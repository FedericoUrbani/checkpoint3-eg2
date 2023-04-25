package com.develhope.checkpoint3eg2.demo.entites;

import jakarta.persistence.*;

@Entity
@Table
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    public Newsletter(){

    }
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
}
