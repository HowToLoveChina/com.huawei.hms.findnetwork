package p732w8;

import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p703v8.C13370g;

/* renamed from: w8.k */
/* loaded from: classes2.dex */
public class C13560k extends AbstractC12367d {

    /* renamed from: a */
    public Handler f60983a;

    public C13560k(Handler handler) {
        this.f60983a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f60983a);
        FamilyDetailInfoResult familyDetailInfoResultM80270a = new C13370g().m80270a();
        if (familyDetailInfoResultM80270a == null) {
            C11839m.m70688i("GetFamilyDetailInfoTask", "get familydetailinfo exception");
            messageObtain.what = 2003;
        } else {
            messageObtain.what = 2002;
            messageObtain.obj = familyDetailInfoResultM80270a;
        }
        this.f60983a.sendMessage(messageObtain);
    }
}
