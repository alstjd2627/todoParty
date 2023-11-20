package com.sparta.todoparty;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    //private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public void signup(UserRequestDto userRequestDto){
        String username = userRequestDto.getUsername();
//        String password = passwordEncoder.encode(userRequestDto.getPassword());
        String password = userRequestDto.getPassword();

        if(userRepository.findByUsername(username).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }

        User user = new User(username,password);
        userRepository.save(user);

    }
}
