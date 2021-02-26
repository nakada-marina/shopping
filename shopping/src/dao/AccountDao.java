package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AccountBean;
import commonUtils.ConnectionUtils;


public class AccountDao {

	/**�V�K�̃��R�[�h��o�^���܂�
	 * @param account
	 * @return �o�^����(1��)
	 * @throws SQLException
	 */
	public int insertAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		Connection con = utils.getConnection();
		try (PreparedStatement ps = con.prepareStatement(
				"INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")) {

				// ID�ݒ肷��iDB���Ŏ����̔Ԃ���̂ŁA0��ݒ肷��j
				ps.setInt(1, 0);

				// ���[����ݒ肷��
				ps.setString(2, account.getE_mail());

				// �p�X���[�h��ݒ肷��
				ps.setString(3, account.getPassword());

				// ���O��ݒ肷��
				ps.setString(4, account.getName());

				// ����ݒ肷��
				ps.setString(5, account.getFamily_name());

				// �X�֔ԍ���ݒ肷��
				ps.setString(6, account.getPostal_code());

				// �Z����ݒ肷��
				ps.setString(7, account.getAddress());

				// �d�b�ԍ���ݒ肷��
				ps.setString(8, account.getPhone_number());

				// �����t���O��ݒ肷��
				ps.setInt(9, account.getAuthority());

				//�@�o�^������ݒ肷��@TODO�@���Ԃ��ݒ�ł��ĂȂ�����
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(10, date);

				// �X�V������ݒ肷��
				ps.setDate(11, date);

				return ps.executeUpdate();
		}
	}

	/**�A�J�E���g����ύX���܂�
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int changeAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		Connection con = utils.getConnection();
		try (PreparedStatement ps = con.prepareStatement(
				"UPDATE USER SET FAMILY_NAME = ?, NAME = ?, POSTAL_CODE = ?, ADDRESS = ?, PHONE_NUMBER = ?, UPDATE_TIME = ? WHERE USER_ID = ?")) {

				// ����ݒ肷��
				ps.setString(1, account.getFamily_name());

				// ���O��ݒ肷��
				ps.setString(2, account.getName());

				// �X�֔ԍ���ݒ肷��
				ps.setString(3, account.getPostal_code());

				// �Z����ݒ肷��
				ps.setString(4, account.getAddress());

				// �d�b�ԍ���ݒ肷��
				ps.setString(5, account.getPhone_number());

				//�@�ύX������ݒ肷��@TODO�@���Ԃ��ݒ�ł��ĂȂ�����
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(6, date);

				// ID���X�V�����ݒ肷��
				ps.setInt(7, account.getUser_id());

				return ps.executeUpdate();
		}
	}

	/**�A�J�E���g����ύX���܂�
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int changePassword(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		Connection con = utils.getConnection();
		try (PreparedStatement ps = con.prepareStatement(
				"UPDATE USER SET PASSWORD = ? WHERE USER_ID = ?")) {

				// �p�X���[�h��ݒ肷��
				ps.setString(1, account.getPassword());

				// ID���X�V�����ݒ肷��
				ps.setInt(2, account.getUser_id());

				return ps.executeUpdate();
		}
	}

	/**���[���A�h���X���L�[�ɃA�J�E���g�����擾���܂��B
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public AccountBean selectAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		Connection con = utils.getConnection();
		try (PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM USER WHERE E_MAIL = ?")) {

			// E-mail��ݒ肷��
			ps.setString(1, account.getE_mail());
			ResultSet rs = ps.executeQuery();
			// �ԋp�p��Bean��p�ӂ���
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

	/**�A�J�E���g�����폜���܂�
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public int deleteAccountInfo(AccountBean account) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		Connection con = utils.getConnection();
		try (PreparedStatement ps = con.prepareStatement(
				"DELETE FROM USER WHERE USER_ID = ?")) {

				// ID���X�V�����ݒ肷��
				ps.setInt(1, account.getUser_id());

				return ps.executeUpdate();
		}
	}


}
