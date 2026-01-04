package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.BatchRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.BatchResponse;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.SingleRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1122c;
import p336he.C10156g;
import p369ii.InterfaceC10510a;
import p523oi.C11903a;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class CloudPhotoBatch {
    private static final String REST_PATH = "cloudPhoto/v1/batch";
    private Drive client;
    private boolean isAlbumClient;
    private List<RequestInfo<?, ?>> requestInfos = new ArrayList();

    public static class Batch extends AbstractC13930g<BatchResponse> {

        @InterfaceC4648p
        private Boolean atomic;

        public Batch(Drive drive, BatchRequest batchRequest) throws IOException {
            super(drive, "POST", CloudPhotoBatch.REST_PATH, batchRequest, BatchResponse.class);
        }

        public Boolean getAtomic() {
            return this.atomic;
        }

        public Batch setAtomic(Boolean bool) {
            this.atomic = bool;
            return this;
        }
    }

    public static class RequestInfo<T, E> {
        final InterfaceC10510a<T, E> callback;
        final Class<T> dataClass;
        final Class<E> errorClass;
        final AbstractC13930g request;

        public RequestInfo(InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2, AbstractC13930g abstractC13930g) {
            this.callback = interfaceC10510a;
            this.dataClass = cls;
            this.errorClass = cls2;
            this.request = abstractC13930g;
        }
    }

    public CloudPhotoBatch(Drive drive) {
        this.client = drive;
    }

    private Batch batch(BatchRequest batchRequest) throws IOException {
        return new Batch(this.client, batchRequest);
    }

    private <T> List<T> getAsList(T t10) {
        if (t10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t10);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T, E> void parseAndCallback(RequestInfo<T, E> requestInfo, int i10, JSONObject jSONObject) throws JSONException, IOException {
        InterfaceC10510a<T, E> interfaceC10510a = requestInfo.callback;
        if (interfaceC10510a == 0) {
            return;
        }
        C4609l c4609l = (C4609l) C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString("httpHeader")).toString()).m69886u(C4609l.class);
        if (C4618u.m28333b(i10)) {
            if (jSONObject.has("httpBody")) {
                interfaceC10510a.onSuccess(C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString("httpBody")).toString()).m69886u(requestInfo.dataClass), c4609l);
                return;
            } else {
                interfaceC10510a.onSuccess(null, c4609l);
                return;
            }
        }
        if (jSONObject.has("httpBody")) {
            interfaceC10510a.onFailure(C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString("httpBody")).toString()).m69886u(requestInfo.errorClass), c4609l);
        } else {
            interfaceC10510a.onFailure(null, c4609l);
        }
    }

    public void execute() throws Throwable {
        BufferedReader bufferedReader;
        InputStream inputStreamExecuteAsInputStream;
        C4627a0.m28394g(!this.requestInfos.isEmpty());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.requestInfos.size(); i10++) {
            RequestInfo<?, ?> requestInfo = this.requestInfos.get(i10);
            SingleRequest singleRequest = new SingleRequest();
            singleRequest.setHttpBody(requestInfo.request.getRequestBody());
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : requestInfo.request.getHeaders().entrySet()) {
                entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    map.put(entry.getKey(), entry.getValue());
                } else {
                    map.put(entry.getKey(), getAsList(entry.getValue()));
                }
            }
            singleRequest.setHttpHeader(map);
            singleRequest.setHttpMethod(requestInfo.request.getRequestMethod().toLowerCase(Locale.getDefault()));
            singleRequest.setUrl("/" + requestInfo.request.getRequestUrl());
            arrayList.add(singleRequest);
        }
        BatchRequest batchRequest = new BatchRequest();
        batchRequest.setBatchReq(arrayList);
        Batch batch = batch(batchRequest);
        if (this.isAlbumClient) {
            batch.setAlbumClientHeader(C1122c.m6755Z0("04019"));
        }
        InputStream inputStream = null;
        try {
            C10156g.m63309f(batch);
            inputStreamExecuteAsInputStream = batch.executeAsInputStream();
            try {
                C10156g.m63310g(batch.getLastResponseHeaders());
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamExecuteAsInputStream, Charset.defaultCharset()));
            } catch (JSONException e10) {
                e = e10;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (JSONException e11) {
            e = e11;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb2.append(line);
                }
            }
            JSONArray jSONArray = new JSONObject(sb2.toString()).getJSONArray("batchRes");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                parseAndCallback(this.requestInfos.get(i11), Integer.parseInt(jSONObject.optString("httpCode")), jSONObject);
            }
            C1122c.m6832t(inputStreamExecuteAsInputStream);
            C1122c.m6832t(bufferedReader);
        } catch (JSONException e12) {
            e = e12;
            inputStream = inputStreamExecuteAsInputStream;
            try {
                throw new IOException("json parse exception " + e.toString());
            } catch (Throwable th4) {
                th = th4;
                C1122c.m6832t(inputStream);
                C1122c.m6832t(bufferedReader);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = inputStreamExecuteAsInputStream;
            C1122c.m6832t(inputStream);
            C1122c.m6832t(bufferedReader);
            throw th;
        }
    }

    public boolean isAlbumClient() {
        return this.isAlbumClient;
    }

    public <T, E> CloudPhotoBatch queue(AbstractC13930g abstractC13930g, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) throws IOException {
        C4627a0.m28391d(abstractC13930g);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        C4627a0.m28391d(interfaceC10510a);
        this.requestInfos.add(new RequestInfo<>(interfaceC10510a, cls, cls2, abstractC13930g));
        return this;
    }

    public void setAlbumClient(boolean z10) {
        this.isAlbumClient = z10;
    }

    public int size() {
        return this.requestInfos.size();
    }
}
