package com.huawei.android.hicloud.p088ui.activity;

import ae.C0124f2;
import ae.C0128g2;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import ca.C1399b;
import com.huawei.android.hicloud.cloudspace.bean.BackupCacheInfo;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback;
import com.huawei.android.hicloud.cloudspace.manager.StorageManageOtherItem;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.fragment.UniformStorageBarFragment;
import com.huawei.android.hicloud.p088ui.uiadapter.NoScrollLinearLayoutManager;
import com.huawei.android.hicloud.p088ui.uiextend.CurrentOnTouchListener;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerCardLayout;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerCardViewLayout;
import com.huawei.android.hicloud.p088ui.uiextend.TextLinkBar;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.UnspportPrivateSpaceDialog;
import com.huawei.android.hicloud.p088ui.uiutil.IManageClickControl;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.hicloud.task.storage.C3104a;
import com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyDetailInfoRetBody;
import com.huawei.hicloud.base.bean.FamilyShareInfoAndDetailResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.SpaceFormatSplit;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.base.view.widget.HightLightNumView;
import com.huawei.hicloud.bean.DataTypeNum;
import com.huawei.hicloud.bean.DriveConfigQuotaCountData;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.DriveModuleConfigManager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.notification.p106db.bean.SyncConfigDataTypesCountData;
import com.huawei.hicloud.notification.syncconfig.StructureNumRet;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import fk.C9721b;
import ge.C9908c;
import gl.C9961b;
import gl.C9964e;
import gp.C10028c;
import hu.C10343b;
import huawei.android.widget.HwTextView;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import je.C10799m;
import je.C10810x;
import jp.C10906b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0229n;
import p015ak.C0241z;
import p035bk.C1248a;
import p037bp.C1270a;
import p054cj.C1442a;
import p232dp.InterfaceC9282a;
import p252e9.C9424a;
import p292fn.C9733f;
import p336he.C10155f;
import p387j7.C10718a;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11079e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p651t8.C12997e;
import p651t8.C12998f;
import p664u0.C13108a;
import p674ub.C13149f;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13227f;
import p684un.C13229h;
import p684un.C13230i;
import p703v8.C13368e;
import p703v8.C13380q;
import p709vj.C13452e;
import p732w8.AsyncTaskC13562m;
import p732w8.C13561l;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p815ym.AbstractC14026a;
import p850zo.InterfaceC14351b;
import sk.C12809f;
import tl.C13036o;

/* loaded from: classes3.dex */
public class HisyncSpaceDetailActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener, CloudStorageCallback, InterfaceC14351b, IManageClickControl {

    /* renamed from: A */
    public View f15035A;

    /* renamed from: B */
    public TextLinkBar f15037B;

    /* renamed from: B0 */
    public C0128g2 f15038B0;

    /* renamed from: C */
    public C10906b f15039C;

    /* renamed from: D */
    public View f15041D;

    /* renamed from: D0 */
    public FamilyShareInfoAndDetailResult f15042D0;

    /* renamed from: E */
    public View f15043E;

    /* renamed from: E0 */
    public FamilyDetailInfoResult f15044E0;

    /* renamed from: F */
    public View f15045F;

    /* renamed from: I0 */
    public TextView f15052I0;

    /* renamed from: J */
    public StorageManagerCardViewLayout f15053J;

    /* renamed from: J0 */
    public View f15054J0;

    /* renamed from: K */
    public NotchFitRelativeLayout f15055K;

    /* renamed from: K0 */
    public NotchFitRelativeLayout f15056K0;

    /* renamed from: L */
    public StorageManagerCardViewLayout f15057L;

    /* renamed from: L0 */
    public NotchFitRelativeLayout f15058L0;

    /* renamed from: M */
    public ImageView f15059M;

    /* renamed from: M0 */
    public StorageManagerCardLayout f15060M0;

    /* renamed from: N */
    public TextView f15061N;

    /* renamed from: N0 */
    public NotchFitRelativeLayout f15062N0;

    /* renamed from: O */
    public RelativeLayout f15063O;

    /* renamed from: O0 */
    public StorageManagerCardLayout f15064O0;

    /* renamed from: P */
    public TextView f15065P;

    /* renamed from: P0 */
    public NotchFitRelativeLayout f15066P0;

    /* renamed from: Q */
    public RecyclerView f15067Q;

    /* renamed from: Q0 */
    public StorageManagerCardLayout f15068Q0;

    /* renamed from: R */
    public HightLightNumView f15069R;

    /* renamed from: R0 */
    public NotchFitRelativeLayout f15070R0;

    /* renamed from: S */
    public LinearLayout f15071S;

    /* renamed from: S0 */
    public StorageManagerCardLayout f15072S0;

    /* renamed from: T */
    public RelativeLayout f15073T;

    /* renamed from: U */
    public ImageView f15075U;

    /* renamed from: V */
    public StorageManagerCardViewLayout f15077V;

    /* renamed from: X0 */
    public UserDataStateInfo f15082X0;

    /* renamed from: Y0 */
    public TextView f15084Y0;

    /* renamed from: Z0 */
    public Handler f15086Z0;

    /* renamed from: a1 */
    public boolean f15088a1;

    /* renamed from: b0 */
    public String f15089b0;

    /* renamed from: b1 */
    public C3328d f15090b1;

    /* renamed from: c0 */
    public String f15091c0;

    /* renamed from: c1 */
    public BroadcastReceiver f15092c1;

    /* renamed from: d0 */
    public String f15093d0;

    /* renamed from: d1 */
    public boolean f15094d1;

    /* renamed from: e0 */
    public C13380q f15095e0;

    /* renamed from: e1 */
    public boolean f15096e1;

    /* renamed from: f0 */
    public ProgressBar f15097f0;

    /* renamed from: f1 */
    public Messenger f15098f1;

    /* renamed from: g0 */
    public UniformStorageBarFragment f15099g0;

    /* renamed from: h0 */
    public HwTextView f15100h0;

    /* renamed from: i0 */
    public HwTextView f15101i0;

    /* renamed from: j0 */
    public HwTextView f15102j0;

    /* renamed from: l0 */
    public StorageReceiver f15104l0;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15108p;

    /* renamed from: q */
    public NotchFitRelativeLayout f15110q;

    /* renamed from: r */
    public NotchFitRelativeLayout f15112r;

    /* renamed from: s */
    public NotchFitLinearLayout f15114s;

    /* renamed from: t */
    public NotchFitRelativeLayout f15116t;

    /* renamed from: t0 */
    public C10718a f15117t0;

    /* renamed from: u */
    public StorageManagerCardViewLayout f15118u;

    /* renamed from: v */
    public NotchFitRelativeLayout f15120v;

    /* renamed from: v0 */
    public String f15121v0;

    /* renamed from: w */
    public View f15122w;

    /* renamed from: w0 */
    public String f15123w0;

    /* renamed from: x */
    public NotchFitRelativeLayout f15124x;

    /* renamed from: y */
    public NotchFitRelativeLayout f15126y;

    /* renamed from: z */
    public NotchFitRelativeLayout f15128z;

    /* renamed from: G */
    public View f15047G = null;

    /* renamed from: H */
    public View f15049H = null;

    /* renamed from: I */
    public ScrollDisabledListView f15051I = null;

    /* renamed from: W */
    public C0124f2 f15079W = null;

    /* renamed from: X */
    public boolean f15081X = true;

    /* renamed from: Y */
    public boolean f15083Y = false;

    /* renamed from: Z */
    public boolean f15085Z = false;

    /* renamed from: a0 */
    public boolean f15087a0 = false;

    /* renamed from: k0 */
    public C13149f f15103k0 = new C13149f();

    /* renamed from: m0 */
    public C3329e f15105m0 = new C3329e(null);

    /* renamed from: n0 */
    public C3330f f15106n0 = new C3330f(null);

    /* renamed from: o0 */
    public ArrayList<C13380q> f15107o0 = new ArrayList<>();

    /* renamed from: p0 */
    public ArrayList<C13380q> f15109p0 = new ArrayList<>();

    /* renamed from: q0 */
    public ArrayList<String> f15111q0 = new ArrayList<>();

    /* renamed from: r0 */
    public ArrayList<String> f15113r0 = new ArrayList<>();

    /* renamed from: s0 */
    public ArrayList<C13380q> f15115s0 = new ArrayList<>();

    /* renamed from: u0 */
    public UnspportPrivateSpaceDialog f15119u0 = null;

    /* renamed from: x0 */
    public int f15125x0 = -1;

    /* renamed from: y0 */
    public FamilyShareInfoResult f15127y0 = new FamilyShareInfoResult();

    /* renamed from: z0 */
    public C13380q f15129z0 = new C13380q();

    /* renamed from: A0 */
    public StorageManageOtherItem f15036A0 = new StorageManageOtherItem();

    /* renamed from: C0 */
    public boolean f15040C0 = true;

    /* renamed from: F0 */
    public List<String> f15046F0 = new ArrayList();

    /* renamed from: G0 */
    public ArrayList<StorageManagerCardViewLayout> f15048G0 = new ArrayList<>();

    /* renamed from: H0 */
    public RecommendCardReport f15050H0 = new RecommendCardReport();

    /* renamed from: T0 */
    public boolean f15074T0 = false;

    /* renamed from: U0 */
    public boolean f15076U0 = false;

    /* renamed from: V0 */
    public boolean f15078V0 = false;

    /* renamed from: W0 */
    public ArrayList<StorageManagerCardLayout> f15080W0 = new ArrayList<>();

