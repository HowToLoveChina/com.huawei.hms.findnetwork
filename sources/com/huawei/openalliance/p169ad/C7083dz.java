package com.huawei.openalliance.p169ad;

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
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.dz */
/* loaded from: classes8.dex */
public class C7083dz {
    /* renamed from: a */
    public static DefaultTemplate m42809a(DefaultTemplateFb defaultTemplateFb) {
        if (defaultTemplateFb == null) {
            return null;
        }
        DefaultTemplate defaultTemplate = new DefaultTemplate();
        defaultTemplate.m40016a(defaultTemplateFb.defTptId());
        defaultTemplate.m40015a(Integer.valueOf(defaultTemplateFb.tptFcCtl()));
        return defaultTemplate;
    }

    /* renamed from: a */
    public static InstallConfig m42810a(InstallConfigFb installConfigFb) {
        if (installConfigFb == null) {
            return null;
        }
        InstallConfig installConfig = new InstallConfig();
        installConfig.m40195b(installConfigFb.appBtnInstallWay());
        installConfig.m40193a(installConfigFb.creativeInstallWay());
        installConfig.m40197c(installConfigFb.contentBtnInstallWay());
        return installConfig;
    }

    /* renamed from: a */
    public static PromoteInfo m42811a(PromoteInfoFb promoteInfoFb) {
        if (promoteInfoFb == null) {
            return null;
        }
        PromoteInfo promoteInfo = new PromoteInfo();
        promoteInfo.m40435a(promoteInfoFb.type());
        promoteInfo.m40436a(promoteInfoFb.name());
        return promoteInfo;
    }

    /* renamed from: a */
    public static TemplateData m42812a(TemplateDataFb templateDataFb) {
        if (templateDataFb == null) {
            return null;
        }
        TemplateData templateData = new TemplateData();
        templateData.m40550a(templateDataFb.templateContext());
        templateData.m40553b(templateDataFb.motions());
        templateData.m40551a(m42832a(templateDataFb.motionDataVector()));
        templateData.m40555c(templateDataFb.componentContext());
        return templateData;
    }

    /* renamed from: a */
    public static Data m42813a(DataFb dataFb) {
        if (dataFb == null) {
            return null;
        }
        Data data = new Data();
        data.m40571b(dataFb.len());
        data.m40568a(dataFb.type());
        data.m40569a(dataFb.value());
        return data;
    }

    /* renamed from: a */
    public static Image m42814a(ImageFb imageFb) {
        if (imageFb == null) {
            return null;
        }
        Image image = new Image();
        image.m40575a(m42815a(imageFb.ext()));
        image.m40578b(imageFb.height());
        image.m40574a(imageFb.width());
        image.m40579b(imageFb.localPath());
        image.m40576a(imageFb.url());
        return image;
    }

    /* renamed from: a */
    public static ImageExt m42815a(ImageExtFb imageExtFb) {
        if (imageExtFb == null) {
            return null;
        }
        ImageExt imageExt = new ImageExt();
        imageExt.m40584a(imageExtFb.checkSha256Flag());
        imageExt.m40588b(imageExtFb.format());
        imageExt.m40586a(imageExtFb.sha256());
        imageExt.m40585a(imageExtFb.size());
        return imageExt;
    }

    /* renamed from: a */
    public static Title m42816a(TitleFb titleFb) {
        if (titleFb == null) {
            return null;
        }
        Title title = new Title();
        title.m40592a(titleFb.len());
        title.m40593a(titleFb.text());
        return title;
    }

    /* renamed from: a */
    public static Video m42817a(VideoFb videoFb) {
        if (videoFb == null) {
            return null;
        }
        Video video = new Video();
        video.m40604c(videoFb.checkSha256Flag());
        video.m40598a(videoFb.url());
        video.m40596a(videoFb.width());
        video.m40600b(videoFb.height());
        video.m40597a(videoFb.duration());
        video.m40601b(videoFb.size());
        video.m40602b(videoFb.sha256());
        video.m40605c(videoFb.format());
        video.m40608d(videoFb.localPath());
        video.m40607d(videoFb.type());
        return video;
    }

