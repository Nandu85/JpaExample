package com.example.springwebannoted;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserCredential implements Serializable {


    private String username;
    private String email;

    public UserCredential(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserCredential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
