package p243e0;

/* renamed from: e0.f */
/* loaded from: classes.dex */
public class C9371f<T> implements InterfaceC9370e<T> {

    /* renamed from: a */
    public final Object[] f46771a;

    /* renamed from: b */
    public int f46772b;

    public C9371f(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f46771a = new Object[i10];
    }

    @Override // p243e0.InterfaceC9370e
    /* renamed from: a */
    public boolean mo58737a(T t10) {
        if (m58739c(t10)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f46772b;
        Object[] objArr = this.f46771a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f46772b = i10 + 1;
        return true;
    }

    @Override // p243e0.InterfaceC9370e
    /* renamed from: b */
    public T mo58738b() {
        int i10 = this.f46772b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f46771a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f46772b = i10 - 1;
        return t10;
    }

    /* renamed from: c */
    public final boolean m58739c(T t10) {
        for (int i10 = 0; i10 < this.f46772b; i10++) {
            if (this.f46771a[i10] == t10) {
                return true;
            }
        }
        return false;
    }
}
