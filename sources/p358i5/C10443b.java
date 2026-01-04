package p358i5;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.CallLog;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p006a5.AbstractC0048c;
import p699v4.C13333b;

/* renamed from: i5.b */
/* loaded from: classes.dex */
public class C10443b extends AbstractC10442a {

    /* renamed from: d */
    public static final Uri f50394d = CallLog.Calls.CONTENT_URI.buildUpon().appendQueryParameter("avoid_update_name", FaqConstants.DISABLE_HA_REPORT).build();

    /* renamed from: e */
    public static final HashMap<Integer, Integer> f50395e;

    /* renamed from: a */
    public String[] f50396a = null;

    /* renamed from: b */
    public int f50397b = 1;

    /* renamed from: c */
    public int f50398c = 0;

    /* renamed from: i5.b$a */
    public static class a {

        /* renamed from: a */
        public String f50399a;

        /* renamed from: b */
        public int f50400b;

        public a(String str, int i10) {
            this.f50399a = str;
            this.f50400b = i10;
        }

        /* renamed from: a */
        public int m64238a() {
            return this.f50400b;
        }

        /* renamed from: b */
        public String m64239b() {
            return this.f50399a;
        }
    }

    static {
        HashMap<Integer, Integer> map = new HashMap<>(1);
        f50395e = map;
        map.put(10, 5);
    }

