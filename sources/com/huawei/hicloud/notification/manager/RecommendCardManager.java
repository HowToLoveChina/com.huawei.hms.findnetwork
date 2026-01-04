package com.huawei.hicloud.notification.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.webkit.URLUtil;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.campaign.bean.CampaignEntery;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudBackupNotifyProxy;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.bean.ActivityEntryEx;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.CardEntrance;
import com.huawei.hicloud.notification.constants.DevConditionsConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.AblumSyncConfig;
import com.huawei.hicloud.notification.p106db.bean.BannerSpacePositionConfig;
import com.huawei.hicloud.notification.p106db.bean.BannerSpacePositionConfigActivity;
import com.huawei.hicloud.notification.p106db.bean.BasicConfig;
import com.huawei.hicloud.notification.p106db.bean.BrandMarket;
import com.huawei.hicloud.notification.p106db.bean.C4913Ka;
import com.huawei.hicloud.notification.p106db.bean.ClearLocalSpace;
import com.huawei.hicloud.notification.p106db.bean.CloudBackupClears;
import com.huawei.hicloud.notification.p106db.bean.CommonCard;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.GalleryReleaseSpace;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.Pps;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.p106db.bean.RomVersion;
import com.huawei.hicloud.notification.task.InitFocusAdloaderTask;
import com.huawei.hicloud.notification.task.QueryHiCloudBannerPicturesTask;
import com.huawei.hicloud.notification.task.QueryHiCloudH5ConfigTask;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0224k0;
import p015ak.C0227m;
import p015ak.C0234s;
import p015ak.C0240y;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13191h;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p778xk.C13821b;
import p778xk.C13823d;
import p783xp.C13843a;
import p815ym.AbstractC14026a;

/* loaded from: classes6.dex */
public class RecommendCardManager {
    private static final int PPS_PICTURES_CLEAR_SIZE = 50;
    private static final String TAG = "RecommendCardManager";
    private Map<String, Map<String, List<INativeAd>>> adsMap;
    private boolean buyAdsLoaded;
    ArrayList<RecommendCard> buyRecommendCards;
    private int currentNotifyId;
    private int currentRequestCode;
    private boolean homeAdsLoaded;
    ArrayList<RecommendCard> homepageRecommendCards;
    private CountDownLatch mAlbumSizeCheckLatch;
    private LinkedHashMap<String, Integer> notifyIdMap;
    private HashMap<String, Bitmap> pictureMap;
    private Random pictureNameRand;
    private RecommendReceiver recommendReceiver;
    private HashSet<String> showInfoKeySet;
    private HashSet<String> showKeySet;
    private HashSet<String> unsatisfiedKeySet;

    /* renamed from: com.huawei.hicloud.notification.manager.RecommendCardManager$1 */
    public class C49361 extends AbstractC12367d {
        final /* synthetic */ Handler val$handler;

        public C49361(Handler handler) {
            handler = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            NotifyLogger.m29915i(RecommendCardManager.TAG, "call getHomeRecommendCardsFromCache");
            ArrayList homeRecommendCardsFromCache = RecommendCardManager.this.getHomeRecommendCardsFromCache();
            if (homeRecommendCardsFromCache == null || homeRecommendCardsFromCache.size() == 0) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 9007;
            messageObtain.obj = Boolean.TRUE;
            handler.sendMessage(messageObtain);
            NotifyLogger.m29915i(RecommendCardManager.TAG, "send refresh message");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
        }
    }

    /* renamed from: com.huawei.hicloud.notification.manager.RecommendCardManager$2 */
    public class C49372 extends AbstractC12367d {
        final /* synthetic */ boolean val$isFromRefreshTask;
        final /* synthetic */ ArrayList val$recommendCards;
        final /* synthetic */ ArrayList val$tempRecommendCards;

