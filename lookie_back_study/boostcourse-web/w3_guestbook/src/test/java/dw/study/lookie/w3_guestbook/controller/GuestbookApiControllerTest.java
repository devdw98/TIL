package dw.study.lookie.w3_guestbook.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dw.study.lookie.w3_guestbook.config.ApplicationConfig;
import dw.study.lookie.w3_guestbook.config.WebMvcContextConfiguration;
import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.service.GuestbookService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration(classes= {
		WebMvcContextConfiguration.class,
		ApplicationConfig.class
})
public class GuestbookApiControllerTest {
	
	@InjectMocks
	public GuestbookApiController gac; 
	//가짜객체 gb를 사용함 (mockito 프레임워크에 의해 생성된 목객체가 주입되어 객체 생성)
	
	@Mock
	GuestbookService gs; 
	//mockito를 위해 목객체로 생성 ( 가짜 객체 )
	
	private MockMvc mockMvc;
	
	@Before //Test 메소드 실행 전에 해당 메소드 실행
	public void createController() {
		MockitoAnnotations.initMocks(this); //@Mock이 붙은 필드를 목객체로 초기화
		mockMvc=MockMvcBuilders.standaloneSetup(gac).build();
		//gac를 테스트하기 위한 MockMvc 객체 생성
	}
	
	@Test
	public void getGuestbooks() throws Exception{
		Guestbook gb = new Guestbook();
		gb.setId(1L);
		gb.setRegdate(new Date(0));
		gb.setContent("hello");
		gb.setName("dw_mock_test");
		
		List<Guestbook> list = Arrays.asList(gb);
		
		when(gs.getGuestbooks(0)).thenReturn(list);
		//when(목객체.목객체메소드호출()).thenReturn(목객체 메소드가 리턴할 값)
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/guestbooks").contentType(MediaType.APPLICATION_JSON);
		//MockMvcRequestBuilders를 이용해 MockMvc에게 호출할 URL 생성 /guestbooks  GET 방식으로 호출하라는 의미
		mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
		//reqBuilder에 해당하는URL에 대한 요청을 보내고 상태코드 값이 200 이 나와야 한다는 것을 의미 -> 처리내용 출력
		((GuestbookService) verify(gb)).getGuestbooks(0); //호출 되었다면 검증 성공!
	
	}
	
	@Test
	public void deleteGuestbook() throws Exception{
		Long id = 1L;
		when(gs.deleteGuestbook(id, "127.0.0.1")).thenReturn(1);
		RequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/guestbooks/"+id).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(gs).deleteGuestbook(id, "127.0.0.1");
	}

}
