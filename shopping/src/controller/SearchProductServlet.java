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
		
		// ボタン押下時の値を取得する
		String buttonType = req.getParameter("buttonType");
		
		// Serviceの呼び出し
		ProductService productService = new ProductService();
		
		ProductDao dao = new ProductDao();
		
		// 編集ボタン押下時
		if("product_info".equals(buttonType)) {
			req.setAttribute("url","product_info");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}

		// 検索ボタン押下時
		if("product_search".equals(buttonType)) {
			
			// 検索ワードを取得する
			String searchWord = req.getParameter("product_search");
			

			
			// 検索ワードが空白の場合、全件表示を行う
			if(searchWord.isEmpty()) {
				req.setAttribute("url","product_search");
				req.setAttribute("resultFlg","1");
				
				//有効の場合 セッション情報リストを追加
				HttpSession session = req.getSession(true);
				session.setAttribute("account", productService.showProduct());
				
				req.setAttribute("productList",productService.showProduct());
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}else {
				
				//有効の場合 セッション情報リストを追加
				HttpSession session = req.getSession(true);
				session.setAttribute("account", productService.searchProduct(searchWord));
				
				// 検索ワード指定があった場合、そのワードで検索を行う。
				req.setAttribute("url","product_search");
				req.setAttribute("resultFlg","1");
				req.setAttribute("productList",productService.searchProduct(searchWord));
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
		}
		
		// 結果テーブルを表示しない
		req.setAttribute("resultFlg","0");
		// 各画面へ遷移する
		req.getRequestDispatcher("/index.jsp").forward(req, resp);	
		}
}