        public C49372(boolean z10, ArrayList arrayList, ArrayList arrayList2) {
            z = z10;
            arrayList = arrayList;
            arrayList = arrayList2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                if (z) {
                    RecommendCardManager.this.sendNotification(RecommendCardConstants.Entrance.HOMEPAGE, arrayList);
                    return;
                }
                C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME);
                RecommendCardManager.this.replaceCardText(arrayList);
                RecommendCardManager.this.homepageRecommendCards = new ArrayList<>(arrayList);
                int size = arrayList.size();
                NotifyLogger.m29915i(RecommendCardManager.TAG, "set homepage sp num: " + size);
                RecommendCardManager.this.setCardsNumToSp(size);
                RecommendCardManager.this.setCardsLanguageToSp(C0234s.m1636n());
                for (int i10 = 0; i10 < size; i10++) {
                    RecommendCard recommendCard = (RecommendCard) arrayList.get(i10);
                    if (recommendCard != null) {
                        RecommendCardManager.this.setPictureSecondPathToSp(i10, recommendCard.getPictureSecondPath());
                        RecommendCardManager.this.setRemarkToSp(i10, recommendCard.getRemark());
                        RecommendCardManager.this.setButtonToSp(i10, recommendCard.getButton());
                        NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
                        if (notifyTypeAndUriGoto != null) {
                            RecommendCardManager.this.setNotifyTypeToSp(i10, notifyTypeAndUriGoto.getNotifyType());
                            RecommendCardManager.this.setNotifyUriToSp(i10, notifyTypeAndUriGoto.getNotifyUri());
                        }
                        int priority = recommendCard.getPriority();
                        RecommendCardManager.this.setPriorityToSp(i10, priority);
                        boolean zIsFixed = recommendCard.isFixed();
                        RecommendCardManager.this.setFixedToSp(i10, zIsFixed);
                        String activityId = recommendCard.getActivityId();
                        RecommendCardManager.this.setActivityIdToSp(i10, activityId);
                        String activityType = recommendCard.getActivityType();
                        RecommendCardManager.this.setActivityTypeToSp(i10, activityType);
                        NotifyLogger.m29915i(RecommendCardManager.TAG, "set homepage sp index: " + i10 + ", activityId: " + activityId + ", activityType: " + activityType + ", galleryReleaseActivityType: " + recommendCard.getGalleryReleaseActivityType() + ", priority: " + priority + ", fixed: " + zIsFixed);
                        RecommendCardManager.this.setDescriptionToSp(i10, recommendCard.getDescription());
                        RecommendCardManager.this.setDescriptionEndLinkToSp(i10, recommendCard.getDescriptionEndLink());
                    }
                }
                RecommendCardManager.this.sendRefreshCardFinishBroadcast(RecommendCardConstants.Entrance.HOMEPAGE);
                RecommendCardManager.this.sendNotification(RecommendCardConstants.Entrance.HOMEPAGE, arrayList);
            } catch (Exception e10) {
                NotifyLogger.m29914e(RecommendCardManager.TAG, "set homepage sp error: " + e10);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
        }
    }

    /* renamed from: com.huawei.hicloud.notification.manager.RecommendCardManager$3 */
    public class C49383 extends AbstractC12367d {
        final /* synthetic */ String val$entrance;
        final /* synthetic */ boolean val$isFromDetailActivity;
        final /* synthetic */ boolean val$isFromRefreshTask;

        public C49383(String str, boolean z10, boolean z11) {
            str = str;
            z = z10;
            z = z11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                int canBeDisplayedNum = RecommendCardManager.this.getCanBeDisplayedNum(str, z);
                BannerSpacePositionConfig configByEntrance = HiCloudSpacePositionMgrManager.getInstance().getConfigByEntrance(str);
                if (configByEntrance == null) {
                    NotifyLogger.m29914e(RecommendCardManager.TAG, "bannerSpacePositionConfig is null");
                    RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                    return;
                }
                BannerSpacePositionConfigActivity[] activities = configByEntrance.getActivities();
                if (activities == null) {
                    NotifyLogger.m29914e(RecommendCardManager.TAG, "activities is null");
                    RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                    return;
                }
                ArrayList canBeDisplayedCards = RecommendCardManager.this.getCanBeDisplayedCards(str, activities, z, z, canBeDisplayedNum);
                if (canBeDisplayedCards.size() == 0) {
                    NotifyLogger.m29914e(RecommendCardManager.TAG, "canBeDisplayedCards data error");
                    RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                    return;
                }
                NotifyLogger.m29915i(RecommendCardManager.TAG, "canBeDisplayedCards size: " + canBeDisplayedCards.size());
                ArrayList sortedRecommendCards = RecommendCardManager.this.getSortedRecommendCards(str, canBeDisplayedCards);
                if (sortedRecommendCards != null && sortedRecommendCards.size() != 0) {
                    NotifyLogger.m29915i(RecommendCardManager.TAG, "sorted cards size: " + sortedRecommendCards.size());
                    RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, sortedRecommendCards, z, z, canBeDisplayedNum);
                    return;
                }
                NotifyLogger.m29914e(RecommendCardManager.TAG, "sorted cards empty");
                RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
            } catch (Exception e10) {
                NotifyLogger.m29914e(RecommendCardManager.TAG, "getRecommendCards exception: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD_REFRESH;
        }
    }

    public static class Holder {
        private static RecommendCardManager instance = new RecommendCardManager();

        private Holder() {
        }
    }

    public static class RecommendCardComparator implements Comparator<RecommendCard>, Serializable {
        private static final long serialVersionUID = 2902329127356911540L;

        private RecommendCardComparator() {
        }

        public /* synthetic */ RecommendCardComparator(C49361 c49361) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(RecommendCard recommendCard, RecommendCard recommendCard2) {
            if (recommendCard.getCardRefreshMod() != recommendCard2.getCardRefreshMod()) {
                return recommendCard.getCardRefreshMod() - recommendCard2.getCardRefreshMod();
            }
            if (RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL.equals(recommendCard.getActivityType())) {
                return -1;
            }
            return RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(recommendCard.getActivityType()) ? RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL.equals(recommendCard2.getActivityType()) ? 1 : -1 : RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE.equals(recommendCard.getActivityType()) ? (RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL.equals(recommendCard2.getActivityType()) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(recommendCard2.getActivityType())) ? 1 : -1 : (!RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR.equals(recommendCard.getActivityType()) || RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL.equals(recommendCard2.getActivityType()) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(recommendCard2.getActivityType()) || RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE.equals(recommendCard2.getActivityType())) ? 1 : -1;
        }
    }

    public class RecommendReceiver extends BroadcastReceiver {
        public RecommendReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !RecommendCardConstants.ACTION_ALBUM_CHECK_SIZE_FINISH.equals(new SafeIntent(intent).getAction()) || RecommendCardManager.this.mAlbumSizeCheckLatch == null) {
                return;
            }
            RecommendCardManager.this.mAlbumSizeCheckLatch.countDown();
        }
    }

    public static class SendNotificationTask extends AbstractC12367d {
        private String entrance;
        private ArrayList<RecommendCard> recommendCards;

        public SendNotificationTask(String str, ArrayList<RecommendCard> arrayList) {
            this.entrance = str;
            this.recommendCards = new ArrayList<>(arrayList);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
            if (spaceProxy == null) {
                NotifyLogger.m29914e(RecommendCardManager.TAG, "spaceProxy is null");
            } else {
                spaceProxy.sendHomePageRecommendCardsNotification(this.entrance, this.recommendCards);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
        }
    }

    public static class ShowBuyRecommendCardsTask extends AbstractC12367d {
        private ArrayList<RecommendCard> tempCards;

        public ShowBuyRecommendCardsTask(ArrayList<RecommendCard> arrayList) {
            this.tempCards = new ArrayList<>(arrayList);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList<RecommendCard> arrayList = this.tempCards;
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            for (int i10 = 0; i10 < this.tempCards.size(); i10++) {
                RecommendCard recommendCard = this.tempCards.get(i10);
                if (recommendCard != null) {
                    NotifyLogger.m29915i(RecommendCardManager.TAG, "showBuyRecommendCards, index: " + i10 + ", activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType() + ", priority: " + recommendCard.getPriority() + ", fixed: " + recommendCard.isFixed());
                }
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
        }
    }

    public /* synthetic */ RecommendCardManager(C49361 c49361) {
        this();
    }

    private boolean checkKaVersion(int i10, int i11, boolean z10, int i12) {
        switch (i10) {
            case 1:
                if (i12 != i11) {
                    return z10;
                }
                break;
            case 2:
                if (i12 <= i11) {
                    return z10;
                }
                break;
            case 3:
                if (i12 < i11) {
                    return z10;
                }
                break;
            case 4:
                if (i12 >= i11) {
                    return z10;
                }
                break;
            case 5:
                if (i12 > i11) {
                    return z10;
                }
                break;
            case 6:
                if (i12 == i11) {
                    return z10;
                }
                break;
            default:
                return z10;
        }
        return true;
    }

    private boolean checkNotifyUri(NotifyTypeAndUriGoto notifyTypeAndUriGoto) {
        if (notifyTypeAndUriGoto == null) {
            return false;
        }
        String notifyUri = notifyTypeAndUriGoto.getNotifyUri();
        boolean zEquals = TextUtils.equals(NotifyConstants.HICLOUD_PPS, notifyTypeAndUriGoto.getNotifyType());
        if (!zEquals && TextUtils.isEmpty(notifyUri)) {
            return false;
        }
        if (zEquals || !notifyUri.contains(NotifyConstants.InterfaceC4908FA.MAIN_ABILITY)) {
            return true;
        }
        return C0224k0.m1567v() && !C0209d.m1184K0(C0213f.m1377a(), NotifyConstants.InterfaceC4908FA.PACKAGE_NAME);
    }

    private void delEmptyCards(String str, ArrayList<RecommendCard> arrayList) {
        int i10 = 0;
        while (i10 < arrayList.size() && i10 < 100) {
            RecommendCard recommendCard = arrayList.get(i10);
            if (recommendCard == null) {
                NotifyLogger.m29914e(TAG, "recommendCard is null");
            } else {
                boolean z10 = RecommendCardConstants.Entrance.BUY.equals(str) && TextUtils.isEmpty(recommendCard.getLandscapePicturePath());
                boolean z11 = RecommendCardConstants.Entrance.HOMEPAGE.equals(str) && TextUtils.isEmpty(recommendCard.getPictureSecondPath());
                if (TextUtils.isEmpty(recommendCard.getAdvertId()) && (z10 || z11)) {
                    arrayList.remove(i10);
                    i10--;
                }
            }
            i10++;
        }
    }

    private void deletePictures() {
        File[] fileArrListFiles = new File(C0213f.m1378b().getFilesDir() + File.separator + RecommendCardConstants.PictureFileName.FOLDER).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file != null && !file.isDirectory() && !file.delete()) {
                NotifyLogger.m29914e(TAG, "del file failed, file name is " + file.getPath());
            }
        }
    }

    private void downLoadAdsPicture(Map<String, List<INativeAd>> map, String str) throws InterruptedException {
        if (map == null) {
            return;
        }
        Iterator<List<INativeAd>> it = map.values().iterator();
        while (it.hasNext()) {
            for (INativeAd iNativeAd : it.next()) {
                List<ImageInfo> imageInfos = iNativeAd.getImageInfos();
                NotifyLogger.m29915i(TAG, "INativeAd title: " + iNativeAd.getTitle());
                for (ImageInfo imageInfo : imageInfos) {
                    CommonPicture commonPicture = new CommonPicture();
                    commonPicture.setUrl(imageInfo.getUrl());
                    commonPicture.setHash(imageInfo.getSha256());
                    commonPicture.setResolution(RecommendCardConstants.Resolution.PHONE_LANDSCAPE);
                    getInstance().downloadPpsPicture(commonPicture, str);
                }
            }
        }
    }

    private void fillEmptyCards(String str, ArrayList<RecommendCard> arrayList, ArrayList<RecommendCard> arrayList2) {
        ArrayList<RecommendCard> needMoveForwardSceneCards = getNeedMoveForwardSceneCards(str, arrayList);
        NotifyLogger.m29915i(TAG, "getNeedMoveForwardSceneCards size: " + needMoveForwardSceneCards.size());
        for (int i10 = 0; i10 < arrayList2.size() && i10 < 100; i10++) {
            RecommendCard recommendCard = arrayList2.get(i10);
            if (recommendCard == null) {
                NotifyLogger.m29914e(TAG, "recommendCard is null");
            } else {
                boolean z10 = RecommendCardConstants.Entrance.BUY.equals(str) && TextUtils.isEmpty(recommendCard.getLandscapePicturePath());
                boolean z11 = RecommendCardConstants.Entrance.HOMEPAGE.equals(str) && TextUtils.isEmpty(recommendCard.getPictureSecondPath());
                if (TextUtils.isEmpty(recommendCard.getAdvertId()) && (z10 || z11)) {
                    if (needMoveForwardSceneCards.size() > 0) {
                        RecommendCard recommendCard2 = needMoveForwardSceneCards.get(0);
                        if (recommendCard2 != null) {
                            NotifyLogger.m29915i(TAG, "sort list, activityId: " + recommendCard2.getActivityId() + ", activityType: " + recommendCard2.getActivityType());
                            arrayList2.set(i10, recommendCard2);
                        }
                        needMoveForwardSceneCards.remove(0);
                    } else {
                        if (arrayList.size() <= 0) {
                            NotifyLogger.m29915i(TAG, "no card can fill empty");
                            return;
                        }
                        RecommendCard recommendCard3 = arrayList.get(0);
                        if (recommendCard3 != null) {
                            NotifyLogger.m29915i(TAG, "sort resourceCompleteCards, activityId: " + recommendCard3.getActivityId() + ", activityType: " + recommendCard3.getActivityType());
                            arrayList2.set(i10, recommendCard3);
                        }
                        arrayList.remove(0);
                    }
                }
            }
        }
    }

    private RecommendCard getBrandObject(String str, String str2, LinkedHashMap<String, String> linkedHashMap) throws InterruptedException {
        C4913Ka ka2;
        if (!checkEntrance(str)) {
            reportError(linkedHashMap, "entrance is empty");
            return null;
        }
        RecommendCard recommendCard = new RecommendCard();
        BrandMarket brandObjectByActivityId = HiCloudBrandBannerManager.getInstance().getBrandObjectByActivityId(str, str2);
        if (brandObjectByActivityId == null) {
            reportError(linkedHashMap, "brandMarket is null");
            return null;
        }
        if (!C0209d.m1238b2(brandObjectByActivityId.getBeginTime(), brandObjectByActivityId.getEndTime())) {
            NotifyLogger.m29916w(TAG, "time not in range");
            linkedHashMap.put("recommend_card_info", "time not in range");
            getInstance().reportRecommendCardShowInfo(linkedHashMap);
            return null;
        }
        if (!isSatisfiedRomAndTag(brandObjectByActivityId.getrVersions(), brandObjectByActivityId.getUserGroupExtIDs(), linkedHashMap, true, brandObjectByActivityId.isAdSwitchControl())) {
            return null;
        }
        if (brandObjectByActivityId.isKaCard() && (ka2 = brandObjectByActivityId.getKa()) != null && !isKaValid(C0213f.m1377a(), ka2.getPackageName(), ka2.getOperator(), ka2.getVersion())) {
            NotifyLogger.m29914e(TAG, "ka version not valid");
            reportError(linkedHashMap, "ka version not valid");
            return null;
        }
        if (brandObjectByActivityId.isPpsCard()) {
            NotifyLogger.m29915i(TAG, "is pps card");
            Pps pps = brandObjectByActivityId.getPps();
            if (pps == null || TextUtils.isEmpty(pps.getAdvertId())) {
                return null;
            }
            loadAds(str);
            INativeAd ad2 = getAd(str, pps.getAdvertId());
            if (ad2 == null) {
                return null;
            }
            Iterator<ImageInfo> it = ad2.getImageInfos().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(getInstance().getPpsPicturePathFromSp(it.next().getUrl(), str))) {
                    NotifyLogger.m29914e(TAG, "pps picture not download ");
                    return null;
                }
            }
            recommendCard.setAd(ad2);
            recommendCard.setAdvertId(pps.getAdvertId());
        }
        if (brandObjectByActivityId.isTempBackUpCard()) {
            if (!C0209d.m1166E1()) {
                reportError(linkedHashMap, "is not owner user, cannot show temp backup card");
                return null;
            }
            boolean zM79249b = C13191h.m79248a().m79249b("cloudBackupTempBackup");
            BaseLogger.m28733i(TAG, "isShowTempBackupBanner: " + zM79249b);
            if (!zM79249b) {
                reportError(linkedHashMap, "brandMarket temp back card feature not ok");
                return null;
            }
        }
        if (RecommendCardConstants.Entrance.HOMEPAGE.equals(str)) {
            String picturePath = getPicturePath(brandObjectByActivityId.getPicturesSecond());
            if (TextUtils.isEmpty(picturePath) && !brandObjectByActivityId.isPpsCard()) {
                reportError(linkedHashMap, "brandMarket pictureSecondPath is empty");
                return null;
            }
            if (!isPictureToBitmapSuccess(picturePath) && !brandObjectByActivityId.isPpsCard()) {
                NotifyLogger.m29916w(TAG, "brandMarket, second picture to bitmap fail");
                return null;
            }
            recommendCard.setPictureSecondPath(picturePath);
        } else {
            String picturePath2 = getPicturePath(brandObjectByActivityId.getPictures(), true);
            if (TextUtils.isEmpty(picturePath2) && !brandObjectByActivityId.isPpsCard()) {
                reportError(linkedHashMap, "brandMarket landscapePicturePath is empty");
                return null;
            }
            if (!isPictureToBitmapSuccess(picturePath2) && !brandObjectByActivityId.isPpsCard()) {
                NotifyLogger.m29916w(TAG, "brandMarket, landscape picture to bitmap fail");
                return null;
            }
            recommendCard.setLandscapePicturePath(picturePath2);
            String picturePath3 = getPicturePath(brandObjectByActivityId.getPictures(), false);
            if (TextUtils.isEmpty(picturePath3) && !brandObjectByActivityId.isPpsCard()) {
                reportError(linkedHashMap, "brandMarket portraitPicturePath is empty");
                return null;
            }
            if (!brandObjectByActivityId.isPpsCard()) {
                if (!isPictureToBitmapSuccess(picturePath3)) {
                    NotifyLogger.m29916w(TAG, "brandMarket, portrait picture to bitmap fail");
                    return null;
                }
                recommendCard.setPortraitPicturePath(picturePath3);
            }
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = brandObjectByActivityId.getNotifyTypeAndUriGoto();
        if (!checkNotifyUri(notifyTypeAndUriGoto)) {
            reportError(linkedHashMap, "brandMarket notifyTypeAndUriGoto not ok");
            return null;
        }
        recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGoto);
        String[] devConditions = brandObjectByActivityId.getDevConditions();
        NotifyLogger.m29913d(TAG, "getBrandObject devConditions: " + Arrays.toString(devConditions));
        recommendCard.setDevConditions(devConditions);
        if (devConditions == null || isOpenGallerySwitchBannerShouldShow(devConditions)) {
            return getBrandObjectSpilt(str, recommendCard, brandObjectByActivityId, linkedHashMap);
        }
        NotifyLogger.m29915i(TAG, "getBrandObject condition not allow");
        reportError(linkedHashMap, "getBrandObject condition not allow");
        return null;
    }

    private RecommendCard getBrandObjectSpilt(String str, RecommendCard recommendCard, BrandMarket brandMarket, LinkedHashMap<String, String> linkedHashMap) {
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String remark1201 = zEquals ? brandMarket.getRemark1201() : brandMarket.getRemark();
        if (!TextUtils.isEmpty(remark1201)) {
            String stringFromDB = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, remark1201);
            if (TextUtils.isEmpty(stringFromDB)) {
                reportError(linkedHashMap, "Brand remark value is empty");
                return null;
            }
            recommendCard.setRemark(stringFromDB);
        }
        if (TextUtils.isEmpty(remark1201) && zEquals && !brandMarket.isPpsCard()) {
            reportError(linkedHashMap, "Brand remark key is empty");
            return null;
        }
        String title1201 = zEquals ? brandMarket.getTitle1201() : brandMarket.getTitle();
        if (!TextUtils.isEmpty(title1201)) {
            String stringFromDB2 = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, title1201);
            if (!TextUtils.isEmpty(stringFromDB2)) {
                recommendCard.setTitle(stringFromDB2);
            }
        }
        String button1201 = zEquals ? brandMarket.getButton1201() : brandMarket.getButton();
        if (!TextUtils.isEmpty(button1201)) {
            String stringFromDB3 = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, button1201);
            if (!TextUtils.isEmpty(stringFromDB3)) {
                recommendCard.setButton(stringFromDB3);
            }
        }
        String description1201 = zEquals ? brandMarket.getDescription1201() : brandMarket.getDescription();
        if (!TextUtils.isEmpty(description1201)) {
            String stringFromDB4 = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, description1201);
            if (TextUtils.isEmpty(stringFromDB4) && !zEquals) {
                reportError(linkedHashMap, "description is empty");
                return null;
            }
            recommendCard.setDescription(stringFromDB4);
        }
        String notifyBarTitle = brandMarket.getNotifyBarTitle();
        if (!TextUtils.isEmpty(notifyBarTitle)) {
            String stringFromDB5 = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, notifyBarTitle);
            if (!TextUtils.isEmpty(stringFromDB5)) {
                recommendCard.setNotifyBarTitle(stringFromDB5);
            }
        }
        String notifyBarDescription = brandMarket.getNotifyBarDescription();
        if (!TextUtils.isEmpty(notifyBarDescription)) {
            String stringFromDB6 = HiCloudBrandBannerManager.getInstance().getStringFromDB(str, notifyBarDescription);
            if (!TextUtils.isEmpty(stringFromDB6)) {
                recommendCard.setNotifyBarDescription(stringFromDB6);
            }
        }
        recommendCard.setNotifyBar(brandMarket.isNotifyBar());
        recommendCard.setEntrance(str);
        String textLink = brandMarket.getTextLink();
        if (!TextUtils.isEmpty(textLink)) {
            recommendCard.setDescriptionEndLink(HiCloudBrandBannerManager.getInstance().getStringFromDB(str, textLink));
        }
        recommendCard.setTextLinkGoto(brandMarket.getTextGoto());
        return recommendCard;
    }

    private RecommendCard getBrandObjectWithException(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getBrandObject(str, str2, linkedHashMap);
        } catch (Exception e10) {
            this.reportError(linkedHashMap, "getBrandObject exception: " + e10);
            NotifyLogger.m29914e(TAG, "getBrandObject exception: " + e10.toString());
            return null;
        }
    }

    private RecommendCard getCampaignActivityCenterObject(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        CampaignEntery campaignEnteryM82935s = RecommendCardConstants.Entrance.BUY.equals(str) ? C13823d.m82904y().m82935s(7) : RecommendCardConstants.Entrance.HOMEPAGE.equals(str) ? C13823d.m82904y().m82935s(5) : null;
        if (campaignEnteryM82935s == null || campaignEnteryM82935s.getPictures() == null) {
            NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject getCampaignEntery is null");
            return null;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGotoM82941z = RecommendCardConstants.Entrance.BUY.equals(str) ? C13823d.m82904y().m82941z(7) : RecommendCardConstants.Entrance.HOMEPAGE.equals(str) ? C13823d.m82904y().m82941z(5) : null;
        if (notifyTypeAndUriGotoM82941z == null) {
            NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject notifyTypeAndUriGoto is null");
            return null;
        }
        RecommendCard recommendCard = new RecommendCard();
        if (RecommendCardConstants.Entrance.HOMEPAGE.equals(str)) {
            String strM82929m = C13823d.m82904y().m82929m(campaignEnteryM82935s.getPictures());
            if (TextUtils.isEmpty(strM82929m)) {
                NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject pictureSecondPath is empty");
                C13821b.m82867w().m82875b();
                return null;
            }
            if (!new File(strM82929m).exists()) {
                NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject pictureSecond not exists");
                return null;
            }
            recommendCard.setPictureSecondPath(strM82929m);
            recommendCard.setTitle(C13823d.m82904y().m82931o());
            recommendCard.setRemark(C13821b.m82867w().m82872E(campaignEnteryM82935s.getHomepageBannerRemark()));
            if (TextUtils.isEmpty(recommendCard.getRemark())) {
                reportError(linkedHashMap, "getCampaignActivityCenterObject reMark is empty, remark key is null:" + TextUtils.isEmpty(campaignEnteryM82935s.getHomepageBannerRemark()));
                return null;
            }
            recommendCard.setDescription(C13821b.m82867w().m82872E(campaignEnteryM82935s.getHomepageBannerDescription()));
            recommendCard.setButton(C13821b.m82867w().m82872E(campaignEnteryM82935s.getHomepageBannerButton()));
        } else {
            String strM82930n = C13823d.m82904y().m82930n(campaignEnteryM82935s.getPictures(), true);
            String strM82930n2 = C13823d.m82904y().m82930n(campaignEnteryM82935s.getPictures(), false);
            if (TextUtils.isEmpty(strM82930n) || TextUtils.isEmpty(strM82930n2)) {
                NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject pictures is empty");
                C13821b.m82867w().m82875b();
                return null;
            }
            File file = new File(strM82930n);
            File file2 = new File(strM82930n2);
            if (!file.exists() || !file2.exists()) {
                NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject pictures not exists");
                return null;
            }
            recommendCard.setLandscapePicturePath(strM82930n);
            recommendCard.setPortraitPicturePath(strM82930n2);
        }
        recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGotoM82941z);
        recommendCard.setEntrance(str);
        recommendCard.setActivityId(str2);
        C13823d.m82904y().m82916L(5, "");
        return recommendCard;
    }

    private RecommendCard getCampaignActivityCenterObjectWithException(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        if (!CampaignCheckUtil.checkCampaignEntryCondition(C0213f.m1377a())) {
            NotifyLogger.m29915i(TAG, "getCampaignActivityCenterObjectWithException not show");
            return null;
        }
        if (C0212e0.m1354d(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", true)) {
            NotifyLogger.m29915i(TAG, "getCampaignActivityCenterObjectWithException, exceedRedemptionLimit is true!");
            return null;
        }
        try {
            return getCampaignActivityCenterObject(str, str2, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getCampaignActivityCenterObject exception: " + e10.toString());
            return null;
        }
    }

    public ArrayList<RecommendCard> getCanBeDisplayedCards(String str, BannerSpacePositionConfigActivity[] bannerSpacePositionConfigActivityArr, boolean z10, boolean z11, int i10) {
        ArrayList<RecommendCard> arrayList = new ArrayList<>();
        if (!checkEntrance(str)) {
            return arrayList;
        }
        getInstance().reportRecommendCardShowInfoUserTag();
        NotifyLogger.m29915i(TAG, "CanBeDisplayedNum: " + i10 + ", entrance: " + str + ", isFromDetailActivity: " + z11);
        for (int i11 = 1; i11 <= 100 && arrayList.size() != i10; i11++) {
            int length = bannerSpacePositionConfigActivityArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                BannerSpacePositionConfigActivity bannerSpacePositionConfigActivity = bannerSpacePositionConfigActivityArr[i12];
                if (bannerSpacePositionConfigActivity == null) {
                    NotifyLogger.m29914e(TAG, "activity is null");
                } else if (i11 == bannerSpacePositionConfigActivity.getPriority()) {
                    try {
                        getCanBeDisplayedCardsSplit(str, z10, arrayList, bannerSpacePositionConfigActivity);
                        break;
                    } catch (Exception e10) {
                        NotifyLogger.m29914e(TAG, "getCanBeDisplayedCardsSplit error: " + e10.getMessage());
                    }
                }
                i12++;
            }
        }
        return arrayList;
    }

    private void getCanBeDisplayedCardsSplit(String str, boolean z10, ArrayList<RecommendCard> arrayList, BannerSpacePositionConfigActivity bannerSpacePositionConfigActivity) {
        RecommendCard cloudSpaceFullObjectWithException;
        String activityType = bannerSpacePositionConfigActivity.getActivityType();
        if (TextUtils.isEmpty(activityType)) {
            NotifyLogger.m29914e(TAG, "activityType is isEmpty");
            return;
        }
        String activityId = bannerSpacePositionConfigActivity.getActivityId();
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("recommend_card_activity_id", C0209d.m1209S1(activityId));
        linkedHashMapM79497A.put("recommend_card_activity_type", activityType);
        linkedHashMapM79497A.put("recommend_card_entrance", str);
        if (isSceneBannerAlreadyExist(activityType, arrayList)) {
            String str2 = "scene banner already exist, activityId: " + activityId + ", activityType: " + activityType;
            NotifyLogger.m29916w(TAG, str2);
            linkedHashMapM79497A.put("recommend_card_info", str2);
            getInstance().reportRecommendCardShowInfo(linkedHashMapM79497A);
            return;
        }
        NotifyLogger.m29915i(TAG, "start get Recommend, activityType is " + activityType);
        RecommendCard recommendCard = null;
        if (activityType.equals(RecommendCardConstants.ActivityType.INCENTIVE)) {
            if (TextUtils.isEmpty(activityId)) {
                activityId = C0212e0.m1363m(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "activityId", "");
            }
            cloudSpaceFullObjectWithException = getIncentiveObjectWithException(str, getIncentiveCardActivityEntryEx(str, z10, linkedHashMapM79497A), linkedHashMapM79497A);
        } else {
            if (TextUtils.isEmpty(activityId) && !activityType.equals(RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER)) {
                NotifyLogger.m29914e(TAG, "getCanBeDisplayedCards activityId is isEmpty");
                return;
            }
            if (activityType.equals(RecommendCardConstants.ActivityType.BRAND_MARKETS)) {
                cloudSpaceFullObjectWithException = getBrandObjectWithException(str, activityId, linkedHashMapM79497A);
            } else if (activityType.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE)) {
                cloudSpaceFullObjectWithException = getGalleryReleaseSpaceObjectWithException(str, activityId, linkedHashMapM79497A);
            } else if (activityType.equals(RecommendCardConstants.ActivityType.TWO_HUNDRED_GUID)) {
                cloudSpaceFullObjectWithException = getTwoHundredGuidObjectWithException(str, activityId, z10, linkedHashMapM79497A);
            } else if (activityType.equals(RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE)) {
                cloudSpaceFullObjectWithException = getClearLocalSpaceObjectWithException(str, activityId, linkedHashMapM79497A);
            } else if (activityType.equals(RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR)) {
                cloudSpaceFullObjectWithException = getCloudBackupClearObjectWithException(str, activityId, linkedHashMapM79497A);
            } else if (activityType.equals(RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER)) {
                if (TextUtils.isEmpty(activityId)) {
                    activityId = C0212e0.m1363m(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "activityId", "");
                }
                cloudSpaceFullObjectWithException = getCampaignActivityCenterObjectWithException(str, activityId, linkedHashMapM79497A);
            } else {
                cloudSpaceFullObjectWithException = activityType.equals(RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL) ? getCloudSpaceFullObjectWithException(activityId, z10, linkedHashMapM79497A) : null;
            }
        }
        int priority = bannerSpacePositionConfigActivity.getPriority();
        boolean z11 = false;
        boolean z12 = RecommendCardConstants.Entrance.HOMEPAGE.equals(str) && RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(activityType);
        if (RecommendCardConstants.Entrance.BUY.equals(str) && RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE.equals(activityType)) {
            z11 = true;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        BrandMarket brandObjectByActivityId = HiCloudBrandBannerManager.getInstance().getBrandObjectByActivityId(str, activityId);
        if (cloudSpaceFullObjectWithException == null || brandObjectByActivityId == null || spaceProxy.isParamSatisfy(brandObjectByActivityId.getParams(), brandObjectByActivityId.getRealtimeParams(), brandObjectByActivityId.getTrigger())) {
            recommendCard = cloudSpaceFullObjectWithException;
        } else {
            BaseLogger.m28733i(TAG, "paramSatisfy is false");
        }
        String str3 = RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY;
        String str4 = RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN;
        if (recommendCard == null) {
            NotifyLogger.m29916w(TAG, "tempRecommendCard is null, entrance: " + str + ", priority: " + priority + ", activityType: " + activityType + ", activityId: " + activityId);
            if (z12) {
                clearNotification(activityId, RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE);
                clearNotification(activityId, RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN);
            }
            if (z11) {
                clearNotification(activityId, RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY);
                clearNotification(activityId, RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY);
            }
            clearNotification(activityId, activityType);
            reportRecommendCardUnsatisfied(str, activityId, activityType);
            return;
        }
        if (z12) {
            if (!RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(recommendCard.getGalleryReleaseActivityType())) {
                str4 = RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE;
            }
            clearNotification(activityId, str4);
        }
        if (z11) {
            if (!RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(recommendCard.getGalleryReleaseActivityType())) {
                str3 = RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY;
            }
            clearNotification(activityId, str3);
        }
        recommendCard.setActivityId(activityId);
        recommendCard.setActivityType(activityType);
        recommendCard.setPriority(priority);
        recommendCard.setFixed(bannerSpacePositionConfigActivity.isFixed());
        NotifyLogger.m29915i(TAG, "tempRecommendCard not null, entrance: " + str + ", priority: " + priority + ", activityType: " + activityType + ", activityId: " + activityId);
        arrayList.add(recommendCard);
    }

    private RecommendCard getClearLocalSpaceObject(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        ClearLocalSpace clearLocalSpaceObjectByActivityId = HiCloudSceneBannerManager.getInstance().getClearLocalSpaceObjectByActivityId(str, str2);
        if (clearLocalSpaceObjectByActivityId == null) {
            reportError(linkedHashMap, "clearLocalSpace is null");
            return null;
        }
        if (!isFMVersionInRange(clearLocalSpaceObjectByActivityId.getFmRVersions())) {
            reportError(linkedHashMap, "FMVersion not in range");
            return null;
        }
        if (!C13843a.m83074Z(C0213f.m1377a())) {
            reportError(linkedHashMap, "not support localClean");
            return null;
        }
        BasicConfig basicConfig = clearLocalSpaceObjectByActivityId.getBasicConfig();
        if (!isSatisfiedBasicConfig(clearLocalSpaceObjectByActivityId.getBasicConfig(), linkedHashMap)) {
            return null;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = clearLocalSpaceObjectByActivityId.getNotifyTypeAndUriGoto();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String title1201 = zEquals ? clearLocalSpaceObjectByActivityId.getTitle1201() : clearLocalSpaceObjectByActivityId.getTitle();
        String remark1201 = zEquals ? clearLocalSpaceObjectByActivityId.getRemark1201() : clearLocalSpaceObjectByActivityId.getRemark();
        String button1201 = zEquals ? clearLocalSpaceObjectByActivityId.getButton1201() : clearLocalSpaceObjectByActivityId.getButton();
        String description1201 = zEquals ? clearLocalSpaceObjectByActivityId.getDescription1201() : clearLocalSpaceObjectByActivityId.getDescription();
        String notifyBarTitle = clearLocalSpaceObjectByActivityId.getNotifyBarTitle();
        String notifyBarDescription = clearLocalSpaceObjectByActivityId.getNotifyBarDescription();
        RecommendCard sceneBannerObject = RecommendCardConstants.Entrance.HOMEPAGE.equals(str) ? getSceneBannerObject(str, str2, basicConfig, "", "", notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, true, getPicturePath(clearLocalSpaceObjectByActivityId.getPicturesSecond())) : getSceneBannerObject(str, str2, basicConfig, getPicturePath(clearLocalSpaceObjectByActivityId.getPictures(), true), getPicturePath(clearLocalSpaceObjectByActivityId.getPictures(), false), notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, false, "");
        if (sceneBannerObject == null) {
            NotifyLogger.m29914e(TAG, "tempClearLocalSpaceObject is null, activityId: " + str2);
            return null;
        }
        long jM1503m = C0221j.m1503m(C0221j.m1511u(C0213f.m1377a()));
        long jM1688f = C0241z.m1688f(clearLocalSpaceObjectByActivityId.getLocalSpace());
        String str3 = "availableStorageSpace: " + jM1503m + ", localSpace: " + jM1688f;
        NotifyLogger.m29915i(TAG, str3);
        linkedHashMap.put("recommend_card_info", str3);
        getInstance().reportRecommendCardShowInfo(linkedHashMap);
        if (jM1503m > jM1688f) {
            return null;
        }
        NotifyLogger.m29915i(TAG, "availableStorageSpace satisfied");
        sceneBannerObject.setRemark(replaceCleanLocalPlaceholder(sceneBannerObject.getRemark(), jM1503m));
        sceneBannerObject.setDescription(replaceCleanLocalPlaceholder(sceneBannerObject.getDescription(), jM1503m));
        sceneBannerObject.setNotifyBarDescription(replaceCleanLocalPlaceholder(sceneBannerObject.getNotifyBarDescription(), jM1503m));
        return sceneBannerObject;
    }

    private RecommendCard getClearLocalSpaceObjectWithException(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getClearLocalSpaceObject(str, str2, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getClearLocalSpaceObject exception: " + e10.toString());
            return null;
        }
    }

    private RecommendCard getCloudBackupClearObject(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        CloudBackupClears cloudBackupClearByActivityId = HiCloudSceneBannerManager.getInstance().getCloudBackupClearByActivityId(str, str2);
        if (cloudBackupClearByActivityId == null) {
            reportError(linkedHashMap, "cloudBackupClear is null");
            return null;
        }
        BasicConfig basicConfig = cloudBackupClearByActivityId.getBasicConfig();
        if (!isSatisfiedBasicConfig(cloudBackupClearByActivityId.getBasicConfig(), linkedHashMap)) {
            return null;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = cloudBackupClearByActivityId.getNotifyTypeAndUriGoto();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String title1201 = zEquals ? cloudBackupClearByActivityId.getTitle1201() : cloudBackupClearByActivityId.getTitle();
        String remark1201 = zEquals ? cloudBackupClearByActivityId.getRemark1201() : cloudBackupClearByActivityId.getRemark();
        String button1201 = zEquals ? cloudBackupClearByActivityId.getButton1201() : cloudBackupClearByActivityId.getButton();
        String description1201 = zEquals ? cloudBackupClearByActivityId.getDescription1201() : cloudBackupClearByActivityId.getDescription();
        String notifyBarTitle = cloudBackupClearByActivityId.getNotifyBarTitle();
        String notifyBarDescription = cloudBackupClearByActivityId.getNotifyBarDescription();
        RecommendCard sceneBannerObject = RecommendCardConstants.Entrance.HOMEPAGE.equals(str) ? getSceneBannerObject(str, str2, basicConfig, "", "", notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, true, getPicturePath(cloudBackupClearByActivityId.getPicturesSecond())) : getSceneBannerObject(str, str2, basicConfig, getPicturePath(cloudBackupClearByActivityId.getPictures(), true), getPicturePath(cloudBackupClearByActivityId.getPictures(), false), notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, false, "");
        if (sceneBannerObject == null) {
            NotifyLogger.m29914e(TAG, "tempClearOverMonthsObject is null, activityId: " + str2);
            return null;
        }
        ICloudBackupNotifyProxy cloudBackupProxy = CloudSpaceNotifyUtil.getInstance().getCloudBackupProxy();
        if (cloudBackupProxy != null && cloudBackupProxy.isBackupClearsConditionAllow()) {
            return sceneBannerObject;
        }
        NotifyLogger.m29914e(TAG, "proxy is null");
        return null;
    }

    private RecommendCard getCloudBackupClearObjectWithException(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getCloudBackupClearObject(str, str2, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getCloudBackupClearObject exception: " + e10.toString());
            return null;
        }
    }

    private RecommendCard getCloudSpaceFullObject(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        if (z10) {
            NotifyLogger.m29916w(TAG, "from refresh, not show full card");
            return null;
        }
        if (C13452e.m80781L().m80791C0()) {
            NotifyLogger.m29916w(TAG, "Basic service User, Cannot show CloudSpaceFull Banner");
            return null;
        }
        CommonCard cloudSpaceFullObjectByActivityId = HiCloudSceneBannerManager.getInstance().getCloudSpaceFullObjectByActivityId(str);
        if (cloudSpaceFullObjectByActivityId == null) {
            reportError(linkedHashMap, "cloudSpaceFull is null");
            return null;
        }
        BasicConfig basicConfig = cloudSpaceFullObjectByActivityId.getBasicConfig();
        if (!isSatisfiedBasicConfig(basicConfig, linkedHashMap)) {
            return null;
        }
        String picturePath = getPicturePath(cloudSpaceFullObjectByActivityId.getPicturesSecond());
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = cloudSpaceFullObjectByActivityId.getNotifyTypeAndUriGoto();
        RecommendCard sceneBannerObject = getSceneBannerObject(RecommendCardConstants.Entrance.HOMEPAGE, str, basicConfig, "", "", notifyTypeAndUriGoto, cloudSpaceFullObjectByActivityId.getTitle1201(), cloudSpaceFullObjectByActivityId.getRemark1201(), cloudSpaceFullObjectByActivityId.getButton1201(), cloudSpaceFullObjectByActivityId.getDescription1201(), cloudSpaceFullObjectByActivityId.getNotifyBarTitle(), cloudSpaceFullObjectByActivityId.getNotifyBarDescription(), linkedHashMap, true, picturePath);
        if (sceneBannerObject == null) {
            NotifyLogger.m29914e(TAG, "tempCloudSpaceFullObject is null, activityId: " + str);
            return null;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return null;
        }
        CloudSpace cloudSpaceIsSatisfiedCloudSpaceFull = spaceProxy.isSatisfiedCloudSpaceFull(notifyTypeAndUriGoto.getNotifyType(), notifyTypeAndUriGoto.getNotifyUri());
        if (cloudSpaceIsSatisfiedCloudSpaceFull == null) {
            return null;
        }
        long used = cloudSpaceIsSatisfiedCloudSpaceFull.getUsed();
        long total = cloudSpaceIsSatisfiedCloudSpaceFull.getTotal();
        long j10 = used - total;
        if (total <= 0) {
            NotifyLogger.m29916w(TAG, "getCloudSpaceFullObject, total space is zero!");
            return null;
        }
        sceneBannerObject.setRemark(replaceCloudSpaceFullPlaceholder(spaceProxy, sceneBannerObject.getRemark(), used, total, j10));
        sceneBannerObject.setDescription(replaceCloudSpaceFullPlaceholder(spaceProxy, sceneBannerObject.getDescription(), used, total, j10));
        sceneBannerObject.setNotifyBarDescription(replaceCloudSpaceFullPlaceholder(spaceProxy, sceneBannerObject.getNotifyBarDescription(), used, total, j10));
        return sceneBannerObject;
    }

    private RecommendCard getCloudSpaceFullObjectWithException(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getCloudSpaceFullObject(str, z10, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getCloudSpaceFullObject exception: " + e10.toString());
            return null;
        }
    }

    private RecommendCard getGalleryReleaseSpaceObject(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        GalleryReleaseSpace galleryReleaseSpaceObjectByActivityId = HiCloudSceneBannerManager.getInstance().getGalleryReleaseSpaceObjectByActivityId(str, str2);
        if (galleryReleaseSpaceObjectByActivityId == null) {
            reportError(linkedHashMap, "galleryReleaseSpace is null");
            return null;
        }
        AblumSyncConfig ablumSyncConfig = galleryReleaseSpaceObjectByActivityId.getAblumSyncConfig();
        if (ablumSyncConfig == null) {
            NotifyLogger.m29914e(TAG, "ablumSyncConfig is null");
            return null;
        }
        BasicConfig basicConfig = galleryReleaseSpaceObjectByActivityId.getBasicConfig();
        if (isSatisfiedBasicConfig(basicConfig, linkedHashMap)) {
            return getGalleryReleaseSpaceObjectSplit(str, str2, galleryReleaseSpaceObjectByActivityId, ablumSyncConfig, basicConfig, linkedHashMap);
        }
        return null;
    }

    private RecommendCard getGalleryReleaseSpaceObjectSplit(String str, String str2, GalleryReleaseSpace galleryReleaseSpace, AblumSyncConfig ablumSyncConfig, BasicConfig basicConfig, LinkedHashMap<String, String> linkedHashMap) {
        if (C13452e.m80781L().m80791C0()) {
            NotifyLogger.m29916w(TAG, "Basic service User, Cannot show GalleryReleaseSpace Banner");
            return null;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return null;
        }
        if (!spaceProxy.isGallerySupportSetting()) {
            NotifyLogger.m29914e(TAG, "gallery not support setting");
            return null;
        }
        boolean zIsGeneralAlbumOn = isGeneralAlbumOn(spaceProxy);
        NotifyLogger.m29915i(TAG, "galleryStatus: " + zIsGeneralAlbumOn);
        RecommendCard galleryReleaseSpaceSyncObject = zIsGeneralAlbumOn ? getGalleryReleaseSpaceSyncObject(str, ablumSyncConfig, basicConfig, str2, linkedHashMap) : getGalleryReleaseSpaceUnSyncObject(str, ablumSyncConfig, basicConfig, str2, linkedHashMap);
        if (galleryReleaseSpaceSyncObject == null) {
            NotifyLogger.m29914e(TAG, "tempGalleryReleaseSpaceObject is null, activityId: " + str2);
            return null;
        }
        if (zIsGeneralAlbumOn) {
            galleryReleaseSpaceSyncObject.setTextLinkGoto(ablumSyncConfig.getSyncTextGoto());
            galleryReleaseSpaceSyncObject.setGalleryReleaseActivityType(RecommendCardConstants.Entrance.BUY.equals(str) ? RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY : RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN);
        } else {
            galleryReleaseSpaceSyncObject.setGalleryReleaseActivityType(RecommendCardConstants.Entrance.BUY.equals(str) ? RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY : RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE);
            galleryReleaseSpaceSyncObject.setTextLinkGoto(ablumSyncConfig.getUnSyncTextGoto());
        }
        long jM1688f = C0241z.m1688f(galleryReleaseSpace.getLocalPhotoSpace());
        long jM1688f2 = C0241z.m1688f(galleryReleaseSpace.getLocalClearSpace());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mAlbumSizeCheckLatch = countDownLatch;
        long localClearSpace = zIsGeneralAlbumOn ? spaceProxy.getLocalClearSpace(countDownLatch) : spaceProxy.getLocalPhotoSpace(countDownLatch);
        String str3 = "localClearSpace: " + jM1688f2 + ", localPhotoSpace: " + jM1688f + ", size: " + localClearSpace;
        NotifyLogger.m29915i(TAG, str3);
        linkedHashMap.put("recommend_card_info", str3);
        getInstance().reportRecommendCardShowInfo(linkedHashMap);
        if (!zIsGeneralAlbumOn ? localClearSpace >= jM1688f : localClearSpace >= jM1688f2) {
            return null;
        }
        galleryReleaseSpaceSyncObject.setRemark(replaceGalleryPlaceholder(galleryReleaseSpaceSyncObject.getRemark(), localClearSpace));
        galleryReleaseSpaceSyncObject.setDescription(replaceGalleryPlaceholder(galleryReleaseSpaceSyncObject.getDescription(), localClearSpace));
        galleryReleaseSpaceSyncObject.setNotifyBarDescription(replaceGalleryPlaceholder(galleryReleaseSpaceSyncObject.getNotifyBarDescription(), localClearSpace));
        return galleryReleaseSpaceSyncObject;
    }

    private RecommendCard getGalleryReleaseSpaceObjectWithException(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getGalleryReleaseSpaceObject(str, str2, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getGalleryReleaseSpaceObject exception: " + e10.toString());
            return null;
        }
    }

    private RecommendCard getGalleryReleaseSpaceSyncObject(String str, AblumSyncConfig ablumSyncConfig, BasicConfig basicConfig, String str2, LinkedHashMap<String, String> linkedHashMap) {
        NotifyTypeAndUriGoto syncGoto = ablumSyncConfig.getSyncGoto();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String syncTitle1201 = zEquals ? ablumSyncConfig.getSyncTitle1201() : ablumSyncConfig.getSyncTitle();
        String syncRemark1201 = zEquals ? ablumSyncConfig.getSyncRemark1201() : ablumSyncConfig.getSyncRemark();
        String syncButton1201 = zEquals ? ablumSyncConfig.getSyncButton1201() : ablumSyncConfig.getSyncButton();
        String syncDescription1201 = zEquals ? ablumSyncConfig.getSyncDescription1201() : ablumSyncConfig.getSyncDescription();
        String syncTextLink = ablumSyncConfig.getSyncTextLink();
        String syncNotifyBarTitle = ablumSyncConfig.getSyncNotifyBarTitle();
        String syncNotifyBarDescription = ablumSyncConfig.getSyncNotifyBarDescription();
        return zEquals ? getSceneBannerObjectWithTextLink(str, str2, basicConfig, "", "", syncGoto, syncTitle1201, syncRemark1201, syncButton1201, syncDescription1201, syncTextLink, syncNotifyBarTitle, syncNotifyBarDescription, linkedHashMap, true, getPicturePath(ablumSyncConfig.getSyncPicturesSecond())) : getSceneBannerObjectWithTextLink(str, str2, basicConfig, getPicturePath(ablumSyncConfig.getSyncPictures(), true), getPicturePath(ablumSyncConfig.getSyncPictures(), false), syncGoto, syncTitle1201, syncRemark1201, syncButton1201, syncDescription1201, syncTextLink, syncNotifyBarTitle, syncNotifyBarDescription, linkedHashMap, false, "");
    }

    private RecommendCard getGalleryReleaseSpaceUnSyncObject(String str, AblumSyncConfig ablumSyncConfig, BasicConfig basicConfig, String str2, LinkedHashMap<String, String> linkedHashMap) {
        NotifyTypeAndUriGoto unSyncGoto = ablumSyncConfig.getUnSyncGoto();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String unSyncTitle1201 = zEquals ? ablumSyncConfig.getUnSyncTitle1201() : ablumSyncConfig.getUnSyncTitle();
        String unSyncRemark1201 = zEquals ? ablumSyncConfig.getUnSyncRemark1201() : ablumSyncConfig.getUnSyncRemark();
        String unSyncButton1201 = zEquals ? ablumSyncConfig.getUnSyncButton1201() : ablumSyncConfig.getUnSyncButton();
        String unSyncDescription1201 = zEquals ? ablumSyncConfig.getUnSyncDescription1201() : ablumSyncConfig.getUnSyncDescription();
        String unSyncTextLink = ablumSyncConfig.getUnSyncTextLink();
        String unSyncNotifyBarTitle = ablumSyncConfig.getUnSyncNotifyBarTitle();
        String unSyncNotifyBarDescription = ablumSyncConfig.getUnSyncNotifyBarDescription();
        return zEquals ? getSceneBannerObjectWithTextLink(str, str2, basicConfig, "", "", unSyncGoto, unSyncTitle1201, unSyncRemark1201, unSyncButton1201, unSyncDescription1201, unSyncTextLink, unSyncNotifyBarTitle, unSyncNotifyBarDescription, linkedHashMap, true, getPicturePath(ablumSyncConfig.getUnSyncPicturesSecond())) : getSceneBannerObjectWithTextLink(str, str2, basicConfig, getPicturePath(ablumSyncConfig.getUnSyncPictures(), true), getPicturePath(ablumSyncConfig.getUnSyncPictures(), false), unSyncGoto, unSyncTitle1201, unSyncRemark1201, unSyncButton1201, unSyncDescription1201, unSyncTextLink, unSyncNotifyBarTitle, unSyncNotifyBarDescription, linkedHashMap, false, "");
    }

    public ArrayList<RecommendCard> getHomeRecommendCardsFromCache() {
        ArrayList<RecommendCard> arrayList = new ArrayList<>();
        int cardsNumFromSp = getCardsNumFromSp();
        NotifyLogger.m29915i(TAG, "cached recommend num is: " + cardsNumFromSp);
        if (cardsNumFromSp == 0) {
            return arrayList;
        }
        String cardsLanguageFromSp = getCardsLanguageFromSp();
        if (!StringUtil.equals(cardsLanguageFromSp, C0234s.m1636n())) {
            NotifyLogger.m29916w(TAG, "language is changed, cache language is: " + cardsLanguageFromSp);
            return arrayList;
        }
        NotifyLogger.m29915i(TAG, "getHomePageRecommendCardsFromSp, num: " + cardsNumFromSp);
        for (int i10 = 0; i10 < cardsNumFromSp; i10++) {
            RecommendCard recommendCard = new RecommendCard();
            String pictureSecondPathFromSp = getPictureSecondPathFromSp(i10);
            recommendCard.setEntrance(RecommendCardConstants.Entrance.HOMEPAGE);
            recommendCard.setPictureSecondPath(pictureSecondPathFromSp);
            recommendCard.setRemark(getRemarkFromSp(i10));
            recommendCard.setButton(getButtonFromSp(i10));
            if (recommendCard.isValid()) {
                NotifyTypeAndUriGoto notifyTypeAndUriGoto = new NotifyTypeAndUriGoto();
                notifyTypeAndUriGoto.setNotifyType(getNotifyTypeFromSp(i10));
                notifyTypeAndUriGoto.setNotifyUri(getNotifyUriFromSp(i10));
                recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGoto);
                String activityIdFromSp = getActivityIdFromSp(i10);
                recommendCard.setActivityId(activityIdFromSp);
                String activityTypeFromSp = getActivityTypeFromSp(i10);
                recommendCard.setActivityType(activityTypeFromSp);
                int priorityFromSp = getPriorityFromSp(i10);
                recommendCard.setPriority(priorityFromSp);
                boolean fixedFromSp = getFixedFromSp(i10);
                recommendCard.setFixed(fixedFromSp);
                recommendCard.setDescription(getDescriptionFromSp(i10));
                recommendCard.setDescriptionEndLink(getDescriptionEndLinkFromSp(i10));
                NotifyLogger.m29915i(TAG, "get homepage sp index: " + i10 + ", activityId: " + activityIdFromSp + ", activityType: " + activityTypeFromSp + ", priority: " + priorityFromSp + ", fixed: " + fixedFromSp);
                arrayList.add(recommendCard);
            } else {
                NotifyLogger.m29916w(TAG, "card is invalid");
            }
        }
        this.homepageRecommendCards = arrayList;
        return arrayList;
    }

    private RecommendCard getIncentiveObject(String str, ActivityEntryEx activityEntryEx, LinkedHashMap<String, String> linkedHashMap) {
        String str2;
        String str3;
        String str4;
        if (activityEntryEx == null) {
            NotifyLogger.m29914e(TAG, "activityEntryEx is null");
            return null;
        }
        if (C13452e.m80781L().m80795D0()) {
            NotifyLogger.m29916w(TAG, "getIncentiveObject is child account, can't display");
            return null;
        }
        String resource = activityEntryEx.getResource();
        if (TextUtils.isEmpty(resource)) {
            reportError(linkedHashMap, "resourceId is empty");
            return null;
        }
        NotifyLogger.m29915i(TAG, "resourceId: " + resource);
        H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(resource);
        if (h5ResourceById == null) {
            NotifyLogger.m29914e(TAG, "h5Resource is null");
            return null;
        }
        RecommendCard recommendCard = new RecommendCard();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        if (zEquals) {
            String picturePath = getPicturePath(h5ResourceById.getHomePagePictureSecond());
            if (TextUtils.isEmpty(picturePath) || !isPictureToBitmapSuccess(picturePath)) {
                reportError(linkedHashMap, "incentive pictureSecond is illegal");
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(h5ResourceById.getHomePagePictureSecond()), false);
                return null;
            }
            recommendCard.setPictureSecondPath(picturePath);
        } else {
            String picturePath2 = HicloudH5ConfigManager.getInstance().getPicturePath(str, resource, true);
            if (TextUtils.isEmpty(picturePath2)) {
                reportError(linkedHashMap, "incentive landscapePicturePath is empty");
                return null;
            }
            recommendCard.setLandscapePicturePath(picturePath2);
            String picturePath3 = HicloudH5ConfigManager.getInstance().getPicturePath(str, resource, false);
            if (TextUtils.isEmpty(picturePath3)) {
                reportError(linkedHashMap, "incentive portraitPicturePath is empty");
                return null;
            }
            if (!isPictureToBitmapSuccess(picturePath2) || !isPictureToBitmapSuccess(picturePath3)) {
                NotifyLogger.m29916w(TAG, "incentive, picture to bitmap fail");
                return null;
            }
            recommendCard.setPortraitPicturePath(picturePath3);
        }
        if (zEquals) {
            Map<String, String> noticeText = h5ResourceById.getNoticeText();
            if (noticeText == null || noticeText.size() <= 0) {
                str2 = "";
                str3 = str2;
                str4 = str3;
            } else {
                str2 = "";
                str3 = str2;
                str4 = str3;
                for (Map.Entry<String, String> entry : noticeText.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_REMARK_1201.equals(key)) {
                            str2 = value;
                        } else if (NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_BUTTON_1201.equals(key)) {
                            str3 = value;
                        } else if (NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_DESCRIPTION_1201.equals(key)) {
                            str4 = value;
                        }
                    }
                }
            }
            String strFromDBByResource = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_TITLE_1201);
            if (!TextUtils.isEmpty(strFromDBByResource)) {
                recommendCard.setTitle(strFromDBByResource);
            }
            String strFromDBByResource2 = TextUtils.isEmpty(str2) ? "" : NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_REMARK_1201);
            if (TextUtils.isEmpty(strFromDBByResource2)) {
                reportError(linkedHashMap, "incentive remark is empty");
                return null;
            }
            recommendCard.setRemark(strFromDBByResource2);
            if (!TextUtils.isEmpty(str3)) {
                String strFromDBByResource3 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_BUTTON_1201);
                if (!TextUtils.isEmpty(strFromDBByResource3)) {
                    recommendCard.setButton(strFromDBByResource3);
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                String strFromDBByResource4 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_DESCRIPTION_1201);
                if (TextUtils.isEmpty(strFromDBByResource4)) {
                    NotifyLogger.m29916w(TAG, "incentive description is empty");
                } else {
                    recommendCard.setDescription(strFromDBByResource4);
                }
            }
        } else {
            String strFromDBByResource5 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_TITLE);
            if (!TextUtils.isEmpty(strFromDBByResource5)) {
                recommendCard.setTitle(strFromDBByResource5);
            }
            String strFromDBByResource6 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_REMARK);
            if (!TextUtils.isEmpty(strFromDBByResource6)) {
                recommendCard.setRemark(strFromDBByResource6);
            }
            String strFromDBByResource7 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_BUTTON);
            if (!TextUtils.isEmpty(strFromDBByResource7)) {
                recommendCard.setButton(strFromDBByResource7);
            }
            String strFromDBByResource8 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_BANNER_DESCRIPTION);
            if (!TextUtils.isEmpty(strFromDBByResource8)) {
                recommendCard.setDescription(strFromDBByResource8);
            }
        }
        String strFromDBByResource9 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_NOTIFYBAR_TITLE);
        if (!TextUtils.isEmpty(strFromDBByResource9)) {
            recommendCard.setNotifyBarTitle(strFromDBByResource9);
        }
        String strFromDBByResource10 = NoticeWithActivityUtil.getStrFromDBByResource(resource, NotifyConstants.H5SpaceNoticeStringKey.HOMEPAGE_NOTIFYBAR_DESCRIPTION);
        if (!TextUtils.isEmpty(strFromDBByResource10)) {
            recommendCard.setNotifyBarDescription(strFromDBByResource10);
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = new NotifyTypeAndUriGoto();
        notifyTypeAndUriGoto.setNotifyType(NotifyConstants.HICLOUD_DLAPP);
        notifyTypeAndUriGoto.setNotifyUri(activityEntryEx.getUrl());
        recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGoto);
        recommendCard.setNotifyBar(true);
        recommendCard.setEntrance(str);
        return recommendCard;
    }

    public static RecommendCardManager getInstance() {
        return Holder.instance;
    }

    private ArrayList<RecommendCard> getNeedMoveForwardSceneCards(String str, ArrayList<RecommendCard> arrayList) {
        int i10;
        int i11;
        ArrayList<RecommendCard> arrayList2 = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12 = i11 + 1) {
            RecommendCard recommendCard = arrayList.get(i12);
            if (recommendCard == null) {
                NotifyLogger.m29914e(TAG, "sort tempCard is null");
            } else {
                String activityId = recommendCard.getActivityId();
                if (TextUtils.isEmpty(activityId)) {
                    NotifyLogger.m29916w(TAG, "sort activityId is empty");
                } else {
                    String activityType = recommendCard.getActivityType();
                    if (TextUtils.isEmpty(activityType)) {
                        NotifyLogger.m29914e(TAG, "sort activityType is empty");
                    } else {
                        int cardRefresh = recommendCard.getCardRefresh();
                        if (cardRefresh != 0) {
                            boolean z10 = activityType.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) || activityType.equals(RecommendCardConstants.ActivityType.TWO_HUNDRED_GUID) || activityType.equals(RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE);
                            boolean z11 = activityType.equals(RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR) || activityType.equals(RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL);
                            if (z10 || z11) {
                                long firstShowTimeFromSp = getFirstShowTimeFromSp(str, activityId);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                i10 = i12;
                                int i13 = (int) ((jCurrentTimeMillis - firstShowTimeFromSp) / 86400000);
                                NotifyLogger.m29915i(TAG, "getNeedMoveForwardSceneCards, entrance: " + str + ", activityId: " + activityId + ", activityType: " + activityType + ", firstShowTime: " + firstShowTimeFromSp + ", now: " + jCurrentTimeMillis + ", diff: " + i13 + ", cardRefresh: " + cardRefresh);
                                if (firstShowTimeFromSp == 0) {
                                    setFirstShowTimeToSp(str, activityId);
                                } else if (i13 >= cardRefresh) {
                                    recommendCard.setCardRefreshMod(i13 % cardRefresh);
                                    arrayList2.add(recommendCard);
                                    arrayList.remove(i10);
                                    i11 = i10 - 1;
                                }
                            }
                            i11 = i10;
                        }
                    }
                }
            }
            i10 = i12;
            i11 = i10;
        }
        Collections.sort(arrayList2, new RecommendCardComparator());
        return arrayList2;
    }

    private String getPpsPicturePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + RecommendCardConstants.PictureFileName.PPS_FOLDER;
    }

    private RecommendCard getSceneBannerObject(String str, String str2, BasicConfig basicConfig, String str3, String str4, NotifyTypeAndUriGoto notifyTypeAndUriGoto, String str5, String str6, String str7, String str8, String str9, String str10, LinkedHashMap<String, String> linkedHashMap, boolean z10, String str11) {
        return getSceneBannerObjectWithTextLink(str, str2, basicConfig, str3, str4, notifyTypeAndUriGoto, str5, str6, str7, str8, "", str9, str10, linkedHashMap, z10, str11);
    }

    private RecommendCard getSceneBannerObjectSplit(String str, RecommendCard recommendCard, String str2, String str3, String str4, String str5, String str6, String str7, String str8, LinkedHashMap<String, String> linkedHashMap) {
        boolean zEquals = StringUtil.equals(str, RecommendCardConstants.Entrance.HOMEPAGE);
        if (!TextUtils.isEmpty(str3)) {
            String stringFromDB = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str3);
            if (TextUtils.isEmpty(stringFromDB)) {
                reportError(linkedHashMap, "remark value is empty");
                return null;
            }
            recommendCard.setRemark(stringFromDB);
        }
        if (TextUtils.isEmpty(str3) && zEquals) {
            reportError(linkedHashMap, "remark key is empty");
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            String stringFromDB2 = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str2);
            if (!TextUtils.isEmpty(stringFromDB2)) {
                recommendCard.setTitle(stringFromDB2);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            String stringFromDB3 = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str4);
            if (!TextUtils.isEmpty(stringFromDB3)) {
                recommendCard.setButton(stringFromDB3);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            String stringFromDB4 = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str5);
            if (TextUtils.isEmpty(stringFromDB4) && !zEquals) {
                reportError(linkedHashMap, "description is empty");
                return null;
            }
            recommendCard.setDescription(stringFromDB4);
        }
        if (!TextUtils.isEmpty(str6)) {
            recommendCard.setDescriptionEndLink(HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str6));
        }
        if (!TextUtils.isEmpty(str7)) {
            String stringFromDB5 = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str7);
            if (!TextUtils.isEmpty(stringFromDB5)) {
                recommendCard.setNotifyBarTitle(stringFromDB5);
            }
        }
        if (!TextUtils.isEmpty(str8)) {
            String stringFromDB6 = HiCloudSceneBannerManager.getInstance().getStringFromDB(str, str8);
            if (!TextUtils.isEmpty(stringFromDB6)) {
                recommendCard.setNotifyBarDescription(stringFromDB6);
            }
        }
        return recommendCard;
    }

    private RecommendCard getSceneBannerObjectWithTextLink(String str, String str2, BasicConfig basicConfig, String str3, String str4, NotifyTypeAndUriGoto notifyTypeAndUriGoto, String str5, String str6, String str7, String str8, String str9, String str10, String str11, LinkedHashMap<String, String> linkedHashMap, boolean z10, String str12) {
        RecommendCard recommendCard = new RecommendCard();
        if (z10) {
            if (TextUtils.isEmpty(str12)) {
                reportError(linkedHashMap, "pictureSecondPath is null");
                return null;
            }
            if (!isPictureToBitmapSuccess(str12)) {
                NotifyLogger.m29916w(TAG, "scene, picture to bitmap fail");
                return null;
            }
            recommendCard.setPictureSecondPath(str12);
        } else {
            if (TextUtils.isEmpty(str3)) {
                reportError(linkedHashMap, "landscapePicturePath is null");
                return null;
            }
            if (TextUtils.isEmpty(str4)) {
                reportError(linkedHashMap, "portraitPicturePath is null");
                return null;
            }
            if (!isPictureToBitmapSuccess(str3) || !isPictureToBitmapSuccess(str4)) {
                NotifyLogger.m29916w(TAG, "scene, picture to bitmap fail");
                return null;
            }
            recommendCard.setLandscapePicturePath(str3);
            recommendCard.setPortraitPicturePath(str4);
        }
        if (!checkNotifyUri(notifyTypeAndUriGoto)) {
            reportError(linkedHashMap, "notifyTypeAndUriGoto not ok");
            return null;
        }
        recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGoto);
        if (basicConfig != null) {
            recommendCard.setNotifyBar(basicConfig.isNotifyBar());
            recommendCard.setCardRefresh(basicConfig.getCardRefresh());
            recommendCard.setEntrance(str);
            return getSceneBannerObjectSplit(str, recommendCard, str5, str6, str7, str8, str9, str10, str11, linkedHashMap);
        }
        NotifyLogger.m29914e(TAG, "basicConfig is null, activityId: " + str2);
        return null;
    }

    public ArrayList<RecommendCard> getSortedRecommendCards(String str, ArrayList<RecommendCard> arrayList) {
        ArrayList<RecommendCard> arrayList2 = new ArrayList<>();
        for (int i10 = 0; i10 < 100; i10++) {
            arrayList2.add(new RecommendCard());
        }
        setFixedPosition(arrayList, arrayList2);
        fillEmptyCards(str, arrayList, arrayList2);
        delEmptyCards(str, arrayList2);
        if (arrayList2.size() > 0) {
            return arrayList2;
        }
        return null;
    }

    private RecommendCard getTwoHundredGuidObject(String str, String str2, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        CommonCard twoHundredGuidObjectByActivityId = HiCloudSceneBannerManager.getInstance().getTwoHundredGuidObjectByActivityId(str, str2);
        if (twoHundredGuidObjectByActivityId == null) {
            reportError(linkedHashMap, "twoHundredGuid is null");
            return null;
        }
        BasicConfig basicConfig = twoHundredGuidObjectByActivityId.getBasicConfig();
        if (!isSatisfiedBasicConfigWithoutOwnerUser(basicConfig, linkedHashMap)) {
            return null;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = twoHundredGuidObjectByActivityId.getNotifyTypeAndUriGoto();
        boolean zEquals = RecommendCardConstants.Entrance.HOMEPAGE.equals(str);
        String title1201 = zEquals ? twoHundredGuidObjectByActivityId.getTitle1201() : twoHundredGuidObjectByActivityId.getTitle();
        String remark1201 = zEquals ? twoHundredGuidObjectByActivityId.getRemark1201() : twoHundredGuidObjectByActivityId.getRemark();
        String button1201 = zEquals ? twoHundredGuidObjectByActivityId.getButton1201() : twoHundredGuidObjectByActivityId.getButton();
        String description1201 = zEquals ? twoHundredGuidObjectByActivityId.getDescription1201() : twoHundredGuidObjectByActivityId.getDescription();
        String notifyBarTitle = twoHundredGuidObjectByActivityId.getNotifyBarTitle();
        String notifyBarDescription = twoHundredGuidObjectByActivityId.getNotifyBarDescription();
        RecommendCard sceneBannerObject = zEquals ? getSceneBannerObject(str, str2, basicConfig, "", "", notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, true, getPicturePath(twoHundredGuidObjectByActivityId.getPicturesSecond())) : getSceneBannerObject(str, str2, basicConfig, getPicturePath(twoHundredGuidObjectByActivityId.getPictures(), true), getPicturePath(twoHundredGuidObjectByActivityId.getPictures(), false), notifyTypeAndUriGoto, title1201, remark1201, button1201, description1201, notifyBarTitle, notifyBarDescription, linkedHashMap, false, "");
        if (sceneBannerObject == null) {
            NotifyLogger.m29914e(TAG, "tempTwoHundredGuidObject is null, activityId: " + str2);
            return null;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return null;
        }
        if (spaceProxy.isSatisfiedTwoHundredGuid(z10, linkedHashMap)) {
            return sceneBannerObject;
        }
        return null;
    }

    private RecommendCard getTwoHundredGuidObjectWithException(String str, String str2, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getTwoHundredGuidObject(str, str2, z10, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getTwoHundredGuidObject exception: " + e10.toString());
            return null;
        }
    }

    private boolean isGeneralAlbumOn(ICloudSpaceProxy iCloudSpaceProxy) {
        return iCloudSpaceProxy.isGeneralAlbumOnBySp();
    }

    private boolean isKaValid(Context context, String str, int i10, String str2) throws PackageManager.NameNotFoundException {
        boolean zCheckKaVersion = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int iM1685c = C0241z.m1685c(str2);
        boolean z10 = false;
        if (context == null) {
            NotifyLogger.m29916w(TAG, "context is null");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            if (packageInfo != null) {
                int i11 = packageInfo.versionCode;
                NotifyLogger.m29915i(TAG, str + " localVesrion: " + i11);
                if (!TextUtils.isEmpty(str2)) {
                    zCheckKaVersion = checkKaVersion(i10, iM1685c, false, i11);
                }
            } else {
                zCheckKaVersion = false;
            }
            z10 = zCheckKaVersion;
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            NotifyLogger.m29914e(TAG, "checkKaVersion exception." + e10.toString() + str);
        }
        NotifyLogger.m29913d(TAG, "checkKaVersion result:" + z10);
        return z10;
    }

    public static boolean isOpenGallerySwitchBannerShouldShow(String[] strArr) {
        for (String str : strArr) {
            if (str.contains(DevConditionsConstants.BANNER_OPEN_GALLERY)) {
                try {
                    int iOptInt = new JSONObject(str).optInt(DevConditionsConstants.BANNER_OPEN_GALLERY, -1);
                    ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
                    if (spaceProxy == null) {
                        NotifyLogger.m29914e(TAG, "spaceProxy is null");
                        return false;
                    }
                    boolean zIsGeneralAlbumOnBySp = spaceProxy.isGeneralAlbumOnBySp();
                    NotifyLogger.m29915i(TAG, "isConditionAllow isGeneralAlbumOnBySp: " + zIsGeneralAlbumOnBySp);
                    if (!zIsGeneralAlbumOnBySp) {
                        return iOptInt == 0 && C0209d.m1166E1();
                    }
                } catch (JSONException unused) {
                    NotifyLogger.m29914e(TAG, "isConditionAllow JSONException");
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isSatisfiedBasicConfig(BasicConfig basicConfig, LinkedHashMap<String, String> linkedHashMap) {
        if (C0209d.m1166E1()) {
            return isSatisfiedBasicConfigWithoutOwnerUser(basicConfig, linkedHashMap);
        }
        NotifyLogger.m29916w(TAG, "not owner");
        return false;
    }

    private boolean isSatisfiedBasicConfigWithoutOwnerUser(BasicConfig basicConfig, LinkedHashMap<String, String> linkedHashMap) {
        if (basicConfig == null) {
            NotifyLogger.m29914e(TAG, "basicConfig is null");
            return false;
        }
        if (C0209d.m1173G1(C0213f.m1377a())) {
            NotifyLogger.m29916w(TAG, "privacy user");
            return false;
        }
        if (C0209d.m1203Q1(C0213f.m1377a())) {
            return isSatisfiedRomAndTag(basicConfig.getrVersions(), basicConfig.getUserGroupExtIDs(), linkedHashMap, false, false);
        }
        NotifyLogger.m29916w(TAG, "OOBE not finish");
        return false;
    }

    private boolean isSatisfiedRomAndTag(RomVersion[] romVersionArr, String[] strArr, LinkedHashMap<String, String> linkedHashMap, boolean z10, boolean z11) {
        if (!isRomVersionInRange(romVersionArr)) {
            NotifyLogger.m29916w(TAG, "rom version not in range");
            linkedHashMap.put("recommend_card_info", "rom version not in range");
            getInstance().reportRecommendCardShowInfo(linkedHashMap);
            return false;
        }
        if (isUserTagInRange(strArr, z10, z11)) {
            return true;
        }
        NotifyLogger.m29916w(TAG, "user tag not in range");
        linkedHashMap.put("recommend_card_info", "user tag not in range");
        getInstance().reportRecommendCardShowInfo(linkedHashMap);
        return false;
    }

    private boolean isSceneBannerAlreadyExist(String str, ArrayList<RecommendCard> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z10 = str.equals(RecommendCardConstants.ActivityType.INCENTIVE) || str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE) || str.equals(RecommendCardConstants.ActivityType.TWO_HUNDRED_GUID) || str.equals(RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE);
        boolean z11 = str.equals(RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR) || str.equals(RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER) || str.equals(RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL);
        if (!z10 && !z11) {
            return false;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            RecommendCard recommendCard = arrayList.get(i10);
            if (recommendCard != null) {
                String activityType = recommendCard.getActivityType();
                if (!TextUtils.isEmpty(activityType) && activityType.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean lambda$getPicturePath$0(boolean z10, CommonPicture commonPicture) {
        return commonPicture.getResolution().equals(z10 ? RecommendCardConstants.Resolution.PHONE_LANDSCAPE : RecommendCardConstants.Resolution.PHONE_PORTRAIT);
    }

    public static /* synthetic */ String lambda$getPicturePath$1(CommonPicture commonPicture) {
        return getInstance().getPicturePathFromSp(commonPicture.getUrl());
    }

    public static /* synthetic */ boolean lambda$getPicturePath$2(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static /* synthetic */ String lambda$getPicturePath$3(String str) {
        return new File(str).exists() ? str : "";
    }

    private void loadAds(String str) throws InterruptedException {
        Map<String, List<INativeAd>> map = this.adsMap.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.adsMap.put(str, map);
            NotifyLogger.m29915i(TAG, "loadAds, entrance is " + str);
        }
        if (map.values().size() > 0) {
            NotifyLogger.m29915i(TAG, str + " AdsLoaded");
            return;
        }
        if (this.homeAdsLoaded && str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            NotifyLogger.m29915i(TAG, "homeAdsLoaded");
            return;
        }
        if (this.buyAdsLoaded && str.equals(RecommendCardConstants.Entrance.BUY)) {
            NotifyLogger.m29915i(TAG, "buyAdsLoaded");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean zAwait = false;
        C12515a.m75110o().m75175e(new InitFocusAdloaderTask(C0213f.m1377a(), str, countDownLatch), false);
        try {
            zAwait = countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            NotifyLogger.m29914e(TAG, "loadAdsTask  exception:" + e10.toString());
        }
        NotifyLogger.m29915i(TAG, "loadAdsTask Result:" + zAwait);
        setAdLoaded(str, true);
        downLoadAdsPicture(this.adsMap.get(str), str);
    }

    public void replaceCardText(ArrayList<RecommendCard> arrayList) {
        NotifyLogger.m29915i(TAG, "replaceCardText, enter");
        if (AbstractC14026a.m84159a(arrayList)) {
            NotifyLogger.m29915i(TAG, "replaceCardText, homepageRecommendCards is empty");
            return;
        }
        Iterator<RecommendCard> it = arrayList.iterator();
        while (it.hasNext()) {
            RecommendCard next = it.next();
            String remark = next.getRemark();
            String description = next.getDescription();
            String strReplaceParams = CloudSpaceNotifyUtil.getInstance().replaceParams(remark, "HOME_BANNER");
            if (TextUtils.isEmpty(remark) || !TextUtils.isEmpty(strReplaceParams)) {
                next.setRemark(strReplaceParams);
                String strReplaceParams2 = CloudSpaceNotifyUtil.getInstance().replaceParams(description, "HOME_BANNER");
                if (TextUtils.isEmpty(description) || !TextUtils.isEmpty(strReplaceParams2)) {
                    next.setDescription(strReplaceParams2);
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    private String replaceCleanLocalPlaceholder(String str, long j10) {
        return TextUtils.isEmpty(str) ? "" : C0209d.m1298q2(str, j10, true);
    }

    private String replaceCloudSpaceFullPlaceholder(ICloudSpaceProxy iCloudSpaceProxy, String str, long j10, long j11, long j12) {
        Context contextM1377a;
        if (TextUtils.isEmpty(str) || (contextM1377a = C0213f.m1377a()) == null) {
            return "";
        }
        try {
            String spaceForMain = iCloudSpaceProxy.formatSpaceForMain(contextM1377a, j10);
            String spaceForMain2 = iCloudSpaceProxy.formatSpaceForMain(contextM1377a, j11);
            String spaceForMain3 = iCloudSpaceProxy.formatSpaceForMain(contextM1377a, j12);
            if (!TextUtils.isEmpty(spaceForMain) && !TextUtils.isEmpty(spaceForMain2) && !TextUtils.isEmpty(spaceForMain3)) {
                return str.replaceAll("\\$\\$Used", spaceForMain).replaceAll("\\$\\$Cap", spaceForMain2).replaceAll("\\$\\$Oversize", spaceForMain3);
            }
            NotifyLogger.m29914e(TAG, "usedStr or totalStr or overSizeStr is empty");
            return "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "replaceCloudSpaceFullPlaceholder exception: " + e10.toString());
            return "";
        }
    }

    private String replaceGalleryPlaceholder(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return "";
        }
        try {
            String shortFileSize = Formatter.formatShortFileSize(contextM1377a, j10);
            if (!TextUtils.isEmpty(shortFileSize)) {
                return str.replaceAll("\\$\\$Cap", shortFileSize);
            }
            NotifyLogger.m29914e(TAG, "cap is empty");
            return "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "replaceGalleryPlaceholder exception: " + e10.toString());
            return "";
        }
    }

    private void reportError(LinkedHashMap<String, String> linkedHashMap, String str) {
        NotifyLogger.m29914e(TAG, str);
        linkedHashMap.put("recommend_card_info", str);
        getInstance().reportRecommendCardShowInfo(linkedHashMap);
    }

    private void reportRecommendCardUnsatisfied(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3) || this.unsatisfiedKeySet.contains(str3)) {
                return;
            } else {
                this.unsatisfiedKeySet.add(str3);
            }
        } else if (this.unsatisfiedKeySet.contains(str2)) {
            return;
        } else {
            this.unsatisfiedKeySet.add(str2);
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy != null) {
            spaceProxy.reportRecommendCardUnsatisfied(str, str2, str3);
        }
    }

    public void sendNotification(String str, ArrayList<RecommendCard> arrayList) {
        if (!checkEntrance(str) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        if (!NoticeFreqControlManager.getInstance().canShowNotice()) {
            NotifyLogger.m29916w(TAG, "freq control check fail, notice type: all_recommend_notice");
            NoticeFreqControlManager.getInstance().reportFreqControlled(NotifyConstants.TYPE_RECOMMEND_NOTICE);
            return;
        }
        NotifyLogger.m29915i(TAG, "sendNotification, entrance: " + str);
        C12515a.m75110o().m75175e(new SendNotificationTask(str, arrayList), false);
    }

    private void setFixedPosition(ArrayList<RecommendCard> arrayList, ArrayList<RecommendCard> arrayList2) {
        int i10 = 0;
        while (i10 < arrayList.size()) {
            RecommendCard recommendCard = arrayList.get(i10);
            if (recommendCard == null) {
                NotifyLogger.m29914e(TAG, "card is null");
            } else {
                int priority = recommendCard.getPriority();
                if (priority > 100) {
                    NotifyLogger.m29914e(TAG, "priority more than MAX");
                } else if (recommendCard.isFixed()) {
                    NotifyLogger.m29915i(TAG, "fixed priority: " + priority + ", activityId: " + recommendCard.getActivityId() + ", activityType: " + recommendCard.getActivityType());
                    arrayList2.set(priority + (-1), arrayList.get(i10));
                    arrayList.remove(i10);
                    i10 += -1;
                }
            }
            i10++;
        }
    }

    private void setHomePageRecommendCardsToCache(ArrayList<RecommendCard> arrayList, boolean z10) {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.manager.RecommendCardManager.2
            final /* synthetic */ boolean val$isFromRefreshTask;
            final /* synthetic */ ArrayList val$recommendCards;
            final /* synthetic */ ArrayList val$tempRecommendCards;

            public C49372(boolean z102, ArrayList arrayList2, ArrayList arrayList3) {
                z = z102;
                arrayList = arrayList2;
                arrayList = arrayList3;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                try {
                    if (z) {
                        RecommendCardManager.this.sendNotification(RecommendCardConstants.Entrance.HOMEPAGE, arrayList);
                        return;
                    }
                    C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME);
                    RecommendCardManager.this.replaceCardText(arrayList);
                    RecommendCardManager.this.homepageRecommendCards = new ArrayList<>(arrayList);
                    int size = arrayList.size();
                    NotifyLogger.m29915i(RecommendCardManager.TAG, "set homepage sp num: " + size);
                    RecommendCardManager.this.setCardsNumToSp(size);
                    RecommendCardManager.this.setCardsLanguageToSp(C0234s.m1636n());
                    for (int i10 = 0; i10 < size; i10++) {
                        RecommendCard recommendCard = (RecommendCard) arrayList.get(i10);
                        if (recommendCard != null) {
                            RecommendCardManager.this.setPictureSecondPathToSp(i10, recommendCard.getPictureSecondPath());
                            RecommendCardManager.this.setRemarkToSp(i10, recommendCard.getRemark());
                            RecommendCardManager.this.setButtonToSp(i10, recommendCard.getButton());
                            NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
                            if (notifyTypeAndUriGoto != null) {
                                RecommendCardManager.this.setNotifyTypeToSp(i10, notifyTypeAndUriGoto.getNotifyType());
                                RecommendCardManager.this.setNotifyUriToSp(i10, notifyTypeAndUriGoto.getNotifyUri());
                            }
                            int priority = recommendCard.getPriority();
                            RecommendCardManager.this.setPriorityToSp(i10, priority);
                            boolean zIsFixed = recommendCard.isFixed();
                            RecommendCardManager.this.setFixedToSp(i10, zIsFixed);
                            String activityId = recommendCard.getActivityId();
                            RecommendCardManager.this.setActivityIdToSp(i10, activityId);
                            String activityType = recommendCard.getActivityType();
                            RecommendCardManager.this.setActivityTypeToSp(i10, activityType);
                            NotifyLogger.m29915i(RecommendCardManager.TAG, "set homepage sp index: " + i10 + ", activityId: " + activityId + ", activityType: " + activityType + ", galleryReleaseActivityType: " + recommendCard.getGalleryReleaseActivityType() + ", priority: " + priority + ", fixed: " + zIsFixed);
                            RecommendCardManager.this.setDescriptionToSp(i10, recommendCard.getDescription());
                            RecommendCardManager.this.setDescriptionEndLinkToSp(i10, recommendCard.getDescriptionEndLink());
                        }
                    }
                    RecommendCardManager.this.sendRefreshCardFinishBroadcast(RecommendCardConstants.Entrance.HOMEPAGE);
                    RecommendCardManager.this.sendNotification(RecommendCardConstants.Entrance.HOMEPAGE, arrayList);
                } catch (Exception e10) {
                    NotifyLogger.m29914e(RecommendCardManager.TAG, "set homepage sp error: " + e10);
                }
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public AbstractRunnableC12516b.a getEnum() {
                return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
            }
        }, false);
    }

    public void setRecommendCardsAndNpsToCache(String str, ArrayList<RecommendCard> arrayList, boolean z10, boolean z11, int i10) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        while (arrayList.size() > i10) {
            arrayList.remove(arrayList.size() - 1);
        }
        RecommendCard npsRecommandCards = getNpsRecommandCards(str);
        if (npsRecommandCards != null) {
            NotifyLogger.m29915i(TAG, "npsCard not null");
            arrayList.add(npsRecommandCards);
        } else {
            NotifyLogger.m29915i(TAG, "npsCard is null");
        }
        setRecommendCardsToCache(str, arrayList, z10, z11);
    }

    private void setRecommendCardsToCache(String str, ArrayList<RecommendCard> arrayList, boolean z10, boolean z11) {
        if (checkEntrance(str)) {
            if (arrayList == null || arrayList.size() == 0) {
                if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                    NotifyLogger.m29916w(TAG, "save homepage card is empty");
                    this.homepageRecommendCards.clear();
                    C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME);
                    sendRefreshCardFinishBroadcast(RecommendCardConstants.Entrance.HOMEPAGE);
                    return;
                }
                if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                    NotifyLogger.m29916w(TAG, "save buy card is empty");
                    this.buyRecommendCards.clear();
                    sendRefreshCardFinishBroadcast(RecommendCardConstants.Entrance.BUY);
                    return;
                }
                return;
            }
            ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
            if (spaceProxy != null) {
                spaceProxy.reportRecommendCardShowEvent(arrayList, z11);
            }
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                setHomePageRecommendCardsToCache(arrayList, z10);
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                this.buyRecommendCards = new ArrayList<>(arrayList);
                showBuyRecommendCards(arrayList);
                sendRefreshCardFinishBroadcast(RecommendCardConstants.Entrance.BUY);
                sendNotification(RecommendCardConstants.Entrance.BUY, arrayList);
            }
        }
    }

    private void showBuyRecommendCards(ArrayList<RecommendCard> arrayList) {
        C12515a.m75110o().m75175e(new ShowBuyRecommendCardsTask(arrayList), false);
    }

    public boolean checkEntrance(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.equals(RecommendCardConstants.Entrance.HOMEPAGE) || str.equals(RecommendCardConstants.Entrance.BUY) || str.equals("manage") || str.equals(RecommendCardConstants.Entrance.DESKTOP_DIALOG);
        }
        NotifyLogger.m29914e(TAG, "entrance is empty");
        return false;
    }

    public boolean checkGetConfigParam(String str) {
        if (!getInstance().checkEntrance(str)) {
            return false;
        }
        if (!C13452e.m80781L().m80842P0()) {
            NotifyLogger.m29915i(TAG, "not login");
            return false;
        }
        if (C0209d.m1333z1(C0213f.m1377a())) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "no notwork connected");
        return false;
    }

    public boolean checkLanguageParam(CommonLanguage commonLanguage, String str) {
        if (!getInstance().checkEntrance(str)) {
            return false;
        }
        if (commonLanguage == null) {
            NotifyLogger.m29914e(TAG, "language is null");
            return false;
        }
        String url = commonLanguage.getUrl();
        String hash = commonLanguage.getHash();
        if (TextUtils.isEmpty(url)) {
            NotifyLogger.m29914e(TAG, "url is empty");
            return false;
        }
        if (!URLUtil.isHttpsUrl(url)) {
            NotifyLogger.m29914e(TAG, "url is not https");
            return false;
        }
        if (!TextUtils.isEmpty(hash)) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "hash is empty");
        return false;
    }

    public void clear() {
        this.homepageRecommendCards.clear();
        this.buyRecommendCards.clear();
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME);
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME);
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME);
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.BUY_TIME_FILE_NAME);
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.PICTURE_CACHE_FILE_NAME);
        C0212e0.m1353c(RecommendCardConstants.C4910Sp.HOMEPAGE_NOTIFICATION_TIME_FILE_NAME);
        deletePictures();
        clearPpsPicturePathFromSp(true);
    }

    public void clearAds(String str) {
        this.adsMap.remove(str);
    }

    public void clearFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            NotifyLogger.m29914e(TAG, "picture file delete fail");
        }
    }

    public void clearNotification(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29916w(TAG, "clearNotification activityType is empty");
            return;
        }
        Integer num = (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY.equals(str2) || TextUtils.isEmpty(str)) ? this.notifyIdMap.get(str2) : this.notifyIdMap.get(str);
        NotifyLogger.m29915i(TAG, "clearNotification, notifyId: " + num + ", activityId: " + str + ", activityType: " + str2);
        if (num == null) {
            NotifyLogger.m29916w(TAG, "no notifyId");
            return;
        }
        int iIntValue = num.intValue();
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
        } else {
            spaceProxy.clearRecommendCardsNotification(iIntValue);
        }
    }

    public void clearPpsPicturePathFromSp(boolean z10) {
        File file = new File(getPpsPicturePath());
        if (file.exists()) {
            if (C10278a.m63440f(file).length < 50 && !z10) {
                NotifyLogger.m29915i(TAG, "no need clear pps cache Picture");
                return;
            }
            NotifyLogger.m29915i(TAG, "clear pps cache Picture");
            deletePictures(getPpsPicturePath());
            C0212e0.m1353c(RecommendCardConstants.C4910Sp.PPS_PICTURES_CACHE);
        }
    }

    public void closeIn(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                NotifyLogger.m29914e(TAG, "closeIn exception: " + e10.toString());
            }
        }
    }

    public void downloadPicture(CommonPicture commonPicture) throws InterruptedException {
        if (commonPicture == null) {
            NotifyLogger.m29914e(TAG, "picture is null");
            return;
        }
        String url = commonPicture.getUrl();
        String hash = commonPicture.getHash();
        if (commonPicture.checkPictureParam()) {
            String picturePathFromSp = getPicturePathFromSp(url);
            if (TextUtils.isEmpty(picturePathFromSp)) {
                picturePathFromSp = generatePicturePath(url);
            }
            if (TextUtils.isEmpty(picturePathFromSp)) {
                NotifyLogger.m29914e(TAG, "picturePath is empty");
                return;
            }
            try {
                if (new File(picturePathFromSp).exists()) {
                    if (hash.equals(C0227m.m1591d(picturePathFromSp))) {
                        return;
                    }
                }
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "getFileSHA256Str exception: " + e10.toString());
            }
            clearFile(picturePathFromSp);
            C4896a c4896a = new C4896a(url, picturePathFromSp, 0L);
            for (int i10 = 0; i10 <= 2; i10++) {
                try {
                    NotifyUtil.downloadFileToPath(picturePathFromSp, c4896a.getUrl(), c4896a);
                } catch (C9721b e11) {
                    NotifyLogger.m29914e(TAG, "download picture exception: " + e11.toString());
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e12) {
                        NotifyLogger.m29914e(TAG, "download picture sleep exception: " + e12.toString());
                    }
                }
                if (new File(picturePathFromSp).exists()) {
                    if (hash.equals(C0227m.m1591d(picturePathFromSp))) {
                        setPicturePathToSp(url, picturePathFromSp);
                    } else {
                        NotifyLogger.m29914e(TAG, "picture hash not equal");
                        clearFile(picturePathFromSp);
                    }
                    return;
                }
                continue;
            }
        }
    }

    public void downloadPpsPicture(CommonPicture commonPicture, String str) throws InterruptedException {
        if (commonPicture == null) {
            NotifyLogger.m29914e(TAG, "picture is null");
            return;
        }
        if (commonPicture.checkPictureParam()) {
            String url = commonPicture.getUrl();
            String hash = commonPicture.getHash();
            String ppsPicturePathFromSp = getPpsPicturePathFromSp(url, str);
            if (TextUtils.isEmpty(ppsPicturePathFromSp)) {
                ppsPicturePathFromSp = generatePpsPicturePath(url);
            }
            if (TextUtils.isEmpty(ppsPicturePathFromSp)) {
                NotifyLogger.m29914e(TAG, "picturePath is empty");
                return;
            }
            try {
                if (new File(ppsPicturePathFromSp).exists()) {
                    if (hash.equals(C0227m.m1591d(ppsPicturePathFromSp))) {
                        return;
                    }
                }
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "getFileSHA256Str exception: " + e10.toString());
            }
            clearFile(ppsPicturePathFromSp);
            C4896a c4896a = new C4896a(url, ppsPicturePathFromSp, 0L);
            for (int i10 = 0; i10 <= 2; i10++) {
                try {
                    NotifyUtil.downloadFileToPath(ppsPicturePathFromSp, c4896a.getUrl(), c4896a);
                } catch (C9721b e11) {
                    NotifyLogger.m29914e(TAG, "download picture exception: " + e11.toString());
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e12) {
                        NotifyLogger.m29914e(TAG, "download picture sleep exception: " + e12.toString());
                    }
                }
                if (new File(ppsPicturePathFromSp).exists()) {
                    if (hash.equals(C0227m.m1591d(ppsPicturePathFromSp))) {
                        setPpsPicturePathToSp(url, ppsPicturePathFromSp);
                    } else {
                        NotifyLogger.m29914e(TAG, "picture hash not equal");
                        clearFile(ppsPicturePathFromSp);
                    }
                    return;
                }
                continue;
            }
        }
    }

    public String generatePicturePath(String str) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "url is empty");
            return "";
        }
        int iNextInt = this.pictureNameRand.nextInt(10000);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(RecommendCardConstants.PictureFileName.FOLDER);
        sb2.append(str2);
        sb2.append(str.hashCode());
        sb2.append(iNextInt);
        sb2.append(jCurrentTimeMillis);
        return sb2.toString();
    }

    public String generatePpsPicturePath(String str) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "url is empty");
            return "";
        }
        int iNextInt = this.pictureNameRand.nextInt(10000);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(RecommendCardConstants.PictureFileName.PPS_FOLDER);
        sb2.append(str2);
        sb2.append(str.hashCode());
        sb2.append(iNextInt);
        sb2.append(jCurrentTimeMillis);
        return sb2.toString();
    }

    public String getActivityIdFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.ACTIVITY_ID + i10, "");
    }

    public String getActivityTypeFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.ACTIVITY_TYPE + i10, "");
    }

    public INativeAd getAd(String str, String str2) {
        List<INativeAd> list;
        if (!this.adsMap.containsKey(str) || (list = this.adsMap.get(str).get(str2)) == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public String[] getBatchInsertArgs(CommonLanguageDbString commonLanguageDbString) {
        return new String[]{commonLanguageDbString.getLanguage(), commonLanguageDbString.getName(), commonLanguageDbString.getValue()};
    }

    public String getButtonFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.BUTTON + i10, "");
    }

    public String getCTypeFromSp() {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.C_TYPE, "");
    }

    public int getCanBeDisplayedNum(String str, boolean z10) {
        if (z10) {
            return 100;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            return 7;
        }
        int homepageBannerNum = str.equals(RecommendCardConstants.Entrance.HOMEPAGE) ? hiCloudSysParamMapM60757p.getHomepageBannerNum() : str.equals(RecommendCardConstants.Entrance.BUY) ? hiCloudSysParamMapM60757p.getCloudSpaceBannerV2Limit() : 7;
        if (homepageBannerNum <= 0) {
            return 7;
        }
        if (homepageBannerNum > 10) {
            return 10;
        }
        return homepageBannerNum;
    }

    public int getCardRefreshFromSp(int i10) {
        return C0212e0.m1358h(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.CARD_REFRESH + i10, 0);
    }

    public String getCardsLanguageFromSp() {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.LANGUAGE, "");
    }

    public int getCardsNumFromSp() {
        return C0212e0.m1358h(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, "num", 0);
    }

    public void getConfigFromOM(String str) {
        if (checkEntrance(str)) {
            NotifyLogger.m29915i(TAG, "getConfigFromOM entrance: " + str);
            HiCloudBrandBannerManager.getInstance().getConfigFromOM(str);
            HiCloudSceneBannerManager.getInstance().getConfigFromOM(str);
            HiCloudSpacePositionMgrManager.getInstance().getConfigFromOM();
            C12515a.m75110o().m75172d(new QueryHiCloudH5ConfigTask());
        }
    }

    public int getCurrentNotifyId(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE)) {
                return 371;
            }
            if (str.equals(RecommendCardConstants.ActivityType.TWO_HUNDRED_GUID)) {
                return 372;
            }
            if (str.equals(RecommendCardConstants.ActivityType.CLOUD_BACKUP_CLEAR)) {
                return 394;
            }
            if (str.equals(RecommendCardConstants.ActivityType.CLEAR_LOCAL_SPACE)) {
                return 374;
            }
            if (str.equals(RecommendCardConstants.ActivityType.CLOUD_SPACE_FULL)) {
                return 393;
            }
            if (str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN)) {
                return 400;
            }
            if (str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE)) {
                return 401;
            }
            if (str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY)) {
                return 402;
            }
            if (str.equals(RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY)) {
                return 403;
            }
        }
        int i10 = this.currentNotifyId;
        if (i10 == 370) {
            this.currentNotifyId = 307;
        } else {
            this.currentNotifyId = i10 + 1;
        }
        return this.currentNotifyId;
    }

    public float getCurrentProportion() {
        return (C0209d.m1297q1(C0213f.m1377a()) || C0209d.m1170F1() || C0209d.m1249e1() || C0209d.m1237b1(C0213f.m1377a())) ? 0.1587936f : 0.33307928f;
    }

    public int getCurrentRequestCode() {
        int i10 = this.currentRequestCode;
        if (i10 == 49) {
            this.currentRequestCode = 10;
        } else {
            this.currentRequestCode = i10 + 1;
        }
        return this.currentRequestCode;
    }

    public String getDescriptionEndLinkFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.DESCRIPTION_END_LINK + i10, "");
    }

    public String getDescriptionFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.DESCRIPTION + i10, "");
    }

    public long getFirstShowTimeFromSp(String str, String str2) {
        long jM1360j = 0;
        if (!checkEntrance(str)) {
            return 0L;
        }
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.FIRST_SHOW_TIME + str2, 0L);
        } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.BUY_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.FIRST_SHOW_TIME + str2, 0L);
        }
        NotifyLogger.m29915i(TAG, "getFirstShowTimeFromSp, entrance: " + str + ", activityId: " + str2 + ", firstShowTime: " + jM1360j);
        return jM1360j;
    }

    public boolean getFixedFromSp(int i10) {
        return C0212e0.m1355e(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.FIXED + i10, false);
    }

    public String getH5JumpUrlFromSp() {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.H5_JUMP_URL, "");
    }

    public ArrayList<RecommendCard> getHomePageRecommendCardsFromCache(Handler handler) {
        NotifyLogger.m29915i(TAG, "getHomePageRecommendCardsFromCache with handler");
        ArrayList<RecommendCard> arrayList = this.homepageRecommendCards;
        if (arrayList != null && arrayList.size() > 0) {
            NotifyLogger.m29915i(TAG, "getHomePageRecommendCardsFromCache return homepageRecommendCards");
            return this.homepageRecommendCards;
        }
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.manager.RecommendCardManager.1
            final /* synthetic */ Handler val$handler;

            public C49361(Handler handler2) {
                handler = handler2;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                NotifyLogger.m29915i(RecommendCardManager.TAG, "call getHomeRecommendCardsFromCache");
                ArrayList homeRecommendCardsFromCache = RecommendCardManager.this.getHomeRecommendCardsFromCache();
                if (homeRecommendCardsFromCache == null || homeRecommendCardsFromCache.size() == 0) {
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 9007;
                messageObtain.obj = Boolean.TRUE;
                handler.sendMessage(messageObtain);
                NotifyLogger.m29915i(RecommendCardManager.TAG, "send refresh message");
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public AbstractRunnableC12516b.a getEnum() {
                return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD;
            }
        }, false);
        return new ArrayList<>(0);
    }

    public ActivityEntryEx getIncentiveCardActivityEntryEx(String str, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        if (!checkEntrance(str)) {
            return null;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy != null) {
            return spaceProxy.getIncentiveCardActivityEntryEx(str, z10, linkedHashMap);
        }
        NotifyLogger.m29914e(TAG, "spaceProxy is null");
        return null;
    }

    public RecommendCard getIncentiveObjectWithException(String str, ActivityEntryEx activityEntryEx, LinkedHashMap<String, String> linkedHashMap) {
        try {
            return getIncentiveObject(str, activityEntryEx, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getIncentiveObject exception: " + e10.toString());
            return null;
        }
    }

    public String getLandscapePicturePathFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.LANDSCAPE_PICTURE_PATH + i10, "");
    }

    public long getLastIncentiveTimeFromSp() {
        long jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_INCENTIVE_TIME, 0L);
        NotifyLogger.m29913d(TAG, "getLastIncentiveTimeFromSp: " + jM1360j);
        return jM1360j;
    }

    public long getLastNotifyTimeFromNotificationSp(String str, String str2, String str3) {
        long jM1360j;
        boolean z10;
        if (!checkEntrance(str)) {
            return 0L;
        }
        if (TextUtils.isEmpty(str2)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_NOTIFICATION_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, 0L);
        } else if (TextUtils.isEmpty(str3)) {
            jM1360j = 0;
        } else {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_NOTIFICATION_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str2, 0L);
        }
        if (jM1360j == 0) {
            z10 = true;
            if (TextUtils.isEmpty(str2)) {
                jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, 0L);
            } else if (!TextUtils.isEmpty(str3)) {
                jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str2, 0L);
            }
        } else {
            z10 = false;
        }
        if (z10 && jM1360j != 0) {
            NotifyLogger.m29915i(TAG, "need set notify time to sp");
            setLastNotifyTimeToNotificationSp(str, str2, str3, jM1360j);
        }
        NotifyLogger.m29915i(TAG, "getLastNotifyTimeFromNotificationSp, entrance: " + str + ", activityId: " + str2 + ", activityType: " + str3 + ", lastNotifyTime: " + jM1360j);
        return jM1360j;
    }

    public long getLastNotifyTimeFromSp(String str, String str2, String str3) {
        long jM1360j = 0;
        if (!checkEntrance(str)) {
            return 0L;
        }
        if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(str3) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY.equals(str3)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3 + str, 0L);
        } else if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(str3) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN.equals(str3)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, 0L);
        } else if (TextUtils.isEmpty(str2)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, 0L);
        } else if (!TextUtils.isEmpty(str3)) {
            jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str2, 0L);
        }
        NotifyLogger.m29915i(TAG, "getLastNotifyTimeFromSp, entrance: " + str + ", activityId: " + str2 + ", activityType: " + str3 + ", lastNotifyTime: " + jM1360j);
        return jM1360j;
    }

    public long getLastTwoHundredGuidTimeFromSp() {
        long jM1360j = C0212e0.m1360j(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_TWO_HUNDRED_GUID_TIME, 0L);
        NotifyLogger.m29913d(TAG, "getLastTwoHundredGuidTimeFromSp: " + jM1360j);
        return jM1360j;
    }

    public String getNotifyBarDescriptionFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR_DESCRIPTION + i10, "");
    }

    public boolean getNotifyBarFromSp(int i10) {
        return C0212e0.m1355e(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR + i10, false);
    }

    public String getNotifyBarTitleFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR_TITLE + i10, "");
    }

    public String getNotifyTypeFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_TYPE + i10, "");
    }

    public String getNotifyUriFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_URI + i10, "");
    }

    public RecommendCard getNpsRecommandCards(String str) {
        if (!str.equals(RecommendCardConstants.Entrance.HOMEPAGE) || !NpsShowManager.getInstance().checkIsNeedShowNPSBanner(C0213f.m1377a())) {
            return null;
        }
        RecommendCard recommendCard = new RecommendCard();
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = new NotifyTypeAndUriGoto();
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL, "");
        notifyTypeAndUriGoto.setNotifyType("nps");
        notifyTypeAndUriGoto.setNotifyUri(strM1363m);
        recommendCard.setNotifyTypeAndUriGoto(notifyTypeAndUriGoto);
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return null;
        }
        String strM1363m2 = C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_REMARK_ID, "");
        if (TextUtils.isEmpty(strM1363m2)) {
            NotifyLogger.m29914e(TAG, "nps remark value is empty");
            return null;
        }
        String nPSStringFromDb = spaceProxy.getNPSStringFromDb(strM1363m2);
        if (TextUtils.isEmpty(nPSStringFromDb)) {
            NotifyLogger.m29914e(TAG, "nps remark key is empty");
            return null;
        }
        recommendCard.setRemark(nPSStringFromDb);
        String strM1363m3 = C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DESCRIPTION_ID, "");
        if (!TextUtils.isEmpty(strM1363m3)) {
            String nPSStringFromDb2 = spaceProxy.getNPSStringFromDb(strM1363m3);
            if (TextUtils.isEmpty(nPSStringFromDb2)) {
                NotifyLogger.m29916w(TAG, "nps description is empty");
            }
            recommendCard.setDescription(nPSStringFromDb2);
        }
        String strM1363m4 = C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_BUTTON_ID, "");
        if (!TextUtils.isEmpty(strM1363m4)) {
            String nPSStringFromDb3 = spaceProxy.getNPSStringFromDb(strM1363m4);
            if (TextUtils.isEmpty(nPSStringFromDb3)) {
                NotifyLogger.m29916w(TAG, "nps button is empty");
            }
            recommendCard.setButton(nPSStringFromDb3);
        }
        recommendCard.setPictureSecondPath(C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.PICTURE_CACHE_FILE_NAME, C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_BANNER_PICTURE_SECOND_URL, ""), ""));
        recommendCard.setEntrance(RecommendCardConstants.Entrance.HOMEPAGE);
        recommendCard.setActivityType("nps");
        return recommendCard;
    }

    public Bitmap getPictureBitmapUserCache(String str) {
        Bitmap bitmap;
        try {
            bitmap = this.pictureMap.get(str);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getPictureBitmapUserCache exception: " + e10.toString());
        }
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapM1311u = C0209d.m1311u(str);
        if (bitmapM1311u != null) {
            this.pictureMap.put(str, bitmapM1311u);
            return bitmapM1311u;
        }
        return C0209d.m1311u(str);
    }

    public String getPicturePath(CommonPicture[] commonPictureArr, final boolean z10) {
        return commonPictureArr == null ? "" : (String) Arrays.stream(commonPictureArr).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return RecommendCardManager.lambda$getPicturePath$0(z10, (CommonPicture) obj);
            }
        }).findFirst().map(new Function() { // from class: com.huawei.hicloud.notification.manager.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RecommendCardManager.lambda$getPicturePath$1((CommonPicture) obj);
            }
        }).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return RecommendCardManager.lambda$getPicturePath$2((String) obj);
            }
        }).map(new Function() { // from class: com.huawei.hicloud.notification.manager.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RecommendCardManager.lambda$getPicturePath$3((String) obj);
            }
        }).orElse("");
    }

    public String getPicturePathFromSp(String str) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.PICTURE_CACHE_FILE_NAME, str, "");
    }

    public String getPictureSecondPathFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PICTURE_SECOND_PATH + i10, "");
    }

    public String getPortraitPicturePathFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PORTRAIT_PICTURE_PATH + i10, "");
    }

    public String getPpsPicturePathFromSp(String str, String str2) {
        NotifyLogger.m29913d(TAG, "entrance: " + str2);
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.PPS_PICTURES_CACHE, str, "");
    }

    public int getPriorityFromSp(int i10) {
        return C0212e0.m1358h(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PRIORITY + i10, 0);
    }

    public ArrayList<RecommendCard> getRecommendCardsFromCache(String str) {
        NotifyLogger.m29915i(TAG, "getRecommendCardsFromCache");
        ArrayList<RecommendCard> arrayList = new ArrayList<>();
        if (!checkEntrance(str)) {
            return arrayList;
        }
        if (!str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            return str.equals(RecommendCardConstants.Entrance.BUY) ? this.buyRecommendCards : arrayList;
        }
        ArrayList<RecommendCard> arrayList2 = this.homepageRecommendCards;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return getHomeRecommendCardsFromCache();
        }
        NotifyLogger.m29915i(TAG, "getRecommendCardsFromCache return homepageRecommendCards");
        return this.homepageRecommendCards;
    }

    public String getRemarkFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.REMARK + i10, "");
    }

    public String getResourceIdFromSp() {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, "resource_id", "");
    }

    public String getSuitablePicturePath(String str, String str2) {
        float currentProportion = getCurrentProportion();
        return Math.abs(0.1587936f - currentProportion) < Math.abs(0.33307928f - currentProportion) ? str : str2;
    }

    public String getTitleFromSp(int i10) {
        return C0212e0.m1364n(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.TITLE + i10, "");
    }

    public int getTwoHundredGuidResultFromSp() {
        return C0212e0.m1358h(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.TWO_HUNDRED_GUID_RESULT, 0);
    }

    public void initLocalBroadCast() {
        C13108a c13108aM78878b = C13108a.m78878b(C0213f.m1377a());
        if (this.recommendReceiver == null) {
            this.recommendReceiver = new RecommendReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(RecommendCardConstants.ACTION_ALBUM_CHECK_SIZE_FINISH);
            c13108aM78878b.m78880c(this.recommendReceiver, intentFilter);
        }
    }

    public boolean isCurrentUserInUserGroupExtIds(String[] strArr) {
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return false;
        }
        List<PortraitAndGrade.UserTag> userTagList = spaceProxy.getUserTagList(TAG);
        if (AbstractC14026a.m84159a(userTagList)) {
            NotifyLogger.m29914e(TAG, "userTagList is null or empty.");
            return false;
        }
        for (PortraitAndGrade.UserTag userTag : userTagList) {
            if (userTag == null) {
                NotifyLogger.m29914e(TAG, "userTag is null");
            } else {
                String userGroupExtID = userTag.getUserGroupExtID();
                if (TextUtils.isEmpty(userGroupExtID)) {
                    NotifyLogger.m29914e(TAG, "tag is empty");
                } else {
                    for (String str : strArr) {
                        if (TextUtils.isEmpty(str)) {
                            NotifyLogger.m29914e(TAG, "omTag is empty");
                        } else if (str.equals(userGroupExtID)) {
                            NotifyLogger.m29915i(TAG, "match tag: " + str);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isFMVersionInRange(RomVersion[] romVersionArr) {
        if (romVersionArr == null || romVersionArr.length == 0) {
            return true;
        }
        String strM1680b = C0240y.m1680b(C0213f.m1377a(), NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        NotifyLogger.m29915i(TAG, "curFMVersion: " + strM1680b);
        int length = romVersionArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            RomVersion romVersion = romVersionArr[i10];
            if (romVersion == null) {
                NotifyLogger.m29914e(TAG, "version is null");
            } else {
                String min = romVersion.getMin();
                String max = romVersion.getMax();
                if (TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                    return true;
                }
                if (!TextUtils.isEmpty(min) && !TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1680b, max) >= 0 && C0209d.m1267j(strM1680b, max) <= 0;
                }
                if (!TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1680b, max) >= 0;
                }
                if (TextUtils.isEmpty(min) && !TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1680b, max) <= 0;
                }
            }
        }
        return false;
    }

    public boolean isPictureToBitmapSuccess(String str) {
        try {
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getPictureBitmapUserCache exception: " + e10.toString());
        }
        if (this.pictureMap.get(str) != null) {
            return true;
        }
        Bitmap bitmapM1311u = C0209d.m1311u(str);
        if (bitmapM1311u != null) {
            this.pictureMap.put(str, bitmapM1311u);
            return true;
        }
        NotifyLogger.m29916w(TAG, "pictureToBitmap failed!");
        return false;
    }

    public boolean isRomVersionInRange(RomVersion[] romVersionArr) {
        if (romVersionArr == null || romVersionArr.length == 0) {
            return true;
        }
        String strM1186L = C0209d.m1186L();
        NotifyLogger.m29915i(TAG, "curEmuiVersion: " + strM1186L);
        int length = romVersionArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            RomVersion romVersion = romVersionArr[i10];
            if (romVersion == null) {
                NotifyLogger.m29914e(TAG, "version is null");
            } else {
                String min = romVersion.getMin();
                String max = romVersion.getMax();
                if (TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                    return true;
                }
                if (!TextUtils.isEmpty(min) && !TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1186L, min) >= 0 && C0209d.m1267j(strM1186L, max) <= 0;
                }
                if (!TextUtils.isEmpty(min) && TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1186L, min) >= 0;
                }
                if (TextUtils.isEmpty(min) && !TextUtils.isEmpty(max)) {
                    return C0209d.m1267j(strM1186L, max) <= 0;
                }
            }
        }
        return false;
    }

    public boolean isShowKeySetHaveStr(String str, String str2, String str3) {
        String str4 = str3 + str2 + str;
        if (this.showKeySet.contains(str4)) {
            return true;
        }
        this.showKeySet.add(str4);
        return false;
    }

    public boolean isUserTagInRange(String[] strArr, boolean z10, boolean z11) {
        if (strArr == null || strArr.length == 0) {
            NotifyLogger.m29916w(TAG, "userGroupExtIDs is null");
            return true;
        }
        if (z11 || !z10 || AdSwitchManager.getInstance().canDisplayAd(NotifyConstants.CommonReportConstants.SRC_AD_SWITCH_RECOMMEND_CARD)) {
            return isCurrentUserInUserGroupExtIds(strArr);
        }
        NotifyLogger.m29916w(TAG, "can't display ad");
        return false;
    }

    public void recordNotifyId(int i10, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29916w(TAG, "recordNotifyId activityType is empty");
            return;
        }
        NotifyLogger.m29915i(TAG, "recordNotifyId, notifyId: " + i10 + ", activityId: " + str + ", activityType: " + str2);
        Integer numValueOf = Integer.valueOf(i10);
        if (RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(str2) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY.equals(str2)) {
            this.notifyIdMap.put(str2, numValueOf);
        } else if (TextUtils.isEmpty(str)) {
            this.notifyIdMap.put(str2, numValueOf);
        } else {
            this.notifyIdMap.put(str, numValueOf);
        }
    }

    public void refreshRecommendCards(String str, boolean z10, boolean z11) {
        NotifyLogger.m29915i(TAG, "refreshRecommendCards, entrance: " + str + ", isFromRefreshTask: " + z10);
        if (checkEntrance(str)) {
            if (C0209d.m1293p1()) {
                NotifyLogger.m29915i(TAG, "isInkScreen");
            } else {
                if (!C10028c.m62182c0().m62413x()) {
                    NotifyLogger.m29915i(TAG, "mItemSwitch is false");
                    return;
                }
                setAdLoaded(str, false);
                C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.hicloud.notification.manager.RecommendCardManager.3
                    final /* synthetic */ String val$entrance;
                    final /* synthetic */ boolean val$isFromDetailActivity;
                    final /* synthetic */ boolean val$isFromRefreshTask;

                    public C49383(String str2, boolean z112, boolean z102) {
                        str = str2;
                        z = z112;
                        z = z102;
                    }

                    @Override // p616rk.AbstractRunnableC12516b
                    public void call() {
                        try {
                            int canBeDisplayedNum = RecommendCardManager.this.getCanBeDisplayedNum(str, z);
                            BannerSpacePositionConfig configByEntrance = HiCloudSpacePositionMgrManager.getInstance().getConfigByEntrance(str);
                            if (configByEntrance == null) {
                                NotifyLogger.m29914e(RecommendCardManager.TAG, "bannerSpacePositionConfig is null");
                                RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                                return;
                            }
                            BannerSpacePositionConfigActivity[] activities = configByEntrance.getActivities();
                            if (activities == null) {
                                NotifyLogger.m29914e(RecommendCardManager.TAG, "activities is null");
                                RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                                return;
                            }
                            ArrayList canBeDisplayedCards = RecommendCardManager.this.getCanBeDisplayedCards(str, activities, z, z, canBeDisplayedNum);
                            if (canBeDisplayedCards.size() == 0) {
                                NotifyLogger.m29914e(RecommendCardManager.TAG, "canBeDisplayedCards data error");
                                RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                                return;
                            }
                            NotifyLogger.m29915i(RecommendCardManager.TAG, "canBeDisplayedCards size: " + canBeDisplayedCards.size());
                            ArrayList sortedRecommendCards = RecommendCardManager.this.getSortedRecommendCards(str, canBeDisplayedCards);
                            if (sortedRecommendCards != null && sortedRecommendCards.size() != 0) {
                                NotifyLogger.m29915i(RecommendCardManager.TAG, "sorted cards size: " + sortedRecommendCards.size());
                                RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, sortedRecommendCards, z, z, canBeDisplayedNum);
                                return;
                            }
                            NotifyLogger.m29914e(RecommendCardManager.TAG, "sorted cards empty");
                            RecommendCardManager.this.setRecommendCardsAndNpsToCache(str, null, z, z, canBeDisplayedNum);
                        } catch (Exception e10) {
                            NotifyLogger.m29914e(RecommendCardManager.TAG, "getRecommendCards exception: " + e10.toString());
                        }
                    }

                    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
                    public AbstractRunnableC12516b.a getEnum() {
                        return AbstractRunnableC12516b.a.SINGLE_RECOMMEND_CARD_REFRESH;
                    }
                }, false);
            }
        }
    }

    public void removeNpsRecommandCard(String str, boolean z10) {
        NotifyTypeAndUriGoto notifyTypeAndUriGoto;
        getRecommendCardsFromCache(str);
        ArrayList<RecommendCard> arrayList = this.homepageRecommendCards;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<RecommendCard> it = this.homepageRecommendCards.iterator();
        while (it.hasNext() && (notifyTypeAndUriGoto = it.next().getNotifyTypeAndUriGoto()) != null) {
            if (TextUtils.equals(notifyTypeAndUriGoto.getNotifyType(), "nps")) {
                it.remove();
                setRecommendCardsToCache(str, this.homepageRecommendCards, false, z10);
                return;
            }
        }
    }

    public void reportRecommendCardShowInfo(LinkedHashMap<String, String> linkedHashMap) {
        String str = linkedHashMap.get("recommend_card_activity_id");
        String str2 = linkedHashMap.get("recommend_card_activity_type");
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2) || this.showInfoKeySet.contains(str2)) {
                return;
            } else {
                this.showInfoKeySet.add(str2);
            }
        } else if (this.showInfoKeySet.contains(str)) {
            return;
        } else {
            this.showInfoKeySet.add(str);
        }
        try {
            C13227f.m79492i1().m79567R("recommend_card_banner_show_info", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "recommend_card_banner_show_info", "1", "66", linkedHashMap);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07038"), "07038", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B("recommend_card_banner_show_info");
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportRecommendCardShowInfo exception: " + e10.toString());
        }
    }

    public void reportRecommendCardShowInfoUserTag() {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07038"), "07038", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B("recommend_card_user_tag");
            linkedHashMap.put("userTag", C13452e.m80781L().m80979v0());
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportRecommendCardShowInfoUserTag exception: " + e10.toString());
        }
    }

    public void sendRefreshCardFinishBroadcast(String str) {
        if (checkEntrance(str)) {
            NotifyLogger.m29915i(TAG, "sendCardRefreshFinishBroadcast: " + str);
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                return;
            }
            Intent intent = str.equals(RecommendCardConstants.Entrance.HOMEPAGE) ? new Intent(RecommendCardConstants.HOMEPAGE_RECOMMEND_REFRESH_FINISH_ACTION) : str.equals(RecommendCardConstants.Entrance.BUY) ? new Intent(RecommendCardConstants.BUY_RECOMMEND_REFRESH_FINISH_ACTION) : null;
            if (intent == null) {
                NotifyLogger.m29914e(TAG, "sendRefreshCardFinishBroadcast intent is null ");
            } else {
                C13108a.m78878b(contextM1377a).m78881d(intent);
            }
        }
    }

    public void setActivityIdToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.ACTIVITY_ID + i10, str);
    }

    public void setActivityTypeToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.ACTIVITY_TYPE + i10, str);
    }

    public void setAdLoaded(String str, boolean z10) {
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            this.homeAdsLoaded = z10;
        } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
            this.buyAdsLoaded = z10;
        }
    }

    public void setAds(String str, Map<String, List<INativeAd>> map) {
        this.adsMap.put(str, map);
    }

    public void setButtonToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.BUTTON + i10, str);
    }

    public void setCTypeToSp(String str) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.C_TYPE, str);
    }

    public void setCardRefreshToSp(int i10, int i11) {
        if (i11 <= 0) {
            return;
        }
        C0212e0.m1369s(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.CARD_REFRESH + i10, i11);
    }

    public void setCardsLanguageToSp(String str) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.LANGUAGE, str);
    }

    public void setCardsNumToSp(int i10) {
        C0212e0.m1369s(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, "num", i10);
    }

    public void setDescriptionEndLinkToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.DESCRIPTION_END_LINK + i10, str);
    }

    public void setDescriptionToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.DESCRIPTION + i10, str);
    }

    public void setFirstShowTimeToSp(String str, String str2) {
        if (checkEntrance(str)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            NotifyLogger.m29915i(TAG, "setFirstShowTimeToSp, entrance: " + str + ", activityId: " + str2 + ", lastShowTime: " + jCurrentTimeMillis);
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.FIRST_SHOW_TIME + str2, jCurrentTimeMillis);
                return;
            }
            if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.BUY_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.FIRST_SHOW_TIME + str2, jCurrentTimeMillis);
            }
        }
    }

    public void setFixedToSp(int i10, boolean z10) {
        C0212e0.m1366p(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.FIXED + i10, z10);
    }

    public void setH5JumpUrlToSp(String str) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.H5_JUMP_URL, str);
    }

    public void setLandscapePicturePathToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.LANDSCAPE_PICTURE_PATH + i10, str);
    }

    public void setLastIncentiveTimeToSp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        NotifyLogger.m29913d(TAG, "setLastIncentiveTimeToSp: " + jCurrentTimeMillis);
        C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_INCENTIVE_TIME, jCurrentTimeMillis);
    }

    public void setLastNotifyTimeToNotificationSp(String str, String str2, String str3, long j10) {
        if (checkEntrance(str)) {
            NotifyLogger.m29915i(TAG, "setLastNotifyTimeToNotificationSp, entrance: " + str + ", activityId: " + str2 + ", activityType: " + str3 + ", lastNotifyTime: " + j10);
            if (TextUtils.isEmpty(str2)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_NOTIFICATION_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, j10);
                return;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_NOTIFICATION_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str2, j10);
        }
    }

    public void setLastNotifyTimeToSp(String str, String str2, String str3, long j10) {
        if (checkEntrance(str)) {
            NotifyLogger.m29915i(TAG, "setLastNotifyTimeToSp, entrance: " + str + ", activityId: " + str2 + ", activityType: " + str3 + ", lastNotifyTime: " + j10);
            if ((RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE_BUY.equals(str3) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN_BUY.equals(str3)) && str.equals(RecommendCardConstants.Entrance.BUY)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3 + str, j10);
                return;
            }
            if ((RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_CLOSE.equals(str3) || RecommendCardConstants.ActivityType.GALLERY_RELEASE_SPACE_OPEN.equals(str3)) && str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, j10);
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str3, j10);
                return;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_TIME_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_NOTIFY_TIME + str2, j10);
        }
    }

    public void setLastTwoHundredGuidTimeToSp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        NotifyLogger.m29913d(TAG, "setLastTwoHundredGuidTimeToSp: " + jCurrentTimeMillis);
        C0212e0.m1371u(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.LAST_TWO_HUNDRED_GUID_TIME, jCurrentTimeMillis);
    }

    public void setNotifyBarDescriptionToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR_DESCRIPTION + i10, str);
    }

    public void setNotifyBarTitleToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR_TITLE + i10, str);
    }

    public void setNotifyBarToSp(int i10, boolean z10) {
        C0212e0.m1366p(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_BAR + i10, z10);
    }

    public void setNotifyTypeToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_TYPE + i10, str);
    }

    public void setNotifyUriToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.NOTIFY_URI + i10, str);
    }

    public void setPicturePathToSp(String str, String str2) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.PICTURE_CACHE_FILE_NAME, str, str2);
    }

    public void setPictureSecondPathToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PICTURE_SECOND_PATH + i10, str);
    }

    public void setPortraitPicturePathToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PORTRAIT_PICTURE_PATH + i10, str);
    }

    public void setPpsPicturePathToSp(String str, String str2) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.PPS_PICTURES_CACHE, str, str2);
    }

    public void setPriorityToSp(int i10, int i11) {
        if (i11 <= 0) {
            return;
        }
        C0212e0.m1369s(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.PRIORITY + i10, i11);
    }

    public void setRemarkToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.REMARK + i10, str);
    }

    public void setResourceIdToSp(String str) {
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, "resource_id", str);
    }

    public void setTitleToSp(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_POSITION_FILE_NAME, RecommendCardConstants.C4910Sp.TITLE + i10, str);
    }

    public void setTwoHundredGuidResultToSp(int i10) {
        C0212e0.m1369s(C0213f.m1377a(), RecommendCardConstants.C4910Sp.HOMEPAGE_CACHE_FILE_NAME, RecommendCardConstants.C4910Sp.TWO_HUNDRED_GUID_RESULT, i10);
    }

    private RecommendCardManager() {
        this.adsMap = new HashMap();
        this.homeAdsLoaded = false;
        this.buyAdsLoaded = false;
        this.unsatisfiedKeySet = new HashSet<>();
        this.showInfoKeySet = new HashSet<>();
        this.showKeySet = new HashSet<>();
        this.currentNotifyId = 306;
        this.currentRequestCode = 9;
        this.notifyIdMap = new LinkedHashMap<>();
        this.homepageRecommendCards = new ArrayList<>();
        this.buyRecommendCards = new ArrayList<>();
        this.pictureNameRand = new Random();
        this.pictureMap = new HashMap<>();
        this.adsMap.put(CardEntrance.HOMEPAGE.toString(), new HashMap());
        this.adsMap.put(CardEntrance.BUY.toString(), new HashMap());
    }

    public ActivityEntryEx getIncentiveCardActivityEntryEx(String str, LinkedHashMap<String, String> linkedHashMap, int i10) {
        if (!checkEntrance(str)) {
            return null;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e(TAG, "spaceProxy is null");
            return null;
        }
        return spaceProxy.getIncentiveCardActivityEntryEx(str, linkedHashMap, i10);
    }

    private void deletePictures(String str) {
        File[] fileArrM63440f;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                if (!file2.isDirectory() && !file2.delete()) {
                    NotifyLogger.m29914e(TAG, "del pps file failed, file name is " + file2.getPath());
                }
            }
        }
    }

    public String getPicturePath(CommonPicture[] commonPictureArr) {
        if (commonPictureArr == null || commonPictureArr.length == 0) {
            NotifyLogger.m29916w(TAG, "pictures array is null");
            return "";
        }
        CommonPicture commonPicture = commonPictureArr[0];
        if (commonPicture == null) {
            NotifyLogger.m29916w(TAG, "picture is null");
            return "";
        }
        String picturePathFromSp = getInstance().getPicturePathFromSp(commonPicture.getUrl());
        if (!TextUtils.isEmpty(picturePathFromSp)) {
            return isPictureToBitmapSuccess(picturePathFromSp) ? picturePathFromSp : "";
        }
        NotifyLogger.m29916w(TAG, "picture path in sp is null");
        return "";
    }
}
