package com.huawei.hicloud.account.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p681uj.AbstractC13188e;

/* loaded from: classes5.dex */
public class ATTrafficController {

    /* renamed from: c */
    public static final ATTrafficController f22093c = new ATTrafficController();

    /* renamed from: a */
    public Map<String, AbstractC13188e> f22094a = new HashMap();

    /* renamed from: b */
    public NetworkChangeReceiver f22095b;

    public static class NetworkChangeReceiver extends SafeBroadcastReceiver {
        @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
        public void onReceiveMsg(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction()) && C0209d.m1333z1(context)) {
                for (Map.Entry<String, AbstractC13188e> entry : ATTrafficController.m29104b().m29106c().entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        AbstractC13188e value = entry.getValue();
                        if (value != null && value.mo65470f()) {
                            BaseLogger.m28733i("ATTrafficController", "onNetworkChange id=" + key + ",value=" + value.toString());
                            value.m79247k();
                        }
                    }
                }
            }
        }
    }

    public ATTrafficController() {
        m29109f();
    }

    /* renamed from: b */
    public static ATTrafficController m29104b() {
        return f22093c;
    }

    /* renamed from: a */
    public void m29105a(String str) {
        AbstractC13188e abstractC13188e = this.f22094a.get(str);
        if (abstractC13188e != null) {
            BaseLogger.m28733i("ATTrafficController", "clearFailEvent");
            abstractC13188e.m79246j();
        }
    }

    /* renamed from: c */
    public Map<String, AbstractC13188e> m29106c() {
        return this.f22094a;
    }

    /* renamed from: d */
    public String m29107d(String str) {
        AbstractC13188e abstractC13188e = this.f22094a.get(str);
        if (abstractC13188e == null) {
            return "";
        }
        BaseLogger.m28733i("ATTrafficController", "getSubPackageNameById");
        return abstractC13188e.mo65469d();
    }

    /* renamed from: e */
    public void m29108e(String str) {
        AbstractC13188e abstractC13188e = this.f22094a.get(str);
        if (abstractC13188e != null) {
            BaseLogger.m28733i("ATTrafficController", "processTrafficFail");
            abstractC13188e.m79243g();
        }
    }

    /* renamed from: f */
    public final void m29109f() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            this.f22095b = new NetworkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextM1377a.registerReceiver(this.f22095b, intentFilter, "com.huawei.hicloud.permission.AT_NETWORK_RECEIVE", null);
        }
    }

    /* renamed from: g */
    public void m29110g(String str, AbstractC13188e abstractC13188e) {
        this.f22094a.put(str, abstractC13188e);
    }
}
