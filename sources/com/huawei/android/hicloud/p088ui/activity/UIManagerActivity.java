package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.MaxWidthTextView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MergeAlertDialog;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0223k;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p335hd.C10147j;
import p336he.C10155f;
import p431ko.C11079e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13224c;
import p684un.C13227f;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p850zo.InterfaceC14351b;
import sk.C12809f;
import vn.C13471c;

/* loaded from: classes3.dex */
public class UIManagerActivity extends UIActivity implements View.OnClickListener, InterfaceC14351b, DialogCallback {

    /* renamed from: A */
    public int f16173A;

    /* renamed from: A0 */
    public TextView f16174A0;

    /* renamed from: B */
    public int f16175B;

    /* renamed from: B0 */
    public TextView f16176B0;

    /* renamed from: C0 */
    public TextView f16178C0;

    /* renamed from: D0 */
    public TextView f16180D0;

    /* renamed from: E */
    public ProgressDialog f16181E;

    /* renamed from: E0 */
    public SpanClickText f16182E0;

    /* renamed from: F */
    public Context f16183F;

    /* renamed from: F0 */
    public ProgressDialog f16184F0;

    /* renamed from: G */
    public String f16185G;

    /* renamed from: H */
    public TextView f16187H;

    /* renamed from: H0 */
    public AlertDialog f16188H0;

    /* renamed from: I */
    public TextView f16189I;

    /* renamed from: J */
    public TextView f16191J;

    /* renamed from: J0 */
    public HiCloudExceptionView f16192J0;

    /* renamed from: K */
    public TextView f16193K;

    /* renamed from: L */
    public RelativeLayout f16195L;

    /* renamed from: L0 */
    public String f16196L0;

    /* renamed from: M */
    public ImageView f16197M;

    /* renamed from: N */
    public RelativeLayout f16199N;

    /* renamed from: O */
    public MaxWidthTextView f16200O;

    /* renamed from: P */
    public TextView f16201P;

    /* renamed from: Q */
    public View f16202Q;

    /* renamed from: R */
    public RelativeLayout f16203R;

    /* renamed from: S */
    public MaxWidthTextView f16204S;

    /* renamed from: T */
    public TextView f16205T;

    /* renamed from: U */
    public View f16206U;

    /* renamed from: V */
    public View f16207V;

    /* renamed from: W */
    public RelativeLayout f16208W;

    /* renamed from: X */
    public MaxWidthTextView f16209X;

    /* renamed from: Y */
    public TextView f16210Y;

    /* renamed from: Z */
    public NotchFitRelativeLayout f16211Z;

    /* renamed from: a0 */
    public NotchFitLinearLayout f16212a0;

    /* renamed from: b0 */
    public SpanClickText f16213b0;

    /* renamed from: c0 */
    public NotchFitLinearLayout f16214c0;

    /* renamed from: d0 */
    public NotchFitLinearLayout f16215d0;

    /* renamed from: e0 */
    public RelativeLayout f16216e0;

    /* renamed from: f0 */
    public RelativeLayout f16217f0;

    /* renamed from: g0 */
    public TextView f16218g0;

    /* renamed from: h0 */
    public TextView f16219h0;

    /* renamed from: i0 */
    public NotchFitLinearLayout f16220i0;

    /* renamed from: j0 */
    public RelativeLayout f16221j0;

    /* renamed from: k0 */
    public TextView f16222k0;

    /* renamed from: l0 */
    public SpanClickText f16223l0;

    /* renamed from: m0 */
    public View f16224m0;

    /* renamed from: n0 */
    public RelativeLayout f16225n0;

    /* renamed from: p */
    public boolean f16227p;

    /* renamed from: p0 */
    public RelativeLayout f16228p0;

    /* renamed from: q */
    public NotchTopFitRelativeLayout f16229q;

    /* renamed from: q0 */
    public View f16230q0;

    /* renamed from: r */
    public NotchFitLinearLayout f16231r;

    /* renamed from: r0 */
    public ProgressBar f16232r0;

    /* renamed from: s */
    public RelativeLayout f16233s;

    /* renamed from: s0 */
    public ImageView f16234s0;

    /* renamed from: t0 */
    public HwButton f16236t0;

    /* renamed from: u0 */
    public View f16238u0;

    /* renamed from: v */
    public int f16239v;

    /* renamed from: v0 */
    public TextView f16240v0;

    /* renamed from: w */
    public String f16241w;

    /* renamed from: w0 */
    public HwButton f16242w0;

    /* renamed from: x */
    public String f16243x;

    /* renamed from: x0 */
    public HwButton f16244x0;

    /* renamed from: y0 */
    public LinearLayout f16246y0;

    /* renamed from: z */
    public String f16247z;

    /* renamed from: z0 */
    public RelativeLayout f16248z0;

    /* renamed from: t */
    public AlertDialog f16235t = null;

    /* renamed from: u */
    public AlertDialog f16237u = null;

    /* renamed from: y */
    public int f16245y = -1;

    /* renamed from: C */
    public boolean f16177C = false;

    /* renamed from: D */
    public boolean f16179D = false;

    /* renamed from: o0 */
    public C3516h f16226o0 = new C3516h(this, null);

    /* renamed from: G0 */
    public MergeAlertDialog f16186G0 = null;

    /* renamed from: I0 */
    public C10028c f16190I0 = null;

    /* renamed from: K0 */
    public boolean f16194K0 = false;

