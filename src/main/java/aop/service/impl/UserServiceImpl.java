package aop.service.impl;

import aop.mytransaction.ExtTransation;
import aop.service.UserService;


//user 服务层
public class UserServiceImpl implements UserService {


	// spring 事务封装呢？ aop技术
	// public void add() {
	// TransactionStatus transactionStatus = null;
	// try {
	// // 开启事务
	// transactionStatus = transactionUtils.begin();
	// userDao.add("test001", 20);
	// System.out.println("开始报错啦!@!!");
	// // int i = 1 / 0;
	// System.out.println("################");
	// userDao.add("test002", 21);
	// // 提交事务
	// if (transactionStatus != null)
	// transactionUtils.commit(transactionStatus);
	// } catch (Exception e) {
	// e.getMessage();
	// // 回滚事务
	// if (transactionStatus != null)
	// transactionUtils.rollback(transactionStatus);
	// }
	// }

	@Override
    @ExtTransation
    public void add() {
		// 注意事项： 在使用spring事务的时候，service 不要try 最将异常抛出给外层aop 异常通知接受回滚
		/*try {
			//userDao.add("test001", 20);
			int i = 1 / 0;
			//userDao.add("test002", 21);
		} catch (Exception e) {
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}*/
	/*	int i=1/0;*/
	}

}
