package com.huawei.android.backup.filelogic.utils;

import java.util.concurrent.Callable;

/* renamed from: com.huawei.android.backup.filelogic.utils.e */
/* loaded from: classes.dex */
public class CallableC2112e implements Callable<Integer> {
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Integer call() throws java.lang.Exception {
        /*
            r12 = this;
            java.lang.String r12 = "Close local Socket Error!"
            java.lang.String r0 = "filebackup close resource"
            java.lang.String r1 = "SocketCallable"
            android.net.LocalSocketAddress r2 = new android.net.LocalSocketAddress
            java.lang.String r3 = "filebackup"
            android.net.LocalSocketAddress$Namespace r4 = android.net.LocalSocketAddress.Namespace.RESERVED
            r2.<init>(r3, r4)
            r3 = 1
            r4 = 150(0x96, double:7.4E-322)
            r6 = 0
            r7 = 0
            android.net.LocalSocket r8 = new android.net.LocalSocket     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L80
            r8.<init>()     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L80
            r6 = r7
            r9 = r6
        L1b:
            if (r6 != 0) goto L58
            r10 = 3
            if (r9 >= r10) goto L58
            java.lang.String r6 = "init.svc.filebackup"
            java.lang.String r10 = "none"
            java.lang.String r6 = p728w4.C13529c.m81424b(r6, r10)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            if (r6 == 0) goto L45
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            r10.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            java.lang.String r11 = "filebackup result = "
            r10.append(r11)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            r10.append(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r10)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            goto L4a
        L3f:
            r2 = move-exception
            r6 = r8
            goto Lb0
        L43:
            r6 = r8
            goto L80
        L45:
            java.lang.String r10 = "filebackup result = null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r10)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
        L4a:
            java.lang.String r10 = "running"
            boolean r6 = r10.equals(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            if (r6 != 0) goto L55
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
        L55:
            int r9 = r9 + 1
            goto L1b
        L58:
            if (r6 == 0) goto L6f
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            r8.connect(r2)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            r8.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L67:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r12)
        L6a:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            return r12
        L6f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L43
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            r8.close()     // Catch: java.io.IOException -> L7a
            goto L7d
        L7a:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r12)
        L7d:
            return r2
        L7e:
            r2 = move-exception
            goto Lb0
        L80:
            java.lang.String r8 = "first connect local socket failed!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)     // Catch: java.lang.Throwable -> L7e
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L9a
            r6.connect(r2)     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L9a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L7e java.io.IOException -> L9a
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            r6.close()     // Catch: java.io.IOException -> L96
            goto L99
        L96:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r12)
        L99:
            return r2
        L9a:
            java.lang.String r2 = "second connect local socket failed!"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L7e
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            if (r6 == 0) goto Laf
            r6.close()     // Catch: java.io.IOException -> Lac
            goto Laf
        Lac:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r12)
        Laf:
            return r2
        Lb0:
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
            if (r6 == 0) goto Lbc
            r6.close()     // Catch: java.io.IOException -> Lb9
            goto Lbc
        Lb9:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r12)
        Lbc:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.filelogic.utils.CallableC2112e.call():java.lang.Integer");
    }
}
