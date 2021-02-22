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
	
	
	/**取得したアカウント情報(ID)をもとに、DBのレコードを変更します。
	 * @param account
	 */
	public void doChenge(AccountBean account) {
		// 取得した情報をDBに変更する
		AccountDao dao = new AccountDao();
		
		try {
			dao.changeAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**取得したアカウント情報をもとに、新たにDBにレコードを登録します。
	 * @param account
	 */
	public void doRegist(AccountBean account) {
		
		// 取得した情報をDBに登録する。
		AccountDao dao = new AccountDao();
		
		try {
			dao.insertAccountInfo(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**emailアドレスをもとに、DBに登録されている情報を取得します。
	 * 該当のデータがない場合、中身をnullで返却します
	 * @param account
	 * @return
	 */
	public AccountBean showAccountInfo(AccountBean account) {
		// 取得した情報をDBに登録されているか確認する
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
	 * 入力項目に不正があるかどうかを判定します。
	 * @param account
	 * @return
	 */
	public boolean checkInfo(AccountBean account, int type) {
		
		// ログインの場合
		if(type == 0) {
			if(validate(account) && formLoginCheck(account)) {
				return true;
			}
			
		// 新規登録 または 変更の場合
		}else if(type == 1) {
			if(validate(account) && formRegistCheck(account)) {
				return true;
			}
		}
		return false;
	}
	
	/**アカウント情報のバリデーションチェックを行います。
	 * @param account
	 * @return true/false
	 */
	private boolean validate(AccountBean account) {
		
		// メールアドレスか、パスワードが入力されていない場合false
		if(account.getE_mail().isEmpty() || account.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	/**入力された新規アカウント情報の最大文字桁チェックを行います。
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
	
	/**入力された変更アカウント情報の最大文字桁チェックを行います。
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
	
	/**入力されたログインアカウント情報の最大文字桁チェックを行います。
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
