package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ImageBean;
import bean.ProductBean;
import commonUtils.ConnectionUtils;

public class ProductDao {
	
	
	/**プロダクト情報の名前と、詳細から部分一致検索結果を返却します。
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public List<ProductBean> serchProduct(ProductBean product) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM PRODUCT WHERE NAME LIKE ? OR INFO LIKE ?")) {		
			
			// 名前を設定する
			ps.setString(1, "%" + product.getName() + "%");
			
			// 詳細を設定する
			ps.setString(2, "%" + product.getInfo() + "%");
			
			ResultSet rs = ps.executeQuery();
			List<ProductBean> list = new ArrayList<>();
			while (rs.next()) {
				ProductBean resultAccount = new ProductBean();
				resultAccount.setProduct_id(rs.getInt("PRODUCT_ID"));
				resultAccount.setName(rs.getString("NAME"));
				resultAccount.setInfo(rs.getString("INFO"));
				resultAccount.setPrice(rs.getInt("PRICE"));
				resultAccount.setUrl(rs.getString("URL"));
				resultAccount.setDel_flg(rs.getInt("DEL_FLG"));
				resultAccount.setCreation_time(rs.getString("CREATION_TIME"));
				resultAccount.setUpdate_time(rs.getString("UPDATE_TIME"));
				
				list.add(resultAccount);
			}	
			return list;
		}
	}

	/**ID順に、プロダクトテーブルの情報を取得し、リストにて返却します。
	 * @return
	 * @throws SQLException
	 */
	public List<ProductBean> showProduct() throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
			"SELECT * FROM PRODUCT ORDER BY PRODUCT_ID")) {			
			ResultSet rs = ps.executeQuery();
			List<ProductBean> list = new ArrayList<>();
			while (rs.next()) {
				ProductBean resultAccount = new ProductBean();
				resultAccount.setProduct_id(rs.getInt("PRODUCT_ID"));
				resultAccount.setName(rs.getString("NAME"));
				resultAccount.setInfo(rs.getString("INFO"));
				resultAccount.setPrice(rs.getInt("PRICE"));
				resultAccount.setUrl(rs.getString("URL"));
				resultAccount.setDel_flg(rs.getInt("DEL_FLG"));
				resultAccount.setCreation_time(rs.getString("CREATION_TIME"));
				resultAccount.setUpdate_time(rs.getString("UPDATE_TIME"));
				
				list.add(resultAccount);
			}	
			return list;
		}
	}
	
	/**新規のレコードを登録します
	 * @param account
	 * @return 登録件数(1件)
	 * @throws SQLException
	 */
	public int insertProduct(ProductBean product) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?, ?, ?, ?);")) {
			
				// ID設定する（DB側で自動採番するので、0を設定する）
				ps.setInt(1, 0);
			
				// ファイル名を設定する
				ps.setString(2, product.getName());
				
				// 情報を設定する
				ps.setString(3, product.getInfo());
				
				// 価格を設定する
				ps.setInt(4, product.getPrice());
				
				// パスを設定する
				ps.setString(5, product.getUrl());
				
				// 削除フラグを設定する
				ps.setInt(6, 0);
				
				//　登録日時を設定する
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(7, date);
				
				// 更新日時を設定する
				ps.setDate(8, date);
				
				return ps.executeUpdate();
		}
	}
	
	
}
