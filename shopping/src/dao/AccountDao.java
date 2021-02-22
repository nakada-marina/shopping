package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AccountBean;
import commonUtils.ConnectionUtils;


public class AccountDao {
			
	/**新規のレコードを登録します
	 * @param account
	 * @return 登録件数(1件)
	 * @throws SQLException
	 */
	public int insertAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
			
				// ID設定する（DB側で自動採番するので、0を設定する）
				ps.setInt(1, 0);
				
				// メールを設定する
				ps.setString(2, account.getE_mail());
				
				// パスワードを設定する
				ps.setString(3, account.getPassword());
				
				// 名前を設定する
				ps.setString(4, account.getName());
				
				// 姓を設定する
				ps.setString(5, account.getFamily_name());
				
				// 郵便番号を設定する
				ps.setString(6, account.getPostal_code());
				
				// 住所を設定する
				ps.setString(7, account.getAddress());
				
				// 電話番号を設定する
				ps.setString(8, account.getPhone_number());
				
				// 権限フラグを設定する
				ps.setInt(9, account.getAuthority());
				
				//　登録日時を設定する　TODO　時間が設定できてない＞＜
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(10, date);
				
				// 更新日時を設定する
				ps.setDate(11, date);
				
				return ps.executeUpdate();
		}
	}
	
	/**アカウント情報を変更します
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int changeAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"UPDATE USER SET FAMILY_NAME = ?, NAME = ?, POSTAL_CODE = ?, ADDRESS = ?, PHONE_NUMBER = ?, UPDATE_TIME = ? WHERE USER_ID = ?")) {

				// 姓を設定する
				ps.setString(1, account.getFamily_name());
				
				// 名前を設定する
				ps.setString(2, account.getName());
				
				// 郵便番号を設定する
				ps.setString(3, account.getPostal_code());
				
				// 住所を設定する
				ps.setString(4, account.getAddress());
				
				// 電話番号を設定する
				ps.setString(5, account.getPhone_number());
				
				//　変更日時を設定する　TODO　時間が設定できてない＞＜
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(6, date);
				
				// IDを更新せず設定する
				ps.setInt(7, account.getUser_id());
				
				return ps.executeUpdate();
		}
	}
	
	/**アカウント情報を変更します
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int changePassword(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"UPDATE USER SET PASSWORD = ? WHERE USER_ID = ?")) {

				// パスワードを設定する
				ps.setString(1, account.getPassword());
				
				// IDを更新せず設定する
				ps.setInt(2, account.getUser_id());
				
				return ps.executeUpdate();
		}
	}
	
	/**メールアドレスをキーにアカウント情報を取得します。
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public AccountBean selectAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM USER WHERE E_MAIL = ?")) {
			
			// E-mailを設定する
			ps.setString(1, account.getE_mail());
			ResultSet rs = ps.executeQuery();
			// 返却用のBeanを用意する
			AccountBean resultAccount = new AccountBean();
			
			if (rs.next()) {
				resultAccount.setUser_id(rs.getInt("USER_ID"));
				resultAccount.setE_mail(rs.getString("E_MAIL"));
				resultAccount.setPassword(rs.getString("PASSWORD"));
				resultAccount.setName(rs.getString("NAME"));
				resultAccount.setFamily_name(rs.getString("FAMILY_NAME"));
				resultAccount.setPostal_code(rs.getString("POSTAL_CODE"));
				resultAccount.setAddress(rs.getString("ADDRESS"));
				resultAccount.setPhone_number(rs.getString("PHONE_NUMBER"));
				resultAccount.setAuthority(rs.getInt("AUTHORITY"));
				resultAccount.setCreation_time(rs.getString("CREATION_TIME"));
				resultAccount.setUpdate_time(rs.getString("UPDATE_TIME"));
				return resultAccount;
			}
			return null;
			}
	}
	
	/**アカウント情報を削除します
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int deleteAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"DELETE FROM USER WHERE USER_ID = ?")) {

				// IDを更新せず設定する
				ps.setInt(1, account.getUser_id());
				
				return ps.executeUpdate();
		}
	}
	
	
}
