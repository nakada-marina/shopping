package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import dao.ProductDao;
import service.ProductService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	/**
	 *POST���N�G�X�g�̏������s���܂��B
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// �{�^���������̒l���擾����
		String buttonType = req.getParameter("buttonType");
		ProductService proService = new ProductService();
		
		// �A�J�E���g�V�K�o�^�{�^���������A�A�J�E���g�V�K�o�^��ʂ֑J�ڂ���
		if("account_regist".equals(buttonType)) {
			req.setAttribute("url","account_regist");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// �߂�{�^���������A�A�J�E���g�Ǘ���ʂ֑J�ڂ���
		if("account_management".equals(buttonType)) {
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// ���i�����{�^��������
		if("product_search".equals(buttonType)) {
			req.setAttribute("url","product_search");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// ���i�o�^�{�^��������
		if("product_regist".equals(buttonType)) {
			// �C���[�W�I��p�̃��X�g�{�b�N�X�B
			req.setAttribute("productList",proService.showImage());
			req.setAttribute("url","product_regist");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		// �y��L�ȊO�z �O��̃Z�b�V���������폜����
		HttpSession session = req.getSession(true);
		session.removeAttribute("account");
		
		// ���O�C����ʂ֑J�ڂ���
		req.setAttribute("url","logout");
		resp.sendRedirect("./index.jsp");
		
		}
}
