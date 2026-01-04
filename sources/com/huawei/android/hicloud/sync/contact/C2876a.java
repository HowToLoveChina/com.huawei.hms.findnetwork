package com.huawei.android.hicloud.sync.contact;

import ad.C0100a;
import android.content.Context;
import android.os.Handler;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.syncutil.C2975d;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import p514o9.C11839m;
import p517oc.C11847b;
import p517oc.C11848c;
import sc.C12769b;
import sc.C12770c;
import sc.C12774g;

/* renamed from: com.huawei.android.hicloud.sync.contact.a */
/* loaded from: classes3.dex */
public class C2876a extends SyncProcessBase {

    /* renamed from: A */
    public Map<String, C11848c> f12761A;

    /* renamed from: B */
    public Map<String, C11848c> f12762B;

    /* renamed from: C */
    public Map<String, C11848c> f12763C;

    /* renamed from: D */
    public final Map<String, C11848c> f12764D;

    /* renamed from: E */
    public final Map<String, C11848c> f12765E;

    /* renamed from: F */
    public Map<String, C11848c> f12766F;

    /* renamed from: G */
    public Map<String, C11848c> f12767G;

    /* renamed from: H */
    public final Map<String, C11848c> f12768H;

    /* renamed from: I */
    public ArrayList<C11848c> f12769I;

    /* renamed from: J */
    public ArrayList<C11848c> f12770J;

    /* renamed from: K */
    public ArrayList<C11848c> f12771K;

    /* renamed from: L */
    public ArrayList<C11848c> f12772L;

    /* renamed from: M */
    public ArrayList<C11848c> f12773M;

    /* renamed from: N */
    public int f12774N;

    /* renamed from: O */
    public int f12775O;

    /* renamed from: P */
    public int f12776P;

    /* renamed from: Q */
    public int f12777Q;

    /* renamed from: R */
    public int f12778R;

    /* renamed from: S */
    public int f12779S;

    /* renamed from: T */
    public int f12780T;

    /* renamed from: U */
    public boolean f12781U;

    /* renamed from: V */
    public int f12782V;

    /* renamed from: W */
    public int f12783W;

    /* renamed from: X */
    public int f12784X;

    /* renamed from: Y */
    public int f12785Y;

    /* renamed from: Z */
    public String f12786Z;

    /* renamed from: a */
    public boolean f12787a;

    /* renamed from: b */
    public boolean f12788b;

    /* renamed from: c */
    public boolean f12789c;

    /* renamed from: d */
    public boolean f12790d;

    /* renamed from: e */
    public boolean f12791e;

    /* renamed from: f */
    public final ContactManager f12792f;

    /* renamed from: g */
    public int f12793g;

    /* renamed from: h */
    public String f12794h;

    /* renamed from: i */
    public Map<String, C11847b> f12795i;

    /* renamed from: j */
    public Map<String, C11847b> f12796j;

    /* renamed from: k */
    public Map<String, C11847b> f12797k;

    /* renamed from: l */
    public Map<String, C11847b> f12798l;

    /* renamed from: m */
    public Map<String, C11847b> f12799m;

    /* renamed from: n */
    public Map<String, C11847b> f12800n;

    /* renamed from: o */
    public Map<String, C11847b> f12801o;

    /* renamed from: p */
    public Map<String, C11847b> f12802p;

    /* renamed from: q */
    public ArrayList<String> f12803q;

    /* renamed from: r */
    public ArrayList<String> f12804r;

    /* renamed from: s */
    public ArrayList<C11847b> f12805s;

    /* renamed from: t */
    public ArrayList<C11847b> f12806t;

    /* renamed from: u */
    public ArrayList<C11847b> f12807u;

    /* renamed from: v */
    public ArrayList<C11847b> f12808v;

    /* renamed from: w */
    public ArrayList<C11847b> f12809w;

    /* renamed from: x */
    public Map<String, C11848c> f12810x;

    /* renamed from: y */
    public Map<String, C11848c> f12811y;

    /* renamed from: z */
    public Map<String, C11848c> f12812z;

