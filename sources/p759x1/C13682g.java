package p759x1;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p829z1.InterfaceC14083v;

/* renamed from: x1.g */
/* loaded from: classes.dex */
public class C13682g<T> implements InterfaceC13688m<T> {

    /* renamed from: b */
    public final Collection<? extends InterfaceC13688m<T>> f61611b;

    @SafeVarargs
    public C13682g(InterfaceC13688m<T>... interfaceC13688mArr) {
        if (interfaceC13688mArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f61611b = Arrays.asList(interfaceC13688mArr);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        Iterator<? extends InterfaceC13688m<T>> it = this.f61611b.iterator();
        while (it.hasNext()) {
            it.next().mo56817a(messageDigest);
        }
    }

    @Override // p759x1.InterfaceC13688m
    /* renamed from: b */
    public InterfaceC14083v<T> mo60257b(Context context, InterfaceC14083v<T> interfaceC14083v, int i10, int i11) {
        Iterator<? extends InterfaceC13688m<T>> it = this.f61611b.iterator();
        InterfaceC14083v<T> interfaceC14083v2 = interfaceC14083v;
        while (it.hasNext()) {
            InterfaceC14083v<T> interfaceC14083vMo60257b = it.next().mo60257b(context, interfaceC14083v2, i10, i11);
            if (interfaceC14083v2 != null && !interfaceC14083v2.equals(interfaceC14083v) && !interfaceC14083v2.equals(interfaceC14083vMo60257b)) {
                interfaceC14083v2.mo60254a();
            }
            interfaceC14083v2 = interfaceC14083vMo60257b;
        }
        return interfaceC14083v2;
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (obj instanceof C13682g) {
            return this.f61611b.equals(((C13682g) obj).f61611b);
        }
        return false;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return this.f61611b.hashCode();
    }
}
