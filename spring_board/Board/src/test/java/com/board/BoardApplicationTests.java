package com.board;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BoardApplication.class)
@WebAppConfiguration
public class BoardApplicationTests {
	
	@Autowired 
	private SqlSessionFactory sqlSession;
	@Autowired
	private DataSource ds;
	@Autowired
	private BoardMapper mapper;
	
	/*
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testConnection() throws Exception{
		System.out.println("ds : "+ds);
		
		Connection con = ds.getConnection();
		
		System.out.println("con : "+con);
		
		con.close();
	}
	
	@Test
	public void testSqlSession() throws Exception{
		System.out.println("sqlSession : "+sqlSession);
	}
	*/
	
	@Test
	public void testMapper() throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setSubject("제목입니다.");
		vo.setContent("내용입니다.");
		vo.setWriter("작성자입니다.");
		
		mapper.boardInsert(vo);
	}

}
