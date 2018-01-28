package com.demo.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;

import hello.Application;

@Component
@RestController
@RequestMapping(value="/rest/student")
class StudentService{

   @RequestMapping(value="/",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return Application.hmStudent;
   }
}