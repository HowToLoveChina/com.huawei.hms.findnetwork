package com.huawei.android.hicloud.p088ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackSpaceHeaderBean;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppSettingSingleInstance;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupDetailActivity;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.VerticalBtnAlertDialog;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.C4101g;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloudSpaceDeleteModuleDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TempDoubleBtnDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import hu.C10342a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0241z;
import p252e9.C9428e;
import p336he.C10153d;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p616rk.C12515a;
import p618rm.C12547e;
import p618rm.C12580p;
import p618rm.C12590s0;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p783xp.C13843a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p847zk.C14318k;
import p847zk.C14329v;
import p848zl.C14339h;
import pm.C12175b0;
import pm.C12176c;
import pm.C12177d;
import pm.C12178e;
import pm.C12199z;
import sk.C12809f;
import tl.C13036o;

/* loaded from: classes3.dex */
public class CloudSpaceBackupDetailActivity extends CloudSpaceBackupBaseActivity implements AlertDialogCallback, BackupSpaceDetailAdapter.DeleteBackupModuleListener {

    /* renamed from: A1 */
    public boolean f14461A1;

    /* renamed from: B1 */
    public boolean f14462B1;

    /* renamed from: C1 */
    public int f14463C1;

    /* renamed from: H1 */
    public Integer f14468H1;

    /* renamed from: I1 */
    public boolean f14469I1;

    /* renamed from: J1 */
    public String f14470J1;

    /* renamed from: N1 */
    public TipPopupLayout f14474N1;

    /* renamed from: S0 */
    public AutoSizeButton f14478S0;

    /* renamed from: T0 */
    public RecyclerView f14479T0;

    /* renamed from: U0 */
    public RelativeLayout f14480U0;

    /* renamed from: V0 */
    public NotchFitRelativeLayout f14481V0;

    /* renamed from: W0 */
    public NotchFitRelativeLayout f14482W0;

    /* renamed from: Y0 */
    public String f14484Y0;

    /* renamed from: Z0 */
    public String f14485Z0;

    /* renamed from: a1 */
    public DeleteOneDeviceBackupRecordDialog f14486a1;

    /* renamed from: b1 */
    public DeleteOneDeviceBackupRecordDialog f14487b1;

    /* renamed from: c1 */
    public CutOutProgressDialog f14488c1;

    /* renamed from: d1 */
    public C4101g f14489d1;

    /* renamed from: e1 */
    public BackupDetailItem f14490e1;

    /* renamed from: g1 */
    public NotchTopFitRelativeLayout f14492g1;

    /* renamed from: h1 */
    public CloudSpaceDeleteModuleDialog f14493h1;

    /* renamed from: i1 */
    public VerticalBtnAlertDialog f14494i1;

    /* renamed from: j1 */
    public TempDoubleBtnDialog f14495j1;

    /* renamed from: n1 */
    public long f14499n1;

    /* renamed from: o1 */
    public boolean f14500o1;

    /* renamed from: p1 */
    public boolean f14501p1;

    /* renamed from: q1 */
    public NotchFitRelativeLayout f14502q1;

    /* renamed from: r1 */
    public NotchFitRelativeLayout f14503r1;

    /* renamed from: s1 */
    public NotchFitRelativeLayout f14504s1;

    /* renamed from: t1 */
    public AutoSizeButton f14505t1;

    /* renamed from: u1 */
    public boolean f14506u1;

    /* renamed from: v1 */
    public String f14507v1;

    /* renamed from: w1 */
    public boolean f14508w1;

    /* renamed from: x1 */
    public boolean f14509x1;

    /* renamed from: y1 */
    public TextView f14510y1;

    /* renamed from: z1 */
    public LinearLayout f14511z1;

    /* renamed from: X0 */
    public final Set<Runnable> f14483X0 = new HashSet();

    /* renamed from: f1 */
    public final RecommendCardReport f14491f1 = new RecommendCardReport();

    /* renamed from: k1 */
    public List<CBSSyncRecordDeviceInfo> f14496k1 = new ArrayList();

    /* renamed from: l1 */
    public int f14497l1 = -1;

    /* renamed from: m1 */
    public int f14498m1 = -1;

    /* renamed from: D1 */
    public boolean f14464D1 = false;

    /* renamed from: E1 */
    public boolean f14465E1 = false;

    /* renamed from: F1 */
    public boolean f14466F1 = false;

    /* renamed from: G1 */
    public int f14467G1 = 7;

    /* renamed from: K1 */
    public boolean f14471K1 = false;

    /* renamed from: L1 */
    public final CloudBackSpaceHeaderBean f14472L1 = new CloudBackSpaceHeaderBean();

    /* renamed from: M1 */
    public final List<Object> f14473M1 = new ArrayList();

    /* renamed from: O1 */
    public final Handler.Callback f14475O1 = new C3241a();

    /* renamed from: P1 */
    public volatile boolean f14476P1 = true;

    /* renamed from: Q1 */
    public final Handler f14477Q1 = new Handler(new C3248h());

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$a */
    public class C3241a implements Handler.Callback {
        public C3241a() {
        }

        /* renamed from: d */
        public static /* synthetic */ AppDetailsInfo m20131d(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
            return TextUtils.equals(appDetailsInfo.getBackupAppName(), appDetailsInfo2.getBackupAppName()) ? appDetailsInfo : appDetailsInfo2;
        }

