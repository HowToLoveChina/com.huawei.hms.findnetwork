package p802y8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import aq.C1011a;
import com.google.gson.Gson;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudWish;
import com.huawei.cloud.pay.model.CloudWishError;
import com.huawei.cloud.pay.model.GetCloudWishResp;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0223k;
import p454lj.C11296s;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;
import ro.C12612a;
import tm.C13040c;

/* renamed from: y8.b */
/* loaded from: classes2.dex */
public class C13918b {

    /* renamed from: a */
    public final e f62299a;

    /* renamed from: y8.b$a */
    public class a extends AbstractC13919c {

        /* renamed from: a */
        public final /* synthetic */ int f62300a;

        /* renamed from: b */
        public final /* synthetic */ String f62301b;

        /* renamed from: c */
        public final /* synthetic */ Handler f62302c;

        public a(int i10, String str, Handler handler) {
            this.f62300a = i10;
            this.f62301b = str;
            this.f62302c = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C13918b c13918b = C13918b.this;
                C13918b.this.m83454y(this.f62302c, C13918b.this.m83451v(c13918b.m83445o(c13918b.m83444n(this.f62300a, this.f62301b)), new C13920d("/feedback/v1/client/wish", "GET", "")));
            } catch (C9721b e10) {
                C11839m.m70687e("WishListManager", "requestWishList CException: " + e10.getMessage());
                Handler handler = this.f62302c;
                if (handler != null) {
                    Message.obtain(handler, 104, "").sendToTarget();
                }
            }
        }
    }

    /* renamed from: y8.b$b */
    public class b extends AbstractC13919c {

        /* renamed from: a */
        public final /* synthetic */ String f62304a;

        /* renamed from: b */
        public final /* synthetic */ Handler f62305b;

        public b(String str, Handler handler) {
            this.f62304a = str;
            this.f62305b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C13918b.this.m83452w(this.f62305b, C13918b.this.m83451v(C13918b.this.m83445o(""), new C13920d("/feedback/v1/client/wish", "POST", this.f62304a)));
            } catch (C9721b e10) {
                C11839m.m70687e("WishListManager", "requestAddWish CException: " + e10.getMessage());
                Handler handler = this.f62305b;
                if (handler != null) {
                    Message.obtain(handler, 108, "").sendToTarget();
                }
            }
        }
    }

    /* renamed from: y8.b$c */
    public class c extends AbstractC13919c {

        /* renamed from: a */
        public final /* synthetic */ String f62307a;

        /* renamed from: b */
        public final /* synthetic */ Handler f62308b;

        public c(String str, Handler handler) {
            this.f62307a = str;
            this.f62308b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                C13918b.this.m83453x(this.f62308b, C13918b.this.m83451v(C13918b.this.m83445o("/" + this.f62307a), new C13920d("/feedback/v1/client/wish", "DELETE", "")));
            } catch (C9721b e10) {
                C11839m.m70687e("WishListManager", "requestDeleteWish CException: " + e10.getMessage());
                Handler handler = this.f62308b;
                if (handler != null) {
                    Message.obtain(handler, 106, "").sendToTarget();
                }
            }
        }
    }

    /* renamed from: y8.b$d */
    public static class d {

        /* renamed from: a */
        public static final C13918b f62310a = new C13918b(null);
    }

    /* renamed from: y8.b$e */
    public class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                C11839m.m70687e("WishListManager", "msg null");
                return;
            }
            int i10 = message.what;
            C11839m.m70688i("WishListManager", "handleMessage: " + i10);
            if (i10 == 2001) {
                C13918b.this.m83447q(message.obj);
                return;
            }
            if (i10 == 2101) {
                C13918b.this.m83446p();
            } else if (i10 == 103) {
                C13918b.this.m83449s(message.obj);
            } else if (i10 == 104) {
                C13918b.this.m83448r();
            }
        }
    }

    public /* synthetic */ C13918b(a aVar) {
        this();
    }

    /* renamed from: D */
    public static void m83426D(Context context, TextView textView, int i10, int i11) {
        if (context == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        String string = context.getString(R$string.wish_list_input_count, C1011a.m6163c(Integer.valueOf(i10)), C1011a.m6163c(Integer.valueOf(i11)));
        if (textView != null) {
            textView.setText(string);
        }
    }

    /* renamed from: m */
    public static C13918b m83437m() {
        return d.f62310a;
    }

    /* renamed from: u */
    public static void m83438u(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    /* renamed from: A */
    public void m83439A(Handler handler, String str) {
        C11839m.m70688i("WishListManager", "requestDeleteWish");
        C12515a.m75110o().m75175e(new c(str, handler), false);
    }

    /* renamed from: B */
    public void m83440B(Handler handler, int i10, String str) {
        C11839m.m70688i("WishListManager", "requestWishList");
        C12515a.m75110o().m75175e(new a(i10, str, handler), false);
    }

    /* renamed from: C */
    public void m83441C(Handler handler, String str) {
        m83440B(handler, 10, str);
    }

    /* renamed from: k */
    public void m83442k() {
        C11839m.m70688i("WishListManager", "checkWishRightCache");
        List<String> listM67836t = C11296s.m67836t();
        boolean z10 = false;
        if (listM67836t != null) {
            Iterator<String> it = listM67836t.iterator();
            while (it.hasNext()) {
                if ("WL".equalsIgnoreCase(it.next())) {
                    C11839m.m70688i("WishListManager", "contain WL.");
                    z10 = true;
                }
            }
        }
        C13452e.m80781L().m80827L1(z10);
    }

    /* renamed from: l */
    public final String m83443l(String str, String str2, long j10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strM1524g = C0223k.m1524g(C0213f.m1377a(), j10);
            if (strM1524g == null) {
                strM1524g = "";
            }
            jSONObject.put("title", str);
            jSONObject.put("content", str2);
            jSONObject.put("packageType", strM1524g);
            jSONObject.put("createTime", System.currentTimeMillis());
        } catch (Exception unused) {
            C11839m.m70687e("WishListManager", "createWishData Exception");
        }
        return jSONObject.toString();
    }

    /* renamed from: n */
    public final String m83444n(int i10, String str) {
        String str2 = "?pageSize=" + i10;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String str3 = str2 + "&cursor=" + str;
        C11839m.m70686d("WishListManager", "request nextCursor:" + str);
        return str3;
    }

    /* renamed from: o */
    public final String m83445o(String str) throws C9721b {
        String strM78615G = C13040c.m78609F().m78615G();
        if (TextUtils.isEmpty(strM78615G)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "grs serviceUrl is null");
        }
        return strM78615G + "/feedback/v1/client/wish" + str;
    }

    /* renamed from: p */
    public final void m83446p() {
        C11839m.m70688i("WishListManager", "handleGetUserPackageFailed");
    }

    /* renamed from: q */
    public final void m83447q(Object obj) {
        C11839m.m70688i("WishListManager", "handleGetUserPackageSuccess");
        C13452e.m80781L().m80889a3();
        if (!(obj instanceof UserPackage)) {
            C11839m.m70687e("WishListManager", "handleGetUserPackageSuccess obj is not UserPackage.");
            C13452e.m80781L().m80827L1(false);
            return;
        }
        MemGradeRights gradeRights = ((UserPackage) obj).getGradeRights();
        if (gradeRights == null) {
            C11839m.m70687e("WishListManager", "handleGetUserPackageSuccess gradeRights is null.");
            C13452e.m80781L().m80827L1(false);
            return;
        }
        List<MemGradeRight> rights = gradeRights.getRights();
        if (rights == null || rights.isEmpty()) {
            C11839m.m70687e("WishListManager", "handleGetUserPackageSuccess rightList is null.");
            C13452e.m80781L().m80827L1(false);
            return;
        }
        for (MemGradeRight memGradeRight : rights) {
            if (memGradeRight != null && "WL".equalsIgnoreCase(memGradeRight.getRightCode()) && 1 == memGradeRight.getStatus()) {
                C11839m.m70688i("WishListManager", "handleGetUserPackageSuccess rightList contain WL.");
                C13452e.m80781L().m80827L1(true);
            }
        }
    }

    /* renamed from: r */
    public final void m83448r() {
        C11839m.m70688i("WishListManager", "handleGetWishListFailMsg");
    }

    /* renamed from: s */
    public final void m83449s(Object obj) {
        C11839m.m70688i("WishListManager", "handleGetWishListSuccessMsg");
        List<CloudWish> wishes = null;
        if (obj instanceof String) {
            try {
                GetCloudWishResp getCloudWishResp = (GetCloudWishResp) new Gson().fromJson((String) obj, GetCloudWishResp.class);
                if (getCloudWishResp != null && getCloudWishResp.getWishes() != null) {
                    wishes = getCloudWishResp.getWishes();
                }
            } catch (Exception e10) {
                C11839m.m70687e("WishListManager", "handleGetWishListSuccessMsg: " + e10.getMessage());
            }
        }
        if (wishes == null || wishes.size() <= 0) {
            C11839m.m70688i("WishListManager", "handleGetWishListSuccessMsg wish false");
            C13452e.m80781L().m80824K1(false);
        } else {
            C11839m.m70688i("WishListManager", "handleGetWishListSuccessMsg wish true");
            C13452e.m80781L().m80824K1(true);
        }
    }

    /* renamed from: t */
    public boolean m83450t() {
        if (!C13452e.m80781L().m80995z0()) {
            return false;
        }
        C11839m.m70686d("WishListManager", "hasWishListEditRight");
        return true;
    }

    /* renamed from: v */
    public final String m83451v(String str, C13920d c13920d) throws C9721b {
        try {
            return (String) C12612a.m76107g(str, c13920d, null);
        } catch (C9721b e10) {
            throw new C9721b(PlayerConstants.ErrorCode.DEFAULT_ERROR, e10.getMessage());
        }
    }

    /* renamed from: w */
    public final void m83452w(Handler handler, String str) {
        GetCloudWishResp getCloudWishResp;
        CloudWishError error;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("WishListManager", "sendAddWishSuccessMsg");
            if (handler != null) {
                Message.obtain(handler, 107, "").sendToTarget();
                return;
            }
            return;
        }
        try {
            getCloudWishResp = (GetCloudWishResp) new Gson().fromJson(str, GetCloudWishResp.class);
        } catch (Exception e10) {
            C11839m.m70687e("WishListManager", "parseAddWish Exception: " + e10.getMessage());
            getCloudWishResp = null;
        }
        if (getCloudWishResp != null && (error = getCloudWishResp.getError()) != null) {
            C11839m.m70687e("WishListManager", "parseAddWish error: " + error.getCode());
        }
        C11839m.m70688i("WishListManager", "sendAddWishFailedMsg");
        if (handler != null) {
            Message.obtain(handler, 108, "").sendToTarget();
        }
    }

    /* renamed from: x */
    public final void m83453x(Handler handler, String str) {
        GetCloudWishResp getCloudWishResp;
        CloudWishError error;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("WishListManager", "sendDeleteWishSuccessMsg");
            if (handler != null) {
                Message.obtain(handler, 105, str).sendToTarget();
                return;
            }
            return;
        }
        try {
            getCloudWishResp = (GetCloudWishResp) new Gson().fromJson(str, GetCloudWishResp.class);
        } catch (Exception e10) {
            C11839m.m70687e("WishListManager", "parseDeleteWish Exception: " + e10.getMessage());
            getCloudWishResp = null;
        }
        if (getCloudWishResp != null && (error = getCloudWishResp.getError()) != null) {
            C11839m.m70687e("WishListManager", "parseDeleteWish error: " + error.getCode());
        }
        C11839m.m70688i("WishListManager", "sendDeleteWishFailedMsg");
        if (handler != null) {
            Message.obtain(handler, 106, "").sendToTarget();
        }
    }

    /* renamed from: y */
    public final void m83454y(Handler handler, String str) {
        GetCloudWishResp getCloudWishResp;
        try {
            getCloudWishResp = (GetCloudWishResp) new Gson().fromJson(str, GetCloudWishResp.class);
        } catch (Exception e10) {
            C11839m.m70687e("WishListManager", "parseWishListResult Exception: " + e10.getMessage());
            getCloudWishResp = null;
        }
        if (getCloudWishResp == null) {
            C11839m.m70688i("WishListManager", "sendWishListFailedMsg");
            if (handler != null) {
                Message.obtain(handler, 104, "").sendToTarget();
                return;
            }
            return;
        }
        if (getCloudWishResp.getWishes() != null) {
            C11839m.m70688i("WishListManager", "sendWishListSuccessMsg");
            if (handler != null) {
                Message.obtain(handler, 103, str).sendToTarget();
                return;
            }
            return;
        }
        CloudWishError error = getCloudWishResp.getError();
        if (error != null) {
            C11839m.m70687e("WishListManager", "parseWishList error: " + error.getCode());
        }
        C11839m.m70688i("WishListManager", "sendWishListFailedMsg");
        if (handler != null) {
            Message.obtain(handler, 104, "").sendToTarget();
        }
    }

    /* renamed from: z */
    public void m83455z(Handler handler, String str, String str2, long j10) throws JSONException {
        C11839m.m70688i("WishListManager", "requestAddWish");
        C12515a.m75110o().m75172d(new b(m83443l(str, str2, j10), handler));
    }

    public C13918b() {
        this.f62299a = new e();
    }
}
