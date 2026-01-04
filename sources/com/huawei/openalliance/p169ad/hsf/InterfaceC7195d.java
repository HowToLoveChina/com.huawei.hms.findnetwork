package com.huawei.openalliance.p169ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.hsf.InterfaceC7194c;

/* renamed from: com.huawei.openalliance.ad.hsf.d */
/* loaded from: classes2.dex */
public interface InterfaceC7195d extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.hsf.d$a */
    public static abstract class a extends Binder implements InterfaceC7195d {

        /* renamed from: com.huawei.openalliance.ad.hsf.d$a$a, reason: collision with other inner class name */
        public static class C14464a implements InterfaceC7195d {

            /* renamed from: a */
            private IBinder f33122a;

            public C14464a(IBinder iBinder) {
                this.f33122a = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7195d
            /* renamed from: a */
            public void mo43866a(String str, String str2, InterfaceC7194c interfaceC7194c, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.pm.service.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(interfaceC7194c != null ? interfaceC7194c.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    this.f33122a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
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
                return this.f33122a;
            }
        }

        /* renamed from: a */
        public static InterfaceC7195d m43867a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.pm.service.IPackageManager");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC7195d)) ? new C14464a(iBinder) : (InterfaceC7195d) iInterfaceQueryLocalInterface;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("IPackageManager", "IPackageManager err: " + th2.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.huawei.hsf.pm.service.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.huawei.hsf.pm.service.IPackageManager");
            mo43866a(parcel.readString(), parcel.readString(), InterfaceC7194c.a.m43865a(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo43866a(String str, String str2, InterfaceC7194c interfaceC7194c, int i10);
}
