package ee.koodi.helmes;

import ee.koodi.helmes.sector.Sector;
import ee.koodi.helmes.user.User;
import ee.koodi.helmes.user.api.SectorDto;
import ee.koodi.helmes.user.api.UserDto;
import ee.koodi.helmes.user_sector.UserSector;

import java.util.List;

public class TestUtils {

    public static final String ONE = "ONE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String FOUR = "FOUR";
    public static final String FIVE = "FIVE";
    public static final String SIX = "SIX";
    public static final String SEVEN = "SEVEN";
    public static final String EIGHT = "EIGHT";
    public static final String NINE = "NINE";


    public static UserSector userSector(Long id, Long userId, Long sectorId) {
        var sector = new UserSector();
        sector.setId(id);
        sector.setUserId(userId);
        sector.setSectorId(sectorId);
        return sector;
    }

    public static Sector sector(String name, Long parentId, Long id) {
        var sector = new Sector();
        sector.setId(id);
        sector.setName(name);
        sector.setParentId(parentId);
        return sector;
    }

    public static SectorDto sectorDto(Long id, String name, int spacing) {
        var dto = new SectorDto();

        dto.setId(id);
        dto.setName(name);
        dto.setSpacing(spacing);

        return dto;
    }

    public static User user(String name, Long id, String sessionId, boolean consent) {
        var user = new User();
        user.setName(name);
        user.setId(id);
        user.setSessionId(sessionId);
        user.setConsent(consent);
        return user;
    }

    public static UserDto userDto(String name, boolean consent, List<Long> selectedSectorIds) {
        var user = new UserDto();
        user.setName(name);
        user.setConsent(consent);
        user.setSelectedSectorsIds(selectedSectorIds);
        return user;
    }

    public static List<Sector> testSectors() {
        return List.of(
            /*
                1
                - 2
                -- 3
                4
                - 5
                -- 6
                --- 7
                8
                9
             */
            sector(ONE, null, 1L),
            sector(TWO, 1L, 2L),
            sector(THREE, 2L, 3L),
            sector(FOUR, null, 4L),
            sector(FIVE, 4L, 5L),
            sector(SIX, 5L, 6L),
            sector(SEVEN, 6L, 7L),
            sector(EIGHT, null, 8L),
            sector(NINE, null, 9L)
        );
    }

    public static List<SectorDto> formattedSectorDtoList() {
        return List.of(
            sectorDto(8L, EIGHT, 0),
            sectorDto(4L, FOUR, 0),
            sectorDto(5L, FIVE, 4),
            sectorDto(6L, SIX, 8),
            sectorDto(7L, SEVEN, 12),
            sectorDto(9L, NINE, 0),
            sectorDto(1L, ONE, 0),
            sectorDto(2L, TWO, 4),
            sectorDto(3L, THREE, 8)
        );
    }
}
