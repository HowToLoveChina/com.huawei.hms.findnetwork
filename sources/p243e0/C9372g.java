package p243e0;

/* renamed from: e0.g */
/* loaded from: classes.dex */
public class C9372g<T> extends C9371f<T> {

    /* renamed from: c */
    public final Object f46773c;

    public C9372g(int i10) {
        super(i10);
        this.f46773c = new Object();
    }

    @Override // p243e0.C9371f, p243e0.InterfaceC9370e
    /* renamed from: a */
    public boolean mo58737a(T t10) {
        boolean zMo58737a;
        synchronized (this.f46773c) {
            zMo58737a = super.mo58737a(t10);
        }
        return zMo58737a;
    }

    @Override // p243e0.C9371f, p243e0.InterfaceC9370e
    /* renamed from: b */
    public T mo58738b() {
        T t10;
        synchronized (this.f46773c) {
            t10 = (T) super.mo58738b();
        }
        return t10;
    }
}
