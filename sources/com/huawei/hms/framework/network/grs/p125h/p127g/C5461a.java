package com.huawei.hms.framework.network.grs.p125h.p127g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p373iu.C10618f;
import p406ju.C10929a;

/* renamed from: com.huawei.hms.framework.network.grs.h.g.a */
/* loaded from: classes8.dex */
public class C5461a {

    /* renamed from: a */
    private static final HostnameVerifier f25008a = new C10929a();

    /* renamed from: a */
    public static HostnameVerifier m32335a() {
        return f25008a;
    }

    /* renamed from: a */
    public static SSLSocketFactory m32336a(Context context) {
        try {
            return new C10618f(new SecureX509TrustManager(context.getAssets().open(GrsApp.getInstance().getBrand("/") + "grs_root.bks"), ""), C10048b.m62471c());
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }
}
