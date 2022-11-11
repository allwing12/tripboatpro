package tripboat.tripboat1.File.fileServieces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tripboat.tripboat1.File.Domain.Files;
import tripboat.tripboat1.File.Repository.FilesRepository;

import java.io.File;
import java.io.IOException;

@Service
@Transactional(readOnly = true)
public class filesServices {
    @Autowired
    FilesRepository filesRepository;

    @Transactional
    public Files save (Files files) {
        Files f = new Files();
        f.setFilename(files.getFilename());
        f.setFileOriName(files.getFileOriName());
        f.setFileUrl(files.getFileUrl());
        filesRepository.save(f);
        return files;
    }
    public static void uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("yugyeongmin:\\" + file.getOriginalFilename()));
    }
}
