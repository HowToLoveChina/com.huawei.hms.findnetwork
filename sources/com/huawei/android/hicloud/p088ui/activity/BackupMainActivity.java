package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.InterfaceC0796l;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask;
import com.huawei.android.hicloud.cloudbackup.process.task.C2575c0;
import com.huawei.android.hicloud.cloudbackup.process.task.C2612y;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsFragment;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupMainDeviceAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.TextLinkBar;
import com.huawei.android.hicloud.p088ui.uiextend.backup.SpaceRemindCardView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.AutoBackupFrequencyDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupGuideDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupOptionAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseBackupSwitchAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmJumpRefurbishDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RefurbishUpgradDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.UpgradeMemberConfirmDialog;
import com.huawei.android.hicloud.p088ui.views.CloudBackupStateMainView;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.hicloud.task.simple.CloudBackupOptionTask;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.model.C4867a;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import dj.C9158a;
import fj.C9713b;
import fk.C9721b;
import ge.C9908c;
import gp.C10028c;
import hu.C10342a;
import hu.C10343b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10782d;
import jp.C10906b;
import mk.C11476b;
import mk.C11477c;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0204a0;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0234s;
import p015ak.C0237v;
import p015ak.C0241z;
import p292fn.C9733f;
import p336he.C10155f;
import p387j7.C10718a;
import p422k9.C11019b;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p664u0.C13108a;
import p674ub.C13149f;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p711vl.C13467g;
import p742wj.C13612b;
import p771xd.HandlerC13763g;
import p780xm.C13834f;
import p780xm.InterfaceC13829a;
import p783xp.C13843a;
import p815ym.AbstractC14026a;
import p847zk.C14317j;
import p847zk.C14329v;
import p848zl.C14333b;
import p848zl.C14337f;
import pm.C12173a0;
import pm.C12179f;
import pm.C12199z;
import sk.C12809f;
import tl.C13026e;
import tl.C13029h;
import tl.C13036o;
import vn.C13471c;

/* loaded from: classes3.dex */
public class BackupMainActivity extends CloudBackupStateActivity implements View.OnClickListener, InterfaceC0796l {

    /* renamed from: A0 */
    public BackupMainDeviceAdapter f13561A0;

    /* renamed from: A1 */
    public boolean f13562A1;

    /* renamed from: B0 */
    public LinearLayout f13563B0;

    /* renamed from: B1 */
    public boolean f13564B1;

    /* renamed from: D1 */
    public AlertDialog f13568D1;

    /* renamed from: E1 */
    public AlertDialog f13570E1;

    /* renamed from: G0 */
    public C10718a f13573G0;

    /* renamed from: H0 */
    public C13029h f13575H0;

    /* renamed from: J1 */
    public BackupOptionItem f13580J1;

    /* renamed from: K1 */
    public View f13582K1;

    /* renamed from: L0 */
    public HiCloudExceptionView f13583L0;

    /* renamed from: L1 */
    public NotchFitLinearLayout f13584L1;

    /* renamed from: M0 */
    public NotchFitRelativeLayout f13585M0;

    /* renamed from: N0 */
    public NotchFitRelativeLayout f13587N0;

    /* renamed from: O0 */
    public View f13589O0;

    /* renamed from: P0 */
    public LinearLayout f13591P0;

    /* renamed from: Q0 */
    public TextView f13593Q0;

    /* renamed from: R0 */
    public TextView f13595R0;

    /* renamed from: S0 */
    public TextView f13597S0;

    /* renamed from: T0 */
    public CloudBackupStateMainView f13599T0;

    /* renamed from: U0 */
    public HwProgressBar f13600U0;

    /* renamed from: V0 */
    public TextLinkBar f13601V0;

    /* renamed from: W0 */
    public C10906b f13602W0;

    /* renamed from: X0 */
    public String f13603X0;

    /* renamed from: Z0 */
    public SharedPreferences f13605Z0;

    /* renamed from: a0 */
    public int f13606a0;

    /* renamed from: a1 */
    public AlertDialog f13607a1;

    /* renamed from: g0 */
    public NotchTopFitRelativeLayout f13618g0;

    /* renamed from: h0 */
    public SpaceRemindCardView f13620h0;

    /* renamed from: i0 */
    public View f13622i0;

    /* renamed from: j0 */
    public View f13624j0;

    /* renamed from: k0 */
    public NotchFitLinearLayout f13626k0;

    /* renamed from: k1 */
    public String f13627k1;

    /* renamed from: l0 */
    public UnionSwitch f13628l0;

    /* renamed from: l1 */
    public float f13629l1;

    /* renamed from: m0 */
    public CloseBackupSwitchAlertDialog f13630m0;

    /* renamed from: m1 */
    public RelativeLayout f13631m1;

    /* renamed from: n0 */
    public DeleteOneDeviceBackupRecordDialog f13632n0;

    /* renamed from: n1 */
    public NotchFitRelativeLayout f13633n1;

    /* renamed from: o0 */
    public CutOutProgressDialog f13634o0;

    /* renamed from: p0 */
    public AlertDialog f13636p0;

    /* renamed from: q0 */
    public NotchFitLinearLayout f13638q0;

    /* renamed from: q1 */
    public boolean f13639q1;

    /* renamed from: r0 */
    public NotchFitLinearLayout f13640r0;

    /* renamed from: r1 */
    public String f13641r1;

    /* renamed from: s0 */
    public NotchFitLinearLayout f13642s0;

    /* renamed from: s1 */
    public AlertDialog f13643s1;

    /* renamed from: t0 */
    public LinearLayout f13644t0;

    /* renamed from: u0 */
    public NotchFitLinearLayout f13646u0;

    /* renamed from: v0 */
    public TextView f13648v0;

    /* renamed from: v1 */
    public TextView f13649v1;

    /* renamed from: w0 */
    public NotchFitRelativeLayout f13650w0;

    /* renamed from: w1 */
    public HwProgressBar f13651w1;

    /* renamed from: x0 */
    public HwRecyclerView f13652x0;

    /* renamed from: x1 */
    public CBSpaceDetail f13653x1;

    /* renamed from: y0 */
    public TempBackupRecordsFragment f13654y0;

    /* renamed from: z0 */
    public View f13656z0;

    /* renamed from: z1 */
    public TextView f13657z1;

    /* renamed from: b0 */
    public C0797m f13608b0 = new C0797m(this);

    /* renamed from: c0 */
    public int f13610c0 = 1;

    /* renamed from: d0 */
    public String f13612d0 = "";

    /* renamed from: e0 */
    public String f13614e0 = "";

    /* renamed from: f0 */
    public String f13616f0 = "";

    /* renamed from: C0 */
    public HashMap<String, HashSet<String>> f13565C0 = new HashMap<>();

    /* renamed from: D0 */
    public int f13567D0 = 0;

    /* renamed from: E0 */
    public boolean f13569E0 = false;

    /* renamed from: F0 */
    public boolean f13571F0 = false;

    /* renamed from: I0 */
    public boolean f13577I0 = false;

    /* renamed from: J0 */
    public boolean f13579J0 = false;

    /* renamed from: K0 */
    public int f13581K0 = 0;

    /* renamed from: Y0 */
    public long f13604Y0 = 0;

    /* renamed from: b1 */
    public C13149f f13609b1 = new C13149f();

    /* renamed from: c1 */
    public AutoBackupFrequencyDialog f13611c1 = null;

    /* renamed from: d1 */
    public UpgradeMemberConfirmDialog f13613d1 = null;

    /* renamed from: e1 */
    public ConfirmJumpRefurbishDialog f13615e1 = null;

    /* renamed from: f1 */
    public RefurbishUpgradDialog f13617f1 = null;

    /* renamed from: g1 */
    public BackupGuideDialog f13619g1 = null;

    /* renamed from: h1 */
    public BackupOptionAlertDialog f13621h1 = null;

    /* renamed from: i1 */
    public HandlerC3136i f13623i1 = new HandlerC3136i(this);

    /* renamed from: j1 */
    public boolean f13625j1 = false;

    /* renamed from: o1 */
    public HandlerC13763g f13635o1 = new HandlerC13763g(this);

    /* renamed from: p1 */
    public String f13637p1 = "";

    /* renamed from: t1 */
    public String f13645t1 = "";

    /* renamed from: u1 */
    public String f13647u1 = "";

    /* renamed from: y1 */
    public int f13655y1 = 0;

    /* renamed from: C1 */
    public long f13566C1 = 0;

    /* renamed from: F1 */
    public int f13572F1 = -1;

    /* renamed from: G1 */
    public int f13574G1 = -1;

    /* renamed from: H1 */
    public int f13576H1 = -1;

    /* renamed from: I1 */
    public List<BackupOptionItem> f13578I1 = new ArrayList();

    /* renamed from: M1 */
    public boolean f13586M1 = C13452e.m80781L().m80887a1();

    /* renamed from: N1 */
    public boolean f13588N1 = C13452e.m80781L().m80791C0();

    /* renamed from: O1 */
    public AtomicBoolean f13590O1 = new AtomicBoolean(false);

    /* renamed from: P1 */
    public CloudBackupOptionTask f13592P1 = null;

    /* renamed from: Q1 */
    public Handler.Callback f13594Q1 = new C3128a();

    /* renamed from: R1 */
    public Handler f13596R1 = new HandlerC3129b();

