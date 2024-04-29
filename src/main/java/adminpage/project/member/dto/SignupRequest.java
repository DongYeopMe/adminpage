package adminpage.project.member.dto;

import adminpage.project.member.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupRequest {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String address;

    public Member signuprequestconvertToUser(SignupRequest signupRequest){
        Member member = Member.builder().name(name)
                .email(email)
                .password(password)
                .address(address)
                .name(name)
                .build();
        return member;
    }
}
