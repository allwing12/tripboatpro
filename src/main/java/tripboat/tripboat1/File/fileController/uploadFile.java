package tripboat.tripboat1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class uploadFile {
    @GetMapping("/upload")
    public String upload () {
      return "img_test";
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestPart MultipartFile file) throws IOException {
        filesServices.uploadFile(file);
        return "redirect:/";
    }

}
