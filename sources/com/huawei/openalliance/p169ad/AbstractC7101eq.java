package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageAppWhiteList;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageWebBlackList;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7799cs;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.eq */
/* loaded from: classes8.dex */
public abstract class AbstractC7101eq {

    /* renamed from: a */
    protected final SharedPreferences f32711a;

    /* renamed from: b */
    protected final SharedPreferences f32712b;

    /* renamed from: c */
    protected SharedPreferences f32713c;

    /* renamed from: d */
    protected final SharedPreferences f32714d;

    /* renamed from: e */
    protected final SharedPreferences f32715e;

    /* renamed from: l */
    protected final SharedPreferences f32722l;

    /* renamed from: m */
    protected Context f32723m;

    /* renamed from: n */
    protected Map<String, String> f32724n;

    /* renamed from: q */
    protected LandpageAppWhiteList f32727q;

    /* renamed from: r */
    protected final String f32728r;

    /* renamed from: t */
    protected LandpageWebBlackList f32730t;

    /* renamed from: v */
    private final String f32732v;

    /* renamed from: f */
    protected final byte[] f32716f = new byte[0];

    /* renamed from: g */
    protected final byte[] f32717g = new byte[0];

    /* renamed from: h */
    protected final byte[] f32718h = new byte[0];

    /* renamed from: i */
    protected final byte[] f32719i = new byte[0];

    /* renamed from: j */
    protected final byte[] f32720j = new byte[0];

    /* renamed from: k */
    protected final byte[] f32721k = new byte[0];

    /* renamed from: o */
    protected final Map<String, String> f32725o = new HashMap();

    /* renamed from: p */
    protected Boolean f32726p = null;

    /* renamed from: s */
    protected final byte[] f32729s = new byte[0];

    /* renamed from: u */
    protected String f32731u = "0";

