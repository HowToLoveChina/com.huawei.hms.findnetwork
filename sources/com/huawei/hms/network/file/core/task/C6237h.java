package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.network.file.core.task.h */
/* loaded from: classes8.dex */
public class C6237h {

    /* renamed from: a */
    private final C6238i f29424a;

    /* renamed from: b */
    private List<AbstractC6240k> f29425b;

    /* renamed from: c */
    private ExecutorService f29426c;

    /* renamed from: d */
    private Future f29427d;

    /* renamed from: e */
    private volatile boolean f29428e = false;

    /* renamed from: f */
    private volatile boolean f29429f = false;

    public C6237h(C6238i c6238i, List<AbstractC6240k> list, ExecutorService executorService) {
        this.f29424a = c6238i;
        this.f29425b = list;
        this.f29426c = executorService;
    }

    /* renamed from: b */
    private List<ITaskResult> m36248b(List<AbstractC6240k> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC6240k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m36346u());
        }
        return arrayList;
    }

    /* renamed from: f */
    public /* synthetic */ void m36249f() {
        boolean zM36251a;
        try {
            if (this.f29428e) {
                FLogger.m36355w("RequestProcessor", "allFuture.thenAcceptAsync executeSession invalid", new Object[0]);
                return;
            }
            synchronized (this.f29424a) {
                zM36251a = m36251a(this.f29425b);
            }
            if (zM36251a) {
                this.f29424a.m36301g();
            }
        } catch (Throwable th2) {
            if (this.f29428e) {
                FLogger.m36355w("RequestProcessor", "allFuture.exceptionally executeSession invalid", new Object[0]);
            }
            FLogger.m36355w("RequestProcessor", "allFuture.exceptionally, exceptionTask", new Object[0]);
            this.f29424a.m36292a(th2);
        }
    }

    /* renamed from: c */
    public void m36253c() {
        this.f29427d = this.f29426c.submit(new Runnable() { // from class: com.huawei.hms.network.file.core.task.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f29493a.m36249f();
            }
        });
    }

    /* renamed from: d */
    public boolean m36254d() {
        Future future = this.f29427d;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    /* renamed from: e */
    public boolean m36255e() {
        return this.f29429f;
    }

    /* renamed from: a */
    public void m36250a() {
        Future future = this.f29427d;
        if (future != null) {
            future.cancel(true);
        }
    }

    /* renamed from: b */
    public void m36252b() {
        this.f29428e = true;
    }

    /* renamed from: a */
    public boolean m36251a(List<AbstractC6240k> list) {
        FLogger.m36353i("RequestProcessor", "processTaskFinished all task finished start", new Object[0]);
        this.f29429f = true;
        List<ITaskResult> listM36248b = m36248b(list);
        if (this.f29424a.m36299e()) {
            FLogger.m36355w("RequestProcessor", "processTaskFinished exceptionTask not null!", new Object[0]);
            boolean z10 = this.f29424a.f29450t;
            C6238i c6238i = this.f29424a;
            if (!z10) {
                return c6238i.m36292a((Throwable) null);
            }
            c6238i.f29447q = false;
            return false;
        }
        FLogger.m36353i("RequestProcessor", "1.check results:" + this.f29424a.m36297c().getId() + ",isResuleEmpty:" + Utils.isEmpty(listM36248b), new Object[0]);
        for (ITaskResult iTaskResult : listM36248b) {
            if (!Constants.m36171a(iTaskResult.getErrorCode())) {
                FLogger.m36351e("RequestProcessor", "task finish failed for " + iTaskResult.getErrorMessage());
                this.f29424a.m36284a(iTaskResult.getException(), listM36248b);
                return true;
            }
        }
        return this.f29424a.m36296b(listM36248b);
    }
}
