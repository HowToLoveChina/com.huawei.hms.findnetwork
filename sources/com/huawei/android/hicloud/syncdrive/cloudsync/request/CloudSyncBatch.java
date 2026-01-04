package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.C2933l;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchResponse;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.model.SingleRequest;
import fk.C9722c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p255ed.AbstractC9455k;
import p336he.C10156g;
import p369ii.InterfaceC10510a;
import p523oi.C11903a;
import sb.C12767a;

/* loaded from: classes3.dex */
public class CloudSyncBatch {
    private static final int BATCH_BASE = 0;
    private static final int BATCH_LIST = 1;
    private static final String REST_PATH = "dataSync/v1/batch";
    private Drive client;
    private List<RequestInfo<?, ?>> requestInfos = new ArrayList();

    public static class Batch extends AbstractC9455k<BatchResponse> {

        @InterfaceC4648p
        private Boolean atomic;

        public Batch(Drive drive, BatchRequest batchRequest) throws IOException {
            super(drive, "POST", CloudSyncBatch.REST_PATH, batchRequest, BatchResponse.class);
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
        final AbstractC9455k request;

        public RequestInfo(InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2, AbstractC9455k abstractC9455k) {
            this.callback = interfaceC10510a;
            this.dataClass = cls;
            this.errorClass = cls2;
            this.request = abstractC9455k;
        }
    }

    public CloudSyncBatch(Drive drive) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private <T, E> void parseListAndCallback(RequestInfo<T, E> requestInfo, int i10, JSONObject jSONObject) throws JSONException, IOException {
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

    public void execute(String str, String str2, String str3) throws C9722c, IOException {
        try {
            C2933l c2933l = new C2933l();
            c2933l.checkUpgrade();
            c2933l.checkSyncRisk();
            execute(0, str, str2, str3);
        } finally {
            C12767a.m76619c().m76622d(str);
        }
    }

    public <T, E> CloudSyncBatch queue(AbstractC9455k abstractC9455k, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) throws IOException {
        C4627a0.m28391d(abstractC9455k);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        C4627a0.m28391d(interfaceC10510a);
        this.requestInfos.add(new RequestInfo<>(interfaceC10510a, cls, cls2, abstractC9455k));
        return this;
    }

    public int size() {
        return this.requestInfos.size();
    }

    private void execute(int i10, String str, String str2, String str3) throws Throwable {
        BufferedReader bufferedReader;
        C4627a0.m28394g(!this.requestInfos.isEmpty());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        InputStream inputStream = null;
        int i11 = 0;
        String str4 = null;
        while (i11 < this.requestInfos.size()) {
            RequestInfo<?, ?> requestInfo = this.requestInfos.get(i11);
            SingleRequest singleRequest = new SingleRequest();
            singleRequest.setHttpBody(requestInfo.request.getRequestBody());
            String requestDatabase = requestInfo.request.getRequestDatabase();
            if (!TextUtils.isEmpty(requestInfo.request.getRequestKind())) {
                hashSet.add(requestInfo.request.getRequestKind());
            }
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : requestInfo.request.getHeaders().entrySet()) {
                entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    map.put(entry.getKey(), getAsList(entry.getValue()));
                } else {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            singleRequest.setHttpHeader(map);
            singleRequest.setHttpMethod(requestInfo.request.getRequestMethod().toLowerCase(Locale.getDefault()));
            singleRequest.setUrl(requestInfo.request.getRequestUrl());
            arrayList.add(singleRequest);
            i11++;
            str4 = requestDatabase;
        }
        BatchRequest batchRequest = new BatchRequest();
        if (!TextUtils.isEmpty(str4)) {
            batchRequest.setDatabase(str4);
        }
        if (!hashSet.isEmpty()) {
            batchRequest.setKinds(DriveSyncUtil.m17995g0(hashSet));
        }
        batchRequest.setBatchReq(arrayList);
        Batch batch = batch(batchRequest);
        DriveSyncUtil.m17994g(batch.getHeaders(), str3, str, str2);
        try {
            C10156g.m63309f(batch);
            InputStream inputStreamExecuteAsInputStream = batch.executeAsInputStream();
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
                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i12);
                    RequestInfo<?, ?> requestInfo2 = this.requestInfos.get(i12);
                    int i13 = Integer.parseInt(jSONObject.optString("httpCode"));
                    if (i10 == 0) {
                        parseAndCallback(requestInfo2, i13, jSONObject);
                    } else {
                        parseListAndCallback(requestInfo2, i13, jSONObject);
                    }
                }
                DriveSyncUtil.m18005o(inputStreamExecuteAsInputStream);
                DriveSyncUtil.m18005o(bufferedReader);
            } catch (JSONException e11) {
                e = e11;
                inputStream = inputStreamExecuteAsInputStream;
                try {
                    throw new IOException("json parse exception " + e.toString());
                } catch (Throwable th3) {
                    th = th3;
                    DriveSyncUtil.m18005o(inputStream);
                    DriveSyncUtil.m18005o(bufferedReader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStreamExecuteAsInputStream;
                DriveSyncUtil.m18005o(inputStream);
                DriveSyncUtil.m18005o(bufferedReader);
                throw th;
            }
        } catch (JSONException e12) {
            e = e12;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
    }
}
