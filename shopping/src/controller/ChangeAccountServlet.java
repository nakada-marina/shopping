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
@WebServlet("/account_change")
public class ChangeAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// �ύX�O�̃A�J�E���g�����Z�b�V��������擾����
		HttpSession session = req.getSession(true);
		AccountBean preAccountBean = new AccountBean();
		preAccountBean = (AccountBean)session.getAttribute("account");
		
		// Service�̌Ăяo��
		AccountService accountService = new AccountService();
		
		// ���͓��e����������΁ADB��ύX����
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.checkChangeInfo(req, preAccountBean);
		
		// �����̏ꍇ
		if(!(accountBean == null)){
			
			// �L���̏ꍇ�A�Z�b�V�������ɃA�J�E���g�����Z�b�g����i�X�V)
			session = req.getSession(false);
			session.setAttribute("account", accountBean);
			
			// �A�J�E���g�Ǘ���ʂ֑J�ڂ���
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			// TODO �A�J�E���g�������ł���ꍇ�A�Ƃɂ����G���[����ʂɕ\������B
			req.setAttribute("url","account_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
