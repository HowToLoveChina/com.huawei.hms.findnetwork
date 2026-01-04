package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.e */
/* loaded from: classes4.dex */
public class C9696e implements InterfaceC9942c<Double> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, Double.valueOf(m60529c(parcel, i10)));
    }

    /* renamed from: c */
    public final double m60529c(Parcel parcel, int i10) {
        C9943d.m61614d(parcel, i10, 8);
        return parcel.readDouble();
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Double d10, int i11, boolean z10) {
        if (d10 == null) {
            return;
        }
        C9945f.m61626b(parcel, i10, 8);
        parcel.writeDouble(d10.doubleValue());
    }
}
