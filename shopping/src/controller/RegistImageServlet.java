package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ImageBean;
import service.ProductService;

	/**アカウントの新規登録を行うサーブレットクラス。
	 * @author education
	 *
	 */
	@WebServlet("/image_regist")
	public class RegistImageServlet extends HttpServlet {
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// ボタン押下時の値を取得する
			String buttonType = req.getParameter("buttonType");
			
			// Serviceの呼び出し
			ProductService productService = new ProductService();
			
			// イメージ登録画面へ遷移する準備
			req.setAttribute("url","image_regist");
			
			// イメージを追加ボタン押下時
			if("image_regist".equals(buttonType)) {
				// 商品.画像一覧を用意する
				req.setAttribute("imageList",productService.showImage());
				//　遷移する
				req.getRequestDispatcher("/index.jsp").forward(req, resp);	
				return;
			}

			// イメージを登録ボタン押下時
			// 取り込んだファイルを指定パスに保存 ファイルの名前を取得する
			String fileName = productService.registImage(req.getPart("file"));
		
			// ファイル名が取得できた場合
			if(!(fileName.isEmpty())) {
				// DBに登録する
				productService.insertImage(fileName);
			}
			
			// 商品.画像一覧を用意する
			req.setAttribute("imageList",productService.showImage());
			
			// イメージ登録画面へ遷移する
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
