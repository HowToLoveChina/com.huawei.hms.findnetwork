package com.huawei.hms.support.hwid.common.p145d;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.common.p146e.C6479i;
import com.huawei.hms.support.hwid.common.p146e.C6480j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.support.hwid.common.d.b */
/* loaded from: classes8.dex */
public class C6470b {

    /* renamed from: a */
    private volatile SharedPreferences f30044a;

    /* renamed from: b */
    private Context f30045b;

    /* renamed from: c */
    private String f30046c;

    public C6470b(Context context, String str) {
        this.f30046c = "";
        this.f30045b = context.getApplicationContext();
        this.f30046c = str;
        m36861b();
    }

    /* renamed from: b */
    private boolean m36861b() {
        if (C6479i.m36910a(this.f30045b)) {
            C6477g.m36904a("HwIdCeSharedPreferences", "Phone Still In Lock Mode", true);
            return false;
        }
        this.f30044a = this.f30045b.getSharedPreferences(this.f30046c, 0);
        boolean z10 = this.f30044a == null;
        C6477g.m36904a("HwIdCeSharedPreferences", "createSharedPreferences: " + z10, true);
        return z10;
    }

    /* renamed from: c */
    private boolean m36862c() {
        if (this.f30045b == null) {
            C6477g.m36907c("HwIdCeSharedPreferences", "mContext is null, can not use SharedPreferences.", true);
            return false;
        }
        if (this.f30044a == null) {
            C6477g.m36907c("HwIdCeSharedPreferences", "mSharedPreferences is null, need init.", true);
            synchronized (C6470b.class) {
                try {
                    if (this.f30044a == null) {
                        return m36861b();
                    }
                } finally {
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public String m36863a(String str, String str2) {
        C6477g.m36904a("HwIdCeSharedPreferences", "getStringByRandomEncrypter, key:" + str, false);
        return !m36862c() ? str2 : this.f30044a.getString(str, str2);
    }

    /* renamed from: a */
    public Map<String, ?> m36864a() {
        C6477g.m36904a("HwIdCeSharedPreferences", "getAll", true);
        if (m36862c()) {
            return this.f30044a.getAll();
        }
        return null;
    }

    /* renamed from: b */
    public String m36866b(String str, String str2) {
        C6477g.m36904a("HwIdCeSharedPreferences", "getString, key:" + str, false);
        return !m36862c() ? str2 : this.f30044a.getString(str, str2);
    }

    /* renamed from: a */
    public boolean m36865a(HashMap<String, Object> map) {
        SharedPreferences.Editor editorEdit;
        C6477g.m36904a("HwIdCeSharedPreferences", "saveMap", true);
        if (map == null || map.size() == 0) {
            C6477g.m36907c("HwIdCeSharedPreferences", "map is empty", true);
            return false;
        }
        if (!m36862c() || (editorEdit = this.f30044a.edit()) == null) {
            return false;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, String.valueOf(value));
            } else if (!(value instanceof Integer) && !(value instanceof Short) && !(value instanceof Byte)) {
                if (value instanceof Long) {
                    editorEdit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    editorEdit.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    editorEdit.putFloat(key, (float) ((Double) value).doubleValue());
                } else if (value instanceof Boolean) {
                    editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            } else {
                editorEdit.putInt(key, C6480j.m36911a(String.valueOf(value)));
            }
        }
        return editorEdit.commit();
    }

    /* renamed from: c */
    public boolean m36867c(String str, String str2) {
        SharedPreferences.Editor editorEdit;
        C6477g.m36904a("HwIdCeSharedPreferences", "setString, key:" + str, false);
        if (!m36862c() || (editorEdit = this.f30044a.edit()) == null) {
            return false;
        }
        return editorEdit.putString(str, str2).commit();
    }
}
