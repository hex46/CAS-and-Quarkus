/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.hex46.casandquarkus.service;

import fr.hex46.casandquarkus.form.LoginForm;
import fr.hex46.casandquarkus.config.LoginProperties;
import fr.hex46.casandquarkus.exception.LoginException;
import io.agroal.api.AgroalDataSource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginService {
    
    @Inject
    AgroalDataSource defaultDataSource;
    
    @Inject
    LoginProperties loginProperties;  
    
    public Boolean login(String email, String password) throws LoginException {
        try {
            MessageDigest md = MessageDigest.getInstance(loginProperties.encodingAlgorithm);
            byte[] bytesPassword = password.getBytes(loginProperties.characterEncoding);
            byte[] encodedPassword = md.digest(bytesPassword);
            
            String request = loginProperties.getRequest()
                    .replace("?1", email)
                    .replace("?2", this.bytesToHex(encodedPassword));
            
            ResultSet result = defaultDataSource.getConnection()
                    .createStatement()
                    .executeQuery(request);
            
            return result.next();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | SQLException ex) {
            throw new LoginException(ex);
        }
    }
    
    // Src : https://mkyong.com/java/java-sha-hashing-example/
    public String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public Boolean login(LoginForm loginForm) throws LoginException {
        return this.login(loginForm.getEmail(), loginForm.getPassword());
    }
}
