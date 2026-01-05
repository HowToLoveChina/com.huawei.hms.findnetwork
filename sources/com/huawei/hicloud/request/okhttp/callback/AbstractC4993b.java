package com.huawei.hicloud.request.okhttp.callback;

import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.HttpRequestBuilder;

/* renamed from: com.huawei.hicloud.request.okhttp.callback.b */
/* loaded from: classes6.dex */
public abstract class AbstractC4993b<T> extends AbstractC4992a<T> {
    public abstract AbstractC11920f0 create() throws IOException;

    public void doOutput(HttpRequestBuilder.a aVar) throws IOException {
        AbstractC11920f0 abstractC11920f0Create;
        abstractC11920f0Create = create();
        String str = this.method;
        str.hashCode();
        switch (str) {
            case "PUT":
                aVar.m71582i(abstractC11920f0Create);
                break;
            case "POST":
                aVar.m71581h(abstractC11920f0Create);
                break;
            case "DELETE":
                aVar.m71577d(abstractC11920f0Create);
                break;
        }
    }
}
