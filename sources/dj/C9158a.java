package dj;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.hicloud.logic.threadpool.TaskHandle;
import com.huawei.cloud.pay.model.CampaignInfo;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.NotifyReq;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.cloud.pay.model.VoucherInfo;
import com.huawei.cloud.pay.model.VouchersTaskInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import p341hj.C10210a;
import p341hj.C10211a0;
import p341hj.C10213b;
import p341hj.C10214b0;
import p341hj.C10217c0;
import p341hj.C10220d0;
import p341hj.C10223e0;
import p341hj.C10224e1;
import p341hj.C10225f;
import p341hj.C10227f1;
import p341hj.C10230g1;
import p341hj.C10231h;
import p341hj.C10233h1;
import p341hj.C10234i;
import p341hj.C10236i1;
import p341hj.C10237j;
import p341hj.C10238j0;
import p341hj.C10239j1;
import p341hj.C10242k1;
import p341hj.C10243l;
import p341hj.C10245l1;
import p341hj.C10246m;
import p341hj.C10248m1;
import p341hj.C10250n0;
import p341hj.C10251n1;
import p341hj.C10253o0;
import p341hj.C10254o1;
import p341hj.C10255p;
import p341hj.C10256p0;
import p341hj.C10258q;
import p341hj.C10260r;
import p341hj.C10261r0;
import p341hj.C10262s;
import p341hj.C10263s0;
import p341hj.C10264t;
import p341hj.C10265t0;
import p341hj.C10266u;
import p341hj.C10267u0;
import p341hj.C10269v0;
import p341hj.C10272x;
import p341hj.C10273x0;
import p341hj.C10274y;
import p341hj.C10275y0;
import p341hj.C10276z;
import p429kk.C11060c;
import p616rk.C12515a;

/* renamed from: dj.a */
/* loaded from: classes5.dex */
public final class C9158a {

    /* renamed from: a */
    public static C9158a f45945a = new C9158a();

    /* renamed from: F */
    public static synchronized C9158a m57503F() {
        return f45945a;
    }

    /* renamed from: A */
    public void m57504A(Handler handler, C11060c c11060c) {
        new C10224e1(handler, c11060c).m63381g();
    }

    /* renamed from: B */
    public void m57505B(Handler handler, C11060c c11060c, boolean z10) {
        new C10274y(handler, c11060c, z10).m63381g();
    }

    /* renamed from: C */
    public void m57506C(Handler handler, boolean z10) {
        new C10276z(handler, z10).m63381g();
    }

    /* renamed from: D */
    public void m57507D(Handler handler) {
        new C10211a0(handler).m63381g();
    }

    /* renamed from: E */
    public void m57508E(Handler handler, String str) {
        new C10214b0(handler, str).m63381g();
    }

    /* renamed from: G */
    public void m57509G(Handler handler, NotifyReq notifyReq, C11060c c11060c) {
        new C10217c0(handler, notifyReq, c11060c, true).m63381g();
    }

    /* renamed from: H */
    public void m57510H(Handler handler, NotifyReq notifyReq, C11060c c11060c, boolean z10) {
        new C10217c0(handler, notifyReq, c11060c, z10).m63381g();
    }

    /* renamed from: I */
    public void m57511I(Handler handler, C11060c c11060c, boolean z10) {
        new C10238j0(handler, c11060c, z10).m63381g();
    }

    /* renamed from: J */
    public void m57512J(Handler handler, C11060c c11060c, int i10, long j10, int i11, int i12, String str, ChannelInfo channelInfo, boolean z10) {
        C10220d0 c10220d0 = new C10220d0(handler, c11060c, i10, j10, i11, i12, str, channelInfo);
        c10220d0.m63369h(z10);
        c10220d0.m63381g();
    }

    /* renamed from: K */
    public void m57513K(Handler handler, C11060c c11060c, int i10, long j10, int i11, ChannelInfo channelInfo, boolean z10) {
        C10220d0 c10220d0 = new C10220d0(handler, c11060c, i10, j10, i11, channelInfo);
        c10220d0.m63369h(z10);
        c10220d0.m63381g();
    }

    /* renamed from: L */
    public void m57514L(Handler handler, List<Integer> list, int i10) {
        C12515a.m75110o().m75175e(new C10223e0(handler, list, i10), false);
    }

    /* renamed from: M */
    public void m57515M(Handler handler, int i10, C11060c c11060c, boolean z10, boolean z11, String str) {
        new C10250n0(handler, i10, c11060c, z10, z11, str).m63381g();
    }

