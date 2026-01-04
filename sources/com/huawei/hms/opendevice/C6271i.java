package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* renamed from: com.huawei.hms.opendevice.i */
/* loaded from: classes8.dex */
public class C6271i extends PushPreferences {

    /* renamed from: c */
    private static final String f29585c = "i";

    /* renamed from: b */
    private Context f29586b;

    private C6271i(Context context) {
        super(context, "push_client_self_info");
        this.f29586b = context;
    }

    /* renamed from: a */
    public static C6271i m36434a(Context context) {
        return new C6271i(context);
    }

    /* renamed from: b */
    public String m36438b(String str) {
        try {
            return TextUtils.isEmpty(str) ? m36435a("token_info_v2") : m36435a(str);
        } catch (Exception e10) {
            HMSLog.m36986e(f29585c, "getSecureData" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public boolean m36440c(String str) {
        try {
            return TextUtils.isEmpty(str) ? removeKey("token_info_v2") : removeKey(str);
        } catch (Exception e10) {
            HMSLog.m36986e(f29585c, "removeToken" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public String m36435a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f29586b, getString(str));
        } catch (Exception e10) {
            HMSLog.m36986e(f29585c, "getSecureData" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public boolean m36437a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f29586b, str2));
        } catch (Exception e10) {
            HMSLog.m36986e(f29585c, "saveSecureData" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public boolean m36439b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return m36437a("token_info_v2", str2);
            }
            return m36437a(str, str2);
        } catch (Exception e10) {
            HMSLog.m36986e(f29585c, "saveSecureData" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public void m36436a() {
        Map<String, ?> all = getAll();
        if (all.isEmpty() || all.keySet().isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }
}
