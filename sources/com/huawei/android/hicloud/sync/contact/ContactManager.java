package com.huawei.android.hicloud.sync.contact;

import ad.C0100a;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0227m;
import p015ak.C0241z;
import p514o9.C11839m;
import p517oc.C11847b;
import p517oc.C11848c;

/* loaded from: classes3.dex */
public class ContactManager {

    /* renamed from: r */
    public static final String[] f12733r = {"Phone", "com.android.huawei.phone"};

    /* renamed from: s */
    public static final String[] f12734s = {"_id", "title", "sync1", "group_is_read_only", "version", "dirty"};

    /* renamed from: t */
    public static final String f12735t = "(dirty=1 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (dirty=1 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (dirty=1 AND account_name IS NULL AND account_type IS NULL AND _id in (select raw_contact_id from data))";

    /* renamed from: u */
    public static final String f12736u = "(dirty=1 AND account_name=? AND account_type=?)OR (dirty=1 AND account_name=? AND account_type=?) OR (dirty=1 AND account_name IS NULL AND account_type IS NULL )";

    /* renamed from: a */
    public ContentResolver f12737a;

    /* renamed from: b */
    public Context f12738b;

    /* renamed from: c */
    public HashMap<String, String> f12739c;

    /* renamed from: d */
    public HashMap<String, String> f12740d;

    /* renamed from: e */
    public HashMap<String, Map<String, C11847b>> f12741e;

    /* renamed from: f */
    public HashMap<String, Map<String, C11848c>> f12742f;

    /* renamed from: g */
    public int f12743g;

    /* renamed from: h */
    public int f12744h;

    /* renamed from: i */
    public int f12745i;

    /* renamed from: j */
    public int f12746j;

    /* renamed from: k */
    public int f12747k;

    /* renamed from: l */
    public int f12748l;

    /* renamed from: m */
    public int f12749m;

    /* renamed from: n */
    public int f12750n;

    /* renamed from: o */
    public int f12751o;

    /* renamed from: p */
    public String f12752p;

    /* renamed from: q */
    public String f12753q;

    public ContactManager(Context context) {
        this.f12739c = null;
        this.f12740d = null;
        this.f12741e = null;
        this.f12742f = null;
        this.f12743g = 0;
        this.f12744h = 0;
        this.f12745i = 0;
        this.f12746j = 0;
        this.f12747k = 0;
        this.f12748l = 0;
        this.f12749m = 0;
        this.f12750n = 0;
        this.f12752p = "";
        this.f12753q = "";
        this.f12738b = context;
        this.f12737a = context.getContentResolver();
    }

    /* renamed from: A */
    public int m17198A() {
        return this.f12750n;
    }

    /* renamed from: B */
    public int m17199B() {
        return this.f12747k;
    }

    /* renamed from: C */
    public Map<String, C11847b> m17200C() throws C9722c {
        if (this.f12741e == null) {
            m17234p();
        }
        Map<String, C11847b> map = this.f12741e.get("0");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local added contact size = " + map.size());
        return map;
    }

    /* renamed from: D */
    public Map<String, C11848c> m17201D() throws C9722c {
        if (this.f12742f == null) {
            m17234p();
        }
        Map<String, C11848c> map = this.f12742f.get("0");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local added group size = " + map.size());
        return map;
    }

    /* renamed from: E */
    public Map<String, C11847b> m17202E() throws C9722c {
        if (this.f12741e == null) {
            m17234p();
        }
        Map<String, C11847b> map = this.f12741e.get("3");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local unchanged contact size = " + map.size());
        return map;
    }

    /* renamed from: F */
    public Map<String, C11848c> m17203F() throws C9722c {
        if (this.f12742f == null) {
            m17234p();
        }
        Map<String, C11848c> map = this.f12742f.get("3");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local unchanged group size = " + map.size());
        return map;
    }

    /* renamed from: G */
    public final int m17204G(Cursor cursor) {
        if (!"sync4".equals(C2879d.m17347d())) {
            return cursor.getInt(cursor.getColumnIndex("is_private"));
        }
        String string = cursor.getString(cursor.getColumnIndex("sync4"));
        if ("0".equals(string) || "1".equals(string)) {
            return C0241z.m1685c(string);
        }
        return 0;
    }

