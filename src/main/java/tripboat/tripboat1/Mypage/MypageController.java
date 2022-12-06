package tripboat.tripboat1.Mypage;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tripboat.tripboat1.User.Services.UserServices;


@Controller
public class MypageController {
    private final UserServices userServices;
    private final PasswordEncoder passwordEncoder;
    public MypageController(UserServices userServices, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.passwordEncoder = passwordEncoder;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage () {
        return "Mypage";
    }
    @GetMapping("/test")
    public String image () {
        return "test_form";
    }
}
