package service;

import java.util.List;

import dao.ProdDAO;
import vo.ProdBoard;

public class ProdService {
	// 싱글톤 패턴을 만든다.
	private static ProdService singletTon = null;
	private ProdService() {}
	public static ProdService getInstance() {
		if(singletTon == null) 
			singletTon = new ProdService();
		return singletTon;
	}
	
	// Dao를 부른다
	ProdDAO dao = ProdDAO.getInstance();
}
