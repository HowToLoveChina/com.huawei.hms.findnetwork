package com.huawei.openalliance.p169ad.hsf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.hsf.b */
/* loaded from: classes2.dex */
public interface InterfaceC7193b extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.hsf.b$a */
    public static abstract class a extends Binder implements InterfaceC7193b {

        /* renamed from: com.huawei.openalliance.ad.hsf.b$a$a, reason: collision with other inner class name */
        public static class C14462a implements InterfaceC7193b {

            /* renamed from: a */
            private IBinder f33120a;

            public C14462a(IBinder iBinder) {
                this.f33120a = iBinder;
            }

            @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7193b
            /* renamed from: a */
            public int mo43862a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.internal.ICoreService");
                    this.f33120a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33120a;
            }

            @Override // com.huawei.openalliance.p169ad.hsf.InterfaceC7193b
            /* renamed from: a */
            public int mo43863a(String str, List<PPSHsfService> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hsf.internal.ICoreService");
                    parcelObtain.writeString(str);
                    this.f33120a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i10 = parcelObtain2.readInt();
                    parcelObtain2.readTypedList(list, PPSHsfService.CREATOR);
                    return i10;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC7193b m43864a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hsf.internal.ICoreService");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC7193b)) ? new C14462a(iBinder) : (InterfaceC7193b) iInterfaceQueryLocalInterface;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("ICoreService", "ICoreService err: " + th2.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.hsf.internal.ICoreService");
                int iMo43862a = mo43862a();
                parcel2.writeNoException();
                parcel2.writeInt(iMo43862a);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.huawei.hsf.internal.ICoreService");
                return true;
            }
            parcel.enforceInterface("com.huawei.hsf.internal.ICoreService");
            String string = parcel.readString();
            ArrayList arrayList = new ArrayList();
            int iMo43863a = mo43863a(string, arrayList);
            parcel2.writeNoException();
            parcel2.writeInt(iMo43863a);
            parcel2.writeTypedList(arrayList);
            return true;
        }
    }

    /* renamed from: a */
    int mo43862a();

    /* renamed from: a */
    int mo43863a(String str, List<PPSHsfService> list);
}
