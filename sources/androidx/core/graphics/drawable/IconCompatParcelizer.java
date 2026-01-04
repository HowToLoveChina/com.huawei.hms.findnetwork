package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import p025b1.AbstractC1096a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC1096a abstractC1096a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3434a = abstractC1096a.m6525p(iconCompat.f3434a, 1);
        iconCompat.f3436c = abstractC1096a.m6519j(iconCompat.f3436c, 2);
        iconCompat.f3437d = abstractC1096a.m6527r(iconCompat.f3437d, 3);
        iconCompat.f3438e = abstractC1096a.m6525p(iconCompat.f3438e, 4);
        iconCompat.f3439f = abstractC1096a.m6525p(iconCompat.f3439f, 5);
        iconCompat.f3440g = (ColorStateList) abstractC1096a.m6527r(iconCompat.f3440g, 6);
        iconCompat.f3442i = abstractC1096a.m6529t(iconCompat.f3442i, 7);
        iconCompat.f3443j = abstractC1096a.m6529t(iconCompat.f3443j, 8);
        iconCompat.m3918r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC1096a abstractC1096a) {
        abstractC1096a.m6533x(true, true);
        iconCompat.m3919s(abstractC1096a.m6515f());
        int i10 = iconCompat.f3434a;
        if (-1 != i10) {
            abstractC1096a.m6501F(i10, 1);
        }
        byte[] bArr = iconCompat.f3436c;
        if (bArr != null) {
            abstractC1096a.m6497B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f3437d;
        if (parcelable != null) {
            abstractC1096a.m6503H(parcelable, 3);
        }
        int i11 = iconCompat.f3438e;
        if (i11 != 0) {
            abstractC1096a.m6501F(i11, 4);
        }
        int i12 = iconCompat.f3439f;
        if (i12 != 0) {
            abstractC1096a.m6501F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f3440g;
        if (colorStateList != null) {
            abstractC1096a.m6503H(colorStateList, 6);
        }
        String str = iconCompat.f3442i;
        if (str != null) {
            abstractC1096a.m6505J(str, 7);
        }
        String str2 = iconCompat.f3443j;
        if (str2 != null) {
            abstractC1096a.m6505J(str2, 8);
        }
    }
}
