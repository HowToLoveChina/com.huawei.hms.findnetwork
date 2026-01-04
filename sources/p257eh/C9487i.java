package p257eh;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import java.util.Map;

/* renamed from: eh.i */
/* loaded from: classes4.dex */
public class C9487i {

    /* renamed from: a */
    public static GrsClient f47263a;

    /* renamed from: a */
    public static synchronized Map<String, String> m59343a(Context context, String str) {
        if (f47263a == null) {
            C9490l.m59352d("GrsConfigObtainer", "grs not init ,do init ");
            if (!m59344b(context)) {
                C9490l.m59352d("GrsConfigObtainer", "grs init failed");
                return null;
            }
        }
        return f47263a.synGetGrsUrls(str);
    }

    /* renamed from: b */
    public static boolean m59344b(Context context) {
        C9486h c9486hM59338a = C9486h.m59338a();
        String strM59339b = c9486hM59338a.m59339b(context);
        String strM59341d = c9486hM59338a.m59341d(context);
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        if (!TextUtils.isEmpty(strM59339b)) {
            grsBaseInfo.setAppName(strM59339b);
        }
        if (!TextUtils.isEmpty(strM59341d)) {
            grsBaseInfo.setSerCountry(strM59341d);
        }
        try {
            f47263a = new GrsClient(context, grsBaseInfo);
            return true;
        } catch (NullPointerException unused) {
            C9490l.m59351c("GrsConfigObtainer", "init grs failed,context is null");
            return false;
        }
    }

    /* renamed from: c */
    public static String m59345c(Context context, String str) {
        return C9488j.m59346a(context, str);
    }
}
