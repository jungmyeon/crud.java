package Dao;

import java.util.List;
import Bean.bean;

public interface Dao {
	void addInfo(bean bean1);
	List<bean> searchInfo();
	void modifyInfo(bean bean1);
	void deleteInfo(int no);
}
