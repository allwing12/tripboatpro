package tripboat.tripboat1.User.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tripboat.tripboat1.User.Form.UserCreateForm;
import tripboat.tripboat1.User.Services.UserServices;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("")
public class UserController {
    private final UserServices userServices;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
            userServices.create(userCreateForm.getUsername(),
                    userCreateForm.getEmail(),
                    userCreateForm.getPassword1(),
                    userCreateForm.getNickname());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 아이디 입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "errors";
    }


    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @ResponseBody
    @RequestMapping("/Logout")
    public String Logout(HttpSession session) {
        session.invalidate();
        String str = "<script>";
        str+="alert('로그아웃이 완료 되었습니다.');";
        str+="window.location.href = '/main';";
        str+="</script>";
        return str;
    }
    @ResponseBody
    @RequestMapping("/Sign")
    public String Sign(HttpSession session) {
        session.invalidate();
        String str = "<script>";
        str+="alert('회원가입이 완료 되었습니다.');";
        str+="window.location.href = '/login';";
        str+="</script>";
        return str;
    }
}