package com.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(description = "Menu inquiry response")
public class MenuInquiryResponse {
    private int id;
    private String name;
    private LocalDateTime menufacDate;
    private LocalDateTime expiryDate;
    private int size;

    @ApiModelProperty(position = 1, example = "1", value = "Menu's unique ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ApiModelProperty(position = 2, example = "Choco Cake", value = "Menu's products")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(position = 3, example = "2022-08-23T18:23:28.917487", value = "Manufaturing Date")
    public LocalDateTime getMenufacDate() {
        return menufacDate;
    }

    public void setMenufacDate(LocalDateTime menufacDate) {
        this.menufacDate = menufacDate;
    }

    @ApiModelProperty(position = 4, example = "2022-08-30T18:23:28.917517", value = "Expired Date")
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
    @ApiModelProperty(position = 5, example = "1", value = "pieces")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
