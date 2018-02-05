package com.demo.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@RestController
@Api(name = "Tests", description = "Tests API")
public class CodixTestController {

	private static final Logger logger = LoggerFactory.getLogger(CodixTestController.class);
	
    @RequestMapping("/codixtest")
    @ApiMethod(description = "Test codixtest")
    public String codixTest(@RequestParam(value="name", required=false, defaultValue="Codix Test Controller") String name, Model model) {
    	
    	logger.info("Going to codixTest...");
    	
        model.addAttribute("name", name);
        return "codixtest";
    }

}
