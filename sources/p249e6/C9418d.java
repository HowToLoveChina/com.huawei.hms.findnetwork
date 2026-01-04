package p249e6;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p030b6.C1119a;
import p218d6.C9042a;
import p218d6.C9044c;
import p229di.C9142g;
import p279f6.C9662e;
import p386j6.C10711a;
import p699v4.C13333b;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: e6.d */
/* loaded from: classes.dex */
public class C9418d extends AbstractC9416b {

    /* renamed from: h */
    public static final String f47070h;

    /* renamed from: i */
    public static final String f47071i;

    /* renamed from: j */
    public static final String f47072j;

    /* renamed from: k */
    public static final String f47073k;

    /* renamed from: l */
    public static final HashMap<String, String> f47074l;

    /* renamed from: b */
    public Context f47075b;

    /* renamed from: c */
    public AbstractC0048c f47076c;

    /* renamed from: d */
    public ArrayList<String> f47077d;

    /* renamed from: e */
    public ArrayList<String> f47078e;

    /* renamed from: f */
    public boolean f47079f;

    /* renamed from: g */
    public int f47080g;

    static {
        String str = C9142g.m57463b() ? "content://com.hihonor.android.weather/cityInfo" : "content://com.huawei.android.weather/cityInfo";
        f47070h = str;
        String str2 = C9142g.m57463b() ? "content://com.hihonor.android.weather/weatherInfo" : "content://com.huawei.android.weather/weatherInfo";
        f47071i = str2;
        String str3 = C9142g.m57463b() ? "content://com.hihonor.android.weather/weatherDayInfo" : "content://com.huawei.android.weather/weatherDayInfo";
        f47072j = str3;
        String str4 = C9142g.m57463b() ? "content://com.hihonor.android.weather/settingsInfo" : "content://com.huawei.android.weather/settingsInfo";
        f47073k = str4;
        HashMap<String, String> map = new HashMap<>();
        f47074l = map;
        map.put(str, "cityinfo_tb");
        map.put(str2, "weatherInfo_tb");
        map.put(str3, "weatherDayInfo_tb");
        map.put(str4, "settingsInfo_tb");
    }

    public C9418d(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c) {
        super(interfaceC2155n);
        this.f47075b = context;
        this.f47076c = abstractC0048c;
    }

    /* renamed from: p */
    public static int m59063p() {
        return 1;
    }

    /* renamed from: t */
    public static String m59064t(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, String> map = f47074l;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        String strM80078a = C13347p.m80078a(str);
        if (strM80078a == null) {
            return strM80078a;
        }
        return strM80078a + "_tb";
    }

