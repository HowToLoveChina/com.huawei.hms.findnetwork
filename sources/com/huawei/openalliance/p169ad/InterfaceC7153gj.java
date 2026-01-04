package com.huawei.openalliance.p169ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.p169ad.InterfaceC7152gi;

/* renamed from: com.huawei.openalliance.ad.gj */
/* loaded from: classes8.dex */
public interface InterfaceC7153gj extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.gj$a */
    public static abstract class a extends Binder implements InterfaceC7153gj {

        /* renamed from: com.huawei.openalliance.ad.gj$a$a, reason: collision with other inner class name */
        public static class C14459a implements InterfaceC7153gj {

            /* renamed from: a */
            public static InterfaceC7153gj f32929a;

            /* renamed from: b */
            private IBinder f32930b;

            public C14459a(IBinder iBinder) {
                this.f32930b = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7153gj
            /* renamed from: a */
            public void mo43570a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    if (this.f32930b.transact(1, parcelObtain, parcelObtain2, 0) || a.m43574b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m43574b().mo43570a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32930b;
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7153gj
            /* renamed from: b */
            public void mo43572b(InterfaceC7152gi interfaceC7152gi) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(interfaceC7152gi != null ? interfaceC7152gi.asBinder() : null);
                    if (this.f32930b.transact(3, parcelObtain, parcelObtain2, 0) || a.m43574b() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m43574b().mo43572b(interfaceC7152gi);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7153gj
            /* renamed from: a */
            public void mo43571a(InterfaceC7152gi interfaceC7152gi) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(interfaceC7152gi != null ? interfaceC7152gi.asBinder() : null);
                    if (this.f32930b.transact(2, parcelObtain, parcelObtain2, 0) || a.m43574b() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m43574b().mo43571a(interfaceC7152gi);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC7153gj m43573a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC7153gj)) ? new C14459a(iBinder) : (InterfaceC7153gj) iInterfaceQueryLocalInterface;
        }

        /* renamed from: b */
        public static InterfaceC7153gj m43574b() {
            return C14459a.f32929a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                mo43570a();
            } else if (i10 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                mo43571a(InterfaceC7152gi.a.m43569a(parcel.readStrongBinder()));
            } else {
                if (i10 != 3) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                mo43572b(InterfaceC7152gi.a.m43569a(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo43570a();

    /* renamed from: a */
    void mo43571a(InterfaceC7152gi interfaceC7152gi);

    /* renamed from: b */
    void mo43572b(InterfaceC7152gi interfaceC7152gi);
}
