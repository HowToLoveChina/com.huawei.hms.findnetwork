package p407jv;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import lv.InterfaceC11350a;
import p374iv.C10627f;
import p436kv.InterfaceC11162b;

/* renamed from: jv.b */
/* loaded from: classes9.dex */
public class C10933b {

    /* renamed from: a */
    public HiAnalyticsInstance f51844a;

    /* renamed from: b */
    public final C10932a f51845b;

    /* renamed from: c */
    public final InterfaceC11350a f51846c;

    public C10933b(Context context, String str, String str2, InterfaceC11350a interfaceC11350a) throws C10627f {
        if (TextUtils.isEmpty(str2)) {
            throw new C10627f("hiAnalyticsUrl is empty");
        }
        this.f51846c = interfaceC11350a;
        interfaceC11350a.mo7652i("HaReporter", "hiAnalyticsUrl is " + str2);
        this.f51845b = new C10932a(interfaceC11350a);
        m66057a(str2, context, str);
    }

    /* renamed from: a */
    public final void m66057a(String str, Context context, String str2) {
        HiAnalyticsConfig hiAnalyticsConfigBuild = new HiAnalyticsConfig.Builder().setCollectURL(str).setEnableUUID(false).build();
        HiAnalyticsInstance hiAnalyticsInstanceRefresh = new HiAnalyticsInstance.Builder(context).setMaintConf(hiAnalyticsConfigBuild).setOperConf(hiAnalyticsConfigBuild).refresh(str2);
        this.f51844a = hiAnalyticsInstanceRefresh;
        if (hiAnalyticsInstanceRefresh == null) {
            this.f51846c.mo7652i("HaReporter", "The analytics instance was not successfully obtained, and the analytics capability cannot be used");
        } else {
            hiAnalyticsInstanceRefresh.setAppid("com.huawei.wisesecurity.common");
        }
    }

    /* renamed from: b */
    public void m66058b(Context context, InterfaceC11162b interfaceC11162b) {
        m66059c(context, interfaceC11162b, EnumC10934c.HIANALYTICS_MAINTENANCE);
    }

    /* renamed from: c */
    public void m66059c(Context context, InterfaceC11162b interfaceC11162b, EnumC10934c enumC10934c) {
        if (this.f51844a == null) {
            this.f51846c.mo7652i("HaReporter", "onEvent null == analyticsInstance");
            return;
        }
        if (this.f51845b.m66053d(context)) {
            this.f51846c.mo7652i("HaReporter", "onEvent isEnabledUserExperience is false");
            return;
        }
        try {
            this.f51844a.onEvent(enumC10934c.m66061b(), interfaceC11162b.mo58649a(), interfaceC11162b.build());
            this.f51846c.mo7652i("HaReporter", "onEvent success");
        } catch (Exception e10) {
            this.f51846c.mo7653w("HaReporter", "onEvent fail : " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m66060d() {
        this.f51845b.m66056h();
    }
}
