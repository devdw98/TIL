package dw.study.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dw.study.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TimeMapperTest {
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime2() {
		System.out.println(timeMapper.getClass().getName());
		System.out.println(timeMapper.getTime2());
	}
	
	public void testGetTime() {
		System.out.println(timeMapper.getClass().getName());
		System.out.println(timeMapper.getTime());
	}
}
