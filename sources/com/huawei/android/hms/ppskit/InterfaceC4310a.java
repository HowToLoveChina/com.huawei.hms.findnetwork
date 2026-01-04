package com.huawei.android.hms.ppskit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.android.hms.ppskit.a */
/* loaded from: classes.dex */
public interface InterfaceC4310a extends IInterface {

    /* renamed from: com.huawei.android.hms.ppskit.a$a */
    public static abstract class a extends Binder implements InterfaceC4310a {

        /* renamed from: com.huawei.android.hms.ppskit.a$a$a, reason: collision with other inner class name */
        public static class C14421a implements InterfaceC4310a {

            /* renamed from: b */
            public static InterfaceC4310a f19687b;

            /* renamed from: a */
            public IBinder f19688a;

            public C14421a(IBinder iBinder) {
                this.f19688a = iBinder;
            }

            @Override // com.huawei.android.hms.ppskit.InterfaceC4310a
            /* renamed from: a */
            public String mo25930a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                    parcelObtain.writeString(str);
                    if (!this.f19688a.transact(4, parcelObtain, parcelObtain2, 0) && a.m25933g() != null) {
                        return a.m25933g().mo25930a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19688a;
            }

            @Override // com.huawei.android.hms.ppskit.InterfaceC4310a
            /* renamed from: a */
            public void mo25931a(String str, String str2, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    if (this.f19688a.transact(2, parcelObtain, parcelObtain2, 0) || a.m25933g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m25933g().mo25931a(str, str2, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC4310a m25932a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hms.ppskit.IPPSChannelInfoService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4310a)) ? new C14421a(iBinder) : (InterfaceC4310a) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC4310a m25933g() {
            return C14421a.f19687b;
        }
    }

    /* renamed from: a */
    String mo25930a(String str);

    /* renamed from: a */
    void mo25931a(String str, String str2, int i10);
}
