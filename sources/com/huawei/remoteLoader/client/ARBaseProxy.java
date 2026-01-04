package com.huawei.remoteLoader.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public abstract class ARBaseProxy implements IInterface {
    private final String mDescriptor;
    private final IBinder mRemote;

    public ARBaseProxy(IBinder iBinder, String str) {
        this.mRemote = iBinder;
        this.mDescriptor = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public Parcel obtainAndWriteInterfaceToken() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.mDescriptor);
        return parcelObtain;
    }

    public Parcel transactAndReadException(int i10, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.mRemote.transact(i10, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RemoteException e10) {
                parcelObtain.recycle();
                throw e10;
            }
        } finally {
            parcel.recycle();
        }
    }

    public void transactAndReadExceptionReturnVoid(int i10, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.mRemote.transact(i10, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public void transactOneway(int i10, Parcel parcel) {
        try {
            this.mRemote.transact(i10, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
