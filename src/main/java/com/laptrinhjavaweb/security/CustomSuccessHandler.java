package com.laptrinhjavaweb.security;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    public String determineTargetUrl(Authentication authentication) {
            return SystemConstant.ADMIN_HOME;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    private boolean isManager(List<String> roles) {
        if (roles.contains(SystemConstant.MANAGER_ROLE)) {
            return true;
        }
        return false;
    }

    private boolean isStaff(List<String> roles) {
        if (roles.contains(SystemConstant.STAFF_ROLE)) {
            return true;
        }
        return false;
    }
}