    /* renamed from: M0 */
    public Handler f16198M0 = new HandlerC3509a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$a */
    public class HandlerC3509a extends Handler {
        public HandlerC3509a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1022) {
                C10028c.m62183d0(UIManagerActivity.this.f16183F).m62197C2("get_notepad_history_time", System.currentTimeMillis());
                UIManagerActivity.this.m22406c2(message);
            } else {
                if (i10 != 1000007) {
                    return;
                }
                UIManagerActivity.this.m22414y2(message);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$b */
    public class C3510b extends DialogInterfaceOnClickListenerC3515g {
        public C3510b() {
            super(null);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
            if (dialogInterface != null) {
                dialogInterface.cancel();
            }
            UIManagerActivity.this.m22437m2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$c */
    public class C3511c extends DialogInterfaceOnClickListenerC3517i {
        public C3511c() {
            super(null);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws JSONException {
            UIManagerActivity.this.mo19224n2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$d */
    public class DialogInterfaceOnClickListenerC3512d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3512d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AlertDialog alertDialog = UIManagerActivity.this.f16237u;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            ProgressDialog progressDialog = UIManagerActivity.this.f16184F0;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            MergeAlertDialog mergeAlertDialog = UIManagerActivity.this.f16186G0;
            if (mergeAlertDialog != null) {
                mergeAlertDialog.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$e */
    public class DialogInterfaceOnClickListenerC3513e implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f16253a;

        /* renamed from: b */
        public final /* synthetic */ Resources f16254b;

        public DialogInterfaceOnClickListenerC3513e(String str, Resources resources) {
            this.f16253a = str;
            this.f16254b = resources;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!C11829c.m70532M0() || C10028c.m62182c0().m62413x()) {
                UIManagerActivity.this.m22442w2(this.f16253a, this.f16254b);
            } else {
                C11839m.m70688i("UIManagerActivity", "need process extended feature");
                UIManagerActivity.this.m22405b2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$f */
    public class ViewOnClickListenerC3514f implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ RelativeLayout f16256a;

        public ViewOnClickListenerC3514f(RelativeLayout relativeLayout) {
            this.f16256a = relativeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
            RelativeLayout relativeLayout = this.f16256a;
            if (relativeLayout != null) {
                UIManagerActivity.this.m22438o2(relativeLayout);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$g */
    public static class DialogInterfaceOnClickListenerC3515g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3515g() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3515g(HandlerC3509a handlerC3509a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$h */
    public class C3516h extends BroadcastReceiver {
        public C3516h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C11839m.m70686d("UIManagerActivity", "onReceive: " + safeIntent.getAction());
            if ("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH".equals(safeIntent.getAction()) && UIManagerActivity.this.f16194K0) {
                C11839m.m70688i("UIManagerActivity", "open switch after upgrade");
                UIManagerActivity.this.m22441r2();
                UIManagerActivity.this.f16194K0 = false;
            }
        }

        public /* synthetic */ C3516h(UIManagerActivity uIManagerActivity, HandlerC3509a handlerC3509a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UIManagerActivity$i */
    public static class DialogInterfaceOnClickListenerC3517i implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3517i() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3517i(HandlerC3509a handlerC3509a) {
            this();
        }
    }

    /* renamed from: B2 */
    private void m22388B2() {
        C13227f.m79492i1().m79585f0("action_code_jump_cloud_photos", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_jump_cloud_photos", "1", "from_gallery_detail_page");
    }

    /* renamed from: L2 */
    private void m22390L2(String str, int i10) {
        m22411t2("browser", str, i10);
        C1008c.m6035v().m6065b0(this, 1, "");
    }

    /* renamed from: M2 */
    private void m22392M2(String str, int i10) {
        m22411t2("calendar", str, i10);
        C1008c.m6035v().m6067c0(this, 1, "");
    }

    /* renamed from: N2 */
    private void m22394N2(String str, int i10, int i11) {
        if (C13843a.m83073Y(this)) {
            m22396O2(str, i11);
            return;
        }
        C1008c.m6035v().m6081j0(this);
        m22411t2("addressbook", str, i11);
        C1008c.m6035v().m6069d0(i10);
    }

    /* renamed from: O2 */
    private void m22396O2(String str, int i10) {
        m22411t2("addressbook", str, i10);
        C1008c.m6035v().m6071e0(this, 1, "");
    }

    /* renamed from: P2 */
    private void m22398P2(String str, int i10) {
        m22411t2("notepad", str, i10);
        C1008c.m6035v().m6077h0(this, 1, "");
    }

    /* renamed from: Q2 */
    private void m22400Q2(String str, String str2, int i10) {
        NotifyConstants.putServicesMoudleIntoMap(str, true);
        m22411t2(str, str2, i10);
        C1008c.m6035v().m6075g0(this, str, 1, "");
    }

    /* renamed from: R2 */
    private void m22402R2(String str, int i10) {
        C1008c.m6035v().m6081j0(this);
        m22411t2("wlan", str, i10);
        C1008c.m6035v().m6061Z("dsswitch");
        C1008c.m6035v().m6089n0(this);
    }

    /* renamed from: b2 */
    public void m22405b2() {
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("com.huawei.android.hicloud.ui.activity.CloudSpaceExpansionServiceActivity");
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("UIManagerActivity", "start ExpansionService Activity error: " + e10.toString());
        }
    }

    /* renamed from: c2 */
    public void m22406c2(Message message) {
        C11839m.m70686d("UIManagerActivity", "notepad history message type is " + message.arg1);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f16183F);
        int i10 = message.arg1;
        if (i10 == -10 || i10 == -5) {
            c10028cM62183d0.m62336h2("notepad_has_history_data", false);
        } else {
            if (i10 != 0) {
                return;
            }
            c10028cM62183d0.m62336h2("notepad_has_history_data", true);
        }
    }

    /* renamed from: e2 */
    private void m22407e2() {
        this.f16186G0 = new MergeAlertDialog(this, this, 10);
        this.f16184F0 = new ProgressDialog(this);
    }

    /* renamed from: g2 */
    private void m22408g2() {
        this.f16229q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f16192J0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        NotchFitLinearLayout notchFitLinearLayout = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.general_page_detail_frame);
        this.f16231r = notchFitLinearLayout;
        m22421H2(this, notchFitLinearLayout);
        this.f16211Z = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_delete_frame);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.general_page_delete_data);
        this.f16236t0 = hwButton;
        C11842p.m70874v1(this, hwButton);
        this.f16197M = (ImageView) C12809f.m76829b(this, R$id.general_detail_page_icon);
        this.f16199N = (RelativeLayout) C12809f.m76829b(this, R$id.data_size_frame);
        this.f16200O = (MaxWidthTextView) C12809f.m76829b(this, R$id.data_size_title);
        this.f16201P = (TextView) C12809f.m76829b(this, R$id.data_size_used);
        this.f16202Q = C12809f.m76829b(this, R$id.list_interval);
        this.f16203R = (RelativeLayout) C12809f.m76829b(this, R$id.other_data_frame);
        this.f16204S = (MaxWidthTextView) C12809f.m76829b(this, R$id.other_data_title);
        this.f16205T = (TextView) C12809f.m76829b(this, R$id.other_data_used);
        this.f16206U = C12809f.m76829b(this, R$id.list_interval_2);
        this.f16207V = C12809f.m76829b(this, R$id.list_interval_3);
        this.f16208W = (RelativeLayout) C12809f.m76829b(this, R$id.other_data_frame2);
        this.f16209X = (MaxWidthTextView) C12809f.m76829b(this, R$id.other_data_title2);
        this.f16210Y = (TextView) C12809f.m76829b(this, R$id.other_data_used2);
        this.f16187H = (TextView) C12809f.m76829b(this, R$id.general_detai_subtitle);
        this.f16189I = (TextView) C12809f.m76829b(this, R$id.general_version);
        this.f16195L = (RelativeLayout) C12809f.m76829b(this, R$id.enter_hyperlink);
        this.f16191J = (TextView) C12809f.m76829b(this, R$id.enter_hyperlink_text);
        this.f16193K = (TextView) C12809f.m76829b(this, R$id.enter_hyperlink_tip_text);
        this.f16238u0 = C12809f.m76829b(this, R$id.view_up_down_interval);
        this.f16230q0 = C12809f.m76829b(this, R$id.interval_operation_record);
        NotchFitLinearLayout notchFitLinearLayout2 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.show_operation_record);
        this.f16212a0 = notchFitLinearLayout2;
        notchFitLinearLayout2.setOnClickListener(this);
        this.f16213b0 = (SpanClickText) C12809f.m76829b(this, R$id.gallery_disable_text);
        this.f16214c0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.show_gallery_disable_text);
        this.f16215d0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.show_delete_cloud_album_data);
        this.f16216e0 = (RelativeLayout) C12809f.m76829b(this, R$id.show_delete_cloud_album);
        this.f16217f0 = (RelativeLayout) C12809f.m76829b(this, R$id.show_delete_local_not_cloud_album);
        this.f16218g0 = (TextView) C12809f.m76829b(this, R$id.show_delete_cloud_album_data_text);
        this.f16219h0 = (TextView) C12809f.m76829b(this, R$id.show_delete_local_not_cloud_album_data_text);
        this.f16220i0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.show_cloud_disk_manager);
        this.f16225n0 = (RelativeLayout) C12809f.m76829b(this, R$id.goto_cloud_disk_manager);
        this.f16228p0 = (RelativeLayout) C12809f.m76829b(this, R$id.goto_recently_deleted);
        this.f16225n0.setOnClickListener(this);
        this.f16228p0.setOnClickListener(this);
        this.f16234s0 = (ImageView) C12809f.m76829b(this, R$id.operation_record_right_arrow);
        this.f16232r0 = (ProgressBar) C12809f.m76829b(this, R$id.operation_record_loading_progress);
        if (this.f16227p) {
            this.f16212a0.setVisibility(0);
            this.f16230q0.setVisibility(4);
        } else {
            this.f16212a0.setVisibility(8);
            this.f16230q0.setVisibility(8);
        }
        this.f16246y0 = (LinearLayout) C12809f.m76829b(this, R$id.general_page_content2);
        this.f16248z0 = (RelativeLayout) C12809f.m76829b(this, R$id.general_page_content3);
        this.f16244x0 = (HwButton) C12809f.m76829b(this, R$id.general_shelve_btn);
        this.f16242w0 = (HwButton) C12809f.m76829b(this, R$id.general_cancel_shelve_btn);
        this.f16240v0 = (TextView) C12809f.m76829b(this, R$id.gallery_shelve_tips);
        this.f16174A0 = (TextView) C12809f.m76829b(this, R$id.general_cancel_shelve_tip);
        this.f16176B0 = (TextView) C12809f.m76829b(this, R$id.general_download_textview);
        this.f16178C0 = (TextView) C12809f.m76829b(this, R$id.general_download_exception_tip);
        this.f16182E0 = (SpanClickText) C12809f.m76829b(this, R$id.general_download_check);
        this.f16180D0 = (TextView) C12809f.m76829b(this, R$id.gallery_shelve_tips_text);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rlay_cloud_photos);
        this.f16221j0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f16222k0 = (TextView) C12809f.m76829b(this, R$id.tv_cloud_photos_num);
        this.f16224m0 = C12809f.m76829b(this, R$id.cloud_photos_underline);
        this.f16223l0 = (SpanClickText) C12809f.m76829b(this, R$id.tv_status_des);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getDrawable(R$drawable.ic_cloud_album_honor));
        } else {
            this.f16197M.setImageDrawable(getDrawable(R$drawable.ic_cloud_album));
        }
    }

