package p290fh;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.n */
/* loaded from: classes4.dex */
public class C9705n implements InterfaceC9942c<Parcelable> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60552c(parcel, i10, field, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.os.Parcelable] */
    /* renamed from: c */
    public final <T extends Parcelable> T m60552c(Parcel parcel, int i10, Field field, Map<String, String> map) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        T t10 = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            Parcelable.Creator creatorM60548d = C9704m.m60548d(field, map);
            if (creatorM60548d != null) {
                t10 = (Parcelable) creatorM60548d.createFromParcel(parcel);
            }
        } catch (Exception e10) {
            C9941b.f48706a.m61609c("ParcelableTypeProcess", "readParcelable failed: " + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return t10;
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
