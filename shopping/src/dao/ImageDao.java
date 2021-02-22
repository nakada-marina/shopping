package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AccountBean;
import bean.ImageBean;
import commonUtils.ConnectionUtils;

public class ImageDao {
	
	
	/**ID順に、イメージ情報を取得し、リストにて返却します。
	 * @return
	 * @throws SQLException
	 */
	public List<ImageBean> showImage() throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
			"SELECT * FROM IMAGE ORDER BY IMAGE_ID")) {			
			ResultSet rs = ps.executeQuery();
			List<ImageBean> list = new ArrayList<>();
			while (rs.next()) {
				ImageBean resultAccount = new ImageBean();
				resultAccount.setImage_id(rs.getInt("IMAGE_ID"));
				resultAccount.setName(rs.getString("NAME"));
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
	public int insertImage(ImageBean image) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"INSERT INTO IMAGE VALUES (?, ?, ?, ?, ?, ?);")) {
			
				// ID設定する（DB側で自動採番するので、0を設定する）
				ps.setInt(1, 0);
			
				// ファイル名を設定する
				ps.setString(2, image.getName());
				
				// パスを設定する
				ps.setString(3, image.getUrl());
				
				// 削除フラグを設定する
				ps.setInt(4, 0);
				
				//　登録日時を設定する
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(5, date);
				
				// 更新日時を設定する
				ps.setDate(6, date);
				
				return ps.executeUpdate();
		}
	}

}
