package com.huawei.android.hicloud.sync.contact;

import ad.C0100a;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import p015ak.C0209d;
import p015ak.C0227m;
import p514o9.C11839m;
import p517oc.C11848c;

/* renamed from: com.huawei.android.hicloud.sync.contact.k */
/* loaded from: classes3.dex */
public class C2886k {

    /* renamed from: a */
    public static final Uri f12916a = ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build();

    /* renamed from: b */
    public static final String[] f12917b = {"vnd.android.cursor.item/group_membership"};

    /* renamed from: c */
    public static final String[] f12918c = {"data1", "raw_contact_id"};

    /* renamed from: a */
    public static void m17582a(Context context, List<String> list, List<String> list2, String str) throws C9722c {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            C11839m.m70688i("ContactGroup", "[updateContactGroups] newInsert contact to group.");
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf(it.next())).withValue("mimetype", "vnd.android.cursor.item/group_membership").withValue("data1", str).build());
                if (arrayList.size() == 499) {
                    m17584c(context, arrayList);
                }
            }
        }
        if (!list2.isEmpty()) {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(ContentProviderOperation.newDelete(C2879d.f12833a).withSelection("raw_contact_id=? AND mimetype=? AND data1=?", new String[]{it2.next(), "vnd.android.cursor.item/group_membership", str}).build());
                if (arrayList.size() == 499) {
                    m17584c(context, arrayList);
                }
            }
        }
        try {
            if (!arrayList.isEmpty()) {
                m17584c(context, arrayList);
            }
        } finally {
            list.clear();
            list2.clear();
        }
    }

    /* renamed from: b */
    public static String m17583b(ArrayList<String> arrayList) {
        StringBuilder sb2 = new StringBuilder(128);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != size - 1) {
                    sb2.append(arrayList.get(i10));
                    sb2.append(",");
                } else {
                    sb2.append(arrayList.get(i10));
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static void m17584c(Context context, ArrayList<ContentProviderOperation> arrayList) throws C9722c {
        try {
            try {
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            } catch (Exception e10) {
                String str = "batchOprWhenEqualMax applyBatch failed. " + e10.toString();
                C11839m.m70687e("ContactGroup", str);
                throw new C9722c(2264, str, "addressbook", "local_download_struct");
            }
        } finally {
            arrayList.clear();
        }
    }

    /* renamed from: d */
    public static void m17585d(List<String> list, Context context, String str) throws C9722c {
        C11839m.m70688i("ContactGroup", "[updateContactGroups]  Group:" + str + " not have contact.");
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            C11839m.m70688i("ContactGroup", "[updateContactGroups]  newDelete contact to group.");
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ContentProviderOperation.newDelete(C2879d.f12833a).withSelection("raw_contact_id=? AND mimetype=? AND data1=?", new String[]{it.next(), "vnd.android.cursor.item/group_membership", str}).build());
                if (arrayList.size() == 499) {
                    m17584c(context, arrayList);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        m17584c(context, arrayList);
    }

    /* renamed from: e */
    public static void m17586e(HashMap<String, C11848c> map, Context context) throws Throwable {
        C11848c c11848c;
        Cursor cursor = null;
        C2890o c2890oM70942a = null;
        try {
            Uri uri = ContactsContract.Data.CONTENT_URI;
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("ContactGroup", "fillGroup, TargetApp is not SystemApp");
                return;
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, f12918c, "mimetype=?", f12917b, "data1");
            try {
                if (cursorQuery == null) {
                    C11839m.m70687e("ContactGroup", "fillGroup, cursor return null");
                    throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactGroup fillGroup, cursor return null", "addressbook", "local_pre_sync");
                }
                if (cursorQuery.moveToFirst()) {
                    int i10 = -1;
                    while (true) {
                        int i11 = cursorQuery.getInt(0);
                        if (i11 != i10 && (c11848c = map.get(String.valueOf(i11))) != null) {
                            c2890oM70942a = c11848c.m70942a();
                        }
                        if (c2890oM70942a != null) {
                            c2890oM70942a.m17678k(cursorQuery.getString(1));
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        } else {
                            i10 = i11;
                        }
                    }
                    cursorQuery.close();
                }
                cursorQuery.close();
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: f */
    public static HashMap<String, Map<String, C11848c>> m17587f(HashMap<String, C11848c> map) {
        HashMap map2 = new HashMap(1024);
        HashMap map3 = new HashMap(1024);
        HashMap map4 = new HashMap(1024);
        HashMap map5 = new HashMap(1024);
        HashMap<String, Map<String, C11848c>> map6 = new HashMap<>();
        Map<String, C11848c> mapM707g = C0100a.m707g();
        if (mapM707g.size() == 0) {
            m17589h(map, map2);
        } else if (map != null) {
            m17593l(map, map2, map3, map4, map5, mapM707g);
        } else {
            for (Map.Entry<String, C11848c> entry : mapM707g.entrySet()) {
                map4.put(entry.getKey(), entry.getValue());
                C0100a.m717q(entry.getKey(), 1);
            }
        }
        map6.put("0", map2);
        map6.put("1", map3);
        map6.put("2", map4);
        map6.put("3", map5);
        return map6;
    }

    /* renamed from: g */
    public static void m17588g(Context context, Map<String, C11848c> map) throws RemoteException, OperationApplicationException {
        int i10;
        if (context == null || map == null) {
            return;
        }
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            loop0: while (true) {
                i10 = 0;
                for (Map.Entry<String, C11848c> entry : map.entrySet()) {
                    if (entry.getValue().m70943b() == 1) {
                        C11839m.m70688i("ContactGroup", "fixGroupDirty, group id = " + entry.getKey());
                        arrayList.add(ContentProviderOperation.newUpdate(f12916a).withSelection("_id=?", new String[]{entry.getKey()}).withValue("dirty", 0).build());
                        i10++;
                        if (i10 == 100) {
                            break;
                        }
                    }
                }
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
                arrayList.clear();
            }
            if (i10 > 0) {
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
                arrayList.clear();
            }
        } catch (Exception unused) {
            C11839m.m70687e("ContactGroup", "fixGroupDirty Exception");
        }
    }

    /* renamed from: h */
    public static void m17589h(HashMap<String, C11848c> map, Map<String, C11848c> map2) {
        if (map != null) {
            for (Map.Entry<String, C11848c> entry : map.entrySet()) {
                entry.getValue().setHash(C0227m.m1593f(m17592k(entry.getValue().m70942a())));
                map2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: i */
    public static void m17590i(Context context, List<String> list, List<String> list2) throws C9722c {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 != list.size() - 1) {
                sb2.append("'");
                sb2.append(list.get(i10));
                sb2.append("',");
            } else {
                sb2.append("'");
                sb2.append(list.get(i10));
                sb2.append("'");
            }
        }
        String string = sb2.toString();
        C11839m.m70688i("ContactGroup", "[updateContactGroups]  contact's sync1:" + string);
        Cursor cursor = null;
        try {
            Uri uri = ContactsContract.RawContacts.CONTENT_URI;
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("ContactGroup", "getContactIdWithMemid, TargetApp is not SystemApp");
                return;
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_id"}, "sync1 in (" + string + ")", null, null);
            if (cursorQuery == null) {
                C11839m.m70687e("ContactGroup", "getContactIdWithMemid cursor return null");
                throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactGroup getContactIdWithMemid cursor return null", "addressbook", "local_download_struct");
            }
            if (cursorQuery.moveToFirst()) {
                do {
                    list2.add(cursorQuery.getString(0));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: j */
    public static List<String> m17591j(Context context, String str) throws C9722c {
        Uri uri;
        Cursor cursorQuery = null;
        try {
            uri = ContactsContract.Data.CONTENT_URI;
        } catch (Exception e10) {
            C11839m.m70687e("ContactGroup", "getContactWithGroup Exception ：" + e10.toString());
        }
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("ContactGroup", "getContactWithGroup, TargetApp is not SystemApp");
            return null;
        }
        cursorQuery = context.getContentResolver().query(uri, new String[]{"raw_contact_id"}, "mimetype=? AND data1=?", new String[]{"vnd.android.cursor.item/group_membership", str}, null);
        if (cursorQuery == null) {
            C11839m.m70687e("ContactGroup", "getContactWithGroup cursor return null");
            throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactGroup getContactWithGroup cursor return null", "addressbook", "local_download_struct");
        }
        ArrayList arrayList = new ArrayList();
        if (cursorQuery.moveToFirst()) {
            do {
                arrayList.add(cursorQuery.getString(0));
            } while (cursorQuery.moveToNext());
        }
        cursorQuery.close();
        return arrayList;
    }

    /* renamed from: k */
    public static String m17592k(C2890o c2890o) {
        return C2887l.m17601b(c2890o, false);
    }

    /* renamed from: l */
    public static void m17593l(HashMap<String, C11848c> map, Map<String, C11848c> map2, Map<String, C11848c> map3, Map<String, C11848c> map4, Map<String, C11848c> map5, Map<String, C11848c> map6) {
        for (Map.Entry<String, C11848c> entry : map.entrySet()) {
            String key = entry.getKey();
            C11848c value = entry.getValue();
            String strM1593f = C0227m.m1593f(m17592k(value.m70942a()));
            if (map6.containsKey(key)) {
                C11848c c11848c = new C11848c();
                c11848c.setLuid(key);
                c11848c.setUuid(value.getUuid());
                c11848c.m70944c(value.m70942a());
                c11848c.m70945d(value.m70943b());
                c11848c.setGuid(map6.get(key).getGuid());
                c11848c.setHash(strM1593f);
                if (map6.get(key).getHash().equals(strM1593f)) {
                    map5.put(key, c11848c);
                    C0100a.m717q(key, 0);
                } else {
                    map3.put(key, c11848c);
                    C0100a.m717q(key, 2);
                }
            } else {
                value.setHash(strM1593f);
                map2.put(key, value);
            }
        }
        for (Map.Entry<String, C11848c> entry2 : map6.entrySet()) {
            String key2 = entry2.getKey();
            if (!map.containsKey(key2)) {
                map4.put(key2, entry2.getValue());
                C0100a.m717q(key2, 1);
            }
        }
    }

    /* renamed from: m */
    public static String m17594m(C2890o c2890o, String str) {
        ArrayList<String> arrayListM17676i = c2890o.m17676i();
        StringBuilder sb2 = new StringBuilder(128);
        if (arrayListM17676i == null || arrayListM17676i.isEmpty()) {
            C11839m.m70686d("ContactGroup", "[insertContactGroups]  Group:" + str + " not have contact.");
        } else {
            int size = arrayListM17676i.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != arrayListM17676i.size() - 1) {
                    sb2.append("'");
                    sb2.append(arrayListM17676i.get(i10));
                    sb2.append("',");
                } else {
                    sb2.append("'");
                    sb2.append(arrayListM17676i.get(i10));
                    sb2.append("'");
                }
            }
        }
        String string = sb2.toString();
        C11839m.m70688i("ContactGroup", "[insertContactGroups]  contact's sync1:" + string);
        return string;
    }

    /* renamed from: n */
    public static String m17595n() {
        String string = UUID.randomUUID().toString();
        return string.substring(0, 8) + string.substring(9, 13) + string.substring(14, 18) + string.substring(19, 23) + string.substring(24);
    }

    /* renamed from: o */
    public static void m17596o(ArrayList<String> arrayList, Context context, String str) {
        try {
            Uri uri = ContactsContract.RawContacts.CONTENT_URI;
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("ContactGroup", "getrawContactIdList, TargetApp is not SystemApp");
                return;
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_id"}, "sync1 in (" + str + ")", null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorQuery.getString(0));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70687e("ContactGroup", "getrawContactIdList e : " + e10.toString());
        }
    }

    /* renamed from: p */
    public static boolean m17597p(Context context, C2890o c2890o, String str, String str2) throws C9722c {
        if (c2890o == null) {
            return false;
        }
        String strM17671d = c2890o.m17671d();
        if (C2983l.m17910g(strM17671d)) {
            strM17671d = "";
        }
        ContentValues contentValues = new ContentValues();
        String strM17674g = c2890o.m17674g();
        contentValues.put("title", strM17674g != null ? strM17674g : "");
        contentValues.put("sync1", strM17671d);
        contentValues.put("account_name", str);
        contentValues.put("account_type", str2);
        Uri uri = f12916a;
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("ContactGroup", "insertContactGroups, TargetApp is not SystemApp");
            return false;
        }
        Uri uriInsert = context.getContentResolver().insert(uri, contentValues);
        if (uriInsert == null) {
            return false;
        }
        String strValueOf = String.valueOf(ContentUris.parseId(uriInsert));
        C11839m.m70688i("ContactGroup", "[insertContactGroups] insertContactGroups(), m_groupId = " + strValueOf);
        c2890o.m17684q(strValueOf);
        String strM17594m = m17594m(c2890o, strValueOf);
        ArrayList arrayList = new ArrayList();
        m17596o(arrayList, context, strM17594m);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValue("raw_contact_id", String.valueOf((String) it.next())).withValue("mimetype", "vnd.android.cursor.item/group_membership").withValue("data1", strValueOf).build());
            if (arrayList2.size() == 499) {
                m17584c(context, arrayList2);
            }
        }
        if (arrayList2.isEmpty()) {
            return true;
        }
        m17584c(context, arrayList2);
        return true;
    }

    /* renamed from: q */
    public static void m17598q(Context context, C11848c c11848c) throws C9722c {
        Uri uri;
        C2890o c2890oM70942a = c11848c.m70942a();
        if (c2890oM70942a == null) {
            C11839m.m70689w("ContactGroup", "[updateContactGroups] group data is null");
            throw new C9722c(2005, "[updateContactGroups] group data is null", "addressbook", "local_download_struct");
        }
        ContentValues contentValues = new ContentValues();
        String strM17674g = c2890oM70942a.m17674g();
        if (strM17674g == null) {
            strM17674g = "";
        }
        contentValues.put("title", strM17674g);
        contentValues.put("title_res", "");
        String strM17671d = c2890oM70942a.m17671d();
        contentValues.put("sync1", strM17671d != null ? strM17671d : "");
        String luid = c11848c.getLuid();
        try {
            uri = f12916a;
        } catch (Exception e10) {
            C11839m.m70689w("ContactGroup", "[updateContactGroups] e = " + e10.toString());
        }
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("ContactGroup", "updateContactGroups, TargetApp is not SystemApp");
            return;
        }
        context.getContentResolver().update(uri, contentValues, "_id=?", new String[]{luid});
        C11839m.m70688i("ContactGroup", "[updateContactGroups] m_groupId = " + luid);
        List<String> listM17591j = m17591j(context, luid);
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayListM17676i = c2890oM70942a.m17676i();
        if (arrayListM17676i == null || arrayListM17676i.isEmpty()) {
            m17585d(listM17591j, context, luid);
            return;
        }
        m17590i(context, arrayListM17676i, arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (!listM17591j.contains(arrayList.get(i10))) {
                arrayList2.add((String) arrayList.get(i10));
            }
        }
        for (int i11 = 0; i11 < listM17591j.size(); i11++) {
            if (!arrayList.contains(listM17591j.get(i11))) {
                arrayList3.add(listM17591j.get(i11));
            }
        }
        C11839m.m70688i("ContactGroup", "[updateContactGroups]  newList: " + arrayList2.toString() + "; deleteList:" + arrayList3.toString());
        m17582a(context, arrayList2, arrayList3, luid);
    }

    /* renamed from: r */
    public static void m17599r(HashMap<String, String> map, Context context) throws Exception {
        int i10;
        if (map == null || map.size() == 0) {
            C11839m.m70688i("ContactGroup", "[updateSync1] map is null or map size is 0: ");
            return;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>(HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        loop0: while (true) {
            i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(ContentProviderOperation.newUpdate(f12916a).withSelection("_id=?", new String[]{entry.getKey()}).withValue("sync1", entry.getValue()).build());
                i10++;
                if (i10 == 400) {
                    break;
                }
            }
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            arrayList.clear();
        }
        if (i10 > 0) {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            arrayList.clear();
        }
    }
}
