package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	
	public int idDuplCheck(String id) {
		return dao.idDuplCheck(id);
	}
	
	public int login(String id, String pw) {
		return dao.login(id, pw);
	}
	
	public int memberOut(String id) {
		return dao.memberOut(id);
	}

}
