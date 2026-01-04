package p762x4;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2110c;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.openalliance.p169ad.constant.Constants;
import gy.C10064c;
import gy.C10065d;
import gy.C10067f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import p006a5.AbstractC0048c;
import p699v4.C13339h;

/* renamed from: x4.e */
/* loaded from: classes.dex */
public class C13698e extends AbstractC13696c {

    /* renamed from: u */
    public static byte[] f61660u = new byte[ARImageMetadata.SHADING_MODE];

    /* renamed from: v */
    public static byte[] f61661v = new byte[8192];

    /* renamed from: n */
    public int f61662n;

    /* renamed from: o */
    public C10067f f61663o;

    /* renamed from: p */
    public File f61664p;

    /* renamed from: q */
    public File f61665q;

    /* renamed from: r */
    public int f61666r;

    /* renamed from: s */
    public int f61667s;

    /* renamed from: t */
    public int f61668t;

    public C13698e(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str, Object obj) {
        super(context, abstractC0048c, callback, str, obj);
        this.f61666r = 0;
        this.f61667s = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int length = str.length() + 3;
        if (abstractC0048c == null || TextUtils.isEmpty(abstractC0048c.m196n())) {
            return;
        }
        int length2 = abstractC0048c.m196n().length();
        this.f61664p = new File(new StringBuilder(abstractC0048c.m196n()).delete(length2 - length, length2).toString(), str + ".tar");
    }

    /* renamed from: I */
    public static boolean m82390I(File file) {
        if (!file.exists() || m82392K(file)) {
            return file.mkdir();
        }
        C2111d.m12648d("BackupAppDataBase", "file delete failed");
        return false;
    }

    /* renamed from: J */
    public static boolean m82391J(File file) {
        if (!file.exists() || m82392K(file)) {
            try {
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataBase", "createNewFile fail!");
            }
            return file.createNewFile();
        }
        C2111d.m12648d("BackupAppDataBase", "file delete failed");
        return false;
    }

