package p040bx;

import java.io.Closeable;
import mw.AbstractC11535b;
import mw.InterfaceC11539f;
import p692uw.AbstractC13268k;
import p692uw.C13264g;
import tw.InterfaceC13086l;

/* renamed from: bx.o0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1335o0 extends AbstractC1344t implements Closeable {

    /* renamed from: b */
    public static final a f5835b = new a(null);

    /* renamed from: bx.o0$a */
    public static final class a extends AbstractC11535b<AbstractC1344t, AbstractC1335o0> {

        /* renamed from: bx.o0$a$a */
        public static final class C14413a extends AbstractC13268k implements InterfaceC13086l<InterfaceC11539f.b, AbstractC1335o0> {

            /* renamed from: b */
            public static final C14413a f5836b = new C14413a();

            public C14413a() {
                super(1);
            }

            @Override // tw.InterfaceC13086l
            /* renamed from: e */
            public final AbstractC1335o0 mo5000c(InterfaceC11539f.b bVar) {
                if (bVar instanceof AbstractC1335o0) {
                    return (AbstractC1335o0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
            super(AbstractC1344t.f5841a, C14413a.f5836b);
        }
    }
}
