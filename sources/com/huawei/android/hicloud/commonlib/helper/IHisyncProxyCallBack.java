package com.huawei.android.hicloud.commonlib.helper;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IHisyncProxyCallBack extends IInterface {

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack$a */
    public static abstract class AbstractBinderC2768a extends Binder implements IHisyncProxyCallBack {

        /* renamed from: com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack$a$a */
        public static class a implements IHisyncProxyCallBack {

            /* renamed from: a */
            public IBinder f12033a;

            public a(IBinder iBinder) {
                this.f12033a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12033a;
            }

            @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack
            public void getGrsCallBack(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack");
                    parcelObtain.writeInt(i10);
                    this.f12033a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack
            public void queryHandle(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack");
                    C2769b.m15895b(parcelObtain, message, 0);
                    this.f12033a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static IHisyncProxyCallBack m15893a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHisyncProxyCallBack)) ? new a(iBinder) : (IHisyncProxyCallBack) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: com.huawei.android.hicloud.commonlib.helper.IHisyncProxyCallBack$b */
    public static class C2769b {
        /* renamed from: b */
        public static <T extends Parcelable> void m15895b(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void getGrsCallBack(int i10) throws RemoteException;

    void queryHandle(Message message) throws RemoteException;
}
