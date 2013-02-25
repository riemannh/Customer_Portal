package com.res.sqlite;

import android.content.Context;
import com.res.sqlite.impl.DishOrderDAO;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: haoguanghao
 * Date: 13-2-21
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
public class DishOrderCleaner extends Thread {

    private static Context context = null;

    protected IDishOrderDAO dishOrderDAO = new DishOrderDAO(context);

    private static DishOrderCleaner cleanerThread;

    /**
     * 重写构造方法
     */
    private DishOrderCleaner() {
        Thread thread = new Thread(new cleanerRunnable());
        thread.start();
    }

    /**
     * 单例模式
     *
     * @param cont
     * @return
     */
    public static void startCleanerThread(Context cont) {
        context = cont;
        if (null == cleanerThread) {
            cleanerThread = new DishOrderCleaner();
        }
    }

    /**
     * 内部类,清理订单的处理动作
     */
    class cleanerRunnable implements Runnable {

        @Override
        public void run() {
            Date currentDate = new Date();
            String currentHour = currentDate.toString().substring(11, 13);
            if ("07".equals(currentHour)) {
                dishOrderDAO.deleteDishOrderListAll();
            }

            try {
                Thread.sleep(3600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
