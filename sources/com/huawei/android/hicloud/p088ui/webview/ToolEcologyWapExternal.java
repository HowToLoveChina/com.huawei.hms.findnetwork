package com.huawei.android.hicloud.p088ui.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.webview.SafeWebView;
import java.util.LinkedHashMap;
import je.C10794j;
import mu.C11524a;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0234s;
import p514o9.C11839m;
import p681uj.C13194k;
import p681uj.C13196m;
import p681uj.C13199p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class ToolEcologyWapExternal extends C11524a {

    /* renamed from: c */
    public String f19608c;

    /* renamed from: d */
    public SafeWebView f19609d;

    /* renamed from: e */
    public Context f19610e;

    /* renamed from: f */
    public LoadDataListener f19611f;

    public interface LoadDataListener {
        /* renamed from: R */
        void mo21258R(String str);

        /* renamed from: f */
        void mo21368f(SafeWebView safeWebView, boolean z10);
    }

    public ToolEcologyWapExternal(SafeWebView safeWebView, Context context, LoadDataListener loadDataListener) {
        super(safeWebView);
        this.f19608c = "";
        this.f19609d = safeWebView;
        this.f19610e = context;
        this.f19611f = loadDataListener;
    }

    /* renamed from: e */
    public final void m25854e(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        String strM1638p = C0234s.m1638p();
        linkedHashMapM79499C.put("toolId", str);
        linkedHashMapM79499C.put("toolName", str2);
        linkedHashMapM79499C.put("categoryId", str3);
        linkedHashMapM79499C.put("categoryName", str4);
        linkedHashMapM79499C.put(FaqConstants.FAQ_EMUI_LANGUAGE, strM1638p);
        C13225d.m79490f1().m79591l0("mecloud_click_tool", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_click_tool", "1", "70", linkedHashMapM79499C);
    }

    @JavascriptInterface
    public void excuteOpenTool(String str) throws JSONException {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        JSONObject jSONObject;
        C11839m.m70688i("ToolEcologyWapExternal", "excuteOpenTool jsonData=" + str);
        String string6 = "";
        try {
            jSONObject = new JSONObject(str);
            string = jSONObject.getString("appId");
            try {
                string2 = jSONObject.getString("appName");
            } catch (JSONException e10) {
                e = e10;
                string2 = "";
                string3 = string2;
                string4 = string3;
                string5 = string4;
                C11839m.m70687e("ToolEcologyWapExternal", "excuteOpenTool error" + e.getMessage());
                m25854e(string, string2, string5, string6);
                C10794j.m65687n(this.f19610e, string4, string3);
            }
            try {
                string3 = jSONObject.getString("openUrl");
            } catch (JSONException e11) {
                e = e11;
                string3 = "";
                string4 = string3;
                string5 = string4;
                C11839m.m70687e("ToolEcologyWapExternal", "excuteOpenTool error" + e.getMessage());
                m25854e(string, string2, string5, string6);
                C10794j.m65687n(this.f19610e, string4, string3);
            }
            try {
                string4 = jSONObject.getString("appType");
                try {
                    string5 = jSONObject.getString("categoryId");
                } catch (JSONException e12) {
                    e = e12;
                    string5 = "";
                }
            } catch (JSONException e13) {
                e = e13;
                string4 = "";
                string5 = string4;
                C11839m.m70687e("ToolEcologyWapExternal", "excuteOpenTool error" + e.getMessage());
                m25854e(string, string2, string5, string6);
                C10794j.m65687n(this.f19610e, string4, string3);
            }
        } catch (JSONException e14) {
            e = e14;
            string = "";
            string2 = string;
        }
        try {
            string6 = jSONObject.getString("categoryName");
        } catch (JSONException e15) {
            e = e15;
            C11839m.m70687e("ToolEcologyWapExternal", "excuteOpenTool error" + e.getMessage());
            m25854e(string, string2, string5, string6);
            C10794j.m65687n(this.f19610e, string4, string3);
        }
        m25854e(string, string2, string5, string6);
        C10794j.m65687n(this.f19610e, string4, string3);
    }

    @JavascriptInterface
    public String getWebAt(boolean z10) throws C13199p, C13194k {
        C11839m.m70688i("ToolEcologyWapExternal", "getWebAt forceUpdate=" + z10);
        if (!C10794j.m65676c(m68794b())) {
            C11839m.m70687e("ToolEcologyWapExternal", "getWebAt, url is invalid");
            return "";
        }
        if (z10) {
            C13196m.m79363o().m79375t(this.f19608c);
        }
        String strM79367k = C13196m.m79363o().m79367k();
        this.f19608c = strM79367k;
        return strM79367k;
    }

    @JavascriptInterface
    public void onLoadDataFinish(boolean z10) {
        C11839m.m70688i("ToolEcologyWapExternal", "onLoadDataFinish");
        LoadDataListener loadDataListener = this.f19611f;
        if (loadDataListener != null) {
            loadDataListener.mo21368f(this.f19609d, z10);
        }
    }

    @JavascriptInterface
    public void onLoadPageError(String str) {
        C11839m.m70688i("ToolEcologyWapExternal", "onLoadPageError errorCode =" + str);
        LoadDataListener loadDataListener = this.f19611f;
        if (loadDataListener != null) {
            loadDataListener.mo21258R(str);
        }
    }
}
