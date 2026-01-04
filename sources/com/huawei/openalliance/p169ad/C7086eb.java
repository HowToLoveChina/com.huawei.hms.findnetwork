package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Data;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Image;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.ImageExt;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Title;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Video;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.AudioInfo;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AdSourceFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AdvertiserInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AppInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AssetFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AudioInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.BiddingInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ContentExtFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.DataFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.DefaultTemplateFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.FeedbackInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImageExtFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImageFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImageInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImpEXFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.InstallConfigFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.MonitorFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.MotionDataFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.OmFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.PermissionEntityFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.PromoteInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.TemplateDataFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.TitleFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.VideoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.VideoInfoFb;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.eb */
/* loaded from: classes8.dex */
public class C7086eb {
    /* renamed from: a */
    public static float m42842a(Float f10) {
        if (f10 == null) {
            return -1111.0f;
        }
        return f10.floatValue();
    }

    /* renamed from: b */
    public static int[] m42858b(List<MotionData> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                MotionData motionData = list.get(i10);
                if (motionData != null) {
                    iArr[i10] = MotionDataFb.createMotionDataFb(flatBufferBuilder, motionData.m40524a(), flatBufferBuilder.createString(C7087ec.m42868a(motionData.m40539g())), motionData.m40528b(), motionData.m40531c(), flatBufferBuilder.createString(C7087ec.m42868a(motionData.m40534d())), motionData.m40537e(), flatBufferBuilder.createString(C7087ec.m42868a(motionData.m40540h())), motionData.m40538f(), flatBufferBuilder.createString(C7087ec.m42868a(motionData.m40541i())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: c */
    public static int[] m42859c(List<Asset> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                Asset asset = list.get(i10);
                if (asset != null) {
                    iArr[i10] = AssetFb.createAssetFb(flatBufferBuilder, asset.m40505a(), flatBufferBuilder.createString(C7087ec.m42868a(asset.m40512b())), flatBufferBuilder.createString(C7087ec.m42868a(asset.m40520h())), m42847a(asset.m40514c(), flatBufferBuilder), m42848a(asset.m40516d(), flatBufferBuilder), m42851a(asset.m40517e(), flatBufferBuilder), m42850a(asset.m40518f(), flatBufferBuilder), flatBufferBuilder.createString(C7087ec.m42868a(asset.m40519g())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: d */
    public static int[] m42860d(List<FeedbackInfo> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                FeedbackInfo feedbackInfo = list.get(i10);
                if (feedbackInfo != null) {
                    iArr[i10] = FeedbackInfoFb.createFeedbackInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(feedbackInfo.getLabel())), feedbackInfo.getType(), feedbackInfo.m44464a());
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: e */
    public static int[] m42861e(List<ContentExt> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                ContentExt contentExt = list.get(i10);
                if (contentExt != null) {
                    iArr[i10] = ContentExtFb.createContentExtFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(contentExt.m40009a())), flatBufferBuilder.createString(C7087ec.m42868a(contentExt.m40011b())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: f */
    public static int[] m42862f(List<ImpEX> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                ImpEX impEX = list.get(i10);
                if (impEX != null) {
                    iArr[i10] = ImpEXFb.createImpEXFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(impEX.m40188a())), flatBufferBuilder.createString(C7087ec.m42868a(impEX.m40190b())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: g */
    public static int[] m42863g(List<PermissionEntity> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                PermissionEntity permissionEntity = list.get(i10);
                if (permissionEntity != null) {
                    iArr[i10] = PermissionEntityFb.createPermissionEntityFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(permissionEntity.getName())), permissionEntity.getType());
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: h */
    public static int[] m42864h(List<ImageInfo> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = m42855a(list.get(i10), flatBufferBuilder);
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: i */
    public static int[] m42865i(List<AdvertiserInfo> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                AdvertiserInfo advertiserInfo = list.get(i10);
                if (advertiserInfo != null) {
                    iArr[i10] = AdvertiserInfoFb.createAdvertiserInfoFb(flatBufferBuilder, advertiserInfo.getSeq().intValue(), flatBufferBuilder.createString(C7087ec.m42868a(advertiserInfo.getKey())), flatBufferBuilder.createString(C7087ec.m42868a(advertiserInfo.getValue())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: j */
    public static int[] m42866j(List<C6957Om> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                C6957Om c6957Om = list.get(i10);
                if (c6957Om != null) {
                    iArr[i10] = OmFb.createOmFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(c6957Om.m40366a())), flatBufferBuilder.createString(C7087ec.m42868a(c6957Om.m40368b())), flatBufferBuilder.createString(C7087ec.m42868a(c6957Om.m40370c())));
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: k */
    public static int[] m42867k(List<AdSource> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                AdSource adSource = list.get(i10);
                if (adSource != null) {
                    iArr[i10] = AdSourceFb.createAdSourceFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(adSource.m39551a())), flatBufferBuilder.createString(C7087ec.m42868a(adSource.m39554b())), adSource.m39556c());
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }

    /* renamed from: a */
    public static int m42843a(DefaultTemplate defaultTemplate, FlatBufferBuilder flatBufferBuilder) {
        if (defaultTemplate == null) {
            return 0;
        }
        return DefaultTemplateFb.createDefaultTemplateFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(defaultTemplate.m40014a())), defaultTemplate.m40017b() != null ? defaultTemplate.m40017b().intValue() : 0);
    }

    /* renamed from: a */
    public static int m42844a(InstallConfig installConfig, FlatBufferBuilder flatBufferBuilder) {
        if (installConfig == null) {
            return 0;
        }
        return InstallConfigFb.createInstallConfigFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(installConfig.m40192a())), flatBufferBuilder.createString(C7087ec.m42868a(installConfig.m40194b())), flatBufferBuilder.createString(C7087ec.m42868a(installConfig.m40196c())));
    }

    /* renamed from: a */
    public static int m42845a(PromoteInfo promoteInfo, FlatBufferBuilder flatBufferBuilder) {
        if (promoteInfo == null) {
            return 0;
        }
        return PromoteInfoFb.createPromoteInfoFb(flatBufferBuilder, promoteInfo.getType(), flatBufferBuilder.createString(C7087ec.m42868a(promoteInfo.getName())));
    }

    /* renamed from: a */
    public static int m42846a(TemplateData templateData, FlatBufferBuilder flatBufferBuilder) {
        if (templateData == null) {
            return 0;
        }
        return TemplateDataFb.createTemplateDataFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(templateData.m40549a())), flatBufferBuilder.createString(C7087ec.m42868a(templateData.m40552b())), TemplateDataFb.createMotionDataVector(flatBufferBuilder, m42858b(templateData.m40554c(), flatBufferBuilder)), flatBufferBuilder.createString(C7087ec.m42868a(templateData.m40556d())));
    }

    /* renamed from: a */
    public static int m42847a(Data data, FlatBufferBuilder flatBufferBuilder) {
        if (data == null) {
            return 0;
        }
        return DataFb.createDataFb(flatBufferBuilder, data.m40567a(), flatBufferBuilder.createString(C7087ec.m42868a(data.m40570b())), data.m40572c());
    }

    /* renamed from: a */
    public static int m42848a(Image image, FlatBufferBuilder flatBufferBuilder) {
        if (image == null) {
            return 0;
        }
        return ImageFb.createImageFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(image.m40573a())), image.m40577b(), image.m40580c(), m42849a(image.m40581d(), flatBufferBuilder), flatBufferBuilder.createString(C7087ec.m42868a(image.m40582e())));
    }

    /* renamed from: a */
    public static int m42849a(ImageExt imageExt, FlatBufferBuilder flatBufferBuilder) {
        if (imageExt == null) {
            return 0;
        }
        return ImageExtFb.createImageExtFb(flatBufferBuilder, imageExt.m40583a(), flatBufferBuilder.createString(C7087ec.m42868a(imageExt.m40587b())), flatBufferBuilder.createString(C7087ec.m42868a(imageExt.m40589c())), imageExt.m40590d());
    }

    /* renamed from: a */
    public static int m42850a(Title title, FlatBufferBuilder flatBufferBuilder) {
        if (title == null) {
            return 0;
        }
        return TitleFb.createTitleFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(title.m40591a())), title.m40594b());
    }

    /* renamed from: a */
    public static int m42851a(Video video, FlatBufferBuilder flatBufferBuilder) {
        if (video == null) {
            return 0;
        }
        return VideoFb.createVideoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(video.m40595a())), video.m40599b(), video.m40603c(), video.m40606d(), video.m40609e(), flatBufferBuilder.createString(C7087ec.m42868a(video.m40610f())), flatBufferBuilder.createString(C7087ec.m42868a(video.m40611g())), video.m40612h(), flatBufferBuilder.createString(C7087ec.m42868a(video.m40613i())), video.m40614j());
    }

    /* renamed from: a */
    public static int m42852a(AppInfo appInfo, FlatBufferBuilder flatBufferBuilder) {
        if (appInfo == null) {
            return 0;
        }
        int[] iArrM42863g = m42863g(appInfo.getPermissions(), flatBufferBuilder);
        return AppInfoFb.createAppInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getAppName())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getPackageName())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getVersionCode())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getVersionName())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getIconUrl())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getDownloadUrl())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getSafeDownloadUrl())), appInfo.getFileSize(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getSha256())), appInfo.isCheckSha256(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getIntentUri())), AppInfoFb.createPermissionsVector(flatBufferBuilder, iArrM42863g), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getPriorInstallWay())), m42844a(appInfo.m44375b(), flatBufferBuilder), appInfo.isPermPromptForCard(), appInfo.isPermPromptForLanding(), appInfo.m44391e(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44397g())), appInfo.m44400h(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getUniqueId())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getAppDesc())), appInfo.m44403i(), appInfo.m44406j(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44394f())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44409k())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44412l())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44428t())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44430u())), appInfo.m44418o(), appInfo.m44420p(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44422q())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44424r())), appInfo.m44426s(), appInfo.isAllowedNonWifiNetwork(), appInfo.m44360K() != null ? appInfo.m44360K().intValue() : 0, flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44436x())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44438y())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getDeveloperName())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44432v())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44440z())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44340A())), appInfo.m44342B(), appInfo.m44344C(), appInfo.m44346D(), appInfo.m44348E(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44350F())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44352G())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44354H())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44356I())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44358J())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getPermissionUrl())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getAppDetailUrl())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44362L())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44366a())), appInfo.m44383c(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.m44388d())), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getHot())), appInfo.getRateNum() == null ? -1L : appInfo.getRateNum().longValue(), appInfo.getDownloadNum() == null ? -1L : appInfo.getDownloadNum().longValue(), flatBufferBuilder.createString(C7087ec.m42868a(appInfo.getDownCountDesc())));
    }

    /* renamed from: a */
    public static int m42853a(AudioInfo audioInfo, FlatBufferBuilder flatBufferBuilder) {
        if (audioInfo == null) {
            return 0;
        }
        return AudioInfoFb.createAudioInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(audioInfo.getUrl())), audioInfo.getDuration(), audioInfo.getFileSize(), flatBufferBuilder.createString(C7087ec.m42868a(audioInfo.getSha256())), flatBufferBuilder.createString(C7087ec.m42868a(audioInfo.getMime())));
    }

    /* renamed from: a */
    public static int m42854a(BiddingInfo biddingInfo, FlatBufferBuilder flatBufferBuilder) {
        if (biddingInfo == null) {
            return 0;
        }
        return BiddingInfoFb.createBiddingInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(biddingInfo.getCur())), m42842a(biddingInfo.getPrice()), flatBufferBuilder.createString(C7087ec.m42868a(biddingInfo.getLurl())), flatBufferBuilder.createString(C7087ec.m42868a(biddingInfo.getNurl())));
    }

    /* renamed from: a */
    public static int m42855a(ImageInfo imageInfo, FlatBufferBuilder flatBufferBuilder) {
        if (imageInfo == null) {
            return 0;
        }
        return ImageInfoFb.createImageInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(imageInfo.getUrl())), flatBufferBuilder.createString(C7087ec.m42868a(imageInfo.getOriginalUrl())), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getFileSize(), flatBufferBuilder.createString(C7087ec.m42868a(imageInfo.getSha256())), imageInfo.isCheckSha256(), flatBufferBuilder.createString(C7087ec.m42868a(imageInfo.getImageType())));
    }

    /* renamed from: a */
    public static int m42856a(VideoInfo videoInfo, FlatBufferBuilder flatBufferBuilder) {
        if (videoInfo == null) {
            return 0;
        }
        return VideoInfoFb.createVideoInfoFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.getVideoDownloadUrl())), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.m44586g())), videoInfo.getVideoDuration(), videoInfo.getVideoFileSize(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.getVideoAutoPlay())), videoInfo.getAutoPlayNetwork(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.getVideoAutoPlayWithSound())), videoInfo.getTimeBeforeVideoAutoPlay(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.getSha256())), videoInfo.m44566b(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.getSoundSwitch())), videoInfo.getVideoPlayMode(), videoInfo.isCheckSha256(), videoInfo.m44574c(), videoInfo.isBackFromFullScreen(), videoInfo.getAutoPlayAreaRatio(), videoInfo.getAutoStopPlayAreaRatio(), videoInfo.getDownloadNetwork(), videoInfo.getVideoRatio().floatValue(), videoInfo.m44582e(), videoInfo.m44585f(), videoInfo.m44575d(), videoInfo.m44589h(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.m44592i())), videoInfo.m44594j(), flatBufferBuilder.createString(C7087ec.m42868a(videoInfo.m44596k())));
    }

    /* renamed from: a */
    public static int[] m42857a(List<Monitor> list, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr;
        if (AbstractC7760bg.m47767a(list)) {
            iArr = null;
        } else {
            int size = list.size();
            iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                Monitor monitor = list.get(i10);
                if (monitor != null) {
                    iArr[i10] = MonitorFb.createMonitorFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(monitor.m40347a())), MonitorFb.createUrlVector(flatBufferBuilder, C7087ec.m42873a(monitor.m40351b(), flatBufferBuilder)), monitor.m40352c());
                }
            }
        }
        return C7087ec.m42874a(iArr);
    }
}
