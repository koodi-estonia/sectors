package ee.koodi.helmes.sector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static ee.koodi.helmes.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectorServiceTest {

    @Mock
    private SectorRepository sectorRepository;

    @InjectMocks
    private SectorService sectorService;

    @Test
    public void returnsCorrectlyAssembledList() {
        when(sectorRepository.findAll()).thenReturn(testSectors());

        var result = sectorService.getSectorsList();

        assertThat(result).hasSize(9);
        assertThat(result).containsExactly(
            sectorDto(8L, EIGHT, 0),
            sectorDto(4L, FOUR, 0),
            sectorDto(5L, FIVE, 4),
            sectorDto(6L, SIX, 8),
            sectorDto(7L, SEVEN, 12),
            sectorDto(9L, NINE, 0),
            sectorDto(1L, ONE, 0),
            sectorDto(2L, TWO, 4),
            sectorDto(3L, THREE, 8));
    }

}
