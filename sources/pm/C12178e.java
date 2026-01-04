package pm;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import fk.C9721b;
import java.lang.ref.WeakReference;
import mk.C11477c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p703v8.C13366c;
import p711vl.C13467g;

/* renamed from: pm.e */
/* loaded from: classes6.dex */
public class C12178e extends AbstractC12367d {

    /* renamed from: f */
    public static final String f56513f = "e";

    /* renamed from: a */
    public final WeakReference<Handler> f56514a;

    /* renamed from: b */
    public boolean f56515b;

    /* renamed from: c */
    public boolean f56516c;

    /* renamed from: d */
    public boolean f56517d;

    /* renamed from: e */
    public int f56518e;

    public C12178e(Handler handler, int i10) {
        this.f56515b = false;
        this.f56516c = false;
        this.f56517d = false;
        this.f56518e = 0;
        this.f56514a = new WeakReference<>(handler);
        this.f56518e = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C13366c c13366c = new C13366c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = f56513f;
        C11839m.m70688i(str, "BackupStorageRequestor begin.");
        BackupStorageInfo backupStorageInfoM80174e = c13366c.m80174e(this.f56515b, this.f56516c, this.f56517d, this.f56518e);
        C11839m.m70688i(str, "BackupStorageRequestor end,time cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        Handler handler = this.f56514a.get();
        if (handler == null) {
            C11839m.m70687e(str, "BackupStorageRequestor handler is null");
            return;
        }
        Message messageObtain = Message.obtain();
        if (c13366c.m80171b() != 0) {
            if (c13366c.m80171b() == 3900) {
                messageObtain.what = 1003;
                handler.sendMessage(messageObtain);
                return;
            } else {
                messageObtain.what = 1002;
                handler.sendMessage(messageObtain);
                return;
            }
        }
        if (backupStorageInfoM80174e == null) {
            C11839m.m70687e(str, "BackupStorageRequestor is null");
            messageObtain.what = 1002;
        } else {
            if (backupStorageInfoM80174e.getCurrentDeviceBackupDetails() != null && !TextUtils.isEmpty(backupStorageInfoM80174e.getCurrentDeviceBackupDetails().getDeviceName())) {
                String strM68636f = C11477c.m68636f(backupStorageInfoM80174e.getCurrentDeviceBackupDetails().getDeviceName());
                if (!TextUtils.isEmpty(strM68636f)) {
                    C13467g.m81086c().m81097l(strM68636f);
                }
            }
            messageObtain.what = 1001;
            messageObtain.obj = backupStorageInfoM80174e;
        }
        C11839m.m70688i(str, "return msg.");
        handler.sendMessage(messageObtain);
    }

    public C12178e(Handler handler, boolean z10, boolean z11, boolean z12, int i10) {
        this.f56515b = false;
        this.f56516c = false;
        this.f56517d = false;
        this.f56518e = 0;
        this.f56514a = new WeakReference<>(handler);
        this.f56515b = z10;
        this.f56516c = z11;
        this.f56517d = z12;
        this.f56518e = i10;
    }
}
