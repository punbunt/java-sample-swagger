package com.test.service;

import com.test.model.*;
import com.test.model.Entity.MenuDataEntity;
import com.test.repository.MenuDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyService {



    @Autowired
    private MenuDataRepository menuDataRepository;

    //other service
    //get menu by name

    public void deleteMenu(MenuDeleteRequest request) throws Exception {
        //find record by ID then delete
        Optional <MenuDataEntity> recordOpt = menuDataRepository.findById(request.getId());
        if (recordOpt.isPresent()) {
            MenuDataEntity record = recordOpt.get();
            menuDataRepository.delete(record);
        }
    }

    public MenuCreateResponse postMenu(MenuCreateRequest request) {

        //set default value to request body fields
        if ( request.getMenufacDate() == null ) {
            request.setMenufacDate(LocalDateTime.now());
        }

        //map request into entity
        MenuDataEntity record = new MenuDataEntity();
        record.setName(request.getName());
        record.setMenufacDateTime(request.getMenufacDate());
        record.setSize(request.getAmount());
        record.setExpireDateTime(request.getMenufacDate().plusDays(7));

        //save into DB
        menuDataRepository.save(record);

        //construct response
        MenuCreateResponse response = new MenuCreateResponse();
        response.setId(record.getId());
        response.setName(record.getName());
        response.setMenufacDate(record.getMenufacDateTime());
        response.setExpiryDate(record.getExpireDateTime());
        response.setAmount(record.getSize());

        return response;

    }
    public List<MenuInquiryResponse> getMenuList(String name) {

        //case find by name
        if (name != null) {
            List<MenuDataEntity> myEntitylist = menuDataRepository.findByName(name);
            List<MenuInquiryResponse> mylist = new ArrayList<>();
            for (MenuDataEntity menu : myEntitylist) {
                //Map into response
                MenuInquiryResponse response = mapMenuToEntities(menu);
                mylist.add(response);
            }
            return mylist;
        }

        //get list
        Iterable<MenuDataEntity> menuIterator = menuDataRepository.findAll();

        //Map list into response
        List<MenuInquiryResponse> mylist = new ArrayList<>();
        for (MenuDataEntity menu : menuIterator) {
            MenuInquiryResponse response = mapMenuToEntities(menu);
            mylist.add(response);
        }

        return mylist;

        //construct response
        /*List<MenuInquiryResponse> mylist = new ArrayList<>();

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

        return mylist;*/

    }

    public MenuInquiryResponse mapMenuToEntities (MenuDataEntity record) {
        MenuInquiryResponse response = new MenuInquiryResponse();
        response.setId(record.getId());
        response.setName(record.getName());
        response.setMenufacDate(record.getMenufacDateTime());
        response.setExpiryDate(record.getExpireDateTime());
        response.setAmount(record.getSize());
        return response;
    }
}
