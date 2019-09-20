package myconnectionpool;

import java.sql.Connection;

/**
 * 自定义数据库连接池
 */
public interface IConnectionPool {


     Connection getConnection();

     void releaseConnection(Connection connection);

}
