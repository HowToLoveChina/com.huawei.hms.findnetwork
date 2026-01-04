package com.huawei.openalliance.p169ad.beans.feedback;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdditionalContext {
    private String advertiseTitle = null;
    private String creativeId = "";
    private String slotId = "";
    private String landingPageUrl = null;
    private List<String> imageUrl = null;
    private List<String> videoUrl = null;
    private String advertiseId = null;

    /* renamed from: a */
    private String m39258a() {
        if (AbstractC7760bg.m47767a(this.imageUrl)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder("imageUrl");
        for (String str : this.imageUrl) {
            sb2.append("-");
            sb2.append(AbstractC7806cz.m48174f(str));
        }
        return sb2.toString();
    }

    /* renamed from: b */
    private String m39259b() {
        if (AbstractC7760bg.m47767a(this.videoUrl)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder("videoUrl:");
        for (String str : this.videoUrl) {
            sb2.append("-");
            sb2.append(AbstractC7806cz.m48174f(str));
        }
        return sb2.toString();
    }

    /* renamed from: c */
    private String m39260c() {
        if (AbstractC7806cz.m48165b(this.landingPageUrl)) {
            return "";
        }
        return "clickUrl:-" + AbstractC7806cz.m48174f(this.landingPageUrl);
    }

    /* renamed from: d */
    public void m39266d(String str) {
        this.landingPageUrl = str;
    }

    /* renamed from: e */
    public void m39267e(String str) {
        this.advertiseId = str;
    }

    public String toString() {
        return this.advertiseId + "-" + this.advertiseTitle + "-" + this.creativeId + "-" + this.slotId + "-" + m39258a() + m39259b() + m39260c();
    }

    /* renamed from: a */
    public void m39261a(String str) {
        this.advertiseTitle = str;
    }

    /* renamed from: b */
    public void m39263b(String str) {
        this.creativeId = str;
    }

    /* renamed from: c */
    public void m39265c(String str) {
        this.slotId = str;
    }

    /* renamed from: a */
    public void m39262a(List<String> list) {
        this.imageUrl = list;
    }

    /* renamed from: b */
    public void m39264b(List<String> list) {
        this.videoUrl = list;
    }
}
