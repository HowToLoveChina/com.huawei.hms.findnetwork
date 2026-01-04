package ba;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;

/* renamed from: ba.l */
/* loaded from: classes3.dex */
public class C1158l {

    /* renamed from: a */
    @SerializedName("id")
    private String f5441a;

    /* renamed from: b */
    @SerializedName("title")
    private String f5442b;

    /* renamed from: c */
    @SerializedName("description")
    private String f5443c;

    /* renamed from: d */
    @SerializedName("redirect")
    private b f5444d;

    /* renamed from: e */
    @SerializedName("type")
    private int f5445e;

    /* renamed from: f */
    @SerializedName("picture")
    private a f5446f;

    /* renamed from: ba.l$a */
    public static class a {

        /* renamed from: a */
        @SerializedName(HicloudH5ConfigManager.KEY_HASH)
        private String f5447a;

        /* renamed from: b */
        @SerializedName("resolution")
        private String f5448b;

        /* renamed from: c */
        @SerializedName("url")
        private String f5449c;

        /* renamed from: a */
        public String m7234a() {
            return this.f5447a;
        }

        /* renamed from: b */
        public String m7235b() {
            return this.f5449c;
        }
    }

    /* renamed from: ba.l$b */
    public static class b {

        /* renamed from: a */
        @SerializedName("type")
        private String f5450a;

        /* renamed from: b */
        @SerializedName(C2126b.MODULE_INFO_URI)
        private String f5451b;
    }

    /* renamed from: a */
    public a m7233a() {
        return this.f5446f;
    }
}
