package com.huawei.hwcloudjs.p154d.p155a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwcloudjs.api.ValidateWhiteListListener;
import com.huawei.hwcloudjs.p154d.p156b.C6640b;
import com.huawei.hwcloudjs.p164f.C6657b;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import com.huawei.hwcloudjs.service.auth.bean.C6665a;
import com.huawei.hwcloudjs.service.auth.bean.C6666b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.huawei.hwcloudjs.d.a.c */
/* loaded from: classes8.dex */
public final class C6632c {

    /* renamed from: a */
    private static final String f30824a = "AuthManager";

    /* renamed from: b */
    private static ValidateWhiteListListener f30825b;

    /* renamed from: c */
    private static C6632c f30826c = new C6632c();

    /* renamed from: d */
    private final HashMap<String, AuthBean> f30827d = new HashMap<>();

    /* renamed from: e */
    private final ArrayList<String> f30828e = new ArrayList<>();

    /* renamed from: f */
    private final C6630a f30829f = new C6630a();

    /* renamed from: com.huawei.hwcloudjs.d.a.c$a */
    public interface a {

        /* renamed from: a */
        public static final int f30830a = 0;

        /* renamed from: b */
        public static final int f30831b = -1;

        /* renamed from: c */
        public static final int f30832c = -2;

        /* renamed from: d */
        public static final int f30833d = -3;

        /* renamed from: e */
        public static final int f30834e = -4;

        /* renamed from: a */
        void mo37752a(int i10);
    }

    private C6632c() {
    }

    /* renamed from: c */
    private boolean m37793c(String str) {
        C6659d.m37882c(f30824a, "isUrlAllow begin", true);
        synchronized (this.f30828e) {
            try {
                if (this.f30828e.size() == 0) {
                    C6659d.m37881b(f30824a, "getSercuredUrl empty", true);
                    return false;
                }
                Iterator<String> it = this.f30828e.iterator();
                while (it.hasNext()) {
                    if (Pattern.matches(it.next(), str)) {
                        return true;
                    }
                }
                C6659d.m37881b(f30824a, "isUrlWhileList false!", true);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    private boolean m37794d(String str) {
        C6659d.m37882c(f30824a, "isUrlAllowDomin begin", true);
        try {
            String host = new URL(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            synchronized (this.f30828e) {
                try {
                    if (this.f30828e.size() == 0) {
                        C6659d.m37881b(f30824a, "getSercuredUrl empty ,true", true);
                        return false;
                    }
                    Iterator<String> it = this.f30828e.iterator();
                    while (it.hasNext()) {
                        try {
                        } catch (PatternSyntaxException unused) {
                            C6659d.m37881b(f30824a, "PatternSyntaxException", true);
                        }
                        if (Pattern.compile(it.next()).matcher(host).matches()) {
                            C6659d.m37881b(f30824a, "pattern true", true);
                            return true;
                        }
                        continue;
                    }
                    C6659d.m37881b(f30824a, "isUrlWhileList false!", true);
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (MalformedURLException unused2) {
            C6659d.m37881b(f30824a, "isUrlWhileList MalformedURLException", true);
            return false;
        }
    }

    /* renamed from: b */
    public void m37799b(String str) {
        synchronized (this.f30828e) {
            try {
                if (!this.f30828e.contains(str)) {
                    this.f30828e.add(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C6632c m37786a() {
        return f30826c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m37792b(String str, String str2, List<String> list, a aVar, Context context) throws Throwable {
        int iMo37820b;
        C6659d.m37882c(f30824a, "getAuthFromGw begin", true);
        C6659d.m37882c(f30824a, "getAuthFromGw appId:" + str, false);
        C6659d.m37882c(f30824a, "getAuthFromGw url:" + str2, false);
        C6659d.m37882c(f30824a, "getAuthFromGw permissionList:" + list, false);
        if (!C6657b.m37878f()) {
            C6659d.m37881b(f30824a, "isNetOpen is not open", true);
            aVar.mo37752a(-2);
            return;
        }
        C6666b c6666b = (C6666b) C6640b.m37823a(new C6665a(str), context);
        if (c6666b.mo37822c() != 1) {
            iMo37820b = c6666b.mo37822c() == 2 ? c6666b.mo37820b() : c6666b.mo37822c() == 3 ? -3 : -4;
        } else if (c6666b.m37914e() == 0) {
            C6659d.m37882c(f30824a, "response getUrlList:" + c6666b.m37915f(), false);
            C6659d.m37882c(f30824a, "response getPermissionList:" + c6666b.m37913d(), false);
            AuthBean authBean = new AuthBean();
            authBean.setUrlList(c6666b.m37915f());
            authBean.setPermissionList(c6666b.m37913d());
            authBean.setAppId(str);
            authBean.setTimestamp(System.currentTimeMillis());
            if (C6633d.m37801a(str2, list, authBean)) {
                aVar.mo37752a(0);
                m37791a(str, authBean);
                m37790a(authBean);
                return;
            }
            C6659d.m37881b(f30824a, "getAuthFromGw checkH5App failed", true);
            iMo37820b = -1;
        } else {
            C6659d.m37881b(f30824a, "getAuthFromGw callback failed", true);
            iMo37820b = c6666b.m37914e();
        }
        aVar.mo37752a(iMo37820b);
    }

    /* renamed from: a */
    public static void m37787a(ValidateWhiteListListener validateWhiteListListener) {
        f30825b = validateWhiteListListener;
    }

    /* renamed from: a */
    private void m37790a(AuthBean authBean) throws Throwable {
        this.f30829f.m37783a(authBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37791a(String str, AuthBean authBean) {
        synchronized (this.f30827d) {
            this.f30827d.put(str, authBean);
        }
    }

    /* renamed from: a */
    public void m37795a(String str, String str2, List<String> list, a aVar, Context context) {
        C6659d.m37882c(f30824a, "auth begin", true);
        C6659d.m37882c(f30824a, "auth appId:" + str, false);
        C6659d.m37882c(f30824a, "auth url:" + str2, false);
        if (!m37798a(str, str2, list)) {
            new Thread(new RunnableC6631b(this, str, str2, list, aVar, context)).start();
        } else {
            C6659d.m37882c(f30824a, "auth memoryAuth", true);
            aVar.mo37752a(0);
        }
    }

    /* renamed from: a */
    public boolean m37796a(String str) {
        C6659d.m37882c(f30824a, "isUrlWhileList begin", true);
        if (!TextUtils.isEmpty(str)) {
            return m37793c(str) || m37794d(str);
        }
        C6659d.m37881b(f30824a, "isUrlWhileList isEmpty", true);
        return false;
    }

    /* renamed from: a */
    public boolean m37797a(String str, String str2, Context context) {
        C6666b c6666b = (C6666b) C6640b.m37823a(new C6665a(str), context);
        return c6666b.mo37822c() == 1 && c6666b.m37914e() == 0 && C6633d.m37802a(c6666b.m37915f(), str2);
    }

    /* renamed from: a */
    public boolean m37798a(String str, String str2, List<String> list) {
        boolean z10;
        synchronized (this.f30827d) {
            try {
                AuthBean authBean = this.f30827d.get(str);
                z10 = authBean != null && C6633d.m37801a(str2, list, authBean);
            } finally {
            }
        }
        return z10;
    }
}
