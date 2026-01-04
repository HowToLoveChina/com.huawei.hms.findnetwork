package p711vl;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import mk.C11476b;
import p015ak.C0214f0;
import p514o9.C11839m;
import p572qb.C12299b;
import p709vj.C13452e;

/* renamed from: vl.g */
/* loaded from: classes6.dex */
public class C13467g {

    /* renamed from: c */
    public static final C13467g f60651c = new C13467g();

    /* renamed from: a */
    public SharedPreferences f60652a;

    /* renamed from: b */
    public int f60653b = 0;

    /* renamed from: c */
    public static C13467g m81086c() {
        return f60651c;
    }

    /* renamed from: a */
    public boolean m81087a(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60652a;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    /* renamed from: b */
    public String m81088b() {
        if (C11476b.m68626h(C13452e.m80781L().m80971t0()).equals(m81086c().m81090e("backup_sha_id", ""))) {
            C11839m.m70688i("CloudBackupStickySharedPreferences", "getCurDeviceCloudName the same id");
            return m81090e("current_device_cloud_name", "");
        }
        C11839m.m70688i("CloudBackupStickySharedPreferences", "getCurDeviceCloudName not the same id");
        return "";
    }

    /* renamed from: d */
    public int m81089d(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60652a;
        return sharedPreferences != null ? sharedPreferences.getInt(str, i10) : i10;
    }

    /* renamed from: e */
    public String m81090e(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60652a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: f */
    public int m81091f() {
        if (TextUtils.isEmpty(m81090e("backup_sha_id", ""))) {
            this.f60653b = 7;
        } else {
            this.f60653b = m81089d("backup_frequency", 7);
        }
        return this.f60653b;
    }

    /* renamed from: g */
    public void m81092g(Context context) {
        this.f60652a = C0214f0.m1382b(context, "cloudbackupstickysettings", 0);
    }

    /* renamed from: h */
    public void m81093h(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f60652a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z10).apply();
        }
    }

    /* renamed from: i */
    public void m81094i(String str, int i10) {
        SharedPreferences sharedPreferences = this.f60652a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i10).apply();
        }
    }

    /* renamed from: j */
    public void m81095j(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60652a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: k */
    public void m81096k(String str) {
        SharedPreferences sharedPreferences = this.f60652a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).commit();
        }
    }

    /* renamed from: l */
    public void m81097l(String str) {
        m81095j("current_device_cloud_name", str);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            return;
        }
        C11839m.m70688i("CloudBackupStickySharedPreferences", "setCurDeviceCloudName save id");
        m81095j("backup_sha_id", C11476b.m68626h(strM80971t0));
    }

    /* renamed from: m */
    public void m81098m(int i10) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0)) {
            return;
        }
        m81095j("backup_sha_id", C11476b.m68626h(strM80971t0));
        m81094i("backup_frequency", i10);
        this.f60653b = i10;
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_frequency", Integer.valueOf(i10));
        C12299b.m73929k(contentValues, "backupUserFrequency");
        C12299b.m73927i();
    }
}
