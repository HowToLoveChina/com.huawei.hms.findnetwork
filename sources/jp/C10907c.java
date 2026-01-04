package jp;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* renamed from: jp.c */
/* loaded from: classes7.dex */
public class C10907c {

    /* renamed from: a */
    @SerializedName(NotifyConstants.Keys.NOTIFY_TYPE)
    private String f51773a;

    /* renamed from: b */
    @SerializedName(NotifyConstants.Keys.NOTIFY_URI)
    private String f51774b;

    /* renamed from: a */
    public String m65945a() {
        return this.f51773a;
    }

    /* renamed from: b */
    public String m65946b() {
        return this.f51774b;
    }

    /* renamed from: c */
    public void m65947c(String str) {
        this.f51773a = str;
    }

    /* renamed from: d */
    public void m65948d(String str) {
        this.f51774b = str;
    }
}
