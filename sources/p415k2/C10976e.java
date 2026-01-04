package p415k2;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import java.security.MessageDigest;
import p306g2.C9853e;
import p630s2.C12676k;
import p759x1.InterfaceC13688m;
import p829z1.InterfaceC14083v;

/* renamed from: k2.e */
/* loaded from: classes.dex */
public class C10976e implements InterfaceC13688m<C10973b> {

    /* renamed from: b */
    public final InterfaceC13688m<Bitmap> f52010b;

    public C10976e(InterfaceC13688m<Bitmap> interfaceC13688m) {
        this.f52010b = (InterfaceC13688m) C12676k.m76276d(interfaceC13688m);
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        this.f52010b.mo56817a(messageDigest);
    }

    @Override // p759x1.InterfaceC13688m
    /* renamed from: b */
    public InterfaceC14083v<C10973b> mo60257b(Context context, InterfaceC14083v<C10973b> interfaceC14083v, int i10, int i11) {
        C10973b c10973b = interfaceC14083v.get();
        InterfaceC14083v<Bitmap> c9853e = new C9853e(c10973b.m66307e(), ComponentCallbacks2C1546b.m8898c(context).m8907f());
        InterfaceC14083v<Bitmap> interfaceC14083vMo60257b = this.f52010b.mo60257b(context, c9853e, i10, i11);
        if (!c9853e.equals(interfaceC14083vMo60257b)) {
            c9853e.mo60254a();
        }
        c10973b.m66315m(this.f52010b, interfaceC14083vMo60257b.get());
        return interfaceC14083v;
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (obj instanceof C10976e) {
            return this.f52010b.equals(((C10976e) obj).f52010b);
        }
        return false;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return this.f52010b.hashCode();
    }
}
