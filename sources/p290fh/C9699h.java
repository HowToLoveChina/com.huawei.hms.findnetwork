package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.h */
/* loaded from: classes4.dex */
public class C9699h implements InterfaceC9942c<int[]> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60536d(parcel, i10));
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, int[] iArr, int i11, boolean z10) {
        if (iArr == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeIntArray(iArr);
            C9945f.m61625a(parcel, iM61627c);
        }
    }

    /* renamed from: d */
    public final int[] m60536d(Parcel parcel, int i10) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        int[] iArrCreateIntArray = new int[0];
        if (iM61613c == 0) {
            return iArrCreateIntArray;
        }
        try {
            iArrCreateIntArray = parcel.createIntArray();
        } catch (Exception e10) {
            C9941b.f48706a.m61610d("IntegerArrayTypeProcess", "error readIntArray:" + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return iArrCreateIntArray;
    }
}
