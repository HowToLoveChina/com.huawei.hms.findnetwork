package com.huawei.location.crowdsourcing.upload;

import android.util.Pair;
import as.C1016d;
import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import es.C9542g;
import fr.C9764a;
import fr.C9765b;
import fr.C9766c;
import gr.C10039b;
import gr.C10042e;
import hr.C10335a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lu.C11343b;

/* renamed from: com.huawei.location.crowdsourcing.upload.c */
/* loaded from: classes8.dex */
public final class C6755c {

    /* renamed from: com.huawei.location.crowdsourcing.upload.c$a */
    public static class a extends C10042e {

        /* renamed from: a */
        @SerializedName("reason")
        String f31304a = "";

        /* renamed from: b */
        @SerializedName("resCode")
        int f31305b = -1;

        /* renamed from: c */
        @SerializedName("fileUniqueFlag")
        String f31306c = "";

        /* renamed from: d */
        @SerializedName("currentTime")
        String f31307d = "";

        /* renamed from: e */
        @SerializedName("uploadInfoList")
        List<C14449a> f31308e = new ArrayList();

        /* renamed from: f */
        @SerializedName("patchPolicyList")
        C9766c f31309f;

        /* renamed from: com.huawei.location.crowdsourcing.upload.c$a$a, reason: collision with other inner class name */
        public static class C14449a {

            /* renamed from: a */
            @SerializedName("uploadUrl")
            String f31310a = "";

            /* renamed from: b */
            @SerializedName("method")
            String f31311b = "";

            /* renamed from: c */
            @SerializedName("objectId")
            String f31312c = "";

            /* renamed from: d */
            @SerializedName("headers")
            Map<String, String> f31313d = new HashMap();

            public final String toString() {
                return "UploadInfo{method='" + this.f31311b + '}';
            }
        }

