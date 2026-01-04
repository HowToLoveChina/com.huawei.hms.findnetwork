package com.hihonor.android.powerkit.adapter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPowerKitApi extends IInterface {

    /* renamed from: com.hihonor.android.powerkit.adapter.IPowerKitApi$a */
    public static abstract class AbstractBinderC2085a extends Binder implements IPowerKitApi {

        /* renamed from: com.hihonor.android.powerkit.adapter.IPowerKitApi$a$a */
        public static class a implements IPowerKitApi {

            /* renamed from: b */
            public static IPowerKitApi f9454b;

            /* renamed from: a */
            public IBinder f9455a;

            public a(IBinder iBinder) {
                this.f9455a = iBinder;
            }

            @Override // com.hihonor.android.powerkit.adapter.IPowerKitApi
            public boolean applyForResourceUse(String str, boolean z10, String str2, int i10, long j10, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str3);
                    if (!this.f9455a.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC2085a.m12424g() != null) {
                        return AbstractBinderC2085a.m12424g().applyForResourceUse(str, z10, str2, i10, j10, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9455a;
            }

            @Override // com.hihonor.android.powerkit.adapter.IPowerKitApi
            public boolean disableStateEvent(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeInt(i10);
                    if (!this.f9455a.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC2085a.m12424g() != null) {
                        return AbstractBinderC2085a.m12424g().disableStateEvent(i10);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.android.powerkit.adapter.IPowerKitApi
            public boolean enableStateEvent(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeInt(i10);
                    if (!this.f9455a.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC2085a.m12424g() != null) {
                        return AbstractBinderC2085a.m12424g().enableStateEvent(i10);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hihonor.android.powerkit.adapter.IPowerKitApi
            public boolean registerSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    if (!this.f9455a.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC2085a.m12424g() != null) {
                        boolean zRegisterSink = AbstractBinderC2085a.m12424g().registerSink(iStateSink);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zRegisterSink;
                    }
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

            @Override // com.hihonor.android.powerkit.adapter.IPowerKitApi
            public boolean unregisterSink(IStateSink iStateSink) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.android.powerkit.adapter.IPowerKitApi");
                    parcelObtain.writeStrongBinder(iStateSink != null ? iStateSink.asBinder() : null);
                    if (!this.f9455a.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC2085a.m12424g() != null) {
                        boolean zUnregisterSink = AbstractBinderC2085a.m12424g().unregisterSink(iStateSink);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zUnregisterSink;
                    }
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
        public static IPowerKitApi m12423a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.android.powerkit.adapter.IPowerKitApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPowerKitApi)) ? new a(iBinder) : (IPowerKitApi) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static IPowerKitApi m12424g() {
            return a.f9454b;
        }
    }

    boolean applyForResourceUse(String str, boolean z10, String str2, int i10, long j10, String str3) throws RemoteException;

    boolean disableStateEvent(int i10) throws RemoteException;

    boolean enableStateEvent(int i10) throws RemoteException;

    boolean registerSink(IStateSink iStateSink) throws RemoteException;

    boolean unregisterSink(IStateSink iStateSink) throws RemoteException;
}
