package cn;

import java.util.ArrayList;

public interface QxchisIn {
	public ArrayList<QxchisBean> findByPage(int page);
	public int userCount();
}
