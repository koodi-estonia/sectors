package ee.koodi.helmes.user_sector;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSectorService {

    private final UserSectorRepository userSectorRepository;

    public UserSectorService(UserSectorRepository userSectorRepository) {
        this.userSectorRepository = userSectorRepository;
    }


    public List<Long> getUsersSelectedSectors(Long userId) {
        return userSectorRepository.findAllByUserId(userId)
            .stream()
            .map(UserSector::getSectorId)
            .collect(Collectors.toList());
    }

    public void updateUserSelectedSectors(Long userId, List<Long> selectedSectors) {
        userSectorRepository.deleteAll(userSectorRepository.findAllByUserId(userId));
        userSectorRepository.saveAll(selectedSectors.stream().map(it -> {
            var userSector = new UserSector();
            userSector.setSectorId(it);
            userSector.setUserId(userId);
            return userSector;
        }).collect(Collectors.toList()));
    }
}
