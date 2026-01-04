package ge;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.bean.HonorVersionInfo;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ForceUpgradeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.UpgradeHomePageBar;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import gp.C10028c;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0226l0;
import p020ap.C1007b;
import p336he.C10158i;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p709vj.C13452e;
import sk.C12809f;
import tj.C13019a;

/* renamed from: ge.h */
/* loaded from: classes3.dex */
public class C9913h {

    /* renamed from: h */
    public static C9913h f48644h;

    /* renamed from: a */
    public Activity f48645a;

    /* renamed from: b */
    public boolean f48646b;

    /* renamed from: c */
    public AlertDialog f48647c;

    /* renamed from: d */
    public AlertDialog f48648d;

    /* renamed from: e */
    public AlertDialog f48649e;

    /* renamed from: f */
    public C13108a f48650f;

    /* renamed from: g */
    public final Handler f48651g = new a(Looper.getMainLooper());

    /* renamed from: ge.h$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (C9913h.this.m61597u(message)) {
                return;
            }
            C9913h.this.m61596t(message);
        }
    }

    /* renamed from: ge.h$b */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C9913h.this.m61586M();
        }
    }

    /* renamed from: ge.h$c */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C9913h.this.m61586M();
        }
    }

    /* renamed from: ge.h$d */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C9913h.this.m61590m();
            C9908c.m61499D().m61549p();
            if (C10028c.m62182c0().m62380q1()) {
                if (C10028c.m62182c0().m62320e1()) {
                    C9913h.this.m61592o();
                } else {
                    C11839m.m70686d("UpdateService", "not end service, users can continue to use cloud");
                    C9913h.this.f48645a.finish();
                }
            }
        }
    }

    /* renamed from: ge.h$e */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!C10028c.m62182c0().m62380q1()) {
                C9913h.this.m61577D();
            } else {
                C11839m.m70688i("UpdateService", "click cancel button");
                C9913h.this.m61592o();
            }
        }

        public /* synthetic */ e(C9913h c9913h, a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$f */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("UpdateService", "click exit button");
            C9913h.this.m61592o();
        }

        public /* synthetic */ f(C9913h c9913h, a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$g */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!C0209d.m1208S0(C9913h.this.f48645a)) {
                C9913h.this.m61584K();
            } else {
                C10028c.m62182c0().m62251N3(true);
                C9913h.this.m61588O();
            }
        }
    }

    /* renamed from: ge.h$h */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public HonorVersionInfo f48659a;

        public h(HonorVersionInfo honorVersionInfo) {
            this.f48659a = honorVersionInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!C0209d.m1208S0(C9913h.this.f48645a)) {
                C9913h.this.m61584K();
                return;
            }
            C1007b.m5980s().m6009b();
            MessageCenterManager.getInstance().setMsgAsRead(C13452e.m80781L().m80818J());
            C9908c.m61499D().m61544d0(this.f48659a);
            C10158i.m63321e("2");
            C9913h.this.m61578E();
        }
    }

    /* renamed from: ge.h$i */
    public static class i implements DialogInterface.OnClickListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$j */
    public static class j implements DialogInterface.OnKeyListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            return i10 == 4;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$k */
    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (C0209d.m1208S0(C9913h.this.f48645a)) {
                C9913h.this.m61588O();
            } else {
                C9913h.this.m61584K();
            }
        }

        public /* synthetic */ k(C9913h c9913h, a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$l */
    public static class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C11839m.m70688i("UpdateService", "removeAllActivity run");
            C13019a.m78347n().m78355r();
        }

        public /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* renamed from: ge.h$m */
    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C9913h.this.m61590m();
            if (C0209d.m1208S0(C9913h.this.f48645a)) {
                C9913h.this.m61588O();
            } else {
                C9913h.this.m61584K();
            }
        }

        public /* synthetic */ m(C9913h c9913h, a aVar) {
            this();
        }
    }

    /* renamed from: q */
    public static C9913h m61574q() {
        if (f48644h == null) {
            f48644h = new C9913h();
        }
        return f48644h;
    }

    /* renamed from: A */
    public final /* synthetic */ void m61575A(NotifyJumpInfo notifyJumpInfo, View view) {
        Intent commonGotoIntent = notifyJumpInfo != null ? GeneralRedirectUtil.getCommonGotoIntent("web", notifyJumpInfo.getNotifyUri(), false) : null;
        Activity activity = this.f48645a;
        if (activity == null) {
            C11839m.m70687e("UpdateService", "mContext is null, start detail activity is error");
            return;
        }
        if (commonGotoIntent == null) {
            C11839m.m70687e("UpdateService", "upgradeConfig goto web is error");
            this.f48645a.finish();
        } else if (C0209d.m1208S0(activity)) {
            this.f48645a.startActivity(commonGotoIntent);
        } else {
            m61584K();
        }
    }

    /* renamed from: B */
    public final /* synthetic */ void m61576B() {
        int iM62274T = C10028c.m62182c0().m62274T();
        final ForceUpgradeConfiguration conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig();
        if (iM62274T != 0) {
            conformsConfig = HiCloudForceUpgradeConfigManager.getInstance().getConformsConfig(iM62274T);
        }
        if (conformsConfig == null) {
            C11839m.m70686d("UpdateService", "upgradeConfig is null, not need show.");
            this.f48645a.finish();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        UpgradeHomePageBar homePage = conformsConfig.getHomePage();
        ForcedUpgradeUtil forcedUpgradeUtil = ForcedUpgradeUtil.getInstance();
        String contentString = forcedUpgradeUtil.getContentString(homePage.getHomepageTitle());
        String contentString2 = forcedUpgradeUtil.getContentString(homePage.getHomepageText());
        String contentString3 = forcedUpgradeUtil.getContentString(homePage.getHomepageButton());
        if (TextUtils.isEmpty(contentString) || TextUtils.isEmpty(contentString2) || TextUtils.isEmpty(contentString3)) {
            C11839m.m70687e("UpdateService", "showUpgradeNotice title, message， button is empty");
            this.f48645a.finish();
            return;
        }
        try {
            final NotifyJumpInfo notifyJumpInfo = homePage.getNotifyJumpInfo();
            if (notifyJumpInfo != null && !TextUtils.isEmpty(notifyJumpInfo.getNotifyUri())) {
                builder.setNegativeButton(this.f48645a.getString(R$string.see_details), (DialogInterface.OnClickListener) null);
            }
            builder.setTitle(contentString);
            builder.setMessage(contentString2);
            builder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ge.f
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    return this.f48640a.m61602z(conformsConfig, dialogInterface, i10, keyEvent);
                }
            });
            builder.setTitle(contentString);
            builder.setPositiveButton(contentString3, new g());
            AlertDialog alertDialog = this.f48647c;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f48647c = null;
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f48647c = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.f48647c.show();
            this.f48647c.getButton(-1).setTextColor(this.f48645a.getResources().getColor(R$color.hwbutton_selector_text_emphasize_emui));
            this.f48647c.getButton(-1).setBackground(this.f48645a.getDrawable(R$drawable.hwbutton_emphasize_emui));
            this.f48647c.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: ge.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f48642a.m61575A(notifyJumpInfo, view);
                }
            });
            C10028c.m62182c0().m62251N3(false);
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", "build update dialog error : " + e10.getMessage());
        }
    }

    /* renamed from: D */
    public void m61577D() {
        C11839m.m70688i("UpdateService", "release updateService");
        C9908c.m61499D().m61531Q();
        m61590m();
        if (this.f48645a != null) {
            this.f48645a = null;
        }
    }

    /* renamed from: E */
    public final void m61578E() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.upsdk_ota_update_dialog, (ViewGroup) null);
        builder.setOnCancelListener(new b());
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.ota_warn_text);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.ota_progress_text);
        ((ImageView) C12809f.m76831d(viewInflate, R$id.cancel_imageview)).setOnClickListener(new c());
        ProgressBar progressBar = (ProgressBar) C12809f.m76831d(viewInflate, R$id.ota_progressbar);
        if (C10028c.m62182c0().m62380q1()) {
            textView.setText(R$string.sdk_tip_updating);
        }
        if (textView != null && textView2 != null) {
            if (C11842p.m70732H0(this.f48645a)) {
                textView.setTextColor(-419430401);
                textView2.setTextColor(-419430401);
            } else {
                textView.setTextColor(-436207616);
                textView2.setTextColor(-436207616);
            }
            textView.setAlpha(0.9f);
            textView2.setAlpha(0.9f);
            textView2.setText(m61595s(0));
        }
        progressBar.setProgress(0);
        AlertDialog alertDialogCreate = builder.create();
        this.f48647c = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, m61594r(), 0, m61594r(), 0);
        try {
            this.f48647c.setCanceledOnTouchOutside(false);
            this.f48647c.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", e10.getMessage());
        }
    }

    /* renamed from: F */
    public final void m61579F() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        a aVar = null;
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.hicloud_update_bottom_dialog, (ViewGroup) null);
        ((HwTextView) viewInflate.findViewById(R$id.hicloud_bottom_dialog_message)).setText(R$string.update_fail_retry);
        builder.setPositiveButton(R$string.retry, new m(this, aVar)).setNegativeButton(R$string.cancel, new e(this, aVar));
        AlertDialog alertDialogCreate = builder.create();
        this.f48649e = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, m61594r(), 0, m61594r(), 0);
        try {
            this.f48649e.setCanceledOnTouchOutside(false);
            this.f48649e.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", e10.getMessage());
        }
    }

    /* renamed from: G */
    public void m61580G(Message message, boolean z10) {
        AlertDialog alertDialog = this.f48647c;
        if (alertDialog == null) {
            return;
        }
        TextView textView = (TextView) C12809f.m76830c(alertDialog, R$id.ota_warn_text);
        TextView textView2 = (TextView) C12809f.m76830c(this.f48647c, R$id.ota_progress_text);
        ProgressBar progressBar = (ProgressBar) C12809f.m76830c(this.f48647c, R$id.ota_progressbar);
        if (textView == null || textView2 == null || progressBar == null) {
            return;
        }
        if (C11842p.m70732H0(this.f48645a)) {
            textView.setTextColor(-419430401);
            textView2.setTextColor(-419430401);
        } else {
            textView.setTextColor(-436207616);
            textView2.setTextColor(-436207616);
        }
        textView.setAlpha(0.9f);
        textView2.setAlpha(0.9f);
        if (z10) {
            textView2.setText(m61595s(100));
            progressBar.setProgress(100);
        } else {
            int i10 = message.arg1;
            textView2.setText(m61595s(i10));
            progressBar.setProgress(i10);
        }
    }

    /* renamed from: H */
    public void m61581H() {
        AlertDialog alertDialog = this.f48647c;
        if (alertDialog != null && alertDialog.isShowing()) {
            C11839m.m70686d("UpdateService", "force update dialog is showing, not need show.");
        } else {
            C11839m.m70686d("UpdateService", "showForceUpdateDetail.");
            C0226l0.m1584d(new Runnable() { // from class: ge.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48639a.m61576B();
                }
            });
        }
    }

    /* renamed from: I */
    public void m61582I() {
        C11839m.m70686d("UpdateService", "showHonorUpdateDialog.");
        HonorVersionInfo honorVersionInfoM61518C = C9908c.m61499D().m61518C(C9908c.m61499D().m61517B());
        if (honorVersionInfoM61518C == null) {
            C11839m.m70686d("UpdateService", "versionInfo item is null.");
            return;
        }
        HonorVersionInfo.Info info = honorVersionInfoM61518C.getInfo();
        if (info == null) {
            C11839m.m70686d("UpdateService", "versionInfo info is null.");
            return;
        }
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        a aVar = null;
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.upsdk_new_ota_update_view, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.name_textview);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.version_textview);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.appsize_textview);
        TextView textView4 = (TextView) C12809f.m76831d(viewInflate, R$id.content_textview);
        String title = info.getTitle();
        String name = info.getName();
        String ver = info.getVer();
        String size = info.getSize();
        String detail = info.getDetail();
        if (textView != null) {
            textView.setText(name);
        }
        textView2.setText(ver);
        textView3.setText(size);
        if (detail != null && !detail.isEmpty()) {
            textView4.setVisibility(0);
            textView4.setText(detail);
        }
        try {
            builder.setOnKeyListener(new j(aVar));
            builder.setTitle(title);
            builder.setPositiveButton(R$string.updateNow, new h(honorVersionInfoM61518C));
            builder.setNegativeButton(R$string.update_later_new, new DialogInterface.OnClickListener() { // from class: ge.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    C10158i.m63321e("1");
                }
            });
            AlertDialog alertDialog = this.f48647c;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f48647c = null;
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f48647c = alertDialogCreate;
            alertDialogCreate.setView(viewInflate, 0, 0, 0, 0);
            this.f48647c.show();
            C10158i.m63324h("2", null);
            C10028c.m62182c0().m62269R2(false);
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", "build update dialog error : " + e10.getMessage());
        }
    }

    /* renamed from: J */
    public void m61583J() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.hicloud_installing_dialog, (ViewGroup) null);
        AlertDialog alertDialogCreate = builder.create();
        this.f48648d = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, m61594r(), 0, m61594r(), 0);
        try {
            this.f48648d.setCanceledOnTouchOutside(false);
            this.f48648d.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", e10.getMessage());
        }
    }

    /* renamed from: K */
    public final void m61584K() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.hicloud_update_bottom_dialog, (ViewGroup) null);
        ((HwTextView) viewInflate.findViewById(R$id.hicloud_bottom_dialog_message)).setText(R$string.alert_net_disconnect_new);
        builder.setPositiveButton(R$string.conform, new e(this, null));
        AlertDialog alertDialogCreate = builder.create();
        this.f48649e = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, m61594r(), 0, m61594r(), 0);
        try {
            this.f48649e.setCanceledOnTouchOutside(false);
            this.f48649e.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", e10.getMessage());
        }
    }

    /* renamed from: L */
    public final void m61585L(boolean z10) {
        Activity activity;
        if (z10 || (activity = this.f48645a) == null) {
            return;
        }
        Toast.makeText(activity, R$string.alert_net_disconnect_new, 0).show();
    }

    /* renamed from: M */
    public final void m61586M() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.hicloud_update_bottom_dialog, (ViewGroup) null);
        ((HwTextView) viewInflate.findViewById(R$id.hicloud_bottom_dialog_message)).setText(R$string.app_cancel_download);
        builder.setPositiveButton(R$string.common_positive, new d()).setNegativeButton(R$string.common_negative, new i(null));
        AlertDialog alertDialogCreate = builder.create();
        this.f48649e = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, m61594r(), 0, m61594r(), 0);
        try {
            this.f48649e.setCanceledOnTouchOutside(false);
            this.f48649e.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", e10.getMessage());
        }
    }

    /* renamed from: N */
    public void m61587N(Object obj, boolean z10) {
        AlertDialog alertDialog;
        if (obj == null) {
            C11839m.m70686d("UpdateService", "update item is null.");
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) obj;
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "context is null");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48645a);
        View viewInflate = LayoutInflater.from(this.f48645a).inflate(R$layout.upsdk_new_ota_update_view, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.name_textview);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.version_textview);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.appsize_textview);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(viewInflate, R$id.size_layout);
        TextView textView4 = (TextView) C12809f.m76831d(viewInflate, R$id.content_textview);
        String name_ = apkUpgradeInfo.getName_();
        String version_ = apkUpgradeInfo.getVersion_();
        int size_ = apkUpgradeInfo.getSize_();
        String newFeatures_ = apkUpgradeInfo.getNewFeatures_();
        int isCompulsoryUpdate_ = apkUpgradeInfo.getIsCompulsoryUpdate_();
        C11839m.m70688i("UpdateService", "showUpdateDetails, forcedUpgrade: " + isCompulsoryUpdate_);
        if (textView != null) {
            textView.setText(name_);
        }
        textView2.setText(version_);
        if (size_ > 0) {
            textView3.setText(m61593p(size_));
        } else {
            linearLayout.setVisibility(8);
        }
        if (newFeatures_ != null && !newFeatures_.isEmpty()) {
            textView4.setVisibility(0);
            textView4.setText(newFeatures_);
        }
        try {
            builder.setOnKeyListener(new j(null));
            builder.setTitle(R$string.has_new_version);
            a aVar = null;
            builder.setPositiveButton(R$string.updateNow, new k(this, aVar));
            if (isCompulsoryUpdate_ == 1) {
                builder.setNegativeButton(R$string.update_cancel_now, new f(this, aVar));
                alertDialog = null;
            } else {
                alertDialog = null;
                builder.setNegativeButton(R$string.update_later_new, new i(0 == true ? 1 : 0));
            }
            AlertDialog alertDialog2 = this.f48647c;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
                this.f48647c = alertDialog;
            }
            AlertDialog alertDialogCreate = builder.create();
            this.f48647c = alertDialogCreate;
            alertDialogCreate.setView(viewInflate, 0, 0, 0, 0);
            this.f48647c.show();
        } catch (RuntimeException e10) {
            C11839m.m70687e("UpdateService", "build update dialog error : " + e10.getMessage());
        }
    }

    /* renamed from: O */
    public final void m61588O() {
        C9908c.m61499D().m61542b0();
        m61578E();
    }

    /* renamed from: P */
    public void m61589P(boolean z10) {
        C11839m.m70686d("UpdateService", "updateQuery isAutoCheck = " + z10 + "activity: " + this.f48645a);
        if (!C0209d.m1208S0(this.f48645a)) {
            m61585L(z10);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - C0209d.m1280m0();
        if (jCurrentTimeMillis < RippleView.SINGLE_RIPPLE_TIME && jCurrentTimeMillis > 0) {
            C11839m.m70688i("UpdateService", "updateQuery frequency");
            return;
        }
        C0209d.m1330y2();
        this.f48646b = z10;
        if (!z10) {
            Activity activity = this.f48645a;
            if (activity != null) {
                Toast.makeText(activity, R$string.update_check_tips, 0).show();
                this.f48650f = C13108a.m78878b(this.f48645a);
                Intent intent = new Intent("checkFinish");
                intent.putExtra("visibility", true);
                this.f48650f.m78881d(intent);
            } else {
                C11839m.m70687e("UpdateService", "context is null");
            }
        }
        C9908c.m61499D().m61547h0(z10);
    }

    /* renamed from: m */
    public final void m61590m() {
        try {
            AlertDialog alertDialog = this.f48647c;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.f48647c.dismiss();
                this.f48647c = null;
            }
            AlertDialog alertDialog2 = this.f48649e;
            if (alertDialog2 == null || !alertDialog2.isShowing()) {
                return;
            }
            this.f48649e.dismiss();
            this.f48649e = null;
        } catch (Exception unused) {
            C11839m.m70687e("UpdateService", "dialog dismiss is crash!");
        }
    }

    /* renamed from: n */
    public void m61591n() {
        try {
            AlertDialog alertDialog = this.f48648d;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.f48648d.dismiss();
            this.f48648d = null;
        } catch (Exception unused) {
            C11839m.m70687e("UpdateService", "install dialog dismiss is crash!");
        }
    }

    /* renamed from: o */
    public void m61592o() {
        C11839m.m70688i("UpdateService", "exitAPP");
        if (!C10028c.m62182c0().m62380q1()) {
            Activity activity = this.f48645a;
            if (activity == null) {
                C11839m.m70687e("UpdateService", "exit,context is null");
                return;
            }
            activity.finish();
        }
        new Handler().postDelayed(new l(null), 200L);
    }

    /* renamed from: p */
    public final String m61593p(int i10) {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "getformatupdatesize,context is null");
            return "";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.applyPattern("0.#");
        float f10 = i10;
        int i11 = R$string.cloudbackup_Emotion_KB;
        if (f10 > 0.0f) {
            f10 /= 1024.0f;
        } else {
            C11839m.m70687e("UpdateService", "UpdateSize data error.");
        }
        if (f10 > 900.0f) {
            f10 /= 1024.0f;
            i11 = R$string.cloudbackup_Emotion_MB;
        }
        if (f10 > 900.0f) {
            f10 /= 1024.0f;
            i11 = R$string.cloudbackup_Emotion_GB;
        }
        return this.f48645a.getString(i11, decimalFormat.format(f10));
    }

    /* renamed from: r */
    public final int m61594r() {
        if (this.f48645a == null) {
            C11839m.m70687e("UpdateService", "getPadding,context is null");
            return 0;
        }
        int iM1463a = C0219i.m1463a();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f48645a.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = (int) (displayMetrics.density * 24.0f);
        if (iM1463a >= 8) {
            return i10;
        }
        return 0;
    }

    /* renamed from: s */
    public final String m61595s(int i10) {
        return NumberFormat.getPercentInstance().format(i10 != 0 ? i10 / 100.0d : 0.0d);
    }

    /* renamed from: t */
    public final void m61596t(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            m61599w(message.obj);
            return;
        }
        if (i10 == 2) {
            if (!this.f48646b || C10028c.m62182c0().m62283V0()) {
                m61590m();
                C10028c.m62182c0().m62251N3(false);
                Activity activity = this.f48645a;
                if (activity != null) {
                    Toast.makeText(activity, R$string.NoUpdateFound_20160113, 0).show();
                } else {
                    C11839m.m70687e("UpdateService", "context is null");
                }
            }
            m61577D();
            return;
        }
        if (i10 == 4) {
            m61580G(message, false);
            return;
        }
        if (i10 == 5) {
            m61580G(message, true);
            m61590m();
            return;
        }
        if (i10 == 7) {
            m61583J();
            return;
        }
        if (i10 != 8) {
            if (i10 == 16) {
                m61582I();
                return;
            } else {
                if (i10 != 17) {
                    return;
                }
                m61581H();
                return;
            }
        }
        m61591n();
        if (message.arg1 != 1) {
            Activity activity2 = this.f48645a;
            if (activity2 != null) {
                Toast.makeText(activity2, R$string.reason_install_failed, 0).show();
            } else {
                C11839m.m70687e("UpdateService", "context is null");
            }
        }
        C10028c.m62182c0().m62231J2("forcedUpdate", 0);
        m61577D();
    }

    /* renamed from: u */
    public final boolean m61597u(Message message) {
        int i10 = message.what;
        if (i10 == 3) {
            m61590m();
            m61577D();
            return true;
        }
        if (i10 == 6) {
            m61590m();
            m61579F();
            return true;
        }
        if (i10 == 9) {
            m61590m();
            m61584K();
            return true;
        }
        if (i10 == 12) {
            Activity activity = this.f48645a;
            if (activity != null) {
                Toast.makeText(activity, R$string.reason_install_failed, 0).show();
                return true;
            }
            C11839m.m70687e("UpdateService", "context is null");
            return true;
        }
        if (i10 != 13) {
            return m61598v(true, message);
        }
        Activity activity2 = this.f48645a;
        if (activity2 != null) {
            Toast.makeText(activity2, R$string.alert_net_disconnect, 0).show();
        }
        m61577D();
        return true;
    }

    /* renamed from: v */
    public final boolean m61598v(boolean z10, Message message) {
        int i10 = message.what;
        if (i10 != 10) {
            if (i10 != 11) {
                return false;
            }
            Activity activity = this.f48645a;
            if (activity != null) {
                Toast.makeText(activity, R$string.update_version_updating, 0).show();
                return z10;
            }
            C11839m.m70687e("UpdateService", "context is null");
            return z10;
        }
        Activity activity2 = this.f48645a;
        if (activity2 != null) {
            Toast.makeText(activity2, R$string.update_space_not_enough, 0).show();
        } else {
            C11839m.m70687e("UpdateService", "context is null");
        }
        if (C10028c.m62182c0().m62380q1()) {
            m61592o();
            return z10;
        }
        m61577D();
        return z10;
    }

    /* renamed from: w */
    public final void m61599w(Object obj) {
        if (obj == null) {
            m61590m();
        } else if (this.f48646b) {
            m61590m();
            m61587N(obj, true);
        } else {
            m61590m();
            m61587N(obj, false);
        }
    }

    /* renamed from: x */
    public void m61600x(Activity activity) {
        this.f48645a = activity;
        C9908c.m61499D().m61523I(activity, this.f48651g);
    }

    /* renamed from: y */
    public final void m61601y(ForceUpgradeConfiguration forceUpgradeConfiguration) {
        if (forceUpgradeConfiguration.getForceUpgrade() == 1) {
            C11839m.m70688i("UpdateService", "force upgrade click keyCode keycode back");
            m61592o();
        }
        if (forceUpgradeConfiguration.getForceUpgrade() != 0 || C10028c.m62182c0().m62283V0()) {
            return;
        }
        C11839m.m70686d("UpdateService", "upgradeConfig dismiss, config not is end service.");
        ForcedUpgradeUtil.getInstance().setUserCancelForcedUpgrade(true);
        Activity activity = this.f48645a;
        if (activity != null) {
            activity.finish();
        }
    }

    /* renamed from: z */
    public final /* synthetic */ boolean m61602z(ForceUpgradeConfiguration forceUpgradeConfiguration, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        m61601y(forceUpgradeConfiguration);
        return false;
    }
}
