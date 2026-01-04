package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class SlotTemplateRsp {
    private List<String> deletedTemplates;
    private String slotId;
    private List<TemplateConfig> updatedTemplates;

    /* renamed from: a */
    public String m40542a() {
        return this.slotId;
    }

    /* renamed from: b */
    public List<TemplateConfig> m40543b() {
        return this.updatedTemplates;
    }

    /* renamed from: c */
    public List<String> m40544c() {
        return this.deletedTemplates;
    }
}
