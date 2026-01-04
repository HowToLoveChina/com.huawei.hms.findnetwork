package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import fk.C9721b;
import p015ak.C0213f;
import p054cj.C1442a;
import p454lj.C11282e;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: hj.z */
/* loaded from: classes5.dex */
public class C10276z extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49755b;

    /* renamed from: c */
    public boolean f49756c;

    public C10276z(Handler handler, boolean z10) {
        this.f49755b = handler;
        this.f49756c = z10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            C1442a.m8290i("GetFamilyShareInfoTask", "GetFamilyShareInfoTask start.");
            FamilyShareInfoResult familyShareInfoResult = (FamilyShareInfoResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78751o(), FamilyShareInfoResult.class);
            if (this.f49756c) {
                C11282e.m67709b(C0213f.m1377a()).m67716h("get_family_share_info_cache_key", new Gson().toJson(familyShareInfoResult));
            }
            C1442a.m8290i("GetFamilyShareInfoTask", "GetFamilyShareInfoTask success.");
            m63380f(this.f49755b, 6017, familyShareInfoResult);
        } catch (JsonSyntaxException e10) {
            C1442a.m8289e("GetFamilyShareInfoTask", "GetFamilyShareInfoTask JsonSyntaxException err : " + e10.toString());
        } catch (C9721b e11) {
            C1442a.m8289e("GetFamilyShareInfoTask", "GetFamilyShareInfoTask err : " + e11.toString());
            if (this.f49756c) {
                String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_family_share_info_cache_key");
                if (!TextUtils.isEmpty(strM67711c)) {
                    C1442a.m8291w("GetFamilyShareInfoTask", "GetFamilyShareInfoTask get info faild, use cache. ");
                    m63380f(this.f49755b, 6017, new Gson().fromJson(strM67711c, FamilyShareInfoResult.class));
                    return;
                }
            }
            m63379e(this.f49755b, 6018, e11);
        }
    }
}
