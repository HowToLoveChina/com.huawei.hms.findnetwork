package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.c */
/* loaded from: classes.dex */
public class C0864c implements InterfaceC0873l {

    /* renamed from: a */
    public final InterfaceC0873l f4476a;

    /* renamed from: b */
    public int f4477b = 0;

    /* renamed from: c */
    public int f4478c = -1;

    /* renamed from: d */
    public int f4479d = -1;

    /* renamed from: e */
    public Object f4480e = null;

    public C0864c(InterfaceC0873l interfaceC0873l) {
        this.f4476a = interfaceC0873l;
    }

    @Override // androidx.recyclerview.widget.InterfaceC0873l
    /* renamed from: a */
    public void mo5434a(int i10, int i11) {
        m5438e();
        this.f4476a.mo5434a(i10, i11);
    }

    @Override // androidx.recyclerview.widget.InterfaceC0873l
    /* renamed from: b */
    public void mo5435b(int i10, int i11) {
        int i12;
        if (this.f4477b == 1 && i10 >= (i12 = this.f4478c)) {
            int i13 = this.f4479d;
            if (i10 <= i12 + i13) {
                this.f4479d = i13 + i11;
                this.f4478c = Math.min(i10, i12);
                return;
            }
        }
        m5438e();
        this.f4478c = i10;
        this.f4479d = i11;
        this.f4477b = 1;
    }

    @Override // androidx.recyclerview.widget.InterfaceC0873l
    /* renamed from: c */
    public void mo5436c(int i10, int i11) {
        int i12;
        if (this.f4477b == 2 && (i12 = this.f4478c) >= i10 && i12 <= i10 + i11) {
            this.f4479d += i11;
            this.f4478c = i10;
        } else {
            m5438e();
            this.f4478c = i10;
            this.f4479d = i11;
            this.f4477b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.InterfaceC0873l
    /* renamed from: d */
    public void mo5437d(int i10, int i11, Object obj) {
        int i12;
        if (this.f4477b == 3) {
            int i13 = this.f4478c;
            int i14 = this.f4479d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f4480e == obj) {
                this.f4478c = Math.min(i10, i13);
                this.f4479d = Math.max(i14 + i13, i12) - this.f4478c;
                return;
            }
        }
        m5438e();
        this.f4478c = i10;
        this.f4479d = i11;
        this.f4480e = obj;
        this.f4477b = 3;
    }

    /* renamed from: e */
    public void m5438e() {
        int i10 = this.f4477b;
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            this.f4476a.mo5435b(this.f4478c, this.f4479d);
        } else if (i10 == 2) {
            this.f4476a.mo5436c(this.f4478c, this.f4479d);
        } else if (i10 == 3) {
            this.f4476a.mo5437d(this.f4478c, this.f4479d, this.f4480e);
        }
        this.f4480e = null;
        this.f4477b = 0;
    }
}
