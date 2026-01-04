package p770xc;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import vc.C13400d;

@CBServiceTask(request = 55000013, response = 66000013)
/* renamed from: xc.h */
/* loaded from: classes3.dex */
public class C13745h extends AbstractC13752o {

    /* renamed from: y */
    public List<UnstructData> f61794y = null;

    /* renamed from: z */
    public int f61795z = 0;

    /* renamed from: A */
    public String f61792A = "";

    /* renamed from: B */
    public int f61793B = -1;

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
        C11839m.m70688i("QueryUnstructDataTask", "End afterWorkDone ,result = " + this.f61795z);
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("QueryUnstructDataTask", "Begin doWork");
        C13400d c13400d = new C13400d(this.f53282a, this.f61834s, this.f61835t, this.f61794y, this.f61832q, this.f61833r, this.f61836u, this.f61792A, this.f61793B, this.f61838w);
        c13400d.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f61795z = c13400d.m80520f();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("QueryUnstructDataTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61794y = (List) c10800nM68549a.m65739d("unstructlist");
        if (c10800nM68549a.m65739d("callbackUuid") != null) {
            this.f61792A = (String) c10800nM68549a.m65739d("callbackUuid");
        }
        if (c10800nM68549a.m65739d("functionVersion") != null) {
            this.f61793B = ((Integer) c10800nM68549a.m65739d("functionVersion")).intValue();
        }
    }
}
