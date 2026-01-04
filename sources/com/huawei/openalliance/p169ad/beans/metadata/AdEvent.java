package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdEvent {
    private Integer adReqSource;
    private String agVerifyCode;
    private Integer appDownloadRelatedActionSource;
    private String appVersionCode;
    private Long clickDTime;
    private String clickSuccessDestination;
    private Long clickUTime;
    private Integer clickUpX;
    private Integer clickUpY;
    private Integer clickX;
    private Integer clickY;
    private List<String> closeReason;
    private List<String> closeReasonType;
    private Integer contentDownMethod;
    private String creativeSize;
    private String customData;
    private Integer downloadDuration;
    private Integer downloadMode;
    private Integer downloadReason;
    private Long downloadSize;
    private Integer encodingMode;
    private Integer exposure;

    @InterfaceC6929a
    private String ext;
    private Integer fullDownload;
    private Integer impSource;
    private Integer installRelatedActionSource;
    private String installType;
    private Integer intentDestination;
    private Integer intentFailReason;
    private Integer isAdContainerSizeMatched;
    private String lastFailReason;
    private String lastReportTime;
    private Integer maxShowRatio;
    private int opTimesInLandingPage;

    @InterfaceC6929a
    private ParamFromServer paramfromserver;
    private Integer playedDuration;
    private String playedProgress;
    private Integer playedTime;
    private Integer preCheckResult;
    private List<String> preContentSuccessList;
    private int rawX;
    private int rawY;
    private String realFailedReason;
    private long repeatedCount;
    private Integer requestType;
    private String seq;
    private String shakeAngle;
    private Long showTimeDuration;
    private String showid;
    private Integer sld;
    private String slotPosition;
    private Long startShowTime;
    private long time;
    private String type;
    private String userId;

    @InterfaceC6929a
    private String venusExt;
    private Integer videoPlayEndProgress;
    private Long videoPlayEndTime;
    private Integer videoPlayStartProgress;
    private Long videoPlayStartTime;

    /* renamed from: a */
    public String m39437a() {
        return this.type;
    }

    /* renamed from: b */
    public void m39445b(int i10) {
        this.rawY = i10;
    }

    /* renamed from: c */
    public void m39451c(int i10) {
        this.opTimesInLandingPage = i10;
    }

    /* renamed from: d */
    public void m39456d(Integer num) {
        this.contentDownMethod = num;
    }

    /* renamed from: e */
    public void m39459e(Integer num) {
        this.intentDestination = num;
    }

    /* renamed from: f */
    public void m39462f(Integer num) {
        this.intentFailReason = num;
    }

    /* renamed from: g */
    public void m39465g(Integer num) {
        this.appDownloadRelatedActionSource = num;
    }

    /* renamed from: h */
    public void m39468h(Integer num) {
        this.installRelatedActionSource = num;
    }

    /* renamed from: i */
    public void m39470i(Integer num) {
        this.preCheckResult = num;
    }

    /* renamed from: j */
    public void m39472j(Integer num) {
        this.impSource = num;
    }

    /* renamed from: k */
    public void m39474k(Integer num) {
        this.downloadDuration = num;
    }

    /* renamed from: l */
    public void m39476l(Integer num) {
        this.fullDownload = num;
    }

    /* renamed from: m */
    public void m39478m(Integer num) {
        this.downloadReason = num;
    }

    /* renamed from: n */
    public void m39480n(Integer num) {
        this.downloadMode = num;
    }

    /* renamed from: o */
    public void m39482o(Integer num) {
        this.exposure = num;
    }

    /* renamed from: p */
    public void m39484p(Integer num) {
        this.requestType = num;
    }

    /* renamed from: q */
    public void m39486q(Integer num) {
        this.isAdContainerSizeMatched = num;
    }

    /* renamed from: r */
    public void m39488r(Integer num) {
        this.clickX = num;
    }

    /* renamed from: s */
    public void m39490s(Integer num) {
        this.clickY = num;
    }

    /* renamed from: t */
    public void m39491t(Integer num) {
        this.sld = num;
    }

    /* renamed from: u */
    public void m39492u(Integer num) {
        this.playedTime = num;
    }

    /* renamed from: v */
    public void m39493v(Integer num) {
        this.playedDuration = num;
    }

    /* renamed from: w */
    public void m39494w(Integer num) {
        this.encodingMode = num;
    }

    /* renamed from: x */
    public void m39495x(Integer num) {
        this.adReqSource = num;
    }

    /* renamed from: y */
    public void m39496y(Integer num) {
        this.clickUpX = num;
    }

    /* renamed from: z */
    public void m39497z(Integer num) {
        this.clickUpY = num;
    }

    /* renamed from: a */
    public void m39438a(int i10) {
        this.rawX = i10;
    }

    /* renamed from: b */
    public void m39446b(long j10) {
        this.repeatedCount = j10;
    }

    /* renamed from: c */
    public void m39452c(Integer num) {
        this.videoPlayEndProgress = num;
    }

    /* renamed from: d */
    public void m39457d(Long l10) {
        this.downloadSize = l10;
    }

    /* renamed from: e */
    public void m39460e(Long l10) {
        this.startShowTime = l10;
    }

    /* renamed from: f */
    public void m39463f(Long l10) {
        this.clickDTime = l10;
    }

    /* renamed from: g */
    public void m39466g(Long l10) {
        this.clickUTime = l10;
    }

    /* renamed from: h */
    public void m39469h(String str) {
        this.appVersionCode = str;
    }

    /* renamed from: i */
    public void m39471i(String str) {
        this.realFailedReason = str;
    }

    /* renamed from: j */
    public void m39473j(String str) {
        this.customData = str;
    }

    /* renamed from: k */
    public void m39475k(String str) {
        this.userId = str;
    }

    /* renamed from: l */
    public void m39477l(String str) {
        this.agVerifyCode = str;
    }

    /* renamed from: m */
    public void m39479m(String str) {
        this.installType = str;
    }

    /* renamed from: n */
    public void m39481n(String str) {
        this.creativeSize = str;
    }

    /* renamed from: o */
    public void m39483o(String str) {
        this.venusExt = str;
    }

    /* renamed from: p */
    public void m39485p(String str) {
        this.playedProgress = str;
    }

    /* renamed from: q */
    public void m39487q(String str) {
        this.slotPosition = str;
    }

    /* renamed from: r */
    public void m39489r(String str) {
        this.shakeAngle = str;
    }

    /* renamed from: a */
    public void m39439a(long j10) {
        this.time = j10;
    }

    /* renamed from: b */
    public void m39447b(Integer num) {
        this.videoPlayStartProgress = num;
    }

    /* renamed from: c */
    public void m39453c(Long l10) {
        this.videoPlayEndTime = l10;
    }

    /* renamed from: d */
    public void m39458d(String str) {
        this.seq = str;
    }

    /* renamed from: e */
    public void m39461e(String str) {
        this.ext = str;
    }

    /* renamed from: f */
    public void m39464f(String str) {
        this.lastReportTime = str;
    }

    /* renamed from: g */
    public void m39467g(String str) {
        this.lastFailReason = str;
    }

    /* renamed from: a */
    public void m39440a(ParamFromServer paramFromServer) {
        this.paramfromserver = paramFromServer;
    }

    /* renamed from: b */
    public void m39448b(Long l10) {
        this.videoPlayStartTime = l10;
    }

    /* renamed from: c */
    public void m39454c(String str) {
        this.type = str;
    }

    /* renamed from: a */
    public void m39441a(Integer num) {
        this.maxShowRatio = num;
    }

    /* renamed from: b */
    public void m39449b(String str) {
        this.showid = str;
    }

    /* renamed from: c */
    public void m39455c(List<String> list) {
        this.preContentSuccessList = list;
    }

    /* renamed from: a */
    public void m39442a(Long l10) {
        this.showTimeDuration = l10;
    }

    /* renamed from: b */
    public void m39450b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.closeReasonType = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.closeReasonType.add(AbstractC7806cz.m48170d(it.next()));
        }
    }

    /* renamed from: a */
    public void m39443a(String str) {
        this.clickSuccessDestination = str;
    }

    /* renamed from: a */
    public void m39444a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.closeReason = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.closeReason.add(AbstractC7806cz.m48170d(it.next()));
        }
    }
}
