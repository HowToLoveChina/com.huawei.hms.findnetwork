package com.huawei.hms.network.file.p136b;

import android.content.Context;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.C6225c;
import com.huawei.hms.network.file.core.C6227e;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.task.C6239j;
import com.huawei.hms.network.file.core.task.C6241l;
import com.huawei.hms.network.file.core.task.ITaskResult;
import com.huawei.hms.network.file.core.task.InterfaceC6232c;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.PostRequest;
import com.huawei.hms.network.file.upload.api.PutRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.b.d */
/* loaded from: classes8.dex */
public class C6217d implements InterfaceC6232c<BodyRequest, C6219f, C6221h> {

    /* renamed from: a */
    GlobalRequestConfig f29352a;

    /* renamed from: b */
    C6225c f29353b;

    public C6217d(Context context, String str, GlobalRequestConfig globalRequestConfig) {
        this.f29352a = globalRequestConfig;
        this.f29353b = new C6225c(context, globalRequestConfig, str);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public C6221h mo36001b() {
        return new C6221h(this.f29352a, this.f29353b.m36194a());
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c */
    public C6227e<BodyRequest> mo36008c(long j10) {
        return null;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Result mo35984a(BodyRequest bodyRequest) {
        if (!Utils.isUrlValid(bodyRequest.getUrl()) || !Utils.isUrlValid(bodyRequest.getBackupUrls())) {
            return new Result(Constants.ErrorCode.REQUEST_URL_EMPTY);
        }
        if ((bodyRequest instanceof PutRequest) && Utils.isEmpty(((PutRequest) bodyRequest).getFileEntityList())) {
            Constants.ErrorCode errorCode = Constants.ErrorCode.TASK_UPLOAD_PARAMS_COMMON_ERROR;
            return new Result(errorCode.getErrorCode(), errorCode.getErrorMessage() + "fileList can not be empty");
        }
        if (!(bodyRequest instanceof PostRequest) || !((PostRequest) bodyRequest).getFileEntityMap().isEmpty()) {
            return Result.RESULT_SUCCESS;
        }
        Constants.ErrorCode errorCode2 = Constants.ErrorCode.TASK_UPLOAD_PARAMS_COMMON_ERROR;
        return new Result(errorCode2.getErrorCode(), errorCode2.getErrorMessage() + "fileList can not be empty");
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ ITaskResult mo35986a(Request request, List list) {
        return m36148a((BodyRequest) request, (List<C6219f>) list);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public List<C6219f> mo36002b(long j10) {
        return Collections.emptyList();
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c */
    public void mo36010c() {
        this.f29353b.m36199f();
    }

    /* renamed from: a */
    public ITaskResult m36148a(BodyRequest bodyRequest, List<C6219f> list) {
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(list.get(0));
        if (list.get(0).m36346u() != null) {
            c6241l.setRawResponse(list.get(0).m36346u().getRawResponse());
        } else {
            FLogger.m36351e("UploadRequestHandler", "resultResult is null:" + bodyRequest.getId());
        }
        return c6241l;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<C6219f> mo36009c(BodyRequest bodyRequest) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C6219f(bodyRequest));
        return arrayList;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo36004b(BodyRequest bodyRequest) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.network.file.core.task.InterfaceC6236g m36149a(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1575355461(0xffffffffa219fbbb, float:-2.0868632E-18)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L49
            r1 = -1267495076(0xffffffffb4738f5c, float:-2.2683292E-7)
            if (r0 == r1) goto L3f
            if (r0 == 0) goto L35
            switch(r0) {
                case 3273: goto L2b;
                case 3274: goto L21;
                case 3275: goto L17;
                default: goto L16;
            }
        L16:
            goto L53
        L17:
            java.lang.String r0 = "h3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 4
            goto L54
        L21:
            java.lang.String r0 = "h2"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r4
            goto L54
        L2b:
            java.lang.String r0 = "h1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 0
            goto L54
        L35:
            java.lang.String r0 = ""
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = 5
            goto L54
        L3f:
            java.lang.String r0 = "h3_pcc"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r3
            goto L54
        L49:
            java.lang.String r0 = "h3_pcc_multipath"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L53
            r6 = r2
            goto L54
        L53:
            r6 = -1
        L54:
            if (r6 == 0) goto Laf
            if (r6 == r4) goto L98
            if (r6 == r3) goto L81
            if (r6 == r2) goto L6a
            com.huawei.hms.network.file.b.h r6 = new com.huawei.hms.network.file.b.h
            com.huawei.hms.network.file.api.GlobalRequestConfig r0 = r5.f29352a
            com.huawei.hms.network.file.core.c r5 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r5 = r5.m36194a()
            r6.<init>(r0, r5)
            return r6
        L6a:
            com.huawei.hms.network.file.core.c r6 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36198e()
            com.huawei.hms.network.file.b.h r0 = new com.huawei.hms.network.file.b.h
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29352a
            if (r6 == 0) goto L77
            goto L7d
        L77:
            com.huawei.hms.network.file.core.c r5 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        L7d:
            r0.<init>(r1, r6)
            return r0
        L81:
            com.huawei.hms.network.file.core.c r6 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36197d()
            com.huawei.hms.network.file.b.h r0 = new com.huawei.hms.network.file.b.h
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29352a
            if (r6 == 0) goto L8e
            goto L94
        L8e:
            com.huawei.hms.network.file.core.c r5 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        L94:
            r0.<init>(r1, r6)
            return r0
        L98:
            com.huawei.hms.network.file.core.c r6 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36196c()
            com.huawei.hms.network.file.b.h r0 = new com.huawei.hms.network.file.b.h
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29352a
            if (r6 == 0) goto La5
            goto Lab
        La5:
            com.huawei.hms.network.file.core.c r5 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        Lab:
            r0.<init>(r1, r6)
            return r0
        Laf:
            com.huawei.hms.network.file.core.c r6 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r6.m36195b()
            com.huawei.hms.network.file.b.h r0 = new com.huawei.hms.network.file.b.h
            com.huawei.hms.network.file.api.GlobalRequestConfig r1 = r5.f29352a
            if (r6 == 0) goto Lbc
            goto Lc2
        Lbc:
            com.huawei.hms.network.file.core.c r5 = r5.f29353b
            com.huawei.hms.network.httpclient.HttpClient r6 = r5.m36194a()
        Lc2:
            r0.<init>(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.p136b.C6217d.m36149a(java.lang.String):com.huawei.hms.network.file.core.task.g");
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public C6239j mo35989a() {
        return new C6218e(this);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ List mo35990a(Request request, List list, long j10) {
        return m36150a((BodyRequest) request, (List<C6219f>) list, j10);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo36005b(BodyRequest bodyRequest, InterfaceC6234e.a aVar) {
    }

    /* renamed from: a */
    public List<C6219f> m36150a(BodyRequest bodyRequest, List<C6219f> list, long j10) {
        return null;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: b */
    public void mo36007b(List<C6219f> list) {
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public List<BodyRequest> mo35992a(boolean z10) {
        return null;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public Set<Long> mo35993a(int i10) {
        return null;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public void mo35994a(long j10) {
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public void mo35996a(long j10, boolean z10) {
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo35998a(BodyRequest bodyRequest, InterfaceC6234e.a aVar) {
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6232c
    /* renamed from: a */
    public boolean mo36000a(List<C6219f> list) {
        return true;
    }
}
