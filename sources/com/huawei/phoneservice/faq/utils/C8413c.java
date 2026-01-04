package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.response.FaqKnowSearchDetail;
import com.huawei.phoneservice.faqcommon.webapi.utils.FaqDmpa;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.phoneservice.faq.utils.c */
/* loaded from: classes4.dex */
public class C8413c {

    /* renamed from: a */
    public static volatile C8413c f39227a;

    /* renamed from: b */
    public static String f39228b;

    /* renamed from: com.huawei.phoneservice.faq.utils.c$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public String f39229a;

        /* renamed from: b */
        public String f39230b;

        /* renamed from: c */
        public String f39231c;

        /* renamed from: d */
        public Context f39232d;

        public a(Context context, String str, String str2, String str3) {
            this.f39229a = str;
            this.f39230b = str2;
            this.f39231c = str3;
            this.f39232d = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                new FaqDmpa(this.f39232d, this.f39229a).dmpa(this.f39230b, this.f39231c);
            } catch (NoSuchAlgorithmException e10) {
                FaqLogger.m51840e("collectionSearchData", e10.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static C8413c m52372a() {
        if (f39227a == null) {
            synchronized (C8413c.class) {
                try {
                    if (f39227a == null) {
                        f39227a = new C8413c();
                    }
                } finally {
                }
            }
        }
        return f39227a;
    }

    /* renamed from: f */
    public static void m52373f(String str) {
        f39228b = str;
    }

    /* renamed from: g */
    public static String m52374g() {
        return f39228b;
    }

    /* renamed from: b */
    public void m52375b(Activity activity, FaqKnowSearchDetail faqKnowSearchDetail, int i10, String str, String str2) throws Throwable {
        if (ModuleConfigUtils.searchLogCollectEnabled()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("site_id", str);
            jsonObject.addProperty("country", str2);
            jsonObject.addProperty("siteCode", "");
            jsonObject.addProperty("index", Integer.valueOf(i10));
            jsonObject.addProperty("pageno", Integer.valueOf((i10 / 20) + 1));
            jsonObject.addProperty("clickfrom", "resultList");
            jsonObject.addProperty("sid", m52374g());
            if (!TextUtils.isEmpty(faqKnowSearchDetail.m51974l())) {
                jsonObject.addProperty("knowledge_context_id", faqKnowSearchDetail.m51974l());
                jsonObject.addProperty("title", faqKnowSearchDetail.m51976n());
            }
            if (!"".equals(faqKnowSearchDetail.m51972i())) {
                jsonObject.addProperty("interventions", "1");
            }
            m52376c(activity, FaqConstants.CLICKDOC, jsonObject.toString(), str);
        }
    }

    /* renamed from: c */
    public final void m52376c(Activity activity, String str, String str2, String str3) throws Throwable {
        C8415e.m52388a(new a(activity, str3, str, str2));
    }

    /* renamed from: d */
    public void m52377d(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (ModuleConfigUtils.searchLogCollectEnabled()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("site_id", str3);
            jsonObject.addProperty("country", str4);
            jsonObject.addProperty("siteCode", "");
            jsonObject.addProperty("query_from", str);
            jsonObject.addProperty("query", str2);
            String string = UUID.randomUUID().toString();
            jsonObject.addProperty("sid", string);
            m52373f(string);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("q", str2);
            jsonObject2.addProperty(FaqConstants.FAQ_EMUI_LANGUAGE, str5);
            jsonObject2.addProperty("pageSize", "20");
            jsonObject2.addProperty("pageNo", "1");
            jsonObject.addProperty("searchParam", jsonObject2.toString());
            m52376c(activity, FaqConstants.CUSTOMSEARCH, jsonObject.toString(), str3);
        }
    }

    /* renamed from: e */
    public void m52378e(Activity activity, List<FaqKnowSearchDetail> list, String str, String str2) throws Throwable {
        if (ModuleConfigUtils.searchLogCollectEnabled()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("site_id", str);
            jsonObject.addProperty("country", str2);
            jsonObject.addProperty("siteCode", "");
            jsonObject.addProperty("pageno", "1");
            jsonObject.addProperty("sid", m52374g());
            JsonArray jsonArray = new JsonArray();
            for (int i10 = 0; i10 < list.size(); i10++) {
                JsonObject jsonObject2 = new JsonObject();
                if (list.get(i10) != null) {
                    jsonObject2.addProperty("knowledge_context_id", list.get(i10).m51974l());
                    jsonObject2.addProperty("title", list.get(i10).m51976n());
                    if (!"".equals(list.get(i10).m51972i())) {
                        jsonObject2.addProperty("interventions", "1");
                    }
                    jsonArray.add(jsonObject2);
                }
            }
            jsonObject.addProperty("knowlist", jsonArray.toString());
            m52376c(activity, "display", jsonObject.toString(), str);
        }
    }
}
