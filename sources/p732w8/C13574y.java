package p732w8;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import java.util.ArrayList;
import p015ak.C0213f;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p709vj.C13452e;
import p778xk.C13823d;
import p836z8.C14157f;
import to.C13049a;

/* renamed from: w8.y */
/* loaded from: classes2.dex */
public class C13574y extends AbstractC12367d {

    /* renamed from: a */
    public Handler f61068a;

    public C13574y(Handler handler) {
        this.f61068a = handler;
    }

    /* renamed from: c */
    public final void m81564c() {
        C11839m.m70688i("QuitFamilyShareTask", "QuitFamilyShare");
        Intent intent = new Intent();
        intent.setAction(FamilyShareConstants.Report.CLICK_DISABLE_BUTTON);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f61068a);
        try {
            RetResult retResult = (RetResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78732d0(), RetResult.class);
            if (retResult != null && retResult.getRetCode() == 0) {
                C14157f.m84942g().m84957t();
            }
            messageObtain.what = FamilyShareConstants.MessageCode.QUIT_SPACE_SHARE_SUCCESS;
            messageObtain.obj = retResult;
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70687e("QuitFamilyShareTask", "quitfamilysharetask exception:" + e10.toString());
            messageObtain.what = 2007;
        }
        this.f61068a.sendMessage(messageObtain);
        C13823d.m82901N();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58389Q0();
        }
        C13452e.m80781L().m80941l2("");
        m81564c();
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.grade");
        for (C4987f c4987f : C14157f.m84942g().m84949i(null, arrayList, FamilyShareConstants.Report.QUIT_FAMILY_SHARE)) {
            try {
                if (TextUtils.equals(c4987f.m30026b(), "bs.grade")) {
                    C13452e.m80781L().m80940l1(c4987f.m30027c());
                    if (C13452e.m80781L().m80791C0()) {
                        C1008c.m6035v().m6072f(C0213f.m1377a(), "QuitFamilyShareTask");
                        C1008c.m6035v().m6060Y(C0213f.m1377a(), "QuitFamilyShareTask");
                        C1008c.m6035v().m6086m(C0213f.m1377a(), "QuitFamilyShareTask");
                    }
                }
            } catch (Exception unused) {
                C11839m.m70689w("QuitFamilyShareTask", "getParams " + c4987f.m30026b() + "--" + c4987f.m30027c());
            }
        }
    }
}
