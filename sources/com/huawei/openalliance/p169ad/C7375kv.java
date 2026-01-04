package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.kv */
/* loaded from: classes8.dex */
public class C7375kv extends AbstractC7374ku<Double> {
    @Override // com.huawei.openalliance.p169ad.AbstractC7374ku
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double mo45461a(String str) {
        String str2;
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            AbstractC7185ho.m43823c("DoubleDataConverter", str2);
            return Double.valueOf(0.0d);
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            AbstractC7185ho.m43823c("DoubleDataConverter", str2);
            return Double.valueOf(0.0d);
        }
    }
}
