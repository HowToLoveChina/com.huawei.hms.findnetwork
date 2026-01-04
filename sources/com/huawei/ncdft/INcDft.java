package com.huawei.ncdft;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public interface INcDft extends IInterface {

    /* renamed from: com.huawei.ncdft.INcDft$a */
    public static abstract class AbstractBinderC6824a extends Binder implements INcDft {

        /* renamed from: com.huawei.ncdft.INcDft$a$a */
        public static class a implements INcDft {

            /* renamed from: a */
            public IBinder f31427a;

            public a(IBinder iBinder) {
                this.f31427a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31427a;
            }

            @Override // com.huawei.ncdft.INcDft
            public void connectivityDftReport(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.ncdft.INcDft");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    this.f31427a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static INcDft m38538a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.ncdft.INcDft");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INcDft)) ? new a(iBinder) : (INcDft) iInterfaceQueryLocalInterface;
        }
    }

    void connectivityDftReport(String str, int i10, String str2) throws RemoteException;
}
