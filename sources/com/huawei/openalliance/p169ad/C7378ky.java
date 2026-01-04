package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.ky */
/* loaded from: classes8.dex */
public class C7378ky extends AbstractC7374ku<Integer> {
    @Override // com.huawei.openalliance.p169ad.AbstractC7374ku
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer mo45461a(String str) {
        String str2;
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            AbstractC7185ho.m43823c("IntegerDataConverter", str2);
            return 0;
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            AbstractC7185ho.m43823c("IntegerDataConverter", str2);
            return 0;
        }
    }
}
