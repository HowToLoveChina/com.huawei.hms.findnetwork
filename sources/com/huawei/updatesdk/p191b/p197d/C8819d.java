package com.huawei.updatesdk.p191b.p197d;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.updatesdk.p177a.p178a.p179b.C8776b;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import java.io.File;
import java.net.HttpURLConnection;

/* renamed from: com.huawei.updatesdk.b.d.d */
/* loaded from: classes9.dex */
public class C8819d {

    /* renamed from: com.huawei.updatesdk.b.d.d$a */
    public static class a {

        /* renamed from: a */
        private static final C8819d f45158a = new C8819d();
    }

    /* renamed from: a */
    public static C8819d m56260a() {
        return a.f45158a;
    }

    /* renamed from: b */
    public static String m56261b() {
        String strM56134b = C8793a.m56132c().m56134b();
        if (TextUtils.isEmpty(strM56134b)) {
            return "";
        }
        String str = strM56134b + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    /* renamed from: a */
    public HttpURLConnection m56262a(String str) {
        HttpURLConnection httpURLConnectionM56015a = C8776b.m56015a(str, C8793a.m56132c().m56133a());
        httpURLConnectionM56015a.setConnectTimeout(7000);
        httpURLConnectionM56015a.setReadTimeout(10000);
        httpURLConnectionM56015a.setUseCaches(false);
        httpURLConnectionM56015a.setDoInput(true);
        httpURLConnectionM56015a.setRequestProperty(C5966j2.f27080v, "identity");
        httpURLConnectionM56015a.setInstanceFollowRedirects(true);
        return httpURLConnectionM56015a;
    }
}
