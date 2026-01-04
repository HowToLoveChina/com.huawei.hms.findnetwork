package p732w8;

import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: w8.d */
/* loaded from: classes2.dex */
public class C13553d extends AbstractC12367d {

    /* renamed from: a */
    public Handler f60957a;

    public C13553d(Handler handler) {
        this.f60957a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f60957a);
        try {
            RetResult retResult = (RetResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78737g(), RetResult.class);
            messageObtain.what = 2010;
            messageObtain.obj = retResult;
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70687e("EnableFamilyShareTask", "enablespaceshare exception:" + e10.toString());
            messageObtain.what = FamilyShareConstants.MessageCode.ENABLE_SPACE_SHARE_FAILED;
        }
        this.f60957a.sendMessage(messageObtain);
    }
}
