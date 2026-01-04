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
import to.C13049a;

/* renamed from: w8.c */
/* loaded from: classes2.dex */
public class C13552c extends AbstractC12367d {

    /* renamed from: a */
    public Handler f60956a;

    public C13552c(Handler handler) {
        this.f60956a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f60956a);
        try {
            RetResult retResult = (RetResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78735f(), RetResult.class);
            messageObtain.what = 2004;
            messageObtain.obj = retResult;
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70687e("DisableFamilyShareTask", "disablefamilysharetask exception:" + e10.toString());
            messageObtain.what = 2005;
        }
        this.f60956a.sendMessage(messageObtain);
    }
}
