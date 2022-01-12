package com.ropi.ropispring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RopiController {
    @RequestMapping("/home")
    public List home(){
        return null;
    }
}
