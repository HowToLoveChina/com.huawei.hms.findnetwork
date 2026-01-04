package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.f */
/* loaded from: classes4.dex */
public class C9697f implements InterfaceC9942c<Float> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, Float.valueOf(m60531c(parcel, i10)));
    }

    /* renamed from: c */
    public final float m60531c(Parcel parcel, int i10) {
        C9943d.m61614d(parcel, i10, 4);
        return parcel.readFloat();
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Float f10, int i11, boolean z10) {
        if (f10 == null) {
            return;
        }
        C9945f.m61626b(parcel, i10, 4);
        parcel.writeFloat(f10.floatValue());
    }
}
