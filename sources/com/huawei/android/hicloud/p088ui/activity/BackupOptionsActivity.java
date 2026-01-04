package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionFooterDataBean;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionHeaderDataBean;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupOptionInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.GetBackupCardInfoTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupSwitchBmChanger;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseOptionStatusDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchOpenTipsDialog;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.task.simple.C3048j2;
import com.huawei.android.hicloud.task.simple.C3072p2;
import com.huawei.android.hicloud.task.simple.TryUpdateOptionModuleInfoTask;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import hu.C10342a;
import hu.C10343b;
import il.C10542o;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0223k;
import p015ak.C0226l0;
import p292fn.C9733f;
import p429kk.C11058a;
import p459lp.C11333k;
import p495nm.C11726g;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12580p;
import p618rm.C12590s0;
import p618rm.C12597u1;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13367d;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p783xp.C13843a;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import pm.C12176c;
import pm.C12178e;
import sk.C12806c;
import sk.C12809f;
import tl.C13026e;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class BackupOptionsActivity extends CloudBackupBaseUiActivity implements View.OnClickListener, BackupOptionAdapter.UpdateOptionStatusListener, AdapterView.OnItemClickListener {

    /* renamed from: A0 */
    public TipPopupLayout f13690A0;

    /* renamed from: C */
    public SpaceSwitchOpenTipsDialog f13692C;

    /* renamed from: D */
    public CloudSpace f13694D;

    /* renamed from: I */
    public boolean f13701I;

    /* renamed from: J */
    public QuotaSpaceInfo f13702J;

    /* renamed from: N */
    public NotchFitLinearLayout f13706N;

    /* renamed from: O */
    public RecyclerView f13707O;

    /* renamed from: P */
    public NotchFitRelativeLayout f13708P;

    /* renamed from: Q */
    public NotchTopFitRelativeLayout f13709Q;

    /* renamed from: R */
    public BackupOptionAdapter f13710R;

    /* renamed from: Z */
    public C13465e f13718Z;

    /* renamed from: b0 */
    public CloseOptionStatusDialog f13720b0;

    /* renamed from: d0 */
    public AlertDialog f13722d0;

    /* renamed from: h0 */
    public long f13726h0;

    /* renamed from: j0 */
    public List<BackupOptionItem> f13728j0;

    /* renamed from: m0 */
    public int f13731m0;

    /* renamed from: u0 */
    public long f13739u0;

    /* renamed from: w0 */
    public BackupSwitchBmChanger f13741w0;

    /* renamed from: x0 */
    public LocalReceiver f13742x0;

    /* renamed from: E */
    public boolean f13696E = false;

    /* renamed from: F */
    public boolean f13698F = false;

    /* renamed from: G */
    public boolean f13699G = false;

    /* renamed from: H */
    public boolean f13700H = false;

    /* renamed from: K */
    public boolean f13703K = false;

    /* renamed from: L */
    public final List<String> f13704L = new ArrayList();

    /* renamed from: M */
    public BackupThirdAppOpenNotEnoughDialog f13705M = null;

    /* renamed from: S */
    public List<BackupOptionItem> f13711S = new ArrayList();

    /* renamed from: T */
    public List<BackupOptionItem> f13712T = new ArrayList();

    /* renamed from: U */
    public List<Object> f13713U = new ArrayList();

    /* renamed from: V */
    public BackupOptionHeaderDataBean f13714V = new BackupOptionHeaderDataBean();

    /* renamed from: W */
    public List<String> f13715W = new ArrayList();

    /* renamed from: X */
    public boolean f13716X = true;

    /* renamed from: Y */
    public boolean f13717Y = false;

    /* renamed from: a0 */
    public C13026e f13719a0 = new C13026e();

    /* renamed from: c0 */
    public final SettingOperator f13721c0 = new SettingOperator();

    /* renamed from: e0 */
    public long f13723e0 = 0;

    /* renamed from: f0 */
    public long f13724f0 = 0;

    /* renamed from: g0 */
    public long f13725g0 = 0;

    /* renamed from: i0 */
    public final List<String> f13727i0 = new ArrayList();

    /* renamed from: k0 */
    public boolean f13729k0 = false;

    /* renamed from: l0 */
    public ArrayList<String> f13730l0 = new ArrayList<>();

    /* renamed from: n0 */
    public boolean f13732n0 = false;

    /* renamed from: o0 */
    public boolean f13733o0 = false;

    /* renamed from: p0 */
    public boolean f13734p0 = false;

    /* renamed from: q0 */
    public boolean f13735q0 = false;

    /* renamed from: r0 */
    public final Object f13736r0 = new Object();

    /* renamed from: s0 */
    public Handler f13737s0 = null;

    /* renamed from: t0 */
    public HandlerThread f13738t0 = null;

    /* renamed from: v0 */
    public final Set<String> f13740v0 = new CopyOnWriteArraySet();

    /* renamed from: y0 */
    public String f13743y0 = "";

    /* renamed from: z0 */
    public String f13744z0 = "";

    /* renamed from: B0 */
    public final Handler.Callback f13691B0 = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.q0
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17705a.m18880E3(message);
        }
    };

    /* renamed from: C0 */
    public Handler f13693C0 = new HandlerC3143c();

    /* renamed from: D0 */
    public final Handler f13695D0 = new Handler();

    /* renamed from: E0 */
    public Runnable f13697E0 = new RunnableC3146f();

    public static class LocalReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public final WeakReference<BackupOptionsActivity> f13745a;

        public LocalReceiver(BackupOptionsActivity backupOptionsActivity) {
            this.f13745a = new WeakReference<>(backupOptionsActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70688i("BackupOptionsActivity", "LocalReceiver intent null");
                return;
            }
            String action = new HiCloudSafeIntent(intent).getAction();
            C11839m.m70686d("BackupOptionsActivity", "onReceive: " + action);
            if ("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS".equals(action)) {
                BackupOptionsActivity backupOptionsActivity = this.f13745a.get();
                if (backupOptionsActivity != null && backupOptionsActivity.m19009r3()) {
                    C11839m.m70686d("BackupOptionsActivity", "backupoptionactivity ACTION_PAY_SUCCESS ");
                    CloudBackupService.getInstance().refreshGradeWhiteBusinessModel(true);
                }
                if (backupOptionsActivity != null) {
                    backupOptionsActivity.m18987f4();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$a */
    public class DialogInterfaceOnClickListenerC3141a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3141a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (BackupOptionsActivity.this.f13722d0 != null) {
                BackupOptionsActivity.this.f13722d0.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$b */
    public class C3142b extends AbstractC12367d {
        public C3142b() {
        }

        public /* synthetic */ void lambda$call$0() {
            BackupOptionsActivity.this.m19012s4();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (BackupOptionsActivity.this.f13728j0 != null) {
                Iterator it = BackupOptionsActivity.this.f13728j0.iterator();
                while (it.hasNext()) {
                    BackupOptionsActivity.this.m18948J4((BackupOptionItem) it.next());
                }
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.f1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17605a.lambda$call$0();
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$c */
    public class HandlerC3143c extends Handler {
        public HandlerC3143c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1001) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof BackupStorageInfo) {
                BackupStorageInfo backupStorageInfo = (BackupStorageInfo) obj;
                if (backupStorageInfo.getCurrentDeviceBackupDetails() != null) {
                    long size = backupStorageInfo.getCurrentDeviceBackupDetails().getSize();
                    Bundle bundle = new Bundle();
                    bundle.putLong("backuped_data_size", size);
                    BackupOptionsActivity.this.m18998l4(33002, bundle);
                    C13465e.m81052f().m81065n("currentDeviceBackupedDataSize", size);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$d */
    public class C3144d extends AbstractC12367d {
        public C3144d() {
        }

        public /* synthetic */ void lambda$call$0() {
            BackupOptionsActivity.this.m19012s4();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strQueryBakSourceStrategy;
            int iM75334F = new C12526j().m75334F();
            if (iM75334F == 1) {
                strQueryBakSourceStrategy = BackupOptionsActivity.this.f13721c0.queryBakSourceStrategy();
                if ("1".equalsIgnoreCase(strQueryBakSourceStrategy)) {
                    try {
                        strQueryBakSourceStrategy = new C10542o().m64692t1(false, true, C11058a.m66627b("02102"));
                    } catch (C9721b e10) {
                        C11839m.m70687e("BackupOptionsActivity", "querySourceStrategy err = " + e10.getMessage());
                    }
                }
                BackupOptionsActivity.this.f13733o0 = true ^ "1".equals(strQueryBakSourceStrategy);
            } else {
                BackupOptionsActivity.this.f13733o0 = false;
                strQueryBakSourceStrategy = "";
            }
            BackupOptionsActivity.this.m18980c3();
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17615a.lambda$call$0();
                }
            });
            C11839m.m70688i("BackupOptionsActivity", "querySourceStrategy bakSource = " + strQueryBakSourceStrategy + " deleteTip = " + iM75334F);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$e */
    public class C3145e extends AbstractC12367d {
        public C3145e() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Device deviceDownloadCurrentDeviceInfo = CloudBackupUtil.downloadCurrentDeviceInfo();
            BackupOptionsActivity.this.f13743y0 = deviceDownloadCurrentDeviceInfo.getTerminalType();
            BackupOptionsActivity.this.f13744z0 = deviceDownloadCurrentDeviceInfo.getDeviceCategory();
            if (C4633d0.m28404a(BackupOptionsActivity.this.f13743y0) && C4633d0.m28404a(BackupOptionsActivity.this.f13744z0)) {
                return;
            }
            BackupOptionsActivity.this.m18938D4(DeviceIconManager.getInstance().getDeviceIconFromCache(BackupOptionsActivity.this.f13743y0, BackupOptionsActivity.this.f13744z0));
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DEVICE_ICON_DOWNLOAD;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$f */
    public class RunnableC3146f implements Runnable {
        public RunnableC3146f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GetOptionsInfoFromCloneTask.isOptionTaskNotComplete()) {
                BackupOptionsActivity.this.m18964U3(true);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$g */
    public class C3147g extends AbstractC12367d {
        public C3147g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            final CloudSpace cloudSpaceM80181d = C13367d.m80180e().m80181d();
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17624a.m19027d(cloudSpaceM80181d);
                }
            });
            C11839m.m70688i("BackupOptionsActivity", "initCloudSpace , cloudSpace = " + cloudSpaceM80181d);
        }

        /* renamed from: d */
        public final /* synthetic */ void m19027d(CloudSpace cloudSpace) {
            BackupOptionsActivity.this.f13694D = cloudSpace;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$h */
    public class C3148h implements BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback {

        /* renamed from: a */
        public final /* synthetic */ Function f13753a;

        public C3148h(Function function) {
            this.f13753a = function;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onCancel() {
            BackupOptionsActivity.this.m18996k4("param_cancel_click");
            Function function = this.f13753a;
            if (function != null) {
                function.apply(Boolean.TRUE);
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onJumpManagerSpacePage() {
            BackupOptionsActivity.this.startActivity(new Intent(BackupOptionsActivity.this, (Class<?>) HisyncSpaceDetailActivity.class));
            if (BackupOptionsActivity.this.f13705M != null) {
                BackupOptionsActivity.this.f13705M.dismiss();
            }
            BackupOptionsActivity.this.m18996k4("param_manager_click");
            Function function = this.f13753a;
            if (function != null) {
                function.apply(Boolean.TRUE);
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.BackupThirdAppOpenNotEnoughDialog.NotEnoughDialogClickCallback
        public void onJumpUpgradeCloudSpace() {
            Bundle bundle = new Bundle();
            bundle.putInt("nav_source", 15);
            C12126b.m72706b(BackupOptionsActivity.this, "2", bundle, true, 1001);
            if (BackupOptionsActivity.this.f13705M != null) {
                BackupOptionsActivity.this.f13705M.dismiss();
            }
            BackupOptionsActivity.this.m18996k4("param_upgrade_click");
            Function function = this.f13753a;
            if (function != null) {
                function.apply(Boolean.TRUE);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$i */
    public class C3149i implements SpaceSwitchOpenTipsDialog.DialogClickCallback {

        /* renamed from: a */
        public final /* synthetic */ BackupOptionItem f13755a;

        /* renamed from: b */
        public final /* synthetic */ Function f13756b;

        public C3149i(BackupOptionItem backupOptionItem, Function function) {
            this.f13755a = backupOptionItem;
            this.f13756b = function;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutCancel() {
            if (BackupOptionsActivity.this.f13710R != null) {
                BackupOptionsActivity.this.f13710R.m24766Q(this.f13755a.getAppId(), false);
            }
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_cancel", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_cancel", "1", "17");
            BackupOptionsActivity.this.f13692C.dismiss();
            Function function = this.f13756b;
            if (function != null) {
                function.apply("2");
            }
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog.DialogClickCallback
        public void onSpaceRunningOutOpen() {
            if (!TextUtils.isEmpty(this.f13755a.getAppId())) {
                BackupOptionsActivity.this.m18951M2(this.f13755a.getAppId());
            }
            C13225d.m79490f1().m79585f0("action_code_backup_switch_open_tips_ok", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_ok", "1", "17");
            BackupOptionsActivity.this.f13692C.dismiss();
            Function function = this.f13756b;
            if (function != null) {
                function.apply("1");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$j */
    public class HandlerC3150j extends Handler {
        public HandlerC3150j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BackupOptionsActivity.this.m18974Z3(message);
        }
    }

    /* renamed from: A3 */
    public static /* synthetic */ boolean m18873A3(String str, BackupOptionItem backupOptionItem) {
        return str.equalsIgnoreCase(backupOptionItem.getAppId());
    }

    /* renamed from: B3 */
    public static /* synthetic */ int m18875B3(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        return C12580p.m75586t(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
    }

    /* renamed from: E3 */
    public /* synthetic */ boolean m18880E3(Message message) {
        if (this.f13732n0) {
            m18973Z2(message);
            return false;
        }
        int i10 = message.what;
        if (i10 == 33024) {
            m18975a3(message.arg1);
            return false;
        }
        if (i10 == 33044) {
            this.f13741w0 = (BackupSwitchBmChanger) message.obj;
            m18975a3(message.arg1);
            return false;
        }
        if (i10 != 33043) {
            return false;
        }
        CloudSpace cloudSpace = (CloudSpace) message.obj;
        if (cloudSpace != null) {
            this.f13694D = cloudSpace;
        }
        m18975a3(message.arg1);
        return false;
    }

    /* renamed from: H3 */
    public static /* synthetic */ boolean m18884H3(String str, BackupOptionItem backupOptionItem) {
        return backupOptionItem.getAppId().equals(str);
    }

    /* renamed from: K4 */
    private void m18888K4(int i10) {
        List<String> listM69911k;
        String str;
        if (20007 == i10) {
            listM69911k = this.f22163b.m69911k("backup_sms");
            str = NavigationUtils.SMS_SCHEMA_PREF;
        } else if (20008 == i10) {
            listM69911k = this.f22163b.m69911k("backup_contact");
            str = HNConstants.DataType.CONTACT;
        } else if (20009 == i10) {
            listM69911k = this.f22163b.m69911k("backup_calllog");
            str = "calllog";
        } else if (20010 == i10) {
            listM69911k = this.f22163b.m69911k("backup_calendar");
            str = "calendar";
        } else {
            listM69911k = null;
            str = null;
        }
        if (listM69911k == null || listM69911k.isEmpty()) {
            C11839m.m70688i("BackupOptionsActivity", "relative permission is empty.");
            return;
        }
        List<String> listM69903b = this.f22163b.m69903b(this, listM69911k);
        if (listM69903b == null || listM69903b.isEmpty()) {
            C11839m.m70688i("BackupOptionsActivity", "unGranted permission is empty.");
            return;
        }
        m18966V3(false, str);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24766Q(str, false);
        }
    }

    /* renamed from: Q3 */
    public static /* synthetic */ boolean m18892Q3(String str, BackupOptionItem backupOptionItem) {
        return (str.equals(backupOptionItem.getOriBackupAppName()) || str.equals(backupOptionItem.getAppId())) && backupOptionItem.getBackupSwitch();
    }

    /* renamed from: d3 */
    private Context m18905d3() {
        return C0213f.m1377a();
    }

    /* renamed from: h3 */
    private void m18910h3() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f13731m0 == 2) {
            m22365E1(R$string.action_bar_title_backup_data);
        } else {
            m22365E1(R$string.backup_option_2);
        }
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            ActionBar actionBar = getActionBar();
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(i10));
            }
        }
    }

    /* renamed from: q3 */
    private boolean m18920q3() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.f13726h0 <= 1000;
        this.f13726h0 = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: t4 */
    private void m18924t4(List<BackupOptionItem> list) {
        this.f13713U.clear();
        C11839m.m70688i("BackupOptionsActivity", "showContentView showList:basesize:" + this.f13712T.size() + ";moduleSize:" + this.f13711S.size());
        m18935B4();
        this.f13713U.add(this.f13714V);
        m18969X2(this.f13711S);
        this.f13713U.addAll(this.f13711S);
        BackupOptionFooterDataBean backupOptionFooterDataBean = new BackupOptionFooterDataBean();
        if (C13452e.m80781L().m80887a1()) {
            backupOptionFooterDataBean.setShowTipsType(BackupOptionFooterDataBean.FooterType.EXCLUDE_TIP);
        } else if (this.f13727i0.isEmpty() && this.f13716X) {
            backupOptionFooterDataBean.setShowTipsType(BackupOptionFooterDataBean.FooterType.NOT_SHOW);
        } else {
            backupOptionFooterDataBean.setShowTipsType(BackupOptionFooterDataBean.FooterType.SYNC_EXCLUSIVE_TIP);
        }
        this.f13713U.add(backupOptionFooterDataBean);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24757F(this.f13713U);
        }
        mo19236O1();
        C11839m.m70688i("BackupOptionsActivity", "showContentView showList");
        final String showingModule = this.f13720b0.getShowingModule();
        if (!TextUtils.isEmpty(showingModule)) {
            this.f13711S.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.g0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupOptionsActivity.m18892Q3(showingModule, (BackupOptionItem) obj);
                }
            }).forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.h0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((BackupOptionItem) obj).setBackupSwitch(false);
                }
            });
        }
        this.f13707O.setVisibility(0);
        this.f13708P.setVisibility(8);
    }

    /* renamed from: w4 */
    private void m18928w4(int i10) {
        Toast.makeText(this, getString(i10), 0).show();
    }

    /* renamed from: z3 */
    public static /* synthetic */ Void m18932z3(Boolean bool) {
        return null;
    }

    /* renamed from: z4 */
    private void m18933z4() {
        if (this.f13742x0 != null) {
            try {
                C13108a.m78878b(this).m78883f(this.f13742x0);
                this.f13742x0 = null;
            } catch (Exception unused) {
                C11839m.m70687e("BackupOptionsActivity", "unregisterBroadcastReceiver mLocalReceiver");
            }
        }
    }

    /* renamed from: A4 */
    public final void m18934A4() {
        this.f13714V.setAlreadyBackupSize(this.f13739u0);
        this.f13714V.setShowLoading(false);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    /* renamed from: B4 */
    public final void m18935B4() {
        this.f13714V.setBaseDataList(this.f13712T);
        if (C13452e.m80781L().m80791C0()) {
            this.f13714V.setWaitBackupSize(C0223k.m1524g(C0213f.m1377a(), 0L));
            this.f13714V.setShowLoading(false);
        }
    }

    /* renamed from: C3 */
    public final /* synthetic */ void m18936C3(BackupOptionItem backupOptionItem) {
        BackupOptionItem backupOptionItemM78401y = this.f13719a0.m78401y(backupOptionItem.getAppId());
        if (backupOptionItemM78401y == null) {
            return;
        }
        backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
    }

    /* renamed from: C4 */
    public final void m18937C4(long j10) {
        long j11 = this.f13739u0 - j10;
        this.f13739u0 = j11;
        if (j11 < 0) {
            j11 = 0;
        }
        this.f13739u0 = j11;
        if (this.f13694D != null) {
            C11839m.m70688i("BackupOptionsActivity", "updateSpace , deleteSpace = " + j10 + " ,alreadBackupSize: " + this.f13739u0);
            long used = this.f13694D.getUsed() - j10;
            this.f13694D.setUsed(used > 0 ? used : 0L);
            return;
        }
        C11839m.m70688i("BackupOptionsActivity", "updateSpace , cloudSpace is null deleteSpace = " + j10 + " ,alreadBackupSize: " + this.f13739u0);
        long used2 = this.f13702J.getUsed() - j10;
        long j12 = used2 > 0 ? used2 : 0L;
        QuotaSpaceInfo quotaSpaceInfo = this.f13702J;
        quotaSpaceInfo.setAvailable(quotaSpaceInfo.getTotal() - j12);
        this.f13702J.setUsed(j12);
    }

    /* renamed from: D4 */
    public final void m18938D4(Drawable drawable) {
        this.f13714V.setDeviceIcon(drawable);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C11839m.m70688i("BackupOptionsActivity", "finish permissionSet requestCode: " + i10);
        m18888K4(i10);
    }

    /* renamed from: E4 */
    public final void m18939E4(String str) {
        if (C13452e.m80781L().m80791C0()) {
            return;
        }
        this.f13714V.setWaitBackupSize(str);
        this.f13714V.setShowLoading(false);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    /* renamed from: F3 */
    public final /* synthetic */ void m18940F3(String str, boolean z10) {
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter == null) {
            return;
        }
        backupOptionAdapter.m24764O(str, z10);
    }

    /* renamed from: F4 */
    public final void m18941F4(BackupOptionItem backupOptionItem) {
        List<BackupOptionItem> list = this.f13728j0;
        if (list == null) {
            return;
        }
        for (BackupOptionItem backupOptionItem2 : list) {
            if (Objects.equals(backupOptionItem.getAppId(), backupOptionItem2.getAppId())) {
                backupOptionItem2.setAppName(backupOptionItem.getAppName());
                backupOptionItem2.setParent(backupOptionItem.getParent());
                backupOptionItem2.setDisable(backupOptionItem.isDisable());
                backupOptionItem2.setBackupData(backupOptionItem.isBackupData());
                backupOptionItem2.setIsDataEnable(backupOptionItem.getIsDataEnable());
                backupOptionItem2.setCodeBytes(backupOptionItem.getCodeBytes());
                backupOptionItem2.setDataBytes(backupOptionItem.getDataBytes());
                backupOptionItem2.setSwitchCount(backupOptionItem.getSwitchCount());
                backupOptionItem2.setItemTotal(backupOptionItem.getItemTotal());
                backupOptionItem2.setTotalIncrease(backupOptionItem.getTotalIncrease());
                backupOptionItem2.setCurrentIncrease(backupOptionItem.getCurrentIncrease());
                backupOptionItem2.setData1(backupOptionItem.getData1());
                return;
            }
        }
    }

    /* renamed from: G3 */
    public final /* synthetic */ void m18942G3() {
        m18924t4(this.f13711S);
    }

    /* renamed from: G4 */
    public final void m18943G4(long j10) {
        this.f13714V.setLastBackupTime(j10);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    /* renamed from: H4 */
    public final void m18944H4() {
        if (C13452e.m80781L().m80791C0()) {
            Iterator<BackupOptionItem> it = this.f13711S.iterator();
            while (it.hasNext()) {
                it.next().setBackupSwitch(false);
            }
        }
    }

    /* renamed from: I3 */
    public final /* synthetic */ void m18945I3() {
        m19002n4(false);
    }

    /* renamed from: I4 */
    public void m18946I4(BackupOptionItem backupOptionItem) {
        if (backupOptionItem == null || "thirdAppData".equals(backupOptionItem.getAppId())) {
            return;
        }
        if (backupOptionItem.getAppId().equals("music") && this.f13715W.contains("music")) {
            backupOptionItem.setParent("virtualApp");
        }
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24767R(backupOptionItem);
        }
        m18941F4(backupOptionItem);
    }

    /* renamed from: J3 */
    public final /* synthetic */ void m18947J3() {
        m18928w4(R$string.delete_failed_toast);
    }

    /* renamed from: J4 */
    public final void m18948J4(BackupOptionItem backupOptionItem) {
        C13026e c13026e;
        BackupOptionItem backupOptionItemM78401y;
        if (TextUtils.isEmpty(backupOptionItem.getAppId()) || (c13026e = this.f13719a0) == null || (backupOptionItemM78401y = c13026e.m78401y(backupOptionItem.getAppId())) == null || backupOptionItem.getBackupSwitch() == backupOptionItemM78401y.getBackupSwitch()) {
            return;
        }
        C11839m.m70688i("BackupOptionsActivity", "updateSwitchByDB appId = " + backupOptionItem.getAppId() + " backupSwitch = " + backupOptionItemM78401y.getBackupSwitch());
        backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
    }

    /* renamed from: K3 */
    public final /* synthetic */ void m18949K3(List list, Integer num) {
        if (num.intValue() == 0) {
            m18985e4(list);
            return;
        }
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17644a.m18945I3();
            }
        });
        if (String.valueOf(num).endsWith(String.valueOf(4291))) {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17653a.m18947J3();
                }
            });
        }
    }

    /* renamed from: L3 */
    public final /* synthetic */ Boolean m18950L3() {
        Boolean boolValueOf;
        synchronized (this.f13736r0) {
            boolValueOf = Boolean.valueOf(this.f13737s0 == null);
        }
        return boolValueOf;
    }

    /* renamed from: M2 */
    public final void m18951M2(String str) {
        if (this.f13710R == null) {
            C11839m.m70687e("BackupOptionsActivity", "appDataCheckOpen, backupOptionAdapter is null");
            return;
        }
        m18992i4(str);
        m18966V3(true, str);
        this.f13710R.m24766Q(str, true);
        m19002n4(false);
        m29140w0("backup_" + str);
        C12515a.m75110o().m75172d(new C3048j2(str, true, this.f13731m0, false, m18984e3(str), false, this.f13710R.m24761J()));
        C11839m.m70688i("BackupOptionsActivity", "onCheckChanged appId: " + str + ", switch: true");
    }

    /* renamed from: M3 */
    public final /* synthetic */ void m18952M3() {
        m19002n4(false);
    }

    /* renamed from: N2 */
    public final void m18953N2() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("deeplink_sub_page");
        String stringExtra2 = safeIntent.getStringExtra("forOtherPage");
        C11839m.m70688i("BackupOptionsActivity", "backupOptionActivity parseIntent mSubPageFlag," + stringExtra + ",forOtherPage," + stringExtra2);
        if ("BackupOptionsActivity".equals(stringExtra2)) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, (Class<?>) BackupMainActivity.class));
            hiCloudSafeIntent.putExtra("forOtherPage", stringExtra2);
            startActivity(hiCloudSafeIntent);
        } else if ("BackupOptionsActivity".equals(stringExtra)) {
            C10342a.m63676b(this, new HiCloudSafeIntent(new Intent(this, (Class<?>) MainActivity.class)));
        } else {
            C11839m.m70688i("BackupOptionsActivity", "backupOptionActivity start");
            Intent intent = new Intent();
            intent.putExtra("isNeedReportSwitchState", this.f13729k0);
            intent.putStringArrayListExtra(CloudBackupConstant.BACKUP_OPETION_REPORT_LIST, this.f13730l0);
            setResult(0, intent);
            if (3 == this.f13731m0) {
                setResult(1, intent);
            }
        }
        finish();
    }

    /* renamed from: N3 */
    public final /* synthetic */ void m18954N3(BackupOptionItem backupOptionItem) {
        BackupOptionItem backupOptionItemM78401y = this.f13719a0.m78401y(backupOptionItem.getAppId());
        if (backupOptionItemM78401y == null) {
            return;
        }
        backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
    }

    /* renamed from: O2 */
    public final C11726g m18955O2() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f13727i0);
        if (C13452e.m80781L().m80887a1()) {
            List<String> listM73271n = C12176c.m73271n(null);
            if (!AbstractC14026a.m84159a(listM73271n)) {
                arrayList.addAll(listM73271n);
            }
        }
        return C12590s0.m75927z(true, arrayList);
    }

    /* renamed from: P2 */
    public final boolean m18956P2() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zInRestore = CBAccess.inRestore();
        if (!zM62388s && !zInRestore) {
            C11839m.m70687e("BackupOptionsActivity", "switch off, go to BackupMainActivity");
            m18988g3(BackupMainActivity.class, 1001);
            return false;
        }
        if (CBAccess.inBackup()) {
            C11839m.m70687e("BackupOptionsActivity", "backing up, go to BackupMainActivity");
            m18988g3(BackupMainActivity.class, 1002);
            return false;
        }
        if (!CBAccess.inRestore()) {
            return true;
        }
        C11839m.m70687e("BackupOptionsActivity", "restoring, go to MainActivity");
        m18988g3(MainActivity.class, 1003);
        return false;
    }

    /* renamed from: Q2 */
    public void m18957Q2(String str, boolean z10, BackupOptionItem backupOptionItem) {
        m18968W3(!z10, str, Long.valueOf(System.currentTimeMillis()), null);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24766Q(str, !z10);
            List<BackupOptionItem> twinAppsList = backupOptionItem.getTwinAppsList();
            if (!twinAppsList.isEmpty()) {
                for (BackupOptionItem backupOptionItem2 : twinAppsList) {
                    this.f13710R.m24766Q(backupOptionItem2.getAppId(), backupOptionItem2.getPreBackupSwitch());
                }
            }
        }
        this.f13720b0.dismiss();
        C11839m.m70688i("BackupOptionsActivity", "cancelDialog appId: " + str);
    }

    /* renamed from: R2 */
    public final void m18958R2(BackupOptionItem backupOptionItem) {
        this.f13703K = true;
        C11839m.m70688i("BackupOptionsActivity", "checkCanBackupCurrentApp , isOpenSwitchCalculate = true ,  appId = " + backupOptionItem.getAppId());
        if (this.f13694D == null && C0209d.m1333z1(this)) {
            m18993j3();
        }
        m18961T2(backupOptionItem);
    }

    /* renamed from: S2 */
    public final void m18959S2(BackupOptionItem backupOptionItem, Function<String, Void> function, Function<Boolean, Void> function2) {
        if (backupOptionItem == null) {
            C11839m.m70687e("BackupOptionsActivity", "clickItem is null");
            return;
        }
        if (this.f13710R == null) {
            C11839m.m70687e("BackupOptionsActivity", "backupOptionAdapter is null");
            return;
        }
        if (this.f13703K) {
            C11839m.m70688i("BackupOptionsActivity", "checkClickItemNotEnoughSpace , isOpenSwitchCalculate = true , return");
            this.f13710R.m24766Q(backupOptionItem.getAppId(), true);
            C11841o.m70708d(this, getString(R$string.backup_check_no_enough_loading), 0);
            return;
        }
        this.f13704L.add(backupOptionItem.getAppId());
        this.f13703K = true;
        C11839m.m70688i("BackupOptionsActivity", "checkClickItemNotEnoughSpace , isOpenSwitchCalculate = true ,  appId = " + backupOptionItem.getAppId());
        if (this.f13694D == null && C0209d.m1333z1(this)) {
            m18993j3();
        }
        long jM69963a = m18955O2().m69963a();
        if (m19013t3(backupOptionItem.getAppId(), jM69963a) == 0) {
            m19021x4(backupOptionItem, function2);
            return;
        }
        this.f13703K = false;
        if (this.f13701I) {
            this.f13701I = false;
        } else {
            m19015u4(backupOptionItem, jM69963a, function);
        }
    }

    /* renamed from: S3 */
    public final /* synthetic */ void m18960S3(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m18946I4((BackupOptionItem) it.next());
        }
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24760I().clear();
        }
    }

    /* renamed from: T2 */
    public final void m18961T2(BackupOptionItem backupOptionItem) {
        long jM69963a = m18955O2().m69963a();
        if (m19013t3(backupOptionItem.getAppId(), jM69963a) == 0) {
            m19021x4(backupOptionItem, null);
            return;
        }
        this.f13703K = false;
        if (this.f13701I) {
            this.f13701I = false;
        } else {
            m19015u4(backupOptionItem, jM69963a, null);
        }
    }

    /* renamed from: T3 */
    public final /* synthetic */ void m18962T3(final List list) {
        runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17661a.m18960S3(list);
            }
        });
    }

    /* renamed from: U2 */
    public final List<BackupOptionItem> m18963U2(String str, BackupOptionItem backupOptionItem) {
        ArrayList arrayList = new ArrayList();
        backupOptionItem.setAlmostFullDialogShow(false);
        backupOptionItem.setNotEnoughDialogShow(false);
        arrayList.add(backupOptionItem);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str);
        if (SplitAppUtil.isTwinApp(backupOptionItem.getSplitApkType(), backupOptionItem.getOriBackupAppName())) {
            String oriBackupAppName = backupOptionItem.getOriBackupAppName();
            if (TextUtils.isEmpty(oriBackupAppName) || this.f13710R == null) {
                C11839m.m70688i("BackupOptionsActivity", "dealClickData,oriBackupName or backupOptionAdapter is null");
            } else {
                arrayList2.add(oriBackupAppName);
                List listM81076c = C13466f.m81073d().m81076c("record_the_opened_splits");
                if (!listM81076c.contains(oriBackupAppName)) {
                    listM81076c.add(oriBackupAppName);
                    C13466f.m81073d().m81085m("record_the_opened_splits", listM81076c);
                }
                int iM24762K = this.f13710R.m24762K(oriBackupAppName);
                if (iM24762K < 0) {
                    C11839m.m70688i("BackupOptionsActivity", "dealClickData,positionById is less than 0");
                    return arrayList;
                }
                Object obj = this.f13710R.m24759H().get(iM24762K);
                if (!(obj instanceof BackupOptionItem)) {
                    C11839m.m70688i("BackupOptionsActivity", "dealClickData,oriItem is null or type error");
                    return arrayList;
                }
                BackupOptionItem backupOptionItem2 = (BackupOptionItem) obj;
                backupOptionItem2.setAlmostFullDialogShow(false);
                backupOptionItem2.setNotEnoughDialogShow(false);
                if (backupOptionItem2.getBackupSwitch()) {
                    C11839m.m70688i("BackupOptionsActivity", "dealClickData, oriItem is opened");
                    return arrayList;
                }
                arrayList.add(backupOptionItem2);
                C11839m.m70688i("BackupOptionsActivity", "dealClickData, need open main " + oriBackupAppName);
            }
        }
        return arrayList;
    }

    /* renamed from: U3 */
    public final void m18964U3(boolean z10) {
        this.f13714V.setShowLoading(z10);
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    /* renamed from: V2 */
    public final void m18965V2(final BackupOptionItem backupOptionItem, final List<BackupOptionItem> list, final BackupOptionItem backupOptionItem2) {
        if (backupOptionItem == null || backupOptionItem2 == null || list == null || list.size() < 1) {
            C11839m.m70688i("BackupOptionsActivity", "clickItem and so on are null");
        } else {
            m18959S2(backupOptionItem, new Function() { // from class: com.huawei.android.hicloud.ui.activity.o0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f17685a.m19022y3(list, backupOptionItem, backupOptionItem2, (String) obj);
                }
            }, new Function() { // from class: com.huawei.android.hicloud.ui.activity.p0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BackupOptionsActivity.m18932z3((Boolean) obj);
                }
            });
        }
    }

    /* renamed from: V3 */
    public void m18966V3(boolean z10, String str) {
        m18968W3(z10, str, Long.valueOf(System.currentTimeMillis()), null);
    }

    /* renamed from: W2 */
    public final void m18967W2(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        if (this.f13710R == null) {
            return;
        }
        if (!this.f13703K) {
            this.f13704L.add(backupOptionItem.getAppId());
            m18958R2(backupOptionItem);
        } else {
            C11839m.m70688i("BackupOptionsActivity", "onCheckChanged , isOpenSwitchCalculate = true , return");
            this.f13710R.m24766Q(backupOptionItem.getAppId(), true);
            C11841o.m70708d(this, getString(R$string.backup_check_no_enough_loading), 0);
        }
    }

    /* renamed from: W3 */
    public void m18968W3(boolean z10, String str, Long l10, BackupOptionItem backupOptionItem) {
        if (backupOptionItem == null) {
            backupOptionItem = TransferedUtil.queryItem(str, false);
        }
        if (backupOptionItem == null) {
            m18977b3(str);
        }
        if ("thirdAppData".equals(str)) {
            return;
        }
        if (!TextUtils.equals(NavigationUtils.SMS_SCHEMA_PREF, str) && !TextUtils.equals("soundrecorder", str)) {
            this.f13719a0.m78378M(z10, str, l10);
            return;
        }
        List<BackupOptionItem> listM78399w = this.f13719a0.m78399w(str);
        if (listM78399w == null || listM78399w.isEmpty()) {
            this.f13719a0.m78378M(z10, str, l10);
            return;
        }
        Iterator<BackupOptionItem> it = listM78399w.iterator();
        while (it.hasNext()) {
            this.f13719a0.m78378M(z10, it.next().getAppId(), l10);
        }
    }

    /* renamed from: X2 */
    public final List<BackupOptionItem> m18969X2(List<BackupOptionItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupOptionItem backupOptionItem = (BackupOptionItem) it.next();
            if (SplitAppUtil.isTwinApp(backupOptionItem.getSplitApkType(), backupOptionItem.getOriBackupAppName())) {
                List arrayList2 = map.get(backupOptionItem.getOriBackupAppName()) != null ? (List) map.get(backupOptionItem.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(backupOptionItem);
                    map.put(backupOptionItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.m0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return BackupOptionsActivity.m18873A3(str, (BackupOptionItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    BackupOptionItem backupOptionItem2 = (BackupOptionItem) optionalFindFirst.get();
                    List<BackupOptionItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.n0
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return BackupOptionsActivity.m18875B3((BackupOptionItem) obj, (BackupOptionItem) obj2);
                            }
                        });
                        backupOptionItem2.setTwinAppsList(list2);
                        list.removeAll(list2);
                        list.addAll(list.indexOf(backupOptionItem2) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: X3 */
    public Consumer<Integer> m18970X3(final List<String> list, boolean z10, boolean z11) {
        this.f13696E = this.f13696E || z11;
        for (final String str : list) {
            m18992i4(str);
            m18966V3(false, str);
            boolean zAnyMatch = this.f13712T.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.x0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupOptionsActivity.m18884H3(str, (BackupOptionItem) obj);
                }
            });
            BackupOptionAdapter backupOptionAdapter = this.f13710R;
            if (backupOptionAdapter != null) {
                if (zAnyMatch) {
                    backupOptionAdapter.m24764O(str, z10);
                } else {
                    backupOptionAdapter.m24766Q(str, z10);
                }
                C12515a.m75110o().m75172d(new C3048j2(str, z10, this.f13731m0, z11, m18984e3(str), false, this.f13710R.m24761J()));
            }
        }
        C11839m.m70688i("BackupOptionsActivity", "onSystemItemChanged appIds: " + list.toString());
        return new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.y0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17813a.m18949K3(list, (Integer) obj);
            }
        };
    }

    /* renamed from: Y2 */
    public boolean m18971Y2() {
        return this.f13733o0 && !C0209d.m1333z1(this);
    }

    /* renamed from: Y3 */
    public void m18972Y3() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f13731m0 = safeIntent.getIntExtra("source", -1);
        String stringExtra = safeIntent.getStringExtra("deeplink_sub_page");
        C11839m.m70688i("BackupOptionsActivity", "parseIntent mSubPageFlag," + stringExtra);
        if (!m18956P2()) {
            C11839m.m70689w("BackupOptionsActivity", "can not enter backup option");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if ("Backup_app_data_options".equals(stringExtra)) {
            if (C0209d.m1205R0(new C13026e().m78399w("thirdAppData"))) {
                return;
            }
            C11839m.m70689w("BackupOptionsActivity", "parseIntent error, not supprot BackupOptionsDetailActivity");
        } else if ("BackupOptionsActivity".equals(stringExtra)) {
            C13466f.m81073d().m81081i("has_entered_option_page", true);
            C13225d.m79490f1().m79585f0("enter_option_page_from_notify", C13452e.m80781L().m80971t0());
        }
    }

    /* renamed from: Z2 */
    public final void m18973Z2(Message message) {
        switch (message.what) {
            case 3214:
                C12590s0.m75755I0(C0213f.m1377a(), message.obj.toString());
                break;
            case 33001:
                String str = (String) message.obj;
                BackupOptionAdapter backupOptionAdapter = this.f13710R;
                if (backupOptionAdapter != null) {
                    backupOptionAdapter.m24765P(str);
                    break;
                }
                break;
            case 33002:
                m19008q4(message);
                break;
            case 33003:
                m19010r4(message);
                break;
            case 33005:
                m18946I4((BackupOptionItem) message.obj);
                break;
            case 33008:
                this.f13734p0 = true;
                Object obj = message.obj;
                if (obj instanceof CloudBackupOptionInfo) {
                    CloudBackupOptionInfo cloudBackupOptionInfo = (CloudBackupOptionInfo) obj;
                    this.f13728j0 = cloudBackupOptionInfo.getThirdAppItemList();
                    this.f13715W = cloudBackupOptionInfo.getVirtuals();
                    this.f13711S.clear();
                    boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive");
                    Map<String, SyncAppBackupPolicy> mapM76029e = C12597u1.m76029e();
                    Map<String, Integer> mapM76030f = C12597u1.m76030f();
                    for (BackupOptionItem backupOptionItem : cloudBackupOptionInfo.getSystemItemList()) {
                        String appId = backupOptionItem.getAppId();
                        if (zM60720O && mapM76029e.containsKey(appId)) {
                            String syncAppName = mapM76029e.get(appId).getSyncAppName();
                            if (mapM76029e.get(appId).getPolicy() == 1 && mapM76030f.containsKey(syncAppName) && 1 == mapM76030f.getOrDefault(syncAppName, 0).intValue()) {
                                C11839m.m70688i("BackupOptionsActivity", "skip appId: " + appId + ", syncAppName: " + syncAppName + " status is open");
                                this.f13727i0.add(appId);
                            }
                        }
                        this.f13711S.add(backupOptionItem);
                    }
                    this.f13711S.addAll(cloudBackupOptionInfo.getVirtualItemList());
                }
                m18982d4();
                m19012s4();
                break;
            case 33010:
                m19002n4(true);
                break;
            case 33017:
                Object obj2 = message.obj;
                if (obj2 instanceof BackupSwitchBmChanger) {
                    this.f13741w0 = (BackupSwitchBmChanger) obj2;
                }
                m19004o4(false);
                break;
            case 33021:
                this.f13728j0 = (List) message.obj;
                break;
            case 33033:
                m19002n4(false);
                break;
            case 33034:
                m19023y4();
                break;
            case 33039:
                if (this.f13696E) {
                    m18937C4(((Long) message.obj).longValue());
                    m19007p4();
                    break;
                } else {
                    C11839m.m70688i("BackupOptionsActivity", "appdelete isCheckDelete: " + this.f13696E);
                    break;
                }
            case 33054:
                m19237Q1(R$string.recovery_no_data_server_error);
                break;
        }
    }

    /* renamed from: Z3 */
    public final void m18974Z3(Message message) {
        if (message.what == 1) {
            if (!CBAccess.inBackup()) {
                C11839m.m70688i("BackupOptionsActivity", "processGetCmd start");
                if (GetOptionsInfoFromCloneTask.isOptionTaskNotComplete()) {
                    GetOptionsInfoFromCloneTask.waitOptionTaskEnd(new Supplier() { // from class: com.huawei.android.hicloud.ui.activity.r0
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return this.f17713a.m18950L3();
                        }
                    });
                }
                C11839m.m70688i("BackupOptionsActivity", "processGetCmd waitOptionTaskEnd");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f13740v0);
                C13026e c13026e = new C13026e();
                C12590s0.m75730C(arrayList);
                c13026e.m78373H(arrayList);
                this.f13740v0.removeAll(arrayList);
                C11839m.m70688i("BackupOptionsActivity", "processGetCmd appIdlist : " + arrayList);
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17721a.m18952M3();
                }
            });
        }
    }

    /* renamed from: a3 */
    public final void m18975a3(int i10) {
        switch (i10) {
            case 1:
            case 4:
                m19239S1();
                break;
            case 2:
            case 5:
                m19237Q1(R$string.recovery_no_data_server_error);
                break;
            case 3:
                CloudBackupService.getInstance().refreshGradeWhiteBusinessModel(false);
                break;
            case 6:
                CloudBackupService.getInstance().refreshSwitchStatusAsync(false);
                break;
            case 7:
                m19237Q1(R$string.alert_net_disconnect);
                break;
            case 8:
                this.f13732n0 = true;
                m18995k3();
                break;
            default:
                C11839m.m70689w("BackupOptionsActivity", "dispatchShowType default");
                break;
        }
    }

    /* renamed from: a4 */
    public void m18976a4() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        long jM81058g = this.f13718Z.m81058g("currentDeviceBackupedDataSize", 0L);
        if (zM62388s) {
            if (jM81058g > 0) {
                Bundle bundle = new Bundle();
                bundle.putLong("backuped_data_size", jM81058g);
                m18998l4(33002, bundle);
            } else {
                if (C13452e.m80781L().m80887a1()) {
                    return;
                }
                C12515a.m75110o().m75175e(new C12178e(this.f13693C0, true, true, true, 0), false);
            }
        }
    }

    /* renamed from: b3 */
    public final void m18977b3(String str) {
        BackupOptionItem backupOptionItem = new BackupOptionItem(str);
        backupOptionItem.setBackupSwitch(true);
        try {
            this.f13719a0.m78370E(backupOptionItem);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionsActivity", "generateItemAndSave: " + e10.getMessage());
        }
    }

    /* renamed from: b4 */
    public void m18978b4() {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        long jM81058g = this.f13718Z.m81058g("lastRecordTime", 0L);
        long jQuerylastsuccesstime = this.f13721c0.querylastsuccesstime();
        long jQueryFinalBackupCycle = this.f13721c0.queryFinalBackupCycle();
        if (zM62388s) {
            if (jQuerylastsuccesstime != 0) {
                jM81058g = jQuerylastsuccesstime;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("backup_cycle", jQueryFinalBackupCycle);
            bundle.putLong("backup_last_success_time", jM81058g);
            m18998l4(33003, bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x012b  */
    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionAdapter.UpdateOptionStatusListener
    /* renamed from: c0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo18979c0(int r10, java.lang.String r11, boolean r12, com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r13) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity.mo18979c0(int, java.lang.String, boolean, com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem):void");
    }

    /* renamed from: c3 */
    public final void m18980c3() {
        if (C13452e.m80781L().m80887a1()) {
            List<String> listM73271n = C12176c.m73271n(null);
            List<BackupOptionItem> backupOptionItems = GetBackupCardInfoTask.getBackupOptionItems(null);
            m18991i3(AbstractC14026a.m84159a(backupOptionItems) ? null : GetBackupCardInfoTask.getBaseDataList(backupOptionItems, listM73271n));
        }
        this.f13735q0 = true;
    }

    /* renamed from: c4 */
    public final void m18981c4() {
        m18933z4();
        synchronized (this.f13736r0) {
            try {
                Handler handler = this.f13737s0;
                if (handler != null) {
                    Looper looper = handler.getLooper();
                    this.f13737s0 = null;
                    if (looper != null) {
                        looper.quit();
                    }
                }
                this.f13738t0 = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13709Q);
        arrayList.add(this.f13706N);
        return arrayList;
    }

    /* renamed from: d4 */
    public final void m18982d4() {
        if (C13452e.m80781L().m80887a1()) {
            if (AbstractC14026a.m84159a(this.f13712T)) {
                C11839m.m70688i("BackupOptionsActivity", "basic data is empty");
            } else {
                this.f13712T.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.d1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f17583a.m18954N3((BackupOptionItem) obj);
                    }
                });
                this.f13712T.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.e1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
                    }
                });
            }
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionAdapter.UpdateOptionStatusListener
    /* renamed from: e0 */
    public void mo18983e0() {
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m5214k(0);
        }
    }

    /* renamed from: e3 */
    public final long m18984e3(String str) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem != null) {
            return backupOptionItemQueryItem.getDataBytes();
        }
        return 0L;
    }

    /* renamed from: e4 */
    public final void m18985e4(List<String> list) {
        if (m19001n3()) {
            synchronized (this.f13736r0) {
                try {
                    if (this.f13737s0 == null) {
                        C11839m.m70688i("BackupOptionsActivity", "onSystemItemChanged mHandler is null");
                        return;
                    }
                    this.f13740v0.addAll(list);
                    if (this.f13737s0.hasMessages(1)) {
                        C11839m.m70688i("BackupOptionsActivity", "refreshIncrease hasMessages appIds : " + list.toString());
                        return;
                    }
                    C11839m.m70688i("BackupOptionsActivity", "refreshIncrease");
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1;
                    this.f13737s0.sendMessage(messageObtain);
                } finally {
                }
            }
        }
    }

    /* renamed from: f3 */
    public final long m18986f3(String str) {
        if (!C14333b.m85461Q(str)) {
            BackupOptionItem backupOptionItemQueryMergeTwinItem = TransferedUtil.queryMergeTwinItem(str, false);
            if (backupOptionItemQueryMergeTwinItem != null) {
                return backupOptionItemQueryMergeTwinItem.getTotalIncrease();
            }
            return 0L;
        }
        BackupOptionItem backupOptionItemQueryMergeTwinItem2 = TransferedUtil.queryMergeTwinItem("soundrecorder", false);
        long totalIncrease = backupOptionItemQueryMergeTwinItem2 != null ? backupOptionItemQueryMergeTwinItem2.getTotalIncrease() : 0L;
        BackupOptionItem backupOptionItemQueryMergeTwinItem3 = TransferedUtil.queryMergeTwinItem("callRecorder", false);
        long totalIncrease2 = backupOptionItemQueryMergeTwinItem3 != null ? backupOptionItemQueryMergeTwinItem3.getTotalIncrease() : 0L;
        C11839m.m70688i("BackupOptionsActivity", "getSelectModuleIncreaseSize, soundRecorderSize:" + totalIncrease + ";callRecorderSize:" + totalIncrease2);
        return totalIncrease + totalIncrease2;
    }

    /* renamed from: f4 */
    public final void m18987f4() {
        C11839m.m70688i("BackupOptionsActivity", "refreshPayEndPage");
        m18939E4(C0223k.m1524g(C0213f.m1377a(), m18955O2().m69963a()));
        m19004o4(false);
    }

    /* renamed from: g3 */
    public final void m18988g3(Class<?> cls, int i10) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, cls));
        hiCloudSafeIntent.putExtra("backup_option_enter_status", i10);
        startActivity(hiCloudSafeIntent);
        finish();
    }

    /* renamed from: g4 */
    public final void m18989g4() {
        C12515a.m75110o().m75172d(new C3144d());
        CloudBackupService.getInstance().queryCloudSpaceByServer();
        m19238R1();
        C11839m.m70688i("BackupOptionsActivity", "refreshSwitchStatus showLoadingView");
    }

    /* renamed from: h4 */
    public final void m18990h4() {
        this.f13742x0 = new LocalReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS");
        C13108a.m78878b(this).m78880c(this.f13742x0, intentFilter);
    }

    /* renamed from: i3 */
    public final void m18991i3(List<BackupOptionItem> list) {
        if (list == null) {
            C11839m.m70689w("BackupOptionsActivity", "baseDataList is null");
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (BackupOptionItem backupOptionItem : list) {
            if (backupOptionItem != null) {
                if (C14333b.f63654f.contains(backupOptionItem.getAppId())) {
                    copyOnWriteArrayList.add(backupOptionItem);
                } else {
                    copyOnWriteArrayList2.add(backupOptionItem);
                }
            }
        }
        copyOnWriteArrayList2.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.b1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f16481a.m18936C3((BackupOptionItem) obj);
            }
        });
        copyOnWriteArrayList2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.c1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
        this.f13712T.clear();
        this.f13712T.addAll(copyOnWriteArrayList2);
        if (AbstractC14026a.m84159a(copyOnWriteArrayList)) {
            return;
        }
        BackupOptionItem backupOptionItem2 = new BackupOptionItem();
        backupOptionItem2.setBackupSwitch(true);
        backupOptionItem2.setAppId("basic_system_data");
        this.f13712T.add(0, backupOptionItem2);
    }

    /* renamed from: i4 */
    public final void m18992i4(String str) {
        this.f13729k0 = true;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13730l0.add(str);
    }

    /* renamed from: j3 */
    public final void m18993j3() {
        this.f13702J = C13368e.m80184F().m80224M();
        C11839m.m70688i("BackupOptionsActivity", "initCloudSpace , cahcedSpaceInfo = " + this.f13702J);
        if (C0209d.m1333z1(this)) {
            C12515a.m75110o().m75175e(new C3147g(), true);
        }
    }

    /* renamed from: j4 */
    public final void m18994j4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_backup_appdata_open_switch_dialog_show", String.valueOf(true));
        C13225d.m79490f1().m79567R("action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
    }

    /* renamed from: k3 */
    public void m18995k3() {
        m18997l3();
        m19004o4(true);
        mo22385x1();
        CloudBackup3rdIconUtil.downloadVirtualIcon();
    }

    /* renamed from: k4 */
    public final void m18996k4(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("backup_records_click_type", str);
        C13225d.m79490f1().m79567R("action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_appdata_open_switch_dialog", linkedHashMapM79497A);
    }

    /* renamed from: l3 */
    public void m18997l3() {
        this.f13718Z = C13465e.m81052f();
        m19000m4();
        this.f13707O.setAdapter(this.f13710R);
        this.f13707O.setVisibility(8);
        m18978b4();
        m18976a4();
        m19003o3();
        this.f13700H = new C12526j().m75369W0();
        C11839m.m70688i("BackupOptionsActivity", "switch3rdDefault: " + this.f13700H);
        if (GetOptionsInfoFromCloneTask.isOptionTaskNotComplete()) {
            if (m19011s3()) {
                if (System.currentTimeMillis() - this.f13718Z.m81056d(false) > 604800000) {
                    this.f13695D0.post(this.f13697E0);
                    return;
                }
                return;
            }
            if (System.currentTimeMillis() - this.f13718Z.m81056d(false) > 604800000) {
                long j10 = 15000 - this.f13725g0;
                C11839m.m70688i("BackupOptionsActivity", "delayTime = " + (j10 / 1000));
                this.f13695D0.postDelayed(this.f13697E0, j10);
            }
        }
    }

    /* renamed from: l4 */
    public void m18998l4(int i10, Object obj) {
        Message message = new Message();
        message.what = i10;
        if (obj != null) {
            message.obj = obj;
        }
        CBCallBack.getInstance().sendMessage(message);
    }

    /* renamed from: m3 */
    public final void m18999m3() {
        this.f13709Q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13706N = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.record_detail_list);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.record_sys_list);
        this.f13707O = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f13707O.setNestedScrollingEnabled(true);
        this.f13707O.setItemAnimator(null);
        NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f13708P = notchFitRelativeLayout;
        notchFitRelativeLayout.setVisibility(8);
        this.f13888s.setOnClickListener(this);
        this.f13895z.setOnClickListener(this);
        this.f13720b0 = new CloseOptionStatusDialog(this);
    }

    /* renamed from: m4 */
    public final void m19000m4() {
        Intent intent;
        try {
            intent = getIntent();
        } catch (Exception e10) {
            C11839m.m70687e("BackupOptionsActivity", "BackupOptions initdata err :" + e10.getMessage());
            intent = null;
        }
        if (intent == null) {
            C11839m.m70687e("BackupOptionsActivity", "BackupOptions initdata currentIntent is null");
            m18938D4(null);
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        this.f13743y0 = safeIntent.getStringExtra("terminalType");
        this.f13744z0 = safeIntent.getStringExtra("deviceCategory");
        if (!C4633d0.m28404a(this.f13743y0) && !C4633d0.m28404a(this.f13744z0) && DeviceIconManager.getInstance().isCacheVaild(this.f13743y0)) {
            m18938D4(DeviceIconManager.getInstance().getDeviceIconFromCache(this.f13743y0, this.f13744z0));
        } else {
            C11839m.m70688i("BackupOptionsActivity", "getDeviceIconFromBasic start.");
            C12515a.m75110o().m75172d(new C3145e());
        }
    }

    /* renamed from: n3 */
    public final boolean m19001n3() {
        HandlerThread handlerThread;
        Looper looper;
        synchronized (this.f13736r0) {
            try {
                if (isDestroyed()) {
                    C11839m.m70688i("BackupOptionsActivity", "initOpr current activity isDestroyed");
                    return false;
                }
                if (this.f13738t0 == null) {
                    HandlerThread handlerThread2 = new HandlerThread("cloudbackupoption");
                    this.f13738t0 = handlerThread2;
                    handlerThread2.start();
                    if (this.f13737s0 == null && (handlerThread = this.f13738t0) != null && (looper = handlerThread.getLooper()) != null) {
                        this.f13737s0 = new HandlerC3150j(looper);
                    }
                }
                return this.f13737s0 != null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n4 */
    public void m19002n4(boolean z10) {
        C11839m.m70688i("BackupOptionsActivity", "show backup data size, is first show: " + z10 + ", isShowDataSize: " + this.f13717Y);
        if (z10) {
            this.f13717Y = true;
        }
        if (this.f13717Y) {
            m18939E4(C0223k.m1524g(C0213f.m1377a(), m18955O2().m69963a()));
            this.f13718Z.m81065n("getDataTime", 0L);
            if (z10) {
                C12515a.m75110o().m75172d(new C3142b());
            }
        }
    }

    /* renamed from: o3 */
    public void m19003o3() {
        this.f13716X = ICBUtil.isSupportGallery(this);
    }

    /* renamed from: o4 */
    public void m19004o4(boolean z10) {
        C12515a.m75110o().m75172d(new C3072p2(z10));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 != 0) {
            m18888K4(i10);
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!this.f13729k0) {
            this.f13729k0 = safeIntent.getBooleanExtra("isNeedReportSwitchState", false);
        }
        if (this.f13719a0 == null) {
            this.f13719a0 = new C13026e();
        }
        List<BackupOptionItem> listM78399w = this.f13719a0.m78399w("thirdAppData");
        this.f13728j0 = listM78399w;
        if (listM78399w == null || listM78399w.isEmpty()) {
            C11839m.m70687e("BackupOptionsActivity", "appModule is empty, finish activity");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C11839m.m70688i("BackupOptionsActivity", "onBackPressed");
        m18953N2();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.detail_iv == id2) {
            m19017v4();
            return;
        }
        if (R$id.app_data_item_rel == id2) {
            Intent intent = new Intent(this, (Class<?>) BackupOptionsDetailActivity.class);
            intent.putExtra("source", this.f13731m0);
            intent.putExtra("showDeleteFlag", this.f13733o0);
            C13230i.m79525e1(intent, "1", "50");
            startActivityForResult(intent, 0);
            return;
        }
        if (R$id.bt_no_net == id2) {
            C11829c.m70612r1(this);
        } else if (R$id.rl_network_not_connect == id2) {
            m18989g4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11839m.m70688i("BackupOptionsActivity", "onConfigurationChanged status: " + configuration.orientation);
        if (!AbstractC14026a.m84159a(this.f13711S)) {
            runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17604a.m18942G3();
                }
            });
        }
        TipPopupLayout tipPopupLayout = this.f13690A0;
        if (tipPopupLayout != null) {
            tipPopupLayout.dismiss();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m19006p3();
        m18972Y3();
        m18910h3();
        C11839m.m70688i("BackupOptionsActivity", "activity created");
        this.f13723e0 = System.currentTimeMillis();
        CBCallBack.getInstance().registerCallback(this.f13691B0);
        m18990h4();
        m18989g4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        CBCallBack.getInstance().unregisterCallback(this.f13691B0);
        C12515a.m75110o().m75166b(C3072p2.class.getName());
        if (GetOptionsInfoFromCloneTask.isOptionTaskNotComplete()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f13724f0 = jCurrentTimeMillis;
            long j10 = (jCurrentTimeMillis - this.f13723e0) + this.f13725g0;
            C13465e c13465e = this.f13718Z;
            if (c13465e != null) {
                c13465e.m81065n("getDataTime", j10);
            }
        }
        CloseOptionStatusDialog closeOptionStatusDialog = this.f13720b0;
        if (closeOptionStatusDialog != null) {
            closeOptionStatusDialog.dismiss();
        }
        AlertDialog alertDialog = this.f13722d0;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        SpaceSwitchOpenTipsDialog spaceSwitchOpenTipsDialog = this.f13692C;
        if (spaceSwitchOpenTipsDialog != null) {
            spaceSwitchOpenTipsDialog.dismiss();
        }
        BackupThirdAppOpenNotEnoughDialog backupThirdAppOpenNotEnoughDialog = this.f13705M;
        if (backupThirdAppOpenNotEnoughDialog != null) {
            backupThirdAppOpenNotEnoughDialog.dismiss();
            this.f13705M = null;
        }
        TipPopupLayout tipPopupLayout = this.f13690A0;
        if (tipPopupLayout != null) {
            tipPopupLayout.dismiss();
        }
        m18981c4();
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        m18920q3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            C11839m.m70688i("BackupOptionsActivity", "onOptionsItemSelected home view click");
            m18953N2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e("BackupOptionsActivity", "hicloud is not login could not open BackupOptionsActivity");
            startActivity(new Intent(this, (Class<?>) NewHiSyncSettingActivity.class));
            finish();
        }
        this.f13698F = false;
        if (!this.f13699G) {
            this.f13699G = true;
        } else {
            C11839m.m70688i("BackupOptionsActivity", "onResume mResumeRequest : initCloudSpace ");
            m18993j3();
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionAdapter.UpdateOptionStatusListener
    public void onSystemItemClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (!C13452e.m80781L().m80887a1()) {
            m19017v4();
            return;
        }
        try {
            String string = getString(R$string.backup_option_basic_sys_data_tips, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp"));
            if (view instanceof TipPopupLayout) {
                TipPopupLayout tipPopupLayout = (TipPopupLayout) view;
                this.f13690A0 = tipPopupLayout;
                tipPopupLayout.setTipTxtStr(string);
                this.f13690A0.onClick(view);
            }
        } catch (Exception e10) {
            C11839m.m70687e("BackupOptionsActivity", "showTipWrap error, e = " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: p1 */
    public void mo19005p1() {
        List<View> listMo13289d1 = mo13289d1();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo13289d1);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo13289d1);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m22387z1(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: p3 */
    public void m19006p3() {
        LayoutInflater.from(this).inflate(R$layout.activity_backup_option, (ViewGroup) this.f13894y, true);
        m19000m4();
        m18999m3();
        mo19005p1();
        BackupOptionAdapter backupOptionAdapter = new BackupOptionAdapter(this);
        this.f13710R = backupOptionAdapter;
        backupOptionAdapter.m24763N(this);
    }

    /* renamed from: p4 */
    public final void m19007p4() {
        m18934A4();
    }

    /* renamed from: q4 */
    public void m19008q4(Message message) {
        this.f13739u0 = new C10343b((Bundle) message.obj).m63689k("backuped_data_size", 0L);
        m19007p4();
    }

    /* renamed from: r3 */
    public boolean m19009r3() {
        return this.f13698F;
    }

    /* renamed from: r4 */
    public void m19010r4(Message message) {
        if (C13452e.m80781L().m80887a1()) {
            return;
        }
        m18943G4(new C10343b((Bundle) message.obj).m63688j("backup_last_success_time"));
    }

    /* renamed from: s3 */
    public boolean m19011s3() {
        this.f13725g0 = this.f13718Z.m81058g("getDataTime", 0L);
        C11839m.m70688i("BackupOptionsActivity", "lastGetDataTime = " + (this.f13725g0 / 1000));
        return this.f13725g0 > 15000;
    }

    /* renamed from: s4 */
    public void m19012s4() {
        C11839m.m70688i("BackupOptionsActivity", "showList backupIOptionInitEnd = " + this.f13734p0);
        if (this.f13734p0 && this.f13735q0) {
            if (this.f13728j0 != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<BackupOptionItem> it = this.f13728j0.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getAppId());
                }
                Iterator<BackupOptionItem> it2 = this.f13711S.iterator();
                while (it2.hasNext()) {
                    BackupOptionItem next = it2.next();
                    if (arrayList.contains(next.getAppId())) {
                        it2.remove();
                    } else if ("thirdAppData".equals(next.getParent()) && !arrayList.contains(next.getAppId())) {
                        it2.remove();
                    }
                }
                this.f13711S.addAll(this.f13728j0);
                C11839m.m70688i("BackupOptionsActivity", "showList mThirdAppDatas = " + this.f13728j0.toString());
            }
            m18944H4();
            this.f13711S.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.z0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
                }
            });
            m18924t4(this.f13711S);
        }
    }

    /* renamed from: t3 */
    public final int m19013t3(String str, long j10) {
        long used;
        long total;
        CloudSpace cloudSpace = this.f13694D;
        if (cloudSpace == null) {
            QuotaSpaceInfo quotaSpaceInfo = this.f13702J;
            if (quotaSpaceInfo == null) {
                C11839m.m70688i("BackupOptionsActivity", "isSpaceEnough , bakSize == null || cloudSpace == null");
                return 2;
            }
            used = quotaSpaceInfo.getUsed();
            total = this.f13702J.getTotal();
        } else {
            used = cloudSpace.getUsed();
            total = this.f13694D.getTotal();
        }
        long jM18986f3 = m18986f3(str);
        C11839m.m70688i("BackupOptionsActivity", "isSpaceEnough , used  = " + used + " , total = " + total + " , getIncrease = " + j10 + " , checkSize " + jM18986f3);
        return C11333k.m68086b().m68088c(((total - used) - j10) - jM18986f3);
    }

    /* renamed from: u3 */
    public final /* synthetic */ Void m19014u3(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2, String str) {
        if ("2".equals(str)) {
            BackupOptionAdapter backupOptionAdapter = this.f13710R;
            if (backupOptionAdapter != null) {
                backupOptionAdapter.m24766Q(backupOptionItem.getAppId(), false);
            }
            m18968W3(false, backupOptionItem.getAppId(), Long.valueOf(System.currentTimeMillis()), backupOptionItem2);
        }
        m19002n4(false);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003d  */
    /* renamed from: u4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m19015u4(com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r16, long r17, java.util.function.Function<java.lang.String, java.lang.Void> r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r19
            com.huawei.hicloud.base.bean.CloudSpace r3 = r0.f13694D
            if (r3 != 0) goto L1f
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r3 = r0.f13702J
            if (r3 == 0) goto L1a
            long r3 = r3.getAvailable()
            com.huawei.hicloud.base.bean.QuotaSpaceInfo r5 = r0.f13702J
            long r5 = r5.getTotal()
        L17:
            r7 = r3
            r9 = r5
            goto L31
        L1a:
            r3 = 0
            r7 = r3
            r9 = r7
            goto L31
        L1f:
            long r3 = r3.getTotal()
            com.huawei.hicloud.base.bean.CloudSpace r5 = r0.f13694D
            long r5 = r5.getUsed()
            long r3 = r3 - r5
            com.huawei.hicloud.base.bean.CloudSpace r5 = r0.f13694D
            long r5 = r5.getTotal()
            goto L17
        L31:
            java.lang.String r3 = r16.getAppId()
            r4 = 0
            com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem r3 = com.huawei.android.hicloud.cloudbackup.util.TransferedUtil.queryMergeTwinItem(r3, r4)
            if (r3 != 0) goto L3d
            return
        L3d:
            java.lang.String r5 = r16.getAppId()
            long r13 = r15.m18986f3(r5)
            r11 = r17
            boolean r5 = com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil.isSpaceRunningOut(r7, r9, r11, r13)
            if (r5 == 0) goto L78
            com.huawei.android.hicloud.ui.uiadapter.BackupOptionAdapter r5 = r0.f13710R
            if (r5 == 0) goto L58
            java.lang.String r6 = r16.getAppId()
            r5.m24766Q(r6, r4)
        L58:
            com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog r4 = new com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchOpenTipsDialog
            android.content.Context r5 = r15.m18905d3()
            java.lang.String r3 = r3.getAppId()
            java.lang.String r3 = p618rm.C12590s0.m75770M(r5, r3)
            com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$i r5 = new com.huawei.android.hicloud.ui.activity.BackupOptionsActivity$i
            r5.<init>(r1, r2)
            r4.<init>(r15, r3, r5)
            r0.f13692C = r4
            r4.show()
            r0 = 1
            r1.setAlmostFullDialogShow(r0)
            goto L86
        L78:
            java.lang.String r1 = r16.getAppId()
            r15.m18951M2(r1)
            if (r2 == 0) goto L86
            java.lang.String r0 = "0"
            r2.apply(r0)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity.m19015u4(com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem, long, java.util.function.Function):void");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        C11839m.m70688i("BackupOptionsActivity", "onKeyBackPressed");
        m18953N2();
        return true;
    }

    /* renamed from: v3 */
    public final /* synthetic */ Void m19016v3(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2, Boolean bool) {
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24766Q(backupOptionItem.getAppId(), false);
        }
        m19002n4(false);
        m18968W3(false, backupOptionItem.getAppId(), Long.valueOf(System.currentTimeMillis()), backupOptionItem2);
        return null;
    }

    /* renamed from: v4 */
    public void m19017v4() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.hicloud_new_backup_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.new_backup_auto);
        ((TextView) C12809f.m76831d(viewInflate, R$id.backup_tip)).setVisibility(8);
        textView.setText(getString(R$string.backup_option_basic_sys_data_tips, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp")));
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || (movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate).setTitle(R$string.backup_option_sys_tip_title).setPositiveButton(R$string.cloud_space_dialog_know, new DialogInterfaceOnClickListenerC3141a());
        AlertDialog alertDialogCreate = builder.create();
        this.f13722d0 = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: w3 */
    public final /* synthetic */ Void m19018w3(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2, String str) {
        if (!"2".equals(str)) {
            return null;
        }
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24766Q(backupOptionItem.getAppId(), false);
        }
        m19002n4(false);
        m18968W3(false, backupOptionItem.getAppId(), Long.valueOf(System.currentTimeMillis()), backupOptionItem2);
        return null;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionAdapter.UpdateOptionStatusListener
    /* renamed from: x */
    public void mo19019x(int i10, final String str, final boolean z10, BackupOptionItem backupOptionItem) {
        if (z10) {
            BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
            if (backupOptionItemQueryItem == null) {
                m18977b3(str);
            }
            C11839m.m70688i("BackupOptionsActivity", "onCheckChanged appId: " + str);
            m18968W3(true, backupOptionItem.getAppId(), Long.valueOf(System.currentTimeMillis()), backupOptionItemQueryItem);
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16470a.m18940F3(str, z10);
                }
            });
            m18992i4(backupOptionItem.getAppId());
            return;
        }
        if (m18971Y2()) {
            m18957Q2(str, false, backupOptionItem);
            C11829c.m70612r1(this);
            return;
        }
        String strM16079E = C14333b.m85486u().containsKey(str) ? C2783d.m16079E(m18905d3(), str) : NewHiSyncUtil.m25632b(str);
        C11839m.m70688i("BackupOptionsActivity", "close module switch appId: " + str + ";appName:" + strM16079E);
        this.f13720b0.showHasTitleDialog(getString(R$string.backup_dialog_close_option_title, strM16079E), getString(R$string.backup_dialog_close_option_content2, strM16079E), getString(R$string.backup_dialog_close_option_tips, strM16079E), str, this.f13733o0, backupOptionItem);
        if (C0209d.m1220W0()) {
            return;
        }
        this.f13720b0.getButton(-1).setTextColor(getResources().getColor(R$color.enui50_red_color));
    }

    /* renamed from: x3 */
    public final /* synthetic */ Void m19020x3(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2, Boolean bool) {
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter != null) {
            backupOptionAdapter.m24766Q(backupOptionItem.getAppId(), false);
        }
        m19002n4(false);
        m18968W3(false, backupOptionItem.getAppId(), Long.valueOf(System.currentTimeMillis()), backupOptionItem2);
        return null;
    }

    /* renamed from: x4 */
    public final void m19021x4(BackupOptionItem backupOptionItem, Function<Boolean, Void> function) {
        if (this.f13710R == null) {
            C11839m.m70687e("BackupOptionsActivity", "backupOptionAdapter is null");
            return;
        }
        if (isFinishing() || isDestroyed()) {
            C11839m.m70687e("BackupOptionsActivity", "activity is finishing");
            return;
        }
        this.f13710R.m24766Q(backupOptionItem.getAppId(), false);
        this.f13703K = false;
        this.f13705M = new BackupThirdAppOpenNotEnoughDialog(this, new C3148h(function));
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(backupOptionItem.getAppId(), false);
        String strM75770M = backupOptionItemQueryItem != null ? C12590s0.m75770M(m18905d3(), backupOptionItemQueryItem.getAppId()) : "";
        this.f13705M.setTitleTips(getString(R$string.backup_app_space_not_enough_title, strM75770M));
        this.f13705M.setTipContent(strM75770M);
        this.f13705M.show();
        m18994j4();
        backupOptionItem.setNotEnoughDialogShow(true);
    }

    /* renamed from: y3 */
    public final /* synthetic */ Void m19022y3(List list, final BackupOptionItem backupOptionItem, final BackupOptionItem backupOptionItem2, String str) {
        if ("1".equals(str)) {
            m18959S2((BackupOptionItem) list.get(1), new Function() { // from class: com.huawei.android.hicloud.ui.activity.t0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f17732a.m19014u3(backupOptionItem, backupOptionItem2, (String) obj);
                }
            }, new Function() { // from class: com.huawei.android.hicloud.ui.activity.u0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f17749a.m19016v3(backupOptionItem, backupOptionItem2, (Boolean) obj);
                }
            });
            return null;
        }
        if (!"0".equals(str) || backupOptionItem.isAlmostFullDialogShow() || backupOptionItem.isNotEnoughDialogShow()) {
            return null;
        }
        m18959S2((BackupOptionItem) list.get(1), new Function() { // from class: com.huawei.android.hicloud.ui.activity.v0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17766a.m19018w3(backupOptionItem, backupOptionItem2, (String) obj);
            }
        }, new Function() { // from class: com.huawei.android.hicloud.ui.activity.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17781a.m19020x3(backupOptionItem, backupOptionItem2, (Boolean) obj);
            }
        });
        return null;
    }

    /* renamed from: y4 */
    public final void m19023y4() {
        BackupOptionAdapter backupOptionAdapter = this.f13710R;
        if (backupOptionAdapter == null || backupOptionAdapter.m24760I().isEmpty()) {
            return;
        }
        List<BackupOptionItem> listM24760I = this.f13710R.m24760I();
        C11839m.m70688i("BackupOptionsActivity", "tryUpdateUiData itemList" + listM24760I.size());
        C12515a.m75110o().m75172d(new TryUpdateOptionModuleInfoTask(listM24760I, new TryUpdateOptionModuleInfoTask.UpdateOptionInfoCallback() { // from class: com.huawei.android.hicloud.ui.activity.i0
            @Override // com.huawei.android.hicloud.task.simple.TryUpdateOptionModuleInfoTask.UpdateOptionInfoCallback
            /* renamed from: a */
            public final void mo18127a(List list) {
                this.f17633a.m18962T3(list);
            }
        }));
    }
}
