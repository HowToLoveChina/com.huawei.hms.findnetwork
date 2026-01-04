package com.baidu.location.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p065a.C1534f;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.location.provider.f */
/* loaded from: classes.dex */
public class C1543f {

    /* renamed from: a */
    private static C1543f f6790a;

    /* renamed from: u */
    private C1540c f6810u;

    /* renamed from: b */
    private String f6791b = null;

    /* renamed from: c */
    private boolean f6792c = false;

    /* renamed from: d */
    private boolean f6793d = false;

    /* renamed from: e */
    private boolean f6794e = false;

    /* renamed from: f */
    private String f6795f = null;

    /* renamed from: g */
    private int f6796g = 0;

    /* renamed from: h */
    private double f6797h = 0.0d;

    /* renamed from: i */
    private double f6798i = 0.0d;

    /* renamed from: j */
    private double f6799j = 0.0d;

    /* renamed from: k */
    private double f6800k = 0.0d;

    /* renamed from: l */
    private double f6801l = 0.0d;

    /* renamed from: m */
    private long f6802m = 0;

    /* renamed from: n */
    private boolean f6803n = false;

    /* renamed from: o */
    private volatile boolean f6804o = false;

    /* renamed from: p */
    private final int f6805p = 6;

    /* renamed from: q */
    private final int f6806q = 10000;

    /* renamed from: r */
    private final String f6807r = "bdcltb09";

    /* renamed from: s */
    private final String f6808s = "wof";

    /* renamed from: t */
    private String f6809t = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/ls2.db";

    /* renamed from: v */
    private boolean f6811v = true;