    public class StorageReceiver extends BroadcastReceiver {
        public StorageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
            C10343b c10343b;
            if (intent == null) {
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            try {
                c10343b = new C10343b(hiCloudSafeIntent.getExtras());
            } catch (RuntimeException e10) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "StorageReceiver:" + e10.toString());
                c10343b = null;
            }
            if ("com.huawei.hicloud.QUERY_STORAGE_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "receive STORAGE_QUERY_FINISHED_ACTION");
                if (c10343b != null) {
                    int iM63686h = c10343b.m63686h("result");
                    C11839m.m70688i("HisyncSpaceDetailActivity", "STORAGE_QUERY_FINISHED_ACTION result=" + iM63686h);
                    if (iM63686h == 1) {
                        HisyncSpaceDetailActivity.this.mo15483q();
                        return;
                    } else {
                        HisyncSpaceDetailActivity.this.m20811P3();
                        return;
                    }
                }
                return;
            }
            if ("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "receive QUERY_QUOTA_INFO_FINISHED_ACTION");
                if (c10343b != null) {
                    int iM63686h2 = c10343b.m63686h("result");
                    C11839m.m70688i("HisyncSpaceDetailActivity", "STORAGE_QUERY_FINISHED_ACTION result=" + iM63686h2);
                    if (iM63686h2 != 1) {
                        HisyncSpaceDetailActivity.this.f15099g0.m24360r();
                        return;
                    }
                    HisyncSpaceDetailActivity.this.f15099g0.mo15483q();
                    HisyncSpaceDetailActivity.this.m20890u4();
                    HisyncSpaceDetailActivity.this.m20873n4();
                    HisyncSpaceDetailActivity.this.m20876o4();
                    return;
                }
                return;
            }
            if ("com.huawei.hicloud.QUOTA_INFO_OM_CONFIG_DOWNLOAD_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                HisyncSpaceDetailActivity.this.m20715N4();
                return;
            }
            if ("com.huawei.hicloud.DELETE_STORAGE_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                HisyncSpaceDetailActivity.this.m20856g3(hiCloudSafeIntent.getStringExtra("moduleName"));
                return;
            }
            if ("com.huawei.cloud.pay.action.updatespace".equals(hiCloudSafeIntent.getAction())) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "STORAGE_PAY_UPDATE_ACTION");
                HisyncSpaceDetailActivity.this.f15099g0.m24354j();
                return;
            }
            if (!"com.huawei.cg.action.SPACE_DELETED_CHANGED".equals(hiCloudSafeIntent.getAction())) {
                if ("com.huawei.hicloud.BACKUP_STORAGE_QUERY_SUCCESS".equals(hiCloudSafeIntent.getAction())) {
                    C11839m.m70688i("HisyncSpaceDetailActivity", "update backup storage success");
                    HisyncSpaceDetailActivity.this.m20760r3();
                    return;
                }
                return;
            }
            C11839m.m70688i("HisyncSpaceDetailActivity", "gallery change,updata size");
            HisyncSpaceDetailActivity.this.f15083Y = false;
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
            C11839m.m70688i("HisyncSpaceDetailActivity", "refresh space clean cloud after clean");
            HisyncSpaceDetailActivity.this.m20785F4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$a */
    public class HandlerC3325a extends Handler {
        public HandlerC3325a() {
        }

        /* renamed from: b */
        public final /* synthetic */ void m20905b() {
            HisyncSpaceDetailActivity hisyncSpaceDetailActivity = HisyncSpaceDetailActivity.this;
            Toast.makeText(hisyncSpaceDetailActivity, hisyncSpaceDetailActivity.getString(R$string.cloud_space_clean_toast), 0).show();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (i10 == 1031) {
                HisyncSpaceDetailActivity.this.m20822T3(message);
                return;
            }
            if (i10 == 1045) {
                HisyncSpaceDetailActivity.this.m20852d4((StructureNumRet) message.obj);
                return;
            }
            if (i10 == 2013) {
                HisyncSpaceDetailActivity.this.m20738f3(message);
                return;
            }
            if (i10 == 2018) {
                HisyncSpaceDetailActivity.this.m20736e3();
                return;
            }
            if (i10 == 1050) {
                HisyncSpaceDetailActivity.this.m20855e5(message);
                return;
            }
            if (i10 == 7050) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "textLink handler is fail");
                if (HisyncSpaceDetailActivity.this.f15037B != null) {
                    HisyncSpaceDetailActivity.this.f15037B.setVisibility(8);
                    return;
                }
                return;
            }
            if (i10 == 7051) {
                Object obj = message.obj;
                if (obj instanceof C10906b) {
                    HisyncSpaceDetailActivity.this.f15039C = (C10906b) obj;
                    HisyncSpaceDetailActivity.this.m20766v3();
                    return;
                }
                return;
            }
            if (i10 != 1051) {
                if (i10 == 7038 && HisyncSpaceDetailActivity.this.f15099g0 != null && HisyncSpaceDetailActivity.this.f15099g0.isAdded()) {
                    HisyncSpaceDetailActivity.this.f15099g0.m24363w();
                    return;
                }
                return;
            }
            C11839m.m70686d("HisyncSpaceDetailActivity", "get space clean data msg");
            HisyncSpaceDetailActivity.this.f15078V0 = false;
            int i11 = message.arg1;
            if (i11 == 1) {
                HisyncSpaceDetailActivity.this.f15074T0 = true;
                HisyncSpaceDetailActivity hisyncSpaceDetailActivity = HisyncSpaceDetailActivity.this;
                hisyncSpaceDetailActivity.m20877o5(hisyncSpaceDetailActivity.m20869m3());
                if (HisyncSpaceDetailActivity.this.f15076U0) {
                    HisyncSpaceDetailActivity.this.f15076U0 = false;
                    HisyncSpaceDetailActivity.this.m20872n3();
                    return;
                }
                return;
            }
            if (i11 == -1) {
                HisyncSpaceDetailActivity.this.m20871m5();
                return;
            }
            HisyncSpaceDetailActivity.this.f15074T0 = false;
            HisyncSpaceDetailActivity.this.m20874n5();
            if (HisyncSpaceDetailActivity.this.f15076U0) {
                HisyncSpaceDetailActivity.this.f15076U0 = false;
                C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.r5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17715a.m20905b();
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$b */
    public class C3326b extends AbstractC12367d {
        public C3326b() {
        }

        public /* synthetic */ void lambda$call$0() {
            boolean z10 = false;
            HisyncSpaceDetailActivity.this.f15096e1 = C13452e.m80781L().m80939l0() > 0;
            NotchFitRelativeLayout notchFitRelativeLayout = HisyncSpaceDetailActivity.this.f15062N0;
            if (!HisyncSpaceDetailActivity.this.f15094d1 && HisyncSpaceDetailActivity.this.f15096e1) {
                z10 = true;
            }
            C12809f.m76843p(notchFitRelativeLayout, z10);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Pair<List<CBSDevice>, Long> pairM61806t = C9961b.m61788i().m61806t("SilenceDevice");
            List list = (List) pairM61806t.first;
            long jLongValue = ((Long) pairM61806t.second).longValue();
            int size = AbstractC14026a.m84159a(list) ? 0 : list.size();
            C13452e.m80781L().m80832M2(jLongValue > 0 ? size : 0);
            C13452e.m80781L().m80828L2(list != null ? C12312h0.m74027b().m74028c() : 0L);
            C11839m.m70688i("HisyncSpaceDetailActivity", "querySilenceDevice exit, number: " + size);
            HisyncSpaceDetailActivity.this.f15086Z0.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.s5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17728a.lambda$call$0();
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$c */
    public class C3327c extends BroadcastReceiver {
        public C3327c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C11839m.m70688i("HisyncSpaceDetailActivity", " registerFamilySharingReceiver onReceive ");
            try {
                if (intent == null) {
                    C11839m.m70687e("HisyncSpaceDetailActivity", "joinFamilySharingReceiver intent null");
                    return;
                }
                String action = intent.getAction();
                if (FamilyShareConstants.Report.CLICK_JOIN_BUTTON.equals(action) || FamilyShareConstants.Report.CLICK_DISABLE_BUTTON.equals(action)) {
                    HisyncSpaceDetailActivity.this.m20739f4();
                }
            } catch (Exception e10) {
                C11839m.m70687e("HisyncSpaceDetailActivity", "joinFamilySharingReceiver onReceive exception:" + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$d */
    public class C3328d implements GetSpaceOptDataTask.Callback {

        /* renamed from: a */
        public Handler f15134a;

        public C3328d(Handler handler) {
            this.f15134a = handler;
        }

        @Override // com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask.Callback
        /* renamed from: a */
        public void mo18457a() {
            C11839m.m70688i("HisyncSpaceDetailActivity", "GetSpaceOptData getSpaceDataTaskStart");
            HisyncSpaceDetailActivity.this.m20823T4(this.f15134a, 1051, -1, false);
        }

        @Override // com.huawei.android.hicloud.task.storage.GetSpaceOptDataTask.Callback
        /* renamed from: b */
        public void mo18458b(int i10) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "GetSpaceOptData getSpaceDataTaskEnd");
            if (HisyncSpaceDetailActivity.this.isFinishing() || HisyncSpaceDetailActivity.this.isDestroyed()) {
                C11839m.m70689w("HisyncSpaceDetailActivity", "HisyncSpaceDetailActivity is null");
            } else {
                HisyncSpaceDetailActivity.this.m20823T4(this.f15134a, 1051, i10, false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$e */
    public static class C3329e implements Comparator, Serializable {
        private static final long serialVersionUID = -4464318529487236597L;

        public C3329e() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((C13380q) obj).m80330a() < ((C13380q) obj2).m80330a() ? 1 : -1;
        }

        public /* synthetic */ C3329e(HandlerC3325a handlerC3325a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncSpaceDetailActivity$f */
    public static class C3330f implements Comparator, Serializable {
        private static final long serialVersionUID = -6362186735028199291L;

        public C3330f() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((C13380q) obj).m80336g() < ((C13380q) obj2).m80336g() ? 1 : -1;
        }

        public /* synthetic */ C3330f(HandlerC3325a handlerC3325a) {
            this();
        }
    }

    public HisyncSpaceDetailActivity() {
        HandlerC3325a handlerC3325a = new HandlerC3325a();
        this.f15086Z0 = handlerC3325a;
        this.f15088a1 = false;
        this.f15090b1 = new C3328d(handlerC3325a);
        this.f15094d1 = false;
        this.f15096e1 = false;
        this.f15098f1 = new Messenger(this.f15086Z0);
    }

    /* renamed from: H3 */
    public static /* synthetic */ Integer m20711H3() throws Exception {
        try {
            int iM1685c = C0241z.m1685c(C10155f.m63283g("bs.userdata.remain.dwnldDays"));
            C11839m.m70688i("HisyncSpaceDetailActivity", "getParamValue key = remainDays, value = " + iM1685c);
            return Integer.valueOf(iM1685c);
        } catch (Exception e10) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "getParamValue failed, error = " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: K4 */
    private void m20712K4() {
        if ("campaign_center".equals(this.f15089b0)) {
            C12998f.m78034R().m78136y(C12997e.m78019l(), true, null);
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("gradeCode", C13452e.m80781L().m80790C());
            C13227f.m79492i1().m79567R("ENTER_CLOUD_ST0RAGE_MANAGEMENT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "ENTER_CLOUD_ST0RAGE_MANAGEMENT", linkedHashMapM79497A);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(""), "HisyncSpaceDetailActivity", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("010_200");
            C13622a.m81969o(this, c11060cM66626a, linkedHashMapM79497A);
        }
    }

    /* renamed from: N4 */
    public void m20715N4() {
        UniformStorageBarFragment uniformStorageBarFragment = this.f15099g0;
        if (uniformStorageBarFragment != null) {
            uniformStorageBarFragment.m24362t();
        }
        C13368e.m80184F().m80250o0();
    }

    /* renamed from: P2 */
    private List<FamilyDetailInfo> m20718P2(List<FamilyDetailInfo> list) {
        Iterator<FamilyDetailInfo> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(C13452e.m80781L().m80971t0(), String.valueOf(it.next().getUid()))) {
                it.remove();
            }
        }
        return list;
    }

    /* renamed from: Q3 */
    private void m20720Q3() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 2);
        intent.putExtras(bundle);
        intent.setClass(this, CloudSpaceShareActivity.class);
        startActivityForResult(intent, 10029);
    }

    /* renamed from: b4 */
    private void m20732b4() {
        C11839m.m70688i("HisyncSpaceDetailActivity", "querySilenceDevice enter");
        boolean zEquals = TextUtils.equals(C13452e.m80781L().m80790C(), "N");
        C11839m.m70688i("HisyncSpaceDetailActivity", "querySilenceDevice, isOldFreeUser: " + zEquals);
        boolean z10 = false;
        if (!zEquals) {
            C13452e.m80781L().m80828L2(0L);
            this.f15096e1 = false;
            C12809f.m76843p(this.f15062N0, false);
        } else {
            if (C12312h0.m74027b().m74028c() - C13452e.m80781L().m80935k0() >= 259200000) {
                C12515a.m75110o().m75172d(new C3326b());
                return;
            }
            C11839m.m70688i("HisyncSpaceDetailActivity", "querySilenceDevice, not allowed to refresh again within 30 minutes");
            boolean z11 = C13452e.m80781L().m80939l0() > 0;
            this.f15096e1 = z11;
            NotchFitRelativeLayout notchFitRelativeLayout = this.f15062N0;
            if (!this.f15094d1 && z11) {
                z10 = true;
            }
            C12809f.m76843p(notchFitRelativeLayout, z10);
        }
    }

    /* renamed from: e3 */
    public void m20736e3() {
        List<String> list = this.f15046F0;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            if (TextUtils.isEmpty(str)) {
                arrayList.add(C1248a.m7477h(getResources(), R$drawable.img_defaultavatar_list_gray));
            } else {
                Bitmap bitmapM70501B = C11829c.m70501B(getFilesDir() + FamilyShareConstants.FAMILY_IMAGE_FILE_PATH + str.hashCode());
                if (bitmapM70501B == null) {
                    arrayList.add(C1248a.m7477h(getResources(), R$drawable.img_defaultavatar_list_gray));
                } else {
                    arrayList.add(C11842p.m70860s(bitmapM70501B));
                }
            }
        }
        this.f15072S0.setIconBitmapList(arrayList);
    }

    /* renamed from: f3 */
    public void m20738f3(Message message) throws Resources.NotFoundException {
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = (FamilyShareInfoAndDetailResult) message.obj;
        this.f15042D0 = familyShareInfoAndDetailResult;
        if (familyShareInfoAndDetailResult == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "space share info and detail is null");
            return;
        }
        this.f15044E0 = familyShareInfoAndDetailResult.getFamilyDetailInfoResult();
        FamilyShareInfoResult familyShareInfoResult = this.f15042D0.getFamilyShareInfoResult();
        this.f15127y0 = familyShareInfoResult;
        if (familyShareInfoResult == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "getshareinfo failed " + message.what);
            return;
        }
        if (familyShareInfoResult.getRetCode() == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "getshareinfo success");
            m20890u4();
        } else {
            C11839m.m70688i("HisyncSpaceDetailActivity", "getshareinfo failed " + this.f15127y0.getRetCode());
        }
    }

    /* renamed from: f4 */
    public void m20739f4() {
        C11839m.m70688i("HisyncSpaceDetailActivity", "queryUserDataState");
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.activity.q5
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                this.f17709a.m20792I3(userDataStateInfo);
            }
        }, true, arrayList, "SpaceDetail"), false);
    }

    /* renamed from: f5 */
    private void m20740f5() {
        this.f15043E.setVisibility(0);
        this.f15041D.setVisibility(8);
        this.f15045F.setVisibility(8);
    }

    /* renamed from: g5 */
    private void m20742g5() {
        this.f15043E.setVisibility(8);
        this.f15041D.setVisibility(0);
        this.f15045F.setVisibility(8);
    }

    /* renamed from: h3 */
    private void m20744h3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58459v(this);
        }
    }

    /* renamed from: h5 */
    private void m20745h5() {
        this.f15043E.setVisibility(8);
        this.f15045F.setVisibility(0);
        this.f15041D.setVisibility(8);
    }

    /* renamed from: j3 */
    private void m20748j3(List<FamilyDetailInfo> list) {
        if (list == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "familydetailinfo is null");
            return;
        }
        this.f15046F0.clear();
        for (int i10 = 0; i10 < list.size(); i10++) {
            FamilyDetailInfo familyDetailInfo = list.get(i10);
            String imageURL = familyDetailInfo != null ? familyDetailInfo.getImageURL() : "";
            if (TextUtils.isEmpty(imageURL)) {
                this.f15046F0.add("");
            } else {
                this.f15046F0.add(imageURL);
            }
        }
        if (this.f15046F0.size() > 0) {
            m20851d3(this.f15046F0);
        }
    }

    /* renamed from: j5 */
    private void m20749j5() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58465y(this, true, 0);
        }
    }

    /* renamed from: k3 */
    private void m20751k3() {
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshFamilyShareInfoAndDetail");
        AsyncTaskC13562m asyncTaskC13562mM81514d = AsyncTaskC13562m.m81514d(this.f15086Z0);
        if (AsyncTask.Status.RUNNING.equals(asyncTaskC13562mM81514d.getStatus())) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshFamilyShareInfoAndDetail task is running.");
        } else {
            asyncTaskC13562mM81514d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: p3 */
    private void m20757p3() {
        if (this.f15104l0 == null) {
            this.f15104l0 = new StorageReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.QUERY_STORAGE_FINISHED");
            intentFilter.addAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
            intentFilter.addAction("com.huawei.cloud.pay.action.updatespace");
            intentFilter.addAction("com.huawei.hicloud.QUOTA_INFO_OM_CONFIG_DOWNLOAD_FINISHED");
            intentFilter.addAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
            intentFilter.addAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
            intentFilter.addAction("com.huawei.hicloud.BACKUP_STORAGE_QUERY_SUCCESS");
            C13108a.m78878b(this).m78880c(this.f15104l0, intentFilter);
        }
    }

    /* renamed from: r3 */
    public void m20760r3() throws Resources.NotFoundException {
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        if (C11829c.m70626w0()) {
            m20751k3();
        } else {
            C11839m.m70688i("HisyncSpaceDetailActivity", "spaceshare enable false");
        }
        m20870m4(storageInfoM80226P.getBackupCacheInfo());
        m20903z4(storageInfoM80226P);
        m20873n4();
        m20900y4();
        m20790H4();
        C2783d.m16191y0(this.f15050H0, getIntent());
    }

    /* renamed from: r5 */
    private void m20761r5() {
        if (this.f15104l0 != null) {
            C13108a.m78878b(this).m78883f(this.f15104l0);
        }
    }

    /* renamed from: s4 */
    private void m20763s4(List<FamilyDetailInfo> list) throws Resources.NotFoundException {
        if (list == null) {
            m20861i5(false);
            this.f15072S0.hideStorageManageCardSubTitle();
            this.f15072S0.hideSubDataListView();
            return;
        }
        List<FamilyDetailInfo> listM20718P2 = m20718P2(list);
        int size = listM20718P2.size();
        if (size <= 0) {
            m20861i5(false);
            this.f15072S0.hideStorageManageCardSubTitle();
            this.f15072S0.hideSubDataListView();
            return;
        }
        m20861i5(true);
        Resources resources = getResources();
        if (resources != null) {
            this.f15072S0.setStorageManageCardNumber(resources.getQuantityString(R$plurals.family_member_count, size, Integer.valueOf(size)), size);
        }
        this.f15072S0.hideStorageManageCardSubTitle();
        m20748j3(listM20718P2);
    }

    /* renamed from: t4 */
    private void m20765t4() {
        long jM80213E = C13368e.m80184F().m80213E();
        C11839m.m70686d("HisyncSpaceDetailActivity", "familySize:" + jM80213E);
        if (jM80213E > 0) {
            String strM1525h = C0223k.m1525h(this, jM80213E, 1024);
            StorageManagerCardLayout storageManagerCardLayout = this.f15072S0;
            if (storageManagerCardLayout != null) {
                storageManagerCardLayout.hideLoading();
                this.f15072S0.hideRedImg();
                this.f15072S0.setArrowText(strM1525h);
                return;
            }
            return;
        }
        if (this.f15072S0 != null) {
            FamilyShareInfoResult familyShareInfoResult = this.f15127y0;
            if (familyShareInfoResult == null || familyShareInfoResult.getSpaceShareEnable() != 0) {
                this.f15072S0.hideLoading();
                this.f15072S0.hideRedImg();
                this.f15072S0.setArrowText("");
            } else {
                if (this.f15127y0.getSpaceShareOwner() != -1) {
                    this.f15072S0.hideLoading();
                    this.f15072S0.hideRedImg();
                    this.f15072S0.setArrowText(getString(R$string.not_join));
                    this.f15072S0.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
                    return;
                }
                this.f15072S0.hideLoading();
                this.f15072S0.hideRedImg();
                this.f15072S0.setArrowText(getString(R$string.settings_hicloud_disabled));
                this.f15072S0.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
            }
        }
    }

    /* renamed from: v3 */
    public void m20766v3() {
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "initTextLinkView isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15037B, false);
        } else {
            this.f15037B.setEntrance("cloudStorageMgr");
            this.f15037B.showContent(this.f15039C);
            C11839m.m70688i("HisyncSpaceDetailActivity", "initTextLinkView success");
        }
    }

    /* renamed from: w3 */
    private void m20767w3() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m20888u2();
        this.f15108p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.nrl_usage_details);
        this.f15058L0 = notchFitRelativeLayout;
        C12809f.m76843p(notchFitRelativeLayout, this.f15094d1);
        this.f15110q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.list_show_region);
        this.f15112r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_family_share);
        this.f15116t = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_cloud_collection);
        StorageManagerCardViewLayout storageManagerCardViewLayout = (StorageManagerCardViewLayout) C12809f.m76829b(this, R$id.cloud_collection_item);
        this.f15118u = storageManagerCardViewLayout;
        storageManagerCardViewLayout.setOnClickListener(this);
        NotchFitRelativeLayout notchFitRelativeLayout2 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_upgrading_cloud);
        this.f15056K0 = notchFitRelativeLayout2;
        C12809f.m76843p(notchFitRelativeLayout2, !this.f15094d1);
        StorageManagerCardLayout storageManagerCardLayout = (StorageManagerCardLayout) C12809f.m76829b(this, R$id.upgrading_cloud_item);
        this.f15060M0 = storageManagerCardLayout;
        C12809f.m76843p(storageManagerCardLayout, !this.f15094d1);
        this.f15066P0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_space_opt_cloud);
        this.f15062N0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_expired_backup_records);
        StorageManagerCardLayout storageManagerCardLayout2 = (StorageManagerCardLayout) C12809f.m76829b(this, R$id.expired_backup_records_item);
        this.f15064O0 = storageManagerCardLayout2;
        storageManagerCardLayout2.hideStorageManageCardSize();
        if (C10028c.m62182c0().m62257P()) {
            this.f15064O0.showExpiredBackupRecordsRedImg();
        } else {
            this.f15064O0.hideExpiredBackupRecordsRedImg();
        }
        this.f15068Q0 = (StorageManagerCardLayout) C12809f.m76829b(this, R$id.space_opt_cloud_item);
        this.f15070R0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_family_share_cloud);
        this.f15072S0 = (StorageManagerCardLayout) C12809f.m76829b(this, R$id.family_share_cloud_item);
        this.f15060M0.setOnClickListener(this);
        this.f15064O0.setOnClickListener(this);
        this.f15068Q0.setOnClickListener(this);
        this.f15072S0.setOnClickListener(this);
        StorageManagerCardLayout storageManagerCardLayout3 = this.f15072S0;
        storageManagerCardLayout3.parentClick(storageManagerCardLayout3);
        StorageManagerCardLayout storageManagerCardLayout4 = this.f15072S0;
        storageManagerCardLayout4.parentClickBelow(storageManagerCardLayout4);
        this.f15059M = (ImageView) C12809f.m76829b(this, R$id.manage_list_item_icon);
        this.f15061N = (TextView) C12809f.m76829b(this, R$id.manage_list_item_name);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.manage_list_item_number_frame);
        this.f15063O = relativeLayout;
        relativeLayout.setVisibility(8);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.manage_list_item_number);
        this.f15065P = textView;
        textView.setVisibility(8);
        this.f15063O.setOnClickListener(this);
        this.f15067Q = (RecyclerView) C12809f.m76829b(this, R$id.manage_list_icon_list);
        m20882q5(this);
        this.f15069R = (HightLightNumView) C12809f.m76829b(this, R$id.manage_list_size);
        this.f15071S = (LinearLayout) C12809f.m76829b(this, R$id.manage_list_divider);
        this.f15073T = (RelativeLayout) C12809f.m76829b(this, R$id.manage_list_icon_list_frame);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.manage_list_control);
        this.f15075U = imageView;
        imageView.setVisibility(8);
        NotchFitRelativeLayout notchFitRelativeLayout3 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_other_app);
        this.f15120v = notchFitRelativeLayout3;
        C12809f.m76843p(notchFitRelativeLayout3, !this.f15094d1);
        this.f15122w = C12809f.m76829b(this, R$id.storage_bar_item_layout);
        this.f15124x = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_list_progress);
        this.f15126y = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.membership_service_data_layout);
        this.f15128z = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.not_fit_tips_help_layout);
        this.f15035A = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f15051I = (ScrollDisabledListView) C12809f.m76829b(this, R$id.manage_data_list);
        this.f15041D = C12809f.m76829b(this, R$id.storage_manage_main_layout);
        this.f15043E = C12809f.m76829b(this, R$id.layout_loading);
        this.f15045F = C12809f.m76829b(this, R$id.layout_nodata);
        this.f15055K = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_cloud_backup);
        StorageManagerCardViewLayout storageManagerCardViewLayout2 = (StorageManagerCardViewLayout) C12809f.m76829b(this, R$id.cloud_backup_item);
        this.f15053J = storageManagerCardViewLayout2;
        storageManagerCardViewLayout2.parentClick(storageManagerCardViewLayout2);
        StorageManagerCardViewLayout storageManagerCardViewLayout3 = (StorageManagerCardViewLayout) C12809f.m76829b(this, R$id.family_share_item);
        this.f15057L = storageManagerCardViewLayout3;
        storageManagerCardViewLayout3.setOnClickListener(this);
        StorageManagerCardViewLayout storageManagerCardViewLayout4 = this.f15057L;
        storageManagerCardViewLayout4.parentClick(storageManagerCardViewLayout4);
        StorageManagerCardViewLayout storageManagerCardViewLayout5 = (StorageManagerCardViewLayout) C12809f.m76829b(this, R$id.other_item);
        this.f15077V = storageManagerCardViewLayout5;
        storageManagerCardViewLayout5.setOnClickListener(this);
        StorageManagerCardViewLayout storageManagerCardViewLayout6 = this.f15077V;
        storageManagerCardViewLayout6.parentClick(storageManagerCardViewLayout6);
        HwTextView hwTextViewM76829b = C12809f.m76829b(this, R$id.text_manage_hicloud);
        this.f15100h0 = hwTextViewM76829b;
        hwTextViewM76829b.setOnClickListener(this);
        HwTextView hwTextViewM76829b2 = C12809f.m76829b(this, R$id.text_free_up_hicloud_space);
        this.f15101i0 = hwTextViewM76829b2;
        hwTextViewM76829b2.setOnClickListener(this);
        HwTextView hwTextViewM76829b3 = C12809f.m76829b(this, R$id.text_delete_backup_data);
        this.f15102j0 = hwTextViewM76829b3;
        hwTextViewM76829b3.setOnClickListener(this);
        C12809f.m76829b(this, R$id.clear_backup_bt).setOnClickListener(this);
        this.f15048G0.add(this.f15057L);
        this.f15048G0.add(this.f15053J);
        this.f15048G0.add(this.f15118u);
        this.f15048G0.add(this.f15077V);
        this.f15080W0.add(this.f15060M0);
        this.f15080W0.add(this.f15064O0);
        this.f15080W0.add(this.f15068Q0);
        this.f15080W0.add(this.f15072S0);
        UniformStorageBarFragment uniformStorageBarFragment = (UniformStorageBarFragment) C12809f.m76828a(getFragmentManager(), R$id.storage_bar_fragment);
        this.f15099g0 = uniformStorageBarFragment;
        uniformStorageBarFragment.m24364x(this.f15094d1);
        this.f15097f0 = (ProgressBar) C12809f.m76829b(this, R$id.storage_list_progress);
        if (C0209d.m1166E1()) {
            this.f15053J.setOnClickListener(this);
        } else {
            this.f15053J.disable();
        }
        C0124f2 c0124f2 = new C0124f2(this, this, this.f15094d1);
        this.f15079W = c0124f2;
        this.f15051I.setAdapter((ListAdapter) c0124f2);
        this.f15054J0 = C12809f.m76829b(this, R$id.clear_early_data_item_layout);
        this.f15052I0 = (TextView) C12809f.m76829b(this, R$id.cleanup_release_space_tv);
        this.f15037B = (TextLinkBar) C12809f.m76829b(this, R$id.text_link_bar);
        this.f15114s = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.text_link_region);
        this.f15084Y0 = (TextView) C12809f.m76829b(this, R$id.membership_service_data_tips);
        m22381r1();
        m20886t3();
        mo13327n1();
        m20880q3();
        C11842p.m70760Q1(this, this.f15043E);
        C11842p.m70760Q1(this, this.f15045F);
        m20884s3();
    }

    /* renamed from: A2 */
    public final void m20768A2(DriveConfigService driveConfigService, long j10) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "addDriveConfigToRemoveList serivce = " + driveConfigService.getId() + " quota = " + j10);
        m20812P4(driveConfigService.getId(), j10);
        C13380q c13380qM798d = this.f15079W.m798d(driveConfigService.getId());
        if (c13380qM798d == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "addDriveConfigToRemoveList service = " + driveConfigService.getId() + ", item is null");
            this.f15111q0.add(driveConfigService.getId());
            return;
        }
        C11839m.m70687e("HisyncSpaceDetailActivity", "addDriveConfigToRemoveList service = " + driveConfigService.getId() + ", item not null");
        c13380qM798d.m80354y("0");
        c13380qM798d.m80344o(0);
        c13380qM798d.m80321D(false);
        m20809O3(this, c13380qM798d);
        if (c13380qM798d.m80336g() <= 0) {
            this.f15111q0.add(driveConfigService.getId());
        }
    }

    /* renamed from: A3 */
    public final boolean m20769A3(DriveConfigService driveConfigService) {
        if (driveConfigService == null) {
            return true;
        }
        return (C0209d.m1166E1() || driveConfigService.isSubUser()) ? false : true;
    }

    /* renamed from: A4 */
    public final void m20770A4(String str) {
        this.f15094d1 = C13452e.m80781L().m80798E() == 0 && C13452e.m80781L().m80791C0();
        C11839m.m70688i("HisyncSpaceDetailActivity", str + this.f15094d1);
    }

    /* renamed from: B2 */
    public final void m20771B2(SharedPreferences sharedPreferences) {
        if (!C10028c.m62182c0().m62395t1("funcfg_notes")) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "notepad module disable");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d("notepad");
        int i10 = sharedPreferences.getInt("manage_cache_notepad_num", 0);
        int i11 = sharedPreferences.getInt("manage_cache_notepad_recycle_num", 0);
        C11839m.m70688i("HisyncSpaceDetailActivity", "addNotePadCacheFromSp num:" + i10 + ",recycleNum:" + i11);
        if ((i10 == -1 && i11 == -1) || ((i10 == 0 && i11 == -1) || ((i10 == -1 && i11 == 0) || (i10 == 0 && i11 == 0)))) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addNotePadCacheFromSp num or recycleNum is 0");
            return;
        }
        if (c13380qM798d == null) {
            c13380qM798d = m20840Z2();
            this.f15115s0.add(c13380qM798d);
        }
        if (i10 == 0) {
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
        } else {
            c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
            c13380qM798d.m80344o(i10);
        }
        Intent intentM80332c = c13380qM798d.m80332c();
        if (intentM80332c != null) {
            intentM80332c.putExtra("has_sync_data", true);
            intentM80332c.putExtra("recycle_notepad_num", i11);
        }
        c13380qM798d.m80321D(false);
    }

    /* renamed from: B3 */
    public final boolean m20772B3(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return true;
        }
        return (C0209d.m1166E1() || syncConfigService.isSubUser()) ? false : true;
    }

    /* renamed from: B4 */
    public final void m20773B4(int i10, int i11) {
        if ((i10 == 0 && i11 == 0) || (i10 == -1 && i11 == 0)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshNotepadNum num=" + i10);
            m20817R4("notepad", i10, i11);
            C13380q c13380qM798d = this.f15079W.m798d("notepad");
            if (c13380qM798d == null) {
                this.f15111q0.add("notepad");
                return;
            }
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshNotepadNum notepad item not null");
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
            c13380qM798d.m80321D(false);
            m20809O3(this, c13380qM798d);
            if (c13380qM798d.m80336g() <= 0) {
                this.f15111q0.add("notepad");
                return;
            }
            return;
        }
        C13380q c13380qM798d2 = this.f15079W.m798d("notepad");
        if (c13380qM798d2 == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshNotepadNum item is null");
            c13380qM798d2 = m20840Z2();
            this.f15107o0.add(c13380qM798d2);
        }
        if (i10 == 0) {
            c13380qM798d2.m80354y("0");
            c13380qM798d2.m80344o(0);
        } else {
            c13380qM798d2.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
            c13380qM798d2.m80344o(i10);
        }
        m20817R4("notepad", i10, i11);
        Intent intentM80332c = c13380qM798d2.m80332c();
        if (intentM80332c != null) {
            intentM80332c.putExtra("has_sync_data", true);
            intentM80332c.putExtra("recycle_notepad_num", i11);
        }
        c13380qM798d2.m80321D(false);
        m20809O3(this, c13380qM798d2);
    }

    /* renamed from: C2 */
    public final void m20774C2(SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        if (sharedPreferences == null) {
            return;
        }
        int i10 = sharedPreferences.getInt("manage_cache_sms_num", 0);
        int i11 = sharedPreferences.getInt("manage_cache_callog_num", 0);
        int i12 = sharedPreferences.getInt("manage_cache_record_num", 0);
        this.f15036A0.m15503l(i10);
        this.f15036A0.m15499g(i11);
        this.f15036A0.m15501i(i12);
        m20853d5();
    }

    /* renamed from: C3 */
    public final void m20775C3() {
        String strM80790C = C13452e.m80781L().m80790C();
        C13227f.m79492i1().m79586g0("mecloud_cloudspace_click_cloudbackup", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "mecloud_cloudspace_click_cloudbackup", "1", "7", strM80790C);
        C11839m.m70688i("HisyncSpaceDetailActivity", "mecloud_cloudspace_click_cloudbackup");
        Intent intent = new Intent();
        intent.setClass(this, CloudSpaceBackupActivity.class);
        intent.putExtra("recommend_card_activity_id", this.f15050H0.getActivityId());
        intent.putExtra("recommend_card_activity_type", this.f15050H0.getActivityType());
        intent.putExtra("recommend_card_entrance", this.f15050H0.getEntrance());
        startActivityForResult(intent, RequestManager.NOTIFY_CONNECT_SUCCESS);
    }

    /* renamed from: C4 */
    public final void m20776C4(int i10) {
        if (i10 > 0) {
            this.f15036A0.m15501i(i10);
            m20814Q4("record", i10);
        } else {
            this.f15036A0.m15501i(0);
            m20814Q4("record", 0);
        }
    }

    /* renamed from: D2 */
    public final void m20777D2() {
        C13380q[] c13380qArrM20868l5 = m20868l5(this.f15107o0);
        if (c13380qArrM20868l5.length > 0) {
            for (C13380q c13380q : c13380qArrM20868l5) {
                this.f15079W.m795a(c13380q);
            }
        }
        Iterator<String> it = this.f15111q0.iterator();
        while (it.hasNext()) {
            this.f15079W.m801g(it.next());
        }
        m20821T2();
    }

    /* renamed from: D3 */
    public final void m20778D3() {
        String strM80790C = C13452e.m80781L().m80790C();
        C13223b.m79478f("manage_cloud_drive", "1", C13452e.m80781L().m80971t0(), this.f15093d0, strM80790C);
        UBAAnalyze.m29960U("PVC", "manage_cloud_drive", "1", "7", "1", this.f15093d0, strM80790C);
        C13229h.m79496f1().m79586g0("mecloud_cloudspace_click_favorite", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "mecloud_cloudspace_click_favorite", "1", "7", strM80790C);
        Intent intentM80332c = this.f15129z0.m80332c();
        if (intentM80332c != null) {
            if (!TextUtils.isEmpty(this.f15091c0)) {
                intentM80332c.putExtra("deeplink_sub_page", this.f15091c0);
            }
            startActivity(intentM80332c);
        }
    }

    /* renamed from: D4 */
    public final void m20779D4(int i10) {
        if (i10 > 0) {
            this.f15036A0.m15503l(i10);
            m20814Q4(NavigationUtils.SMS_SCHEMA_PREF, i10);
        } else {
            this.f15036A0.m15503l(0);
            m20814Q4(NavigationUtils.SMS_SCHEMA_PREF, 0);
        }
    }

    /* renamed from: E2 */
    public final void m20780E2() throws Resources.NotFoundException {
        SharedPreferences sharedPreferencesM20866l3 = m20866l3();
        m20895x2(sharedPreferencesM20866l3);
        m20893w2(sharedPreferencesM20866l3);
        m20791I2(sharedPreferencesM20866l3);
        m20891v2(sharedPreferencesM20866l3);
        m20771B2(sharedPreferencesM20866l3);
        m20783F2(sharedPreferencesM20866l3);
        m20898y2(sharedPreferencesM20866l3);
        for (C13380q c13380q : m20868l5(this.f15115s0)) {
            this.f15079W.m795a(c13380q);
        }
        m20774C2(sharedPreferencesM20866l3);
        m20821T2();
    }

    /* renamed from: E3 */
    public final void m20781E3() {
        String strM80790C = C13452e.m80781L().m80790C();
        C13227f.m79492i1().m79586g0("mecloud_cloudspace_click_share", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "mecloud_cloudspace_click_share", "1", "7", strM80790C);
        C11839m.m70688i("HisyncSpaceDetailActivity", "mecloud_cloudspace_click_share");
        m20720Q3();
    }

    /* renamed from: E4 */
    public final void m20782E4() {
        C13380q[] c13380qArrM20865k5 = m20865k5(this.f15109p0, this.f15106n0);
        if (c13380qArrM20865k5.length > 0) {
            for (C13380q c13380q : c13380qArrM20865k5) {
                this.f15079W.m795a(c13380q);
            }
        }
        Iterator<String> it = this.f15113r0.iterator();
        while (it.hasNext()) {
            this.f15079W.m801g(it.next());
        }
        m20821T2();
    }

    /* renamed from: F2 */
    public final void m20783F2(SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        List<SyncConfigService> syncServicesFromDb = SyncModuleConfigManager.getInstance().getSyncServicesFromDb();
        if (syncServicesFromDb.size() <= 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "syncConfig addcache disable");
            return;
        }
        for (int i10 = 0; i10 < syncServicesFromDb.size(); i10++) {
            SyncConfigService syncConfigService = syncServicesFromDb.get(i10);
            String id2 = syncConfigService.getId();
            C13380q c13380qM798d = this.f15079W.m798d(id2);
            int i11 = sharedPreferences.getInt("manage_cache_" + id2, 0);
            if (i11 == 0) {
                C11839m.m70688i("HisyncSpaceDetailActivity", id2 + " addSyncConfigCacheFromSp num 0");
            } else {
                if (c13380qM798d == null) {
                    C11839m.m70687e("HisyncSpaceDetailActivity", syncConfigService.getId() + " addSyncConfigCacheFromSp item is null");
                    c13380qM798d = m20843a3(syncConfigService);
                    this.f15115s0.add(c13380qM798d);
                }
                if (c13380qM798d != null) {
                    if (getResources() != null) {
                        c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i11, Integer.valueOf(i11)), Integer.valueOf(i11)));
                    } else {
                        C11839m.m70687e("HisyncSpaceDetailActivity", "resources is null");
                    }
                    c13380qM798d.m80344o(i11);
                }
            }
        }
    }

    /* renamed from: F3 */
    public final void m20784F3() {
        try {
            this.f15091c0 = new SafeIntent(getIntent()).getStringExtra("deeplink_sub_page");
        } catch (Throwable th2) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "jumpToSubPageByPath err " + th2.getMessage());
        }
        C11839m.m70686d("HisyncSpaceDetailActivity", "mSubPageFlag " + this.f15091c0);
        if (TextUtils.isEmpty(this.f15091c0)) {
            C11839m.m70686d("HisyncSpaceDetailActivity", "jumpToSubPageByPath mSubPageFlag is null");
        }
        String str = this.f15091c0;
        str.hashCode();
        switch (str) {
            case "ManageSpace_contact":
                m20787G3(HNConstants.DataType.CONTACT);
                break;
            case "ManageSpace_disk":
                m20778D3();
                break;
            case "ManageSpace_note":
                m20787G3("notepad");
                break;
            case "ManageSpace_wlan":
                m20787G3("wlan");
                break;
            case "ManageSpace_share":
                m20781E3();
                break;
            case "ManageSpace_calendar":
                m20787G3("calendar");
                break;
            case "ManageSpace_gallery":
                m20787G3("gallery_sync");
                break;
            case "ManageSpace_backup":
                m20775C3();
                break;
        }
    }

    /* renamed from: F4 */
    public final void m20785F4() {
        if (this.f15078V0) {
            return;
        }
        this.f15078V0 = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!C3104a.m18459f().m18465g()) {
            C11839m.m70686d("HisyncSpaceDetailActivity", "GetSpaceOptDataTask start");
            C3104a.m18459f().m18461b(this.f15090b1, jCurrentTimeMillis);
        } else {
            C11839m.m70686d("HisyncSpaceDetailActivity", "GetSpaceOptDataTask isGetSpaceOptDataRunning");
            m20823T4(this.f15086Z0, 1051, -1, false);
            C3104a.m18459f().m18472n(this.f15090b1);
        }
    }

    /* renamed from: G2 */
    public final C13380q m20786G2(SyncConfigService syncConfigService, C13380q c13380q) throws Resources.NotFoundException {
        if (c13380q != null) {
            return c13380q;
        }
        C11839m.m70687e("HisyncSpaceDetailActivity", "refreshSyncConfigNum item is null");
        C13380q c13380qM20843a3 = m20843a3(syncConfigService);
        this.f15107o0.add(c13380qM20843a3);
        return c13380qM20843a3;
    }

    /* renamed from: G3 */
    public final void m20787G3(String str) {
        if (this.f15079W == null) {
            C11839m.m70686d("HisyncSpaceDetailActivity", "jumpToSyncByModuleName listAdapter is null ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70686d("HisyncSpaceDetailActivity", "jumpToSyncByModuleName moduleName is null ");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d(str);
        if (c13380qM798d != null) {
            m20818S2();
            c13380qM798d.m80351v();
            mo20827V(c13380qM798d.m80332c());
        }
    }

    /* renamed from: G4 */
    public final void m20788G4(SyncConfigService syncConfigService) throws Resources.NotFoundException {
        if (m20772B3(syncConfigService)) {
            return;
        }
        SyncConfigDataTypesCountData syncConfigDataTypesCountDataM20848c3 = m20848c3(syncConfigService.getDataTypes());
        int num = syncConfigDataTypesCountDataM20848c3.getNum();
        int recycleTotalNum = syncConfigDataTypesCountDataM20848c3.getRecycleTotalNum();
        if (num == 0 && recycleTotalNum == 0) {
            m20789H2(syncConfigService, num);
            return;
        }
        C13380q c13380qM20786G2 = m20786G2(syncConfigService, this.f15079W.m798d(syncConfigService.getId()));
        c13380qM20786G2.m80328K(syncConfigDataTypesCountDataM20848c3.getTypeName());
        c13380qM20786G2.m80325H(syncConfigDataTypesCountDataM20848c3.getSumNum());
        c13380qM20786G2.m80327J(syncConfigDataTypesCountDataM20848c3.getTypeNameIds());
        if (num == 0) {
            c13380qM20786G2.m80354y("0");
            c13380qM20786G2.m80344o(0);
        } else {
            c13380qM20786G2.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, num, Integer.valueOf(num)), Integer.valueOf(num)));
            c13380qM20786G2.m80344o(num);
        }
        m20814Q4(syncConfigService.getId(), num);
        c13380qM20786G2.m80318A(syncConfigService.isRecord());
        c13380qM20786G2.m80319B(syncConfigService.getRecordIndex());
        c13380qM20786G2.m80320C(recycleTotalNum);
        c13380qM20786G2.m80321D(false);
        m20809O3(this, c13380qM20786G2);
    }

    /* renamed from: H2 */
    public final void m20789H2(SyncConfigService syncConfigService, int i10) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "addSyncConfigToRemoveList service = " + syncConfigService.getId() + ", num=" + i10);
        m20814Q4(syncConfigService.getId(), i10);
        C13380q c13380qM798d = this.f15079W.m798d(syncConfigService.getId());
        if (c13380qM798d == null) {
            this.f15111q0.add(syncConfigService.getId());
            return;
        }
        C11839m.m70687e("HisyncSpaceDetailActivity", "refreshNotepadNum " + syncConfigService.getId() + " item not null");
        c13380qM798d.m80354y("0");
        c13380qM798d.m80344o(0);
        c13380qM798d.m80321D(false);
        m20809O3(this, c13380qM798d);
        if (c13380qM798d.m80336g() <= 0) {
            this.f15111q0.add(syncConfigService.getId());
        }
    }

    /* renamed from: H4 */
    public final void m20790H4() {
        this.f15060M0.hideSubDataListView();
        this.f15060M0.hideRedImg();
        this.f15060M0.hideLoading();
        this.f15060M0.hideStorageManageCardSize();
    }

    /* renamed from: I2 */
    public final void m20791I2(SharedPreferences sharedPreferences) {
        if (!C10028c.m62182c0().m62395t1("funcfg_wlan")) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "wlan module disable");
            return;
        }
        if (this.f15079W.m798d("wlan") != null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addWlanCacheFromSp already has data");
            return;
        }
        C13380q c13380qM20846b3 = m20846b3();
        int i10 = sharedPreferences.getInt("manage_cache_wlan_num", 0);
        if (i10 == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addWlanCacheFromSp num 0");
            return;
        }
        c13380qM20846b3.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM20846b3.m80344o(i10);
        c13380qM20846b3.m80321D(false);
        this.f15115s0.add(c13380qM20846b3);
    }

    /* renamed from: I3 */
    public final /* synthetic */ void m20792I3(UserDataStateInfo userDataStateInfo) {
        this.f15082X0 = userDataStateInfo;
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C11839m.m70688i("HisyncSpaceDetailActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            if (interfaceC9282a != null) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58399V0(System.currentTimeMillis());
                C13452e.m80781L().m80839O1(userDataStateInfo.getDataPeriod());
                C13452e.m80781L().m80893b2(userDataStateInfo.getBmGradeState());
            }
        }
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        m20798K3();
        m20876o4();
        m20862j4(storageInfoM80226P);
        m20897x4(storageInfoM80226P);
        C0124f2 c0124f2 = this.f15079W;
        if (c0124f2 != null) {
            c0124f2.m802h(C13452e.m80781L().m80819J0());
            this.f15079W.notifyDataSetChanged();
        }
    }

    /* renamed from: I4 */
    public final void m20793I4(int i10) {
        if (i10 == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshWlanNum num=" + i10);
            m20814Q4("wlan", i10);
            this.f15111q0.add("wlan");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d("wlan");
        if (c13380qM798d == null) {
            c13380qM798d = m20846b3();
            this.f15107o0.add(c13380qM798d);
        }
        c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM798d.m80344o(i10);
        c13380qM798d.m80321D(false);
        m20814Q4("wlan", i10);
    }

    /* renamed from: J2 */
    public final void m20794J2() {
        if (C13368e.m80184F().m80226P().isEnterSpaceDetailUseCache()) {
            C13368e.m80184F().m80247l0();
            C13368e.m80184F().m80226P().setEnterSpaceDetailUseCache(false);
        }
    }

    /* renamed from: J3 */
    public final void m20795J3(List<HDSpaceDetail> list) {
        boolean z10;
        long fsize;
        HDSpaceDetail hDSpaceDetail = null;
        HDSpaceDetail hDSpaceDetail2 = null;
        for (HDSpaceDetail hDSpaceDetail3 : list) {
            if (hDSpaceDetail3.getModuleName().equals("notepad")) {
                hDSpaceDetail2 = hDSpaceDetail3;
            } else if (hDSpaceDetail3.getModuleName().equals("sync")) {
                hDSpaceDetail = hDSpaceDetail3;
            }
        }
        if (hDSpaceDetail == null && hDSpaceDetail2 == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "mergeSyncNotepad, no notepad data");
            return;
        }
        boolean z11 = true;
        long fsize2 = 0;
        if (hDSpaceDetail != null) {
            fsize = hDSpaceDetail.getFsize();
            list.remove(hDSpaceDetail);
            z10 = true;
        } else {
            z10 = false;
            fsize = 0;
        }
        if (hDSpaceDetail2 != null) {
            fsize2 = hDSpaceDetail2.getFsize();
            list.remove(hDSpaceDetail2);
        } else {
            z11 = false;
        }
        HDSpaceDetail hDSpaceDetail4 = new HDSpaceDetail();
        hDSpaceDetail4.setModuleName("notepad");
        long j10 = fsize + fsize2;
        hDSpaceDetail4.setFsize(j10);
        list.add(hDSpaceDetail4);
        if (z10) {
            hDSpaceDetail4.setSyncData(j10, z11);
        }
        Collections.sort(list);
    }

    /* renamed from: J4 */
    public final void m20796J4() {
        C11839m.m70688i("HisyncSpaceDetailActivity", "registerFamilySharingReceiver");
        if (this.f15092c1 == null) {
            this.f15092c1 = new C3327c();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FamilyShareConstants.Report.CLICK_JOIN_BUTTON);
        intentFilter.addAction(FamilyShareConstants.Report.CLICK_DISABLE_BUTTON);
        C13108a.m78878b(this).m78880c(this.f15092c1, intentFilter);
    }

    /* renamed from: K2 */
    public final boolean m20797K2(DataTypeNum[] dataTypeNumArr) {
        return dataTypeNumArr != null && dataTypeNumArr.length > 0;
    }

    /* renamed from: K3 */
    public final void m20798K3() {
        C11839m.m70688i("HisyncSpaceDetailActivity", "modifyTextByType");
        if (C11842p.m70732H0(this)) {
            this.f15060M0.setStorageManageCardItemIcon(getDrawable(R$drawable.manage_data_upgrading_new_dark));
            this.f15072S0.setStorageManageCardItemIcon(getDrawable(R$drawable.manage_data_family_share_new_dark));
            this.f15068Q0.setStorageManageCardItemIcon(getDrawable(R$drawable.manage_data_space_opt_new_dark));
        }
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        if (zM80887a1 && zM80791C0 && !this.f15094d1) {
            this.f15060M0.setTitleText(getString(R$string.basic_data_upgrade_btn));
            this.f15099g0.m24356l(this);
        } else {
            this.f15060M0.setTitleText(getString(R$string.cloudpay_upgrade_storage));
            this.f15099g0.m24352d(this);
        }
        m20889u3();
    }

    /* renamed from: L2 */
    public final boolean m20799L2(SyncConfigServiceDataType[] syncConfigServiceDataTypeArr) {
        return syncConfigServiceDataTypeArr != null && syncConfigServiceDataTypeArr.length > 0;
    }

    /* renamed from: L3 */
    public final synchronized void m20800L3(ScrollDisabledListView scrollDisabledListView, BaseAdapter baseAdapter) {
        baseAdapter.notifyDataSetChanged();
        C2783d.m16170p1(scrollDisabledListView, baseAdapter);
    }

    /* renamed from: L4 */
    public final void m20801L4() {
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            String stringExtra = safeIntent.getStringExtra("srcChannel");
            String stringExtra2 = safeIntent.getStringExtra("sceneCode");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("pay_src_channel", stringExtra);
            linkedHashMapM79497A.put("sceneCode", stringExtra2);
            linkedHashMapM79497A.put("gradeCode", C13452e.m80781L().m80790C());
            C13227f.m79492i1().m79567R("MANAGING_CLOUD_STORAGE_SPACE", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "MANAGING_CLOUD_STORAGE_SPACE", "1", "7", linkedHashMapM79497A);
        } catch (Throwable th2) {
            C1442a.m8289e("HisyncSpaceDetailActivity", "reportEnterManagerActivity error occur:" + th2.getMessage());
        }
    }

    /* renamed from: M2 */
    public final boolean m20802M2(List<HDSpaceDetail> list) {
        if (list == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "diskDetailList is null");
            return true;
        }
        if (list.size() != 0) {
            return false;
        }
        C11839m.m70688i("HisyncSpaceDetailActivity", "no diskDetailList data");
        return true;
    }

    /* renamed from: M3 */
    public final void m20803M3(View view) {
        int iM805b = ((C0124f2.a) view.getTag()).m805b();
        C11839m.m70688i("HisyncSpaceDetailActivity", "onDetailClick position=" + iM805b);
        C13380q c13380q = (C13380q) this.f15079W.getItem(iM805b);
        if (c13380q == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "onDetailClick item null");
            return;
        }
        C13380q c13380q2 = this.f15095e0;
        if (c13380q2 != null) {
            c13380q2.m80345p(false);
        }
        this.f15095e0 = c13380q;
        m20806N3(view, this, c13380q);
        C10799m.m65722a(this, c13380q.m80333d(), this.f15093d0);
    }

    /* renamed from: M4 */
    public final void m20804M4() {
        String strM80790C = C13452e.m80781L().m80790C();
        C13227f.m79492i1().m79586g0("click_to_backup_clear_button", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "click_to_backup_clear_button", "1", "80", strM80790C);
    }

    /* renamed from: N2 */
    public final void m20805N2() {
        C0124f2 c0124f2 = this.f15079W;
        if (c0124f2 == null || c0124f2.getCount() <= 0) {
            this.f15110q.setVisibility(8);
        } else {
            this.f15110q.setVisibility(0);
            m20839Y4();
        }
    }

    /* renamed from: N3 */
    public final void m20806N3(View view, IManageClickControl iManageClickControl, C13380q c13380q) {
        if (view == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "onItemClick view null");
            return;
        }
        c13380q.m80345p(true);
        if (c13380q.m80341l()) {
            c13380q.m80322E(true);
            iManageClickControl.mo20863k0();
        } else {
            m20818S2();
            c13380q.m80351v();
            iManageClickControl.mo20827V(c13380q.m80332c());
            c13380q.m80345p(false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiutil.IManageClickControl
    /* renamed from: O */
    public void mo20807O() {
        this.f15081X = false;
    }

    /* renamed from: O2 */
    public final boolean m20808O2(HDSpaceDetail hDSpaceDetail) {
        if (TextUtils.equals(hDSpaceDetail.getModuleName(), "clouddrive")) {
            return true;
        }
        if (C10155f.m63288l()) {
            return false;
        }
        if (TextUtils.equals(hDSpaceDetail.getModuleName(), "phonemanager")) {
            this.f15036A0.m15500h(hDSpaceDetail.getFsize());
            return true;
        }
        if (!TextUtils.equals(hDSpaceDetail.getModuleName(), "record")) {
            return false;
        }
        this.f15036A0.m15502j(hDSpaceDetail.getFsize());
        return true;
    }

    /* renamed from: O3 */
    public final void m20809O3(IManageClickControl iManageClickControl, C13380q c13380q) {
        c13380q.m80322E(false);
        iManageClickControl.mo20863k0();
        C11839m.m70688i("HisyncSpaceDetailActivity", "onNumQueryFinish isClick=" + c13380q.m80338i());
        if (c13380q.m80338i()) {
            m20818S2();
            c13380q.m80351v();
            if (iManageClickControl.isForeground()) {
                iManageClickControl.mo20827V(c13380q.m80332c());
            } else {
                iManageClickControl.mo20807O();
            }
            c13380q.m80345p(false);
        }
    }

    /* renamed from: O4 */
    public final void m20810O4() {
        C0214f0.m1382b(this, "com.huawei.android.ds_spcace_detail_cache", 0).edit().putLong("manage_cache_timestamp", System.currentTimeMillis()).commit();
    }

    /* renamed from: P3 */
    public void m20811P3() {
        if (!this.f15083Y || this.f15085Z) {
            m20745h5();
            C11839m.m70687e("HisyncSpaceDetailActivity", "get storage info failed");
        }
    }

    /* renamed from: P4 */
    public final void m20812P4(String str, long j10) {
        if (str == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "driveconfig saveQuotaNumToSp serviceId null");
            return;
        }
        m20866l3().edit().putLong("manage_cache_" + str, j10).commit();
    }

    /* renamed from: Q2 */
    public final boolean m20813Q2(DriveConfigService driveConfigService) {
        return m20769A3(driveConfigService) || TextUtils.isEmpty(driveConfigService.getId());
    }

    /* renamed from: Q4 */
    public final void m20814Q4(String str, int i10) {
        if (str == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "moduleName null");
            return;
        }
        SharedPreferences sharedPreferencesM20866l3 = m20866l3();
        if (str.equals(HNConstants.DataType.CONTACT)) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_contact_num", i10).commit();
            return;
        }
        if (str.equals("calendar")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_calendar_num", i10).commit();
            return;
        }
        if (str.equals(NavigationUtils.SMS_SCHEMA_PREF)) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_sms_num", i10).commit();
            return;
        }
        if (str.equals("wlan")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_wlan_num", i10).commit();
            return;
        }
        if (str.equals("browser")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_browser_num", i10).commit();
            return;
        }
        if (str.equals("calllog")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_callog_num", i10).commit();
            return;
        }
        if (str.equals("notepad")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_notepad_num", i10).commit();
            return;
        }
        if (str.equals("record")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_record_num", i10).commit();
            return;
        }
        sharedPreferencesM20866l3.edit().putInt("manage_cache_" + str, i10).commit();
    }

    /* renamed from: R2 */
    public final boolean m20815R2(SyncConfigService syncConfigService) {
        return m20772B3(syncConfigService) || TextUtils.isEmpty(syncConfigService.getId());
    }

    /* renamed from: R3 */
    public final void m20816R3(Intent intent) {
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra("srcChannel");
            this.f15088a1 = safeIntent.getBooleanExtra("intent_from_settings", false);
            m20770A4("parseIntentExtra isNewMemberDataManagement is ");
            C0216g0.m1402e(this).m1403A(stringExtra);
            if (safeIntent.getBooleanExtra("intent_from_settings_storage", false)) {
                C13227f.m79492i1().m79585f0("show_cloud_storage_in_system_settings", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "show_cloud_storage_in_system_settings", "1", "100");
            }
        } catch (Throwable th2) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "parseIntentExtra err " + th2.getMessage());
        }
    }

    /* renamed from: R4 */
    public final void m20817R4(String str, int i10, int i11) {
        if (str == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "moduleName null");
            return;
        }
        m20814Q4(str, i10);
        SharedPreferences sharedPreferencesM20866l3 = m20866l3();
        if (str.equals(HNConstants.DataType.CONTACT)) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_contact_recycle_num", i11).commit();
            return;
        }
        if (str.equals("notepad")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_notepad_recycle_num", i11).commit();
            return;
        }
        sharedPreferencesM20866l3.edit().putInt("manage_cache_" + str, i10).commit();
    }

    /* renamed from: S2 */
    public final void m20818S2() {
        Iterator<String> it = this.f15079W.m799e().iterator();
        while (it.hasNext()) {
            this.f15079W.m798d(it.next()).m80344o(0);
        }
    }

    /* renamed from: S3 */
    public final void m20819S3(int i10, int i11) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "processActivityResult: " + i10);
        if (10041 == i10 || 10011 == i10) {
            m20880q3();
        } else if (10046 == i10 && 10046 == i11) {
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
            m20889u3();
        }
    }

    /* renamed from: S4 */
    public final void m20820S4(String str, int i10, int i11, int i12, int i13) {
        if (str == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "moduleName null");
            return;
        }
        m20814Q4(str, i10);
        SharedPreferences sharedPreferencesM20866l3 = m20866l3();
        if (str.equals("browser")) {
            sharedPreferencesM20866l3.edit().putInt("manage_cache_key_browser_bookmark_num", i11).putInt("manage_cache_key_browser_history_num", i12).putInt("manage_cache_key_browser_infoflow_num", i13).commit();
            return;
        }
        sharedPreferencesM20866l3.edit().putInt("manage_cache_" + str, i10).commit();
    }

    /* renamed from: T2 */
    public final void m20821T2() {
        Iterator<String> it = this.f15079W.m799e().iterator();
        while (it.hasNext()) {
            this.f15079W.m798d(it.next()).m80354y("0");
        }
    }

    /* renamed from: T3 */
    public final void m20822T3(Message message) {
        Bundle bundle = (Bundle) message.obj;
        if (bundle.getInt(C5963j.f27041j) == 0) {
            long j10 = bundle.getLong("cloudPicCount");
            long j11 = bundle.getLong("cloudVideoCount");
            long j12 = bundle.getLong("recyclePicCount");
            long j13 = bundle.getLong("recycleVideoCount");
            m20894w4(j10, j11, j12, j13);
            C11839m.m70688i("HisyncSpaceDetailActivity", "Gallery photos:" + j10);
            C11839m.m70688i("HisyncSpaceDetailActivity", "Number of galleries video:" + j11);
            C11839m.m70688i("HisyncSpaceDetailActivity", "Recently deleted photos:" + j12);
            C11839m.m70688i("HisyncSpaceDetailActivity", "Number of recently deleted video:" + j13);
        }
    }

    /* renamed from: T4 */
    public final void m20823T4(Handler handler, int i10, int i11, boolean z10) {
        if (handler == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "sendMessage handler is null.");
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = i11;
        if (z10) {
            handler.sendMessageDelayed(messageObtainMessage, 500L);
        } else {
            handler.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: U2 */
    public final void m20824U2() {
        if (this.f15074T0) {
            m20872n3();
        } else {
            if (this.f15076U0) {
                return;
            }
            this.f15076U0 = true;
            m20785F4();
        }
    }

    /* renamed from: U3 */
    public final void m20825U3(int i10, int i11, int i12, int i13) {
        C11839m.m70686d("HisyncSpaceDetailActivity", "queryBrowserCountFinish bookmarkNum=" + i11 + "historyNum=" + i12 + " infoFlowNum=" + i13);
        if (i10 < 0 || !C10028c.m62182c0().m62395t1("funcfg_browser")) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_BROWSER_COUNT_FINISH failed");
            return;
        }
        if (i11 <= -1) {
            i11 = 0;
        }
        if (i13 <= -1) {
            i13 = 0;
        }
        m20864k4(i11 + i12 + i13, i11, i12, i13);
    }

    /* renamed from: U4 */
    public final void m20826U4() {
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "setCloudDriveItem isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15118u, false);
            C12809f.m76843p(this.f15116t, false);
            return;
        }
        UsedSpaceInfo usedSpaceInfoM80221J = C13368e.m80184F().m80221J("drive");
        if (usedSpaceInfoM80221J == null) {
            this.f15118u.setVisibility(8);
            this.f15116t.setVisibility(8);
            C11839m.m70687e("HisyncSpaceDetailActivity", "setCloudDriveItem cloudDriveUsedSpace is null");
            return;
        }
        long used = usedSpaceInfoM80221J.getUsed();
        if (used <= 0) {
            this.f15118u.setVisibility(8);
            this.f15116t.setVisibility(8);
            this.f15079W.m801g("clouddrive");
            m20800L3(this.f15051I, this.f15079W);
            m20805N2();
            C11839m.m70687e("HisyncSpaceDetailActivity", "setCloudDriveItem cloudDriveUsedSpace size is 0");
            return;
        }
        this.f15129z0.m80352w("clouddrive");
        Intent intentM65729h = C10799m.m65729h(this, "clouddrive");
        Drawable drawable = getDrawable(C2783d.m16165o("clouddrive"));
        this.f15129z0.m80326I(C2783d.m16168p(this, "clouddrive"));
        this.f15129z0.m80349t(drawable);
        this.f15129z0.m80350u(intentM65729h);
        this.f15129z0.m80323F(C0223k.m1525h(this, used, 1024));
        this.f15129z0.m80324G(used);
        this.f15129z0.m80351v();
        this.f15118u.setVisibility(8);
        this.f15116t.setVisibility(8);
        this.f15118u.setUsageSize(C0223k.m1525h(this, used, 1024));
        this.f15118u.setTitle(this.f15129z0.m80337h());
    }

    @Override // com.huawei.android.hicloud.p088ui.uiutil.IManageClickControl
    /* renamed from: V */
    public void mo20827V(Intent intent) {
        int intExtra = new HiCloudSafeIntent(intent).getIntExtra("request_code", -1);
        if (intExtra != -1) {
            startActivityForResult(intent, intExtra);
        } else {
            startActivity(intent);
        }
    }

    /* renamed from: V2 */
    public final C13380q m20828V2() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("browser");
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.ic_hicloud_browser_list_new_honor) : getDrawable(R$drawable.ic_hicloud_browser_list_new));
        c13380q.m80326I(getString(R$string.browser));
        c13380q.m80350u(C10799m.m65729h(this, "browser"));
        return c13380q;
    }

    /* renamed from: V3 */
    public final void m20829V3(int i10, int i11) throws Resources.NotFoundException {
        if (!(i10 == -1 && i11 == -1) && C10028c.m62182c0().m62395t1("funcfg_calendar")) {
            m20867l4(i10, i11);
        } else {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_CALENDAR_COUNT_FINISH failed");
        }
    }

    /* renamed from: V4 */
    public final int m20830V4(int i10, int i11, List<Drawable> list) {
        int i12;
        if (i10 > 0) {
            list.add(ContextCompat.getDrawable(this, R$drawable.icon_message_honor));
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 <= 0) {
            return i12;
        }
        int i13 = i12 + 1;
        list.add(ContextCompat.getDrawable(this, R$drawable.icon_call_log_honor));
        return i13;
    }

    /* renamed from: W2 */
    public final C13380q m20831W2() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("calendar");
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.icon_calendar_honor) : getDrawable(R$drawable.icon_calendar));
        c13380q.m80326I(getString(R$string.calendar_sync_item));
        c13380q.m80350u(C10799m.m65729h(this, "calendar"));
        return c13380q;
    }

    /* renamed from: W3 */
    public final void m20832W3(int i10) {
        this.f15097f0.setVisibility(8);
        if (i10 > 0) {
            this.f15036A0.m15499g(i10);
            m20814Q4("calllog", i10);
        } else {
            this.f15036A0.m15499g(0);
            m20814Q4("calllog", 0);
        }
        m20810O4();
    }

    /* renamed from: W4 */
    public final int m20833W4(int i10, int i11, List<Drawable> list) {
        int i12;
        if (i10 > 0) {
            list.add(ContextCompat.getDrawable(this, R$drawable.icon_message));
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 <= 0) {
            return i12;
        }
        int i13 = i12 + 1;
        list.add(ContextCompat.getDrawable(this, R$drawable.icon_call_log));
        return i13;
    }

    /* renamed from: X2 */
    public final C13380q m20834X2() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w(HNConstants.DataType.CONTACT);
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.ic_contacts_honor) : getDrawable(R$drawable.ic_contacts));
        c13380q.m80326I(getString(R$string.contact));
        c13380q.m80350u(C10799m.m65729h(this, HNConstants.DataType.CONTACT));
        return c13380q;
    }

    /* renamed from: X3 */
    public final void m20835X3(int i10, int i11) {
        if (!(i10 == -1 && i11 == -1) && (!(i10 == 0 && i11 == -1) && (!(i10 == -1 && i11 == 0) && C10028c.m62182c0().m62395t1("funcfg_contacts")))) {
            m20878p4(i10, i11);
        } else {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_CONTACT_COUNT_FINISH failed");
        }
    }

    /* renamed from: X4 */
    public final void m20836X4(long j10, long j11, int i10, List<Drawable> list) throws Resources.NotFoundException {
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "setIcons isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15077V, false);
            this.f15077V.setIconListFrame(false);
            return;
        }
        if (i10 <= 0) {
            this.f15077V.setVisibility(8);
            this.f15077V.setIconListFrame(false);
            return;
        }
        this.f15077V.setVisibility(0);
        this.f15077V.showDivider();
        this.f15077V.setIconListFrame(true);
        Resources resources = getResources();
        if (resources != null) {
            this.f15077V.setItemNumber(resources.getQuantityString(R$plurals.other_app_count, i10, Integer.valueOf(i10)));
        }
        long j12 = j10 + j11;
        if (j12 > 0) {
            this.f15077V.setUsageSize(C0223k.m1525h(this, j12, 1024));
        } else {
            this.f15077V.setSize("");
        }
        this.f15077V.setIconList(list);
    }

    /* renamed from: Y2 */
    public final C13380q m20837Y2(DriveConfigService driveConfigService) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "createDriveConfigItem service = " + driveConfigService.getId());
        C13380q c13380q = new C13380q();
        c13380q.m80346q(true);
        c13380q.m80352w(driveConfigService.getId());
        c13380q.m80348s(driveConfigService.getIconPath());
        c13380q.m80318A(driveConfigService.isRecord());
        c13380q.m80319B(driveConfigService.getRecordIndex());
        Bitmap bitmapM70501B = C11829c.m70501B(driveConfigService.getIconPath());
        BitmapDrawable bitmapDrawable = bitmapM70501B != null ? new BitmapDrawable((Resources) null, bitmapM70501B) : null;
        if (bitmapDrawable != null) {
            c13380q.m80349t(bitmapDrawable);
        }
        c13380q.m80353x(driveConfigService.getName());
        String stringFromDriveConfig = NotifyUtil.getStringFromDriveConfig(driveConfigService.getName());
        if (TextUtils.isEmpty(stringFromDriveConfig)) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "createDriveConfigItem titleText null");
            return null;
        }
        c13380q.m80326I(stringFromDriveConfig);
        c13380q.m80321D(false);
        m20859i3(driveConfigService.getPkgNames(), c13380q);
        c13380q.m80350u(C10799m.m65729h(this, "drive_config"));
        return c13380q;
    }

    /* renamed from: Y3 */
    public final void m20838Y3(List<DriveConfigService> list) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "queryDriveConfigCountFinish service size = " + list.size());
        Iterator<DriveConfigService> it = list.iterator();
        while (it.hasNext()) {
            m20883r4(it.next());
        }
    }

    /* renamed from: Y4 */
    public final void m20839Y4() {
        int count;
        C0124f2 c0124f2 = this.f15079W;
        if (c0124f2 == null || (count = c0124f2.getCount()) <= 0) {
            return;
        }
        this.f15063O.setVisibility(8);
        this.f15061N.setText(getString(R$string.main_data_sync_title2));
        this.f15059M.setImageDrawable(getDrawable(R$drawable.use_cloud_applications));
        Resources resources = getResources();
        if (resources != null) {
            this.f15065P.setText(resources.getQuantityString(R$plurals.other_app_count, count, Integer.valueOf(count)));
        }
        SpaceFormatSplit spaceFormatSplitM83088j = C13843a.m83088j(this, this.f15079W.m800f());
        this.f15069R.m29164d(spaceFormatSplitM83088j.getSize(), spaceFormatSplitM83088j.getUnit());
        List<String> listM799e = this.f15079W.m799e();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listM799e.iterator();
        while (it.hasNext()) {
            arrayList.add(C2783d.m16186w(this, it.next()));
        }
        this.f15038B0.m811G(arrayList);
        this.f15038B0.m5213j();
    }

    /* renamed from: Z2 */
    public final C13380q m20840Z2() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("notepad");
        c13380q.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.ic_memorandum_honor) : getDrawable(R$drawable.ic_memorandum));
        c13380q.m80326I(getString(R$string.notepad_app_name));
        c13380q.m80350u(C10799m.m65729h(this, "notepad"));
        return c13380q;
    }

    /* renamed from: Z3 */
    public final void m20841Z3(int i10, int i11) {
        if (!(i10 == -1 && i11 == -1) && (!(i10 == 0 && i11 == -1) && C10028c.m62182c0().m62395t1("funcfg_notes"))) {
            m20773B4(i10, i11);
        } else {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_NOTEPAD_COUNT_FINISH failed");
        }
    }

    /* renamed from: Z4 */
    public final void m20842Z4(C13380q c13380q, HDSpaceDetail hDSpaceDetail) {
        Intent intentM80332c;
        if (!"notepad".equals(hDSpaceDetail.getModuleName()) || (intentM80332c = c13380q.m80332c()) == null) {
            return;
        }
        intentM80332c.putExtra("has_sync_data", hDSpaceDetail.isHasSyncData());
    }

    /* renamed from: a3 */
    public final C13380q m20843a3(SyncConfigService syncConfigService) throws Resources.NotFoundException {
        Drawable bitmapDrawable;
        C11839m.m70688i("HisyncSpaceDetailActivity", "createSyncConfigItem modulename: " + syncConfigService.getId());
        C13380q c13380q = new C13380q();
        c13380q.m80347r(true);
        c13380q.m80352w(syncConfigService.getId());
        c13380q.m80348s(syncConfigService.getIconPath());
        c13380q.m80318A(syncConfigService.isRecord());
        c13380q.m80319B(syncConfigService.getRecordIndex());
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncConfigService.getId()) && C0209d.m1293p1()) {
            bitmapDrawable = ResourcesCompat.getDrawable(getResources(), R$drawable.hinote_sync_icon, getTheme());
        } else {
            Bitmap bitmapM70501B = C11829c.m70501B(syncConfigService.getIconPath());
            bitmapDrawable = bitmapM70501B != null ? new BitmapDrawable((Resources) null, bitmapM70501B) : null;
        }
        if (bitmapDrawable != null) {
            c13380q.m80349t(bitmapDrawable);
        }
        c13380q.m80353x(syncConfigService.getName());
        String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(syncConfigService.getName());
        if (TextUtils.isEmpty(stringFromSyncConfig)) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "titleText null");
            return null;
        }
        c13380q.m80326I(stringFromSyncConfig);
        String strM1300r0 = C0209d.m1300r0(this, syncConfigService.getApplications());
        C11839m.m70686d("HisyncSpaceDetailActivity", "packageName:" + strM1300r0);
        if (!TextUtils.isEmpty(strM1300r0)) {
            c13380q.m80355z(strM1300r0);
        }
        c13380q.m80350u(C10799m.m65729h(this, "sync_config"));
        return c13380q;
    }

    /* renamed from: a4 */
    public final void m20844a4(int i10) {
        if (i10 == -1 || !C10028c.m62182c0().m62201D1()) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_RECORDING_COUNT_FINISH failed");
        } else {
            m20776C4(i10);
        }
    }

    /* renamed from: a5 */
    public final void m20845a5(C13380q c13380q, DriveConfigService driveConfigService) {
        String[] pkgNames = driveConfigService.getPkgNames();
        if (pkgNames == null || pkgNames.length <= 0) {
            return;
        }
        for (String str : pkgNames) {
            if (TextUtils.isEmpty(str) && C0209d.m1218V1(this, str)) {
                c13380q.m80355z(str);
            }
        }
    }

    /* renamed from: b3 */
    public final C13380q m20846b3() {
        C13380q c13380q = new C13380q();
        c13380q.m80352w("wlan");
        c13380q.m80349t(getDrawable(R$drawable.ic_wifi));
        c13380q.m80326I(C0209d.m1262h2() ? getString(R$string.wlan_sync) : getString(R$string.wifi_sync));
        c13380q.m80350u(C10799m.m65729h(this, "wlan"));
        return c13380q;
    }

    /* renamed from: b5 */
    public final void m20847b5(C13380q c13380q, SyncConfigService syncConfigService) {
        String strM1300r0 = C0209d.m1300r0(this, syncConfigService.getApplications());
        if (TextUtils.isEmpty(strM1300r0)) {
            return;
        }
        c13380q.m80355z(strM1300r0);
    }

    /* renamed from: c3 */
    public final SyncConfigDataTypesCountData m20848c3(SyncConfigServiceDataType[] syncConfigServiceDataTypeArr) {
        int i10;
        int i11;
        int i12;
        DataTypeNum[] dataTypeNumArr;
        int i13;
        int i14;
        SyncConfigDataTypesCountData syncConfigDataTypesCountData = new SyncConfigDataTypesCountData();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        if (m20799L2(syncConfigServiceDataTypeArr)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "datatype length:" + syncConfigServiceDataTypeArr.length);
            int sumNum = 0;
            int recycleNum = 0;
            for (int i15 = 0; i15 < syncConfigServiceDataTypeArr.length; i15++) {
                SyncConfigServiceDataType syncConfigServiceDataType = syncConfigServiceDataTypeArr[i15];
                boolean zIsShowNum = syncConfigServiceDataType.isShowNum();
                C11839m.m70686d("HisyncSpaceDetailActivity", "typeName: " + syncConfigServiceDataType.getTypeName() + " showNum: " + zIsShowNum);
                if (zIsShowNum) {
                    DataTypeNum[] typeNum = syncConfigServiceDataType.getTypeNum();
                    if (m20797K2(typeNum)) {
                        int length = typeNum.length;
                        int sumNum2 = 0;
                        int i16 = 0;
                        int sumNum3 = 0;
                        while (i16 < length) {
                            DataTypeNum dataTypeNum = typeNum[i16];
                            if (dataTypeNum != null) {
                                dataTypeNumArr = typeNum;
                                int status = dataTypeNum.getStatus();
                                StringBuilder sb2 = new StringBuilder();
                                i13 = length;
                                sb2.append("status:");
                                sb2.append(status);
                                sb2.append(" typeNum.getSumNum:");
                                i14 = sumNum;
                                i12 = recycleNum;
                                sb2.append(dataTypeNum.getSumNum());
                                C11839m.m70686d("HisyncSpaceDetailActivity", sb2.toString());
                                if (status == -1) {
                                    sumNum2 = (int) (sumNum2 + dataTypeNum.getSumNum());
                                }
                                if (status == 2) {
                                    sumNum3 = (int) (sumNum3 + dataTypeNum.getSumNum());
                                }
                            } else {
                                i12 = recycleNum;
                                dataTypeNumArr = typeNum;
                                i13 = length;
                                i14 = sumNum;
                            }
                            i16++;
                            sumNum = i14;
                            typeNum = dataTypeNumArr;
                            length = i13;
                            recycleNum = i12;
                        }
                        i10 = sumNum;
                        i11 = recycleNum;
                        syncConfigServiceDataType.setSumNum(sumNum3);
                        syncConfigServiceDataType.setRecycleNum(sumNum2);
                        String typeName = syncConfigServiceDataType.getTypeName();
                        String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(typeName);
                        if (!TextUtils.isEmpty(stringFromSyncConfig)) {
                            if (i15 == syncConfigServiceDataTypeArr.length - 1) {
                                stringBuffer.append(stringFromSyncConfig);
                                stringBuffer2.append(String.valueOf(sumNum3));
                                stringBuffer3.append(typeName);
                            } else {
                                stringBuffer.append(stringFromSyncConfig + ",");
                                stringBuffer2.append(String.valueOf(sumNum3) + ",");
                                stringBuffer3.append(typeName + ",");
                            }
                        }
                    } else {
                        i10 = sumNum;
                        i11 = recycleNum;
                        C11839m.m70686d("HisyncSpaceDetailActivity", "SyncConfig DataTypeNums is 0, dataTypes is: " + i15);
                    }
                    sumNum = (int) (i10 + syncConfigServiceDataType.getSumNum());
                    recycleNum = (int) (i11 + syncConfigServiceDataType.getRecycleNum());
                }
            }
            syncConfigDataTypesCountData.setNum(sumNum);
            syncConfigDataTypesCountData.setRecycleTotalNum(recycleNum);
            syncConfigDataTypesCountData.setTypeName(stringBuffer.toString());
            syncConfigDataTypesCountData.setSumNum(stringBuffer2.toString());
            syncConfigDataTypesCountData.setTypeNameIds(stringBuffer3.toString());
        }
        return syncConfigDataTypesCountData;
    }

    /* renamed from: c4 */
    public final void m20849c4(int i10) {
        if (i10 == -1 || !C10028c.m62182c0().m62390s1()) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_SMS_COUNT_FINISH failed");
        } else {
            m20779D4(i10);
        }
    }

    /* renamed from: c5 */
    public final void m20850c5(HDSpaceDetail hDSpaceDetail, C13380q c13380q) {
        if (hDSpaceDetail.getModuleName().equals("record") || hDSpaceDetail.getModuleName().equals("notepad")) {
            return;
        }
        c13380q.m80321D(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15108p);
        arrayList.add(this.f15112r);
        arrayList.add(this.f15116t);
        arrayList.add(this.f15120v);
        arrayList.add(this.f15110q);
        arrayList.add(this.f15055K);
        arrayList.add(this.f15122w);
        arrayList.add(this.f15124x);
        arrayList.add(this.f15035A);
        arrayList.add(this.f15054J0);
        arrayList.add(this.f15128z);
        arrayList.add(this.f15114s);
        arrayList.add(this.f15056K0);
        arrayList.add(this.f15062N0);
        arrayList.add(this.f15058L0);
        arrayList.add(this.f15066P0);
        arrayList.add(this.f15070R0);
        arrayList.add(this.f15126y);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m20851d3(List<String> list) {
        C12515a.m75110o().m75172d(new C13561l(this, this.f15086Z0, list));
    }

    /* renamed from: d4 */
    public final void m20852d4(StructureNumRet structureNumRet) {
        List<SyncConfigService> list;
        List<DriveConfigService> list2;
        try {
            this.f15097f0.setVisibility(8);
            String numStr = structureNumRet.getNumStr();
            List<SyncConfigService> syncConfigServices = structureNumRet.getSyncConfigServices();
            List<DriveConfigService> driveConfigServices = structureNumRet.getDriveConfigServices();
            C11839m.m70688i("HisyncSpaceDetailActivity", "normalnum:" + numStr);
            JSONObject jSONObject = new JSONObject(numStr);
            if (TextUtils.isEmpty(numStr)) {
                list = syncConfigServices;
                list2 = driveConfigServices;
                C11839m.m70687e("HisyncSpaceDetailActivity", "normalNum empty");
            } else {
                Integer num = (Integer) jSONObject.get("record_num");
                Integer num2 = (Integer) jSONObject.get("notepad_num");
                Integer num3 = (Integer) jSONObject.get("recycle_notepad_num");
                Integer num4 = (Integer) jSONObject.get("calendar_num");
                Integer num5 = (Integer) jSONObject.get("calendarArc_num");
                Integer num6 = (Integer) jSONObject.get("contact_num");
                Integer num7 = (Integer) jSONObject.get("recycle_contact_num");
                Integer num8 = (Integer) jSONObject.get("wlan_num");
                Integer num9 = (Integer) jSONObject.get("bookmark_num");
                Integer num10 = (Integer) jSONObject.get("history_num");
                Integer num11 = (Integer) jSONObject.get("info_flow_num");
                list2 = driveConfigServices;
                Integer num12 = (Integer) jSONObject.get("sms_num");
                list = syncConfigServices;
                Integer num13 = (Integer) jSONObject.get("calllog_num");
                m20844a4(num.intValue());
                m20841Z3(num2.intValue(), num3.intValue());
                m20829V3(num4.intValue(), num5.intValue());
                m20835X3(num6.intValue(), num7.intValue());
                m20857g4(num8.intValue());
                m20825U3(num9.intValue() + num10.intValue() + num11.intValue(), num9.intValue(), num10.intValue(), num11.intValue());
                m20849c4(num12.intValue());
                m20832W3(num13.intValue());
                C13368e.m80184F().m80260v0("space_all", "space_operate_finish", jSONObject.toString(), "", -1L);
            }
            if (list != null && list.size() > 0) {
                m20854e4(list);
            } else if (list2 == null || list2.size() <= 0) {
                C11839m.m70687e("HisyncSpaceDetailActivity", "services empty");
            } else {
                m20838Y3(list2);
            }
            m20777D2();
            m20800L3(this.f15051I, this.f15079W);
            m20805N2();
            m20853d5();
        } catch (Exception e10) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "queryStructureCountFinish exception:" + e10.toString());
        }
    }

    /* renamed from: d5 */
    public final void m20853d5() throws Resources.NotFoundException {
        int iM15498f = this.f15036A0.m15498f();
        int iM15494a = this.f15036A0.m15494a();
        long jM15497e = this.f15036A0.m15497e();
        int iM15496d = this.f15036A0.m15496d();
        long jM15495c = this.f15036A0.m15495c();
        ArrayList arrayList = new ArrayList();
        int iM20830V4 = C0209d.m1269j1() ? m20830V4(iM15498f, iM15494a, arrayList) : m20833W4(iM15498f, iM15494a, arrayList);
        if (jM15495c > 0) {
            iM20830V4++;
            arrayList.add(ContextCompat.getDrawable(this, R$drawable.icon_section_ba));
        }
        if (C0209d.m1269j1()) {
            if (jM15497e > 0 && iM15496d > 0) {
                iM20830V4++;
                arrayList.add(ContextCompat.getDrawable(this, R$drawable.icon_record_detail_honor));
            }
        } else if (jM15497e > 0 && iM15496d > 0) {
            iM20830V4++;
            arrayList.add(ContextCompat.getDrawable(this, R$drawable.icon_record_detail));
        }
        int i10 = iM20830V4;
        C11839m.m70686d("HisyncSpaceDetailActivity", "otherAppCount:" + i10);
        m20836X4(jM15497e, jM15495c, i10, arrayList);
    }

    /* renamed from: e4 */
    public final void m20854e4(List<SyncConfigService> list) throws Resources.NotFoundException {
        Iterator<SyncConfigService> it = list.iterator();
        while (it.hasNext()) {
            m20788G4(it.next());
        }
    }

    /* renamed from: e5 */
    public final void m20855e5(Message message) {
        Object obj = message.obj;
        if (obj == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "showCleanupCard obj is null");
            this.f15054J0.setVisibility(8);
            return;
        }
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "showCleanupCard isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15054J0, false);
            return;
        }
        C11839m.m70688i("HisyncSpaceDetailActivity", "showCleanupCard isConditionAllow: " + obj.toString());
        if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                this.f15054J0.setVisibility(8);
            } else {
                this.f15054J0.setVisibility(0);
                this.f15052I0.setText(getString(R$string.cleanup_release_space_tip_2));
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.storage_manage_scrollview;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        if (this.f15088a1) {
            new HwAnimationReflection(this).m15927c(2);
        }
    }

    /* renamed from: g3 */
    public final void m20856g3(String str) throws Resources.NotFoundException {
        if (str != null) {
            if (TextUtils.equals(str, NavigationUtils.SMS_SCHEMA_PREF)) {
                this.f15036A0.m15503l(0);
                m20853d5();
            } else if (TextUtils.equals(str, "calllog")) {
                this.f15036A0.m15499g(0);
                m20853d5();
            } else if (TextUtils.equals(str, "phonemanager")) {
                this.f15036A0.m15500h(0L);
                m20853d5();
            } else if (TextUtils.equals(str, "record")) {
                this.f15036A0.m15501i(0);
                this.f15036A0.m15502j(0L);
                m20853d5();
            } else {
                this.f15079W.m801g(str);
                m20814Q4(str, 0);
                m20800L3(this.f15051I, this.f15079W);
                m20805N2();
            }
        }
        this.f15099g0.m24354j();
    }

    /* renamed from: g4 */
    public final void m20857g4(int i10) {
        if (i10 == -1 || !C10028c.m62182c0().m62395t1("funcfg_wlan")) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "MSG_QUERY_WLAN_COUNT_FINISH failed");
        } else {
            m20793I4(i10);
        }
    }

    /* renamed from: h4 */
    public final void m20858h4(StorageInfo storageInfo) throws Resources.NotFoundException {
        boolean zM16160m0 = C2783d.m16160m0();
        if (zM16160m0) {
            if (!m20896x3()) {
                this.f15097f0.setVisibility(8);
                m20780E2();
                this.f15079W.notifyDataSetChanged();
            }
            C13368e.m80184F().m80256t0(this.f15098f1);
            return;
        }
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshSyncItem isModuleEnable = " + zM16160m0);
        this.f15097f0.setVisibility(8);
    }

    /* renamed from: i3 */
    public final void m20859i3(String[] strArr, C13380q c13380q) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && C0209d.m1218V1(this, str) && c13380q != null) {
                C11839m.m70686d("HisyncSpaceDetailActivity", "driveConfig fillPackageName packageName = " + str);
                c13380q.m80355z(str);
            }
        }
    }

    /* renamed from: i4 */
    public final void m20860i4(BackupCacheInfo backupCacheInfo) throws Resources.NotFoundException {
        List<String> deviceCategorys = backupCacheInfo.getDeviceCategorys();
        int size = deviceCategorys.size();
        if (size == 0) {
            this.f15053J.hideDivider();
            this.f15053J.setNoItemNumber();
            this.f15053J.setIconListFrame(false);
            return;
        }
        this.f15053J.setItemNumber(C2783d.m16095M(getResources().getQuantityString(R$plurals.backups_device_num1, size, Integer.valueOf(size)), Integer.valueOf(size)));
        this.f15053J.showDivider();
        this.f15053J.setIconListFrame(true);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            if (C11829c.m70520H0(deviceCategorys.get(i10))) {
                arrayList.add(ContextCompat.getDrawable(this, R$drawable.manage_data_backup_pad));
            } else {
                arrayList.add(ContextCompat.getDrawable(this, R$drawable.manage_data_backup_phone));
            }
        }
        this.f15053J.setIconList(arrayList);
    }

    /* renamed from: i5 */
    public void m20861i5(boolean z10) {
        if (z10) {
            this.f15072S0.showSubDataListView();
        } else {
            this.f15072S0.hideSubDataListView();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiutil.IManageClickControl
    public boolean isForeground() {
        return C2783d.m16127b0(this);
    }

    /* renamed from: j4 */
    public final void m20862j4(StorageInfo storageInfo) {
        UserDataStateInfo userDataStateInfo;
        if (storageInfo == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshBackupSize() storageInfo=null return");
            return;
        }
        C13036o c13036o = new C13036o();
        List<UserBackupInfo.UserDeviceInfo> listM78566f = c13036o.m78566f();
        List<UserBackupInfo.UserDeviceInfo> listM78567g = c13036o.m78567g();
        long backupUsedSize = storageInfo.getBackupUsedSize();
        if (C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            C13380q c13380qM798d = this.f15079W.m798d("cloud_backup");
            if (c13380qM798d == null) {
                c13380qM798d = new C13380q();
                c13380qM798d.m80352w("cloud_backup");
                c13380qM798d.m80349t(getDrawable(R$drawable.ic_base_backup_item));
                c13380qM798d.m80326I(getString(R$string.cloud_backup_item_title));
                Intent intent = new Intent();
                intent.setClass(this, CloudSpaceBackupActivity.class);
                intent.putExtra("recommend_card_activity_id", this.f15050H0.getActivityId());
                intent.putExtra("recommend_card_activity_type", this.f15050H0.getActivityType());
                intent.putExtra("recommend_card_entrance", this.f15050H0.getEntrance());
                intent.putExtra("request_code", RequestManager.NOTIFY_CONNECT_SUCCESS);
                c13380qM798d.m80350u(intent);
                if (!AbstractC14026a.m84159a(listM78566f) || !AbstractC14026a.m84159a(listM78567g)) {
                    this.f15109p0.add(c13380qM798d);
                }
            }
            c13380qM798d.m80321D(false);
            c13380qM798d.m80323F(C0223k.m1525h(this, backupUsedSize, 1024));
            c13380qM798d.m80324G(backupUsedSize);
            if (backupUsedSize > 0 && (userDataStateInfo = this.f15082X0) != null && userDataStateInfo.getBmGradeState() == 0) {
                c13380qM798d.m80329L(C13452e.m80781L().m80791C0());
                return;
            }
            c13380qM798d.m80329L(false);
            if (backupUsedSize <= 0) {
                c13380qM798d.m80323F("");
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiutil.IManageClickControl
    /* renamed from: k0 */
    public void mo20863k0() {
        this.f15079W.notifyDataSetChanged();
    }

    /* renamed from: k4 */
    public final void m20864k4(int i10, int i11, int i12, int i13) {
        if (i10 == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshBrowserNum num=" + i10);
            m20820S4("browser", i10, 0, 0, 0);
            this.f15111q0.add("browser");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d("browser");
        if (c13380qM798d == null) {
            c13380qM798d = new C13380q();
            c13380qM798d.m80352w("browser");
            c13380qM798d.m80349t(C0209d.m1269j1() ? getDrawable(R$drawable.ic_hicloud_browser_list_new_honor) : getDrawable(R$drawable.ic_hicloud_browser_list_new));
            c13380qM798d.m80326I(getString(R$string.browser));
            c13380qM798d.m80350u(C10799m.m65729h(this, "browser"));
            this.f15107o0.add(c13380qM798d);
        }
        c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM798d.m80344o(i10);
        c13380qM798d.m80321D(false);
        m20820S4("browser", i10, i11, i12, i13);
    }

    /* renamed from: k5 */
    public final C13380q[] m20865k5(ArrayList<C13380q> arrayList, Comparator comparator) {
        if (arrayList.size() <= 0) {
            return new C13380q[0];
        }
        C13380q[] c13380qArr = (C13380q[]) arrayList.toArray(new C13380q[arrayList.size()]);
        Arrays.sort(c13380qArr, comparator);
        return c13380qArr;
    }

    /* renamed from: l3 */
    public final SharedPreferences m20866l3() {
        return C0214f0.m1382b(getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
    }

    /* renamed from: l4 */
    public final void m20867l4(int i10, int i11) throws Resources.NotFoundException {
        if ((i10 == 0 && i11 == 0) || (i10 == 0 && i11 == -1)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshCalendarNum num=" + i10);
            m20814Q4("calendar", i10);
            this.f15111q0.add("calendar");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d("calendar");
        if (c13380qM798d == null) {
            c13380qM798d = m20831W2();
            this.f15107o0.add(c13380qM798d);
        }
        String quantityString = getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10));
        if (i10 == 0) {
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
        } else {
            c13380qM798d.m80354y(C2783d.m16095M(quantityString, Integer.valueOf(i10)));
            c13380qM798d.m80344o(i10);
        }
        c13380qM798d.m80321D(false);
        m20814Q4("calendar", i10);
        m20809O3(this, c13380qM798d);
    }

    /* renamed from: l5 */
    public final C13380q[] m20868l5(ArrayList<C13380q> arrayList) {
        return m20865k5(arrayList, this.f15105m0);
    }

    /* renamed from: m3 */
    public final long m20869m3() {
        return C10810x.m65806b() + C10810x.m65805a();
    }

    /* renamed from: m4 */
    public final void m20870m4(BackupCacheInfo backupCacheInfo) throws Resources.NotFoundException {
        if (backupCacheInfo == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshCloudBackupSizeByCacheType backupCacheInfo is null");
            return;
        }
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshCloudBackupSizeByCacheType isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15055K, false);
            C12809f.m76843p(this.f15053J, false);
            return;
        }
        long backupUsedSize = backupCacheInfo.getBackupUsedSize();
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_cloud_backup");
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshCloudBackupSizeByCacheType size=" + backupUsedSize + ",isModuleEnable=" + zM62395t1);
        C13036o c13036o = new C13036o();
        List<UserBackupInfo.UserDeviceInfo> listM78566f = c13036o.m78566f();
        List<UserBackupInfo.UserDeviceInfo> listM78567g = c13036o.m78567g();
        if (!(AbstractC14026a.m84159a(listM78566f) && AbstractC14026a.m84159a(listM78567g)) && zM62395t1) {
            this.f15053J.setVisibility(8);
            this.f15055K.setVisibility(8);
            this.f15053J.setUsageSize(C0223k.m1525h(this, backupUsedSize, 1024));
            m20860i4(backupCacheInfo);
            return;
        }
        this.f15053J.setVisibility(8);
        this.f15055K.setVisibility(8);
        this.f15079W.m801g("cloud_backup");
        m20800L3(this.f15051I, this.f15079W);
        m20805N2();
    }

    /* renamed from: m5 */
    public final void m20871m5() {
        this.f15068Q0.hideStorageManageCardSubTitle();
        this.f15068Q0.hideSubDataListView();
        this.f15068Q0.hideRedImg();
        this.f15068Q0.hideStorageManageCardSize();
        this.f15068Q0.hideRightArrowImg();
        this.f15068Q0.showLoading();
    }

    /* renamed from: n3 */
    public final void m20872n3() {
        this.f15068Q0.hideRedImg();
        String strM80790C = C13452e.m80781L().m80790C();
        C10028c.m62182c0().m62208E3(System.currentTimeMillis());
        C13227f.m79492i1().m79586g0("click_to_space_clear_button", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "click_to_space_clear_button", "1", "85", strM80790C);
        startActivityForResult(new Intent(this, (Class<?>) HiSyncSpaceClearActivity.class), 10046);
    }

    /* renamed from: n4 */
    public final void m20873n4() {
        m20826U4();
    }

    /* renamed from: n5 */
    public final void m20874n5() {
        this.f15068Q0.hideStorageManageCardSubTitle();
        this.f15068Q0.hideSubDataListView();
        this.f15068Q0.hideRedImg();
        this.f15068Q0.hideStorageManageCardSize();
        this.f15068Q0.hideLoading();
        this.f15068Q0.showRightArrowImg();
    }

    /* renamed from: o3 */
    public final void m20875o3() {
        try {
            String stringExtra = new SafeIntent(getIntent()).getStringExtra(FaqConstants.FAQ_MODULE);
            if (!TextUtils.equals(stringExtra, "dbank")) {
                stringExtra = "other";
            }
            C2783d.m16161m1(this, stringExtra);
        } catch (Throwable th2) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "gotoHisyncEntrance err " + th2.getMessage());
        }
    }

    /* renamed from: o4 */
    public final void m20876o4() {
        UserDataStateInfo userDataStateInfo;
        UsedSpaceInfo usedSpaceInfoM80221J = C13368e.m80184F().m80221J("drive");
        if (usedSpaceInfoM80221J == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshCloudDriveSize() cloudDriveUsedSpace = null return");
            return;
        }
        long used = usedSpaceInfoM80221J.getUsed();
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshCloudDriveSize size=" + used);
        C13380q c13380qM798d = this.f15079W.m798d("clouddrive");
        if (c13380qM798d == null) {
            c13380qM798d = new C13380q();
            c13380qM798d.m80352w("clouddrive");
            c13380qM798d.m80349t(getDrawable(R$drawable.ic_basic_cloud_disk));
            c13380qM798d.m80326I(getString(R$string.space_display_drive_title));
            this.f15129z0.m80350u(C10799m.m65729h(this, "clouddrive"));
            this.f15129z0.m80351v();
            Intent intentM80332c = this.f15129z0.m80332c();
            if (intentM80332c != null) {
                if (!TextUtils.isEmpty(this.f15091c0)) {
                    intentM80332c.putExtra("deeplink_sub_page", this.f15091c0);
                }
                c13380qM798d.m80350u(intentM80332c);
            } else {
                C11839m.m70687e("HisyncSpaceDetailActivity", "intent=null");
            }
            if (used > 0) {
                this.f15109p0.add(c13380qM798d);
            }
        }
        c13380qM798d.m80321D(false);
        c13380qM798d.m80323F(C0223k.m1525h(this, used, 1024));
        c13380qM798d.m80324G(used);
        if (used <= 0 || (userDataStateInfo = this.f15082X0) == null || userDataStateInfo.getBmGradeState() != 0) {
            c13380qM798d.m80329L(false);
        } else {
            c13380qM798d.m80329L(C13452e.m80781L().m80791C0());
        }
        this.f15079W.notifyDataSetChanged();
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: o5 */
    public final void m20877o5(long j10) {
        this.f15068Q0.hideSubDataListView();
        this.f15068Q0.hideLoading();
        String strM1525h = C0223k.m1525h(this, j10, 1024);
        if (TextUtils.isEmpty(strM1525h)) {
            this.f15068Q0.hideStorageManageCardSubTitle();
            this.f15068Q0.hideRedImg();
            this.f15068Q0.hideStorageManageCardSize();
        } else {
            if (m20899y3(j10)) {
                this.f15068Q0.showRedImg();
            } else {
                this.f15068Q0.hideRedImg();
            }
            this.f15068Q0.setSubTitleText(C0229n.m1604c(getString(R$string.cloud_optimizable, strM1525h), strM1525h, Constants.URDU_LANG));
            this.f15068Q0.setArrowText(j10 > 0 ? getString(R$string.cloud_to_optimizable) : "");
        }
        this.f15068Q0.showRightArrowImg();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i10, i11, intent);
        if (10011 == i10 && 102 == i11) {
            C11839m.m70688i("HisyncSpaceDetailActivity", " StorageManageActivity onActivityResult");
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
            if (intent == null) {
                return;
            }
            if (new HiCloudSafeIntent(intent).getBooleanExtra("delete_all_backup", false)) {
                C9964e.m61814f().m61820g();
            }
        } else if (10012 == i10 && 101 == i11) {
            if (intent == null || intent.getStringExtra("disk_app_item_id_param") == null) {
                return;
            }
        } else if (10013 == i10) {
            if (intent == null) {
                C11839m.m70687e("HisyncSpaceDetailActivity", " gallerydetails data null");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("data_cached_refresh", false);
            C11839m.m70686d("HisyncSpaceDetailActivity", "gallerydetails isCachedRefresh:" + booleanExtra);
            if (booleanExtra) {
                C13368e.m80184F().m80212D0();
                m20760r3();
            }
        } else if (10029 == i10) {
            C11839m.m70688i("HisyncSpaceDetailActivity", " open space share,refresh data");
            m20892v4();
            C1399b.m8034o().m8053t(false);
        } else if (i10 == 8903 && this.f15117t0 != null) {
            C13195l.m79272J().m79297M(this, this.f15117t0.m65437v(), i11, intent);
        }
        m20819S3(i10, i11);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f15087a0) {
            return;
        }
        m22378l1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.cloud_backup_item) {
            m20775C3();
            return;
        }
        if (id2 == R$id.storage_manage_list_item_frame) {
            m20803M3(view);
            return;
        }
        if (id2 == R$id.upgrading_cloud_item) {
            Bundle bundle = new Bundle();
            bundle.putInt("from_where", 8);
            C13230i.m79522d1(bundle, "1", "7");
            C12126b.m72707c(C13222a.m79465g(this), bundle);
            new HwAnimationReflection(this).m15927c(1);
            String strM80790C = C13452e.m80781L().m80790C();
            C13223b.m79478f("manage_upgrade_space", "1", C13452e.m80781L().m80971t0(), this.f15093d0, strM80790C);
            UBAAnalyze.m29960U("PVC", "manage_upgrade_space", "1", "7", "1", this.f15093d0, strM80790C);
            C13227f.m79492i1().m79586g0("mecloud_cloudspace_click_upgrade", C13452e.m80781L().m80971t0(), strM80790C);
            UBAAnalyze.m29956Q("PVC", "mecloud_cloudspace_click_upgrade", "1", "7", strM80790C);
            return;
        }
        if (id2 == R$id.family_share_cloud_item) {
            m20781E3();
            return;
        }
        if (id2 == R$id.expired_backup_records_item) {
            startActivityForResult(new Intent(this, (Class<?>) OverdueBackupRecordsActivity.class), 10046);
            C10028c.m62182c0().m62207E2(false);
            this.f15064O0.hideExpiredBackupRecordsRedImg();
            C13225d.m79490f1().m79585f0("expired_backup_records", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "expired_backup_records", "1", "96");
            return;
        }
        if (id2 == R$id.family_share_item) {
            m20781E3();
            return;
        }
        if (id2 == R$id.cloud_collection_item) {
            m20778D3();
            return;
        }
        if (id2 == R$id.other_item) {
            Intent intent = new Intent(this, (Class<?>) OtherDetailActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("other_app_data_details", this.f15036A0);
            intent.putExtras(bundle2);
            startActivity(intent);
            return;
        }
        if (id2 != R$id.manage_list_item_number_frame) {
            if (id2 == R$id.clear_backup_bt) {
                startActivityForResult(new Intent(this, (Class<?>) CloudBackupClearActivity.class), 10041);
                m20804M4();
                return;
            } else {
                if (id2 == R$id.space_opt_cloud_item) {
                    C11839m.m70688i("HisyncSpaceDetailActivity", " space clean card click");
                    m20824U2();
                    return;
                }
                return;
            }
        }
        if (this.f15040C0) {
            this.f15073T.setVisibility(0);
            this.f15051I.setVisibility(8);
            this.f15040C0 = false;
            this.f15075U.setImageDrawable(ContextCompat.getDrawable(this, R$drawable.manage_data_list_expand));
            return;
        }
        this.f15073T.setVisibility(8);
        this.f15051I.setVisibility(0);
        this.f15040C0 = true;
        this.f15075U.setImageDrawable(ContextCompat.getDrawable(this, R$drawable.manage_data_list_retract));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m20882q5(this);
        C2783d.m16185v0(this.f15048G0);
        C2783d.m16183u0(this.f15080W0);
        C11842p.m70760Q1(this, this.f15043E);
        C11842p.m70760Q1(this, this.f15045F);
        C0124f2 c0124f2 = this.f15079W;
        if (c0124f2 != null) {
            c0124f2.notifyDataSetChanged();
        }
        UniformStorageBarFragment uniformStorageBarFragment = this.f15099g0;
        if (uniformStorageBarFragment != null) {
            uniformStorageBarFragment.m24350B();
        }
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "onConfigurationChanged(), isPrivacyUser, now exit Cloud!");
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f15119u0;
            if (unspportPrivateSpaceDialog == null) {
                UnspportPrivateSpaceDialog unspportPrivateSpaceDialog2 = new UnspportPrivateSpaceDialog(this, this);
                this.f15119u0 = unspportPrivateSpaceDialog2;
                unspportPrivateSpaceDialog2.show();
            } else if (!unspportPrivateSpaceDialog.isShowing()) {
                this.f15119u0.show();
            }
        }
        C9158a.m57503F().m57539f("cloudStorageMgr", this.f15086Z0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29137U0();
        super.onCreate(bundle);
        m20816R3(getIntent());
        m20801L4();
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "isPrivacyUser, now exit Cloud!");
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = new UnspportPrivateSpaceDialog(this, this);
            this.f15119u0 = unspportPrivateSpaceDialog;
            unspportPrivateSpaceDialog.show();
        } else {
            setContentView(R$layout.storage_manage);
            boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_already_configed_NV4");
            if (!C13612b.m81829B().isLogin() || !zM62395t1) {
                m20875o3();
                finish();
                return;
            }
            m20767w3();
            mo19005p1();
            m20757p3();
            m20796J4();
            SafeIntent safeIntent = new SafeIntent(getIntent());
            this.f15089b0 = safeIntent.getStringExtra(RemoteMessageConst.FROM);
            try {
                boolean booleanExtra = safeIntent.getBooleanExtra("is_from_main_activity", false);
                this.f15083Y = booleanExtra;
                if (!booleanExtra) {
                    C11060c c11060c = new C11060c();
                    c11060c.m66664t("06008");
                    c11060c.m66643I(C11058a.m66627b("06008"));
                    C9158a.m57503F().m57515M(this.f15086Z0, 3, c11060c, false, false, "HisyncSpaceDetailActivity");
                }
                this.f15087a0 = safeIntent.getBooleanExtra("is_from_webview_filemanager", false);
            } catch (Throwable th2) {
                C11839m.m70687e("HisyncSpaceDetailActivity", "intent init error: " + th2.toString());
            }
            this.f15093d0 = C13222a.m79465g(this);
            boolean zM80917g1 = C13452e.m80781L().m80917g1();
            C11839m.m70688i("HisyncSpaceDetailActivity", "onCreate isStInvalidByServer =" + zM80917g1);
            if (bundle != null) {
                this.f15085Z = bundle.getBoolean("is_recreate");
            }
            C11839m.m70688i("HisyncSpaceDetailActivity", "onCreate isRecreate =" + this.f15085Z);
            if (this.f15083Y && !this.f15085Z) {
                m20794J2();
                m20760r3();
                m20889u3();
            } else if (C0209d.m1333z1(this)) {
                if (zM80917g1) {
                    m20745h5();
                } else {
                    if (ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
                        m20745h5();
                        return;
                    }
                    m20740f5();
                }
                C13368e.m80184F().m80253r0();
                m20889u3();
            } else {
                m20745h5();
            }
            this.f15121v0 = C2783d.m16122Z0();
            this.f15099g0.m24357m(true);
            if (this.f15094d1) {
                m22365E1(R$string.expired_space_detail_title);
            } else {
                m22365E1(R$string.manage_space_title_new1);
            }
            this.f15103k0.m79065c(this, getIntent(), C13222a.m79465g(this));
            mo22385x1();
            C10718a c10718a = new C10718a(this);
            this.f15117t0 = c10718a;
            c10718a.m65432m("hisyncSpaceDetail");
        }
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "HisyncSpaceDetailActivity");
        m20712K4();
        m20739f4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m20761r5();
        m20885s5();
        C10718a c10718a = this.f15117t0;
        if (c10718a != null) {
            c10718a.m65430k();
        }
        if (C3104a.m18459f().m18465g()) {
            C3104a.m18459f().m18460a();
        }
        Handler handler = this.f15086Z0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f15087a0 = false;
        try {
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f15119u0;
            if (unspportPrivateSpaceDialog != null) {
                unspportPrivateSpaceDialog.dismiss();
                this.f15119u0 = null;
            }
        } catch (IllegalArgumentException unused) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "P.S. dialog dismiss IllegalArgumentException");
        } catch (Exception unused2) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "P.S. dialog dismiss exception");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C11839m.m70688i("HisyncSpaceDetailActivity", "onNewIntent");
        this.f15103k0.m79065c(this, getIntent(), C13222a.m79465g(this));
        m20816R3(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C11839m.m70688i("HisyncSpaceDetailActivity", "onRestart");
        m20879p5();
        m20887t5();
        C10718a c10718a = this.f15117t0;
        if (c10718a != null) {
            c10718a.m65431l();
        }
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1031;
        messageObtain.obj = bundle;
        this.f15086Z0.sendMessageDelayed(messageObtain, 3000L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (C2987p.m17951a(this)) {
            return;
        }
        String currentLanguage = HNUtil.getCurrentLanguage();
        if (!TextUtils.isEmpty(this.f15121v0) && !TextUtils.equals(this.f15121v0, currentLanguage)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "SyncConfigContryLanguage changed " + this.f15121v0 + " to " + currentLanguage);
            C2783d.m16140f1(currentLanguage);
            this.f15121v0 = currentLanguage;
            this.f15079W.m803i();
        }
        if (!TextUtils.isEmpty(this.f15123w0) && !TextUtils.equals(this.f15123w0, currentLanguage)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "DriveConfigContryLanguage changed " + this.f15123w0 + " to " + currentLanguage);
            C2783d.m16140f1(currentLanguage);
            this.f15123w0 = currentLanguage;
            this.f15079W.m797c();
        }
        C2783d.m16167o1();
        C9158a.m57503F().m57539f("cloudStorageMgr", this.f15086Z0);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C11839m.m70688i("HisyncSpaceDetailActivity", "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_recreate", true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m20732b4();
    }

    /* renamed from: p4 */
    public final void m20878p4(int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshContactNum, notDeletedNum=0, recycleNum=0");
            m20817R4(HNConstants.DataType.CONTACT, i10, i11);
            C13380q c13380qM798d = this.f15079W.m798d(HNConstants.DataType.CONTACT);
            if (c13380qM798d == null) {
                this.f15111q0.add(HNConstants.DataType.CONTACT);
                return;
            }
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshContactNum item not null");
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
            c13380qM798d.m80321D(false);
            m20809O3(this, c13380qM798d);
            if (c13380qM798d.m80336g() <= 0) {
                this.f15111q0.add(HNConstants.DataType.CONTACT);
                return;
            }
        }
        C13380q c13380qM798d2 = this.f15079W.m798d(HNConstants.DataType.CONTACT);
        if (c13380qM798d2 == null) {
            c13380qM798d2 = m20834X2();
            this.f15107o0.add(c13380qM798d2);
        }
        if (i10 == 0) {
            c13380qM798d2.m80354y("0");
            c13380qM798d2.m80344o(0);
        } else {
            c13380qM798d2.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
            c13380qM798d2.m80344o(i10);
        }
        c13380qM798d2.m80321D(false);
        m20817R4(HNConstants.DataType.CONTACT, i10, i11);
        m20809O3(this, c13380qM798d2);
    }

    /* renamed from: p5 */
    public final void m20879p5() {
        if (this.f15081X) {
            return;
        }
        C13380q c13380q = this.f15095e0;
        if (c13380q == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "currentClickItem null");
            return;
        }
        Intent intentM80332c = c13380q.m80332c();
        if (intentM80332c == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "foreIntent null");
        } else {
            startActivity(intentM80332c);
            this.f15081X = true;
        }
    }

    @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback
    /* renamed from: q */
    public void mo15483q() throws Resources.NotFoundException {
        m20742g5();
        if (!this.f15083Y || this.f15085Z) {
            m20760r3();
            m20784F3();
        }
    }

    /* renamed from: q3 */
    public final void m20880q3() {
        if (C0209d.m1166E1()) {
            C9424a.m59104a().m59105b(this.f15086Z0);
        } else {
            this.f15054J0.setVisibility(8);
            this.f15052I0.setVisibility(8);
        }
    }

    /* renamed from: q4 */
    public final void m20881q4(StorageInfo storageInfo) throws Resources.NotFoundException {
        List<HDSpaceDetail> diskDetails = storageInfo.getDiskDetails();
        if (m20802M2(diskDetails)) {
            return;
        }
        m20795J3(diskDetails);
        for (HDSpaceDetail hDSpaceDetail : diskDetails) {
            if (!m20808O2(hDSpaceDetail)) {
                C13380q c13380qM798d = this.f15079W.m798d(hDSpaceDetail.getModuleName());
                long fsize = hDSpaceDetail.getFsize();
                if (c13380qM798d == null) {
                    c13380qM798d = new C13380q();
                    c13380qM798d.m80352w(hDSpaceDetail.getModuleName());
                    Intent intentM65729h = C10799m.m65729h(this, hDSpaceDetail.getModuleName());
                    Drawable drawable = getDrawable(C2783d.m16165o(hDSpaceDetail.getModuleName()));
                    String strM16168p = C2783d.m16168p(this, hDSpaceDetail.getModuleName());
                    boolean z10 = false;
                    if (hDSpaceDetail.isFromSyncConfig()) {
                        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshDiskSize syncConfig " + hDSpaceDetail.getModuleName());
                        SyncConfigService syncConfigServiceByUnStruncturePath = SyncModuleConfigManager.getInstance().getSyncConfigServiceByUnStruncturePath(hDSpaceDetail.getPath());
                        if (syncConfigServiceByUnStruncturePath == null) {
                            C11839m.m70688i("HisyncSpaceDetailActivity", hDSpaceDetail.getModuleName() + " syncConfig service not found");
                        } else if (!m20815R2(syncConfigServiceByUnStruncturePath)) {
                            C13380q c13380qM798d2 = this.f15079W.m798d(syncConfigServiceByUnStruncturePath.getId());
                            if (c13380qM798d2 != null) {
                                c13380qM798d = c13380qM798d2;
                                z10 = true;
                            }
                            c13380qM798d.m80347r(true);
                            c13380qM798d.m80348s(syncConfigServiceByUnStruncturePath.getIconPath());
                            c13380qM798d.m80353x(syncConfigServiceByUnStruncturePath.getName());
                            strM16168p = NotifyUtil.getStringFromSyncConfig(syncConfigServiceByUnStruncturePath.getName());
                            if (!TextUtils.isEmpty(strM16168p)) {
                                if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncConfigServiceByUnStruncturePath.getId()) && C0209d.m1293p1()) {
                                    drawable = ResourcesCompat.getDrawable(getResources(), R$drawable.hinote_sync_icon, getTheme());
                                } else {
                                    Bitmap bitmapM70501B = C11829c.m70501B(syncConfigServiceByUnStruncturePath.getIconPath());
                                    if (bitmapM70501B != null) {
                                        drawable = new BitmapDrawable((Resources) null, bitmapM70501B);
                                    }
                                }
                                c13380qM798d.m80352w(syncConfigServiceByUnStruncturePath.getId());
                                m20847b5(c13380qM798d, syncConfigServiceByUnStruncturePath);
                                c13380qM798d.m80318A(syncConfigServiceByUnStruncturePath.isRecord());
                                c13380qM798d.m80319B(syncConfigServiceByUnStruncturePath.getRecordIndex());
                                intentM65729h = C10799m.m65729h(this, "sync_config");
                            }
                        }
                    }
                    if (hDSpaceDetail.isFromDriveConfig()) {
                        String serviceId = hDSpaceDetail.getServiceId();
                        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshDiskSize driveConfig " + hDSpaceDetail.getServiceId());
                        DriveConfigService driveServicesFromDb = DriveModuleConfigManager.getInstance().getDriveServicesFromDb(serviceId);
                        if (driveServicesFromDb == null) {
                            C11839m.m70688i("HisyncSpaceDetailActivity", "driveConfig service not found, service = " + serviceId);
                        } else if (!m20813Q2(driveServicesFromDb)) {
                            C13380q c13380qM798d3 = this.f15079W.m798d(driveServicesFromDb.getId());
                            if (c13380qM798d3 != null) {
                                c13380qM798d = c13380qM798d3;
                                z10 = true;
                            }
                            c13380qM798d.m80346q(true);
                            c13380qM798d.m80348s(driveServicesFromDb.getIconPath());
                            c13380qM798d.m80353x(driveServicesFromDb.getName());
                            String stringFromDriveConfig = NotifyUtil.getStringFromDriveConfig(driveServicesFromDb.getName());
                            if (!TextUtils.isEmpty(stringFromDriveConfig)) {
                                Bitmap bitmapM70501B2 = C11829c.m70501B(driveServicesFromDb.getIconPath());
                                if (bitmapM70501B2 != null) {
                                    drawable = new BitmapDrawable((Resources) null, bitmapM70501B2);
                                }
                                c13380qM798d.m80352w(driveServicesFromDb.getId());
                                m20845a5(c13380qM798d, driveServicesFromDb);
                                c13380qM798d.m80318A(driveServicesFromDb.isRecord());
                                c13380qM798d.m80319B(driveServicesFromDb.getRecordIndex());
                                strM16168p = stringFromDriveConfig;
                                intentM65729h = C10799m.m65729h(this, "drive_config");
                            }
                        }
                    }
                    c13380qM798d.m80326I(strM16168p);
                    c13380qM798d.m80349t(drawable);
                    c13380qM798d.m80350u(intentM65729h);
                    if (!C2783d.m16157l0(C0213f.m1377a(), hDSpaceDetail.getModuleName())) {
                        C11839m.m70688i("HisyncSpaceDetailActivity", "module not support:" + hDSpaceDetail.getModuleName());
                    } else if (!z10 && fsize > 0) {
                        this.f15109p0.add(c13380qM798d);
                    }
                }
                m20842Z4(c13380qM798d, hDSpaceDetail);
                c13380qM798d.m80323F(C0223k.m1525h(this, fsize, 1024));
                c13380qM798d.m80324G(fsize);
                m20850c5(hDSpaceDetail, c13380qM798d);
            }
        }
    }

    /* renamed from: q5 */
    public final void m20882q5(Context context) {
        if ((context instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) context)) {
            this.f15061N.setMaxWidth(C11842p.m70853q0());
            this.f15065P.setMaxWidth(C11842p.m70853q0());
        } else {
            this.f15061N.setMaxWidth(C11842p.m70873v0());
            this.f15065P.setMaxWidth(C11842p.m70873v0());
        }
    }

    /* renamed from: r4 */
    public final void m20883r4(DriveConfigService driveConfigService) {
        if (m20769A3(driveConfigService)) {
            return;
        }
        String id2 = driveConfigService.getId();
        DriveConfigQuotaCountData quotaCounts = driveConfigService.getQuotaCounts();
        if (quotaCounts == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshDriveConfigNum serivceId = " + id2 + ", quota = 0, remove service");
            m20768A2(driveConfigService, 0L);
            return;
        }
        long quota = quotaCounts.getQuota();
        m20812P4(id2, quota);
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshDriveConfigNum serivceId = " + id2 + ", quota = " + quota);
        if (quota <= 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshDriveConfigNum serivceId = " + id2 + ", quota = 0, remove service");
            m20768A2(driveConfigService, quota);
            return;
        }
        C13380q c13380qM20901z2 = m20901z2(driveConfigService, this.f15079W.m798d(driveConfigService.getId()));
        c13380qM20901z2.m80354y("0");
        c13380qM20901z2.m80344o(0);
        c13380qM20901z2.m80318A(driveConfigService.isRecord());
        c13380qM20901z2.m80319B(driveConfigService.getRecordIndex());
        c13380qM20901z2.m80321D(false);
        c13380qM20901z2.m80323F(C0223k.m1525h(this, quota, 1024));
        c13380qM20901z2.m80324G(quota);
        m20859i3(driveConfigService.getPkgNames(), c13380qM20901z2);
        m20809O3(this, c13380qM20901z2);
    }

    /* renamed from: s3 */
    public final void m20884s3() {
        if (C13452e.m80781L().m80798E() != 0 || !C13452e.m80781L().m80791C0()) {
            this.f15084Y0.setVisibility(8);
            return;
        }
        if (!C13452e.m80781L().m80815I0()) {
            if (!C13452e.m80781L().m80819J0()) {
                this.f15084Y0.setVisibility(8);
                return;
            } else {
                this.f15084Y0.setVisibility(0);
                this.f15084Y0.setText(getString(R$string.membership_service_expired_tips));
                return;
            }
        }
        Integer num = (Integer) C0226l0.m1582b(new Callable() { // from class: com.huawei.android.hicloud.ui.activity.p5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return HisyncSpaceDetailActivity.m20711H3();
            }
        }, 300L, 30);
        int iIntValue = num.intValue();
        if (iIntValue <= 0 || getResources() == null) {
            return;
        }
        this.f15084Y0.setVisibility(0);
        this.f15084Y0.setText(getResources().getQuantityString(R$plurals.membership_service_data_tips2, iIntValue, num));
    }

    /* renamed from: s5 */
    public final void m20885s5() {
        if (this.f15092c1 != null) {
            C13108a.m78878b(this).m78883f(this.f15104l0);
        }
    }

    /* renamed from: t3 */
    public final void m20886t3() {
        this.f15067Q.setLayoutManager(new NoScrollLinearLayoutManager(this, 0, false));
        C0128g2 c0128g2 = new C0128g2(this, true, false);
        this.f15038B0 = c0128g2;
        this.f15067Q.setAdapter(c0128g2);
        this.f15067Q.setOnTouchListener(new CurrentOnTouchListener(this.f15063O));
    }

    /* renamed from: t5 */
    public final void m20887t5() {
        this.f15083Y = false;
        this.f15099g0.m24361s();
    }

    /* renamed from: u2 */
    public final void m20888u2() {
        try {
            View viewFindViewById = C0209d.m1195O(this) >= 1.75f ? findViewById(R$id.vs_storage_manage_use_cloud_item_font_scale) : findViewById(R$id.vs_storage_manage_use_cloud_item);
            if (viewFindViewById instanceof ViewStub) {
                ((ViewStub) viewFindViewById).inflate();
            }
            viewFindViewById.setVisibility(8);
        } catch (Exception e10) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "adaptOldByFontScale --- " + e10.getMessage());
        }
    }

    /* renamed from: u3 */
    public final void m20889u3() {
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "initSpaceCleanCloud isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15066P0, false);
            C12809f.m76843p(this.f15068Q0, false);
        } else if (!m20902z3()) {
            this.f15066P0.setVisibility(8);
            this.f15068Q0.setVisibility(8);
        } else {
            this.f15066P0.setVisibility(0);
            this.f15068Q0.setVisibility(0);
            m20785F4();
        }
    }

    /* renamed from: u4 */
    public final void m20890u4() throws Resources.NotFoundException {
        FamilyDetailInfoRetBody retBody;
        if (this.f15094d1) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshFamilyShareStatus isNewMemberDataManagement is true");
            C12809f.m76843p(this.f15070R0, false);
            C12809f.m76843p(this.f15072S0, false);
            return;
        }
        FamilyShareInfoResult familyShareInfoResult = this.f15127y0;
        if (familyShareInfoResult != null) {
            if (familyShareInfoResult.getFamilyShareEnable() != 1) {
                this.f15070R0.setVisibility(8);
                this.f15072S0.setVisibility(8);
                return;
            }
            this.f15070R0.setVisibility(0);
            this.f15072S0.setVisibility(0);
            int spaceShareEnable = this.f15127y0.getSpaceShareEnable();
            boolean z10 = this.f15127y0.getSpaceShareOwner() != -1;
            FamilyDetailInfoResult familyDetailInfoResult = this.f15044E0;
            List<FamilyDetailInfo> usedSpaceInfoList = (familyDetailInfoResult == null || (retBody = familyDetailInfoResult.getRetBody()) == null) ? null : retBody.getUsedSpaceInfoList();
            if (spaceShareEnable != 0) {
                this.f15125x0 = 2;
                this.f15072S0.setTitleText(getString(R$string.family_usage));
                m20763s4(usedSpaceInfoList);
                m20765t4();
                return;
            }
            if (z10) {
                this.f15072S0.hideLoading();
                this.f15072S0.hideRedImg();
                this.f15072S0.setArrowText(getString(R$string.not_join));
                this.f15072S0.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
            } else {
                this.f15072S0.hideLoading();
                this.f15072S0.hideRedImg();
                this.f15072S0.setArrowText(getString(R$string.settings_hicloud_disabled));
                this.f15072S0.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
            }
            this.f15125x0 = 1;
            this.f15072S0.setTitleText(getString(R$string.cloud_space_share));
            this.f15072S0.setIconListFrame(false, false);
            m20748j3(usedSpaceInfoList);
        }
    }

    /* renamed from: v2 */
    public final void m20891v2(SharedPreferences sharedPreferences) {
        if (!C10028c.m62182c0().m62395t1("funcfg_browser")) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "browser module disable");
            return;
        }
        if (this.f15079W.m798d("browser") != null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addBrowserCacheFromSp already has data");
            return;
        }
        C13380q c13380qM20828V2 = m20828V2();
        int i10 = sharedPreferences.getInt("manage_cache_browser_num", 0);
        sharedPreferences.getInt("manage_cache_key_browser_bookmark_num", 0);
        sharedPreferences.getInt("manage_cache_key_browser_history_num", 0);
        sharedPreferences.getInt("manage_cache_key_browser_infoflow_num", 0);
        if (i10 == 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addBrowserCacheFromSp num 0");
            return;
        }
        c13380qM20828V2.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        c13380qM20828V2.m80344o(i10);
        c13380qM20828V2.m80321D(false);
        this.f15115s0.add(c13380qM20828V2);
    }

    /* renamed from: v4 */
    public final void m20892v4() {
        C13368e.m80184F().m80250o0();
        m20751k3();
    }

    /* renamed from: w2 */
    public final void m20893w2(SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        if (!C10028c.m62182c0().m62395t1("funcfg_calendar")) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "calendar module disable");
            return;
        }
        int i10 = sharedPreferences.getInt("manage_cache_calendar_num", 0);
        int i11 = sharedPreferences.getInt("calendarArc_num", 0);
        if ((i10 == 0 && i11 == 0) || (i10 == 0 && i11 == -1)) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addCalendarCacheFromSp num 0");
            return;
        }
        C11839m.m70688i("HisyncSpaceDetailActivity", "addCalendarCacheFromSp already has data");
        C13380q c13380qM798d = this.f15079W.m798d("calendar");
        if (c13380qM798d == null) {
            c13380qM798d = m20831W2();
        }
        String quantityString = getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10));
        if (i10 == 0) {
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
        } else {
            c13380qM798d.m80354y(C2783d.m16095M(quantityString, Integer.valueOf(i10)));
            c13380qM798d.m80344o(i10);
        }
        Intent intentM80332c = c13380qM798d.m80332c();
        if (intentM80332c != null) {
            intentM80332c.putExtra("calendarArc_num", i11);
            intentM80332c.putExtra("calendar_num", i10);
        }
        c13380qM798d.m80321D(false);
        this.f15115s0.add(c13380qM798d);
    }

    /* renamed from: w4 */
    public final void m20894w4(long j10, long j11, long j12, long j13) {
        long j14 = j10 + j11 + j12 + j13;
        C13380q c13380qM798d = this.f15079W.m798d("gallery_sync");
        if (c13380qM798d == null) {
            C11839m.m70687e("HisyncSpaceDetailActivity", "refreshGalleryNum item is null");
            return;
        }
        c13380qM798d.m80321D(false);
        Intent intentM80332c = c13380qM798d.m80332c();
        if (intentM80332c == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "refreshGalleryNum intent null");
            return;
        }
        intentM80332c.putExtra("gallery_pic_count", j10 + j12);
        intentM80332c.putExtra("gallery_vedio_count", j11 + j13);
        if (j12 > 0 || j13 > 0) {
            intentM80332c.putExtra("gallery_has_recent_delete", true);
        }
        int i10 = (int) j14;
        c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Long.valueOf(j14)));
        m20800L3(this.f15051I, this.f15079W);
        m20805N2();
        m20809O3(this, c13380qM798d);
    }

    /* renamed from: x2 */
    public final void m20895x2(SharedPreferences sharedPreferences) {
        if (!C10028c.m62182c0().m62395t1("funcfg_contacts")) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "contact module disable");
            return;
        }
        C13380q c13380qM798d = this.f15079W.m798d(HNConstants.DataType.CONTACT);
        int i10 = sharedPreferences.getInt("manage_cache_contact_num", 0);
        int i11 = sharedPreferences.getInt("manage_cache_contact_recycle_num", 0);
        if ((i10 == -1 && i11 == -1) || ((i10 == 0 && i11 == -1) || ((i10 == -1 && i11 == 0) || (i10 == 0 && i11 == 0)))) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "addContactCacheFromSp num or recycleNum 0");
            return;
        }
        if (c13380qM798d == null) {
            c13380qM798d = m20834X2();
            this.f15115s0.add(c13380qM798d);
        }
        if (i10 == 0) {
            c13380qM798d.m80354y("0");
            c13380qM798d.m80344o(0);
        } else {
            c13380qM798d.m80354y(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_detail_gallery_num1, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
            c13380qM798d.m80344o(i10);
        }
        c13380qM798d.m80321D(false);
    }

    /* renamed from: x3 */
    public final boolean m20896x3() {
        return C2783d.m16154k0(C0214f0.m1382b(this, "com.huawei.android.ds_spcace_detail_cache", 0).getLong("manage_cache_timestamp", 0L));
    }

    /* renamed from: x4 */
    public final void m20897x4(StorageInfo storageInfo) {
        UserDataStateInfo userDataStateInfo;
        long galleryUsedSize = storageInfo.getGalleryUsedSize();
        long galleryDeleteSize = storageInfo.getGalleryDeleteSize();
        long j10 = galleryUsedSize + galleryDeleteSize;
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_gallery");
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshGallerySize size=" + j10 + ",gallerySize=" + galleryUsedSize + ",deleteSize=" + galleryDeleteSize + ", isModuleEnable=" + zM62395t1);
        if (zM62395t1) {
            C13380q c13380qM798d = this.f15079W.m798d("gallery_sync");
            if (c13380qM798d == null) {
                c13380qM798d = new C13380q();
                c13380qM798d.m80352w("gallery_sync");
                if (C0209d.m1269j1()) {
                    c13380qM798d.m80349t(getDrawable(R$drawable.ic_cloud_album_honor));
                } else {
                    c13380qM798d.m80349t(getDrawable(R$drawable.ic_cloud_album));
                }
                c13380qM798d.m80326I(getString(R$string.gallery_item_title));
                Intent intent = new Intent();
                intent.setClass(this, GalleryDetailActivity.class);
                intent.putExtra("request_code", RequestManager.NOTIFY_CONNECT_SUSPENDED);
                intent.putExtra("gallery_from_hisync", true);
                c13380qM798d.m80350u(intent);
                this.f15109p0.add(c13380qM798d);
            }
            c13380qM798d.m80321D(false);
            c13380qM798d.m80323F(C0223k.m1525h(this, j10, 1024));
            c13380qM798d.m80324G(j10);
            Intent intentM80332c = c13380qM798d.m80332c();
            if (intentM80332c != null) {
                intentM80332c.putExtra("gallery_size", j10);
                intentM80332c.putExtra("gallery_delete_size", galleryDeleteSize);
            } else {
                C11839m.m70687e("HisyncSpaceDetailActivity", "refreshGallerySize intent null");
            }
            if (j10 <= 0 || (userDataStateInfo = this.f15082X0) == null || userDataStateInfo.getBmGradeState() != 0) {
                c13380qM798d.m80329L(false);
            } else {
                c13380qM798d.m80329L(C13452e.m80781L().m80791C0());
            }
        }
    }

    /* renamed from: y2 */
    public final void m20898y2(SharedPreferences sharedPreferences) {
        List<DriveConfigService> driveServicesFromDb = DriveModuleConfigManager.getInstance().getDriveServicesFromDb();
        if (driveServicesFromDb.size() <= 0) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "driveConfig addcache disable");
            return;
        }
        for (int i10 = 0; i10 < driveServicesFromDb.size(); i10++) {
            DriveConfigService driveConfigService = driveServicesFromDb.get(i10);
            String id2 = driveConfigService.getId();
            C13380q c13380qM798d = this.f15079W.m798d(id2);
            long j10 = sharedPreferences.getLong("manage_cache_" + id2, 0L);
            C11839m.m70688i("HisyncSpaceDetailActivity", "driveConfig addcache service = " + id2 + ", cacheSize = " + j10);
            if (j10 == 0) {
                C11839m.m70688i("HisyncSpaceDetailActivity", "addDriveConfigCacheFromSp quota 0, service = " + id2);
            } else {
                if (c13380qM798d == null) {
                    C11839m.m70687e("HisyncSpaceDetailActivity", "addDriveConfigCacheFromSp item is null, service = " + id2);
                    c13380qM798d = m20837Y2(driveConfigService);
                    this.f15115s0.add(c13380qM798d);
                }
                if (c13380qM798d != null) {
                    if (getResources() != null) {
                        c13380qM798d.m80354y("");
                    } else {
                        C11839m.m70687e("HisyncSpaceDetailActivity", "driveConfig resources is null");
                    }
                    c13380qM798d.m80344o(0);
                    c13380qM798d.m80323F(C0223k.m1525h(this, j10, 1024));
                    c13380qM798d.m80324G(j10);
                }
            }
        }
    }

    /* renamed from: y3 */
    public final boolean m20899y3(long j10) {
        return C10810x.m65812h(System.currentTimeMillis(), C10028c.m62182c0().m62243M0()) && C10810x.m65813i(j10);
    }

    /* renamed from: y4 */
    public final void m20900y4() {
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        int disuseState = storageInfoM80226P.getDisuseState();
        C11839m.m70688i("HisyncSpaceDetailActivity", "refreshGalleyDisuse disuseState: " + disuseState);
        if (disuseState != 1) {
            if (storageInfoM80226P.getGalleryUsedSize() + storageInfoM80226P.getGalleryDeleteSize() <= 0) {
                this.f15079W.m801g("gallery_sync");
                m20800L3(this.f15051I, this.f15079W);
                m20805N2();
            }
            m20744h3();
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("HisyncSpaceDetailActivity", "cloudAlbumRouterImpl is null");
        } else {
            if (interfaceC9282a.mo58378L(this)) {
                return;
            }
            m20749j5();
        }
    }

    /* renamed from: z2 */
    public final C13380q m20901z2(DriveConfigService driveConfigService, C13380q c13380q) {
        if (c13380q != null) {
            return c13380q;
        }
        C11839m.m70687e("HisyncSpaceDetailActivity", "refreshSyncConfigNum item is null");
        C13380q c13380qM20837Y2 = m20837Y2(driveConfigService);
        this.f15107o0.add(c13380qM20837Y2);
        return c13380qM20837Y2;
    }

    /* renamed from: z3 */
    public final boolean m20902z3() {
        return C9733f.m60705z().m60725T() && C0209d.m1166E1() && !C0209d.m1293p1() && C10155f.m63301y() && C10155f.m63248A();
    }

    /* renamed from: z4 */
    public final void m20903z4(StorageInfo storageInfo) throws Resources.NotFoundException {
        this.f15107o0.clear();
        this.f15109p0.clear();
        this.f15111q0.clear();
        this.f15115s0.clear();
        this.f15113r0.clear();
        C0124f2 c0124f2 = this.f15079W;
        if (c0124f2 != null) {
            c0124f2.m796b();
        }
        m20897x4(storageInfo);
        m20876o4();
        m20862j4(storageInfo);
        m20881q4(storageInfo);
        m20782E4();
        m20858h4(storageInfo);
        m20800L3(this.f15051I, this.f15079W);
        m20805N2();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        C9908c.m61499D().m61548i0(getApplicationContext());
    }
}
