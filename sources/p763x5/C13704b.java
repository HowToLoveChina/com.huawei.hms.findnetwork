package p763x5;

import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.feedback.constant.FeedbackConst;
import pe.C12132a;

/* renamed from: x5.b */
/* loaded from: classes.dex */
public class C13704b implements InterfaceC13705c {
    @Override // p763x5.InterfaceC13705c
    /* renamed from: a */
    public void mo82451a(C12132a c12132a, String str, int i10, long j10, String str2) throws RemoteException {
        if (c12132a == null || str == null) {
            C2111d.m12648d("ClonePowerKitEmailOldName", "power kit is null or clone module name is null!");
        } else if (str.equals("email")) {
            C2111d.m12654j("ClonePowerKitEmailOldName", "applyForResourceUse old email result = ", Boolean.valueOf(c12132a.m72751a(FeedbackConst.Mail.ANDROID_EMAIL, i10, j10, str2)));
        }
    }
}
