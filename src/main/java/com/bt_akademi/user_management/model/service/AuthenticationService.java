package com.bt_akademi.user_management.model.service;

import com.bt_akademi.user_management.model.entity.User;
import com.bt_akademi.user_management.security.model.UserPrincipal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

// ****11 -> AuthenticationController'a
@Service
public class AuthenticationService extends AbstractAuthenticationService
{
    @Override
    public String generateJWT(User signInUser)
    {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(signInUser.getUsername(), signInUser.getPassword()); // ****d

        Authentication authentication = authenticationManager.authenticate(token); // ****c

        // kimliği doğrulanmış kullanıcı çekilir.
        // Bunun için Authentication tipinde nesne gerekir.
        UserPrincipal userPrinciple = (UserPrincipal)authentication.getPrincipal();// ****b

        // kimliği doğrulanmış kullanıcıyı kullanarak token üretilme kısmı
        return providable.generateToken(userPrinciple); // ****a
    }
}
