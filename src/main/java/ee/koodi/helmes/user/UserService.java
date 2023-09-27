package ee.koodi.helmes.user;


import ee.koodi.helmes.user.api.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;


    public User findUserBySessionIdOrCreateNew(String sessionId) {
        return findUserBySessionId(sessionId)
            .orElseGet(() -> createNewUser(sessionId));
    }

    private Optional<User> findUserBySessionId(String sessionId) {
        return userRepository.findUserBySessionId(sessionId);
    }

    private User createNewUser(String sessionId) {
        var user = new User();
        user.setSessionId(sessionId);
        user.setConsent(false);
        user.setName("");
        return userRepository.save(user);
    }

    public Long updateUserAndReturnId(String sessionId, UserDto userDto) {
        var user = findUserBySessionId(sessionId).orElseThrow();
        user.setName(userDto.getName());
        user.setConsent(userDto.isConsent());
        user.setSessionId(sessionId);
        userRepository.save(user);
        return user.getId();
    }

}
