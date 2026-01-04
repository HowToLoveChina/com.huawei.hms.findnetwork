package p814yl;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AnalysisReport;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSizeInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSizeInfoList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSwitchStatusInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSwitchStatusInfoList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppsSwitchPost;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefreshRequestNoLock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.GeneralPost;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ScanLost;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Remove;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.View;
import fk.C9721b;
import hm.C10321z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import p292fn.C9733f;
import p429kk.C11058a;
import p495nm.C11732m;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p626ry.C12652a;
import p626ry.C12653b;
import p709vj.C13452e;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;

/* renamed from: yl.b0 */
/* loaded from: classes6.dex */
public class C13998b0 {

    /* renamed from: yl.b0$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f62709a;

        public a(List list) {
            this.f62709a = list;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                HashMap<String, String> map = new HashMap<>();
                C11839m.m70686d("CloudBackupV3Client", "asyncDownloadDeviceIcon start.");
                for (Device device : this.f62709a) {
                    if (!C12652a.m76180b(device)) {
                        String deviceIconUrl = device.getDeviceIconUrl();
                        String terminalType = device.getTerminalType();
                        if (!DeviceIconManager.getInstance().isCacheVaild(terminalType) && !C12653b.m76182b(terminalType) && !C12653b.m76182b(deviceIconUrl)) {
                            map.put(terminalType, deviceIconUrl);
                        }
                    }
                }
                if (C12652a.m76180b(map)) {
                    return;
                }
                DeviceIconManager.getInstance().downloadDeviceIcon(map);
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupV3Client", "asyncDownloadRemoveIcon error: " + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DEVICE_ICON_DOWNLOAD;
        }
    }

    /* renamed from: yl.b0$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f62711a;

        public b(List list) {
            this.f62711a = list;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                HashMap<String, String> map = new HashMap<>();
                C11839m.m70686d("CloudBackupV3Client", "asyncDownloadDeviceIcon start.");
                for (Remove.Device4Del device4Del : this.f62711a) {
                    if (!C12652a.m76180b(device4Del)) {
                        String deviceIconUrl = device4Del.getDeviceIconUrl();
                        String terminalType = device4Del.getTerminalType();
                        if (!DeviceIconManager.getInstance().isCacheVaild(terminalType) && !C12653b.m76182b(terminalType) && !C12653b.m76182b(deviceIconUrl)) {
                            map.put(terminalType, deviceIconUrl);
                        }
                    }
                }
                if (C12652a.m76180b(map)) {
                    return;
                }
                DeviceIconManager.getInstance().downloadDeviceIcon(map);
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupV3Client", "asyncDownloadRemoveIcon error: " + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DEVICE_ICON_DOWNLOAD;
        }
    }

    /* renamed from: A0 */
    public static /* synthetic */ CloudBackupV3Request m84043A0(CloudBackupV3Server cloudBackupV3Server) throws IOException {
        return cloudBackupV3Server.remove().deleteSwitch().get();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
    /* renamed from: B0 */
    public static /* synthetic */ CloudBackupV3Request m84044B0(String str, boolean z10, int i10, int i11, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.List list = cloudBackupV3Server.remove().device().list();
        list.setFields(str).setPageSize(10).setBackGround(Boolean.valueOf(z10)).setClearTime(Integer.valueOf(i10)).setClearRange(Integer.valueOf(i11));
        if (str2 != null && !str2.isEmpty()) {
            list.setCursor(str2);
        }
        return list;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
    /* renamed from: C0 */
    public static /* synthetic */ CloudBackupV3Request m84045C0(String str, boolean z10, int i10, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.List list = cloudBackupV3Server.remove().device().list();
        list.setFields(str).setPageSize(10).setBackGround(Boolean.valueOf(z10)).setClearTime(Integer.valueOf(i10));
        if (str2 != null && !str2.isEmpty()) {
            list.setCursor(str2);
        }
        return list;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
    /* renamed from: D0 */
    public static /* synthetic */ CloudBackupV3Request m84046D0(String str, boolean z10, String str2, int i10, int i11, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.List list = cloudBackupV3Server.remove().device().list();
        list.setFields(str).setPageSize(10).setBackGround(Boolean.valueOf(z10)).setType(str2).setClearTime(Integer.valueOf(i10)).setClearRange(Integer.valueOf(i11));
        if (str3 != null && !str3.isEmpty()) {
            list.setCursor(str3);
        }
        return list;
    }

    /* renamed from: E0 */
    public static /* synthetic */ CloudBackupV3Request m84047E0(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        return cloudBackupV3Server.abnormal().data().scanLost(new ScanLost().setType(str).setTargetDeviceId(str2));
    }

    /* renamed from: F0 */
    public static /* synthetic */ CloudBackupV3Request m84048F0(Remove.RefreshSwitch refreshSwitch, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        return cloudBackupV3Server.remove().deleteSwitch().update(refreshSwitch);
    }

    /* renamed from: T */
    public static boolean m84049T(String str) {
        return (TextUtils.isEmpty(str) || "empty_default_id".equals(str)) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.About$Get] */
    /* renamed from: h0 */
    public static /* synthetic */ CloudBackupV3Request m84058h0(String str, Integer num, String str2, boolean z10, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        About.Get get = cloudBackupV3Server.about().get();
        get.setFields(str).setChannel(num).setBackupAction(str2);
        if (z10) {
            get.setForce2V3(Boolean.TRUE);
        }
        return get;
    }

    /* renamed from: i0 */
    public static /* synthetic */ CloudBackupV3Request m84060i0(String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        return cloudBackupV3Server.view().device().app().preAnalysis().post(str, new GeneralPost().setCreateTime(new C4644l(System.currentTimeMillis())));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$App$PreAnalysis$Get] */
    /* renamed from: j0 */
    public static /* synthetic */ CloudBackupV3Request m84062j0(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.App.PreAnalysis.Get get = cloudBackupV3Server.view().device().app().preAnalysis().get(str);
        get.setFields(str2).setPageSize(100);
        if (str3 != null && !str3.isEmpty()) {
            get.setCursor(str3);
        }
        return get;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Bak$Apps$List] */
    /* renamed from: k0 */
    public static /* synthetic */ CloudBackupV3Request m84064k0(String str, String str2, String str3, String str4, String str5, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Bak.Apps.List list = cloudBackupV3Server.view().device().bak().apps().list(str, str2);
        list.setFields(str3).setPageSize(100).setUsage(str4).setHeader("x-hw-masking-apps-version", "V1").setHeader("x-hw-appduplicator", "1");
        if (str5 != null && !str5.isEmpty()) {
            list.setCursor(str5);
        }
        return list;
    }

    /* renamed from: l0 */
    public static /* synthetic */ CloudBackupV3Request m84066l0(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.App.Transfer transfer = cloudBackupV3Server.view().device().app().transfer(str, new GeneralPost().setCreateTime(new C4644l(System.currentTimeMillis())));
        if (str2 != null && !str2.isEmpty()) {
            transfer.setAppNameList(str2);
        }
        return transfer;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$List] */
    /* renamed from: m0 */
    public static /* synthetic */ CloudBackupV3Request m84068m0(String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Apps.List list = cloudBackupV3Server.view().device().apps().list(str);
        list.setFields(str2).setPageSize(10).setAppNameList(str3).setHeader("x-hw-compose-apps", Boolean.TRUE).setHeader("x-hw-masking-apps-version", "V1").setHeader("x-hw-appduplicator", "1");
        if (str4 != null && !str4.isEmpty()) {
            list.setCursor(str4);
        }
        return list;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$List] */
    /* renamed from: n0 */
    public static /* synthetic */ CloudBackupV3Request m84070n0(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Apps.List list = cloudBackupV3Server.view().device().apps().list(str);
        list.setFields(str2).setPageSize(100).setHeader("x-hw-compose-apps", Boolean.TRUE).setHeader("x-hw-masking-apps-version", "V1").setHeader("x-hw-appduplicator", "1");
        if (str3 != null && !str3.isEmpty()) {
            list.setCursor(str3);
        }
        return list;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Bak$Refresh] */
    /* renamed from: o0 */
    public static /* synthetic */ CloudBackupV3Request m84072o0(BakRefreshRequestNoLock bakRefreshRequestNoLock, String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Bak.Refresh refresh = cloudBackupV3Server.view().device().bak().refresh(bakRefreshRequestNoLock);
        refresh.setFields(str).setBakId(str2).setBackupDeviceId(str3);
        return refresh;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Bak$Single] */
    /* renamed from: p0 */
    public static /* synthetic */ CloudBackupV3Request m84074p0(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Bak.Single single = cloudBackupV3Server.view().device().bak().single();
        single.setFields(str).setBakId(str2).setBackupDeviceId(str3);
        return single;
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$Delete] */
    /* renamed from: q0 */
    public static /* synthetic */ CloudBackupV3Request m84076q0(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Apps.SwitchStatus.Delete delete = cloudBackupV3Server.view().device().apps().switchStatus().delete(str);
        delete.setTargetDeviceId(C11476b.m68626h(C13452e.m80781L().m80950o())).setHeader("x-hw-compose-apps", (Object) Boolean.TRUE).setAppNameList(str2);
        return delete;
    }

    /* renamed from: r0 */
    public static /* synthetic */ CloudBackupV3Request m84078r0(String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.Delete delete = cloudBackupV3Server.remove().device().delete();
        delete.setBackupDeviceId(str);
        return delete;
    }

    /* renamed from: s0 */
    public static /* synthetic */ CloudBackupV3Request m84080s0(String str, int i10, int i11, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.Delete delete = cloudBackupV3Server.remove().device().delete();
        delete.setBackupDeviceId(str).setClearRange(Integer.valueOf(i10)).setSendPush(Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str2)) {
            delete.setBakCategories(str2);
        }
        return delete;
    }

    /* renamed from: t0 */
    public static /* synthetic */ CloudBackupV3Request m84082t0(String str, int i10, int i11, int i12, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.Delete delete = cloudBackupV3Server.remove().device().delete();
        delete.setBackupDeviceId(str).setClearTime(Integer.valueOf(i10)).setClearRange(Integer.valueOf(i11)).setSendPush(Integer.valueOf(i12));
        return delete;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Apps$Delete] */
    /* renamed from: u0 */
    public static /* synthetic */ CloudBackupV3Request m84084u0(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.Apps.Delete delete = cloudBackupV3Server.remove().device().apps().delete();
        delete.setBackupDeviceId(str).setHeader("x-hw-compose-apps", (Object) Boolean.TRUE).setHeader("x-hw-appduplicator", (Object) "1").setAppNameList(str2);
        return delete;
    }

    /* renamed from: v0 */
    public static /* synthetic */ CloudBackupV3Request m84086v0(String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.BaseApps.Delete delete = cloudBackupV3Server.remove().device().baseApps().delete();
        delete.setBackupDeviceId(str);
        return delete;
    }

    /* renamed from: w0 */
    public static /* synthetic */ CloudBackupV3Request m84088w0(String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Remove.Device.Bak.Delete deleteDeleteSingle = cloudBackupV3Server.remove().device().bak().deleteSingle();
        deleteDeleteSingle.setBackupDeviceId(str).setBakId(str2).setBakVersion(str3).setOpSceneParam(new C11732m("10", "from client," + str4));
        return deleteDeleteSingle;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Baks] */
    /* renamed from: x0 */
    public static /* synthetic */ CloudBackupV3Request m84090x0(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String str2, boolean z15, int i10, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Baks baks = cloudBackupV3Server.view().device().baks();
        baks.setFields(str).setPageSize(10).setHeader("x-hw-contain-refurbishment", Boolean.valueOf(z10)).setHeader("x-hw-query-totalSize", Boolean.valueOf(z11)).setHeader("x-hw-query-deviceSize", Boolean.valueOf(z12)).setHeader("x-hw-contain-interim", Boolean.valueOf(z13));
        if (z14) {
            if (C9733f.m60705z().m60720O("backupContainOhInterimRecords")) {
                baks.setHeader("x-hw-contain-oh", 3);
            } else {
                baks.setHeader("x-hw-contain-oh", 1);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            baks.setHeader(CloudBackupConstant.BACKUP_DEVICE_ID, str2);
        }
        if (z15) {
            baks.setHeader("x-hw-clear-range", 1);
        }
        if (i10 == 1) {
            baks.setQueryType(Integer.valueOf(i10));
        }
        if (str3 != null && !str3.isEmpty()) {
            baks.setCursor(str3);
        }
        return baks;
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$List] */
    /* renamed from: y0 */
    public static /* synthetic */ CloudBackupV3Request m84092y0(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Apps.SwitchStatus.List list = cloudBackupV3Server.view().device().apps().switchStatus().list(str);
        list.setTargetDeviceId(C11476b.m68626h(C13452e.m80781L().m80950o()));
        list.setFields("appSwitchStatusInfos(backupAppName,createTime,switchStatus,updateTime),nextCursor").setPageSize(100).setHeader("x-hw-appduplicator", (Object) "1");
        if (str2 != null && !str2.isEmpty()) {
            list.setCursor(str2);
        }
        return list;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$Post] */
    /* renamed from: z0 */
    public static /* synthetic */ CloudBackupV3Request m84093z0(Map map, String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        View.Device.Apps.SwitchStatus.Post post = cloudBackupV3Server.view().device().apps().switchStatus().post(str, new AppsSwitchPost().setDeviceSwitch(map));
        post.setHeader("x-hw-compose-apps", (Object) Boolean.TRUE).setAppNameList(str2);
        return post;
    }

    /* renamed from: A */
    public com.huawei.hicloud.cloudbackup.p104v3.server.model.About m84094A(String str, String str2, String str3) throws C9721b {
        return m84095B(str, false, str2, str3, null);
    }

    /* renamed from: B */
    public com.huawei.hicloud.cloudbackup.p104v3.server.model.About m84095B(final String str, final boolean z10, String str2, final String str3, final Integer num) throws C9721b {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.About about = (com.huawei.hicloud.cloudbackup.p104v3.server.model.About) new C14000c0(new C14000c0.a() { // from class: yl.l
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84058h0(str, num, str3, z10, cloudBackupV3Server);
            }
        }).m84139b("About", str2);
        if (about != null) {
            return about;
        }
        throw new C9721b(3911, "about response is null.");
    }

    /* renamed from: C */
    public void m84096C(final String str, String str2) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.i
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84060i0(str, cloudBackupV3Server);
            }
        }).m84139b("View.device.app.preanalysis.post", str2);
    }

    /* renamed from: D */
    public AnalysisReport m84097D(String str, String str2) throws C9721b {
        AnalysisReport analysisReportM84098E = m84098E(null, str, str2);
        if (analysisReportM84098E.isFinishAnalysis()) {
            String nextCursor = analysisReportM84098E.getNextCursor();
            while (nextCursor != null && !nextCursor.isEmpty()) {
                AnalysisReport analysisReportM84098E2 = m84098E(nextCursor, str, str2);
                analysisReportM84098E.getApps().addAll(analysisReportM84098E2.getApps());
                analysisReportM84098E.setAppSize(analysisReportM84098E2.getAppSize());
                analysisReportM84098E.setDelSpaceSize(analysisReportM84098E2.getDelSpaceSize());
                nextCursor = analysisReportM84098E2.getNextCursor();
            }
        }
        return analysisReportM84098E;
    }

    /* renamed from: E */
    public final AnalysisReport m84098E(final String str, final String str2, String str3) throws C9721b {
        final String str4 = "appSize,delSpaceSize,nextCursor,isFinishAnalysis,apps(backupAppName,backupAppStatus,attachments(assetId,versionId),properties)";
        return (AnalysisReport) new C14000c0(new C14000c0.a() { // from class: yl.x
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84062j0(str2, str4, str, cloudBackupV3Server);
            }
        }).m84139b("View.device.app.preanalysis.get", str3);
    }

    /* renamed from: F */
    public final AppList m84099F(final String str, final String str2, final String str3, final String str4, String str5, final String str6) throws C9721b {
        return (AppList) new C14000c0(new C14000c0.a() { // from class: yl.c
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84064k0(str3, str4, str, str6, str2, cloudBackupV3Server);
            }
        }).m84139b("View.device.bak.apps.list", str5);
    }

    /* renamed from: G */
    public List<App> m84100G(String str, String str2, String str3, String str4, String str5) throws C9721b {
        AppList appListM84099F = m84099F(str, null, str2, str3, str4, str5);
        ArrayList arrayList = new ArrayList(appListM84099F.getApps());
        String nextCursor = appListM84099F.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            AppList appListM84099F2 = m84099F(str, nextCursor, str2, str3, str4, str5);
            arrayList.addAll(appListM84099F2.getApps());
            nextCursor = appListM84099F2.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: G0 */
    public final AppSwitchStatusInfoList m84101G0(final String str, final String str2, String str3) throws C9721b {
        return (AppSwitchStatusInfoList) new C14000c0(new C14000c0.a() { // from class: yl.m
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84092y0(str2, str, cloudBackupV3Server);
            }
        }).m84139b("view.device.apps.switchStatus.list", str3);
    }

    /* renamed from: H */
    public final void m84102H(final String str, final String str2, String str3) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.d
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84066l0(str, str2, cloudBackupV3Server);
            }
        }).m84139b("view.device.app.transfer", str3);
    }

    /* renamed from: H0 */
    public List<AppSwitchStatusInfo> m84103H0(String str, String str2) throws C9721b {
        AppSwitchStatusInfoList appSwitchStatusInfoListM84101G0 = m84101G0(null, str, str2);
        ArrayList arrayList = new ArrayList(appSwitchStatusInfoListM84101G0.getAppSwitchStatusInfos());
        String nextCursor = appSwitchStatusInfoListM84101G0.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            AppSwitchStatusInfoList appSwitchStatusInfoListM84101G02 = m84101G0(nextCursor, str, str2);
            arrayList.addAll(appSwitchStatusInfoListM84101G02.getAppSwitchStatusInfos());
            nextCursor = appSwitchStatusInfoListM84101G02.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: I */
    public void m84104I(String str, List<String> list, String str2) throws C9721b {
        if (list == null || list.isEmpty()) {
            m84102H(str, "", str2);
            return;
        }
        int size = list.size();
        int iMin = 0;
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                return;
            }
            iMin = Math.min(iMin + 10, size);
            m84102H(str, list.subList(i10, iMin).toString().replace("[", "").replace("]", ""), str2);
        }
    }

    /* renamed from: I0 */
    public void m84105I0(final String str, final Map<String, Object> map, List<String> list, String str2) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int iMin = 0;
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                return;
            }
            iMin = Math.min(iMin + 10, size);
            final String strM84136g0 = m84136g0(list.subList(i10, iMin));
            new C14000c0(new C14000c0.a() { // from class: yl.e
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return C13998b0.m84093z0(map, str, strM84136g0, cloudBackupV3Server);
                }
            }).m84139b("view.device.apps.switchStatus.post", str2);
        }
    }

    /* renamed from: J */
    public final AppSizeInfoList m84106J(final String str, final String str2, String str3, final String str4) throws C9721b {
        return (AppSizeInfoList) new C14000c0(new C14000c0.a() { // from class: yl.w
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84070n0(str2, str4, str, cloudBackupV3Server);
            }
        }).m84139b("view.device.apps.list", str3);
    }

    /* renamed from: J0 */
    public int m84107J0(String str) throws C9721b {
        return m84111L0(str).getStatus().intValue();
    }

    /* renamed from: K */
    public final AppSizeInfoList m84108K(final String str, final String str2, String str3, final String str4, final String str5) throws C9721b {
        List<ErrorResp.ErrorMsg> errorDetail;
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: yl.j
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84068m0(str2, str4, str5, str, cloudBackupV3Server);
            }
        });
        try {
            return (AppSizeInfoList) c14000c0.m84139b("view.device.apps.list", str3);
        } catch (C9721b e10) {
            ErrorResp.Error errorM84140c = c14000c0.m84140c();
            if (errorM84140c != null && (errorDetail = errorM84140c.getErrorDetail()) != null && !errorDetail.isEmpty()) {
                String errorCode = errorDetail.get(0).getErrorCode();
                if (errorM84140c.getCode().intValue() == 500 && errorCode.endsWith(String.valueOf(5009))) {
                    throw new C9721b(3911, 5009, "Quota statistics has no data");
                }
            }
            throw e10;
        }
    }

    /* renamed from: K0 */
    public Long m84109K0() {
        try {
            return m84137z("lastBackupEndTime", C11058a.m66627b("02016")).getLastBackupEndTime();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3Client", "queryLastBackupEndTime error: " + e10);
            return null;
        }
    }

    /* renamed from: L */
    public List<AppSizeInfo> m84110L(String str, String str2) throws C9721b {
        AppSizeInfoList appSizeInfoListM84106J = m84106J(null, str, str2, "nextCursor,appSizeInfo(id,backupAppName,isExistSplit,apkType,properties,attachments,splitApkType,oriBackupAppName)");
        List<AppSizeInfo> appSizeInfo = appSizeInfoListM84106J.getAppSizeInfo();
        ArrayList arrayList = new ArrayList();
        if (appSizeInfo != null) {
            arrayList.addAll(appSizeInfo);
        }
        String nextCursor = appSizeInfoListM84106J.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            AppSizeInfoList appSizeInfoListM84106J2 = m84106J(nextCursor, str, str2, "nextCursor,appSizeInfo(id,backupAppName,isExistSplit,apkType,properties,attachments,splitApkType,oriBackupAppName)");
            List<AppSizeInfo> appSizeInfo2 = appSizeInfoListM84106J2.getAppSizeInfo();
            if (appSizeInfo2 != null) {
                arrayList.addAll(appSizeInfo2);
            }
            nextCursor = appSizeInfoListM84106J2.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: L0 */
    public Remove.QuerySwitch m84111L0(String str) throws C9721b {
        return (Remove.QuerySwitch) new C14000c0(new C14000c0.a() { // from class: yl.o
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84043A0(cloudBackupV3Server);
            }
        }).m84139b("Remove.delete.switch.get", str);
    }

    /* renamed from: M */
    public boolean m84112M(List<String> list, String str, String str2) throws C9721b {
        AppSizeInfoList appSizeInfoListM84108K = m84108K(null, str, str2, "nextCursor,appSizeInfo(backupAppName)", m84136g0(list));
        return (appSizeInfoListM84108K.getAppSizeInfo() == null || appSizeInfoListM84108K.isEmpty()) ? false : true;
    }

    /* renamed from: M0 */
    public final com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove m84113M0(final String str, final String str2, final boolean z10, String str3, final int i10) throws C9721b {
        return (com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove) new C14000c0(new C14000c0.a() { // from class: yl.z
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84045C0(str, z10, i10, str2, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.list", str3);
    }

    /* renamed from: N */
    public List<AppSizeInfo> m84114N(String str, String str2, List<String> list) throws C9721b {
        List<AppSizeInfo> appSizeInfo = m84108K(null, str, str2, "nextCursor,appSizeInfo(backupAppName,id,backupId,attachments(usage,assetId,versionId))", m84136g0(list)).getAppSizeInfo();
        return appSizeInfo != null ? new ArrayList(appSizeInfo) : new ArrayList();
    }

    /* renamed from: N0 */
    public final com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove m84115N0(final String str, final String str2, final boolean z10, String str3, final int i10, final int i11) throws C9721b {
        return (com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove) new C14000c0(new C14000c0.a() { // from class: yl.p
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84044B0(str, z10, i10, i11, str2, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.list", str3);
    }

    /* renamed from: O */
    public List<AppSizeInfo> m84116O(List<String> list, String str, String str2) throws C9721b {
        List<AppSizeInfo> appSizeInfo = m84108K(null, str, str2, "nextCursor,appSizeInfo(backupAppName,totalSize,appSize)", m84136g0(list)).getAppSizeInfo();
        return appSizeInfo != null ? new ArrayList(appSizeInfo) : new ArrayList();
    }

    /* renamed from: O0 */
    public final com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove m84117O0(final String str, final String str2, final boolean z10, String str3, final int i10, final int i11, final String str4) throws C9721b {
        return (com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove) new C14000c0(new C14000c0.a() { // from class: yl.v
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84046D0(str, z10, str4, i10, i11, str2, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.list", str3);
    }

    /* renamed from: P */
    public final void m84118P(List<Device> list) {
        C12515a.m75110o().m75172d(new a(list));
    }

    /* renamed from: P0 */
    public void m84119P0(String str, final String str2, final String str3) {
        try {
            new C14000c0(new C14000c0.a() { // from class: yl.t
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return C13998b0.m84047E0(str3, str2, cloudBackupV3Server);
                }
            }).m84139b("Abnormal.data.scanLost", str);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupV3Client", "abnormal report error." + e10);
        }
    }

    /* renamed from: Q */
    public final void m84120Q(List<Remove.Device4Del> list) {
        C12515a.m75110o().m75172d(new b(list));
    }

    /* renamed from: Q0 */
    public void m84121Q0(int i10, int i11, String str) throws C9721b {
        final Remove.RefreshSwitch refreshSwitch = new Remove.RefreshSwitch();
        refreshSwitch.setStatus(Integer.valueOf(i10)).setClearTime(Integer.valueOf(i11));
        new C14000c0(new C14000c0.a() { // from class: yl.u
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84048F0(refreshSwitch, cloudBackupV3Server);
            }
        }).m84139b("Remove.delete.switch.update", str);
    }

    /* renamed from: R */
    public Bak m84122R(final String str, final String str2, String str3, final BakRefreshRequestNoLock bakRefreshRequestNoLock) throws C9721b {
        final String str4 = "id,bakCategory,backupStatus,occupySpaceType";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: yl.k
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84072o0(bakRefreshRequestNoLock, str4, str2, str, cloudBackupV3Server);
            }
        });
        try {
            return (Bak) c14000c0.m84139b("view.device.bak.refresh", str3);
        } catch (C9721b e10) {
            throw C10321z.m63503E0(c14000c0.m84140c(), e10);
        }
    }

    /* renamed from: S */
    public Bak m84123S(final String str, final String str2, String str3, final String str4) throws C9721b {
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: yl.q
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84074p0(str4, str2, str, cloudBackupV3Server);
            }
        });
        try {
            return (Bak) c14000c0.m84139b("view.device.bak.single", str3);
        } catch (C9721b e10) {
            throw C10321z.m63503E0(c14000c0.m84140c(), e10);
        }
    }

    /* renamed from: U */
    public void m84124U(final String str, List<String> list, String str2) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int iMin = 0;
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                return;
            }
            iMin = Math.min(iMin + 10, size);
            final String strM84136g0 = m84136g0(list.subList(i10, iMin));
            new C14000c0(new C14000c0.a() { // from class: yl.g
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return C13998b0.m84076q0(str, strM84136g0, cloudBackupV3Server);
                }
            }).m84139b("view.device.apps.switchStatus.delete", str2);
        }
    }

    /* renamed from: V */
    public void m84125V(final String str, String str2) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.s
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84078r0(str, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.delete", str2);
    }

    /* renamed from: W */
    public void m84126W(final String str, String str2, final int i10, final int i11, final int i12) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.r
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84082t0(str, i10, i11, i12, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.delete", str2);
    }

    /* renamed from: X */
    public void m84127X(final String str, String str2, final int i10, final int i11, final String str3) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.h
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84080s0(str, i10, i11, str3, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.delete", str2);
    }

    /* renamed from: Y */
    public void m84128Y(final String str, List<String> list, String str2) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int iMin = 0;
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                return;
            }
            iMin = Math.min(iMin + 10, size);
            final String strM84136g0 = m84136g0(list.subList(i10, iMin));
            new C14000c0(new C14000c0.a() { // from class: yl.n
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return C13998b0.m84084u0(str, strM84136g0, cloudBackupV3Server);
                }
            }).m84139b("remove.device.apps.delete", str2);
        }
    }

    /* renamed from: Z */
    public void m84129Z(final String str, String str2) throws C9721b {
        new C14000c0(new C14000c0.a() { // from class: yl.f
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84086v0(str, cloudBackupV3Server);
            }
        }).m84139b("Remove.device.baseApps.delete", str2);
    }

    /* renamed from: a0 */
    public void m84130a0(final String str, final String str2, final String str3, String str4, final String str5) throws C9721b {
        C14000c0.a aVar = new C14000c0.a() { // from class: yl.a0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84088w0(str, str2, str3, str5, cloudBackupV3Server);
            }
        };
        String str6 = "";
        C14000c0 c14000c0 = new C14000c0(aVar);
        try {
            try {
                if (m84049T(str2)) {
                    c14000c0.m84139b("Remove.device.bak.delete", str4);
                } else {
                    str6 = "" + str2;
                }
                CloudBackupReport.reportDeleteSingle(str4, str2, str3, str5, true, str6);
            } catch (C9721b e10) {
                e10.getMessage();
                throw e10;
            }
        } catch (Throwable th2) {
            CloudBackupReport.reportDeleteSingle(str4, str2, str3, str5, false, "");
            throw th2;
        }
    }

    /* renamed from: b0 */
    public final DeviceList m84131b0(final String str, final String str2, String str3, final boolean z10, final boolean z11, final boolean z12, final boolean z13, final String str4, final int i10, final boolean z14, final boolean z15) throws C9721b {
        return (DeviceList) new C14000c0(new C14000c0.a() { // from class: yl.y
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C13998b0.m84090x0(str, z10, z14, z15, z11, z12, str4, z13, i10, str2, cloudBackupV3Server);
            }
        }).m84139b("View.devices.baks.list", str3);
    }

    /* renamed from: c0 */
    public List<Device> m84132c0(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, String str3, boolean z14, boolean z15) throws C9721b {
        int i10 = !C9733f.m60705z().m60720O("disableBackupDeviceListRealTimeQuery") ? 1 : 0;
        DeviceList deviceListM84131b0 = m84131b0(str, null, str2, z10, z11, z12, z13, str3, i10, z14, z15);
        if (deviceListM84131b0.getDevices() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(deviceListM84131b0.getDevices());
        String nextCursor = deviceListM84131b0.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            DeviceList deviceListM84131b02 = m84131b0(str, nextCursor, str2, z10, z11, z12, z13, str3, i10, z14, z15);
            arrayList.addAll(deviceListM84131b02.getDevices());
            nextCursor = deviceListM84131b02.getNextCursor();
        }
        m84118P(arrayList);
        return arrayList;
    }

    /* renamed from: d0 */
    public Pair<List<Remove.Device4Del>, Long> m84133d0(String str, boolean z10, String str2, int i10, String str3) throws C9721b {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84117O0 = m84117O0(str, null, z10, str2, 6, i10, str3);
        long deleteTime = removeM84117O0.getDeleteTime();
        C11839m.m70688i("CloudBackupV3Client", "deleteTime: " + deleteTime);
        ArrayList arrayList = new ArrayList();
        if (!AbstractC14026a.m84159a(removeM84117O0.getDevice4Dels())) {
            arrayList = new ArrayList(removeM84117O0.getDevice4Dels());
        }
        String nextCursor = removeM84117O0.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84117O02 = m84117O0(str, nextCursor, z10, str2, 6, i10, str3);
            arrayList.addAll(removeM84117O02.getDevice4Dels());
            nextCursor = removeM84117O02.getNextCursor();
        }
        m84120Q(arrayList);
        return new Pair<>(arrayList, Long.valueOf(deleteTime));
    }

    /* renamed from: e0 */
    public List<Remove.Device4Del> m84134e0(String str, boolean z10, String str2, int i10) throws C9721b {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84113M0 = m84113M0(str, null, z10, str2, i10);
        if (removeM84113M0.getDevice4Dels() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(removeM84113M0.getDevice4Dels());
        String nextCursor = removeM84113M0.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84113M02 = m84113M0(str, nextCursor, z10, str2, i10);
            arrayList.addAll(removeM84113M02.getDevice4Dels());
            nextCursor = removeM84113M02.getNextCursor();
        }
        m84120Q(arrayList);
        return arrayList;
    }

    /* renamed from: f0 */
    public List<Remove.Device4Del> m84135f0(String str, boolean z10, String str2, int i10, int i11) throws C9721b {
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84115N0 = m84115N0(str, null, z10, str2, i10, i11);
        ArrayList arrayList = new ArrayList();
        if (!AbstractC14026a.m84159a(removeM84115N0.getDevice4Dels())) {
            arrayList = new ArrayList(removeM84115N0.getDevice4Dels());
        }
        String nextCursor = removeM84115N0.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove removeM84115N02 = m84115N0(str, nextCursor, z10, str2, i10, i11);
            arrayList.addAll(removeM84115N02.getDevice4Dels());
            nextCursor = removeM84115N02.getNextCursor();
        }
        m84120Q(arrayList);
        return arrayList;
    }

    /* renamed from: g0 */
    public final String m84136g0(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 == 0) {
                stringBuffer.append(list.get(i10));
            } else {
                stringBuffer.append(";");
                stringBuffer.append(list.get(i10));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: z */
    public com.huawei.hicloud.cloudbackup.p104v3.server.model.About m84137z(String str, String str2) throws C9721b {
        return m84095B(str, false, str2, "", null);
    }
}
