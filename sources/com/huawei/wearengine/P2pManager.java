package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.AuthManager;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.IdentityInfo;
import com.huawei.wearengine.p2p.MessageParcel;
import com.huawei.wearengine.p2p.MessageParcelExtra;
import com.huawei.wearengine.p2p.P2pPingCallback;
import com.huawei.wearengine.p2p.P2pSendCallback;
import com.huawei.wearengine.p2p.ReceiverCallback;

/* loaded from: classes9.dex */
public interface P2pManager extends IInterface {

    /* renamed from: com.huawei.wearengine.P2pManager$a */
    public static abstract class AbstractBinderC8880a extends Binder implements P2pManager {

        /* renamed from: com.huawei.wearengine.P2pManager$a$a */
        public static class a implements P2pManager {

            /* renamed from: a */
            public IBinder f45260a;

            public a(IBinder iBinder) {
                this.f45260a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f45260a;
            }

            @Override // com.huawei.wearengine.P2pManager
            public int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.P2pManager");
                    AuthManager.C8874b.m56490b(parcelObtain, device, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(p2pPingCallback);
                    this.f45260a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.P2pManager
            public int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.P2pManager");
                    AuthManager.C8874b.m56490b(parcelObtain, device, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo2, 0);
                    parcelObtain.writeStrongInterface(receiverCallback);
                    parcelObtain.writeInt(i10);
                    this.f45260a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.P2pManager
            public int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.P2pManager");
                    AuthManager.C8874b.m56490b(parcelObtain, device, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, messageParcel, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo2, 0);
                    parcelObtain.writeStrongInterface(p2pSendCallback);
                    this.f45260a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.P2pManager
            public int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.P2pManager");
                    AuthManager.C8874b.m56490b(parcelObtain, device, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, messageParcelExtra, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo, 0);
                    AuthManager.C8874b.m56490b(parcelObtain, identityInfo2, 0);
                    parcelObtain.writeStrongInterface(p2pSendCallback);
                    this.f45260a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.wearengine.P2pManager
            public int unregisterReceiver(ReceiverCallback receiverCallback, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.wearengine.P2pManager");
                    parcelObtain.writeStrongInterface(receiverCallback);
                    parcelObtain.writeInt(i10);
                    this.f45260a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static P2pManager m56496a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.wearengine.P2pManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof P2pManager)) ? new a(iBinder) : (P2pManager) iInterfaceQueryLocalInterface;
        }
    }

    int ping(Device device, String str, String str2, P2pPingCallback p2pPingCallback);

    int registerReceiver(Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, ReceiverCallback receiverCallback, int i10);

    int send(Device device, MessageParcel messageParcel, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback);

    int sendExtra(Device device, MessageParcelExtra messageParcelExtra, IdentityInfo identityInfo, IdentityInfo identityInfo2, P2pSendCallback p2pSendCallback);

    int unregisterReceiver(ReceiverCallback receiverCallback, int i10);
}
