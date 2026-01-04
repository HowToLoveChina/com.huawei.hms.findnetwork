package p491nd;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import p015ak.C0209d;
import p514o9.C11828b;
import p616rk.AbstractRunnableC12516b;

/* renamed from: nd.c */
/* loaded from: classes3.dex */
public class C11665c extends BaseDownLoadFileTask {

    /* renamed from: a */
    public boolean f54112a;

    /* renamed from: b */
    public ImageView f54113b;

    public C11665c(String str, String str2, String str3, Handler handler, ImageView imageView) {
        super(str, str2, str3, handler);
        this.f54113b = imageView;
        this.f54112a = false;
    }

    /* renamed from: c */
    public Bitmap m69658c(String str) {
        return C0209d.m1311u(str);
    }

    @Override // com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public boolean diskCacheExist(String str, String str2) {
        return m69658c(str) != null;
    }

    @Override // com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public boolean forceDownload() {
        return this.f54112a;
    }

    @Override // com.huawei.hicloud.notification.task.BaseDownLoadFileTask, p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.PPS_ICON_DOWNLOAD;
    }

    @Override // com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public void sendDownloadFileFail() {
        if (this.f54113b == null || TextUtils.isEmpty(this.mUrl) || this.mHandler == null) {
            return;
        }
        this.mHandler.obtainMessage(5002, new C11828b.b(this.f54113b, this.mUrl)).sendToTarget();
    }

    @Override // com.huawei.hicloud.notification.task.BaseDownLoadFileTask
    public void sendDownloadFileSuccess() {
        Bitmap bitmapM69658c = m69658c(this.mDestPath);
        if (bitmapM69658c == null || this.f54113b == null || TextUtils.isEmpty(this.mUrl) || this.mHandler == null) {
            return;
        }
        this.mHandler.obtainMessage(5001, new C11828b.b(this.f54113b, this.mUrl, bitmapM69658c)).sendToTarget();
    }
}
