package com.example.springwebannoted;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserObject implements Serializable {

    @EmbeddedId
    private UserCredential credential;

    private String acontactNo;

    @AttributeOverrides({@AttributeOverride(name = "street",column = @Column(name = "user_street")),@AttributeOverride(name = "city",column = @Column(name = "user_city")),@AttributeOverride(name = "state",column = @Column(name = "user_state")),@AttributeOverride(name = "country",column = @Column(name = "user_country")),@AttributeOverride(name = "zip",column = @Column(name = "user_zip"))})
    private Address address;

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public String getContactNo() {
        return acontactNo;
    }

    public void setContactNo(String contactNo) {
        this.acontactNo = contactNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
