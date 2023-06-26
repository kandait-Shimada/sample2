//ユニフォーム情報を一つのオブジェクトとしてまとめるためのDTOクラス

package bean;

public class Uniform {

	// フィールド変数の宣言
	private int uniformid;
	private String name;
	private int stock;
	private int price;

	// 初期設定
	public Uniform() {
		this.uniformid = 0;
		this.name = null;
		this.stock = 0;
		this.price = 0;
	}

	public int getUniformid() {
		return uniformid;
	}

	public void setUniformid(int uniformid) {
		this.uniformid = uniformid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
