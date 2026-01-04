package jp;

import android.graphics.drawable.Drawable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;

/* renamed from: jp.b */
/* loaded from: classes7.dex */
public class C10906b {

    /* renamed from: a */
    @SerializedName(FrequencyManager.H5DialogConstant.BEGIN_TIME)
    private String f51760a;

    /* renamed from: b */
    @SerializedName("endTime")
    private String f51761b;

    /* renamed from: c */
    @SerializedName("id")
    private String f51762c;

    /* renamed from: d */
    @SerializedName("picture")
    private String f51763d;

    /* renamed from: e */
    @SerializedName("text")
    private String f51764e;

    /* renamed from: f */
    @SerializedName("displayOfCloseDays")
    private int f51765f;

    /* renamed from: g */
    @SerializedName("undisplayOfTimes")
    private int f51766g;

    /* renamed from: h */
    @SerializedName("priority")
    private int f51767h;

    /* renamed from: i */
    @SerializedName(NotifyConstants.TextLinkConst.ENTRANCE_KEY)
    private String[] f51768i;

    /* renamed from: j */
    @SerializedName("goto")
    private C10907c f51769j;

    /* renamed from: k */
    @SerializedName("userGroupExtIDs")
    private String[] f51770k;

    /* renamed from: l */
    public String f51771l;

    /* renamed from: m */
    public Drawable f51772m;

    /* renamed from: a */
    public String m65929a() {
        return this.f51760a;
    }

    /* renamed from: b */
    public int m65930b() {
        return this.f51765f;
    }

    /* renamed from: c */
    public Drawable m65931c() {
        return this.f51772m;
    }

    /* renamed from: d */
    public String m65932d() {
        return this.f51771l;
    }

    /* renamed from: e */
    public String m65933e() {
        return this.f51761b;
    }

    /* renamed from: f */
    public String[] m65934f() {
        return this.f51768i;
    }

    /* renamed from: g */
    public String m65935g() {
        return this.f51762c;
    }

    /* renamed from: h */
    public String m65936h() {
        return this.f51763d;
    }

    /* renamed from: i */
    public int m65937i() {
        return this.f51767h;
    }

    /* renamed from: j */
    public String m65938j() {
        return this.f51764e;
    }

    /* renamed from: k */
    public C10907c m65939k() {
        return this.f51769j;
    }

    /* renamed from: l */
    public int m65940l() {
        return this.f51766g;
    }

    /* renamed from: m */
    public String[] m65941m() {
        return this.f51770k;
    }

    /* renamed from: n */
    public void m65942n(Drawable drawable) {
        this.f51772m = drawable;
    }

    /* renamed from: o */
    public void m65943o(String str) {
        this.f51771l = str;
    }

    /* renamed from: p */
    public void m65944p(C10907c c10907c) {
        this.f51769j = c10907c;
    }
}
