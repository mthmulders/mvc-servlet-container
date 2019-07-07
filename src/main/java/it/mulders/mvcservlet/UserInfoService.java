package it.mulders.mvcservlet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class UserInfoService {
    @Inject
    HttpServletRequest request;

    public String getRemoteIp() {
        return request.getRemoteAddr();
    }
}
