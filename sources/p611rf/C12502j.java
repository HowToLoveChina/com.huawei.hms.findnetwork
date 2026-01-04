package p611rf;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4347e;
import eg.AbstractC9478g;
import fk.C9721b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0241z;
import p616rk.C12515a;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: rf.j */
/* loaded from: classes4.dex */
public class C12502j {

    /* renamed from: a */
    public Handler f57584a;

    /* renamed from: b */
    public Handler.Callback f57585b;

    /* renamed from: rf.j$a */
    public static class a implements Handler.Callback {

        /* renamed from: a */
        public final Context f57586a;

        /* renamed from: b */
        public final Handler f57587b;

        /* renamed from: c */
        public final Handler.Callback f57588c;

        public a(Context context, Handler handler, Handler.Callback callback) {
            this.f57586a = context;
            this.f57587b = handler;
            this.f57588c = callback;
        }

        /* renamed from: a */
        public final void m75061a(int i10, String str) {
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putInt("result", i10);
            bundle.putString("response_info", str);
            messageObtain.setData(bundle);
            Handler handler = this.f57587b;
            if (handler != null) {
                handler.sendMessage(messageObtain);
            }
            Handler.Callback callback = this.f57588c;
            if (callback != null) {
                callback.handleMessage(messageObtain);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            C13981a.m83989i("UpdateActivationBypass", "call update callback");
            C12797b c12797b = new C12797b();
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            if (200 == iM1685c) {
                int iM26233d = C4347e.m26233d(message.getData().getString("response_info"));
                C13981a.m83990w("UpdateActivationBypass", "handleMessage resultCode=" + iM26233d);
                if (iM26233d == 0) {
                    m75061a(0, null);
                    c12797b.m76784j(this.f57586a, "UpdateActivationBypass", "0", "UpdateActivationBypass success", null, "01071", null, "updateBypass", true);
                    return true;
                }
                if (401 == iM26233d) {
                    C13981a.m83988e("UpdateActivationBypass", "handleMessage auth fail");
                    c12797b.m76782h(this.f57586a, "UpdateActivationBypass", "001_3004", iM26233d, "UpdateActivationBypass fail, resultCode=" + iM26233d, null, "01071", null, "updateBypass", true);
                } else {
                    C13981a.m83988e("UpdateActivationBypass", "handleMessage fail");
                    c12797b.m76782h(this.f57586a, "UpdateActivationBypass", "001_3004", iM26233d, "UpdateActivationBypass fail, resultCode=" + iM26233d, null, "01071", null, "updateBypass", true);
                }
            } else {
                C13981a.m83988e("UpdateActivationBypass", "handleMessage result error=" + iM1685c);
                c12797b.m76784j(this.f57586a, "UpdateActivationBypass", "001_3003", "UpdateActivationBypass fail, result=" + iM1685c, null, "01071", null, "updateBypass", true);
            }
            m75061a(-1, "");
            return true;
        }
    }

    /* renamed from: rf.j$b */
    public static class b extends AbstractC9478g {

        /* renamed from: a */
        public final Context f57589a;

        /* renamed from: b */
        public final Handler f57590b;

        /* renamed from: c */
        public final Handler.Callback f57591c;

        public b(Context context, Handler handler, Handler.Callback callback) {
            this.f57589a = context;
            this.f57590b = handler;
            this.f57591c = callback;
        }

        /* renamed from: c */
        public final String m75062c() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", "v11");
                jSONObject.put("bypassTimesClear", 1);
                if (C1175a.m7385g(true)) {
                    C13981a.m83989i("UpdateActivationBypass", "has auth flag, not report socId");
                    return jSONObject.toString();
                }
                JSONArray jSONArrayM7393o = C1175a.m7393o();
                if (jSONArrayM7393o != null && jSONArrayM7393o.length() != 0 && !TextUtils.isEmpty(jSONArrayM7393o.toString())) {
                    jSONObject.put("socID", jSONArrayM7393o);
                    C13981a.m83989i("UpdateActivationBypass", "encaseUpdateInfo, socId not null");
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
                C13981a.m83988e("UpdateActivationBypass", "encaseUpdateInfo exception");
                return null;
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, C9721b {
            C13981a.m83989i("UpdateActivationBypass", "call update");
            String strM75062c = m75062c();
            if (strM75062c == null) {
                C13981a.m83988e("UpdateActivationBypass", "UpdateTask, request body is null");
                return;
            }
            a aVar = new a(this.f57589a, this.f57590b, this.f57591c);
            String strM76774a = C12797b.m76774a("01071");
            RequestModeConfig.getInstance().setMode(3111, true);
            C4346d.m26226e(3111, strM75062c, aVar, this.f57589a, strM76774a);
            new C12797b().m76784j(this.f57589a, "UpdateActivationBypass", "0", "call UpdateActivationBypass", null, "01071", null, "updateBypass", true);
        }
    }

    /* renamed from: a */
    public void m75060a() {
        C13981a.m83989i("UpdateActivationBypass", "doUpdateInfo");
        C12515a.m75110o().m75172d(new b(C0213f.m1377a(), this.f57584a, this.f57585b));
    }
}
