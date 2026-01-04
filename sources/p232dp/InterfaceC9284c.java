package p232dp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: dp.c */
/* loaded from: classes.dex */
public interface InterfaceC9284c {
    /* renamed from: A */
    void mo17079A(Context context, Messenger messenger);

    /* renamed from: A0 */
    String mo17080A0(String str);

    /* renamed from: B */
    void mo17081B(Context context, Handler handler, boolean z10);

    /* renamed from: B0 */
    void mo17082B0(int i10, int i11);

    /* renamed from: C */
    void mo17083C(Context context, String str);

    /* renamed from: C0 */
    boolean mo17084C0(Context context);

    /* renamed from: D */
    int mo17085D(Context context, Messenger messenger);

    /* renamed from: D0 */
    Map<String, Integer> mo17086D0();

    /* renamed from: E */
    void mo17087E(Context context, String str, int i10);

    /* renamed from: E0 */
    void mo17088E0(int i10);

    /* renamed from: F */
    void mo17089F(Context context, String str, int i10);

    /* renamed from: F0 */
    void mo17090F0(Context context, String str);

    /* renamed from: G */
    void mo17091G(String str);

    /* renamed from: G0 */
    void mo17092G0(Context context, String str, int i10, int i11, String str2);

    /* renamed from: H */
    int mo17093H(Context context, Messenger messenger);

    /* renamed from: I */
    void mo17094I(Context context, String str, int i10, int i11, String str2);

    /* renamed from: J */
    void mo17095J();

    /* renamed from: K */
    List<String> mo17096K(Context context);

    /* renamed from: L */
    void mo17097L(String str);

    /* renamed from: M */
    void mo17098M(Context context, String str);

    /* renamed from: N */
    void mo17099N(Context context, String str, int i10, String str2);

    /* renamed from: O */
    void mo17100O(Context context, String str, int i10, int i11, String str2);

    /* renamed from: P */
    void mo17101P(Context context, boolean z10);

    /* renamed from: Q */
    boolean mo17102Q(String str, int i10);

    /* renamed from: R */
    int mo17103R(Context context, String str, String str2);

    /* renamed from: S */
    void mo17104S(Context context, String str);

    /* renamed from: T */
    boolean mo17105T(Context context);

    /* renamed from: U */
    void mo17106U(Context context, String str, String str2);

    /* renamed from: V */
    boolean mo17107V(String str);

    /* renamed from: W */
    void mo17108W(Context context);

    /* renamed from: X */
    void mo17109X(Context context, boolean z10);

    /* renamed from: Y */
    void mo17110Y(Context context);

    /* renamed from: Z */
    void mo17111Z(Context context, String str);

    /* renamed from: a */
    void mo17112a(Context context, String str, boolean z10);

    /* renamed from: a0 */
    void mo17113a0(Context context, int i10, String str);

    /* renamed from: b */
    void mo17114b(Context context, String str, String str2, int i10);

    /* renamed from: b0 */
    int mo17115b0(String str, int i10, String str2);

    /* renamed from: c */
    void mo17116c(String str);

    /* renamed from: c0 */
    int mo17117c0();

    /* renamed from: d */
    void mo17118d(Context context);

    /* renamed from: d0 */
    void mo17119d0(Context context, Messenger messenger);

    void doBackupPhoneManager();

    /* renamed from: e */
    void mo17120e(Context context);

    /* renamed from: e0 */
    boolean mo17121e0();

    /* renamed from: f */
    void mo17122f(Context context, String str, int i10);

    /* renamed from: f0 */
    void mo17123f0(Context context, String str);

    /* renamed from: g */
    void mo17124g(Context context, Handler handler, List<ExiterSyncData> list, String str);

    /* renamed from: g0 */
    boolean mo17125g0(String str);

    /* renamed from: h */
    List<String> mo17126h(Context context);

    /* renamed from: h0 */
    void mo17127h0(Context context, String str, int i10, int i11, String str2);

    /* renamed from: i */
    void mo17128i(Context context);

    /* renamed from: i0 */
    void mo17129i0(int i10, int i11);

    /* renamed from: j */
    void mo17130j(Context context, String str);

    /* renamed from: j0 */
    void mo17131j0(boolean z10, int i10);

    /* renamed from: k */
    void mo17132k(Context context, Bundle bundle);

    /* renamed from: k0 */
    void mo17133k0(Context context, String str);

    /* renamed from: l */
    void mo17134l(Context context, String str, int i10, String str2, String str3, String str4, String str5, LinkedHashMap<String, String> linkedHashMap);

    /* renamed from: l0 */
    void mo17135l0(Context context, Handler handler, String str, String str2, int i10);

    /* renamed from: m */
    void mo17136m(Context context, int i10, String str);

    /* renamed from: m0 */
    void mo17137m0(Context context, String str, String str2);

    /* renamed from: n */
    int mo17138n(Context context, Messenger messenger);

    /* renamed from: n0 */
    void mo17139n0(Context context, String str, boolean z10);

    /* renamed from: o */
    void mo17140o(Context context, Handler handler);

    /* renamed from: o0 */
    void mo17141o0(Context context, String str, int i10, int i11, String str2);

    /* renamed from: p */
    boolean mo17142p(Context context, Messenger messenger);

    /* renamed from: p0 */
    int mo17143p0(Context context, String str);

    /* renamed from: q */
    boolean mo17144q(Context context, CountDownLatch countDownLatch);

    /* renamed from: q0 */
    void mo17145q0(Context context, int i10, String str);

    /* renamed from: r */
    void mo17146r(Context context, String str);

    /* renamed from: r0 */
    List<String> mo17147r0(Context context);

    /* renamed from: s */
    List<String> mo17148s();

    /* renamed from: s0 */
    void mo17149s0();

    /* renamed from: t */
    void mo17150t(Context context, String str);

    /* renamed from: t0 */
    void mo17151t0();

    /* renamed from: u */
    void mo17152u(int i10);

    /* renamed from: u0 */
    void mo17153u0(Context context);

    /* renamed from: v */
    void mo17154v(Context context, int i10, String str);

    /* renamed from: v0 */
    void mo17155v0(Context context);

    /* renamed from: w */
    void mo17156w(String str);

    /* renamed from: w0 */
    void mo17157w0(Context context, String str, int i10, int i11, String str2);

    /* renamed from: x */
    void mo17158x(Context context, String str, int i10, int i11, String str2);

    /* renamed from: x0 */
    void mo17159x0(Context context, int i10, String str);

    /* renamed from: y */
    void mo17160y(Context context);

    /* renamed from: y0 */
    void mo17161y0(Context context, Messenger messenger);

    /* renamed from: z */
    int mo17162z(Context context, Messenger messenger, String str);

    /* renamed from: z0 */
    void mo17163z0(Context context, String str);
}
