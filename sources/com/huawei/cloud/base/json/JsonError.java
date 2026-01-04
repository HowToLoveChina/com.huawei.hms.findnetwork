package com.huawei.cloud.base.json;

import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.json.C4625a;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import ni.AbstractC11708c;
import ni.C11707b;

/* loaded from: classes.dex */
public class JsonError extends C11707b {

    @InterfaceC4648p
    private int code;

    @InterfaceC4648p
    private List<C4624a> errors;

    @InterfaceC4648p
    private String message;

    /* renamed from: com.huawei.cloud.base.json.JsonError$a */
    public static class C4624a extends C11707b {
        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C4624a clone() {
            return (C4624a) super.clone();
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public C4624a set(String str, Object obj) {
            return (C4624a) super.set(str, obj);
        }
    }

    static {
        C4642j.m28447j(C4624a.class);
    }

    public static JsonError parse(AbstractC11708c abstractC11708c, C4615r c4615r) throws IOException {
        return (JsonError) new C4625a.a(abstractC11708c).m28372b(Collections.singleton(VastAttribute.ERROR)).m28371a().mo28364a(c4615r.m28306c(), c4615r.m28307d(), JsonError.class);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<C4624a> getErrors() {
        return this.errors;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setErrors(List<C4624a> list) {
        this.errors = list;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public JsonError set(String str, Object obj) {
        return (JsonError) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public JsonError clone() {
        return (JsonError) super.clone();
    }
}
