package pm;

import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import p020ap.C1007b;
import p336he.C10153d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import tl.C13036o;

/* renamed from: pm.z */
/* loaded from: classes6.dex */
public class C12199z extends AbstractC12367d implements Comparator<UserBackupInfo.UserDeviceInfo>, Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final int f56569a;

    /* renamed from: b */
    public final int f56570b;

    public C12199z() {
        this(0);
    }

    @Override // java.util.Comparator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compare(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo.getLastbackupTime() > userDeviceInfo2.getLastbackupTime()) {
            return -1;
        }
        return userDeviceInfo.getLastbackupTime() < userDeviceInfo2.getLastbackupTime() ? 1 : 0;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("OtherDeviceBackupRecordTask", "OtherDeviceBackupRecordTask begin");
        try {
            UserBackupInfo userBackupInfoM6025p = C1007b.m5980s().m6025p(true, this.f56569a);
            if (userBackupInfoM6025p == null) {
                return;
            }
            List<UserBackupInfo.UserDeviceInfo> userBackupInfos = userBackupInfoM6025p.getUserBackupInfos();
            C13036o c13036o = new C13036o();
            c13036o.clear();
            if (userBackupInfos != null) {
                c13036o.m78573m(C10153d.m63241e(userBackupInfos));
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 33038;
            CBCallBack.getInstance().sendMessage(messageObtain);
            C11839m.m70688i("OtherDeviceBackupRecordTask", "OtherDeviceBackupRecordTask end");
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceBackupRecordTask", "OtherDeviceBackupRecordTask exception: " + e10.getMessage());
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = this.f56570b;
            if (e10.m60659c() == 3900) {
                messageObtain2.arg1 = 2;
            } else {
                messageObtain2.arg1 = 3;
            }
            CBCallBack.getInstance().sendMessage(messageObtain2);
        } catch (Exception e11) {
            C11839m.m70689w("OtherDeviceBackupRecordTask", "OtherDeviceBackupRecordTask Exception " + e11.getMessage());
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = this.f56570b;
            messageObtain3.arg1 = 3;
            CBCallBack.getInstance().sendMessage(messageObtain3);
        }
    }

    public C12199z(int i10) {
        this(i10, 33048);
    }

    public C12199z(int i10, int i11) {
        this.f56569a = i10;
        this.f56570b = i11;
    }
}
