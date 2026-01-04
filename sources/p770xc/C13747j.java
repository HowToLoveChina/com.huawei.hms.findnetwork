package p770xc;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.task.frame.CBServiceTask;
import java.util.List;
import je.C10800n;
import p514o9.C11839m;
import vc.C13397a;

@CBServiceTask(request = 55000502, response = 66000500)
/* renamed from: xc.j */
/* loaded from: classes3.dex */
public class C13747j extends AbstractC13748k {

    /* renamed from: r */
    public String f61803r = null;

    /* renamed from: s */
    public String f61804s = null;

    /* renamed from: t */
    public List<UnstructData> f61805t = null;

    /* renamed from: u */
    public String f61806u = null;

    /* renamed from: v */
    public String f61807v = null;

    /* renamed from: w */
    public String f61808w = null;

    /* renamed from: x */
    public String f61809x = "";

    @Override // md.AbstractC11438a
    /* renamed from: c */
    public void mo66489c() {
        C11839m.m70688i("RequirePauseTask", "Begin beforeWorkStart");
        C10800n c10800nM68549a = this.f53284c.m68549a();
        this.f61803r = c10800nM68549a.m65740e("synctype", "");
        this.f61804s = c10800nM68549a.m65740e("datatype", "");
        this.f61805t = (List) c10800nM68549a.m65739d("requireList");
        this.f61806u = c10800nM68549a.m65740e("sync_moudle_package_name", "");
        this.f61807v = c10800nM68549a.m65740e("session_id", "");
        this.f61808w = c10800nM68549a.m65740e("trace_id_key", "");
        this.f61809x = c10800nM68549a.m65740e("callbackUuid", "");
        this.f61811q = "03001";
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void mo66488a(Boolean bool) {
    }

    @Override // md.C11439b, md.AbstractC11438a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Boolean mo66490d() throws Exception {
        C11839m.m70688i("RequirePauseTask", "Begin doWork");
        new C13397a(this.f53282a, this.f61803r, this.f61804s, this.f61811q, this.f61808w, this.f61806u, this.f61805t, this.f61807v, this.f61809x).m80498a();
        return Boolean.FALSE;
    }
}
