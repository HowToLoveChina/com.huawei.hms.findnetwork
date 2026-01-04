package p290fh;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fh.g */
/* loaded from: classes4.dex */
public class C9698g implements InterfaceC9942c<HashMap> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60533c(parcel, i10, autoParcelable.getClass().getClassLoader()));
    }

    /* renamed from: c */
    public final HashMap m60533c(Parcel parcel, int i10, ClassLoader classLoader) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        HashMap hashMap = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            hashMap = parcel.readHashMap(classLoader);
        } catch (Exception unused) {
            C9941b.f48706a.m61610d("HashMapTypeProcess", "can not read map");
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return hashMap;
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, HashMap map, int i11, boolean z10) {
        if (map == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeMap(map);
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
