package com.ocr.beans;

public class User {

    private String name;
    private String firstname;
    
    public String getName() {
        return name;
    }
    public void setName(String name) throws BeanException {
    	if (name.length() > 10)
    		throw new BeanException(name + " is too large !");
    	else
    		this.name = name;
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}