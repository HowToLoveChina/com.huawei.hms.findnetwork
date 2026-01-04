package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.o */
/* loaded from: classes3.dex */
public class C2986o {

    /* renamed from: a */
    public static long f13026a;

    /* renamed from: b */
    public static long f13027b;

    /* renamed from: a */
    public static void m17944a(Context context, String str) {
        if (context == null) {
            C11839m.m70689w("SyncRetryUtil", "cancelSyncRetryAlarm error: context is null");
            return;
        }
        if (!C11829c.m70611r0()) {
            m17945b(str);
            return;
        }
        C11839m.m70688i("SyncRetryUtil", "Cancel sync retry alarm, module action is: " + str);
        CloudSyncUtil.m16012h(context, str);
    }

    /* renamed from: b */
    public static void m17945b(String str) {
        C11839m.m70688i("SyncRetryUtil", "Cancel sync retry scheduler, sync item is: " + str);
        if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(str)) {
            C12338d.m74195s().m74243p0();
        } else if ("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(str)) {
            C12338d.m74195s().m74197A0();
        }
    }

    /* renamed from: c */
    public static void m17946c(Context context, String str) {
        C11839m.m70688i("SyncRetryUtil", "begin clearSyncRetryAlarm");
        if (C11829c.m70611r0()) {
            m17944a(context, str);
        } else {
            m17945b(str);
        }
        m17948e(str);
    }

    /* renamed from: d */
    public static boolean m17947d(int i10) {
        return (i10 == 0 || i10 == 5 || i10 == 8 || i10 == 14 || i10 == 17) ? false : true;
    }

    /* renamed from: e */
    public static void m17948e(String str) {
        C11839m.m70688i("SyncRetryUtil", "reset retry times, module action is: " + str);
        if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(str)) {
            f13026a = 0L;
        } else if ("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(str)) {
            f13027b = 0L;
        }
    }

    /* renamed from: f */
    public static void m17949f(Context context, int i10, String str) {
        long j10;
        long j11;
        if (!C11829c.m70611r0()) {
            m17950g(i10, str);
            return;
        }
        if (i10 == 0 || 14 == i10) {
            m17946c(context, str);
        }
        if (m17947d(i10)) {
            if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(str)) {
                C2973b.m17825m(context, "addressbook", 1, 0L, 0, true);
                long j12 = f13026a;
                if (j12 >= 2) {
                    C11839m.m70688i("SyncRetryUtil", "contact retry time reach 2");
                    m17944a(context, str);
                    return;
                }
                f13026a = j12 + 1;
                C11839m.m70688i("SyncRetryUtil", "contact need retry, retry time: " + f13026a);
                j11 = f13026a;
            } else {
                if (!"com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(str)) {
                    j10 = 0;
                    CloudSyncUtil.m16044r1(context, j10, str);
                }
                long j13 = f13027b;
                if (j13 >= 2) {
                    C11839m.m70688i("SyncRetryUtil", "WIFI retry time reach 2");
                    m17944a(context, str);
                    return;
                }
                f13027b = j13 + 1;
                C11839m.m70688i("SyncRetryUtil", "WIFI need retry, retry time: " + f13027b);
                j11 = f13027b;
            }
            j10 = j11 * 300000;
            CloudSyncUtil.m16044r1(context, j10, str);
        }
    }

    /* renamed from: g */
    public static void m17950g(int i10, String str) {
        if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(str)) {
            C12338d.m74195s().m74243p0();
            if (i10 == 0 || 14 == i10) {
                m17948e("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
            }
        } else if ("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(str)) {
            C12338d.m74195s().m74197A0();
            if (i10 == 0 || i10 == 14) {
                m17948e("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
            }
        }
        if (m17947d(i10)) {
            if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(str)) {
                long j10 = f13026a;
                if (j10 >= 2) {
                    C11839m.m70688i("SyncRetryUtil", "contact retry scheduler time reach 2");
                    return;
                }
                f13026a = j10 + 1;
                C12338d.m74195s().m74217U();
                C11839m.m70688i("SyncRetryUtil", "contact need retry scheduler, retry time: " + f13026a);
                return;
            }
            if ("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(str)) {
                long j11 = f13027b;
                if (j11 >= 2) {
                    C11839m.m70688i("SyncRetryUtil", "WIFI retry scheduler time reach 2");
                    return;
                }
                f13027b = j11 + 1;
                C12338d.m74195s().m74228f0();
                C11839m.m70688i("SyncRetryUtil", "WIFI need retry scheduler, retry time: " + f13027b);
            }
        }
    }
}
