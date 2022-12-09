package com.codegym.demo.model.contract;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.facility.Facility;
import javax.persistence.Entity;
import javax.persistence.*;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateStart;
    private String dateEnd;
    private Double deposit;
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;

    public Contract() {
    }

    public Contract(Long id, String dateStart, String dateEnd, Double deposit,Double totalMoney, Customer customer, Facility facility) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
