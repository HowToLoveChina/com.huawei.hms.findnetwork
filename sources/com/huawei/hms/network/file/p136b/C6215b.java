package com.huawei.hms.network.file.p136b;

import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.network.base.common.MediaType;
import com.huawei.hms.network.base.common.MultipartBody;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.InterfaceC6231b;
import com.huawei.hms.network.file.core.task.InterfaceC6235f;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.file.upload.api.PostRequest;
import com.huawei.hms.network.file.upload.api.PutRequest;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.file.b.b */
/* loaded from: classes8.dex */
public class C6215b implements InterfaceC6231b<BodyRequest, C6219f> {

    /* renamed from: e */
    static final MediaType f29343e = MediaType.parse(RequestBody.HEAD_VALUE_CONTENT_TYPE_FORM_DATA);

    /* renamed from: a */
    GlobalRequestConfig f29344a;

    /* renamed from: b */
    C6220g f29345b;

    /* renamed from: c */
    C6219f f29346c;

    /* renamed from: d */
    HttpClient f29347d;

    public C6215b(GlobalRequestConfig globalRequestConfig, HttpClient httpClient) {
        this.f29344a = globalRequestConfig;
        this.f29347d = httpClient;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6231b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Closeable mo35975a(C6219f c6219f, InterfaceC6235f interfaceC6235f) throws JSONException {
        com.huawei.hms.network.httpclient.RequestBody requestBodyBuild;
        this.f29346c = c6219f;
        this.f29345b = new C6220g(this.f29344a, this.f29347d);
        BodyRequest bodyRequestM36341p = c6219f.m36341p();
        long jContentLength = 0;
        if (bodyRequestM36341p instanceof PutRequest) {
            requestBodyBuild = new C6216c(c6219f, ((PutRequest) bodyRequestM36341p).getFileEntityList(), interfaceC6235f);
            try {
                jContentLength = requestBodyBuild.contentLength();
            } catch (IOException e10) {
                FLogger.m36352e("UploadImpl", "get requestBody contentLength error", e10);
            }
        } else {
            PostRequest postRequest = (PostRequest) bodyRequestM36341p;
            MultipartBody.Builder type = new MultipartBody.Builder().setType(f29343e);
            if (!postRequest.getParams().isEmpty()) {
                for (Map.Entry<String, String> entry : postRequest.getParams().entrySet()) {
                    FLogger.m36350d("UploadImpl", "FormDataPart:" + entry, new Object[0]);
                    type.addFormDataPart(entry.getKey(), entry.getValue());
                }
            }
            for (String str : postRequest.getFileEntityMap().keySet()) {
                List<FileEntity> list = postRequest.getFileEntityMap().get(str);
                if (list == null || list.isEmpty()) {
                    FLogger.m36355w("UploadImpl", "no FileEntity for:" + str, new Object[0]);
                } else {
                    FLogger.m36350d("UploadImpl", "fileParams for:" + str + ",fileListSize:" + list.size(), new Object[0]);
                    String name = list.get(0).getName();
                    String fileName = list.get(0).getFileName();
                    C6216c c6216c = new C6216c(c6219f, list, interfaceC6235f);
                    try {
                        jContentLength += c6216c.contentLength();
                    } catch (IOException e11) {
                        FLogger.m36352e("UploadImpl", "get fileBody contentLength error", e11);
                    }
                    type.addFormDataPart(name, fileName, c6216c);
                }
            }
            requestBodyBuild = type.build();
        }
        c6219f.m36161e(jContentLength);
        Response responseM36167a = this.f29345b.m36167a(requestBodyBuild, c6219f, interfaceC6235f);
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(c6219f);
        c6241l.setRawResponse(responseM36167a);
        this.f29346c.m36323a(c6241l);
        m36143a(responseM36167a.getCode());
        return responseM36167a;
    }

    /* renamed from: a */
    private void m36143a(int i10) {
        String str;
        if (i10 == -1) {
            throw new FileManagerException(Constants.ErrorCode.SERVER_EXCEPTION, " upload failed,response null");
        }
        if (i10 != 416) {
            if (i10 / 100 == 2) {
                return;
            }
            throw new FileManagerException(i10, "thread Upload failed:bad http response [responseCode=" + i10 + "]");
        }
        if (this.f29346c != null) {
            str = "server file is wrong : 416 response [name= " + this.f29346c.mo36241f() + ", uploadSize=" + this.f29346c.mo36022a() + "]";
        } else {
            str = "server file is wrong : 416 response";
        }
        throw new FileManagerException(i10, str);
    }
}
