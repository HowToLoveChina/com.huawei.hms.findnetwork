package zw;

import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p692uw.C13267j;

/* renamed from: zw.a */
/* loaded from: classes9.dex */
public final class C14392a<T> implements InterfaceC14393b<T> {

    /* renamed from: a */
    public final AtomicReference<InterfaceC14393b<T>> f63766a;

    public C14392a(InterfaceC14393b<? extends T> interfaceC14393b) {
        C13267j.m79677e(interfaceC14393b, VastAttribute.SEQUENCE);
        this.f63766a = new AtomicReference<>(interfaceC14393b);
    }

    @Override // zw.InterfaceC14393b
    public Iterator<T> iterator() {
        InterfaceC14393b<T> andSet = this.f63766a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