    /* renamed from: N */
    public void m57516N(Handler handler, C11060c c11060c, boolean z10, String str) {
        new C10250n0(handler, c11060c, z10, str).m63381g();
    }

    /* renamed from: O */
    public void m57517O(Handler handler, C11060c c11060c, boolean z10, boolean z11, String str) {
        new C10250n0(handler, c11060c, z10, z11, str).m63381g();
    }

    /* renamed from: P */
    public void m57518P(Handler handler, C11060c c11060c) {
        new C10253o0(c11060c, handler).m63381g();
    }

    /* renamed from: Q */
    public void m57519Q(Handler handler, String str, C11060c c11060c) {
        new C10267u0(handler, str, c11060c).m63381g();
    }

    /* renamed from: R */
    public void m57520R(Handler handler, VouchersTaskInfo vouchersTaskInfo, CountDownLatch countDownLatch) {
        new C10269v0(handler, vouchersTaskInfo, countDownLatch).m63381g();
    }

    /* renamed from: S */
    public void m57521S(Handler handler, String str, C11060c c11060c) {
        new C10273x0(handler, str, c11060c).m63381g();
    }

    /* renamed from: T */
    public void m57522T(Handler handler, String str, String str2) {
        new C10275y0(handler, str, str2).m63381g();
    }

    /* renamed from: U */
    public void m57523U(Handler handler, C11060c c11060c) {
        new C10227f1(handler, c11060c).m63381g();
    }

    /* renamed from: V */
    public void m57524V(Handler handler) {
        new C10230g1(handler).m63381g();
    }

    /* renamed from: W */
    public TaskHandle m57525W(Handler handler, C11060c c11060c) {
        return new C10261r0(handler, c11060c).m63381g();
    }

    /* renamed from: X */
    public TaskHandle m57526X(Handler handler, C11060c c11060c, int i10, String str) {
        return new C10261r0(handler, c11060c, i10, str).m63381g();
    }

    /* renamed from: Y */
    public void m57527Y(Handler handler) {
        new C10233h1(handler).m63381g();
    }

    /* renamed from: Z */
    public void m57528Z(Handler handler) {
        new C10236i1(handler).m63381g();
    }

    /* renamed from: a */
    public void m57529a(Handler handler, Map<String, String> map, String str, int i10) {
        C12515a.m75110o().m75172d(new C10210a(handler, map, str, i10));
    }

    /* renamed from: a0 */
    public void m57530a0(Handler handler, C11060c c11060c, String str, int i10, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        new C10239j1(handler, c11060c, str, i10, channelInfo, map, bigDecimal).m63381g();
    }

    /* renamed from: b */
    public TaskHandle m57531b(Handler handler, C11060c c11060c, CampaignInfo campaignInfo) {
        return new C10213b(c11060c, handler, campaignInfo).m63381g();
    }

    /* renamed from: b0 */
    public void m57532b0(Handler handler, C11060c c11060c, String str, int i10, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        new C10239j1(handler, c11060c, str, i10, list, channelInfo, map, bigDecimal).m63381g();
    }

    /* renamed from: c */
    public void m57533c(Handler handler, int i10) {
        new C10225f(handler, i10).m63381g();
    }

    /* renamed from: c0 */
    public void m57534c0(Handler handler, C11060c c11060c, String str, Context context) {
        new C10242k1(handler, c11060c, str, context).m63381g();
    }

    /* renamed from: d */
    public void m57535d(Handler handler, C11060c c11060c) {
        new C10265t0(handler, c11060c).m63381g();
    }

    /* renamed from: d0 */
    public void m57536d0(Handler handler) {
        new C10245l1(handler).m63381g();
    }

    /* renamed from: e */
    public void m57537e(Handler handler, C11060c c11060c, boolean z10) {
        new C10265t0(handler, c11060c, z10).m63381g();
    }

    /* renamed from: e0 */
    public void m57538e0(Handler handler, Map<String, String> map) {
        C12515a.m75110o().m75175e(new C10248m1(handler, map), false);
    }

    /* renamed from: f */
    public void m57539f(String str, Handler handler) {
        C12515a.m75110o().m75175e(new C10256p0(str, handler), false);
    }

    /* renamed from: f0 */
    public void m57540f0(Handler handler, Map<String, String> map, String str) {
        C12515a.m75110o().m75175e(new C10251n1(handler, map, str), false);
    }

