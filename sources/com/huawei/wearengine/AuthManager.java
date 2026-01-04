package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.wearengine.auth.Permission;

/* loaded from: classes9.dex */
public interface AuthManager extends IInterface {

    /* renamed from: com.huawei.wearengine.AuthManager$a */
    public static abstract class AbstractBinderC8873a extends Binder implements AuthManager {

        /* renamed from: com.huawei.wearengine.AuthManager$a$a */
        public static class a implements AuthManager {

            /* renamed from: a */
            public IBinder f45256a;

            public a(IBinder iBinder) {
                this.f45256a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45256a;
            }

            @Override // com.huawei.wearengine.AuthManager
            public boolean checkPermission(Permission permission) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.AuthManager");
                    if (permission != null) {
                        parcelObtain.writeInt(1);
                        permission.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f45256a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    boolean z10 = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        /* renamed from: a */
        public static AuthManager m56488a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.AuthManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof AuthManager)) ? new a(iBinder) : (AuthManager) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: com.huawei.wearengine.AuthManager$b */
    public static class C8874b {
        /* renamed from: a */
        public static void m56489a(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
            }
        }

        /* renamed from: b */
        public static void m56490b(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
            }
        }
    }

    boolean checkPermission(Permission permission);
}
