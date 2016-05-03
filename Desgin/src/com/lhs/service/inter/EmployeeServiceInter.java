package com.lhs.service.inter;

import java.util.List;
import com.lhs.basic.BasicServiceInter;
import com.lhs.domain.Employee;
public interface EmployeeServiceInter extends BasicServiceInter{
	 //show
	 public List showEmployeeList(int pageSize,int pageNow);
	 
	 public int getPageCount(int pageSize);

//	 public List showEmployeeList1(String role, int pageSize, int pageNow);
	 
	 public List showEmployeeList2(String userId, int pageSize, int pageNow);
	 
	//显示经理下面有多少职工
	public List showEmployeeList3(String deport, int pageSize, int pageNow);
	public int getPageCount2(String deport, int pageSize);
	 
	 
}