    public AbstractC7101eq(Context context) {
        this.f32723m = C7845x.m48571i(context.getApplicationContext());
        m43008z();
        this.f32711a = this.f32723m.getSharedPreferences("HiAdSharedPreferences", 0);
        this.f32712b = this.f32723m.getSharedPreferences("HiAdSharedPreferences_sec", 0);
        this.f32714d = this.f32723m.getSharedPreferences("HiAdSharedPreferences_opti", 0);
        try {
            this.f32713c = context.getSharedPreferences("HiAdSharedPreferences", 0);
        } catch (Throwable unused) {
            this.f32713c = null;
            AbstractC7185ho.m43823c("BaseSpHandler", "create sp error.");
        }
        m42999ar();
        this.f32722l = this.f32723m.getSharedPreferences("HiAd_url_cache_sp", 0);
        this.f32715e = this.f32723m.getSharedPreferences("HiAd_device_id_sp", 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f32723m.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        sb2.append("sp.config");
        this.f32728r = sb2.toString();
        this.f32732v = this.f32723m.getFilesDir() + str + Constants.PPS_ROOT_PATH + str + "black.config";
        this.f32724n = (Map) AbstractC7758be.m47739b(m43002au(), Map.class, new Class[0]);
        synchronized (this.f32729s) {
            this.f32727q = new LandpageAppWhiteList();
        }
        synchronized (this.f32721k) {
            this.f32730t = new LandpageWebBlackList();
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.eq.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Serializable serializableM48110a = C7799cs.m48110a(AbstractC7101eq.this.f32728r);
                if (serializableM48110a == null || !(serializableM48110a instanceof LandpageAppWhiteList)) {
                    return;
                }
                synchronized (AbstractC7101eq.this.f32729s) {
                    AbstractC7101eq.this.f32727q = (LandpageAppWhiteList) serializableM48110a;
                }
            }
        });
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.eq.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Serializable serializableM48110a = C7799cs.m48110a(AbstractC7101eq.this.f32732v);
                if (serializableM48110a == null || !(serializableM48110a instanceof LandpageWebBlackList)) {
                    return;
                }
                synchronized (AbstractC7101eq.this.f32721k) {
                    AbstractC7101eq.this.f32730t = (LandpageWebBlackList) serializableM48110a;
                }
            }
        });
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.eq.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7101eq.this.m43000as();
                if (AbstractC7101eq.this.f32725o.isEmpty()) {
                    AbstractC7185ho.m43823c("BaseSpHandler", "load nothing from SP");
                }
            }
        });
    }

    /* renamed from: ar */
    private void m42999ar() {
        if (m43001at()) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = this.f32713c;
            if (sharedPreferences == null) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("BaseSpHandler", "there is no old config file");
                    return;
                }
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null && !all.isEmpty()) {
                Set<Map.Entry<String, ?>> setEntrySet = all.entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    SharedPreferences.Editor editorEdit = this.f32711a.edit();
                    Iterator<Map.Entry<String, ?>> it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        m42997a(it.next(), editorEdit);
                    }
                    editorEdit.commit();
                }
                m42998a(true);
                return;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("BaseSpHandler", "there is no old config file");
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("BaseSpHandler", "restore config error:" + th2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: as */
    public void m43000as() {
        synchronized (this.f32719i) {
            try {
                for (Map.Entry<String, ?> entry : this.f32722l.getAll().entrySet()) {
                    this.f32725o.put(entry.getKey(), (String) entry.getValue());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: at */
    private boolean m43001at() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getBoolean(SpKeys.HAS_RESTORE_CONFIG, false);
        }
        return z10;
    }

    /* renamed from: au */
    private String m43002au() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.CONFIG_MAP, "");
        }
        return string;
    }

    /* renamed from: av */
    private String m43003av() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.SUPPORT_VIDEO_CODEC, "");
        }
        return !AbstractC7806cz.m48165b(string) ? string : m43004aw();
    }

    /* renamed from: aw */
    private String m43004aw() {
        AbstractC7185ho.m43817a("BaseSpHandler", "put support video codec");
        int codecCount = MediaCodecList.getCodecCount();
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < codecCount; i10++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
            if (codecInfoAt.isEncoder()) {
                hashSet.addAll(Arrays.asList(codecInfoAt.getSupportedTypes()));
            }
        }
        String strM48156a = AbstractC7806cz.m48156a((List<String>) new ArrayList(hashSet), ",");
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putString(SpKeys.SUPPORT_VIDEO_CODEC, strM48156a);
            editorEdit.commit();
        }
        return strM48156a;
    }

    /* renamed from: z */
    private void m43008z() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.eq.8
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7101eq abstractC7101eq = AbstractC7101eq.this;
                abstractC7101eq.f32726p = Boolean.valueOf(C6982bz.m41148a(abstractC7101eq.f32723m).mo41175d());
            }
        });
    }

    /* renamed from: a */
    public String mo43009a() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.REDUCE_DISTURB_RULE, null);
        }
        return string;
    }

    /* renamed from: b */
    public int mo43016b() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.GIF_TIME_UPPER_LIMIT, 8000);
        }
        return i10;
    }

    /* renamed from: c */
    public int mo43017c() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.GIF_TIME_LOWER_LIMIT_FRAME, 100);
        }
        return i10;
    }

    /* renamed from: d */
    public int mo43018d() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.GIF_SIZE_UPPER_LIMIT, Constants.GIF_SIZE_UPPER_LIMIT_KB);
        }
        return i10;
    }

    /* renamed from: e */
    public int mo43019e() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.IMG_SIZE_UPPER_LIMIT, Constants.IMG_SIZE_UPPER_LIMIT_KB);
        }
        return i10;
    }

    /* renamed from: b */
    private void m43005b(SharedPreferences.Editor editor, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("apiWhiteList", jSONObject);
            m43006b(editor, SpKeys.API_WHITE_LIST, jSONObject2.toString());
        } catch (JSONException unused) {
            AbstractC7185ho.m43826d("BaseSpHandler", "putApiWhiteList JSONException");
        }
    }

    /* renamed from: b */
    private void m43006b(SharedPreferences.Editor editor, String str, String str2) {
        if (str2 != null) {
            editor.putString(str, str2);
        }
    }

    /* renamed from: a */
    public void mo43010a(int i10) {
        if (i10 <= 0) {
            return;
        }
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putInt(SpKeys.DISK_CACHE_SIZE, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: a */
    private void m42992a(SharedPreferences.Editor editor, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trustAppList", jSONObject);
            m43006b(editor, SpKeys.TRUST_APP_LIST, jSONObject2.toString());
        } catch (JSONException unused) {
            AbstractC7185ho.m43826d("BaseSpHandler", "putTrustAppList JSONException");
        }
    }

    /* renamed from: a */
    public void m43011a(SharedPreferences.Editor editor, String str, Integer num) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        }
    }

    /* renamed from: a */
    private void m42993a(SharedPreferences.Editor editor, String str, Integer num, int i10) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.putInt(str, i10);
        }
    }

    /* renamed from: a */
    private void m42994a(SharedPreferences.Editor editor, String str, Long l10) {
        if (l10 != null) {
            editor.putLong(str, l10.longValue());
        }
    }

    /* renamed from: a */
    private void m42995a(SharedPreferences.Editor editor, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            editor.remove(SpKeys.CONFIG_MAP);
            this.f32724n = null;
            return;
        }
        try {
            AbstractC7185ho.m43820b("BaseSpHandler", "sv config map");
            JSONObject jSONObject = new JSONObject(str);
            m43006b(editor, SpKeys.CONFIG_MAP, jSONObject.toString());
            Map<String, String> map = (Map) AbstractC7758be.m47739b(jSONObject.toString(), Map.class, new Class[0]);
            this.f32724n = map;
            m42996a(map.get(Constants.ALLOWED_VIDEO_CODEC));
            String str3 = this.f32724n.get(MapKeyNames.REPORT_STRATEGY);
            this.f32731u = str3;
            m43014a(str3, str2);
        } catch (JSONException unused) {
            AbstractC7185ho.m43826d("BaseSpHandler", "putConfigMap JSONException");
        }
    }

    /* renamed from: a */
    private void m42996a(Object obj) {
        if (obj == null) {
            AbstractC7185ho.m43817a("BaseSpHandler", "allowed video codec is null");
            return;
        }
        String string = obj.toString();
        String strM43003av = m43003av();
        if (AbstractC7806cz.m48165b(strM43003av)) {
            AbstractC7185ho.m43817a("BaseSpHandler", "support video codec is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split("\\|");
            if (strArrSplit.length != 0) {
                for (String str : strArrSplit) {
                    if (strM43003av.contains(str)) {
                        AbstractC7185ho.m43818a("BaseSpHandler", "support video codec: %s", str);
                        arrayList.add(str);
                    }
                }
            }
        }
        C7787cg.m47900a(this.f32723m).m47955a(arrayList);
    }

    /* renamed from: a */
    public void mo43012a(String str, long j10) {
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(SpKeys.CFG_REF_LAST_TIME_SLOTID, "");
                JSONObject jSONObject = AbstractC7806cz.m48165b(string) ? new JSONObject() : new JSONObject(string);
                jSONObject.put(str, j10);
                this.f32711a.edit().putString(SpKeys.CFG_REF_LAST_TIME_SLOTID, jSONObject.toString()).commit();
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("BaseSpHandler", "set cfg refresh time based on slot error");
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public void mo43013a(String str, AppConfigRsp appConfigRsp, boolean z10) {
        synchronized (this.f32716f) {
            try {
                AbstractC7185ho.m43820b("BaseSpHandler", "sv config");
                SharedPreferences.Editor editorEdit = this.f32711a.edit();
                SharedPreferences.Editor editorEdit2 = this.f32714d.edit();
                editorEdit.putLong(SpKeys.LOCATION_EXPIRE_TIME, appConfigRsp.m40879B().longValue());
                editorEdit.putLong(SpKeys.LOCATION_REFRESH_INTERVAL_TIME, appConfigRsp.m40882E().longValue());
                editorEdit.putInt(SpKeys.LOCATION_COLLECTED_SWITCH, appConfigRsp.m40880C());
                editorEdit.putInt(SpKeys.SPLASH_SHOW_TIME, appConfigRsp.m40922h());
                m43011a(editorEdit, SpKeys.SPLASH_SHOW_MODE, appConfigRsp.m40923i());
                editorEdit.putInt("splash_skip_area", appConfigRsp.m40924j());
                if (C7845x.m48576j(this.f32723m)) {
                    m43011a(editorEdit, SpKeys.SLOGAN_SHOW_TIME, appConfigRsp.m40921g());
                } else {
                    m42993a(editorEdit, SpKeys.SLOGAN_SHOW_TIME, appConfigRsp.m40921g(), 2000);
                }
                editorEdit.putLong(SpKeys.SPLASH_SHOW_TIME_INTERVAL, appConfigRsp.m40919e());
                editorEdit.putLong(SpKeys.SLOGAN_REAL_MIN_SHOW_TIME, appConfigRsp.m40920f());
                editorEdit.putInt(SpKeys.SPLASH_APP_DAY_IMPFC, appConfigRsp.m40917d());
                editorEdit.putString(SpKeys.REDUCE_DISTURB_RULE, appConfigRsp.m40906a(mo43009a()));
                editorEdit.putInt(SpKeys.GIF_TIME_UPPER_LIMIT, appConfigRsp.m40904a(mo43016b()));
                editorEdit.putInt(SpKeys.GIF_TIME_LOWER_LIMIT_FRAME, appConfigRsp.m40913b(mo43017c()));
                editorEdit.putInt(SpKeys.GIF_SIZE_UPPER_LIMIT, appConfigRsp.m40915c(mo43018d()));
                editorEdit.putInt(SpKeys.IMG_SIZE_UPPER_LIMIT, appConfigRsp.m40918d(mo43019e()));
                editorEdit.putFloat(SpKeys.LIMIT_OF_CONTAINER_ASPECT_RATIO, (float) appConfigRsp.m40885H());
                m43011a(editorEdit, SpKeys.SHOW_LANDING_PAGE_MENU, appConfigRsp.m40927m());
                m43011a(editorEdit, "landpage_app_prompt", appConfigRsp.m40929o());
                m43011a(editorEdit, SpKeys.CFG_REF_INTERVAL, appConfigRsp.m40930p());
                if (z10) {
                    mo43012a(str, System.currentTimeMillis());
                }
                editorEdit.putLong(SpKeys.CFG_REF_LAST_TIME, System.currentTimeMillis());
                m43011a(editorEdit, SpKeys.VALIDITY_SPLASH_EVENT, appConfigRsp.m40931q());
                m43011a(editorEdit, SpKeys.VALIDITY_CLICK_SKIP, appConfigRsp.m40932r());
                m43011a(editorEdit, SpKeys.VALIDITY_LOCK_EVENT, appConfigRsp.m40933s());
                m43011a(editorEdit, SpKeys.VALIDITY_NATIVE_EVENT, appConfigRsp.m40934t());
                m43011a(editorEdit, SpKeys.EXSPLASH_DELETE_MODE, appConfigRsp.m40887J());
                m43011a(editorEdit, SpKeys.SPLASH_CACHE_NUM, appConfigRsp.m40888K());
                editorEdit.putString(SpKeys.GLOBAL_SWITCH, appConfigRsp.m40935u());
                editorEdit.putString(SpKeys.SUPPORT_HMS_SDK_VERCODE, appConfigRsp.m40937w());
                editorEdit.putLong(SpKeys.PRELOAD_SPLASH_REQ_TIME_INTERVAL, appConfigRsp.m40938x());
                m42994a(editorEdit, SpKeys.MIN_BANNER_INTERVAL, appConfigRsp.m40914b());
                m42994a(editorEdit, SpKeys.MAX_BANNER_INTERVAL, appConfigRsp.m40916c());
                m43005b(editorEdit, appConfigRsp.m40881D());
                m43011a(editorEdit, SpKeys.NEED_NOTIFY_KIT_WHEN_REQUEST, appConfigRsp.m40940z());
                m42994a(editorEdit, SpKeys.DISKCACHE_VALID_TIME, appConfigRsp.m40886I());
                editorEdit.putString(SpKeys.APP_LIST, appConfigRsp.m40891N());
                editorEdit.putString(SpKeys.TEST_COUNTRY_CODE, appConfigRsp.m40893P());
                m42995a(editorEdit, appConfigRsp.m40890M(), str);
                m43011a(editorEdit, SpKeys.SUPPORT_GZIP, appConfigRsp.m40894Q());
                m43011a(editorEdit, SpKeys.SUPPORT_SDK_SERVER_GZIP, appConfigRsp.m40907aa());
                m43011a(editorEdit, SpKeys.DEFAULT_BANNER_INTERVAL, appConfigRsp.m40892O());
                m43011a(editorEdit, SpKeys.REWARD_GAIN_TIME_PERCENT, appConfigRsp.m40895R());
                m43011a(editorEdit, "ite_ad_close_tm", appConfigRsp.m40896S());
                m43011a(editorEdit, SpKeys.ITE_AD_EXP, appConfigRsp.m40898U());
                m43011a(editorEdit, "ite_ad_ca", appConfigRsp.m40899V());
                m43011a(editorEdit, SpKeys.REWARD_CLOSE_BTN_PERCENT, appConfigRsp.m40900W());
                m42992a(editorEdit, appConfigRsp.m40905a());
                m43006b(editorEdit, "sha256", appConfigRsp.m40902Y());
                m43011a(editorEdit, SpKeys.ALLOW_AD_SKIP_TIME, appConfigRsp.m40903Z());
                m43011a(editorEdit, "splashInteractCloseEffectiveTime", appConfigRsp.m40883F());
                m43006b(editorEdit, "splashFeedbackBtnText", appConfigRsp.m40884G());
                m43011a(editorEdit, SpKeys.VIDEO_CACHA_SIZE, appConfigRsp.m40908ab());
                m43011a(editorEdit, SpKeys.FLOW_CONTROL_SWITCH, appConfigRsp.m40911ae());
                mo43015a(appConfigRsp.m40909ac());
                m43011a(editorEdit2, SpKeys.ITE_AD_FS, appConfigRsp.m40897T());
                m43011a(editorEdit2, SpKeys.OAID_REPORT_ON_NPA, appConfigRsp.m40901X());
                List<String> listM40936v = appConfigRsp.m40936v();
                if (!AbstractC7760bg.m47767a(listM40936v)) {
                    editorEdit.putStringSet(SpKeys.DEF_BROSWER_PKG_LIST, new HashSet(listM40936v));
                }
                List<String> listM40878A = appConfigRsp.m40878A();
                if (AbstractC7760bg.m47767a(listM40878A)) {
                    editorEdit.putStringSet("scheme_info", null);
                } else {
                    editorEdit.putStringSet("scheme_info", new HashSet(listM40878A));
                }
                editorEdit.commit();
                editorEdit2.commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        C7350jx.m45424a(this.f32723m).m45432c();
        synchronized (this.f32729s) {
            this.f32727q.m40222a(appConfigRsp.m40928n());
        }
        synchronized (this.f32721k) {
            this.f32730t.m40227a(appConfigRsp.m40939y());
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.eq.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AbstractC7101eq.this.f32729s) {
                    AbstractC7101eq abstractC7101eq = AbstractC7101eq.this;
                    C7799cs.m48112a(abstractC7101eq.f32727q, abstractC7101eq.f32728r);
                }
            }
        });
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.eq.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AbstractC7101eq.this.f32721k) {
                    AbstractC7101eq abstractC7101eq = AbstractC7101eq.this;
                    C7799cs.m48112a(abstractC7101eq.f32730t, abstractC7101eq.f32732v);
                }
            }
        });
        final Integer numM40889L = appConfigRsp.m40889L();
        if (numM40889L != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.eq.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7101eq.this.mo43010a(numM40889L.intValue());
                    long jIntValue = numM40889L.intValue() * 1048576;
                    C7022dk c7022dkM41937a = C7019dh.m41937a(AbstractC7101eq.this.f32723m, Constants.NORMAL_CACHE);
                    long jM41967c = c7022dkM41937a.m41967c();
                    if (jM41967c > 0 && jM41967c != jIntValue) {
                        c7022dkM41937a.m41959a(jIntValue);
                    }
                    C7022dk c7022dkM41937a2 = C7019dh.m41937a(AbstractC7101eq.this.f32723m, Constants.AR_CACHE);
                    long jM41967c2 = c7022dkM41937a2.m41967c();
                    if (jM41967c2 <= 0 || jM41967c2 == jIntValue) {
                        return;
                    }
                    c7022dkM41937a2.m41959a(jIntValue);
                }
            });
        }
        final Integer numM40888K = appConfigRsp.m40888K();
        if (numM40888K != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.eq.7
                @Override // java.lang.Runnable
                public void run() {
                    C7022dk c7022dkM41937a = C7019dh.m41937a(AbstractC7101eq.this.f32723m, Constants.NORMAL_CACHE);
                    int iM41964b = c7022dkM41937a.m41964b();
                    if (iM41964b > 0 && iM41964b != numM40888K.intValue()) {
                        c7022dkM41937a.m41958a(numM40888K.intValue());
                    }
                    C7022dk c7022dkM41937a2 = C7019dh.m41937a(AbstractC7101eq.this.f32723m, Constants.AR_CACHE);
                    int iM41964b2 = c7022dkM41937a2.m41964b();
                    if (iM41964b2 <= 0 || iM41964b2 == numM40888K.intValue()) {
                        return;
                    }
                    c7022dkM41937a2.m41958a(numM40888K.intValue());
                }
            });
        }
    }

    /* renamed from: a */
    public void m43014a(String str, String str2) {
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(MapKeyNames.REPORT_STRATEGY, "");
                JSONObject jSONObject = AbstractC7806cz.m48165b(string) ? new JSONObject() : new JSONObject(string);
                jSONObject.put(str2, str);
                this.f32711a.edit().putString(MapKeyNames.REPORT_STRATEGY, jSONObject.toString()).commit();
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("BaseSpHandler", "set report strategy based on slot error");
            }
        }
    }

    /* renamed from: a */
    public void mo43015a(List<String> list) {
        synchronized (this.f32716f) {
            try {
                if (!AbstractC7760bg.m47767a(list)) {
                    this.f32711a.edit().putStringSet(SpKeys.SINGLE_INSTANCE_LS_MODEL_LIST, AbstractC7760bg.m47766a(list, true)).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private void m42997a(Map.Entry<String, ?> entry, SharedPreferences.Editor editor) {
        if (entry == null || editor == null) {
            return;
        }
        Object value = entry.getValue();
        String key = entry.getKey();
        if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
            return;
        }
        if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, new HashSet((Set) value));
        }
    }

    /* renamed from: a */
    private void m42998a(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.HAS_RESTORE_CONFIG, z10).commit();
        }
    }
}
