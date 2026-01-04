package p306g2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import p003a2.InterfaceC0009d;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.y */
/* loaded from: classes.dex */
public class C9873y implements InterfaceC13686k<Uri, Bitmap> {

    /* renamed from: a */
    public final ResourceDrawableDecoder f48490a;

    /* renamed from: b */
    public final InterfaceC0009d f48491b;

    public C9873y(ResourceDrawableDecoder resourceDrawableDecoder, InterfaceC0009d interfaceC0009d) {
        this.f48490a = resourceDrawableDecoder;
        this.f48491b = interfaceC0009d;
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(Uri uri, int i10, int i11, C13684i c13684i) {
        InterfaceC14083v<Drawable> interfaceC14083vMo9147b = this.f48490a.mo9147b(uri, i10, i11, c13684i);
        if (interfaceC14083vMo9147b == null) {
            return null;
        }
        return C9863o.m61287a(this.f48491b, interfaceC14083vMo9147b.get(), i10, i11);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(Uri uri, C13684i c13684i) {
        return "android.resource".equals(uri.getScheme());
    }
}
