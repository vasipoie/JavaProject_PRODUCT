package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.ProdBoard;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class ProdDAO {
	// 싱글톤 패턴을 만든다.
	private static ProdDAO singleTon = null;
	private ProdDAO() {}
	public static ProdDAO getInstance() {
		if(singleTon == null) 
			singleTon = new ProdDAO();
		return singleTon;
	}
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
}
