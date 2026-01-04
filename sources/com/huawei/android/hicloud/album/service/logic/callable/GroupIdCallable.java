package com.huawei.android.hicloud.album.service.logic.callable;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.p069cg.logic.app.HmsSnsApp;
import com.huawei.android.p069cg.request.threadpool.AbstractC2328i;

/* loaded from: classes2.dex */
public class GroupIdCallable extends AbstractC2328i {
    private CallbackHandler callbackHandler;

    public GroupIdCallable(CallbackHandler callbackHandler) {
        super(null);
        this.callbackHandler = callbackHandler;
    }

    @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
    public Object call() throws Exception {
        String[] strArrM14425e = HmsSnsApp.m14419h().m14425e();
        if (this.callbackHandler == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("SnsGroups", strArrM14425e);
        this.callbackHandler.sendMessage(9080, bundle);
        return null;
    }
}
