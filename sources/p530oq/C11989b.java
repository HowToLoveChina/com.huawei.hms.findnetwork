package p530oq;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import p640sq.C12836o;

/* renamed from: oq.b */
/* loaded from: classes8.dex */
public class C11989b {

    /* renamed from: a */
    public volatile SharedPreferences f55779a;

    /* renamed from: b */
    public Context f55780b;

    /* renamed from: c */
    public String f55781c;

    public C11989b(Context context, String str) {
        this.f55781c = "";
        this.f55780b = context.getApplicationContext();
        this.f55781c = str;
        m72138e();
    }

    /* renamed from: a */
    public int m72134a(String str, int i10) {
        C12836o.m77097b("HwIdCeSharedPreferences", "getLong, key:" + str, false);
        return !m72140g() ? i10 : this.f55779a.getInt(str, i10);
    }

    /* renamed from: b */
    public long m72135b(String str, long j10) {
        C12836o.m77097b("HwIdCeSharedPreferences", "getLong, key:" + str, false);
        return !m72140g() ? j10 : this.f55779a.getLong(str, j10);
    }

    /* renamed from: c */
    public String m72136c(String str, String str2) {
        C12836o.m77097b("HwIdCeSharedPreferences", "getString, key:" + str, false);
        return !m72140g() ? str2 : this.f55779a.getString(str, str2);
    }

    /* renamed from: d */
    public void m72137d(String str) {
        SharedPreferences.Editor editorEdit;
        C12836o.m77097b("HwIdCeSharedPreferences", "deleteKey, key:" + str, false);
        if (m72140g() && (editorEdit = this.f55779a.edit()) != null) {
            editorEdit.remove(str).commit();
        }
    }

    /* renamed from: e */
    public final boolean m72138e() {
        if (AccountPickerUtil.isPhoneStillInLockMode(this.f55780b)) {
            C12836o.m77097b("HwIdCeSharedPreferences", "Phone Still In Lock Mode", true);
            return false;
        }
        this.f55779a = this.f55780b.getSharedPreferences(this.f55781c, 0);
        boolean z10 = this.f55779a == null;
        C12836o.m77097b("HwIdCeSharedPreferences", "createSharedPreferences: " + z10, false);
        return z10;
    }

    /* renamed from: f */
    public boolean m72139f(String str, boolean z10) {
        C12836o.m77097b("HwIdCeSharedPreferences", "getBoolean, key:" + str, false);
        return !m72140g() ? z10 : this.f55779a.getBoolean(str, z10);
    }

    /* renamed from: g */
    public final boolean m72140g() {
        if (this.f55780b == null) {
            C12836o.m77099d("HwIdCeSharedPreferences", "mContext is null, can not use SharedPreferences.", true);
            return false;
        }
        if (this.f55779a == null) {
            C12836o.m77099d("HwIdCeSharedPreferences", "mSharedPreferences is null, need init.", true);
            synchronized (C11989b.class) {
                try {
                    if (this.f55779a == null) {
                        return m72138e();
                    }
                } finally {
                }
            }
        }
        return true;
    }

    /* renamed from: h */
    public boolean m72141h(String str, long j10) {
        SharedPreferences.Editor editorEdit;
        C12836o.m77097b("HwIdCeSharedPreferences", "saveLong, key:" + str, false);
        if (!m72140g() || (editorEdit = this.f55779a.edit()) == null) {
            return false;
        }
        return editorEdit.putLong(str, j10).commit();
    }

    /* renamed from: i */
    public boolean m72142i(String str, String str2) {
        SharedPreferences.Editor editorEdit;
        C12836o.m77097b("HwIdCeSharedPreferences", "setString, key:" + str, false);
        if (!m72140g() || (editorEdit = this.f55779a.edit()) == null) {
            return false;
        }
        return editorEdit.putString(str, str2).commit();
    }

    /* renamed from: j */
    public boolean m72143j(String str, boolean z10) {
        SharedPreferences.Editor editorEdit;
        C12836o.m77097b("HwIdCeSharedPreferences", "saveBoolean, key:" + str, false);
        if (!m72140g() || (editorEdit = this.f55779a.edit()) == null) {
            return false;
        }
        return editorEdit.putBoolean(str, z10).commit();
    }
}
