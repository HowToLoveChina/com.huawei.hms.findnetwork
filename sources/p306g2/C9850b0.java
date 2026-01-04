package p306g2;

import android.graphics.Bitmap;
import p630s2.C12677l;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.b0 */
/* loaded from: classes.dex */
public final class C9850b0 implements InterfaceC13686k<Bitmap, Bitmap> {

    /* renamed from: g2.b0$a */
    public static final class a implements InterfaceC14083v<Bitmap> {

        /* renamed from: a */
        public final Bitmap f48413a;

        public a(Bitmap bitmap) {
            this.f48413a = bitmap;
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: a */
        public void mo60254a() {
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f48413a;
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: c */
        public Class<Bitmap> mo60255c() {
            return Bitmap.class;
        }

        @Override // p829z1.InterfaceC14083v
        public int getSize() {
            return C12677l.m76284g(this.f48413a);
        }
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(Bitmap bitmap, int i10, int i11, C13684i c13684i) {
        return new a(bitmap);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(Bitmap bitmap, C13684i c13684i) {
        return true;
    }
}
