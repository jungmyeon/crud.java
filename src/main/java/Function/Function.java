package Function;

import java.util.List;
import Bean.bean;


public interface Function {
	void addInfo(bean bean1);
	List<bean> searchInfo();
	void modifyInfo(bean bean1);
	void deleteInfo(int no);
}