    /* renamed from: com.baidu.location.provider.f$a */
    public class a extends AsyncTask<Boolean, Void, Boolean> {
        private a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Boolean... boolArr) throws SQLException {
            if (boolArr.length != 4) {
                return Boolean.FALSE;
            }
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
            try {
                sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(C1543f.this.f6809t, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabaseOpenOrCreateDatabase == null) {
                return Boolean.FALSE;
            }
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabaseOpenOrCreateDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delete from wof where ac < ");
                    sb2.append(iCurrentTimeMillis - 35);
                    try {
                        sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb2.toString());
                    } catch (Exception e10) {
                        if (C1534f.f6655a) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (boolArr[1].booleanValue()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("delete from bdcltb09 where ac is NULL or ac < ");
                    sb3.append(iCurrentTimeMillis - 130);
                    try {
                        sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb3.toString());
                    } catch (Exception e11) {
                        if (C1534f.f6655a) {
                            e11.printStackTrace();
                        }
                    }
                }
                sQLiteDatabaseOpenOrCreateDatabase.setTransactionSuccessful();
                sQLiteDatabaseOpenOrCreateDatabase.endTransaction();
                sQLiteDatabaseOpenOrCreateDatabase.close();
            } catch (Exception unused2) {
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.baidu.location.provider.f$b */
    public class b extends AsyncTask<Object, Void, Boolean> {
        private b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Object... objArr) {
            if (objArr.length != 4) {
                C1543f.this.f6804o = false;
                return Boolean.FALSE;
            }
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
            try {
                sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(C1543f.this.f6809t, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabaseOpenOrCreateDatabase == null) {
                C1543f.this.f6804o = false;
                return Boolean.FALSE;
            }
            try {
                sQLiteDatabaseOpenOrCreateDatabase.beginTransaction();
                C1543f.this.m8861a((String) objArr[0], (C1538a) objArr[1], sQLiteDatabaseOpenOrCreateDatabase);
                C1543f.this.m8859a((C1544g) objArr[2], (BDLocation) objArr[3], sQLiteDatabaseOpenOrCreateDatabase);
                sQLiteDatabaseOpenOrCreateDatabase.setTransactionSuccessful();
                sQLiteDatabaseOpenOrCreateDatabase.endTransaction();
                sQLiteDatabaseOpenOrCreateDatabase.close();
            } catch (Exception unused2) {
            }
            C1543f.this.f6804o = false;
            return Boolean.TRUE;
        }
    }

    private C1543f(Context context) {
    }

    /* renamed from: c */
    private BDLocation m8866c() {
        return m8872a(true);
    }

    /* renamed from: d */
    private void m8867d() {
        C1538a c1538aM8799e = C1539b.m8784a().m8799e();
        if (c1538aM8799e != null) {
            m8860a(c1538aM8799e.m8774g());
        }
        C1540c c1540c = this.f6810u;
        if (c1540c == null || c1540c.m8821a() == null || this.f6810u.m8821a().getScanResults() == null) {
            return;
        }
        C1534f.m8725c("获取wifi扫描结果：firstLocRequest.getmWifiman().getScanResults().size()：" + this.f6810u.m8821a().getScanResults().size());
        m8862a(this.f6810u.m8821a().getScanResults());
    }

    /* renamed from: e */
    private void m8868e() throws IOException, SQLException {
        try {
            String strM8724c = C1534f.m8724c();
            if (TextUtils.isEmpty(strM8724c)) {
                return;
            }
            File file = new File(strM8724c);
            File file2 = new File(this.f6809t);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                sQLiteDatabaseOpenOrCreateDatabase.setVersion(1);
                sQLiteDatabaseOpenOrCreateDatabase.close();
                C1534f.m8725c("创建了数据库表");
            }
        } catch (Exception e10) {
            C1534f.m8725c(e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8869f() {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.f6809t, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabaseOpenOrCreateDatabase = null;
        }
        if (sQLiteDatabaseOpenOrCreateDatabase == null) {
            return;
        }
        try {
            long jQueryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabaseOpenOrCreateDatabase, "wof");
            long jQueryNumEntries2 = DatabaseUtils.queryNumEntries(sQLiteDatabaseOpenOrCreateDatabase, "bdcltb09");
            boolean z10 = jQueryNumEntries > 10000;
            boolean z11 = jQueryNumEntries2 > 10000;
            if (z10 || z11) {
                new a().execute(Boolean.valueOf(z10), Boolean.valueOf(z11));
            }
            sQLiteDatabaseOpenOrCreateDatabase.close();
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public BDLocation m8870a(C1540c c1540c) {
        this.f6810u = c1540c;
        try {
            m8868e();
        } catch (Exception e10) {
            C1534f.m8725c(e10.getMessage());
        }
        return m8866c();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009d  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m8865b(boolean r10) {
        /*
            r9 = this;
            boolean r0 = r9.f6793d
            r1 = 1
            if (r0 == 0) goto L10
            double r2 = r9.f6800k
            double r4 = r9.f6801l
            r6 = 4642873445846928589(0x406ecccccccccccd, double:246.4)
        Le:
            r9 = r1
            goto L21
        L10:
            boolean r0 = r9.f6792c
            if (r0 == 0) goto L1b
            double r2 = r9.f6797h
            double r4 = r9.f6798i
            double r6 = r9.f6799j
            goto Le
        L1b:
            r2 = 0
            r1 = 0
            r9 = r1
            r4 = r2
            r6 = r4
        L21:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "hasLocal:"
            r0.append(r8)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.location.p065a.C1534f.m8725c(r0)
            java.lang.String r0 = "{\"result\":{\"time\":\""
            if (r1 == 0) goto L9d
            java.lang.String r1 = "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}"
            if (r10 == 0) goto L6c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r10 = com.baidu.location.p065a.C1534f.m8712a()
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.util.Locale r10 = java.util.Locale.CHINA
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r4)
            java.lang.Double r2 = java.lang.Double.valueOf(r6)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1, r2, r3}
            java.lang.String r9 = java.lang.String.format(r10, r9, r0)
            goto Lc8
        L6c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r0 = com.baidu.location.p065a.C1534f.m8712a()
            r10.append(r0)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            java.util.Locale r0 = java.util.Locale.CHINA
            java.lang.Double r1 = java.lang.Double.valueOf(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.Object[] r9 = new java.lang.Object[]{r1, r2, r3, r9}
            java.lang.String r9 = java.lang.String.format(r0, r10, r9)
            goto Lc8
        L9d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            if (r10 == 0) goto Lb8
            r9.<init>()
            r9.append(r0)
            java.lang.String r10 = com.baidu.location.p065a.C1534f.m8712a()
            r9.append(r10)
            java.lang.String r10 = "\",\"error\":\"67\"}}"
        Lb0:
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            goto Lc8
        Lb8:
            r9.<init>()
            r9.append(r0)
            java.lang.String r10 = com.baidu.location.p065a.C1534f.m8712a()
            r9.append(r10)
            java.lang.String r10 = "\",\"error\":\"63\"}}"
            goto Lb0
        Lc8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "res:"
            r10.append(r0)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            com.baidu.location.p065a.C1534f.m8725c(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1543f.m8865b(boolean):java.lang.String");
    }

    /* renamed from: a */
    public BDLocation m8871a(String str, List<ScanResult> list) {
        if (str != null) {
            m8860a(str);
        }
        m8862a(list);
        return new BDLocation(m8865b(true));
    }

    /* renamed from: a */
    public BDLocation m8872a(boolean z10) {
        m8867d();
        return new BDLocation(m8865b(z10));
    }

    /* renamed from: b */
    public void m8875b() {
    }

    /* renamed from: a */
    public static C1543f m8855a(Context context) {
        if (f6790a == null) {
            f6790a = new C1543f(context);
        }
        return f6790a;
    }

    /* renamed from: a */
    public void m8873a() {
        new Thread(new Runnable() { // from class: com.baidu.location.provider.f.1
            @Override // java.lang.Runnable
            public void run() {
                C1543f.this.m8869f();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8859a(C1544g c1544g, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        int i10;
        double d10;
        double d11;
        int i11;
        int i12;
        boolean z10;
        String str;
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && c1544g.f6816a != null) {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            int i13 = 0;
            for (ScanResult scanResult : c1544g.f6816a) {
                if (scanResult.level != 0) {
                    int i14 = i13 + 1;
                    if (i14 > 6) {
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    String strEncode2 = Jni.encode2(scanResult.BSSID.replace(":", ""));
                    try {
                        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + strEncode2 + "\";", null);
                        if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                            d10 = 0.0d;
                            d11 = 0.0d;
                            i11 = 0;
                            i12 = 0;
                            z10 = false;
                        } else {
                            double d12 = cursorRawQuery.getDouble(1) - 113.2349d;
                            double d13 = cursorRawQuery.getDouble(2) - 432.1238d;
                            cursorRawQuery.getInt(3);
                            i11 = cursorRawQuery.getInt(4);
                            i12 = cursorRawQuery.getInt(5);
                            d10 = d12;
                            d11 = d13;
                            z10 = true;
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (Exception e10) {
                        e = e10;
                        i10 = i14;
                    }
                    if (z10) {
                        if (i12 != 0) {
                            float[] fArr = new float[1];
                            Location.distanceBetween(d11, d10, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                            if (fArr[0] > 1500.0f) {
                                int i15 = i12 + 1;
                                if (i15 <= 10 || i15 <= i11 * 3) {
                                    contentValues.put("cc", Integer.valueOf(i15));
                                } else {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", (Integer) 1);
                                    contentValues.put("cc", (Integer) 1);
                                    contentValues.put("ac", Integer.valueOf(iCurrentTimeMillis));
                                }
                                i10 = i14;
                                str = "wof";
                            } else {
                                double d14 = i11;
                                int i16 = i11 + 1;
                                i10 = i14;
                                str = "wof";
                                double d15 = i16;
                                double longitude = ((d10 * d14) + bDLocation.getLongitude()) / d15;
                                double latitude = ((d11 * d14) + bDLocation.getLatitude()) / d15;
                                contentValues.put("mktime", Double.valueOf(longitude + 113.2349d));
                                contentValues.put("time", Double.valueOf(latitude + 432.1238d));
                                contentValues.put("bc", Integer.valueOf(i16));
                                contentValues.put("ac", Integer.valueOf(iCurrentTimeMillis));
                            }
                            try {
                                if (sQLiteDatabase.update(str, contentValues, "id = \"" + strEncode2 + "\"", null) <= 0) {
                                    C1534f.m8725c("update DB fail!");
                                }
                            } catch (Exception e11) {
                                try {
                                    if (C1534f.f6655a) {
                                        e11.printStackTrace();
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    if (C1534f.f6655a) {
                                        e.printStackTrace();
                                    }
                                    i13 = i10;
                                }
                            }
                        }
                        i13 = i10;
                    } else {
                        contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                        contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                        contentValues.put("bc", (Integer) 1);
                        contentValues.put("cc", (Integer) 1);
                        contentValues.put("ac", Integer.valueOf(iCurrentTimeMillis));
                        contentValues.put("id", strEncode2);
                        sQLiteDatabase.insert("wof", null, contentValues);
                    }
                    i10 = i14;
                    i13 = i10;
                }
            }
        }
    }

    /* renamed from: a */
    private void m8860a(String str) {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase;
        if (str == null || str.equals(this.f6791b)) {
            return;
        }
        try {
            sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.f6809t, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabaseOpenOrCreateDatabase = null;
        }
        if (sQLiteDatabaseOpenOrCreateDatabase == null) {
            C1534f.m8725c("db is null...");
            this.f6792c = false;
            return;
        }
        C1534f.m8725c("LOCATING...");
        this.f6792c = false;
        try {
            Cursor cursorRawQuery = sQLiteDatabaseOpenOrCreateDatabase.rawQuery("select * from bdcltb09 where id = \"" + str + "\";", null);
            this.f6791b = str;
            this.f6802m = System.currentTimeMillis();
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    C1534f.m8725c("lookup DB success:" + this.f6791b);
                    this.f6797h = cursorRawQuery.getDouble(1) - 1235.4323d;
                    this.f6799j = cursorRawQuery.getDouble(2) - 4326.0d;
                    this.f6798i = cursorRawQuery.getDouble(3) - 2367.3217d;
                    this.f6792c = true;
                    C1534f.m8725c("lookup DB success:x" + this.f6797h + "y" + this.f6798i + "r" + this.f6799j);
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused2) {
        }
        sQLiteDatabaseOpenOrCreateDatabase.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8861a(String str, C1538a c1538a, SQLiteDatabase sQLiteDatabase) throws JSONException, NumberFormatException {
        double d10;
        if (c1538a != null && c1538a.m8769b()) {
            System.currentTimeMillis();
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            String strM8774g = c1538a.m8774g();
            try {
                C1534f.m8725c("DB:" + str);
                JSONObject jSONObject = new JSONObject(str);
                int i10 = Integer.parseInt(jSONObject.getJSONObject("result").getString(VastAttribute.ERROR));
                double d11 = 0.0d;
                float f10 = 0.0f;
                if (i10 == 161) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    if (jSONObject2.has("point")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                        d11 = Double.parseDouble(jSONObject3.optString(Constants.MULTIPLE_SIGN));
                        d10 = Double.parseDouble(jSONObject3.optString("y"));
                    } else {
                        d10 = 0.0d;
                    }
                    if (jSONObject2.has("radius")) {
                        f10 = Float.parseFloat(jSONObject2.getString("radius"));
                    }
                } else {
                    if (i10 == 167) {
                        sQLiteDatabase.delete("bdcltb09", "id = \"" + strM8774g + "\"", null);
                        return;
                    }
                    d10 = 0.0d;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("time", Double.valueOf(d11 + 1235.4323d));
                contentValues.put("tag", Float.valueOf(f10 + 4326.0f));
                contentValues.put("type", Double.valueOf(d10 + 2367.3217d));
                contentValues.put("ac", Integer.valueOf(iCurrentTimeMillis));
                try {
                    if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + strM8774g + "\"", null) <= 0) {
                        contentValues.put("id", strM8774g);
                        sQLiteDatabase.insert("bdcltb09", null, contentValues);
                        C1534f.m8725c("插入一条基站信息");
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                C1534f.m8725c("DB PARSE:exp!");
                C1534f.m8725c(e11.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void m8874a(String str, C1538a c1538a, C1544g c1544g, BDLocation bDLocation) {
        try {
            m8868e();
        } catch (Exception e10) {
            C1534f.m8725c(e10.getMessage());
        }
        boolean z10 = false;
        boolean z11 = c1538a == null || !c1538a.m8769b();
        if (bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f)) {
            z10 = true;
        }
        if (c1544g.f6816a == null) {
            z10 = true;
        }
        if ((z11 && z10) || this.f6804o) {
            return;
        }
        this.f6804o = true;
        new b().execute(str, c1538a, c1544g, bDLocation);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01c8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m8862a(java.util.List<android.net.wifi.ScanResult> r33) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1543f.m8862a(java.util.List):void");
    }
}
