package gh;

import android.os.Parcel;

/* renamed from: gh.f */
/* loaded from: classes4.dex */
public final class C9945f {
    /* renamed from: a */
    public static void m61625a(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    /* renamed from: b */
    public static void m61626b(Parcel parcel, int i10, int i11) {
        if (i11 < 65535) {
            parcel.writeInt(i10 | (i11 << 16));
        } else {
            parcel.writeInt(i10 | (-65536));
            parcel.writeInt(i11);
        }
    }

    /* renamed from: c */
    public static int m61627c(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
}
