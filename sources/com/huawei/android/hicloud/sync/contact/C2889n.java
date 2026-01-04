package com.huawei.android.hicloud.sync.contact;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9722c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.C10812z;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.contact.n */
/* loaded from: classes3.dex */
public class C2889n {
    /* renamed from: A */
    public static void m17633A(ArrayList<String> arrayList, int i10, ArrayList<ContentProviderOperation> arrayList2, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m17658q(arrayList2, str, it.next(), i10);
        }
    }

    /* renamed from: B */
    public static boolean m17634B(Context context, String str, C2882g c2882g) throws C9722c {
        Cursor cursorQuery;
        boolean zEquals = true;
        try {
            cursorQuery = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, C2879d.f12835c, "raw_contact_id=? and mimetype =?", new String[]{String.valueOf(str), "vnd.android.cursor.item/photo"}, "raw_contact_id");
        } catch (Exception e10) {
            C11839m.m70687e("ContactUpadateOperatin", "isNeedDeletePhoto Exception :" + e10.toString());
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            C11839m.m70687e("ContactUpadateOperatin", "isNeedDeletePhoto cursor return null");
            throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactUpadateOperatin isNeedDeletePhoto cursor return null", "addressbook", "local_download_struct");
        }
        if (cursorQuery.moveToFirst()) {
            byte[] blob = cursorQuery.getBlob(cursorQuery.getColumnIndex("data15"));
            byte[] bArrM17541z0 = c2882g.m17541z0();
            if (blob != null && blob.length > 0 && bArrM17541z0.length > 0) {
                zEquals = true ^ Arrays.equals(blob, bArrM17541z0);
            }
        }
        cursorQuery.close();
        return zEquals;
    }

    /* renamed from: C */
    public static void m17635C(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
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
        m17662u(arrayList, str, strArr, strArr2);
    }

    /* renamed from: D */
    public static boolean m17636D(String str, Context context, C2882g c2882g, String str2, String str3) throws C9722c, RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        C11839m.m70688i("ContactUpadateOperatin", "[operationContactUpdate] operationContactUpdata() id: " + str);
        ArrayList arrayList2 = new ArrayList();
        m17656o(context, arrayList2, str);
        if (c2882g == null) {
            C11839m.m70688i("ContactUpadateOperatin", "cf is null");
            return false;
        }
        boolean zM17634B = m17634B(context, str, c2882g);
        arrayList.add(ContentProviderOperation.newUpdate(C2879d.f12834b).withSelection("_id=?", new String[]{str}).withValue("sync1", c2882g.m17418L0()).withValue("account_name", C2880e.m17352a()).withValue("account_type", C2880e.m17353b()).withValue("starred", Integer.valueOf(c2882g.m17406H0())).withValue(C2879d.f12836d, Integer.valueOf(c2882g.m17450W())).build());
        if (zM17634B) {
            arrayList.add(ContentProviderOperation.newDelete(C2879d.f12833a).withSelection("raw_contact_id=?", new String[]{String.valueOf(str)}).build());
        } else {
            arrayList.add(ContentProviderOperation.newDelete(C2879d.f12833a).withSelection("raw_contact_id=? and mimetype != ?", new String[]{String.valueOf(str), "vnd.android.cursor.item/photo"}).build());
        }
        m17635C(arrayList, c2882g, str);
        m17637E(arrayList, c2882g, str);
        m17645d(arrayList, c2882g, str);
        m17642a(arrayList, c2882g, str);
        m17649h(arrayList, str, new String[]{c2882g.m17537y(), c2882g.m17415K0()});
        String strM17512r0 = c2882g.m17512r0();
        if (!C2983l.m17910g(strM17512r0)) {
            m17661t(arrayList, str, strM17512r0);
        }
        m17641I(arrayList, c2882g, str);
        m17667z(arrayList, c2882g, str);
        m17644c(arrayList, c2882g, str);
        m17639G(arrayList, c2882g, str);
        if (!arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                m17657p(arrayList, str, (String) it.next());
            }
        }
        if (zM17634B) {
            m17664w(arrayList, str, c2882g.m17541z0());
        }
        try {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (OperationApplicationException e10) {
            String str4 = "Update contact OperationApplicationException. id = " + str + ", " + e10.getMessage();
            C10812z.m65837f(context, "addressbook", 2264, str4, str2, "local_download_struct", str3);
            C11839m.m70687e("ContactUpadateOperatin", str4);
            return false;
        } catch (Exception e11) {
            String str5 = "Update contact failed. id = " + str + ", " + e11.getMessage();
            C11839m.m70687e("ContactUpadateOperatin", str5);
            throw new C9722c(2264, str5, "addressbook", "local_download_struct");
        }
    }

    /* renamed from: E */
    public static void m17637E(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        m17638F(c2882g.m17385A0(), 12, str, arrayList);
        m17638F(c2882g.m17412J0(), 6, str, arrayList);
        m17638F(c2882g.m17421M0(), 7, str, arrayList);
        m17638F(c2882g.m17498n0(), 20, str, arrayList);
        m17638F(c2882g.m17438S(), 1, str, arrayList);
        m17638F(c2882g.m17439S0(), 3, str, arrayList);
        m17638F(c2882g.m17442T0(), 10, str, arrayList);
        m17638F(c2882g.m17487j0(), 2, str, arrayList);
        m17660s(arrayList, str, c2882g.m17508q0());
        m17638F(c2882g.m17435R(), 0, str, arrayList);
        m17638F(c2882g.m17436R0(), 17, str, arrayList);
        m17638F(c2882g.m17411J(), 13, str, arrayList);
        m17638F(c2882g.m17432Q(), 5, str, arrayList);
        m17638F(c2882g.m17433Q0(), 4, str, arrayList);
        ArrayList<String[]> arrayListM17390C = c2882g.m17390C();
        if (arrayListM17390C == null || arrayListM17390C.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17390C.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17653l(arrayList, str, 0, next[0], next[1]);
        }
    }

    /* renamed from: F */
    public static void m17638F(ArrayList<String> arrayList, int i10, String str, ArrayList<ContentProviderOperation> arrayList2) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m17663v(arrayList2, str, i10, it.next());
        }
    }

    /* renamed from: G */
    public static void m17639G(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        m17640H(arrayList, str, 1, c2882g.m17515s());
        m17640H(arrayList, str, 2, c2882g.m17523u());
        m17640H(arrayList, str, 3, c2882g.m17527v());
        m17640H(arrayList, str, 4, c2882g.m17531w());
        m17640H(arrayList, str, 5, c2882g.m17408I());
        m17640H(arrayList, str, 6, c2882g.m17414K());
        m17640H(arrayList, str, 7, c2882g.m17456Y());
        m17640H(arrayList, str, 8, c2882g.m17495m0());
        m17640H(arrayList, str, 9, c2882g.m17528v0());
        m17640H(arrayList, str, 10, c2882g.m17534x());
        m17640H(arrayList, str, 11, c2882g.m17447V());
        m17640H(arrayList, str, 12, c2882g.m17402G());
        m17640H(arrayList, str, 13, c2882g.m17397E0());
        m17640H(arrayList, str, 14, c2882g.m17403G0());
        ArrayList<String[]> arrayListM17393D = c2882g.m17393D();
        if (arrayListM17393D == null || arrayListM17393D.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17393D.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17665x(arrayList, str, next[1], 0, next[0]);
        }
    }

    /* renamed from: H */
    public static void m17640H(ArrayList<ContentProviderOperation> arrayList, String str, int i10, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        Collections.sort(arrayList2);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            m17665x(arrayList, str, it.next(), i10, null);
        }
    }

    /* renamed from: I */
    public static void m17641I(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        ArrayList<String> arrayListM17424N0 = c2882g.m17424N0();
        if (arrayListM17424N0 != null && arrayListM17424N0.size() > 0) {
            Iterator<String> it = arrayListM17424N0.iterator();
            while (it.hasNext()) {
                m17666y(arrayList, str, 7, it.next());
            }
        }
        ArrayList<String> arrayListM17441T = c2882g.m17441T();
        if (arrayListM17441T != null && arrayListM17441T.size() > 0) {
            Iterator<String> it2 = arrayListM17441T.iterator();
            while (it2.hasNext()) {
                m17666y(arrayList, str, 4, it2.next());
            }
        }
        ArrayList<String> arrayListM17445U0 = c2882g.m17445U0();
        if (arrayListM17445U0 == null || arrayListM17445U0.size() <= 0) {
            return;
        }
        Iterator<String> it3 = arrayListM17445U0.iterator();
        while (it3.hasNext()) {
            m17666y(arrayList, str, 5, it3.next());
        }
    }

    /* renamed from: a */
    public static void m17642a(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        m17643b(c2882g.m17516s0(), 3, arrayList, str);
        m17643b(c2882g.m17426O(), 1, arrayList, str);
        m17643b(c2882g.m17427O0(), 2, arrayList, str);
        ArrayList<Map<String, String[]>> arrayListM17540z = c2882g.m17540z();
        if (arrayListM17540z == null || arrayListM17540z.size() <= 0) {
            return;
        }
        Iterator<Map<String, String[]>> it = arrayListM17540z.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, String[]> entry : it.next().entrySet()) {
                if (!C2879d.m17349f(entry.getValue()) && !C2879d.m17349f(new String[]{entry.getKey()})) {
                    m17650i(arrayList, str, 0, entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m17643b(ArrayList<String[]> arrayList, int i10, ArrayList<ContentProviderOperation> arrayList2, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            m17647f(arrayList2, str, i10, it.next());
        }
    }

    /* renamed from: c */
    public static void m17644c(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        String strM17519t = c2882g.m17519t();
        if (!C2983l.m17910g(strM17519t)) {
            m17648g(arrayList, str, strM17519t);
        }
        String strM17451W0 = c2882g.m17451W0();
        if (!C2983l.m17910g(strM17451W0)) {
            m17659r(arrayList, str, strM17451W0);
        }
        ArrayList<String> arrayListM17503p = c2882g.m17503p();
        if (arrayListM17503p != null && arrayListM17503p.size() > 0) {
            Iterator<String> it = arrayListM17503p.iterator();
            while (it.hasNext()) {
                m17654m(arrayList, str, it.next(), 1, null);
            }
        }
        ArrayList<String> arrayListM17520t0 = c2882g.m17520t0();
        if (arrayListM17520t0 != null && arrayListM17520t0.size() > 0) {
            Iterator<String> it2 = arrayListM17520t0.iterator();
            while (it2.hasNext()) {
                m17654m(arrayList, str, it2.next(), 2, null);
            }
        }
        ArrayList<String[]> arrayListM17384A = c2882g.m17384A();
        if (arrayListM17384A == null || arrayListM17384A.size() <= 0) {
            return;
        }
        Iterator<String[]> it3 = arrayListM17384A.iterator();
        while (it3.hasNext()) {
            String[] next = it3.next();
            m17654m(arrayList, str, next[1], 0, next[0]);
        }
    }

    /* renamed from: d */
    public static void m17645d(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        m17646e(c2882g.m17391C0(), 3, arrayList, str);
        m17646e(c2882g.m17429P(), 1, arrayList, str);
        m17646e(c2882g.m17430P0(), 2, arrayList, str);
        m17646e(c2882g.m17524u0(), 3, arrayList, str);
        ArrayList<String[]> arrayListM17396E = c2882g.m17396E();
        if (arrayListM17396E == null || arrayListM17396E.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17396E.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17651j(arrayList, str, 0, next[0], next[1]);
        }
    }

    /* renamed from: e */
    public static void m17646e(ArrayList<String> arrayList, int i10, ArrayList<ContentProviderOperation> arrayList2, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m17655n(arrayList2, str, i10, it.next());
        }
    }

    /* renamed from: f */
    public static void m17647f(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String[] strArr) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data5", strArr[0]).withValue("data6", strArr[1]).withValue("data4", strArr[2]).withValue("data7", strArr[3]).withValue("data8", strArr[4]).withValue("data9", strArr[5]).withValue("data10", strArr[6]).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: g */
    public static void m17648g(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 3).withValue("data1", str2).build());
    }

    /* renamed from: h */
    public static void m17649h(ArrayList<ContentProviderOperation> arrayList, String str, String[] strArr) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data2", 1).withValue("data1", strArr[0]).withValue("data4", strArr[1]).build());
    }

    /* renamed from: i */
    public static void m17650i(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2, String[] strArr) {
        if (C2879d.m17349f(strArr)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data5", strArr[0]).withValue("data6", strArr[1]).withValue("data4", strArr[2]).withValue("data7", strArr[3]).withValue("data8", strArr[4]).withValue("data9", strArr[5]).withValue("data10", strArr[6]).withValue("data2", Integer.valueOf(i10)).withValue("data3", str2).build());
    }

    /* renamed from: j */
    public static void m17651j(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2, String str3) {
        if (C2983l.m17910g(str3)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", str3).withValue("data2", Integer.valueOf(i10)).withValue("data3", str2).build());
    }

    /* renamed from: k */
    public static void m17652k(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2, String str3) {
        if (C2983l.m17910g(str3)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", str3).withValue("data5", Integer.valueOf(i10)).withValue("data6", str2).build());
    }

    /* renamed from: l */
    public static void m17653l(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2, String str3) {
        if (C2983l.m17910g(str3)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str3).withValue("data2", Integer.valueOf(i10)).withValue("data3", str2).build());
    }

    /* renamed from: m */
    public static void m17654m(ArrayList<ContentProviderOperation> arrayList, String str, String str2, int i10, String str3) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        if (str3 == null) {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", str).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).build());
        } else {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", str).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).withValue("data3", str3).build());
        }
    }

    /* renamed from: n */
    public static void m17655n(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: o */
    public static void m17656o(Context context, List<String> list, String str) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"data1"}, "mimetype=? AND raw_contact_id=?", new String[]{"vnd.android.cursor.item/group_membership", str}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        list.add(cursorQuery.getString(0));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
            C11839m.m70688i("ContactUpadateOperatin", "[operationContactUpdate] update contact's groupId: " + list.toString());
        } catch (Exception e10) {
            C11839m.m70687e("ContactUpadateOperatin", "getGroupIdOfContact Exception:" + e10.toString());
        }
        C11839m.m70688i("ContactUpadateOperatin", "[operationContactUpdate] update contact's groupId: " + list.toString());
    }

    /* renamed from: p */
    public static void m17657p(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/group_membership").withValue("data1", str2).build());
    }

    /* renamed from: q */
    public static void m17658q(ArrayList<ContentProviderOperation> arrayList, String str, String str2, int i10) {
        if (C2983l.m17910g(str2) || i10 < 0) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", str2).withValue("data5", Integer.valueOf(i10)).withValue("data2", 1).build());
    }

    /* renamed from: r */
    public static void m17659r(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 4).withValue("data1", str2).build());
    }

    /* renamed from: s */
    public static void m17660s(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/nickname").withValue("data1", str2).build());
    }

    /* renamed from: t */
    public static void m17661t(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", str2).build());
    }

    /* renamed from: u */
    public static void m17662u(ArrayList<ContentProviderOperation> arrayList, String str, String[] strArr, String[] strArr2) {
        if (C2879d.m17349f(strArr2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", str).withValue("mimetype", "vnd.android.cursor.item/name").withValue(strArr[0], strArr2[0]).withValue(strArr[1], strArr2[1]).withValue(strArr[2], strArr2[2]).withValue(strArr[3], strArr2[3]).withValue(strArr[4], strArr2[4]).withValue(strArr[5], strArr2[5]).withValue(strArr[6], strArr2[6]).withValue(strArr[7], strArr2[7]).build());
    }

    /* renamed from: v */
    public static void m17663v(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: w */
    public static void m17664w(ArrayList<ContentProviderOperation> arrayList, String str, byte[] bArr) {
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", bArr).build());
    }

    /* renamed from: x */
    public static void m17665x(ArrayList<ContentProviderOperation> arrayList, String str, String str2, int i10, String str3) {
        if (C2983l.m17910g(str2) || i10 < 0) {
            return;
        }
        if (str3 == null) {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", str).withValue("mimetype", "vnd.android.cursor.item/relation").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).build());
        } else {
            arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", str).withValue("mimetype", "vnd.android.cursor.item/relation").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).withValue("data3", str3).build());
        }
    }

    /* renamed from: y */
    public static void m17666y(ArrayList<ContentProviderOperation> arrayList, String str, int i10, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(str)).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", str2).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: z */
    public static void m17667z(ArrayList<ContentProviderOperation> arrayList, C2882g c2882g, String str) {
        m17633A(c2882g.m17490k(), 0, arrayList, str);
        m17633A(c2882g.m17444U(), 6, arrayList, str);
        m17633A(c2882g.m17453X(), 7, arrayList, str);
        m17633A(c2882g.m17504p0(), 1, arrayList, str);
        m17633A(c2882g.m17448V0(), 2, arrayList, str);
        m17633A(c2882g.m17394D0(), 4, arrayList, str);
        m17633A(c2882g.m17400F0(), 3, arrayList, str);
        m17633A(c2882g.m17420M(), 5, arrayList, str);
        ArrayList<String[]> arrayListM17387B = c2882g.m17387B();
        if (arrayListM17387B == null || arrayListM17387B.size() <= 0) {
            return;
        }
        Iterator<String[]> it = arrayListM17387B.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            m17652k(arrayList, str, -1, next[0], next[1]);
        }
    }
}
