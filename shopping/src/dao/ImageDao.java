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
	
	
	/**ID���ɁA�C���[�W�����擾���A���X�g�ɂĕԋp���܂��B
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
	
	
	/**�V�K�̃��R�[�h��o�^���܂�
	 * @param account
	 * @return �o�^����(1��)
	 * @throws SQLException
	 */
	public int insertImage(ImageBean image) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"INSERT INTO IMAGE VALUES (?, ?, ?, ?, ?, ?);")) {
			
				// ID�ݒ肷��iDB���Ŏ����̔Ԃ���̂ŁA0��ݒ肷��j
				ps.setInt(1, 0);
			
				// �t�@�C������ݒ肷��
				ps.setString(2, image.getName());
				
				// �p�X��ݒ肷��
				ps.setString(3, image.getUrl());
				
				// �폜�t���O��ݒ肷��
				ps.setInt(4, 0);
				
				//�@�o�^������ݒ肷��
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(5, date);
				
				// �X�V������ݒ肷��
				ps.setDate(6, date);
				
				return ps.executeUpdate();
		}
	}

}
