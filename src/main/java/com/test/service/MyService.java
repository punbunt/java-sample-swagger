package com.test.service;

import com.test.model.MenuInquiryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {


    public List<MenuInquiryResponse> getMenuList() {
//construct response
        List<MenuInquiryResponse> mylist = new ArrayList<>();

        MenuInquiryResponse menu1 = new MenuInquiryResponse();
        menu1.setId(1);
        menu1.setName("Choc Cake");
        menu1.setMenufacDate(LocalDateTime.now());
        menu1.setExpiryDate(LocalDateTime.now().plusDays(7));
        menu1.setSize(1);

        MenuInquiryResponse menu2 = new MenuInquiryResponse();
        menu2.setId(2);
        menu2.setName("Choc Cookies");
        menu2.setMenufacDate(LocalDateTime.now());
        menu2.setExpiryDate(LocalDateTime.now().plusDays(7));
        menu2.setSize(1);

        //add menu into list
        mylist.add(menu1);
        mylist.add(menu2);

        return mylist;
    }
}
