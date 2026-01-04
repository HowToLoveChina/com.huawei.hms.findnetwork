package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.beans.metadata.FlowControl;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageAppWhiteList;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageWebBlackList;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.OaidRecord;
import com.huawei.openalliance.p169ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.p169ad.beans.tags.TagCfgModel;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.DefBrowserPkgList;
import com.huawei.openalliance.p169ad.constant.DefSchemeInfo;
import com.huawei.openalliance.p169ad.constant.DefaultUrlConstant;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.SpDefaultValues;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7808da;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7799cs;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.fh */
/* loaded from: classes8.dex */
public class C7124fh extends AbstractC7102er implements InterfaceC7146gc {

    /* renamed from: v */
    private static InterfaceC7146gc f32844v;

    /* renamed from: w */
    private static final byte[] f32845w = new byte[0];

    /* renamed from: x */
    private String f32846x;

    /* renamed from: y */
    private String f32847y;

    /* renamed from: com.huawei.openalliance.ad.fh$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f32848a;

        /* renamed from: b */
        final /* synthetic */ String f32849b;

        public AnonymousClass1(String str, String str2) {
            str = str;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7124fh.this.f32722l.edit().putString(str, str).commit();
            C7800ct.m48114a().m48119b(C7124fh.this.f32723m);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.fh$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C7124fh.this.f32729s) {
                C7124fh c7124fh = C7124fh.this;
                C7799cs.m48112a(c7124fh.f32727q, c7124fh.f32728r);
            }
        }
    }

    private C7124fh(Context context) {
        super(context);
    }

    /* renamed from: co */
    private String m43319co() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.GLOBAL_SWITCH, "");
        }
        return string;
    }

    /* renamed from: cp */
    private int m43320cp() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpDefaultValues.DEFAULT_SPLASH_MODE, 2);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: A */
    public int mo43321A(String str) {
        int iM48145a;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                iM48145a = (map != null ? AbstractC7806cz.m48145a(map.get(SpKeys.LOADER_ENGINE_2KIT_UPDATE), 60) : 60) * 60000;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iM48145a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: B */
    public int mo43322B(String str) {
        int iM48145a;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                iM48145a = (map != null ? AbstractC7806cz.m48145a(map.get(SpKeys.LOADER_ENGINE_ENGINE_INTERVAL), 10080) : 10080) * 60000;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iM48145a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: C */
    public void mo43323C(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString("adid", str).apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq, com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public String mo43009a() {
        return super.mo43009a();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aA */
    public long mo43334aA() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LAST_CLEAN_DISK_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aB */
    public long mo43335aB() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.ONLINE_STREAM_CLEAN_DISK_TIME, 0L);
        }
        return j10;
    }

    /* renamed from: aC */
    public int m43336aC() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.CACHE_SLOGAN_SHOW_TIME_DEF, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aD */
    public boolean mo43337aD() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getBoolean(SpKeys.USE_POST_AT_FRONT, false);
        }
        return z10;
    }

    /* renamed from: aE */
    public int m43338aE() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.SMART_SCREEN_SLOGAN_TIME, 2000);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aF */
    public int mo43339aF() {
        int i10;
        synchronized (this.f32716f) {
            try {
                int iM43336aC = AdLoadMode.CACHE == mo43367ay() ? m43336aC() : 2000;
                if (C7845x.m48576j(this.f32723m)) {
                    iM43336aC = m43338aE();
                }
                i10 = this.f32711a.getInt(SpKeys.SLOGAN_SHOW_TIME, iM43336aC);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aG */
    public long mo43340aG() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.SPLASH_SHOW_TIME_INTERVAL, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aH */
    public long mo43341aH() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.SLOGAN_REAL_MIN_SHOW_TIME, 300L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aI */
    public int mo43342aI() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.SPLASH_APP_DAY_IMPFC, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aJ */
    public int mo43343aJ() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.TODAY_SHOW_TIMES, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aK */
    public String mo43344aK() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.TODAY_DATE, "");
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x001d  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aL */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo43345aL() {
        /*
            r4 = this;
            byte[] r0 = r4.f32716f
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r4.f32713c     // Catch: java.lang.Throwable -> L11
            r2 = 0
            if (r1 == 0) goto L13
            java.lang.String r3 = "enable_user_info"
            boolean r1 = r1.getBoolean(r3, r2)     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L1d
            goto L13
        L11:
            r4 = move-exception
            goto L20
        L13:
            android.content.SharedPreferences r4 = r4.f32711a     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = "enable_user_info"
            boolean r4 = r4.getBoolean(r1, r2)     // Catch: java.lang.Throwable -> L11
            if (r4 == 0) goto L1e
        L1d:
            r2 = 1
        L1e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r2
        L20:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7124fh.mo43345aL():boolean");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aM */
    public boolean mo43346aM() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getBoolean(SpKeys.ENABLE_SHARE_PD, true);
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aN */
    public String mo43347aN() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.MAGLOCK_SHOW_ID, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aO */
    public long mo43348aO() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.NO_SHOW_AD_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aP */
    public String mo43349aP() {
        synchronized (this.f32716f) {
            try {
                String str = this.f32846x;
                if (str != null) {
                    return str;
                }
                String string = this.f32711a.getString(SpKeys.SERVER_STORE, "");
                this.f32846x = string;
                return string;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aQ */
    public String mo43350aQ() {
        synchronized (this.f32716f) {
            try {
                String str = this.f32847y;
                if (str != null) {
                    return str;
                }
                String string = this.f32711a.getString(SpKeys.PPS_STORE, "");
                this.f32847y = string;
                return string;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aR */
    public boolean mo43351aR() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getInt(SpKeys.SHOW_LANDING_PAGE_MENU, 0) == 1;
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aS */
    public boolean mo43352aS() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getInt("landpage_app_prompt", 0) == 1;
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aT */
    public int mo43353aT() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.CFG_REF_INTERVAL, NotifyConstants.NegFeedback.DEFAULT_LIMIT);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aU */
    public long mo43354aU() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.CFG_REF_LAST_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aV */
    public int mo43355aV() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.VALIDITY_SPLASH_EVENT, 2880) * 60000;
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aW */
    public int mo43356aW() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.VALIDITY_CLICK_SKIP, 30);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aX */
    public int mo43357aX() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.VALIDITY_LOCK_EVENT, 10080) * 60000;
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aY */
    public int mo43358aY() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.VALIDITY_NATIVE_EVENT, 2880) * 60000;
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aZ */
    public int mo43359aZ() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.DISK_CACHE_SIZE, 800);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ar */
    public String mo43360ar() {
        String string;
        synchronized (this.f32716f) {
            string = PreferenceManager.getDefaultSharedPreferences(this.f32723m.getApplicationContext()).getString(SpKeys.IABTCF_TCSTRING, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: as */
    public String mo43361as() {
        String string;
        synchronized (this.f32716f) {
            string = PreferenceManager.getDefaultSharedPreferences(this.f32723m.getApplicationContext()).getString(SpKeys.GOOGLE_ACSTRING, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: at */
    public String mo43362at() {
        String string;
        synchronized (this.f32716f) {
            string = PreferenceManager.getDefaultSharedPreferences(this.f32723m.getApplicationContext()).getString(SpKeys.HW_ACSTRING, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: au */
    public int mo43363au() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.VIDEO_CACHA_SIZE, 300);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: av */
    public int mo43364av() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.SPLASH_CACHE_NUM, 10);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: aw */
    public long mo43365aw() {
        long jMax;
        synchronized (this.f32716f) {
            jMax = Math.max(this.f32711a.getLong(SpKeys.LOCATION_REFRESH_INTERVAL_TIME, 1800000L), 300000L);
        }
        return jMax;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ax */
    public int mo43366ax() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.SPLASH_SHOW_TIME, 3000);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ay */
    public AdLoadMode mo43367ay() {
        AdLoadMode adLoadMode;
        synchronized (this.f32716f) {
            try {
                int i10 = this.f32711a.getInt(SpKeys.SPLASH_SHOW_MODE, m43320cp());
                adLoadMode = AdLoadMode.CACHE;
                if (2 == i10) {
                    adLoadMode = AdLoadMode.REAL;
                } else if (3 == i10) {
                    adLoadMode = AdLoadMode.REAL_NEW;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return adLoadMode;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: az */
    public int mo43368az() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt("splash_skip_area", 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq
    /* renamed from: b */
    public int mo43016b() {
        return super.mo43016b();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bA */
    public Long mo43374bA() {
        Long lValueOf;
        synchronized (this.f32716f) {
            lValueOf = Long.valueOf(this.f32711a.getLong(SpKeys.DISKCACHE_VALID_TIME, Constants.DISKCACHE_DEFAULT_VALID_TIME));
        }
        return lValueOf;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bB */
    public Long mo43375bB() {
        Long lValueOf;
        synchronized (this.f32716f) {
            lValueOf = Long.valueOf(this.f32711a.getLong(SpKeys.EXSPLASH_SLOGAN_START_TIME, 0L));
        }
        return lValueOf;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bC */
    public int mo43376bC() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.EXSPLASH_SLOGAN_SHOW_TIME, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bD */
    public int mo43377bD() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.EXSPLASH_REDUNDANCY_TIME, 100);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bE */
    public long mo43378bE() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.DEVICE_CONNECT_LIST_LAST_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bF */
    public String mo43379bF() {
        synchronized (this.f32716f) {
            try {
                boolean zMo41175d = C6982bz.m41148a(this.f32723m).mo41175d();
                boolean zM41152b = C6982bz.m41152b(this.f32723m);
                if (zMo41175d && !zM41152b) {
                    return this.f32711a.getBoolean(SpKeys.APP_AD_LMT_KEY, false) ? "1" : "0";
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bG */
    public long mo43380bG() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LAST_QUERY_UA_TIME, 0L);
        }
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0057  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bH */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.openalliance.p169ad.beans.metadata.App> mo43381bH() {
        /*
            r8 = this;
            byte[] r0 = r8.f32716f
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r8.f32711a     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = "app_list"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch: java.lang.Throwable -> L43
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L43
            if (r2 != 0) goto L57
            java.util.HashSet r2 = new java.util.HashSet     // Catch: java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = ","
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.lang.Throwable -> L43
            int r3 = r1.length     // Catch: java.lang.Throwable -> L43
            if (r3 <= 0) goto L48
            r4 = 0
        L22:
            if (r4 >= r3) goto L48
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L43
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L43
            if (r5 != 0) goto L45
            com.huawei.openalliance.ad.beans.metadata.App r5 = new com.huawei.openalliance.ad.beans.metadata.App     // Catch: java.lang.Throwable -> L43
            android.content.Context r6 = r8.f32723m     // Catch: java.lang.Throwable -> L43
            r7 = r1[r4]     // Catch: java.lang.Throwable -> L43
            r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = r5.m39697a()     // Catch: java.lang.Throwable -> L43
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L43
            if (r6 != 0) goto L45
            r2.add(r5)     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            r8 = move-exception
            goto L5a
        L45:
            int r4 = r4 + 1
            goto L22
        L48:
            int r8 = r2.size()     // Catch: java.lang.Throwable -> L43
            if (r8 <= 0) goto L57
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L43
            r8.<init>()     // Catch: java.lang.Throwable -> L43
            r8.addAll(r2)     // Catch: java.lang.Throwable -> L43
            goto L58
        L57:
            r8 = 0
        L58:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            return r8
        L5a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L43
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7124fh.mo43381bH():java.util.List");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bI */
    public String mo43382bI() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.TEST_COUNTRY_CODE, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bJ */
    public boolean mo43383bJ() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getInt(SpKeys.SUPPORT_GZIP, 0) == 1;
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bK */
    public boolean mo43384bK() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getInt(SpKeys.SUPPORT_SDK_SERVER_GZIP, 0) == 1;
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bL */
    public String mo43385bL() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.TRUST_APP_LIST, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bM */
    public String mo43386bM() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.PLACEMENT_CFG_REQ_AD_ID, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bN */
    public Location mo43387bN() {
        Location location;
        synchronized (this.f32720j) {
            String string = this.f32712b.getString(SpKeys.LAST_KNOWN_LOCATION, "");
            location = TextUtils.isEmpty(string) ? null : (Location) AbstractC7758be.m47739b(AbstractC7827f.m48400b(string, AbstractC7796cp.m48089b(this.f32723m)), Location.class, new Class[0]);
        }
        return location;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bO */
    public int mo43388bO() {
        int iMax;
        synchronized (this.f32716f) {
            iMax = Math.max(this.f32711a.getInt(SpKeys.REWARD_GAIN_TIME_PERCENT, 90), 1);
        }
        return iMax;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bP */
    public int mo43389bP() {
        int i10;
        synchronized (this.f32716f) {
            int i11 = this.f32711a.getInt("ite_ad_close_tm", 3);
            i10 = i11 >= 0 ? i11 : 3;
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bQ */
    public int mo43390bQ() {
        int i10;
        synchronized (this.f32718h) {
            try {
                if (this.f32726p == null) {
                    this.f32726p = Boolean.valueOf(C6982bz.m41148a(this.f32723m).mo41175d());
                }
                i10 = this.f32714d.getInt(SpKeys.ITE_AD_FS, this.f32726p.booleanValue() ? 1 : 0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bR */
    public int mo43391bR() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.ITE_AD_EXP, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bS */
    public int mo43392bS() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt("ite_ad_ca", 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bT */
    public long mo43393bT() {
        long j10;
        synchronized (this.f32717g) {
            try {
                j10 = this.f32715e.getLong(SpKeys.LAST_REQ_QAID_TIME, 0L);
                if (0 == j10) {
                    j10 = this.f32711a.getLong(SpKeys.LAST_REQ_QAID_TIME, 0L);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bU */
    public long mo43394bU() {
        long j10;
        synchronized (this.f32717g) {
            try {
                j10 = this.f32715e.getLong(SpKeys.LAST_REQ_UUID_TIME, 0L);
                if (0 == j10) {
                    j10 = this.f32711a.getLong(SpKeys.LAST_REQ_UUID_TIME, 0L);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bV */
    public int mo43395bV() {
        synchronized (this.f32718h) {
            try {
                if (this.f32726p == null) {
                    this.f32726p = Boolean.valueOf(C6982bz.m41148a(this.f32723m).mo41175d());
                }
                if (!this.f32726p.booleanValue()) {
                    return 0;
                }
                return this.f32714d.getInt(SpKeys.OAID_REPORT_ON_NPA, 0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bW */
    public int mo43396bW() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.ALLOW_AD_SKIP_TIME, 0) * 1000;
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bX */
    public boolean mo43397bX() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getBoolean(SpKeys.AUTO_OPEN_FORBIDDEN, false);
        }
        return z10;
    }

    /* renamed from: bY */
    public int m43398bY() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt("splashInteractCloseEffectiveTime", 30);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bZ */
    public String mo43399bZ() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString("splashFeedbackBtnText", "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ba */
    public boolean mo43400ba() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bb */
    public boolean mo43401bb() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 1);
        return numM48265a != null && numM48265a.intValue() == 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bc */
    public boolean mo43402bc() {
        synchronized (this.f32716f) {
            try {
                return this.f32711a.getInt(SpKeys.LOCATION_COLLECTED_SWITCH, 0) == 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bd */
    public String mo43403bd() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.API_WHITE_LIST, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: be */
    public boolean mo43404be() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 2);
        return numM48265a != null && numM48265a.intValue() == 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bf */
    public boolean mo43405bf() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 3);
        return numM48265a == null || numM48265a.intValue() == 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bg */
    public int mo43406bg() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 5);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bh */
    public int mo43407bh() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 6);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bi */
    public int mo43408bi() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 7);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bj */
    public int mo43409bj() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 4);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 5;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bk */
    public Set<String> mo43410bk() {
        Set<String> stringSet;
        synchronized (this.f32716f) {
            stringSet = this.f32711a.getStringSet(SpKeys.DEF_BROSWER_PKG_LIST, DefBrowserPkgList.CONTENT);
        }
        return stringSet;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bl */
    public int mo43411bl() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.AD_PRELOAD_INTERVAL, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bm */
    public String mo43412bm() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.R_D, null);
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bn */
    public boolean mo43413bn() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = Math.abs(System.currentTimeMillis() - this.f32711a.getLong(SpKeys.NO_WIFI_REMIND_STARTTIME, 0L)) > ((long) this.f32711a.getInt(SpKeys.NO_WFII_REMIND_BLOCK_TIME, 7)) * 86400000;
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bo */
    public long mo43414bo() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.PRELOAD_SPLASH_REQ_TIME_INTERVAL, 600000L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bp */
    public long mo43415bp() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.MIN_BANNER_INTERVAL, 30L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bq */
    public long mo43416bq() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getInt(SpKeys.DEFAULT_BANNER_INTERVAL, 60);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: br */
    public long mo43417br() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.MAX_BANNER_INTERVAL, 120L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bs */
    public long mo43418bs() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LAST_SYNC_CONFIRM_RESULT_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bt */
    public boolean mo43419bt() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = true;
            if (1 != this.f32711a.getInt(SpKeys.NEED_NOTIFY_KIT_WHEN_REQUEST, 1)) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bu */
    public Set<String> mo43420bu() {
        Set<String> stringSet;
        synchronized (this.f32716f) {
            stringSet = this.f32711a.getStringSet("scheme_info", DefSchemeInfo.SCHEME_INFO);
        }
        return stringSet;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bv */
    public int mo43421bv() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 8);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bw */
    public String mo43422bw() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.BELONG_COUNTRY_CODE, null);
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bx */
    public float mo43423bx() {
        float f10;
        synchronized (this.f32716f) {
            f10 = this.f32711a.getFloat(SpKeys.LIMIT_OF_CONTAINER_ASPECT_RATIO, 0.05f);
        }
        return f10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: by */
    public int mo43424by() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.EXSPLASH_DELETE_MODE, 2);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: bz */
    public int mo43425bz() {
        Integer numM48265a = AbstractC7808da.m48265a(m43319co(), 9);
        if (numM48265a != null) {
            return numM48265a.intValue();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq
    /* renamed from: c */
    public int mo43017c() {
        return super.mo43017c();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ca */
    public String mo43430ca() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.SHIELD_OTHER_SPLASH_FASHION, "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cb */
    public boolean mo43431cb() {
        boolean z10;
        synchronized (this.f32716f) {
            z10 = this.f32711a.getBoolean(SpKeys.REMIND_AGAIN, true);
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cc */
    public long mo43432cc() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.CLCT_CTX_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cd */
    public Set<String> mo43433cd() {
        Set<String> stringSet;
        synchronized (this.f32716f) {
            stringSet = this.f32711a.getStringSet(SpKeys.NOTIFICATION_APP_LIST, new HashSet());
        }
        return stringSet;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ce */
    public boolean mo43434ce() {
        synchronized (this.f32716f) {
            try {
                if (!C7845x.m48576j(this.f32723m)) {
                    return false;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("SpHandler", "isSingleMediaPlayerInstance, is tv");
                }
                Set<String> stringSet = this.f32711a.getStringSet(SpKeys.SINGLE_INSTANCE_LS_MODEL_LIST, new HashSet());
                String strMo41173b = C6982bz.m41148a(this.f32723m).mo41173b();
                if (!AbstractC7760bg.m47767a(stringSet) && !TextUtils.isEmpty(strMo41173b)) {
                    return AbstractC7806cz.m48160a(stringSet, strMo41173b.toUpperCase(Locale.ENGLISH));
                }
                return true;
            } finally {
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cf */
    public long mo43435cf() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LAST_QRY_GRP_ID_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cg */
    public int mo43436cg() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.MEDIA_UI_MODE, -1);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ch */
    public int mo43437ch() {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(SpKeys.FLOW_CONTROL_SWITCH, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ci */
    public String mo43438ci() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString(SpKeys.UNINSTALLED_APP_CACHE, null);
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cj */
    public long mo43439cj() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LAST_QUERY_ACCOUNT_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: ck */
    public List<TagCfgModel> mo43440ck() {
        ArrayList arrayList = new ArrayList();
        String strMo43070b = mo43070b(SpKeys.TAG_CFG, "");
        if (AbstractC7806cz.m48165b(strMo43070b)) {
            return arrayList;
        }
        try {
            AbstractC7185ho.m43818a("SpHandler", "tagCfg info is : %s", strMo43070b);
            String strOptString = new JSONObject(strMo43070b).optString(SpKeys.ALLOWED_TAGS, "");
            return AbstractC7806cz.m48165b(strOptString) ? arrayList : (List) AbstractC7758be.m47739b(strOptString, List.class, TagCfgModel.class);
        } catch (Exception unused) {
            AbstractC7185ho.m43823c("SpHandler", "get tag cfg list error");
            return arrayList;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cl */
    public long mo43441cl() {
        long j10;
        synchronized (this.f32717g) {
            j10 = this.f32715e.getLong(SpKeys.LAST_REQ_HONORQAID_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cm */
    public long mo43442cm() {
        long j10;
        synchronized (this.f32716f) {
            j10 = this.f32711a.getLong(SpKeys.LOADER_LAST_CHECK_TIME, 0L);
        }
        return j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: cn */
    public String mo43443cn() {
        String string;
        synchronized (this.f32716f) {
            string = this.f32711a.getString("adid", "");
        }
        return string;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq, com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: d */
    public int mo43018d() {
        return super.mo43018d();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq, com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: e */
    public int mo43019e() {
        return super.mo43019e();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: f */
    public long mo43452f(int i10) {
        int iMo43019e;
        if (4 == i10) {
            iMo43019e = mo43018d();
        } else {
            if (2 != i10) {
                return 51200L;
            }
            iMo43019e = mo43019e();
        }
        return iMo43019e;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: g */
    public void mo43456g(int i10) {
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putInt(SpKeys.AD_PRELOAD_INTERVAL, i10);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: h */
    public void mo43459h(int i10) {
        synchronized (this.f32716f) {
            if (i10 > 0) {
                try {
                    this.f32711a.edit().putInt(SpKeys.EXSPLASH_SLOGAN_SHOW_TIME, i10).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: i */
    public void mo43462i(int i10) {
        synchronized (this.f32716f) {
            if (i10 > 0) {
                try {
                    this.f32711a.edit().putInt(SpKeys.EXSPLASH_REDUNDANCY_TIME, i10).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: j */
    public void mo43465j(int i10) {
        synchronized (this.f32716f) {
            if (i10 >= 0) {
                try {
                    m43011a(this.f32711a.edit(), "landpage_app_prompt", Integer.valueOf(i10));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: k */
    public Boolean mo43468k(String str) {
        Boolean boolM40226c;
        synchronized (this.f32729s) {
            boolM40226c = this.f32727q.m40226c(str);
        }
        return boolM40226c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: l */
    public long mo43471l(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return 0L;
        }
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(SpKeys.CFG_REF_LAST_TIME_SLOTID, "");
                if (AbstractC7806cz.m48165b(string)) {
                    return 0L;
                }
                Object obj = new JSONObject(string).get(str);
                if (obj == null) {
                    return 0L;
                }
                return Long.parseLong(obj.toString());
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("SpHandler", "get cfg refresh time based on slot error");
                return 0L;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: m */
    public void mo43474m(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpKeys.MEDIA_UI_MODE, i10).apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: n */
    public void mo43477n(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LAST_QUERY_ACCOUNT_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: o */
    public void mo43479o(long j10) {
        synchronized (this.f32717g) {
            this.f32715e.edit().putLong(SpKeys.LAST_REQ_HONORQAID_TIME, j10).apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: p */
    public void mo43481p(long j10) {
        if (j10 <= 0) {
            return;
        }
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LOADER_LAST_CHECK_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: q */
    public OaidRecord mo43483q(String str) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SpHandler", "getOaidRecord, key: %s", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    return (OaidRecord) AbstractC7758be.m47739b(string, OaidRecord.class, new Class[0]);
                }
                AbstractC7185ho.m43823c("SpHandler", "oaid record do not exist for: " + str);
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: r */
    public void mo43484r(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString(SpKeys.PLACEMENT_CFG_REQ_AD_ID, str).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: s */
    public void mo43485s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LAST_CALL_METHOD_TIME_PREFIX + str, AbstractC7741ao.m47566c()).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: t */
    public void mo43486t(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString(SpKeys.SHIELD_OTHER_SPLASH_FASHION, str).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: u */
    public FlowControl mo43487u(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            AbstractC7185ho.m43820b("SpHandler", "slot is empty");
            return null;
        }
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(str, null);
                if (AbstractC7806cz.m48165b(string)) {
                    return null;
                }
                return (FlowControl) AbstractC7758be.m47739b(string, FlowControl.class, new Class[0]);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: v */
    public void mo43488v(String str) {
        synchronized (this.f32716f) {
            String str2 = str + SpKeys.FLOW_CONTROL_COUNTS;
            this.f32711a.edit().putInt(str2, this.f32711a.getInt(str2, 0) + 1).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: w */
    public int mo43489w(String str) {
        int i10;
        synchronized (this.f32716f) {
            i10 = this.f32711a.getInt(str + SpKeys.FLOW_CONTROL_COUNTS, 0);
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: x */
    public void mo43490x(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().remove(str + SpKeys.FLOW_CONTROL_COUNTS).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: y */
    public void mo43491y(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putString(SpKeys.UNINSTALLED_APP_CACHE, str);
            editorEdit.apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: z */
    public boolean mo43492z(String str) {
        boolean zEquals;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                zEquals = "1".equals(map != null ? map.get(SpKeys.LOADER_ENGINE_UPDATE) : null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zEquals;
    }

    /* renamed from: b */
    public static InterfaceC7146gc m43316b(Context context) {
        return m43317c(context);
    }

    /* renamed from: c */
    private static InterfaceC7146gc m43317c(Context context) {
        InterfaceC7146gc interfaceC7146gc;
        synchronized (f32845w) {
            try {
                if (f32844v == null) {
                    f32844v = new C7124fh(context);
                }
                interfaceC7146gc = f32844v;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7146gc;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public String mo43324a(Context context, String str) {
        String url;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strMo41186o = C6982bz.m41148a(context).mo41186o();
        String str2 = str + AbstractC7806cz.m48149a(context) + strMo41186o;
        AbstractC7185ho.m43818a("SpHandler", "countryCode: %s", strMo41186o);
        synchronized (this.f32719i) {
            try {
                url = this.f32725o.get(str2);
                if (TextUtils.isEmpty(url)) {
                    C7094ej c7094ejM42928a = C7094ej.m42928a(context);
                    String strM42931a = c7094ejM42928a.m42931a(str);
                    AbstractC7185ho.m43820b("SpHandler", "baseUrlKey:" + strM42931a);
                    String str3 = this.f32725o.get(strM42931a + strMo41186o);
                    String strM42932b = c7094ejM42928a.m42932b(str);
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(strM42932b)) {
                        url = str3 + strM42932b;
                    } else if (!C6982bz.m41148a(context).mo41184m()) {
                        AbstractC7185ho.m43820b("SpHandler", "there is no url in SP, use default");
                        url = DefaultUrlConstant.getUrl(context, str);
                    }
                    this.f32725o.put(str2, url);
                    m43318c(str2, url);
                } else {
                    C7800ct.m48114a().m48119b(context);
                }
                AbstractC7185ho.m43818a("SpHandler", "serverUrl= %s", AbstractC7819dl.m48375a(url));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return url;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: d */
    public String mo43444d(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return "";
        }
        synchronized (this.f32716f) {
            try {
                String string = this.f32711a.getString(MapKeyNames.REPORT_STRATEGY, "");
                if (AbstractC7806cz.m48165b(string)) {
                    return "";
                }
                Object obj = new JSONObject(string).get(str);
                if (obj == null) {
                    return "";
                }
                return obj.toString();
            } catch (Throwable unused) {
                AbstractC7185ho.m43820b("SpHandler", "get report strategy based on slot error");
                return "";
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: e */
    public void mo43448e(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpKeys.TODAY_SHOW_TIMES, i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: f */
    public void mo43453f(long j10) {
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putLong(SpKeys.LAST_SYNC_CONFIRM_RESULT_TIME, j10);
            editorEdit.apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: g */
    public void mo43457g(long j10) {
        synchronized (this.f32716f) {
            if (j10 > 0) {
                try {
                    this.f32711a.edit().putLong(SpKeys.EXSPLASH_SLOGAN_START_TIME, j10).commit();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: h */
    public void mo43460h(long j10) {
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putLong(SpKeys.DEVICE_CONNECT_LIST_LAST_TIME, j10);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: i */
    public void mo43463i(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LAST_QUERY_UA_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: j */
    public void mo43466j(long j10) {
        synchronized (this.f32717g) {
            this.f32715e.edit().putLong(SpKeys.LAST_REQ_QAID_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: k */
    public void mo43469k(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpDefaultValues.DEFAULT_SPLASH_MODE, i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: l */
    public void mo43472l(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpKeys.VIDEO_AUTO_PLAY_FROM_MEDIA, i10).apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: m */
    public void mo43475m(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LAST_QRY_GRP_ID_TIME, j10).apply();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: n */
    public void mo43478n(String str) {
        synchronized (this.f32716f) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.f32711a.edit().putString(SpKeys.BELONG_COUNTRY_CODE, str).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: o */
    public void mo43480o(String str) {
        synchronized (this.f32716f) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.f32711a.edit().putString(SpKeys.LINKED_CONTENT_ID, str).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: p */
    public void mo43482p(String str) {
        synchronized (this.f32716f) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.f32711a.edit().putString(SpKeys.GLOBAL_SWITCH, str).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq
    /* renamed from: a */
    public void mo43010a(int i10) {
        super.mo43010a(i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    public void mo43369b(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt("splash_skip_area", i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: c */
    public String mo43426c(String str) {
        String strMo43444d = mo43444d(str);
        return AbstractC7806cz.m48165b(strMo43444d) ? "0" : strMo43444d;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: d */
    public void mo43445d(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpKeys.SMART_SCREEN_SLOGAN_TIME, i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: e */
    public void mo43449e(long j10) {
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putLong(SpKeys.CFG_REF_LAST_TIME, j10);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: f */
    public void mo43454f(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString(SpKeys.MAGLOCK_SHOW_ID, str).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: g */
    public void mo43458g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f32716f) {
            this.f32846x = str;
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putString(SpKeys.SERVER_STORE, str);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: h */
    public void mo43461h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f32716f) {
            this.f32847y = str;
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putString(SpKeys.PPS_STORE, str);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: i */
    public boolean mo43464i(String str) {
        synchronized (this.f32729s) {
            try {
                LandpageAppWhiteList landpageAppWhiteList = this.f32727q;
                if (landpageAppWhiteList == null) {
                    return true;
                }
                return landpageAppWhiteList.m40225b(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: j */
    public boolean mo43467j(String str) {
        synchronized (this.f32721k) {
            try {
                LandpageWebBlackList landpageWebBlackList = this.f32730t;
                if (landpageWebBlackList == null) {
                    return false;
                }
                return landpageWebBlackList.m40228b(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: k */
    public void mo43470k(long j10) {
        synchronized (this.f32717g) {
            this.f32715e.edit().putLong(SpKeys.LAST_REQ_UUID_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: l */
    public void mo43473l(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.CLCT_CTX_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: m */
    public void mo43476m(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString(SpKeys.R_D, str).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43325a(Location location) {
        synchronized (this.f32720j) {
            this.f32712b.edit().putString(SpKeys.LAST_KNOWN_LOCATION, AbstractC7827f.m48394a(AbstractC7758be.m47742b(location), AbstractC7796cp.m48089b(this.f32723m))).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    public void mo43370b(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.LAST_CLEAN_DISK_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: c */
    public void mo43427c(int i10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putInt(SpKeys.CACHE_SLOGAN_SHOW_TIME_DEF, i10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: d */
    public void mo43446d(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.NO_SHOW_AD_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: e */
    public void mo43450e(String str) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putString(SpKeys.TODAY_DATE, str).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: f */
    public void mo43455f(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.REMIND_AGAIN, z10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq, com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43012a(String str, long j10) {
        super.mo43012a(str, j10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: b */
    public void mo43371b(List<String> list) {
        synchronized (this.f32721k) {
            if (list != null) {
                try {
                    this.f32730t.m40227a(AbstractC7760bg.m47765a(list, ","));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: c */
    public void mo43428c(long j10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putLong(SpKeys.ONLINE_STREAM_CLEAN_DISK_TIME, j10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: d */
    public void mo43447d(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.APP_AD_LMT_KEY, z10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: e */
    public void mo43451e(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.AUTO_OPEN_FORBIDDEN, z10).commit();
        }
    }

    /* renamed from: c */
    private void m43318c(String str, String str2) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.fh.1

            /* renamed from: a */
            final /* synthetic */ String f32848a;

            /* renamed from: b */
            final /* synthetic */ String f32849b;

            public AnonymousClass1(String str3, String str22) {
                str = str3;
                str = str22;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7124fh.this.f32722l.edit().putString(str, str).commit();
                C7800ct.m48114a().m48119b(C7124fh.this.f32723m);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43326a(String str, FlowControl flowControl) {
        String str2;
        String str3;
        if (AbstractC7806cz.m48165b(str) || flowControl == null) {
            str2 = "SpHandler";
            str3 = "fc para null";
        } else {
            String strM47742b = AbstractC7758be.m47742b(flowControl);
            if (!AbstractC7806cz.m48165b(strM47742b)) {
                AbstractC7185ho.m43821b("SpHandler", "fc para:%s", strM47742b);
                synchronized (this.f32716f) {
                    this.f32711a.edit().putString(str, strM47742b).commit();
                }
                return;
            }
            str2 = "SpHandler";
            str3 = "fc to json failed";
        }
        AbstractC7185ho.m43820b(str2, str3);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: b */
    public void mo43372b(Set<String> set) {
        synchronized (this.f32716f) {
            try {
                SharedPreferences.Editor editorEdit = this.f32711a.edit();
                if (AbstractC7760bg.m47767a(set)) {
                    editorEdit.putStringSet(SpKeys.NOTIFICATION_APP_LIST, null);
                } else {
                    editorEdit.putStringSet(SpKeys.NOTIFICATION_APP_LIST, set);
                }
                editorEdit.commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43327a(String str, OaidRecord oaidRecord) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SpHandler", "saveOaidRecord, key: %s", str);
        }
        if (TextUtils.isEmpty(str) || oaidRecord == null) {
            return;
        }
        String strM47742b = AbstractC7758be.m47742b(oaidRecord);
        if (TextUtils.isEmpty(strM47742b)) {
            AbstractC7185ho.m43823c("SpHandler", "oaid record is null");
            return;
        }
        synchronized (this.f32716f) {
            SharedPreferences.Editor editorEdit = this.f32711a.edit();
            editorEdit.putString(str, strM47742b);
            editorEdit.commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    public void mo43373b(boolean z10) {
        synchronized (this.f32716f) {
            try {
                this.f32711a.edit().putBoolean(SpKeys.ENABLE_USER_INFO, z10).commit();
                SharedPreferences sharedPreferences = this.f32713c;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean(SpKeys.ENABLE_USER_INFO, z10).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: c */
    public void mo43429c(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.ENABLE_SHARE_PD, z10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq, com.huawei.openalliance.p169ad.InterfaceC7146gc
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public void mo43013a(String str, AppConfigRsp appConfigRsp, boolean z10) {
        super.mo43013a(str, appConfigRsp, z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43328a(String str, boolean z10) {
        synchronized (this.f32729s) {
            this.f32727q.m40223a(str, z10);
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.fh.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C7124fh.this.f32729s) {
                        C7124fh c7124fh = C7124fh.this;
                        C7799cs.m48112a(c7124fh.f32727q, c7124fh.f32728r);
                    }
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7101eq
    /* renamed from: a */
    public void mo43015a(List<String> list) {
        super.mo43015a(list);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43329a(List<String> list, Map<String, Boolean> map) {
        synchronized (this.f32729s) {
            if (list != null) {
                try {
                    this.f32727q.m40222a(AbstractC7760bg.m47765a(list, ","));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (map != null) {
                this.f32727q.m40224a(map);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43330a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        synchronized (this.f32719i) {
            try {
                SharedPreferences.Editor editorEdit = this.f32722l.edit();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    editorEdit.putString(entry.getKey(), entry.getValue());
                    this.f32725o.put(entry.getKey(), entry.getValue());
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("SpHandler", "save base url to SP: %s", AbstractC7819dl.m48375a(entry.getValue()));
                    }
                }
                AbstractC7185ho.m43820b("SpHandler", "save result: " + editorEdit.commit());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43331a(Set<String> set) {
        synchronized (this.f32716f) {
            try {
                SharedPreferences.Editor editorEdit = this.f32711a.edit();
                if (AbstractC7760bg.m47767a(set)) {
                    editorEdit.putStringSet("scheme_info", null);
                } else {
                    editorEdit.putStringSet("scheme_info", set);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public void mo43332a(boolean z10) {
        synchronized (this.f32716f) {
            this.f32711a.edit().putBoolean(SpKeys.USE_POST_AT_FRONT, z10).commit();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7146gc
    /* renamed from: a */
    public boolean mo43333a(Long l10) {
        synchronized (this.f32716f) {
            try {
                if (l10 == null) {
                    return false;
                }
                long jM43398bY = m43398bY();
                if (jM43398bY == -1) {
                    return true;
                }
                return System.currentTimeMillis() < (jM43398bY * 86400000) + l10.longValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
