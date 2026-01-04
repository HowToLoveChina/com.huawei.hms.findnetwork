package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.android.hms.ppskit.c */
/* loaded from: classes.dex */
public interface InterfaceC4312c extends IInterface {

    /* renamed from: com.huawei.android.hms.ppskit.c$a */
    public static abstract class a extends Binder implements InterfaceC4312c {

        /* renamed from: com.huawei.android.hms.ppskit.c$a$a, reason: collision with other inner class name */
        public static class C14423a implements InterfaceC4312c {

            /* renamed from: b */
            public static InterfaceC4312c f19691b;

            /* renamed from: a */
            public IBinder f19692a;

            public C14423a(IBinder iBinder) {
                this.f19692a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19692a;
            }
        }

        public a() {
            attachInterface(this, "com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
        }

        /* renamed from: a */
        public static InterfaceC4312c m25938a() {
            return C14423a.f19691b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
            mo25937a(parcel.readInt() != 0, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static InterfaceC4312c m25939a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSInstallationServiceCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4312c)) ? new C14423a(iBinder) : (InterfaceC4312c) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo25937a(boolean z10, int i10);
}
