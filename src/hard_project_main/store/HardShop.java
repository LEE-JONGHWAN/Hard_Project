package hard_project_main.store;

import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jbpark.dabang.store.TeaInputException;
import com.jbpark.dabang.utility.TeaType;
import com.jhlee.utility.JH_FileHandler;

import hard_project_main.util.BrandName;
import jbpark.utility.SuffixChecker;

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
	private static Logger logger 
	= Logger.getLogger("hard_project_main.store");
{
	logger.setLevel(Level.INFO);
	logger.setUseParentHandlers(false);
	int LOG_ROTATION_COUNT = 10;
	JH_FileHandler handler;
	try {
		String logFile = "D:/LOG/JB_Dabang"; 
		System.out.println("로그파일: " 
				+ logFile + ".*.log.*");
		handler = new JH_FileHandler(
				logFile + ".%g.log", 0, 
				LOG_ROTATION_COUNT);
		handler.setLevel(Level.INFO);
		logger.addHandler(handler);
	} catch (SecurityException | IOException e) {
		e.printStackTrace();
	}
}
	
	
	public static void main(String[] args) {
		var hshop = new HardShop();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				hshop.serveOneCustomer(scanner);
				for (int i = 0; i<3; i++) {
					System.out.println(".");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {}
				}
			}
		}
	}

	private void serveOneCustomer(Scanner scanner) {
		System.out.println("다음 손님 어서오세요...");
		System.out.println("J.H.하드스토어가 당신을 환영합니다");

		BrandName type = null;  
		
		do {
			showHardSelection();
			try {
				type = getHardSelection(scanner);
			} catch (HardInputException te) {
				String msg = "'는 잘못된 입력입니다. 다시 선택해 주세요.";
				System.out.println("'" + te.getMessage() + msg);
				continue;
			}
			if (type == null) {
				if (getUserResponse("주문을 원치 않으십니까",
						scanner))
					break;
			} else 
				break;
		} while (true);
		
		if (type == null)
			System.out.println("안녕히 가십시오.");
		else {
			String tea = type.name();
			int idx = tea.length() - 1;
			int cp = tea.codePointAt(idx);
			String msg = "당신이 주문한 '" 
					+ tea
					+ (SuffixChecker.has받침(cp, 
						tea.substring(idx)) ? "'을" : "'를") 
				+ " 준비할께요.";
			DateTimeFormatter dtf 
				= DateTimeFormatter.ofPattern("HH:mm");
			String timeLabel = LocalTime.now().format(dtf);
			logger.info(msg + ", 주문 시각: " + timeLabel);
			System.out.println(msg);
		}
		Toolkit.getDefaultToolkit().beep();
	}

	
		private BrandName getHardSelection(Scanner scanner) 
				throws HardInputException {
			String selection = 입력접수(scanner);

			if (selection.isEmpty()) {
				return null;
			}
			for (var type : BrandName.values()) {
				if (type.get단축명().equals(selection) || 
						type.name().indexOf(selection) >= 0) {
					String teaLong = type.toString();
					int idx = teaLong.indexOf('(');
					int cp = teaLong.codePointAt(--idx);
					String sfx = SuffixChecker.has받침(
							cp, teaLong.substring(idx))
							? "을" : "를";
					String msg = type + sfx + " 선택하셨습니까";
					boolean resp = getUserResponse(msg, scanner);
					
					if (resp)
						return type;
					else
						return null;
				}
			}
			throw new HardInputException(selection);
	}
	
		private String 입력접수(Scanner scanner) {
			String 고객입력 = "";
			try {
				if (scanner.hasNextLine()) {
					고객입력 = scanner.nextLine();
					고객입력 = 고객입력.trim();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return 고객입력;
		}
	
		/**
		 * 고객의 의사를 확인한다. 고객 입력 문자가 'Y', 'y', 'N', 'n' 문자 
		 * 혹은 [엔터] 키가 아니면 재 입력을 요구한다.
		 * 
		 * @param type    고객이 선택한 차 종류
		 * @param scanner 고객 입력 접수용 참조
		 * @return 참: 'Y', 'y', [엔터]키 일 때, 
		 * 		   거짓: 'N', 'n'일 때.
		 */
		private boolean getUserResponse(String question, 
				Scanner scanner) {
			String input;
			boolean validInput = true;
			
			do {
				if (!validInput) {
					Toolkit.getDefaultToolkit().beep();
					System.out.println("입력 오류입니다. 다시 입력해 주세요");
				}
				System.out.println(question + "?");
				System.out.print("Y/y/[엔터]=예; N/n=아니오: ");
				input = 입력접수(scanner);
				if (input != null) {
					input = input.trim().toLowerCase();
				}
				validInput = "y".equals(input) 
						|| "n".equals(input)
						|| (input != null && input.isEmpty());
			} while (!validInput);

			if (input != null) {
				input = input.trim().toLowerCase();
				if (input.length() == 0 
						|| input.equals("y"))
					return true;
			}
			assert "n".equals(input)
					: "'부정' 의사 표시로 부적절한 문자 입력!";
			return false;
		}
	
	
	
	private void showHardSelection() {
		LocalDate today = LocalDate.now();
		String weekDay = today.format(DateTimeFormatter
				.ofPattern("E").withLocale(Locale.KOREAN)); //E:요일
		
		System.out.println("=".repeat(40));
		System.out.println("다음 하드디스크 종류 중에서 선택하세요:");
		System.out.println("=".repeat(40));
		System.out.println(" * : '" + weekDay + "'요일 특별 하드디스크!");

		BrandName[] brandNames = BrandName.values();
		long specialInx = ChronoUnit.DAYS.between(
				LocalDate.of(2021, 6, 22), today) 
				% brandNames.length;
		int brandCount = brandNames.length;
		
		for (int i = 0; i < brandCount; i++) {
			var teaMenu = new StringBuffer(" -");
			teaMenu.append(brandNames[i]);
			if (i == specialInx)
				teaMenu.append("*");
			System.out.println(teaMenu);
		}
		System.out.println(" -메뉴 선택 안함([엔터])");
		System.out.println("=".repeat(40));
		System.out.print("단축명(ㄱ-ㅎ), 이름(일부/전부): ");
	}

}
