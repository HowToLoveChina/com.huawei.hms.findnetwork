package p572qb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import fk.C9721b;
import gp.C10028c;
import java.util.HashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1007b;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: qb.b */
/* loaded from: classes3.dex */
public class C12299b {

    /* renamed from: a */
    public static boolean f56985a = true;

    /* renamed from: qb.b$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f56986a;

        /* renamed from: b */
        public final /* synthetic */ Context f56987b;

        public a(boolean z10, Context context) {
            this.f56986a = z10;
            this.f56987b = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider");
            if (!C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isAgreeTerms", this.f56986a);
            this.f56987b.getApplicationContext().getContentResolver().call(uri, "method_do_powerconnect_job", (String) null, bundle);
        }
    }

    /* renamed from: qb.b$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ boolean f56988a;

        /* renamed from: b */
        public final /* synthetic */ long f56989b;

        /* renamed from: c */
        public final /* synthetic */ Context f56990c;

        public b(boolean z10, long j10, Context context) {
            this.f56988a = z10;
            this.f56989b = j10;
            this.f56990c = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("CloudBackupDsProviderManager", "notifyDsRestoreTimer isRegister: " + this.f56988a + " ,delaytime: " + this.f56989b);
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider");
            if (!C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("paramter_restore_timer_register_or_unregister", this.f56988a);
            bundle.putLong("paramter_restore_timer_delay_duration", this.f56989b);
            this.f56990c.getApplicationContext().getContentResolver().call(uri, "method_notify_restore_timer", (String) null, bundle);
        }
    }

