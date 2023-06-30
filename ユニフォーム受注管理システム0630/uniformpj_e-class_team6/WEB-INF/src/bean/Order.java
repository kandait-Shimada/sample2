/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：ユニフォーム注文時のDTOクラス
 * 作成者：杉崎達也
 * 作成日付：2023/06/22
 */

package bean;

public class Order {
	private int purchase_id;
	private int uniform_id;
	private int quantitiy;
	private String purchase_day;
	private String username;
	private String address;
	private String user_mail;
	private int total_price;
	private String paymentStatus;
	private String sendingStatus;
	private String comment;

	private String uniform_name;

	public Order() {
		this.purchase_id = 0;
		this.uniform_id = 0;
		this.quantitiy = 0;
		this.purchase_day = null;
		this.username = null;
		this.address = null;
		this.user_mail = null;
		this.total_price = 0;
		this.paymentStatus = null;
		this.sendingStatus = null;
		this.comment = null;
		this.uniform_name = null;
	}

	// 購入ID
	public int getpurchase_id() {
		return purchase_id;
	}

	public void setpurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	// 商品ID
	public int getuniform_id() {
		return uniform_id;
	}

	public void setuniform_id(int uniform_id) {
		this.uniform_id = uniform_id;
	}

	// 数量
	public int getquantitiy() {
		return quantitiy;
	}

	public void setquantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}

	// 購入日時
	public String getpurchase_day() {
		return purchase_day;
	}

	public void setpurchase_day(String purchase_day) {
		this.purchase_day = purchase_day;
	}

	// 利用者名前
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	// 住所
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	// 利用者メールアドレス
	public String getuser_mail() {
		return user_mail;
	}

	public void setuser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	// 合計金額
	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	// 入金状況
	public String getpaymentStatus() {
		return paymentStatus;
	}

	public void setpaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	// 発送状況
	public String getsendingStatus() {
		return sendingStatus;
	}

	public void setsendingStatus(String sendingStatus) {
		this.sendingStatus = sendingStatus;
	}

	// 備考欄
	public String getcomment() {
		return comment;
	}

	public void setcomment(String comment) {
		this.comment = comment;
	}

	public String getUniform_name() {
		return uniform_name;
	}

	public void setUniform_name(String uniform_name) {
		this.uniform_name = uniform_name;
	}

}