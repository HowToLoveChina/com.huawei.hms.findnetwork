package p763x5;

import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import p229di.C9142g;
import pe.C12132a;

/* renamed from: x5.e */
/* loaded from: classes.dex */
public class C13707e implements InterfaceC13705c {

    /* renamed from: a */
    public static final String f61703a;

    static {
        f61703a = C9142g.m57463b() ? "com.hihonor.notepad" : NextRestoreConstants.PKG_NAME_MEMO;
    }

    @Override // p763x5.InterfaceC13705c
    /* renamed from: a */
    public void mo82451a(C12132a c12132a, String str, int i10, long j10, String str2) throws RemoteException {
        if (c12132a == null || str == null) {
            C2111d.m12648d("ClonePowerKitMemoNewName", "power kit is null or clone module name is null!");
        } else if (str.equals("Memo")) {
            C2111d.m12654j("ClonePowerKitMemoNewName", "applyForResourceUse new memo result = ", Boolean.valueOf(c12132a.m72751a(f61703a, i10, j10, str2)));
        }
    }
}
