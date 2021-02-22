package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ImageBean;
import service.ProductService;

	/**�A�J�E���g�̐V�K�o�^���s���T�[�u���b�g�N���X�B
	 * @author education
	 *
	 */
	@WebServlet("/image_regist")
	public class RegistImageServlet extends HttpServlet {
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// �{�^���������̒l���擾����
			String buttonType = req.getParameter("buttonType");
			
			// Service�̌Ăяo��
			ProductService productService = new ProductService();
			
			// �C���[�W�o�^��ʂ֑J�ڂ��鏀��
			req.setAttribute("url","image_regist");
			
			// �C���[�W��ǉ��{�^��������
			if("image_regist".equals(buttonType)) {
				// ���i.�摜�ꗗ��p�ӂ���
				req.setAttribute("imageList",productService.showImage());
				//�@�J�ڂ���
				req.getRequestDispatcher("/index.jsp").forward(req, resp);	
				return;
			}

			// �C���[�W��o�^�{�^��������
			// ��荞�񂾃t�@�C�����w��p�X�ɕۑ� �t�@�C���̖��O���擾����
			String fileName = productService.registImage(req.getPart("file"));
		
			// �t�@�C�������擾�ł����ꍇ
			if(!(fileName.isEmpty())) {
				// DB�ɓo�^����
				productService.insertImage(fileName);
			}
			
			// ���i.�摜�ꗗ��p�ӂ���
			req.setAttribute("imageList",productService.showImage());
			
			// �C���[�W�o�^��ʂ֑J�ڂ���
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
