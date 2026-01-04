package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.utils.AbstractC7816di;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.fm */
/* loaded from: classes8.dex */
public class C7129fm implements InterfaceC7149gf {

    /* renamed from: a */
    private static final byte[] f32915a = new byte[0];

    /* renamed from: c */
    private static InterfaceC7149gf f32916c;

    /* renamed from: b */
    private final byte[] f32917b = new byte[0];

    /* renamed from: d */
    private Context f32918d;

    private C7129fm(Context context) {
        this.f32918d = C7845x.m48571i(context.getApplicationContext());
    }

    /* renamed from: b */
    private static InterfaceC7149gf m43539b(Context context) {
        InterfaceC7149gf interfaceC7149gf;
        synchronized (f32915a) {
            try {
                if (f32916c == null) {
                    f32916c = new C7129fm(context);
                }
                interfaceC7149gf = f32916c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7149gf;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7149gf
    /* renamed from: a */
    public int mo43541a(String str) {
        synchronized (this.f32917b) {
            try {
                SharedPreferences sharedPreferencesM43534a = m43534a();
                if (!AbstractC7816di.m48361a(sharedPreferencesM43534a.getLong("last_time_" + str, 0L))) {
                    return 0;
                }
                return sharedPreferencesM43534a.getInt("show_times_" + str, 0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public SharedPreferences m43534a() {
        return this.f32918d.getSharedPreferences("HiAd_def_tpt_sp", 0);
    }

    /* renamed from: b */
    private void m43540b() {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.fm.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferencesM43534a = C7129fm.this.m43534a();
                SharedPreferences.Editor editorEdit = sharedPreferencesM43534a.edit();
                if (System.currentTimeMillis() - sharedPreferencesM43534a.getLong("last_clean_time", 0L) <= 43200000) {
                    AbstractC7185ho.m43820b("TptSpHandler", "less than half day");
                    return;
                }
                AbstractC7185ho.m43820b("TptSpHandler", "begin clean");
                for (Map.Entry<String, ?> entry : sharedPreferencesM43534a.getAll().entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        String key = entry.getKey();
                        if (key.startsWith("last_time_") && (entry.getValue() instanceof Long) && (((Long) entry.getValue()) == null || !AbstractC7816di.m48361a(((Long) entry.getValue()).longValue()))) {
                            editorEdit.remove(key);
                            String strM43538a = C7129fm.this.m43538a(key, "last_time_");
                            AbstractC7185ho.m43818a("TptSpHandler", "slotId = %s", strM43538a);
                            if (!TextUtils.isEmpty(strM43538a)) {
                                editorEdit.remove("show_times_" + strM43538a);
                            }
                        }
                    }
                }
                editorEdit.putLong("last_clean_time", System.currentTimeMillis());
                editorEdit.commit();
            }
        });
    }

    /* renamed from: a */
    public static InterfaceC7149gf m43536a(Context context) {
        return m43539b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m43538a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            int iIndexOf = str.indexOf(str2);
            int length = str2.length();
            if (iIndexOf < 0 || iIndexOf >= str.length() - length) {
                return null;
            }
            return str.substring(iIndexOf + length);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("TptSpHandler", "get slotId by prefix err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7149gf
    /* renamed from: a */
    public void mo43542a(String str, long j10) {
        synchronized (this.f32917b) {
            try {
                SharedPreferences sharedPreferencesM43534a = m43534a();
                SharedPreferences.Editor editorEdit = sharedPreferencesM43534a.edit();
                long j11 = sharedPreferencesM43534a.getLong("last_time_" + str, 0L);
                editorEdit.putLong("last_time_" + str, j10);
                if (AbstractC7816di.m48361a(j11)) {
                    editorEdit.putInt("show_times_" + str, sharedPreferencesM43534a.getInt("show_times_" + str, 0) + 1);
                } else {
                    editorEdit.putInt("show_times_" + str, 1);
                }
                editorEdit.commit();
                m43540b();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
