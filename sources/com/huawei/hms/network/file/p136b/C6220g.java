package com.huawei.hms.network.file.p136b;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.util.C6252b;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.PostRequest;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.file.b.g */
/* loaded from: classes8.dex */
public class C6220g {

    /* renamed from: a */
    private HttpClient f29359a;

    /* renamed from: b */
    private GlobalRequestConfig f29360b;

    /* renamed from: c */
    private InterfaceC6235f f29361c;

    public C6220g(GlobalRequestConfig globalRequestConfig, HttpClient httpClient) {
        this.f29359a = httpClient;
        this.f29360b = globalRequestConfig;
    }

    /* renamed from: a */
    private Response m36165a(RequestBody requestBody, C6219f c6219f) throws JSONException, IOException {
        String str = c6219f.m36341p() instanceof PostRequest ? "POST" : "PUT";
        FLogger.m36353i("UploadUtils", "callUpload method:" + str, new Object[0]);
        Request.Builder builderUrl = this.f29359a.newRequest().url(c6219f.m36347v());
        builderUrl.options(Utils.convertToJsonString(this.f29360b));
        Set<Map.Entry<String, String>> setEntrySet = c6219f.m36341p().getHeaders().entrySet();
        if (setEntrySet.size() > 0) {
            for (Map.Entry<String, String> entry : setEntrySet) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        HashMap map = new HashMap();
        if (!c6219f.m36341p().getReportInfos().isEmpty()) {
            map.putAll(c6219f.m36341p().getReportInfos());
        }
        if (!map.containsKey("trace_id")) {
            map.put("trace_id", String.valueOf(c6219f.m36341p().getId()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (map.containsKey("trace_id")) {
                jSONObject.put("trace_id", map.get("trace_id"));
            }
            if (map.containsKey(C6148x2.DEVICE_ID)) {
                jSONObject.put(C6148x2.DEVICE_ID, map.get(C6148x2.DEVICE_ID));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("metrics_data", jSONObject);
            builderUrl.options(jSONObject2.toString());
        } catch (JSONException unused) {
            FLogger.m36351e("UploadUtils", "callUpload requestBuilder.options exception");
        }
        builderUrl.method(str);
        builderUrl.requestBody(requestBody);
        Submit<ResponseBody> submitNewSubmit = this.f29359a.newSubmit(builderUrl.build());
        InterfaceC6235f interfaceC6235f = this.f29361c;
        if (interfaceC6235f != null) {
            interfaceC6235f.mo36244a((Submit) submitNewSubmit);
        }
        c6219f.m36158b(System.currentTimeMillis());
        Response<ResponseBody> responseExecute = submitNewSubmit.execute();
        m36169a(submitNewSubmit, c6219f);
        return responseExecute;
    }

    /* renamed from: b */
    private int m36166b(AbstractC6240k<BodyRequest> abstractC6240k) {
        if (((BodyRequest) abstractC6240k.m36341p()).getConfig() == null || this.f29360b.getRetryTimes() == -100) {
            return 0;
        }
        return this.f29360b.getRetryTimes();
    }

    /* renamed from: a */
    public Response m36167a(RequestBody requestBody, C6219f c6219f, InterfaceC6235f interfaceC6235f) throws JSONException {
        this.f29361c = interfaceC6235f;
        IOException e10 = null;
        if (this.f29359a == null || TextUtils.isEmpty(c6219f.m36347v())) {
            return null;
        }
        int iM36166b = m36166b(c6219f);
        String message = "IO exception";
        int i10 = 0;
        int iM36358a = 0;
        while (i10 <= iM36166b && !c6219f.mo36243h()) {
            m36168a(c6219f);
            try {
                FLogger.m36353i("UploadUtils", "before connect, task:" + c6219f.m36341p().getId() + ", taskFileTotalSize:" + c6219f.mo36022a() + ",configRetryCount:" + iM36166b + ",sliceRetryCount:" + i10, new Object[0]);
                Response responseM36165a = m36165a(requestBody, c6219f);
                c6219f.m36162f(System.currentTimeMillis() - c6219f.m36163y());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("upload responsecode:");
                sb2.append(responseM36165a.getCode());
                FLogger.m36353i("UploadUtils", sb2.toString(), new Object[0]);
                return responseM36165a;
            } catch (IOException e11) {
                e10 = e11;
                if (!(e10.getCause() instanceof FileManagerException)) {
                    if (!TextUtils.isEmpty(message)) {
                        message = e10.getMessage();
                    }
                    iM36358a = C6252b.m36358a(e10);
                    if (!C6252b.m36360a((Throwable) e10)) {
                        break;
                    }
                    i10++;
                } else {
                    throw ((FileManagerException) Utils.cast(e10.getCause()));
                }
            }
        }
        FLogger.m36355w("UploadUtils", "doWithIOException failed, retrycount=" + i10 + ", code=" + iM36358a, new Object[0]);
        c6219f.m36321a(i10);
        throw new FileManagerException(iM36358a, message, e10);
    }

    /* renamed from: a */
    public void m36168a(AbstractC6240k<BodyRequest> abstractC6240k) {
        abstractC6240k.m36322a(0L);
    }

    /* renamed from: a */
    public void m36169a(Submit submit, AbstractC6240k<BodyRequest> abstractC6240k) {
        if (submit != null) {
            try {
                if (submit.getRequestFinishedInfo() != null) {
                    abstractC6240k.m36328b(submit.getRequestFinishedInfo());
                }
            } catch (RuntimeException unused) {
                FLogger.m36355w("UploadUtils", "collectFinishedInfo RuntimeException", new Object[0]);
            } catch (Exception unused2) {
                FLogger.m36355w("UploadUtils", "collectFinishedInfo exception", new Object[0]);
            }
        }
    }
}
