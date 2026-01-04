package to;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoCallback;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoReq;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaPackageInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.CheckAppStatusWithAvoid;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hicloud.request.opengw.bean.Address;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.LsResult;
import com.huawei.hicloud.request.opengw.bean.MakeFileReq;
import com.huawei.hicloud.request.opengw.bean.ObjectAttribute;
import com.huawei.hicloud.request.opengw.bean.Objects;
import com.huawei.hicloud.request.opengw.bean.QuotaSpace;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hicloud.request.opengw.bean.UploadCer;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0237v;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p673u9.C13136a;
import p673u9.C13140e;
import p673u9.C13141f;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p685uo.C13231a;
import p685uo.C13232b;
import p703v8.C13367d;
import p704v9.C13385a;
import p704v9.C13386b;
import p704v9.C13387c;
import p709vj.C13452e;
import p746wn.C13622a;
import p837z9.C14163d;
import ro.C12612a;
import tm.C13040c;

/* renamed from: to.a */
/* loaded from: classes6.dex */
public class C13049a {

    /* renamed from: f */
    public static final List<String> f59377f = new a();

    /* renamed from: g */
    public static final List<String> f59378g = new b();

    /* renamed from: h */
    public static final List<String> f59379h = new c();

    /* renamed from: i */
    public static final List<String> f59380i = new d();

    /* renamed from: j */
    public static final List<String> f59381j = new e();

    /* renamed from: k */
    public static final Map<String, String> f59382k = new f();

    /* renamed from: l */
    public static CloudSpace f59383l = null;

    /* renamed from: m */
    public static CloudSpace f59384m = null;

    /* renamed from: n */
    public static long f59385n = 0;

    /* renamed from: o */
    public static long f59386o = 0;

    /* renamed from: p */
    public static final Gson f59387p = new Gson();

    /* renamed from: a */
    public int f59388a;

    /* renamed from: b */
    public int f59389b;

    /* renamed from: c */
    public String f59390c;

    /* renamed from: d */
    public EnumC12999a f59391d;

    /* renamed from: e */
    public AbstractC4994a f59392e;

    /* renamed from: to.a$a */
    public class a extends ArrayList<String> {
        public a() {
            add("nsp.vfs.lsdir");
            add("nsp.user.getInfo");
            add("nsp.user.getQuotaInfo");
            add("nsp.user.getQuotaUsedInfo");
        }
    }

    /* renamed from: to.a$b */
    public class b extends ArrayList<String> {
        public b() {
            add("nsp.content.upload");
            add("nsp.content.uploadComplete");
            add("nsp.vfs.setattr");
            add("nsp.vfs.mkfile");
            add("nsp.vfs.preMakeFile");
            add("nsp.vfs.makeFile");
            add("nsp.vfs.rmfile");
            add("nsp.vfs.copyfile");
            add("nsp.vfs.movefile");
            add("nsp.vfs.trash");
            add("nsp.vfs.upauth");
        }
    }

    /* renamed from: to.a$c */
    public class c extends ArrayList<String> {
        public c() {
            add("nsp.user.getInfo");
            add("nsp.user.getQuotaInfo");
            add("nsp.user.getQuotaUsedInfo");
            add("nsp.user.getFamilyShareInfo");
            add("nsp.user.enableFamilyShare");
            add("nsp.user.joinFamilyShare");
            add("nsp.user.disableFamilyShare");
            add("nsp.user.quitFamilyShare");
            add("nsp.user.getFamilyDetaiInfo");
            add("nsp.user.queryFamilyShareInfo");
        }
    }

    /* renamed from: to.a$d */
    public class d extends ArrayList<String> {
        public d() {
            add("inviteFamilyMembers");
        }
    }

    /* renamed from: to.a$e */
    public class e extends ArrayList<String> {
        public e() {
            add("nsp.content.upload");
            add("nsp.content.uploadComplete");
            add("nsp.content.download");
        }
    }

    /* renamed from: to.a$f */
    public class f extends HashMap<String, String> {
        public f() {
            put("nsp.vfs.lsdir", "112_");
            put("nsp.vfs.queryFolder", "112_");
            put("nsp.vfs.getattr", "112_");
            put("nsp.vfs.setattr", "112_");
            put("nsp.vfs.mkfile", "112_");
            put("nsp.vfs.preMakeFile", "112_");
            put("nsp.vfs.makeFile", "112_");
            put("nsp.vfs.rmfile", "112_");
            put("nsp.vfs.copyfile", "112_");
            put("nsp.vfs.movefile", "112_");
            put("nsp.vfs.trash", "112_");
            put("nsp.vfs.upauth", "112_");
            put("nsp.vfs.usedspace", "112_");
            put("nsp.vfs.fpe.image.crop", "112_");
            put("nsp.vfs.fpe.image.resize", "112_");
            put("nsp.user.getInfo", "112_");
            put("nsp.content.upload", "116_");
            put("nsp.content.uploadComplete", "116_");
            put("nsp.content.download", "116_");
            put("nsp.user.getQuotaInfo", "112_");
            put("nsp.user.getQuotaUsedInfo", "112_");
        }
    }

    public C13049a(EnumC12999a enumC12999a, String str) {
        EnumC12999a enumC12999a2 = EnumC12999a.CLOUD_BACKUP;
        this.f59390c = str;
        this.f59391d = enumC12999a;
    }

    /* renamed from: O */
    public static boolean m78697O() {
        return f59383l == null || System.currentTimeMillis() - f59385n > 30000;
    }

    /* renamed from: P */
    public static boolean m78698P() {
        return C10028c.m62182c0().m62420y1();
    }

    /* renamed from: Q */
    public static boolean m78699Q() {
        return f59384m == null || System.currentTimeMillis() - f59386o > 30000;
    }

    /* renamed from: k */
    public static Context m78700k() {
        return C0213f.m1377a();
    }

