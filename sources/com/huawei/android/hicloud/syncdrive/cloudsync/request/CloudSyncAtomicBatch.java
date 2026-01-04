package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchResponse;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
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

/* loaded from: classes3.dex */
public class CloudSyncAtomicBatch {
    private static final String ATOMIC_REST_PATH = "dataSync/v1/atomicBatch";
    private List<AtomicRequestInfo<?, ?>> automicRequestInfos = new ArrayList();
    private Drive client;

    public static class AtomicBatch extends AbstractC9455k<BatchResponse> {

        @InterfaceC4648p
        private Boolean atomic;

        public AtomicBatch(Drive drive, BatchRequest batchRequest) throws IOException {
            super(drive, "POST", CloudSyncAtomicBatch.ATOMIC_REST_PATH, batchRequest, BatchResponse.class);
        }

        public Boolean getAtomic() {
            return this.atomic;
        }

        public AtomicBatch setAtomic(Boolean bool) {
            this.atomic = bool;
            return this;
        }
    }

    public static class AtomicRequestInfo<T, E> {
        final InterfaceC10510a<T, E> callback;
        final Class<T> dataClass;
        final AbstractC9455k request;

        public AtomicRequestInfo(InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2, AbstractC9455k abstractC9455k) {
            this.callback = interfaceC10510a;
            this.dataClass = cls;
            this.request = abstractC9455k;
        }
    }

    public CloudSyncAtomicBatch(Drive drive) {
        this.client = drive;
    }

    private AtomicBatch atomicBatch(BatchRequest batchRequest) throws IOException {
        return new AtomicBatch(this.client, batchRequest);
    }

    private <T> List<T> getAsList(T t10) {
        if (t10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t10);
        return arrayList;
    }

    public void automicExecute() throws Throwable {
        BufferedReader bufferedReader;
        InputStream inputStreamExecuteAsInputStream;
        C4627a0.m28394g(!this.automicRequestInfos.isEmpty());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        InputStream inputStream = null;
        int i10 = 0;
        String str = null;
        while (i10 < this.automicRequestInfos.size()) {
            AtomicRequestInfo<?, ?> atomicRequestInfo = this.automicRequestInfos.get(i10);
            SingleRequest singleRequest = new SingleRequest();
            singleRequest.setHttpBody(atomicRequestInfo.request.getRequestBody());
            String requestDatabase = atomicRequestInfo.request.getRequestDatabase();
            if (!TextUtils.isEmpty(atomicRequestInfo.request.getRequestKind())) {
                hashSet.add(atomicRequestInfo.request.getRequestKind());
            }
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : atomicRequestInfo.request.getHeaders().entrySet()) {
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
            singleRequest.setHttpMethod(atomicRequestInfo.request.getRequestMethod().toLowerCase(Locale.getDefault()));
            String requestUrl = atomicRequestInfo.request.getRequestUrl();
            if (!requestUrl.startsWith("/")) {
                requestUrl = "/" + requestUrl;
            }
            singleRequest.setUrl(requestUrl);
            arrayList.add(singleRequest);
            i10++;
            str = requestDatabase;
        }
        BatchRequest batchRequest = new BatchRequest();
        if (!TextUtils.isEmpty(str)) {
            batchRequest.setDatabase(str);
        }
        if (!hashSet.isEmpty()) {
            batchRequest.setKinds(DriveSyncUtil.m17995g0(hashSet));
        }
        batchRequest.setBatchReq(arrayList);
        AtomicBatch atomicBatch = atomicBatch(batchRequest);
        try {
            C10156g.m63309f(atomicBatch);
            inputStreamExecuteAsInputStream = atomicBatch.executeAsInputStream();
            try {
                C10156g.m63310g(atomicBatch.getLastResponseHeaders());
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
                parseAndCallback(this.automicRequestInfos.get(i11), jSONArray.getJSONObject(i11));
            }
            DriveSyncUtil.m18005o(inputStreamExecuteAsInputStream);
            DriveSyncUtil.m18005o(bufferedReader);
        } catch (JSONException e12) {
            e = e12;
            inputStream = inputStreamExecuteAsInputStream;
            try {
                throw new IOException("json parse exception " + e.toString());
            } catch (Throwable th4) {
                th = th4;
                DriveSyncUtil.m18005o(inputStream);
                DriveSyncUtil.m18005o(bufferedReader);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = inputStreamExecuteAsInputStream;
            DriveSyncUtil.m18005o(inputStream);
            DriveSyncUtil.m18005o(bufferedReader);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T, E> void parseAndCallback(AtomicRequestInfo<T, E> atomicRequestInfo, JSONObject jSONObject) throws JSONException, IOException {
        InterfaceC10510a<T, E> interfaceC10510a = atomicRequestInfo.callback;
        if (interfaceC10510a == 0) {
            return;
        }
        if (jSONObject.has("httpBody")) {
            interfaceC10510a.onSuccess(C11903a.m71435l().mo69832e(new JSONObject(jSONObject.optString("httpBody")).toString()).m69886u(atomicRequestInfo.dataClass), null);
        } else {
            interfaceC10510a.onSuccess(null, null);
        }
    }

    public <T, E> CloudSyncAtomicBatch queue(AbstractC9455k abstractC9455k, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) throws IOException {
        C4627a0.m28391d(abstractC9455k);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        C4627a0.m28391d(interfaceC10510a);
        this.automicRequestInfos.add(new AtomicRequestInfo<>(interfaceC10510a, cls, cls2, abstractC9455k));
        return this;
    }

    public int size() {
        return this.automicRequestInfos.size();
    }
}
