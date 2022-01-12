package com.ropi.ropispring.Controller;

import com.ropi.ropispring.Service.SummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ViewController {
    private Logger logger = LoggerFactory.getLogger(ViewController.class);

    @RequestMapping("/")
    public String indexpage(ModelAndView mav, Model model, HttpSession session){

        return "/";
    }
}
