package com.huawei.android.hicloud.sync.contact;

import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2983l;

/* renamed from: com.huawei.android.hicloud.sync.contact.h */
/* loaded from: classes3.dex */
public class C2883h {
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[Catch: all -> 0x006e, TryCatch #1 {all -> 0x006e, blocks: (B:14:0x004f, B:17:0x0056, B:19:0x005d, B:21:0x006a, B:24:0x0071, B:34:0x008f, B:27:0x0078, B:29:0x007d, B:31:0x0087, B:32:0x008b, B:38:0x0099, B:39:0x00ab), top: B:44:0x004d }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m17543a(java.util.HashMap<java.lang.String, com.huawei.android.hicloud.sync.contact.C2882g> r8, android.content.Context r9, boolean r10) throws java.lang.Throwable {
        /*
            if (r8 != 0) goto L3
            return
        L3:
            r0 = 0
            android.net.Uri r2 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L14
            boolean r1 = p015ak.C0209d.m1227Y1(r9, r2)     // Catch: java.lang.Throwable -> L14
            java.lang.String r7 = "ContactFillpart"
            if (r1 != 0) goto L17
            java.lang.String r8 = "fillContactPart, TargetApp is not SystemApp"
            p514o9.C11839m.m70687e(r7, r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r8 = move-exception
            goto Lac
        L17:
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L14
            java.lang.String[] r3 = com.huawei.android.hicloud.sync.contact.C2879d.f12835c     // Catch: java.lang.Throwable -> L14
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14
            r9.<init>()     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "raw_contact_id in "
            r9.append(r4)     // Catch: java.lang.Throwable -> L14
            java.util.Set r4 = r8.keySet()     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L14
            java.lang.String r5 = "["
            java.lang.String r6 = "("
            java.lang.String r4 = r4.replace(r5, r6)     // Catch: java.lang.Throwable -> L14
            java.lang.String r5 = "]"
            java.lang.String r6 = ")"
            java.lang.String r4 = r4.replace(r5, r6)     // Catch: java.lang.Throwable -> L14
            r9.append(r4)     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = r9.toString()     // Catch: java.lang.Throwable -> L14
            java.lang.String r6 = "raw_contact_id"
            r5 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L14
            if (r9 == 0) goto L99
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L95
            r1 = -1
        L56:
            r2 = 0
            int r3 = r9.getInt(r2)     // Catch: java.lang.Throwable -> L6e
            if (r3 == r1) goto L7b
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r0 = r8.get(r0)     // Catch: java.lang.Throwable -> L6e
            com.huawei.android.hicloud.sync.contact.g r0 = (com.huawei.android.hicloud.sync.contact.C2882g) r0     // Catch: java.lang.Throwable -> L6e
            r4 = 1
            if (r10 == 0) goto L71
            r0.m17529v1(r4)     // Catch: java.lang.Throwable -> L6e
            goto L7b
        L6e:
            r8 = move-exception
            r0 = r9
            goto Lac
        L71:
            boolean r5 = r0.m17457Y0()     // Catch: java.lang.Throwable -> L6e
            if (r5 == 0) goto L78
            goto L8f
        L78:
            r0.m17525u1(r4)     // Catch: java.lang.Throwable -> L6e
        L7b:
            if (r0 == 0) goto L8e
            r0.m17505p1(r2)     // Catch: java.lang.Throwable -> L6e
            r1 = 2
            java.lang.String r1 = r9.getString(r1)     // Catch: java.lang.Throwable -> L6e
            if (r10 == 0) goto L8b
            m17547e(r1, r9, r0)     // Catch: java.lang.Throwable -> L6e
            goto L8e
        L8b:
            m17546d(r1, r9, r0)     // Catch: java.lang.Throwable -> L6e
        L8e:
            r1 = r3
        L8f:
            boolean r2 = r9.moveToNext()     // Catch: java.lang.Throwable -> L6e
            if (r2 != 0) goto L56
        L95:
            r9.close()
            return
        L99:
            java.lang.String r8 = "fillContactPart, cursor return null"
            p514o9.C11839m.m70687e(r7, r8)     // Catch: java.lang.Throwable -> L6e
            fk.c r8 = new fk.c     // Catch: java.lang.Throwable -> L6e
            java.lang.String r10 = "ContactFillpart fillContactPart, cursor return null"
            java.lang.String r0 = "addressbook"
            java.lang.String r1 = "local_pre_sync"
            r2 = 2006(0x7d6, float:2.811E-42)
            r8.<init>(r2, r10, r0, r1)     // Catch: java.lang.Throwable -> L6e
            throw r8     // Catch: java.lang.Throwable -> L6e
        Lac:
            if (r0 == 0) goto Lb1
            r0.close()
        Lb1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.C2883h.m17543a(java.util.HashMap, android.content.Context, boolean):void");
    }

    /* renamed from: b */
    public static void m17544b(Cursor cursor, C2882g c2882g) {
        String[] strArr = new String[7];
        int columnIndex = cursor.getColumnIndex("data10");
        int columnIndex2 = cursor.getColumnIndex("data9");
        int columnIndex3 = cursor.getColumnIndex("data8");
        int columnIndex4 = cursor.getColumnIndex("data7");
        int[] iArr = {cursor.getColumnIndex("data5"), cursor.getColumnIndex("data6"), cursor.getColumnIndex("data4"), columnIndex4, columnIndex3, columnIndex2, columnIndex};
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        for (int i11 = 0; i11 < 7; i11++) {
            strArr[i11] = cursor.getString(iArr[i11]) == null ? "" : cursor.getString(iArr[i11]);
        }
        if (i10 == 0) {
            String string = cursor.getString(cursor.getColumnIndex("data3"));
            if (TextUtils.isEmpty(string)) {
                c2882g.m17542z1(strArr);
                return;
            } else {
                c2882g.m17488j1(string, strArr);
                return;
            }
        }
        if (i10 == 1) {
            c2882g.m17542z1(strArr);
        } else if (i10 == 2) {
            c2882g.m17500n2(strArr);
        } else {
            if (i10 != 3) {
                return;
            }
            c2882g.m17437R1(strArr);
        }
    }

    /* renamed from: c */
    public static void m17545c(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int columnIndex2 = cursor.getColumnIndex("data4");
        String string = cursor.getString(columnIndex);
        if (!TextUtils.isEmpty(string)) {
            c2882g.m17485i1(string);
        }
        String string2 = cursor.getString(columnIndex2);
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        c2882g.m17489j2(string2);
    }

    /* renamed from: d */
    public static void m17546d(String str, Cursor cursor, C2882g c2882g) {
        if ("vnd.android.cursor.item/phone_v2".equals(str)) {
            m17555m(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/name".equals(str) && !c2882g.m17460Z0()) {
            m17552j(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/nickname".equals(str)) {
            m17553k(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/email_v2".equals(str)) {
            m17549g(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/postal-address_v2".equals(str)) {
            m17544b(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/organization".equals(str)) {
            m17545c(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/note".equals(str)) {
            m17554l(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/website".equals(str)) {
            m17563u(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/im".equals(str)) {
            m17550h(cursor, c2882g);
            return;
        }
        if ("vnd.android.cursor.item/contact_event".equals(str)) {
            m17548f(cursor, c2882g);
        } else if ("vnd.android.cursor.item/relation".equals(str)) {
            m17559q(cursor, c2882g);
        } else if ("vnd.android.cursor.item/photo".equals(str)) {
            m17558p(cursor, c2882g);
        }
    }

    /* renamed from: e */
    public static void m17547e(String str, Cursor cursor, C2882g c2882g) {
        if ("vnd.android.cursor.item/name".equals(str)) {
            m17552j(cursor, c2882g);
        }
    }

    /* renamed from: f */
    public static void m17548f(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        String string = cursor.getString(columnIndex);
        if (i10 == 3 && !TextUtils.isEmpty(string)) {
            c2882g.m17470d1(string);
        }
        if (i10 == 4 && !TextUtils.isEmpty(string)) {
            c2882g.m17530v2(string);
        }
        if (i10 == 1 && !TextUtils.isEmpty(string)) {
            c2882g.m17466b1(string);
        }
        if (i10 == 2 && !TextUtils.isEmpty(string)) {
            c2882g.m17440S1(string);
        }
        if (i10 != 0 || TextUtils.isEmpty(string)) {
            return;
        }
        String string2 = cursor.getString(cursor.getColumnIndex("data3"));
        if (TextUtils.isEmpty(string2)) {
            c2882g.m17470d1(string);
        } else {
            c2882g.m17491k1(string2, string);
        }
    }

    /* renamed from: g */
    public static void m17549g(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        String string = cursor.getString(columnIndex);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (i10 == 0) {
            String string2 = cursor.getString(cursor.getColumnIndex("data3"));
            if (C2983l.m17910g(string2)) {
                c2882g.m17386A1(string);
                return;
            } else {
                c2882g.m17501o1(string2, string);
                return;
            }
        }
        if (i10 == 1) {
            c2882g.m17386A1(string);
            return;
        }
        if (i10 == 2) {
            c2882g.m17502o2(string);
        } else if (i10 != 3) {
            c2882g.m17386A1(string);
        } else {
            c2882g.m17443T1(string);
        }
    }

    /* renamed from: h */
    public static void m17550h(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data5"));
        String string = cursor.getString(columnIndex);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        m17551i(c2882g, i10, string);
        if (i10 == -1) {
            String string2 = cursor.getString(cursor.getColumnIndex("data6"));
            if (TextUtils.isEmpty(string2)) {
                c2882g.m17463a1(string);
                return;
            } else {
                c2882g.m17493l1(string2, string);
                return;
            }
        }
        if (i10 == 3) {
            c2882g.m17474e2(string);
        } else {
            if (i10 != 5) {
                return;
            }
            c2882g.m17539y1(string);
        }
    }

    /* renamed from: i */
    public static void m17551i(C2882g c2882g, int i10, String str) {
        if (i10 == 0) {
            c2882g.m17463a1(str);
            return;
        }
        if (i10 == 1) {
            c2882g.m17428O1(str);
            return;
        }
        if (i10 == 2) {
            c2882g.m17526u2(str);
            return;
        }
        if (i10 == 4) {
            c2882g.m17469c2(str);
        } else if (i10 == 6) {
            c2882g.m17401F1(str);
        } else {
            if (i10 != 7) {
                return;
            }
            c2882g.m17410I1(str);
        }
    }

    /* renamed from: j */
    public static void m17552j(Cursor cursor, C2882g c2882g) {
        String string = cursor.getString(cursor.getColumnIndex("data3"));
        if (string == null) {
            string = "";
        }
        c2882g.m17513r1(string);
        String string2 = cursor.getString(cursor.getColumnIndex("data2"));
        if (string2 == null) {
            string2 = "";
        }
        c2882g.m17536x1(string2);
        String string3 = cursor.getString(cursor.getColumnIndex("data5"));
        if (string3 == null) {
            string3 = "";
        }
        c2882g.m17416K1(string3);
        String string4 = cursor.getString(cursor.getColumnIndex("data4"));
        if (string4 == null) {
            string4 = "";
        }
        c2882g.m17464a2(string4);
        String string5 = cursor.getString(cursor.getColumnIndex("data6"));
        if (string5 == null) {
            string5 = "";
        }
        c2882g.m17482h2(string5);
        String string6 = cursor.getString(cursor.getColumnIndex("data9"));
        if (string6 == null) {
            string6 = "";
        }
        c2882g.m17452W1(string6);
        String string7 = cursor.getString(cursor.getColumnIndex("data7"));
        if (string7 == null) {
            string7 = "";
        }
        c2882g.m17449V1(string7);
        String string8 = cursor.getString(cursor.getColumnIndex("data8"));
        c2882g.m17455X1(string8 != null ? string8 : "");
    }

    /* renamed from: k */
    public static void m17553k(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        c2882g.m17431P1(cursor.getString(columnIndex) == null ? "" : cursor.getString(columnIndex));
    }

    /* renamed from: l */
    public static void m17554l(Cursor cursor, C2882g c2882g) {
        String string = cursor.getString(cursor.getColumnIndex("data1"));
        if (TextUtils.isEmpty(string)) {
            return;
        }
        c2882g.m17434Q1(string);
    }

    /* renamed from: m */
    public static void m17555m(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        String string = cursor.getString(columnIndex);
        if (string != null && m17556n(c2882g, i10, string) && m17557o(c2882g, i10, string) && i10 == 0) {
            String string2 = cursor.getString(cursor.getColumnIndex("data3"));
            if (TextUtils.isEmpty(string2)) {
                c2882g.m17419L1(string);
            } else {
                c2882g.m17496m1(string2, string);
            }
        }
    }

    /* renamed from: n */
    public static boolean m17556n(C2882g c2882g, int i10, String str) {
        if (i10 == 1) {
            c2882g.m17395D1(str);
            return false;
        }
        if (i10 == 3) {
            c2882g.m17514r2(str);
            return false;
        }
        if (i10 == 7) {
            c2882g.m17494l2(str);
            return false;
        }
        if (i10 == 10) {
            c2882g.m17518s2(str);
            return false;
        }
        if (i10 == 12) {
            c2882g.m17461Z1(str);
            return false;
        }
        if (i10 != 20) {
            return true;
        }
        c2882g.m17425N1(str);
        return false;
    }

    /* renamed from: o */
    public static boolean m17557o(C2882g c2882g, int i10, String str) {
        if (i10 == 2) {
            c2882g.m17419L1(str);
            return false;
        }
        if (i10 == 13) {
            c2882g.m17521t1(str);
            return false;
        }
        if (i10 == 17) {
            c2882g.m17510q2(str);
            return false;
        }
        if (i10 == 4) {
            c2882g.m17506p2(str);
            return false;
        }
        if (i10 == 5) {
            c2882g.m17389B1(str);
            return false;
        }
        if (i10 != 6) {
            return true;
        }
        c2882g.m17486i2(str);
        return false;
    }

    /* renamed from: p */
    public static void m17558p(Cursor cursor, C2882g c2882g) {
        byte[] blob = cursor.getBlob(cursor.getColumnIndex("data15"));
        if (blob == null || blob.length <= 0) {
            return;
        }
        c2882g.m17458Y1(blob);
    }

    /* renamed from: q */
    public static void m17559q(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        String string = cursor.getString(columnIndex);
        if (m17560r(c2882g, i10, string) && m17561s(c2882g, i10, string)) {
            m17562t(cursor, c2882g, i10, string);
        }
    }

    /* renamed from: r */
    public static boolean m17560r(C2882g c2882g, int i10, String str) {
        if (i10 == 1 && !TextUtils.isEmpty(str)) {
            c2882g.m17468c1(str);
            return false;
        }
        if (i10 == 2 && !TextUtils.isEmpty(str)) {
            c2882g.m17473e1(str);
            return false;
        }
        if (i10 == 3 && !TextUtils.isEmpty(str)) {
            c2882g.m17476f1(str);
            return false;
        }
        if (i10 == 4 && !TextUtils.isEmpty(str)) {
            c2882g.m17478g1(str);
            return false;
        }
        if (i10 != 5 || TextUtils.isEmpty(str)) {
            return true;
        }
        c2882g.m17517s1(str);
        return false;
    }

    /* renamed from: s */
    public static boolean m17561s(C2882g c2882g, int i10, String str) {
        if (i10 == 6 && !TextUtils.isEmpty(str)) {
            c2882g.m17533w1(str);
            return false;
        }
        if (i10 == 7 && !TextUtils.isEmpty(str)) {
            c2882g.m17413J1(str);
            return false;
        }
        if (i10 == 8 && !TextUtils.isEmpty(str)) {
            c2882g.m17422M1(str);
            return false;
        }
        if (i10 == 9 && !TextUtils.isEmpty(str)) {
            c2882g.m17446U1(str);
            return false;
        }
        if (i10 == 10 && !TextUtils.isEmpty(str)) {
            c2882g.m17481h1(str);
            return false;
        }
        if (i10 != 11 || TextUtils.isEmpty(str)) {
            return true;
        }
        c2882g.m17404G1(str);
        return false;
    }

    /* renamed from: t */
    public static void m17562t(Cursor cursor, C2882g c2882g, int i10, String str) {
        if (i10 == 12 && !TextUtils.isEmpty(str)) {
            c2882g.m17509q1(str);
            return;
        }
        if (i10 == 13 && !TextUtils.isEmpty(str)) {
            c2882g.m17471d2(str);
            return;
        }
        if (i10 == 14 && !TextUtils.isEmpty(str)) {
            c2882g.m17477f2(str);
            return;
        }
        if (i10 != 0 || TextUtils.isEmpty(str)) {
            return;
        }
        String string = cursor.getString(cursor.getColumnIndex("data3"));
        if (TextUtils.isEmpty(string)) {
            c2882g.m17468c1(str);
        } else {
            c2882g.m17499n1(string, str);
        }
    }

    /* renamed from: u */
    public static void m17563u(Cursor cursor, C2882g c2882g) {
        int columnIndex = cursor.getColumnIndex("data1");
        int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
        String string = cursor.getString(columnIndex);
        if (TextUtils.isEmpty(string)) {
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 7:
                c2882g.m17497m2(string);
                break;
            case 4:
                c2882g.m17398E1(string);
                break;
            case 5:
                c2882g.m17522t2(string);
                break;
        }
    }
}
