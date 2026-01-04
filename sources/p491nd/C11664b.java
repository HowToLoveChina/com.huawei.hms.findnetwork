package p491nd;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import ba.C1147a;

/* renamed from: nd.b */
/* loaded from: classes3.dex */
public class C11664b extends C11665c {
    public C11664b(String str, String str2, String str3, Handler handler, ImageView imageView) {
        super(str, str2, str3, handler, imageView);
    }

    @Override // p491nd.C11665c, com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public void sendDownloadFileFail() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    @Override // p491nd.C11665c, com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public void sendDownloadFileSuccess() {
        Handler handler;
        Bitmap bitmapM69658c = m69658c(this.mDestPath);
        C1147a c1147a = new C1147a();
        c1147a.m7214e(this.mUrl);
        c1147a.m7213d(bitmapM69658c);
        if (bitmapM69658c == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.obtainMessage(1, c1147a).sendToTarget();
    }
}
