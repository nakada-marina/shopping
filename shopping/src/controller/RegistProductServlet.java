package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import service.AccountService;
import service.ProductService;

	/**�A�J�E���g�̐V�K�o�^���s���T�[�u���b�g�N���X�B
	 * @author education
	 *
	 */
	@WebServlet("/product_regist")
	public class RegistProductServlet extends HttpServlet {
		
		/** �ۑ���t�@�C����**/
		private final String FILE_NAME = ".\\\\images\\\\";

		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// �p�����^�̎擾
			ProductBean product = new ProductBean();
			product.setName(req.getParameter("product_name"));
			product.setInfo(req.getParameter("info"));
			product.setPrice(Integer.valueOf(req.getParameter("price")));
			product.setUrl(FILE_NAME + req.getParameter("image"));

			
			// Service�̌Ăяo��
			ProductService productService = new ProductService();
			
			// DB�ɓo�^����
			productService.insertProduct(product);
			
			// ���i�ڍ׉�ʂ֑J�ڂ���
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
