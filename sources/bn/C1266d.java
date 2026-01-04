package bn;

import android.content.Context;
import bn.C1264b;
import com.huawei.fastengine.fastview.FastSDKEngine;
import com.huawei.hicloud.sync.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import org.json.JSONException;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11841o;

/* renamed from: bn.d */
/* loaded from: classes6.dex */
public final class C1266d {

    /* renamed from: a */
    public final Context f5695a;

    /* renamed from: b */
    public int f5696b = 0;

    /* renamed from: c */
    public boolean f5697c = true;

    /* renamed from: d */
    public String f5698d = "merge";

    /* renamed from: e */
    public boolean f5699e = true;

    public C1266d(Context context) {
        this.f5695a = context.getApplicationContext();
    }

    /* renamed from: d */
    public static C1266d m7525d(Context context) {
        if (context != null) {
            return new C1266d(context);
        }
        throw new IllegalArgumentException("argument 'context' must not be null.");
    }

    /* renamed from: b */
    public final FastSDKEngine.LaunchOption m7526b() {
        FastSDKEngine.LaunchOption launchOption = new FastSDKEngine.LaunchOption();
        launchOption.setLatestNeed(this.f5697c);
        launchOption.setShortCutStrategy(this.f5696b);
        launchOption.setActionbarLockCustomize(this.f5698d);
        launchOption.setActionbarLockStatus(this.f5699e);
        return launchOption;
    }

    /* renamed from: c */
    public final /* synthetic */ void m7527c(String str, int i10) throws JSONException {
        if (i10 == 0) {
            FastSDKEngine.launchFastAppByDeeplink(this.f5695a, str, m7526b());
        } else if (i10 == 80001) {
            C11839m.m70687e("FastLauncher", "not get download url");
        }
    }

    /* renamed from: e */
    public int m7528e(final String str) {
        if (str == null) {
            C11839m.m70687e("FastLauncher", "Failed to open FastApp by deeplink! Input parameter 'deeplink' is null.");
            throw new IllegalArgumentException("argument 'deeplink' must not be null.");
        }
        if (C0209d.m1184K0(this.f5695a, Constants.FAST_APP_PKG)) {
            return FastSDKEngine.launchFastAppByDeeplink(this.f5695a, str, m7526b());
        }
        if (C0209d.m1333z1(this.f5695a)) {
            C11839m.m70688i("FastLauncher", "Start to launch FastApp by deeplink.");
            C1264b.m7520c(this.f5695a, new C1264b.a() { // from class: bn.c
                @Override // bn.C1264b.a
                public final void onResult(int i10) throws JSONException {
                    this.f5693a.m7527c(str, i10);
                }
            });
            return 0;
        }
        Context context = this.f5695a;
        C11841o.m70708d(context, context.getString(R$string.network_unavailable), 0);
        return 80001;
    }
}
