package com.test.controller;

import com.test.model.*;
import com.test.service.MyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "create menu", nickname = "create menu", notes = "remark")
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/menu/create", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public MenuCreateResponse postMenu(@RequestBody(required = false) MenuCreateRequest request) {
        return myService.postMenu(request);
    }

    @ApiOperation(value = "delete menu", nickname = "delete menu", notes = "remark")
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/menu/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postMenu(@RequestBody(required = false) MenuDeleteRequest request) throws Exception {
        myService.deleteMenu(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}