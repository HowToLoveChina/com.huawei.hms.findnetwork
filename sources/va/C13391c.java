package va;

import android.text.TextUtils;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import hk.C10278a;
import java.io.File;
import p514o9.C11839m;

/* renamed from: va.c */
/* loaded from: classes3.dex */
public class C13391c {
    /* renamed from: a */
    public static boolean m80473a(String str) {
        if (!str.contains("./") && !str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) && !str.contains(".\\.\\") && !str.contains("%00")) {
            return true;
        }
        C11839m.m70689w("PathUtil", "file path can't contains ./、../、.\\.\\、%00 !");
        return false;
    }

    /* renamed from: b */
    public static synchronized String m80474b(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("PathUtil", "Generate Small Thumbnail Name Failed: File Name is Empty");
            return null;
        }
        return m80475c(str, m80476d(), "thumbnail");
    }

    /* renamed from: c */
    public static String m80475c(String str, String str2, String str3) {
        int i10 = 0;
        if (str.length() > 30) {
            str = str.substring(0, 30);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        do {
            sb2.append(str3);
            sb2.append("_");
            sb2.append(str);
            sb2.append("_");
            sb2.append(jCurrentTimeMillis);
            sb3.append(str2);
            sb3.append(File.separator);
            sb3.append((CharSequence) sb2);
            jCurrentTimeMillis++;
            i10++;
            if (!new File(sb3.toString()).exists()) {
                break;
            }
        } while (i10 < 99);
        if (i10 < 99) {
            return sb3.toString();
        }
        C11839m.m70687e("PathUtil", "Failed To Generate File Name: Too Many Files With Same Name");
        return null;
    }

    /* renamed from: d */
    public static String m80476d() {
        File fileM63442h = C10278a.m63442h("data/data/com.huawei.hidisk/cache/thumbnail");
        if (fileM63442h.exists() || fileM63442h.mkdirs()) {
            return "data/data/com.huawei.hidisk/cache/thumbnail";
        }
        C11839m.m70687e("PathUtil", "Create thumbnail folder Failed. Small Thumbnail Folder");
        return null;
    }
}
