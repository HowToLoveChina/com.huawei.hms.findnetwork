package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.push.o */
/* loaded from: classes8.dex */
public class C6296o {

    /* renamed from: B */
    private int f29679B;

    /* renamed from: D */
    private String f29681D;

    /* renamed from: b */
    private int f29685b;

    /* renamed from: c */
    private String f29686c;

    /* renamed from: d */
    private String f29687d;

    /* renamed from: l */
    private String f29695l;

    /* renamed from: m */
    private String f29696m;

    /* renamed from: n */
    private String f29697n;

    /* renamed from: o */
    private String f29698o;

    /* renamed from: p */
    private String f29699p;

    /* renamed from: r */
    private String f29701r;

    /* renamed from: s */
    private String f29702s;

    /* renamed from: z */
    private String f29709z;

    /* renamed from: a */
    private String f29684a = "";

    /* renamed from: e */
    private String f29688e = "";

    /* renamed from: f */
    private String f29689f = "";

    /* renamed from: g */
    private String f29690g = "";

    /* renamed from: h */
    private String f29691h = "";

    /* renamed from: i */
    private String f29692i = "";

    /* renamed from: j */
    private String f29693j = "";

    /* renamed from: k */
    private String f29694k = "";

    /* renamed from: q */
    private String f29700q = "";

    /* renamed from: t */
    private int f29703t = EnumC6292k.STYLE_DEFAULT.ordinal();

    /* renamed from: u */
    private String f29704u = "";

    /* renamed from: v */
    private String f29705v = "";

    /* renamed from: w */
    private String f29706w = "";

    /* renamed from: x */
    private int f29707x = 0;

    /* renamed from: y */
    private int f29708y = 0;

    /* renamed from: A */
    private String f29678A = "";

    /* renamed from: C */
    private String f29680C = "";

    /* renamed from: E */
    private String f29682E = "";

    /* renamed from: F */
    private String f29683F = "";

    public C6296o(byte[] bArr, byte[] bArr2) {
        Charset charset = C6294m.f29674a;
        this.f29701r = new String(bArr, charset);
        this.f29702s = new String(bArr2, charset);
    }

