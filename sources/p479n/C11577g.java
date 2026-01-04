package p479n;

/* renamed from: n.g */
/* loaded from: classes.dex */
public class C11577g<T> implements InterfaceC11576f<T> {

    /* renamed from: a */
    public final Object[] f53685a;

    /* renamed from: b */
    public int f53686b;

    public C11577g(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f53685a = new Object[i10];
    }

    @Override // p479n.InterfaceC11576f
    /* renamed from: a */
    public boolean mo69116a(T t10) {
        int i10 = this.f53686b;
        Object[] objArr = this.f53685a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f53686b = i10 + 1;
        return true;
    }

    @Override // p479n.InterfaceC11576f
    /* renamed from: b */
    public T mo69117b() {
        int i10 = this.f53686b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f53685a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f53686b = i10 - 1;
        return t10;
    }

    @Override // p479n.InterfaceC11576f
    /* renamed from: c */
    public void mo69118c(T[] tArr, int i10) {
        if (i10 > tArr.length) {
            i10 = tArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            T t10 = tArr[i11];
            int i12 = this.f53686b;
            Object[] objArr = this.f53685a;
            if (i12 < objArr.length) {
                objArr[i12] = t10;
                this.f53686b = i12 + 1;
            }
        }
    }
}
