package zw;

import java.util.Iterator;
import p692uw.C13267j;

/* renamed from: zw.f */
/* loaded from: classes9.dex */
public class C14397f extends C14396e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: zw.f$a */
    public static final class a<T> implements InterfaceC14393b<T> {

        /* renamed from: a */
        public final /* synthetic */ Iterator f63767a;

        public a(Iterator it) {
            this.f63767a = it;
        }

        @Override // zw.InterfaceC14393b
        public Iterator<T> iterator() {
            return this.f63767a;
        }
    }

    /* renamed from: a */
    public static <T> InterfaceC14393b<T> m85624a(Iterator<? extends T> it) {
        C13267j.m79677e(it, "<this>");
        return m85625b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static final <T> InterfaceC14393b<T> m85625b(InterfaceC14393b<? extends T> interfaceC14393b) {
        C13267j.m79677e(interfaceC14393b, "<this>");
        return interfaceC14393b instanceof C14392a ? interfaceC14393b : new C14392a(interfaceC14393b);
    }
}
