package p290fh;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p290fh.C9704m;

/* renamed from: fh.k */
/* loaded from: classes4.dex */
public class C9702k implements InterfaceC9942c<List> {
    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        Class clsSubClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        field.set(autoParcelable, (clsSubClass == null || !Parcelable.class.isAssignableFrom(clsSubClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) ? m60541d(parcel, i10, C9944e.m61618b(clsSubClass)) : m60540c(parcel, i10, clsSubClass));
    }

    /* renamed from: c */
    public final <T extends Parcelable> ArrayList<T> m60540c(Parcel parcel, int i10, Class cls) {
        C9941b c9941b;
        StringBuilder sb2;
        String str;
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        ArrayList<T> arrayListCreateTypedArrayList = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            Parcelable.Creator creatorM60547c = C9704m.m60547c(cls);
            if (creatorM60547c != null) {
                arrayListCreateTypedArrayList = parcel.createTypedArrayList(creatorM60547c);
            }
        } catch (C9704m.a e10) {
            e = e10;
            c9941b = C9941b.f48706a;
            sb2 = new StringBuilder();
            str = "error getCreator:";
            sb2.append(str);
            sb2.append(e.getMessage());
            c9941b.m61610d("ListTypeProcess", sb2.toString());
            parcel.setDataPosition(iDataPosition + iM61613c);
            return arrayListCreateTypedArrayList;
        } catch (Exception e11) {
            e = e11;
            c9941b = C9941b.f48706a;
            sb2 = new StringBuilder();
            str = "error readParcelableList:";
            sb2.append(str);
            sb2.append(e.getMessage());
            c9941b.m61610d("ListTypeProcess", sb2.toString());
            parcel.setDataPosition(iDataPosition + iM61613c);
            return arrayListCreateTypedArrayList;
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return arrayListCreateTypedArrayList;
    }

    /* renamed from: d */
    public final ArrayList m60541d(Parcel parcel, int i10, ClassLoader classLoader) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        ArrayList arrayList = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            arrayList = parcel.readArrayList(classLoader);
        } catch (Exception e10) {
            C9941b.f48706a.m61610d("ListTypeProcess", "error readList:" + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return arrayList;
    }

    /* renamed from: e */
    public final <T extends Parcelable> void m60542e(Parcel parcel, int i10, List<T> list, int i11, boolean z10) {
        if (list == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM61627c = C9945f.m61627c(parcel, i10);
        parcel.writeInt(list.size());
        for (T t10 : list) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                C9704m.m60549e(parcel, t10, i11);
            }
        }
        C9945f.m61625a(parcel, iM61627c);
    }

    /* renamed from: f */
    public final void m60543f(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeList(list);
            C9945f.m61625a(parcel, iM61627c);
        }
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, List list, int i11, boolean z10) {
        Class clsSubClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        if (clsSubClass == null || !Parcelable.class.isAssignableFrom(clsSubClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) {
            m60543f(parcel, i10, list, z10);
        } else {
            m60542e(parcel, i10, list, i11, z10);
        }
    }
}
