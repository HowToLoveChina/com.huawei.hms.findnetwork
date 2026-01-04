package com.huawei.android.backup.filelogic.utils;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.service.utils.C2157a;
import p229di.C9153r;
import p699v4.C13343l;

/* renamed from: com.huawei.android.backup.filelogic.utils.a */
/* loaded from: classes.dex */
public class C2108a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0053 A[PHI: r3
  0x0053: PHI (r3v7 android.content.ContentProviderClient) = 
  (r3v4 android.content.ContentProviderClient)
  (r3v5 android.content.ContentProviderClient)
  (r3v6 android.content.ContentProviderClient)
  (r3v8 android.content.ContentProviderClient)
 binds: [B:99:0x0075, B:108:0x00ad, B:104:0x0092, B:91:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m12615a(android.content.Context r3, android.net.Uri r4, java.lang.String r5, java.lang.String r6, android.os.Bundle r7) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "ContextUtil"
            if (r3 != 0) goto Lb
            java.lang.String r3 = "callContentResolver context is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            return r0
        Lb:
            if (r4 != 0) goto L13
            java.lang.String r3 = "callContentResolver uri is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            return r0
        L13:
            if (r5 != 0) goto L1b
            java.lang.String r3 = "callContentResolver method is null"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)
            return r0
        L1b:
            java.lang.String r2 = "backup_query"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L39
            java.lang.String r2 = "backup"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L39
            if (r7 != 0) goto L36
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            m12623i(r3, r2)
            goto L39
        L36:
            m12623i(r3, r7)
        L39:
            android.content.ContentProviderClient r3 = m12617c(r3, r4)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59 android.os.RemoteException -> L76 java.lang.IllegalArgumentException -> L93
            if (r3 == 0) goto L51
            android.os.Bundle r4 = r3.call(r5, r6, r7)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4b android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f
            r3.release()
            return r4
        L47:
            r4 = move-exception
            r0 = r3
            goto Lb1
        L4b:
            r4 = move-exception
            goto L5b
        L4d:
            r4 = move-exception
            goto L78
        L4f:
            r4 = move-exception
            goto L95
        L51:
            if (r3 == 0) goto Lb0
        L53:
            r3.release()
            goto Lb0
        L57:
            r4 = move-exception
            goto Lb1
        L59:
            r4 = move-exception
            r3 = r0
        L5b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "catch Exception when callContentResolver: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L47
            r5.append(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L47
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r4)     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto Lb0
            goto L53
        L76:
            r4 = move-exception
            r3 = r0
        L78:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "catch RemoteException when callContentResolver: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L47
            r5.append(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L47
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r4)     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto Lb0
            goto L53
        L93:
            r4 = move-exception
            r3 = r0
        L95:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "catch IllegalArgumentException when callContentResolver: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L47
            r5.append(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L47
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r4)     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto Lb0
            goto L53
        Lb0:
            return r0
        Lb1:
            if (r0 == 0) goto Lb6
            r0.release()
        Lb6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.filelogic.utils.C2108a.m12615a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* renamed from: b */
    public static Bundle m12616b(Context context, String str, String str2, String str3, Bundle bundle) {
        Uri uri;
        if (context == null || str == null || str2 == null || (uri = Uri.parse(str)) == null) {
            return null;
        }
        return m12615a(context, uri, str2, str3, bundle);
    }

    /* renamed from: c */
    public static ContentProviderClient m12617c(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                return context.getContentResolver().acquireUnstableContentProviderClient(uri);
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0029: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:88:0x0029 */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00aa A[Catch: all -> 0x0028, TryCatch #4 {all -> 0x0028, blocks: (B:85:0x001f, B:100:0x0040, B:105:0x0050, B:111:0x0063, B:124:0x008b, B:129:0x00aa, B:130:0x00ad, B:96:0x0036), top: B:138:0x0005 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.database.Cursor m12618d(android.content.Context r10, android.net.Uri r11, java.lang.String[] r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "ContextUtil"
            r1 = 0
            if (r10 == 0) goto Lb4
            if (r11 != 0) goto L9
            goto Lb4
        L9:
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31 android.os.RemoteException -> L33
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r11)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31 android.os.RemoteException -> L33
            if (r2 != 0) goto L19
            if (r2 == 0) goto L18
            r2.release()
        L18:
            return r1
        L19:
            r3 = r2
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L28 android.os.RemoteException -> L2c java.lang.Exception -> L36
        L23:
            r2.release()
            goto La7
        L28:
            r10 = move-exception
            r1 = r2
            goto Lae
        L2c:
            r3 = move-exception
            goto L3e
        L2e:
            r10 = move-exception
            goto Lae
        L31:
            r2 = r1
            goto L36
        L33:
            r3 = move-exception
            r2 = r1
            goto L3e
        L36:
            java.lang.String r10 = "getCursor unstableProvider Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto La7
            goto L23
        L3e:
            if (r2 == 0) goto L44
            r2.release()     // Catch: java.lang.Throwable -> L28
            r2 = r1
        L44:
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L6c android.os.RemoteException -> L6e
            android.content.ContentProviderClient r10 = r10.acquireUnstableContentProviderClient(r11)     // Catch: java.lang.Throwable -> L6c android.os.RemoteException -> L6e
            if (r10 != 0) goto L59
            if (r10 == 0) goto L53
            r10.release()     // Catch: java.lang.Throwable -> L28
        L53:
            if (r2 == 0) goto L58
            r2.release()
        L58:
            return r1
        L59:
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L67 android.os.RemoteException -> L6a
        L63:
            r10.release()     // Catch: java.lang.Throwable -> L28
            goto L8b
        L67:
            r11 = move-exception
            r1 = r10
            goto La8
        L6a:
            r11 = move-exception
            goto L70
        L6c:
            r11 = move-exception
            goto La8
        L6e:
            r11 = move-exception
            r10 = r1
        L70:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r12.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r13 = "getCursor unstableProviderNext Exception: "
            r12.append(r13)     // Catch: java.lang.Throwable -> L67
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L67
            r12.append(r11)     // Catch: java.lang.Throwable -> L67
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> L67
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r11)     // Catch: java.lang.Throwable -> L67
            if (r10 == 0) goto L8b
            goto L63
        L8b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r10.<init>()     // Catch: java.lang.Throwable -> L28
            java.lang.String r11 = "getCursor unstableProvider RemoteException: "
            r10.append(r11)     // Catch: java.lang.Throwable -> L28
            java.lang.String r11 = r3.getMessage()     // Catch: java.lang.Throwable -> L28
            r10.append(r11)     // Catch: java.lang.Throwable -> L28
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L28
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto La7
            goto L23
        La7:
            return r1
        La8:
            if (r1 == 0) goto Lad
            r1.release()     // Catch: java.lang.Throwable -> L28
        Lad:
            throw r11     // Catch: java.lang.Throwable -> L28
        Lae:
            if (r1 == 0) goto Lb3
            r1.release()
        Lb3:
            throw r10
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.filelogic.utils.C2108a.m12618d(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* renamed from: e */
    public static int m12619e() {
        return C9153r.m57494b();
    }

    /* renamed from: f */
    public static boolean m12620f() {
        return m12619e() > 0;
    }

    /* renamed from: g */
    public static boolean m12621g(Context context, String str) {
        if (context == null || str == null || !C2157a.m13212t().contains(str)) {
            return false;
        }
        return m12622h(context) || m12620f();
    }

    /* renamed from: h */
    public static boolean m12622h(Context context) {
        if (!C2157a.m13177L(context)) {
            return false;
        }
        if (context == null) {
            C2111d.m12653i("ContextUtil", "isPrivacyUser context is null");
            return false;
        }
        int iM12619e = m12619e();
        if (iM12619e == -1) {
            return false;
        }
        return C2113f.m12661a(context, iM12619e);
    }

    /* renamed from: i */
    public static void m12623i(Context context, Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("have_lock_screen_password", C13343l.m80060b(context));
        }
    }
}
