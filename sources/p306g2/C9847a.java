package p306g2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.IOException;
import p630s2.C12676k;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.a */
/* loaded from: classes.dex */
public class C9847a<DataType> implements InterfaceC13686k<DataType, BitmapDrawable> {

    /* renamed from: a */
    public final InterfaceC13686k<DataType, Bitmap> f48404a;

    /* renamed from: b */
    public final Resources f48405b;

    public C9847a(Resources resources, InterfaceC13686k<DataType, Bitmap> interfaceC13686k) {
        this.f48405b = (Resources) C12676k.m76276d(resources);
        this.f48404a = (InterfaceC13686k) C12676k.m76276d(interfaceC13686k);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: a */
    public boolean mo9146a(DataType datatype, C13684i c13684i) throws IOException {
        return this.f48404a.mo9146a(datatype, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: b */
    public InterfaceC14083v<BitmapDrawable> mo9147b(DataType datatype, int i10, int i11, C13684i c13684i) throws IOException {
        return C9870v.m61307e(this.f48405b, this.f48404a.mo9147b(datatype, i10, i11, c13684i));
    }
}
