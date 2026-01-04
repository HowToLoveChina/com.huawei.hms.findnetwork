package com.huawei.android.hms.ppskit;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.android.hms.ppskit.b */
/* loaded from: classes.dex */
public interface InterfaceC4311b extends IInterface {

    /* renamed from: com.huawei.android.hms.ppskit.b$a */
    public static abstract class a extends Binder implements InterfaceC4311b {

        /* renamed from: com.huawei.android.hms.ppskit.b$a$a, reason: collision with other inner class name */
        public static class C14422a implements InterfaceC4311b {

            /* renamed from: b */
            public static InterfaceC4311b f19689b;

            /* renamed from: a */
            public IBinder f19690a;

            public C14422a(IBinder iBinder) {
                this.f19690a = iBinder;
            }

            @Override // com.huawei.android.hms.ppskit.InterfaceC4311b
            /* renamed from: a */
            public void mo25934a(RemoteInstallReq remoteInstallReq, Uri uri, InterfaceC4312c interfaceC4312c) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSInstallationService");
                    if (remoteInstallReq != null) {
                        parcelObtain.writeInt(1);
                        remoteInstallReq.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(interfaceC4312c != null ? interfaceC4312c.asBinder() : null);
                    if (this.f19690a.transact(1, parcelObtain, parcelObtain2, 0) || a.m25935g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m25935g().mo25934a(remoteInstallReq, uri, interfaceC4312c);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19690a;
            }
        }

        /* renamed from: g */
        public static InterfaceC4311b m25935g() {
            return C14422a.f19689b;
        }

        /* renamed from: h */
        public static InterfaceC4311b m25936h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSInstallationService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4311b)) ? new C14422a(iBinder) : (InterfaceC4311b) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo25934a(RemoteInstallReq remoteInstallReq, Uri uri, InterfaceC4312c interfaceC4312c);
}
