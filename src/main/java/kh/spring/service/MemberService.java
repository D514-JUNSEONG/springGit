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
	
	public int idDuplCheck(MemberDTO dto) {
		return dao.idDuplCheck(dto);
	}
	
	public int login(MemberDTO dto) {
		return dao.login(dto);
	}
	
	public int memberOut(String id) {
		return dao.memberOut(id);
	}
}
