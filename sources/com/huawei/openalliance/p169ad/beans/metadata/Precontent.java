package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.constant.AdConfigMapKey;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class Precontent extends RspBean {
    private Integer apiVer;
    private String assets;
    private List<Asset> assetsObj;
    private String contentid;
    private int creativetype;
    private String ctrlSwitchs;
    private List<ImageInfo> imageInfo;
    private List<MediaFile> mediaFileList;

    @InterfaceC6934f
    private List<String> noReportEventList;

    @InterfaceC6932d(m39225a = "prio")
    private Integer priority;
    private String slotid;

    @InterfaceC6932d(m39225a = AdConfigMapKey.SPLASH_PRELOAD_MODE)
    private Integer splashPreloadMode;
    private TemplateV3 template;
    private List<TemplateV3> templates;
    private VideoInfo videoInfo;

    /* renamed from: a */
    public String m40407a() {
        return this.slotid;
    }

    /* renamed from: b */
    public String m40415b() {
        return this.contentid;
    }

    /* renamed from: c */
    public int m40419c() {
        return this.creativetype;
    }

    /* renamed from: d */
    public List<ImageInfo> m40423d() {
        return this.imageInfo;
    }

    /* renamed from: e */
    public VideoInfo m40425e() {
        return this.videoInfo;
    }

    /* renamed from: f */
    public String m40426f() {
        return this.ctrlSwitchs;
    }

    /* renamed from: g */
    public List<String> m40427g() {
        return this.noReportEventList;
    }

    /* renamed from: h */
    public List<MediaFile> m40428h() {
        return this.mediaFileList;
    }

    /* renamed from: i */
    public Integer m40429i() {
        return this.priority;
    }

    /* renamed from: j */
    public Integer m40430j() {
        return this.apiVer;
    }

    /* renamed from: k */
    public String m40431k() {
        return this.assets;
    }

    /* renamed from: l */
    public TemplateV3 m40432l() {
        return this.template;
    }

    /* renamed from: m */
    public List<TemplateV3> m40433m() {
        return this.templates;
    }

    /* renamed from: n */
    public Integer m40434n() {
        return this.splashPreloadMode;
    }

    /* renamed from: a */
    public void m40408a(int i10) {
        this.creativetype = i10;
    }

    /* renamed from: b */
    public void m40416b(Integer num) {
        this.apiVer = num;
    }

    /* renamed from: c */
    public void m40420c(Integer num) {
        this.splashPreloadMode = num;
    }

    /* renamed from: d */
    public void m40424d(List<TemplateV3> list) {
        this.templates = list;
    }

    /* renamed from: a */
    public void m40409a(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    /* renamed from: b */
    public void m40417b(String str) {
        this.contentid = str;
    }

    /* renamed from: c */
    public void m40421c(String str) {
        this.ctrlSwitchs = str;
    }

    /* renamed from: a */
    public void m40410a(TemplateV3 templateV3) {
        this.template = templateV3;
    }

    /* renamed from: b */
    public void m40418b(List<MediaFile> list) {
        this.mediaFileList = list;
    }

    /* renamed from: c */
    public void m40422c(List<Asset> list) {
        this.assetsObj = list;
    }

    /* renamed from: a */
    public void m40411a(Integer num) {
        this.priority = num;
    }

    /* renamed from: a */
    public void m40412a(String str) {
        this.slotid = str;
    }

    /* renamed from: a */
    public void m40413a(List<ImageInfo> list) {
        this.imageInfo = list;
    }

    /* renamed from: a */
    public void m40414a(List<AdTypeEvent> list, int i10) {
        List<String> listM39580b;
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        for (AdTypeEvent adTypeEvent : list) {
            if (adTypeEvent != null && adTypeEvent.m39577a() == i10 && (listM39580b = adTypeEvent.m39580b()) != null && listM39580b.size() > 0) {
                ArrayList arrayList = new ArrayList();
                this.noReportEventList = arrayList;
                arrayList.addAll(listM39580b);
            }
        }
    }
}
