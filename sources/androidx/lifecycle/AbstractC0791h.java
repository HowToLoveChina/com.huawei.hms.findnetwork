package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.h */
/* loaded from: classes.dex */
public abstract class AbstractC0791h {

    /* renamed from: a */
    public AtomicReference<Object> f4165a = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.h$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4166a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f4167b;

        static {
            int[] iArr = new int[b.values().length];
            f4167b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4167b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4167b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4167b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4167b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4167b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4167b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            f4166a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4166a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4166a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4166a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4166a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: androidx.lifecycle.h$b */
    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        /* renamed from: b */
        public static b m4951b(c cVar) {
            int i10 = a.f4166a[cVar.ordinal()];
            if (i10 == 1) {
                return ON_DESTROY;
            }
            if (i10 == 2) {
                return ON_STOP;
            }
            if (i10 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        /* renamed from: f */
        public static b m4952f(c cVar) {
            int i10 = a.f4166a[cVar.ordinal()];
            if (i10 == 1) {
                return ON_START;
            }
            if (i10 == 2) {
                return ON_RESUME;
            }
            if (i10 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        /* renamed from: e */
        public c m4953e() {
            switch (a.f4167b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* renamed from: androidx.lifecycle.h$c */
    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: b */
        public boolean m4954b(c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    /* renamed from: a */
    public abstract void mo4948a(InterfaceC0795k interfaceC0795k);

    /* renamed from: b */
    public abstract c mo4949b();

    /* renamed from: c */
    public abstract void mo4950c(InterfaceC0795k interfaceC0795k);
}
