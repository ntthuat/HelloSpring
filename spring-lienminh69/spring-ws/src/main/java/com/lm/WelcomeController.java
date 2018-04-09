package com.lm;

import java.util.Map;

import com.lm.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    private DirectoryProperties directory;

    @Autowired
    public void setDirectory(DirectoryProperties directory) {
        this.directory = directory;
    }

    @Autowired
    private DirectoryService directoryService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/test")
    public String test(Map<String, Object> model) {

        model.put("message", directory.getRoot());

        model.put("file", directoryService.testReadFile());
        return "welcome";
    }

}