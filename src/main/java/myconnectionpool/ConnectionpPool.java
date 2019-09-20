package myconnectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ConnectionpPool implements  IConnectionPool{

    // 使用线程安全的集合 空闲线程 容器 没有被使用的连接存放
    private List<Connection> freeConnection = new Vector<Connection>();
    // 使用线程安全的集合 活动线程 容器 容器正在使用的连接
    private List<Connection> activeConnection = new Vector<Connection>();
    private DbBean dbBean;

    private int countConne = 0;

    public  ConnectionpPool (){

    }

    @Override
    public Connection getConnection() {
        return null;
    }
    // 判断连接是否可用
    public boolean isAvailable(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;

    }

    @Override
    public synchronized void releaseConnection(Connection connection) {

        if(isAvailable(connection)){
            //判断空闲线程是否已满
            if(freeConnection.size() < dbBean.getMaxConnections()){
                freeConnection.add(connection);
            }else {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                activeConnection.remove(connection);
                countConne--;//?
                this.notifyAll();//唤醒正在重试获得连接的线程
            }
        }

    }
}
