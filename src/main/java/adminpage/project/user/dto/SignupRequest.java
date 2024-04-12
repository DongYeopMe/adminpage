package adminpage.project.user.dto;

import adminpage.project.user.entity.User;
import jakarta.persistence.Column;
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

    public User signuprequestconvertToUser(SignupRequest signupRequest){
        User user = User.builder().name(name)
                .email(email)
                .password(password)
                .address(address)
                .build();
        return user;
    }
}
