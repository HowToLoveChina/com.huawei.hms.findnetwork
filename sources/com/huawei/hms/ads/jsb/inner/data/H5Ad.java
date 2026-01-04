package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes8.dex */
public class H5Ad {
    private String abilityDetailInfo;
    private String adChoiceUrl;
    private int adType;
    private List<AdvertiserInfo> advertiserInfos;
    private int apiVer;
    private App app;
    private String bannerRefSetting;
    private String clickBtnTxt;
    private String contentId;
    private int creativeType;
    private CtrlExt ctrlExt;
    private String desc;
    private String dspLogo;
    private String dspName;
    private long endTime;
    private Map<String, String> ext;
    private ImageInfo icon;
    private List<ImageInfo> imgList;
    private int interactionType;
    private boolean isGaussianBlur;
    private boolean isSilentReserve;
    private List<String> keywords;
    private String label;
    private String logo2Text;
    private MediaFile mediaFile;
    private int minEffectiveShowRatio;
    private long minEffectiveShowTime;
    private String requestId;
    private RewardItem rewardItem;
    private int sequence;
    private boolean showAppElement;
    private String showId;
    private String slotId;
    private String source;
    private String taskId;
    private String templateId;
    private String title;
    private boolean transparencyOpen;
    private boolean transparencySwitch;
    private String transparencyTplUrl;
    private String uniqueId;
    private Video video;

    public H5Ad() {
        this.apiVer = 2;
    }

    /* renamed from: a */
    public int m30368a() {
        return this.adType;
    }

    public H5Ad(C7301d c7301d) {
        this.apiVer = 2;
        if (c7301d == null) {
            return;
        }
        this.requestId = c7301d.m44636f();
        this.uniqueId = c7301d.getUniqueId();
        this.showId = c7301d.getShowId();
        this.slotId = c7301d.m44710Q();
        this.contentId = c7301d.getContentId();
        this.taskId = c7301d.getTaskId();
        this.rewardItem = c7301d.m44684D();
        this.ctrlExt = c7301d.m44627d();
        this.showAppElement = c7301d.isShowAppElement();
        this.transparencyOpen = c7301d.isTransparencyOpen();
        this.transparencyTplUrl = c7301d.getTransparencyTplUrl();
        this.transparencySwitch = c7301d.m44675z();
        this.abilityDetailInfo = c7301d.getAbilityDetailInfo();
        if (AbstractC7760bg.m47767a(c7301d.getCompliance())) {
            return;
        }
        this.advertiserInfos = c7301d.getCompliance();
    }

