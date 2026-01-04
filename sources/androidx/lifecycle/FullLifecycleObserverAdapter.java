package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements InterfaceC0794j {

    /* renamed from: a */
    public final InterfaceC0785e f4105a;

    /* renamed from: b */
    public final InterfaceC0794j f4106b;

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$a */
    public static /* synthetic */ class C0769a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4107a;

        static {
            int[] iArr = new int[AbstractC0791h.b.values().length];
            f4107a = iArr;
            try {
                iArr[AbstractC0791h.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4107a[AbstractC0791h.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(InterfaceC0785e interfaceC0785e, InterfaceC0794j interfaceC0794j) {
        this.f4105a = interfaceC0785e;
        this.f4106b = interfaceC0794j;
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        switch (C0769a.f4107a[bVar.ordinal()]) {
            case 1:
                this.f4105a.mo4927a(interfaceC0796l);
                break;
            case 2:
                this.f4105a.onStart(interfaceC0796l);
                break;
            case 3:
                this.f4105a.mo4194c(interfaceC0796l);
                break;
            case 4:
                this.f4105a.mo4928b(interfaceC0796l);
                break;
            case 5:
                this.f4105a.onStop(interfaceC0796l);
                break;
            case 6:
                this.f4105a.onDestroy(interfaceC0796l);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0794j interfaceC0794j = this.f4106b;
        if (interfaceC0794j != null) {
            interfaceC0794j.mo1925d(interfaceC0796l, bVar);
        }
    }
}
