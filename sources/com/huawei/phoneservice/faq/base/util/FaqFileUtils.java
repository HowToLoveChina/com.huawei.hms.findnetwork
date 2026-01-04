package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import androidx.annotation.Keep;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.File;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public final class FaqFileUtils {

    /* renamed from: a */
    public static final FaqFileUtils f38694a = new FaqFileUtils();

    @Keep
    public static final String getCompressFolder(Context context) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        FaqFileUtils faqFileUtils = f38694a;
        return faqFileUtils.m51829b(faqFileUtils.m51828a(context));
    }

    @Keep
    public static final File getDownloadFolder(Context context) {
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        FaqFileUtils faqFileUtils = f38694a;
        return faqFileUtils.m51830c(faqFileUtils.m51828a(context));
    }

    /* renamed from: a */
    public final File m51828a(Context context) {
        return context.getCacheDir();
    }

    /* renamed from: b */
    public final String m51829b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        File file2 = new File(file.toString() + File.separator + "picCache");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getAbsolutePath();
    }

    /* renamed from: c */
    public final File m51830c(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        File file2 = new File(file, "Download" + File.separator + "FeedbackDownload");
        if (file2.isDirectory() || file2.mkdirs()) {
            return file2;
        }
        return null;
    }
}
