package p394jf;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.remotecontrol.track.C4443e;
import p521og.C11877j;
import p638sf.C12795b;
import p664u0.C13108a;
import p809yg.C13981a;

/* renamed from: jf.e */
/* loaded from: classes4.dex */
public class C10817e {
    /* renamed from: a */
    public static void m65873a(Context context, boolean z10) {
        if (context == null) {
            C13981a.m83988e("LossModeManager", "context null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.remotecontrol.UNREGISTER_ACTION_SCREEN_ON");
        C13108a.m78878b(context).m78881d(intent);
        C10818f.m65874a().m65879f(context, false);
        C10818f.m65874a().m65880g(false);
        AbstractC10816d.m65869e(context, false);
        AbstractC10816d.m65870f(context, "");
        C4443e.m26985i(context);
        C12795b.m76765a(context);
        if (z10) {
            C13981a.m83989i("LossModeManager", "send remote lock changed broadcast");
            context.sendBroadcast(new Intent("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED"), "com.huawei.remotocontrol.permission.REMOTECALL");
        }
        C11877j.m71203D0(context, false);
        C11877j.m71201C0(context, -1);
    }
}
