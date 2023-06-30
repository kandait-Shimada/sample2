package bean;

public class User {

	// マネージャーIDを格納する変数
	private int managerLogin_id;

	// パスワードを格納する変数
	private String manager_password;

	// Eメールアドレスを格納する変数
	private String manager_mail;

	// コンストラクタの定義
	public User() {
		managerLogin_id = 0;
		manager_password = null;
		manager_mail = null;
	}

	// managerLogin_idを格納するアクセサメソッド
	public int getManagerLogin_id() {
		return managerLogin_id;
	}

	public void setManagerLogin_id(int managerLogin_id) {
		this.managerLogin_id = managerLogin_id;
	}

	// manager_passwordを格納するアクセサメソッド
	public String getManager_password() {
		return manager_password;
	}

	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}

	// maneger_mailを格納するアクセサメソッド
	public String getManager_mail() {
		return manager_mail;
	}

	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
	}
}
