package cn;

import java.util.ArrayList;

public interface QxcnoIn {
	public ArrayList<QxcnoBean> findByPage(int page);
	public int userCount();
}