        public final String toString() {
            return "Resp{reason='" + this.f31304a + "', resCode='" + this.f31305b + "', fileUniqueFlag='" + this.f31306c + "', currentTime='" + this.f31307d + "', uploadInfoList=" + this.f31308e + ", patchPolicyList=" + this.f31309f + '}';
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.upload.c$b */
    public static class b {

        /* renamed from: a */
        @SerializedName("fileMd5")
        final String f31314a = "";

        /* renamed from: b */
        @SerializedName("fileSha256")
        final String f31315b;

        /* renamed from: c */
        @SerializedName("fileSize")
        final long f31316c;

        public b(String str, long j10) {
            this.f31315b = str;
            this.f31316c = j10;
        }
    }

    /* renamed from: a */
    public static Pair m38360a(C9765b c9765b, String str, TreeMap treeMap, C9766c c9766c) throws IOException {
        ArrayList arrayListM38362c;
        C9766c c9766c2;
        C9764a c9764a;
        File file = new File(str);
        if (!file.exists()) {
            C1016d.m6183c("GetUploadInfo", "file not exist");
            return null;
        }
        long length = file.length();
        C10039b c10039b = new C10039b(c9765b.f48046a, "/v2/getUploadInfo");
        c10039b.m62444p(treeMap).m62441m("logType", "0").m62441m(ContentResource.FILE_NAME, file.getName()).m62441m("fileSize", String.valueOf(length)).m62441m("encryptKey", "0").m62441m("others", "others").m62443o(c9765b.f48047b).m62434d("appID", "1063");
        long jM60792b = c9766c.m60792b();
        double d10 = length;
        long jCeil = (long) Math.ceil(d10 / c9766c.m60793c());
        if (jCeil > c9766c.m60792b()) {
            jM60792b = jCeil;
        }
        ArrayList arrayListM38362c2 = m38362c(file, jM60792b);
        a aVar = (a) c10039b.m62442n("fileHashList", C9542g.m59588a().toJsonTree(arrayListM38362c2, arrayListM38362c2.getClass()).getAsJsonArray().toString()).m62441m("patchSize", String.valueOf(jM60792b)).m62441m("patchNum", String.valueOf(arrayListM38362c2.size())).m62441m("patchVer", c9766c.m60791a()).m62437g(a.class);
        if (aVar == null) {
            C1016d.m6183c("GetUploadInfo", "server return null");
            return null;
        }
        if (aVar.f31305b == 200009) {
            c9766c2 = aVar.f31309f;
            if (c9766c2 == null) {
                C1016d.m6183c("GetUploadInfo", "200009 without patchPolicy");
                return null;
            }
            long jM60792b2 = c9766c2.m60792b();
            long jCeil2 = (long) Math.ceil(d10 / c9766c2.m60793c());
            long j10 = jCeil2 > c9766c2.m60792b() ? jCeil2 : jM60792b2;
            arrayListM38362c = m38362c(file, j10);
            aVar = (a) c10039b.m62442n("fileHashList", C9542g.m59588a().toJsonTree(arrayListM38362c, arrayListM38362c.getClass()).getAsJsonArray().toString()).m62441m("patchSize", String.valueOf(j10)).m62441m("patchNum", String.valueOf(arrayListM38362c.size())).m62441m("patchVer", c9766c2.m60791a()).m62437g(a.class);
            if (aVar == null) {
                C1016d.m6183c("GetUploadInfo", "redo failed");
                return null;
            }
        } else {
            arrayListM38362c = arrayListM38362c2;
            c9766c2 = c9766c;
        }
        if (aVar.f31305b != 0) {
            C1016d.m6183c("GetUploadInfo", "server return not success. error info:" + C10335a.m63647a(aVar.f31305b));
            return null;
        }
        if (aVar.f31308e == null || arrayListM38362c.size() != aVar.f31308e.size()) {
            C1016d.m6183c("GetUploadInfo", "size diff");
            c9764a = null;
        } else {
            String str2 = aVar.f31306c;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = aVar.f31307d;
            if (str3 == null) {
                str3 = "";
            }
            c9764a = new C9764a(str2, str3);
            for (int i10 = 0; i10 < arrayListM38362c.size(); i10++) {
                a.C14449a c14449a = aVar.f31308e.get(i10);
                String str4 = c14449a.f31310a;
                if (str4 == null) {
                    str4 = "";
                }
                Map map = c14449a.f31313d;
                if (map == null) {
                    map = new HashMap();
                }
                c9764a.f48042c.add(new C9764a.a(str4, ((b) arrayListM38362c.get(i10)).f31316c, map));
            }
        }
        if (c9764a == null) {
            return null;
        }
        return new Pair(c9766c2, c9764a);
    }

    /* renamed from: b */
    public static b m38361b(long j10, FileInputStream fileInputStream) throws NoSuchAlgorithmException, IOException {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1024];
            long j11 = j10;
            while (j11 > 0) {
                try {
                    int i10 = fileInputStream.read(bArr, 0, j11 < ((long) 1024) ? (int) j11 : 1024);
                    if (i10 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i10);
                    j11 -= i10;
                } catch (IOException unused) {
                    str = "read file error";
                    C1016d.m6183c("GetUploadInfo", str);
                    return null;
                }
            }
            long j12 = j10 - j11;
            if (j12 <= 0) {
                return null;
            }
            return new b(C11343b.m68146a(messageDigest.digest()), j12);
        } catch (NoSuchAlgorithmException unused2) {
            str = "NoSuchAlgorithmException SHA-256";
        }
    }

    /* renamed from: c */
    public static ArrayList m38362c(File file, long j10) throws IOException {
        ArrayList arrayList = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    b bVarM38361b = m38361b(j10, fileInputStream);
                    if (bVarM38361b == null) {
                        break;
                    }
                    arrayList.add(bVarM38361b);
                } finally {
                }
            }
            fileInputStream.close();
        } catch (IOException unused) {
            C1016d.m6183c("GetUploadInfo", "IOException");
        }
        return arrayList;
    }
}
