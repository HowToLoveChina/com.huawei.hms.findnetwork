package p711vl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import p015ak.C0214f0;
import p514o9.C11839m;
import p618rm.C12540b1;

/* renamed from: vl.e */
/* loaded from: classes6.dex */
public class C13465e {

    /* renamed from: b */
    public static final C13465e f60646b = new C13465e();

    /* renamed from: a */
    public SharedPreferences f60647a;

    /* renamed from: f */
    public static C13465e m81052f() {
        return f60646b;
    }

    /* renamed from: a */
    public void m81053a() {
        if (this.f60647a != null) {
            C11839m.m70688i("CloudBackupOptionsPreferences", "clear preferences in cloud backup options.");
            this.f60647a.edit().clear().apply();
        }
    }

    /* renamed from: b */
    public boolean m81054b(String str) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    /* renamed from: c */
    public boolean m81055c(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60647a;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    /* renamed from: d */
    public long m81056d(boolean z10) {
        return m81058g(z10 ? "lasttime_refurbish" : "lastTime", 0L);
    }

    /* renamed from: e */
    public long m81057e(boolean z10) {
        return m81058g(z10 ? "clientSizeCacheTime_refurbish" : "clientSizeCacheTime", 0L);
    }

    /* renamed from: g */
    public long m81058g(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60647a;
        return sharedPreferences != null ? sharedPreferences.getLong(str, j10) : j10;
    }

    /* renamed from: h */
    public <T> T m81059h(String str, Class<T> cls) {
        if (this.f60647a != null) {
            try {
                return (T) new Gson().fromJson(this.f60647a.getString(str, null), (Class) cls);
            } catch (JsonSyntaxException unused) {
            }
        }
        return null;
    }

    /* renamed from: i */
    public <T> T m81060i(String str, Type type) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            return (T) C12540b1.m75484b(sharedPreferences.getString(str, null), type);
        }
        return null;
    }

    /* renamed from: j */
    public long m81061j(boolean z10) {
        return m81058g(z10 ? "backupoptionstimestamp_refurbish" : "backupOptionsTimestamp", -1L);
    }

    /* renamed from: k */
    public long m81062k() {
        return m81058g("last_time_temp_backup", 0L);
    }

    /* renamed from: l */
    public void m81063l(Context context) {
        this.f60647a = C0214f0.m1382b(context, "backup_option_status_sp", 0);
    }

    /* renamed from: m */
    public void m81064m(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z10).apply();
        }
    }

    /* renamed from: n */
    public void m81065n(String str, long j10) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j10).apply();
        }
    }

    /* renamed from: o */
    public void m81066o(String str, Object obj) {
        if (this.f60647a != null) {
            this.f60647a.edit().putString(str, new Gson().toJson(obj)).apply();
        }
    }

    /* renamed from: p */
    public void m81067p(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: q */
    public void m81068q(String str) {
        SharedPreferences sharedPreferences = this.f60647a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    /* renamed from: r */
    public void m81069r(boolean z10, long j10) {
        m81065n(z10 ? "lasttime_refurbish" : "lastTime", j10);
    }

    /* renamed from: s */
    public void m81070s(boolean z10, long j10) {
        m81065n(z10 ? "clientSizeCacheTime_refurbish" : "clientSizeCacheTime", j10);
    }

    /* renamed from: t */
    public void m81071t(boolean z10, long j10) {
        m81065n(z10 ? "backupoptionstimestamp_refurbish" : "backupOptionsTimestamp", j10);
    }

    /* renamed from: u */
    public void m81072u(long j10) {
        m81065n("last_time_temp_backup", j10);
    }
}
