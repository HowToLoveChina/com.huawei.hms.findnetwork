package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7845x;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.fe */
/* loaded from: classes8.dex */
public class C7121fe implements InterfaceC7144ga {

    /* renamed from: a */
    private static C7121fe f32834a;

    /* renamed from: b */
    private static final byte[] f32835b = new byte[0];

    /* renamed from: c */
    private final byte[] f32836c = new byte[0];

    /* renamed from: d */
    private Context f32837d;

    private C7121fe(Context context) {
        this.f32837d = C7845x.m48571i(context.getApplicationContext());
    }

    /* renamed from: c */
    private SharedPreferences m43295c() {
        return this.f32837d.getSharedPreferences("hiad_report", 4);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7144ga
    /* renamed from: a */
    public int mo43296a() {
        int i10;
        synchronized (this.f32836c) {
            i10 = m43295c().getInt("minSmartImpDelay", 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7144ga
    /* renamed from: b */
    public int mo43300b() {
        int i10;
        synchronized (this.f32836c) {
            i10 = m43295c().getInt("maxSmartImpDelay", 0);
        }
        return i10;
    }

    /* renamed from: b */
    private static C7121fe m43294b(Context context) {
        C7121fe c7121fe;
        synchronized (f32835b) {
            try {
                if (f32834a == null) {
                    f32834a = new C7121fe(context);
                }
                c7121fe = f32834a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7121fe;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7144ga
    /* renamed from: a */
    public long mo43297a(String str) {
        long j10;
        synchronized (this.f32836c) {
            j10 = m43295c().getLong("last_rpt_time_" + str, 0L);
        }
        return j10;
    }

    /* renamed from: a */
    public static C7121fe m43293a(Context context) {
        return m43294b(context);
    }

    /* renamed from: b */
    public void m43301b(int i10) {
        synchronized (this.f32836c) {
            m43295c().edit().putInt("maxSmartImpDelay", i10).commit();
        }
    }

    /* renamed from: a */
    public void m43298a(int i10) {
        synchronized (this.f32836c) {
            m43295c().edit().putInt("minSmartImpDelay", i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7144ga
    /* renamed from: b */
    public void mo43302b(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43817a("ReportSpHandler", "saveConfigMapSmartImpDelay(), configMap is blank");
            return;
        }
        try {
            String str2 = (String) new JSONObject(str).get("smartImpDelay");
            if (AbstractC7806cz.m48165b(str2)) {
                return;
            }
            AbstractC7185ho.m43817a("ReportSpHandler", "saveConfigMapSmartImpDelay(), hasSmartImpDelay:" + str2);
            String[] strArrSplit = str2.trim().split(",");
            if (strArrSplit.length > 1) {
                m43298a(Integer.valueOf(strArrSplit[0]).intValue());
                m43301b(Integer.valueOf(strArrSplit[1]).intValue());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("ReportSpHandler", "saveConfigMapSmartImpDelay(), exception:" + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7144ga
    /* renamed from: a */
    public void mo43299a(String str, long j10) {
        synchronized (this.f32836c) {
            m43295c().edit().putLong("last_rpt_time_" + str, j10).commit();
        }
    }
}
