package com.ropi.ropispring.Controller;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Service.SummaryService;
import com.ropi.ropispring.Service.SummaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.ropi.ropispring.Model.Summary;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class SummaryController {
	private static final Logger logger = LoggerFactory.getLogger(SummaryController.class);

	@Autowired
	private SummaryService summaryService;

	@GetMapping(value = "/")
	public ModelAndView viewSummary( ModelAndView mv, Model model) {
		try {
			List<Summary> list = summaryService.listSummary();
			model.addAttribute(list);
			mv.setViewName("/summary/main");
			mv.addObject("list",summaryService.listSummary());
			mv.addObject("db",summaryService.dbCheck());
		}catch (Exception e){
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}
	@GetMapping(value = "/ropi6")
	public ModelAndView viewRopi6( ModelAndView mv, Model model) {
		try {
			List<Summary> list = summaryService.listRopi6Summary();
			model.addAttribute(list);
			mv.setViewName("/summary/main");
			mv.addObject("list",summaryService.listRopi6Summary());
			mv.addObject("db",summaryService.dbRopi6Check());
		}catch (Exception e){
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}
	@GetMapping(value = "/ropi7")
	public ModelAndView viewRopi7( ModelAndView mv, Model model) {
		try {
			List<Summary> list = summaryService.listRopi7Summary();
			model.addAttribute(list);
			mv.setViewName("/summary/main");
			mv.addObject("list",summaryService.listRopi7Summary());
			mv.addObject("db",summaryService.dbRopi7Check());
		}catch (Exception e){
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}

	@GetMapping(value = "/test")
	public List<Summary> test(){
		return summaryService.listSummary();
	}

	@GetMapping(value = "/addSummary")
	public ModelAndView addSummary(ModelAndView mv, Model model){
		Summary summary = new Summary();
		mv.addObject("list",summary);
		mv.setViewName("/summary/addSummary");
		return mv;
	}

	@PostMapping("/add/{db}")
	public ModelAndView addPostSummary(Summary summary,@PathVariable("db")String db){
		ModelAndView mv = new ModelAndView();
		String[] selectDB = db.toString().split(",");
		logger.info(summary.toString());

		for (int i =0;i<selectDB.length; i++){
			switch (selectDB[i]){
				case "1":
					logger.info("server 1 attach");
					try	{
						summaryService.setSummary(summary);
					}catch (Exception e){}
					break;

				case "2":
					logger.info("server 2 attach");
					try	{
						summaryService.setRopi6Summary(summary);
					}catch (Exception e){}
					break;

				case "3":
					logger.info("server 3 attach");
					try	{
						summaryService.setRopi7Summary(summary);
					}catch (Exception e){}
					break;
			}
		}
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping(value = "/updateSummary/{db}/{no}/{countrycode}")
	public ModelAndView updateSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("countrycode")String countrycode, Summary summary){
		ModelAndView mv = new ModelAndView();
		String temp1,temp2,temp3;
		try	{
			temp1 = summaryService.dbCheck();
		}catch (Exception e){
			temp1 = "error";
		}
		try	{
			temp2 = summaryService.dbRopi6Check();
		}catch (Exception e){
			temp2 = "error";
		}
		try	{
			temp3 = summaryService.dbRopi7Check();
		}catch (Exception e){
			temp3 = "error";
		}
		if (db.equals(temp1)){
			mv.addObject("list",summaryService.getSummary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else if (db.equals(temp2)){
			mv.addObject("list",summaryService.getRopi6Summary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else if (db.equals(temp3)){
			mv.addObject("list",summaryService.getRopi7Summary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else{
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}

	@PostMapping("/update/{db}")
	public ModelAndView updatePostSummary(Summary summary,@PathVariable("db")String db){
		switch (db){
			case "ropi":
				logger.info("server 1 update");
				try	{
					summaryService.updateSummary(summary);
				}catch (Exception e){}
				break;

			case "second_ropi":
				logger.info("server 2 update");
				try	{
					summaryService.updateRopi6Summary(summary);
				}catch (Exception e){}
				break;

			case "third_ropi":
				logger.info("server 3 update");
				try	{
					summaryService.updateRopi7Summary(summary);
				}catch (Exception e){}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping("/deleteSummary/{db}/{no}/{countrycode}")
	public ModelAndView deleteSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("countrycode")String countrycode,Summary summary){
		ModelAndView mv = new ModelAndView();
		Summary deletesum = new Summary();
		logger.info(db);
		switch (db){
			case "ropi":
				try	{
					deletesum = summaryService.getSummary(no, countrycode);
					summaryService.deleteSummary(deletesum);
				}catch (Exception e){}
				break;

			case "second_ropi":
				try	{
					deletesum = summaryService.getRopi6Summary(no, countrycode);
					summaryService.deleteRopi6Summary(deletesum);
				}catch (Exception e){}
				break;

			case "third_ropi":
				try	{
					deletesum = summaryService.getRopi7Summary(no, countrycode);
					summaryService.deleteRopi7Summary(deletesum);
				}catch (Exception e){}
		}
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping(value = "/detail/{db}/{no}/{countrycode}")
	public ModelAndView detailSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("countrycode")String countrycode, Summary summary){
		ModelAndView mv = new ModelAndView();
		String temp1,temp2,temp3;
		try	{
			temp1 = summaryService.dbCheck();
		}catch (Exception e){
			temp1 = "error";
		}
		try	{
			temp2 = summaryService.dbRopi6Check();
		}catch (Exception e){
			temp2 = "error";
		}
		try	{
			temp3 = summaryService.dbRopi7Check();
		}catch (Exception e){
			temp3 = "error";
		}
        if (db.equals(temp1)){
			mv.addObject("list",summaryService.getSummary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else if (db.equals(temp2)){
			mv.addObject("list",summaryService.getRopi6Summary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else if (db.equals(temp3)){
			mv.addObject("list",summaryService.getRopi7Summary(no, countrycode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else{
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}

	@GetMapping(value = "/delete/{select}/{countrycode}")
	public ModelAndView selectDelete(@PathVariable("select")String select, @PathVariable("countrycode")String ctc, ModelAndView mv){
		String[] arrSymbol = select.toString().split(",");
		String[] arrCountrycode = ctc.toString().split(",");
		Summary summary = new Summary();
		logger.info(arrSymbol[1]);
		logger.info(arrCountrycode[1]);
		try	{
			for (int i =0;i<arrSymbol.length; i++){
				String symbol = arrSymbol[i];
				String countrycode = arrCountrycode[i];
				summary = summaryService.getSummary(symbol, countrycode);
				summaryService.deleteSummary(summary);
				mv.setViewName("redirect:/");
			}
		}catch (Exception e){}
		return mv;
	}
}