    /* renamed from: a */
    public static void m73919a(Context context) {
        try {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/clear");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                context.getApplicationContext().getContentResolver().delete(uri, null, null);
                C11839m.m70688i("CloudBackupDsProviderManager", "clear all data in ds success");
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "clear all data in ds failed : " + e10.toString());
        }
    }

    /* renamed from: b */
    public static void m73920b(Context context, boolean z10) {
        a aVar = new a(z10, context);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C12515a.m75110o().m75172d(aVar);
            C11839m.m70688i("CloudBackupDsProviderManager", "doDsPowerConnectJob main");
            return;
        }
        try {
            aVar.call();
            C11839m.m70688i("CloudBackupDsProviderManager", "doDsPowerConnectJob child");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "doDsPowerConnectJob failed: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static boolean m73921c(String str) {
        boolean z10 = false;
        try {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/queryBackupKey");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                Cursor cursorQuery = C0213f.m1377a().getContentResolver().query(uri, null, str, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0) {
                    z10 = true;
                }
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "isContainsKey error: " + e10.toString());
        }
        return z10;
    }

    /* renamed from: d */
    public static void m73922d(Context context, boolean z10, long j10) {
        b bVar = new b(z10, j10, context);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C12515a.m75110o().m75172d(bVar);
            C11839m.m70688i("CloudBackupDsProviderManager", "notifyDsRestoreTimer main");
            return;
        }
        try {
            bVar.call();
            C11839m.m70688i("CloudBackupDsProviderManager", "notifyDsRestoreTimer child");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "notifyDsRestoreTimer failed: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static int m73923e() {
        int i10 = 0;
        try {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/backupUserFrequency");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                Cursor cursorQuery = C0213f.m1377a().getContentResolver().query(uri, null, "backup_frequency", null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i10 = cursorQuery.getInt(0);
                    cursorQuery.close();
                }
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "queryDsUserFrequency error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "queryDsUserFrequency error: " + e10.toString());
        }
        return i10;
    }

    /* renamed from: f */
    public static long m73924f(String str) {
        long j10 = 0;
        try {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/queryLongValueBykey");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                Cursor cursorQuery = C0213f.m1377a().getContentResolver().query(uri, null, str, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    j10 = cursorQuery.getLong(0);
                }
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "queryLongValueByKey error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "queryLongValueByKey error: " + e10.toString());
        }
        return j10;
    }

    /* renamed from: g */
    public static String m73925g(String str) {
        String string = "";
        try {
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/queryStringValueBykey");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                Cursor cursorQuery = C0213f.m1377a().getContentResolver().query(uri, null, str, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(0);
                }
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "queryStringValueByKey error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "queryStringValueByKey error: " + e10.getMessage());
        }
        return string;
    }

    /* renamed from: h */
    public static void m73926h(Long l10) {
        String strM6033y = C1007b.m5980s().m6033y(new Exception());
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02101"), "refreshLastSuccessTime", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
        c11060cM66626a.m66664t("refreshLastSuccessTime");
        HashMap map = new HashMap();
        map.put("time", String.valueOf(l10));
        map.put("stackTrace", strM6033y);
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        C11839m.m70688i("CloudBackupDsProviderManager", "reportRefreshLastSuccessTime end values: " + map);
    }

    /* renamed from: i */
    public static void m73927i() {
        try {
            boolean zM62221H1 = C10028c.m62182c0().m62221H1();
            boolean zM70611r0 = C11829c.m70611r0();
            C11839m.m70686d("CloudBackupDsProviderManager", "isDsStartSticky " + zM70611r0);
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/resetAutoBackupCheck");
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("isDsStartSticky", Boolean.valueOf(zM70611r0));
                contentValues.put("isAgreeTerms", Boolean.valueOf(zM62221H1));
                C0213f.m1377a().getContentResolver().update(uri, contentValues, null, null);
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "resetAutoBackupCheck failed: " + e10.getMessage());
        }
    }

    /* renamed from: j */
    public static void m73928j(String str, Boolean bool) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_ds_boolean_key", str);
        contentValues.put("backup_ds_boolean_value", bool);
        m73929k(contentValues, "backup_update_boolean_key_value");
    }

    /* renamed from: k */
    public static void m73929k(ContentValues contentValues, String str) {
        try {
            f56985a = false;
            Uri uri = Uri.parse("content://com.huawei.android.ds.cloudbackup.provider/" + str);
            if (C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                C0213f.m1377a().getContentResolver().update(uri, contentValues, null, null);
                f56985a = true;
                C11839m.m70688i("CloudBackupDsProviderManager", "updateDataToDs success");
            } else {
                C11839m.m70687e("CloudBackupDsProviderManager", "error occur because inspection found uri do not source from system app");
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDsProviderManager", "updateDataToDs failed : " + e10.toString());
        }
    }

    /* renamed from: l */
    public static void m73930l(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("disperseRule", str);
        m73929k(contentValues, "backupDisperseRule");
    }

    /* renamed from: m */
    public static void m73931m(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("push_reset_status", Integer.valueOf(i10));
        m73929k(contentValues, "backupResetStatus");
    }

    /* renamed from: n */
    public static void m73932n(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_ds_string_key", str);
        contentValues.put("backup_ds_string_value", str2);
        m73929k(contentValues, "backup_update_string_key_value");
    }

    /* renamed from: o */
    public static boolean m73933o() {
        return f56985a;
    }

    /* renamed from: p */
    public static void m73934p(boolean z10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("backup_key", Boolean.valueOf(z10));
        m73929k(contentValues, "backupKey");
    }

    /* renamed from: q */
    public static void m73935q(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thermalControlGroup", str);
        m73929k(contentValues, "thermalControlGroup");
    }

    /* renamed from: r */
    public static void m73936r(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("thermalControl", str);
        m73929k(contentValues, "thermalControl");
    }

    /* renamed from: s */
    public static void m73937s(ContentValues contentValues) {
        Long asLong;
        if (contentValues != null && (asLong = contentValues.getAsLong("lastsuccesstime")) != null) {
            m73926h(asLong);
        }
        m73929k(contentValues, "backupTimes");
    }

    /* renamed from: t */
    public static void m73938t(ContentValues contentValues) {
        m73929k(contentValues, "backupUserInfo");
    }
}
