/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.hex46.casandquarkus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("login")
public class LoginProperties {
    
    private static final String REQUEST 
            = "SELECT loginField from tableName WHERE loginField = '?1' AND passwordField = '?2';";
    
    public String tableName;
    public String loginField;
    public String passwordField;
    
    public String characterEncoding;
    public String encodingAlgorithm;
    
    public String getRequest() {
        return REQUEST.replaceAll("loginField", loginField)
                .replaceAll("tableName", tableName)
                .replaceAll("passwordField", passwordField);
    }
}
