package com.remoteinteface;

import com.lamfire.hydra.rpc.ProviderConfig;
import com.lamfire.hydra.rpc.RpcServer;
import com.lamfire.hydra.rpc.ServiceRegistryConfig;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-27
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceServer {

    public static void main(String[] args) {
        ServiceRegistryConfig serviceRegistry = new ServiceRegistryConfig();
        serviceRegistry.registerService(DemoInterface.class,new DemoInterfaceImpl());

        ProviderConfig provider = new ProviderConfig("PROVIDER_01");
        provider.setPort(9999);
        provider.setServiceAddr("127.0.0.1");

        RpcServer server = new RpcServer();
        server.setProviderConfig(provider);
        server.setServiceRegistry(serviceRegistry);
        server.startup();
    }
}
