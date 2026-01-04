package p341hj;

import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import fk.C9721b;
import p581qk.AbstractC12367d;

/* renamed from: hj.p1 */
/* loaded from: classes5.dex */
public class C10257p1 extends AbstractC12367d {

    /* renamed from: a */
    public long f49689a;

    /* renamed from: b */
    public int f49690b;

    /* renamed from: c */
    public Handler f49691c;

    public C10257p1(Handler handler, long j10, int i10) {
        this.f49690b = i10;
        this.f49689a = j10;
        this.f49691c = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        HicloudH5ConfigManager.getInstance().checkH5ClientVersion(this.f49689a);
        Handler handler = this.f49691c;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 7029;
            messageObtainMessage.arg1 = this.f49690b;
            this.f49691c.sendMessage(messageObtainMessage);
        }
    }
}
