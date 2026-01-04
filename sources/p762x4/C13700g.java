package p762x4;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p006a5.AbstractC0048c;
import p699v4.C13345n;
import p762x4.AbstractC13696c;
import p798y4.C13909a;

/* renamed from: x4.g */
/* loaded from: classes.dex */
public class C13700g extends C13699f {

    /* renamed from: g */
    public int f61675g;

    /* renamed from: h */
    public int f61676h;

    /* renamed from: i */
    public int f61677i;

    /* renamed from: j */
    public ArrayList<ContentValues> f61678j;

    /* renamed from: k */
    public long f61679k;

    /* renamed from: l */
    public int f61680l;

    /* renamed from: m */
    public int f61681m;

    /* renamed from: n */
    public int f61682n;

    /* renamed from: o */
    public int f61683o;

    /* renamed from: p */
    public long f61684p;

    /* renamed from: q */
    public C13702i f61685q;

    public C13700g(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str, Object obj) {
        super(context, abstractC0048c, callback, str, obj);
        this.f61675g = 0;
        this.f61676h = 0;
        this.f61685q = new C13702i(context, str);
    }

    /* renamed from: d */
    public int m82416d() {
        if (this.f61685q == null) {
            C2111d.m12648d("BackupAppDataToDB", "backupApkData fail mReaderFiles is null");
            return 2;
        }
        if (!m82417e()) {
            return 2;
        }
        this.f61677i = 0;
        if (!m82432t()) {
            C2111d.m12653i("BackupAppDataToDB", "writeFileAttrToDB fail");
            return 2;
        }
        if (this.f61677i > 0) {
            return !m82433u() ? 2 : 1;
        }
        C2111d.m12653i("BackupAppDataToDB", "need backup file is 0");
        m82414b(0, 0, 0, this.f61672c, this.f61673d);
        return 1;
    }