    public C2876a(Context context, String str, String str2, String str3, String str4) {
        super(context, str, str2, str3, str4, "com.android.contacts");
        this.f12787a = false;
        this.f12788b = false;
        this.f12789c = false;
        this.f12790d = false;
        this.f12791e = true;
        this.f12795i = new HashMap(512);
        this.f12796j = new HashMap(512);
        this.f12797k = new HashMap(512);
        this.f12798l = new HashMap(512);
        this.f12799m = new HashMap(512);
        this.f12800n = new HashMap(512);
        this.f12801o = new HashMap(512);
        this.f12802p = new HashMap(512);
        this.f12803q = null;
        this.f12804r = null;
        this.f12805s = null;
        this.f12806t = null;
        this.f12807u = null;
        this.f12808v = null;
        this.f12809w = null;
        this.f12810x = new HashMap(512);
        this.f12811y = new HashMap(512);
        this.f12812z = new HashMap(512);
        this.f12761A = new HashMap(512);
        this.f12762B = new HashMap(512);
        this.f12763C = new HashMap(512);
        this.f12764D = new HashMap(512);
        this.f12765E = new HashMap(512);
        this.f12766F = new HashMap(512);
        this.f12767G = new HashMap(512);
        this.f12768H = new HashMap(512);
        this.f12769I = null;
        this.f12770J = null;
        this.f12771K = null;
        this.f12772L = null;
        this.f12773M = null;
        this.f12774N = 0;
        this.f12775O = 0;
        this.f12776P = 0;
        this.f12777Q = 0;
        this.f12778R = 0;
        this.f12779S = 0;
        this.f12780T = 0;
        this.f12781U = false;
        this.f12782V = 0;
        this.f12783W = 0;
        this.f12784X = 0;
        this.f12786Z = "";
        this.f12792f = new ContactManager(context, str3, str4);
    }

    /* renamed from: A */
    public final void m17245A(List<C11848c> list) {
        try {
            this.f12792f.m17217T(list);
        } catch (Exception e10) {
            C11839m.m70689w("AddressDataProcess", "[procResultAU] update return update or add results failed " + e10.toString());
        }
    }

