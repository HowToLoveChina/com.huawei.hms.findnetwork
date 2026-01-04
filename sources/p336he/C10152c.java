package p336he;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.DialogMarkInfo;
import com.huawei.hicloud.notification.p106db.bean.DialogMarkPictures;
import com.huawei.hicloud.notification.p106db.bean.NoticeContentRoot;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipInfo;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0241z;
import p020ap.C1007b;
import p514o9.C11839m;

/* renamed from: he.c */
/* loaded from: classes3.dex */
public class C10152c {
    /* renamed from: a */
    public static void m63217a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "cancelSpaceNotEnoughNotify, context is null");
        } else {
            ScreenListener.m18023c(contextM1377a).m18028g();
            C1007b.m5980s().m6013d();
        }
    }

    /* renamed from: b */
    public static void m63218b(Context context) {
        C11839m.m70688i("BackUpFailWithSpaceUtil", "number clear");
        C0214f0.m1382b(context, "backup_fail_with_space_not_enough_sp", 0).edit().putInt("backup_fail_dialog_num", 0).apply();
    }

    /* renamed from: c */
    public static int m63219c(Context context) {
        C11839m.m70688i("BackUpFailWithSpaceUtil", "getDialogShowNum");
        return C0214f0.m1382b(context, "backup_fail_with_space_not_enough_sp", 0).getInt("backup_fail_dialog_num", 0);
    }

    /* renamed from: d */
    public static DialogMarkPictures m63220d(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "notification is null");
            return null;
        }
        DialogMarkInfo markContentInfo = baseSpaceNotifyBean.getMarkContentInfo();
        if (markContentInfo != null) {
            return markContentInfo.getPictures();
        }
        C11839m.m70687e("BackUpFailWithSpaceUtil", "getImageDetail dialogMarkInfo is null");
        return null;
    }

    /* renamed from: e */
    public static DialogMarkPictures m63221e(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "notification is null");
            return null;
        }
        DialogMarkInfo markContentInfo = notificationWithActivity.getMarkContentInfo();
        if (markContentInfo != null) {
            return markContentInfo.getPictures();
        }
        C11839m.m70687e("BackUpFailWithSpaceUtil", "getImageDetail dialogMarkInfo is null");
        return null;
    }

    /* renamed from: f */
    public static NoticeDetail m63222f(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        NoticeGoto noticeGoto = baseSpaceNotifyBean.getNoticeGoto();
        NoticeContentRoot noticeContent = baseSpaceNotifyBean.getNoticeContent();
        if (noticeContent == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "noticeContentRoot is null");
            return null;
        }
        C11839m.m70688i("BackUpFailWithSpaceUtil", "getNoticeDetail noticeGoto type:" + noticeGoto.getPopupType());
        if ("detail".equals(noticeGoto.getPopupType())) {
            return noticeContent.getNoticeDetail();
        }
        if (NotifyConstants.DETAIL2.equals(noticeGoto.getPopupType())) {
            return noticeContent.getNoticeDetail2();
        }
        return null;
    }

    /* renamed from: g */
    public static NoticeDetail m63223g(NotificationWithActivity notificationWithActivity) {
        List<PopUpWithActivityGoto> popupeGoto = notificationWithActivity.getPopupeGoto();
        NoticeContentRoot noticeContent = notificationWithActivity.getNoticeContent();
        if (noticeContent == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "getNoticeDetail noticeContentRoot is null");
            return null;
        }
        for (PopUpWithActivityGoto popUpWithActivityGoto : popupeGoto) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "getNoticeDetailWithActivity noticeGoto type:" + popUpWithActivityGoto.getPopupType());
            if (NotifyConstants.DETAIL2.equals(popUpWithActivityGoto.getPopupType())) {
                return noticeContent.getNoticeDetail2();
            }
            if ("detail".equals(popUpWithActivityGoto.getPopupType())) {
                return noticeContent.getNoticeDetail();
            }
        }
        return null;
    }

    /* renamed from: h */
    public static NoticeDetail m63224h(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        NoticeContentRoot noticeContent = baseSpaceNotifyBean.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeDetail2();
        }
        C11839m.m70687e("BackUpFailWithSpaceUtil", "noticeContentRoot is null");
        return null;
    }

    /* renamed from: i */
    public static int m63225i(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        if (baseSpaceNotifyBean == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "notification is null");
            return -1;
        }
        DialogMarkInfo markContentInfo = baseSpaceNotifyBean.getMarkContentInfo();
        if (markContentInfo != null) {
            return C0241z.m1685c(markContentInfo.getPopTimesThreshold());
        }
        C11839m.m70687e("BackUpFailWithSpaceUtil", "getPopTimesThreshold dialogMarkInfo is null");
        return -1;
    }

    /* renamed from: j */
    public static int m63226j(NotificationWithActivity notificationWithActivity) {
        if (notificationWithActivity == null) {
            C11839m.m70687e("BackUpFailWithSpaceUtil", "notification is null");
            return -1;
        }
        DialogMarkInfo markContentInfo = notificationWithActivity.getMarkContentInfo();
        if (markContentInfo != null) {
            return C0241z.m1685c(markContentInfo.getPopTimesThreshold());
        }
        C11839m.m70687e("BackUpFailWithSpaceUtil", "getPopTimesThresholdWithActivity dialogMarkInfo is null");
        return -1;
    }

    /* renamed from: k */
    public static RecommendTipData m63227k(RecommendTipInfo recommendTipInfo, NoticeDetail noticeDetail, String str, int i10) {
        RecommendTipData recommendTipData = new RecommendTipData();
        recommendTipData.setDisplayClearCard(recommendTipInfo.getDisplayClearCard());
        recommendTipData.setDisplayHelp(recommendTipInfo.getDisplayHelp());
        recommendTipData.setHelpUrl(recommendTipInfo.getHelpUrl());
        recommendTipData.setDialogPopTimesThreshold(str);
        recommendTipData.setTipId(noticeDetail.getTip());
        recommendTipData.setDialogViewDetailsNum(i10);
        return recommendTipData;
    }

    /* renamed from: l */
    public static String m63228l(String str, int i10) {
        String stringWithDefault = SpaceInsuffNoticeV4Manager.getInstance().getStringWithDefault(str, i10);
        return !TextUtils.isEmpty(stringWithDefault) ? stringWithDefault : SpaceNoticeV3Manager.getInstance().getStringWithDefault(str);
    }

    /* renamed from: m */
    public static Intent m63229m(Intent intent, BaseSpaceNotifyBean baseSpaceNotifyBean, NoticeGoto noticeGoto, int i10, boolean z10) {
        NoticeDetail noticeDetail;
        RecommendTipInfo recommendDetail = null;
        if (intent == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "cloudSpaceIntent is null");
            return null;
        }
        String popupType = z10 ? noticeGoto.getPopupType() : noticeGoto.getNotiType();
        C11839m.m70686d("BackUpFailWithSpaceUtil", "uriType:" + popupType);
        if (NotifyConstants.DETAIL3.equals(popupType)) {
            NoticeDetail noticeDetail2 = baseSpaceNotifyBean.getNoticeContent().getNoticeDetail();
            recommendDetail = baseSpaceNotifyBean.getRecommendDetail3();
            noticeDetail = noticeDetail2;
        } else {
            noticeDetail = null;
        }
        if (NotifyConstants.DETAIL2.equals(popupType)) {
            noticeDetail = baseSpaceNotifyBean.getNoticeContent().getNoticeDetail2();
            recommendDetail = baseSpaceNotifyBean.getRecommendDetail2();
        }
        if ("detail".equals(popupType)) {
            noticeDetail = baseSpaceNotifyBean.getNoticeContent().getNoticeDetail();
            recommendDetail = baseSpaceNotifyBean.getRecommendDetail();
        }
        if (recommendDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "initCloudSpaceIntent recommendTipInfo is null");
            return intent;
        }
        if (noticeDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "noticeDetail is null");
            return intent;
        }
        intent.putExtra("recommend_tip_info_key", m63227k(recommendDetail, noticeDetail, baseSpaceNotifyBean.getMarkContentInfo().getPopTimesThreshold(), i10));
        return intent;
    }

    /* renamed from: n */
    public static Intent m63230n(Intent intent, PopUpWithActivityGoto popUpWithActivityGoto, BaseSpaceNotifyBean baseSpaceNotifyBean, int i10) {
        RecommendTipInfo recommendDetail;
        NoticeDetail noticeDetail = null;
        if (intent == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "initIntentWithActivity intent is null");
            return null;
        }
        if (NotifyConstants.DETAIL2.equals(popUpWithActivityGoto.getPopupType())) {
            noticeDetail = baseSpaceNotifyBean.getNoticeContent().getNoticeDetail2();
            recommendDetail = baseSpaceNotifyBean.getRecommendDetail2();
        } else {
            recommendDetail = null;
        }
        if ("detail".equals(popUpWithActivityGoto.getPopupType())) {
            noticeDetail = baseSpaceNotifyBean.getNoticeContent().getNoticeDetail();
            recommendDetail = baseSpaceNotifyBean.getRecommendDetail();
        }
        if (noticeDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "noticeDetail is null");
            return intent;
        }
        if (recommendDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "recommendTipInfo is null");
            return intent;
        }
        intent.putExtra("recommend_tip_info_key", m63227k(recommendDetail, noticeDetail, baseSpaceNotifyBean.getMarkContentInfo().getPopTimesThreshold(), i10));
        return intent;
    }

    /* renamed from: o */
    public static Intent m63231o(Intent intent, String str, NotificationWithActivity notificationWithActivity, int i10) {
        RecommendTipInfo recommendDetail;
        NoticeDetail noticeDetail = null;
        if (intent == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "initIntentWithActivity intent is null");
            return null;
        }
        if (NotifyConstants.DETAIL2.equals(str)) {
            noticeDetail = notificationWithActivity.getNoticeContent().getNoticeDetail2();
            recommendDetail = notificationWithActivity.getRecommendDetail2();
        } else {
            recommendDetail = null;
        }
        if ("detail".equals(str)) {
            noticeDetail = notificationWithActivity.getNoticeContent().getNoticeDetail();
            recommendDetail = notificationWithActivity.getRecommendDetail();
        }
        if (noticeDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "noticeDetail is null");
            return intent;
        }
        if (recommendDetail == null) {
            C11839m.m70688i("BackUpFailWithSpaceUtil", "initIntentWithActivity recommendTipInfo is null");
            return intent;
        }
        intent.putExtra("recommend_tip_info_key", m63227k(recommendDetail, noticeDetail, notificationWithActivity.getMarkContentInfo().getPopTimesThreshold(), i10));
        return intent;
    }

    /* renamed from: p */
    public static boolean m63232p(int i10, String str) {
        C11839m.m70686d("BackUpFailWithSpaceUtil", "isShowHelpBubbleView dialogViewDetailsNum:" + i10 + " dialogPopTimesThreshold:" + str);
        return i10 > C0241z.m1685c(str);
    }

    /* renamed from: q */
    public static boolean m63233q(String str) {
        C11839m.m70686d("BackUpFailWithSpaceUtil", "isShowHelpView  displayHelp:" + str);
        return C0241z.m1685c(str) == 1;
    }

    /* renamed from: r */
    public static boolean m63234r(Context context, BaseSpaceNotifyBean baseSpaceNotifyBean, boolean z10) {
        if (z10) {
            return false;
        }
        int iM63219c = m63219c(context);
        int iM63225i = m63225i(baseSpaceNotifyBean);
        C11839m.m70686d("BackUpFailWithSpaceUtil", "number:" + iM63219c + " popTimes:" + iM63225i);
        return iM63219c + 1 > iM63225i && iM63225i > 0;
    }

    /* renamed from: s */
    public static boolean m63235s(NotificationWithActivity notificationWithActivity, Context context, boolean z10) {
        if (z10) {
            return false;
        }
        int iM63219c = m63219c(context);
        int iM63226j = m63226j(notificationWithActivity);
        C11839m.m70686d("BackUpFailWithSpaceUtil", "NotificationWithActivity number:" + iM63219c + " popTimes:" + iM63226j);
        return iM63219c + 1 > iM63226j && iM63226j >= 0;
    }

    /* renamed from: t */
    public static void m63236t(Context context) {
        C11839m.m70688i("BackUpFailWithSpaceUtil", "number add");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "backup_fail_with_space_not_enough_sp", 0);
        sharedPreferencesM1382b.edit().putInt("backup_fail_dialog_num", sharedPreferencesM1382b.getInt("backup_fail_dialog_num", 0) + 1).apply();
    }
}
