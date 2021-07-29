package kh.spring.main;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kh.spring.dao.BoardDAO;
import kh.spring.dao.FileDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.FileDTO;
import kh.spring.service.BoardService;
import kh.spring.vo.PagingVO;



@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	
	@Autowired
	private FileDAO pdao;
	
	//@Autowired
	//private PagingVO vo;
	
	//@Autowired
	//private HttpSession session;

	//modifyProc
	@RequestMapping("modifyProc")
	public String modify(BoardDTO dto) throws Exception {
		
		bService.modify(dto);
		return "home";
		
	}
	
	//modifyForm View
	@RequestMapping(value="modifyForm" , method=RequestMethod.GET)
	public String modifyForm(Model model, int board_seq) throws Exception {
	
		BoardDTO dto = bService.modifyView(board_seq);
		model.addAttribute("list",dto);
		return "board/writeModify";
		
	}
	
	//delete
	@RequestMapping("delete")
	public String delete(int board_seq) throws Exception {

		bService.delete(board_seq);
		return "home";
		
	}
	
	//writeView
	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	//writeProc
	@RequestMapping("writeProc")
	public String writeProc(String title, String contents) throws Exception{
		
		bService.insert(title,contents);
		return "redirect:/";
		
	}
	
	//list
	@RequestMapping("list")
	public String list(PagingVO vo, Model model, String nowPage, String cntPerPage) throws Exception {
			
			int total = bService.CountBoard();
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "5";
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "5";
			}
			vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			model.addAttribute("paging", vo);
			model.addAttribute("viewAll", bService.SelectBoard(vo));
		return "board/boardlist";
	}

	//listDetail View
	@RequestMapping(value="detail" ,method=RequestMethod.GET)
	public String detail(Model model,int board_seq) throws Exception{
		BoardDTO dto = bService.detail(board_seq);
		model.addAttribute("list",dto);
		return "board/detail";
	}

	@ExceptionHandler // error
	public String execeptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}