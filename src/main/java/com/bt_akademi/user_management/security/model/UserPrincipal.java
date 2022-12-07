package com.bt_akademi.user_management.security.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

// ****5 -> buradan, SecurityConfig'e
@NoArgsConstructor
@AllArgsConstructor
public class UserPrincipal implements UserDetails
{
    private Integer id;
    private String username;

    // password, Serilestirilmis (serialized) yerlerde gorulmesin diye
    private transient String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        // USER varsayilan rol listesi tanimlandi
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
