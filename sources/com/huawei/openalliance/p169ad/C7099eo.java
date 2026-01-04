package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.eo */
/* loaded from: classes8.dex */
public class C7099eo implements InterfaceC7133fq {

    /* renamed from: b */
    private static InterfaceC7133fq f32704b;

    /* renamed from: c */
    private static final byte[] f32705c = new byte[0];

    /* renamed from: a */
    private final SharedPreferences f32706a;

    /* renamed from: d */
    private final byte[] f32707d = new byte[0];

    /* renamed from: e */
    private List<String> f32708e;

    private C7099eo(Context context) {
        try {
            this.f32706a = context.getApplicationContext().getSharedPreferences("hiad_audids", 0);
        } catch (Throwable th2) {
            try {
                AbstractC7185ho.m43824c("AudIdSpHandler", "get SharedPreference exception: %s", th2.getClass().getSimpleName());
            } finally {
                this.f32706a = null;
            }
        }
    }

    /* renamed from: b */
    private static InterfaceC7133fq m42971b(Context context) {
        InterfaceC7133fq interfaceC7133fq;
        synchronized (f32705c) {
            try {
                if (f32704b == null) {
                    f32704b = new C7099eo(context);
                }
                interfaceC7133fq = f32704b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7133fq;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7133fq
    /* renamed from: a */
    public long mo42972a() {
        long j10;
        synchronized (this.f32707d) {
            j10 = this.f32706a.getLong("last_query_audid_time", 0L);
        }
        return j10;
    }

    /* renamed from: a */
    public static InterfaceC7133fq m42970a(Context context) {
        return m42971b(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7133fq
    /* renamed from: b */
    public List<String> mo42975b() {
        synchronized (this.f32707d) {
            try {
                SharedPreferences sharedPreferences = this.f32706a;
                if (sharedPreferences == null) {
                    return null;
                }
                List<String> list = this.f32708e;
                if (list != null) {
                    return list;
                }
                String string = sharedPreferences.getString("aud_id", "");
                if (AbstractC7806cz.m48165b(string)) {
                    return null;
                }
                List<String> list2 = (List) AbstractC7758be.m47739b(string, List.class, String.class);
                this.f32708e = list2;
                return list2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7133fq
    /* renamed from: a */
    public void mo42973a(long j10) {
        synchronized (this.f32707d) {
            this.f32706a.edit().putLong("last_query_audid_time", j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7133fq
    /* renamed from: a */
    public void mo42974a(String str) {
        synchronized (this.f32707d) {
            try {
                if (this.f32706a == null) {
                    return;
                }
                this.f32708e = (List) AbstractC7758be.m47739b(str, List.class, String.class);
                this.f32706a.edit().putString("aud_id", str).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
