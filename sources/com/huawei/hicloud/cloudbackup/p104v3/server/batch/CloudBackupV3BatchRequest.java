package com.huawei.hicloud.cloudbackup.p104v3.server.batch;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BatchRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BatchResponse;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import li.C11277a;
import ni.C11707b;
import p015ak.C0241z;
import p369ii.InterfaceC10510a;
import p523oi.C11903a;
import p814yl.C14000c0;

/* loaded from: classes6.dex */
public class CloudBackupV3BatchRequest {
    private List<RequestInfo<?, ?>> requestInfos = new ArrayList();

    public static class RequestInfo<T, E> {
        final InterfaceC10510a<T, E> callback;
        final Class<T> dataClass;
        final Class<E> errorClass;
        final C4612o request;

        public RequestInfo(C4612o c4612o, InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2) {
            this.callback = interfaceC10510a;
            this.dataClass = cls;
            this.errorClass = cls2;
            this.request = c4612o;
        }
    }

    public static /* synthetic */ CloudBackupV3Request lambda$execute$0(BatchRequest batchRequest, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        return cloudBackupV3Server.batchRequest().batch(batchRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T, E> void parseAndCallback(RequestInfo<T, E> requestInfo, BatchResponse.SingleResponse singleResponse) throws IOException {
        InterfaceC10510a<T, E> interfaceC10510a = requestInfo.callback;
        if (interfaceC10510a == 0) {
            return;
        }
        int iM1685c = C0241z.m1685c(singleResponse.getHttpCode());
        C11707b httpBody = singleResponse.getHttpBody();
        if (C4618u.m28333b(iM1685c)) {
            if (httpBody == null) {
                interfaceC10510a.onSuccess(null, singleResponse.getHttpHeader());
                return;
            } else {
                interfaceC10510a.onSuccess(C11903a.m71435l().mo69832e(httpBody.toString()).m69886u(requestInfo.dataClass), singleResponse.getHttpHeader());
                return;
            }
        }
        if (httpBody == null) {
            interfaceC10510a.onFailure(null, singleResponse.getHttpHeader());
        } else {
            interfaceC10510a.onFailure(C11903a.m71435l().mo69832e(httpBody.toString()).m69886u(requestInfo.errorClass), singleResponse.getHttpHeader());
        }
    }

    public void execute(String str, String str2) throws C9721b {
        C4627a0.m28394g(!this.requestInfos.isEmpty());
        List<BatchRequest.SingleRequest> arrayList = new ArrayList<>();
        for (RequestInfo<?, ?> requestInfo : this.requestInfos) {
            BatchRequest.SingleRequest singleRequest = new BatchRequest.SingleRequest();
            singleRequest.setUrl(requestInfo.request.m28288t().m28200r());
            singleRequest.setHttpMethod(requestInfo.request.m28282n().toLowerCase(Locale.getDefault()));
            C4609l c4609lM28277i = requestInfo.request.m28277i();
            c4609lM28277i.set("x-hw-trace-id", str2);
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : c4609lM28277i.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof List) {
                    map.put(entry.getKey(), (List) value);
                } else {
                    map.put(entry.getKey(), Collections.singletonList(value));
                }
            }
            singleRequest.setHttpHeader(map);
            C11277a c11277a = (C11277a) requestInfo.request.m28274f();
            if (c11277a != null) {
                singleRequest.setHttpBody(c11277a.m67681g());
            }
            arrayList.add(singleRequest);
        }
        execute(arrayList, str, str2);
    }

    public <T, E> CloudBackupV3BatchRequest queue(C4612o c4612o, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) {
        C4627a0.m28391d(c4612o);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        C4627a0.m28391d(interfaceC10510a);
        this.requestInfos.add(new RequestInfo<>(c4612o, interfaceC10510a, cls, cls2));
        return this;
    }

    public int size() {
        return this.requestInfos.size();
    }

    private void execute(List<BatchRequest.SingleRequest> list, String str, String str2) throws C9721b {
        final BatchRequest batchRequest = new BatchRequest();
        batchRequest.setBatchReq(list);
        List<BatchResponse.SingleResponse> batchRes = ((BatchResponse) new C14000c0(new C14000c0.a() { // from class: com.huawei.hicloud.cloudbackup.v3.server.batch.a
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return CloudBackupV3BatchRequest.lambda$execute$0(batchRequest, cloudBackupV3Server);
            }
        }).m84139b(str, str2)).getBatchRes();
        if (batchRes == null || batchRes.size() != this.requestInfos.size()) {
            return;
        }
        Iterator<RequestInfo<?, ?>> it = this.requestInfos.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            try {
                parseAndCallback(it.next(), batchRes.get(i10));
                i10 = i11;
            } catch (IOException e10) {
                throw new C9721b(3911, e10.toString());
            }
        }
    }
}
