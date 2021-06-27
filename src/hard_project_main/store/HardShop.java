package hard_project_main.store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

import hard_project_main.util.BrandName;

/**
 * 
 * 이곳은 메인 프로젝트를 실행할 공간입니다.
 * 모든 것을 만들 때 주석을 달며 어떤 의미로 썼는지 체크해 봅시다.
 * 
 * @author 이종환(Lee JongHwan)
 * @version 1.0.0
 *
 */
public class HardShop {

	public static void main(String[] args) {
		
		/**
		 * 하기의 입력은 클래스 정의를 간단하게 하기 위해서 
		 * 만드는 함수이다.
		 */
		var hshop = new HardShop();
		
		/**
		 * 
		 * 이곳은 하드디스크 전문 스토어이다.
		 * 첫번째로 스토어의 환영 인사말로 시작한다.
		 * System.out.println("=".repeat(20)); 문의 repeat(20)은 반복문으로서
		 * 의미 없이 반복 해서 출력해야 하는 String문에 입력하면 문자수를 줄일수 있다.
		 * 그럼 이제 만들어 보자.
		 * 
		 */
		System.out.println("=".repeat(20));
		System.out.println("하드디스크 전문 스토어에 오신걸 환영합니다!");
		System.out.println("=".repeat(20));
		System.out.println("\n");
		
		/*
		 * 입력문을 받아야 하기에 그 입력 받고 출력하는 곳을 내부에 클래스 문으로 입력하자.
		 * [Selection]이라는 메소드로 만들어 그것을 불러내 보자.
		 * hshop.Selection();은 [Selection]이란 메소드를 불러내는 것이다.
		 */
		hshop.Selection();
		
		/**
		 * [BrandName]의 Enum문이 null일때 do while 문을 실행한다.
		 */
		BrandName type = null;
		do {
			type = hshop.getHardSelection();
		} while (type == null);
		System.out.println("당신이 주문한 " + type + "을 준비할께요.");
	}
	
		private BrandName getHardSelection() {
			//@formatter:off
		Scanner scanner = new Scanner(System.in);
		String selection = scanner.nextLine();
		
		selection = selection.trim();
		for (var type : BrandName.values()) {
			if (type.get단축명().equals(selection) || 
					type.name().indexOf(selection) >= 0) {
				System.out.println(type + "?");
				if (selectionConfirmed(type, scanner))
					return type;
			}
		}
		return null;
		//@formatter:on
	}
	
	
	
	/**
	 * 고객이 원하는 하드디스크가 맞는지 확인한다.
	 * 
	 * @param type    고객이 선택한 하드디스크 종류
	 * @param scanner 고객 입력 접수용 참조
	 * @return 맞으면 참, 아니면 거짓
	 */
	private boolean selectionConfirmed(BrandName type, Scanner scanner) {
		System.out.println(type + "을 선택하셨습니까?[Y/n] : ");

		String input = scanner.nextLine();

		if (input != null) {
			input = input.trim().toLowerCase();
			if (input.length() == 0 || input.equals("y"))
				return true;
		}
		return false;
	}
	
	
	
	private void Selection() {
		//[todays]로 오늘자 요일을 출력하기 위해서 사용한다.
		LocalDate todays = LocalDate.now();
		//@formatter:off
		
		//오늘 자 요일을 출력하기 위한 함수이다.
		//ofPattern("E")의 E 는 요일을 출력하기 위한 문자이다.
		String weekDay = todays.format(DateTimeFormatter.
				ofPattern("E").withLocale(Locale.KOREAN));
		
		System.out.println("=".repeat(33));
		System.out.println("다음 하드디스크 메이커 중에서 선택하세요:");
		System.out.println("=".repeat(33));
		System.out.println(" * : '" + weekDay + "'요일 특별 할인 하드디스크!");
		
		BrandName[] brandNames = BrandName.values();
		long specialInx = ChronoUnit.DAYS.between(todays, 
				LocalDate.of(2021, 6, 22)) % brandNames.length;
		//@formatter:on
		for (int i = 0; i < brandNames.length; i++) {
			var hrMenu = new StringBuffer(" -");
			hrMenu.append(brandNames[i]);
			if (i == specialInx)
				hrMenu.append("*");
			System.out.println(hrMenu);
		}
		System.out.println("=".repeat(40));
		System.out.print("단축명(ㄱ-ㅎ), 이름(일부/전부) :");
		
		
		
		
	}

}
