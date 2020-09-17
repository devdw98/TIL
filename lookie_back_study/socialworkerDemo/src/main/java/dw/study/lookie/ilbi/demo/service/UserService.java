package dw.study.lookie.ilbi.demo.service;

import dw.study.lookie.ilbi.demo.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public boolean register(User user); //회원가입
    public boolean checkUsername(String username); //중복 아이디 검사
    public boolean checkNickname(String nickname); //중복 닉네임 검사
    public boolean updatePassword(Long id, String oldPassword, String newPassword); //비밀번호 수정
    public User update(User user); //회원 정보 수정
    public boolean delete(Long id); //회원 정보 삭제
    public String findUsername(String name, String email); //아이디찾기
    public boolean findPassword(String name, String username); //비밀번호 찾기

    public String checkLogin(String username, String password);

}
