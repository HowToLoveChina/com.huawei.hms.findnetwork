package p699v4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p544p4.C12086a;

/* renamed from: v4.s */
/* loaded from: classes.dex */
public class C13350s {

    /* renamed from: a */
    public static final List<String> f60175a = new ArrayList(Arrays.asList("/Pictures/WeiXin", "/Pictures/WeChat", "/Download/WeiXin"));

    /* renamed from: b */
    public static final List<String> f60176b = new ArrayList(Arrays.asList("/xlog", "/crash"));

    /* renamed from: a */
    public static String m80089a(Context context, boolean z10) {
        if (!z10) {
            return C12086a.m72259f(context);
        }
        String str = C13345n.m80071j(context)[0];
        return str != null ? str : "";
    }

    /* renamed from: b */
    public static List<String> m80090b(Context context, boolean z10) {
        String strM80089a = m80089a(context, z10);
        if (TextUtils.isEmpty(strM80089a)) {
            C2111d.m12657m("WechatHelper", "getWechatRecorderDirs root path is empty");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = f60175a.iterator();
        while (it.hasNext()) {
            arrayList.add(strM80089a + it.next());
        }
        arrayList.add(strM80089a + "/tencent/MicroMsg/WeiXin");
        return arrayList;
    }
}
