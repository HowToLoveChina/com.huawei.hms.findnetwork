package p703v8;

import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import p052cb.C1414k;
import p514o9.C11839m;
import sn.C12818a;

/* renamed from: v8.s */
/* loaded from: classes2.dex */
public class C13382s extends C12818a<TotalStorageInfo> {

    /* renamed from: a */
    public C13384u f60325a = new C13384u();

    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "TotalStorageRequestor";
    }

    /* renamed from: e */
    public TotalStorageInfo m80361e() throws C1414k {
        C11839m.m70688i("TotalStorageReliableRequestor", TrackConstants$Opers.REQUEST);
        TotalStorageInfo totalStorageInfoM80364b = this.f60325a.m80364b();
        if (totalStorageInfoM80364b == null) {
            return m76961b();
        }
        C11839m.m70688i("TotalStorageReliableRequestor", "request  saveReqeust");
        m76963d(totalStorageInfoM80364b);
        return totalStorageInfoM80364b;
    }
}
