package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupModuleInfoQueryLogic;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionRefurbishAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseOptionStatusDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RefurbishConfirmationDialog;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.hicloud.task.simple.C3048j2;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.view.widget.HiCloudAutoSizeButton;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import hu.C10343b;
import il.C10542o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10155f;
import p495nm.C11727h;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12541c;
import p618rm.C12580p;
import p618rm.C12585q1;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p664u0.C13108a;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p815ym.AbstractC14026a;
import p847zk.C14317j;
import p848zl.C14333b;
import sk.C12809f;
import tl.C13026e;
import vn.C13471c;

/* loaded from: classes3.dex */
public class BackupOptionsRefurbishActivity extends CloudBackupBaseUiActivity implements View.OnClickListener, BackupOptionRefurbishAdapter.UpdateOptionStatusListener, AdapterView.OnItemClickListener {

    /* renamed from: C */
    public NotchFitRelativeLayout f13802C;

    /* renamed from: D */
    public RecyclerView f13803D;

    /* renamed from: E */
    public RelativeLayout f13804E;

    /* renamed from: F */
    public HiCloudAutoSizeButton f13805F;

    /* renamed from: G */
    public RelativeLayout f13806G;

    /* renamed from: H */
    public HiCloudAutoSizeButton f13807H;

    /* renamed from: I */
    public NotchFitRelativeLayout f13808I;

    /* renamed from: J */
    public NotchTopFitRelativeLayout f13809J;

    /* renamed from: K */
    public HwProgressBar f13810K;

    /* renamed from: L */
    public BackupOptionRefurbishAdapter f13811L;

    /* renamed from: M */
    public C13465e f13812M;

    /* renamed from: S */
    public C13026e f13818S;

    /* renamed from: T */
    public CloseOptionStatusDialog f13819T;

    /* renamed from: U */
    public AlertDialog f13820U;

    /* renamed from: W */
    public CloudBackupState f13822W;

    /* renamed from: X */
    public RelativeLayout f13823X;

    /* renamed from: Y */
    public HiCloudAutoSizeButton f13824Y;

    /* renamed from: Z */
    public RelativeLayout f13825Z;

    /* renamed from: a0 */
    public Button f13826a0;

    /* renamed from: b0 */
    public HwProgressBar f13827b0;

    /* renamed from: c0 */
    public List<BackupOptionItem> f13828c0;

    /* renamed from: d0 */
    public AlertDialog f13829d0;

    /* renamed from: e0 */
    public AsyncTaskC3161e f13830e0;

    /* renamed from: f0 */
    public RefurbishConfirmationDialog f13831f0;

    /* renamed from: g0 */
    public RefurbishConfirmationDialog f13832g0;

    /* renamed from: N */
    public BackupOptionItem f13813N = new BackupOptionItem();

    /* renamed from: O */
    public List<BackupOptionItem> f13814O = new ArrayList();

    /* renamed from: P */
    public List<String> f13815P = new ArrayList();

    /* renamed from: Q */
    public boolean f13816Q = false;

    /* renamed from: R */
    public boolean f13817R = false;

    /* renamed from: V */
    public long f13821V = 0;

    /* renamed from: h0 */
    public final Handler f13833h0 = new HandlerC3160d(this, null);

    /* renamed from: i0 */
    public boolean f13834i0 = true;

    /* renamed from: j0 */
    public Handler.Callback f13835j0 = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.o1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17689a.m19091I2(message);
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$a */
    public class C3157a implements RefurbishConfirmationDialog.ClickCallback {

        /* renamed from: a */
        public final /* synthetic */ Context f13836a;

        /* renamed from: b */
        public final /* synthetic */ List f13837b;

