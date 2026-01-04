package p638sf;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import eg.AbstractC9478g;
import p616rk.C12515a;
import p809yg.C13981a;

/* renamed from: sf.b */
/* loaded from: classes4.dex */
public class C12795b {

    /* renamed from: sf.b$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f58476a;

        /* renamed from: b */
        public final /* synthetic */ Context f58477b;

        public a(String str, Context context) {
            this.f58476a = str;
            this.f58477b = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("StartLossModeRetry", "uploadReportCache task start");
            RequestModeConfig.getInstance().setMode(3, false);
            C4346d.m26225d(3, this.f58476a, null, this.f58477b);
        }
    }

    /* renamed from: a */
    public static void m76765a(Context context) {
        C12794a.m76762a(context, "startlossmode_retry");
    }

    /* renamed from: b */
    public static void m76766b(Context context, String str) {
        C12794a.m76764c(context, "startlossmode_retry", str);
    }

    /* renamed from: c */
    public static void m76767c(Context context) {
        String strM76763b = C12794a.m76763b(context, "startlossmode_retry");
        if (TextUtils.isEmpty(strM76763b)) {
            return;
        }
        m76765a(context);
        C12515a.m75110o().m75172d(new a(strM76763b, context));
        C13981a.m83989i("StartLossModeRetry", "uploadReportCache task add");
    }
}
