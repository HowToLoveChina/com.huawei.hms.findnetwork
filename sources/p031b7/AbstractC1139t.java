package p031b7;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import hk.C10278a;
import java.io.File;
import java.io.IOException;

/* renamed from: b7.t */
/* loaded from: classes2.dex */
public abstract class AbstractC1139t {
    /* renamed from: a */
    public File m7187a(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str2)) {
            C1120a.m6676e("ThumbnailUtil", "Generate Large Empty Thumbnail Failed: File Name is Empty");
            return null;
        }
        boolean zCreateNewFile = false;
        int i10 = 0;
        File fileM63442h = null;
        while (!zCreateNewFile && i10 < 10) {
            File fileM63442h2 = C10278a.m63442h(C1122c.m6782g0(1, str));
            if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
                C1120a.m6676e("ThumbnailUtil", "dirFile.mkdirs failed");
            }
            fileM63442h = C10278a.m63442h(C1122c.m6786h0(1, str, str2));
            try {
                zCreateNewFile = fileM63442h.createNewFile();
            } catch (IOException e10) {
                C1120a.m6678w("ThumbnailUtil", "Create Large New File Failed" + e10);
            }
            i10++;
        }
        if (i10 < 10) {
            return fileM63442h;
        }
        C1120a.m6676e("ThumbnailUtil", "Too many files with same name.");
        return null;
    }

    /* renamed from: b */
    public abstract Thumbnail mo6907b(File file, File file2, int i10, FailRet failRet);

    /* renamed from: c */
    public abstract Thumbnail mo6908c(String str, String str2, File file, int i10);

    /* renamed from: d */
    public File m7188d(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str2)) {
            C1120a.m6676e("ThumbnailUtil", "Generate Small Empty Thumbnail Failed: File Name is Empty");
            return null;
        }
        boolean zCreateNewFile = false;
        int i10 = 0;
        File fileM63442h = null;
        while (!zCreateNewFile && i10 < 10) {
            File fileM63442h2 = C10278a.m63442h(C1122c.m6782g0(2, str));
            if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
                C1120a.m6676e("ThumbnailUtil", "dirFile.mkdirs failed");
            }
            fileM63442h = C10278a.m63442h(C1122c.m6786h0(2, str, str2));
            try {
                zCreateNewFile = fileM63442h.createNewFile();
            } catch (IOException e10) {
                C1120a.m6678w("ThumbnailUtil", "Create Small New File Failed" + e10);
            }
            i10++;
        }
        if (i10 < 10) {
            return fileM63442h;
        }
        C1120a.m6676e("ThumbnailUtil", "Too many files with same name.");
        return null;
    }

    /* renamed from: e */
    public abstract Thumbnail mo6909e(File file, File file2, int i10, FailRet failRet);

    /* renamed from: f */
    public abstract Thumbnail mo6910f(String str, String str2, File file, int i10);
}
