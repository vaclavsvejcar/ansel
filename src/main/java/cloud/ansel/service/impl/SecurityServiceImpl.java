package cloud.ansel.service.impl;

import cloud.ansel.model.User;
import cloud.ansel.service.SecurityService;
import cloud.ansel.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    public SecurityServiceImpl(AuthenticationManager authenticationManager,
                               UserDetailsService userDetailsService,
                               UserService userService) {

        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    public void login(String username, String password) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final Authentication token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            logger.debug(String.format("User %s successfully logged in!", username));
        }
    }

    @Override
    public Optional<User> loggedInUser() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth instanceof UsernamePasswordAuthenticationToken token
               ? userService.findByEmail(token.getName())
               : Optional.empty();
    }
}