    /* renamed from: a */
    private JSONObject m36552a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f29684a);
        jSONObject2.put("tag", this.f29678A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f29707x);
        jSONObject2.put("visibility", this.f29708y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f29709z);
        return jSONObject2;
    }

    /* renamed from: b */
    private JSONObject m36554b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.f29690g);
        jSONObject2.put("content", this.f29691h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f29692i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f29693j);
        jSONObject2.put("notifySummary", this.f29694k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    /* renamed from: c */
    private void m36555c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f29687d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i10 = 0; i10 < length; i10++) {
                sb2.append("0");
            }
            sb2.append(string);
            this.f29687d = sb2.toString();
        }
    }

    /* renamed from: d */
    private boolean m36556d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f29696m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f29686c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f29695l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.m36983d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    /* renamed from: e */
    private boolean m36557e(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(RemoteMessageConst.MSGID)) {
            HMSLog.m36988i("PushSelfShowLog", "msgId == null");
            return false;
        }
        Object obj = jSONObject.get(RemoteMessageConst.MSGID);
        if (obj instanceof String) {
            this.f29688e = (String) obj;
            return true;
        }
        if (!(obj instanceof Integer)) {
            return true;
        }
        this.f29688e = String.valueOf(((Integer) obj).intValue());
        return true;
    }

    /* renamed from: f */
    private boolean m36558f(JSONObject jSONObject) throws JSONException {
        HMSLog.m36983d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has(TemplateStyleRecord.STYLE)) {
                this.f29703t = jSONObject2.getInt(TemplateStyleRecord.STYLE);
            }
            this.f29704u = jSONObject2.optString("bigTitle");
            this.f29705v = jSONObject2.optString("bigContent");
            this.f29682E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e10) {
            HMSLog.m36988i("PushSelfShowLog", e10.toString());
            return false;
        }
    }

    /* renamed from: g */
    private void m36559g(JSONObject jSONObject) {
        this.f29684a = jSONObject.optString("group");
        HMSLog.m36983d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f29684a);
        this.f29707x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.m36983d("PushSelfShowLog", "autoCancel: " + this.f29707x);
        this.f29708y = jSONObject.optInt("visibility", 0);
        this.f29709z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.f29678A = jSONObject.optString("tag");
    }

    /* renamed from: h */
    private boolean m36560h(JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f29685b = jSONObject2.getInt("autoClear");
            } else {
                this.f29685b = 0;
            }
            if (!"app".equals(this.f29690g) && !"cosa".equals(this.f29690g)) {
                if ("url".equals(this.f29690g)) {
                    m36563k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f29690g)) {
                    return true;
                }
                m36562j(jSONObject2);
                return true;
            }
            m36556d(jSONObject2);
            return true;
        } catch (Exception e10) {
            HMSLog.m36987e("PushSelfShowLog", "ParseParam error ", e10);
            return false;
        }
    }

    /* renamed from: i */
    private boolean m36561i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f29690g = jSONObject2.getString("cmd");
            this.f29691h = jSONObject2.optString("content");
            this.f29692i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f29693j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f29694k = jSONObject2.optString("notifySummary");
            this.f29681D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || m36558f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return m36560h(jSONObject2);
            }
        }
        return false;
    }

    /* renamed from: j */
    private boolean m36562j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f29695l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.m36983d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f29698o = jSONObject.getString("rpl");
        this.f29699p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f29700q = jSONObject.getString("rpct");
        return true;
    }

    /* renamed from: k */
    private boolean m36563k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.has("url")) {
            HMSLog.m36983d("PushSelfShowLog", "url is null");
            return false;
        }
        this.f29697n = jSONObject.getString("url");
        if (jSONObject.has("appPackageName")) {
            this.f29695l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            return true;
        }
        this.f29698o = jSONObject.getString("rpl");
        this.f29699p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f29700q = jSONObject.getString("rpct");
        return true;
    }

    /* renamed from: q */
    private JSONObject m36564q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TemplateStyleRecord.STYLE, this.f29703t);
        jSONObject.put("bigTitle", this.f29704u);
        jSONObject.put("bigContent", this.f29705v);
        jSONObject.put("bigPic", this.f29706w);
        return jSONObject;
    }

    /* renamed from: u */
    private JSONObject m36565u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f29685b);
        jSONObject.put("url", this.f29697n);
        jSONObject.put("rpl", this.f29698o);
        jSONObject.put("rpt", this.f29699p);
        jSONObject.put("rpct", this.f29700q);
        jSONObject.put("appPackageName", this.f29695l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f29696m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f29686c);
        return jSONObject;
    }

    /* renamed from: l */
    public String m36578l() {
        return this.f29682E;
    }

    /* renamed from: m */
    public String m36579m() {
        return this.f29686c;
    }

    /* renamed from: n */
    public byte[] m36580n() {
        try {
            return m36552a(m36553a(m36554b(m36565u()), m36564q())).toString().getBytes(C6294m.f29674a);
        } catch (JSONException e10) {
            HMSLog.m36987e("PushSelfShowLog", "getMsgData failed JSONException:", e10);
            return new byte[0];
        }
    }

    /* renamed from: o */
    public String m36581o() {
        HMSLog.m36983d("PushSelfShowLog", "msgId =" + this.f29688e);
        return this.f29688e;
    }

    /* renamed from: p */
    public String m36582p() {
        return this.f29678A;
    }

    /* renamed from: r */
    public int m36583r() {
        return this.f29679B;
    }

    /* renamed from: s */
    public String m36584s() {
        return this.f29694k;
    }

    /* renamed from: t */
    public String m36585t() {
        return this.f29693j;
    }

    /* renamed from: v */
    public int m36586v() {
        return this.f29703t;
    }

    /* renamed from: w */
    public String m36587w() {
        return this.f29681D;
    }

    /* renamed from: x */
    public byte[] m36588x() {
        return this.f29702s.getBytes(C6294m.f29674a);
    }

    /* renamed from: y */
    public boolean m36589y() throws JSONException {
        try {
            if (TextUtils.isEmpty(this.f29701r)) {
                HMSLog.m36983d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f29701r);
            m36559g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!m36557e(jSONObject2)) {
                return false;
            }
            this.f29689f = jSONObject2.optString("dispPkgName");
            m36555c(jSONObject2);
            this.f29679B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.f29680C = jSONObject2.optString("data");
            this.f29683F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return m36561i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.m36983d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e10) {
            HMSLog.m36983d("PushSelfShowLog", e10.toString());
            return false;
        }
    }

    /* renamed from: a */
    private JSONObject m36553a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f29689f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f29688e);
        jSONObject3.put("ap", this.f29687d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.f29679B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.f29681D);
        jSONObject3.put("data", this.f29680C);
        return jSONObject3;
    }

    /* renamed from: b */
    public String m36568b() {
        return this.f29683F;
    }

    /* renamed from: d */
    public int m36570d() {
        return this.f29707x;
    }

    /* renamed from: g */
    public String m36573g() {
        return this.f29704u;
    }

    /* renamed from: e */
    public int m36571e() {
        return this.f29685b;
    }

    /* renamed from: f */
    public String m36572f() {
        return this.f29705v;
    }

    /* renamed from: j */
    public String m36576j() {
        return this.f29689f;
    }

    /* renamed from: c */
    public String m36569c() {
        return this.f29695l;
    }

    /* renamed from: k */
    public String m36577k() {
        return this.f29684a;
    }

    /* renamed from: h */
    public String m36574h() {
        return this.f29690g;
    }

    /* renamed from: i */
    public String m36575i() {
        return this.f29691h;
    }

    /* renamed from: a */
    public String m36566a() {
        return this.f29696m;
    }

    /* renamed from: a */
    public void m36567a(int i10) {
        this.f29679B = i10;
    }
}
