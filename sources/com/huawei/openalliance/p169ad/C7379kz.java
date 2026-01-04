package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.kz */
/* loaded from: classes8.dex */
public class C7379kz<R> extends AbstractC7374ku<R> {

    /* renamed from: a */
    private Class<R> f34298a;

    public C7379kz(Class<R> cls) {
        this.f34298a = cls;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7374ku
    /* renamed from: a */
    public R mo45461a(String str) throws JSONException {
        try {
            return (R) AbstractC7758be.m47722a(str, this.f34298a, new Class[0]);
        } catch (JSONException e10) {
            AbstractC7185ho.m43823c("JsonObjDataConverter", "convertStringToData json JSONException");
            throw e10;
        }
    }
}
