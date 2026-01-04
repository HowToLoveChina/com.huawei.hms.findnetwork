package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.b */
/* loaded from: classes4.dex */
public class C9693b implements InterfaceC9942c<Boolean> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, Boolean.valueOf(m60524d(parcel, i10)));
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Boolean bool, int i11, boolean z10) {
        if (bool == null) {
            return;
        }
        C9945f.m61626b(parcel, i10, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    /* renamed from: d */
    public final boolean m60524d(Parcel parcel, int i10) {
        C9943d.m61614d(parcel, i10, 4);
        return parcel.readInt() != 0;
    }
}
