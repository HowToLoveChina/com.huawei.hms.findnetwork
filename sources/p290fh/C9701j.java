package p290fh;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import gh.C9941b;
import gh.C9945f;
import gh.InterfaceC9942c;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: fh.j */
/* loaded from: classes4.dex */
public class C9701j implements InterfaceC9942c<IInterface> {

    /* renamed from: fh.j$a */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: b */
    public void mo60521b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        C9941b c9941b;
        StringBuilder sb2;
        for (Class<?> cls : field.getType().getDeclaredClasses()) {
            try {
                field.set(autoParcelable, cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, C9692a.m60519c(parcel, i10)));
                return;
            } catch (NoSuchMethodException e10) {
                e = e10;
                c9941b = C9941b.f48706a;
                sb2 = new StringBuilder();
                sb2.append("can not set the interface");
                sb2.append(e.getMessage());
                c9941b.m61610d("InterfaceTypeProcess", sb2.toString());
            } catch (Exception e11) {
                e = e11;
                c9941b = C9941b.f48706a;
                sb2 = new StringBuilder();
                sb2.append("can not set the interface");
                sb2.append(e.getMessage());
                c9941b.m61610d("InterfaceTypeProcess", sb2.toString());
            }
        }
        throw new a("Field has broken interface: " + field);
    }

    @Override // gh.InterfaceC9942c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo60520a(Parcel parcel, Field field, int i10, IInterface iInterface, int i11, boolean z10) {
        if (iInterface == null) {
            if (z10) {
                C9945f.m61626b(parcel, i10, 0);
            }
        } else {
            int iM61627c = C9945f.m61627c(parcel, i10);
            parcel.writeStrongBinder(iInterface.asBinder());
            C9945f.m61625a(parcel, iM61627c);
        }
    }
}