        public C3157a(Context context, List list) {
            this.f13836a = context;
            this.f13837b = list;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishConfirmationDialog.ClickCallback
        public void onRefurbishCancel() {
            BackupOptionsRefurbishActivity.this.f13831f0.dismiss();
            C11839m.m70688i("BackupOptionsRefurbishActivity", "onRefurbishContinue: twins app cancel.");
            BackupOptionsRefurbishActivity.this.m19135S2("action_code_refurbish_twin_app_click_cancel", BackupOptionsRefurbishActivity.m19114t2(this.f13837b));
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishConfirmationDialog.ClickCallback
        public void onRefurbishContinue() {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "onRefurbishContinue: twins app click.");
            BackupOptionsRefurbishActivity.this.f13831f0.dismiss();
            BackupOptionsRefurbishActivity.this.m19140Y2(this.f13836a);
            BackupOptionsRefurbishActivity.this.m19135S2("action_code_refurbish_twin_app_click_continue", BackupOptionsRefurbishActivity.m19114t2(this.f13837b));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$b */
    public class C3158b implements RefurbishConfirmationDialog.ClickCallback {
        public C3158b() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishConfirmationDialog.ClickCallback
        public void onRefurbishCancel() {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "onRefurbishCancel: import app tips click cancel.");
            BackupOptionsRefurbishActivity.this.f13832g0.dismiss();
            BackupOptionsRefurbishActivity backupOptionsRefurbishActivity = BackupOptionsRefurbishActivity.this;
            backupOptionsRefurbishActivity.m19135S2("action_code_refurbish_important_app_click_cancel", backupOptionsRefurbishActivity.m19157s2());
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishConfirmationDialog.ClickCallback
        public void onRefurbishContinue() {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "onRefurbishContinue: import app tips click continue.");
            BackupOptionsRefurbishActivity.this.f13832g0.dismiss();
            BackupOptionsRefurbishActivity.this.m19146e3();
            BackupOptionsRefurbishActivity backupOptionsRefurbishActivity = BackupOptionsRefurbishActivity.this;
            backupOptionsRefurbishActivity.m19135S2("action_code_refurbish_important_app_click_continue", backupOptionsRefurbishActivity.m19157s2());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$c */
    public class C3159c extends AbstractC12367d {
        public C3159c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            List<BackupOptionItem> listM78397u;
            ArrayList arrayList = new ArrayList();
            boolean z10 = true;
            if (BackupOptionsRefurbishActivity.this.f13818S != null && (listM78397u = BackupOptionsRefurbishActivity.this.f13818S.m78397u()) != null && !listM78397u.isEmpty()) {
                for (BackupOptionItem backupOptionItem : listM78397u) {
                    String parent = backupOptionItem.getParent();
                    String appId = backupOptionItem.getAppId();
                    int uid = backupOptionItem.getUid();
                    boolean backupSwitch = backupOptionItem.getBackupSwitch();
                    if (!"baseData".equals(parent) && uid == 0 && !backupSwitch) {
                        C11839m.m70686d("BackupOptionsRefurbishActivity", "reportBackupNow isAllCheck = false appId = " + appId);
                        arrayList.add(appId);
                        z10 = false;
                    }
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("is_refurbish", Boolean.valueOf(C10028c.m62182c0().m62325f1()));
            linkedHashMap.put("refurbish_option_all", String.valueOf(z10));
            linkedHashMap.put("refurbish_close_modules", Arrays.toString((String[]) arrayList.toArray(new String[0])));
            C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", "1", "", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", "1", "", linkedHashMap);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$d */
    public static class HandlerC3160d extends Handler {

        /* renamed from: a */
        public final WeakReference<BackupOptionsRefurbishActivity> f13841a;

        public /* synthetic */ HandlerC3160d(BackupOptionsRefurbishActivity backupOptionsRefurbishActivity, C3157a c3157a) {
            this(backupOptionsRefurbishActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BackupOptionsRefurbishActivity backupOptionsRefurbishActivity = this.f13841a.get();
            if (backupOptionsRefurbishActivity == null || backupOptionsRefurbishActivity.isFinishing()) {
                return;
            }
            if (message.what == 33428) {
                backupOptionsRefurbishActivity.m19139X2(message);
                return;
            }
            C11839m.m70687e("BackupOptionsRefurbishActivity", "cloudBackupHandler invalid message :" + message.what);
        }

        public HandlerC3160d(BackupOptionsRefurbishActivity backupOptionsRefurbishActivity) {
            this.f13841a = new WeakReference<>(backupOptionsRefurbishActivity);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$e */
    public class AsyncTaskC3161e extends AsyncTask<Void, Void, Void> {
        public AsyncTaskC3161e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            C12585q1.m75709s();
            C13466f.m81073d().m81082j("backup_read_om_config_state", -1);
            C12585q1.m75691a("BackupOptionsRefurbishActivity");
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            if (CloudBackupAppDataUtil.getRefurbishVersion(true) == 0) {
                BackupOptionsRefurbishActivity.this.m19142a3();
                return;
            }
            boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
            BackupOptionsRefurbishActivity.this.f13817R = zM62388s;
            if (zM62388s) {
                BackupOptionsRefurbishActivity.this.m19122C2();
            } else {
                BackupOptionsRefurbishActivity.this.m19152l2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupOptionsRefurbishActivity$f */
    public static class C3162f extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<BackupOptionsRefurbishActivity> f13843a;

        public /* synthetic */ C3162f(BackupOptionsRefurbishActivity backupOptionsRefurbishActivity, C3157a c3157a) {
            this(backupOptionsRefurbishActivity);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            CloudBackupUserInfo cloudBackupUserInfoM64691s1;
            C11839m.m70688i("BackupOptionsRefurbishActivity", "ShowBackupOptionListTask start.");
            BackupOptionsRefurbishActivity backupOptionsRefurbishActivity = this.f13843a.get();
            if (backupOptionsRefurbishActivity == null) {
                C11839m.m70689w("BackupOptionsRefurbishActivity", "ShowBackupOptionListTask backupOptionsActivity is null");
                return;
            }
            if (backupOptionsRefurbishActivity.f13834i0) {
                C11839m.m70688i("BackupOptionsRefurbishActivity", "ShowBackupOptionListTask clear last backup options");
                new C13026e(true).clear();
                backupOptionsRefurbishActivity.f13834i0 = false;
            }
            long jM81056d = backupOptionsRefurbishActivity.f13812M.m81056d(true);
            long jCurrentTimeMillis = System.currentTimeMillis() - jM81056d;
            boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
            if (jCurrentTimeMillis < 604800000 || zM75158X0) {
                C11839m.m70688i("BackupOptionsRefurbishActivity", "option items in sp is valid, no need to scan files, lastTime: " + jM81056d);
                backupOptionsRefurbishActivity.m19121B2();
            } else {
                C11839m.m70688i("BackupOptionsRefurbishActivity", "option items in sp is invalid, lastTime: " + jM81056d + " , millis: " + jCurrentTimeMillis);
                backupOptionsRefurbishActivity.m19120A2();
            }
            C12515a.m75110o().m75166b(GetOptionsInfoFromCloneTask.class.getName());
            try {
                cloudBackupUserInfoM64691s1 = new C10542o().m64691s1();
            } catch (Exception e10) {
                C11839m.m70687e("BackupOptionsRefurbishActivity", "ShowBackupOptionListTask,  queryLastRecordDetails e : " + e10.getMessage());
                cloudBackupUserInfoM64691s1 = null;
            }
            C12515a.m75110o().m75175e(new GetOptionsInfoFromCloneTask(true, CBAccess.hasValidTempBackup(), cloudBackupUserInfoM64691s1), false);
            C11839m.m70688i("BackupOptionsRefurbishActivity", "ShowBackupOptionListTask end.");
        }

        public C3162f(BackupOptionsRefurbishActivity backupOptionsRefurbishActivity) {
            this.f13843a = new WeakReference<>(backupOptionsRefurbishActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I2 */
    public /* synthetic */ boolean m19091I2(Message message) throws IllegalAccessException, IllegalArgumentException {
        BackupOptionRefurbishAdapter backupOptionRefurbishAdapter;
        switch (message.what) {
            case 33001:
                String str = (String) message.obj;
                BackupOptionRefurbishAdapter backupOptionRefurbishAdapter2 = this.f13811L;
                if (backupOptionRefurbishAdapter2 != null) {
                    backupOptionRefurbishAdapter2.m24791Z(this.f13803D, str);
                    break;
                }
                break;
            case 33023:
                m19159v2();
                break;
            case 33025:
                m19138W2();
                break;
            case 33026:
                m19148g3();
                m19153m2();
                finish();
                break;
            case 33027:
                int i10 = message.arg1;
                C11839m.m70688i("BackupOptionsRefurbishActivity", "refurbish response error. errCode: " + i10);
                if (i10 == 3921) {
                    m19143b3();
                    break;
                }
                break;
            case 43005:
            case 43006:
                m19149i3((BackupOptionItem) message.obj);
                break;
            case 43008:
                m19141Z2(this.f13814O);
                break;
            case 43010:
                m19137V2(true);
                break;
            case 43021:
                List<BackupOptionItem> list = (List) message.obj;
                this.f13828c0 = list;
                if (list != null && (backupOptionRefurbishAdapter = this.f13811L) != null && backupOptionRefurbishAdapter.m24776K() != null && !this.f13811L.m24776K().isEmpty()) {
                    m19132P2(this.f13828c0);
                    this.f13811L.m24772G(m19158u2());
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: J2 */
    public static /* synthetic */ void m19092J2(DialogInterface dialogInterface, int i10) {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "dialog click ok");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: T2 */
    private void m19094T2(int i10, Object obj) {
        Message message = new Message();
        message.what = i10;
        if (obj != null) {
            message.obj = obj;
        }
        CBCallBack.getInstance().sendMessage(message);
    }

    /* renamed from: c3 */
    private void m19104c3() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.hicloud_new_backup_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.new_backup_auto);
        ((TextView) C12809f.m76831d(viewInflate, R$id.backup_tip)).setVisibility(8);
        textView.setText(getString(R$string.backup_option_basic_sys_data_tips, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp")));
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || (movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate).setTitle(R$string.backup_option_sys_tip_title).setPositiveButton(R$string.cloud_space_dialog_know, new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.n1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17679a.m19127K2(dialogInterface, i10);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.f13820U = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: h3 */
    private void m19110h3(BackupOptionItem backupOptionItem) {
        List<BackupOptionItem> list = this.f13828c0;
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

    /* renamed from: p2 */
    private Context m19112p2() {
        return C0213f.m1377a();
    }

    /* renamed from: r2 */
    private long m19113r2(String str) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem != null) {
            return backupOptionItemQueryItem.getDataBytes();
        }
        return 0L;
    }

    /* renamed from: t2 */
    public static LinkedHashMap m19114t2(List<BackupOptionItem> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_refurbish", Boolean.TRUE);
        linkedHashMap.put("refurbish_twin_app_ids", C12590s0.m75739E0(list).toString());
        return linkedHashMap;
    }

    /* renamed from: w2 */
    public static boolean m19115w2() {
        return !CBAccess.hasValidTempBackup() && (C12591s1.m75931a().m75935e() || C12591s1.m75931a().m75936f());
    }

    /* renamed from: x2 */
    private void m19116x2() {
        AsyncTaskC3161e asyncTaskC3161e = new AsyncTaskC3161e();
        this.f13830e0 = asyncTaskC3161e;
        asyncTaskC3161e.execute(new Void[0]);
    }

    /* renamed from: y2 */
    private void m19117y2() {
        this.f13812M = C13465e.m81052f();
        this.f13818S = new C13026e(true);
        BackupOptionRefurbishAdapter backupOptionRefurbishAdapter = new BackupOptionRefurbishAdapter(this, this);
        this.f13811L = backupOptionRefurbishAdapter;
        backupOptionRefurbishAdapter.m24787V(this);
        this.f13803D.setAdapter(this.f13811L);
        this.f13803D.setLayoutManager(new LinearLayoutManager(this));
        this.f13803D.setFocusableInTouchMode(false);
        this.f13803D.setItemAnimator(null);
        if (GetOptionsInfoFromCloneTask.isOptionTaskNotComplete()) {
            if (m19125F2()) {
                C11839m.m70686d("BackupOptionsRefurbishActivity", "millis = " + ((System.currentTimeMillis() - this.f13812M.m81056d(true)) / 1000));
                return;
            }
            if (System.currentTimeMillis() - this.f13812M.m81056d(true) > 604800000) {
                C11839m.m70688i("BackupOptionsRefurbishActivity", "delayTime = " + ((15000 - this.f13821V) / 1000));
            }
        }
    }

    /* renamed from: z2 */
    private void m19118z2() {
        this.f13809J = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13802C = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.record_detail_list);
        this.f13803D = (RecyclerView) C12809f.m76829b(this, R$id.record_sys_list);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_now);
        this.f13804E = relativeLayout;
        relativeLayout.setOnClickListener(this);
        if (!C12591s1.m75931a().m75943m()) {
            C11839m.m70689w("BackupOptionsRefurbishActivity", "refurbishUtil isSupportBase is false");
            if (!C12591s1.m75931a().m75944n()) {
                C11839m.m70689w("BackupOptionsRefurbishActivity", "check not support refurbish");
                this.f13804E.setVisibility(8);
            }
        }
        HiCloudAutoSizeButton hiCloudAutoSizeButton = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.bt_backup_pause);
        this.f13805F = hiCloudAutoSizeButton;
        hiCloudAutoSizeButton.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_continue);
        this.f13806G = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        HiCloudAutoSizeButton hiCloudAutoSizeButton2 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.bt_backup_complete);
        this.f13807H = hiCloudAutoSizeButton2;
        hiCloudAutoSizeButton2.setOnClickListener(this);
        HwProgressBar hwProgressBar = (HwProgressBar) C12809f.m76829b(this, R$id.click_backup_loading);
        this.f13810K = hwProgressBar;
        hwProgressBar.setVisibility(8);
        this.f13827b0 = (HwProgressBar) C12809f.m76829b(this, R$id.click_backup_continue_loading);
        this.f13808I = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f13823X = (RelativeLayout) C12809f.m76829b(this, R$id.refurbish_backup_layout);
        HiCloudAutoSizeButton hiCloudAutoSizeButton3 = (HiCloudAutoSizeButton) C12809f.m76829b(this, R$id.refurbished_backup_switch_button);
        this.f13824Y = hiCloudAutoSizeButton3;
        hiCloudAutoSizeButton3.setOnClickListener(this);
        if (C0209d.m1195O(this) >= 1.75f) {
            ViewGroup.LayoutParams layoutParams = this.f13824Y.getLayoutParams();
            layoutParams.height = -2;
            this.f13824Y.setLayoutParams(layoutParams);
        }
        this.f13825Z = (RelativeLayout) C12809f.m76829b(this, R$id.refurbish_offline_layout);
        Button button = (Button) C12809f.m76829b(this, R$id.refurbished_backup_know_button);
        this.f13826a0 = button;
        button.setOnClickListener(this);
        this.f13888s.setOnClickListener(this);
        this.f13895z.setOnClickListener(this);
        this.f13819T = new CloseOptionStatusDialog(this);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter.UpdateOptionStatusListener
    /* renamed from: A */
    public void mo19119A(int i10) {
        if (i10 == 0) {
            C11839m.m70686d("BackupOptionsRefurbishActivity", "on click show all event.");
            this.f13811L.m24785T(true);
            this.f13811L.m24788W(true);
        }
        if (this.f13828c0 != null) {
            if (i10 == 1) {
                C11839m.m70686d("BackupOptionsRefurbishActivity", "on click down arrow.");
                this.f13811L.m24785T(false);
                this.f13811L.m24772G(m19158u2());
            } else if (i10 == 2) {
                C11839m.m70686d("BackupOptionsRefurbishActivity", "on click up arrow.");
                this.f13811L.m24785T(true);
                this.f13811L.m24772G(m19158u2());
            }
        }
        this.f13811L.m5213j();
    }

    /* renamed from: A2 */
    public void m19120A2() {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "initOptionShow");
        BackupModuleInfoQueryLogic backupModuleInfoQueryLogic = new BackupModuleInfoQueryLogic(false, BackupModuleInfoQueryLogic.BackupType.REFURBISH, "BackupOptionsRefurbishActivity");
        this.f13815P.addAll(backupModuleInfoQueryLogic.getAppOptionInfo().getVirtuals());
        List<BackupOptionItem> virtualItemList = backupModuleInfoQueryLogic.getAppOptionInfo().getVirtualItemList();
        List<BackupOptionItem> systemItemList = backupModuleInfoQueryLogic.getAppOptionInfo().getSystemItemList();
        this.f13814O.clear();
        m19150j2();
        this.f13814O.addAll(systemItemList);
        this.f13814O.addAll(virtualItemList);
        List<BackupOptionItem> arrayList = new ArrayList<>();
        try {
            arrayList = m19123D2();
        } catch (C9721b e10) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "init third app data error, " + e10.getMessage());
        }
        this.f13814O.addAll(arrayList);
        m19094T2(43008, null);
    }

    /* renamed from: B2 */
    public void m19121B2() throws C9721b {
        List<BackupOptionItem> listM78397u = this.f13818S.m78397u();
        if (listM78397u == null || listM78397u.isEmpty()) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "no option cache, init option show");
            m19120A2();
            return;
        }
        C11839m.m70688i("BackupOptionsRefurbishActivity", "initOptionShowFromCache");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C12519c c12519c = new C12519c();
        List<String> listM75297h = c12519c.m75297h(2);
        this.f13815P = listM75297h;
        boolean zContains = listM75297h.contains("music");
        for (String str : C12541c.m75487b(false, null, false, C14333b.m85449E())) {
            BackupOptionItem backupOptionItemQueryParentItem = ICBUtil.queryParentItem(str, true);
            if (str.equals("music") && zContains) {
                backupOptionItemQueryParentItem.setParent("virtualApp");
            }
            arrayList.add(backupOptionItemQueryParentItem);
        }
        this.f13815P.removeAll(C14333b.m85476k());
        String str2 = m19112p2().getFilesDir() + "/cloudbackup";
        for (String str3 : this.f13815P) {
            if (new CloudBackupAppDataUtil(str3, str2, 0L, true, false).isAppDataAble()) {
                BackupOptionItem backupOptionItemM78401y = this.f13818S.m78401y(str3);
                if (backupOptionItemM78401y == null) {
                    backupOptionItemM78401y = new BackupOptionItem(str3, "virtualApp");
                    backupOptionItemM78401y.setBackupSwitch(true);
                    backupOptionItemM78401y.setBackupData(true);
                }
                backupOptionItemM78401y.setShowType(C0241z.m1685c(c12519c.m75305p(str3)));
                arrayList2.add(backupOptionItemM78401y);
            }
        }
        if (zContains) {
            this.f13815P.add("music");
        }
        this.f13813N = ICBUtil.queryAppDataItem(true);
        List<BackupOptionItem> listM78399w = this.f13818S.m78399w("thirdAppData");
        this.f13828c0 = listM78399w;
        if (listM78399w != null) {
            listM78399w.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.p1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
                }
            });
        }
        this.f13814O.clear();
        m19150j2();
        this.f13814O.addAll(arrayList);
        this.f13814O.addAll(arrayList2);
        this.f13814O.addAll(this.f13828c0);
        m19094T2(43008, null);
    }

    /* renamed from: C2 */
    public final void m19122C2() {
        m19117y2();
        C12515a.m75110o().m75172d(new C3162f(this, null));
        mo22385x1();
        CloudBackup3rdIconUtil.downloadVirtualIcon();
    }

    /* renamed from: D2 */
    public final List<BackupOptionItem> m19123D2() throws C9721b {
        ArrayList arrayList = new ArrayList();
        if (CBAccess.hasTaskWorking()) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "init refurbish third app in backup or restore, return.");
            return arrayList;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle backupModuleInfo = CloneService.getInstance().getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "initRefurbish3rdAppDataItemsList third app return;");
            return arrayList;
        }
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "initRefurbish3rdAppDataItemsList value is null");
            return arrayList;
        }
        ArrayList<String> arrayListM63696r = new C10343b(bundle).m63696r("AppPackageList");
        if (arrayListM63696r == null) {
            arrayListM63696r = new ArrayList<>();
        }
        List<String> listM75386e = new C12526j().m75386e();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(C2157a.m13200h());
        arrayList2.addAll(C14333b.m85454J());
        arrayList2.addAll(listM75386e);
        List<String> listM69970d = C11727h.m69967b().m69970d();
        if (!listM69970d.isEmpty()) {
            arrayList2.addAll(listM69970d);
        }
        List<String> listM69969c = C11727h.m69967b().m69969c();
        if (!listM69969c.isEmpty()) {
            arrayList2.addAll(listM69969c);
        }
        C11839m.m70688i("BackupOptionsRefurbishActivity", "add unSafePackageName: " + listM69970d + "  unRecognizedPackageName " + listM69969c);
        arrayListM63696r.removeAll(arrayList2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initRefurbish3rdAppDataItemsList time: ");
        sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
        C11839m.m70688i("BackupOptionsRefurbishActivity", sb2.toString());
        if (!arrayListM63696r.isEmpty()) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "initRefurbish3rdAppDataItemsList third app module list from clone: " + new Gson().toJson(arrayListM63696r));
            PackageManager packageManager = C0213f.m1377a().getPackageManager();
            for (String str : arrayListM63696r) {
                boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                while (zM75158X0) {
                    SystemClock.sleep(500L);
                    zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                    C11839m.m70688i("BackupOptionsRefurbishActivity", "initRefurbish3rdAppDataItemsList wait QueryOmAppBackupScopeTask appId " + str);
                }
                long versionCode = ICBUtil.getVersionCode(packageManager, str);
                String appName = ICBUtil.getAppName(packageManager, str);
                if (new CloudBackupAppDataUtil(str, C12586r.m75711b(), versionCode, true, false).isAppDataAble() && PmsCheckUtil.m12611e()) {
                    BackupOptionItem backupOptionItemM19154n2 = m19154n2(str, 0, true);
                    backupOptionItemM19154n2.setParent("thirdAppData");
                    backupOptionItemM19154n2.setBackupData(true);
                    if (!TextUtils.isEmpty(appName)) {
                        str = appName;
                    }
                    backupOptionItemM19154n2.setAppName(str);
                    arrayList.add(backupOptionItemM19154n2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: E2 */
    public void m19124E2() {
        LayoutInflater.from(this).inflate((C11842p.m70747M0(this) || C11842p.m70771U0()) ? R$layout.activity_backup_option_refurbish_pad : R$layout.activity_backup_option_refurbish, (ViewGroup) this.f13894y, true);
        m19118z2();
        mo19005p1();
        m19116x2();
    }

    /* renamed from: F2 */
    public boolean m19125F2() {
        this.f13821V = this.f13812M.m81058g("getDataTime", 0L);
        C11839m.m70688i("BackupOptionsRefurbishActivity", "lastGetDataTime = " + (this.f13821V / 1000));
        return this.f13821V > 15000;
    }

    /* renamed from: G2 */
    public boolean m19126G2() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.phoneservice.renovation.notification");
        C0209d.m1302r2(intent, ICBBroadcastManager.MYHUAWEI_PACKAGE);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("IntentSource", "cloudbackup");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "context is null.");
            return false;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return false;
        }
        startActivityForResult(intent, 10045);
        return true;
    }

