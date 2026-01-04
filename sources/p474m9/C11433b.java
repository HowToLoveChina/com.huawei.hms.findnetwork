package p474m9;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import fk.C9721b;
import io.C10582a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p684un.C13230i;
import vn.C13469a;

/* renamed from: m9.b */
/* loaded from: classes3.dex */
public class C11433b extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        HashMap<String, String> resultMap;
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                resultMap = new C10582a(C11058a.m66627b("07019")).m64938i().getResultMap();
            } catch (C9721b e10) {
                C11839m.m70688i("HiCloudDataAnalyzeTask", "HiCloudDataAnalyzeTask error: " + e10.toString());
            }
            if (resultMap != null) {
                C11432a.m68479d().m68487h(resultMap.get("clientLogReport"));
                synchronized (C11433b.class) {
                    try {
                        C11432a.m68479d();
                        boolean zM68481f = C11432a.m68481f();
                        C11432a.m68479d();
                        String strM68480e = C11432a.m68480e();
                        C11432a.m68479d();
                        LinkedHashMap<String, String> linkedHashMapM68478b = C11432a.m68478b();
                        if (zM68481f) {
                            C11839m.m70688i("HiCloudDataAnalyzeTask", "reportOpenCloudSpace");
                            C11432a.m68479d();
                            C11432a.m68484j(false);
                            C11432a.m68479d();
                            C11432a.m68483i("");
                            C11432a.m68479d();
                            C11432a.m68482g(null);
                            if (TextUtils.equals(strM68480e, PriorInstallWay.PRIOR_ACTION_LANDING_PAGE)) {
                                C13230i.m79504I().m79565P0(PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, linkedHashMapM68478b);
                            } else {
                                C13230i.m79504I().m79561L0(strM68480e);
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                C13469a.m81112f().m81118g();
                C13469a.m81112f().m81120i();
                return;
            }
            C11839m.m70687e("HiCloudDataAnalyzeTask", "map is null");
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.DATA_ANALYZE;
    }
}
