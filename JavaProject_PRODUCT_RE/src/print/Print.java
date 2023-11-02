package print;

import java.util.List;

import vo.Product;

public class Print {

		public void printHome() {
			System.out.println("-----------------------------");
			System.out.println("1. 관리자");
			System.out.println("2. 일반 회원");
			System.out.println("-----------------------------");
		}
		
		public void printList(List<Product> l) {
			//전체 상품 조회
			System.out.println("--------------------------------------------------------");
			System.out.println("No\t상품명\t가격\t재고\t상세설명");
			for(Product product : l) {
				System.out.println(product);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("-----------------------------");
			// 선택 메뉴 출력
			System.out.println("1. 다음페이지");
			System.out.println("2. 뒤로가기");
			System.out.println("3. 홈");
		}
		
		public void pirntStockList(List<Product> l) {
			System.out.println("--------------------------------------------------------");
			System.out.println("No\t상품명\t가격\t기본수량\t입고수량\t출고수량\t재고\t상세설명");
			for(Product product : l) {//Vo toString으로 가져오는거
				System.out.println(product.s1());
			}
			System.out.println("--------------------------------------------------------");
		}
		
		public void printSelectSearch(List<Product> l) {
			System.out.println("--------------------------------------------------------");
			System.out.println("No\t상품명\t가격\t기본수량\t입고수량\t출고수량\t재고\t상세설명");
			for(Product product : l) {
				System.out.println(product.s1());
			}
			System.out.println("--------------------------------------------------------");
		}
		
		public void printStock() {
			System.out.println("-----------------------------");
			System.out.println("1. 재고 수정");
			System.out.println("2. 품절 추가");
			System.out.println("-----------------------------");
		}
		
		
		public void printAdmin() {
			System.out.println("-----------------------------");
			System.out.println("1. 전체 상품 조회");
			System.out.println("2. 재고 관리");
			System.out.println("3. 신규 상품 등록");
			System.out.println("4. 뒤로가기");
			System.out.println("-----------------------------");
		}
	
	
		public void printMember() {
			System.out.println("-----------------------------");
			System.out.println("1. 전체 상품 조회");
			System.out.println("2. 상품 구매");
			System.out.println("3. 구매 상품 조회");
			System.out.println("3. 장바구니 조회");
			System.out.println("-----------------------------");
		}
	
	
}
