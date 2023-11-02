package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.ProdService;
import util.ScanUtil;
import util.View;
import vo.ProdBoard;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	ProdService prodService = ProdService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case ADMIN:
				view = admin();
				break;
			case MEMBER:
				view = home();
				break;
			case PROD_LIST:
				view = prodList();
				break;
				
			}
		}
	}

	private View prodList() {
		
		return null;
	}

	private View admin() {
		printAdmin();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.PROD_LIST;
		case 2:
			return View.MEMBER;
		default :
			return View.HOME;
		}
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.MEMBER;
		default :
			return View.HOME;
		}
	}
}
