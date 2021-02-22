package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;

import bean.ImageBean;
import bean.ProductBean;
import dao.ImageDao;
import dao.ProductDao;

public class ProductService {

	/** ファイル保存パス**/
	private final String FILE_PATH = "C:\\Users\\education\\eclipse-workspace\\shopping\\WebContent\\images\\";
	
	/** 保存先ファイル名**/
	private final String FILE_NAME = ".\\\\images\\\\";

	
	/**プロダクト情報の名前と、詳細から部分一致検索結果を返却します。
	 * @param product
	 * @return
	 */
	public List<ProductBean> searchProduct(String searchWord){
		
		// 検索ワードを、名前と詳細情報にセットする
		ProductBean product = new ProductBean();
		product.setName(searchWord);
		product.setInfo(searchWord);
		
		ProductDao dao = new ProductDao();
		
		// 検索を行う
		try {
			return dao.serchProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	/**プロダクトの一覧をリスト型で返却します。
	 * @return
	 */
	public List<ProductBean> showProduct() {
		
		ProductDao dao = new ProductDao();
		try {
			return dao.showProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**イメージの一覧をリスト型で返却します。
	 * @return
	 */
	public List<ImageBean> showImage() {
		
		ImageDao dao = new ImageDao();
		try {
			return dao.showImage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**イメージ画像を登録します。ファイル名からフルパスを生成します。
	 * @param image
	 */
	public void insertImage(String imageName) {

		ImageBean image = new ImageBean();
		// 画像名をセットする
		image.setName(imageName);
		// 相対パスををセットする
		image.setUrl(FILE_NAME + imageName);
		
		ImageDao dao = new ImageDao();
		try {
			dao.insertImage(image);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**商品情報を新規登録します
	 * @param product
	 */
	public void insertProduct(ProductBean product) {
		ProductDao dao = new ProductDao();
		try {
			dao.insertProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	 /**画像ファイルを取り込み、保存先に保存し、そのフルパスを返却します。
	 * @param part 取り込んだ画像ファイル
	 * @return ファイル名
	 */
	public String registImage(Part part) {

		String fileName = null;
		String[] splitedHeader = part.getHeader("Content-Disposition").split(";");

		for(String item: splitedHeader) {
			if(item.trim().startsWith("filename")) {
					fileName = item.substring(item.indexOf('"')).replaceAll("\"", "");
				}
		}
		
		// 指定したパスにファイルを保存する
		try {
			part.write(FILE_PATH + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ファイル名を返却する。
		return fileName;
	 }
}
