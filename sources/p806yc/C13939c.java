package p806yc;

import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import p736wc.C13583c;
import p770xc.AbstractC13752o;

@CBServiceTask(request = 55000032, response = 66000032)
/* renamed from: yc.c */
/* loaded from: classes3.dex */
public class C13939c extends AbstractC13752o {

    /* renamed from: y */
    public List<String> f62505y = null;

    /* renamed from: z */
    public int f62506z = 0;

    /* renamed from: A */
    public boolean f62504A = false;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenQueryCloudTask", "Begin doWork");
        C13583c c13583c = new C13583c(this.f53282a, this.f61834s, this.f61835t, this.f62505y, this.f61832q, this.f61833r, this.f61836u, this.f62504A, this.f61838w);
        c13583c.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f62506z = c13583c.m81593b();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenQueryCloudTask", "beforeWorkStart begin");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62505y = (List) c10800nM68549a.m65739d("guidList");
        if (c10800nM68549a.m65739d("isSdkSupportDownPartical") != null) {
            this.f62504A = ((Boolean) c10800nM68549a.m65739d("isSdkSupportDownPartical")).booleanValue();
        }
    }
}
