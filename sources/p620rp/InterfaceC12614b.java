package p620rp;

import nu.C11754g;
import p686up.InterfaceC13233a;

/* renamed from: rp.b */
/* loaded from: classes8.dex */
public interface InterfaceC12614b {

    /* renamed from: rp.b$a */
    public class a implements InterfaceC12614b {
        @Override // p620rp.InterfaceC12614b
        public <T extends InterfaceC13233a> void clearConfigurable(Class<T> cls) {
        }

        @Override // p620rp.InterfaceC12614b
        public <T extends InterfaceC13233a> T getConfigurable(Class<T> cls) {
            return null;
        }

        @Override // p620rp.InterfaceC12614b
        public <T extends InterfaceC13233a> void saveConfigurable(Class<T> cls, T t10) {
        }
    }

    static InterfaceC12614b get() {
        return (InterfaceC12614b) C11754g.m70076k(InterfaceC12614b.class).findFirst().orElse(new a());
    }

    default void clearAll() {
    }

    <T extends InterfaceC13233a> void clearConfigurable(Class<T> cls);

    <T extends InterfaceC13233a> T getConfigurable(Class<T> cls);

    <T extends InterfaceC13233a> void saveConfigurable(Class<T> cls, T t10);
}
