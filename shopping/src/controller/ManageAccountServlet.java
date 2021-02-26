package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/account_management")
public class ManageAccountServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		// �A�J�E���g�Ǘ���ʂ֑J�ڂ���
		req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);

	}


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
