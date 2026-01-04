package p229di;

import android.os.UserHandle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import p229di.C9142g;

/* renamed from: di.r */
/* loaded from: classes4.dex */
public class C9153r {
    /* renamed from: a */
    public static UserHandle m57493a(int i10) {
        try {
            return (UserHandle) C9142g.a.m57468c("android.os.UserHandle", Integer.TYPE).m57470d("getUserHandleForUid", Integer.valueOf(i10)).m57472f();
        } catch (Exception e10) {
            C2111d.m12648d("OS", "getUserHandleForUid error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static int m57494b() {
        try {
            return ((Integer) C9142g.a.m57468c("android.os.UserHandle", new Class[0]).m57470d("myUserId", new Object[0]).m57472f()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }
}
