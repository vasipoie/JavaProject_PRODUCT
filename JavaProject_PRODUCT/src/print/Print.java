package print;

public class Print {
	

	public void printHome() {
		System.out.println("----------------------------------");
		System.out.println("1. 관리자");
		System.out.println("2. 일반 회원");
		System.out.println("----------------------------------");
	}

	
	public void printAdmin() {
		System.out.println("----------------------------------");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 재고 관리");
		System.out.println("3. 신규 상품 등록");
		System.out.println("----------------------------------");
	}
	
	public void printMember() {
		System.out.println("----------------------------------");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 상품 구매");
		System.out.println("3. 구매 상품 조회");
		System.out.println("4. 장바구니 조회");
		System.out.println("----------------------------------");
	}
	
}
