package p546p6;

import android.content.Intent;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import java.util.ArrayList;
import p015ak.C0213f;
import p031b7.C1120a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12947g;
import p664u0.C13108a;

/* renamed from: p6.n */
/* loaded from: classes2.dex */
public class C12101n extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C1120a.m6677i("GetPicTabCountTask", "GetPicTabCountTask call");
        C12947g c12947g = new C12947g();
        C1120a.m6675d("GetPicTabCountTask", "GetPicTabCountTask start query");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<DayModeGroup> arrayListM77806S = c12947g.m77806S();
        C1120a.m6675d("GetPicTabCountTask", "useTime = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        C1120a.m6675d("GetPicTabCountTask", "GetPicTabCountTask end query");
        if (arrayListM77806S.size() == 0) {
            C1120a.m6676e("GetPicTabCountTask", "GetPicTabCountTask mediaRaws is null");
        }
        if (C12091d.m72280a0().m72377q("", arrayListM77806S)) {
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.getPicTabList");
        C12091d.m72280a0().m72357h1("", arrayListM77806S);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_SHARE_UI;
    }
}
