package p732w8;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.RetResult;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p652t9.EnumC12999a;
import p836z8.C14157f;
import to.C13049a;

/* renamed from: w8.x */
/* loaded from: classes2.dex */
public class C13573x extends AbstractC12367d {

    /* renamed from: a */
    public Handler f61067a;

    public C13573x(Handler handler) {
        this.f61067a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        Message messageObtain = Message.obtain(this.f61067a);
        try {
            RetResult retResult = (RetResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78716R(), RetResult.class);
            if (retResult == null || retResult.getRetCode() != 1024) {
                C14157f.m84942g().m84957t();
                messageObtain.what = 2000;
            } else {
                messageObtain.what = 2020;
            }
            messageObtain.obj = retResult;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("JoinFamilyShareTask", "joinFamilyShare json exception:" + e10.toString());
        } catch (C9721b e11) {
            C11839m.m70687e("JoinFamilyShareTask", "joinFamilyShare exception:" + e11.toString());
            messageObtain.what = 2001;
            messageObtain.arg1 = e11.m60663g();
        }
        this.f61067a.sendMessage(messageObtain);
    }
}