    /* renamed from: e */
    public final boolean m82417e() throws PackageManager.NameNotFoundException {
        int iM82329g = C13694a.m82329g(this.f61670a, this.f61674e);
        if (iM82329g < 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("uid", (Integer) 0);
        contentValues.put("gid", (Integer) 0);
        contentValues.put("apk_version", Integer.valueOf(iM82329g));
        return this.f61671b.m185A("apk_info", contentValues) != 2;
    }

    /* renamed from: f */
    public final void m82418f(FileInputStream fileInputStream) throws IOException {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataToDB", "fileInputStream close Exception");
            }
        }
    }

    /* renamed from: g */
    public final void m82419g(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupAppDataToDB", "fos.close() Exception");
            }
        }
    }

    /* renamed from: h */
    public final void m82420h(ContentValues[] contentValuesArr, Cursor cursor, int i10, int i11, int i12) throws IOException {
        this.f61683o = cursor.getColumnIndexOrThrow("file_data");
        this.f61681m = cursor.getColumnIndexOrThrow("file_index");
        this.f61682n = cursor.getColumnIndexOrThrow("file_length");
        while (i12 < i11 && !C13699f.m82413a()) {
            int iIntValue = contentValuesArr[i12].getAsInteger("file_index").intValue();
            if (iIntValue >= 0) {
                long jM82431s = m82431s(cursor, contentValuesArr[i12].getAsString("file_path").replace((char) 127, ' '), iIntValue);
                int i13 = this.f61680l + 1;
                this.f61680l = i13;
                if (jM82431s < 0) {
                    m82415c(new AbstractC13696c.a(5, i13, i10), this.f61672c, this.f61673d, m82422j(5, jM82431s));
                    throw new IOException("writeSingleFile err!");
                }
                m82415c(new AbstractC13696c.a(3, i13, i10), this.f61672c, this.f61673d, m82422j(3, jM82431s));
            }
            i12++;
        }
    }

    /* renamed from: i */
    public final int m82421i(ContentValues[] contentValuesArr) {
        if (contentValuesArr == null || contentValuesArr.length <= 0) {
            return -1;
        }
        return contentValuesArr[0].getAsInteger("apk_version").intValue();
    }

    /* renamed from: j */
    public final Bundle m82422j(int i10, long j10) {
        Bundle bundle = new Bundle();
        if (i10 == 5) {
            this.f61684p = this.f61679k;
        } else {
            this.f61684p += j10;
        }
        bundle.putLong("current_restore", this.f61684p);
        bundle.putLong("totalsize", this.f61679k);
        return bundle;
    }

    /* renamed from: k */
    public final Bundle m82423k(ContentValues[] contentValuesArr, int i10, int i11) {
        HashSet hashSet = new HashSet();
        int i12 = i10;
        while (true) {
            if (i12 > i11) {
                i12 = i10;
                break;
            }
            if (hashSet.size() >= 500) {
                break;
            }
            if (i12 == i11) {
                i12 = i11;
                break;
            }
            try {
                Integer asInteger = contentValuesArr[i12].getAsInteger("file_index");
                asInteger.intValue();
                hashSet.add(asInteger);
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupAppDataToDB", "index IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupAppDataToDB", "index Exception");
            }
            i12++;
        }
        if (hashSet.isEmpty()) {
            C2111d.m12653i("BackupAppDataToDB", "get file list index empty, file length:" + i11 + ";index.size():" + hashSet.size() + ";num:" + i10);
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
        C2111d.m12646b("BackupAppDataToDB", "where end:" + sb2.toString());
        Bundle bundle = new Bundle();
        bundle.putInt("fileindex_number", i12);
        bundle.putString("select_fileindex", sb2.toString());
        return bundle;
    }

    /* renamed from: l */
    public final String m82424l(ContentValues contentValues) {
        String asString = contentValues.getAsString("file_path");
        if (asString == null) {
            return asString;
        }
        if (asString.startsWith(BackupRestoreConstans.DATA_PATH)) {
            asString = asString.replace(BackupRestoreConstans.DATA_PATH, "/data/data/com.hicloud.android.clone/files/clone/");
        } else if (asString.startsWith(BackupRestoreConstans.DATA_OWNER_PATH)) {
            asString = asString.replace(BackupRestoreConstans.DATA_OWNER_PATH, "/data/data/com.hicloud.android.clone/files/clone/");
        } else {
            C2111d.m12646b("BackupAppDataToDB", "file path is not start with /data/data or /data/user/0 ");
        }
        return asString.replace((char) 127, ' ');
    }

    /* renamed from: m */
    public final boolean m82425m(ContentValues contentValues) {
        if (this.f61671b.m185A("apk_file_data", contentValues) == 2) {
            C2111d.m12648d("BackupAppDataToDB", "mStoreHandler.write( AppFileData.TABLE_NAME, cv) error!");
            return false;
        }
        if (this.f61675g < 2097152) {
            return true;
        }
        this.f61671b.mo171c();
        this.f61675g = 0;
        return true;
    }

    /* renamed from: n */
    public final int m82426n(byte[] bArr, FileInputStream fileInputStream) throws IOException {
        int i10 = fileInputStream.read(bArr);
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    /* renamed from: o */
    public final boolean m82427o() {
        ContentValues[] contentValuesArrM200s = this.f61671b.m200s("apk_file_info", null, "file_index = " + String.valueOf(-1), null, null);
        if (contentValuesArrM200s == null) {
            return true;
        }
        for (ContentValues contentValues : contentValuesArrM200s) {
            String asString = contentValues.getAsString("file_path");
            String strM80070i = C13345n.m80070i(this.f61670a);
            if (TextUtils.isEmpty(strM80070i)) {
                strM80070i = "/data/data/com.hicloud.android.clone/files/clone/";
            }
            File file = new File(asString.replace(BackupRestoreConstans.DATA_PATH, strM80070i).replace((char) 127, ' '));
            if (!file.exists() && !file.mkdirs()) {
                C2111d.m12648d("BackupAppDataToDB", "restoreApkDataDirs mkdirs fail");
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    public int m82428p() throws Throwable {
        AbstractC0048c abstractC0048c;
        if (this.f61670a == null || (abstractC0048c = this.f61671b) == null) {
            return 5;
        }
        int iM82421i = m82421i(abstractC0048c.m200s("apk_info", null, null, null, null));
        if (iM82421i == -1) {
            C2111d.m12648d("BackupAppDataToDB", "backupVersion == -1");
            return 5;
        }
        if (!C13694a.m82336n(this.f61670a, iM82421i, this.f61674e)) {
            m82414b(9, 0, 0, this.f61672c, this.f61673d);
            return 5;
        }
        this.f61679k = new File(this.f61671b.m197o()).length();
        if (!m82429q()) {
            C2111d.m12648d("BackupAppDataToDB", "restoreAttrFile fail");
            return 5;
        }
        if (m82427o()) {
            m82430r();
            return 4;
        }
        C2111d.m12648d("BackupAppDataToDB", "restoreApkDataDirs fail");
        return 5;
    }

    /* renamed from: q */
    public final boolean m82429q() {
        ContentValues[] contentValuesArrM199r = this.f61671b.m199r("apk_file_info");
        if (contentValuesArrM199r == null) {
            C2111d.m12648d("BackupAppDataToDB", "restoreAttrFile fail filelist is null");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (ContentValues contentValues : contentValuesArrM199r) {
            C13909a c13909a = new C13909a();
            c13909a.m83339k(contentValues);
            arrayList.add(c13909a);
        }
        C13702i c13702i = this.f61685q;
        if (c13702i == null || !c13702i.m82442f(arrayList)) {
            return false;
        }
        C2111d.m12653i("BackupAppDataToDB", "writeAttrFileInfo success");
        return true;
    }

    /* renamed from: r */
    public final void m82430r() throws Throwable {
        String str;
        String string;
        ContentValues[] contentValuesArrM200s = this.f61671b.m200s("apk_file_info", null, "file_index <> -1", null, null);
        if (contentValuesArrM200s == null || contentValuesArrM200s.length <= 0) {
            return;
        }
        int i10 = 0;
        Cursor cursor = null;
        try {
            try {
                this.f61680l = 0;
                int length = contentValuesArrM200s.length;
                do {
                    int i11 = i10;
                    if (length >= 500) {
                        Bundle bundleM82423k = m82423k(contentValuesArrM200s, i10, length);
                        if (bundleM82423k != null) {
                            i10 = bundleM82423k.getInt("fileindex_number");
                            string = bundleM82423k.getString("select_fileindex");
                        } else {
                            string = null;
                        }
                        str = string;
                    } else {
                        str = null;
                        i10 = length;
                    }
                    Cursor cursorMo194l = this.f61671b.mo194l("apk_file_data", null, str, null, null);
                    if (cursorMo194l != null) {
                        try {
                            if (cursorMo194l.moveToFirst()) {
                                m82420h(contentValuesArrM200s, cursorMo194l, length, i10, i11);
                                cursorMo194l.close();
                            }
                        } catch (SQLException unused) {
                            cursor = cursorMo194l;
                            C2111d.m12648d("BackupAppDataToDB", "restoreFiles SQLException");
                            if (cursor == null) {
                                return;
                            }
                            cursor.close();
                            return;
                        } catch (IOException unused2) {
                            cursor = cursorMo194l;
                            C2111d.m12648d("BackupAppDataToDB", "restoreFiles Exception");
                            if (cursor == null) {
                                return;
                            }
                            cursor.close();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorMo194l;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorMo194l != null) {
                        cursorMo194l.close();
                        return;
                    }
                    return;
                } while (i10 < length);
            } catch (SQLException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: s */
    public final long m82431s(Cursor cursor, String str, int i10) throws IOException {
        C2111d.m12646b("BackupAppDataToDB", "restoreSingleFile filePath = " + str);
        String strM80070i = C13345n.m80070i(this.f61670a);
        if (TextUtils.isEmpty(strM80070i)) {
            strM80070i = "/data/data/com.hicloud.android.clone/files/clone/";
        }
        String strReplace = str.replace(BackupRestoreConstans.DATA_PATH, strM80070i);
        C2111d.m12646b("BackupAppDataToDB", "restoreSingleFile filePaths = " + strReplace);
        File file = new File(strReplace);
        long j10 = -1;
        if (!file.exists() && !this.f61685q.m82437a(strReplace)) {
            C2111d.m12648d("BackupAppDataToDB", "file cannot exist");
            return -1L;
        }
        long j11 = 0;
        FileOutputStream fileOutputStream = null;
        do {
            try {
                try {
                    if (!C13699f.m82413a()) {
                        if (fileOutputStream == null) {
                            fileOutputStream = new FileOutputStream(file);
                        }
                        if (i10 != cursor.getInt(this.f61681m)) {
                            break;
                        }
                        int i11 = cursor.getInt(this.f61682n);
                        if (i11 > 0) {
                            j11 += i11;
                            fileOutputStream.write(cursor.getBlob(this.f61683o));
                        }
                    } else {
                        C2111d.m12653i("BackupAppDataToDB", "writeSingleFile ，user abort()");
                        return -1L;
                    }
                } catch (FileNotFoundException unused) {
                    C2111d.m12648d("BackupAppDataToDB", "restoreSingleFile fail");
                } catch (IOException unused2) {
                    C2111d.m12648d("BackupAppDataToDB", "restoreSingleFile Exception");
                }
            } finally {
                m82419g(fileOutputStream);
            }
        } while (cursor.moveToNext());
        j10 = j11;
        return j10;
    }

    /* renamed from: t */
    public final boolean m82432t() throws Throwable {
        AbstractC0048c abstractC0048c = this.f61671b;
        if (abstractC0048c == null) {
            C2111d.m12653i("BackupAppDataToDB", "mStoreHandler is null");
            return false;
        }
        abstractC0048c.mo169a();
        ArrayList<C13909a> arrayListM82441e = this.f61685q.m82441e();
        if (arrayListM82441e == null) {
            C2111d.m12648d("BackupAppDataToDB", "appDataFileAttrs is null");
        } else {
            ArrayList arrayList = new ArrayList();
            for (int size = arrayListM82441e.size() - 1; size >= 0; size--) {
                arrayList.add(arrayListM82441e.get(size));
            }
            this.f61678j = new ArrayList<>();
            int size2 = arrayList.size();
            for (int i10 = 0; i10 < size2; i10++) {
                C13909a c13909a = (C13909a) arrayList.get(i10);
                ContentValues contentValuesM83329a = c13909a.m83329a();
                if (c13909a.m83333e()) {
                    contentValuesM83329a.put("file_index", (Integer) (-1));
                } else {
                    int i11 = this.f61676h;
                    this.f61676h = i11 + 1;
                    contentValuesM83329a.put("file_index", Integer.valueOf(i11));
                }
                this.f61678j.add(contentValuesM83329a);
                this.f61677i++;
                if (this.f61671b.m185A("apk_file_info", contentValuesM83329a) != 1) {
                    C2111d.m12648d("BackupAppDataToDB", "write to db fail");
                    return false;
                }
            }
        }
        this.f61671b.mo171c();
        return true;
    }

    /* renamed from: u */
    public final boolean m82433u() {
        int i10;
        AbstractC0048c abstractC0048c = this.f61671b;
        if (abstractC0048c == null) {
            return false;
        }
        abstractC0048c.mo169a();
        this.f61675g = 0;
        ArrayList<ContentValues> arrayList = this.f61678j;
        if (arrayList == null || arrayList.isEmpty()) {
            C2111d.m12648d("BackupAppDataToDB", "writeFileContentToDB error not file need write");
            return false;
        }
        int size = this.f61678j.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            ContentValues contentValues = this.f61678j.get(i12);
            int iIntValue = contentValues.getAsInteger("file_index").intValue();
            if (iIntValue == -1) {
                i10 = i11 + 1;
                m82414b(0, i10, size, this.f61672c, this.f61673d);
            } else {
                i10 = i11 + 1;
                if (!m82434v(m82424l(contentValues), iIntValue)) {
                    this.f61671b.m190h();
                    m82414b(2, i10, size, this.f61672c, this.f61673d);
                    return false;
                }
                m82414b(0, i10, size, this.f61672c, this.f61673d);
            }
            i11 = i10;
            if (C13699f.m82413a()) {
                this.f61671b.m190h();
                break;
            }
            i12++;
        }
        if (this.f61675g == 0) {
            return true;
        }
        this.f61671b.mo171c();
        this.f61675g = 0;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        m82418f(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return true;
     */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m82434v(java.lang.String r11, int r12) throws java.lang.Throwable {
        /*
            r10 = this;
            x4.i r0 = r10.f61685q
            java.io.File r0 = r0.m82438b(r11)
            r1 = 8192(0x2000, float:1.148E-41)
            byte[] r2 = new byte[r1]
            java.lang.String r3 = "BackupAppDataToDB"
            r4 = 0
            if (r0 == 0) goto La3
            boolean r5 = r0.exists()
            if (r5 == 0) goto La3
            boolean r5 = r0.isFile()
            if (r5 == 0) goto La3
            r11 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L90 java.io.FileNotFoundException -> L99
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L90 java.io.FileNotFoundException -> L99
            r11 = r4
        L22:
            int r0 = r10.m82426n(r2, r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r6 = 1
            if (r0 != 0) goto L2c
            if (r11 == 0) goto L2c
            goto L85
        L2c:
            boolean r7 = p762x4.C13699f.m82413a()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            if (r7 == 0) goto L36
            r10.m82418f(r5)
            return r4
        L36:
            int r7 = r10.f61675g     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            if (r7 != 0) goto L47
            a5.c r7 = r10.f61671b     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.mo169a()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            goto L47
        L40:
            r11 = move-exception
            goto L9f
        L43:
            r11 = r5
            goto L90
        L45:
            r11 = r5
            goto L99
        L47:
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.clear()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r10.m82435w(r2, r0, r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            java.lang.String r8 = "data_index"
            int r9 = r11 + 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.put(r8, r11)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            java.lang.String r11 = "file_index"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.put(r11, r8)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            java.lang.String r11 = "file_length"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            r7.put(r11, r8)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            int r11 = r10.f61675g     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            if (r0 != 0) goto L75
            r8 = r6
            goto L76
        L75:
            r8 = r0
        L76:
            int r11 = r11 + r8
            r10.f61675g = r11     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            boolean r11 = r10.m82425m(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43 java.io.FileNotFoundException -> L45
            if (r11 != 0) goto L83
            r10.m82418f(r5)
            return r4
        L83:
            if (r0 >= r1) goto L8a
        L85:
            r10.m82418f(r5)
            r4 = r6
            goto Lb7
        L8a:
            r11 = r9
            goto L22
        L8c:
            r12 = move-exception
            r5 = r11
            r11 = r12
            goto L9f
        L90:
            java.lang.String r12 = "writeSingleFileContentToDB Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r12)     // Catch: java.lang.Throwable -> L8c
        L95:
            r10.m82418f(r11)
            goto Lb7
        L99:
            java.lang.String r12 = "writeSingleFileContentToDB fail:not file"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r12)     // Catch: java.lang.Throwable -> L8c
            goto L95
        L9f:
            r10.m82418f(r5)
            throw r11
        La3:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "writeSingleFileContentToDB error file not exist filePath : "
            r10.append(r12)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r10)
        Lb7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p762x4.C13700g.m82434v(java.lang.String, int):boolean");
    }

    /* renamed from: w */
    public final void m82435w(byte[] bArr, int i10, ContentValues contentValues) {
        if (i10 >= 8192) {
            contentValues.put("file_data", bArr);
            return;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        contentValues.put("file_data", bArr2);
    }
}
