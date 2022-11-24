package tripboat.tripboat1.Mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
    @GetMapping("/mypage")
    public String mypage () {
        return "Mypage";
    }
}
