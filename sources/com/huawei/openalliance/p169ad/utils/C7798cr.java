package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.util.Log;
import com.huawei.openalliance.p169ad.C7384ld;
import com.huawei.openalliance.p169ad.C7385le;
import com.huawei.openalliance.p169ad.net.http.HttpsConfig;
import java.io.IOException;

/* renamed from: com.huawei.openalliance.ad.utils.cr */
/* loaded from: classes2.dex */
public class C7798cr {
    /* renamed from: a */
    public static void m48109a(Context context) {
        String str;
        try {
            Context applicationContext = context.getApplicationContext();
            HttpsConfig.m45965a(C7384ld.m45468a(applicationContext));
            HttpsConfig.m45966a(new C7385le(applicationContext));
        } catch (IOException unused) {
            str = "SecureSSLSocketFactory create fail io";
            Log.w("SecurityHttpsConfig", str);
        } catch (Exception unused2) {
            str = "SecureSSLSocketFactory create fail";
            Log.w("SecurityHttpsConfig", str);
        }
    }
}
