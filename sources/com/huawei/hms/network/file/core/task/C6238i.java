package com.huawei.hms.network.file.core.task;

import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.embedded.C6018n2;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.Callback;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.C6223a;
import com.huawei.hms.network.file.core.C6226d;
import com.huawei.hms.network.file.core.C6228f;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.C6252b;
import com.huawei.hms.network.file.core.util.C6256f;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p136b.C6219f;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Submit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.huawei.hms.network.file.core.task.i */
/* loaded from: classes8.dex */
public class C6238i<R extends Request> implements InterfaceC6235f<AbstractC6240k<R>> {

    /* renamed from: a */
    volatile R f29431a;

    /* renamed from: b */
    Callback f29432b;

    /* renamed from: c */
    InterfaceC6232c f29433c;

    /* renamed from: d */
    volatile List<AbstractC6240k> f29434d;

    /* renamed from: f */
    C6226d f29436f;

    /* renamed from: g */
    List<String> f29437g;

    /* renamed from: j */
    C6237h f29440j;

    /* renamed from: k */
    ExecutorService f29441k;

    /* renamed from: l */
    ExecutorService f29442l;

    /* renamed from: m */
    ExecutorService f29443m;

    /* renamed from: o */
    C6239j f29445o;

    /* renamed from: s */
    int f29449s;

    /* renamed from: u */
    C6256f f29451u;

    /* renamed from: w */
    RequestFinishedInfo f29453w;

    /* renamed from: x */
    volatile Throwable f29454x;

    /* renamed from: y */
    volatile Submit f29455y;

    /* renamed from: z */
    String f29456z;

    /* renamed from: e */
    private final Object f29435e = new Object();

    /* renamed from: h */
    int f29438h = 0;

    /* renamed from: i */
    volatile String f29439i = "";

    /* renamed from: n */
    volatile long f29444n = 0;

    /* renamed from: p */
    private C6223a f29446p = C6223a.m36172a();

    /* renamed from: q */
    volatile boolean f29447q = false;

    /* renamed from: r */
    volatile boolean f29448r = false;

    /* renamed from: t */
    volatile boolean f29450t = false;

    /* renamed from: v */
    private final Object f29452v = new Object();

    /* renamed from: A */
    private boolean f29430A = false;

    public C6238i(R r10, InterfaceC6232c interfaceC6232c, Callback callback, C6226d c6226d, C6228f c6228f) {
        m36269c((C6238i<R>) r10);
        this.f29433c = interfaceC6232c;
        this.f29445o = interfaceC6232c.mo35989a();
        this.f29432b = callback;
        this.f29436f = c6226d;
        this.f29441k = c6228f.m36218d();
        this.f29442l = c6228f.m36217c();
        this.f29443m = c6228f.m36215a();
        this.f29449s = c6228f.m36216b();
        this.f29451u = new C6256f(c6226d);
    }

    /* renamed from: l */
    private String m36275l() {
        if (Utils.isEmpty(this.f29437g)) {
            this.f29437g = m36276m();
        }
        if (this.f29438h >= this.f29437g.size()) {
            return null;
        }
        FLogger.m36353i("RequestProcessor", "getNextUrl urlIndex :" + this.f29438h, new Object[0]);
        List<String> list = this.f29437g;
        int i10 = this.f29438h;
        this.f29438h = i10 + 1;
        return list.get(i10);
    }

    /* renamed from: m */
    private List<String> m36276m() {
        ArrayList arrayList = new ArrayList();
        if (Utils.isUrlValid(this.f29431a.getUrl())) {
            arrayList.add(this.f29431a.getUrl());
        }
        if (Utils.isUrlValid(this.f29431a.getBackupUrls())) {
            arrayList.addAll(this.f29431a.getBackupUrls());
        }
        return arrayList;
    }

