package p699v4;

import android.content.Context;
import android.os.UserManager;
import com.android.internal.widget.LockPatternUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import p229di.C9155t;

/* renamed from: v4.l */
/* loaded from: classes.dex */
public class C13343l {
    /* renamed from: a */
    public static String m80059a(Context context) {
        try {
            int iM12619e = C2108a.m12619e();
            LockPatternUtils lockPatternUtils = new LockPatternUtils(context);
            int iM57497b = C9155t.m57497b((UserManager) context.getSystemService("user"), iM12619e);
            if (lockPatternUtils.isLockScreenDisabled(iM57497b)) {
                return "unlock_set_off";
            }
            int keyguardStoredPasswordQuality = lockPatternUtils.getKeyguardStoredPasswordQuality(iM57497b);
            if (keyguardStoredPasswordQuality == 0) {
                return "unlock_set_none";
            }
            if (keyguardStoredPasswordQuality == 65536) {
                return "unlock_set_pattern";
            }
            if (keyguardStoredPasswordQuality == 131072 || keyguardStoredPasswordQuality == 196608) {
                return "unlock_set_pin";
            }
            if (keyguardStoredPasswordQuality == 262144 || keyguardStoredPasswordQuality == 327680 || keyguardStoredPasswordQuality == 393216) {
                return "unlock_set_password";
            }
            if (keyguardStoredPasswordQuality != 524288) {
                return null;
            }
            return "unlock_set_managed";
        } catch (Error unused) {
            C2111d.m12648d("PhoneLockPatternUtils", "Error: get password type faild.");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("PhoneLockPatternUtils", "Exception: get password type faild.");
            return null;
        } catch (NoSuchMethodError unused3) {
            C2111d.m12648d("PhoneLockPatternUtils", "NoSuchMethodError: get password type faild.");
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m80060b(Context context) {
        String strM80059a = m80059a(context);
        return "unlock_set_pattern".equals(strM80059a) || "unlock_set_pin".equals(strM80059a) || "unlock_set_password".equals(strM80059a);
    }
}
