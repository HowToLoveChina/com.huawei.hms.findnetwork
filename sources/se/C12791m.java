package se;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.tag.bean.TagLocalFindResult;
import com.huawei.gson.Gson;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p616rk.C12515a;
import p809yg.C13981a;
import p842zf.C14298f;

/* renamed from: se.m */
/* loaded from: classes4.dex */
public class C12791m {

    /* renamed from: a */
    public Handler.Callback f58462a;

    /* renamed from: b */
    public int f58463b;

    /* renamed from: c */
    public int f58464c;

    /* renamed from: e */
    public String f58466e;

    /* renamed from: f */
    public String f58467f;

    /* renamed from: g */
    public String f58468g;

    /* renamed from: h */
    public String f58469h;

    /* renamed from: i */
    public String f58470i;

    /* renamed from: j */
    public Context f58471j;

    /* renamed from: k */
    public C14298f f58472k = new C14298f();

    /* renamed from: d */
    public long f58465d = System.currentTimeMillis();

    /* renamed from: se.m$a */
    public class a extends AbstractC9478g {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("AncillaryDeviceAlarmReport", "do report ancillary alarm result, operation:" + C12791m.this.f58466e + ",resultCode:" + C12791m.this.f58464c);
            String strM76760i = C12791m.this.m76760i();
            if (C12791m.this.m76761j().m85162e()) {
                TagLocalFindResult tagLocalFindResultM85159b = C12791m.this.m76761j().m85159b(strM76760i);
                C12791m.this.m76761j().m85163g(C12791m.this.f58471j, tagLocalFindResultM85159b, new Gson().toJson(tagLocalFindResultM85159b, TagLocalFindResult.class));
            }
            if (C12791m.this.m76761j().m85161d()) {
                return;
            }
            RequestModeConfig.getInstance().setMode(Integer.valueOf(C12791m.this.f58463b), false);
            C4346d.m26226e(C12791m.this.f58463b, strM76760i, C12791m.this.f58462a, C12791m.this.f58471j, C12791m.this.f58470i);
        }
    }

    public C12791m(Context context, int i10, int i11, PushCmdParser pushCmdParser, String str, String str2, Handler.Callback callback) {
        this.f58471j = context;
        this.f58463b = i10;
        this.f58464c = i11;
        this.f58462a = callback;
        this.f58466e = str2;
        this.f58467f = pushCmdParser.getCmdParamValue("perDeviceType");
        this.f58468g = pushCmdParser.getCmdParamValue("perDeviceId");
        this.f58469h = str;
        this.f58470i = pushCmdParser.getTraceID();
    }

    /* renamed from: h */
    public void m76759h() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: i */
    public final String m76760i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", this.f58466e);
            jSONObject.put("result", this.f58464c);
            jSONObject.put("reportTime", this.f58465d);
            if (this.f58468g != null) {
                jSONObject.put("perDeviceType", this.f58467f);
                jSONObject.put("perDeviceId", this.f58468g);
                jSONObject.put("cptList", this.f58469h);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("AncillaryDeviceAlarmReport", "encaseAncBellResult JSONException");
            return null;
        }
    }

    /* renamed from: j */
    public C14298f m76761j() {
        return this.f58472k;
    }
}
