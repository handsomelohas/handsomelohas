package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.junit.Test;
import demo.JDBCUtils;
public class TestCursor {
/*
 * PACKAGE MYPACKAGE AS
  --把光标（cursor）的类型赋给empcursor
  type empcursor is ref cursor;
  procedure queryEmpList(dno in number,empList out empcursor);
  
  END MYPACKAGE;
 */
	@Test
	public void testCursor(){
		//{call <procedure-name>[(<arg1>,<arg2>,...)]}
		String sql = "{call MYPACKAGE.queryEmpList(?,?)}";
		
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			//获取数据库的连接
			conn = JDBCUtils.getConnection();
			//基于连接创建statement
			call = conn.prepareCall(sql);
			
			//对于in参数，赋值(10是部门号)
			call.setInt(1, 10);
			//对于out参数，申明
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//执行调用
			call.execute();
			
			//取出该部门中所有员工的信息
			rs = ((OracleCallableStatement)call).getCursor(2);
			while(rs.next()){
				//取出该员工的员工号，姓名、薪水和职位
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				double sal = rs.getDouble("sal");
				String job = rs.getString("ejob");
				
				System.out.println(empno+"\t"+name+"\t"+sal+"\t"+job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, call, rs);
		}
	}
}
