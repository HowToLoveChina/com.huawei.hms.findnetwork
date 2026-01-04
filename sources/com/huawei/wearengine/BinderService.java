package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface BinderService extends IInterface {

    /* renamed from: com.huawei.wearengine.BinderService$a */
    public static abstract class AbstractBinderC8875a extends Binder implements BinderService {

        /* renamed from: com.huawei.wearengine.BinderService$a$a */
        public static class a implements BinderService {

            /* renamed from: a */
            public IBinder f45257a;

            public a(IBinder iBinder) {
                this.f45257a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45257a;
            }

            @Override // com.huawei.wearengine.BinderService
            public void checkPermissionIdentity(String str, String str2, IdentityStoreCallback identityStoreCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.BinderService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(identityStoreCallback);
                    this.f45257a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.BinderService
            public int exchangeApiLevel(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.BinderService");
                    parcelObtain.writeInt(i10);
                    this.f45257a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.BinderService
            public IBinder getBinder(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.BinderService");
                    parcelObtain.writeInt(i10);
                    this.f45257a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.BinderService
            public void registerToken(String str, ClientToken clientToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.BinderService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(clientToken);
                    this.f45257a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static BinderService m56491a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.BinderService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof BinderService)) ? new a(iBinder) : (BinderService) iInterfaceQueryLocalInterface;
        }
    }

    void checkPermissionIdentity(String str, String str2, IdentityStoreCallback identityStoreCallback);

    int exchangeApiLevel(int i10);

    IBinder getBinder(int i10);

    void registerToken(String str, ClientToken clientToken);
}
