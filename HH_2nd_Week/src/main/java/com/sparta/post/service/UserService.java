package com.sparta.post.service;

import com.sparta.post.dto.ResponseDto;
import com.sparta.post.dto.UserDto;
import com.sparta.post.entity.User;
import com.sparta.post.jwt.JwtUtil;
import com.sparta.post.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtutil;

    @Transactional
    public ResponseDto signup(UserDto UserDto) {
        String username = UserDto.getUsername();
        String password = UserDto.getPassword();

        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        User user = new User(username, password);
        userRepository.save(user);

        return new ResponseDto("success", "회원가입 성공");
    }

    @Transactional(readOnly = true)
    public ResponseDto login(UserDto userDto, HttpServletResponse response) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        if(!user.getPassword().equals(password)){
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtutil.createToken(userDto.getUsername()));

        return new ResponseDto("success", "로그인 성공");
    }

}