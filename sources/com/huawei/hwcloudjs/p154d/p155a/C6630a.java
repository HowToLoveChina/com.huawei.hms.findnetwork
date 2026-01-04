package com.huawei.hwcloudjs.p154d.p155a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hwcloudjs.p151b.C6617a;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.hwcloudjs.d.a.a */
/* loaded from: classes8.dex */
public class C6630a {

    /* renamed from: a */
    private static final String f30815a = "AuthCache";

    /* renamed from: b */
    private static final String f30816b = "jssdkcache";

    /* renamed from: c */
    private static final long f30817c = 86400000;

    /* renamed from: c */
    private String m37779c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes(Constants.UTF_8), 2);
        } catch (UnsupportedEncodingException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: d */
    private String m37780d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strM37779c = m37779c(str);
        if (TextUtils.isEmpty(strM37779c)) {
            return str;
        }
        return m37777a(C6617a.m37753a(), f30816b) + strM37779c;
    }

    /* renamed from: e */
    private void m37781e(String str) {
        String strM37780d = m37780d(str);
        if (strM37780d == null) {
            return;
        }
        File file = new File(strM37780d);
        if (!file.exists() || file.delete()) {
            return;
        }
        C6659d.m37881b(f30815a, "removeFile error", true);
    }

    /* renamed from: a */
    public AuthBean m37782a(String str) {
        C6659d.m37882c(f30815a, "getValidCache begin", false);
        AuthBean authBeanM37784b = m37784b(str);
        if (authBeanM37784b == null) {
            return null;
        }
        if (!m37778b(authBeanM37784b)) {
            return authBeanM37784b;
        }
        m37781e(str);
        return null;
    }

    /* renamed from: b */
    public AuthBean m37784b(String str) {
        String strM37780d = m37780d(str);
        if (strM37780d != null && new File(strM37780d).exists()) {
            return (AuthBean) new C6635f(strM37780d).m37805b();
        }
        return null;
    }

    /* renamed from: a */
    private String m37777a(Context context, String str) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cacheDir.getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        File file = new File(sb2.toString());
        if (!file.exists() && !file.mkdir()) {
            C6659d.m37881b(f30815a, "getCacheDir mkdir error", true);
        }
        return file.getAbsolutePath() + str2;
    }

    /* renamed from: b */
    private boolean m37778b(AuthBean authBean) {
        long jCurrentTimeMillis = System.currentTimeMillis() - authBean.getTimestamp();
        return jCurrentTimeMillis >= 86400000 || jCurrentTimeMillis < 0;
    }

    /* renamed from: a */
    public void m37783a(AuthBean authBean) throws Throwable {
        String strM37780d = m37780d(authBean.getAppId());
        if (strM37780d == null) {
            return;
        }
        new C6635f(strM37780d).m37804a(authBean);
    }
}
