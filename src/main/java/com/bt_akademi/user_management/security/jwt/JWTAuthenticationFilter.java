package com.bt_akademi.user_management.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter
{
    @Autowired
    private JWTProvidable providable;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        // kimligi dogrulanmis kullanici
        Authentication authentication = providable.getAuthentication(request);

        /*  gecerli mi degil mi ? -> expiration date
            SecurityContext, thread bazli olusturulan bir Container
            veya thread bazli olusturulan bir oturum nesnesi gibi dusunebiliriz.
         */
        if(authentication != null && providable.isValidToken(request))
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
