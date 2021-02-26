package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show_password_change")
public class ShowPasswordChangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		// �߂�{�^���������ꂽ���ǂ����̔�����s��
		String click = req.getParameter("click");

		// �߂�{�^��������
		if ("1".equals(click)) {
			// �A�J�E���g�ύX��ʂ֑J�ڂ���
			req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);
		} else {
			// �߂�{�^���ȊO������
			// �A�J�E���g�Ǘ���ʂ֑J�ڂ���
			req.getRequestDispatcher("./WEB-INF/account/password_change.jsp").forward(req, resp);
		}

	}

}
