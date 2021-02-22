package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.AccountBean;
import dao.AccountDao;
import logic.AccountLogic;

public class AccountService {
	
	/**Eメールをキーにほかの情報を取得し返却します。
	 * @return
	 */
	public AccountBean showAccountInfo(AccountBean account) {
		AccountDao dao = new AccountDao();
		try {
			return dao.selectAccountInfo(account);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}
	
	/**パスワードの入力をチェックし、チェックがOKの場合パスワードを変更します
	 * @param sessionAccount
	 * @param newPassword
	 * @param rePassword
	 * @return
	 */
	public AccountBean changePassword(AccountBean sessionAccount, String newPassword, String rePassword) {
		
		// 正しいパスワード
		String okPassWord = sessionAccount.getPassword();
		
		// 正しいパスワードと入力された現在のパスワードが一致している場合
		if(okPassWord.equals(rePassword)) {
			// 更新するパスワードとIDをDAOに渡す用
			AccountBean account = new AccountBean();
			account.setPassword(newPassword);
			account.setUser_id(sessionAccount.getUser_id());
			
			// 新しいパスワードに書き換える。
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
	
	
	/**変更されたアカウント情報をもとにチェックをかけて、DBに変更を行います。
	 * 変更が成功した場合、取得された情報をBean型で返却します。
	 * 変更が失敗した場合、nullを返却します。
	 * @param req
	 * @return
	 */
	public AccountBean checkChangeInfo(HttpServletRequest req, AccountBean preAccount) {
		
		// ログイン情報を取得し、Beanにセットする
		AccountBean account = new AccountBean();
		
		// 以下の情報は、変更後のアカウント情報のものを使用する」
		account.setFamily_name(req.getParameter("family_name"));
		account.setName(req.getParameter("name"));
		account.setPostal_code(req.getParameter("postal_code"));
		account.setAddress(req.getParameter("address"));
		account.setPhone_number(req.getParameter("phone_number"));
		
		// 以下の情報は変更前のアカウント情報のものを使用する
		account.setE_mail(preAccount.getE_mail());
		account.setPassword(preAccount.getPassword());
		account.setUser_id(preAccount.getUser_id());
		account.setAuthority(preAccount.getAuthority());
				
		// アカウントロジック
		AccountLogic accountLogic = new AccountLogic();
		
		// 入力された情報の判定を行う
		if(accountLogic.checkInfo(account, 1)) {
			// OKの場合、登録処理を行う
			accountLogic.doChenge(account);
			//　アカウント情報を取得し返却する
			return accountLogic.showAccountInfo(account);
		} else {
			// NGの場合、登録処理を行わずfalseを返却する
			return null;
		}	
	}
	
	
	/**入力されたログイン情報をもとに有効であるかをチェックを行う。
	 * チェックが通れば、アカウント情報を返却します。
	 * @param req
	 * @return　AccountBean　エラーの場合null
	 */
	public AccountBean checkLoginInfo(HttpServletRequest req) {
		
		// ログイン情報を取得し、Beanにセットする
		AccountBean account = new AccountBean();
		
		// メールアドレスを設定する
		account.setE_mail(req.getParameter("mail"));
		
		// パスワードを設定する
		account.setPassword(req.getParameter("password"));
		// req.getParameter("rePassword");
		
		// アカウントロジック
		AccountLogic accountLogic = new AccountLogic();
		
		// DBに登録情報がある場合
		if(!(accountLogic.showAccountInfo(account) == null)) {
			// 入力された情報の判定 かつ　DBパスワードと入力パスワードが一致する場合
			if(accountLogic.checkInfo(account, 0)
					&& accountLogic.showAccountInfo(account).getPassword().equals(account.getPassword())) {
				// ログイン情報から、アカウント情報すべてを取得し返却する。
				return accountLogic.showAccountInfo(account);
			}
		}
		
		// NGの場合、nullを返却する
		return null;
	}
	
	
	/**入力されたアカウント新規登録情報をもとに各種チェックを行う
	 * チェックが通れば登録を行い、結果をBeanに詰めて返却します。
	 * 、通らなければ登録を行わず、Nullを返却します。
	 * @param req
	 * @return boolean trueｔ：登録成功　false：失敗
	 */
	public AccountBean checkRegistInfo(HttpServletRequest req) {
		
		// ログイン情報を取得し、Beanにセットする
		AccountBean account = new AccountBean();
		
		account.setE_mail(req.getParameter("mail"));
		
		account.setFamily_name(req.getParameter("family_name"));
		
		account.setName(req.getParameter("name"));
		
		account.setPostal_code(req.getParameter("postal_code"));
		
		account.setAddress(req.getParameter("address"));
		
		account.setPhone_number(req.getParameter("phone_number"));
		
		// 権限フラグチェックボックスにチェックがない場合、0を設定する
		if(req.getParameter("uthority") == null) {
			account.setAuthority(0);
		}else {
			// それ以外の場合1を設定する
			account.setAuthority(1);
		}
		
		account.setPassword(req.getParameter("password"));
		// req.getParameter("rePassword");
		
		// アカウントロジック
		AccountLogic accountLogic = new AccountLogic();
		
		// 入力された情報の判定を行う
		if(accountLogic.checkInfo(account, 1)) {
			// OKの場合、登録処理を行う
			accountLogic.doRegist(account);
			//　アカウント情報を取得し返却する
			return accountLogic.showAccountInfo(account);
		} else {
			// NGの場合、登録処理を行わずfalseを返却する
			return null;
		}	
	}
	
	/**IDをキーにアカウント情報を削除します
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
