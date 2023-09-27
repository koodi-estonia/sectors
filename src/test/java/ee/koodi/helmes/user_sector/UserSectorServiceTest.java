package ee.koodi.helmes.user_sector;

import ee.koodi.helmes.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserSectorServiceTest {

    @Mock
    private UserSectorRepository userSectorRepository;

    @InjectMocks
    private UserSectorService userSectorService;

    @Test
    public void deletesAllExistingSelectionsForUserAndSavesNewSelection() {
        var existingSectors = List.of(
            TestUtils.userSector(1L, 1L, 1L),
            TestUtils.userSector(1L, 1L, 2L)
        );
        var newSectors = List.of(
            TestUtils.userSector(null, 1L, 1L),
            TestUtils.userSector(null, 1L, 2L),
            TestUtils.userSector(null, 1L, 3L)
        );
        when(userSectorRepository.findAllByUserId(1L))
            .thenReturn(existingSectors);


        userSectorService.updateUserSelectedSectors(1L, List.of(1L, 2L, 3L));


        verify(userSectorRepository, times(1)).deleteAll(existingSectors);
        verify(userSectorRepository, times(1))
            .saveAll(newSectors);

    }


}
