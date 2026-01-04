package p703v8;

import com.huawei.android.hicloud.commonlib.space.ReliableSpaceRsp;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import p514o9.C11839m;
import sn.C12818a;

/* renamed from: v8.t */
/* loaded from: classes2.dex */
public class C13383t extends C12818a<ReliableSpaceRsp> {

    /* renamed from: a */
    public C13384u f60326a = new C13384u();

    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "UsedStorageRequestor";
    }

    /* renamed from: e */
    public long m80362e() throws NumberFormatException {
        C11839m.m70688i("UsedStorageReliableRequestor", TrackConstants$Opers.REQUEST);
        long jM80365c = this.f60326a.m80365c();
        if (jM80365c == -1) {
            ReliableSpaceRsp reliableSpaceRspM76961b = m76961b();
            return reliableSpaceRspM76961b != null ? reliableSpaceRspM76961b.getSize() : jM80365c;
        }
        C11839m.m70688i("UsedStorageReliableRequestor", "request savedRsp");
        ReliableSpaceRsp reliableSpaceRsp = new ReliableSpaceRsp();
        reliableSpaceRsp.setSize(jM80365c);
        m76963d(reliableSpaceRsp);
        return jM80365c;
    }
}
