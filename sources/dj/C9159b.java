package dj;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.user.request.UsersInfoRequest;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import io.C10582a;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import p012ab.C0086a;
import p015ak.C0209d;
import p283fa.C9679b;
import p514o9.C11839m;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;

/* renamed from: dj.b */
/* loaded from: classes5.dex */
public class C9159b {

    /* renamed from: a */
    public static boolean f45946a = false;

    /* renamed from: b */
    public static boolean f45947b = false;

    /* renamed from: a */
    public static void m57562a(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("InActiveUserHelper", "bind email activity is null");
        }
        C13195l.m79273Z(activity, "1");
        m57572k("click_goto_bind_email");
    }

    /* renamed from: b */
    public static boolean m57563b(HashMap<String, String> map) {
        return map != null && map.containsKey("validToTime") && map.containsKey("lastUpdateTime");
    }

    /* renamed from: c */
    public static String m57564c(long j10) {
        DateFormat dateInstance = DateFormat.getDateInstance(1, Resources.getSystem().getConfiguration().getLocales().get(0));
        Date date = new Date();
        date.setTime(j10);
        String str = dateInstance.format(date);
        return !TextUtils.isEmpty(str) ? C0209d.m1270j2("zh-TW") ? str.replaceAll("(\\d{1,4})(\\D)", " $1 $2").trim() : C0209d.m1278l2("jv") ? SafeString.replace(str, ",", "") : str : str;
    }

    /* renamed from: d */
    public static HashMap<String, String> m57565d() {
        C11839m.m70688i("InActiveUserHelper", "getInactiveData");
        return m57566e(m57567f());
    }

    /* renamed from: e */
    public static HashMap<String, String> m57566e(GetUserRegisterResp getUserRegisterResp) {
        if (getUserRegisterResp != null && getUserRegisterResp.isInActive().booleanValue()) {
            HashMap<String, String> resultMap = getUserRegisterResp.getResultMap();
            if (m57563b(resultMap)) {
                return resultMap;
            }
        }
        C11839m.m70688i("InActiveUserHelper", "getInactiveData return null");
        return null;
    }

    /* renamed from: f */
    public static GetUserRegisterResp m57567f() {
        C11839m.m70688i("InActiveUserHelper", "getInactiveData");
        try {
            return new C10582a(null).m64942k();
        } catch (C9721b e10) {
            C11839m.m70687e("InActiveUserHelper", "get active status error:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static boolean m57568g() {
        return f45946a;
    }

    /* renamed from: h */
    public static Boolean m57569h() {
        C0086a c0086aM60455e = C9679b.m60452d().m60455e();
        if (c0086aM60455e == null) {
            C11839m.m70687e("InActiveUserHelper", "get bind email error, userClient is null ");
            return null;
        }
        try {
            UsersInfoRequest usersInfoRequest = new UsersInfoRequest();
            usersInfoRequest.set("fields", (Object) CommonConstant.KEY_ACCOUNT_FLAG);
            User userExecute = c0086aM60455e.m676c().userInfo(usersInfoRequest).execute();
            if (userExecute != null) {
                return Boolean.valueOf(userExecute.alreadyBoundEmail());
            }
        } catch (IOException e10) {
            C11839m.m70687e("InActiveUserHelper", "get bind email error" + e10.getMessage());
        }
        return null;
    }

    /* renamed from: i */
    public static boolean m57570i() {
        return f45947b;
    }

    /* renamed from: j */
    public static void m57571j(Intent intent) {
        if (intent == null) {
            C11839m.m70687e("InActiveUserHelper", "putAlreadyEnteredInactivePage intent is null");
            return;
        }
        C11839m.m70688i("InActiveUserHelper", "put alreadyEnteredInactivePage" + f45946a);
        intent.putExtra("alreadyEnteredInactivePage", f45946a);
    }

    /* renamed from: k */
    public static void m57572k(String str) {
        C13227f.m79492i1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("CKC", str, "1", "100");
    }

    /* renamed from: l */
    public static void m57573l(int i10, boolean z10, int i11, Handler handler, HashMap<String, String> map) {
        if (z10) {
            C11839m.m70688i("InActiveUserHelper", "query config task is abort");
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.arg1 = i11;
        messageObtainMessage.arg2 = 4098;
        messageObtainMessage.obj = map;
        C11839m.m70688i("InActiveUserHelper", "sendMessageWithInactiveData");
        handler.sendMessage(messageObtainMessage);
    }

    /* renamed from: m */
    public static void m57574m(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        if (safeIntent.hasExtra("needEnterInactivePage") && safeIntent.getBooleanExtra("needEnterInactivePage", false)) {
            C11839m.m70687e("InActiveUserHelper", "setAlreadyEntered false from intent");
            m57575n(false);
            m57576o(true);
        }
    }

    /* renamed from: n */
    public static void m57575n(boolean z10) {
        f45946a = z10;
    }

    /* renamed from: o */
    public static void m57576o(boolean z10) {
        f45947b = z10;
    }
}
