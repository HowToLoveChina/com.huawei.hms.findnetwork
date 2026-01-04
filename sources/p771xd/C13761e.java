package p771xd;

import com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler;
import p514o9.C11839m;
import p654tb.C13002a;
import p654tb.C13003b;
import p654tb.C13004c;

/* renamed from: xd.e */
/* loaded from: classes3.dex */
public class C13761e implements ISpaceRemindHandler {

    /* renamed from: a */
    public final C13003b f61865a;

    public C13761e(C13003b c13003b) {
        this.f61865a = c13003b;
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: a */
    public C13004c mo24386a() {
        try {
            C13003b c13003b = this.f61865a;
            if (c13003b == null) {
                C11839m.m70689w("CardDisplayHandler", "context is null");
                return C13004c.m78185a("context is null", null, null, false);
            }
            if (!c13003b.m78180d()) {
                C11839m.m70689w("CardDisplayHandler", "preCheck not pass");
                return C13004c.m78185a("preCheck not pass", null, null, false);
            }
            String strM78179c = this.f61865a.m78179c();
            if (strM78179c == null) {
                C11839m.m70689w("CardDisplayHandler", "userSpaceState is null");
                return C13004c.m78185a("userSpaceState is null", null, null, false);
            }
            if ("spaceNormal".equals(strM78179c)) {
                return C13004c.m78186f(strM78179c, null, false);
            }
            C13002a c13002aM78177a = this.f61865a.m78177a();
            if (c13002aM78177a == null) {
                C11839m.m70689w("CardDisplayHandler", "cardInfo is null");
                return C13004c.m78185a("cardInfo is null", strM78179c, null, false);
            }
            if (!c13002aM78177a.m78171f()) {
                return C13004c.m78186f(strM78179c, c13002aM78177a, true);
            }
            C11839m.m70689w("CardDisplayHandler", "cardInfo param is invalid");
            return C13004c.m78185a("cardInfo param is invalid", strM78179c, c13002aM78177a, false);
        } catch (Exception e10) {
            C11839m.m70687e("CardDisplayHandler", "CardDisplayHandler handle error:" + e10.getMessage());
            return C13004c.m78185a("CardDisplayHandler handle error", null, null, false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: b */
    public boolean mo24387b() {
        return true;
    }
}
