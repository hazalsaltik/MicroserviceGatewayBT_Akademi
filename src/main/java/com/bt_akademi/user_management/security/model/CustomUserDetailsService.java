package com.bt_akademi.user_management.security.model;

import com.bt_akademi.user_management.model.entity.User;
import com.bt_akademi.user_management.model.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// ****4 -> UserDetails implementasyonu (UserPrinciple) tanımlanacak.
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private AbstractUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // "Bu kullanıcı adındaki kullanıcı yoksa" durumu, orElseThrow() metodu ile yönetildi.
        User user = userService.findByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException("User with " + username + " is not found."));

        return new UserPrincipal(user.getUserID(), user.getUsername(), user.getPassword());
    }
}
