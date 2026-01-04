package mq;

import java.util.ArrayList;

/* renamed from: mq.a */
/* loaded from: classes8.dex */
public class C11504a {

    /* renamed from: a */
    public String f53407a;

    /* renamed from: b */
    public ArrayList<C11505b> f53408b = new ArrayList<>();

    public C11504a(String str) {
        this.f53407a = str;
    }

    /* renamed from: a */
    public String m68676a() {
        return this.f53407a;
    }

    /* renamed from: b */
    public void m68677b(C11505b c11505b) {
        this.f53408b.add(c11505b);
    }

    /* renamed from: c */
    public ArrayList<C11505b> m68678c() {
        return this.f53408b;
    }

    /* renamed from: d */
    public void m68679d() {
        ArrayList<C11505b> arrayList = this.f53408b;
        if (arrayList != null) {
            arrayList.clear();
            this.f53408b = new ArrayList<>();
        }
    }
}
