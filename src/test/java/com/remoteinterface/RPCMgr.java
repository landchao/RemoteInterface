package com.remoteinterface;

import com.lamfire.hydra.rpc.HydraRPC;
import com.lamfire.hydra.rpc.ProviderConfig;

public class RPCMgr {

    static HydraRPC rpc = null;

    public static HydraRPC getRPC(){
        if(rpc != null){
            return rpc;
        }
        ProviderConfig provider = new ProviderConfig("PROVIDER_01");
        provider.setServiceAddr("127.0.0.1");
        provider.setPort(9999);

        rpc = new HydraRPC();
        rpc.addProvider(provider);
        return rpc;
    }
}
