package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.dtos.UserDto;
import nl.novi.beeindopdracht.entities.Role;
import nl.novi.beeindopdracht.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.getUser(username);

        String password = user.getPassword();

        Set<Role> roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }

}
