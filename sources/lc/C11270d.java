package lc;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.servercontrol.ServerControlResultCallback;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import java.net.InetAddress;
import java.util.HashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1007b;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9286e;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11827a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: lc.d */
/* loaded from: classes3.dex */
public class C11270d extends AbstractC12367d {

    /* renamed from: a */
    public ServerControlResultCallback f52897a;

    public C11270d(ServerControlResultCallback serverControlResultCallback) {
        this.f52897a = serverControlResultCallback;
    }

    /* renamed from: k */
    public static void m67633k() {
        boolean z10;
        InterfaceC9286e interfaceC9286e;
        C11839m.m70688i("ServerControlResetTask", "startQuickAccess start");
        try {
            interfaceC9286e = (InterfaceC9286e) C1270a.m7534b().m7535a(InterfaceC9286e.class);
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "startQuickAccess occurred exception: " + e10.toString());
            z10 = false;
        }
        if (interfaceC9286e == null) {
            C11839m.m70688i("ServerControlResetTask", "startQuickAccess fileManagerRouter is null");
            return;
        }
        interfaceC9286e.m58537b();
        z10 = true;
        C11839m.m70688i("ServerControlResetTask", "startQuickAccess isSuccess: " + z10);
    }

    /* renamed from: c */
    public final void m67634c() {
        C11839m.m70688i("ServerControlResetTask", "pauseQuickAccess start");
        try {
            InterfaceC9286e interfaceC9286e = (InterfaceC9286e) C1270a.m7534b().m7535a(InterfaceC9286e.class);
            if (interfaceC9286e == null) {
                C11839m.m70688i("ServerControlResetTask", "pauseQuickAccess fileManagerRouter is null");
            } else {
                interfaceC9286e.m58536a();
            }
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "pauseQuickAccess occurred exception: " + e10.toString());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        int i10;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07013"), CloudBackupConstant.RestoreDataDictionaryType.BASIC, C13452e.m80781L().m80971t0());
        HashMap map = new HashMap();
        try {
            if (C1007b.m5980s().m5983C()) {
                C11839m.m70688i("ServerControlResetTask", "hasManulBackupOrRestore task executing");
                this.f52897a.mo17194a("hasManulBackupOrRestore task executing");
                return;
            }
            C11839m.m70687e("ServerControlResetTask", "ServerControlResetTask start");
            String strM70478c = C11827a.m70478c();
            c11060cM66626a.m66667w(strM70478c);
            c11060cM66626a.m66639E(InetAddress.getByName(strM70478c).getHostAddress());
            C11268b.m67619i().m67630p(1);
            c11060cM66626a.m66665u("120_0");
            map.put("result", "resetStatus not finish, code 1");
            C13622a.m81971q(c11060cM66626a, map, false, true);
            String str = "client init data success";
            if (m67640j("server_control_cloud_clear_data") && m67635d() && m67637f() && m67636e() && m67638g() && m67639h()) {
                C11268b.m67619i().m67630p(0);
                map.put("result", "resetStatus finish, code 0");
                C13622a.m81971q(c11060cM66626a, map, false, true);
                this.f52897a.mo17195b();
                i10 = 0;
            } else {
                this.f52897a.mo17194a("");
                str = "client init data fail";
                c11060cM66626a.m66635A("client init data fail");
                i10 = 3401;
            }
            c11060cM66626a.m66665u("120_" + i10);
            map.put("result", str);
            C13622a.m81971q(c11060cM66626a, map, false, true);
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "ServerControlResetTask exception: " + e10.toString());
            c11060cM66626a.m66665u("120_3401");
            String str2 = "client init data fail, " + e10.getMessage();
            c11060cM66626a.m66635A(str2);
            map.put("result", str2);
            C13622a.m81971q(c11060cM66626a, map, false, true);
            this.f52897a.mo17194a(e10.getMessage());
        }
    }

    /* renamed from: d */
    public final boolean m67635d() {
        InterfaceC9282a interfaceC9282a;
        C11839m.m70688i("ServerControlResetTask", "resetAlbumData start");
        if (C0209d.m1293p1()) {
            C11839m.m70688i("ServerControlResetTask", "resetAlbumData isInkScreen");
            return true;
        }
        boolean zMo58404Y = false;
        try {
            interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "resetAlbumData occurred exception: " + e10.toString());
        }
        if (interfaceC9282a == null) {
            C11839m.m70688i("ServerControlResetTask", "resetAlbumData cloudAlbumRouterImpl is null");
            return false;
        }
        zMo58404Y = interfaceC9282a.mo58404Y(C0213f.m1377a());
        C11839m.m70688i("ServerControlResetTask", "resetAlbumData isSuccess:" + zMo58404Y);
        return zMo58404Y;
    }

    /* renamed from: e */
    public final boolean m67636e() {
        C11839m.m70688i("ServerControlResetTask", "resetCloudBackupData start");
        C1007b.m5980s().m5998R(C0213f.m1377a());
        C11839m.m70688i("ServerControlResetTask", "resetCloudBackupData end");
        return true;
    }

    /* renamed from: f */
    public final boolean m67637f() {
        C11839m.m70688i("ServerControlResetTask", "resetCommonData start");
        HiCloudNotification.getInstance().clearCloudConfigFile();
        SpaceInsuffNoticeV4Manager.getInstance().clearAllConfigInTask();
        BackupSpaceInsuffNoticeV5Manager.getInstance().clearAllConfigInTask();
        return true;
    }

    /* renamed from: g */
    public final boolean m67638g() {
        return true;
    }

    /* renamed from: h */
    public final boolean m67639h() {
        boolean zM67617a;
        try {
            C11839m.m70688i("ServerControlResetTask", "resetMoreBackupData start");
            zM67617a = C11267a.m67617a();
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "resetMoreBackupData occurred exception: " + e10.toString());
            zM67617a = false;
        }
        C11839m.m70688i("ServerControlResetTask", "resetMoreBackupData isSuccess:" + zM67617a);
        return zM67617a;
    }

    /* renamed from: j */
    public final boolean m67640j(String str) {
        boolean zM6057V;
        m67634c();
        C11839m.m70688i("ServerControlResetTask", "resetSyncData start");
        try {
            zM6057V = C1008c.m6035v().m6057V(str);
        } catch (Exception e10) {
            C11839m.m70687e("ServerControlResetTask", "resetSyncData occurred exception: " + e10.toString());
            zM6057V = false;
        }
        C11839m.m70688i("ServerControlResetTask", "resetSyncData status: " + zM6057V);
        return zM6057V;
    }
}
