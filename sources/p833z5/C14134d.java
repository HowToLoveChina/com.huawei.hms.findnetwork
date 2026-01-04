package p833z5;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.network.p129ai.C5799g0;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;
import p279f6.C9662e;
import p386j6.C10713c;
import p699v4.C13333b;
import p699v4.C13339h;
import p699v4.C13342k;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: z5.d */
/* loaded from: classes.dex */
public class C14134d extends AbstractC14140j {

    /* renamed from: l */
    public static final Uri f63190l = C13347p.m80079b("content://mms-sms/threadID");

    /* renamed from: m */
    public static final String[] f63191m = {"_id"};

    /* renamed from: n */
    public static final String[] f63192n = {"_id", "recipient_ids"};

    /* renamed from: o */
    public static final String[] f63193o = {"_id", C5799g0.f25867g};

    /* renamed from: p */
    public static final Uri f63194p;

    /* renamed from: q */
    public static final Uri f63195q;

    /* renamed from: b */
    public String[] f63196b;

    /* renamed from: c */
    public HashMap<Long, String> f63197c;

    /* renamed from: d */
    public HashMap<Long, String> f63198d;

    /* renamed from: e */
    public HashMap<Long, String> f63199e;

    /* renamed from: f */
    public HashMap<Long, String> f63200f;

    /* renamed from: g */
    public HashMap<Long, Long> f63201g;

    /* renamed from: h */
    public ArrayList<BackupObject.SubKeyInfo> f63202h;

    /* renamed from: i */
    public Context f63203i;

    /* renamed from: j */
    public AbstractC0048c f63204j;

    /* renamed from: k */
    public Set<Long> f63205k;

    /* renamed from: z5.d$a */
    public class a extends BackupObject.SubKeyInfo {

        /* renamed from: c */
        public String[] f63206c;

        /* renamed from: d */
        public int f63207d;

