package Main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import Bean.bean;
import Function.FunctionImpl;

public class main {
	BufferedReader in;
	public main() {
		in = new BufferedReader(new InputStreamReader(System.in));
		info();		
	}
	
	private void searchInfo() {
		List<bean>list = FunctionImpl.getFunction().searchInfo();
		System.out.println("*************학생정보****************");
		if(list == null || list.isEmpty()) {
				System.out.println("아무 정보가 없습니다. ");
			}else {
				for(bean article : list) {
				System.out.println(article);				
			}
		}
	}
	
	private void addInfo() throws Exception{
		bean bean1 = new bean();
		System.out.println("***************글등록***************");
		System.out.println("id");
		bean1.setId(Integer.parseInt(in.readLine()));
		System.out.println("Name");
		bean1.setName(in.readLine());
		System.out.println("Age");
		bean1.setAge(Integer.parseInt(in.readLine()));
		System.out.println("major");
		bean1.setMajor(in.readLine());
		FunctionImpl.getFunction().addInfo(bean1);
		System.out.println(bean1);
	}
	
	public void modifyInfo() throws Exception{
		bean bean1 = new bean();
		System.out.println("수정 할 Id: ");
		bean1.setId(Integer.parseInt(in.readLine()));
		System.out.println("수정 이름 : ");
		bean1.setName(in.readLine());
		System.out.println("수정 나이 : ");
		bean1.setAge(Integer.parseInt(in.readLine()));
		System.out.println("수정 major : ");
		bean1.setMajor(in.readLine());
		FunctionImpl.getFunction().modifyInfo(bean1);
	}
	
	public void deleteInfo() throws Exception{
		System.out.println("삭제할 Id : ");
		int no = Integer.parseInt(in.readLine());
		FunctionImpl.getFunction().deleteInfo(no);
	}
	
	
	private void info() {
		while(true) {
			System.out.println("------------학생정보-------------");
			System.out.println("1. 학생정보 조회");
			System.out.println("2. 학생정보 추가");
			System.out.println("3. 학생정보 수정");
			System.out.println("4. 학생정보 삭제");
			System.out.println("0. 학생정보 종료");
			System.out.print("기능 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : searchInfo();
				break;
				case 2 : addInfo();
				break;
				case 3 : modifyInfo();
				break;
				case 4 : deleteInfo();
				break;
				default: System.exit(0);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}


 public static void main(String[] args) {
	 new main();
}

}

