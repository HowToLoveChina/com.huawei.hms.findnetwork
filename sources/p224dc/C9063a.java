package p224dc;

import android.content.Context;
import android.view.View;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p399jk.AbstractC10896a;
import p472m7.C11426a;
import p472m7.C11428c;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: dc.a */
/* loaded from: classes3.dex */
public class C9063a extends C11428c {

    /* renamed from: d */
    public final C11426a f45779d;

    public C9063a(Context context, String str) {
        super(context, str);
        this.f45779d = new C11426a(this.f53264a, "permission_description", true);
    }

    @Override // p472m7.C11428c, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f53264a == null) {
            AbstractC10896a.m65888w("OOBEPermissionClickSpan", "context is null");
            return;
        }
        this.f45779d.onClick();
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("productType", this.f53265b);
        C13227f.m79492i1().m79591l0("mecloud_agrenment_click", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "mecloud_agrenment_click", "1", "34", "productType", this.f53265b);
    }
}
