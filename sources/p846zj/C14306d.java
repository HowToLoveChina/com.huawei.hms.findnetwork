package p846zj;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hms.network.embedded.C5863b6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import okhttp3.C11918e0;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p618rm.C12540b1;
import p664u0.C13108a;
import p681uj.C13195l;
import p709vj.C13452e;
import p709vj.C13453f;
import p742wj.C13615e;

/* renamed from: zj.d */
/* loaded from: classes5.dex */
public class C14306d {

    /* renamed from: zj.d$a */
    public class a extends TypeToken<List<PortraitAndGrade.UserTagWithoutName>> {
    }

    /* renamed from: zj.d$b */
    public class b extends TypeToken<List<PortraitAndGrade.UserTag>> {
    }

    /* renamed from: zj.d$c */
    public static class c extends Handler {

        /* renamed from: a */
        public CountDownLatch f63563a;

        /* renamed from: b */
        public d f63564b;

        public c(CountDownLatch countDownLatch, d dVar) {
            super(Looper.getMainLooper());
            this.f63563a = countDownLatch;
            this.f63564b = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 20000) {
                AbstractC10896a.m65887i("AccountUtil", "getAccountInfo fail");
                this.f63564b.m85227b(1);
            } else if (i10 != 20001) {
                AbstractC10896a.m65887i("AccountUtil", "getAccountInfo, msg not correct");
                this.f63564b.m85227b(1);
            } else {
                AbstractC10896a.m65887i("AccountUtil", "getAccountInfosuccess");
                this.f63564b.m85227b(0);
            }
            CountDownLatch countDownLatch = this.f63563a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* renamed from: zj.d$d */
    public static class d {

        /* renamed from: a */
        public int f63565a;

        public d(int i10) {
            this.f63565a = i10;
        }

        /* renamed from: a */
        public int m85226a() {
            return this.f63565a;
        }

        /* renamed from: b */
        public void m85227b(int i10) {
            this.f63565a = i10;
        }
    }

    /* renamed from: b */
    public static String m85201b() {
        if (C0213f.m1377a() == null) {
            return "";
        }
        String strM80895c = C13452e.m80781L().m80895c();
        long jM80865V = C13452e.m80781L().m80865V();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(strM80895c) || jCurrentTimeMillis - jM80865V < C5863b6.g.f26453g) {
            return strM80895c;
        }
        String strM85214o = m85214o();
        AbstractC10896a.m65887i("AccountUtil", "getDeviceAccountBrand from provider, accountBrand: " + strM85214o);
        return strM85214o;
    }

    /* renamed from: c */
    public static int m85202c() {
        Context contextM1377a = C0213f.m1377a();
        try {
            String strM79270H = C13195l.m79270H(contextM1377a);
            if (TextUtils.isEmpty(strM79270H)) {
                AbstractC10896a.m65886e("AccountUtil", "hmsPackage is invalid!");
                return 0;
            }
            int i10 = contextM1377a.getPackageManager().getPackageInfo(strM79270H, 16384).versionCode;
            AbstractC10896a.m65887i("AccountUtil", "hmsVersion:" + i10);
            return i10;
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC10896a.m65887i("AccountUtil", "getHmsVersion PackageManager.NameNotFoundException");
            return 0;
        }
    }

    /* renamed from: d */
    public static String m85203d(String str) {
        try {
            List list = (List) new Gson().fromJson(str, new a().getType());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UserTag{");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb2.append(((PortraitAndGrade.UserTagWithoutName) it.next()).getUserGroupExtID() + ", ");
            }
            sb2.append("}");
            return sb2.toString();
        } catch (Exception unused) {
            return "getTagsId error";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* renamed from: e */
    public static List<PortraitAndGrade.UserTag> m85204e() {
        String strM80979v0;
        ArrayList arrayList = new ArrayList();
        try {
            strM80979v0 = C13452e.m80781L().m80979v0();
        } catch (Exception unused) {
        }
        if (strM80979v0 == null) {
            return arrayList;
        }
        ?? r32 = (List) C12540b1.m75484b(strM80979v0, new b().getType());
        if (r32 == 0) {
            try {
                arrayList = new ArrayList();
            } catch (Exception unused2) {
                arrayList = r32;
                AbstractC10896a.m65886e("AccountUtil", " getUserTagListFromSp JsonSyntaxException");
                return arrayList;
            }
        } else {
            arrayList = r32;
        }
        AbstractC10896a.m65887i("AccountUtil", "getUserTagsUseCache, userTags is " + m85203d(strM80979v0));
        return arrayList;
    }

    /* renamed from: f */
    public static String m85205f(final List<String> list, List<PortraitAndGrade.UserTag> list2) {
        if (list == null || list.size() == 0) {
            AbstractC10896a.m65887i("AccountUtil", "omGrayUserTags is empty");
            return "";
        }
        if (list2 == null || list2.isEmpty()) {
            AbstractC10896a.m65887i("AccountUtil", "userTags is empty");
            return "";
        }
        String str = (String) list2.stream().map(new Function() { // from class: zj.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((PortraitAndGrade.UserTag) obj).getUserGroupExtID();
            }
        }).filter(new Predicate() { // from class: zj.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return list.contains((String) obj);
            }
        }).collect(Collectors.joining(","));
        AbstractC10896a.m65887i("AccountUtil", "getUserTags grayUserTags:" + str);
        return str;
    }

