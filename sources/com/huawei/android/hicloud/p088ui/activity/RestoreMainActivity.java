package com.huawei.android.hicloud.p088ui.activity;

import ae.C0172u1;
import android.R;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.C0866e;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.provider.QueryAppRestoreFromProvider;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.service.BackupRestoreControlService;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.extend.HiCloudTextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.TextBannerSwitcher;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupRecoveryWlanDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MobileNetTipDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RestoreFailedDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RestoreLauncherDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopRecoveryDialog;
import com.huawei.android.hicloud.p088ui.uilistener.OnRestoreItemClickListener;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.C4868b;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p292fn.C9733f;
import p361i8.C10453b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12580p;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13619c;
import p783xp.C13843a;
import sk.C12809f;
import sl.C12816g;
import tk.C13021b;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;

/* loaded from: classes3.dex */
public class RestoreMainActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: x0 */
    public static boolean f15867x0 = true;

    /* renamed from: A */
    public HwButton f15868A;

    /* renamed from: B */
    public RelativeLayout f15869B;

    /* renamed from: C */
    public RestoreModuleAdapter f15870C;

    /* renamed from: D */
    public RelativeLayout f15871D;

    /* renamed from: E */
    public TextView f15872E;

    /* renamed from: F */
    public TextView f15873F;

    /* renamed from: G */
    public RelativeLayout f15874G;

    /* renamed from: H */
    public RelativeLayout f15875H;

    /* renamed from: I */
    public HiCloudTextView f15876I;

    /* renamed from: J */
    public TextView f15877J;

    /* renamed from: K */
    public TextView f15878K;

    /* renamed from: L */
    public ImageView f15879L;

    /* renamed from: M */
    public ImageView f15880M;

    /* renamed from: N */
    public RelativeLayout f15881N;

    /* renamed from: O */
    public LinearLayout f15882O;

    /* renamed from: P */
    public TextView f15883P;

    /* renamed from: Q */
    public LinearLayout f15884Q;

    /* renamed from: R */
    public HwButton f15885R;

    /* renamed from: S */
    public HwButton f15886S;

    /* renamed from: T */
    public RestoreFailedDialog f15887T;

    /* renamed from: U */
    public StopRecoveryDialog f15888U;

    /* renamed from: V */
    public BackupRecoveryWlanDialog f15889V;

    /* renamed from: W */
    public RestoreLauncherDialog f15890W;

    /* renamed from: b0 */
    public boolean f15895b0;

    /* renamed from: c0 */
    public MobileNetTipDialog f15896c0;

    /* renamed from: d0 */
    public NetWorkChangeReceiver f15897d0;

    /* renamed from: e0 */
    public BatteryChangeReceiver f15898e0;

    /* renamed from: f0 */
    public CutOutProgressDialog f15899f0;

    /* renamed from: g0 */
    public MobileNetTipDialog f15900g0;

    /* renamed from: h0 */
    public boolean f15901h0;

    /* renamed from: i0 */
    public String f15902i0;

    /* renamed from: j0 */
    public NotchFitLinearLayout f15903j0;

    /* renamed from: m0 */
    public MobileNetTipDialog f15906m0;

    /* renamed from: n0 */
    public boolean f15907n0;

    /* renamed from: o0 */
    public boolean f15908o0;

    /* renamed from: p0 */
    public BottomSheetDialog f15910p0;

    /* renamed from: q */
    public NotchTopFitRelativeLayout f15911q;

    /* renamed from: q0 */
    public float f15912q0;

    /* renamed from: r */
    public NotchFitRelativeLayout f15913r;

    /* renamed from: r0 */
    public RecyclerView f15914r0;

    /* renamed from: s */
    public NotchFitRelativeLayout f15915s;

    /* renamed from: s0 */
    public C0172u1 f15916s0;

    /* renamed from: t */
    public ListView f15917t;

    /* renamed from: u */
    public HwProgressBar f15919u;

    /* renamed from: v */
    public HwProgressBar f15921v;

    /* renamed from: w */
    public TextView f15923w;

    /* renamed from: x */
    public TextBannerSwitcher f15925x;

    /* renamed from: y */
    public TextView f15926y;

    /* renamed from: z */
    public HwButton f15927z;

    /* renamed from: p */
    public boolean f15909p = false;

    /* renamed from: X */
    public boolean f15891X = false;

    /* renamed from: Y */
    public boolean f15892Y = false;

    /* renamed from: Z */
    public boolean f15893Z = true;

    /* renamed from: a0 */
    public boolean f15894a0 = false;

    /* renamed from: k0 */
    public C13035n f15904k0 = new C13035n();

    /* renamed from: l0 */
    public C12816g f15905l0 = new C12816g();

    /* renamed from: t0 */
    public Handler.Callback f15918t0 = new C3456a();

    /* renamed from: u0 */
    public MobileNetTipDialog.MobileNetTipClickListener f15920u0 = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.activity.f8
        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            this.f17612a.m22020I2(dialogInterface, i10);
        }
    };

    /* renamed from: v0 */
    public MobileNetTipDialog.MobileNetTipClickListener f15922v0 = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.activity.g8
        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            this.f17622a.m22054J2(dialogInterface, i10);
        }
    };

    /* renamed from: w0 */
    public MobileNetTipDialog.MobileNetTipClickListener f15924w0 = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.activity.h8
        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            this.f17631a.m22055K2(dialogInterface, i10);
        }
    };

    public class BatteryChangeReceiver extends BroadcastReceiver {
        public BatteryChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("android.intent.action.BATTERY_CHANGED".equals(safeIntent.getAction())) {
                int intExtra = safeIntent.getIntExtra("status", 1);
                C11839m.m70688i("RestoreMainActivity", "batteryStatus: " + intExtra);
                if ((intExtra != 2 && intExtra != 5) || RestoreMainActivity.this.f15886S == null || C13452e.m80781L().m80916g0() == 6) {
                    return;
                }
                RestoreMainActivity.this.f15886S.setEnabled(RestoreMainActivity.this.f15893Z);
            }
        }
    }

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                C11839m.m70688i("RestoreMainActivity", "onReceive isNetWorkConnected" + C0209d.m1333z1(context));
                if (C13452e.m80781L().m80916g0() == 6 && RestoreMainActivity.this.f15893Z) {
                    RestoreMainActivity.this.m22073e3();
                }
                if (RestoreNotification.getInstance().isNetErr()) {
                    RestoreNotification.getInstance().showNetErrNotification(C13452e.m80781L().m80911f0());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$a */
    public class C3456a implements Handler.Callback {
        public C3456a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            Bundle data = message.getData();
            int i10 = message.what;
            if (i10 == 3205) {
                RestoreMainActivity.this.m22061R2(message);
                return false;
            }
            if (i10 == 32002) {
                C11839m.m70686d("RestoreMainActivity", "CMD_START_CLOUDBACKUP ");
                return false;
            }
            if (i10 == 32310) {
                RestoreMainActivity.this.m22059P2(message.getData());
                return false;
            }
            if (i10 == 33000) {
                C11839m.m70686d("RestoreMainActivity", "callback_restore_send_my_huawei");
                RestoreMainActivity.this.m22075g3();
                return false;
            }
            if (i10 == 33015) {
                C11839m.m70686d("RestoreMainActivity", "cancel proLoadingDialog");
                CutOutProgressDialog cutOutProgressDialog = RestoreMainActivity.this.f15899f0;
                if (cutOutProgressDialog == null) {
                    return false;
                }
                cutOutProgressDialog.dismiss();
                return false;
            }
            if (i10 == 32327) {
                if (data == null) {
                    return false;
                }
                RestoreMainActivity.this.m22101u3(data.getFloat(VastAttribute.PROGRESS, 0.0f));
                return false;
            }
            if (i10 != 32328 || data == null) {
                return false;
            }
            RestoreMainActivity.this.m22104w2(data.getString("speed"));
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$b */
    public class ServiceConnectionC3457b implements ServiceConnection {

        /* renamed from: a */
        public final /* synthetic */ String f15931a;

        public ServiceConnectionC3457b(String str) {
            this.f15931a = str;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ((BackupRestoreControlService.RestoreActivityBinder) iBinder).restore3rd(this.f15931a, false, RestoreMainActivity.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$c */
    public class C3458c extends C3460e {
        public C3458c(Context context) {
            super(context);
        }

        @Override // com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity.C3460e, android.text.style.ClickableSpan
        public void onClick(View view) {
            C11839m.m70688i("RestoreMainActivity", "click set network");
            RestoreMainActivity.this.m22083k3();
        }

        @Override // com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity.C3460e, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Resources resources = RestoreMainActivity.this.getResources();
            int i10 = R$color.hwbutton_text_normal_emui_custom;
            textPaint.setColor(resources.getColor(i10));
            Resources resources2 = RestoreMainActivity.this.getResources();
            if (!this.f15935a) {
                i10 = R$color.transparent;
            }
            textPaint.bgColor = resources2.getColor(i10);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$d */
    public class C3459d implements OnRestoreItemClickListener {
        public C3459d() {
        }

        @Override // com.huawei.android.hicloud.p088ui.uilistener.OnRestoreItemClickListener
        /* renamed from: a */
        public void mo22111a(CloudRestoreItem cloudRestoreItem) throws IllegalAccessException, IllegalArgumentException {
            if (cloudRestoreItem == null) {
                C11839m.m70687e("RestoreMainActivity", "onBasicItemClick, currentSelectedItem is null.");
                return;
            }
            C11839m.m70688i("RestoreMainActivity", "onBasicItemClick, appId: " + cloudRestoreItem.getAppId());
            if ("thirdApp" != cloudRestoreItem.getAppId()) {
                RestoreMainActivity.this.m22086m3(cloudRestoreItem);
                return;
            }
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r == null || listM29202r.isEmpty()) {
                C11839m.m70687e("RestoreMainActivity", "onBasicItemClick, appList is empty");
                return;
            }
            if (RestoreUtil.isRestoring()) {
                C11839m.m70688i("RestoreMainActivity", "onBasicItemClick, task is restoring");
                return;
            }
            C11839m.m70688i("RestoreMainActivity", "appList click, status:" + cloudRestoreItem.getStatus() + ";type:" + cloudRestoreItem.getType());
            if (cloudRestoreItem.getStatus() != 8 || cloudRestoreItem.getType() == 1) {
                return;
            }
            Intent intent = new Intent(RestoreMainActivity.this, (Class<?>) CloudRestoreApkListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("current_app_id", cloudRestoreItem.getAppId());
            intent.putExtras(bundle);
            RestoreMainActivity.this.startActivity(intent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$e */
    public class C3460e extends ClickableSpan {

        /* renamed from: a */
        public boolean f15935a = false;

        /* renamed from: b */
        public Context f15936b;

        public C3460e(Context context) {
            this.f15936b = context;
        }

        /* renamed from: b */
        public void m22113b(boolean z10) {
            this.f15935a = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("huawei.intent.action.HSM_STORAGE_CLEANER");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            intent.putExtra("auto_start", true);
            intent.putExtra(MapKeyNames.PACKAGE_NAME, RestoreMainActivity.this.getPackageName());
            try {
                C0209d.m1302r2(intent, C13843a.m83103y(RestoreMainActivity.this));
                RestoreMainActivity.this.startActivity(intent);
            } catch (ActivityNotFoundException e10) {
                C11839m.m70687e("RestoreMainActivity", "start activity not found: " + e10.toString());
            } catch (Exception e11) {
                C11839m.m70687e("RestoreMainActivity", "start activity error: " + e11.toString());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f15936b.getResources().getColor(R$color.emui_functional_blue));
            textPaint.bgColor = this.f15936b.getResources().getColor(this.f15935a ? R$color.emui9_list_seletor_color : R$color.transparent);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$f */
    public class C3461f extends LinkMovementMethod {

        /* renamed from: a */
        public C3460e f15938a;

        public C3461f() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            this.f15938a = RestoreMainActivity.this.m22102v2(textView, spannable, motionEvent);
            if (motionEvent.getAction() == 0) {
                C11839m.m70688i("RestoreMainActivity", "MyLinkMovementMethod email on click");
                if (this.f15938a != null) {
                    C11839m.m70688i("RestoreMainActivity", "mClickSpan is not null");
                    this.f15938a.m22113b(true);
                    this.f15938a.onClick(textView);
                    return true;
                }
            } else if (2 == motionEvent.getAction()) {
                C3460e c3460eM22102v2 = RestoreMainActivity.this.m22102v2(textView, spannable, motionEvent);
                C3460e c3460e = this.f15938a;
                if (c3460e != null && c3460eM22102v2 != c3460e) {
                    c3460e.m22113b(false);
                    this.f15938a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                C3460e c3460e2 = this.f15938a;
                if (c3460e2 == null) {
                    return true;
                }
                c3460e2.m22113b(false);
                this.f15938a = null;
            }
            return false;
        }

        public /* synthetic */ C3461f(RestoreMainActivity restoreMainActivity, C3456a c3456a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$g */
    public static class C3462g extends AbstractC12367d {
        public C3462g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            SystemClock.sleep(500L);
            ICBBroadcastManager.sendCancelCloudBackupStateBroadcast(2, CloudBackupStateUtil.getBroadcastId(2));
        }

        public /* synthetic */ C3462g(C3456a c3456a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.RestoreMainActivity$h */
    public class C3463h implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        public RestoreModuleAdapter f15940a;

        public C3463h(RestoreModuleAdapter restoreModuleAdapter) {
            this.f15940a = restoreModuleAdapter;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            C11839m.m70688i("RestoreMainActivity", "onItemClick, position = " + i10);
            if (RestoreMainActivity.this.f15908o0 || RestoreUtil.isNewBmRecord()) {
                C11839m.m70687e("RestoreMainActivity", "onItemClick, isNewBmRecord");
                return;
            }
            RestoreModuleAdapter restoreModuleAdapter = this.f15940a;
            if (restoreModuleAdapter == null) {
                C11839m.m70687e("RestoreMainActivity", "onItemClick, restoreModuleAdapter is null");
                return;
            }
            int count = restoreModuleAdapter.getCount();
            if (i10 < 0 || i10 >= count) {
                C11839m.m70687e("RestoreMainActivity", "onItemClick, position < 0 || position >= count");
                return;
            }
            CloudRestoreItem item = this.f15940a.getItem(i10);
            if (item == null) {
                C11839m.m70687e("RestoreMainActivity", "onItemClick, currentSelectedItem is null.");
                return;
            }
            if (!item.isShowChildList()) {
                if (RestoreAggregatedAppUtil.isShowAggregatedDialog(item) || RestoreMainActivity.this.m22051C2(item)) {
                    RestoreMainActivity restoreMainActivity = RestoreMainActivity.this;
                    restoreMainActivity.f15910p0 = RestoreAggregatedAppUtil.buildAggregatedAppsDetailDialog(restoreMainActivity, item);
                    if (RestoreMainActivity.this.f15910p0 != null) {
                        RestoreMainActivity.this.f15910p0.show();
                        return;
                    }
                    return;
                }
                return;
            }
            List<CloudRestoreItem> listM29202r = item.m29202r();
            if (listM29202r == null || listM29202r.isEmpty()) {
                return;
            }
            Intent intent = new Intent(RestoreMainActivity.this, (Class<?>) RestoreModuleListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("current_app_id", item.getAppId());
            intent.putExtras(bundle);
            RestoreMainActivity.this.startActivity(intent);
        }
    }

    /* renamed from: A2 */
    private void m22014A2() {
        this.f15911q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15903j0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_restore_main_layout);
        this.f15913r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_restore_main_loading);
        this.f15915s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_bottom_layout);
        this.f15881N = (RelativeLayout) C12809f.m76829b(this, R$id.restore_main_loading);
        this.f15882O = (LinearLayout) C12809f.m76829b(this, R$id.restore_main);
        this.f15881N.setVisibility(0);
        this.f15882O.setVisibility(8);
        this.f15869B = (RelativeLayout) C12809f.m76829b(this, R$id.restore_process_layout);
        this.f15871D = (RelativeLayout) C12809f.m76829b(this, R$id.restore_failed_layout);
        this.f15872E = (TextView) C12809f.m76829b(this, R$id.restore_failed_tv);
        this.f15873F = (TextView) C12809f.m76829b(this, R$id.restore_failed_tv_2);
        this.f15874G = (RelativeLayout) C12809f.m76829b(this, R$id.restore_top_tip);
        this.f15917t = (ListView) C12809f.m76829b(this, R$id.restore_listview);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.new_bm_recyclerView);
        this.f15914r0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f15914r0.setNestedScrollingEnabled(false);
        C0866e c0866e = new C0866e();
        c0866e.setSupportsChangeAnimations(false);
        this.f15914r0.setItemAnimator(c0866e);
        this.f15921v = (HwProgressBar) C12809f.m76829b(this, R$id.restore_ready_progress);
        this.f15919u = (HwProgressBar) C12809f.m76829b(this, R$id.restore_progress);
        this.f15926y = (TextView) C12809f.m76829b(this, R$id.restore_module_process);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.stop_restoring_btn);
        this.f15927z = hwButton;
        hwButton.setOnClickListener(this);
        this.f15875H = (RelativeLayout) C12809f.m76829b(this, R$id.restore_succ_layout);
        this.f15876I = (HiCloudTextView) C12809f.m76829b(this, R$id.restore_succ_tip);
        this.f15877J = (TextView) C12809f.m76829b(this, R$id.restore_succ_prompt);
        this.f15878K = (TextView) C12809f.m76829b(this, R$id.restore_fail_prompt);
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.restore_ok_btn);
        this.f15868A = hwButton2;
        hwButton2.setOnClickListener(this);
        this.f15883P = (TextView) C12809f.m76829b(this, R$id.restore_process_tv);
        this.f15923w = (TextView) C12809f.m76829b(this, R$id.restore_tv);
        this.f15925x = (TextBannerSwitcher) C12809f.m76829b(this, R$id.restore_tbv);
        this.f15884Q = (LinearLayout) C12809f.m76829b(this, R$id.continue_retry_layout);
        HwButton hwButton3 = (HwButton) C12809f.m76829b(this, R$id.restore_cancel_ok_btn);
        this.f15885R = hwButton3;
        hwButton3.setOnClickListener(this);
        HwButton hwButton4 = (HwButton) C12809f.m76829b(this, R$id.restore_continue_retry_btn);
        this.f15886S = hwButton4;
        hwButton4.setOnClickListener(this);
        this.f15879L = (ImageView) C12809f.m76829b(this, R$id.restore_failed_iv);
        this.f15880M = (ImageView) C12809f.m76829b(this, R$id.restore_succ_iv);
        this.f15887T = new RestoreFailedDialog(this);
        C11842p.m70874v1(this, this.f15927z);
        C11842p.m70874v1(this, this.f15868A);
        C11842p.m70721D1(this.f15923w, 1.0f);
        this.f15906m0 = new MobileNetTipDialog(this, this.f15920u0, false);
    }

    /* renamed from: D2 */
    public static boolean m22015D2() {
        return f15867x0;
    }

    /* renamed from: D3 */
    private void m22016D3() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f15897d0;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f15897d0 = null;
        }
    }

    /* renamed from: F2 */
    private void m22017F2() {
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras == null) {
            C11839m.m70687e("RestoreMainActivity", "bundle is null");
            return;
        }
        int i10 = extras.getInt(FamilyShareConstants.ENTRY_TYPE);
        if (i10 != 1) {
            String string = extras.getString("entrance_of_restore");
            Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, i10);
            intent.putExtra("entrance_of_restore", string);
            if (!TextUtils.isEmpty(this.f15902i0)) {
                intent.putExtra("moudle", this.f15902i0);
            }
            startActivity(intent);
        }
    }

    /* renamed from: G2 */
    public static /* synthetic */ boolean m22018G2(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equalsIgnoreCase(cloudRestoreItem.getAppId());
    }

    /* renamed from: H2 */
    public static /* synthetic */ int m22019H2(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75586t(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: I2 */
    public /* synthetic */ void m22020I2(DialogInterface dialogInterface, int i10) {
        if (C0209d.m1226Y0()) {
            return;
        }
        String appId = this.f15906m0.getAppId();
        if (i10 == -2) {
            m22085m2(appId);
            dialogInterface.dismiss();
        } else {
            if (i10 != -1) {
                return;
            }
            bindService(new Intent(this, (Class<?>) BackupRestoreControlService.class), new ServiceConnectionC3457b(appId), 1);
            dialogInterface.dismiss();
            C10782d.m65634a().m65640g(this);
        }
    }

    /* renamed from: L2 */
    public static /* synthetic */ boolean m22022L2(AtomicReference atomicReference, CloudRestoreItem cloudRestoreItem) {
        if (!TextUtils.equals(cloudRestoreItem.getAppId(), "bmBaseData")) {
            return true;
        }
        if (cloudRestoreItem.getAction() == 2) {
            return false;
        }
        atomicReference.set(cloudRestoreItem);
        return false;
    }

    /* renamed from: V2 */
    private void m22033V2() {
        if (this.f15897d0 == null) {
            this.f15897d0 = new NetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f15897d0, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: l3 */
    public static void m22045l3(boolean z10) {
        f15867x0 = z10;
    }

    /* renamed from: q2 */
    private List<CloudRestoreItem> m22046q2(List<CloudRestoreItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) it.next();
            if (SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                List arrayList2 = map.get(cloudRestoreItem.getOriBackupAppName()) != null ? (List) map.get(cloudRestoreItem.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(cloudRestoreItem);
                    map.put(cloudRestoreItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.i8
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return RestoreMainActivity.m22018G2(str, (CloudRestoreItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    CloudRestoreItem cloudRestoreItem2 = (CloudRestoreItem) optionalFindFirst.get();
                    List<CloudRestoreItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.j8
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return RestoreMainActivity.m22019H2((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                            }
                        });
                        cloudRestoreItem2.m29177E0(list2);
                        list.removeAll(list2);
                        list.addAll(list.indexOf(cloudRestoreItem2) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: z2 */
    private void m22047z2(boolean z10) {
        CloudBackupService.getInstance().register(this.f15918t0);
        Intent intent = getIntent();
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            this.f15902i0 = safeIntent.getStringExtra("moudle");
            Bundle extras = safeIntent.getExtras();
            if (extras != null) {
                C10343b c10343b = new C10343b(extras);
                this.f15894a0 = c10343b.m63682d("is_form_notification", false);
                m22108y2(c10343b.m63689k("restore_selected_size", 0L));
                if (this.f15894a0 && c10343b.m63687i("restore_status", -1) == 6) {
                    C11829c.m70612r1(this);
                }
                if (z10) {
                    this.f15908o0 = c10343b.m63682d("isNewBmRecord", RestoreUtil.isNewBmRecord());
                    C13466f.m81073d().m81081i("restore_is_new_bm_record", this.f15908o0);
                }
            }
            boolean booleanExtra = safeIntent.getBooleanExtra("is_form_service", false);
            this.f15895b0 = booleanExtra;
            if (booleanExtra) {
                this.f15906m0.setAppId(safeIntent.getStringExtra("restore_app"));
                this.f15906m0.show();
            }
        }
        this.f15890W = new RestoreLauncherDialog(this, true);
        CloudBackupService.getInstance().showReports();
        this.f15888U = new StopRecoveryDialog(this, true);
        this.f15889V = new BackupRecoveryWlanDialog(this);
        CutOutProgressDialog cutOutProgressDialog = new CutOutProgressDialog(this);
        this.f15899f0 = cutOutProgressDialog;
        cutOutProgressDialog.setMessage(getString(R$string.waiting_tip));
        this.f15899f0.setCancelable(false);
        this.f15896c0 = new MobileNetTipDialog(this, this.f15924w0, false);
        this.f15900g0 = new MobileNetTipDialog(this, this.f15922v0, false);
        C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
        RestoreModuleAdapter restoreModuleAdapter = new RestoreModuleAdapter(this);
        this.f15870C = restoreModuleAdapter;
        if (this.f15908o0) {
            return;
        }
        this.f15917t.setOnItemClickListener(new C3463h(restoreModuleAdapter));
    }

    /* renamed from: A3 */
    public final List<CloudRestoreItem> m22048A3(List<CloudRestoreItem> list) {
        CloudRestoreItem next;
        ArrayList arrayList = new ArrayList();
        if (RestoreUtil.isNewBmRecord() || this.f15908o0) {
            next = null;
        } else {
            Iterator<CloudRestoreItem> it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                if ("sysdata".equals(next.getAppId())) {
                    it.remove();
                    break;
                }
            }
            next = null;
        }
        Iterator<CloudRestoreItem> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            CloudRestoreItem next2 = it2.next();
            if ("thirdAppData".equals(next2.getAppId())) {
                arrayList.addAll(next2.m29202r());
                it2.remove();
                break;
            }
        }
        list.addAll(arrayList);
        if (next != null) {
            list.add(0, next);
        }
        return list;
    }

    /* renamed from: B2 */
    public boolean m22049B2() {
        return this.f15881N.getVisibility() == 0;
    }

    /* renamed from: B3 */
    public void m22050B3() {
        if (CBAccess.inRestoreTask()) {
            CutOutProgressDialog cutOutProgressDialog = this.f15899f0;
            if (cutOutProgressDialog != null) {
                cutOutProgressDialog.show();
            }
            CloudBackupService.getInstance().abort();
            C13452e.m80781L().m80890b();
            C13466f.m81073d().m81081i("restore_is_new_bm_record", false);
        }
    }

    /* renamed from: C2 */
    public final boolean m22051C2(CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem == null || !this.f15892Y || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1 || (cloudRestoreItem.getStatus() == 8 && cloudRestoreItem.getType() == 1)) ? false : true;
    }

    /* renamed from: C3 */
    public final void m22052C3() {
        BatteryChangeReceiver batteryChangeReceiver = this.f15898e0;
        if (batteryChangeReceiver != null) {
            unregisterReceiver(batteryChangeReceiver);
            this.f15898e0 = null;
        }
    }

    /* renamed from: E2 */
    public final boolean m22053E2() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreMainActivity", "restore3rdPause tags is null, exception: " + e10.getMessage());
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i("RestoreMainActivity", "restore3rdPause tags is null");
            return false;
        }
        if (TextUtils.isEmpty(C12590s0.m75924y0(c13029hM78495f))) {
            C11839m.m70688i("RestoreMainActivity", "current is v2 restore");
            return false;
        }
        C11839m.m70688i("RestoreMainActivity", "current is v3 restore");
        return true;
    }

    /* renamed from: J2 */
    public final /* synthetic */ void m22054J2(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportRestoreCancel(MobileTrafficReport.RESTORE_MAIN_DIALOG);
        } else {
            if (i10 != -1) {
                return;
            }
            m22067Y2();
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().setDialogType(MobileTrafficReport.RESTORE_MAIN_DIALOG);
            C10782d.m65634a().m65640g(this);
        }
    }

    /* renamed from: K2 */
    public final /* synthetic */ void m22055K2(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportRestoreCancel(MobileTrafficReport.RESTORE_MAIN_DIALOG);
        } else {
            if (i10 != -1) {
                return;
            }
            m22074f3();
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().setDialogType(MobileTrafficReport.RESTORE_MAIN_DIALOG);
            C10782d.m65634a().m65640g(this);
        }
    }

    /* renamed from: M2 */
    public final /* synthetic */ void m22056M2(int i10) {
        TextView textView = this.f15878K;
        if (textView != null) {
            textView.scrollTo(0, i10);
        }
    }

    /* renamed from: N2 */
    public final void m22057N2() {
        m22073e3();
    }

    /* renamed from: O2 */
    public final void m22058O2() {
        this.f15884Q.setVisibility(8);
        this.f15927z.setVisibility(8);
        this.f15868A.setVisibility(0);
    }

    /* renamed from: P2 */
    public final void m22059P2(Bundle bundle) {
        if (bundle == null || this.f15891X || this.f15892Y) {
            C11839m.m70689w("RestoreMainActivity", "onOneModuleUpdate isManulCanceled = " + this.f15891X + " ,isPause = " + this.f15892Y);
            return;
        }
        String string = bundle.getString("appId");
        CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) bundle.getParcelable("item");
        if (string == null || cloudRestoreItem == null) {
            return;
        }
        if (!this.f15908o0 && !RestoreUtil.isNewBmRecord()) {
            RestoreModuleAdapter restoreModuleAdapter = this.f15870C;
            if (restoreModuleAdapter != null) {
                restoreModuleAdapter.m25116A(cloudRestoreItem);
                return;
            }
            return;
        }
        C0172u1 c0172u1 = this.f15916s0;
        if (c0172u1 == null) {
            C11839m.m70687e("RestoreMainActivity", "onOneModuleUpdate, newBmAdapter is null");
        } else {
            c0172u1.m964h0(cloudRestoreItem);
        }
    }

    /* renamed from: Q2 */
    public void m22060Q2() {
        if (this.f15893Z) {
            return;
        }
        C11839m.m70688i("RestoreMainActivity", "onRestoreFailedConfirmed data not prepare done");
        C13452e.m80781L().m80890b();
        RestoreNotification.getInstance().cancelNotification();
        setResult(0);
        if (this.f15909p) {
            Bundle extras = new SafeIntent(getIntent()).getExtras();
            extras.putBoolean("record_not_exists", true);
            Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
        finish();
    }

    /* renamed from: R2 */
    public final void m22061R2(Message message) throws Resources.NotFoundException {
        StopRecoveryDialog stopRecoveryDialog;
        int i10 = message.arg1;
        int i11 = message.arg2;
        Boolean bool = (Boolean) message.obj;
        C11839m.m70688i("RestoreMainActivity", "onRestoreStatusHandle status = " + i10 + " ,code = " + i11 + " ,isShowDialog: " + bool);
        if (i10 == 0) {
            if ("myHuawei".equals(this.f15902i0)) {
                m22017F2();
                return;
            } else {
                m22080j2();
            }
        }
        if (!CBAccess.inRestore() && (stopRecoveryDialog = this.f15888U) != null && stopRecoveryDialog.isShowing()) {
            this.f15888U.dismiss();
        }
        switch (i10) {
            case 1:
                m22107x3();
                RestoreAggregatedAppUtil.dismissAggregatedAppsDetailDialog(this.f15910p0);
                break;
            case 2:
                m22092p3();
                break;
            case 3:
                m22090o3();
                break;
            case 4:
                m22095r3(i11, bool);
                break;
            case 5:
                m22093q3(i11, bool);
                break;
            case 6:
                m22099t3();
                break;
            case 7:
                m22105w3();
                break;
            case 8:
                m22109y3();
                break;
        }
    }

    /* renamed from: S2 */
    public final RestoreStatus m22062S2(boolean z10, String str) {
        if (!z10) {
            C11839m.m70688i("RestoreMainActivity", "resume v2 3rd module task");
            return this.f15904k0.m78554f(str);
        }
        C11839m.m70688i("RestoreMainActivity", "resume v3 3rd module task");
        List<CloudRestoreStatusV3> listM76951o = this.f15905l0.m76951o(str);
        if (listM76951o == null || listM76951o.size() <= 0) {
            return null;
        }
        return listM76951o.get(0);
    }

    /* renamed from: T2 */
    public final void m22063T2(boolean z10) {
        C11839m.m70688i("RestoreMainActivity", "refreshListView strart");
        if (this.f15870C == null || this.f15917t == null) {
            C11839m.m70687e("RestoreMainActivity", "refreshListView date or view is null");
            return;
        }
        List<CloudRestoreItem> listM22048A3 = m22048A3(RestoreProgress.getItemList());
        if (z10) {
            listM22048A3.sort(new C3710d8());
        }
        if (!this.f15908o0 && !RestoreUtil.isNewBmRecord()) {
            this.f15914r0.setVisibility(8);
            this.f15917t.setVisibility(0);
            this.f15870C.m25138w(m22046q2(listM22048A3));
            this.f15917t.setAdapter((ListAdapter) this.f15870C);
            this.f15870C.notifyDataSetChanged();
            return;
        }
        C11839m.m70688i("RestoreMainActivity", "refreshListView new bm Record");
        this.f15917t.setVisibility(8);
        final AtomicReference atomicReference = new AtomicReference(new CloudRestoreItem());
        List<CloudRestoreItem> list = (List) listM22048A3.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.e8
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return RestoreMainActivity.m22022L2(atomicReference, (CloudRestoreItem) obj);
            }
        }).collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) atomicReference.get();
        if (cloudRestoreItem != null) {
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r != null && !listM29202r.isEmpty()) {
                if (z10) {
                    listM29202r.sort(new C3710d8());
                }
                arrayList.addAll(m22082k2(getString(R$string.base_service_data), m22046q2(listM29202r)));
            }
        } else {
            C11839m.m70688i("RestoreMainActivity", "refreshListView baseRestoreAllData is null.");
        }
        if (list.isEmpty()) {
            C11839m.m70688i("RestoreMainActivity", "refreshListView adapterData is null.");
        } else {
            if (!arrayList.isEmpty()) {
                arrayList.add(new C4868b(null, null, 2));
            }
            arrayList.addAll(m22082k2(getString(R$string.full_data_new), m22046q2(list)));
        }
        if (arrayList.isEmpty()) {
            C11839m.m70688i("RestoreMainActivity", "refreshListView newBmRecyclerView gone.");
            this.f15914r0.setVisibility(8);
            return;
        }
        this.f15914r0.setVisibility(0);
        if (this.f15916s0 == null) {
            C0172u1 c0172u1 = new C0172u1(this, arrayList);
            this.f15916s0 = c0172u1;
            this.f15914r0.setAdapter(c0172u1);
            this.f15916s0.m961e0(new C3459d());
            this.f15916s0.m5213j();
            return;
        }
        RecyclerView.AbstractC0846p layoutManager = this.f15914r0.getLayoutManager();
        Parcelable parcelableOnSaveInstanceState = layoutManager.onSaveInstanceState();
        this.f15914r0.setAdapter(this.f15916s0);
        this.f15916s0.m948R(arrayList);
        layoutManager.onRestoreInstanceState(parcelableOnSaveInstanceState);
    }

    /* renamed from: U2 */
    public final void m22064U2() {
        if (this.f15898e0 == null) {
            this.f15898e0 = new BatteryChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            registerReceiver(this.f15898e0, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: W2 */
    public final void m22065W2(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("network_restore", str);
        C13225d.m79490f1().m79567R("cloudbackup_network_restore", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_network_restore", linkedHashMap);
    }

    /* renamed from: X2 */
    public final void m22066X2() {
        RestoreNotification.getInstance().cancelNotification();
        m22107x3();
    }

    /* renamed from: Y2 */
    public final void m22067Y2() {
        m22072d3();
        RestoreNotification.getInstance().cancelNotification();
        m22107x3();
    }

    /* renamed from: Z2 */
    public final void m22068Z2() {
        if (!C10782d.m65634a().m65645l()) {
            if (C0209d.m1254f2(this)) {
                m22067Y2();
                return;
            } else {
                this.f15889V.customShow();
                return;
            }
        }
        if (!C0209d.m1333z1(this)) {
            this.f15889V.customShow();
            return;
        }
        if (!C10782d.m65634a().m65644k(this)) {
            m22067Y2();
            return;
        }
        MobileNetTipDialog mobileNetTipDialog = this.f15900g0;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011d  */
    /* renamed from: a3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m22069a3(boolean r7, boolean r8, int r9) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity.m22069a3(boolean, boolean, int):void");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    /* renamed from: b3 */
    public final void m22070b3() {
        if (!"myHuawei".equals(this.f15902i0)) {
            C13452e.m80781L().m80890b();
            RestoreProgress.clearCache();
        }
        RestoreNotification.getInstance().cancelNotification();
        C13466f.m81073d().m81081i("restore_is_new_bm_record", false);
    }

    /* renamed from: c3 */
    public final void m22071c3(boolean z10) {
        C11839m.m70688i("RestoreMainActivity", "showRestoredDetail view");
        this.f15881N.setVisibility(8);
        this.f15882O.setVisibility(0);
        this.f15874G.setVisibility(8);
        this.f15871D.setVisibility(8);
        this.f15875H.setVisibility(0);
        this.f15873F.setVisibility(8);
        this.f15878K.setVisibility(8);
        this.f15925x.m24030m();
        this.f15927z.setVisibility(8);
        if (z10) {
            this.f15868A.setVisibility(8);
            this.f15884Q.setVisibility(0);
            this.f15885R.setText(getString(R$string.cloudbackup_btn_ok_new));
            this.f15886S.setText(getString(R$string.cloudbackup_retry));
            this.f15885R.setVisibility(0);
        } else {
            this.f15884Q.setVisibility(8);
            this.f15868A.setVisibility(0);
        }
        if (getResources() == null) {
            C11839m.m70687e("RestoreMainActivity", "restoreSuccess resources is null");
            return;
        }
        this.f15891X = false;
        this.f15892Y = false;
        m22063T2(true);
        List<CloudRestoreItem> itemList = RestoreProgress.getItemList();
        int failCount = RestoreUtil.getFailCount(0, itemList);
        C11839m.m70688i("RestoreMainActivity", "restoreSuccess failedCount = " + failCount);
        int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
        C11839m.m70688i("RestoreMainActivity", "restoreSuccess succeedCount = " + succeedCount);
        if (failCount > 0 && succeedCount > 0) {
            this.f15877J.setText(this.f15908o0 ? getResources().getQuantityString(R$plurals.backup_restore_not_completed_not_retry, failCount, Integer.valueOf(failCount)) : m22098t2(z10));
            this.f15877J.setVisibility(0);
            this.f15880M.setImageResource(R$drawable.ic_public_part);
            this.f15876I.setText(getString(R$string.restore_partial_completed));
        } else if (succeedCount > 0) {
            this.f15880M.setImageResource(R$drawable.ic_success);
            this.f15877J.setVisibility(8);
            this.f15876I.setText(getString(R$string.restore_new_success));
        } else if (failCount > 0) {
            this.f15877J.setText(m22098t2(z10));
            this.f15877J.setVisibility(0);
            this.f15880M.setImageResource(R$drawable.ic_public_error);
            this.f15876I.setText(getString(R$string.restore_failed));
        }
        this.f15876I.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15911q);
        arrayList.add(this.f15913r);
        arrayList.add(this.f15915s);
        arrayList.add(this.f15903j0);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m22072d3() {
        C11839m.m70688i("RestoreMainActivity", "resume all paused apks.");
        Intent intent = new Intent(this, (Class<?>) BackupRestoreControlService.class);
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, 5);
        startService(intent);
    }

    /* renamed from: e3 */
    public final void m22073e3() {
        this.f15886S.setEnabled(C10782d.m65634a().m65642i(this));
    }

    /* renamed from: f3 */
    public final void m22074f3() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b unused) {
            C11839m.m70687e("RestoreMainActivity", "tags is null");
            c13029hM78495f = null;
        }
        boolean zRestoreRetry = (c13029hM78495f == null || !C13619c.m81952h(c13029hM78495f.m78480t())) ? CloudBackupService.getInstance().restoreRetry(false, true, false) : CloudBackupService.getInstance().restoreRetryV3(false, true);
        m22066X2();
        C11839m.m70688i("RestoreMainActivity", " manul onClick restoreRetry " + zRestoreRetry);
        if (zRestoreRetry) {
            return;
        }
        C11839m.m70689w("RestoreMainActivity", "retry failed, finish current activity");
        finish();
    }

    /* renamed from: g3 */
    public final void m22075g3() {
        if ("myHuawei".equals(this.f15902i0)) {
            CBAccess.setRestoreTaskToMyHuawei();
        }
    }

    /* renamed from: h2 */
    public final void m22076h2() {
        C13029h c13029hM78495f;
        if (CBAccess.isCloudBackupTaskRunning() || !CBAccess.prePareDateDone() || CBAccess.isShowRestorePause()) {
            m22075g3();
            return;
        }
        C11839m.m70688i("RestoreMainActivity", "auto retry restore");
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b unused) {
            C11839m.m70687e("RestoreMainActivity", "tags is null");
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i("RestoreMainActivity", "query tags is null.");
        } else if (!C0209d.m1254f2(this) || ICBUtil.isRestoreRetryTimeExpires(c13029hM78495f.m78440F())) {
            C11839m.m70688i("RestoreMainActivity", "auto retry abort");
        } else {
            m22094r2(false);
        }
    }

    /* renamed from: h3 */
    public final void m22077h3(int i10) {
        C11839m.m70688i("RestoreMainActivity", "setErrMessage errCode = " + i10);
        RestoreFailedDialog restoreFailedDialog = this.f15887T;
        if (restoreFailedDialog == null) {
            C11839m.m70687e("RestoreMainActivity", "restoreFailedDialog is null");
            return;
        }
        if (i10 != 1002) {
            if (i10 == 1004) {
                this.f15887T.setMessage(getString(R$string.cloud_restore_failed_battery_2, C0209d.m1232a0(C2783d.m16075C(m22096s2()))));
                m22088n3(this.f15887T);
                return;
            }
            if (i10 == 1007) {
                restoreFailedDialog.setMessage(getString(R$string.cloud_restore_failed_local_space_2));
                m22088n3(this.f15887T);
                return;
            }
            if (i10 != 1102 && i10 != 3107) {
                if (i10 == 3109) {
                    restoreFailedDialog.setMessage(getString(R$string.restore_failed_not_exist));
                    this.f15909p = true;
                    m22088n3(this.f15887T);
                    return;
                } else if (i10 != 3307) {
                    switch (i10) {
                        case 1104:
                        case 1105:
                        case 1106:
                        case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                            break;
                        default:
                            switch (i10) {
                                case 3103:
                                case 3104:
                                case 3105:
                                    break;
                                default:
                                    switch (i10) {
                                        case 3203:
                                        case 3204:
                                        case 3205:
                                            break;
                                        default:
                                            switch (i10) {
                                            }
                                    }
                            }
                            if (!this.f15893Z) {
                                restoreFailedDialog.setMessage(getString(R$string.restore_failed_net_error));
                                m22088n3(this.f15887T);
                                break;
                            }
                            break;
                    }
                    return;
                }
            }
            if (this.f15893Z) {
                return;
            }
            restoreFailedDialog.setMessage(getString(R$string.restore_failed_sever_error));
            m22088n3(this.f15887T);
            return;
        }
        if (this.f15893Z) {
            return;
        }
        restoreFailedDialog.setMessage(getString(R$string.restore_failed_net_disable));
        m22088n3(this.f15887T);
    }

    /* renamed from: i2 */
    public final void m22078i2() {
        if (this.f15894a0) {
            m22080j2();
            return;
        }
        if ("myHuawei".equals(this.f15902i0)) {
            moveTaskToBack(true);
            setResult(C5963j.f27043l);
            finish();
            return;
        }
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras == null || extras.getBoolean("new_version_flag", false)) {
            int iM80916g0 = C13452e.m80781L().m80916g0();
            if (iM80916g0 == 3 || iM80916g0 == 5) {
                C11839m.m70688i("RestoreMainActivity", "restoreFlowComplete");
                m22070b3();
            }
            setResult(C5963j.f27043l);
        } else {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        }
        finish();
    }

    /* renamed from: i3 */
    public void m22079i3() {
        TextView textView = this.f15878K;
        if (textView != null) {
            textView.scrollTo(0, 0);
        }
    }

    /* renamed from: j2 */
    public final void m22080j2() {
        startActivity(C13452e.m80781L().m80842P0() ? new Intent(this, (Class<?>) MainActivity.class) : new Intent(this, (Class<?>) NewHiSyncSettingActivity.class));
        finish();
    }

    /* renamed from: j3 */
    public final void m22081j3() throws Resources.NotFoundException {
        String string = getString(R$string.restore_net_disconnet_new);
        String string2 = getString(R$string.set_net);
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new C3458c(this), 0, string2.length(), 17);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), 0, string2.length(), 17);
        Drawable drawable = getResources().getDrawable(R$drawable.ic_public_arrow_right_new);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannableString2 = new SpannableString(" ");
        C13021b c13021b = new C13021b(drawable, (int) C11842p.m70844o(this, 4), " ");
        spannableString2.setSpan(c13021b, 0, 1, 17);
        this.f15878K.setHighlightColor(0);
        this.f15878K.setText("");
        this.f15878K.append(string);
        this.f15878K.append("  ");
        this.f15878K.append(spannableString);
        this.f15878K.append(spannableString2);
        this.f15878K.setMovementMethod(new C3461f(this, null));
        TextPaint paint = this.f15878K.getPaint();
        paint.setTextSize(getResources().getDimensionPixelSize(R$dimen.emui_text_size_overline));
        paint.setTypeface(Typeface.create("HwChinese-regular", paint.getTypeface().getStyle()));
        if ((C11842p.m70753O0(this) ? C11842p.m70752O(this) : C11842p.m70758Q(this)) - (getResources().getDimensionPixelSize(R$dimen.padding_xl) * 2) < ((int) paint.measureText(this.f15878K.getText().toString())) + drawable.getIntrinsicWidth()) {
            this.f15878K.invalidate();
        } else {
            c13021b.m78358a(new C13021b.a() { // from class: com.huawei.android.hicloud.ui.activity.k8
                @Override // tk.C13021b.a
                /* renamed from: a */
                public final void mo23908a(int i10) {
                    this.f17660a.m22056M2(i10);
                }
            });
        }
        this.f15878K.setVisibility(0);
    }

    /* renamed from: k2 */
    public final List<C4868b> m22082k2(String str, List<CloudRestoreItem> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C4868b(null, str, 0));
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 == list.size() - 1) {
                arrayList.add(new C4868b(list.get(i10), null, 3));
            } else {
                arrayList.add(new C4868b(list.get(i10), null, 1));
            }
        }
        return arrayList;
    }

    /* renamed from: k3 */
    public final void m22083k3() {
        C11829c.m70612r1(this);
        C13225d.m79490f1().m79585f0("action_code_backup_detail_set_wlan", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_backup_detail_set_wlan", "1", "77");
    }

    /* renamed from: l2 */
    public final void m22084l2(boolean z10) {
        this.f15927z.setVisibility(8);
        this.f15868A.setVisibility(8);
        this.f15884Q.setVisibility(0);
        this.f15885R.setText(getString(R$string.cloudbackup_btn_ok_new));
        this.f15886S.setText(getString(R$string.cloudbackup_retry));
        if (z10) {
            this.f15885R.setText(getString(R$string.cloudbackup_Cancel));
            this.f15886S.setText(getString(R$string.restore_continue));
        }
    }

    /* renamed from: m2 */
    public final void m22085m2(String str) {
        boolean zM22053E2 = m22053E2();
        RestoreStatus restoreStatusM22062S2 = m22062S2(zM22053E2, str);
        if (restoreStatusM22062S2 != null) {
            ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatusM22062S2, zM22053E2, this);
        }
    }

    /* renamed from: m3 */
    public final void m22086m3(CloudRestoreItem cloudRestoreItem) throws IllegalAccessException, IllegalArgumentException {
        if (RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem) || m22051C2(cloudRestoreItem)) {
            BottomSheetDialog bottomSheetDialogBuildAggregatedAppsDetailDialog = RestoreAggregatedAppUtil.buildAggregatedAppsDetailDialog(this, cloudRestoreItem);
            this.f15910p0 = bottomSheetDialogBuildAggregatedAppsDetailDialog;
            if (bottomSheetDialogBuildAggregatedAppsDetailDialog != null) {
                bottomSheetDialogBuildAggregatedAppsDetailDialog.show();
            }
        }
    }

    /* renamed from: n2 */
    public final void m22087n2(int i10) {
        if (this.f15878K != null && i10 == 3920) {
            m22079i3();
            this.f15878K.setVisibility(0);
            this.f15878K.setText(R$string.toast_tip_in_delete_backup);
        }
    }

    /* renamed from: n3 */
    public final void m22088n3(AlertDialog alertDialog) {
        if (alertDialog == null) {
            C11839m.m70687e("RestoreMainActivity", "dialog is null");
            return;
        }
        if (isDestroyed()) {
            C11839m.m70687e("RestoreMainActivity", "activity recycled, do not show dialog");
            return;
        }
        if (!alertDialog.isShowing()) {
            alertDialog.show();
            return;
        }
        C11839m.m70689w("RestoreMainActivity", "dialog is showing, do not show again, dialog = " + alertDialog);
    }

    /* renamed from: o2 */
    public final void m22089o2() {
        SafeIntent safeIntent;
        Bundle extras;
        if (m22015D2() && (extras = (safeIntent = new SafeIntent(getIntent())).getExtras()) != null && 1 == safeIntent.getIntExtra("current_status", 0) && extras.getInt(FamilyShareConstants.ENTRY_TYPE, 0) != 1 && m22106x2() && QueryAppRestoreFromProvider.checkPrioritRestoreIcon(this)) {
            C11839m.m70688i("RestoreMainActivity", "checkLauncherDialog show launcher dialog");
            m22088n3(this.f15890W);
            m22045l3(false);
        }
    }

    /* renamed from: o3 */
    public final void m22090o3() {
        m22071c3(false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m22078i2();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C13029h c13029hM78495f;
        if (view.getId() == R$id.stop_restoring_btn) {
            this.f15888U.customShow();
            return;
        }
        if (view.getId() == R$id.restore_ok_btn) {
            m22070b3();
            finish();
            return;
        }
        if (view.getId() == R$id.restore_continue_retry_btn) {
            if (this.f15886S.getText().equals(getString(R$string.restore_continue))) {
                m22068Z2();
                return;
            } else {
                m22091p2();
                return;
            }
        }
        if (view.getId() == R$id.restore_cancel_ok_btn) {
            try {
                c13029hM78495f = new C13030i().m78495f(3);
            } catch (C9721b e10) {
                C11839m.m70689w("RestoreMainActivity", "queryTag error: " + e10.getMessage());
                c13029hM78495f = null;
            }
            CloudBackupService.getInstance().abortRestore(1001);
            C13452e.m80781L().m80890b();
            RestoreNotification.getInstance().cancelNotification();
            if (this.f15901h0) {
                m22065W2("4");
            }
            if (c13029hM78495f != null && ("myHuawei".equalsIgnoreCase(this.f15902i0) || C12591s1.m75931a().m75938h())) {
                C12515a.m75110o().m75172d(new C3462g(null));
            }
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RecyclerView recyclerView;
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.restore_main);
        m22014A2();
        mo19005p1();
        CloudBackupService.getInstance().unregister(this.f15918t0);
        m22047z2(false);
        C11842p.m70874v1(this, this.f15927z);
        C11842p.m70874v1(this, this.f15868A);
        if (!this.f15908o0 || (recyclerView = this.f15914r0) == null) {
            return;
        }
        recyclerView.setNestedScrollingEnabled(false);
        C0866e c0866e = new C0866e();
        c0866e.setSupportsChangeAnimations(false);
        this.f15914r0.setItemAnimator(c0866e);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            m22045l3(bundle.getBoolean("is_show_launcher_dialog"));
            this.f15908o0 = bundle.getBoolean("isNewBmRecord") || RestoreUtil.isNewBmRecord();
        }
        m22365E1(R$string.from_hisync);
        mo19982C1();
        float fM1195O = C0209d.m1195O(this);
        this.f15912q0 = fM1195O;
        if (fM1195O >= 3.2f) {
            setContentView(R$layout.restore_main_3dot2);
        } else {
            setContentView(R$layout.restore_main);
        }
        m22014A2();
        mo19005p1();
        m22047z2(true);
        m22076h2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m22016D3();
        m22052C3();
        if (this.f15918t0 != null) {
            CBCallBack.getInstance().unregisterCallback(this.f15918t0);
        }
        StopRecoveryDialog stopRecoveryDialog = this.f15888U;
        if (stopRecoveryDialog != null) {
            stopRecoveryDialog.dismiss();
        }
        BackupRecoveryWlanDialog backupRecoveryWlanDialog = this.f15889V;
        if (backupRecoveryWlanDialog != null) {
            backupRecoveryWlanDialog.dismiss();
        }
        RestoreLauncherDialog restoreLauncherDialog = this.f15890W;
        if (restoreLauncherDialog != null) {
            restoreLauncherDialog.dismiss();
        }
        RestoreFailedDialog restoreFailedDialog = this.f15887T;
        if (restoreFailedDialog != null) {
            restoreFailedDialog.dismiss();
        }
        MobileNetTipDialog mobileNetTipDialog = this.f15896c0;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.dismiss();
            this.f15896c0 = null;
        }
        MobileNetTipDialog mobileNetTipDialog2 = this.f15900g0;
        if (mobileNetTipDialog2 != null) {
            mobileNetTipDialog2.dismiss();
        }
        CutOutProgressDialog cutOutProgressDialog = this.f15899f0;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
            this.f15899f0 = null;
        }
        MobileNetTipDialog mobileNetTipDialog3 = this.f15906m0;
        if (mobileNetTipDialog3 == null || !mobileNetTipDialog3.isShowing()) {
            return;
        }
        m22085m2(this.f15906m0.getAppId());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        this.f15902i0 = safeIntent.getStringExtra("moudle");
        this.f15895b0 = safeIntent.getBooleanExtra("is_form_service", false);
        if (this.f15906m0.isShowing()) {
            m22085m2(this.f15906m0.getAppId());
        }
        if (this.f15895b0) {
            this.f15906m0.setAppId(safeIntent.getStringExtra("restore_app"));
            this.f15906m0.show();
        }
        Bundle extras = safeIntent.getExtras();
        if (extras != null) {
            C10343b c10343b = new C10343b(extras);
            boolean zM63682d = c10343b.m63682d("is_form_notification", false);
            this.f15894a0 = zM63682d;
            if (zM63682d && c10343b.m63687i("restore_status", -1) == 6) {
                C11829c.m70612r1(this);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m22078i2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m22033V2();
        m22064U2();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            C11839m.m70686d("RestoreMainActivity", "onSaveInstanceState");
            bundle.putBoolean("is_show_launcher_dialog", m22015D2());
            bundle.putBoolean("isNewBmRecord", this.f15908o0 || RestoreUtil.isNewBmRecord());
        } catch (Exception e10) {
            C11839m.m70687e("RestoreMainActivity", "onSaveInstanceState  fail==" + e10.toString());
        }
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: p2 */
    public final void m22091p2() {
        if (C10782d.m65634a().m65644k(this)) {
            MobileNetTipDialog mobileNetTipDialog = this.f15896c0;
            if (mobileNetTipDialog != null) {
                mobileNetTipDialog.show();
                return;
            }
            return;
        }
        m22094r2(true);
        if (this.f15901h0) {
            m22065W2("3");
        }
    }

    /* renamed from: p3 */
    public final void m22092p3() {
        m22071c3(true);
    }

    /* renamed from: q3 */
    public final void m22093q3(int i10, Boolean bool) throws Resources.NotFoundException {
        if (bool != null && bool.booleanValue()) {
            m22077h3(i10);
        }
        m22069a3(false, false, i10);
        m22087n2(i10);
        CloudBackupService.getInstance().abortRestore(1001);
    }

    /* renamed from: r2 */
    public final void m22094r2(boolean z10) {
        if (!C10782d.m65634a().m65642i(this)) {
            if (z10) {
                this.f15889V.customShow();
            }
        } else {
            C11839m.m70688i("RestoreMainActivity", "doRetryRestore ==" + z10);
            m22074f3();
        }
    }

    /* renamed from: r3 */
    public final void m22095r3(int i10, Boolean bool) throws Resources.NotFoundException {
        if (bool != null && bool.booleanValue()) {
            m22077h3(i10);
        }
        m22069a3(false, true, i10);
    }

    /* renamed from: s2 */
    public final int m22096s2() {
        return new C12526j().m75325A0().getPauseBattery();
    }

    /* renamed from: s3 */
    public final void m22097s3() {
        SpannableString spannableString;
        String string = getString(R$string.cloud_restore_goto_clear_space);
        long jM81078f = C13466f.m81073d().m81078f("restore_local_space_not_enough_size", 0L);
        C11839m.m70688i("RestoreMainActivity", "showLocalSpaceNotEnough localNeedSpace: " + jM81078f);
        this.f15879L.setImageResource(R$drawable.ic_public_error);
        this.f15878K.setVisibility(8);
        this.f15872E.setText(getString(R$string.notification_restore_fail_local_space_tip));
        int iIndexOf = 0;
        this.f15873F.setVisibility(0);
        this.f15873F.setMovementMethod(new C3461f(this, null));
        if (jM81078f > 0) {
            spannableString = new SpannableString(getString(R$string.cloud_restore_need_more_local_space_tip, C0209d.m1232a0(C0223k.m1525h(C0213f.m1377a(), jM81078f, 1000)), string));
            iIndexOf = spannableString.toString().indexOf(string);
        } else {
            spannableString = new SpannableString(string);
        }
        spannableString.setSpan(new C3460e(this), iIndexOf, string.length() + iIndexOf, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        this.f15873F.setText(spannableString);
        this.f15873F.setHighlightColor(getColor(R.color.transparent));
    }

    /* renamed from: t2 */
    public final String m22098t2(boolean z10) {
        return z10 ? getString(R$string.backup_restore_not_completed_can_retry_new) : getString(R$string.backup_restore_not_completed_not_retry_new);
    }

    /* renamed from: t3 */
    public final void m22099t3() throws Resources.NotFoundException {
        m22077h3(1002);
        m22069a3(true, true, 1002);
        this.f15901h0 = C0209d.m1150A1(this);
    }

    /* renamed from: u2 */
    public String m22100u2(String str) {
        return C12590s0.m75742F(this, str);
    }

    /* renamed from: u3 */
    public final void m22101u3(float f10) {
        TextView textView = this.f15926y;
        if (textView == null || this.f15919u == null) {
            return;
        }
        textView.setText(C2783d.m16085H(f10));
        this.f15919u.setProgress((int) f10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m22078i2();
        return false;
    }

    /* renamed from: v2 */
    public final C3460e m22102v2(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C3460e[] c3460eArr = (C3460e[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C3460e.class);
        if (c3460eArr.length > 0) {
            return c3460eArr[0];
        }
        return null;
    }

    /* renamed from: v3 */
    public void m22103v3() {
        this.f15882O.setVisibility(8);
        this.f15881N.setVisibility(0);
    }

    /* renamed from: w2 */
    public final void m22104w2(String str) {
        C11839m.m70686d("RestoreMainActivity", "getSpeed restoreTextBanner = " + this.f15925x.getVisibility() + " speed = " + str);
        if (TextUtils.isEmpty(str)) {
            str = getString(R$string.restore_restoring_data_network_tips);
        }
        if (this.f15907n0) {
            this.f15925x.m24027j(str, 2);
        } else {
            this.f15925x.m24027j(str, 1);
        }
    }

    /* renamed from: w3 */
    public final void m22105w3() {
        C11839m.m70688i("RestoreMainActivity", "showRestoringPausedView.");
        this.f15881N.setVisibility(8);
        this.f15882O.setVisibility(0);
        this.f15874G.setVisibility(8);
        this.f15875H.setVisibility(8);
        this.f15871D.setVisibility(0);
        this.f15927z.setVisibility(8);
        this.f15868A.setVisibility(8);
        this.f15925x.m24030m();
        this.f15873F.setVisibility(8);
        this.f15879L.setImageResource(R$drawable.ic_public_error);
        this.f15892Y = true;
        this.f15872E.setText(getString(R$string.restore_new_pause));
        this.f15884Q.setVisibility(0);
        this.f15885R.setText(getString(R$string.cloudbackup_Cancel));
        this.f15886S.setText(getString(R$string.restore_continue));
        m22079i3();
        if (getResources() == null) {
            C11839m.m70687e("RestoreMainActivity", "showRestoringPausedView resources is null");
            return;
        }
        int pauseCount = RestoreUtil.getPauseCount(0, RestoreProgress.getItemList());
        C11839m.m70688i("RestoreMainActivity", "showRestoringPausedView pauseCount = " + pauseCount);
        if (pauseCount > 0) {
            this.f15878K.setText(getString(R$string.restore_pause_resume_subtitle_new));
            this.f15878K.setVisibility(0);
        } else {
            this.f15878K.setVisibility(8);
        }
        m22063T2(true);
    }

    /* renamed from: x2 */
    public final boolean m22106x2() {
        for (CloudRestoreItem cloudRestoreItem : RestoreProgress.getItemList()) {
            if (cloudRestoreItem.getAppType() == -1) {
                List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
                if (listM29202r == null || listM29202r.isEmpty()) {
                    return false;
                }
                Iterator<CloudRestoreItem> it = listM29202r.iterator();
                while (it.hasNext()) {
                    if ("HWlanucher".equals(it.next().getAppId())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: x3 */
    public final void m22107x3() {
        this.f15878K.setVisibility(8);
        this.f15881N.setVisibility(8);
        this.f15882O.setVisibility(0);
        this.f15874G.setVisibility(0);
        this.f15883P.setVisibility(0);
        boolean z10 = CBAccess.isInPrepare() || (!CBAccess.hasTaskWorking() && 1 == C13452e.m80781L().m80916g0());
        C11839m.m70688i("RestoreMainActivity", "showRestoredDetail view isShowPrepare :" + z10);
        if (z10) {
            this.f15883P.setText(R$string.cloudbackup_prepare_data);
            this.f15921v.setVisibility(0);
            TextView textView = this.f15926y;
            if (textView != null) {
                textView.setVisibility(8);
            }
            m22110z3(true, getString(R$string.restore_ready_restore_prompt));
        } else {
            this.f15883P.setText(R$string.restore_new_restoring_data);
            this.f15921v.setVisibility(8);
            TextView textView2 = this.f15926y;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            m22110z3(false, "");
        }
        this.f15871D.setVisibility(8);
        this.f15875H.setVisibility(8);
        this.f15884Q.setVisibility(8);
        this.f15868A.setVisibility(8);
        this.f15927z.setVisibility(0);
        this.f15869B.setVisibility(0);
        float fM80911f0 = C13452e.m80781L().m80911f0();
        if (!z10) {
            m22101u3(fM80911f0);
        }
        C11839m.m70688i("RestoreMainActivity", "showRestoringView start restore restoreProgress = " + fM80911f0);
        m22089o2();
        this.f15891X = false;
        this.f15892Y = false;
        m22063T2(false);
    }

    /* renamed from: y2 */
    public final void m22108y2(long j10) {
        int iM64257a;
        if (j10 > 0) {
            C13466f.m81073d().m81083k("restore_selected_data_size", j10);
        } else {
            C11839m.m70688i("RestoreMainActivity", "Restore selected data size is 0.");
            j10 = C13466f.m81073d().m81078f("restore_selected_data_size", 0L);
        }
        long j11 = j10 / 1048576;
        C11839m.m70688i("RestoreMainActivity", "Restore selected data size is: " + j11 + "MB");
        C10453b c10453bM75430y0 = new C12526j().m75430y0();
        if (c10453bM75430y0 == null || c10453bM75430y0.m64259a() == null) {
            C11839m.m70688i("RestoreMainActivity", "the restoreExperienceControl is null.");
            iM64257a = 3000;
        } else {
            iM64257a = c10453bM75430y0.m64259a().m64257a();
        }
        C11839m.m70688i("RestoreMainActivity", "Restore restoreDataTooLarge config is: " + iM64257a);
        this.f15907n0 = j11 >= ((long) iM64257a);
    }

    /* renamed from: y3 */
    public final void m22109y3() {
        RestoreNotification.getInstance().cancelNotification();
        this.f15881N.setVisibility(8);
        this.f15882O.setVisibility(0);
        this.f15874G.setVisibility(8);
        this.f15871D.setVisibility(0);
        this.f15925x.m24030m();
        this.f15875H.setVisibility(8);
        this.f15872E.setText(getString(R$string.restore_new_cancel_restore));
        this.f15927z.setVisibility(8);
        this.f15868A.setVisibility(0);
        this.f15873F.setVisibility(8);
        this.f15878K.setVisibility(8);
        this.f15879L.setImageResource(R$drawable.ic_public_error);
        this.f15884Q.setVisibility(8);
        this.f15891X = true;
        m22063T2(true);
    }

    /* renamed from: z3 */
    public final void m22110z3(boolean z10, String str) {
        C11839m.m70686d("RestoreMainActivity", "showTextTip showTextTip = " + z10);
        this.f15923w.setVisibility(z10 ? 0 : 8);
        this.f15925x.setVisibility(z10 ? 8 : 0);
        if (z10) {
            this.f15923w.setText(str);
            this.f15925x.m24030m();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = R$string.restore_restoring_data_network_tips;
        arrayList.add(getString(i10));
        if (this.f15907n0) {
            arrayList.add(getString(R$string.restore_restoring_large_amount_data_tips));
        }
        arrayList.add(getString(i10));
        if (this.f15907n0) {
            arrayList.add(getString(R$string.restore_restoring_large_amount_data_tips));
        }
        this.f15925x.setDataIfNotNull(arrayList);
    }
}
