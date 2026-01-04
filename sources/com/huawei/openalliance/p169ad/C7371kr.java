package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.kr */
/* loaded from: classes8.dex */
public class C7371kr extends AbstractC7369kp<Object> {
    public C7371kr(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7372ks
    /* renamed from: a */
    public String mo45456a() {
        return InterfaceC5483d.f25084j;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7369kp
    /* renamed from: a */
    public String mo45454a(Object obj) throws JSONException {
        if (obj == null) {
            return "";
        }
        try {
            return AbstractC7758be.m47727a(obj);
        } catch (JSONException e10) {
            AbstractC7185ho.m43823c("JsonBeanConverter", "convert json JSONException!");
            throw e10;
        }
    }
}
