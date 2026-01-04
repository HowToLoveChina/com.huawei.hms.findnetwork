package ac;

import android.content.Context;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import p514o9.C11839m;
import p514o9.C11842p;

/* renamed from: ac.d */
/* loaded from: classes3.dex */
public class C0092d extends C0089a {
    @Override // ac.C0089a
    /* renamed from: d */
    public void mo691d(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        C11842p.m70831k2(context, relativeLayout);
    }

    @Override // ac.C0089a
    /* renamed from: f */
    public void mo693f(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
        } else {
            oOBETopView.m17056f(context);
            C11842p.m70775V1(context, relativeLayout);
        }
    }

    @Override // ac.C0089a
    /* renamed from: h */
    public void mo695h(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
        } else {
            oOBETopView.m17057g(context);
            C11842p.m70791a2(relativeLayout);
        }
    }

    @Override // ac.C0089a
    /* renamed from: j */
    public void mo697j(Context context, OOBETopView oOBETopView, RelativeLayout relativeLayout, OOBENavLayout oOBENavLayout) {
        if (oOBETopView == null || relativeLayout == null) {
            C11839m.m70687e("OOBELayoutEmui8Helper", "layoutPadPortrait topLayout mainRegion null");
        } else {
            oOBETopView.m17058h(context);
            C11842p.m70831k2(context, relativeLayout);
        }
    }

    @Override // ac.C0089a
    /* renamed from: k */
    public void mo698k() {
    }

    @Override // ac.C0089a
    /* renamed from: l */
    public void mo699l() {
    }
}
