package jp;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Map;

/* renamed from: jp.a */
/* loaded from: classes7.dex */
public class C10905a {

    /* renamed from: a */
    @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
    private C10906b[] f51754a;

    /* renamed from: b */
    @SerializedName(CallLogCons.DATE)
    private String f51755b;

    /* renamed from: c */
    @SerializedName("id")
    private String f51756c;

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage f51757d;

    /* renamed from: e */
    @SerializedName("resourceMap")
    private Map<String, CommonPicture> f51758e;

    /* renamed from: f */
    @SerializedName("version")
    private String f51759f;

    /* renamed from: a */
    public C10906b[] m65926a() {
        return this.f51754a;
    }

    /* renamed from: b */
    public CommonLanguage m65927b() {
        return this.f51757d;
    }

    /* renamed from: c */
    public Map<String, CommonPicture> m65928c() {
        return this.f51758e;
    }
}
