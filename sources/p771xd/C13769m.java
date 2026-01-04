package p771xd;

import com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p654tb.C13003b;
import p654tb.C13004c;

/* renamed from: xd.m */
/* loaded from: classes3.dex */
public class C13769m {

    /* renamed from: a */
    public final List<ISpaceRemindHandler> f61870a = new ArrayList();

    /* renamed from: a */
    public void m82679a(ISpaceRemindHandler iSpaceRemindHandler) {
        this.f61870a.add(iSpaceRemindHandler);
    }

    /* renamed from: b */
    public C13004c m82680b(C13003b c13003b) {
        C13004c c13004cMo24386a = null;
        for (ISpaceRemindHandler iSpaceRemindHandler : this.f61870a) {
            if (iSpaceRemindHandler.mo24387b()) {
                c13004cMo24386a = iSpaceRemindHandler.mo24386a();
            } else {
                C11839m.m70688i("SpaceRemindHandlerChain", "Skipped: " + iSpaceRemindHandler.getClass().getSimpleName());
            }
        }
        return c13004cMo24386a;
    }
}
