package org.redhat;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CRMAccount")
public class CRMAccount {
	private Integer id;
    private String name;
    private String email;
    private String company;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}
