package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CBRecoveryItem;
import com.huawei.android.hicloud.cloudbackup.bean.CloudRestoreOptionHeaderBean;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.model.RestoreItem;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BasicDataRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.C2661b;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBERecoveringActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudRestoreOptionsAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloudRestoreConfirmDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmJumpRefurbishDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MobileNetTipDialog;
import com.huawei.android.hicloud.p088ui.views.CloudRestoreBasicView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.gson.JsonSyntaxException;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.HonorVersionInfo;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import fk.C9721b;
import ge.C9908c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10782d;
import mk.C11477c;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0229n;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p292fn.C9733f;
import p384j4.AbstractC10706e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p514o9.C11842p;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p617rl.C12534r;
import p618rm.C12540b1;
import p618rm.C12580p;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p682ul.C13207a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p742wj.C13612b;
import p771xd.C13768l;
import p780xm.C13834f;
import p783xp.C13843a;
import p814yl.C14004e0;
import p815ym.AbstractC14026a;
import p846zj.C14306d;
import p848zl.C14333b;
import p850zo.InterfaceC14351b;
import sk.C12809f;
import sl.C12816g;
import tl.C13030i;
import tl.C13035n;

/* loaded from: classes3.dex */
public class CloudRestoreOptionsActivity extends CloudBaseRestoreOptionsActivity implements CloudRestoreConfirmDialog.BackupRecoverOnClickListner, View.OnClickListener, CloudRestoreOptionsAdapter.OnItemClickListener, View.OnTouchListener, DialogInterface.OnDismissListener, CloudRestoreBasicView.OnBaseItemCheckedListener {

    /* renamed from: A0 */
    public String f14331A0;

    /* renamed from: B0 */
    public String f14332B0;

    /* renamed from: C0 */
    public int f14333C0;

    /* renamed from: D0 */
    public LinearLayout f14334D0;

    /* renamed from: E0 */
    public CloudRestoreItem f14335E0;

    /* renamed from: F0 */
    public boolean f14336F0;

    /* renamed from: I0 */
    public C12534r f14339I0;

    /* renamed from: L */
    public long f14342L;

    /* renamed from: N */
    public float f14344N;

    /* renamed from: O */
    public boolean f14345O;

    /* renamed from: P */
    public boolean f14346P;

    /* renamed from: S */
    public RecyclerView f14349S;

    /* renamed from: T */
    public HwButton f14350T;

    /* renamed from: U */
    public AlertDialog f14351U;

    /* renamed from: V */
    public CloudRestoreConfirmDialog f14352V;

    /* renamed from: W */
    public CloudRestoreConfirmDialog f14353W;

    /* renamed from: X */
    public CloudRestoreOptionsAdapter f14354X;

    /* renamed from: Z */
    public NotchFitRelativeLayout f14356Z;

    /* renamed from: a0 */
    public NotchFitLinearLayout f14357a0;

    /* renamed from: c0 */
    public long f14359c0;

    /* renamed from: d0 */
    public MobileNetTipDialog f14360d0;

    /* renamed from: e0 */
    public HiCloudExceptionView f14361e0;

    /* renamed from: f0 */
    public NetWorkChangeReceiver f14362f0;

    /* renamed from: g0 */
    public Handler f14363g0;

    /* renamed from: h0 */
    public Handler f14364h0;

    /* renamed from: i0 */
    public TextView f14365i0;

    /* renamed from: j0 */
    public TextView f14366j0;

    /* renamed from: k0 */
    public TextView f14367k0;

    /* renamed from: l0 */
    public TextView f14368l0;

    /* renamed from: m0 */
    public NotchFitRelativeLayout f14369m0;

    /* renamed from: n0 */
    public NotchFitRelativeLayout f14370n0;

    /* renamed from: o0 */
    public AlertDialog f14371o0;

    /* renamed from: p0 */
    public ConfirmJumpRefurbishDialog f14372p0;

    /* renamed from: q0 */
    public AlertDialog f14373q0;

    /* renamed from: r0 */
    public LinearLayout f14374r0;

    /* renamed from: s0 */
    public CheckBox f14375s0;

    /* renamed from: z0 */
    public String f14382z0;

    /* renamed from: M */
    public final C3229d f14343M = new C3229d();

    /* renamed from: Q */
    public boolean f14347Q = true;

    /* renamed from: R */
    public boolean f14348R = false;

    /* renamed from: Y */
    public List<CloudRestoreItem> f14355Y = new ArrayList();

    /* renamed from: b0 */
    public boolean f14358b0 = false;

    /* renamed from: t0 */
    public boolean f14376t0 = false;

    /* renamed from: u0 */
    public boolean f14377u0 = true;

    /* renamed from: v0 */
    public boolean f14378v0 = true;

    /* renamed from: w0 */
    public boolean f14379w0 = false;

    /* renamed from: x0 */
    public boolean f14380x0 = false;

    /* renamed from: y0 */
    public int f14381y0 = 0;

    /* renamed from: G0 */
    public boolean f14337G0 = false;

    /* renamed from: H0 */
    public String f14338H0 = "";

