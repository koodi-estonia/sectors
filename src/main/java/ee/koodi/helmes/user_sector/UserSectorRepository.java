package ee.koodi.helmes.user_sector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSectorRepository extends JpaRepository<UserSector, Long> {

    List<UserSector> findAllByUserId(Long userId);

}
