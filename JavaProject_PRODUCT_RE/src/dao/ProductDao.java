package dao;

import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Product;

public class ProductDao {
	// 싱글톤 패턴을 만든다.
		private static ProductDao instance = null;
		private ProductDao() {}
		public static ProductDao getInstance() {
			if(instance == null) 
				instance = new ProductDao();
			return instance;
		}
		
		// JDBC를 부른다.
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public List<Product> adminParam(List<Object> param) {
			String sql = "SELECT *\r\n" + 
					"from (select rownum rnum, a.*\r\n" + 
					"from(select no, name, price, prodbase, prodi, prodo, \r\n" + 
					"(prodbase+prodi-prodo) prodj, SUBSTR(prodexp,0,10) prodexp\r\n" + 
					"from product) a)\r\n" + 
					"where rnum>=? and rnum<=?";
			List<Map<String, Object>> l = jdbc.selectList(sql, param);
			return ConvertUtils.convertToList(l, Product.class);
		}
		public List<Product> admin() {
			String sql = "select no, name, price, prodbase, prodi, prodo, \r\n" + 
						"(prodbase+prodi-prodo) prodj, SUBSTR(prodexp,0,10) prodexp\r\n" + 
						"from product";
			List<Map<String, Object>> l = jdbc.selectList(sql);
			return ConvertUtils.convertToList(l, Product.class);
		}
		public List<Product> stock() {
			String sql = "select no, name, price, prodbase, prodi, prodo, "
					+ 	 "(prodbase+prodi-prodo) prodj, prodexp\r\n" 
					+ 	 "from product";
			List<Map<String, Object>> l = jdbc.selectList(sql);
			return ConvertUtils.convertToList(l, Product.class);
		}
		public void stockUpdate(List<Object> param) {
			String sql = "update product\r\n" + 
					"set name = ?,\r\n" + 
					"    price = ?,\r\n" + 
					"    prodi = ?,\r\n" + 
					"    prodo = ?,\r\n" + 
					"    prodexp = ?\r\n" + 
					"where no = ?";
			jdbc.update(sql,param);
		}
		public List<Product> prodSearchList(List<Object> param) {
			String sql = "select no, name, price, prodbase, prodi, prodo, \r\n" + 
					"        (prodbase+prodi-prodo) prodj, SUBSTR(prodexp,0,10) prodexp\r\n" + 
					"from product\r\n" + 
					"where name like'%'||?||'%'";
			List<Map<String, Object>> l = jdbc.selectList(sql,param);
			return ConvertUtils.convertToList(l, Product.class);
		}
	
		
		
		
		
		
		
}