    /* renamed from: S1 */
    public Handler f13598S1 = new HandlerC3130c();

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$a */
    public class C3128a implements Handler.Callback {
        public C3128a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws SecurityException {
            switch (message.what) {
                case 3209:
                    C12590s0.m75755I0(C0213f.m1377a(), message.obj.toString());
                    break;
                case 3210:
                    BackupMainActivity.this.m18825r5(message);
                    break;
                case 32331:
                    BackupMainActivity.this.m18721D6(message);
                    break;
                case 32338:
                    BackupMainActivity.this.m18737I6(message);
                    break;
                case 32999:
                    BackupMainActivity.this.m18779Z5(message);
                    break;
                case 33014:
                    BackupMainActivity.this.m18744K6(message);
                    break;
                case 33016:
                    int iM81091f = C13467g.m81086c().m81091f();
                    BackupMainActivity.this.f13597S0.setText(BackupMainActivity.this.getResources().getQuantityString(R$plurals.auto_backup_frequency, iM81091f, Integer.valueOf(iM81091f)));
                    if (!CBAccess.inBackup()) {
                        BackupMainActivity.this.m19617k2();
                        break;
                    }
                    break;
                case 33018:
                    BackupMainActivity.this.m18752O6((Bundle) message.obj);
                    break;
                case 33020:
                    BackupMainActivity.this.m18717B6();
                    break;
                case 33023:
                    BackupMainActivity.this.m19620n2(message.arg1);
                    if (message.arg1 == 33035) {
                        BackupMainActivity backupMainActivity = BackupMainActivity.this;
                        backupMainActivity.f13568D1 = backupMainActivity.m18730G6(backupMainActivity.f13568D1, null, null);
                        break;
                    }
                    break;
                case 33025:
                    BackupMainActivity.this.m19609S2();
                    break;
                case 33036:
                    C11839m.m70688i("BackupMainActivity", "DELETE_DEVICE");
                    BackupMainActivity.this.m18759R4();
                    break;
                case 33038:
                    BackupMainActivity.this.m18776Y5();
                    break;
                case 33045:
                    BackupMainActivity.this.m18824q5(message);
                    break;
                case 33050:
                    BackupMainActivity.this.m18827s5();
                    break;
                case 33053:
                    BackupMainActivity.this.m18720D5();
                    break;
                case 33055:
                    if (BackupMainActivity.this.f13561A0 != null) {
                        C11839m.m70688i("BackupMainActivity", "refresh deviceListAdapter");
                        BackupMainActivity.this.f13561A0.m5213j();
                        break;
                    }
                    break;
            }
            BackupMainActivity.this.m18747L6(C10028c.m62182c0().m62413x());
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$b */
    public class HandlerC3129b extends Handler {
        public HandlerC3129b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                BackupMainActivity.this.m18716B5(false);
            } else {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    C11839m.m70688i("BackupMainActivity", "start cloud space guide activity");
                    BackupMainActivity.this.startActivityForResult((Intent) obj, 3);
                }
            }
            BackupMainActivity.this.m18747L6(C10028c.m62182c0().m62413x());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$c */
    public class HandlerC3130c extends Handler {
        public HandlerC3130c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            switch (message.what) {
                case 1001:
                    BackupMainActivity.this.f13655y1 = 1;
                    BackupMainActivity.this.f13651w1.setVisibility(8);
                    Object obj = message.obj;
                    if (obj instanceof BackupStorageInfo) {
                        BackupMainActivity.this.m18837w5((BackupStorageInfo) obj, message);
                    }
                    if (BackupMainActivity.this.f13562A1) {
                        BackupMainActivity.this.f13562A1 = false;
                        BackupMainActivity backupMainActivity = BackupMainActivity.this;
                        backupMainActivity.m18718C5(backupMainActivity.f13653x1 == null ? false : BackupMainActivity.this.f13653x1.isOnlyRefurbish(), BackupMainActivity.this.f13653x1 != null ? BackupMainActivity.this.f13653x1.isOnlyHarmonyNext() : false);
                        break;
                    }
                    break;
                case 1002:
                    BackupMainActivity.this.f13651w1.setVisibility(8);
                    BackupMainActivity.this.f13655y1 = 2;
                    if (BackupMainActivity.this.f13562A1) {
                        BackupMainActivity.this.f13562A1 = false;
                        BackupMainActivity backupMainActivity2 = BackupMainActivity.this;
                        backupMainActivity2.m18718C5(false, backupMainActivity2.f13653x1 == null ? false : BackupMainActivity.this.f13653x1.isOnlyHarmonyNext());
                        break;
                    }
                    break;
                case 1003:
                    BackupMainActivity.this.f13651w1.setVisibility(8);
                    BackupMainActivity.this.f13655y1 = 4;
                    if (BackupMainActivity.this.f13562A1) {
                        BackupMainActivity.this.f13562A1 = false;
                        BackupMainActivity backupMainActivity3 = BackupMainActivity.this;
                        backupMainActivity3.m18718C5(false, backupMainActivity3.f13653x1 == null ? false : BackupMainActivity.this.f13653x1.isOnlyHarmonyNext());
                        break;
                    }
                    break;
                default:
                    BackupMainActivity.this.m18716B5(false);
                    BackupMainActivity.this.m18806i6();
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$d */
    public class C3131d extends BackupRecordSingleTask {
        public C3131d() {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask, p616rk.AbstractRunnableC12516b
        public void call() {
            final LinkedList linkedList = new LinkedList();
            C13036o c13036o = new C13036o();
            final HashMap map = new HashMap();
            List<UserBackupInfo.UserDeviceInfo> listM78568h = c13036o.m78568h();
            if (listM78568h != null && !listM78568h.isEmpty() && !TextUtils.isEmpty(listM78568h.get(0).getDeviceName())) {
                C11839m.m70688i("BackupMainActivity", "has current device");
                UserBackupInfo.UserDeviceInfo userDeviceInfo = listM78568h.get(0);
                String strM18785c5 = BackupMainActivity.this.m18785c5(userDeviceInfo.getDeviceName());
                C4867a c4867a = new C4867a(userDeviceInfo);
                linkedList.add(c4867a);
                HashSet hashSet = new HashSet();
                hashSet.add(c4867a.getDeviceId());
                map.put(c4867a.getDeviceCategory() + "_" + strM18785c5, hashSet);
                BackupMainActivity.this.f13645t1 = c4867a.getTerminalType();
                BackupMainActivity.this.f13647u1 = c4867a.getDeviceCategory();
            }
            final int size = linkedList.size() + c13036o.queryCount();
            List<UserBackupInfo.UserDeviceInfo> listM78565e = c13036o.m78565e(BackupMainActivity.this.f13610c0 == 2 ? size - linkedList.size() : 5 - linkedList.size());
            if (listM78565e != null && listM78565e.size() > 0) {
                for (UserBackupInfo.UserDeviceInfo userDeviceInfo2 : BackupMainActivity.this.m18755P6(listM78565e)) {
                    String strM18785c52 = BackupMainActivity.this.m18785c5(userDeviceInfo2.getDeviceName());
                    C4867a c4867a2 = new C4867a(userDeviceInfo2);
                    if (!linkedList.contains(c4867a2)) {
                        linkedList.add(c4867a2);
                        String str = c4867a2.getDeviceCategory() + "_" + strM18785c52;
                        if (map.containsKey(str)) {
                            HashSet hashSet2 = (HashSet) map.get(str);
                            if (hashSet2 != null) {
                                hashSet2.add(c4867a2.getDeviceId());
                            }
                        } else {
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add(c4867a2.getDeviceId());
                            map.put(str, hashSet3);
                        }
                    }
                }
            }
            final LinkedList linkedList2 = new LinkedList();
            List<UserBackupInfo.UserDeviceInfo> listM78572l = c13036o.m78572l();
            LinkedList linkedList3 = new LinkedList();
            if (listM78572l != null && !listM78572l.isEmpty()) {
                C11839m.m70688i("BackupMainActivity", "has current temp device");
                C4867a c4867a3 = new C4867a(listM78572l.get(0));
                linkedList3.add(c4867a3);
                linkedList2.addAll(0, linkedList3);
                BackupMainActivity.this.f13645t1 = c4867a3.getTerminalType();
                BackupMainActivity.this.f13647u1 = c4867a3.getDeviceCategory();
            }
            final int iM78571k = c13036o.m78571k() + linkedList2.size();
            int size2 = 5 - linkedList2.size();
            if (BackupMainActivity.this.f13654y0.m24324b() == 2) {
                size2 = iM78571k - linkedList2.size();
            }
            List<UserBackupInfo.UserDeviceInfo> listM78570j = c13036o.m78570j(size2);
            if (listM78570j != null && !listM78570j.isEmpty()) {
                Iterator it = BackupMainActivity.this.m18755P6(listM78570j).iterator();
                while (it.hasNext()) {
                    C4867a c4867a4 = new C4867a((UserBackupInfo.UserDeviceInfo) it.next());
                    if (!linkedList2.contains(c4867a4)) {
                        linkedList2.add(c4867a4);
                    }
                }
                C11839m.m70688i("BackupMainActivity", "sortOtherDevicePolicy tempDeviceInfoList completed, other device size = " + linkedList2.size());
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.y
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f17807a.m18845d(linkedList, size, map, linkedList2, iM78571k);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m18845d(LinkedList linkedList, int i10, HashMap map, LinkedList linkedList2, int i11) throws Resources.NotFoundException {
            BackupMainActivity.this.m18812l6(linkedList, i10, map);
            BackupMainActivity.this.m18822p6(linkedList2, i11);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$e */
    public class C3132e implements CloudBackupOptionTask.BackupCallback {
        public C3132e() {
        }

        @Override // com.huawei.android.hicloud.task.simple.CloudBackupOptionTask.BackupCallback
        /* renamed from: a */
        public void mo18098a() {
            C11839m.m70687e("BackupMainActivity", "initBackupOption failed");
            BackupMainActivity.this.m19605O2(false);
            BackupMainActivity.this.m19608R2();
        }

        @Override // com.huawei.android.hicloud.task.simple.CloudBackupOptionTask.BackupCallback
        public void onSuccess() {
            C11839m.m70688i("BackupMainActivity", "initBackupOption success");
            BackupMainActivity.this.m19605O2(true);
            BackupMainActivity.this.m19606P2();
            BackupMainActivity backupMainActivity = BackupMainActivity.this;
            backupMainActivity.f13574G1 = backupMainActivity.f13592P1.m18077A();
            BackupMainActivity backupMainActivity2 = BackupMainActivity.this;
            backupMainActivity2.f13572F1 = backupMainActivity2.f13592P1.m18097z();
            BackupMainActivity backupMainActivity3 = BackupMainActivity.this;
            backupMainActivity3.f13576H1 = backupMainActivity3.f13574G1 - BackupMainActivity.this.f13572F1;
            BackupMainActivity backupMainActivity4 = BackupMainActivity.this;
            backupMainActivity4.f13578I1 = backupMainActivity4.f13592P1.m18093s();
            C11839m.m70688i("BackupMainActivity", "allDataList: " + BackupMainActivity.this.f13578I1.stream().map(new C2575c0()).collect(Collectors.toList()));
            BackupMainActivity.this.m18795f5();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$f */
    public class C3133f implements CloseBackupSwitchAlertDialog.DialogCallBack {
        public C3133f() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloseBackupSwitchAlertDialog.DialogCallBack
        public void cancel() {
            BackupMainActivity.this.m18728G4();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloseBackupSwitchAlertDialog.DialogCallBack
        public void confirm() {
            BackupMainActivity.this.m18759R4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$g */
    public class C3134g implements DeleteOneDeviceBackupRecordDialog.ClickCallback {
        public C3134g() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onCancelDelete() {
            BackupMainActivity.this.m18728G4();
            BackupMainActivity.this.m18770V4();
            BackupMainActivity.this.m18773X4();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.DeleteOneDeviceBackupRecordDialog.ClickCallback
        public void onDeleteConfirmed() {
            BackupMainActivity.this.m18773X4();
            BackupMainActivity.this.m18768U4();
            BackupMainActivity.this.m18727F6();
            CloudBackupService.getInstance().deleteAllBaseAppModule(4);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$h */
    public class C3135h extends AbstractC12367d {
        public C3135h() {
        }

        /* renamed from: d */
        public static /* synthetic */ boolean m18847d(BackupOptionItem backupOptionItem) {
            return !backupOptionItem.getBackupSwitch();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (BackupMainActivity.this.f13578I1 == null) {
                C11839m.m70688i("BackupMainActivity", "allShowBackupOptionItems is empty");
                return;
            }
            List list = (List) BackupMainActivity.this.f13578I1.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.z
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupMainActivity.C3135h.m18847d((BackupOptionItem) obj);
                }
            }).sorted(Comparator.comparingLong(new C2612y()).reversed()).collect(Collectors.toList());
            C11839m.m70688i("BackupMainActivity", "nonBackupOptionDataOffList: " + list.stream().map(new C2575c0()).collect(Collectors.toList()));
            BackupMainActivity.this.f13576H1 = list.size();
            C11839m.m70688i("BackupMainActivity", "getFullBackupOnCount, fullBackupOnCount: " + BackupMainActivity.this.f13572F1 + " getNoBackupCount, noBackupCount: " + BackupMainActivity.this.f13576H1);
            BackupMainActivity.this.m18811l5(list);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupMainActivity$i */
    public class HandlerC3136i extends Handler {

        /* renamed from: a */
        public WeakReference<Activity> f13666a;

        public HandlerC3136i(Activity activity) {
            this.f13666a = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity = this.f13666a.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            int i10 = message.what;
            if (i10 == 2001) {
                BackupMainActivity.this.m18671b5(message.obj);
                return;
            }
            if (i10 != 2101 && i10 != 20000) {
                if (i10 == 6019) {
                    BackupMainActivity.this.m18669a5(message.obj);
                    return;
                }
                if (i10 != 6020) {
                    if (i10 == 7050) {
                        C11839m.m70688i("BackupMainActivity", "textLink handler is fail");
                        if (BackupMainActivity.this.f13601V0 != null) {
                            BackupMainActivity.this.f13601V0.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    if (i10 != 7051) {
                        return;
                    }
                    Object obj = message.obj;
                    if (obj instanceof C10906b) {
                        BackupMainActivity.this.f13602W0 = (C10906b) obj;
                        BackupMainActivity.this.m18841y5();
                        return;
                    }
                    return;
                }
            }
            C11839m.m70688i("BackupMainActivity", "get user package fail, or get available grade packages fail, or get account user info fail");
            BackupMainActivity.this.f13600U0.setVisibility(8);
        }
    }

    /* renamed from: N5 */
    public static /* synthetic */ void m18647N5(DialogInterface dialogInterface, int i10) {
        C13225d.m79490f1().m79585f0("mecloud_backup_main_no_data_switch_cancel_click", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backup_main_no_data_switch_cancel_click", "1", "43");
    }

    /* renamed from: N6 */
    private void m18648N6(int i10) {
        Toast.makeText(this, getString(i10), 0).show();
    }

    /* renamed from: O4 */
    public static boolean m18650O4(Context context, String str) {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i("BackupMainActivity", "restoreStatus = " + iM80916g0);
        if (iM80916g0 == 0 || iM80916g0 == 3 || iM80916g0 == 8 || iM80916g0 == 5) {
            return false;
        }
        if (CBAccess.inRestoreTask()) {
            m18655R6(context, 2, iM80916g0, str);
            C11839m.m70688i("BackupMainActivity", "inRestore = " + CBAccess.inRestore());
        } else {
            if (C0209d.m1150A1(context)) {
                if (iM80916g0 == 1) {
                    C13452e.m80781L().m80914f3(7);
                } else if (iM80916g0 != 2) {
                    C13452e.m80781L().m80914f3(6);
                }
            } else if (iM80916g0 == 1) {
                C13452e.m80781L().m80914f3(7);
            }
            m18655R6(context, 2, iM80916g0, str);
        }
        return true;
    }

    /* renamed from: O5 */
    public static /* synthetic */ void m18651O5(DialogInterface dialogInterface) {
        C13225d.m79490f1().m79585f0("mecloud_backup_main_no_data_switch_cancel_click", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backup_main_no_data_switch_cancel_click", "1", "43");
    }

    /* renamed from: R6 */
    public static void m18655R6(Context context, int i10, int i11, String str) {
        Intent intent = new Intent(context, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", i10);
        bundle.putInt("restore_status", i11);
        intent.putExtras(bundle);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("moudle", str);
        }
        context.startActivity(intent);
        if (context instanceof BackupMainActivity) {
            ((BackupMainActivity) context).finish();
        }
    }

    /* renamed from: T5 */
    public static /* synthetic */ boolean m18658T5(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        return userDeviceInfo.getLastbackupTime() > 0;
    }

    /* renamed from: U5 */
    public static /* synthetic */ int m18660U5(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo2.getLastbackupTime() - userDeviceInfo.getLastbackupTime() > 0) {
            return 1;
        }
        return userDeviceInfo2.getLastbackupTime() - userDeviceInfo.getLastbackupTime() < 0 ? -1 : 0;
    }

    /* renamed from: V5 */
    public static /* synthetic */ boolean m18662V5(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        return userDeviceInfo.getLastbackupTime() == 0;
    }

    /* renamed from: W5 */
    public static /* synthetic */ int m18664W5(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo2.getSize() - userDeviceInfo.getSize() > 0) {
            return 1;
        }
        return userDeviceInfo2.getSize() - userDeviceInfo.getSize() < 0 ? -1 : 0;
    }

    /* renamed from: a5 */
    public void m18669a5(Object obj) {
        C11839m.m70688i("BackupMainActivity", "deal get available grade packages begin");
        String strM81079g = C13466f.m81073d().m81079g("gradeCode", "");
        int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(strM81079g);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            if (!(obj instanceof GetAvailableGradePackagesResp)) {
                C11839m.m70688i("BackupMainActivity", "GetAvailableGradePackagesResp cast error");
                return;
            }
            GetAvailableGradePackagesResp getAvailableGradePackagesResp = (GetAvailableGradePackagesResp) obj;
            for (FilterAvailabalGradePackage filterAvailabalGradePackage : C11296s.m67831o(getAvailableGradePackagesResp.getPackageGrades(), getAvailableGradePackagesResp.getSpacePackages(), getAvailableGradePackagesResp.getServerTime())) {
                String gradeCode = filterAvailabalGradePackage.getGradeCode();
                int gradeMinFrequency2 = CloudBackupUtil.getGradeMinFrequency(gradeCode);
                PackageGrades packageGrades = filterAvailabalGradePackage.getPackageGrades();
                String gradeName = packageGrades.getGradeName();
                if (!strM81079g.equals(gradeCode) && gradeMinFrequency2 < gradeMinFrequency) {
                    if (C13452e.m80781L().m80887a1()) {
                        gradeName = C0223k.m1529l(gradeName + " " + C0223k.m1524g(this, packageGrades.getCapacity()));
                    }
                    map.put(gradeCode, gradeName);
                    map2.put(gradeCode, C0223k.m1524g(this, packageGrades.getCapacity()));
                }
                C11839m.m70688i("BackupMainActivity", "available gradeCode: " + gradeCode + ", gradeName: " + gradeName);
            }
            C11839m.m70688i("BackupMainActivity", "deal get available grade packages end");
            this.f13600U0.setVisibility(8);
            AutoBackupFrequencyDialog autoBackupFrequencyDialog = this.f13611c1;
            if (autoBackupFrequencyDialog == null) {
                this.f13611c1 = new AutoBackupFrequencyDialog(this, map, map2);
            } else {
                autoBackupFrequencyDialog.setGradeCodeName(map);
                this.f13611c1.setBasicGradeCodeName(map2);
            }
            if (isFinishing()) {
                return;
            }
            this.f13611c1.show();
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("gradeCode", C13466f.m81073d().m81079g("gradeCode", ""));
            linkedHashMapM79499C.put("backup_frequency_dialog_exposure", String.valueOf(true));
            C13225d.m79490f1().m79567R("auto_backup_frequency_selected", linkedHashMapM79499C);
            UBAAnalyze.m29947H("CKC", "auto_backup_frequency_selected", linkedHashMapM79499C);
        } catch (ClassCastException e10) {
            C11839m.m70688i("BackupMainActivity", "deal get available grade packages failed: " + e10.toString());
        }
    }

    /* renamed from: b5 */
    public void m18671b5(Object obj) {
        if (obj == null || !(obj instanceof UserPackage)) {
            return;
        }
        MemGradeRights gradeRights = ((UserPackage) obj).getGradeRights();
        if (gradeRights == null) {
            C11839m.m70689w("BackupMainActivity", "gradeRights is null.");
            this.f13600U0.setVisibility(8);
            return;
        }
        C12590s0.m75926y2(this.f13637p1, gradeRights.getGradeCode(), "dealGetUserPackageSuccess");
        if (this.f13625j1) {
            C11839m.m70688i("BackupMainActivity", "begin get available grade packages task");
            Filter filter = new Filter();
            filter.setShowPlace(2);
            C9713b.m60566c().m60567a(this.f13623i1, filter, null, false, new ChannelInfo());
        }
    }

    /* renamed from: b6 */
    public static void m18672b6(String str, String str2) {
        m18694q6();
        C13225d.m79490f1().m79597u0(str + ": open switch", C13471c.f.ALL_SWITCH, true);
        CloudBackupService.getInstance().cloudbackupOpr(true);
        C13225d.m79490f1().m79558J0(str2);
        C10028c.m62182c0().m62202D2("EnterClosedCloudBackupTimes", 0);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws JSONException, IllegalAccessException, IllegalArgumentException {
        if (C13612b.m81829B().m81886t(this)) {
            C11839m.m70688i("BackupMainActivity", "st is invalid");
            compoundButton.setChecked(!z10);
            return;
        }
        if (!this.f13569E0) {
            C11839m.m70688i("BackupMainActivity", "switch do not initialized yet");
            return;
        }
        if (R$id.backup_main_switch_btn == compoundButton.getId()) {
            m18826r6(z10);
            if (!z10) {
                m18753P4();
                return;
            }
            if (CBAccess.inBackup()) {
                C11839m.m70688i("BackupMainActivity", "onCheckedChanged isChecked in backup");
            }
            m18756Q4();
            m18816n6("openBackupSwitch");
        }
    }

    /* renamed from: q6 */
    public static void m18694q6() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("backup_key");
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
    }

    /* renamed from: z6 */
    private void m18713z6() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Bundle extras = new SafeIntent(intent).getExtras();
        this.f13606a0 = 2;
        if (extras != null) {
            if ("11".equals(extras.getString("hi_anlytics_type_value_refer"))) {
                new BackupNotificationManager(this).cancelNotification(24);
            } else {
                this.f13606a0 = extras.getInt(FamilyShareConstants.ENTRY_TYPE, 2);
            }
        }
        if (1 != this.f13606a0 || getActionBar() == null) {
            return;
        }
        getActionBar().hide();
    }

    /* renamed from: A5 */
    public final boolean m18714A5() {
        long j10 = this.f13566C1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f13566C1 = jCurrentTimeMillis;
        return jCurrentTimeMillis - j10 <= 1000;
    }

    /* renamed from: A6 */
    public final void m18715A6() {
        int iM70770U = (C11842p.m70771U0() && C11842p.m70774V0(this)) ? C11842p.m70770U(this) : C11842p.m70713B(this);
        this.f13595R0.setMaxWidth(iM70770U);
        this.f13657z1.setMaxWidth(iM70770U);
    }

    /* renamed from: B5 */
    public final void m18716B5(boolean z10) {
        if (z10) {
            this.f13622i0.setVisibility(0);
            this.f13624j0.setVisibility(8);
        } else {
            this.f13622i0.setVisibility(8);
            this.f13624j0.setVisibility(0);
        }
    }

    /* renamed from: B6 */
    public final void m18717B6() {
        if (this.f13575H0 != null) {
            CloudBackupService.getInstance().updateShowTag(this.f13575H0);
            this.f13575H0 = null;
        }
        mo18764T2();
    }

    /* renamed from: C5 */
    public final void m18718C5(boolean z10, boolean z11) {
        if (this.f13655y1 == 0) {
            C11839m.m70688i("BackupMainActivity", "Getting device storage size");
            return;
        }
        if (!C0209d.m1181J0(this)) {
            C11839m.m70688i("BackupMainActivity", "isActivityRunningForeground false return");
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", "1");
        C13225d.m79490f1().m79591l0("backup_main_click_backup_detail", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "backup_main_click_backup_detail", "1", "43");
        Intent intent = new Intent(this, (Class<?>) CloudSpaceBackupDetailActivity.class);
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        CBSpaceDetail cBSpaceDetail = this.f13653x1;
        if (cBSpaceDetail != null && (z10 || cBSpaceDetail.getSize() > 0 || this.f13653x1.getLastbackupTime() > 0)) {
            C11839m.m70688i("BackupMainActivity", "jumpDeviceManager " + this.f13653x1.getSize());
            backupDetailItem.m16373a(this.f13653x1);
            backupDetailItem.m16372M(C0223k.m1524g(this, backupDetailItem.m16382l()));
            C11839m.m70688i("BackupMainActivity", "jumpDeviceManager:backupItem.getSize() " + backupDetailItem.m16382l());
            backupDetailItem.m16368A(String.valueOf(this.f13604Y0));
        }
        intent.putExtra("backup_item_param", backupDetailItem);
        intent.putExtra("from_backup_main_page", true);
        intent.putExtra("isOnlyRefurbish", z10);
        intent.putExtra("isOnlyHarmonyNext", z11);
        intent.putExtra("terminalType", backupDetailItem.m16383m());
        intent.putExtra("backup_device_space_result", this.f13655y1);
        intent.putExtra("backup_delete_report_entry", 1);
        startActivityForResult(intent, 10024);
    }

    /* renamed from: C6 */
    public final void m18719C6(String str) {
        BackupOptionAlertDialog backupOptionAlertDialog = new BackupOptionAlertDialog(this);
        this.f13621h1 = backupOptionAlertDialog;
        backupOptionAlertDialog.setMessage(str);
        this.f13621h1.show();
    }

    /* renamed from: D5 */
    public final void m18720D5() throws SecurityException {
        boolean zM1245d1 = C0209d.m1245d1(this, BackupMainActivity.class.getName());
        this.f14145O = CBAccess.hasManualBackupOrRestore();
        this.f13639q1 = m19625x2();
        C11839m.m70688i("BackupMainActivity", "jumpToDetail check canEnterDetail = " + this.f13639q1 + " isManual = " + this.f14145O + " foreground = " + zM1245d1 + " isBasicBusiness = " + this.f13588N1);
        if (this.f13639q1 && this.f14145O && zM1245d1) {
            String string = getString(R$string.backup_prepareing_state_tip);
            if (!this.f13588N1) {
                Intent intent = new Intent(this, (Class<?>) CloudBackupDetailStateActivity.class);
                intent.putExtra("entry_source", "entry_backup_main_auto");
                startActivity(intent);
            }
            m19601I2(this, string);
        }
    }

    /* renamed from: D6 */
    public final void m18721D6(Message message) {
        C11839m.m70686d("BackupMainActivity", "CALLBACK_BACKUP_TIMES is " + message.arg1);
        if (this.f13571F0) {
            return;
        }
        this.f13571F0 = true;
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C11839m.m70688i("BackupMainActivity", "finish permissionSet requestCode: " + i10);
        m18766T6(i10);
    }

    /* renamed from: E5 */
    public final void m18722E5() {
        try {
            String strM79270H = C13195l.m79270H(this);
            if (TextUtils.isEmpty(strM79270H)) {
                C11839m.m70687e("BackupMainActivity", "hmsPackage is invalid!");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("hwid://com.huawei.hwid/DeviceManager"));
            C0209d.m1302r2(intent, strM79270H);
            C10342a.m63678d(this, intent, 10055);
        } catch (Exception e10) {
            C11839m.m70688i("BackupMainActivity", "jumpToHmsDeviceManager exception: " + e10);
        }
    }

    /* renamed from: E6 */
    public final void m18723E6() {
        boolean zM19624v2 = m19624v2();
        C11839m.m70686d("BackupMainActivity", "showDefaultOpenView switchChecked:" + zM19624v2);
        if (zM19624v2) {
            this.f13599T0.m25714Q(getString(R$string.backup_status_tip));
            mo18767U2(1);
            CloudBackupService.getInstance().getSwitchTime();
        } else {
            this.f13599T0.m25713P();
            mo18767U2(5);
        }
        m18763S6(zM19624v2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: F2 */
    public void mo18724F2() {
        super.mo18724F2();
        if (CBAccess.inBackup()) {
            m19617k2();
        }
        m18808j6();
    }

    /* renamed from: F4 */
    public final void m18725F4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (getIntent() != null) {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            Bundle extras = safeIntent.getExtras();
            if (extras != null) {
                C10343b c10343b = new C10343b(extras);
                boolean zM63681c = c10343b.m63681c("is_activity_need_back_to_main");
                boolean zM63681c2 = c10343b.m63681c("is_from_webview_filemanager");
                if (zM63681c && !zM63681c2) {
                    startActivity(new Intent(this, (Class<?>) MainActivity.class));
                    new HwAnimationReflection(this).m15927c(2);
                }
            }
            String stringExtra = safeIntent.getStringExtra("forOtherPage");
            C11839m.m70688i("BackupMainActivity", "backupToMainActivity,forOtherPage," + stringExtra);
            if ("BackupOptionsActivity".equals(stringExtra)) {
                C10342a.m63676b(this, new HiCloudSafeIntent(new Intent(this, (Class<?>) MainActivity.class)));
            }
        }
    }

    /* renamed from: F5 */
    public void m18726F5() {
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
            C11839m.m70688i("BackupMainActivity", "context is null.");
            return;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 10045);
        } else {
            Toast.makeText(this, R$string.cloudbackup_jump_refurbish, 0).show();
            C11839m.m70688i("BackupMainActivity", "refurbish activity is null.");
        }
    }

    /* renamed from: F6 */
    public final void m18727F6() {
        if (this.f13634o0 == null) {
            this.f13634o0 = new CutOutProgressDialog(this);
        }
        this.f13634o0.setMessage(getString(R$string.backup_clean_loading_msg));
        this.f13634o0.setCancelable(false);
        this.f13634o0.show();
    }

    /* renamed from: G4 */
    public void m18728G4() {
        this.f13628l0.setCheckedProgrammatically(true);
    }

    /* renamed from: G5 */
    public final /* synthetic */ List m18729G5() throws Exception {
        return this.f22163b.m69907f(m18813m5());
    }

    /* renamed from: G6 */
    public final AlertDialog m18730G6(AlertDialog alertDialog, Runnable runnable, Runnable runnable2) {
        return C4012a.m24641Y(alertDialog, this, "BackupMainActivity", runnable, runnable2, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: H2 */
    public void mo18731H2(boolean z10) {
        super.mo18731H2(z10);
        m18808j6();
    }

    /* renamed from: H4 */
    public final void m18732H4() {
        this.f13562A1 = false;
        HwProgressBar hwProgressBar = this.f13651w1;
        if (hwProgressBar == null || hwProgressBar.getVisibility() != 0) {
            return;
        }
        this.f13651w1.setVisibility(8);
    }

    /* renamed from: H5 */
    public final /* synthetic */ void m18733H5(C13834f.b bVar) {
        C11839m.m70688i("BackupMainActivity", "checkPagePermission Size:" + ((List) bVar.m82984b()).size());
        m29128B0((List) bVar.m82984b());
        this.f13590O1.set(false);
    }

    /* renamed from: H6 */
    public boolean m18734H6() {
        int iM1357g;
        if ("HuaweiService".equals(this.f13627k1)) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5 is HUAWEI_SERVICE");
            return false;
        }
        String strM18235I = C3024d2.m18235I(this, false, null);
        String strM18234H = C3024d2.m18234H(this, false, null);
        if (FrequencyManager.checkInValidTime(this, strM18235I, strM18234H)) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5 checkInValidTime true");
            return false;
        }
        if (!C0212e0.m1363m(this, strM18235I, strM18234H + "_pageType", "").equals(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5  pageType error");
            return false;
        }
        if (!C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.SCENETYPE, "").equals("exit")) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5  sceneType error");
            return false;
        }
        int iM1357g2 = C0212e0.m1357g(this, strM18235I, strM18234H + "_num", -1);
        String strM1363m = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.H5URL, "");
        if (TextUtils.isEmpty(strM1363m) || iM1357g2 == -1) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5  h5Url == null:  true");
            return false;
        }
        int iM1357g3 = C0212e0.m1357g(this, strM18235I, strM18234H + "_frequency", 1);
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("BackupMainActivity", "showGuidH5  frequency: " + iM1357g3);
        if (iM1357g3 == 0) {
            iM1357g = C0212e0.m1357g(this, strM18235I, strM18234H + "_interval", 0);
        } else {
            iM1357g = 0;
        }
        if (!frequencyManager.checkGuideH5DialogFrequency(this, iM1357g3, -1, iM1357g)) {
            C11839m.m70688i("BackupMainActivity", "showGuidH5  checkGuideH5DialogFrequency:  false");
            return false;
        }
        String strM1363m2 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.ACTIVEURL, "");
        String strM1363m3 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.PACKAGEID, "");
        String strM1363m4 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.NOTIFYTYPE, "");
        String strM1363m5 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.NOTIFYURL, "");
        String strM1363m6 = C0212e0.m1363m(this, strM18235I, strM18234H + "_gradeCode", "");
        String strM1363m7 = C0212e0.m1363m(this, strM18235I, strM18234H + "_expireTime", "");
        if (iM1357g2 != 3 && iM1357g2 != 4) {
            return false;
        }
        m18769U6(this, iM1357g2, strM1363m, strM1363m3, strM1363m4, strM1363m5, strM1363m2, strM1363m6, strM1363m7);
        return true;
    }

    /* renamed from: I4 */
    public void m18735I4() {
        this.f13615e1.dismiss();
    }

    /* renamed from: I5 */
    public final /* synthetic */ void m18736I5(final C13834f.b bVar) {
        if (!C0204a0.m1125a(bVar) || AbstractC14026a.m84159a((Collection) bVar.m82984b())) {
            this.f13590O1.set(false);
        } else {
            runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17642a.m18733H5(bVar);
                }
            });
        }
    }

    /* renamed from: I6 */
    public final void m18737I6(Message message) {
        if (message.arg1 == 0) {
            this.f13581K0 = 0;
            m18740J6(message);
            return;
        }
        int i10 = this.f13581K0;
        if (i10 < 2) {
            this.f13581K0 = i10 + 1;
            C11839m.m70688i("BackupMainActivity", "retryTimes = " + this.f13581K0);
        } else {
            C11839m.m70688i("BackupMainActivity", "show no data view");
        }
        C11839m.m70688i("BackupMainActivity", "query records failed");
    }

    /* renamed from: J4 */
    public final boolean m18738J4(boolean z10) {
        return z10 ? C10028c.m62182c0().m62325f1() : m19622s2();
    }

    /* renamed from: J5 */
    public final /* synthetic */ void m18739J5(Boolean bool) {
        this.f14149S = bool.booleanValue();
    }

    /* renamed from: J6 */
    public final void m18740J6(Message message) {
        Bundle bundle;
        if (getResources() == null) {
            C11839m.m70687e("BackupMainActivity", "BackuoMainActivity resources is null");
        } else {
            if (message == null || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            this.f13604Y0 = bundle.getLong("lastRecordTime");
            C13465e.m81052f().m81067p("deviceName", bundle.getString("deviceName"));
            C13465e.m81052f().m81065n("lastRecordTime", this.f13604Y0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: K2 */
    public void mo18741K2(boolean z10) {
        CloudBackupState cloudBackupState;
        super.mo18741K2(z10);
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        boolean z11 = zM80791C0 != this.f13588N1;
        boolean z12 = zM80887a1 != this.f13586M1;
        if (z10 || z11 || z12) {
            C11839m.m70688i("BackupMainActivity", "refreshLayoutWithSpaceChange :" + z10 + " ; " + zM80791C0);
            this.f13586M1 = zM80887a1;
            this.f13588N1 = zM80791C0;
            m18763S6(m19624v2());
            if (!z11 || (cloudBackupState = this.f14158q) == null || this.f13599T0 == null) {
                return;
            }
            this.f13599T0.m25704G(cloudBackupState.getState().intValue(), this.f13639q1);
        }
    }

    /* renamed from: K4 */
    public final void m18742K4(HiCloudSafeIntent hiCloudSafeIntent) {
        int intExtra = hiCloudSafeIntent.getIntExtra("backup_option_enter_status", 0);
        if (intExtra == 1001) {
            m18719C6(getString(R$string.enter_option_backup_switch_off_note));
        } else if (intExtra == 1002) {
            m18719C6(getString(R$string.enter_option_backup_backuping_note));
        }
    }

    /* renamed from: K5 */
    public final /* synthetic */ void m18743K5(boolean z10, boolean z11, DialogInterface dialogInterface, int i10) {
        m18810k6(z10, z11);
    }

    /* renamed from: K6 */
    public final void m18744K6(Message message) {
        Resources resources = getResources();
        if (resources == null || message == null) {
            return;
        }
        long jM1688f = C0241z.m1688f(String.valueOf(message.obj));
        long jCurrentTimeMillis = jM1688f != 0 ? ((System.currentTimeMillis() - jM1688f) - 1) / 86400001 : 0L;
        if (jCurrentTimeMillis <= 0) {
            this.f13593Q0.setText(getString(R$string.backup_safe_ing));
        } else {
            int i10 = (int) jCurrentTimeMillis;
            this.f13593Q0.setText(resources.getQuantityString(R$plurals.backup_safe_day, i10, Integer.valueOf(i10)));
        }
    }

    /* renamed from: L4 */
    public final void m18745L4() {
        C11839m.m70688i("BackupMainActivity", "<checkBackupPermissions> start.");
        if (this.f13590O1.compareAndSet(false, true)) {
            C13834f.m82974k(new Callable() { // from class: com.huawei.android.hicloud.ui.activity.p
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f17697a.m18729G5();
                }
            }, null).m82981m(new InterfaceC13829a() { // from class: com.huawei.android.hicloud.ui.activity.q
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    this.f17704a.m18736I5((C13834f.b) obj);
                }
            });
        }
        C11839m.m70688i("BackupMainActivity", "<checkBackupPermissions> end, checkingPermission: " + this.f13590O1);
    }

    /* renamed from: L5 */
    public final /* synthetic */ void m18746L5(DialogInterface dialogInterface, int i10) {
        m18821p5();
    }

    /* renamed from: L6 */
    public final void m18747L6(boolean z10) {
        if (C11829c.m70532M0()) {
            RelativeLayout relativeLayout = this.f13631m1;
            if (relativeLayout == null || this.f13633n1 == null || this.f13628l0 == null || this.f13638q0 == null) {
                C11839m.m70687e("BackupMainActivity", "view is null");
                return;
            }
            if (z10) {
                relativeLayout.setVisibility(8);
                this.f13633n1.setVisibility(8);
                this.f13628l0.setClickable(true);
                this.f13628l0.setEnabled(true);
                return;
            }
            relativeLayout.setVisibility(0);
            this.f13633n1.setVisibility(0);
            this.f13628l0.setClickable(false);
            this.f13628l0.setEnabled(false);
        }
    }

    /* renamed from: M4 */
    public final void m18748M4(HiCloudSafeIntent hiCloudSafeIntent) {
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("from_guide_backup_activity", false);
        C11839m.m70688i("BackupMainActivity", "checkIsGuideClickBackup start ");
        if (booleanExtra) {
            boolean zM65652s = C10782d.m65634a().m65652s(this);
            boolean z10 = CBAccess.inBackup() || CBAccess.inRestore();
            RelativeLayout relativeLayout = this.f14163v;
            boolean z11 = relativeLayout != null && relativeLayout.getVisibility() == 0 && this.f14163v.isEnabled();
            C11839m.m70688i("BackupMainActivity", "checkIsGuideClickBackup isWifiConnect: " + zM65652s + " ,isBackupOrRestore: " + z10 + " ,backupBtnEnable: " + z11);
            hiCloudSafeIntent.putExtra("from_guide_backup_activity", false);
            if (z11 && zM65652s && !z10) {
                mo18797g2(true, "myHuawei".equals(this.f13603X0));
            }
        }
    }

    /* renamed from: M5 */
    public final /* synthetic */ void m18749M5(DialogInterface dialogInterface, int i10) {
        m18821p5();
        C13225d.m79490f1().m79585f0("mecloud_backup_main_no_data_switch_confirm_click", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backup_main_no_data_switch_confirm_click", "1", "43");
    }

    /* renamed from: M6 */
    public final void m18750M6() throws IllegalAccessException, IllegalArgumentException {
        String string = getString(R$string.cloudbackup_refurbishing_close_switch_tips1);
        AlertDialog alertDialog = this.f13643s1;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(string).setNeutralButton(getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f17623a.m18762S5(dialogInterface, i10);
                }
            }).setNegativeButton(getString(R$string.backup_close_confirm), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f17632a.m18760R5(dialogInterface, i10);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f13643s1 = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
        } else {
            alertDialog.setMessage(string);
        }
        this.f13643s1.show();
    }

    /* renamed from: N4 */
    public final void m18751N4() {
        if (!(!C10028c.m62182c0().m62395t1("is_already_configed_NV4"))) {
            C13612b.m81829B().m81876o();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) NewHiSyncSettingActivity.class);
        C13230i.m79525e1(intent, this.f16165h, this.f16166i);
        startActivity(intent);
        finish();
    }

    /* renamed from: O6 */
    public final void m18752O6(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        C10343b c10343b = new C10343b(bundle);
        String strM63695q = c10343b.m63695q("targetGradeCode", "");
        int iM63687i = c10343b.m63687i("targetFrequency", 0);
        String strM63695q2 = c10343b.m63695q("targetGradeName", "");
        if (TextUtils.isEmpty(strM63695q) || TextUtils.isEmpty(strM63695q2) || iM63687i == 0) {
            return;
        }
        UpgradeMemberConfirmDialog upgradeMemberConfirmDialog = this.f13613d1;
        if (upgradeMemberConfirmDialog == null) {
            this.f13613d1 = new UpgradeMemberConfirmDialog(this, iM63687i, strM63695q, strM63695q2);
        } else {
            upgradeMemberConfirmDialog.updateView(iM63687i, strM63695q, strM63695q2);
        }
        this.f13613d1.show();
    }

    /* renamed from: P4 */
    public final void m18753P4() throws IllegalAccessException, IllegalArgumentException {
        if (this.f14149S) {
            m18750M6();
        } else if (C13452e.m80781L().m80791C0()) {
            m18761S4();
        } else {
            m18772W4();
        }
        m19621r2();
        String str = C13452e.m80781L().m80887a1() ? "CLOUDBACKUP_CLOSE_FULL_CLOUDBACKUP" : "CLOUDBACKUP_CLOSE_CLOUDBACKUP";
        C13223b.m79475c(this, str, "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        UBAAnalyze.m29950K("CKC", str, "1", C13222a.m79465g(this));
    }

    /* renamed from: P5 */
    public final /* synthetic */ void m18754P5() {
        this.f13569E0 = true;
    }

    /* renamed from: P6 */
    public final List<UserBackupInfo.UserDeviceInfo> m18755P6(List<UserBackupInfo.UserDeviceInfo> list) {
        ArrayList arrayList = new ArrayList();
        List list2 = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupMainActivity.m18658T5((UserBackupInfo.UserDeviceInfo) obj);
            }
        }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackupMainActivity.m18660U5((UserBackupInfo.UserDeviceInfo) obj, (UserBackupInfo.UserDeviceInfo) obj2);
            }
        }).collect(Collectors.toList());
        List list3 = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupMainActivity.m18662V5((UserBackupInfo.UserDeviceInfo) obj);
            }
        }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackupMainActivity.m18664W5((UserBackupInfo.UserDeviceInfo) obj, (UserBackupInfo.UserDeviceInfo) obj2);
            }
        }).collect(Collectors.toList());
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        return arrayList;
    }

    /* renamed from: Q4 */
    public final void m18756Q4() throws JSONException {
        C11839m.m70688i("BackupMainActivity", "clickOpenBackupSwitch");
        m18672b6("BackupMainActivity", this.f13612d0);
        m18723E6();
        m19617k2();
        C10155f.m63262O(this, true);
        C2783d.m16164n1(this);
        m18745L4();
        JSONObject jSONObjectM79482j = C13223b.m79482j(this, "CLOUDBACKUP_OPEN_CLOUDBACKUP", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            if (this.f13609b1.m79064b()) {
                jSONObjectM79482j.put("notify_id", this.f13609b1.m79063a());
                jSONObjectM79482j.put("notify_type", 1);
            }
        } catch (JSONException e10) {
            C11839m.m70687e("BackupMainActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(this, jSONObjectM79482j);
        UBAAnalyze.m29952M("CKC", "CLOUDBACKUP_OPEN_CLOUDBACKUP", jSONObjectM79482j);
        C13225d.m79490f1().m79587h0("mecloud_backupmain_click_switch", "1", "1", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_backupmain_click_switch", "1", "16", "1", "1");
    }

    /* renamed from: Q5 */
    public final /* synthetic */ void m18757Q5(SpanClickText spanClickText) {
        if (m18714A5() || spanClickText == null) {
            return;
        }
        C11839m.m70688i("BackupMainActivity", "set click");
        m18722E5();
    }

    /* renamed from: Q6 */
    public final void m18758Q6() {
        m18716B5(true);
        C12515a.m75110o().m75172d(new C12179f(C11058a.m66627b("02301"), this.f13598S1));
    }

    /* renamed from: R4 */
    public void m18759R4() {
        C11839m.m70688i("BackupMainActivity", "closeBackupAfterConfirm");
        this.f13628l0.setCheckedProgrammatically(false);
        m18763S6(false);
        this.f13599T0.m25713P();
        m18765T4();
        CloudBackupService.getInstance().afterCloseCloudBackup(this, new InterfaceC13829a() { // from class: com.huawei.android.hicloud.ui.activity.g
            @Override // p780xm.InterfaceC13829a
            public final void accept(Object obj) {
                this.f17613a.m18739J5((Boolean) obj);
            }
        });
        C13223b.m79475c(this, "CLOUDBACKUP_CLOSE_CLOUDBACKUP_SUCCEED", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        UBAAnalyze.m29950K("CKC", "CLOUDBACKUP_CLOSE_CLOUDBACKUP_SUCCEED", "1", C13222a.m79465g(this));
        m18694q6();
        this.f13579J0 = true;
        C13225d.m79490f1().m79587h0("mecloud_backupmain_click_switch", "2", "2", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_backupmain_click_switch", "1", "16", "2", "2");
        m19621r2();
        CloseBackupSwitchAlertDialog closeBackupSwitchAlertDialog = this.f13630m0;
        if (closeBackupSwitchAlertDialog != null) {
            closeBackupSwitchAlertDialog.dismiss();
        }
        C2783d.m16164n1(this);
        m18816n6("closeBackupSwitch");
    }

    /* renamed from: R5 */
    public final /* synthetic */ void m18760R5(DialogInterface dialogInterface, int i10) {
        m18759R4();
        dialogInterface.dismiss();
    }

    /* renamed from: S4 */
    public final void m18761S4() {
        String strQueryBakSourceStrategy = new SettingOperator().queryBakSourceStrategy();
        C11839m.m70688i("BackupMainActivity", "bakSourceStrategy: " + strQueryBakSourceStrategy);
        if (!TextUtils.equals("1", strQueryBakSourceStrategy)) {
            m18773X4();
            if (this.f13632n0 == null) {
                this.f13632n0 = new DeleteOneDeviceBackupRecordDialog(this, new C3134g());
            }
            this.f13632n0.showBasicDeleteAndClose(C12590s0.m75814X());
            CloudBackupReport.reportCloseSwitch(null, this, this);
            return;
        }
        m18759R4();
        C13225d.m79490f1().m79597u0(getClass().getSimpleName() + ":  close base switch, bak source strategy is V2", C13471c.f.BASE_SWITCH, false);
        CloudBackupReport.reportCloseSwitch(null, this, this);
    }

    /* renamed from: S5 */
    public final /* synthetic */ void m18762S5(DialogInterface dialogInterface, int i10) {
        m18728G4();
        dialogInterface.dismiss();
    }

    /* renamed from: S6 */
    public final void m18763S6(boolean z10) {
        if (this.f13588N1) {
            C12809f.m76843p(this.f13582K1, false);
        } else {
            C12809f.m76843p(this.f13582K1, z10);
        }
        C12809f.m76843p(this.f13584L1, z10);
        this.f13591P0.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: T2 */
    public void mo18764T2() {
        super.mo18764T2();
        this.f13639q1 = m19625x2();
        this.f13599T0.m25708K(getString(R$string.backuping), null, this.f13639q1);
    }

    /* renamed from: T4 */
    public final void m18765T4() {
        if (CBAccess.inBackup() && !CBAccess.hasValidTempBackup()) {
            mo18731H2(true);
        }
        C11839m.m70688i("BackupMainActivity", "closeCloudBackup newBmType: " + C13452e.m80781L().m80887a1());
        C13225d.m79490f1().m79597u0(getClass().getSimpleName() + ": close switch", C13471c.f.ALL_SWITCH, false);
        if (C10028c.m62182c0().m62388s("backup_key")) {
            CloudBackupService.getInstance().cloudbackupOpr(false);
            CloudBackupService.getInstance().reportCloseBackup();
        }
        C10028c.m62182c0().m62197C2("CloseCloudBackupDate", 0L);
    }

    /* renamed from: T6 */
    public final void m18766T6(int i10) {
        if (i10 == 20006 || i10 == 20001 || i10 == 20002) {
            List<String> listM69903b = this.f22163b.m69903b(this, this.f22163b.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP));
            if (listM69903b == null || listM69903b.isEmpty()) {
                C11839m.m70688i("BackupMainActivity", "unGranted permission is empty.");
                return;
            }
            if (i10 == 20001 || i10 == 20002) {
                C2783d.m16090J0("backup_permission_close_backup", C13230i.m79497A(C13452e.m80781L().m80971t0()));
            }
            m18759R4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: U2 */
    public void mo18767U2(int i10) {
        m19624v2();
        super.mo18767U2(i10);
    }

    /* renamed from: U4 */
    public final void m18768U4() {
        DeleteOneDeviceBackupRecordDialog deleteOneDeviceBackupRecordDialog = this.f13632n0;
        if (deleteOneDeviceBackupRecordDialog != null) {
            deleteOneDeviceBackupRecordDialog.dismiss();
        }
    }

    /* renamed from: U6 */
    public void m18769U6(Activity activity, int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str3);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str4);
            intent.putExtra("activeUri", str5);
            intent.putExtra("packageId", str2);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("gradeCode", str6);
            intent.putExtra("expireTime", str7);
            activity.startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("BackupMainActivity", " QueryGuideH5Task  showGuidH5 System.currentTimeMillis(): " + jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70687e("BackupMainActivity", "viewWeb Exception: " + e10.toString());
        }
    }

    /* renamed from: V4 */
    public final void m18770V4() {
        CutOutProgressDialog cutOutProgressDialog = this.f13634o0;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: W2 */
    public void mo18771W2() {
        super.mo18771W2();
        this.f13639q1 = false;
        this.f13599T0.m25713P();
        mo18767U2(5);
    }

    /* renamed from: W4 */
    public final void m18772W4() {
        if (this.f13630m0 == null) {
            this.f13630m0 = new CloseBackupSwitchAlertDialog(this, new C3133f());
        }
        this.f13630m0.show();
        if (C0209d.m1220W0()) {
            return;
        }
        this.f13630m0.getButton(-1).setTextColor(getResources().getColor(R$color.enui50_red_color));
    }

    /* renamed from: X4 */
    public final void m18773X4() {
        AlertDialog alertDialog = this.f13643s1;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f13643s1 = null;
        }
    }

    /* renamed from: X5 */
    public void m18774X5(C4867a c4867a, boolean z10) {
        if (!C0209d.m1181J0(this)) {
            C11839m.m70688i("BackupMainActivity", "isActivityRunningForeground false return");
            return;
        }
        C11839m.m70688i("BackupMainActivity", "<navToCloudSpaceBackupDetail> deviceName: " + c4867a.getDeviceName() + ", size: " + c4867a.m29219f());
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", String.valueOf(c4867a.isCurrent()));
        C13225d.m79490f1().m79591l0("backup_main_click_backup_detail", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "backup_main_click_backup_detail", "1", "43");
        Intent intent = new Intent(this, (Class<?>) CloudSpaceBackupDetailActivity.class);
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        backupDetailItem.m16369I(c4867a.getDeviceName());
        backupDetailItem.m16389s(c4867a.getDeviceId());
        backupDetailItem.m16390t(c4867a.getDeviceType());
        backupDetailItem.m16386p(c4867a.isCurrent() ? 1 : 0);
        backupDetailItem.m16370K(c4867a.m29219f());
        backupDetailItem.m16388r(c4867a.getDeviceCategory());
        backupDetailItem.m16384n(c4867a.getBackupDeviceId());
        backupDetailItem.m16372M(C0223k.m1524g(this, c4867a.m29219f()));
        backupDetailItem.m16368A(m18802h5(c4867a, z10));
        if (z10 && c4867a.m29221p() != null) {
            backupDetailItem.m16385o(c4867a.m29221p().getBakId());
        }
        intent.putExtra("backup_item_param", backupDetailItem);
        intent.putExtra("isTempBackup", z10);
        intent.putExtra("from_backup_main_page", true);
        intent.putExtra("isOnlyRefurbish", c4867a.isOnlyRefurbish());
        intent.putExtra("isOnlyHarmonyNext", c4867a.isOnlyHarmonyNext());
        intent.putExtra("terminalType", c4867a.getTerminalType());
        intent.putExtra("backup_delete_report_entry", 1);
        startActivityForResult(intent, 10024);
    }

    /* renamed from: Y4 */
    public final void m18775Y4() {
        C11839m.m70688i("BackupMainActivity", "begin get user package task");
        if (C0209d.m1333z1(this)) {
            this.f13625j1 = true;
            this.f13600U0.setVisibility(0);
            C11060c c11060c = new C11060c();
            c11060c.m66664t("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            C9713b.m60566c().m60571f(this.f13623i1, c11060c, true, "BsIfMgBackupMainActivity");
            C13225d.m79490f1().m79585f0("mecloud_backupmain_click_backup_frequency", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_backup_frequency", "1", "43");
        }
    }

    /* renamed from: Y5 */
    public void m18776Y5() {
        C11839m.m70688i("BackupMainActivity", " notifyItem ");
        C12515a.m75110o().m75172d(new C3131d());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: Z2 */
    public void mo18777Z2() {
        C11839m.m70686d("BackupMainActivity", "showCreateRecord");
        super.mo18777Z2();
        if (CBAccess.inBackup() && this.f13628l0.isChecked()) {
            float progress = this.f14158q.getProgress();
            if (progress == 0.0f) {
                return;
            }
            String string = getString(R$string.creating_backup_record);
            this.f13639q1 = m19625x2();
            this.f13599T0.m25711N(progress, string, m18818o5(), this.f13639q1);
            m19601I2(this, string);
        }
    }

    /* renamed from: Z4 */
    public final void m18778Z4() {
        if (CBAccess.inBackup()) {
            m18648N6(R$string.backup_option_click_toast);
        } else {
            m18821p5();
        }
    }

    /* renamed from: Z5 */
    public final void m18779Z5(Message message) {
        if (message.arg1 != 3) {
            C11839m.m70688i("BackupMainActivity", "backup failed.");
        } else {
            m18808j6();
        }
    }

    /* renamed from: a6 */
    public final void m18780a6(View view) {
        if (!C0209d.m1333z1(this)) {
            C11839m.m70688i("BackupMainActivity", "<onDeviceItemClick> net work is not connected.");
            return;
        }
        C4867a c4867aM18815n5 = m18815n5(view);
        if (c4867aM18815n5 == null) {
            C11839m.m70689w("BackupMainActivity", "Adapter item is null, viewId: " + view.getId());
            return;
        }
        C11839m.m70688i("BackupMainActivity", "click device item, deviceName: " + c4867aM18815n5.getDeviceName() + ", size: " + c4867aM18815n5.m29219f());
        int type = c4867aM18815n5.getType();
        if (type == 1) {
            m18774X5(c4867aM18815n5, false);
            return;
        }
        if (type == 2) {
            this.f13610c0 = 2;
            this.f13561A0.m24748K();
            this.f13561A0.m24743F(new C4867a(4));
            this.f13561A0.m5213j();
            m18808j6();
            return;
        }
        if (type == 3) {
            this.f13610c0 = 1;
            this.f13561A0.m24750M();
            this.f13561A0.m5213j();
        } else if (type != 4) {
            C11839m.m70689w("BackupMainActivity", "Unknown adapterItem type: " + c4867aM18815n5.getType());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: b2 */
    public void mo18781b2(boolean z10) {
        super.mo18781b2(z10);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_system_retread", String.valueOf(m18738J4(z10)));
        linkedHashMap.put("is_refurbish", Boolean.valueOf(C10028c.m62182c0().m62325f1()));
        C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", "1", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", "1", "", linkedHashMap);
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.put("scene", this.f13614e0);
        C11839m.m70688i("BackupMainActivity", "report manual backup scene");
        C13225d.m79490f1().m79603z0("cloudbackup_manual_scene", linkedHashMap2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: b3 */
    public void mo18782b3(int i10) {
        super.mo18782b3(i10);
        mo18767U2(1);
        CloudBackupService.getInstance().getSwitchTime();
        this.f13639q1 = false;
        boolean zIsChecked = this.f13628l0.isChecked();
        int returnCode = this.f14159r.getReturnCode();
        C11839m.m70688i("BackupMainActivity", "showDoneState returnCode: " + returnCode);
        if ((i10 != 0 || "entry_backup_notify".equalsIgnoreCase(this.f13641r1)) && !C14337f.f63677c.contains(Integer.valueOf(returnCode))) {
            this.f13605Z0.edit().putBoolean("have_read_new_record", false).apply();
            long jM85306g = C14317j.m85300d().m85306g();
            if (jM85306g <= 0) {
                this.f13599T0.m25714Q(getString(R$string.backup_status_tip));
            } else {
                String string = getString(R$string.backup_success_size, C0223k.m1524g(this, jM85306g));
                this.f13599T0.m25710M(string);
                m19601I2(this, string);
            }
        } else if (zIsChecked) {
            this.f13599T0.m25714Q(getString(R$string.backup_status_tip));
        } else {
            this.f13599T0.m25713P();
        }
        m18763S6(zIsChecked);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: c2 */
    public void mo18783c2(boolean z10) {
        super.mo18783c2(z10);
        if (this.f14161t || !this.f13639q1 || this.f13588N1) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CloudBackupDetailStateActivity.class);
        intent.putExtra("entry_source", "entry_backup_main_auto");
        startActivity(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: c3 */
    public void mo18784c3() {
        super.mo18784c3();
        String displayModule = this.f14158q.getDisplayModule();
        float progress = this.f14158q.getProgress();
        C11839m.m70686d("BackupMainActivity", "showModuleProcessing module = " + displayModule);
        if (displayModule.isEmpty()) {
            return;
        }
        String string = getString(R$string.module_progress_tips_no_num_new, m18805i5(C2783d.m16142g0(displayModule) ? C2783d.m16153k(this, displayModule) : C2783d.m16079E(this, displayModule)));
        this.f13639q1 = m19625x2();
        this.f13599T0.m25711N(progress, string, m18818o5(), this.f13639q1);
        m19601I2(this, string);
    }

    /* renamed from: c5 */
    public final String m18785c5(String str) {
        String strM68633c = C11477c.m68633c(str);
        return TextUtils.isEmpty(strM68633c) ? str : strM68633c;
    }

    /* renamed from: c6 */
    public final void m18786c6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("BackupMainActivity", "pageBack");
        this.f13562A1 = false;
        if ("myHuawei".equals(this.f13603X0)) {
            moveTaskToBack(true);
        } else {
            m18725F4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13618g0);
        arrayList.add(this.f13583L0);
        arrayList.add(this.f13640r0);
        arrayList.add(this.f13626k0);
        arrayList.add(this.f13633n1);
        arrayList.add(this.f13642s0);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: d3 */
    public void mo18787d3() {
        super.mo18787d3();
        String displayModule = this.f14158q.getDisplayModule();
        float progress = this.f14158q.getProgress();
        long prepareSize = this.f14158q.getPrepareSize();
        int count = this.f14158q.getCount();
        C11839m.m70686d("BackupMainActivity", "showModuleTransferData module =" + displayModule + " prepareSize =" + prepareSize + " moduleCount =" + count);
        if (displayModule.isEmpty()) {
            return;
        }
        String strM18805i5 = m18805i5(C2783d.m16153k(this, displayModule));
        String string = prepareSize > 0 ? getString(R$string.backup_module_progress, strM18805i5, C2783d.m16144h(this.f14158q.getModuleProgress())) : count > 0 ? getString(R$string.module_progress_tips, strM18805i5, Integer.valueOf(this.f14158q.getCurrent()), Integer.valueOf(count)) : getString(R$string.module_progress_tips_no_num_new, strM18805i5);
        this.f13639q1 = m19625x2();
        this.f13599T0.m25711N(progress, string, m18818o5(), this.f13639q1);
        m19601I2(this, string);
    }

    /* renamed from: d5 */
    public final void m18788d5() {
        if (this.f13577I0) {
            return;
        }
        C11842p.m70836m(this);
        CloseBackupSwitchAlertDialog closeBackupSwitchAlertDialog = this.f13630m0;
        if (closeBackupSwitchAlertDialog != null) {
            closeBackupSwitchAlertDialog.dismiss();
            this.f13630m0 = null;
        }
        m18768U4();
        UnionSwitch unionSwitch = this.f13628l0;
        if (unionSwitch != null) {
            unionSwitch.setOnCheckedChangeListener(null);
            this.f13569E0 = false;
        }
        C10718a c10718a = this.f13573G0;
        if (c10718a != null) {
            c10718a.m65430k();
        }
        AlertDialog alertDialog = this.f13607a1;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f13607a1 = null;
        }
        AutoBackupFrequencyDialog autoBackupFrequencyDialog = this.f13611c1;
        if (autoBackupFrequencyDialog != null) {
            autoBackupFrequencyDialog.dismiss();
            this.f13611c1 = null;
        }
        UpgradeMemberConfirmDialog upgradeMemberConfirmDialog = this.f13613d1;
        if (upgradeMemberConfirmDialog != null) {
            upgradeMemberConfirmDialog.dismiss();
            this.f13613d1 = null;
        }
        BackupGuideDialog backupGuideDialog = this.f13619g1;
        if (backupGuideDialog != null) {
            backupGuideDialog.dismiss();
            this.f13619g1 = null;
        }
        RefurbishUpgradDialog refurbishUpgradDialog = this.f13617f1;
        if (refurbishUpgradDialog != null) {
            refurbishUpgradDialog.dismiss();
            this.f13617f1 = null;
        }
        m18773X4();
        m18770V4();
        ConfirmJumpRefurbishDialog confirmJumpRefurbishDialog = this.f13615e1;
        if (confirmJumpRefurbishDialog != null) {
            confirmJumpRefurbishDialog.dismiss();
            this.f13615e1 = null;
        }
        AlertDialog alertDialog2 = this.f13636p0;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f13636p0 = null;
        }
        AlertDialog alertDialog3 = this.f13570E1;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
            this.f13570E1 = null;
        }
        BackupOptionAlertDialog backupOptionAlertDialog = this.f13621h1;
        if (backupOptionAlertDialog != null) {
            backupOptionAlertDialog.dismiss();
            this.f13621h1 = null;
        }
        if (this.f13594Q1 != null) {
            CloudBackupService.getInstance().unregister(this.f13594Q1);
        }
        this.f13577I0 = true;
    }

    /* renamed from: d6 */
    public void m18789d6(HiCloudSafeIntent hiCloudSafeIntent) {
        if (hiCloudSafeIntent == null || !hiCloudSafeIntent.getBooleanExtra("isOpenSwitch", false)) {
            return;
        }
        m18672b6("BackupMainActivity", this.f13612d0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: e2 */
    public void mo18790e2() {
        C11839m.m70686d("BackupMainActivity", "cancelRefurbishResponse");
        super.mo18790e2();
        this.f13603X0 = "";
        this.f14149S = false;
        this.f14158q = null;
        m18723E6();
        m19619m2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: e3 */
    public void mo18791e3() {
        super.mo18791e3();
        C11839m.m70686d("BackupMainActivity", "showOverDays");
        this.f13591P0.setVisibility(8);
        mo18767U2(1);
        boolean z10 = (!m19625x2() || this.f14158q.getIntProgress() == 100 || this.f14158q.isOverDayErrTipDismiss()) ? false : true;
        this.f13639q1 = z10;
        this.f13599T0.m25712O(this.f14158q, z10);
    }

    /* renamed from: e5 */
    public final void m18792e5() {
        ResultReceiver resultReceiver;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        try {
            resultReceiver = (ResultReceiver) intent.getParcelableExtra("external_finisher");
        } catch (RuntimeException unused) {
            C11839m.m70688i("BackupMainActivity", "intent Serializable error.");
            resultReceiver = null;
        }
        if (resultReceiver != null) {
            resultReceiver.send(1, null);
        }
    }

    /* renamed from: e6 */
    public void m18793e6() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                if (intent.hasExtra("scene_of_manual_backup")) {
                    this.f13614e0 = intent.getStringExtra("scene_of_manual_backup");
                } else if ("11".equals(this.f16166i)) {
                    this.f13614e0 = "2";
                } else {
                    this.f13614e0 = "3";
                }
            } catch (Exception unused) {
                C11839m.m70687e("BackupMainActivity", "parseManulScene get extra error");
            }
        }
        C11839m.m70688i("BackupMainActivity", "parseManulScene: " + this.f13614e0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: f3 */
    public void mo18794f3() {
        int returnCode = this.f14158q.getReturnCode();
        C11839m.m70686d("BackupMainActivity", "showPauseState returnCode = " + returnCode);
        if (returnCode == 3001 && this.f14158q.isCloudSpaceNotEnoughDismiss()) {
            mo18782b3(0);
            C0237v.m1661c();
            C11839m.m70688i("BackupMainActivity", "showPauseState errorCode is 3001 ,show spacialstatus");
        } else {
            if (returnCode == 3113) {
                m18723E6();
                return;
            }
            super.mo18794f3();
            this.f13591P0.setVisibility(8);
            this.f13639q1 = m19625x2();
            String string = getString(R$string.backup_suspended);
            m19601I2(this, string);
            this.f13599T0.m25707J(m19618l2(), string, this.f14158q, this.f13639q1);
        }
    }

    /* renamed from: f5 */
    public final void m18795f5() {
        C12515a.m75110o().m75172d(new C3135h());
    }

    /* renamed from: f6 */
    public void m18796f6() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                if (intent.hasExtra("channel_of_open_switch")) {
                    this.f13612d0 = intent.getStringExtra("channel_of_open_switch");
                } else if (C10028c.m62182c0().m62325f1()) {
                    this.f13612d0 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                } else if ("9".equals(this.f16166i)) {
                    this.f13612d0 = "11";
                } else if ("5".equals(this.f16166i)) {
                    this.f13612d0 = "5";
                } else if ("2".equals(this.f16165h)) {
                    this.f13612d0 = "8";
                }
            } catch (Exception unused) {
                C11839m.m70687e("BackupMainActivity", "parseOpenSwitchChannel get extra error");
            }
        }
        C11839m.m70686d("BackupMainActivity", "parseOpenSwitchChannel channel: " + this.f13612d0);
    }

    @Override // androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        return this.f13608b0;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: g2 */
    public void mo18797g2(boolean z10, boolean z11) {
        m18732H4();
        if (!this.f14149S) {
            if (CBAccess.hasValidTempBackup()) {
                this.f13568D1 = m18730G6(this.f13568D1, null, null);
                return;
            } else {
                mo18804i3(z10, "myHuawei".equals(this.f13603X0));
                return;
            }
        }
        if (!C12591s1.m75931a().m75944n()) {
            RefurbishUpgradDialog refurbishUpgradDialog = new RefurbishUpgradDialog(this);
            this.f13617f1 = refurbishUpgradDialog;
            refurbishUpgradDialog.show();
        } else {
            ConfirmJumpRefurbishDialog confirmJumpRefurbishDialog = this.f13615e1;
            if (confirmJumpRefurbishDialog != null) {
                confirmJumpRefurbishDialog.show(C0213f.m1377a().getString(R$string.cloudbackup_refurbishing_backup_tips));
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: g3 */
    public void mo18798g3() {
        super.mo18798g3();
        this.f13639q1 = m19625x2();
        String string = getString(R$string.backup_prepareing_state_tip);
        this.f13599T0.m25708K(string, m18809k5(), this.f13639q1);
        m19601I2(this, string);
    }

    /* renamed from: g5 */
    public final AlertDialog.Builder m18799g5(final boolean z10, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String appId = this.f13580J1.getAppId();
        String strM16079E = this.f13580J1.getParent().equals("virtualApp") ? CloudBackupLanguageUtil.getVirtualName(appId) : (C14333b.m85483r().containsKey(appId) || C14333b.f63653e.containsKey(appId)) ? C2783d.m16079E(this, appId) : this.f13580J1.getAppName();
        C11839m.m70688i("BackupMainActivity", "offNum: " + this.f13576H1 + " name: " + strM16079E);
        Resources resources = getResources();
        if (resources != null) {
            int i10 = R$plurals.exit_data_no_backup;
            int i11 = this.f13576H1;
            builder.setTitle(resources.getQuantityString(i10, i11, Integer.valueOf(i11)));
            int i12 = this.f13576H1;
            if (i12 == 1) {
                builder.setMessage(resources.getString(R$string.which_app_one, strM16079E, strM16079E));
            } else if (i12 > 1) {
                builder.setMessage(resources.getQuantityString(R$plurals.which_app, i12, Integer.valueOf(i12), strM16079E));
            }
        } else {
            C11839m.m70687e("TAG", "Resources is null!");
        }
        builder.setPositiveButton(R$string.continue_backup, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i13) {
                this.f17746a.m18743K5(z10, z11, dialogInterface, i13);
            }
        });
        builder.setNegativeButton(R$string.go_to_backup_options, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i13) {
                this.f17765a.m18746L5(dialogInterface, i13);
            }
        });
        return builder;
    }

    /* renamed from: g6 */
    public void m18800g6() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                if (intent.hasExtra("entrance_of_restore")) {
                    this.f13616f0 = intent.getStringExtra("entrance_of_restore");
                } else if ("9".equals(this.f16166i)) {
                    this.f13616f0 = "4";
                }
            } catch (Exception unused) {
                C11839m.m70687e("BackupMainActivity", "parseRestoreEntrance get extra error");
            }
        }
        C11839m.m70688i("BackupMainActivity", "parseRestoreEntrance: " + this.f13616f0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: h3 */
    public void mo18801h3() {
        super.mo18801h3();
        this.f13639q1 = m19625x2();
        this.f13599T0.m25708K(getString(R$string.backup_prepareing_state_tip), m18809k5(), this.f13639q1);
    }

    /* renamed from: h5 */
    public final String m18802h5(C4867a c4867a, boolean z10) {
        return (!c4867a.isCurrent() || z10) ? String.valueOf(c4867a.m29220k()) : String.valueOf(Math.max(this.f13604Y0, c4867a.m29220k()));
    }

    /* renamed from: h6 */
    public final void m18803h6() {
        C11839m.m70688i("BackupMainActivity", "<parsingDeepLink> start.");
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("deeplink_sub_page");
        C11839m.m70686d("BackupMainActivity", "mSubPageFlag " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            if ("Backup_recovery".equals(stringExtra)) {
                C11839m.m70688i("BackupMainActivity", "<parsingDeepLink> start cloud backup records activity.");
                Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
                intent.putExtra("from_backup_enter", true);
                intent.putExtra("moudle", this.f13603X0);
                startActivityForResult(intent, 10036);
            } else if ("Backup_app_data_options".equals(stringExtra)) {
                C11839m.m70688i("BackupMainActivity", "<parsingDeepLink> start backup options activity, key: " + stringExtra);
                Intent intent2 = new Intent(this, (Class<?>) BackupOptionsActivity.class);
                intent2.putExtra("deeplink_sub_page", stringExtra);
                startActivity(intent2);
            } else if ("Backup_options".equals(stringExtra)) {
                C11839m.m70688i("BackupMainActivity", "<parsingDeepLink> start backup options activity.");
                startActivity(new Intent(this, (Class<?>) BackupOptionsActivity.class));
            }
        }
        C11839m.m70688i("BackupMainActivity", "<parsingDeepLink> end.");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: i3 */
    public void mo18804i3(boolean z10, boolean z11) {
        if (!z10) {
            m18810k6(z10, z11);
            return;
        }
        int i10 = this.f13576H1;
        if (i10 > 0) {
            AlertDialog alertDialogCreate = m18799g5(z10, z11).create();
            this.f13636p0 = alertDialogCreate;
            alertDialogCreate.show();
        } else if (this.f13572F1 == 0) {
            if (this.f13570E1 == null) {
                this.f13570E1 = m18807j5().create();
            }
            this.f13570E1.show();
        } else if (i10 >= 0) {
            m18810k6(z10, z11);
        }
    }

    /* renamed from: i5 */
    public final String m18805i5(String str) {
        C11839m.m70688i("BackupMainActivity", "getModuleName moduleName = " + str + " uid = " + this.f14158q.getUid());
        return str;
    }

    /* renamed from: i6 */
    public final void m18806i6() throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        mo19005p1();
        mo18817o2();
        m22365E1(R$string.cloud_backup_item_title);
        m18840x6("EnterCloudBackupTimes", "EnterCloudBackupDate");
        m18789d6(hiCloudSafeIntent);
        m18796f6();
        mo22385x1();
        m18793e6();
        m18800g6();
        C13225d.m79490f1().m79598v0(this, new SafeIntent(getIntent()), "BackupMainActivity");
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        String strM66627b = C11058a.m66627b("06008");
        this.f13637p1 = strM66627b;
        c11060c.m66643I(strM66627b);
        C9713b.m60566c().m60571f(this.f13623i1, c11060c, true, "BsIfMgBackupMainActivity");
        boolean zM1333z1 = C0209d.m1333z1(this);
        boolean zM19624v2 = m19624v2();
        if ("HuaweiService".equals(this.f13627k1) && zM1333z1 && zM19624v2) {
            C11839m.m70688i("BackupMainActivity", "backup enter flag = " + this.f13627k1);
            CloudBackupService.getInstance().checkBackup(this.f13596R1);
        } else {
            m18716B5(false);
        }
        m18748M4(new HiCloudSafeIntent(getIntent()));
        C10028c.m62182c0().m62323f(hiCloudSafeIntent);
    }

    /* renamed from: j5 */
    public final AlertDialog.Builder m18807j5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R$string.no_backup_data_available_title);
        builder.setMessage(R$string.no_backup_data_available_message);
        builder.setPositiveButton(R$string.go_ahead_and_open_backup_data, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17712a.m18749M5(dialogInterface, i10);
            }
        });
        builder.setNegativeButton(R$string.cloudbackup_btn_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                BackupMainActivity.m18647N5(dialogInterface, i10);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.android.hicloud.ui.activity.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                BackupMainActivity.m18651O5(dialogInterface);
            }
        });
        return builder;
    }

    /* renamed from: j6 */
    public void m18808j6() {
        C11839m.m70688i("BackupMainActivity", "<queryBackupRecords>");
        C12515a.m75110o().m75172d(new C12199z(1));
    }

    /* renamed from: k5 */
    public final String m18809k5() {
        CloudBackupState cloudBackupState = this.f14158q;
        if (cloudBackupState != null && TextUtils.equals(cloudBackupState.getStatusInPrepare(), "2")) {
            String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("backup_prepare_resume_data_tip");
            if (!TextUtils.isEmpty(spaceMultLanguage)) {
                return spaceMultLanguage;
            }
        }
        return null;
    }

    /* renamed from: k6 */
    public final void m18810k6(boolean z10, boolean z11) {
        super.mo18804i3(z10, z11);
    }

    /* renamed from: l5 */
    public final void m18811l5(List<BackupOptionItem> list) {
        int i10 = this.f13576H1;
        if (i10 <= 0 || i10 != list.size()) {
            C11839m.m70687e("BackupMainActivity", "getPriorityExitSwitchOffApp failed");
            return;
        }
        int i11 = 0;
        this.f13580J1 = list.get(0);
        while (true) {
            if (i11 >= this.f13576H1) {
                break;
            }
            if (list.get(i11).getAppId().equals("com.tencent.mm")) {
                this.f13580J1 = list.get(i11);
                break;
            }
            if (list.get(i11).getAppId().equals(HNConstants.DataType.MEDIA)) {
                this.f13580J1 = list.get(i11);
            }
            if (list.get(i11).getAppId().equals("com.tencent.mobileqq") && !this.f13580J1.getAppId().equals(HNConstants.DataType.MEDIA)) {
                this.f13580J1 = list.get(i11);
            }
            i11++;
        }
        C11839m.m70688i("BackupMainActivity", "exitappid: " + this.f13580J1.getAppId());
    }

    /* renamed from: l6 */
    public final void m18812l6(LinkedList<C4867a> linkedList, int i10, HashMap<String, HashSet<String>> map) throws Resources.NotFoundException {
        BackupMainDeviceAdapter backupMainDeviceAdapter = this.f13561A0;
        if (backupMainDeviceAdapter == null) {
            C11839m.m70689w("BackupMainActivity", "deviceListAdapter is null.");
            return;
        }
        this.f13567D0 = i10;
        this.f13565C0 = map;
        backupMainDeviceAdapter.m24744G();
        this.f13561A0.m24741D(linkedList);
        int i11 = 8;
        if (this.f13561A0.m24745H() == 0) {
            this.f13646u0.setVisibility(8);
            this.f13650w0.setVisibility(8);
            this.f13561A0.m5213j();
            return;
        }
        this.f13646u0.setVisibility(0);
        this.f13650w0.setVisibility(0);
        m18814m6();
        this.f13648v0.setText(C2783d.m16095M(getResources().getQuantityString(R$plurals.backup_main_list_title, i10, Integer.valueOf(i10)), Integer.valueOf(i10)));
        if (i10 > 5) {
            if (this.f13610c0 == 2) {
                this.f13561A0.m24743F(new C4867a(3));
            } else {
                this.f13561A0.m24743F(new C4867a(2));
            }
        }
        this.f13561A0.m5213j();
        TextView textView = (TextView) C12809f.m76829b(this, R$id.restore_data_cloud_space);
        if (C13452e.m80781L().m80887a1() && linkedList.size() != 0) {
            i11 = 0;
        }
        textView.setVisibility(i11);
    }

    /* renamed from: m5 */
    public final List<String> m18813m5() {
        ArrayList arrayList = new ArrayList();
        if (!m19624v2()) {
            C11839m.m70688i("BackupMainActivity", "get services backup item switch is close.");
            return new ArrayList();
        }
        arrayList.add(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (m18843z5("calendar")) {
            arrayList.add("backup_calendar");
        }
        if (m18843z5("calllog")) {
            arrayList.add("backup_calllog");
        }
        if (m18843z5(HNConstants.DataType.CONTACT)) {
            arrayList.add("backup_contact");
        }
        if (m18843z5(NavigationUtils.SMS_SCHEMA_PREF)) {
            arrayList.add("backup_sms");
        }
        return arrayList;
    }

    /* renamed from: m6 */
    public final void m18814m6() {
        if (!C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
            C11839m.m70688i("BackupMainActivity", "The switch for cloudBackupDeviceNameManagement is close.");
            C12809f.m76843p(this.f13656z0, false);
            C12809f.m76843p(this.f13563B0, false);
            return;
        }
        Iterator<Map.Entry<String, HashSet<String>>> it = this.f13565C0.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().size() > 1) {
                m18832u5();
                return;
            }
        }
        C12809f.m76843p(this.f13656z0, false);
        C12809f.m76843p(this.f13563B0, false);
    }

    /* renamed from: n5 */
    public final C4867a m18815n5(View view) {
        BackupMainDeviceAdapter.C4022d c4022d = (BackupMainDeviceAdapter.C4022d) view.getTag();
        if (c4022d == null) {
            C11839m.m70688i("BackupMainActivity", "View has not holder.");
            return null;
        }
        return (C4867a) this.f13561A0.m24746I(c4022d.m5165l());
    }

    /* renamed from: n6 */
    public void m18816n6(String str) {
        this.f13620h0.refreshCardView(str);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: o2 */
    public void mo18817o2() {
        super.mo18817o2();
        boolean zM19624v2 = m19624v2();
        this.f13628l0.setCheckedProgrammatically(zM19624v2);
        m18763S6(zM19624v2);
        if (zM19624v2) {
            this.f13599T0.m25714Q(getString(R$string.backup_status_tip));
            mo18767U2(1);
        } else {
            this.f13599T0.m25713P();
            mo18767U2(5);
        }
        m19621r2();
    }

    /* renamed from: o5 */
    public final String m18818o5() {
        return getString(R$string.backup_keep_connect_tip);
    }

    /* renamed from: o6 */
    public final void m18819o6(LinkedList<C4867a> linkedList) {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.temp_cloud_space);
        int i10 = 8;
        if (linkedList == null || linkedList.isEmpty()) {
            textView.setVisibility(8);
            return;
        }
        Iterator<C4867a> it = linkedList.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            UserBackupInfo.UserDeviceInfo userDeviceInfoM29221p = it.next().m29221p();
            if (userDeviceInfoM29221p != null) {
                Iterator<ExtraDeviceInfo> it2 = userDeviceInfoM29221p.getExtraDeviceInfos().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (it2.next().getOccupySpaceType().intValue() != 1) {
                        z10 = true;
                        break;
                    }
                }
            }
        }
        C11839m.m70688i("BackupMainActivity", "refreshTempDescription isShowDescription :" + z10);
        if (C13452e.m80781L().m80887a1() && z10) {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("BackupMainActivity", "<onActivityResult> requestCode: " + i10 + ", resultCode: " + i11 + ", data: " + intent);
        super.onActivityResult(i10, i11, intent);
        if (10036 == i10) {
            if (100301 == i11) {
                finish();
                return;
            }
            if (1 == i11) {
                long jM81058g = C13465e.m81052f().m81058g("lastRecordTime", 0L);
                if (jM81058g == 0 || this.f13604Y0 != jM81058g) {
                    this.f13604Y0 = jM81058g;
                    return;
                }
                return;
            }
            return;
        }
        if (10039 == i10 && 102 == i11) {
            if (CBAccess.inBackup()) {
                return;
            }
            m19617k2();
            return;
        }
        if (3 == i10 && 3 == i11) {
            m18716B5(false);
            return;
        }
        if (10040 == i10) {
            SafeIntent safeIntent = new SafeIntent(intent);
            if (safeIntent.getBooleanExtra("isNeedReportSwitchState", false)) {
                m18830t6(safeIntent.getStringArrayListExtra(CloudBackupConstant.BACKUP_OPETION_REPORT_LIST));
                return;
            }
            return;
        }
        if (i10 == 8903) {
            if (this.f13573G0 != null) {
                C13195l.m79272J().m79297M(this, this.f13573G0.m65437v(), i11, intent);
                return;
            }
            return;
        }
        if (10024 != i10) {
            m18766T6(i10);
            m18716B5(false);
            return;
        }
        if (100301 == i11) {
            if (CBAccess.inRestore()) {
                setResult(C5963j.f27043l);
                finish();
                return;
            }
            return;
        }
        if (101 == i11) {
            m18808j6();
            C11839m.m70688i("BackupMainActivity", "RECORD_DELETED.");
            if (intent == null) {
                C11839m.m70688i("BackupMainActivity", "RECORD_DELETED, data is null.");
                return;
            }
            Bundle extras = new SafeIntent(intent).getExtras();
            if (extras == null) {
                C11839m.m70688i("BackupMainActivity", "RECORD_DELETED, paramBundle is null.");
                return;
            }
            BackupDetailItem backupDetailItem = (BackupDetailItem) extras.getParcelable("backup_item_param");
            if (backupDetailItem == null) {
                C11839m.m70688i("BackupMainActivity", "RECORD_DELETED, backupItem is null.");
                return;
            }
            if (TextUtils.isEmpty(backupDetailItem.m16379h())) {
                C11839m.m70688i("BackupMainActivity", "RECORD_DELETED, deviceId is empty.");
                return;
            }
            C14329v.m85349e0().m85396N0(C11476b.m68626h(backupDetailItem.m16379h()));
            if (!CBAccess.inBackup()) {
                m19617k2();
            }
            m18816n6("removeFromCloudSpace");
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("BackupMainActivity", "onBackPressed, click back");
        m18786c6();
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.device_item_view == id2) {
            m18780a6(view);
            return;
        }
        if (R$id.backup_main_switch == id2) {
            this.f13628l0.setChecked(!r5.isChecked());
            return;
        }
        if (R$id.rl_backup_option == id2) {
            m18778Z4();
            return;
        }
        if (R$id.rl_backup_frequency == id2) {
            m18732H4();
            m18775Y4();
            return;
        }
        if (R$id.backup_learn_about == id2) {
            C13225d.m79490f1().m79585f0("mecloud_backupmain_click_learn_backup", C13452e.m80781L().m80971t0());
            CloudBackupService.getInstance().getBackupLearnAboutAddress();
            UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_learn_backup", "1", "42");
            return;
        }
        if (R$id.cloud_backup_read_support == id2) {
            CloudBackupService.getInstance().getBackupLinkAddress(3209);
            return;
        }
        if (R$id.rl_backup_data_layout == id2) {
            this.f13562A1 = true;
            HwProgressBar hwProgressBar = this.f13651w1;
            if (hwProgressBar != null) {
                hwProgressBar.setVisibility(0);
            }
            this.f13655y1 = 0;
            return;
        }
        if (R$id.oepn_service_button == id2) {
            C13225d.m79490f1().m79585f0("extended_service_click_open_backup", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "extended_service_click_open_backup", "1", "100");
            C10028c.m62182c0().m62272S1(true);
            m18747L6(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m18715A6();
        AutoBackupFrequencyDialog autoBackupFrequencyDialog = this.f13611c1;
        if (autoBackupFrequencyDialog != null && autoBackupFrequencyDialog.isShowing()) {
            this.f13611c1.show();
        }
        C9158a.m57503F().m57539f("backupHomePage", this.f13623i1);
        AlertDialog alertDialog = this.f13568D1;
        boolean z10 = false;
        boolean z11 = alertDialog != null && alertDialog.isShowing();
        AlertDialog alertDialog2 = this.f13643s1;
        boolean z12 = alertDialog2 != null && alertDialog2.isShowing();
        CloseBackupSwitchAlertDialog closeBackupSwitchAlertDialog = this.f13630m0;
        if (closeBackupSwitchAlertDialog != null && closeBackupSwitchAlertDialog.isShowing()) {
            z10 = true;
        }
        C11839m.m70688i("BackupMainActivity", "onConfigurationChanged: isShowDialog:" + z11 + "," + z12 + "," + z10);
        if (z11 || z12 || z10) {
            boolean zM62413x = C10028c.m62182c0().m62413x();
            C11839m.m70688i("BackupMainActivity", "onConfigurationChanged: status:" + zM62413x);
            this.f13628l0.setCheckedProgrammatically(zM62413x ^ true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("BackupMainActivity", "<onCreate> start.");
        m29137U0();
        super.onCreate(bundle);
        this.f13609b1.m79065c(this, getIntent(), C13222a.m79465g(this));
        m18751N4();
        C9908c.m61499D().m61548i0(getApplicationContext());
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f13627k1 = hiCloudSafeIntent.getStringExtra("enterType");
        this.f13603X0 = hiCloudSafeIntent.getStringExtra("moudle");
        this.f14149S = C12591s1.m75931a().m75941k();
        this.f13564B1 = hiCloudSafeIntent.getBooleanExtra("queryType", false);
        m18742K4(hiCloudSafeIntent);
        m18828s6(hiCloudSafeIntent);
        boolean z10 = bundle != null ? bundle.getBoolean("enter_background") : false;
        C11839m.m70688i("BackupMainActivity", "<onCreate> flag: " + this.f13627k1 + ", renovatingFlag: " + this.f13603X0 + ", isBackFromDeviceManager: " + this.f13564B1 + ", isEnterBackground: " + z10);
        C12515a.m75110o().m75172d(new C12173a0());
        if (!z10 && m18650O4(this, this.f13603X0)) {
            C11839m.m70688i("BackupMainActivity", "<onCreate> Restoring, start restore main activity.");
            return;
        }
        m18803h6();
        if (!C13843a.m83076a0(this)) {
            C11839m.m70688i("BackupMainActivity", "<onCreate> setRequestedOrientation.");
            setRequestedOrientation(1);
        }
        this.f13629l1 = C0209d.m1195O(this);
        m18838w6();
        m18792e5();
        m18833u6(getIntent());
        m18713z6();
        this.f13605Z0 = C0214f0.m1382b(this, "backup_new_record_sp", 0);
        CloudBackupService.getInstance().register(this.f13594Q1);
        mo18823q2();
        C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
        if ("myHuawei".equals(this.f13603X0)) {
            m18758Q6();
        } else {
            m18806i6();
        }
        m18745L4();
        if (!"HuaweiService".equals(this.f13627k1)) {
            C11839m.m70688i("BackupMainActivity", "BackupActivity start QueryGuideH5Task");
            C12515a.m75110o().m75175e(new C3024d2(this, this.f13635o1, 1, "BackupMainActivity"), false);
        }
        if (!C0209d.m1333z1(this)) {
            C11839m.m70688i("BackupMainActivity", "<onCreate> network is not connected.");
            this.f13651w1.setVisibility(8);
            this.f13655y1 = 2;
        }
        this.f13608b0.m4962h(AbstractC0791h.b.ON_CREATE);
        C11839m.m70688i("BackupMainActivity", "<onCreate> end.");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        this.f13608b0.m4962h(AbstractC0791h.b.ON_DESTROY);
        super.onDestroy();
        C11839m.m70686d("BackupMainActivity", "onDestroy");
        AlertDialog alertDialog = this.f13568D1;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        m18833u6(getIntent());
        m18788d5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String stringExtra = hiCloudSafeIntent.getStringExtra("moudle");
        this.f13603X0 = stringExtra;
        m18650O4(this, stringExtra);
        m18833u6(hiCloudSafeIntent);
        m18748M4(hiCloudSafeIntent);
        m18742K4(hiCloudSafeIntent);
        this.f13609b1.m79065c(this, hiCloudSafeIntent, C13222a.m79465g(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("BackupMainActivity", "onOptionsItemSelected.");
        if (menuItem == null) {
            C11839m.m70688i("BackupMainActivity", "onOptionsItemSelected item is null.");
            return false;
        }
        if (menuItem.getItemId() == 16908332) {
            C11839m.m70688i("BackupMainActivity", "onOptionsItemSelected, click back");
            if (getIntent() == null) {
                return false;
            }
            if (m18734H6()) {
                C11839m.m70688i("BackupMainActivity", "showGuidH5 onOptionsItemSelected home");
                return false;
            }
            C11839m.m70688i("BackupMainActivity", "onOptionsItemSelected, start pageBack");
            m18786c6();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        this.f13608b0.m4962h(AbstractC0791h.b.ON_PAUSE);
        super.onPause();
        if (this.f13592P1 != null) {
            C12515a.m75110o().m75165a1(this.f13592P1);
        }
        m18732H4();
        if (isFinishing()) {
            boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
            if (!this.f13579J0 && !zM62388s) {
                C2783d.m16164n1(this);
            }
            m18788d5();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        m18751N4();
        C10718a c10718a = this.f13573G0;
        if (c10718a != null) {
            c10718a.m65431l();
        }
        if ("HuaweiService".equals(this.f13627k1)) {
            return;
        }
        C11839m.m70688i("BackupMainActivity", "BackupActivity start QueryGuideH5Task");
        C12515a.m75110o().m75175e(new C3024d2(this, this.f13635o1, 2, "BackupMainActivity"), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        CloseBackupSwitchAlertDialog closeBackupSwitchAlertDialog;
        C11839m.m70688i("BackupMainActivity", "<onResume> start.");
        super.onResume();
        boolean zM19624v2 = m19624v2();
        UnionSwitch unionSwitch = this.f13628l0;
        if (unionSwitch == null) {
            C11839m.m70689w("BackupMainActivity", "backupSwitchBtn is null.");
            return;
        }
        boolean zIsChecked = unionSwitch.isChecked();
        boolean z10 = false;
        if (!zM19624v2 && zIsChecked) {
            this.f13628l0.setCheckedProgrammatically(false);
            zIsChecked = this.f13628l0.isChecked();
        }
        AlertDialog alertDialog = this.f13643s1;
        boolean z11 = (alertDialog != null && alertDialog.isShowing()) || ((closeBackupSwitchAlertDialog = this.f13630m0) != null && closeBackupSwitchAlertDialog.isShowing());
        C11839m.m70686d("BackupMainActivity", "onResume isSwitchOpen  " + zM19624v2 + ",checked  " + zIsChecked + " isOnCloseSwitch = " + z11);
        if (!z11 && zM19624v2 && !zIsChecked) {
            this.f13628l0.setCheckedProgrammatically(true);
            if (this.f14158q == null) {
                m18723E6();
            } else {
                m18723E6();
                Message messageObtain = Message.obtain();
                messageObtain.obj = this.f14158q;
                m19611X2(messageObtain);
            }
        }
        int iM75932b = C12591s1.m75931a().m75932b();
        C11839m.m70688i("BackupMainActivity", "<onResume> status: " + iM75932b);
        if (iM75932b >= 0 && iM75932b != 4) {
            z10 = true;
        }
        this.f14149S = z10;
        if (iM75932b >= 0) {
            m18723E6();
            m19619m2();
        }
        m18747L6(C10028c.m62182c0().m62413x());
        mo18820p2();
        C11839m.m70688i("BackupMainActivity", "<onResume> isRiskEffective: " + C2987p.m17951a(this));
        if (this.f13597S0 != null) {
            int iM81091f = C13467g.m81086c().m81091f();
            this.f13597S0.setText(getResources().getQuantityString(R$plurals.auto_backup_frequency, iM81091f, Integer.valueOf(iM81091f)));
        }
        m18796f6();
        m18793e6();
        m18834v5();
        C9158a.m57503F().m57539f("backupHomePage", this.f13623i1);
        this.f13608b0.m4962h(AbstractC0791h.b.ON_RESUME);
        C11839m.m70688i("BackupMainActivity", "<onResume> end.");
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            C11839m.m70686d("BackupMainActivity", "onSaveInstanceState");
            bundle.putBoolean("enter_background", true);
        } catch (Exception e10) {
            C11839m.m70687e("BackupMainActivity", "onSaveInstanceState  fail==" + e10.toString());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m18740J6(null);
        this.f13608b0.m4962h(AbstractC0791h.b.ON_START);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        this.f13608b0.m4962h(AbstractC0791h.b.ON_STOP);
        super.onStop();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: p2 */
    public void mo18820p2() {
        super.mo18820p2();
        if (this.f13583L0 != null) {
            if (C0209d.m1333z1(this) || CBAccess.isAppDataPreparing()) {
                this.f13583L0.m23914a();
                return;
            }
            this.f13583L0.m23919i();
            C13225d.m79490f1().m79585f0("action_code_backup_detail_wait_wlan", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_backup_detail_wait_wlan", "4", "78");
        }
    }

    /* renamed from: p5 */
    public final void m18821p5() {
        Intent intent = "myHuawei".equals(this.f13603X0) ? new Intent(this, (Class<?>) BackupOptionsRefurbishActivity.class) : new Intent(this, (Class<?>) BackupOptionsActivity.class);
        C13225d.m79490f1().m79585f0("mecloud_backupmain_click_backup_option", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(intent, "1", "17");
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_backup_option", "1", "17");
        intent.putExtra("deviceCategory", this.f13647u1);
        intent.putExtra("terminalType", this.f13645t1);
        startActivityForResult(intent, 10040);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: p6 */
    public final void m18822p6(LinkedList<C4867a> linkedList, int i10) {
        this.f13654y0.m24327e(linkedList, i10);
        m18819o6(linkedList);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: q2 */
    public void mo18823q2() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("BackupMainActivity", "<initView> start.");
        super.mo18823q2();
        this.f13615e1 = new ConfirmJumpRefurbishDialog(this, this);
        this.f13618g0 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13622i0 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f13624j0 = C12809f.m76829b(this, R$id.main_view_layout);
        this.f13626k0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_ll_open);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.backup_main_switch_btn);
        this.f13628l0 = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws JSONException, IllegalAccessException, IllegalArgumentException {
                this.f17780a.onCheckedChanged(compoundButton, z10);
            }
        });
        this.f13628l0.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f17794a.m18754P5();
            }
        });
        NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_backup_option);
        this.f13585M0 = notchFitRelativeLayout;
        notchFitRelativeLayout.setOnClickListener(this);
        NotchFitRelativeLayout notchFitRelativeLayout2 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_backup_frequency);
        this.f13587N0 = notchFitRelativeLayout2;
        notchFitRelativeLayout2.setOnClickListener(this);
        this.f13589O0 = C12809f.m76829b(this, R$id.auto_backup_divider);
        this.f13638q0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.backup_title_layout);
        this.f13640r0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.backup_main_region);
        C10718a c10718a = new C10718a(this);
        this.f13573G0 = c10718a;
        c10718a.m65432m("backUp");
        this.f13591P0 = (LinearLayout) C12809f.m76829b(this, R$id.ll_backup_open);
        this.f13593Q0 = (TextView) C12809f.m76829b(this, R$id.backup_open_time);
        this.f13582K1 = C12809f.m76829b(this, R$id.switch_divider);
        this.f13584L1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_backup_record);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.backup_learn_about);
        textView.setOnClickListener(this);
        textView.setVisibility(C13452e.m80781L().m80887a1() ? 8 : 0);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.cloud_backup_read_support);
        textView2.setOnClickListener(this);
        this.f13595R0 = (TextView) C12809f.m76829b(this, R$id.tv_frequency);
        this.f13597S0 = (TextView) C12809f.m76829b(this, R$id.tv_current_frequency);
        int iM81091f = C13467g.m81086c().m81091f();
        this.f13597S0.setText(getResources().getQuantityString(R$plurals.auto_backup_frequency, iM81091f, Integer.valueOf(iM81091f)));
        this.f13600U0 = (HwProgressBar) C12809f.m76829b(this, R$id.frequency_loading_bar);
        this.f13599T0 = (CloudBackupStateMainView) C12809f.m76829b(this, R$id.clloud_backup_state_view);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.oepn_service_button);
        this.f13631m1 = (RelativeLayout) C12809f.m76829b(this, R$id.open_function_item_empty_layout);
        this.f13633n1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.hicloud_open_function_item_layout_frame);
        hwButton.setOnClickListener(this);
        m18747L6(C10028c.m62182c0().m62413x());
        this.f13583L0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f13601V0 = (TextLinkBar) C12809f.m76829b(this, R$id.text_link_bar);
        this.f13642s0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.text_link_region);
        this.f13644t0 = (LinearLayout) C12809f.m76829b(this, R$id.ll_manage_backup_data_card_view);
        this.f13646u0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_device_list_title_view);
        this.f13648v0 = (TextView) C12809f.m76829b(this, R$id.device_list_title);
        this.f13650w0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_device_list_view);
        this.f13652x0 = (HwRecyclerView) C12809f.m76829b(this, R$id.device_list);
        this.f13654y0 = (TempBackupRecordsFragment) C12809f.m76828a(getFragmentManager(), R$id.fragment_temp_backup_records);
        ((NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_backup_data_layout)).setOnClickListener(this);
        this.f13651w1 = (HwProgressBar) C12809f.m76829b(this, R$id.backup_data_progressbar);
        this.f13649v1 = (TextView) C12809f.m76829b(this, R$id.backup_device_used_space);
        this.f13657z1 = (TextView) C12809f.m76829b(this, R$id.backup_data_title);
        this.f13620h0 = (SpaceRemindCardView) C12809f.m76829b(this, R$id.space_remind_view);
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = 0;
            textView2.setLayoutParams(layoutParams);
        }
        m18715A6();
        if ("HuaweiService".equals(this.f13627k1)) {
            m18716B5(true);
        }
        mo13327n1();
        m18839x5();
        mo18741K2(true);
        C11839m.m70688i("BackupMainActivity", "<initView> end.");
    }

    /* renamed from: q5 */
    public final void m18824q5(Message message) {
        int i10 = message.arg1;
        int i11 = message.arg2;
        if (i11 != 4 || 33045 != message.what) {
            C11839m.m70689w("BackupMainActivity", "deleteFrom = " + i11 + " ; what = " + message.what);
            return;
        }
        Integer numM66437p = C11019b.m66371t().m66437p(i10);
        C11839m.m70688i("BackupMainActivity", "deleteStatus = " + i10 + " ; toastTxt = " + numM66437p + " ; isBasicBusiness = " + this.f13588N1);
        m18770V4();
        if (numM66437p != null) {
            C11841o.m70707c(this, numM66437p.intValue(), 0);
            m18728G4();
        } else {
            m18759R4();
            m18808j6();
        }
    }

    /* renamed from: r5 */
    public final void m18825r5(Message message) {
        String str;
        String string = message.obj.toString();
        if (TextUtils.isEmpty(string)) {
            C11839m.m70687e("BackupMainActivity", "handleLearAboutClick host is empty set default");
            string = "";
        }
        String strM1636n = C0234s.m1636n();
        if ("zh".equalsIgnoreCase(strM1636n) || "bo".equalsIgnoreCase(strM1636n) || "ug".equalsIgnoreCase(strM1636n)) {
            str = string + "/cch5/hidisk/10.7.0/index.html";
        } else {
            str = string + "/cch5/hidisk/10.7.0EN/index.html";
        }
        C12590s0.m75736D1(C0213f.m1377a(), str, getString(R$string.backup_learn_about));
    }

    /* renamed from: r6 */
    public final void m18826r6(boolean z10) {
        if (this.f13588N1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("status", z10 ? "1" : "2");
            C13225d.m79490f1().m79591l0("basic_click_switch", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "basic_click_switch", linkedHashMap);
        }
    }

    /* renamed from: s5 */
    public final void m18827s5() {
        C11839m.m70688i("BackupMainActivity", "refresh user grade code");
        if (this.f13611c1 != null) {
            C11839m.m70688i("BackupMainActivity", "reset auto backup frequency dialog");
            this.f13611c1.dismiss();
        }
    }

    /* renamed from: s6 */
    public final void m18828s6(HiCloudSafeIntent hiCloudSafeIntent) {
        String strM29113i = hiCloudSafeIntent.m29113i("entry_source", "entry_undefined");
        this.f13641r1 = strM29113i;
        if ("entry_backup_notify".equals(strM29113i)) {
            String strM29113i2 = hiCloudSafeIntent.m29113i("notify_type", "");
            if (TextUtils.isEmpty(strM29113i2)) {
                return;
            }
            C13225d.m79490f1().m79585f0(strM29113i2, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", strM29113i2, "4", "78");
        }
    }

    /* renamed from: t5 */
    public final void m18829t5() {
        this.f13649v1.setVisibility(8);
    }

    /* renamed from: t6 */
    public final void m18830t6(ArrayList<String> arrayList) {
        C12515a.m75110o().m75172d(new C3017c(arrayList, true));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: u2 */
    public boolean mo18831u2() {
        return false;
    }

    /* renamed from: u5 */
    public final void m18832u5() {
        View view = this.f13656z0;
        if (view == null) {
            C11839m.m70689w("BackupMainActivity", "deviceListHeaderView is null");
            return;
        }
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(view, R$id.device_name_duplicate_tip);
        String string = getString(R$string.login_devices_management_prompt);
        m18842y6(spanClickText, getString(R$string.backup_device_names_duplicate_prompt, string), string);
        spanClickText.setVisibility(0);
        this.f13656z0.setVisibility(0);
        C12809f.m76843p(this.f13563B0, true);
    }

    /* renamed from: u6 */
    public final void m18833u6(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra("from_welcome_backup", false)) {
                C11839m.m70688i("BackupMainActivity", "finish backup welcome");
                Intent intent2 = new Intent();
                intent2.setAction("finish_welcome_backup_action");
                C13108a.m78878b(this).m78881d(intent2);
            }
        } catch (RuntimeException e10) {
            C11839m.m70687e("BackupMainActivity", "sendFinishWelcomeBrocast error " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        if (m18734H6()) {
            return true;
        }
        return super.mo13429v1(i10, keyEvent);
    }

    /* renamed from: v5 */
    public final void m18834v5() {
        C11839m.m70688i("BackupMainActivity", "<initBackupOptions>");
        CloudBackupOptionTask cloudBackupOptionTask = new CloudBackupOptionTask(this, this.f13585M0);
        this.f13592P1 = cloudBackupOptionTask;
        cloudBackupOptionTask.m18087S(new C3132e());
        C12515a.m75110o().m75172d(this.f13592P1);
    }

    /* renamed from: v6 */
    public final void m18835v6(long j10) {
        this.f13649v1.setText(C0223k.m1524g(this, j10));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupStateActivity
    /* renamed from: w2 */
    public boolean mo18836w2() {
        return false;
    }

    /* renamed from: w5 */
    public final void m18837w5(BackupStorageInfo backupStorageInfo, Message message) {
        this.f13653x1 = null;
        if (backupStorageInfo.getBackupDetails() == null || backupStorageInfo.getCurrentDeviceBackupDetails() == null) {
            m18829t5();
            this.f13655y1 = 3;
            C11839m.m70688i("BackupMainActivity", "initDeviceStorageData backupDetails size = 0 or currentDeviceSpaceDetail = null");
        } else {
            CBSpaceDetail currentDeviceBackupDetails = backupStorageInfo.getCurrentDeviceBackupDetails();
            long size = currentDeviceBackupDetails.getSize();
            this.f13653x1 = currentDeviceBackupDetails;
            if (size == 0) {
                m18829t5();
                this.f13655y1 = 3;
            } else {
                this.f13649v1.setVisibility(0);
                m18835v6(size);
            }
            C13465e.m81052f().m81065n("currentDeviceBackupedDataSize", size);
        }
        CBSpaceDetail cBSpaceDetail = this.f13653x1;
        if (cBSpaceDetail != null && cBSpaceDetail.isHasRefurbish() && this.f13655y1 == 3) {
            this.f13653x1.setOnlyRefurbish(true);
        }
    }

    /* renamed from: w6 */
    public final void m18838w6() {
        if (this.f13629l1 >= 1.75f) {
            setContentView(R$layout.backup_main_new_font_scale);
        } else {
            setContentView(R$layout.backup_main_new);
        }
        try {
            View viewFindViewById = this.f13629l1 >= 1.75f ? findViewById(R$id.vs_backup_frequencey2) : findViewById(R$id.vs_backup_frequencey1);
            if (viewFindViewById instanceof ViewStub) {
                ((ViewStub) viewFindViewById).inflate();
            }
        } catch (Exception e10) {
            C11839m.m70687e("BackupMainActivity", "adaptOldByFontScale --- " + e10.getMessage());
        }
    }

    /* renamed from: x5 */
    public final void m18839x5() {
        this.f13644t0.setVisibility(8);
        this.f13646u0.setVisibility(0);
        this.f13650w0.setVisibility(0);
        View viewInflate = getLayoutInflater().inflate(R$layout.cloud_space_backup_activity_device_list_header, (ViewGroup) null);
        this.f13656z0 = viewInflate;
        this.f13563B0 = (LinearLayout) C12809f.m76831d(viewInflate, R$id.header_view);
        BackupMainDeviceAdapter backupMainDeviceAdapter = new BackupMainDeviceAdapter(this, this);
        this.f13561A0 = backupMainDeviceAdapter;
        backupMainDeviceAdapter.m24742E(this.f13656z0);
        this.f13652x0.setAdapter(this.f13561A0);
        this.f13652x0.setLayoutManager(new BackupMainDeviceAdapter.LayoutManager(this));
        this.f13652x0.addOnItemTouchListener(new BackupMainDeviceAdapter.C4021c());
        this.f13652x0.setFocusableInTouchMode(false);
        this.f13652x0.setItemAnimator(null);
        this.f13652x0.stopScroll();
        this.f13610c0 = 1;
        m18776Y5();
    }

    /* renamed from: x6 */
    public final void m18840x6(String str, String str2) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int iM62252O = c10028cM62182c0.m62252O(str);
        if (iM62252O <= 2) {
            iM62252O++;
        }
        c10028cM62182c0.m62202D2(str, iM62252O);
        c10028cM62182c0.m62197C2(str2, new Date().getTime());
    }

    /* renamed from: y5 */
    public final void m18841y5() {
        this.f13601V0.setEntrance("backupHomePage");
        this.f13601V0.showContent(this.f13602W0);
        C11839m.m70688i("BackupMainActivity", "initTextLinkView success");
    }

    /* renamed from: y6 */
    public final void m18842y6(final SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.k
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17651a.m18757Q5(spanClickText);
            }
        });
        spanClickText.m15934g(str, false);
    }

    /* renamed from: z5 */
    public final boolean m18843z5(String str) {
        BackupOptionItem backupOptionItemM78401y = new C13026e().m78401y(str);
        return backupOptionItemM78401y != null && backupOptionItemM78401y.getBackupSwitch();
    }
}
