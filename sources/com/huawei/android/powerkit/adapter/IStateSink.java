package com.huawei.android.powerkit.adapter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStateSink extends IInterface {

    /* renamed from: com.huawei.android.powerkit.adapter.IStateSink$a */
    public static abstract class AbstractBinderC4317a extends Binder implements IStateSink {
        public AbstractBinderC4317a() {
            attachInterface(this, "com.huawei.android.powerkit.adapter.IStateSink");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.android.powerkit.adapter.IStateSink");
                onPowerOverUsing(parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.huawei.android.powerkit.adapter.IStateSink");
                onStateChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface("com.huawei.android.powerkit.adapter.IStateSink");
                onPowerBaseLineUsing(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("com.huawei.android.powerkit.adapter.IStateSink");
            return true;
        }
    }

    void onPowerBaseLineUsing(String str, String str2, long j10, int i10, String str3) throws RemoteException;

    void onPowerOverUsing(String str, int i10, long j10, long j11, String str2) throws RemoteException;

    void onStateChanged(int i10, int i11, int i12, String str, int i13) throws RemoteException;
}
