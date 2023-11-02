package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ProductDao;
import util.ScanUtil;
import vo.Product;

public class ProductService {
	//얕은복사
	static public Map<String, Object> sessionStorage = Controller.sessionStorage;
	
	private static ProductService instance = null;
	private ProductService() {}
	public static ProductService getInstance() {
		if(instance == null) 
			instance = new ProductService();
		return instance;
	}
	
	// Dao를 부른다
	ProductDao dao = ProductDao.getInstance();
	
	public List<Product> admin(List<Object> param) {
		return dao.adminParam(param);
	}
	public List<Product> admin() {
		return dao.admin();
	}
	public List<Product> stock() {
		return dao.stock();
	}
	public void stockModify(int prod_no) {
		prod_no = (int)sessionStorage.get("no");
		String name = ScanUtil.nextLine("상품명 : ");
		int price = ScanUtil.nextInt("가격 : ");
		int prodi = ScanUtil.nextInt("입고수량 : ");
		int prodo= ScanUtil.nextInt("출고수량 : ");
		String prodexp= ScanUtil.nextLine("상품 설명 : ");
		
		List<Object> param = new ArrayList<Object>();
		param.add(name);
		param.add(price);
		param.add(prodi);
		param.add(prodo);
		param.add(prodexp);
		param.add(prod_no);
		
		stockUpdate(param);
	}
	public List<Product> prodSearchList(List<Object> param) {
		return dao.prodSearchList(param);
	}
	private void stockUpdate(List<Object> param) {
		dao.stockUpdate(param);
	}
	

	
	
	
}
