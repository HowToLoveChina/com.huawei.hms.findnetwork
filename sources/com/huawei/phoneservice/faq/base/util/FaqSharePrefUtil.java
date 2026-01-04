package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public final class FaqSharePrefUtil {

    @Keep
    public static final String FAQ_IPCC_FILENAME = "FAQ_IPCC_FILENAME";

    @Keep
    public static final String FAQ_IPCC_KEY = "FAQ_IPCC_KEY";

    @Keep
    public static final String FAQ_IPCC_TYPE = "FAQ_IPCC_TYPE";

    /* renamed from: a */
    public static String m51876a(Context context) {
        return context != null ? context.getSharedPreferences("FAQ_LANGUAGE_FILE_NAME", 0).getString(FaqConstants.FAQ_EMUI_LANGUAGE, "") : "";
    }

    /* renamed from: b */
    public static void m51877b(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("FAQ_LANGUAGE_FILE_NAME", 0).edit();
            editorEdit.putString(FaqConstants.FAQ_EMUI_LANGUAGE, str);
            editorEdit.commit();
        }
    }

    /* renamed from: c */
    public static String m51878c(Context context) {
        return context != null ? context.getSharedPreferences("FAQ_MODULE_FILE_NAME", 0).getString(FaqConstants.FAQ_MODULE, "") : "";
    }

    /* renamed from: d */
    public static void m51879d(Context context, String str) throws Throwable {
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("FAQ_MODULE_FILE_NAME", 0).edit();
                editorEdit.putString(FaqConstants.FAQ_MODULE, str);
                editorEdit.commit();
            } catch (Exception e10) {
                FaqLogger.m51840e("FaqSharePrefUtil", e10.getMessage());
            }
        }
    }

    @Keep
    public static void delete(Context context, String str, String str2) throws Throwable {
        if (context == null) {
            FaqLogger.m51840e("FaqSharePrefUtil", "delete context is null");
            return;
        }
        if (FaqStringUtil.isEmpty(str)) {
            str = FaqConstants.COMMON_FILE;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences == null) {
            FaqLogger.m51840e("FaqSharePrefUtil", "delete sharedPreferences is null");
            return;
        }
        if (sharedPreferences.contains(str2)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                FaqLogger.m51840e("FaqSharePrefUtil", "delete editor is null");
            } else {
                editorEdit.remove(str2);
                editorEdit.apply();
            }
        }
    }

    @Keep
    public static <T> T getModuleListBeanList(Context context, String str, String str2, Type type) throws Throwable {
        String string = getString(context, str, str2, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (T) new Gson().fromJson(string, type);
        } catch (JsonParseException e10) {
            FaqLogger.m51840e("FaqSharePrefUtil", e10.getMessage());
            return null;
        }
    }

    @Keep
    public static String getString(Context context, String str, String str2, String str3) {
        if (context == null) {
            return str3;
        }
        if (FaqStringUtil.isEmpty(str)) {
            str = FaqConstants.COMMON_FILE;
        }
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    @Keep
    public static void save(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            if (FaqStringUtil.isEmpty(str)) {
                str = FaqConstants.COMMON_FILE;
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, str3);
            editorEdit.apply();
        } catch (Exception e10) {
            FaqLogger.m51840e("FaqSharePrefUtil", e10.getMessage());
        }
    }
}
