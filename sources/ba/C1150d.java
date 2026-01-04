package ba;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.p106db.bean.ConfigPictureParam;

/* renamed from: ba.d */
/* loaded from: classes3.dex */
public class C1150d {

    /* renamed from: a */
    @SerializedName("id")
    private String f5418a;

    /* renamed from: b */
    @SerializedName(FrequencyManager.H5DialogConstant.BEGIN_TIME)
    private String f5419b;

    /* renamed from: c */
    @SerializedName("endTime")
    private String f5420c;

    /* renamed from: d */
    @SerializedName("adId")
    private String f5421d;

    /* renamed from: e */
    @SerializedName("backColor")
    private String f5422e;

    /* renamed from: f */
    @SerializedName("banner_pictures")
    private ConfigPictureParam[] f5423f;

    /* renamed from: g */
    @SerializedName("buyPage")
    private C1155i f5424g;

    /* renamed from: h */
    @SerializedName(NotifyConstants.TextLinkConst.ENTRANCE_KEY)
    private String[] f5425h;

    /* renamed from: i */
    @SerializedName("txt")
    private C1154h f5426i;

    /* renamed from: j */
    @SerializedName("detailPage")
    private C1151e f5427j;

    /* renamed from: k */
    @SerializedName("tasks")
    private C1158l[] f5428k;

    /* renamed from: l */
    @SerializedName("awards_banner_pictures")
    private C1157k[] f5429l;

    /* renamed from: m */
    @SerializedName("accept_button_backColor")
    private String f5430m;

    /* renamed from: a */
    public C1157k[] m7221a() {
        return this.f5429l;
    }

    /* renamed from: b */
    public C1155i m7222b() {
        return this.f5424g;
    }

    /* renamed from: c */
    public ConfigPictureParam[] m7223c() {
        ConfigPictureParam[] configPictureParamArr = this.f5423f;
        if (configPictureParamArr == null) {
            return new ConfigPictureParam[0];
        }
        ConfigPictureParam[] configPictureParamArr2 = (ConfigPictureParam[]) configPictureParamArr.clone();
        this.f5423f = configPictureParamArr2;
        return configPictureParamArr2;
    }

    /* renamed from: d */
    public C1158l[] m7224d() {
        return this.f5428k;
    }
}
