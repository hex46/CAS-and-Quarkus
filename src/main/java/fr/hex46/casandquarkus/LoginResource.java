/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.hex46.casandquarkus;

import fr.hex46.casandquarkus.exception.LoginException;
import fr.hex46.casandquarkus.form.LoginForm;
import fr.hex46.casandquarkus.service.LoginService;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;


@Path("/login")
public class LoginResource {
    
    @Inject
    Template login;
    
    @Inject
    LoginService loginService;
    
    private static final Logger LOGGER = Logger.getLogger(LoginResource.class.getName());
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance loginForm(@QueryParam("service") String service) {
        return login.data("service", service);
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public void login(@MultipartForm LoginForm loginForm) {
        try {
            Boolean result = loginService.login(loginForm);
            if (result) {
                // Connection OK
            } else {
                // Connection KO
            }
        } catch (LoginException ex) {
            LOGGER.log(Level.SEVERE, "Connection error!", ex);
        }
    }
}
