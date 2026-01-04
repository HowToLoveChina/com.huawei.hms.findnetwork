package com.huawei.hms.p109a.p110a.p113c;

import com.huawei.hms.support.picker.request.AccountPickerParams;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p640sq.C12836o;

/* renamed from: com.huawei.hms.a.a.c.a */
/* loaded from: classes8.dex */
public class C5040a {

    /* renamed from: a */
    private static final C5040a f23024a = new C5040a();

    /* renamed from: b */
    private Map<String, String> f23025b = new ConcurrentHashMap();

    private C5040a() {
    }

    /* renamed from: a */
    public static C5040a m30081a() {
        return f23024a;
    }

    /* renamed from: b */
    public final AuthAccountPicker m30084b() {
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerMemCache", "getAccountPickerAccount start.", true);
        try {
            String str = this.f23025b.get("AccountPickerAccount");
            if (str != null) {
                return AuthAccountPicker.fromJson(str);
            }
            return null;
        } catch (Throwable th2) {
            C12836o.m77099d("[ACCOUNTSDK]AccountPickerMemCache", "getHuaweiSignInAccount faild, exception:" + th2.getClass().getSimpleName(), true);
            return null;
        }
    }

    /* renamed from: c */
    public void m30085c() {
        this.f23025b.clear();
    }

    /* renamed from: a */
    public void m30083a(AuthAccountPicker authAccountPicker, AccountPickerParams accountPickerParams) {
        String json;
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerMemCache", "saveDefaultAccountPickerAccount start.", true);
        if (authAccountPicker != null) {
            try {
                json = authAccountPicker.toJson();
            } catch (Throwable th2) {
                C12836o.m77099d("[ACCOUNTSDK]AccountPickerMemCache", "store SignInAccount faild, exception:" + th2.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        m30082a(json, accountPickerParams != null ? accountPickerParams.toJson() : null);
    }

    /* renamed from: a */
    private void m30082a(String str, String str2) {
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerMemCache", "saveDefaultAccountPickerAccount start.", true);
        this.f23025b.remove("AccountPickerAccount");
        this.f23025b.remove("AccountPickerAuthParams");
        if (str != null) {
            this.f23025b.put("AccountPickerAccount", str);
        }
        if (str2 != null) {
            this.f23025b.put("AccountPickerAuthParams", str2);
        }
    }
}
