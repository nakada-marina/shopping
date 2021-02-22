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

	/** �t�@�C���ۑ��p�X**/
	private final String FILE_PATH = "C:\\Users\\education\\eclipse-workspace\\shopping\\WebContent\\images\\";
	
	/** �ۑ���t�@�C����**/
	private final String FILE_NAME = ".\\\\images\\\\";

	
	/**�v���_�N�g���̖��O�ƁA�ڍׂ��畔����v�������ʂ�ԋp���܂��B
	 * @param product
	 * @return
	 */
	public List<ProductBean> searchProduct(String searchWord){
		
		// �������[�h���A���O�Əڍ׏��ɃZ�b�g����
		ProductBean product = new ProductBean();
		product.setName(searchWord);
		product.setInfo(searchWord);
		
		ProductDao dao = new ProductDao();
		
		// �������s��
		try {
			return dao.serchProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	/**�v���_�N�g�̈ꗗ�����X�g�^�ŕԋp���܂��B
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
	
	/**�C���[�W�̈ꗗ�����X�g�^�ŕԋp���܂��B
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
	
	/**�C���[�W�摜��o�^���܂��B�t�@�C��������t���p�X�𐶐����܂��B
	 * @param image
	 */
	public void insertImage(String imageName) {

		ImageBean image = new ImageBean();
		// �摜�����Z�b�g����
		image.setName(imageName);
		// ���΃p�X�����Z�b�g����
		image.setUrl(FILE_NAME + imageName);
		
		ImageDao dao = new ImageDao();
		try {
			dao.insertImage(image);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**���i����V�K�o�^���܂�
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
	
	
	 /**�摜�t�@�C������荞�݁A�ۑ���ɕۑ����A���̃t���p�X��ԋp���܂��B
	 * @param part ��荞�񂾉摜�t�@�C��
	 * @return �t�@�C����
	 */
	public String registImage(Part part) {

		String fileName = null;
		String[] splitedHeader = part.getHeader("Content-Disposition").split(";");

		for(String item: splitedHeader) {
			if(item.trim().startsWith("filename")) {
					fileName = item.substring(item.indexOf('"')).replaceAll("\"", "");
				}
		}
		
		// �w�肵���p�X�Ƀt�@�C����ۑ�����
		try {
			part.write(FILE_PATH + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// �t�@�C������ԋp����B
		return fileName;
	 }
}