    /* renamed from: K2 */
    public final /* synthetic */ void m19127K2(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog = this.f13820U;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: L2 */
    public void m19128L2(boolean z10, String str) {
        m19129M2(z10, str, Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: M2 */
    public void m19129M2(boolean z10, String str, Long l10) {
        if (TransferedUtil.queryItem(str, true) == null) {
            m19155o2(str, z10, l10);
        }
        if ("thirdAppData".equals(str)) {
            return;
        }
        if (!TextUtils.equals(NavigationUtils.SMS_SCHEMA_PREF, str) && !TextUtils.equals("soundrecorder", str)) {
            this.f13818S.m78378M(z10, str, l10);
            return;
        }
        List<BackupOptionItem> listM78399w = this.f13818S.m78399w(str);
        if (listM78399w == null || listM78399w.isEmpty()) {
            this.f13818S.m78378M(z10, str, l10);
            return;
        }
        Iterator<BackupOptionItem> it = listM78399w.iterator();
        while (it.hasNext()) {
            this.f13818S.m78378M(z10, it.next().getAppId(), l10);
        }
    }

    /* renamed from: N2 */
    public void m19130N2(String str, boolean z10) {
        m19128L2(z10, str);
        this.f13811L.m24792a0(this.f13803D, str, z10);
        C12515a.m75110o().m75172d(new C3048j2(str, z10, -1, false, m19113r2(str), true, this.f13811L.m24776K()));
        m19137V2(false);
        m19134R2(str, false);
        C11839m.m70688i("BackupOptionsRefurbishActivity", "onSystemItemChanged appId: " + str);
    }

    /* renamed from: O2 */
    public void m19131O2(boolean z10) {
        CloudBackupService.getInstance().abort(z10 ? PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED : 1001);
    }

    /* renamed from: P2 */
    public final void m19132P2(List<BackupOptionItem> list) {
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackupOptionItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAppId());
        }
        Iterator<BackupOptionItem> it2 = this.f13814O.iterator();
        while (it2.hasNext()) {
            BackupOptionItem next = it2.next();
            if (arrayList.contains(next.getAppId())) {
                it2.remove();
            } else if ("thirdAppData".equals(next.getParent()) && !arrayList.contains(next.getAppId())) {
                it2.remove();
            }
        }
        this.f13814O.addAll(list);
        C11839m.m70688i("BackupOptionsRefurbishActivity", "refresh3rdAppModuleList size = " + list.size());
    }

    /* renamed from: Q2 */
    public final void m19133Q2() {
        C12515a.m75110o().m75172d(new C3159c());
    }

    /* renamed from: R2 */
    public final void m19134R2(String str, boolean z10) {
        HashMap map = new HashMap();
        map.put(str, Boolean.valueOf(z10));
        C12515a.m75110o().m75175e(new C3017c(true, (Map<String, Boolean>) map), false);
    }

    /* renamed from: S2 */
    public final void m19135S2(String str, LinkedHashMap linkedHashMap) {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "Start reportRefurbishTips:" + str);
        C13225d.m79490f1().m79573U(str, linkedHashMap);
        C13225d.m79490f1().m79590k0(str, "1", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", str, "1", "43", "1", "", linkedHashMap);
    }

    /* renamed from: U2 */
    public final void m19136U2() {
        this.f13811L.m24788W(true);
        this.f13811L.m5213j();
    }

    /* renamed from: V2 */
    public void m19137V2(boolean z10) {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "show backup data size, is first show: " + z10 + ", isShowDataSize: " + this.f13816Q);
        if (z10) {
            this.f13816Q = true;
        }
        if (this.f13816Q) {
            this.f13811L.m24794c0(C0223k.m1524g(C0213f.m1377a(), C12590s0.m75908u0()));
            BackupOptionItem backupOptionItemQueryAppDataItem = ICBUtil.queryAppDataItem(true);
            this.f13813N = backupOptionItemQueryAppDataItem;
            m19149i3(backupOptionItemQueryAppDataItem);
            this.f13812M.m81065n("getDataTime", 0L);
            if (z10) {
                m19141Z2(this.f13814O);
            }
        }
    }

