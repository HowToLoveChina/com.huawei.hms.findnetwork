package p281f8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.C2414a;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.hicloud.drive.cloudphoto.model.PushMessage;
import com.huawei.android.p069cg.request.threadpool.AbstractC2328i;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p523oi.C11903a;
import p568q6.C12289b;
import p604r7.C12473f;
import p709vj.C13452e;
import p731w7.C13535b;

/* renamed from: f8.h */
/* loaded from: classes2.dex */
public class C9671h {

    /* renamed from: a */
    public static long f47852a;

    /* renamed from: f8.h$a */
    public class a extends AbstractC2328i {

        /* renamed from: a */
        public final /* synthetic */ String f47853a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, String str) {
            super(obj);
            this.f47853a = str;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2328i, com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
        public Object call() throws Exception {
            Thread.sleep(5000L);
            C9665b.m60348e(2, 7, this.f47853a);
            return null;
        }
    }

    /* renamed from: f8.h$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f47854a;

        public b(String str) {
            this.f47854a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C9665b.m60348e(2, 7, this.f47854a);
        }
    }

    /* renamed from: d */
    public static /* synthetic */ void m60374d() {
        C12473f.m74865c().m74869f(3);
    }

    /* renamed from: f */
    public static /* synthetic */ void m60376f() {
        C12473f.m74865c().m74869f(3);
    }

    /* renamed from: g */
    public static void m60377g(Context context, String str) {
        boolean zM7170h = C1136q.e.m7170h(context);
        if ("1".equals(str)) {
            zM7170h = true;
        } else if ("2".equals(str)) {
            zM7170h = false;
        }
        C1136q.e.m7178p(Boolean.valueOf(zM7170h), context);
        C1120a.m6677i("PushProcessor", "NEVER DEAL! atlas switch change, status:" + str + ", allow:" + zM7170h);
    }

    /* renamed from: h */
    public static void m60378h(Context context, JSONArray jSONArray, String str, String str2) {
        if (jSONArray == null || jSONArray.length() < 1) {
            return;
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String strOptString = jSONArray.optString(i10);
            if ("2".equals(strOptString)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - f47852a < 15000) {
                    C1120a.m6678w("PushProcessor", "push msg Flow control");
                    return;
                } else {
                    f47852a = jCurrentTimeMillis;
                    z11 = true;
                }
            } else if ("1".equals(strOptString)) {
                z12 = true;
            } else if ("0".equals(strOptString)) {
                z10 = true;
            }
        }
        if (z10) {
            C9665b.m60347d(0, 7);
            OpsReport.m15262m(context, "cloud_async_share", str);
        }
        if (z11) {
            C13535b.m81436a().m81438c(new b(str2), 15000L);
            OpsReport.m15262m(context, "cloud_async_general", str);
        }
        if (z12) {
            C9665b.m60347d(1, 7);
            OpsReport.m15262m(context, "cloud_async_atlas", str);
        }
        if (z10 || z11) {
            C13535b.m81436a().m81438c(new Runnable() { // from class: f8.e
                @Override // java.lang.Runnable
                public final void run() {
                    C9671h.m60374d();
                }
            }, 30000L);
        }
    }

    /* renamed from: i */
    public static void m60379i(Context context, String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("PushProcessor", "pushData is empty!");
            return;
        }
        C1120a.m6675d("PushProcessor", "processOnMessage:" + str);
        String strM15255f = OpsReport.m15255f();
        C1120a.m6677i("PushProcessor", "begin deal with push message");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            C1120a.m6676e("PushProcessor", "push message convert to json error");
            jSONObject = null;
        }
        if (jSONObject == null) {
            C1120a.m6676e("PushProcessor", "jsonObj is null!");
            return;
        }
        String strOptString = jSONObject.optString(JsbMapKeyNames.H5_USER_ID, null);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        int iOptInt = jSONObject.optInt(CommonNotifyReceiver.COMMAND_KEY, 0);
        String strOptString2 = jSONObject.optString("prepareTraceId", "");
        if (!TextUtils.isEmpty(jSONObject.optString("x-hw-trace-id"))) {
            strM15255f = jSONObject.optString("x-hw-trace-id");
        }
        if (strM80971t0 == null || strOptString == null || !strM80971t0.equals(strOptString)) {
            C1120a.m6676e("PushProcessor", "receive push userId not equal local userId!");
            return;
        }
        if (101 == iOptInt) {
            m60378h(context, jSONObject.optJSONArray(FaqConstants.FAQ_MODULE), strM15255f, strOptString2);
            return;
        }
        if (102 == iOptInt) {
            m60377g(context, jSONObject.optString("status", "0"));
            OpsReport.m15262m(context, "cloud_async_atlas", strM15255f);
            return;
        }
        if (103 == iOptInt) {
            OpsReport.m15262m(context, "cloud_clear_version", strM15255f);
            if (Version.isSupportClearCloudVersion()) {
                Bundle bundle = new Bundle();
                bundle.putInt("Code", 142);
                C2414a.m15051l().sendMessage(9091, bundle);
                C1136q.b.m7067i1(context, "");
                C1122c.m6825r(context, strM15255f);
                C2333n.m14663f().m14673l(new a(null, strOptString2), true);
            }
        }
    }

    /* renamed from: j */
    public static void m60380j(Context context, String str) {
        JSONObject jSONObject;
        C1120a.m6675d("PushProcessor", "processOnMessageV2:" + str);
        final String strOptString = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                PushMessage pushMessage = (PushMessage) C11903a.m71435l().mo69832e(str).m69886u(PushMessage.class);
                if ("315".equals(pushMessage.getCommand())) {
                    PushMessage.ApplicantInfo applicantInfo = (PushMessage.ApplicantInfo) C11903a.m71435l().mo69832e(pushMessage.getBody()).m69886u(PushMessage.ApplicantInfo.class);
                    if (applicantInfo.getType() == 1) {
                        C12289b.m73837b().m73840d(applicantInfo);
                        return;
                    }
                    return;
                }
                C1120a.m6677i("PushProcessor", "begin deal with push message");
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                    C1120a.m6676e("PushProcessor", "push message convert to json error");
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    C1120a.m6676e("PushProcessor", "jsonObj is null!");
                    return;
                } else {
                    try {
                        strOptString = new JSONObject(new JSONObject(jSONObject.optString("body", "")).optString(ParamConstants.Param.CONTEXT, "")).optString("prepareTraceId", "");
                    } catch (Exception unused2) {
                        C1120a.m6676e("PushProcessor", "get prepareTraceId json exception.");
                    }
                }
            } catch (IOException e10) {
                C1120a.m6676e("PushProcessor", "processOnMessageV2 exception:" + e10.toString());
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = f47852a;
        if (j10 != 0 && jCurrentTimeMillis - j10 < 15000) {
            C1120a.m6678w("PushProcessor", "processOnMessageV2 Flow control");
            return;
        }
        f47852a = jCurrentTimeMillis;
        String strM15255f = OpsReport.m15255f();
        C9665b.m60347d(0, 7);
        OpsReport.m15262m(context, "cloud_async_share", strM15255f);
        C13535b.m81436a().m81438c(new Runnable() { // from class: f8.f
            @Override // java.lang.Runnable
            public final void run() {
                C9665b.m60348e(2, 7, strOptString);
            }
        }, 15000L);
        OpsReport.m15262m(context, "cloud_async_general", strM15255f);
        C13535b.m81436a().m81438c(new Runnable() { // from class: f8.g
            @Override // java.lang.Runnable
            public final void run() {
                C9671h.m60376f();
            }
        }, 30000L);
    }
}
