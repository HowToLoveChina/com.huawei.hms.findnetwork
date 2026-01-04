package p362i9;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p010a9.C0080b;
import p015ak.C0227m;
import p020ap.C1006a;
import p020ap.C1008c;
import p051c9.C1396a;
import p336he.C10155f;
import p459lp.InterfaceC11331i;
import p494nk.C11718b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p684un.C13225d;
import p709vj.C13452e;
import p746wn.C13622a;
import p847zk.C14315h;
import p847zk.C14317j;
import tl.C13026e;
import vn.C13471c;

/* renamed from: i9.i */
/* loaded from: classes3.dex */
public class C10462i extends AbstractC12367d {

    /* renamed from: a */
    public final String f50430a;

    /* renamed from: b */
    public final Context f50431b;

    /* renamed from: c */
    public String f50432c;

    /* renamed from: d */
    public ArrayList<String> f50433d = new ArrayList<>();

    /* renamed from: e */
    public Handler f50434e;

    /* renamed from: i9.i$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("SwitchRestoreTask", "handleLocalDataCheckMsg");
            int i10 = message.arg1;
            int i11 = message.what;
            if (i11 != 1046) {
                if (i11 == 1047) {
                    C10462i c10462i = C10462i.this;
                    c10462i.m64276o(c10462i.f50433d, i10);
                    CommonReportUtil.reportLocalDataCheckResult("0", null);
                    return;
                }
                return;
            }
            C11839m.m70688i("SwitchRestoreTask", "MSG_SYNC_LOCAL_DATA_EXIST, module size = " + ((ArrayList) message.obj).size());
            C10462i c10462i2 = C10462i.this;
            c10462i2.m64276o(c10462i2.f50433d, i10);
            CommonReportUtil.reportLocalDataCheckResult("1", C10462i.this.f50433d);
        }
    }

    public C10462i(Context context, String str, String str2) {
        this.f50431b = context;
        this.f50432c = str;
        this.f50430a = str2;
        m64270h(context.getMainLooper());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C11839m.m70689w("SwitchRestoreTask", "SwitchRestoreTask begin");
        if (this.f50431b == null) {
            C11839m.m70689w("SwitchRestoreTask", "context is null");
            return;
        }
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        String strM1593f = C0227m.m1593f(C13452e.m80781L().m80971t0());
        if (!zM80842P0 || TextUtils.isEmpty(strM1593f)) {
            C11839m.m70689w("SwitchRestoreTask", "not login or uid is null");
            return;
        }
        if (TextUtils.isEmpty(this.f50432c)) {
            StringBuilder sbM64272k = m64272k();
            if (sbM64272k == null) {
                return;
            }
            if (TextUtils.isEmpty(sbM64272k)) {
                C11839m.m70689w("SwitchRestoreTask", "content is empty");
                return;
            } else {
                this.f50432c = sbM64272k.toString();
                C11839m.m70688i("SwitchRestoreTask", "readCloneFileContent from file");
            }
        }
        try {
            C0080b c0080b = (C0080b) new Gson().fromJson(this.f50432c, C0080b.class);
            if (c0080b == null || !StringUtil.equals(strM1593f, c0080b.getUidSha256())) {
                C11839m.m70689w("SwitchRestoreTask", "switchBackUpBean is null or uid is not same");
                return;
            }
            if (1 < c0080b.getDataVersion()) {
                C11839m.m70689w("SwitchRestoreTask", "dataVersion restore < backup :1 > " + c0080b.getDataVersion());
                return;
            }
            if (!StringUtil.equals("0", c0080b.getFrameworkType())) {
                C11839m.m70689w("SwitchRestoreTask", "not android backup");
                return;
            }
            m64275n(c0080b, C10028c.m62183d0(this.f50431b));
            m64273l(c0080b);
            C11839m.m70689w("SwitchRestoreTask", "SwitchRestoreTask end");
        } catch (JsonSyntaxException e10) {
            C11839m.m70689w("SwitchRestoreTask", "switchBackUpBean format err " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public final void m64267e(boolean z10) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (z10 != c10028cM62182c0.m62388s("backup_key")) {
            CloudBackupService.getInstance().cloudbackupOpr(z10);
            if (z10) {
                c10028cM62182c0.m62202D2("EnterClosedCloudBackupTimes", 0);
                C13225d.m79490f1().m79558J0("16");
            } else {
                if (CBAccess.inBackup() && !CBAccess.hasValidTempBackup()) {
                    m64271j();
                }
                CloudBackupService.getInstance().reportCloseBackup();
                c10028cM62182c0.m62197C2("CloseCloudBackupDate", 0L);
            }
            C13225d c13225dM79490f1 = C13225d.m79490f1();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SwitchRestoreTask");
            sb2.append(z10 ? ": open switch" : ": close switch");
            c13225dM79490f1.m79597u0(sb2.toString(), C13471c.f.ALL_SWITCH, z10);
        }
    }

    /* renamed from: f */
    public final void m64268f(String str, int i10) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("SwitchRestoreTask", "executeSync, syncModuleName:" + str + ", traceId: " + strM81958d);
        if ("addressbook".equals(str)) {
            C10155f.m63272Y(this.f50431b, strM81958d, SyncType.RISK_MANAGEMENT_MANUALLY, i10);
        } else if ("calendar".equals(str)) {
            C10155f.m63271X(this.f50431b, strM81958d, i10);
        } else if ("notepad".equals(str)) {
            C10155f.m63275a0(this.f50431b, strM81958d, i10);
        } else if ("wlan".equals(str)) {
            C10155f.m63279c0(this.f50431b, strM81958d, i10);
        } else if ("browser".equals(str)) {
            C10155f.m63270W(this.f50431b, strM81958d, i10);
        } else if (HNConstants.DataType.MEDIA.equals(str)) {
            C2783d.m16178s0(this.f50431b.getApplicationContext(), "84", SyncType.RISK_MANAGEMENT_MANUALLY);
        } else {
            C10155f.m63277b0(this.f50431b, str, strM81958d, i10);
        }
        C14317j.m85300d().m85319t();
    }

    /* renamed from: g */
    public final Map<String, String> m64269g() {
        HashMap map = new HashMap();
        map.put(CloudBackupConstant.Command.PMS_CMD_BACKUP, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        map.put("calendar", "backup_calendar");
        map.put("calllog", "backup_calllog");
        map.put(HNConstants.DataType.CONTACT, "backup_contact");
        map.put(NavigationUtils.SMS_SCHEMA_PREF, "backup_sms");
        return map;
    }

    /* renamed from: h */
    public final void m64270h(Looper looper) {
        this.f50434e = new a(looper);
    }

    /* renamed from: j */
    public void m64271j() {
        CloudBackupService.getInstance().abort(PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_system_retread", String.valueOf(false));
        linkedHashMap.put("is_refurbish", Boolean.FALSE);
        C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", "2", "", linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v0, types: [i9.i] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v24, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.StringBuilder m64272k() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p362i9.C10462i.m64272k():java.lang.StringBuilder");
    }

    /* renamed from: l */
    public final void m64273l(C0080b c0080b) {
        C0080b.a backupSwitch = c0080b.getBackupSwitch();
        if (backupSwitch != null) {
            int status = backupSwitch.getStatus();
            int baseStatus = backupSwitch.getBaseStatus();
            boolean zM80887a1 = C13452e.m80781L().m80887a1();
            boolean z10 = true;
            boolean z11 = status == 1;
            boolean z12 = baseStatus == 1;
            C11839m.m70688i("SwitchRestoreTask", "refreshBackUpSwitch. status :" + status + " baseStatus:" + baseStatus + " ,newBmType: " + zM80887a1);
            m64274m(backupSwitch);
            if (!zM80887a1) {
                m64267e(z11);
                return;
            }
            Integer baseStatusNew = backupSwitch.getBaseStatusNew();
            Integer statusNew = backupSwitch.getStatusNew();
            boolean z13 = z12 || (!C13452e.m80781L().m80791C0() && z11);
            boolean z14 = (baseStatusNew == null || statusNew == null) ? false : true;
            if (z14) {
                z12 = baseStatusNew.intValue() == 1;
                z13 = statusNew.intValue() == 1;
            } else {
                z10 = z11;
            }
            C11839m.m70688i("SwitchRestoreTask", "refreshBackUpSwitch isNew: " + z14 + " ,isOpen: " + z10 + " ,isBaseOpen: " + z12 + " ,backupOpen:" + z13);
            m64277p(z10, z12, z13);
        }
    }

    /* renamed from: m */
    public final void m64274m(C0080b.a aVar) {
        List<String> listM69904c;
        List<C0080b.b> appSwitch = aVar.getAppSwitch();
        C11718b c11718b = new C11718b();
        C13026e c13026e = new C13026e();
        Map<String, String> mapM64269g = m64269g();
        for (C0080b.b bVar : appSwitch) {
            boolean z10 = bVar.getStatus() == 1;
            String bundleName = bVar.getBundleName();
            if (z10) {
                BackupOptionItem backupOptionItemM78401y = c13026e.m78401y(bundleName);
                if (backupOptionItemM78401y == null || !backupOptionItemM78401y.getBackupSwitch()) {
                    String str = mapM64269g.get(bundleName);
                    if (TextUtils.isEmpty(str)) {
                        c13026e.m78376K(true, bundleName);
                    } else {
                        List<String> listM69909h = c11718b.m69909h(str);
                        if (listM69909h != null && listM69909h.size() > 0 && (listM69904c = c11718b.m69904c(this.f50431b, listM69909h)) != null && listM69904c.size() > 0) {
                            C11839m.m70689w("SwitchRestoreTask", "refreshBackUpSwitch. moduleId " + str + "unGranted " + listM69904c.size());
                        }
                        c13026e.m78376K(true, bundleName);
                    }
                }
            } else {
                c13026e.m78376K(false, bundleName);
            }
        }
    }

    /* renamed from: n */
    public final void m64275n(C0080b c0080b, C10028c c10028c) {
        List<String> listM69904c;
        List<C0080b.b> syncSwitch = c0080b.getSyncSwitch();
        List<String> listM6037B = C1008c.m6035v().m6037B(this.f50431b);
        C11718b c11718b = new C11718b();
        if (syncSwitch != null) {
            for (C0080b.b bVar : syncSwitch) {
                String type = bVar.getType();
                int status = bVar.getStatus();
                Integer memberStatus = bVar.getMemberStatus();
                boolean z10 = status == 1;
                C11839m.m70688i("SwitchRestoreTask", "refreshSyncSwitch. status :" + status + " memberStatus:" + memberStatus + " moduleId:" + type);
                if (HNConstants.DataType.MEDIA.equals(type)) {
                    boolean zM5975v = C1006a.m5936k().m5975v(this.f50431b);
                    if (z10 && !zM5975v) {
                        this.f50433d.add(type);
                    }
                    if (!z10 && zM5975v) {
                        C10155f.m63268U(this.f50431b, type, 16);
                    }
                    C1006a.m5936k().m5951O(z10, this.f50431b);
                    c10028c.m62336h2("uploadphotokey", z10);
                } else {
                    if (listM6037B.contains(type)) {
                        c10028c.m62245M2(type, memberStatus);
                    }
                    boolean zM62388s = c10028c.m62388s(type);
                    if (z10 && !zM62388s) {
                        List<String> listM69909h = c11718b.m69909h(type);
                        if (listM69909h == null || listM69909h.size() <= 0 || (listM69904c = c11718b.m69904c(this.f50431b, listM69909h)) == null || listM69904c.size() <= 0) {
                            this.f50433d.add(type);
                        } else {
                            C11839m.m70689w("SwitchRestoreTask", "refreshSyncSwitch. moduleId " + type + "unGranted " + listM69904c.size());
                        }
                    }
                    if (!z10 && zM62388s) {
                        C10155f.m63268U(this.f50431b, type, 16);
                    }
                    c10028c.m62336h2(type, z10);
                }
            }
            new C1396a(this.f50434e).m7988b(this.f50431b, this.f50433d, 16);
            CommonReportUtil.reportLocalDataCheck(this.f50433d);
        }
    }

    /* renamed from: o */
    public final void m64276o(ArrayList<String> arrayList, int i10) {
        C11839m.m70688i("SwitchRestoreTask", "sync4LocalDataCheck");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m64268f(it.next(), i10);
        }
    }

    /* renamed from: p */
    public final void m64277p(boolean z10, boolean z11, boolean z12) {
        m64267e(z12);
        C14315h.m85262p().m85271J(z11);
        if (z11) {
            C13225d.m79490f1().m79557I0("16");
        }
        if (z10 || !z12) {
            return;
        }
        InterfaceC11331i.get().ifPresent(new C10461h());
    }
}
