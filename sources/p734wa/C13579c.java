package p734wa;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p015ak.C0213f;

/* renamed from: wa.c */
/* loaded from: classes3.dex */
public class C13579c extends BitmapDrawable {

    /* renamed from: a */
    public int f61079a;

    /* renamed from: b */
    public int f61080b;

    /* renamed from: c */
    public boolean f61081c;

    public C13579c(Bitmap bitmap) {
        super(C0213f.m1377a().getResources(), bitmap);
        this.f61079a = 0;
        this.f61080b = 0;
        this.f61081c = false;
    }

    /* renamed from: a */
    public final synchronized void m81580a() {
        Bitmap bitmap;
        if (this.f61079a <= 0 && this.f61080b <= 0 && this.f61081c && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* renamed from: b */
    public void m81581b(boolean z10) {
        synchronized (this) {
            try {
                if (z10) {
                    this.f61079a++;
                } else {
                    this.f61079a--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m81580a();
    }
}
