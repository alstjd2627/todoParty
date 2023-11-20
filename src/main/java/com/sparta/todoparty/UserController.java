package com.sparta.todoparty;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody UserRequestDto userRequestDto){
        try {
            userService.signup(userRequestDto);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new CommonResponseDto("중복된 username입니다.",HttpStatus.CREATED.value()));
        }

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new CommonResponseDto("회원가입 성공",HttpStatus.CREATED.value()));
    }
}
