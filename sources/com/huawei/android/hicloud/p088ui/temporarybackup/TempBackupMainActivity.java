package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.C2629f;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataAdapter;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupMainActivity;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.android.hicloud.p088ui.uiextend.UnionCheckBox;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MobileNetTipDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TempDoubleBtnDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakList;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0226l0;
import p211d.C8968a;
import p292fn.C9733f;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12591s1;
import p618rm.C12600v1;
import p626ry.C12652a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p814yl.C13998b0;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;
import p840zd.C14229k2;
import p848zl.C14333b;
import sk.C12809f;
import tl.C13029h;
import tl.C13030i;
import tl.C13033l;
import tl.C13034m;

/* loaded from: classes3.dex */
public class TempBackupMainActivity extends UIActivity implements TempBackupDataAdapter.UpdateOptionStatusListener, View.OnClickListener {

    /* renamed from: A */
    public AlertDialog f18400A;

    /* renamed from: B */
    public AlertDialog f18401B;

    /* renamed from: C */
    public MobileNetTipDialog f18402C;

    /* renamed from: D */
    public AlertDialog f18403D;

    /* renamed from: E */
    public boolean f18404E;

    /* renamed from: F */
    public TempDoubleBtnDialog f18405F;

    /* renamed from: G */
    public AlertDialog f18406G;

    /* renamed from: J */
    public String f18409J;

    /* renamed from: p */
    public FrameLayout f18413p;

    /* renamed from: q */
    public TextView f18414q;

    /* renamed from: r */
    public SpanClickText f18415r;

    /* renamed from: s */
    public TextView f18416s;

    /* renamed from: t */
    public LinearLayout f18417t;

    /* renamed from: u */
    public HwProgressBar f18418u;

    /* renamed from: v */
    public AutoSizeButton f18419v;

    /* renamed from: w */
    public UnionCheckBox f18420w;

    /* renamed from: x */
    public SpanClickText f18421x;

    /* renamed from: y */
    public TempBackupSelectSpaceView f18422y;

    /* renamed from: z */
    public TempBackupDataAdapter f18423z;

    /* renamed from: H */
    public final List<String> f18407H = new C12526j().m75384d0();

    /* renamed from: I */
    public final List<String> f18408I = new C12526j().m75387e0();

    /* renamed from: K */
    public final List<String> f18410K = C14333b.m85452H();

    /* renamed from: L */
    public BroadcastReceiver f18411L = new C4005a();

    /* renamed from: M */
    public final TempBackupDataManager.CallBack f18412M = new C4006b();

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupMainActivity$a */
    public class C4005a extends BroadcastReceiver {
        public C4005a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                TempBackupMainActivity.this.m24565H2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupMainActivity$b */
    public class C4006b implements TempBackupDataManager.CallBack {
        public C4006b() {
        }

        @Override // com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataManager.CallBack
        /* renamed from: a */
        public void mo24516a(BackupOptionItem backupOptionItem, int i10) {
            if (TempBackupMainActivity.this.f18423z == null) {
                C11839m.m70689w("TempBackUpMainActivity", "refreshDataItem: tempBackupDataAdapter is null");
                return;
            }
            if (i10 != -1 && i10 >= 0 && i10 < TempBackupMainActivity.this.f18423z.m24485N().size()) {
                BackupOptionItem backupOptionItem2 = TempBackupMainActivity.this.f18423z.m24485N().get(i10);
                if (TextUtils.equals(backupOptionItem2.getAppId(), backupOptionItem.getAppId())) {
                    backupOptionItem2.setDataBytes(backupOptionItem.getDataBytes() + backupOptionItem.getCodeBytes());
                    TempBackupMainActivity.this.f18423z.m5214k(i10 + 2);
                }
            }
        }

        @Override // com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataManager.CallBack
        /* renamed from: b */
        public void mo24517b(List<BackupOptionItem> list, long j10) {
            C11839m.m70688i("TempBackUpMainActivity", "refreshData: backupOptionItems.size: " + list.size() + ", totalSize: " + j10);
            if (TempBackupMainActivity.this.f18423z == null) {
                C11839m.m70689w("TempBackUpMainActivity", "refreshData: tempBackupDataAdapter is null");
                return;
            }
            if (j10 > 0) {
                TempBackupMainActivity.this.f18423z.m24493a0();
                TempBackupMainActivity.this.m24565H2();
                m24588g(true);
                TempBackupMainActivity.this.f18423z.m24484L(TempBackupMainActivity.this);
            } else {
                m24588g(false);
            }
            if (TempBackupMainActivity.this.f18409J != null) {
                list.stream().filter(new Predicate() { // from class: zd.u1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.f63481a.m24587e((BackupOptionItem) obj);
                    }
                }).findFirst().ifPresent(new Consumer() { // from class: zd.v1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((BackupOptionItem) obj).setBackupSwitch(false);
                    }
                });
            }
            TempBackupDataAdapter tempBackupDataAdapter = TempBackupMainActivity.this.f18423z;
            TempBackupMainActivity tempBackupMainActivity = TempBackupMainActivity.this;
            tempBackupDataAdapter.m24492Z(tempBackupMainActivity, list, tempBackupMainActivity.f18409J);
        }

