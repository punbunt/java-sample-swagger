package com.test.model.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu")
public class MenuDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MENUFAC_DATE_TIME")
    private LocalDateTime menufacDateTime;

    @Column(name = "EXPIRE_DATE_TIME")
    private LocalDateTime expireDateTime ;

    @Column(name = "SIZE")
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getMenufacDateTime() {
        return menufacDateTime;
    }

    public void setMenufacDateTime(LocalDateTime menufacDateTime) {
        this.menufacDateTime = menufacDateTime;
    }

    public LocalDateTime getExpireDateTime() {
        return expireDateTime;
    }

    public void setExpireDateTime(LocalDateTime expireDateTime) {
        this.expireDateTime = expireDateTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
