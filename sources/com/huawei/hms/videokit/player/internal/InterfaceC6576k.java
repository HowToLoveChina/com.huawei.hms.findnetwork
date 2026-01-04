package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* renamed from: com.huawei.hms.videokit.player.internal.k */
/* loaded from: classes8.dex */
public interface InterfaceC6576k extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.k$a */
    public static abstract class a extends Binder implements InterfaceC6576k {

        /* renamed from: com.huawei.hms.videokit.player.internal.k$a$a, reason: collision with other inner class name */
        public static class C14447a implements InterfaceC6576k {

            /* renamed from: b */
            public static InterfaceC6576k f30528b;

            /* renamed from: a */
            private IBinder f30529a;

            public C14447a(IBinder iBinder) {
                this.f30529a = iBinder;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6576k
            /* renamed from: a */
            public IBinder mo37421a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
                IBinder strongBinder;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IServiceBinder");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeStrongBinder(iObjectWrapper2 != null ? iObjectWrapper2.asBinder() : null);
                    parcelObtain.writeStrongBinder(iObjectWrapper3 != null ? iObjectWrapper3.asBinder() : null);
                    if (this.f30529a.transact(4, parcelObtain, parcelObtain2, 0) || a.m37424g() == null) {
                        parcelObtain2.readException();
                        strongBinder = parcelObtain2.readStrongBinder();
                    } else {
                        strongBinder = a.m37424g().mo37421a(iObjectWrapper, iObjectWrapper2, iObjectWrapper3);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return strongBinder;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30529a;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6576k
            /* renamed from: d */
            public void mo37422d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IServiceBinder");
                    if (this.f30529a.transact(2, parcelObtain, parcelObtain2, 0) || a.m37424g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37424g().mo37422d();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC6576k m37423a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.videokit.player.internal.IServiceBinder");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC6576k)) ? new C14447a(iBinder) : (InterfaceC6576k) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC6576k m37424g() {
            return C14447a.f30528b;
        }
    }

    /* renamed from: a */
    IBinder mo37421a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    /* renamed from: d */
    void mo37422d() throws RemoteException;
}
