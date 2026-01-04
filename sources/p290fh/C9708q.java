package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.q */
/* loaded from: classes4.dex */
public class C9708q implements InterfaceC9942c<String> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60558c(parcel, i10));
    }

    /* renamed from: c */
    public final String m60558c(Parcel parcel, int i10) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iM61613c == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM61613c);
        return string;
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, String str, int i11, boolean z10) {
        if (str == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeString(str);
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
