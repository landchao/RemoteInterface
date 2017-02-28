package com.remoteinterface;

import com.lamfire.utils.OPSMonitor;
import com.lamfire.utils.Threads;
import com.remoteinteface.DemoInterface;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-27
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class ProformanceTest implements Runnable{
    static OPSMonitor monitor = new OPSMonitor("1");
    @Override
    public void run() {
        DemoInterface d = RPCMgr.getRPC().lookup(DemoInterface.class);
        while(true){
            d.getUser(0)   ;
            monitor.done();
        }
    }

    public static void main(String[] args) {
        monitor.setInterval(1);
        monitor.debug(true);
        monitor.startup();
        ThreadPoolExecutor executor = Threads.newFixedThreadPool(10);
        Runnable run = new ProformanceTest();
        for(int i=0;i<10;i++){
            executor.submit(run);
        }
    }
}
