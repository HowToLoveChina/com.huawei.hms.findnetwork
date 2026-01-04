package com.huawei.openalliance.p169ad.download.p172ag;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.huawei.openalliance.ad.download.ag.b */
/* loaded from: classes2.dex */
public class C7034b<T extends DownloadTask> {

    /* renamed from: a */
    private Queue<T> f32271a = new ConcurrentLinkedQueue();

    /* renamed from: a */
    public T m42114a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdapterDownloadQueue", "findTask, workingQueue.size:%d", Integer.valueOf(this.f32271a.size()));
        }
        return (T) m42113a(this.f32271a, str);
    }

    /* renamed from: b */
    public void m42117b() {
        this.f32271a.clear();
    }

    /* renamed from: a */
    private T m42113a(Queue<T> queue, String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdapterDownloadQueue", "findTaskFromQueue, taskId:%s", str);
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

    /* renamed from: b */
    public boolean m42118b(T t10) {
        if (t10 == null || !this.f32271a.contains(t10)) {
            return false;
        }
        this.f32271a.remove(t10);
        return true;
    }

    /* renamed from: a */
    public Queue<T> m42115a() {
        return this.f32271a;
    }

    /* renamed from: a */
    public void m42116a(T t10) {
        if (t10 == null || this.f32271a.contains(t10)) {
            return;
        }
        this.f32271a.offer(t10);
    }
}
