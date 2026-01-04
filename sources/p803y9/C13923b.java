package p803y9;

import android.content.Context;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.connect.progress.IPreCallback;
import com.huawei.android.hicloud.p081cs.bean.DownloadReq;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hicloud.request.opengw.bean.UploadCer;
import com.huawei.hicloud.request.upload.PreUploadCallback;
import com.huawei.hicloud.request.upload.UploadPCallback;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0241z;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11835i;
import p514o9.C11839m;
import p549p9.C12122a;
import p637s9.C12765a;
import p652t9.EnumC12999a;
import p673u9.C13136a;
import p673u9.C13141f;
import p704v9.C13385a;
import p704v9.C13387c;
import p709vj.C13452e;
import p746wn.C13622a;
import ro.C12612a;
import to.C13049a;

/* renamed from: y9.b */
/* loaded from: classes3.dex */
public class C13923b {

    /* renamed from: a */
    public int f62388a;

    /* renamed from: b */
    public int f62389b;

    /* renamed from: c */
    public LinkedHashMap<String, String> f62390c = new LinkedHashMap<>();

    /* renamed from: d */
    public String f62391d;

    /* renamed from: e */
    public EnumC12999a f62392e;

    /* renamed from: f */
    public UploadCer f62393f;

    public C13923b(EnumC12999a enumC12999a, String str, int i10, int i11) {
        this.f62392e = enumC12999a;
        this.f62391d = str;
        this.f62388a = i10;
        this.f62389b = i11;
    }

