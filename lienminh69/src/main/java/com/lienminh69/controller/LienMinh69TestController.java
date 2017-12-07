package com.lienminh69.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Thuat T Nguyen
 * @version 2017/12/07
 *
 */
@Controller
public class LienMinh69TestController {

    @RequestMapping("/lienminh69test")
    public String lienMinh69Test(@RequestParam(value="name", required=false, defaultValue="Lien Minh 69 Test") String name, Model model) {
        model.addAttribute("name", name);
        return "lienminh69test";
    }

}
