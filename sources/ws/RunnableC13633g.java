package ws;

/* renamed from: ws.g */
/* loaded from: classes8.dex */
public final class RunnableC13633g implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C13635i f61308a;

    public RunnableC13633g(C13635i c13635i) {
        this.f61308a = c13635i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
        C13635i.m81995i(this.f61308a);
        C13635i.m81991d(this.f61308a);
    }
}
