package com.huawei.android.hicloud.common.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import p037bp.C1270a;
import p232dp.InterfaceC9285d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class CloudPushMsgService extends HmsMessageService {

    /* renamed from: com.huawei.android.hicloud.common.push.CloudPushMsgService$a */
    public static class C2759a extends AbstractC12367d {

        /* renamed from: a */
        public String f11986a;

        /* renamed from: b */
        public Context f11987b;

        public C2759a(Context context, String str) {
            this.f11986a = str;
            this.f11987b = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            C11839m.m70688i("CloudPushMsgService", "process push message begin");
            C2760a.m15777z(this.f11987b, this.f11986a);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.COMMON_PUSH;
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        C11839m.m70688i("CloudPushMsgService", "onMessageReceived");
        if (remoteMessage == null) {
            C11839m.m70687e("CloudPushMsgService", "remoteMessage is null");
            stopSelf();
        } else {
            C12515a.m75110o().m75175e(new C2759a(getApplicationContext(), remoteMessage.getData()), false);
            stopSelf();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        C11839m.m70688i("CloudPushMsgService", "onNewToken");
        InterfaceC9285d interfaceC9285d = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
        if (interfaceC9285d != null && !TextUtils.isEmpty(str)) {
            interfaceC9285d.mo17174g(getApplicationContext(), str, false);
        }
        stopSelf();
    }
}
