package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.android.hms.ppskit.d */
/* loaded from: classes.dex */
public interface InterfaceC4313d extends IInterface {

    /* renamed from: com.huawei.android.hms.ppskit.d$a */
    public static abstract class a extends Binder implements InterfaceC4313d {

        /* renamed from: com.huawei.android.hms.ppskit.d$a$a, reason: collision with other inner class name */
        public static class C14424a implements InterfaceC4313d {

            /* renamed from: b */
            public static InterfaceC4313d f19693b;

            /* renamed from: a */
            public IBinder f19694a;

            public C14424a(IBinder iBinder) {
                this.f19694a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19694a;
            }
        }

        public a() {
            attachInterface(this, "com.huawei.android.hms.ppskit.IPPSResultCallback");
        }

        /* renamed from: a */
        public static InterfaceC4313d m25941a() {
            return C14424a.f19693b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.hms.ppskit.IPPSResultCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.android.hms.ppskit.IPPSResultCallback");
            mo25940a(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static InterfaceC4313d m25942a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSResultCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4313d)) ? new C14424a(iBinder) : (InterfaceC4313d) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo25940a(String str, int i10, String str2);
}
