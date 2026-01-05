package p239dw;

import p436kv.AbstractLinkHashMap;

/* renamed from: dw.p */
/* loaded from: classes9.dex */
public class C9348p extends AbstractLinkHashMap {
    @Override // p436kv.interfaceLinkHashMap
    /* renamed from: a */
    public String getName() {
        return "credentialFromString";
    }

    /* renamed from: k */
    public C9348p m58701k() {
        this.hashmap.put("flavor", "product");
        return this;
    }

    /* renamed from: l */
    public C9348p m58702l(int i10) {
        this.hashmap.put("akSkVersion", String.valueOf(i10));
        return this;
    }

    /* renamed from: m */
    public C9348p m58703m(String str) {
        this.hashmap.put("credentialAppName", str);
        return this;
    }

    /* renamed from: n */
    public C9348p m58704n(String str) {
        this.hashmap.put("cty", str);
        return this;
    }
}
