package com.huawei.openalliance.p169ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.hsf.c */
/* loaded from: classes2.dex */
public interface InterfaceC7194c extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.hsf.c$a */
    public static abstract class a extends Binder implements InterfaceC7194c {

        /* renamed from: com.huawei.openalliance.ad.hsf.c$a$a, reason: collision with other inner class name */
        public static class C14463a implements InterfaceC7194c {

            /* renamed from: a */
            private IBinder f33121a;

            public C14463a(IBinder iBinder) {
                this.f33121a = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7194c
            /* renamed from: a */
            public void mo43858a(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.f33121a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33121a;
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hsf.pm.service.IPackageInstalledCallback");
        }

        /* renamed from: a */
        public static InterfaceC7194c m43865a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC7194c)) ? new C14463a(iBinder) : (InterfaceC7194c) iInterfaceQueryLocalInterface;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("IPackageInstalledCallback", "IPackageInstalledCallback err: " + th2.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.hsf.pm.service.IPackageInstalledCallback");
                mo43858a(parcel.readString(), parcel.readInt());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("com.huawei.hsf.pm.service.IPackageInstalledCallback");
            return true;
        }
    }

    /* renamed from: a */
    void mo43858a(String str, int i10);
}
