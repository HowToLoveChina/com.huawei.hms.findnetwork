package p031b7;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import fk.C9720a;
import hk.C10278a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: b7.w */
/* loaded from: classes2.dex */
public class C1142w extends AbstractC1139t {
    /* renamed from: g */
    private void m7205g(File file, File file2) throws Exception {
        C9720a.m60653b(file.getName(), "File Name is Empty");
        C9720a.m60653b(file.getCanonicalPath(), "File Path is Empty");
        C9720a.m60657f(file2, "EmptyThumbnailFile is Null");
    }

    /* renamed from: i */
    private Bitmap m7206i(File file, int i10, int i11, FailRet failRet) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(file.getCanonicalPath());
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
            } catch (Exception e10) {
                String str = "Failed to make bitmap. " + e10;
                C1120a.m6676e("VideoThumUtil", str);
                failRet.setErrMsg(failRet.getErrMsg() + ", " + str);
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused) {
                    C1120a.m6678w("VideoThumUtil", "Ignore failures while cleaning up.");
                }
                frameAtTime = null;
            }
            if (frameAtTime == null) {
                C1120a.m6676e("VideoThumUtil", "Failed to make bitmap. Bitmap is null");
                return null;
            }
            int height = frameAtTime.getHeight();
            int width = frameAtTime.getWidth();
            int iMin = Math.min(i11 != 0 ? width / i11 : 0, i10 != 0 ? height / i10 : 0);
            if (iMin <= 0) {
                iMin = 1;
            }
            return ThumbnailUtils.extractThumbnail(frameAtTime, width / iMin, height / iMin, 2);
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception unused2) {
                C1120a.m6678w("VideoThumUtil", "Ignore failures while cleaning up.");
            }
        }
    }

    @Override // p031b7.AbstractC1139t
    /* renamed from: b */
    public Thumbnail mo6907b(File file, File file2, int i10, FailRet failRet) throws Throwable {
        File fileM7207h;
        if (file == null) {
            C1120a.m6676e("VideoThumUtil", "Generate Video Large Thumbnail Failed, emptyThumbnail:null");
            failRet.setErrMsg("Generate Video Large Thumbnail Failed, emptyThumbnail:null");
            return null;
        }
        int i11 = 0;
        do {
            fileM7207h = m7207h(file2, 1920, 1080, file, failRet);
            i11++;
            if (fileM7207h != null) {
                break;
            }
        } while (i11 <= 3);
        if (fileM7207h != null && fileM7207h.length() != 0) {
            return new Thumbnail("large", fileM7207h);
        }
        C1120a.m6676e("VideoThumUtil", "Generate Video Large Thumbnail Failed");
        failRet.setErrMsg(failRet.getErrMsg() + ", Generate Video Large Thumbnail Failed");
        if (file.delete()) {
            C1120a.m6677i("VideoThumUtil", "Delete Empty Thumbnail Success");
        } else if (file.exists()) {
            C1120a.m6676e("VideoThumUtil", "Delete Empty Thumbnail Failed");
        }
        return null;
    }

    @Override // p031b7.AbstractC1139t
    /* renamed from: c */
    public Thumbnail mo6908c(String str, String str2, File file, int i10) {
        return mo6907b(m7187a(str, str2), file, i10, new FailRet());
    }

    @Override // p031b7.AbstractC1139t
    /* renamed from: e */
    public Thumbnail mo6909e(File file, File file2, int i10, FailRet failRet) throws Throwable {
        File fileM7207h;
        if (file == null) {
            C1120a.m6676e("VideoThumUtil", "Generate Video Small Thumbnail Failed, emptyThumbnail:null");
            failRet.setErrMsg("Generate Video Small Thumbnail Failed, emptyThumbnail:null");
            return null;
        }
        int i11 = 0;
        do {
            fileM7207h = m7207h(file2, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, file, failRet);
            i11++;
            if (fileM7207h != null) {
                break;
            }
        } while (i11 <= 3);
        if (fileM7207h != null && fileM7207h.length() != 0) {
            return new Thumbnail("small", fileM7207h);
        }
        C1120a.m6676e("VideoThumUtil", "Generate Video Small Thumbnail Failed");
        failRet.setErrMsg(failRet.getErrMsg() + ", Generate Video Small Thumbnail Failed");
        if (file.delete()) {
            C1120a.m6677i("VideoThumUtil", "Delete Empty Thumbnail Success");
        } else if (file.exists()) {
            C1120a.m6676e("VideoThumUtil", "Delete Empty Thumbnail Failed");
        }
        return null;
    }

    @Override // p031b7.AbstractC1139t
    /* renamed from: f */
    public Thumbnail mo6910f(String str, String str2, File file, int i10) {
        return mo6909e(m7188d(str, str2), file, i10, new FailRet());
    }

    /* renamed from: h */
    public final File m7207h(File file, int i10, int i11, File file2, FailRet failRet) throws Throwable {
        FileOutputStream fileOutputStreamM63445k;
        Bitmap bitmapM7206i;
        C1120a.m6677i("VideoThumUtil", "Generate Video Thumbnail Start");
        try {
            try {
                fileOutputStreamM63445k = C10278a.m63445k(file2);
                try {
                    m7205g(file, file2);
                    bitmapM7206i = m7206i(file, i10, i11, failRet);
                } catch (Throwable th2) {
                    th = th2;
                    file2 = null;
                }
            } catch (Exception e10) {
                e = e10;
                String str = "Generate Video Thumbnail Failed. " + e;
                C1120a.m6676e("VideoThumUtil", str);
                failRet.setErrMsg(failRet.getErrMsg() + ", " + str);
                C1120a.m6677i("VideoThumUtil", "Generate Video End");
                return file2;
            }
        } catch (Exception e11) {
            e = e11;
            file2 = null;
            String str2 = "Generate Video Thumbnail Failed. " + e;
            C1120a.m6676e("VideoThumUtil", str2);
            failRet.setErrMsg(failRet.getErrMsg() + ", " + str2);
            C1120a.m6677i("VideoThumUtil", "Generate Video End");
            return file2;
        }
        if (bitmapM7206i == null) {
            C1120a.m6678w("VideoThumUtil", "generate video thumbnail, bitmap:null");
            failRet.setErrMsg(failRet.getErrMsg() + ", generate video thumbnail, bitmap:null");
            if (fileOutputStreamM63445k != null) {
                fileOutputStreamM63445k.close();
            }
            return null;
        }
        bitmapM7206i.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamM63445k);
        if (file2 == null) {
            try {
                C1120a.m6678w("VideoThumUtil", "generate video thumbnail, thumbnailFile:null");
                failRet.setErrMsg(failRet.getErrMsg() + ", generate video thumbnail, thumbnailFile:null");
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStreamM63445k != null) {
                    try {
                        fileOutputStreamM63445k.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                }
                throw th;
            }
        }
        if (fileOutputStreamM63445k != null) {
            fileOutputStreamM63445k.close();
        }
        C1120a.m6677i("VideoThumUtil", "Generate Video End");
        return file2;
    }
}
