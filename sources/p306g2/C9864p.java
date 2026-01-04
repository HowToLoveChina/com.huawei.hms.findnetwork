package p306g2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import java.security.MessageDigest;
import p003a2.InterfaceC0009d;
import p759x1.InterfaceC13688m;
import p829z1.InterfaceC14083v;

/* renamed from: g2.p */
/* loaded from: classes.dex */
public class C9864p implements InterfaceC13688m<Drawable> {

    /* renamed from: b */
    public final InterfaceC13688m<Bitmap> f48457b;

    /* renamed from: c */
    public final boolean f48458c;

    public C9864p(InterfaceC13688m<Bitmap> interfaceC13688m, boolean z10) {
        this.f48457b = interfaceC13688m;
        this.f48458c = z10;
    }

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        this.f48457b.mo56817a(messageDigest);
    }

    @Override // p759x1.InterfaceC13688m
    /* renamed from: b */
    public InterfaceC14083v<Drawable> mo60257b(Context context, InterfaceC14083v<Drawable> interfaceC14083v, int i10, int i11) {
        InterfaceC0009d interfaceC0009dM8907f = ComponentCallbacks2C1546b.m8898c(context).m8907f();
        Drawable drawable = interfaceC14083v.get();
        InterfaceC14083v<Bitmap> interfaceC14083vM61287a = C9863o.m61287a(interfaceC0009dM8907f, drawable, i10, i11);
        if (interfaceC14083vM61287a != null) {
            InterfaceC14083v<Bitmap> interfaceC14083vMo60257b = this.f48457b.mo60257b(context, interfaceC14083vM61287a, i10, i11);
            if (!interfaceC14083vMo60257b.equals(interfaceC14083vM61287a)) {
                return m61290d(context, interfaceC14083vMo60257b);
            }
            interfaceC14083vMo60257b.mo60254a();
            return interfaceC14083v;
        }
        if (!this.f48458c) {
            return interfaceC14083v;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    /* renamed from: c */
    public InterfaceC13688m<BitmapDrawable> m61289c() {
        return this;
    }

    /* renamed from: d */
    public final InterfaceC14083v<Drawable> m61290d(Context context, InterfaceC14083v<Bitmap> interfaceC14083v) {
        return C9870v.m61307e(context.getResources(), interfaceC14083v);
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        if (obj instanceof C9864p) {
            return this.f48457b.equals(((C9864p) obj).f48457b);
        }
        return false;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return this.f48457b.hashCode();
    }
}
