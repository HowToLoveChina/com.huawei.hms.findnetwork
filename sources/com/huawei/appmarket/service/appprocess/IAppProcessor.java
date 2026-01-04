package com.huawei.appmarket.service.appprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IAppProcessor extends IInterface {

    /* renamed from: com.huawei.appmarket.service.appprocess.IAppProcessor$a */
    public static abstract class AbstractBinderC4587a extends Binder implements IAppProcessor {

        /* renamed from: com.huawei.appmarket.service.appprocess.IAppProcessor$a$a */
        public static class a implements IAppProcessor {

            /* renamed from: a */
            public IBinder f21107a;

            public a(IBinder iBinder) {
                this.f21107a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21107a;
            }

            @Override // com.huawei.appmarket.service.appprocess.IAppProcessor
            public int installEvent(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.appmarket.service.appprocess.IAppProcessor");
                    C4588b.m28126b(parcelObtain, bundle, 0);
                    this.f21107a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static IAppProcessor m28124a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.service.appprocess.IAppProcessor");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAppProcessor)) ? new a(iBinder) : (IAppProcessor) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: com.huawei.appmarket.service.appprocess.IAppProcessor$b */
    public static class C4588b {
        /* renamed from: b */
        public static <T extends Parcelable> void m28126b(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    int installEvent(Bundle bundle) throws RemoteException;
}
