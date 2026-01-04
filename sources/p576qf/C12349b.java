package p576qf;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.ExecuteCmdBuilder;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: qf.b */
/* loaded from: classes4.dex */
public class C12349b implements Handler.Callback {

    /* renamed from: a */
    public Context f57142a;

    /* renamed from: b */
    public PushCmdParser f57143b;

    /* renamed from: c */
    public JSONObject f57144c;

    public C12349b(Context context, PushCmdParser pushCmdParser, JSONObject jSONObject) {
        this.f57142a = context;
        this.f57143b = pushCmdParser;
        this.f57144c = jSONObject;
    }

    /* renamed from: a */
    public final String m74313a(String str) throws JSONException {
        String string = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lockSdcard")) {
                string = jSONObject.getString("lockSdcard");
            } else {
                C13981a.m83989i("AsyncQueryCallBack", "getLockSDCard->json has no lockSDCard");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryCallBack", "getLockSDCard JSONException");
        }
        return string;
    }

    /* renamed from: b */
    public final String m74314b(String str) throws JSONException {
        String string = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lockScreen")) {
                string = jSONObject.getString("lockScreen");
            } else {
                C13981a.m83989i("AsyncQueryCallBack", "getLockScreen->json has no lockScreen");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryCallBack", "getLockScreen JSONException");
        }
        return string;
    }

    /* renamed from: c */
    public final String m74315c(String str) throws JSONException {
        String string = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("message")) {
                string = jSONObject.getString("message");
            } else {
                C13981a.m83989i("AsyncQueryCallBack", "getMessage->json has no message");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryCallBack", "getMessage JSONException");
        }
        return string;
    }

    /* renamed from: d */
    public final String m74316d(String str) throws JSONException {
        String string = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("password")) {
                string = jSONObject.getString("password");
            } else {
                C13981a.m83989i("AsyncQueryCallBack", "getPassword->json has no password");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryCallBack", "getPassword JSONException");
        }
        return string;
    }

    /* renamed from: e */
    public final int m74317e(String str) throws JSONException {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83987d("AsyncQueryCallBack", "getResultCode->json has no resultCode");
            }
            C13981a.m83987d("AsyncQueryCallBack", "resultCode:" + i10);
        } catch (JSONException unused) {
            C13981a.m83988e("AsyncQueryCallBack", "getResultCode JSONException");
        }
        return i10;
    }

    /* renamed from: f */
    public final void m74318f(Message message) throws JSONException {
        Bundle data;
        if (message == null || (data = message.getData()) == null) {
            return;
        }
        int iM1685c = C0241z.m1685c(data.getString("result"));
        C13981a.m83989i("AsyncQueryCallBack", "handleAsyncQueryCallBack result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            AbstractC1177c.m7408T(this.f57143b, this.f57142a);
            C13981a.m83988e("AsyncQueryCallBack", "handleAsyncQueryCallBack->report error, result:" + iM1685c);
            c12797b.m76783i(this.f57142a, "AsyncQueryCallBack", "001_1006", "AsyncQueryPushInfo connect to server failed by query " + this.f57143b.getOperation(), null, this.f57143b, "lockQueryInfo", true);
            return;
        }
        String string = data.getString("response_info");
        int iM74317e = m74317e(string);
        C13981a.m83989i("AsyncQueryCallBack", "handleAsyncQueryCallBack->resultCode =" + iM74317e);
        if (iM74317e == 0) {
            if (m74319g(string)) {
                ExecuteCmdBuilder.excuteV8Cmd(this.f57142a, this.f57143b);
            } else {
                AbstractC1177c.m7406R(this.f57143b, this.f57142a);
            }
            c12797b.m76783i(this.f57142a, "AsyncQueryCallBack", "0", "AsyncQueryPushInfo query success:" + this.f57143b.getOperation(), null, this.f57143b, "lockQueryInfo", false);
            return;
        }
        AbstractC1177c.m7408T(this.f57143b, this.f57142a);
        c12797b.m76783i(this.f57142a, "AsyncQueryCallBack", "001_1006", "AsyncQueryPushInfo handle failed in server by query " + this.f57143b.getOperation(), null, this.f57143b, "lockQueryInfo", true);
        C13981a.m83988e("AsyncQueryCallBack", "handleAsyncQueryCallBack->resultCode =" + iM74317e);
    }

    /* renamed from: g */
    public final boolean m74319g(String str) throws JSONException {
        if (this.f57143b != null && !TextUtils.isEmpty(str)) {
            if (this.f57144c == null) {
                this.f57144c = new JSONObject();
            }
            try {
                String strM74314b = m74314b(str);
                if (strM74314b != null) {
                    this.f57144c.put("lockScreen", strM74314b);
                }
                String strM74313a = m74313a(str);
                if (strM74313a != null) {
                    this.f57144c.put("lockSdcard", strM74313a);
                }
                String strM74315c = m74315c(str);
                if (strM74315c != null) {
                    this.f57144c.put("message", strM74315c);
                }
                String strM74316d = m74316d(str);
                if (strM74316d != null) {
                    this.f57144c.put("password", strM74316d);
                }
                return this.f57143b.updateParam(this.f57144c);
            } catch (JSONException unused) {
                C13981a.m83988e("AsyncQueryCallBack", "reCapsuPushCmd JSONException");
            }
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws JSONException {
        C13981a.m83989i("AsyncQueryCallBack", "AsyncQueryCallBack->handleMessage");
        m74318f(message);
        return true;
    }
}
