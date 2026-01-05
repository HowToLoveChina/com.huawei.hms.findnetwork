package p239dw;

import p436kv.AbstractLinkHashMap;

/* renamed from: dw.h */
/* loaded from: classes9.dex */
public class C9332h extends AbstractLinkHashMap {
    @Override // p436kv.interfaceLinkHashMap
    /* renamed from: a */
    public String getName() {
        return "applyCredential";
    }

    /* renamed from: k */
    public C9332h m58674k() {
        this.hashmap.put("flavor", "product");
        return this;
    }

    /* renamed from: l */
    public C9332h m58675l(String str) {
        this.hashmap.put("credentialPackageName", str);
        return this;
    }

    /* renamed from: m */
    public C9332h m58676m(String str) {
        this.hashmap.put("cty", str);
        return this;
    }
}
