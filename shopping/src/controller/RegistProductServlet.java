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

	/**アカウントの新規登録を行うサーブレットクラス。
	 * @author education
	 *
	 */
	@WebServlet("/product_regist")
	public class RegistProductServlet extends HttpServlet {
		
		/** 保存先ファイル名**/
		private final String FILE_NAME = ".\\\\images\\\\";

		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// パラメタの取得
			ProductBean product = new ProductBean();
			product.setName(req.getParameter("product_name"));
			product.setInfo(req.getParameter("info"));
			product.setPrice(Integer.valueOf(req.getParameter("price")));
			product.setUrl(FILE_NAME + req.getParameter("image"));

			
			// Serviceの呼び出し
			ProductService productService = new ProductService();
			
			// DBに登録する
			productService.insertProduct(product);
			
			// 商品詳細画面へ遷移する
			req.setAttribute("url","account_management");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