    /* renamed from: k2 */
    private void m22409k2() {
        boolean zM5975v = C1006a.m5936k().m5975v(this);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", zM5975v);
        if (zM5975v) {
            bundle.putBoolean("ShareAlbum", true);
            C13223b.m79473a(this, "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", "15");
        } else {
            C13223b.m79473a(this, "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1", "15");
        }
        C1006a.m5936k().m5943G(this, bundle, 13);
        C1008c.m6035v().m6053R(this, zM5975v);
    }

    /* renamed from: s2 */
    private void m22410s2(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("UIManagerActivity", "performSynchronization, moduleName is empty");
        }
        C11839m.m70688i("UIManagerActivity", "performSynchronization, moduleName: " + str);
        str.hashCode();
        switch (str) {
            case "addressbook":
                C1008c.m6035v().m6050O(this.f16183F, "addressbook", true);
                m22394N2(str2, SyncType.OPEN_SWITCH_MANUALLY, i10);
                break;
            case "gallery":
                m22409k2();
                break;
            case "calendar":
                m22392M2(str2, i10);
                break;
            case "wlan":
                C1008c.m6035v().m6050O(this.f16183F, "wlan", true);
                m22402R2(str2, i10);
                break;
            case "browser":
                m22390L2(str2, i10);
                break;
            case "notepad":
                m22398P2(str2, i10);
                break;
            default:
                NotifyConstants.putServicesMoudleIntoMap(str, true);
                m22400Q2(str, str2, i10);
                break;
        }
    }

    /* renamed from: t2 */
    private void m22411t2(String str, String str2, int i10) {
        C13223b.m79477e(this, str, true, i10);
        UBAAnalyze.m29955P("PVC", C13471c.m81132e().get(str), "1", "29", i10);
        this.f16190I0.m62336h2(str, true);
        C10155f.m63262O(this, true);
        C13612b.m81829B().m81870k0(getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75172d(new C10147j(getApplicationContext(), arrayList, "03003", str2));
    }

    /* renamed from: u2 */
    private void m22412u2(int i10) {
        C11839m.m70688i("UIManagerActivity", "processSwitchOpenPermissionResult");
        if (i10 == 20004) {
            List<String> listM69911k = this.f22163b.m69911k("sync_contact");
            C11839m.m70688i("UIManagerActivity", "contact need permissions size: " + listM69911k.size());
            List<String> listM69903b = this.f22163b.m69903b(this, listM69911k);
            if (listM69903b == null || listM69903b.size() == 0) {
                m22413v2("addressbook");
                return;
            }
            return;
        }
        if (i10 == 20005) {
            List<String> listM69911k2 = this.f22163b.m69911k("sync_calendar");
            C11839m.m70688i("UIManagerActivity", "calendar need permissions size: " + listM69911k2.size());
            List<String> listM69903b2 = this.f22163b.m69903b(this, listM69911k2);
            if (listM69903b2 == null || listM69903b2.size() == 0) {
                m22413v2("calendar");
                return;
            }
            return;
        }
        if (i10 == 20003) {
            List<String> listM69911k3 = this.f22163b.m69911k("sync_ablum");
            C11839m.m70688i("UIManagerActivity", "gallery need permissions size: " + listM69911k3.size());
            List<String> listM69903b3 = this.f22163b.m69903b(this, listM69911k3);
            if (listM69903b3 == null || listM69903b3.size() == 0) {
                m22439p2();
            }
        }
    }

    /* renamed from: v2 */
    private void m22413v2(String str) {
        m22443x2(str, 10);
        ProgressDialog progressDialog = this.f16184F0;
        if (progressDialog != null) {
            progressDialog.setMessage(getResources().getString(R$string.opening));
            this.f16184F0.setCancelable(false);
            this.f16184F0.show();
        }
    }

    /* renamed from: y2 */
    public void m22414y2(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Boolean)) {
            C11839m.m70687e("UIManagerActivity", "Cannot get boolean from message");
            return;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        Bundle data = message.getData();
        if (data == null) {
            C11839m.m70687e("UIManagerActivity", "queryLocalDataFinish, bundle data is null");
            return;
        }
        String string = data.getString("sync_type_key", "");
        int i10 = data.getInt("sync_operation_type", 10);
        C11839m.m70688i("UIManagerActivity", "Query local data finish, module id = " + string + ", result = " + zBooleanValue);
        ProgressDialog progressDialog = this.f16184F0;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String string2 = data.getString("trace_id_key", "");
        if (!zBooleanValue) {
            m22410s2(string, string2, i10);
            m22416C2(string, "1", "1", i10);
            m22430Z1();
        } else {
            if (this.f16186G0 == null || isFinishing()) {
                return;
            }
            this.f16186G0.show(string, string2);
        }
    }

    /* renamed from: A2 */
    public final void m22415A2(int i10) {
        String str;
        String str2;
        if (i10 == R$id.goto_cloud_disk_manager) {
            str = "mecloud_favorite_mng_click_goto";
            str2 = "28";
        } else if (i10 == R$id.goto_recently_deleted) {
            str = "mecloud_favorite_mng_click_goto_recently_deleted";
            str2 = "82";
        } else {
            str = "mecloud_mng_other_click_goto";
            str2 = "100";
        }
        C13227f.m79492i1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", str2);
    }

    /* renamed from: C2 */
    public final void m22416C2(String str, String str2, String str3, int i10) {
        String str4;
        String str5;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("UIManagerActivity", "reportSyncModuleAction, moduleName is empty");
            return;
        }
        C11839m.m70688i("UIManagerActivity", "reportSyncModuleAction, moduleName: " + str);
        str.hashCode();
        switch (str) {
            case "addressbook":
                str4 = "mecloud_main_click_contacts";
                str5 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str4 = "mecloud_main_click_calendar";
                str5 = "11";
                break;
            case "wlan":
                str4 = "mecloud_clouddiskmain_click_wlan";
                str5 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str4 = "mecloud_clouddiskmain_click_browser";
                str5 = "20";
                break;
            case "notepad":
                str4 = "mecloud_main_click_notepad";
                str5 = "10";
                break;
            default:
                str4 = "mecloud_main_click_" + str;
                str5 = "29";
                break;
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        String str6 = str4;
        C13227f.m79492i1().m79588i0(str6, str2, str3, C13452e.m80781L().m80971t0(), i10);
        UBAAnalyze.m29973d0("PVC", str6, "1", str5, str2, str3, i10);
    }

    /* renamed from: D2 */
    public void m22417D2(int i10, String str, String str2, String str3) {
        this.f16239v = i10;
        this.f16241w = str;
        this.f16185G = str2;
        this.f16243x = str3;
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        m22412u2(i10);
    }

    /* renamed from: E2 */
    public void m22418E2(int i10, String str, String str2, String str3, int i11) {
        m22417D2(i10, str, str2, str3);
        this.f16245y = i11;
    }

    /* renamed from: F2 */
    public void m22419F2(RelativeLayout relativeLayout, TextView textView, String str, String str2) {
        if (relativeLayout == null || textView == null || str == null || str2 == null) {
            C11839m.m70687e("UIManagerActivity", "setLinkableTxt params has null");
        } else {
            relativeLayout.setOnClickListener(new ViewOnClickListenerC3514f(relativeLayout));
            textView.setText(str2);
        }
    }

    /* renamed from: G2 */
    public void m22420G2(Context context, String str) throws Resources.NotFoundException {
        if (context == null || context.getResources() == null || TextUtils.isEmpty(str)) {
            return;
        }
        String string = context.getResources().getString(R$string.module_version_name, str);
        this.f16189I.setVisibility(0);
        this.f16189I.setText(string);
    }

    /* renamed from: H2 */
    public void m22421H2(Context context, View view) {
        this.f16183F = context;
        if (context.getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetricsM70876w = C11842p.m70876w(this);
            RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.gellery_detail_page_left_frame);
            this.f16233s = relativeLayout;
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                layoutParams.width = (displayMetricsM70876w.widthPixels * 5) / 12;
                this.f16233s.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: I2 */
    public final void m22422I2(boolean z10) {
        if (z10) {
            this.f16234s0.setVisibility(0);
            this.f16232r0.setVisibility(8);
        } else {
            this.f16234s0.setVisibility(8);
            this.f16232r0.setVisibility(0);
        }
    }

    /* renamed from: J2 */
    public void m22423J2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f16181E = progressDialog;
        progressDialog.setMessage(getResources().getString(R$string.hicloud_notepad_deleting));
        this.f16181E.setCancelable(false);
        this.f16181E.show();
    }

    /* renamed from: K2 */
    public final void m22424K2(Intent intent, String str) {
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("UIManagerActivity", str + " startGoActivity error " + e10.getMessage());
        }
    }

    /* renamed from: U1 */
    public final void m22425U1(String str, String str2) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(this, "manage_app_detail_btn_click", "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put("APP_NAME", str);
            jSONObjectM79482j.put("BTN_TYPE", str2);
        } catch (JSONException e10) {
            C11839m.m70687e("UIManagerActivity", "collectBIEvent json error:" + e10.toString());
        }
        C13222a.m79461c(this, jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "manage_app_detail_btn_click", "1", "7", jSONObjectM79482j);
        if (this instanceof SoundRecordDetailActivity) {
            C11839m.m70686d("UIManagerActivity", "backup_detail_delete click");
        }
    }

    /* renamed from: V1 */
    public final void m22426V1(String str) throws JSONException {
        String str2;
        if (this instanceof MemorandumDetailActivity) {
            str2 = "notepad";
            m22425U1("notepad", str);
        } else if (this instanceof MessageDetailActivity) {
            str2 = NavigationUtils.SMS_SCHEMA_PREF;
            m22425U1(NavigationUtils.SMS_SCHEMA_PREF, str);
        } else if (this instanceof CallLogDetailActivity) {
            str2 = "calllog";
            m22425U1("calllog", str);
        } else if (this instanceof SoundRecordDetailActivity) {
            str2 = "recording";
            m22425U1("recording", str);
        } else if (this instanceof HarassmentInterceptDetailActivity) {
            str2 = "phonemanager";
            m22425U1("phonemanager", str);
        } else {
            str2 = "";
        }
        CommonReportUtil.reportCloudStorageDeleteBtnClick(str2, str);
    }

    /* renamed from: W1 */
    public final void m22427W1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C13223b.m79475c(this, "manage_app_start", str, C13452e.m80781L().m80971t0(), "2");
        UBAAnalyze.m29959T("PVC", "manage_app_start", "1", "7", str, "2");
    }

    /* renamed from: X1 */
    public void m22428X1(int i10, int i11, int i12) throws IllegalAccessException, IllegalArgumentException {
        if (this.f16183F == null) {
            return;
        }
        if (getString(R$string.cloudbackup_back_item_notepad).equals(this.f16243x)) {
            i10 = R$string.module_data_delete_alert_notepad;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16183F);
        builder.setMessage(this.f16183F.getResources().getString(i10)).setPositiveButton(this.f16183F.getResources().getString(i12), new C3511c()).setNegativeButton(this.f16183F.getResources().getString(i11), new C3510b());
        AlertDialog alertDialogCreate = builder.create();
        this.f16235t = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f16235t.setCanceledOnTouchOutside(false);
        try {
            this.f16235t.show();
        } catch (Exception e10) {
            C11839m.m70687e("UIManagerActivity", "deleteDataDialog exception" + e10.toString());
        }
        Button button = this.f16235t.getButton(-1);
        if (button != null) {
            button.setTextColor(this.f16183F.getResources().getColor(R$color.red));
        }
    }

    /* renamed from: Y1 */
    public final void m22429Y1() {
        try {
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            long longExtra = intent.getLongExtra("detail_size_long", 0L);
            this.f16173A = intent.getIntExtra("detail_num", 0);
            this.f16247z = longExtra <= 0 ? "" : C0223k.m1524g(this, longExtra);
        } catch (Exception e10) {
            C11839m.m70687e("UIManagerActivity", "getCommonData intent param error:" + e10.toString());
        }
    }

    /* renamed from: Z1 */
    public final void m22430Z1() {
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.f16241w);
            if ("com.huawei.hitouch".equals(this.f16241w)) {
                launchIntentForPackage = new Intent("com.huawei.hitouch.READ_LATER_CARD_ACTION");
                launchIntentForPackage.putExtra("FROM", "com.huawei.hidisk");
                C0209d.m1302r2(launchIntentForPackage, this.f16241w);
            }
            if (launchIntentForPackage == null) {
                Toast.makeText(this, getResources().getString(R$string.general_no_tips, this.f16243x), 1).show();
                return;
            }
            m22427W1(this.f16241w);
            if (TextUtils.isEmpty(this.f16185G)) {
                if (this.f16245y == 4) {
                    launchIntentForPackage.setFlags(337641472);
                } else {
                    launchIntentForPackage.setFlags(69206016);
                }
                m22424K2(launchIntentForPackage, this.f16241w);
                return;
            }
            if ("CLOUD_SYNC_CONFIG_ACTIVITY".equals(this.f16185G)) {
                launchIntentForPackage.setFlags(337641472);
                m22424K2(launchIntentForPackage, this.f16241w);
                return;
            }
            if ("com.huawei.hidisk.filemanager.FileManager".equals(this.f16185G)) {
                m22375i1(this, 0);
                return;
            }
            if (!"com.android.settings.Settings$WifiSettingsActivity".equals(this.f16185G)) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                m22424K2(intent.setComponent(new ComponentName(this.f16241w, this.f16185G)), this.f16241w);
            } else if (C0209d.m1281m1()) {
                Intent intent2 = new Intent("android.settings.WIFI_SETTINGS");
                intent2.addCategory("android.intent.category.DEFAULT");
                m22424K2(intent2.setComponent(new ComponentName(this.f16241w, this.f16185G)), this.f16241w);
            } else {
                Intent intent3 = new Intent("android.intent.action.MAIN");
                intent3.addCategory("android.intent.category.LAUNCHER");
                m22424K2(intent3.setComponent(new ComponentName(this.f16241w, this.f16185G)), this.f16241w);
            }
        } catch (Exception e10) {
            C11839m.m70687e("UIManagerActivity", this.f16241w + " goManage error " + e10.getMessage());
        }
    }

    /* renamed from: a2 */
    public final void m22431a2(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        Resources resources;
        Context context = this.f16183F;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        String string = resources.getString(R$string.open_sync_to_manage_title);
        String string2 = resources.getString(R$string.open_sync_to_manage_message);
        String string3 = resources.getString(R$string.sync_data_merge_btn_confirm);
        String string4 = resources.getString(R$string.hicloud_cover_open_btn);
        if (this.f16243x.equals(getString(R$string.gallery_item_title))) {
            string = resources.getString(R$string.open_album_data_sync);
            string2 = resources.getString(R$string.gallery_main_other_describe_msg);
            string3 = resources.getString(R$string.cloudalbum_switch_close_now);
            string4 = resources.getString(R$string.cloudalbum_switch_open_now);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16183F);
        builder.setTitle(string).setMessage(string2).setPositiveButton(string4, new DialogInterfaceOnClickListenerC3513e(str, resources)).setNegativeButton(string3, new DialogInterfaceOnClickListenerC3512d());
        AlertDialog alertDialogCreate = builder.create();
        this.f16237u = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f16237u.setCancelable(true);
        this.f16237u.setCanceledOnTouchOutside(false);
        this.f16237u.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16192J0);
        arrayList.add(this.f16229q);
        arrayList.add(this.f16231r);
        arrayList.add(this.f16211Z);
        arrayList.add(this.f16212a0);
        arrayList.add(this.f16220i0);
        arrayList.add(this.f16214c0);
        arrayList.add(this.f16193K);
        arrayList.add(this.f16215d0);
        return arrayList;
    }

    /* renamed from: d2 */
    public void m22432d2() {
        ProgressDialog progressDialog = this.f16181E;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f16181E = null;
        }
    }

    /* renamed from: f2 */
    public void m22433f2(boolean z10) {
        this.f16227p = z10;
        float fM1195O = C0209d.m1195O(this);
        if (fM1195O >= 1.75f && fM1195O < 3.2f) {
            setContentView(R$layout.storage_manage_item_detail_2);
        } else if (fM1195O >= 3.2f) {
            setContentView(R$layout.storage_manage_item_detail_3dot2);
        } else {
            setContentView(R$layout.storage_manage_item_detail);
        }
        m22408g2();
        mo19005p1();
    }

    /* renamed from: h2 */
    public boolean mo19217h2() {
        return true;
    }

    /* renamed from: i2 */
    public boolean m22434i2() {
        if (C0209d.m1333z1(this)) {
            this.f16192J0.m23914a();
            return false;
        }
        this.f16192J0.m23919i();
        return true;
    }

    /* renamed from: j2 */
    public final /* synthetic */ void m22435j2(UserDataStateInfo userDataStateInfo) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C11839m.m70688i("UIManagerActivity", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C11839m.m70688i("UIManagerActivity", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C11839m.m70688i("UIManagerActivity", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            if (interfaceC9282a != null) {
                C11839m.m70688i("UIManagerActivity", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
                interfaceC9282a.mo58399V0(System.currentTimeMillis());
            }
        }
        if (interfaceC9282a == null) {
            return;
        }
        if (C13452e.m80781L().m80791C0() && interfaceC9282a.mo58370H() == 1) {
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b == null) {
                C11839m.m70687e("UIManagerActivity", "jumpToCloudSpaceUpgradePage cloudBackupRouter is null");
                return;
            }
            this.f16194K0 = true;
            C11839m.m70688i("UIManagerActivity", "jump to cloud space upgrade page.");
            interfaceC9283b.mo58515k(this, null);
            return;
        }
        if (!C13452e.m80781L().m80791C0() || interfaceC9282a.mo58370H() != 0 || (interfaceC9282a.mo58409a0() != 1 && interfaceC9282a.mo58409a0() != 2)) {
            m22441r2();
            return;
        }
        InterfaceC9283b interfaceC9283b2 = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        if (interfaceC9283b2 == null) {
            C11839m.m70687e("UIManagerActivity", "jumpToDataExpiresDownloadPage cloudBackupRouter is null");
            return;
        }
        this.f16194K0 = true;
        C11839m.m70688i("UIManagerActivity", "jump to data expire download page.");
        interfaceC9283b2.mo58530u(this, null);
    }

    /* renamed from: l2 */
    public final void m22436l2(View view) throws JSONException, IllegalAccessException, IllegalArgumentException {
        if (R$id.general_page_delete_data == view.getId()) {
            C11839m.m70686d("UIManagerActivity", "backup_detail_delete click");
            if (!C0209d.m1333z1(this)) {
                Toast.makeText(this, getString(R$string.gallery_no_network_tips), 0).show();
                return;
            }
            m22426V1(NotifyConstants.CommonReportConstants.OPERATION_NAME_DELETE_BTN_CLICK);
            if (this.f16177C) {
                Toast.makeText(this, getString(R$string.hicloud_notepad_deleting), 0).show();
                return;
            } else {
                m22428X1(R$string.module_data_delete_alert_new, R$string.clone_install_cancle, R$string.cloudbackup_btn_delete);
                return;
            }
        }
        if (view.getId() == R$id.show_operation_record) {
            m22422I2(false);
            if (m22434i2()) {
                m22422I2(true);
                return;
            }
            m22422I2(true);
            Intent intent = new Intent();
            intent.putExtra("operation_record_data_type", this.f16245y);
            intent.setClass(this, OperationRecordDetailsActivity.class);
            startActivity(intent);
            return;
        }
        int id2 = view.getId();
        int i10 = R$id.goto_cloud_disk_manager;
        if (id2 == i10) {
            m22415A2(i10);
            m22375i1(this, 9);
            return;
        }
        int id3 = view.getId();
        int i11 = R$id.goto_recently_deleted;
        if (id3 == i11) {
            m22415A2(i11);
            m22377k1(this);
        } else if (view.getId() == R$id.rlay_cloud_photos) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58429h(this, 0);
            }
            C13227f.m79492i1().m79593q0("CLICK_HISYNC_SPACE_CLOUD_PHOTOS");
            m22388B2();
        }
    }

    /* renamed from: m2 */
    public void m22437m2() throws JSONException {
        m22426V1("delete_btn_cancel");
    }

    /* renamed from: n2 */
    public void mo19224n2() throws JSONException {
        m22426V1("delete_btn_confirm");
    }

    /* renamed from: o2 */
    public void m22438o2(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            return;
        }
        onClickHyperlink(view);
        m22436l2(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        AlertDialog alertDialog = this.f16237u;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        ProgressDialog progressDialog = this.f16184F0;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        MergeAlertDialog mergeAlertDialog = this.f16186G0;
        if (mergeAlertDialog != null) {
            mergeAlertDialog.dismiss();
        }
    }

    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        if (C0209d.m1226Y0()) {
            return;
        }
        onClickHyperlink(view);
        m22436l2(view);
    }

    @SuppressLint({"StringFormatMatches"})
    public void onClickHyperlink(View view) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (view.getId() == this.f16239v) {
            m22444z2(this.f16243x);
            if (mo19217h2()) {
                m22430Z1();
            } else {
                m22431a2(this.f16243x);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11839m.m70688i("UIManagerActivity", "onCreate");
        m22429Y1();
        m22407e2();
        C13108a.m78878b(this).m78880c(this.f16226o0, new IntentFilter("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH"));
        this.f16190I0 = C10028c.m62183d0(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
        C11839m.m70688i("UIManagerActivity", "onDestroy");
        AlertDialog alertDialog = this.f16235t;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f16235t = null;
        }
        ProgressDialog progressDialog = this.f16181E;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f16181E = null;
        }
        AlertDialog alertDialog2 = this.f16237u;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f16237u = null;
        }
        ProgressDialog progressDialog2 = this.f16184F0;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
            this.f16184F0 = null;
        }
        AlertDialog alertDialog3 = this.f16188H0;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
            this.f16188H0 = null;
        }
        MergeAlertDialog mergeAlertDialog = this.f16186G0;
        if (mergeAlertDialog != null) {
            mergeAlertDialog.dismiss();
            this.f16186G0 = null;
        }
        if (this.f16198M0 != null) {
            this.f16198M0 = null;
        }
        if (this.f16226o0 != null) {
            C13108a.m78878b(this).m78883f(this.f16226o0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58361C0(this);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.onRestoreInstanceState(bundle);
        boolean z10 = bundle.getBoolean("isShowDeleteDialog");
        this.f16179D = z10;
        if (z10) {
            m22428X1(R$string.module_data_delete_alert_new, R$string.clone_install_cancle, R$string.cloudbackup_btn_delete);
        }
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f16192J0 != null) {
            if (C0209d.m1333z1(this)) {
                this.f16192J0.m23914a();
            } else {
                this.f16192J0.m23919i();
            }
        }
        this.f16194K0 = false;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isShowDeleteDialog", this.f16179D);
    }

    /* renamed from: p2 */
    public final void m22439p2() {
        if (C13612b.m81829B().m81886t(this)) {
            return;
        }
        m22440q2();
    }

    /* renamed from: q2 */
    public final void m22440q2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.activity.u8
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                this.f17764a.m22435j2(userDataStateInfo);
            }
        }, true, arrayList, "UIManager"), false);
    }

    /* renamed from: r2 */
    public final void m22441r2() {
        C1008c.m6035v().m6081j0(getApplication());
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", true);
        bundle.putBoolean("ShareAlbum", true);
        C13223b.m79475c(this, "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        UBAAnalyze.m29959T("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", "15", "1", C13222a.m79465g(this));
        C13224c.m79487f1().m79587h0("mecloud_gallerymain_click_switch", "1", "1", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29971c0("PVC", "mecloud_gallerymain_click_switch", "1", "15", "1", "1");
        C1006a.m5936k().m5951O(true, this);
        C1006a.m5936k().m5943G(this, bundle, 40);
        C1008c.m6035v().m6053R(this, true);
        m22430Z1();
    }

    /* renamed from: w2 */
    public final void m22442w2(String str, Resources resources) {
        if (str.equals(resources.getString(R$string.contact))) {
            if (!m29143z0("addressbook")) {
                return;
            } else {
                m22413v2("addressbook");
            }
        } else if (str.equals(resources.getString(R$string.calendar_sync_item))) {
            if (!m29143z0("calendar")) {
                return;
            } else {
                m22413v2("calendar");
            }
        } else if (str.equals(resources.getString(R$string.cloudbackup_back_item_notepad))) {
            m22413v2("notepad");
        } else if (str.equals(resources.getString(R$string.browser))) {
            m22413v2("browser");
        } else if (str.equals(resources.getString(R$string.wlan_detail)) || str.equals(resources.getString(R$string.wifi_sync))) {
            m22413v2("wlan");
        } else if (str.equals(resources.getString(R$string.gallery_item_title))) {
            if (!m29143z0(HNConstants.DataType.MEDIA)) {
                return;
            } else {
                m22439p2();
            }
        } else if (!TextUtils.isEmpty(str)) {
            m22413v2(str);
        }
        C11839m.m70688i("UIManagerActivity", "open switch " + str);
    }

    /* renamed from: x2 */
    public final void m22443x2(String str, int i10) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("UIManagerActivity", "Query local data: " + str + ", traceId: " + strM81958d);
        C1008c.m6035v().m6048M(this, this.f16198M0, str, strM81958d, i10);
    }

    /* renamed from: z2 */
    public final void m22444z2(String str) {
        String str2;
        String str3;
        if (str == null) {
            C11839m.m70687e("UIManagerActivity", "reportGoAction, modeName is null");
            return;
        }
        if (str.equals(getString(R$string.browser))) {
            str2 = "mecloud_browser_mng_click_goto";
            str3 = "20";
        } else if (str.equals(getString(R$string.calendar_sync_item))) {
            str2 = "mecloud_calendar_mng_click_goto";
            str3 = "11";
        } else if (str.equals(getString(R$string.cloud_collect))) {
            str2 = "mecloud_favorite_mng_click_goto";
            str3 = "28";
        } else if (str.equals(getString(R$string.contact))) {
            str2 = "mecloud_contact_mng_click_goto";
            str3 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
        } else if (str.equals(getString(R$string.wlan_detail)) || str.equals(getString(R$string.wifi_sync))) {
            str2 = "mecloud_contact_mng_wlan_goto";
            str3 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
        } else if (str.equals(getString(R$string.gallery_item_title))) {
            str2 = "mecloud_gallery_mng_click_goto";
            str3 = "3";
        } else if (str.equals(getString(R$string.notepad_app_name))) {
            str2 = "mecloud_notepad_mng_click_goto";
            str3 = "10";
        } else {
            str2 = "mecloud_mng_other_click_goto";
            str3 = "100";
        }
        C13227f.m79492i1().m79585f0(str2, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str2, "1", str3);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        m22410s2(str, str2, i10);
        m22416C2(str, "1", "1", i10);
        m22430Z1();
    }
}
