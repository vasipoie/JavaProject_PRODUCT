package vo;

public class Product {
	
	int no;
	String name;
	int price;
	int prodbase;
	int prodi;
	int prodo;
	int prodj;
	String prodexp;
	String prodsd;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public int getProdbase() {
		return prodbase;
	}
	public void setProdbase(int prodbase) {
		this.prodbase = prodbase;
	}


	public int getProdi() {
		return prodi;
	}
	public void setProdi(int prodi) {
		this.prodi = prodi;
	}


	public int getProdo() {
		return prodo;
	}
	public void setProdo(int prodo) {
		this.prodo = prodo;
	}


	public int getProdj() {
		return prodj;
	}
	public void setProdj(int prodj) {
		this.prodj = prodj;
	}


	public String getProdexp() {
		return prodexp;
	}
	public void setProdexp(String prodexp) {
		this.prodexp = prodexp;
	}

	public String getProdsd() {
		return prodsd;
	}
	public void setProdsd(String prodsd) {
		this.prodsd = prodsd;
	}
	
	
	@Override
	public String toString() {
		return no +"\t"+ name+"\t"+ price+"\t"+ prodj+"\t" + prodexp+"...";
	}
	
	public String s1() {
		return no +"\t"+ name+"\t"+ price+"\t\s"+ prodbase+"\t\t"+prodi+"\t\t"+prodo+"\t\t"+prodj+"\t" + prodexp;
	}
	
}
