package p434kt;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: kt.f */
/* loaded from: classes2.dex */
public abstract class AbstractC11152f {

    /* renamed from: a */
    public static final List<String> f52496a = new ArrayList();

    /* renamed from: a */
    public static void m67069a(Context context) {
        List<String> list = f52496a;
        list.clear();
        list.add(AbstractC11151e.m67065a(context));
        list.add(AbstractC11151e.m67066b(context));
        list.add(AbstractC11151e.m67067c(context));
        list.add(AbstractC11151e.m67068d(context));
    }

    /* renamed from: b */
    public static boolean m67070b(String str) {
        List<String> list = f52496a;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }
}
