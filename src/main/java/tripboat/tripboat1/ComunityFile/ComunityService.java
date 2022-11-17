package tripboat.tripboat1.ComunityFile;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tripboat.tripboat1.Util.DataNotFoundException;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ComunityService {

    private final ComunityRepository comunityRepository;

    public List<Comunity> getList() {
        return this.comunityRepository.findAll();
    }

    public void create(String subject, String content, String region){
        Comunity comunity = new Comunity();
        comunity.setSubject(subject);
        comunity.setContent(content);
        comunity.setRegion(region);
        comunity.setCreateDate(LocalDateTime.now());
        this.comunityRepository.save(comunity);
    }
    public Comunity getComunity(Integer id) {
        Optional<Comunity> comunity = this.comunityRepository.findById(id);
        if (comunity.isPresent()) {
            return comunity.get();
        } else {
            throw new DataNotFoundException("comunity not found");
        }
    }
}