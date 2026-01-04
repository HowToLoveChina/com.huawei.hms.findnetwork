package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.fragment.RecommendFragment;
import com.huawei.android.hicloud.p088ui.uiadapter.BaseDataItemRecyclerAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.BackupLinkClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.AddToDesktopDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MergeAlertDialog;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.ModuleItemForAll;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$color;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import je.C10801o;
import je.C10804r;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p053ce.C1424b;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p335hd.C10147j;
import p336he.C10155f;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p664u0.C13108a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13461a;
import p737wd.AlertDialogC13588a;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p807yd.C13945a;
import p847zk.C14317j;
import sk.C12809f;
import vn.C13471c;

/* loaded from: classes3.dex */
public class SyncAndBackupMainActivity extends BaseActivity implements DialogCallback, SyncItemRecyclerAdapter.OnCheckedChangedListener, SyncItemRecyclerAdapter.OnItemClickListener {

    /* renamed from: B */
    public RelativeLayout f16041B;

    /* renamed from: F */
    public boolean f16045F;

    /* renamed from: H */
    public C13945a f16047H;

    /* renamed from: J */
    public AlertDialogC13588a f16049J;

    /* renamed from: L */
    public CutOutProgressDialog f16051L;

    /* renamed from: M */
    public boolean f16052M;

    /* renamed from: N */
    public boolean f16053N;

    /* renamed from: P */
    public boolean f16055P;

    /* renamed from: Q */
    public SyncItemInfo f16056Q;

    /* renamed from: S */
    public View f16058S;

    /* renamed from: U */
    public RecommendFragment f16060U;

    /* renamed from: V */
    public ArrayList<RecommendCard> f16061V;

    /* renamed from: W */
    public boolean f16062W;

    /* renamed from: X */
    public boolean f16063X;

    /* renamed from: Y */
    public boolean f16064Y;

    /* renamed from: Z */
    public boolean f16065Z;

    /* renamed from: a0 */
    public RelativeLayout f16066a0;

    /* renamed from: b0 */
    public SpanClickText f16067b0;

    /* renamed from: c0 */
    public AddToDesktopDialog f16068c0;

    /* renamed from: h0 */
    public TextView f16073h0;

    /* renamed from: i0 */
    public TextView f16074i0;

    /* renamed from: j0 */
    public ImageView f16075j0;

    /* renamed from: k0 */
    public List<String> f16076k0;

    /* renamed from: m0 */
    public View f16078m0;

    /* renamed from: n0 */
    public AlertDialog f16079n0;

    /* renamed from: o0 */
    public View f16080o0;

    /* renamed from: p */
    public View f16081p;

    /* renamed from: p0 */
    public ImageView f16082p0;

    /* renamed from: q */
    public BaseDataItemRecyclerAdapter f16083q;

    /* renamed from: r */
    public HwRecyclerView f16085r;

    /* renamed from: s */
    public C1424b f16087s;

    /* renamed from: t */
    public SyncItemInfo f16089t;

    /* renamed from: u */
    public SyncItemInfo f16090u;

    /* renamed from: v */
    public SyncItemInfo f16091v;

    /* renamed from: w */
    public SyncItemInfo f16092w;

    /* renamed from: x */
    public SyncItemInfo f16093x;

    /* renamed from: y */
    public SyncItemInfo f16094y;

    /* renamed from: z */
    public boolean f16095z = false;

    /* renamed from: A */
    public boolean f16040A = false;

    /* renamed from: C */
    public CopyOnWriteArrayList<SyncItemInfo> f16042C = new CopyOnWriteArrayList<>();

    /* renamed from: D */
    public CopyOnWriteArrayList<SyncItemInfo> f16043D = new CopyOnWriteArrayList<>();

    /* renamed from: E */
    public LinkedHashMap<String, SyncItemInfo> f16044E = new LinkedHashMap<>();

    /* renamed from: G */
    public boolean f16046G = true;

    /* renamed from: I */
    public HashMap<String, MergeAlertDialog> f16048I = new HashMap<>();

    /* renamed from: K */
    public C10028c f16050K = null;

    /* renamed from: O */
    public boolean f16054O = false;

    /* renamed from: R */
    public C10804r f16057R = null;

    /* renamed from: T */
    public boolean f16059T = false;

    /* renamed from: d0 */
    public String f16069d0 = null;

    /* renamed from: e0 */
    public String f16070e0 = null;

    /* renamed from: f0 */
    public Activity f16071f0 = null;

    /* renamed from: g0 */
    public HiSyncReceiver f16072g0 = null;

