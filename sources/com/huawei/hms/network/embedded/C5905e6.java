package com.huawei.hms.network.embedded;

import com.huawei.hms.network.base.util.TypeUtils;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.hms.network.restclient.SubmitAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* renamed from: com.huawei.hms.network.embedded.e6 */
/* loaded from: classes8.dex */
public final class C5905e6 extends SubmitAdapter.Factory {

    /* renamed from: a */
    public static final SubmitAdapter.Factory f26689a = new C5905e6();

    /* renamed from: com.huawei.hms.network.embedded.e6$a */
    public class a extends SubmitAdapter<Object, Submit<?>> {

        /* renamed from: a */
        public final /* synthetic */ Type f26690a;

        public a(Type type) {
            this.f26690a = type;
        }

        @Override // com.huawei.hms.network.restclient.SubmitAdapter
        /* renamed from: adapt, reason: merged with bridge method [inline-methods] */
        public Submit<?> adapt2(Submit<Object> submit) {
            return submit;
        }

        @Override // com.huawei.hms.network.restclient.SubmitAdapter
        public Type responseType() {
            return this.f26690a;
        }
    }

    @Override // com.huawei.hms.network.restclient.SubmitAdapter.Factory
    public SubmitAdapter<?, ?> get(Type type, Annotation[] annotationArr, RestClient restClient) {
        return new a(TypeUtils.getSubmitResponseType(type));
    }
}
