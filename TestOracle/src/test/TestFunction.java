package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import org.junit.Test;
import demo.JDBCUtils;

public class TestFunction {
/*
 * create or replace function queryempincome(eno in number)
 */
	
	@Test
	public void testFunction(){
		//{?= call <procedure-name[(<arg1>,<arg2>,...)]>}
		String sql = "{? = call queryempincome(?)}";
		Connection conn = null;
		CallableStatement call = null;
		
		try {
			//得到数据库连接
			conn = JDBCUtils.getConnection();
			//基于连接创建statment
			call = conn.prepareCall(sql);
			
			//对于输出参数，申明
			call.registerOutParameter(1, OracleTypes.NUMBER);
			//对于输入参数，赋值
			call.setInt(2, 7839);
			//执行调用
			call.execute();
			//取出年收入的结果
			double income = call.getDouble(1);
			System.out.println("该员工的年收入是："+income);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, call, null);
		}
	}
}
