package com.huawei.hms.framework.network.grs.p122g;

import android.text.TextUtils;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.d */
/* loaded from: classes8.dex */
public class C5445d {

    /* renamed from: o */
    private static final String f24957o = "d";

    /* renamed from: a */
    private Map<String, List<String>> f24958a;

    /* renamed from: b */
    private byte[] f24959b;

    /* renamed from: c */
    private int f24960c;

    /* renamed from: d */
    private long f24961d;

    /* renamed from: e */
    private long f24962e;

    /* renamed from: f */
    private long f24963f;

    /* renamed from: g */
    private String f24964g;

    /* renamed from: h */
    private int f24965h;

    /* renamed from: i */
    private int f24966i;

    /* renamed from: j */
    private String f24967j;

    /* renamed from: k */
    private long f24968k;

    /* renamed from: l */
    private String f24969l;

    /* renamed from: m */
    private Exception f24970m;

    /* renamed from: n */
    private String f24971n;

    public C5445d(int i10, Map<String, List<String>> map, byte[] bArr, long j10) throws NumberFormatException {
        this.f24965h = 2;
        this.f24966i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f24967j = "";
        this.f24968k = 0L;
        this.f24969l = "";
        this.f24960c = i10;
        this.f24958a = map;
        this.f24959b = ByteBuffer.wrap(bArr).array();
        this.f24961d = j10;
        m32269s();
    }

