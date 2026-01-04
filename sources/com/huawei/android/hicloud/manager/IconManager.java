package com.huawei.android.hicloud.manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p336he.C10157h;
import p514o9.C11839m;
import p514o9.C11841o;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p676ud.C13164k;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class IconManager {

    /* renamed from: g */
    public static final Uri f12256g;

    /* renamed from: h */
    public static final Uri f12257h;

    /* renamed from: i */
    public static final String f12258i;

    /* renamed from: j */
    public static final String f12259j;

    /* renamed from: k */
    public static final Uri f12260k;

    /* renamed from: l */
    public static final boolean f12261l;

    /* renamed from: a */
    public final Context f12262a;

    /* renamed from: b */
    public C13164k f12263b;

    /* renamed from: c */
    public View f12264c;

    /* renamed from: d */
    public AlertDialog f12265d;

    /* renamed from: e */
    public final String f12266e;

    /* renamed from: f */
    public boolean f12267f;

    public interface CallBack {
        /* renamed from: a */
        void mo16466a();
    }

    public interface IconCallBack {
        /* renamed from: a */
        void mo16467a(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.manager.IconManager$a */
    public class C2809a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ IconCallBack f12268a;

        public C2809a(IconCallBack iconCallBack) {
            this.f12268a = iconCallBack;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            IconCallBack iconCallBack = this.f12268a;
            IconManager iconManager = IconManager.this;
            iconCallBack.mo16467a(iconManager.m16462v(iconManager.f12262a, "com.huawei.hidisk"));
        }
    }

    static {
        Uri uri = Uri.parse("content://com.huawei.android.launcher.removable_icon");
        f12256g = uri;
        f12257h = Uri.parse("content://com.hihonor.android.launcher.settings/favorites?notify=true");
        f12258i = C0209d.m1269j1() ? "com.honor.android.launcher" : "com.huawei.android.launcher";
        f12259j = C0209d.m1269j1() ? "com.hihonor.filemanager" : NextRestoreConstants.PKG_NAME_FILE_MANAGER;
        f12260k = uri;
        f12261l = m16433z();
    }

    public IconManager(Context context) {
        this.f12262a = context;
        this.f12266e = C0209d.m1269j1() ? "honor_icon" : "icon";
    }

    /* renamed from: z */
    public static boolean m16433z() {
        C11839m.m70688i("IconManager", "enter isSupport");
        try {
            boolean z10 = C0213f.m1377a().getPackageManager().getApplicationInfo(f12258i, 128).metaData.getBoolean("support_appicon_removable");
            C11839m.m70686d("IconManager", "isSupport: " + z10);
            return z10;
        } catch (Exception unused) {
            C11839m.m70687e("IconManager", "isSupport: getApplicationInfo failed");
            return false;
        }
    }

    /* renamed from: A */
    public boolean m16434A(String str) {
        C11839m.m70688i("IconManager", "enter isTimePermit, key: " + str);
        if (System.currentTimeMillis() - m16458r(str) >= Constants.TWO_WEEK) {
            return true;
        }
        C11839m.m70689w("IconManager", "the interval is too short.");
        return false;
    }

    /* renamed from: B */
    public final /* synthetic */ void m16435B(DialogInterface dialogInterface, int i10) {
        m16452l("mecloud_cloud_space_add_icon_dialog_show", "add_icon_dialog_add_click");
        m16444L(this.f12262a.getPackageName());
    }

    /* renamed from: C */
    public final /* synthetic */ void m16436C(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
        m16452l("mecloud_cloud_space_add_icon_dialog_show", "add_icon_dialog_cancel_click");
        if (m16464x("cloudSpaceNoReminder")) {
            return;
        }
        m16451S();
        m16448P("cloudSpaceNoReminder");
    }

    /* renamed from: D */
    public final /* synthetic */ void m16437D(DialogInterface dialogInterface) {
        m16447O("cloudLasttime");
        m16449Q(true);
    }

    /* renamed from: E */
    public final /* synthetic */ void m16438E(CheckBox checkBox, Class cls, DialogInterface dialogInterface, int i10) {
        C11839m.m70688i("IconManager", "getHonorIconDialog " + checkBox.isChecked());
        m16452l("mecloud_cloud_space_add_icon_dialog_show", "add_icon_dialog_add_click");
        new C10157h().m63312a(this.f12262a, cls);
        if (checkBox.isChecked()) {
            m16448P("cloudSpaceNoReminder");
        }
    }

    /* renamed from: F */
    public final /* synthetic */ void m16439F(CheckBox checkBox, DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
        m16452l("mecloud_cloud_space_add_icon_dialog_show", "add_icon_dialog_cancel_click");
        this.f12265d.dismiss();
        if (m16460t()) {
            m16451S();
            m16446N();
        }
        if (checkBox.isChecked()) {
            m16448P("cloudSpaceNoReminder");
        }
    }

    /* renamed from: G */
    public final /* synthetic */ void m16440G(CheckBox checkBox, DialogInterface dialogInterface) {
        ViewParent parent = checkBox.getParent();
        if (parent != null) {
            ((ViewGroup) parent).setPadding(24, 0, 24, 0);
            m16449Q(true);
        }
    }

    /* renamed from: H */
    public final /* synthetic */ void m16441H(DialogInterface dialogInterface, int i10) {
        m16452l("mecloud_filemanager_add_icon_dialog_show", "add_icon_dialog_add_click");
        m16444L(f12259j);
    }

    /* renamed from: I */
    public final /* synthetic */ void m16442I(DialogInterface dialogInterface, int i10) {
        m16452l("mecloud_filemanager_add_icon_dialog_show", "add_icon_dialog_cancel_click");
    }

    /* renamed from: J */
    public final /* synthetic */ void m16443J(DialogInterface dialogInterface) {
        m16447O("filemanagerLastTime");
    }

    /* renamed from: L */
    public void m16444L(String str) {
        C11839m.m70688i("IconManager", "enter recoverAppIcon, packageName: " + str);
        if (!f12261l) {
            C11839m.m70689w("IconManager", "launcher not support");
            return;
        }
        if (this.f12262a == null) {
            C11839m.m70689w("IconManager", "context = null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package", str);
        Bundle bundleM16453m = m16453m("recoverAppIcon", bundle);
        if (bundleM16453m == null) {
            C11839m.m70689w("IconManager", "responsebundle is null");
        } else if (bundleM16453m.getInt(FamilyShareConstants.OpenCloudShareResultInfo.RESULT_CODE_KEY, 0) != 0) {
            C11839m.m70689w("IconManager", "add icon failed, current package name is not in the removeable list");
        } else {
            Context context = this.f12262a;
            C11841o.m70708d(context, context.getString(R$string.set_icon_success), 0);
        }
    }

    /* renamed from: M */
    public void m16445M() {
        C11839m.m70688i("IconManager", "enter refreshTipView");
        C13164k c13164k = this.f12263b;
        if (c13164k == null || !c13164k.m79161l()) {
            return;
        }
        C11839m.m70686d("IconManager", "tipView on display");
        this.f12263b.m79155f();
        m16451S();
    }

    /* renamed from: N */
    public void m16446N() {
        C0212e0.m1365o(this.f12262a, this.f12266e, "isFirstTips", false);
    }

    /* renamed from: O */
    public void m16447O(String str) {
        C0212e0.m1370t(this.f12262a, "icon", str, System.currentTimeMillis());
    }

    /* renamed from: P */
    public final void m16448P(String str) {
        C0212e0.m1365o(this.f12262a, this.f12266e, str, true);
    }

    /* renamed from: Q */
    public void m16449Q(boolean z10) {
        this.f12267f = z10;
    }

    /* renamed from: R */
    public void m16450R(final CallBack callBack) {
        C11839m.m70688i("IconManager", "enter getAddFileManagerIconDialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f12262a).setView(LayoutInflater.from(this.f12262a).inflate(R$layout.dialog_coustom_title, (ViewGroup) null)).setPositiveButton(this.f12262a.getString(R$string.add_icon_dialog_add_button), new DialogInterface.OnClickListener() { // from class: qb.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f57047a.m16441H(dialogInterface, i10);
            }
        }).setNegativeButton(this.f12262a.getString(R$string.add_icon_dialog_cancel), new DialogInterface.OnClickListener() { // from class: qb.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f57048a.m16442I(dialogInterface, i10);
            }
        }).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: qb.m
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f57050a.m16443J(dialogInterface);
            }
        });
        alertDialogCreate.show();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: qb.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                callBack.mo16466a();
            }
        });
    }

    /* renamed from: S */
    public void m16451S() throws Resources.NotFoundException {
        C11839m.m70688i("IconManager", "enter showTipPopupWindow");
        Context context = this.f12262a;
        if (context instanceof Activity) {
            C13164k c13164k = new C13164k((Activity) context);
            this.f12263b = c13164k;
            c13164k.m79169t(this.f12264c, this.f12262a.getString(R$string.add_icon_tip), 0, -this.f12262a.getResources().getDimensionPixelOffset(R$dimen.hiad_12_dp));
        }
    }

    /* renamed from: l */
    public final void m16452l(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("dialog_click", str2);
        C13227f.m79492i1().m79591l0(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
    }

    /* renamed from: m */
    public final Bundle m16453m(String str, Bundle bundle) {
        C11839m.m70688i("IconManager", "enter callProviderByMethod");
        if (!C0209d.m1184K0(this.f12262a, f12258i)) {
            C11839m.m70689w("IconManager", "app not install");
            return null;
        }
        Context context = this.f12262a;
        Uri uri = f12260k;
        if (C0209d.m1227Y1(context, uri)) {
            return C0209d.m1243d(this.f12262a, uri, str, null, bundle);
        }
        C11839m.m70689w("IconManager", "error occur because inspection found uri do not source from system app");
        return null;
    }

    /* renamed from: n */
    public void m16454n() {
        C11839m.m70688i("IconManager", "dismissTipView");
        C13164k c13164k = this.f12263b;
        if (c13164k == null || !c13164k.m79161l()) {
            return;
        }
        C11839m.m70686d("IconManager", "tipView on display");
        this.f12263b.m79155f();
    }

    /* renamed from: o */
    public AlertDialog m16455o(View view) {
        C11839m.m70688i("IconManager", "enter getAddIconDialog");
        this.f12264c = view;
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f12262a).setTitle(this.f12262a.getString(R$string.add_icon_dialog_title)).setMessage(this.f12262a.getString(R$string.add_icon_dialog_message_new)).setPositiveButton(this.f12262a.getString(R$string.add_icon_dialog_add_button), new DialogInterface.OnClickListener() { // from class: qb.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f57052a.m16435B(dialogInterface, i10);
            }
        }).setNegativeButton(this.f12262a.getString(R$string.add_icon_dialog_cancel), new DialogInterface.OnClickListener() { // from class: qb.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
                this.f57053a.m16436C(dialogInterface, i10);
            }
        }).create();
        this.f12265d = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.f12265d.setOnShowListener(new DialogInterface.OnShowListener() { // from class: qb.q
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f57054a.m16437D(dialogInterface);
            }
        });
        return this.f12265d;
    }

    /* renamed from: p */
    public String m16456p() {
        return f12259j;
    }

    /* renamed from: q */
    public AlertDialog m16457q(View view, final Class cls) {
        C11839m.m70688i("IconManager", "enter getAddIconDialog");
        this.f12264c = view;
        final CheckBox checkBox = new CheckBox(this.f12262a);
        checkBox.setText(this.f12262a.getString(R$string.add_icon_dialog_no_reminder));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f12262a).setTitle(this.f12262a.getString(R$string.add_icon_dialog_title)).setMessage(this.f12262a.getString(R$string.add_icon_dialog_message_new)).setView(checkBox).setPositiveButton(this.f12262a.getString(R$string.add_icon_dialog_add_button), new DialogInterface.OnClickListener() { // from class: qb.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f57055a.m16438E(checkBox, cls, dialogInterface, i10);
            }
        }).setNegativeButton(this.f12262a.getString(R$string.add_icon_dialog_cancel), new DialogInterface.OnClickListener() { // from class: qb.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws Resources.NotFoundException {
                this.f57058a.m16439F(checkBox, dialogInterface, i10);
            }
        }).create();
        this.f12265d = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.f12265d.setOnShowListener(new DialogInterface.OnShowListener() { // from class: qb.t
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f57060a.m16440G(checkBox, dialogInterface);
            }
        });
        return this.f12265d;
    }

    /* renamed from: r */
    public long m16458r(String str) {
        return C0212e0.m1359i(this.f12262a, "icon", str, 0L);
    }

    /* renamed from: s */
    public boolean m16459s() {
        AlertDialog alertDialog = this.f12265d;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* renamed from: t */
    public boolean m16460t() {
        return C0212e0.m1354d(this.f12262a, this.f12266e, "isFirstTips", true);
    }

    /* renamed from: u */
    public void m16461u(IconCallBack iconCallBack) {
        if (this.f12262a == null) {
            C11839m.m70687e("IconManager", "context is null");
            return;
        }
        if (C0209d.m1166E1()) {
            if (C0209d.m1305s1()) {
                C12515a.m75110o().m75172d(new C2809a(iconCallBack));
                return;
            }
            C11839m.m70688i("IconManager", "isHonorIconExist SDK_INT" + Build.VERSION.SDK_INT);
        }
    }

    /* renamed from: v */
    public boolean m16462v(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(f12257h, null, "title=?", new String[]{packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString()}, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return true;
                    }
                }
                if (cursorQuery == null) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                C11839m.m70687e("IconManager", "getAppIcon NameNotFoundException " + e10);
                if (cursorQuery == null) {
                    return false;
                }
            } catch (Exception e11) {
                C11839m.m70687e("IconManager", "getAppIcon Exception " + e11);
                if (cursorQuery == null) {
                    return false;
                }
            }
            cursorQuery.close();
            return false;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: w */
    public boolean m16463w(String str) {
        C11839m.m70688i("IconManager", "enter isIconExist, packageName: " + str);
        if (!f12261l) {
            C11839m.m70689w("IconManager", "launcher not support");
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package", str);
        Bundle bundleM16453m = m16453m("queryAppIconState", bundle);
        if (bundleM16453m == null) {
            C11839m.m70689w("IconManager", "responseBundle is null");
            return true;
        }
        boolean z10 = bundleM16453m.getBoolean("icon_state", true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isIconExist: ");
        sb2.append(!z10);
        C11839m.m70686d("IconManager", sb2.toString());
        return !z10;
    }

    /* renamed from: x */
    public boolean m16464x(String str) {
        boolean zM1354d = C0212e0.m1354d(this.f12262a, this.f12266e, str, false);
        C11839m.m70688i("IconManager", "isNoReminder: " + zM1354d);
        return zM1354d;
    }

    /* renamed from: y */
    public boolean m16465y() {
        return this.f12267f;
    }
}
