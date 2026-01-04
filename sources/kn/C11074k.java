package kn;

import android.text.TextUtils;
import com.huawei.hicloud.bean.NotifyJumpInfo;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.bean.SilenceDurationBean;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.bean.MsgUserData;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNoticeConfig;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notificationv2.bean.ActionTimeRecord;
import com.huawei.hicloud.notificationv2.bean.C4971a;
import com.huawei.hicloud.notificationv2.bean.C4973c;
import com.huawei.hicloud.notificationv2.bean.LogInfoRecord;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import com.huawei.hicloud.notificationv2.bean.NotificationTaskList;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5863b6;
import fk.C9721b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import kn.C11074k;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p657tp.C13053d;
import p657tp.C13055f;
import p684un.C13230i;
import p686up.InterfaceC13233a;
import p686up.InterfaceC13235c;
import p709vj.C13452e;
import p746wn.C13622a;
import p815ym.AbstractC14026a;

/* renamed from: kn.k */
/* loaded from: classes6.dex */
public class C11074k {

    /* renamed from: kn.k$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f52269a;

        /* renamed from: b */
        public final /* synthetic */ int f52270b;

        /* renamed from: c */
        public final /* synthetic */ int f52271c;

        public a(String str, int i10, int i11) {
            this.f52269a = str;
            this.f52270b = i10;
            this.f52271c = i11;
        }

        /* renamed from: e */
        public static /* synthetic */ boolean m66726e(LogInfoRecord logInfoRecord) {
            return C11074k.m66723z(logInfoRecord.getEventTime(), C11074k.m66717t());
        }

