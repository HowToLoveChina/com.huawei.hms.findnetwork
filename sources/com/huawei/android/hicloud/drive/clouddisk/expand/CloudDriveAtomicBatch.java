package com.huawei.android.hicloud.drive.clouddisk.expand;

import bb.C1160a;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.BatchResponse;
import com.huawei.android.hicloud.drive.clouddisk.model.SingleRequest;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import java.io.BufferedReader;
import java.io.Closeable;
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
import p015ak.C0241z;
import p336he.C10156g;
import p369ii.InterfaceC10510a;
import p514o9.C11839m;
import p523oi.C11903a;

/* loaded from: classes3.dex */
public class CloudDriveAtomicBatch {
    private static final int DEFAULT_CURSOR = -1;
    private static final String HTTP_BODY = "httpBody";
    private static final String HTTP_HEADER = "httpHeader";
    private static final String REST_PATH = "atomicBatch";
    private static final String TAG = "CloudDriveAtomicBatch";
    private String baseCursor;
    private Drive client;
    private C4609l extraHeaders;
    private String newCursor;
    private List<RequestInfo<?, ?>> requestInfos = new ArrayList();

    public static class AtomicBatch extends DriveRequest<BatchResponse> {

        @InterfaceC4648p
        private Integer baseCursor;

        public AtomicBatch(Drive drive, BatchRequest batchRequest) {
            super(drive, "POST", CloudDriveAtomicBatch.REST_PATH, batchRequest, BatchResponse.class);
        }

        public Integer getBaseCursor() {
            return this.baseCursor;
        }

        public AtomicBatch setBaseCursor(Integer num) {
            this.baseCursor = num;
            return this;
        }
    }

    public static class RequestInfo<T, E> {
        final InterfaceC10510a<T, E> callback;
        final Class<T> dataClass;
        final Class<E> errorClass;
        final CloudDriveRequest request;

        public RequestInfo(InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2, CloudDriveRequest cloudDriveRequest) {
            this.callback = interfaceC10510a;
            this.dataClass = cls;
            this.errorClass = cls2;
            this.request = cloudDriveRequest;
        }
    }

    public CloudDriveAtomicBatch(Drive drive, String str, C4609l c4609l) {
        this.client = drive;
        this.baseCursor = str;
        this.extraHeaders = c4609l;
    }

    private AtomicBatch batch(BatchRequest batchRequest) throws IOException {
        AtomicBatch atomicBatch = new AtomicBatch(this.client, batchRequest);
        this.client.initialize(atomicBatch);
        int iM1686d = C0241z.m1686d(this.baseCursor, -1);
        if (iM1686d != -1) {
            atomicBatch.setBaseCursor(Integer.valueOf(iM1686d));
        }
        return atomicBatch;
    }

    private void closeSilently(Closeable closeable) throws IOException {
        if (closeable == null) {
            C11839m.m70686d(TAG, "closeable is already null");
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            C11839m.m70687e(TAG, "close failed: " + e10.toString());
        }
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
        C4609l c4609l;
        InterfaceC10510a<T, E> interfaceC10510a = requestInfo.callback;
        if (interfaceC10510a == 0) {
            return;
        }
        if (jSONObject.has(HTTP_HEADER)) {
            try {
                c4609l = (C4609l) C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString(HTTP_HEADER)).toString()).m69886u(C4609l.class);
            } catch (Exception unused) {
                C11839m.m70687e(TAG, "parse httpHeader fail");
            }
        } else {
            c4609l = null;
        }
        if (C4618u.m28333b(i10)) {
            if (jSONObject.has(HTTP_BODY)) {
                interfaceC10510a.onSuccess(C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString(HTTP_BODY)).toString()).m69886u(requestInfo.dataClass), c4609l);
                return;
            } else {
                interfaceC10510a.onSuccess(null, c4609l);
                return;
            }
        }
        if (jSONObject.has(HTTP_BODY)) {
            interfaceC10510a.onFailure(C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString(HTTP_BODY)).toString()).m69886u(requestInfo.errorClass), c4609l);
        } else {
            interfaceC10510a.onFailure(null, c4609l);
        }
    }

    public void execute() throws Throwable {
        BufferedReader bufferedReader;
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
            singleRequest.setUrl(requestInfo.request.getRequestUrl());
            arrayList.add(singleRequest);
        }
        BatchRequest batchRequest = new BatchRequest();
        batchRequest.setBatchReq(arrayList);
        AtomicBatch atomicBatchBatch = batch(batchRequest);
        InputStream inputStream = null;
        try {
            C4609l headers = atomicBatchBatch.getHeaders();
            C10156g.m63307d(headers, atomicBatchBatch.buildHttpRequestUrl());
            C1160a.m7250a(headers);
            Map<? extends String, ?> map2 = this.extraHeaders;
            if (map2 != null) {
                headers.putAll(map2);
            }
            InputStream inputStreamExecuteAsInputStream = atomicBatchBatch.executeAsInputStream();
            try {
                C10156g.m63310g(atomicBatchBatch.getLastResponseHeaders());
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamExecuteAsInputStream, Charset.defaultCharset()));
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
                    C11839m.m70686d(TAG, "batchRes jsonArray: " + jSONArray.toString());
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        parseAndCallback(this.requestInfos.get(i11), atomicBatchBatch.getLastStatusCode(), jSONArray.getJSONObject(i11));
                    }
                    this.newCursor = C1160a.m7251b(atomicBatchBatch.getLastResponseHeaders());
                    closeSilently(inputStreamExecuteAsInputStream);
                    closeSilently(bufferedReader);
                } catch (JSONException e10) {
                    e = e10;
                    inputStream = inputStreamExecuteAsInputStream;
                    try {
                        throw new IOException("json parse exception " + e.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        closeSilently(inputStream);
                        closeSilently(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStreamExecuteAsInputStream;
                    closeSilently(inputStream);
                    closeSilently(bufferedReader);
                    throw th;
                }
            } catch (JSONException e11) {
                e = e11;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (JSONException e12) {
            e = e12;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
    }

    public String getNewCursor() {
        return this.newCursor;
    }

    public <T, E> CloudDriveAtomicBatch queue(CloudDriveRequest cloudDriveRequest, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) {
        C4627a0.m28391d(cloudDriveRequest);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        C4627a0.m28391d(interfaceC10510a);
        this.requestInfos.add(new RequestInfo<>(interfaceC10510a, cls, cls2, cloudDriveRequest));
        return this;
    }

    public int size() {
        return this.requestInfos.size();
    }
}
