package com.huawei.hms.network.embedded;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.check.ProviderCheckUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.network.abtest.ABHelper;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.utils.CheckConfigUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.j */
/* loaded from: classes8.dex */
public class C5963j {

    /* renamed from: h */
    public static final String f27039h = "ConfigManager";

    /* renamed from: i */
    public static final String f27040i = "content://com.huawei.hms.contentprovider/com.huawei.hms.networkkit/remoteconfig";

    /* renamed from: j */
    public static final String f27041j = "retCode";

    /* renamed from: k */
    public static final String f27042k = "retDesc";

    /* renamed from: l */
    public static final int f27043l = 100301;

    /* renamed from: m */
    public static final String f27044m = "getConfig";

    /* renamed from: n */
    public static final String f27045n = "remote_configs";

    /* renamed from: o */
    public static final int f27046o = 5000;

    /* renamed from: p */
    public static final int f27047p = 10000;

    /* renamed from: q */
    public static final int f27048q = 500;

    /* renamed from: u */
    public static final String f27052u = "_";

    /* renamed from: v */
    public static final String f27053v = "get_config_time";

    /* renamed from: w */
    public static final String f27054w = "get_ab_time";

    /* renamed from: y */
    public static final String f27056y = "share_pre_config";

    /* renamed from: a */
    public Map<String, AbstractC6002m> f27057a;

    /* renamed from: b */
    public Map<String, Object> f27058b;

    /* renamed from: c */
    public String f27059c;

    /* renamed from: d */
    public String f27060d;

    /* renamed from: e */
    public ExecutorService f27061e;

    /* renamed from: f */
    public PLSharedPreferences f27062f;

    /* renamed from: g */
    public volatile CountDownLatch f27063g;

    /* renamed from: s */
    public static final String f27050s = "profile_base";

    /* renamed from: r */
    public static final String f27049r = "profile_restful";

    /* renamed from: t */
    public static final String f27051t = "profile_filemanager";

    /* renamed from: x */
    public static final List<String> f27055x = Collections.unmodifiableList(Arrays.asList(f27050s, f27049r, f27051t));

    /* renamed from: com.huawei.hms.network.embedded.j$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27064a;

        static {
            int[] iArr = new int[EnumC6054q.values().length];
            f27064a = iArr;
            try {
                iArr[EnumC6054q.RESTFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27064a[EnumC6054q.FILE_MANAGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27064a[EnumC6054q.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.j$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ABHelper.getInstance().fetchABInfo();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.j$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public final C5950i f27066a;

        public c(C5950i c5950i) {
            this.f27066a = c5950i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.m32144v(C5963j.f27039h, "remote config sdk report data to aiops is: %s", new JSONObject(this.f27066a.get()));
            HianalyticsHelper.getInstance().onEvent(this.f27066a.get(), C5950i.f26981b);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.j$d */
    public static class d {

        /* renamed from: a */
        public static C5963j f27067a = new C5963j(null);
    }

    /* renamed from: com.huawei.hms.network.embedded.j$e */
    public class e implements Runnable {

        /* renamed from: a */
        public Context f27068a;

