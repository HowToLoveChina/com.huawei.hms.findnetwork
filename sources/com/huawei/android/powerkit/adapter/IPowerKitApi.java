package com.huawei.android.powerkit.adapter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPowerKitApi extends IInterface {

    /* renamed from: com.huawei.android.powerkit.adapter.IPowerKitApi$a */
    public static abstract class AbstractBinderC4316a extends Binder implements IPowerKitApi {

        /* renamed from: com.huawei.android.powerkit.adapter.IPowerKitApi$a$a */
        public static class a implements IPowerKitApi {

            /* renamed from: a */
            public IBinder f19700a;

            public a(IBinder iBinder) {
                this.f19700a = iBinder;
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean applyForResourceUse(String str, boolean z10, String str2, int i10, long j10, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str3);
                    this.f19700a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19700a;
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean disableStateEvent(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeInt(i10);
                    this.f19700a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean enableStateEvent(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeInt(i10);
                    this.f19700a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public String getPowerKitVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeString(str);
                    this.f19700a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean registerSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    this.f19700a.transact(5, parcelObtain, parcelObtain2, 0);
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

            @Override // com.huawei.android.powerkit.adapter.IPowerKitApi
            public boolean unregisterSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    this.f19700a.transact(6, parcelObtain, parcelObtain2, 0);
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
        public static IPowerKitApi m25949a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.powerkit.adapter.IPowerKitApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPowerKitApi)) ? new a(iBinder) : (IPowerKitApi) iInterfaceQueryLocalInterface;
        }
    }

    boolean applyForResourceUse(String str, boolean z10, String str2, int i10, long j10, String str3) throws RemoteException;

    boolean disableStateEvent(int i10) throws RemoteException;

    boolean enableStateEvent(int i10) throws RemoteException;

    String getPowerKitVersion(String str) throws RemoteException;

    boolean registerSink(IStateSink iStateSink) throws RemoteException;

    boolean unregisterSink(IStateSink iStateSink) throws RemoteException;
}
