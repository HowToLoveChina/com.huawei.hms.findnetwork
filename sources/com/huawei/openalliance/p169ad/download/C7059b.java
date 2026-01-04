package com.huawei.openalliance.p169ad.download;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.huawei.openalliance.ad.download.b */
/* loaded from: classes2.dex */
public class C7059b<T extends DownloadTask> {

    /* renamed from: a */
    protected Context f32505a;

    /* renamed from: b */
    protected String f32506b;

    /* renamed from: c */
    protected InterfaceC7032a<T> f32507c;

    /* renamed from: d */
    protected RunnableC7065h f32508d;

    /* renamed from: e */
    protected C7061d<T> f32509e;

    /* renamed from: f */
    private ExecutorService f32510f;

    /* renamed from: g */
    private Integer f32511g;

    /* renamed from: com.huawei.openalliance.ad.download.b$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private final DownloadTask f32512a;

        /* renamed from: b */
        private final Context f32513b;

        public a(DownloadTask downloadTask, Context context) {
            this.f32512a = downloadTask;
            this.f32513b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadTask downloadTask = this.f32512a;
            if (downloadTask == null) {
                return;
            }
            AbstractC7731ae.m47440a(this.f32513b, downloadTask.m42071e());
            AbstractC7731ae.m47440a(this.f32513b, this.f32512a.m42068d());
        }
    }

    public C7059b(Context context) {
        this.f32505a = context.getApplicationContext();
    }

    /* renamed from: a */
    public T mo42385a(String str) {
        return (T) this.f32509e.m42584a(str);
    }

    /* renamed from: b */
    public T m42558b() {
        return (T) this.f32509e.m42586b();
    }

    /* renamed from: c */
    public int m42561c() {
        return this.f32509e.m42583a();
    }

    /* renamed from: d */
    public int m42563d() {
        return 256000;
    }

    /* renamed from: e */
    public int m42566e() {
        Context context = this.f32505a;
        if (context != null) {
            return C7124fh.m43316b(context).mo43409bj();
        }
        return 5;
    }

    /* renamed from: f */
    public void m42568f(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadWaiting, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.onDownloadWaiting(t10);
        }
    }

    /* renamed from: g */
    public int m42570g() {
        Integer num = this.f32511g;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* renamed from: h */
    public void m42572h(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadSuccess, taskId:%s", t10.mo42082n());
        }
        this.f32509e.m42587b(t10);
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.onDownloadSuccess(t10);
        }
    }

    /* renamed from: i */
    public void m42573i(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadSwitchSafeUrl, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42101b(t10);
        }
    }

    /* renamed from: j */
    public void m42574j(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadFail, taskId:%s", t10.mo42082n());
        }
        if (AbstractC7731ae.m47458b(t10.m42071e()) || AbstractC7731ae.m47456b(this.f32505a, t10.m42068d())) {
            m42560b(t10);
        } else {
            t10.m42059b(0);
        }
        t10.m42054a(EnumC7062e.FAILED);
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.onDownloadFail(t10);
        }
    }

    /* renamed from: a */
    public void m42551a() {
        if (this.f32509e == null) {
            this.f32509e = new C7061d<>();
        }
        this.f32510f = Executors.newFixedThreadPool(1, new ThreadFactoryC7063f());
        RunnableC7065h runnableC7065h = new RunnableC7065h(this);
        this.f32508d = runnableC7065h;
        this.f32510f.execute(runnableC7065h);
    }

    /* renamed from: b */
    public void m42559b(T t10, boolean z10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadPaused, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42102b(t10, z10);
        }
    }

    /* renamed from: c */
    public void m42562c(T t10, boolean z10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadResumed, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42103c(t10, z10);
        }
    }

    /* renamed from: d */
    public void m42564d(T t10, boolean z10) {
        if (t10 == null) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadDeleted, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42100a(t10, z10);
        }
    }

    /* renamed from: e */
    public void m42567e(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadWaitingForWifi, taskId:%s", t10.mo42082n());
        }
        t10.m42054a(EnumC7062e.WAITING_FOR_WIFI);
        t10.m42053a(DownloadTask.EnumC7031c.WAITING_WIFI_DOWNLOAD);
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42099a(t10);
        }
    }

    /* renamed from: f */
    public boolean m42569f() {
        Integer num = this.f32511g;
        return num != null && num.intValue() > 0;
    }

    /* renamed from: g */
    public void m42571g(T t10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadStart, taskId:%s", t10.mo42082n());
        }
        t10.m42054a(EnumC7062e.DOWNLOADING);
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.onDownloadStart(t10);
        }
    }

    /* renamed from: a */
    public void m42552a(T t10) {
        if (t10 != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadManager", "onDownloadCompleted, taskId:%s, priority:%d", t10.mo42082n(), Integer.valueOf(t10.m42079k()));
            }
            this.f32509e.m42589c(t10);
        }
    }

    /* renamed from: b */
    public boolean m42560b(T t10) {
        return this.f32509e.m42587b(t10);
    }

    /* renamed from: c */
    public boolean mo42403c(T t10) {
        EnumC7062e enumC7062eM42077i = t10.m42077i();
        boolean zM42085q = t10.m42085q();
        t10.m42054a(EnumC7062e.WAITING);
        t10.m42062b(false);
        boolean zM42585a = this.f32509e.m42585a((C7061d<T>) t10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "addTask, added:%s, task:%s, priority:%d", Boolean.valueOf(zM42585a), t10.mo42082n(), Integer.valueOf(t10.m42079k()));
        }
        if (zM42585a) {
            m42568f(t10);
        } else {
            t10.m42054a(enumC7062eM42077i);
            t10.m42062b(zM42085q);
        }
        return zM42585a;
    }

    /* renamed from: d */
    public boolean m42565d(T t10) {
        if (t10 == null) {
            return true;
        }
        boolean zM42591d = this.f32509e.m42591d(t10);
        if (!AbstractC7185ho.m43819a()) {
            return true;
        }
        AbstractC7185ho.m43818a("DownloadManager", "deleteTask, succ:%s, taskId:%s, priority:%d", Boolean.valueOf(zM42591d), t10.mo42082n(), Integer.valueOf(t10.m42079k()));
        return true;
    }

    /* renamed from: a */
    public void m42553a(T t10, int i10) {
        if (t10 == null || t10.m42085q()) {
            return;
        }
        if (AbstractC7185ho.m43819a() && i10 % 10 == 0) {
            AbstractC7185ho.m43818a("DownloadManager", "onDownloadProgress, progress:%d, taskId:%s", Integer.valueOf(i10), t10.mo42082n());
        }
        t10.m42059b(i10);
        InterfaceC7032a<T> interfaceC7032a = this.f32507c;
        if (interfaceC7032a != null) {
            interfaceC7032a.onDownloadProgress(t10);
        }
    }

    /* renamed from: a */
    public void m42554a(T t10, DownloadTask.EnumC7031c enumC7031c) {
        if (t10 == null) {
            return;
        }
        boolean zM42592e = this.f32509e.m42592e(t10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "pauseTask, succ:%s, taskId:%s", Boolean.valueOf(zM42592e), t10.mo42082n());
        }
        if (zM42592e) {
            AbstractC7185ho.m43820b("DownloadManager", "reason:" + enumC7031c);
            t10.m42053a(enumC7031c);
            t10.m42054a(EnumC7062e.IDLE);
            m42559b(t10, DownloadTask.EnumC7031c.USER_CLICK == enumC7031c);
        }
    }

    /* renamed from: a */
    public void m42555a(InterfaceC7032a<T> interfaceC7032a) {
        this.f32507c = interfaceC7032a;
    }

    /* renamed from: a */
    public void m42556a(Integer num) {
        this.f32511g = num;
    }

    /* renamed from: a */
    public boolean mo42393a(T t10, boolean z10) {
        if (t10 == null) {
            return false;
        }
        if (t10.m42080l() >= 100) {
            t10.m42059b(0);
        }
        boolean zM42085q = t10.m42085q();
        t10.m42062b(false);
        boolean zM42593f = this.f32509e.m42593f(t10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadManager", "resumeTask, succ:%s, taskId:%s", Boolean.valueOf(zM42593f), t10.mo42082n());
        }
        if (!zM42593f) {
            t10.m42062b(zM42085q);
            return false;
        }
        t10.m42054a(EnumC7062e.WAITING);
        m42562c(t10, z10);
        return true;
    }

    /* renamed from: a */
    public boolean m42557a(T t10, boolean z10, boolean z11, boolean z12) {
        if (t10 == null) {
            return false;
        }
        if (z10) {
            t10.m42062b(true);
        }
        AbstractC7185ho.m43820b("DownloadManager", "removeTask, succ:" + this.f32509e.m42594g(t10) + ", fromUser:" + z10);
        if (z11) {
            AbstractC7834m.m48486f(new a(t10, this.f32505a));
        }
        if (z12) {
            m42564d(t10, z10);
        }
        return true;
    }
}
