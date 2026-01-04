package p336he;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Random;

/* renamed from: he.k */
/* loaded from: classes3.dex */
public class C10160k {
    /* renamed from: a */
    public static String m63340a() {
        return String.valueOf(new Random().nextInt(90000000) + ExceptionCode.CRASH_EXCEPTION);
    }

    /* renamed from: b */
    public static String m63341b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + "_" + (System.currentTimeMillis() / 1000) + "_" + m63340a();
    }
}
