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
@WebServlet("/account_delete")
public class DeleteAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	
		// Service�̌Ăяo��
		AccountService accountService = new AccountService();
		
		// ���݂̃A�J�E���g�����Z�b�V��������擾����
		HttpSession session = req.getSession(true);
		AccountBean account = new AccountBean();
		account = (AccountBean)session.getAttribute("account");
		
		// �A�J�E���g����DB����폜����
		accountService.deleteAccount(account);
		
		// �O��̃Z�b�V���������폜����
		session.removeAttribute("account");
		
		// ���O�C����ʂ֑J�ڂ���
		req.setAttribute("url","logout");
		resp.sendRedirect("./index.jsp");
	}
	
	
}
