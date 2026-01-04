package com.huawei.android.hicloud.sync.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/* renamed from: com.huawei.android.hicloud.sync.contact.o */
/* loaded from: classes3.dex */
public class C2890o {

    /* renamed from: a */
    public String f12921a;

    /* renamed from: b */
    public String f12922b;

    /* renamed from: c */
    public ArrayList<String> f12923c;

    /* renamed from: d */
    public ArrayList<String> f12924d;

    /* renamed from: e */
    public boolean f12925e;

    /* renamed from: f */
    public ArrayList<String> f12926f;

    /* renamed from: g */
    public ArrayList<String> f12927g;

    /* renamed from: h */
    public String f12928h;

    public C2890o() {
        this.f12922b = "";
        this.f12925e = false;
    }

    /* renamed from: a */
    public void m17668a() {
        ArrayList<String> arrayList = this.f12923c;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* renamed from: b */
    public final <T> T m17669b(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    /* renamed from: c */
    public ArrayList<String> m17670c() {
        return this.f12927g;
    }

    /* renamed from: d */
    public String m17671d() {
        return (String) m17669b(this.f12928h);
    }

    /* renamed from: e */
    public ArrayList<String> m17672e() {
        return this.f12924d;
    }

    /* renamed from: f */
    public String m17673f() {
        return this.f12921a;
    }

    /* renamed from: g */
    public String m17674g() {
        return (String) m17669b(this.f12922b);
    }

    /* renamed from: h */
    public ArrayList<String> m17675h() {
        return (ArrayList) m17669b(this.f12926f);
    }

    /* renamed from: i */
    public ArrayList<String> m17676i() {
        return (ArrayList) m17669b(this.f12923c);
    }

    /* renamed from: j */
    public boolean m17677j() {
        return this.f12925e;
    }

    /* renamed from: k */
    public void m17678k(String str) {
        if (this.f12927g == null) {
            this.f12927g = new ArrayList<>(128);
        }
        this.f12927g.add(str);
    }

    /* renamed from: l */
    public void m17679l(boolean z10) {
        this.f12925e = z10;
    }

    /* renamed from: m */
    public void m17680m(String str) {
        this.f12928h = str;
    }

    /* renamed from: n */
    public void m17681n(ArrayList<String> arrayList) {
        if (this.f12926f == null) {
            this.f12926f = new ArrayList<>(128);
        }
        this.f12926f.clear();
        this.f12926f.addAll(arrayList);
    }

    /* renamed from: o */
    public void m17682o(ArrayList<String> arrayList) {
        if (this.f12923c == null) {
            this.f12923c = new ArrayList<>(128);
        }
        this.f12923c.clear();
        this.f12923c.addAll(arrayList);
    }

    /* renamed from: p */
    public void m17683p(String str) {
        if (this.f12924d == null) {
            this.f12924d = new ArrayList<>(128);
        }
        this.f12924d.add(str);
    }

    /* renamed from: q */
    public void m17684q(String str) {
        this.f12921a = str;
    }

    /* renamed from: r */
    public void m17685r(String str) {
        this.f12922b = str;
    }

    /* renamed from: s */
    public void m17686s(String str) {
        if (this.f12926f == null) {
            this.f12926f = new ArrayList<>(128);
        }
        this.f12926f.add(str);
    }

    /* renamed from: t */
    public void m17687t(String str) {
        if (this.f12923c == null) {
            this.f12923c = new ArrayList<>(128);
        }
        this.f12923c.add(str);
    }

    /* renamed from: u */
    public void m17688u() {
        ArrayList<String> arrayList = this.f12923c;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String> arrayList2 = this.f12926f;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            Collections.sort(this.f12923c);
            return;
        }
        if (this.f12923c.size() == this.f12926f.size()) {
            TreeMap treeMap = new TreeMap();
            for (int i10 = 0; i10 < this.f12923c.size() && i10 < this.f12926f.size(); i10++) {
                treeMap.put(this.f12923c.get(i10), this.f12926f.get(i10));
            }
            this.f12923c = new ArrayList<>(treeMap.keySet());
            this.f12926f = new ArrayList<>(treeMap.values());
        }
    }

    public C2890o(String str, String str2, String str3) {
        this.f12925e = false;
        this.f12922b = str2;
        this.f12921a = str;
        this.f12928h = str3;
    }
}
