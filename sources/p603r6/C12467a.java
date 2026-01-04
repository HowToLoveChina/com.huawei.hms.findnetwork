package p603r6;

import android.content.Context;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.huawei.android.p069cg.p072vo.SettingsProp;
import p031b7.C1124e;
import p031b7.C1136q;
import p035bk.C1249b;

/* renamed from: r6.a */
/* loaded from: classes2.dex */
public class C12467a {
    /* renamed from: a */
    public static String m74743a(Context context) {
        if (context == null) {
            return "";
        }
        for (StorageVolume storageVolume : C1249b.m7483f((StorageManager) context.getSystemService("storage"))) {
            if (storageVolume.isPrimary() && storageVolume.isEmulated()) {
                return C1249b.m7481d(storageVolume);
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m74744b(Context context, int i10, String str, String str2) {
        SettingsProp settingsPropM7118a = C1136q.c.m7118a(context);
        if (str == null || str.isEmpty() || i10 == 0) {
            return null;
        }
        String thumbCachePath = i10 == 2 ? settingsPropM7118a.getThumbCachePath() != null ? settingsPropM7118a.getThumbCachePath() : C1124e.m6870n(context) : i10 == 1 ? settingsPropM7118a.getLcdCachePath() != null ? settingsPropM7118a.getLcdCachePath() : C1124e.m6867k(context) : "";
        if (thumbCachePath != null && !thumbCachePath.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(thumbCachePath);
            sb2.append("/");
            sb2.append(str);
            sb2.append("/");
            if (str2 != null) {
                sb2.append(str2);
            }
            return sb2.toString();
        }
        return null;
    }
}
