package com.remoteinteface;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-27
 * Time: 下午11:13
 * To change this template use File | Settings | File Templates.
 */
public class DemoInterfaceImpl implements DemoInterface {
    @Override
    public String getUser(int id) {
        return "user-"+ id;
    }
}
