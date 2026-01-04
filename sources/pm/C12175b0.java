package pm;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefreshRequestNoLock;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import fk.C9721b;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p814yl.C13998b0;
import tl.C13036o;

/* renamed from: pm.b0 */
/* loaded from: classes6.dex */
public class C12175b0 extends AbstractC12367d {

    /* renamed from: a */
    public final SoftReference<Handler> f56502a;

    /* renamed from: b */
    public String f56503b;

    /* renamed from: c */
    public String f56504c;

    /* renamed from: d */
    public UserBackupInfo.UserDeviceInfo f56505d;

    public C12175b0(Handler handler, String str, String str2) {
        this.f56502a = new SoftReference<>(handler);
        this.f56503b = str;
        this.f56504c = str2;
    }

    /* renamed from: c */
    public final boolean m73259c(Handler handler) {
        if (TextUtils.isEmpty(this.f56503b) || TextUtils.isEmpty(this.f56504c)) {
            C11839m.m70689w("TempBackupSaveToCloudSpaceTask", "backupId or backupDeviceId is null or empty.");
            return true;
        }
        if (handler != null) {
            return false;
        }
        C11839m.m70687e("TempBackupSaveToCloudSpaceTask", "TempBackupSaveToCloudSpaceTask handler is null");
        return true;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("TempBackupSaveToCloudSpaceTask", "enter into moveTempBackupToCloudSpace,backupId is:" + this.f56503b);
        Handler handler = this.f56502a.get();
        if (m73259c(handler)) {
            return;
        }
        C13998b0 c13998b0 = new C13998b0();
        Message messageObtain = Message.obtain();
        try {
            BakRefreshRequestNoLock bakRefreshRequestNoLock = new BakRefreshRequestNoLock();
            bakRefreshRequestNoLock.setOccupySpaceType(1);
            boolean z10 = c13998b0.m84122R(this.f56504c, this.f56503b, C11058a.m66627b("02025"), bakRefreshRequestNoLock).getOccupySpaceType().intValue() == 1;
            UserBackupInfo.UserDeviceInfo userDeviceInfo = this.f56505d;
            if (userDeviceInfo != null) {
                Iterator<ExtraDeviceInfo> it = userDeviceInfo.getExtraDeviceInfos().iterator();
                while (it.hasNext()) {
                    ExtraDeviceInfo next = it.next();
                    if (StringUtil.equals(next.getId(), this.f56505d.getBakId())) {
                        next.setOccupySpaceType(1);
                        next.setExpiratoryInDays(-1);
                        next.setCanBeReserveForever(false);
                    }
                }
                C11839m.m70688i("TempBackupSaveToCloudSpaceTask", "update userDeviceInfo :" + this.f56505d.getDevDisplayName());
                new C13036o().m78574n(this.f56505d);
            }
            C12515a.m75110o().m75172d(new C12199z(1));
            messageObtain.what = 2001;
            C11839m.m70688i("TempBackupSaveToCloudSpaceTask", "moveTempBackupToCloudSpace success,move result:" + z10);
        } catch (C9721b e10) {
            C11839m.m70687e("TempBackupSaveToCloudSpaceTask", "moveTempBackupToCloudSpace error: " + e10);
            messageObtain.what = 2002;
            messageObtain.obj = e10;
        }
        handler.sendMessage(messageObtain);
    }

    public C12175b0(Handler handler, UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        this.f56502a = new SoftReference<>(handler);
        this.f56505d = userDeviceInfo;
        this.f56503b = userDeviceInfo.getBakId();
        this.f56504c = userDeviceInfo.getBackupDeviceId();
    }
}
