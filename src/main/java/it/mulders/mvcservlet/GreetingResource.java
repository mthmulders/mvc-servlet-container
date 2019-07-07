package it.mulders.mvcservlet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Path("/greeting/")
@RequestScoped
public class GreetingResource {
    private static final Logger log = Logger.getLogger(GreetingResource.class.getName());

    @Inject
    UserInfoService userInfoService;

    @Inject
    Models models;

    @Inject
    MvcContext context;

    @GET
    @View("hello.jsp")
    public void hello(@QueryParam("name") final String name) {
        log.log(Level.INFO, "Greeting URI: {0}", context.uri("GreetingResource#hello"));
        models.put("name", name == null ? "world" : name);
        models.put("remoteIp", userInfoService.getRemoteIp());
    }
}
