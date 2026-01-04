package p705vb;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;
import java.util.Map;

/* renamed from: vb.b */
/* loaded from: classes3.dex */
public class C13393b {

    /* renamed from: a */
    @SerializedName(CallLogCons.DATE)
    private String f60383a;

    /* renamed from: b */
    @SerializedName("id")
    private String f60384b;

    /* renamed from: c */
    @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
    private List<C13392a> f60385c;

    /* renamed from: d */
    @SerializedName("resourceMap")
    private Map<String, CommonPicture> f60386d;

    /* renamed from: e */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage f60387e;

    /* renamed from: f */
    @SerializedName("version")
    private String f60388f;

    /* renamed from: a */
    public List<C13392a> m80478a() {
        return this.f60385c;
    }

    /* renamed from: b */
    public CommonLanguage m80479b() {
        return this.f60387e;
    }

    /* renamed from: c */
    public Map<String, CommonPicture> m80480c() {
        return this.f60386d;
    }
}
