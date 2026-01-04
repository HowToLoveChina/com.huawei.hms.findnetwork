package p232dp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.util.Pair;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.router.data.CloudSpaceUsageItemColor;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: dp.b */
/* loaded from: classes.dex */
public interface InterfaceC9283b {
    /* renamed from: A */
    void mo58469A(Handler.Callback callback);

    /* renamed from: B */
    boolean mo58470B();

    /* renamed from: C */
    boolean mo58471C();

    /* renamed from: D */
    void mo58472D(Context context);

    /* renamed from: E */
    void mo58473E();

    /* renamed from: F */
    void mo58474F();

    /* renamed from: G */
    String mo58475G(Throwable th2);

    /* renamed from: H */
    Object mo58476H(boolean z10, boolean z11, boolean z12) throws C9721b;

    /* renamed from: I */
    void mo58477I();

    /* renamed from: J */
    boolean mo58478J(String str);

    /* renamed from: K */
    void mo58479K();

    /* renamed from: L */
    long mo58480L(String str);

    /* renamed from: M */
    Intent mo58481M(Context context);

    /* renamed from: N */
    int mo58482N(Context context);

    /* renamed from: O */
    Intent mo58483O(Context context, String str, SafeIntent safeIntent, String str2);

    /* renamed from: P */
    boolean mo58484P();

    /* renamed from: Q */
    void mo58485Q(Context context, ArrayList<String> arrayList);

    /* renamed from: R */
    void mo58486R(Message message);

    /* renamed from: S */
    String mo58487S(String str);

    /* renamed from: T */
    void mo58488T(Handler handler);

    /* renamed from: U */
    void mo58489U(Context context);

    /* renamed from: V */
    void mo58490V(Context context, int i10, int i11);

    /* renamed from: W */
    void mo58491W(Context context);

    /* renamed from: X */
    boolean mo58492X(Context context, long j10) throws C9721b;

    /* renamed from: Y */
    boolean mo58493Y();

    /* renamed from: Z */
    String mo58494Z(String str);

    /* renamed from: a */
    void mo58495a(String str);

    /* renamed from: a0 */
    void mo58496a0();

    /* renamed from: b */
    void mo58497b(Context context);

    /* renamed from: b0 */
    void mo58498b0(String str, boolean z10);

    /* renamed from: c */
    String mo58499c();

    /* renamed from: c0 */
    SpannableString mo58500c0(SpannableString spannableString, Context context);

    /* renamed from: d */
    Long mo58501d();

    /* renamed from: d0 */
    void mo58502d0(List<UserBackupInfo.UserDeviceInfo> list);

    /* renamed from: e */
    void mo58503e(UserBackupInfo.UserDeviceInfo userDeviceInfo);

    /* renamed from: e0 */
    void mo58504e0();

    /* renamed from: f */
    void mo58505f(Context context, String str);

    /* renamed from: f0 */
    UserBackupInfo mo58506f0(boolean z10, int i10) throws C9721b;

    /* renamed from: g */
    void mo58507g(String str);

    /* renamed from: g0 */
    String mo58508g0();

    /* renamed from: h */
    boolean mo58509h();

    /* renamed from: h0 */
    int mo58510h0();

    /* renamed from: i */
    void mo58511i(Context context);

    /* renamed from: i0 */
    void mo58512i0(Handler.Callback callback);

    /* renamed from: j */
    boolean mo58513j();

    /* renamed from: j0 */
    void mo58514j0(String str, String str2);

    /* renamed from: k */
    void mo58515k(Context context, String str);

    /* renamed from: k0 */
    void mo58516k0(int i10);

    /* renamed from: l */
    Pair<Integer, Integer> mo58517l();

    /* renamed from: l0 */
    void mo58518l0(String str);

    /* renamed from: m */
    void mo58519m(RecommendCardReport recommendCardReport, String str);

    /* renamed from: m0 */
    UserBackupInfo mo58520m0(boolean z10, boolean z11, boolean z12, boolean z13, int i10) throws C9721b;

    /* renamed from: n */
    void mo58521n(String str);

    /* renamed from: n0 */
    void mo58522n0(Context context);

    /* renamed from: o */
    void mo58523o();

    /* renamed from: o0 */
    void mo58524o0(Context context);

    /* renamed from: p */
    boolean mo58525p(File file, File file2);

    /* renamed from: q */
    String mo58526q();

    /* renamed from: r */
    List<CloudSpaceUsageItemColor> mo58527r();

    /* renamed from: s */
    void mo58528s(Handler.Callback callback);

    /* renamed from: t */
    void mo58529t(Context context);

    /* renamed from: u */
    void mo58530u(Context context, String str);

    /* renamed from: v */
    int mo58531v();

    /* renamed from: w */
    boolean mo58532w();

    /* renamed from: x */
    String mo58533x(String str);

    /* renamed from: y */
    FamilySharePageConfig mo58534y(String str);

    /* renamed from: z */
    long mo58535z();
}
