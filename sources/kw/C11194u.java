package kw;

import ax.C1037g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p408jw.C10944j;
import p408jw.C10948n;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: kw.u */
/* loaded from: classes9.dex */
public class C11194u extends C11193t {
    /* renamed from: n */
    public static <T> boolean m67184n(Iterable<? extends T> iterable, T t10) {
        C13267j.m79677e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : m67185o(iterable, t10) >= 0;
    }

    /* renamed from: o */
    public static final <T> int m67185o(Iterable<? extends T> iterable, T t10) {
        C13267j.m79677e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                C11186m.m67181k();
            }
            if (C13267j.m79673a(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* renamed from: p */
    public static final <T, A extends Appendable> A m67186p(Iterable<? extends T> iterable, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC13086l<? super T, ? extends CharSequence> interfaceC13086l) throws IOException {
        C13267j.m79677e(iterable, "<this>");
        C13267j.m79677e(a10, "buffer");
        C13267j.m79677e(charSequence, "separator");
        C13267j.m79677e(charSequence2, "prefix");
        C13267j.m79677e(charSequence3, "postfix");
        C13267j.m79677e(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : iterable) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            C1037g.m6256a(a10, t10, interfaceC13086l);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    /* renamed from: q */
    public static final <T> String m67187q(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC13086l<? super T, ? extends CharSequence> interfaceC13086l) {
        C13267j.m79677e(iterable, "<this>");
        C13267j.m79677e(charSequence, "separator");
        C13267j.m79677e(charSequence2, "prefix");
        C13267j.m79677e(charSequence3, "postfix");
        C13267j.m79677e(charSequence4, "truncated");
        String string = ((StringBuilder) m67186p(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, interfaceC13086l)).toString();
        C13267j.m79676d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    /* renamed from: r */
    public static /* synthetic */ String m67188r(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC13086l interfaceC13086l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            interfaceC13086l = null;
        }
        return m67187q(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, interfaceC13086l);
    }

    /* renamed from: s */
    public static <T> T m67189s(Iterable<? extends T> iterable) {
        C13267j.m79677e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) m67190t((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    /* renamed from: t */
    public static final <T> T m67190t(List<? extends T> list) {
        C13267j.m79677e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    /* renamed from: u */
    public static <T, R> List<C10944j<T, R>> m67191u(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        C13267j.m79677e(iterable, "<this>");
        C13267j.m79677e(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C11187n.m67182l(iterable, 10), C11187n.m67182l(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(C10948n.m66075a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