    /* renamed from: a */
    public int m83519a(File file, C13387c c13387c, C12122a c12122a) throws C9721b {
        String strM68620b;
        C11839m.m70688i("CoreService", "third app common upload start.");
        if (!file.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "file is not exist.", C10279b.m63452a(file));
        }
        try {
            strM68620b = C11476b.m68620b(file);
        } catch (C9721b e10) {
            C11839m.m70689w("CoreService", "get app manifest.mf hash failed. " + e10.toString());
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02008"), "02008", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66635A(e10.getMessage());
            c11060cM66626a.m66665u("001_" + e10.m60659c());
            c11060cM66626a.m66668x("1");
            C13622a.m81968n(m83529k(), c11060cM66626a);
            strM68620b = "";
        }
        String str = strM68620b;
        String strM68021e = !str.isEmpty() ? new C11322a(this.f62391d).m68021e(c13387c.m80419d(), str, c13387c.m80421f(), c13387c.m80417b(), c13387c.m80418c()) : "false";
        if ("false".equals(strM68021e)) {
            C11839m.m70688i("CoreService", "check third app is nonstandard.");
            return 1;
        }
        m83534p(c12122a);
        if (FaqConstants.DISABLE_HA_REPORT.equals(strM68021e)) {
            return 3;
        }
        m83522d(strM68021e, file, c13387c, c12122a);
        return 3;
    }

    /* renamed from: b */
    public final void m83520b(String str, File file, File file2) throws C9721b {
        if (str == null || str.isEmpty()) {
            m83540v(file, file2);
            return;
        }
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file2);
        if (str.equals(md5AndHashM68622d.getMD5()) || str.equals(md5AndHashM68622d.getHash())) {
            m83540v(file, file2);
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash is not equal, need download again. delete file success = " + file2.delete(), "download");
    }

    /* renamed from: c */
    public void m83521c(File file, C12122a c12122a, C13387c c13387c, C11060c c11060c, boolean z10) throws C9721b {
        C11839m.m70688i("CoreService", "use plv3 upload file is forbidden");
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "use plv3 upload file is forbidden");
    }

    /* renamed from: d */
    public final void m83522d(String str, File file, C13387c c13387c, C12122a c12122a) throws C9721b {
        C11839m.m70688i("CoreService", "use dl upload file is forbidden");
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "use dl upload file is forbidden");
    }

    /* renamed from: e */
    public final String m83523e(Map<String, String> map) throws C9721b {
        UploadCer uploadCer = this.f62393f;
        if (uploadCer == null) {
            throw new C9721b(4001, "cer is null");
        }
        map.put("nsp_app", uploadCer.getNspTapp());
        map.put("nsp_ver", this.f62393f.getNspTver());
        map.put("nsp_tstr", String.valueOf(this.f62393f.getNspTstr()));
        map.put("nsp_ts", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("nsp_fmt", "JSON");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                sb2.append(URLEncoder.encode(key, Constants.UTF_8));
                sb2.append('=');
                sb2.append(URLEncoder.encode(value, Constants.UTF_8));
                sb2.append('&');
            } catch (UnsupportedEncodingException unused) {
                sb2.append(URLEncoder.encode(key));
                sb2.append('=');
                sb2.append(URLEncoder.encode(value));
                sb2.append('&');
            }
            sb3.append(key);
            sb3.append(value);
        }
        sb2.append("nsp_key");
        sb2.append('=');
        sb2.append(C11476b.m68629k(sb3.toString(), this.f62393f.getSecret()).toUpperCase(Locale.US));
        return sb2.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.google.gson.JsonArray, com.google.gson.JsonElement] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: f */
    public final boolean m83524f(File file, C13387c c13387c, C12122a c12122a, C11060c c11060c) throws Throwable {
        long jM80427l = c13387c.m80427l();
        boolean z10 = true;
        if (jM80427l <= 524288) {
            m83538t(file, c13387c, c12122a, c11060c);
            return true;
        }
        String strM83531m = m83531m(c13387c, c11060c);
        char c10 = 0;
        boolean z11 = false;
        while (true) {
            m83534p(c12122a);
            try {
                JsonObject jsonObjectM83528j = m83528j(strM83531m);
                String asString = jsonObjectM83528j.get("nsp_upcmd").getAsString();
                asString.hashCode();
                ?? r52 = -1;
                r52 = -1;
                r52 = -1;
                r52 = -1;
                r52 = -1;
                switch (asString.hashCode()) {
                    case -1785052305:
                        if (asString.equals("UPSTAT")) {
                            r52 = c10;
                            break;
                        }
                        break;
                    case 1813642731:
                        if (asString.equals("REQTBLK")) {
                            r52 = z10;
                            break;
                        }
                        break;
                    case 1813643788:
                        if (asString.equals("REQTCON")) {
                            r52 = 2;
                            break;
                        }
                        break;
                    case 1813658847:
                        if (asString.equals("REQTSEG")) {
                            r52 = 3;
                            break;
                        }
                        break;
                }
                switch (r52) {
                    case 0:
                        boolean z12 = z11;
                        String asString2 = jsonObjectM83528j.get("nsp_upstat").getAsString();
                        if (!"FIN".equals(asString2)) {
                            throw new C9721b(3307, "storage error UPSTAT upload stat = " + asString2, "tryUpload");
                        }
                        c12122a.mo17784f(jM80427l);
                        c12122a.mo17783e(true);
                        C13385a c13385a = new C13385a(this.f62392e.m78143b());
                        c13385a.m80379n(c13387c.m80421f());
                        c13385a.m80380o(jsonObjectM83528j.get("nsp_path").getAsString());
                        c13385a.m80381p(jsonObjectM83528j.get("nsp_sig").getAsString());
                        c13385a.m80382q(jsonObjectM83528j.get("nsp_ts").getAsString());
                        c13385a.m80375j(System.currentTimeMillis());
                        new C13136a().m79016k(c13385a);
                        return z12;
                    case 1:
                        c11060c.m66664t(asString);
                        TreeMap treeMap = new TreeMap();
                        long[] jArrM83541w = m83541w(jsonObjectM83528j, c13387c, treeMap);
                        m83542x(treeMap);
                        strM83531m = m83533o("/up/up_blk", new UploadPCallback(treeMap, new SliceItem(file, 0, jArrM83541w[c10], jArrM83541w[1]), this.f62391d, c12122a), c11060c);
                        z11 = true;
                        break;
                    case 2:
                        c11060c.m66664t(asString);
                        TreeMap treeMap2 = new TreeMap();
                        long[] jArrM83541w2 = m83541w(jsonObjectM83528j, c13387c, treeMap2);
                        treeMap2.put("nsp_fcon", C11476b.m68623e(file, jArrM83541w2[c10], (int) jArrM83541w2[1]).getMD5());
                        strM83531m = m83533o("/up/up_retcon", new PreUploadCallback("/up/up_retcon", m83523e(treeMap2), c11060c.m66661q()), c11060c);
                        z11 = z11;
                        break;
                    case 3:
                        c11060c.m66664t(asString);
                        long asLong = jsonObjectM83528j.get("nsp_segsize").getAsLong();
                        this.f62390c.clear();
                        this.f62390c.putAll(C11476b.m68630l(file, asLong));
                        TreeMap treeMap3 = new TreeMap();
                        treeMap3.put("nsp_fid", c13387c.m80421f());
                        treeMap3.put("nsp_fsize", String.valueOf(c13387c.m80427l()));
                        ?? jsonArray = new JsonArray();
                        for (Map.Entry<String, String> entry : this.f62390c.entrySet()) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("fileid", entry.getValue());
                            jsonObject.addProperty("range", entry.getKey());
                            jsonArray.add(jsonObject);
                        }
                        treeMap3.put("nsp_seglist", jsonArray.toString());
                        strM83531m = m83533o("/up/up_seginfo", new PreUploadCallback("/up/up_seginfo", m83523e(treeMap3), c11060c.m66661q()), c11060c);
                        break;
                    default:
                        throw new C9721b(3307, "upload process control, cmd = " + asString, "tryUpload");
                }
                z10 = true;
                c10 = 0;
            } catch (JsonSyntaxException e10) {
                C11839m.m70687e("CoreService", "doUpload, json exception is: " + e10.getMessage());
                throw new C9721b(4000, "json err ");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ff A[Catch: all -> 0x01fd, TryCatch #7 {all -> 0x01fd, blocks: (B:64:0x01c6, B:67:0x01df, B:70:0x01e6, B:74:0x021a, B:75:0x0247, B:73:0x01ff), top: B:78:0x01c6 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m83525g(com.huawei.android.hicloud.p081cs.bean.DownloadReq r23, p429kk.C11060c r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p803y9.C13923b.m83525g(com.huawei.android.hicloud.cs.bean.DownloadReq, kk.c):void");
    }

    /* renamed from: h */
    public void m83526h(String str, String str2, ICallback iCallback, C11060c c11060c) throws Throwable {
        Map<String, Object> mapM83539u = m83539u(str);
        try {
            m83525g(new DownloadReq((String) mapM83539u.get("sslUrl"), str2, (String) mapM83539u.get("md5"), C0241z.m1688f((String) mapM83539u.get("size")), iCallback), c11060c);
        } catch (NumberFormatException e10) {
            throw new C9721b(3307, "size error." + e10.getMessage(), "queryDownloadParams");
        }
    }

    /* renamed from: i */
    public final String m83527i(String str, Object... objArr) {
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

    /* renamed from: j */
    public final JsonObject m83528j(String str) throws C9721b {
        try {
            return new JsonParser().parse(str).getAsJsonObject();
        } catch (JsonSyntaxException unused) {
            throw new C9721b(4000, "json err " + str, "fromJson");
        }
    }

    /* renamed from: k */
    public Context m83529k() {
        return C0213f.m1377a();
    }

    /* renamed from: l */
    public void m83530l(File file, C13387c c13387c, C12122a c12122a) throws C9721b {
        String strM68022f = new C11322a(this.f62391d).m68022f(c13387c.m80419d(), c13387c.m80421f());
        if (FaqConstants.DISABLE_HA_REPORT.equals(strM68022f)) {
            return;
        }
        m83522d(strM68022f, file, c13387c, c12122a);
    }

    /* renamed from: m */
    public final String m83531m(C13387c c13387c, C11060c c11060c) throws C9721b {
        c11060c.m66664t("/up/up_init");
        TreeMap treeMap = new TreeMap();
        treeMap.put("nsp_fid", c13387c.m80421f());
        treeMap.put("nsp_fsize", String.valueOf(c13387c.m80427l()));
        return m83533o("/up/up_init", new PreUploadCallback("/up/up_init", m83523e(treeMap), c11060c.m66661q()), c11060c);
    }

    /* renamed from: n */
    public final long m83532n(File file) {
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* renamed from: o */
    public final String m83533o(String str, AbstractC4994a abstractC4994a, C11060c c11060c) throws Throwable {
        new CheckAppStatus().checkAllSendToFile();
        if (this.f62393f == null) {
            throw new C9721b(4001, "cer is null, cmd = " + c11060c.m66646b(), c11060c.m66646b());
        }
        String str2 = "https://" + this.f62393f.getNspHost() + str;
        try {
            C11839m.m70688i("CoreService", m83527i(str2, "x-hw-trace-id = ", c11060c.m66661q()));
            String str3 = (String) C12612a.m76105e(str2, abstractC4994a, this.f62388a, this.f62389b, c11060c);
            if (str3 != null && !str3.isEmpty()) {
                C11839m.m70688i("CoreService", m83527i("nsp request end.", "x-hw-trace-id = ", c11060c.m66661q()));
                C11839m.m70686d("CoreService", m83527i(str, "response = ", str3));
                return str3;
            }
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null. cmd = " + c11060c.m66646b(), c11060c.m66646b());
        } catch (C9721b e10) {
            throw new C9721b(e10.m60659c(), e10.m60663g(), e10.getMessage(), c11060c.m66646b());
        } catch (Throwable th2) {
            C11839m.m70687e("CoreService", m83527i(str2, th2));
            throw new C9721b(4000, m83527i(str2, th2), c11060c.m66646b());
        }
    }

    /* renamed from: p */
    public final void m83534p(C12122a c12122a) throws C9721b {
        if (c12122a.mo17782d()) {
            throw new C9721b(1002, "net disable or canceled by user");
        }
    }

    /* renamed from: q */
    public final boolean m83535q(File file) {
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            return true;
        }
        return file.getParentFile() != null && file.getParentFile().isFile();
    }

    /* renamed from: r */
    public final boolean m83536r(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* renamed from: s */
    public final C9721b m83537s(C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1002 && iM60659c != 1011 && iM60659c != 1102) {
            if (iM60659c == 1199) {
                return new C9721b(1106, c9721b.getMessage(), c9721b.m60658b());
            }
            if (iM60659c != 1201) {
                if (iM60659c == 3012) {
                    return new C9721b(3301, c9721b.getMessage(), c9721b.m60658b());
                }
                if (iM60659c != 3207) {
                    if (iM60659c == 9005) {
                        return new C9721b(3305, c9721b.getMessage(), c9721b.m60658b());
                    }
                    if (iM60659c == 4000) {
                        return new C9721b(3307, c9721b.m60663g(), c9721b.getMessage(), c9721b.m60658b());
                    }
                    if (iM60659c != 4001 && iM60659c != 4007 && iM60659c != 4008 && iM60659c != 4011 && iM60659c != 4012) {
                        switch (iM60659c) {
                            case ConnectionResult.NETWORK_ERROR /* 9000 */:
                                return new C9721b(3306, c9721b.m60663g(), c9721b.getMessage(), c9721b.m60658b());
                            case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                                return new C9721b(3302, c9721b.getMessage(), c9721b.m60658b());
                            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                                return new C9721b(3303, c9721b.getMessage(), c9721b.m60658b());
                            case 9003:
                                return new C9721b(3304, c9721b.getMessage(), c9721b.m60658b());
                            default:
                                return new C9721b(3308, c9721b.getMessage(), c9721b.m60658b());
                        }
                    }
                }
            }
        }
        return c9721b;
    }

    /* renamed from: t */
    public final void m83538t(File file, C13387c c13387c, C12122a c12122a, C11060c c11060c) throws Throwable {
        m83534p(c12122a);
        c11060c.m66664t("REQTPHP");
        TreeMap treeMap = new TreeMap();
        treeMap.put("nsp_fid", c13387c.m80421f());
        treeMap.put("nsp_fsize", String.valueOf(c13387c.m80427l()));
        m83542x(treeMap);
        String strM83533o = m83533o("/upload/up.php", new UploadPCallback(treeMap, new SliceItem(file, 0, 0L, file.length()), c11060c.m66661q(), c12122a), c11060c);
        try {
            JsonObject jsonObjectM83528j = m83528j(strM83533o);
            if (!jsonObjectM83528j.get("success").getAsBoolean()) {
                c11060c.m66635A("up.php error response = " + strM83533o);
                throw new C9721b(4000, "up.php response = " + strM83533o, "REQTPHP");
            }
            JsonObject asJsonObject = jsonObjectM83528j.get(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE).getAsJsonObject();
            C13385a c13385a = new C13385a(this.f62392e.m78143b());
            c13385a.m80379n(c13387c.m80421f());
            c13385a.m80380o(asJsonObject.get("path").getAsString());
            c13385a.m80381p(asJsonObject.get("sig").getAsString());
            c13385a.m80382q(asJsonObject.get("ts").getAsString());
            c13385a.m80375j(System.currentTimeMillis());
            new C13136a().m79016k(c13385a);
        } catch (JsonSyntaxException e10) {
            C11839m.m70688i("CoreService", "phpUpload json exception is: " + e10.toString());
            throw new C9721b(4000, "json err ");
        }
    }

    /* renamed from: u */
    public final Map<String, Object> m83539u(String str) throws C9721b {
        Result resultM78709H = new C13049a(this.f62392e, this.f62391d, this.f62388a, this.f62389b).m78709H(new String[]{str}, new String[]{"sslUrl", "md5", "size", JsbMapKeyNames.H5_LOC, "encoded"});
        List<Map<String, Object>> successList = resultM78709H.getSuccessList();
        if (resultM78709H.getFailList().isEmpty()) {
            return successList.get(0);
        }
        Result.ErrMsg errMsg = resultM78709H.getFailList().get(0);
        C11839m.m70687e("CoreService", m83527i("download getattr err. " + errMsg.toString(), new Object[0]));
        throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
    }

    /* renamed from: v */
    public final void m83540v(File file, File file2) throws C9721b {
        File fileM63437c = C10278a.m63437c(file);
        if (fileM63437c != null && !fileM63437c.exists() && fileM63437c.mkdirs()) {
            C11839m.m70686d("CoreService", "rename file, parent create success.");
        }
        if (file.exists() && !file.delete()) {
            C11839m.m70686d("CoreService", "rename file, delete old file error.");
            throw new C9721b(4001, "rename file, delete old file error,  file = " + C10279b.m63452a(file2));
        }
        boolean zM70640d = C11835i.m70640d(file2, file);
        if (!zM70640d) {
            C11839m.m70686d("CoreService", "use pms copy file, delete cache = " + file.delete());
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b != null) {
                zM70640d = interfaceC9283b.mo58525p(file, file2);
            }
            C11839m.m70686d("CoreService", "use pms copy file result = " + zM70640d);
        }
        if (zM70640d) {
            C11839m.m70686d("CoreService", "copy file success, delete source file = " + file2.delete());
            if (file.exists()) {
                return;
            }
            throw new C9721b(4001, "copy file success, but file not exist, file = " + C10279b.m63452a(file2));
        }
        C11839m.m70686d("CoreService", "copy file failed, delete source file = " + file2.delete());
        C9721b c9721b = new C9721b(4001, "CoreService renameFile error src = " + C10279b.m63452a(file2) + ", dest = " + C10279b.m63452a(file) + ", result = " + file.delete());
        String strM63452a = C10279b.m63452a(fileM63437c);
        boolean z10 = strM63452a != null && strM63452a.startsWith(C0221j.m1512v());
        if (!m83535q(fileM63437c) && !z10) {
            throw c9721b;
        }
        String str = this.f62391d;
        C11060c c11060cM66626a = C11058a.m66626a((str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f62391d, "renameFile", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("113_" + c9721b.m60659c());
        c11060cM66626a.m66635A(C10279b.m63452a(file) + ", " + c9721b.getMessage());
        C13622a.m81969o(m83529k(), c11060cM66626a, null);
    }

    /* renamed from: w */
    public final long[] m83541w(JsonObject jsonObject, C13387c c13387c, Map<String, String> map) throws C9721b {
        try {
            String asString = jsonObject.get("nsp_range").getAsString();
            String asString2 = jsonObject.get("nsp_fid").getAsString();
            long jM1688f = C0241z.m1688f(asString.split("-")[0]);
            long jM1688f2 = (C0241z.m1688f(asString.split("-")[1]) - jM1688f) + 1;
            map.put("nsp_range", asString);
            Iterator<Map.Entry<String, String>> it = this.f62390c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (next.getValue().equals(asString2)) {
                    String[] strArrSplit = next.getKey().split("-");
                    long jM1688f3 = C0241z.m1688f(strArrSplit[0]);
                    long jM1688f4 = C0241z.m1688f(strArrSplit[1]);
                    jM1688f += jM1688f3;
                    map.put("nsp_fid", next.getValue());
                    map.put("nsp_fsize", String.valueOf((jM1688f4 - jM1688f3) + 1));
                    break;
                }
            }
            if (map.containsKey("nsp_fid") && map.containsKey("nsp_fsize")) {
                map.put("nsp_pfid", c13387c.m80421f());
                map.put("nsp_pfsize", String.valueOf(c13387c.m80427l()));
            } else {
                map.put("nsp_fid", c13387c.m80421f());
                map.put("nsp_fsize", String.valueOf(c13387c.m80427l()));
            }
            return new long[]{jM1688f, jM1688f2};
        } catch (NumberFormatException e10) {
            throw new C9721b(3307, "nsp_range error." + e10.getMessage());
        }
    }

    /* renamed from: x */
    public final void m83542x(Map<String, String> map) throws C9721b {
        UploadCer uploadCer = this.f62393f;
        if (uploadCer == null) {
            throw new C9721b(4001, "cer is null");
        }
        map.put("nsp_app", uploadCer.getNspTapp());
        map.put("nsp_ver", this.f62393f.getNspTver());
        map.put("nsp_tstr", String.valueOf(this.f62393f.getNspTstr()));
        map.put("nsp_ts", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("nsp_fmt", "JSON");
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!"nsp_key".equals(key)) {
                sb2.append(key);
                sb2.append(value);
            }
        }
        map.put("nsp_key", C11476b.m68629k(sb2.toString(), this.f62393f.getSecret()).toUpperCase(Locale.US));
    }

    /* renamed from: y */
    public void m83543y(File file, C12122a c12122a, C13387c c13387c, C11060c c11060c) throws Throwable {
        C11839m.m70688i("CoreService", "file common upload start. traceID is " + this.f62391d);
        C13141f c13141f = new C13141f();
        c13141f.m79044k(c13387c);
        ICallback iCallbackMo17781a = c12122a.mo17781a();
        if (iCallbackMo17781a instanceof IPreCallback) {
            ((IPreCallback) iCallbackMo17781a).m16231a();
        }
        try {
            this.f62393f = C12765a.m76606f().m76607c(this.f62392e, this.f62391d);
            m83534p(c12122a);
            boolean zM83524f = m83524f(file, c13387c, c12122a, c11060c);
            m83534p(c12122a);
            c13387c.m80412F(2);
            c13387c.m80414H(System.currentTimeMillis());
            c13141f.m79044k(c13387c);
            if (zM83524f) {
                c11060c.m66665u("113_200");
                c11060c.m66635A("success");
                c11060c.m66638D("file = " + file.getName() + " fid = " + c13387c.m80421f() + " length = " + c13387c.m80427l());
                c11060c.m66641G(String.valueOf(c12122a.m72685b()));
                c11060c.m66642H(String.valueOf(System.currentTimeMillis() - c13387c.m80416a()));
            }
            C11839m.m70688i("CoreService", "file common upload end.");
        } catch (C9721b e10) {
            C13387c c13387cM79043j = c13141f.m79043j(this.f62392e.m78143b(), c13387c.m80421f());
            if (!c12122a.mo17782d() && c13387cM79043j != null && c13387cM79043j.m80430o() != 2) {
                c13387c.m80412F(3);
                c13387c.m80414H(System.currentTimeMillis());
                c13141f.m79044k(c13387c);
            }
            UploadCer uploadCer = this.f62393f;
            String nspHost = uploadCer != null ? uploadCer.getNspHost() : "";
            C9721b c9721bM83537s = m83537s(e10);
            C11839m.m70687e("CoreService", m83527i(nspHost, e10.m60658b(), c9721bM83537s, file));
            c11060c.m66665u("113_" + c9721bM83537s.m60659c());
            c11060c.m66635A(nspHost + e10.getMessage());
            c11060c.m66638D("file = " + file.getName() + " fid = " + c13387c.m80421f() + " length = " + c13387c.m80427l());
            c11060c.m66641G(String.valueOf(c12122a.m72685b()));
            C12765a.m76606f().m76608d();
            throw c9721bM83537s;
        }
    }
}
