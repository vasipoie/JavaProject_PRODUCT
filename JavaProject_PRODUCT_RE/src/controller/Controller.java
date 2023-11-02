package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;
import util.ScanUtil;
import util.View;
import print.Print;
import service.ProductService;
import vo.Product;

public class Controller extends Print{
	
	static public Map<String, Object> sessionStorage = new HashMap<>();

	ProductService productService = ProductService.getInstance();
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 테이블 PRODUCT 만들기
		 * 
		 * 1. 전체 상품 조회	READ 
		 * 2. 재고관리			UPDATE, DELETE
		 * 3. 신규 상품 등록	CREATE
		 * 4. 상품구매			UPDATE
		 * 5. 구매 상품 조회	READ
		 * 6. 장바구니 조회		UPDATE
		 * 
		 * 
		 * No	상품명		가격		재고	상세설명
		 * 1	상품1		10000		 9
		 * 2	상품2		20000 		 17
		 * 3	상품3		30000		 21
		 * 
		 * 
		 */
		
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while(true){
			switch(view) {
			case HOME:
				view = home();
				break;
			case ADMIN:	//관리자페이지
				view = admin();
				break;
			case PROD_ALL:	//전체상품조회
				view = prodAll();
				break;
			case PROD_MEMBER:	//일반회원
				view = prodMember();
				break;
			case PROD_MANAGE:	//재고관리
				view = prodManage();
				break;
			case PROD_MOD: //재고수정
				view = prodMod();
				break;
			case PROD_MOD2: //재고수정
				view = prodMod2();
				break;
			}
		}
	}
	

	
	private View prodMod2() {
		
		return View.PROD_MOD;
	}

	//1.관리자-2.재고관리-1.재고수정
	private View prodMod() {
		List<Product> list = productService.stock();
		pirntStockList(list);
		System.out.println("-----------------------------");
		int prod_no  = ScanUtil.nextInt("수정을 원하는 No를 선택하세요\s");
		System.out.println("-----------------------------");
		String mod = ScanUtil.nextLine(prod_no+"번 상품 수정을 원하십니까?(Y/N)\s");
		if(mod.equals("Y")||mod.equals("y")) {
			sessionStorage.put("no", prod_no);
			productService.stockModify(prod_no);
		}
		System.out.println(prod_no+"번 상품이 수정되었습니다");
		return View.PROD_MOD;
	}


	//1.관리자-2.재고관리
//	private View prodManage() {
//		List<Product> list = productService.stock();
//		pirntStockList(list);
//		printStock();
//		System.out.println("-----------------------------");
//		int select  = ScanUtil.nextInt("원하는 번호를 선택하세요\s");
//		System.out.println("-----------------------------");
//		switch(select){
//		case 1:
//			return View.PROD_MOD;
//		case 2:
//			return View.PROD_SOLDOUT;
//		case 3:
//			return View.ADMIN;
//		case 4:
//			return View.HOME;
//		default :
//			return View.ADMIN;
//		}
//	}
	
	//1.관리자-2.재고관리
	private View prodManage() {
		List<Product> list = productService.stock();
		pirntStockList(list);
		String name = ScanUtil.nextLine("검색하고싶은 상품명을 입력하세요\s");
		List<Object> param = new ArrayList();
		param.add(name);
		List<Product> l = productService.prodSearchList(param);
//		System.out.println(l);
		printSelectSearch(l);
		return View.PROD_MOD2;
	}

	//1.관리자-1.전체 상품 조회
	private View prodAll() {
		List<Object> param = new ArrayList<Object>();
		int pageNo = 1;
		if(sessionStorage.containsKey("pageNo")) {
			pageNo = (int) sessionStorage.get("pageNo");
		}
		int start_no = 1+10*(pageNo-1);
		int last_no = 10*pageNo;
		param.add(start_no);
		param.add(last_no);
		List<Product> list = productService.admin(param);
		printList(list);	//페이징처리
		System.out.println("-----------------------------");
		int select = ScanUtil.nextInt("원하는 번호를 선택하세요\s");
		switch(select) {
		case 1:
			sessionStorage.put("pageNo", pageNo+1);
			return View.PROD_ALL;
		case 2:
			sessionStorage.put("pageNo", pageNo-1);
			return View.PROD_ALL;
		case 3:
			sessionStorage.remove("pageNo");
			return View.HOME;
		default:
			return View.ADMIN;
		}
	}

	//일반회원 페이지
	private View prodMember() {
		printMember();
		System.out.println("-----------------------------");
		int select  = ScanUtil.nextInt("원하는 번호를 선택하세요\s");
		System.out.println("-----------------------------");
		switch(select) {
		case 1:
			return View.PROD_ALL;
		case 2:
		}
		return null;
	}

	//관리자 페이지
	private View admin() {
		printAdmin();
		System.out.println("-----------------------------");
		int select  = ScanUtil.nextInt("원하는 번호를 선택하세요\s");
		System.out.println("-----------------------------");
		switch(select){
		case 1:
			return View.PROD_ALL;
		case 2:
			return View.PROD_MANAGE;
		case 3:
			return View.PROD_REGIS;
		case 4:
			return View.HOME;
		default :
			return View.ADMIN;
		}
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("번호를 선택하세요.\s");
		switch(select) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.PROD_MEMBER;
		default :
			return View.HOME;
		}
	}
	
}
