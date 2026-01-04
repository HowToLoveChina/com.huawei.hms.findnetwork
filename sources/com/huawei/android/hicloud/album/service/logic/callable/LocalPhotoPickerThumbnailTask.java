package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.kvdb.KVDatabase;
import fk.C9721b;
import java.lang.ref.WeakReference;
import p009a8.C0069g;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1127h;
import p031b7.C1138s;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes2.dex */
public class LocalPhotoPickerThumbnailTask extends AbstractC12367d {
    private static final int IMAGE_ICON_HEIGHT = 100;
    private static final int IMAGE_ICON_WIDTH = 100;
    private static final int MEDIA_TYPE_IMAGE = 1;
    private static final int MEDIA_TYPE_VIDEO = 3;
    private static final String TAG = "LocalPhotoPickerThumbnailTask";
    private static final int TYPE_MICRO_THUMBNAIL = 2;
    private float density = 2.0f;
    private final MediaFileBean fileBean;
    private boolean isCancelled;
    private WeakReference<View> viewWeakReference;

    public static class ViewHandler extends Handler {
        public static final int MSG_LOAD_THUMBNAIL_SUCCESS = 10000;
        private static final String TAG = "ViewHandler";
        private final MediaFileBean fileBean;
        private final WeakReference<View> viewWeakReference;

        public ViewHandler(WeakReference<View> weakReference, MediaFileBean mediaFileBean) {
            super(Looper.getMainLooper());
            this.viewWeakReference = weakReference;
            this.fileBean = mediaFileBean;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10000) {
                View view = this.viewWeakReference.get();
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    Object tag = imageView.getTag();
                    if ((tag instanceof String) && TextUtils.equals((String) tag, this.fileBean.m14350s())) {
                        Bitmap bitmapM7184c = C1138s.m7181d().m7184c(C0069g.m479y().m482C(this.fileBean));
                        if (bitmapM7184c == null || bitmapM7184c.isRecycled()) {
                            return;
                        }
                        C1120a.m6675d(TAG, "refreshIcon " + this.fileBean.m14350s() + " ; " + this.fileBean.m14327d());
                        imageView.setImageBitmap(bitmapM7184c);
                    }
                }
            }
        }
    }

    public LocalPhotoPickerThumbnailTask(MediaFileBean mediaFileBean, View view) {
        this.fileBean = mediaFileBean;
        if (view != null) {
            this.viewWeakReference = new WeakReference<>(view);
        }
    }

    private boolean checkTaskValid(View view, MediaFileBean mediaFileBean) {
        if (this.isCancelled || view == null || mediaFileBean == null) {
            C1120a.m6677i(TAG, "checkTaskValid false ,need cancel task");
            cancel();
            return false;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            return TextUtils.equals((String) tag, mediaFileBean.m14350s());
        }
        return false;
    }

    public static Bitmap getBitmapFromKvDB(Context context, int i10, long j10, int i11, int i12, BitmapFactory.Options options) {
        try {
            return new KVDatabase(context).getBitmap(KVDatabase.generateKey(i10, j10, i11, i12), options);
        } catch (Exception e10) {
            C1120a.m6676e(TAG, e10.getMessage());
            return null;
        }
    }

    private Bitmap getThumbnailEx(int i10, String str) {
        Bitmap bitmapCreateVideoThumbnail = null;
        try {
            float f10 = this.density;
            int i11 = (int) (f10 * 100.0f);
            int i12 = (int) (f10 * 100.0f);
            if (i10 == 1) {
                bitmapCreateVideoThumbnail = ThumbnailUtils.extractThumbnail(C1127h.m6905d(str, 1), i11, i12, 2);
            } else if (i10 == 3 && (bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1)) != null && !bitmapCreateVideoThumbnail.isRecycled()) {
                bitmapCreateVideoThumbnail = ThumbnailUtils.extractThumbnail(bitmapCreateVideoThumbnail, i11, i12, 2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "getThumbnailFromMedia() Exception: " + e10.toString());
        }
        return bitmapCreateVideoThumbnail;
    }

    private static Bitmap getThumbnailFromMedia(Context context, int i10, long j10, BitmapFactory.Options options) {
        ContentResolver contentResolver = context.getContentResolver();
        Bitmap thumbnail = null;
        if (j10 > -1) {
            try {
                if (i10 == 1) {
                    thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j10, 1, options);
                } else if (i10 == 3) {
                    thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j10, 1, options);
                }
            } catch (Exception e10) {
                C1120a.m6676e(TAG, "getThumbnailFromMedia() Exception: " + e10.toString());
            }
        }
        return thumbnail;
    }

    private void initDensity(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null) {
            context = C0213f.m1377a();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.density = displayMetrics.density;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        WeakReference<View> weakReference;
        if (this.fileBean == null || (weakReference = this.viewWeakReference) == null) {
            release();
            return;
        }
        if (checkTaskValid(weakReference.get(), this.fileBean)) {
            C1120a.m6677i(TAG, "start getThumb " + this.fileBean.m14350s());
            String strM482C = C0069g.m479y().m482C(this.fileBean);
            View view = this.viewWeakReference.get();
            Bitmap bitmapM7184c = C1138s.m7181d().m7184c(strM482C);
            if (bitmapM7184c == null && view != null) {
                Context context = view.getContext();
                initDensity(context);
                long jM14348q = this.fileBean.m14348q() / 1000;
                int i10 = this.fileBean.m14338j() == 2 ? 1 : 3;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmapFromKvDB = getBitmapFromKvDB(context, (int) this.fileBean.m14327d(), jM14348q, i10, 2, options);
                if (bitmapFromKvDB == null && !this.isCancelled) {
                    bitmapFromKvDB = getThumbnailFromMedia(context, i10, this.fileBean.m14327d(), options);
                }
                if (bitmapFromKvDB == null && !this.isCancelled) {
                    bitmapFromKvDB = getThumbnailEx(i10, this.fileBean.m14350s());
                }
                if (bitmapFromKvDB != null && checkTaskValid(this.viewWeakReference.get(), this.fileBean)) {
                    int iM6716M0 = C1122c.m6716M0(this.fileBean.m14350s());
                    int iM14349r = this.fileBean.m14349r();
                    if (iM6716M0 >= 0) {
                        iM14349r = C1122c.m6722O0(iM6716M0);
                        this.fileBean.m14339k0(iM14349r);
                    }
                    bitmapM7184c = iM14349r != 0 ? C1122c.m6719N0(bitmapFromKvDB, iM14349r) : bitmapFromKvDB;
                    if (bitmapM7184c != null) {
                        C1120a.m6677i(TAG, this.fileBean.m14350s() + " getThumbnail success");
                        C1138s.m7181d().m7182a(strM482C, bitmapM7184c);
                    } else {
                        C1120a.m6677i(TAG, this.fileBean.m14350s() + " getThumbnail fail");
                    }
                }
            }
            if (bitmapM7184c != null) {
                new ViewHandler(this.viewWeakReference, this.fileBean).sendEmptyMessage(10000);
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        this.isCancelled = true;
        return super.cancel();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOCAL_PHOTO_PICKER_THUMBNAIL;
    }
}