    /* renamed from: t */
    public static synchronized CloudSpace m78701t(C13049a c13049a) throws C9721b {
        try {
            C11839m.m70688i("OpenGWService", "getQuotaCloudSpaceCached");
            if (m78699Q()) {
                f59384m = c13049a.m78754r();
                f59386o = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59384m;
    }

    /* renamed from: A */
    public String m78702A() throws C9721b {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE, "10781986");
        map.put("q", "collection=drive and (trashed=true)");
        return m78712K("nsp.user.getQuotaUsedInfo", map);
    }

    /* renamed from: B */
    public String m78703B(String[] strArr) throws C9721b {
        List listAsList = Arrays.asList(strArr);
        StringBuffer stringBuffer = new StringBuffer("collection=applicationData and (");
        for (String str : strArr) {
            if (listAsList.indexOf(str) != strArr.length - 1) {
                stringBuffer.append("appId=");
                stringBuffer.append(str);
                stringBuffer.append(" or ");
            } else {
                stringBuffer.append("appId=");
                stringBuffer.append(str);
                stringBuffer.append(")");
            }
        }
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE, "10781986");
        map.put("q", stringBuffer.toString());
        return m78712K("nsp.user.getQuotaUsedInfo", map);
    }

    /* renamed from: C */
    public final AbstractC4994a m78704C(String str, String str2, String str3, String str4, String str5, String str6) {
        if (f59380i.contains(str2)) {
            return new C13232b(str, str2, str3, str4, str5, m78722X(str2), m78746l(str2), str6);
        }
        C13231a c13231a = new C13231a(str, str2, str3, str4, str5, m78722X(str2), m78746l(str2), str6);
        if ("nsp.user.getQuotaInfo".equals(str2) && C0209d.m1188L1(C0213f.m1377a(), 1)) {
            C11839m.m70688i("OpenGWService", "app is frontEnd");
            c13231a.m79604a(true);
        }
        return c13231a;
    }

