package pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSizeInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import im.C10546a;
import im.C10574x;
import im.InterfaceC10551c0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p814yl.C13998b0;
import p848zl.C14333b;

/* renamed from: pm.b */
/* loaded from: classes6.dex */
public class C12174b extends AbstractC12367d {

    /* renamed from: a */
    public List<AppDetailsInfo> f56497a;

    /* renamed from: b */
    public Context f56498b;

    /* renamed from: d */
    public String f56500d;

    /* renamed from: c */
    public List<String> f56499c = new ArrayList();

    /* renamed from: e */
    public C13998b0 f56501e = new C13998b0();

    public C12174b(List<AppDetailsInfo> list, Context context, String str) {
        this.f56497a = list;
        this.f56498b = context;
        this.f56500d = str;
    }

    /* renamed from: e */
    public static /* synthetic */ InterfaceC10551c0 m73257e(String str, String str2, AppSizeInfo appSizeInfo, String str3, String str4) throws C9721b {
        return new C10574x(null, str, str2, "icon", appSizeInfo.getId(), str3, str4);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws PackageManager.NameNotFoundException {
        int iMin;
        PackageInfo packageInfo;
        PackageManager packageManager = this.f56498b.getPackageManager();
        Iterator<AppDetailsInfo> it = this.f56497a.iterator();
        while (true) {
            iMin = 0;
            if (!it.hasNext()) {
                try {
                    break;
                } catch (Exception e10) {
                    C11839m.m70688i("AppIconTask", "appsIcon error: " + e10.toString());
                    return;
                }
            }
            AppDetailsInfo next = it.next();
            if (!C14333b.m85483r().containsKey(next.getBackupAppName())) {
                try {
                    packageInfo = packageManager.getPackageInfo(next.getBackupAppName(), 0);
                } catch (PackageManager.NameNotFoundException e11) {
                    C11839m.m70688i("AppIconTask", e11.getMessage());
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    File fileM63441g = C10278a.m63441g(this.f56498b.getFilesDir(), "icons");
                    if (fileM63441g.exists()) {
                        if (C10278a.m63441g(fileM63441g, next.getBackupAppName() + ".icon").exists()) {
                        }
                    }
                    this.f56499c.add(next.getBackupAppName());
                }
            }
        }
        String strM66627b = C11058a.m66627b("02103");
        int size = this.f56499c.size();
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                return;
            }
            iMin = Math.min(iMin + 10, size);
            m73258d(strM66627b, this.f56501e.m84114N(this.f56500d, strM66627b, this.f56499c.subList(i10, iMin)));
        }
    }

    /* renamed from: d */
    public final void m73258d(final String str, List<AppSizeInfo> list) {
        File fileM63441g = C10278a.m63441g(this.f56498b.getFilesDir(), "icons");
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d("AppIconTask", "3rd icon mkdirs failed.");
            return;
        }
        for (final AppSizeInfo appSizeInfo : list) {
            Attachment attachment = appSizeInfo.getAttachments().get(0);
            final String assetId = attachment.getAssetId();
            final String versionId = attachment.getVersionId();
            final String strM63452a = C10279b.m63452a(C10278a.m63441g(fileM63441g, appSizeInfo.getBackupAppName() + ".icon"));
            try {
                C10546a.m64704a(new C10546a.a() { // from class: pm.a
                    @Override // im.C10546a.a
                    /* renamed from: a */
                    public final InterfaceC10551c0 mo1696a() {
                        return C12174b.m73257e(str, strM63452a, appSizeInfo, assetId, versionId);
                    }
                }).m64705b();
                CBCallBack.getInstance().sendMessage(Message.obtain(null, 33001, appSizeInfo.getBackupAppName()));
            } catch (C9721b e10) {
                C11839m.m70689w("AppIconTask", "downloadIcons appId =" + appSizeInfo.getBackupAppName() + e10.getMessage());
            }
        }
    }
}
