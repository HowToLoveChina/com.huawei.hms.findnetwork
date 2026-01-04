package gh;

import android.os.Parcel;

/* renamed from: gh.d */
/* loaded from: classes4.dex */
public final class C9943d {

    /* renamed from: gh.d$a */
    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str);
        }
    }

    /* renamed from: gh.d$b */
    public static class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static int m61611a(int i10) {
        return i10 & 65535;
    }

    /* renamed from: b */
    public static int m61612b(Parcel parcel) {
        int i10 = parcel.readInt();
        int iM61613c = m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (m61611a(i10) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(i10), parcel);
        }
        int i11 = iM61613c + iDataPosition;
        if (i11 >= iDataPosition && i11 <= parcel.dataSize()) {
            return i11;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i11, parcel);
    }

    /* renamed from: c */
    public static int m61613c(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (i10 >> 16) & 65535 : parcel.readInt();
    }

    /* renamed from: d */
    public static void m61614d(Parcel parcel, int i10, int i11) {
        int iM61613c = m61613c(parcel, i10);
        if (iM61613c == i11) {
            return;
        }
        throw new a("Expected size " + i11 + " got " + iM61613c + " (0x" + Integer.toHexString(iM61613c) + ")", parcel);
    }

    /* renamed from: e */
    public static void m61615e(Parcel parcel, int i10) {
        if ((i10 & (-65536)) == -65536) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
        }
    }

    /* renamed from: f */
    public static void m61616f(Parcel parcel, int i10) {
        int iM61613c = m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        int i11 = iDataPosition + iM61613c;
        if (i11 >= iDataPosition && i11 <= parcel.dataSize()) {
            parcel.setDataPosition(i11);
            return;
        }
        throw new b("error length:" + iDataPosition + "-" + iM61613c);
    }
}
