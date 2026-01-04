package p249e6;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p249e6.AbstractC9416b;
import p249e6.C9415a;
import p279f6.C9662e;

/* renamed from: e6.c */
/* loaded from: classes.dex */
public class C9417c extends AbstractC9416b {

    /* renamed from: b */
    public Context f47063b;

    /* renamed from: c */
    public AbstractC0048c f47064c;

    /* renamed from: d */
    public BackupObject.SubKeyInfo[] f47065d;

    /* renamed from: e6.c$a */
    public class a extends AbstractC9416b.a {
        public a(Uri uri, String str, HashMap<String, Integer> map, String str2, C9662e c9662e) {
            super(uri, str, map, str2, c9662e);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[PHI: r8
  0x005c: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:22:0x005a, B:25:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void doEachRestore(android.content.Context r12, p006a5.AbstractC0048c r13, android.os.Handler.Callback r14, java.lang.Object r15) throws java.lang.Throwable {
            /*
                r11 = this;
                java.lang.String r1 = "WeatherSubImpV1"
                if (r12 == 0) goto L72
                if (r13 != 0) goto L8
                goto L72
            L8:
                r8 = 0
                android.content.ContentResolver r2 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L60
                android.net.Uri r9 = p249e6.C9415a.a.f47053a     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L60
                java.lang.String r5 = "city_type = 10 AND home_city = 1"
                r6 = 0
                r7 = 0
                r4 = 0
                r3 = r9
                android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.IllegalArgumentException -> L60
                if (r10 == 0) goto L4d
                java.lang.String r3 = r11.backTable     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                java.lang.String[] r4 = r11.projections     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                java.lang.String r5 = "home_city = 1"
                r6 = 0
                r7 = 0
                r2 = r13
                android.content.ContentValues[] r2 = r2.m200s(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                if (r2 == 0) goto L4d
                android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                r2.<init>()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                r2.clear()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                java.lang.String r3 = "home_city"
                r4 = 0
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                r2.put(r3, r4)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                android.content.ContentResolver r3 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                java.lang.String r4 = "city_type = 10"
                r3.update(r9, r2, r4, r8)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.lang.IllegalArgumentException -> L4b
                goto L4d
            L46:
                r0 = move-exception
                r8 = r10
                goto L6c
            L49:
                r8 = r10
                goto L55
            L4b:
                r8 = r10
                goto L60
            L4d:
                if (r10 == 0) goto L68
                r10.close()
                goto L68
            L53:
                r0 = move-exception
                goto L6c
            L55:
                java.lang.String r2 = "query homecity failed"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L53
                if (r8 == 0) goto L68
            L5c:
                r8.close()
                goto L68
            L60:
                java.lang.String r2 = "query homecity IllegalArgumentException"
                com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r2)     // Catch: java.lang.Throwable -> L53
                if (r8 == 0) goto L68
                goto L5c
            L68:
                super.doEachRestore(r12, r13, r14, r15)
                return
            L6c:
                if (r8 == 0) goto L71
                r8.close()
            L71:
                throw r0
            L72:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p249e6.C9417c.a.doEachRestore(android.content.Context, a5.c, android.os.Handler$Callback, java.lang.Object):void");
        }
    }

    /* renamed from: e6.c$b */
    public class b extends AbstractC9416b.a {
        public b(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            super(uri, str, map, str2);
        }
    }

    /* renamed from: e6.c$c */
    public class c extends AbstractC9416b.a {
        public c(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            super(uri, str, map, str2);
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getEachModuleNumber(Context context) {
            this.selection = "weather_info_id <> " + C9417c.this.m59062p(context);
            return super.getEachModuleNumber(context);
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public boolean initEach(Context context, int i10, AbstractC0048c abstractC0048c) {
            this.selection = "weather_info_id <> " + C9417c.this.m59062p(context);
            return super.initEach(context, i10, abstractC0048c);
        }
    }

    /* renamed from: e6.c$d */
    public class d extends AbstractC9416b.a {
        public d(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            super(uri, str, map, str2);
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public int getEachModuleNumber(Context context) {
            this.selection = "_id <> " + C9417c.this.m59062p(context);
            return super.getEachModuleNumber(context);
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public boolean initEach(Context context, int i10, AbstractC0048c abstractC0048c) {
            this.selection = "_id <> " + C9417c.this.m59062p(context);
            return super.initEach(context, i10, abstractC0048c);
        }
    }

    public C9417c(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c) {
        super(interfaceC2155n);
        b bVar = new b(C9415a.b.f47055a, "settingsInfo_tb", C9415a.b.m59044a(), "settingsInfo");
        d dVar = new d(C9415a.d.f47059a, "weatherInfo_tb", C9415a.d.m59046a(), "weatherInfo");
        Uri uri = C9415a.a.f47053a;
        this.f47065d = new BackupObject.SubKeyInfo[]{bVar, dVar, new a(uri, "cityinfo_tb", C9415a.a.m59043a(), "cityInfo", new C9662e(uri, null, "city_type!=10", null, "_id")), new c(C9415a.c.f47057a, "weatherDayInfo_tb", C9415a.c.m59045a(), "weatherDayInfo")};
        this.f47063b = context;
        this.f47064c = abstractC0048c;
    }

    private boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        int i11 = 0;
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            if (subKeyInfo.initEach(context, i10, abstractC0048c)) {
                i11++;
            } else {
                C2111d.m12648d("WeatherSubImpV1", "Failed at init ");
            }
        }
        return i11 > 0;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: a */
    public boolean mo59047a() {
        return true;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: b */
    public boolean mo59048b() {
        return true;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: c */
    public int mo59049c() {
        int iDoEachBackup = 0;
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            iDoEachBackup += subKeyInfo.doEachBackup(this.f47063b, this.f47064c, null, null);
        }
        return iDoEachBackup;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: d */
    public boolean mo59050d() {
        return init(this.f47063b, 1, null);
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: e */
    public boolean mo59051e(Handler.Callback callback, Object obj) {
        return init(this.f47063b, 2, this.f47064c);
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: f */
    public int mo59052f() {
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            subKeyInfo.doEachDelete(this.f47063b);
        }
        for (BackupObject.SubKeyInfo subKeyInfo2 : this.f47065d) {
            subKeyInfo2.doEachRestore(this.f47063b, this.f47064c, null, null);
        }
        return 0;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: g */
    public int mo59053g() {
        int i10 = 0;
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            int backupCount = subKeyInfo.getBackupCount(this.f47063b);
            if (backupCount >= 0) {
                i10 += backupCount;
            }
        }
        return i10;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: h */
    public String mo59054h() {
        StringBuilder sb2 = new StringBuilder();
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            sb2.append(subKeyInfo.getTable());
            sb2.append(";");
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: i */
    public int mo59055i() {
        int i10 = 0;
        int i11 = 0;
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            int eachModuleNumber = subKeyInfo.getEachModuleNumber(this.f47063b);
            if (eachModuleNumber >= 0) {
                i11 += eachModuleNumber;
            } else {
                i10++;
            }
        }
        if (i10 >= this.f47065d.length) {
            return -1;
        }
        return i11;
    }

    @Override // p249e6.AbstractC9416b
    /* renamed from: j */
    public int mo59056j() {
        int restoreCount = 0;
        for (BackupObject.SubKeyInfo subKeyInfo : this.f47065d) {
            restoreCount += subKeyInfo.getRestoreCount(this.f47064c);
        }
        return restoreCount;
    }

    /* renamed from: p */
    public final int m59062p(Context context) {
        Cursor cursorM12618d = null;
        int i10 = -1;
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, C9415a.a.f47053a, new String[]{"weather_id"}, "city_type = 10", null, null);
                if (cursorM12618d != null) {
                    int columnIndex = cursorM12618d.getColumnIndex("weather_id");
                    cursorM12618d.moveToNext();
                    i10 = cursorM12618d.getInt(columnIndex);
                }
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("WeatherSubImpV1", "buildArgs IllegalArgumentException");
                if (cursorM12618d != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("WeatherSubImpV1", "buildArgs failed");
                if (cursorM12618d != null) {
                }
            }
            return i10;
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }
}
