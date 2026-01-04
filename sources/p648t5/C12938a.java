package p648t5;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p006a5.AbstractC0048c;
import p007a6.AbstractC0053b;
import p007a6.C0052a;
import p229di.C9142g;
import p386j6.C10713c;
import p648t5.C12939b;
import p699v4.C13334c;
import p699v4.C13345n;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: t5.a */
/* loaded from: classes.dex */
public class C12938a extends AbstractC0053b {

    /* renamed from: b */
    public static final String f58980b;

    /* renamed from: c */
    public static final String f58981c;

    /* renamed from: d */
    public static final String f58982d;

    /* renamed from: e */
    public static final String f58983e;

    /* renamed from: t5.a$a */
    public static class a extends AbstractC0053b.c {
        public a(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c, C0052a c0052a, AbstractC0053b.b bVar) {
            super(interfaceC2155n, context, abstractC0048c, c0052a, bVar.m315b(), bVar.m314a());
        }

        /* renamed from: p0 */
        private void m77700p0(Cursor cursor, ContentValues contentValues) {
            if (cursor == null || contentValues == null) {
                return;
            }
            int columnCount = cursor.getColumnCount();
            for (int i10 = 0; i10 < columnCount; i10++) {
                int type = cursor.getType(i10);
                String columnName = cursor.getColumnName(i10);
                if (type == 0) {
                    contentValues.putNull(columnName);
                } else if (type == 1) {
                    contentValues.put(columnName, Long.valueOf(cursor.getLong(i10)));
                } else if (type == 2) {
                    contentValues.put(columnName, Float.valueOf(cursor.getFloat(i10)));
                } else if (type == 3) {
                    contentValues.put(columnName, cursor.getString(i10));
                } else if (type == 4) {
                    contentValues.put(columnName, cursor.getBlob(i10));
                }
            }
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: I */
        public int mo324I() {
            return 500;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: a0 */
        public String mo343a0(String str) {
            if (str == null || this.f177t == null) {
                return null;
            }
            String lastPathSegment = C13347p.m80079b(str).getLastPathSegment();
            if (lastPathSegment != null) {
                lastPathSegment = lastPathSegment + "_tb";
            }
            if (lastPathSegment == null) {
                return lastPathSegment;
            }
            return this.f177t + lastPathSegment;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
        @Override // p007a6.AbstractC0053b.c
        /* renamed from: b0 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean mo345b0() {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.ArrayList<java.lang.String> r1 = r3.f163f
                if (r1 == 0) goto L15
                java.lang.String r2 = p648t5.C12939b.f58984c
                boolean r1 = r1.contains(r2)
                if (r1 == 0) goto L15
                r0.add(r2)
                goto L2d
            L15:
                java.lang.String r1 = p648t5.C12938a.m77678I()
                r0.add(r1)
                java.lang.String r1 = p648t5.C12938a.m77679J()
                r0.add(r1)
                java.lang.String r1 = "content://com.hihonor.provider.NotePad.backup/super_tasks"
                r0.add(r1)
                java.lang.String r1 = "content://com.hihonor.provider.NotePad.backup/super_notes"
                r0.add(r1)
            L2d:
                r3.f163f = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "preConfirmListNeedCount memo mUriListNeedCount."
                r0.append(r1)
                java.util.ArrayList<java.lang.String> r3 = r3.f163f
                java.lang.String r3 = r3.toString()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                java.lang.String r0 = "BackupMemo"
                com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r3)
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p648t5.C12938a.a.mo345b0():boolean");
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: c */
        public int mo346c(String str) {
            ArrayList<String> arrayList;
            if (this.f160c == null || this.f161d == null || str == null || (arrayList = this.f163f) == null) {
                m357h0(str, false, "backupOneTable isNull ");
                return 0;
            }
            boolean zContains = arrayList.contains(str);
            String strMo343a0 = mo343a0(str);
            if (strMo343a0 != null) {
                return m77704t0(str, zContains, strMo343a0);
            }
            m357h0(str, false, "backTableName isNull ");
            return 0;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: k */
        public boolean mo362k() {
            C12939b.b bVarM77709h;
            if (this.f160c != null && this.f161d != null && this.f175r != null) {
                try {
                    C12939b.a aVarM77705u0 = m77705u0();
                    C0052a c0052a = this.f175r;
                    if (!(c0052a instanceof C12939b) || (bVarM77709h = ((C12939b) c0052a).m77709h(this.f160c, aVarM77705u0)) == null) {
                        return true;
                    }
                    this.f172o = bVarM77709h.m77717e();
                    this.f162e = bVarM77709h.m77716d();
                    this.f180w = bVarM77709h.m77715c();
                    if (this.f162e == null) {
                        return true;
                    }
                    C2111d.m12653i("BackupMemo", "restoreStart memo mUriList = " + this.f162e.toString());
                    return true;
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupMemo", "doBeforeRestore error IllegalArgumentException.");
                    this.f172o = false;
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupMemo", "doBeforeRestore error.");
                    this.f172o = false;
                    return false;
                }
            }
            return false;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: o */
        public int mo370o() {
            if (C13348q.m80082b(this.f162e) || C13348q.m80082b(this.f163f)) {
                return -1;
            }
            m332Q();
            Iterator<String> it = this.f162e.iterator();
            Cursor cursorM12618d = null;
            int i10 = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (this.f163f.contains(next)) {
                    try {
                        try {
                            try {
                                cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(next), null, null, null, null);
                                if (cursorM12618d != null) {
                                    int count = cursorM12618d.getCount();
                                    m344b(next, C2126b.MODULE_INFO_PREPARE_COUNT, String.valueOf(count));
                                    i10 += count;
                                }
                            } catch (IllegalArgumentException e10) {
                                String str = "Get backup numbers failed IllegalArgumentException. error: " + e10.getMessage();
                                C2111d.m12648d("BackupMemo", str);
                                m344b(next, C2126b.MODULE_INFO_ERROR_INFO, str);
                                if (cursorM12618d != null) {
                                }
                            }
                        } catch (Exception e11) {
                            String str2 = "Get backup numbers failed. error: " + e11.getMessage();
                            C2111d.m12648d("BackupMemo", "Get backup numbers failed");
                            m344b(next, C2126b.MODULE_INFO_ERROR_INFO, str2);
                            if (cursorM12618d != null) {
                            }
                        }
                        if (cursorM12618d != null) {
                            cursorM12618d.close();
                        }
                    } catch (Throwable th2) {
                        if (cursorM12618d != null) {
                            cursorM12618d.close();
                        }
                        throw th2;
                    }
                }
            }
            return i10;
        }

        /* renamed from: q0 */
        public final void m77701q0(boolean z10) {
            if (z10) {
                m333R();
            }
        }

        /* renamed from: r0 */
        public final int m77702r0(boolean z10, int i10, ThreadLocal<String> threadLocal, AtomicLong atomicLong) {
            if (i10 == 1) {
                atomicLong.set(atomicLong.get() + 1);
                if (z10) {
                    m336U();
                    return 1;
                }
            } else {
                threadLocal.set("WRITE_FAIL");
                m77701q0(z10);
            }
            return 0;
        }

        /* renamed from: s0 */
        public final int m77703s0(boolean z10, String str, int i10, Cursor cursor, ContentValues contentValues, ThreadLocal<String> threadLocal, AtomicLong atomicLong) {
            try {
                contentValues.clear();
                m77700p0(cursor, contentValues);
                return m77702r0(z10, this.f161d.m185A(str, contentValues), threadLocal, atomicLong);
            } catch (IllegalArgumentException e10) {
                threadLocal.set(e10.getMessage());
                C2111d.m12648d("BackupMemo", "memo write events values IllegalArgumentException.");
                m77701q0(z10);
                return i10;
            } catch (Exception e11) {
                threadLocal.set(e11.getMessage());
                C2111d.m12648d("BackupMemo", "memo write events values failed.");
                m77701q0(z10);
                return i10;
            }
        }

        /* renamed from: t0 */
        public final int m77704t0(String str, boolean z10, String str2) throws Throwable {
            int iM77703s0;
            Cursor cursorM12618d;
            this.f161d.mo169a();
            Cursor cursor = null;
            try {
                try {
                    cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(str), null, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e10) {
                e = e10;
                iM77703s0 = 0;
            }
            if (cursorM12618d != null) {
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursorM12618d;
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.f161d.mo171c();
                        throw th;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    iM77703s0 = 0;
                }
                if (cursorM12618d.moveToFirst()) {
                    ThreadLocal<String> threadLocal = new ThreadLocal<>();
                    AtomicLong atomicLong = new AtomicLong(0L);
                    ContentValues contentValues = new ContentValues();
                    iM77703s0 = 0;
                    while (!BackupObject.isAbort()) {
                        try {
                            iM77703s0 = m77703s0(z10, str2, iM77703s0, cursorM12618d, contentValues, threadLocal, atomicLong);
                            if (!cursorM12618d.moveToNext()) {
                                break;
                            }
                        } catch (SQLiteException e12) {
                            e = e12;
                            cursor = cursorM12618d;
                            C2111d.m12648d("BackupMemo", "memo write events values SQLiteException.");
                            String str3 = "memo write events values SQLiteException isNeedCountUri: " + z10 + ". error: " + e.getMessage();
                            m357h0(str, false, str3);
                            m344b(str, C2126b.MODULE_INFO_ERROR_INFO, str3);
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.f161d.mo171c();
                            return iM77703s0;
                        }
                    }
                    m77707w0(str, z10, threadLocal, atomicLong);
                    m344b(str, "count", String.valueOf(atomicLong.get()));
                    cursorM12618d.close();
                    this.f161d.mo171c();
                    return iM77703s0;
                }
            }
            m357h0(str, false, "cursor isNull isNeedCountUri: " + z10);
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
            this.f161d.mo171c();
            return 0;
        }

        /* renamed from: u0 */
        public final C12939b.a m77705u0() throws Exception {
            int iIntValue = m355g0(this.f161d).getAsInteger("version").intValue();
            m351e0();
            if (this.f162e != null) {
                C2111d.m12653i("BackupMemo", "readRestoreDataInfoFromBackupFile memo mUriList." + this.f162e.toString());
            }
            ArrayList arrayList = new ArrayList();
            if (C13348q.m80084d(this.f162e)) {
                Iterator<String> it = this.f162e.iterator();
                while (it.hasNext()) {
                    C12939b.c cVarM77706v0 = m77706v0(it.next());
                    if (cVarM77706v0 != null) {
                        arrayList.add(cVarM77706v0);
                    }
                }
            }
            return new C12939b.a(iIntValue, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0047  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* renamed from: v0 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final p648t5.C12939b.c m77706v0(java.lang.String r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.String r0 = "BackupMemo"
                r1 = 0
                if (r9 != 0) goto L6
                return r1
            L6:
                java.lang.String r3 = r8.mo343a0(r9)
                a5.c r2 = r8.f161d     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d android.database.SQLException -> L2f
                r6 = 0
                r7 = 0
                r4 = 0
                r5 = 0
                android.database.Cursor r8 = r2.mo194l(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d android.database.SQLException -> L2f
                if (r8 == 0) goto L1e
                int r2 = r8.getCount()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L31 android.database.SQLException -> L3c
                goto L1f
            L1b:
                r9 = move-exception
                r1 = r8
                goto L45
            L1e:
                r2 = 0
            L1f:
                t5.b$c r3 = new t5.b$c     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L31 android.database.SQLException -> L3c
                r3.<init>(r9, r2)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L31 android.database.SQLException -> L3c
                if (r8 == 0) goto L29
                r8.close()
            L29:
                r1 = r3
                goto L44
            L2b:
                r9 = move-exception
                goto L45
            L2d:
                r8 = r1
                goto L31
            L2f:
                r8 = r1
                goto L3c
            L31:
                java.lang.String r9 = "readSingleDataInfoFromBackupFile with Exception!"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L1b
                if (r8 == 0) goto L44
            L38:
                r8.close()
                goto L44
            L3c:
                java.lang.String r9 = "readSingleDataInfoFromBackupFile with SQLException"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L1b
                if (r8 == 0) goto L44
                goto L38
            L44:
                return r1
            L45:
                if (r1 == 0) goto L4a
                r1.close()
            L4a:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: p648t5.C12938a.a.m77706v0(java.lang.String):t5.b$c");
        }

        /* renamed from: w0 */
        public final void m77707w0(String str, boolean z10, ThreadLocal<String> threadLocal, AtomicLong atomicLong) {
            String str2;
            if (atomicLong.get() > 0) {
                return;
            }
            if (threadLocal.get() != null) {
                str2 = ",errorInfo" + threadLocal.get();
            } else {
                str2 = "";
            }
            m357h0(str, false, "success is 0 isNeedCountUri " + z10 + str2);
        }
    }

    static {
        f58980b = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/task_items" : "content://com.huawei.provider.NotePad.backup/task_items";
        f58981c = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_items" : "content://com.huawei.provider.NotePad.backup/note_items";
        f58982d = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup/note_items_new" : "content://com.huawei.provider.NotePad.backup/note_items_new";
        f58983e = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup" : "content://com.huawei.provider.NotePad.backup";
    }

    /* renamed from: Q */
    private void m77680Q(List<AbstractC0053b.c> list) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null) {
                cVar.m354g();
            }
        }
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(f58983e);
        return arrayList;
    }

    /* renamed from: K */
    public final void m77681K(Context context, List<String> list) {
        if (list == null) {
            C2111d.m12648d("BackupMemo", "addBackupFileList tarFilePathList is null ");
            return;
        }
        for (String str : list) {
            C2111d.m12653i("BackupMemo", "addBackupFileList by pms tar start.");
            String strSubstring = "com.example.android.notepad" + str;
            if (strSubstring.endsWith(File.separator)) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            this.backupFliedList.addAll(C13334c.m79985r(C13345n.m80070i(context) + strSubstring));
            C2111d.m12654j("BackupMemo", "addBackupFileList by pms tar end. module name = ", strSubstring);
        }
    }

    /* renamed from: L */
    public boolean m77682L(Context context, AbstractC0048c abstractC0048c) throws IOException {
        int i10;
        C2111d.m12653i("BackupMemo", "Backup memo attachment.");
        boolean z10 = false;
        if (abstractC0048c == null) {
            return false;
        }
        InputStream inputStreamM77723a = C12940c.m77723a(context);
        if (inputStreamM77723a == null) {
            return true;
        }
        byte[] bArr = new byte[RuleConfig.DEFAULT_DB_DIFF_MAX_FILE_SIZE];
        ContentValues contentValues = new ContentValues();
        try {
            try {
                abstractC0048c.mo169a();
                int i11 = 0;
                do {
                    i10 = inputStreamM77723a.read(bArr);
                    if (i10 > 0) {
                        byte[] bArr2 = new byte[i10];
                        System.arraycopy(bArr, 0, bArr2, 0, i10);
                        contentValues.put("file_length", Integer.valueOf(i10));
                        int i12 = i11 + 1;
                        contentValues.put("data_index", Integer.valueOf(i11));
                        contentValues.put("file_data", bArr2);
                        abstractC0048c.m185A("attachment", contentValues);
                        contentValues.clear();
                        i11 = i12;
                    }
                } while (i10 > 0);
                abstractC0048c.mo171c();
                try {
                    inputStreamM77723a.close();
                } catch (IOException unused) {
                    C2111d.m12648d("BackupMemo", "close error.");
                }
                z10 = true;
            } catch (IOException unused2) {
                C2111d.m12648d("BackupMemo", "backupAttachment IOException.");
                abstractC0048c.mo171c();
                try {
                    inputStreamM77723a.close();
                } catch (IOException unused3) {
                    C2111d.m12648d("BackupMemo", "close error.");
                }
            }
            C2111d.m12653i("BackupMemo", "Backup memo attachment end");
            return z10;
        } catch (Throwable th2) {
            abstractC0048c.mo171c();
            try {
                inputStreamM77723a.close();
            } catch (IOException unused4) {
                C2111d.m12648d("BackupMemo", "close error.");
            }
            throw th2;
        }
    }

    /* renamed from: M */
    public final boolean m77683M(Context context, AbstractC0048c abstractC0048c, List<String> list, String str) {
        C2111d.m12653i("BackupMemo", "Backup memo attachment start.");
        if (list != null && m77695Z() && m77686P(context, str)) {
            if (!m77684N(context, list)) {
                C2111d.m12648d("BackupMemo", "attachment backup by pms fail!");
                return false;
            }
        } else if (!m77682L(context, abstractC0048c)) {
            C2111d.m12648d("BackupMemo", "attachment backup by db fail!");
            return false;
        }
        C2111d.m12653i("BackupMemo", "Backup memo attachment end.");
        return true;
    }

    /* renamed from: N */
    public final boolean m77684N(Context context, List<String> list) {
        C2111d.m12653i("BackupMemo", "attachment backup by pms tar");
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (pMSbackupRestoreUtil.m12729t(m77687R(context, it.next()), 2, null, null) == -1) {
                C2111d.m12648d("BackupMemo", "PMS copy memo file fail");
                return false;
            }
        }
        return true;
    }

    /* renamed from: O */
    public final boolean m77685O() {
        if (!C10713c.m65392b(BackupObject.getExecuteParameter(), "isPmsBackupMemoData", false)) {
            C2111d.m12653i("BackupMemo", "not pms tar data");
            return true;
        }
        if (PmsCheckUtil.m12614h() && C2153l.m13045g0()) {
            C2111d.m12653i("BackupMemo", "support pms tar");
            return true;
        }
        C2111d.m12653i("BackupMemo", "not support pms tar");
        return false;
    }

    /* renamed from: P */
    public final boolean m77686P(Context context, String str) throws IOException {
        try {
            File file = new File(context.getDir("medaicache", 0), str);
            if (file.exists()) {
                return true;
            }
            boolean zCreateNewFile = file.createNewFile();
            C2111d.m12653i("BackupMemo", "create pms txt file result = " + zCreateNewFile);
            return zCreateNewFile;
        } catch (Exception e10) {
            C2111d.m12648d("BackupMemo", "create pms txt file error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: R */
    public final String m77687R(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        String str2 = NextRestoreConstants.PKG_NAME_MEMO;
        if (C2157a.m13181P(packageManager, NextRestoreConstants.PKG_NAME_MEMO)) {
            C2111d.m12653i("BackupMemo", "backup memo package name is new: com.huawei.notepad");
        } else {
            str2 = "com.hihonor.notepad";
            if (C2157a.m13181P(packageManager, "com.hihonor.notepad")) {
                C2111d.m12653i("BackupMemo", "backup memo package name is new: com.hihonor.notepad");
            } else {
                str2 = "com.example.android.notepad";
            }
        }
        String str3 = str2 + str;
        return str.endsWith(File.separator) ? str3.substring(0, str3.length() - 1) : str3;
    }

    /* renamed from: S */
    public final List<AbstractC0053b.c> m77688S(List<AbstractC0053b.c> list, Handler.Callback callback, Object obj) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && cVar.mo362k()) {
                if (!cVar.m326K()) {
                    C2111d.m12653i("BackupMemo", "Memo permit is false");
                    sendMsg(7, 0, 0, callback, obj);
                    return null;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* renamed from: T */
    public final void m77689T(List<AbstractC0053b.c> list, StringBuilder sb2) {
        String strM372p;
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && (strM372p = cVar.m372p()) != null) {
                sb2.append(strM372p);
                sb2.append(";");
            }
        }
    }

    /* renamed from: U */
    public final void m77690U(Cursor cursor, OutputStream outputStream) throws IOException {
        while (!BackupObject.isAbort()) {
            outputStream.write(cursor.getBlob(cursor.getColumnIndexOrThrow("file_data")), 0, cursor.getInt(cursor.getColumnIndexOrThrow("file_length")));
            if (!cursor.moveToNext()) {
                return;
            }
        }
        throw new SQLiteException("Abort!");
    }

    /* renamed from: V */
    public final int m77691V(Context context, String str, List<String> list) {
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        int i10 = 0;
        for (String str2 : list) {
            String strM79987t = C13334c.m79987t(str2);
            if (str2.endsWith(".tar") && strM79987t != null && pMSbackupRestoreUtil.m12731v(str2, 2, str, strM79987t) == -1) {
                i10 = -1;
            }
        }
        return i10;
    }

    /* renamed from: W */
    public final void m77692W(Context context, List<AbstractC0053b.c> list) {
        String packageName = context.getPackageName();
        String str = C9142g.m57463b() ? "com.huawei.retaildemo" : "com.hihonor.retaildemo";
        if ("com.huawei.hidisk".equals(packageName) || str.equals(packageName)) {
            for (AbstractC0053b.c cVar : list) {
                if (cVar != null) {
                    this.subKeyTotalNum += cVar.m325J();
                }
            }
        } else {
            if (BackupObject.getExecuteParameter().containsKey("memoTotalNumber")) {
                this.subKeyTotalNum = C10713c.m65394d(BackupObject.getExecuteParameter(), "memoTotalNumber");
            }
        }
    }

    /* renamed from: X */
    public final ArrayList<String> m77693X(List<AbstractC0053b.c> list) {
        ArrayList<String> arrayListM328M = null;
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && cVar.m328M() != null) {
                arrayListM328M = cVar.m328M();
            }
        }
        return arrayListM328M;
    }

    /* renamed from: Y */
    public final String m77694Y(List<AbstractC0053b.c> list) {
        String strM329N = null;
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && cVar.m329N() != null) {
                strM329N = cVar.m329N();
            }
        }
        return strM329N;
    }

