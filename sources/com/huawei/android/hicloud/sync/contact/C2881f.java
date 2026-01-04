package com.huawei.android.hicloud.sync.contact;

import android.content.ContentProviderOperation;
import android.content.Context;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.contact.f */
/* loaded from: classes3.dex */
public class C2881f {
    /* renamed from: A */
    public static void m17354A(ArrayList<ContentProviderOperation> arrayList, byte[] bArr, int i10) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", bArr).build());
    }

    /* renamed from: B */
    public static void m17355B(ArrayList<ContentProviderOperation> arrayList, String str, int i10, int i11, String str2) {
        if (C2983l.m17910g(str) || i10 < 0) {
            return;
        }
        if (str2 == null) {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/relation").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).build());
        } else {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/relation").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).withValue("data3", str2).build());
        }
    }

    /* renamed from: C */
    public static void m17356C(ArrayList<ContentProviderOperation> arrayList, int i10, String str, int i11) {
        if (C2983l.m17910g(str)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: D */
    public static void m17357D(int i10, ArrayList<ContentProviderOperation> arrayList, Context context, C2882g c2882g) {
        C11839m.m70688i("ContactAddOperation", "[operationContactAdd] ContentProviderOperation size : " + i10);
        String strM17418L0 = c2882g.m17418L0();
        if (C2983l.m17910g(strM17418L0)) {
            strM17418L0 = "";
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12834b).withValue("sync1", strM17418L0).withValue("account_name", C2880e.m17352a()).withValue("account_type", C2880e.m17353b()).withValue("starred", Integer.valueOf(c2882g.m17406H0())).withValue(C2879d.f12836d, Integer.valueOf(c2882g.m17450W())).build());
        m17363f(arrayList, c2882g, i10);
        m17364g(context, arrayList, c2882g, i10);
        String strM17508q0 = c2882g.m17508q0();
        if (!C2983l.m17910g(strM17508q0)) {
            m17380w(arrayList, strM17508q0, i10);
        }
        m17361d(context, arrayList, c2882g, i10);
        m17358a(arrayList, c2882g, i10);
        m17372o(arrayList, new String[]{c2882g.m17537y(), c2882g.m17415K0()}, i10);
        String strM17512r0 = c2882g.m17512r0();
        if (!C2983l.m17910g(strM17512r0)) {
            m17381x(arrayList, strM17512r0, i10);
        }
        m17366i(arrayList, c2882g, i10);
        m17362e(context, arrayList, c2882g, i10);
        m17360c(arrayList, c2882g, i10);
        m17365h(arrayList, c2882g, i10);
        byte[] bArrM17541z0 = c2882g.m17541z0();
        if (bArrM17541z0.length > 0) {
            m17354A(arrayList, bArrM17541z0, i10);
        }
    }

    /* renamed from: a */
    public static void m17358a(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        m17359b(c2882g.m17516s0(), 3, i10, arrayList);
        m17359b(c2882g.m17426O(), 1, i10, arrayList);
        m17359b(c2882g.m17427O0(), 2, i10, arrayList);
        ArrayList<Map<String, String[]>> arrayListM17540z = c2882g.m17540z();
        if (arrayListM17540z == null || arrayListM17540z.size() <= 0) {
            return;
        }
        Iterator<Map<String, String[]>> it = arrayListM17540z.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, String[]> entry : it.next().entrySet()) {
                if (!C2879d.m17349f(entry.getValue()) && !C2879d.m17349f(new String[]{entry.getKey()})) {
                    m17373p(arrayList, 0, entry.getKey(), entry.getValue(), i10);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m17359b(ArrayList<String[]> arrayList, int i10, int i11, ArrayList<ContentProviderOperation> arrayList2) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            m17370m(arrayList2, i10, it.next(), i11);
        }
    }

    /* renamed from: c */
    public static void m17360c(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        String strM17519t = c2882g.m17519t();
        if (!C2983l.m17910g(strM17519t)) {
            m17371n(arrayList, strM17519t, i10);
        }
        String strM17451W0 = c2882g.m17451W0();
        if (!C2983l.m17910g(strM17451W0)) {
            m17379v(arrayList, strM17451W0, i10);
        }
        ArrayList<String> arrayListM17503p = c2882g.m17503p();
        if (arrayListM17503p != null && arrayListM17503p.size() > 0) {
            Iterator<String> it = arrayListM17503p.iterator();
            while (it.hasNext()) {
                m17377t(arrayList, it.next(), 1, i10, null);
            }
        }
        ArrayList<String> arrayListM17520t0 = c2882g.m17520t0();
        if (arrayListM17520t0 != null && arrayListM17520t0.size() > 0) {
            Iterator<String> it2 = arrayListM17520t0.iterator();
            while (it2.hasNext()) {
                m17377t(arrayList, it2.next(), 2, i10, null);
            }
        }
        ArrayList<String[]> arrayListM17384A = c2882g.m17384A();
        if (arrayListM17384A == null || arrayListM17384A.size() <= 0) {
            return;
        }
        Iterator<String[]> it3 = arrayListM17384A.iterator();
        while (it3.hasNext()) {
            String[] next = it3.next();
            m17377t(arrayList, next[1], 0, i10, next[0]);
        }
    }

    /* renamed from: d */
    public static void m17361d(Context context, ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        c2882g.m17475f(arrayList, i10);
        c2882g.m17465b(arrayList, i10);
        c2882g.m17480h(arrayList, i10);
        c2882g.m17472e(arrayList, i10);
        ArrayList<String[]> arrayListM17396E = c2882g.m17396E();
        if (arrayListM17396E == null || arrayListM17396E.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17396E.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17374q(arrayList, 0, next[0], next[1], i10);
        }
    }

    /* renamed from: e */
    public static void m17362e(Context context, ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        m17367j(arrayList, 0, i10, c2882g.m17490k());
        m17367j(arrayList, 6, i10, c2882g.m17444U());
        m17367j(arrayList, 7, i10, c2882g.m17453X());
        m17367j(arrayList, 1, i10, c2882g.m17504p0());
        m17367j(arrayList, 2, i10, c2882g.m17448V0());
        m17367j(arrayList, 4, i10, c2882g.m17394D0());
        m17367j(arrayList, 3, i10, c2882g.m17400F0());
        m17367j(arrayList, 5, i10, c2882g.m17420M());
        ArrayList<String[]> arrayListM17387B = c2882g.m17387B();
        if (arrayListM17387B == null || arrayListM17387B.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17387B.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17375r(arrayList, -1, next[0], next[1], i10);
        }
    }

    /* renamed from: f */
    public static void m17363f(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        String[] strArr = {"data3", "data2", "data5", "data4", "data6", "data7", "data8", "data9"};
        String[] strArr2 = new String[8];
        strArr2[0] = c2882g.m17405H() == null ? "" : c2882g.m17405H();
        strArr2[1] = c2882g.m17417L() == null ? "" : c2882g.m17417L();
        strArr2[2] = c2882g.m17484i0() == null ? "" : c2882g.m17484i0();
        strArr2[3] = c2882g.m17388B0() == null ? "" : c2882g.m17388B0();
        strArr2[4] = c2882g.m17409I0() == null ? "" : c2882g.m17409I0();
        strArr2[5] = c2882g.m17532w0() == null ? "" : c2882g.m17532w0();
        strArr2[6] = c2882g.m17538y0() == null ? "" : c2882g.m17538y0();
        strArr2[7] = c2882g.m17535x0() != null ? c2882g.m17535x0() : "";
        if (C2879d.m17349f(strArr2)) {
            return;
        }
        m17382y(arrayList, strArr, strArr2, i10);
    }

    /* renamed from: g */
    public static void m17364g(Context context, ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        m17368k(context, arrayList, 12, i10, c2882g.m17385A0());
        m17368k(context, arrayList, 6, i10, c2882g.m17412J0());
        m17368k(context, arrayList, 7, i10, c2882g.m17421M0());
        m17368k(context, arrayList, 20, i10, c2882g.m17498n0());
        m17368k(context, arrayList, 1, i10, c2882g.m17438S());
        m17368k(context, arrayList, 3, i10, c2882g.m17439S0());
        m17368k(context, arrayList, 10, i10, c2882g.m17442T0());
        m17368k(context, arrayList, 2, i10, c2882g.m17487j0());
        m17368k(context, arrayList, 1, i10, c2882g.m17435R());
        m17368k(context, arrayList, 17, i10, c2882g.m17436R0());
        m17368k(context, arrayList, 13, i10, c2882g.m17411J());
        m17368k(context, arrayList, 5, i10, c2882g.m17432Q());
        m17368k(context, arrayList, 4, i10, c2882g.m17433Q0());
        ArrayList<String[]> arrayListM17390C = c2882g.m17390C();
        if (arrayListM17390C == null || arrayListM17390C.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17390C.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17376s(arrayList, 0, next[0], next[1], i10);
        }
    }

    /* renamed from: h */
    public static void m17365h(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        m17369l(arrayList, i10, 1, c2882g.m17515s());
        m17369l(arrayList, i10, 2, c2882g.m17523u());
        m17369l(arrayList, i10, 3, c2882g.m17527v());
        m17369l(arrayList, i10, 4, c2882g.m17531w());
        m17369l(arrayList, i10, 5, c2882g.m17408I());
        m17369l(arrayList, i10, 6, c2882g.m17414K());
        m17369l(arrayList, i10, 7, c2882g.m17456Y());
        m17369l(arrayList, i10, 8, c2882g.m17495m0());
        m17369l(arrayList, i10, 9, c2882g.m17528v0());
        m17369l(arrayList, i10, 10, c2882g.m17534x());
        m17369l(arrayList, i10, 11, c2882g.m17447V());
        m17369l(arrayList, i10, 12, c2882g.m17402G());
        m17369l(arrayList, i10, 13, c2882g.m17397E0());
        m17369l(arrayList, i10, 14, c2882g.m17403G0());
        ArrayList<String[]> arrayListM17393D = c2882g.m17393D();
        if (arrayListM17393D == null || arrayListM17393D.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17393D.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17355B(arrayList, next[1], 0, i10, next[0]);
        }
    }

    /* renamed from: i */
    public static void m17366i(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, int i10) {
        ArrayList<String> arrayListM17424N0 = c2882g.m17424N0();
        if (arrayListM17424N0 != null && arrayListM17424N0.size() > 0) {
            Iterator<String> it = arrayListM17424N0.iterator();
            while (it.hasNext()) {
                m17356C(arrayList, 7, it.next(), i10);
            }
        }
        ArrayList<String> arrayListM17441T = c2882g.m17441T();
        if (arrayListM17441T != null && arrayListM17441T.size() > 0) {
            Iterator<String> it2 = arrayListM17441T.iterator();
            while (it2.hasNext()) {
                m17356C(arrayList, 4, it2.next(), i10);
            }
        }
        ArrayList<String> arrayListM17445U0 = c2882g.m17445U0();
        if (arrayListM17445U0 == null || arrayListM17445U0.size() <= 0) {
            return;
        }
        Iterator<String> it3 = arrayListM17445U0.iterator();
        while (it3.hasNext()) {
            m17356C(arrayList, 5, it3.next(), i10);
        }
    }

    /* renamed from: j */
    public static void m17367j(ArrayList<ContentProviderOperation> arrayList, int i10, int i11, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            m17378u(arrayList, it.next(), i10, i11);
        }
    }

    /* renamed from: k */
    public static void m17368k(Context context, ArrayList<ContentProviderOperation> arrayList, int i10, int i11, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            m17383z(arrayList, i10, it.next(), i11);
        }
    }

    /* renamed from: l */
    public static void m17369l(ArrayList<ContentProviderOperation> arrayList, int i10, int i11, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Collections.sort(arrayList2);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            m17355B(arrayList, it.next(), i11, i10, null);
        }
    }

    /* renamed from: m */
    public static void m17370m(ArrayList<ContentProviderOperation> arrayList, int i10, String[] strArr, int i11) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data5", strArr[0]).withValue("data6", strArr[1]).withValue("data4", strArr[2]).withValue("data7", strArr[3]).withValue("data8", strArr[4]).withValue("data9", strArr[5]).withValue("data10", strArr[6]).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: n */
    public static void m17371n(ArrayList<ContentProviderOperation> arrayList, String str, int i10) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 3).withValue("data1", str).build());
    }

    /* renamed from: o */
    public static void m17372o(ArrayList<ContentProviderOperation> arrayList, String[] strArr, int i10) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data2", 1).withValue("data1", strArr[0]).withValue("data4", strArr[1]).build());
    }

    /* renamed from: p */
    public static void m17373p(ArrayList<ContentProviderOperation> arrayList, int i10, String str, String[] strArr, int i11) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data5", strArr[0]).withValue("data6", strArr[1]).withValue("data4", strArr[2]).withValue("data7", strArr[3]).withValue("data8", strArr[4]).withValue("data9", strArr[5]).withValue("data10", strArr[6]).withValue("data2", Integer.valueOf(i10)).withValue("data3", str).build());
    }

    /* renamed from: q */
    public static void m17374q(ArrayList<ContentProviderOperation> arrayList, int i10, String str, String str2, int i11) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).withValue("data3", str).build());
    }

    /* renamed from: r */
    public static void m17375r(ArrayList<ContentProviderOperation> arrayList, int i10, String str, String str2, int i11) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", str2).withValue("data5", Integer.valueOf(i10)).withValue("data6", str).build());
    }

    /* renamed from: s */
    public static void m17376s(ArrayList<ContentProviderOperation> arrayList, int i10, String str, String str2, int i11) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).withValue("data3", str).build());
    }

    /* renamed from: t */
    public static void m17377t(ArrayList<ContentProviderOperation> arrayList, String str, int i10, int i11, String str2) {
        if (C2983l.m17910g(str)) {
            return;
        }
        if (str2 == null) {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).build());
        } else {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).withValue("data3", str2).build());
        }
    }

    /* renamed from: u */
    public static void m17378u(ArrayList<ContentProviderOperation> arrayList, String str, int i10, int i11) {
        if (C2983l.m17910g(str) || i10 < 0) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", str).withValue("data5", Integer.valueOf(i10)).withValue("data2", 1).build());
    }

    /* renamed from: v */
    public static void m17379v(ArrayList<ContentProviderOperation> arrayList, String str, int i10) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 4).withValue("data1", str).build());
    }

    /* renamed from: w */
    public static void m17380w(ArrayList<ContentProviderOperation> arrayList, String str, int i10) {
        if (C2983l.m17910g(str)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/nickname").withValue("data1", str).build());
    }

    /* renamed from: x */
    public static void m17381x(ArrayList<ContentProviderOperation> arrayList, String str, int i10) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", str).build());
    }

    /* renamed from: y */
    public static void m17382y(ArrayList<ContentProviderOperation> arrayList, String[] strArr, String[] strArr2, int i10) {
        if (C2879d.m17349f(strArr2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/name").withValue(strArr[0], strArr2[0]).withValue(strArr[1], strArr2[1]).withValue(strArr[2], strArr2[2]).withValue(strArr[3], strArr2[3]).withValue(strArr[4], strArr2[4]).withValue(strArr[5], strArr2[5]).withValue(strArr[6], strArr2[6]).withValue(strArr[7], strArr2[7]).build());
    }

    /* renamed from: z */
    public static void m17383z(ArrayList<ContentProviderOperation> arrayList, int i10, String str, int i11) {
        if (C2983l.m17910g(str) || i10 == 0) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).build());
    }
}
