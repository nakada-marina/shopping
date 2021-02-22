package bean;

public class ProductBean {

	
	private int product_id;
    private String name;
    private String info;
    private int price;
    private String url;
    private int del_flg;
    private String creation_time;
    private String update_time;
    
	/**
	 * @return product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id セットする product_id
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info セットする info
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url セットする url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return del_flg
	 */
	public int getDel_flg() {
		return del_flg;
	}
	/**
	 * @param del_flg セットする del_flg
	 */
	public void setDel_flg(int del_flg) {
		this.del_flg = del_flg;
	}
	/**
	 * @return creation_time
	 */
	public String getCreation_time() {
		return creation_time;
	}
	/**
	 * @param creation_time セットする creation_time
	 */
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	/**
	 * @return update_time
	 */
	public String getUpdate_time() {
		return update_time;
	}
	/**
	 * @param update_time セットする update_time
	 */
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
}
