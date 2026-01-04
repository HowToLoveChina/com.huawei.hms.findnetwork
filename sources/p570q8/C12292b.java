package p570q8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import p015ak.AbstractC0218h0;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: q8.b */
/* loaded from: classes2.dex */
public class C12292b {
    /* renamed from: a */
    public static HashSet<Object> m73846a(Context context, Uri uri, HashMap<String, Integer> map, String str, String[] strArr) throws IOException {
        HashSet<Object> hashSet = new HashSet<>();
        Cursor cursorQuery = null;
        try {
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("NotepadUtil", "buildCurrHashSet, TargetApp is not SystemApp");
                return null;
            }
            try {
                cursorQuery = context.getContentResolver().query(uri, strArr, str, null, null);
            } catch (Exception e10) {
                C11839m.m70687e("NotepadUtil", "Exception occour" + e10.toString());
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    ContentValues contentValuesM73850e = m73850e(cursorQuery, map);
                    if (contentValuesM73850e != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (String str2 : strArr) {
                            stringBuffer.append(contentValuesM73850e.getAsString(str2) + ";");
                        }
                        hashSet.add(Integer.valueOf(m73852g(stringBuffer.toString())));
                    }
                } while (cursorQuery.moveToNext());
                m73847b(cursorQuery);
                return hashSet;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            m73847b(cursorQuery);
            return hashSet;
        } catch (Throwable th2) {
            m73847b(null);
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m73847b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                C11839m.m70687e("NotepadUtil", " close error: " + e10.toString());
            }
        }
    }

    /* renamed from: c */
    public static boolean m73848c(ContentValues contentValues, String[] strArr, HashSet<Object> hashSet) {
        if (strArr == null || hashSet == null || hashSet.size() < 1) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            if (!contentValues.containsKey(str)) {
                return false;
            }
            stringBuffer.append(contentValues.getAsString(str) + ";");
        }
        return hashSet.contains(Integer.valueOf(m73852g(stringBuffer.toString())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] m73849d(android.content.Context r9, android.net.Uri r10) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "NotepadUtil"
            r1 = 0
            java.lang.String r5 = "_id = 0"
            r6 = 0
            r7 = 0
            r4 = 0
            r2 = r9
            r3 = r10
            android.database.Cursor r9 = p015ak.C0209d.m1286n2(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            if (r9 != 0) goto L1e
            java.lang.String r10 = "cursor is null"
            p514o9.C11839m.m70686d(r0, r10)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            goto L1e
        L16:
            r10 = move-exception
            r1 = r9
            goto L56
        L19:
            r10 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
            goto L39
        L1e:
            if (r9 == 0) goto L31
            java.lang.String[] r10 = r9.getColumnNames()     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L19
            if (r10 == 0) goto L30
            int r0 = r10.length     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L2a
            if (r0 != 0) goto L30
            goto L31
        L2a:
            r1 = move-exception
            r8 = r1
            r1 = r9
            r9 = r10
            r10 = r8
            goto L39
        L30:
            r1 = r10
        L31:
            m73847b(r9)
            goto L55
        L35:
            r10 = move-exception
            goto L56
        L37:
            r10 = move-exception
            r9 = r1
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r2.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "Util getColumnNames failed:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L35
            r2.append(r10)     // Catch: java.lang.Throwable -> L35
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> L35
            p514o9.C11839m.m70689w(r0, r10)     // Catch: java.lang.Throwable -> L35
            m73847b(r1)
            r1 = r9
        L55:
            return r1
        L56:
            m73847b(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p570q8.C12292b.m73849d(android.content.Context, android.net.Uri):java.lang.String[]");
    }

    /* renamed from: e */
    public static ContentValues m73850e(Cursor cursor, Map<String, Integer> map) {
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        ContentValues contentValues = new ContentValues();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (cursor.getColumnIndex(key) >= 0) {
                m73851f(map.get(key).intValue(), key, cursor, contentValues);
            }
        }
        return contentValues;
    }

    /* renamed from: f */
    public static void m73851f(int i10, String str, Cursor cursor, ContentValues contentValues) {
        switch (i10) {
            case 1:
                contentValues.put(str, cursor.getString(cursor.getColumnIndexOrThrow(str)));
                break;
            case 2:
            case 5:
                contentValues.put(str, Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str))));
                break;
            case 3:
                contentValues.put(str, Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(str))));
                break;
            case 4:
                contentValues.put(str, cursor.getBlob(cursor.getColumnIndexOrThrow(str)));
                break;
            case 6:
                contentValues.put(str, Float.valueOf(cursor.getFloat(cursor.getColumnIndexOrThrow(str))));
                break;
            case 7:
                if (cursor.getString(cursor.getColumnIndexOrThrow(str)) != null) {
                    contentValues.put(str, Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str))));
                    break;
                } else {
                    contentValues.putNull(str);
                    break;
                }
            case 8:
                if (cursor.getString(cursor.getColumnIndexOrThrow(str)) != null) {
                    contentValues.put(str, Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(str))));
                    break;
                } else {
                    contentValues.putNull(str);
                    break;
                }
        }
    }

    /* renamed from: g */
    public static int m73852g(String str) {
        return str.hashCode();
    }

    /* renamed from: h */
    public static String[] m73853h(String[] strArr, AbstractC0218h0 abstractC0218h0) {
        ArrayList arrayList = new ArrayList();
        HashSet<String> hashSetMo1460i = abstractC0218h0.mo1460i("notes_tb");
        if (hashSetMo1460i != null && hashSetMo1460i.size() > 0) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (C12291a.m73845a().containsKey(strArr[i10]) && hashSetMo1460i.contains(strArr[i10])) {
                    arrayList.add(strArr[i10]);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
