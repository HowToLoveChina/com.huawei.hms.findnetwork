package com.huawei.android.backup.service.logic.installedapps;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import ly.C11376j;
import p229di.C9149n;
import p699v4.C13339h;
import p762x4.C13694a;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.a */
/* loaded from: classes.dex */
public class C2143a {

    /* renamed from: a */
    public PackageManager f9631a;

    /* renamed from: b */
    public Uri f9632b;

    /* renamed from: c */
    public Context f9633c;

    /* renamed from: d */
    public List<String> f9634d;

    public C2143a(Context context, PackageManager packageManager, Uri uri) {
        this.f9631a = packageManager;
        this.f9632b = uri;
        this.f9633c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    @android.annotation.TargetApi(21)
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12895a() {
        /*
            r8 = this;
            java.lang.String r0 = "Start do install Apk."
            java.lang.String r1 = "AppInstaller"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            android.content.pm.PackageInstaller$SessionParams r0 = new android.content.pm.PackageInstaller$SessionParams
            r2 = 1
            r0.<init>(r2)
            android.content.pm.PackageManager r3 = r8.f9631a
            android.content.pm.PackageInstaller r3 = r3.getPackageInstaller()
            r4 = 0
            r5 = 0
            android.net.Uri r6 = r8.f9632b     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            java.lang.String r6 = r6.getPath()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            if (r6 != 0) goto L25
            java.lang.String r8 = "packageLocation is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            return r4
        L23:
            r8 = move-exception
            goto L67
        L25:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            int r0 = r3.createSession(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            android.content.pm.PackageInstaller$Session r5 = r3.openSession(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            r8.m12899e(r7, r5)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            r8.m12897c(r5, r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3e java.io.IOException -> L4a
            if (r5 == 0) goto L52
            r5.close()
            goto L52
        L3e:
            java.lang.String r8 = "do installAPk other error"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L48
        L45:
            r5.close()
        L48:
            r2 = r4
            goto L52
        L4a:
            java.lang.String r8 = "do installAPk IO error"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L48
            goto L45
        L52:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Install Apk end,result is "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r8)
            return r2
        L67:
            if (r5 == 0) goto L6c
            r5.close()
        L6c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.installedapps.C2143a.m12895a():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[PHI: r5
  0x0047: PHI (r5v2 android.content.pm.PackageInstaller$Session) = (r5v1 android.content.pm.PackageInstaller$Session), (r5v3 android.content.pm.PackageInstaller$Session) binds: [B:14:0x0045, B:17:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    @android.annotation.TargetApi(21)
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12896b() {
        /*
            r7 = this;
            java.lang.String r0 = "Start to install multiple apk."
            java.lang.String r1 = "AppInstaller"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            java.util.List<java.lang.String> r0 = r7.f9634d
            boolean r0 = p699v4.C13348q.m80082b(r0)
            r2 = 0
            if (r0 == 0) goto L16
            java.lang.String r7 = "mApksList is empty."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r7)
            return r2
        L16:
            android.content.pm.PackageInstaller$SessionParams r0 = new android.content.pm.PackageInstaller$SessionParams
            r3 = 1
            r0.<init>(r3)
            android.content.pm.PackageManager r4 = r7.f9631a
            android.content.pm.PackageInstaller r4 = r4.getPackageInstaller()
            r5 = 0
            int r0 = r4.createSession(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            android.content.pm.PackageInstaller$Session r5 = r4.openSession(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            r4 = 65536(0x10000, float:9.1835E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            java.util.List<java.lang.String> r6 = r7.f9634d     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            r7.m12900f(r6, r5, r4)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            r7.m12897c(r5, r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40 java.io.IOException -> L4b
            if (r5 == 0) goto L3c
            r5.close()
        L3c:
            r2 = r3
            goto L53
        L3e:
            r7 = move-exception
            goto L54
        L40:
            java.lang.String r7 = "doInstallMultiApk: other error"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r7)     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L53
        L47:
            r5.close()
            goto L53
        L4b:
            java.lang.String r7 = "doInstallMultiApk: IO error"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r7)     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L53
            goto L47
        L53:
            return r2
        L54:
            if (r5 == 0) goto L59
            r5.close()
        L59:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.installedapps.C2143a.m12896b():boolean");
    }

    /* renamed from: c */
    public final void m12897c(PackageInstaller.Session session, int i10) {
        Intent intent = new Intent("com.hicloud.android.clone.installapp.finish.action");
        try {
            intent.setPackage(this.f9633c.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f9633c, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            if (broadcast != null) {
                session.commit(broadcast.getIntentSender());
            }
        } catch (Exception e10) {
            C2111d.m12648d("AppInstaller", "sendPendingIntent Exception: " + e10.getMessage());
        }
    }

    @TargetApi(21)
    /* renamed from: d */
    public boolean m12898d(String str) {
        if (str == null) {
            return false;
        }
        Intent intent = new Intent("com.hicloud.android.clone.uninstallapp.finish.action");
        try {
            intent.setPackage(this.f9633c.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f9633c, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            PackageInstaller packageInstaller = this.f9633c.getPackageManager().getPackageInstaller();
            if (broadcast == null) {
                return false;
            }
            packageInstaller.uninstall(str, broadcast.getIntentSender());
            return true;
        } catch (Exception e10) {
            C2111d.m12648d("AppInstaller", "sendPendingIntent Exception: " + e10.getMessage());
            return false;
        }
    }

    @TargetApi(21)
    /* renamed from: e */
    public final void m12899e(File file, PackageInstaller.Session session) throws IOException {
        byte[] bArr = new byte[65536];
        FileInputStream fileInputStream = new FileInputStream(file);
        long length = file.length();
        OutputStream outputStreamOpenWrite = null;
        try {
            try {
                outputStreamOpenWrite = session.openWrite("PackageInstaller", 0L, length);
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    outputStreamOpenWrite.write(bArr, 0, i10);
                    if (length > 0) {
                        C9149n.m57486a(session, i10 / length);
                    }
                }
                session.fsync(outputStreamOpenWrite);
            } catch (IOException unused) {
                C2111d.m12648d("AppInstaller", "writeApkToSession IOException");
            } catch (Exception unused2) {
                C2111d.m12648d("AppInstaller", "writeApkToSession Exception");
            }
            C13339h.m80014a(fileInputStream);
            C11376j.m68227a(outputStreamOpenWrite);
        } catch (Throwable th2) {
            C13339h.m80014a(fileInputStream);
            C11376j.m68227a(outputStreamOpenWrite);
            throw th2;
        }
    }

    @TargetApi(21)
    /* renamed from: f */
    public final void m12900f(List<String> list, PackageInstaller.Session session, byte[] bArr) throws IOException {
        for (String str : list) {
            if (str == null) {
                C2111d.m12648d("AppInstaller", "apkPath is null");
            } else {
                File file = new File(str);
                if (file.exists()) {
                    String strM82325c = C13694a.m82325c(str);
                    C2111d.m12654j("AppInstaller", "apkName = ", strM82325c);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    OutputStream outputStreamOpenWrite = null;
                    try {
                        try {
                            outputStreamOpenWrite = session.openWrite(strM82325c, 0L, file.length());
                            while (true) {
                                int i10 = fileInputStream.read(bArr);
                                if (i10 == -1) {
                                    break;
                                } else {
                                    outputStreamOpenWrite.write(bArr, 0, i10);
                                }
                            }
                            session.fsync(outputStreamOpenWrite);
                        } catch (IOException unused) {
                            C2111d.m12648d("AppInstaller", "writeApksToSession IOException");
                        } catch (Exception unused2) {
                            C2111d.m12648d("AppInstaller", "writeApksToSession Exception");
                        }
                        C13339h.m80014a(fileInputStream);
                        C11376j.m68227a(outputStreamOpenWrite);
                    } catch (Throwable th2) {
                        C13339h.m80014a(fileInputStream);
                        C11376j.m68227a(outputStreamOpenWrite);
                        throw th2;
                    }
                } else {
                    C2111d.m12648d("AppInstaller", "apk isn't exist.");
                }
            }
        }
    }

    public C2143a(Context context, PackageManager packageManager, List<String> list) {
        this.f9633c = context;
        this.f9631a = packageManager;
        this.f9634d = list;
    }
}
