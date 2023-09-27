package ee.koodi.helmes.sector;

import ee.koodi.helmes.user.api.SectorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SectorService {

    private static final int SPACING_MULTIPLIER = 4;

    private final SectorRepository sectorRepository;


    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<SectorDto> getSectorsList() {
        var sectors = sectorRepository.findAll();

        var topLevelSectors = sectors.stream()
            .sorted(Comparator.comparing(Sector::getName))
            .filter(it -> it.getParentId() == null)
            .toList();

        var resultList = new ArrayList<SectorDto>();

        topLevelSectors.forEach(it -> {
            resultList.add(toDto(it, 0));
            buildResultForTopLevelSector(it.getId(), sectors, resultList, 1);
        });

        return resultList;
    }

    private void buildResultForTopLevelSector(Long topLevelSectorId, List<Sector> fullSectorList, List<SectorDto> resultList, int spacing) {
        fullSectorList.stream()
            .filter(it -> topLevelSectorId.equals(it.getParentId()))
            .sorted(Comparator.comparing(Sector::getName))
            .forEach(it -> {
                resultList.add(toDto(it, spacing));
                buildResultForTopLevelSector(it.getId(), fullSectorList, resultList, spacing + 1);
            });
    }


    private SectorDto toDto(Sector sector, int spacing) {
        var dto = new SectorDto();
        dto.setId(sector.getId());
        dto.setName(sector.getName());
        dto.setSpacing(spacing * SPACING_MULTIPLIER);
        return dto;
    }

}
