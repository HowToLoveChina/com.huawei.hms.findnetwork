package com.huawei.cloud.base.json;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes.dex */
public class JsonErrorContainer extends C11707b {

    @InterfaceC4648p
    private JsonError error;

    public final JsonError getError() {
        return this.error;
    }

    public final void setError(JsonError jsonError) {
        this.error = jsonError;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public JsonErrorContainer set(String str, Object obj) {
        return (JsonErrorContainer) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public JsonErrorContainer clone() {
        return (JsonErrorContainer) super.clone();
    }
}