        /* renamed from: e */
        public final /* synthetic */ boolean m24587e(BackupOptionItem backupOptionItem) {
            return TextUtils.equals(backupOptionItem.getAppId(), TempBackupMainActivity.this.f18409J);
        }

        /* renamed from: g */
        public final synchronized void m24588g(boolean z10) {
            try {
                TempBackupMainActivity tempBackupMainActivity = TempBackupMainActivity.this;
                int i10 = R$string.temp_backup_entire_system_backup;
                if (TextUtils.equals(tempBackupMainActivity.getString(i10), TempBackupMainActivity.this.f18414q.getText())) {
                    return;
                }
                if (z10) {
                    TempBackupMainActivity.this.f18414q.setText(TempBackupMainActivity.this.getString(i10));
                } else {
                    TempBackupMainActivity.this.f18414q.setText(TempBackupMainActivity.this.getString(R$string.temp_backup_main_please_wait_tips));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupMainActivity$c */
    public class C4007c extends AbstractC12367d {
        public C4007c() {
        }

        /* renamed from: h */
        public /* synthetic */ void m24592h() throws Resources.NotFoundException {
            TempBackupMainActivity.this.m24568M2();
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$List] */
        /* renamed from: j */
        public static /* synthetic */ CloudBackupV3Request m24593j(String str, About about, CloudBackupV3Server cloudBackupV3Server) throws IOException {
            Bak.List list = cloudBackupV3Server.backup().device().bak().list();
            if (C9733f.m60705z().m60720O("backupContainOhInterimRecords")) {
                list.setContainOH(2);
            }
            list.setFields(str).setBackupAction("interim").setBackupDeviceId(about.getBackupDeviceId()).setContainInterim(true);
            return list;
        }

        public /* synthetic */ void lambda$call$0() {
            TempBackupMainActivity.this.m24553p2();
            TempBackupMainActivity.this.m24569N2();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                if (m24595g()) {
                    C0226l0.m1584d(new Runnable() { // from class: zd.w1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f63495a.lambda$call$0();
                        }
                    });
                    return;
                }
            } catch (Exception e10) {
                C11839m.m70687e("TempBackUpMainActivity", "isExistSuccessTempBackupRecord failed: " + e10.getMessage());
            }
            C0226l0.m1584d(new Runnable() { // from class: zd.x1
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f63504a.m24592h();
                }
            });
        }

        /* renamed from: f */
        public final BakList m24594f(final About about, String str) throws C9721b {
            final String str2 = "baks(id,bakCategory,backupStatus,startTime,updateTime,endTime,device,gradeCode)";
            return (BakList) new C14000c0(new C14000c0.a() { // from class: zd.y1
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return TempBackupMainActivity.C4007c.m24593j(str2, about, cloudBackupV3Server);
                }
            }).m84139b("Backup.device.baks.list", str);
        }

        /* renamed from: g */
        public final boolean m24595g() throws Exception {
            About aboutM84137z = new C13998b0().m84137z(CloudBackupConstant.BACKUP_DEVICE_ID, C11058a.m66627b("02102"));
            String strM66627b = C11058a.m66627b("02315");
            if (aboutM84137z == null || TextUtils.isEmpty(aboutM84137z.getBackupDeviceId())) {
                C11839m.m70689w("TempBackUpMainActivity", "about params is empty");
                return false;
            }
            BakList bakListM24594f = m24594f(aboutM84137z, strM66627b);
            if (bakListM24594f == null) {
                return false;
            }
            for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak : bakListM24594f.getBaks()) {
                if (bak.isTempBackup() && bak.getBackupStatus().intValue() == 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.TEMP_BACKUP;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupMainActivity$d */
    public class C4008d implements TempDoubleBtnDialog.BtnCallBack {
        public C4008d() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnLeftCallBack() {
            C4012a.m24631O("event_id_confirm_temp_backup_dialog", "cancel confirm data dialog", "TempBackUpMainActivity");
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.TempDoubleBtnDialog.BtnCallBack
        public void btnRightCallBack() {
            TempBackupMainActivity.this.m24570P2();
            C4012a.m24631O("event_id_confirm_temp_backup_dialog", "confirm data dialog", "TempBackUpMainActivity");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupMainActivity$e */
    public class DialogInterfaceOnClickListenerC4009e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4009e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (TempBackupMainActivity.this.f18403D != null) {
                TempBackupMainActivity.this.f18403D.dismiss();
            }
        }
    }

    /* renamed from: I2 */
    private void m24524I2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_temp_backup", String.valueOf(true));
        JsonArray jsonArray = new JsonArray();
        JsonArray jsonArray2 = new JsonArray();
        List<BackupOptionItem> listM24485N = this.f18423z.m24485N();
        for (int i10 = 0; i10 < listM24485N.size(); i10++) {
            BackupOptionItem backupOptionItem = listM24485N.get(i10);
            if (backupOptionItem.getBackupSwitch()) {
                jsonArray.add(backupOptionItem.getAppId());
            }
            if (backupOptionItem.getOperateType() == 1) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("appId", backupOptionItem.getAppId());
                jsonObject.addProperty("backupSwitch", Boolean.valueOf(backupOptionItem.getBackupSwitch()));
                jsonObject.addProperty("operateTime", Long.valueOf(backupOptionItem.getOperateTime()));
                jsonObject.addProperty("backupData", Boolean.valueOf(backupOptionItem.isBackupData()));
                jsonArray2.add(jsonObject);
            }
        }
        linkedHashMap.put("selectedAppIds", jsonArray.toString());
        linkedHashMap.put("operatedAppIds", jsonArray2.toString());
        linkedHashMap.put("spaceType", String.valueOf(this.f18422y.getType().f18445a));
        C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", "1", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        C13622a.m81972r("02316", "mecloud_backupmain_click_now", linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", "1", "", linkedHashMap);
    }