    /* renamed from: Z */
    public final boolean m77695Z() {
        if (!PmsCheckUtil.m12614h() || !isOtherPhoneSupportTar()) {
            C2111d.m12653i("BackupMemo", "isPmsSupportTarByPath, unsupported pms tar.");
            return false;
        }
        boolean zM65392b = C10713c.m65392b(BackupObject.getExecuteParameter(), "isNewPhonePmsSupportDecompressTarByPath", false);
        C2111d.m12654j("BackupMemo", "isPmsSupportTarByPath = ", Boolean.valueOf(zM65392b));
        return zM65392b;
    }

    /* renamed from: a0 */
    public final void m77696a0(Context context, boolean z10, OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                C2111d.m12648d("BackupMemo", "close error.");
            }
            if (!z10 || BackupObject.isAbort()) {
                return;
            }
            C2111d.m12653i("BackupMemo", "MemoProtocol updateAttachment");
            C12940c.m77725c(context);
        }
    }

    /* renamed from: b0 */
    public final void m77697b0(List<AbstractC0053b.c> list, AbstractC0048c abstractC0048c) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null) {
                int iMo203v = abstractC0048c.mo203v("comhuaweiproviderNotePadbackupnote_items_new_tb");
                C2111d.m12654j("BackupMemo", "subkeyTotalNum = ", Integer.valueOf(this.subKeyTotalNum), ", noteItemsNewCount = ", Integer.valueOf(iMo203v));
                if (this.subKeyTotalNum > iMo203v) {
                    cVar.m342a();
                }
                cVar.m368n();
            }
        }
        for (AbstractC0053b.c cVar2 : list) {
            if (cVar2 != null) {
                cVar2.m356h();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [t5.a] */
    /* JADX WARN: Type inference failed for: r13v0, types: [a5.c] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* renamed from: c0 */
    public boolean m77698c0(Context context, AbstractC0048c abstractC0048c) throws Throwable {
        OutputStream outputStream;
        OutputStream outputStream2;
        C2111d.m12653i("BackupMemo", "restoreAttachment memo begin");
        if (abstractC0048c == 0) {
            return false;
        }
        Cursor cursor = null;
        outputStreamM77724b = null;
        OutputStream outputStreamM77724b = null;
        cursor = null;
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        try {
            try {
                Cursor cursorMo194l = abstractC0048c.mo194l("attachment", null, null, null, "data_index");
                if (cursorMo194l != null) {
                    try {
                        if (cursorMo194l.moveToFirst()) {
                            outputStreamM77724b = C12940c.m77724b(context);
                            if (outputStreamM77724b == null) {
                                cursorMo194l.close();
                                m77696a0(context, true, outputStreamM77724b);
                                return false;
                            }
                            m77690U(cursorMo194l, outputStreamM77724b);
                        }
                    } catch (SQLiteException unused) {
                        cursor2 = cursorMo194l;
                        outputStream2 = null;
                        C2111d.m12648d("BackupMemo", "sqlite exception");
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        m77696a0(context, true, outputStream2);
                        return true;
                    } catch (Exception unused2) {
                        cursor3 = cursorMo194l;
                        outputStream = null;
                        C2111d.m12648d("BackupMemo", TrackConstants$Events.EXCEPTION);
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        m77696a0(context, false, outputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorMo194l;
                        abstractC0048c = 0;
                        if (cursor != null) {
                            cursor.close();
                        }
                        m77696a0(context, true, abstractC0048c);
                        throw th;
                    }
                }
                if (cursorMo194l != null) {
                    cursorMo194l.close();
                }
                m77696a0(context, true, outputStreamM77724b);
            } catch (SQLiteException unused3) {
                outputStream2 = null;
            } catch (Exception unused4) {
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                abstractC0048c = 0;
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: d0 */
    public final boolean m77699d0(Context context, AbstractC0048c abstractC0048c, String str) {
        if (str != null && m77695Z()) {
            ArrayList<String> arrayListM79985r = C13334c.m79985r(abstractC0048c.m198p() + File.separator + "com.example.android.notepad");
            if (arrayListM79985r.isEmpty()) {
                return false;
            }
            C2111d.m12653i("BackupMemo", "attachment tar restore start");
            if (m77691V(context, str, arrayListM79985r) == -1) {
                C2111d.m12648d("BackupMemo", "attachment restore fail!");
                return true;
            }
        }
        return false;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (context == null) {
            return false;
        }
        Uri uriM80079b = C13347p.m80079b(f58983e);
        if (!C2157a.m13184S(context, uriM80079b)) {
            return false;
        }
        C0052a.a aVarMo221b = new C12939b(uriM80079b).mo221b(context, null);
        Object[] objArr = new Object[2];
        objArr[0] = "isMemoBackupEnable isEnable = ";
        objArr[1] = Boolean.valueOf(aVarMo221b != null);
        C2111d.m12654j("BackupMemo", objArr);
        return aVarMo221b != null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle notifyModuleStart(Context context, String str, String str2) {
        Bundle bundleM65393c;
        C2111d.m12654j("BackupMemo", "notifyModuleStart start, moduleName = ", str, ", backupOrRestore = ", str2);
        String str3 = f58983e;
        if (!C2157a.m13184S(context, C13347p.m80079b(str3))) {
            return null;
        }
        boolean zM13194b = C2157a.m13194b(context, str3);
        C2111d.m12654j("BackupMemo", "query provider module ", str, " result is : ", Boolean.valueOf(zM13194b));
        if (!zM13194b) {
            C2111d.m12653i("BackupMemo", "Uri is not exist.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("session", "com.hicloud.android.clone");
        Bundle bundleM65393c2 = C10713c.m65393c(BackupObject.getExecuteParameter(), "AllModulesAbility");
        if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str2) && bundleM65393c2 != null && (bundleM65393c = C10713c.m65393c(bundleM65393c2, str)) != null) {
            bundle.putBundle("new_phone_ability_info", bundleM65393c);
        }
        if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str2)) {
            boolean zM65392b = C10713c.m65392b(BackupObject.getExecuteParameter(), "isMemoUsePmsTar", false);
            bundle.putBoolean("is_support_tar", zM65392b);
            C2111d.m12654j("BackupMemo", "isBothSupportMemoPms = ", Boolean.valueOf(zM65392b));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundleM12616b = C2108a.m12616b(context, str3, "backup_start", str2, reassembleExtra(bundle));
        C2111d.m12654j("BackupMemo", "get module info cost time: [", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "] ms, notifyModuleStart end.");
        return bundleM12616b;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupMemo", "Backup memo.");
        if (abstractC0048c == null || !C2157a.m13184S(context, C13347p.m80079b(f58983e))) {
            return 2;
        }
        notifyModuleStart(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, null);
        if (listMo301w.isEmpty() || !m302x(listMo301w)) {
            return 2;
        }
        int iM298E = m298E(listMo301w);
        this.subKeyTotalNum = iM298E;
        if (iM298E == 0) {
            return 2;
        }
        int iM294A = m294A(listMo301w);
        if (iM294A == 0) {
            C2111d.m12648d("BackupMemo", "No record backup sucess!");
            return 2;
        }
        ArrayList<String> arrayListM77693X = m77693X(listMo301w);
        if (!m77683M(context, abstractC0048c, arrayListM77693X, str)) {
            C2111d.m12648d("BackupMemo", "attachment backup fail!");
            return 2;
        }
        m77680Q(listMo301w);
        if (m77695Z()) {
            m77681K(context, arrayListM77693X);
        }
        StringBuilder sb2 = new StringBuilder();
        m77689T(listMo301w, sb2);
        this.backupFileModuleInfo.updateModuleInfo(iM294A, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord()) {
            return 1;
        }
        abstractC0048c.m190h();
        return 1;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iMo303y = mo303y(context, str);
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("BackupMemo", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(iMo303y), ", packageSize = ", l10, ", isSupportClone : ", Boolean.valueOf(zMo299G));
        if (iMo303y < 0) {
            return null;
        }
        long jLongValue = iMo303y == 0 ? 0L : l10.longValue();
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iMo303y);
        bundle.putLong("ModuleSize", jLongValue);
        bundle.putBoolean("isSupportClone", zMo299G);
        return bundle;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupMemo", "Restore memo.");
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, null);
        if (listMo301w.isEmpty()) {
            return 5;
        }
        List<AbstractC0053b.c> listM77688S = m77688S(listMo301w, callback, obj);
        if (listM77688S == null) {
            return 7;
        }
        m77692W(context, listM77688S);
        if (this.subKeyTotalNum == 0) {
            C2111d.m12648d("BackupMemo", "There is no value in back table!");
            return 5;
        }
        if (!m77685O()) {
            C2111d.m12648d("BackupMemo", "not support pms tar data!");
            sendMsg(7, 0, 0, callback, obj);
            return 5;
        }
        if (m77699d0(context, abstractC0048c, m77694Y(listM77688S))) {
            return 5;
        }
        if (!m77698c0(context, abstractC0048c)) {
            C2111d.m12648d("BackupMemo", "attachment restore fail!");
            return 5;
        }
        m77697b0(listM77688S, abstractC0048c);
        reportModuleRestoreFinish(str);
        return 4;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: w */
    public List<AbstractC0053b.c> mo301w(Context context, AbstractC0048c abstractC0048c, InterfaceC2155n interfaceC2155n, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!C2157a.m13184S(context, C13347p.m80079b(f58983e))) {
            return arrayList;
        }
        Iterator<String> it = mo296C(context, str, str2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                Uri uriM80079b = C13347p.m80079b(next);
                arrayList.add(new a(interfaceC2155n, context, abstractC0048c, new C12939b(uriM80079b), new AbstractC0053b.b(str, m297D(uriM80079b))));
            }
        }
        return arrayList;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: y */
    public int mo303y(Context context, String str) {
        List<AbstractC0053b.c> listMo301w = mo301w(context, null, null, str, null);
        if (listMo301w.isEmpty()) {
            return -1;
        }
        int i10 = 0;
        int i11 = 0;
        for (AbstractC0053b.c cVar : listMo301w) {
            if (cVar != null) {
                int iM320E = cVar.m320E();
                if (iM320E < 0) {
                    i10++;
                } else {
                    i11 += iM320E;
                }
            }
        }
        if (i10 == listMo301w.size()) {
            return -1;
        }
        return i11;
    }
}