        public a(Uri uri, String str, String str2, String[] strArr, HashMap<String, Integer> map, String str3) {
            super(uri, str, map, str3);
            this.f63206c = null;
            this.f63207d = 0;
            setSelection(str2);
            setSelectionArgs(strArr);
            Set<String> setKeySet = C14135e.m84897a().keySet();
            this.f63206c = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0057 A[PHI: r1
  0x0057: PHI (r1v4 android.database.Cursor) = (r1v18 android.database.Cursor), (r1v19 android.database.Cursor) binds: [B:26:0x0055, B:29:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int doEachBackup(android.content.Context r16, p006a5.AbstractC0048c r17, android.os.Handler.Callback r18, java.lang.Object r19) throws java.lang.Throwable {
            /*
                r15 = this;
                r0 = r15
                java.lang.String r7 = "MmsSmsImp"
                r8 = 0
                if (r17 == 0) goto L6d
                if (r16 != 0) goto La
                goto L6d
            La:
                r17.mo169a()
                r1 = 0
                android.content.ContentResolver r9 = r16.getContentResolver()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                android.net.Uri r10 = r0.uri     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                java.lang.String[] r11 = r0.projections     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                java.lang.String r12 = r0.selection     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                java.lang.String[] r13 = r0.selectionArgs     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                java.lang.String r14 = r0.sortOrder     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.IllegalArgumentException -> L5b
                if (r9 == 0) goto L45
                boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41 java.lang.IllegalArgumentException -> L43
                if (r1 != 0) goto L29
                goto L45
            L29:
                r1 = r15
                r2 = r16
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r9
                int r8 = r1.m84877n(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41 java.lang.IllegalArgumentException -> L43
                r9.close()
            L3a:
                r17.mo171c()
                goto L63
            L3e:
                r0 = move-exception
                r1 = r9
                goto L64
            L41:
                r1 = r9
                goto L50
            L43:
                r1 = r9
                goto L5b
            L45:
                if (r9 == 0) goto L4a
                r9.close()
            L4a:
                r17.mo171c()
                return r8
            L4e:
                r0 = move-exception
                goto L64
            L50:
                java.lang.String r0 = "doEachBackup error "
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r7, r0)     // Catch: java.lang.Throwable -> L4e
                if (r1 == 0) goto L3a
            L57:
                r1.close()
                goto L3a
            L5b:
                java.lang.String r0 = "doEachBackup IllegalArgumentException"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r7, r0)     // Catch: java.lang.Throwable -> L4e
                if (r1 == 0) goto L3a
                goto L57
            L63:
                return r8
            L64:
                if (r1 == 0) goto L69
                r1.close()
            L69:
                r17.mo171c()
                throw r0
            L6d:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.a.doEachBackup(android.content.Context, a5.c, android.os.Handler$Callback, java.lang.Object):int");
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void doEachRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
            if (context == null || abstractC0048c == null) {
                return;
            }
            abstractC0048c.mo169a();
            Cursor cursorMo194l = null;
            try {
                try {
                    cursorMo194l = abstractC0048c.mo194l(this.backTable, AbstractC14131a.m84804b(context) ? C14134d.this.m84865v(this.projections) : this.projections, this.selection, this.selectionArgs, null);
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("MmsSmsImp", "doEachRestore IllegalArgumentException");
                    if (0 != 0) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "doEachRestore error. ");
                    if (0 != 0) {
                    }
                }
                if (cursorMo194l != null && cursorMo194l.moveToFirst()) {
                    m84878o(context, abstractC0048c, callback, obj, cursorMo194l);
                    cursorMo194l.close();
                    abstractC0048c.mo171c();
                    return;
                }
                C2111d.m12648d("MmsSmsImp", "uri is restore error. because values is null.");
                if (cursorMo194l != null) {
                    cursorMo194l.close();
                }
                abstractC0048c.mo171c();
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursorMo194l.close();
                }
                abstractC0048c.mo171c();
                throw th2;
            }
        }

        /* renamed from: f */
        public final boolean m84869f(long j10, Context context, AbstractC0048c abstractC0048c) {
            C9662e c9662e = new C9662e(C13347p.m80080c(C14138h.f63216a, j10 + "/addr"), this.f63206c, null, null, null);
            c9662e.m60337g(C14135e.m84897a());
            ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
            return backupValues.length <= 0 || abstractC0048c.mo186B("addr_tb", backupValues, null, null) == 1;
        }

        /* renamed from: g */
        public final boolean m84870g(Context context, AbstractC0048c abstractC0048c, long j10, long j11) throws IOException {
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("files_mms_tb", new String[]{"_id", "file_data"}, "_id = " + j10, null, null);
            if (contentValuesArrM200s == null) {
                C2111d.m12648d("MmsSmsImp", "FileTable is restore error. because FileValues is null.");
                return false;
            }
            try {
                try {
                    OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(C13347p.m80080c(C14137g.f63214a, String.valueOf(j11)));
                    if (outputStreamOpenOutputStream == null) {
                        C2111d.m12648d("MmsSmsImp", "doFileRestore OutputStream is null");
                        C13339h.m80014a(outputStreamOpenOutputStream);
                        return false;
                    }
                    for (ContentValues contentValues : contentValuesArrM200s) {
                        if (BackupObject.isAbort()) {
                            break;
                        }
                        byte[] asByteArray = contentValues.getAsByteArray("file_data");
                        if (asByteArray != null) {
                            outputStreamOpenOutputStream.write(asByteArray);
                        } else {
                            C2111d.m12648d("MmsSmsImp", "Restore  files Failed data is null");
                        }
                    }
                    C13339h.m80014a(outputStreamOpenOutputStream);
                    return true;
                } catch (IOException unused) {
                    C2111d.m12648d("MmsSmsImp", "Restore  files Failed IOException.");
                    C13339h.m80014a(null);
                    return false;
                }
            } catch (Throwable th2) {
                C13339h.m80014a(null);
                throw th2;
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getBackupCount(Context context) {
            if (context == null || !this.isInitSuccess) {
                return 0;
            }
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(this.uri, this.projections, this.selection, this.selectionArgs, this.sortOrder);
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("MmsSmsImp", "getBackupCount IllegalArgumentException");
                    if (cursorQuery != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "getBackupCount error.");
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    return 0;
                }
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getRestoreCount(AbstractC0048c abstractC0048c) {
            if (abstractC0048c == null || !this.isInitSuccess) {
                return 0;
            }
            Cursor cursorMo194l = null;
            try {
                try {
                    try {
                        cursorMo194l = abstractC0048c.mo194l(this.backTable, this.projections, this.selection, this.selectionArgs, null);
                    } catch (Exception unused) {
                        C2111d.m12648d("MmsSmsImp", "getRestoreCount error.");
                        if (cursorMo194l != null) {
                        }
                    }
                } catch (IllegalArgumentException unused2) {
                    C2111d.m12648d("MmsSmsImp", "getRestoreCount IllegalArgumentException");
                    if (cursorMo194l != null) {
                    }
                }
                if (cursorMo194l == null || !cursorMo194l.moveToFirst()) {
                    return 0;
                }
                int count = cursorMo194l.getCount();
                cursorMo194l.close();
                return count;
            } finally {
                if (cursorMo194l != null) {
                    cursorMo194l.close();
                }
            }
        }

        /* renamed from: h */
        public final boolean m84871h(Context context, AbstractC0048c abstractC0048c, long j10, long j11) {
            boolean z10;
            boolean z11;
            long jLongValue;
            Object obj;
            ContentResolver contentResolver;
            Uri uri;
            StringBuilder sb2;
            int i10;
            String lastPathSegment;
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("part_tb", C14134d.this.f63196b, "mid = " + j10, null, null);
            boolean z12 = false;
            if (contentValuesArrM200s == null) {
                C2111d.m12648d("MmsSmsImp", "partTable is restore error. because partValues is null.");
                return false;
            }
            int length = contentValuesArrM200s.length;
            int i11 = 0;
            while (i11 < length) {
                ContentValues contentValues = contentValuesArrM200s[i11];
                if (BackupObject.isAbort()) {
                    return true;
                }
                try {
                    try {
                        jLongValue = contentValues.getAsLong("_id").longValue();
                        contentValues.put("mid", Long.valueOf(j11));
                        contentValues.remove("_id");
                        obj = contentValues.get("_data");
                        contentValues.remove("_data");
                        contentResolver = context.getContentResolver();
                        uri = C14138h.f63216a;
                        sb2 = new StringBuilder();
                        i10 = length;
                    } catch (IllegalStateException unused) {
                        z11 = z12;
                    } catch (NumberFormatException unused2) {
                        z10 = z12;
                    }
                    try {
                        sb2.append(j11);
                        sb2.append("/part");
                        Uri uriInsert = contentResolver.insert(C13347p.m80080c(uri, sb2.toString()), contentValues);
                        if (uriInsert == null) {
                            return false;
                        }
                        if (obj != null && (lastPathSegment = uriInsert.getLastPathSegment()) != null && !m84870g(context, abstractC0048c, jLongValue, C13342k.m80057f(lastPathSegment))) {
                            return false;
                        }
                        i11++;
                        length = i10;
                        z12 = false;
                    } catch (IllegalStateException unused3) {
                        z11 = false;
                        C2111d.m12648d("MmsSmsImp", "Restore IllegalStateException");
                        return z11;
                    } catch (NumberFormatException unused4) {
                        z10 = false;
                        C2111d.m12648d("MmsSmsImp", "Restore NumberFormatException");
                        return z10;
                    }
                } catch (Exception unused5) {
                    C2111d.m12648d("MmsSmsImp", "Restore files Failed ");
                    return false;
                }
            }
            return true;
        }

        /* renamed from: i */
        public final String m84872i(Context context, Handler.Callback callback, Object obj, ContentValues contentValues) {
            Uri uriInsert = context.getContentResolver().insert(C14138h.f63216a, contentValues);
            if (uriInsert == null) {
                notifyRestoreOneFail(callback, obj);
                return null;
            }
            String lastPathSegment = uriInsert.getLastPathSegment();
            if (lastPathSegment != null) {
                return lastPathSegment;
            }
            notifyRestoreOneFail(callback, obj);
            return null;
        }

        /* renamed from: j */
        public final void m84873j(int i10, boolean z10) {
            if (z10) {
                C2111d.m12653i("MmsSmsImp", "force report");
            }
            int i11 = this.f63207d + i10;
            this.f63207d = i11;
            if (z10 || i11 >= 100) {
                C14134d.this.m84904k().mo311g(this.f63207d);
                this.f63207d = 0;
            }
        }

        /* renamed from: k */
        public final void m84874k(Context context, Handler.Callback callback, Object obj, long j10) {
            context.getContentResolver().delete(C14138h.f63216a, "_id = '" + j10 + "'", null);
            notifyRestoreOneFail(callback, obj);
        }

        /* renamed from: l */
        public final void m84875l(Context context, AbstractC0048c abstractC0048c, long j10, long j11) {
            if (!m84881r(j10, j11, context, abstractC0048c)) {
                C2111d.m12648d("MmsSmsImp", "restore one addr data failed");
            }
            m84873j(1, false);
        }

        /* renamed from: m */
        public final int m84876m(InputStream inputStream, AbstractC0048c abstractC0048c, long j10) throws IOException {
            if (inputStream == null) {
                C2111d.m12648d("MmsSmsImp", "onBackupFiles InputStream is null");
                return 2;
            }
            ContentValues contentValues = new ContentValues();
            byte[] bArr = C14134d.this.isOtherPhoneSupportPduFileOptimization() ? new byte[ARImageMetadata.SHADING_MODE] : new byte[inputStream.available()];
            int i10 = 0;
            while (true) {
                try {
                    int i11 = inputStream.read(bArr);
                    if (i11 <= 0) {
                        return 1;
                    }
                    byte[] bArr2 = new byte[i11];
                    System.arraycopy(bArr, 0, bArr2, 0, i11);
                    contentValues.clear();
                    contentValues.put("_id", Long.valueOf(j10));
                    int i12 = i10 + 1;
                    contentValues.put("data_index", Integer.valueOf(i10));
                    contentValues.put("file_data", bArr2);
                    if (abstractC0048c.m185A("files_mms_tb", contentValues) != 1) {
                        return 2;
                    }
                    i10 = i12;
                } catch (IOException unused) {
                    C2111d.m12648d("MmsSmsImp", "onBackupFiles IOException");
                    return 2;
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "onBackupFiles Exception");
                    return 2;
                }
            }
        }

        /* renamed from: n */
        public final int m84877n(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, Cursor cursor) {
            int i10 = 0;
            while (!BackupObject.isAbort()) {
                ContentValues contentValuesM13213u = C2157a.m13213u(cursor, this.fields);
                if (contentValuesM13213u != null) {
                    m84880q(contentValuesM13213u);
                    if (C14134d.this.f63205k.contains(contentValuesM13213u.getAsLong(CrashHianalyticsData.THREAD_ID))) {
                        try {
                            if (abstractC0048c.m185A(this.backTable, contentValuesM13213u) != 1) {
                                notifyBackupOneFail(callback, obj);
                            } else {
                                notifyBackupOneSuccess(callback, obj);
                                i10++;
                                long jLongValue = contentValuesM13213u.getAsLong("_id").longValue();
                                if (!m84869f(jLongValue, context, abstractC0048c)) {
                                    C2111d.m12648d("MmsSmsImp", "backup one addr data failed");
                                }
                                C9662e c9662e = new C9662e(C14137g.f63214a, C14134d.this.f63196b, "mid='" + jLongValue + "'", null, null);
                                c9662e.m60337g(C14137g.m84899a());
                                ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
                                if (backupValues.length != 0 && abstractC0048c.mo186B("part_tb", backupValues, null, null) == 1) {
                                    m84879p(backupValues, context, abstractC0048c);
                                }
                            }
                        } catch (Exception unused) {
                            C2111d.m12648d("MmsSmsImp", "PduSubkeyInfo doEachBackup error ");
                        }
                    } else {
                        C2111d.m12657m("MmsSmsImp", "thread_id is not exists, give up this pdu");
                    }
                }
                if (!cursor.moveToNext()) {
                    break;
                }
            }
            return i10;
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneFail(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo309e();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneSuccess(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo313i();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneFail(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo312h();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneSuccess(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo307c();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00f5 A[LOOP:0: B:3:0x0028->B:37:0x00f5, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f1 A[EDGE_INSN: B:46:0x00f1->B:35:0x00f1 BREAK  A[LOOP:0: B:3:0x0028->B:37:0x00f5], SYNTHETIC] */
        /* renamed from: o */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m84878o(android.content.Context r22, p006a5.AbstractC0048c r23, android.os.Handler.Callback r24, java.lang.Object r25, android.database.Cursor r26) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.a.m84878o(android.content.Context, a5.c, android.os.Handler$Callback, java.lang.Object, android.database.Cursor):void");
        }

        /* renamed from: p */
        public final void m84879p(ContentValues[] contentValuesArr, Context context, AbstractC0048c abstractC0048c) throws IOException {
            InputStream inputStreamOpenInputStream = null;
            try {
                try {
                    for (ContentValues contentValues : contentValuesArr) {
                        if (contentValues.getAsString("_data") != null) {
                            long jLongValue = contentValues.getAsLong("_id").longValue();
                            Uri uriM80080c = C13347p.m80080c(C14137g.f63214a, String.valueOf(jLongValue));
                            if (uriM80080c != null) {
                                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriM80080c);
                                m84876m(inputStreamOpenInputStream, abstractC0048c, jLongValue);
                            }
                        }
                    }
                } catch (IOException unused) {
                    C2111d.m12648d("MmsSmsImp", "PduSubkeyInfo doEachBackup IOException");
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "PduSubkeyInfo doEachBackup Exception");
                }
            } finally {
                C13339h.m80014a(inputStreamOpenInputStream);
            }
        }

        /* renamed from: q */
        public final void m84880q(ContentValues contentValues) {
            if (contentValues.containsKey("phone_id")) {
                Integer asInteger = contentValues.getAsInteger("phone_id");
                asInteger.intValue();
                contentValues.put(CallLogCons.SUBID, asInteger);
                contentValues.remove("phone_id");
            }
        }

        /* renamed from: r */
        public final boolean m84881r(long j10, long j11, Context context, AbstractC0048c abstractC0048c) {
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("addr_tb", this.f63206c, "msg_id = " + j10, null, null);
            if (contentValuesArrM200s == null) {
                return true;
            }
            for (ContentValues contentValues : contentValuesArrM200s) {
                if (BackupObject.isAbort()) {
                    break;
                }
                contentValues.put("msg_id", Long.valueOf(j11));
                if (!C13333b.m79954b(context, C13347p.m80080c(C14138h.f63216a, j11 + "/addr"), contentValues)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: z5.d$b */
    public class b extends BackupObject.SubKeyInfo {

        /* renamed from: c */
        public int f63209c;

        public b(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            super(uri, str, map, str2);
            this.f63209c = 0;
        }

        /* renamed from: p */
        private void m84882p(int i10, boolean z10) {
            if (z10) {
                C2111d.m12653i("MmsSmsImp", "force report");
            }
            int i11 = this.f63209c + i10;
            this.f63209c = i11;
            if (z10 || i11 >= 100) {
                C14134d.this.m84904k().mo311g(this.f63209c);
                this.f63209c = 0;
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int doEachBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
            int iM84887j = 0;
            if (abstractC0048c == null || context == null) {
                return 0;
            }
            abstractC0048c.mo169a();
            Cursor cursorQuery = null;
            try {
                try {
                    try {
                        cursorQuery = context.getContentResolver().query(this.uri, this.projections, this.selection, this.selectionArgs, this.sortOrder);
                    } catch (SQLException unused) {
                        C2111d.m12648d("MmsSmsImp", "doEachBackup SQLException");
                        if (cursorQuery != null) {
                        }
                    } catch (Exception unused2) {
                        C2111d.m12648d("MmsSmsImp", "calendar write events values failed ");
                        if (cursorQuery != null) {
                        }
                    }
                } catch (IllegalArgumentException unused3) {
                    C2111d.m12648d("MmsSmsImp", "doEachBackup IllegalArgumentException");
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    iM84887j = m84887j(abstractC0048c, callback, obj, cursorQuery);
                    cursorQuery.close();
                    abstractC0048c.mo171c();
                    return iM84887j;
                }
                return 0;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                abstractC0048c.mo171c();
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void doEachRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
            if (context == null || abstractC0048c == null) {
                return;
            }
            Cursor cursorMo194l = null;
            try {
                try {
                    cursorMo194l = abstractC0048c.mo194l(this.backTable, AbstractC14131a.m84804b(context) ? C14134d.this.m84865v(this.projections) : this.projections, this.selection, this.selectionArgs, null);
                    m84893q(context, callback, obj, cursorMo194l);
                    if (cursorMo194l == null) {
                        return;
                    }
                } catch (SQLiteException unused) {
                    C2111d.m12648d("MmsSmsImp", "doEachRestore SQLiteException ");
                    if (cursorMo194l == null) {
                        return;
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "doEachRestore Exception ");
                    if (cursorMo194l == null) {
                        return;
                    }
                }
                cursorMo194l.close();
            } catch (Throwable th2) {
                if (cursorMo194l != null) {
                    cursorMo194l.close();
                }
                throw th2;
            }
        }

        /* renamed from: f */
        public final void m84883f(Context context, ArrayList<ContentProviderOperation> arrayList, ArrayList<ContentValues> arrayList2, Handler.Callback callback, Object obj) throws RemoteException, OperationApplicationException {
            ContentProviderResult[] contentProviderResultArrM84884g = m84884g(context, arrayList);
            if (arrayList2 == null) {
                return;
            }
            if (contentProviderResultArrM84884g == null || contentProviderResultArrM84884g.length <= 0) {
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    if (C13333b.m79954b(context, this.uri, arrayList2.get(i10))) {
                        m84882p(1, false);
                    } else {
                        notifyRestoreOneFail(callback, obj);
                    }
                }
                arrayList2.clear();
                return;
            }
            for (int i11 = 0; i11 < contentProviderResultArrM84884g.length; i11++) {
                if (contentProviderResultArrM84884g[i11].uri != null) {
                    m84882p(1, false);
                } else if (C13333b.m79954b(context, this.uri, arrayList2.get(i11))) {
                    m84882p(1, false);
                } else {
                    notifyRestoreOneFail(callback, obj);
                }
            }
            arrayList2.clear();
        }

        /* renamed from: g */
        public final ContentProviderResult[] m84884g(Context context, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
            try {
                ContentProviderResult[] contentProviderResultArrApplyBatch = context.getContentResolver().applyBatch(NavigationUtils.SMS_SCHEMA_PREF, arrayList);
                arrayList.clear();
                return contentProviderResultArrApplyBatch;
            } catch (RemoteException unused) {
                C2111d.m12648d("MmsSmsImp", "applyBatchAndListClear RemoteException.");
                return new ContentProviderResult[0];
            } catch (Exception unused2) {
                C2111d.m12648d("MmsSmsImp", "applyBatchAndListClear error.");
                return new ContentProviderResult[0];
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getBackupCount(Context context) {
            if (context == null || !this.isInitSuccess) {
                return 0;
            }
            Cursor cursorQuery = null;
            try {
                try {
                    try {
                        cursorQuery = context.getContentResolver().query(this.uri, this.projections, this.selection, this.selectionArgs, this.sortOrder);
                    } catch (SQLiteException unused) {
                        C2111d.m12648d("MmsSmsImp", "getBackupCount SQLiteException");
                        if (cursorQuery != null) {
                        }
                    } catch (Exception unused2) {
                        C2111d.m12648d("MmsSmsImp", "getBackupCount error");
                        if (cursorQuery != null) {
                        }
                    }
                } catch (IllegalStateException unused3) {
                    C2111d.m12648d("MmsSmsImp", "getBackupCount IllegalStateException");
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    return 0;
                }
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getRestoreCount(AbstractC0048c abstractC0048c) {
            if (abstractC0048c == null || !this.isInitSuccess) {
                return 0;
            }
            Cursor cursorMo194l = null;
            try {
                try {
                    cursorMo194l = abstractC0048c.mo194l(this.backTable, this.projections, this.selection, this.selectionArgs, null);
                } catch (SQLiteException unused) {
                    C2111d.m12648d("MmsSmsImp", "getRestoreCount SQLiteException");
                    if (cursorMo194l != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "getRestoreCount Exception");
                    if (cursorMo194l != null) {
                    }
                }
                if (cursorMo194l == null || !cursorMo194l.moveToFirst()) {
                    return 0;
                }
                int count = cursorMo194l.getCount();
                cursorMo194l.close();
                return count;
            } finally {
                if (cursorMo194l != null) {
                    cursorMo194l.close();
                }
            }
        }

        /* renamed from: h */
        public final boolean m84885h(Long l10) {
            ContentResolver contentResolver = C14134d.this.f63203i.getContentResolver();
            boolean z10 = false;
            Cursor cursorQuery = null;
            try {
                try {
                } catch (IllegalStateException unused) {
                    C2111d.m12648d("MmsSmsImp", "getOneThreadIds exception.");
                    if (0 != 0) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MmsSmsImp", "getOneThreadIds failed.");
                    if (0 != 0) {
                    }
                }
                if (contentResolver == null) {
                    C2111d.m12653i("MmsSmsImp", "getOneThreadIds resolver is null.");
                    return false;
                }
                cursorQuery = contentResolver.query(C14134d.f63195q, new String[]{"_id"}, "_id=?", new String[]{l10.toString()}, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    C2111d.m12653i("MmsSmsImp", "getOneThreadIds threadsCursor is null.");
                } else {
                    C2111d.m12653i("MmsSmsImp", "getOneThreadIds threadsCursor is exist.");
                    z10 = true;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z10;
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }

        /* renamed from: i */
        public final void m84886i(ArrayList<ContentValues> arrayList, Context context, Handler.Callback callback, Object obj) {
            if (arrayList == null || context == null || arrayList.isEmpty()) {
                return;
            }
            int iBulkInsert = context.getContentResolver().bulkInsert(this.uri, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
            m84882p(iBulkInsert, false);
            int size = arrayList.size() - iBulkInsert;
            if (size > 0) {
                C2111d.m12648d("MmsSmsImp", "sms do bulk insert fail, total: " + arrayList.size() + " failNum:" + size);
            }
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                if (!z10) {
                    C14134d.this.sendMsg(100, C2111d.m12652h("MmsSmsImp", NavigationUtils.SMS_SCHEMA_PREF, "doBulkInsert", "insert fail"), callback, obj);
                    z10 = true;
                }
                notifyRestoreOneFail(callback, obj);
            }
            arrayList.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[LOOP:0: B:3:0x001e->B:31:0x00cd, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cc A[EDGE_INSN: B:35:0x00cc->B:30:0x00cc BREAK  A[LOOP:0: B:3:0x001e->B:31:0x00cd], SYNTHETIC] */
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int m84887j(p006a5.AbstractC0048c r12, android.os.Handler.Callback r13, java.lang.Object r14, android.database.Cursor r15) {
            /*
                r11 = this;
                int r6 = r15.getCount()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "totalNum is "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                java.lang.String r7 = "MmsSmsImp"
                com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r7, r0)
                r8 = 0
                r0 = r8
                r4 = r0
                r9 = r4
            L1e:
                boolean r1 = com.huawei.android.backup.service.logic.BackupObject.isAbort()
                if (r1 == 0) goto L26
                goto Lcc
            L26:
                r1 = 1
                int r10 = r0 + 1
                java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r11.fields
                android.content.ContentValues r0 = com.huawei.android.backup.service.utils.C2157a.m13213u(r15, r0)
                if (r0 != 0) goto L51
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "doEachBackup values is null continue.index: "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r0 = r0.toString()
                com.huawei.android.backup.filelogic.utils.C2111d.m12657m(r7, r0)
                r0 = r11
                r1 = r13
                r2 = r14
                r3 = r6
                r5 = r10
                int r0 = r0.m84895s(r1, r2, r3, r4, r5)
            L4e:
                r4 = r0
                goto Lc6
            L51:
                java.lang.String r2 = "phone_id"
                boolean r3 = r0.containsKey(r2)
                if (r3 == 0) goto L68
                java.lang.Integer r3 = r0.getAsInteger(r2)
                r3.intValue()
                java.lang.String r5 = "sub_id"
                r0.put(r5, r3)
                r0.remove(r2)
            L68:
                java.lang.String r2 = "thread_id"
                java.lang.Long r2 = r0.getAsLong(r2)
                z5.d r3 = p833z5.C14134d.this
                java.util.Set r3 = p833z5.C14134d.m84834m(r3)
                boolean r3 = r3.contains(r2)
                if (r3 != 0) goto La3
                boolean r3 = r11.m84885h(r2)
                if (r3 == 0) goto L8a
                z5.d r3 = p833z5.C14134d.this
                java.util.Set r3 = p833z5.C14134d.m84834m(r3)
                r3.add(r2)
                goto La3
            L8a:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
                java.lang.String r1 = " threadId: "
                java.lang.String r3 = "thread_id is not exists, give up this sms. index: "
                java.lang.Object[] r0 = new java.lang.Object[]{r3, r0, r1, r2}
                com.huawei.android.backup.filelogic.utils.C2111d.m12658n(r7, r0)
                r0 = r11
                r1 = r13
                r2 = r14
                r3 = r6
                r5 = r10
                int r0 = r0.m84895s(r1, r2, r3, r4, r5)
                goto L4e
            La3:
                java.lang.String r2 = r11.backTable     // Catch: java.lang.Exception -> Lbe
                int r0 = r12.m185A(r2, r0)     // Catch: java.lang.Exception -> Lbe
                if (r0 != r1) goto Lba
                int r9 = r9 + 1
                int r4 = r4 + 1
                r0 = 500(0x1f4, float:7.0E-43)
                if (r4 == r0) goto Lb5
                if (r10 != r6) goto Lc6
            Lb5:
                r11.m84892o(r13, r14, r4)     // Catch: java.lang.Exception -> Lbe
                r4 = r8
                goto Lc6
            Lba:
                r11.notifyBackupOneFail(r13, r14)     // Catch: java.lang.Exception -> Lbe
                goto Lc6
            Lbe:
                java.lang.String r0 = "calendar write events values failed"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r7, r0)
                r11.notifyBackupOneFail(r13, r14)
            Lc6:
                boolean r0 = r15.moveToNext()
                if (r0 != 0) goto Lcd
            Lcc:
                return r9
            Lcd:
                r0 = r10
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.b.m84887j(a5.c, android.os.Handler$Callback, java.lang.Object, android.database.Cursor):int");
        }

        /* renamed from: k */
        public final HashMap<String, Long> m84888k(Context context) {
            if (m84889l(context)) {
                return C14133c.m84831e(context);
            }
            return null;
        }

        /* renamed from: l */
        public final boolean m84889l(Context context) throws Throwable {
            Bundle bundleM12615a = C2108a.m12615a(context, this.uri, "METHOD_BULKINSERT_SUPPORT", null, C14134d.this.reassembleExtra(null));
            return bundleM12615a != null && C10713c.m65392b(bundleM12615a, "HW_KOBACKUP_BULKINSERT", false);
        }

        /* renamed from: m */
        public final boolean m84890m(Context context, HashMap<String, Long> map) throws Throwable {
            boolean zM84889l = m84889l(context);
            return zM84889l ? map != null : zM84889l;
        }

        /* renamed from: n */
        public final int m84891n(boolean z10, ArrayList<ContentProviderOperation> arrayList, ArrayList<ContentValues> arrayList2, int i10, ContentValues contentValues) {
            if (!z10) {
                ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(this.uri);
                builderNewInsert.withValues(contentValues);
                arrayList.add(builderNewInsert.build());
            }
            arrayList2.add(contentValues);
            return i10 + 1;
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneFail(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo309e();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneSuccess(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo313i();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneFail(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo312h();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneSuccess(Handler.Callback callback, Object obj) {
            C14134d.this.m84904k().mo307c();
        }

        /* renamed from: o */
        public void m84892o(Handler.Callback callback, Object obj, int i10) {
            C14134d.this.m84904k().mo306b(i10);
        }

        /* renamed from: q */
        public final void m84893q(Context context, Handler.Callback callback, Object obj, Cursor cursor) throws Throwable {
            int count = (cursor == null || !cursor.moveToFirst()) ? 0 : cursor.getCount();
            if (count <= 0) {
                C2111d.m12648d("MmsSmsImp", "uri is restore error. because values is null.");
            } else {
                m84894r(context, callback, obj, cursor, count);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0136 A[LOOP:0: B:3:0x005a->B:49:0x0136, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x012f A[SYNTHETIC] */
        /* renamed from: r */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m84894r(android.content.Context r23, android.os.Handler.Callback r24, java.lang.Object r25, android.database.Cursor r26, int r27) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 321
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.b.m84894r(android.content.Context, android.os.Handler$Callback, java.lang.Object, android.database.Cursor, int):void");
        }

        /* renamed from: s */
        public final int m84895s(Handler.Callback callback, Object obj, int i10, int i11, int i12) {
            if (i12 != i10) {
                return i11;
            }
            m84892o(callback, obj, i11);
            return 0;
        }

        /* renamed from: t */
        public final void m84896t(ArrayList<ContentValues> arrayList, HashMap<String, Long> map, HashMap<String, Long> map2) {
            Long l10;
            if (arrayList == null || map2 == null) {
                return;
            }
            Iterator<ContentValues> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentValues next = it.next();
                String asString = next.getAsString(C5799g0.f25867g);
                if (map2.containsKey(asString)) {
                    l10 = map2.get(asString);
                } else {
                    Long lM84828b = C14133c.m84828b(map, asString);
                    map2.put(asString, lM84828b);
                    l10 = lM84828b;
                }
                if (l10 != null) {
                    next.put("person", l10);
                }
                next.put("HW_KOBACKUP_BULKINSERT_END", Boolean.FALSE);
            }
        }
    }

    static {
        Uri uriM80079b = C13347p.m80079b("content://mms-sms/conversations");
        f63194p = uriM80079b;
        f63195q = uriM80079b.buildUpon().appendQueryParameter("simple", FaqConstants.DISABLE_HA_REPORT).appendQueryParameter("cbs", FaqConstants.DISABLE_HA_REPORT).appendQueryParameter("cmas", FaqConstants.DISABLE_HA_REPORT).appendQueryParameter("etws", FaqConstants.DISABLE_HA_REPORT).build();
    }

    public C14134d(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c) {
        super(interfaceC2155n);
        this.f63196b = null;
        this.f63197c = new HashMap<>(2048);
        this.f63198d = new HashMap<>(2048);
        this.f63199e = new HashMap<>(2048);
        this.f63200f = new HashMap<>(2048);
        this.f63201g = new HashMap<>(2048);
        this.f63202h = new ArrayList<>(Arrays.asList(new b(C14139i.f63218a, "sms_tb", C14139i.m84902a(), NavigationUtils.SMS_SCHEMA_PREF), new a(C14138h.f63216a, "pdu_tb", "(thread_id >0)", null, C14138h.m84900a(), "pdu")));
        this.f63205k = new HashSet(2048);
        this.f63203i = context;
        this.f63204j = abstractC0048c;
    }

    /* renamed from: B */
    public static ContentValues[] m84832B(Context context, Map<String, String> map) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(f63195q, f63192n, null, null, null);
            if (m84833L(cursorQuery)) {
                return new ContentValues[0];
            }
            int count = cursorQuery.getCount();
            ContentValues[] contentValuesArr = new ContentValues[count];
            int i10 = 0;
            while (!BackupObject.isAbort()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("recipient_ids"));
                String[] strArrSplit = string.split(" ");
                StringBuffer stringBuffer = new StringBuffer(map.size());
                for (String str : strArrSplit) {
                    if (BackupObject.isAbort()) {
                        break;
                    }
                    if (map.containsKey(str)) {
                        stringBuffer.append(map.get(str));
                        stringBuffer.append(' ');
                    }
                }
                if (stringBuffer.length() - 1 >= 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                if (i10 >= 0 && i10 < count) {
                    ContentValues contentValues = new ContentValues();
                    contentValuesArr[i10] = contentValues;
                    contentValues.put(CrashHianalyticsData.THREAD_ID, Long.valueOf(j10));
                    contentValuesArr[i10].put(C5799g0.f25867g, stringBuffer.toString());
                    contentValuesArr[i10].put("recipient_ids", string);
                }
                i10++;
                if (!cursorQuery.moveToNext()) {
                    break;
                }
            }
            cursorQuery.close();
            return contentValuesArr;
        } catch (SQLException | IllegalStateException unused) {
            C2111d.m12648d("MmsSmsImp", "getThreadsValues IllegalStateException or SQLException");
            return new ContentValues[0];
        } catch (Exception unused2) {
            C2111d.m12648d("MmsSmsImp", "getThreadsValues exception");
            return new ContentValues[0];
        }
    }

    /* renamed from: L */
    public static boolean m84833L(Cursor cursor) {
        if (cursor == null) {
            C2111d.m12648d("MmsSmsImp", "threadsCursor is null.");
            return true;
        }
        if (cursor.moveToFirst()) {
            return false;
        }
        C2111d.m12648d("MmsSmsImp", "close cursor.");
        cursor.close();
        return true;
    }

    /* renamed from: x */
    public static long m84843x(Context context, Set<String> set) {
        if (context == null || context.getContentResolver() == null || set == null) {
            C2111d.m12648d("MmsSmsImp", "getOrCreateThreadId parameter is wrong");
            return -1L;
        }
        Uri.Builder builderBuildUpon = f63190l.buildUpon();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            builderBuildUpon.appendQueryParameter("recipient", it.next());
        }
        Uri uriBuild = builderBuildUpon.build();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuild, f63191m, null, null, null);
            } catch (IllegalStateException unused) {
                C2111d.m12648d("MmsSmsImp", "getOrCreateThreadId IllegalStateException!");
                if (0 != 0) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("MmsSmsImp", "getOrCreateThreadId Exception!");
                if (0 != 0) {
                }
            }
            if (cursorQuery == null) {
                return -1L;
            }
            if (cursorQuery.moveToFirst()) {
                long j10 = cursorQuery.getLong(0);
                cursorQuery.close();
                return j10;
            }
            C2111d.m12648d("MmsSmsImp", "getOrCreateThreadId returned no rows!");
            cursorQuery.close();
            return -1L;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[PHI: r2
  0x0085: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:29:0x00ac, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m84844A(com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo r13) {
        /*
            r12 = this;
            java.lang.String r0 = "error_info"
            java.lang.String r1 = "thread_id"
            java.lang.String r2 = "getSubkeyNum begin."
            java.lang.String r3 = "MmsSmsImp"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r3, r2)
            r2 = 0
            r4 = 0
            android.content.Context r5 = r12.f63203i     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            android.content.ContentResolver r6 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            android.net.Uri r7 = r13.getUri()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            r5 = 1
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            r8[r4] = r1     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r2 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            if (r2 == 0) goto L5a
            boolean r5 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            if (r5 != 0) goto L2c
            goto L5a
        L2c:
            r5 = r4
        L2d:
            int r6 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            long r6 = r2.getLong(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            java.util.Set<java.lang.Long> r8 = r12.f63205k     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            boolean r6 = r8.contains(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            if (r6 == 0) goto L44
            int r5 = r5 + 1
            goto L49
        L44:
            java.lang.String r6 = "thread_id is not exists"
            com.huawei.android.backup.filelogic.utils.C2111d.m12657m(r3, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
        L49:
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56 java.lang.IllegalArgumentException -> L58
            if (r6 != 0) goto L2d
            r2.close()
            r4 = r5
            goto Laf
        L54:
            r12 = move-exception
            goto Lb5
        L56:
            r1 = move-exception
            goto L60
        L58:
            r1 = move-exception
            goto L89
        L5a:
            if (r2 == 0) goto L5f
            r2.close()
        L5f:
            return r4
        L60:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r5.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r6 = "getSubkeyNum Exception. error: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L54
            r5.append(r1)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L54
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r1)     // Catch: java.lang.Throwable -> L54
            android.net.Uri r13 = r13.getUri()     // Catch: java.lang.Throwable -> L54
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L54
            r12.attachUriInfo(r13, r0, r1)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto Laf
        L85:
            r2.close()
            goto Laf
        L89:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r5.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r6 = "IllegalArgumentException Exception. error: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L54
            r5.append(r1)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L54
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r3, r1)     // Catch: java.lang.Throwable -> L54
            android.net.Uri r13 = r13.getUri()     // Catch: java.lang.Throwable -> L54
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> L54
            r12.attachUriInfo(r13, r0, r1)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto Laf
            goto L85
        Laf:
            java.lang.String r12 = "getSubkeyNum end."
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r3, r12)
            return r4
        Lb5:
            if (r2 == 0) goto Lba
            r2.close()
        Lba:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.m84844A(com.huawei.android.backup.service.logic.BackupObject$SubKeyInfo):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m84845C(android.content.Context r20, android.content.ContentValues r21, java.util.HashMap<java.lang.Long, java.lang.String> r22, java.util.HashMap<java.lang.Long, java.lang.Long> r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "thread_id"
            java.lang.Long r5 = r1.getAsLong(r4)
            int r6 = r22.size()
            java.lang.String r7 = "MmsSmsImp"
            if (r6 <= 0) goto L1c
            boolean r6 = r2.containsKey(r5)
            if (r6 != 0) goto L1f
        L1c:
            r0 = 0
            goto Ldd
        L1f:
            boolean r6 = r3.containsKey(r5)
            r9 = 1
            if (r6 == 0) goto L33
            java.lang.Object r0 = r3.get(r5)
            java.lang.Long r0 = (java.lang.Long) r0
            r0.longValue()
            r1.put(r4, r0)
            return r9
        L33:
            java.util.HashSet r6 = new java.util.HashSet
            r10 = 2048(0x800, float:2.87E-42)
            r6.<init>(r10)
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>(r10)
            java.util.HashMap<java.lang.Long, java.lang.String> r10 = r0.f63199e
            int r10 = r10.size()
            java.lang.String r12 = " "
            if (r10 <= 0) goto L88
            java.util.HashMap<java.lang.Long, java.lang.String> r10 = r0.f63198d
            java.lang.Object r10 = r10.get(r5)
            java.lang.String r10 = (java.lang.String) r10
            boolean r13 = android.text.TextUtils.isEmpty(r10)
            if (r13 != 0) goto L88
            java.lang.String[] r10 = r10.split(r12)
            int r13 = r10.length
            r14 = 0
            r15 = 0
        L5e:
            if (r14 >= r13) goto L89
            r16 = r10[r14]
            java.util.HashMap<java.lang.Long, java.lang.String> r9 = r0.f63199e     // Catch: java.lang.NumberFormatException -> L73
            long r17 = p699v4.C13342k.m80057f(r16)     // Catch: java.lang.NumberFormatException -> L73
            java.lang.Long r8 = java.lang.Long.valueOf(r17)     // Catch: java.lang.NumberFormatException -> L73
            java.lang.Object r8 = r9.get(r8)     // Catch: java.lang.NumberFormatException -> L73
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.NumberFormatException -> L73
            goto L7a
        L73:
            java.lang.String r8 = "handleContent NumberFormatException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r7, r8)
            r8 = r16
        L7a:
            boolean r9 = r0.m84853K(r8)
            if (r9 == 0) goto L81
            r15 = 1
        L81:
            r11.add(r8)
            int r14 = r14 + 1
            r9 = 1
            goto L5e
        L88:
            r15 = 0
        L89:
            java.util.HashMap<java.lang.Long, java.lang.String> r8 = r0.f63199e
            int r8 = r8.size()
            if (r8 <= 0) goto L93
            if (r15 == 0) goto La9
        L93:
            java.lang.String r8 = "addresses_tb has null addresses, get addresses Map from thread_tb"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r7, r8)
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String[] r2 = r2.split(r12)
            java.util.List r2 = java.util.Arrays.asList(r2)
            r6.addAll(r2)
        La9:
            java.util.Set r0 = r0.m84868z(r11, r6, r5)
            java.lang.String r2 = "null"
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto Lbd
            java.lang.String r2 = ""
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto Lbf
        Lbd:
            r0 = 0
            goto Ldc
        Lbf:
            r2 = r20
            long r6 = m84843x(r2, r0)
            r8 = -1
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto Lcd
            r0 = 0
            return r0
        Lcd:
            java.lang.Long r0 = java.lang.Long.valueOf(r6)
            r3.put(r5, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r6)
            r1.put(r4, r0)
            r0 = 1
        Ldc:
            return r0
        Ldd:
            java.lang.String r1 = "handleContent return false here"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r7, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p833z5.C14134d.m84845C(android.content.Context, android.content.ContentValues, java.util.HashMap, java.util.HashMap):boolean");
    }

    /* renamed from: D */
    public final Map<String, String> m84846D(ContentValues[] contentValuesArr) {
        HashMap map = new HashMap(contentValuesArr.length);
        for (ContentValues contentValues : contentValuesArr) {
            if (contentValues != null) {
                map.put(contentValues.getAsLong("_id").toString(), contentValues.getAsString(C5799g0.f25867g));
            }
        }
        return map;
    }

    /* renamed from: E */
    public final void m84847E() {
        ContentValues[] contentValuesArrM199r = this.f63204j.m199r("addresses_tb");
        this.f63199e.clear();
        if (contentValuesArrM199r == null || contentValuesArrM199r.length == 0) {
            return;
        }
        for (ContentValues contentValues : contentValuesArrM199r) {
            try {
                this.f63199e.put(contentValues.getAsLong("_id"), contentValues.getAsString(C5799g0.f25867g));
            } catch (Exception unused) {
                C2111d.m12648d("MmsSmsImp", "initAddressesMap Exception ");
            }
        }
    }

    /* renamed from: F */
    public final Set<String> m84848F(Long l10) {
        ContentValues[] contentValuesArrM200s;
        ContentValues[] contentValuesArrM200s2 = this.f63204j.m200s("sms_tb", null, "thread_id = " + l10, null, null);
        HashSet hashSet = new HashSet();
        if (contentValuesArrM200s2 != null && contentValuesArrM200s2.length != 0) {
            for (ContentValues contentValues : contentValuesArrM200s2) {
                String asString = contentValues.getAsString(C5799g0.f25867g);
                if (!m84853K(asString)) {
                    hashSet.add(asString);
                }
            }
        }
        try {
            contentValuesArrM200s = this.f63204j.m200s("pdu_tb", null, "thread_id = " + l10, null, null);
        } catch (Exception unused) {
            C2111d.m12648d("MmsSmsImp", "read pdu_tb error");
            contentValuesArrM200s = null;
        }
        if (contentValuesArrM200s != null && contentValuesArrM200s.length != 0) {
            for (ContentValues contentValues2 : contentValuesArrM200s) {
                Long asLong = contentValues2.getAsLong("_id");
                asLong.longValue();
                if (this.f63200f.containsKey(asLong)) {
                    String str = this.f63200f.get(asLong);
                    if (!m84853K(str)) {
                        hashSet.add(str);
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: G */
    public final void m84849G() {
        ContentValues[] contentValuesArrM199r = this.f63204j.m199r("addr_tb");
        this.f63200f.clear();
        if (contentValuesArrM199r == null || contentValuesArrM199r.length == 0) {
            return;
        }
        for (ContentValues contentValues : contentValuesArrM199r) {
            try {
                this.f63200f.put(contentValues.getAsLong("msg_id"), contentValues.getAsString(C5799g0.f25867g));
            } catch (Exception unused) {
                C2111d.m12648d("MmsSmsImp", "mapGetFromPdu put Exception.");
            }
        }
    }

    /* renamed from: H */
    public final Set<Long> m84850H() {
        C2111d.m12653i("MmsSmsImp", "initAllThreadIds begin.");
        HashSet hashSet = new HashSet(2048);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f63203i.getContentResolver().query(f63195q, new String[]{"_id"}, null, null, null);
            } catch (IllegalStateException unused) {
                C2111d.m12648d("MmsSmsImp", "getAllThreadIds exception");
                hashSet = new HashSet(0);
                if (0 != 0) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("MmsSmsImp", "getAllThreadIds failed");
                hashSet = new HashSet(0);
                if (0 != 0) {
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    hashSet.add(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_id"))));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                C2111d.m12653i("MmsSmsImp", "initAllThreadIds end.");
                return hashSet;
            }
            C2111d.m12648d("MmsSmsImp", "getAllThreadIds threadsCursor is null.");
            return hashSet;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: I */
    public final void m84851I() {
        ContentValues[] contentValuesArrM199r = this.f63204j.m199r("threads_tb");
        if (contentValuesArrM199r == null || contentValuesArrM199r.length == 0) {
            return;
        }
        for (ContentValues contentValues : contentValuesArrM199r) {
            try {
                this.f63197c.put(contentValues.getAsLong(CrashHianalyticsData.THREAD_ID), contentValues.getAsString(C5799g0.f25867g));
                this.f63198d.put(contentValues.getAsLong(CrashHianalyticsData.THREAD_ID), contentValues.getAsString("recipient_ids"));
            } catch (Exception unused) {
                C2111d.m12648d("MmsSmsImp", "initThreadsMap Exception.");
            }
        }
    }

    /* renamed from: J */
    public final boolean m84852J(Set<String> set) {
        if (C13348q.m80082b(set) || set.contains("null") || set.contains("")) {
            C2111d.m12657m("MmsSmsImp", "setAddress has null");
            return false;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                C2111d.m12657m("MmsSmsImp", "setAddress has null str");
                return false;
            }
        }
        return true;
    }

    /* renamed from: K */
    public final boolean m84853K(String str) {
        return str == null || str.isEmpty() || "null".equals(str);
    }

    /* renamed from: M */
    public final void m84854M(boolean z10, ContentValues contentValues) {
        if (z10 && contentValues.containsKey(CallLogCons.SUBID)) {
            Integer asInteger = contentValues.getAsInteger(CallLogCons.SUBID);
            asInteger.intValue();
            contentValues.put("phone_id", asInteger);
            contentValues.remove(CallLogCons.SUBID);
        }
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: b */
    public boolean mo84855b() {
        return true;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: c */
    public boolean mo84856c() {
        return true;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: d */
    public int mo84857d() {
        Map<String, String> map;
        int iMo186B;
        C9662e c9662e = new C9662e(C14136f.f63212a, f63193o, null, null, null);
        c9662e.m60337g(C14136f.m84898a());
        ContentValues[] backupValues = BackupObject.getBackupValues(this.f63203i, c9662e);
        if (backupValues.length != 0) {
            int iMo186B2 = this.f63204j.mo186B("addresses_tb", backupValues, null, null);
            if (iMo186B2 != 1) {
                return storeHandlerMsgToObjectMsg(iMo186B2);
            }
            map = m84846D(backupValues);
        } else {
            map = new HashMap<>(2048);
        }
        ContentValues[] contentValuesArrM84832B = m84832B(this.f63203i, map);
        if (contentValuesArrM84832B.length > 0 && (iMo186B = this.f63204j.mo186B("threads_tb", contentValuesArrM84832B, null, null)) != 1) {
            return storeHandlerMsgToObjectMsg(iMo186B);
        }
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            BackupObject.SubKeyInfo next = it.next();
            int iDoEachBackup = next.doEachBackup(this.f63203i, this.f63204j, null, null);
            i10 += iDoEachBackup;
            attachUriInfo(String.valueOf(next.getUri()), "count", String.valueOf(iDoEachBackup));
        }
        return i10;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: e */
    public boolean mo84858e() {
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().initEach(this.f63203i, 1, this.f63204j)) {
                i10++;
            } else {
                C2111d.m12648d("MmsSmsImp", "Failed at init");
            }
        }
        String[] strArrM84866w = m84866w(C2157a.m13202j(this.f63203i, C14137g.f63214a), C14137g.m84899a());
        this.f63196b = strArrM84866w;
        if (strArrM84866w != null && strArrM84866w.length > 0) {
            i10++;
        }
        return i10 > 0;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: f */
    public boolean mo84859f() {
        Set<String> setMo202u;
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().initEach(this.f63203i, 2, this.f63204j)) {
                i10++;
            } else {
                C2111d.m12648d("MmsSmsImp", "Failed at init");
            }
        }
        String[] strArrM13202j = C2157a.m13202j(this.f63203i, C14137g.f63214a);
        AbstractC0048c abstractC0048c = this.f63204j;
        if (abstractC0048c != null && (setMo202u = abstractC0048c.mo202u("part_tb")) != null && setMo202u.size() > 0) {
            this.f63196b = m84867y(strArrM13202j, setMo202u, C14137g.m84899a());
        }
        String[] strArr = this.f63196b;
        if (strArr != null && strArr.length > 0) {
            i10++;
        }
        return i10 > 0;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: g */
    public int mo84860g() {
        m84851I();
        m84847E();
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        while (it.hasNext()) {
            it.next().doEachRestore(this.f63203i, this.f63204j, null, null);
        }
        return 0;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: h */
    public int mo84861h() {
        return mo84863j();
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: i */
    public String mo84862i() {
        StringBuffer stringBuffer = new StringBuffer(this.f63202h.size());
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getTable());
            stringBuffer.append(";");
        }
        if (stringBuffer.length() - 1 >= 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: j */
    public int mo84863j() {
        this.f63205k = m84850H();
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            BackupObject.SubKeyInfo next = it.next();
            int iM84844A = m84844A(next);
            addModuleUriInfo(String.valueOf(next.getUri()), true, true, iM84844A);
            if (iM84844A >= 0) {
                i11 += iM84844A;
            } else {
                i10++;
            }
        }
        if (i10 >= this.f63202h.size()) {
            return -1;
        }
        return i11;
    }

    @Override // p833z5.AbstractC14140j
    /* renamed from: l */
    public int mo84864l() {
        Iterator<BackupObject.SubKeyInfo> it = this.f63202h.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            BackupObject.SubKeyInfo next = it.next();
            int restoreCount = next.getRestoreCount(this.f63204j);
            addModuleUriInfo(String.valueOf(next.getUri()), true, true, restoreCount);
            i10 += restoreCount;
        }
        return i10;
    }

    /* renamed from: v */
    public final String[] m84865v(String[] strArr) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = CallLogCons.SUBID;
        return strArr2;
    }

    /* renamed from: w */
    public final String[] m84866w(String[] strArr, HashMap<String, Integer> map) {
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: y */
    public final String[] m84867y(String[] strArr, Set<String> set, HashMap<String, Integer> map) {
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (map.containsKey(str) && set.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: z */
    public final Set<String> m84868z(Set<String> set, Set<String> set2, Long l10) {
        if (m84852J(set)) {
            return set;
        }
        if (m84852J(set2)) {
            C2111d.m12653i("MmsSmsImp", "get addresses map from thread_tb success, setFromAddresses.size():" + set.size() + ";setFromThreads.size()" + set2.size());
            return set2;
        }
        m84849G();
        Set<String> setM84848F = m84848F(l10);
        if (m84852J(setM84848F)) {
            C2111d.m12653i("MmsSmsImp", "get addresses map from thread_tb success, setFromAddresses.size():" + set.size() + ";setFromThreads.size():" + set2.size() + "setFromSms.size():" + setM84848F.size());
        }
        return setM84848F;
    }
}
