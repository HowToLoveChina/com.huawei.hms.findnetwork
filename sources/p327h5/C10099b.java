package p327h5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p006a5.AbstractC0048c;
import p279f6.C9662e;
import p327h5.C10100c;

/* renamed from: h5.b */
/* loaded from: classes.dex */
public class C10099b extends AbstractC10098a {

    /* renamed from: a */
    public String[] f49276a = null;

    /* renamed from: b */
    public boolean f49277b = false;

    /* renamed from: h5.b$b */
    public static class b {

        /* renamed from: a */
        public final Context f49278a;

        /* renamed from: b */
        public final Uri f49279b;

        /* renamed from: c */
        public final HashMap<String, Integer> f49280c;

        /* renamed from: d */
        public final String f49281d;

        /* renamed from: e */
        public final HashMap<Integer, Set<c>> f49282e;

        /* renamed from: a */
        public Context m62903a() {
            return this.f49278a;
        }

        /* renamed from: b */
        public HashMap<String, Integer> m62904b() {
            return this.f49280c;
        }

        /* renamed from: c */
        public HashMap<Integer, Set<c>> m62905c() {
            return this.f49282e;
        }

        /* renamed from: d */
        public Uri m62906d() {
            return this.f49279b;
        }

        /* renamed from: e */
        public String m62907e() {
            return this.f49281d;
        }

        public b(Context context, Uri uri, HashMap<String, Integer> map, String str, HashMap<Integer, Set<c>> map2) {
            this.f49278a = context;
            this.f49279b = uri;
            this.f49280c = map;
            this.f49281d = str;
            this.f49282e = map2;
        }
    }

    /* renamed from: h5.b$c */
    public static class c {

        /* renamed from: a */
        public c f49283a;

        /* renamed from: b */
        public ContentValues f49284b;

        /* renamed from: c */
        public int f49285c;

        /* renamed from: d */
        public Set<c> f49286d = new HashSet();

        public c(ContentValues contentValues) {
            this.f49284b = contentValues;
        }

