package com.test.controller;

import com.test.model.MenuInquiryResponse;
import com.test.service.MyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableSwagger2
@Api(tags="Bakery Information", description = "This service is a bakery information provider.")
public class HelloController {

    @Autowired
    private MyService myService;


    @ApiOperation(value = "inquire menu", nickname = "search menu", notes = "remark")
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/menu/inquiry", produces = "application/json")
    public List<MenuInquiryResponse> getMenuList(@RequestParam(required = false) String name) {
        return myService.getMenuList(name);
    }
}