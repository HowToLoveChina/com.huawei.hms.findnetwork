package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import java.util.ArrayList;
import p015ak.C0213f;
import p015ak.C0241z;
import p020ap.C1008c;
import p054cj.C1442a;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p778xk.C13823d;
import p836z8.C14157f;
import to.C13049a;

/* renamed from: hj.l1 */
/* loaded from: classes5.dex */
public class C10245l1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49649b;

    public C10245l1(Handler handler) {
        this.f49649b = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            RetResult retResult = (RetResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78732d0(), RetResult.class);
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.bm.grade.state");
            arrayList.add("bs.grade");
            for (C4987f c4987f : C14157f.m84942g().m84949i(null, arrayList, "GetParam")) {
                try {
                    if (TextUtils.equals(c4987f.m30026b(), "bs.bm.grade.state")) {
                        C13452e.m80781L().m80893b2(C0241z.m1685c(c4987f.m30027c()));
                    }
                    if (TextUtils.equals(c4987f.m30026b(), "bs.grade")) {
                        C13452e.m80781L().m80940l1(c4987f.m30027c());
                        if (C13452e.m80781L().m80791C0()) {
                            C1008c.m6035v().m6072f(C0213f.m1377a(), "QuitFamilyShareForPayTask");
                            C1008c.m6035v().m6060Y(C0213f.m1377a(), "QuitFamilyShareForPayTask");
                            C1008c.m6035v().m6086m(C0213f.m1377a(), "QuitFamilyShareForPayTask");
                        }
                    }
                } catch (Exception unused) {
                    C11839m.m70689w("QuitFamilyShareForPayTask", "getParams " + c4987f.m30026b() + "--" + c4987f.m30027c());
                }
            }
            m63380f(this.f49649b, 6015, retResult);
        } catch (JsonSyntaxException e10) {
            C1442a.m8289e("QuitFamilyShareForPayTask", "member quit family share json exception : " + e10.toString());
        } catch (C9721b e11) {
            C1442a.m8289e("QuitFamilyShareForPayTask", "member quit family share err : " + e11.toString());
            m63379e(this.f49649b, 6016, e11);
        }
        C13823d.m82901N();
    }
}
