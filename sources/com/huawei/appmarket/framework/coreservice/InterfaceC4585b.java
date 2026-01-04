package com.huawei.appmarket.framework.coreservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.appmarket.framework.coreservice.b */
/* loaded from: classes4.dex */
public interface InterfaceC4585b extends IInterface {

    /* renamed from: com.huawei.appmarket.framework.coreservice.b$a */
    public static abstract class a extends Binder implements InterfaceC4585b {

        /* renamed from: com.huawei.appmarket.framework.coreservice.b$a$a, reason: collision with other inner class name */
        public static class C14428a implements InterfaceC4585b {

            /* renamed from: b */
            public static InterfaceC4585b f21099b;

            /* renamed from: a */
            public IBinder f21100a;

            public C14428a(IBinder iBinder) {
                this.f21100a = iBinder;
            }

            @Override // com.huawei.appmarket.framework.coreservice.InterfaceC4585b
            /* renamed from: a */
            public void mo28119a(DataHolder dataHolder, InterfaceC4584a interfaceC4584a) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.appmarket.framework.coreservice.IAppGalleryServiceTransport");
                    if (dataHolder != null) {
                        parcelObtain.writeInt(1);
                        dataHolder.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(interfaceC4584a != null ? interfaceC4584a.asBinder() : null);
                    if (this.f21100a.transact(1, parcelObtain, parcelObtain2, 0) || a.m28120g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m28120g().mo28119a(dataHolder, interfaceC4584a);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21100a;
            }
        }

        /* renamed from: g */
        public static InterfaceC4585b m28120g() {
            return C14428a.f21099b;
        }

        /* renamed from: h */
        public static InterfaceC4585b m28121h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryServiceTransport");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4585b)) ? new C14428a(iBinder) : (InterfaceC4585b) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo28119a(DataHolder dataHolder, InterfaceC4584a interfaceC4584a) throws RemoteException;
}
