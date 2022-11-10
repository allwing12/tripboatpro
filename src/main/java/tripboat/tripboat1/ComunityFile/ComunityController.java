package tripboat.tripboat1.ComunityFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Getter
@Setter
public class ComunityController {
    private final ComunityService comunityService;


    @RequestMapping("/comunity")

    private String list(Model model) {
        List<Comunity> comunityList = this.comunityService.getList();
        model.addAttribute("comunityList",comunityList);
        return "Comunity_main";
    }

    @RequestMapping("login_errors")
    private String login_err () {
        return "login_errors";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/writer")
    public String WriterForm (ComunityForm comunityForm){
        return "Writer";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/writer")
    public String WriterDate (@Valid ComunityForm comunityForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Writer";
        }
        this.comunityService.create(comunityForm.getSubject(),comunityForm.getContent(),comunityForm.getRegion()); {
            return "redirect:/comunity"; // 질문 저장후 질문목록으로 이동
        }
    }
    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Comunity comunity = this.comunityService.getComunity(id);
        model.addAttribute("comunity", comunity);
        return "Comunity_content";
    }
//    public String WriterDate(Comunity comunity, Model model, MultipartFile file) {
//        ComunityService.create(comunity,file);
//        model.addAttribute("message" , "글 작성이 완료 되었습니다.");
//        model.addAttribute("searchUrl" , "")
//    }
}