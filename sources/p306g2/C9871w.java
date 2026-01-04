package p306g2;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.w */
/* loaded from: classes.dex */
public final class C9871w implements InterfaceC13686k<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a */
    public final C9862n f48483a;

    public C9871w(C9862n c9862n) {
        this.f48483a = c9862n;
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, C13684i c13684i) throws IOException {
        return this.f48483a.m61276d(parcelFileDescriptor, i10, i11, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(ParcelFileDescriptor parcelFileDescriptor, C13684i c13684i) {
        return m61311e(parcelFileDescriptor) && this.f48483a.m61281o(parcelFileDescriptor);
    }

    /* renamed from: e */
    public final boolean m61311e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }
}
