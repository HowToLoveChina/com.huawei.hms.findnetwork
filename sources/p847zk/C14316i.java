package p847zk;

import android.content.SharedPreferences;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p572qb.C12315j;

/* renamed from: zk.i */
/* loaded from: classes6.dex */
public class C14316i {

    /* renamed from: a */
    public long f63580a = -1;

    /* renamed from: zk.i$a */
    public static class a {

        /* renamed from: a */
        public static final C14316i f63581a = new C14316i();
    }

    /* renamed from: e */
    public static C14316i m85291e() {
        return a.f63581a;
    }

    /* renamed from: a */
    public void m85292a(String str) {
        m85293b("com.huawei.hidisk", str);
    }

    /* renamed from: b */
    public void m85293b(String str, String str2) {
        m85294c(str, m85295d(), str2);
    }

    /* renamed from: c */
    public void m85294c(String str, long j10, String str2) {
        C12315j.m74059f().m74060c(str, j10, str2);
    }

    /* renamed from: d */
    public long m85295d() {
        if (this.f63580a <= 0) {
            m85296f();
        }
        return this.f63580a;
    }

    /* renamed from: f */
    public final void m85296f() {
        int i10;
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "powerkit_apply_sp", 0);
        int i11 = 30;
        if (sharedPreferencesM1382b != null && (i10 = sharedPreferencesM1382b.getInt(PowerKitApplyUtil.POWERKITDURATION, 30)) > 0) {
            i11 = i10;
        }
        this.f63580a = i11 * 60000;
        C11839m.m70686d("CloudBackupPowerKitManager", "initDuration:" + this.f63580a);
    }

    /* renamed from: g */
    public void m85297g(String str) {
        m85298h("com.huawei.hidisk", str);
    }

    /* renamed from: h */
    public void m85298h(String str, String str2) {
        C12315j.m74059f().m74071o(str, str2);
    }
}
