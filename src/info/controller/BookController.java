package info.controller;
//콘솔로 작성 
import java.util.ArrayList;
import java.util.Scanner;

import info.view.BookView;
import info.vo.BookDAO;
import info.vo.BookVO;

// javax.swing.JTable(행, 열로 data를 출력하는 컴포넌트)
// javax.swing.JTextField(값 입력, 컴포넌트)
// javax.swingn.JComboBox(콤보박스 컴포넌트)

public class BookController {
	
	public static final int CONTINUE = 1;
	public static final int BREAK = 0;

	
	//여러 학생 정보(동적 인원 수)를 입력 받기 위해서 ArrayList 객체 생성 
	ArrayList<Integer> isbnes = new ArrayList<Integer>();
	ArrayList<String> bookNames = new ArrayList<String>();
	ArrayList<String> publisher = new ArrayList<String>();
	ArrayList<String> authors = new ArrayList<String>();
	ArrayList<Integer> prices = new ArrayList<Integer>();
	ArrayList<String> categories = new ArrayList<String>();
	
	// 콘솔창에서 입력받은 학생정보를 사용하여 각각의 ArrayList에 저장해 둔다. 
	public void consoleToList() {
		// 콘솔에 입력 받기 위해 Scanner 생성 
		Scanner s1 = new Scanner(System.in); // 문자열 입력용
		Scanner s2 = new Scanner(System.in); // 숫자 입력용


		// flag변수 : 콘솔 창에서 학생정보를 입력 받을때 계속 입력 받을 것인지 멈출 것인지의 상태를 저장하는 변수 
		int flag = CONTINUE;
		System.out.println("==========도서 정보 입력==========");
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("** 도서번호 입력 : ");
				isbnes.add(s2.nextInt());
				System.out.print("** 도서명 입력 : ");
				bookNames.add(s1.nextLine());
				System.out.print("** 출판사 입력 : ");
				publisher.add(s1.nextLine());
				System.out.print("** 저자 입력 : ");
				authors.add(s1.nextLine());
				System.out.print("** 가격 입력 : ");
				prices.add(s2.nextInt());
				System.out.print("** 분야 입력 : ");
				categories.add(s1.nextLine());
			}else if(flag ==BREAK) {
				break;
			}
			System.out.print("계속 도서 정보를 입력 받으시겠습니까?(계속 : 1, 중지 : 0 ) : ");
			flag = s2.nextInt();
		}
		s1.close();
		s2.close();

}
// StudentVO객체를 생성하고 
// 생성된 StudentVO객체를 StudentDAO 객체의 ArrayList에 저장한다.(insert()사용)

	public void voToDAO(BookDAO dao) {

		for (int i = 0; i < isbnes.size(); i++) {
			BookVO bvo = new BookVO(isbnes.get(i), bookNames.get(i), publisher.get(i), prices.get(i), authors.get(i), categories.get(i));
			dao.insert(bvo);
		}
	}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			// 콘솔창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메소드 
			BookController controller = new BookController();
			controller.consoleToList();
			// 입력 받은 값들을 사용하여 StudentVO객체를 생성하여 DAO의 ArrayList에 저장하는 메소드 
			BookDAO dao = new BookDAO();
			controller.voToDAO(dao);
			// 화면에 출력 
			BookView bView= new BookView();
			bView.view(dao.select());
		}

	}