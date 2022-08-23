package com.test.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(description = "Menu create request")
public class MenuCreateRequest {
    @NotNull
    private String name;
    private LocalDateTime menufacDate;
    private int amount;

    @ApiModelProperty(position = 1, example = "Choco Cake", value = "Menu's products")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ApiModelProperty(position = 2, example = "2022-08-23T18:23:28.917487", value = "Manufaturing Date")
    public LocalDateTime getMenufacDate() {
        return menufacDate;
    }

    public void setMenufacDate(LocalDateTime menufacDate) {
        this.menufacDate = menufacDate;
    }

    @ApiModelProperty(position = 3, example = "1", value = "pieces")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
