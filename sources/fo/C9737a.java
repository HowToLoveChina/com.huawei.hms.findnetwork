package fo;

import com.huawei.hicloud.request.appmashup.bean.C4984c;
import java.util.concurrent.CountDownLatch;
import p264eo.InterfaceC9529b;
import p343ho.C10331b;
import p514o9.C11839m;
import p616rk.C12515a;

/* renamed from: fo.a */
/* loaded from: classes6.dex */
public class C9737a {

    /* renamed from: fo.a$a */
    public static class a {

        /* renamed from: a */
        public static C9737a f47992a = new C9737a();
    }

    /* renamed from: a */
    public static C9737a m60788a() {
        return a.f47992a;
    }

    /* renamed from: b */
    public void m60789b(C4984c c4984c, InterfaceC9529b interfaceC9529b, String str, CountDownLatch countDownLatch) {
        if (c4984c == null) {
            C11839m.m70687e("AppMashupManager", "getParamsTask getParamsNeedData is null!");
            if (countDownLatch != null) {
                countDownLatch.countDown();
                return;
            }
            return;
        }
        C11839m.m70688i("AppMashupManager", "getParamsTask provider =  " + c4984c.m30017d());
        C11839m.m70686d("AppMashupManager", "getParamsTask pushContext =  " + c4984c.m30018e());
        C12515a.m75110o().m75175e(new C10331b(c4984c, interfaceC9529b, str), false);
    }
}
