package p770xc;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import vc.C13401e;

@CBServiceTask(request = 55000500, response = 66000500)
/* renamed from: xc.l */
/* loaded from: classes3.dex */
public class C13749l extends AbstractC13748k {

    /* renamed from: r */
    public String f61812r = null;

    /* renamed from: s */
    public String f61813s = null;

    /* renamed from: t */
    public List<UnstructData> f61814t = null;

    /* renamed from: u */
    public String f61815u = null;

    /* renamed from: v */
    public String f61816v = null;

    /* renamed from: w */
    public boolean f61817w = false;

    /* renamed from: x */
    public boolean f61818x = false;

    /* renamed from: y */
    public String f61819y = null;

    /* renamed from: z */
    public String f61820z = "";

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("RequireDownloadFileTask", "Begin beforeWorkStart");
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61812r = c10800nM68549a.m65740e("synctype", "");
        this.f61813s = c10800nM68549a.m65740e("datatype", "");
        this.f61814t = (List) c10800nM68549a.m65739d("requireList");
        this.f61815u = c10800nM68549a.m65740e("sync_moudle_package_name", "");
        this.f61816v = c10800nM68549a.m65740e("session_id", "");
        this.f61817w = c10800nM68549a.m65736a("need_progress", false);
        this.f61818x = c10800nM68549a.m65736a("force_download", false);
        this.f61819y = c10800nM68549a.m65740e("trace_id_key", "");
        this.f61820z = c10800nM68549a.m65740e("callbackUuid", "");
        this.f61811q = "03001";
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("RequireDownloadFileTask", "Begin doWork");
        new C13401e(this.f53282a, this.f61812r, this.f61813s, this.f61814t, this.f61817w, this.f61818x, this.f61816v, this.f61811q, this.f61819y, this.f61815u, this.f61820z).m80532i();
        return Boolean.FALSE;
    }
}
