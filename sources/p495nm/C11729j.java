package p495nm;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hms.network.embedded.C6142w9;

/* renamed from: nm.j */
/* loaded from: classes6.dex */
public class C11729j {

    /* renamed from: a */
    @SerializedName(C6142w9.f28873n)
    private String f54258a;

    /* renamed from: b */
    @SerializedName("lastModifyTime")
    private String f54259b;

    /* renamed from: c */
    @SerializedName("compressedSize")
    private long f54260c;

    /* renamed from: d */
    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String f54261d;

    /* renamed from: a */
    public long m69983a() {
        return this.f54260c;
    }

    /* renamed from: b */
    public String m69984b() {
        return this.f54261d;
    }

    /* renamed from: c */
    public String m69985c() {
        return this.f54259b;
    }

    /* renamed from: d */
    public void m69986d(long j10) {
        this.f54260c = j10;
    }

    /* renamed from: e */
    public void m69987e(String str) {
        this.f54258a = str;
    }

    /* renamed from: f */
    public void m69988f(String str) {
        this.f54261d = str;
    }

    /* renamed from: g */
    public void m69989g(String str) {
        this.f54259b = str;
    }

    public String toString() {
        return "compressedFileInfo = {encoding:" + this.f54258a + ",lastModifyTime:" + this.f54259b + ",compressedSize:" + this.f54260c + ",hash:" + this.f54261d + "}";
    }
}
