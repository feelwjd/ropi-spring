package com.ropi.ropispring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RopiController {	

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
    	ModelAndView mv = new ModelAndView("main");
    	System.out.println("home controller start");
        return mv;
    }
}
