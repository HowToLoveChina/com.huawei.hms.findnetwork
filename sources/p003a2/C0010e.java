package p003a2;

import android.graphics.Bitmap;

/* renamed from: a2.e */
/* loaded from: classes.dex */
public class C0010e implements InterfaceC0009d {
    @Override // p003a2.InterfaceC0009d
    /* renamed from: a */
    public void mo14a(int i10) {
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: b */
    public void mo15b(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: c */
    public Bitmap mo16c(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // p003a2.InterfaceC0009d
    public void clearMemory() {
    }

    @Override // p003a2.InterfaceC0009d
    /* renamed from: d */
    public Bitmap mo17d(int i10, int i11, Bitmap.Config config) {
        return mo16c(i10, i11, config);
    }
}
