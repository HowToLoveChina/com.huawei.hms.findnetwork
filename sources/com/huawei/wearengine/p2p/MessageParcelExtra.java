package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public class MessageParcelExtra extends MessageParcel implements Parcelable {
    public static final Parcelable.Creator<MessageParcelExtra> CREATOR = new C8898a();

    /* renamed from: g */
    public String f45337g;

    /* renamed from: com.huawei.wearengine.p2p.MessageParcelExtra$a */
    public class C8898a implements Parcelable.Creator<MessageParcelExtra> {
        @Override // android.os.Parcelable.Creator
        public MessageParcelExtra createFromParcel(Parcel parcel) {
            MessageParcelExtra messageParcelExtra = new MessageParcelExtra();
            if (parcel != null) {
                int i10 = parcel.readInt();
                messageParcelExtra.m56577p(i10);
                if (MessageParcelExtra.m56580i(i10)) {
                    messageParcelExtra.m56572j(parcel.createByteArray());
                } else {
                    messageParcelExtra.m56576o(parcel.readFileDescriptor());
                }
                messageParcelExtra.m56574m(parcel.readString());
                messageParcelExtra.m56573l(parcel.readString());
                messageParcelExtra.m56575n(parcel.readString());
                messageParcelExtra.m56581r(parcel.readString());
            }
            return messageParcelExtra;
        }

        @Override // android.os.Parcelable.Creator
        public MessageParcelExtra[] newArray(int i10) {
            return (i10 > 65535 || i10 < 0) ? new MessageParcelExtra[0] : new MessageParcelExtra[i10];
        }
    }

    /* renamed from: i */
    public static boolean m56580i(int i10) {
        return i10 == 1;
    }

    /* renamed from: r */
    public void m56581r(String str) {
        this.f45337g = str;
    }

    @Override // com.huawei.wearengine.p2p.MessageParcel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        m56578q(parcel);
        parcel.writeString(this.f45337g);
    }
}
