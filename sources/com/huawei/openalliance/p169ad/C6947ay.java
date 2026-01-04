package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ay */
/* loaded from: classes8.dex */
public class C6947ay extends AbstractC6912ag {
    public C6947ay() {
        super("pps.download.resume");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        final C7306i c7306iM38795d = m38795d(context, str);
        final int[] iArr = {-1};
        boolean zOptBoolean = new JSONObject(str).optBoolean(JsbMapKeyNames.ALLOWED_NON_WIFI_NETWORK, false);
        if (c7306iM38795d == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 1000, Integer.valueOf(iArr[0]), true);
            return;
        }
        if (c7306iM38795d.getAppInfo() != null) {
            c7306iM38795d.getAppInfo().setAllowedNonWifiNetwork(zOptBoolean);
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    iArr[0] = C6947ay.this.m38796e(context, str).mo42480b(context, c7306iM38795d);
                } catch (Throwable unused) {
                }
                AbstractC7326j.m45216a(remoteCallResultCallback, C6947ay.this.f34112a, 1000, Integer.valueOf(iArr[0]), true);
            }
        });
    }
}