    /* renamed from: a */
    public static AppInfo m42818a(AppInfoFb appInfoFb) {
        if (appInfoFb == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.m44417n(appInfoFb.appName());
        appInfo.m44371a(appInfoFb.packageName());
        appInfo.m44380b(appInfoFb.versionCode());
        appInfo.m44386c(appInfoFb.versionName());
        appInfo.m44390d(appInfoFb.iconUrl());
        appInfo.m44393e(appInfoFb.downloadUrl());
        appInfo.m44413l(appInfoFb.safeDownloadUrl());
        appInfo.m44368a(appInfoFb.fileSize());
        appInfo.m44411k(appInfoFb.sha256());
        appInfo.m44387c(appInfoFb.checkSha256());
        appInfo.m44415m(appInfoFb.intentUri());
        appInfo.m44381b(m42834a(appInfoFb.permissionsVector()));
        appInfo.m44423q(appInfoFb.priorInstallWay());
        appInfo.m44369a(m42810a(appInfoFb.installConfig()));
        appInfo.m44373a(appInfoFb.permPromptForCard());
        appInfo.m44382b(appInfoFb.permPromptForLanding());
        appInfo.m44377b(appInfoFb.popUpAfterInstallNew());
        appInfo.m44431u(appInfoFb.channelInfo());
        appInfo.m44384c(appInfoFb.channelInfoSaveLimit());
        appInfo.m44433v(appInfoFb.uniqueId());
        appInfo.m44419o(appInfoFb.appDesc());
        appInfo.m44389d(appInfoFb.noAlertTime());
        appInfo.m44392e(appInfoFb.trafficReminder());
        appInfo.m44429t(appInfoFb.popUpAfterInstallText());
        appInfo.m44434w(appInfoFb.dlBtnText());
        appInfo.m44437x(appInfoFb.afDlBtnText());
        appInfo.m44345C(appInfoFb.intent());
        appInfo.m44347D(appInfoFb.intentPackage());
        appInfo.m44395f(appInfoFb.popNotify());
        appInfo.m44398g(appInfoFb.fullScrnNotify());
        appInfo.m44341A(appInfoFb.fullScrnNotifyText());
        appInfo.m44343B(appInfoFb.insActvNotifyBtnText());
        appInfo.m44401h(appInfoFb.insActvNotifyCfg());
        appInfo.m44385c(Integer.valueOf(appInfoFb.hasPermissions()));
        appInfo.m44351F(appInfoFb.appLanguage());
        appInfo.m44353G(appInfoFb.appCountry());
        appInfo.m44421p(appInfoFb.developerName());
        appInfo.m44349E(appInfoFb.nextInstallWays());
        appInfo.m44355H(appInfoFb.curInstallWay());
        appInfo.m44357I(appInfoFb.actName());
        appInfo.m44404i(appInfoFb.appType());
        appInfo.m44407j(appInfoFb.autoOpenAfterInstall());
        appInfo.m44378b(appInfoFb.allAreaPopDelay());
        appInfo.m44410k(appInfoFb.popUpStyle());
        appInfo.m44359J(appInfoFb.installPermiText());
        appInfo.m44361K(appInfoFb.pureModeText());
        appInfo.m44363L(appInfoFb.installPureModeText());
        appInfo.m44364M(appInfoFb.contiBtn());
        appInfo.m44365N(appInfoFb.reservedPkgName());
        appInfo.m44396f(appInfoFb.permissionUrl());
        appInfo.m44399g(appInfoFb.appDetailsUrl());
        appInfo.m44402h(appInfoFb.privacyUrl());
        appInfo.m44425r(appInfoFb.contentInstallBtnAction());
        appInfo.m44367a(appInfoFb.autoOpenSwitchLandingOrDetail());
        appInfo.m44427s(appInfoFb.dlOpenBtnText());
        appInfo.m44405i(appInfoFb.hot());
        appInfo.m44370a(appInfoFb.rateNum() == -1 ? null : Long.valueOf(appInfoFb.rateNum()));
        appInfo.m44379b(appInfoFb.downloadNum() != -1 ? Long.valueOf(appInfoFb.downloadNum()) : null);
        appInfo.m44408j(appInfoFb.downCountDesc());
        return appInfo;
    }

    /* renamed from: a */
    public static AudioInfo m42819a(AudioInfoFb audioInfoFb) {
        if (audioInfoFb == null) {
            return null;
        }
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.m44443a(audioInfoFb.url());
        audioInfo.m44442a(audioInfoFb.duration());
        audioInfo.m44444b(audioInfoFb.fileSize());
        audioInfo.m44445b(audioInfoFb.sha256());
        audioInfo.m44446c(audioInfoFb.mime());
        return audioInfo;
    }

    /* renamed from: a */
    public static BiddingInfo m42820a(BiddingInfoFb biddingInfoFb) {
        if (biddingInfoFb == null) {
            return null;
        }
        BiddingInfo.C7295a c7295a = new BiddingInfo.C7295a();
        c7295a.m44455a(biddingInfoFb.cur());
        c7295a.m44454a(m42823a(biddingInfoFb.price()));
        c7295a.setLurl(biddingInfoFb.lurl());
        c7295a.m44457b(biddingInfoFb.nurl());
        return c7295a.m44456a();
    }

    /* renamed from: a */
    public static ImageInfo m42821a(ImageInfoFb imageInfoFb) {
        if (imageInfoFb == null) {
            return null;
        }
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.m44473a(imageInfoFb.checkSha256());
        imageInfo.m44478c(imageInfoFb.fileSize());
        imageInfo.m44471a(imageInfoFb.height());
        imageInfo.m44475b(imageInfoFb.width());
        imageInfo.m44480d(imageInfoFb.originalUrl());
        imageInfo.m44479c(imageInfoFb.url());
        imageInfo.m44476b(imageInfoFb.sha256());
        imageInfo.m44472a(imageInfoFb.imageType());
        return imageInfo;
    }

    /* renamed from: a */
    public static VideoInfo m42822a(VideoInfoFb videoInfoFb) {
        if (videoInfoFb == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.m44563a(videoInfoFb.videoDownloadUrl());
        videoInfo.m44584f(videoInfoFb.originUrl());
        videoInfo.m44561a(videoInfoFb.videoDuration());
        videoInfo.m44567b(videoInfoFb.videoFileSize());
        videoInfo.m44568b(videoInfoFb.videoAutoPlay());
        videoInfo.m44593i(videoInfoFb.autoPlayNetwork());
        videoInfo.m44572c(videoInfoFb.videoAutoPlayWithSound());
        videoInfo.m44571c(videoInfoFb.timeBeforeVideoAutoPlay());
        videoInfo.m44577d(videoInfoFb.sha256());
        videoInfo.m44579e(videoInfoFb.playProgress());
        videoInfo.m44580e(videoInfoFb.soundSwitch());
        videoInfo.m44576d(videoInfoFb.videoPlayMode());
        videoInfo.m44564a(videoInfoFb.checkSha256());
        videoInfo.m44569b(videoInfoFb.needContinueAutoPlay());
        videoInfo.m44573c(videoInfoFb.backFromFullScreen());
        videoInfo.m44583f(videoInfoFb.autoPlayAreaRatio());
        videoInfo.m44587g(videoInfoFb.autoStopPlayAreaRatio());
        videoInfo.m44590h(videoInfoFb.downloadNetwork());
        videoInfo.m44562a(Float.valueOf(videoInfoFb.videoRatio()));
        videoInfo.m44578d(videoInfoFb.showSoundIcon());
        videoInfo.m44581e(videoInfoFb.directReturnVideoAd());
        videoInfo.m44560a(videoInfoFb.splashSwitchTime());
        videoInfo.m44595j(videoInfoFb.customExposureType());
        videoInfo.m44588g(videoInfoFb.useTemplate());
        videoInfo.m44597k(videoInfoFb.videoType());
        videoInfo.m44591h(videoInfoFb.liveRoomName());
        return videoInfo;
    }

    /* renamed from: a */
    private static Float m42823a(float f10) {
        if (f10 == -1111.0f) {
            return null;
        }
        return Float.valueOf(f10);
    }

    /* renamed from: a */
    public static List<AdSource> m42824a(AdSourceFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            AdSourceFb adSourceFb = vector.get(i10);
            if (adSourceFb != null) {
                AdSource adSource = new AdSource();
                adSource.m39552a(adSourceFb.displayPosition());
                adSource.m39555b(adSourceFb.dspLogo());
                adSource.m39553a(adSourceFb.dspName());
                arrayList.add(adSource);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<AdvertiserInfo> m42825a(AdvertiserInfoFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            AdvertiserInfoFb advertiserInfoFb = vector.get(i10);
            if (advertiserInfoFb != null) {
                AdvertiserInfo advertiserInfo = new AdvertiserInfo();
                advertiserInfo.m44335a(advertiserInfoFb.key());
                advertiserInfo.m44334a(Integer.valueOf(advertiserInfoFb.seq()));
                advertiserInfo.m44336b(advertiserInfoFb.value());
                arrayList.add(advertiserInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Asset> m42826a(AssetFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            Asset asset = new Asset();
            AssetFb assetFb = vector.get(i10);
            if (assetFb != null) {
                asset.m40506a(assetFb.m44864id());
                asset.m40511a(assetFb.alias());
                asset.m40515c(assetFb.context());
                asset.m40507a(m42813a(assetFb.data()));
                asset.m40508a(m42814a(assetFb.img()));
                asset.m40510a(m42817a(assetFb.video()));
                asset.m40509a(m42816a(assetFb.title()));
                asset.m40513b(assetFb.filePath());
                arrayList.add(asset);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ContentExt> m42827a(ContentExtFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            ContentExt contentExt = new ContentExt();
            ContentExtFb contentExtFb = vector.get(i10);
            if (contentExtFb != null) {
                contentExt.m40010a(contentExtFb.key());
                contentExt.m40012b(contentExtFb.value());
                arrayList.add(contentExt);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<FeedbackInfo> m42828a(FeedbackInfoFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            FeedbackInfo feedbackInfo = new FeedbackInfo();
            FeedbackInfoFb feedbackInfoFb = vector.get(i10);
            if (feedbackInfoFb != null) {
                feedbackInfo.m44466a(feedbackInfoFb.m44865id());
                feedbackInfo.m44467a(feedbackInfoFb.label());
                feedbackInfo.m44465a(feedbackInfoFb.type());
                arrayList.add(feedbackInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ImageInfo> m42829a(ImageInfoFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(m42821a(vector.get(i10)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ImpEX> m42830a(ImpEXFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            ImpEX impEX = new ImpEX();
            ImpEXFb impEXFb = vector.get(i10);
            if (impEXFb != null) {
                impEX.m40189a(impEXFb.key());
                impEX.m40191b(impEXFb.value());
                arrayList.add(impEX);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Monitor> m42831a(MonitorFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            Monitor monitor = new Monitor();
            MonitorFb monitorFb = vector.get(i10);
            if (monitorFb != null) {
                monitor.m40349a(monitorFb.eventType());
                monitor.m40348a(monitorFb.retryFlag());
                monitor.m40350a(C7087ec.m42870a(monitorFb.urlVector()));
                arrayList.add(monitor);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<MotionData> m42832a(MotionDataFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            MotionData motionData = new MotionData();
            MotionDataFb motionDataFb = vector.get(i10);
            if (motionDataFb != null) {
                motionData.m40526a(motionDataFb.dataId());
                motionData.m40530b(motionDataFb.url());
                motionData.m40525a(motionDataFb.width());
                motionData.m40529b(motionDataFb.height());
                motionData.m40527a(motionDataFb.format());
                motionData.m40532c(motionDataFb.size());
                motionData.m40533c(motionDataFb.sha256());
                motionData.m40535d(motionDataFb.duration());
                motionData.m40536d(motionDataFb.filePath());
                arrayList.add(motionData);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<C6957Om> m42833a(OmFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            OmFb omFb = vector.get(i10);
            if (omFb != null) {
                C6957Om c6957Om = new C6957Om();
                c6957Om.m40369b(omFb.resourceUrl());
                c6957Om.m40367a(omFb.vendorKey());
                c6957Om.m40371c(omFb.verificationParameters());
                arrayList.add(c6957Om);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<PermissionEntity> m42834a(PermissionEntityFb.Vector vector) {
        if (vector == null || vector.length() == 0) {
            return null;
        }
        int length = vector.length();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            PermissionEntity permissionEntity = new PermissionEntity();
            PermissionEntityFb permissionEntityFb = vector.get(i10);
            if (permissionEntityFb != null) {
                permissionEntity.m44543a(permissionEntityFb.name());
                permissionEntity.m44542a(permissionEntityFb.type());
                arrayList.add(permissionEntity);
            }
        }
        return arrayList;
    }
}
