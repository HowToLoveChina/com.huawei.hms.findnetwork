package com.huawei.openalliance.p169ad.p171db.bean;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.Map;

@DataKeep
/* loaded from: classes2.dex */
public class TemplateStyleRecord extends C7013a {
    private static final String H5_TEMPLATE_TAG = "js";
    private static final int H5_TEMPLATE_TAG_VALUE = 1;
    public static final String SLOT_ID = "slotId";
    public static final String STYLE = "style";
    public static final String STYLE_VER = "styleVer";
    public static final String TAG = "tag";
    public static final String TEMPLATE_ID = "templateId";
    public static final String TMP_TYPE = "tmpType";
    private String slotId;
    private String style;
    private int styleVer;
    private String tag;
    private String templateId;
    private int tmpType;

    public TemplateStyleRecord() {
    }

    /* renamed from: a */
    public String m41824a() {
        return this.slotId;
    }

    /* renamed from: b */
    public String m41825b() {
        return this.templateId;
    }

    /* renamed from: c */
    public String m41826c() {
        return this.style;
    }

    /* renamed from: d */
    public int m41827d() {
        return this.styleVer;
    }

    /* renamed from: e */
    public String m41828e() {
        return this.tag;
    }

    public TemplateStyleRecord(String str, TemplateConfig templateConfig) {
        this.slotId = str;
        this.templateId = templateConfig.m40545a();
        this.style = templateConfig.m40547c();
        this.styleVer = templateConfig.m40546b();
        this.tag = templateConfig.m40548d();
        m41823a(templateConfig.m40548d());
    }

    /* renamed from: a */
    private void m41823a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC7185ho.m43818a("tag", "tag: %s", str);
        Map map = (Map) AbstractC7758be.m47739b(str, Map.class, Integer.class);
        if (C7765bl.m47802a(map)) {
            AbstractC7185ho.m43817a("tag", "tag is null");
        } else if (map.containsKey(H5_TEMPLATE_TAG) && ((Integer) map.get(H5_TEMPLATE_TAG)).intValue() == 1) {
            this.tmpType = 1;
        }
    }

    public TemplateStyleRecord(String str, TemplateConfig templateConfig, int i10) {
        this.slotId = str;
        this.templateId = templateConfig.m40545a();
        this.style = templateConfig.m40547c();
        this.styleVer = templateConfig.m40546b();
        this.tag = templateConfig.m40548d();
        this.tmpType = i10;
    }
}
