package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.kw */
/* loaded from: classes8.dex */
public class C7376kw extends AbstractC7374ku<Float> {
    @Override // com.huawei.openalliance.p169ad.AbstractC7374ku
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float mo45461a(String str) {
        String str2;
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            AbstractC7185ho.m43823c("FloatDataConverter", str2);
            return Float.valueOf(0.0f);
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            AbstractC7185ho.m43823c("FloatDataConverter", str2);
            return Float.valueOf(0.0f);
        }
    }
}
