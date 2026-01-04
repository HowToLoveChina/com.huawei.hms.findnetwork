package com.huawei.openalliance.p169ad.beans.metadata.p170v3;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class SlotTemplate {
    private String slotId;
    private List<TemplateConfig> templates;

    public SlotTemplate(String str, List<TemplateConfig> list) {
        this.slotId = str;
        this.templates = list;
    }
}
