package com.remoteinterface;

import com.remoteinteface.DemoInterface;

public class InterfaceClient {

    public static void main(String[] args) {
        DemoInterface demoInterface = RPCMgr.getRPC().lookup(DemoInterface.class);
        String user = demoInterface.getUser(10);
        System.out.println(user);

    }
}
