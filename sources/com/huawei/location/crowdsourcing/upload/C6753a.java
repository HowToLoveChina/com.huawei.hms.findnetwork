package com.huawei.location.crowdsourcing.upload;

import as.C1016d;
import com.google.gson.annotations.SerializedName;
import fr.C9765b;
import gr.C10039b;
import gr.C10042e;
import hr.C10335a;
import java.util.TreeMap;

/* renamed from: com.huawei.location.crowdsourcing.upload.a */
/* loaded from: classes8.dex */
public final class C6753a {

    /* renamed from: com.huawei.location.crowdsourcing.upload.a$a */
    public static class a extends C10042e {

        /* renamed from: a */
        @SerializedName("resCode")
        private int f31303a = -1;

        @Override // gr.C10042e
        /* renamed from: a */
        public final boolean mo38355a() {
            return this.f31303a == 0;
        }

        @Override // gr.C10042e
        /* renamed from: b */
        public final String mo38356b() {
            return C10335a.m63647a(this.f31303a);
        }
    }

    /* renamed from: a */
    public static boolean m38354a(TreeMap treeMap, C9765b c9765b, String str, String str2) {
        C1016d.m6186f("NotifySuccess", "doNotifySuccess start");
        C10039b c10039b = new C10039b(c9765b.f48046a, "/v2/notifyUploadSucc");
        c10039b.m62444p(treeMap).m62441m("fileUniqueFlag", str).m62441m("uploadTime", str2).m62443o(c9765b.f48047b).m62434d("appID", "1063");
        a aVar = (a) c10039b.m62437g(a.class);
        return aVar != null && aVar.mo38355a();
    }
}
