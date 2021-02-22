package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/account_management")
public class ManageAccountServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// �{�^���������̒l���擾����
		String buttonType = req.getParameter("buttonType");
		
		// �A�J�E���g�ύX�{�^���������A�A�J�E���g�ύX��ʂ֑J�ڂ���
		if("account_change".equals(buttonType)) {

			req.setAttribute("url","account_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}	
		
		// �p�X���[�h�ύX�{�^���������A�A�J�E���g�ύX��ʂ֑J�ڂ���
		if("password_change".equals(buttonType)) {
			req.setAttribute("url","password_change");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// �p�X���[�h�ύX�{�^���������A�A�J�E���g�ύX��ʂ֑J�ڂ���
		if("account_delete".equals(buttonType)) {
			req.setAttribute("url","account_delete");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}	
	}
	
	
}
