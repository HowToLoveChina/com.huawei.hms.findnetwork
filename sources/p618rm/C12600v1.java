package p618rm;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import om.C11963c;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import sl.C12815f;

/* renamed from: rm.v1 */
/* loaded from: classes6.dex */
public class C12600v1 {

    /* renamed from: c */
    public static C12600v1 f57993c;

    /* renamed from: d */
    public static int f57994d = C0212e0.m1357g(C0213f.m1377a(), "tempBackupSpFile", "key_interim_expiration_delete_time", -1);

    /* renamed from: e */
    public static int f57995e = C0212e0.m1357g(C0213f.m1377a(), "tempBackupSpFile", "key_interim_channel", 0);

    /* renamed from: f */
    public static int f57996f = C0212e0.m1357g(C0213f.m1377a(), "tempBackupSpFile", "key_interim_extra_retention_time", -1);

    /* renamed from: g */
    public static int f57997g = C0212e0.m1357g(C0213f.m1377a(), "tempBackupSpFile", "key_free_user_interim_max_times", -1);

    /* renamed from: a */
    public boolean f57998a = false;

    /* renamed from: b */
    public TempBackupSelectSpaceView.EnumC4011b f57999b = TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_USER_SPACE;

    /* renamed from: b */
    public static void m76046b() {
        C11963c.m71951f("interim");
        new C12815f("interim").clear();
    }

    /* renamed from: c */
    public static synchronized C12600v1 m76047c() {
        try {
            if (f57993c == null) {
                f57993c = new C12600v1();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f57993c;
    }

    /* renamed from: f */
    public static void m76048f(Integer num) {
        int iIntValue = num != null ? num.intValue() : 3;
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "key_free_user_interim_max_times", iIntValue);
        f57997g = iIntValue;
    }

    /* renamed from: g */
    public static void m76049g(Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String stringExtra = hiCloudSafeIntent.getStringExtra("srcChannel");
        String stringExtra2 = hiCloudSafeIntent.getStringExtra("activityCode");
        int i10 = 0;
        if (!TextUtils.equals(stringExtra, "542")) {
            if (TextUtils.equals(stringExtra2, "701")) {
                i10 = 1;
            } else if (TextUtils.equals(stringExtra2, "702")) {
                i10 = 2;
            }
        }
        C4012a.m24630N(stringExtra, stringExtra2, i10);
        C11839m.m70688i("TemporaryBackupUtil", "setInterimChannel srcChannel: " + stringExtra + " ,activityCode: " + stringExtra2 + " ,channel: " + i10);
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "key_interim_channel", i10);
        f57995e = i10;
    }

    /* renamed from: h */
    public static void m76050h(Integer num) {
        int iIntValue = num != null ? num.intValue() : 30;
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "key_interim_expiration_delete_time", iIntValue);
        f57994d = iIntValue;
    }

    /* renamed from: i */
    public static void m76051i(Integer num) {
        int iIntValue = num != null ? num.intValue() : 30;
        int i10 = iIntValue >= 0 ? iIntValue : 30;
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "key_interim_extra_retention_time", i10);
        f57996f = i10;
    }

    /* renamed from: a */
    public void m76052a() {
        this.f57999b = TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_USER_SPACE;
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "selectSpaceType", this.f57999b.m24616e());
        this.f57998a = false;
    }

    /* renamed from: d */
    public TempBackupSelectSpaceView.EnumC4011b m76053d() {
        TempBackupSelectSpaceView.EnumC4011b enumC4011bM24615b = TempBackupSelectSpaceView.EnumC4011b.m24615b(C0212e0.m1357g(C0213f.m1377a(), "tempBackupSpFile", "selectSpaceType", TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_EXTRAS_SPACE.m24616e()));
        this.f57999b = enumC4011bM24615b;
        return enumC4011bM24615b;
    }

    /* renamed from: e */
    public boolean m76054e() {
        return this.f57998a;
    }

    /* renamed from: j */
    public void m76055j(TempBackupSelectSpaceView.EnumC4011b enumC4011b) {
        this.f57999b = enumC4011b;
        C0212e0.m1368r(C0213f.m1377a(), "tempBackupSpFile", "selectSpaceType", enumC4011b.m24616e());
    }

    /* renamed from: k */
    public void m76056k(boolean z10) {
        this.f57998a = z10;
    }
}
