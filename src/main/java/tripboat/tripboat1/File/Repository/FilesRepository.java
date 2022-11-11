package tripboat.tripboat1.File.fileRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import tripboat.tripboat1.File.Domain.Files;

import java.util.Optional;

public interface FilesRepository extends JpaRepository<Files, Long> {
    Optional<Files> findById (Long id);
}