        /* renamed from: f */
        public static /* synthetic */ void m66727f(String str, int i10, int i11, ICloudSpaceProxy iCloudSpaceProxy, C4973c c4973c) {
            List<LogInfoRecord> arrayList;
            List<LogInfoRecord> listM29934c = ((C4973c) C13053d.m78770i().m78764c(C4973c.class)).m29934c();
            if (AbstractC14026a.m84159a(listM29934c)) {
                arrayList = new ArrayList<>();
                arrayList.add(new LogInfoRecord(C11074k.m66717t(), str));
                C11074k.m66712o(i10, i11, str, iCloudSpaceProxy);
            } else {
                arrayList = (List) listM29934c.stream().filter(new Predicate() { // from class: kn.j
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C11074k.a.m66726e((LogInfoRecord) obj);
                    }
                }).collect(Collectors.toList());
                if (C11074k.m66692N(arrayList, str)) {
                    arrayList.add(new LogInfoRecord(C11074k.m66717t(), str));
                    C11074k.m66712o(i10, i11, str, iCloudSpaceProxy);
                }
            }
            c4973c.m29935d(arrayList);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
            if (spaceProxy == null || this.f52269a == null) {
                NotifyLogger.m29914e("NotificationV2Util", "spaceProxy or errorReason is null");
                return;
            }
            C13053d c13053dM78770i = C13053d.m78770i();
            final String str = this.f52269a;
            final int i10 = this.f52270b;
            final int i11 = this.f52271c;
            c13053dM78770i.m78765d(C4973c.class, new InterfaceC13235c() { // from class: kn.i
                @Override // p686up.InterfaceC13235c
                /* renamed from: a */
                public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                    C11074k.a.m66727f(str, i10, i11, spaceProxy, (C4973c) interfaceC13233a);
                }
            });
        }
    }

    /* renamed from: A */
    public static boolean m66679A(List<SilenceDurationBean> list) {
        if (AbstractC14026a.m84159a(list)) {
            NotifyLogger.m29916w("NotificationV2Util", "silencePeriod is null or empty");
            return false;
        }
        for (SilenceDurationBean silenceDurationBean : list) {
            if (NotifyUtil.checkTimeRange(silenceDurationBean.getStartTime(), silenceDurationBean.getEndTime(), "HH:mm")) {
                NotifyLogger.m29915i("NotificationV2Util", "in silent notify time,currentTime:" + System.currentTimeMillis() + ",startTime:" + silenceDurationBean.getStartTime() + ",endTime:" + silenceDurationBean.getEndTime());
                return true;
            }
        }
        return false;
    }

    /* renamed from: B */
    public static boolean m66680B() {
        BackupBeforeNotice backupBeforeNoticeM66715r = m66715r();
        if (backupBeforeNoticeM66715r != null) {
            return m66679A(backupBeforeNoticeM66715r.getSilencePeriod());
        }
        NotifyLogger.m29916w("NotificationV2Util", "backupBeforeNotice is null,isInSilentTime will return true");
        return true;
    }

    /* renamed from: C */
    public static boolean m66681C() {
        NotificationTaskList notificationTaskList = (NotificationTaskList) C13055f.m78779g().m78764c(NotificationTaskList.class);
        if (notificationTaskList == null || AbstractC14026a.m84159a(notificationTaskList.getNotificationTaskList())) {
            NotifyLogger.m29915i("NotificationV2Util", "notificationTaskList in sp is null or empty");
            return false;
        }
        Optional<NotificationTask> optionalFindFirst = notificationTaskList.getNotificationTaskList().stream().filter(new Predicate() { // from class: kn.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C11074k.m66688J((NotificationTask) obj);
            }
        }).findFirst();
        if (!optionalFindFirst.isPresent()) {
            NotifyLogger.m29915i("NotificationV2Util", "cannot find notice before backup task in sp.");
            return false;
        }
        NotificationTask notificationTask = optionalFindFirst.get();
        if (notificationTask.getNotifyTime() > m66717t()) {
            NotifyLogger.m29915i("NotificationV2Util", "noticeBeforeBackupTask notifyTime in sp is after current time,notifyTime is:" + notificationTask.getNotifyTime());
            return false;
        }
        if (notificationTask.getNotifyTime() >= m66717t() - 86400000) {
            NotifyLogger.m29915i("NotificationV2Util", "noticeBeforeBackupTask notifyTime in sp is within currentTime -24h,notifyTime is:" + notificationTask.getNotifyTime());
            return true;
        }
        NotifyLogger.m29915i("NotificationV2Util", "noticeBeforeBackupTask notifyTime in sp is beyond currentTime -24h,notifyTime is:" + notificationTask.getNotifyTime());
        return false;
    }

    /* renamed from: D */
    public static boolean m66682D(Date date, Date date2, Date date3) {
        if (date == null || date2 == null || date3 == null || date.after(date2)) {
            return false;
        }
        if (!m66723z(date3.getTime(), date.getTime())) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(date3);
            calendar2.setTime(date);
            int i10 = calendar2.get(1);
            int i11 = calendar2.get(2);
            int i12 = calendar2.get(5);
            calendar.set(1, i10);
            calendar.set(2, i11);
            calendar.set(5, i12);
            date3.setTime(calendar.getTime().getTime());
        }
        return date3.after(date) && date3.before(date2);
    }

    /* renamed from: E */
    public static boolean m66683E(BackupBeforeNotice backupBeforeNotice) {
        if (backupBeforeNotice == null) {
            NotifyLogger.m29914e("NotificationV2Util", "isUserInRange,backupBeforeNotice is null");
            return false;
        }
        List<String> userGroupExtIDs = backupBeforeNotice.getUserGroupExtIDs();
        if (!AbstractC14026a.m84159a(userGroupExtIDs)) {
            return RecommendCardManager.getInstance().isCurrentUserInUserGroupExtIds((String[]) userGroupExtIDs.toArray(new String[userGroupExtIDs.size()]));
        }
        NotifyLogger.m29915i("NotificationV2Util", "userGroupExtIds is empty.");
        return true;
    }

    /* renamed from: F */
    public static /* synthetic */ void m66684F(NotificationTask notificationTask, NotificationTaskList notificationTaskList) {
        NotificationTaskList notificationTaskList2 = (NotificationTaskList) C13055f.m78779g().m78764c(NotificationTaskList.class);
        if (notificationTaskList2 == null) {
            return;
        }
        List<NotificationTask> notificationTaskList3 = notificationTaskList2.getNotificationTaskList();
        if (AbstractC14026a.m84159a(notificationTaskList3)) {
            NotifyLogger.m29915i("NotificationV2Util", "clearNotificationTask,no notificationTaskList found in sp,taskType is:" + notificationTask.getType());
            return;
        }
        Iterator<NotificationTask> it = notificationTaskList3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NotificationTask next = it.next();
            if (next.getType() == notificationTask.getType()) {
                it.remove();
                NotifyLogger.m29915i("NotificationV2Util", "clear notificationTask,type is:" + next.getType());
                break;
            }
        }
        notificationTaskList2.setNotificationTaskList(notificationTaskList3);
    }

    /* renamed from: G */
    public static /* synthetic */ boolean m66685G(int i10, ActionTimeRecord actionTimeRecord) {
        return actionTimeRecord.getActionType() == i10;
    }

    /* renamed from: H */
    public static /* synthetic */ boolean m66686H(BackupBeforeNotice backupBeforeNotice) {
        return m66722y(backupBeforeNotice) && m66683E(backupBeforeNotice);
    }

    /* renamed from: J */
    public static /* synthetic */ boolean m66688J(NotificationTask notificationTask) {
        return notificationTask.getType() == 1;
    }

    /* renamed from: K */
    public static /* synthetic */ boolean m66689K(long j10, long j11, ActionTimeRecord actionTimeRecord) {
        return actionTimeRecord.getTimeStamp() >= j10 && actionTimeRecord.getTimeStamp() <= j11;
    }

    /* renamed from: L */
    public static /* synthetic */ void m66690L(ActionTimeRecord actionTimeRecord, int i10, C4971a c4971a) {
        List<ActionTimeRecord> arrayList;
        List<ActionTimeRecord> listM29930c = ((C4971a) C13053d.m78770i().m78764c(C4971a.class)).m29930c();
        if (AbstractC14026a.m84159a(listM29930c)) {
            arrayList = new ArrayList<>();
            arrayList.add(actionTimeRecord);
        } else {
            final long jM66717t = m66717t() - (i10 * C5863b6.g.f26453g);
            final long jM66717t2 = m66717t();
            arrayList = (List) listM29930c.stream().filter(new Predicate() { // from class: kn.h
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C11074k.m66689K(jM66717t, jM66717t2, (ActionTimeRecord) obj);
                }
            }).collect(Collectors.toList());
            arrayList.add(actionTimeRecord);
        }
        c4971a.m29931d(arrayList);
    }

    /* renamed from: M */
    public static /* synthetic */ void m66691M(NotificationTask notificationTask, NotificationTaskList notificationTaskList) {
        NotificationTaskList notificationTaskList2 = (NotificationTaskList) C13055f.m78779g().m78764c(NotificationTaskList.class);
        if (notificationTaskList2 == null) {
            notificationTaskList2 = new NotificationTaskList();
        }
        List<NotificationTask> notificationTaskList3 = notificationTaskList2.getNotificationTaskList();
        if (AbstractC14026a.m84159a(notificationTaskList3)) {
            notificationTaskList3 = new ArrayList<>();
            notificationTaskList3.add(notificationTask);
        } else {
            Iterator<NotificationTask> it = notificationTaskList3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getType() == notificationTask.getType()) {
                    it.remove();
                    break;
                }
            }
            notificationTaskList3.add(notificationTask);
        }
        notificationTaskList.setNotificationTaskList(notificationTaskList3);
    }

    /* renamed from: N */
    public static boolean m66692N(List<LogInfoRecord> list, String str) {
        if (AbstractC14026a.m84159a(list)) {
            return true;
        }
        LogInfoRecord logInfoRecord = list.get(list.size() - 1);
        return (logInfoRecord.getErrorReason() == null || logInfoRecord.getErrorReason().equals(str) || m66708k(str, logInfoRecord)) ? false : true;
    }

    /* renamed from: O */
    public static void m66693O(int i10, int i11, String str) {
        NotifyLogger.m29913d("NotificationV2Util", "reportCheckResult enter.");
        C12515a.m75110o().m75172d(new a(str, i10, i11));
    }

    /* renamed from: P */
    public static void m66694P(int i10, int i11, String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("eventType", String.valueOf(i10));
        linkedHashMapM79497A.put("result", String.valueOf(i11));
        linkedHashMapM79497A.put("errorReason", str);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02310"), "noticeBeforeBackupCheck", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMapM79497A, false, true);
        UBAAnalyze.m29947H("CKC", "action_notice_before_backup_check", linkedHashMapM79497A);
    }

    /* renamed from: Q */
    public static void m66695Q(final ActionTimeRecord actionTimeRecord, final int i10) {
        if (actionTimeRecord == null) {
            NotifyLogger.m29916w("NotificationV2Util", "saveNotificationTask error,notificationTask is null");
            return;
        }
        if (i10 <= 0) {
            i10 = 48;
        }
        C13053d.m78770i().m78765d(C4971a.class, new InterfaceC13235c() { // from class: kn.f
            @Override // p686up.InterfaceC13235c
            /* renamed from: a */
            public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                C11074k.m66690L(actionTimeRecord, i10, (C4971a) interfaceC13233a);
            }
        });
    }

    /* renamed from: R */
    public static void m66696R(final NotificationTask notificationTask) {
        if (notificationTask == null) {
            NotifyLogger.m29916w("NotificationV2Util", "saveNotificationTask error,notificationTask is null");
        } else {
            C13055f.m78779g().m78765d(NotificationTaskList.class, new InterfaceC13235c() { // from class: kn.g
                @Override // p686up.InterfaceC13235c
                /* renamed from: a */
                public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                    C11074k.m66691M(notificationTask, (NotificationTaskList) interfaceC13233a);
                }
            });
        }
    }

    /* renamed from: S */
    public static Date m66697S(String str, Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str2 = simpleDateFormat.format(date).substring(0, 11) + str + ":00";
        Date dateM66718u = m66718u();
        try {
            return simpleDateFormat.parse(str2);
        } catch (Exception unused) {
            NotifyLogger.m29914e("NotificationV2Util", "timeToDate error.");
            return dateM66718u;
        }
    }

    /* renamed from: k */
    public static boolean m66708k(String str, LogInfoRecord logInfoRecord) {
        return logInfoRecord.getErrorReason().contains("time not satisfied,isInBackupCycleDay:false") && str != null && str.contains("time not satisfied,isInBackupCycleDay:false");
    }

    /* renamed from: l */
    public static BaseNotifyBean m66709l(BackupBeforeNotice backupBeforeNotice) {
        BaseNotifyBean baseNotifyBean = new BaseNotifyBean();
        baseNotifyBean.setId(C0241z.m1685c(backupBeforeNotice.getId()));
        baseNotifyBean.setRemindPurposes(backupBeforeNotice.getRemindPurposes());
        ArrayList arrayList = new ArrayList();
        NotifyWay notifyWay = new NotifyWay();
        notifyWay.setText(backupBeforeNotice.getText());
        notifyWay.setTitle(backupBeforeNotice.getTitle());
        List<String> remindWays = backupBeforeNotice.getRemindWays();
        if (!AbstractC14026a.m84159a(remindWays)) {
            notifyWay.setName(remindWays.get(0));
        }
        BackupBeforeNoticeGoto noticeGoto = backupBeforeNotice.getNoticeGoto();
        if (noticeGoto != null) {
            NotifyJumpInfo notifyJumpInfo = new NotifyJumpInfo();
            notifyJumpInfo.setNotifyType(noticeGoto.getNotifyType());
            notifyJumpInfo.setNotifyUri(noticeGoto.getNotifyUri());
            notifyWay.setNotifyJumpInfo(notifyJumpInfo);
        }
        arrayList.add(notifyWay);
        baseNotifyBean.setRemindWays(arrayList);
        baseNotifyBean.setNoticeType("before_backup");
        return baseNotifyBean;
    }

    /* renamed from: m */
    public static MsgUserData m66710m(BackupBeforeNotice backupBeforeNotice) {
        MsgUserData msgUserData = new MsgUserData();
        msgUserData.setNotifyType(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
        msgUserData.setActivityNotify(true);
        msgUserData.setResourceId(backupBeforeNotice.getId());
        msgUserData.setNotifyConfigId(Integer.valueOf(backupBeforeNotice.getId()).intValue());
        return msgUserData;
    }

    /* renamed from: n */
    public static void m66711n(final NotificationTask notificationTask) {
        if (notificationTask == null) {
            NotifyLogger.m29915i("NotificationV2Util", "clearNotificationTask error,notificationTask is null");
        } else {
            C13055f.m78779g().m78765d(NotificationTaskList.class, new InterfaceC13235c() { // from class: kn.a
                @Override // p686up.InterfaceC13235c
                /* renamed from: a */
                public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                    C11074k.m66684F(notificationTask, (NotificationTaskList) interfaceC13233a);
                }
            });
        }
    }

    /* renamed from: o */
    public static void m66712o(int i10, int i11, String str, ICloudSpaceProxy iCloudSpaceProxy) {
        NotifyLogger.m29913d("NotificationV2Util", "need to report.");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m66716s(iCloudSpaceProxy, linkedHashMapM79497A);
        linkedHashMapM79497A.put("userTags", C13452e.m80781L().m80979v0());
        linkedHashMapM79497A.put("gradeCode", C13452e.m80781L().m80790C());
        linkedHashMapM79497A.put("eventType", String.valueOf(i10));
        linkedHashMapM79497A.put("result", String.valueOf(i11));
        linkedHashMapM79497A.put("backupFrequency", String.valueOf(iCloudSpaceProxy.getBackupCycle()));
        linkedHashMapM79497A.put("errorReason", str);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02310"), "noticeBeforeBackupCheck", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81971q(c11060cM66626a, linkedHashMapM79497A, false, true);
        UBAAnalyze.m29947H("CKC", "action_notice_before_backup_check", linkedHashMapM79497A);
    }

    /* renamed from: p */
    public static boolean m66713p(Date date, Date date2, Date date3) {
        if (date != null && date2 != null && date3 != null) {
            return date2.after(date3) && !(date.after(date3) && date.before(date2));
        }
        NotifyLogger.m29914e("NotificationV2Util", "checkTimeRange parse result is null");
        return false;
    }

    /* renamed from: q */
    public static List<ActionTimeRecord> m66714q(final int i10) {
        List<ActionTimeRecord> listM29930c = ((C4971a) C13053d.m78770i().m78764c(C4971a.class)).m29930c();
        return AbstractC14026a.m84159a(listM29930c) ? Collections.emptyList() : (List) listM29930c.stream().filter(new Predicate() { // from class: kn.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C11074k.m66685G(i10, (ActionTimeRecord) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: r */
    public static BackupBeforeNotice m66715r() {
        BackupBeforeNoticeConfig backupBeforeNoticeConfigLocal = BackupBeforeNoticeManager.getInstance().getBackupBeforeNoticeConfigLocal();
        if (backupBeforeNoticeConfigLocal == null) {
            NotifyLogger.m29916w("NotificationV2Util", "BackupBeforeNoticeConfig is null");
            return null;
        }
        List<BackupBeforeNotice> configuration = backupBeforeNoticeConfigLocal.getConfiguration();
        if (configuration == null || configuration.isEmpty()) {
            NotifyLogger.m29916w("NotificationV2Util", "BackupBeforeNoticeList is null");
            return null;
        }
        List list = (List) configuration.stream().filter(new Predicate() { // from class: kn.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C11074k.m66686H((BackupBeforeNotice) obj);
            }
        }).sorted(Comparator.comparingInt(new ToIntFunction() { // from class: kn.c
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((BackupBeforeNotice) obj).getPriority();
            }
        })).collect(Collectors.toList());
        if (list.size() == 0) {
            NotifyLogger.m29915i("NotificationV2Util", "get NoticeBeforeBackup config failed,gradeCode or userGroupExtIds no satisfied");
            return null;
        }
        BackupBeforeNotice backupBeforeNotice = (BackupBeforeNotice) list.get(0);
        NotifyLogger.m29915i("NotificationV2Util", "get NoticeBeforeBackup config success,priority is:" + backupBeforeNotice.getPriority());
        return backupBeforeNotice;
    }

    /* renamed from: s */
    public static void m66716s(ICloudSpaceProxy iCloudSpaceProxy, LinkedHashMap<String, String> linkedHashMap) {
        if (iCloudSpaceProxy == null) {
            NotifyLogger.m29914e("NotificationV2Util", "space proxy is null.");
            return;
        }
        linkedHashMap.put("needBackupSize", String.valueOf(iCloudSpaceProxy.getNeedBackupSize()));
        linkedHashMap.put("availableSize", String.valueOf(iCloudSpaceProxy.getAvailableSize()));
        linkedHashMap.put("usedSize", String.valueOf(iCloudSpaceProxy.getUsedSize()));
    }

    /* renamed from: t */
    public static long m66717t() {
        return System.currentTimeMillis();
    }

    /* renamed from: u */
    public static Date m66718u() {
        return new Date();
    }

    /* renamed from: v */
    public static Date m66719v(SilenceDurationBean silenceDurationBean, String str) throws ParseException {
        new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        Date date = new Date();
        if (m66713p(date, simpleDateFormat.parse(silenceDurationBean.getStartTime()), simpleDateFormat.parse(silenceDurationBean.getEndTime()))) {
            new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(5, 1);
            date = calendar.getTime();
        }
        return m66697S(silenceDurationBean.getEndTime(), date);
    }

    /* renamed from: w */
    public static Date m66720w(List<SilenceDurationBean> list, String str) {
        Date date = new Date();
        if (AbstractC14026a.m84159a(list)) {
            NotifyLogger.m29915i("NotificationV2Util", "get latest notify time beyond silence period error,silencePeriod is null or empty");
            return date;
        }
        m66717t();
        for (SilenceDurationBean silenceDurationBean : list) {
            if (NotifyUtil.checkTimeRange(silenceDurationBean.getStartTime(), silenceDurationBean.getEndTime(), str)) {
                try {
                    date = new Date(m66719v(silenceDurationBean, str).getTime() + 1000);
                } catch (ParseException e10) {
                    NotifyLogger.m29914e("NotificationV2Util", "ParseException exception: " + e10.getMessage());
                }
            }
        }
        return date;
    }

    /* renamed from: x */
    public static long m66721x(int i10, int i11) {
        if (i10 >= i11) {
            NotifyLogger.m29916w("NotificationV2Util", "startHour >= endHour");
            return 0L;
        }
        BackupBeforeNotice backupBeforeNoticeM66715r = m66715r();
        if (backupBeforeNoticeM66715r == null) {
            NotifyLogger.m29914e("NotificationV2Util", "backupBeforeNotice is null");
            return 0L;
        }
        List<SilenceDurationBean> silencePeriod = backupBeforeNoticeM66715r.getSilencePeriod();
        if (AbstractC14026a.m84159a(silencePeriod)) {
            NotifyLogger.m29914e("NotificationV2Util", "silenceDurationBeans is null");
            return 0L;
        }
        Date dateM66718u = m66718u();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar.setTime(dateM66718u);
        calendar2.setTime(dateM66718u);
        calendar3.setTime(dateM66718u);
        calendar.add(11, i10);
        calendar2.add(11, i11);
        Iterator<SilenceDurationBean> it = silencePeriod.iterator();
        long jMin = 0;
        while (it.hasNext()) {
            Date dateM66697S = m66697S(it.next().getStartTime(), m66718u());
            if (m66682D(calendar.getTime(), calendar2.getTime(), dateM66697S)) {
                new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                long time = dateM66697S.getTime() - 30000;
                jMin = jMin == 0 ? time : Math.min(jMin, time);
            }
        }
        return jMin;
    }

    /* renamed from: y */
    public static boolean m66722y(BackupBeforeNotice backupBeforeNotice) {
        if (backupBeforeNotice == null) {
            NotifyLogger.m29914e("NotificationV2Util", "backupBeforeNotice is null");
            return false;
        }
        if (AbstractC14026a.m84159a(backupBeforeNotice.getGradeCode())) {
            NotifyLogger.m29915i("NotificationV2Util", "isGradeCodeSatisfied,backupBeforeNotice is null or empty");
            return true;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e("NotificationV2Util", "spaceProxy is null");
            return false;
        }
        String currentGradeCode = spaceProxy.getCurrentGradeCode("isGradeCodeSatisfied");
        NotifyLogger.m29915i("NotificationV2Util", "current user gradeCode is:" + currentGradeCode);
        if (TextUtils.isEmpty(currentGradeCode)) {
            NotifyLogger.m29915i("NotificationV2Util", "isGradeCodeSatisfied,current gradeCode is empty");
            return false;
        }
        Iterator<String> it = backupBeforeNotice.getGradeCode().iterator();
        while (it.hasNext()) {
            if (currentGradeCode.equals(it.next())) {
                NotifyLogger.m29913d("NotificationV2Util", "gradeCode satisfied:" + currentGradeCode);
                return true;
            }
        }
        NotifyLogger.m29913d("NotificationV2Util", "gradeCode not satisfied");
        return false;
    }

    /* renamed from: z */
    public static boolean m66723z(long j10, long j11) {
        if (j10 <= 0 || j11 <= 0) {
            NotifyLogger.m29914e("NotificationV2Util", "timestamp cannot <= 0");
            return false;
        }
        Date date = new Date(j10);
        Date date2 = new Date(j11);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }
}
