package com.huawei.hwcloudjs.p164f;

import android.content.Context;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import java.lang.reflect.Field;

/* renamed from: com.huawei.hwcloudjs.f.g */
/* loaded from: classes8.dex */
public class C6662g {

    /* renamed from: a */
    private static final String f30889a = "ReflectUtils";

    /* renamed from: com.huawei.hwcloudjs.f.g$a */
    public enum a {
        RES_TYPE_ID("id"),
        RES_TYPE_LAYOUT("layout"),
        RES_TYPE_STRING(ExtractOWiFiHelper.STING_NODE),
        RES_TYPE_DRAWABLE("drawable"),
        RES_TYPE_STYLE(TemplateStyleRecord.STYLE),
        RES_TYPE_COLOR(RemoteMessageConst.Notification.COLOR),
        RES_TYPE_DIMEN("dimen"),
        RES_TYPE_MENU("menu"),
        RES_TYPE_ARRAY("array");


        /* renamed from: k */
        private String f30900k;

        a(String str) {
            this.f30900k = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f30900k;
        }
    }

    /* renamed from: a */
    public static final int m37889a(Context context, a aVar, String str) throws NoSuchFieldException {
        StringBuilder sb2;
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(context.getPackageName());
            sb3.append(".R$");
            sb3.append(aVar.toString());
            Field field = Class.forName(sb3.toString()).getField(str);
            return Integer.parseInt(field.get(field.getName()).toString());
        } catch (ClassNotFoundException unused) {
            sb2 = new StringBuilder();
            sb2.append("reflect ClassNotFoundException! resourceType=");
            sb2.append(aVar);
            sb2.append("--resourceName=");
            sb2.append(str);
            C6659d.m37881b(f30889a, sb2.toString(), true);
            return 0;
        } catch (IllegalAccessException unused2) {
            sb2 = new StringBuilder();
            sb2.append("reflect ClassNotFoundException! resourceType=");
            sb2.append(aVar);
            sb2.append("--resourceName=");
            sb2.append(str);
            C6659d.m37881b(f30889a, sb2.toString(), true);
            return 0;
        } catch (NoSuchFieldException unused3) {
            sb2 = new StringBuilder();
            sb2.append("reflect ClassNotFoundException! resourceType=");
            sb2.append(aVar);
            sb2.append("--resourceName=");
            sb2.append(str);
            C6659d.m37881b(f30889a, sb2.toString(), true);
            return 0;
        }
    }

    /* renamed from: b */
    public static final int m37891b(Context context, String str) {
        return m37889a(context, a.RES_TYPE_COLOR, str);
    }

    /* renamed from: c */
    public static final int m37892c(Context context, String str) {
        return m37889a(context, a.RES_TYPE_DIMEN, str);
    }

    /* renamed from: d */
    public static final int m37893d(Context context, String str) {
        return m37889a(context, a.RES_TYPE_DRAWABLE, str);
    }

    /* renamed from: e */
    public static final int m37894e(Context context, String str) {
        return m37889a(context, a.RES_TYPE_ID, str);
    }

    /* renamed from: f */
    public static final int m37895f(Context context, String str) {
        return m37889a(context, a.RES_TYPE_LAYOUT, str);
    }

    /* renamed from: g */
    public static final int m37896g(Context context, String str) {
        return m37889a(context, a.RES_TYPE_MENU, str);
    }

    /* renamed from: h */
    public static final int m37897h(Context context, String str) {
        return m37889a(context, a.RES_TYPE_STRING, str);
    }

    /* renamed from: i */
    public static final int m37898i(Context context, String str) {
        return m37889a(context, a.RES_TYPE_STYLE, str);
    }

    /* renamed from: a */
    public static final int m37890a(Context context, String str) {
        return m37889a(context, a.RES_TYPE_ARRAY, str);
    }
}
