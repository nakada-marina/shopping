package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import service.AccountService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/dologin")
public class DoLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// Service�̌Ăяo��
		AccountService accountService = new AccountService();
		
		// ���O�C����񂩂�@�A�J�E���g�����擾����
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.checkLoginInfo(req);
		
		// �A�J�E���g���L���ł���ꍇ
		if(!(accountBean == null)) {
	
			//�L���̏ꍇ �Z�b�V�������ɁA�A�J�E���g�����Z�b�g����i�V�K�j
			HttpSession session = req.getSession(true);
			session.setAttribute("account", accountBean);
			req.setAttribute("url","account_management");
	
		}else {
			
			// �A�J�E���g�������̏ꍇ
			req.setAttribute("url","login");
			req.setAttribute("errorFlg","1");
		}
	
		// �e��ʂ֑J�ڂ���
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	
		}
}
