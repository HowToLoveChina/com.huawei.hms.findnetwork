package com.huawei.updatesdk.p191b.p200g;

import android.os.AsyncTask;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p186b.p189c.AsyncTaskC8797b;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.InterfaceC8798a;
import com.huawei.updatesdk.p191b.p195b.C8809c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.huawei.updatesdk.b.g.b */
/* loaded from: classes9.dex */
public class C8831b {

    /* renamed from: a */
    private static final List<AsyncTask> f45171a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static AsyncTaskC8797b m56297a(C8809c c8809c, InterfaceC8798a interfaceC8798a) {
        AsyncTaskC8797b asyncTaskC8797b = new AsyncTaskC8797b(c8809c, interfaceC8798a);
        m56301a(asyncTaskC8797b);
        return asyncTaskC8797b;
    }

    /* renamed from: a */
    public static C8801d m56298a(C8800c c8800c) {
        return new AsyncTaskC8797b(c8800c, null).m56163c();
    }

    /* renamed from: a */
    public static List<AsyncTask> m56299a() {
        return f45171a;
    }

    /* renamed from: a */
    public static void m56300a(AsyncTask asyncTask) {
        if (asyncTask == null) {
            return;
        }
        for (AsyncTask asyncTask2 : f45171a) {
            if (asyncTask2 != null && (asyncTask2.getStatus() == AsyncTask.Status.FINISHED || asyncTask2.isCancelled())) {
                f45171a.remove(asyncTask2);
            }
        }
        f45171a.add(asyncTask);
    }

    /* renamed from: a */
    private static void m56301a(AsyncTaskC8797b asyncTaskC8797b) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("executeTask, ActiveCount:");
        ThreadPoolExecutor threadPoolExecutor = C8832c.f45172a;
        sb2.append(threadPoolExecutor.getActiveCount());
        sb2.append(", TaskCount:");
        sb2.append(threadPoolExecutor.getTaskCount());
        C8777a.m56026a("StoreAgent", sb2.toString());
        asyncTaskC8797b.m56161a(threadPoolExecutor);
    }
}
