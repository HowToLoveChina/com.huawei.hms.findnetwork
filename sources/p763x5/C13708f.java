package p763x5;

import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import p229di.C9142g;
import pe.C12132a;

/* renamed from: x5.f */
/* loaded from: classes.dex */
public class C13708f implements InterfaceC13705c {

    /* renamed from: a */
    public static final String f61704a;

    static {
        f61704a = C9142g.m57463b() ? "com.hihonor.soundrecorder" : NextRestoreConstants.PKG_NAME_SOUND_RECORDER;
    }

    @Override // p763x5.InterfaceC13705c
    /* renamed from: a */
    public void mo82451a(C12132a c12132a, String str, int i10, long j10, String str2) throws RemoteException {
        if (c12132a == null || str == null) {
            C2111d.m12648d("ClonePowerKitRecorderNewName", "power kit is null or clone module name is null!");
        } else if (str.equals("soundrecorder")) {
            C2111d.m12654j("ClonePowerKitRecorderNewName", "applyForResourceUse new recorder result = ", Boolean.valueOf(c12132a.m72751a(f61704a, i10, j10, str2)));
        }
    }
}
