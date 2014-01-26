/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sunat.entity;

/**
 *
 * @author javier olivares
 */

public class Debt {
    private Integer id;
    private Concept concept;
    private Person person;
    private String period;
    private String taxcode;
    private String resolutionNumber;
    private Double amount;

    public Debt() {
    }

    public Debt(Integer id, Concept concept, Person person, String period, String taxcode, String resolutionNumber, Double amount) {
        this.id = id;
        this.concept = concept;
        this.person = person;
        this.period = period;
        this.taxcode = taxcode;
        this.resolutionNumber = resolutionNumber;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    public String getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(String resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
