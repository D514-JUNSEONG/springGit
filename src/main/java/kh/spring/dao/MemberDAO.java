package kh.spring.dao;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(MemberDTO dto) {
		return mybatis.insert("Member.insert", dto);
	}
	
	public int idDuplCheck(MemberDTO dto) {
		return mybatis.selectOne("Member.idDuplCheck",dto);
	}
	
	public int login(MemberDTO dto) {
		return mybatis.selectOne("Member.login",dto);
	
	}

	public int memberOut(String id) {
		return mybatis.delete("Member.delete", id);
	}
}