    /* renamed from: p */
    private void m32266p() {
        int i10;
        if (m32287m()) {
            Logger.m32141i(f24957o, "GRSSDK get httpcode{304} not any changed.");
            m32259c(1);
            return;
        }
        if (!m32289o()) {
            Logger.m32141i(f24957o, "GRSSDK parse server body all failed.");
            m32259c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.f24959b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                }
            } else if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE) == 0 ? 1 : 2;
            } else {
                Logger.m32138e(f24957o, "sth. wrong because server errorcode's key.");
                i10 = -1;
            }
            if (i10 != 1 && jSONObject.has("services")) {
                i10 = 0;
            }
            m32259c(i10);
            if (i10 == 1 || i10 == 0) {
                m32265f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                m32264e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                m32257b(jSONObject.has(AddressConstants.Extras.EXTRA_NAME_ERR_CODE) ? jSONObject.getInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE) : ConnectionResult.RESOLUTION_REQUIRED);
                m32263d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (JSONException e10) {
            Logger.m32147w(f24957o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e10.getMessage()));
            m32259c(2);
        }
    }

    /* renamed from: q */
    private void m32267q() throws NumberFormatException {
        if (m32289o() || m32288n() || m32287m()) {
            Map<String, String> mapM32268r = m32268r();
            if (mapM32268r.size() <= 0) {
                Logger.m32145w(f24957o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (m32289o() || m32287m()) {
                    m32258b(mapM32268r);
                    m32256a(mapM32268r);
                }
                if (m32288n()) {
                    m32262c(mapM32268r);
                }
            } catch (JSONException e10) {
                Logger.m32147w(f24957o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e10.getMessage()));
            }
        }
    }

    /* renamed from: r */
    private Map<String, String> m32268r() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.f24958a;
        if (map2 == null || map2.size() <= 0) {
            Logger.m32143v(f24957o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.f24958a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                map.put(key, it.next());
            }
        }
        return map;
    }

    /* renamed from: s */
    private void m32269s() throws NumberFormatException {
        m32267q();
        m32266p();
    }

    /* renamed from: a */
    public String m32270a() {
        return this.f24967j;
    }

    /* renamed from: b */
    public int m32274b() {
        return this.f24960c;
    }

    /* renamed from: c */
    public int m32277c() {
        return this.f24966i;
    }

    /* renamed from: d */
    public Exception m32278d() {
        return this.f24970m;
    }

    /* renamed from: e */
    public String m32279e() {
        return this.f24969l;
    }

    /* renamed from: f */
    public int m32280f() {
        return this.f24965h;
    }

    /* renamed from: g */
    public long m32281g() {
        return this.f24963f;
    }

    /* renamed from: h */
    public long m32282h() {
        return this.f24962e;
    }

    /* renamed from: i */
    public long m32283i() {
        return this.f24961d;
    }

    /* renamed from: j */
    public String m32284j() {
        return this.f24964g;
    }

    /* renamed from: k */
    public long m32285k() {
        return this.f24968k;
    }

    /* renamed from: l */
    public String m32286l() {
        return this.f24971n;
    }

    /* renamed from: m */
    public boolean m32287m() {
        return this.f24960c == 304;
    }

    /* renamed from: n */
    public boolean m32288n() {
        return this.f24960c == 503;
    }

    /* renamed from: o */
    public boolean m32289o() {
        return this.f24960c == 200;
    }

    public C5445d(Exception exc, long j10) {
        this.f24960c = 0;
        this.f24965h = 2;
        this.f24966i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f24967j = "";
        this.f24968k = 0L;
        this.f24969l = "";
        this.f24970m = exc;
        this.f24961d = j10;
    }

    /* renamed from: b */
    private void m32257b(int i10) {
        this.f24966i = i10;
    }

    /* renamed from: c */
    private void m32259c(int i10) {
        this.f24965h = i10;
    }

    /* renamed from: d */
    private void m32263d(String str) {
    }

    /* renamed from: e */
    private void m32264e(String str) {
    }

    /* renamed from: f */
    private void m32265f(String str) {
        this.f24964g = str;
    }

    /* renamed from: a */
    public void m32271a(int i10) {
    }

    /* renamed from: c */
    private void m32260c(long j10) {
        this.f24968k = j10;
    }

    /* renamed from: a */
    public void m32272a(long j10) {
        this.f24963f = j10;
    }

    /* renamed from: b */
    public void m32275b(long j10) {
        this.f24962e = j10;
    }

    /* renamed from: c */
    private void m32261c(String str) {
        this.f24967j = str;
    }

    /* renamed from: a */
    public void m32273a(String str) {
        this.f24969l = str;
    }

    /* renamed from: b */
    public void m32276b(String str) {
        this.f24971n = str;
    }

    /* renamed from: a */
    private void m32256a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.m32141i(f24957o, "success get Etag from server");
                m32273a(str3);
                return;
            } else {
                str = f24957o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = f24957o;
            str2 = "Response Heads has not Etag";
        }
        Logger.m32141i(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m32258b(java.util.Map<java.lang.String, java.lang.String> r11) throws java.lang.NumberFormatException {
        /*
            r10 = this;
            java.lang.String r0 = "Cache-Control"
            boolean r1 = r11.containsKey(r0)
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 0
            if (r1 == 0) goto L4d
            java.lang.Object r11 = r11.get(r0)
            java.lang.String r11 = (java.lang.String) r11
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto Laf
            java.lang.String r0 = "max-age="
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto Laf
            int r0 = r11.indexOf(r0)     // Catch: java.lang.NumberFormatException -> L43
            int r0 = r0 + 8
            java.lang.String r11 = r11.substring(r0)     // Catch: java.lang.NumberFormatException -> L43
            long r0 = java.lang.Long.parseLong(r11)     // Catch: java.lang.NumberFormatException -> L43
            java.lang.String r11 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o     // Catch: java.lang.NumberFormatException -> L41
            java.lang.String r6 = "Cache-Control value{%s}"
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.NumberFormatException -> L41
            java.lang.Long r8 = java.lang.Long.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L41
            r9 = 0
            r7[r9] = r8     // Catch: java.lang.NumberFormatException -> L41
            com.huawei.hms.framework.common.Logger.m32144v(r11, r6, r7)     // Catch: java.lang.NumberFormatException -> L41
            goto Lb0
        L41:
            r11 = move-exception
            goto L45
        L43:
            r11 = move-exception
            r0 = r4
        L45:
            java.lang.String r6 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.String r7 = "getExpireTime addHeadersToResult NumberFormatException"
            com.huawei.hms.framework.common.Logger.m32146w(r6, r7, r11)
            goto Lb0
        L4d:
            java.lang.String r0 = "Expires"
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto La8
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.Object[] r6 = new java.lang.Object[]{r0}
            java.lang.String r7 = "expires is{%s}"
            com.huawei.hms.framework.common.Logger.m32144v(r1, r7, r6)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r7 = "EEE, d MMM yyyy HH:mm:ss 'GMT'"
            r1.<init>(r7, r6)
            java.lang.String r6 = "Date"
            boolean r7 = r11.containsKey(r6)
            if (r7 == 0) goto L7e
            java.lang.Object r11 = r11.get(r6)
            java.lang.String r11 = (java.lang.String) r11
            goto L7f
        L7e:
            r11 = 0
        L7f:
            java.util.Date r0 = r1.parse(r0)     // Catch: java.text.ParseException -> L8f
            boolean r6 = android.text.TextUtils.isEmpty(r11)     // Catch: java.text.ParseException -> L8f
            if (r6 == 0) goto L91
            java.util.Date r11 = new java.util.Date     // Catch: java.text.ParseException -> L8f
            r11.<init>()     // Catch: java.text.ParseException -> L8f
            goto L95
        L8f:
            r11 = move-exception
            goto La0
        L91:
            java.util.Date r11 = r1.parse(r11)     // Catch: java.text.ParseException -> L8f
        L95:
            long r0 = r0.getTime()     // Catch: java.text.ParseException -> L8f
            long r6 = r11.getTime()     // Catch: java.text.ParseException -> L8f
            long r0 = r0 - r6
            long r0 = r0 / r2
            goto Lb0
        La0:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.String r1 = "getExpireTime ParseException."
            com.huawei.hms.framework.common.Logger.m32146w(r0, r1, r11)
            goto Laf
        La8:
            java.lang.String r11 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.String r0 = "response headers neither contains Cache-Control nor Expires."
            com.huawei.hms.framework.common.Logger.m32141i(r11, r0)
        Laf:
            r0 = r4
        Lb0:
            int r11 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r11 <= 0) goto Lbb
            r4 = 2592000(0x278d00, double:1.280618E-317)
            int r11 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r11 <= 0) goto Lbe
        Lbb:
            r0 = 86400(0x15180, double:4.26873E-319)
        Lbe:
            long r0 = r0 * r2
            java.lang.String r11 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "convert expireTime{%s}"
            com.huawei.hms.framework.common.Logger.m32142i(r11, r3, r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r0 + r2
            java.lang.String r11 = java.lang.String.valueOf(r0)
            r10.m32261c(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p122g.C5445d.m32258b(java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m32262c(java.util.Map<java.lang.String, java.lang.String> r5) throws java.lang.NumberFormatException {
        /*
            r4 = this;
            java.lang.String r0 = "Retry-After"
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L21
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L21
            long r0 = java.lang.Long.parseLong(r5)     // Catch: java.lang.NumberFormatException -> L19
            goto L23
        L19:
            r5 = move-exception
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.String r1 = "getRetryAfter addHeadersToResult NumberFormatException"
            com.huawei.hms.framework.common.Logger.m32146w(r0, r1, r5)
        L21:
            r0 = 0
        L23:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            java.lang.String r5 = com.huawei.hms.framework.network.grs.p122g.C5445d.f24957o
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "convert retry-afterTime{%s}"
            com.huawei.hms.framework.common.Logger.m32144v(r5, r3, r2)
            r4.m32260c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p122g.C5445d.m32262c(java.util.Map):void");
    }
}
