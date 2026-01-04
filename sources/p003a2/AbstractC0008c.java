package p003a2;

import java.util.Queue;
import p003a2.InterfaceC0017l;
import p630s2.C12677l;

/* renamed from: a2.c */
/* loaded from: classes.dex */
public abstract class AbstractC0008c<T extends InterfaceC0017l> {

    /* renamed from: a */
    public final Queue<T> f0a = C12677l.m76282e(20);

    /* renamed from: a */
    public abstract T mo11a();

    /* renamed from: b */
    public T m12b() {
        T tPoll = this.f0a.poll();
        return tPoll == null ? (T) mo11a() : tPoll;
    }

    /* renamed from: c */
    public void m13c(T t10) {
        if (this.f0a.size() < 20) {
            this.f0a.offer(t10);
        }
    }
}
