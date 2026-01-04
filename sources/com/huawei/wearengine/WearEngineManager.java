package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface WearEngineManager extends IInterface {

    /* renamed from: com.huawei.wearengine.WearEngineManager$a */
    public static abstract class AbstractBinderC8881a extends Binder implements WearEngineManager {

        /* renamed from: com.huawei.wearengine.WearEngineManager$a$a */
        public static class a implements WearEngineManager {

            /* renamed from: a */
            public IBinder f45261a;

            public a(IBinder iBinder) {
                this.f45261a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45261a;
            }

            @Override // com.huawei.wearengine.WearEngineManager
            public int releaseConnection() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.WearEngineManager");
                    this.f45261a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static WearEngineManager m56497a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.WearEngineManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof WearEngineManager)) ? new a(iBinder) : (WearEngineManager) iInterfaceQueryLocalInterface;
        }
    }

    int releaseConnection();
}
