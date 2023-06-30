//ユニフォーム情報を一つのオブジェクトとしてまとめるためのDTOクラス

package bean;

public class Uniform {

	// フィールド変数の宣言
	private int uniformid;
	private String uniform_name;
	private int stock;
	private int price;

	// 初期設定
	public Uniform() {
		this.uniformid = 0;
		this.uniform_name = null;
		this.stock = 0;
		this.price = 0;
	}

	public int getUniformid() {
		return uniformid;
	}

	public String getUniform_name() {
		return uniform_name;
	}

	public int getStock() {
		return stock;
	}

	public int getPrice() {
		return price;
	}

	public void setUniformid(int uniformid) {
		this.uniformid = uniformid;
	}

	public void setUniform_name(String uniform_name) {
		this.uniform_name = uniform_name;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

// 各設定と取得
