package p290fh;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9943d;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.m */
/* loaded from: classes4.dex */
public class C9704m implements InterfaceC9942c<Parcelable[]> {

    /* renamed from: fh.m$a */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: c */
    public static Parcelable.Creator m60547c(Class cls) {
        try {
            return (Parcelable.Creator) cls.getDeclaredField("CREATOR").get(null);
        } catch (IllegalAccessException unused) {
            throw new a(cls + " IllegalAccessException");
        } catch (IllegalArgumentException unused2) {
            throw new a(cls + " IllegalArgumentException");
        } catch (NoSuchFieldException unused3) {
            throw new a(cls + " is an Parcelable without CREATOR");
        }
    }

    /* renamed from: d */
    public static Parcelable.Creator m60548d(Field field, Map<String, String> map) throws ClassNotFoundException {
        String str;
        Class<?> type = field.getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        if (type == null || !Parcelable.class.isAssignableFrom(type)) {
            return null;
        }
        String name = field.getName();
        if (map != null && map.get(name) != null && (str = map.get(name)) != null) {
            try {
                type = Class.forName(str);
            } catch (ClassNotFoundException unused) {
                C9941b.f48706a.m61609c("ParcelableArrayTypeProcess", "error clazz:" + str);
                return null;
            }
        }
        return m60547c(type);
    }

    /* renamed from: e */
    public static <T extends Parcelable> void m60549e(Parcel parcel, T t10, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t10.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        field.set(autoParcelable, m60551g(parcel, i10, field));
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, Parcelable[] parcelableArr, int i11, boolean z10) {
        if (parcelableArr == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
                return;
            }
            return;
        }
        int iM61627c = C9945f.m61627c(parcel, i10);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                m60549e(parcel, parcelable, i11);
            }
        }
        C9945f.m61625a(parcel, iM61627c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.os.Parcelable[]] */
    /* renamed from: g */
    public final <T extends Parcelable> T[] m60551g(Parcel parcel, int i10, Field field) {
        int iM61613c = C9943d.m61613c(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        T[] tArr = null;
        if (iM61613c == 0) {
            return null;
        }
        try {
            Parcelable.Creator creatorM60548d = m60548d(field, null);
            if (creatorM60548d != null) {
                tArr = (Parcelable[]) parcel.createTypedArray(creatorM60548d);
            }
        } catch (Exception e10) {
            C9941b.f48706a.m61610d("ParcelableArrayTypeProcess", "error readParcelableArray:" + e10.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iM61613c);
        return tArr;
    }
}
