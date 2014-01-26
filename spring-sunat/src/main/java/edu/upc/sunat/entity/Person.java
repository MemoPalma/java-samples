/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.entity;

import java.io.Serializable;

/**
 *
 * @author javier olivares
 */
public class Person implements Serializable{
    
    private Integer id;
    private String name;
    private String ruc;
    private String phone;
    private Integer type;

    public Person() {
    }

    public Person(Integer id, String name, String ruc, String phone, Integer type) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
        this.phone = phone;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getRuc();
    }

}
