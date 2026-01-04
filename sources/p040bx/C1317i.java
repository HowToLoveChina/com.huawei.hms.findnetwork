package p040bx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: bx.i */
/* loaded from: classes9.dex */
public final class C1317i extends C1332n {

    /* renamed from: c */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5805c = AtomicIntegerFieldUpdater.newUpdater(C1317i.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    /* renamed from: c */
    public final boolean m7774c() {
        return f5805c.compareAndSet(this, 0, 1);
    }
}
