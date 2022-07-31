package com.test.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/javaswagger")
    public String sayHello() {
        return "Swagger Hello World";
    }
}