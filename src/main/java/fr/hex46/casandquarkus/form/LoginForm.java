/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.hex46.casandquarkus.form;

import javax.ws.rs.FormParam;

public class LoginForm {
    
    private @FormParam("email") String email;
    private @FormParam("password") String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "LoginForm{" + "username=" + email + ", password=" + password + '}';
    }
}