    /* renamed from: K */
    public static boolean m82392K(File file) {
        File[] fileArrListFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m82392K(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: L */
    public static boolean m82393L(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return file.delete();
        }
        return true;
    }

    /* renamed from: N */
    private int m82394N(ContentValues[] contentValuesArr) {
        ContentValues contentValues;
        if (contentValuesArr == null || (contentValues = contentValuesArr[0]) == null) {
            return -1;
        }
        return contentValues.getAsInteger("apk_version").intValue();
    }

    /* renamed from: T */
    private void m82395T(int[] iArr, byte[] bArr) throws IOException {
        ContentValues[] contentValuesArrM200s = this.f61641i.m200s("apk_file_info", null, "file_index = " + String.valueOf(-1), null, null);
        if (contentValuesArrM200s == null) {
            return;
        }
        int iIndexOf = contentValuesArrM200s[0].getAsString("file_path").indexOf(this.f61639g);
        for (ContentValues contentValues : contentValuesArrM200s) {
            if (contentValues != null) {
                String asString = contentValues.getAsString("file_path");
                String str = this.f61635c + asString;
                if (iIndexOf != -1) {
                    str = this.f61635c + asString.substring(iIndexOf);
                }
                if (str.startsWith(this.f61633a)) {
                    C2111d.m12653i("BackupAppDataBase", "[restoreDirs] don't restore dirName");
                } else {
                    int iIntValue = contentValues.getAsInteger("permission").intValue();
                    m82354l(str, iIntValue, bArr);
                    m82365z(str, iArr, bArr);
                    m82364y(str, iIntValue, bArr);
                }
            }
        }
    }

    /* renamed from: C */
    public final void m82396C(String str, int i10) throws IOException {
        if (this.f61663o != null) {
            C10064c c10064c = new C10064c(str + File.separator);
            c10064c.m62588j0(i10);
            this.f61663o.m62640D(c10064c);
            this.f61663o.m62654s();
        }
    }

    /* renamed from: D */
    public final void m82397D(File file, String str, int i10) throws Throwable {
        if (this.f61663o == null || file == null || !file.exists()) {
            return;
        }
        C10064c c10064c = new C10064c(str);
        c10064c.m62588j0(i10);
        c10064c.m62592l0(file.length());
        this.f61663o.m62640D(c10064c);
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = bufferedInputStream2.read(bArr, 0, 8192);
                        if (i11 != -1) {
                            this.f61663o.write(bArr, 0, i11);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                                C2111d.m12648d("BackupAppDataBase", "archiveFile close Exception");
                            }
                        }
                    }
                    bufferedInputStream2.close();
                    this.f61663o.m62654s();
                } catch (IOException e10) {
                    e = e10;
                    C2111d.m12648d("BackupAppDataBase", "archiveFile Exception");
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                            C2111d.m12648d("BackupAppDataBase", "archiveFile close Exception");
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: E */
    public final void m82398E(byte[] bArr, String str, int i10, int i11) throws IOException {
        if (this.f61663o != null) {
            C10064c c10064c = new C10064c(str);
            c10064c.m62588j0(i11);
            c10064c.m62592l0(i10);
            this.f61663o.m62640D(c10064c);
            this.f61663o.write(bArr, 0, i10);
            this.f61663o.m62654s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        r0 = r3;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("BackupAppDataBase", "backupFileToTar Exception");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        p699v4.C13339h.m80014a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        return r11;
     */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m82399F(boolean r11, java.lang.String r12, byte[] r13, int r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r0 = 0
            com.huawei.android.backup.filelogic.utils.c r1 = r10.f61636d     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            byte[] r1 = r1.m12636g()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r2 = 0
            java.util.Arrays.fill(r1, r2)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            java.io.File r3 = r10.f61665q     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            boolean r3 = m82391J(r3)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            if (r3 != 0) goto L17
            p699v4.C13339h.m80014a(r0)
            return r2
        L17:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            java.io.File r4 = r10.f61665q     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r0 = -1
            r4 = r2
            r5 = r4
        L21:
            com.huawei.android.backup.filelogic.utils.c r6 = r10.f61636d     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            int r6 = r6.m12644s(r13, r1)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            r7 = 1
            r8 = 4
            if (r6 >= r8) goto L2c
            goto L54
        L2c:
            int r0 = com.huawei.android.backup.filelogic.utils.C2110c.m12626a(r1, r2, r8)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            if (r0 > 0) goto L33
            goto L54
        L33:
            if (r4 != 0) goto L51
            int r6 = r5 + r0
            r9 = 1048576(0x100000, float:1.469368E-39)
            if (r6 <= r9) goto L4a
            byte[] r4 = p762x4.C13698e.f61660u     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            r3.write(r4, r2, r5)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            r3.write(r1, r8, r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            r4 = r7
            goto L54
        L45:
            r10 = move-exception
            r0 = r3
            goto L78
        L48:
            r0 = r3
            goto L6c
        L4a:
            byte[] r9 = p762x4.C13698e.f61660u     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            java.lang.System.arraycopy(r1, r8, r9, r5, r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            r5 = r6
            goto L54
        L51:
            r3.write(r1, r8, r0)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
        L54:
            if (r0 > 0) goto L21
            if (r4 == 0) goto L61
            java.io.File r11 = r10.f61665q     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L5e
            r10.m82397D(r11, r12, r14)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L5e
            goto L66
        L5e:
            r0 = r3
            r11 = r7
            goto L6c
        L61:
            byte[] r11 = p762x4.C13698e.f61660u     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L5e
            r10.m82398E(r11, r12, r5, r14)     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L5e
        L66:
            p699v4.C13339h.m80014a(r3)
            goto L77
        L6a:
            r10 = move-exception
            goto L78
        L6c:
            java.lang.String r10 = "BackupAppDataBase"
            java.lang.String r12 = "backupFileToTar Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r10, r12)     // Catch: java.lang.Throwable -> L6a
            p699v4.C13339h.m80014a(r0)
            r7 = r11
        L77:
            return r7
        L78:
            p699v4.C13339h.m80014a(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p762x4.C13698e.m82399F(boolean, java.lang.String, byte[], int):boolean");
    }

    /* renamed from: G */
    public final void m82400G(long j10) throws IOException {
        if (j10 != -1) {
            return;
        }
        byte[] bytes = String.format(Locale.ROOT, "close %s", String.valueOf(j10)).getBytes(Constants.UTF_8);
        byte[] bArrM12636g = this.f61636d.m12636g();
        Arrays.fill(bArrM12636g, 0, this.f61636d.m12644s(bytes, bArrM12636g), (byte) 0);
    }

    /* renamed from: H */
    public final void m82401H(C10065d c10065d) {
        if (c10065d != null) {
            try {
                c10065d.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataBase", "closeStream close fail");
            }
        }
    }

    /* renamed from: M */
    public final int m82402M(ArrayList<ContentValues> arrayList) throws IOException {
        m82406R();
        int size = arrayList.size();
        int i10 = 0;
        try {
            Iterator<ContentValues> it = arrayList.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                try {
                    ContentValues next = it.next();
                    int iIntValue = next.getAsInteger("file_index").intValue();
                    String asString = next.getAsString("file_path");
                    if (!m82405Q(asString, iIntValue)) {
                        throw new IOException("openAndBackupFile fail : " + asString);
                    }
                    int i12 = i11 + 1;
                    try {
                        m82362v(0, i12, size, this.f61638f, this.f61640h);
                        i11 += 2;
                    } catch (IOException unused) {
                        i10 = i12;
                        C2111d.m12648d("BackupAppDataBase", "doRealBackRestore IOException");
                        m82362v(2, i10 + 1, size, this.f61638f, this.f61640h);
                        return 2;
                    }
                } catch (IOException unused2) {
                    i10 = i11;
                }
            }
            return 1;
        } catch (IOException unused3) {
        }
    }

    /* renamed from: O */
    public final HashMap<String, Integer> m82403O(ContentValues[] contentValuesArr) {
        if (contentValuesArr == null) {
            return null;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (ContentValues contentValues : contentValuesArr) {
            if (AbstractC13696c.m82342r()) {
                break;
            }
            if (contentValues.getAsInteger("file_index").intValue() >= 0) {
                map.put(contentValues.getAsString("file_path"), contentValues.getAsInteger("permission"));
            }
        }
        return map;
    }

    /* renamed from: P */
    public final boolean m82404P() {
        try {
            if (!this.f61664p.exists()) {
                if (this.f61664p.createNewFile()) {
                    C2111d.m12646b("BackupAppDataBase", "initTarUtils success");
                } else {
                    C2111d.m12646b("BackupAppDataBase", "initTarUtils fail");
                }
            }
            C10067f c10067f = new C10067f(new FileOutputStream(this.f61664p));
            this.f61663o = c10067f;
            c10067f.m62642F(2);
            return true;
        } catch (IOException unused) {
            C2111d.m12648d("BackupAppDataBase", "create tar file failed!");
            return false;
        }
    }

    /* renamed from: Q */
    public final boolean m82405Q(String str, int i10) throws IOException {
        String strSubstring = str.substring(this.f61662n);
        int iM82356n = m82356n(str, this.f61636d.m12636g());
        if (i10 == -1) {
            try {
                m82396C(strSubstring, iM82356n);
                return true;
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataBase", "openAndBackupFile error");
                return false;
            }
        }
        Locale locale = Locale.ROOT;
        long jM12635f = this.f61636d.m12635f(String.format(locale, "open %s 0 0", str).getBytes(Constants.UTF_8));
        boolean zM82399F = jM12635f != -1 ? m82399F(false, strSubstring, String.format(locale, "read %s 8192", Long.valueOf(jM12635f)).getBytes(Constants.UTF_8), iM82356n) : false;
        m82400G(jM12635f);
        return zM82399F;
    }

    /* renamed from: R */
    public final void m82406R() {
        m82390I(new File(this.f61637e.getCacheDir(), this.f61639g));
    }

    /* renamed from: S */
    public int m82407S() throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC0048c abstractC0048c;
        int iM82394N;
        int i10 = 5;
        if (this.f61637e == null || (abstractC0048c = this.f61641i) == null || (iM82394N = m82394N(abstractC0048c.m200s("apk_info", null, null, null, null))) == -1) {
            return 5;
        }
        if (!C13694a.m82336n(this.f61637e, iM82394N, this.f61639g)) {
            m82362v(9, 0, 0, this.f61638f, this.f61640h);
            return 5;
        }
        ContentValues[] contentValuesArrM200s = this.f61641i.m200s("apk_file_info", null, "file_index <> -1", null, null);
        this.f61668t = (int) new File(this.f61641i.m197o()).length();
        if (contentValuesArrM200s == null) {
            return 5;
        }
        C2110c c2110cM82357o = m82357o();
        this.f61636d = c2110cM82357o;
        if (c2110cM82357o == null) {
            return 5;
        }
        byte[] bArrM12636g = c2110cM82357o.m12636g();
        mo82359q();
        try {
            try {
                int[] iArrM82358p = m82358p(this.f61634b, bArrM12636g);
                if (mo82352i(this.f61637e)) {
                    m82395T(iArrM82358p, bArrM12636g);
                    m82408U(contentValuesArrM200s, iArrM82358p);
                    m82361u(this.f61637e, this.f61634b);
                    i10 = 4;
                } else {
                    C2111d.m12648d("BackupAppDataBase", "restoreApkData() fail on clear appdata");
                }
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataBase", "restoreApkData() IO fail");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupAppDataBase", "restoreApkData() Exception");
            }
            mo82360t(i10);
            return i10;
        } catch (Throwable th2) {
            mo82360t(i10);
            throw th2;
        }
    }

    /* renamed from: U */
    public final void m82408U(ContentValues[] contentValuesArr, int[] iArr) throws Throwable {
        FileInputStream fileInputStream;
        C10065d c10065d;
        C10064c c10064cM62615A;
        HashMap<String, Integer> mapM82403O = m82403O(contentValuesArr);
        if (mapM82403O == null) {
            return;
        }
        C10065d c10065d2 = null;
        c10065d = null;
        C10065d c10065d3 = null;
        c10065d2 = null;
        long jM82409V = -1;
        try {
            try {
                fileInputStream = new FileInputStream(this.f61664p);
                try {
                    c10065d = new C10065d(fileInputStream);
                    try {
                        c10064cM62615A = c10065d.m62615A();
                    } catch (IOException unused) {
                        c10065d3 = c10065d;
                        C2111d.m12648d("BackupAppDataBase", "restoreAppFiles() Exception");
                        m82401H(c10065d3);
                        C13339h.m80014a(fileInputStream);
                        c10065d2 = c10065d3;
                        try {
                            m82400G(jM82409V);
                        } catch (IOException unused2) {
                            C2111d.m12648d("BackupAppDataBase", "closeRestoreFile() Exception");
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c10065d2 = c10065d;
                        m82401H(c10065d2);
                        C13339h.m80014a(fileInputStream);
                        try {
                            m82400G(jM82409V);
                        } catch (IOException unused3) {
                            C2111d.m12648d("BackupAppDataBase", "closeRestoreFile() Exception");
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (IOException unused5) {
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            if (c10064cM62615A == null) {
                m82401H(c10065d);
                C13339h.m80014a(fileInputStream);
                try {
                    m82400G(-1L);
                    return;
                } catch (IOException unused6) {
                    C2111d.m12648d("BackupAppDataBase", "closeRestoreFile() Exception");
                    return;
                }
            }
            m82411X((int) this.f61664p.length());
            while (c10064cM62615A != null) {
                if (c10064cM62615A.m62549B()) {
                    String strSubstring = c10064cM62615A.m62607t().substring(this.f61664p.getParent().length() - 1);
                    if (strSubstring.startsWith(this.f61639g)) {
                        String str = "/data/data" + File.separator + strSubstring;
                        if (mapM82403O.containsKey(str)) {
                            int iIntValue = mapM82403O.get(str).intValue();
                            if (!str.startsWith(this.f61633a)) {
                                jM82409V = m82409V(str, c10065d, iIntValue, iArr);
                            }
                        }
                    }
                }
                c10064cM62615A = c10065d.m62615A();
            }
            int i10 = this.f61668t;
            m82362v(3, i10, i10, this.f61638f, this.f61640h);
            m82401H(c10065d);
            C13339h.m80014a(fileInputStream);
            c10065d2 = c10064cM62615A;
            m82400G(jM82409V);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: V */
    public final long m82409V(String str, C10065d c10065d, int i10, int[] iArr) throws IOException {
        boolean z10;
        long jM12635f = this.f61636d.m12635f(String.format(Locale.ROOT, "open %s 577 0775", str).getBytes(Constants.UTF_8));
        if (jM12635f < 0) {
            return jM12635f;
        }
        while (true) {
            int i11 = c10065d.read(f61661v);
            if (i11 == -1) {
                z10 = true;
                break;
            }
            if (!m82412Y(jM12635f, i11)) {
                z10 = false;
                break;
            }
        }
        m82400G(jM12635f);
        if (z10) {
            m82364y(str, i10, this.f61636d.m12636g());
            m82365z(str, iArr, this.f61636d.m12636g());
        }
        return -1L;
    }

    /* renamed from: W */
    public final void m82410W(int i10) {
        int i11 = this.f61666r + i10;
        this.f61666r = i11;
        int i12 = this.f61668t;
        if (i12 == 0) {
            C2111d.m12648d("BackupAppDataBase", "sendPercentMsgdataFileSize = 0 ");
            return;
        }
        int i13 = i11 / (i12 / 100);
        if (i13 > this.f61667s) {
            this.f61667s = i13;
            m82362v(3, i11, i12, this.f61638f, this.f61640h);
        }
    }

    /* renamed from: X */
    public final void m82411X(int i10) {
        this.f61668t = i10;
    }

    /* renamed from: Y */
    public final boolean m82412Y(long j10, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        System.arraycopy(f61661v, 0, bArr, 0, i10);
        byte[] bArrM12636g = this.f61636d.m12636g();
        int iM12643r = this.f61636d.m12643r(String.format(Locale.ROOT, "write %s %s ", Long.valueOf(j10), Integer.valueOf(i10)).getBytes(Constants.UTF_8), bArr, bArrM12636g);
        if (iM12643r <= 0) {
            return false;
        }
        int iM12626a = C2110c.m12626a(bArrM12636g, 0, 4);
        Arrays.fill(bArrM12636g, 0, iM12643r, (byte) 0);
        if (iM12626a != -1) {
            m82410W(i10);
            return true;
        }
        C2111d.m12648d("BackupAppDataBase", "writeSingleFile invalid socket return  " + iM12626a);
        return false;
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: f */
    public boolean mo82349f(String str) throws PackageManager.NameNotFoundException {
        int iM82329g = C13694a.m82329g(this.f61637e, this.f61639g);
        if (iM82329g < 0) {
            return false;
        }
        try {
            int[] iArrM82358p = m82358p(str, this.f61636d.m12636g());
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", Integer.valueOf(iArrM82358p[0]));
            contentValues.put("gid", Integer.valueOf(iArrM82358p[1]));
            contentValues.put("apk_version", Integer.valueOf(iM82329g));
            return this.f61641i.m185A("apk_info", contentValues) != 2;
        } catch (IOException unused) {
            C2111d.m12648d("BackupAppDataBase", "backupApkInfo Exception");
            return false;
        }
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: m */
    public int mo82355m(ArrayList<ContentValues> arrayList) throws IOException {
        if (arrayList == null) {
            C2111d.m12653i("BackupAppDataBase", "doRealBackRestore fileInfo is null");
            return 1;
        }
        this.f61641i.mo169a();
        int size = arrayList.size();
        int iIndexOf = arrayList.get(0).getAsString("file_path").indexOf(this.f61639g);
        for (int i10 = 0; i10 < size; i10++) {
            ContentValues contentValues = new ContentValues(arrayList.get(i10));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/data/data");
            String str = File.separator;
            sb2.append(str);
            sb2.append(contentValues.getAsString("file_path"));
            String string = sb2.toString();
            if (iIndexOf != -1) {
                string = "/data/data" + str + contentValues.getAsString("file_path").substring(iIndexOf);
            }
            contentValues.put("file_path", string);
            if (this.f61641i.m185A("apk_file_info", contentValues) != 1) {
                this.f61636d.m12633d();
                return 2;
            }
        }
        this.f61641i.mo171c();
        if (m82404P()) {
            return m82402M(arrayList);
        }
        m82362v(2, 0, 0, this.f61638f, this.f61640h);
        return 2;
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: q */
    public void mo82359q() {
        super.mo82359q();
        this.f61662n = this.f61635c.length();
        this.f61665q = new File(this.f61637e.getCacheDir(), "temp");
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: t */
    public void mo82360t(int i10) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.mo82360t(i10);
        C10067f c10067f = this.f61663o;
        if (c10067f != null) {
            try {
                c10067f.flush();
                this.f61663o.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataBase", "releaseResource error");
            }
        }
        if (i10 == 2) {
            if (this.f61664p.delete()) {
                C2111d.m12646b("BackupAppDataBase", "releaseResource success");
            } else {
                C2111d.m12646b("BackupAppDataBase", "releaseResource fail");
            }
        }
        m82393L(this.f61665q);
    }
}
