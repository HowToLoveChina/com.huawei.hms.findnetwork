package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import aq.C1011a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudBackupRecordsAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RefurbishedBackupRecordSelectDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p336he.C10155f;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p815ym.AbstractC14026a;
import pm.C12179f;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupRecordsActivity extends CloudBackupBaseUiActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: A0 */
    public TextView f13981A0;

    /* renamed from: B0 */
    public String f13982B0;

    /* renamed from: C */
    public int f13983C;

    /* renamed from: C0 */
    public String f13984C0;

    /* renamed from: D0 */
    public long f13986D0;

    /* renamed from: E0 */
    public boolean f13988E0;

    /* renamed from: F */
    public CloudBackupRecordsAdapter f13989F;

    /* renamed from: G */
    public CloudBackupRecordsAdapter f13991G;

    /* renamed from: H */
    public CloudBackupRecordsAdapter f13992H;

    /* renamed from: I */
    public NotchFitLinearLayout f13993I;

    /* renamed from: J */
    public ScrollView f13994J;

    /* renamed from: K */
    public NotchFitLinearLayout f13995K;

    /* renamed from: L */
    public TextView f13996L;

    /* renamed from: M */
    public NotchFitLinearLayout f13997M;

    /* renamed from: N */
    public NotchFitLinearLayout f13998N;

    /* renamed from: O */
    public TextView f13999O;

    /* renamed from: P */
    public TextView f14000P;

    /* renamed from: Q */
    public List<CloudRecoveryItem> f14001Q;

    /* renamed from: R */
    public List<CloudRecoveryItem> f14002R;

    /* renamed from: S */
    public List<CloudRecoveryItem> f14003S;

    /* renamed from: V */
    public LinearLayout f14006V;

    /* renamed from: W */
    public LinearLayout f14007W;

    /* renamed from: X */
    public LinearLayout f14008X;

    /* renamed from: Y */
    public RelativeLayout f14009Y;

    /* renamed from: Z */
    public NotchFitLinearLayout f14010Z;

    /* renamed from: a0 */
    public NotchFitLinearLayout f14011a0;

    /* renamed from: b0 */
    public NotchFitLinearLayout f14012b0;

    /* renamed from: d0 */
    public String f14014d0;

    /* renamed from: e0 */
    public boolean f14015e0;

    /* renamed from: f0 */
    public RefurbishedBackupRecordSelectDialog f14016f0;

    /* renamed from: h0 */
    public CloudBackupDeviceInfo f14018h0;

    /* renamed from: i0 */
    public boolean f14019i0;

    /* renamed from: j0 */
    public String f14020j0;

    /* renamed from: k0 */
    public String f14021k0;

    /* renamed from: l0 */
    public int f14022l0;

    /* renamed from: m0 */
    public int f14023m0;

    /* renamed from: n0 */
    public boolean f14024n0;

    /* renamed from: o0 */
    public String f14025o0;

    /* renamed from: p0 */
    public AutoSizeButton f14026p0;

    /* renamed from: q0 */
    public boolean f14027q0;

    /* renamed from: r0 */
    public DeleteOneDeviceBackupRecordDialog f14028r0;

    /* renamed from: s0 */
    public CutOutProgressDialog f14029s0;

    /* renamed from: u0 */
    public View f14031u0;

    /* renamed from: v0 */
    public C12526j f14032v0;

    /* renamed from: w0 */
    public SpanClickText f14033w0;

    /* renamed from: x0 */
    public AlertDialog f14034x0;

    /* renamed from: D */
    public String f13985D = "";

    /* renamed from: E */
    public int f13987E = 0;

    /* renamed from: T */
    public ArrayList<CloudRecoveryItem> f14004T = new ArrayList<>();

    /* renamed from: U */
    public ArrayList<CloudRecoveryItem> f14005U = new ArrayList<>();

    /* renamed from: c0 */
    public boolean f14013c0 = false;

    /* renamed from: g0 */
    public boolean f14017g0 = false;

    /* renamed from: t0 */
    public long f14030t0 = 0;

    /* renamed from: y0 */
    public boolean f14035y0 = false;

    /* renamed from: z0 */
    public final Handler.Callback f14036z0 = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.o2
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17690a.m19372K2(message);
        }
    };

    /* renamed from: F0 */
    public Handler f13990F0 = new HandlerC3182a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity$a */
    public class HandlerC3182a extends Handler {
        public HandlerC3182a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            CloudBackupRecordsActivity.this.m19374P2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity$b */
    public class C3183b implements DeleteOneDeviceBackupRecordDialog.ClickCallback {
        public C3183b() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onCancelDelete() {
            CloudBackupRecordsActivity.this.m19393l2();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onDeleteConfirmed() {
            CloudBackupRecordsActivity.this.m19396p2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity$c */
    public class C3184c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ TextView f14039a;

        public C3184c(TextView textView) {
            this.f14039a = textView;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Resources.NotFoundException, C9721b {
            int iM1686d = C0241z.m1686d(C10155f.m63283g("bs.userdata.overdue.days"), 30);
            final int iM1685c = C0241z.m1685c(C10155f.m63283g("bs.userdata.remain.dwnldDays"));
            C11839m.m70688i("CloudBackupRecordsActivity", "overdueDays: " + iM1686d + " ,remainDays: " + iM1685c);
            final String quantityString = CloudBackupRecordsActivity.this.getResources().getQuantityString(R$plurals.common_days, iM1686d, Integer.valueOf(iM1686d));
            final String string = (iM1685c <= 0 || C13452e.m80781L().m80823K0()) ? CloudBackupRecordsActivity.this.getString(R$string.backup_base_data_overdue) : CloudBackupRecordsActivity.this.getResources().getQuantityString(R$plurals.cloudpay_remain_days, iM1685c, C1011a.m6163c(Integer.valueOf(iM1685c)));
            final TextView textView = this.f14039a;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.u2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17753a.m19432d(textView, quantityString, string, iM1685c);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m19432d(TextView textView, String str, String str2, int i10) {
            textView.setText(CloudBackupRecordsActivity.this.getString(R$string.restore_history_page_description_single, str, str2));
            if (i10 <= 0 || C13452e.m80781L().m80823K0()) {
                textView.setTextColor(CloudBackupRecordsActivity.this.getColor(R$color.hicloud_exception_bg_title_color));
            } else {
                textView.setTextColor(CloudBackupRecordsActivity.this.getColor(R$color.CS_black_60_percent));
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity$d */
    public class C3185d implements RefurbishedBackupRecordSelectDialog.SelectDialogClickCallback {

        /* renamed from: a */
        public final /* synthetic */ int f14041a;

        public C3185d(int i10) {
            this.f14041a = i10;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishedBackupRecordSelectDialog.SelectDialogClickCallback
        public void onGoToRestore(CloudRecoveryItem cloudRecoveryItem) {
            if (CloudBackupRecordsActivity.this.f14016f0 != null) {
                CloudBackupRecordsActivity.this.f14016f0.dismiss();
            }
            CloudBackupRecordsActivity.this.m19425t2(cloudRecoveryItem, this.f14041a);
        }
    }

    /* renamed from: A2 */
    public static boolean m19367A2() {
        return C10028c.m62182c0().m62388s("backup_key");
    }

    /* renamed from: G2 */
    public static /* synthetic */ void m19369G2(Set set, CloudRecoveryItem cloudRecoveryItem) {
        set.add(cloudRecoveryItem.getDeviceIdd());
    }

    /* renamed from: H2 */
    public static /* synthetic */ void m19370H2(Set set, CloudRecoveryItem cloudRecoveryItem) {
        set.add(cloudRecoveryItem.getDeviceIdd());
    }

    /* renamed from: I2 */
    public static /* synthetic */ void m19371I2(Set set, CloudRecoveryItem cloudRecoveryItem) {
        set.add(cloudRecoveryItem.getDeviceIdd());
    }

    /* renamed from: K2 */
    public /* synthetic */ boolean m19372K2(Message message) {
        int i10 = message.what;
        if (i10 == 32315) {
            if (message.arg1 == 0) {
                CloudBackupService.getInstance().getState();
                this.f13987E = 0;
                this.f14035y0 = true;
                m19411V2(message);
            } else if (this.f13987E < 2) {
                m19406Q2();
                this.f13987E++;
                C11839m.m70688i("CloudBackupRecordsActivity", "query records retryTimes = " + this.f13987E);
            } else {
                C11839m.m70688i("CloudBackupRecordsActivity", "query records failed");
                if (C0209d.m1333z1(this)) {
                    m19237Q1(R$string.recovery_no_data_server_error);
                } else {
                    C11839m.m70688i("CloudBackupRecordsActivity", "net disconnected");
                    m19239S1();
                }
            }
        } else if (i10 == 33052) {
            boolean z10 = !AbstractC14026a.m84159a(this.f14001Q);
            boolean z11 = !AbstractC14026a.m84159a(this.f14002R);
            if (z10) {
                this.f13989F.m24913h(this.f14004T);
                this.f13995K.setVisibility(0);
            }
            if (z11) {
                this.f13991G.m24913h(this.f14005U);
                this.f13997M.setVisibility(0);
            }
            if (this.f14035y0) {
                mo19236O1();
            }
        } else if (i10 == 3214) {
            C12590s0.m75755I0(C0213f.m1377a(), message.obj.toString());
        } else if (32309 == i10) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f14030t0;
            int i11 = message.arg1;
            if (i11 == 0) {
                this.f14024n0 = true;
                this.f14023m0 = 0;
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("deleteTime", String.valueOf(jCurrentTimeMillis));
                linkedHashMapM79499C.put(FamilyShareConstants.ENTRY_TYPE, String.valueOf(this.f13983C));
                C13225d.m79490f1().m79591l0("mecloud_ backupdetail_delete_success", linkedHashMapM79499C);
                UBAAnalyze.m29954O("PVC", "mecloud_ backupdetail_delete_success", "1", "43");
                if (this.f14019i0) {
                    BackupNotification.getInstance().cancelBackupNotification();
                }
                C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.android.intent.action.CLOUD_BACKUP_DELETE"));
                C11839m.m70688i("CloudBackupRecordsActivity", "delete success.");
            } else {
                this.f14023m0 = i11;
                LinkedHashMap linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C2.put("deleteTime", String.valueOf(jCurrentTimeMillis));
                linkedHashMapM79499C2.put(FamilyShareConstants.ENTRY_TYPE, String.valueOf(this.f13983C));
                C13225d.m79490f1().m79591l0("mecloud_ backupdetail_delete_failed", linkedHashMapM79499C2);
                UBAAnalyze.m29954O("PVC", "mecloud_ backupdetail_delete_failed", "1", "43");
                C11839m.m70688i("CloudBackupRecordsActivity", "delete failed (others).");
            }
        } else if (33047 == i10) {
            Message message2 = new Message();
            message2.what = 32309;
            message2.arg1 = 0;
            CBCallBack.getInstance().sendMessage(message2);
        } else if (33040 == i10) {
            m19395o2();
            int i12 = this.f14023m0;
            if (i12 == 0) {
                setResult(101, getIntent());
                finish();
            } else if (i12 == 1) {
                C11841o.m70707c(this, R$string.delete_failed_toast, 0);
            } else if (i12 == 2) {
                C11841o.m70707c(this, R$string.delete_backup_record_failed, 0);
            } else if (i12 == 3) {
                C11841o.m70707c(this, R$string.delete_backup_record_service_failed, 0);
            } else {
                finish();
            }
        }
        return false;
    }

    /* renamed from: O2 */
    private void m19373O2() {
        if ("myHuawei".equals(this.f14014d0) && !this.f14015e0) {
            moveTaskToBack(true);
        } else if (1 == this.f13983C) {
            setResult(2);
            finish();
        } else {
            setResult(1);
            finish();
        }
    }

    /* renamed from: P2 */
    public void m19374P2() {
        m19427w2();
        m19407R2();
        C10028c.m62182c0().m62323f(new HiCloudSafeIntent(getIntent()));
    }

    /* renamed from: e3 */
    private void m19387e3() {
        m19238R1();
        C12515a.m75110o().m75172d(new C12179f(C11058a.m66627b("02304"), this.f13990F0));
    }

    /* renamed from: l2 */
    public void m19393l2() {
        m19395o2();
        m19394n2();
    }

    /* renamed from: n2 */
    private void m19394n2() {
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f14028r0;
        if (deleteOneDeviceBackupRecordDialog != null) {
            deleteOneDeviceBackupRecordDialog.dismiss();
        }
    }

    /* renamed from: o2 */
    private void m19395o2() {
        CutOutProgressDialog cutOutProgressDialog = this.f14029s0;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
        }
    }

    /* renamed from: p2 */
    public void m19396p2() {
        if (!C0209d.m1333z1(this)) {
            m19394n2();
            C11829c.m70612r1(this);
            return;
        }
        RecommendCardReport recommendCardReport = new RecommendCardReport();
        C2783d.m16191y0(recommendCardReport, getIntent());
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("recommend_card_activity_id", recommendCardReport.getActivityId());
        linkedHashMapM79499C.put("recommend_card_activity_type", recommendCardReport.getActivityType());
        linkedHashMapM79499C.put("recommend_card_entrance", recommendCardReport.getEntrance());
        linkedHashMapM79499C.put(FamilyShareConstants.ENTRY_TYPE, String.valueOf(this.f13983C));
        C13225d.m79490f1().m79591l0("mecloud_backupdetail_delete_done", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_delete_done", "1", "43");
        C11839m.m70688i("CloudBackupRecordsActivity", "mecloud_backupdetail_delete_done");
        String str = this.f14021k0;
        if (this.f13988E0) {
            CloudRecoveryItem cloudRecoveryItem = this.f14001Q.get(0);
            CloudBackupService.getInstance().deleteSingleTempRecord(cloudRecoveryItem.getBackupDeviceId(), cloudRecoveryItem.getBackupId(), this.f14019i0, 1);
        } else if (this.f14019i0) {
            CloudBackupService.getInstance().deleteDeviceRecord(this.f14025o0, str, 1, this.f13983C, true);
        } else {
            CloudBackupService cloudBackupService = CloudBackupService.getInstance();
            String str2 = this.f14025o0;
            boolean z10 = this.f14027q0;
            cloudBackupService.deleteDeviceRecord(str2, str, z10 ? 1 : 0, this.f13983C, false);
        }
        this.f14030t0 = System.currentTimeMillis();
        CutOutProgressDialog cutOutProgressDialog = this.f14029s0;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.setMessage(getString(R$string.backup_clean_loading_msg));
            this.f14029s0.setCancelable(false);
            this.f14029s0.show();
        }
        this.f14023m0 = -1;
        Message message = new Message();
        message.what = 33040;
        CBCallBack.getInstance().sendMessageDelayed(message, 5000L);
    }

    /* renamed from: u2 */
    public static boolean m19397u2(CloudRecoveryItem cloudRecoveryItem) {
        return cloudRecoveryItem.getBmDataType() == 2 || cloudRecoveryItem.getBmDataType() == 3 || cloudRecoveryItem.getBmDataType() == 0;
    }

    /* renamed from: B2 */
    public boolean m19398B2() {
        Iterator<CloudRecoveryItem> it = this.f14001Q.iterator();
        while (it.hasNext()) {
            if (m19397u2(it.next())) {
                return false;
            }
        }
        Iterator<CloudRecoveryItem> it2 = this.f14002R.iterator();
        while (it2.hasNext()) {
            if (m19397u2(it2.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: C2 */
    public final /* synthetic */ boolean m19399C2(CloudRecoveryItem cloudRecoveryItem) {
        return !TextUtils.isEmpty(this.f14021k0) ? this.f14021k0.equals(cloudRecoveryItem.getBackupDeviceId()) : cloudRecoveryItem.isCurrent();
    }

    /* renamed from: D2 */
    public final /* synthetic */ void m19400D2(CloudRecoveryItem cloudRecoveryItem, int i10, DialogInterface dialogInterface, int i11) {
        m19425t2(cloudRecoveryItem, i10);
    }

    /* renamed from: F2 */
    public final /* synthetic */ void m19401F2(DialogInterface dialogInterface, int i10) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("CloudBackupRecordsActivity", "link click to fast");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "upgrade membership services");
        C13225d.m79490f1().m79567R("action_record_notification_delete_data_remind", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_record_notification_delete_data_remind", "4", "30", linkedHashMapM79497A);
        m19420k2();
    }

    /* renamed from: J2 */
    public final /* synthetic */ void m19402J2(Bundle bundle) {
        this.f14018h0 = (CloudBackupDeviceInfo) bundle.getParcelable("cloudBackupDeviceInfo");
    }

    /* renamed from: M2 */
    public final /* synthetic */ void m19404M2() {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("CloudBackupRecordsActivity", "link click to fast");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("event", "upgrade now");
        C13225d.m79490f1().m79567R("action_record_notification_delete_data_remind", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_record_notification_delete_data_remind", "1", "30", linkedHashMapM79497A);
        m19420k2();
    }

    /* renamed from: N2 */
    public final boolean m19405N2() {
        return !TextUtils.isEmpty(this.f14021k0) || 5 == this.f13983C;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity
    /* renamed from: O1 */
    public void mo19236O1() {
        super.mo19236O1();
        this.f13994J.setVisibility(0);
    }

    /* renamed from: Q2 */
    public final void m19406Q2() {
        C11839m.m70688i("CloudBackupRecordsActivity", "queryCloudBackupRecords start");
        CloudBackupService.getInstance().showRecords(this.f14019i0, this.f13983C == 3, this.f14025o0);
    }

    /* renamed from: R2 */
    public final void m19407R2() {
        String action = new SafeIntent(getIntent()).getAction();
        if (action == null || !action.equals("restore_notify_click")) {
            return;
        }
        this.f14013c0 = true;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("notify_time", String.valueOf(RestoreNotifyUtil.getInstance().getNotifiedCount(this)));
        C13225d.m79490f1().m79567R("restore_notify_click", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "restore_notify_click", linkedHashMap);
    }

    /* renamed from: S2 */
    public void m19408S2() {
        if (this.f13983C != 1 && C13452e.m80781L().m80887a1()) {
            ArrayList<CloudRecoveryItem> arrayList = new ArrayList();
            List<CloudRecoveryItem> list = this.f14001Q;
            if (list != null) {
                arrayList.addAll(list);
            }
            List<CloudRecoveryItem> list2 = this.f14002R;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            List<CloudRecoveryItem> list3 = this.f14003S;
            if (list3 != null) {
                arrayList.addAll(list3);
            }
            int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
            boolean zM19398B2 = m19398B2();
            for (CloudRecoveryItem cloudRecoveryItem : arrayList) {
                if (!cloudRecoveryItem.isRefurbishment()) {
                    cloudRecoveryItem.getBackupRecordLabel();
                }
                cloudRecoveryItem.getBackupRecordLabel();
                cloudRecoveryItem.getBackupRecordLabel();
                boolean z10 = cloudRecoveryItem.isTempBackup() && cloudRecoveryItem.getOccupySpaceType() != 1;
                boolean z11 = iM81077e != 1;
                if (cloudRecoveryItem.isRefurbishment() || z10 || z11 || zM19398B2) {
                    this.f14033w0.setVisibility(8);
                } else {
                    this.f14033w0.setVisibility(0);
                }
            }
            if (zM19398B2 || iM81077e == 1) {
                this.f13981A0.setVisibility(8);
            }
        }
    }

    /* renamed from: T2 */
    public final void m19409T2() {
        C11839m.m70688i("CloudBackupRecordsActivity", "setServiceExpirationTips");
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.j2
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17645a.m19404M2();
            }
        };
        String string = getString(R$string.cloudpay_subscribe_now);
        this.f14033w0.m15931c(string, iSpanClickListener);
        this.f14033w0.m15934g(getString(R$string.service_expiration_tip, string), false);
    }

    /* renamed from: U2 */
    public final void m19410U2() {
        String string = this.f13982B0;
        if (!C13452e.m80781L().m80791C0() || TextUtils.isEmpty(string)) {
            m22365E1(R$string.backup_manager_cloudbackup);
        } else {
            if (this.f14019i0) {
                string = getString(R$string.cloudbackup_self_device_new_update, string);
            }
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setTitle(string);
            }
        }
        if (this.f13988E0) {
            this.f13981A0.setVisibility(8);
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            if (this.f13983C == 1) {
                this.f13981A0.setVisibility(8);
            } else if (!C13452e.m80781L().m80791C0()) {
                this.f13981A0.setVisibility(8);
            } else {
                this.f13981A0.setVisibility(0);
                m19429y2(this.f13981A0);
            }
        }
    }

    /* renamed from: V2 */
    public final void m19411V2(Message message) {
        Bundle data = message.getData();
        if (data == null) {
            mo19229P1(R$string.current_device_no_backup_records, R$drawable.pay_sync_nodata);
            return;
        }
        if (!C0209d.m1333z1(this)) {
            m19239S1();
            return;
        }
        if (this.f13988E0) {
            this.f14001Q = data.getParcelableArrayList("tempBackup");
        } else {
            this.f14001Q = data.getParcelableArrayList("latest");
            this.f14002R = data.getParcelableArrayList("oldest");
            this.f14003S = data.getParcelableArrayList("refurbishment");
        }
        this.f14027q0 = data.getBoolean("isSupportCloseBackup");
        C11839m.m70688i("CloudBackupRecordsActivity", "showBackupRecordList isTempBackup: " + this.f13988E0);
        List<CloudRecoveryItem> list = this.f14001Q;
        if (list != null) {
            this.f14022l0 += list.size();
            if (m19405N2()) {
                this.f14001Q = m19422q2(this.f14001Q);
            }
            C11839m.m70688i("CloudBackupRecordsActivity", "latestRecords length: " + this.f14001Q.size());
        } else {
            C11839m.m70688i("CloudBackupRecordsActivity", "latestRecords is null");
        }
        List<CloudRecoveryItem> list2 = this.f14002R;
        if (list2 != null) {
            this.f14022l0 += list2.size();
            if (m19405N2()) {
                this.f14002R = m19422q2(this.f14002R);
            }
            C11839m.m70688i("CloudBackupRecordsActivity", "oldestRecords length: " + this.f14002R.size());
        } else {
            C11839m.m70688i("CloudBackupRecordsActivity", "oldestRecords is null");
        }
        List<CloudRecoveryItem> list3 = this.f14003S;
        if (list3 != null) {
            this.f14022l0 += list3.size();
            if (m19405N2()) {
                this.f14003S = m19422q2(this.f14003S);
            }
            C11839m.m70688i("CloudBackupRecordsActivity", "refurbishmentRecords length: " + this.f14003S.size());
        } else {
            C11839m.m70688i("CloudBackupRecordsActivity", "refurbishmentRecords is null");
        }
        m19408S2();
        m19415Z2();
        m19412W2(this.f14027q0);
    }

    /* renamed from: W2 */
    public final void m19412W2(boolean z10) {
        if (this.f13983C != 3) {
            this.f14031u0.setVisibility(8);
            return;
        }
        this.f14031u0.setVisibility(0);
        AutoSizeButton autoSizeButton = this.f14026p0;
        if (autoSizeButton == null) {
            return;
        }
        if (this.f13988E0) {
            autoSizeButton.setText(R$string.delete_backup);
            return;
        }
        if (!this.f14019i0) {
            autoSizeButton.setText(z10 ? R$string.backup_delete_and_close : R$string.delete_backup);
            return;
        }
        boolean zM19367A2 = m19367A2();
        C11839m.m70688i("CloudBackupRecordsActivity", "showBaseDeleteBtn isBackupSwitchOpen: " + zM19367A2 + " ,isSupportCloseBackup: " + z10);
        this.f14026p0.setText((z10 && zM19367A2) ? R$string.backup_delete_and_close : R$string.delete_backup);
    }

    /* renamed from: X2 */
    public final void m19413X2(boolean z10, boolean z11) {
        m19414Y2(z10, z11);
        m19416a3(z11);
        C11839m.m70688i("CloudBackupRecordsActivity", "queryRecordsCompatibility start ");
        CloudBackupService.getInstance().queryRecordsCompatibility(this.f14001Q, this.f14002R);
    }

    /* renamed from: Y2 */
    public final void m19414Y2(boolean z10, boolean z11) {
        C11839m.m70688i("CloudBackupRecordsActivity", "showLatestView hasLatest: " + z10 + ", hasOldest: " + z11 + ", entryType: " + this.f13983C);
        if (!z10) {
            C12809f.m76829b(this, R$id.tv_latest_title).setVisibility(8);
            C12809f.m76829b(this, R$id.latest_show_all_records).setVisibility(8);
            C12809f.m76829b(this, R$id.latest_records_list_view).setVisibility(8);
            return;
        }
        this.f14004T = new ArrayList<>();
        if (z11 || this.f14001Q.size() <= 1 || 1 != this.f13983C) {
            this.f13996L.setVisibility(8);
            this.f14004T.addAll(this.f14001Q);
        } else {
            this.f14004T.add(this.f14001Q.get(0));
            this.f13996L.setVisibility(0);
        }
        if (this.f14001Q != null) {
            C11839m.m70688i("CloudBackupRecordsActivity", "latestRecords length: " + this.f14001Q.size());
        }
    }

    /* renamed from: Z2 */
    public final void m19415Z2() {
        List<CloudRecoveryItem> list = this.f14001Q;
        boolean z10 = false;
        boolean z11 = (list == null || list.isEmpty()) ? false : true;
        List<CloudRecoveryItem> list2 = this.f14002R;
        boolean z12 = (list2 == null || list2.isEmpty()) ? false : true;
        List<CloudRecoveryItem> list3 = this.f14003S;
        if (list3 != null && !list3.isEmpty()) {
            z10 = true;
        }
        C11839m.m70688i("CloudBackupRecordsActivity", "showListView hasLatest: " + z11 + ", hasOldest: " + z12 + ", hasRefurbishment: " + z10);
        if (!z11 && !z12 && !z10) {
            mo19229P1(R$string.current_device_no_backup_records, R$drawable.pay_sync_nodata);
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            m19419d3(z10);
        } else {
            this.f13998N.setVisibility(8);
        }
        m19413X2(z11, z12);
    }

    /* renamed from: a3 */
    public final void m19416a3(boolean z10) {
        CloudRecoveryItem next;
        if (!z10) {
            this.f13997M.setVisibility(8);
            return;
        }
        this.f14005U = new ArrayList<>();
        if (this.f14002R.size() <= 1 || 1 != this.f13983C) {
            this.f13999O.setVisibility(8);
            this.f14005U.addAll(this.f14002R);
            return;
        }
        String str = C11842p.m70762R0() ? "pad" : "phone";
        Iterator<CloudRecoveryItem> it = this.f14002R.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (!str.equals(next.getDeviceCategory())) {
                    break;
                }
            }
        }
        if (next == null) {
            next = this.f14002R.get(0);
        }
        this.f14005U.add(next);
        this.f13999O.setVisibility(0);
    }

    /* renamed from: b3 */
    public final void m19417b3() {
        if (this.f14018h0 == null) {
            C11839m.m70689w("CloudBackupRecordsActivity", "showPageFromOOBE error,deviceInfoFromIntent is null");
            m19415Z2();
            return;
        }
        C11839m.m70688i("CloudBackupRecordsActivity", "receive data from oobe,device Info is not null.");
        List<CloudRecoveryItem> recoveryItems = this.f14018h0.getRecoveryItems();
        if (AbstractC14026a.m84159a(recoveryItems)) {
            C11839m.m70688i("CloudBackupRecordsActivity", "recoveryItemList is empty.");
            m19415Z2();
            return;
        }
        Collections.sort(recoveryItems);
        this.f14001Q = new ArrayList();
        this.f14002R = new ArrayList();
        this.f14003S = new ArrayList();
        for (CloudRecoveryItem cloudRecoveryItem : recoveryItems) {
            if (TextUtils.isEmpty(cloudRecoveryItem.getBackupDeviceId()) && !TextUtils.isEmpty(this.f14021k0)) {
                cloudRecoveryItem.setBackupDeviceId(this.f14021k0);
            }
            if (C13452e.m80781L().m80887a1() && cloudRecoveryItem.isRefurbishment()) {
                this.f14003S.add(cloudRecoveryItem);
            } else {
                C11839m.m70688i("CloudBackupRecordsActivity", "before add recovery item latesRecords length: " + this.f14001Q.size() + ", isCompleted: " + cloudRecoveryItem.isBackupCompleted());
                if (this.f14001Q.isEmpty() && cloudRecoveryItem.isBackupCompleted()) {
                    this.f14001Q.add(cloudRecoveryItem);
                } else if (cloudRecoveryItem.isBackupCompleted()) {
                    this.f14002R.add(cloudRecoveryItem);
                }
            }
        }
        m19408S2();
        if (recoveryItems.size() > 1 || C12590s0.m75854g2(recoveryItems)) {
            C11839m.m70688i("CloudBackupRecordsActivity", "initData,recoveryItemList size > 1 or has one harmony record");
            m19415Z2();
        } else {
            C11839m.m70688i("CloudBackupRecordsActivity", "initData,recoveryItemList size == 1 and not harmony record");
            m19425t2(recoveryItems.get(0), 1);
            finish();
        }
    }

    /* renamed from: c3 */
    public final void m19418c3(CloudRecoveryItem cloudRecoveryItem, int i10) {
        if (this.f14016f0 == null) {
            this.f14016f0 = new RefurbishedBackupRecordSelectDialog(this, new C3185d(i10));
        }
        this.f14016f0.setRecoveryItem(cloudRecoveryItem);
        this.f14016f0.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        arrayList.add(this.f13995K);
        arrayList.add(this.f13997M);
        arrayList.add(this.f13998N);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m19419d3(boolean z10) {
        CloudRecoveryItem next;
        if (!z10) {
            this.f13998N.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f14003S.size() <= 1 || 1 != this.f13983C) {
            this.f14000P.setVisibility(8);
            arrayList.addAll(this.f14003S);
        } else {
            String str = C11842p.m70762R0() ? "pad" : "phone";
            Iterator<CloudRecoveryItem> it = this.f14003S.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (!str.equals(next.getDeviceCategory())) {
                        break;
                    }
                }
            }
            if (next == null) {
                next = this.f14003S.get(0);
            }
            arrayList.add(next);
            this.f14000P.setVisibility(0);
        }
        this.f13992H.m24913h(arrayList);
        this.f13998N.setVisibility(0);
    }

    /* renamed from: k2 */
    public final void m19420k2() {
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 20);
        C13230i.m79522d1(bundle, "1", "action_record_notification_delete_data_remind");
        C12126b.m72707c(C13222a.m79465g(this), bundle);
    }

    /* renamed from: m2 */
    public final void m19421m2(View view) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(FamilyShareConstants.ENTRY_TYPE, String.valueOf(this.f13983C));
        C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_delete", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "mecloud_cloudspace_click_backup_delete", linkedHashMapM79499C);
        String strM80950o = C13452e.m80781L().m80950o();
        if (!C0209d.m1333z1(this)) {
            C11829c.m70612r1(this);
            return;
        }
        boolean z10 = false;
        if ((CBAccess.inBackup() || CBAccess.inRestore()) && !TextUtils.isEmpty(strM80950o) && strM80950o.equals(this.f14025o0)) {
            C11841o.m70707c(this, R$string.delete_failed_toast, 0);
            C11839m.m70688i("CloudBackupRecordsActivity", "delete failed.");
            return;
        }
        if (this.f13988E0) {
            this.f14028r0.show(this.f13982B0, false);
            return;
        }
        if (!this.f14019i0) {
            this.f14028r0.show(this.f13982B0, this.f14027q0);
            return;
        }
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f14028r0;
        String str = this.f13982B0;
        if (this.f14027q0 && m19367A2()) {
            z10 = true;
        }
        deleteOneDeviceBackupRecordDialog.show(str, z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d("CloudBackupRecordsActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 30001 && i11 == 100301) {
            if (CBAccess.inRestore()) {
                setResult(C5963j.f27043l);
                finish();
                return;
            }
            return;
        }
        if (i10 == 30001 && i11 == 11) {
            C11839m.m70686d("CloudBackupRecordsActivity", "setResult to migrate");
            setResult(11, intent);
            finish();
        } else if (i10 == 30001 && i11 == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.bt_no_net == id2) {
            C11829c.m70612r1(this);
            return;
        }
        if (R$id.rl_network_not_connect == id2) {
            m19238R1();
            if (C0209d.m1333z1(this)) {
                m19427w2();
                return;
            } else {
                m19239S1();
                return;
            }
        }
        if (R$id.latest_show_all_records == id2) {
            this.f13989F.m24913h(this.f14001Q);
            this.f13996L.setVisibility(8);
        } else if (R$id.oldest_show_all_records == id2) {
            this.f13991G.m24913h(this.f14002R);
            this.f13999O.setVisibility(8);
        } else if (R$id.refurbishment_show_all_records == id2) {
            this.f13992H.m24913h(this.f14003S);
            this.f14000P.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19428x2();
        m19430z2();
        m19403L2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        if (this.f14036z0 != null) {
            CloudBackupService.getInstance().unregister(this.f14036z0);
        }
        RefurbishedBackupRecordSelectDialog refurbishedBackupRecordSelectDialog = this.f14016f0;
        if (refurbishedBackupRecordSelectDialog != null) {
            refurbishedBackupRecordSelectDialog.dismiss();
            this.f14016f0 = null;
        }
        if (this.f14032v0 != null) {
            this.f14032v0 = null;
        }
        m19393l2();
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:88:0x003e  */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onItemClick(android.widget.AdapterView<?> r6, android.view.View r7, int r8, long r9) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.i2
            @Override // java.lang.Runnable
            public final void run() {
                this.f17635a.m19403L2();
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m19373O2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        CloudRecoveryItem cloudRecoveryItem;
        boolean z10;
        super.onResume();
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras != null) {
            z10 = extras.getBoolean("record_not_exists");
            cloudRecoveryItem = (CloudRecoveryItem) extras.getParcelable("backup_content_detail_list");
            this.f14020j0 = extras.getString("moudle");
        } else {
            cloudRecoveryItem = null;
            z10 = false;
        }
        C11839m.m70688i("CloudBackupRecordsActivity", "onResume record: " + cloudRecoveryItem + ", isNotExists: " + z10);
        if (z10) {
            List<CloudRecoveryItem> list = this.f14001Q;
            if (list != null) {
                list.remove(cloudRecoveryItem);
            }
            List<CloudRecoveryItem> list2 = this.f14002R;
            if (list2 != null) {
                list2.remove(cloudRecoveryItem);
            }
            List<CloudRecoveryItem> list3 = this.f14003S;
            if (list3 != null) {
                list3.remove(cloudRecoveryItem);
            }
        }
    }

    /* renamed from: q2 */
    public final List<CloudRecoveryItem> m19422q2(List<CloudRecoveryItem> list) {
        return (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.k2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f17655a.m19399C2((CloudRecoveryItem) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: r2 */
    public final AlertDialog.Builder m19423r2(final CloudRecoveryItem cloudRecoveryItem, final int i10) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R$string.continue_resotre_data_tip);
        builder.setMessage(R$string.continue_resotre_data_content);
        builder.setNeutralButton(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.q2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R$string.basic_data_upgrade_btn), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.r2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f17714a.m19401F2(dialogInterface, i11);
            }
        });
        builder.setPositiveButton(getString(R$string.continue_button), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.s2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f17724a.m19400D2(cloudRecoveryItem, i10, dialogInterface, i11);
            }
        });
        return builder;
    }

    /* renamed from: s2 */
    public final int m19424s2() {
        final HashSet hashSet = new HashSet();
        List<CloudRecoveryItem> list = this.f14001Q;
        if (list != null) {
            list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.l2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloudBackupRecordsActivity.m19369G2(hashSet, (CloudRecoveryItem) obj);
                }
            });
        }
        List<CloudRecoveryItem> list2 = this.f14002R;
        if (list2 != null) {
            list2.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.m2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloudBackupRecordsActivity.m19370H2(hashSet, (CloudRecoveryItem) obj);
                }
            });
        }
        List<CloudRecoveryItem> list3 = this.f14003S;
        if (list3 != null) {
            list3.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.n2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloudBackupRecordsActivity.m19371I2(hashSet, (CloudRecoveryItem) obj);
                }
            });
        }
        return hashSet.size();
    }

    /* renamed from: t2 */
    public final void m19425t2(CloudRecoveryItem cloudRecoveryItem, int i10) {
        try {
            Intent intent = new Intent(this, (Class<?>) CloudRestoreOptionsActivity.class);
            if (this.f14013c0) {
                intent.setAction("restore_notify_click");
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_from_recovery", false);
            bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f13983C);
            CloudRecoveryItem cloudRecoveryItem2 = new CloudRecoveryItem();
            cloudRecoveryItem2.setBackupId(cloudRecoveryItem.getBackupId());
            cloudRecoveryItem2.setStartTime(cloudRecoveryItem.getStartTime());
            cloudRecoveryItem2.setCurrent(cloudRecoveryItem.isCurrent());
            cloudRecoveryItem2.setDevDisplayName(cloudRecoveryItem.getDevDisplayName());
            cloudRecoveryItem2.setDeviceIdd(C11477c.m68636f(cloudRecoveryItem.getDeviceIdd()));
            cloudRecoveryItem2.setDeviceName(cloudRecoveryItem.getDeviceName());
            cloudRecoveryItem2.setDeviceType(cloudRecoveryItem.getDeviceType());
            cloudRecoveryItem2.setItemList(cloudRecoveryItem.getItemList());
            cloudRecoveryItem2.setBackupEndTime(cloudRecoveryItem.getBackupEndTime());
            cloudRecoveryItem2.setSize(cloudRecoveryItem.getSize());
            cloudRecoveryItem2.setTerminalType(cloudRecoveryItem.getTerminalType());
            cloudRecoveryItem2.setIndex(cloudRecoveryItem.getIndex());
            cloudRecoveryItem2.setRefurbishment(cloudRecoveryItem.isRefurbishment());
            cloudRecoveryItem2.setTempBackup(cloudRecoveryItem.isTempBackup());
            cloudRecoveryItem2.setOccupySpaceType(cloudRecoveryItem.getOccupySpaceType());
            cloudRecoveryItem2.setNewBmRecord(cloudRecoveryItem.isNewBmRecord());
            cloudRecoveryItem2.setBackupRecordLabel(cloudRecoveryItem.getBackupRecordLabel());
            cloudRecoveryItem2.setBmDataType(cloudRecoveryItem.getBmDataType());
            bundle.putParcelable("backup_content_detail_list", cloudRecoveryItem2);
            bundle.putString("entrance_of_restore", this.f13985D);
            bundle.putString("device_count", String.valueOf(m19424s2()));
            bundle.putString("record_count", String.valueOf(this.f13989F.getCount() + this.f13991G.getCount() + this.f13992H.getCount()));
            bundle.putString("record_index", String.valueOf(i10));
            bundle.putBoolean("new_version_flag", true);
            bundle.putInt("record_count_type_int", this.f14022l0);
            intent.putExtras(bundle);
            intent.putExtra("moudle", this.f14020j0);
            intent.putExtra("backup_is_temp_backup_type", this.f13988E0);
            C13230i.m79525e1(intent, "1", "39");
            startActivityForResult(intent, PayStatusCodes.PAY_STATE_PARAM_ERROR);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupRecordsActivity", " navToBackupContentDetail " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m19373O2();
        return true;
    }

    /* renamed from: v2 */
    public final void m19403L2() {
        mo19005p1();
        if ("myHuawei".equals(this.f14014d0)) {
            m19387e3();
        } else {
            m19374P2();
        }
    }

    /* renamed from: w2 */
    public void m19427w2() {
        if (!C0209d.m1333z1(this)) {
            m19239S1();
            return;
        }
        m19238R1();
        m19410U2();
        CloudBackupService.getInstance().register(this.f14036z0);
        if (this.f13983C != 1 || this.f14018h0 == null) {
            m19406Q2();
        } else {
            this.f14035y0 = true;
            m19417b3();
        }
    }

    /* renamed from: x2 */
    public void m19428x2() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        Bundle extras = hiCloudSafeIntent.getExtras();
        this.f14014d0 = hiCloudSafeIntent.getStringExtra("moudle");
        this.f13982B0 = hiCloudSafeIntent.getStringExtra("backup_device_new");
        this.f13986D0 = hiCloudSafeIntent.getLongExtra("backup_data_size", 0L);
        this.f13984C0 = hiCloudSafeIntent.getStringExtra("backup_device_category");
        this.f14025o0 = hiCloudSafeIntent.getStringExtra(C6148x2.DEVICE_ID);
        this.f14015e0 = hiCloudSafeIntent.getBooleanExtra("from_backup_enter", false);
        this.f14019i0 = hiCloudSafeIntent.getBooleanExtra("is_current_device", false);
        this.f13988E0 = hiCloudSafeIntent.getBooleanExtra("backup_is_temp_backup_type", false);
        if (hiCloudSafeIntent.getBooleanExtra("oobe_online_update_is_fail", false)) {
            C11839m.m70689w("CloudBackupRecordsActivity", "hwcloud update hwclouddrive fail");
            C0209d.m1326x2();
        }
        if (extras == null) {
            return;
        }
        C10343b c10343b = new C10343b(extras);
        this.f13983C = c10343b.m63687i(FamilyShareConstants.ENTRY_TYPE, 1);
        String strM63695q = c10343b.m63695q("entrance_of_restore", "2");
        this.f13985D = strM63695q;
        if (strM63695q.equals("5")) {
            m22365E1(R$string.view_and_restore);
        }
        Optional.ofNullable((Bundle) extras.getParcelable(CommonPickerConstant.RequestParams.KEY_DEVICE_INFO)).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.p2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17698a.m19402J2((Bundle) obj);
            }
        });
        CloudBackupDeviceInfo cloudBackupDeviceInfo = this.f14018h0;
        if (cloudBackupDeviceInfo != null) {
            this.f13982B0 = cloudBackupDeviceInfo.getDevDisplayName();
            this.f13986D0 = this.f14018h0.getDeviceBackupSpace();
        }
        this.f14021k0 = hiCloudSafeIntent.getStringExtra("backup_device_id");
    }

    /* renamed from: y2 */
    public final void m19429y2(TextView textView) {
        C12515a.m75110o().m75175e(new C3184c(textView), false);
    }

    /* renamed from: z2 */
    public void m19430z2() {
        mo19982C1();
        LayoutInflater.from(this).inflate(R$layout.activity_backup_record, (ViewGroup) this.f13894y, true);
        this.f13993I = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_top);
        this.f13895z.setOnClickListener(this);
        this.f13888s.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.restore_page_description);
        this.f13981A0 = textView;
        if (this.f13983C == 1) {
            textView.setVisibility(8);
        }
        this.f13994J = (ScrollView) C12809f.m76829b(this, R$id.records_list_layout);
        this.f13995K = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.latest_records_layout);
        ScrollDisabledListView scrollDisabledListView = (ScrollDisabledListView) C12809f.m76829b(this, R$id.latest_records_list_view);
        this.f13996L = (TextView) C12809f.m76829b(this, R$id.latest_show_all_records);
        this.f14006V = (LinearLayout) C12809f.m76829b(this, R$id.latest_column);
        this.f13996L.setOnClickListener(this);
        this.f14033w0 = (SpanClickText) C12809f.m76829b(this, R$id.service_expiration_tips);
        int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
        m19409T2();
        if (iM81077e == 1) {
            this.f14033w0.setVisibility(0);
        } else {
            this.f14033w0.setVisibility(8);
        }
        this.f13997M = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.oldest_records_layout);
        ScrollDisabledListView scrollDisabledListView2 = (ScrollDisabledListView) C12809f.m76829b(this, R$id.oldest_records_list_view);
        this.f13999O = (TextView) C12809f.m76829b(this, R$id.oldest_show_all_records);
        this.f14007W = (LinearLayout) C12809f.m76829b(this, R$id.oldest_column);
        this.f13999O.setOnClickListener(this);
        this.f14028r0 = new DeleteOneDeviceBackupRecordDialog(this, new C3183b());
        this.f14029s0 = new CutOutProgressDialog(this);
        this.f13998N = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.refurbishment_records_layout);
        ScrollDisabledListView scrollDisabledListView3 = (ScrollDisabledListView) C12809f.m76829b(this, R$id.refurbishment_records_list_view);
        this.f14000P = (TextView) C12809f.m76829b(this, R$id.refurbishment_show_all_records);
        this.f14008X = (LinearLayout) C12809f.m76829b(this, R$id.refurbishment_column);
        this.f14000P.setOnClickListener(this);
        this.f14010Z = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.noch_fit_latest_layout);
        this.f14011a0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.noch_fit_oldest_layout);
        this.f14012b0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.noch_fit_refurbishment_layout);
        this.f14026p0 = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_backup_btn);
        this.f14031u0 = C12809f.m76829b(this, R$id.nfrel_delete);
        this.f14026p0.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17736a.m19421m2(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_recovery_queryconfig_failed_frame_column);
        this.f14009Y = relativeLayout;
        C11842p.m70795b2(this, relativeLayout);
        CloudBackupRecordsAdapter cloudBackupRecordsAdapter = new CloudBackupRecordsAdapter(this);
        this.f13989F = cloudBackupRecordsAdapter;
        scrollDisabledListView.setAdapter((ListAdapter) cloudBackupRecordsAdapter);
        scrollDisabledListView.setTag("latest");
        scrollDisabledListView.setOnItemClickListener(this);
        CloudBackupRecordsAdapter cloudBackupRecordsAdapter2 = new CloudBackupRecordsAdapter(this);
        this.f13991G = cloudBackupRecordsAdapter2;
        scrollDisabledListView2.setAdapter((ListAdapter) cloudBackupRecordsAdapter2);
        scrollDisabledListView2.setTag("oldest");
        scrollDisabledListView2.setOnItemClickListener(this);
        CloudBackupRecordsAdapter cloudBackupRecordsAdapter3 = new CloudBackupRecordsAdapter(this);
        this.f13992H = cloudBackupRecordsAdapter3;
        scrollDisabledListView3.setAdapter((ListAdapter) cloudBackupRecordsAdapter3);
        scrollDisabledListView3.setTag("refurbishment");
        scrollDisabledListView3.setOnItemClickListener(this);
    }
}
