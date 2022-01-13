package com.ropi.ropispring.Controller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SummaryController {
	@GetMapping(value="/summary")
	public ModelAndView createSummaryForm() {
		ModelAndView mv = new ModelAndView("/summary/summaryForm");
		return mv;
	}
}
