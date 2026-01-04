package p263en;

import com.huawei.openalliance.p169ad.constant.VastAttribute;

/* renamed from: en.a */
/* loaded from: classes6.dex */
public enum EnumC9527a {
    DEBUG("debug", "D", 0),
    INFO("info", "I", 1),
    WARN("warn", "W", 2),
    ERROR(VastAttribute.ERROR, "E", 3);


    /* renamed from: a */
    public final String f47360a;

    /* renamed from: b */
    public final String f47361b;

    /* renamed from: c */
    public final int f47362c;

    EnumC9527a(String str, String str2, int i10) {
        this.f47360a = str;
        this.f47362c = i10;
        this.f47361b = str2;
    }

    /* renamed from: b */
    public int m59520b() {
        return this.f47362c;
    }
}