        /* renamed from: c */
        public final /* synthetic */ void m20132c() {
            CloudSpaceBackupDetailActivity.this.m20027A4();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (32309 == i10) {
                long jCurrentTimeMillis = System.currentTimeMillis() - CloudSpaceBackupDetailActivity.this.f14499n1;
                int i11 = message.arg1;
                if (i11 == 0) {
                    C10028c.m62182c0().m62255O2(0L);
                    C9428e.m59118h().m59129k(C0213f.m1377a());
                    CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity = CloudSpaceBackupDetailActivity.this;
                    cloudSpaceBackupDetailActivity.f14458Q0 = true;
                    cloudSpaceBackupDetailActivity.f14497l1 = 0;
                    LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                    linkedHashMapM79499C.put("deleteTime", String.valueOf(jCurrentTimeMillis));
                    if (CloudSpaceBackupDetailActivity.this.f14490e1 != null) {
                        linkedHashMapM79499C.put("deleteSize", String.valueOf(CloudSpaceBackupDetailActivity.this.f14490e1.m16382l()));
                    }
                    C13225d.m79490f1().m79591l0("mecloud_ backupdetail_delete_success", linkedHashMapM79499C);
                    UBAAnalyze.m29958S("PVC", "mecloud_ backupdetail_delete_success", "1", "43", linkedHashMapM79499C);
                    if (CloudSpaceBackupDetailActivity.this.f14490e1 != null && CloudSpaceBackupDetailActivity.this.f14500o1) {
                        BackupNotification.getInstance().cancelBackupNotification();
                    }
                    C13108a.m78878b(CloudSpaceBackupDetailActivity.this.getApplicationContext()).m78881d(new Intent("com.huawei.android.intent.action.CLOUD_BACKUP_DELETE"));
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "delete success.");
                } else {
                    CloudSpaceBackupDetailActivity.this.f14497l1 = i11;
                    LinkedHashMap linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
                    linkedHashMapM79499C2.put("deleteTime", String.valueOf(jCurrentTimeMillis));
                    C13225d.m79490f1().m79591l0("mecloud_ backupdetail_delete_failed", linkedHashMapM79499C2);
                    UBAAnalyze.m29954O("PVC", "mecloud_ backupdetail_delete_failed", "1", "43");
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "delete failed (others).");
                }
            } else if (33022 == i10) {
                CloudSpaceBackupDetailActivity.this.f14478S0.setEnabled(true);
                CloudSpaceBackupDetailActivity.this.f14478S0.setAlpha(1.0f);
                if (message.arg1 == 0) {
                    List<AppDetailsInfo> listM85424c0 = C14329v.m85349e0().m85424c0();
                    CloudSpaceBackupDetailActivity.this.f14476P1 = true;
                    if (listM85424c0.isEmpty()) {
                        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "appSizeInfos is null");
                        C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.s4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f17727a.m20132c();
                            }
                        }, 1000L);
                        return true;
                    }
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25504H();
                    List listM20105T4 = CloudSpaceBackupDetailActivity.this.m20105T4(listM85424c0);
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "get device list:detailsInfos");
                    CloudSpaceBackupDetailActivity.this.m20106U3(listM20105T4);
                    CloudSpaceBackupDetailActivity.this.m20126x4();
                    CloudSpaceBackupDetailActivity.this.m20112Z3();
                } else {
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "get device list:hasData false");
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25514U(CloudSpaceBackupDetailActivity.this.f14479T0, false);
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25515V(CloudSpaceBackupDetailActivity.this.f14479T0, false);
                    CloudSpaceBackupDetailActivity.this.m20122o4();
                }
            } else if (33042 == i10) {
                if (message.arg1 == 0) {
                    C10028c.m62182c0().m62255O2(0L);
                    C9428e.m59118h().m59129k(C0213f.m1377a());
                    CloudSpaceBackupDetailActivity.this.f14457P0 = true;
                    List<AppDetailsInfo> listM85424c02 = C14329v.m85349e0().m85424c0();
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25504H();
                    if (C13452e.m80781L().m80887a1() && AbstractC14026a.m84159a(listM85424c02)) {
                        CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity2 = CloudSpaceBackupDetailActivity.this;
                        cloudSpaceBackupDetailActivity2.setResult(101, cloudSpaceBackupDetailActivity2.getIntent());
                        CloudSpaceBackupDetailActivity.this.finish();
                    }
                    CloudSpaceBackupDetailActivity.this.m20106U3(CloudSpaceBackupDetailActivity.this.m20105T4(listM85424c02));
                    CloudSpaceBackupDetailActivity.this.m20090D4(((Long) message.obj).longValue());
                } else {
                    int iM1685c = C0241z.m1685c(String.valueOf(message.obj));
                    if (iM1685c == 1) {
                        CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_failed_toast);
                    } else if (iM1685c == 2) {
                        CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_backup_record_service_failed);
                    } else {
                        CloudSpaceBackupDetailActivity.this.m20023U2();
                    }
                }
            } else if (33334 == i10) {
                CloudSpaceBackupDetailActivity.this.m20090D4(((Long) message.obj).longValue());
            } else if (34444 == i10) {
                C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "current listview has not footer view");
            } else if (33040 == i10) {
                CloudSpaceBackupDetailActivity.this.m20054c4();
                if (CloudSpaceBackupDetailActivity.this.f14497l1 == 0) {
                    CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity3 = CloudSpaceBackupDetailActivity.this;
                    cloudSpaceBackupDetailActivity3.setResult(101, cloudSpaceBackupDetailActivity3.getIntent());
                    CloudSpaceBackupDetailActivity.this.finish();
                } else if (CloudSpaceBackupDetailActivity.this.f14497l1 == 1) {
                    CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_failed_toast);
                } else if (CloudSpaceBackupDetailActivity.this.f14497l1 == 2) {
                    CloudSpaceBackupDetailActivity.this.m20023U2();
                } else if (CloudSpaceBackupDetailActivity.this.f14497l1 == 3) {
                    CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_backup_record_service_failed);
                } else {
                    CloudSpaceBackupDetailActivity.this.finish();
                }
            } else if (33041 == i10) {
                long jM1688f = C0241z.m1688f(String.valueOf(message.obj));
                String strM1524g = C0223k.m1524g(CloudSpaceBackupDetailActivity.this, jM1688f);
                CloudSpaceBackupDetailActivity.this.f14472L1.detailItem.m16370K(jM1688f);
                CloudSpaceBackupDetailActivity.this.f14472L1.detailItem.m16372M(strM1524g);
                CloudSpaceBackupDetailActivity.this.f14489d1.m5214k(0);
                CloudSpaceBackupDetailActivity.this.f14489d1.m25515V(CloudSpaceBackupDetailActivity.this.f14479T0, true);
            } else if (33001 == i10) {
                if (CloudSpaceBackupDetailActivity.this.f14489d1 != null) {
                    String str = (String) message.obj;
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "icon download succeed, appid: " + str);
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25517X(CloudSpaceBackupDetailActivity.this.f14479T0, str);
                }
            } else if (34333 == i10) {
                try {
                    Bundle data = message.getData();
                    if (data != null) {
                        final AppDetailsInfo appDetailsInfo = (AppDetailsInfo) data.getSerializable("AppDetailsInfo");
                        if (appDetailsInfo == null) {
                            return false;
                        }
                        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "handle msg item is:" + appDetailsInfo);
                        if (CloudSpaceBackupDetailActivity.this.f14489d1 != null) {
                            if (appDetailsInfo.isBasicItem()) {
                                CloudSpaceBackupDetailActivity.this.f14489d1.m25510Q(appDetailsInfo);
                            } else {
                                CloudSpaceBackupDetailActivity.this.f14489d1.m25508L().replaceAll(new UnaryOperator() { // from class: com.huawei.android.hicloud.ui.activity.t4
                                    @Override // java.util.function.Function
                                    public final Object apply(Object obj) {
                                        return CloudSpaceBackupDetailActivity.C3241a.m20131d(appDetailsInfo, (AppDetailsInfo) obj);
                                    }
                                });
                                CloudSpaceBackupDetailActivity.this.f14489d1.m5214k(CloudSpaceBackupDetailActivity.this.f14489d1.m25509M(appDetailsInfo.getBackupAppName()));
                            }
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "handle msg item error:" + e10);
                }
            } else if (34334 == i10) {
                int i12 = message.arg1;
                if (i12 == 2 || i12 == 1) {
                    List<AppDetailsInfo> listM85424c03 = C14329v.m85349e0().m85424c0();
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25504H();
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "loading done:hasData");
                    CloudSpaceBackupDetailActivity.this.m20106U3(CloudSpaceBackupDetailActivity.this.m20105T4(listM85424c03));
                }
            } else if (33037 == i10) {
                CloudSpaceBackupDetailActivity.this.m20112Z3();
            } else if (33038 == i10) {
                if (CloudSpaceBackupDetailActivity.this.f14465E1) {
                    CloudSpaceBackupDetailActivity.this.m20120l4();
                } else {
                    CloudSpaceBackupDetailActivity.this.m20113a4();
                }
            } else if (33051 == i10) {
                if (message.arg1 == 2) {
                    CloudSpaceBackupDetailActivity.this.m20099N4();
                } else {
                    CloudSpaceBackupDetailActivity.this.m20102Q4();
                }
            } else if (33049 == i10) {
                CloudSpaceBackupDetailActivity.this.m20054c4();
                if (CloudSpaceBackupDetailActivity.this.f14498m1 == 0) {
                    C13108a.m78878b(CloudSpaceBackupDetailActivity.this.getApplicationContext()).m78881d(new Intent("com.huawei.android.intent.action.CLOUD_BACKUP_DELETE"));
                    Intent intent = CloudSpaceBackupDetailActivity.this.getIntent();
                    intent.putExtra("bak_id", CloudSpaceBackupDetailActivity.this.f14490e1.m16375d());
                    CloudSpaceBackupDetailActivity.this.setResult(101, intent);
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "delete success.");
                    CloudSpaceBackupDetailActivity.this.finish();
                } else if (CloudSpaceBackupDetailActivity.this.f14498m1 == 1) {
                    CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_failed_toast);
                } else if (CloudSpaceBackupDetailActivity.this.f14498m1 == 2) {
                    CloudSpaceBackupDetailActivity.this.m20023U2();
                } else if (CloudSpaceBackupDetailActivity.this.f14498m1 == 3) {
                    CloudSpaceBackupDetailActivity.this.m20025W2(R$string.delete_backup_record_service_failed);
                } else {
                    CloudSpaceBackupDetailActivity.this.finish();
                }
            } else if (33047 == i10) {
                int i13 = message.arg1;
                if (i13 == 0) {
                    CloudSpaceBackupDetailActivity.this.f14498m1 = 0;
                } else if (i13 == 3) {
                    CloudSpaceBackupDetailActivity.this.f14498m1 = 3;
                } else {
                    int i14 = message.arg2;
                    if (String.valueOf(i14).endsWith(String.valueOf(4291))) {
                        CloudSpaceBackupDetailActivity.this.f14498m1 = 1;
                    } else if (C14339h.m85516o().contains(Integer.valueOf(i14)) || C14339h.m85514m().contains(Integer.valueOf(i14))) {
                        CloudSpaceBackupDetailActivity.this.f14498m1 = 2;
                    }
                }
            } else if (33023 == i10) {
                C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "get temp apps");
                List<AppDetailsInfo> listM85428h0 = C14329v.m85349e0().m85428h0();
                if (message.arg1 == 0) {
                    CloudSpaceBackupDetailActivity.this.m20107U4(listM85428h0);
                } else {
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "get temp apps:hasData false");
                    CloudSpaceBackupDetailActivity.this.f14489d1.m25514U(CloudSpaceBackupDetailActivity.this.f14479T0, false);
                }
            } else if (32338 == i10) {
                CloudSpaceBackupDetailActivity.this.m20089C4(message);
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$b */
    public class C3242b extends BackupRecordSingleTask {
        public C3242b() {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask, p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            List<UserBackupInfo.UserDeviceInfo> listM78567g = new C13036o().m78567g();
            for (int i10 = 0; i10 < listM78567g.size(); i10++) {
                UserBackupInfo.UserDeviceInfo userDeviceInfo = listM78567g.get(i10);
                if (CloudSpaceBackupDetailActivity.this.f14490e1.m16374c().equals(userDeviceInfo.getBackupDeviceId()) && userDeviceInfo.isTempBackUp()) {
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16369I(CloudSpaceBackupDetailActivity.this.m20058e4(userDeviceInfo.getDeviceName()));
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16389s(userDeviceInfo.getDeviceID());
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16390t(userDeviceInfo.getDeviceType());
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16385o(userDeviceInfo.getBakId());
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16386p(userDeviceInfo.isCurrent() ? 1 : 0);
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16370K(userDeviceInfo.getSize());
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16388r(userDeviceInfo.getDeviceCategory());
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16372M(C0223k.m1524g(CloudSpaceBackupDetailActivity.this, userDeviceInfo.getSize()));
                    CloudSpaceBackupDetailActivity.this.f14490e1.m16368A(String.valueOf(userDeviceInfo.getLastbackupTime()));
                    CloudSpaceBackupDetailActivity.this.f14472L1.detailItem = CloudSpaceBackupDetailActivity.this.f14490e1;
                    CloudSpaceBackupDetailActivity.this.f14472L1.isOnlyHarmonyNext = userDeviceInfo.isOnlyHarmonyNext();
                    Iterator<ExtraDeviceInfo> it = userDeviceInfo.getExtraDeviceInfos().iterator();
                    while (it.hasNext()) {
                        ExtraDeviceInfo next = it.next();
                        if (TextUtils.equals(next.getId(), CloudSpaceBackupDetailActivity.this.f14490e1.m16375d())) {
                            CloudSpaceBackupDetailActivity.this.f14467G1 = next.getExpiratoryInDays();
                            if (CloudSpaceBackupDetailActivity.this.f14467G1 == 0) {
                                CloudSpaceBackupDetailActivity.this.f14467G1++;
                            }
                            CloudSpaceBackupDetailActivity.this.f14468H1 = next.getOccupySpaceType();
                            CloudSpaceBackupDetailActivity.this.f14469I1 = next.isCanBeReserveForever();
                            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "init backupRecord canBeReserveForever:" + CloudSpaceBackupDetailActivity.this.f14469I1);
                            CloudSpaceBackupDetailActivity.this.f14472L1.expiratoryInDays = CloudSpaceBackupDetailActivity.this.f14467G1;
                            CloudSpaceBackupDetailActivity.this.f14472L1.occupySpaceType = CloudSpaceBackupDetailActivity.this.f14468H1;
                            CloudSpaceBackupDetailActivity.this.f14472L1.canBeReserveForever = CloudSpaceBackupDetailActivity.this.f14469I1;
                        }
                    }
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.u4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17759a.lambda$call$0();
                        }
                    });
                    return;
                }
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.v4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17773a.m20135e();
                }
            });
        }

        /* renamed from: e */
        public final /* synthetic */ void m20135e() {
            try {
                SafeIntent safeIntent = new SafeIntent(new Intent());
                safeIntent.setClass(CloudSpaceBackupDetailActivity.this, BackupMainActivity.class);
                CloudSpaceBackupDetailActivity.this.startActivity(safeIntent);
                CloudSpaceBackupDetailActivity.this.finish();
            } catch (Exception e10) {
                C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "start MainActivity exception: " + e10.getMessage());
            }
        }

        public final /* synthetic */ void lambda$call$0() {
            CloudSpaceBackupDetailActivity.this.m20123p4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$c */
    public class C3243c extends BackupRecordSingleTask {
        public C3243c() {
        }

        public /* synthetic */ void lambda$call$0() {
            CloudSpaceBackupDetailActivity.this.f14472L1.tips = CloudSpaceBackupDetailActivity.this.getString(R$string.current_device_no_backup_records);
            CloudSpaceBackupDetailActivity.this.f14489d1.m5214k(0);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask, p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo : new C13036o().m78566f()) {
                if (TextUtils.equals(CloudSpaceBackupDetailActivity.this.f14490e1.m16374c(), userDeviceInfo.getBackupDeviceId())) {
                    if (userDeviceInfo.isHasOnlyRefurbishAndBackingUp()) {
                        CloudSpaceBackupDetailActivity.this.f14476P1 = true;
                        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "Has Refurbish,common backup is backing up.");
                        return;
                    }
                    CloudSpaceBackupDetailActivity.this.f14476P1 = userDeviceInfo.getLastbackupTime() != 0;
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "checkDeviceRecordsInfo userDeviceInfo size" + userDeviceInfo.getSize());
                    CloudSpaceBackupDetailActivity.this.f14472L1.detailItem.m16370K(userDeviceInfo.getSize());
                    CloudSpaceBackupDetailActivity.this.f14472L1.isCurrentDeviceHasData = CloudSpaceBackupDetailActivity.this.f14476P1;
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "isCurrentDeviceHasData: " + CloudSpaceBackupDetailActivity.this.f14476P1);
                    if (CloudSpaceBackupDetailActivity.this.f14476P1) {
                        return;
                    }
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.w4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17788a.lambda$call$0();
                        }
                    });
                    return;
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$d */
    public class C3244d extends BackupRecordSingleTask {
        public C3244d() {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask, p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                final Bak bakM84123S = new C13998b0().m84123S(CloudSpaceBackupDetailActivity.this.f14490e1.m16374c(), CloudSpaceBackupDetailActivity.this.f14490e1.m16375d(), C11058a.m66627b("02024"), "id,bakCategory,backupStatus,canbeReserveForever,expiratoryInDays,occupySpaceType");
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.x4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17800a.m20138d(bakM84123S);
                    }
                });
            } catch (C9721b e10) {
                C11839m.m70689w(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "getCanBeReserveForever error: " + e10.getMessage());
            }
        }

        /* renamed from: d */
        public final /* synthetic */ void m20138d(Bak bak) {
            CloudSpaceBackupDetailActivity.this.f14468H1 = bak.getOccupySpaceType();
            CloudSpaceBackupDetailActivity.this.f14469I1 = bak.isCanbeReserveForever();
            CloudSpaceBackupDetailActivity.this.f14467G1 = bak.getExpiratoryInDaysForClient();
            CloudSpaceBackupDetailActivity.this.f14472L1.occupySpaceType = CloudSpaceBackupDetailActivity.this.f14468H1;
            CloudSpaceBackupDetailActivity.this.f14472L1.canBeReserveForever = bak.isCanbeReserveForever();
            CloudSpaceBackupDetailActivity.this.f14472L1.expiratoryInDays = bak.getExpiratoryInDaysForClient();
            CloudSpaceBackupDetailActivity.this.f14489d1.m5214k(0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$e */
    public class C3245e implements TempDoubleBtnDialog.BtnCallBack {

        /* renamed from: a */
        public final /* synthetic */ boolean f14516a;

        public C3245e(boolean z10) {
            this.f14516a = z10;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnLeftCallBack() {
            C4012a.m24631O("event_id_save_temp_backup_dialog", "cancel save tempbackup data dialog", CloudSpaceBackupDetailActivity.this.f14465E1 ? "notificationBar" : "backupManagePage");
            CloudSpaceBackupDetailActivity.this.f14466F1 = true;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnRightCallBack() {
            CloudSpaceBackupDetailActivity.this.f14466F1 = true;
            if (this.f14516a) {
                Bundle bundle = new Bundle();
                bundle.putInt("page_type", 16);
                bundle.putString("page_detail", CloudSpaceBackupDetailActivity.class.getName());
                bundle.putLong("need_extra_space", CloudSpaceBackupDetailActivity.this.f14490e1.m16382l());
                CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity = CloudSpaceBackupDetailActivity.this;
                C12126b.m72706b(cloudSpaceBackupDetailActivity, C13222a.m79465g(cloudSpaceBackupDetailActivity), bundle, true, 1004);
            } else {
                CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity2 = CloudSpaceBackupDetailActivity.this;
                cloudSpaceBackupDetailActivity2.m20114b4(cloudSpaceBackupDetailActivity2.f14490e1);
            }
            C4012a.m24631O("event_id_save_temp_backup_dialog", "confirm save tempbackup data dialog", CloudSpaceBackupDetailActivity.this.f14465E1 ? "notificationBar" : "backupManagePage");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$f */
    public class C3246f implements DeleteOneDeviceBackupRecordDialog.ClickCallback {
        public C3246f() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onCancelDelete() {
            CloudSpaceBackupDetailActivity.this.m20109W3();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onDeleteConfirmed() {
            CloudSpaceBackupDetailActivity.this.m20115f4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$g */
    public class C3247g implements DeleteOneDeviceBackupRecordDialog.ClickCallback {
        public C3247g() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onCancelDelete() {
            CloudSpaceBackupDetailActivity.this.m20109W3();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onDeleteConfirmed() {
            CloudSpaceBackupDetailActivity.this.m20115f4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity$h */
    public class C3248h implements Handler.Callback {
        public C3248h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (1001 == i10) {
                Object obj = message.obj;
                if (obj instanceof BackupStorageInfo) {
                    BackupStorageInfo backupStorageInfo = (BackupStorageInfo) obj;
                    if (backupStorageInfo.getCurrentDeviceBackupDetails() == null) {
                        CloudSpaceBackupDetailActivity.this.m20101P4();
                    } else {
                        CBSpaceDetail currentDeviceBackupDetails = backupStorageInfo.getCurrentDeviceBackupDetails();
                        if (currentDeviceBackupDetails.getSize() == 0) {
                            CloudSpaceBackupDetailActivity.this.m20101P4();
                        } else {
                            CloudSpaceBackupDetailActivity.this.f14490e1 = new BackupDetailItem();
                            CloudSpaceBackupDetailActivity.this.f14490e1.m16373a(currentDeviceBackupDetails);
                            CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity = CloudSpaceBackupDetailActivity.this;
                            CloudSpaceBackupDetailActivity.this.f14490e1.m16372M(C0223k.m1524g(cloudSpaceBackupDetailActivity, cloudSpaceBackupDetailActivity.f14490e1.m16382l()));
                            CloudSpaceBackupDetailActivity.this.m20098M4();
                            CloudSpaceBackupDetailActivity.this.m20070n4();
                        }
                    }
                }
            } else if (1002 == i10) {
                CloudSpaceBackupDetailActivity.this.m20102Q4();
            } else if (2001 == i10) {
                if (CloudSpaceBackupDetailActivity.this.f14480U0 != null) {
                    CloudSpaceBackupDetailActivity.this.f14480U0.setVisibility(8);
                }
                CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity2 = CloudSpaceBackupDetailActivity.this;
                C11841o.m70706b(cloudSpaceBackupDetailActivity2, cloudSpaceBackupDetailActivity2.getString(R$string.temp_backup_save_space_succeed_tips), 0);
                CloudSpaceBackupDetailActivity.this.f14472L1.occupySpaceType = 1;
                CloudSpaceBackupDetailActivity.this.f14472L1.canBeReserveForever = false;
                CloudSpaceBackupDetailActivity.this.f14469I1 = false;
                CloudSpaceBackupDetailActivity.this.f14468H1 = 1;
                CloudSpaceBackupDetailActivity.this.f14489d1.m5214k(0);
            } else if (2002 == i10) {
                if (CloudSpaceBackupDetailActivity.this.f14480U0 != null) {
                    CloudSpaceBackupDetailActivity.this.f14480U0.setVisibility(8);
                }
                CloudSpaceBackupDetailActivity cloudSpaceBackupDetailActivity3 = CloudSpaceBackupDetailActivity.this;
                C11841o.m70706b(cloudSpaceBackupDetailActivity3, cloudSpaceBackupDetailActivity3.getString(R$string.temp_backup_save_space_failed), 0);
            }
            return false;
        }
    }

    /* renamed from: A4 */
    public void m20027A4() {
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "<queryBackupRecords>");
        C12515a.m75110o().m75172d(new C12199z(1));
    }

    /* renamed from: G4 */
    private void m20034G4() {
        if (this.f14457P0 || this.f14458Q0) {
            m20091E4();
            setResult(101, getIntent());
        }
        finish();
    }

    /* renamed from: c4 */
    public void m20054c4() {
        CutOutProgressDialog cutOutProgressDialog = this.f14488c1;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
        }
    }

    /* renamed from: d4 */
    private List<AppDetailsInfo> m20056d4(List<AppDetailsInfo> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppDetailsInfo appDetailsInfo = (AppDetailsInfo) it.next();
            if (SplitAppUtil.isTwinApp(appDetailsInfo.getSplitApkType(), appDetailsInfo.getOriBackupAppName())) {
                List arrayList2 = map.get(appDetailsInfo.getOriBackupAppName()) != null ? (List) map.get(appDetailsInfo.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(appDetailsInfo);
                    map.put(appDetailsInfo.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.j4
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudSpaceBackupDetailActivity.m20074q4(str, (AppDetailsInfo) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    AppDetailsInfo appDetailsInfo2 = (AppDetailsInfo) optionalFindFirst.get();
                    List<AppDetailsInfo> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.k4
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return CloudSpaceBackupDetailActivity.m20076r4((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
                            }
                        });
                        appDetailsInfo2.setTwinAppsList(list2);
                        list.removeAll(list2);
                        list.addAll(list.indexOf(appDetailsInfo2) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: e4 */
    public String m20058e4(String str) {
        String strM68633c = C11477c.m68633c(str);
        return TextUtils.isEmpty(strM68633c) ? str : strM68633c;
    }

    /* renamed from: g2 */
    private void m20060g2() {
        this.f14492g1 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notch_main);
        this.f14482W0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.nfrel_delete);
        this.f16192J0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f14478S0 = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_backup_btn);
        this.f14480U0 = (RelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f14481V0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_detail_root_layout);
        this.f14510y1 = (TextView) C12809f.m76829b(this, R$id.backup_detail_tips);
        this.f14480U0.setVisibility(0);
        this.f14486a1 = new DeleteOneDeviceBackupRecordDialog(this, new C3246f());
        this.f14487b1 = new DeleteOneDeviceBackupRecordDialog(this, new C3247g());
        this.f14488c1 = new CutOutProgressDialog(this);
        this.f14478S0.setOnClickListener(this);
        this.f14478S0.setEnabled(false);
        this.f14478S0.setAlpha(0.6f);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.record_sys_list);
        this.f14479T0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f14479T0.setNestedScrollingEnabled(true);
        C4101g c4101g = new C4101g(this, this, this.f14464D1);
        this.f14489d1 = c4101g;
        c4101g.m25512S(this);
        this.f14479T0.setAdapter(this.f14489d1);
        this.f14479T0.setItemAnimator(null);
        C11842p.m70874v1(this, this.f14478S0);
        this.f14502q1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backup_detail_error_page);
        this.f14503r1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_fit_no_data);
        this.f14504s1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_nonet);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.bt_set_net);
        this.f14505t1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f14505t1.setOnClickListener(this);
        m20116g4();
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.backup_detail_server_error);
        this.f14511z1 = linearLayout;
        linearLayout.setOnClickListener(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rl_not_connect_column)).setOnClickListener(this);
    }

    /* renamed from: j4 */
    private void m20065j4() {
        Intent intent;
        CloudBackupService.getInstance().register(this.f14475O1);
        this.f14455N0 = new C13998b0();
        try {
            intent = getIntent();
        } catch (RuntimeException e10) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData e = " + e10.getMessage());
            intent = null;
        }
        if (intent == null) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData currentIntent is null");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        this.f14490e1 = (BackupDetailItem) safeIntent.getParcelableExtra("backup_item_param");
        this.f14506u1 = safeIntent.getBooleanExtra("from_backup_main_page", false);
        this.f14461A1 = safeIntent.getBooleanExtra("isOnlyRefurbish", false);
        boolean booleanExtra = safeIntent.getBooleanExtra("isOnlyHarmonyNext", false);
        this.f14462B1 = booleanExtra;
        this.f14472L1.isOnlyHarmonyNext = booleanExtra;
        this.f14463C1 = safeIntent.getIntExtra("backup_delete_report_entry", 0);
        String stringExtra = safeIntent.getStringExtra("terminalType");
        this.f14470J1 = stringExtra;
        this.f14472L1.detailItem.m16371L(stringExtra);
        int intExtra = safeIntent.getIntExtra("backup_device_space_result", 0);
        if (intExtra == 2) {
            m20102Q4();
        } else if (intExtra == 3) {
            if (!this.f14461A1) {
                m20101P4();
            }
        } else if (intExtra == 4) {
            m20099N4();
        }
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f14472L1;
        BackupDetailItem backupDetailItem = this.f14490e1;
        cloudBackSpaceHeaderBean.detailItem = backupDetailItem;
        cloudBackSpaceHeaderBean.isOnlyRefurbish = this.f14461A1;
        if (backupDetailItem != null) {
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "getIntentData:detailItem.getSize" + this.f14490e1.m16382l());
        }
    }

    /* renamed from: n4 */
    public void m20070n4() {
        m20106U3(null);
        if (!C0209d.m1333z1(this)) {
            m20100O4();
            return;
        }
        BackupDetailItem backupDetailItem = this.f14490e1;
        if (backupDetailItem == null || TextUtils.isEmpty(backupDetailItem.m16374c())) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData detailItem is null");
            m20101P4();
            return;
        }
        if (this.f14461A1) {
            this.f14482W0.setVisibility(8);
        }
        this.f14484Y0 = this.f14490e1.m16379h();
        this.f14485Z0 = this.f14490e1.m16381j();
        this.f14500o1 = this.f14490e1.m16376e() == 1;
        Boolean bool = C10153d.m63237a().get(this.f14490e1.m16374c());
        this.f14501p1 = bool != null ? bool.booleanValue() : false;
        this.f14480U0.setVisibility(8);
        C2783d.m16191y0(this.f14491f1, getIntent());
        m20117h4();
    }

    /* renamed from: q4 */
    public static /* synthetic */ boolean m20074q4(String str, AppDetailsInfo appDetailsInfo) {
        return str.equalsIgnoreCase(appDetailsInfo.getBackupAppName());
    }

    /* renamed from: r4 */
    public static /* synthetic */ int m20076r4(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        return C12580p.m75586t(appDetailsInfo.getBackupAppName(), appDetailsInfo2.getBackupAppName());
    }

    /* renamed from: s4 */
    public static /* synthetic */ void m20078s4(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_save_temp_backup_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_save_temp_backup_dialog", "4", "is_backup_detail", linkedHashMapM79497A);
    }

    /* renamed from: t4 */
    public static /* synthetic */ void m20080t4(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "cancel");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_backup_detail", linkedHashMapM79497A);
    }

    /* renamed from: w4 */
    public static /* synthetic */ void m20084w4(DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "show dialog");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_backup_detail", linkedHashMapM79497A);
    }

    /* renamed from: B4 */
    public final void m20088B4() {
        BackupDetailItem backupDetailItem = this.f14490e1;
        if (backupDetailItem != null && !TextUtils.isEmpty(backupDetailItem.m16374c())) {
            C14329v.m85349e0().m85433o0(this.f14490e1.m16374c(), this.f14490e1.m16375d());
        } else {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData detailItem is null");
            m20101P4();
        }
    }

    /* renamed from: C4 */
    public final void m20089C4(Message message) {
        Bundle bundle;
        BackupDetailItem backupDetailItem = this.f14490e1;
        if ((backupDetailItem == null || backupDetailItem.m16376e() == 1) && message.arg1 == 0 && (bundle = (Bundle) message.obj) != null) {
            long j10 = bundle.getLong("lastRecordTime");
            this.f14472L1.detailItem.m16368A(String.valueOf(j10));
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "refreshBackupTime: " + j10);
            this.f14489d1.m5214k(0);
        }
    }

    /* renamed from: D4 */
    public final void m20090D4(long j10) {
        if (j10 <= 0 || this.f14490e1 == null) {
            return;
        }
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "refreshDataSize " + j10);
        long jM16382l = this.f14490e1.m16382l() - j10;
        this.f14472L1.detailItem.m16370K(jM16382l);
        this.f14472L1.detailItem.m16372M(C0223k.m1524g(this, jM16382l));
        this.f14489d1.m5214k(0);
    }

    /* renamed from: E4 */
    public final void m20091E4() {
        C13036o c13036o = new C13036o();
        List<UserBackupInfo.UserDeviceInfo> listM78564d = c13036o.m78564d();
        ArrayList arrayList = new ArrayList();
        if (listM78564d != null && listM78564d.size() > 0 && this.f14490e1 != null) {
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo : listM78564d) {
                if (!arrayList.contains(userDeviceInfo) && this.f14490e1.m16374c().equalsIgnoreCase(userDeviceInfo.getBackupDeviceId())) {
                    arrayList.add(userDeviceInfo);
                    C11839m.m70686d(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "get device = " + userDeviceInfo.getDeviceName());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        UserBackupInfo.UserDeviceInfo userDeviceInfo2 = (UserBackupInfo.UserDeviceInfo) arrayList.get(0);
        userDeviceInfo2.setSize(this.f14490e1.m16382l());
        C11839m.m70686d(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "update device size = " + userDeviceInfo2.getSize());
        c13036o.m78574n(userDeviceInfo2);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33038;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: F4 */
    public final void m20092F4() {
        m20097L4();
        if (!C0209d.m1333z1(this)) {
            m20100O4();
            return;
        }
        if (this.f14506u1) {
            BackupDetailItem backupDetailItem = this.f14490e1;
            if (backupDetailItem == null || TextUtils.isEmpty(backupDetailItem.m16374c())) {
                m20128z4();
                return;
            } else {
                m20117h4();
                return;
            }
        }
        BackupDetailItem backupDetailItem2 = this.f14490e1;
        if (backupDetailItem2 != null && !TextUtils.isEmpty(backupDetailItem2.m16374c()) && this.f14465E1 && !TextUtils.isEmpty(this.f14490e1.m16375d())) {
            m20027A4();
            return;
        }
        BackupDetailItem backupDetailItem3 = this.f14490e1;
        if (backupDetailItem3 == null || TextUtils.isEmpty(backupDetailItem3.m16374c())) {
            C11839m.m70689w(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "retryShowBackupDetailView BackupDetailItem is null or backupDeviceId is null");
        } else {
            m20117h4();
        }
    }

    /* renamed from: H4 */
    public final void m20093H4(BackupDetailItem backupDetailItem) {
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "saveTempBackupToUserCloud detailItem " + backupDetailItem.m16375d());
        String str = this.f14465E1 ? "notificationBar" : "backupManagePage";
        this.f14480U0.setVisibility(0);
        C12515a.m75110o().m75175e(new C12175b0(this.f14477Q1, backupDetailItem.m16375d(), backupDetailItem.m16374c()), false);
        C4012a.m24631O("event_id_save_temp_backup_dialog", "confirm save tempbackup data dialog", str);
    }

    /* renamed from: I4 */
    public final void m20094I4(boolean z10) {
        this.f14489d1.m25515V(this.f14479T0, z10);
    }

    /* renamed from: J4 */
    public final void m20095J4(int i10, String str, String str2, AppDetailsInfo appDetailsInfo, boolean z10) {
        boolean zContains = (this.f14459R0 && !this.f14501p1 && C12590s0.m75865j1()) ? C12176c.m73271n("").contains(str) : false;
        CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = new CloudSpaceDeleteModuleDialog(this, this, 0, this.f14459R0, zContains);
        this.f14493h1 = cloudSpaceDeleteModuleDialog;
        cloudSpaceDeleteModuleDialog.setPosition(i10);
        this.f14493h1.setCurrentAppId(str);
        this.f14493h1.setBasicItem(z10);
        boolean zIsSupportSplitBackUp = SplitAppSettingSingleInstance.getInstance().isSupportSplitBackUp(str, this.f14461A1 ? "2" : this.f14464D1 ? "3" : "1");
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "showDeleteModuleDialog:supportSplitApp," + zIsSupportSplitBackUp + ",isSupportClose," + this.f14459R0 + ",isInWhiteList," + zContains);
        this.f14493h1.showHasTitleDialog(getString(R$string.dialog_close_delete_backup_switch_title_new, str2), (!this.f14459R0 || zContains || z10) ? (!appDetailsInfo.getTwinAppsList().isEmpty() || zIsSupportSplitBackUp) ? getString(R$string.dialog_close_delete_backup_switch_content_new2_has_twin, str2, str2) : getString(R$string.dialog_close_delete_backup_switch_content_new2, str2, str2) : (!appDetailsInfo.getTwinAppsList().isEmpty() || zIsSupportSplitBackUp) ? getString(R$string.dialog_close_delete_backup_switch_content_new_has_twin, str2, str2) : getString(R$string.dialog_close_delete_backup_switch_content_new, str2, str2));
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter.DeleteBackupModuleListener
    /* renamed from: K */
    public void mo20013K(int i10, String str) {
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "onDeleteBackupModule");
        m20022T2();
        if (C0209d.m1226Y0()) {
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C11829c.m70612r1(this);
            return;
        }
        AppDetailsInfo appDetailsInfoM25507K = this.f14489d1.m25507K(i10);
        String strM20021S2 = m20021S2(appDetailsInfoM25507K.getApkType(), str);
        if (TextUtils.isEmpty(strM20021S2)) {
            strM20021S2 = appDetailsInfoM25507K.getPropertiesValue(SnapshotBackupMeta.KEY_STRING_APP_NAME);
        }
        m20095J4(i10, str, strM20021S2, appDetailsInfoM25507K, false);
    }

    /* renamed from: K4 */
    public void m20096K4(Integer num) throws Resources.NotFoundException {
        String quantityString;
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "occupySpaceType is " + this.f14469I1);
        if (num == null || num.intValue() != 0) {
            return;
        }
        TempDoubleBtnDialog tempDoubleBtnDialog = this.f14495j1;
        if (tempDoubleBtnDialog != null && tempDoubleBtnDialog.isShowing()) {
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "tempDoubleBtnDialog is show");
            return;
        }
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        TempDoubleBtnDialog tempDoubleBtnDialog2 = new TempDoubleBtnDialog(this, new C3245e(zM80791C0));
        this.f14495j1 = tempDoubleBtnDialog2;
        tempDoubleBtnDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.activity.m4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                CloudSpaceBackupDetailActivity.m20078s4(dialogInterface);
            }
        });
        TempDoubleBtnDialog tempDoubleBtnDialog3 = this.f14495j1;
        String string = getString(R$string.temp_backup_change_space_dialog_title);
        if (zM80791C0) {
            Resources resources = getResources();
            int i10 = R$plurals.temp_backup_save_basic_des;
            int i11 = this.f14467G1;
            quantityString = resources.getQuantityString(i10, i11, Integer.valueOf(i11));
        } else {
            Resources resources2 = getResources();
            int i12 = R$plurals.temp_backup_change_space_dialog_message;
            int i13 = this.f14467G1;
            quantityString = resources2.getQuantityString(i12, i13, Integer.valueOf(i13));
        }
        tempDoubleBtnDialog3.showCommonView(string, quantityString, getString(zM80791C0 ? R$string.subscribe_for_save : R$string.temp_backup_save_to_user_space), getString(R$string.cloudbackup_btn_cancel), 1);
    }

    /* renamed from: L4 */
    public final void m20097L4() {
        this.f14480U0.setVisibility(0);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
        m20121m4();
    }

    /* renamed from: M4 */
    public final void m20098M4() {
        Boolean bool = C10153d.m63237a().get(this.f14490e1.m16374c());
        this.f14501p1 = bool != null ? bool.booleanValue() : false;
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
        this.f14479T0.setVisibility(0);
        if (this.f14461A1) {
            return;
        }
        this.f14482W0.setVisibility(0);
    }

    /* renamed from: N4 */
    public final void m20099N4() {
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(0);
        this.f14511z1.setEnabled(false);
        this.f14511z1.setClickable(false);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
        this.f14510y1.setText(getString(R$string.alert_net_disconnect));
        this.f14479T0.setVisibility(8);
        m20121m4();
    }

    /* renamed from: O4 */
    public final void m20100O4() {
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(0);
        this.f14479T0.setVisibility(8);
        m20121m4();
    }

    /* renamed from: P4 */
    public final void m20101P4() {
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(0);
        this.f14504s1.setVisibility(8);
        this.f14479T0.setVisibility(8);
        m20121m4();
    }

    /* renamed from: Q4 */
    public final void m20102Q4() {
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(0);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
        this.f14479T0.setVisibility(8);
        m20121m4();
    }

    /* renamed from: R4 */
    public final void m20103R4(final BackupDetailItem backupDetailItem) {
        boolean zM80811H0 = C13452e.m80781L().m80811H0();
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "showSpaceNotEnoughDialog isHighestGrade " + zM80811H0);
        VerticalBtnAlertDialog verticalBtnAlertDialog = new VerticalBtnAlertDialog(this);
        this.f14494i1 = verticalBtnAlertDialog;
        verticalBtnAlertDialog.m23932m(getString(R$string.space_share_no_space_title));
        this.f14494i1.m23926g(zM80811H0 ? getString(R$string.temp_backup_space_not_enough_deal_des) : getString(R$string.temp_backup_space_not_enough_upgrade_des));
        this.f14494i1.m23930k(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.o4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                CloudSpaceBackupDetailActivity.m20080t4(dialogInterface, i10);
            }
        });
        this.f14494i1.m23928i(getString(R$string.managing_space), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.p4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17700a.m20124u4(dialogInterface, i10);
            }
        });
        if (zM80811H0) {
            this.f14494i1.m23927h(R$drawable.hwbutton_emphasize_emui);
            this.f14494i1.m23929j(R$color.hwbutton_selector_text_emphasize_emui);
        } else {
            this.f14494i1.m23931l(getString(R$string.increase_cloud_space_btn), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.q4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f17707a.m20125v4(backupDetailItem, dialogInterface, i10);
                }
            });
        }
        this.f14494i1.setCancelable(false);
        this.f14494i1.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.activity.r4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                CloudSpaceBackupDetailActivity.m20084w4(dialogInterface);
            }
        });
        if (isFinishing() || isDestroyed() || this.f14494i1.isShowing()) {
            return;
        }
        this.f14494i1.show();
    }

    /* renamed from: S4 */
    public final void m20104S4() {
        this.f14482W0.setVisibility(8);
        this.f14480U0.setVisibility(0);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
    }

    /* renamed from: T4 */
    public final List<AppDetailsInfo> m20105T4(List<AppDetailsInfo> list) {
        List<AppDetailsInfo> arrayList = new ArrayList<>(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator<AppDetailsInfo> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AppDetailsInfo next = it.next();
            if ("thirdAppData".equals(next.getBackupAppName())) {
                arrayList2.addAll(next.getChildList());
                it.remove();
                break;
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.sort(new C3808n4());
        m20111Y3(arrayList);
        return arrayList;
    }

    /* renamed from: U3 */
    public final void m20106U3(List<AppDetailsInfo> list) {
        boolean z10 = false;
        Object obj = this.f14473M1.get(0);
        this.f14472L1.basicItemList = C12547e.m75495e().m75498f();
        if (obj instanceof CloudBackSpaceHeaderBean) {
            ((CloudBackSpaceHeaderBean) obj).basicItemList = C12547e.m75495e().m75498f();
        } else {
            this.f14473M1.add(0, this.f14472L1);
        }
        if (this.f14473M1.size() > 1) {
            List<Object> list2 = this.f14473M1;
            this.f14473M1.removeAll(list2.subList(1, list2.size()));
        }
        if (list != null && !list.isEmpty()) {
            this.f14473M1.addAll(1, m20056d4(list));
            z10 = true;
        }
        this.f14489d1.m25514U(this.f14479T0, z10);
        this.f14489d1.m25503G(this.f14473M1);
        m20098M4();
    }

    /* renamed from: U4 */
    public void m20107U4(List<AppDetailsInfo> list) throws Resources.NotFoundException {
        m20106U3(list);
        AutoSizeButton autoSizeButton = this.f14478S0;
        if (autoSizeButton != null) {
            autoSizeButton.setText(R$string.delete_backup);
            this.f14478S0.setEnabled(true);
            this.f14478S0.setAlpha(1.0f);
        }
        this.f14482W0.setVisibility(0);
        this.f14480U0.setVisibility(8);
        this.f14502q1.setVisibility(8);
        this.f14503r1.setVisibility(8);
        this.f14504s1.setVisibility(8);
        if (this.f14466F1 || !this.f14465E1) {
            return;
        }
        m20096K4(this.f14468H1);
    }

    /* renamed from: V3 */
    public void m20108V3(Runnable runnable) {
        this.f14483X0.add(runnable);
    }

    /* renamed from: W3 */
    public void m20109W3() {
        C13225d.m79490f1().m79585f0("mecloud_backupdetail_delete_cancel", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_delete_cancel", "1", "43");
        this.f14471K1 = false;
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "mecloud_backupdetail_delete_cancel");
    }

    /* renamed from: X3 */
    public final boolean m20110X3(long j10) {
        return C14329v.m85349e0().m85397O(j10);
    }

    /* renamed from: Y3 */
    public final void m20111Y3(List<AppDetailsInfo> list) {
        if (list.isEmpty()) {
            m20094I4(false);
        } else {
            if (!this.f14501p1) {
                m20094I4(true);
                return;
            }
            if ("baseData".equals(list.get(0).getBackupAppName())) {
                list.remove(0);
            }
            m20094I4(list.size() > 0);
        }
    }

    /* renamed from: Z3 */
    public final void m20112Z3() {
        AutoSizeButton autoSizeButton;
        if (this.f14464D1 && (autoSizeButton = this.f14478S0) != null) {
            autoSizeButton.setText(R$string.delete_backup);
            return;
        }
        List<CBSSyncRecordDeviceInfo> listM85419Z = C14329v.m85349e0().m85419Z();
        if (listM85419Z == null) {
            AutoSizeButton autoSizeButton2 = this.f14478S0;
            if (autoSizeButton2 != null) {
                autoSizeButton2.setText(R$string.delete_backup);
                return;
            }
            return;
        }
        if (this.f14500o1) {
            long jM1688f = C0241z.m1688f(C1443a.f6213a);
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "checkDeleteBackupSwitch current appVersion: " + jM1688f);
            this.f14508w1 = m20110X3(jM1688f);
        } else {
            for (CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo : listM85419Z) {
                if (TextUtils.equals(this.f14490e1.m16379h(), cBSSyncRecordDeviceInfo.getDeviceID())) {
                    long jM1689g = C0241z.m1689g(cBSSyncRecordDeviceInfo.getAppVersion(), 0L);
                    C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "checkDeleteBackupSwitch appVersion: " + jM1689g);
                    this.f14508w1 = m20110X3(jM1689g);
                }
            }
        }
        m20122o4();
    }

    /* renamed from: a4 */
    public final void m20113a4() {
        if (this.f14464D1 || this.f14465E1) {
            C11839m.m70689w(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "is temp backup");
        } else {
            C12515a.m75110o().m75172d(new C3243c());
        }
    }

    /* renamed from: b4 */
    public final void m20114b4(BackupDetailItem backupDetailItem) {
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        if (BackupAppEstimateUtil.isSpaceEnoughForBackup(quotaSpaceInfoM80224M.getAvailable(), quotaSpaceInfoM80224M.getTotal(), backupDetailItem.m16382l(), 0L)) {
            m20093H4(backupDetailItem);
        } else {
            m20103R4(backupDetailItem);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14492g1);
        arrayList.add(this.f14481V0);
        return arrayList;
    }

    /* renamed from: f4 */
    public void m20115f4() {
        if (!C0209d.m1333z1(this)) {
            DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f14486a1;
            if (deleteOneDeviceBackupRecordDialog != null) {
                deleteOneDeviceBackupRecordDialog.dismiss();
            }
            DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog2 = this.f14487b1;
            if (deleteOneDeviceBackupRecordDialog2 != null) {
                deleteOneDeviceBackupRecordDialog2.dismiss();
            }
            C11829c.m70612r1(this);
            return;
        }
        if (!this.f14471K1) {
            this.f14471K1 = true;
            this.f14487b1.showBackupDeleteAndClose(true);
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("recommend_card_activity_id", this.f14491f1.getActivityId());
        linkedHashMapM79499C.put("recommend_card_activity_type", this.f14491f1.getActivityType());
        linkedHashMapM79499C.put("recommend_card_entrance", this.f14491f1.getEntrance());
        C13225d.m79490f1().m79591l0("mecloud_backupdetail_delete_done", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_delete_done", "1", "43");
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "mecloud_backupdetail_delete_done");
        BackupDetailItem backupDetailItem = this.f14490e1;
        if (backupDetailItem == null) {
            return;
        }
        String strM16374c = backupDetailItem.m16374c();
        if (this.f14464D1) {
            CloudBackupService.getInstance().deleteSingleTempRecord(strM16374c, this.f14490e1.m16375d(), this.f14500o1, this.f14463C1);
        } else if (this.f14500o1) {
            CloudBackupService.getInstance().deleteDeviceRecord(this.f14484Y0, strM16374c, (this.f14508w1 && this.f14509x1) ? 1 : 0, this.f14463C1, false);
        } else {
            CloudBackupService.getInstance().deleteDeviceRecord(this.f14484Y0, strM16374c, this.f14508w1 ? 1 : 0, this.f14463C1, false);
        }
        this.f14499n1 = System.currentTimeMillis();
        CutOutProgressDialog cutOutProgressDialog = this.f14488c1;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.setMessage(getString(R$string.backup_clean_loading_msg));
            this.f14488c1.setCancelable(false);
            this.f14488c1.show();
        }
        this.f14497l1 = -1;
        Message message = new Message();
        message.what = 33040;
        if (this.f14464D1) {
            message.what = 33049;
            this.f14498m1 = -1;
        }
        CBCallBack.getInstance().sendMessageDelayed(message, 5000L);
    }

    /* renamed from: g4 */
    public final void m20116g4() {
        if (!this.f14464D1) {
            C11842p.m70760Q1(this, this.f14480U0);
        }
        C11842p.m70760Q1(this, this.f14502q1);
        C11842p.m70760Q1(this, this.f14503r1);
        C11842p.m70760Q1(this, this.f14504s1);
    }

    /* renamed from: h4 */
    public final void m20117h4() {
        if (TextUtils.isEmpty(this.f14507v1)) {
            this.f14507v1 = toString();
        }
        C14329v.m85349e0().m85431m0(this.f14500o1, this.f14490e1.m16374c(), this.f14490e1.m16379h(), this.f14507v1);
    }

    /* renamed from: i4 */
    public final void m20118i4() {
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "getCanBeReserveForever");
        C12515a.m75110o().m75172d(new C3244d());
    }

    /* renamed from: k4 */
    public final void m20119k4() {
        Intent intent;
        CloudBackupService.getInstance().register(this.f14475O1);
        this.f14455N0 = new C13998b0();
        try {
            intent = getIntent();
        } catch (RuntimeException e10) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData e = " + e10.getMessage());
            intent = null;
        }
        if (intent == null) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData currentIntent is null");
            return;
        }
        boolean booleanExtra = new SafeIntent(intent).getBooleanExtra("isOnlyHarmonyNext", false);
        this.f14462B1 = booleanExtra;
        this.f14472L1.isOnlyHarmonyNext = booleanExtra;
    }

    /* renamed from: l4 */
    public final void m20120l4() {
        C12515a.m75110o().m75172d(new C3242b());
    }

    /* renamed from: m4 */
    public final void m20121m4() {
        this.f14482W0.setVisibility(8);
    }

    /* renamed from: o4 */
    public final void m20122o4() {
        AutoSizeButton autoSizeButton = this.f14478S0;
        if (autoSizeButton != null) {
            if (this.f14500o1) {
                autoSizeButton.setText((this.f14508w1 && this.f14509x1) ? R$string.remove_from_cloud_space_and_close : R$string.delete_backup);
            } else {
                autoSizeButton.setText(this.f14508w1 ? R$string.remove_from_cloud_space_and_close : R$string.delete_backup);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1004 || i10 == 1002) {
            if (intent == null) {
                return;
            }
            if (new SafeIntent(intent).getBooleanExtra("is_upgrade_success", false)) {
                m20093H4(this.f14490e1);
            }
        }
        if (i10 == 10047 && i11 == 100301 && CBAccess.inRestore()) {
            setResult(C5963j.f27043l);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C12547e.m75495e().m75497c();
        m20034G4();
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (C0209d.m1226Y0()) {
            return;
        }
        m20022T2();
        int id2 = view.getId();
        boolean z10 = false;
        if (id2 == R$id.delete_backup_btn) {
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            BackupDetailItem backupDetailItem = this.f14490e1;
            if (backupDetailItem != null) {
                linkedHashMapM79499C.put("deleteSize", String.valueOf(backupDetailItem.m16382l()));
            }
            C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_delete", linkedHashMapM79499C);
            UBAAnalyze.m29947H("PVC", "mecloud_cloudspace_click_backup_delete", linkedHashMapM79499C);
            String strM80950o = C13452e.m80781L().m80950o();
            if (!C0209d.m1333z1(this)) {
                this.f16192J0.m23919i();
                C11829c.m70612r1(this);
                return;
            }
            if (this.f14464D1) {
                this.f14486a1.show(this.f14485Z0, false);
                return;
            }
            if ((CBAccess.inBackup() || CBAccess.inRestoreWithRetryClearCheck(false)) && !TextUtils.isEmpty(strM80950o) && strM80950o.equals(this.f14484Y0)) {
                m20025W2(R$string.delete_failed_toast);
                C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "delete failed.");
                return;
            }
            boolean z11 = this.f14508w1;
            if (z11) {
                this.f14486a1.showBackupDeleteAndClose(this.f14471K1);
                return;
            }
            if (!this.f14500o1) {
                this.f14486a1.show(this.f14485Z0, z11);
                return;
            }
            DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f14486a1;
            String str = this.f14485Z0;
            if (z11 && this.f14509x1) {
                z10 = true;
            }
            deleteOneDeviceBackupRecordDialog.show(str, z10);
            return;
        }
        if (R$id.app_data_item_rel == id2) {
            Intent intent = new Intent(this, (Class<?>) CloudSpaceBackupAppDetailActivity.class);
            LinkedHashMap linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C2.put("isCurrent", String.valueOf(this.f14500o1));
            C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_app_detail", linkedHashMapM79499C2);
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_backup_app_detail", "1", "81");
            BackupDetailItem backupDetailItem2 = this.f14490e1;
            if (backupDetailItem2 != null) {
                intent.putExtra("deviceId", backupDetailItem2.m16379h());
            }
            intent.putExtra("backup_delete_report_entry", 2);
            intent.putExtra("isSupportsClose", this.f14459R0);
            startActivityForResult(intent, 0);
            return;
        }
        if (R$id.detail_iv == id2) {
            m20024V2(this.f14462B1, false);
            return;
        }
        if (R$id.basic_detail_iv != id2) {
            if (R$id.bt_set_net == id2) {
                C11829c.m70612r1(this);
                return;
            }
            if (R$id.backup_detail_server_error == id2 || R$id.rl_not_connect_column == id2) {
                m20092F4();
                return;
            } else {
                if (R$id.cloudbackup_switch_closed_tips == id2) {
                    m20096K4(this.f14468H1);
                    return;
                }
                return;
            }
        }
        try {
            String string = getString(R$string.manager_basic_system_data_detail, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp"));
            if (view instanceof TipPopupLayout) {
                TipPopupLayout tipPopupLayout = (TipPopupLayout) view;
                this.f14474N1 = tipPopupLayout;
                tipPopupLayout.setTipTxtStr(string);
                this.f14474N1.onClick(view);
            }
        } catch (Exception e10) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "showTipWrap error, e = " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback
    public void onClickNegative(int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.AlertDialogCallback
    public void onClickPositive(String str, boolean z10) {
        int iM25509M;
        AppDetailsInfo appDetailsInfoM25507K;
        int i10;
        C4101g c4101g;
        if (!C0209d.m1333z1(this)) {
            CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = this.f14493h1;
            if (cloudSpaceDeleteModuleDialog != null) {
                cloudSpaceDeleteModuleDialog.dismiss();
            }
            C11829c.m70612r1(this);
            return;
        }
        if (this.f14455N0 == null || this.f14489d1 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (z10) {
            iM25509M = this.f14489d1.m25506J(str);
            appDetailsInfoM25507K = this.f14489d1.m25505I(str);
        } else {
            iM25509M = this.f14489d1.m25509M(str);
            try {
                appDetailsInfoM25507K = this.f14489d1.m25507K(iM25509M);
            } catch (Exception e10) {
                C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "getItem failed, e = " + e10.getMessage());
                appDetailsInfoM25507K = null;
            }
        }
        if (iM25509M == -1 || appDetailsInfoM25507K == null) {
            return;
        }
        long totalSize = appDetailsInfoM25507K.getTotalSize();
        List<AppDetailsInfo> twinAppsList = appDetailsInfoM25507K.getTwinAppsList();
        if (!twinAppsList.isEmpty()) {
            for (AppDetailsInfo appDetailsInfo : twinAppsList) {
                arrayList.add(appDetailsInfo.getBackupAppName());
                totalSize += appDetailsInfo.getTotalSize();
            }
        }
        long j10 = totalSize;
        if (!this.f14501p1 || (c4101g = this.f14489d1) == null) {
            i10 = -1;
        } else {
            int iMo721e = c4101g.mo721e();
            i10 = iMo721e > 0 ? iMo721e - 1 : 0;
        }
        C14329v.m85349e0().m85415X(arrayList, this.f14459R0, this.f14490e1.m16379h(), j10, this.f14463C1, i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14478S0);
        C11842p.m70874v1(this, this.f14505t1);
        m20116g4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        if (C0209d.m1195O(this) >= 1.75f) {
            setContentView(R$layout.cloud_space_backup_detail_activity_font_scale);
        } else {
            setContentView(R$layout.cloud_space_backup_detail_activity);
        }
        C12547e.m75495e().m75497c();
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        this.f14509x1 = zM62388s;
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f14472L1;
        cloudBackSpaceHeaderBean.isBackupSwitchOpen = zM62388s;
        this.f14473M1.add(0, cloudBackSpaceHeaderBean);
        mo19982C1();
        m20127y4();
        m20060g2();
        mo19005p1();
        m22365E1(R$string.cloudbackup_manager_data_title);
        if (this.f14464D1) {
            this.f14478S0.setText(R$string.delete_backup);
            m20104S4();
            m20119k4();
            if (!this.f14465E1) {
                m20118i4();
                m20123p4();
            }
        } else {
            m20065j4();
            m20070n4();
        }
        if (this.f14465E1) {
            m20027A4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f14507v1 == null || C14329v.m85349e0().m85406S0(this.f14507v1)) {
            C14329v.m85349e0().m85395N();
        }
        if (this.f14475O1 != null) {
            CloudBackupService.getInstance().unregister(this.f14475O1);
        }
        m20054c4();
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f14486a1;
        if (deleteOneDeviceBackupRecordDialog != null) {
            deleteOneDeviceBackupRecordDialog.dismiss();
            this.f14486a1 = null;
        }
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog2 = this.f14487b1;
        if (deleteOneDeviceBackupRecordDialog2 != null) {
            deleteOneDeviceBackupRecordDialog2.dismiss();
            this.f14487b1 = null;
        }
        CloudSpaceDeleteModuleDialog cloudSpaceDeleteModuleDialog = this.f14493h1;
        if (cloudSpaceDeleteModuleDialog != null) {
            cloudSpaceDeleteModuleDialog.dismiss();
        }
        VerticalBtnAlertDialog verticalBtnAlertDialog = this.f14494i1;
        if (verticalBtnAlertDialog != null) {
            verticalBtnAlertDialog.dismiss();
        }
        TempDoubleBtnDialog tempDoubleBtnDialog = this.f14495j1;
        if (tempDoubleBtnDialog != null) {
            tempDoubleBtnDialog.dismiss();
        }
        TipPopupLayout tipPopupLayout = this.f14474N1;
        if (tipPopupLayout != null) {
            tipPopupLayout.dismiss();
        }
        this.f14477Q1.removeCallbacksAndMessages(null);
        C12177d.m73274b().m73277d();
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "onDestroy destroyRunnable: " + this.f14483X0.size());
        this.f14483X0.forEach(new C3788l4());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m20034G4();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* renamed from: p4 */
    public final void m20123p4() {
        m20106U3(null);
        if (!C0209d.m1333z1(this)) {
            m20100O4();
            return;
        }
        BackupDetailItem backupDetailItem = this.f14490e1;
        if (backupDetailItem == null || TextUtils.isEmpty(backupDetailItem.m16374c())) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "initData detailItem is null");
            m20101P4();
        } else {
            this.f14484Y0 = this.f14490e1.m16379h();
            this.f14485Z0 = this.f14490e1.m16381j();
            this.f14500o1 = this.f14490e1.m16376e() == 1;
            m20088B4();
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupSpaceDetailAdapter.DeleteBackupModuleListener
    /* renamed from: r0 */
    public void mo20020r0(int i10, String str) {
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "onBasicDeleteBackupModule");
        m20022T2();
        if (C0209d.m1226Y0()) {
            return;
        }
        if (!C0209d.m1333z1(this)) {
            C11829c.m70612r1(this);
            return;
        }
        List<AppDetailsInfo> list = this.f14472L1.basicItemList;
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "basicItemList is empty");
            return;
        }
        try {
            AppDetailsInfo appDetailsInfo = list.get(i10);
            String strM20021S2 = m20021S2(appDetailsInfo.getApkType(), str);
            if (TextUtils.isEmpty(strM20021S2)) {
                strM20021S2 = appDetailsInfo.getPropertiesValue(SnapshotBackupMeta.KEY_STRING_APP_NAME);
            }
            m20095J4(i10, str, strM20021S2, appDetailsInfo, true);
        } catch (Exception e10) {
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "showDeleteModuleDialog failed, e: " + e10.getMessage());
        }
    }

    /* renamed from: u4 */
    public final /* synthetic */ void m20124u4(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "manager space");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_backup_detail", linkedHashMapM79497A);
        Intent intent = new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class);
        C13230i.m79525e1(intent, "4", "43");
        intent.putExtra("is_from_main_activity", false);
        C10342a.m63676b(this, intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m20034G4();
        return true;
    }

    /* renamed from: v4 */
    public final /* synthetic */ void m20125v4(BackupDetailItem backupDetailItem, DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "go upgrade");
        C13225d.m79490f1().m79567R("event_id_temp_backup_save_no_enough_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "event_id_temp_backup_save_no_enough_dialog", "4", "is_backup_detail", linkedHashMapM79497A);
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 13);
        bundle.putString("page_detail", TempBackupCheckActivity.class.getName());
        bundle.putLong("need_extra_space", backupDetailItem.m16382l());
        C12126b.m72706b(this, C13222a.m79465g(this), bundle, true, 1002);
    }

    /* renamed from: x4 */
    public final void m20126x4() {
        C14318k c14318kM85425d0 = C14329v.m85349e0().m85425d0();
        if (c14318kM85425d0 == null) {
            return;
        }
        List<CBSSyncRecordDeviceInfo> listM85326c = c14318kM85425d0.m85326c();
        this.f14496k1 = listM85326c;
        if (this.f14500o1) {
            long jM1688f = C0241z.m1688f(C1443a.f6213a);
            C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "current appVersion: " + jM1688f);
            if (jM1688f >= 110107100) {
                this.f14459R0 = true;
                return;
            }
            return;
        }
        if (listM85326c == null) {
            return;
        }
        for (CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo : listM85326c) {
            if (TextUtils.equals(this.f14490e1.m16379h(), cBSSyncRecordDeviceInfo.getDeviceID())) {
                long jM1689g = C0241z.m1689g(cBSSyncRecordDeviceInfo.getAppVersion(), 0L);
                C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "appVersion: " + jM1689g);
                if (String.valueOf(jM1689g).startsWith("11")) {
                    if (jM1689g >= 110107100) {
                        this.f14459R0 = true;
                        return;
                    }
                } else if (jM1689g >= 101117100) {
                    this.f14459R0 = true;
                    return;
                }
            }
        }
    }

    /* renamed from: y4 */
    public final void m20127y4() {
        Intent intent;
        try {
            intent = getIntent();
        } catch (RuntimeException e10) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "needShowTemp e : " + e10.getMessage());
            intent = null;
        }
        if (intent == null) {
            C11839m.m70687e(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "needShowTemp currentIntent is null");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        this.f14464D1 = safeIntent.getBooleanExtra("isTempBackup", false);
        boolean booleanExtra = safeIntent.getBooleanExtra("isFromNotifyTemp", false);
        this.f14465E1 = booleanExtra;
        if (booleanExtra) {
            this.f14464D1 = true;
            this.f14466F1 = safeIntent.getBooleanExtra(GeneralRedirectUtil.IS_DELETE, false);
        }
        BackupDetailItem backupDetailItem = (BackupDetailItem) safeIntent.getParcelableExtra("backup_item_param");
        this.f14490e1 = backupDetailItem;
        if (backupDetailItem == null) {
            BackupDetailItem backupDetailItem2 = new BackupDetailItem();
            this.f14490e1 = backupDetailItem2;
            backupDetailItem2.m16384n(safeIntent.getStringExtra("deviceId"));
            this.f14490e1.m16385o(safeIntent.getStringExtra(GeneralRedirectUtil.BAK_ID));
        }
        this.f14463C1 = safeIntent.getIntExtra("backup_delete_report_entry", 0);
        String stringExtra = safeIntent.getStringExtra("terminalType");
        this.f14470J1 = stringExtra;
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f14472L1;
        BackupDetailItem backupDetailItem3 = this.f14490e1;
        cloudBackSpaceHeaderBean.detailItem = backupDetailItem3;
        cloudBackSpaceHeaderBean.isTempBackup = this.f14464D1;
        cloudBackSpaceHeaderBean.isFromNotifyTemp = this.f14465E1;
        cloudBackSpaceHeaderBean.isDelete = this.f14466F1;
        backupDetailItem3.m16371L(stringExtra);
        C11839m.m70688i(GeneralRedirectUtil.TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME, "isDelete:" + this.f14466F1 + ",isFromNotifyTemp:" + this.f14465E1);
    }

    /* renamed from: z4 */
    public final void m20128z4() {
        C12515a.m75110o().m75175e(new C12178e(this.f14477Q1, 0), false);
    }
}
