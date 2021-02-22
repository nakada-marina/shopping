package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import service.AccountService;
import service.ProductService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/product_search")
public class SearchProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		// �{�^���������̒l���擾����
		String buttonType = req.getParameter("buttonType");
		
		// Service�̌Ăяo��
		ProductService productService = new ProductService();
		
		ProductDao dao = new ProductDao();
		
		// �ҏW�{�^��������
		if("product_info".equals(buttonType)) {
			req.setAttribute("url","product_info");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}

		// �����{�^��������
		if("product_search".equals(buttonType)) {
			
			// �������[�h���擾����
			String searchWord = req.getParameter("product_search");
			

			
			// �������[�h���󔒂̏ꍇ�A�S���\�����s��
			if(searchWord.isEmpty()) {
				req.setAttribute("url","product_search");
				req.setAttribute("resultFlg","1");
				
				//�L���̏ꍇ �Z�b�V������񃊃X�g��ǉ�
				HttpSession session = req.getSession(true);
				session.setAttribute("account", productService.showProduct());
				
				req.setAttribute("productList",productService.showProduct());
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}else {
				
				//�L���̏ꍇ �Z�b�V������񃊃X�g��ǉ�
				HttpSession session = req.getSession(true);
				session.setAttribute("account", productService.searchProduct(searchWord));
				
				// �������[�h�w�肪�������ꍇ�A���̃��[�h�Ō������s���B
				req.setAttribute("url","product_search");
				req.setAttribute("resultFlg","1");
				req.setAttribute("productList",productService.searchProduct(searchWord));
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
		}
		
		// ���ʃe�[�u����\�����Ȃ�
		req.setAttribute("resultFlg","0");
		// �e��ʂ֑J�ڂ���
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	
		}
}