    /* renamed from: B */
    public final void m17246B(C11848c c11848c, C11848c c11848c2) throws C9722c {
        if (c11848c.m70942a() == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (c11848c2.m70942a() != null) {
            arrayList2 = c11848c2.m70942a().m17675h();
            m17257c(c11848c2.m70942a(), arrayList2);
            arrayList = c11848c2.m70942a().m17676i();
        }
        ArrayList<String> arrayListM17676i = c11848c.m70942a().m17676i();
        m17256b(c11848c.m70942a(), arrayListM17676i);
        ArrayList<String> arrayListM17675h = c11848c.m70942a().m17675h();
        HashMap map = new HashMap(512);
        String str = "";
        if (arrayList2 != null) {
            try {
                if (arrayList2.size() > 0 && arrayList != null && arrayList.size() > 0) {
                    String str2 = "cloud guid: " + arrayList2.size() + ", cloud uuid: " + arrayList.size();
                    for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                        if (!map.containsKey(arrayList2.get(i10))) {
                            map.put(arrayList2.get(i10), arrayList.get(i10));
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e10) {
                throw new C9722c(2008, "processGroupMerge, " + e10.getMessage() + ", " + str);
            }
        }
        if (arrayListM17675h != null && arrayListM17675h.size() > 0 && arrayListM17676i != null && arrayListM17676i.size() > 0) {
            str = "local guid: " + arrayListM17675h.size() + ", local uuid: " + arrayListM17676i.size();
            for (int i11 = 0; i11 < arrayListM17675h.size(); i11++) {
                if (!map.containsKey(arrayListM17675h.get(i11))) {
                    map.put(arrayListM17675h.get(i11), arrayListM17676i.get(i11));
                }
            }
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            arrayList4.add((String) entry.getValue());
            arrayList3.add((String) entry.getKey());
        }
        c11848c.m70942a().m17682o(arrayList4);
        c11848c.m70942a().m17681n(arrayList3);
    }

    /* renamed from: C */
    public void m17247C(int i10, String str, int i11, String str2, Handler.Callback callback, ReportSyncEndInfo reportSyncEndInfo) {
        setConfig(str2, callback, reportSyncEndInfo);
        this.f12793g = i10;
        this.f12794h = str;
        this.f12785Y = i11;
    }

    /* renamed from: D */
    public void m17248D(String str) {
        this.f12786Z = str;
    }

    /* renamed from: E */
    public void m17249E() throws InterruptedException {
        try {
            Thread.sleep(60L);
        } catch (InterruptedException e10) {
            C11839m.m70687e("AddressDataProcess", "InterruptedException : " + e10.toString());
        }
    }

    /* renamed from: F */
    public final void m17250F(C11847b c11847b, C11847b c11847b2) {
        C11847b c11847b3 = new C11847b();
        c11847b3.setLuid(c11847b2.getLuid());
        c11847b3.setGuid(c11847b.getGuid());
        c11847b3.setEtag(c11847b.getEtag());
        c11847b3.setUuid(c11847b2.getUuid());
        c11847b3.m70941b(new C2882g(c11847b2.getLuid(), null, c11847b2.getUuid(), c11847b2.m70940a().m17406H0(), c11847b2.m70940a().m17450W()));
        this.f12796j.put(c11847b2.getLuid(), c11847b3);
    }

    /* renamed from: G */
    public int m17251G(List<C11847b> list, boolean z10, List<String> list2) throws C9722c {
        C12769b c12769b = new C12769b();
        int size = 0;
        try {
            if (z10) {
                if (list2 != null && list2.size() != 0) {
                    m17268n(list2);
                    c12769b.m76628e(list2, this.mDataType);
                    size = list2.size();
                }
                return 0;
            }
            if (list != null && list.size() != 0) {
                if (HNConstants.DataType.CONTACT.equals(this.f12786Z)) {
                    c12769b.m76629f(list, this.mDataType);
                    m17280z(list);
                    size = list.size();
                }
            }
            return 0;
            return size;
        } catch (Exception e10) {
            C11839m.m70687e("AddressDataProcess", "database error message:" + e10.getMessage());
            throw new C9722c(2007, "AddressDataProcess updateContactdb fail " + e10.getMessage(), "addressbook", "local_download_struct");
        }
    }

    /* renamed from: H */
    public void m17252H(boolean z10) throws Exception {
        C12770c c12770c = new C12770c();
        if (z10) {
            c12770c.m76642j(this.ctagList);
            return;
        }
        Iterator<CtagInfo> it = this.ctagList.iterator();
        while (it.hasNext()) {
            CtagInfo next = it.next();
            if (this.f12786Z.equals(next.getCtagName())) {
                C11839m.m70686d("AddressDataProcess", "updateCtag , module = " + next.getCtagName() + ", ctag = " + next.getCtagValue());
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                c12770c.m76642j(arrayList);
            }
        }
    }

    /* renamed from: I */
    public int m17253I(List<C11848c> list, boolean z10, List<String> list2) throws C9722c {
        int size;
        C12774g c12774g = new C12774g();
        try {
            if (z10) {
                if (list2 != null && list2.size() != 0) {
                    m17270p(list2);
                    c12774g.m76670e(list2, this.mDataType);
                    size = list2.size();
                }
                return 0;
            }
            if (list != null && list.size() != 0) {
                c12774g.m76671f(list, this.mDataType);
                m17245A(list);
                size = list.size();
            }
            return 0;
            return size;
        } catch (Exception e10) {
            C11839m.m70687e("AddressDataProcess", "database error message:" + e10.getMessage());
            throw new C9722c(2007, "AddressDataProcess updateGroupdb fail " + e10.getMessage(), "addressbook", "local_download_struct");
        }
    }

    /* renamed from: J */
    public final void m17254J(C11848c c11848c, C11848c c11848c2) throws C9722c {
        m17246B(c11848c, c11848c2);
        C11848c c11848c3 = new C11848c();
        c11848c3.setLuid(c11848c.getLuid());
        c11848c3.setGuid(c11848c2.getGuid());
        c11848c3.setEtag(c11848c2.getEtag());
        c11848c3.setUuid(c11848c.getUuid());
        c11848c3.m70944c(c11848c.m70942a());
        c11848c3.setHash(c11848c.getHash());
        this.f12811y.put(c11848c3.getLuid(), c11848c3);
        this.f12767G.put(c11848c3.getGuid(), c11848c3);
    }

    /* renamed from: a */
    public void m17255a(C2890o c2890o) {
        C11839m.m70686d("AddressDataProcess", "addGuid begin ");
        ArrayList<String> arrayListM17672e = c2890o.m17672e();
        if (arrayListM17672e == null || arrayListM17672e.isEmpty()) {
            return;
        }
        C11839m.m70686d("AddressDataProcess", "contactIdList =  " + arrayListM17672e.toString());
        ArrayList<C11847b> arrayListM76633j = new C12769b().m76633j(arrayListM17672e, HNConstants.DataType.CONTACT);
        if (!c2890o.m17677j()) {
            Iterator<C11847b> it = arrayListM76633j.iterator();
            while (it.hasNext()) {
                c2890o.m17686s(it.next().getGuid());
            }
        }
        C11839m.m70686d("AddressDataProcess", "addGuid , guids =  " + c2890o.m17675h().toString());
    }

    /* renamed from: b */
    public final void m17256b(C2890o c2890o, ArrayList<String> arrayList) {
        C11839m.m70686d("AddressDataProcess", "addGuidUuid");
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<C11847b> it = new C12769b().m76634k(new LinkedHashSet(arrayList), HNConstants.DataType.CONTACT).iterator();
        while (it.hasNext()) {
            c2890o.m17686s(it.next().getGuid());
        }
        c2890o.m17679l(true);
        C11839m.m70686d("AddressDataProcess", "addGuidUuid , guids =  " + c2890o.m17675h().toString());
    }

    public void beginSyncDataPre() throws JSONException, C9722c {
        this.f12792f.m17224f();
        this.f12792f.m17214Q(this.f12785Y);
        C11839m.m70688i("AddressDataProcess", "Begin sync pre for source '" + this.mModuleName + "' with mode " + this.f12785Y);
        int i10 = this.f12785Y;
        if (i10 == 3) {
            m17277w();
            m17279y();
            m17275u();
            C2975d.m17839c(this.mContext, this.f12784X, this.f12783W, this.f12782V, this.f12794h);
            this.f12784X = 0;
            this.f12783W = 0;
            this.f12782V = 0;
            return;
        }
        if (i10 == 4) {
            m17277w();
            m17279y();
            m17275u();
            m17278x();
            return;
        }
        throw new C9722c(2003, "SyncSource " + this.mModuleName + ": invalid sync mode " + this.f12785Y, this.mModuleName, "local_pre_sync");
    }

    /* renamed from: c */
    public final void m17257c(C2890o c2890o, ArrayList<String> arrayList) {
        C11839m.m70686d("AddressDataProcess", "addUuidByGuid begin ");
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<C11847b> arrayListM76636m = new C12769b().m76636m(new LinkedHashSet(arrayList), HNConstants.DataType.CONTACT);
        c2890o.m17668a();
        Iterator<C11847b> it = arrayListM76636m.iterator();
        while (it.hasNext()) {
            c2890o.m17687t(it.next().getUuid());
        }
    }

    /* renamed from: d */
    public void m17258d() throws Throwable {
        isCancel();
        ArrayList arrayList = new ArrayList();
        if (this.f12801o == null) {
            this.f12801o = new HashMap(512);
        }
        if (this.f12796j == null) {
            this.f12796j = new HashMap(512);
        }
        if (this.f12795i == null) {
            this.f12795i = new HashMap(512);
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = false;
        for (Map.Entry<String, C11847b> entry : this.f12801o.entrySet()) {
            C2882g c2882gM70940a = entry.getValue().m70940a();
            if (!this.f12781U && !z10) {
                this.f12792f.m17230l(this.f12795i, true);
                z10 = true;
            }
            arrayList.clear();
            String strM17906c = C2983l.m17906c(c2882gM70940a.m17405H() + c2882gM70940a.m17484i0() + c2882gM70940a.m17417L() + c2882gM70940a.m17388B0() + c2882gM70940a.m17409I0());
            for (Map.Entry<String, C11847b> entry2 : this.f12795i.entrySet()) {
                C2882g c2882gM70940a2 = entry2.getValue().m70940a();
                if (strM17906c.equals(C2983l.m17906c(c2882gM70940a2.m17405H() + c2882gM70940a2.m17484i0() + c2882gM70940a2.m17417L() + c2882gM70940a2.m17388B0() + c2882gM70940a2.m17409I0()))) {
                    arrayList.add(entry2.getValue());
                }
            }
            if (arrayList.size() == 1) {
                arrayList2.add(entry.getKey());
                m17250F(entry.getValue(), (C11847b) arrayList.get(0));
                this.f12795i.remove(((C11847b) arrayList.get(0)).getLuid());
            } else if (arrayList.size() >= 2) {
                if (!this.f12781U) {
                    this.f12792f.m17231m(arrayList);
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        C11847b c11847b = (C11847b) it.next();
                        if (c2882gM70940a.compareTo(c11847b.m70940a()) == 0) {
                            m17250F(entry.getValue(), c11847b);
                            arrayList2.add(entry.getKey());
                            this.f12795i.remove(c11847b.getLuid());
                            break;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.f12801o.remove((String) it2.next());
        }
    }

    /* renamed from: e */
    public boolean m17259e() {
        Map<String, C11847b> mapM701a = C0100a.m701a(C0100a.m702b());
        HashMap map = new HashMap(512);
        for (Map.Entry<String, C11847b> entry : this.f12795i.entrySet()) {
            map.put(entry.getValue().getLuid(), entry.getValue().getUuid());
        }
        int i10 = this.f12785Y;
        if (3 == i10) {
            m17262h(mapM701a, map, false);
        } else if (4 == i10) {
            m17262h(mapM701a, map, true);
        }
        ArrayList<String> arrayList = this.f12804r;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        ArrayList<String> arrayList2 = this.f12803q;
        return (arrayList2 == null || arrayList2.isEmpty()) ? false : true;
    }

    /* renamed from: f */
    public final void m17260f(Map<String, C11848c> map, Map<String, C11848c> map2, boolean z10) {
        for (Map.Entry<String, Etag> entry : this.cloudEtagMap.entrySet()) {
            String key = entry.getKey();
            Etag value = entry.getValue();
            C11848c c11848c = map.get(key);
            if (value != null && value.getEtag() != null) {
                if (!map.containsKey(key) || c11848c == null) {
                    m17261g(map2, z10, key, value);
                } else {
                    if (!value.getEtag().equals(c11848c.getEtag()) && c11848c.getStatus() == 0 && !z10) {
                        C11848c c11848c2 = new C11848c();
                        c11848c2.setGuid(key);
                        c11848c2.setUuid(value.getUuid());
                        c11848c2.setEtag(value.getEtag());
                        c11848c2.setStatus(value.getStatus());
                        c11848c2.setLuid(c11848c.getLuid());
                        this.f12763C.put(key, c11848c2);
                        this.f12804r.add(key);
                    }
                    if (z10) {
                        if (c11848c.getStatus() == 1) {
                            C11848c c11848c3 = new C11848c();
                            c11848c3.setGuid(key);
                            c11848c3.setUuid(value.getUuid());
                            c11848c3.setEtag(value.getEtag());
                            c11848c3.setStatus(value.getStatus());
                            this.f12762B.put(key, c11848c3);
                            this.f12804r.add(key);
                            this.f12812z.remove(c11848c.getLuid());
                        }
                        if (c11848c.getStatus() == 2) {
                            C11848c c11848c4 = new C11848c();
                            c11848c4.setGuid(key);
                            c11848c4.setUuid(value.getUuid());
                            c11848c4.setEtag(value.getEtag());
                            c11848c4.setStatus(value.getStatus());
                            c11848c4.setLuid(c11848c.getLuid());
                            this.f12764D.put(key, c11848c4);
                            this.f12804r.add(key);
                            this.f12765E.put(key, this.f12811y.get(map.get(key).getLuid()));
                            this.f12811y.remove(c11848c.getLuid());
                        }
                        if (c11848c.getStatus() == 0) {
                            C11848c c11848c5 = new C11848c();
                            c11848c5.setGuid(key);
                            c11848c5.setUuid(value.getUuid());
                            c11848c5.setEtag(value.getEtag());
                            c11848c5.setStatus(value.getStatus());
                            c11848c5.setLuid(c11848c.getLuid());
                            this.f12764D.put(key, c11848c5);
                            this.f12804r.add(key);
                            this.f12765E.put(key, this.f12761A.get(map.get(key).getLuid()));
                        }
                    }
                }
            }
        }
        m17266l(map, z10);
    }

    /* renamed from: g */
    public final void m17261g(Map<String, C11848c> map, boolean z10, String str, Etag etag) {
        for (Map.Entry<String, C11848c> entry : map.entrySet()) {
            C11848c value = entry.getValue();
            String key = entry.getKey();
            if (value.getUuid().equals(etag.getUuid())) {
                this.f12791e = false;
                if (z10) {
                    C11848c c11848c = new C11848c();
                    c11848c.setGuid(str);
                    c11848c.setUuid(etag.getUuid());
                    c11848c.setEtag(etag.getEtag());
                    c11848c.setStatus(etag.getStatus());
                    c11848c.m70944c(value.m70942a());
                    c11848c.setLuid(value.getLuid());
                    this.f12764D.put(str, c11848c);
                    this.f12804r.add(str);
                    this.f12765E.put(str, this.f12810x.get(key));
                    this.f12810x.remove(value.getLuid());
                } else {
                    C11848c c11848c2 = new C11848c();
                    c11848c2.setGuid(str);
                    c11848c2.setUuid(etag.getUuid());
                    c11848c2.setEtag(etag.getEtag());
                    c11848c2.setStatus(etag.getStatus());
                    c11848c2.setLuid(value.getLuid());
                    c11848c2.setHash(value.getHash());
                    c11848c2.m70944c(value.m70942a());
                    this.f12811y.put(key, c11848c2);
                    this.f12810x.remove(key);
                }
                map.remove(key);
                return;
            }
        }
        C11848c c11848c3 = new C11848c();
        c11848c3.setGuid(str);
        c11848c3.setUuid(etag.getUuid());
        c11848c3.setEtag(etag.getEtag());
        c11848c3.setStatus(etag.getStatus());
        this.f12762B.put(str, c11848c3);
        this.f12804r.add(str);
    }

    /* renamed from: h */
    public final void m17262h(Map<String, C11847b> map, Map<String, String> map2, boolean z10) {
        for (Map.Entry<String, Etag> entry : this.cloudEtagMap.entrySet()) {
            String key = entry.getKey();
            Etag value = entry.getValue();
            C11847b c11847b = map.get(key);
            if (value != null && value.getEtag() != null) {
                if (!map.containsKey(key) || c11847b == null) {
                    Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            C11847b c11847b2 = new C11847b();
                            c11847b2.setGuid(key);
                            c11847b2.setUuid(value.getUuid());
                            c11847b2.setEtag(value.getEtag());
                            c11847b2.setStatus(value.getStatus());
                            this.f12799m.put(key, c11847b2);
                            this.f12804r.add(key);
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        String value2 = next.getValue();
                        String key2 = next.getKey();
                        if (value2.equals(value.getUuid())) {
                            this.f12791e = false;
                            C11847b c11847b3 = new C11847b();
                            c11847b3.setGuid(key);
                            c11847b3.setUuid(value.getUuid());
                            c11847b3.setEtag(value.getEtag());
                            c11847b3.setStatus(value.getStatus());
                            c11847b3.setLuid(key2);
                            c11847b3.m70941b(new C2882g(key2, null, value2, this.f12795i.get(key2).m70940a().m17406H0(), this.f12795i.get(key2).m70940a().m17450W()));
                            this.f12796j.put(key2, c11847b3);
                            map2.remove(key2);
                            this.f12795i.remove(key2);
                            break;
                        }
                    }
                } else {
                    if (!value.getEtag().equals(c11847b.getEtag()) && c11847b.getStatus() == 0) {
                        C11847b c11847b4 = new C11847b();
                        c11847b4.setGuid(key);
                        c11847b4.setUuid(value.getUuid());
                        c11847b4.setEtag(value.getEtag());
                        c11847b4.setStatus(value.getStatus());
                        c11847b4.setLuid(c11847b.getLuid());
                        this.f12800n.put(key, c11847b4);
                        this.f12804r.add(key);
                    }
                    if (z10 && c11847b.getStatus() == 1) {
                        C11847b c11847b5 = new C11847b();
                        c11847b5.setGuid(key);
                        c11847b5.setUuid(value.getUuid());
                        c11847b5.setEtag(value.getEtag());
                        c11847b5.setStatus(value.getStatus());
                        this.f12799m.put(key, c11847b5);
                        this.f12804r.add(key);
                        this.f12797k.remove(c11847b.getLuid());
                    }
                }
            }
        }
        m17267m(map, z10);
    }

    /* renamed from: i */
    public void m17263i() throws C9722c {
        isCancel();
        if (this.f12766F == null) {
            this.f12766F = new HashMap(512);
        }
        if (this.f12811y == null) {
            this.f12811y = new HashMap(512);
        }
        if (this.f12810x == null) {
            this.f12810x = new HashMap(512);
        }
        for (Map.Entry<String, C11848c> entry : this.f12768H.entrySet()) {
            String key = entry.getKey();
            C11848c value = entry.getValue();
            if (this.f12765E.containsKey(key)) {
                C11848c c11848c = this.f12765E.get(key);
                m17246B(c11848c, value);
                C11848c c11848c2 = new C11848c();
                c11848c2.setLuid(c11848c.getLuid());
                c11848c2.setGuid(value.getGuid());
                c11848c2.setEtag(value.getEtag());
                c11848c2.setUuid(c11848c.getUuid());
                c11848c2.m70944c(c11848c.m70942a());
                c11848c2.setHash(c11848c.getHash());
                this.f12811y.put(c11848c.getLuid(), c11848c2);
                this.f12767G.put(key, c11848c2);
                this.f12765E.remove(key);
            }
        }
    }

    /* renamed from: j */
    public boolean m17264j() throws C9722c {
        isCancel();
        Map<String, C11848c> mapM704d = C0100a.m704d(C0100a.m708h());
        HashMap map = new HashMap(512);
        for (Map.Entry<String, C11848c> entry : this.f12810x.entrySet()) {
            map.put(entry.getValue().getLuid(), entry.getValue());
        }
        int i10 = this.f12785Y;
        if (3 == i10) {
            m17260f(mapM704d, map, false);
        } else if (4 == i10) {
            m17260f(mapM704d, map, true);
        }
        ArrayList<String> arrayList = this.f12804r;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        ArrayList<String> arrayList2 = this.f12803q;
        return (arrayList2 == null || arrayList2.isEmpty()) ? false : true;
    }

    /* renamed from: k */
    public void m17265k() throws C9722c {
        isCancel();
        if (this.f12766F == null) {
            this.f12766F = new HashMap(512);
        }
        if (this.f12811y == null) {
            this.f12811y = new HashMap(512);
        }
        if (this.f12810x == null) {
            this.f12810x = new HashMap(512);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, C11848c> entry : this.f12766F.entrySet()) {
            String strM17674g = entry.getValue().m70942a().m17674g();
            Iterator<Map.Entry<String, C11848c>> it = this.f12810x.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, C11848c> next = it.next();
                    if (strM17674g.equals(next.getValue().m70942a().m17674g())) {
                        m17254J(next.getValue(), entry.getValue());
                        arrayList.add(entry.getKey());
                        this.f12810x.remove(next.getKey());
                        break;
                    }
                }
            }
        }
        if (arrayList.size() != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f12766F.remove((String) it2.next());
            }
        }
    }

    /* renamed from: l */
    public final void m17266l(Map<String, C11848c> map, boolean z10) {
        for (Map.Entry<String, C11848c> entry : map.entrySet()) {
            String key = entry.getKey();
            C11848c value = entry.getValue();
            String luid = value.getLuid();
            if (!this.cloudEtagMap.containsKey(key)) {
                if (value.getStatus() == 0) {
                    if (z10) {
                        this.f12810x.put(luid, this.f12761A.get(luid));
                    } else {
                        this.f12803q.add(luid);
                    }
                } else if (value.getStatus() == 1) {
                    this.f12803q.add(luid);
                    this.f12812z.remove(luid);
                } else if (value.getStatus() == 2) {
                    this.f12810x.put(luid, this.f12811y.get(luid));
                    this.f12811y.remove(luid);
                }
            }
        }
    }

    /* renamed from: m */
    public final void m17267m(Map<String, C11847b> map, boolean z10) {
        for (Map.Entry<String, C11847b> entry : map.entrySet()) {
            String key = entry.getKey();
            C11847b value = entry.getValue();
            String luid = value.getLuid();
            if (!this.cloudEtagMap.containsKey(key)) {
                if (value.getStatus() == 0) {
                    if (z10) {
                        this.f12795i.put(luid, this.f12798l.get(luid));
                    } else {
                        this.f12803q.add(luid);
                    }
                } else if (value.getStatus() == 1) {
                    this.f12803q.add(luid);
                    this.f12797k.remove(luid);
                } else if (value.getStatus() == 2) {
                    this.f12795i.put(luid, this.f12796j.get(luid));
                    this.f12796j.remove(luid);
                }
            }
        }
    }

    /* renamed from: n */
    public final void m17268n(List<String> list) {
        this.f12792f.m17226h(list, false, "");
    }

    /* renamed from: o */
    public void m17269o(List<String> list) throws C9722c, InterruptedException {
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size()) {
            isCancel();
            int i12 = i11 * 20;
            int size = i12 + 20;
            if (size > list.size()) {
                size = list.size();
            }
            m17249E();
            if (HNConstants.DataType.CONTACT.equals(this.f12786Z)) {
                this.f12779S += m17251G(null, true, list.subList(i12, size));
            } else {
                this.f12779S += m17253I(null, true, list.subList(i12, size));
            }
            i11++;
            i10 = size;
        }
    }

    /* renamed from: p */
    public final void m17270p(List<String> list) {
        this.f12792f.m17228j(list);
    }

    /* renamed from: q */
    public void m17271q(ArrayList<String> arrayList) throws C9722c, InterruptedException {
        int i10 = 0;
        int i11 = 0;
        while (i10 < arrayList.size()) {
            isCancel();
            int i12 = i11 * 20;
            int size = i12 + 20;
            if (size > arrayList.size()) {
                size = arrayList.size();
            }
            m17249E();
            if (HNConstants.DataType.CONTACT.equals(this.f12786Z)) {
                this.f12776P += m17251G(null, true, arrayList.subList(i12, size));
            } else {
                this.f12776P += m17253I(null, true, arrayList.subList(i12, size));
            }
            i11++;
            i10 = size;
        }
    }

    /* renamed from: r */
    public int m17272r(Context context) {
        return this.f12792f.m17232n();
    }

    /* renamed from: s */
    public int m17273s(Context context) {
        return this.f12792f.m17205H();
    }

    /* renamed from: t */
    public int m17274t() {
        return this.f12793g;
    }

    /* renamed from: u */
    public final void m17275u() throws C9722c {
        this.f12797k = this.f12792f.m17240v();
        this.f12783W = this.f12792f.m17237s();
    }

    /* renamed from: v */
    public void m17276v() throws C9722c {
        this.f12810x = this.f12792f.m17201D();
        this.f12811y = this.f12792f.m17208K();
        this.f12812z = this.f12792f.m17241w();
        this.f12761A = this.f12792f.m17203F();
    }

    /* renamed from: w */
    public final void m17277w() throws C9722c {
        this.f12795i = this.f12792f.m17200C();
        this.f12784X = this.f12792f.m17236r();
    }

    /* renamed from: x */
    public final void m17278x() throws C9722c {
        this.f12798l = this.f12792f.m17202E();
    }

    /* renamed from: y */
    public final void m17279y() throws C9722c {
        this.f12796j = this.f12792f.m17207J();
        this.f12782V = this.f12792f.m17239u();
    }

    /* renamed from: z */
    public final void m17280z(List<C11847b> list) {
        try {
            this.f12792f.m17216S(list);
        } catch (Exception e10) {
            C11839m.m70689w("AddressDataProcess", "[procResultAU] update return update or add results failed " + e10.toString());
        }
    }
}
