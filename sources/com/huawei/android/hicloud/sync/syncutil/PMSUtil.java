package com.huawei.android.hicloud.sync.syncutil;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.p018os.IBackupSessionCallback;
import com.hihonor.android.app.PackageManagerEx;
import java.io.IOException;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class PMSUtil {

    /* renamed from: a */
    public static int f12987a = 0;

    /* renamed from: b */
    public static boolean f12988b = false;

    /* renamed from: c */
    public static boolean f12989c = false;

    /* renamed from: d */
    public static int f12990d = -1;

    /* renamed from: e */
    public static boolean f12991e = false;

    /* renamed from: f */
    public static IBackupSessionCallback f12992f = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.hicloud.sync.syncutil.PMSUtil.1
        @Override // android.p018os.IBackupSessionCallback
        public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws IOException, RemoteException {
            C11839m.m70686d("PMSUtil", "syncWlanPMS onTaskFileDescriptorCreated:sessionId = " + i10 + ",taskId = " + i11);
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e10) {
                    C11839m.m70687e("PMSUtil", "onTaskFileDescriptorCreated close error: " + e10.toString());
                }
            }
        }

        @Override // android.p018os.IBackupSessionCallback
        public void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException {
            C11839m.m70688i("PMSUtil", "syncWlanPMS onTaskStatusChanged:sessionId = " + i10 + ",taskId = " + i11 + ",statusCode = " + i12 + ",appendData = " + str);
            if (i12 == -1) {
                boolean unused = PMSUtil.f12988b = true;
                C11839m.m70687e("PMSUtil", "syncWlanPMS PMS Exception, statusCode: " + i12);
                return;
            }
            if (i12 == 0) {
                boolean unused2 = PMSUtil.f12988b = true;
                C11839m.m70688i("PMSUtil", "syncWlanPMS PMS copy file success, statusCode: " + i12);
                return;
            }
            if (i12 == 1) {
                C11839m.m70688i("PMSUtil", "syncWlanPMS PMS copy file begin, statusCode: " + i12);
                return;
            }
            if (i12 != 2) {
                return;
            }
            boolean unused3 = PMSUtil.f12989c = true;
            C11839m.m70687e("PMSUtil", "syncWlanPMS PMS stoped, statusCode: " + i12);
        }
    };

    /* renamed from: c */
    public static int m17802c(String str, String str2) throws InterruptedException {
        int i10 = f12990d;
        if (-2 == i10 || -1 == i10) {
            C11839m.m70687e("PMSUtil", "syncWlanPMS PackageManagerEx startBackupSession fail,sessionId:" + f12990d);
            return f12990d;
        }
        String str3 = "backup file " + str + " " + str2;
        C11839m.m70688i("PMSUtil", "syncWlanPMS backup sessionId = " + f12990d);
        int iExecuteBackupTask = C0209d.m1277l1() ? PackageManagerEx.executeBackupTask(f12990d, str3) : com.huawei.android.app.PackageManagerEx.executeBackupTask(f12990d, str3);
        if (-3 == iExecuteBackupTask || -2 == iExecuteBackupTask || -1 == iExecuteBackupTask) {
            C11839m.m70687e("PMSUtil", "syncWlanPMS PackageManagerEx executeBackupTask fail, taskId:" + iExecuteBackupTask);
            return iExecuteBackupTask;
        }
        C11839m.m70688i("PMSUtil", "syncWlanPMS backup taskId = " + iExecuteBackupTask);
        f12987a = 0;
        while (!f12988b && f12987a < 10) {
            try {
                C11839m.m70688i("PMSUtil", "syncWlanPMS Thread sleep");
                f12987a++;
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                C11839m.m70689w("PMSUtil", "syncWlanPMS InterruptedException");
            }
            if (f12989c) {
                C11839m.m70687e("PMSUtil", "syncWlanPMS PMS Exception, mTaskIdException: " + f12989c);
                return -1;
            }
        }
        if (f12987a >= 10) {
            C11839m.m70687e("PMSUtil", "syncWlanPMS PMS error, over MAX_WAIT_TIMES:1000ms.");
            return -1;
        }
        C11839m.m70688i("PMSUtil", "syncWlanPMS backupFile success");
        return 0;
    }

    /* renamed from: d */
    public static void m17803d() {
        if (f12992f == null) {
            C11839m.m70687e("PMSUtil", "syncWlanPMS PackageManagerEx mSessionCallback is null");
        }
        if (C0209d.m1277l1()) {
            f12990d = PackageManagerEx.startBackupSession(f12992f);
        } else {
            f12990d = com.huawei.android.app.PackageManagerEx.startBackupSession(f12992f);
        }
        int i10 = f12990d;
        if (-2 == i10 || -1 == i10) {
            C11839m.m70688i("PMSUtil", "syncWlanPMS PackageManagerEx startBackupSession fail,sessionId:" + f12990d);
        }
        f12991e = true;
        f12988b = false;
        f12989c = false;
    }

    /* renamed from: e */
    public static boolean m17804e() {
        return f12991e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m17805f(java.lang.String r6, android.content.Context r7) throws java.lang.Throwable {
        /*
            java.lang.String r7 = "syncWlanPMS fin close error."
            java.lang.String r0 = "PMSUtil"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3b
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3b
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3b
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L3b
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            r2.<init>()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
        L18:
            int r3 = r6.read(r1)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            r4 = -1
            if (r3 == r4) goto L28
            r4 = 0
            r2.write(r1, r4, r3)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            goto L18
        L24:
            r1 = move-exception
            goto L63
        L26:
            r1 = move-exception
            goto L3f
        L28:
            java.lang.String r1 = "UTF-8"
            java.lang.String r1 = r2.toString(r1)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            r6.close()     // Catch: java.io.IOException -> L32
            goto L62
        L32:
            p514o9.C11839m.m70689w(r0, r7)
            goto L62
        L36:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L63
        L3b:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L3f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "syncWlanPMS readFile IOException"
            r2.append(r3)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L24
            r2.append(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L24
            p514o9.C11839m.m70687e(r0, r1)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.io.IOException -> L5d
            goto L60
        L5d:
            p514o9.C11839m.m70689w(r0, r7)
        L60:
            java.lang.String r1 = ""
        L62:
            return r1
        L63:
            if (r6 == 0) goto L6c
            r6.close()     // Catch: java.io.IOException -> L69
            goto L6c
        L69:
            p514o9.C11839m.m70689w(r0, r7)
        L6c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.PMSUtil.m17805f(java.lang.String, android.content.Context):java.lang.String");
    }

    /* renamed from: g */
    public static void m17806g() {
        int i10 = f12990d;
        if (-2 == i10 || -1 == i10) {
            f12991e = false;
            return;
        }
        int iFinishBackupSession = C0209d.m1277l1() ? PackageManagerEx.finishBackupSession(f12990d) : com.huawei.android.app.PackageManagerEx.finishBackupSession(f12990d);
        C11839m.m70688i("PMSUtil", "syncWlanPMS finishBackupSession errorCode:" + iFinishBackupSession);
        if (iFinishBackupSession != 0) {
            C11839m.m70687e("PMSUtil", "syncWlanPMS PackageManagerEx finishBackupSession fail, errorCode:" + iFinishBackupSession);
        }
        f12990d = -1;
        f12991e = false;
        f12988b = false;
        f12989c = false;
    }
}