        /* renamed from: a */
        public boolean m62908a(HashMap<Integer, c> map, String[] strArr) {
            if (map == null || strArr == null) {
                Object[] objArr = new Object[2];
                objArr[0] = "computeHashCode map is null? ";
                objArr[1] = Boolean.valueOf(map == null);
                C2111d.m12649e("BackupBookmark", objArr);
                return false;
            }
            if (!this.f49284b.containsKey("_id") || !this.f49284b.containsKey("parent")) {
                C2111d.m12648d("BackupBookmark", "computeHashCode parent not exist? " + this.f49284b.containsKey("parent"));
                return false;
            }
            map.put(this.f49284b.getAsInteger("_id"), this);
            Integer asInteger = this.f49284b.getAsInteger("parent");
            if (asInteger.intValue() == 1) {
                this.f49285c = C2157a.m13214v(String.valueOf(BackupObject.getHash(this.f49284b, strArr)));
            } else {
                c cVar = map.get(asInteger);
                this.f49283a = cVar;
                if (cVar == null) {
                    C2111d.m12648d("BackupBookmark", "computeHashCode parentFileTree is null. ");
                    return false;
                }
                cVar.f49286d.add(this);
                this.f49285c = C2157a.m13214v(BackupObject.getHash(this.f49284b, strArr) + ";" + this.f49283a.f49285c);
            }
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(4:13|(1:15)|16|(7:22|24|43|25|(1:27)|(1:32)|39)(1:20))(1:23)|43|25|(0)|(0)|39) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("BackupBookmark", "onBackupModulesDataItemTotal error.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a6, code lost:
    
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("BackupBookmark", "onBackupModulesDataItemTotal RuntimeException.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ae, code lost:
    
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: all -> 0x0099, Exception -> 0x00a1, RuntimeException -> 0x00a9, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x00a9, blocks: (B:25:0x0070, B:27:0x0080), top: B:43:0x0070, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[DONT_GENERATE, PHI: r1 r2
  0x009d: PHI (r1v9 android.database.Cursor) = (r1v6 android.database.Cursor), (r1v7 android.database.Cursor), (r1v10 android.database.Cursor) binds: [B:35:0x00a8, B:37:0x00ae, B:31:0x009b] A[DONT_GENERATE, DONT_INLINE]
  0x009d: PHI (r2v4 int) = (r2v1 int), (r2v2 int), (r2v5 int) binds: [B:35:0x00a8, B:37:0x00ae, B:31:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m62887f(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "BackupBookmark"
            boolean r1 = r9.m62898l(r10)
            r2 = -1
            if (r1 != 0) goto La
            return r2
        La:
            android.net.Uri r4 = p327h5.C10100c.a.f49289a
            java.lang.String[] r1 = com.huawei.android.backup.service.utils.C2157a.m13202j(r10, r4)
            int r3 = r1.length
            if (r3 != 0) goto L14
            return r2
        L14:
            java.util.List r1 = java.util.Arrays.asList(r1)
            java.lang.String r3 = "device_type"
            boolean r1 = r1.contains(r3)
            if (r1 != 0) goto L21
            return r2
        L21:
            boolean r1 = com.huawei.android.backup.service.utils.BackupConstant.LocalPhoneInfo.IS_I_VERSION
            if (r1 == 0) goto L6b
            boolean r1 = com.huawei.android.backup.service.utils.BackupConstant.LocalPhoneInfo.IS_S7
            java.lang.String r3 = " deleted = 0 and created is not null"
            if (r1 == 0) goto L3c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = " and account_type is null "
            r1.append(r3)
            java.lang.String r3 = r1.toString()
        L3c:
            java.util.HashMap r1 = p327h5.C10100c.a.m62911a()
            java.lang.String r9 = r9.m62892e(r10, r4, r1)
            if (r9 == 0) goto L69
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = " and _id not in ("
            r1.append(r3)
            r1.append(r9)
            java.lang.String r9 = ")"
            r1.append(r9)
            java.lang.String r9 = r1.toString()
        L67:
            r6 = r9
            goto L6e
        L69:
            r6 = r3
            goto L6e
        L6b:
            java.lang.String r9 = " bookmark = 1 "
            goto L67
        L6e:
            r9 = 1
            r1 = 0
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            java.lang.String r9 = "_id"
            r3 = 0
            r5[r3] = r9     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            r7 = 0
            r8 = 0
            r3 = r10
            android.database.Cursor r1 = com.huawei.android.backup.filelogic.utils.C2108a.m12618d(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            if (r1 == 0) goto L9b
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            r9.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            java.lang.String r10 = "getBackupItemCount, totalNumber:"
            r9.append(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            r9.append(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r9)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> La1 java.lang.RuntimeException -> La9
            goto L9b
        L99:
            r9 = move-exception
            goto Lb2
        L9b:
            if (r1 == 0) goto Lb1
        L9d:
            r1.close()
            goto Lb1
        La1:
            java.lang.String r9 = "onBackupModulesDataItemTotal error."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto Lb1
            goto L9d
        La9:
            java.lang.String r9 = "onBackupModulesDataItemTotal RuntimeException."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto Lb1
            goto L9d
        Lb1:
            return r2
        Lb2:
            if (r1 == 0) goto Lb7
            r1.close()
        Lb7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p327h5.C10099b.m62887f(android.content.Context):int");
    }

    private boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        if (!m62898l(context)) {
            return false;
        }
        String[] strArrM13202j = C2157a.m13202j(context, C10100c.a.f49289a);
        if (strArrM13202j.length == 0) {
            return false;
        }
        if (Arrays.asList(strArrM13202j).contains("device_type")) {
            this.f49277b = false;
        } else {
            this.f49277b = true;
        }
        if (i10 == 1) {
            this.f49276a = m62888a(strArrM13202j);
        } else if (i10 != 2 || abstractC0048c == null) {
            this.f49276a = null;
        } else {
            this.f49276a = m62902p(strArrM13202j, abstractC0048c);
        }
        String[] strArr = this.f49276a;
        return strArr != null && strArr.length > 0;
    }

    /* renamed from: a */
    public final String[] m62888a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (C10100c.a.m62911a().containsKey(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public final boolean m62889b(ContentValues contentValues, String[] strArr, HashMap<Integer, c> map, HashSet<Integer> hashSet) {
        c cVar = new c(contentValues);
        return cVar.m62908a(map, strArr) && hashSet.contains(Integer.valueOf(cVar.f49285c));
    }

    /* renamed from: c */
    public final HashSet<Integer> m62890c(b bVar, String[] strArr) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer, c> map = new HashMap<>();
        Cursor cursorM12618d = null;
        try {
            try {
                try {
                    cursorM12618d = C2108a.m12618d(bVar.m62903a(), bVar.m62906d(), this.f49276a, bVar.m62907e(), null, " folder DESC, parent ASC");
                } catch (RuntimeException unused) {
                    C2111d.m12648d("BackupBookmark", "buildBookMarkHashSet RuntimeException.");
                    if (0 != 0) {
                        break;
                    }
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupBookmark", "buildBookMarkHashSet error.");
                if (0 != 0) {
                }
            }
            if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                while (!BackupObject.isAbort()) {
                    ContentValues contentValuesM13213u = C2157a.m13213u(cursorM12618d, bVar.m62904b());
                    if (contentValuesM13213u != null) {
                        c cVar = new c(contentValuesM13213u);
                        if (cVar.m62908a(map, strArr)) {
                            hashSet.add(Integer.valueOf(cVar.f49285c));
                            Set<c> set = bVar.m62905c().get(Integer.valueOf(cVar.f49285c));
                            if (set != null) {
                                set.add(cVar);
                            } else {
                                HashSet hashSet2 = new HashSet();
                                hashSet2.add(cVar);
                                bVar.m62905c().put(Integer.valueOf(cVar.f49285c), hashSet2);
                            }
                        }
                    }
                    if (!cursorM12618d.moveToNext()) {
                        break;
                    }
                }
                cursorM12618d.close();
                return hashSet;
            }
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
            return hashSet;
        } finally {
            if (0 != 0) {
                cursorM12618d.close();
            }
        }
    }

    /* renamed from: d */
    public final int m62891d(Set<c> set, HashSet<Integer> hashSet) {
        Iterator<c> it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (hashSet.contains(Integer.valueOf(it.next().f49285c))) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: e */
    public final String m62892e(Context context, Uri uri, HashMap<String, Integer> map) {
        ContentValues contentValues;
        C9662e c9662e = new C9662e(uri, this.f49276a, "deleted = 0 and created is not null", null, " folder DESC, parent ASC");
        c9662e.m60337g(map);
        ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
        if (backupValues.length == 0 || (contentValues = backupValues[0]) == null || contentValues.getAsInteger("_id") == null || backupValues[0].getAsInteger("parent") == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        for (ContentValues contentValues2 : backupValues) {
            if (contentValues2 != null) {
                Integer asInteger = contentValues2.getAsInteger("_id");
                int iIntValue = asInteger.intValue();
                Integer asInteger2 = contentValues2.getAsInteger("parent");
                if (asInteger2.intValue() == 1 || hashSet.contains(asInteger2)) {
                    hashSet.add(asInteger);
                } else if (z10) {
                    stringBuffer.append(iIntValue);
                    z10 = false;
                } else {
                    stringBuffer.append("," + iIntValue);
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public final ContentValues[] m62893g(Cursor cursor) {
        int count = cursor.getCount();
        C2111d.m12654j("BackupBookmark", "bookmarks total num = ", Integer.valueOf(count));
        ContentValues[] contentValuesArr = new ContentValues[count];
        int i10 = 0;
        while (cursor.getPosition() != count && !BackupObject.isAbort()) {
            if (i10 >= 0 && i10 < count) {
                try {
                    contentValuesArr[i10] = C2157a.m13213u(cursor, C10100c.a.m62911a());
                    int i11 = 1;
                    if (cursor.getColumnIndex("bookmark") == -1) {
                        contentValuesArr[i10].put("bookmark", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(CalendarConfigTable.CalendarTable.Events.DELETED)) == 0 ? 1 : 0));
                    }
                    if (cursor.getColumnIndex(CalendarConfigTable.CalendarTable.Events.DELETED) == -1) {
                        ContentValues contentValues = contentValuesArr[i10];
                        if (cursor.getInt(cursor.getColumnIndexOrThrow("bookmark")) != 0) {
                            i11 = 0;
                        }
                        contentValues.put(CalendarConfigTable.CalendarTable.Events.DELETED, Integer.valueOf(i11));
                    }
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupBookmark", "onBackup IllegalArgumentException");
                } catch (RuntimeException unused2) {
                    C2111d.m12648d("BackupBookmark", "onBackup RuntimeException");
                } catch (Exception unused3) {
                    C2111d.m12648d("BackupBookmark", "onBackup fail:Exception");
                }
            }
            i10++;
            cursor.moveToNext();
        }
        return contentValuesArr;
    }

    /* renamed from: h */
    public final String m62894h(Context context) {
        StringBuilder sb2 = new StringBuilder(512);
        if (BackupConstant.LocalPhoneInfo.IS_I_VERSION) {
            sb2.append(" deleted = 0 and created is not null");
            if (BackupConstant.LocalPhoneInfo.IS_S7) {
                sb2.append(" and account_type is null ");
            }
            String strM62892e = m62892e(context, C10100c.a.f49289a, C10100c.a.m62911a());
            if (strM62892e != null && !"".equals(strM62892e)) {
                sb2.append(" and _id not in ");
                sb2.append("(");
                sb2.append(strM62892e);
                sb2.append(")");
            }
        } else {
            sb2.append(" bookmark = 1 ");
        }
        return sb2.toString();
    }

    /* renamed from: i */
    public final String m62895i(String str, AbstractC0048c abstractC0048c) {
        ContentValues[] contentValuesArrM200s;
        if (!BackupConstant.LocalPhoneInfo.IS_I_VERSION || (contentValuesArrM200s = abstractC0048c.m200s("bookmarks_tb", null, str, null, null)) == null || contentValuesArrM200s.length < 1 || !contentValuesArrM200s[0].containsKey("folder")) {
            return null;
        }
        return "folder DESC, parent ASC";
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (C2157a.m13166A(context) && C2157a.m13168C() && init(context, 1, null)) {
            return !this.f49277b;
        }
        return false;
    }

    /* renamed from: j */
    public final int m62896j(int i10, int i11, HashMap<Integer, Set<c>> map, HashMap<Integer, c> map2) {
        int i12 = -1;
        if (map == null || map2 == null) {
            Object[] objArr = new Object[2];
            objArr[0] = "getParentId error. localFileTreeHashMap is null? ";
            objArr[1] = Boolean.valueOf(map == null);
            C2111d.m12649e("BackupBookmark", objArr);
            return -1;
        }
        Set<c> set = map.get(Integer.valueOf(map2.get(Integer.valueOf(i11)).f49285c));
        if (set == null || set.isEmpty()) {
            C2111d.m12648d("BackupBookmark", "getParentId error. hashEqualSet is null.");
            return -1;
        }
        if (set.size() == 1) {
            Iterator<c> it = set.iterator();
            if (it.hasNext()) {
                return it.next().f49284b.getAsInteger("_id").intValue();
            }
            C2111d.m12648d("BackupBookmark", "getParentId error..");
            return -1;
        }
        Set<c> set2 = map2.get(Integer.valueOf(i11)).f49286d;
        HashSet<Integer> hashSet = new HashSet<>();
        for (c cVar : set2) {
            if (i10 != cVar.f49284b.getAsInteger("_id").intValue()) {
                hashSet.add(Integer.valueOf(cVar.f49285c));
            }
        }
        int i13 = -1;
        for (c cVar2 : set) {
            int iIntValue = cVar2.f49284b.getAsInteger("_id").intValue();
            if (cVar2.f49286d.isEmpty() && hashSet.isEmpty()) {
                return iIntValue;
            }
            int iM62891d = m62891d(cVar2.f49286d, hashSet);
            if (iM62891d > i13) {
                i13 = iM62891d;
                i12 = iIntValue;
            }
        }
        return i12;
    }

    /* renamed from: k */
    public final String m62897k() {
        if (BackupConstant.LocalPhoneInfo.IS_I_VERSION && BackupConstant.LocalPhoneInfo.IS_S7) {
            return " account_type is null ";
        }
        return null;
    }

    /* renamed from: l */
    public final boolean m62898l(Context context) {
        if (BackupConstant.LocalPhoneInfo.IS_I_VERSION) {
            return C2157a.m13184S(context, C10100c.a.f49289a);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01d4 A[Catch: all -> 0x00a5, IllegalStateException -> 0x01f5, Exception -> 0x0262, TRY_LEAVE, TryCatch #3 {all -> 0x00a5, blocks: (B:17:0x0092, B:89:0x0264, B:91:0x0280, B:93:0x02b0, B:95:0x02b7, B:96:0x02c2, B:32:0x00fe, B:38:0x0109, B:41:0x0121, B:43:0x0127, B:45:0x012f, B:65:0x01c5, B:67:0x01d4, B:71:0x01e5, B:83:0x022d, B:84:0x0232, B:51:0x0150, B:54:0x0165, B:56:0x0174, B:58:0x0186, B:62:0x01af, B:78:0x020f), top: B:108:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0264 A[Catch: all -> 0x00a5, TRY_ENTER, TryCatch #3 {all -> 0x00a5, blocks: (B:17:0x0092, B:89:0x0264, B:91:0x0280, B:93:0x02b0, B:95:0x02b7, B:96:0x02c2, B:32:0x00fe, B:38:0x0109, B:41:0x0121, B:43:0x0127, B:45:0x012f, B:65:0x01c5, B:67:0x01d4, B:71:0x01e5, B:83:0x022d, B:84:0x0232, B:51:0x0150, B:54:0x0165, B:56:0x0174, B:58:0x0186, B:62:0x01af, B:78:0x020f), top: B:108:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b7 A[Catch: all -> 0x00a5, TryCatch #3 {all -> 0x00a5, blocks: (B:17:0x0092, B:89:0x0264, B:91:0x0280, B:93:0x02b0, B:95:0x02b7, B:96:0x02c2, B:32:0x00fe, B:38:0x0109, B:41:0x0121, B:43:0x0127, B:45:0x012f, B:65:0x01c5, B:67:0x01d4, B:71:0x01e5, B:83:0x022d, B:84:0x0232, B:51:0x0150, B:54:0x0165, B:56:0x0174, B:58:0x0186, B:62:0x01af, B:78:0x020f), top: B:108:0x0092 }] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m62899m(android.content.Context r26, p006a5.AbstractC0048c r27, android.os.Handler.Callback r28, java.lang.Object r29, android.content.ContentValues[] r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 747
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p327h5.C10099b.m62899m(android.content.Context, a5.c, android.os.Handler$Callback, java.lang.Object, android.content.ContentValues[]):void");
    }

    /* renamed from: n */
    public final void m62900n(int i10, C2126b.a aVar, AbstractC0048c abstractC0048c) {
        if (i10 == 1) {
            this.backupFileModuleInfo.updateModuleInfo(aVar.m12766e(), 8, "bookmarks");
        }
        if (this.backupFileModuleInfo.hasRecord()) {
            return;
        }
        abstractC0048c.m190h();
    }

    /* renamed from: o */
    public final int m62901o(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        if (abstractC0048c == null) {
            return 5;
        }
        String strM62897k = m62897k();
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("bookmarks_tb", this.f49276a, strM62897k, null, m62895i(strM62897k, abstractC0048c));
        if (contentValuesArrM200s == null || contentValuesArrM200s.length < 1) {
            return 5;
        }
        m62899m(context, abstractC0048c, callback, obj, contentValuesArrM200s);
        return 4;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws Throwable {
        C2111d.m12653i("BackupBookmark", "Backup bookmark.");
        if (abstractC0048c == null || !init(context, 1, null)) {
            C2111d.m12648d("BackupBookmark", "Backup Failed at init!");
            return 2;
        }
        C2126b.a aVar = new C2126b.a(callback, obj);
        Cursor cursorM12618d = C2108a.m12618d(context, C10100c.a.f49289a, this.f49276a, m62894h(context), null, null);
        try {
            if (cursorM12618d != null) {
                if (cursorM12618d.moveToFirst()) {
                    int iMo186B = abstractC0048c.mo186B("bookmarks_tb", m62893g(cursorM12618d), this.backupObjectCallback, aVar);
                    cursorM12618d.close();
                    m62900n(iMo186B, aVar, abstractC0048c);
                    return storeHandlerMsgToObjectMsg(iMo186B);
                }
            }
            if (cursorM12618d != null) {
            }
            return 1;
        } catch (Exception unused) {
            sendMsg(100, C2111d.m12652h("BackupBookmark", "bookmark", "onBackup", "Exception"), callback, obj);
            C2111d.m12648d("BackupBookmark", "Backup Failed.");
            return 2;
        } catch (RuntimeException unused2) {
            C2111d.m12648d("BackupBookmark", "Backup RuntimeException.");
            sendMsg(101, C2111d.m12652h("BackupBookmark", "bookmark", "onBackup", "RuntimeException"), callback, obj);
            return 2;
        } finally {
            cursorM12618d.close();
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iM62887f = m62887f(context);
        C2111d.m12653i("BackupBookmark", " totalTermNumber" + iM62887f);
        if (iM62887f < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM62887f);
        bundle.putLong("ModuleSize", l10.longValue());
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (init(context, 2, abstractC0048c)) {
            C2111d.m12653i("BackupBookmark", "Restore bookmark.");
            return m62901o(context, abstractC0048c, callback, obj);
        }
        sendMsg(101, C2111d.m12652h("BackupBookmark", "bookmark", "onRestore", "init fail"), callback, obj);
        return 5;
    }

    /* renamed from: p */
    public final String[] m62902p(String[] strArr, AbstractC0048c abstractC0048c) {
        ArrayList arrayList = new ArrayList();
        Set<String> setMo202u = abstractC0048c.mo202u("bookmarks_tb");
        if (setMo202u != null && setMo202u.size() > 0) {
            for (String str : strArr) {
                if (C10100c.a.m62911a().containsKey(str) && setMo202u.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
