package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.android.hms.ppskit.e */
/* loaded from: classes.dex */
public interface InterfaceC4314e extends IInterface {

    /* renamed from: com.huawei.android.hms.ppskit.e$a */
    public static abstract class a extends Binder implements InterfaceC4314e {

        /* renamed from: com.huawei.android.hms.ppskit.e$a$a, reason: collision with other inner class name */
        public static class C14425a implements InterfaceC4314e {

            /* renamed from: b */
            public static InterfaceC4314e f19695b;

            /* renamed from: a */
            public IBinder f19696a;

            public C14425a(IBinder iBinder) {
                this.f19696a = iBinder;
            }

            @Override // com.huawei.android.hms.ppskit.InterfaceC4314e
            /* renamed from: a */
            public void mo25943a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSServiceApi");
                    if (this.f19696a.transact(1, parcelObtain, parcelObtain2, 0) || a.m25946g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m25946g().mo25943a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19696a;
            }

            @Override // com.huawei.android.hms.ppskit.InterfaceC4314e
            /* renamed from: a */
            public void mo25944a(String str, String str2, InterfaceC4313d interfaceC4313d) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSServiceApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(interfaceC4313d != null ? interfaceC4313d.asBinder() : null);
                    if (this.f19696a.transact(2, parcelObtain, parcelObtain2, 0) || a.m25946g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m25946g().mo25944a(str, str2, interfaceC4313d);
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
        public static InterfaceC4314e m25945a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSServiceApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4314e)) ? new C14425a(iBinder) : (InterfaceC4314e) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC4314e m25946g() {
            return C14425a.f19695b;
        }
    }

    /* renamed from: a */
    void mo25943a();

    /* renamed from: a */
    void mo25944a(String str, String str2, InterfaceC4313d interfaceC4313d);
}
