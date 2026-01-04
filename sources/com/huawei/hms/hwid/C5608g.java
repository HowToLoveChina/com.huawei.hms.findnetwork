package com.huawei.hms.hwid;

import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AuthAccount;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.hwid.g */
/* loaded from: classes8.dex */
public class C5608g {

    /* renamed from: a */
    private static final C5608g f25358a = new C5608g();

    /* renamed from: b */
    private Map<String, String> f25359b = new ConcurrentHashMap();

    private C5608g() {
    }

    /* renamed from: a */
    public static C5608g m32926a() {
        return f25358a;
    }

    /* renamed from: b */
    public final AuthAccount m32929b() {
        C5602as.m32910b("[AccountSDK]AccountAuthMemCache", "getSignInAccount start.", true);
        try {
            String str = this.f25359b.get("AccountAuth");
            if (str != null) {
                return AuthAccount.fromJson(str);
            }
            return null;
        } catch (Throwable th2) {
            C5602as.m32912d("[AccountSDK]AccountAuthMemCache", "getSignInAccount faild, exception:" + th2.getClass().getSimpleName(), true);
            return null;
        }
    }

    /* renamed from: c */
    public void m32930c() {
        this.f25359b.clear();
    }

    /* renamed from: a */
    public void m32928a(AuthAccount authAccount, AccountAuthParams accountAuthParams) {
        String json;
        C5602as.m32910b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        if (authAccount != null) {
            try {
                json = authAccount.toJson();
            } catch (Throwable th2) {
                C5602as.m32912d("[AccountSDK]AccountAuthMemCache", "store faild, exception:" + th2.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        m32927a(json, accountAuthParams != null ? accountAuthParams.toJson() : null);
    }

    /* renamed from: a */
    private void m32927a(String str, String str2) {
        C5602as.m32910b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        this.f25359b.remove("AccountAuth");
        this.f25359b.remove("AccountAuthParams");
        if (str != null) {
            this.f25359b.put("AccountAuth", str);
        }
        if (str2 != null) {
            this.f25359b.put("AccountAuthParams", str2);
        }
    }
}
