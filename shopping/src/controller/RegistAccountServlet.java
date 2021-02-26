package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import service.AccountService;

	/**�A�J�E���g�̐V�K�o�^���s���T�[�u���b�g�N���X�B
	 * @author education
	 *
	 */
	@WebServlet("/doRegist")
	public class RegistAccountServlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			// Service�̌Ăяo��
			AccountService accountService = new AccountService();

			// ���͓��e����������΁ADB�ɓo�^����
			AccountBean accountBean = new AccountBean();
			accountBean = accountService.checkRegistInfo(req);

			// �����̏ꍇ
			if(!(accountBean == null)){

				//�L���̏ꍇ �Z�b�V�������ɁA�A�J�E���g�����Z�b�g����
				HttpSession session = req.getSession(true);
				session.setAttribute("account", accountBean);

				// �A�J�E���g�Ǘ���ʂ֑J�ڂ���
				req.setAttribute("url","account_management");
				req.getRequestDispatcher("./WEB-INF/account/account_management.jsp").forward(req, resp);

			}else {
				// TODO �A�J�E���g�������ł���ꍇ�A�Ƃɂ����G���[����ʂɕ\������B
				req.setAttribute("errorFlg","1");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
		}
	}
