package sy;

/* renamed from: sy.c */
/* loaded from: classes9.dex */
public class C12879c {

    /* renamed from: d */
    public static final InterfaceC12878b[] f58655d = new InterfaceC12878b[0];

    /* renamed from: a */
    public InterfaceC12878b[] f58656a;

    /* renamed from: b */
    public int f58657b;

    /* renamed from: c */
    public boolean f58658c;

    public C12879c(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f58656a = i10 == 0 ? f58655d : new InterfaceC12878b[i10];
        this.f58657b = 0;
        this.f58658c = false;
    }

    /* renamed from: b */
    public static InterfaceC12878b[] m77275b(InterfaceC12878b[] interfaceC12878bArr) {
        return interfaceC12878bArr.length < 1 ? f58655d : (InterfaceC12878b[]) interfaceC12878bArr.clone();
    }

    /* renamed from: a */
    public void m77276a(InterfaceC12878b interfaceC12878b) {
        if (interfaceC12878b == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        int length = this.f58656a.length;
        int i10 = this.f58657b + 1;
        if (this.f58658c | (i10 > length)) {
            m77277c(i10);
        }
        this.f58656a[this.f58657b] = interfaceC12878b;
        this.f58657b = i10;
    }

    /* renamed from: c */
    public final void m77277c(int i10) {
        InterfaceC12878b[] interfaceC12878bArr = new InterfaceC12878b[Math.max(this.f58656a.length, i10 + (i10 >> 1))];
        System.arraycopy(this.f58656a, 0, interfaceC12878bArr, 0, this.f58657b);
        this.f58656a = interfaceC12878bArr;
        this.f58658c = false;
    }

    /* renamed from: d */
    public InterfaceC12878b[] m77278d() {
        int i10 = this.f58657b;
        if (i10 == 0) {
            return f58655d;
        }
        InterfaceC12878b[] interfaceC12878bArr = this.f58656a;
        if (interfaceC12878bArr.length == i10) {
            this.f58658c = true;
            return interfaceC12878bArr;
        }
        InterfaceC12878b[] interfaceC12878bArr2 = new InterfaceC12878b[i10];
        System.arraycopy(interfaceC12878bArr, 0, interfaceC12878bArr2, 0, i10);
        return interfaceC12878bArr2;
    }
}
