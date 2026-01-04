package p224dc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBELocalTermsActivity;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p472m7.C11428c;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: dc.b */
/* loaded from: classes3.dex */
public class C9064b extends C11428c {
    public C9064b(Context context, String str) {
        super(context, str);
    }

    @Override // p472m7.C11428c, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f53264a == null) {
            return;
        }
        Intent intent = new Intent(this.f53264a, (Class<?>) OOBELocalTermsActivity.class);
        intent.putExtra("product_type", this.f53265b);
        PackageManager packageManager = this.f53264a.getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            this.f53264a.startActivity(intent);
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("productType", this.f53265b);
        C13227f.m79492i1().m79591l0("mecloud_agrenment_click", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "mecloud_agrenment_click", "1", "34", "productType", this.f53265b);
    }
}
