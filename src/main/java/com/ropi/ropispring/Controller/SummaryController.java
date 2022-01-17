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
		List<Summary> list = summaryService.listSummary();
		model.addAttribute(list);
		mv.setViewName("/summary/main");
		mv.addObject("list",summaryService.listSummary());
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
}
