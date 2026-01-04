package p806yc;

import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import p736wc.C13585e;
import p770xc.AbstractC13752o;

@CBServiceTask(request = 55000033, response = 66000033)
/* renamed from: yc.f */
/* loaded from: classes3.dex */
public class C13942f extends AbstractC13752o {

    /* renamed from: y */
    public List<SyncData> f62515y = null;

    /* renamed from: z */
    public List<String> f62516z = null;

    /* renamed from: A */
    public boolean f62512A = false;

    /* renamed from: B */
    public int f62513B = 0;

    /* renamed from: C */
    public String f62514C = "";

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("GenSaveResultTask", "begin doWork");
        C13585e c13585e = new C13585e(this.f53282a, this.f61834s, this.f61835t, this.f62515y, this.f62516z, this.f62512A, this.f61832q, this.f61833r, this.f61836u, this.f62514C, this.f61838w);
        c13585e.setConfig(this.f61834s, this.f53297m, this.f61839x);
        this.f62513B = c13585e.m81611j();
        return Boolean.FALSE;
    }

    @Override // p770xc.AbstractC13752o, md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("GenSaveResultTask", "begin beforeWorkStart");
        super.mo66489c();
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f62515y = (List) c10800nM68549a.m65739d("saveresult");
        this.f62516z = (List) c10800nM68549a.m65739d("deleteList");
        this.f62512A = ((Boolean) c10800nM68549a.m65739d("isupload")).booleanValue();
        if (c10800nM68549a.m65739d("isCloudDataParticalSuc") != null) {
            this.f62514C = (String) c10800nM68549a.m65739d("isCloudDataParticalSuc");
        }
    }
}
