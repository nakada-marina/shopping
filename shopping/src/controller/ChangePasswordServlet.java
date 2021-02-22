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
@WebServlet("/password_change")
public class ChangePasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// �ύX�O�̃A�J�E���g�����Z�b�V��������擾����
		HttpSession session = req.getSession(true);
		AccountBean sessionAccount = new AccountBean();
		sessionAccount = (AccountBean)session.getAttribute("account");
		
		// �ύX�O�̃A�J�E���g���p�����^����擾����
		String rePassword = req.getParameter("rePassword");
		
		// �ύX��̃A�J�E���g���p����������擾����
		String newPassword = req.getParameter("newPassword");
		
		// Service�̌Ăяo��
		AccountService accountService = new AccountService();
		AccountBean accountBean = new AccountBean();
		accountBean = accountService.changePassword(sessionAccount, newPassword, rePassword);
		
		// �ύX�����ł����ꍇ
		if(!(accountBean == null)) {
			
			// Email���Z�b�V������񂩂�擾���AEmail,�p�X���[�h�ȊO�̏����擾����
			accountBean.setE_mail(sessionAccount.getE_mail());
			// �ύX��̃p�X���[�h���Z�b�V�����ɃZ�b�g����
			session.setAttribute("account", accountService.showAccountInfo(accountBean));
			
			// �A�J�E���g�Ǘ���ʂ֑J�ڂ���
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			// ��ʑJ�ڂ��Ȃ�
			req.setAttribute("url","password_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);

		}
		
		}
}
