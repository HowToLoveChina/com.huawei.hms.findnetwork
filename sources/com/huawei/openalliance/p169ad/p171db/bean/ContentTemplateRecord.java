package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes2.dex */
public class ContentTemplateRecord extends C7013a implements Serializable {
    public static final String ASSETS = "assets";
    public static final String CONTENT_ID = "contentId";
    public static final String MOTIONS = "motions";
    public static final String MOTION_DATA = "motionData";
    public static final String TEMPLATE_CONTEXT = "templateContext";
    public static final String TEMPLATE_ID = "templateId";
    private static final long serialVersionUID = 1999006876326113126L;
    private List<Asset> assets;
    private String contentId;
    private List<MotionData> motionData;
    private String motions;
    private String strAssets;
    private String templateContext;
    private String templateId;
    private String templateUrl;

    public ContentTemplateRecord() {
    }

    /* renamed from: a */
    public String m41643a() {
        return this.contentId;
    }

    /* renamed from: b */
    public String m41645b() {
        return this.templateId;
    }

    /* renamed from: c */
    public List<Asset> m41646c() {
        return this.assets;
    }

    /* renamed from: d */
    public String m41647d() {
        return this.templateContext;
    }

    /* renamed from: e */
    public String m41648e() {
        return this.motions;
    }

    /* renamed from: f */
    public List<MotionData> m41649f() {
        return this.motionData;
    }

    /* renamed from: g */
    public String m41650g() {
        return this.strAssets;
    }

    public ContentTemplateRecord(String str, String str2, List<Asset> list, TemplateData templateData, String str3) {
        this.contentId = str;
        this.templateId = str2;
        this.assets = list;
        this.strAssets = str3;
        if (templateData != null) {
            this.templateContext = templateData.m40549a();
            this.motions = templateData.m40552b();
            this.motionData = templateData.m40554c();
        }
    }

    /* renamed from: a */
    public void m41644a(String str) {
        this.templateUrl = str;
    }
}