    /* renamed from: D */
    public long m78705D() throws C9721b {
        try {
            JsonObject jsonObject = (JsonObject) m78741i(m78708G(new String[]{"product.totalcapacity"}), JsonObject.class);
            if (jsonObject.has("product.totalcapacity")) {
                return C0241z.m1688f(jsonObject.get("product.totalcapacity").getAsString());
            }
            return 0L;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "getTotalCapacity, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: E */
    public Address m78706E(Map<String, String> map, C11060c c11060c) throws C9721b {
        HashMap map2 = new HashMap(map);
        HashMap map3 = new HashMap();
        map3.put("x-nsp-scheme", "https");
        map2.put("mapUrlHeaders", f59387p.toJson(map3));
        try {
            Address address = (Address) m78741i(m78713L("nsp.content.upload", map2, c11060c), Address.class);
            if (address.getUrl() != null) {
                return address;
            }
            throw new C9721b(4207, "get upload address is null.", "getUploadAddress");
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "getUploadAddress, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: F */
    public String m78707F() throws C9721b {
        return m78712K("nsp.vfs.usedspace", new HashMap());
    }

    /* renamed from: G */
    public String m78708G(String[] strArr) throws C9721b {
        C9720a.m60656e(strArr, "attributes is empty");
        HashMap map = new HashMap(1);
        map.put("attrs", f59387p.toJson(strArr));
        return m78712K("nsp.user.getInfo", map);
    }

    /* renamed from: H */
    public Result m78709H(String[] strArr, String[] strArr2) throws C9721b {
        C9720a.m60657f(strArr, "getattr files is invalid.");
        C9720a.m60657f(strArr2, "getattr fields is invalid.");
        HashMap map = new HashMap();
        Gson gson = f59387p;
        map.put("files", gson.toJson(strArr));
        map.put("fields", gson.toJson(strArr2));
        if (m78698P()) {
            HashMap map2 = new HashMap();
            map2.put("isSslUrl", Boolean.TRUE);
            map.put("options", gson.toJson(map2));
        }
        return m78733e("nsp.vfs.getattr", map, null);
    }

    /* renamed from: I */
    public String m78710I(long[] jArr) throws C9721b {
        if (jArr == null || jArr.length <= 0) {
            throw new C9721b(4002, "param members list is null");
        }
        HashMap map = new HashMap(1);
        map.put("uids", f59387p.toJson(jArr));
        return m78712K("inviteFamilyMembers", map);
    }

    /* renamed from: J */
    public final String m78711J(String str, String str2, boolean z10, C11060c c11060c, String str3, String str4) throws C9721b {
        String str5 = this.f59390c;
        C11060c c11060cM66626a = C11058a.m66626a((str5 == null || str5.isEmpty()) ? C11058a.m66627b("00000") : this.f59390c, str, C13452e.m80781L().m80971t0());
        try {
            try {
                return m78738g0(str, str2, c11060cM66626a, z10, str3, str4);
            } catch (C9721b e10) {
                C9721b c9721bM78729c = f59381j.contains(str) ? this.m78729c(str, e10) : this.m78749m0(str, e10);
                C11839m.m70687e("OpenGWService", this.m78739h(str, c9721bM78729c));
                c11060cM66626a.m66665u(f59382k.get(str) + c9721bM78729c.m60659c());
                c11060cM66626a.m66635A(e10.getMessage());
                C13622a.m81968n(m78700k(), c11060cM66626a);
                throw c9721bM78729c;
            }
        } finally {
            if (c11060c != null) {
                c11060c.m66667w(c11060cM66626a.m66648d());
            }
        }
    }

    /* renamed from: K */
    public final String m78712K(String str, Map<String, String> map) throws C9721b {
        return m78714M(str, map, true, null);
    }

    /* renamed from: L */
    public final String m78713L(String str, Map<String, String> map, C11060c c11060c) throws C9721b {
        return m78714M(str, map, true, c11060c);
    }

    /* renamed from: M */
    public final String m78714M(String str, Map<String, String> map, boolean z10, C11060c c11060c) throws C9721b {
        return m78715N(str, map, true, c11060c, null);
    }

    /* renamed from: N */
    public final String m78715N(String str, Map<String, String> map, boolean z10, C11060c c11060c, String str2) throws C9721b, UnsupportedEncodingException {
        String value;
        boolean zContains = f59380i.contains(str);
        char c10 = zContains ? ',' : '&';
        StringBuilder sb2 = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!zContains) {
                    try {
                        sb2.append(URLEncoder.encode(entry.getKey(), Constants.UTF_8));
                    } catch (Exception unused) {
                        sb2.append(entry.getKey());
                    }
                    sb2.append('=');
                }
                if (entry.getValue() != null) {
                    if (zContains) {
                        try {
                            value = entry.getValue();
                        } catch (Exception unused2) {
                            sb2.append(entry.getValue());
                        }
                    } else {
                        value = URLEncoder.encode(entry.getValue(), Constants.UTF_8);
                    }
                    sb2.append(value);
                }
                sb2.append(c10);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
        }
        return m78711J(str, sb2.toString(), z10, c11060c, "POST", str2);
    }

    /* renamed from: R */
    public String m78716R() throws C9721b {
        return m78712K("nsp.user.joinFamilyShare", null);
    }

    /* renamed from: S */
    public LsResult m78717S(LsRequest lsRequest, boolean z10) throws C9721b {
        C9720a.m60657f(lsRequest, "nsp.vfs.lsdir request is invalid.");
        C9720a.m60656e(lsRequest.getFields(), "nsp.vfs.lsdir fields is invalid.");
        C9720a.m60653b(lsRequest.getServerPath(), "nsp.vfs.lsdir path is invalid.");
        HashMap map = new HashMap();
        Gson gson = f59387p;
        map.put("fields", gson.toJson(lsRequest.getFields()));
        map.put("path", lsRequest.getServerPath());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", Integer.valueOf(lsRequest.getType()));
        jsonObject.addProperty("recursive", Integer.valueOf(lsRequest.getRecursive()));
        if (m78698P()) {
            jsonObject.addProperty("isSslUrl", Boolean.TRUE);
        }
        map.put("options", gson.toJson((JsonElement) jsonObject));
        try {
            return (LsResult) m78741i(m78714M("nsp.vfs.lsdir", map, z10, null), LsResult.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "lsdir, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: T */
    public List<Map<String, Object>> m78718T(LsRequest lsRequest) throws C9721b {
        try {
            return m78717S(lsRequest, true).getChildList();
        } catch (C9721b e10) {
            if (3207 != e10.m60659c()) {
                throw e10;
            }
            int iM60663g = e10.m60663g();
            if (iM60663g == 103 || iM60663g == 9009 || iM60663g == 9005 || iM60663g == 9006) {
                return new ArrayList();
            }
            throw e10;
        }
    }

    /* renamed from: U */
    public Result m78719U(Map<String, Map<String, Object>> map, C11060c c11060c) throws C9721b {
        Map<String, Object> value;
        C9720a.m60655d(map, "mkdir request is null.");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            String key = entry.getKey();
            C9720a.m60653b(key, "path is empty");
            if (key.startsWith("/")) {
                key = key.substring(1);
            }
            String[] strArrSplit = key.split("/");
            StringBuilder sb2 = new StringBuilder(strArrSplit[0]);
            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                sb2.append("/");
                sb2.append(strArrSplit[i10]);
                String string = sb2.toString();
                HashMap map2 = new HashMap();
                map2.put("name", string);
                map2.put("type", "Directory");
                if (i10 == strArrSplit.length - 1 && (value = entry.getValue()) != null && !value.isEmpty()) {
                    for (Map.Entry<String, Object> entry2 : value.entrySet()) {
                        map2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                linkedHashSet.add(map2);
            }
        }
        Result resultM78731d = m78731d("nsp.vfs.mkfile", linkedHashSet, c11060c);
        for (Result.ErrMsg errMsg : resultM78731d.getFailList()) {
            if (errMsg.getErrCode() != 302 && errMsg.getErrCode() != 402) {
                C11839m.m70689w("OpenGWService", errMsg.toString());
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg(), "mkdirs");
            }
        }
        return resultM78731d;
    }

    /* renamed from: V */
    public void m78720V(List<MakeFileReq> list, C11060c c11060c) throws Throwable {
        C9720a.m60654c(list, "mkfile request is null.");
        HashMap map = new HashMap();
        for (MakeFileReq makeFileReq : list) {
            C13387c c13387cM79043j = new C13141f().m79043j(this.f59391d.m78143b(), makeFileReq.getHash());
            if (c13387cM79043j == null) {
                Map<String, Object> attribute = makeFileReq.getAttribute();
                throw new C9721b(4002, "mkfile request hash is not invalid. hash = " + makeFileReq.getHash() + ", name = " + (attribute != null ? String.valueOf(attribute.getOrDefault(JsbMapKeyNames.H5_LOC, "")) : ""));
            }
            C9720a.m60652a(m78698P() == (c13387cM79043j.m80428m() == 0), "used incorrect upload for mkfile params.");
            C9720a.m60652a(c13387cM79043j.m80430o() == 2, "file not upload success.");
            if (m78698P()) {
                map.put(makeFileReq.getPath(), m78740h0(makeFileReq.getPath(), c13387cM79043j, makeFileReq.getAttribute()));
            } else {
                map.put(makeFileReq.getPath(), m78742i0(makeFileReq.getPath(), c13387cM79043j, makeFileReq.getAttribute()));
            }
        }
        m78721W(map, c11060c);
    }

    /* renamed from: W */
    public final void m78721W(Map<String, Map<String, Object>> map, C11060c c11060c) throws C9721b {
        Result resultM78731d = m78698P() ? m78731d("nsp.vfs.mkfile", map.values(), c11060c) : m78731d("nsp.vfs.makeFile", map.values(), c11060c);
        if (resultM78731d.getFailList().isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (Result.ErrMsg errMsg : resultM78731d.getFailList()) {
            int errCode = errMsg.getErrCode();
            if (errCode != 101) {
                if (errCode == 206) {
                    C0237v.m1661c();
                    throw new C9721b(SNSCode.Status.HWID_UNLOGIN, errMsg.getErrMsg(), "OpenGWService_mkfiles");
                }
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getName() + " errCode = " + errMsg.getErrCode() + " errMsg = " + errMsg.getErrMsg(), "OpenGWService_mkfiles");
            }
            String name = errMsg.getName();
            if (!name.startsWith("/")) {
                name = "/" + name;
            }
            map3.put(name, map.get(name));
            String strSubstring = name.substring(0, name.lastIndexOf("/"));
            if (map2.get(strSubstring) == null) {
                map2.put(strSubstring, new HashMap());
            }
        }
        if (map2.isEmpty()) {
            return;
        }
        m78719U(map2, c11060c);
        m78721W(map3, c11060c);
    }

    /* renamed from: X */
    public final boolean m78722X(String str) {
        return f59380i.contains(str);
    }

    /* renamed from: Y */
    public final String m78723Y(String str, boolean z10) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("OpenGW1", str);
        } catch (C13194k e10) {
            C11839m.m70687e("OpenGWService", "onAccessToken: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            if (!EnumC12999a.CLOUD_DRIVE.equals(this.f59391d)) {
                C13452e.m80781L().m80972t1();
            } else if (!f59377f.contains(str) || !z10) {
                C13452e.m80781L().m80980v1();
                C13452e.m80781L().m80972t1();
            }
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: Z */
    public final String m78724Z(String str, boolean z10, String str2) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str2, "OpenGW2", str);
        } catch (C13194k e10) {
            C11839m.m70687e("OpenGWService", "onAccessTokenWithId: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            if (!EnumC12999a.CLOUD_DRIVE.equals(this.f59391d)) {
                C13452e.m80781L().m80972t1();
            } else if (!f59377f.contains(str) || !z10) {
                C13452e.m80781L().m80980v1();
                C13452e.m80781L().m80972t1();
            }
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: a */
    public String m78725a(String[] strArr, String[] strArr2, C11060c c11060c) throws C9721b {
        C9720a.m60657f(strArr, "getattr files is invalid.");
        C9720a.m60657f(strArr2, "getattr fields is invalid.");
        HashMap map = new HashMap();
        Gson gson = f59387p;
        map.put("files", gson.toJson(strArr));
        map.put("fields", gson.toJson(strArr2));
        if (m78698P()) {
            HashMap map2 = new HashMap();
            map2.put("isSslUrl", Boolean.TRUE);
            map.put("options", gson.toJson(map2));
        }
        return m78713L("nsp.vfs.getattr", map, c11060c);
    }

    /* renamed from: a0 */
    public final void m78726a0(String str, boolean z10) throws C9721b {
        if (!C14163d.m84990g().m85009o()) {
            if (C10028c.m62182c0().m62206E1() && f59378g.contains(str)) {
                throw new C9721b(4010, "increment migration update error.", "onMigrateCheck");
            }
        } else {
            if (EnumC12999a.CLOUD_DRIVE.equals(this.f59391d) && (!f59377f.contains(str) || !z10)) {
                C13452e.m80781L().m80984w1(true);
            }
            throw new C9721b(4009, "data migration error.", "onMigrateCheck");
        }
    }

    /* renamed from: b */
    public String m78727b(String str, String str2, String str3, String str4, String str5) throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(str4, str, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
        c11060cM66626a.m66664t(str);
        HashMap map = new HashMap();
        try {
            return m78711J(str, str2, true, null, str3, str5);
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        }
    }

    /* renamed from: b0 */
    public String m78728b0(String str, long j10, List<Long> list, C11060c c11060c) throws C9721b {
        C9720a.m60653b(str, "hmac can't be null");
        C9720a.m60652a(j10 > 0, "file size must great than zero");
        HashMap map = new HashMap();
        map.put("fileHash", str);
        map.put("fileSize", String.valueOf(j10));
        if (list != null && !list.isEmpty()) {
            map.put("attachmentsSize", f59387p.toJson(list));
        }
        return m78713L("nsp.vfs.preMakeFile", map, c11060c);
    }

    /* renamed from: c */
    public final C9721b m78729c(String str, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1102 && iM60659c != 1107 && iM60659c != 1199 && iM60659c != 1201) {
            if (iM60659c == 3012) {
                return new C9721b(4201, c9721b.getMessage(), str);
            }
            if (iM60659c == 4000) {
                return new C9721b(4207, c9721b.m60663g(), m78739h("", Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()), str);
            }
            if (iM60659c == 9005) {
                return new C9721b(4205, c9721b.getMessage(), str);
            }
            switch (iM60659c) {
                case 4008:
                case 4009:
                case 4010:
                case 4011:
                case AccountConstant.Err.SMS_SERVICE_FAILED_APP_NOT_AUTHORIZED /* 4012 */:
                    break;
                default:
                    switch (iM60659c) {
                        case ConnectionResult.NETWORK_ERROR /* 9000 */:
                            return new C9721b(4206, c9721b.m60663g(), m78739h("", Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()), str);
                        case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                            return new C9721b(4202, c9721b.getMessage(), str);
                        case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                            return new C9721b(4203, c9721b.getMessage(), str);
                        case 9003:
                            return new C9721b(4204, c9721b.getMessage(), str);
                        default:
                            return new C9721b(4208, c9721b.getMessage(), str);
                    }
            }
        }
        return c9721b;
    }

    /* renamed from: c0 */
    public String m78730c0() throws C9721b {
        return m78712K("nsp.user.queryFamilyShareInfo", null);
    }

    /* renamed from: d */
    public final Result m78731d(String str, Collection<Map<String, Object>> collection, C11060c c11060c) throws C9721b {
        HashMap map = new HashMap();
        try {
            map.put("files", f59387p.toJson(collection));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "create, json exception is: " + e10.getMessage());
        }
        return m78733e(str, map, c11060c);
    }

    /* renamed from: d0 */
    public String m78732d0() throws C9721b {
        return m78712K("nsp.user.quitFamilyShare", null);
    }

    /* renamed from: e */
    public final Result m78733e(String str, Map<String, String> map, C11060c c11060c) throws C9721b {
        try {
            Result result = (Result) m78741i(m78713L(str, map, c11060c), Result.class);
            if (result.getFailList() != null && result.getSuccessList() != null) {
                return result;
            }
            throw new C9721b(3201, str + " result is null", str);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "create, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: e0 */
    public final String m78734e0(String str) throws C9721b {
        if (f59381j.contains(str)) {
            return C13040c.m78609F().m78673z();
        }
        if (f59379h.contains(str)) {
            return C13040c.m78609F().m78644e0();
        }
        if (!f59380i.contains(str)) {
            return C13040c.m78609F().m78650h0();
        }
        return C13040c.m78609F().m78642d0() + "/user/v1/" + str;
    }

    /* renamed from: f */
    public String m78735f() throws C9721b {
        return m78712K("nsp.user.disableFamilyShare", null);
    }

    /* renamed from: f0 */
    public Result m78736f0(String[] strArr, boolean z10) throws C9721b {
        C9720a.m60656e(strArr, "nsp.vfs.rmfile files is empty.");
        HashMap map = new HashMap();
        map.put("files", f59387p.toJson(strArr));
        map.put("reserve", String.valueOf(z10));
        return m78733e("nsp.vfs.rmfile", map, null);
    }

    /* renamed from: g */
    public String m78737g() throws C9721b {
        return m78712K("nsp.user.enableFamilyShare", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* renamed from: g0 */
    public final String m78738g0(String str, String str2, C11060c c11060c, boolean z10, String str3, String str4) throws Throwable {
        int i10;
        String str5;
        int i11;
        String strM78734e0 = m78734e0(str);
        ?? r14 = 1;
        int i12 = 1;
        while (true) {
            new CheckAppStatusWithAvoid((EnumC12999a.CLOUD_DRIVE.equals(this.f59391d) ? 1 : 0) ^ r14, (f59377f.contains(str) && z10) ? false : r14).checkAll();
            m78726a0(str, z10);
            String strM78723Y = TextUtils.isEmpty(this.f59391d.m78144e()) ? m78723Y(str, z10) : m78724Z(str, z10, this.f59391d.m78144e());
            try {
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[r14] = "x-hw-trace-id = ";
                objArr[2] = c11060c.m66661q();
                C11839m.m70688i("OpenGWService", m78739h(strM78734e0, objArr));
                if (!"inviteFamilyMembers".equals(str)) {
                    C11839m.m70686d("OpenGWService", m78739h(str, str2));
                }
                i10 = 4000;
                str5 = strM78723Y;
            } catch (C9721b e10) {
                e = e10;
                i10 = 4000;
                str5 = strM78723Y;
            } catch (Exception e11) {
                e = e11;
                i10 = 4000;
            }
            try {
                AbstractC4994a abstractC4994aM78704C = m78704C(strM78723Y, str, str2, c11060c.m66661q(), str3, str4);
                this.f59392e = abstractC4994aM78704C;
                String str6 = (String) C12612a.m76110j(strM78734e0, abstractC4994aM78704C, this.f59388a, this.f59389b, c11060c, m78722X(str));
                if (!"inviteFamilyMembers".equals(str)) {
                    C11839m.m70686d("OpenGWService", m78739h(str, str6));
                }
                if (str6 != null && !str6.isEmpty()) {
                    return str6;
                }
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, strM78734e0 + " response is null", str);
            } catch (C9721b e12) {
                e = e12;
                if (e.m60659c() != i10) {
                    throw e;
                }
                int iM60663g = e.m60663g();
                if (iM60663g != 6 && iM60663g != 102) {
                    throw e;
                }
                i11 = i12 + 1;
                if (i12 >= 3) {
                    throw new C9721b(1202, e.getMessage(), str);
                }
                C11839m.m70687e("OpenGWService", " [AT OPERATION] exception:" + e.toString());
                C13195l.m79272J().m79325o0(str5);
                i12 = i11;
                r14 = 1;
            } catch (Exception e13) {
                e = e13;
                C11839m.m70687e("OpenGWService", m78739h(strM78734e0, str, e));
                throw new C9721b(i10, e.getMessage(), str);
            }
            C11839m.m70687e("OpenGWService", " [AT OPERATION] exception:" + e.toString());
            C13195l.m79272J().m79325o0(str5);
            i12 = i11;
            r14 = 1;
        }
    }

    /* renamed from: h */
    public final String m78739h(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: h0 */
    public final Map<String, Object> m78740h0(String str, C13387c c13387c, Map<String, Object> map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.put("merge", Boolean.TRUE);
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        map2.put("name", str);
        map2.put("type", "File");
        map2.put("md5", c13387c.m80421f());
        map2.put("size", Long.valueOf(c13387c.m80427l()));
        C13385a c13385aM79015j = new C13136a().m79015j(this.f59391d.m78143b(), c13387c.m80421f());
        map2.put("sig", c13385aM79015j.m80373h());
        map2.put("ts", c13385aM79015j.m80374i());
        map2.put("url", c13385aM79015j.m80372g());
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    /* renamed from: i */
    public final <T> T m78741i(String str, Class<T> cls) throws C9721b {
        try {
            T t10 = (T) f59387p.fromJson(str, (Class) cls);
            if (t10 != null) {
                return t10;
            }
            throw new C9721b(3207, "json err " + str, "OpenGWService" + cls.getSimpleName());
        } catch (JsonSyntaxException unused) {
            throw new C9721b(3207, "json err " + str, "OpenGWService" + cls.getSimpleName());
        }
    }

    /* renamed from: i0 */
    public final Map<String, Object> m78742i0(String str, C13387c c13387c, Map<String, Object> map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.put("merge", Boolean.TRUE);
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        map2.put("name", str);
        map2.put("type", "File");
        map2.put("size", Long.valueOf(c13387c.m80427l()));
        map2.put("md5", c13387c.m80423h());
        map2.put("e_type", Integer.valueOf(c13387c.m80431p()));
        map2.put("e_fek", c13387c.m80420e());
        map2.put("e_iv", c13387c.m80425j());
        String strM80419d = c13387c.m80419d();
        if (strM80419d != null && !strM80419d.isEmpty()) {
            map2.put("e_saltguid", c13387c.m80419d());
        }
        Objects objectsM78752p = m78752p(c13387c);
        if (objectsM78752p != null) {
            map2.put("dbank_s3_file", objectsM78752p);
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    /* renamed from: j */
    public CloudSpace m78743j() throws C9721b {
        try {
            JsonObject jsonObject = (JsonObject) m78741i(m78708G(new String[]{"profile.usedspacecapacity", "profile.spaceextcapacity", "product.spacecapacity", "product.fileuploadsize"}), JsonObject.class);
            CloudSpace cloudSpace = new CloudSpace();
            if (jsonObject.has("profile.usedspacecapacity")) {
                cloudSpace.setUsed(jsonObject.get("profile.usedspacecapacity").getAsLong());
            }
            cloudSpace.setTotal((jsonObject.has("profile.spaceextcapacity") ? jsonObject.get("profile.spaceextcapacity").getAsLong() : 0L) + (jsonObject.has("product.spacecapacity") ? jsonObject.get("product.spacecapacity").getAsLong() : 0L));
            if (jsonObject.has("product.fileuploadsize")) {
                cloudSpace.setLimit(jsonObject.get("product.fileuploadsize").getAsLong());
            }
            return cloudSpace;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "getCloudSpace, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: j0 */
    public Result m78744j0(Map<String, Map<String, Object>> map) throws C9721b {
        C9720a.m60655d(map, "setattr files is invalid.");
        HashMap map2 = new HashMap();
        map2.put("files", f59387p.toJson(map));
        return m78733e("nsp.vfs.setattr", map2, null);
    }

    /* renamed from: k0 */
    public UploadCer m78745k0() throws C9721b {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ret_dn_flag", "1");
        jsonObject.addProperty("nsp_tver", "2.0");
        jsonObject.addProperty(HwPayConstant.KEY_SITE_ID, String.valueOf(C13452e.m80781L().m80947n0()));
        HashMap map = new HashMap();
        map.put("option", f59387p.toJson((JsonElement) jsonObject));
        try {
            return (UploadCer) m78741i(m78712K("nsp.vfs.upauth", map), UploadCer.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "upauth, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: l */
    public final String m78746l(String str) {
        return f59381j.contains(str) ? "content" : f59379h.contains(str) ? "user" : f59380i.contains(str) ? "userdomain" : "vfs";
    }

    /* renamed from: l0 */
    public void m78747l0(Map<String, String> map, C11060c c11060c) throws C9721b {
        try {
            if (((Boolean) m78741i(m78713L("nsp.content.uploadComplete", map, c11060c), Boolean.class)).booleanValue()) {
            } else {
                throw new C9721b(4207, "upload complete response is false", "nsp.content.uploadComplete");
            }
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "uploadComplete, json exception is: " + e10.getMessage());
        }
    }

    /* renamed from: m */
    public List<Address> m78748m(List<Map<String, Object>> list) throws C9721b {
        HashMap map = new HashMap();
        map.put("listObjectAuthReq", f59387p.toJson(list));
        try {
            Address[] addressArr = (Address[]) m78741i(m78712K("nsp.content.download", map), Address[].class);
            for (Address address : addressArr) {
                if (address.getUrl() == null) {
                    throw new C9721b(4207, "get download address is null.", "getDownloadAddress");
                }
            }
            return Arrays.asList(addressArr);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OpenGWService", "getDownloadAddress, json exception is: " + e10.getMessage());
            throw new C9721b(3207, "json err");
        }
    }

    /* renamed from: m0 */
    public final C9721b m78749m0(String str, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1102 && iM60659c != 1107) {
            if (iM60659c == 1199) {
                return new C9721b(1105, c9721b.getMessage(), str);
            }
            if (iM60659c != 1201) {
                if (iM60659c == 3012) {
                    return new C9721b(3201, c9721b.getMessage(), str);
                }
                if (iM60659c == 4000) {
                    return new C9721b(3207, c9721b.m60663g(), m78739h("", Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()), str);
                }
                if (iM60659c == 9005) {
                    return new C9721b(3205, c9721b.getMessage(), str);
                }
                switch (iM60659c) {
                    case 4008:
                    case 4009:
                    case 4010:
                    case 4011:
                    case AccountConstant.Err.SMS_SERVICE_FAILED_APP_NOT_AUTHORIZED /* 4012 */:
                        break;
                    default:
                        switch (iM60659c) {
                            case ConnectionResult.NETWORK_ERROR /* 9000 */:
                                return new C9721b(3206, c9721b.m60663g(), m78739h("", Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()), str);
                            case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                                return new C9721b(3202, c9721b.getMessage(), str);
                            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                                return new C9721b(3203, c9721b.getMessage(), str);
                            case 9003:
                                return new C9721b(3204, c9721b.getMessage(), str);
                            default:
                                return new C9721b(3208, c9721b.getMessage(), str);
                        }
                }
            }
        }
        return c9721b;
    }

    /* renamed from: n */
    public String m78750n() throws C9721b {
        return m78712K("nsp.user.getFamilyDetaiInfo", null);
    }

    /* renamed from: o */
    public String m78751o() throws C9721b {
        return m78712K("nsp.user.getFamilyShareInfo", null);
    }

    /* renamed from: p */
    public final Objects m78752p(C13387c c13387c) throws Throwable {
        List<C13386b> listM79037j = new C13140e().m79037j(this.f59391d.m78143b(), c13387c.m80421f());
        if (listM79037j.isEmpty()) {
            return null;
        }
        Collections.sort(listM79037j);
        Objects objects = new Objects();
        ArrayList arrayList = new ArrayList();
        Iterator<C13386b> it = listM79037j.iterator();
        while (true) {
            boolean z10 = false;
            if (!it.hasNext()) {
                objects.setSliceSize(c13387c.m80429n());
                objects.setObjectKeys(arrayList);
                try {
                    objects.setAttributes(Arrays.asList((ObjectAttribute[]) m78741i(c13387c.m80417b(), ObjectAttribute[].class)));
                    C11839m.m70688i("OpenGWService", m78739h(c13387c.m80426k(), "construct mkfile objects = ", objects));
                    return objects;
                } catch (JsonSyntaxException e10) {
                    C11839m.m70687e("OpenGWService", "getObjects, json exception is: " + e10.getMessage());
                    throw new C9721b(3207, "json err");
                }
            }
            C13386b next = it.next();
            C9720a.m60657f(next, "makefile slice is null.");
            if (next.m80399s() == 1) {
                z10 = true;
            }
            C9720a.m60652a(z10, "makefile slice upload err.");
            arrayList.add(next.m80397q());
            objects.setBucket(next.m80390b());
        }
    }

    /* renamed from: q */
    public CloudSpace m78753q() throws C9721b {
        QuotaInfoRsp quotaInfoRsp;
        String strM80921h0 = C13452e.m80781L().m80921h0();
        String strM78757v = TextUtils.isEmpty(strM80921h0) ? m78757v(new String[]{"quota.summary", "quota.details"}) : m78758w(new String[]{"quota.summary", "quota.details", "package.total.limit", "package.limit"}, strM80921h0);
        CloudSpace cloudSpace = new CloudSpace();
        if (!TextUtils.isEmpty(strM78757v)) {
            try {
                quotaInfoRsp = (QuotaInfoRsp) new Gson().fromJson(strM78757v, QuotaInfoRsp.class);
            } catch (JsonSyntaxException e10) {
                C11839m.m70687e("OpenGWService", "getQuotaCloudMessage,json exception is: " + e10.getMessage());
                quotaInfoRsp = null;
            }
            if (quotaInfoRsp != null) {
                if (quotaInfoRsp.getRetCode() == 0) {
                    C11839m.m70688i("OpenGWService", "getQuotaCloudMessage,getQuotaSummary Success");
                    FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
                    if (retBody != null) {
                        QuotaInfo quotaInfo = retBody.getQuotaInfo();
                        if (quotaInfo != null) {
                            QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
                            if (quotaSpaceInfo != null) {
                                cloudSpace.setUsed(quotaSpaceInfo.getUsed());
                                cloudSpace.setTotal(quotaSpaceInfo.getTotal());
                                cloudSpace.setLimit(quotaInfo.getFileUploadSize());
                                C13367d.m80177a(quotaSpaceInfo);
                            } else {
                                C11839m.m70687e("OpenGWService", "spaceInfo is null");
                            }
                            QuotaPackageInfo quotaPackageInfo = quotaInfo.getQuotaPackageInfo();
                            if (quotaPackageInfo != null) {
                                cloudSpace.setEndTime(quotaPackageInfo.getEndTime());
                                cloudSpace.setWorryEndTime2(quotaPackageInfo.getEndtime2());
                            }
                            long maxPackageSize = retBody.getMaxPackageSize();
                            if (maxPackageSize > 0) {
                                cloudSpace.setMaxPackageSize(maxPackageSize);
                            }
                            long oldMaxPackageSize = retBody.getOldMaxPackageSize();
                            if (oldMaxPackageSize > 0) {
                                cloudSpace.setOldMaxPackageSize(oldMaxPackageSize);
                            }
                        } else {
                            C11839m.m70687e("OpenGWService", "quotaInfo is null");
                        }
                    } else {
                        C11839m.m70687e("OpenGWService", "fullInfo is null");
                    }
                } else {
                    C11839m.m70687e("OpenGWService", "getQuotaCloudMessage Failed");
                }
            }
        }
        return cloudSpace;
    }

    /* renamed from: r */
    public CloudSpace m78754r() throws C9721b {
        QuotaInfoRsp quotaInfoRsp;
        String strM78757v = m78757v(new String[]{"quota.summary"});
        CloudSpace cloudSpace = new CloudSpace();
        if (!TextUtils.isEmpty(strM78757v)) {
            try {
                quotaInfoRsp = (QuotaInfoRsp) new Gson().fromJson(strM78757v, QuotaInfoRsp.class);
            } catch (JsonSyntaxException e10) {
                C11839m.m70687e("OpenGWService", "getQuotaCloudSpace, json exception is: " + e10.getMessage());
                quotaInfoRsp = null;
            }
            if (quotaInfoRsp != null) {
                if (quotaInfoRsp.getRetCode() == 0) {
                    C11839m.m70688i("OpenGWService", "getQuotaCloudSpace,getQuotaSummary Success");
                    FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
                    if (retBody != null) {
                        QuotaInfo quotaInfo = retBody.getQuotaInfo();
                        if (quotaInfo != null) {
                            QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
                            if (quotaSpaceInfo != null) {
                                cloudSpace.setUsed(quotaSpaceInfo.getUsed());
                                cloudSpace.setTotal(quotaSpaceInfo.getTotal());
                                cloudSpace.setLimit(quotaInfo.getFileUploadSize());
                                C13367d.m80177a(quotaSpaceInfo);
                            } else {
                                C11839m.m70687e("OpenGWService", "spaceInfo is null");
                            }
                        } else {
                            C11839m.m70687e("OpenGWService", "quotaInfo is null");
                        }
                    } else {
                        C11839m.m70687e("OpenGWService", "fullInfo is null");
                    }
                } else {
                    C11839m.m70687e("OpenGWService", "getQuotaCloudSpace Failed");
                }
            }
        }
        return cloudSpace;
    }

    /* renamed from: s */
    public CloudSpace m78755s(boolean z10) throws C9721b {
        C11839m.m70688i("OpenGWService", "getQuotaCloudSpace");
        return !z10 ? m78754r() : m78701t(this);
    }

    /* renamed from: u */
    public CloudSpace m78756u() throws C9721b {
        String strM78757v = m78757v(new String[]{"quota.summary"});
        CloudSpace cloudSpace = new CloudSpace();
        if (TextUtils.isEmpty(strM78757v)) {
            C11839m.m70687e("OpenGWService", "getQuotaSpace response empty");
            throw new C9721b(3207, "getQuotaSpace response empty");
        }
        try {
            QuotaInfoRsp quotaInfoRsp = (QuotaInfoRsp) new Gson().fromJson(strM78757v, QuotaInfoRsp.class);
            if (quotaInfoRsp == null) {
                C11839m.m70687e("OpenGWService", "quotaRsp is null");
                throw new C9721b(3207, "quotaRsp is null");
            }
            int retCode = quotaInfoRsp.getRetCode();
            if (retCode != 0) {
                String str = "getQuotaCloudSpace Failed,retCode is:" + retCode;
                C11839m.m70687e("OpenGWService", str);
                throw new C9721b(3207, str);
            }
            C11839m.m70688i("OpenGWService", "getQuotaCloudSpace,getQuotaSummary Success");
            FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
            if (retBody == null) {
                C11839m.m70687e("OpenGWService", "fullInfo is null");
                throw new C9721b(3207, "fullInfo is null");
            }
            QuotaInfo quotaInfo = retBody.getQuotaInfo();
            if (quotaInfo == null) {
                C11839m.m70687e("OpenGWService", "quotaInfo is null");
                throw new C9721b(3207, "quotaInfo is null");
            }
            QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
            if (quotaSpaceInfo == null) {
                C11839m.m70687e("OpenGWService", "spaceInfo is null");
                throw new C9721b(3207, "spaceInfo is null");
            }
            cloudSpace.setUsed(quotaSpaceInfo.getUsed());
            cloudSpace.setTotal(quotaSpaceInfo.getTotal());
            cloudSpace.setLimit(quotaInfo.getFileUploadSize());
            C13367d.m80177a(quotaSpaceInfo);
            return cloudSpace;
        } catch (JsonSyntaxException e10) {
            String str2 = "getQuotaCloudSpace, json exception is: " + e10.getMessage();
            C11839m.m70687e("OpenGWService", str2);
            throw new C9721b(3207, str2);
        }
    }

    /* renamed from: v */
    public String m78757v(String[] strArr) throws C9721b {
        C9720a.m60656e(strArr, "getQuotaInfo attributes is empty");
        HashMap map = new HashMap(1);
        map.put("attrs", f59387p.toJson(strArr));
        return m78712K("nsp.user.getQuotaInfo", map);
    }

    /* renamed from: w */
    public String m78758w(String[] strArr, String str) throws C9721b {
        C9720a.m60656e(strArr, "getQuotaInfo attributes is empty");
        HashMap map = new HashMap(2);
        map.put("attrs", f59387p.toJson(strArr));
        map.put("country", str);
        return m78713L("nsp.user.getQuotaInfo", map, null);
    }

    /* renamed from: x */
    public QuotaSpace m78759x() throws C9721b {
        C11839m.m70688i("OpenGWService", "getQuotaSpaceForPay");
        QuotaSpace quotaSpace = new QuotaSpace();
        CloudSpace cloudSpaceM78754r = m78754r();
        quotaSpace.setUsed(cloudSpaceM78754r.getUsed());
        quotaSpace.setTotal(cloudSpaceM78754r.getTotal());
        return quotaSpace;
    }

    /* renamed from: y */
    public String m78760y(String str) throws C9721b {
        C9720a.m60653b(str, "getQuotaUsedInfo key is empty");
        String str2 = this.f59390c;
        return (String) C12612a.m76107g(str, new QuotaUsedInfoCallback(m78723Y("nsp.user.getQuotaUsedInfo", true), "nsp.user.getQuotaUsedInfo", new QuotaUsedInfoReq().toString(), (str2 == null || str2.isEmpty()) ? C11058a.m66627b("00000") : this.f59390c), null);
    }

    /* renamed from: z */
    public String m78761z(String str, String str2) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("OpenGWService", "getQuotaUsedInfo serviceType is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getQuotaUsedInfo serviceType is null or empty.");
        }
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE, str);
        map.put("q", str2);
        return m78712K("nsp.user.getQuotaUsedInfo", map);
    }

    public C13049a(EnumC12999a enumC12999a, String str, int i10) {
        EnumC12999a enumC12999a2 = EnumC12999a.CLOUD_BACKUP;
        this.f59390c = str;
        this.f59391d = enumC12999a;
        this.f59388a = i10;
    }

    public C13049a(EnumC12999a enumC12999a, String str, int i10, int i11) {
        EnumC12999a enumC12999a2 = EnumC12999a.CLOUD_BACKUP;
        this.f59390c = str;
        this.f59391d = enumC12999a;
        this.f59388a = i10;
        this.f59389b = i11;
    }
}
