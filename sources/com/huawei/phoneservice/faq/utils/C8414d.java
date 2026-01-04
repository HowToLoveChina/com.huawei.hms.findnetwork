package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqSharePrefUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faqcommon.utils.FaqImageUtil;
import com.tencent.p204mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p204mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.phoneservice.faq.utils.d */
/* loaded from: classes4.dex */
public class C8414d {

    /* renamed from: com.huawei.phoneservice.faq.utils.d$a */
    public class a extends TypeToken<List<String>> {
    }

    /* renamed from: com.huawei.phoneservice.faq.utils.d$b */
    public class b extends TypeToken<List<String>> {
    }

    /* renamed from: a */
    public static String m52379a() {
        return "SEARCH_KEY2" + FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
    }

    /* renamed from: b */
    public static List<String> m52380b(Context context) {
        return (List) FaqSharePrefUtil.getModuleListBeanList(context, "SEARCH_FILE_NAME", m52379a(), new b().getType());
    }

    /* renamed from: c */
    public static void m52381c(String str, Activity activity, String str2, String str3) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2 + "  " + str3);
        intent.setType(InterfaceC5483d.f25083i);
        try {
            activity.startActivity(Intent.createChooser(intent, activity.getResources().getString(R$string.faq_sdk_shareto)));
        } catch (ActivityNotFoundException e10) {
            FaqLogger.m51840e("FaqShareUtil", e10.getMessage());
        }
        FaqTrack.event(str + "+SDK+Detail", "Share", String.format(Locale.getDefault(), "%1$s", str2));
    }

    /* renamed from: d */
    public static void m52382d(String str, IWXAPI iwxapi, int i10, Context context, String str2, String str3, String str4, byte[] bArr) throws Throwable {
        if (!iwxapi.isWXAppInstalled()) {
            FaqToastUtils.makeText(context, context.getResources().getString(R$string.faq_sdk_wx_uninstall));
            return;
        }
        iwxapi.registerApp(str);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str3;
        wXMediaMessage.thumbData = bArr;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = i10;
        iwxapi.sendReq(req);
    }

    /* renamed from: e */
    public static void m52383e(String str, IWXAPI iwxapi, Context context, String str2, String str3, String str4, byte[] bArr) throws Throwable {
        m52382d(str, iwxapi, 1, context, str2, str3, str4, bArr);
    }

    /* renamed from: f */
    public static byte[] m52384f(Context context, String str) throws Throwable {
        String message;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(str));
            byte[] bArrM52385g = m52385g(bitmapDecodeResource);
            return bArrM52385g.length > 32768 ? FaqImageUtil.compressImage(bitmapDecodeResource) : bArrM52385g;
        } catch (OutOfMemoryError e10) {
            message = "compressBitmap failed because of " + e10.getMessage();
            FaqLogger.m51840e("FaqShareUtil", message);
            return null;
        } catch (Throwable th2) {
            message = th2.getMessage();
            FaqLogger.m51840e("FaqShareUtil", message);
            return null;
        }
    }

    /* renamed from: g */
    public static byte[] m52385g(Bitmap bitmap) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
            FaqLogger.m51840e("FaqShareUtil", "IOException");
        }
        return byteArray;
    }

    /* renamed from: h */
    public static void m52386h(Context context, String str) {
        if (!ModuleConfigUtils.searchHistoryEnabled() || str == null) {
            return;
        }
        List arrayList = (List) FaqSharePrefUtil.getModuleListBeanList(context, "SEARCH_FILE_NAME", m52379a(), new a().getType());
        if (arrayList != null) {
            if (arrayList.indexOf(str) != -1) {
                arrayList.remove(str);
            }
            arrayList.add(0, str);
            if (arrayList.size() > 5) {
                arrayList.remove(arrayList.size() - 1);
            }
        } else {
            arrayList = new ArrayList();
            arrayList.add(str);
        }
        FaqSharePrefUtil.save(context, "SEARCH_FILE_NAME", m52379a(), new Gson().toJson(arrayList));
    }

    /* renamed from: i */
    public static void m52387i(String str, IWXAPI iwxapi, Context context, String str2, String str3, String str4, byte[] bArr) throws Throwable {
        m52382d(str, iwxapi, 0, context, str2, str3, str4, bArr);
    }
}
