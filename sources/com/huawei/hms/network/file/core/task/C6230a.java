package com.huawei.hms.network.file.core.task;

import android.text.TextUtils;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.p130a.C6186b;
import com.huawei.hms.network.file.p130a.C6188d;
import com.huawei.hms.network.file.p130a.C6192h;
import com.huawei.hms.network.file.p136b.C6216c;
import com.huawei.hms.network.file.p136b.C6217d;
import com.huawei.hms.network.file.p136b.C6219f;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.file.upload.api.PostRequest;
import com.huawei.hms.network.file.upload.api.PutRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.file.core.task.a */
/* loaded from: classes8.dex */
public class C6230a {

    /* renamed from: a */
    private final C6238i f29410a;

    /* renamed from: b */
    private InterfaceC6234e f29411b;

    /* renamed from: c */
    ExecutorService f29412c;

    /* renamed from: d */
    ExecutorService f29413d;

    /* renamed from: e */
    String f29414e;

    public C6230a(C6238i c6238i, InterfaceC6234e interfaceC6234e, ExecutorService executorService, ExecutorService executorService2, String str) {
        this.f29410a = c6238i;
        this.f29411b = interfaceC6234e;
        this.f29412c = executorService;
        this.f29413d = executorService2;
        this.f29414e = str;
    }

    /* renamed from: a */
    private long m36220a(C6188d c6188d) {
        if (c6188d != null && c6188d.m36341p() != null) {
            RequestConfig config = c6188d.m36341p().getConfig();
            if (config != null && !TextUtils.isEmpty(config.getOptions())) {
                try {
                    return new JSONObject(config.getOptions()).getLong("complete_file_size");
                } catch (JSONException e10) {
                    FLogger.m36355w("ForkTaskFuture", "get complete file size fail " + e10.getMessage(), new Object[0]);
                    return 0L;
                }
            }
            FLogger.m36354v("ForkTaskFuture", "config options is empty");
        }
        return 0L;
    }

    /* renamed from: b */
    private long m36224b(C6188d c6188d) {
        long jM36220a = m36220a(c6188d);
        FLogger.m36354v("ForkTaskFuture", "complete file size is " + jM36220a);
        return jM36220a <= 0 ? c6188d.mo36022a() : jM36220a;
    }

    /* renamed from: a */
    private long m36221a(C6219f c6219f) {
        BodyRequest bodyRequestM36341p = c6219f.m36341p();
        long jContentLength = 0;
        if (bodyRequestM36341p instanceof PutRequest) {
            try {
                jContentLength = new C6216c(c6219f, ((PutRequest) bodyRequestM36341p).getFileEntityList(), null).contentLength();
            } catch (IOException e10) {
                FLogger.m36352e("ForkTaskFuture", "get requestBody contentLength error", e10);
            }
        } else {
            PostRequest postRequest = (PostRequest) bodyRequestM36341p;
            for (String str : postRequest.getFileEntityMap().keySet()) {
                List<FileEntity> list = postRequest.getFileEntityMap().get(str);
                if (list == null || list.isEmpty()) {
                    FLogger.m36355w("ForkTaskFuture", "no FileEntity for:" + str, new Object[0]);
                } else {
                    FLogger.m36350d("ForkTaskFuture", "fileParams for:" + str + ",fileListSize:" + list.size(), new Object[0]);
                    try {
                        jContentLength += new C6216c(c6219f, list, null).contentLength();
                    } catch (IOException e11) {
                        FLogger.m36352e("ForkTaskFuture", "get fileBody contentLength error", e11);
                    }
                }
            }
        }
        FLogger.m36350d("ForkTaskFuture", "upload filesize:" + jContentLength, new Object[0]);
        return jContentLength;
    }

