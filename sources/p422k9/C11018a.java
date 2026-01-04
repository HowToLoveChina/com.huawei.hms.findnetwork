package p422k9;

import com.huawei.feedback.GetAccessTokenListener;
import com.huawei.feedback.IAccessTokenProxy;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.C13452e;

/* renamed from: k9.a */
/* loaded from: classes3.dex */
public class C11018a implements IAccessTokenProxy {

    /* renamed from: k9.a$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public GetAccessTokenListener f52095a;

        public a(GetAccessTokenListener getAccessTokenListener) {
            this.f52095a = getAccessTokenListener;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM79344y = "";
            try {
                strM79344y = C13195l.m79272J().m79344y("FeedBack", "");
            } catch (Exception e10) {
                C11839m.m70687e("FeedbackAccessTokenImp", "getAccessToken exception:" + e10.toString());
            }
            this.f52095a.getAccessToken(strM79344y);
        }
    }

    @Override // com.huawei.feedback.IAccessTokenProxy
    public void getAccessToken(GetAccessTokenListener getAccessTokenListener) {
        C12515a.m75110o().m75172d(new a(getAccessTokenListener));
    }

    @Override // com.huawei.feedback.IAccessTokenProxy
    public String getAccessTokenCache() {
        return C13195l.m79272J().m79288A();
    }

    @Override // com.huawei.feedback.IAccessTokenProxy
    public String getContryCode() {
        return C13452e.m80781L().m80942m();
    }

    @Override // com.huawei.feedback.IAccessTokenProxy
    public boolean isLogin() {
        return C13452e.m80781L().m80842P0();
    }
}
