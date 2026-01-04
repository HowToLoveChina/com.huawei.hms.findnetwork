package p491nd;

import android.graphics.Bitmap;
import android.os.Handler;
import java.util.function.Consumer;

/* renamed from: nd.d */
/* loaded from: classes3.dex */
public class C11666d extends C11665c {

    /* renamed from: c */
    public Consumer<Object> f54114c;

    public C11666d(String str, String str2, String str3, Handler handler) {
        super(str, str2, str3, handler, null);
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
        Consumer<Object> consumer;
        Handler handler;
        Bitmap bitmapM69658c = m69658c(this.mDestPath);
        if (bitmapM69658c != null && (handler = this.mHandler) != null) {
            handler.obtainMessage(1, bitmapM69658c).sendToTarget();
        }
        if (bitmapM69658c == null || (consumer = this.f54114c) == null) {
            return;
        }
        consumer.accept(bitmapM69658c);
    }

    public C11666d(String str, String str2, String str3, Consumer<Object> consumer) {
        super(str, str2, str3, null, null);
        this.f54114c = consumer;
    }
}
