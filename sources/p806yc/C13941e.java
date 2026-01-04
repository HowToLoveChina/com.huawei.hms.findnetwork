package p806yc;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import p514o9.C11839m;
import p736wc.C13584d;
import p770xc.AbstractC13752o;

@CBServiceTask(request = 55000028, response = 66000028)
/* renamed from: yc.e */
/* loaded from: classes3.dex */
public class C13941e extends AbstractC13752o {

    /* renamed from: y */
    public List<UnstructData> f62510y = null;

    /* renamed from: z */
    public int f62511z = 0;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("GenQueryUnstructDataTask", "End afterWorkDone ,result = " + this.f62511z);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenQueryUnstructDataTask", "Begin doWork");
        C13584d c13584d = new C13584d(this.f53282a, this.f61834s, this.f61835t, this.f62510y, this.f61832q, this.f61833r, this.f61836u, this.f61838w);
        c13584d.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f62511z = c13584d.m81601e();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenQueryUnstructDataTask", "Begin beforeWorkStart");
        super.mo66489c();
        this.f62510y = (List) this.f53284c.m68549a().m65739d("unstructlist");
    }
}
