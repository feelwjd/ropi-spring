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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@PostMapping("/add")
	public ModelAndView addPostSummary(Summary summary){
		summaryService.setSummary(summary);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping(value = "/updateSummary/{db}/{no}/{sectorcode}")
	public ModelAndView updateSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("sectorcode")String sectorcode, Summary summary){
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
		logger.info(db);
		if (db.equals(temp1)){
			mv.addObject("list",summaryService.getSummary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else if (db.equals(temp2)){
			mv.addObject("list",summaryService.getRopi6Summary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else if (db.equals(temp3)){
			mv.addObject("list",summaryService.getRopi7Summary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/updateSummary");
		}
		else{
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}

	@PostMapping("/update")
	public ModelAndView updatePostSummary(Summary summary){
		summaryService.updateSummary(summary);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping("/deleteSummary/{db}/{no}/{sectorcode}")
	public ModelAndView deleteSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("sectorcode")String sectorcode,Summary summary){
		ModelAndView mv = new ModelAndView();
		Summary deletesum = new Summary();
		try	{
			deletesum = summaryService.getSummary(no,sectorcode);
			summaryService.deleteSummary(deletesum);
		}catch (Exception e){}
		try	{
			deletesum = summaryService.getRopi6Summary(no,sectorcode);
			summaryService.deleteSummary(deletesum);
		}catch (Exception e){}
		try	{
			deletesum = summaryService.getRopi7Summary(no,sectorcode);
			summaryService.deleteSummary(deletesum);
		}catch (Exception e){}
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping(value = "/detail/{db}/{no}/{sectorcode}")
	public ModelAndView detailSummary(@PathVariable("no")String no,@PathVariable("db")String db,@PathVariable("sectorcode")String sectorcode, Summary summary){
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
		logger.info(temp1);
		logger.info(temp2);
		logger.info(temp3);
		logger.info(db);
        if (db.equals(temp1)){
			mv.addObject("list",summaryService.getSummary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else if (db.equals(temp2)){
			mv.addObject("list",summaryService.getRopi6Summary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else if (db.equals(temp3)){
			mv.addObject("list",summaryService.getRopi7Summary(no, sectorcode));
			mv.addObject("db",db);
			mv.setViewName("/summary/detailSummary");
		}
		else{
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}
}