    public H5Ad(C7302e c7302e) {
        this.apiVer = 2;
        if (c7302e == null) {
            return;
        }
        this.isSilentReserve = AbstractC7558os.m46458F(c7302e.getCtrlSwitchs());
        this.requestId = c7302e.m44636f();
        this.uniqueId = c7302e.getUniqueId();
        this.showId = c7302e.getShowId();
        this.slotId = c7302e.getSlotId();
        this.contentId = c7302e.getContentId();
        this.taskId = c7302e.getTaskId();
        this.adType = c7302e.m44632e();
        this.creativeType = c7302e.getCreativeType();
        this.interactionType = c7302e.getInterActionType();
        this.endTime = c7302e.getEndTime();
        this.minEffectiveShowTime = c7302e.getMinEffectiveShowTime();
        this.minEffectiveShowRatio = c7302e.getMinEffectiveShowRatio();
        this.desc = AbstractC7806cz.m48170d(c7302e.getDescription());
        this.title = AbstractC7806cz.m48170d(c7302e.getTitle());
        this.dspName = AbstractC7806cz.m48170d(c7302e.getDspName());
        this.dspLogo = c7302e.getDspLogo();
        this.logo2Text = AbstractC7806cz.m48170d(c7302e.m44667u());
        this.label = AbstractC7806cz.m48170d(c7302e.getLabel());
        this.source = AbstractC7806cz.m48170d(c7302e.getLabel());
        this.clickBtnTxt = AbstractC7806cz.m48170d(c7302e.getCta());
        this.adChoiceUrl = c7302e.getAdChoiceUrl();
        this.ctrlExt = c7302e.m44627d();
        this.showAppElement = c7302e.isShowAppElement();
        this.transparencyOpen = c7302e.isTransparencyOpen();
        this.transparencyTplUrl = c7302e.getTransparencyTplUrl();
        this.transparencySwitch = c7302e.m44675z();
        this.abilityDetailInfo = c7302e.getAbilityDetailInfo();
        if (!AbstractC7760bg.m47767a(c7302e.getAdCloseKeyWords())) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = c7302e.getAdCloseKeyWords().iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7806cz.m48170d(it.next()));
            }
            this.keywords = arrayList;
        }
        this.isGaussianBlur = c7302e.isUseGaussianBlur();
        this.bannerRefSetting = c7302e.m44816al();
        if (c7302e.getAppInfo() != null) {
            this.app = new App(c7302e.getAppInfo());
        }
        this.icon = new ImageInfo(c7302e.getIcon());
        if (c7302e.getVideoInfo() != null) {
            this.video = new Video(c7302e.getVideoInfo());
        }
        if (!AbstractC7760bg.m47767a(c7302e.getImageInfos())) {
            ArrayList arrayList2 = new ArrayList();
            for (com.huawei.openalliance.p169ad.inter.data.ImageInfo imageInfo : c7302e.getImageInfos()) {
                if (imageInfo != null) {
                    arrayList2.add(new ImageInfo(imageInfo));
                }
            }
            this.imgList = arrayList2;
        }
        List<ImpEX> listM44817am = c7302e.m44817am();
        HashMap map = new HashMap();
        if (!AbstractC7760bg.m47767a(listM44817am)) {
            for (ImpEX impEX : listM44817am) {
                map.put(impEX.m40188a(), impEX.m40190b());
            }
        }
        this.ext = map;
        if (AbstractC7760bg.m47767a(c7302e.getAdvertiserInfo())) {
            return;
        }
        this.advertiserInfos = c7302e.getAdvertiserInfo();
    }

    public H5Ad(C7304g c7304g) {
        this.apiVer = 2;
        if (c7304g == null) {
            return;
        }
        this.requestId = c7304g.m44636f();
        this.uniqueId = c7304g.getUniqueId();
        this.showId = c7304g.getShowId();
        this.slotId = c7304g.m44879H();
        this.contentId = c7304g.getContentId();
        this.taskId = c7304g.getTaskId();
        this.adType = c7304g.m44632e();
        this.creativeType = c7304g.getCreativeType();
        this.interactionType = c7304g.getInterActionType();
        this.endTime = c7304g.getEndTime();
        this.minEffectiveShowTime = c7304g.getMinEffectiveShowTime();
        this.minEffectiveShowRatio = c7304g.getMinEffectiveShowRatio();
        this.source = c7304g.getLabel();
        this.clickBtnTxt = c7304g.getCta();
        this.sequence = c7304g.getSequence();
        this.adChoiceUrl = c7304g.getAdChoiceUrl();
        this.ctrlExt = c7304g.m44627d();
        this.showAppElement = c7304g.isShowAppElement();
        this.transparencyOpen = c7304g.isTransparencyOpen();
        this.transparencyTplUrl = c7304g.getTransparencyTplUrl();
        this.transparencySwitch = c7304g.m44675z();
        this.abilityDetailInfo = c7304g.getAbilityDetailInfo();
        if (c7304g.getAppInfo() != null) {
            this.app = new App(c7304g.getAppInfo());
        }
        if (c7304g.getMediaFile() != null) {
            this.mediaFile = new MediaFile(c7304g.getMediaFile());
        }
        if (AbstractC7760bg.m47767a(c7304g.getAdvertiserInfo())) {
            return;
        }
        this.advertiserInfos = c7304g.getAdvertiserInfo();
    }

    public H5Ad(C7305h c7305h) {
        this.apiVer = 2;
        if (c7305h == null) {
            return;
        }
        this.requestId = c7305h.m44636f();
        this.uniqueId = c7305h.getUniqueId();
        this.showId = c7305h.getShowId();
        this.slotId = c7305h.m44932R();
        this.contentId = c7305h.getContentId();
        this.taskId = c7305h.getTaskId();
        this.rewardItem = c7305h.getRewardItem();
        this.ctrlExt = c7305h.m44627d();
        this.showAppElement = c7305h.isShowAppElement();
        this.transparencyOpen = c7305h.isTransparencyOpen();
        this.transparencyTplUrl = c7305h.getTransparencyTplUrl();
        this.transparencySwitch = c7305h.m44675z();
        this.abilityDetailInfo = c7305h.getAbilityDetailInfo();
        if (!AbstractC7760bg.m47767a(c7305h.getCompliance())) {
            this.advertiserInfos = c7305h.getCompliance();
        }
        this.apiVer = c7305h.m44957al() != null ? c7305h.m44957al().intValue() : 2;
        this.templateId = c7305h.m44954ai();
    }
}
