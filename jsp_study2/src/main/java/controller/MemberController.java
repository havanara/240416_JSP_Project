package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //멤버변수 작성구간
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOK;
	private MemberService msv; //service -> interface
	public MemberController() {
		msv = new MemberServiceImpl(); 
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세팅 구간
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(path);
		
		switch(path) {
		case "join" :
			destPage = "/member/join.jsp";
			break;
			
		case "register" :
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				String phone = request.getParameter("phone");
				
				MemberVO mvo = new MemberVO(id, pwd, email, age, phone);
				log.info("join >>> {}", mvo);
				int isOK = msv.register(mvo);
				
				if(isOK>0) {
					request.setAttribute("msg_register", "성공");
					HttpSession ses = request.getSession();
					ses.invalidate();
					destPage = "/index.jsp";
				}else {
					request.setAttribute("msg_register", "실패");					
					destPage = "/index.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "login" : 
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				MemberVO mvo = new MemberVO(id, pwd);
				log.info("login >>> {}", mvo);

				MemberVO loginMvo = msv.getLogin(mvo);
				log.info("return loginMvo >>> {}", loginMvo);
				
				if(loginMvo != null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
				}else {
					request.setAttribute("msg_login", -1);
				}
				destPage = "/index.jsp"; 
			} catch (Exception e) {
				e.printStackTrace();
			}	
			break;
			
		case "logout" :
			try {
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				ses.invalidate(); //세션끊기
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "list" : 
			try {
				List<MemberVO> list = msv.getList();
				log.info("list >>> {}", list);
				request.setAttribute("list", list);
				destPage = "/member/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "modify" : 
			try {
				String id = request.getParameter("id");
				MemberVO mvo = msv.getModify(id);
				log.info("modify >>> {}", mvo);
				request.setAttribute("mvo", mvo);
				destPage = "/member/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "update" : 
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				String phone = request.getParameter("phone");
				
				MemberVO mvo = new MemberVO(id, pwd, email, age, phone);
				int isOK = msv.update(mvo);
				log.info("update >>> {}", (isOK>0)? " 성공 ":" 실패 ");
				
				if(isOK>0) {
					request.setAttribute("msg_update", "성공");
					HttpSession ses = request.getSession();
					ses.invalidate();
					destPage = "/index.jsp";
				}else {
					request.setAttribute("msg_update", "실패");					
					destPage = "/member/modify.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "delete" : 
			try {
				//로그인 된 세션 호출
				HttpSession ses = request.getSession();
				String id = ((MemberVO) ses.getAttribute("ses")).getId();
				int isOK = msv.delete(id);
				log.info("delete >>> {}", (isOK>0)? " 성공 ":" 실패 ");
				if(isOK>0) {
					request.setAttribute("msg_delete", "성공");
					ses.invalidate(); //세션 끊기
				}
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;			
			
		default :
			break;
		}
		
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
