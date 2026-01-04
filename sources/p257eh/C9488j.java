package p257eh;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: eh.j */
/* loaded from: classes4.dex */
public class C9488j {

    /* renamed from: a */
    public static final Map<String, Map<String, String>> f47264a = new HashMap(1);

    /* renamed from: a */
    public static synchronized String m59346a(Context context, String str) {
        Map<String, String> mapM59343a;
        try {
            String strM59341d = C9486h.m59338a().m59341d(context);
            Map<String, Map<String, String>> map = f47264a;
            Map<String, String> map2 = map.get(strM59341d);
            String str2 = map2 != null ? map2.get(str) : "";
            if (TextUtils.isEmpty(str2) && (mapM59343a = C9487i.m59343a(context, "com.huawei.cloud.agdsdkV02")) != null) {
                map.put(strM59341d, mapM59343a);
                str2 = mapM59343a.get(str);
                m59347b(mapM59343a);
            }
            if (TextUtils.isEmpty(str2)) {
                C9490l.m59352d("ServerUrlCache", "get grs url is empty!");
                return str2;
            }
            return str2 + C8800c.CLIENT_API;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m59347b(Map<String, String> map) {
    }
}
