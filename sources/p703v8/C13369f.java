package p703v8;

import android.content.Context;
import com.huawei.android.hicloud.cloudspace.bean.DiskStorageInfo;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import p514o9.C11839m;
import sn.C12818a;

/* renamed from: v8.f */
/* loaded from: classes2.dex */
public class C13369f extends C12818a<DiskStorageInfo> {

    /* renamed from: a */
    public C13372i f60279a = new C13372i();

    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "DiskStorageRequestor";
    }

    /* renamed from: e */
    public DiskStorageInfo m80269e(Context context, long j10, long j11) throws Throwable {
        C11839m.m70688i("DiskReliableRequestor", TrackConstants$Opers.REQUEST);
        DiskStorageInfo diskStorageInfoM80288q = this.f60279a.m80288q(context, j10, j11);
        if (diskStorageInfoM80288q == null) {
            return m76961b();
        }
        C11839m.m70688i("DiskReliableRequestor", "saveReqeust");
        m76963d(diskStorageInfoM80288q);
        return diskStorageInfoM80288q;
    }
}
