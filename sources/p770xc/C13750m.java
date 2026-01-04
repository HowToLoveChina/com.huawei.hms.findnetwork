package p770xc;

import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import vc.C13402f;

@CBServiceTask(request = 55000010, response = 66000010)
/* renamed from: xc.m */
/* loaded from: classes3.dex */
public class C13750m extends AbstractC13752o {

    /* renamed from: y */
    public List<SyncData> f61824y = null;

    /* renamed from: z */
    public List<String> f61825z = null;

    /* renamed from: A */
    public boolean f61821A = false;

    /* renamed from: B */
    public int f61822B = 0;

    /* renamed from: C */
    public String f61823C = "";

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("SaveResultTask", "Begin doWork");
        C13402f c13402f = new C13402f(this.f53282a, this.f61834s, this.f61835t, this.f61824y, this.f61825z, this.f61821A, this.f61832q, this.f61833r, this.f61836u, this.f61823C, this.f61838w);
        c13402f.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f61822B = c13402f.m80543j();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("SaveResultTask", "Begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61824y = (List) c10800nM68549a.m65739d("saveresult");
        this.f61825z = (List) c10800nM68549a.m65739d("deleteList");
        this.f61821A = ((Boolean) c10800nM68549a.m65739d("isupload")).booleanValue();
        if (c10800nM68549a.m65739d("isCloudDataParticalSuc") != null) {
            this.f61823C = (String) c10800nM68549a.m65739d("isCloudDataParticalSuc");
        }
    }
}