    /* renamed from: f */
    private int m64219f(Context context) {
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"_id"}, null, null, null);
                    count = cursorQuery != null ? cursorQuery.getCount() : -1;
                } catch (Exception unused) {
                    C2111d.m12648d("BackupCallLogsImp", "getBackupItemCount error:Exception");
                    if (cursorQuery != null) {
                    }
                }
            } catch (IllegalArgumentException unused2) {
                C2111d.m12648d("BackupCallLogsImp", "getBackupItemCount error:IllegalArgumentException");
                if (cursorQuery != null) {
                }
            }
            return count;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        String[] strArrM13202j = C2157a.m13202j(context, CallLog.Calls.CONTENT_URI);
        if (strArrM13202j.length == 0) {
            return false;
        }
        if (i10 == 1) {
            this.f50396a = m64224g(strArrM13202j);
        } else if (i10 != 2 || abstractC0048c == null) {
            C2111d.m12647c("BackupCallLogsImp", "init flags: ", Integer.valueOf(i10));
        } else {
            Set<String> setMo202u = abstractC0048c.mo202u("calls_tb");
            if (setMo202u != null && setMo202u.size() > 0) {
                this.f50396a = m64227j(strArrM13202j, setMo202u);
            }
        }
        String[] strArr = this.f50396a;
        return strArr != null && strArr.length > 0;
    }

    /* renamed from: b */
    public final void m64220b(Context context, ArrayList<ContentProviderOperation> arrayList, ArrayList<ContentValues> arrayList2, Handler.Callback callback, Object obj) {
        try {
            try {
                m64228k(context, context.getContentResolver().applyBatch("call_log", arrayList), arrayList2, callback, obj);
            } catch (OperationApplicationException unused) {
                m64237t(context, arrayList2, callback, obj);
                C2111d.m12648d("BackupCallLogsImp", "applyBatchAndListClear OperationApplicationException.");
            } catch (RemoteException unused2) {
                m64237t(context, arrayList2, callback, obj);
                C2111d.m12648d("BackupCallLogsImp", "applyBatchAndListClear RemoteException.");
            } catch (Exception unused3) {
                m64237t(context, arrayList2, callback, obj);
                C2111d.m12648d("BackupCallLogsImp", "applyBatchAndListClear Exception.");
            }
        } finally {
            arrayList.clear();
            arrayList2.clear();
        }
    }

    /* renamed from: c */
    public final void m64221c(a aVar, ArrayList<ContentValues> arrayList, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        boolean z10;
        int i10;
        int i11;
        if (arrayList == null) {
            return;
        }
        Iterator<ContentValues> it = arrayList.iterator();
        int i12 = 0;
        boolean z11 = false;
        while (it.hasNext()) {
            ContentValues next = it.next();
            if (BackupObject.isAbort()) {
                return;
            }
            try {
                m64232o(next);
                int iM185A = abstractC0048c.m185A(aVar.m64239b(), next);
                if (iM185A == 1) {
                    int iStoreHandlerMsgToObjectMsg = storeHandlerMsgToObjectMsg(i12);
                    z10 = true;
                    i10 = 100;
                    try {
                        sendMsg(iStoreHandlerMsgToObjectMsg, this.f50397b, aVar.m64238a(), callback, obj);
                        this.f50398c++;
                    } catch (IllegalArgumentException unused) {
                        i11 = 2;
                        String strM12652h = C2111d.m12652h("BackupCallLogsImp", "calllogs", "backupCallLogs", "IllegalArgumentException");
                        if (!z11) {
                            sendMsg(i10, strM12652h, callback, obj);
                            z11 = z10;
                        }
                        attachUriInfo(String.valueOf(CallLog.Calls.CONTENT_URI), C2126b.MODULE_INFO_ERROR_INFO, strM12652h);
                        sendMsg(storeHandlerMsgToObjectMsg(i11), this.f50397b, aVar.m64238a(), callback, obj);
                        C2111d.m12648d("BackupCallLogsImp", "backup RuntimeException.");
                        this.f50397b++;
                        i12 = 0;
                    } catch (Exception unused2) {
                        String strM12652h2 = C2111d.m12652h("BackupCallLogsImp", "calllogs", "backupCallLogs", "Exception");
                        if (!z11) {
                            sendMsg(i10, strM12652h2, callback, obj);
                            z11 = z10;
                        }
                        attachUriInfo(String.valueOf(CallLog.Calls.CONTENT_URI), C2126b.MODULE_INFO_ERROR_INFO, strM12652h2);
                        sendMsg(storeHandlerMsgToObjectMsg(2), this.f50397b, aVar.m64238a(), callback, obj);
                        C2111d.m12648d("BackupCallLogsImp", "backup failed.");
                        this.f50397b++;
                        i12 = 0;
                    }
                } else {
                    sendMsg(storeHandlerMsgToObjectMsg(iM185A), this.f50397b, aVar.m64238a(), callback, obj);
                }
            } catch (IllegalArgumentException unused3) {
                z10 = true;
                i10 = 100;
                i11 = 2;
            } catch (Exception unused4) {
                z10 = true;
                i10 = 100;
            }
            this.f50397b++;
            i12 = 0;
        }
    }

    /* renamed from: d */
    public final int m64222d(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        ArrayList<ContentValues> arrayListM64225h;
        if (abstractC0048c == null || (arrayListM64225h = m64225h(context, null)) == null) {
            return 2;
        }
        if (arrayListM64225h.size() < 1) {
            return 1;
        }
        int size = arrayListM64225h.size();
        abstractC0048c.mo169a();
        m64221c(new a("calls_tb", size), arrayListM64225h, abstractC0048c, callback, obj);
        abstractC0048c.mo171c();
        this.backupFileModuleInfo.updateModuleInfo(this.f50398c, 8, "calls");
        if (this.f50398c > 0) {
            return storeHandlerMsgToObjectMsg(1);
        }
        abstractC0048c.m190h();
        return storeHandlerMsgToObjectMsg(2);
    }

    /* renamed from: e */
    public final String[] m64223e(Context context) {
        return m64229l(context) ? new String[]{"number", "type", CallLogCons.DATE, "duration", CallLogCons.SUBID} : new String[]{"number", "type", CallLogCons.DATE, "duration"};
    }

    /* renamed from: g */
    public final String[] m64224g(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (C10444c.m64240a().containsKey(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058 A[PHI: r9
  0x0058: PHI (r9v4 android.database.Cursor) = (r9v3 android.database.Cursor), (r9v5 android.database.Cursor) binds: [B:26:0x0056, B:30:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList<android.content.ContentValues> m64225h(android.content.Context r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "BackupCallLogsImp"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L4f
            android.net.Uri r4 = android.provider.CallLog.Calls.CONTENT_URI     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L4f
            java.lang.String[] r5 = r9.f50396a     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L4f
            r7 = 0
            r8 = 0
            r6 = r11
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L4f
            if (r9 != 0) goto L1f
            if (r9 == 0) goto L1e
            r9.close()
        L1e:
            return r1
        L1f:
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            if (r10 != 0) goto L2f
            r9.close()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            r9.close()
            return r1
        L2c:
            r10 = move-exception
            r2 = r9
            goto L66
        L2f:
            boolean r10 = com.huawei.android.backup.service.logic.BackupObject.isAbort()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            if (r10 == 0) goto L36
            goto L47
        L36:
            java.util.HashMap r10 = p358i5.C10444c.m64240a()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            android.content.ContentValues r10 = com.huawei.android.backup.service.utils.C2157a.m13213u(r9, r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            r1.add(r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L51 java.lang.IllegalArgumentException -> L5d
            if (r10 != 0) goto L2f
        L47:
            r9.close()
            goto L65
        L4b:
            r10 = move-exception
            goto L66
        L4d:
            r9 = r2
            goto L51
        L4f:
            r9 = r2
            goto L5d
        L51:
            java.lang.String r10 = "Get call logs failed."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L5b
        L58:
            r9.close()
        L5b:
            r1 = r2
            goto L65
        L5d:
            java.lang.String r10 = "Get call logs IllegalArgumentException."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L5b
            goto L58
        L65:
            return r1
        L66:
            if (r2 == 0) goto L6b
            r2.close()
        L6b:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p358i5.C10443b.m64225h(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: i */
    public final void m64226i(ArrayList<ContentProviderOperation> arrayList, ArrayList<ContentValues> arrayList2, ContentValues contentValues) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(f50394d);
        builderNewInsert.withValues(contentValues);
        arrayList.add(builderNewInsert.build());
        arrayList2.add(contentValues);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return C2157a.m13186U(context);
    }

    /* renamed from: j */
    public final String[] m64227j(String[] strArr, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (C10444c.m64240a().containsKey(str) && set.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: k */
    public final void m64228k(Context context, ContentProviderResult[] contentProviderResultArr, ArrayList<ContentValues> arrayList, Handler.Callback callback, Object obj) {
        if (arrayList == null) {
            C2111d.m12646b("BackupCallLogsImp", "contentValuesList is null");
            return;
        }
        if (contentProviderResultArr != null) {
            m64233p(context, contentProviderResultArr, arrayList, callback, obj);
            return;
        }
        C2111d.m12646b("BackupCallLogsImp", "dbResult is null");
        Iterator<ContentValues> it = arrayList.iterator();
        while (it.hasNext()) {
            if (C13333b.m79954b(context, f50394d, it.next())) {
                int i10 = this.subKeyCurCount + 1;
                this.subKeyCurCount = i10;
                sendMsg(3, i10, this.subKeyTotalNum, callback, obj);
            } else {
                C2111d.m12648d("BackupCallLogsImp", "handleResultAndListClear insert fail.");
                int i11 = this.subKeyCurCount;
                this.subKeyCurCount = i11 + 1;
                sendMsg(5, i11, this.subKeyTotalNum, callback, obj);
            }
        }
    }

    /* renamed from: l */
    public final boolean m64229l(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{CallLogCons.SUBID}, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("BackupCallLogsImp", "isContainedSubId error IllegalArgumentException.");
            return false;
        } catch (Exception unused2) {
            C2111d.m12648d("BackupCallLogsImp", "isContainedSubId error.");
            return false;
        }
    }

    /* renamed from: m */
    public final boolean m64230m(Handler.Callback callback, Object obj, ContentValues contentValues) {
        if (contentValues != null) {
            return false;
        }
        C2111d.m12648d("BackupCallLogsImp", "restoreCallLogs cv is null ");
        int i10 = this.subKeyCurCount;
        this.subKeyCurCount = i10 + 1;
        sendMsg(5, i10, this.subKeyTotalNum, callback, obj);
        return true;
    }

    /* renamed from: n */
    public final boolean m64231n(int i10, int i11) {
        return (i10 == this.subKeyTotalNum && i11 != 0) || i11 % 50 == 0;
    }

    /* renamed from: o */
    public final void m64232o(ContentValues contentValues) {
        Integer asInteger;
        if (contentValues.containsKey("type") && (asInteger = contentValues.getAsInteger("type")) != null) {
            HashMap<Integer, Integer> map = f50395e;
            if (map.containsKey(asInteger)) {
                contentValues.put("type", map.get(asInteger));
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupCallLogsImp", "Backup calllogs.");
        if (!init(context, 1, null)) {
            sendMsg(100, C2111d.m12652h("BackupCallLogsImp", "calllogs", "onBackup", "Backup Failed at init"), callback, obj);
            return 2;
        }
        String strValueOf = String.valueOf(CallLog.Calls.CONTENT_URI);
        addModuleUriInfo(strValueOf, true, true, m64219f(context));
        int iM64222d = m64222d(context, abstractC0048c, callback, obj);
        attachUriInfo(strValueOf, "count", String.valueOf(this.f50398c));
        reportModuleBackupFinish(str, callback, obj);
        return iM64222d;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        C2111d.m12653i("BackupCallLogsImp", "onBackupModulesDataItemTotal.");
        int iM64219f = m64219f(context);
        if (iM64219f < 0) {
            return null;
        }
        long appInfoSize = getAppInfoSize(context, l10.longValue(), iM64219f);
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM64219f);
        bundle.putLong("ModuleSize", appInfoSize);
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupCallLogsImp", "Restore calllogs.");
        if (!init(context, 2, abstractC0048c)) {
            return 5;
        }
        String strValueOf = String.valueOf(CallLog.Calls.CONTENT_URI);
        addModuleUriInfo(strValueOf, true, true, this.subKeyTotalNum);
        int iM64236s = m64236s(context, abstractC0048c, callback, obj);
        attachUriInfo(strValueOf, "count", String.valueOf(this.subKeyCurCount));
        reportModuleRestoreFinish(str);
        m64218a(context);
        return iM64236s;
    }

    /* renamed from: p */
    public final void m64233p(Context context, ContentProviderResult[] contentProviderResultArr, ArrayList<ContentValues> arrayList, Handler.Callback callback, Object obj) {
        for (int i10 = 0; i10 < contentProviderResultArr.length; i10++) {
            if (contentProviderResultArr[i10].uri == null) {
                C2111d.m12647c("BackupCallLogsImp", "dbResult[", Integer.valueOf(i10), "].uri is null");
                if (C13333b.m79954b(context, f50394d, arrayList.get(i10))) {
                    int i11 = this.subKeyCurCount + 1;
                    this.subKeyCurCount = i11;
                    sendMsg(3, i11, this.subKeyTotalNum, callback, obj);
                } else {
                    C2111d.m12648d("BackupCallLogsImp", "handleResultAndListClear insert fail..");
                    int i12 = this.subKeyCurCount;
                    this.subKeyCurCount = i12 + 1;
                    sendMsg(5, i12, this.subKeyTotalNum, callback, obj);
                }
            } else {
                int i13 = this.subKeyCurCount + 1;
                this.subKeyCurCount = i13;
                sendMsg(3, i13, this.subKeyTotalNum, callback, obj);
            }
        }
    }

    /* renamed from: q */
    public final void m64234q(Context context, ArrayList<ContentProviderOperation> arrayList, ArrayList<ContentValues> arrayList2, Handler.Callback callback, Object obj) {
        C2111d.m12654j("BackupCallLogsImp", "processResults operationList size = ", Integer.valueOf(arrayList.size()));
        if (arrayList.size() > 0) {
            try {
                m64220b(context, arrayList, arrayList2, callback, obj);
            } catch (IllegalArgumentException unused) {
                sendMsg(5, this.subKeyCurCount, this.subKeyTotalNum, callback, obj);
                C2111d.m12648d("BackupCallLogsImp", "restore IllegalArgumentException.");
            } catch (Exception unused2) {
                sendMsg(5, this.subKeyCurCount, this.subKeyTotalNum, callback, obj);
                C2111d.m12648d("BackupCallLogsImp", "restore failed.");
            }
        }
    }

    /* renamed from: r */
    public final boolean m64235r(Handler.Callback callback, Object obj, boolean z10, String str) {
        if (!z10) {
            sendMsg(101, C2111d.m12652h("BackupCallLogsImp", "calllogs", "backupCallLogs", str), callback, obj);
            z10 = true;
        }
        sendMsg(5, this.subKeyCurCount, this.subKeyTotalNum, callback, obj);
        return z10;
    }

    /* renamed from: s */
    public final int m64236s(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        int i10;
        int i11;
        String str;
        HashSet<Integer> hashSet;
        String[] strArr;
        if (abstractC0048c == null) {
            return 5;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("calls_tb", this.f50396a, null, null, null);
        if (contentValuesArrM200s != null) {
            int i12 = 1;
            if (contentValuesArrM200s.length >= 1) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                ArrayList<ContentValues> arrayList2 = new ArrayList<>();
                this.subKeyTotalNum = contentValuesArrM200s.length;
                int i13 = 0;
                this.subKeyCurCount = 0;
                String[] strArrM64223e = m64223e(context);
                Uri uri = CallLog.Calls.CONTENT_URI;
                HashSet<Integer> hashSetBuildCurrHashSet = BackupObject.buildCurrHashSet(context, uri, C10444c.m64240a(), null, strArrM64223e);
                String strValueOf = String.valueOf(uri);
                C2111d.m12653i("BackupCallLogsImp", "subKeyTotalNum:" + this.subKeyTotalNum);
                int length = contentValuesArrM200s.length;
                int i14 = 0;
                int i15 = 0;
                boolean z10 = false;
                while (i14 < length) {
                    int i16 = length;
                    ContentValues contentValues = contentValuesArrM200s[i14];
                    ContentValues[] contentValuesArr = contentValuesArrM200s;
                    int i17 = i13 + 1;
                    if (BackupObject.isAbort()) {
                        break;
                    }
                    if (m64230m(callback, obj, contentValues)) {
                        i10 = i16;
                        i11 = i14;
                        str = strValueOf;
                        hashSet = hashSetBuildCurrHashSet;
                        strArr = strArrM64223e;
                    } else {
                        try {
                            m64232o(contentValues);
                            if (BackupObject.containsKeys(contentValues, strArrM64223e, hashSetBuildCurrHashSet)) {
                                int i18 = this.subKeyCurCount + i12;
                                this.subKeyCurCount = i18;
                                i11 = i14;
                                i10 = i16;
                                str = strValueOf;
                                hashSet = hashSetBuildCurrHashSet;
                                strArr = strArrM64223e;
                                try {
                                    sendMsg(3, i18, this.subKeyTotalNum, callback, obj);
                                } catch (IllegalArgumentException e10) {
                                    e = e10;
                                    boolean z11 = z10;
                                    String str2 = "restore the item IllegalArgumentException. error: " + e.getMessage();
                                    boolean zM64235r = m64235r(callback, obj, z11, e.getMessage());
                                    C2111d.m12648d("BackupCallLogsImp", str2);
                                    attachUriInfo(str, C2126b.MODULE_INFO_ERROR_INFO, str2);
                                    z10 = zM64235r;
                                    i14 = i11 + 1;
                                    i13 = i17;
                                    strValueOf = str;
                                    contentValuesArrM200s = contentValuesArr;
                                    hashSetBuildCurrHashSet = hashSet;
                                    length = i10;
                                    strArrM64223e = strArr;
                                    i12 = 1;
                                } catch (Exception e11) {
                                    e = e11;
                                    String str3 = "restore the item failed. error: " + e.getMessage();
                                    boolean zM64235r2 = m64235r(callback, obj, z10, "");
                                    C2111d.m12648d("BackupCallLogsImp", str3);
                                    attachUriInfo(str, C2126b.MODULE_INFO_ERROR_INFO, str3);
                                    z10 = zM64235r2;
                                    i14 = i11 + 1;
                                    i13 = i17;
                                    strValueOf = str;
                                    contentValuesArrM200s = contentValuesArr;
                                    hashSetBuildCurrHashSet = hashSet;
                                    length = i10;
                                    strArrM64223e = strArr;
                                    i12 = 1;
                                }
                            } else {
                                i10 = i16;
                                i11 = i14;
                                str = strValueOf;
                                hashSet = hashSetBuildCurrHashSet;
                                strArr = strArrM64223e;
                                m64226i(arrayList, arrayList2, contentValues);
                                int i19 = i15 + 1;
                                try {
                                    if (m64231n(i17, i19)) {
                                        i15 = i19;
                                        m64220b(context, arrayList, arrayList2, callback, obj);
                                    } else {
                                        i15 = i19;
                                    }
                                } catch (IllegalArgumentException e12) {
                                    e = e12;
                                    i15 = i19;
                                    boolean z112 = z10;
                                    String str22 = "restore the item IllegalArgumentException. error: " + e.getMessage();
                                    boolean zM64235r3 = m64235r(callback, obj, z112, e.getMessage());
                                    C2111d.m12648d("BackupCallLogsImp", str22);
                                    attachUriInfo(str, C2126b.MODULE_INFO_ERROR_INFO, str22);
                                    z10 = zM64235r3;
                                    i14 = i11 + 1;
                                    i13 = i17;
                                    strValueOf = str;
                                    contentValuesArrM200s = contentValuesArr;
                                    hashSetBuildCurrHashSet = hashSet;
                                    length = i10;
                                    strArrM64223e = strArr;
                                    i12 = 1;
                                } catch (Exception e13) {
                                    e = e13;
                                    i15 = i19;
                                    String str32 = "restore the item failed. error: " + e.getMessage();
                                    boolean zM64235r22 = m64235r(callback, obj, z10, "");
                                    C2111d.m12648d("BackupCallLogsImp", str32);
                                    attachUriInfo(str, C2126b.MODULE_INFO_ERROR_INFO, str32);
                                    z10 = zM64235r22;
                                    i14 = i11 + 1;
                                    i13 = i17;
                                    strValueOf = str;
                                    contentValuesArrM200s = contentValuesArr;
                                    hashSetBuildCurrHashSet = hashSet;
                                    length = i10;
                                    strArrM64223e = strArr;
                                    i12 = 1;
                                }
                            }
                        } catch (IllegalArgumentException e14) {
                            e = e14;
                            i10 = i16;
                            i11 = i14;
                            str = strValueOf;
                            hashSet = hashSetBuildCurrHashSet;
                            strArr = strArrM64223e;
                        } catch (Exception e15) {
                            e = e15;
                            i10 = i16;
                            i11 = i14;
                            str = strValueOf;
                            hashSet = hashSetBuildCurrHashSet;
                            strArr = strArrM64223e;
                        }
                    }
                    i14 = i11 + 1;
                    i13 = i17;
                    strValueOf = str;
                    contentValuesArrM200s = contentValuesArr;
                    hashSetBuildCurrHashSet = hashSet;
                    length = i10;
                    strArrM64223e = strArr;
                    i12 = 1;
                }
                m64234q(context, arrayList, arrayList2, callback, obj);
                return 4;
            }
        }
        C2111d.m12648d("BackupCallLogsImp", "callLogs is null or empty");
        return 5;
    }

    /* renamed from: t */
    public final void m64237t(Context context, ArrayList<ContentValues> arrayList, Handler.Callback callback, Object obj) {
        String[] strArrM64223e = m64223e(context);
        HashSet<Integer> hashSetBuildCurrHashSet = BackupObject.buildCurrHashSet(context, CallLog.Calls.CONTENT_URI, C10444c.m64240a(), null, strArrM64223e);
        Iterator<ContentValues> it = arrayList.iterator();
        while (it.hasNext()) {
            ContentValues next = it.next();
            if (BackupObject.containsKeys(next, strArrM64223e, hashSetBuildCurrHashSet)) {
                C2111d.m12647c("BackupCallLogsImp", "singleItemApplyAndHandleResult containsKeys subkeyCurCount = ", Integer.valueOf(this.subKeyCurCount));
                int i10 = this.subKeyCurCount + 1;
                this.subKeyCurCount = i10;
                sendMsg(3, i10, this.subKeyTotalNum, callback, obj);
            } else if (C13333b.m79954b(context, CallLog.Calls.CONTENT_URI, next)) {
                C2111d.m12647c("BackupCallLogsImp", "result subkeyCurCount = ", Integer.valueOf(this.subKeyCurCount));
                int i11 = this.subKeyCurCount + 1;
                this.subKeyCurCount = i11;
                sendMsg(3, i11, this.subKeyTotalNum, callback, obj);
            } else {
                C2111d.m12648d("BackupCallLogsImp", "singleItemApplyAndHandleResult insert fail ");
                int i12 = this.subKeyCurCount + 1;
                this.subKeyCurCount = i12;
                sendMsg(5, i12, this.subKeyTotalNum, callback, obj);
            }
        }
    }
}
