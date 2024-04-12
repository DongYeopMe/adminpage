package adminpage.project.user.service;

import adminpage.project.user.dto.SignupRequest;
import adminpage.project.user.entity.User;
import adminpage.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public void saveUser(SignupRequest signupRequest){
        if(userRepository.findByEmail(signupRequest.getEmail()).isPresent()){
            System.out.println("이미 존재하는 이메일");
        }
        User user=signupRequest.signuprequestconvertToUser(signupRequest);
        userRepository.save(user);
    }


}