    /* renamed from: H */
    public int m17205H() {
        int i10;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = this.f12737a.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "deleted!=?", new String[]{"1"}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -1;
                }
                int count = cursorQuery.getCount();
                cursorQuery.close();
                int iM17232n = m17232n();
                if (iM17232n != -2 && (i10 = count - iM17232n) >= 0) {
                    return i10;
                }
                return -1;
            } catch (Exception e10) {
                C11839m.m70687e("ContactManager", "Exception occur = " + e10.toString());
                if (0 != 0) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: I */
    public final String m17206I(List<String> list, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("account_type");
        sb2.append("='");
        sb2.append(C2880e.m17353b());
        sb2.append("'");
        sb2.append(" AND ");
        sb2.append("_id");
        sb2.append(" IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 != list.size() - 1) {
                sb2.append("?,");
            } else {
                sb2.append(Constants.QUESTION_STR);
            }
        }
        sb2.append(")");
        if (z10) {
            sb2.append(" AND ");
            sb2.append("dirty");
            sb2.append("=");
            sb2.append("0");
        }
        return sb2.toString();
    }

    /* renamed from: J */
    public Map<String, C11847b> m17207J() throws C9722c {
        if (this.f12741e == null) {
            m17234p();
        }
        Map<String, C11847b> map = this.f12741e.get("1");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local modified contact size = " + map.size());
        return map;
    }

    /* renamed from: K */
    public Map<String, C11848c> m17208K() throws C9722c {
        if (this.f12742f == null) {
            m17234p();
        }
        Map<String, C11848c> map = this.f12742f.get("1");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local modified group size = " + map.size());
        return map;
    }

    /* renamed from: L */
    public final void m17209L() {
        String[] strArr = {"_id", "group_is_read_only", "version"};
        String[] strArr2 = f12733r;
        String[] strArr3 = {strArr2[0], strArr2[1]};
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f12737a.query(ContactsContract.Groups.CONTENT_URI, strArr, "(deleted=0 AND account_name=? AND account_type=?) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL )", strArr3, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    String strValueOf = String.valueOf(cursorQuery.getInt(0));
                    int i10 = cursorQuery.getInt(1);
                    int i11 = cursorQuery.getInt(2);
                    if (i10 != 1) {
                        C0100a.m715o(strValueOf, i11);
                    }
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: M */
    public boolean m17210M() {
        boolean z10 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f12737a.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, f12735t, f12733r, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    C11839m.m70688i("ContactManager", "isContactChange Observer get the data change");
                    z10 = true;
                }
            } catch (Exception e10) {
                C11839m.m70688i("ContactManager", "isContactChange query RawContacts table error" + e10.toString());
                if (cursorQuery != null) {
                }
            }
            return z10;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: N */
    public boolean m17211N() {
        boolean z10 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f12737a.query(ContactsContract.Groups.CONTENT_URI, new String[]{"_id"}, f12736u, f12733r, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    C11839m.m70688i("ContactManager", "Observer get the data change");
                    z10 = true;
                }
            } catch (Exception e10) {
                C11839m.m70688i("ContactManager", "query RawContacts table error" + e10.toString());
                if (cursorQuery != null) {
                }
            }
            return z10;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m17212O() throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.String r0 = "_id"
            r1 = 2
            r2 = 0
            r3 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.lang.String[] r4 = com.huawei.android.hicloud.sync.contact.ContactManager.f12733r     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r1[r2] = r5     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r10 = 1
            r4 = r4[r10]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r1[r10] = r4     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            android.content.ContentResolver r4 = r12.f12737a     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            android.net.Uri r5 = android.provider.ContactsContract.RawContacts.CONTENT_URI     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r6[r2] = r0     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.lang.String r7 = "(deleted=0 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL AND _id in (select raw_contact_id from data))"
            r9 = 0
            r8 = r1
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            android.content.ContentResolver r4 = r12.f12737a     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            android.net.Uri r5 = android.provider.ContactsContract.Groups.CONTENT_URI     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            r6[r2] = r0     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            java.lang.String r7 = "(deleted=0 AND account_name=? AND account_type=?) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL )"
            r9 = 0
            r8 = r1
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            if (r11 != 0) goto L3f
            if (r11 == 0) goto L39
            r11.close()
        L39:
            if (r3 == 0) goto L3e
            r3.close()
        L3e:
            return r2
        L3f:
            if (r3 != 0) goto L4a
            r11.close()
            if (r3 == 0) goto L49
            r3.close()
        L49:
            return r2
        L4a:
            int r12 = r11.getCount()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            int r0 = r3.getCount()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            int r12 = r12 + r0
            r11.close()
            r3.close()
            if (r12 <= 0) goto L5c
            r2 = r10
        L5c:
            return r2
        L5d:
            r12 = move-exception
            r0 = r3
            r3 = r11
            goto L90
        L61:
            r12 = move-exception
            r0 = r3
            r3 = r11
            goto L6a
        L65:
            r12 = move-exception
            r0 = r3
            goto L90
        L68:
            r12 = move-exception
            r0 = r3
        L6a:
            java.lang.String r1 = "ContactManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r4.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r5 = "[getAllContactNum] catch exception: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L8f
            r4.append(r12)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r12 = r4.toString()     // Catch: java.lang.Throwable -> L8f
            p514o9.C11839m.m70687e(r1, r12)     // Catch: java.lang.Throwable -> L8f
            if (r3 == 0) goto L89
            r3.close()
        L89:
            if (r0 == 0) goto L8e
            r0.close()
        L8e:
            return r2
        L8f:
            r12 = move-exception
        L90:
            if (r3 == 0) goto L95
            r3.close()
        L95:
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.contact.ContactManager.m17212O():boolean");
    }

    /* renamed from: P */
    public final void m17213P(HashMap<String, C11847b> map, HashMap<String, C11848c> map2) {
        if (map != null) {
            Iterator<Map.Entry<String, C11848c>> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                C2890o c2890oM70942a = it.next().getValue().m70942a();
                ArrayList<String> arrayListM17670c = c2890oM70942a.m17670c();
                if (arrayListM17670c != null) {
                    Iterator<String> it2 = arrayListM17670c.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        C11847b c11847b = map.get(next);
                        C2882g c2882gM70940a = c11847b != null ? c11847b.m70940a() : null;
                        if (c2882gM70940a != null) {
                            c2890oM70942a.m17687t(c2882gM70940a.m17418L0());
                            c2890oM70942a.m17683p(next);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: Q */
    public void m17214Q(int i10) {
        this.f12751o = i10;
    }

    /* renamed from: R */
    public List<C11847b> m17215R(List<C11847b> list) throws C9722c {
        ArrayList arrayList = new ArrayList();
        for (C11847b c11847b : list) {
            if (C2889n.m17636D(c11847b.getLuid(), this.f12738b, c11847b.m70940a(), this.f12752p, this.f12753q)) {
                arrayList.add(c11847b);
            }
        }
        return arrayList;
    }

    /* renamed from: S */
    public void m17216S(List<C11847b> list) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Iterator<C11847b> it = list.iterator();
        while (it.hasNext()) {
            String luid = it.next().getLuid();
            arrayList.add(ContentProviderOperation.newUpdate(C2879d.f12834b.buildUpon().appendPath(luid).build()).withValue("dirty", 0).withSelection("version<= " + C0100a.m703c(luid), null).build());
            if (499 == arrayList.size()) {
                m17223e(arrayList);
                arrayList.clear();
            }
        }
        if (arrayList.size() > 0) {
            m17223e(arrayList);
            arrayList.clear();
        }
    }

    /* renamed from: T */
    public void m17217T(List<C11848c> list) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Iterator<C11848c> it = list.iterator();
        while (it.hasNext()) {
            String luid = it.next().getLuid();
            arrayList.add(ContentProviderOperation.newUpdate(C2886k.f12916a.buildUpon().appendPath(luid).build()).withValue("dirty", 0).withSelection("version<= " + C0100a.m705e(luid), null).build());
            if (499 == arrayList.size()) {
                m17223e(arrayList);
                arrayList.clear();
            }
        }
        if (arrayList.size() > 0) {
            m17223e(arrayList);
            arrayList.clear();
        }
    }

    /* renamed from: U */
    public List<C11848c> m17218U(List<C11848c> list) throws C9722c {
        C11848c next;
        C2890o c2890oM70942a;
        ArrayList arrayList = new ArrayList();
        Iterator<C11848c> it = list.iterator();
        while (it.hasNext() && (c2890oM70942a = (next = it.next()).m70942a()) != null) {
            next.setHash(C0227m.m1593f(C2886k.m17592k(c2890oM70942a)));
            C2886k.m17598q(this.f12738b, next);
            arrayList.add(next);
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m17219a(List<C11847b> list, ArrayList<ContentProviderOperation> arrayList, ArrayList<Integer> arrayList2, HashMap<Integer, C11847b> map) throws Exception {
        ContentProviderResult[] contentProviderResultArrApplyBatch = this.f12738b.getContentResolver().applyBatch("com.android.contacts", arrayList);
        Iterator<Integer> it = arrayList2.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            String strValueOf = String.valueOf(Long.valueOf(ContentUris.parseId(contentProviderResultArrApplyBatch[next.intValue()].uri)));
            C11847b c11847b = map.get(next);
            c11847b.setLuid(strValueOf);
            list.add(c11847b);
        }
    }

    /* renamed from: b */
    public List<C11847b> m17220b(List<C11847b> list) throws C9722c {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        HashMap<Integer, C11847b> map = new HashMap<>();
        List<C11847b> arrayList3 = new ArrayList<>();
        C11839m.m70688i("ContactManager", "add addBatchContact and listItem count = " + list.size());
        if (list.size() <= 0) {
            return arrayList3;
        }
        int i10 = 0;
        while (i10 < list.size()) {
            try {
                try {
                    int size = arrayList.size();
                    ArrayList arrayList4 = new ArrayList();
                    C2881f.m17357D(size, arrayList4, this.f12738b, list.get(i10).m70940a());
                    if (arrayList4.size() > 499) {
                        C11839m.m70687e("ContactManager", "addBatchContact error: too many data in one raw contact, skip.");
                        arrayList4.clear();
                    } else {
                        C11839m.m70688i("ContactManager", "add addBatchContact and batchOperation size = " + arrayList.size());
                        if (arrayList4.size() + arrayList.size() > 499) {
                            m17219a(arrayList3, arrayList, arrayList2, map);
                            arrayList4.clear();
                            arrayList.clear();
                            arrayList2.clear();
                            map.clear();
                        } else {
                            arrayList2.add(Integer.valueOf(size));
                            map.put(Integer.valueOf(size), list.get(i10));
                            arrayList.addAll(arrayList4);
                            arrayList4.clear();
                        }
                    }
                    i10++;
                } catch (OperationApplicationException e10) {
                    C11839m.m70687e("ContactManager", "addBatchContact error: " + e10.toString());
                } catch (Exception e11) {
                    C11839m.m70687e("ContactManager", "addBatchContact " + e11.getMessage());
                    throw new C9722c(2264, "ContactManager batch operationContactAdd() error " + e11.getMessage(), "addressbook", "local_download_struct");
                }
            } catch (Throwable th2) {
                arrayList.clear();
                arrayList2.clear();
                map.clear();
                throw th2;
            }
        }
        C11839m.m70688i("ContactManager", "add addBatchContact and batchOperation size = " + arrayList.size());
        if (arrayList.size() > 0) {
            m17219a(arrayList3, arrayList, arrayList2, map);
        }
        C11839m.m70688i("ContactManager", "addBatchContact addResult size =" + arrayList3.size());
        arrayList.clear();
        arrayList2.clear();
        map.clear();
        return arrayList3;
    }

    /* renamed from: c */
    public final boolean m17221c(C11848c c11848c, String str, String str2) throws C9722c {
        C2890o c2890oM70942a = c11848c.m70942a();
        if (c2890oM70942a == null || !C2886k.m17597p(this.f12738b, c2890oM70942a, str, str2)) {
            return false;
        }
        c11848c.setLuid(c2890oM70942a.m17673f());
        c11848c.setHash(C0227m.m1593f(C2886k.m17592k(c2890oM70942a)));
        return true;
    }

    /* renamed from: d */
    public List<C11848c> m17222d(List<C11848c> list) throws C9722c {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (C11848c c11848c : list) {
                if (m17221c(c11848c, C2880e.m17352a(), C2880e.m17353b())) {
                    arrayList.add(c11848c);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final void m17223e(ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        try {
            this.f12737a.applyBatch("com.android.contacts", arrayList);
        } catch (OperationApplicationException | RemoteException unused) {
            C11839m.m70687e("ContactManager", "applyBath RemoteException or OperationApplicationException");
        } catch (Exception unused2) {
            C11839m.m70687e("ContactManager", "applyBath Exception");
        }
    }

    /* renamed from: f */
    public void m17224f() {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f12737a.query(ContactsContract.RawContacts.CONTENT_URI, null, null, null, null);
            } catch (Exception e10) {
                C11839m.m70687e("ContactManager", "[contactIsSupportIsPrivate] catch exception: " + e10.toString());
                if (0 == 0) {
                    return;
                }
            }
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            for (String str : cursorQuery.getColumnNames()) {
                if ("is_private".equals(str)) {
                    C2879d.m17350g("is_private");
                }
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: g */
    public void m17225g() {
        ContentResolver contentResolver = this.f12738b.getContentResolver();
        String[] strArr = f12733r;
        String[] strArr2 = {strArr[0], strArr[1]};
        C11839m.m70688i("ContactManager", "Deleted contact number: " + contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build(), "(deleted=1 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (deleted=1 AND account_name IS NULL AND account_type IS NULL AND _id in (select raw_contact_id from data))", strArr2));
        C11839m.m70688i("ContactManager", "Deleted group number: " + contentResolver.delete(ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build(), "(deleted=1 AND account_name=? AND account_type=?) OR (deleted=1 AND account_name IS NULL AND account_type IS NULL )", strArr2));
    }

    /* renamed from: h */
    public void m17226h(List<String> list, boolean z10, String str) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("ContactManager", "deleteBatchContacts: deleteList not have data");
            return;
        }
        C11839m.m70688i("ContactManager", "deleteBatchContacts: delete contact start, isSelectDirty = " + z10);
        Uri uriBuild = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build();
        C11839m.m70688i("ContactManager", "deleteBatchContacts: delete contact end size " + this.f12737a.delete(uriBuild.buildUpon().appendQueryParameter(Constants.CONTENT_SERVER_REALM, str).build(), m17206I(list, z10), (String[]) list.toArray(new String[0])));
    }

    /* renamed from: i */
    public final void m17227i(String str) {
        String strReplaceAll = str.replaceAll(CloudBackupConstant.UserPackageInfo.GOLD_MEMBER, "");
        Uri.Builder builderAppendQueryParameter = ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1");
        builderAppendQueryParameter.appendEncodedPath(strReplaceAll);
        C11839m.m70686d("ContactManager", "[deleteContactGroups]  groupId = " + strReplaceAll);
        if (this.f12737a.delete(builderAppendQueryParameter.build(), "", null) <= 0) {
            C11839m.m70688i("ContactManager", "[deleteContactGroups] delete groups   error. id:" + str);
        }
    }

    /* renamed from: j */
    public void m17228j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70688i("ContactManager", "deleteGroupInfo group size=" + list.size());
        for (String str : list) {
            if (!str.contains("G1")) {
                m17227i(str);
            }
        }
    }

    /* renamed from: k */
    public void m17229k() {
        this.f12738b = null;
        this.f12737a = null;
    }

    /* renamed from: l */
    public void m17230l(Map<String, C11847b> map, boolean z10) throws Throwable {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, C11847b> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue().m70940a());
        }
        C2883h.m17543a(map2, this.f12738b, z10);
        map2.clear();
    }

    /* renamed from: m */
    public void m17231m(List<C11847b> list) throws Throwable {
        HashMap map = new HashMap();
        for (C11847b c11847b : list) {
            map.put(c11847b.getLuid(), c11847b.m70940a());
        }
        C2883h.m17543a(map, this.f12738b, false);
        map.clear();
    }

    /* renamed from: n */
    public int m17232n() {
        Cursor cursor = null;
        try {
            try {
                String[] strArr = f12733r;
                Cursor cursorQuery = this.f12737a.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "(deleted=0 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL AND _id in (select raw_contact_id from data))", new String[]{strArr[0], strArr[1]}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -2;
                }
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            } catch (Exception e10) {
                C11839m.m70687e("ContactManager", "[getAllContactNum] catch exception: " + e10.toString());
                if (0 != 0) {
                    cursor.close();
                }
                return -2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: o */
    public final HashMap<String, C11847b> m17233o(Cursor cursor, int i10) throws C9722c {
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        C11839m.m70688i("ContactManager", "[getChangedContact] Retrieving all items, Contacts size:" + i10);
        HashMap<String, C11847b> map = new HashMap<>(1024);
        for (int i11 = 0; i11 < i10; i11++) {
            String strValueOf = String.valueOf(cursor.getInt(0));
            String string = cursor.getString(1);
            String string2 = cursor.getString(2);
            int i12 = cursor.getInt(3);
            int i13 = cursor.getInt(4);
            if (C2983l.m17910g(string2) || string2.length() > 64) {
                string2 = C2879d.m17348e();
                if (this.f12739c == null) {
                    this.f12739c = new HashMap<>(1024);
                }
                this.f12739c.put(strValueOf, string2);
            }
            C11847b c11847b = new C11847b();
            c11847b.setLuid(strValueOf);
            C2882g c2882g = new C2882g(strValueOf, string, string2, i13);
            int i14 = cursor.getInt(cursor.getColumnIndex("starred"));
            int iM17204G = m17204G(cursor);
            c2882g.m17479g2(i14);
            c2882g.m17407H1(iM17204G);
            c11847b.m70941b(c2882g);
            c11847b.setUuid(string2);
            map.put(strValueOf, c11847b);
            C0100a.m714n(strValueOf, i12);
            cursor.moveToNext();
        }
        try {
            C2879d.m17351h(this.f12739c, this.f12738b);
            HashMap<String, String> map2 = this.f12739c;
            if (map2 == null) {
                return map;
            }
            map2.clear();
            return map;
        } catch (Exception e10) {
            C11839m.m70689w("ContactManager", "[getChangedContact] update contact sync1 error:" + e10.toString());
            throw new C9722c(2264, "ContactManager update contact sync1 error " + e10.getMessage(), "addressbook", "local_pre_sync");
        }
    }

    /* renamed from: p */
    public final void m17234p() throws C9722c {
        Cursor cursorQuery;
        if (4 == this.f12751o) {
            m17225g();
        }
        String[] strArr = f12733r;
        String[] strArr2 = {strArr[0], strArr[1]};
        try {
            cursorQuery = this.f12737a.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id", "display_name", "sync1", "version", "dirty", "starred", C2879d.m17347d()}, "(deleted=0 AND account_name=? AND account_type=? and _id in (select raw_contact_id from data)) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL AND _id in (select raw_contact_id from data))", strArr2, null);
        } catch (Exception e10) {
            C11839m.m70687e("ContactManager", "getChangedContact, query Exception :" + e10.toString());
            cursorQuery = null;
        }
        Cursor cursor = cursorQuery;
        if (cursor == null) {
            C11839m.m70687e("ContactManager", "getChangedContact, contact return null");
            throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactManager getChangedContact, contact return null", "addressbook", "local_pre_sync");
        }
        ContentResolver contentResolver = this.f12737a;
        Uri uri = ContactsContract.Groups.CONTENT_URI;
        String[] strArr3 = f12734s;
        Cursor cursorQuery2 = contentResolver.query(uri, strArr3, "(deleted=0 AND account_name=? AND account_type=?) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL )", strArr2, null);
        try {
            cursorQuery2 = this.f12737a.query(uri, strArr3, "(deleted=0 AND account_name=? AND account_type=?) OR (deleted=0 AND account_name IS NULL AND account_type IS NULL )", strArr2, null);
        } catch (Exception e11) {
            C11839m.m70687e("ContactManager", "getChangedContact, query Exception :" + e11.toString());
        }
        Cursor cursor2 = cursorQuery2;
        if (cursor2 == null) {
            cursor.close();
            C11839m.m70687e("ContactManager", "getChangedContact, group return null");
            throw new C9722c(FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS, "ContactManager getChangedContact, group return null", "addressbook", "local_pre_sync");
        }
        try {
            HashMap<String, C11847b> mapM17233o = m17233o(cursor, cursor.getCount());
            this.f12741e = C2884i.m17565b(mapM17233o);
            this.f12742f = m17235q(mapM17233o, cursor2);
            HashMap<String, Map<String, C11847b>> map = this.f12741e;
            if (map != null) {
                this.f12744h = map.get("2").size();
                this.f12743g = this.f12741e.get("1").size();
                this.f12745i = this.f12741e.get("0").size();
                this.f12746j = this.f12741e.get("3").size();
            }
            this.f12748l = this.f12742f.get("2").size();
            this.f12747k = this.f12742f.get("1").size();
            this.f12749m = this.f12742f.get("0").size();
            this.f12750n = this.f12742f.get("3").size();
            cursor.close();
            cursor2.close();
        } catch (Throwable th2) {
            cursor.close();
            cursor2.close();
            throw th2;
        }
    }

    /* renamed from: q */
    public final HashMap<String, Map<String, C11848c>> m17235q(HashMap<String, C11847b> map, Cursor cursor) throws Throwable {
        HashMap<String, C11848c> mapM17244z;
        int count = cursor != null ? cursor.getCount() : 0;
        if (cursor == null || !cursor.moveToFirst()) {
            mapM17244z = null;
        } else {
            C11839m.m70688i("ContactManager", "[getChangedGroup] Retrieving all items, groups size:" + count);
            mapM17244z = m17244z(count, cursor);
            m17209L();
            C2886k.m17586e(mapM17244z, this.f12738b);
            m17213P(map, mapM17244z);
        }
        HashMap<String, Map<String, C11848c>> mapM17587f = C2886k.m17587f(mapM17244z);
        C2886k.m17588g(this.f12738b, mapM17587f.get("3"));
        return mapM17587f;
    }

    /* renamed from: r */
    public int m17236r() {
        return this.f12745i;
    }

    /* renamed from: s */
    public int m17237s() {
        return this.f12744h;
    }

    /* renamed from: t */
    public int m17238t() {
        return this.f12746j;
    }

    /* renamed from: u */
    public int m17239u() {
        return this.f12743g;
    }

    /* renamed from: v */
    public Map<String, C11847b> m17240v() throws C9722c {
        if (this.f12741e == null) {
            m17234p();
        }
        Map<String, C11847b> map = this.f12741e.get("2");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local deleted contact size = " + map.size());
        return map;
    }

    /* renamed from: w */
    public Map<String, C11848c> m17241w() throws C9722c {
        if (this.f12742f == null) {
            m17234p();
        }
        Map<String, C11848c> map = this.f12742f.get("2");
        if (map == null) {
            map = new HashMap<>();
        }
        C11839m.m70688i("ContactManager", "Local deleted group size = " + map.size());
        return map;
    }

    /* renamed from: x */
    public int m17242x() {
        return this.f12749m;
    }

    /* renamed from: y */
    public int m17243y() {
        return this.f12748l;
    }

    /* renamed from: z */
    public final HashMap<String, C11848c> m17244z(int i10, Cursor cursor) throws C9722c {
        HashMap<String, C11848c> map = new HashMap<>(32);
        for (int i11 = 0; i11 < i10; i11++) {
            String strValueOf = String.valueOf(cursor.getInt(0));
            String string = cursor.getString(1);
            String string2 = cursor.getString(2);
            int i12 = cursor.getInt(3);
            int i13 = cursor.getInt(5);
            if (i12 != 1) {
                if (C2983l.m17910g(string2)) {
                    string2 = C2886k.m17595n();
                    if (this.f12740d == null) {
                        this.f12740d = new HashMap<>(64);
                    }
                    this.f12740d.put(strValueOf, string2);
                }
                C2890o c2890o = new C2890o(strValueOf, string, string2);
                C11848c c11848c = new C11848c();
                c11848c.setLuid(strValueOf);
                c11848c.setUuid(string2);
                c11848c.m70944c(c2890o);
                c11848c.m70945d(i13);
                map.put(c2890o.m17673f(), c11848c);
            }
            cursor.moveToNext();
        }
        try {
            C2886k.m17599r(this.f12740d, this.f12738b);
            HashMap<String, String> map2 = this.f12740d;
            if (map2 != null) {
                map2.clear();
            }
            return map;
        } catch (Exception e10) {
            C11839m.m70689w("ContactManager", "[getChangedGroup] update group sync1 error:" + e10.toString());
            throw new C9722c(2264, "ContactManager update group sync1 error " + e10.getMessage(), "addressbook", "local_pre_sync");
        }
    }

    public ContactManager(Context context, String str, String str2) {
        this.f12739c = null;
        this.f12740d = null;
        this.f12741e = null;
        this.f12742f = null;
        this.f12743g = 0;
        this.f12744h = 0;
        this.f12745i = 0;
        this.f12746j = 0;
        this.f12747k = 0;
        this.f12748l = 0;
        this.f12749m = 0;
        this.f12750n = 0;
        this.f12752p = "";
        this.f12753q = "";
        this.f12738b = context;
        this.f12737a = context.getContentResolver();
        this.f12752p = str;
        this.f12753q = str2;
    }
}
