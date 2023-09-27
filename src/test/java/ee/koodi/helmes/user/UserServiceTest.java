package ee.koodi.helmes.user;

import ee.koodi.helmes.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static ee.koodi.helmes.TestUtils.THREE;
import static ee.koodi.helmes.TestUtils.userDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void findUserBySessionIdOrCreateNew_IfFoundReturnsExistingUser() {
        when(userRepository.findUserBySessionId(TestUtils.ONE))
            .thenReturn(Optional.of(TestUtils.user(TestUtils.TWO, null, null, false)));

        var result = userService.findUserBySessionIdOrCreateNew(TestUtils.ONE);

        verify(userRepository, never()).save(ArgumentMatchers.any(User.class));
        assertThat(result.getName()).isEqualTo(TestUtils.TWO);
    }

    @Test
    public void findUserBySessionIdOrCreateNew_IfNotFoundReturnsNewUser() {
        when(userRepository.findUserBySessionId(TestUtils.ONE))
            .thenReturn(Optional.empty());
        when(userRepository.save(any(User.class)))
            .thenReturn(TestUtils.user(TestUtils.EIGHT, null, TestUtils.ONE, false));

        var result = userService.findUserBySessionIdOrCreateNew(TestUtils.ONE);

        verify(userRepository, times(1)).save(any(User.class));
        assertThat(result.getName()).isEqualTo(TestUtils.EIGHT);
        assertThat(result.isConsent()).isEqualTo(false);
        assertThat(result.getSessionId()).isEqualTo(TestUtils.ONE);
    }

    @Test
    public void updateUserAndReturnId_savesChangesAndReturnsId() {
        when(userRepository.findUserBySessionId(TestUtils.ONE))
            .thenReturn(Optional.of(TestUtils.user(TestUtils.TWO, 42L, null, false)));

        var result = userService.updateUserAndReturnId(TestUtils.ONE, userDto(THREE, false, Collections.emptyList()));

        assertThat(result).isEqualTo(42L);
        verify(userRepository, times(1)).save(any(User.class));

    }


}
