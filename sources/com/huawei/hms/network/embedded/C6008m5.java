package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.hms.network.inner.api.NetworkReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;

/* renamed from: com.huawei.hms.network.embedded.m5 */
/* loaded from: classes8.dex */
public class C6008m5 implements NetworkReceiver {

    /* renamed from: b */
    public static final String f27487b = "NetDiagBroadcaseReceive";

    /* renamed from: a */
    public C5995l5 f27488a;

    public C6008m5(C5995l5 c5995l5) {
        this.f27488a = c5995l5;
    }

    @Override // com.huawei.hms.network.inner.api.NetworkReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        Logger.m32143v(f27487b, "the broadcast has received the event!");
        String strM53579c = new SafeIntent(intent).m53579c();
        Message messageObtain = Message.obtain();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(strM53579c)) {
            Logger.m32143v(f27487b, "the action is error,please check your action!");
            return;
        }
        messageObtain.what = 1002;
        messageObtain.obj = C5863b6.m.f26476a;
        this.f27488a.m34661b(messageObtain);
    }
}
