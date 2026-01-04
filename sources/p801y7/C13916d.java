package p801y7;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.callable.CallableBuilder;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import hk.C10278a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p009a8.C0074l;
import p009a8.C0076n;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p312g8.C9894e;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11820b;
import p511o6.C11821c;
import p511o6.C11823e;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: y7.d */
/* loaded from: classes2.dex */
public class C13916d {

    /* renamed from: f */
    public static String f62288f;

    /* renamed from: a */
    public Context f62289a;

    /* renamed from: b */
    public CallbackHandler f62290b;

    /* renamed from: c */
    public String f62291c;

    /* renamed from: d */
    public String f62292d;

    /* renamed from: e */
    public boolean f62293e = true;

    /* renamed from: y7.d$a */
    public class a extends AbstractC2324e {

        /* renamed from: a */
        public final /* synthetic */ CallbackHandler f62294a;

        /* renamed from: b */
        public final /* synthetic */ int f62295b;

        /* renamed from: c */
        public final /* synthetic */ boolean f62296c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, CallbackHandler callbackHandler, int i10, boolean z10) {
            super(obj);
            this.f62294a = callbackHandler;
            this.f62295b = i10;
            this.f62296c = z10;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) {
            if (obj == null || !(obj instanceof FileInfo)) {
                return;
            }
            C13916d.m83390C(this.f62294a, (FileInfo) obj, this.f62295b, this.f62296c);
        }
    }

    /* renamed from: y7.d$b */
    public class b extends AbstractC2324e {

        /* renamed from: a */
        public final /* synthetic */ FileInfo f62297a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, FileInfo fileInfo) {
            super(obj);
            this.f62297a = fileInfo;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) {
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : ((obj instanceof HashMap) && "11".equals(((HashMap) obj).get("code"))) ? 115 : 101;
            C13916d.this.m83417l(this.f62297a);
            C1120a.m6677i("SDKUploadPhoto", "HandleCallable upload, ret: " + iIntValue + ", fileName: " + C1122c.m6818p0(this.f62297a.getFileName()));
            if (iIntValue == 1009 || iIntValue == 508) {
                C1136q.b.m7041a(C13916d.this.f62289a);
                C13916d.this.m83419s(this.f62297a, iIntValue);
                return;
            }
            C1136q.b.m7044b(C13916d.this.f62289a);
            if (iIntValue == 0) {
                C13916d.this.m83412E(this.f62297a);
                C13916d c13916d = C13916d.this;
                c13916d.m83418r(Boolean.valueOf(c13916d.f62293e), C13916d.this.f62292d);
            } else if (iIntValue == 122) {
                C13916d.this.m83423x(iIntValue, this.f62297a);
            } else {
                if (iIntValue == 30) {
                    C13916d.this.m83422w(iIntValue, this.f62297a);
                    return;
                }
                C13916d.this.m83411B(this.f62297a, iIntValue);
                C13916d c13916d2 = C13916d.this;
                c13916d2.m83418r(Boolean.valueOf(c13916d2.f62293e), C13916d.this.f62292d);
            }
        }
    }

    public C13916d(Context context, CallbackHandler callbackHandler, String str, String str2) {
        this.f62289a = context;
        this.f62290b = callbackHandler;
        this.f62291c = str;
        this.f62292d = str2;
    }

    /* renamed from: A */
    public static void m83389A(Context context, FileInfo fileInfo, String str) {
        C1120a.m6677i("SDKUploadPhoto", "notifyUploadError fileUpType:" + str);
    }

    /* renamed from: C */
    public static void m83390C(CallbackHandler callbackHandler, FileInfo fileInfo, int i10, boolean z10) {
        m83391D(callbackHandler, fileInfo, i10, z10, null);
    }

    /* renamed from: D */
    public static void m83391D(CallbackHandler callbackHandler, FileInfo fileInfo, int i10, boolean z10, String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("sessionId", str);
        }
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putParcelable("HttpResult", new HttpResult(200, i10, null));
        callbackHandler.sendMessage(z10 ? 9158 : 9148, bundle);
    }

    /* renamed from: H */
    public static void m83392H(List<FileInfo> list) {
        Collections.sort(list, C11820b.m70396a());
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80900d = C13452e.m80781L().m80900d();
        for (FileInfo fileInfo : list) {
            fileInfo.setCreaterId(strM80971t0);
            fileInfo.setCreaterAccount(strM80900d);
            fileInfo.setSource(Build.MODEL);
        }
    }

    /* renamed from: m */
    public static void m83403m(Context context, String str, CallbackHandler callbackHandler, int i10) {
        C1120a.m6677i("SDKUploadPhoto", "cancelCustomerUploadTask, errCode: " + i10);
        C11821c.m70419i(str, i10, m83408u(context, callbackHandler, i10, false));
    }

    /* renamed from: n */
    public static void m83404n(Context context, CallbackHandler callbackHandler, int i10) {
        C1120a.m6677i("SDKUploadPhoto", "cancelGeneralUploadTask, errCode: " + i10);
        C11821c.m70419i("0", i10, m83408u(context, callbackHandler, i10, false));
    }

    /* renamed from: o */
    public static void m83405o(Context context, CallbackHandler callbackHandler, int i10) {
        C1120a.m6677i("SDKUploadPhoto", "cancelShareUploadTask, errCode: " + i10);
        C11823e.m70443a(context, m83408u(context, callbackHandler, i10, true));
    }

    /* renamed from: p */
    public static void m83406p(Context context, CallbackHandler callbackHandler, int i10, boolean z10) {
        if (z10) {
            m83405o(context, callbackHandler, i10);
        } else {
            m83404n(context, callbackHandler, i10);
        }
    }

    /* renamed from: q */
    public static void m83407q(Context context, CallbackHandler callbackHandler, int i10) {
        m83405o(context, callbackHandler, i10);
        m83404n(context, callbackHandler, i10);
    }

    /* renamed from: u */
    public static AbstractC2324e m83408u(Context context, CallbackHandler callbackHandler, int i10, boolean z10) {
        if (callbackHandler != null) {
            return new a(context, callbackHandler, i10, z10);
        }
        return null;
    }

    /* renamed from: y */
    public static boolean m83409y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(f62288f);
    }

    /* renamed from: z */
    public static synchronized void m83410z(String str) {
        if (!TextUtils.isEmpty(str)) {
            f62288f = str;
        }
    }

    /* renamed from: B */
    public final void m83411B(FileInfo fileInfo, int i10) {
        m83390C(this.f62290b, fileInfo, i10, this.f62293e);
    }

    /* renamed from: E */
    public final void m83412E(FileInfo fileInfo) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", this.f62292d);
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putParcelable("HttpResult", new HttpResult(200, 0, null));
        this.f62290b.sendMessage(this.f62293e ? 9058 : 9048, bundle);
    }

    /* renamed from: F */
    public final void m83413F() {
        this.f62290b.sendMessage(9096, new Bundle());
    }

    /* renamed from: G */
    public final void m83414G() {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", this.f62292d);
        if (this.f62293e) {
            this.f62290b.sendMessage(9039, bundle);
        } else {
            this.f62290b.sendMessage(9034, bundle);
        }
    }

    /* renamed from: I */
    public final void m83415I(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e) {
        if (this.f62293e) {
            C2332m.m14608s().m14630W(abstractCallableC2320a, abstractC2324e, false);
        } else {
            C2333n.m14663f().m14672k(abstractCallableC2320a, abstractC2324e, false);
        }
    }

    /* renamed from: k */
    public final void m83416k(FileInfo fileInfo) {
        m83415I(m83421v(fileInfo), new b("", fileInfo));
    }

    /* renamed from: l */
    public final void m83417l(FileInfo fileInfo) {
        if (this.f62293e) {
            String strM6847y = C1122c.m6847y(fileInfo);
            Integer numM605b = C0074l.m603c().m605b(strM6847y);
            C0074l.m603c().m610h(strM6847y, Integer.valueOf(numM605b != null ? 1 + numM605b.intValue() : 1));
        } else {
            String strM6838v = C1122c.m6838v(fileInfo);
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6838v, 4);
            SyncSessionManager.m15153t().m15166M(strM6838v, Integer.valueOf(numM15193q != null ? 1 + numM15193q.intValue() : 1), 4);
        }
    }

    /* renamed from: r */
    public void m83418r(Boolean bool, String str) {
        C13916d c13916d;
        Bundle bundle;
        Map<String, Long> map;
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", str);
        if (bool.booleanValue()) {
            if (C2332m.m14608s().m14611D().isEmpty() && C2332m.m14608s().m14610C().isEmpty()) {
                this.f62290b.sendMessage(9039, bundle2);
                return;
            }
            return;
        }
        if (C2333n.m14663f().m14668g().isEmpty() && C2333n.m14663f().m14669h().isEmpty()) {
            Map<String, Long> mapM15190n = SyncSessionManager.m15153t().m15190n();
            try {
                long jLongValue = mapM15190n.get("uploadBatchSize").longValue();
                long jLongValue2 = mapM15190n.get("uploadStartTime").longValue();
                long jLongValue3 = mapM15190n.get("uploadEndTime").longValue();
                long j10 = jLongValue3 - jLongValue2;
                bundle = bundle2;
                map = mapM15190n;
                try {
                    long j11 = jLongValue / j10;
                    try {
                        C1120a.m6677i("SDKUploadPhoto", "upload rate, traceId:" + str + ",uploadStartTime:" + jLongValue2 + ",uploadEndTime:" + jLongValue3 + ",uploadBatchSize:" + jLongValue + ",batchUploadRate:" + j11);
                        HashMap map2 = new HashMap();
                        map2.put("traceId", str);
                        map2.put("uploadStartTime", String.valueOf(jLongValue2));
                        map2.put("uploadEndTime", String.valueOf(jLongValue3));
                        map2.put("uploadBatchSize", String.valueOf(jLongValue));
                        map2.put("batchUploadRate", String.valueOf(j11));
                        C11060c c11060cM66626a = C11058a.m66626a(str, "batchUpload", C13452e.m80781L().m80971t0());
                        c11060cM66626a.m66665u("0:1");
                        c11060cM66626a.m66641G(String.valueOf(jLongValue));
                        c11060cM66626a.m66642H(String.valueOf(j10));
                        c11060cM66626a.m66635A("uploadStartTime: " + String.valueOf(jLongValue2) + ", uploadEndTime: " + String.valueOf(jLongValue3));
                        if (j11 > 0) {
                            c13916d = this;
                            try {
                                C13622a.m81969o(c13916d.f62289a, c11060cM66626a, map2);
                            } catch (Exception e10) {
                                e = e10;
                                map.clear();
                                C1120a.m6676e("SDKUploadPhoto", "this upload batch fail,traceId:" + str + ",errMsg:" + e.getMessage());
                                c13916d.f62290b.sendMessage(9034, bundle);
                            }
                        } else {
                            c13916d = this;
                        }
                        map.clear();
                    } catch (Exception e11) {
                        e = e11;
                        c13916d = this;
                    }
                } catch (Exception e12) {
                    e = e12;
                    c13916d = this;
                }
            } catch (Exception e13) {
                e = e13;
                c13916d = this;
                bundle = bundle2;
                map = mapM15190n;
            }
            c13916d.f62290b.sendMessage(9034, bundle);
        }
    }

    /* renamed from: s */
    public final void m83419s(FileInfo fileInfo, int i10) {
        int iM7065i = C1136q.b.m7065i(this.f62289a);
        C1120a.m6677i("SDKUploadPhoto", "HandleCallable upload, ret: " + i10 + " uploadFailCount:" + iM7065i);
        if (iM7065i < 10) {
            m83411B(fileInfo, i10);
            m83418r(Boolean.valueOf(this.f62293e), this.f62292d);
            return;
        }
        C1136q.b.m7044b(this.f62289a);
        m83407q(this.f62289a, this.f62290b, 30);
        m83411B(fileInfo, i10);
        this.f62290b.sendMessage(9091, new Bundle());
    }

    /* renamed from: t */
    public void m83420t(List<FileInfo> list) {
        C1120a.m6677i("SDKUploadPhoto", "execUpload, upload file size: " + list.size());
        this.f62290b.sendMessage(9046, new Bundle());
        for (FileInfo fileInfo : list) {
            if (!C11821c.m70433w(fileInfo)) {
                fileInfo.setFileUploadType("0");
                m83416k(fileInfo);
            }
        }
    }

    /* renamed from: v */
    public final AbstractCallableC2320a m83421v(FileInfo fileInfo) {
        return this.f62293e ? CallableBuilder.getInstance().buildShareUploadCallable(this.f62289a, fileInfo, this.f62292d, this.f62290b) : CallableBuilder.getInstance().buildUploadCallable(this.f62289a, fileInfo, this.f62291c, this.f62292d, this.f62290b);
    }

    /* renamed from: w */
    public final void m83422w(int i10, FileInfo fileInfo) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String userID = fileInfo.getUserID();
        if (userID == null || !userID.equals(strM80971t0)) {
            m83411B(fileInfo, i10);
            m83418r(Boolean.valueOf(this.f62293e), this.f62292d);
        } else {
            m83407q(this.f62289a, this.f62290b, 30);
            m83411B(fileInfo, i10);
            m83414G();
        }
    }

    /* renamed from: x */
    public final void m83423x(int i10, FileInfo fileInfo) {
        long jM7089q = C1136q.b.m7089q(this.f62289a, "userCapacityUsed");
        long jM7089q2 = C1136q.b.m7089q(this.f62289a, "userCapacityTotal");
        File fileM63442h = C10278a.m63442h(fileInfo.getLocalRealPath());
        if (this.f62293e) {
            String createrId = fileInfo.getCreaterId();
            String userID = fileInfo.getUserID();
            if (!TextUtils.isEmpty(createrId) && !TextUtils.isEmpty(userID) && createrId.equals(userID)) {
                C0076n.m619a().m627i(fileM63442h.length() + jM7089q);
            }
        } else {
            SyncSessionManager.m15153t().m15173T(true);
            C0076n.m619a().m627i(fileM63442h.length() + jM7089q);
        }
        if (jM7089q == 0 || jM7089q2 == 0 || jM7089q2 - jM7089q >= 5242880) {
            m83411B(fileInfo, i10);
            m83413F();
            m83418r(Boolean.valueOf(this.f62293e), this.f62292d);
        } else {
            m83406p(this.f62289a, this.f62290b, 122, this.f62293e);
            m83411B(fileInfo, i10);
            m83413F();
            m83414G();
        }
    }

    public C13916d(Context context, CallbackHandler callbackHandler, String str) {
        this.f62289a = context;
        this.f62290b = callbackHandler;
        this.f62292d = str;
    }
}