    /* renamed from: b */
    public /* synthetic */ ITaskResult m36225b() {
        InterfaceC6236g interfaceC6236gMo36001b;
        try {
            synchronized (this.f29410a) {
                try {
                    if (this.f29410a.f29450t) {
                        FLogger.m36355w("RequestProcessor", "all task is Canceled, no need to process", new Object[0]);
                        return null;
                    }
                    if (!this.f29410a.m36294b((AbstractC6240k) this.f29411b)) {
                        return null;
                    }
                    FLogger.m36354v("RequestProcessor", "executeTasks currentUrl:" + this.f29410a.f29439i + ",taskSize:" + this.f29410a.f29434d.size());
                    this.f29410a.m36285a(this.f29411b);
                    int i10 = !(this.f29411b instanceof C6188d) ? 1 : 0;
                    if (!m36223a(i10)) {
                        interfaceC6236gMo36001b = this.f29410a.f29433c.mo36001b();
                    } else if (i10 == 0) {
                        String strM36049a = C6192h.m36048f().m36049a(i10, m36224b((C6188d) this.f29411b));
                        FLogger.m36350d("ForkTaskFuture", "protocol = " + strM36049a, new Object[0]);
                        interfaceC6236gMo36001b = ((C6186b) this.f29410a.f29433c).m35988a(strM36049a);
                    } else {
                        String strM36049a2 = C6192h.m36048f().m36049a(i10, m36221a((C6219f) this.f29411b));
                        FLogger.m36350d("ForkTaskFuture", "protocol = " + strM36049a2, new Object[0]);
                        interfaceC6236gMo36001b = ((C6217d) this.f29410a.f29433c).m36149a(strM36049a2);
                    }
                    interfaceC6236gMo36001b.mo36035a(this.f29410a);
                    C6241l c6241l = (C6241l) interfaceC6236gMo36001b.mo36033a((InterfaceC6236g) this.f29411b);
                    if (this.f29410a.f29450t) {
                        FLogger.m36355w("RequestProcessor", "all task is Canceled, no need to finished", new Object[0]);
                        return null;
                    }
                    this.f29410a.m36302h();
                    return c6241l;
                } finally {
                }
            }
        } catch (Throwable th2) {
            synchronized (this.f29410a) {
                try {
                    if (this.f29411b.mo36243h()) {
                        return null;
                    }
                    if (!(th2 instanceof FileManagerException)) {
                        this.f29410a.m36288a(new FileManagerException(Constants.ErrorCode.TASK_UNCACHED_EXCEPTION, th2.getMessage()), this.f29414e);
                        return null;
                    }
                    FLogger.m36355w("RequestProcessor", "future.exceptionally ,exceptionTask:" + this.f29411b, new Object[0]);
                    this.f29410a.m36288a(th2, this.f29414e);
                    return null;
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    private Future<ITaskResult> m36222a(final AbstractC6240k abstractC6240k) {
        return this.f29413d.submit(new Callable() { // from class: com.huawei.hms.network.file.core.task.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C6230a.m36226b(abstractC6240k);
            }
        });
    }

    /* renamed from: b */
    public static /* synthetic */ ITaskResult m36226b(AbstractC6240k abstractC6240k) {
        if (abstractC6240k.m36346u() != null) {
            return abstractC6240k.m36346u();
        }
        C6241l c6241l = new C6241l(Constants.ErrorCode.SUCCESS);
        c6241l.setTask(abstractC6240k);
        c6241l.setRawResponse(null);
        abstractC6240k.m36323a(c6241l);
        return c6241l;
    }

    /* renamed from: a */
    public void m36229a() {
        if (this.f29411b.mo36239c() <= 0 || this.f29411b.mo36022a() <= 0 || this.f29411b.mo36239c() < this.f29411b.mo36022a()) {
            this.f29411b.mo36235a(this.f29412c.submit(new Callable() { // from class: com.huawei.hms.network.file.core.task.n
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f29492a.m36225b();
                }
            }));
            return;
        }
        FLogger.m36353i("RequestProcessor", "taskId:" + this.f29411b.mo36241f() + " already finished before, ingnore", new Object[0]);
        this.f29411b.mo36235a(m36222a((AbstractC6240k) this.f29411b));
        this.f29411b.mo36236a(true);
        this.f29410a.m36285a(this.f29411b);
        this.f29410a.m36302h();
    }

    /* renamed from: a */
    private boolean m36223a(int i10) {
        return C6192h.m36048f().m36052a(i10);
    }
}
