package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.hms.network.embedded.C6069r1;
import cw.C8957b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: dw.k */
/* loaded from: classes9.dex */
public class C9338k {
    /* renamed from: a */
    public String m58689a() {
        return "Last-Query-Time_ucscomponent_ucscomponent.jws";
    }

    /* renamed from: b */
    public Map m58690b(Context context) {
        HashMap map = new HashMap();
        String strM56705d = C8957b.m56705d("ETag_ucscomponent", "", context);
        String strM56705d2 = C8957b.m56705d("Last-Modified_ucscomponent", "", context);
        map.put("ETag", strM56705d);
        map.put(C6069r1.b.f27986o, strM56705d2);
        return map;
    }

    /* renamed from: c */
    public boolean m58691c(Context context) {
        long jM56704c = C8957b.m56704c(m58689a(), 0L, context);
        C1029b.m6234e("LocalCDNFile", "lastQueryTime is " + jM56704c, new Object[0]);
        return System.currentTimeMillis() - jM56704c > 432000000;
    }
}
