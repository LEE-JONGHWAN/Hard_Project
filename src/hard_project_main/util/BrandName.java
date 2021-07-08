package hard_project_main.util;

/**
 * 
 *하드디스크(예,{@code BrandName})의 종류 열거형
 * @author 이종환(Lee, JongHwan)
 *
 */

public enum BrandName {
		삼성전자("ㅅ"), WD("W"), 씨게이트("ㅆ"), 샌디스크("ㅅ");
		// 예문 : 부동산 일 경우 => 아파트, 단독, 빌라, 원룸, 투룸, 오피스텔 등등
		
		private String 단축명;
	
	private BrandName(String 단축명) {
		this.단축명 = 단축명;
	}
	public String get단축명() {
		return 단축명;
	}
	@Override
	public String toString() {
		return name() + "(" + get단축명() + ")";
	}

}