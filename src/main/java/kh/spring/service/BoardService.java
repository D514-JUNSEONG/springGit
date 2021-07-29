package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.vo.PagingVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public int insert(String title, String contents) throws Exception {
		return dao.insert(title, contents);
	}
	
	public List<BoardDTO> sellectAll() throws Exception {
		return dao.List();
	}
	
	public int getSeq() throws Exception {
		return dao.getSeq();
	}
	
	public BoardDTO detail(int board_seq) throws Exception {
		return dao.detail(board_seq);
	}
	
	public BoardDTO modifyView(int board_seq) throws Exception{
		return dao.modifyView(board_seq);
	}
	
	public int delete(int board_seq) {
		return dao.delete(board_seq);
	}
	
	public int modify(BoardDTO dto) {
		return dao.modify(dto);
	}
	
	public List<BoardDTO> SelectBoard(PagingVO vo) throws Exception{
		return dao.SelectBoard(vo);
	}
	
	public int CountBoard() {
		return dao.CountBoard();
	}
	
	public int view_count(int board_seq) {
		return dao.view_count(board_seq);
	}
	
	public String ReXSSFilter(String target) {
		return dao.ReXSSFilter(target);
	}
	
	public String XSSFilter(String target) {
		return dao.XSSFilter(target);
	}
}
