package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.FileDTO;


@Repository
public class FileDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private HttpSession session;
	
	public int insert(FileDTO dto) throws Exception{
		String sql = "insert into files values(?,?,sysdate,?)";
		return jdbc.update(sql, dto.getOriName(), dto.getSysName(), dto.getParent());}

}
