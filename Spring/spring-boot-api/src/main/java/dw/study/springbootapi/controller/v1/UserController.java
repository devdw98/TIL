package dw.study.springbootapi.controller.v1;

import dw.study.springbootapi.advice.exception.CUserNotFoundException;
import dw.study.springbootapi.entity.User;
import dw.study.springbootapi.model.response.CommonResult;
import dw.study.springbootapi.model.response.ListResult;
import dw.study.springbootapi.model.response.SingleResult;
import dw.study.springbootapi.repository.UserRepository;
import dw.study.springbootapi.service.ResponseService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"2. User"}) //최상단 타이틀 영역에 표시될 값 세팅
@RequiredArgsConstructor //final로 선언된 객체에 대해 Constructor Injection 수행
@RestController
@RequestMapping(value = "/v1")
public class UserController {
    private final UserRepository userRepository;
    private final ResponseService responseService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 리스트 조회", notes="모든 회원 조회") // 제목과 설명
    @GetMapping("/users")
    public ListResult<User> findAllUser(){
        return responseService.getListResult(userRepository.findAll());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다")
    @GetMapping("/user/{id}")
    public SingleResult<User> findUserById(@ApiParam(value="회원번호", required = true) @RequestParam long id,
                                           @ApiParam(value="언어", defaultValue = "ko") @RequestParam String lang)
    throws Exception{
//        return responseService.getSingleResult(userRepository.findById(id).orElse(null));
//        return responseService.getSingleResult(userRepository.findById(id).orElseThrow(Exception::new));
        return responseService.getSingleResult(userRepository.findById(id).orElseThrow(CUserNotFoundException::new));
    }

    @ApiOperation(value = "회원 입력", notes = "회원 입력한다")
    @PostMapping("/user")
    public SingleResult<User> save(@ApiParam(value="회원아이디", required = true) @RequestParam String uid, //파라미터에 대한 설명
                                   @ApiParam(value="회원이름",required = true) @RequestParam String name){
        User user = User.builder().uid(uid).name(name).build();
        return responseService.getSingleResult(userRepository.save(user));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 수정", notes = "회원 정보를 수정한다")
    @PutMapping("/user")
    public SingleResult<User> modify(@ApiParam(value="회원번호", required = true) @RequestParam long id,
                                     @ApiParam(value="회원아이디", required = true) @RequestParam String uid,
                                     @ApiParam(value="회원이름",required = true) @RequestParam String name){
        User user = User.builder().id(id).uid(uid).name(name).build();
        return responseService.getSingleResult(userRepository.save(user));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 삭제", notes = "회원 정보를 삭제한다")
    @DeleteMapping("/user/{id}")
    public CommonResult delete(@ApiParam(value="회원번호", required = true) @PathVariable long id){
        userRepository.deleteById(id);
        return responseService.getSuccessResult();
    }
}
