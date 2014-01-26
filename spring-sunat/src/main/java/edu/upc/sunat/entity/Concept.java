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
public class Concept implements Serializable {
    
    private Integer id;
    private String name;

    public Concept() {
    }

    public Concept(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}
