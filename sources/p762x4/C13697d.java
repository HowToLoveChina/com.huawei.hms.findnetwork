package p762x4;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2110c;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import p006a5.AbstractC0048c;
import p762x4.AbstractC13696c;

/* renamed from: x4.d */
/* loaded from: classes.dex */
public class C13697d extends AbstractC13696c {

    /* renamed from: n */
    public long f61649n;

    /* renamed from: o */
    public int f61650o;

    /* renamed from: p */
    public int f61651p;

    /* renamed from: q */
    public int f61652q;

    /* renamed from: r */
    public int f61653r;

    /* renamed from: s */
    public int f61654s;

    /* renamed from: t */
    public long f61655t;

    /* renamed from: x4.d$b */
    public static class b {

        /* renamed from: a */
        public final Cursor f61656a;

        /* renamed from: b */
        public final String f61657b;

        /* renamed from: c */
        public final int f61658c;

        /* renamed from: d */
        public final int f61659d;

        /* renamed from: a */
        public Cursor m82386a() {
            return this.f61656a;
        }

        /* renamed from: b */
        public int m82387b() {
            return this.f61658c;
        }

        /* renamed from: c */
        public String m82388c() {
            return this.f61657b;
        }

        /* renamed from: d */
        public int m82389d() {
            return this.f61659d;
        }

        public b(Cursor cursor, String str, int i10, int i11) {
            this.f61656a = cursor;
            this.f61657b = str;
            this.f61658c = i10;
            this.f61659d = i11;
        }
    }

    public C13697d(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str, Object obj) {
        super(context, abstractC0048c, callback, str, obj);
        this.f61650o = 0;
    }