        public e(Context context) {
            this.f27068a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    C5963j.this.m34438b(this.f27068a);
                } catch (Exception unused) {
                    Logger.m32138e(C5963j.f27039h, "updateConfigs has an exception");
                }
            } finally {
                C5963j.this.f27063g.countDown();
            }
        }
    }

    public C5963j() {
        this.f27061e = ExecutorsUtils.newSingleThreadExecutor("CfgManager");
        this.f27058b = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f27057a = concurrentHashMap;
        EnumC5989l enumC5989l = EnumC5989l.REMOTE_AGC;
        concurrentHashMap.put(f27050s, new C6015n(enumC5989l));
        this.f27057a.put(f27049r, new C6041p(enumC5989l));
        this.f27057a.put(f27051t, new C6028o(enumC5989l));
    }

    /* renamed from: a */
    private long m34426a(Object obj) {
        return StringUtils.stringToLong(String.valueOf(obj), 0L);
    }

    /* renamed from: b */
    private Object m34436b(String str, EnumC6054q enumC6054q) {
        return m34427a(str, enumC6054q);
    }

    /* renamed from: c */
    private Object m34440c(String str) {
        return this.f27058b.get(str);
    }

    /* renamed from: d */
    private int m34444d() {
        String str = (String) this.f27058b.get("core_configversion");
        if (str == null) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb2.append(str2);
        }
        return Integer.parseInt(sb2.toString());
    }

    /* renamed from: e */
    public static C5963j m34447e() {
        return d.f27067a;
    }

    /* renamed from: f */
    private boolean m34448f() {
        return this.f27062f.getLong(f27054w, -1L) == ABHelper.getInstance().getLastUpdateAbTime();
    }

    /* renamed from: g */
    private boolean m34449g() {
        Object value;
        Object obj = this.f27058b.get(f27053v);
        return obj == null || (value = ConfigAPI.getValue(PolicyNetworkService.GlobalConstants.CONFIG_EXPIRED_TIME)) == null || ((Long) obj).longValue() + (m34426a(value) * 1000) <= System.currentTimeMillis();
    }

    /* renamed from: h */
    private boolean m34450h() {
        Object objM34440c = m34440c(C5976k.f27156e);
        if (objM34440c instanceof String) {
            return Boolean.parseBoolean((String) objM34440c);
        }
        if (objM34440c instanceof Boolean) {
            return ((Boolean) objM34440c).booleanValue();
        }
        return false;
    }

    /* renamed from: i */
    private void m34451i() {
        Object value = ConfigAPI.getValue(PolicyNetworkService.GlobalConstants.AB_EXPIRED_TIME);
        if (value == null) {
            return;
        }
        ABHelper.getInstance().setAbExpiredTime(StringUtils.stringToLong(String.valueOf(value), 0L));
    }

    /* renamed from: j */
    private void m34452j() {
        this.f27062f.putLong(f27053v, System.currentTimeMillis());
    }

    public /* synthetic */ C5963j(a aVar) {
        this();
    }

    /* renamed from: b */
    private void m34437b() {
        Object obj = this.f27058b.get("core_connect_timeout");
        Object obj2 = this.f27058b.get("core_concurrent_connect_delay");
        if (obj == null || obj2 == null) {
            return;
        }
        int i10 = 10000;
        int iStringToInteger = StringUtils.stringToInteger(String.valueOf(obj), 10000);
        int i11 = 500;
        int iStringToInteger2 = StringUtils.stringToInteger(String.valueOf(obj2), 500);
        if (iStringToInteger2 >= iStringToInteger) {
            Logger.m32136d(f27039h, "concurrent_connect_delay :" + iStringToInteger2 + ",is not less than connect_timeout: " + iStringToInteger + ",reset the two values to the default values");
        } else {
            i10 = iStringToInteger;
            i11 = iStringToInteger2;
        }
        this.f27058b.put("core_connect_timeout", Integer.valueOf(i10));
        this.f27058b.put("core_concurrent_connect_delay", Integer.valueOf(i11));
    }

    /* renamed from: c */
    private Object m34441c(String str, EnumC6054q enumC6054q) {
        try {
            return m34445d(str.toLowerCase(Locale.ENGLISH), enumC6054q);
        } catch (Exception unused) {
            Logger.m32138e(f27039h, "search configs occurs error, return default config");
            return null;
        }
    }

    /* renamed from: d */
    private Object m34445d(String str, EnumC6054q enumC6054q) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (!EnumC6054q.DEFAULT.name().equals(enumC6054q.name()) && this.f27063g != null && this.f27063g.getCount() > 0) {
            try {
                try {
                    if (!this.f27063g.await(1L, TimeUnit.SECONDS)) {
                        Logger.m32145w(f27039h, "Wait timeout!");
                    }
                } catch (InterruptedException unused) {
                    Logger.m32138e(f27039h, "InterruptedException,countDownLatch await error !");
                }
            } finally {
                this.f27063g.countDown();
            }
        }
        if (!TextUtils.equals("core_configversion", lowerCase) && m34450h() && m34444d() >= 100301) {
            return m34436b(lowerCase, enumC6054q);
        }
        return m34440c(lowerCase);
    }

    /* renamed from: a */
    public Bundle m34453a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Uri uri = Uri.parse(f27040i);
        if (!ProviderCheckUtil.isValid(uri)) {
            Logger.m32145w(f27039h, "package name is invalid");
            return null;
        }
        bundle.putString(C6110u3.f28491p, "content://com.huawei.hms.networkkit");
        bundle.putString("appversion", this.f27060d);
        try {
            return context.getContentResolver().call(uri, str, str2, bundle);
        } catch (RuntimeException unused) {
            Logger.m32138e(f27039h, "remote config base service kit not exist ");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(f27041j, C5950i.f26986g);
            bundle2.putString(f27042k, "cross process call failed");
            return bundle2;
        }
    }

    /* renamed from: b */
    public void m34438b(Context context) throws JSONException {
        Bundle bundleM34453a;
        boolean zIsExpired = false;
        boolean zM34448f = true;
        boolean z10 = ReflectionUtils.isAbTestEnable() && ABHelper.getInstance().isInAllowList(String.valueOf(ConfigAPI.getValue(PolicyNetworkService.GlobalConstants.AB_ALLOWED_LIST)));
        boolean zM34449g = m34449g();
        if (z10) {
            ABHelper.getInstance().init();
            m34451i();
            zIsExpired = ABHelper.getInstance().isExpired();
            zM34448f = m34448f();
        }
        Logger.m32142i(f27039h, "isAbTestEnable:%s, isRemoteConfigExpired:%s, isAbConfigExpired:%s", Boolean.valueOf(z10), Boolean.valueOf(zM34449g), Boolean.valueOf(zIsExpired));
        if (!m34435a(z10, zM34449g, zIsExpired, zM34448f)) {
            Logger.m32141i(f27039h, "config is not expired");
            this.f27063g.countDown();
            return;
        }
        if (zM34449g) {
            Logger.m32141i(f27039h, "update configs");
            bundleM34453a = m34453a(context, f27044m, this.f27059c, (Bundle) null);
            this.f27062f.putString(f27045n, BundleUtil.bundleToJson(bundleM34453a));
            m34452j();
        } else {
            bundleM34453a = BundleUtil.jsonToBundle(this.f27062f.getString(f27045n));
        }
        if (bundleM34453a == null) {
            bundleM34453a = new Bundle();
        }
        Logger.m32144v(f27039h, "remoteConfigs:%s", bundleM34453a);
        if (z10) {
            Map abParamsMap = ABHelper.getInstance().getAbParamsMap();
            Logger.m32144v(f27039h, "abConfigs:%s", abParamsMap);
            for (String str : abParamsMap.keySet()) {
                bundleM34453a.putString(str, (String) abParamsMap.get(str));
            }
            Logger.m32144v(f27039h, "after the merger remoteConfigs:%s", bundleM34453a);
            this.f27062f.putLong(f27054w, ABHelper.getInstance().getLastUpdateAbTime());
        }
        m34442c();
        m34439b(bundleM34453a);
        m34443c(bundleM34453a);
        this.f27063g.countDown();
        m34431a(bundleM34453a);
        if (z10 && zIsExpired) {
            InitReport.executeDelay(new b());
        }
    }

    /* renamed from: c */
    private void m34442c() {
        String string = this.f27062f.getString(C5950i.f26985f);
        String string2 = this.f27062f.getString(f27045n);
        long j10 = this.f27062f.getLong(f27053v, -1L);
        long j11 = this.f27062f.getLong(f27054w, -1L);
        this.f27062f.clear();
        m34456b(string);
        this.f27062f.putString(f27045n, string2);
        this.f27062f.putLong(f27053v, j10);
        this.f27062f.putLong(f27054w, j11);
    }

    /* renamed from: d */
    private JSONObject m34446d(String str) {
        try {
            return TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
        } catch (JSONException unused) {
            Logger.m32138e(f27039h, "call method stringToJson occur JSONException");
            return null;
        }
    }

    /* renamed from: a */
    public Object m34454a(String str) {
        EnumC6054q enumC6054q;
        if (str == null || str.length() == 0) {
            return null;
        }
        Logger.m32136d(f27039h, "getValue:" + str);
        if (str.contains("|")) {
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length != 2) {
                return null;
            }
            if (TextUtils.equals(strArrSplit[0], PolicyNetworkService.ProfileConstants.RESTFUL)) {
                str = strArrSplit[1];
                enumC6054q = EnumC6054q.RESTFUL;
            } else if (TextUtils.equals(strArrSplit[0], PolicyNetworkService.ProfileConstants.FILE_MANAGER)) {
                str = strArrSplit[1];
                enumC6054q = EnumC6054q.FILE_MANAGER;
            } else {
                str = strArrSplit[1];
                enumC6054q = EnumC6054q.DEFAULT;
            }
        } else {
            enumC6054q = EnumC6054q.DEFAULT;
        }
        return m34441c(str, enumC6054q);
    }

    /* renamed from: a */
    private Object m34427a(String str, EnumC6054q enumC6054q) {
        String str2;
        int i10 = a.f27064a[enumC6054q.ordinal()];
        if (i10 == 1) {
            str2 = f27049r;
        } else if (i10 == 2) {
            str2 = f27051t;
        } else {
            if (i10 != 3) {
                return null;
            }
            str2 = f27050s;
        }
        return m34428a(str2, str);
    }

    /* renamed from: b */
    private void m34439b(Bundle bundle) {
        this.f27058b.clear();
        for (String str : C5976k.m34556b().m34559a()) {
            Object obj = bundle.get(str);
            if (obj != null && CheckConfigUtils.checkIsCorrect(str, obj)) {
                this.f27058b.put(str, obj);
                Logger.m32137d(f27039h, "put independentConfigs key: %s, value: %s", str, obj);
            }
        }
        Map<String, Object> map = this.f27058b;
        if (map == null || map.size() == 0) {
            return;
        }
        m34437b();
        try {
            for (String str2 : this.f27058b.keySet()) {
                this.f27062f.putString(str2, String.valueOf(this.f27058b.get(str2)));
            }
        } catch (RuntimeException | Exception unused) {
            m34434a("sharedPreferences put failed", C5950i.f26988i);
        }
    }

    /* renamed from: c */
    private void m34443c(Bundle bundle) throws JSONException {
        this.f27057a.clear();
        Map<String, AbstractC6002m> map = this.f27057a;
        EnumC5989l enumC5989l = EnumC5989l.REMOTE_AGC;
        map.put(f27050s, new C6015n(enumC5989l));
        this.f27057a.put(f27049r, new C6041p(enumC5989l));
        this.f27057a.put(f27051t, new C6028o(enumC5989l));
        if (m34450h()) {
            for (String str : f27055x) {
                if (this.f27058b.containsKey(str)) {
                    m34433a(this.f27057a.get(str), (String) this.f27058b.get(str));
                    this.f27058b.remove(str);
                }
            }
            Map<String, AbstractC6002m> map2 = this.f27057a;
            if (map2 == null || map2.size() <= 0) {
                return;
            }
            m34430a();
        }
    }

    /* renamed from: a */
    private Object m34428a(String str, String str2) {
        if (this.f27057a.get(str).m34735d()) {
            return null;
        }
        return this.f27057a.get(str).m34728a(str2);
    }

    /* renamed from: b */
    public void m34456b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27062f.putString(C5950i.f26985f, str);
    }

    /* renamed from: a */
    private void m34430a() {
        for (String str : f27055x) {
            AbstractC6002m abstractC6002m = this.f27057a.get(str);
            Map<String, Object> mapM34729a = abstractC6002m.m34729a();
            Object obj = mapM34729a.get("core_connect_timeout");
            Object obj2 = mapM34729a.get("core_concurrent_connect_delay");
            if (obj != null && obj2 != null) {
                int i10 = 10000;
                int iStringToInteger = StringUtils.stringToInteger(String.valueOf(obj), 10000);
                int i11 = 500;
                int iStringToInteger2 = StringUtils.stringToInteger(String.valueOf(obj2), 500);
                if (iStringToInteger2 >= iStringToInteger) {
                    Logger.m32136d(f27039h, "concurrent_connect_delay :" + iStringToInteger2 + ",is not less than connect_timeout: " + iStringToInteger + ",reset the two values to the default values");
                } else {
                    i11 = iStringToInteger2;
                    i10 = iStringToInteger;
                }
                abstractC6002m.m34731a("core_connect_timeout", Integer.valueOf(i10));
                abstractC6002m.m34731a("core_concurrent_connect_delay", Integer.valueOf(i11));
            }
            this.f27057a.put(str, abstractC6002m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00da  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m34455a(android.content.Context r7) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5963j.m34455a(android.content.Context):void");
    }

    /* renamed from: a */
    private void m34431a(Bundle bundle) {
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            C5950i c5950i = new C5950i();
            c5950i.put("error_code", bundle.getInt(f27041j));
            c5950i.put(C5950i.f26983d, bundle.getString(f27042k));
            c5950i.put("config_version", bundle.getString("core_configversion"));
            String string = this.f27062f.getString(C5950i.f26985f);
            if (!TextUtils.isEmpty(string)) {
                c5950i.put(C5950i.f26985f, string);
            }
            InitReport.reportWhenInit(new c(c5950i));
            Logger.m32136d(f27039h, "add to init report ConfigHianalyticsData：" + c5950i.toString());
        }
    }

    /* renamed from: a */
    private void m34433a(AbstractC6002m abstractC6002m, String str) throws JSONException {
        Object obj;
        Logger.m32137d(f27039h, "parseJsonStr: %s", str);
        JSONObject jSONObjectM34446d = m34446d(str);
        if (jSONObjectM34446d != null) {
            Iterator<String> itKeys = jSONObjectM34446d.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    obj = jSONObjectM34446d.get(next);
                } catch (JSONException e10) {
                    Logger.m32140e(f27039h, "JSONException: %s", e10.getMessage());
                    obj = null;
                }
                if (next.startsWith(C5976k.f27152a)) {
                    next = next.substring(11);
                }
                if (CheckConfigUtils.checkIsCorrect(next, obj)) {
                    abstractC6002m.m34731a(next, obj);
                    Logger.m32137d(f27039h, "put key: %s, value: %s", next, obj);
                }
            }
        }
    }

    /* renamed from: a */
    private void m34434a(String str, int i10) {
        Logger.m32138e(f27039h, str);
        Bundle bundle = new Bundle();
        bundle.putInt(f27041j, i10);
        bundle.putString(f27042k, str);
        m34431a(bundle);
    }

    /* renamed from: a */
    private boolean m34435a(boolean z10, boolean z11, boolean z12, boolean z13) {
        String str;
        if (z11) {
            str = "remote config expired";
        } else if (z10 && z12) {
            str = "ab config expired";
        } else {
            if (!z10 || z13) {
                return false;
            }
            str = "ab config has not merges";
        }
        Logger.m32136d(f27039h, str);
        return true;
    }
}
