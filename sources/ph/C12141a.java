package ph;

import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p492nh.C11705a;
import p775xh.InterfaceC13814b;

/* renamed from: ph.a */
/* loaded from: classes4.dex */
public class C12141a {

    /* renamed from: a */
    public static final Map<String, Class> f56284a;

    /* renamed from: b */
    public static final ThreadPoolExecutor f56285b;

    static {
        HashMap map = new HashMap();
        f56284a = map;
        if (map.size() <= 0) {
            map.put("client.getMarketInfo", C11705a.class);
        }
        f56285b = new ThreadPoolExecutor(6, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Executors.newFixedThreadPool(1);
    }

    /* renamed from: a */
    public static ResponseBean m72778a(RequestBean requestBean) {
        return new AsyncTaskC12142b(requestBean, null).m72780a(requestBean.getContext());
    }

    /* renamed from: b */
    public static AsyncTaskC12142b m72779b(RequestBean requestBean, InterfaceC13814b interfaceC13814b) {
        AsyncTaskC12142b asyncTaskC12142b = new AsyncTaskC12142b(requestBean, interfaceC13814b);
        asyncTaskC12142b.m72786g(f56285b);
        return asyncTaskC12142b;
    }
}
