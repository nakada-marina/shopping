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
	
	
	/**�v���_�N�g���̖��O�ƁA�ڍׂ��畔����v�������ʂ�ԋp���܂��B
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public List<ProductBean> serchProduct(ProductBean product) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM PRODUCT WHERE NAME LIKE ? OR INFO LIKE ?")) {		
			
			// ���O��ݒ肷��
			ps.setString(1, "%" + product.getName() + "%");
			
			// �ڍׂ�ݒ肷��
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

	/**ID���ɁA�v���_�N�g�e�[�u���̏����擾���A���X�g�ɂĕԋp���܂��B
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
	
	/**�V�K�̃��R�[�h��o�^���܂�
	 * @param account
	 * @return �o�^����(1��)
	 * @throws SQLException
	 */
	public int insertProduct(ProductBean product) throws SQLException{
		ConnectionUtils utils = new ConnectionUtils();
		try (Connection con = utils.getConnection();
				PreparedStatement ps = con.prepareStatement(
				"INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?, ?, ?, ?);")) {
			
				// ID�ݒ肷��iDB���Ŏ����̔Ԃ���̂ŁA0��ݒ肷��j
				ps.setInt(1, 0);
			
				// �t�@�C������ݒ肷��
				ps.setString(2, product.getName());
				
				// ����ݒ肷��
				ps.setString(3, product.getInfo());
				
				// ���i��ݒ肷��
				ps.setInt(4, product.getPrice());
				
				// �p�X��ݒ肷��
				ps.setString(5, product.getUrl());
				
				// �폜�t���O��ݒ肷��
				ps.setInt(6, 0);
				
				//�@�o�^������ݒ肷��
				Date date = new Date(System.currentTimeMillis());
				ps.setDate(7, date);
				
				// �X�V������ݒ肷��
				ps.setDate(8, date);
				
				return ps.executeUpdate();
		}
	}
	
	
}
