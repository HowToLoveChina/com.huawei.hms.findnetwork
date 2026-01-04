package p290fh;

import android.os.IBinder;
import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.a */
/* loaded from: classes4.dex */
public class C9692a implements InterfaceC9942c<IBinder> {
    /* renamed from: c */
    public static IBinder m60519c(Parcel parcel, int i10) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        IBinder strongBinder = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            strongBinder = parcel.readStrongBinder();
        } catch (Exception e10) {
            C9941b.f48706a.m61610d("BinderTypeProcess", "error readBinder:" + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return strongBinder;
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60519c(parcel, i10));
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, IBinder iBinder, int i11, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
