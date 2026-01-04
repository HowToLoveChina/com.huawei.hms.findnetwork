package p391jb;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.List;

/* renamed from: jb.b */
/* loaded from: classes3.dex */
public class C10769b {

    /* renamed from: a */
    @SerializedName(Constants.CONTENT_SERVER_REALM)
    private int f51488a;

    /* renamed from: b */
    @SerializedName("goto")
    private C10768a f51489b;

    /* renamed from: c */
    @SerializedName("url")
    private String f51490c;

    /* renamed from: d */
    @SerializedName("times")
    private List<Integer> f51491d;

    /* renamed from: e */
    @SerializedName("transCornerMark")
    private boolean f51492e;

    /* renamed from: f */
    @SerializedName("transEndTime")
    private String f51493f;

    /* renamed from: g */
    @SerializedName(NotifyConstants.NotificationReport.KEY_ORDER)
    private int f51494g;

    /* renamed from: a */
    public int m65584a() {
        return this.f51488a;
    }

    /* renamed from: b */
    public C10768a m65585b() {
        return this.f51489b;
    }

    /* renamed from: c */
    public int m65586c() {
        return this.f51494g;
    }

    /* renamed from: d */
    public List<Integer> m65587d() {
        return this.f51491d;
    }

    /* renamed from: e */
    public String m65588e() {
        return this.f51490c;
    }
}
