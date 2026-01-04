package com.huawei.hms.ads.installreferrer.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public interface IPPSChannelInfoService extends IInterface {

    public static abstract class Stub {
        private static final String DESCRIPTOR = "com.huawei.android.hms.ppskit.IPPSChannelInfoService";
        static final int TRANSACTION_GETCHANNELINFO = 1;
        static final int TRANSACTION_SETCHANNELINFO = 2;

        public static class Proxy implements IPPSChannelInfoService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.ads.installreferrer.aidl.IPPSChannelInfoService
            public String getChannelInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.hms.ads.installreferrer.aidl.IPPSChannelInfoService
            public void setChannelInfo(String str, String str2, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static IPPSChannelInfoService asInterface(IBinder iBinder) {
            return new Proxy(iBinder);
        }
    }

    String getChannelInfo() throws RemoteException;

    void setChannelInfo(String str, String str2, int i10) throws RemoteException;
}