    /* renamed from: W2 */
    public void m19138W2() {
        RelativeLayout relativeLayout = this.f13804E;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f13810K.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = this.f13806G;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() != 0) {
            return;
        }
        this.f13827b0.setVisibility(0);
    }

    /* renamed from: X2 */
    public void m19139X2(Message message) {
        CloudBackupState cloudBackupState = (CloudBackupState) message.obj;
        this.f13822W = cloudBackupState;
        if (cloudBackupState == null) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "showCloudBackupState");
            return;
        }
        int iIntValue = cloudBackupState.getState().intValue();
        if (this.f13822W.getId() == 1) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "backup state = " + this.f13822W.toString() + "  msg" + message.arg1);
            return;
        }
        if (this.f13822W.getId() == 2) {
            C11839m.m70689w("BackupOptionsRefurbishActivity", "restore state ");
            return;
        }
        C11839m.m70689w("BackupOptionsRefurbishActivity", "unknown state " + iIntValue);
    }

    /* renamed from: Y2 */
    public final void m19140Y2(Context context) {
        String strM75900s0 = C12590s0.m75900s0(this, this.f13811L.m24776K());
        if (!(!TextUtils.isEmpty(strM75900s0))) {
            m19146e3();
            return;
        }
        RefurbishConfirmationDialog refurbishConfirmationDialog = new RefurbishConfirmationDialog(context, strM75900s0, new C3158b());
        this.f13832g0 = refurbishConfirmationDialog;
        refurbishConfirmationDialog.setCanceledOnTouchOutside(false);
        this.f13832g0.show();
    }

    /* renamed from: Z2 */
    public void m19141Z2(List<BackupOptionItem> list) {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "showContentView showList");
        this.f13808I.setVisibility(8);
        this.f13803D.setVisibility(0);
        C11839m.m70688i("BackupOptionsRefurbishActivity", "backupOptionItemsList size: " + list.size());
        this.f13811L.m24772G(list);
    }

    /* renamed from: a3 */
    public final void m19142a3() {
        this.f13808I.setVisibility(8);
        this.f13825Z.setVisibility(0);
        this.f13824Y.setVisibility(0);
    }

    /* renamed from: b3 */
    public final void m19143b3() throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.q1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                BackupOptionsRefurbishActivity.m19092J2(dialogInterface, i10);
            }
        });
        AlertDialog alertDialog = this.f13829d0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f13829d0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.f13829d0 = alertDialogCreate;
        alertDialogCreate.setMessage(getString(R$string.refurbish_quota_exhausted));
        this.f13829d0.show();
        C11829c.m70594l1(this, this.f13829d0);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter.UpdateOptionStatusListener
    /* renamed from: c */
    public void mo19144c(int i10, String str, boolean z10) {
        if (!z10) {
            if (this.f13815P.contains(str)) {
                this.f13819T.show(CloudBackupLanguageUtil.getVirtualName(str), str, z10, false);
            } else if (C14333b.m85486u().containsKey(str)) {
                this.f13819T.show(C2783d.m16079E(m19112p2(), str), str, z10, false);
            } else {
                this.f13819T.show(ICBUtil.getAppName(m19112p2().getPackageManager(), str), str, z10, false);
            }
            if (C0209d.m1220W0()) {
                return;
            }
            this.f13819T.getButton(-1).setTextColor(getResources().getColor(R$color.enui50_red_color));
            return;
        }
        m19128L2(z10, str);
        this.f13811L.m24792a0(this.f13803D, str, z10);
        m19137V2(false);
        m29140w0("backup_" + str);
        C12515a.m75110o().m75172d(new C3048j2(str, z10, -1, false, m19113r2(str), true, this.f13811L.m24776K()));
        m19134R2(str, true);
        C11839m.m70688i("BackupOptionsRefurbishActivity", "onCheckChanged appId: " + str);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13809J);
        arrayList.add(this.f13802C);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m19145d3(String str, List<BackupOptionItem> list) {
        RefurbishConfirmationDialog refurbishConfirmationDialog = new RefurbishConfirmationDialog(this, str, new C3157a(this, list));
        this.f13831f0 = refurbishConfirmationDialog;
        refurbishConfirmationDialog.setCanceledOnTouchOutside(false);
        this.f13831f0.show();
    }

    /* renamed from: e3 */
    public final void m19146e3() {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "start backup.");
        if (CloudBackupService.getInstance().doRefurbishBackup(false)) {
            m19133Q2();
            return;
        }
        if (!CBAccess.hasValidTempBackup() && CBAccess.hasTaskWorking()) {
            C11841o.m70707c(this, R$string.cloud_backup_running, 0);
        }
        C11839m.m70688i("BackupOptionsRefurbishActivity", "start backup fail, because the backup or restore is running.");
    }

    /* renamed from: f3 */
    public final void m19147f3() {
        if (!C0209d.m1254f2(this)) {
            Toast.makeText(this, R$string.alert_net_disconnect_new, 0).show();
            return;
        }
        if (m19115w2() || CBAccess.inRestore()) {
            C11841o.m70707c(this, R$string.cloud_backup_running, 0);
            C11839m.m70687e("BackupOptionsRefurbishActivity", "cloud_backup_running");
            return;
        }
        C11839m.m70688i("BackupOptionsRefurbishActivity", "is support refurbish:" + C12591s1.m75931a().m75943m());
        List<BackupOptionItem> listM24776K = this.f13811L.m24776K();
        String strM75912v0 = C12590s0.m75912v0(this, listM24776K);
        if (!TextUtils.isEmpty(strM75912v0)) {
            m19145d3(strM75912v0, listM24776K);
        } else {
            m19140Y2(this);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("moduleSystemRefurbish", "moduleSystemRefurbish");
        setResult(-1, intent);
        super.finish();
    }

    /* renamed from: g3 */
    public final void m19148g3() {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "refurbish response success.");
        ICBBroadcastManager.sendCloudBackupPrepareState();
        Intent intent = new Intent();
        intent.setAction("com.huawei.phoneservice.renovation.notification");
        C0209d.m1302r2(intent, ICBBroadcastManager.MYHUAWEI_PACKAGE);
        intent.setFlags(335544320);
        startActivityForResult(intent, 0);
    }

    /* renamed from: i3 */
    public void m19149i3(BackupOptionItem backupOptionItem) {
        if (backupOptionItem == null) {
            C11839m.m70688i("BackupOptionsRefurbishActivity", "optionItem is null.");
            return;
        }
        if (backupOptionItem.getAppId().equals("music") && this.f13815P.contains("music")) {
            backupOptionItem.setParent("virtualApp");
        }
        BackupOptionRefurbishAdapter backupOptionRefurbishAdapter = this.f13811L;
        if (backupOptionRefurbishAdapter != null) {
            backupOptionRefurbishAdapter.m24793b0(backupOptionItem);
        }
        m19110h3(backupOptionItem);
    }

    /* renamed from: j2 */
    public final void m19150j2() {
        this.f13814O.add(new BackupOptionItem());
        this.f13814O.add(new BackupOptionItem());
    }

    /* renamed from: k2 */
    public void m19151k2(String str, boolean z10) {
        m19129M2(!z10, str, null);
        this.f13811L.m24792a0(this.f13803D, str, !z10);
        this.f13819T.dismiss();
        C11839m.m70688i("BackupOptionsRefurbishActivity", "cancelDialog appId: " + str);
    }

    /* renamed from: l2 */
    public final void m19152l2() {
        this.f13808I.setVisibility(8);
        this.f13823X.setVisibility(0);
        this.f13824Y.setVisibility(0);
    }

    /* renamed from: m2 */
    public final void m19153m2() {
        C11839m.m70688i("BackupOptionsRefurbishActivity", "finish backup welcome");
        Intent intent = new Intent();
        intent.setAction("finish_welcome_backup_action");
        intent.putExtra("com.huawei.hicloud.action.BACKUP_OPTIONS", "com.huawei.hicloud.action.BACKUP_OPTIONS");
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: n2 */
    public final BackupOptionItem m19154n2(String str, int i10, boolean z10) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, i10, true);
        if (backupOptionItemQueryItem == null) {
            BackupOptionItem backupOptionItem = new BackupOptionItem(str, "thirdAppData");
            backupOptionItem.setBackupSwitch(z10);
            backupOptionItem.setUid(i10);
            return backupOptionItem;
        }
        if (backupOptionItemQueryItem.getOperateType() == 1) {
            return backupOptionItemQueryItem;
        }
        backupOptionItemQueryItem.setBackupSwitch(z10);
        return backupOptionItemQueryItem;
    }

    /* renamed from: o2 */
    public final void m19155o2(String str, boolean z10, Long l10) {
        BackupOptionItem backupOptionItem = new BackupOptionItem(str);
        backupOptionItem.setBackupSwitch(z10);
        if (l10 != null) {
            backupOptionItem.setOperateType(1);
            backupOptionItem.setOperateTime(l10.longValue());
        }
        try {
            this.f13818S.m78370E(backupOptionItem);
        } catch (C9721b e10) {
            C11839m.m70687e("BackupOptionsRefurbishActivity", "generateItemAndSave: " + e10.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean zM19126G2 = m19126G2();
        finish();
        if (zM19126G2) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.showAll == id2) {
            m19136U2();
            return;
        }
        if (R$id.detail_iv == id2) {
            m19104c3();
            return;
        }
        if (id2 == R$id.rl_backup_now) {
            m19147f3();
            return;
        }
        if (id2 == R$id.bt_backup_pause) {
            this.f13805F.setEnabled(false);
            this.f13805F.setAlpha(0.62f);
            m19131O2(false);
            return;
        }
        if (id2 == R$id.rl_backup_continue) {
            m19147f3();
            return;
        }
        if (id2 != R$id.refurbished_backup_switch_button) {
            if (id2 == R$id.refurbished_backup_know_button) {
                finish();
                return;
            }
            return;
        }
        C13225d.m79490f1().m79597u0(getClass().getSimpleName() + ": open switch", C13471c.f.ALL_SWITCH, true);
        CloudBackupService.getInstance().cloudbackupOpr(true);
        C10155f.m63262O(this, true);
        C10028c.m62182c0().m62202D2("EnterClosedCloudBackupTimes", 0);
        this.f13817R = true;
        C2783d.m16164n1(this);
        this.f13823X.setVisibility(8);
        this.f13824Y.setVisibility(8);
        this.f13808I.setVisibility(0);
        m19122C2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C11842p.m70759Q0()) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(-1);
        }
        mo19236O1();
        m19124E2();
        C11839m.m70688i("BackupOptionsRefurbishActivity", "activity created");
        C14317j.m85300d().m85311l(this.f13833h0);
        CBCallBack.getInstance().registerCallback(this.f13835j0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C14317j.m85300d().m85322w(this.f13833h0);
        CBCallBack.getInstance().unregisterCallback(this.f13835j0);
        C12515a.m75110o().m75166b(C3162f.class.getName());
        AsyncTaskC3161e asyncTaskC3161e = this.f13830e0;
        if (asyncTaskC3161e != null && !asyncTaskC3161e.isCancelled()) {
            this.f13830e0.cancel(true);
        }
        RefurbishConfirmationDialog refurbishConfirmationDialog = this.f13831f0;
        if (refurbishConfirmationDialog != null) {
            refurbishConfirmationDialog.dismiss();
            this.f13831f0 = null;
        }
        RefurbishConfirmationDialog refurbishConfirmationDialog2 = this.f13832g0;
        if (refurbishConfirmationDialog2 != null) {
            refurbishConfirmationDialog2.dismiss();
            this.f13832g0 = null;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 && m19126G2()) {
            return true;
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
            C11839m.m70687e("BackupOptionsRefurbishActivity", "hicloud is not login could not open BackupOptionsRefurbishActivity");
            startActivity(new Intent(this, (Class<?>) NewHiSyncSettingActivity.class));
            finish();
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        if (this.f13817R && !zM62388s) {
            this.f13803D.setVisibility(4);
            m19116x2();
        }
        if (!this.f13817R && zM62388s) {
            C2783d.m16164n1(this);
            this.f13823X.setVisibility(8);
            this.f13824Y.setVisibility(8);
            this.f13808I.setVisibility(0);
            this.f13803D.setVisibility(0);
            m19122C2();
        }
        this.f13817R = zM62388s;
    }

    /* renamed from: q2 */
    public final List<String> m19156q2() {
        List<BackupOptionItem> listM75904t0 = C12590s0.m75904t0(m19112p2(), this.f13811L.m24776K());
        ArrayList arrayList = new ArrayList();
        if (listM75904t0 != null) {
            Iterator<BackupOptionItem> it = listM75904t0.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAppId());
            }
        }
        return arrayList;
    }

    /* renamed from: s2 */
    public final LinkedHashMap m19157s2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> listM75424v0 = new C12526j().m75424v0(m19112p2());
        linkedHashMap.put("is_refurbish", Boolean.TRUE);
        linkedHashMap.put("refurbish_config_important_app_ids", listM75424v0 != null ? listM75424v0.toString() : "");
        linkedHashMap.put("refurbish_user_disabled_important_app_ids", m19156q2().toString());
        return linkedHashMap;
    }

    /* renamed from: u2 */
    public final List<BackupOptionItem> m19158u2() {
        ArrayList arrayList = new ArrayList(20);
        Iterator<BackupOptionItem> it = this.f13814O.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        boolean zM19126G2 = m19126G2();
        finish();
        if (zM19126G2) {
            return true;
        }
        super.mo13429v1(i10, keyEvent);
        return true;
    }

    /* renamed from: v2 */
    public void m19159v2() {
        RelativeLayout relativeLayout = this.f13804E;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f13810K.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.f13806G;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() != 0) {
            return;
        }
        this.f13827b0.setVisibility(8);
    }
}
