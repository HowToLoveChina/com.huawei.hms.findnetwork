package p252e9;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import java.util.List;
import p514o9.C11839m;

/* renamed from: e9.k */
/* loaded from: classes3.dex */
public class C9434k {
    /* renamed from: a */
    public static String m59166a(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (c10 == '*') {
                sb2.append("(.)*");
            } else {
                sb2.append(c10);
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static boolean m59167b(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("RecommendedOpenDeviceChecker", "deviceMatch config is empty");
            return false;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("RecommendedOpenDeviceChecker", "deviceMatch phoneType is empty");
            return false;
        }
        C11839m.m70688i("RecommendedOpenDeviceChecker", "deviceMatch cloud phoneTypes " + list + " ,current phoneType = " + str);
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e("RecommendedOpenDeviceChecker", "device is empty");
            } else if (str.matches(m59166a(str2))) {
                C11839m.m70688i("RecommendedOpenDeviceChecker", "deviceMatch device = " + str2);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m59168c() {
        NotificationConfig config = new HNCloudConfig().getConfig();
        if (config != null) {
            return m59167b(config.getRecommendedOpenDevice());
        }
        return false;
    }
}
