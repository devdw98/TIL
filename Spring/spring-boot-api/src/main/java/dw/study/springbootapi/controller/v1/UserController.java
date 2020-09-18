package dw.study.springbootapi.controller.v1;

import dw.study.springbootapi.entity.User;
import dw.study.springbootapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor //final로 선언된 객체에 대해 Constructor Injection 수행
@RestController
@RequestMapping(value = "/v1")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/user")
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User save(){
        User user = User.builder().uid("test@dwtest.com").name("test1").build();
        return userRepository.save(user);
    }
}
