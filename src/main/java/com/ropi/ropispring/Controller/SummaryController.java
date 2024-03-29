package com.ropi.ropispring.Controller;

import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Service.SummaryService;
import com.ropi.ropispring.Service.SummaryServiceImpl;
import com.ropi.ropispring.util.Pagination;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ropi.ropispring.Model.Industry;
import com.ropi.ropispring.Model.Sector;
import com.ropi.ropispring.Model.Summary;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class SummaryController {
	private static final Logger logger = LoggerFactory.getLogger(SummaryController.class);

	@Autowired
	private SummaryService summaryService;

	@GetMapping(value = "/{database}/list/{page}")
	public ModelAndView getSummaryList(@PathVariable("database")String selectedDB, @PathVariable("page")int curPage, ModelAndView mv) {
		String database = summaryService.dbCheck(selectedDB);
		int listSize = summaryService.getSummaryCount(database);
		
		//페이징 처리
		Pagination pagination = new Pagination(curPage, listSize);
		int pageSize = pagination.getPageSize(); 
		int page = (curPage - 1) * pageSize;
		
		try {
			List<Summary> list = summaryService.listSummary(database, page, pageSize);
			mv.setViewName("summary/main");
			mv.addObject("list",list);
			mv.addObject("database",database);
			mv.addObject("pagination", pagination);

			for (Summary summary : list) {
				System.out.println(summary.toString());
			}
			System.out.println("[controller]list count : " + list.size());


		}catch (Exception e){
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}
	

//	@GetMapping(value = "/test")
//	public List<Summary> test(){
//		return summaryService.listSummary();
//	}

	@GetMapping(value = "/{database}/addSummary")
	public ModelAndView goSummaryForm(@PathVariable("database")String selectedDB, ModelAndView mv, @ModelAttribute("summary")Summary summary){
		String database = summaryService.dbCheck(selectedDB);
		
		List<Sector> sectorList = summaryService.getSectorList(database);
		List<Industry> industryList = summaryService.getIndustryList(database);

		mv.addObject("sectorList", sectorList);
		mv.addObject("industryList", industryList);
		mv.addObject("summary",summary);
		mv.addObject("database", database);
		
		mv.setViewName("summary/formSummary");
		return mv;
	}

	@PostMapping("/{database}/add")
	public ModelAndView addPostSummary(@PathVariable("database")String database, Summary summary, @RequestParam("selectedDB")String selectedDB){
		ModelAndView mv = new ModelAndView("redirect:/{database}/list/1");
		System.out.println(summary.toString());
		
		int result = summaryService.setSummary(selectedDB, summary);
		System.out.println("controller result : " + result);

//		for (int i =0;i<selectDB.length; i++){
//			switch (selectDB[i]){
//				case "1":
//					logger.info("server 1 attach");
//					try	{
//						summaryService.setSummary(summary);
//					}catch (Exception e){}
//					break;
//
//				case "2":
//					logger.info("server 2 attach");
//					try	{
//						summaryService.setRopi6Summary(summary);
//					}catch (Exception e){}
//					break;
//
//				case "3":
//					logger.info("server 3 attach");
//					try	{
//						summaryService.setRopi7Summary(summary);
//					}catch (Exception e){}
//					break;
//			}
//		}
		return mv;
	}

	@GetMapping(value = "{database}/detail/{symbol}/{countrycode}")
	public ModelAndView detailSummary(@PathVariable("database") String database, @PathVariable("symbol") String symbol, @PathVariable("countrycode") String countrycode) {
		ModelAndView mv = new ModelAndView("summary/detailSummary");
		Summary summary = new Summary();
		
		String dbName = summaryService.dbCheck(database);
		if(!(dbName.equals("error"))) {
			summary = summaryService.getSummary(dbName, symbol, countrycode);
			mv.addObject("summary", summary);
			mv.addObject("database", dbName);
		}else {
			mv.setViewName("/summary/errors/500");
			mv.addObject("errortype","409");
		}
		return mv;
	}
	
//	@GetMapping(value = "/updateSummary/{database}/{symbol}/{countrycode}")
//	public ModelAndView updateSummary(@PathVariable("symbol")String symbol, @PathVariable("database")String database,@PathVariable("countrycode")String countrycode, Summary summary){
//		ModelAndView mv = new ModelAndView();
//		String temp1,temp2,temp3;
//		try	{
//			temp1 = summaryService.dbCheck();
//		}catch (Exception e){
//			temp1 = "error";
//		}
//		try	{
//			temp2 = summaryService.dbRopi6Check();
//		}catch (Exception e){
//			temp2 = "error";
//		}
//		try	{
//			temp3 = summaryService.dbRopi7Check();
//		}catch (Exception e){
//			temp3 = "error";
//		}
//		if (database.equals(temp1)){
//			mv.addObject("list",summaryService.getSummary(symbol, countrycode));
//			mv.addObject("db",database);
//			mv.setViewName("/summary/updateSummary");
//		}
//		else if (database.equals(temp2)){
//			mv.addObject("list",summaryService.getRopi6Summary(symbol, countrycode));
//			mv.addObject("db",database);
//			mv.setViewName("/summary/updateSummary");
//		}
//		else if (database.equals(temp3)){
//			mv.addObject("list",summaryService.getRopi7Summary(symbol, countrycode));
//			mv.addObject("db",database);
//			mv.setViewName("/summary/updateSummary");
//		}
//		else{
//			mv.setViewName("/summary/errors/500");
//			mv.addObject("errortype","409");
//		}
//		return mv;
//	}
	@PostMapping(value="/{database}/updateSummary")
	public ModelAndView goSummaryForm(@PathVariable("database")String database, @ModelAttribute Summary summary) {
		ModelAndView mv = new ModelAndView("summary/formSummary");
		summary = summaryService.getSummary(database, summary.getSymbol(), summary.getCountrycode());
		List<Sector> sectorList = summaryService.getSectorList(database);
		List<Industry> industryList = summaryService.getIndustryList(database);

		mv.addObject("sectorList", sectorList);
		mv.addObject("industryList", industryList);
		mv.addObject("summary", summary);
		System.out.println("update form post " + summary.toString());
		
		return mv;
	}
	
	@PostMapping("/update/{db}")
	public ModelAndView updatePostSummary(Summary summary,@PathVariable("db")String db){
		switch (db){
			case "ropi1":
				logger.info("server 1 update");
				try	{
					summaryService.updateSummary(summary);
				}catch (Exception e){}
				break;

			case "ropi6":
				logger.info("server 2 update");
				try	{
					summaryService.updateRopi6Summary(summary);
				}catch (Exception e){}
				break;

			case "ropi7":
				logger.info("server 3 update");
				try	{
					summaryService.updateRopi7Summary(summary);
				}catch (Exception e){}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/{database}/deleteSummary")
	public ModelAndView deleteSummary(@PathVariable("database")String database, @ModelAttribute Summary summary){
		ModelAndView mv = new ModelAndView();
		System.out.println("delete " + database + "/ summary : " + summary.toString());
		
		String dbName = summaryService.dbCheck(database);
		int result = summaryService.deleteSummary(dbName, summary);
		
		if(result == 1) {	//삭제 성공
			mv.setViewName("redirect:/{database}/list/1");
		}else {	//삭제 실패
			mv.setViewName("redirect:/{database}/detail/"+ summary.getSymbol() + "/" + summary.getCountrycode());
		}
		
		System.out.println(mv.getViewName());
		return mv;
	}



//	@GetMapping(value = "/delete/{db}/{select}/{countrycode}")
//	public ModelAndView selectDelete(@PathVariable("db")String db,@PathVariable("select")String select, @PathVariable("countrycode")String ctc, ModelAndView mv){
//		String[] arrSymbol = select.toString().split(",");
//		String[] arrCountrycode = ctc.toString().split(",");
//		Summary summary = new Summary();
//		try	{
//			for (int i =0;i<arrSymbol.length; i++){
//				String symbol = arrSymbol[i];
//				String countrycode = arrCountrycode[i];
//				switch (db){
//					case "ropi1":
//						logger.info("server 1 delete");
//						try {
//							summary = summaryService.getSummary(symbol, countrycode);
//							summaryService.deleteSummary(summary);
//							break;
//						}catch (Exception e){}
//
//					case "ropi6":
//						logger.info("server 2 delete");
//						try {
//							summary = summaryService.getRopi6Summary(symbol, countrycode);
//							summaryService.deleteRopi6Summary(summary);
//							break;
//						}catch (Exception e){}
//
//					case "ropi7":
//						logger.info("server 3 delete");
//						try {
//							summary = summaryService.getRopi7Summary(symbol, countrycode);
//							summaryService.deleteRopi7Summary(summary);
//							break;
//						}catch (Exception e){}
//				}
//			}
//			mv.setViewName("redirect:/");
//		}catch (Exception e){}
//		return mv;
//	}
	
	@PostMapping(value = "/copySummary/{database}")
	public ModelAndView copySummary(@PathVariable("database")String database, @ModelAttribute Summary summary, @RequestParam("selectedDB")String selectedDB) {
		String symbol = summary.getSymbol();
		String countrycode = summary.getCountrycode();
		ModelAndView mv = new ModelAndView("redirect:/{database}/detail/" + symbol +"/"+ countrycode);
		
		summary = summaryService.getSummary(database, symbol, countrycode);
		System.out.println("selected db : " + selectedDB.toString());
//		String databases[] = selectedDB.split(",");
		int result = summaryService.setSummary(selectedDB, summary);
		System.out.println("controller : " + result);
		
		return mv;
	}
}