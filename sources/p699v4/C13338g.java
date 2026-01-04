package p699v4;

import android.content.Intent;
import android.os.BadParcelableException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: v4.g */
/* loaded from: classes.dex */
public class C13338g {
    /* renamed from: a */
    public static boolean m80010a(Intent intent, String str, boolean z10) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                return intent.getBooleanExtra(str, z10);
            } catch (BadParcelableException unused) {
                C2111d.m12657m("IntentHelper", "getBooleanExtra BadParcelableException");
            } catch (Exception e10) {
                C2111d.m12648d("IntentHelper", "getBooleanExtra error: " + e10.getMessage());
                return z10;
            }
        }
        return z10;
    }

    /* renamed from: b */
    public static int m80011b(Intent intent, String str, int i10) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                return intent.getIntExtra(str, i10);
            } catch (BadParcelableException unused) {
                C2111d.m12657m("IntentHelper", "getIntExtra BadParcelableException");
            } catch (Exception e10) {
                C2111d.m12648d("IntentHelper", "getIntExtra error: " + e10.getMessage());
                return i10;
            }
        }
        return i10;
    }

    /* renamed from: c */
    public static long m80012c(Intent intent, String str, long j10) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                return intent.getLongExtra(str, j10);
            } catch (BadParcelableException unused) {
                C2111d.m12657m("IntentHelper", "getLongExtra BadParcelableException");
            } catch (Exception e10) {
                C2111d.m12657m("IntentHelper", "getLongExtra error: " + e10.getMessage());
                return j10;
            }
        }
        return j10;
    }

    /* renamed from: d */
    public static String m80013d(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                return intent.getStringExtra(str);
            } catch (BadParcelableException unused) {
                C2111d.m12657m("IntentHelper", "getStringExtra BadParcelableException");
            } catch (Exception e10) {
                C2111d.m12657m("IntentHelper", "getStringExtra error: " + e10.getMessage());
                return "";
            }
        }
        return "";
    }
}
