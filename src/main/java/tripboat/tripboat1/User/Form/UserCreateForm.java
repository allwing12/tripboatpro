package tripboat.tripboat1.User.Form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {

    @NotEmpty(message = "아이디가 입력되지 않았습니다.")
    private String username;

    @NotEmpty(message = "비밀번호가 입력되지 않았습니다.")
    private String password1;
    @NotEmpty(message = "2차 비밀번호가 입력되지 않았습니다.")
    private String password2;

    @NotEmpty(message = "이메일이 입력되지 않았습니다.")
    @Email
    private String email;

    @NotEmpty(message = "닉네임이 입력되지 않았습니다.")
    private String nickname;
}
