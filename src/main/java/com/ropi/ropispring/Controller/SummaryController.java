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

	@GetMapping(value="/summary")
	public ModelAndView createSummaryForm() {
		ModelAndView mv = new ModelAndView("/summary/summaryForm");
		return mv;
	}

	@GetMapping(value = "/")
	public ModelAndView viewSummary( ModelAndView mv, Model model) {
		try {
			List<Summary> list = summaryService.listSummary();
			model.addAttribute(list);
			mv.setViewName("/summary/main");
			mv.addObject("list",summaryService.listSummary());
		}catch (Exception e){
			mv.setViewName("/summary/page404");
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
		}catch (Exception e){
			mv.setViewName("/summary/page404");
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
		}catch (Exception e){
			mv.setViewName("/summary/page404");
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

	@GetMapping(value = "/summary/{no}")
	public ModelAndView updateSummary(@PathVariable("no")String no, Summary summary){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/summary/updateSummary");
		mv.addObject("list",summaryService.getSummary(no));
		return mv;
	}

	@PostMapping("/update")
	public ModelAndView updatePostSummary(Summary summary){
		summaryService.updateSummary(summary);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping("/deleteSummary/{no}")
	public ModelAndView deleteSummary(@PathVariable("no")String no,Summary summary){
		ModelAndView mv = new ModelAndView();
		Summary deletesum = new Summary();
		deletesum = summaryService.getSummary(no);
		summaryService.deleteSummary(deletesum);
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping(value = "/detail/{no}")
	public ModelAndView detailSummary(@PathVariable("no")String no, Summary summary){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/summary/detailSummary");
		mv.addObject("list",summaryService.getSummary(no));
		return mv;
	}
}
