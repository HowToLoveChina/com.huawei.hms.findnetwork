package com.huawei.android.hicloud.p088ui.activity;

import ae.C0156p0;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.drive.clouddisk.presenter.callback.DownloadProgressListener;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.MoreDataNotchFitListView;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.sync.R$drawable;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.sync.R$color;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import md.C11440c;
import p015ak.C0209d;
import p015ak.C0214f0;
import p020ap.C1007b;
import p336he.C10159j;
import p336he.C10161l;
import p488n8.C11653a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p516ob.C11845a;
import p573qc.C12338d;
import p664u0.C13108a;
import p684un.C13223b;
import p684un.C13226e;
import p684un.C13230i;
import p703v8.C13381r;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;
import vn.C13471c;

/* loaded from: classes3.dex */
public abstract class CloudDiskOperateBaseActivity extends UIActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: f0 */
    public static DialogInterface.OnClickListener f14243f0 = new DialogInterfaceOnClickListenerC3211a();

    /* renamed from: g0 */
    public static DialogInterface.OnCancelListener f14244g0 = new DialogInterfaceOnCancelListenerC3212b();

    /* renamed from: A */
    public NotchTopFitLinearLayout f14245A;

    /* renamed from: B */
    public NotchFitLinearLayout f14246B;

    /* renamed from: C */
    public RelativeLayout f14247C;

    /* renamed from: D */
    public RelativeLayout f14248D;

    /* renamed from: E */
    public NotchFitRelativeLayout f14249E;

    /* renamed from: F */
    public NotchFitLinearLayout f14250F;

    /* renamed from: G */
    public MoreDataNotchFitListView f14251G;

    /* renamed from: H */
    public LinearLayout f14252H;

    /* renamed from: I */
    public TextView f14253I;

    /* renamed from: J */
    public TextView f14254J;

    /* renamed from: K */
    public TextView f14255K;

    /* renamed from: L */
    public View f14256L;

    /* renamed from: M */
    public TextView f14257M;

    /* renamed from: N */
    public TextView f14258N;

    /* renamed from: O */
    public ImageView f14259O;

    /* renamed from: P */
    public HwButton f14260P;

    /* renamed from: Q */
    public UnionSwitch f14261Q;

    /* renamed from: R */
    public UnionSwitch f14262R;

    /* renamed from: S */
    public ProgressBar f14263S;

    /* renamed from: U */
    public View f14265U;

    /* renamed from: V */
    public LinearLayout f14266V;

    /* renamed from: W */
    public TextView f14267W;

    /* renamed from: X */
    public LinearLayout f14268X;

    /* renamed from: Y */
    public C0156p0 f14269Y;

    /* renamed from: p */
    public ModuleItem f14276p;

    /* renamed from: w */
    public TextView f14283w;

    /* renamed from: x */
    public SharedPreferences f14284x;

    /* renamed from: y */
    public SharedPreferences f14285y;

    /* renamed from: z */
    public C10028c f14286z;

    /* renamed from: q */
    public DialogInterface.OnClickListener f14277q = new DialogInterfaceOnClickListenerC3213c();

    /* renamed from: r */
    public Context f14278r = null;

    /* renamed from: s */
    public C11653a f14279s = C11653a.m69582l();

    /* renamed from: t */
    public Handler f14280t = new HandlerC3214d();

    /* renamed from: u */
    public Messenger f14281u = new Messenger(this.f14280t);

    /* renamed from: v */
    public String f14282v = "";

    /* renamed from: T */
    public AlertDialog f14264T = null;

    /* renamed from: Z */
    public List<ModuleItem> f14270Z = new ArrayList();

    /* renamed from: a0 */
    public List<CBSDevice> f14271a0 = new ArrayList();

    /* renamed from: b0 */
    public boolean f14272b0 = false;

    /* renamed from: c0 */
    public boolean f14273c0 = false;

    /* renamed from: d0 */
    public boolean f14274d0 = false;

    /* renamed from: e0 */
    public AlertDialog f14275e0 = null;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$a */
    public class DialogInterfaceOnClickListenerC3211a implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                dialogInterface.cancel();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$b */
    public class DialogInterfaceOnCancelListenerC3212b implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                dialogInterface.cancel();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$c */
    public class DialogInterfaceOnClickListenerC3213c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3213c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11829c.m70612r1(CloudDiskOperateBaseActivity.this.f14278r);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$d */
    public class HandlerC3214d extends Handler {
        public HandlerC3214d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudDiskOperateBaseActivity.this.mo19681g2(message);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$e */
    public class DialogInterfaceOnClickListenerC3215e implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ModuleItem f14289a;

        public DialogInterfaceOnClickListenerC3215e(ModuleItem moduleItem) {
            this.f14289a = moduleItem;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f14289a.isInTask()) {
                this.f14289a.setState(ModuleItem.State.CANCLE);
                CloudDiskOperateBaseActivity.this.f14269Y.notifyDataSetChanged();
                CloudDiskOperateBaseActivity.this.m19736b2(CloudDiskOperateBaseActivity.this.f14282v + "_restore");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$f */
    public class DialogInterfaceOnClickListenerC3216f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ModuleItem f14291a;

        public DialogInterfaceOnClickListenerC3216f(ModuleItem moduleItem) {
            this.f14291a = moduleItem;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CloudDiskOperateBaseActivity.this.m19733Y1(this.f14291a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$g */
    public class DialogInterfaceOnClickListenerC3217g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3217g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CloudDiskOperateBaseActivity.this.m19743p2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$h */
    public class DialogInterfaceOnClickListenerC3218h implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3218h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CloudDiskOperateBaseActivity.this.m19743p2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$i */
    public class C3219i implements DownloadProgressListener {
        public C3219i() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$j */
    public class DialogInterfaceOnClickListenerC3220j implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public ModuleItem f14296a;

        public DialogInterfaceOnClickListenerC3220j(ModuleItem moduleItem) {
            this.f14296a = moduleItem;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException {
            CloudDiskOperateBaseActivity.this.m19742o2(this.f14296a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskOperateBaseActivity$k */
    public static class DialogInterfaceOnClickListenerC3221k implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public CompoundButton f14298a;

        public DialogInterfaceOnClickListenerC3221k(CompoundButton compoundButton) {
            this.f14298a = compoundButton;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f14298a.setChecked(false);
        }
    }

    /* renamed from: B2 */
    private void m19699B2() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.hicloud_hmos_bg);
            C0209d.m1306s2(getActionBar(), this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: Q1 */
    private void m19704Q1() {
        if ("notepad".equals(this.f14282v)) {
            this.f14258N.setVisibility(8);
            this.f14253I.setVisibility(8);
            this.f14257M.setVisibility(8);
            this.f14258N.setVisibility(8);
            this.f14261Q.setVisibility(8);
            this.f14247C.setVisibility(8);
            return;
        }
        if ("autosmslistkey".equals(this.f14282v)) {
            m19719N2();
            return;
        }
        if ("autophonemanagerkey".equals(this.f14282v)) {
            m19717L2();
        } else if ("autocallloglistkey".equals(this.f14282v)) {
            m19711G2();
        } else if ("autorecordingkey".equals(this.f14282v)) {
            m19718M2();
        }
    }

    /* renamed from: l2 */
    private void m19705l2() {
        this.f14253I = (TextView) C12809f.m76829b(this, R$id.module_sub_title);
        this.f14257M = (TextView) C12809f.m76829b(this, R$id.module_upload_loading);
        this.f14258N = (TextView) C12809f.m76829b(this, R$id.module_pref_text);
        this.f14261Q = (UnionSwitch) C12809f.m76829b(this, R$id.module_notify_switch);
        this.f14246B = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.disk_operate_linear_layout);
        this.f14247C = (RelativeLayout) C12809f.m76829b(this, R$id.top_laout);
        this.f14248D = (RelativeLayout) C12809f.m76829b(this, R$id.module_net_setting);
        this.f14245A = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14249E = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_title);
        this.f14250F = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_list);
        this.f14251G = (MoreDataNotchFitListView) C12809f.m76829b(this, R$id.module_clouddata_list);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R$layout.cloud_disk_operate_foot_view, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R$id.lin_more_data_foot);
        this.f14265U = viewFindViewById;
        this.f14266V = (LinearLayout) viewFindViewById.findViewById(R$id.lin_more_data_ing);
        this.f14267W = (TextView) this.f14265U.findViewById(R$id.more_data);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f14268X = linearLayout;
        linearLayout.setGravity(17);
        this.f14268X.addView(viewInflate);
        this.f14265U.setVisibility(8);
        this.f14256L = C12809f.m76829b(this, R$id.cloud_disk_divider);
        m19704Q1();
        m19708D2();
        m19709E2();
        this.f14261Q.setChecked(this.f14286z.m62388s(this.f14282v));
        TextView textView = (TextView) C12809f.m76829b(this, R$id.backupdata_right_text);
        this.f14283w = textView;
        if (this.f14274d0) {
            textView.setText(R$string.cloud_backup_data);
        } else {
            textView.setText(R$string.cloud_historical_data);
        }
        this.f14263S = (ProgressBar) C12809f.m76829b(this, R$id.backupdata_loading_progress);
        this.f14252H = (LinearLayout) C12809f.m76829b(this, R$id.net_disconnect);
        this.f14259O = (ImageView) C12809f.m76829b(this, R$id.wifi_nodata_imageview);
        this.f14254J = (TextView) C12809f.m76829b(this, R$id.image_descript_text);
        this.f14260P = (HwButton) C12809f.m76829b(this, R$id.net_settings_btn);
        this.f14252H.setOnClickListener(this);
        this.f14260P.setOnClickListener(this);
        this.f14261Q.setOnCheckedChangeListener(this);
        C11842p.m70874v1(this, this.f14260P);
    }

    /* renamed from: A2 */
    public final void m19706A2(String str, String str2, String str3) {
        String str4;
        String str5;
        if (str.equals("autosmslistkey")) {
            str4 = "mecloud_clouddiskmainsms_click_switch";
            str5 = "12";
        } else {
            str4 = "";
            str5 = "";
        }
        if (str.equals("autocallloglistkey")) {
            str4 = "mecloud_clouddiskmaincalllog_click_switch";
            str5 = "25";
        }
        if (str.equals("autorecordingkey")) {
            str4 = "mecloud_clouddiskmainrecording_click_switch";
            str5 = "26";
        }
        if (str.equals("autophonemanagerkey")) {
            str4 = "mecloud_clouddiskmaininterceptionclick_switch";
            str5 = "6";
        }
        String str6 = str4;
        C13226e.m79491f1().m79587h0(str6, str2, str3, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", str6, "1", str5, str2, str3);
    }

    /* renamed from: C2 */
    public final void m19707C2() {
        if (this.f14273c0) {
            C11839m.m70686d("CloudDiskOperateBaseActivity", "setFootView isFromBackup is true:");
            return;
        }
        if (this.f14265U == null) {
            C11839m.m70687e("CloudDiskOperateBaseActivity", "footView is null");
            return;
        }
        List<CBSDevice> list = this.f14271a0;
        if (list != null && list.isEmpty()) {
            C11839m.m70688i("CloudDiskOperateBaseActivity", "notQuaryDeviceList is null or Empty");
            this.f14265U.setVisibility(8);
            this.f14267W.setVisibility(8);
            return;
        }
        C11839m.m70688i("CloudDiskOperateBaseActivity", "notQuaryDeviceList size：" + this.f14271a0);
        this.f14265U.setVisibility(0);
        this.f14266V.setVisibility(8);
        this.f14267W.setVisibility(0);
    }

    /* renamed from: D2 */
    public void m19708D2() {
        if (C11440c.m68539r(this.f14282v)) {
            this.f14261Q.setEnabled(false);
            this.f14253I.setVisibility(0);
            this.f14257M.setVisibility(0);
            this.f14253I.setText(getResources().getString(R$string.autobackup_canceling));
            return;
        }
        String string = this.f14284x.getString(this.f14282v + "_time", "0");
        int i10 = this.f14284x.getInt(this.f14282v + "_retcode", -10);
        this.f14261Q.setEnabled(true);
        if (i10 == 4 && this.f14286z.m62388s(this.f14282v)) {
            this.f14253I.setVisibility(0);
            this.f14257M.setVisibility(0);
            this.f14253I.setText(getResources().getString(R$string.autobackup_btn_running_new));
        } else if ("0".equals(string)) {
            this.f14257M.setVisibility(8);
            this.f14253I.setVisibility(8);
        } else {
            this.f14253I.setVisibility(0);
            this.f14257M.setVisibility(8);
            this.f14253I.setText(C10159j.m63326b(string, this));
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) throws IllegalAccessException, IllegalArgumentException {
        if (i10 == 20013) {
            if ("autorecordingkey".equals(this.f14282v)) {
                if (!m19721P1()) {
                    this.f14261Q.setCheckedProgrammatically(false);
                    return;
                } else {
                    if (this.f14285y.getBoolean("recording_need_wifi_condition", true)) {
                        return;
                    }
                    m19720O2(this.f14261Q);
                    return;
                }
            }
            return;
        }
        if (!mo19714J0(i10) || m19740m2(i10)) {
            if (m19740m2(i10) && m19721P1()) {
                m19734Z1(this.f14276p);
                return;
            }
            return;
        }
        if (m19721P1()) {
            m19743p2();
        } else {
            this.f14261Q.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: E2 */
    public final void m19709E2() {
        if ("autorecordingkey".equals(this.f14282v)) {
            boolean zM62388s = this.f14286z.m62388s(this.f14282v);
            if (zM62388s) {
                this.f14255K.setAlpha(1.0f);
                this.f14248D.setClickable(true);
            } else {
                this.f14255K.setAlpha(1.0f);
                this.f14248D.setClickable(false);
            }
            this.f14262R.setEnabled(zM62388s);
            this.f14262R.setClickable(zM62388s);
        }
    }

    /* renamed from: F2 */
    public final void m19710F2(Context context) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R$string.cloudbackup_networksettingtip_msg)).setMessage(context.getResources().getString(R$string.cloudbackup_settingalert_msg)).setPositiveButton(R$string.cloudbakcup_setting_msg, this.f14277q).setNegativeButton(R$string.cloudbackup_Cancel, f14243f0).setOnCancelListener(f14244g0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14275e0 = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14275e0.setCanceledOnTouchOutside(false);
        this.f14275e0.show();
    }

    /* renamed from: G2 */
    public final void m19711G2() {
        this.f14251G.addFooterView(this.f14268X);
        this.f14265U.setOnClickListener(this);
        if (!this.f14274d0 || !CloudSyncUtil.m15944C0(this)) {
            this.f14247C.setVisibility(8);
            return;
        }
        this.f14247C.setVisibility(0);
        this.f14258N.setVisibility(0);
        this.f14256L.setVisibility(0);
        this.f14258N.setText(CloudSyncUtil.m15998c0(getResources().getString(R$string.calllog_upload_limit_2000_every_device, 2000), 2000));
    }

    /* renamed from: H2 */
    public final void m19712H2(ModuleItem moduleItem) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R$string.download_cancle_alert)).setPositiveButton(getResources().getString(R$string.download_stop_btn), new DialogInterfaceOnClickListenerC3215e(moduleItem)).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), f14243f0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.setCancelable(false);
        this.f14264T.show();
        this.f14264T.getButton(-1).setTextColor(getResources().getColor(com.huawei.android.sync.R$color.red));
    }

    /* renamed from: I2 */
    public final void m19713I2(CompoundButton compoundButton) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R$string.hicloud_cover_open_alert_new)).setMessage(R$string.hicloud_cover_open_messages_new).setPositiveButton(getResources().getString(R$string.hicloud_cover_open_btn), new DialogInterfaceOnClickListenerC3218h()).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), new DialogInterfaceOnClickListenerC3221k(compoundButton));
        m19726S1(builder);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: J0 */
    public boolean mo19714J0(int i10) {
        return 20012 == i10 || 20013 == i10 || 20011 == i10 || m19740m2(i10);
    }

    /* renamed from: J2 */
    public final void m19715J2(ModuleItem moduleItem) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R$string.module_data_delete_alert_new)).setPositiveButton(getResources().getString(R$string.cloudbackup_btn_delete), new DialogInterfaceOnClickListenerC3220j(moduleItem)).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), f14243f0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.setCancelable(false);
        this.f14264T.show();
        this.f14264T.getButton(-1).setTextColor(getResources().getColor(com.huawei.android.sync.R$color.red));
    }

    /* renamed from: K2 */
    public final void m19716K2(ModuleItem moduleItem) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R$string.cloudbackup_alert)).setMessage(getResources().getString(R$string.data_download_net_alert_new)).setPositiveButton(getResources().getString(R$string.continuebutton), new DialogInterfaceOnClickListenerC3216f(moduleItem)).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), f14243f0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.setCancelable(false);
        this.f14264T.show();
    }

    /* renamed from: L2 */
    public final void m19717L2() {
        if (this.f14274d0 && CloudSyncUtil.m15946D0(this)) {
            this.f14247C.setVisibility(0);
            this.f14256L.setVisibility(0);
        } else {
            this.f14247C.setVisibility(8);
        }
        this.f14258N.setVisibility(0);
        this.f14258N.setText(getResources().getString(R$string.phonemanager_upload_everyday));
    }

    /* renamed from: M2 */
    public final void m19718M2() {
        this.f14255K = (TextView) C12809f.m76829b(this, R$id.module_net_title);
        this.f14262R = (UnionSwitch) C12809f.m76829b(this, R$id.module_net_switch);
        if (!this.f14274d0 || !CloudSyncUtil.m15948E0(this)) {
            this.f14247C.setVisibility(8);
            this.f14255K.setVisibility(8);
            this.f14262R.setVisibility(8);
            return;
        }
        this.f14247C.setVisibility(0);
        this.f14255K.setVisibility(0);
        this.f14262R.setVisibility(0);
        this.f14256L.setVisibility(0);
        this.f14255K.setText(C0209d.m1167E2(R$string.autoupload_condition_wlan, R$string.autoupload_condition_wifi));
        this.f14248D.setVisibility(0);
        this.f14248D.setClickable(false);
        this.f14262R.setChecked(this.f14285y.getBoolean("recording_need_wifi_condition", true));
        this.f14262R.setOnCheckedChangeListener(this);
    }

    /* renamed from: N2 */
    public final void m19719N2() {
        this.f14251G.addFooterView(this.f14268X);
        this.f14265U.setOnClickListener(this);
        if (!this.f14274d0 || !CloudSyncUtil.m15950F0(this)) {
            this.f14247C.setVisibility(8);
        } else {
            this.f14247C.setVisibility(0);
            this.f14256L.setVisibility(0);
        }
    }

    /* renamed from: O2 */
    public final void m19720O2(CompoundButton compoundButton) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R$string.alert)).setMessage(CloudSyncUtil.m16050t1(this)).setPositiveButton(getResources().getString(R$string.cloudbackup_btn_ok), new DialogInterfaceOnClickListenerC3217g()).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), new DialogInterfaceOnClickListenerC3221k(compoundButton));
        m19726S1(builder);
    }

    /* renamed from: P1 */
    public final boolean m19721P1() {
        List<String> listM69903b;
        List<String> listM69909h = this.f22163b.m69909h(this.f14282v);
        return listM69909h == null || listM69909h.size() == 0 || (listM69903b = this.f22163b.m69903b(this, listM69909h)) == null || listM69903b.size() == 0;
    }

    /* renamed from: P2 */
    public final void m19722P2(CompoundButton compoundButton) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R$string.cloudbackup_alert)).setMessage(getResources().getString(R$string.autoupload_condition_allnet_message)).setPositiveButton(getResources().getString(R$string.cloudbackup_restart_msgtip), f14243f0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.show();
    }

    /* renamed from: Q2 */
    public final void m19723Q2() {
        if (C11829c.m70611r0()) {
            CloudSyncUtil.m16023k1(this, this.f14282v);
        }
        if ("autosmslistkey".equals(this.f14282v)) {
            this.f14279s.m69590f();
            return;
        }
        if ("autocallloglistkey".equals(this.f14282v)) {
            this.f14279s.m69587c();
            return;
        }
        if (!"autorecordingkey".equals(this.f14282v)) {
            if ("autophonemanagerkey".equals(this.f14282v)) {
                this.f14279s.m69588d();
            }
        } else {
            this.f14279s.m69589e();
            if (CloudSyncUtil.m15954H0(this.f14278r)) {
                this.f14284x.edit().putLong("recordingtimestamp", 0L).commit();
            }
        }
    }

    /* renamed from: R1 */
    public final void m19724R1() {
        if ("autosmslistkey".equals(this.f14282v)) {
            C11845a.m70916c();
        } else if ("autocallloglistkey".equals(this.f14282v)) {
            C11845a.m70915b();
        }
    }

    /* renamed from: R2 */
    public final void m19725R2(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        C1007b.m5980s().m5995O(getApplicationContext(), arrayList);
    }

    /* renamed from: S1 */
    public final void m19726S1(AlertDialog.Builder builder) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.setCancelable(false);
        this.f14264T.show();
    }

    /* renamed from: S2 */
    public void m19727S2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R$string.backup_waiting_download)).setNegativeButton(getResources().getString(R$string.alarm_msg_positive_btn), f14243f0);
        AlertDialog alertDialogCreate = builder.create();
        this.f14264T = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14264T.setCancelable(false);
        this.f14264T.show();
    }

    /* renamed from: T1 */
    public final void m19728T1() {
        this.f14270Z = mo19679e2();
        this.f14271a0 = mo19680f2();
        String strM80900d = C13452e.m80781L().m80900d();
        String strM70919f = C11845a.m70919f();
        if (strM70919f == null || strM70919f.isEmpty()) {
            C11845a.m70936w(strM80900d);
        } else if (strM80900d != null && !strM80900d.equals(strM70919f)) {
            this.f14270Z.clear();
            C11845a.m70936w(strM80900d);
        }
        if (this.f14270Z.isEmpty()) {
            C11839m.m70686d("CloudDiskOperateBaseActivity", "cloudDatas is empty");
            if (!C0209d.m1208S0(this)) {
                m19745r2();
                return;
            } else {
                m19744q2();
                mo19684v2(true, false);
                return;
            }
        }
        if ("autocallloglistkey".equals(this.f14282v)) {
            this.f14273c0 = C11845a.m70934u();
        } else if ("autosmslistkey".equals(this.f14282v)) {
            this.f14273c0 = C11845a.m70935v();
        }
        m19707C2();
        m19739j2();
        m19729U1(false);
    }

    /* renamed from: U1 */
    public final void m19729U1(boolean z10) {
        if (z10) {
            m19744q2();
            mo19684v2(false, z10);
            return;
        }
        if (mo19682i2()) {
            m19744q2();
        } else if (!"autocallloglistkey".equals(this.f14282v) && !"autosmslistkey".equals(this.f14282v)) {
            Iterator<ModuleItem> it = this.f14270Z.iterator();
            long space = 0;
            while (it.hasNext()) {
                space += it.next().getSpace();
            }
            String strM83086h = C13843a.m83086h(this, space);
            if (this.f14274d0) {
                this.f14283w.setText(getString(R$string.cloud_backup_data_2019, strM83086h));
            } else {
                this.f14283w.setText(getString(R$string.cloud_historical_data_size, strM83086h));
            }
        }
        if (System.currentTimeMillis() - C11845a.m70923j(this.f14282v).longValue() <= 60000 || !C0209d.m1208S0(this) || CloudSyncUtil.m16016i0(this.f14282v) || CloudSyncUtil.m16007f0()) {
            return;
        }
        C11839m.m70686d("CloudDiskOperateBaseActivity", "cache is invalid");
        m19724R1();
        m19744q2();
        mo19684v2(false, false);
    }

    /* renamed from: V1 */
    public final void m19730V1(Message message) {
        MoreDataNotchFitListView moreDataNotchFitListView;
        Bundle data = message.getData();
        String string = data.getString("moduleName");
        String string2 = data.getString("deviceId");
        boolean z10 = data.getBoolean("result");
        if (string == null || !string.equals(this.f14282v)) {
            return;
        }
        if (!z10 && !isFinishing()) {
            m19738h2(string, string2);
            return;
        }
        Toast.makeText(this, getString(R$string.module_data_deleted), 0).show();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f14270Z);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModuleItem moduleItem = (ModuleItem) it.next();
            if (string2 != null && string2.equals(mo19678d2(moduleItem))) {
                arrayList2.add(moduleItem);
                break;
            }
        }
        this.f14270Z.removeAll(arrayList2);
        C0156p0 c0156p0 = this.f14269Y;
        if (c0156p0 != null && (moreDataNotchFitListView = this.f14251G) != null) {
            moreDataNotchFitListView.setAdapter((ListAdapter) c0156p0);
            this.f14269Y.notifyDataSetChanged();
        }
        if (this.f14270Z.isEmpty()) {
            m19746s2();
        }
        m19729U1(false);
        C13381r.m80356a().m80359d();
    }

    /* renamed from: W1 */
    public void m19731W1(Message message) {
        C11839m.m70686d("CloudDiskOperateBaseActivity", "msg type is " + message.arg1);
        Bundle data = message.getData();
        if (data != null) {
            this.f14273c0 = data.getBoolean("fromBackup");
            C11839m.m70686d("CloudDiskOperateBaseActivity", "dealOneModuleInfo isFromBackup " + this.f14273c0);
        }
        int i10 = message.arg1;
        if (i10 != 0 && i10 != -10) {
            if (mo19679e2().isEmpty()) {
                m19747t2();
            } else if ("autocallloglistkey".equals(this.f14282v) || "autosmslistkey".equals(this.f14282v)) {
                Toast.makeText(this, getString(R$string.load_more_data_failed), 0).show();
            }
            this.f14263S.setVisibility(8);
            m19707C2();
            return;
        }
        List<ModuleItem> listMo19679e2 = mo19679e2();
        this.f14270Z = listMo19679e2;
        if (listMo19679e2.isEmpty()) {
            m19746s2();
            return;
        }
        this.f14271a0 = mo19680f2();
        m19707C2();
        m19739j2();
        m19729U1(false);
    }

    /* renamed from: X1 */
    public void m19732X1(ModuleItem moduleItem) {
        m19751y2(moduleItem.getModuleName());
        if (!C0209d.m1208S0(this)) {
            Toast.makeText(this, getString(R$string.alert_net_disconnect_20160420), 0).show();
        } else if (C11440c.m68531i(this.f14282v) && moduleItem.isCurrent()) {
            Toast.makeText(this, getString(R$string.have_autobackup_running1), 0).show();
        } else {
            m19715J2(moduleItem);
        }
    }

    /* renamed from: Y1 */
    public final void m19733Y1(ModuleItem moduleItem) {
        moduleItem.setProgress(5);
        moduleItem.setState(ModuleItem.State.WAITING);
        C0156p0 c0156p0 = this.f14269Y;
        if (c0156p0 != null) {
            c0156p0.notifyDataSetChanged();
        }
        if ("autosmslistkey".equals(this.f14282v) && !CloudSyncUtil.m16016i0(this.f14282v)) {
            this.f14279s.m69595k();
            return;
        }
        if ("autocallloglistkey".equals(this.f14282v) && !CloudSyncUtil.m16016i0(this.f14282v)) {
            this.f14279s.m69591g();
            return;
        }
        if ("notepad".equals(this.f14282v) && !CloudSyncUtil.m16016i0(this.f14282v)) {
            this.f14279s.m69592h(moduleItem, new C3219i());
        } else if ("autorecordingkey".equals(this.f14282v) && !CloudSyncUtil.m16016i0(this.f14282v)) {
            this.f14279s.m69594j();
        } else {
            if (!"autophonemanagerkey".equals(this.f14282v) || CloudSyncUtil.m16016i0(this.f14282v)) {
                return;
            }
            this.f14279s.m69593i();
        }
    }

    /* renamed from: Z1 */
    public void m19734Z1(ModuleItem moduleItem) {
        String strM19737c2 = m19737c2();
        if (m19741n2(this.f14282v) && !m29143z0(strM19737c2)) {
            this.f14276p = moduleItem;
            return;
        }
        m19752z2(moduleItem.getModuleName());
        if (!C0209d.m1208S0(this)) {
            Toast.makeText(this, getString(R$string.alert_net_disconnect_20160420), 0).show();
            return;
        }
        if (C11440c.m68531i(this.f14282v)) {
            Toast.makeText(this, getString(R$string.have_autobackup_running1), 0).show();
        } else if (C0209d.m1150A1(this)) {
            m19716K2(moduleItem);
        } else {
            m19733Y1(moduleItem);
        }
    }

    /* renamed from: a2 */
    public void m19735a2(ModuleItem moduleItem) {
        m19712H2(moduleItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13226e.m79491f1();
    }

    /* renamed from: b2 */
    public final void m19736b2(String str) {
        C11440c.m68528e(str);
    }

    /* renamed from: c2 */
    public final String m19737c2() {
        return "autorecordingkey".equals(this.f14282v) ? "cloud_disk_download_recording" : "autocallloglistkey".equals(this.f14282v) ? "cloud_disk_download_calllog" : "autosmslistkey".equals(this.f14282v) ? "cloud_disk_download_sms" : "";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14245A);
        arrayList.add(this.f14246B);
        arrayList.add(this.f14249E);
        arrayList.add(this.f14250F);
        return arrayList;
    }

    /* renamed from: d2 */
    public abstract String mo19678d2(ModuleItem moduleItem);

    /* renamed from: e2 */
    public abstract List<ModuleItem> mo19679e2();

    /* renamed from: f2 */
    public abstract List<CBSDevice> mo19680f2();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: g2 */
    public boolean mo19681g2(Message message) {
        switch (message.what) {
            case 11:
            case 67:
            case 1001:
            case 1202:
            case 99001:
                m19708D2();
                C0156p0 c0156p0 = this.f14269Y;
                if (c0156p0 != null) {
                    c0156p0.notifyDataSetChanged();
                }
                return false;
            case 15:
            case 99101:
                Toast.makeText(this, getApplicationContext().getResources().getString(R$string.cloudbackup_sdcard_unenough_msg), 0).show();
                m19708D2();
                C0156p0 c0156p02 = this.f14269Y;
                if (c0156p02 != null) {
                    c0156p02.notifyDataSetChanged();
                }
                return false;
            case 1003:
                m19708D2();
                C0156p0 c0156p03 = this.f14269Y;
                if (c0156p03 != null) {
                    c0156p03.notifyDataSetChanged();
                }
                m19729U1(true);
                return false;
            case 66000003:
                m19730V1(message);
                return false;
            case 66000023:
                m19731W1(message);
                return false;
            default:
                return false;
        }
    }

    /* renamed from: h2 */
    public final void m19738h2(String str, String str2) {
        if ("autorecordingkey".equals(str) || "autophonemanagerkey".equals(str) || "notepad".equals(str)) {
            Toast.makeText(this, getString(R$string.backup_failed_sever_busy), 0).show();
        }
        for (ModuleItem moduleItem : this.f14270Z) {
            if (str2 != null && str2.equals(mo19678d2(moduleItem))) {
                moduleItem.setState(ModuleItem.State.NORMAL);
                this.f14269Y.notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: i2 */
    public abstract boolean mo19682i2();

    /* renamed from: j2 */
    public void m19739j2() {
        this.f14263S.setVisibility(8);
        this.f14252H.setVisibility(8);
        this.f14260P.setVisibility(8);
        if (this.f14251G == null) {
            this.f14251G = (MoreDataNotchFitListView) C12809f.m76829b(this, R$id.module_clouddata_list);
        }
        this.f14251G.setVisibility(0);
        C0156p0 c0156p0 = new C0156p0(this, this.f14270Z, this.f14282v);
        this.f14269Y = c0156p0;
        this.f14251G.setAdapter((ListAdapter) c0156p0);
        this.f14269Y.notifyDataSetChanged();
    }

    /* renamed from: k2 */
    public abstract void mo19683k2();

    /* renamed from: m2 */
    public final boolean m19740m2(int i10) {
        return 20015 == i10 || 20016 == i10 || 20014 == i10;
    }

    /* renamed from: n2 */
    public final boolean m19741n2(String str) {
        return str.equals("autosmslistkey") || str.equals("autorecordingkey") || str.equals("autocallloglistkey");
    }

    /* renamed from: o2 */
    public final void m19742o2(ModuleItem moduleItem) throws IllegalAccessException, IllegalArgumentException {
        if (!C0209d.m1208S0(this.f14278r)) {
            m19710F2(this.f14278r);
        }
        this.f14279s.m69598o(mo19678d2(moduleItem), moduleItem.getDeviceType(), this.f14282v, moduleItem);
        moduleItem.setState(ModuleItem.State.DELETING);
        C0156p0 c0156p0 = this.f14269Y;
        if (c0156p0 != null) {
            c0156p0.notifyDataSetChanged();
        }
        C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_REFRESH_FIRST_PAGE"));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        int id2 = compoundButton.getId();
        if (R$id.module_notify_switch == id2) {
            if (!z10) {
                SyncObserverServiceInvoker.getInstance().stopService(this, this.f14282v);
                this.f14286z.m62336h2(this.f14282v, false);
                C12338d.m74195s().m74229g0("dsswitch");
                m19725R2(this.f14282v);
                m19736b2(this.f14282v);
                m19708D2();
                m19709E2();
                if (C11829c.m70611r0() && !"autorecordingkey".equals(this.f14282v)) {
                    CloudSyncUtil.m16009g(this, this.f14282v);
                }
                C13223b.m79476d(this, this.f14282v, false);
                UBAAnalyze.m29954O("PVC", C13471c.m81131d().get(this.f14282v), "1", "29");
                m19706A2(this.f14282v, "2", "2");
            } else {
                if (m19741n2(this.f14282v) && !m29143z0(this.f14282v)) {
                    return;
                }
                if ("autorecordingkey".equals(this.f14282v) && !this.f14285y.getBoolean("recording_need_wifi_condition", true)) {
                    m19720O2(compoundButton);
                    return;
                } else if ("autophonemanagerkey".equals(this.f14282v)) {
                    m19713I2(compoundButton);
                } else {
                    m19743p2();
                }
            }
        }
        if (R$id.module_net_switch == id2) {
            this.f14285y.edit().putBoolean("recording_need_wifi_condition", z10).commit();
            if (z10) {
                C13226e.m79491f1().m79587h0("mecloud_clouddiskmainrecording_click_wlanonly", "1", "1", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29971c0("PVC", "mecloud_clouddiskmainrecording_click_wlanonly", "1", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, "1", "1");
            } else {
                m19722P2(compoundButton);
                C13226e.m79491f1().m79587h0("mecloud_clouddiskmainrecording_click_wlanonly", "2", "2", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29971c0("PVC", "mecloud_clouddiskmainrecording_click_wlanonly", "1", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, "2", "2");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.net_disconnect == id2) {
            if (C0209d.m1208S0(this)) {
                m19744q2();
                mo19684v2(false, false);
            } else {
                m19745r2();
            }
        }
        if (R$id.net_settings_btn == id2) {
            C11829c.m70612r1(this);
        }
        if (R$id.top_laout == id2) {
            this.f14261Q.setChecked(!r0.isChecked());
        }
        if (R$id.lin_more_data_foot == id2) {
            if ("autocallloglistkey".equals(this.f14282v)) {
                C13223b.m79479g(this, this.f14282v);
                UBAAnalyze.m29957R("PVC", C13471c.m81132e().get(this.f14282v), "1", "25", "value", "MOREDATA_CLICK_MORE_DATA");
                this.f14266V.setVisibility(0);
                this.f14267W.setVisibility(8);
                m19748u2();
                return;
            }
            if ("autosmslistkey".equals(this.f14282v)) {
                C13223b.m79479g(this, this.f14282v);
                UBAAnalyze.m29957R("PVC", C13471c.m81132e().get(this.f14282v), "1", "12", "value", "MOREDATA_CLICK_MORE_DATA");
                this.f14266V.setVisibility(0);
                this.f14267W.setVisibility(8);
                m19748u2();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14260P);
        C0156p0 c0156p0 = this.f14269Y;
        if (c0156p0 != null) {
            c0156p0.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C10161l.m63342b().m63345d(this);
        setContentView(R$layout.cloud_disk_operate_base);
        this.f14286z = C10028c.m62182c0();
        this.f14284x = C0214f0.m1382b(getApplicationContext(), "deviceNameSp", 0);
        this.f14285y = C0214f0.m1382b(getApplicationContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        Bundle extras = new HiCloudSafeIntent(getIntent()).getExtras();
        if (extras != null) {
            this.f14274d0 = new C10343b(extras).m63682d("isShowCloudDisk", false);
        }
        this.f14278r = this;
        m19699B2();
        mo19683k2();
        m19705l2();
        mo19005p1();
        m19728T1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        C11839m.m70686d("CloudDiskOperateBaseActivity", "onDestroy ");
        this.f14279s.m69599r(this.f14281u);
        C10161l.m63342b().m63344c(this);
        AlertDialog alertDialog = this.f14264T;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14264T = null;
        }
        if ("autocallloglistkey".equals(this.f14282v)) {
            C11845a.m70906C(false);
        } else if ("autosmslistkey".equals(this.f14282v)) {
            C11845a.m70907D(false);
        }
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        LinearLayout linearLayout;
        if (this.f14272b0 && C0209d.m1208S0(this) && (linearLayout = this.f14252H) != null && this.f14254J != null) {
            linearLayout.setClickable(true);
            this.f14254J.setText(R$string.connect_server_fail_msg1);
            this.f14272b0 = false;
        }
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    /* renamed from: p2 */
    public final void m19743p2() {
        this.f14286z.m62336h2(this.f14282v, true);
        C12338d.m74195s().m74229g0("dsswitch");
        m19725R2(this.f14282v);
        m19706A2(this.f14282v, "1", "1");
        if (C11829c.m70611r0()) {
            m19749w2(this.f14282v);
        }
        m19709E2();
        if (!CloudSyncUtil.m15940A0(this, this.f14282v)) {
            this.f14284x.edit().putBoolean(this.f14282v + "notAllSucess", true).commit();
        }
        C13223b.m79476d(this, this.f14282v, true);
        UBAAnalyze.m29954O("PVC", C13471c.m81132e().get(this.f14282v), "1", "29");
        boolean z10 = "autorecordingkey".equals(this.f14282v) ? this.f14285y.getBoolean("recording_need_wifi_condition", true) : false;
        m19750x2();
        if (!z10 && !C0209d.m1333z1(this)) {
            Toast.makeText(this, getString(R$string.alert_net_disconnect_20160420), 1).show();
            return;
        }
        if (z10 && !C0209d.m1254f2(this)) {
            Toast.makeText(this, CloudSyncUtil.m16003e(this), 1).show();
            return;
        }
        C11839m.m70688i("CloudDiskOperateBaseActivity", "openSwitch itemName: " + this.f14282v);
        m19723Q2();
    }

    /* renamed from: q2 */
    public final void m19744q2() {
        this.f14263S.setVisibility(0);
        this.f14252H.setVisibility(8);
        this.f14260P.setVisibility(8);
    }

    /* renamed from: r2 */
    public final void m19745r2() {
        if (this.f14274d0) {
            this.f14283w.setText(R$string.cloud_backup_data);
        } else {
            this.f14283w.setText(R$string.cloud_historical_data);
        }
        this.f14263S.setVisibility(8);
        this.f14252H.setVisibility(0);
        this.f14259O.setVisibility(0);
        this.f14254J.setVisibility(0);
        this.f14260P.setVisibility(0);
        MoreDataNotchFitListView moreDataNotchFitListView = this.f14251G;
        if (moreDataNotchFitListView != null) {
            moreDataNotchFitListView.setVisibility(8);
        }
        this.f14259O.setBackground(getResources().getDrawable(R$drawable.pay_ic_no_wifi_disable));
        this.f14254J.setText(R$string.network_unavailable);
        this.f14272b0 = true;
    }

    /* renamed from: s2 */
    public final void m19746s2() {
        if (this.f14274d0) {
            this.f14283w.setText(R$string.cloud_backup_data);
        } else {
            this.f14283w.setText(R$string.cloud_historical_data);
        }
        this.f14263S.setVisibility(8);
        this.f14252H.setVisibility(0);
        this.f14259O.setVisibility(0);
        this.f14254J.setVisibility(0);
        this.f14260P.setVisibility(8);
        this.f14252H.setClickable(false);
        this.f14259O.setBackground(getResources().getDrawable(R$drawable.pay_sync_nodata));
        this.f14254J.setText(R$string.no_cloud_backup);
        MoreDataNotchFitListView moreDataNotchFitListView = this.f14251G;
        if (moreDataNotchFitListView != null) {
            moreDataNotchFitListView.setVisibility(8);
        }
    }

    /* renamed from: t2 */
    public final void m19747t2() {
        if (this.f14274d0) {
            this.f14283w.setText(R$string.cloud_backup_data);
        } else {
            this.f14283w.setText(R$string.cloud_historical_data);
        }
        this.f14252H.setVisibility(0);
        this.f14259O.setVisibility(0);
        this.f14254J.setVisibility(0);
        this.f14260P.setVisibility(8);
        this.f14252H.setClickable(true);
        MoreDataNotchFitListView moreDataNotchFitListView = this.f14251G;
        if (moreDataNotchFitListView != null) {
            moreDataNotchFitListView.setVisibility(8);
        }
        this.f14259O.setBackground(getResources().getDrawable(R$drawable.pay_ic_no_wifi_disable));
        this.f14254J.setText(R$string.connect_server_fail_msg1);
    }

    /* renamed from: u2 */
    public final void m19748u2() {
        if (System.currentTimeMillis() - C11845a.m70923j(this.f14282v).longValue() <= 60000 || !C0209d.m1208S0(this) || CloudSyncUtil.m16016i0(this.f14282v) || CloudSyncUtil.m16007f0()) {
            m19744q2();
            mo19684v2(true, false);
        } else {
            C11839m.m70686d("CloudDiskOperateBaseActivity", "cache is invalid");
            m19724R1();
            m19744q2();
            mo19684v2(false, false);
        }
    }

    /* renamed from: v2 */
    public abstract void mo19684v2(boolean z10, boolean z11);

    /* renamed from: w2 */
    public final void m19749w2(String str) {
        if ("autocallloglistkey".equals(str)) {
            SyncObserverServiceInvoker.getInstance().startService(this, "com.huawei.android.hicloud.sync.registerCallLogChangeObserver");
        } else if ("autorecordingkey".equals(str)) {
            SyncObserverServiceInvoker.getInstance().startService(this, "com.huawei.android.hicloud.sync.syncobserverservice.filelistener");
        }
    }

    /* renamed from: x2 */
    public final void m19750x2() {
        if (!C11829c.m70611r0()) {
            if ("autosmslistkey".equals(this.f14282v)) {
                C12338d.m74195s().m74227e0();
            } else if ("autocallloglistkey".equals(this.f14282v)) {
                C12338d.m74195s().m74215S();
            } else if ("autophonemanagerkey".equals(this.f14282v)) {
                C12338d.m74195s().m74221Y();
            }
        }
        if ("autorecordingkey".equals(this.f14282v) && CloudSyncUtil.m15954H0(this.f14278r)) {
            C12338d.m74195s().m74223a0();
        }
    }

    /* renamed from: y2 */
    public final void m19751y2(String str) {
        String str2;
        String str3;
        if (str.equals("autosmslistkey")) {
            str2 = "mecloud_clouddiskmainsms_click_delete";
            str3 = "12";
        } else {
            str2 = "";
            str3 = "";
        }
        if (str.equals("autocallloglistkey")) {
            str2 = "mecloud_clouddiskmaincalllog_click_delete";
            str3 = "25";
        }
        if (str.equals("autorecordingkey")) {
            str2 = "mecloud_clouddiskmainrecording_click_delete";
            str3 = "26";
        }
        if (str.equals("autophonemanagerkey")) {
            str2 = "mecloud_clouddiskmaininterception_click_delete";
            str3 = "6";
        }
        C13226e.m79491f1().m79585f0(str2, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str2, "1", str3);
    }

    /* renamed from: z2 */
    public final void m19752z2(String str) {
        String str2;
        String str3;
        if (str.equals("autosmslistkey")) {
            str2 = "mecloud_clouddiskmainsms_click_download";
            str3 = "12";
        } else {
            str2 = "";
            str3 = "";
        }
        if (str.equals("autocallloglistkey")) {
            str2 = "mecloud_clouddiskmaincalllog_click_download";
            str3 = "25";
        }
        if (str.equals("autorecordingkey")) {
            str2 = "mecloud_clouddiskmainrecording_click_download";
            str3 = "26";
        }
        if (str.equals("autophonemanagerkey")) {
            str2 = "mecloud_clouddiskmaininterception_click_download";
            str3 = "6";
        }
        C13226e.m79491f1().m79585f0(str2, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str2, "1", str3);
    }
}
