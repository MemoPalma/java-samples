/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.entity;

import java.io.Serializable;


/**
 *
 * @author herald olivares
 */
public class User implements Serializable{
        
    private Integer id;
    private String fullname;
    private String username;
    private String salt;
    private String password;
    private String email;
    private Boolean active = true;

    public User() {
        
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.fullname = "TestUser";
        this.username = username;
        this.password = password;
    }
    

    public User(Integer id, String fullname, String username, String salt, String password, String email, Boolean active) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        if(salt == null){
            return this.email + this.fullname;
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
    
    
}
