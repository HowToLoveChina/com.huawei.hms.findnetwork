package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.l */
/* loaded from: classes4.dex */
public class C9703l implements InterfaceC9942c<Long> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, Long.valueOf(m60545c(parcel, i10)));
    }

    /* renamed from: c */
    public final long m60545c(Parcel parcel, int i10) {
        C9943d.m61614d(parcel, i10, 8);
        return parcel.readLong();
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Long l10, int i11, boolean z10) {
        if (l10 == null) {
            return;
        }
        C9945f.m61626b(parcel, i10, 8);
        parcel.writeLong(l10.longValue());
    }
}
