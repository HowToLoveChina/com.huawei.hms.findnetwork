package com.huawei.hms.hwid;

import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.hwid.y */
/* loaded from: classes8.dex */
public class C5627y {

    /* renamed from: a */
    private static final C5627y f25370a = new C5627y();

    /* renamed from: b */
    private Map<String, String> f25371b = new ConcurrentHashMap();

    private C5627y() {
    }

    /* renamed from: a */
    public static C5627y m32967a() {
        return f25370a;
    }

    /* renamed from: b */
    public final AuthHuaweiId m32970b() {
        try {
            String str = this.f25371b.get("HuaweiIdAccount");
            if (str != null) {
                return AuthHuaweiId.fromJson(str);
            }
            return null;
        } catch (Throwable th2) {
            C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "getHuaweiSignInAccount faild, exception:" + th2.getClass().getSimpleName(), true);
            return null;
        }
    }

    /* renamed from: c */
    public void m32971c() {
        this.f25371b.clear();
    }

    /* renamed from: a */
    public void m32969a(AuthHuaweiId authHuaweiId, HuaweiIdAuthParams huaweiIdAuthParams) {
        String json;
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        if (authHuaweiId != null) {
            try {
                json = authHuaweiId.toJson();
            } catch (Throwable th2) {
                C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "store faild, exception:" + th2.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        m32968a(json, huaweiIdAuthParams != null ? huaweiIdAuthParams.toJson() : null);
    }

    /* renamed from: a */
    private void m32968a(String str, String str2) {
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        this.f25371b.remove("HuaweiIdAccount");
        this.f25371b.remove("HuaweiIdAuthParams");
        if (str != null) {
            this.f25371b.put("HuaweiIdAccount", str);
        }
        if (str2 != null) {
            this.f25371b.put("HuaweiIdAuthParams", str2);
        }
    }
}