    /* renamed from: g */
    public void m57541g(Handler handler, String str, String str2, C11060c c11060c) {
        new C10231h(handler, str, str2, c11060c).m63381g();
    }

    /* renamed from: g0 */
    public TaskHandle m57542g0(Handler handler, C11060c c11060c, String str, ChannelInfo channelInfo, Map<String, String> map, List<VoucherInfo> list, String str2, int i10, BigDecimal bigDecimal) {
        return new C10254o1(handler, c11060c, str, channelInfo, map, list, str2, i10, bigDecimal).m63381g();
    }

    /* renamed from: h */
    public void m57543h(Handler handler, String str, String str2, C11060c c11060c, long j10, int i10) {
        new C10231h(handler, str, str2, c11060c, j10, i10).m63381g();
    }

    /* renamed from: i */
    public void m57544i(Handler handler, C11060c c11060c, String str, Context context, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        new C10234i(handler, c11060c, str, context, channelInfo, map, bigDecimal).m63381g();
    }

    /* renamed from: j */
    public void m57545j(Handler handler, String str, C11060c c11060c, Map<String, String> map) {
        new C10263s0(handler, str, c11060c, map).m63381g();
    }

    /* renamed from: k */
    public void m57546k(Handler handler, String str, C11060c c11060c, int i10, String str2, int i11, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map) {
        new C10237j(handler, str, c11060c, i10, str2, i11, list, channelInfo, map).m63381g();
    }

    /* renamed from: l */
    public void m57547l(Handler handler, String str, C11060c c11060c, int i10, String str2, ChannelInfo channelInfo, Map<String, String> map) {
        new C10237j(handler, str, c11060c, i10, str2, channelInfo, map).m63381g();
    }

    /* renamed from: m */
    public void m57548m(Handler handler, String str, int i10, C11060c c11060c, BigDecimal bigDecimal) {
        new C10243l(handler, str, i10, c11060c, bigDecimal).m63381g();
    }

    /* renamed from: n */
    public void m57549n(Handler handler, String str, int i10, C11060c c11060c, BigDecimal bigDecimal, Integer num, String str2) {
        new C10243l(handler, str, i10, c11060c, bigDecimal, num, str2).m63381g();
    }

    /* renamed from: o */
    public void m57550o(Handler handler, C11060c c11060c, boolean z10, Map<String, String> map) {
        new C10243l(handler, c11060c, z10, map).m63381g();
    }

    /* renamed from: p */
    public TaskHandle m57551p(Handler handler, String str, ChannelInfo channelInfo, long j10, int i10) {
        return new C10246m(handler, str, channelInfo, j10, i10).m63381g();
    }

    /* renamed from: q */
    public void m57552q(Handler handler, UserTags userTags, int i10) {
        C12515a.m75110o().m75175e(new C10255p(handler, userTags, i10), false);
    }

    /* renamed from: r */
    public void m57553r(Handler handler, String str, String str2, String str3) {
        new C10258q(handler, str, str2, str3).m63381g();
    }

    /* renamed from: s */
    public void m57554s(Handler handler, VouchersTaskInfo vouchersTaskInfo) {
        new C10260r(handler, vouchersTaskInfo).m63381g();
    }

    /* renamed from: t */
    public void m57555t(Handler handler, List<String> list) {
        new C10262s(handler, list, new ArrayList()).m63381g();
    }

    /* renamed from: u */
    public void m57556u(Handler handler, List<String> list) {
        new C10264t(handler, list, new ArrayList()).m63381g();
    }

    /* renamed from: v */
    public void m57557v(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10) {
        new C10266u(handler, filter, str, channelInfo, z10).m63381g();
    }

    /* renamed from: w */
    public void m57558w(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10, boolean z11) {
        new C10266u(handler, filter, str, channelInfo, z10, z11).m63381g();
    }

    /* renamed from: x */
    public void m57559x(Handler handler, Filter filter, String str, ChannelInfo channelInfo, boolean z10, boolean z11, long j10) {
        new C10266u(handler, filter, str, channelInfo, z10, z11, j10).m63381g();
    }

    /* renamed from: y */
    public void m57560y(Handler handler, Filter filter, String str, boolean z10, ChannelInfo channelInfo, boolean z11, long j10) {
        new C10266u(handler, filter, str, z10, channelInfo, z11, j10).m63381g();
    }

    /* renamed from: z */
    public void m57561z(Context context, Handler handler, String str, C11060c c11060c) {
        new C10272x(handler, context, str, c11060c).m63381g();
    }
}
