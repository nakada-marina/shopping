package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import dao.AccountDao;
import logic.AccountLogic;

public class AccountService {
	
	/**E���[�����L�[�ɂق��̏����擾���ԋp���܂��B
	 * @return
	 */
	public AccountBean showAccountInfo(AccountBean account) {
		AccountDao dao = new AccountDao();
		try {
			return dao.selectAccountInfo(account);
		} catch (SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		return null;
	}
	
	/**�p�X���[�h�̓��͂��`�F�b�N���A�`�F�b�N��OK�̏ꍇ�p�X���[�h��ύX���܂�
	 * @param sessionAccount
	 * @param newPassword
	 * @param rePassword
	 * @return
	 */
	public AccountBean changePassword(AccountBean sessionAccount, String newPassword, String rePassword) {
		
		// �������p�X���[�h
		String okPassWord = sessionAccount.getPassword();
		
		// �������p�X���[�h�Ɠ��͂��ꂽ���݂̃p�X���[�h����v���Ă���ꍇ
		if(okPassWord.equals(rePassword)) {
			// �X�V����p�X���[�h��ID��DAO�ɓn���p
			AccountBean account = new AccountBean();
			account.setPassword(newPassword);
			account.setUser_id(sessionAccount.getUser_id());
			
			// �V�����p�X���[�h�ɏ���������B
			AccountDao dao = new AccountDao();
			try {
				dao.changePassword(account);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return sessionAccount;
		}
		return null;
	}
	
	
	/**�ύX���ꂽ�A�J�E���g�������ƂɃ`�F�b�N�������āADB�ɕύX���s���܂��B
	 * �ύX�����������ꍇ�A�擾���ꂽ����Bean�^�ŕԋp���܂��B
	 * �ύX�����s�����ꍇ�Anull��ԋp���܂��B
	 * @param req
	 * @return
	 */
	public AccountBean checkChangeInfo(HttpServletRequest req, AccountBean preAccount) {
		
		// ���O�C�������擾���ABean�ɃZ�b�g����
		AccountBean account = new AccountBean();
		
		// �ȉ��̏��́A�ύX��̃A�J�E���g���̂��̂��g�p����v
		account.setFamily_name(req.getParameter("family_name"));
		account.setName(req.getParameter("name"));
		account.setPostal_code(req.getParameter("postal_code"));
		account.setAddress(req.getParameter("address"));
		account.setPhone_number(req.getParameter("phone_number"));
		
		// �ȉ��̏��͕ύX�O�̃A�J�E���g���̂��̂��g�p����
		account.setE_mail(preAccount.getE_mail());
		account.setPassword(preAccount.getPassword());
		account.setUser_id(preAccount.getUser_id());
		account.setAuthority(preAccount.getAuthority());
				
		// �A�J�E���g���W�b�N
		AccountLogic accountLogic = new AccountLogic();
		
		// ���͂��ꂽ���̔�����s��
		if(accountLogic.checkInfo(account, 1)) {
			// OK�̏ꍇ�A�o�^�������s��
			accountLogic.doChenge(account);
			//�@�A�J�E���g�����擾���ԋp����
			return accountLogic.showAccountInfo(account);
		} else {
			// NG�̏ꍇ�A�o�^�������s�킸false��ԋp����
			return null;
		}	
	}
	
	
	/**���͂��ꂽ���O�C���������ƂɗL���ł��邩���`�F�b�N���s���B
	 * �`�F�b�N���ʂ�΁A�A�J�E���g����ԋp���܂��B
	 * @param req
	 * @return�@AccountBean�@�G���[�̏ꍇnull
	 */
	public AccountBean checkLoginInfo(HttpServletRequest req) {
		
		// ���O�C�������擾���ABean�ɃZ�b�g����
		AccountBean account = new AccountBean();
		
		// ���[���A�h���X��ݒ肷��
		account.setE_mail(req.getParameter("mail"));
		
		// �p�X���[�h��ݒ肷��
		account.setPassword(req.getParameter("password"));
		// req.getParameter("rePassword");
		
		// �A�J�E���g���W�b�N
		AccountLogic accountLogic = new AccountLogic();
		
		// DB�ɓo�^��񂪂���ꍇ
		if(!(accountLogic.showAccountInfo(account) == null)) {
			// ���͂��ꂽ���̔��� ���@DB�p�X���[�h�Ɠ��̓p�X���[�h����v����ꍇ
			if(accountLogic.checkInfo(account, 0)
					&& accountLogic.showAccountInfo(account).getPassword().equals(account.getPassword())) {
				// ���O�C����񂩂�A�A�J�E���g��񂷂ׂĂ��擾���ԋp����B
				return accountLogic.showAccountInfo(account);
			}
		}
		
		// NG�̏ꍇ�Anull��ԋp����
		return null;
	}
	
	
	/**���͂��ꂽ�A�J�E���g�V�K�o�^�������ƂɊe��`�F�b�N���s��
	 * �`�F�b�N���ʂ�Γo�^���s���A���ʂ�Bean�ɋl�߂ĕԋp���܂��B
	 * �A�ʂ�Ȃ���Γo�^���s�킸�ANull��ԋp���܂��B
	 * @param req
	 * @return boolean true���F�o�^�����@false�F���s
	 */
	public AccountBean checkRegistInfo(HttpServletRequest req) {
		
		// ���O�C�������擾���ABean�ɃZ�b�g����
		AccountBean account = new AccountBean();
		
		account.setE_mail(req.getParameter("mail"));
		
		account.setFamily_name(req.getParameter("family_name"));
		
		account.setName(req.getParameter("name"));
		
		account.setPostal_code(req.getParameter("postal_code"));
		
		account.setAddress(req.getParameter("address"));
		
		account.setPhone_number(req.getParameter("phone_number"));
		
		// �����t���O�`�F�b�N�{�b�N�X�Ƀ`�F�b�N���Ȃ��ꍇ�A0��ݒ肷��
		if(req.getParameter("uthority") == null) {
			account.setAuthority(0);
		}else {
			// ����ȊO�̏ꍇ1��ݒ肷��
			account.setAuthority(1);
		}
		
		account.setPassword(req.getParameter("password"));
		// req.getParameter("rePassword");
		
		// �A�J�E���g���W�b�N
		AccountLogic accountLogic = new AccountLogic();
		
		// ���͂��ꂽ���̔�����s��
		if(accountLogic.checkInfo(account, 1)) {
			// OK�̏ꍇ�A�o�^�������s��
			accountLogic.doRegist(account);
			//�@�A�J�E���g�����擾���ԋp����
			return accountLogic.showAccountInfo(account);
		} else {
			// NG�̏ꍇ�A�o�^�������s�킸false��ԋp����
			return null;
		}	
	}
	
	/**ID���L�[�ɃA�J�E���g�����폜���܂�
	 * @param account
	 */
	public void deleteAccount(AccountBean account) {
		AccountDao dao = new AccountDao();
		try {
			dao.deleteAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
