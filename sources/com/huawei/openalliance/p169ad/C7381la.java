package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.la */
/* loaded from: classes8.dex */
public class C7381la extends AbstractC7374ku<Long> {
    @Override // com.huawei.openalliance.p169ad.AbstractC7374ku
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long mo45461a(String str) {
        String str2;
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            AbstractC7185ho.m43817a("LongDataConverter", str2);
            return 0L;
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            AbstractC7185ho.m43817a("LongDataConverter", str2);
            return 0L;
        }
    }
}
