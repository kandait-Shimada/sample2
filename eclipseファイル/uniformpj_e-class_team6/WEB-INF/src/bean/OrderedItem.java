/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：注文詳細情報を
 * 　　　　　　　　　一つのオブジェクトとしてまとめるためのDTOクラス
 * 作成者：松井　朱奈
 * 作成日付：2023/06/22
 */


package bean;

public class OrderedItem {

	/**
	 * 注文番号
	 */
	private int purchase_id;
	/**
	 * ユーザー名
	 */
	private String username;
	/**
	 * 住所
	 */
	private String address;
	/**
	 * メールアドレス
	 */
	private String user_mail;
	/**
	 * 合計金額
	 */
	private int total_price;
	/**
	 * 入金状況
	 */
	private String paymentStatus;
	/**
	 * 発送状況
	 */
	private String sendingStatus;

	/**
	 * 商品番号
	 */
	private int uniform_id;
	/**
	 * 個数
	 */
	private int quantitiy;
	/**
	 * 購入日時
	 */
	private String purchase_day;
	/**
	 * 備考
	 */
	private String comment;
;


	/**
	 * コンストラクタ<br>
	 * 受注情報の初期設定をおこなう
	 */
	public OrderedItem() {
		this.purchase_id = 0;
		this.username = null;
		this.address = null;
		this.user_mail = null;
		this.total_price = 0;
		this.paymentStatus = null;
		this.sendingStatus = null;
		this.uniform_id = 0;
		this.quantitiy = 0;
		this.purchase_day = null;
		this.comment = null;
	}


	/**
	 * 注文番号を取得する
	 */
	public int getPurchase_id() {
		return purchase_id;
	}

	/**
	 * 注文番号を設定する
	 */
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	/**
	 * ユーザー名を取得する
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ユーザー名を設定する
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 住所を取得する
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住所を設定する
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * メールアドレスを取得する
	 */
	public String getUser_mail() {
		return user_mail;
	}

	/**
	 * メールアドレスを設定する
	 */
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	/**
	 * 合計金額を取得する
	 */
	public int getTotal_price() {
		return total_price;
	}

	/**
	 * 合計金額を設定する
	 */
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	/**
	 * 入金状況を取得する
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * 入金状況を設定する
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * 発送状況を取得する
	 */
	public String getSendingStatus() {
		return sendingStatus;
	}

	/**
	 * 発送状況を設定する
	 */
	public void setSendingStatus(String sendingStatus) {
		this.sendingStatus = sendingStatus;
	}

	/**
	 * 商品番号を取得する
	 */
	public int getUniform_id() {
		return uniform_id;
	}

	/**
	 * 商品番号を設定する
	 */
	public void setUniform_id(int uniform_id) {
		this.uniform_id = uniform_id;
	}

	/**
	 * 注文個数を取得する
	 */
	public int getQuantitiy() {
		return quantitiy;
	}

	/**
	 * 注文個数を設定する
	 */
	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}

	/**
	 * 購入日時を取得する
	 */
	public String getPurchase_day() {
		return purchase_day;
	}

	/**
	 * 購入日時を設定する
	 */
	public void setPurchase_day(String purchase_day) {
		this.purchase_day = purchase_day;
	}

	/**
	 * 購入日時を取得する
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 購入日時を設定する
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
