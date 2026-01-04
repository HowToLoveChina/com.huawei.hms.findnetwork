package zw;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kw.C11186m;
import p692uw.C13267j;

/* renamed from: zw.h */
/* loaded from: classes9.dex */
public class C14399h extends C14398g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: zw.h$a */
    public static final class a<T> implements Iterable<T> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC14393b f63768a;

        public a(InterfaceC14393b interfaceC14393b) {
            this.f63768a = interfaceC14393b;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f63768a.iterator();
        }
    }

    /* renamed from: c */
    public static <T> Iterable<T> m85626c(InterfaceC14393b<? extends T> interfaceC14393b) {
        C13267j.m79677e(interfaceC14393b, "<this>");
        return new a(interfaceC14393b);
    }

    /* renamed from: d */
    public static final <T, C extends Collection<? super T>> C m85627d(InterfaceC14393b<? extends T> interfaceC14393b, C c10) {
        C13267j.m79677e(interfaceC14393b, "<this>");
        C13267j.m79677e(c10, JsbMapKeyNames.H5_CLICK_DEST);
        Iterator<? extends T> it = interfaceC14393b.iterator();
        while (it.hasNext()) {
            c10.add(it.next());
        }
        return c10;
    }

    /* renamed from: e */
    public static <T> List<T> m85628e(InterfaceC14393b<? extends T> interfaceC14393b) {
        C13267j.m79677e(interfaceC14393b, "<this>");
        return C11186m.m67179i(m85629f(interfaceC14393b));
    }

    /* renamed from: f */
    public static final <T> List<T> m85629f(InterfaceC14393b<? extends T> interfaceC14393b) {
        C13267j.m79677e(interfaceC14393b, "<this>");
        return (List) m85627d(interfaceC14393b, new ArrayList());
    }
}
