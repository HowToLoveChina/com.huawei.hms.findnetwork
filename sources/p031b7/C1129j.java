package p031b7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import fk.C9720a;
import hk.C10278a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: b7.j */
/* loaded from: classes2.dex */
public class C1129j extends AbstractC1139t {

    /* renamed from: a */
    public int f5386a = 1;

    /* renamed from: b */
    public int f5387b = C5976k.e.f27211b;

    @Override // p031b7.AbstractC1139t
    /* renamed from: b */
    public Thumbnail mo6907b(File file, File file2, int i10, FailRet failRet) {
        File fileM6914j;
        if (file == null) {
            C1120a.m6676e("ImageThumUtil", "Generate Image Large Thumbnail Failed, emptyThumbnail:null");
            failRet.setErrMsg("Generate Image Large Thumbnail Failed, emptyThumbnail:null");
            return null;
        }
        int i11 = 0;
        do {
            fileM6914j = m6914j(file2, 1920, 1080, i10, file, failRet);
            i11++;
            if (fileM6914j != null) {
                break;
            }
        } while (i11 <= 3);
        if (fileM6914j != null && fileM6914j.length() != 0) {
            return new Thumbnail("large", fileM6914j);
        }
        C1120a.m6676e("ImageThumUtil", "Generate Image Large Thumbnail Failed");
        failRet.setErrMsg(failRet.getErrMsg() + ", Generate Image Large Thumbnail Failed");
        if (file.delete()) {
            C1120a.m6677i("ImageThumUtil", "Delete Empty Thumbnail Success");
        } else if (file.exists()) {
            C1120a.m6676e("ImageThumUtil", "Delete Empty Thumbnail Failed");
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
    public Thumbnail mo6909e(File file, File file2, int i10, FailRet failRet) {
        File fileM6914j;
        if (file == null) {
            C1120a.m6676e("ImageThumUtil", "Generate Image Small Thumbnail Failed, emptyThumbnail:null");
            failRet.setErrMsg("Generate Image Small Thumbnail Failed, emptyThumbnail:null");
            return null;
        }
        int i11 = 0;
        do {
            fileM6914j = m6914j(file2, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, i10, file, failRet);
            i11++;
            if (fileM6914j != null) {
                break;
            }
        } while (i11 <= 3);
        if (fileM6914j != null && fileM6914j.length() != 0) {
            return new Thumbnail("small", fileM6914j);
        }
        C1120a.m6676e("ImageThumUtil", "Generate Image Small Thumbnail Failed");
        failRet.setErrMsg(failRet.getErrMsg() + ", Generate Image Small Thumbnail Failed");
        if (file.delete()) {
            C1120a.m6677i("ImageThumUtil", "Delete Empty Thumbnail Success");
        } else if (file.exists()) {
            C1120a.m6676e("ImageThumUtil", "Delete Empty Thumbnail Failed");
        }
        return null;
    }

    @Override // p031b7.AbstractC1139t
    /* renamed from: f */
    public Thumbnail mo6910f(String str, String str2, File file, int i10) {
        return mo6909e(m7188d(str, str2), file, i10, new FailRet());
    }

    /* renamed from: g */
    public final void m6911g(File file, File file2) throws Exception {
        C9720a.m60653b(file.getName(), "File Name is Empty");
        C9720a.m60653b(file.getCanonicalPath(), "File Path is Empty");
        C9720a.m60657f(file2, "EmptyThumbnailFile is Null");
    }

    /* renamed from: h */
    public final File m6912h(Bitmap bitmap, File file, int i10, FailRet failRet) throws IOException {
        FileOutputStream fileOutputStreamM63445k;
        try {
            fileOutputStreamM63445k = C10278a.m63445k(file.getAbsoluteFile());
        } catch (FileNotFoundException unused) {
            C1120a.m6676e("ImageThumUtil", "Compress Bitmap Failed error");
            failRet.setErrMsg(failRet.getErrMsg() + ", Compress Bitmap Failed error");
        } catch (Exception e10) {
            String str = "Compress Bitmap Failed Exception: " + e10;
            C1120a.m6676e("ImageThumUtil", str);
            failRet.setErrMsg(failRet.getErrMsg() + ", " + str);
        }
        try {
            if (i10 == 102) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStreamM63445k);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamM63445k);
            }
            if (fileOutputStreamM63445k != null) {
                fileOutputStreamM63445k.close();
            }
            return file;
        } catch (Throwable th2) {
            if (fileOutputStreamM63445k != null) {
                try {
                    fileOutputStreamM63445k.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: i */
    public final Bitmap m6913i(String str, BitmapFactory.Options options, FailRet failRet) {
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e10) {
            String str2 = "decodeFile, Exception: " + e10;
            C1120a.m6676e("ImageThumUtil", str2);
            failRet.setErrMsg(failRet.getErrMsg() + ", " + str2);
            return null;
        } catch (OutOfMemoryError unused) {
            C1120a.m6676e("ImageThumUtil", "decodeFile error");
            failRet.setErrMsg(failRet.getErrMsg() + ", decodeFile error");
            return null;
        }
    }

    /* renamed from: j */
    public final File m6914j(File file, int i10, int i11, int i12, File file2, FailRet failRet) {
        File fileM6912h;
        C1120a.m6677i("ImageThumUtil", "Generate ImageThumbnail Start");
        File file3 = null;
        try {
            m6911g(file, file2);
            fileM6912h = null;
            do {
                try {
                    int i13 = this.f5386a;
                    Bitmap bitmapM6915k = m6915k(file, i10 / i13, i11 / i13, failRet);
                    fileM6912h = bitmapM6915k != null ? m6912h(bitmapM6915k, file2, i12, failRet) : null;
                    this.f5386a++;
                    String str = "generate image thumbnail retryTime:" + this.f5386a;
                    if (bitmapM6915k == null) {
                        str = str + ", bitmap:null";
                    }
                    if (fileM6912h == null) {
                        str = str + ", thumbnailFile:null";
                    }
                    C1120a.m6677i("ImageThumUtil", str);
                    failRet.setErrMsg(failRet.getErrMsg() + ", " + str);
                    if (fileM6912h == null || fileM6912h.length() <= this.f5387b) {
                        break;
                    }
                } catch (Exception e10) {
                    e = e10;
                    file3 = fileM6912h;
                    String str2 = "Generate ImageThumbnail Exception: " + e;
                    C1120a.m6676e("ImageThumUtil", str2);
                    failRet.setErrMsg(failRet.getErrMsg() + ", " + str2);
                    fileM6912h = file3;
                    C1120a.m6677i("ImageThumUtil", "Generate ImageThumbnail End");
                    return fileM6912h;
                }
            } while (this.f5386a <= 3);
        } catch (Exception e11) {
            e = e11;
        }
        C1120a.m6677i("ImageThumUtil", "Generate ImageThumbnail End");
        return fileM6912h;
    }

    /* renamed from: k */
    public final Bitmap m6915k(File file, int i10, int i11, FailRet failRet) throws Exception {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        m6913i(file.getCanonicalPath(), options, failRet);
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int iMin = Math.min(i13 / i11, i12 / i10);
        int i14 = iMin > 0 ? iMin : 1;
        options.inSampleSize = i14;
        options.inJustDecodeBounds = false;
        Bitmap bitmapM6913i = m6913i(file.getCanonicalPath(), options, failRet);
        return (i10 < i12 || i11 < i13) ? ThumbnailUtils.extractThumbnail(bitmapM6913i, i13 / i14, i12 / i14, 2) : ThumbnailUtils.extractThumbnail(bitmapM6913i, i13, i12, 2);
    }
}
