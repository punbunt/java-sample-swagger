package com.test.model;

import io.swagger.annotations.ApiModelProperty;

public class MenuDeleteRequest {
    private int id;

    @ApiModelProperty(position = 1, example = "1", value = "1")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