    /* renamed from: C */
    public final boolean m82369C(String str, int i10) throws Throwable {
        int i11;
        byte[] bArrM12636g = this.f61636d.m12636g();
        long j10 = -1;
        try {
            try {
                Locale locale = Locale.ROOT;
                long jM12635f = this.f61636d.m12635f(String.format(locale, "open %s 0 0", str).getBytes(Constants.UTF_8));
                if (jM12635f < 0) {
                    m82372F(str, jM12635f, bArrM12636g);
                    return false;
                }
                try {
                    byte[] bytes = String.format(locale, "read %s 8192", Long.valueOf(jM12635f)).getBytes(Constants.UTF_8);
                    Arrays.fill(bArrM12636g, (byte) 0);
                    int i12 = 0;
                    while (!AbstractC13696c.m82342r()) {
                        m82371E();
                        if (this.f61636d.m12644s(bytes, bArrM12636g) < 4) {
                            m82372F(str, jM12635f, bArrM12636g);
                            return false;
                        }
                        int iM12626a = C2110c.m12626a(bArrM12636g, 0, 4);
                        if (i12 == 0 || iM12626a > 0) {
                            byte[] bArr = new byte[iM12626a];
                            System.arraycopy(bArrM12636g, 4, bArr, 0, iM12626a);
                            ContentValues contentValues = new ContentValues();
                            contentValues.clear();
                            i11 = iM12626a;
                            m82383Q(i10, iM12626a, i12, bArr, contentValues);
                            i12++;
                            if (this.f61641i.m185A("apk_file_data", contentValues) == 2) {
                                C2111d.m12648d("BackupRestoreAppData", "storeHandler.write( AppFileData.TABLE_NAME, cv) error!");
                                m82372F(str, jM12635f, bArrM12636g);
                                return false;
                            }
                        } else {
                            i11 = iM12626a;
                        }
                        m82370D();
                        if (i11 <= 0) {
                            m82372F(str, jM12635f, bArrM12636g);
                            return true;
                        }
                    }
                    m82372F(str, jM12635f, bArrM12636g);
                    return false;
                } catch (IOException unused) {
                    j10 = jM12635f;
                    C2111d.m12648d("BackupRestoreAppData", "backupApkDataFile Exception");
                    m82372F(str, j10, bArrM12636g);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    j10 = jM12635f;
                    m82372F(str, j10, bArrM12636g);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: D */
    public final void m82370D() {
        if (this.f61650o >= 2097152) {
            this.f61641i.mo171c();
            this.f61650o = 0;
        }
    }

    /* renamed from: E */
    public final void m82371E() {
        if (this.f61650o == 0) {
            this.f61641i.mo169a();
        }
    }

    /* renamed from: F */
    public final void m82372F(String str, long j10, byte[] bArr) {
        if (j10 > 0) {
            try {
                this.f61636d.m12644s(String.format(Locale.ROOT, "close %s", String.valueOf(j10)).getBytes(Constants.UTF_8), bArr);
                Arrays.fill(bArr, (byte) 0);
            } catch (IOException unused) {
                C2111d.m12648d("BackupRestoreAppData", "backupApkDataFile close handle socket write error Exception : " + str);
            }
        }
    }

    /* renamed from: G */
    public final void m82373G(String str, byte[] bArr, long j10, long j11) {
        if (j11 >= 0) {
            try {
                Arrays.fill(bArr, 0, this.f61636d.m12644s(String.format(Locale.ROOT, "close %s", String.valueOf(j10)).getBytes(Constants.UTF_8), bArr), (byte) 0);
            } catch (UnsupportedEncodingException unused) {
                C2111d.m12648d("BackupRestoreAppData", "writeSingleFile close handle string to byte[] Exception");
            } catch (IOException unused2) {
                C2111d.m12648d("BackupRestoreAppData", "writeSingleFile close handle socket write error Exception");
            }
        }
    }

    /* renamed from: H */
    public final int m82374H(ContentValues[] contentValuesArr) {
        if (contentValuesArr == null || contentValuesArr.length <= 0) {
            return -1;
        }
        return contentValuesArr[0].getAsInteger("apk_version").intValue();
    }

    /* renamed from: I */
    public final Bundle m82375I(int i10, long j10) {
        Bundle bundle = new Bundle();
        if (i10 == 5) {
            this.f61649n = this.f61655t;
        } else {
            this.f61649n += j10;
        }
        bundle.putLong("current_restore", this.f61649n);
        bundle.putLong("totalsize", this.f61655t);
        return bundle;
    }

    /* renamed from: J */
    public final Bundle m82376J(ContentValues[] contentValuesArr, int i10, int i11) {
        C2111d.m12653i("BackupRestoreAppData", "get file list begin, file length:" + i11 + ";num:" + i10);
        HashSet hashSet = new HashSet();
        int i12 = i10;
        while (true) {
            if (i12 > i11) {
                i12 = i10;
                break;
            }
            if (hashSet.size() >= 500) {
                C2111d.m12654j("BackupRestoreAppData", "get file list 500, file length:", Integer.valueOf(i11), ";index.size():", Integer.valueOf(hashSet.size()), ";num:", Integer.valueOf(i10), ";count:", Integer.valueOf(i12), ";i:", Integer.valueOf(i12));
                break;
            }
            if (i12 == i11) {
                C2111d.m12653i("BackupRestoreAppData", "get file list end, file length:" + i11 + ";index.size():" + hashSet.size() + ";num:" + i10 + ";count:" + i11 + ";i:" + i12);
                i12 = i11;
                break;
            }
            try {
                Integer asInteger = contentValuesArr[i12].getAsInteger("file_index");
                asInteger.intValue();
                hashSet.add(asInteger);
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupRestoreAppData", "index IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupRestoreAppData", "index Exception");
            }
            i12++;
        }
        if (hashSet.isEmpty()) {
            C2111d.m12648d("BackupRestoreAppData", "get file list index empty, file length:" + i11 + ";index.size():" + hashSet.size() + ";num:" + i10);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("file_index in");
        sb2.append("(");
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sb2.append(((Integer) it.next()).intValue());
            sb2.append(",");
        }
        sb2.deleteCharAt(sb2.length() - 1).append(")");
        C2111d.m12646b("BackupRestoreAppData", "where end:" + sb2.toString());
        Bundle bundle = new Bundle();
        bundle.putInt("fileindex_number", i12);
        bundle.putString("select_fileindex", sb2.toString());
        return bundle;
    }

    /* renamed from: K */
    public final int m82377K(ContentValues[] contentValuesArr, int i10) {
        if (contentValuesArr.length < 500) {
            int length = contentValuesArr.length;
            C2111d.m12654j("BackupRestoreAppData", "files is less than 1000, filesNum:", Integer.valueOf(contentValuesArr.length), ";num:", Integer.valueOf(length));
            return length;
        }
        Bundle bundleM82376J = m82376J(contentValuesArr, i10, contentValuesArr.length);
        if (bundleM82376J == null) {
            return i10;
        }
        int i11 = bundleM82376J.getInt("fileindex_number");
        C2111d.m12654j("BackupRestoreAppData", "files is over 500, get fileindex end, filesNum:", Integer.valueOf(contentValuesArr.length), ";num:", Integer.valueOf(i11));
        return i11;
    }

    /* renamed from: L */
    public final String m82378L(ContentValues[] contentValuesArr, int i10) {
        Bundle bundleM82376J;
        if (contentValuesArr.length < 500 || (bundleM82376J = m82376J(contentValuesArr, i10, contentValuesArr.length)) == null) {
            return null;
        }
        String string = bundleM82376J.getString("select_fileindex");
        C2111d.m12654j("BackupRestoreAppData", "files is over 500, get fileindex end, filesNum:", Integer.valueOf(contentValuesArr.length), "where:", string);
        return string;
    }

    /* renamed from: M */
    public int m82379M() throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC0048c abstractC0048c;
        int iM82374H;
        int i10 = 5;
        if (this.f61637e == null || (abstractC0048c = this.f61641i) == null || (iM82374H = m82374H(abstractC0048c.m200s("apk_info", null, null, null, null))) == -1) {
            return 5;
        }
        if (!C13694a.m82336n(this.f61637e, iM82374H, this.f61639g)) {
            m82362v(9, 0, 0, this.f61638f, this.f61640h);
            return 5;
        }
        ContentValues[] contentValuesArrM200s = this.f61641i.m200s("apk_file_info", null, "file_index <> -1", null, null);
        this.f61655t = new File(this.f61641i.m197o()).length();
        if (contentValuesArrM200s == null) {
            return 5;
        }
        C2110c c2110cM82357o = m82357o();
        this.f61636d = c2110cM82357o;
        if (c2110cM82357o == null) {
            return 5;
        }
        mo82359q();
        byte[] bArrM12636g = this.f61636d.m12636g();
        try {
            try {
                try {
                    int[] iArrM82358p = m82358p(this.f61634b, bArrM12636g);
                    if (mo82352i(this.f61637e)) {
                        m82380N(iArrM82358p, bArrM12636g);
                        C2111d.m12653i("BackupRestoreAppData", "time test --- restore apk data begin");
                        m82381O(contentValuesArrM200s, iArrM82358p, bArrM12636g);
                        C2111d.m12653i("BackupRestoreAppData", "time test --- restore apk data end");
                        m82361u(this.f61637e, this.f61634b);
                        i10 = 4;
                    } else {
                        C2111d.m12648d("BackupRestoreAppData", "restoreApkData() fail on clear appdata");
                    }
                } catch (IOException unused) {
                    C2111d.m12648d("BackupRestoreAppData", "restoreApkData() IO fail");
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupRestoreAppData", "restoreApkData() Exception");
            }
            mo82360t(i10);
            return i10;
        } catch (Throwable th2) {
            mo82360t(i10);
            throw th2;
        }
    }

    /* renamed from: N */
    public final void m82380N(int[] iArr, byte[] bArr) {
        ContentValues[] contentValuesArrM200s = this.f61641i.m200s("apk_file_info", null, "file_index = " + String.valueOf(-1), null, null);
        if (contentValuesArrM200s == null) {
            return;
        }
        int iIndexOf = contentValuesArrM200s[0].getAsString("file_path").indexOf(this.f61639g);
        for (ContentValues contentValues : contentValuesArrM200s) {
            String asString = contentValues.getAsString("file_path");
            String str = this.f61635c + asString;
            if (iIndexOf != -1) {
                str = this.f61635c + asString.substring(iIndexOf);
            }
            if (str.startsWith(this.f61633a)) {
                C2111d.m12653i("BackupRestoreAppData", "don't restore dirName");
            } else {
                int iIntValue = contentValues.getAsInteger("permission").intValue();
                try {
                    m82354l(str, iIntValue, bArr);
                    m82365z(str, iArr, bArr);
                    m82364y(str, iIntValue, bArr);
                } catch (IOException unused) {
                    C2111d.m12648d("BackupRestoreAppData", "restoreApkDataDirs Exception");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0149, code lost:
    
        throw new java.io.IOException("cursor init Err on restoreFiles!");
     */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m82381O(android.content.ContentValues[] r23, int[] r24, byte[] r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p762x4.C13697d.m82381O(android.content.ContentValues[], int[], byte[]):void");
    }

    /* renamed from: P */
    public final void m82382P(int i10, long j10) throws IOException {
        int i11 = this.f61654s + 1;
        this.f61654s = i11;
        if (j10 >= 0) {
            m82363w(new AbstractC13696c.a(3, i11, i10), this.f61638f, this.f61640h, m82375I(3, j10));
        } else {
            m82363w(new AbstractC13696c.a(5, i11, i10), this.f61638f, this.f61640h, m82375I(5, j10));
            throw new IOException("writeSingleFile err!");
        }
    }

    /* renamed from: Q */
    public final void m82383Q(int i10, int i11, int i12, byte[] bArr, ContentValues contentValues) {
        contentValues.put("file_data", bArr);
        contentValues.put("data_index", Integer.valueOf(i12));
        contentValues.put("file_index", Integer.valueOf(i10));
        contentValues.put("file_length", Integer.valueOf(i11));
        int i13 = this.f61650o;
        if (i11 == 0) {
            i11 = 1;
        }
        this.f61650o = i13 + i11;
    }

    /* renamed from: R */
    public final int m82384R(ArrayList<ContentValues> arrayList, int i10) {
        int iIndexOf = arrayList.get(0).getAsString("file_path").indexOf(this.f61639g);
        for (int i11 = 0; i11 < i10; i11++) {
            ContentValues contentValues = new ContentValues(arrayList.get(i11));
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
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: S */
    public final long m82385S(b bVar, int[] iArr, byte[] bArr) throws Throwable {
        long jM12635f;
        long j10;
        long j11 = -1;
        long j12 = 0;
        try {
            jM12635f = this.f61636d.m12635f(String.format(Locale.ROOT, "open %s 577 0775", bVar.m82388c()).getBytes(Constants.UTF_8));
            if (jM12635f < 0) {
                m82373G(bVar.m82388c(), bArr, jM12635f, 0L);
                return -1L;
            }
            try {
                Arrays.fill(bArr, 0, bArr.length, (byte) 0);
                while (!AbstractC13696c.m82342r()) {
                    if (bVar.m82387b() == bVar.m82386a().getInt(this.f61651p)) {
                        int i10 = bVar.m82386a().getInt(this.f61652q);
                        if (i10 > 0) {
                            j12 += i10;
                            int iM12643r = this.f61636d.m12643r(String.format(Locale.ROOT, "write %s %s ", Long.valueOf(jM12635f), Integer.valueOf(i10)).getBytes(Constants.UTF_8), bVar.m82386a().getBlob(this.f61653r), bArr);
                            if (iM12643r <= 0) {
                                C2111d.m12649e("BackupRestoreAppData", "writeSingleFile invalid command or data ", bVar.m82388c());
                                m82373G(bVar.m82388c(), bArr, jM12635f, j12);
                                return -1L;
                            }
                            int iM12626a = C2110c.m12626a(bArr, 0, 4);
                            Arrays.fill(bArr, 0, iM12643r, (byte) 0);
                            if (iM12626a == -1) {
                                C2111d.m12649e("BackupRestoreAppData", "writeSingleFile invalid socket return  ", String.valueOf(iM12626a), bVar.m82388c());
                                m82373G(bVar.m82388c(), bArr, jM12635f, j12);
                                return -1L;
                            }
                            j10 = -1;
                        } else {
                            j10 = j11;
                        }
                        if (bVar.m82386a().moveToNext()) {
                            j11 = j10;
                        }
                    }
                    long j13 = j12;
                    m82373G(bVar.m82388c(), bArr, jM12635f, j13);
                    m82364y(bVar.m82388c(), bVar.m82389d(), bArr);
                    m82365z(bVar.m82388c(), iArr, bArr);
                    return j13;
                }
                C2111d.m12653i("BackupRestoreAppData", "writeSingleFile ，user abort()");
                m82373G(bVar.m82388c(), bArr, jM12635f, j12);
                return j11;
            } catch (Throwable th2) {
                th = th2;
                m82373G(bVar.m82388c(), bArr, jM12635f, 0L);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            jM12635f = -1;
        }
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
            C2111d.m12648d("BackupRestoreAppData", "backupApkInfo Exception");
            return false;
        }
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: i */
    public boolean mo82352i(Context context) {
        return super.mo82352i(context);
    }

    @Override // p762x4.AbstractC13696c
    /* renamed from: m */
    public int mo82355m(ArrayList<ContentValues> arrayList) throws IOException {
        if (arrayList == null) {
            C2111d.m12653i("BackupRestoreAppData", "doRealBackRestore fileInfo is null");
            return 2;
        }
        this.f61641i.mo169a();
        int size = arrayList.size();
        if (m82384R(arrayList, size) != 0) {
            this.f61636d.m12633d();
            return 2;
        }
        this.f61641i.mo171c();
        this.f61650o = 0;
        int size2 = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size2) {
            ContentValues contentValues = arrayList.get(i11);
            int iIntValue = contentValues.getAsInteger("file_index").intValue();
            int i12 = i10 + 1;
            if (iIntValue == -1) {
                m82362v(0, i12, size, this.f61638f, this.f61640h);
            } else {
                String asString = contentValues.getAsString("file_path");
                if (!m82369C(asString, iIntValue)) {
                    C2111d.m12648d("BackupRestoreAppData", "backupApkDataFile err, file path:" + asString);
                    this.f61636d.m12633d();
                    this.f61641i.m190h();
                    m82362v(2, i12, size, this.f61638f, this.f61640h);
                    return 2;
                }
                m82362v(0, i12, size, this.f61638f, this.f61640h);
            }
            if (AbstractC13696c.m82342r()) {
                this.f61636d.m12633d();
                this.f61641i.m190h();
                return 1;
            }
            i11++;
            i10 = i12;
        }
        if (this.f61650o != 0) {
            this.f61641i.mo171c();
            this.f61650o = 0;
        }
        return 1;
    }
}
