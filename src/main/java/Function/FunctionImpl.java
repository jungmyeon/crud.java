package Function;

import java.util.List;
import Bean.bean;
import Dao.DaoImpl;

public class FunctionImpl implements Function {
	private static Function function = new FunctionImpl();
	
	public static Function getFunction() {
		return function;
	}
	
	public void addInfo(bean bean1) {
		// TODO Auto-generated method stub
		DaoImpl.getdao().addInfo(bean1);
	}

	public List<bean> searchInfo() {
		// TODO Auto-generated method stub
		return DaoImpl.getdao().searchInfo();
	}

	public void modifyInfo(bean bean1) {
		// TODO Auto-generated method stub
		DaoImpl.getdao().modifyInfo(bean1);
	}

	public void deleteInfo(int no) {
		// TODO Auto-generated method stub
		DaoImpl.getdao().deleteInfo(no);
	}
	
}
