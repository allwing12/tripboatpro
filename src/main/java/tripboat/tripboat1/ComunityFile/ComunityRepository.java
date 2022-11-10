package tripboat.tripboat1.ComunityFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import tripboat.tripboat1.User.Domain.SiteUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

public interface ComunityRepository extends JpaRepository<Comunity, Integer> {
    Optional<Comunity> findById(String subject);

}