package com.huawei.android.hicloud.sync.syncutil;

import android.content.SharedPreferences;
import com.huawei.fastengine.fastview.NavigationUtils;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p573qc.C12338d;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.a */
/* loaded from: classes3.dex */
public class C2972a {

    /* renamed from: a */
    public static long f12993a;

    /* renamed from: b */
    public static long f12994b;

    /* renamed from: c */
    public static long f12995c;

    /* renamed from: d */
    public static long f12996d;

    /* renamed from: a */
    public static void m17807a(String str) {
        C11839m.m70688i("BackupRetryUtil", "Cancel sync retry scheduler, sync item is: " + str);
        if ("phonemanager".equals(str)) {
            C12338d.m74195s().m74250t0();
            return;
        }
        if ("recording".equals(str)) {
            C12338d.m74195s().m74254v0();
        } else if ("callLog".equals(str)) {
            C12338d.m74195s().m74237m0();
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            C12338d.m74195s().m74260y0();
        }
    }

    /* renamed from: b */
    public static void m17808b(String str) {
        m17811e(str);
        m17807a(str);
    }

    /* renamed from: c */
    public static boolean m17809c(int i10) {
        return (i10 == 0 || i10 == 1 || i10 == -2) ? false : true;
    }

    /* renamed from: d */
    public static void m17810d(String str) {
        if ("phonemanager".equals(str)) {
            long j10 = f12993a;
            if (j10 >= 2) {
                C11839m.m70688i("BackupRetryUtil", "phone manager retry time reach 2");
                return;
            }
            f12993a = j10 + 1;
            C12338d.m74195s().m74220X();
            C11839m.m70688i("BackupRetryUtil", "phone manager need retry, retry time: " + f12993a);
            return;
        }
        if ("recording".equals(str)) {
            long j11 = f12994b;
            if (j11 >= 2) {
                SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "deviceNameSp", 0);
                if (sharedPreferencesM1382b != null) {
                    sharedPreferencesM1382b.edit().putLong("recordingtimestamp", 0L).commit();
                }
                C11839m.m70688i("BackupRetryUtil", "record retry time reach 2");
                return;
            }
            f12994b = j11 + 1;
            C12338d.m74195s().m74222Z();
            C11839m.m70688i("BackupRetryUtil", "record need retry, retry time: " + f12994b);
            return;
        }
        if ("callLog".equals(str)) {
            long j12 = f12996d;
            if (j12 >= 2) {
                C11839m.m70688i("BackupRetryUtil", "calllog retry time reach 2");
                return;
            }
            f12996d = j12 + 1;
            C12338d.m74195s().m74214R();
            C11839m.m70688i("BackupRetryUtil", "calllog need retry, retry time: " + f12996d);
            return;
        }
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            long j13 = f12995c;
            if (j13 >= 2) {
                C11839m.m70688i("BackupRetryUtil", "sms retry time reach 2");
                return;
            }
            f12995c = j13 + 1;
            C12338d.m74195s().m74226d0();
            C11839m.m70688i("BackupRetryUtil", "sms need retry, retry time: " + f12995c);
        }
    }

    /* renamed from: e */
    public static void m17811e(String str) {
        C11839m.m70688i("BackupRetryUtil", "reset retry times, module action is: " + str);
        if ("phonemanager".equals(str)) {
            f12993a = 0L;
            return;
        }
        if ("recording".equals(str)) {
            f12994b = 0L;
        } else if ("callLog".equals(str)) {
            f12996d = 0L;
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            f12995c = 0L;
        }
    }

    /* renamed from: f */
    public static void m17812f(int i10, String str) {
        C11839m.m70688i("BackupRetryUtil", "setBackupRetryJobScheduler(), resultCode = " + i10 + ",moduleName: " + str);
        if ("phonemanager".equals(str)) {
            C12338d.m74195s().m74250t0();
            if (i10 == 0) {
                m17811e(str);
            }
        } else if ("recording".equals(str)) {
            C12338d.m74195s().m74254v0();
            if (i10 == 0) {
                m17811e(str);
            }
        } else if ("callLog".equals(str)) {
            C12338d.m74195s().m74237m0();
            if (i10 == 0) {
                m17811e(str);
            }
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            C12338d.m74195s().m74260y0();
            if (i10 == 0) {
                m17811e(str);
            }
        }
        if (m17809c(i10)) {
            m17810d(str);
        }
    }
}