    /* renamed from: L2 */
    private void m24526L2() {
        if ((C11842p.m70753O0(this) || C11842p.m70762R0()) && !C11842p.m70741K0()) {
            C11842p.m70736I1(this.f18413p, 0);
        } else {
            C11842p.m70736I1(this.f18413p, C11842p.m70789a0(this));
        }
    }

    /* renamed from: O2 */
    private void m24530O2() {
        this.f18417t.setClickable(false);
        this.f18418u.setVisibility(0);
        this.f18419v.setVisibility(8);
    }

    /* renamed from: S2 */
    private void m24535S2() {
        if (!C0209d.m1333z1(this)) {
            Toast.makeText(this, R$string.alert_net_disconnect_new, 0).show();
            return;
        }
        if (CBAccess.inRestoreWithRetryClearCheck(false)) {
            C11841o.m70707c(this, R$string.temp_backup_failed_cloud_backup_restoring, 0);
            C11839m.m70687e("TempBackUpMainActivity", "cloud_backup_running");
            return;
        }
        C11839m.m70688i("TempBackUpMainActivity", "is support refurbish:" + C12591s1.m75931a().m75943m());
        int iM1225Y = C0209d.m1225Y(this);
        C11839m.m70688i("TempBackUpMainActivity", "networkType: " + iM1225Y);
        if (iM1225Y == 1) {
            m24578o2();
            return;
        }
        if (!this.f18404E) {
            C11829c.m70612r1(this);
            return;
        }
        if (this.f18402C == null) {
            this.f18402C = new MobileNetTipDialog(this, new MobileNetTipDialog.MobileNetTipClickListener() { // from class: zd.j1
                @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63412a.m24563E2(dialogInterface, i10);
                }
            }, true);
        }
        this.f18402C.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.k1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4012a.m24631O("event_id_mobile_net_tips_temp_backup_dialog", "show mobile net tips dialog", "TempBackUpMainActivity");
            }
        });
        this.f18402C.show();
    }

    /* renamed from: k2 */
    public static void m24552k2() {
        C13029h c13029hM78495f;
        new C13033l().m78543a(1);
        new C13034m().m78543a(1);
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(5);
        } catch (C9721b unused) {
            C11839m.m70689w("TempBackUpMainActivity", "temp tag is empty");
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
            return;
        }
        c13030i.m78490a(c13029hM78495f.m78442H());
        C11839m.m70688i("TempBackUpMainActivity", "clearOriginTempBackupStateBeforeStartBackup clear temp backup cache");
    }

    /* renamed from: p2 */
    public void m24553p2() {
        this.f18417t.setClickable(true);
        this.f18418u.setVisibility(8);
        this.f18419v.setVisibility(0);
    }

    /* renamed from: t2 */
    public /* synthetic */ void m24555t2() throws IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("TempBackUpMainActivity", "link click to fast");
        } else {
            C11839m.m70688i("TempBackUpMainActivity", "show special instructions bottom sheet");
            C4012a.m24642Z(this);
        }
    }

    /* renamed from: u2 */
    public /* synthetic */ void m24556u2(View view) {
        if (this.f18420w.isChecked()) {
            m24564G2();
        } else {
            C11841o.m70707c(this, R$string.pls_check_backup_scope, 0);
        }
    }

    /* renamed from: v2 */
    public static /* synthetic */ boolean m24557v2(BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch();
    }

    /* renamed from: w2 */
    public static /* synthetic */ int m24558w2(BackupOptionItem backupOptionItem) {
        if (TextUtils.equals("com.tencent.mm", backupOptionItem.getAppId())) {
            return 0;
        }
        return TextUtils.equals(HNConstants.DataType.MEDIA, backupOptionItem.getAppId()) ? 1 : 2;
    }

    /* renamed from: A2 */
    public final /* synthetic */ void m24559A2(DialogInterface dialogInterface, int i10) {
        m24566J2("event_id_not_support_data_range_tips", "agree and continue");
        m24535S2();
    }

    /* renamed from: B2 */
    public final /* synthetic */ void m24560B2(LinkedHashMap linkedHashMap, DialogInterface dialogInterface) {
        Button button = this.f18406G.getButton(-1);
        if (button != null) {
            button.setTextColor(getColor(R$color.emui_functional_red));
        }
        m24567K2("event_id_close_switch_tips", "show dialog", linkedHashMap);
    }

    /* renamed from: C2 */
    public final /* synthetic */ void m24561C2(BackupOptionItem backupOptionItem, LinkedHashMap linkedHashMap, String str, DialogInterface dialogInterface, int i10) {
        BackupOptionItem backupOptionItemM24487P;
        List<BackupOptionItem> twinAppsList = backupOptionItem.getTwinAppsList();
        if (!twinAppsList.isEmpty()) {
            for (BackupOptionItem backupOptionItem2 : twinAppsList) {
                TempBackupDataAdapter tempBackupDataAdapter = this.f18423z;
                if (tempBackupDataAdapter != null && (backupOptionItemM24487P = tempBackupDataAdapter.m24487P(backupOptionItem2.getAppId())) != null) {
                    backupOptionItemM24487P.setBackupSwitch(backupOptionItemM24487P.getPreBackupSwitch());
                    m24573T2(backupOptionItem2.getAppId(), linkedHashMap, backupOptionItemM24487P.getBackupSwitch(), null, "cancel close");
                    this.f18423z.m5214k(this.f18423z.m24488Q(backupOptionItemM24487P));
                }
            }
        }
        m24573T2(str, linkedHashMap, true, null, "cancel close");
    }

    /* renamed from: D2 */
    public final /* synthetic */ void m24562D2(BackupOptionItem backupOptionItem, LinkedHashMap linkedHashMap, String str, DialogInterface dialogInterface, int i10) {
        BackupOptionItem backupOptionItemM24487P;
        List<BackupOptionItem> twinAppsList = backupOptionItem.getTwinAppsList();
        if (!twinAppsList.isEmpty()) {
            for (BackupOptionItem backupOptionItem2 : twinAppsList) {
                m24573T2(backupOptionItem2.getAppId(), linkedHashMap, false, 1, "confirm close");
                TempBackupDataAdapter tempBackupDataAdapter = this.f18423z;
                if (tempBackupDataAdapter != null && (backupOptionItemM24487P = tempBackupDataAdapter.m24487P(backupOptionItem2.getAppId())) != null) {
                    backupOptionItemM24487P.setBackupSwitch(false);
                    backupOptionItemM24487P.setOperateType(1);
                    this.f18423z.m5214k(this.f18423z.m24488Q(backupOptionItemM24487P));
                }
            }
        }
        m24573T2(str, linkedHashMap, false, 1, "confirm close");
    }

    /* renamed from: E2 */
    public final /* synthetic */ void m24563E2(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            C4012a.m24631O("event_id_mobile_net_tips_temp_backup_dialog", "cancel dialog", "TempBackUpMainActivity");
            dialogInterface.dismiss();
        } else {
            if (i10 != -1) {
                return;
            }
            C4012a.m24631O("event_id_mobile_net_tips_temp_backup_dialog", "continue temp backup", "TempBackUpMainActivity");
            m24578o2();
        }
    }

    /* renamed from: G2 */
    public final void m24564G2() {
        m24530O2();
        C12600v1.m76046b();
        C12515a.m75110o().m75172d(new C4007c());
    }

    /* renamed from: H2 */
    public final void m24565H2() {
        int iM1225Y = C0209d.m1225Y(this);
        C11839m.m70688i("TempBackUpMainActivity", "refreshButton networkType: " + iM1225Y);
        if (this.f18404E || iM1225Y == 1) {
            this.f18416s.setVisibility(8);
            this.f18417t.setClickable(true);
            this.f18417t.setBackground(C8968a.m56743b(this, R$drawable.hwbutton_emphasize_emui));
        } else {
            this.f18416s.setVisibility(0);
            this.f18417t.setClickable(false);
            this.f18417t.setBackground(C8968a.m56743b(this, R$drawable.hwbutton_emphasize_emui_disable_drawable));
        }
    }

    /* renamed from: J2 */
    public final void m24566J2(String str, String str2) {
        m24567K2(str, str2, null);
    }

    /* renamed from: K2 */
    public final void m24567K2(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        linkedHashMapM79497A.put("event", str2);
        C13225d.m79490f1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", str, "4", "66", linkedHashMapM79497A);
    }

    /* renamed from: M2 */
    public final void m24568M2() throws Resources.NotFoundException {
        String strM24476M;
        String strM24476M2;
        m24553p2();
        TempBackupDataAdapter tempBackupDataAdapter = this.f18423z;
        if (tempBackupDataAdapter == null) {
            C11839m.m70689w("TempBackUpMainActivity", "dataAdapter is null");
            m24535S2();
            return;
        }
        List<BackupOptionItem> listM24485N = tempBackupDataAdapter.m24485N();
        if (AbstractC14026a.m84159a(listM24485N)) {
            m24570P2();
            C11839m.m70688i("TempBackUpMainActivity", "backupOptionItems is null or size is zero");
            C4012a.m24631O("event_id_confirm_temp_backup_dialog", "confirm data dialog", "TempBackUpMainActivity");
            return;
        }
        int iCount = (int) listM24485N.stream().filter(new C2629f()).count();
        List list = (List) listM24485N.stream().filter(new Predicate() { // from class: zd.q1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TempBackupMainActivity.m24557v2((BackupOptionItem) obj);
            }
        }).collect(Collectors.toList());
        int size = listM24485N.size() - iCount;
        if (size == 0) {
            C11839m.m70688i("TempBackUpMainActivity", "all apps are selected");
            m24570P2();
            C4012a.m24631O("event_id_confirm_temp_backup_dialog", "confirm data dialog", "TempBackUpMainActivity");
            return;
        }
        Resources resources = getResources();
        String quantityString = "";
        String quantityString2 = resources != null ? resources.getQuantityString(R$plurals.temp_backup_confirm_dialog_title_v2, size, Integer.valueOf(size)) : "";
        list.sort(Comparator.comparingInt(new ToIntFunction() { // from class: zd.r1
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return TempBackupMainActivity.m24558w2((BackupOptionItem) obj);
            }
        }));
        if (list.size() == 1) {
            strM24476M = TempBackupDataAdapter.m24476M(this, (BackupOptionItem) list.get(0));
            strM24476M2 = "";
        } else if (list.size() >= 2) {
            strM24476M = TempBackupDataAdapter.m24476M(this, (BackupOptionItem) list.get(0));
            strM24476M2 = TempBackupDataAdapter.m24476M(this, (BackupOptionItem) list.get(1));
        } else {
            strM24476M = "";
            strM24476M2 = strM24476M;
        }
        if (size == 1) {
            C11839m.m70688i("TempBackUpMainActivity", "unSelectCount only one");
            quantityString = getString(R$string.temp_backup_confirm_dialog_content_v2_equal_one, strM24476M);
        } else if (size == 2) {
            C11839m.m70688i("TempBackUpMainActivity", "unSelectCount is two");
            quantityString = getString(R$string.temp_backup_confirm_dialog_content_v2_equal_two, strM24476M, strM24476M2);
        } else {
            C11839m.m70688i("TempBackUpMainActivity", "unSelectCount more than two");
            if (resources != null) {
                quantityString = resources.getQuantityString(R$plurals.temp_backup_confirm_dialog_content_v2_more_than_two, size, strM24476M, strM24476M2, Integer.valueOf(size));
            }
        }
        String str = quantityString;
        if (TextUtils.isEmpty(quantityString2) || TextUtils.isEmpty(str)) {
            C11839m.m70689w("TempBackUpMainActivity", "confirmDialog Title or Content is empty");
            m24535S2();
        } else {
            TempDoubleBtnDialog tempDoubleBtnDialogM24577n2 = m24577n2();
            this.f18405F = tempDoubleBtnDialogM24577n2;
            tempDoubleBtnDialogM24577n2.showCommonView(quantityString2, str, getString(R$string.temp_backup_continue_button), getString(R$string.cloudbackup_cancel_btn), 1);
        }
    }

    /* renamed from: N2 */
    public final void m24569N2() {
        AlertDialog alertDialog = this.f18401B;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R$string.temp_backup_exist_temp_record_title)).setMessage(getString(R$string.temp_backup_exist_temp_record_content_new)).setNegativeButton(getString(R$string.cancel_backup), new DialogInterface.OnClickListener() { // from class: zd.s1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63465a.m24583z2(dialogInterface, i10);
                }
            }).setPositiveButton(getString(R$string.temp_backup_continue_button), new DialogInterface.OnClickListener() { // from class: zd.t1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
                    this.f63476a.m24581x2(dialogInterface, i10);
                }
            }).setCancelable(false);
            AlertDialog alertDialogCreate = builder.create();
            this.f18401B = alertDialogCreate;
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.g1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f63399a.m24582y2(dialogInterface);
                }
            });
        } else if (alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpMainActivity", "existRecordDialog is showing");
            return;
        }
        this.f18401B.show();
    }

    /* renamed from: P2 */
    public final void m24570P2() {
        AlertDialog alertDialog = this.f18400A;
        if (alertDialog == null) {
            AlertDialog alertDialogM24661r = C4012a.m24661r(this, new DialogInterface.OnClickListener() { // from class: zd.i1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63409a.m24559A2(dialogInterface, i10);
                }
            });
            this.f18400A = alertDialogM24661r;
            if (alertDialogM24661r == null) {
                m24566J2("event_id_not_support_data_range_tips", "get multi data failed");
                m24535S2();
                return;
            }
        } else if (alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpMainActivity", "twinAppTipsDialog is showing");
            return;
        }
        this.f18400A.show();
    }

    /* renamed from: Q2 */
    public void m24571Q2(final BackupOptionItem backupOptionItem) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final String appId = backupOptionItem.getAppId();
        linkedHashMap.put("appId", appId);
        this.f18409J = appId;
        String strM24576m2 = m24576m2(backupOptionItem);
        String strM24575l2 = m24575l2(backupOptionItem);
        AlertDialog alertDialog = this.f18406G;
        if (alertDialog != null && alertDialog.isShowing()) {
            C11839m.m70688i("TempBackUpMainActivity", "existRecordDialog is showing");
            this.f18406G.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(strM24576m2).setMessage(strM24575l2).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.f18406G = alertDialogCreate;
        alertDialogCreate.setMessage(strM24575l2);
        this.f18406G.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.n1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f63434a.m24560B2(linkedHashMap, dialogInterface);
            }
        });
        this.f18406G.setTitle(strM24576m2);
        this.f18406G.setButton(-2, getString(R$string.temp_backup_cancel_button), new DialogInterface.OnClickListener() { // from class: zd.o1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63441a.m24561C2(backupOptionItem, linkedHashMap, appId, dialogInterface, i10);
            }
        });
        this.f18406G.setButton(-1, getString(R$string.temp_backup_confirm_button, TempBackupDataAdapter.m24476M(this, backupOptionItem)), new DialogInterface.OnClickListener() { // from class: zd.p1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f63449a.m24562D2(backupOptionItem, linkedHashMap, appId, dialogInterface, i10);
            }
        });
        this.f18406G.show();
    }

    /* renamed from: R2 */
    public void m24572R2() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.hicloud_new_backup_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.new_backup_auto);
        ((TextView) C12809f.m76831d(viewInflate, R$id.backup_tip)).setVisibility(8);
        textView.setText(getString(R$string.backup_option_basic_sys_data_tips, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp")));
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || (movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate).setTitle(R$string.backup_option_sys_tip_title).setPositiveButton(R$string.cloud_space_dialog_know, new DialogInterfaceOnClickListenerC4009e());
        AlertDialog alertDialogCreate = builder.create();
        this.f18403D = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: T2 */
    public final void m24573T2(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10, Integer num, String str2) {
        BackupOptionItem backupOptionItemM24487P = this.f18423z.m24487P(str);
        this.f18409J = null;
        if (backupOptionItemM24487P != null) {
            backupOptionItemM24487P.setBackupSwitch(z10);
            if (num != null) {
                backupOptionItemM24487P.setOperateType(1);
                backupOptionItemM24487P.setOperateTime(System.currentTimeMillis());
            }
            m24574j2(backupOptionItemM24487P);
            this.f18423z.m5214k(this.f18423z.m24488Q(backupOptionItemM24487P));
            m24567K2("event_id_close_switch_tips", str2, linkedHashMap);
            return;
        }
        C11839m.m70689w("TempBackUpMainActivity", "confirm close appid: " + str + " showingItem is null");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" showingItem is null");
        m24567K2("event_id_close_switch_tips", sb2.toString(), linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataAdapter.UpdateOptionStatusListener
    /* renamed from: d */
    public void mo24495d(int i10, BackupOptionItem backupOptionItem) {
        String appId = backupOptionItem.getAppId();
        if (backupOptionItem.getBackupSwitch()) {
            m24574j2(backupOptionItem);
        } else if (this.f18407H.contains(appId) || this.f18408I.contains(appId) || this.f18410K.contains(appId)) {
            m24571Q2(backupOptionItem);
        } else {
            m24574j2(backupOptionItem);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C12809f.m76829b(this, R$id.rl_main));
        return arrayList;
    }

    /* renamed from: j2 */
    public final void m24574j2(BackupOptionItem backupOptionItem) {
        BackupOptionItem backupOptionItemM24487P;
        C14229k2 c14229k2 = new C14229k2();
        if (TextUtils.equals(backupOptionItem.getAppId(), "soundrecorder") || TextUtils.equals(backupOptionItem.getAppId(), "callRecorder")) {
            c14229k2.m78377L(backupOptionItem.getBackupSwitch(), "soundrecorder", backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            c14229k2.m78377L(backupOptionItem.getBackupSwitch(), "callRecorder", backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            return;
        }
        if (TextUtils.equals(backupOptionItem.getAppId(), NavigationUtils.SMS_SCHEMA_PREF) || TextUtils.equals(backupOptionItem.getAppId(), "chatSms")) {
            c14229k2.m78377L(backupOptionItem.getBackupSwitch(), NavigationUtils.SMS_SCHEMA_PREF, backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            c14229k2.m78377L(backupOptionItem.getBackupSwitch(), "chatSms", backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            return;
        }
        if (SplitAppUtil.isTwinApp(backupOptionItem.getSplitApkType(), backupOptionItem.getOriBackupAppName()) && backupOptionItem.getBackupSwitch()) {
            c14229k2.m78377L(backupOptionItem.getBackupSwitch(), backupOptionItem.getOriBackupAppName(), backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
            TempBackupDataAdapter tempBackupDataAdapter = this.f18423z;
            if (tempBackupDataAdapter != null && (backupOptionItemM24487P = tempBackupDataAdapter.m24487P(backupOptionItem.getOriBackupAppName())) != null) {
                backupOptionItemM24487P.setBackupSwitch(backupOptionItem.getBackupSwitch());
                backupOptionItemM24487P.setOperateType(backupOptionItem.getOperateType());
                backupOptionItemM24487P.setOperateTime(backupOptionItem.getOperateTime());
                this.f18423z.m5214k(this.f18423z.m24488Q(backupOptionItemM24487P));
            }
        }
        c14229k2.m78377L(backupOptionItem.getBackupSwitch(), backupOptionItem.getAppId(), backupOptionItem.getOperateType(), Long.valueOf(backupOptionItem.getOperateTime()));
    }

    /* renamed from: l2 */
    public final String m24575l2(BackupOptionItem backupOptionItem) {
        if (C12652a.m76180b(backupOptionItem)) {
            C11839m.m70688i("TempBackUpMainActivity", "item is null");
            return "item exception";
        }
        String strM24476M = TempBackupDataAdapter.m24476M(this, backupOptionItem);
        boolean z10 = !C12652a.m76180b(backupOptionItem.getTwinAppsList());
        String appId = backupOptionItem.getAppId();
        if (TextUtils.equals(appId, "com.tencent.mm")) {
            C11839m.m70688i("TempBackUpMainActivity", "appId is app_wechat, has TwinAppsList :" + z10);
            return z10 ? getString(R$string.temp_backup_cancel_module_dialog_content_wechat_clone, strM24476M, strM24476M) : getString(R$string.temp_backup_cancel_module_dialog_content_wechat, strM24476M, strM24476M);
        }
        if (TextUtils.equals(appId, HNConstants.DataType.MEDIA)) {
            C11839m.m70688i("TempBackUpMainActivity", "appId is app_photos, has TwinAppsList :" + z10);
            return getString(R$string.temp_backup_cancel_module_dialog_content_album, strM24476M, strM24476M);
        }
        C11839m.m70688i("TempBackUpMainActivity", "appId is other, has TwinAppsList :" + z10);
        return getString(R$string.temp_backup_cancel_module_dialog_content_v2, strM24476M);
    }

    /* renamed from: m2 */
    public final String m24576m2(BackupOptionItem backupOptionItem) {
        return String.format(getString(R$string.temp_backup_cancel_module_dialog_title_v3), TempBackupDataAdapter.m24476M(this, backupOptionItem));
    }

    /* renamed from: n2 */
    public final TempDoubleBtnDialog m24577n2() {
        TempDoubleBtnDialog tempDoubleBtnDialog = new TempDoubleBtnDialog(this, new C4008d());
        tempDoubleBtnDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zd.h1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4012a.m24631O("event_id_confirm_temp_backup_dialog", "show confirm data dialog", "TempBackUpMainActivity");
            }
        });
        return tempDoubleBtnDialog;
    }

    /* renamed from: o2 */
    public final void m24578o2() {
        int iM24616e;
        if (C13452e.m80781L().m80907e1()) {
            iM24616e = this.f18422y.getType().m24616e();
            C12600v1.m76047c().m76055j(this.f18422y.getType());
        } else {
            iM24616e = 0;
        }
        m24552k2();
        if (CloudBackupService.getInstance().doTempBackup(false, iM24616e)) {
            C0212e0.m1365o(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume", true);
            m24524I2();
            setResult(10001);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C4012a.m24631O("event_id_user_click_exit_page", "onBackPressed", "TempBackUpMainActivity");
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C0209d.m1226Y0() && view.getId() == R$id.detail_iv) {
            m24572R2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m24526L2();
        C11842p.m70874v1(this, this.f18417t);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11829c.m70624v1(this, getWindow());
        C11842p.m70842n1(getActionBar(), new ColorDrawable(getColor(R$color.pay_activity_harmony_bg)));
        setContentView(R$layout.activity_temp_back_up_main);
        View viewInflate = getLayoutInflater().inflate(R$layout.temp_back_up_top_view_holder, (ViewGroup) null);
        mo19005p1();
        m24579q2(bundle, viewInflate);
        C11842p.m70874v1(this, this.f18417t);
        m24526L2();
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.recyclerview_temp_backup_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(null);
        TempBackupDataAdapter tempBackupDataAdapter = new TempBackupDataAdapter(this);
        this.f18423z = tempBackupDataAdapter;
        tempBackupDataAdapter.m24482J(viewInflate);
        this.f18423z.m24494b0(this);
        recyclerView.setAdapter(this.f18423z);
        TempBackupDataManager.m24501i().m24507j(this.f18412M);
        this.f18404E = C10782d.m65634a().m65645l();
        C11839m.m70688i("TempBackUpMainActivity", "isSupportMobileDataOperate: " + this.f18404E);
        m24565H2();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f18411L, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("TempBackUpMainActivity", "onDestroy");
        super.onDestroy();
        TempBackupDataManager.m24501i().m24515t(this.f18412M);
        AlertDialog alertDialog = this.f18401B;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        MobileNetTipDialog mobileNetTipDialog = this.f18402C;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.f18403D;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        TempDoubleBtnDialog tempDoubleBtnDialog = this.f18405F;
        if (tempDoubleBtnDialog != null) {
            tempDoubleBtnDialog.dismiss();
        }
        AlertDialog alertDialog3 = this.f18406G;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
        }
        AlertDialog alertDialog4 = this.f18400A;
        if (alertDialog4 != null) {
            alertDialog4.dismiss();
        }
        BroadcastReceiver broadcastReceiver = this.f18411L;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f18411L = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("spaceType", this.f18422y.getType().m24616e());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        TempBackupSelectSpaceView tempBackupSelectSpaceView = this.f18422y;
        tempBackupSelectSpaceView.m24611p(tempBackupSelectSpaceView.getType());
        C4012a.m24633Q(this.f18415r, this.f18422y.getType());
    }

    /* renamed from: q2 */
    public final void m24579q2(Bundle bundle, View view) {
        this.f18413p = (FrameLayout) C12809f.m76829b(this, R$id.fl_temp_backup_main);
        this.f18414q = (TextView) C12809f.m76831d(view, R$id.tv_title);
        this.f18415r = (SpanClickText) C12809f.m76831d(view, R$id.sct_desc);
        TempBackupSelectSpaceView tempBackupSelectSpaceView = (TempBackupSelectSpaceView) C12809f.m76831d(view, R$id.select_space_view);
        this.f18422y = tempBackupSelectSpaceView;
        C4012a.m24633Q(this.f18415r, tempBackupSelectSpaceView.getType());
        if (bundle != null) {
            this.f18422y.m24611p(TempBackupSelectSpaceView.EnumC4011b.m24615b(bundle.getInt("spaceType")));
        } else {
            this.f18422y.m24611p(TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_EXTRAS_SPACE);
        }
        this.f18422y.setStateChangeListener(new TempBackupSelectSpaceView.StateChangeListener() { // from class: zd.f1
            @Override // com.huawei.android.hicloud.ui.temporarybackup.TempBackupSelectSpaceView.StateChangeListener
            /* renamed from: a */
            public final void mo24614a(TempBackupSelectSpaceView.EnumC4011b enumC4011b) {
                this.f63394a.m24580s2(enumC4011b);
            }
        });
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_net_tip);
        this.f18416s = textView;
        textView.setText(C2783d.m16179s1(R$string.backup_no_wlan_tips, R$string.backup_no_wifi_tips));
        this.f18417t = (LinearLayout) C12809f.m76829b(this, R$id.rl_btn);
        this.f18418u = (HwProgressBar) C12809f.m76829b(this, R$id.progress);
        this.f18419v = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_start);
        this.f18420w = (UnionCheckBox) C12809f.m76829b(this, R$id.cb_backup_scope_confirm);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.sp_backup_scope_text);
        this.f18421x = spanClickText;
        C11842p.m70721D1(spanClickText, 1.0f);
        String string = getString(R$string.temp_backup_scope);
        String string2 = getString(R$string.temp_backup_scope_des, string);
        this.f18421x.m15931c(string, new SpanClickText.ISpanClickListener() { // from class: zd.l1
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException {
                this.f63424a.m24555t2();
            }
        });
        this.f18421x.m15934g(string2, false);
        this.f18417t.setOnClickListener(new View.OnClickListener() { // from class: zd.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f63429a.m24556u2(view2);
            }
        });
    }

    /* renamed from: s2 */
    public final /* synthetic */ void m24580s2(TempBackupSelectSpaceView.EnumC4011b enumC4011b) {
        C4012a.m24633Q(this.f18415r, enumC4011b);
    }

    /* renamed from: x2 */
    public final /* synthetic */ void m24581x2(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
        m24566J2("event_id_exist_record_tips", "continue backup");
        m24568M2();
    }

    /* renamed from: y2 */
    public final /* synthetic */ void m24582y2(DialogInterface dialogInterface) {
        Button button = this.f18401B.getButton(-2);
        if (button != null) {
            button.setTextColor(getColor(R$color.emui_functional_red));
        }
        m24566J2("event_id_exist_record_tips", "show dialog");
    }

    /* renamed from: z2 */
    public final /* synthetic */ void m24583z2(DialogInterface dialogInterface, int i10) {
        m24566J2("event_id_exist_record_tips", "cancel backup");
    }
}
