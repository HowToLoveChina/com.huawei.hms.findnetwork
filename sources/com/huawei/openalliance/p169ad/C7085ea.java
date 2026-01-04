package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.p173fb.NativeAdFb;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.ea */
/* loaded from: classes8.dex */
public class C7085ea {
    /* renamed from: a */
    public static C7302e m42840a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "data is empty";
        } else {
            try {
                NativeAdFb rootAsNativeAdFb = NativeAdFb.getRootAsNativeAdFb(ByteBuffer.wrap(bArr));
                if (rootAsNativeAdFb == null) {
                    AbstractC7185ho.m43823c("FBSerializeUtil", "fromFlatBuffersBytes native ad is null");
                    return null;
                }
                C7302e c7302e = new C7302e();
                c7302e.m44642h(rootAsNativeAdFb.showId());
                c7302e.m44624c(rootAsNativeAdFb.contentId());
                c7302e.m44614b(rootAsNativeAdFb.endTime());
                c7302e.m44616b(rootAsNativeAdFb.cta());
                c7302e.m44630d(rootAsNativeAdFb.adSign());
                c7302e.m44602a(rootAsNativeAdFb.creativeType());
                c7302e.m44633e(rootAsNativeAdFb.originCreativeType());
                c7302e.m44635e(rootAsNativeAdFb.taskId());
                c7302e.m44638f(rootAsNativeAdFb.label());
                c7302e.m44603a(rootAsNativeAdFb.startTime());
                c7302e.m44640g(rootAsNativeAdFb.intent());
                c7302e.m44613b(rootAsNativeAdFb.adType());
                c7302e.m44644i(rootAsNativeAdFb.requestId());
                c7302e.m44621c(rootAsNativeAdFb.requestType());
                c7302e.m44646j(rootAsNativeAdFb.whyThisAd());
                c7302e.m44648k(rootAsNativeAdFb.adChoiceUrl());
                c7302e.m44650l(rootAsNativeAdFb.adChoiceIcon());
                c7302e.m44615b(Integer.valueOf(rootAsNativeAdFb.fileCachePriority()));
                c7302e.m44654n(rootAsNativeAdFb.appLanguage());
                c7302e.m44656o(rootAsNativeAdFb.appCountry());
                c7302e.setCustomData(rootAsNativeAdFb.customData());
                c7302e.setUserId(rootAsNativeAdFb.userId());
                c7302e.m44611a(C7083dz.m42833a(rootAsNativeAdFb.omVector()));
                c7302e.m44658p(rootAsNativeAdFb.landpgDlInteractionCfg());
                c7302e.m44652m(rootAsNativeAdFb.uniqueId());
                c7302e.m44628d(rootAsNativeAdFb.isPreload());
                c7302e.m44622c(rootAsNativeAdFb.startShowtime());
                c7302e.m44623c(Integer.valueOf(rootAsNativeAdFb.customExposureType()));
                c7302e.m44629d(Integer.valueOf(rootAsNativeAdFb.minEffectiveVideoPlayProgress()));
                c7302e.m44626c(rootAsNativeAdFb.isVastAd());
                c7302e.m44617b(C7083dz.m42824a(rootAsNativeAdFb.adSourcesVector()));
                c7302e.m44660q(rootAsNativeAdFb.logo2Text());
                c7302e.m44662r(rootAsNativeAdFb.abilityDetailInfo());
                c7302e.m44663s(rootAsNativeAdFb.hwChannelId());
                c7302e.m44625c(C7083dz.m42825a(rootAsNativeAdFb.complianceVector()));
                c7302e.m44838f(rootAsNativeAdFb.clicked());
                c7302e.m44845j(rootAsNativeAdFb.interactiontype());
                c7302e.m44754B(rootAsNativeAdFb.encodedParamFromServer());
                c7302e.m44755C(rootAsNativeAdFb.title());
                c7302e.m44756D(rootAsNativeAdFb.description());
                c7302e.m44798a(C7083dz.m42821a(rootAsNativeAdFb.icon()));
                c7302e.m44834e(C7083dz.m42829a(rootAsNativeAdFb.imageInfosVector()));
                c7302e.m44852l(C7083dz.m42829a(rootAsNativeAdFb.rawImageInfosVector()));
                c7302e.m44757E(rootAsNativeAdFb.landWebUrl());
                c7302e.m44831d(rootAsNativeAdFb.minEffectiveShowTime());
                c7302e.m44848k(rootAsNativeAdFb.minEffectiveShowRatio());
                c7302e.m44758F(rootAsNativeAdFb.appPromotionChannel());
                c7302e.m44759G(rootAsNativeAdFb.marketAppId());
                c7302e.m44799a(C7083dz.m42822a(rootAsNativeAdFb.videoInfo()));
                c7302e.m44837f(C7087ec.m42870a(rootAsNativeAdFb.adCloseKeyWordsVector()));
                c7302e.m44839g(C7087ec.m42870a(rootAsNativeAdFb.adCloseKeyWordsTypeVector()));
                c7302e.m44796a(C7083dz.m42818a(rootAsNativeAdFb.appInfo()));
                c7302e.m44760H(rootAsNativeAdFb.metaData());
                c7302e.m44761I(rootAsNativeAdFb.encodedeMonitors());
                c7302e.m44797a(C7083dz.m42819a(rootAsNativeAdFb.audioInfo()));
                c7302e.m44851l(rootAsNativeAdFb.showLandingPageTitleFlag());
                c7302e.m44841h(C7087ec.m42869a(rootAsNativeAdFb.clickActionListVector()));
                c7302e.m44840g(rootAsNativeAdFb.shown());
                c7302e.m44762J(rootAsNativeAdFb.webConfig());
                c7302e.m44763K(rootAsNativeAdFb.ctrlSwitchs());
                c7302e.m44843i(C7087ec.m42870a(rootAsNativeAdFb.noReportEventListVector()));
                c7302e.m44764L(rootAsNativeAdFb.slotId());
                c7302e.m44842h(rootAsNativeAdFb.hasReportShowEventDuringShowTime());
                c7302e.m44770O(rootAsNativeAdFb.taskinfo());
                c7302e.m44771P(rootAsNativeAdFb.encodeWhiteList());
                c7302e.m44774Q(rootAsNativeAdFb.encodeJssdkAllowList());
                c7302e.m44844i(rootAsNativeAdFb.directReturnVideoAd());
                c7302e.m44776R(rootAsNativeAdFb.landingPageType());
                c7302e.m44849k(C7087ec.m42870a(rootAsNativeAdFb.invalidcontentidsVector()));
                c7302e.m44847j(rootAsNativeAdFb.isShowStartReported());
                c7302e.mo44499y(rootAsNativeAdFb.splashMediaPath());
                c7302e.m44833e(rootAsNativeAdFb.apiRecordStartTime());
                c7302e.m44778S(rootAsNativeAdFb.bannerRefSetting());
                c7302e.m44853m(rootAsNativeAdFb.useGaussianBlur());
                c7302e.m44854m(C7083dz.m42830a(rootAsNativeAdFb.extVector()));
                c7302e.m44855n(C7083dz.m42827a(rootAsNativeAdFb.contentExtsVector()));
                c7302e.m44856o(C7083dz.m42828a(rootAsNativeAdFb.feedbackInfoListVector()));
                c7302e.m44766M(rootAsNativeAdFb.templateId());
                c7302e.m44846j(C7083dz.m42826a(rootAsNativeAdFb.assetsVector()));
                c7302e.m44795a(C7083dz.m42812a(rootAsNativeAdFb.templateData()));
                c7302e.m44768N(rootAsNativeAdFb.templateStyle());
                c7302e.m44836f(Integer.valueOf(rootAsNativeAdFb.apiVer()));
                c7302e.m44794a(C7083dz.m42809a(rootAsNativeAdFb.defaultTemplate()));
                c7302e.m44850k(rootAsNativeAdFb.encryptInContentRrd());
                c7302e.m44800a(C7087ec.m42871a(rootAsNativeAdFb.workingKeyVector()));
                c7302e.m44780T(rootAsNativeAdFb.originParamFromServer());
                c7302e.m44857p(C7083dz.m42831a(rootAsNativeAdFb.monitorsVector()));
                c7302e.m44782U(rootAsNativeAdFb.originWhiteList());
                c7302e.m44783V(rootAsNativeAdFb.originJssdkAllowList());
                c7302e.m44610a(rootAsNativeAdFb.ctrlExt());
                c7302e.m44634e(Integer.valueOf(rootAsNativeAdFb.showAppElement()));
                c7302e.m44666t(rootAsNativeAdFb.transparencyTplUrl());
                c7302e.m44631d(rootAsNativeAdFb.transparencySwitch());
                c7302e.m44668u(rootAsNativeAdFb.adRealCallerPkgName());
                c7302e.m44607a(C7083dz.m42811a(rootAsNativeAdFb.promoteInfo()));
                c7302e.m44637f(rootAsNativeAdFb.recallSource());
                c7302e.m44788X(rootAsNativeAdFb.cshareUrl());
                c7302e.m44786W(rootAsNativeAdFb.templateUrl());
                c7302e.m44608a(C7083dz.m42820a(rootAsNativeAdFb.biddingInfo()));
                c7302e.m44612a(rootAsNativeAdFb.hasReportInteractiveImp());
                c7302e.m44832d(C7087ec.m42870a(rootAsNativeAdFb.subDescriptionVector()));
                c7302e.m44789Y(rootAsNativeAdFb.style());
                c7302e.m44792Z(rootAsNativeAdFb.styleExt());
                c7302e.m44805aa(rootAsNativeAdFb.strAssets());
                c7302e.m44670v(rootAsNativeAdFb.trackVersion());
                c7302e.m44609a(Integer.valueOf(rootAsNativeAdFb.sdkMonitor()));
                c7302e.m44672w(rootAsNativeAdFb.bubbleInfo());
                c7302e.m44835f(rootAsNativeAdFb.maxEffectiveShowTime());
                return c7302e;
            } catch (Throwable th2) {
                str = "fromFlatBuffersBytes error:" + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("FBSerializeUtil", str);
        return null;
    }

    /* renamed from: a */
    public static byte[] m42841a(C7302e c7302e) {
        String str;
        if (c7302e == null) {
            str = "toFlatBuffersBytes native ad is null";
        } else {
            try {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
                int[] iArrM42866j = C7086eb.m42866j(c7302e.m44651m(), flatBufferBuilder);
                int[] iArrM42867k = C7086eb.m42867k(c7302e.m44665t(), flatBufferBuilder);
                int[] iArrM42865i = C7086eb.m42865i(c7302e.getCompliance(), flatBufferBuilder);
                int iM42855a = C7086eb.m42855a(c7302e.getIcon(), flatBufferBuilder);
                int[] iArrM42864h = C7086eb.m42864h(c7302e.getImageInfos(), flatBufferBuilder);
                int[] iArrM42864h2 = C7086eb.m42864h(c7302e.getRawImageInfos(), flatBufferBuilder);
                int iM42856a = C7086eb.m42856a(c7302e.getVideoInfo(), flatBufferBuilder);
                int iM42852a = C7086eb.m42852a(c7302e.getAppInfo(), flatBufferBuilder);
                int iM42853a = C7086eb.m42853a(c7302e.getAudioInfo(), flatBufferBuilder);
                int[] iArrM42862f = C7086eb.m42862f(c7302e.m44817am(), flatBufferBuilder);
                int[] iArrM42861e = C7086eb.m42861e(c7302e.m44818an(), flatBufferBuilder);
                int[] iArrM42860d = C7086eb.m42860d(c7302e.getFeedbackInfoList(), flatBufferBuilder);
                int[] iArrM42859c = C7086eb.m42859c(c7302e.m44804aa(), flatBufferBuilder);
                flatBufferBuilder.finish(NativeAdFb.createNativeAdFb(flatBufferBuilder, flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getShowId())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getContentId())), c7302e.getEndTime(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getCta())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getAdSign())), c7302e.getCreativeType(), c7302e.m44671w(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getTaskId())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getLabel())), c7302e.getStartTime(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getIntent())), c7302e.m44632e(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44636f())), c7302e.m44639g(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getWhyThisAd())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getAdChoiceUrl())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getAdChoiceIcon())), c7302e.m44641h() == null ? 5 : c7302e.m44641h().intValue(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44643i())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44645j())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44647k())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44649l())), NativeAdFb.createOmVector(flatBufferBuilder, iArrM42866j), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44653n())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getUniqueId())), c7302e.m44655o(), c7302e.m44657p(), c7302e.m44659q() == null ? 0 : c7302e.m44659q().intValue(), c7302e.m44661r() == null ? 0 : c7302e.m44661r().intValue(), c7302e.m44664s(), NativeAdFb.createAdSourcesVector(flatBufferBuilder, iArrM42867k), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44667u())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getAbilityDetailInfo())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getHwChannelId())), NativeAdFb.createComplianceVector(flatBufferBuilder, iArrM42865i), c7302e.isClicked(), c7302e.getInterActionType(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44765M())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getTitle())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getDescription())), iM42855a, NativeAdFb.createImageInfosVector(flatBufferBuilder, iArrM42864h), NativeAdFb.createRawImageInfosVector(flatBufferBuilder, iArrM42864h2), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getLandWebUrl())), c7302e.getMinEffectiveShowTime(), c7302e.getMinEffectiveShowRatio(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44767N())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44769O())), iM42856a, NativeAdFb.createAdCloseKeyWordsVector(flatBufferBuilder, C7087ec.m42873a(c7302e.getAdCloseKeyWords(), flatBufferBuilder)), NativeAdFb.createAdCloseKeyWordsTypeVector(flatBufferBuilder, C7087ec.m42873a(c7302e.m44773Q(), flatBufferBuilder)), iM42852a, flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44775R())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44777S())), iM42853a, c7302e.m44779T(), NativeAdFb.createClickActionListVector(flatBufferBuilder, C7087ec.m42872a(c7302e.m44781U())), c7302e.m44784V(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44785W())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getCtrlSwitchs())), NativeAdFb.createNoReportEventListVector(flatBufferBuilder, C7087ec.m42873a(c7302e.m44787X(), flatBufferBuilder)), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getSlotId())), c7302e.m44790Y(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44810af())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44811ag())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44812ah())), c7302e.m44825au(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44813ai())), NativeAdFb.createInvalidcontentidsVector(flatBufferBuilder, C7087ec.m42873a(c7302e.getInvalidContentIds(), flatBufferBuilder)), c7302e.m44814aj(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.mo44485F())), c7302e.m44826av(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44816al())), c7302e.m44827aw(), NativeAdFb.createExtVector(flatBufferBuilder, iArrM42862f), NativeAdFb.createContentExtsVector(flatBufferBuilder, iArrM42861e), NativeAdFb.createFeedbackInfoListVector(flatBufferBuilder, iArrM42860d), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44791Z())), NativeAdFb.createAssetsVector(flatBufferBuilder, iArrM42859c), C7086eb.m42846a(c7302e.m44806ab(), flatBufferBuilder), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44807ac())), c7302e.m44808ad() == null ? 0 : c7302e.m44808ad().intValue(), C7086eb.m42843a(c7302e.m44809ae(), flatBufferBuilder), c7302e.m44819ao(), flatBufferBuilder.createByteVector(c7302e.m44820ap()), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44821aq())), NativeAdFb.createMonitorsVector(flatBufferBuilder, C7086eb.m42857a(c7302e.m44822ar(), flatBufferBuilder)), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44823as())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44824at())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44620c())), c7302e.m44674y() != null ? c7302e.m44674y().intValue() : 0, c7302e.isTransparencyOpen(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.getTransparencyTplUrl())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44598A())), C7086eb.m42845a(c7302e.getPromoteInfo(), flatBufferBuilder), c7302e.m44673x(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44828ax())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44829ay())), c7302e.m44619b(), NativeAdFb.createSubDescriptionVector(flatBufferBuilder, C7087ec.m42873a(c7302e.getSubDescription(), flatBufferBuilder)), C7086eb.m42854a(c7302e.getBiddingInfo(), flatBufferBuilder), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44830az())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44802aA())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44803aB())), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44599B())), c7302e.m44601a().intValue(), flatBufferBuilder.createString(C7087ec.m42868a(c7302e.m44600C())), c7302e.getMaxEffectiveShowTime()));
                return flatBufferBuilder.sizedByteArray();
            } catch (Throwable th2) {
                str = "toFlatBuffersBytes error:" + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("FBSerializeUtil", str);
        return null;
    }
}
