package com.huawei.openalliance.p169ad.download;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* renamed from: com.huawei.openalliance.ad.download.d */
/* loaded from: classes2.dex */
public class C7061d<T extends DownloadTask> {

    /* renamed from: a */
    private BlockingQueue<T> f32514a = new PriorityBlockingQueue();

    /* renamed from: b */
    private Queue<T> f32515b = new ConcurrentLinkedQueue();

    /* renamed from: c */
    private Queue<T> f32516c = new ConcurrentLinkedQueue();

    /* renamed from: h */
    private boolean m42582h(T t10) {
        if (t10 == null || this.f32516c.contains(t10)) {
            return false;
        }
        if (this.f32514a.contains(t10)) {
            return true;
        }
        boolean zOffer = this.f32514a.offer(t10);
        if (zOffer) {
            this.f32515b.remove(t10);
        }
        return zOffer;
    }

    /* renamed from: a */
    public int m42583a() {
        return this.f32514a.size();
    }

    /* renamed from: b */
    public T m42586b() throws InterruptedException {
        String str;
        try {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadQueue", "takeTask, workingQueue.size:%d, waitingQueue.size:%d, idleQueue.size:%d", Integer.valueOf(this.f32516c.size()), Integer.valueOf(this.f32514a.size()), Integer.valueOf(this.f32515b.size()));
            }
            T tTake = this.f32514a.take();
            if (!this.f32516c.offer(tTake)) {
                AbstractC7185ho.m43820b("DownloadQueue", "taskTask - workingQueue fail to offer ");
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadQueue", "takeTask, task:%s", tTake.toString());
            }
            return tTake;
        } catch (InterruptedException unused) {
            str = "takeTask InterruptedException";
            AbstractC7185ho.m43826d("DownloadQueue", str);
            return null;
        } catch (Exception unused2) {
            str = "takeTask Exception";
            AbstractC7185ho.m43826d("DownloadQueue", str);
            return null;
        }
    }

    /* renamed from: c */
    public List<T> m42588c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f32515b);
        return arrayList;
    }

    /* renamed from: d */
    public List<T> m42590d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f32514a);
        arrayList.addAll(this.f32516c);
        return arrayList;
    }

    /* renamed from: e */
    public boolean m42592e(T t10) {
        if (t10 == null) {
            return false;
        }
        if (this.f32514a.contains(t10)) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadQueue", "pauseTask, from waitingQueue, taskId:%s", t10.mo42082n());
            }
            this.f32514a.remove(t10);
        } else {
            if (!this.f32516c.contains(t10)) {
                if (!this.f32515b.contains(t10)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("DownloadQueue", "pauseTask, from idleQueue, taskId:%s", t10.mo42082n());
                }
                return true;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("DownloadQueue", "pauseTask, from workingQueue, taskId:%s", t10.mo42082n());
            }
            t10.m42091w();
        }
        m42587b(t10);
        return true;
    }

    /* renamed from: f */
    public boolean m42593f(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean zM42585a = m42585a((C7061d<T>) t10);
        if (!AbstractC7185ho.m43819a()) {
            return zM42585a;
        }
        AbstractC7185ho.m43818a("DownloadQueue", "resumeTask, succ:%s, taskId:%s", Boolean.valueOf(zM42585a), t10.mo42082n());
        return zM42585a;
    }

    /* renamed from: g */
    public boolean m42594g(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean zRemove = this.f32514a.remove(t10);
        if (this.f32515b.remove(t10)) {
            zRemove = true;
        }
        if (!this.f32516c.contains(t10)) {
            return zRemove;
        }
        t10.m42091w();
        return true;
    }

    /* renamed from: a */
    public T m42584a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadQueue", "findTask, workingQueue.size:%d, waitingQueue.size:%d, idleQueue.size:%d", Integer.valueOf(this.f32516c.size()), Integer.valueOf(this.f32514a.size()), Integer.valueOf(this.f32515b.size()));
        }
        T t10 = (T) m42581a(this.f32516c, str);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) m42581a(this.f32514a, str);
        return t11 == null ? (T) m42581a(this.f32515b, str) : t11;
    }

    /* renamed from: b */
    public boolean m42587b(T t10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadQueue", "addIdleTask, task:%s", t10.toString());
        }
        if (t10 == null || this.f32515b.contains(t10)) {
            return false;
        }
        return this.f32515b.offer(t10);
    }

    /* renamed from: c */
    public void m42589c(T t10) {
        this.f32516c.remove(t10);
    }

    /* renamed from: d */
    public boolean m42591d(T t10) {
        return this.f32516c.remove(t10);
    }

    /* renamed from: a */
    private T m42581a(Queue<T> queue, String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadQueue", "findTaskFromQueue, taskId:%s", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (T t10 : queue) {
            if (str.equals(t10.mo42082n())) {
                return t10;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m42585a(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean zM42582h = m42582h(t10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("DownloadQueue", "addTask, succ:%s, taskId:%s, priority:%d, seqNum:%d", Boolean.valueOf(zM42582h), t10.mo42082n(), Integer.valueOf(t10.m42079k()), Long.valueOf(t10.m42081m()));
        }
        return zM42582h;
    }
}
