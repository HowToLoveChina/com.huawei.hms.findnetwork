package p833z5;

import android.telephony.PhoneNumberUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: z5.c */
/* loaded from: classes.dex */
public class C14133c {
    /* renamed from: a */
    public static Long m84827a(HashMap<String, Long> map, String str) {
        Iterator<Map.Entry<String, Long>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            int length = str.length() - 1;
            int length2 = key.length() - 1;
            int i10 = 0;
            while (length >= 0 && length2 >= 0) {
                char cCharAt = str.charAt(length);
                char cCharAt2 = key.charAt(length2);
                if (!m84830d(cCharAt)) {
                    length--;
                } else if (!m84830d(cCharAt2)) {
                    length2--;
                } else {
                    if (cCharAt != cCharAt2) {
                        break;
                    }
                    length--;
                    length2--;
                    i10++;
                }
            }
            if (m84829c(length, length2, i10)) {
                return map.get(key);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Long m84828b(HashMap<String, Long> map, String str) {
        if (map == null || map.isEmpty() || str == null) {
            return null;
        }
        String number = PhoneNumberUtils.formatNumber(str);
        return map.containsKey(number) ? map.get(number) : m84827a(map, number);
    }

    /* renamed from: c */
    public static boolean m84829c(int i10, int i11, int i12) {
        if (i12 < 7) {
            return i10 < 0 && i11 < 0;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m84830d(char c10) {
        return (c10 >= '0' && c10 <= '9') || (c10 == '*' || c10 == '#' || c10 == '+');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.Long> m84831e(android.content.Context r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "ContactMatchHelper"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.net.Uri r3 = android.provider.Contacts.Phones.CONTENT_URI
            java.lang.String r2 = "person"
            java.lang.String r4 = "number"
            java.lang.String[] r4 = new java.lang.String[]{r2, r4}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
            if (r9 == 0) goto L41
        L1f:
            boolean r2 = r9.moveToNext()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            if (r2 == 0) goto L41
            r2 = 1
            java.lang.String r2 = r9.getString(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            if (r2 == 0) goto L34
            java.lang.String r2 = android.telephony.PhoneNumberUtils.formatNumber(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            goto L34
        L31:
            r0 = move-exception
            r8 = r9
            goto L63
        L34:
            r3 = 0
            long r3 = r9.getLong(r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L4d java.lang.IllegalArgumentException -> L58
            goto L1f
        L41:
            if (r9 == 0) goto L46
            r9.close()
        L46:
            return r1
        L47:
            r0 = move-exception
            goto L63
        L49:
            r9 = r8
            goto L4d
        L4b:
            r9 = r8
            goto L58
        L4d:
            java.lang.String r1 = "insert: query contact uri error."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L31
            if (r9 == 0) goto L57
            r9.close()
        L57:
            return r8
        L58:
            java.lang.String r1 = "insert: query contact uri IllegalArgumentException."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L31
            if (r9 == 0) goto L62
            r9.close()
        L62:
            return r8
        L63:
            if (r8 == 0) goto L68
            r8.close()
        L68:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p833z5.C14133c.m84831e(android.content.Context):java.util.HashMap");
    }
}
