package com.huawei.hicloud.okhttp.callback;

import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11918e0;

/* renamed from: com.huawei.hicloud.okhttp.callback.b */
/* loaded from: classes6.dex */
public abstract class AbstractC4976b<T> extends AbstractC4975a<T> {
    public abstract AbstractC11920f0 create() throws IOException;

    public void doOutput(C11918e0.a aVar) throws IOException {
        AbstractC11920f0 abstractC11920f0Create = create();
        String str = this.method;
        str.hashCode();
        if (str.equals("PUT")) {
            aVar.m71582i(abstractC11920f0Create);
        } else if (str.equals("POST")) {
            aVar.m71581h(abstractC11920f0Create);
        }
    }
}
