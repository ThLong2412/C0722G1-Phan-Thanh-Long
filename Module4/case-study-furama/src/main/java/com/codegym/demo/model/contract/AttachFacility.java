package com.codegym.demo.model.contract;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    private String init;

    public AttachFacility() {
    }

    public AttachFacility(Long id, String name, Double cost, String init) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.init = init;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }
}
