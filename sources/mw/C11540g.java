package mw;

import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.Serializable;
import mw.InterfaceC11539f;
import p692uw.C13267j;
import tw.InterfaceC13090p;

/* renamed from: mw.g */
/* loaded from: classes9.dex */
public final class C11540g implements InterfaceC11539f, Serializable {

    /* renamed from: a */
    public static final C11540g f53497a = new C11540g();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return f53497a;
    }

    @Override // mw.InterfaceC11539f
    public <R> R fold(R r10, InterfaceC13090p<? super R, ? super InterfaceC11539f.b, ? extends R> interfaceC13090p) {
        C13267j.m79677e(interfaceC13090p, "operation");
        return r10;
    }

    @Override // mw.InterfaceC11539f
    public <E extends InterfaceC11539f.b> E get(InterfaceC11539f.c<E> cVar) {
        C13267j.m79677e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f minusKey(InterfaceC11539f.c<?> cVar) {
        C13267j.m79677e(cVar, "key");
        return this;
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f plus(InterfaceC11539f interfaceC11539f) {
        C13267j.m79677e(interfaceC11539f, ParamConstants.Param.CONTEXT);
        return interfaceC11539f;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