    /* renamed from: n */
    private synchronized boolean m36277n() {
        C6237h c6237h = this.f29440j;
        if (c6237h != null) {
            if (c6237h.m36255e()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    private void m36278o() {
        m36292a((Throwable) new CancellationException("task is Interrupt"));
    }

    /* renamed from: f */
    public boolean m36300f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f29431a.getUrl());
        if (!Utils.isEmpty(this.f29431a.getBackupUrls())) {
            arrayList.addAll(this.f29431a.getBackupUrls());
        }
        return !Utils.isDeepEqual(arrayList, this.f29437g);
    }

    /* renamed from: g */
    public void m36301g() {
        FLogger.m36353i("RequestProcessor", "notifyRequestFinished", new Object[0]);
        this.f29436f.m36208a(this.f29431a);
    }

    /* renamed from: h */
    public synchronized void m36302h() {
        C6237h c6237h;
        InterfaceC6234e.a aVarM36298d = m36298d();
        FLogger.m36355w("RequestProcessor", "onFinished status:" + aVarM36298d, new Object[0]);
        if (aVarM36298d != InterfaceC6234e.a.PROCESS) {
            return;
        }
        if (this.f29447q && (c6237h = this.f29440j) != null && !c6237h.m36254d()) {
            FLogger.m36353i("RequestProcessor", "task is finished", new Object[0]);
            return;
        }
        for (AbstractC6240k abstractC6240k : this.f29434d) {
            FLogger.m36350d("RequestProcessor", "task is Finished:" + abstractC6240k.mo36238b(), new Object[0]);
            if (!abstractC6240k.mo36238b()) {
                FLogger.m36355w("RequestProcessor", "task is still process", new Object[0]);
                return;
            }
        }
        this.f29447q = true;
        if (this.f29453w != null) {
            AbstractC6240k.m36318a(this.f29434d, this.f29453w);
        }
        C6237h c6237h2 = new C6237h(this, this.f29434d, this.f29443m);
        this.f29440j = c6237h2;
        c6237h2.m36253c();
    }

    /* renamed from: i */
    public synchronized Result m36303i() {
        boolean zM36277n = m36277n();
        FLogger.m36353i("RequestProcessor", "pause request:" + this.f29431a.getId() + ",isTaskExecuteFinished:" + zM36277n, new Object[0]);
        if (zM36277n) {
            return Result.RESULT_STATUS_FAILED;
        }
        this.f29445o.m36313c((C6239j) this.f29431a);
        this.f29448r = false;
        m36293b();
        C6237h c6237h = this.f29440j;
        if (c6237h != null) {
            c6237h.m36250a();
        }
        m36278o();
        return Result.RESULT_SUCCESS;
    }

    /* renamed from: j */
    public void m36304j() {
        this.f29444n = 0L;
    }

    /* renamed from: k */
    public Result m36305k() {
        FLogger.m36353i("RequestProcessor", "requestProcessor start:" + this.f29431a.getId(), new Object[0]);
        Result resultMo35984a = this.f29433c.mo35984a((InterfaceC6232c) this.f29431a);
        if (resultMo35984a.getCode() != Constants.ErrorCode.SUCCESS.getErrorCode()) {
            FLogger.m36351e("RequestProcessor", "start checkParams failed:" + resultMo35984a);
            return resultMo35984a;
        }
        this.f29433c.mo36004b((InterfaceC6232c) this.f29431a);
        this.f29434d = m36272d(this.f29433c.mo36009c((InterfaceC6232c) this.f29431a));
        m36290a(true);
        this.f29445o.m36314d(this.f29431a);
        this.f29446p.m36176c(this.f29431a.getId());
        return resultMo35984a;
    }

    /* renamed from: b */
    private Response m36264b(int i10) {
        if (this.f29434d.size() > 0) {
            AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(this.f29434d);
            if (abstractC6240kM36317a.m36346u() != null) {
                return new Response(i10, this.f29431a, abstractC6240kM36317a.m36346u().getRawResponse(), null);
            }
        }
        return new Response(i10, this.f29431a, null, null);
    }

    /* renamed from: a */
    public Request m36279a(R r10) {
        try {
            return this.f29432b.onStart(r10);
        } catch (Throwable th2) {
            FLogger.m36352e("RequestProcessor", "customRequestCallback.onStart exception", th2);
            return null;
        }
    }

    /* renamed from: c */
    public R m36297c() {
        R r10;
        synchronized (this.f29452v) {
            r10 = this.f29431a;
        }
        return r10;
    }

    /* renamed from: d */
    public InterfaceC6234e.a m36298d() {
        return this.f29445o.m36312c();
    }

    /* renamed from: e */
    public synchronized boolean m36299e() {
        return this.f29454x != null;
    }

    /* renamed from: c */
    private Response m36268c(List<ITaskResult> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (ITaskResult iTaskResult : list) {
            if (iTaskResult.getRawResponse() != null) {
                return new Response(iTaskResult.getErrorCode(), this.f29431a, iTaskResult.getRawResponse(), null);
            }
        }
        return new Response(list.get(0).getErrorCode(), this.f29431a, null, null);
    }

    /* renamed from: d */
    private List<AbstractC6240k> m36272d(List<AbstractC6240k> list) {
        return (list == null || list.size() <= 0) ? list : Collections.synchronizedList(list);
    }

    /* renamed from: a */
    public synchronized Result m36280a() {
        boolean zM36277n = m36277n();
        FLogger.m36353i("RequestProcessor", "cancel request:" + this.f29431a.getId() + ",isTaskExecuteFinished:" + zM36277n, new Object[0]);
        if (zM36277n) {
            return Result.RESULT_STATUS_FAILED;
        }
        InterfaceC6234e.a aVarM36298d = m36298d();
        this.f29445o.m36310b((C6239j) this.f29431a);
        if (aVarM36298d != InterfaceC6234e.a.PAUSE) {
            m36293b();
            C6237h c6237h = this.f29440j;
            if (c6237h != null) {
                c6237h.m36250a();
            }
        }
        this.f29433c.mo35994a(this.f29431a.getId());
        m36278o();
        return Result.RESULT_SUCCESS;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x002e A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m36293b() {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 1
            r7.f29450t = r0     // Catch: java.lang.Throwable -> L65
            java.lang.String r1 = "RequestProcessor"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r2.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r3 = "cancelTasks isTaskNull:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L65
            java.util.List<com.huawei.hms.network.file.core.task.k> r3 = r7.f29434d     // Catch: java.lang.Throwable -> L65
            r4 = 0
            if (r3 != 0) goto L17
            r3 = r0
            goto L18
        L17:
            r3 = r4
        L18:
            r2.append(r3)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L65
            com.huawei.hms.network.file.core.util.FLogger.m36355w(r1, r2, r3)     // Catch: java.lang.Throwable -> L65
            java.util.List<com.huawei.hms.network.file.core.task.k> r1 = r7.f29434d     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto La5
            java.util.List<com.huawei.hms.network.file.core.task.k> r1 = r7.f29434d     // Catch: java.lang.Throwable -> L65
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L65
        L2e:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto La5
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L65
            com.huawei.hms.network.file.core.task.e r2 = (com.huawei.hms.network.file.core.task.InterfaceC6234e) r2     // Catch: java.lang.Throwable -> L65
            r2.mo36237b(r0)     // Catch: java.lang.Throwable -> L65
            com.huawei.hms.network.httpclient.Submit r3 = r7.f29455y     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L78
            com.huawei.hms.network.httpclient.Submit r3 = r7.f29455y     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            r3.cancel()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            java.lang.String r3 = "RequestProcessor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            r5.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            java.lang.String r6 = "submit.cancel state:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            com.huawei.hms.network.httpclient.Submit r6 = r7.f29455y     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            boolean r6 = r6.isCanceled()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            r5.append(r6)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            com.huawei.hms.network.file.core.util.FLogger.m36353i(r3, r5, r6)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67 java.lang.RuntimeException -> L69
            goto L78
        L65:
            r0 = move-exception
            goto La7
        L67:
            r3 = move-exception
            goto L6b
        L69:
            r3 = move-exception
            goto L73
        L6b:
            java.lang.String r5 = "RequestProcessor"
            java.lang.String r6 = "submit.cancel exception"
        L6f:
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r5, r6, r3)     // Catch: java.lang.Throwable -> L65
            goto L78
        L73:
            java.lang.String r5 = "RequestProcessor"
            java.lang.String r6 = "submit.cancel runtimeException"
            goto L6f
        L78:
            com.huawei.hms.network.httpclient.Submit r3 = r2.mo36242g()     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L97
            com.huawei.hms.network.httpclient.Submit r3 = r2.mo36242g()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L86 java.lang.RuntimeException -> L88
            r3.cancel()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L86 java.lang.RuntimeException -> L88
            goto L97
        L86:
            r3 = move-exception
            goto L8a
        L88:
            r3 = move-exception
            goto L92
        L8a:
            java.lang.String r5 = "RequestProcessor"
            java.lang.String r6 = "submit.cancel exception"
        L8e:
            com.huawei.hms.network.file.core.util.FLogger.m36352e(r5, r6, r3)     // Catch: java.lang.Throwable -> L65
            goto L97
        L92:
            java.lang.String r5 = "RequestProcessor"
            java.lang.String r6 = "submit.cancel runtimeException"
            goto L8e
        L97:
            java.util.concurrent.Future r3 = r2.mo36240e()     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L2e
            java.util.concurrent.Future r2 = r2.mo36240e()     // Catch: java.lang.Throwable -> L65
            r2.cancel(r0)     // Catch: java.lang.Throwable -> L65
            goto L2e
        La5:
            monitor-exit(r7)
            return
        La7:
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.file.core.task.C6238i.m36293b():void");
    }

    /* renamed from: a */
    private LinkedHashMap<String, String> m36256a(int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        int i11 = this.f29438h;
        linkedHashMap.put("retry_url_index", String.valueOf(i11 == 0 ? 0 : i11 - 1));
        linkedHashMap.put("domain", NetworkUtil.getHost(this.f29439i));
        linkedHashMap.put(C6148x2.API_ID, Utils.anonymizeMessage(Utils.getUrlPath(this.f29439i)));
        linkedHashMap.put("task_num", String.valueOf(this.f29449s));
        linkedHashMap.put("concurrent_task_num", String.valueOf(i10));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m36265b(FileManagerException fileManagerException, Response response) {
        m36301g();
        this.f29432b.onException(this.f29431a, C6252b.m36359a(fileManagerException), response);
    }

    /* renamed from: c */
    private void m36269c(R r10) {
        synchronized (this.f29452v) {
            this.f29431a = r10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36257a(Progress progress) {
        if (this.f29450t) {
            FLogger.m36353i("RequestProcessor", "response onProgress no need for status:" + m36298d(), new Object[0]);
            return;
        }
        FLogger.m36354v("RequestProcessor", "onProgress:" + progress);
        this.f29432b.onProgress(this.f29431a, progress);
    }

    /* renamed from: b */
    private boolean m36267b(final R r10) {
        if (this.f29432b == null) {
            return m36291a("performOnStart null callback");
        }
        Request requestM36279a = m36279a((C6238i<R>) r10);
        if (requestM36279a == null || requestM36279a == r10) {
            return m36291a("performOnStart no update");
        }
        FLogger.m36353i("RequestProcessor", "performOnStart update request:" + requestM36279a, new Object[0]);
        if (r10.getId() != requestM36279a.getId()) {
            FLogger.m36351e("RequestProcessor", "performOnStart, onStart return another request");
            m36301g();
            final Response responseM36264b = m36264b(Constants.ErrorCode.REQUEST_UPDATE_REQUEST_ERROR.getErrorCode());
            m36260a(responseM36264b, this.f29446p.m36175b(r10.getId()));
            this.f29446p.m36174a(r10.getId());
            m36287a(new Runnable() { // from class: com.huawei.hms.network.file.core.task.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29505a.m36258a(r10, responseM36264b);
                }
            });
            return false;
        }
        m36269c((C6238i<R>) requestM36279a);
        if (!m36291a("after on Start")) {
            return false;
        }
        if (m36300f()) {
            List<String> list = this.f29437g;
            if (list != null) {
                list.clear();
            }
            this.f29438h = 0;
            this.f29439i = m36275l();
        }
        return true;
    }

    /* renamed from: c */
    private boolean m36271c(Throwable th2) {
        return (th2 instanceof CancellationException) || (th2.getCause() instanceof CancellationException);
    }

    /* renamed from: a */
    public synchronized void m36281a(R r10, Callback callback, boolean z10) {
        try {
            if (!Utils.isEmpty(this.f29434d) && !this.f29433c.mo36000a(this.f29434d)) {
                this.f29434d.clear();
            }
            this.f29445o.m36315e(r10);
            m36269c((C6238i<R>) r10);
            this.f29446p.m36176c(r10.getId());
            this.f29432b = callback;
            this.f29430A = false;
            FLogger.m36353i("RequestProcessor", "resume :" + r10.getId() + ";resume url :" + Utils.anonymizeMessage(r10.getUrl()), new Object[0]);
            m36290a(z10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public boolean m36294b(AbstractC6240k<R> abstractC6240k) {
        synchronized (this) {
            try {
                if (!this.f29448r) {
                    this.f29448r = true;
                    if (!m36267b((C6238i<R>) this.f29431a)) {
                        this.f29448r = false;
                        return false;
                    }
                    this.f29433c.mo36010c();
                    this.f29451u.m36378a();
                    this.f29445o.mo36016a((C6239j) this.f29431a, (List) this.f29434d);
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36258a(Request request, Response response) {
        this.f29432b.onException(request, C6252b.m36359a(new FileManagerException(Constants.ErrorCode.REQUEST_UPDATE_REQUEST_ERROR)), response);
    }

    /* renamed from: b */
    public boolean m36295b(final Throwable th2) {
        FileManagerException fileManagerException;
        if (!m36271c(th2)) {
            if (th2 instanceof FileManagerException) {
                fileManagerException = (FileManagerException) Utils.cast(th2);
            } else if (th2.getCause() instanceof FileManagerException) {
                th2 = th2.getCause();
                fileManagerException = (FileManagerException) Utils.cast(th2);
            } else {
                fileManagerException = new FileManagerException(Constants.ErrorCode.TASK_UNCACHED_EXCEPTION, th2);
            }
            return !m36263a(fileManagerException);
        }
        final Constants.ErrorCode errorCode = Constants.ErrorCode.TASK_PAUSE_EXCEPTION;
        if (m36298d() == InterfaceC6234e.a.CANCEL) {
            errorCode = Constants.ErrorCode.TASK_CANCEL_EXCEPTION;
        }
        if (this.f29432b != null) {
            final Response responseM36264b = m36264b(errorCode.getErrorCode());
            m36260a(responseM36264b, this.f29446p.m36175b(this.f29431a.getId()));
            this.f29446p.m36174a(this.f29431a.getId());
            m36287a(new Runnable() { // from class: com.huawei.hms.network.file.core.task.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29494a.m36261a(errorCode, th2, responseM36264b);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36259a(Response response) {
        Callback callback = this.f29432b;
        if (callback != null) {
            try {
                callback.onSuccess(response);
            } catch (Throwable th2) {
                FLogger.m36352e("RequestProcessor", "customRequestCallback.onSuccess exception", th2);
            }
        }
        FLogger.m36353i("RequestProcessor", "5.remove data after onSuccess", new Object[0]);
        this.f29445o.m36316f(this.f29431a);
        m36301g();
    }

    /* renamed from: b */
    public boolean m36296b(List<ITaskResult> list) {
        this.f29445o.m36308a((C6239j) this.f29431a);
        FLogger.m36353i("RequestProcessor", "2.compose results", new Object[0]);
        try {
            ITaskResult iTaskResultMo35986a = this.f29433c.mo35986a((InterfaceC6232c) this.f29431a, (List) this.f29434d);
            if (!Constants.m36171a(iTaskResultMo35986a.getErrorCode())) {
                FLogger.m36355w("RequestProcessor", iTaskResultMo35986a.getErrorMessage(), new Object[0]);
                m36282a(new FileManagerException(iTaskResultMo35986a.getErrorCode(), iTaskResultMo35986a.getErrorMessage()), m36268c(list));
                return true;
            }
            FLogger.m36353i("RequestProcessor", "3.convertResponse", new Object[0]);
            try {
                final Response response = new Response(iTaskResultMo35986a.getErrorCode(), iTaskResultMo35986a.getErrorMessage(), this.f29431a, iTaskResultMo35986a.getRawResponse(), this.f29431a.getConverter() != null ? this.f29431a.getConverter().convertResponse(this.f29431a, iTaskResultMo35986a) : null);
                FLogger.m36353i("RequestProcessor", "4.runAsyncForResponse success:" + this.f29431a.getId(), new Object[0]);
                int iM36175b = this.f29446p.m36175b(this.f29431a.getId());
                m36260a(response, iM36175b);
                LinkedHashMap<String, String> linkedHashMapM36256a = m36256a(iM36175b);
                m36287a(new Runnable() { // from class: com.huawei.hms.network.file.core.task.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29503a.m36259a(response);
                    }
                });
                this.f29446p.m36174a(this.f29431a.getId());
                this.f29451u.m36379a(this.f29434d, null, this.f29445o, linkedHashMapM36256a);
                return false;
            } catch (Throwable th2) {
                FLogger.m36352e("RequestProcessor", "5.task failed ", th2);
                m36282a(new FileManagerException("convert exception:" + th2), m36268c(list));
                return true;
            }
        } catch (FileManagerException e10) {
            m36282a(e10, m36268c(list));
            return true;
        }
    }

    /* renamed from: a */
    private void m36260a(Response response, int i10) {
        if (!Utils.isEmpty(this.f29434d)) {
            AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(this.f29434d);
            if (abstractC6240kM36317a.mo36026d() == InterfaceC6234e.b.UPLOAD) {
                ((C6219f) Utils.cast(abstractC6240kM36317a)).m36157a(response.getExtraInfo());
            }
            response.getExtraInfo().put("protocol", abstractC6240kM36317a.m36339n());
            response.getExtraInfo().put("protocol_impl", abstractC6240kM36317a.m36340o());
            response.getExtraInfo().put(C6018n2.CONGESTION_CONTROL_TYPE, abstractC6240kM36317a.m36335i());
            response.getExtraInfo().put("concurrent_task_num", Integer.valueOf(i10));
            response.getExtraInfo().put("multipath_algorithm", Integer.valueOf(abstractC6240kM36317a.m36338l()));
        }
        RequestConfig config = this.f29431a.getConfig();
        if (config != null) {
            response.getExtraInfo().put("association_id", Utils.getValueFromOptions("association_id", config.getOptions()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36261a(Constants.ErrorCode errorCode, Throwable th2, Response response) {
        this.f29432b.onException(this.f29431a, C6252b.m36359a(new FileManagerException(errorCode, th2)), response);
    }

    /* renamed from: a */
    public void m36282a(FileManagerException fileManagerException, Response response) {
        m36283a(fileManagerException, response, false);
    }

    /* renamed from: a */
    public void m36283a(final FileManagerException fileManagerException, Response response, boolean z10) {
        final Response response2;
        FLogger.m36353i("RequestProcessor", "onRequestException isNetworkException:" + z10, new Object[0]);
        if (!z10) {
            this.f29433c.mo35996a(this.f29431a.getId(), false);
        }
        int iM36175b = this.f29446p.m36175b(this.f29431a.getId());
        if (response != null) {
            response2 = new Response(fileManagerException.getErrorCode(), fileManagerException.getMessage(), response.getRequest(), response.getRawResponse(), null);
            m36260a(response2, iM36175b);
        } else {
            response2 = null;
        }
        LinkedHashMap<String, String> linkedHashMapM36256a = m36256a(iM36175b);
        this.f29445o.m36309a((C6239j) this.f29431a, fileManagerException);
        this.f29446p.m36174a(this.f29431a.getId());
        if (this.f29432b != null) {
            m36287a(new Runnable() { // from class: com.huawei.hms.network.file.core.task.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29498a.m36265b(fileManagerException, response2);
                }
            });
        }
        this.f29451u.m36379a(this.f29434d, fileManagerException, this.f29445o, linkedHashMapM36256a);
    }

    /* renamed from: a */
    public void m36284a(FileManagerException fileManagerException, List<ITaskResult> list) {
        m36283a(fileManagerException, m36268c(list), false);
    }

    /* renamed from: a */
    public synchronized void m36285a(InterfaceC6234e interfaceC6234e) {
        interfaceC6234e.mo36234a(this.f29439i);
        interfaceC6234e.mo36233a((InterfaceC6234e) this.f29431a);
        interfaceC6234e.mo36237b(false);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6235f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo36245a(AbstractC6240k<R> abstractC6240k) {
        final Progress progressM36306a;
        if (this.f29432b == null) {
            return;
        }
        synchronized (this.f29435e) {
            try {
                if (this.f29450t) {
                    FLogger.m36353i("RequestProcessor", "onProgress no need for status:" + m36298d(), new Object[0]);
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if ((this.f29444n <= 0 || jCurrentTimeMillis - this.f29444n > 1000) && (progressM36306a = this.f29445o.m36306a(this.f29431a, this.f29439i, this.f29434d)) != null) {
                    this.f29444n = jCurrentTimeMillis;
                    this.f29433c.mo36007b(this.f29434d);
                    this.f29433c.mo36005b(this.f29431a, m36298d());
                    m36287a(new Runnable() { // from class: com.huawei.hms.network.file.core.task.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f29501a.m36257a(progressM36306a);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6235f
    /* renamed from: a */
    public void mo36244a(Submit submit) {
        this.f29455y = submit;
    }

    /* renamed from: a */
    public void m36287a(Runnable runnable) {
        String str;
        if (this.f29442l.isShutdown()) {
            str = "runAsyncForResponse respExecutorService is shut down";
        } else {
            try {
                this.f29442l.submit(runnable);
                return;
            } catch (RejectedExecutionException unused) {
                str = "runAsyncForResponse failed for RejectedExecutionException";
            }
        }
        FLogger.m36351e("RequestProcessor", str);
    }

    /* renamed from: a */
    public synchronized void m36288a(Throwable th2, String str) {
        if (this.f29430A) {
            FLogger.m36355w("RequestProcessor", "has throw exception, this time ignore", new Object[0]);
            return;
        }
        if (this.f29454x == null) {
            FLogger.m36353i("RequestProcessor", "onTaskFutureException set throwable", new Object[0]);
            this.f29454x = th2;
        }
        m36293b();
        this.f29430A = m36292a(this.f29454x);
    }

    /* renamed from: a */
    public synchronized void m36289a(List<AbstractC6240k> list) {
        try {
            if (this.f29441k.isShutdown() || this.f29443m.isShutdown()) {
                FLogger.m36351e("RequestProcessor", "executorService is shutdown");
                return;
            }
            if (this.f29440j != null) {
                FLogger.m36353i("RequestProcessor", "disable last allfuture", new Object[0]);
                this.f29440j.m36252b();
            }
            FLogger.m36353i("RequestProcessor", "executeTasks size:" + list.size(), new Object[0]);
            this.f29454x = null;
            this.f29456z = UUID.randomUUID().toString();
            if (Utils.isEmpty(list)) {
                FLogger.m36351e("RequestProcessor", "executeTasks tasks is null");
                m36282a(new FileManagerException(Constants.ErrorCode.REQUEST_TASKS_EMPTY), (Response) null);
                return;
            }
            this.f29451u.m36380b();
            Iterator<AbstractC6240k> it = list.iterator();
            while (it.hasNext()) {
                try {
                    new C6230a(this, it.next(), this.f29441k, this.f29443m, this.f29456z).m36229a();
                } catch (RejectedExecutionException e10) {
                    FLogger.m36351e("RequestProcessor", "RejectedExecutionException for CompletableFuture.supplyAsync");
                    m36293b();
                    m36282a(new FileManagerException(Constants.ErrorCode.TASK_SUBMIT_EXCEPTION, e10), (Response) null);
                    return;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m36290a(boolean z10) {
        try {
            if (Utils.isEmpty(this.f29434d)) {
                FLogger.m36353i("RequestProcessor", "startCore getCachedTasks", new Object[0]);
                this.f29434d = m36272d(this.f29433c.mo36002b(this.f29431a.getId()));
                this.f29445o.m36307a(this.f29445o.m36311c(this.f29434d));
            }
            if (Utils.isEmpty(this.f29434d)) {
                FLogger.m36353i("RequestProcessor", "startCore decompose", new Object[0]);
                this.f29434d = m36272d(this.f29433c.mo36009c((InterfaceC6232c) this.f29431a));
            }
            if (z10) {
                this.f29439i = m36275l();
            }
            if (Utils.isEmpty(this.f29434d)) {
                m36282a(new FileManagerException(Constants.ErrorCode.REQUEST_TASKS_EMPTY), (Response) null);
                return;
            }
            if (this.f29450t) {
                AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(this.f29434d);
                if (abstractC6240kM36317a.m36343r() != null) {
                    this.f29453w = abstractC6240kM36317a.m36343r();
                }
                this.f29434d = m36272d(AbstractC6240k.m36319b(this.f29434d));
            }
            this.f29450t = false;
            m36289a(this.f29434d);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6235f
    /* renamed from: a */
    public boolean mo36246a(long j10) {
        FLogger.m36353i("RequestProcessor", "onFileLengthUpdated fileSize:" + j10, new Object[0]);
        if (this.f29450t) {
            FLogger.m36355w("RequestProcessor", "onFileLengthUpdated, all task is Canceled, no need to process", new Object[0]);
            return false;
        }
        List<AbstractC6240k> listMo35990a = this.f29433c.mo35990a(this.f29431a, this.f29434d, j10);
        if (Utils.isEmpty(listMo35990a)) {
            return false;
        }
        FLogger.m36353i("RequestProcessor", "onFileLengthUpdated, newTaskListSize:" + listMo35990a.size(), new Object[0]);
        this.f29434d.addAll(listMo35990a);
        m36289a(listMo35990a);
        return true;
    }

    /* renamed from: a */
    private boolean m36263a(FileManagerException fileManagerException) {
        FLogger.m36355w("RequestProcessor", "notifyTaskException(will cancel other tasks)", new Object[0]);
        boolean zM36360a = C6252b.m36360a(fileManagerException.getCause());
        boolean z10 = m36298d() == InterfaceC6234e.a.PROCESS && this.f29438h < this.f29437g.size();
        FLogger.m36353i("RequestProcessor", "notifyTaskException isNetworkException:" + zM36360a + ",needRetry:" + z10 + ",getStatus:" + m36298d(), new Object[0]);
        if (z10) {
            AbstractC6240k abstractC6240kM36317a = AbstractC6240k.m36317a(this.f29434d);
            boolean z11 = abstractC6240kM36317a == null || abstractC6240kM36317a.mo36026d() == InterfaceC6234e.b.UPLOAD;
            if (!zM36360a || z11) {
                this.f29433c.mo35996a(m36297c().getId(), true);
                this.f29434d.clear();
            }
            FLogger.m36353i("RequestProcessor", "notifyTaskException try next url", new Object[0]);
            m36304j();
            m36290a(true);
        } else {
            FLogger.m36352e("RequestProcessor", "processFileManagerException", fileManagerException);
            m36283a(fileManagerException, m36264b(fileManagerException.getErrorCode()), zM36360a);
        }
        return z10;
    }

    /* renamed from: a */
    public boolean m36291a(String str) {
        if (Utils.isUrlValid(this.f29431a.getUrl()) && Utils.isUrlValid(this.f29431a.getBackupUrls())) {
            return true;
        }
        FLogger.m36351e("RequestProcessor", "checkAllUrlsValid failed for:" + str);
        m36282a(new FileManagerException(Constants.ErrorCode.REQUEST_URL_EMPTY), (Response) null);
        return false;
    }

    /* renamed from: a */
    public synchronized boolean m36292a(Throwable th2) {
        try {
            this.f29445o.m36308a((C6239j) this.f29431a);
            if (!this.f29450t) {
                m36293b();
            }
            if (th2 != null && this.f29454x == null) {
                this.f29454x = th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return m36295b(this.f29454x);
    }
}
