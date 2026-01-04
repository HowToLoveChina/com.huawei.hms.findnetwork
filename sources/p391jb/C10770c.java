package p391jb;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: jb.c */
/* loaded from: classes3.dex */
public class C10770c {

    /* renamed from: a */
    @SerializedName("actionList")
    private List<C10769b> f51495a;

    /* renamed from: b */
    @SerializedName(FrequencyManager.H5DialogConstant.BEGIN_TIME)
    private String f51496b;

    /* renamed from: c */
    @SerializedName("endTime")
    private String f51497c;

    /* renamed from: d */
    @SerializedName("frequency")
    private int f51498d;

    /* renamed from: e */
    @SerializedName("pageType")
    private String f51499e;

    /* renamed from: f */
    @SerializedName(FrequencyManager.H5DialogConstant.SCENETYPE)
    private String f51500f;

    /* renamed from: g */
    @SerializedName("priority")
    private int f51501g;

    /* renamed from: h */
    @SerializedName("intervalTime")
    private int f51502h;

    /* renamed from: i */
    @SerializedName("userGroupExtIDs")
    private ArrayList<String> f51503i;

    /* renamed from: a */
    public String m65589a() {
        return this.f51496b;
    }

    /* renamed from: b */
    public String m65590b() {
        return this.f51497c;
    }

    /* renamed from: c */
    public int m65591c() {
        return this.f51498d;
    }

    /* renamed from: d */
    public List<C10769b> m65592d() {
        return this.f51495a;
    }

    /* renamed from: e */
    public int m65593e() {
        return this.f51502h;
    }

    /* renamed from: f */
    public String m65594f() {
        return this.f51499e;
    }

    /* renamed from: g */
    public int m65595g() {
        return this.f51501g;
    }

    /* renamed from: h */
    public String m65596h() {
        return this.f51500f;
    }

    /* renamed from: i */
    public ArrayList<String> m65597i() {
        return this.f51503i;
    }
}