    /* renamed from: w */
    public static int m59065w(AbstractC0048c abstractC0048c) throws Exception {
        ContentValues contentValues;
        if (abstractC0048c == null) {
            throw new C10711a("storeHandler is null");
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("weather_version_info", null, null, null, null);
        if (contentValuesArrM200s == null || contentValuesArrM200s.length == 0 || (contentValues = contentValuesArrM200s[0]) == null) {
            throw new C10711a("version info is not exist");
        }
        return contentValues.getAsInteger("version").intValue();
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: a */
    public boolean mo59047a() {
        m59074z();
        ContentValues contentValues = new ContentValues();
        contentValues.put("version", Integer.valueOf(this.f47080g));
        this.f47076c.m185A("weather_version_info", contentValues);
        return true;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: b */
    public boolean mo59048b() throws Throwable {
        C1119a.m6673c(this.f47075b);
        return true;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: c */
    public int mo59049c() {
        int iM59066o = 0;
        if (C13348q.m80082b(this.f47077d)) {
            return 0;
        }
        Iterator<String> it = this.f47077d.iterator();
        while (it.hasNext()) {
            iM59066o += m59066o(it.next());
        }
        return iM59066o;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: d */
    public boolean mo59050d() {
        m59070u();
        return true;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: e */
    public boolean mo59051e(Handler.Callback callback, Object obj) throws Throwable {
        try {
            C9044c c9044cM6674d = C1119a.m6674d(this.f47075b, m59065w(this.f47076c));
            if (c9044cM6674d != null && c9044cM6674d.m57012a()) {
                this.f47079f = true;
                m59071v();
                return true;
            }
            C2111d.m12653i("WeatherSubImpV2", "info.permit is false");
            this.f47079f = false;
            sendMsg(7, 0, 0, callback, obj);
            return false;
        } catch (C10711a unused) {
            this.f47079f = false;
            C2111d.m12648d("WeatherSubImpV2", "BackupException error.");
            return false;
        } catch (Exception unused2) {
            this.f47079f = false;
            C2111d.m12648d("WeatherSubImpV2", "error.");
            return false;
        }
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: f */
    public int mo59052f() {
        int iM59072x = 0;
        if (!C13348q.m80082b(this.f47077d) && this.f47079f) {
            List<String> listM6672b = C1119a.m6672b(this.f47075b);
            Iterator<String> it = this.f47077d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (C9142g.m57463b() || listM6672b.contains(next)) {
                    iM59072x += m59072x(next);
                } else {
                    C2111d.m12653i("WeatherSubImpV2", "module is not compatible with the uri: " + next);
                }
            }
        }
        return iM59072x;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: g */
    public int mo59053g() {
        int iM59068r = 0;
        if (!C13348q.m80082b(this.f47077d) && !C13348q.m80082b(this.f47078e)) {
            Iterator<String> it = this.f47077d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.f47078e.contains(next)) {
                    iM59068r += m59068r(next);
                }
            }
        }
        return iM59068r;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: h */
    public String mo59054h() {
        StringBuilder sb2 = new StringBuilder();
        int size = this.f47077d.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strM59064t = m59064t(this.f47077d.get(i10));
            if (strM59064t != null) {
                sb2.append(strM59064t);
            }
            if (i10 != size - 1) {
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: i */
    public int mo59055i() {
        m59070u();
        return mo59053g();
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: j */
    public int mo59056j() {
        int length = 0;
        if (!C13348q.m80082b(this.f47077d) && !C13348q.m80082b(this.f47078e)) {
            Iterator<String> it = this.f47077d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.f47078e.contains(next)) {
                    ContentValues[] contentValuesArrM200s = this.f47076c.m200s(m59064t(next), null, null, null, null);
                    if (contentValuesArrM200s != null) {
                        length += contentValuesArrM200s.length;
                    }
                }
            }
        }
        return length;
    }

    /* renamed from: o */
    public final int m59066o(String str) throws Throwable {
        if (this.f47076c != null && str != null && !C13348q.m80082b(this.f47078e)) {
            String strM59064t = m59064t(str);
            HashMap<String, Integer> mapM59067q = m59067q(str);
            C9662e c9662e = new C9662e(C13347p.m80079b(str), null, null, null, null);
            c9662e.m60337g(mapM59067q);
            ContentValues[] backupValues = BackupObject.getBackupValues(this.f47075b, c9662e);
            if (backupValues.length != 0 && strM59064t != null) {
                boolean zContains = this.f47078e.contains(str);
                this.f47076c.mo169a();
                int iM59073y = 0;
                for (ContentValues contentValues : backupValues) {
                    if (BackupObject.isAbort()) {
                        break;
                    }
                    iM59073y += m59073y(zContains, strM59064t, contentValues);
                }
                this.f47076c.mo171c();
                return iM59073y;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[PHI: r1 r8
  0x0064: PHI (r1v4 java.util.HashMap<java.lang.String, java.lang.Integer>) = 
  (r1v3 java.util.HashMap<java.lang.String, java.lang.Integer>)
  (r1v6 java.util.HashMap<java.lang.String, java.lang.Integer>)
 binds: [B:32:0x0062, B:36:0x006e] A[DONT_GENERATE, DONT_INLINE]
  0x0064: PHI (r8v6 android.database.Cursor) = (r8v5 android.database.Cursor), (r8v8 android.database.Cursor) binds: [B:32:0x0062, B:36:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.HashMap<java.lang.String, java.lang.Integer> m59067q(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "WeatherSubImpV2"
            android.content.Context r1 = r8.f47075b
            if (r1 == 0) goto L78
            if (r9 != 0) goto La
            goto L78
        La:
            r8 = 0
            android.net.Uri r2 = p699v4.C13347p.m80079b(r9)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L59 android.database.sqlite.SQLiteException -> L5b
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r9 = com.huawei.android.backup.filelogic.utils.C2108a.m12618d(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L59 android.database.sqlite.SQLiteException -> L5b
            if (r9 == 0) goto L49
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45 android.database.sqlite.SQLiteException -> L47
            if (r1 != 0) goto L20
            goto L49
        L20:
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45 android.database.sqlite.SQLiteException -> L47
            r1.<init>()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45 android.database.sqlite.SQLiteException -> L47
            java.lang.String[] r8 = r9.getColumnNames()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            int r2 = r8.length     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            r3 = 0
        L2b:
            if (r3 >= r2) goto L43
            r4 = r8[r3]     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            int r5 = m59063p()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f android.database.sqlite.SQLiteException -> L41
            int r3 = r3 + 1
            goto L2b
        L3d:
            r8 = move-exception
            goto L72
        L3f:
            r8 = r9
            goto L5d
        L41:
            r8 = r9
            goto L69
        L43:
            r8 = r1
            goto L4e
        L45:
            r1 = r8
            goto L3f
        L47:
            r1 = r8
            goto L41
        L49:
            java.lang.String r1 = "uri is null."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45 android.database.sqlite.SQLiteException -> L47
        L4e:
            if (r9 == 0) goto L71
            r9.close()
            goto L71
        L54:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L72
        L59:
            r1 = r8
            goto L5d
        L5b:
            r1 = r8
            goto L69
        L5d:
            java.lang.String r9 = "getFields Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L54
            if (r8 == 0) goto L67
        L64:
            r8.close()
        L67:
            r8 = r1
            goto L71
        L69:
            java.lang.String r9 = " getFields SQLiteException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L54
            if (r8 == 0) goto L67
            goto L64
        L71:
            return r8
        L72:
            if (r9 == 0) goto L77
            r9.close()
        L77:
            throw r8
        L78:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p249e6.C9418d.m59067q(java.lang.String):java.util.HashMap");
    }

    /* renamed from: r */
    public final int m59068r(String str) {
        Cursor cursorM12618d = null;
        try {
            try {
                cursorM12618d = C2108a.m12618d(this.f47075b, C13347p.m80079b(str), null, null, null, null);
                count = cursorM12618d != null ? cursorM12618d.getCount() : 0;
            } catch (SQLiteException unused) {
                C2111d.m12648d("WeatherSubImpV2", "Get backup numbers SQLiteException");
                if (cursorM12618d != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("WeatherSubImpV2", "Get backup numbers failed");
                if (cursorM12618d != null) {
                }
            }
            return count;
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }

    /* renamed from: s */
    public final int m59069s(ContentProviderClient contentProviderClient, String str, boolean z10, ContentValues contentValues) {
        if (C13333b.m79953a(contentProviderClient, C13347p.m80079b(str), contentValues)) {
            if (z10) {
                m59060n();
                return 1;
            }
        } else if (z10) {
            m59059m();
        }
        return 0;
    }

    /* renamed from: u */
    public final void m59070u() {
        C9042a c9042aM6671a = C1119a.m6671a(this.f47075b);
        if (c9042aM6671a != null) {
            this.f47077d = c9042aM6671a.m57007c();
            this.f47078e = c9042aM6671a.m57006b();
            this.f47080g = c9042aM6671a.m57005a();
        }
    }

    /* renamed from: v */
    public final void m59071v() {
        AbstractC0048c abstractC0048c = this.f47076c;
        if (abstractC0048c == null) {
            return;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("weather_uri_info", null, null, null, null);
        if (contentValuesArrM200s == null) {
            this.f47077d = null;
            this.f47078e = null;
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (ContentValues contentValues : contentValuesArrM200s) {
            if (contentValues != null) {
                String strM57465d = C9142g.m57465d(contentValues.getAsString("value"));
                arrayList.add(strM57465d);
                if (contentValues.getAsBoolean("need_count").booleanValue()) {
                    arrayList2.add(strM57465d);
                }
            }
        }
        this.f47077d = arrayList;
        this.f47078e = arrayList2;
    }

    /* renamed from: x */
    public final int m59072x(String str) {
        boolean z10 = str == null || C13348q.m80082b(this.f47078e);
        if (this.f47075b != null && this.f47076c != null && !z10) {
            boolean zContains = this.f47078e.contains(str);
            String strM59064t = m59064t(str);
            ContentValues[] contentValuesArrM200s = this.f47076c.m200s(strM59064t, null, null, null, null);
            if (contentValuesArrM200s != null && strM59064t != null) {
                ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(this.f47075b, C13347p.m80079b(str));
                try {
                    int iM59069s = 0;
                    for (ContentValues contentValues : contentValuesArrM200s) {
                        if (BackupObject.isAbort()) {
                            break;
                        }
                        iM59069s += m59069s(contentProviderClientM12617c, str, zContains, contentValues);
                    }
                    return iM59069s;
                } finally {
                    if (contentProviderClientM12617c != null) {
                        contentProviderClientM12617c.close();
                    }
                }
            }
            C2111d.m12648d("WeatherSubImpV2", "restore error. because values is null.");
        }
        return 0;
    }

    /* renamed from: y */
    public final int m59073y(boolean z10, String str, ContentValues contentValues) {
        int i10 = 0;
        try {
            if (this.f47076c.m185A(str, contentValues) == 1) {
                if (z10) {
                    m59058l();
                    i10 = 1;
                }
            } else if (z10) {
                m59057k();
            }
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("WeatherSubImpV2", "calendar write events values IllegalArgumentException");
            if (z10) {
                m59057k();
            }
        } catch (Exception unused2) {
            C2111d.m12648d("WeatherSubImpV2", "calendar write events values failed");
            if (z10) {
                m59057k();
            }
        }
        return i10;
    }

    /* renamed from: z */
    public final void m59074z() {
        if (this.f47076c == null || C13348q.m80082b(this.f47077d) || C13348q.m80082b(this.f47078e)) {
            return;
        }
        Iterator<String> it = this.f47077d.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            String next = it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i10));
            contentValues.put("need_count", Boolean.valueOf(this.f47078e.contains(next)));
            contentValues.put("value", C9142g.m57462a(next));
            this.f47076c.m185A("weather_uri_info", contentValues);
            i10++;
        }
    }
}
