package logic;

import java.sql.SQLException;

import bean.AccountBean;
import dao.AccountDao;

public class AccountLogic {
	
	private final int E_MAIL_LENGTH = 60;
	private final int PASSWORD_LENGTH = 40;
	private final int NAME_LENGTH = 40;
	private final int FAMILY_NAME_LENGTH = 40;
	private final int POSTAL_CODE_LENGTH = 8;
	private final int ADDRESS_LENGTH = 200;
	private final int PHONE_LENGTH = 20;
	
	
	/**�擾�����A�J�E���g���(ID)�����ƂɁADB�̃��R�[�h��ύX���܂��B
	 * @param account
	 */
	public void doChenge(AccountBean account) {
		// �擾��������DB�ɕύX����
		AccountDao dao = new AccountDao();
		
		try {
			dao.changeAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**�擾�����A�J�E���g�������ƂɁA�V����DB�Ƀ��R�[�h��o�^���܂��B
	 * @param account
	 */
	public void doRegist(AccountBean account) {
		
		// �擾��������DB�ɓo�^����B
		AccountDao dao = new AccountDao();
		
		try {
			dao.insertAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**email�A�h���X�����ƂɁADB�ɓo�^����Ă�������擾���܂��B
	 * �Y���̃f�[�^���Ȃ��ꍇ�A���g��null�ŕԋp���܂�
	 * @param account
	 * @return
	 */
	public AccountBean showAccountInfo(AccountBean account) {
		// �擾��������DB�ɓo�^����Ă��邩�m�F����
		AccountDao dao = new AccountDao();
		AccountBean resultAccount = new AccountBean();
		try {
			resultAccount = dao.selectAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultAccount;
	}
	
	/**
	 * ���͍��ڂɕs�������邩�ǂ����𔻒肵�܂��B
	 * @param account
	 * @return
	 */
	public boolean checkInfo(AccountBean account, int type) {
		
		// ���O�C���̏ꍇ
		if(type == 0) {
			if(validate(account) && formLoginCheck(account)) {
				return true;
			}
			
		// �V�K�o�^ �܂��� �ύX�̏ꍇ
		}else if(type == 1) {
			if(validate(account) && formRegistCheck(account)) {
				return true;
			}
		}
		return false;
	}
	
	/**�A�J�E���g���̃o���f�[�V�����`�F�b�N���s���܂��B
	 * @param account
	 * @return true/false
	 */
	private boolean validate(AccountBean account) {
		
		// ���[���A�h���X���A�p�X���[�h�����͂���Ă��Ȃ��ꍇfalse
		if(account.getE_mail().isEmpty() || account.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	/**���͂��ꂽ�V�K�A�J�E���g���̍ő啶�����`�F�b�N���s���܂��B
	 * @param account
	 * @return true/false
	 */
	private boolean formRegistCheck(AccountBean account) {
		
		if(account.getE_mail().length()>E_MAIL_LENGTH
				|| account.getPassword().length()>PASSWORD_LENGTH
				|| account.getName().length()>NAME_LENGTH
				|| account.getFamily_name().length()>FAMILY_NAME_LENGTH
				|| account.getPostal_code().length()>POSTAL_CODE_LENGTH
				|| account.getAddress().length()>ADDRESS_LENGTH
				|| account.getPhone_number().length()>PHONE_LENGTH) {
			return false;
		}
		return true;
	}
	
	/**���͂��ꂽ�ύX�A�J�E���g���̍ő啶�����`�F�b�N���s���܂��B
	 * @param account
	 * @return true/false
	 */
	private boolean formChangeCheck(AccountBean account) {
		
		if(account.getName().length()>NAME_LENGTH
				|| account.getFamily_name().length()>FAMILY_NAME_LENGTH
				|| account.getPostal_code().length()>POSTAL_CODE_LENGTH
				|| account.getAddress().length()>ADDRESS_LENGTH
				|| account.getPhone_number().length()>PHONE_LENGTH) {
			return false;
		}
		return true;
	}
	
	/**���͂��ꂽ���O�C���A�J�E���g���̍ő啶�����`�F�b�N���s���܂��B
	 * @param account
	 * @return true/false
	 */
	private boolean formLoginCheck(AccountBean account) {
		
		if(account.getE_mail().length()>E_MAIL_LENGTH
				|| account.getPassword().length()>PASSWORD_LENGTH) {
			return false;
		}
		return true;
	}
}
