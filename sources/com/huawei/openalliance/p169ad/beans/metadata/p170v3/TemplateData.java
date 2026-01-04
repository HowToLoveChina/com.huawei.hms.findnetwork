package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class TemplateData implements Serializable {
    private static final long serialVersionUID = 881899438177174869L;
    private String componentContext;
    private List<MotionData> motionData;
    private String motions;
    private String templateContext;

    public TemplateData() {
    }

    public TemplateData(String str, String str2, List<MotionData> list) {
        this.templateContext = str;
        this.motions = str2;
        this.motionData = list;
    }

    /* renamed from: a */
    public String m40549a() {
        return this.templateContext;
    }

    /* renamed from: b */
    public String m40552b() {
        return this.motions;
    }

    /* renamed from: c */
    public List<MotionData> m40554c() {
        return this.motionData;
    }

    /* renamed from: d */
    public String m40556d() {
        return this.componentContext;
    }

    /* renamed from: a */
    public void m40550a(String str) {
        this.templateContext = str;
    }

    /* renamed from: b */
    public void m40553b(String str) {
        this.motions = str;
    }

    /* renamed from: c */
    public void m40555c(String str) {
        this.componentContext = str;
    }

    /* renamed from: a */
    public void m40551a(List<MotionData> list) {
        this.motionData = list;
    }
}
