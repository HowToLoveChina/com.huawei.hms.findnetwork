package p770xc;

import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import vc.C13399c;

@CBServiceTask(request = 55000008, response = 66000008)
/* renamed from: xc.f */
/* loaded from: classes3.dex */
public class C13743f extends AbstractC13752o {

    /* renamed from: y */
    public List<String> f61783y = null;

    /* renamed from: z */
    public int f61784z = 0;

    /* renamed from: A */
    public boolean f61782A = false;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("QueryCloudTask", "Begin doWork");
        C13399c c13399c = new C13399c(this.f53282a, this.f61834s, this.f61835t, this.f61783y, this.f61832q, this.f61833r, this.f61836u, this.f61782A, this.f61838w);
        c13399c.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f61784z = c13399c.m80513k();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("QueryCloudTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61783y = (List) c10800nM68549a.m65739d("guidList");
        if (c10800nM68549a.m65739d("isSdkSupportDownPartical") != null) {
            this.f61782A = ((Boolean) c10800nM68549a.m65739d("isSdkSupportDownPartical")).booleanValue();
        }
    }
}
