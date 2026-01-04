package ohos.ohos.ohos.ohos.ohos;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ohos.ohos.ohos.ohos.ohos.x */
/* loaded from: classes9.dex */
public interface InterfaceC11900x extends IInterface {

    /* renamed from: ohos.ohos.ohos.ohos.ohos.x$a */
    public static abstract class a extends Binder implements InterfaceC11900x {
        public a() {
            attachInterface(this, "StatusReceiver");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 0) {
                parcel.enforceInterface("OHOS.Appexecfwk.IStatusReceiver");
                mo71403a(parcel.readInt(), parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("StatusReceiver");
            return true;
        }
    }

    /* renamed from: a */
    void mo71403a(int i10, String str);
}
