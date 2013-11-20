/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.vinos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@XmlRootElement
public class Vino implements Serializable{
    
    private int id;
    private String name;
    private String grapes;
    private String country;
    private String region;
    private String year;
    private String picture;
    private String description;

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

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vino{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vino other = (Vino) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