    /* renamed from: g */
    public static boolean m85206g(Context context) {
        if (context == null) {
            BaseLogger.m28735w("AccountUtil", "isAccountLogin context is null");
            return false;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            BaseLogger.m28735w("AccountUtil", "isAccountLogin can not run in the main thread");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/has_login");
        if (!C0209d.m1227Y1(context, uri)) {
            AbstractC10896a.m65886e("AccountUtil", "is not Target App or System App");
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, null, null, null, null);
            } catch (RuntimeException unused) {
                BaseLogger.m28735w("AccountUtil", "isAccountLogin Exception");
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return false;
            }
            if (1 == cursorQuery.getInt(cursorQuery.getColumnIndex("hasLogin"))) {
                cursorQuery.close();
                return true;
            }
            cursorQuery.close();
            return false;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: h */
    public static boolean m85207h() {
        return "CN".equals(C13452e.m80781L().m80942m());
    }

    /* renamed from: i */
    public static boolean m85208i() {
        String strM80942m = C13452e.m80781L().m80942m();
        return strM80942m != null && C13453f.m80998a().contains(strM80942m.toUpperCase(Locale.getDefault()));
    }

    /* renamed from: j */
    public static boolean m85209j() {
        if (!C13452e.m80781L().m80842P0()) {
            AbstractC10896a.m65886e("AccountUtil", "queryAccountBrand, cloud not login");
            return false;
        }
        if (m85202c() >= 50008100) {
            return true;
        }
        AbstractC10896a.m65888w("AccountUtil", "HMS not support query account brand");
        C13452e.m80781L().m80997z2(System.currentTimeMillis());
        return false;
    }

    /* renamed from: k */
    public static boolean m85210k() {
        if (!C13452e.m80781L().m80842P0()) {
            AbstractC10896a.m65886e("AccountUtil", "queryChildAccount, cloud not login");
            return false;
        }
        if (m85202c() >= 50001000) {
            return true;
        }
        AbstractC10896a.m65888w("AccountUtil", "HMS not support query child account");
        return false;
    }

    /* renamed from: l */
    public static boolean m85211l() {
        if (m85202c() >= 50100300) {
            return true;
        }
        AbstractC10896a.m65888w("AccountUtil", "HMS not support return status code 2012");
        return false;
    }

    /* renamed from: n */
    public static void m85213n(C11918e0.a aVar) {
        String strM1160D = C0209d.m1160D();
        if (!TextUtils.isEmpty(strM1160D)) {
            aVar.m71574a("x-hw-device-brand", strM1160D);
        }
        String strM1164E = C0209d.m1164E();
        if (!TextUtils.isEmpty(strM1164E)) {
            aVar.m71574a("x-hw-device-manufacturer", strM1164E);
        }
        String strM85201b = m85201b();
        if (!TextUtils.isEmpty(strM85201b)) {
            aVar.m71574a("x-hw-account-brand-id", strM85201b);
        }
        String strM1156C = C0209d.m1156C();
        if (TextUtils.isEmpty(strM1156C)) {
            return;
        }
        aVar.m71574a("x-hw-app-brand-id", strM1156C);
    }

    /* renamed from: o */
    public static String m85214o() {
        if (!m85209j()) {
            AbstractC10896a.m65886e("AccountUtil", "queryAccountBrand, not support query");
            return "";
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "queryAccountBrand, context is null");
            return "";
        }
        ContentResolver contentResolver = contextM1377a.getContentResolver();
        Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/queryAccountBrand");
        if (!C0209d.m1227Y1(contextM1377a, uri)) {
            AbstractC10896a.m65886e("AccountUtil", "is not Target App or System App");
            return "";
        }
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(0);
                        C13452e.m80781L().m80996z1(string);
                        C13452e.m80781L().m80997z2(0L);
                        AbstractC10896a.m65887i("AccountUtil", "queryAccountBrand, accountBrand " + string);
                        cursorQuery.close();
                        return string;
                    }
                } finally {
                }
            }
            AbstractC10896a.m65887i("AccountUtil", "queryAccountBrand cursor is null");
            C13452e.m80781L().m80997z2(System.currentTimeMillis());
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("AccountUtil", "exception hwidProvider queryAccountBrand: " + e10.getClass().getSimpleName());
        }
        return "";
    }

    /* renamed from: p */
    public static int m85215p() {
        if (!m85210k()) {
            AbstractC10896a.m65886e("AccountUtil", "queryIsChildAccount, not support query");
            return -1;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "queryIsChildAccount, context is null");
            return -1;
        }
        ContentResolver contentResolver = contextM1377a.getContentResolver();
        Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/child_mode_on");
        if (!C0209d.m1227Y1(contextM1377a, uri)) {
            AbstractC10896a.m65886e("AccountUtil", "is not Target App or System App");
            return -1;
        }
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("isChildMode"));
                        AbstractC10896a.m65887i("AccountUtil", "queryIsChildMode, childMode : " + i10);
                        cursorQuery.close();
                        return i10;
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("AccountUtil", "exception hwidProvider queryIsChildAccount: " + e10.getClass().getSimpleName());
        }
        return -1;
    }

    /* renamed from: q */
    public static String m85216q(List<String> list) {
        if (list == null || list.size() == 0) {
            AbstractC10896a.m65888w("AccountUtil", "omGrayUserTags is empty!");
            C13452e.m80781L().m80903d2("");
            return null;
        }
        AbstractC10896a.m65887i("AccountUtil", "omGrayUserTags:" + list);
        List<PortraitAndGrade.UserTag> listM85204e = m85204e();
        if (listM85204e != null && !listM85204e.isEmpty()) {
            return m85219t(list, listM85204e);
        }
        AbstractC10896a.m65888w("AccountUtil", "realUserTags is empty!");
        C13452e.m80781L().m80903d2("");
        return null;
    }

    /* renamed from: r */
    public static void m85217r(Context context, Handler handler, boolean z10) {
        if (handler == null) {
            AbstractC10896a.m65886e("AccountUtil", "getUserInfoForPay accountInfoHandler is null");
            return;
        }
        if (z10) {
            if (System.currentTimeMillis() - C13452e.m80781L().m80926i0() < 1800000) {
                handler.sendEmptyMessage(20001);
                return;
            }
        }
        if (context != null) {
            C13195l.m79272J().m79343x0(new C13615e(handler));
        } else {
            AbstractC10896a.m65886e("AccountUtil", "getUserInfoForPay context is null.");
            handler.sendEmptyMessage(20000);
        }
    }

    /* renamed from: s */
    public static int m85218s() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d dVar = new d(1);
        m85217r(C0213f.m1377a(), new c(countDownLatch, dVar), true);
        try {
            if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65885d("AccountUtil", "wait not finish");
                dVar.m85227b(2);
            }
        } catch (InterruptedException e10) {
            dVar.m85227b(1);
            AbstractC10896a.m65888w("AccountUtil", "getAccountInfo wait catch InterruptedException. e = " + e10.toString());
        }
        return dVar.m85226a();
    }

    /* renamed from: t */
    public static String m85219t(List<String> list, List<PortraitAndGrade.UserTag> list2) {
        String strM85205f = m85205f(list, list2);
        C13452e.m80781L().m80903d2(strM85205f);
        AbstractC10896a.m65887i("AccountUtil", "refreshUserTags2Sp grayUserTags:" + strM85205f);
        return strM85205f;
    }

    /* renamed from: u */
    public static void m85220u(int i10, boolean z10, Serializable serializable) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendNotifyAccountInfoBroadcast context null");
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.actoin.ACTION_SEND_BACKUP_CYCLE_NOTIFY");
        intent.putExtra("un_backup_weeks", i10);
        intent.putExtra("is_show_local", z10);
        intent.putExtra("user_tags_key", serializable);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    /* renamed from: v */
    public static void m85221v(String str) {
        AbstractC10896a.m65887i("AccountUtil", "sendLocalBroadcast action:" + str);
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendLocalBroadcast context null");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("AccountUtil", "action is null");
        } else {
            C13108a.m78878b(contextM1377a).m78881d(new Intent(str));
        }
    }

    /* renamed from: w */
    public static void m85222w(Bundle bundle) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendLoginBroadcast context null");
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.action.ON_LOGIN");
        intent.putExtras(bundle);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    /* renamed from: x */
    public static void m85223x() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendOpenPushSuccessBroadcast context null");
            return;
        }
        AbstractC10896a.m65887i("AccountUtil", "sendOpenPushSuccessBroadcast");
        C13108a.m78878b(contextM1377a).m78881d(new Intent("com.huawei.hicloud.actoin.OPEN_PUSH_SUCCESS"));
    }

    /* renamed from: y */
    public static void m85224y(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendNotifyAccountInfoBroadcast context null");
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.actoin.PUSH_TOKEN_SUCCESS");
        intent.putExtra("push_token", str);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    /* renamed from: z */
    public static void m85225z(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("AccountUtil", "sendNotifyAccountInfoBroadcast context null");
            return;
        }
        Intent intent = new Intent("om.huawei.hicloud.actoin.URGENCY_NOTICE");
        intent.putExtra("push_token", str);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }
}
