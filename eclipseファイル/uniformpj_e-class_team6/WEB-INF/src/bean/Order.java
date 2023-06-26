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
	private int quantity;
	private String purchase_day;
	private String username;
	private String address;
	private String user_mail;
	private int total_price;
	private String paymentStatus;
	private String sendingStatus;;

	public Order() {
		this.purchase_id = 0;
		this.uniform_id = 0;
		this.quantity = 0;
		this.purchase_day = null;
		this.username = null;
		this.address = null;
		this.user_mail = null;
		this.total_price = 0;
		this.paymentStatus = null;
		this.sendingStatus = null;
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
	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
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

	public void setDate(String username) {
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
	public int gettotal_price() {
		return total_price;
	}

	public void settotal_price(int total_price) {
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
}