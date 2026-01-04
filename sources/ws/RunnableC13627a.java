package ws;

/* renamed from: ws.a */
/* loaded from: classes8.dex */
public final class RunnableC13627a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C13635i f61295a;

    public RunnableC13627a(C13635i c13635i) {
        this.f61295a = c13635i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
        C13635i.m81991d(this.f61295a);
    }
}
