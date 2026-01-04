package p771xd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import java.lang.ref.WeakReference;
import me.C11444a;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: xd.q */
/* loaded from: classes3.dex */
public class HandlerC13773q extends Handler {

    /* renamed from: a */
    public WeakReference<ImageView> f61875a;

    /* renamed from: b */
    public String f61876b;

    /* renamed from: c */
    public String f61877c;

    /* renamed from: d */
    public WeakReference<View> f61878d;

    /* renamed from: e */
    public int f61879e;

    public HandlerC13773q(ImageView imageView, String str, String str2, View view, int i10) {
        super(Looper.getMainLooper());
        this.f61875a = new WeakReference<>(imageView);
        this.f61876b = str;
        this.f61877c = str2;
        this.f61878d = new WeakReference<>(view);
        this.f61879e = i10;
    }

    /* renamed from: a */
    public final ImageView m82689a(WeakReference<ImageView> weakReference, Message message) {
        if (weakReference != null) {
            return weakReference.get();
        }
        if (message.getTarget() != null) {
            message.getTarget().removeCallbacksAndMessages(null);
        }
        C11839m.m70686d("ThumbnailHandler", "weakRefImageView is null");
        return null;
    }

    /* renamed from: b */
    public final View m82690b(WeakReference<View> weakReference, Message message) {
        if (weakReference != null) {
            return weakReference.get();
        }
        if (message.getTarget() != null) {
            message.getTarget().removeCallbacksAndMessages(null);
        }
        C11839m.m70686d("ThumbnailHandler", "weakRefImageView is null");
        return null;
    }

    /* renamed from: c */
    public final void m82691c(ImageView imageView, int i10, Drawable drawable) {
        if (i10 == 5) {
            RoundRectImageView.setNoBorderScaleDefault(imageView, drawable);
        } else {
            RoundRectImageView.setBorderScaleDefault(imageView, drawable);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null) {
            C11839m.m70688i("ThumbnailHandler", "msg is null");
            return;
        }
        super.handleMessage(message);
        ImageView imageViewM82689a = m82689a(this.f61875a, message);
        if (imageViewM82689a == null) {
            C11839m.m70686d("ThumbnailHandler", "thumbnail is null");
            return;
        }
        String str = imageViewM82689a.getTag() instanceof String ? (String) imageViewM82689a.getTag() : null;
        if (TextUtils.isEmpty(this.f61876b) || TextUtils.isEmpty(str) || !this.f61876b.equals(str)) {
            C11839m.m70688i("ThumbnailHandler", "filePath is null or tag not equal");
            return;
        }
        Object obj = message.obj;
        if (obj instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) obj;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70687e("ThumbnailHandler", "context is null");
                    return;
                } else {
                    imageViewM82689a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    RoundRectImageView.setNoBorderBottomCenter(imageViewM82689a, contextM1377a.getDrawable(C11444a.m68561e(this.f61877c, this.f61879e, 0)));
                    return;
                }
            }
            imageViewM82689a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            m82691c(imageViewM82689a, this.f61879e, bitmapDrawable);
            View viewM82690b = m82690b(this.f61878d, message);
            if (viewM82690b == null) {
                C11839m.m70688i("ThumbnailHandler", "videoIcon is null");
            } else if (2 == this.f61879e) {
                viewM82690b.setVisibility(0);
            } else {
                viewM82690b.setVisibility(8);
            }
        }
    }
}
