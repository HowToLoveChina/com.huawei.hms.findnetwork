package p422k9;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import com.huawei.android.hicloud.commonlib.helper.IHiSyncHelper;
import com.huawei.android.hicloud.commonlib.helper.ISettingsSuggestUtil;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import java.util.ArrayList;
import java.util.HashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p709vj.InterfaceC13449b;
import p783xp.C13843a;

/* renamed from: k9.b */
/* loaded from: classes3.dex */
public class C11019b {

    /* renamed from: d */
    public static final C11019b f52096d = new C11019b();

    /* renamed from: a */
    public HashMap<String, Class> f52097a = new HashMap<>();

    /* renamed from: b */
    public ISettingsSuggestUtil f52098b;

    /* renamed from: c */
    public IHiSyncHelper f52099c;

    /* renamed from: t */
    public static C11019b m66371t() {
        return f52096d;
    }

    /* renamed from: A */
    public boolean m66372A(Context context, String str, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15827D(context, str, z10);
        }
        return false;
    }

    /* renamed from: A0 */
    public void m66373A0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15832I(context);
        }
    }

    /* renamed from: B */
    public void m66374B(Context context) {
        ISettingsSuggestUtil iSettingsSuggestUtil = this.f52098b;
        if (iSettingsSuggestUtil != null) {
            iSettingsSuggestUtil.mo15898a(context);
        }
    }

    /* renamed from: B0 */
    public void m66375B0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15867i0(context);
        }
    }

    /* renamed from: C */
    public void m66376C(Context context) {
        ISettingsSuggestUtil iSettingsSuggestUtil = this.f52098b;
        if (iSettingsSuggestUtil != null) {
            iSettingsSuggestUtil.mo15899b(context);
        }
    }

    /* renamed from: C0 */
    public void m66377C0(String str, Bundle bundle) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15888v(str, bundle);
        }
    }

    /* renamed from: D */
    public boolean m66378D() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.inBackup();
        }
        return false;
    }

    /* renamed from: D0 */
    public void m66379D0(Handler.Callback callback) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15859e0(callback);
        }
    }

    /* renamed from: E */
    public boolean m66380E() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.inRestore();
        }
        return false;
    }

    /* renamed from: E0 */
    public void m66381E0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15878o(context);
        }
    }

    /* renamed from: F */
    public boolean m66382F() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.inRestoreFirst();
        }
        return false;
    }

    /* renamed from: F0 */
    public void m66383F0(ListView listView, BaseAdapter baseAdapter) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15855c0(listView, baseAdapter);
        }
    }

    /* renamed from: G */
    public boolean m66384G() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15857d0();
        }
        return false;
    }

    /* renamed from: G0 */
    public void m66385G0(Context context, Handler handler) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15838O(context, handler);
        }
    }

    /* renamed from: H */
    public void m66386H(Context context, Bundle bundle) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15834K(context, bundle);
        }
    }

    /* renamed from: H0 */
    public void m66387H0(Context context, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15854c(context, z10);
        }
    }

    /* renamed from: I */
    public void m66388I(Context context, String str, Switch r32, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15848Y(context, str, r32, z10);
        }
    }

    /* renamed from: I0 */
    public void m66389I0() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.writeUISwitchToFile();
        }
    }

    /* renamed from: J */
    public void m66390J(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15833J(context);
        }
    }

    /* renamed from: K */
    public boolean m66391K(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15884r(context);
        }
        return false;
    }

    /* renamed from: L */
    public boolean m66392L(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15890x(i10);
        }
        return false;
    }

    /* renamed from: M */
    public boolean m66393M(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15880p(i10);
        }
        return false;
    }

    /* renamed from: N */
    public boolean m66394N(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15842S(i10);
        }
        return false;
    }

    /* renamed from: O */
    public boolean m66395O(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15839P(i10);
        }
        return false;
    }

    /* renamed from: P */
    public boolean m66396P(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15844U(i10);
        }
        return false;
    }

    /* renamed from: Q */
    public boolean m66397Q(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15864h(context);
        }
        return false;
    }

    /* renamed from: R */
    public boolean m66398R() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.isSendPhoneFinderOning();
        }
        return false;
    }

    /* renamed from: S */
    public boolean m66399S() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.isShowGalleryItemView();
        }
        return false;
    }

    /* renamed from: T */
    public boolean m66400T() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.isSupportAntiTheft();
        }
        return false;
    }

    /* renamed from: U */
    public boolean m66401U(String str) {
        Context contextM1377a;
        if (TextUtils.isEmpty(str) || (contextM1377a = C0213f.m1377a()) == null) {
            return false;
        }
        String strM83054F = str.equals("funcfg_gallery") ? C13843a.m83054F(contextM1377a) : str.equals("funcfg_contacts") ? C13843a.m83094p(contextM1377a) : str.equals("funcfg_calendar") ? C13843a.m83093o(contextM1377a) : str.equals("funcfg_notes") ? C13843a.m83050B(contextM1377a) : "";
        if (!TextUtils.isEmpty(strM83054F)) {
            return C0209d.m1184K0(contextM1377a, strM83054F);
        }
        C11839m.m70687e("HisyncProxy", "isSupportSyncByAppInstalled packageName is empty");
        return false;
    }

    /* renamed from: V */
    public boolean m66402V(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15870k(context);
        }
        return false;
    }

    /* renamed from: W */
    public ClickableSpan m66403W(Context context, int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15876n(context, i10);
        }
        return null;
    }

    /* renamed from: X */
    public LinkMovementMethod m66404X() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15887u();
        }
        return null;
    }

    /* renamed from: Y */
    public ClickableSpan m66405Y(Context context, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15889w(context, str);
        }
        return null;
    }

    /* renamed from: Z */
    public BaseAdapter m66406Z(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15851a0(context);
        }
        return null;
    }

    /* renamed from: a */
    public void m66407a() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15875m0();
        }
    }

    /* renamed from: a0 */
    public CommonDialogInterface m66408a0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15879o0(context);
        }
        return null;
    }

    /* renamed from: b */
    public void m66409b(Bundle bundle, InterfaceC13449b interfaceC13449b) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15847X(bundle, interfaceC13449b);
        }
    }

    /* renamed from: b0 */
    public CommonDialogInterface m66410b0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15872l(context);
        }
        return null;
    }

    /* renamed from: c */
    public void m66411c(Context context, Bundle bundle) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15883q0(context, bundle);
        }
    }

    /* renamed from: c0 */
    public CommonDialogInterface m66412c0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15845V(context);
        }
        return null;
    }

    /* renamed from: d */
    public AlertDialog m66413d(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnKeyListener onKeyListener) {
        C11839m.m70688i("HisyncProxy", "buildBackupDeleteDialog");
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15824A(context, onClickListener, onClickListener2, onKeyListener);
        }
        return null;
    }

    /* renamed from: d0 */
    public LinkMovementMethod m66414d0() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15863g0();
        }
        return null;
    }

    /* renamed from: e */
    public void m66415e() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15826C();
        }
    }

    /* renamed from: e0 */
    public void m66416e0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15831H(context);
        }
    }

    /* renamed from: f */
    public boolean m66417f(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15861f0(context);
        }
        return false;
    }

    /* renamed from: f0 */
    public void m66418f0(Context context, String str, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15850a(context, str, z10);
        }
    }

    /* renamed from: g */
    public void m66419g(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15846W(context);
        }
    }

    /* renamed from: g0 */
    public void m66420g0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15862g(context);
        }
    }

    /* renamed from: h */
    public void m66421h(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15849Z(context);
        }
    }

    /* renamed from: h0 */
    public void m66422h0() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.openPhoneFinderInBack();
        }
    }

    /* renamed from: i */
    public void m66423i(String str, String str2, String str3, int i10, String str4, int i11, boolean z10, boolean z11, boolean z12) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15871k0(str, str2, str3, i10, str4, i11, z10, z11, z12);
        }
    }

    /* renamed from: i0 */
    public void m66424i0(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15837N(context, z10, z11, z12, z13);
        }
    }

    /* renamed from: j */
    public void m66425j(boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.cloudbackupOpr(z10);
        }
    }

    /* renamed from: j0 */
    public void m66426j0(Activity activity, AbstractC11020c abstractC11020c) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15828E(activity, abstractC11020c);
        }
    }

    /* renamed from: k */
    public void m66427k(Context context, String str, String str2) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15858e(context, str, str2);
        }
    }

    /* renamed from: k0 */
    public void m66428k0(Handler.Callback callback) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15866i(callback);
        }
    }

    /* renamed from: l */
    public void m66429l(Context context, int i10, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15881p0(context, i10, str);
        }
    }

    /* renamed from: l0 */
    public void m66430l0(String str, Class cls) {
        this.f52097a.put(str, cls);
    }

    /* renamed from: m */
    public void m66431m() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15860f();
        }
    }

    /* renamed from: m0 */
    public void m66432m0(IHiSyncHelper iHiSyncHelper) {
        this.f52099c = iHiSyncHelper;
    }

    /* renamed from: n */
    public void m66433n(Context context, Intent intent) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15877n0(context, intent);
        }
    }

    /* renamed from: n0 */
    public void m66434n0(ISettingsSuggestUtil iSettingsSuggestUtil) {
        this.f52098b = iSettingsSuggestUtil;
    }

    /* renamed from: o */
    public void m66435o(Context context, Handler handler, int i10, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15829F(context, handler, i10, z10);
        }
    }

    /* renamed from: o0 */
    public void m66436o0(Context context, String str, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15865h0(context, str, z10);
        }
    }

    /* renamed from: p */
    public Integer m66437p(int i10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15874m(i10);
        }
        return null;
    }

    /* renamed from: p0 */
    public void m66438p0(Context context, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15852b(context, str);
        }
    }

    /* renamed from: q */
    public String m66439q() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15885s();
        }
        return null;
    }

    /* renamed from: q0 */
    public void m66440q0(Boolean bool, Context context, Activity activity) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15868j(bool, activity);
        }
    }

    /* renamed from: r */
    public Class m66441r(String str) {
        return this.f52097a.get(str);
    }

    /* renamed from: r0 */
    public void m66442r0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15836M(context);
        }
    }

    /* renamed from: s */
    public Long m66443s() {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15856d();
        }
        return null;
    }

    /* renamed from: s0 */
    public void m66444s0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15830G(context);
        }
    }

    /* renamed from: t0 */
    public void m66445t0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15892z(context);
        }
    }

    /* renamed from: u */
    public String m66446u(Context context, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        return iHiSyncHelper != null ? iHiSyncHelper.mo15869j0(context, str) : "";
    }

    /* renamed from: u0 */
    public void m66447u0(boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.setMrGuide(z10);
        }
    }

    /* renamed from: v */
    public boolean m66448v(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15843T(context);
        }
        return false;
    }

    /* renamed from: v0 */
    public void m66449v0(Context context, boolean z10) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15840Q(context, z10);
        }
    }

    /* renamed from: w */
    public String m66450w(Context context, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15891y(context, str);
        }
        return null;
    }

    /* renamed from: w0 */
    public void m66451w0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15825B(context);
        }
    }

    /* renamed from: x */
    public String m66452x(Context context, String str) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            return iHiSyncHelper.mo15882q(context, str);
        }
        return null;
    }

    /* renamed from: x0 */
    public void m66453x0(AlertDialog alertDialog) {
        C11839m.m70688i("HisyncProxy", "showBackupDeleteDialog");
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15841R(alertDialog);
        }
    }

    /* renamed from: y */
    public ArrayList<DriveConfigService> m66454y(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        return iHiSyncHelper != null ? iHiSyncHelper.mo15886t(context) : new ArrayList<>();
    }

    /* renamed from: y0 */
    public void m66455y0(Context context, Activity activity) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15873l0(context, activity);
        }
    }

    /* renamed from: z */
    public ArrayList<SyncConfigService> m66456z(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        return iHiSyncHelper != null ? iHiSyncHelper.mo15853b0(context) : new ArrayList<>();
    }

    /* renamed from: z0 */
    public void m66457z0(Context context) {
        IHiSyncHelper iHiSyncHelper = this.f52099c;
        if (iHiSyncHelper != null) {
            iHiSyncHelper.mo15835L(context);
        }
    }
}