    /* renamed from: l0 */
    public final Handler.Callback f16077l0 = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.p8
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17703a.m22242W2(message);
        }
    };

    /* renamed from: q0 */
    public Handler f16084q0 = new HandlerC3481b();

    /* renamed from: r0 */
    public Handler f16086r0 = new HandlerC3483d();

    /* renamed from: s0 */
    public Handler f16088s0 = new HandlerC3486g();

    public class HiSyncReceiver extends BroadcastReceiver {
        public HiSyncReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action.equals("action_drive_parse_config_finish")) {
                SyncAndBackupMainActivity.this.m22289r3(context);
                return;
            }
            if (action.equals("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START")) {
                String stringExtra = safeIntent.getStringExtra("");
                C11839m.m70688i("SyncAndBackupMianActivity", "Constant.Action.UI_NOTIFY_SYNC_START moduleName=" + stringExtra);
                SyncAndBackupMainActivity.this.f16047H.m83831I(stringExtra);
                return;
            }
            if (!"com.huawei.hicloud.action.UI_NOTIFY_SYNC_END".equals(action)) {
                if ("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH".equals(action)) {
                    SyncAndBackupMainActivity.this.m22262d3(false, safeIntent.getStringExtra("syncType"), 15);
                    return;
                }
                return;
            }
            String stringExtra2 = safeIntent.getStringExtra("");
            C11839m.m70688i("SyncAndBackupMianActivity", "Constant.Action.UI_NOTIFY_SYNC_END moduleName=" + stringExtra2);
            SyncAndBackupMainActivity.this.f16047H.m83830H(stringExtra2);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$a */
    public class C3480a extends AbstractC12367d {
        public C3480a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            SyncAndBackupMainActivity.this.f16084q0.sendEmptyMessageDelayed(20002, 300L);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$b */
    public class HandlerC3481b extends Handler {
        public HandlerC3481b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 20002) {
                C11839m.m70688i("SyncAndBackupMianActivity", "NOTIFY_SYNC_ITEM_FRESH");
                SyncAndBackupMainActivity.this.m22250Z2();
            } else {
                C11839m.m70687e("SyncAndBackupMianActivity", "commonHandler invalid message :" + message.what);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$c */
    public class RunnableC3482c implements Runnable {
        public RunnableC3482c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SyncAndBackupMainActivity.this.f16083q != null) {
                SyncAndBackupMainActivity.this.f16083q.m25290f0(SyncAndBackupMainActivity.this.f16044E);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$d */
    public class HandlerC3483d extends Handler {
        public HandlerC3483d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("SyncAndBackupMianActivity", "handleMessage, case: " + message.what);
            int i10 = message.what;
            if (i10 == 1022) {
                C10028c.m62183d0(SyncAndBackupMainActivity.this.f16071f0).m62197C2("get_notepad_history_time", System.currentTimeMillis());
                SyncAndBackupMainActivity.this.m22203F2(message);
            } else {
                if (i10 != 9010) {
                    return;
                }
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                C11839m.m70686d("SyncAndBackupMianActivity", "mSyncHandler isGallerySynOn");
                if (!zBooleanValue) {
                    SyncAndBackupMainActivity.this.m22270h2();
                } else if (SyncAndBackupMainActivity.this.f16047H != null) {
                    SyncAndBackupMainActivity.this.f16047H.m83891z0();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$e */
    public class RunnableC3484e implements Runnable {
        public RunnableC3484e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SyncAndBackupMainActivity.this.f16083q != null) {
                SyncAndBackupMainActivity.this.f16083q.m25290f0(SyncAndBackupMainActivity.this.f16044E);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$f */
    public class RunnableC3485f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f16102a;

        public RunnableC3485f(String str) {
            this.f16102a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SyncAndBackupMainActivity.this.f16083q != null) {
                SyncAndBackupMainActivity.this.f16083q.m25287c0(this.f16102a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$g */
    public class HandlerC3486g extends Handler {
        public HandlerC3486g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SyncAndBackupMainActivity.this.isFinishing() || SyncAndBackupMainActivity.this.isDestroyed()) {
                C11839m.m70687e("SyncAndBackupMianActivity", "the activity is not avaiable");
            } else {
                SyncAndBackupMainActivity.this.m22301B2(message);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$h */
    public class RunnableC3487h implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f16105a;

        public RunnableC3487h(String str) {
            this.f16105a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SyncAndBackupMainActivity.this.f16083q != null) {
                SyncAndBackupMainActivity.this.f16083q.m25286b0(this.f16105a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$i */
    public class C3488i extends AbstractC12367d {
        public C3488i() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            SyncAndBackupMainActivity syncAndBackupMainActivity = SyncAndBackupMainActivity.this;
            syncAndBackupMainActivity.f16076k0 = syncAndBackupMainActivity.m22291t2();
            List<String> listM69907f = SyncAndBackupMainActivity.this.f22163b.m69907f(SyncAndBackupMainActivity.this.f16076k0);
            C11839m.m70688i("SyncAndBackupMianActivity", "Need Permissions Size:" + listM69907f.size());
            if (SyncAndBackupMainActivity.this.f16050K.m62388s("addressbook") || SyncAndBackupMainActivity.this.f16050K.m62388s("calendar")) {
                SyncAndBackupMainActivity.this.m29142y0(listM69907f);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$j */
    public static class C3489j implements SpanClickText.ISpanClickListener {

        /* renamed from: a */
        public TextView f16108a;

        /* renamed from: b */
        public Context f16109b;

        /* renamed from: c */
        public Bundle f16110c;

        public C3489j(Context context, TextView textView, Bundle bundle) {
            this.f16108a = textView;
            this.f16109b = context;
            this.f16110c = bundle;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() {
            if (this.f16108a == null) {
                return;
            }
            if (C0209d.m1226Y0()) {
                C11839m.m70687e("SyncAndBackupMianActivity", "fast click");
                return;
            }
            C13225d.m79490f1().m79585f0("mecloud_main_click_more_data", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_more_data", "1", "37");
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c != null) {
                interfaceC9284c.mo17132k(this.f16109b, this.f16110c);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$k */
    public class DialogInterfaceOnCancelListenerC3490k implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        public String f16111a;

        public DialogInterfaceOnCancelListenerC3490k(String str) {
            this.f16111a = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C11839m.m70688i("SyncAndBackupMianActivity", "onCancel module:" + this.f16111a);
            SyncAndBackupMainActivity.this.f16050K.m62336h2(this.f16111a, false);
            C1008c.m6035v().m6046K(SyncAndBackupMainActivity.this.f16071f0, this.f16111a, 0);
            C13225d.m79490f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f16111a);
            if (SyncAndBackupMainActivity.this.f16047H != null) {
                SyncAndBackupMainActivity.this.f16047H.m83858i0(this.f16111a, Boolean.FALSE);
            }
            SyncAndBackupMainActivity.this.m22254a4("");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncAndBackupMainActivity$l */
    public class DialogInterfaceOnClickListenerC3491l implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public String f16113a;

        public DialogInterfaceOnClickListenerC3491l(String str) {
            this.f16113a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                C11839m.m70688i("SyncAndBackupMianActivity", "positive module:" + this.f16113a);
                SyncAndBackupMainActivity.this.f16050K.m62336h2(this.f16113a, true);
                C1008c.m6035v().m6046K(SyncAndBackupMainActivity.this.f16071f0, this.f16113a, 1);
                C13225d.m79490f1().m79599w0(true, "CLOUDBACKUP_OPEN_DRIVE_APP_SWITCH", this.f16113a);
                if (SyncAndBackupMainActivity.this.f16047H != null) {
                    SyncAndBackupMainActivity.this.f16047H.m83858i0(this.f16113a, Boolean.TRUE);
                }
            } else if (-2 == i10) {
                C11839m.m70688i("SyncAndBackupMianActivity", "negative module:" + this.f16113a);
                SyncAndBackupMainActivity.this.f16050K.m62336h2(this.f16113a, false);
                C1008c.m6035v().m6046K(SyncAndBackupMainActivity.this.f16071f0, this.f16113a, 0);
                C13225d.m79490f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f16113a);
                if (SyncAndBackupMainActivity.this.f16047H != null) {
                    SyncAndBackupMainActivity.this.f16047H.m83858i0(this.f16113a, Boolean.FALSE);
                }
            }
            SyncAndBackupMainActivity.this.m22254a4("");
        }
    }

    /* renamed from: A3 */
    private void m22195A3(String str) {
        C10804r c10804r = this.f16057R;
        if (c10804r != null) {
            c10804r.m65764k(str);
        }
    }

    /* renamed from: B3 */
    private void m22196B3(ArrayList<DriveConfigService> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f16043D.clear();
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            DriveConfigService driveConfigService = arrayList.get(i10);
            SyncItemInfo syncItemInfoM22292u2 = m22292u2(driveConfigService.getId(), new SyncItemInfo());
            syncItemInfoM22292u2.setDriveConfig(true);
            syncItemInfoM22292u2.setId(driveConfigService.getId());
            syncItemInfoM22292u2.setTitle(driveConfigService.getTitleText());
            syncItemInfoM22292u2.setSubUser(driveConfigService.isSubUser());
            syncItemInfoM22292u2.setShowDivider(driveConfigService.isShowDivider());
            this.f16043D.add(syncItemInfoM22292u2);
        }
    }

    /* renamed from: C2 */
    private boolean m22197C2(Message message) {
        int i10 = message.what;
        if (i10 != 11 && i10 != 15 && i10 != 67) {
            if (i10 == 102) {
                C11839m.m70688i("SyncAndBackupMianActivity", "finish,msg_sim_change_pwd_check_failed");
                finish();
                return true;
            }
            if (i10 != 116 && i10 != 1003 && i10 != 1202) {
                return i10 == 99001;
            }
        }
        m22201E2(message);
        return true;
    }

    /* renamed from: C3 */
    private void m22198C3(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            if (z10) {
                syncItemInfo.setStatusText(getString(R$string.cloudalbum_switch_open));
            } else {
                syncItemInfo.setStatusText(getString(R$string.sync_switch_button_close));
                syncItemInfo.setNoSubTitle(true);
                syncItemInfo.setShowSubTitle(false);
            }
            m22287q3(syncItemInfo);
            if (C10155f.m63299w()) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 9010;
                messageObtain.obj = Boolean.valueOf(z10);
                this.f16086r0.sendMessage(messageObtain);
            }
        }
    }

    /* renamed from: D2 */
    private boolean m22199D2(Message message) {
        C11839m.m70686d("SyncAndBackupMianActivity", "message type is " + message.what);
        int i10 = message.what;
        if (i10 == 0) {
            Object obj = message.obj;
            if (obj == null || !(obj instanceof Dialog)) {
                return true;
            }
            m22195A3("PUSH_MARKETING_NOTICE");
            m22195A3("CLAM_POP");
            m22195A3("GET_SPACE_OK_H5_DIALOG");
            this.f16057R.m65765l("POLICY_SERVICE", (Dialog) obj);
            this.f16057R.m65754a("POLICY_SERVICE");
            return true;
        }
        if (i10 == 3) {
            this.f16057R.m65765l("POLICY_SERVICE", null);
            this.f16057R.m65754a("POLICY_SERVICE");
            return true;
        }
        if (i10 == 9007) {
            Object obj2 = message.obj;
            if (obj2 == null || !(obj2 instanceof Boolean) || ((Boolean) obj2).booleanValue()) {
                m22279m3();
            }
            RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, false);
            return true;
        }
        if (i10 != 10035) {
            if (i10 != 1000007) {
                return true;
            }
            m22277k3(message);
            return true;
        }
        Object obj3 = message.obj;
        if (obj3 == null || !(obj3 instanceof ModuleItemForAll)) {
            return true;
        }
        m22274j2((ModuleItemForAll) obj3);
        return true;
    }

    /* renamed from: D3 */
    private void m22200D3(SpanClickText spanClickText, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(NavigationUtils.SMS_SCHEMA_PREF, this.f16062W);
        bundle.putBoolean("calllog", this.f16063X);
        bundle.putBoolean("recordig", this.f16064Y);
        bundle.putBoolean("phonemanager", this.f16065Z);
        bundle.putBoolean("isShowCloudDisk", false);
        BackupLinkClickListener backupLinkClickListener = new BackupLinkClickListener(this.f16071f0, spanClickText);
        C3489j c3489j = new C3489j(this.f16071f0, spanClickText, bundle);
        spanClickText.m15931c(str2, backupLinkClickListener);
        spanClickText.m15931c(str3, c3489j);
        spanClickText.m15934g(str, false);
    }

    /* renamed from: E2 */
    private void m22201E2(Message message) {
        C11839m.m70686d("SyncAndBackupMianActivity", "task end ,module " + message.what);
    }

    /* renamed from: E3 */
    private void m22202E3(String str) {
        m22200D3(this.f16067b0, str, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F2 */
    public void m22203F2(Message message) {
        C11839m.m70686d("SyncAndBackupMianActivity", "notepad history message type is " + message.arg1);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f16071f0);
        this.f16094y.setHideLoading(true);
        int i10 = message.arg1;
        if (i10 == -10 || i10 == -5) {
            C11839m.m70688i("SyncAndBackupMianActivity", "notepad history no data or service unavaliable");
            boolean zM62388s = c10028cM62183d0.m62388s("notepad");
            c10028cM62183d0.m62336h2("notepad_has_history_data", false);
            this.f16095z = false;
            this.f16094y.setCheckedProgrammatically(zM62388s);
            this.f16094y.setShowSwitchLayout(true);
            this.f16094y.setOnClick(false);
        } else if (i10 == 0) {
            C11839m.m70688i("SyncAndBackupMianActivity", "notepad history query success");
            c10028cM62183d0.m62336h2("notepad_has_history_data", true);
            this.f16095z = true;
            this.f16094y.setShowStatusLayout(true);
            this.f16094y.setOnClick(true);
            if (c10028cM62183d0.m62388s("notepad")) {
                this.f16094y.setStatusText(getString(R$string.settings_hicloud_open));
            } else {
                this.f16094y.setStatusText(getString(R$string.sync_switch_button_close));
            }
        }
        m22287q3(this.f16094y);
    }

    /* renamed from: F3 */
    private void m22204F3(String str, boolean z10) {
        if (str.equals("addressbook")) {
            this.f16052M = z10;
        }
        if (str.equals("calendar")) {
            this.f16053N = z10;
        }
    }

    /* renamed from: G2 */
    private void m22205G2() {
        this.f16080o0 = C12809f.m76829b(this, R$id.base_backup_item);
        this.f16073h0 = (TextView) C12809f.m76829b(this, R$id.base_backup_item_subtitle);
        this.f16074i0 = (TextView) C12809f.m76829b(this, R$id.backup_item_title);
        this.f16075j0 = (ImageView) C12809f.m76829b(this, R$id.iv_pop_notify);
        this.f16082p0 = (ImageView) C12809f.m76829b(this, R$id.base_arrow_iv);
        this.f16078m0 = C12809f.m76829b(this, R$id.base_content_loading_bar);
        if (!C10155f.m63301y() || C0209d.m1293p1() || !C10028c.m62182c0().m62413x()) {
            this.f16080o0.setVisibility(8);
        }
        if (!C0209d.m1166E1()) {
            this.f16080o0.setEnabled(false);
            this.f16073h0.setAlpha(0.62f);
            this.f16074i0.setAlpha(0.62f);
            this.f16075j0.setAlpha(0.62f);
        }
        this.f16080o0.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.q8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17711a.m22307V2(view);
            }
        });
    }

    /* renamed from: G3 */
    private void m22206G3() {
        if (this.f16061V.size() == 0) {
            C11839m.m70688i("SyncAndBackupMianActivity", "setRecommendView size 0");
            this.f16058S.setVisibility(8);
            return;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "setRecommendView size:" + this.f16061V.size());
        this.f16060U.m24181A(this.f16061V);
        this.f16058S.setVisibility(0);
        if (this.f16055P) {
            return;
        }
        this.f16058S.setVisibility(8);
    }

    /* renamed from: H3 */
    private void m22207H3(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            SyncItemInfo syncItemInfoM22292u2 = m22292u2(syncItemInfo.getId(), syncItemInfo);
            syncItemInfoM22292u2.setCheckedProgrammatically(z10);
            this.f16044E.put(syncItemInfoM22292u2.getId(), syncItemInfoM22292u2);
            m22212K3();
            if (z10) {
                C3948f.m24064g().m24078r(syncItemInfoM22292u2.getId(), 1);
            }
        }
    }

    /* renamed from: I3 */
    private void m22208I3(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            if (z10) {
                syncItemInfo.setStatusText(getString(R$string.settings_hicloud_open));
            } else {
                syncItemInfo.setStatusText(getString(R$string.sync_switch_button_close));
            }
            m22287q3(syncItemInfo);
        }
    }

    /* renamed from: J2 */
    private void m22209J2() {
        C11839m.m70687e("SyncAndBackupMianActivity", "receive ACTION_DRIVE_PARSE_CONFIG_FINISH, do refreshDriveItemView");
        if (this.f16072g0 == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f16072g0 = new HiSyncReceiver();
            intentFilter.addAction("action_drive_parse_config_finish");
            intentFilter.addAction("action_parse_config_finish");
            intentFilter.addAction("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
            intentFilter.addAction("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START");
            intentFilter.addAction("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END");
            intentFilter.addAction("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH");
            C13108a.m78878b(this.f16071f0.getApplicationContext()).m78880c(this.f16072g0, intentFilter);
        }
    }

    /* renamed from: J3 */
    private void m22210J3(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            return;
        }
        String title = syncItemInfo.getTitle();
        int visible = syncItemInfo.getVisible();
        String id2 = syncItemInfo.getId();
        if (TextUtils.isEmpty(id2) || TextUtils.isEmpty(title) || visible == 8) {
            return;
        }
        this.f16044E.put(id2, syncItemInfo);
    }

    /* renamed from: K2 */
    private void m22211K2() {
        this.f16051L = new CutOutProgressDialog(this.f16071f0);
        if (this.f16068c0 != null) {
            this.f16068c0 = null;
        }
    }

    /* renamed from: K3 */
    private void m22212K3() {
        m22248Y3(new RunnableC3484e());
    }

    /* renamed from: L2 */
    private void m22213L2() {
        m22286q2(Constant.C2794f.m16246a());
    }

    /* renamed from: L3 */
    private void m22214L3(ArrayList<SyncConfigService> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f16042C.clear();
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            SyncConfigService syncConfigService = arrayList.get(i10);
            SyncItemInfo syncItemInfoM22292u2 = m22292u2(syncConfigService.getId(), new SyncItemInfo());
            boolean z10 = true;
            syncItemInfoM22292u2.setSyncConfig(true);
            syncItemInfoM22292u2.setId(syncConfigService.getId());
            syncItemInfoM22292u2.setTitle(syncConfigService.getTitleText());
            syncItemInfoM22292u2.setSubUser(syncConfigService.isSubUser());
            syncItemInfoM22292u2.setShowDivider(syncConfigService.isShowDivider());
            if (!C10028c.m62182c0().m62388s(syncConfigService.getId()) && !syncConfigService.getSwitchStatus()) {
                z10 = false;
            }
            syncItemInfoM22292u2.setSwitchStatus(z10);
            syncItemInfoM22292u2.setSyncItemSubtitleStatus(syncConfigService.getSyncItemSubtitleStatus());
            syncItemInfoM22292u2.setSubStringText(syncConfigService.getSubStringText());
            syncItemInfoM22292u2.setIconPath(syncConfigService.getIconPath());
            this.f16042C.add(syncItemInfoM22292u2);
        }
    }

    /* renamed from: M2 */
    private void m22216M2() {
        ArrayList<SyncItemInfo> arrayListM22294v2;
        if (this.f16083q == null || (arrayListM22294v2 = m22294v2()) == null || arrayListM22294v2.isEmpty()) {
            return;
        }
        Iterator<SyncItemInfo> it = arrayListM22294v2.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            next.setSwitchStatus(this.f16050K.m62388s(next.getId()));
        }
        this.f16083q.m5213j();
    }

    /* renamed from: M3 */
    private void m22217M3(String str, int i10) {
        if (str == null) {
            C11839m.m70687e("SyncAndBackupMianActivity", "setSyncSwitchOff, moduleName is null");
            return;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "setSyncSwitchOff, moduleName is " + str);
        C13945a c13945a = this.f16047H;
        if (c13945a != null) {
            c13945a.m83832J(str);
        }
        switch (str) {
            case "addressbook":
                this.f16089t.setCheckedProgrammatically(false);
                m22287q3(this.f16089t);
                this.f16050K.m62336h2("addressbook", false);
                C1008c.m6035v().m6103u0(this.f16071f0, "addressbook");
                C1008c.m6035v().m6082k(this.f16071f0, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                C13223b.m79477e(this.f16071f0, "addressbook", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("addressbook"), "1", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, i10);
                break;
            case "gallery":
                Bundle bundle = new Bundle();
                bundle.putBoolean("GeneralAblum", false);
                C1006a.m5936k().m5943G(this, bundle, 12);
                C1008c.m6035v().m6053R(this, false);
                break;
            case "calendar":
                this.f16091v.setCheckedProgrammatically(false);
                m22287q3(this.f16091v);
                this.f16050K.m62336h2("calendar", false);
                C10028c.m62182c0().m62348k(str);
                C13223b.m79477e(this.f16071f0, "calendar", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("calendar"), "1", "11", i10);
                break;
            case "wlan":
                this.f16092w.setCheckedProgrammatically(false);
                m22287q3(this.f16092w);
                this.f16050K.m62336h2("wlan", false);
                C1008c.m6035v().m6061Z("dsswitch");
                C1008c.m6035v().m6103u0(this.f16071f0, "wlan");
                C1008c.m6035v().m6082k(this.f16071f0, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
                C13223b.m79477e(this.f16071f0, "wlan", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("wlan"), "1", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, i10);
                break;
            case "browser":
                this.f16090u.setCheckedProgrammatically(false);
                m22287q3(this.f16090u);
                this.f16050K.m62336h2("browser", false);
                C13223b.m79477e(this.f16071f0, "browser", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("browser"), "1", "20", i10);
                break;
            case "notepad":
                this.f16094y.setCheckedProgrammatically(false);
                m22287q3(this.f16094y);
                this.f16050K.m62336h2("notepad", false);
                C13223b.m79477e(this, "notepad", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("notepad"), "1", "10", i10);
                break;
            default:
                C13945a c13945a2 = this.f16047H;
                if (c13945a2 != null) {
                    c13945a2.m83858i0(str, Boolean.FALSE);
                }
                this.f16050K.m62336h2(str, false);
                NotifyConstants.putServicesMoudleIntoMap(str, false);
                C13223b.m79477e(this.f16071f0, str, false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get(str), "1", "29", i10);
                break;
        }
        C10155f.m63262O(this.f16071f0, false);
    }

    /* renamed from: N2 */
    private boolean m22219N2() {
        boolean z10 = false;
        if (this.f16083q == null) {
            return false;
        }
        ArrayList<SyncItemInfo> arrayListM22294v2 = m22294v2();
        if (arrayListM22294v2.isEmpty()) {
            return false;
        }
        Iterator<SyncItemInfo> it = arrayListM22294v2.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            boolean zM62388s = this.f16050K.m62388s(next.getId());
            next.setSwitchStatus(zM62388s);
            if (zM62388s) {
                C3948f.m24064g().m24078r(next.getId(), 1);
                if (next.isSyncConfig()) {
                    z10 = true;
                }
            }
            m22260c4(next);
        }
        this.f16083q.m5213j();
        return z10;
    }

    /* renamed from: O2 */
    private synchronized void m22221O2(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            C11839m.m70687e("SyncAndBackupMianActivity", "module arrayList is null");
        } else {
            Resources resources = this.f16071f0.getResources();
            m22202E3(resources != null ? arrayList.size() == 4 ? resources.getString(R$string.more_app_info_messages_calllogs_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.size() == 3 ? m22298x2(arrayList, resources) : arrayList.size() == 2 ? m22299y2(arrayList, resources) : m22296w2(arrayList, resources) : "");
        }
    }

    /* renamed from: O3 */
    private void m22222O3(String str, int i10) {
        m22259c3("browser", str, i10);
        C1008c.m6035v().m6065b0(this, 1, "");
        this.f16090u.setCheckedProgrammatically(true);
        m22287q3(this.f16090u);
    }

    /* renamed from: P2 */
    private void m22224P2() {
        Context applicationContext = this.f16071f0.getApplicationContext();
        this.f16050K = C10028c.m62183d0(applicationContext);
        boolean zM5975v = C1006a.m5936k().m5975v(applicationContext);
        if (C13452e.m80781L().m80791C0() && zM5975v) {
            C11839m.m70687e("SyncAndBackupMianActivity", "this is nn user, but gallery status is open. change status to close");
            m22280n2();
            zM5975v = false;
        }
        m22198C3(this.f16093x, zM5975v);
        boolean zM62388s = this.f16050K.m62388s("addressbook");
        boolean zM62388s2 = this.f16050K.m62388s("calendar");
        boolean zM62388s3 = this.f16050K.m62388s("notepad");
        boolean zM62388s4 = this.f16050K.m62388s("browser");
        boolean zM62388s5 = this.f16050K.m62388s("wlan");
        if (this.f16046G) {
            if (!this.f16052M) {
                m22207H3(this.f16089t, zM62388s);
            }
            if (!this.f16053N) {
                m22207H3(this.f16091v, zM62388s2);
            }
            m22207H3(this.f16094y, zM62388s3);
            m22207H3(this.f16090u, zM62388s4);
            m22207H3(this.f16092w, zM62388s5);
        }
        m22208I3(this.f16094y, zM62388s3);
        boolean zM62216G1 = !C10155f.m63301y() ? this.f16050K.m62216G1(this.f16071f0) : false;
        if (m22219N2()) {
            this.f16054O = true;
        }
        m22216M2();
        boolean z10 = zM62388s || zM62388s2 || zM62388s3;
        boolean z11 = zM62388s4 || zM62388s5 || zM62216G1 || zM5975v;
        if (z10 || z11) {
            this.f16054O = true;
        }
    }

    /* renamed from: P3 */
    private void m22225P3(String str, int i10) {
        m22259c3("calendar", str, i10);
        C1008c.m6035v().m6067c0(this.f16071f0, 1, "");
        this.f16091v.setCheckedProgrammatically(true);
        m22287q3(this.f16091v);
    }

    /* renamed from: Q2 */
    private void m22227Q2() {
        C11839m.m70688i("SyncAndBackupMianActivity", "initSyncItemView ");
        m22236T3();
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.f16071f0);
        ArrayList<DriveConfigService> subpageList = NotifyUtil.getSubpageList(this.f16071f0, false);
        C3948f.m24064g().m24075o(this.f16044E);
        C3948f.m24064g().m24076p(C1008c.m6035v().m6036A(this.f16071f0));
        if (shownSyncServiceItems.isEmpty() && subpageList.isEmpty()) {
            C11839m.m70688i("SyncAndBackupMianActivity", "initSyncItemView service is empty");
            return;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "initSyncItemView syncServices count = " + shownSyncServiceItems.size() + " driveServices count =" + subpageList.size());
        m22214L3(shownSyncServiceItems);
        m22196B3(subpageList);
        m22212K3();
    }

    /* renamed from: Q3 */
    private void m22228Q3(String str, int i10, int i11) {
        if (C13843a.m83073Y(this.f16071f0)) {
            m22231R3(str, i11);
            return;
        }
        m22259c3("addressbook", str, i11);
        C1008c.m6035v().m6081j0(this.f16071f0);
        C1008c.m6035v().m6069d0(i10);
        this.f16089t.setCheckedProgrammatically(true);
        m22287q3(this.f16089t);
    }

    /* renamed from: R2 */
    private void m22230R2() {
        this.f16047H = new C13945a(this.f16071f0, this.f16044E);
        SyncItemInfo syncItemInfoM22292u2 = m22292u2(HNConstants.DataType.MEDIA, this.f16093x);
        if (syncItemInfoM22292u2 == null) {
            SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.gallery_item_title));
            this.f16093x = syncItemInfo;
            syncItemInfo.setShowStatusLayout(true);
            this.f16093x.setSubUserDisable(true);
            this.f16093x.setId(HNConstants.DataType.MEDIA);
        } else {
            this.f16093x = syncItemInfoM22292u2;
            syncItemInfoM22292u2.setShowStatusLayout(true);
            this.f16093x.setSubUserDisable(true);
        }
        SyncItemInfo syncItemInfoM22292u22 = m22292u2("addressbook", this.f16089t);
        if (syncItemInfoM22292u22 == null) {
            SyncItemInfo syncItemInfo2 = new SyncItemInfo(getString(R$string.contact));
            this.f16089t = syncItemInfo2;
            syncItemInfo2.setShowSwitch(true);
            this.f16089t.setId("addressbook");
        } else {
            this.f16089t = syncItemInfoM22292u22;
            syncItemInfoM22292u22.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM22292u23 = m22292u2("calendar", this.f16091v);
        if (syncItemInfoM22292u23 == null) {
            SyncItemInfo syncItemInfo3 = new SyncItemInfo(getString(R$string.calendar_sync_item));
            this.f16091v = syncItemInfo3;
            syncItemInfo3.setShowSwitch(true);
            this.f16091v.setId("calendar");
        } else {
            this.f16091v = syncItemInfoM22292u23;
            syncItemInfoM22292u23.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM22292u24 = m22292u2("browser", this.f16090u);
        if (syncItemInfoM22292u24 == null) {
            SyncItemInfo syncItemInfo4 = new SyncItemInfo(getString(R$string.browser));
            this.f16090u = syncItemInfo4;
            syncItemInfo4.setShowSwitch(true);
            this.f16090u.setId("browser");
        } else {
            this.f16090u = syncItemInfoM22292u24;
            syncItemInfoM22292u24.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM22292u25 = m22292u2("notepad", this.f16094y);
        if (syncItemInfoM22292u25 == null) {
            SyncItemInfo syncItemInfo5 = new SyncItemInfo(getString(R$string.notepad_app_name));
            this.f16094y = syncItemInfo5;
            syncItemInfo5.setShowSwitch(true);
            this.f16094y.setId("notepad");
        } else {
            this.f16094y = syncItemInfoM22292u25;
            syncItemInfoM22292u25.setShowSwitch(true);
        }
        boolean zM62388s = C10028c.m62183d0(this.f16071f0).m62388s("notepad_has_history_data");
        this.f16095z = zM62388s;
        if (zM62388s) {
            this.f16094y.setShowStatusLayout(true);
            this.f16094y.setOnClick(true);
        } else {
            this.f16094y.setShowSwitchLayout(true);
            this.f16094y.setOnClick(false);
        }
        this.f16094y.setHasNotePadHistoryData(this.f16095z);
        m22235T2();
        if (C0209d.m1293p1()) {
            this.f16093x.setImage(getDrawable(R$drawable.ic_cloud_album_ink));
            this.f16094y.setImage(getDrawable(R$drawable.ic_memorandum_ink));
            this.f16091v.setImage(this.f16071f0.getDrawable(R$drawable.icon_calendar_ink));
            this.f16090u.setImage(this.f16071f0.getDrawable(R$drawable.ic_hicloud_browser_list_new_ink));
            this.f16092w.setImage(this.f16071f0.getDrawable(R$drawable.ic_wifi_ink));
        } else if (C0209d.m1269j1()) {
            this.f16093x.setImage(getDrawable(R$drawable.ic_cloud_album_honor));
            this.f16094y.setImage(getDrawable(R$drawable.ic_memorandum_honor));
            this.f16089t.setImage(this.f16071f0.getDrawable(R$drawable.ic_contacts_honor));
            this.f16091v.setImage(this.f16071f0.getDrawable(R$drawable.icon_calendar_honor));
            this.f16090u.setImage(this.f16071f0.getDrawable(R$drawable.ic_hicloud_browser_list_new_honor));
        } else {
            this.f16093x.setImage(getDrawable(R$drawable.ic_cloud_album));
            this.f16094y.setImage(getDrawable(R$drawable.ic_memorandum));
            this.f16089t.setImage(this.f16071f0.getDrawable(R$drawable.ic_contacts));
            this.f16091v.setImage(this.f16071f0.getDrawable(R$drawable.icon_calendar));
            this.f16090u.setImage(this.f16071f0.getDrawable(R$drawable.ic_hicloud_browser_list_new));
        }
        m22313x3();
        m22303I2();
        m22302H2();
        m22227Q2();
        m22272i2();
        m22205G2();
        m22224P2();
        m22211K2();
        C13945a c13945a = this.f16047H;
        if (c13945a != null) {
            c13945a.mo83728t();
        }
        this.f16085r.setFocusable(false);
        this.f16085r.setEnabled(false);
        this.f16085r.setNestedScrollingEnabled(false);
    }

    /* renamed from: R3 */
    private void m22231R3(String str, int i10) {
        m22259c3("addressbook", str, i10);
        C1008c.m6035v().m6071e0(this.f16071f0, 1, "");
        this.f16089t.setCheckedProgrammatically(true);
        m22287q3(this.f16089t);
    }

    /* renamed from: S3 */
    private void m22233S3(String str, int i10) {
        m22259c3("notepad", str, i10);
        C1008c.m6035v().m6077h0(this, 1, "");
        this.f16094y.setCheckedProgrammatically(true);
        m22287q3(this.f16094y);
    }

    /* renamed from: T2 */
    private void m22235T2() {
        SyncItemInfo syncItemInfoM22292u2 = m22292u2("wlan", this.f16092w);
        if (syncItemInfoM22292u2 == null) {
            SyncItemInfo syncItemInfo = new SyncItemInfo();
            this.f16092w = syncItemInfo;
            syncItemInfo.setShowSwitch(true);
            this.f16092w.setSubUserDisable(true);
            this.f16092w.setId("wlan");
        } else {
            this.f16092w = syncItemInfoM22292u2;
            syncItemInfoM22292u2.setShowSwitch(true);
            this.f16092w.setSubUserDisable(true);
        }
        Resources resources = getResources();
        if (resources != null) {
            this.f16092w.setImage(this.f16071f0.getDrawable(R$drawable.ic_wifi));
            if (C0209d.m1262h2()) {
                this.f16092w.setTitle(resources.getString(R$string.wlan_sync));
            } else {
                this.f16092w.setTitle(resources.getString(R$string.wifi_sync));
            }
        }
    }

    /* renamed from: T3 */
    private void m22236T3() {
        BaseDataItemRecyclerAdapter baseDataItemRecyclerAdapter = this.f16083q;
        if (baseDataItemRecyclerAdapter != null) {
            baseDataItemRecyclerAdapter.m25270H();
        }
        this.f16042C.clear();
        this.f16043D.clear();
    }

    /* renamed from: U3 */
    private void m22238U3(String str, String str2, int i10) {
        NotifyConstants.putServicesMoudleIntoMap(str, true);
        m22259c3(str, str2, i10);
        C1008c.m6035v().m6075g0(this.f16071f0, str, 1, "");
        C13945a c13945a = this.f16047H;
        if (c13945a != null) {
            c13945a.m83858i0(str, Boolean.TRUE);
        }
    }

    /* renamed from: V3 */
    private void m22240V3(String str, int i10) {
        m22259c3("wlan", str, i10);
        C1008c.m6035v().m6061Z("dsswitch");
        C1008c.m6035v().m6081j0(this.f16071f0);
        C1008c.m6035v().m6089n0(this.f16071f0);
        this.f16092w.setCheckedProgrammatically(true);
        m22287q3(this.f16092w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W2 */
    public /* synthetic */ boolean m22242W2(Message message) throws Resources.NotFoundException {
        if (message.what != 34574) {
            return false;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "baseCard info get");
        m22310l3();
        return false;
    }

    /* renamed from: X2 */
    public static /* synthetic */ void m22244X2(ImageView imageView) {
        imageView.setImageResource(R$drawable.hicloud_list_arrow_gray);
    }

    /* renamed from: X3 */
    private void m22245X3() {
        if (this.f16072g0 != null) {
            C13108a.m78878b(this.f16071f0).m78883f(this.f16072g0);
            this.f16072g0 = null;
        }
    }

    /* renamed from: Y2 */
    public static /* synthetic */ void m22247Y2(TextView textView) {
        textView.setText(R$string.backup_item_title);
    }

    /* renamed from: Y3 */
    private void m22248Y3(Runnable runnable) {
        HwRecyclerView hwRecyclerView = this.f16085r;
        if (hwRecyclerView == null) {
            return;
        }
        hwRecyclerView.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z2 */
    public void m22250Z2() {
        m22283o3();
        m22289r3(this);
        BaseDataItemRecyclerAdapter baseDataItemRecyclerAdapter = this.f16083q;
        if (baseDataItemRecyclerAdapter != null) {
            baseDataItemRecyclerAdapter.m5213j();
        }
    }

    /* renamed from: Z3 */
    private void m22251Z3(String str) {
        m22248Y3(new RunnableC3487h(str));
    }

    /* renamed from: a3 */
    private void m22253a3(String str, String str2, int i10) {
        m22256b3(str, str2, SyncType.OPEN_SWITCH_MANUALLY, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a4 */
    public void m22254a4(String str) {
        m22248Y3(new RunnableC3485f(str));
    }

    /* renamed from: b3 */
    private void m22256b3(String str, String str2, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("SyncAndBackupMianActivity", "performSynchronization, moduleName is empty");
            return;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "performSynchronization, moduleName: " + str);
        str.hashCode();
        switch (str) {
            case "addressbook":
                C1008c.m6035v().m6050O(this.f16071f0, "addressbook", true);
                m22228Q3(str2, i10, i11);
                break;
            case "calendar":
                m22225P3(str2, i11);
                break;
            case "wlan":
                C1008c.m6035v().m6050O(this.f16071f0, "wlan", true);
                m22240V3(str2, i11);
                break;
            case "browser":
                m22222O3(str2, i11);
                break;
            case "notepad":
                m22233S3(str2, i11);
                break;
            default:
                m22238U3(str, str2, i11);
                break;
        }
        C14317j.m85300d().m85319t();
    }

    /* renamed from: b4 */
    private void m22257b4(int i10) {
        if (i10 == 20006 || i10 == 20001 || i10 == 20002) {
            List<String> listM69903b = this.f22163b.m69903b(this, m22291t2());
            if (listM69903b == null || listM69903b.isEmpty()) {
                C11839m.m70688i("SyncAndBackupMianActivity", "unGranted permission is empty.");
            } else if (i10 == 20001 || i10 == 20002) {
                C2783d.m16090J0("backup_permission_close_backup", C13230i.m79497A(C13452e.m80781L().m80971t0()));
            }
        }
    }

    /* renamed from: c3 */
    private void m22259c3(String str, String str2, int i10) {
        String str3;
        C13223b.m79477e(this.f16071f0, str, true, i10);
        str.hashCode();
        switch (str) {
            case "addressbook":
                str3 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str3 = "11";
                break;
            case "wlan":
                str3 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str3 = "20";
                break;
            case "notepad":
                str3 = "10";
                break;
            default:
                str3 = "29";
                break;
        }
        UBAAnalyze.m29955P("PVC", C13471c.m81132e().get(str), "1", str3, i10);
        this.f16050K.m62336h2(str, true);
        C10155f.m63262O(this.f16071f0, true);
        C13612b.m81829B().m81870k0(getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75172d(new C10147j(this.f16071f0.getApplicationContext(), arrayList, "03003", str2));
    }

    /* renamed from: c4 */
    private void m22260c4(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        this.f16044E.put(syncItemInfo.getId(), syncItemInfo);
        BaseDataItemRecyclerAdapter baseDataItemRecyclerAdapter = this.f16083q;
        if (baseDataItemRecyclerAdapter != null) {
            baseDataItemRecyclerAdapter.m25292h0(this.f16044E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d3 */
    public void m22262d3(boolean z10, String str, int i10) {
        C11839m.m70688i("SyncAndBackupMianActivity", "processCheckedChanged, syncType: " + str + ", isChecked = " + z10 + ", isRefreshSwitchStatus = " + this.f16046G);
        C1008c.m6035v().m6051P(this.f16071f0, null, false);
        if (z10) {
            m22273i3(str);
            return;
        }
        this.f16046G = true;
        if (this.f16048I.containsKey(str) && this.f16048I.get(str) != null) {
            this.f16048I.get(str).dismiss();
            m22254a4("");
        }
        m22271h3(str, i10);
    }

    /* renamed from: d4 */
    private void m22263d4() {
        SyncItemInfo syncItemInfoM25274M;
        C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemView");
        if (this.f16085r == null || this.f16083q == null) {
            C11839m.m70687e("SyncAndBackupMianActivity", "syncItemsView or syncListAdapter is null");
            return;
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.f16071f0);
        ArrayList<DriveConfigService> subpageList = NotifyUtil.getSubpageList(this.f16071f0, false);
        if (shownSyncServiceItems.size() + subpageList.size() > 0) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemView shown items count = " + shownSyncServiceItems.size());
            for (int i10 = 0; i10 < shownSyncServiceItems.size(); i10++) {
                SyncConfigService syncConfigService = shownSyncServiceItems.get(i10);
                if (syncConfigService != null && (syncItemInfoM25274M = this.f16083q.m25274M(syncConfigService.getId())) != null && syncItemInfoM25274M.isSyncConfig()) {
                    syncConfigService.setSyncItemSubtitleStatus(syncItemInfoM25274M.getSyncItemSubtitleStatus());
                    syncConfigService.setSubStringText(syncItemInfoM25274M.getSubStringText());
                }
            }
            m22236T3();
            m22214L3(shownSyncServiceItems);
            m22196B3(subpageList);
            m22290s3();
        } else {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemView get OM services is null or empty ");
            m22236T3();
        }
        m22212K3();
    }

    /* renamed from: e3 */
    private void m22265e3(boolean z10, String str, int i10) {
        C11839m.m70688i("SyncAndBackupMianActivity", "query module:" + str + " switchStatus:" + z10 + ", clickOptType: " + i10);
        BaseDataItemRecyclerAdapter baseDataItemRecyclerAdapter = this.f16083q;
        if (baseDataItemRecyclerAdapter == null) {
            C11839m.m70687e("SyncAndBackupMianActivity", "processItemCheckedChanged sync is null, syncType = " + str);
            return;
        }
        SyncItemInfo syncItemInfoM25274M = baseDataItemRecyclerAdapter.m25274M(str);
        if (syncItemInfoM25274M == null) {
            return;
        }
        if (syncItemInfoM25274M.isSyncConfig()) {
            m22262d3(z10, str, i10);
            return;
        }
        if (syncItemInfoM25274M.isDriveConfig()) {
            if (!z10) {
                this.f16050K.m62336h2(str, false);
                C1008c.m6035v().m6046K(this.f16071f0, str, 0);
                C13225d.m79490f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", str);
            } else {
                m22254a4(str);
                AlertDialogC13588a alertDialogC13588a = new AlertDialogC13588a(this.f16071f0, new DialogInterfaceOnClickListenerC3491l(str), new DialogInterfaceOnCancelListenerC3490k(str));
                this.f16049J = alertDialogC13588a;
                alertDialogC13588a.m81741a(str);
            }
        }
    }

    /* renamed from: f3 */
    private void m22267f3() {
        List<String> listM22291t2 = m22291t2();
        this.f16076k0 = listM22291t2;
        if (listM22291t2 == null) {
            C11839m.m70689w("SyncAndBackupMianActivity", "pageServices is null ");
            return;
        }
        Iterator<String> it = listM22291t2.iterator();
        while (it.hasNext()) {
            m22281n3(it.next());
        }
    }

    /* renamed from: g3 */
    private void m22269g3(int i10) {
        C11839m.m70688i("SyncAndBackupMianActivity", "processSwitchOpenPermissionResult");
        if (i10 == 20004) {
            List<String> listM69911k = this.f22163b.m69911k("sync_contact");
            C11839m.m70688i("SyncAndBackupMianActivity", "contact need permissions size: " + listM69911k.size());
            List<String> listM69903b = this.f22163b.m69903b(this, listM69911k);
            SyncItemInfo syncItemInfoM22292u2 = m22292u2("addressbook", this.f16089t);
            if (syncItemInfoM22292u2 == null) {
                SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.contact));
                this.f16089t = syncItemInfo;
                syncItemInfo.setId("addressbook");
                this.f16089t.setShowSwitch(true);
            } else {
                this.f16089t = syncItemInfoM22292u2;
                syncItemInfoM22292u2.setShowSwitch(true);
            }
            if (listM69903b.size() > 0) {
                this.f16052M = false;
                this.f16089t.setCheckedProgrammatically(false);
                m22262d3(false, "addressbook", 2);
            } else {
                this.f16089t.setCheckedProgrammatically(true);
                m22262d3(true, "addressbook", 2);
            }
            m22287q3(this.f16089t);
            return;
        }
        if (i10 == 20005) {
            List<String> listM69911k2 = this.f22163b.m69911k("sync_calendar");
            C11839m.m70688i("SyncAndBackupMianActivity", "calendar need permissions size: " + listM69911k2.size());
            List<String> listM69903b2 = this.f22163b.m69903b(this, listM69911k2);
            SyncItemInfo syncItemInfoM22292u22 = m22292u2("calendar", this.f16091v);
            if (syncItemInfoM22292u22 == null) {
                SyncItemInfo syncItemInfo2 = new SyncItemInfo(getString(R$string.calendar_sync_item));
                this.f16091v = syncItemInfo2;
                syncItemInfo2.setShowSwitch(true);
                this.f16091v.setId("calendar");
            } else {
                this.f16091v = syncItemInfoM22292u22;
                syncItemInfoM22292u22.setShowSwitch(true);
            }
            if (listM69903b2.size() > 0) {
                this.f16053N = false;
                this.f16091v.setCheckedProgrammatically(false);
                m22262d3(false, "calendar", 2);
            } else {
                C11839m.m70688i("SyncAndBackupMianActivity", "calendar setChecked");
                this.f16091v.setCheckedProgrammatically(true);
                m22262d3(true, "calendar", 2);
            }
            m22287q3(this.f16091v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2 */
    public void m22270h2() {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("SyncAndBackupMianActivity", " uploadStatusSuccess isCloudphotoManagerEnable false");
            this.f16093x.setNoSubTitle(true);
            this.f16093x.setShowSubTitle(false);
            m22287q3(this.f16093x);
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58460v0(this.f16071f0, "", false, true);
            return;
        }
        this.f16093x.setNoSubTitle(true);
        this.f16093x.setShowSubTitle(false);
        m22287q3(this.f16093x);
    }

    /* renamed from: h3 */
    private void m22271h3(String str, int i10) {
        C2783d.m16114V0(str, "2", "2", i10);
        m22297w3(str, "local_close_switch", i10);
        C1008c.m6035v().m6074g(this.f16071f0, str, "");
        C1008c.m6035v().m6078i(this.f16071f0, str);
        C14317j.m85300d().m85319t();
    }

    /* renamed from: i2 */
    private void m22272i2() {
        LinkedHashMap<String, SyncItemInfo> linkedHashMap = this.f16044E;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        m22210J3(this.f16093x);
        m22210J3(this.f16094y);
        m22210J3(this.f16089t);
        m22210J3(this.f16091v);
        m22210J3(this.f16090u);
        m22210J3(this.f16056Q);
        m22210J3(this.f16092w);
        m22290s3();
        m22212K3();
    }

    /* renamed from: i3 */
    private void m22273i3(String str) {
        if (C10155f.m63261N(str) && !m29143z0(str)) {
            m22204F3(str, true);
            return;
        }
        C1008c.m6035v().m6076h(this.f16071f0, str);
        m22275j3(str);
        m22251Z3(str);
        m22304N3();
    }

    /* renamed from: j2 */
    private void m22274j2(ModuleItemForAll moduleItemForAll) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f16062W = moduleItemForAll.hasSmsData();
        this.f16063X = moduleItemForAll.hasCallLogData();
        this.f16064Y = moduleItemForAll.hasRecordingData();
        this.f16065Z = moduleItemForAll.hasPhoneManagerData();
        C11839m.m70688i("SyncAndBackupMianActivity", "smsdata:" + this.f16062W + ", calllogdata:" + this.f16063X + ", recordingdata:" + this.f16064Y + ", phonemanagerdata:" + this.f16065Z);
        if (this.f16062W) {
            arrayList.add("message");
        }
        if (this.f16063X) {
            arrayList.add("calllog");
        }
        if (this.f16064Y) {
            arrayList.add("recording");
        }
        if (this.f16065Z) {
            arrayList.add("interception");
        }
        boolean z10 = this.f16062W || this.f16063X || this.f16064Y || this.f16065Z;
        if (!C0209d.m1166E1() || !z10) {
            this.f16066a0.setVisibility(8);
            return;
        }
        this.f16056Q.setVisible(8);
        this.f16066a0.setVisibility(0);
        m22221O2(arrayList);
        m22293u3(this.f16056Q);
    }

    /* renamed from: j3 */
    private void m22275j3(String str) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("SyncAndBackupMianActivity", "Query local data: " + str + ", traceId: " + strM81958d);
        C1008c.m6035v().m6048M(this.f16071f0, this.f16088s0, str, strM81958d, 2);
    }

    /* renamed from: k2 */
    private void m22276k2(int i10) {
        if (i10 == R$id.manage_space_storagebar_frame || i10 == R$id.frag_storage_text_frame || i10 == R$id.manage_space_entrance || i10 == R$id.rl_manage_space_entrance) {
            C11839m.m70688i("SyncAndBackupMianActivity", "checkCloudStorageClick storageClick = true");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("result", String.valueOf(i10));
            C13225d.m79490f1().m79552E0("CLICK_MAIN_MANAGER", linkedHashMapM79497A);
            C13225d.m79490f1().m79585f0("mecloud_main_click_storage", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_storage", "1", "7");
            m22306U2();
            return;
        }
        C11839m.m70688i("SyncAndBackupMianActivity", "checkCloudStorageClick storageClick = false, id = " + i10);
        LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A2.put("result", String.valueOf(i10));
        C13225d.m79490f1().m79552E0("CLICK_NOT_MAIN_MANAGER", linkedHashMapM79497A2);
        this.f16040A = false;
    }

    /* renamed from: k3 */
    private void m22277k3(Message message) {
        CutOutProgressDialog cutOutProgressDialog = this.f16051L;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
        }
        Object obj = message.obj;
        if (!(obj instanceof Boolean)) {
            C11839m.m70687e("SyncAndBackupMianActivity", "Cannot get boolean from message");
            return;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        Bundle data = message.getData();
        if (data == null) {
            C11839m.m70687e("SyncAndBackupMianActivity", "queryLocalDataFinish, bundle data is null");
            return;
        }
        String string = data.getString("sync_type_key", "");
        m22251Z3("");
        int i10 = data.getInt("sync_operation_type", 2);
        C11839m.m70688i("SyncAndBackupMianActivity", "Query local data finish, module id = " + string + ", result = " + zBooleanValue + ", clickOptType = " + i10);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String string2 = data.getString("trace_id_key", "");
        if (zBooleanValue) {
            m22254a4(string);
            this.f16046G = false;
            if (!this.f16048I.containsKey(string) || this.f16048I.get(string) == null) {
                MergeAlertDialog mergeAlertDialog = new MergeAlertDialog(this.f16071f0, this, 2);
                mergeAlertDialog.show(string, string2);
                this.f16048I.put(string, mergeAlertDialog);
            } else {
                this.f16048I.get(string).show(string, string2);
            }
        } else {
            m22204F3(string, false);
            m22253a3(string, string2, i10);
            C2783d.m16114V0(string, "1", "1", i10);
        }
        C1008c.m6035v().m6079i0(this.f16071f0, string);
    }

    /* renamed from: m2 */
    private void m22278m2(String str) {
        C1008c.m6035v().m6084l(this, str);
    }

    /* renamed from: m3 */
    private void m22279m3() {
        if (this.f16058S == null || this.f16060U == null) {
            C11839m.m70687e("SyncAndBackupMianActivity", "recommend view is null");
        } else {
            this.f16061V = RecommendCardManager.getInstance().getRecommendCardsFromCache(RecommendCardConstants.Entrance.HOMEPAGE);
            m22206G3();
        }
    }

    /* renamed from: n2 */
    private void m22280n2() {
        if (this.f16093x == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        bundle.putBoolean("ShareAlbum", false);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            m22198C3(this.f16093x, false);
            interfaceC9282a.mo58396U(this.f16071f0, bundle, 12);
        }
    }

    /* renamed from: n3 */
    private void m22281n3(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A;
        linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        str.hashCode();
        switch (str) {
            case "cloud_disk_recording":
                List<String> listM69903b = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_recording"));
                if (listM69903b != null && listM69903b.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close CLOUD_DISK_RECORDING automatically");
                    m22278m2("autorecordingkey");
                }
                C2783d.m16090J0("main_permission_close_recording_upload", linkedHashMapM79497A);
                break;
            case "sync_ablum":
                List<String> listM69903b2 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_ablum"));
                if (listM69903b2 != null && listM69903b2.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close ablum automatically");
                    InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                    if (interfaceC9282a != null) {
                        interfaceC9282a.mo58407Z0(this, 12);
                    }
                    m22198C3(this.f16093x, false);
                }
                C2783d.m16090J0("main_permission_close_gallery", linkedHashMapM79497A);
                break;
            case "backup":
                List<String> listM69903b3 = this.f22163b.m69903b(this, this.f22163b.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP));
                if (listM69903b3 != null && listM69903b3.size() > 0) {
                    CloudBackupService.getInstance().cloudbackupOpr(false);
                }
                C2783d.m16090J0("main_permission_close_backup", linkedHashMapM79497A);
                break;
            case "cloud_disk_sms":
                List<String> listM69903b4 = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_sms"));
                if (listM69903b4 != null && listM69903b4.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close CLOUD_DISK_SMS automatically");
                    m22278m2("autosmslistkey");
                }
                C2783d.m16090J0("main_permission_close_sms_upload", linkedHashMapM79497A);
                break;
            case "sync_contact":
                List<String> listM69903b5 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_contact"));
                if (listM69903b5 != null && listM69903b5.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close contact automatically");
                    this.f16089t.setCheckedProgrammatically(false);
                    m22262d3(false, "addressbook", 2);
                }
                m22287q3(this.f16089t);
                C2783d.m16090J0("main_permission_close_contact", linkedHashMapM79497A);
                break;
            case "cloud_disk_calllog":
                List<String> listM69903b6 = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_calllog"));
                if (listM69903b6 != null && listM69903b6.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close CLOUD_DISK_CALLLOG automatically");
                    m22278m2("autocallloglistkey");
                }
                C2783d.m16090J0("main_permission_close_calllog_upload", linkedHashMapM79497A);
                break;
            case "sync_calendar":
                List<String> listM69903b7 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_calendar"));
                SyncItemInfo syncItemInfoM22292u2 = m22292u2("calendar", this.f16091v);
                if (syncItemInfoM22292u2 == null) {
                    SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.calendar_sync_item));
                    this.f16091v = syncItemInfo;
                    syncItemInfo.setShowSwitch(true);
                    this.f16091v.setId("calendar");
                } else {
                    this.f16091v.setShowSwitch(true);
                    this.f16091v = syncItemInfoM22292u2;
                }
                if (listM69903b7 != null && listM69903b7.size() > 0) {
                    C11839m.m70688i("SyncAndBackupMianActivity", "no permission close calendar automatically");
                    this.f16091v.setCheckedProgrammatically(false);
                    m22262d3(false, "calendar", 2);
                }
                m22287q3(this.f16091v);
                C2783d.m16090J0("main_permission_close_calendar", linkedHashMapM79497A);
                break;
        }
    }

    /* renamed from: o2 */
    private void m22282o2() {
        AlertDialog alertDialog = this.f16079n0;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: o3 */
    private void m22283o3() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        C11842p.m70881x0(this, i10);
        C11842p.m70885y0(this, i10);
    }

    /* renamed from: p2 */
    private void m22284p2(String str, boolean z10, String str2) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                m22262d3(z10, "addressbook", 2);
                break;
            case "huaweiaireader":
                m22262d3(z10, "huaweiaireader", 2);
                break;
            case "calendar":
                m22262d3(z10, "calendar", 2);
                break;
            case "wlan":
                m22262d3(z10, "wlan", 2);
                break;
            case "browser":
                m22262d3(z10, "browser", 2);
                break;
            case "notepad":
                m22262d3(z10, "notepad", 2);
                break;
            default:
                if (!TextUtils.isEmpty(str2)) {
                    m22265e3(z10, str2, 2);
                    break;
                }
                break;
        }
    }

    /* renamed from: p3 */
    private void m22285p3() {
        C12515a.m75110o().m75172d(new C3480a());
    }

    /* renamed from: q2 */
    private void m22286q2(int[] iArr) {
        HiCloudItemView hiCloudItemView = null;
        for (int i10 : iArr) {
            HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76829b(this.f16071f0, i10);
            if (hiCloudItemView2 != null && hiCloudItemView2.getVisibility() == 0) {
                hiCloudItemView = hiCloudItemView2;
            }
        }
        if (hiCloudItemView != null) {
            hiCloudItemView.m23973d();
        }
    }

    /* renamed from: q3 */
    private void m22287q3(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        if (this.f16083q == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap baseDataItemRecyclerAdapter is null");
            return;
        }
        if (this.f16044E == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap baseDataItemInfoHashMap is null");
            this.f16044E = new LinkedHashMap<>();
        }
        if (syncItemInfo.getVisible() == 8) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap syncItemInfo is gone");
            if (this.f16044E.containsKey(syncItemInfo.getId())) {
                this.f16044E.remove(syncItemInfo.getId());
            }
        } else {
            this.f16044E.put(syncItemInfo.getId(), syncItemInfo);
        }
        m22212K3();
    }

    /* renamed from: r2 */
    private void m22288r2() {
        try {
            CutOutProgressDialog cutOutProgressDialog = this.f16051L;
            if (cutOutProgressDialog != null) {
                cutOutProgressDialog.dismiss();
                m22251Z3("");
            }
        } catch (IllegalArgumentException e10) {
            C11839m.m70687e("SyncAndBackupMianActivity", "Dismiss delete progress dialog " + e10.toString());
        }
        if (this.f16045F) {
            C2783d.m16138f(this.f16071f0);
        } else {
            C9062b.m57146k().m57155h(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r3 */
    public void m22289r3(Context context) {
        C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemView begin:");
        m22263d4();
        m22213L2();
        boolean zM22219N2 = m22219N2();
        C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemView :" + zM22219N2);
        if (this.f16054O || !zM22219N2) {
            return;
        }
        C1008c.m6035v().m6081j0(context);
    }

    /* renamed from: s3 */
    private void m22290s3() {
        for (int i10 = 0; i10 < this.f16042C.size(); i10++) {
            m22210J3(this.f16042C.get(i10));
        }
        for (int i11 = 0; i11 < this.f16043D.size(); i11++) {
            m22210J3(this.f16043D.get(i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t2 */
    public List<String> m22291t2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        arrayList.add("backup_calendar");
        arrayList.add("backup_calllog");
        arrayList.add("backup_contact");
        arrayList.add("backup_sms");
        arrayList.add("cloud_disk_recording");
        if (this.f16050K.m62388s("addressbook")) {
            arrayList.add("sync_contact");
        }
        if (this.f16050K.m62388s("calendar")) {
            arrayList.add("sync_calendar");
        }
        return arrayList;
    }

    /* renamed from: u2 */
    private SyncItemInfo m22292u2(String str, SyncItemInfo syncItemInfo) {
        LinkedHashMap<String, SyncItemInfo> linkedHashMap = this.f16044E;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.containsKey(str) ? this.f16044E.get(str) : syncItemInfo;
    }

    /* renamed from: u3 */
    private void m22293u3(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        if (this.f16044E.containsKey(syncItemInfo.getId())) {
            this.f16044E.remove(syncItemInfo.getId(), syncItemInfo);
        }
        m22212K3();
    }

    /* renamed from: v2 */
    private ArrayList<SyncItemInfo> m22294v2() {
        BaseDataItemRecyclerAdapter baseDataItemRecyclerAdapter = this.f16083q;
        return baseDataItemRecyclerAdapter == null ? new ArrayList<>() : baseDataItemRecyclerAdapter.m25276P(this.f16044E);
    }

    /* renamed from: v3 */
    private void m22295v3(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("serviceId", str);
        C13225d.m79490f1().m79567R("CLOUDBACKUP_ENTRANCE_DRIVE_APP_MAIN", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "CLOUDBACKUP_ENTRANCE_DRIVE_APP_MAIN", linkedHashMapM79497A);
    }

    /* renamed from: w2 */
    private String m22296w2(ArrayList<String> arrayList, Resources resources) {
        return arrayList.contains("message") ? resources.getString(R$string.more_app_info_messages, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.contains("calllog") ? resources.getString(R$string.more_app_info_calllogs, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.contains("recording") ? resources.getString(R$string.more_app_info_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: w3 */
    private void m22297w3(String str, String str2, int i10) {
        m22217M3(str, i10);
        C2783d.m16120Y0(getApplicationContext(), str, str2);
    }

    /* renamed from: x2 */
    private String m22298x2(ArrayList<String> arrayList, Resources resources) {
        return (arrayList.contains("message") && arrayList.contains("calllog") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_messages_calllogs_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("calllog") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_calllogs_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("recording") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_calllogs_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: y2 */
    private String m22299y2(ArrayList<String> arrayList, Resources resources) {
        return (arrayList.contains("message") && arrayList.contains("calllog")) ? resources.getString(R$string.more_app_info_messages_calllogs, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_messages_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("calllog") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_calllogs_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("calllog") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_calllogs_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: A2 */
    public final void m22300A2() {
        C11839m.m70688i("SyncAndBackupMianActivity", "goToBackupOptionActivity");
        if (CBAccess.inBackup()) {
            C11839m.m70688i("SyncAndBackupMianActivity", "goToBackupOptionActivity in backup toast");
            Toast.makeText(this, getString(R$string.backup_option_click_toast), 0).show();
            return;
        }
        if (CBAccess.inRestore()) {
            C11839m.m70688i("SyncAndBackupMianActivity", "goToBackupOptionActivity in backup during recovery toast");
            Toast.makeText(this, getString(R$string.backup_option_click_during_recovery_toast), 0).show();
            return;
        }
        String stringExtra = new HiCloudSafeIntent(getIntent()).getStringExtra("deeplink_sub_page");
        C11839m.m70688i("SyncAndBackupMianActivity", "<parsingDeepLink> start backup options activity, key: " + stringExtra);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, (Class<?>) BackupOptionsActivity.class));
        hiCloudSafeIntent.putExtra("deeplink_sub_page", stringExtra);
        startActivity(hiCloudSafeIntent);
    }

    /* renamed from: B2 */
    public boolean m22301B2(Message message) {
        if (m22197C2(message) || m22199D2(message) || message.what != 4) {
            return false;
        }
        m22288r2();
        return false;
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C11839m.m70688i("SyncAndBackupMianActivity", "finishPermissionSet requestCode: " + i10);
        if (i10 == 20004 || i10 == 20005 || i10 == 20006) {
            m22269g3(i10);
        }
        if (i10 == 20001 || i10 == 20002) {
            m22257b4(i10);
            m22267f3();
        }
    }

    /* renamed from: H2 */
    public final void m22302H2() {
        if (this.f16083q == null) {
            this.f16083q = new BaseDataItemRecyclerAdapter(this);
        }
        this.f16083q.m25283Y(this);
        this.f16083q.m25284Z(this);
        this.f16085r = (HwRecyclerView) C12809f.m76829b(this, R$id.sync_normal_recycler_view);
        m22316z3();
    }

    /* renamed from: I2 */
    public final void m22303I2() {
        C11839m.m70688i("SyncAndBackupMianActivity", "initItemViewParent start");
        try {
            if (this.f16081p == null) {
                View viewM76829b = C12809f.m76829b(this.f16071f0, R$id.base_data_normal_item_stub);
                if (viewM76829b instanceof ViewStub) {
                    this.f16081p = ((ViewStub) viewM76829b).inflate();
                    C11839m.m70688i("SyncAndBackupMianActivity", "inflate success");
                    View viewM76829b2 = C12809f.m76829b(this.f16071f0, R$id.init_base_data_item_view_layout);
                    if (viewM76829b2 != null) {
                        viewM76829b2.setVisibility(8);
                        C11839m.m70688i("SyncAndBackupMianActivity", "remove init item view layout success");
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("SyncAndBackupMianActivity", "switch view stub inflate exception:" + e10.toString());
        }
    }

    /* renamed from: N3 */
    public final void m22304N3() {
        CutOutProgressDialog cutOutProgressDialog = this.f16051L;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.setMessage(getResources().getString(R$string.opening));
            this.f16051L.setCancelable(false);
            this.f16051L.show();
        }
    }

    /* renamed from: S2 */
    public final void m22305S2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R$string.sync_and_backup_basic_data_new));
            int color = getColor(R$color.hicloud_hmos_bg);
            C11842p.m70842n1(actionBar, new ColorDrawable(color));
            actionBar.setBackgroundDrawable(new ColorDrawable(color));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: U2 */
    public void m22306U2() {
        if (C2783d.m16177s()) {
            C2783d.m16137e1(false);
            C12809f.m76843p(this.f16041B, false);
        }
        this.f16040A = true;
    }

    /* renamed from: V2 */
    public final /* synthetic */ void m22307V2(View view) {
        m22309l2();
    }

    /* renamed from: W3 */
    public final void m22308W3() {
        CBCallBack.getInstance().unregisterCallback(this.f16077l0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(findViewById(R$id.base_data_service_item));
        arrayList.add(findViewById(R$id.base_data_item_switch));
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter.OnCheckedChangedListener
    /* renamed from: j */
    public void mo21399j(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView, boolean z10) {
        if (hiCloudItemView == null) {
            return;
        }
        Object tag = hiCloudItemView.getTag();
        if (tag == null || (tag instanceof String)) {
            if (syncItemInfo == null) {
                C11839m.m70688i("SyncAndBackupMianActivity", "onCheckedChangedSyncItem syncItemInfo is null");
                return;
            }
            String str = (String) tag;
            if (C13612b.m81829B().m81886t(this.f16071f0)) {
                hiCloudItemView.setChecked(!z10);
            } else {
                m22284p2(syncItemInfo.getId(), z10, str);
            }
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter.OnItemClickListener
    /* renamed from: k */
    public void mo21407k(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView) {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("SyncAndBackupMianActivity", "fast click");
            return;
        }
        if (C13612b.m81829B().m81886t(this)) {
            C11839m.m70687e("SyncAndBackupMianActivity", "ST is invalid,click disable");
            return;
        }
        if (hiCloudItemView != null) {
            m22276k2(hiCloudItemView.getId());
        }
        if (syncItemInfo == null) {
            return;
        }
        String id2 = syncItemInfo.getId();
        if (HNConstants.DataType.MEDIA.equals(id2)) {
            C13225d.m79490f1().m79585f0("mecloud_main_click_gallery", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_gallery", "1", "3");
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58393S0(this.f16071f0);
            }
        } else if ("notepad".equals(id2)) {
            if (this.f16095z) {
                InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
                if (interfaceC9284c != null) {
                    interfaceC9284c.mo17160y(this);
                }
                C13225d.m79490f1().m79585f0("mecloud_main_click_notepad_old", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_main_click_notepad_old", "1", "10");
            } else {
                this.f16094y.setChecked(!r0.isChecked());
                m22287q3(this.f16094y);
            }
        } else if (syncItemInfo.isDiskItem()) {
            C13225d.m79490f1().m79585f0("mecloud_main_click_more_data", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_more_data", "1", "37");
            Bundle bundle = new Bundle();
            bundle.putBoolean(NavigationUtils.SMS_SCHEMA_PREF, this.f16062W);
            bundle.putBoolean("calllog", this.f16063X);
            bundle.putBoolean("recordig", this.f16064Y);
            bundle.putBoolean("phonemanager", this.f16065Z);
            bundle.putBoolean("isShowCloudDisk", true);
            InterfaceC9284c interfaceC9284c2 = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c2 != null) {
                interfaceC9284c2.mo17132k(this, bundle);
            }
        }
        if (syncItemInfo.isDriveConfig()) {
            if (TextUtils.isEmpty(id2)) {
                C11839m.m70687e("SyncAndBackupMianActivity", "onItemClick, id is empty");
            } else {
                m22295v3(id2);
                C1008c.m6035v().m6073f0(this, id2);
            }
        }
    }

    /* renamed from: l2 */
    public final void m22309l2() {
        if (C10028c.m62182c0().m62388s("backup_key")) {
            m22300A2();
        } else {
            m22315z2();
        }
    }

    /* renamed from: l3 */
    public final void m22310l3() throws Resources.NotFoundException {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        C11839m.m70688i("SyncAndBackupMianActivity", "refreshBackupItemView backupOn: " + zM62388s + " baseBackupOn: " + zM62303a1);
        BackupCardInfo backupCardInfoM81004b = C13461a.m81002d(this).m81004b();
        if (!zM62303a1) {
            this.f16073h0.setVisibility(8);
            this.f16078m0.setVisibility(8);
        } else if (backupCardInfoM81004b == null) {
            C11839m.m70688i("SyncAndBackupMianActivity", "refreshBackupItemView baseCardInfo is null");
            this.f16073h0.setVisibility(8);
            this.f16078m0.setVisibility(0);
        } else {
            this.f16073h0.setVisibility(0);
            this.f16078m0.setVisibility(8);
            int baseModuleCount = backupCardInfoM81004b.getBaseModuleCount();
            if (zM62388s) {
                String baseFirstAppId = backupCardInfoM81004b.getBaseFirstAppId();
                String baseSecondAppId = backupCardInfoM81004b.getBaseSecondAppId();
                String quantityString = getResources().getQuantityString(R$plurals.backup_card_content_module_data, baseModuleCount, Integer.valueOf(baseModuleCount));
                this.f16073h0.setText(baseModuleCount > 2 ? getString(R$string.backup_card_content_module2, m22311s2(baseFirstAppId), m22311s2(baseSecondAppId), quantityString) : baseModuleCount == 2 ? getString(R$string.backup_card_content_module1, m22311s2(baseFirstAppId), m22311s2(baseSecondAppId), quantityString) : baseModuleCount == 1 ? m22311s2(baseFirstAppId) : "");
                return;
            }
            this.f16073h0.setText(getResources().getQuantityString(R$plurals.base_backup_close_tip_content, baseModuleCount, Integer.valueOf(baseModuleCount)));
        }
        if (C0209d.m1166E1()) {
            return;
        }
        this.f16073h0.setAlpha(0.62f);
        this.f16074i0.setAlpha(0.62f);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        this.f16046G = true;
        m22204F3(str, false);
        m22217M3(str, i10);
        C2783d.m16114V0(str, "1", "2", i10);
        m22254a4("");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Optional.ofNullable(this.f16082p0).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.r8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SyncAndBackupMainActivity.m22244X2((ImageView) obj);
            }
        });
        Optional.ofNullable(this.f16074i0).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.s8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SyncAndBackupMainActivity.m22247Y2((TextView) obj);
            }
        });
        m22316z3();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f16071f0 = this;
        this.f16087s = C10801o.m65744a(this);
        m22312t3();
        m22305S2();
        setContentView(R$layout.base_data_service_item);
        C1008c.m6035v().m6051P(this.f16071f0, null, false);
        m22230R2();
        mo19005p1();
        m22209J2();
        if (C13452e.m80781L().m80917g1()) {
            return;
        }
        this.f16047H.m83849a0();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m22245X3();
        m22308W3();
        m22282o2();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (!C13452e.m80781L().m80791C0()) {
            C1008c.m6035v().m6051P(this.f16071f0, null, false);
        } else {
            C11839m.m70689w("SyncAndBackupMianActivity", "current is full mode, finish");
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m22224P2();
        m22285p3();
        C1006a c1006aM5936k = C1006a.m5936k();
        if (c1006aM5936k.m5975v(C0213f.m1377a())) {
            c1006aM5936k.m5941E();
            c1006aM5936k.m5944H();
        }
        c1006aM5936k.m5957c(getApplicationContext());
        m22310l3();
        C13225d.m79490f1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "91");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C11839m.m70686d("SyncAndBackupMianActivity", "onStart");
        C12515a.m75110o().m75175e(new C3488i(), false);
    }

    /* renamed from: s2 */
    public final String m22311s2(String str) {
        String strM75774N = C12590s0.m75774N(this, str, str);
        if (!SplitAppUtil.hasSplitAppSuffix(str)) {
            return strM75774N;
        }
        String splitOriAppId = SplitAppUtil.getSplitOriAppId(str);
        return getResources().getString(R$string.refurbish_twin_app, C12590s0.m75774N(this, splitOriAppId, splitOriAppId));
    }

    /* renamed from: t3 */
    public final void m22312t3() {
        CBCallBack.getInstance().registerCallback(this.f16077l0);
    }

    /* renamed from: x3 */
    public final void m22313x3() {
        this.f16089t.setCheckedProgrammatically(false);
        this.f16091v.setCheckedProgrammatically(false);
        this.f16090u.setCheckedProgrammatically(false);
        this.f16044E.put(this.f16089t.getId(), this.f16089t);
        this.f16044E.put(this.f16091v.getId(), this.f16091v);
        this.f16044E.put(this.f16090u.getId(), this.f16090u);
        this.f16044E.put(this.f16092w.getId(), this.f16092w);
    }

    /* renamed from: y3 */
    public final void m22314y3() {
        m22248Y3(new RunnableC3482c());
    }

    /* renamed from: z2 */
    public final void m22315z2() {
        C11839m.m70688i("SyncAndBackupMianActivity", "goToBackupMainActivity");
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this, (Class<?>) BackupMainActivity.class));
        C13230i.m79525e1(hiCloudSafeIntent, "1", "2");
        startActivity(hiCloudSafeIntent);
    }

    /* renamed from: z3 */
    public final void m22316z3() {
        if (this.f16085r == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f16071f0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f16071f0, 2);
        if (C11829c.m70511E0(this.f16071f0)) {
            this.f16085r.setLayoutManager(gridLayoutManager);
            C1424b c1424b = this.f16087s;
            if (c1424b != null) {
                this.f16085r.removeItemDecoration(c1424b);
            }
            if (C11842p.m70753O0(this.f16071f0)) {
                this.f16085r.addItemDecoration(this.f16087s);
            }
        } else {
            this.f16085r.setLayoutManager(linearLayoutManager);
            C1424b c1424b2 = this.f16087s;
            if (c1424b2 != null) {
                this.f16085r.removeItemDecoration(c1424b2);
            }
        }
        this.f16085r.setAdapter(this.f16083q);
        m22314y3();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        this.f16046G = true;
        m22204F3(str, false);
        m22253a3(str, str2, i10);
        C2783d.m16114V0(str, "1", "1", i10);
        m22254a4("");
    }
}