    /* renamed from: J0 */
    public MobileNetTipDialog.MobileNetTipClickListener f14340J0 = new MobileNetTipDialog.MobileNetTipClickListener() { // from class: com.huawei.android.hicloud.ui.activity.k3
        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.MobileNetTipDialog.MobileNetTipClickListener, android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
            this.f17656a.m19885M3(dialogInterface, i10);
        }
    };

    /* renamed from: K0 */
    public Handler f14341K0 = new Handler(new C3227b());

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                if (C0209d.m1333z1(context)) {
                    MobileTrafficReport.getInstance().setMobile(!C0209d.m1254f2(context));
                }
                CloudRestoreOptionsActivity.this.m19871C4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$a */
    public class C3226a extends AbstractC12368e {
        public C3226a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            boolean zM79409d;
            C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
            try {
                zM79409d = C13207a.m79404c().m79409d(CloudRestoreOptionsActivity.this, C13207a.b.PROTOCOL);
                C11839m.m70688i("CloudRestoreOptionsActivity", "query adg Protocol isAgreeAgdNetwork:" + C13207a.m79404c().m79408b(C13207a.a.WHITE_LIST));
            } catch (C9721b e10) {
                C11839m.m70688i("CloudRestoreOptionsActivity", "query adg Protocol exception:" + e10.getMessage());
                CloudRestoreOptionsActivity.this.f14378v0 = false;
                zM79409d = true;
            }
            if (zM79409d) {
                CloudRestoreOptionsActivity.this.m19917g3();
                return;
            }
            boolean zIsRefurbishment = CloudRestoreOptionsActivity.this.f14175D.isRefurbishment();
            C11839m.m70688i("CloudRestoreOptionsActivity", "initAgdProtocol isRefurbish:" + zIsRefurbishment);
            boolean zM60720O = C9733f.m60705z().m60720O(CloudRestoreOptionsActivity.this.f14336F0 ? "cloudBackupTempAGDCapbility" : zIsRefurbishment ? "cloudBackupRefurbishAGDCapbility" : "cloudBackupAGDCapbility");
            C11839m.m70688i("CloudRestoreOptionsActivity", "initAgdProtocol:" + zM79409d + ", ag switch:" + zM60720O);
            if (!zM60720O) {
                CloudRestoreOptionsActivity.this.m19917g3();
            } else {
                CloudRestoreOptionsActivity.this.f14376t0 = true;
                CloudRestoreOptionsActivity.this.f14375s0.setChecked(CloudRestoreOptionsActivity.this.f14377u0);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$b */
    public class C3227b implements Handler.Callback {
        public C3227b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                int i10 = bundle.getInt(C5963j.f27041j);
                if (i10 != 0) {
                    if (i10 == 3) {
                        C11839m.m70689w("CloudRestoreOptionsActivity", "get gallery space INTFACE_FAIL_LOGOFF");
                        CloudRestoreOptionsActivity.this.m19881L2();
                        C13612b.m81830Y(CloudRestoreOptionsActivity.this);
                    }
                } else if (message.what == 1031) {
                    CloudRestoreOptionsActivity.this.m19949x4(bundle);
                }
            }
            CloudRestoreOptionsActivity.this.f14341K0.removeMessages(message.what);
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$c */
    public class C3228c extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ boolean f14386a;

        public C3228c(boolean z10) {
            this.f14386a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C11839m.m70688i("CloudRestoreOptionsActivity", "checkAgdNetworkProtocol:" + this.f14386a);
                C13207a c13207aM79404c = C13207a.m79404c();
                C13207a.a aVar = C13207a.a.WHITE_LIST;
                if (c13207aM79404c.m79408b(aVar) != this.f14386a) {
                    C13207a.m79404c().m79411f(aVar, this.f14386a);
                }
            } finally {
                CloudRestoreOptionsActivity.this.m19935q4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$d */
    public class C3229d implements InterfaceC14351b {
        public C3229d() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            if (bundle == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1031;
            messageObtain.obj = bundle;
            CloudRestoreOptionsActivity.this.f14341K0.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$e */
    public static class HandlerC3230e extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudRestoreOptionsActivity> f14389a;

        public /* synthetic */ HandlerC3230e(CloudRestoreOptionsActivity cloudRestoreOptionsActivity, C3226a c3226a) {
            this(cloudRestoreOptionsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudRestoreOptionsActivity cloudRestoreOptionsActivityM19834Z2 = CloudRestoreOptionsActivity.m19834Z2(this.f14389a, message);
            if (cloudRestoreOptionsActivityM19834Z2 == null) {
                return;
            }
            C11839m.m70688i("CloudRestoreOptionsActivity", "update check finish: " + message.what);
            if (message.what != 1) {
                cloudRestoreOptionsActivityM19834Z2.m19867A4();
            } else {
                cloudRestoreOptionsActivityM19834Z2.m19898U2(message.obj);
            }
        }

        public HandlerC3230e(CloudRestoreOptionsActivity cloudRestoreOptionsActivity) {
            this.f14389a = new WeakReference<>(cloudRestoreOptionsActivity);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudRestoreOptionsActivity$f */
    public static class HandlerC3231f extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudRestoreOptionsActivity> f14390a;

        public HandlerC3231f(CloudRestoreOptionsActivity cloudRestoreOptionsActivity) {
            this.f14390a = new WeakReference<>(cloudRestoreOptionsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudRestoreOptionsActivity cloudRestoreOptionsActivityM19834Z2 = CloudRestoreOptionsActivity.m19834Z2(this.f14390a, message);
            if (cloudRestoreOptionsActivityM19834Z2 == null) {
                return;
            }
            C11839m.m70688i("CloudRestoreOptionsActivity", "getServiceCountryCode finish: " + message.what);
            if (message.what != 20001) {
                cloudRestoreOptionsActivityM19834Z2.m19867A4();
            } else {
                cloudRestoreOptionsActivityM19834Z2.m19888O4();
            }
        }
    }

    /* renamed from: D4 */
    private void m19809D4(int i10) {
        Toast.makeText(this, getString(i10), 0).show();
    }

    /* renamed from: E3 */
    public static /* synthetic */ boolean m19811E3(String str, CloudRestoreItem cloudRestoreItem) {
        return str.equalsIgnoreCase(cloudRestoreItem.getAppId());
    }

    /* renamed from: F3 */
    public static /* synthetic */ int m19813F3(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75586t(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: G3 */
    public static /* synthetic */ boolean m19815G3(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.isCompatible() && cloudRestoreItem.getAction() != 2;
    }

    /* renamed from: I3 */
    public static /* synthetic */ boolean m19818I3(CloudRestoreItem cloudRestoreItem) {
        return !TextUtils.equals("bmBaseData", cloudRestoreItem.getAppId());
    }

    /* renamed from: I4 */
    private void m19819I4() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f14362f0;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f14362f0 = null;
        }
    }

    /* renamed from: J3 */
    public static /* synthetic */ int m19821J3(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75591y(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: N2 */
    public static boolean m19823N2(CloudRestoreOptionsActivity cloudRestoreOptionsActivity) {
        return cloudRestoreOptionsActivity == null || cloudRestoreOptionsActivity.isFinishing();
    }

    /* renamed from: N3 */
    public static /* synthetic */ boolean m19824N3(CloudRestoreItem cloudRestoreItem) {
        return !TextUtils.equals("bmBaseData", cloudRestoreItem.getAppId());
    }

    /* renamed from: N4 */
    private void m19825N4(CloudRestoreItem cloudRestoreItem, int i10) {
        CloudRestoreItem item;
        CloudRecoveryItem cloudRecoveryItem;
        C11839m.m70688i("CloudRestoreOptionsActivity", "updateLinkedItemAction item " + cloudRestoreItem.getAppName() + " action " + i10);
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null || listM29202r.isEmpty()) {
            return;
        }
        if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
            if (i10 == 0) {
                return;
            }
            for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
                Iterator<CloudRestoreItem> it = this.f14355Y.iterator();
                while (true) {
                    if (it.hasNext()) {
                        CloudRestoreItem next = it.next();
                        if (cloudRestoreItem2.getAppId().equals(next.getAppId())) {
                            next.setAction(i10);
                            break;
                        }
                    }
                }
            }
            return;
        }
        if ("thirdAppData".equals(cloudRestoreItem.getAppId())) {
            if ((i10 != 2 || ((cloudRecoveryItem = this.f14175D) != null && cloudRecoveryItem.getBmDataType() == 2)) && (item = RestoreCache.getInstance().getItem("thirdApp")) != null) {
                CloudRestoreItem item2 = RestoreCache.getInstance().getItem("sysdata");
                List<CloudRestoreItem> statusList = RestoreCache.getInstance().getStatusList("thirdApp");
                for (CloudRestoreItem cloudRestoreItem3 : listM29202r) {
                    Iterator<CloudRestoreItem> it2 = statusList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CloudRestoreItem next2 = it2.next();
                            if (cloudRestoreItem3.getAppId().equals(next2.getAppId())) {
                                next2.setAction(i10);
                                break;
                            }
                        }
                    }
                }
                m19635b2(item);
                m19635b2(item2);
                m19635b2(RestoreCache.getInstance().getItem("bmBaseData"));
                boolean zM19913e3 = m19913e3();
                this.f14347Q = zM19913e3;
                this.f14348R = zM19913e3;
            }
        }
    }

    /* renamed from: O3 */
    public static /* synthetic */ boolean m19826O3(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAction() != 2;
    }

    /* renamed from: P4 */
    private void m19827P4(int i10) {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter;
        RecyclerView recyclerView = this.f14349S;
        if (recyclerView == null || (cloudRestoreOptionsAdapter = this.f14354X) == null) {
            return;
        }
        cloudRestoreOptionsAdapter.m24967V(recyclerView, i10);
    }

    /* renamed from: S3 */
    public static /* synthetic */ boolean m19828S3(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return TextUtils.equals(cloudRestoreItem.getAppId(), cloudRestoreItem2.getAppId());
    }

    /* renamed from: T2 */
    private List<CloudRestoreItem> m19829T2(List<CloudRestoreItem> list) {
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
                if (m19950y3(cloudRestoreItem.getOriBackupAppName())) {
                    cloudRestoreItem.setCompatible(true);
                } else {
                    cloudRestoreItem.setAction(2);
                    cloudRestoreItem.setCompatible(false);
                }
                if (arrayList2 != null) {
                    arrayList2.add(cloudRestoreItem);
                    map.put(cloudRestoreItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.q3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreOptionsActivity.m19811E3(str, (CloudRestoreItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    CloudRestoreItem cloudRestoreItem2 = (CloudRestoreItem) optionalFindFirst.get();
                    List<CloudRestoreItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.r3
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return CloudRestoreOptionsActivity.m19813F3((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
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

    /* renamed from: T3 */
    public static /* synthetic */ boolean m19830T3(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getAction() != 2;
    }

    /* renamed from: U3 */
    public static /* synthetic */ boolean m19831U3(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.getAction() != 2;
    }

    /* renamed from: W2 */
    private void m19832W2() {
        CloudRecoveryItem cloudRecoveryItem;
        CloudBackup3rdIconUtil.downloadVirtualIcon();
        if (m19865z3() || (cloudRecoveryItem = this.f14175D) == null) {
            return;
        }
        CloudBackup3rdIconUtil.download3rdIcons(cloudRecoveryItem.getRecordDeviceId(), this.f14175D.getBackupId(), this.f14175D.getDeviceType());
    }

    /* renamed from: X3 */
    private void m19833X3(View view) {
        if (this.f14175D == null || this.f14354X == null) {
            C11839m.m70689w("CloudRestoreOptionsActivity", "onListItemClick recordItem = null || detailAdapter ==null");
            return;
        }
        int iIntValue = ((Integer) view.getTag()).intValue();
        Object obj = this.f14354X.m24954H().get(iIntValue);
        if (obj instanceof CloudRestoreItem) {
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) obj;
            C11839m.m70688i("CloudRestoreOptionsActivity", "onListItemClick position = " + iIntValue);
            if (cloudRestoreItem == null) {
                C11839m.m70689w("CloudRestoreOptionsActivity", "onListItemClick item = null");
                return;
            }
            String appId = cloudRestoreItem.getAppId();
            appId.hashCode();
            if (!appId.equals("sysdata") && !appId.equals("thirdAppData")) {
                m19835Z3(iIntValue);
            } else {
                if (C0209d.m1226Y0()) {
                    C11839m.m70688i("CloudRestoreOptionsActivity", "onListItemClick isFastClick");
                    return;
                }
                C11839m.m70688i("CloudRestoreOptionsActivity", "onListItemClick thirdAppData or sysdata appId:" + appId);
                Intent intent = new Intent(this, (Class<?>) CloudRestoreChildOptionsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
                bundle.putString("current_app_id", appId);
                bundle.putParcelable("backup_content_detail_list", this.f14175D);
                intent.putExtras(bundle);
                C13230i.m79525e1(intent, "1", "60");
                startActivityForResult(intent, PayStatusCodes.PAY_STATE_TIME_OUT);
            }
            m19933p4(appId);
        }
    }

    /* renamed from: Z2 */
    public static CloudRestoreOptionsActivity m19834Z2(WeakReference<CloudRestoreOptionsActivity> weakReference, Message message) {
        CloudRestoreOptionsActivity cloudRestoreOptionsActivity = weakReference.get();
        if (m19823N2(cloudRestoreOptionsActivity)) {
            return null;
        }
        if (message != null) {
            return cloudRestoreOptionsActivity;
        }
        C11839m.m70687e("CloudRestoreOptionsActivity", "msg is null");
        cloudRestoreOptionsActivity.m19237Q1(R$string.connect_server_fail_msg1);
        return null;
    }

    /* renamed from: Z3 */
    private void m19835Z3(int i10) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "onSubSwitchClick position = " + i10);
        if (!this.f14349S.isEnabled()) {
            C11839m.m70686d("CloudRestoreOptionsActivity", "onSubSwitchClick " + this.f14349S.isEnabled());
            return;
        }
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter == null) {
            C11839m.m70689w("CloudRestoreOptionsActivity", "onSubSwitchClick detailAdapter null");
            return;
        }
        Object obj = cloudRestoreOptionsAdapter.m24954H().get(i10);
        if (obj instanceof CloudRestoreItem) {
            CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) obj;
            int i11 = 2;
            if (cloudRestoreItem.getAction() != 2) {
                this.f14350T.setEnabled(false);
            } else {
                i11 = 0;
            }
            m19951z4(cloudRestoreItem, i11);
            m19845i4();
            m19928m4(this.f14347Q);
            this.f14354X.m5213j();
            m19937r4(cloudRestoreItem.getAppId(), i11 == 0);
        }
    }

    /* renamed from: b4 */
    private void m19836b4() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            return;
        }
        String action = safeIntent.getAction();
        if (action != null && action.equals("restore_notify_click")) {
            this.f14358b0 = true;
        }
        this.f14177F = extras.getString("entrance_of_restore", "2");
        this.f14382z0 = extras.getString("device_count", "");
        this.f14331A0 = extras.getString("record_count", "");
        this.f14332B0 = extras.getString("record_index", "");
        this.f14333C0 = extras.getInt("record_count_type_int");
        this.f14336F0 = extras.getBoolean("backup_is_temp_backup_type", false);
        C11839m.m70688i("CloudRestoreOptionsActivity", "isTempFlag: " + this.f14336F0);
        Parcelable parcelable = extras.getParcelable("backup_content_detail_list");
        if (parcelable instanceof CloudRecoveryItem) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "parseIntent CloudRecoveryItem");
            this.f14175D = (CloudRecoveryItem) parcelable;
            C11839m.m70688i("CloudRestoreOptionsActivity", "CloudRecoveryItem");
        } else if (parcelable instanceof CBRecoveryItem) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "parseIntent CBRecoveryItem");
            this.f14175D = m19900V3((CBRecoveryItem) parcelable);
            C11839m.m70688i("CloudRestoreOptionsActivity", "CBRecoveryItem");
        } else {
            C11839m.m70688i("CloudRestoreOptionsActivity", "recordItem parcelable error");
        }
        if (this.f14175D == null) {
            return;
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "recordItem.isTempBackup(): " + this.f14175D.isTempBackup());
        if (this.f14175D.isTempBackup()) {
            this.f14336F0 = true;
        }
        String strM68633c = C11477c.m68633c(this.f14175D.getDeviceIdd());
        if (strM68633c.contains("&")) {
            String[] strArrSplit = strM68633c.split("&");
            this.f14175D.setRecordDeviceId(strArrSplit[0]);
            this.f14175D.setBackupDeviceId(strArrSplit[1]);
            this.f14175D.setVersion(strArrSplit[2]);
        } else {
            this.f14175D.setRecordDeviceId(strM68633c);
        }
        this.f14338H0 = getString(R$string.backup_time, DateUtils.formatDateTime(this, this.f14175D.getBackupEndTime(), C11842p.m70824j()));
        this.f14352V.setRefurbished(this.f14175D.isRefurbishment());
        C11839m.m70688i("CloudRestoreOptionsActivity", "recordItem.backupRecordLabel: " + this.f14175D.getBackupRecordLabel() + ", bmDataType: " + this.f14175D.getBmDataType());
        this.f14181J = this.f14175D.isNewBmRecord();
    }

    /* renamed from: h3 */
    private void m19843h3() {
        this.f14355Y = RestoreCache.getInstance().getItemList();
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem != null) {
            this.f14379w0 = cloudRecoveryItem.isRefurbishment();
            this.f14380x0 = this.f14175D.isTempBackup();
            this.f14381y0 = this.f14175D.getOccupySpaceType();
        }
        this.f14354X = new CloudRestoreOptionsAdapter(this, this.f14181J, this.f14379w0, this.f14380x0, this.f14381y0);
        m19832W2();
        m19633Z1(this.f14355Y);
        this.f14354X.m24962Q(this);
        this.f14354X.m24964S(this);
        this.f14354X.m24963R(this);
        this.f14354X.m24959N(this.f14175D);
        this.f14354X.m24965T(this);
        this.f14354X.m24960O(this.f14176E);
        this.f14337G0 = m19915f3(this.f14355Y);
        C11839m.m70688i("CloudRestoreOptionsActivity", "initAdapter, getBackupRecordLabel: " + this.f14175D.getBackupRecordLabel() + ", getBmDataType: " + this.f14175D.getBmDataType());
        if (this.f14175D.getBmDataType() == 0) {
            m19940t3();
            m19910c4(this.f14355Y);
            this.f14355Y.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.j3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CloudRestoreOptionsActivity.m19821J3((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                }
            });
            m19912d4(this.f14355Y);
            this.f14355Y.sort(new C12580p.a());
            m19947w4(m19829T2(this.f14355Y));
            this.f14347Q = false;
            this.f14348R = false;
        } else {
            if (this.f14175D.getBmDataType() == 3) {
                this.f14347Q = false;
                this.f14348R = false;
            }
            for (CloudRestoreItem cloudRestoreItem : this.f14355Y) {
                if (TextUtils.equals(cloudRestoreItem.getAppId(), "bmBaseData")) {
                    this.f14335E0 = cloudRestoreItem;
                    if (!cloudRestoreItem.isCompatible()) {
                        this.f14334D0.setVisibility(8);
                    }
                } else if (this.f14175D.getBmDataType() == 1) {
                    cloudRestoreItem.setAction(2);
                }
            }
            this.f14355Y.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.u3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f17758a.m19879K3((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                }
            });
            this.f14355Y.sort(new C12580p.a());
            m19947w4(m19829T2((List) this.f14355Y.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.v3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudRestoreOptionsActivity.m19818I3((CloudRestoreItem) obj);
                }
            }).collect(Collectors.toList())));
            if (this.f14355Y.isEmpty()) {
                this.f14349S.setVisibility(8);
            } else {
                this.f14349S.setVisibility(0);
            }
        }
        this.f14349S.setAdapter(this.f14354X);
    }

    /* renamed from: i4 */
    private void m19845i4() {
        int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem != null) {
            this.f14379w0 = cloudRecoveryItem.isRefurbishment();
            this.f14380x0 = this.f14175D.isTempBackup();
            this.f14381y0 = this.f14175D.getOccupySpaceType();
        }
        boolean z10 = true;
        boolean z11 = this.f14379w0 || (this.f14380x0 && this.f14381y0 == 0);
        List<CloudRestoreItem> listM19903Y2 = m19903Y2();
        if (listM19903Y2 == null) {
            return;
        }
        if (!listM19903Y2.isEmpty()) {
            this.f14346P = listM19903Y2.stream().anyMatch(new C2661b());
        }
        if (iM81077e == 1) {
            this.f14346P = false;
            if (z11) {
                this.f14346P = listM19903Y2.stream().anyMatch(new C2661b());
            }
        }
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = false;
        for (CloudRestoreItem cloudRestoreItem : listM19903Y2) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "refreshMainSwitch appId =" + cloudRestoreItem.getAppId() + " action = " + cloudRestoreItem.getAction());
            if (cloudRestoreItem.isCompatible() && (iM81077e != 1 || z11)) {
                z13 = cloudRestoreItem.getAction() == 0 && z13;
                z14 = cloudRestoreItem.getAction() != 2 || z14;
                z12 = false;
            }
        }
        if (z12) {
            z13 = false;
        }
        this.f14345O = z13;
        HwButton hwButton = this.f14350T;
        if (!z14 && !this.f14348R) {
            z10 = false;
        }
        hwButton.setEnabled(z10);
        m19922j4(this.f14345O, this.f14346P, m19905a3());
    }

    /* renamed from: n4 */
    private void m19851n4() {
        if (this.f14362f0 == null) {
            this.f14362f0 = new NetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f14362f0, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: y4 */
    private void m19863y4() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = new SafeIntent(intent).getExtras()) == null) {
            return;
        }
        this.f14176E = extras.getInt(FamilyShareConstants.ENTRY_TYPE, 2);
    }

    /* renamed from: z3 */
    private boolean m19865z3() {
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem == null) {
            return false;
        }
        String version = cloudRecoveryItem.getVersion();
        return CBSBaseReq.CURRENT_API_VERSION.equalsIgnoreCase(version) || "V4".equalsIgnoreCase(version);
    }

    /* renamed from: A3 */
    public final void m19866A3() {
        C11839m.m70688i("CloudRestoreOptionsActivity", "entryType is :" + this.f14176E);
        if (this.f14176E != 1) {
            if (!this.f14335E0.isCompatible()) {
                if (!this.f14337G0) {
                    this.f14334D0.setVisibility(8);
                    return;
                } else {
                    this.f14367k0.setText(R$string.backup_recover_some_items_not_support_tips);
                    this.f14334D0.setVisibility(0);
                    return;
                }
            }
            if (this.f14337G0) {
                this.f14367k0.setText(R$string.backup_recover_some_items_not_support_tips);
                this.f14334D0.setVisibility(0);
                return;
            } else {
                if (this.f14347Q) {
                    this.f14334D0.setVisibility(8);
                    return;
                }
                String strM19902X2 = m19902X2();
                this.f14367k0.setText(strM19902X2);
                this.f14334D0.setVisibility(TextUtils.isEmpty(strM19902X2) ? 8 : 0);
                return;
            }
        }
        if (!this.f14335E0.isCompatible()) {
            if (!this.f14337G0) {
                this.f14334D0.setVisibility(8);
                return;
            } else {
                this.f14367k0.setText(R$string.backup_recover_some_items_not_support_tips);
                this.f14334D0.setVisibility(0);
                return;
            }
        }
        if (!this.f14347Q) {
            String strM19902X22 = m19902X2();
            this.f14367k0.setText(strM19902X22);
            this.f14334D0.setVisibility(TextUtils.isEmpty(strM19902X22) ? 8 : 0);
        } else if (!this.f14337G0) {
            this.f14334D0.setVisibility(8);
        } else {
            this.f14367k0.setText(R$string.backup_recover_some_items_not_support_tips);
            this.f14334D0.setVisibility(0);
        }
    }

    /* renamed from: A4 */
    public final void m19867A4() {
        if (TextUtils.isEmpty(this.f14175D.getVersion())) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "current recordItem version is null");
            CloudBackupService.getInstance().queryCurrentRecord(this.f14175D.getBackupId());
        } else if (m19865z3()) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "current record version is v3");
            m19914e4();
        } else {
            C11839m.m70688i("CloudRestoreOptionsActivity", "current record version is v2");
            m19873E4();
        }
    }

    /* renamed from: B3 */
    public final void m19868B3() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = new SafeIntent(intent).getExtras()) == null) {
            return;
        }
        int i10 = extras.getInt(FamilyShareConstants.ENTRY_TYPE);
        boolean z10 = extras.getBoolean("new_version_flag", false);
        if (i10 == 1 || z10) {
            return;
        }
        String string = extras.getString("entrance_of_restore");
        Intent intent2 = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
        intent2.putExtra(FamilyShareConstants.ENTRY_TYPE, i10);
        intent2.putExtra("entrance_of_restore", string);
        intent2.putExtra("backup_is_temp_backup_type", this.f14336F0);
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem != null && !TextUtils.isEmpty(cloudRecoveryItem.getBackupDeviceId())) {
            intent2.putExtra("backup_device_id", this.f14175D.getBackupDeviceId());
        }
        startActivity(intent2);
    }

    /* renamed from: B4 */
    public final void m19869B4(long j10) throws IllegalAccessException, IllegalArgumentException {
        String string = getString(R$string.restore_space_tip, C0209d.m1232a0(C0223k.m1524g(this, j10)));
        AlertDialog alertDialog = this.f14371o0;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(string).setNeutralButton(getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.n3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f17681a.m19895R3(dialogInterface, i10);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f14371o0 = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
        } else {
            alertDialog.setMessage(string);
        }
        this.f14349S.setEnabled(false);
        this.f14371o0.show();
    }

    /* renamed from: C3 */
    public void m19870C3() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.phoneservice.renovation.notification");
        C0209d.m1302r2(intent, ICBBroadcastManager.MYHUAWEI_PACKAGE);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("IntentSource", "cloudbackup");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("is_refurbish", String.valueOf(C12591s1.m75931a().m75941k()));
        C13225d.m79490f1().m79591l0("mecloud_backupmain_jump_refurbish", linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_jump_refurbish", "1", "43", "1", "", linkedHashMap);
        C13230i.m79525e1(intent, "1", "85");
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_backup_restore", "1", "85");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "context is null.");
            return;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 10045);
        } else {
            Toast.makeText(this, R$string.cloudbackup_jump_refurbish, 0).show();
            C11839m.m70688i("CloudRestoreOptionsActivity", "refurbish activity is null.");
        }
    }

    /* renamed from: C4 */
    public final void m19871C4() {
        if (this.f14361e0 != null) {
            if (!C0209d.m1333z1(this)) {
                this.f14361e0.m23919i();
                this.f14334D0.setVisibility(8);
                return;
            }
            this.f14361e0.m23914a();
            CloudRecoveryItem cloudRecoveryItem = this.f14175D;
            int bmDataType = cloudRecoveryItem != null ? cloudRecoveryItem.getBmDataType() : 0;
            if (this.f14335E0 != null && bmDataType != 3) {
                m19866A3();
            } else if (!this.f14337G0) {
                this.f14334D0.setVisibility(8);
            } else {
                this.f14367k0.setText(R$string.backup_recover_some_items_not_support_tips);
                this.f14334D0.setVisibility(0);
            }
        }
    }

    /* renamed from: D3 */
    public final /* synthetic */ Object m19872D3() throws Exception {
        if (m19865z3()) {
            m19896R4();
        } else {
            m19893Q4();
        }
        new C13030i().m78490a(3);
        runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.p3
            @Override // java.lang.Runnable
            public final void run() {
                this.f17699a.m19877H4();
            }
        });
        return null;
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "onPermissionGranted");
        if (AbstractC14026a.m84159a(this.f22163b.m69903b(this, this.f22163b.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP)))) {
            runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.m3
                @Override // java.lang.Runnable
                public final void run() throws JSONException, IllegalAccessException, IllegalArgumentException {
                    this.f17672a.m19899V2();
                }
            });
        } else {
            C11839m.m70688i("CloudRestoreOptionsActivity", "onPermissionGranted unGranted is not empty");
        }
    }

    /* renamed from: E4 */
    public final void m19873E4() {
        this.f14355Y = this.f14175D.getItemList();
        m19930o3();
        m19843h3();
        mo19236O1();
        m19845i4();
    }

    /* renamed from: F4 */
    public final void m19874F4() {
        Intent intent = new Intent(this, (Class<?>) OOBERecoveringActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("backup_id", this.f14175D.getBackupId());
        bundle.putString(C6148x2.DEVICE_ID, C11477c.m68636f(this.f14175D.getRecordDeviceId()));
        bundle.putString("backup_version", this.f14175D.getVersion());
        bundle.putString("backup_device_id", this.f14175D.getBackupDeviceId());
        bundle.putInt("device_type", this.f14175D.getDeviceType());
        bundle.putLong("restore_selected_size", m19909c3());
        bundle.putBoolean("is_refurbishment", this.f14175D.isRefurbishment());
        bundle.putBoolean("isNewBmRecord", this.f14175D.isNewBmRecord());
        bundle.putBoolean("is_temp_backup", this.f14175D.isTempBackup());
        bundle.putInt("current_status", 1);
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
        intent.putExtras(bundle);
        C11839m.m70686d("CloudRestoreOptionsActivity", "startActivityForResult RequestCode.OOBE_RECOVERING");
        startActivityForResult(intent, 10010);
    }

    /* renamed from: G4 */
    public final void m19875G4(int i10) {
        C13452e.m80781L().m80909e3(0.0f);
        C13452e.m80781L().m80914f3(1);
        C13466f.m81073d().m81082j("latest_restore_record_bm_type_key", this.f14175D.getBmDataType());
        RestoreProgress.clearCache();
        if (m19865z3()) {
            CloudBackupService.getInstance().restoreV3(this.f14175D.getBackupDeviceId(), this.f14175D.getRecordDeviceId(), this.f14175D.getBackupId(), this.f14176E, this.f14175D.getVersion(), RestoreUtil.getBakCategory(this.f14175D.isRefurbishment(), this.f14175D.isTempBackup()));
        } else {
            CloudBackupService.getInstance().restore(this.f14175D.getRecordDeviceId(), this.f14175D.getDeviceType(), this.f14175D.getBackupId(), this.f14176E);
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        Bundle extras = safeIntent.getExtras();
        boolean z10 = extras != null ? extras.getBoolean("new_version_flag", false) : false;
        Intent intent = new Intent(this, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", i10);
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
        bundle.putLong("restore_selected_size", m19909c3());
        bundle.putBoolean("isNewBmRecord", this.f14181J);
        bundle.putBoolean("new_version_flag", z10);
        bundle.putString("entrance_of_restore", this.f14177F);
        bundle.putParcelable("backup_content_detail_list", this.f14175D);
        intent.putExtras(bundle);
        intent.putExtra("moudle", safeIntent.getStringExtra("moudle"));
        C11839m.m70686d("CloudRestoreOptionsActivity", "startActivity RestoreMainActivity");
        startActivityForResult(intent, RequestManager.NOTIFY_CONNECT_FAILED);
    }

    /* renamed from: H3 */
    public final /* synthetic */ void m19876H3() {
        LinearLayout linearLayout = this.f14374r0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: H4 */
    public final void m19877H4() {
        int i10;
        if (CBAccess.inRestore()) {
            i10 = 2;
        } else {
            i10 = 1;
            RestoreMainActivity.m22045l3(true);
        }
        C12591s1.m75931a().m75945o(this.f14345O);
        RestoreCache.getInstance().setRestoreItems(new ArrayList<>(RestoreCache.getInstance().getItemList()));
        m19875G4(i10);
    }

    /* renamed from: J4 */
    public final void m19878J4(CloudRestoreItem cloudRestoreItem, int i10) {
        CloudRestoreItem item;
        C11839m.m70688i("CloudRestoreOptionsActivity", "update3rdAppLinkedItemAction item " + cloudRestoreItem.getAppName() + " action " + i10);
        if ((i10 != 2 || this.f14175D.getBmDataType() == 3 || this.f14175D.getBmDataType() == 2) && (item = RestoreCache.getInstance().getItem("thirdApp")) != null) {
            CloudRestoreItem item2 = RestoreCache.getInstance().getItem("sysdata");
            for (CloudRestoreItem cloudRestoreItem2 : RestoreCache.getInstance().getStatusList("thirdApp")) {
                if (i10 == 0 && SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName()) && cloudRestoreItem.getOriBackupAppName().equals(cloudRestoreItem2.getAppId())) {
                    cloudRestoreItem2.setAction(i10);
                    cloudRestoreItem.m29182J0();
                }
                if (cloudRestoreItem.getAppId().equals(cloudRestoreItem2.getAppId())) {
                    cloudRestoreItem2.setAction(i10);
                    cloudRestoreItem.m29182J0();
                }
            }
            m19635b2(item);
            m19635b2(item2);
            m19635b2(RestoreCache.getInstance().getItem("bmBaseData"));
            boolean zM19913e3 = m19913e3();
            this.f14347Q = zM19913e3;
            this.f14348R = zM19913e3;
        }
    }

    /* renamed from: K3 */
    public final /* synthetic */ int m19879K3(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return C12580p.m75574h(cloudRestoreItem, cloudRestoreItem2, this.f14181J, this.f14175D.getBmDataType() == 2);
    }

    /* renamed from: K4 */
    public final void m19880K4() {
        CloudRestoreItem item = RestoreCache.getInstance().getItem("thirdApp");
        if (item == null) {
            return;
        }
        m19635b2(item);
        m19635b2(RestoreCache.getInstance().getItem("sysdata"));
        m19635b2(RestoreCache.getInstance().getItem("bmBaseData"));
    }

    /* renamed from: L2 */
    public final void m19881L2() {
        this.f14366j0.setVisibility(this.f14180I ? 8 : 0);
        this.f14365i0.setVisibility(this.f14179H ? 0 : 8);
    }

    /* renamed from: L3 */
    public final /* synthetic */ void m19882L3(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog = this.f14351U;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: L4 */
    public final void m19883L4(final CloudRestoreItem cloudRestoreItem) {
        List<CloudRestoreItem> listM29202r;
        int i10 = 2;
        if (this.f14175D.getBmDataType() == 2 && cloudRestoreItem.is3rdAppType()) {
            CloudRestoreItem item = RestoreCache.getInstance().getItem("thirdApp");
            if (item == null) {
                CloudRestoreItem item2 = RestoreCache.getInstance().getItem("bmBaseData");
                if (item2 == null) {
                    return;
                }
                CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                cloudRestoreItem2.setAppId("thirdApp").setAppName(C2783d.m16079E(this, "thirdApp")).setAppType(3).m29209v0(new ArrayList());
                if (cloudRestoreItem.isHarmonyNext()) {
                    cloudRestoreItem2.m29181I0();
                }
                cloudRestoreItem2.m29182J0();
                if (item2.m29202r() != null) {
                    item2.m29202r().add(cloudRestoreItem2);
                }
                listM29202r = RestoreCache.getInstance().getItem("thirdApp").m29202r();
            } else {
                listM29202r = item.m29202r();
                if (listM29202r == null || listM29202r.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.o3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreOptionsActivity.m19828S3(cloudRestoreItem, (CloudRestoreItem) obj);
                    }
                })) {
                    return;
                }
            }
            if (cloudRestoreItem.isHarmonyNext() && C14333b.f63655g.contains(cloudRestoreItem.getAppId())) {
                return;
            }
            CloudRestoreItem cloudRestoreItem3 = new CloudRestoreItem();
            cloudRestoreItem3.setAppId(cloudRestoreItem.getAppId()).setAppName(cloudRestoreItem.getAppName()).setAppType(cloudRestoreItem.getAppType()).setBmAppDataType(cloudRestoreItem.getBmAppDataType()).setCompatible(cloudRestoreItem.isCompatible()).update(cloudRestoreItem);
            cloudRestoreItem3.m29213z0("thirdApp");
            if (cloudRestoreItem.getAction() != 2 && cloudRestoreItem.isCompatible()) {
                i10 = 0;
            }
            cloudRestoreItem3.setAction(i10);
            listM29202r.add(cloudRestoreItem3);
            CloudRestoreItem item3 = RestoreCache.getInstance().getItem("thirdApp");
            if (item3 != null) {
                item3.m29182J0();
            }
        }
    }

    /* renamed from: M2 */
    public void m19884M2() {
        ConfirmJumpRefurbishDialog confirmJumpRefurbishDialog = this.f14372p0;
        if (confirmJumpRefurbishDialog != null) {
            confirmJumpRefurbishDialog.dismiss();
        }
    }

    /* renamed from: M3 */
    public final /* synthetic */ void m19885M3(DialogInterface dialogInterface, int i10) throws JSONException {
        if (i10 == -2) {
            dialogInterface.dismiss();
            MobileTrafficReport.getInstance().reportRestoreCancel(MobileTrafficReport.RESTORE_OPTION_DIALOG);
        } else {
            if (i10 != -1) {
                return;
            }
            m19941t4();
            MobileTrafficReport.getInstance().setDialogType(MobileTrafficReport.RESTORE_OPTION_DIALOG);
            C10782d.m65634a().m65640g(this);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: M4 */
    public final void m19886M4() {
        List<CloudRestoreItem> listM29202r;
        CloudRestoreItem item;
        CloudRecoveryItem cloudRecoveryItem;
        CloudRestoreItem item2 = RestoreCache.getInstance().getItem("thirdAppData");
        if (item2 == null || (listM29202r = item2.m29202r()) == null || listM29202r.isEmpty() || (item = RestoreCache.getInstance().getItem("thirdApp")) == null) {
            return;
        }
        CloudRestoreItem item3 = RestoreCache.getInstance().getItem("sysdata");
        List<CloudRestoreItem> statusList = RestoreCache.getInstance().getStatusList("thirdApp");
        char c10 = 2;
        for (CloudRestoreItem cloudRestoreItem : listM29202r) {
            Iterator<CloudRestoreItem> it = statusList.iterator();
            while (true) {
                if (it.hasNext()) {
                    CloudRestoreItem next = it.next();
                    if (cloudRestoreItem.getAppId().equals(next.getAppId()) && cloudRestoreItem.getAction() == 0) {
                        next.setAction(cloudRestoreItem.getAction());
                        c10 = 0;
                        break;
                    }
                }
            }
        }
        if (c10 != 2 || ((cloudRecoveryItem = this.f14175D) != null && cloudRecoveryItem.getBmDataType() == 2)) {
            m19635b2(item);
            m19635b2(item3);
            m19635b2(RestoreCache.getInstance().getItem("bmBaseData"));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity
    /* renamed from: O1 */
    public void mo19236O1() {
        super.mo19236O1();
        this.f14356Z.setVisibility(0);
        m19871C4();
    }

    /* renamed from: O2 */
    public final void m19887O2(boolean z10) {
        C12515a.m75110o().m75175e(new C3228c(z10), false);
    }

    /* renamed from: O4 */
    public final void m19888O4() {
        C12515a.m75110o().m75172d(new C13768l(this.f14363g0));
    }

    /* renamed from: P2 */
    public final boolean m19889P2() {
        boolean zM75941k;
        if (1 != this.f14176E) {
            zM75941k = C12591s1.m75931a().m75941k();
            if (zM75941k) {
                if (this.f14372p0 == null) {
                    this.f14372p0 = new ConfirmJumpRefurbishDialog(this, this);
                }
                this.f14372p0.show(getString(R$string.cloudbackup_refurbishing_restore_tips));
            }
        } else {
            zM75941k = false;
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "checkRefurbishment isRefurbishment = " + zM75941k + " ,entryType: " + this.f14176E);
        return zM75941k;
    }

    /* renamed from: P3 */
    public final /* synthetic */ void m19890P3(DialogInterface dialogInterface, int i10) throws JSONException {
        if (i10 == -2) {
            dialogInterface.dismiss();
            return;
        }
        if (i10 != -1) {
            return;
        }
        if (C10782d.m65634a().m65644k(this)) {
            MobileNetTipDialog mobileNetTipDialog = this.f14360d0;
            if (mobileNetTipDialog != null) {
                mobileNetTipDialog.show();
                MobileTrafficReport.getInstance().setMobile(true);
            }
        } else {
            m19941t4();
        }
        dialogInterface.dismiss();
    }

    /* renamed from: Q2 */
    public final boolean m19891Q2() {
        boolean zHasValidTempBackup;
        if (1 != this.f14176E) {
            zHasValidTempBackup = CBAccess.hasValidTempBackup();
            if (zHasValidTempBackup) {
                this.f14373q0 = C4012a.m24641Y(this.f14373q0, this, "CloudRestoreOptionsActivity", null, null, true);
            }
        } else {
            zHasValidTempBackup = false;
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "checkTempBackup hasValidTempBackup = " + zHasValidTempBackup + " ,entryType: " + this.f14176E);
        return zHasValidTempBackup;
    }

    /* renamed from: Q3 */
    public final /* synthetic */ void m19892Q3(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null || !SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName()) || cloudRestoreItem.getAction() == 2) {
            return;
        }
        if (RestoreUtil.isSupportSplitRestore(this.f14175D, cloudRestoreItem.getOriBackupAppName())) {
            cloudRestoreItem.setCompatible(true);
        } else {
            cloudRestoreItem.setAction(2);
            cloudRestoreItem.setCompatible(false);
        }
    }

    /* renamed from: Q4 */
    public final void m19893Q4() {
        List<CloudRestoreStatus> list = (List) new CloudRestoreClient().getActionStatusListV2(RestoreCache.getInstance().getItemList()).values().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.t3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreOptionsActivity.m19830T3((CloudRestoreStatus) obj);
            }
        }).collect(Collectors.toList());
        try {
            C13035n c13035n = new C13035n();
            RestoreProgress.clearCache();
            c13035n.clear();
            c13035n.batchReplace(list);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "v2DataSet error: " + e10.getMessage());
        }
    }

    /* renamed from: R2 */
    public final void m19894R2() {
        C13834f.m82974k(new Callable() { // from class: com.huawei.android.hicloud.ui.activity.z3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f17832a.m19872D3();
            }
        }, null);
    }

    /* renamed from: R3 */
    public final /* synthetic */ void m19895R3(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        this.f14349S.setEnabled(true);
    }

    /* renamed from: R4 */
    public final void m19896R4() {
        List<CloudRestoreStatusV3> list = (List) new C14004e0().m84154f(RestoreCache.getInstance().getItemList()).values().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.s3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreOptionsActivity.m19831U3((CloudRestoreStatusV3) obj);
            }
        }).collect(Collectors.toList());
        try {
            C12816g c12816g = new C12816g();
            RestoreProgress.clearCache();
            c12816g.clear();
            c12816g.batchReplace(list);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "v3DataSet error: " + e10.getMessage());
        }
    }

    /* renamed from: S2 */
    public final void m19897S2(String str) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(this, "manage_cloud_backup_device_record_btn_click", "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put("BACKUP_ID", this.f14175D.getBackupId());
            jSONObjectM79482j.put("BTN_TYPE", str);
        } catch (JSONException e10) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "collectBIEvent json error:" + e10);
        }
        C13222a.m79461c(this, jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "manage_cloud_backup_device_record_btn_click", "1", "43", jSONObjectM79482j);
    }

    /* renamed from: U2 */
    public final void m19898U2(Object obj) {
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "intent is null");
            return;
        }
        Bundle extras = new SafeIntent(intent).getExtras();
        if (extras == null) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "bundle is null");
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) obj;
        Bundle bundle = new Bundle();
        bundle.putString("name", apkUpgradeInfo.getName_());
        bundle.putString("downUrl", apkUpgradeInfo.getDownurl_());
        bundle.putString("sha256", apkUpgradeInfo.getSha256_());
        bundle.putString("version", apkUpgradeInfo.getVersion_());
        bundle.putBoolean("is_from_recovery", extras.getBoolean("is_from_recovery"));
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14358b0 ? 3 : extras.getInt(FamilyShareConstants.ENTRY_TYPE));
        Parcelable parcelable = extras.getParcelable("backup_content_detail_list");
        if (parcelable instanceof CloudRecoveryItem) {
            CloudRecoveryItem cloudRecoveryItem = (CloudRecoveryItem) parcelable;
            bundle.putParcelable("backup_content_detail_list", m19921j3(cloudRecoveryItem));
            C11839m.m70688i("CloudRestoreOptionsActivity", "jump isTemp: " + cloudRecoveryItem.isTempBackup());
        } else {
            if (!(parcelable instanceof CBRecoveryItem)) {
                C11839m.m70687e("CloudRestoreOptionsActivity", "parcelable is unknown");
                return;
            }
            bundle.putParcelable("backup_content_detail_list", parcelable);
            C11839m.m70688i("CloudRestoreOptionsActivity", "jump isTemp: " + this.f14175D.isTempBackup());
        }
        bundle.putString("entrance_of_restore", extras.getString("entrance_of_restore"));
        Intent intent2 = new Intent();
        intent2.putExtras(bundle);
        if (this.f14176E == 1 && !this.f14358b0 && !m19946w3()) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "doHasNewVersionApk jump back to oobe.");
            m19945v4((CloudRecoveryItem) extras.getParcelable("backup_content_detail_list"));
            setResult(11, intent2);
            finish();
            return;
        }
        for (PackageInfo packageInfo : getPackageManager().getInstalledPackages(0)) {
            String str = packageInfo.packageName;
            long longVersionCode = packageInfo.getLongVersionCode();
            if (TextUtils.equals(str, "com.huawei.hicloud")) {
                this.f14342L = longVersionCode;
            }
        }
        if (!m19946w3()) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "go to OOBEUpgradeActivity");
            m19945v4((CloudRecoveryItem) extras.getParcelable("backup_content_detail_list"));
            intent2.setComponent(new ComponentName("com.huawei.hicloud", "com.huawei.android.hicloud.oobe.ui.activity.OOBEUpgradeActivity"));
            try {
                startActivityForResult(intent2, 30003);
                return;
            } catch (Exception e10) {
                C11839m.m70687e("CloudRestoreOptionsActivity", "startActivity exception: " + e10);
                return;
            }
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "The device is an Honor device and the version is later than the preset version.");
        if (C0209d.m1184K0(C0213f.m1377a(), C13843a.m83090l())) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "Download from AppGallery");
            C9908c.m61499D().m61543c0(apkUpgradeInfo.getName_(), apkUpgradeInfo.getDownurl_(), apkUpgradeInfo.getSha256_(), apkUpgradeInfo.getVersion_(), C0213f.m1377a());
        } else {
            C11839m.m70688i("CloudRestoreOptionsActivity", "The application market does not exist,download from OM.");
            HonorVersionInfo honorVersionInfoM61518C = C9908c.m61499D().m61518C(C9908c.m61499D().m61517B());
            if (honorVersionInfoM61518C == null) {
                C11839m.m70688i("CloudRestoreOptionsActivity", "versionInfo item is null.");
                return;
            }
            C9908c.m61499D().m61545e0(honorVersionInfoM61518C);
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "Jump to small package");
        intent2.setComponent(new ComponentName("com.huawei.hicloud", "com.huawei.android.hicloud.oobe.ui.activity.OOBEUpgradeActivity"));
        try {
            startActivity(intent2);
        } catch (Exception e11) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "startActivity exception: " + e11);
        }
    }

    /* renamed from: V2 */
    public final void m19899V2() throws JSONException, IllegalAccessException, IllegalArgumentException {
        if (this.f14176E != 1) {
            long jM19909c3 = m19909c3();
            String strM75684t = C12583q.m75684t();
            if (TextUtils.isEmpty(strM75684t)) {
                strM75684t = "/storage/emulated/0";
            }
            long jM1605d = C0229n.m1605d(strM75684t);
            C11839m.m70688i("CloudRestoreOptionsActivity", "path: " + strM75684t + " avaSpace: " + jM1605d);
            if (jM19909c3 > jM1605d) {
                m19869B4(jM19909c3);
                return;
            }
            CloudRestoreConfirmDialog cloudRestoreConfirmDialog = this.f14352V;
            if (cloudRestoreConfirmDialog != null && !cloudRestoreConfirmDialog.isShowing() && this.f14354X != null) {
                this.f14349S.setEnabled(false);
                this.f14352V.setRecoveryItem(jM19909c3);
                this.f14352V.show();
            }
        } else if (C10782d.m65634a().m65644k(this)) {
            MobileNetTipDialog mobileNetTipDialog = this.f14360d0;
            if (mobileNetTipDialog != null) {
                mobileNetTipDialog.show();
                MobileTrafficReport.getInstance().setMobile(true);
            }
        } else {
            m19941t4();
        }
        m19939s4();
    }

    /* renamed from: V3 */
    public final CloudRecoveryItem m19900V3(CBRecoveryItem cBRecoveryItem) {
        if (cBRecoveryItem == null) {
            return null;
        }
        try {
            CloudRecoveryItem cloudRecoveryItem = (CloudRecoveryItem) C12540b1.m75483a(C11477c.m68631a(C13466f.m81073d().m81079g("oobe_restore_backup_record_key", "")), CloudRecoveryItem.class);
            if (cloudRecoveryItem == null || cloudRecoveryItem.getBackupId() == null || !cloudRecoveryItem.getBackupId().equals(cBRecoveryItem.getBackupId())) {
                C11839m.m70688i("CloudRestoreOptionsActivity", "get last record fail");
                return m19923k3(cBRecoveryItem);
            }
            C11839m.m70688i("CloudRestoreOptionsActivity", "get last record success");
            return cloudRecoveryItem;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CloudRestoreOptionsActivity", "JsonSyntaxException: " + e10.getMessage());
            return m19923k3(cBRecoveryItem);
        }
    }

    /* renamed from: W3 */
    public final void m19901W3() {
        boolean zIsChecked = this.f14375s0.isChecked();
        this.f14375s0.setChecked(!zIsChecked);
        this.f14377u0 = !zIsChecked;
    }

    /* renamed from: X2 */
    public final String m19902X2() {
        CloudRestoreItem cloudRestoreItem = this.f14335E0;
        if (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || this.f14176E != 1) {
            return "";
        }
        ArrayList<BasicDataRestoreUtil.BasicItemInfo> basicPriorityApps = BasicDataRestoreUtil.getBasicPriorityApps(this.f14335E0, false);
        if (basicPriorityApps.size() == 1) {
            return getString(R$string.backup_recover_base_data_not_selected_warn_tips_one, basicPriorityApps.get(0).getAppName());
        }
        if (basicPriorityApps.size() == 2) {
            return getString(R$string.backup_recover_base_data_not_selected_warn_tips_one, getString(R$string.service_names, basicPriorityApps.get(0).getAppName(), basicPriorityApps.get(1).getAppName()));
        }
        if (basicPriorityApps.size() == 3) {
            return getString(R$string.backup_recover_base_data_not_selected_warn_tips_one, getString(R$string.backup_recover_base_data_triple_not_support_toggle, basicPriorityApps.get(0).getAppName(), basicPriorityApps.get(1).getAppName(), basicPriorityApps.get(2).getAppName()));
        }
        if (basicPriorityApps.size() <= 3) {
            return "";
        }
        return getString(R$string.backup_recover_base_data_not_selected_warn_tips_other, getString(R$string.backup_recover_base_data_triple_not_support, basicPriorityApps.get(0).getAppName(), basicPriorityApps.get(1).getAppName(), basicPriorityApps.get(2).getAppName()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity
    /* renamed from: Y1 */
    public void mo19632Y1(Message message) {
        int i10 = message.what;
        if (i10 != 32322) {
            if (i10 != 33019) {
                if (i10 == 32422) {
                    if (C0209d.m1333z1(this)) {
                        m19237Q1(R$string.recovery_no_data_server_error);
                        return;
                    } else {
                        C11839m.m70688i("CloudRestoreOptionsActivity", "net disconnected");
                        m19239S1();
                        return;
                    }
                }
                return;
            }
            Bundle bundle = (Bundle) message.obj;
            String string = bundle.getString(CloudBackupConstant.BACKUP_DEVICE_ID);
            String string2 = bundle.getString("version");
            CloudRecoveryItem cloudRecoveryItem = this.f14175D;
            if (cloudRecoveryItem != null) {
                cloudRecoveryItem.setBackupDeviceId(string);
                this.f14175D.setVersion(string2);
                C11839m.m70688i("CloudRestoreOptionsActivity", "query current record end, backupId: " + this.f14175D.getBackupId() + ", version: " + this.f14175D.getVersion());
            }
            m19867A4();
            return;
        }
        Bundle data = message.getData();
        if (data == null) {
            mo19236O1();
            return;
        }
        CloudRecoveryItem cloudRecoveryItem2 = (CloudRecoveryItem) data.getParcelable("recordItem");
        if (cloudRecoveryItem2 == null) {
            return;
        }
        this.f14180I = cloudRecoveryItem2.isRomCompatible();
        this.f14181J = cloudRecoveryItem2.isNewBmRecord();
        List<CloudRestoreItem> itemList = cloudRecoveryItem2.getItemList();
        CloudRecoveryItem cloudRecoveryItem3 = this.f14175D;
        if (cloudRecoveryItem3 != null) {
            cloudRecoveryItem3.setItemList(itemList);
            m19938s3();
            this.f14175D.setSize(cloudRecoveryItem2.getSize());
            this.f14175D.setNewBmRecord(this.f14181J);
        }
        if (itemList.size() <= 0) {
            this.f14370n0.setVisibility(0);
            this.f14369m0.setVisibility(8);
            mo19236O1();
        } else {
            RestoreCache.getInstance().clear();
            this.f14355Y = itemList;
            m19930o3();
            m19843h3();
            m19845i4();
            mo19236O1();
        }
    }

    /* renamed from: Y2 */
    public final List<CloudRestoreItem> m19903Y2() {
        CloudRestoreItem cloudRestoreItem;
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter;
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter2;
        ArrayList<CloudRestoreItem> itemList = RestoreCache.getInstance().getItemList();
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        return cloudRecoveryItem == null ? itemList : (cloudRecoveryItem.getBmDataType() != 2 || (cloudRestoreOptionsAdapter2 = this.f14354X) == null) ? (this.f14175D.getBmDataType() != 3 || (cloudRestoreOptionsAdapter = this.f14354X) == null) ? (this.f14175D.getBmDataType() != 1 || (cloudRestoreItem = this.f14335E0) == null) ? itemList : cloudRestoreItem.m29202r() : m19908b3(cloudRestoreOptionsAdapter.m24954H()) : m19908b3(cloudRestoreOptionsAdapter2.m24954H());
    }

    /* renamed from: Y3 */
    public final void m19904Y3(View view) {
        List<Object> listM24954H;
        this.f14345O = ((CheckBox) view).isChecked();
        m19924k4();
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter == null || (listM24954H = cloudRestoreOptionsAdapter.m24954H()) == null || listM24954H.isEmpty()) {
            return;
        }
        int i10 = this.f14345O ? 0 : 2;
        for (Object obj : listM24954H) {
            if (obj instanceof CloudRestoreItem) {
                m19951z4((CloudRestoreItem) obj, i10);
            }
        }
        m19926l4(m19905a3());
        this.f14350T.setEnabled(this.f14345O || this.f14348R);
        this.f14354X.m5213j();
        m19928m4(this.f14347Q);
        m19931o4(this.f14345O);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity
    /* renamed from: a2 */
    public void mo19634a2(String str) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "refreshItemIcon");
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter == null) {
            return;
        }
        List<Object> listM24954H = cloudRestoreOptionsAdapter.m24954H();
        if (TextUtils.isEmpty(str) || AbstractC10706e.m65374a(listM24954H)) {
            return;
        }
        int i10 = 0;
        for (Object obj : listM24954H) {
            if ((obj instanceof CloudRestoreItem) && str.equals(((CloudRestoreItem) obj).getAppId())) {
                m19827P4(i10);
                return;
            }
            i10++;
        }
    }

    /* renamed from: a3 */
    public final long m19905a3() {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter == null) {
            return 0L;
        }
        return RestoreUtil.getSizeFromAppData(m19908b3(cloudRestoreOptionsAdapter.m24954H()), this.f14181J, this.f14175D.getBmDataType());
    }

    /* renamed from: a4 */
    public final void m19906a4() {
        C11839m.m70688i("CloudRestoreOptionsActivity", "onViewBasicDataClick");
        Intent intent = new Intent(this, (Class<?>) CloudRestoreChildOptionsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
        bundle.putString("current_app_id", "bmBaseData");
        bundle.putParcelable("backup_content_detail_list", this.f14175D);
        intent.putExtras(bundle);
        C13230i.m79525e1(intent, "1", "60");
        startActivityForResult(intent, PayStatusCodes.PAY_STATE_TIME_OUT);
    }

    @Override // com.huawei.android.hicloud.ui.views.CloudRestoreBasicView.OnBaseItemCheckedListener
    /* renamed from: b0 */
    public void mo19907b0(CloudRestoreItem cloudRestoreItem, boolean z10) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "onItemCheckedChanged hasSelect " + z10);
        this.f14347Q = z10;
        this.f14348R = z10;
        if (cloudRestoreItem == null) {
            C11839m.m70689w("CloudRestoreOptionsActivity", "onSubSwitchClick restoreItem null");
            return;
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "onItemCheckedChanged restoreItem " + cloudRestoreItem.getAppId() + " action " + cloudRestoreItem.getAction());
        if (cloudRestoreItem.isCompatible()) {
            m19951z4(cloudRestoreItem, cloudRestoreItem.getAction());
        } else {
            m19951z4(cloudRestoreItem, 2);
        }
        m19845i4();
        m19928m4(this.f14347Q);
        m19937r4(cloudRestoreItem.getAppId(), cloudRestoreItem.getAction() == 0);
    }

    /* renamed from: b3 */
    public final ArrayList<CloudRestoreItem> m19908b3(List<Object> list) {
        ArrayList<CloudRestoreItem> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) instanceof CloudRestoreItem) {
                arrayList.add((CloudRestoreItem) list.get(i10));
            }
        }
        return arrayList;
    }

    /* renamed from: c3 */
    public final long m19909c3() {
        return RestoreUtil.getSizeFromAppData(RestoreCache.getInstance().getItemList(), this.f14181J, this.f14175D.getBmDataType());
    }

    /* renamed from: c4 */
    public final void m19910c4(List<CloudRestoreItem> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<CloudRestoreItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CloudRestoreItem next = it.next();
            if ("thirdAppData".equals(next.getAppId())) {
                arrayList.addAll(next.m29202r());
                it.remove();
                break;
            }
        }
        list.addAll(arrayList);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        arrayList.add(this.f14356Z);
        arrayList.add(this.f14369m0);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m19911d3() {
        C11839m.m70688i("CloudRestoreOptionsActivity", "begin getServiceCountryCode");
        C14306d.m85217r(this, this.f14364h0, false);
    }

    /* renamed from: d4 */
    public final void m19912d4(List<CloudRestoreItem> list) {
        CloudRestoreItem next;
        Iterator<CloudRestoreItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ("sysdata".equals(next.getAppId())) {
                it.remove();
                break;
            }
        }
        if (next != null) {
            list.add(0, next);
        }
    }

    /* renamed from: e3 */
    public final boolean m19913e3() {
        CloudRestoreItem item;
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem == null || cloudRecoveryItem.getBmDataType() == 3 || this.f14175D.getBmDataType() == 0 || (item = RestoreCache.getInstance().getItem("bmBaseData")) == null || item.m29202r() == null) {
            return false;
        }
        return item.m29202r().stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.y3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreOptionsActivity.m19815G3((CloudRestoreItem) obj);
            }
        });
    }

    /* renamed from: e4 */
    public void m19914e4() {
        boolean zM1333z1 = C0209d.m1333z1(this);
        C11839m.m70686d("CloudRestoreOptionsActivity", "queryV3RecordsDetail isNetWorkConnected =" + zM1333z1);
        if (!zM1333z1) {
            m19239S1();
        } else {
            CloudBackupService.getInstance().showV3RecordsDetail(this.f14175D.getBackupDeviceId(), this.f14175D.getBackupId(), this.f14175D.isNewBmRecord(), this.f14175D.getBackupRecordLabel() == 3);
        }
    }

    /* renamed from: f3 */
    public final boolean m19915f3(List<CloudRestoreItem> list) {
        for (CloudRestoreItem cloudRestoreItem : list) {
            if (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 0) {
                if (cloudRestoreItem != null && !cloudRestoreItem.isCompatible() && !SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                    return true;
                }
            } else if (cloudRestoreItem.m29183K()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f4 */
    public final void m19916f4() throws JSONException, IllegalAccessException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (this.f14175D == null) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "restoreClickEvent recordItem is null");
            return;
        }
        m19897S2("restore_btn");
        if (!C10782d.m65634a().m65652s(this)) {
            m19944v3();
            return;
        }
        List<String> listM69911k = this.f22163b.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (AbstractC14026a.m84159a(this.f22163b.m69903b(this, listM69911k))) {
            m19899V2();
        } else {
            m29128B0(listM69911k);
        }
    }

    /* renamed from: g3 */
    public final void m19917g3() {
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.x3
            @Override // java.lang.Runnable
            public final void run() {
                this.f17799a.m19876H3();
            }
        });
    }

    /* renamed from: g4 */
    public final void m19918g4(boolean z10) {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter != null && cloudRestoreOptionsAdapter.m24954H().size() > 0) {
            ((CloudRestoreOptionHeaderBean) this.f14354X.m24954H().get(0)).setBaseChecked(z10);
            this.f14354X.m5214k(0);
        }
    }

    /* renamed from: h4 */
    public final void m19919h4() {
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem == null) {
            return;
        }
        boolean z10 = cloudRecoveryItem.getBackupRecordLabel() == 3;
        CloudRestoreItem item = RestoreCache.getInstance().getItem("thirdApp");
        if (item == null) {
            return;
        }
        if (z10) {
            item.m29181I0();
        }
        List<CloudRestoreItem> listM29202r = item.m29202r();
        if (listM29202r == null) {
            return;
        }
        listM29202r.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.w3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17787a.m19892Q3((CloudRestoreItem) obj);
            }
        });
        item.m29182J0();
    }

    /* renamed from: i3 */
    public final void m19920i3() {
        C12515a.m75110o().m75172d(new C3226a());
    }

    /* renamed from: j3 */
    public final CBRecoveryItem m19921j3(CloudRecoveryItem cloudRecoveryItem) {
        CBRecoveryItem cBRecoveryItem = new CBRecoveryItem();
        cBRecoveryItem.setBackupId(cloudRecoveryItem.getBackupId());
        cBRecoveryItem.setStartTime(cloudRecoveryItem.getStartTime());
        cBRecoveryItem.setCurrent(cloudRecoveryItem.isCurrent());
        cBRecoveryItem.setDevDisplayName(cloudRecoveryItem.getDevDisplayName());
        cBRecoveryItem.setDeviceIdd(cloudRecoveryItem.getDeviceIdd());
        cBRecoveryItem.setDeviceName(cloudRecoveryItem.getDeviceName());
        cBRecoveryItem.setDeviceType(cloudRecoveryItem.getDeviceType());
        cBRecoveryItem.setItemList(m19932p3(cloudRecoveryItem.getItemList()));
        cBRecoveryItem.setBackupEndTime(cloudRecoveryItem.getBackupEndTime());
        cBRecoveryItem.setSize(cloudRecoveryItem.getSize());
        cBRecoveryItem.setTerminalType(cloudRecoveryItem.getTerminalType());
        cBRecoveryItem.setIndex(cloudRecoveryItem.getIndex());
        return cBRecoveryItem;
    }

    /* renamed from: j4 */
    public final void m19922j4(boolean z10, boolean z11, long j10) {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter != null && cloudRestoreOptionsAdapter.m24954H().size() > 0) {
            CloudRestoreOptionHeaderBean cloudRestoreOptionHeaderBean = (CloudRestoreOptionHeaderBean) this.f14354X.m24954H().get(0);
            cloudRestoreOptionHeaderBean.setMainSwitchCheck(z10);
            cloudRestoreOptionHeaderBean.setMainSwitchEnable(z11);
            cloudRestoreOptionHeaderBean.setSelectedSize(j10);
            cloudRestoreOptionHeaderBean.setBaseChecked(this.f14347Q);
            this.f14354X.m5213j();
        }
    }

    /* renamed from: k3 */
    public final CloudRecoveryItem m19923k3(CBRecoveryItem cBRecoveryItem) {
        CloudRecoveryItem cloudRecoveryItem = new CloudRecoveryItem();
        cloudRecoveryItem.setBackupId(cBRecoveryItem.getBackupId());
        cloudRecoveryItem.setStartTime(cBRecoveryItem.getStartTime());
        cloudRecoveryItem.setCurrent(cBRecoveryItem.isCurrent());
        cloudRecoveryItem.setDevDisplayName(cBRecoveryItem.getDevDisplayName());
        cloudRecoveryItem.setDeviceIdd(cBRecoveryItem.getDeviceIdd());
        cloudRecoveryItem.setDeviceName(cBRecoveryItem.getDeviceName());
        cloudRecoveryItem.setDeviceType(cBRecoveryItem.getDeviceType());
        cloudRecoveryItem.setItemList(m19925l3(cBRecoveryItem.getItemList()));
        cloudRecoveryItem.setBackupEndTime(cBRecoveryItem.getBackupEndTime());
        cloudRecoveryItem.setSize(cBRecoveryItem.getSize());
        cloudRecoveryItem.setTerminalType(cBRecoveryItem.getTerminalType());
        cloudRecoveryItem.setIndex(cBRecoveryItem.getIndex());
        return cloudRecoveryItem;
    }

    /* renamed from: k4 */
    public final void m19924k4() {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter != null && cloudRestoreOptionsAdapter.m24954H().size() > 0) {
            ((CloudRestoreOptionHeaderBean) this.f14354X.m24954H().get(0)).setMainSwitchCheck(this.f14345O);
        }
    }

    /* renamed from: l3 */
    public final List<CloudRestoreItem> m19925l3(List<RestoreItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (RestoreItem restoreItem : list) {
            CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
            cloudRestoreItem.setAppId(restoreItem.getAppId());
            cloudRestoreItem.setAppName(restoreItem.getAppName());
            cloudRestoreItem.setAppType(restoreItem.getAppType());
            cloudRestoreItem.setAction(restoreItem.getAction());
            cloudRestoreItem.setStatus(restoreItem.getStatus());
            cloudRestoreItem.setType(restoreItem.getType());
            cloudRestoreItem.setCurrent(restoreItem.getCurrent());
            cloudRestoreItem.setCount(restoreItem.getCount());
            cloudRestoreItem.setSize(restoreItem.getSize());
            cloudRestoreItem.setAsize(restoreItem.getAsize());
            cloudRestoreItem.m29209v0(m19925l3(restoreItem.getChildList()));
            arrayList.add(cloudRestoreItem);
        }
        return arrayList;
    }

    /* renamed from: l4 */
    public final void m19926l4(long j10) {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter != null && cloudRestoreOptionsAdapter.m24954H().size() > 0) {
            ((CloudRestoreOptionHeaderBean) this.f14354X.m24954H().get(0)).setSelectedSize(j10);
        }
    }

    /* renamed from: m3 */
    public final void m19927m3() {
        this.f14355Y = RestoreCache.getInstance().getItemList();
        m19881L2();
        m19843h3();
        mo19236O1();
    }

    /* renamed from: m4 */
    public final void m19928m4(boolean z10) {
        m19871C4();
    }

    /* renamed from: n3 */
    public final void m19929n3() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "cloudAlbum getCloudFileCount");
            interfaceC9282a.mo58432i(this, this.f14343M);
        }
    }

    /* renamed from: o3 */
    public final void m19930o3() {
        boolean z10 = false;
        for (CloudRestoreItem cloudRestoreItem : this.f14355Y) {
            if (cloudRestoreItem != null) {
                if (HNConstants.DataType.MEDIA.equals(cloudRestoreItem.getAppId())) {
                    z10 = true;
                }
                RestoreCache.getInstance().addItem(cloudRestoreItem);
                m19883L4(cloudRestoreItem);
            }
        }
        m19919h4();
        if (z10) {
            m19881L2();
        } else {
            m19929n3();
        }
    }

    /* renamed from: o4 */
    public void m19931o4(boolean z10) {
        LinkedHashMap linkedHashMapM19630V1 = m19630V1(z10);
        C13225d.m79490f1().m79591l0("cloudbackup_restore_main_all", linkedHashMapM19630V1);
        UBAAnalyze.m29947H("CKC", "cloudbackup_restore_main_all", linkedHashMapM19630V1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        List<CloudRestoreItem> listM29202r;
        C11839m.m70686d("CloudRestoreOptionsActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 30003) {
            if (i11 == 15) {
                C11839m.m70689w("CloudRestoreOptionsActivity", "hwcloud update hwclouddrive fail");
                C0209d.m1326x2();
            }
            setResult(C5963j.f27043l);
            finish();
            return;
        }
        if (i10 == 30002) {
            if (this.f14354X != null) {
                m19845i4();
                m19886M4();
                CloudRecoveryItem cloudRecoveryItem = this.f14175D;
                if (cloudRecoveryItem != null) {
                    this.f14379w0 = cloudRecoveryItem.isRefurbishment();
                    this.f14380x0 = this.f14175D.isTempBackup();
                    this.f14381y0 = this.f14175D.getOccupySpaceType();
                }
                this.f14354X = new CloudRestoreOptionsAdapter(this, this.f14181J, this.f14379w0, this.f14380x0, this.f14381y0);
                if (this.f14175D.getBmDataType() == 2 || this.f14175D.getBmDataType() == 3 || this.f14175D.getBmDataType() == 1) {
                    m19947w4(m19829T2((List) RestoreCache.getInstance().getItemList().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.a4
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return CloudRestoreOptionsActivity.m19824N3((CloudRestoreItem) obj);
                        }
                    }).collect(Collectors.toList())));
                } else {
                    m19947w4(m19829T2(RestoreCache.getInstance().getItemList()));
                }
                this.f14354X.m24964S(this);
                this.f14354X.m24962Q(this);
                this.f14354X.m24965T(this);
                this.f14349S.setAdapter(this.f14354X);
                return;
            }
            return;
        }
        if (i10 == 10010) {
            if (i11 == -1 || i11 == 1001) {
                setResult(-1);
                finish();
                return;
            } else {
                setResult(C5963j.f27043l);
                finish();
                return;
            }
        }
        if (i10 == 20002 || i10 == 20001 || i10 == 20000) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "permission back, onActivityResult");
            return;
        }
        if (i10 != 10000) {
            setResult(C5963j.f27043l);
            finish();
            return;
        }
        C11839m.m70688i("CloudRestoreOptionsActivity", "RESTORE_APP_LIST_REQUEST, onActivityResult");
        if (this.f14175D.getBmDataType() != 0 && (listM29202r = this.f14335E0.m29202r()) != null) {
            this.f14347Q = listM29202r.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.b4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudRestoreOptionsActivity.m19826O3((CloudRestoreItem) obj);
                }
            });
        }
        m19845i4();
        m19880K4();
        m19928m4(this.f14347Q);
        this.f14348R = this.f14347Q;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f14176E != 1) {
            m19868B3();
            finish();
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException, IllegalAccessException, IllegalArgumentException {
        int id2 = view.getId();
        if (id2 == R$id.cb_all) {
            m19904Y3(view);
            return;
        }
        if (id2 == R$id.rl_content) {
            m19833X3(view);
            return;
        }
        if (id2 == R$id.bt_recovery) {
            m19916f4();
            return;
        }
        if (id2 == R$id.no_record_btn) {
            finish();
            return;
        }
        if (id2 == R$id.bt_no_net) {
            C11829c.m70612r1(this);
            return;
        }
        if (id2 == R$id.rl_network_not_connect) {
            if (!C0209d.m1333z1(this)) {
                m19239S1();
                return;
            } else {
                m19238R1();
                m19911d3();
                return;
            }
        }
        if (id2 == R$id.agd_network_layout) {
            m19901W3();
        } else if (id2 == R$id.view_all_basic_data_text) {
            m19906a4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11839m.m70688i("CloudRestoreOptionsActivity", "onConfigurationChanged");
        m19843h3();
        m19845i4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity, com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras != null) {
            this.f14336F0 = extras.getBoolean("backup_is_temp_backup_type", false);
        }
        m19936r3();
        m19238R1();
        mo19005p1();
        m19836b4();
        m19934q3();
        this.f14363g0 = new HandlerC3230e(this, null);
        this.f14364h0 = new HandlerC3231f(this);
        if (this.f14178G) {
            C11839m.m70688i("CloudRestoreOptionsActivity", "onCreate initData from state");
            m19927m3();
        } else {
            if (this.f14175D == null) {
                C11839m.m70688i("CloudRestoreOptionsActivity", "onCreate recordItem == null");
                return;
            }
            RestoreCache.getInstance().clear();
            RestoreCache.getInstance().setIndex(this.f14175D.getIndex());
            RestoreCache.getInstance().setRecordCount(this.f14333C0);
            RestoreCache.getInstance().setEntranceOfRestore(this.f14177F);
            RestoreCache.getInstance().setRefurbishment(this.f14175D.isRefurbishment());
            if (C0209d.m1182J1()) {
                C11839m.m70688i("CloudRestoreOptionsActivity", "onCreate getServiceCountryCode");
                m19911d3();
            } else {
                m19867A4();
            }
        }
        this.f14344N = C0209d.m1195O(this);
        mo22385x1();
        m19920i3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("CloudRestoreOptionsActivity", "onDestroy");
        Handler handler = this.f14364h0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f14363g0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        AlertDialog alertDialog = this.f14351U;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14351U = null;
        }
        CloudRestoreConfirmDialog cloudRestoreConfirmDialog = this.f14352V;
        if (cloudRestoreConfirmDialog != null) {
            cloudRestoreConfirmDialog.dismiss();
            this.f14352V = null;
        }
        AlertDialog alertDialog2 = this.f14371o0;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f14371o0 = null;
        }
        MobileNetTipDialog mobileNetTipDialog = this.f14360d0;
        if (mobileNetTipDialog != null) {
            mobileNetTipDialog.dismiss();
            this.f14360d0 = null;
        }
        ConfirmJumpRefurbishDialog confirmJumpRefurbishDialog = this.f14372p0;
        if (confirmJumpRefurbishDialog != null) {
            confirmJumpRefurbishDialog.dismiss();
            this.f14372p0 = null;
        }
        AlertDialog alertDialog3 = this.f14373q0;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
            this.f14373q0 = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f14349S.setEnabled(true);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudRestoreOptionsAdapter.OnItemClickListener
    public void onItemClick(int i10) {
        C11839m.m70686d("CloudRestoreOptionsActivity", "onItemClick position = " + i10 + " mFontScale = " + this.f14344N);
        m19835Z3(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            m19868B3();
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m19819I4();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "enter onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        boolean z10 = bundle.getBoolean("base_data_is_checked", true);
        this.f14377u0 = bundle.getBoolean("agd_network_is_checked", false);
        m19918g4(z10);
        this.f14347Q = z10;
        this.f14348R = z10;
        this.f14375s0.setChecked(this.f14377u0);
        m19928m4(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70688i("CloudRestoreOptionsActivity", "enter onResume");
        super.onResume();
        m19845i4();
        if (this.f14176E == 1) {
            C11842p.m70751N1(this, getWindow());
        }
        m19851n4();
        m19871C4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBaseRestoreOptionsActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C11839m.m70688i("CloudRestoreOptionsActivity", "enetr onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("base_data_is_checked", this.f14347Q);
        bundle.putBoolean("agd_network_is_checked", this.f14375s0.isChecked());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        CloudRestoreOptionsAdapter cloudRestoreOptionsAdapter = this.f14354X;
        if (cloudRestoreOptionsAdapter == null) {
            C11839m.m70689w("CloudRestoreOptionsActivity", "onTouch detailAdapter null");
            return false;
        }
        Object obj = cloudRestoreOptionsAdapter.m24954H().get(((Integer) view.getTag()).intValue());
        if (obj == null || !(obj instanceof CloudRestoreItem) || ((CloudRestoreItem) obj).isSystemShowModule()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            ((RelativeLayout) view.getParent()).setBackground(getDrawable(R$drawable.hmos_pressed_shape));
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            ((RelativeLayout) view.getParent()).setBackground(null);
        }
        return false;
    }

    /* renamed from: p3 */
    public final List<RestoreItem> m19932p3(List<CloudRestoreItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (CloudRestoreItem cloudRestoreItem : list) {
            RestoreItem restoreItem = new RestoreItem();
            restoreItem.setAppId(cloudRestoreItem.getAppId());
            restoreItem.setAppName(cloudRestoreItem.getAppName());
            restoreItem.setAppType(cloudRestoreItem.getAppType());
            restoreItem.setAction(cloudRestoreItem.getAction());
            restoreItem.setStatus(cloudRestoreItem.getStatus());
            restoreItem.setType(cloudRestoreItem.getType());
            restoreItem.setCurrent(cloudRestoreItem.getCurrent());
            restoreItem.setCount(cloudRestoreItem.getCount());
            restoreItem.setSize(cloudRestoreItem.getSize());
            restoreItem.setAsize(cloudRestoreItem.getAsize());
            restoreItem.setChildList(m19932p3(cloudRestoreItem.m29202r()));
            arrayList.add(restoreItem);
        }
        return arrayList;
    }

    /* renamed from: p4 */
    public void m19933p4(String str) {
        LinkedHashMap linkedHashMapM19629U1 = m19629U1();
        linkedHashMapM19629U1.put("appId", str);
        C13225d.m79490f1().m79591l0("cloudbackup_restore_main_arrow", linkedHashMapM19629U1);
        UBAAnalyze.m29958S("PVC", "cloudbackup_restore_main_arrow", "1", "9", linkedHashMapM19629U1);
    }

    /* renamed from: q3 */
    public final void m19934q3() {
        this.f14339I0 = C12534r.m75443g();
    }

    /* renamed from: q4 */
    public final void m19935q4() {
        String strM80987x0 = C13452e.m80781L().m80987x0();
        if (TextUtils.isEmpty(strM80987x0)) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("userType", strM80987x0);
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        linkedHashMap.put("entrance_of_restore", this.f14177F);
        linkedHashMap.put("record_count", this.f14331A0);
        linkedHashMap.put("record_index", this.f14332B0);
        linkedHashMap.put("device_count", this.f14382z0);
        linkedHashMap.put("agd_agree", String.valueOf(C13207a.m79404c().m79410e()));
        linkedHashMap.put("agd_check", String.valueOf(this.f14377u0));
        linkedHashMap.put("agd_provider", String.valueOf(this.f14378v0));
        linkedHashMap.put("is_oobe", String.valueOf(this.f14176E == 1));
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        String strValueOf = cloudRecoveryItem == null ? "" : String.valueOf(cloudRecoveryItem.getBackupEndTime());
        CloudRecoveryItem cloudRecoveryItem2 = this.f14175D;
        C13466f.m81073d().m81083k("restoringBackupRecordEndTime", cloudRecoveryItem2 == null ? 0L : cloudRecoveryItem2.getBackupEndTime());
        linkedHashMap.put("recordTime", strValueOf);
        C11839m.m70688i("CloudRestoreOptionsActivity", "report entrance_of_restore" + this.f14177F);
        C13225d.m79490f1().m79567R("cloudbackup_restore_entrance", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "cloudbackup_restore_entrance", "1", "16", linkedHashMap);
    }

    /* renamed from: r3 */
    public void m19936r3() {
        if (this.f14336F0) {
            m22365E1(R$string.backup_manager_cloudbackup);
        } else {
            m22365E1(R$string.backup_content_detail_title_select_data);
        }
        m19863y4();
        LayoutInflater.from(this).inflate(R$layout.activity_recovery_optionmain, (ViewGroup) this.f13894y, true);
        this.f13895z.setOnClickListener(this);
        this.f13888s.setOnClickListener(this);
        C11842p.m70874v1(this, this.f13888s);
        this.f14361e0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f14334D0 = (LinearLayout) C12809f.m76829b(this, R$id.ll_backup_warn);
        this.f14356Z = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.restore_child_detail_layout);
        this.f14369m0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.btn_rl);
        this.f14370n0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.no_record_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.cloudbackup_more_detail_tips);
        this.f14365i0 = textView;
        textView.setText(R$string.backup_detail_gallery_restore_content);
        this.f14367k0 = (TextView) C12809f.m76829b(this, R$id.tv_base_tip);
        this.f14368l0 = (TextView) C12809f.m76829b(this, R$id.tv_agd_tip);
        this.f14366j0 = (TextView) C12809f.m76829b(this, R$id.tv_phone_type_tip);
        C11842p.m70721D1(this.f14365i0, 1.0f);
        C11842p.m70721D1(this.f14367k0, 1.0f);
        C11842p.m70721D1(this.f14368l0, 1.0f);
        C11842p.m70721D1(this.f14366j0, 1.0f);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.record_detail_list);
        this.f14349S = recyclerView;
        recyclerView.setNestedScrollingEnabled(true);
        this.f14349S.setLayoutManager(new LinearLayoutManager(this));
        this.f14349S.setOverScrollMode(2);
        this.f14357a0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_checkbox);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.bt_recovery);
        this.f14350T = hwButton;
        C11842p.m70874v1(this, hwButton);
        this.f14350T.setOnClickListener(this);
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.no_record_btn);
        C11842p.m70874v1(this, hwButton2);
        hwButton2.setOnClickListener(this);
        this.f14345O = true;
        CloudRestoreConfirmDialog cloudRestoreConfirmDialog = new CloudRestoreConfirmDialog(this, this, true);
        this.f14352V = cloudRestoreConfirmDialog;
        cloudRestoreConfirmDialog.setOnDismissListener(this);
        this.f14360d0 = new MobileNetTipDialog(this, this.f14340J0, false);
        if (this.f14176E == 1) {
            C11842p.m70745L1(this.f14356Z, this);
            C11842p.m70745L1(this.f13886q, this);
            this.f14352V.setIsOOBE(true);
            this.f14360d0.setIsOOBE(true);
        }
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.agd_network_layout);
        this.f14374r0 = linearLayout;
        linearLayout.setVisibility(0);
        this.f14374r0.setOnClickListener(this);
        this.f14375s0 = (CheckBox) C12809f.m76829b(this, R$id.agd_network_checkbox);
    }

    /* renamed from: r4 */
    public void m19937r4(String str, boolean z10) {
        LinkedHashMap linkedHashMapM19630V1 = m19630V1(z10);
        linkedHashMapM19630V1.put("appId", str);
        C13225d.m79490f1().m79591l0("cloudbackup_restore_main_module", linkedHashMapM19630V1);
        UBAAnalyze.m29947H("CKC", "cloudbackup_restore_main_module", linkedHashMapM19630V1);
    }

    /* renamed from: s3 */
    public final void m19938s3() {
        if (this.f14176E != 1) {
            for (CloudRestoreItem cloudRestoreItem : this.f14175D.getItemList()) {
                cloudRestoreItem.setAction(2);
                if (cloudRestoreItem.m29202r() != null) {
                    m19951z4(cloudRestoreItem, 2);
                    m19942u3(cloudRestoreItem.m29202r());
                }
            }
        }
    }

    /* renamed from: s4 */
    public void m19939s4() {
        LinkedHashMap linkedHashMapM19629U1 = m19629U1();
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem != null) {
            linkedHashMapM19629U1.put("is_refurbish", Boolean.valueOf(cloudRecoveryItem.isRefurbishment()));
            linkedHashMapM19629U1.put("is_temp_backup", Boolean.valueOf(this.f14175D.isTempBackup()));
        }
        C13225d.m79490f1().m79591l0("cloudbackup_restore_main_recovery", linkedHashMapM19629U1);
        UBAAnalyze.m29958S("PVC", "cloudbackup_restore_main_recovery", "1", "9", linkedHashMapM19629U1);
        if (this.f14358b0) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("notify_time", String.valueOf(RestoreNotifyUtil.getInstance().getNotifiedCount(this)));
            C13225d.m79490f1().m79567R("restore_from_restore_notify", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "restore_from_restore_notify", linkedHashMapM19629U1);
        }
    }

    /* renamed from: t3 */
    public final void m19940t3() {
        if (this.f14176E != 1) {
            for (CloudRestoreItem cloudRestoreItem : this.f14355Y) {
                cloudRestoreItem.setAction(2);
                if (cloudRestoreItem.m29202r() != null) {
                    m19951z4(cloudRestoreItem, 2);
                    m19942u3(cloudRestoreItem.m29202r());
                }
            }
        }
    }

    /* renamed from: t4 */
    public final void m19941t4() throws JSONException {
        m19887O2(this.f14375s0.isChecked());
        if (m19889P2() || m19891Q2()) {
            return;
        }
        if (CBAccess.inBackup()) {
            m19809D4(R$string.restore_failed_toast_message);
            return;
        }
        if (!CBAccess.inRestoreWithRetryClearCheck(false)) {
            m19943u4();
            return;
        }
        if (!CBAccess.inCurrentRestoreFirst(this.f14175D.getBackupId())) {
            if (CBAccess.inRestoreFirst()) {
                m19809D4(R$string.restoring_other_record);
                return;
            }
            C11839m.m70686d("CloudRestoreOptionsActivity", "CBAccess.inRestoreLast()=" + CBAccess.inRestoreLast());
            m19809D4(R$string.oobe_in_recovering_alert);
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE"));
        hiCloudSafeIntent.putExtra("notify_type", 4);
        C0209d.m1302r2(hiCloudSafeIntent, getPackageName());
        sendBroadcast(hiCloudSafeIntent);
        Intent intent = new Intent(this, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", 2);
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14176E);
        bundle.putLong("restore_selected_size", m19909c3());
        intent.putExtras(bundle);
        startActivity(intent);
        setResult(C5963j.f27043l);
        finish();
    }

    /* renamed from: u3 */
    public final void m19942u3(List<CloudRestoreItem> list) {
        if (list == null) {
            return;
        }
        for (CloudRestoreItem cloudRestoreItem : list) {
            cloudRestoreItem.setAction(2);
            if (cloudRestoreItem.m29202r() != null) {
                m19942u3(cloudRestoreItem.m29202r());
            }
        }
    }

    /* renamed from: u4 */
    public void m19943u4() throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE"));
        hiCloudSafeIntent.putExtra("notify_type", 4);
        C0209d.m1302r2(hiCloudSafeIntent, getPackageName());
        sendBroadcast(hiCloudSafeIntent);
        RestoreNotifyUtil.getInstance().saveHaveRestored(this, true);
        m19897S2("restore_btn_confirm");
        if (1 != this.f14176E) {
            m19894R2();
        } else {
            C13466f.m81073d().m81082j("latest_restore_record_bm_type_key", this.f14175D.getBmDataType());
            m19874F4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        if (this.f14176E != 1) {
            m19868B3();
        }
        finish();
        return true;
    }

    /* renamed from: v3 */
    public final void m19944v3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (C10782d.m65634a().m65645l()) {
            builder.setMessage(R$string.no_net);
        } else if (C0209d.m1262h2()) {
            builder.setMessage(R$string.no_wlan_dialog_content);
        } else {
            builder.setMessage(R$string.no_wifi);
        }
        builder.setPositiveButton(R$string.cloudbackup_btn_ok_new, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.l3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17664a.m19882L3(dialogInterface, i10);
            }
        });
        this.f14351U = builder.create();
        if (this.f14176E == 1) {
            C11829c.m70585i1(getWindow());
            C11840n.m70694e(this.f14351U);
        }
        this.f14351U.show();
    }

    /* renamed from: v4 */
    public final void m19945v4(CloudRecoveryItem cloudRecoveryItem) {
        String strM75485c;
        if (!(cloudRecoveryItem instanceof CloudRecoveryItem) || (strM75485c = C12540b1.m75485c(cloudRecoveryItem)) == null) {
            return;
        }
        C13466f.m81073d().m81084l("oobe_restore_backup_record_key", C11477c.m68634d(strM75485c));
    }

    /* renamed from: w3 */
    public final boolean m19946w3() {
        return C0209d.m1269j1() && m19948x3();
    }

    /* renamed from: w4 */
    public final void m19947w4(List<CloudRestoreItem> list) {
        if (this.f14354X != null) {
            CloudRestoreItem cloudRestoreItem = this.f14335E0;
            if (cloudRestoreItem != null && cloudRestoreItem.m29202r() != null) {
                this.f14335E0.m29202r().sort(new C12580p.b());
                this.f14335E0.m29202r().sort(new C12580p.a());
            }
            ArrayList arrayList = new ArrayList();
            CloudRestoreOptionHeaderBean cloudRestoreOptionHeaderBean = new CloudRestoreOptionHeaderBean();
            cloudRestoreOptionHeaderBean.setRecordBackupTime(this.f14338H0);
            CloudRecoveryItem cloudRecoveryItem = this.f14175D;
            boolean z10 = false;
            cloudRestoreOptionHeaderBean.setBmDataType(cloudRecoveryItem != null ? cloudRecoveryItem.getBmDataType() : 0);
            cloudRestoreOptionHeaderBean.setBaseDataItem(this.f14335E0);
            cloudRestoreOptionHeaderBean.setRecordVersion(this.f14175D.getVersion());
            cloudRestoreOptionHeaderBean.setHasAppData(list != null && list.size() > 0);
            arrayList.add(cloudRestoreOptionHeaderBean);
            int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
            CloudRecoveryItem cloudRecoveryItem2 = this.f14175D;
            if (cloudRecoveryItem2 != null) {
                this.f14379w0 = cloudRecoveryItem2.isRefurbishment();
                this.f14380x0 = this.f14175D.isTempBackup();
                this.f14381y0 = this.f14175D.getOccupySpaceType();
            }
            if (this.f14379w0 || (this.f14380x0 && this.f14381y0 == 0)) {
                z10 = true;
            }
            if (iM81077e == 1 && !z10) {
                for (CloudRestoreItem cloudRestoreItem2 : list) {
                    if (!cloudRestoreItem2.m29189N()) {
                        cloudRestoreItem2.setAction(2);
                        List<CloudRestoreItem> listM29202r = cloudRestoreItem2.m29202r();
                        if (listM29202r != null) {
                            Iterator<CloudRestoreItem> it = listM29202r.iterator();
                            while (it.hasNext()) {
                                it.next().setAction(2);
                            }
                        }
                    }
                }
            }
            arrayList.addAll(list);
            this.f14354X.m24961P(arrayList);
        }
    }

    /* renamed from: x3 */
    public final boolean m19948x3() {
        return this.f14342L > 120100305;
    }

    /* renamed from: x4 */
    public final void m19949x4(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        m19881L2();
        long j10 = bundle.getLong("cloudPicCount");
        long j11 = bundle.getLong("cloudVideoCount");
        long j12 = j10 + j11;
        C11839m.m70688i("CloudRestoreOptionsActivity", "The photo number of gallery:" + j10 + "The video number of gallery : " + j11);
        this.f14179H = j12 > 0;
        m19881L2();
    }

    /* renamed from: y3 */
    public boolean m19950y3(String str) {
        String str2;
        if (this.f14339I0 == null) {
            return false;
        }
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem == null || !cloudRecoveryItem.isTempBackup()) {
            CloudRecoveryItem cloudRecoveryItem2 = this.f14175D;
            str2 = (cloudRecoveryItem2 == null || !cloudRecoveryItem2.isRefurbishment()) ? "1" : "2";
        } else {
            str2 = "3";
        }
        return this.f14339I0.m75452n(str, str2);
    }

    /* renamed from: z4 */
    public final void m19951z4(CloudRestoreItem cloudRestoreItem, int i10) {
        if (cloudRestoreItem == null) {
            return;
        }
        cloudRestoreItem.setAction(i10);
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null || listM29202r.isEmpty()) {
            if (cloudRestoreItem.is3rdAppType()) {
                m19878J4(cloudRestoreItem, i10);
                return;
            }
            return;
        }
        for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
            if (cloudRestoreItem2 == null || !cloudRestoreItem2.isCompatible()) {
                m19951z4(cloudRestoreItem2, 2);
            } else {
                m19951z4(cloudRestoreItem2, i10);
            }
        }
        cloudRestoreItem.m29182J0();
        m19825N4(cloudRestoreItem, i10);
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloudRestoreConfirmDialog.BackupRecoverOnClickListner, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
        if (i10 == -2) {
            dialogInterface.dismiss();
            return;
        }
        if (i10 != -1) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.f14359c0 <= 600;
        this.f14359c0 = jCurrentTimeMillis;
        if (z10) {
            return;
        }
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        boolean z11 = cloudRecoveryItem != null && cloudRecoveryItem.getBackupRecordLabel() == 3;
        if (this.f14352V.getSelectSize() > 0 && !z11) {
            this.f14352V.dismiss();
            CloudRestoreConfirmDialog cloudRestoreConfirmDialog = new CloudRestoreConfirmDialog(this, new CloudRestoreConfirmDialog.BackupRecoverOnClickListner() { // from class: com.huawei.android.hicloud.ui.activity.c4
                @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloudRestoreConfirmDialog.BackupRecoverOnClickListner, android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i11) throws JSONException {
                    this.f16491a.m19890P3(dialogInterface2, i11);
                }
            }, false);
            this.f14353W = cloudRestoreConfirmDialog;
            cloudRestoreConfirmDialog.setOnDismissListener(this);
            this.f14353W.setSedRecoveryItem(DateUtils.formatDateTime(this, this.f14175D.getBackupEndTime(), C11842p.m70824j()), this.f14354X.m24954H(), z11);
            this.f14353W.show();
        } else if (C10782d.m65634a().m65644k(this)) {
            MobileNetTipDialog mobileNetTipDialog = this.f14360d0;
            if (mobileNetTipDialog != null) {
                mobileNetTipDialog.show();
                MobileTrafficReport.getInstance().setMobile(true);
            }
        } else {
            m19941t4();
        }
        dialogInterface.dismiss();
    }
}
