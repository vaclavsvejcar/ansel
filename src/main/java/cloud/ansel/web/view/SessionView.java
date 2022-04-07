package cloud.ansel.web.view;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import cloud.ansel.service.SecurityService;
import cloud.ansel.web.mapper.UserMapper;
import cloud.ansel.web.dto.UserDTO;
import jakarta.annotation.PostConstruct;

@Component("sessionV")
@SessionScope
public class SessionView {

    private final SecurityService securityService;
    private final UserMapper userMapper;

    private UserDTO user;

    public SessionView(SecurityService securityService,
                       UserMapper userMapper) {

        this.securityService = securityService;
        this.userMapper = userMapper;
    }

    @PostConstruct
    private void postConstruct() {
        loadLoggedInUser();
    }

    public void loadLoggedInUser() {
        this.user = securityService.loggedInUser()
            .map(userMapper::to)
            .orElse(null);
    }

    public UserDTO getUser() {
        return user;
    }
}
