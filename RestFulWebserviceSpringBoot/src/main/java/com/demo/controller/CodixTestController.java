package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@Controller
public class CodixTestController {

    @RequestMapping("/codixtest")
    public String lienMinh69Test(@RequestParam(value="name", required=false, defaultValue="Codix Test Controller") String name, Model model) {
        model.addAttribute("name", name);
        return "codixtest";
    }

}
