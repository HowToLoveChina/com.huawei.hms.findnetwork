package p290fh;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import gh.C9941b;
import gh.C9943d;
import gh.C9944e;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.c */
/* loaded from: classes4.dex */
public class C9694c implements InterfaceC9942c<Bundle> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        Class clsSubClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        field.set(autoParcelable, m60525c(parcel, i10, (clsSubClass == null || !Parcelable.class.isAssignableFrom(clsSubClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) ? C9944e.m61618b(field.getDeclaringClass()) : C9944e.m61618b(clsSubClass)));
    }

    /* renamed from: c */
    public final Bundle m60525c(Parcel parcel, int i10, ClassLoader classLoader) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        Bundle bundle = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            bundle = parcel.readBundle(classLoader);
        } catch (Exception e10) {
            C9941b.f48706a.m61610d("BundleTypeProcess", "error readBundle:" + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return bundle;
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Bundle bundle, int i11, boolean z10) {
        if (bundle == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeBundle(bundle);
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
