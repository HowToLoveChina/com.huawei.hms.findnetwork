package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.i */
/* loaded from: classes4.dex */
public class C9700i implements InterfaceC9942c<Integer> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, Integer.valueOf(m60537c(parcel, i10)));
    }

    /* renamed from: c */
    public final int m60537c(Parcel parcel, int i10) {
        C9943d.m61614d(parcel, i10, 4);
        return parcel.readInt();
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Integer num, int i11, boolean z10) {
        if (num == null) {
            return;
        }
        C9945f.m61626b(parcel, i10, 4);
        parcel.writeInt(num.intValue());
    }
}
