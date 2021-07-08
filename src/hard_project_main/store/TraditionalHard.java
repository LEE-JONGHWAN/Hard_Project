package hard_project_main.store;

import java.time.LocalDate;

public class TraditionalHard {
	private String 제품코드; // 제품 코드
	private String 제품이름; // 제품 이름(예, 율무차)
	private String 제품설명; // 최대 500 글자
	private double 제품가격; // 개당 가격
	private int 하드디스크중량; // 용량, 단위: 그램
	private int 재고하드디스크수량 = 0; // 단위: KG
	private int 누적판매수 = 0; // 누적판매 하드디스크 수
	private LocalDate 제조일 = null; // 제품 제조일자
	private LocalDate 등록일; // 제품 등록 일자
	// 이미지(jpg, png, bmp)
	// 설명 odt 파일
	public TraditionalHard(String 제품코드, String 제품이름, String 제품설명, double 제품가격, int 하드디스크중량, int 재고하드디스크수량, int 누적판매수,
			LocalDate 제조일, LocalDate 등록일) {
		super();
		this.제품코드 = 제품코드;
		this.제품이름 = 제품이름;
		this.제품설명 = 제품설명;
		this.제품가격 = 제품가격;
		this.하드디스크중량 = 하드디스크중량;
		this.재고하드디스크수량 = 재고하드디스크수량;
		this.누적판매수 = 누적판매수;
		this.제조일 = 제조일;
		this.등록일 = 등록일;
	}
	public String get제품코드() {
		return 제품코드;
	}
	public void set제품코드(String 제품코드) {
		this.제품코드 = 제품코드;
	}
	public String get제품이름() {
		return 제품이름;
	}
	public void set제품이름(String 제품이름) {
		this.제품이름 = 제품이름;
	}
	public String get제품설명() {
		return 제품설명;
	}
	public void set제품설명(String 제품설명) {
		this.제품설명 = 제품설명;
	}
	public double get제품가격() {
		return 제품가격;
	}
	public void set제품가격(double 제품가격) {
		this.제품가격 = 제품가격;
	}
	public int get하드디스크중량() {
		return 하드디스크중량;
	}
	public void set하드디스크중량(int 하드디스크중량) {
		this.하드디스크중량 = 하드디스크중량;
	}
	public int get재고하드디스크수량() {
		return 재고하드디스크수량;
	}
	public void set재고하드디스크수량(int 재고하드디스크수량) {
		this.재고하드디스크수량 = 재고하드디스크수량;
	}
	public int get누적판매수() {
		return 누적판매수;
	}
	public void set누적판매수(int 누적판매수) {
		this.누적판매수 = 누적판매수;
	}
	public LocalDate get제조일() {
		return 제조일;
	}
	public void set제조일(LocalDate 제조일) {
		this.제조일 = 제조일;
	}
	public LocalDate get등록일() {
		return 등록일;
	}
	public void set등록일(LocalDate 등록일) {
		this.등록일 = 등록일;
	}
	
	
	
}
