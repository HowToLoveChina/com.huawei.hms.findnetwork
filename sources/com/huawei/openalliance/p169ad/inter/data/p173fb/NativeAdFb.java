package com.huawei.openalliance.p169ad.inter.data.p173fb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AdSourceFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AdvertiserInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.AssetFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ContentExtFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.FeedbackInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImageInfoFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.ImpEXFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.MonitorFb;
import com.huawei.openalliance.p169ad.inter.data.p173fb.OmFb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class NativeAdFb extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        public NativeAdFb get(int i10) {
            return get(new NativeAdFb(), i10);
        }

        public NativeAdFb get(NativeAdFb nativeAdFb, int i10) {
            return nativeAdFb.__assign(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static void addAbilityDetailInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(32, i10, 0);
    }

    public static void addAdChoiceIcon(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(16, i10, 0);
    }

    public static void addAdChoiceUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(15, i10, 0);
    }

    public static void addAdCloseKeyWords(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(49, i10, 0);
    }

    public static void addAdCloseKeyWordsType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(50, i10, 0);
    }

    public static void addAdRealCallerPkgName(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(93, i10, 0);
    }

    public static void addAdSign(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(4, i10, 0);
    }

    public static void addAdSources(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(30, i10, 0);
    }

    public static void addAdType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(11, i10, 0);
    }

    public static void addApiRecordStartTime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(71, j10, 0L);
    }

    public static void addApiVer(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(81, i10, 0);
    }

    public static void addAppCountry(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(19, i10, 0);
    }

    public static void addAppInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(51, i10, 0);
    }

    public static void addAppLanguage(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(18, i10, 0);
    }

    public static void addAppPromotionChannel(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(46, i10, 0);
    }

    public static void addAssets(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(78, i10, 0);
    }

    public static void addAudioInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(54, i10, 0);
    }

    public static void addBannerRefSetting(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(72, i10, 0);
    }

    public static void addBiddingInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(100, i10, 0);
    }

    public static void addBubbleInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(106, i10, 0);
    }

    public static void addClickActionList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(56, i10, 0);
    }

    public static void addClicked(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(35, z10, false);
    }

    public static void addCompliance(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(34, i10, 0);
    }

    public static void addContentExts(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(75, i10, 0);
    }

    public static void addContentId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(1, i10, 0);
    }

    public static void addCreativeType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(5, i10, 0);
    }

    public static void addCshareUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(97, i10, 0);
    }

    public static void addCta(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(3, i10, 0);
    }

    public static void addCtrlExt(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(89, i10, 0);
    }

    public static void addCtrlSwitchs(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(59, i10, 0);
    }

    public static void addCustomData(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(20, i10, 0);
    }

    public static void addCustomExposureType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(27, i10, 0);
    }

    public static void addDefaultTemplate(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(82, i10, 0);
    }

    public static void addDescription(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(39, i10, 0);
    }

    public static void addDirectReturnVideoAd(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(66, z10, false);
    }

    public static void addEncodeJssdkAllowList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(65, i10, 0);
    }

    public static void addEncodeWhiteList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(64, i10, 0);
    }

    public static void addEncodedParamFromServer(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(37, i10, 0);
    }

    public static void addEncodedeMonitors(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(53, i10, 0);
    }

    public static void addEncryptInContentRrd(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(83, z10, true);
    }

    public static void addEndTime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(2, j10, 0L);
    }

    public static void addExt(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(74, i10, 0);
    }

    public static void addFeedbackInfoList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(76, i10, 0);
    }

    public static void addFileCachePriority(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(17, i10, 0);
    }

    public static void addHasReportInteractiveImp(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(98, z10, false);
    }

    public static void addHasReportShowEventDuringShowTime(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(62, z10, false);
    }

    public static void addHwChannelId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(33, i10, 0);
    }

    public static void addIcon(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(40, i10, 0);
    }

    public static void addImageInfos(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(41, i10, 0);
    }

    public static void addIntent(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(10, i10, 0);
    }

    public static void addInteractiontype(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(36, i10, 0);
    }

    public static void addInvalidcontentids(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(68, i10, 0);
    }

    public static void addIsPreload(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(25, i10, 0);
    }

    public static void addIsShowStartReported(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(69, z10, false);
    }

    public static void addIsVastAd(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(29, z10, false);
    }

    public static void addLabel(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(8, i10, 0);
    }

    public static void addLandWebUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(43, i10, 0);
    }

    public static void addLandingPageType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(67, i10, 0);
    }

    public static void addLandpgDlInteractionCfg(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(23, i10, 0);
    }

    public static void addLogo2Text(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(31, i10, 0);
    }

    public static void addMarketAppId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(47, i10, 0);
    }

    public static void addMaxEffectiveShowTime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(107, j10, 0L);
    }

    public static void addMetaData(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(52, i10, 0);
    }

    public static void addMinEffectiveShowRatio(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(45, i10, 0);
    }

    public static void addMinEffectiveShowTime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(44, j10, 0L);
    }

    public static void addMinEffectiveVideoPlayProgress(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(28, i10, 0);
    }

    public static void addMonitors(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(86, i10, 0);
    }

    public static void addNoReportEventList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(60, i10, 0);
    }

    public static void addOm(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(22, i10, 0);
    }

    public static void addOriginCreativeType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(6, i10, 0);
    }

    public static void addOriginJssdkAllowList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(88, i10, 0);
    }

    public static void addOriginParamFromServer(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(85, i10, 0);
    }

    public static void addOriginWhiteList(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(87, i10, 0);
    }

    public static void addPromoteInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(94, i10, 0);
    }

    public static void addRawImageInfos(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(42, i10, 0);
    }

    public static void addRecallSource(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(95, i10, 0);
    }

    public static void addRequestId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(12, i10, 0);
    }

    public static void addRequestType(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(13, i10, 0);
    }

    public static void addSdkMonitor(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(105, i10, 0);
    }

    public static void addShowAppElement(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(90, i10, 0);
    }

    public static void addShowId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(0, i10, 0);
    }

    public static void addShowLandingPageTitleFlag(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(55, i10, 0);
    }

    public static void addShown(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(57, z10, false);
    }

    public static void addSlotId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(61, i10, 0);
    }

    public static void addSplashMediaPath(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(70, i10, 0);
    }

    public static void addStartShowtime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(26, j10, 0L);
    }

    public static void addStartTime(FlatBufferBuilder flatBufferBuilder, long j10) {
        flatBufferBuilder.addLong(9, j10, 0L);
    }

    public static void addStrAssets(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(103, i10, 0);
    }

    public static void addStyle(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(101, i10, 0);
    }

    public static void addStyleExt(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(102, i10, 0);
    }

    public static void addSubDescription(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(99, i10, 0);
    }

    public static void addTaskId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(7, i10, 0);
    }

    public static void addTaskinfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(63, i10, 0);
    }

    public static void addTemplateData(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(79, i10, 0);
    }

    public static void addTemplateId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(77, i10, 0);
    }

    public static void addTemplateStyle(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(80, i10, 0);
    }

    public static void addTemplateUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(96, i10, 0);
    }

    public static void addTitle(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(38, i10, 0);
    }

    public static void addTrackVersion(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(104, i10, 0);
    }

    public static void addTransparencySwitch(FlatBufferBuilder flatBufferBuilder, boolean z10) {
        flatBufferBuilder.addBoolean(91, z10, false);
    }

    public static void addTransparencyTplUrl(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(92, i10, 0);
    }

    public static void addUniqueId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(24, i10, 0);
    }

    public static void addUseGaussianBlur(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addInt(73, i10, 0);
    }

    public static void addUserId(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(21, i10, 0);
    }

    public static void addVideoInfo(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(48, i10, 0);
    }

    public static void addWebConfig(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(58, i10, 0);
    }

    public static void addWhyThisAd(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(14, i10, 0);
    }

    public static void addWorkingKey(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.addOffset(84, i10, 0);
    }

    public static int createAdCloseKeyWordsTypeVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createAdCloseKeyWordsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createAdSourcesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createAssetsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createClickActionListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createComplianceVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createContentExtsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createExtVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createFeedbackInfoListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createImageInfosVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createInvalidcontentidsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMonitorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createNativeAdFb(FlatBufferBuilder flatBufferBuilder, int i10, int i11, long j10, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, long j12, int i34, int i35, boolean z10, int i36, int i37, int i38, int i39, int i40, boolean z11, int i41, int i42, int i43, int i44, int i45, int i46, int i47, int i48, long j13, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, boolean z12, int i61, int i62, int i63, int i64, boolean z13, int i65, int i66, int i67, boolean z14, int i68, int i69, boolean z15, int i70, long j14, int i71, int i72, int i73, int i74, int i75, int i76, int i77, int i78, int i79, int i80, int i81, boolean z16, int i82, int i83, int i84, int i85, int i86, int i87, int i88, boolean z17, int i89, int i90, int i91, int i92, int i93, int i94, boolean z18, int i95, int i96, int i97, int i98, int i99, int i100, int i101, int i102, long j15) {
        flatBufferBuilder.startTable(108);
        addMaxEffectiveShowTime(flatBufferBuilder, j15);
        addApiRecordStartTime(flatBufferBuilder, j14);
        addMinEffectiveShowTime(flatBufferBuilder, j13);
        addStartShowtime(flatBufferBuilder, j12);
        addStartTime(flatBufferBuilder, j11);
        addEndTime(flatBufferBuilder, j10);
        addBubbleInfo(flatBufferBuilder, i102);
        addSdkMonitor(flatBufferBuilder, i101);
        addTrackVersion(flatBufferBuilder, i100);
        addStrAssets(flatBufferBuilder, i99);
        addStyleExt(flatBufferBuilder, i98);
        addStyle(flatBufferBuilder, i97);
        addBiddingInfo(flatBufferBuilder, i96);
        addSubDescription(flatBufferBuilder, i95);
        addCshareUrl(flatBufferBuilder, i94);
        addTemplateUrl(flatBufferBuilder, i93);
        addRecallSource(flatBufferBuilder, i92);
        addPromoteInfo(flatBufferBuilder, i91);
        addAdRealCallerPkgName(flatBufferBuilder, i90);
        addTransparencyTplUrl(flatBufferBuilder, i89);
        addShowAppElement(flatBufferBuilder, i88);
        addCtrlExt(flatBufferBuilder, i87);
        addOriginJssdkAllowList(flatBufferBuilder, i86);
        addOriginWhiteList(flatBufferBuilder, i85);
        addMonitors(flatBufferBuilder, i84);
        addOriginParamFromServer(flatBufferBuilder, i83);
        addWorkingKey(flatBufferBuilder, i82);
        addDefaultTemplate(flatBufferBuilder, i81);
        addApiVer(flatBufferBuilder, i80);
        addTemplateStyle(flatBufferBuilder, i79);
        addTemplateData(flatBufferBuilder, i78);
        addAssets(flatBufferBuilder, i77);
        addTemplateId(flatBufferBuilder, i76);
        addFeedbackInfoList(flatBufferBuilder, i75);
        addContentExts(flatBufferBuilder, i74);
        addExt(flatBufferBuilder, i73);
        addUseGaussianBlur(flatBufferBuilder, i72);
        addBannerRefSetting(flatBufferBuilder, i71);
        addSplashMediaPath(flatBufferBuilder, i70);
        addInvalidcontentids(flatBufferBuilder, i69);
        addLandingPageType(flatBufferBuilder, i68);
        addEncodeJssdkAllowList(flatBufferBuilder, i67);
        addEncodeWhiteList(flatBufferBuilder, i66);
        addTaskinfo(flatBufferBuilder, i65);
        addSlotId(flatBufferBuilder, i64);
        addNoReportEventList(flatBufferBuilder, i63);
        addCtrlSwitchs(flatBufferBuilder, i62);
        addWebConfig(flatBufferBuilder, i61);
        addClickActionList(flatBufferBuilder, i60);
        addShowLandingPageTitleFlag(flatBufferBuilder, i59);
        addAudioInfo(flatBufferBuilder, i58);
        addEncodedeMonitors(flatBufferBuilder, i57);
        addMetaData(flatBufferBuilder, i56);
        addAppInfo(flatBufferBuilder, i55);
        addAdCloseKeyWordsType(flatBufferBuilder, i54);
        addAdCloseKeyWords(flatBufferBuilder, i53);
        addVideoInfo(flatBufferBuilder, i52);
        addMarketAppId(flatBufferBuilder, i51);
        addAppPromotionChannel(flatBufferBuilder, i50);
        addMinEffectiveShowRatio(flatBufferBuilder, i49);
        addLandWebUrl(flatBufferBuilder, i48);
        addRawImageInfos(flatBufferBuilder, i47);
        addImageInfos(flatBufferBuilder, i46);
        addIcon(flatBufferBuilder, i45);
        addDescription(flatBufferBuilder, i44);
        addTitle(flatBufferBuilder, i43);
        addEncodedParamFromServer(flatBufferBuilder, i42);
        addInteractiontype(flatBufferBuilder, i41);
        addCompliance(flatBufferBuilder, i40);
        addHwChannelId(flatBufferBuilder, i39);
        addAbilityDetailInfo(flatBufferBuilder, i38);
        addLogo2Text(flatBufferBuilder, i37);
        addAdSources(flatBufferBuilder, i36);
        addMinEffectiveVideoPlayProgress(flatBufferBuilder, i35);
        addCustomExposureType(flatBufferBuilder, i34);
        addIsPreload(flatBufferBuilder, i33);
        addUniqueId(flatBufferBuilder, i32);
        addLandpgDlInteractionCfg(flatBufferBuilder, i31);
        addOm(flatBufferBuilder, i30);
        addUserId(flatBufferBuilder, i29);
        addCustomData(flatBufferBuilder, i28);
        addAppCountry(flatBufferBuilder, i27);
        addAppLanguage(flatBufferBuilder, i26);
        addFileCachePriority(flatBufferBuilder, i25);
        addAdChoiceIcon(flatBufferBuilder, i24);
        addAdChoiceUrl(flatBufferBuilder, i23);
        addWhyThisAd(flatBufferBuilder, i22);
        addRequestType(flatBufferBuilder, i21);
        addRequestId(flatBufferBuilder, i20);
        addAdType(flatBufferBuilder, i19);
        addIntent(flatBufferBuilder, i18);
        addLabel(flatBufferBuilder, i17);
        addTaskId(flatBufferBuilder, i16);
        addOriginCreativeType(flatBufferBuilder, i15);
        addCreativeType(flatBufferBuilder, i14);
        addAdSign(flatBufferBuilder, i13);
        addCta(flatBufferBuilder, i12);
        addContentId(flatBufferBuilder, i11);
        addShowId(flatBufferBuilder, i10);
        addHasReportInteractiveImp(flatBufferBuilder, z18);
        addTransparencySwitch(flatBufferBuilder, z17);
        addEncryptInContentRrd(flatBufferBuilder, z16);
        addIsShowStartReported(flatBufferBuilder, z15);
        addDirectReturnVideoAd(flatBufferBuilder, z14);
        addHasReportShowEventDuringShowTime(flatBufferBuilder, z13);
        addShown(flatBufferBuilder, z12);
        addClicked(flatBufferBuilder, z11);
        addIsVastAd(flatBufferBuilder, z10);
        return endNativeAdFb(flatBufferBuilder);
    }

    public static int createNoReportEventListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createOmVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createRawImageInfosVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createSubDescriptionVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createWorkingKeyVector(FlatBufferBuilder flatBufferBuilder, ByteBuffer byteBuffer) {
        return flatBufferBuilder.createByteVector(byteBuffer);
    }

    public static int endNativeAdFb(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static NativeAdFb getRootAsNativeAdFb(ByteBuffer byteBuffer) {
        return getRootAsNativeAdFb(byteBuffer, new NativeAdFb());
    }

    public static void startAdCloseKeyWordsTypeVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startAdCloseKeyWordsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startAdSourcesVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startAssetsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startClickActionListVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startComplianceVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startContentExtsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startExtVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startFeedbackInfoListVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startImageInfosVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startInvalidcontentidsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startMonitorsVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startNativeAdFb(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(108);
    }

    public static void startNoReportEventListVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startOmVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startRawImageInfosVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startSubDescriptionVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(4, i10, 4);
    }

    public static void startWorkingKeyVector(FlatBufferBuilder flatBufferBuilder, int i10) {
        flatBufferBuilder.startVector(1, i10, 1);
    }

    public NativeAdFb __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public String abilityDetailInfo() {
        int i__offset = __offset(68);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer abilityDetailInfoAsByteBuffer() {
        return __vector_as_bytebuffer(68, 1);
    }

    public ByteBuffer abilityDetailInfoInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 68, 1);
    }

    public String adChoiceIcon() {
        int i__offset = __offset(36);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer adChoiceIconAsByteBuffer() {
        return __vector_as_bytebuffer(36, 1);
    }

    public ByteBuffer adChoiceIconInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 36, 1);
    }

    public String adChoiceUrl() {
        int i__offset = __offset(34);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer adChoiceUrlAsByteBuffer() {
        return __vector_as_bytebuffer(34, 1);
    }

    public ByteBuffer adChoiceUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 34, 1);
    }

    public String adCloseKeyWords(int i10) {
        int i__offset = __offset(102);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int adCloseKeyWordsLength() {
        int i__offset = __offset(102);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public String adCloseKeyWordsType(int i10) {
        int i__offset = __offset(104);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int adCloseKeyWordsTypeLength() {
        int i__offset = __offset(104);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector adCloseKeyWordsTypeVector() {
        return adCloseKeyWordsTypeVector(new StringVector());
    }

    public StringVector adCloseKeyWordsVector() {
        return adCloseKeyWordsVector(new StringVector());
    }

    public String adRealCallerPkgName() {
        int i__offset = __offset(190);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer adRealCallerPkgNameAsByteBuffer() {
        return __vector_as_bytebuffer(190, 1);
    }

    public ByteBuffer adRealCallerPkgNameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 190, 1);
    }

    public String adSign() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer adSignAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer adSignInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public AdSourceFb adSources(int i10) {
        return adSources(new AdSourceFb(), i10);
    }

    public int adSourcesLength() {
        int i__offset = __offset(64);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public AdSourceFb.Vector adSourcesVector() {
        return adSourcesVector(new AdSourceFb.Vector());
    }

    public int adType() {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public long apiRecordStartTime() {
        int i__offset = __offset(146);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int apiVer() {
        int i__offset = __offset(166);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String appCountry() {
        int i__offset = __offset(42);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appCountryAsByteBuffer() {
        return __vector_as_bytebuffer(42, 1);
    }

    public ByteBuffer appCountryInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 42, 1);
    }

    public AppInfoFb appInfo() {
        return appInfo(new AppInfoFb());
    }

    public String appLanguage() {
        int i__offset = __offset(40);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appLanguageAsByteBuffer() {
        return __vector_as_bytebuffer(40, 1);
    }

    public ByteBuffer appLanguageInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 40, 1);
    }

    public String appPromotionChannel() {
        int i__offset = __offset(96);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer appPromotionChannelAsByteBuffer() {
        return __vector_as_bytebuffer(96, 1);
    }

    public ByteBuffer appPromotionChannelInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 96, 1);
    }

    public AssetFb assets(int i10) {
        return assets(new AssetFb(), i10);
    }

    public int assetsLength() {
        int i__offset = __offset(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public AssetFb.Vector assetsVector() {
        return assetsVector(new AssetFb.Vector());
    }

    public AudioInfoFb audioInfo() {
        return audioInfo(new AudioInfoFb());
    }

    public String bannerRefSetting() {
        int i__offset = __offset(148);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bannerRefSettingAsByteBuffer() {
        return __vector_as_bytebuffer(148, 1);
    }

    public ByteBuffer bannerRefSettingInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 148, 1);
    }

    public BiddingInfoFb biddingInfo() {
        return biddingInfo(new BiddingInfoFb());
    }

    public String bubbleInfo() {
        int i__offset = __offset(216);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bubbleInfoAsByteBuffer() {
        return __vector_as_bytebuffer(216, 1);
    }

    public ByteBuffer bubbleInfoInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 216, 1);
    }

    public int clickActionList(int i10) {
        int i__offset = __offset(116);
        if (i__offset != 0) {
            return this.f9449bb.getInt(__vector(i__offset) + (i10 * 4));
        }
        return 0;
    }

    public ByteBuffer clickActionListAsByteBuffer() {
        return __vector_as_bytebuffer(116, 4);
    }

    public ByteBuffer clickActionListInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 116, 4);
    }

    public int clickActionListLength() {
        int i__offset = __offset(116);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public IntVector clickActionListVector() {
        return clickActionListVector(new IntVector());
    }

    public boolean clicked() {
        int i__offset = __offset(74);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public AdvertiserInfoFb compliance(int i10) {
        return compliance(new AdvertiserInfoFb(), i10);
    }

    public int complianceLength() {
        int i__offset = __offset(72);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public AdvertiserInfoFb.Vector complianceVector() {
        return complianceVector(new AdvertiserInfoFb.Vector());
    }

    public ContentExtFb contentExts(int i10) {
        return contentExts(new ContentExtFb(), i10);
    }

    public int contentExtsLength() {
        int i__offset = __offset(154);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ContentExtFb.Vector contentExtsVector() {
        return contentExtsVector(new ContentExtFb.Vector());
    }

    public String contentId() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer contentIdAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer contentIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public int creativeType() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String cshareUrl() {
        int i__offset = __offset(198);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer cshareUrlAsByteBuffer() {
        return __vector_as_bytebuffer(198, 1);
    }

    public ByteBuffer cshareUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 198, 1);
    }

    public String cta() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer ctaAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer ctaInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String ctrlExt() {
        int i__offset = __offset(182);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer ctrlExtAsByteBuffer() {
        return __vector_as_bytebuffer(182, 1);
    }

    public ByteBuffer ctrlExtInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 182, 1);
    }

    public String ctrlSwitchs() {
        int i__offset = __offset(122);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer ctrlSwitchsAsByteBuffer() {
        return __vector_as_bytebuffer(122, 1);
    }

    public ByteBuffer ctrlSwitchsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 122, 1);
    }

    public String customData() {
        int i__offset = __offset(44);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer customDataAsByteBuffer() {
        return __vector_as_bytebuffer(44, 1);
    }

    public ByteBuffer customDataInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 44, 1);
    }

    public int customExposureType() {
        int i__offset = __offset(58);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public DefaultTemplateFb defaultTemplate() {
        return defaultTemplate(new DefaultTemplateFb());
    }

    public String description() {
        int i__offset = __offset(82);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer descriptionAsByteBuffer() {
        return __vector_as_bytebuffer(82, 1);
    }

    public ByteBuffer descriptionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 82, 1);
    }

    public boolean directReturnVideoAd() {
        int i__offset = __offset(SyncType.AUTO_SYNC_PHONE_MANAGER);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String encodeJssdkAllowList() {
        int i__offset = __offset(SyncType.OPEN_SWITCH_FROM_GUIDE);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer encodeJssdkAllowListAsByteBuffer() {
        return __vector_as_bytebuffer(SyncType.OPEN_SWITCH_FROM_GUIDE, 1);
    }

    public ByteBuffer encodeJssdkAllowListInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, SyncType.OPEN_SWITCH_FROM_GUIDE, 1);
    }

    public String encodeWhiteList() {
        int i__offset = __offset(SyncType.AUTO_SYNC_RECORD);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer encodeWhiteListAsByteBuffer() {
        return __vector_as_bytebuffer(SyncType.AUTO_SYNC_RECORD, 1);
    }

    public ByteBuffer encodeWhiteListInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, SyncType.AUTO_SYNC_RECORD, 1);
    }

    public String encodedParamFromServer() {
        int i__offset = __offset(78);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer encodedParamFromServerAsByteBuffer() {
        return __vector_as_bytebuffer(78, 1);
    }

    public ByteBuffer encodedParamFromServerInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 78, 1);
    }

    public String encodedeMonitors() {
        int i__offset = __offset(110);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer encodedeMonitorsAsByteBuffer() {
        return __vector_as_bytebuffer(110, 1);
    }

    public ByteBuffer encodedeMonitorsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 110, 1);
    }

    public boolean encryptInContentRrd() {
        int i__offset = __offset(170);
        return i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) != 0;
    }

    public long endTime() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public ImpEXFb ext(int i10) {
        return ext(new ImpEXFb(), i10);
    }

    public int extLength() {
        int i__offset = __offset(152);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ImpEXFb.Vector extVector() {
        return extVector(new ImpEXFb.Vector());
    }

    public FeedbackInfoFb feedbackInfoList(int i10) {
        return feedbackInfoList(new FeedbackInfoFb(), i10);
    }

    public int feedbackInfoListLength() {
        int i__offset = __offset(156);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public FeedbackInfoFb.Vector feedbackInfoListVector() {
        return feedbackInfoListVector(new FeedbackInfoFb.Vector());
    }

    public int fileCachePriority() {
        int i__offset = __offset(38);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean hasReportInteractiveImp() {
        int i__offset = __offset(200);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean hasReportShowEventDuringShowTime() {
        int i__offset = __offset(128);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String hwChannelId() {
        int i__offset = __offset(70);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer hwChannelIdAsByteBuffer() {
        return __vector_as_bytebuffer(70, 1);
    }

    public ByteBuffer hwChannelIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 70, 1);
    }

    public ImageInfoFb icon() {
        return icon(new ImageInfoFb());
    }

    public ImageInfoFb imageInfos(int i10) {
        return imageInfos(new ImageInfoFb(), i10);
    }

    public int imageInfosLength() {
        int i__offset = __offset(86);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ImageInfoFb.Vector imageInfosVector() {
        return imageInfosVector(new ImageInfoFb.Vector());
    }

    public String intent() {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer intentAsByteBuffer() {
        return __vector_as_bytebuffer(24, 1);
    }

    public ByteBuffer intentInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 24, 1);
    }

    public int interactiontype() {
        int i__offset = __offset(76);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String invalidcontentids(int i10) {
        int i__offset = __offset(140);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int invalidcontentidsLength() {
        int i__offset = __offset(140);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector invalidcontentidsVector() {
        return invalidcontentidsVector(new StringVector());
    }

    public int isPreload() {
        int i__offset = __offset(54);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean isShowStartReported() {
        int i__offset = __offset(142);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean isVastAd() {
        int i__offset = __offset(62);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String label() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer labelAsByteBuffer() {
        return __vector_as_bytebuffer(20, 1);
    }

    public ByteBuffer labelInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 1);
    }

    public String landWebUrl() {
        int i__offset = __offset(90);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer landWebUrlAsByteBuffer() {
        return __vector_as_bytebuffer(90, 1);
    }

    public ByteBuffer landWebUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 90, 1);
    }

    public String landingPageType() {
        int i__offset = __offset(138);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer landingPageTypeAsByteBuffer() {
        return __vector_as_bytebuffer(138, 1);
    }

    public ByteBuffer landingPageTypeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 138, 1);
    }

    public String landpgDlInteractionCfg() {
        int i__offset = __offset(50);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer landpgDlInteractionCfgAsByteBuffer() {
        return __vector_as_bytebuffer(50, 1);
    }

    public ByteBuffer landpgDlInteractionCfgInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 50, 1);
    }

    public String logo2Text() {
        int i__offset = __offset(66);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer logo2TextAsByteBuffer() {
        return __vector_as_bytebuffer(66, 1);
    }

    public ByteBuffer logo2TextInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 66, 1);
    }

    public String marketAppId() {
        int i__offset = __offset(98);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer marketAppIdAsByteBuffer() {
        return __vector_as_bytebuffer(98, 1);
    }

    public ByteBuffer marketAppIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 98, 1);
    }

    public long maxEffectiveShowTime() {
        int i__offset = __offset(PlayerConstants.EventCode.LAYOUT_NOT_SUPPORT_SUBTITLE);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public String metaData() {
        int i__offset = __offset(108);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer metaDataAsByteBuffer() {
        return __vector_as_bytebuffer(108, 1);
    }

    public ByteBuffer metaDataInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 108, 1);
    }

    public int minEffectiveShowRatio() {
        int i__offset = __offset(94);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public long minEffectiveShowTime() {
        int i__offset = __offset(92);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int minEffectiveVideoPlayProgress() {
        int i__offset = __offset(60);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public MonitorFb monitors(int i10) {
        return monitors(new MonitorFb(), i10);
    }

    public int monitorsLength() {
        int i__offset = __offset(176);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public MonitorFb.Vector monitorsVector() {
        return monitorsVector(new MonitorFb.Vector());
    }

    public String noReportEventList(int i10) {
        int i__offset = __offset(124);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int noReportEventListLength() {
        int i__offset = __offset(124);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector noReportEventListVector() {
        return noReportEventListVector(new StringVector());
    }

    /* renamed from: om */
    public OmFb m44866om(int i10) {
        return m44867om(new OmFb(), i10);
    }

    public int omLength() {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public OmFb.Vector omVector() {
        return omVector(new OmFb.Vector());
    }

    public int originCreativeType() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String originJssdkAllowList() {
        int i__offset = __offset(180);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originJssdkAllowListAsByteBuffer() {
        return __vector_as_bytebuffer(180, 1);
    }

    public ByteBuffer originJssdkAllowListInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 180, 1);
    }

    public String originParamFromServer() {
        int i__offset = __offset(174);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originParamFromServerAsByteBuffer() {
        return __vector_as_bytebuffer(174, 1);
    }

    public ByteBuffer originParamFromServerInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 174, 1);
    }

    public String originWhiteList() {
        int i__offset = __offset(178);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originWhiteListAsByteBuffer() {
        return __vector_as_bytebuffer(178, 1);
    }

    public ByteBuffer originWhiteListInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 178, 1);
    }

    public PromoteInfoFb promoteInfo() {
        return promoteInfo(new PromoteInfoFb());
    }

    public ImageInfoFb rawImageInfos(int i10) {
        return rawImageInfos(new ImageInfoFb(), i10);
    }

    public int rawImageInfosLength() {
        int i__offset = __offset(88);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ImageInfoFb.Vector rawImageInfosVector() {
        return rawImageInfosVector(new ImageInfoFb.Vector());
    }

    public int recallSource() {
        int i__offset = __offset(194);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String requestId() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer requestIdAsByteBuffer() {
        return __vector_as_bytebuffer(28, 1);
    }

    public ByteBuffer requestIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 28, 1);
    }

    public int requestType() {
        int i__offset = __offset(30);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int sdkMonitor() {
        int i__offset = __offset(214);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public int showAppElement() {
        int i__offset = __offset(184);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String showId() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer showIdAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer showIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int showLandingPageTitleFlag() {
        int i__offset = __offset(114);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public boolean shown() {
        int i__offset = __offset(118);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String slotId() {
        int i__offset = __offset(126);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer slotIdAsByteBuffer() {
        return __vector_as_bytebuffer(126, 1);
    }

    public ByteBuffer slotIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 126, 1);
    }

    public String splashMediaPath() {
        int i__offset = __offset(RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer splashMediaPathAsByteBuffer() {
        return __vector_as_bytebuffer(RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT, 1);
    }

    public ByteBuffer splashMediaPathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT, 1);
    }

    public long startShowtime() {
        int i__offset = __offset(56);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public long startTime() {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public String strAssets() {
        int i__offset = __offset(210);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer strAssetsAsByteBuffer() {
        return __vector_as_bytebuffer(210, 1);
    }

    public ByteBuffer strAssetsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 210, 1);
    }

    public String style() {
        int i__offset = __offset(206);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer styleAsByteBuffer() {
        return __vector_as_bytebuffer(206, 1);
    }

    public String styleExt() {
        int i__offset = __offset(PlayerConstants.EventCode.VIDEO_DECODE_LAGGING);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer styleExtAsByteBuffer() {
        return __vector_as_bytebuffer(PlayerConstants.EventCode.VIDEO_DECODE_LAGGING, 1);
    }

    public ByteBuffer styleExtInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, PlayerConstants.EventCode.VIDEO_DECODE_LAGGING, 1);
    }

    public ByteBuffer styleInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 206, 1);
    }

    public String subDescription(int i10) {
        int i__offset = __offset(202);
        if (i__offset != 0) {
            return __string(__vector(i__offset) + (i10 * 4));
        }
        return null;
    }

    public int subDescriptionLength() {
        int i__offset = __offset(202);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringVector subDescriptionVector() {
        return subDescriptionVector(new StringVector());
    }

    public String taskId() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer taskIdAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer taskIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public String taskinfo() {
        int i__offset = __offset(130);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer taskinfoAsByteBuffer() {
        return __vector_as_bytebuffer(130, 1);
    }

    public ByteBuffer taskinfoInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 130, 1);
    }

    public TemplateDataFb templateData() {
        return templateData(new TemplateDataFb());
    }

    public String templateId() {
        int i__offset = __offset(158);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer templateIdAsByteBuffer() {
        return __vector_as_bytebuffer(158, 1);
    }

    public ByteBuffer templateIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 158, 1);
    }

    public String templateStyle() {
        int i__offset = __offset(164);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer templateStyleAsByteBuffer() {
        return __vector_as_bytebuffer(164, 1);
    }

    public ByteBuffer templateStyleInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 164, 1);
    }

    public String templateUrl() {
        int i__offset = __offset(196);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer templateUrlAsByteBuffer() {
        return __vector_as_bytebuffer(196, 1);
    }

    public ByteBuffer templateUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 196, 1);
    }

    public String title() {
        int i__offset = __offset(80);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer titleAsByteBuffer() {
        return __vector_as_bytebuffer(80, 1);
    }

    public ByteBuffer titleInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 80, 1);
    }

    public String trackVersion() {
        int i__offset = __offset(212);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer trackVersionAsByteBuffer() {
        return __vector_as_bytebuffer(212, 1);
    }

    public ByteBuffer trackVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 212, 1);
    }

    public boolean transparencySwitch() {
        int i__offset = __offset(186);
        return (i__offset == 0 || this.f9449bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public String transparencyTplUrl() {
        int i__offset = __offset(188);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer transparencyTplUrlAsByteBuffer() {
        return __vector_as_bytebuffer(188, 1);
    }

    public ByteBuffer transparencyTplUrlInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 188, 1);
    }

    public String uniqueId() {
        int i__offset = __offset(52);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer uniqueIdAsByteBuffer() {
        return __vector_as_bytebuffer(52, 1);
    }

    public ByteBuffer uniqueIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 52, 1);
    }

    public int useGaussianBlur() {
        int i__offset = __offset(150);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public String userId() {
        int i__offset = __offset(46);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer userIdAsByteBuffer() {
        return __vector_as_bytebuffer(46, 1);
    }

    public ByteBuffer userIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 46, 1);
    }

    public VideoInfoFb videoInfo() {
        return videoInfo(new VideoInfoFb());
    }

    public String webConfig() {
        int i__offset = __offset(120);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer webConfigAsByteBuffer() {
        return __vector_as_bytebuffer(120, 1);
    }

    public ByteBuffer webConfigInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 120, 1);
    }

    public String whyThisAd() {
        int i__offset = __offset(32);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer whyThisAdAsByteBuffer() {
        return __vector_as_bytebuffer(32, 1);
    }

    public ByteBuffer whyThisAdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 32, 1);
    }

    public byte workingKey(int i10) {
        int i__offset = __offset(172);
        if (i__offset != 0) {
            return this.f9449bb.get(__vector(i__offset) + i10);
        }
        return (byte) 0;
    }

    public ByteBuffer workingKeyAsByteBuffer() {
        return __vector_as_bytebuffer(172, 1);
    }

    public ByteBuffer workingKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 172, 1);
    }

    public int workingKeyLength() {
        int i__offset = __offset(172);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ByteVector workingKeyVector() {
        return workingKeyVector(new ByteVector());
    }

    public static int createWorkingKeyVector(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        return flatBufferBuilder.createByteVector(bArr);
    }

    public static NativeAdFb getRootAsNativeAdFb(ByteBuffer byteBuffer, NativeAdFb nativeAdFb) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return nativeAdFb.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public StringVector adCloseKeyWordsTypeVector(StringVector stringVector) {
        int i__offset = __offset(104);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector adCloseKeyWordsVector(StringVector stringVector) {
        int i__offset = __offset(102);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public AdSourceFb adSources(AdSourceFb adSourceFb, int i10) {
        int i__offset = __offset(64);
        if (i__offset != 0) {
            return adSourceFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public AdSourceFb.Vector adSourcesVector(AdSourceFb.Vector vector) {
        int i__offset = __offset(64);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public AppInfoFb appInfo(AppInfoFb appInfoFb) {
        int i__offset = __offset(106);
        if (i__offset != 0) {
            return appInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public AssetFb assets(AssetFb assetFb, int i10) {
        int i__offset = __offset(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        if (i__offset != 0) {
            return assetFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public AssetFb.Vector assetsVector(AssetFb.Vector vector) {
        int i__offset = __offset(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public AudioInfoFb audioInfo(AudioInfoFb audioInfoFb) {
        int i__offset = __offset(112);
        if (i__offset != 0) {
            return audioInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public BiddingInfoFb biddingInfo(BiddingInfoFb biddingInfoFb) {
        int i__offset = __offset(204);
        if (i__offset != 0) {
            return biddingInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public IntVector clickActionListVector(IntVector intVector) {
        int i__offset = __offset(116);
        if (i__offset != 0) {
            return intVector.__assign(__vector(i__offset), this.f9449bb);
        }
        return null;
    }

    public AdvertiserInfoFb compliance(AdvertiserInfoFb advertiserInfoFb, int i10) {
        int i__offset = __offset(72);
        if (i__offset != 0) {
            return advertiserInfoFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public AdvertiserInfoFb.Vector complianceVector(AdvertiserInfoFb.Vector vector) {
        int i__offset = __offset(72);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public ContentExtFb contentExts(ContentExtFb contentExtFb, int i10) {
        int i__offset = __offset(154);
        if (i__offset != 0) {
            return contentExtFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public ContentExtFb.Vector contentExtsVector(ContentExtFb.Vector vector) {
        int i__offset = __offset(154);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public DefaultTemplateFb defaultTemplate(DefaultTemplateFb defaultTemplateFb) {
        int i__offset = __offset(168);
        if (i__offset != 0) {
            return defaultTemplateFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public ImpEXFb ext(ImpEXFb impEXFb, int i10) {
        int i__offset = __offset(152);
        if (i__offset != 0) {
            return impEXFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public ImpEXFb.Vector extVector(ImpEXFb.Vector vector) {
        int i__offset = __offset(152);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public FeedbackInfoFb feedbackInfoList(FeedbackInfoFb feedbackInfoFb, int i10) {
        int i__offset = __offset(156);
        if (i__offset != 0) {
            return feedbackInfoFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public FeedbackInfoFb.Vector feedbackInfoListVector(FeedbackInfoFb.Vector vector) {
        int i__offset = __offset(156);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public ImageInfoFb icon(ImageInfoFb imageInfoFb) {
        int i__offset = __offset(84);
        if (i__offset != 0) {
            return imageInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public ImageInfoFb imageInfos(ImageInfoFb imageInfoFb, int i10) {
        int i__offset = __offset(86);
        if (i__offset != 0) {
            return imageInfoFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public ImageInfoFb.Vector imageInfosVector(ImageInfoFb.Vector vector) {
        int i__offset = __offset(86);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector invalidcontentidsVector(StringVector stringVector) {
        int i__offset = __offset(140);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public MonitorFb monitors(MonitorFb monitorFb, int i10) {
        int i__offset = __offset(176);
        if (i__offset != 0) {
            return monitorFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public MonitorFb.Vector monitorsVector(MonitorFb.Vector vector) {
        int i__offset = __offset(176);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector noReportEventListVector(StringVector stringVector) {
        int i__offset = __offset(124);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: om */
    public OmFb m44867om(OmFb omFb, int i10) {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return omFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public OmFb.Vector omVector(OmFb.Vector vector) {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public PromoteInfoFb promoteInfo(PromoteInfoFb promoteInfoFb) {
        int i__offset = __offset(192);
        if (i__offset != 0) {
            return promoteInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public ImageInfoFb rawImageInfos(ImageInfoFb imageInfoFb, int i10) {
        int i__offset = __offset(88);
        if (i__offset != 0) {
            return imageInfoFb.__assign(__indirect(__vector(i__offset) + (i10 * 4)), this.f9449bb);
        }
        return null;
    }

    public ImageInfoFb.Vector rawImageInfosVector(ImageInfoFb.Vector vector) {
        int i__offset = __offset(88);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public StringVector subDescriptionVector(StringVector stringVector) {
        int i__offset = __offset(202);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    public TemplateDataFb templateData(TemplateDataFb templateDataFb) {
        int i__offset = __offset(162);
        if (i__offset != 0) {
            return templateDataFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public VideoInfoFb videoInfo(VideoInfoFb videoInfoFb) {
        int i__offset = __offset(100);
        if (i__offset != 0) {
            return videoInfoFb.__assign(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    public ByteVector workingKeyVector(ByteVector byteVector) {
        int i__offset = __offset(172);
        if (i__offset != 0) {
            return byteVector.__assign(__vector(i__offset), this.f9449bb);
        }
        return null;
    }
}
