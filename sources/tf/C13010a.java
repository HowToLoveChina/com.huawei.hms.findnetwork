package tf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.facard.model.ShareLocationCardInfo;
import com.huawei.android.remotecontrol.p093ui.PhoneFinderActivity;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneForSlaveActivity;
import com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.function.Consumer;
import p232dp.InterfaceC9287f;
import p256ef.C9462c;
import p256ef.C9465f;
import p366if.C10487l;
import p520of.C11860j;
import p520of.C11866p;
import p520of.C11867q;
import p521og.C11875h;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p709vj.C13452e;
import p739wg.C13605a;
import p774xg.C13811a;
import p809yg.C13981a;
import p841ze.C14288b;
import pg.AbstractC12139d;
import sg.C12797b;
import ug.C13171a;

/* renamed from: tf.a */
/* loaded from: classes4.dex */
public class C13010a implements InterfaceC9287f {
    @Override // p232dp.InterfaceC9287f
    /* renamed from: A */
    public boolean mo58538A(Context context) {
        return C11860j.m71031Y();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: B */
    public Class mo58539B() {
        return PhoneFinderActivity.class;
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: C */
    public void mo58540C(Activity activity, String str, String str2, int i10) {
        Intent intent = new Intent(activity, (Class<?>) PhoneFinderActivity.class);
        intent.putExtra(RemoteMessageConst.FROM, str);
        intent.putExtra("switch_name", str2);
        activity.startActivityForResult(intent, i10);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: D */
    public void mo58541D(String str, Context context, Bundle bundle) {
        C11860j.m71020S0(str, context, bundle);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: E */
    public void mo58542E(Context context) {
        C11875h.m71193d(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: F */
    public void mo58543F(Context context) {
        C13981a.m83989i("PhoneFinderRouterImpl", "updatePublicKey");
        C11860j.m71058h1(1, null);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: G */
    public void mo58544G(Context context, int i10) {
        C11860j.m71043c1(context, i10);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: H */
    public void mo58545H(Consumer<Location> consumer, Context context) {
        C13811a.m82802T(consumer, context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: I */
    public int mo58546I(Context context) {
        return C11877j.m71315x(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: J */
    public void mo58547J(Context context, Intent intent) {
        C12347f.m74285n().m74311y(context, intent);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: K */
    public boolean mo58548K(Context context) {
        if (context == null) {
            return false;
        }
        return C1175a.m7390l(context, C13452e.m80781L().m80971t0());
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: L */
    public long mo58549L() {
        return C9465f.m59265A().m59285B();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: M */
    public boolean mo58550M(Context context) {
        if (context == null) {
            return false;
        }
        return C11877j.m71267g0(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: N */
    public boolean mo58551N(Context context) {
        return (context instanceof WapFindPhoneActivity) || (context instanceof WapFindPhoneForSlaveActivity);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: O */
    public boolean mo58552O(String str) {
        return C11860j.m71017R(str);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: P */
    public void mo58553P(Bundle bundle) {
        C11881n.m71350M(bundle);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: Q */
    public Location mo58554Q(Location location) {
        return C10487l.m64545l(location);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: R */
    public String mo58555R(Context context) {
        return C11877j.m71252b0(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: S */
    public void mo58556S() {
        C11860j.m71049e1();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: T */
    public void mo58557T(Context context) {
        if (C1175a.m7395q(context, C13452e.m80781L().m80971t0())) {
            C13981a.m83990w("PhoneFinderRouterImpl", "uid not match, not need close phone finder");
            return;
        }
        C11860j.m71037a1(1);
        C11860j.m71030X0(1);
        C11860j.m71014P0(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: a */
    public void mo58558a() {
        C11860j.m71040b1();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: b */
    public void mo58559b(Context context, String str) {
        new C12797b().m76784j(context, "MrGuideRouterActivity", "0", str, null, C12797b.m76774a("01017"), "success", "01017", true);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: c */
    public void mo58560c(Context context, boolean z10) {
        C11877j.m71243X0(context, Boolean.valueOf(z10));
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: d */
    public boolean mo58561d(Location location) {
        return C10487l.m64539f(location);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: e */
    public boolean mo58562e() {
        return C11860j.m71029X();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: f */
    public boolean mo58563f(String str) {
        return PhoneFinderFeatureProvider.m26449i(str);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: g */
    public void mo58564g(Context context, int i10) {
        C11860j.m71037a1(1);
        C11860j.m71030X0(500);
        C11860j.m71051f0(context, i10, false);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: h */
    public void mo58565h(Context context, String str) {
        if (C1175a.m7385g(false) && mo58574q(context) && !AbstractC12139d.m72768g(context)) {
            C13981a.m83990w("PhoneFinderRouterImpl", "accountInfo not exist");
            C1175a.m7398t(false, context);
            C12347f.m74285n().m74300l(context);
        } else {
            if (C1175a.m7395q(context, C13452e.m80781L().m80971t0())) {
                C13981a.m83990w("PhoneFinderRouterImpl", "uid not match, not need close phone finder");
                return;
            }
            C11860j.m71037a1(1);
            C11860j.m71030X0(1);
            C11860j.m71018R0(context, true, str);
        }
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: i */
    public boolean mo58566i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return C13605a.m81797e(context, str);
    }

    @Override // p232dp.InterfaceC9287f
    public boolean isSupportAntiTheft() {
        return C13171a.m79199e();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: j */
    public void mo58567j(Handler handler) {
        C11860j.m70998H0(handler);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: k */
    public boolean mo58568k(Context context) {
        if (context == null) {
            return false;
        }
        return C11877j.m71202D(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: l */
    public boolean mo58569l() {
        return C11860j.m71027W();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: m */
    public void mo58570m(Context context, boolean z10) {
        C11877j.m71274i1(context, Boolean.valueOf(z10));
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: n */
    public String mo58571n(Context context) {
        return AbstractC12139d.m72766e(context).getUserID4RC();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: o */
    public String mo58572o(Context context) {
        return AbstractC12139d.m72766e(context).getAccountType();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: p */
    public boolean mo58573p(long j10) {
        return C9465f.m59265A().m59287D(j10);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: q */
    public boolean mo58574q(Context context) {
        if (context == null) {
            return false;
        }
        return C1175a.m7389k(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: r */
    public void mo58575r(long j10) {
        C9462c.m59254g().m59262i(j10);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: s */
    public void mo58576s(String str) {
        C11860j.m71034Z0(str);
    }

    @Override // p232dp.InterfaceC9287f
    public void setMrGuide(boolean z10) {
        C12347f.m74285n().m74293G(z10);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: t */
    public boolean mo58577t(String str, String str2) {
        return C11866p.m71107f(str, str2, 4);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: u */
    public String mo58578u(long j10) {
        ShareLocationCardInfo shareLocationCardInfoM59258d = C9462c.m59254g().m59258d(j10);
        if (shareLocationCardInfoM59258d == null) {
            return null;
        }
        return shareLocationCardInfoM59258d.getUserName();
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: v */
    public void mo58579v(Context context) {
        C14288b.m85117p0(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: w */
    public boolean mo58580w(Context context, String str) {
        if (context == null) {
            return false;
        }
        return C1175a.m7395q(context, str);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: x */
    public void mo58581x(Context context) {
        C11877j.m71307t1(context);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: y */
    public void mo58582y(Activity activity, Consumer<Location> consumer) {
        C11867q.m71126d().m71127e(activity, consumer);
    }

    @Override // p232dp.InterfaceC9287f
    /* renamed from: z */
    public void mo58583z(long j10, boolean z10) {
        C9465f.m59265A().m59306Y(j10, z10);
    }
}
