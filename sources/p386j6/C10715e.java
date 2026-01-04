package p386j6;

import android.os.RemoteException;
import android.p018os.IBackupSessionCallback;
import com.huawei.android.backup.filelogic.utils.C2111d;
import p229di.C9137b;

/* renamed from: j6.e */
/* loaded from: classes.dex */
public class C10715e {

    /* renamed from: a */
    public static IBackupSessionCallback f51360a = new a();

    /* renamed from: j6.e$a */
    public class a extends IBackupSessionCallback.Stub {
        @Override // android.p018os.IBackupSessionCallback
        public void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException {
        }
    }

    /* renamed from: a */
    public static String m65404a(int i10) {
        String str = "setweight tar " + i10;
        C2111d.m12653i("PMSAppDataWeightUtil", "appdata weight: " + i10 + " appDataWeightCmd: " + str);
        return str;
    }

    /* renamed from: b */
    public static int m65405b(int i10) {
        C2111d.m12653i("PMSAppDataWeightUtil", "setPMSAppDataWeight  start ");
        int iM57453e = C9137b.m57453e(f51360a);
        if (iM57453e == -1 || iM57453e == -2) {
            C2111d.m12653i("PMSAppDataWeightUtil", "PackageManagerEx startBackupSession fail,sessionId:" + iM57453e);
            return -1;
        }
        C2111d.m12653i("PMSAppDataWeightUtil", "setPMSAppDataWeight taskID = " + C9137b.m57449a(iM57453e, m65404a(i10)));
        C2111d.m12653i("PMSAppDataWeightUtil", "setPMSAppDataWeight finishBackupSession, pes:" + C9137b.m57450b(iM57453e));
        return 0;
    }
}
