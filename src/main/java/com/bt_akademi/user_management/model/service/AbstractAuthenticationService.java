package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.model.entity.User;
import com.bt_akademi.user_management.security.jwt.JWTProvidable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

// ****10 -> AuthenticationService
public abstract class AbstractAuthenticationService
{
    @Autowired
    protected JWTProvidable providable;

    @Autowired
    protected AuthenticationManager authenticationManager;

    /*
        JSON Web Token üreten metot
        JSON Web Token (JWT) -> oturum (session) yerine geçecek
     */
    public abstract String generateJWT(User signInUser);
}
