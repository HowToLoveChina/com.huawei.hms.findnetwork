package com.huawei.location.crowdsourcing.upload;

import as.C1016d;
import com.google.gson.annotations.SerializedName;
import fr.C9765b;
import gr.C10039b;
import gr.C10042e;
import hr.C10335a;
import java.util.TreeMap;

/* renamed from: com.huawei.location.crowdsourcing.upload.d */
/* loaded from: classes8.dex */
public final class C6756d {

    /* renamed from: com.huawei.location.crowdsourcing.upload.d$a */
    public static class a extends C10042e {

        /* renamed from: a */
        @SerializedName("reason")
        private String f31317a;

        /* renamed from: b */
        @SerializedName("resCode")
        private int f31318b = -1;

        /* renamed from: c */
        @SerializedName("serverDomain")
        private String f31319c;

        /* renamed from: d */
        @SerializedName("accessToken")
        private String f31320d;

        @Override // gr.C10042e
        /* renamed from: a */
        public final boolean mo38355a() {
            return this.f31318b == 0;
        }

        @Override // gr.C10042e
        /* renamed from: b */
        public final String mo38356b() {
            return C10335a.m63647a(this.f31318b);
        }

        /* renamed from: c */
        public final String m38364c() {
            String str = this.f31320d;
            return str == null ? "" : str;
        }

        /* renamed from: d */
        public final String m38365d() {
            String str = this.f31319c;
            return str == null ? "" : str;
        }
    }

    /* renamed from: a */
    public static C9765b m38363a(C9765b c9765b, TreeMap treeMap) {
        C1016d.m6186f("GetServerDomain", "getDomainFromCloud start");
        C10039b c10039b = new C10039b(c9765b.f48046a, "/v2/getServerDomain");
        c10039b.m62444p(treeMap).m62443o(c9765b.f48047b).m62434d("appID", "1063");
        a aVar = (a) c10039b.m62437g(a.class);
        if (aVar != null) {
            return new C9765b(aVar.m38365d(), aVar.m38364c());
        }
        C1016d.m6186f("GetServerDomain", "resp is null:");
        return null;
    }
}
