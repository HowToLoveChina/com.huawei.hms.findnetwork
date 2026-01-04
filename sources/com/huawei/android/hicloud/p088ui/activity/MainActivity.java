package com.huawei.android.hicloud.p088ui.activity;

import ae.C0145l1;
import android.R;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ResultReceiver;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bn.C1266d;
import bo.InterfaceC1268b;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.common.task.ClickExchangeTask;
import com.huawei.android.hicloud.commonlib.p079db.bean.JoinShareAlbumRequestInfo;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.hicloud.manager.IconManager;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CampaignActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CouponCenterActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PaymentManagerAndOrderActivity;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.android.hicloud.p088ui.extend.GradientActionBar;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.ObservableScrollView;
import com.huawei.android.hicloud.p088ui.extend.ScrollUpUrgencyView;
import com.huawei.android.hicloud.p088ui.extend.ScrollViewListener;
import com.huawei.android.hicloud.p088ui.extend.UrgencyScrollUpView;
import com.huawei.android.hicloud.p088ui.extend.VipRightsListener;
import com.huawei.android.hicloud.p088ui.fragment.RecommendFragment;
import com.huawei.android.hicloud.p088ui.fragment.SpaceDisplayFragment;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.android.hicloud.p088ui.uiadapter.JoinShareAlbumHeadPicAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.SomeShareAlbumAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.BackupDeviceView;
import com.huawei.android.hicloud.p088ui.uiextend.BackupLinkClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.BasicDataGuideView;
import com.huawei.android.hicloud.p088ui.uiextend.HicloudVerticalItemView;
import com.huawei.android.hicloud.p088ui.uiextend.NewBmBackupItemView;
import com.huawei.android.hicloud.p088ui.uiextend.NoShareAlbumLayoutView;
import com.huawei.android.hicloud.p088ui.uiextend.OneShareAlbumLayoutView;
import com.huawei.android.hicloud.p088ui.uiextend.PhoneFinderView;
import com.huawei.android.hicloud.p088ui.uiextend.StorageManagerCardLayout;
import com.huawei.android.hicloud.p088ui.uiextend.TaskCenterView;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.hicloud.p088ui.uiextend.bean.TaskCenterItem;
import com.huawei.android.hicloud.p088ui.uiextend.bean.VipBaseResourceBean;
import com.huawei.android.hicloud.p088ui.uiextend.bean.VipDiamondResourceBean;
import com.huawei.android.hicloud.p088ui.uiextend.bean.VipGoldResourceBean;
import com.huawei.android.hicloud.p088ui.uiextend.bean.VipPlatinumResourceBean;
import com.huawei.android.hicloud.p088ui.uiextend.bean.VipSilverResourceBean;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.AddToDesktopDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupOptionAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ClaimSpacePopDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CleanCacheDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseSyncDialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmJumpRefurbishDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.HicloudPushGuideDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.MergeAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RefurbishUpgradDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;
import com.huawei.android.hicloud.p088ui.uilistener.CloudSpaceShowDetailsRegionListener;
import com.huawei.android.hicloud.p088ui.views.CampaignEntryFloatView;
import com.huawei.android.hicloud.p088ui.views.ExpirationReminderCardView;
import com.huawei.android.hicloud.p088ui.views.SyncStatusTipsView;
import com.huawei.android.hicloud.p088ui.webview.ToolEcologyWapExternal;
import com.huawei.android.hicloud.safeinfo.bean.LinkContents;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.hicloud.task.simple.C3010a0;
import com.huawei.android.hicloud.task.simple.C3011a1;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.hicloud.task.simple.C3028e2;
import com.huawei.android.hicloud.task.simple.C3037h;
import com.huawei.android.hicloud.task.simple.GetUserAvatarTask;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetRecommendActivityResp;
import com.huawei.cloud.pay.model.JumpInactivePageStatus;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.PayActivityInfo;
import com.huawei.cloud.pay.model.Response;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.p098ui.InactiveUserActivity;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.FeedbackMailProcessor;
import com.huawei.feedback.FeedbackSdkProcessor;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyDetailInfoRetBody;
import com.huawei.hicloud.base.bean.FamilyShareInfoAndDetailResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.ModuleItemForAll;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.BmServiceUpdateInfo;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.bean.GraySwitch;
import com.huawei.hicloud.bean.H5SpaceFullDialogInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.notification.manager.NpsShowManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.manager.UnReadNumManager;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuidPopConfig;
import com.huawei.hicloud.notification.p106db.bean.MainMenuItem;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.notification.p106db.bean.UrgencyGoto;
import com.huawei.hicloud.notification.p106db.bean.UrgencyOnTopParams;
import com.huawei.hicloud.notification.p106db.bean.UrgencyTop;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.notification.util.CampaignCheckUtil;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.ConsentRecord;
import com.huawei.hicloud.request.agreement.request.ConsentRecordWithStatus;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.router.data.ShareAlbumInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import dj.C9158a;
import dj.C9159b;
import dk.EnumC9164e;
import fj.C9713b;
import fj.C9718g;
import fk.C9721b;
import ge.C9908c;
import ge.C9913h;
import gl.C9961b;
import gp.C10028c;
import hu.C10343b;
import huawei.android.widget.ListView;
import ie.C10474a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import je.C10794j;
import je.C10801o;
import je.C10804r;
import je.C10809w;
import mu.C11525b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0223k;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p015ak.C0234s;
import p015ak.C0236u;
import p015ak.C0240y;
import p015ak.C0241z;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1009d;
import p020ap.C1010e;
import p035bk.C1248a;
import p037bp.C1270a;
import p052cb.C1412i;
import p053ce.C1424b;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p232dp.InterfaceC9284c;
import p252e9.C9436m;
import p252e9.C9437n;
import p284fb.C9681b;
import p285fc.C9682a;
import p292fn.C9733f;
import p314gc.C9904a;
import p329h7.C10121i;
import p335hd.C10147j;
import p336he.C10153d;
import p336he.C10155f;
import p336he.C10157h;
import p336he.C10158i;
import p336he.C10161l;
import p341hj.C10270w;
import p364ib.C10465b;
import p373iu.C10620h;
import p387j7.C10718a;
import p399jk.AbstractC10896a;
import p420k7.AlertDialogC11014a;
import p420k7.AlertDialogC11015b;
import p420k7.AlertDialogC11016c;
import p422k9.C11018a;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11075a;
import p431ko.C11077c;
import p446l7.C11256d;
import p446l7.C11257e;
import p446l7.C11258f;
import p450le.C11273b;
import p459lp.C11326d;
import p459lp.C11333k;
import p496nn.C11737b;
import p496nn.InterfaceC11736a;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11838l;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p550pb.C12126b;
import p572qb.C12300b0;
import p572qb.C12312h0;
import p572qb.C12318k0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12571m;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p664u0.C13108a;
import p674ub.C13148e;
import p674ub.C13152i;
import p676ud.AlertDialogC13154a;
import p676ud.AlertDialogC13157d;
import p681uj.C13192i;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13227f;
import p684un.C13229h;
import p684un.C13230i;
import p703v8.C13368e;
import p706vd.C13406a;
import p706vd.C13408c;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p732w8.AsyncTaskC13562m;
import p737wd.AlertDialogC13588a;
import p742wj.C13612b;
import p746wn.C13622a;
import p771xd.HandlerC13763g;
import p778xk.C13823d;
import p778xk.C13826g;
import p782xo.C13842a;
import p783xp.C13843a;
import p805yb.C13933c;
import p807yd.C13950f;
import p815ym.AbstractC14026a;
import p836z8.C14157f;
import p837z9.C14163d;
import p846zj.C14303a;
import p847zk.C14311d;
import p847zk.C14315h;
import p847zk.C14317j;
import pm.C12199z;
import sk.C12806c;
import sk.C12809f;
import sm.C12817a;
import td.C13008a;
import tl.C13026e;
import tm.C13040c;
import vn.C13470b;
import vn.C13471c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class MainActivity extends BaseActivity implements View.OnClickListener, HiCloudItemCheckedChangeListener, DialogCallback, CloseSyncDialogCallback, InterfaceC1268b, CloudSpaceShowDetailsRegionListener, HwBottomNavigationView.BottomNavListener, PopupMenu.OnMenuItemClickListener, PushGuideDialogCallback, Consumer<Location>, ToolEcologyWapExternal.LoadDataListener, AdapterView.OnItemClickListener, SyncItemRecyclerAdapter.OnCheckedChangedListener, SyncItemRecyclerAdapter.OnItemClickListener {

    /* renamed from: w5 */
    public static final List<String> f15168w5 = Arrays.asList(CloudBackupConstant.Command.PMS_CMD_BACKUP, "backup_calendar", "backup_calllog", "backup_sms", "backup_contact", "sync_contact", "sync_ablum", "sync_calendar");

    /* renamed from: x5 */
    public static boolean f15169x5 = false;

    /* renamed from: A */
    public BackupDeviceView f15170A;

    /* renamed from: A0 */
    public View f15171A0;

    /* renamed from: A4 */
    public TextView f15174A4;

    /* renamed from: B */
    public ExpirationReminderCardView f15175B;

    /* renamed from: B0 */
    public RecommendFragment f15176B0;

    /* renamed from: B1 */
    public boolean f15177B1;

    /* renamed from: B3 */
    public com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView f15178B3;

    /* renamed from: B4 */
    public C3378q0 f15179B4;

    /* renamed from: C */
    public NotchFitLinearLayout f15180C;

    /* renamed from: C0 */
    public ImageView f15181C0;

    /* renamed from: C1 */
    public C10718a f15182C1;

    /* renamed from: C3 */
    public List<String> f15183C3;

    /* renamed from: C4 */
    public CampaignEntryFloatView f15184C4;

    /* renamed from: D */
    public NewBmBackupItemView f15185D;

    /* renamed from: D0 */
    public SpaceDisplayFragment f15186D0;

    /* renamed from: D4 */
    public HandlerC3357g1 f15189D4;

    /* renamed from: E */
    public RelativeLayout f15190E;

    /* renamed from: E0 */
    public SyncStatusTipsView f15191E0;

    /* renamed from: E4 */
    public boolean f15194E4;

    /* renamed from: F */
    public boolean f15195F;

    /* renamed from: F0 */
    public RelativeLayout f15196F0;

    /* renamed from: F1 */
    public boolean f15197F1;

    /* renamed from: F4 */
    public long f15199F4;

    /* renamed from: G */
    public boolean f15200G;

    /* renamed from: G0 */
    public RelativeLayout f15201G0;

    /* renamed from: G1 */
    public View f15202G1;

    /* renamed from: G4 */
    public SomeShareAlbumAdapter f15204G4;

    /* renamed from: H */
    public int f15205H;

    /* renamed from: H0 */
    public LinearLayout f15206H0;

    /* renamed from: H1 */
    public View f15207H1;

    /* renamed from: H3 */
    public int f15208H3;

    /* renamed from: I */
    public ArrayList<RecommendCard> f15210I;

    /* renamed from: I0 */
    public RelativeLayout f15211I0;

    /* renamed from: I1 */
    public RelativeLayout f15212I1;

    /* renamed from: I3 */
    public View f15213I3;

    /* renamed from: I4 */
    public boolean f15214I4;

    /* renamed from: J */
    public SyncItemInfo f15215J;

    /* renamed from: J1 */
    public TextView f15217J1;

    /* renamed from: J4 */
    public FamilyShareInfoResult f15219J4;

    /* renamed from: K */
    public SyncItemInfo f15220K;

    /* renamed from: K1 */
    public TextView f15222K1;

    /* renamed from: K4 */
    public String f15224K4;

    /* renamed from: L */
    public SyncItemInfo f15225L;

    /* renamed from: L1 */
    public RelativeLayout f15227L1;

    /* renamed from: L4 */
    public IconManager f15229L4;

    /* renamed from: M */
    public SyncItemInfo f15230M;

    /* renamed from: M0 */
    public NetworkChangeReceiver f15231M0;

    /* renamed from: M1 */
    public RelativeLayout f15232M1;

    /* renamed from: M3 */
    public View f15233M3;

    /* renamed from: M4 */
    public String f15234M4;

    /* renamed from: N */
    public SyncItemInfo f15235N;

    /* renamed from: N1 */
    public RelativeLayout f15237N1;

    /* renamed from: N3 */
    public View f15238N3;

    /* renamed from: O */
    public SyncItemInfo f15240O;

    /* renamed from: O0 */
    public RefreshJoinAlbumBroadcastReceiver f15241O0;

    /* renamed from: O1 */
    public RelativeLayout f15242O1;

    /* renamed from: O3 */
    public View f15243O3;

    /* renamed from: P */
    public SyncItemInfo f15245P;

    /* renamed from: P1 */
    public boolean f15247P1;

    /* renamed from: P3 */
    public boolean f15248P3;

    /* renamed from: Q */
    public TaskCenterView f15250Q;

    /* renamed from: Q1 */
    public boolean f15252Q1;

    /* renamed from: Q3 */
    public boolean f15253Q3;

    /* renamed from: Q4 */
    public SyncItemRecyclerAdapter f15254Q4;

    /* renamed from: R */
    public NotchFitRelativeLayout f15255R;

    /* renamed from: R1 */
    public boolean f15257R1;

    /* renamed from: R3 */
    public boolean f15258R3;

    /* renamed from: R4 */
    public HwRecyclerView f15259R4;

    /* renamed from: S */
    public RelativeLayout f15260S;

    /* renamed from: S1 */
    public boolean f15262S1;

    /* renamed from: S3 */
    public boolean f15263S3;

    /* renamed from: S4 */
    public C1424b f15264S4;

    /* renamed from: T */
    public HwButton f15265T;

    /* renamed from: T1 */
    public TipPopupLayout f15267T1;

    /* renamed from: T3 */
    public boolean f15268T3;

    /* renamed from: T4 */
    public C1424b f15269T4;

    /* renamed from: U */
    public NotchFitRelativeLayout f15270U;

    /* renamed from: U1 */
    public boolean f15272U1;

    /* renamed from: U3 */
    public Location f15273U3;

    /* renamed from: U4 */
    public View f15274U4;

    /* renamed from: V */
    public RelativeLayout f15275V;

    /* renamed from: V0 */
    public RefurbishUpgradDialog f15276V0;

    /* renamed from: V3 */
    public float f15278V3;

    /* renamed from: V4 */
    public View f15279V4;

    /* renamed from: W */
    public SpanClickText f15280W;

    /* renamed from: W1 */
    public UrgencyScrollUpView f15282W1;

    /* renamed from: W3 */
    public CleanCacheDialog f15283W3;

    /* renamed from: X1 */
    public String f15287X1;

    /* renamed from: X3 */
    public View f15288X3;

    /* renamed from: X4 */
    public HashMap<String, String> f15289X4;

    /* renamed from: Y3 */
    public SafeWebView f15293Y3;

    /* renamed from: Z */
    public PhoneFinderView f15295Z;

    /* renamed from: Z0 */
    public CutOutProgressDialog f15296Z0;

    /* renamed from: Z1 */
    public PopupWindow f15297Z1;

    /* renamed from: Z3 */
    public NotchFitRelativeLayout f15298Z3;

    /* renamed from: a0 */
    public NotchFitRelativeLayout f15300a0;

    /* renamed from: a2 */
    public ListView f15302a2;

    /* renamed from: a4 */
    public NotchFitLinearLayout f15303a4;

    /* renamed from: b0 */
    public LinearLayout f15305b0;

    /* renamed from: b1 */
    public int f15306b1;

    /* renamed from: b2 */
    public LinearLayout f15307b2;

    /* renamed from: b4 */
    public NotchFitLinearLayout f15308b4;

    /* renamed from: c0 */
    public TextView f15310c0;

    /* renamed from: c1 */
    public HiCloudExceptionView f15311c1;

    /* renamed from: c2 */
    public C0145l1 f15312c2;

    /* renamed from: c4 */
    public HwColumnLinearLayout f15313c4;

    /* renamed from: d2 */
    public HicloudPushGuideDialog f15317d2;

    /* renamed from: d4 */
    public TextView f15318d4;

    /* renamed from: d5 */
    public Object f15319d5;

    /* renamed from: e0 */
    public LinearLayout f15320e0;

    /* renamed from: e2 */
    public Calendar f15322e2;

    /* renamed from: e4 */
    public AutoSizeButton f15323e4;

    /* renamed from: f0 */
    public RelativeLayout f15325f0;

    /* renamed from: f4 */
    public TextView f15327f4;

    /* renamed from: g0 */
    public GradientActionBar f15329g0;

    /* renamed from: g1 */
    public AlertDialogC13157d f15330g1;

    /* renamed from: g4 */
    public String f15331g4;

    /* renamed from: h1 */
    public C13950f f15334h1;

    /* renamed from: h4 */
    public String f15335h4;

    /* renamed from: i0 */
    public NotchFitRelativeLayout f15337i0;

    /* renamed from: i1 */
    public boolean f15338i1;

    /* renamed from: j0 */
    public NotchFitRelativeLayout f15341j0;

    /* renamed from: j1 */
    public boolean f15342j1;

    /* renamed from: k0 */
    public LinearLayout f15345k0;

    /* renamed from: l0 */
    public LinearLayout f15349l0;

    /* renamed from: l4 */
    public String f15351l4;

    /* renamed from: m0 */
    public LinearLayout f15353m0;

    /* renamed from: m4 */
    public ValueCallback<Uri[]> f15355m4;

    /* renamed from: n0 */
    public NotchFitLinearLayout f15357n0;

    /* renamed from: n4 */
    public View f15359n4;

    /* renamed from: o0 */
    public NotchFitLinearLayout f15361o0;

    /* renamed from: o4 */
    public HwButton f15363o4;

    /* renamed from: p0 */
    public NotchFitLinearLayout f15366p0;

    /* renamed from: p4 */
    public RelativeLayout f15368p4;

    /* renamed from: q */
    public AddToDesktopDialog f15370q;

    /* renamed from: q0 */
    public NotchFitRelativeLayout f15371q0;

    /* renamed from: q4 */
    public LinearLayout f15373q4;

    /* renamed from: r */
    public List<String> f15375r;

    /* renamed from: r0 */
    public NotchFitRelativeLayout f15376r0;

    /* renamed from: r4 */
    public LinearLayout f15378r4;

    /* renamed from: s0 */
    public NotchFitLinearLayout f15381s0;

    /* renamed from: s4 */
    public TextView f15383s4;

    /* renamed from: t0 */
    public NotchFitLinearLayout f15386t0;

    /* renamed from: t4 */
    public TextView f15388t4;

    /* renamed from: t5 */
    public GetClientUIConfigResp f15389t5;

    /* renamed from: u0 */
    public BasicDataGuideView f15391u0;

    /* renamed from: u4 */
    public NoShareAlbumLayoutView f15393u4;

    /* renamed from: u5 */
    public Response f15394u5;

    /* renamed from: v4 */
    public OneShareAlbumLayoutView f15398v4;

    /* renamed from: v5 */
    public UserPackage f15399v5;

    /* renamed from: w0 */
    public Bitmap f15401w0;

    /* renamed from: w4 */
    public LinearLayout f15403w4;

    /* renamed from: x0 */
    public View f15405x0;

    /* renamed from: x3 */
    public NotchFitRelativeLayout f15407x3;

    /* renamed from: x4 */
    public RecyclerView f15408x4;

    /* renamed from: y0 */
    public View f15410y0;

    /* renamed from: y3 */
    public StorageManagerCardLayout f15412y3;

    /* renamed from: y4 */
    public RecyclerView f15413y4;

    /* renamed from: z0 */
    public View f15415z0;

    /* renamed from: z4 */
    public AlertDialogC13588a f15418z4;

    /* renamed from: p */
    public volatile JumpInactivePageStatus f15365p = JumpInactivePageStatus.DATA_NOT_READY;

    /* renamed from: s */
    public volatile boolean f15380s = false;

    /* renamed from: t */
    public volatile long f15385t = 0;

    /* renamed from: u */
    public String f15390u = "";

    /* renamed from: v */
    public String f15395v = "";

    /* renamed from: w */
    public String f15400w = "";

    /* renamed from: x */
    public String f15404x = "";

    /* renamed from: y */
    public String f15409y = "";

    /* renamed from: z */
    public Activity f15414z = null;

    /* renamed from: X */
    public NotchFitLinearLayout f15285X = null;

    /* renamed from: Y */
    public ObservableScrollView f15290Y = null;

    /* renamed from: d0 */
    public TextView f15315d0 = null;

    /* renamed from: h0 */
    public int f15333h0 = 0;

    /* renamed from: v0 */
    public ArrayList<View> f15396v0 = new ArrayList<>();

    /* renamed from: J0 */
    public HiSyncReceiver f15216J0 = null;

    /* renamed from: K0 */
    public UrgencyReceiver f15221K0 = null;

    /* renamed from: L0 */
    public StFixedReceiver f15226L0 = null;

    /* renamed from: N0 */
    public BroadcastReceiver f15236N0 = null;

    /* renamed from: P0 */
    public AlertDialog f15246P0 = null;

    /* renamed from: Q0 */
    public HashMap<String, MergeAlertDialog> f15251Q0 = new HashMap<>();

    /* renamed from: R0 */
    public ClaimSpacePopDialog f15256R0 = null;

    /* renamed from: S0 */
    public AlertDialog f15261S0 = null;

    /* renamed from: T0 */
    public Dialog f15266T0 = null;

    /* renamed from: U0 */
    public ConfirmJumpRefurbishDialog f15271U0 = null;

    /* renamed from: W0 */
    public Dialog f15281W0 = null;

    /* renamed from: X0 */
    public Dialog f15286X0 = null;

    /* renamed from: Y0 */
    public AlertDialogC13154a f15291Y0 = null;

    /* renamed from: a1 */
    public int f15301a1 = -2;

    /* renamed from: d1 */
    public boolean f15316d1 = false;

    /* renamed from: e1 */
    public boolean f15321e1 = false;

    /* renamed from: f1 */
    public C10028c f15326f1 = null;

    /* renamed from: k1 */
    public boolean f15346k1 = true;

    /* renamed from: l1 */
    public AlertDialogC11016c f15350l1 = null;

    /* renamed from: m1 */
    public AlertDialogC11015b f15354m1 = null;

    /* renamed from: n1 */
    public AlertDialogC11014a f15358n1 = null;

    /* renamed from: o1 */
    public boolean f15362o1 = false;

    /* renamed from: p1 */
    public boolean f15367p1 = false;

    /* renamed from: q1 */
    public boolean f15372q1 = false;

    /* renamed from: r1 */
    public boolean f15377r1 = false;

    /* renamed from: s1 */
    public boolean f15382s1 = false;

    /* renamed from: t1 */
    public boolean f15387t1 = false;

    /* renamed from: u1 */
    public boolean f15392u1 = false;

    /* renamed from: v1 */
    public boolean f15397v1 = false;

    /* renamed from: w1 */
    public boolean f15402w1 = false;

    /* renamed from: x1 */
    public boolean f15406x1 = false;

    /* renamed from: y1 */
    public boolean f15411y1 = true;

    /* renamed from: z1 */
    public boolean f15416z1 = true;

    /* renamed from: A1 */
    public boolean f15172A1 = true;

    /* renamed from: D1 */
    public C3392x0 f15187D1 = new C3392x0(this, null);

    /* renamed from: E1 */
    public List<HicloudVerticalItemView> f15192E1 = new ArrayList();

    /* renamed from: V1 */
    public List<UrgencyOnTopParams> f15277V1 = new ArrayList();

    /* renamed from: Y1 */
    public C10804r f15292Y1 = null;

    /* renamed from: z3 */
    public boolean f15417z3 = false;

    /* renamed from: A3 */
    public int f15173A3 = 1;

    /* renamed from: D3 */
    public List<Map<String, Object>> f15188D3 = new ArrayList();

    /* renamed from: E3 */
    public boolean f15193E3 = false;

    /* renamed from: F3 */
    public boolean f15198F3 = false;

    /* renamed from: G3 */
    public boolean f15203G3 = false;

    /* renamed from: J3 */
    public C3382s0 f15218J3 = new C3382s0();

    /* renamed from: K3 */
    public C3360h1 f15223K3 = new C3360h1();

    /* renamed from: L3 */
    public boolean f15228L3 = false;

    /* renamed from: i4 */
    public boolean f15339i4 = false;

    /* renamed from: j4 */
    public boolean f15343j4 = false;

    /* renamed from: k4 */
    public boolean f15347k4 = false;

    /* renamed from: H4 */
    public List<String> f15209H4 = new ArrayList();

    /* renamed from: N4 */
    public LinkedHashMap<String, SyncItemInfo> f15239N4 = new LinkedHashMap<>();

    /* renamed from: O4 */
    public CopyOnWriteArrayList<SyncItemInfo> f15244O4 = new CopyOnWriteArrayList<>();

    /* renamed from: P4 */
    public CopyOnWriteArrayList<SyncItemInfo> f15249P4 = new CopyOnWriteArrayList<>();

    /* renamed from: W4 */
    public C11077c f15284W4 = new C11077c(new C3365k());

    /* renamed from: Y4 */
    public AbstractC12367d f15294Y4 = new C3385u();

    /* renamed from: Z4 */
    public Handler f15299Z4 = new HandlerC3366k0(Looper.getMainLooper());

    /* renamed from: a5 */
    public Handler f15304a5 = new HandlerC3368l0();

    /* renamed from: b5 */
    public Handler f15309b5 = new HandlerC3370m0();

    /* renamed from: c5 */
    public Messenger f15314c5 = new Messenger(this.f15309b5);

    /* renamed from: e5 */
    public Handler f15324e5 = new HandlerC3354f1();

    /* renamed from: f5 */
    public Runnable f15328f5 = new RunnableC3340b();

    /* renamed from: g5 */
    public Runnable f15332g5 = new RunnableC3343c();

    /* renamed from: h5 */
    public Runnable f15336h5 = new RunnableC3346d();

    /* renamed from: i5 */
    public Runnable f15340i5 = new RunnableC3349e();

    /* renamed from: j5 */
    public Runnable f15344j5 = new RunnableC3352f();

    /* renamed from: k5 */
    public Runnable f15348k5 = new RunnableC3355g();

    /* renamed from: l5 */
    public Runnable f15352l5 = new RunnableC3358h();

    /* renamed from: m5 */
    public Handler.Callback f15356m5 = new C3361i();

    /* renamed from: n5 */
    public String f15360n5 = "1";

    /* renamed from: o5 */
    public String f15364o5 = "100";

    /* renamed from: p5 */
    public HandlerC3386u0 f15369p5 = new HandlerC3386u0(this);

    /* renamed from: q5 */
    public HandlerC13763g f15374q5 = new HandlerC13763g(this);

    /* renamed from: r5 */
    public Handler f15379r5 = new HandlerC3347d0();

    /* renamed from: s5 */
    public Handler f15384s5 = new HandlerC3356g0();

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$26 */
    public class C333626 extends WebChromeClient {
        public C333626() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            C11839m.m70688i("MainActivity", "tool onProgressChanged newProgress =" + i10);
            MainActivity.this.m21268S4();
            if (i10 != 100) {
                MainActivity.this.m21395i8(webView, false);
            } else {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.m21395i8(webView, mainActivity.f15343j4);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            C11839m.m70688i("MainActivity", "onReceivedTitle");
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            C11839m.m70688i("MainActivity", "onActivityResult onShowFileChooser");
            MainActivity.this.f15355m4 = valueCallback;
            return MainActivity.this.m22373g1();
        }
    }

    public class HiSyncReceiver extends BroadcastReceiver {
        public HiSyncReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (intent == null) {
                return;
            }
            MainActivity.this.m21294V8(context, new SafeIntent(intent));
        }
    }

    public class NetworkChangeReceiver extends BroadcastReceiver {
        public NetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NotchFitLinearLayout notchFitLinearLayout;
            if (intent == null || context == null) {
                C11839m.m70688i("MainActivity", "NetworkChangeReceiver return");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            C11839m.m70688i("MainActivity", "NetworkChangeReceiver action =" + action);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                boolean zM1333z1 = C0209d.m1333z1(context);
                boolean z10 = C2783d.m16159m() == 1;
                if (!zM1333z1 && (notchFitLinearLayout = MainActivity.this.f15303a4) != null && notchFitLinearLayout.getVisibility() == 8 && z10) {
                    C11841o.m70707c(MainActivity.this, R$string.invite_family_member_failed_net_disable, 0);
                }
                MainActivity.this.m21437o5();
            }
        }
    }

    public class RefreshJoinAlbumBroadcastReceiver extends BroadcastReceiver {
        public RefreshJoinAlbumBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = new SafeIntent(intent).getAction();
            if ("com.huawei.hicloud.join.share.album.refresh".equals(action)) {
                C11839m.m70688i("MainActivity", "RefreshJoinAlbumBroadcastReceiver ACTION_REFRESH_JOIN_SHARE_ALBUM_INFO");
                ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58397U0(MainActivity.this.f15384s5);
            } else if ("com.huawei.hidisk.action.ALBUM_CLIENT_MESSAGE_SYNC_COMPLETE".equals(action)) {
                C11839m.m70688i("MainActivity", "RefreshJoinAlbumBroadcastReceiver ALBUM_CLIENT_MESSAGE_SYNC_COMPLETE");
                ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58397U0(MainActivity.this.f15384s5);
            }
        }
    }

    public class StFixedReceiver extends BroadcastReceiver {
        public StFixedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.huawei.hicloud.ST_FIXED".equals(new SafeIntent(intent).getAction())) {
                C11839m.m70688i("MainActivity", "receive st fixed broadcast");
                MainActivity.this.f15347k4 = false;
                MainActivity mainActivity = MainActivity.this;
                mainActivity.m21350cc(mainActivity.f15293Y3, mainActivity.f15331g4, MainActivity.this.f15417z3);
            }
        }
    }

    public class UrgencyReceiver extends BroadcastReceiver {
        public UrgencyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if ("notify_urgency_top_banner".equals(safeIntent.getAction())) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("Receive urgency broadcast", String.valueOf("MainActivity:notify_urgency_top_banner,Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("Receive urgency broadcast", linkedHashMap);
                MainActivity.this.m21281Tb(safeIntent);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$a */
    public class C3337a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f15424a;

        public C3337a(String str) {
            this.f15424a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b, NumberFormatException {
            String strM80790C = C13452e.m80781L().m80790C();
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.grade");
            arrayList.add("bs.dsu.cloud.free");
            long j10 = 0;
            try {
                for (C4987f c4987f : C14157f.m84942g().m84949i(null, arrayList, "ShowSpaceFull")) {
                    if (c4987f != null) {
                        if (TextUtils.equals("bs.grade", c4987f.m30026b())) {
                            strM80790C = c4987f.m30027c();
                            C13452e.m80781L().m80940l1(strM80790C);
                        }
                        if (TextUtils.equals("bs.dsu.cloud.free", c4987f.m30026b())) {
                            j10 = Long.parseLong(c4987f.m30027c());
                        }
                    }
                }
            } catch (Exception e10) {
                C11839m.m70687e("MainActivity", "toShowSpaceFullDialog occur err: " + e10.getMessage());
            }
            final String str = strM80790C;
            final long j11 = j10;
            C11839m.m70688i("MainActivity", "gradeCode: " + str + ", finalGradeCode = " + str + ", finalFreeSpace = " + j11);
            final String str2 = this.f15424a;
            C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.v6
                @Override // java.lang.Runnable
                public final void run() throws SecurityException {
                    this.f17775a.m21536d(str, j11, str2);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m21536d(String str, long j10, String str2) throws SecurityException {
            boolean zM1245d1 = C0209d.m1245d1(MainActivity.this.f15414z, MainActivity.class.getName());
            MainActivity.this.m21295V9(str, j10, zM1245d1);
            if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)) {
                C11839m.m70688i("MainActivity", "basic business, not need show dialog");
                MainActivity.this.f15292Y1.m65764k(str2);
                MainActivity.this.f15377r1 = false;
            } else if (!MainActivity.this.m21298W4() || !MainActivity.this.m21237O4() || !C11333k.m68086b().m68091f(j10)) {
                C11839m.m70688i("MainActivity", "toShowSpaceFullDialog, space is not full.");
                MainActivity.this.f15292Y1.m65764k(str2);
                MainActivity.this.f15377r1 = false;
            } else if (zM1245d1) {
                C11839m.m70688i("MainActivity", "spacefulldialog,activity is foreground");
                MainActivity.this.m21250Pb(str2);
            } else {
                C11839m.m70688i("MainActivity", "toShowSpaceFullDialog,mShowFullDialogLater set true");
                MainActivity.this.f15377r1 = true;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$a0 */
    public class RunnableC3338a0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f15426a;

        public RunnableC3338a0(String str) {
            this.f15426a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f15254Q4 != null) {
                MainActivity.this.f15254Q4.m25287c0(this.f15426a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$a1 */
    public class C3339a1 extends ClickableSpan {

        /* renamed from: a */
        public boolean f15428a = false;

        /* renamed from: b */
        public Context f15429b;

        public C3339a1(Context context) {
            this.f15429b = context;
        }

        /* renamed from: a */
        public void m21537a(boolean z10) {
            this.f15428a = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            MainActivity.this.m21072ma();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f15429b.getResources().getColor(R$color.emui_functional_blue));
            textPaint.bgColor = this.f15429b.getResources().getColor(this.f15428a ? R$color.emui9_list_seletor_color : R$color.transparent);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$b */
    public class RunnableC3340b implements Runnable {
        public RunnableC3340b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
                return;
            }
            MainActivity.this.m21408k7();
            MainActivity.this.m21140Cc();
            C12515a.m75110o().m75172d(MainActivity.this.f15187D1);
            C13227f.m79492i1().m79598v0(MainActivity.this, new SafeIntent(MainActivity.this.getIntent()), "MainActivity");
            MainActivity.this.m21311X9();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$b0 */
    public class RunnableC3341b0 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f15432a;

        public RunnableC3341b0(String str) {
            this.f15432a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f15254Q4 != null) {
                MainActivity.this.f15254Q4.m25286b0(this.f15432a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$b1 */
    public class C3342b1 extends LinkMovementMethod {

        /* renamed from: a */
        public C3339a1 f15434a;

        public C3342b1() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            this.f15434a = MainActivity.this.m21315Y5(textView, spannable, motionEvent);
            if (motionEvent.getAction() == 0) {
                C11839m.m70688i("MainActivity", "MyLinkMovementMethod email on click");
                if (this.f15434a != null) {
                    C11839m.m70688i("MainActivity", "mClickSpan is not null");
                    this.f15434a.m21537a(true);
                }
            } else if (2 == motionEvent.getAction()) {
                C3339a1 c3339a1M21315Y5 = MainActivity.this.m21315Y5(textView, spannable, motionEvent);
                C3339a1 c3339a1 = this.f15434a;
                if (c3339a1 != null && c3339a1M21315Y5 != c3339a1) {
                    c3339a1.m21537a(false);
                    this.f15434a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                C3339a1 c3339a12 = this.f15434a;
                if (c3339a12 == null) {
                    return true;
                }
                c3339a12.m21537a(false);
                this.f15434a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }

        public /* synthetic */ C3342b1(MainActivity mainActivity, C3365k c3365k) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$c */
    public class RunnableC3343c implements Runnable {
        public RunnableC3343c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
            } else {
                MainActivity.this.m21496v5();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$c0 */
    public class C3344c0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f15437a;

        public C3344c0(String str) {
            this.f15437a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("MainActivity", "getUserInfoSuccess set login user name in sub thread");
            long jCurrentTimeMillis = System.currentTimeMillis();
            C13452e.m80781L().m80949n2(this.f15437a);
            C11839m.m70688i("MainActivity", "setLoginUserName take time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$c1 */
    public class C3345c1 implements ScrollViewListener {
        public C3345c1() {
        }

        @Override // com.huawei.android.hicloud.p088ui.extend.ScrollViewListener
        /* renamed from: a */
        public void mo21540a() {
            C11839m.m70686d("MainActivity", "onScrollBegin");
            MainActivity.this.f15198F3 = false;
        }

        @Override // com.huawei.android.hicloud.p088ui.extend.ScrollViewListener
        /* renamed from: b */
        public void mo21541b() {
            C11839m.m70686d("MainActivity", "onScrollEnd");
            final MainActivity mainActivity = MainActivity.this;
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.c7
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.m20995Q3(mainActivity);
                }
            }, 500L);
        }

        @Override // com.huawei.android.hicloud.p088ui.extend.ScrollViewListener
        /* renamed from: c */
        public void mo21542c(int i10) {
            MainActivity.this.f15333h0 = i10;
            MainActivity.this.m21440o8(i10);
        }

        public /* synthetic */ C3345c1(MainActivity mainActivity, C3365k c3365k) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$d */
    public class RunnableC3346d implements Runnable {
        public RunnableC3346d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
                return;
            }
            C11839m.m70686d("MainActivity", "start initStorageDataViewUnSupportTask");
            boolean zM16151j0 = C2783d.m16151j0();
            MainActivity.this.m21379g7(C2783d.m16139f0(), zM16151j0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$d0 */
    public class HandlerC3347d0 extends Handler {
        public HandlerC3347d0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 20002) {
                C11839m.m70688i("MainActivity", "NOTIFY_SYNC_ITEM_FRESH");
                MainActivity.this.m21432n8();
            } else {
                C11839m.m70687e("MainActivity", "commonHandler invalid message :" + message.what);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$d1 */
    public class C3348d1 extends C12817a {
        public C3348d1() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C11839m.m70688i("MainActivity", "onPageStarted");
            if (!C10794j.m65675b(str, new ArrayList(), true)) {
                MainActivity.this.m21297Vb();
                return;
            }
            if (MainActivity.this.f15417z3) {
                MainActivity.this.m21233N9();
            }
            NotchFitLinearLayout notchFitLinearLayout = MainActivity.this.f15308b4;
            if (notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) {
                if (C2783d.m16159m() == 1 && MainActivity.this.f15347k4) {
                    MainActivity.this.f15308b4.setVisibility(0);
                } else {
                    MainActivity.this.f15308b4.setVisibility(8);
                }
            }
            if (C10794j.m65685l(str) || webView == null) {
                super.onPageStarted(webView, str, bitmap);
                return;
            }
            C11839m.m70687e("MainActivity", "onPageStarted url is invalid");
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).m53595d(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (!webResourceRequest.isForMainFrame()) {
                C11839m.m70687e("MainActivity", "onReceivedHttpError is not main frame");
                return;
            }
            int statusCode = webResourceResponse.getStatusCode();
            String strM65677d = C10794j.m65677d(webResourceRequest.getUrl());
            C11839m.m70688i("MainActivity", "onReceivedHttpError url is:" + strM65677d + ",errorCode is:" + statusCode);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, Integer.valueOf(statusCode));
            linkedHashMap.put("currentPage", "tool");
            linkedHashMap.put("errorUrl", strM65677d);
            C13230i.m79498B0(linkedHashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C11839m.m70688i("MainActivity", "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, MainActivity.this);
            } catch (Exception e10) {
                C11839m.m70687e("MainActivity", "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C11839m.m70688i("MainActivity", "shouldOverrideUrlLoading");
            if (!C10794j.m65675b(str, new ArrayList(), true)) {
                MainActivity.this.m21297Vb();
                return false;
            }
            NotchFitLinearLayout notchFitLinearLayout = MainActivity.this.f15308b4;
            if (notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) {
                if (C2783d.m16159m() == 1 && MainActivity.this.f15347k4) {
                    MainActivity.this.f15308b4.setVisibility(0);
                } else {
                    MainActivity.this.f15308b4.setVisibility(8);
                }
            }
            if (webView == null) {
                C11839m.m70687e("MainActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e("MainActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            C10794j.m65686m(MainActivity.this, str);
            return true;
        }

        public /* synthetic */ C3348d1(MainActivity mainActivity, C3365k c3365k) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$e */
    public class RunnableC3349e implements Runnable {
        public RunnableC3349e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
                return;
            }
            C11839m.m70686d("MainActivity", "start initStorageDataViewSupportTask");
            boolean zM16151j0 = C2783d.m16151j0();
            boolean zM16139f0 = C2783d.m16139f0();
            MainActivity.this.m21484ta(zM16139f0, zM16151j0);
            MainActivity.this.m21379g7(zM16139f0, zM16151j0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$e0 */
    public class C3350e0 extends AbstractC12367d {
        public C3350e0() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            MainActivity.this.f15173A3 = 1;
            if (MainActivity.this.f15417z3) {
                MainActivity.m21022Y3(MainActivity.this);
            }
            Resources resources = MainActivity.this.getResources();
            if (resources == null) {
                return;
            }
            if (MainActivity.this.f15173A3 == 1) {
                C11839m.m70688i("MainActivity", "tabSize == 1 hide bottom tab");
                return;
            }
            final Drawable[] drawableArrM20992P5 = MainActivity.m20992P5(resources, MainActivity.this.f15417z3);
            final String[] strArrM20996Q5 = MainActivity.m20996Q5(resources, MainActivity.this.f15417z3);
            Resources resources2 = MainActivity.this.getResources();
            MainActivity.this.f15183C3 = new ArrayList();
            MainActivity.this.f15183C3.add(resources2.getString(R$string.HiCloud_app_name));
            if (MainActivity.this.f15417z3) {
                MainActivity.this.f15183C3.add(resources2.getString(R$string.tool_tab));
            }
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.y6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17821a.m21544d(strArrM20996Q5, drawableArrM20992P5);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m21544d(String[] strArr, Drawable[] drawableArr) {
            for (int i10 = 0; i10 < MainActivity.this.f15173A3; i10++) {
                if (!MainActivity.this.f15178B3.addMenu((CharSequence) strArr[i10], drawableArr[i10], false)) {
                    C11839m.m70687e("MainActivity", "add bottomTab error");
                }
            }
            MainActivity.this.f15178B3.setBottomNavListener(MainActivity.this);
            MainActivity.this.f15178B3.setItemChecked(0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$e1 */
    public static class C3351e1 extends BroadcastReceiver {

        /* renamed from: a */
        public Set<String> f15444a;

        public C3351e1(LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
            this.f15444a = linkedHashMap.keySet();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws Throwable {
            if (intent == null) {
                C11839m.m70688i("MainActivity", "intent is empty");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
                C11839m.m70688i("MainActivity", "action:" + action + " is not ACTION_PACKAGE_REMOVED");
                return;
            }
            boolean zM80887a1 = C13452e.m80781L().m80887a1();
            boolean zM80791C0 = C13452e.m80781L().m80791C0();
            if (!zM80887a1 || zM80791C0) {
                C11839m.m70688i("MainActivity", "is not Cloud+ plan");
                return;
            }
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                ArrayList<SyncConfigService> notShownSyncServiceItems = NotifyUtil.getNotShownSyncServiceItems(context);
                List<String> listM6037B = C1008c.m6035v().m6037B(context);
                if (this.f15444a.isEmpty() || listM6037B.size() < 1) {
                    C11839m.m70688i("MainActivity", "shownSyncItems or fullAppNames is empty");
                    return;
                }
                Iterator<SyncConfigService> it = notShownSyncServiceItems.iterator();
                while (it.hasNext()) {
                    SyncConfigService next = it.next();
                    if (this.f15444a.contains(next.getId()) && listM6037B.contains(next.getId())) {
                        boolean zM62388s = C10028c.m62182c0().m62388s(next.getId());
                        C10028c.m62182c0().m62245M2(next.getId(), Integer.valueOf(zM62388s ? 1 : 0));
                        C11839m.m70688i("MainActivity", "package_removed appName: " + next.getId() + ", switchStatus:" + zM62388s);
                    }
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$f */
    public class RunnableC3352f implements Runnable {
        public RunnableC3352f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
                return;
            }
            C11839m.m70686d("MainActivity", "start getUsetCountTask");
            int badgeCount = MessageCenterManager.getInstance().getBadgeCount();
            C11839m.m70686d("MainActivity", "get messageNum:" + badgeCount);
            MainActivity.this.f15329g0.m23949k(badgeCount);
            UnReadNumManager.getInstance().refreshLauncherIconInTask(badgeCount);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$f0 */
    public class C3353f0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ BmServiceUpdateInfo f15446a;

        public C3353f0(BmServiceUpdateInfo bmServiceUpdateInfo) {
            this.f15446a = bmServiceUpdateInfo;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C0212e0.m1365o(C0213f.m1377a(), "sp_cloud_service_update", "key_show_cloud_service_update_red_hot", false);
            C0212e0.m1368r(C0213f.m1377a(), "sp_cloud_service_update", "key_cloud_service_update_version", Integer.parseInt(C0240y.m1680b(C0213f.m1377a(), "com.huawei.hidisk")));
            final BmServiceUpdateInfo bmServiceUpdateInfo = this.f15446a;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.w6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17790a.m21546d(bmServiceUpdateInfo);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m21546d(BmServiceUpdateInfo bmServiceUpdateInfo) {
            C13227f.m79492i1().m79585f0("mecloud_cloud_service_update_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloud_service_update_click", "1", "4");
            MainActivity.this.m21135C7(bmServiceUpdateInfo.getUrl());
            MainActivity.this.m21274Sa();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$f1 */
    public static class HandlerC3354f1 extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$g */
    public class RunnableC3355g implements Runnable {
        public RunnableC3355g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
            } else {
                C11839m.m70686d("MainActivity", "start initSwitchStatusTask");
                MainActivity.this.m21386h7();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$g0 */
    public class HandlerC3356g0 extends Handler {
        public HandlerC3356g0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1017) {
                MainActivity.this.m21235Nb(message.obj);
            }
            switch (i10) {
                case FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED /* 1011 */:
                    MainActivity.this.m21190Ib(message.obj);
                    break;
                case FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN /* 1012 */:
                    MainActivity.this.m21157Eb(message.obj);
                    break;
                case FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH /* 1013 */:
                    MainActivity.this.m21430n6(message.obj);
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$g1 */
    public static class HandlerC3357g1 extends Handler {

        /* renamed from: a */
        public final WeakReference<MainActivity> f15450a;

        public HandlerC3357g1(MainActivity mainActivity) {
            this.f15450a = new WeakReference<>(mainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            MainActivity mainActivity = this.f15450a.get();
            if (mainActivity == null) {
                return;
            }
            mainActivity.m21522y6(message);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$h */
    public class RunnableC3358h implements Runnable {
        public RunnableC3358h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not available");
                return;
            }
            if (!C0209d.m1293p1() && MainActivity.this.f15258R3 && C13452e.m80781L().m80803F0().booleanValue()) {
                MainActivity.this.f15273U3 = null;
                if (!C0209d.m1333z1(MainActivity.this)) {
                    C1010e c1010eM6125b = C1010e.m6125b();
                    MainActivity mainActivity = MainActivity.this;
                    c1010eM6125b.m6154t(mainActivity, mainActivity);
                } else if (MainActivity.this.f15324e5 != null) {
                    C1010e c1010eM6125b2 = C1010e.m6125b();
                    MainActivity mainActivity2 = MainActivity.this;
                    c1010eM6125b2.m6128C(mainActivity2, mainActivity2);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$h0 */
    public class C3359h0 implements SpaceSwitchSuggestDialog.DialogSaveSwitchCallback {
        public C3359h0() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchSuggestDialog.DialogSaveSwitchCallback
        public void onSaveFinish() {
            MainActivity.this.m21140Cc();
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.SpaceSwitchSuggestDialog.DialogSaveSwitchCallback
        public void onSyncSwitchOpen(String str) {
            MainActivity.this.m21117A8(str, C13622a.m81958d("03003"), 9);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$h1 */
    public class C3360h1 implements VipRightsListener {
        public C3360h1() {
        }

        @Override // com.huawei.android.hicloud.p088ui.extend.VipRightsListener
        /* renamed from: a */
        public void mo21547a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Bundle bundle = new Bundle();
            C13230i.m79522d1(bundle, "1", "71");
            C12126b.m72707c(C13222a.m79465g(MainActivity.this.f15414z), bundle);
            MainActivity.m21003Sb(MainActivity.this.f15414z, 1);
            C13223b.m79475c(MainActivity.this.f15414z, "main_vip_rights_click", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(MainActivity.this.f15414z));
            UBAAnalyze.m29959T("PVC", "main_vip_rights_click", "1", "71", "1", C13222a.m79465g(MainActivity.this.f15414z));
            C13227f.m79492i1().m79585f0("main_vip_rights_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "main_vip_rights_click", "1", "71");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$i */
    public class C3361i implements Handler.Callback {
        public C3361i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 3216 || message.obj == null) {
                return false;
            }
            C12590s0.m75755I0(C0213f.m1377a(), message.obj.toString());
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$i0 */
    public class C3362i0 extends AbstractRunnableC12516b {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f15455a;

        /* renamed from: b */
        public final /* synthetic */ View f15456b;

        /* renamed from: c */
        public final /* synthetic */ View f15457c;

        public C3362i0(ArrayList arrayList, View view, View view2) {
            this.f15455a = arrayList;
            this.f15456b = view;
            this.f15457c = view2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final boolean zM21489u7 = MainActivity.this.m21489u7();
            final ArrayList arrayList = this.f15455a;
            final View view = this.f15456b;
            final View view2 = this.f15457c;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.z6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17835a.m21549d(zM21489u7, arrayList, view, view2);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m21549d(boolean z10, ArrayList arrayList, View view, View view2) {
            if (z10) {
                MainMenuItem mainMenuItem = new MainMenuItem(MainActivity.this.getString(R$string.cloud_service_update_menu_item), 14);
                mainMenuItem.setShowRedDot(MainActivity.this.m21116A7());
                arrayList.add(mainMenuItem);
                C13225d.m79490f1().m79585f0("mecloud_cloud_service_update_show", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29943D("PVC", "mecloud_cloud_service_update_show");
            }
            MainActivity.this.m21182Ha(arrayList);
            MainActivity.this.m21500va(arrayList);
            MainActivity.this.m21129Ba(arrayList);
            MainActivity.this.m21174Ga(arrayList);
            MainActivity.this.m21288Ua(arrayList);
            arrayList.add(new MainMenuItem(MainActivity.this.getString(R$string.more_setting), 12));
            MainActivity.this.f15312c2 = new C0145l1(MainActivity.this.getApplicationContext(), arrayList);
            MainActivity.this.f15302a2.setAdapter(MainActivity.this.f15312c2);
            MainActivity.this.f15302a2.setOnItemClickListener(MainActivity.this.new C3390w0());
            MainActivity.this.f15302a2.measure(0, 0);
            if (MainActivity.this.f15297Z1 != null) {
                MainActivity.this.f15297Z1.dismiss();
            }
            MainActivity.this.f15297Z1 = new PopupWindow(view, -2, -2);
            MainActivity mainActivity = MainActivity.this;
            MainActivity.this.f15297Z1.setWidth(mainActivity.m21249Pa(mainActivity.f15302a2.getMeasuredWidth()));
            MainActivity.this.f15297Z1.setFocusable(true);
            MainActivity.this.f15297Z1.setOutsideTouchable(true);
            MainActivity.this.f15297Z1.showAsDropDown(view2, C11842p.m70765S0() ? -((int) MainActivity.this.getResources().getDimension(R$dimen.cloud_space_12_dp)) : (int) MainActivity.this.getResources().getDimension(R$dimen.cloud_space_12_dp), -((int) MainActivity.this.getResources().getDimension(R$dimen.cloud_space_24_dp)), 8388613);
            MainActivity.this.f15297Z1.setContentView(view);
            MainActivity.this.f15297Z1.setOnDismissListener(MainActivity.this.new C3388v0());
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.MAIN_MENU;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void release() {
            C12515a.m75110o().m75165a1(this);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$j */
    public class C3363j extends AbstractC12367d {
        public C3363j() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (!NoticeWithActivityUtil.isNewDeviceGiftMainPopOn()) {
                C11839m.m70689w("MainActivity", "NewDeviceGiftMainPop is off");
                MainActivity.this.m21147Da("CLAM_POP");
                return;
            }
            try {
                if (!C11829c.m70629x0(false)) {
                    MainActivity.this.m21385h6(1);
                } else {
                    C11839m.m70687e("MainActivity", "family share member not support NotificationWithActivity");
                    MainActivity.this.m21147Da("CLAM_POP");
                }
            } catch (C1412i e10) {
                C11839m.m70687e("MainActivity", e10.toString());
                MainActivity.this.m21147Da("CLAM_POP");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$j0 */
    public static /* synthetic */ class C3364j0 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15460a;

        static {
            int[] iArr = new int[EnumC9164e.values().length];
            f15460a = iArr;
            try {
                iArr[EnumC9164e.LEVEL_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15460a[EnumC9164e.LEVEL_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15460a[EnumC9164e.LEVEL_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$k */
    public class C3365k implements C11075a.a<GetUserRegisterResp> {
        public C3365k() {
        }

        @Override // p431ko.C11075a.a
        /* renamed from: b */
        public void mo19190b() {
            MainActivity.this.f15289X4 = new HashMap();
            C11839m.m70687e("MainActivity", "GetUserRegisterResp error!");
        }

        @Override // p431ko.C11075a.a
        /* renamed from: d */
        public GetUserRegisterResp mo19189a() {
            return C9159b.m57567f();
        }

        /* renamed from: e */
        public final /* synthetic */ void m21552e(GetUserRegisterResp getUserRegisterResp) {
            MainActivity.this.m21504w5(getUserRegisterResp);
        }

        @Override // p431ko.C11075a.a
        /* renamed from: f */
        public void onResult(final GetUserRegisterResp getUserRegisterResp) {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.u6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17761a.m21552e(getUserRegisterResp);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$k0 */
    public class HandlerC3366k0 extends Handler {
        public HandlerC3366k0(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("MainActivity", "new business mode handler msg scene is " + message.obj);
            if (C13452e.m80781L().m80791C0()) {
                MainActivity.this.f15186D0.m24258K();
                MainActivity.this.m21173G9();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$l */
    public class C3367l extends AbstractC12367d {
        public C3367l() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("MainActivity", "processGetSpaceOkDialog");
            if (C0209d.m1245d1(MainActivity.this.f15414z, MainActivity.class.getName())) {
                C11839m.m70688i("MainActivity", "processGetSpaceOkDialog, MainActivity is on foreground");
            } else {
                MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
                C11839m.m70687e("MainActivity", "processGetSpaceOkDialog, MainActivity is not foreground");
            }
            boolean zM63289m = C10155f.m63289m();
            if (C13452e.m80781L().m80803F0().booleanValue() && zM63289m) {
                if (!C9437n.m59190e().m59192d()) {
                    C11839m.m70688i("MainActivity", "processGetSpaceOkDialog getFreePackageStatus false");
                    MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
                    return;
                }
            } else if (!C9437n.m59190e().m59193f()) {
                C11839m.m70688i("MainActivity", "processGetSpaceOkDialog isFreePackageAvailable false");
                MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
                return;
            }
            HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
            if (hiCloudSysParamMapM60758q == null) {
                C11839m.m70688i("MainActivity", "sysParamMap is null");
                MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
                return;
            }
            if (C13452e.m80781L().m80803F0().booleanValue() && zM63289m) {
                MainActivity.this.f15224K4 = hiCloudSysParamMapM60758q.getSpaceExperienceGiftPackageSuccessPage();
                C11839m.m70688i("MainActivity", "get ExperienceGiftPackagePage url");
            } else if ((C9437n.m59190e().m59194g() || C14303a.m85185a().m85192h()) && !C0209d.m1250e2(MainActivity.this)) {
                MainActivity.this.f15224K4 = hiCloudSysParamMapM60758q.getSpaceExperienceGiftPackageSubscribePage();
                C14303a.m85185a().m85194j(false);
                C9437n.m59190e().m59202o(false);
                C11839m.m70688i("MainActivity", "get SpaceExperienceGiftPackageSubscribePage url");
            } else {
                C11839m.m70688i("MainActivity", "no need show SpaceExperienceGiftPackageSubscribePage");
                MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
            }
            if (MainActivity.this.f15224K4 == null || MainActivity.this.f15224K4.length() == 0) {
                C11839m.m70688i("MainActivity", "spaceGetSuccessUrl is empty");
                MainActivity.this.m21147Da("GET_SPACE_OK_H5_DIALOG");
            } else {
                MainActivity.this.f15292Y1.m65765l("GET_SPACE_OK_H5_DIALOG", null);
                MainActivity.this.f15292Y1.m65754a("GET_SPACE_OK_H5_DIALOG");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$l0 */
    public class HandlerC3368l0 extends Handler {
        public HandlerC3368l0() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                C11839m.m70687e("MainActivity", "the activity is not avaiable");
            } else {
                MainActivity.this.m21438o6(message);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$m */
    public class C3369m extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ int f15465a;

        public C3369m(int i10) {
            this.f15465a = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM70684b = C11838l.m70684b(MainActivity.this);
            File file = new File(strM70684b);
            if (!file.exists() || file.length() >= 4194304) {
                C11839m.m70687e("MainActivity", "get map image error: file not exist or too large");
                return;
            }
            Bitmap bitmapM1311u = C0209d.m1311u(strM70684b);
            if (bitmapM1311u == null) {
                return;
            }
            C11828b.b bVar = new C11828b.b(null, null, bitmapM1311u);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f15465a;
            messageObtain.obj = bVar;
            MainActivity.this.f15309b5.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$m0 */
    public class HandlerC3370m0 extends Handler {
        public HandlerC3370m0() {
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x007c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "handleMessage, case: "
                r0.append(r1)
                int r1 = r5.what
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "MainActivity"
                p514o9.C11839m.m70688i(r1, r0)
                int r0 = r5.what
                r2 = 3
                if (r0 == r2) goto L74
                r2 = 1022(0x3fe, float:1.432E-42)
                if (r0 == r2) goto L5b
                r2 = 9010(0x2332, float:1.2626E-41)
                if (r0 == r2) goto L34
                r2 = 5001(0x1389, float:7.008E-42)
                if (r0 == r2) goto L82
                r2 = 5002(0x138a, float:7.009E-42)
                if (r0 == r2) goto L2e
                goto L9d
            L2e:
                java.lang.String r0 = "handle download fail message"
                p514o9.C11839m.m70688i(r1, r0)
                goto L74
            L34:
                java.lang.Object r5 = r5.obj
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                java.lang.String r0 = "mSyncHandler isGallerySynOn"
                p514o9.C11839m.m70686d(r1, r0)
                if (r5 == 0) goto L55
                com.huawei.android.hicloud.ui.activity.MainActivity r5 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                yd.f r5 = com.huawei.android.hicloud.p088ui.activity.MainActivity.m20966I3(r5)
                if (r5 == 0) goto L9d
                com.huawei.android.hicloud.ui.activity.MainActivity r4 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                yd.f r4 = com.huawei.android.hicloud.p088ui.activity.MainActivity.m20966I3(r4)
                r4.m83891z0()
                goto L9d
            L55:
                com.huawei.android.hicloud.ui.activity.MainActivity r4 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                com.huawei.android.hicloud.p088ui.activity.MainActivity.m21002S3(r4)
                goto L9d
            L5b:
                com.huawei.android.hicloud.ui.activity.MainActivity r0 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                android.app.Activity r0 = com.huawei.android.hicloud.p088ui.activity.MainActivity.m21046f4(r0)
                gp.c r0 = gp.C10028c.m62183d0(r0)
                java.lang.String r1 = "get_notepad_history_time"
                long r2 = java.lang.System.currentTimeMillis()
                r0.m62197C2(r1, r2)
                com.huawei.android.hicloud.ui.activity.MainActivity r4 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                com.huawei.android.hicloud.p088ui.activity.MainActivity.m21069m2(r4, r5)
                goto L9d
            L74:
                com.huawei.android.hicloud.ui.activity.MainActivity r0 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                boolean r0 = com.huawei.android.hicloud.p088ui.activity.MainActivity.m21093t2(r0)
                if (r0 == 0) goto L82
                java.lang.String r4 = "alreadyLoadMap, return"
                p514o9.C11839m.m70688i(r1, r4)
                return
            L82:
                java.lang.Object r5 = r5.obj
                o9.b$b r5 = (p514o9.C11828b.b) r5
                if (r5 != 0) goto L8e
                java.lang.String r4 = "handle download success message, result is null"
                p514o9.C11839m.m70688i(r1, r4)
                return
            L8e:
                android.graphics.Bitmap r5 = r5.f54752c
                if (r5 != 0) goto L98
                java.lang.String r4 = "handle download success message, result bitmap is null"
                p514o9.C11839m.m70688i(r1, r4)
                return
            L98:
                com.huawei.android.hicloud.ui.activity.MainActivity r4 = com.huawei.android.hicloud.p088ui.activity.MainActivity.this
                com.huawei.android.hicloud.p088ui.activity.MainActivity.m21096u2(r4, r5)
            L9d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.MainActivity.HandlerC3370m0.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$n */
    public class C3371n extends AbstractC12367d {
        public C3371n() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Intent intent = MainActivity.this.getIntent();
            if (intent != null) {
                try {
                    String stringExtra = intent.getStringExtra("risk_entry_key");
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    C13223b.m79473a(MainActivity.this.f15414z, stringExtra, "1");
                    UBAAnalyze.m29954O("PVC", stringExtra, "2", "38");
                } catch (Exception unused) {
                    C11839m.m70687e("MainActivity", "getIntent error");
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$n0 */
    public class C3372n0 extends AbstractC12367d {
        public C3372n0() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!C12591s1.m75931a().m75942l()) {
                C14311d.m85230g().m85236f(MainActivity.this, true);
            }
            ICBBroadcastManager.sendCancelRestoreBroadcast(MainActivity.this);
            C12571m.m75543e("");
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            Message messageObtain = Message.obtain();
            messageObtain.what = 9008;
            messageObtain.obj = Long.valueOf(jCurrentTimeMillis2);
            if (jCurrentTimeMillis2 > RippleView.SINGLE_RIPPLE_TIME) {
                MainActivity.this.f15304a5.sendMessage(messageObtain);
            } else {
                MainActivity.this.f15304a5.sendMessageDelayed(messageObtain, RippleView.SINGLE_RIPPLE_TIME - jCurrentTimeMillis2);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$o */
    public class C3373o extends AbstractC12367d {
        public C3373o() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f15375r = mainActivity.m21029a6();
            List<String> listM69907f = MainActivity.this.f22163b.m69907f(MainActivity.this.f15375r);
            C11839m.m70688i("MainActivity", "Need Permissions Size:" + listM69907f.size());
            MainActivity.this.m29142y0(listM69907f);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$o0 */
    public class C3374o0 extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Location f15471a;

        public C3374o0(Location location) {
            this.f15471a = location;
        }

        /* renamed from: e */
        public /* synthetic */ void m21556e() {
            MainActivity.this.m21180H8();
        }

        public /* synthetic */ void lambda$call$0() {
            if (MainActivity.this.f15295Z != null) {
                MainActivity.this.f15295Z.showDefaultMap();
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (C1010e.m6125b().m6152r(this.f15471a)) {
                C11838l.m70683a(MainActivity.this.f15414z);
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16475a.lambda$call$0();
                    }
                });
            } else if (MainActivity.this.f15273U3 != null) {
                C11839m.m70688i("MainActivity", "location done, start to load map image.");
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.b7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16485a.m21556e();
                    }
                });
            } else {
                MainActivity.this.f15273U3 = C1010e.m6125b().m6132G(this.f15471a);
                MainActivity.this.m21160F5();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$p */
    public class C3375p extends View.AccessibilityDelegate {
        public C3375p() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.removeChild(MainActivity.this.f15329g0);
            accessibilityNodeInfo.removeChild(MainActivity.this.f15290Y);
            accessibilityNodeInfo.addChild(MainActivity.this.f15290Y);
            accessibilityNodeInfo.addChild(MainActivity.this.f15329g0);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$p0 */
    public class C3376p0 extends AbstractC12367d {
        public C3376p0() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1008c.m6035v().m6051P(MainActivity.this.f15414z, MainActivity.this.f15299Z4, false);
            MainActivity.this.f15379r5.sendEmptyMessageDelayed(20002, 300L);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$q */
    public class ViewOnClickListenerC3377q implements View.OnClickListener {
        public ViewOnClickListenerC3377q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C13227f.m79492i1().m79585f0("mecloud_main_click_service_tip", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_service_tip", "1", "92");
            MainActivity.this.f15267T1.onClick(view);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$q0 */
    public class C3378q0 implements InterfaceC11736a {

        /* renamed from: a */
        public final InterfaceC9282a f15476a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);

        public C3378q0() {
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: a */
        public void mo13316a() {
            C11839m.m70688i("MainActivity", "onAlbumChanged");
            MainActivity.this.m21491u9(true);
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: b */
        public void mo13317b() {
            C11839m.m70688i("MainActivity", "notifyShareDownloadSyncCompleted");
            if (C10155f.m63300x()) {
                C1006a.m5936k().m5968o(MainActivity.this.f15384s5);
            }
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: c */
        public void mo13318c() {
            C11839m.m70688i("MainActivity", "onMediaChanged");
            if (C10155f.m63300x() && (this.f15476a.mo58383N0() || (!this.f15476a.mo58413b1() && !MainActivity.this.m21523y7()))) {
                C1006a.m5936k().m5968o(MainActivity.this.f15384s5);
            }
            MainActivity.this.m21491u9(false);
        }

        @Override // p496nn.InterfaceC11736a
        /* renamed from: d */
        public void mo13319d() {
            C11839m.m70688i("MainActivity", "onDownloadSyncCompleted");
            MainActivity.this.m21491u9(true);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$r */
    public class C3379r extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Intent f15478a;

        public C3379r(Intent intent) {
            this.f15478a = intent;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("MainActivity", "get campaignTaskList");
            List<QuestBean> listM60644z = C9718g.m60602t().m60644z(MainActivity.this, C9718g.m60602t().m60635o());
            if (listM60644z == null) {
                C11839m.m70689w("MainActivity", "processCampaignCard TaskList is empty");
                listM60644z = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (listM60644z.size() >= 2) {
                for (int i10 = 0; i10 < listM60644z.size(); i10++) {
                    QuestBean questBean = listM60644z.get(i10);
                    if (questBean != null) {
                        TaskCenterItem taskCenterItem = new TaskCenterItem();
                        taskCenterItem.setFragmentNumber(C9718g.m60602t().m60642x(MainActivity.this, questBean.getId()));
                        taskCenterItem.setButtonText(questBean.getButtonCreate());
                        taskCenterItem.setTitle(questBean.getName());
                        taskCenterItem.setDescription(questBean.getDetail());
                        taskCenterItem.setType(questBean.getType());
                        if (questBean.getPicture() != null) {
                            taskCenterItem.setImageUrl(C13826g.m82952o(questBean.getPicture().getUrl()));
                        }
                        arrayList.add(taskCenterItem);
                        C11839m.m70686d("MainActivity", "addCenterItems ：taskId = " + questBean.getId() + " ，fragmentNumber = " + taskCenterItem.getFragmentNumber());
                        if (arrayList.size() == 2) {
                            break;
                        }
                    }
                }
            }
            int size = listM60644z.size();
            C11839m.m70688i("MainActivity", "Campaign Card task size:" + size + "," + arrayList.size());
            MainActivity.this.m21441o9(arrayList, size, this.f15478a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$r0 */
    public static class C3380r0 extends AbstractC12367d {
        public C3380r0() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            RecommendCardManager.getInstance().clearPpsPicturePathFromSp(false);
        }

        public /* synthetic */ C3380r0(C3365k c3365k) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$s */
    public class C3381s implements ScrollUpUrgencyView.OnItemClickListener {
        public C3381s() {
        }

        @Override // com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView.OnItemClickListener
        public void onItemClick(int i10) {
            if (C0209d.m1226Y0()) {
                C11839m.m70687e("MainActivity", "fast click urgencyScrollupView");
            } else {
                MainActivity.this.m21424m6(i10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$s0 */
    public class C3382s0 implements InterfaceC13450c {
        public C3382s0() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            C11839m.m70686d("MainActivity", "PhoneFinderConstants.CHECKPASSWORD_ONERROR");
            MainActivity.this.mo7530X();
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C11839m.m70686d("MainActivity", "PhoneFinderConstants.CHECKPASSWORD_ONFINISH");
            MainActivity.this.m21369f5();
            MainActivity.this.f15346k1 = false;
            MainActivity.this.m20967I5();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$t */
    public class ViewOnClickListenerC3383t implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Boolean f15482a;

        public ViewOnClickListenerC3383t(Boolean bool) {
            this.f15482a = bool;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("MainActivity", "click too fast");
                return;
            }
            int id2 = view.getId();
            if (id2 == R$id.ic_back_hot_space) {
                MainActivity.this.m21467rb();
                return;
            }
            if (id2 == R$id.ic_more_hot_space) {
                MainActivity.this.m21265Ra(this.f15482a, view);
            } else if (id2 == R$id.ic_sns_info_hot_space) {
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this, (Class<?>) MessageCenterActivity.class), 1007);
                C13227f.m79492i1().m79585f0("mecloud_click_sns_info_pic", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_click_sns_info_pic", "1", "2");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$t0 */
    public static class C3384t0 implements SpanClickText.ISpanClickListener {

        /* renamed from: a */
        public TextView f15484a;

        /* renamed from: b */
        public Context f15485b;

        /* renamed from: c */
        public Bundle f15486c;

        public C3384t0(Context context, TextView textView, Bundle bundle) {
            this.f15484a = textView;
            this.f15485b = context;
            this.f15486c = bundle;
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() {
            if (this.f15484a == null) {
                return;
            }
            if (C0209d.m1226Y0()) {
                C11839m.m70687e("MainActivity", "fast click");
                return;
            }
            C13227f.m79492i1().m79585f0("mecloud_main_click_more_data", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_more_data", "1", "37");
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c != null) {
                interfaceC9284c.mo17132k(this.f15485b, this.f15486c);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$u */
    public class C3385u extends AbstractC12367d {
        public C3385u() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13612b.m81829B().m81847J(MainActivity.this);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$u0 */
    public class HandlerC3386u0 extends Handler {

        /* renamed from: a */
        public Activity f15488a;

        public HandlerC3386u0(Activity activity) {
            this.f15488a = activity;
        }

        /* renamed from: a */
        public final void m21557a(Object obj) throws SecurityException {
            String stringExtra = new SafeIntent(MainActivity.this.getIntent()).getStringExtra("SOURCE_OTHER_APP");
            C11839m.m70688i("MainActivity", "parseGuidQueryH5Ok sources: " + stringExtra);
            if (TextUtils.equals("SOURCE_ID_ACCOUNT_CENTER", stringExtra)) {
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                linkedHashMapM79497A.put("sources", stringExtra);
                linkedHashMapM79497A.put("result", "fail");
                C13227f.m79492i1().m79567R("mecloud_pre_h5_show_result_2", linkedHashMapM79497A);
                UBAAnalyze.m29947H("PVC", "mecloud_pre_h5_show_result_2", linkedHashMapM79497A);
            }
            if (C9733f.m60705z().m60718M()) {
                C11839m.m70688i("MainActivity", "disableHomePagePopupFromAccount is open, not show h5 dialog");
                return;
            }
            boolean zM1245d1 = C0209d.m1245d1(MainActivity.this.f15414z, MainActivity.class.getName());
            if (C0209d.m1245d1(MainActivity.this.f15414z, MainActivity.class.getName())) {
                C11839m.m70688i("MainActivity", "QueryGuideH5Task parseGuidQueryH5Ok in");
                MainActivity.this.f15319d5 = obj;
                MainActivity.this.f15261S0 = new AlertDialog.Builder(MainActivity.this.f15414z).create();
                MainActivity.this.f15292Y1.m65765l("GUIDE_H5_WEBVIEW_DAILOG", MainActivity.this.f15261S0);
                MainActivity.this.f15292Y1.m65754a("GUIDE_H5_WEBVIEW_DAILOG");
            } else {
                C11839m.m70688i("MainActivity", "QueryGuideH5Task parseGuidQueryH5Ok, activity is not foreground");
            }
            LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A2.put("sources", stringExtra);
            linkedHashMapM79497A2.put("result", "end");
            linkedHashMapM79497A2.put("foreground", String.valueOf(zM1245d1));
            C13227f.m79492i1().m79567R("mecloud_pre_h5_show_result_2", linkedHashMapM79497A2);
            UBAAnalyze.m29947H("PVC", "mecloud_pre_h5_show_result_2", linkedHashMapM79497A2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws SecurityException {
            C11839m.m70688i("MainActivity", "QueryGuideH5Task msg.what: " + message.what);
            int i10 = message.what;
            if (i10 == 0) {
                C11839m.m70688i("MainActivity", "QueryGuideH5Task QUERY_H5_FAIL");
                MainActivity.this.m21147Da("GUIDE_H5_WEBVIEW_DAILOG");
            } else if (i10 == 1) {
                m21557a(message.obj);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$v */
    public class ViewOnClickListenerC3387v implements View.OnClickListener {
        public ViewOnClickListenerC3387v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.f15297Z1 != null) {
                MainActivity.this.f15297Z1.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$v0 */
    public class C3388v0 implements PopupWindow.OnDismissListener {
        public C3388v0() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MainActivity.this.m21274Sa();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$w */
    public class C3389w extends AbstractC12367d {
        public C3389w() {
        }

        /* renamed from: d */
        public /* synthetic */ void m21559d(boolean z10) {
            if (z10) {
                MainActivity.this.f15329g0.setMoreIconRedDot(0);
            } else {
                MainActivity.this.f15329g0.setMoreIconRedDot(8);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final boolean z10 = (HiCloudSysParamMapCache.isNpsMenuRedDot() && NpsShowManager.getInstance().checkIsNeedShowNPSMenu(MainActivity.this.getApplicationContext())) || (MainActivity.this.m21489u7() && MainActivity.this.m21116A7());
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.x6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17803a.m21559d(z10);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$w0 */
    public class C3390w0 implements AdapterView.OnItemClickListener {
        public C3390w0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (MainActivity.this.f15312c2 == null) {
                C11839m.m70688i("MainActivity", "MainMenuItemClick adapter is null.");
                return;
            }
            MainMenuItem mainMenuItem = (MainMenuItem) MainActivity.this.f15312c2.getItem(i10);
            if (mainMenuItem == null) {
                C11839m.m70688i("MainActivity", "MainMenuItemClick item is null.");
            } else {
                if (!mainMenuItem.isEnabled()) {
                    C11839m.m70688i("MainActivity", "MainMenuItemClick item is not enabled.");
                    return;
                }
                if (MainActivity.this.f15297Z1 != null) {
                    MainActivity.this.f15297Z1.dismiss();
                }
                MainActivity.this.m21402j8(mainMenuItem.getMenuType());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$x */
    public class RunnableC3391x implements Runnable {
        public RunnableC3391x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f15254Q4 != null) {
                MainActivity.this.f15254Q4.m25290f0(MainActivity.this.f15239N4);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$x0 */
    public class C3392x0 extends AbstractC12367d {
        public C3392x0() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            MainActivity.this.m21512x4();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.MAIN_PROC_SINGLE;
        }

        public /* synthetic */ C3392x0(MainActivity mainActivity, C3365k c3365k) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$y */
    public class C3393y extends AbstractC12367d {
        public C3393y() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            Pair<List<CBSDevice>, Long> pairM61806t = C9961b.m61788i().m61806t("SilenceDevice");
            List list = (List) pairM61806t.first;
            int size = AbstractC14026a.m84159a(list) ? 0 : list.size();
            C13452e.m80781L().m80832M2(((Long) pairM61806t.second).longValue() > 0 ? size : 0);
            C13452e.m80781L().m80828L2(list != null ? C12312h0.m74027b().m74028c() : 0L);
            C11839m.m70688i("MainActivity", "querySilenceDevice exit, number: " + size);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$y0 */
    public class DialogInterfaceOnCancelListenerC3394y0 implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        public String f15497a;

        public DialogInterfaceOnCancelListenerC3394y0(String str) {
            this.f15497a = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C11839m.m70688i("MainActivity", "onCancel module:" + this.f15497a);
            MainActivity.this.f15326f1.m62336h2(this.f15497a, false);
            C1008c.m6035v().m6046K(MainActivity.this, this.f15497a, 0);
            C13227f.m79492i1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f15497a);
            if (MainActivity.this.f15334h1 != null) {
                MainActivity.this.f15334h1.m83858i0(this.f15497a, Boolean.FALSE);
            }
            MainActivity.this.m21184Hc("");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$z */
    public class ViewTreeObserverOnGlobalLayoutListenerC3395z implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC3395z() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            C11842p.m70736I1(MainActivity.this.f15196F0, MainActivity.this.f15311c1.getHeight());
            MainActivity.this.f15311c1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MainActivity$z0 */
    public class DialogInterfaceOnClickListenerC3396z0 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public String f15500a;

        public DialogInterfaceOnClickListenerC3396z0(String str) {
            this.f15500a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                C11839m.m70688i("MainActivity", "positive module:" + this.f15500a);
                MainActivity.this.f15326f1.m62336h2(this.f15500a, true);
                C1008c.m6035v().m6046K(MainActivity.this, this.f15500a, 1);
                C13227f.m79492i1().m79599w0(true, "CLOUDBACKUP_OPEN_DRIVE_APP_SWITCH", this.f15500a);
                if (MainActivity.this.f15334h1 != null) {
                    MainActivity.this.f15334h1.m83858i0(this.f15500a, Boolean.TRUE);
                }
            } else if (-2 == i10) {
                C11839m.m70688i("MainActivity", "negative module:" + this.f15500a);
                MainActivity.this.f15326f1.m62336h2(this.f15500a, false);
                C1008c.m6035v().m6046K(MainActivity.this, this.f15500a, 0);
                C13227f.m79492i1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f15500a);
                if (MainActivity.this.f15334h1 != null) {
                    MainActivity.this.f15334h1.m83858i0(this.f15500a, Boolean.FALSE);
                }
            }
            MainActivity.this.m21184Hc("");
        }
    }

    /* renamed from: H4 */
    private void m20964H4() {
        C11839m.m70688i("MainActivity", "checkCampaignConfig");
        C10270w c10270w = new C10270w(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.v5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17774a.m21231N7((GetCampaignActivityEntryResp) obj);
            }
        }, 1);
        c10270w.m63434i("MainActivity");
        c10270w.m63381g();
    }

    /* renamed from: I5 */
    public void m20967I5() {
        mo7529M(false);
        if (!this.f15342j1) {
            C2783d.m16138f(this);
        } else {
            m21521y5("local_policy_exit_cloud");
            this.f15338i1 = true;
        }
    }

    /* renamed from: I6 */
    private void m20968I6() {
        C11839m.m70688i("MainActivity", "initBroadcastReceiver");
        if (this.f15216J0 == null) {
            this.f15216J0 = new HiSyncReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.DELETENUM");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.hicloud.intent.getphotourl");
            intentFilter.addAction("com.huawei.hicloud.intent.getlocaluserphoto");
            intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
            intentFilter.addAction("com.huawei.hicloud.intent.phoneFinderClose");
            intentFilter.addAction("com.huawei.hicloud.intent.action.CLOUDALBUM_STATUS");
            intentFilter.addAction("com.huawei.hicloud.intent.action.SPACE_NOT_ENOUGH");
            intentFilter.addAction("com.huawei.android.hicloud.intent.action.WLAN_HOTSPOT");
            intentFilter.addAction("com.huawei.hicloud.intent.EXIT");
            intentFilter.addAction("com.huawei.hwid.ACTION_HEAD_PIC_CHANGE");
            intentFilter.addAction("com.huawei.hwid.ACTION_ACCOUNTNAME_CHANGE");
            intentFilter.addAction("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START");
            intentFilter.addAction("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END");
            intentFilter.addAction("com.huawei.hicloud.action.ACTION_OPEN_FULL_SWITCH");
            intentFilter.addAction("com.huawei.hicloud.QUERY_STORAGE_FINISHED");
            intentFilter.addAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
            intentFilter.addAction("com.huawei.hicloud.QUOTA_INFO_OM_CONFIG_DOWNLOAD_FINISHED");
            intentFilter.addAction("com.huawei.cloud.pay.action.updatespace");
            intentFilter.addAction("com.huawei.hicloud.action.agreeCampaign");
            intentFilter.addAction("com.huawei.hicloud.action.updateCampaign");
            intentFilter.addAction("com.huawei.hicloud.ST_FIXED");
            intentFilter.addAction("action_parse_config_finish");
            intentFilter.addAction("action_drive_parse_config_finish");
            intentFilter.addAction("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH");
            intentFilter.addAction("com.huawei.hicloud.intent.action.SAFE_INFO_CONFIG_SUCCESS");
            intentFilter.addAction("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW");
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_REFRESH_FIRST_PAGE");
            intentFilter.addAction("com.huawei.hicloud.DELETE_STORAGE_FINISHED");
            intentFilter.addAction("com.huawei.android.intent.action.CLOUD_BACKUP_DELETE");
            intentFilter.addAction("com.huawei.android.hicloud.sendmessage");
            intentFilter.addAction("com.huawei.android.hicloud.nofityThumbnail");
            intentFilter.addAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
            intentFilter.addAction(RecommendCardConstants.HOMEPAGE_RECOMMEND_REFRESH_FINISH_ACTION);
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS");
            intentFilter.addAction("com.huawei.hicloud.action.ACTION_MESSAGE_STATUS_CHANGED");
            intentFilter.addAction("com.huawei.hicloud.action.ACTION_MESSAGE_NUM_CHANGED");
            intentFilter.addAction("com.huawei.hicloud.getCloudPhotoTotalSize");
            intentFilter.addAction("com.huawei.hicloud.more.setting.clear.cache");
            intentFilter.addAction("com.huawei.hicloud.intent.action.HICLOUD_SPACE_POSITION_MGR_REFRESH_FINISH_ACTION");
            intentFilter.addAction("newBusinessChangeSuccess");
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_CHANGE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.SWITCH_CHANGED");
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_PUSH");
            intentFilter.addAction("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH");
            C13108a.m78878b(getApplicationContext()).m78880c(this.f15216J0, intentFilter);
        }
    }

    /* renamed from: Kc */
    private void m20973Kc() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            this.f15301a1 = interfaceC9282a.mo58394T(this);
        } else {
            C11839m.m70688i("MainActivity", "cloudAlbumRouterImpl is null");
        }
        int i10 = this.f15301a1;
        if (i10 == -1 || i10 == -2) {
            return;
        }
        int iM16192z = C2783d.m16192z(this);
        this.f15306b1 = iM16192z;
        if (this.f15301a1 != 1 || iM16192z >= 0) {
            m21176Gc();
        }
    }

    /* renamed from: L1 */
    private void m20974L1(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f15414z);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        if (i10 == 0) {
            C11839m.m70687e("MainActivity", "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e("MainActivity", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C11839m.m70687e("MainActivity", "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10002) {
                        c10028cM62183d0.m62377p3("hms_agr_force_query", false);
                    }
                }
            }
        } else {
            C11839m.m70688i("MainActivity", "agreement update success");
            c10028cM62183d0.m62377p3("hms_agr_force_query", false);
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
    }

    /* renamed from: L5 */
    private void m20977L5() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        ResultReceiver resultReceiver = (ResultReceiver) hiCloudSafeIntent.getParcelableExtra("welcome_finisher");
        if (resultReceiver != null) {
            resultReceiver.send(1, null);
        }
        ResultReceiver resultReceiver2 = (ResultReceiver) hiCloudSafeIntent.getParcelableExtra("hisync_guide_finisher");
        if (resultReceiver2 != null) {
            resultReceiver2.send(1, null);
        }
        ResultReceiver resultReceiver3 = (ResultReceiver) hiCloudSafeIntent.getParcelableExtra("phonefinder_guide_finisher");
        if (resultReceiver3 != null) {
            resultReceiver3.send(1, null);
        }
        ResultReceiver resultReceiver4 = (ResultReceiver) hiCloudSafeIntent.getParcelableExtra("gallery_finisher");
        if (resultReceiver4 != null) {
            resultReceiver4.send(1, null);
        }
        ResultReceiver resultReceiver5 = (ResultReceiver) hiCloudSafeIntent.getParcelableExtra("external_finisher");
        if (resultReceiver5 != null) {
            resultReceiver5.send(1, null);
        }
    }

    /* renamed from: Mb */
    private void m20981Mb() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58465y(this, true, this.f15306b1);
        }
    }

    /* renamed from: Oa */
    public static void m20988Oa(String str) {
        C12515a.m75110o().m75175e(new C3344c0(str), false);
    }

    /* renamed from: P5 */
    public static Drawable[] m20992P5(Resources resources, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(resources.getDrawable(R$drawable.bottonbar_home_selector));
        if (z10) {
            arrayList.add(resources.getDrawable(R$drawable.bottonbar_tool_selector));
        }
        return (Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]);
    }

    /* renamed from: Q3 */
    public static /* synthetic */ void m20995Q3(MainActivity mainActivity) {
        mainActivity.m21468rc();
    }

    /* renamed from: Q5 */
    public static String[] m20996Q5(Resources resources, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(resources.getString(R$string.main_home_tab));
        if (z10) {
            arrayList.add(resources.getString(R$string.tool_tab));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: Sb */
    public static void m21003Sb(Context context, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new HwAnimationReflection(context).m15927c(i10);
    }

    /* renamed from: T7 */
    public static /* synthetic */ void m21007T7(SpaceSwitchSuggestDialog spaceSwitchSuggestDialog, DialogInterface dialogInterface) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("scene_id", spaceSwitchSuggestDialog.getDialogSceneId());
        linkedHashMapM79499C.put("action_code_guide_dialog_time", Long.valueOf(System.currentTimeMillis() - spaceSwitchSuggestDialog.getStartShowTime()));
        C13227f.m79492i1().m79591l0("mecloud_main_switch_suggest_cancel", linkedHashMapM79499C);
        C13227f.m79492i1().m79573U("mecloud_main_switch_suggest_cancel", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_main_switch_suggest_cancel", "1", "cloud_space_home_page_dialog", linkedHashMapM79499C);
    }

    /* renamed from: Y3 */
    public static /* synthetic */ int m21022Y3(MainActivity mainActivity) {
        int i10 = mainActivity.f15173A3;
        mainActivity.f15173A3 = i10 + 1;
        return i10;
    }

    /* renamed from: a6 */
    public List<String> m21029a6() {
        ArrayList arrayList = new ArrayList();
        boolean zM80858T0 = C13452e.m80781L().m80858T0();
        if (this.f15326f1.m62388s("backup_key")) {
            m21238O5(arrayList);
        }
        if (this.f15326f1.m62395t1("addressbook") && !zM80858T0) {
            arrayList.add("sync_contact");
        }
        if (this.f15326f1.m62395t1("calendar") && !zM80858T0) {
            arrayList.add("sync_calendar");
        }
        if (C1006a.m5936k().m5975v(this)) {
            arrayList.add("sync_ablum");
        }
        m21276T5(arrayList);
        return arrayList;
    }

    /* renamed from: a7 */
    private void m21030a7() {
        C11839m.m70688i("MainActivity", "initNetworkChangeReceiver");
        if (this.f15231M0 == null) {
            this.f15231M0 = new NetworkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f15231M0, intentFilter);
        }
    }

    /* renamed from: c8 */
    public static /* synthetic */ boolean m21037c8(UrgencyOnTopParams urgencyOnTopParams) {
        return "I".equals(urgencyOnTopParams.getUrgencID());
    }

    /* renamed from: ga */
    private void m21050ga() {
        Intent intent = getIntent();
        if (intent != null && new HiCloudSafeIntent(intent).getBooleanExtra("need_root_alert", false)) {
            AlertDialogC13157d alertDialogC13157d = new AlertDialogC13157d(this, null, 2);
            this.f15330g1 = alertDialogC13157d;
            alertDialogC13157d.show();
        }
    }

    /* renamed from: i9 */
    private void m21057i9() {
        C11839m.m70686d("MainActivity", "queryPushGuideStatus");
        if (C10028c.m62182c0().m62419y0()) {
            C11839m.m70688i("MainActivity", "MarketingNotifyCheckBox has showed, pushMarketingNotice dialog do not show!");
            m21147Da("PUSH_MARKETING_NOTICE");
        } else if (C13452e.m80781L().m80803F0().booleanValue() || !C0209d.m1166E1()) {
            C11839m.m70688i("MainActivity", "chinaRegion no push guide");
            m21147Da("PUSH_MARKETING_NOTICE");
        } else {
            C12515a.m75110o().m75172d(new C11256d(new WeakReference(this.f15304a5)));
        }
    }

    /* renamed from: j5 */
    private void m21061j5() {
        AlertDialogC13157d alertDialogC13157d = this.f15330g1;
        if (alertDialogC13157d != null) {
            try {
                alertDialogC13157d.dismiss();
                this.f15330g1 = null;
            } catch (IllegalArgumentException unused) {
                C11839m.m70687e("MainActivity", "RootedAlertDialog dismiss IllegalArgumentException");
            }
        }
        AlertDialogC11015b alertDialogC11015b = this.f15354m1;
        if (alertDialogC11015b != null) {
            alertDialogC11015b.dismiss();
            this.f15354m1 = null;
        }
        AlertDialogC11016c alertDialogC11016c = this.f15350l1;
        if (alertDialogC11016c != null) {
            alertDialogC11016c.dismiss();
            this.f15350l1 = null;
        }
        AlertDialogC11014a alertDialogC11014a = this.f15358n1;
        if (alertDialogC11014a != null) {
            alertDialogC11014a.dismiss();
            this.f15358n1 = null;
        }
    }

    /* renamed from: k5 */
    private void m21065k5() {
        C11839m.m70688i("MainActivity", "closePhoneFinder");
        C13195l.m79272J().m79324o(this, C1010e.m6125b().m6136a(this.f15414z), 8904, this.f15218J3);
    }

    /* renamed from: k6 */
    private void m21066k6() {
        Intent intent = new Intent(this, (Class<?>) GalleryDetailActivity.class);
        C13230i.m79525e1(intent, "1", "2");
        intent.putExtra("gallery_from_hisync", false);
        startActivity(intent);
    }

    /* renamed from: ma */
    public void m21072ma() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", getString(R$string.hidisk_hwcloud_email_address_for_feedback), null));
        intent.putExtra("android.intent.extra.SUBJECT", "Subject");
        intent.putExtra("android.intent.extra.TEXT", "Body");
        startActivity(Intent.createChooser(intent, ""));
    }

    /* renamed from: mc */
    private void m21073mc(String str, int i10) {
        m21163F8("notepad", str, i10);
        C1008c.m6035v().m6077h0(this, 1, "");
        this.f15240O.setCheckedProgrammatically(true);
        m21137C9(this.f15240O);
    }

    /* renamed from: q */
    private void m21083q() {
        SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
        if (spaceDisplayFragment == null) {
            m21147Da("SPACE_FULL");
            return;
        }
        if (!this.f15367p1) {
            spaceDisplayFragment.m24285r();
        }
        this.f15186D0.mo15483q();
        m21525y9();
    }

    /* renamed from: q7 */
    private void m21086q7() throws Throwable {
        m21292V6();
        m21316Y6();
        m21394i7();
        this.f15227L1 = (RelativeLayout) C12809f.m76829b(this, R$id.main_top_blue_region);
        SyncItemInfo syncItemInfoM21337b6 = m21337b6(HNConstants.DataType.MEDIA, this.f15220K);
        if (syncItemInfoM21337b6 == null) {
            SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.gallery_item_title));
            this.f15220K = syncItemInfo;
            syncItemInfo.setShowStatusLayout(true);
            this.f15220K.setSubUserDisable(true);
            this.f15220K.setId(HNConstants.DataType.MEDIA);
        } else {
            this.f15220K = syncItemInfoM21337b6;
            syncItemInfoM21337b6.setShowStatusLayout(true);
            this.f15220K.setSubUserDisable(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.main_user_head_pic_space);
        this.f15190E = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f15190E.setAccessibilityDelegate(C11842p.m70804e());
        SyncItemInfo syncItemInfoM21337b62 = m21337b6("addressbook", this.f15225L);
        if (syncItemInfoM21337b62 == null) {
            SyncItemInfo syncItemInfo2 = new SyncItemInfo(getString(R$string.contact));
            this.f15225L = syncItemInfo2;
            syncItemInfo2.setShowSwitch(true);
            this.f15225L.setId("addressbook");
        } else {
            this.f15225L = syncItemInfoM21337b62;
            syncItemInfoM21337b62.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM21337b63 = m21337b6("browser", this.f15230M);
        if (syncItemInfoM21337b63 == null) {
            SyncItemInfo syncItemInfo3 = new SyncItemInfo(getString(R$string.browser));
            this.f15230M = syncItemInfo3;
            syncItemInfo3.setShowSwitch(true);
            this.f15230M.setId("browser");
        } else {
            this.f15230M = syncItemInfoM21337b63;
            syncItemInfoM21337b63.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM21337b64 = m21337b6("calendar", this.f15235N);
        if (syncItemInfoM21337b64 == null) {
            SyncItemInfo syncItemInfo4 = new SyncItemInfo(getString(R$string.calendar_sync_item));
            this.f15235N = syncItemInfo4;
            syncItemInfo4.setShowSwitch(true);
            this.f15235N.setId("calendar");
        } else {
            this.f15235N = syncItemInfoM21337b64;
            syncItemInfoM21337b64.setShowSwitch(true);
        }
        SyncItemInfo syncItemInfoM21337b65 = m21337b6("notepad", this.f15240O);
        if (syncItemInfoM21337b65 == null) {
            SyncItemInfo syncItemInfo5 = new SyncItemInfo(getString(R$string.notepad_app_name));
            this.f15240O = syncItemInfo5;
            syncItemInfo5.setShowSwitch(true);
            this.f15240O.setId("notepad");
        } else {
            this.f15240O = syncItemInfoM21337b65;
            syncItemInfoM21337b65.setShowSwitch(true);
        }
        if (this.f15362o1) {
            this.f15240O.setShowStatusLayout(true);
            this.f15240O.setOnClick(true);
        } else {
            this.f15240O.setShowSwitchLayout(true);
            this.f15240O.setOnClick(false);
        }
        this.f15240O.setHasNotePadHistoryData(this.f15362o1);
        m21472s7();
        if (C0209d.m1293p1()) {
            this.f15220K.setImage(getDrawable(R$drawable.ic_cloud_album_ink));
            this.f15235N.setImage(getDrawable(R$drawable.icon_calendar_ink));
            this.f15240O.setImage(getDrawable(R$drawable.ic_memorandum_ink));
            this.f15230M.setImage(getDrawable(R$drawable.ic_hicloud_browser_list_new_ink));
            this.f15215J.setImage(getDrawable(R$drawable.ic_wifi_ink));
        } else if (C0209d.m1269j1()) {
            this.f15220K.setImage(getDrawable(R$drawable.ic_cloud_album_honor));
            this.f15225L.setImage(getDrawable(R$drawable.ic_contacts_honor));
            this.f15235N.setImage(getDrawable(R$drawable.icon_calendar_honor));
            this.f15230M.setImage(getDrawable(R$drawable.ic_hicloud_browser_list_new_honor));
            this.f15240O.setImage(getDrawable(R$drawable.ic_memorandum_honor));
        } else {
            this.f15220K.setImage(getDrawable(R$drawable.ic_cloud_album));
            this.f15225L.setImage(getDrawable(R$drawable.ic_contacts));
            this.f15235N.setImage(getDrawable(R$drawable.icon_calendar));
            this.f15230M.setImage(getDrawable(R$drawable.ic_hicloud_browser_list_new));
            this.f15240O.setImage(getDrawable(R$drawable.ic_memorandum));
        }
        this.f15259R4.setFocusable(false);
        this.f15259R4.setEnabled(false);
        this.f15259R4.setNestedScrollingEnabled(false);
        View viewM76829b = C12809f.m76829b(this, R$id.full_data_item_switch);
        this.f15243O3 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        m21401j7();
        m21230N6();
        m21110z4();
        SyncItemInfo syncItemInfo6 = new SyncItemInfo(getString(R$string.cloud_disk_item_title_new_update));
        this.f15245P = syncItemInfo6;
        syncItemInfo6.setVisible(8);
        this.f15245P.setShowSwitch(false);
        this.f15245P.setDiskItem(true);
        NotchFitLinearLayout notchFitLinearLayout = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.query_failed_frame);
        this.f15285X = notchFitLinearLayout;
        C11842p.m70891z2(this, notchFitLinearLayout);
        ObservableScrollView observableScrollView = (ObservableScrollView) C12809f.m76829b(this, R$id.new_hisync_setting);
        this.f15290Y = observableScrollView;
        observableScrollView.setScrollViewListener(new C3345c1(this, null));
        this.f15242O1.setAccessibilityDelegate(new C3375p());
        this.f15305b0 = (LinearLayout) C12809f.m76829b(this, R$id.safety_notice_item_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.safety_notice_link);
        this.f15310c0 = textView;
        textView.setOnClickListener(this);
        this.f15275V = (RelativeLayout) C12809f.m76829b(this, R$id.more_app_info_frame);
        this.f15280W = (SpanClickText) C12809f.m76829b(this, R$id.more_app_info_text);
        WindowManager windowManager = getWindowManager();
        windowManager.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        this.f15315d0 = (TextView) C12809f.m76829b(this, R$id.query_failed_email);
        this.f15196F0 = (RelativeLayout) C12809f.m76829b(this, R$id.space_display_stub_frame);
        this.f15201G0 = (RelativeLayout) C12809f.m76829b(this, R$id.blank_layout_for_space_not_show);
        if (ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
            m21112zb();
        }
        C13950f c13950f = this.f15334h1;
        if (c13950f != null) {
            c13950f.mo83728t();
        }
        m21207K9(this.f15253Q3);
        m21362e7();
        m21346c7();
        this.f15311c1 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f15206H0 = (LinearLayout) C12809f.m76829b(this, R$id.frag_storage_text_frame);
        this.f15211I0 = (RelativeLayout) C12809f.m76829b(this, R$id.manage_space_storagebar_frame);
        if (!C13452e.m80781L().m80887a1()) {
            LinearLayout linearLayout = this.f15206H0;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
            }
            RelativeLayout relativeLayout2 = this.f15211I0;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(this);
            }
        }
        this.f15212I1 = (RelativeLayout) C12809f.m76829b(this, R$id.tips_manage_space_frame);
        this.f15217J1 = (TextView) C12809f.m76829b(this, R$id.click_manage_space_desc);
        this.f15222K1 = (TextView) C12809f.m76829b(this, R$id.click_manage_space_ignore);
        this.f15182C1 = new C10718a(this);
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76829b(this, R$id.hot_features_help);
        this.f15267T1 = tipPopupLayout;
        tipPopupLayout.setClickListener(new ViewOnClickListenerC3377q());
        m21328Za();
        m21447p7();
        m20973Kc();
        m21221M6();
        m22381r1();
        m21417l7();
        m21252Q6();
        m21261R6();
        m21425m7();
        m21533za();
        m21376fc();
        this.f15407x3.setOnClickListener(this);
        this.f15412y3 = (StorageManagerCardLayout) C12809f.m76829b(this, R$id.main_family_share_cloud_item);
        ((TextView) findViewById(R$id.item_title)).setText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_disk_title"));
        ((TextView) findViewById(R$id.item_des)).setText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_disk_content"));
        ((TextView) findViewById(R$id.base_data_service_title2)).setText(SpaceMultLanguageUtil.getSpaceMultLanguage("base_data_service_title"));
        ((TextView) findViewById(R$id.manage_item_name)).setText(SpaceMultLanguageUtil.getSpaceMultLanguage("sync_and_backup_basic_data"));
    }

    /* renamed from: q8 */
    private void m21087q8() {
        SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
        if (spaceDisplayFragment != null) {
            if (!this.f15367p1) {
                spaceDisplayFragment.m24285r();
            }
            this.f15186D0.m24254G();
        }
        m21147Da("SPACE_FULL");
    }

    /* renamed from: r5 */
    private void m21090r5(Object obj) {
        C11839m.m70688i("MainActivity", "dealGetLocalHeadPicSuccess");
        if (obj == null) {
            C11839m.m70687e("MainActivity", "dealGetLocalHeadPicSuccess object is null.");
        } else if (obj instanceof Bitmap) {
            m21198J9((Bitmap) obj);
        } else {
            C11839m.m70687e("MainActivity", "dealGetLocalHeadPicSuccess object is not bitmap.");
        }
    }

    /* renamed from: tc */
    private void m21095tc(QueryPushGuideRsp queryPushGuideRsp) {
        ConsentRecordWithStatus consentRecordWithStatus;
        List<ConsentRecordWithStatus> recordWithStatusArrayList = queryPushGuideRsp.getRecordWithStatusArrayList();
        if (recordWithStatusArrayList == null || (consentRecordWithStatus = recordWithStatusArrayList.get(0)) == null) {
            C11839m.m70688i("MainActivity", "consentrecordwithstatus rsp is null");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        ConsentRecord latestSignRecord = consentRecordWithStatus.getLatestSignRecord();
        if (latestSignRecord != null) {
            C10028c.m62182c0().m62296Y1(latestSignRecord.getSubConsent());
        }
        if (!consentRecordWithStatus.isNeedSign()) {
            C11839m.m70688i("MainActivity", "no need sign");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        HicloudPushGuidPopConfig popConfig = HicloudPushGuideManager.getInstance().getPopConfig();
        if (popConfig == null) {
            C11839m.m70688i("MainActivity", "hicloudpushguideconfig is null");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        if (!HicloudPushGuideManager.getInstance().checkPopTimes()) {
            C11839m.m70688i("MainActivity", "canPop is false");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        this.f15317d2 = new HicloudPushGuideDialog();
        String giftPackageMode = popConfig.getGiftPackageMode();
        C11839m.m70686d("MainActivity", "giftPackageMode:" + giftPackageMode);
        if (TextUtils.equals(giftPackageMode, "1")) {
            m21385h6(2);
        } else {
            m21216Lb(null);
        }
    }

    /* renamed from: v7 */
    private boolean m21100v7(String str) {
        BackupOptionItem backupOptionItemM78401y = new C13026e().m78401y(str);
        return backupOptionItemM78401y != null && backupOptionItemM78401y.getBackupSwitch();
    }

    /* renamed from: y4 */
    private void m21107y4() {
        C13223b.m79481i(this, getIntent());
    }

    /* renamed from: z4 */
    private void m21110z4() {
        LinkedHashMap<String, SyncItemInfo> linkedHashMap = this.f15239N4;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        m21358db(this.f15220K);
        m21358db(this.f15225L);
        m21358db(this.f15235N);
        m21358db(this.f15240O);
        m21358db(this.f15230M);
        m21358db(this.f15245P);
        m21358db(this.f15215J);
        m21164F9();
        m21366eb();
    }

    /* renamed from: z5 */
    private void m21111z5() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58459v(this);
        }
    }

    /* renamed from: zb */
    private void m21112zb() {
        m21280Ta();
        this.f15285X.setVisibility(0);
        this.f15290Y.setVisibility(8);
        this.f15270U.setVisibility(8);
        RelativeLayout relativeLayout = this.f15196F0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        m21527yb();
        RelativeLayout relativeLayout2 = this.f15227L1;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    /* renamed from: A4 */
    public final void m21113A4(int i10, int i11) {
        C11839m.m70686d("MainActivity", "cacheVipRightsInfo expiredDays " + i10 + " rightsNum " + i11);
        C0212e0.m1372v(this, "sp_vip_rights_info", "key_vip_grade_code", this.f15335h4);
        C0212e0.m1368r(this, "sp_vip_rights_info", "key_vip_rights_num", i11);
        C0212e0.m1368r(this, "sp_vip_rights_info", "key_vip_expired_days", i10);
    }

    /* renamed from: A5 */
    public final void m21114A5() {
        AlertDialog alertDialog = this.f15246P0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f15246P0 = null;
        }
        if (this.f15251Q0.size() != 0) {
            Iterator<Map.Entry<String, MergeAlertDialog>> it = this.f15251Q0.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().dismiss();
            }
            this.f15251Q0.clear();
            m21184Hc("");
        }
        CutOutProgressDialog cutOutProgressDialog = this.f15296Z0;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
            this.f15296Z0 = null;
            m21167Fc("");
        }
        ClaimSpacePopDialog claimSpacePopDialog = this.f15256R0;
        if (claimSpacePopDialog != null) {
            claimSpacePopDialog.dismiss();
            this.f15256R0 = null;
        }
        Dialog dialog = this.f15266T0;
        if (dialog != null) {
            dialog.dismiss();
            this.f15266T0 = null;
        }
        AddToDesktopDialog addToDesktopDialog = this.f15370q;
        if (addToDesktopDialog != null) {
            addToDesktopDialog.dismiss();
            this.f15370q = null;
        }
        CleanCacheDialog cleanCacheDialog = this.f15283W3;
        if (cleanCacheDialog != null) {
            cleanCacheDialog.dismiss();
            this.f15283W3 = null;
        }
        RefurbishUpgradDialog refurbishUpgradDialog = this.f15276V0;
        if (refurbishUpgradDialog != null) {
            refurbishUpgradDialog.dismiss();
            this.f15276V0 = null;
        }
        Optional.ofNullable(this.f15286X0).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.w5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17789a.m21246P7((Dialog) obj);
            }
        });
    }

    /* renamed from: A6 */
    public final void m21115A6() {
        TaskCenterView taskCenterView = this.f15250Q;
        if (taskCenterView != null) {
            taskCenterView.setVisibility(8);
        }
    }

    /* renamed from: A7 */
    public final boolean m21116A7() throws NumberFormatException {
        int iM1357g = C0212e0.m1357g(C0213f.m1377a(), "sp_cloud_service_update", "key_cloud_service_update_version", 0);
        int i10 = Integer.parseInt(C0240y.m1680b(C0213f.m1377a(), "com.huawei.hidisk"));
        C11839m.m70688i("MainActivity", "isShowMenuRedHot currentVersionCode is: " + i10 + ", lastVersion is: " + iM1357g);
        return i10 > iM1357g || C0212e0.m1354d(C0213f.m1377a(), "sp_cloud_service_update", "key_show_cloud_service_update_red_hot", true);
    }

    /* renamed from: A8 */
    public final void m21117A8(String str, String str2, int i10) {
        m21127B8(str, str2, SyncType.OPEN_SWITCH_MANUALLY, i10);
    }

    /* renamed from: A9 */
    public final void m21118A9() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        C11842p.m70881x0(this, i10);
        C11842p.m70885y0(this, i10);
    }

    /* renamed from: Aa */
    public final void m21119Aa(C9682a c9682a) {
        if (c9682a == null) {
            c9682a = new C9682a();
        }
        LinkContents linkContentsM61490c = C9904a.m61488b().m61490c(c9682a.m60506a());
        SpaceSwitchSuggestDialog spaceSwitchSuggestDialog = (SpaceSwitchSuggestDialog) this.f15292Y1.m65756c("GUIDE_BACKUP_SWITCH");
        if (linkContentsM61490c == null) {
            C11839m.m70687e("MainActivity", "linkContent is null");
            LinearLayout linearLayout = this.f15305b0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            } else {
                C11839m.m70687e("MainActivity", "setClinkSpanForSafeLink safeInfoRegion is null");
                return;
            }
        }
        LinearLayout linearLayout2 = this.f15305b0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        } else {
            C11839m.m70687e("MainActivity", "setClinkSpanForSafeLink safeInfoRegion is null");
        }
        this.f15390u = linkContentsM61490c.getmGoto().getType();
        this.f15395v = linkContentsM61490c.getmGoto().getUri();
        String strM61491d = C9904a.m61488b().m61491d(linkContentsM61490c);
        TextView textView = this.f15310c0;
        if (textView != null) {
            textView.setText(strM61491d);
        } else {
            C11839m.m70687e("MainActivity", "setClinkSpanForSafeLink safeInfoText is null");
        }
        if (spaceSwitchSuggestDialog == null) {
            C11839m.m70687e("MainActivity", "setClinkSpanForSafeLink dialog is null");
            return;
        }
        LinearLayout linearLayout3 = this.f15305b0;
        boolean z10 = (linearLayout3 != null && linearLayout3.isShown()) || !TextUtils.isEmpty(this.f15395v);
        C11839m.m70688i("MainActivity", "setClinkSpanForSafeLink, isShowClickText:" + z10);
        spaceSwitchSuggestDialog.replaceSpanTextView(z10, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.n6
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17682a.m21363e8();
            }
        });
    }

    /* renamed from: Ab */
    public final void m21120Ab(UserPackage userPackage) {
        C11839m.m70686d("MainActivity", "usertype is free");
        C11839m.m70686d("MainActivity", "5G free user");
        m21183Hb();
        this.f15186D0.m24258K();
        this.f15391u0.refreshView();
        m21146D9();
    }

    /* renamed from: Ac */
    public final void m21121Ac(String str) {
        Dialog dialogM65756c = this.f15292Y1.m65756c(str);
        this.f15281W0 = dialogM65756c;
        if (dialogM65756c == null) {
            C11839m.m70688i("MainActivity", "pushGuideDialog is null");
            return;
        }
        if (C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
            C11839m.m70688i("MainActivity", "pushguide,activity is foreground");
            this.f15281W0.show();
            C10028c.m62182c0().m62427z3();
            this.f15208H3 = C10028c.m62182c0().m62230J0();
            m21348ca(this.f15228L3 ? "main_new_user_scene" : "main_agreement_change_scene");
            this.f15292Y1.m65762i(str);
        } else {
            C11839m.m70688i("MainActivity", "pushguide,activity is not foreground");
            this.f15397v1 = true;
        }
        this.f15377r1 = false;
        this.f15382s1 = false;
    }

    @Override // com.huawei.android.hicloud.p088ui.uilistener.CloudSpaceShowDetailsRegionListener
    /* renamed from: B */
    public void mo21122B(boolean z10) {
        if (z10) {
            RelativeLayout relativeLayout = this.f15196F0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.f15196F0;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    /* renamed from: B4 */
    public void m21123B4() {
        this.f15271U0.dismiss();
    }

    /* renamed from: B5 */
    public final void m21124B5() {
        AlertDialogC13588a alertDialogC13588a = this.f15418z4;
        if (alertDialogC13588a != null) {
            alertDialogC13588a.dismiss();
            this.f15418z4 = null;
        }
        m21184Hc("");
    }

    /* renamed from: B6 */
    public final void m21125B6() {
        CampaignEntryFloatView campaignEntryFloatView = this.f15184C4;
        if (campaignEntryFloatView != null) {
            campaignEntryFloatView.setVisibility(8);
            this.f15184C4.m25677d();
        }
    }

    /* renamed from: B7 */
    public final boolean m21126B7() {
        return this.f15225L == null || this.f15240O == null || this.f15235N == null || this.f15230M == null || this.f15215J == null || this.f15254Q4 == null;
    }

    /* renamed from: B8 */
    public final void m21127B8(String str, String str2, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("MainActivity", "performSynchronization, moduleName is empty");
            return;
        }
        C11839m.m70688i("MainActivity", "performSynchronization, moduleName: " + str);
        str.hashCode();
        switch (str) {
            case "addressbook":
                C1008c.m6035v().m6050O(this.f15414z, "addressbook", true);
                m21413kc(str2, i10, i11);
                break;
            case "gallery":
                m21426m8();
                break;
            case "calendar":
                m21406jc(str2, i11);
                break;
            case "wlan":
                C1008c.m6035v().m6050O(this.f15414z, "wlan", true);
                m21460qc(str2, i11);
                break;
            case "browser":
                m21398ic(str2, i11);
                break;
            case "notepad":
                m21073mc(str2, i11);
                break;
            default:
                m21452pc(str, str2, i11);
                break;
        }
        C14317j.m85300d().m85319t();
    }

    /* renamed from: B9 */
    public final void m21128B9() {
        C12515a.m75110o().m75172d(new C3376p0());
    }

    /* renamed from: Ba */
    public final void m21129Ba(ArrayList<MainMenuItem> arrayList) {
        MainMenuItem mainMenuItem = new MainMenuItem(getString(R$string.payment_manager_tag_short), 2);
        if (C2783d.m16139f0()) {
            arrayList.add(mainMenuItem);
        }
    }

    /* renamed from: Bb */
    public final void m21130Bb(boolean z10, int i10) {
        m21526ya(8);
        this.f15233M3.setVisibility(8);
        this.f15300a0.setVisibility(8);
        com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView hwBottomNavigationView = this.f15178B3;
        if (hwBottomNavigationView != null) {
            hwBottomNavigationView.setVisibility(8);
        }
        BasicDataGuideView basicDataGuideView = this.f15391u0;
        if (basicDataGuideView != null) {
            basicDataGuideView.setVisibility(8);
        }
        this.f15371q0.setVisibility(8);
        this.f15255R.setVisibility(8);
        this.f15260S.setVisibility(0);
        this.f15329g0.setSnSInfoViewVisible(false);
        this.f15329g0.setMoreIconVisibility(false);
        mo21122B(false);
        m21484ta(false, z10);
        m21526ya(8);
        C11842p.m70736I1(this.f15295Z, 0);
        C2783d.m16135e(this, i10);
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        if (syncItemRecyclerAdapter != null) {
            ArrayList<SyncItemInfo> arrayListM25272K = syncItemRecyclerAdapter.m25272K(this.f15239N4);
            if (!arrayListM25272K.isEmpty()) {
                Iterator<SyncItemInfo> it = arrayListM25272K.iterator();
                while (it.hasNext()) {
                    SyncItemInfo next = it.next();
                    if (next != null) {
                        m21223M8(false, next.getId(), i10);
                    }
                }
            }
        }
        NotchFitRelativeLayout notchFitRelativeLayout = this.f15376r0;
        if (notchFitRelativeLayout != null) {
            notchFitRelativeLayout.setVisibility(8);
        }
        ExpirationReminderCardView expirationReminderCardView = this.f15175B;
        if (expirationReminderCardView != null) {
            expirationReminderCardView.setVisibility(8);
        }
        m21284U6();
        m21183Hb();
        m21134C6();
    }

    /* renamed from: Bc */
    public final void m21131Bc(String str) {
        C11839m.m70688i("MainActivity", "toShowSpaceFullDialog: " + str);
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("MainActivity", "toShowSpaceFullDialog,too fast");
        } else {
            C12515a.m75110o().m75172d(new C3337a(str));
        }
    }

    /* renamed from: C4 */
    public final void m21132C4(int i10) {
        LinkedHashMap linkedHashMapM79546w;
        if (this.f15298Z3 == null || this.f15290Y == null) {
            return;
        }
        m21409k8(i10);
        m21226Mc(i10);
        if (i10 == 1) {
            m21236Nc(this.f15331g4);
            linkedHashMapM79546w = C13230i.m79546w("tool");
        } else {
            this.f15290Y.setVisibility(0);
            this.f15298Z3.setVisibility(8);
            linkedHashMapM79546w = C13230i.m79546w(RecommendCardConstants.Entrance.HOMEPAGE);
        }
        C13227f.m79492i1().m79591l0("mecloud_click_tab", linkedHashMapM79546w);
        UBAAnalyze.m29958S("PVC", "mecloud_click_tab", "1", "69", linkedHashMapM79546w);
    }

    /* renamed from: C5 */
    public final void m21133C5(String str, boolean z10, String str2) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                m21223M8(z10, "addressbook", 2);
                break;
            case "calendar":
                m21223M8(z10, "calendar", 2);
                break;
            case "wlan":
                m21223M8(z10, "wlan", 2);
                break;
            case "browser":
                m21223M8(z10, "browser", 2);
                break;
            case "notepad":
                m21223M8(z10, "notepad", 2);
                break;
            default:
                if (!TextUtils.isEmpty(str2)) {
                    m21302W8(z10, str2, 2);
                    break;
                }
                break;
        }
    }

    /* renamed from: C6 */
    public final void m21134C6() {
        NotchFitRelativeLayout notchFitRelativeLayout = this.f15407x3;
        if (notchFitRelativeLayout != null) {
            notchFitRelativeLayout.setVisibility(8);
        }
        StorageManagerCardLayout storageManagerCardLayout = this.f15412y3;
        if (storageManagerCardLayout != null) {
            storageManagerCardLayout.setVisibility(8);
        }
    }

    /* renamed from: C7 */
    public final void m21135C7(String str) {
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.putExtra("srcChannel", "0");
        safeIntent.putExtra("salChannel", "0");
        C11273b.m67657l(this, str, safeIntent, "");
    }

    /* renamed from: C8 */
    public final void m21136C8(boolean z10, Bitmap bitmap) {
        C11839m.m70686d("MainActivity", "phoneFinderShowDefault");
        PhoneFinderView phoneFinderView = this.f15295Z;
        if (phoneFinderView == null) {
            return;
        }
        phoneFinderView.refreshStatus(true);
        if (bitmap == null) {
            if (this.f15263S3) {
                if (this.f15268T3 != C0209d.m1208S0(this)) {
                    this.f15268T3 = C0209d.m1208S0(this);
                    m21387h8(5001);
                    return;
                }
                return;
            }
            this.f15295Z.showDefaultMap();
            m21387h8(3);
            if (z10) {
                m21160F5();
                return;
            }
            return;
        }
        C11839m.m70688i("MainActivity", "display map image.");
        this.f15268T3 = C0209d.m1208S0(this);
        this.f15295Z.setMapBitmap(bitmap);
        int width = bitmap.getWidth() * bitmap.getHeight();
        Bundle bundle = new Bundle();
        bundle.putString("operationType", "mapCardShow");
        bundle.putString(C5807k0.f25949l, "mapCardShow");
        bundle.putString("errorReason", "MainActivity map show success. size: " + width);
        C1010e.m6125b().m6129D(bundle);
        C11839m.m70688i("MainActivity", "MainActivity map show success. size: " + width);
    }

    /* renamed from: C9 */
    public final void m21137C9(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        if (this.f15254Q4 == null) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemRecyclerAdapter is null");
            return;
        }
        if (this.f15239N4 == null) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemInfoHashMap is null");
            this.f15239N4 = new LinkedHashMap<>();
        }
        if (syncItemInfo.getVisible() == 8) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemInfo is gone");
            if (this.f15239N4.containsKey(syncItemInfo.getId())) {
                this.f15239N4.remove(syncItemInfo.getId());
            }
        } else {
            this.f15239N4.put(syncItemInfo.getId(), syncItemInfo);
        }
        m21366eb();
    }

    /* renamed from: Ca */
    public final void m21138Ca() {
        int i10 = R$layout.main_layout;
        if (this.f15278V3 >= 1.75f) {
            i10 = R$layout.main_layout_scale;
        }
        setContentView(i10);
    }

    /* renamed from: Cb */
    public final void m21139Cb() {
        C11839m.m70688i("MainActivity", "showHasNoShareAlbumArea");
        m21529z6();
        if (C10155f.m63300x()) {
            NoShareAlbumLayoutView noShareAlbumLayoutView = this.f15393u4;
            if (noShareAlbumLayoutView != null) {
                noShareAlbumLayoutView.setVisibility(0);
                this.f15393u4.refreshData();
            }
            OneShareAlbumLayoutView oneShareAlbumLayoutView = this.f15398v4;
            if (oneShareAlbumLayoutView != null) {
                oneShareAlbumLayoutView.setVisibility(8);
            }
            LinearLayout linearLayout = this.f15403w4;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f15373q4;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
    }

    /* renamed from: Cc */
    public void m21140Cc() {
        SpaceDisplayFragment spaceDisplayFragment;
        m21306X4();
        m21386h7();
        if (this.f15321e1) {
            C1008c.m6035v().m6081j0(this);
        }
        this.f15334h1.m83875r();
        if (!C13452e.m80781L().m80917g1()) {
            this.f15334h1.m83849a0();
        }
        C14317j.m85300d().m85319t();
        CloudBackupService.getInstance().showLastRecord(true);
        if (this.f15253Q3 && (spaceDisplayFragment = this.f15186D0) != null) {
            spaceDisplayFragment.m24286t(true);
        }
        m21050ga();
        if (C0209d.m1215U1(this)) {
            m21307X5();
        }
        m21206K8();
        m21496v5();
        if (!this.f15244O4.isEmpty() && this.f15254Q4 != null) {
            C11839m.m70688i("MainActivity", "uiRefreshTask, notifyDataSetChanged");
            this.f15254Q4.m5213j();
        }
        m21437o5();
    }

    /* renamed from: D4 */
    public final void m21141D4() {
        boolean zM1650a = C0236u.m1650a();
        C11839m.m70688i("MainActivity", "checkAndExecuteSync, needExecuteSync: " + zM1650a);
        if (zM1650a) {
            C0236u.m1655f(false);
            C13612b.m81829B().m81870k0(this.f15414z.getApplicationContext());
            C2783d.m16150j(this);
            C1008c.m6035v().m6087m0(this, 1, "");
        }
    }

    /* renamed from: D5 */
    public void m21142D5() {
        C11839m.m70688i("MainActivity", "doInitCampaignEntryFloatView");
        if (this.f15184C4 == null && !isFinishing()) {
            CampaignEntryFloatView campaignEntryFloatView = new CampaignEntryFloatView(this.f15414z);
            this.f15184C4 = campaignEntryFloatView;
            ImageView campaignClose = campaignEntryFloatView.getCampaignClose();
            ImageView campaignImg = this.f15184C4.getCampaignImg();
            if (campaignClose == null || campaignImg == null) {
                C11839m.m70686d("MainActivity", "doInitCampaignEntryFloatView view is null");
                return;
            } else {
                campaignClose.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.a6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f16474a.m21253Q7(view);
                    }
                });
                campaignImg.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.b6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f16484a.m21262R7(view);
                    }
                });
            }
        }
        m21185I4();
    }

    /* renamed from: D6 */
    public final void m21143D6() {
        NotchFitRelativeLayout notchFitRelativeLayout;
        NotchFitRelativeLayout notchFitRelativeLayout2;
        RelativeLayout relativeLayout;
        if (!C0209d.m1293p1() && (relativeLayout = this.f15227L1) != null) {
            relativeLayout.setVisibility(0);
        }
        if (C10155f.m63301y() && !C0209d.m1293p1()) {
            m21526ya(0);
            this.f15357n0.setVisibility(0);
            this.f15366p0.setVisibility(0);
        }
        C11842p.m70736I1(this.f15295Z, (int) C11842p.m70844o(this, 12));
        this.f15233M3.setVisibility(0);
        this.f15300a0.setVisibility(0);
        this.f15255R.setVisibility(0);
        m21284U6();
        com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView hwBottomNavigationView = this.f15178B3;
        if (hwBottomNavigationView != null) {
            hwBottomNavigationView.setVisibility(8);
        }
        if (C0209d.m1293p1() && (notchFitRelativeLayout2 = this.f15371q0) != null) {
            notchFitRelativeLayout2.setVisibility(8);
        }
        BasicDataGuideView basicDataGuideView = this.f15391u0;
        if (basicDataGuideView != null) {
            basicDataGuideView.refreshView();
        }
        this.f15260S.setVisibility(8);
        m21385h6(3);
        this.f15329g0.setSnSInfoViewVisible(true);
        this.f15329g0.setMoreIconVisibility(true);
        mo21122B(true);
        this.f15329g0.setScrollChangeEnable(true ^ C11842p.m70732H0(this));
        Handler handler = this.f15324e5;
        if (handler != null) {
            handler.postDelayed(this.f15340i5, 200L);
        }
        boolean zM63300x = C10155f.m63300x();
        if ((zM63300x || C10155f.m63299w()) && this.f15179B4 == null) {
            C11839m.m70688i("MainActivity", "hideFunctionItemView initAlbumShareItem");
            this.f15179B4 = new C3378q0();
            C11737b.m70035b().m70036a(this.f15179B4);
        }
        if (zM63300x && (notchFitRelativeLayout = this.f15376r0) != null) {
            notchFitRelativeLayout.setVisibility(0);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null && interfaceC9282a.mo58413b1()) {
                interfaceC9282a.mo58446o0(this.f15384s5);
            }
        }
        m21291V5();
    }

    /* renamed from: D7 */
    public final void m21144D7(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 7);
        if (!TextUtils.isEmpty(str)) {
            C13230i.m79522d1(bundle, "1", str);
        }
        C12126b.m72707c(C13222a.m79465g(this), bundle);
        m21003Sb(this, 1);
    }

    /* renamed from: D8 */
    public final void m21145D8() {
        if (this.f15304a5 != null) {
            if (ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
                C11839m.m70688i("MainActivity", "all module disable");
                return;
            }
            if (!C10028c.m62182c0().m62266R()) {
                m21147Da("PUSH_MARKETING_NOTICE");
                this.f15292Y1.m65763j("CLAM_POP");
                m21477sc();
                m21278T8();
                return;
            }
            this.f15228L3 = true;
            C11839m.m70688i("MainActivity", "after first sign terms,goto prepare pushguide");
            this.f15292Y1.m65763j("PUSH_MARKETING_NOTICE");
            this.f15292Y1.m65763j("CLAM_POP");
            m21057i9();
            m21477sc();
            m21278T8();
            C10028c.m62182c0().m62276T1(false);
        }
    }

    /* renamed from: D9 */
    public final void m21146D9() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.data_sync_title);
        final ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.down_arrow_icon);
        final TextView textView2 = (TextView) C12809f.m76829b(this, R$id.data_base_view_all_title);
        textView.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_home_page_sync_card_tips"));
        m21412kb(textView2);
        if (this.f15349l0 == null) {
            LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.data_base_view_all_item);
            this.f15349l0 = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.y5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f17818a.m21339b8(textView2, imageView, view);
                }
            });
        }
        this.f15349l0.setVisibility(0);
        if (C13452e.m80781L().m80887a1()) {
            if (C13452e.m80781L().m80791C0()) {
                this.f15353m0.setVisibility(0);
            } else if (C0209d.m1293p1()) {
                SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
                if (syncItemRecyclerAdapter == null || syncItemRecyclerAdapter.mo721e() <= 0) {
                    LinearLayout linearLayout2 = this.f15353m0;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                } else {
                    LinearLayout linearLayout3 = this.f15353m0;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                }
            }
        }
        m21128B9();
    }

    /* renamed from: Da */
    public final void m21147Da(String str) {
        C10804r c10804r = this.f15292Y1;
        if (c10804r != null) {
            c10804r.m65764k(str);
        }
    }

    /* renamed from: Db */
    public final void m21148Db() {
        if (TextUtils.equals(this.f16166i, "1") || TextUtils.equals(this.f16166i, "4")) {
            this.f15329g0.m23957s();
        } else {
            this.f15329g0.m23939a();
        }
        if (ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
            this.f15329g0.m23957s();
        }
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("campaign_channel");
        this.f15234M4 = stringExtra;
        if ("81".equals(stringExtra)) {
            this.f15329g0.m23957s();
        }
    }

    /* renamed from: Dc */
    public final void m21149Dc(Runnable runnable) {
        HwRecyclerView hwRecyclerView = this.f15259R4;
        if (hwRecyclerView == null) {
            return;
        }
        hwRecyclerView.post(runnable);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: E0 */
    public void mo13484E0(int i10) {
        C11839m.m70688i("MainActivity", "finishPermissionSet requestCode: " + i10);
        if (i10 == 20004 || i10 == 20005 || i10 == 20006) {
            m21326Z8(i10);
        }
        if (i10 == 20001 || i10 == 20002) {
            m21310X8();
        }
    }

    /* renamed from: E4 */
    public final void m21150E4() {
        NewBmBackupItemView newBmBackupItemView = this.f15185D;
        if (newBmBackupItemView == null || this.f15274U4 == null || this.f15279V4 == null) {
            C11839m.m70689w("MainActivity", "checkBackupCloudDiskViewShow view is null");
            return;
        }
        if (newBmBackupItemView.getVisibility() == 8 && this.f15279V4.getVisibility() == 8) {
            this.f15274U4.setVisibility(8);
        } else if (this.f15185D.getVisibility() == 0 || this.f15279V4.getVisibility() == 0) {
            this.f15274U4.setVisibility(0);
        }
    }

    /* renamed from: E5 */
    public final void m21151E5(int[] iArr) {
        HiCloudItemView hiCloudItemView = null;
        for (int i10 : iArr) {
            HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76829b(this, i10);
            if (hiCloudItemView2 != null && hiCloudItemView2.getVisibility() == 0) {
                hiCloudItemView = hiCloudItemView2;
            }
        }
        if (hiCloudItemView != null) {
            hiCloudItemView.m23973d();
        }
    }

    /* renamed from: E6 */
    public final void m21152E6() {
        if (this.f15295Z == null) {
            this.f15295Z = (PhoneFinderView) C12809f.m76829b(this, R$id.phonefinder_vertical_item_view);
        }
        if (!C10155f.m63253F()) {
            this.f15366p0.setVisibility(8);
        } else {
            C11839m.m70688i("MainActivity", "show phone finder view");
            this.f15366p0.setVisibility(0);
        }
    }

    /* renamed from: E7 */
    public void m21153E7() {
        boolean zM16177s = C2783d.m16177s();
        C11839m.m70688i("MainActivity", "start jump manager space, is first enter main: " + zM16177s);
        if (zM16177s) {
            C2783d.m16137e1(false);
            C12809f.m76843p(this.f15212I1, false);
        }
        this.f15367p1 = true;
        if (m21437o5()) {
            return;
        }
        this.f15186D0.m24275c0();
        C13368e.m80184F().m80254s0(true);
        m21410k9();
    }

    /* renamed from: E8 */
    public final void m21154E8() {
        m20977L5();
        m21322Z4();
        if (C13612b.m81829B().isLogin()) {
            C12515a.m75110o().m75172d(new C3037h(this, getIntent()));
        } else {
            C11839m.m70686d("MainActivity", "preOperation clearAllActivity");
            C10161l.m63342b().m63343a();
        }
        C13612b.m81830Y(this);
    }

    /* renamed from: E9 */
    public final void m21155E9(Context context) {
        C11839m.m70688i("MainActivity", "refreshSyncItemView start");
        m21201Jc();
        m21221M6();
        boolean zM21245P6 = m21245P6();
        if (this.f15321e1 || !zM21245P6) {
            return;
        }
        C1008c.m6035v().m6081j0(context);
    }

    /* renamed from: Ea */
    public final void m21156Ea() {
        int iM16156l = C2783d.m16156l(this);
        SyncItemInfo syncItemInfo = this.f15245P;
        if (syncItemInfo != null) {
            if (iM16156l == 0) {
                m21349cb(syncItemInfo, true);
                return;
            }
            Resources resources = getResources();
            if (resources != null) {
                this.f15245P.setStatusText(resources.getQuantityString(R$plurals.item_num_not_open1, iM16156l, Integer.valueOf(iM16156l)));
                m21137C9(this.f15245P);
            }
        }
    }

    /* renamed from: Eb */
    public final void m21157Eb(Object obj) {
        if (C10155f.m63300x()) {
            C11839m.m70688i("MainActivity", "showJoinShareAlbumRequestArea");
            JoinShareAlbumRequestInfo joinShareAlbumRequestInfo = (JoinShareAlbumRequestInfo) obj;
            int joinRequestNum = joinShareAlbumRequestInfo.getJoinRequestNum();
            this.f15205H = joinRequestNum;
            if (this.f15378r4 != null) {
                if (joinRequestNum <= 0) {
                    C11839m.m70688i("MainActivity", "showJoinShareAlbumRequestArea joinRequestNum <= 0");
                    this.f15378r4.setVisibility(8);
                    return;
                }
                C11839m.m70688i("MainActivity", "showJoinShareAlbumRequestArea joinRequestNum > 0");
                this.f15378r4.setVisibility(0);
                this.f15378r4.setOnClickListener(this);
                if (this.f15383s4 != null) {
                    int iIntValue = joinShareAlbumRequestInfo.getMessageType().intValue();
                    if (iIntValue == 1) {
                        this.f15383s4.setText(getResources().getQuantityString(R$plurals.album_share_join_request, this.f15205H, Integer.valueOf(joinShareAlbumRequestInfo.getJoinRequestNum())));
                    } else if (iIntValue == 2) {
                        this.f15383s4.setText(getString(R$string.album_joined_info_text, joinShareAlbumRequestInfo.getLatestJoinAlbumName()));
                    } else if (iIntValue == 7) {
                        this.f15383s4.setText(getString(R$string.album_join_refuse_text, joinShareAlbumRequestInfo.getLatestJoinAlbumName()));
                    }
                }
                TextView textView = this.f15388t4;
                if (textView != null) {
                    textView.setText(C11829c.m70557Z(joinShareAlbumRequestInfo.getJoinRequestTime(), this.f15322e2, false));
                }
                if (this.f15408x4 != null) {
                    JoinShareAlbumHeadPicAdapter joinShareAlbumHeadPicAdapter = new JoinShareAlbumHeadPicAdapter(this);
                    joinShareAlbumHeadPicAdapter.m25056F(joinShareAlbumRequestInfo.getJoinRequesetUserIdList());
                    this.f15408x4.setAdapter(joinShareAlbumHeadPicAdapter);
                    joinShareAlbumHeadPicAdapter.m5213j();
                }
            }
        }
    }

    /* renamed from: Ec */
    public final void m21158Ec() {
        C11839m.m70688i("MainActivity", "updateDriveItemView");
        if (this.f15259R4 == null || this.f15254Q4 == null) {
            C11839m.m70687e("MainActivity", "updateDriveItemView view or adapter is null");
            return;
        }
        m21165Fa(NotifyUtil.getSubpageList(this, true));
        m21457q9();
        m21366eb();
    }

    /* renamed from: F4 */
    public final void m21159F4() {
        Intent intent = getIntent();
        if (intent == null) {
            this.f15292Y1.m65764k("BACKUP_OPTION_ALERT_DIALOG_ID");
        } else if (new HiCloudSafeIntent(intent).getIntExtra("backup_option_enter_status", 0) != 1003) {
            this.f15292Y1.m65764k("BACKUP_OPTION_ALERT_DIALOG_ID");
        } else {
            this.f15292Y1.m65765l("BACKUP_OPTION_ALERT_DIALOG_ID", m21229N5());
            this.f15292Y1.m65754a("BACKUP_OPTION_ALERT_DIALOG_ID");
        }
    }

    /* renamed from: F5 */
    public final void m21160F5() {
        if (this.f15273U3 == null || this.f15295Z == null) {
            return;
        }
        C11839m.m70688i("MainActivity", "MainActivity begin to download map.");
        try {
            new C10474a(this, this.f15273U3, (ImageView) this.f15295Z.findViewById(R$id.phonefind_map_view), this.f15309b5).m64367e();
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("download_map_from", "from_mainactivity_card");
            C13227f.m79492i1().m79567R("mecloud_findmyphone_download_map", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "mecloud_findmyphone_download_map", linkedHashMapM79497A);
            Bundle bundle = new Bundle();
            bundle.putString("operationType", "mapCardLoad");
            bundle.putString(C5807k0.f25949l, "from_mainactivity_card");
            bundle.putString("errorReason", "MainActivity downloadMapImg");
            C1010e.m6125b().m6129D(bundle);
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "downloadMapImg Exception: " + e10.getMessage());
        }
    }

    /* renamed from: F6 */
    public final void m21161F6() {
        NotchFitRelativeLayout notchFitRelativeLayout;
        try {
            if (this.f15171A0 == null) {
                C11839m.m70688i("MainActivity", "initAlbumShareItem()");
                View viewFindViewById = findViewById(R$id.album_share_card_stub);
                if (viewFindViewById instanceof ViewStub) {
                    this.f15171A0 = ((ViewStub) viewFindViewById).inflate();
                }
                View viewM76831d = C12809f.m76831d(this.f15171A0, R$id.album_share_item_layout);
                this.f15359n4 = viewM76831d;
                viewM76831d.setOnClickListener(this);
                this.f15368p4 = (RelativeLayout) C12809f.m76831d(this.f15171A0, R$id.share_album_loading_area);
                m21476sb();
                LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(this.f15171A0, R$id.no_share_album_text_area);
                this.f15373q4 = linearLayout;
                linearLayout.setOnClickListener(this);
                this.f15373q4.setVisibility(8);
                HwButton hwButton = (HwButton) C12809f.m76831d(this.f15171A0, R$id.create_album_button);
                this.f15363o4 = hwButton;
                hwButton.setOnClickListener(this);
                LinearLayout linearLayout2 = (LinearLayout) C12809f.m76831d(this.f15171A0, R$id.has_join_share_album_request_area);
                this.f15378r4 = linearLayout2;
                linearLayout2.setVisibility(8);
                this.f15383s4 = (TextView) C12809f.m76831d(this.f15171A0, R$id.album_share_join_request_text);
                this.f15388t4 = (TextView) C12809f.m76831d(this.f15171A0, R$id.album_share_request_time);
                this.f15393u4 = (NoShareAlbumLayoutView) C12809f.m76831d(this.f15171A0, R$id.no_share_album_layout_view);
                this.f15398v4 = (OneShareAlbumLayoutView) C12809f.m76831d(this.f15171A0, R$id.one_share_album_layout_view);
                this.f15403w4 = (LinearLayout) C12809f.m76831d(this.f15171A0, R$id.some_share_album_area);
                this.f15408x4 = (RecyclerView) C12809f.m76831d(this.f15171A0, R$id.share_album_join_user_head_pic);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(0);
                this.f15408x4.setLayoutManager(linearLayoutManager);
                this.f15408x4.addItemDecoration(new C13406a());
                this.f15413y4 = (RecyclerView) C12809f.m76831d(this.f15171A0, R$id.some_share_album_recyclerview);
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
                linearLayoutManager2.setOrientation(0);
                this.f15413y4.setLayoutManager(linearLayoutManager2);
                this.f15413y4.addItemDecoration(new C13408c());
                boolean zM63300x = C10155f.m63300x();
                if ((zM63300x || C10155f.m63299w()) && this.f15179B4 == null) {
                    C11839m.m70688i("MainActivity", "initAlbumShareItem----albumInfoObserver");
                    this.f15179B4 = new C3378q0();
                    C11737b.m70035b().m70036a(this.f15179B4);
                }
                if (!zM63300x && (notchFitRelativeLayout = this.f15376r0) != null) {
                    notchFitRelativeLayout.setVisibility(8);
                    return;
                }
                InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a != null && interfaceC9282a.mo58413b1()) {
                    C11839m.m70688i("MainActivity", "initAlbumShareItem hasShareDownloadSyncComplete");
                    interfaceC9282a.mo58446o0(this.f15384s5);
                }
                m21354d7();
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "tool view stub inflate exception:" + e10.toString());
        }
    }

    /* renamed from: F7 */
    public final void m21162F7(Activity activity) {
        if (m21437o5()) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        intent.putExtra(FaqConstants.FAQ_CHANNEL, 15000000);
        try {
            activity.startActivityForResult(intent, 10002);
        } catch (Exception unused) {
            C11839m.m70686d("MainActivity", "jumpToAccount fail");
        }
    }

    /* renamed from: F8 */
    public final void m21163F8(String str, String str2, int i10) {
        String str3;
        C13223b.m79477e(this, str, true, i10);
        str.hashCode();
        switch (str) {
            case "addressbook":
                str3 = DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN;
                break;
            case "calendar":
                str3 = "11";
                break;
            case "wlan":
                str3 = PriorInstallWay.PRIOR_ACTION_LANDING_PAGE;
                break;
            case "browser":
                str3 = "20";
                break;
            case "notepad":
                str3 = "10";
                break;
            default:
                str3 = "29";
                break;
        }
        UBAAnalyze.m29955P("PVC", C13471c.m81132e().get(str), "1", str3, i10);
        this.f15326f1.m62336h2(str, true);
        C10155f.m63262O(this, true);
        C13612b.m81829B().m81870k0(getApplicationContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75172d(new C10147j(getApplicationContext(), arrayList, "03003", str2));
    }

    /* renamed from: F9 */
    public final void m21164F9() {
        for (int i10 = 0; i10 < this.f15244O4.size(); i10++) {
            m21358db(this.f15244O4.get(i10));
        }
        for (int i11 = 0; i11 < this.f15249P4.size(); i11++) {
            m21358db(this.f15249P4.get(i11));
        }
    }

    /* renamed from: Fa */
    public final void m21165Fa(ArrayList<DriveConfigService> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f15249P4.clear();
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            DriveConfigService driveConfigService = arrayList.get(i10);
            SyncItemInfo syncItemInfoM21337b6 = m21337b6(driveConfigService.getId(), new SyncItemInfo());
            syncItemInfoM21337b6.setDriveConfig(true);
            syncItemInfoM21337b6.setId(driveConfigService.getId());
            syncItemInfoM21337b6.setTitle(driveConfigService.getTitleText());
            syncItemInfoM21337b6.setSubUser(driveConfigService.isSubUser());
            syncItemInfoM21337b6.setShowDivider(driveConfigService.isShowDivider());
            this.f15249P4.add(syncItemInfoM21337b6);
        }
    }

    /* renamed from: Fb */
    public final void m21166Fb() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f15247P1 = C0212e0.m1354d(C0213f.m1377a(), "more_app_info_sp", "sms_items", false);
        this.f15252Q1 = C0212e0.m1354d(C0213f.m1377a(), "more_app_info_sp", "calllog_items", false);
        this.f15257R1 = C0212e0.m1354d(C0213f.m1377a(), "more_app_info_sp", "recording_items", false);
        this.f15262S1 = C0212e0.m1354d(C0213f.m1377a(), "more_app_info_sp", "phonemanager_items", false);
        if (this.f15247P1) {
            arrayList.add("message");
        }
        if (this.f15252Q1) {
            arrayList.add("calllog");
        }
        if (this.f15257R1) {
            arrayList.add("recording");
        }
        if (this.f15262S1) {
            arrayList.add("interception");
        }
        boolean z10 = this.f15247P1 || this.f15252Q1 || this.f15257R1 || this.f15262S1;
        if (C0209d.m1166E1() && z10) {
            SyncItemInfo syncItemInfo = this.f15245P;
            if (syncItemInfo != null) {
                syncItemInfo.setVisible(8);
                m21264R9(this.f15245P);
            }
            RelativeLayout relativeLayout = this.f15275V;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            m21324Z6(arrayList);
        }
    }

    /* renamed from: Fc */
    public final void m21167Fc(String str) {
        m21149Dc(new RunnableC3341b0(str));
    }

    /* renamed from: G4 */
    public boolean m21168G4() {
        ArrayList arrayList = new ArrayList();
        m21238O5(arrayList);
        return m29141x0(this.f22163b.m69907f(arrayList));
    }

    /* renamed from: G5 */
    public final void m21169G5(int i10) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == R$id.ecology_h5_operation_no_net_btn) {
            C11829c.m70612r1(this);
            return;
        }
        if (i10 == R$id.ecology_h5_operation_nonet) {
            this.f15303a4.setVisibility(8);
            if (!C0209d.m1333z1(this)) {
                m21175Gb();
                return;
            } else {
                this.f15347k4 = false;
                m21350cc(this.f15293Y3, this.f15331g4, this.f15417z3);
                return;
            }
        }
        if (i10 == R$id.ecology_operation_error_url_layout) {
            if (!this.f15347k4) {
                C11839m.m70688i("MainActivity", "invalid page is not support try");
                return;
            }
            this.f15347k4 = false;
            this.f15308b4.setVisibility(8);
            m21350cc(this.f15293Y3, this.f15331g4, this.f15417z3);
            return;
        }
        if (i10 == R$id.album_share_item_layout) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58429h(this, 2);
                C13227f.m79492i1().m79593q0("CLICK_MAIN_SHARE_MORE");
                return;
            }
            return;
        }
        if (i10 == R$id.create_album_button || i10 == R$id.no_share_album_text_area) {
            InterfaceC9282a interfaceC9282a2 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a2 != null) {
                interfaceC9282a2.mo58427g0(this, 2);
            }
            long total = C13368e.m80184F().m80224M().getTotal() / Constants.ONE_GB_SIZE;
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("album_use_space", String.valueOf(total));
            C13227f.m79492i1().m79594r0("CLICK_MAIN_SHARE_CREATE", linkedHashMapM79497A);
            return;
        }
        if (i10 == R$id.has_join_share_album_request_area) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this, "com.huawei.android.cg.activity.ShareAlbumAllMsgActivity"));
            C0224k0.m1542L(this, intent);
            C13227f.m79492i1().m79593q0("CLICK_MAIN_SHARE_MSG");
            LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A2.put("album_msg_count", String.valueOf(this.f15205H));
            C13227f.m79492i1().m79594r0("CLICK_MAIN_SHARE_MSG", linkedHashMapM79497A2);
            return;
        }
        if (i10 == R$id.to_upload_button || i10 == R$id.banner_layout_press) {
            if (!C13452e.m80781L().m80791C0()) {
                m21327Z9("noRecentData");
                m22375i1(this, 12);
                return;
            } else {
                m21333aa("noRecentData");
                m21244P4("newBusinessModelCommonGuidePage", "28");
                m21003Sb(this, 1);
                return;
            }
        }
        if (i10 == R$id.notch_main_family_share_cloud) {
            if (this.f15214I4) {
                C10465b.m64301k(this, 0);
            } else {
                m21498v8();
            }
            C13227f.m79492i1().m79585f0(FamilyShareConstants.Report.CLICK_SPACE_SHARE, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", FamilyShareConstants.Report.CLICK_SPACE_SHARE, "1", "23");
        }
    }

    /* renamed from: G6 */
    public final void m21170G6() {
        C13452e.m80781L().m80887a1();
        if (this.f15170A == null) {
            this.f15170A = (BackupDeviceView) C12809f.m76829b(this, R$id.cloud_backup_vertical_item_view);
        }
        if (this.f15185D == null) {
            this.f15185D = (NewBmBackupItemView) C12809f.m76829b(this, R$id.cloud_backup_item_view_new);
        }
        this.f15185D.setVisibility(0);
        this.f15170A.setVisibility(8);
        if (!C10155f.m63301y() || C0209d.m1293p1()) {
            m21526ya(8);
        } else {
            m21150E4();
        }
    }

    /* renamed from: G7 */
    public final void m21171G7(JumpInactivePageStatus jumpInactivePageStatus) {
        C11839m.m70686d("MainActivity", "JumpInactivePageStatus old:" + this.f15365p + "new:" + jumpInactivePageStatus);
        this.f15365p = this.f15365p.update(jumpInactivePageStatus);
        if (this.f15365p == JumpInactivePageStatus.CAN_JUMP || (C9159b.m57570i() && this.f15365p == JumpInactivePageStatus.JUMPED)) {
            InactiveUserActivity.m28509M2(this, this.f15289X4);
            this.f15365p = JumpInactivePageStatus.JUMPED;
        }
    }

    /* renamed from: G8 */
    public final void m21172G8(Bitmap bitmap) {
        C11839m.m70686d("MainActivity", "procLoadMapSuccess");
        if (this.f15258R3) {
            this.f15263S3 = true;
            m21136C8(false, bitmap);
        }
    }

    /* renamed from: G9 */
    public final void m21173G9() {
        if (C13452e.m80781L().m80887a1() && C13452e.m80781L().m80791C0()) {
            m21384h5();
            m21392i5();
        }
    }

    /* renamed from: Ga */
    public final void m21174Ga(ArrayList<MainMenuItem> arrayList) {
        C11839m.m70688i("MainActivity", "setExchangeMenu start.");
        if (!C13452e.m80781L().m80833N()) {
            C11839m.m70689w("MainActivity", "setExchangeMenu,not support");
            return;
        }
        String strM80990y = C13452e.m80781L().m80990y();
        if (TextUtils.isEmpty(strM80990y)) {
            C11839m.m70689w("MainActivity", "setExchangeMenu,text is null.");
            return;
        }
        String strM80994z = C13452e.m80781L().m80994z();
        String strM1632j = C0234s.m1632j();
        if (TextUtils.equals(strM80994z, strM1632j)) {
            MainMenuItem mainMenuItem = new MainMenuItem(strM80990y, 15);
            if (C2783d.m16139f0()) {
                arrayList.add(mainMenuItem);
                return;
            }
            return;
        }
        C11839m.m70689w("MainActivity", "setExchangeMenu,lan is not equal. exchangeMenuTextLan = " + strM80994z + ", currentLan = " + strM1632j);
    }

    /* renamed from: Gb */
    public void m21175Gb() {
        HwColumnLinearLayout hwColumnLinearLayout = this.f15313c4;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15303a4;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(0);
        }
        SafeWebView safeWebView = this.f15293Y3;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15308b4;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
        m21242O9();
    }

    /* renamed from: Gc */
    public final void m21176Gc() {
        int i10 = this.f15301a1;
        if (i10 == -1 || i10 == 0) {
            m21111z5();
            return;
        }
        if (i10 != 1) {
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("MainActivity", "cloudAlbumRouterImpl is null");
        } else {
            if (interfaceC9282a.mo58378L(this)) {
                return;
            }
            m20981Mb();
        }
    }

    /* renamed from: H5 */
    public final void m21177H5() {
        try {
            CutOutProgressDialog cutOutProgressDialog = this.f15296Z0;
            if (cutOutProgressDialog != null) {
                cutOutProgressDialog.dismiss();
                m21167Fc("");
            }
        } catch (IllegalArgumentException e10) {
            C11839m.m70687e("MainActivity", "Dismiss delete progress dialog " + e10.toString());
        }
        if (this.f15338i1) {
            C2783d.m16138f(this);
        } else {
            C9062b.m57146k().m57155h(false, false);
        }
    }

    /* renamed from: H6 */
    public final void m21178H6() {
        try {
            if (this.f15213I3 == null) {
                View viewFindViewById = findViewById(R$id.bottom_tab_stub);
                if (viewFindViewById instanceof ViewStub) {
                    this.f15213I3 = ((ViewStub) viewFindViewById).inflate();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "tool view stub inflate exception:" + e10.toString());
        }
        com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView hwBottomNavigationView = (com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView) C12809f.m76829b(this, R$id.bottom_tab);
        this.f15178B3 = hwBottomNavigationView;
        if (hwBottomNavigationView == null) {
            C11839m.m70687e("MainActivity", "mBottomNavigationView is null");
            return;
        }
        if (!C13452e.m80781L().m80803F0().booleanValue() || !C10028c.m62182c0().m62413x() || C10794j.m65683j()) {
            C11839m.m70688i("MainActivity", "isInkScreen isPad isFoldScreen hide bottom tab");
            this.f15178B3.setVisibility(8);
        }
        boolean zM65684k = C10794j.m65684k(0);
        this.f15417z3 = zM65684k;
        if (!zM65684k) {
            C11839m.m70686d("MainActivity", "initBottomTab return");
        } else {
            C12515a.m75110o().m75172d(new C3350e0());
        }
    }

    /* renamed from: H7 */
    public void m21179H7() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.phoneservice.renovation.notification");
        C0209d.m1302r2(intent, ICBBroadcastManager.MYHUAWEI_PACKAGE);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("IntentSource", "cloudbackup");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("is_refurbish", String.valueOf(C12591s1.m75931a().m75941k()));
        C13227f.m79492i1().m79591l0("mecloud_backupmain_jump_refurbish", linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_jump_refurbish", "1", "43", "1", "", linkedHashMap);
        C13230i.m79525e1(intent, "1", "85");
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_backup_restore", "1", "85");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("MainActivity", "context is null.");
            return;
        }
        PackageManager packageManager = contextM1377a.getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 10045);
        } else {
            Toast.makeText(this, R$string.cloudbackup_jump_refurbish, 0).show();
            C11839m.m70688i("MainActivity", "refurbish activity is null.");
        }
    }

    /* renamed from: H8 */
    public final void m21180H8() {
        C11839m.m70686d("MainActivity", "procPhoneFinderCard");
        if (this.f15295Z == null) {
            C11839m.m70687e("MainActivity", "phoneFinderCardView is null");
            return;
        }
        if (!C0209d.m1166E1() && !this.f15258R3) {
            this.f15295Z.refreshStatus(false);
            return;
        }
        if (this.f15258R3) {
            m21136C8(true, null);
        } else if (C1010e.m6125b().m6144j()) {
            this.f15295Z.showDefaultMap();
        } else {
            this.f15295Z.refreshStatus(false);
        }
    }

    /* renamed from: H9 */
    public final void m21181H9(List<TaskCenterItem> list, int i10) {
        TaskCenterView taskCenterView = this.f15250Q;
        if (taskCenterView != null) {
            taskCenterView.refreshStatus(list, i10);
        }
    }

    /* renamed from: Ha */
    public final void m21182Ha(ArrayList<MainMenuItem> arrayList) {
        MainMenuItem mainMenuItem = new MainMenuItem(getString(R$string.talkback_help_and_customer_service), 0);
        if (this.f15253Q3) {
            arrayList.add(mainMenuItem);
        }
    }

    /* renamed from: Hb */
    public final void m21183Hb() {
        C11839m.m70688i("MainActivity", "showNonVipInfo");
        this.f15335h4 = "";
        m21113A4(0, 0);
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            return;
        }
        gradientActionBar.setVipIconLayoutShowStatus(8);
        if (C13452e.m80781L().m80887a1()) {
            this.f15329g0.setAvatorVipBgShowStatus(0);
        } else {
            this.f15329g0.setAvatorVipBgShowStatus(4);
        }
    }

    /* renamed from: Hc */
    public final void m21184Hc(String str) {
        m21149Dc(new RunnableC3338a0(str));
    }

    /* renamed from: I4 */
    public final void m21185I4() {
        if (this.f15184C4 == null) {
            return;
        }
        if (!CampaignCheckUtil.checkCampaignEntryCondition(this)) {
            C11839m.m70689w("MainActivity", "checkCampaignEntryFloatViewVisibility checkCampaignEntryCondition is false!");
            m21125B6();
            return;
        }
        if (!C13823d.m82904y().m82911G(C0213f.m1377a(), 6)) {
            C11839m.m70689w("MainActivity", "checkCampaignEntryFloatViewVisibility isChannelsAvailable is false!");
            m21125B6();
            return;
        }
        String strM82940x = C13823d.m82904y().m82940x(6);
        Drawable drawableM82907C = C13823d.m82904y().m82907C(strM82940x);
        if (drawableM82907C == null) {
            C11839m.m70687e("MainActivity", "checkCampaignEntryFloatViewVisibility drawable is null");
            m21125B6();
            return;
        }
        if (MimeType.GIF.equals(C13823d.m82904y().m82933q(strM82940x)) && (drawableM82907C instanceof AnimatedImageDrawable)) {
            ((AnimatedImageDrawable) drawableM82907C).start();
        }
        this.f15184C4.getCampaignImg().setImageDrawable(drawableM82907C);
        m21493ub();
        C13823d.m82904y().m82916L(6, "");
    }

    /* renamed from: I7 */
    public final /* synthetic */ void m21186I7(DialogInterface dialogInterface) {
        this.f15292Y1.m65759f("ADD_ICON_DIALOG_ID");
    }

    /* renamed from: I8 */
    public final void m21187I8() {
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
        C10028c.m62183d0(this).m62377p3("is_exit_finish", false);
        m21263R8(C9062b.m57146k().m57158l(), "local_logout_account");
    }

    /* renamed from: I9 */
    public final void m21188I9(boolean z10, boolean z11) {
        int iM70852q = C11842p.m70852q(this);
        int iM70789a0 = C11842p.m70789a0(this);
        int iM21220M5 = m21220M5(z11);
        if (z10) {
            if (this.f15329g0 != null) {
                m21421lb(this.f15333h0);
                this.f15329g0.m23950l(this.f15333h0, !C11842p.m70732H0(this));
            }
            RelativeLayout relativeLayout = this.f15201G0;
            if (relativeLayout != null) {
                C11842p.m70727F1(relativeLayout, 0);
            }
        } else if (this.f15201G0 != null) {
            if (!C11842p.m70753O0(this.f15414z) || C11842p.m70771U0()) {
                C11842p.m70727F1(this.f15201G0, iM70852q + iM70789a0 + iM21220M5);
            } else {
                C11842p.m70727F1(this.f15201G0, iM21220M5 + iM70852q);
            }
        }
        if (this.f15320e0 != null) {
            if (!C11842p.m70753O0(this.f15414z) || C11842p.m70771U0()) {
                C11842p.m70736I1(this.f15320e0, iM70852q + iM70789a0);
            } else {
                C11842p.m70736I1(this.f15320e0, iM70852q);
            }
        }
    }

    /* renamed from: Ia */
    public final void m21189Ia() {
        C0214f0.m1382b(getApplicationContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit().putBoolean("isFirstUse", false).commit();
    }

    /* renamed from: Ib */
    public final void m21190Ib(Object obj) {
        C11839m.m70688i("MainActivity", "showOneShareAlbumArea");
        m21529z6();
        if (C10155f.m63300x()) {
            NoShareAlbumLayoutView noShareAlbumLayoutView = this.f15393u4;
            if (noShareAlbumLayoutView != null) {
                noShareAlbumLayoutView.setVisibility(8);
            }
            OneShareAlbumLayoutView oneShareAlbumLayoutView = this.f15398v4;
            if (oneShareAlbumLayoutView != null) {
                oneShareAlbumLayoutView.setVisibility(0);
                this.f15398v4.refreshData((ShareAlbumInfo) obj);
            }
            LinearLayout linearLayout = this.f15403w4;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f15373q4;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    /* renamed from: Ic */
    public final void m21191Ic(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        this.f15239N4.put(syncItemInfo.getId(), syncItemInfo);
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        if (syncItemRecyclerAdapter != null) {
            syncItemRecyclerAdapter.m25292h0(this.f15239N4);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: J1 */
    public void mo21192J1() {
        C13008a.m78300b().m78301a(this);
    }

    /* renamed from: J4 */
    public final void m21193J4(ModuleItemForAll moduleItemForAll) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f15247P1 = moduleItemForAll.hasSmsData();
        this.f15252Q1 = moduleItemForAll.hasCallLogData();
        this.f15257R1 = moduleItemForAll.hasRecordingData();
        this.f15262S1 = moduleItemForAll.hasPhoneManagerData();
        C11839m.m70688i("MainActivity", "smsdata:" + this.f15247P1 + ", calllogdata:" + this.f15252Q1 + ", recordingdata:" + this.f15257R1 + ", phonemanagerdata:" + this.f15262S1);
        if (this.f15247P1) {
            arrayList.add("message");
        }
        if (this.f15252Q1) {
            arrayList.add("calllog");
        }
        if (this.f15257R1) {
            arrayList.add("recording");
        }
        if (this.f15262S1) {
            arrayList.add("interception");
        }
        boolean z10 = this.f15247P1 || this.f15252Q1 || this.f15257R1 || this.f15262S1;
        if (!C0209d.m1166E1() || !z10) {
            this.f15275V.setVisibility(8);
            return;
        }
        this.f15245P.setVisible(8);
        this.f15275V.setVisibility(0);
        m21324Z6(arrayList);
        m21264R9(this.f15245P);
    }

    /* renamed from: J5 */
    public final void m21194J5() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("file_clean_gallery", false);
        boolean booleanExtra2 = hiCloudSafeIntent.getBooleanExtra("file_to_release_space", false);
        if (booleanExtra) {
            intent.removeExtra("file_clean_gallery");
            intent.removeExtra("file_to_release_space");
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("callingPackage", NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            linkedHashMapM79499C.put("isFromFileCleanGallery", String.valueOf(booleanExtra));
            linkedHashMapM79499C.put("isRelease", String.valueOf(booleanExtra2));
            linkedHashMapM79499C.put("sourceType", String.valueOf(2));
            linkedHashMapM79499C.put("isOpenSwitch", String.valueOf(true));
            linkedHashMapM79499C.put("isBasicBusiness", String.valueOf(C13452e.m80781L().m80791C0()));
            C13227f.m79492i1().m79567R("gallery_openswitch_data_info", linkedHashMapM79499C);
            UBAAnalyze.m29947H("PVC", "gallery_openswitch_data_info", linkedHashMapM79499C);
            if (!C13452e.m80781L().m80791C0()) {
                InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a != null) {
                    interfaceC9282a.mo58386P(this, 10053, booleanExtra2);
                    return;
                }
                return;
            }
            C11839m.m70688i("MainActivity", "jump to cloud space upgrade page.");
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b != null) {
                interfaceC9283b.mo58515k(this, "OPEN_CLOUD_PHOTO_FROM_OTHER");
            } else {
                C11839m.m70687e("MainActivity", "cloudBackupRouter is null");
            }
        }
    }

    /* renamed from: J6 */
    public final void m21195J6() {
        C11839m.m70688i("MainActivity", "initCampaignEntryView");
        if (C13823d.m82904y().m82912H()) {
            C11839m.m70688i("MainActivity", "isRedundantQuery is true");
            m21450pa();
            m21442oa();
            m21458qa(true);
            return;
        }
        if (C9718g.m60602t().m60607E(this, true)) {
            C11839m.m70688i("MainActivity", "initCampaignEntryView isCampaignValid!");
        } else {
            m20964H4();
            C13823d.m82902O(System.currentTimeMillis());
        }
    }

    /* renamed from: J7 */
    public final /* synthetic */ void m21196J7() {
        AlertDialog alertDialogM16457q = this.f15229L4.m16457q(this.f15329g0.findViewById(R$id.ic_more_hot_space), NewHiSyncSettingActivity.class);
        this.f15292Y1.m65765l("ADD_ICON_DIALOG_ID", alertDialogM16457q);
        this.f15292Y1.m65754a("ADD_ICON_DIALOG_ID");
        alertDialogM16457q.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.huawei.android.hicloud.ui.activity.l6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f17666a.m21186I7(dialogInterface);
            }
        });
    }

    /* renamed from: J8 */
    public final void m21197J8() {
        LinearLayout linearLayout = this.f15305b0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        } else {
            C11839m.m70687e("MainActivity", "processAfterGetConfig safeInfoRegion is null");
        }
        m21119Aa(null);
    }

    /* renamed from: J9 */
    public final void m21198J9(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            C11839m.m70688i("MainActivity", "refreshUserPhoto photo is wrong! bitmap is " + (bitmap == null ? "null" : "recycled"));
            return;
        }
        Bitmap bitmap2 = this.f15401w0;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.f15401w0 = bitmap;
        this.f15181C0.setBackground(getResources().getDrawable(R$drawable.avatar_bg_circle));
        this.f15181C0.setImageBitmap(this.f15401w0);
    }

    /* renamed from: Ja */
    public final void m21199Ja(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            if (z10) {
                syncItemInfo.setStatusText(getString(R$string.cloudalbum_switch_open));
            } else {
                syncItemInfo.setStatusText(getString(R$string.sync_switch_button_close));
                syncItemInfo.setNoSubTitle(true);
                syncItemInfo.setShowSubTitle(false);
            }
            m21137C9(syncItemInfo);
            if (C10155f.m63299w()) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 9010;
                messageObtain.obj = Boolean.valueOf(z10);
                this.f15309b5.sendMessage(messageObtain);
            }
        }
    }

    /* renamed from: Jb */
    public void m21200Jb(boolean z10) {
        if (z10) {
            this.f15412y3.showSubDataListView();
        } else {
            this.f15412y3.hideSubDataListView();
        }
    }

    /* renamed from: Jc */
    public final void m21201Jc() {
        SyncItemInfo syncItemInfoM25274M;
        C11839m.m70688i("MainActivity", "refreshSyncItemView");
        if (this.f15259R4 == null || this.f15254Q4 == null) {
            C11839m.m70687e("MainActivity", "syncItemsView or syncListAdapter is null");
            return;
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this);
        ArrayList<DriveConfigService> subpageList = NotifyUtil.getSubpageList(this, false);
        if (shownSyncServiceItems.size() + subpageList.size() > 0) {
            C11839m.m70688i("MainActivity", "refreshSyncItemView shown items count = " + shownSyncServiceItems.size());
            for (int i10 = 0; i10 < shownSyncServiceItems.size(); i10++) {
                SyncConfigService syncConfigService = shownSyncServiceItems.get(i10);
                if (syncConfigService != null && (syncItemInfoM25274M = this.f15254Q4.m25274M(syncConfigService.getId())) != null && syncItemInfoM25274M.isSyncConfig()) {
                    syncConfigService.setSwitchStatus(Boolean.valueOf(m21203K5(syncItemInfoM25274M.getId(), C10028c.m62182c0().m62388s(syncItemInfoM25274M.getId()) || syncItemInfoM25274M.isSwitchStatus())));
                    syncConfigService.setSyncItemSubtitleStatus(syncItemInfoM25274M.getSyncItemSubtitleStatus());
                    syncConfigService.setSubStringText(syncItemInfoM25274M.getSubStringText());
                }
            }
            m21436nc();
            m21390hb(shownSyncServiceItems);
            m21165Fa(subpageList);
            m21164F9();
        } else {
            C11839m.m70688i("MainActivity", "refreshSyncItemView get OM services is null or empty ");
            m21436nc();
        }
        m21366eb();
    }

    /* renamed from: K4 */
    public final void m21202K4(int i10) {
        if (i10 == R$id.manage_space_storagebar_frame || i10 == R$id.frag_storage_text_frame || i10 == R$id.manage_space_entrance || i10 == R$id.rl_manage_space_entrance || i10 == R$id.membership_expired_manage_space_entrance) {
            C11839m.m70688i("MainActivity", "checkCloudStorageClick storageClick = true");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("result", String.valueOf(i10));
            C13227f.m79492i1().m79552E0("CLICK_MAIN_MANAGER", linkedHashMapM79497A);
            C13227f.m79492i1().m79585f0("mecloud_main_click_storage", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_storage", "1", "7");
            m21153E7();
            return;
        }
        C11839m.m70688i("MainActivity", "checkCloudStorageClick storageClick = false, id = " + i10);
        LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A2.put("result", String.valueOf(i10));
        C13227f.m79492i1().m79552E0("CLICK_NOT_MAIN_MANAGER", linkedHashMapM79497A2);
        this.f15367p1 = false;
    }

    /* renamed from: K5 */
    public final boolean m21203K5(String str, boolean z10) {
        if (!C13452e.m80781L().m80887a1() || !C13452e.m80781L().m80791C0() || !C1008c.m6035v().m6037B(this.f15414z).contains(str) || !z10) {
            return z10;
        }
        if (!C10028c.m62182c0().m62388s(str)) {
            return false;
        }
        if (C1006a.m5936k().m5973t() && StringUtil.equals(str, NotifyUtil.HI_NOTE_SYNC_TYPE) && C1008c.m6035v().m6108z(this, str) == 1) {
            C11839m.m70689w("MainActivity", "inRetentionPeriod & h5 open closeSwitch hinote return");
            return z10;
        }
        C11839m.m70688i("MainActivity", "need close switch by nn, type = " + str);
        m21347c9(str, 12);
        return false;
    }

    /* renamed from: K6 */
    public final void m21204K6() {
        m21284U6();
    }

    /* renamed from: K7 */
    public final /* synthetic */ void m21205K7(boolean z10) {
        if (z10) {
            C11839m.m70688i("MainActivity", "honor icon is exist");
            this.f15292Y1.m65764k("ADD_ICON_DIALOG_ID");
        } else {
            if (this.f15229L4.m16464x("cloudSpaceNoReminder")) {
                C11839m.m70688i("MainActivity", "getHonorIconDialog no reminder");
                return;
            }
            C13227f.m79492i1().m79567R("mecloud_icon_is_not_exist", new LinkedHashMap<>());
            UBAAnalyze.m29943D("CKC", "mecloud_icon_is_not_exist");
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.e6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17598a.m21196J7();
                }
            });
        }
    }

    /* renamed from: K8 */
    public final void m21206K8() {
        C9904a.m61488b().m61492e(this.f15305b0);
    }

    /* renamed from: K9 */
    public final void m21207K9(boolean z10) {
        boolean zM16151j0 = C2783d.m16151j0();
        boolean zM16139f0 = C2783d.m16139f0();
        m21532z9(zM16139f0);
        if (z10) {
            m21188I9(zM16139f0, zM16151j0);
        }
    }

    /* renamed from: Ka */
    public void m21208Ka(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("MainActivity", "WebSettings is null.");
            return;
        }
        settings.setUserAgentString(settings.getUserAgentString() + "; " + ("HiDiskCloudService/com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)"));
    }

    /* renamed from: Kb */
    public final void m21209Kb(boolean z10, int i10) {
        if (m21336b5()) {
            C11839m.m70687e("MainActivity", "view is null");
            return;
        }
        boolean zM16151j0 = C2783d.m16151j0();
        if (!C11829c.m70532M0()) {
            Handler handler = this.f15324e5;
            if (handler != null) {
                handler.postDelayed(this.f15336h5, 200L);
                return;
            }
            return;
        }
        C11839m.m70686d("MainActivity", "showOrHideFunctionItemView itemSwitch:" + z10);
        if (z10) {
            m21143D6();
        } else {
            m21130Bb(zM16151j0, i10);
        }
    }

    /* renamed from: L4 */
    public final void m21210L4() {
        C11839m.m70688i("MainActivity", "checkCloudUpdateItem");
        if (m21489u7()) {
            return;
        }
        m21274Sa();
        PopupWindow popupWindow = this.f15297Z1;
        if (popupWindow == null || !popupWindow.isShowing() || this.f15312c2 == null) {
            return;
        }
        C11839m.m70688i("MainActivity", "checkCloudUpdateItem,remove item view!");
        this.f15312c2.m827d(14);
    }

    /* renamed from: L6 */
    public final void m21211L6() {
        this.f15296Z0 = new CutOutProgressDialog(this);
        if (this.f15370q != null) {
            this.f15370q = null;
        }
    }

    /* renamed from: L7 */
    public final /* synthetic */ void m21212L7(DialogInterface dialogInterface) {
        C10804r c10804r = this.f15292Y1;
        if (c10804r != null) {
            c10804r.m65759f("ADD_ICON_DIALOG_ID");
        }
    }

    /* renamed from: L8 */
    public final void m21213L8(Intent intent) {
        C11839m.m70688i("MainActivity", "processCampaignCard");
        if (CampaignCheckUtil.checkCampaignEntryCondition(this)) {
            C12515a.m75110o().m75172d(new C3379r(intent));
        } else {
            C11839m.m70688i("MainActivity", "processCampaignCard checkCampaignEntryCondition is false!");
            m21115A6();
        }
    }

    /* renamed from: L9 */
    public final void m21214L9(Message message) {
        Object obj = message.obj;
        if (obj instanceof UserPackage) {
            UserPackage userPackage = (UserPackage) obj;
            this.f15399v5 = userPackage;
            int userPayType = userPackage.getUserPayType();
            C11839m.m70686d("MainActivity", " payType " + userPayType);
            if (userPayType == 0) {
                m21120Ab(userPackage);
            } else {
                m21305Wb(userPackage);
            }
            m21195J6();
        }
    }

    /* renamed from: La */
    public final void m21215La(final ArrayList<MainMenuItem> arrayList) {
        if (C0209d.m1269j1()) {
            this.f15229L4.m16461u(new IconManager.IconCallBack() { // from class: com.huawei.android.hicloud.ui.activity.s6
                @Override // com.huawei.android.hicloud.manager.IconManager.IconCallBack
                /* renamed from: a */
                public final void mo16467a(boolean z10) {
                    this.f17729a.m21372f8(arrayList, z10);
                }
            });
        } else if (this.f15229L4.m16463w(getPackageName())) {
            C11839m.m70688i("MainActivity", "app icon is exist");
        } else {
            arrayList.add(0, new MainMenuItem(getString(R$string.add_icon_menu_item), 13));
        }
    }

    /* renamed from: Lb */
    public final void m21216Lb(PayActivityInfo payActivityInfo) {
        String strM1524g;
        if (payActivityInfo != null) {
            C11839m.m70686d("MainActivity", "pushGuideDialog is to be popuped");
            strM1524g = C0223k.m1524g(this.f15414z, payActivityInfo.getCapacity());
        } else {
            C11839m.m70688i("MainActivity", "pushGuideDialog payactivityinfo is null");
            strM1524g = "";
        }
        String[] currentContentString = HicloudPushGuideManager.getInstance().getCurrentContentString();
        if (currentContentString.length == 0) {
            C11839m.m70688i("MainActivity", "currentContentString is null");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        String str = currentContentString[0];
        String str2 = currentContentString[1];
        String str3 = currentContentString[2];
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70688i("MainActivity", "dialog string is null");
            m21147Da("PUSH_MARKETING_NOTICE");
            return;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(strM1524g) || !C2783d.m16139f0()) {
            this.f15193E3 = false;
            Dialog dialogPrepareDialog = this.f15317d2.prepareDialog(this, this, str, str2, "");
            this.f15281W0 = dialogPrepareDialog;
            this.f15292Y1.m65765l("PUSH_MARKETING_NOTICE", dialogPrepareDialog);
            this.f15292Y1.m65754a("PUSH_MARKETING_NOTICE");
            return;
        }
        this.f15193E3 = true;
        this.f15317d2.setPayActivityInfo(payActivityInfo);
        Dialog dialogPrepareDialog2 = this.f15317d2.prepareDialog(this, this, str, str2, String.format(Locale.ENGLISH, str3, strM1524g));
        this.f15281W0 = dialogPrepareDialog2;
        this.f15292Y1.m65765l("PUSH_MARKETING_NOTICE", dialogPrepareDialog2);
        this.f15292Y1.m65754a("PUSH_MARKETING_NOTICE");
    }

    /* renamed from: Lc */
    public final void m21217Lc(String str, Bundle bundle) {
        String str2;
        int i10 = bundle.getInt("queryh5oknum");
        C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog  queryH5OkNum: " + i10);
        String string = bundle.getString("packageId");
        String string2 = bundle.getString(NotifyConstants.Keys.NOTIFY_TYPE);
        String string3 = bundle.getString(NotifyConstants.Keys.NOTIFY_URI);
        String string4 = bundle.getString("h5Uri");
        String string5 = bundle.getString("activeUri");
        String string6 = bundle.getString("gradeCode");
        String string7 = bundle.getString("expireTime");
        int i11 = bundle.getInt("agd_resource_enable");
        String string8 = bundle.getString("agd_resource_slot_id");
        int i12 = bundle.getInt("pps_threshold");
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", string4);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, string2);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, string3);
            intent.putExtra("packageId", string);
            intent.putExtra("activeUri", string5);
            intent.putExtra("gradeCode", string6);
            intent.putExtra("expireTime", string7);
            intent.putExtra("agd_resource_enable", i11);
            intent.putExtra("agd_resource_slot_id", string8);
            intent.putExtra("pps_threshold", i12);
            if (i10 == 8) {
                intent.putExtra("action_bar_color_hm_os_bg", true);
                intent.putExtra("is_support_dark_mode", true);
            }
            intent.putExtra("fromMessage", true);
            GuideWebViewActivity.m20586z2(this.f15292Y1);
            startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this, "switch_suggest_dialog_sp", "guide_backup_switch_notify_time", jCurrentTimeMillis);
            str2 = "MainActivity";
            try {
                C11839m.m70688i(str2, " QueryGuideH5Task toShowGuideH5Dialog System.currentTimeMillis(): " + jCurrentTimeMillis);
                this.f15292Y1.m65762i(str);
            } catch (Exception e10) {
                e = e10;
                C11839m.m70687e(str2, "viewWeb Exception: " + e.toString());
            }
        } catch (Exception e11) {
            e = e11;
            str2 = "MainActivity";
        }
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: M */
    public void mo7529M(boolean z10) {
        C12515a.m75110o().m75172d(new C11257e(this, z10, this.f15411y1, this.f15416z1, this.f15172A1));
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: M0 */
    public void mo21218M0() {
        super.mo21218M0();
        if (this.f15229L4.m16465y()) {
            C11839m.m70686d("MainActivity", "mIconManager isShow");
        } else if (C0209d.m1269j1()) {
            m21469s4();
        } else {
            m21478t4();
        }
    }

    /* renamed from: M4 */
    public final void m21219M4() {
        if (C13452e.m80781L().m80849R() && !C13452e.m80781L().m80791C0()) {
            if (C13452e.m80781L().m80862U0()) {
                Toast.makeText(this.f15414z, getString(R$string.membership_service_restored_toast), 0).show();
            }
            C13452e.m80781L().m80981v2(false);
        }
    }

    /* renamed from: M5 */
    public final int m21220M5(boolean z10) {
        if (z10) {
            return C11842p.m70840n(this, 16);
        }
        return 0;
    }

    /* renamed from: M6 */
    public final void m21221M6() {
        m21151E5(Constant.C2794f.m16246a());
    }

    /* renamed from: M7 */
    public final /* synthetic */ void m21222M7() {
        C13227f.m79492i1().m79567R("mecloud_icon_is_not_exist", new LinkedHashMap<>());
        UBAAnalyze.m29943D("CKC", "mecloud_icon_is_not_exist");
        if (!this.f15229L4.m16434A("cloudLasttime")) {
            m21147Da("ADD_ICON_DIALOG_ID");
            return;
        }
        AlertDialog alertDialogM16455o = this.f15229L4.m16455o(this.f15329g0.findViewById(R$id.ic_more_hot_space));
        C10804r c10804r = this.f15292Y1;
        if (c10804r != null) {
            c10804r.m65765l("ADD_ICON_DIALOG_ID", alertDialogM16455o);
            this.f15292Y1.m65754a("ADD_ICON_DIALOG_ID");
        }
        alertDialogM16455o.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.huawei.android.hicloud.ui.activity.i6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f17638a.m21212L7(dialogInterface);
            }
        });
    }

    /* renamed from: M8 */
    public final void m21223M8(boolean z10, String str, int i10) {
        C11839m.m70688i("MainActivity", "processCheckedChanged, syncType: " + str + ", isChecked = " + z10 + ", isRefreshSwitchStatus = " + this.f15346k1);
        C1008c.m6035v().m6051P(this.f15414z, null, false);
        if (z10) {
            m21356d9(str);
            return;
        }
        this.f15346k1 = true;
        if (this.f15251Q0.containsKey(str) && this.f15251Q0.get(str) != null) {
            this.f15251Q0.get(str).dismiss();
            m21184Hc("");
        }
        m21347c9(str, i10);
    }

    /* renamed from: M9 */
    public final void m21224M9() {
        C11839m.m70687e("MainActivity", "registerPackagesChangeReceiver");
        if (this.f15236N0 == null) {
            this.f15236N0 = new C3351e1(this.f15239N4);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            registerReceiver(this.f15236N0, intentFilter);
        }
    }

    /* renamed from: Ma */
    public final void m21225Ma(SpanClickText spanClickText, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(NavigationUtils.SMS_SCHEMA_PREF, this.f15247P1);
        bundle.putBoolean("calllog", this.f15252Q1);
        bundle.putBoolean("recordig", this.f15257R1);
        bundle.putBoolean("phonemanager", this.f15262S1);
        bundle.putBoolean("isShowCloudDisk", false);
        BackupLinkClickListener backupLinkClickListener = new BackupLinkClickListener(this.f15414z, spanClickText);
        C3384t0 c3384t0 = new C3384t0(this.f15414z, spanClickText, bundle);
        spanClickText.m15931c(str2, backupLinkClickListener);
        spanClickText.m15931c(str3, c3384t0);
        spanClickText.m15934g(str, false);
    }

    /* renamed from: Mc */
    public final void m21226Mc(int i10) {
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            C11839m.m70687e("MainActivity", "visibleGradientActionbar mGradientActionbar is null.");
            return;
        }
        if (i10 == 1) {
            gradientActionBar.setToolActionMainVisibility(0);
            this.f15329g0.setMainLayoutVisibility(8);
            C11842p.m70720D0(this);
        } else {
            C11842p.m70720D0(this);
            this.f15329g0.setToolActionMainVisibility(8);
            this.f15329g0.setMainLayoutVisibility(0);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: N0 */
    public void mo21227N0() {
    }

    /* renamed from: N4 */
    public final void m21228N4(String str) {
        m21273S9(str);
        if (str == null || this.f15292Y1.m65756c(str) == null || m21530z7()) {
            if ("GET_SPACE_OK_H5_DIALOG".equals(str) && !m21530z7()) {
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId = GET_SPACE_OK_H5_DIALOG");
                m21511wc(str);
                return;
            } else {
                if (!"SPACE_FULL".equals(str) || m21530z7()) {
                    return;
                }
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId = SPACE_FULL");
                m21131Bc(str);
            }
        }
        str.hashCode();
        switch (str) {
            case "GUIDE_H5_WEBVIEW_DAILOG":
                C11839m.m70688i("MainActivity", "QueryGuideH5Task checkDialogCanShow dialogId = GUIDE_H5_WEBVIEW_DAILOG");
                m21528yc(str);
                break;
            case "POLICY_SERVICE":
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId = POLICY_SERVICE");
                m21534zc(str);
                break;
            case "BACKUP_OPTION_ALERT_DIALOG_ID":
                C11839m.m70688i("MainActivity", "show backup option alert, dialogId = " + str);
                m21494uc(str);
                break;
            case "ADD_ICON_DIALOG_ID":
                C11839m.m70688i("MainActivity", "add icon dialog show, dialogId = " + str);
                this.f15292Y1.m65756c(str).show();
                this.f15292Y1.m65762i(str);
                break;
            case "GUIDE_BACKUP_SWITCH":
                C11839m.m70688i("MainActivity", "guide backup switch dialogId = " + str);
                m21520xc(str);
                break;
            case "CLAM_POP":
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId = CLAM_POP");
                m21502vc(str);
                break;
            case "PUSH_MARKETING_NOTICE":
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId = PUSH_MARKETING_NOTICE");
                m21121Ac(str);
                break;
            default:
                C11839m.m70688i("MainActivity", "checkDialogCanShow dialogId not satify");
                break;
        }
    }

    /* renamed from: N5 */
    public final AlertDialogC13154a m21229N5() {
        BackupOptionAlertDialog backupOptionAlertDialog = new BackupOptionAlertDialog(this);
        this.f15291Y0 = backupOptionAlertDialog;
        backupOptionAlertDialog.setMessage(getString(R$string.enter_option_backup_restoring_note));
        return this.f15291Y0;
    }

    /* renamed from: N6 */
    public final void m21230N6() {
        C11839m.m70688i("MainActivity", "initDriveItemView");
        ArrayList<DriveConfigService> subpageList = NotifyUtil.getSubpageList(this, true);
        m21165Fa(subpageList);
        m21457q9();
        if (subpageList.isEmpty()) {
            C11839m.m70688i("MainActivity", "initDriveItemView showSubpageList is empty");
            return;
        }
        C11839m.m70688i("MainActivity", "initDriveItemView noShowSubpageList count = " + subpageList.size());
    }

    /* renamed from: N7 */
    public final /* synthetic */ void m21231N7(GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        C9718g.m60602t().m60622Z(getCampaignActivityEntryResp);
        m21248P9();
        C13823d.m82902O(System.currentTimeMillis());
    }

    /* renamed from: N8 */
    public final void m21232N8(boolean z10, String str, int i10) {
        C11839m.m70688i("MainActivity", "processCheckedChangedFromBackUp, syncType: " + str + ", isChecked = " + z10 + ", isRefreshSwitchStatus = " + this.f15346k1);
        if (z10) {
            m21364e9(str, i10);
        } else {
            this.f15346k1 = true;
            m21347c9(str, i10);
        }
    }

    /* renamed from: N9 */
    public final void m21233N9() {
        if (this.f15194E4) {
            C11839m.m70688i("MainActivity", "hasRegisterHook");
            return;
        }
        this.f15194E4 = true;
        C11839m.m70688i("MainActivity", "registerTimeOutHook");
        try {
            m21434na(101, 5000L);
            m21434na(102, 30000L);
        } catch (Exception unused) {
            C11839m.m70687e("MainActivity", "registerTimeOutHook error");
        }
    }

    /* renamed from: Na */
    public final void m21234Na(String str) {
        TextView textView = this.f15318d4;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: Nb */
    public final void m21235Nb(Object obj) {
        C11839m.m70688i("MainActivity", "showSomeShareAlbum");
        List<ShareAlbumInfo> list = (List) obj;
        m21529z6();
        if (C10155f.m63300x()) {
            NoShareAlbumLayoutView noShareAlbumLayoutView = this.f15393u4;
            if (noShareAlbumLayoutView != null) {
                noShareAlbumLayoutView.setVisibility(8);
            }
            OneShareAlbumLayoutView oneShareAlbumLayoutView = this.f15398v4;
            if (oneShareAlbumLayoutView != null) {
                oneShareAlbumLayoutView.setVisibility(8);
            }
            LinearLayout linearLayout = this.f15403w4;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                if (this.f15413y4 != null) {
                    if (this.f15204G4 == null) {
                        SomeShareAlbumAdapter someShareAlbumAdapter = new SomeShareAlbumAdapter(this);
                        this.f15204G4 = someShareAlbumAdapter;
                        this.f15413y4.setAdapter(someShareAlbumAdapter);
                    }
                    this.f15204G4.m25225H(list);
                    this.f15204G4.m5213j();
                }
            }
            LinearLayout linearLayout2 = this.f15373q4;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    /* renamed from: Nc */
    public final void m21236Nc(String str) {
        this.f15298Z3.setVisibility(0);
        this.f15290Y.setVisibility(8);
        SafeWebView safeWebView = this.f15293Y3;
        if (safeWebView != null) {
            safeWebView.setVisibility(0);
        }
        if (!C0209d.m1333z1(this)) {
            m21175Gb();
        } else if (!TextUtils.isEmpty(str) && !this.f15347k4) {
            m21313Xb(this.f15293Y3, this.f15343j4);
        } else {
            C11839m.m70687e("MainActivity", "startLoadWebView url is invalid.");
            m21297Vb();
        }
    }

    /* renamed from: O4 */
    public final boolean m21237O4() {
        long jM1427d = C0216g0.m1402e(this).m1427d();
        C11839m.m70688i("MainActivity", "checkHwidRecomInterval lastEnterByHwidRecom = " + jM1427d);
        return System.currentTimeMillis() - jM1427d > 86400000;
    }

    /* renamed from: O5 */
    public final void m21238O5(List<String> list) {
        list.add(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (m21100v7("calendar")) {
            list.add("backup_calendar");
        }
        if (m21100v7("calllog")) {
            list.add("backup_calllog");
        }
        if (m21100v7(HNConstants.DataType.CONTACT)) {
            list.add("backup_contact");
        }
        if (m21100v7(NavigationUtils.SMS_SCHEMA_PREF)) {
            list.add("backup_sms");
        }
    }

    /* renamed from: O6 */
    public final void m21239O6() {
        ArrayList<SyncItemInfo> arrayListM21345c6;
        C11839m.m70688i("MainActivity", "initDriveItemsSwitch start");
        if (this.f15254Q4 == null || (arrayListM21345c6 = m21345c6()) == null || arrayListM21345c6.isEmpty()) {
            return;
        }
        Iterator<SyncItemInfo> it = arrayListM21345c6.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            next.setSwitchStatus(this.f15326f1.m62388s(next.getId()));
        }
        this.f15254Q4.m5213j();
    }

    /* renamed from: O7 */
    public final /* synthetic */ void m21240O7(HashMap map, View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        C9159b.m57572k("click_inActive_text");
        InactiveUserActivity.m28535s2(this, map);
    }

    /* renamed from: O8 */
    public final void m21241O8() {
        C12515a.m75110o().m75172d(new C3363j());
    }

    /* renamed from: O9 */
    public final void m21242O9() {
        if (!this.f15194E4) {
            C11839m.m70688i("MainActivity", "releaseScheduleTask return");
            return;
        }
        this.f15194E4 = false;
        HandlerC3357g1 handlerC3357g1 = this.f15189D4;
        if (handlerC3357g1 != null) {
            handlerC3357g1.obtainMessage(100, Boolean.TRUE).sendToTarget();
            if (this.f15189D4.hasMessages(101)) {
                this.f15189D4.removeMessages(101);
            }
            if (this.f15189D4.hasMessages(102)) {
                this.f15189D4.removeMessages(102);
            }
        }
    }

    /* renamed from: Ob */
    public final void m21243Ob(long j10) {
        boolean zM21298W4 = m21298W4();
        boolean zM21237O4 = m21237O4();
        boolean z10 = zM21298W4 && zM21237O4;
        C11839m.m70688i("MainActivity", "isDialogNeedShow = " + z10 + ", fullDailogFreq = " + zM21298W4 + ", checkHwidRecomInterval = " + zM21237O4);
        m21279T9(zM21298W4, zM21237O4, isDestroyed());
        if (!z10 || isDestroyed()) {
            m21147Da("SPACE_FULL");
            return;
        }
        this.f15372q1 = C11333k.m68086b().m68090e(j10);
        if (this.f15402w1) {
            this.f15292Y1.m65765l("SPACE_FULL", null);
            this.f15292Y1.m65754a("SPACE_FULL");
        } else {
            C11839m.m70688i("MainActivity", "MainActivity is not running foreground");
            this.f15377r1 = true;
            this.f15292Y1.m65765l("SPACE_FULL", null);
            this.f15292Y1.m65754a("SPACE_FULL");
        }
    }

    /* renamed from: P4 */
    public final void m21244P4(String str, String str2) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        GraySwitch graySwitchM60764w = C9733f.m60705z().m60764w(str);
        if (graySwitchM60764w == null || graySwitchM60764w.getStatus() == 0) {
            C11839m.m70686d("MainActivity", "jumpCloudUpgradePage switchValue closed ");
            m21144D7(str2);
            return;
        }
        try {
            String string = new JSONObject(graySwitchM60764w.getParameters()).getString("url");
            if (!TextUtils.isEmpty(string)) {
                m21135C7(string);
                return;
            }
        } catch (JSONException e10) {
            C11839m.m70689w("MainActivity", "FeatureSwitch parse failed: " + e10.getMessage());
        }
        m21144D7(str2);
    }

    /* renamed from: P6 */
    public final boolean m21245P6() {
        boolean z10 = false;
        if (this.f15254Q4 == null) {
            return false;
        }
        ArrayList<SyncItemInfo> arrayListM21345c6 = m21345c6();
        if (arrayListM21345c6.isEmpty()) {
            return false;
        }
        Iterator<SyncItemInfo> it = arrayListM21345c6.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            boolean zM62388s = this.f15326f1.m62388s(next.getId());
            next.setSwitchStatus(zM62388s);
            if (zM62388s) {
                C3948f.m24064g().m24078r(next.getId(), 1);
                if (next.isSyncConfig()) {
                    z10 = true;
                }
            }
            m21191Ic(next);
            m21375fb();
        }
        this.f15254Q4.m5213j();
        return z10;
    }

    /* renamed from: P7 */
    public final /* synthetic */ void m21246P7(Dialog dialog) {
        this.f15286X0.dismiss();
        this.f15286X0 = null;
    }

    /* renamed from: P8 */
    public final void m21247P8(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("entry_key");
                if (!TextUtils.isEmpty(stringExtra)) {
                    C13622a.m81973s(this, "entry: " + stringExtra, "click");
                    C13223b.m79473a(this, stringExtra, "1");
                    UBAAnalyze.m29954O("PVC", stringExtra, "1", "100");
                    if ("click_desktop".equals(stringExtra)) {
                        C13452e.m80781L().m80789B2("desktop_login");
                    } else if ("click_notification".equals(stringExtra)) {
                        C13452e.m80781L().m80789B2("notification_login");
                        new BackupNotificationManager(this).cancelNotification(275);
                    }
                }
            } catch (Exception unused) {
                C11839m.m70687e("MainActivity", "processClickReLogin exception");
            }
        }
    }

    /* renamed from: P9 */
    public final void m21248P9() {
        C11839m.m70688i("MainActivity", "reloadCampaignEntryView");
        C13108a.m78878b(this).m78881d(new Intent(RecommendCardConstants.UPGRADE_BANNER_CONFIG_UPDATE));
        if (this.f15304a5 == null) {
            C11839m.m70687e("MainActivity", "reloadCampaignEntryView mHandler is null");
            return;
        }
        m21450pa();
        m21458qa(false);
        m21442oa();
    }

    /* renamed from: Pa */
    public final int m21249Pa(int i10) throws Resources.NotFoundException {
        int dimension;
        double d10;
        double d11;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        float f10 = displayMetrics.widthPixels;
        if (C11842p.m70771U0()) {
            if (C11842p.m70753O0(this)) {
                d10 = f10;
                d11 = 0.4d;
            } else {
                d10 = f10;
                d11 = 0.6d;
            }
            dimension = (int) (d10 * d11);
        } else if (C11842p.m70753O0(this)) {
            dimension = (int) ((f10 - getResources().getDimension(R$dimen.cloud_space_402_dp)) + getResources().getDimension(R$dimen.cloud_space_24_dp));
        } else {
            dimension = (int) f10;
        }
        if (dimension <= 0) {
            dimension = (int) f10;
        }
        return Math.min(dimension, i10 + ((int) getResources().getDimension(R$dimen.cloud_space_32_dp)));
    }

    /* renamed from: Pb */
    public final void m21250Pb(String str) {
        try {
            this.f15377r1 = false;
        } catch (WindowManager.BadTokenException unused) {
            C11839m.m70687e("MainActivity", "spaceFullAlertDialog show BadTokenException");
            this.f15292Y1.m65764k(str);
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70689w("MainActivity", "showSpaceFullDialogAfterWait not ownerUser!");
            m21287U9("isOwnerUser");
            this.f15292Y1.m65764k(str);
            return;
        }
        if (C9733f.m60705z().m60763v("enableSpaceFullPrompt") != 1) {
            C11839m.m70689w("MainActivity", "showSpaceFullDialogAfterWait switchStatus is not open");
            m21287U9("switchStatus close");
            this.f15292Y1.m65764k(str);
            return;
        }
        H5SpaceFullDialogInfo h5SpaceFullDialogInfoM60709D = C9733f.m60705z().m60709D();
        if (h5SpaceFullDialogInfoM60709D == null) {
            C11839m.m70689w("MainActivity", "showSpaceFullDialogAfterWait h5SpaceFullDialogInfo is null");
            m21287U9("dialog null");
            this.f15292Y1.m65764k(str);
            return;
        }
        String h5Url = h5SpaceFullDialogInfoM60709D.getH5Url();
        if (TextUtils.isEmpty(h5Url)) {
            C11839m.m70689w("MainActivity", "showSpaceFullDialogAfterWait h5Url is null");
            m21287U9("h5Url null");
            this.f15292Y1.m65764k(str);
            return;
        }
        try {
            C11839m.m70688i("MainActivity", "showSpaceFullDialogAfterWait h5Url dialog");
            SafeIntent safeIntent = new SafeIntent(new Intent(this, (Class<?>) GuideWebViewActivity.class));
            Uri.Builder builderBuildUpon = Uri.parse(h5Url).buildUpon();
            builderBuildUpon.appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1632j());
            String string = builderBuildUpon.toString();
            C11839m.m70686d("MainActivity", "showSpaceFullDialogAfterWait url: " + string);
            safeIntent.putExtra("url", string);
            safeIntent.putExtra("isEnableJs", true);
            safeIntent.putExtra("main_dialog_id", "SPACE_FULL");
            safeIntent.putExtra("is_support_orientation", true);
            startActivity(safeIntent);
            this.f15292Y1.m65762i(str);
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "showSpaceFullDialogAfterWait error: " + e10.getMessage());
            m21287U9("err : " + e10.getMessage());
            this.f15292Y1.m65764k(str);
        }
        C13227f.m79492i1().m79585f0("mecloud_cloudspacedialog_full_show", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_cloudspacedialog_full_show", "4", "10");
        m21319Y9("mecloud_cloudspacedialog_full_show", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        C0214f0.m1382b(getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0).edit().putLong("cloudSpaceAvailableSizeReminderTime", System.currentTimeMillis()).commit();
    }

    /* renamed from: Q4 */
    public void m21251Q4() {
        if (C12591s1.m75931a().m75944n()) {
            ConfirmJumpRefurbishDialog confirmJumpRefurbishDialog = new ConfirmJumpRefurbishDialog(this, this);
            this.f15271U0 = confirmJumpRefurbishDialog;
            confirmJumpRefurbishDialog.show(this.f15414z.getString(R$string.cloudbackup_refurbishing_backup_tips));
        } else {
            RefurbishUpgradDialog refurbishUpgradDialog = new RefurbishUpgradDialog(this);
            this.f15276V0 = refurbishUpgradDialog;
            refurbishUpgradDialog.show();
        }
    }

    /* renamed from: Q6 */
    public final void m21252Q6() {
        this.f15298Z3 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.ecology_webview_mian);
        try {
            if (this.f15288X3 == null) {
                View viewFindViewById = findViewById(R$id.ecology_general_stub);
                if (viewFindViewById instanceof ViewStub) {
                    this.f15288X3 = ((ViewStub) viewFindViewById).inflate();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "ecologyStubLayout view stub inflate exception:" + e10.toString());
        }
        this.f15313c4 = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.ecology_rl_loading);
        this.f15318d4 = (TextView) C12809f.m76829b(this, R$id.ecology_loading_view_text);
        this.f15303a4 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ecology_h5_operation_nonet);
        this.f15308b4 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ecology_operation_error_url_layout);
        this.f15327f4 = (TextView) C12809f.m76829b(this, R$id.ecology_page_error_text);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.ecology_h5_operation_no_net_btn);
        this.f15323e4 = autoSizeButton;
        if (autoSizeButton != null) {
            autoSizeButton.setOnClickListener(this);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15303a4;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setOnClickListener(this);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15308b4;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setOnClickListener(this);
        }
    }

    /* renamed from: Q7 */
    public final /* synthetic */ void m21253Q7(View view) {
        if (!C0209d.m1226Y0() && view.getId() == R$id.campaign_entry_close) {
            C13823d.m82904y().m82917P(this, System.currentTimeMillis());
            m21125B6();
        }
    }

    /* renamed from: Q8 */
    public final void m21254Q8(SafeIntent safeIntent) {
        Bundle bundleExtra;
        try {
            bundleExtra = safeIntent.getBundleExtra("cloudAlbumStatus");
        } catch (RuntimeException e10) {
            C11839m.m70688i("MainActivity", "processCloudAlbumSwitchChange:" + e10.toString());
            bundleExtra = null;
        }
        if (bundleExtra != null) {
            String string = bundleExtra.getString("type");
            int i10 = bundleExtra.getInt("status");
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f15414z, "cloud_photo_cfg", 0);
            C11839m.m70686d("status", "receiver ACTION_CLOUDALBUM_STATUS , type= " + string + "status" + i10);
            if (i10 == 0 && "0".equals(string)) {
                sharedPreferencesM1382b.edit().putLong("cloud_photo_end_time", bundleExtra.getLong("updatetime")).commit();
                sharedPreferencesM1382b.edit().putInt("cloud_photo_uploading", 2).commit();
            } else if (1 == i10) {
                sharedPreferencesM1382b.edit().putInt("cloud_photo_uploading", 4).commit();
            }
        }
    }

    /* renamed from: Q9 */
    public final void m21255Q9() {
        UrgencyOnTopParams urgencyOnTopParamsOrElse;
        List<UrgencyOnTopParams> list = this.f15277V1;
        if (list != null && (urgencyOnTopParamsOrElse = list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.q6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MainActivity.m21037c8((UrgencyOnTopParams) obj);
            }
        }).findFirst().orElse(null)) != null) {
            this.f15277V1.remove(urgencyOnTopParamsOrElse);
        }
        m21428mb();
    }

    /* renamed from: Qa */
    public final void m21256Qa(String str) {
        m21225Ma(this.f15280W, str, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: Qb */
    public final void m21257Qb() {
        try {
            C11839m.m70687e("MainActivity", "spacefull later show");
            this.f15292Y1.m65765l("SPACE_FULL", null);
            this.f15292Y1.m65754a("SPACE_FULL");
        } catch (WindowManager.BadTokenException unused) {
            C11839m.m70687e("MainActivity", "spaceFullAlertDialog show BadTokenException");
        }
    }

    @Override // com.huawei.android.hicloud.ui.webview.ToolEcologyWapExternal.LoadDataListener
    /* renamed from: R */
    public void mo21258R(String str) {
        int iM16159m = C2783d.m16159m();
        C11839m.m70688i("MainActivity", "onLoadPageError, errorCode =" + str + " currentTab =" + iM16159m);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("method", "onLoadPageError");
        linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, str);
        C13230i.m79498B0(linkedHashMap);
        this.f15351l4 = str;
        this.f15347k4 = true;
        this.f15343j4 = false;
        if (iM16159m == 1) {
            runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.p6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17701a.m21297Vb();
                }
            });
        }
    }

    /* renamed from: R4 */
    public final void m21259R4() {
        boolean zIsShownAlready = SpaceNoticeCommonSpUtil.getInstance().isShownAlready();
        boolean zIsSupport = SpaceNoticeCommonSpUtil.getInstance().isSupport();
        C11839m.m70688i("MainActivity", "onrestart isShown = " + zIsShownAlready);
        if (zIsShownAlready) {
            return;
        }
        C11839m.m70688i("MainActivity", "onrestart isSuppot = " + zIsSupport);
        if (zIsSupport) {
            this.f15387t1 = true;
            C9713b.m60566c().m60569d(this.f15304a5, NoticeWithActivityUtil.checkRecommendActivityType(), 1, true);
        }
    }

    /* renamed from: R5 */
    public String m21260R5() {
        return this.f15400w;
    }

    /* renamed from: R6 */
    public final void m21261R6() {
        this.f15189D4 = new HandlerC3357g1(this);
    }

    /* renamed from: R7 */
    public final /* synthetic */ void m21262R7(View view) {
        if (!C0209d.m1226Y0() && view.getId() == R$id.campaign_entry_img) {
            boolean zM82913I = C13823d.m82904y().m82913I(this, 6);
            C11839m.m70686d("MainActivity", "jumpToCampaignCenter:" + zM82913I);
            if (zM82913I) {
                return;
            }
            m21125B6();
            C13823d.m82903c();
            m21195J6();
        }
    }

    /* renamed from: R8 */
    public final void m21263R8(boolean z10, String str) {
        C11839m.m70688i("MainActivity", "Process exit account, hasExiterSyncData: " + z10);
        this.f15316d1 = true;
        if (z10) {
            m21521y5(str);
        } else {
            C1008c.m6035v().m6058W(this.f15414z, str);
            C9062b.m57146k().m57155h(false, false);
        }
    }

    /* renamed from: R9 */
    public final void m21264R9(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            C11839m.m70688i("MainActivity", "refreshSyncItemMap syncItemInfo is null");
            return;
        }
        if (this.f15239N4.containsKey(syncItemInfo.getId())) {
            this.f15239N4.remove(syncItemInfo.getId(), syncItemInfo);
        }
        m21366eb();
    }

    /* renamed from: Ra */
    public final void m21265Ra(Boolean bool, View view) {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.main_menu_window, (ViewGroup) null);
        this.f15302a2 = C12809f.m76831d(viewInflate, R$id.main_menu_items);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(viewInflate, R$id.main_menu_view);
        this.f15307b2 = linearLayout;
        linearLayout.setOnClickListener(new ViewOnClickListenerC3387v());
        ArrayList<MainMenuItem> arrayList = new ArrayList<>();
        m21215La(arrayList);
        m21312Xa(viewInflate, view, arrayList);
    }

    /* renamed from: Rb */
    public final void m21266Rb(long j10) {
        m21243Ob(j10);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: S0 */
    public void mo21267S0(String str) {
        m21184Hc(str);
    }

    /* renamed from: S4 */
    public boolean m21268S4() {
        if (C0209d.m1333z1(this)) {
            return false;
        }
        C11839m.m70687e("MainActivity", "net is not connected");
        m21175Gb();
        return true;
    }

    /* renamed from: S5 */
    public final void m21269S5() {
        if (!C10155f.m63301y()) {
            C11839m.m70689w("MainActivity", "getCloudDiskData: not show CloudBackup");
            return;
        }
        if (C0209d.m1293p1()) {
            C11839m.m70689w("MainActivity", "isEinkScreen not show moredata");
            return;
        }
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17140o(this, this.f15304a5);
        }
    }

    /* renamed from: S6 */
    public final void m21270S6() {
        C11839m.m70688i("MainActivity", "initExchageMenuInfo");
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06029");
        c11060c.m66643I(C11058a.m66627b("06029"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        C9158a.m57503F().m57505B(this.f15304a5, c11060c, true);
        C9158a.m57503F().m57504A(this.f15304a5, c11060c);
    }

    /* renamed from: S7 */
    public final /* synthetic */ void m21271S7() {
        m21482t8("mecloud_main_click_safe_learn_more");
    }

    /* renamed from: S8 */
    public final void m21272S8(Intent intent) {
        Uri uri;
        if (this.f15355m4 == null) {
            C11839m.m70687e("MainActivity", "onActivityResult mFilePathCallback is null.");
            return;
        }
        if (intent == null || intent.getClipData() == null) {
            C11839m.m70687e("MainActivity", "onActivityResult intent is null.");
            this.f15355m4.onReceiveValue(null);
            this.f15355m4 = null;
            return;
        }
        ClipData clipData = intent.getClipData();
        if (clipData.getItemCount() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
                ClipData.Item itemAt = clipData.getItemAt(i10);
                if (itemAt != null && (uri = itemAt.getUri()) != null) {
                    arrayList.add(uri);
                    C11839m.m70686d("MainActivity", "onActivityResult uri: " + uri);
                }
            }
            if (arrayList.isEmpty()) {
                C11839m.m70688i("MainActivity", "onActivityResult choose count 0");
                this.f15355m4.onReceiveValue(null);
            } else {
                C11839m.m70688i("MainActivity", "onActivityResult multi choose count " + arrayList.size());
                this.f15355m4.onReceiveValue((Uri[]) arrayList.toArray(new Uri[arrayList.size()]));
            }
        }
        this.f15355m4 = null;
    }

    /* renamed from: S9 */
    public final void m21273S9(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("dialogCanShowID", str);
        C13227f.m79492i1().m79567R("before_mecloud_cloudspacedialog_full_show_4", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "before_mecloud_cloudspacedialog_full_show_4", linkedHashMapM79497A);
    }

    /* renamed from: Sa */
    public final void m21274Sa() {
        if (this.f15329g0 == null) {
            return;
        }
        C12515a.m75110o().m75172d(new C3389w());
    }

    /* renamed from: T4 */
    public final void m21275T4() {
        PopupWindow popupWindow;
        C0145l1 c0145l1;
        if (NpsShowManager.getInstance().checkIsNeedShowNPSMenu(this) || (popupWindow = this.f15297Z1) == null || !popupWindow.isShowing() || (c0145l1 = this.f15312c2) == null) {
            return;
        }
        c0145l1.m827d(8);
    }

    /* renamed from: T5 */
    public final void m21276T5(List<String> list) {
        boolean zM16133d0 = C2783d.m16133d0(this);
        if (zM16133d0 && this.f15326f1.m62388s("autocallloglistkey")) {
            list.add("cloud_disk_calllog");
        }
        if (zM16133d0 && this.f15326f1.m62388s("autosmslistkey")) {
            list.add("cloud_disk_sms");
        }
        if (zM16133d0 && this.f15326f1.m62388s("autorecordingkey")) {
            list.add("cloud_disk_recording");
        }
    }

    /* renamed from: T6 */
    public final void m21277T6() {
        if (this.f15175B == null) {
            this.f15175B = (ExpirationReminderCardView) C12809f.m76829b(this, R$id.expiration_reminder_card_view);
        }
        if (this.f15180C == null) {
            this.f15180C = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.expiration_card_layout);
        }
        this.f15180C.setVisibility(0);
        this.f15175B.setVisibility(8);
    }

    /* renamed from: T8 */
    public final void m21278T8() {
        C12515a.m75110o().m75172d(new C3367l());
    }

    /* renamed from: T9 */
    public final void m21279T9(boolean z10, boolean z11, boolean z12) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("fullDailogFreq", String.valueOf(z10));
        linkedHashMapM79497A.put("checkHwidRecomInterval", String.valueOf(z11));
        linkedHashMapM79497A.put("isDestroyed", String.valueOf(z12));
        C13227f.m79492i1().m79567R("before_mecloud_cloudspacedialog_full_show_1", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "before_mecloud_cloudspacedialog_full_show_1", linkedHashMapM79497A);
    }

    /* renamed from: Ta */
    public final void m21280Ta() {
        String string = getString(R$string.contact_email_value);
        SpannableString spannableString = new SpannableString(getString(R$string.set_get_info_not_avi, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        spannableString.setSpan(new C3339a1(this), iIndexOf, string.length() + iIndexOf, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        this.f15315d0.setMovementMethod(new C3342b1(this, null));
        this.f15315d0.setHighlightColor(getResources().getColor(R.color.transparent));
        this.f15315d0.setText(spannableString);
    }

    /* renamed from: Tb */
    public final void m21281Tb(SafeIntent safeIntent) {
        UrgencyTop urgencyTop;
        String stringExtra = safeIntent.getStringExtra("detail_urgency_top_banner");
        String stringExtra2 = safeIntent.getStringExtra("detail_urgency_top_detail");
        String stringExtra3 = safeIntent.getStringExtra("detail_urgency_ID");
        if (stringExtra != null) {
            try {
                urgencyTop = (UrgencyTop) new Gson().fromJson(stringExtra, UrgencyTop.class);
            } catch (Exception e10) {
                C11839m.m70687e("MainActivity", "getUrencyTop exception:" + e10.toString());
                return;
            }
        } else {
            urgencyTop = null;
        }
        if (urgencyTop == null) {
            C11839m.m70687e("MainActivity", "showUrgencyPolicy UrgencyTop is null");
            return;
        }
        if (!C13152i.m79070o().m79094d("hicloud_entrance", urgencyTop.getShowPages())) {
            C11839m.m70687e("MainActivity", "showUrgencyPolicy page not show");
            return;
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            C11839m.m70687e("MainActivity", "showUrgencyPolicy UrgencyID is null");
            return;
        }
        String content = urgencyTop.getContent();
        if (TextUtils.isEmpty(content)) {
            C11839m.m70687e("MainActivity", "showUrgencyPolicy Urgency content is null");
            return;
        }
        String strM79071w = C13152i.m79071w(content);
        this.f15287X1 = strM79071w;
        if (strM79071w == null) {
            C11839m.m70687e("MainActivity", "showUrgencyPolicy urgencyContent is null");
            return;
        }
        UrgencyGoto to2 = urgencyTop.getTo();
        List<UrgencyOnTopParams> list = this.f15277V1;
        if (list == null || list.size() != 0) {
            if (this.f15277V1 != null) {
                m21495v4(stringExtra3, to2, stringExtra2);
            }
        } else {
            UrgencyOnTopParams urgencyOnTopParams = new UrgencyOnTopParams();
            urgencyOnTopParams.setUrgencID(stringExtra3);
            m21439o7(urgencyOnTopParams, to2, stringExtra2);
            this.f15277V1.add(urgencyOnTopParams);
            m21428mb();
        }
    }

    /* renamed from: U4 */
    public final void m21282U4() {
        if (C10028c.m62182c0().m62419y0()) {
            C11839m.m70688i("MainActivity", "checkPushGuideDialog getMarketingNotifyChecked is true");
            C10028c.m62182c0().m62372o3();
            return;
        }
        if (this.f15281W0 == null) {
            C11839m.m70688i("MainActivity", "checkPushGuideDialog,pushGuideDialog is null");
            return;
        }
        m21147Da("PUSH_MARKETING_NOTICE");
        if (this.f15281W0.isShowing()) {
            C11839m.m70688i("MainActivity", "pushguide has show");
            if (C10028c.m62182c0().m62230J0() > this.f15208H3) {
                C11839m.m70688i("MainActivity", "pushGuideDialog cancel");
                this.f15281W0.cancel();
            } else {
                C11839m.m70688i("MainActivity", "no cancel");
            }
        } else {
            C11839m.m70688i("MainActivity", "pushGuideDialog is not null,not show");
        }
        if (this.f15397v1) {
            this.f15397v1 = false;
            m21057i9();
        }
    }

    /* renamed from: U5 */
    public String m21283U5() {
        return this.f15409y;
    }

    /* renamed from: U6 */
    public void m21284U6() {
        if (m21510wb()) {
            this.f15279V4.setVisibility(0);
            C12809f.m76831d(this.f15279V4, R$id.item_cloud_disk_full_data).setOnClickListener(this);
        } else {
            this.f15279V4.setVisibility(8);
        }
        m21150E4();
    }

    /* renamed from: U7 */
    public final /* synthetic */ void m21285U7(List list) {
        if (list.isEmpty()) {
            C11839m.m70688i("MainActivity", "guide backup switch task not satisfy,not need show dialog");
            m21147Da("GUIDE_BACKUP_SWITCH");
            this.f15380s = false;
            return;
        }
        LinearLayout linearLayout = this.f15305b0;
        boolean z10 = (linearLayout != null && linearLayout.isShown()) || !TextUtils.isEmpty(this.f15395v);
        C11839m.m70688i("MainActivity", "need show guide backup switch dialog, isShowClickText:" + z10);
        final SpaceSwitchSuggestDialog spaceSwitchSuggestDialog = new SpaceSwitchSuggestDialog(this, z10, new C3359h0(), new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.j6
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17649a.m21271S7();
            }
        });
        spaceSwitchSuggestDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.android.hicloud.ui.activity.k6
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MainActivity.m21007T7(spaceSwitchSuggestDialog, dialogInterface);
            }
        });
        spaceSwitchSuggestDialog.setCanceledOnTouchOutside(false);
        spaceSwitchSuggestDialog.setSwitchData(list);
        if (!"backup_recommend_switch_notify".equals(new SafeIntent(getIntent()).getStringExtra("scene_id"))) {
            this.f15292Y1.m65765l("GUIDE_BACKUP_SWITCH", spaceSwitchSuggestDialog);
            this.f15292Y1.m65754a("GUIDE_BACKUP_SWITCH");
            return;
        }
        C11839m.m70688i("MainActivity", "show guide dialog from notify");
        spaceSwitchSuggestDialog.setDialogSceneId(SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY);
        this.f15286X0 = spaceSwitchSuggestDialog;
        spaceSwitchSuggestDialog.show();
        this.f15292Y1.m65762i("GUIDE_BACKUP_SWITCH");
        C0212e0.m1370t(this, "switch_suggest_dialog_sp", "guide_backup_switch_notify_time", System.currentTimeMillis());
    }

    /* renamed from: U8 */
    public final void m21286U8() {
        if ("backup_recommend_switch_notify".equals(new SafeIntent(getIntent()).getStringExtra("scene_id"))) {
            this.f15385t = 0L;
            m21300W6();
            this.f15292Y1.m65763j("GUIDE_BACKUP_SWITCH");
        }
    }

    /* renamed from: U9 */
    public final void m21287U9(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("result", str);
        C13227f.m79492i1().m79567R("before_mecloud_cloudspacedialog_full_show_3", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "before_mecloud_cloudspacedialog_full_show_3", linkedHashMapM79497A);
    }

    /* renamed from: Ua */
    public final void m21288Ua(ArrayList<MainMenuItem> arrayList) {
        String string = getString(R$string.main_nps_title);
        boolean zIsNpsMenuRedDot = HiCloudSysParamMapCache.isNpsMenuRedDot();
        MainMenuItem mainMenuItem = new MainMenuItem(string, 8);
        mainMenuItem.setShowRedDot(zIsNpsMenuRedDot);
        if (NpsShowManager.getInstance().checkIsNeedShowNPSMenu(this)) {
            C11839m.m70688i("MainActivity", "show NPS menu");
            arrayList.add(mainMenuItem);
        }
    }

    /* renamed from: Ub */
    public final void m21289Ub() {
        if (this.f15277V1.size() <= 0 || this.f15282W1 == null) {
            return;
        }
        C11839m.m70686d("MainActivity", "showBannerView success , mBannerInfoList size = " + this.f15277V1.size());
        this.f15282W1.setData(this.f15277V1);
        this.f15282W1.setVisibility(0);
        if (this.f15277V1.size() > 1) {
            this.f15282W1.setTimer(5000L);
            this.f15282W1.m24011l();
            this.f15282W1.m24010k();
        }
    }

    /* renamed from: V4 */
    public final List<FamilyDetailInfo> m21290V4(List<FamilyDetailInfo> list) {
        Iterator<FamilyDetailInfo> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(C13452e.m80781L().m80971t0(), String.valueOf(it.next().getUid()))) {
                it.remove();
            }
        }
        return list;
    }

    /* renamed from: V5 */
    public final void m21291V5() {
        C11839m.m70688i("MainActivity", FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO);
        if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i("MainActivity", "getFamilyShareInfo, mItemSwitch is true");
            m21134C6();
            return;
        }
        if (!C11829c.m70626w0()) {
            C11839m.m70688i("MainActivity", "getFamilyShareInfo isFamilyShareFuncEnable = false");
            m21134C6();
        } else {
            if (!C13452e.m80781L().m80887a1()) {
                C11839m.m70688i("MainActivity", "getFamilyShareInfo is not new bmtype");
                m21134C6();
                return;
            }
            AsyncTaskC13562m asyncTaskC13562mM81514d = AsyncTaskC13562m.m81514d(this.f15304a5);
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC13562mM81514d.getStatus())) {
                C11839m.m70688i("MainActivity", "refreshFamilyShareInfoAndDetail task is running.");
            } else {
                asyncTaskC13562mM81514d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    /* renamed from: V6 */
    public final void m21292V6() {
        C11829c.m70609q1(this, getWindow());
        this.f15253Q3 = C10028c.m62182c0().m62413x();
        if (this.f15329g0 != null) {
            Boolean boolM80803F0 = C13452e.m80781L().m80803F0();
            this.f15329g0.setSnSInfoViewVisible(this.f15253Q3);
            this.f15329g0.setMoreIconVisibility(this.f15253Q3);
            this.f15329g0.setOnItemClickListener(new ViewOnClickListenerC3383t(boolM80803F0));
        }
        Handler handler = this.f15324e5;
        if (handler != null) {
            handler.postDelayed(this.f15344j5, 200L);
        }
        this.f15181C0 = (ImageView) C12809f.m76829b(this, R$id.main_user_head_pic);
    }

    /* renamed from: V7 */
    public final /* synthetic */ void m21293V7(final List list) {
        this.f15304a5.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.h6
            @Override // java.lang.Runnable
            public final void run() {
                this.f17628a.m21285U7(list);
            }
        });
    }

    /* renamed from: V8 */
    public final void m21294V8(Context context, SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String action = safeIntent.getAction();
        C10343b c10343b = new C10343b(C2783d.m16087I(safeIntent));
        if ("com.huawei.hicloud.intent.action.CLOUDALBUM_STATUS".equals(action)) {
            m21254Q8(safeIntent);
            return;
        }
        if ("com.huawei.hicloud.intent.action.SPACE_NOT_ENOUGH".equals(action)) {
            C11839m.m70686d("MainActivity", "ACTION_SPACE_NOT_ENOUGH");
            return;
        }
        if ("com.huawei.hicloud.intent.EXIT".equals(action)) {
            ProgressDialog progressDialog = new ProgressDialog(this.f15414z);
            progressDialog.setCancelable(true);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(getString(R$string.exiting));
            progressDialog.show();
            return;
        }
        if ("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action) || "com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(action)) {
            m21320Ya();
            return;
        }
        if ("com.huawei.hicloud.action.UI_NOTIFY_SYNC_START".equals(action)) {
            String stringExtra = safeIntent.getStringExtra("");
            C11839m.m70688i("MainActivity", "Constant.Action.UI_NOTIFY_SYNC_START moduleName=" + stringExtra);
            this.f15334h1.m83831I(stringExtra);
            return;
        }
        if ("com.huawei.hicloud.action.ACTION_OPEN_FULL_SWITCH".equals(action)) {
            String stringExtra2 = safeIntent.getStringExtra("open_switch_app_name");
            String strM81958d = C13622a.m81958d("03003");
            C11839m.m70688i("MainActivity", "Constant.Action.ACTION_OPEN_FULL_SWITCH moduleName=" + stringExtra2);
            m21117A8(stringExtra2, strM81958d, 14);
            return;
        }
        if ("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END".equals(action)) {
            String stringExtra3 = safeIntent.getStringExtra("");
            C11839m.m70688i("MainActivity", "Constant.Action.UI_NOTIFY_SYNC_END moduleName=" + stringExtra3);
            this.f15334h1.m83830H(stringExtra3);
            return;
        }
        if ("com.huawei.hicloud.QUERY_STORAGE_FINISHED".equals(action)) {
            m21419l9(c10343b);
            return;
        }
        if ("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED".equals(action)) {
            m21403j9(c10343b);
            return;
        }
        if ("com.huawei.hicloud.QUOTA_INFO_OM_CONFIG_DOWNLOAD_FINISHED".equals(action)) {
            m21357da();
            return;
        }
        if ("com.huawei.hicloud.ST_FIXED".equals(action)) {
            C11839m.m70688i("MainActivity", "STORAGE_ST_FIXED_ACTION");
            C13368e.m80184F().m80250o0();
            return;
        }
        if ("com.huawei.cloud.pay.action.updatespace".equals(action)) {
            C11839m.m70688i("MainActivity", "STORAGE_PAY_UPDATE_ACTION");
            this.f15186D0.m24284p();
            return;
        }
        if ("com.huawei.hicloud.action.agreeCampaign".equals(action)) {
            m21213L8(safeIntent);
            return;
        }
        if ("com.huawei.hicloud.action.updateCampaign".equals(action)) {
            C13823d.m82903c();
            m21195J6();
        } else if ("com.huawei.hicloud.action.CLOSE_SYNC_SWITCH".equals(action)) {
            m21223M8(false, safeIntent.getStringExtra("syncType"), 15);
        } else {
            m21464r8(context, safeIntent);
        }
    }

    /* renamed from: V9 */
    public final void m21295V9(String str, long j10, boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("gradeCode", str);
        linkedHashMapM79497A.put("freeSpace", String.valueOf(j10));
        linkedHashMapM79497A.put("foreground", String.valueOf(z10));
        C13227f.m79492i1().m79567R("before_mecloud_cloudspacedialog_full_show_2", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "before_mecloud_cloudspacedialog_full_show_2", linkedHashMapM79497A);
    }

    /* renamed from: Va */
    public final void m21296Va() {
        if (C13452e.m80781L().m80887a1()) {
            this.f15329g0.setVipIconLayoutShowStatus(8);
        }
    }

    /* renamed from: Vb */
    public void m21297Vb() {
        NotchFitLinearLayout notchFitLinearLayout = this.f15308b4;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(0);
            if (this.f15327f4 != null) {
                if (!this.f15347k4 || C2783d.m16159m() != 1) {
                    this.f15327f4.setText(getResources().getString(R$string.webview_unavaliable_url));
                } else if ("404".equals(this.f15351l4)) {
                    this.f15327f4.setText(getString(R$string.cloud_backup_failed_app_name, ""));
                } else {
                    this.f15327f4.setText(getResources().getString(R$string.connect_server_fail_msg1));
                }
            }
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f15313c4;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(8);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15303a4;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
        SafeWebView safeWebView = this.f15293Y3;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
        m21242O9();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        m21107y4();
    }

    /* renamed from: W4 */
    public final boolean m21298W4() {
        long j10 = C0214f0.m1382b(getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0).getLong("cloudSpaceAvailableSizeReminderTime", 0L);
        int iM60763v = C9733f.m60705z().m60763v("enableSpaceFullPrompt");
        C11839m.m70688i("MainActivity", "checkSpaceFullDialogFreq tempTime = " + j10 + " , switchStatus = " + iM60763v);
        if (!C0209d.m1166E1() || iM60763v != 1) {
            return System.currentTimeMillis() - j10 > 259200000;
        }
        H5SpaceFullDialogInfo h5SpaceFullDialogInfoM60709D = C9733f.m60705z().m60709D();
        if (h5SpaceFullDialogInfoM60709D == null) {
            C11839m.m70688i("MainActivity", "checkSpaceFullDialogFreq h5SpaceFullDialogInfo is null.");
            return System.currentTimeMillis() - j10 > 259200000;
        }
        String period = h5SpaceFullDialogInfoM60709D.getPeriod();
        C11839m.m70688i("MainActivity", "checkSpaceFullDialogFreq period = " + period);
        if (TextUtils.isEmpty(period)) {
            return System.currentTimeMillis() - j10 > 259200000;
        }
        try {
            return System.currentTimeMillis() - j10 > Long.parseLong(period) * 86400000;
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "checkSpaceFullDialogFreq err:" + e10.getMessage());
            return System.currentTimeMillis() - j10 > 259200000;
        }
    }

    /* renamed from: W5 */
    public final void m21299W5() {
        C12515a.m75110o().m75172d(new C3010a0(this.f15304a5));
    }

    /* renamed from: W6 */
    public final synchronized void m21300W6() {
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            C11839m.m70689w("MainActivity", "get user cloud total size is null");
            m21147Da("GUIDE_BACKUP_SWITCH");
            return;
        }
        long total = quotaSpaceInfoM80223L.getTotal();
        if (this.f15385t == total) {
            C11839m.m70688i("MainActivity", "user cloud total size not change");
            if (!this.f15380s) {
                C11839m.m70688i("MainActivity", "guide backup switch task not satisfy, set fail");
                m21147Da("GUIDE_BACKUP_SWITCH");
            }
            return;
        }
        if (CBAccess.inBackup()) {
            C11839m.m70688i("MainActivity", "backup is running");
            m21147Da("GUIDE_BACKUP_SWITCH");
            return;
        }
        this.f15380s = true;
        boolean z10 = this.f15385t != 0;
        C11839m.m70688i("MainActivity", "guide backup switch task isNeedQueryGradeCode:" + z10);
        this.f15385t = total;
        C12515a.m75110o().m75175e(new C3011a1(z10, new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.z5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f17834a.m21293V7((List) obj);
            }
        }), true);
    }

    /* renamed from: W7 */
    public final /* synthetic */ void m21301W7(boolean z10, SafeWebView safeWebView) {
        this.f15343j4 = z10;
        this.f15347k4 = false;
        m21395i8(safeWebView, z10);
    }

    /* renamed from: W8 */
    public final void m21302W8(boolean z10, String str, int i10) {
        C11839m.m70688i("MainActivity", "query module:" + str + " switchStatus:" + z10 + ", clickOptType: " + i10);
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        if (syncItemRecyclerAdapter == null) {
            C11839m.m70687e("MainActivity", "processItemCheckedChanged sync is null, syncType = " + str);
            return;
        }
        SyncItemInfo syncItemInfoM25274M = syncItemRecyclerAdapter.m25274M(str);
        if (syncItemInfoM25274M != null) {
            if (syncItemInfoM25274M.isSyncConfig()) {
                m21223M8(z10, str, i10);
                return;
            }
            if (syncItemInfoM25274M.isDriveConfig()) {
                if (!z10) {
                    this.f15326f1.m62336h2(str, false);
                    C1008c.m6035v().m6046K(this, str, 0);
                    C13227f.m79492i1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", str);
                } else {
                    m21184Hc(str);
                    AlertDialogC13588a alertDialogC13588a = new AlertDialogC13588a(this, new DialogInterfaceOnClickListenerC3396z0(str), new DialogInterfaceOnCancelListenerC3394y0(str));
                    this.f15418z4 = alertDialogC13588a;
                    alertDialogC13588a.m81741a(str);
                }
            }
        }
    }

    /* renamed from: W9 */
    public final void m21303W9() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07005"), "07005", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this, "boot_status", 0);
        HashMap map = new HashMap();
        String string = sharedPreferencesM1382b.getString("login_status", "");
        String string2 = sharedPreferencesM1382b.getString("st_uid_status", "");
        String string3 = sharedPreferencesM1382b.getString("st_encrypt_error", "");
        String string4 = sharedPreferencesM1382b.getString("nav_to_main_status", "");
        String string5 = sharedPreferencesM1382b.getString("st_decrypt_error", "");
        String string6 = sharedPreferencesM1382b.getString("keystore_generate_key", "");
        String string7 = sharedPreferencesM1382b.getString("account_sp_clear", "");
        if (!TextUtils.isEmpty(string)) {
            map.put("login_status", string);
        }
        if (!TextUtils.isEmpty(string2)) {
            map.put("st_uid_status", string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            map.put("st_encrypt_error", string3);
        }
        if (!TextUtils.isEmpty(string4)) {
            map.put("nav_to_main_status", string4);
        }
        if (!TextUtils.isEmpty(string5)) {
            map.put("st_decrypt_error", string5);
        }
        if (!TextUtils.isEmpty(string6)) {
            map.put("keystore_generate_key", string6);
        }
        if (!TextUtils.isEmpty(string7)) {
            map.put("account_sp_clear", string7);
        }
        if (map.size() != 0) {
            C13622a.m81969o(this, c11060cM66626a, map);
            sharedPreferencesM1382b.edit().clear().commit();
        }
    }

    /* renamed from: Wa */
    public final void m21304Wa(String str, boolean z10) {
        if (str.equals("addressbook")) {
            this.f15200G = z10;
        }
        if (str.equals("calendar")) {
            this.f15195F = z10;
        }
    }

    /* renamed from: Wb */
    public final void m21305Wb(UserPackage userPackage) {
        C11839m.m70686d("MainActivity", "usertype is vip");
        MemGradeRights gradeRights = userPackage.getGradeRights();
        if (gradeRights != null) {
            this.f15335h4 = gradeRights.getGradeCode();
            C11839m.m70686d("MainActivity", "in effect gradeCode " + this.f15335h4);
            m21435nb();
            int iM21393i6 = m21393i6(gradeRights.getRights());
            C11839m.m70686d("MainActivity", "in rightsNum gradeCode " + iM21393i6);
            m21113A4(0, iM21393i6);
            GradientActionBar gradientActionBar = this.f15329g0;
            if (gradientActionBar != null) {
                gradientActionBar.m23958t(iM21393i6);
                this.f15329g0.m23956r(false, this.f15223K3);
            }
        }
        this.f15186D0.m24258K();
        this.f15391u0.refreshView();
        m21146D9();
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: X */
    public void mo7530X() {
        if (this.f15350l1 == null) {
            this.f15350l1 = new AlertDialogC11016c(this, this, this.f15411y1, this.f15416z1, this.f15172A1);
        }
        this.f15350l1.show();
    }

    /* renamed from: X4 */
    public final void m21306X4() {
        SpaceDisplayFragment spaceDisplayFragment;
        C11839m.m70688i("MainActivity", "checkStorageLoadingFailed isStInvalidByServer = " + this.f15177B1);
        if (!this.f15177B1 || (spaceDisplayFragment = this.f15186D0) == null) {
            return;
        }
        spaceDisplayFragment.m24254G();
    }

    /* renamed from: X5 */
    public final void m21307X5() {
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c == null || !interfaceC9284c.mo17142p(this, this.f15314c5)) {
            return;
        }
        this.f15240O.setShowStatusLayout(true);
        this.f15240O.setShowLoading(true);
        this.f15240O.setOnClick(true);
        m21137C9(this.f15240O);
    }

    /* renamed from: X6 */
    public final void m21308X6() {
        m21367ec();
        C11839m.m70688i("MainActivity", "MainActivity start QueryGuideH5Task");
        C12515a.m75110o().m75175e(new C3024d2(this, this.f15374q5, 1, "drive"), false);
    }

    /* renamed from: X8 */
    public final void m21310X8() {
        List<String> list = this.f15375r;
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            m21517x9(it.next());
        }
    }

    /* renamed from: X9 */
    public final void m21311X9() {
        boolean z10 = TextUtils.equals(this.f16166i, "1") || TextUtils.equals(this.f16166i, "4");
        C11839m.m70686d("MainActivity", "reportUsingTime isFromHwid：" + z10);
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("from_hwid", Boolean.valueOf(z10));
        C13227f.m79492i1().m79567R("open_main_from_hwid", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "open_main_from_hwid", linkedHashMapM79499C);
    }

    /* renamed from: Xa */
    public final void m21312Xa(View view, View view2, ArrayList<MainMenuItem> arrayList) {
        C12515a.m75110o().m75172d(new C3362i0(arrayList, view, view2));
    }

    /* renamed from: Xb */
    public void m21313Xb(SafeWebView safeWebView, boolean z10) {
        if (safeWebView != null) {
            safeWebView.setVisibility(z10 ? 0 : 8);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f15303a4;
        if (notchFitLinearLayout != null) {
            notchFitLinearLayout.setVisibility(8);
        }
        HwColumnLinearLayout hwColumnLinearLayout = this.f15313c4;
        if (hwColumnLinearLayout != null) {
            hwColumnLinearLayout.setVisibility(z10 ? 8 : 0);
        }
        NotchFitLinearLayout notchFitLinearLayout2 = this.f15308b4;
        if (notchFitLinearLayout2 != null) {
            notchFitLinearLayout2.setVisibility(8);
        }
    }

    /* renamed from: Y4 */
    public final void m21314Y4() {
        C12515a.m75110o().m75172d(new C3371n());
    }

    /* renamed from: Y5 */
    public final C3339a1 m21315Y5(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C3339a1[] c3339a1Arr = (C3339a1[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C3339a1.class);
        if (c3339a1Arr.length > 0) {
            return c3339a1Arr[0];
        }
        return null;
    }

    /* renamed from: Y6 */
    public final void m21316Y6() {
        C11839m.m70688i("MainActivity", "initItemViewParent start");
        try {
            if (this.f15415z0 == null) {
                View viewFindViewById = findViewById(R$id.sync_normal_item_stub);
                if (viewFindViewById instanceof ViewStub) {
                    this.f15415z0 = ((ViewStub) viewFindViewById).inflate();
                    C11839m.m70688i("MainActivity", "inflate success");
                    View viewFindViewById2 = findViewById(R$id.init_item_view_layout);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(8);
                        C11839m.m70688i("MainActivity", "remove init item view layout success");
                    }
                    LinearLayout linearLayout = this.f15349l0;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "switch view stub inflate exception:" + e10.toString());
        }
    }

    /* renamed from: Y7 */
    public final /* synthetic */ void m21317Y7(List list, int i10, final Intent intent) {
        m21181H9(list, i10);
        if (intent != null) {
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.d6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17588a.m21309X7(intent);
                }
            }, 200L);
        } else if (m21459qb()) {
            m21466ra();
        }
    }

    /* renamed from: Y8 */
    public final void m21318Y8(long j10) {
        this.f15197F1 = C11333k.m68086b().m68091f(j10);
        C11839m.m70686d("MainActivity", "processSpaceRes tempAvailable=" + j10);
        if (this.f15197F1) {
            m21266Rb(j10);
        } else {
            m21147Da("SPACE_FULL");
            this.f15377r1 = false;
        }
    }

    /* renamed from: Y9 */
    public final void m21319Y9(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06026"), "06026", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: Ya */
    public final void m21320Ya() {
        if (this.f15295Z == null) {
            C11839m.m70687e("MainActivity", "setPhoneFinderState, phoneFinderCardView is null");
            return;
        }
        if (!C0209d.m1166E1()) {
            String strM6141g = C1010e.m6125b().m6141g(this);
            String strM80971t0 = C13452e.m80781L().m80971t0();
            if (TextUtils.isEmpty(strM6141g) || !strM6141g.equals(strM80971t0)) {
                this.f15258R3 = false;
                m21180H8();
                return;
            }
        }
        this.f15258R3 = C1010e.m6125b().m6139e(this);
        C11839m.m70688i("MainActivity", "setPhoneFinderState phoneStatus=" + this.f15258R3);
        m21180H8();
    }

    /* renamed from: Yb */
    public final void m21321Yb() {
        C10718a c10718a = this.f15182C1;
        if (c10718a != null) {
            c10718a.m65430k();
            C11839m.m70688i("MainActivity", "releaseActivity");
            this.f15182C1.m65438x();
        }
        ClaimSpacePopDialog claimSpacePopDialog = this.f15256R0;
        if (claimSpacePopDialog != null) {
            claimSpacePopDialog.dismiss();
            this.f15256R0 = null;
        }
        Dialog dialog = this.f15266T0;
        if (dialog != null) {
            dialog.dismiss();
            this.f15266T0 = null;
        }
        TipPopupLayout tipPopupLayout = this.f15267T1;
        if (tipPopupLayout != null) {
            tipPopupLayout.dismiss();
        }
        PopupWindow popupWindow = this.f15297Z1;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f15297Z1 = null;
        }
        HicloudPushGuideDialog hicloudPushGuideDialog = this.f15317d2;
        if (hicloudPushGuideDialog != null) {
            hicloudPushGuideDialog.dismissAndDestroy();
        }
    }

    /* renamed from: Z4 */
    public final void m21322Z4() {
        m21314Y4();
        C2987p.m17951a(this);
    }

    /* renamed from: Z5 */
    public String m21323Z5() {
        return this.f15404x;
    }

    /* renamed from: Z6 */
    public final synchronized void m21324Z6(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            C11839m.m70687e("MainActivity", "module arrayList is null");
        } else {
            Resources resources = this.f15414z.getResources();
            m21256Qa(resources != null ? arrayList.size() == 4 ? resources.getString(R$string.more_app_info_messages_calllogs_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.size() == 3 ? m21361e6(arrayList, resources) : arrayList.size() == 2 ? m21370f6(arrayList, resources) : m21353d6(arrayList, resources) : "");
        }
    }

    /* renamed from: Z7 */
    public final /* synthetic */ void m21325Z7(final boolean z10) {
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.g6
            @Override // java.lang.Runnable
            public final void run() {
                this.f17619a.m21331a8(z10);
            }
        });
    }

    /* renamed from: Z8 */
    public final void m21326Z8(int i10) {
        C11839m.m70688i("MainActivity", "processSwitchOpenPermissionResult");
        if (i10 == 20004) {
            List<String> listM69911k = this.f22163b.m69911k("sync_contact");
            C11839m.m70688i("MainActivity", "contact need permissions size: " + listM69911k.size());
            List<String> listM69903b = this.f22163b.m69903b(this, listM69911k);
            SyncItemInfo syncItemInfoM21337b6 = m21337b6("addressbook", this.f15225L);
            if (syncItemInfoM21337b6 == null) {
                SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.contact));
                this.f15225L = syncItemInfo;
                syncItemInfo.setId("addressbook");
                this.f15225L.setShowSwitch(true);
            } else {
                this.f15225L = syncItemInfoM21337b6;
                syncItemInfoM21337b6.setShowSwitch(true);
            }
            if (listM69903b.size() > 0) {
                this.f15200G = false;
                this.f15225L.setCheckedProgrammatically(false);
                m21223M8(false, "addressbook", 2);
            } else {
                this.f15225L.setCheckedProgrammatically(true);
                m21223M8(true, "addressbook", 2);
            }
            m21137C9(this.f15225L);
            return;
        }
        if (i10 == 20005) {
            List<String> listM69911k2 = this.f22163b.m69911k("sync_calendar");
            C11839m.m70688i("MainActivity", "calendar need permissions size: " + listM69911k2.size());
            List<String> listM69903b2 = this.f22163b.m69903b(this, listM69911k2);
            SyncItemInfo syncItemInfoM21337b62 = m21337b6("calendar", this.f15235N);
            if (syncItemInfoM21337b62 == null) {
                SyncItemInfo syncItemInfo2 = new SyncItemInfo(getString(R$string.calendar_sync_item));
                this.f15235N = syncItemInfo2;
                syncItemInfo2.setShowSwitch(true);
                this.f15235N.setId("calendar");
            } else {
                this.f15235N = syncItemInfoM21337b62;
                syncItemInfoM21337b62.setShowSwitch(true);
            }
            if (listM69903b2.size() > 0) {
                this.f15195F = false;
                this.f15235N.setCheckedProgrammatically(false);
                m21223M8(false, "calendar", 2);
            } else {
                C11839m.m70688i("MainActivity", "calendar setChecked");
                this.f15235N.setCheckedProgrammatically(true);
                m21223M8(true, "calendar", 2);
            }
            m21137C9(this.f15235N);
        }
    }

    /* renamed from: Z9 */
    public final void m21327Z9(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("isForm", "cloudMain");
        linkedHashMapM79497A.put("cardStatus", str);
        C13229h.m79496f1().m79591l0("mecloud_main_click_cloud_drive", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_main_click_cloud_drive", "1", "28", linkedHashMapM79497A);
    }

    /* renamed from: Za */
    public final void m21328Za() {
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76829b(this, R$id.hot_features_help);
        this.f15267T1 = tipPopupLayout;
        if (tipPopupLayout != null) {
            tipPopupLayout.setImageViewPic(R$drawable.ic_sync_help_new);
        }
    }

    /* renamed from: Zb */
    public final void m21329Zb() {
        if (C0209d.m1269j1()) {
            C11839m.m70688i("MainActivity", "startForceUpdate stop, honor not need checkForceUpdate");
            return;
        }
        if (m21506w7()) {
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(true);
        } else if (C10028c.m62182c0().m62380q1() && ForcedUpgradeUtil.getInstance().isForcedUpgradeIsShowing() && !ForcedUpgradeUtil.getInstance().isUserCancelForcedUpgrade()) {
            new Handler().postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.f6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17610a.m21380g8();
                }
            }, 600L);
        }
    }

    /* renamed from: a5 */
    public final void m21330a5() {
        if (C0209d.m1329y1()) {
            boolean z10 = true;
            if (C0209d.m1269j1() && C9733f.m60705z().m60721P()) {
                C9913h.m61574q().m61600x(this);
                C9908c c9908cM61499D = C9908c.m61499D();
                if (!m21515x7() && !C10028c.m62182c0().m62385r1()) {
                    z10 = false;
                }
                c9908cM61499D.m61522H(z10);
                C0209d.m1155B2();
                return;
            }
            if (C0209d.m1208S0(this)) {
                C11839m.m70688i("MainActivity", "CommonUtil.isEmui30()" + C11829c.m70614s0());
                if (C11829c.m70614s0()) {
                    C9913h.m61574q().m61600x(this);
                    C9913h.m61574q().m61589P(true);
                    C0209d.m1155B2();
                }
            }
        }
    }

    /* renamed from: a8 */
    public final /* synthetic */ void m21331a8(boolean z10) {
        if (z10) {
            C11839m.m70688i("MainActivity", "honor app icon is exist");
        } else {
            m21486u4();
        }
    }

    /* renamed from: a9 */
    public final void m21332a9(int i10, int i11) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == R$id.notepad_item_view) {
            if (!this.f15362o1) {
                this.f15240O.setChecked(!r6.isChecked());
                m21137C9(this.f15240O);
                return;
            } else {
                InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
                if (interfaceC9284c != null) {
                    interfaceC9284c.mo17160y(this);
                }
                C13227f.m79492i1().m79585f0("mecloud_main_click_notepad_old", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_main_click_notepad_old", "1", "10");
                return;
            }
        }
        if (i10 == R$id.cloud_disk_item) {
            C13227f.m79492i1().m79585f0("mecloud_main_click_more_data", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_more_data", "1", "37");
            Bundle bundle = new Bundle();
            bundle.putBoolean(NavigationUtils.SMS_SCHEMA_PREF, this.f15247P1);
            bundle.putBoolean("calllog", this.f15252Q1);
            bundle.putBoolean("recordig", this.f15257R1);
            bundle.putBoolean("phonemanager", this.f15262S1);
            bundle.putBoolean("isShowCloudDisk", true);
            InterfaceC9284c interfaceC9284c2 = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c2 != null) {
                interfaceC9284c2.mo17132k(this, bundle);
                return;
            }
            return;
        }
        if (i10 == R$id.contact_item_view) {
            this.f15225L.setChecked(!r6.isChecked());
            m21137C9(this.f15225L);
            return;
        }
        if (i10 == R$id.carlendar_item_view) {
            this.f15235N.setChecked(!r6.isChecked());
            m21137C9(this.f15235N);
        } else {
            if (i10 == R$id.safety_notice_link) {
                m21482t8("mecloud_main_click_safe");
                return;
            }
            if (i10 == R$id.hisync_main_shelve_head_setting_tip) {
                m21066k6();
            } else {
                if (i10 != R$id.browser_item_view) {
                    m21340b9(i10, i11);
                    return;
                }
                this.f15230M.setChecked(!r6.isChecked());
                m21137C9(this.f15230M);
            }
        }
    }

    /* renamed from: aa */
    public final void m21333aa(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("isForm", "cloudMain");
        linkedHashMapM79497A.put("cardStatus", str);
        C13229h.m79496f1().m79591l0("mecloud_main_click_cloud_drive", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_main_click_cloud_drive", "1", "28", linkedHashMapM79497A);
    }

    /* renamed from: ab */
    public final void m21334ab() {
        if (this.f15210I.size() == 0) {
            C11839m.m70688i("MainActivity", "setRecommendView size 0");
            this.f15405x0.setVisibility(8);
            return;
        }
        C11839m.m70688i("MainActivity", "setRecommendView size:" + this.f15210I.size());
        this.f15176B0.m24181A(this.f15210I);
        this.f15405x0.setVisibility(0);
        if (this.f15253Q3) {
            return;
        }
        this.f15405x0.setVisibility(8);
    }

    /* renamed from: ac */
    public final void m21335ac() {
        if (m21515x7()) {
            C9913h.m61574q().m61600x(this);
            C9908c.m61499D().m61522H(true);
            C10028c.m62182c0().m62269R2(false);
        }
    }

    /* renamed from: b5 */
    public final boolean m21336b5() {
        return (this.f15170A == null || this.f15233M3 == null || this.f15300a0 == null || this.f15255R == null) || (this.f15260S == null || this.f15329g0 == null || this.f15227L1 == null);
    }

    /* renamed from: b6 */
    public final SyncItemInfo m21337b6(String str, SyncItemInfo syncItemInfo) {
        LinkedHashMap<String, SyncItemInfo> linkedHashMap = this.f15239N4;
        if (linkedHashMap == null) {
            return null;
        }
        return linkedHashMap.containsKey(str) ? this.f15239N4.get(str) : syncItemInfo;
    }

    /* renamed from: b7 */
    public final void m21338b7() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (C0209d.m1293p1()) {
                NotchFitRelativeLayout notchFitRelativeLayout = this.f15371q0;
                if (notchFitRelativeLayout != null) {
                    notchFitRelativeLayout.setVisibility(8);
                }
            } else {
                m21346c7();
                RecommendCardManager.getInstance().getHomePageRecommendCardsFromCache(this.f15304a5);
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", e10.getMessage());
        }
        C11839m.m70686d("MainActivity", "recommendCard useTime " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: b8 */
    public final /* synthetic */ void m21339b8(TextView textView, ImageView imageView, View view) {
        if (f15169x5) {
            f15169x5 = false;
            textView.setText(R$string.cloud_disk_more);
            imageView.setImageResource(R$drawable.expand_arrow);
        } else {
            f15169x5 = true;
            textView.setText(R$string.collapse);
            imageView.setImageResource(R$drawable.collapse_arrow);
        }
        m21366eb();
    }

    /* renamed from: b9 */
    public final void m21340b9(int i10, int i11) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == R$id.wlan_item_view) {
            this.f15215J.setChecked(!r7.isChecked());
            m21137C9(this.f15215J);
            return;
        }
        if (i10 == R$id.oepn_service_button) {
            C13227f.m79492i1().m79585f0("extended_service_click_open_main", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "extended_service_click_open_main", "1", "100");
            C10028c.m62182c0().m62272S1(true);
            this.f15253Q3 = true;
            m21209Kb(true, i11);
            C13823d.m82903c();
            m21195J6();
            return;
        }
        if (i10 != R$id.main_user_head_pic_space) {
            if (i10 != R$id.cloud_disk_category && i10 != R$id.item_cloud_disk_full_data) {
                m21169G5(i10);
                return;
            }
            List<Map<String, Object>> list = this.f15188D3;
            if (list == null || list.size() <= 0) {
                m21327Z9("noRecentData");
                m22375i1(this, 12);
                return;
            } else {
                m21327Z9("hasRecentData");
                m22375i1(this, 9);
                return;
            }
        }
        if (!this.f15253Q3) {
            C11839m.m70687e("MainActivity", "extend func switch closed, not jump to other page");
            return;
        }
        C13227f.m79492i1().m79585f0("extended_service_main_click_head", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "extended_service_main_click_head", "1", "100");
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        intent.putExtra(FaqConstants.FAQ_CHANNEL, 15000000);
        intent.putExtra("showLogout", true);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("MainActivity", "startActivity error: " + e10.getMessage());
        }
    }

    /* renamed from: ba */
    public final void m21341ba(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("serviceId", str);
        C13227f.m79492i1().m79567R("CLOUDBACKUP_ENTRANCE_DRIVE_APP_MAIN", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "CLOUDBACKUP_ENTRANCE_DRIVE_APP_MAIN", linkedHashMapM79497A);
    }

    /* renamed from: bb */
    public final void m21342bb(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            SyncItemInfo syncItemInfoM21337b6 = m21337b6(syncItemInfo.getId(), syncItemInfo);
            syncItemInfoM21337b6.setCheckedProgrammatically(z10);
            this.f15239N4.put(syncItemInfoM21337b6.getId(), syncItemInfoM21337b6);
            m21366eb();
            if (z10) {
                C3948f.m24064g().m24078r(syncItemInfoM21337b6.getId(), 1);
            }
        }
    }

    /* renamed from: bc */
    public final void m21343bc() {
        if (new Intent("com.huawei.hwid.ACTION_MAIN_SETTINGS").resolveActivity(getPackageManager()) != null) {
            m21162F7(this);
        } else {
            Toast.makeText(this.f15414z, getString(R$string.unable_enter_account_tips_20160202), 0).show();
        }
    }

    /* renamed from: c5 */
    public final void m21344c5() {
        C11839m.m70688i("MainActivity", "cleanBackupCache");
        C13842a.m83010i().m83027e();
        m21352d5();
        C13225d.m79490f1().m79585f0("action_code_backup_clean_cache", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_backup_clean_cache", "1", "79");
        CleanCacheDialog cleanCacheDialog = new CleanCacheDialog(this);
        this.f15283W3 = cleanCacheDialog;
        cleanCacheDialog.show();
        this.f15334h1.m83866m0(true);
        C12515a.m75110o().m75172d(new C3372n0());
    }

    /* renamed from: c6 */
    public final ArrayList<SyncItemInfo> m21345c6() {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        return syncItemRecyclerAdapter == null ? new ArrayList<>() : syncItemRecyclerAdapter.m25276P(this.f15239N4);
    }

    /* renamed from: c7 */
    public final void m21346c7() {
        View viewFindViewById;
        this.f15405x0 = C12809f.m76829b(this, R$id.recommend_stub_frame);
        try {
            if (this.f15410y0 == null && (viewFindViewById = findViewById(R$id.recommend_stub)) != null && (viewFindViewById instanceof ViewStub)) {
                this.f15410y0 = ((ViewStub) viewFindViewById).inflate();
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "view stub inflate exception:" + e10.toString());
        }
        this.f15176B0 = (RecommendFragment) C12809f.m76828a(getFragmentManager(), R$id.recommend_fragment);
    }

    /* renamed from: c9 */
    public final void m21347c9(String str, int i10) {
        C2783d.m16114V0(str, "2", "2", i10);
        m21374fa(str, "local_close_switch", i10);
        C1008c.m6035v().m6074g(this, str, "");
        C1008c.m6035v().m6078i(this, str);
        C14317j.m85300d().m85319t();
    }

    /* renamed from: ca */
    public final void m21348ca(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("show_push_guide_dialog_scene", str);
        linkedHashMapM79497A.put("pop_show_times", String.valueOf(this.f15208H3));
        C13227f.m79492i1().m79567R("07031", linkedHashMapM79497A);
    }

    /* renamed from: cb */
    public final void m21349cb(SyncItemInfo syncItemInfo, boolean z10) {
        if (syncItemInfo != null) {
            if (z10) {
                syncItemInfo.setStatusText(getString(R$string.settings_hicloud_open));
            } else {
                syncItemInfo.setStatusText(getString(R$string.sync_switch_button_close));
            }
            m21137C9(syncItemInfo);
        }
    }

    /* renamed from: cc */
    public void m21350cc(SafeWebView safeWebView, String str, boolean z10) {
        C11839m.m70688i("MainActivity", "startLoadWebView begin");
        if (!z10) {
            C11839m.m70688i("MainActivity", "startLoadWebView: toolEcologySwitch is close");
            return;
        }
        if (safeWebView == null) {
            C11839m.m70687e("MainActivity", "webView is null, finish");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("MainActivity", "startLoadWebView url is invalid.");
            m21297Vb();
        } else {
            m21395i8(safeWebView, false);
            safeWebView.loadUrl(str);
            C11839m.m70688i("MainActivity", "startLoadWebView end");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseSyncDialogCallback
    public void closeSyncCancel(String str) {
        m21405jb(str);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseSyncDialogCallback
    public void closeSyncDeleteData(String str, String str2, int i10) {
        m21513x5(str, str2, i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseSyncDialogCallback
    public void closeSyncRetainData(String str, String str2, int i10) {
        m21374fa(str, str2, i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener
    /* renamed from: d0 */
    public void mo21351d0(HiCloudItemView hiCloudItemView, boolean z10) {
        if (hiCloudItemView == null) {
            return;
        }
        Object tag = hiCloudItemView.getTag();
        if (tag == null || (tag instanceof String)) {
            String str = (String) tag;
            if (C13612b.m81829B().m81886t(this)) {
                hiCloudItemView.setChecked(!z10);
                return;
            }
            int id2 = hiCloudItemView.getId();
            if (id2 == R$id.contact_item_view) {
                m21223M8(z10, "addressbook", 2);
                return;
            }
            if (id2 == R$id.carlendar_item_view) {
                m21223M8(z10, "calendar", 2);
                return;
            }
            if (id2 == R$id.notepad_item_view) {
                m21223M8(z10, "notepad", 2);
                return;
            }
            if (id2 == R$id.browser_item_view) {
                m21223M8(z10, "browser", 2);
            } else if (id2 == R$id.wlan_item_view) {
                m21223M8(z10, "wlan", 2);
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                m21302W8(z10, str, 2);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15311c1);
        arrayList.add(this.f15300a0);
        arrayList.add(this.f15285X);
        arrayList.add(this.f15270U);
        arrayList.add(this.f15255R);
        arrayList.add(this.f15282W1);
        arrayList.add(this.f15298Z3);
        arrayList.add(this.f15313c4);
        arrayList.add(this.f15303a4);
        arrayList.add(this.f15308b4);
        arrayList.add(this.f15259R4);
        return arrayList;
    }

    /* renamed from: d5 */
    public final void m21352d5() {
        SafeWebView safeWebView = this.f15293Y3;
        if (safeWebView != null) {
            safeWebView.clearCache(true);
            C11839m.m70688i("MainActivity", "tool webview clear cache");
        }
    }

    /* renamed from: d6 */
    public final String m21353d6(ArrayList<String> arrayList, Resources resources) {
        return arrayList.contains("message") ? resources.getString(R$string.more_app_info_messages, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.contains("calllog") ? resources.getString(R$string.more_app_info_calllogs, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : arrayList.contains("recording") ? resources.getString(R$string.more_app_info_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: d7 */
    public final void m21354d7() {
        C11839m.m70688i("MainActivity", "initRefreshJoinReceiver");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (this.f15241O0 == null) {
            this.f15241O0 = new RefreshJoinAlbumBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.join.share.album.refresh");
            intentFilter.addAction("com.huawei.hidisk.action.ALBUM_CLIENT_MESSAGE_SYNC_COMPLETE");
            c13108aM78878b.m78880c(this.f15241O0, intentFilter);
        }
    }

    /* renamed from: d8 */
    public final /* synthetic */ void m21355d8(int i10) {
        this.f15290Y.smoothScrollTo(0, i10);
    }

    /* renamed from: d9 */
    public final void m21356d9(String str) {
        if (C10155f.m63261N(str) && !m29143z0(str)) {
            m21304Wa(str, true);
            return;
        }
        C1008c.m6035v().m6076h(this.f15414z, str);
        m21381g9(str);
        m21167Fc(str);
        m21444oc();
    }

    /* renamed from: da */
    public final void m21357da() {
        SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
        if (spaceDisplayFragment != null) {
            spaceDisplayFragment.m24256I();
        }
        C13368e.m80184F().m80250o0();
    }

    /* renamed from: db */
    public final void m21358db(SyncItemInfo syncItemInfo) {
        if (syncItemInfo == null) {
            return;
        }
        String title = syncItemInfo.getTitle();
        int visible = syncItemInfo.getVisible();
        String id2 = syncItemInfo.getId();
        if (TextUtils.isEmpty(id2)) {
            return;
        }
        if (id2.equals(HNConstants.DataType.MEDIA)) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (visible == 8 && interfaceC9282a != null) {
                interfaceC9282a.mo58407Z0(this.f15414z, 12);
            }
        }
        if (TextUtils.isEmpty(title) || visible == 8) {
            return;
        }
        this.f15239N4.put(id2, syncItemInfo);
    }

    /* renamed from: dc */
    public final void m21359dc() {
        try {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_nps", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_nps", "1", "4");
            startActivity(C13933c.m83668n().m83684q());
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "startNPSWebview wish exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        if (operationCanceledException != null) {
            C11839m.m70687e("MainActivity", "account login canceled: " + operationCanceledException.toString());
        }
    }

    /* renamed from: e5 */
    public final void m21360e5() {
        C12515a.m75110o().m75172d(new C3380r0(null));
    }

    /* renamed from: e6 */
    public final String m21361e6(ArrayList<String> arrayList, Resources resources) {
        return (arrayList.contains("message") && arrayList.contains("calllog") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_messages_calllogs_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("calllog") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_calllogs_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("recording") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_calllogs_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: e7 */
    public final void m21362e7() {
        if (this.f15186D0 == null) {
            this.f15186D0 = (SpaceDisplayFragment) C12809f.m76828a(getFragmentManager(), R$id.space_display_fragment);
        }
        SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
        if (spaceDisplayFragment != null) {
            spaceDisplayFragment.m24269W();
            this.f15186D0.m24265S(this);
        }
        if (this.f15202G1 == null) {
            this.f15202G1 = C12809f.m76829b(this, R$id.notch_fragment_layout);
        }
        if (this.f15207H1 == null) {
            this.f15207H1 = C12809f.m76829b(this, R$id.storage_manage_layout);
        }
    }

    /* renamed from: e8 */
    public final /* synthetic */ void m21363e8() {
        m21482t8("mecloud_main_click_safe_learn_more");
    }

    /* renamed from: e9 */
    public final void m21364e9(String str, int i10) {
        if (C10155f.m63261N(str) && !m29143z0(str)) {
            m21304Wa(str, true);
            return;
        }
        String strM81958d = C13622a.m81958d("03003");
        this.f15346k1 = true;
        m21304Wa(str, false);
        m21117A8(str, strM81958d, i10);
        C2783d.m16114V0(str, "1", "1", i10);
    }

    /* renamed from: ea */
    public final void m21365ea(String str) {
        C11839m.m70688i("MainActivity", "resetEcologyTab ecologyMode = " + str);
        this.f15178B3.setItemChecked(0);
        C2783d.m16134d1(0);
        m21132C4(0);
    }

    /* renamed from: eb */
    public final void m21366eb() {
        m21149Dc(new RunnableC3391x());
    }

    /* renamed from: ec */
    public final void m21367ec() {
        C11839m.m70688i("MainActivity", "QueryGuideH5Task, startQueryGuideH5Task pageViewChannel: " + this.f16166i);
        if (this.f15360n5.equals(this.f16166i) || this.f15364o5.equals(this.f16166i)) {
            C12515a.m75110o().m75175e(new C3028e2(this.f15369p5), false);
            return;
        }
        C11839m.m70687e("MainActivity", "QueryGuideH5Task, pageViewChannel != 1 && pageViewChannel != 100");
        m21147Da("GUIDE_H5_WEBVIEW_DAILOG");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("pageViewChannel", this.f16166i);
        C13227f.m79492i1().m79567R("mecloud_pre_h5_show_result_1", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "mecloud_pre_h5_show_result_1", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.ui.webview.ToolEcologyWapExternal.LoadDataListener
    /* renamed from: f */
    public void mo21368f(final SafeWebView safeWebView, final boolean z10) {
        C11839m.m70688i("MainActivity", "onWebViewLoadFinish isFinish =" + z10);
        NotchFitLinearLayout notchFitLinearLayout = this.f15303a4;
        if (notchFitLinearLayout == null || notchFitLinearLayout.getVisibility() != 0) {
            runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.t6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17740a.m21301W7(z10, safeWebView);
                }
            });
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.new_hisync_setting;
    }

    /* renamed from: f5 */
    public final void m21369f5() {
        m21509wa();
        m21199Ja(this.f15220K, false);
        m21349cb(this.f15240O, false);
        m21349cb(this.f15245P, false);
    }

    /* renamed from: f6 */
    public final String m21370f6(ArrayList<String> arrayList, Resources resources) {
        return (arrayList.contains("message") && arrayList.contains("calllog")) ? resources.getString(R$string.more_app_info_messages_calllogs, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_messages_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("message") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_messages_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("calllog") && arrayList.contains("recording")) ? resources.getString(R$string.more_app_info_calllogs_recordings, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : (arrayList.contains("calllog") && arrayList.contains("interception")) ? resources.getString(R$string.more_app_info_calllogs_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data)) : resources.getString(R$string.more_app_info_recordings_blockrules, getString(R$string.more_app_info_backup), getString(R$string.more_app_info_view_data));
    }

    /* renamed from: f7 */
    public final void m21371f7() {
        C11839m.m70688i("MainActivity", "initStFixedReceiver");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (this.f15226L0 == null) {
            this.f15226L0 = new StFixedReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.ST_FIXED");
            c13108aM78878b.m78880c(this.f15226L0, intentFilter);
        }
    }

    /* renamed from: f8 */
    public final /* synthetic */ void m21372f8(ArrayList arrayList, boolean z10) {
        if (z10) {
            return;
        }
        arrayList.add(0, new MainMenuItem(getString(R$string.add_icon_menu_item), 13));
    }

    /* renamed from: f9 */
    public final void m21373f9() {
        int iM1357g = C0212e0.m1357g(this, "checkbox_push_guide_sp", "key_push_guide_result", 0);
        if (iM1357g == 0) {
            return;
        }
        C11839m.m70688i("MainActivity", "pushGuideResultReport");
        boolean z10 = iM1357g == 2;
        C11839m.m70688i("MainActivity", "pushGuideResultReport checkStatus is " + z10);
        if (C13470b.m81125a().m81126b()) {
            String str = z10 ? "push_guide_checkbox_checked" : "push_guide_checkbox_unchecked";
            C11839m.m70688i("MainActivity", "pushGuideResultReport eventId is " + str);
            C13227f.m79492i1().m79591l0(str, C13230i.m79499C(C13452e.m80781L().m80971t0()));
            C0212e0.m1374x(this, "checkbox_push_guide_sp", "key_push_guide_result");
        }
    }

    /* renamed from: fa */
    public final void m21374fa(String str, String str2, int i10) {
        m21397ib(str, i10);
        C2783d.m16120Y0(getApplicationContext(), str, str2);
    }

    /* renamed from: fb */
    public final void m21375fb() {
        HwRecyclerView hwRecyclerView = this.f15259R4;
        if (hwRecyclerView == null) {
            C11839m.m70688i("MainActivity", "syncItemRecyclerView is null");
        } else {
            m21382gb((GridLayoutManager) hwRecyclerView.getLayoutManager());
        }
    }

    /* renamed from: fc */
    public final void m21376fc() {
        C11839m.m70688i("MainActivity", "startShowEcology");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("ecologyMode");
        String stringExtra2 = safeIntent.getStringExtra("ecologyType");
        String stringExtra3 = safeIntent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            C11839m.m70688i("MainActivity", "startShowEcology ecologyModeis empty");
            return;
        }
        if ("tools".equals(stringExtra)) {
            if (!this.f15417z3) {
                C11839m.m70688i("MainActivity", "startShowEcology toolEcologySwitch is close");
                return;
            } else if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
                C11839m.m70688i("MainActivity", "startShowEcology ecologyUrl or ecologyType is empty");
                return;
            } else {
                C11839m.m70688i("MainActivity", "startShowEcology start quick app");
                C1266d.m7525d(this).m7528e(stringExtra3);
            }
        }
        C11839m.m70688i("MainActivity", "startShowEcology ecologyMode = " + stringExtra + ", ecologyType = " + stringExtra2);
        m21365ea(stringExtra);
        try {
            Intent intent = getIntent();
            intent.removeExtra("ecologyMode");
            intent.removeExtra("ecologyType");
            intent.removeExtra("url");
        } catch (Exception unused) {
            C11839m.m70689w("MainActivity", "startShowEcology removeExtraFlag error");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        m21003Sb(this, 2);
    }

    /* renamed from: g5 */
    public final void m21377g5(String str) {
        C1008c.m6035v().m6084l(this, str);
    }

    /* renamed from: g6 */
    public final String m21378g6() {
        C11839m.m70688i("MainActivity", "getUserGuideType grandeCode is: " + C13452e.m80781L().m80790C());
        return C13452e.m80781L().m80907e1() ? "bmPaidUserMenuPage" : "bmFreeUserMenuPage";
    }

    /* renamed from: g7 */
    public final void m21379g7(boolean z10, boolean z11) {
        m21484ta(z10, z11);
        if (this.f15186D0 != null) {
            if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
                C11839m.m70689w("MainActivity", "ForcedUpgrade, don't refresh storage");
            } else {
                this.f15186D0.m24286t(true);
            }
        }
    }

    /* renamed from: g8 */
    public final /* synthetic */ void m21380g8() {
        C9913h.m61574q().m61600x(this);
        C9913h.m61574q().m61589P(true);
    }

    /* renamed from: g9 */
    public final void m21381g9(String str) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i("MainActivity", "Query local data: " + str + ", traceId: " + strM81958d);
        C1008c.m6035v().m6048M(this, this.f15304a5, str, strM81958d, 2);
    }

    /* renamed from: gb */
    public final void m21382gb(GridLayoutManager gridLayoutManager) {
        if (this.f15259R4 == null) {
            C11839m.m70688i("MainActivity", "syncItemRecyclerView is null");
            return;
        }
        C11839m.m70688i("MainActivity", "the device is landFolder or pad");
        this.f15259R4.setLayoutManager(gridLayoutManager);
        C1424b c1424b = this.f15269T4;
        if (c1424b != null) {
            this.f15259R4.removeItemDecoration(c1424b);
        }
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        int iMo721e = syncItemRecyclerAdapter == null ? 1 : syncItemRecyclerAdapter.mo721e();
        if (C11829c.m70511E0(this) && iMo721e > 1 && C11842p.m70753O0(this)) {
            C11839m.m70688i("MainActivity", "the config is landscape");
            this.f15259R4.addItemDecoration(this.f15269T4);
        }
        C11839m.m70688i("MainActivity", "syncItemRecyclerView update adapter");
        this.f15259R4.setAdapter(this.f15254Q4);
        m21366eb();
    }

    /* renamed from: gc */
    public final void m21383gc() {
        try {
            Intent intent = new Intent();
            intent.setClass(this, NewBusinessIntroductionActivity.class);
            intent.putExtra("navigation_dest", 1);
            startActivityForResult(intent, 10056);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("MainActivity", "startUpGuideActivity failed, exception: " + e10.toString());
        }
    }

    /* renamed from: h5 */
    public final void m21384h5() {
        if (this.f15220K != null && C13452e.m80781L().m80887a1() && C13452e.m80781L().m80791C0()) {
            if (C1006a.m5936k().m5973t()) {
                C11839m.m70689w("MainActivity", "closeCloudPhotoForNN inRetentionPeriod not close");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("GeneralAblum", false);
            bundle.putBoolean("ShareAlbum", false);
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                m21199Ja(this.f15220K, false);
                if (interfaceC9282a.mo58417d(this.f15414z)) {
                    interfaceC9282a.mo58396U(this.f15414z, bundle, 22);
                }
            }
        }
    }

    /* renamed from: h6 */
    public final void m21385h6(int i10) {
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9713b.m60566c().m60570e(this.f15304a5, i10, c11060c, true, true, "BsInterfaceMgMainActivity");
    }

    /* renamed from: h7 */
    public final void m21386h7() {
        C11839m.m70688i("MainActivity", "initSwitchStatus start");
        Context applicationContext = getApplicationContext();
        this.f15326f1 = C10028c.m62183d0(applicationContext);
        boolean zM5975v = C1006a.m5936k().m5975v(applicationContext);
        boolean zM62216G1 = false;
        if (C13452e.m80781L().m80791C0() && zM5975v) {
            C11839m.m70687e("MainActivity", "this is nn user, but gallery status is open. change status to close");
            m21384h5();
            zM5975v = false;
        }
        m21199Ja(this.f15220K, zM5975v);
        boolean zM62388s = this.f15326f1.m62388s("addressbook");
        boolean zM62388s2 = this.f15326f1.m62388s("calendar");
        boolean zM62388s3 = this.f15326f1.m62388s("notepad");
        boolean zM62388s4 = this.f15326f1.m62388s("browser");
        boolean zM62388s5 = this.f15326f1.m62388s("wlan");
        if (this.f15346k1) {
            if (!this.f15200G) {
                m21342bb(this.f15225L, zM62388s);
            }
            if (!this.f15195F) {
                m21342bb(this.f15235N, zM62388s2);
            }
            m21342bb(this.f15240O, zM62388s3);
            m21342bb(this.f15230M, zM62388s4);
            m21342bb(this.f15215J, zM62388s5);
        }
        m21349cb(this.f15240O, zM62388s3);
        boolean zM62388s6 = this.f15326f1.m62388s("backup_key");
        if (!C10155f.m63301y()) {
            m21156Ea();
            zM62216G1 = this.f15326f1.m62216G1(this);
        }
        m21320Ya();
        if (m21245P6()) {
            this.f15321e1 = true;
        }
        if (zM62388s || zM62388s2 || zM62388s4 || zM62388s3 || zM62388s5 || zM62388s6 || zM62216G1 || zM5975v) {
            this.f15321e1 = true;
        }
        if (zM62388s6) {
            applicationContext.getPackageManager().setComponentEnabledSetting(new ComponentName(applicationContext, (Class<?>) BackupMainforSettingActivity.class), 2, 1);
        }
    }

    /* renamed from: h8 */
    public final void m21387h8(int i10) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            C12515a.m75110o().m75172d(new C3369m(i10));
        }
    }

    /* renamed from: h9 */
    public final void m21388h9(Message message) {
        getWindow().clearFlags(16);
        Object obj = message.obj;
        if (!(obj instanceof Boolean)) {
            C11839m.m70687e("MainActivity", "Cannot get boolean from message");
            return;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        Bundle data = message.getData();
        if (data == null) {
            C11839m.m70687e("MainActivity", "queryLocalDataFinish, bundle data is null");
            return;
        }
        String string = data.getString("sync_type_key", "");
        m21167Fc("");
        int i10 = data.getInt("sync_operation_type", 2);
        C11839m.m70688i("MainActivity", "Query local data finish, module id = " + string + ", result = " + zBooleanValue + ", clickOptType = " + i10);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String string2 = data.getString("trace_id_key", "");
        if (zBooleanValue) {
            m21184Hc(string);
            this.f15346k1 = false;
            if (!this.f15251Q0.containsKey(string) || this.f15251Q0.get(string) == null) {
                MergeAlertDialog mergeAlertDialog = new MergeAlertDialog(this, this, 2);
                mergeAlertDialog.show(string, string2);
                this.f15251Q0.put(string, mergeAlertDialog);
            } else {
                this.f15251Q0.get(string).show(string, string2);
            }
        } else {
            m21304Wa(string, false);
            m21117A8(string, string2, i10);
            C2783d.m16116W0(string, "1", "1", i10, 0);
        }
        C1008c.m6035v().m6079i0(this, string);
    }

    /* renamed from: ha */
    public final void m21389ha() {
        if (C13452e.m80781L().m80842P0()) {
            boolean zM70892b = C11842p.f.PERCENT_50.m70892b(this.f15381s0);
            C11839m.m70686d("MainActivity", "CampaignCard is visibleToUser: " + zM70892b);
            C0212e0.m1366p(this, "common_account_app", "campaign_card_visible", zM70892b);
        }
    }

    /* renamed from: hb */
    public final void m21390hb(ArrayList<SyncConfigService> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            this.f15244O4.clear();
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            SyncConfigService syncConfigService = arrayList.get(i10);
            SyncItemInfo syncItemInfoM21337b6 = m21337b6(syncConfigService.getId(), new SyncItemInfo());
            boolean z10 = true;
            syncItemInfoM21337b6.setSyncConfig(true);
            syncItemInfoM21337b6.setId(syncConfigService.getId());
            syncItemInfoM21337b6.setTitle(syncConfigService.getTitleText());
            syncItemInfoM21337b6.setSubUser(syncConfigService.isSubUser());
            syncItemInfoM21337b6.setShowDivider(syncConfigService.isShowDivider());
            if (!C10028c.m62182c0().m62388s(syncConfigService.getId()) && !syncConfigService.getSwitchStatus()) {
                z10 = false;
            }
            syncItemInfoM21337b6.setSwitchStatus(m21203K5(syncConfigService.getId(), z10));
            syncItemInfoM21337b6.setSyncItemSubtitleStatus(syncConfigService.getSyncItemSubtitleStatus());
            syncItemInfoM21337b6.setSubStringText(syncConfigService.getSubStringText());
            syncItemInfoM21337b6.setIconPath(syncConfigService.getIconPath());
            this.f15244O4.add(syncItemInfoM21337b6);
        }
    }

    /* renamed from: hc */
    public final void m21391hc() {
        C13227f.m79492i1().m79585f0("mecloud_setting_click_wish_list", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_setting_click_wish_list", "1", "4");
        try {
            startActivity(new Intent(this, (Class<?>) CloudWishActivity.class));
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "start wish exception: " + e10.toString());
        }
    }

    /* renamed from: i5 */
    public final void m21392i5() {
        if (m21126B7()) {
            C11839m.m70689w("MainActivity", "closeCloudSyncForNN view not ready, return");
            return;
        }
        if (C13452e.m80781L().m80887a1() && C13452e.m80781L().m80791C0()) {
            List<String> listM6037B = C1008c.m6035v().m6037B(this.f15414z);
            if (listM6037B.isEmpty()) {
                C11839m.m70689w("MainActivity", "closeCloudSyncForNN allToOffService is empty");
                return;
            }
            C11839m.m70688i("MainActivity", "closeCloudSyncForNN allToOffService = " + listM6037B.toString());
            C10028c c10028cM62183d0 = C10028c.m62183d0(this);
            for (String str : listM6037B) {
                if (c10028cM62183d0.m62388s(str)) {
                    str.hashCode();
                    switch (str) {
                        case "addressbook":
                            if (!this.f15225L.isCheckedProgrammatically()) {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN contact switch already close");
                                break;
                            } else {
                                m21223M8(false, "addressbook", 12);
                                continue;
                            }
                        case "hinote":
                            if (!C1006a.m5936k().m5973t() || C1008c.m6035v().m6108z(this, str) != 1) {
                                break;
                            } else {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN " + str + " inRetentionPeriod return");
                                break;
                            }
                            break;
                        case "calendar":
                            if (!this.f15235N.isCheckedProgrammatically()) {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN calendar switch already close");
                                break;
                            } else {
                                m21223M8(false, "calendar", 12);
                                continue;
                            }
                        case "wlan":
                            if (!this.f15215J.isCheckedProgrammatically()) {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN wlan switch already close");
                                break;
                            } else {
                                m21223M8(false, "wlan", 12);
                                continue;
                            }
                        case "browser":
                            if (!this.f15230M.isCheckedProgrammatically()) {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN browser switch already close");
                                break;
                            } else {
                                m21223M8(false, "browser", 12);
                                continue;
                            }
                        case "notepad":
                            if (!this.f15240O.isCheckedProgrammatically()) {
                                C11839m.m70688i("MainActivity", "closeCloudSyncForNN notepad switch already close");
                                break;
                            } else {
                                m21223M8(false, "notepad", 12);
                                continue;
                            }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        SyncItemInfo syncItemInfoM25274M = this.f15254Q4.m25274M(str);
                        if (syncItemInfoM25274M == null || syncItemInfoM25274M.isSwitchStatus()) {
                            C11839m.m70688i("MainActivity", " closeCloudSyncForNN " + str + "");
                            m21302W8(false, str, 12);
                        } else {
                            C11839m.m70688i("MainActivity", "closeCloudSyncForNN " + str + " switch already close");
                        }
                    }
                } else {
                    C11839m.m70688i("MainActivity", "closeCloudSyncForNN " + str + " is closed");
                }
            }
        }
    }

    /* renamed from: i6 */
    public final int m21393i6(List<MemGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            C11839m.m70687e("MainActivity", "memGradeRightList is null ");
            return arrayList.size();
        }
        for (MemGradeRight memGradeRight : list) {
            if (memGradeRight.getStatus() == 1) {
                arrayList.add(memGradeRight);
            }
        }
        C11839m.m70686d("MainActivity", "getValidRights " + arrayList.size());
        return arrayList.size();
    }

    /* renamed from: i7 */
    public final void m21394i7() {
        this.f15259R4 = (HwRecyclerView) C12809f.m76829b(this, R$id.sync_normal_recycler_view);
        boolean zM70511E0 = C11829c.m70511E0(this);
        if (this.f15259R4.getAdapter() != null) {
            zM70511E0 = zM70511E0 && this.f15259R4.getAdapter().mo721e() > 1;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, zM70511E0 ? 2 : 1);
        if (this.f15254Q4 == null) {
            this.f15254Q4 = new SyncItemRecyclerAdapter(this, gridLayoutManager);
        }
        this.f15254Q4.m25283Y(this);
        this.f15254Q4.m25284Z(this);
        m21382gb(gridLayoutManager);
    }

    /* renamed from: i8 */
    public final void m21395i8(WebView webView, boolean z10) {
        if (C2783d.m16159m() == 1 && this.f15417z3) {
            if (z10) {
                webView.setVisibility(0);
                this.f15313c4.setVisibility(8);
                m21242O9();
            } else {
                webView.setVisibility(4);
                if (this.f15347k4) {
                    this.f15313c4.setVisibility(8);
                } else {
                    this.f15313c4.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: ia */
    public final void m21396ia() {
        long jM62270S = C10028c.m62183d0(this).m62270S();
        boolean zM63300x = C10155f.m63300x();
        C11839m.m70686d("MainActivity", "isShowCloudAlbumShare: " + zM63300x);
        if (jM62270S == 0 && zM63300x) {
            C10028c.m62183d0(this).m62280U1();
        }
    }

    /* renamed from: ib */
    public final void m21397ib(String str, int i10) {
        if (str == null) {
            C11839m.m70687e("MainActivity", "setSyncSwitchOff, moduleName is null");
            return;
        }
        C11839m.m70688i("MainActivity", "setSyncSwitchOff, moduleName is " + str);
        C13950f c13950f = this.f15334h1;
        if (c13950f != null) {
            c13950f.m83832J(str);
        }
        switch (str) {
            case "addressbook":
                this.f15225L.setCheckedProgrammatically(false);
                m21137C9(this.f15225L);
                this.f15326f1.m62336h2("addressbook", false);
                C1008c.m6035v().m6103u0(this, "addressbook");
                C1008c.m6035v().m6082k(this.f15414z, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                C13223b.m79477e(this, "addressbook", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("addressbook"), "1", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, i10);
                break;
            case "gallery":
                Bundle bundle = new Bundle();
                bundle.putBoolean("GeneralAblum", false);
                C1006a.m5936k().m5943G(this, bundle, 12);
                C1008c.m6035v().m6053R(this, false);
                break;
            case "calendar":
                this.f15235N.setCheckedProgrammatically(false);
                m21137C9(this.f15235N);
                this.f15326f1.m62336h2("calendar", false);
                C10028c.m62182c0().m62348k(str);
                C13223b.m79477e(this, "calendar", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("calendar"), "1", "11", i10);
                break;
            case "wlan":
                this.f15215J.setCheckedProgrammatically(false);
                m21137C9(this.f15215J);
                this.f15326f1.m62336h2("wlan", false);
                C1008c.m6035v().m6061Z("dsswitch");
                C1008c.m6035v().m6103u0(this, "wlan");
                C1008c.m6035v().m6082k(this, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
                C13223b.m79477e(this, "wlan", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("wlan"), "1", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, i10);
                break;
            case "browser":
                this.f15230M.setCheckedProgrammatically(false);
                m21137C9(this.f15230M);
                this.f15326f1.m62336h2("browser", false);
                C13223b.m79477e(this, "browser", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("browser"), "1", "20", i10);
                break;
            case "notepad":
                this.f15240O.setCheckedProgrammatically(false);
                m21137C9(this.f15240O);
                this.f15326f1.m62336h2("notepad", false);
                C13223b.m79477e(this, "notepad", false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get("notepad"), "1", "10", i10);
                break;
            default:
                C13950f c13950f2 = this.f15334h1;
                if (c13950f2 != null) {
                    c13950f2.m83858i0(str, Boolean.FALSE);
                }
                this.f15326f1.m62336h2(str, false);
                NotifyConstants.putServicesMoudleIntoMap(str, false);
                C13223b.m79477e(this, str, false, i10);
                UBAAnalyze.m29955P("PVC", C13471c.m81131d().get(str), "1", "29", i10);
                break;
        }
        C10155f.m63262O(this, false);
    }

    /* renamed from: ic */
    public final void m21398ic(String str, int i10) {
        m21163F8("browser", str, i10);
        C1008c.m6035v().m6065b0(this, 1, "");
        this.f15230M.setCheckedProgrammatically(true);
        m21137C9(this.f15230M);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter.OnCheckedChangedListener
    /* renamed from: j */
    public void mo21399j(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView, boolean z10) {
        if (hiCloudItemView == null) {
            return;
        }
        Object tag = hiCloudItemView.getTag();
        if (tag == null || (tag instanceof String)) {
            if (syncItemInfo == null) {
                C11839m.m70688i("MainActivity", "onCheckedChangedSyncItem syncItemInfo is null");
                return;
            }
            String str = (String) tag;
            if (C13612b.m81829B().m81886t(this)) {
                hiCloudItemView.setChecked(!z10);
            } else {
                m21133C5(syncItemInfo.getId(), z10, str);
            }
        }
    }

    /* renamed from: j6 */
    public final int m21400j6(int i10, String str) {
        View view;
        C11839m.m70688i("MainActivity", "getViewCardPosition, cardId: " + i10 + ",direction: " + str);
        if (i10 >= 1 && i10 <= this.f15396v0.size() && (view = this.f15396v0.get(i10 - 1)) != null && view.isShown() && str != null) {
            if (com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_TOP.equals(str)) {
                return view.getTop();
            }
            if ("bottom".equals(str)) {
                return view.getBottom();
            }
        }
        return -1;
    }

    /* renamed from: j7 */
    public final void m21401j7() throws Throwable {
        C11839m.m70688i("MainActivity", "initSyncItemView ");
        m21423m5(2);
        m21436nc();
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this);
        ArrayList<DriveConfigService> subpageList = NotifyUtil.getSubpageList(this, false);
        C3948f.m24064g().m24075o(this.f15239N4);
        C3948f.m24064g().m24076p(C1008c.m6035v().m6036A(this.f15414z));
        if (shownSyncServiceItems.isEmpty() && subpageList.isEmpty()) {
            C11839m.m70688i("MainActivity", "initSyncItemView service is empty");
            return;
        }
        C11839m.m70688i("MainActivity", "initSyncItemView syncServices count = " + shownSyncServiceItems.size() + " driveServices count =" + subpageList.size());
        m21390hb(shownSyncServiceItems);
        m21165Fa(subpageList);
        m21366eb();
    }

    /* renamed from: j8 */
    public boolean m21402j8(int i10) {
        if (i10 == 1) {
            if (C1443a.f6215c.booleanValue()) {
                AddToDesktopDialog addToDesktopDialog = new AddToDesktopDialog(this.f15414z);
                this.f15370q = addToDesktopDialog;
                addToDesktopDialog.show();
            }
            C0214f0.m1382b(this.f15414z, "create_shortcut_sp", 0).edit().putBoolean("isCreatShortcut", false).commit();
            C2783d.m16082F0("");
        } else if (i10 == 3) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_check_upgrade", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_check_upgrade", "1", "4");
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(false);
        } else if (i10 == 9) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_about", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_about", "1", "4");
            startActivity(new Intent(this, (Class<?>) AboutActivity.class));
        } else if (i10 == 4) {
            startActivity(new Intent(this, (Class<?>) PushMarketingNoticeActivity.class));
        } else if (i10 == 2) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_manage", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_manage", "1", "4");
            Intent intent = new Intent(this, (Class<?>) PaymentManagerAndOrderActivity.class);
            intent.putExtra("nav_source", 12);
            startActivity(intent);
        } else if (i10 == 11) {
            C13227f.m79492i1().m79585f0("mecloud_voucher_center_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_voucher_center_click", "1", "4");
            startActivity(new Intent(this, (Class<?>) CouponCenterActivity.class));
        } else if (i10 == 13) {
            C11839m.m70688i("MainActivity", "add icon menu item is clicked");
            C13227f.m79492i1().m79591l0("add_icon_menu_item_click", new LinkedHashMap());
            UBAAnalyze.m29943D("PVC", "add_icon_menu_item_click");
            if (C0209d.m1269j1()) {
                new C10157h().m63312a(this.f15414z, NewHiSyncSettingActivity.class);
            } else {
                this.f15229L4.m16444L(getPackageName());
            }
        } else if (i10 == 0) {
            if (C0209d.m1212T1()) {
                m21416l6();
            }
        } else if (i10 == 5) {
            m21344c5();
        } else if (i10 == 6) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_personalization", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_personalization", "1", "4");
            try {
                startActivity(new Intent(this, (Class<?>) PersonalizationActivity.class));
            } catch (Exception e10) {
                C11839m.m70687e("MainActivity", "start personalization exception: " + e10.toString());
            }
        } else if (i10 == 7) {
            m21391hc();
        } else if (i10 == 8) {
            m21359dc();
        } else if (i10 == 12) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_more_setting", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_more_setting", "1", "4");
            try {
                SafeIntent safeIntent = new SafeIntent(new Intent());
                safeIntent.setClass(this, MoreSettingActivity.class);
                startActivity(safeIntent);
            } catch (Exception e11) {
                C11839m.m70687e("MainActivity", "start MoreSettingActivity exception: " + e11.toString());
            }
        } else if (i10 == 14) {
            BmServiceUpdateInfo bmServiceUpdateInfoM60706A = C9733f.m60705z().m60706A(m21378g6());
            if (bmServiceUpdateInfoM60706A != null && bmServiceUpdateInfoM60706A.getUrl() != null) {
                C12515a.m75110o().m75172d(new C3353f0(bmServiceUpdateInfoM60706A));
            }
        } else if (i10 == 15) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_exchange", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_exchange", "1", "4");
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06029"), "06029", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B("mecloud_setting_click_exchange");
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, C13230i.m79497A(C13452e.m80781L().m80971t0()));
            C12515a.m75110o().m75172d(new ClickExchangeTask(this, this.f15389t5, this.f15399v5, 2));
        }
        return false;
    }

    /* renamed from: j9 */
    public final void m21403j9(C10343b c10343b) {
        C11839m.m70688i("MainActivity", "receive QUERY_QUOTA_INFO_FINISHED_ACTION");
        if (c10343b != null) {
            int iM63686h = c10343b.m63686h("result");
            C11839m.m70688i("MainActivity", "STORAGE_QUERY_FINISHED_ACTION result=" + iM63686h);
            if (iM63686h == 1) {
                m21083q();
            } else {
                m21087q8();
            }
            this.f15292Y1.m65754a("SPACE_FULL");
            m21300W6();
        }
    }

    /* renamed from: ja */
    public final void m21404ja() {
        if (this.f15198F3) {
            m21411ka(7, "bottom");
        }
    }

    /* renamed from: jb */
    public final void m21405jb(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                this.f15225L.setCheckedProgrammatically(true);
                m21137C9(this.f15225L);
                this.f15326f1.m62336h2("addressbook", true);
                break;
            case "calendar":
                this.f15235N.setCheckedProgrammatically(true);
                m21137C9(this.f15235N);
                this.f15326f1.m62336h2("calendar", true);
                break;
            case "wlan":
                this.f15326f1.m62336h2("wlan", true);
                break;
            case "browser":
                this.f15230M.setCheckedProgrammatically(true);
                m21137C9(this.f15230M);
                this.f15326f1.m62336h2("browser", true);
                break;
            default:
                C13950f c13950f = this.f15334h1;
                if (c13950f != null) {
                    c13950f.m83858i0(str, Boolean.TRUE);
                }
                this.f15326f1.m62336h2(str, true);
                break;
        }
    }

    /* renamed from: jc */
    public final void m21406jc(String str, int i10) {
        m21163F8("calendar", str, i10);
        C1008c.m6035v().m6067c0(this, 1, "");
        this.f15235N.setCheckedProgrammatically(true);
        m21137C9(this.f15235N);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.SyncItemRecyclerAdapter.OnItemClickListener
    /* renamed from: k */
    public void mo21407k(SyncItemInfo syncItemInfo, HiCloudItemView hiCloudItemView) {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("MainActivity", "fast click");
            return;
        }
        if (C13612b.m81829B().m81886t(this)) {
            C11839m.m70687e("MainActivity", "ST is invalid,click disable");
            return;
        }
        if (hiCloudItemView != null) {
            m21202K4(hiCloudItemView.getId());
        }
        if (syncItemInfo == null) {
            return;
        }
        String id2 = syncItemInfo.getId();
        if (HNConstants.DataType.MEDIA.equals(id2)) {
            C13227f.m79492i1().m79585f0("mecloud_main_click_gallery", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_gallery", "1", "3");
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58393S0(this.f15414z);
            }
        } else if ("notepad".equals(id2)) {
            if (this.f15362o1) {
                InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
                if (interfaceC9284c != null) {
                    interfaceC9284c.mo17160y(this);
                }
                C13227f.m79492i1().m79585f0("mecloud_main_click_notepad_old", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_main_click_notepad_old", "1", "10");
            } else {
                this.f15240O.setChecked(!r0.isChecked());
                m21137C9(this.f15240O);
            }
        } else if (syncItemInfo.isDiskItem()) {
            C13227f.m79492i1().m79585f0("mecloud_main_click_more_data", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_more_data", "1", "37");
            Bundle bundle = new Bundle();
            bundle.putBoolean(NavigationUtils.SMS_SCHEMA_PREF, this.f15247P1);
            bundle.putBoolean("calllog", this.f15252Q1);
            bundle.putBoolean("recordig", this.f15257R1);
            bundle.putBoolean("phonemanager", this.f15262S1);
            bundle.putBoolean("isShowCloudDisk", true);
            InterfaceC9284c interfaceC9284c2 = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c2 != null) {
                interfaceC9284c2.mo17132k(this, bundle);
            }
        }
        if (syncItemInfo.isDriveConfig()) {
            if (TextUtils.isEmpty(id2)) {
                C11839m.m70687e("MainActivity", "onItemClick, id is empty");
            } else {
                m21341ba(id2);
                C1008c.m6035v().m6073f0(this, id2);
            }
        }
    }

    /* renamed from: k7 */
    public void m21408k7() throws Throwable {
        C10161l.m63342b().m63345d(this);
        this.f15334h1 = new C13950f(this, this.f15239N4);
        m21189Ia();
        this.f15362o1 = C10028c.m62183d0(this.f15414z).m62403v("notepad_has_history_data", false);
        this.f15177B1 = C13452e.m80781L().m80917g1();
        m21086q7();
        mo19005p1();
        m21152E6();
        m21224M9();
        m20968I6();
        m21030a7();
        m21481t7();
        m21371f7();
        m21161F6();
        C13040c.m78609F().m78652i0(C0213f.m1377a(), C13452e.m80781L().m80942m(), false);
        C10028c.m62183d0(getApplicationContext()).m62377p3("is_all_guide_over", true);
        C1010e.m6125b().m6155u(this.f15304a5);
        if (C0209d.m1293p1()) {
            C11839m.m70689w("MainActivity", "isEinkScreen not show moredata");
            this.f15245P.setVisible(8);
            m21264R9(this.f15245P);
            this.f15275V.setVisibility(8);
            return;
        }
        if (C10155f.m63301y()) {
            C11839m.m70688i("MainActivity", "showMoreAppInfo");
            m21166Fb();
            m21269S5();
            return;
        }
        C11839m.m70688i("MainActivity", "isShowCloudDiskView");
        if (!C2783d.m16133d0(this)) {
            this.f15245P.setVisible(8);
            m21264R9(this.f15245P);
        } else {
            this.f15245P.setVisible(0);
            m21519xb(true);
            m21137C9(this.f15245P);
        }
    }

    /* renamed from: k8 */
    public final void m21409k8(int i10) {
        NotchFitRelativeLayout notchFitRelativeLayout = this.f15298Z3;
        if (notchFitRelativeLayout == null) {
            C11839m.m70688i("MainActivity", "marginTopDistance mMainView is null");
            return;
        }
        if (i10 != 1) {
            C11842p.m70736I1(notchFitRelativeLayout, 0);
        } else if (isInMultiWindowMode()) {
            C11842p.m70729G0(this.f15298Z3, this);
            this.f15329g0.setToolStatusBarRegion(8);
        } else {
            C11842p.m70726F0(this.f15298Z3, this);
            this.f15329g0.setToolStatusBarRegion(0);
        }
    }

    /* renamed from: k9 */
    public final void m21410k9() {
        C11839m.m70688i("MainActivity", "querySilenceDevice enter");
        boolean zM80897c1 = C13452e.m80781L().m80897c1();
        C11839m.m70688i("MainActivity", "querySilenceDevice, isOldFreeUser: " + zM80897c1);
        if (!zM80897c1) {
            C13452e.m80781L().m80828L2(0L);
        } else if (C12312h0.m74027b().m74028c() - C13452e.m80781L().m80935k0() < 259200000) {
            C11839m.m70688i("MainActivity", "querySilenceDevice, not allowed to refresh again within 30 minutes");
        } else {
            C12515a.m75110o().m75172d(new C3393y());
        }
    }

    /* renamed from: ka */
    public final void m21411ka(int i10, String str) {
        C11839m.m70688i("MainActivity", "scrollCard");
        int iM21400j6 = m21400j6(i10, str);
        if (iM21400j6 == -1) {
            C11839m.m70687e("MainActivity", "viewCard param error");
            return;
        }
        final int iM70844o = "bottom".equals(str) ? (iM21400j6 - getResources().getDisplayMetrics().heightPixels) - ((int) C11842p.m70844o(this, 24)) : iM21400j6 - this.f15329g0.getHeight();
        C11839m.m70688i("MainActivity", "scrollCard, scrollPos: " + iM21400j6 + ", finalTemp: " + iM70844o);
        this.f15290Y.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.m6
            @Override // java.lang.Runnable
            public final void run() {
                this.f17675a.m21355d8(iM70844o);
            }
        });
    }

    /* renamed from: kb */
    public final void m21412kb(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setMaxWidth((((C11842p.m70753O0(this) ? C11842p.m70752O(this) : C11842p.m70758Q(this)) - (C11842p.m70840n(this, 24) * 2)) * 2) / 3);
    }

    /* renamed from: kc */
    public final void m21413kc(String str, int i10, int i11) {
        if (C13843a.m83073Y(this)) {
            m21422lc(str, i11);
            return;
        }
        m21163F8("addressbook", str, i11);
        C1008c.m6035v().m6081j0(this);
        C1008c.m6035v().m6069d0(i10);
        this.f15225L.setCheckedProgrammatically(true);
        m21137C9(this.f15225L);
    }

    @Override // java.util.function.Consumer
    /* renamed from: l2 */
    public void accept(Location location) {
        if (this.f15258R3) {
            C12515a.m75110o().m75172d(new C3374o0(location));
        } else {
            C11839m.m70688i("MainActivity", "accept but phoneFinder closed");
        }
    }

    /* renamed from: l5 */
    public final void m21415l5(String str, int i10) {
        if (C10028c.m62182c0().m62388s(str)) {
            C11839m.m70688i("MainActivity", "closeSyncSwitchBackground module name = " + str);
            C2783d.m16112U0(str, "2", "2", i10);
            this.f15326f1.m62341i2(str, false, -1);
            C1008c.m6035v().m6099s0(this, str, 101, 2012, "local_close_switch");
            C1008c.m6035v().m6074g(this, str, "");
        }
    }

    /* renamed from: l6 */
    public final void m21416l6() {
        C13227f.m79492i1().m79585f0("mecloud_main_click_help", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_main_click_help", "1", "27");
        FeedbackSdkProcessor.getInstance(this, new C11018a()).jumpToSdkView(this, 1, true);
    }

    /* renamed from: l7 */
    public final void m21417l7() {
        if (this.f15212I1 == null) {
            return;
        }
        if (!C2783d.m16177s()) {
            this.f15212I1.setVisibility(8);
            return;
        }
        this.f15212I1.setVisibility(0);
        C11842p.m70748M1(this, this.f15217J1);
        C11842p.m70748M1(this, this.f15222K1);
        this.f15222K1.setOnClickListener(this);
    }

    /* renamed from: l8 */
    public final void m21418l8() {
        if (C13452e.m80781L().m80791C0()) {
            C11839m.m70688i("MainActivity", "isBasicBusiness can not nav to backupMainPage");
            return;
        }
        Intent intent = getIntent();
        if (intent != null && new HiCloudSafeIntent(intent).getBooleanExtra("is_nav_to_back_up_main_activity", false)) {
            intent.removeExtra("is_nav_to_back_up_main_activity");
            try {
                startActivity(new Intent(this, (Class<?>) BackupMainActivity.class));
            } catch (Exception e10) {
                C11839m.m70687e("MainActivity", "startBackUpMainActivity exception: " + e10.toString());
            }
        }
    }

    /* renamed from: l9 */
    public final void m21419l9(C10343b c10343b) {
        C11839m.m70688i("MainActivity", "receive STORAGE_QUERY_FINISHED_ACTION");
        SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
        if (spaceDisplayFragment != null) {
            spaceDisplayFragment.m24285r();
            if (c10343b != null) {
                int iM63686h = c10343b.m63686h("result");
                C11839m.m70688i("MainActivity", "STORAGE_QUERY_FINISHED_ACTION result=" + iM63686h);
                if (iM63686h == 1) {
                    m21448p8();
                    C11839m.m70688i("MainActivity", "storageClick =" + this.f15367p1);
                    if (this.f15367p1) {
                        this.f15367p1 = false;
                        C11839m.m70688i("MainActivity", "mCurrentActivityRunning =" + this.f15402w1);
                        if (this.f15402w1) {
                            C13223b.m79475c(C0213f.m1377a(), "main_manage_click", "1", C13452e.m80781L().m80971t0(), "2");
                            UBAAnalyze.m29959T("PVC", "main_manage_click", "1", "7", "1", "2");
                            Intent intent = new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class);
                            C13230i.m79525e1(intent, "1", "2");
                            intent.putExtra("is_from_main_activity", true);
                            startActivity(intent);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: la */
    public final void m21309X7(Intent intent) {
        C11839m.m70688i("MainActivity", "scrollCard");
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            m21411ka(safeIntent.getIntExtra("cardId", -1), safeIntent.getStringExtra(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        } catch (Exception e10) {
            C11839m.m70688i("MainActivity", "scrollCard getExtra error " + e10);
        }
    }

    /* renamed from: lb */
    public final void m21421lb(int i10) {
        if (i10 > 1) {
            C11842p.m70720D0(this);
        } else {
            C11842p.m70720D0(this);
        }
    }

    /* renamed from: lc */
    public final void m21422lc(String str, int i10) {
        m21163F8("addressbook", str, i10);
        C1008c.m6035v().m6071e0(this, 1, "");
        this.f15225L.setCheckedProgrammatically(true);
        m21137C9(this.f15225L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
        C11839m.m70688i("MainActivity", "userPicUrl = " + bundle.getString("photoUrl"));
        m21479t5(bundle);
        String string = bundle.getString(com.huawei.hms.support.feature.result.CommonConstant.KEY_DISPLAY_NAME);
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.setActionBarTitle(C0209d.m1232a0(string));
        }
        m20988Oa(string);
    }

    /* renamed from: m5 */
    public final void m21423m5(int i10) throws Throwable {
        C11839m.m70688i("MainActivity", "closeUnshownItemSyncBackground");
        ArrayList<SyncConfigService> notShownSyncServiceItems = NotifyUtil.getNotShownSyncServiceItems(this);
        C11839m.m70688i("MainActivity", "closeUnshownItemSyncBackground get OM unshown services success, unshown items count = " + notShownSyncServiceItems.size());
        Iterator<SyncConfigService> it = notShownSyncServiceItems.iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            if (!TextUtils.isEmpty(id2)) {
                m21415l5(id2, i10);
            }
        }
    }

    /* renamed from: m6 */
    public final void m21424m6(int i10) {
        Intent intentM79111y;
        List<UrgencyOnTopParams> list = this.f15277V1;
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("MainActivity", "Urgency failed, urgencyOnTopParams is null");
            return;
        }
        if (i10 > this.f15277V1.size()) {
            C11839m.m70688i("MainActivity", "Urgency failed, position is illegal.");
            return;
        }
        UrgencyOnTopParams urgencyOnTopParams = this.f15277V1.get(i10);
        String urgencyGoto = urgencyOnTopParams.getUrgencyGoto();
        String detailString = urgencyOnTopParams.getDetailString();
        String url = urgencyOnTopParams.getUrl();
        String urgencID = urgencyOnTopParams.getUrgencID();
        if (TextUtils.isEmpty(urgencyGoto)) {
            C11839m.m70688i("MainActivity", "gotoType is null.");
            return;
        }
        try {
            if (urgencyGoto.equals("detail")) {
                intentM79111y = new Intent();
                C0209d.m1302r2(intentM79111y, "com.huawei.hidisk");
                intentM79111y.setAction("com.huawei.android.hicloud.ui.activity.UrgencyDetailActivity");
                intentM79111y.putExtra("urgency_goto_detail", detailString);
                intentM79111y.putExtra("detail_urgency_ID", urgencID);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("urgency goto", String.valueOf("MainActivity:detail-" + detailString + ",Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("urgency notice event", linkedHashMap);
            } else if (urgencyGoto.equals("web")) {
                intentM79111y = C13152i.m79070o().m79111y(url);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("urgency goto", String.valueOf("MainActivity:web-" + url + ",Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("urgency notice event", linkedHashMap2);
            } else {
                intentM79111y = null;
            }
            if (intentM79111y != null) {
                startActivity(intentM79111y);
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "startActivity exception:" + e10.toString());
        }
    }

    /* renamed from: m7 */
    public final void m21425m7() {
        try {
            m21431n7();
            this.f15331g4 = C10794j.m65679f();
            this.f15293Y3.m53596e(new C3348d1(this, null), false);
            if (!this.f15417z3) {
                C11839m.m70688i("MainActivity", "toolEcologySwitch is close");
                return;
            }
            m21233N9();
            m21451pb(this.f15293Y3);
            if (C0209d.m1333z1(this)) {
                C11839m.m70688i("MainActivity", "startLoadWebView");
                m21350cc(this.f15293Y3, this.f15331g4, this.f15417z3);
            } else {
                C11839m.m70688i("MainActivity", "showNetDisconnectView");
                m21175Gb();
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "initToolEcologyWebView error: " + e10.getMessage());
        }
    }

    /* renamed from: m8 */
    public final void m21426m8() {
        boolean zM5975v = C1006a.m5936k().m5975v(this);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", zM5975v);
        if (zM5975v) {
            bundle.putBoolean("ShareAlbum", true);
            C13223b.m79473a(this, "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY", "1", "15");
        } else {
            C13223b.m79473a(this, "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY", "1", "15");
        }
        C1006a.m5936k().m5943G(this, bundle, 12);
        C1008c.m6035v().m6053R(this, zM5975v);
    }

    /* renamed from: m9 */
    public final void m21427m9() {
        C14315h.m85262p().m85281r(C13452e.m80781L().m80887a1(), C13452e.m80781L().m80790C());
        if (this.f15185D == null || this.f15170A == null) {
            C11839m.m70689w("MainActivity", "refreshBackupItemVipStatus bmBackupItemView or cloudBackupVerticalItemView is null");
            return;
        }
        if (!C10028c.m62182c0().m62413x() || !C10155f.m63301y() || C0209d.m1293p1()) {
            this.f15185D.setVisibility(8);
            this.f15170A.setVisibility(8);
        } else if (this.f15185D.getVisibility() != 8) {
            if (this.f15170A.getVisibility() == 0) {
                this.f15170A.setVisibility(8);
            }
            if (this.f15185D.gradeChangeCheck()) {
                C11839m.m70688i("MainActivity", "grade changed, refresh view");
                C14317j.m85300d().m85319t();
            }
        } else if (C13452e.m80781L().m80887a1()) {
            if (this.f15170A.getVisibility() == 0) {
                this.f15170A.setVisibility(8);
            }
            this.f15185D.setVisibility(0);
            C11839m.m70688i("MainActivity", "refresh to new bm type");
            C14317j.m85300d().m85319t();
        }
        m21150E4();
    }

    /* renamed from: mb */
    public final void m21428mb() {
        List<UrgencyOnTopParams> list;
        if (!TextUtils.isEmpty(this.f15287X1) && (list = this.f15277V1) != null && list.size() > 0) {
            m21289Ub();
            return;
        }
        UrgencyScrollUpView urgencyScrollUpView = this.f15282W1;
        if (urgencyScrollUpView != null) {
            urgencyScrollUpView.setVisibility(8);
        }
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: n */
    public void mo7531n(boolean z10) {
        this.f15342j1 = z10;
        boolean zM6139e = C1010e.m6125b().m6139e(this);
        C11839m.m70688i("MainActivity", "phoneStatus: " + zM6139e);
        if (zM6139e && C0209d.m1166E1()) {
            m21065k5();
        } else {
            m21369f5();
            m20967I5();
        }
    }

    /* renamed from: n5 */
    public final void m21429n5() {
        C13227f.m79492i1().m79585f0(FamilyShareConstants.Report.SHOW_SPACE_SHARE, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", FamilyShareConstants.Report.SHOW_SPACE_SHARE, "5", "23");
    }

    /* renamed from: n6 */
    public final void m21430n6(Object obj) {
        List<ShareAlbumInfo> list = (List) obj;
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("MainActivity", "handleAlbumShareListInfo has no share album");
            m21139Cb();
            ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58397U0(this.f15384s5);
            return;
        }
        if (list.size() == 1) {
            C11839m.m70688i("MainActivity", "handleAlbumShareListInfo has one share album");
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            interfaceC9282a.mo58425f1(this.f15384s5, list.get(0));
            interfaceC9282a.mo58397U0(this.f15384s5);
            return;
        }
        if (list.size() >= 2) {
            C11839m.m70688i("MainActivity", "handleAlbumShareListInfo has some share albums , share album num = " + list.size());
            InterfaceC9282a interfaceC9282a2 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            interfaceC9282a2.mo58464x0(this.f15384s5, list);
            interfaceC9282a2.mo58397U0(this.f15384s5);
        }
    }

    /* renamed from: n7 */
    public final void m21431n7() {
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.tool_ecology_group);
        if (this.f15293Y3 == null) {
            this.f15293Y3 = new SafeWebView(this);
        }
        C12809f.m76838k(this.f15293Y3, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.f15293Y3);
    }

    /* renamed from: n8 */
    public final void m21432n8() {
        m21118A9();
        m21155E9(this);
        m21449p9();
    }

    /* renamed from: n9 */
    public final void m21433n9() {
        this.f15406x1 = false;
        C13823d.m82903c();
        m21195J6();
    }

    /* renamed from: na */
    public final void m21434na(int i10, long j10) {
        Message message = new Message();
        message.what = i10;
        HandlerC3357g1 handlerC3357g1 = this.f15189D4;
        if (handlerC3357g1 != null) {
            handlerC3357g1.sendMessageDelayed(message, j10);
        }
    }

    /* renamed from: nb */
    public final void m21435nb() {
        if (TextUtils.isEmpty(this.f15335h4)) {
            AbstractC10896a.m65886e("MainActivity", "setVipGradeInfoByCode mGradeCode is null");
            return;
        }
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.setVipIconLayoutShowStatus(0);
        }
        if (C12590s0.m75823Z0()) {
            AbstractC10896a.m65886e("MainActivity", "setVipGradeInfoByCode, current user is free user");
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            AbstractC10896a.m65887i("MainActivity", "setVipGradeInfoByCode, is new bm type");
            GradientActionBar gradientActionBar2 = this.f15329g0;
            if (gradientActionBar2 != null) {
                gradientActionBar2.setVipIconLayoutShowStatus(8);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.f15335h4, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER)) {
            m21443ob(new VipPlatinumResourceBean());
            return;
        }
        int i10 = C3364j0.f15460a[C11326d.m68044f(this.f15335h4).ordinal()];
        if (i10 == 1) {
            m21443ob(new VipSilverResourceBean());
        } else if (i10 == 2) {
            m21443ob(new VipGoldResourceBean());
        } else {
            if (i10 != 3) {
                return;
            }
            m21443ob(new VipDiamondResourceBean());
        }
    }

    /* renamed from: nc */
    public final void m21436nc() {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f15254Q4;
        if (syncItemRecyclerAdapter != null) {
            syncItemRecyclerAdapter.m25270H();
        }
        this.f15244O4.clear();
        this.f15249P4.clear();
    }

    /* renamed from: o5 */
    public final boolean m21437o5() {
        List<UrgencyOnTopParams> list;
        HiCloudExceptionView hiCloudExceptionView;
        UrgencyScrollUpView urgencyScrollUpView;
        if (this.f15311c1 == null) {
            C11839m.m70686d("MainActivity", "processExceptionView exceptionView is null");
            return false;
        }
        if (C0209d.m1333z1(this)) {
            this.f15311c1.m23914a();
            if (!TextUtils.isEmpty(this.f15287X1) && this.f15282W1 != null && (list = this.f15277V1) != null && list.size() > 0) {
                this.f15282W1.setVisibility(0);
            }
            if (this.f15186D0 != null && this.f15311c1 != null) {
                C11842p.m70736I1(this.f15196F0, 0);
            }
            return false;
        }
        C11839m.m70686d("MainActivity", "the net work not connected");
        this.f15311c1.m23919i();
        if (!TextUtils.isEmpty(this.f15287X1) && (urgencyScrollUpView = this.f15282W1) != null) {
            urgencyScrollUpView.setVisibility(8);
        }
        if (this.f15186D0 == null || (hiCloudExceptionView = this.f15311c1) == null) {
            return true;
        }
        hiCloudExceptionView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC3395z());
        return true;
    }

    /* renamed from: o6 */
    public boolean m21438o6(Message message) throws Resources.NotFoundException {
        if (m21446p6(message) || m21456q6(message)) {
            return false;
        }
        int i10 = message.what;
        if (i10 == 4) {
            m21177H5();
        } else if (i10 == 2002) {
            this.f15389t5 = (GetClientUIConfigResp) message.obj;
            m21465r9();
        } else if (i10 == 2013) {
            m21470s5(message);
        } else if (i10 == 2018) {
            m21455q5();
        } else if (i10 == 2023) {
            this.f15394u5 = (Response) message.obj;
            m21465r9();
        } else if (i10 == 9003) {
            m21187I8();
        } else if (i10 == 9008) {
            CleanCacheDialog cleanCacheDialog = this.f15283W3;
            if (cleanCacheDialog != null) {
                cleanCacheDialog.dismiss();
            }
            Toast.makeText(this, getString(R$string.cache_cleaned), 0).show();
            C14317j.m85300d().m85319t();
            BackupNotification.getInstance().cancelBackupNotification();
            RestoreNotification.getInstance().cancelNotification();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            Object obj = message.obj;
            long jM1688f = obj == null ? 0L : C0241z.m1688f(obj.toString());
            if (jM1688f != 0) {
                linkedHashMap.put("deletionTime", String.valueOf(jM1688f));
            }
            C13225d.m79490f1().m79567R("action_code_backup_clean_cache_completed", linkedHashMap);
            UBAAnalyze.m29954O("PVC", "action_code_backup_clean_cache_completed", "1", "79");
            this.f15334h1.m83866m0(false);
        } else if (i10 == 9011) {
            C11839m.m70688i("MainActivity", "message receive doInitCampaignEntryFloatView");
            m21142D5();
        } else {
            if (i10 != 9012) {
                return false;
            }
            C11839m.m70688i("MainActivity", "message init campaign card");
            m21213L8(null);
        }
        return false;
    }

    /* renamed from: o7 */
    public final void m21439o7(UrgencyOnTopParams urgencyOnTopParams, UrgencyGoto urgencyGoto, String str) {
        urgencyOnTopParams.setUrgencyContent(this.f15287X1);
        if (urgencyGoto == null) {
            return;
        }
        urgencyOnTopParams.setDetailString(str);
        urgencyOnTopParams.setUrgencyGoto(urgencyGoto.getType());
        urgencyOnTopParams.setUrl(urgencyGoto.getUri());
    }

    /* renamed from: o8 */
    public final void m21440o8(int i10) {
        m21421lb(i10);
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.m23948j(i10);
        }
    }

    /* renamed from: o9 */
    public final void m21441o9(final List<TaskCenterItem> list, final int i10, final Intent intent) {
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.r6
            @Override // java.lang.Runnable
            public final void run() {
                this.f17716a.m21317Y7(list, i10, intent);
            }
        });
    }

    /* renamed from: oa */
    public final void m21442oa() {
        this.f15304a5.sendEmptyMessageDelayed(9012, 200L);
    }

    /* renamed from: ob */
    public final void m21443ob(VipBaseResourceBean vipBaseResourceBean) {
        if (vipBaseResourceBean == null) {
            C11839m.m70687e("MainActivity", "setVipResource failed bean is null");
            return;
        }
        if (getResources() == null) {
            C11839m.m70687e("MainActivity", "setVipResource failed res is null");
            return;
        }
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.setVipIconResource(vipBaseResourceBean.getVipLevelIcon());
            this.f15329g0.m23954p(vipBaseResourceBean.getVipGradeStr(), vipBaseResourceBean.getVipGradeColor());
        }
    }

    /* renamed from: oc */
    public final void m21444oc() {
        getWindow().setFlags(16, 16);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
        C11839m.m70688i("MainActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10002) {
            C13612b.m81829B().m81880q(this.f15304a5);
            return;
        }
        if (i10 == 10023) {
            if (i11 == 2) {
                finish();
                return;
            }
            return;
        }
        if (i10 == 10028) {
            m20974L1(i11, hiCloudSafeIntent);
            return;
        }
        if (i10 == 1007) {
            Handler handler = this.f15324e5;
            if (handler != null) {
                handler.postDelayed(this.f15344j5, 200L);
                return;
            }
            return;
        }
        if (i10 == 8903) {
            if (this.f15182C1 != null) {
                C13195l.m79272J().m79297M(this, this.f15182C1.m65437v(), i11, hiCloudSafeIntent);
                return;
            }
            return;
        }
        if (i10 == 8904) {
            C13195l.m79272J().m79297M(this, this.f15218J3, i11, hiCloudSafeIntent);
            return;
        }
        if (i10 == 10043) {
            m21272S8(intent);
            return;
        }
        if (i10 == 10045) {
            finish();
            return;
        }
        if (i10 == 10053 && i11 == 10500) {
            finishAndRemoveTask();
            return;
        }
        if (i10 == 10049) {
            if (i11 == 1) {
                m21454q4();
                return;
            }
            return;
        }
        if (i10 == 10055) {
            m21518xa();
            C12515a.m75110o().m75172d(new C12199z(1));
        } else {
            if (10024 == i10) {
                if (101 == i11) {
                    C12515a.m75110o().m75172d(new C12199z(0));
                    return;
                }
                return;
            }
            if (10029 == i10 || 10034 == i10) {
                m21291V5();
            }
        }
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView.BottomNavListener
    public void onBottomNavItemReselected(MenuItem menuItem, int i10) {
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView.BottomNavListener
    public void onBottomNavItemSelected(MenuItem menuItem, int i10) {
        C11839m.m70688i("MainActivity", "onBottomNavItemSelected select tab is : " + i10);
        C2783d.m16134d1(i10);
        m21132C4(i10);
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView.BottomNavListener
    public void onBottomNavItemUnselected(MenuItem menuItem, int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        this.f15346k1 = true;
        m21304Wa(str, false);
        m21397ib(str, i10);
        C2783d.m16114V0(str, "1", "2", i10);
        m21184Hc("");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("MainActivity", "fast click");
            return;
        }
        if (C13612b.m81829B().m81886t(this)) {
            C11839m.m70687e("MainActivity", "ST is invalid,click disable");
            return;
        }
        int id2 = view.getId();
        m21202K4(id2);
        if (id2 == R$id.account_info) {
            C13223b.m79475c(C0213f.m1377a(), "main_account_click", "1", C13452e.m80781L().m80971t0(), "2");
            UBAAnalyze.m29959T("PVC", "main_account_click", "1", "1", "1", "2");
            C13227f.m79492i1().m79585f0("mecloud_main_click_hwaccount", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_hwaccount", "1", "1");
            m21343bc();
            return;
        }
        if (id2 == R$id.gallery_item_view) {
            C13227f.m79492i1().m79585f0("mecloud_main_click_gallery", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_gallery", "1", "3");
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58393S0(this.f15414z);
                return;
            }
            return;
        }
        if (id2 == R$id.storage_upgrade_entrance || id2 == R$id.base_upgrade_entrance) {
            Bundle bundle = new Bundle();
            bundle.putInt("from_where", 7);
            C13230i.m79522d1(bundle, "1", "7");
            C12126b.m72707c(C13222a.m79465g(this), bundle);
            m21003Sb(this, 1);
            C13223b.m79475c(this, "manage_upgrade_space", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
            UBAAnalyze.m29959T("PVC", "manage_upgrade_space", "1", "30", "1", C13222a.m79465g(this));
            C13227f.m79492i1().m79585f0("mecloud_cloudspace_click_upgrade", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_upgrade", "1", "30");
            return;
        }
        if (id2 == R$id.click_manage_space_ignore) {
            this.f15212I1.setVisibility(8);
            C2783d.m16137e1(false);
            return;
        }
        if (id2 == R$id.check_update_content) {
            C9913h.m61574q().m61600x(this);
            C9913h.m61574q().m61589P(false);
            return;
        }
        if (id2 == R$id.about_content) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_about", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_about", "1", "4");
            startActivity(new Intent(this, (Class<?>) AboutActivity.class));
        } else {
            if (id2 != R$id.full_data_item_switch) {
                m21332a9(id2, 2);
                return;
            }
            C13227f.m79492i1().m79585f0("mecloud_main_click_base_data_sync_and_backup", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_main_click_base_data_sync_and_backup", "1", "91");
            startActivity(new Intent(this, (Class<?>) SyncAndBackupMainActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        C11839m.m70686d("MainActivity", "onConfigurationChanged");
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        this.f15253Q3 = C10028c.m62182c0().m62413x();
        C11839m.m70686d("MainActivity", "onConfigurationChanged itemSwitch:" + this.f15253Q3);
        m21209Kb(this.f15253Q3, 2);
        C2783d.m16187w0(this.f15192E1);
        m21375fb();
        if (!C13612b.m81829B().isLogin()) {
            m21086q7();
        }
        if (C2783d.m16177s()) {
            C11842p.m70748M1(this, this.f15217J1);
            C11842p.m70748M1(this, this.f15222K1);
        }
        ClaimSpacePopDialog claimSpacePopDialog = this.f15256R0;
        if (claimSpacePopDialog != null && claimSpacePopDialog.isShowing()) {
            this.f15256R0.setDisplayLayoutParameter();
        }
        TextView textView = this.f15174A4;
        if (textView != null && textView.getVisibility() == 0) {
            if (C11842p.m70753O0(this)) {
                this.f15174A4.setMaxLines(1);
            } else {
                this.f15174A4.setMaxLines(6);
            }
        }
        m21475sa();
        m21409k8(C2783d.m16159m());
        m21487u5();
        this.f15229L4.m16445M();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m21418l8();
        TempBackupDataManager.m24501i().m24508k();
        if (!C13452e.m80781L().m80870W0()) {
            C9436m.m59180d().m59181a(this);
        } else if (!C10028c.m62182c0().m62196C1()) {
            m21383gc();
        }
        C9908c.m61499D().m61548i0(getApplicationContext());
        if (C13452e.m80781L().m80791C0()) {
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
        }
        if (C14163d.m84990g().m85009o()) {
            startActivityForResult(new Intent(this, (Class<?>) DataMigrationAuthActivity.class), 10023);
        }
        this.f15326f1 = C10028c.m62183d0(this);
        C13192i.m79258g().m79267m(false);
        C11842p.m70800d(getIntent(), 8);
        super.onCreate(bundle);
        m21507w8();
        this.f15414z = this;
        this.f15248P3 = true;
        this.f15263S3 = false;
        this.f15198F3 = true;
        C11839m.m70688i("MainActivity", "onCreate, EMUI SDK: " + C0219i.m1463a());
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e("MainActivity", "hicloud is not login could not open mainActivity");
            startActivity(new Intent(this, (Class<?>) NewHiSyncSettingActivity.class));
            finish();
            return;
        }
        m21373f9();
        C11842p.m70720D0(this);
        this.f15278V3 = C0209d.m1195O(this);
        m21138Ca();
        this.f15322e2 = Calendar.getInstance();
        this.f15320e0 = (LinearLayout) C12809f.m76829b(this, R$id.top_layout_struct);
        this.f15325f0 = (RelativeLayout) C12809f.m76829b(this, R$id.top_region);
        this.f15227L1 = (RelativeLayout) C12809f.m76829b(this, R$id.main_top_blue_region);
        this.f15196F0 = (RelativeLayout) C12809f.m76829b(this, R$id.space_display_stub_frame);
        this.f15371q0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.recommend_stub_frame);
        this.f15357n0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.backup_finder_frame);
        this.f15361o0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.expiration_card_layout);
        this.f15366p0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.finder_frame);
        this.f15337i0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.sync_item_frame);
        this.f15341j0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.full_data_service_item_frame);
        this.f15345k0 = (LinearLayout) C12809f.m76829b(this, R$id.full_data_service_card);
        this.f15353m0 = (LinearLayout) C12809f.m76829b(this, R$id.cloud_app_card);
        this.f15376r0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.album_share_card_item);
        this.f15381s0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.task_center_item);
        this.f15386t0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.basic_data_guide_layout);
        this.f15274U4 = C12809f.m76829b(this, R$id.cloud_backup_cloud_disk_item);
        this.f15391u0 = (BasicDataGuideView) C12809f.m76829b(this, R$id.basic_data_guide_item_view);
        this.f15407x3 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_main_family_share_cloud);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15371q0);
        arrayList.add(this.f15357n0);
        arrayList.add(this.f15361o0);
        arrayList.add(this.f15366p0);
        arrayList.add(this.f15337i0);
        arrayList.add(this.f15353m0);
        arrayList.add(this.f15376r0);
        arrayList.add(this.f15381s0);
        arrayList.add(this.f15386t0);
        arrayList.add(this.f15407x3);
        arrayList.add(this.f15274U4);
        arrayList.add(this.f15341j0);
        C12806c.m76817h(this.f15414z, arrayList);
        m21170G6();
        m21277T6();
        m21396ia();
        this.f15279V4 = C12809f.m76829b(this, R$id.full_data_extra_layout);
        this.f15233M3 = C12809f.m76829b(this, R$id.data_sync_item_layout);
        this.f15238N3 = C12809f.m76829b(this, R$id.full_data_service_item_layout);
        this.f15300a0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_safety_notice);
        this.f15250Q = (TaskCenterView) C12809f.m76829b(this, R$id.task_center_item_view);
        this.f15255R = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_more_app_info);
        this.f15260S = (RelativeLayout) C12809f.m76829b(this, R$id.open_function_item_layout);
        this.f15265T = (HwButton) C12809f.m76829b(this, R$id.oepn_service_button);
        this.f15270U = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.hicloud_open_function_item_layout_frame);
        this.f15174A4 = (TextView) C12809f.m76829b(this, R$id.tv_open_function);
        GradientActionBar gradientActionBar = (GradientActionBar) C12809f.m76829b(this, R$id.gradient_action_bar);
        this.f15329g0 = gradientActionBar;
        gradientActionBar.setImportantForAccessibility(2);
        m21492ua();
        SpaceDisplayFragment spaceDisplayFragment = (SpaceDisplayFragment) C12809f.m76828a(getFragmentManager(), R$id.space_display_fragment);
        this.f15186D0 = spaceDisplayFragment;
        spaceDisplayFragment.m24287v(this);
        this.f15191E0 = (SyncStatusTipsView) C12809f.m76829b(this, R$id.sync_item_num);
        this.f15202G1 = C12809f.m76829b(this, R$id.notch_fragment_layout);
        this.f15207H1 = C12809f.m76829b(this, R$id.storage_manage_layout);
        this.f15264S4 = new C1424b(C11842p.m70840n(this, 8));
        this.f15269T4 = C10801o.m65744a(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15242O1 = relativeLayout;
        boolean z10 = (this.f15227L1 == null || this.f15232M1 == null || this.f15237N1 == null || relativeLayout == null || this.f15233M3 == null || this.f15207H1 == null) ? false : true;
        if (C0209d.m1293p1() && z10) {
            this.f15227L1.setVisibility(8);
            this.f15242O1.setBackgroundColor(getColor(R$color.ink_color_white));
            View view = this.f15233M3;
            int i10 = R$drawable.storage_manage_cardview_list_ink;
            view.setBackground(getDrawable(i10));
            this.f15207H1.setBackground(getDrawable(i10));
        }
        C1008c.m6035v().m6051P(this.f15414z, this.f15299Z4, false);
        m21328Za();
        m21178H6();
        RecommendCardManager.getInstance().clearAds(RecommendCardConstants.Entrance.HOMEPAGE);
        m21270S6();
        m21292V6();
        m21299W5();
        if (!ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
            this.f15233M3.setVisibility(0);
        }
        m21146D9();
        this.f15265T.setOnClickListener(this);
        m21524y8();
        mo22385x1();
        m21516x8();
        m21531z8();
        C13612b.m81829B().m81885s0(false);
        m21211L6();
        m21204K6();
        this.f15292Y1 = new C10804r(this.f15304a5);
        this.f15324e5.postDelayed(this.f15328f5, 200L);
        RecommendCardManager.getInstance().getConfigFromOM(RecommendCardConstants.Entrance.HOMEPAGE);
        m21308X6();
        C1009d.m6109e().m6124p();
        C9681b.m60470l().m60475E();
        HiCloudWebViewPolicyManager.getInstance().reloadParseLocalFile();
        m21338b7();
        C9718g.m60602t().m60621Y(new ArrayList());
        this.f15229L4 = new IconManager(this.f15414z);
        C11829c.m70567c1();
        this.f15284W4.m66728c(true);
        m21463r7();
        m21296Va();
        m21159F4();
        CloudBackupService.getInstance().register(this.f15356m5);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70686d("MainActivity", "on destroy");
        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        if (configuration != null && configuration.equals(getResources().getConfiguration())) {
            C11839m.m70688i("MainActivity", "setAlreadyEntered false");
            C9159b.m57575n(false);
        }
        m21125B6();
        C11842p.m70836m(this);
        C10161l.m63342b().m63344c(this);
        C0212e0.m1351a(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP);
        C0212e0.m1351a(this, FrequencyManager.HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP);
        C0212e0.m1351a(this, FrequencyManager.HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP);
        List<UrgencyOnTopParams> list = this.f15277V1;
        if (list != null) {
            list.clear();
            this.f15277V1 = null;
        }
        UrgencyScrollUpView urgencyScrollUpView = this.f15282W1;
        if (urgencyScrollUpView != null) {
            urgencyScrollUpView.m24011l();
            this.f15282W1 = null;
        }
        if (this.f15216J0 != null) {
            C13108a.m78878b(this).m78883f(this.f15216J0);
            this.f15216J0 = null;
        }
        if (this.f15221K0 != null) {
            C13108a.m78878b(this).m78883f(this.f15221K0);
            this.f15221K0 = null;
        }
        NetworkChangeReceiver networkChangeReceiver = this.f15231M0;
        if (networkChangeReceiver != null) {
            unregisterReceiver(networkChangeReceiver);
            this.f15231M0 = null;
        }
        if (this.f15226L0 != null) {
            C13108a.m78878b(this).m78883f(this.f15226L0);
            this.f15226L0 = null;
        }
        BroadcastReceiver broadcastReceiver = this.f15236N0;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f15236N0 = null;
        }
        C1010e.m6125b().m6130E();
        C13612b.m81829B().m81861b0();
        C11836j.m70658k().m70662d();
        C13040c.m78609F().m78645f();
        C13368e.m80184F().m80265y();
        m21360e5();
        m21114A5();
        m21124B5();
        m21061j5();
        C3392x0 c3392x0 = this.f15187D1;
        if (c3392x0 != null) {
            c3392x0.cancel();
            this.f15187D1.release();
        }
        C13950f c13950f = this.f15334h1;
        if (c13950f != null) {
            c13950f.m83863l();
        }
        SafeWebView safeWebView = this.f15293Y3;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
            this.f15293Y3.removeAllViews();
            this.f15293Y3.destroy();
        }
        f15169x5 = false;
        if (TextUtils.equals(C0209d.m1295q(this), NotifyConstants.Action.ACTION_MAIN_ACTIVITY)) {
            C9913h.m61574q().m61577D();
        }
        m21321Yb();
        HandlerC3357g1 handlerC3357g1 = this.f15189D4;
        if (handlerC3357g1 != null) {
            handlerC3357g1.removeCallbacksAndMessages(null);
            this.f15189D4 = null;
        }
        super.onDestroy();
        C11829c.m70606p1(true);
        if (this.f15179B4 != null) {
            C11737b.m70035b().m70041g(this.f15179B4);
        }
        if (this.f15241O0 != null) {
            C13108a.m78878b(this).m78883f(this.f15241O0);
        }
        CampaignEntryFloatView campaignEntryFloatView = this.f15184C4;
        if (campaignEntryFloatView != null) {
            campaignEntryFloatView.m25677d();
            this.f15184C4 = null;
        }
        this.f15385t = 0L;
        C13823d.m82903c();
        C10153d.m63237a().clear();
        if (this.f15356m5 != null) {
            CloudBackupService.getInstance().unregister(this.f15356m5);
        }
        ForcedUpgradeUtil.getInstance().setUserCancelForcedUpgrade(false);
        C9681b.m60470l().m60485e();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback
    public void onNegativeClick() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C11839m.m70686d("MainActivity", "onNewIntent");
        this.f15198F3 = true;
        setIntent(intent);
        m21507w8();
        m21418l8();
        m21247P8(getIntent());
        m20977L5();
        m21159F4();
        this.f15324e5.postDelayed(this.f15332g5, 200L);
        m21322Z4();
        if (C14163d.m84990g().m85009o()) {
            startActivityForResult(new Intent(this, (Class<?>) DataMigrationAuthActivity.class), 10023);
        }
        m21282U4();
        m21376fc();
        m21367ec();
        m21335ac();
        m21329Zb();
        m21286U8();
        this.f15203G3 = "campaign_center".equals(new SafeIntent(intent).getStringExtra(RemoteMessageConst.FROM));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        C11839m.m70686d("MainActivity", "onPause");
        UrgencyScrollUpView urgencyScrollUpView = this.f15282W1;
        if (urgencyScrollUpView != null && urgencyScrollUpView.getVisibility() == 0) {
            this.f15282W1.m24011l();
        }
        super.onPause();
        this.f15402w1 = false;
        this.f15406x1 = false;
        C13950f c13950f = this.f15334h1;
        if (c13950f != null) {
            c13950f.m83835M();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback
    public void onPositiveClick(PayActivityInfo payActivityInfo) {
        String str = this.f15228L3 ? "main_new_user_scene" : "main_agreement_change_scene";
        C10028c.m62182c0().m62296Y1("1111222222222222");
        C12515a.m75110o().m75172d(new C11258f(true, "1111222222222222", str));
        if (this.f15193E3) {
            Intent intent = new Intent();
            intent.setClass(this, CloudSpaceUpgradeActivity.class);
            intent.putExtra("from_where", 2);
            intent.putExtra("activityInfo", payActivityInfo);
            startActivity(intent);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Dialog dialog;
        SpaceDisplayFragment spaceDisplayFragment;
        C11839m.m70686d("MainActivity", "onRestart");
        super.onRestart();
        if (!C0209d.m1208S0(this)) {
            m20973Kc();
            CloudBackupService.getInstance().getState();
        }
        C1008c.m6035v().m6051P(this.f15414z, this.f15299Z4, false);
        if (this.f15253Q3 && (spaceDisplayFragment = this.f15186D0) != null) {
            spaceDisplayFragment.m24255H();
        }
        m21282U4();
        if (this.f15377r1 && m21237O4()) {
            m21257Qb();
        }
        if (this.f15392u1 && (dialog = this.f15266T0) != null) {
            dialog.show();
            this.f15292Y1.m65762i("POLICY_SERVICE");
        }
        CloudBackupService.getInstance().showLastRecord(true);
        if (this.f15316d1) {
            return;
        }
        if (this.f15382s1) {
            m21259R4();
        }
        if (!C13612b.m81829B().isLogin()) {
            C11839m.m70688i("MainActivity", "not login");
            finish();
            return;
        }
        C10718a c10718a = this.f15182C1;
        if (c10718a != null) {
            c10718a.m65431l();
        }
        m21322Z4();
        m21376fc();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        C11839m.m70686d("MainActivity", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        int i10 = bundle.getInt("scroll_value");
        this.f15333h0 = i10;
        m21440o8(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C13950f c13950f;
        C12515a.m75110o().m75175e(this.f15294Y4, true);
        C10028c.m62182c0().m62249N1("");
        C11839m.m70686d("MainActivity", "onResume");
        m21490u8(2);
        m21195J6();
        m21152E6();
        UrgencyScrollUpView urgencyScrollUpView = this.f15282W1;
        if (urgencyScrollUpView != null && urgencyScrollUpView.getVisibility() == 0) {
            this.f15282W1.m24011l();
            this.f15282W1.m24009j();
            this.f15282W1.m24010k();
        }
        super.onResume();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onResume isReenter:");
        sb2.append(this.f15248P3);
        sb2.append(" mInactiveData is null:");
        sb2.append(this.f15289X4 == null);
        C11839m.m70686d("MainActivity", sb2.toString());
        this.f15402w1 = true;
        C13612b.m81829B().m81886t(this);
        m21437o5();
        m21128B9();
        if (!C13452e.m80781L().m80917g1() && (c13950f = this.f15334h1) != null) {
            c13950f.m83849a0();
        }
        if (this.f15334h1 != null) {
            C14317j.m85300d().m85319t();
        }
        m21524y8();
        m21516x8();
        m21531z8();
        C1006a c1006aM5936k = C1006a.m5936k();
        if (c1006aM5936k.m5975v(C0213f.m1377a())) {
            c1006aM5936k.m5941E();
            c1006aM5936k.m5944H();
        }
        c1006aM5936k.m5957c(getApplicationContext());
        Handler handler = this.f15324e5;
        if (handler != null) {
            handler.postDelayed(this.f15348k5, 200L);
        }
        C2783d.m16167o1();
        m21148Db();
        m21475sa();
        Handler handler2 = this.f15324e5;
        if (handler2 != null) {
            handler2.postDelayed(this.f15352l5, 200L);
        }
        m21194J5();
        m21485tb();
        m21274Sa();
        m21275T4();
        m21219M4();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C11839m.m70688i("MainActivity", "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        bundle.putInt("scroll_value", this.f15333h0);
        ClaimSpacePopDialog claimSpacePopDialog = this.f15256R0;
        if (claimSpacePopDialog == null || !claimSpacePopDialog.isShowing()) {
            return;
        }
        SpaceNoticeCommonSpUtil.getInstance().setShownAlready(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C11839m.m70686d("MainActivity", "onStart");
        m21499v9();
        C12515a.m75110o().m75172d(new C3373o());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        this.f15229L4.m16454n();
        super.onStop();
        m21389ha();
    }

    /* renamed from: p5 */
    public void m21445p5(Object obj) {
        C11839m.m70688i("MainActivity", "dealGetAcountHeadPicSuccess");
        if (obj == null) {
            C11839m.m70687e("MainActivity", "dealGetAcountHeadPicSuccess object is null.");
        } else if (obj instanceof Bitmap) {
            m21198J9((Bitmap) obj);
        } else {
            C11839m.m70687e("MainActivity", "dealGetAcountHeadPicSuccess object is not bitmap.");
        }
    }

    /* renamed from: p6 */
    public final boolean m21446p6(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = message.what;
        if (i10 == 11 || i10 == 15 || i10 == 67 || i10 == 116 || i10 == 1003 || i10 == 1202) {
            m21462r6(message);
            return true;
        }
        if (i10 == 99001) {
            return true;
        }
        if (i10 == 102) {
            C11839m.m70688i("MainActivity", "finish,msg_sim_change_pwd_check_failed");
            finish();
            return true;
        }
        if (i10 == 103) {
            m21514x6(message);
            return true;
        }
        if (i10 != 9001 && i10 != 9002) {
            return false;
        }
        C11839m.m70688i("MainActivity", "setPhoneFinderState msg = " + message.what);
        m21320Ya();
        C12300b0.m73940b().m73942d();
        return true;
    }

    /* renamed from: p7 */
    public final void m21447p7() {
        UrgencyScrollUpView urgencyScrollUpView = (UrgencyScrollUpView) C12809f.m76829b(this, R$id.cloud_urgency_scrollup_text);
        this.f15282W1 = urgencyScrollUpView;
        urgencyScrollUpView.setVisibility(8);
        this.f15282W1.setOnItemClickListener(new C3381s());
    }

    /* renamed from: p8 */
    public final void m21448p8() {
        StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
        this.f15301a1 = storageInfoM80226P.getDisuseState();
        this.f15306b1 = storageInfoM80226P.getLeftDays();
        m21176Gc();
    }

    /* renamed from: p9 */
    public final void m21449p9() {
        m21158Ec();
        m21239O6();
    }

    /* renamed from: pa */
    public final void m21450pa() {
        this.f15304a5.sendEmptyMessageDelayed(9011, 200L);
    }

    /* renamed from: pb */
    public void m21451pb(SafeWebView safeWebView) {
        if (safeWebView == null) {
            C11839m.m70687e("MainActivity", "setWebViewSetting webView is null");
            return;
        }
        C11525b.m68802f(safeWebView);
        m21208Ka(safeWebView);
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("MainActivity", "setJavaScriptEnabled fail,WebSettings is null");
            return;
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        safeWebView.addJavascriptInterface(new ToolEcologyWapExternal(safeWebView, this, this), "ToolEcology");
        safeWebView.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.MainActivity.26
            public C333626() {
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                C11839m.m70688i("MainActivity", "tool onProgressChanged newProgress =" + i10);
                MainActivity.this.m21268S4();
                if (i10 != 100) {
                    MainActivity.this.m21395i8(webView, false);
                } else {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.m21395i8(webView, mainActivity.f15343j4);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                C11839m.m70688i("MainActivity", "onReceivedTitle");
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                C11839m.m70688i("MainActivity", "onActivityResult onShowFileChooser");
                MainActivity.this.f15355m4 = valueCallback;
                return MainActivity.this.m22373g1();
            }
        });
    }

    /* renamed from: pc */
    public final void m21452pc(String str, String str2, int i10) {
        NotifyConstants.putServicesMoudleIntoMap(str, true);
        m21163F8(str, str2, i10);
        C1008c.m6035v().m6075g0(this, str, 1, "");
        C13950f c13950f = this.f15334h1;
        if (c13950f != null) {
            c13950f.m83858i0(str, Boolean.TRUE);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: q1 */
    public void mo21453q1() {
        C13008a.m78300b().m78302c(this);
    }

    /* renamed from: q4 */
    public final void m21454q4() {
        this.f15289X4 = null;
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.setInactiveTVVisible(false);
        }
        m21255Q9();
    }

    /* renamed from: q5 */
    public final void m21455q5() {
        List<String> list = this.f15209H4;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            if (TextUtils.isEmpty(str)) {
                arrayList.add(C1248a.m7477h(getResources(), R$drawable.img_defaultavatar_list_gray));
            } else {
                Bitmap bitmapM70501B = C11829c.m70501B(getFilesDir() + FamilyShareConstants.FAMILY_IMAGE_FILE_PATH + str.hashCode());
                if (bitmapM70501B == null) {
                    arrayList.add(C1248a.m7477h(getResources(), R$drawable.img_defaultavatar_list_gray));
                } else {
                    arrayList.add(C11842p.m70860s(bitmapM70501B));
                }
            }
        }
        this.f15412y3.setIconBitmapList(arrayList);
    }

    /* renamed from: q6 */
    public final boolean m21456q6(Message message) {
        C11839m.m70686d("MainActivity", "message type is " + message.what);
        int i10 = message.what;
        if (i10 == 0) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof Dialog)) {
                m21147Da("PUSH_MARKETING_NOTICE");
                m21147Da("CLAM_POP");
                m21147Da("GET_SPACE_OK_H5_DIALOG");
                this.f15292Y1.m65765l("POLICY_SERVICE", (Dialog) obj);
                this.f15292Y1.m65754a("POLICY_SERVICE");
            }
        } else if (i10 == 1) {
            m21147Da("POLICY_SERVICE");
            m21171G7(JumpInactivePageStatus.PROTOCOL_CHECK_PASSED);
            m21145D8();
        } else if (i10 == 3) {
            this.f15292Y1.m65765l("POLICY_SERVICE", null);
            this.f15292Y1.m65754a("POLICY_SERVICE");
        } else if (i10 == 9007) {
            Object obj2 = message.obj;
            if (obj2 == null || !(obj2 instanceof Boolean) || ((Boolean) obj2).booleanValue()) {
                m21508w9();
            }
            RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, false);
        } else if (i10 == 10035) {
            Object obj3 = message.obj;
            if (obj3 != null && (obj3 instanceof ModuleItemForAll)) {
                m21193J4((ModuleItemForAll) obj3);
            }
        } else {
            if (i10 != 1000007) {
                return m21471s6(message);
            }
            m21388h9(message);
        }
        return true;
    }

    /* renamed from: q9 */
    public final void m21457q9() {
        for (int i10 = 0; i10 < this.f15249P4.size(); i10++) {
            m21358db(this.f15249P4.get(i10));
        }
    }

    /* renamed from: qa */
    public final void m21458qa(boolean z10) {
        C11839m.m70686d("MainActivity", "mRefreshRecommendView=" + this.f15406x1);
        if (this.f15406x1) {
            return;
        }
        this.f15406x1 = true;
        Message messageObtain = Message.obtain();
        messageObtain.what = 9007;
        messageObtain.obj = Boolean.valueOf(z10);
        this.f15304a5.sendMessage(messageObtain);
    }

    /* renamed from: qb */
    public final boolean m21459qb() {
        if (this.f15203G3) {
            C11839m.m70686d("MainActivity", "from campaignActivity, return");
            this.f15198F3 = false;
            return false;
        }
        if (C11842p.f.PERCENT_100.m70892b(this.f15381s0)) {
            C11839m.m70686d("MainActivity", "TaskCenter has been shown");
            this.f15198F3 = false;
            return false;
        }
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "common_account_app", "last_resume_activity", "");
        if (strM1364n != null && strM1364n.equals(CampaignActivity.class.getCanonicalName())) {
            C11839m.m70686d("MainActivity", "last activity is CampaignActivity, scroll to CampaignCard");
            return true;
        }
        if (!C0212e0.m1355e(this, "common_account_app", "campaign_card_visible", false)) {
            return false;
        }
        C11839m.m70686d("MainActivity", "last CampaignCard is visible to user, scroll to CampaignCard");
        return true;
    }

    /* renamed from: qc */
    public final void m21460qc(String str, int i10) {
        m21163F8("wlan", str, i10);
        C1008c.m6035v().m6061Z("dsswitch");
        C1008c.m6035v().m6081j0(this);
        C1008c.m6035v().m6089n0(this);
        this.f15215J.setCheckedProgrammatically(true);
        m21137C9(this.f15215J);
    }

    /* renamed from: r4 */
    public final void m21461r4() {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("MainActivity", " uploadStatusSuccess isCloudphotoManagerEnable false");
            this.f15220K.setNoSubTitle(true);
            this.f15220K.setShowSubTitle(false);
            m21137C9(this.f15220K);
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58460v0(this.f15414z, "", false, true);
            return;
        }
        this.f15220K.setNoSubTitle(true);
        this.f15220K.setShowSubTitle(false);
        m21137C9(this.f15220K);
    }

    /* renamed from: r6 */
    public final void m21462r6(Message message) {
        C11839m.m70686d("MainActivity", "task end ,module " + message.what);
    }

    /* renamed from: r7 */
    public final void m21463r7() {
        this.f15396v0.add(this.f15325f0);
        this.f15396v0.add(this.f15371q0);
        this.f15396v0.add(this.f15357n0);
        this.f15396v0.add(this.f15361o0);
        this.f15396v0.add(this.f15366p0);
        this.f15396v0.add(this.f15353m0);
        this.f15396v0.add(this.f15381s0);
        this.f15396v0.add(this.f15386t0);
    }

    /* renamed from: r8 */
    public final void m21464r8(Context context, SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (safeIntent == null) {
            return;
        }
        String action = safeIntent.getAction();
        if ("action_parse_config_finish".equals(action)) {
            C11839m.m70688i("MainActivity", "receive ACTION_PARSE_CONFIG_FINISH, do initSyncItemView");
            m21155E9(context);
            return;
        }
        if ("action_drive_parse_config_finish".equals(action)) {
            C11839m.m70688i("MainActivity", "receive ACTION_DRIVE_PARSE_CONFIG_FINISH, do refreshDriveItemView");
            m21155E9(context);
            m21449p9();
            return;
        }
        if ("com.huawei.hicloud.intent.action.BASIC_CONFIG_REFRESH_FINISH".equals(action)) {
            if (safeIntent.getBooleanExtra("isFromMigration", false)) {
                C11839m.m70688i("MainActivity", "receive BASIC_CONFIG_REFRESH_FINISH, from migrate, finish");
                finish();
                return;
            } else {
                C11839m.m70688i("MainActivity", "receive BASIC_CONFIG_REFRESH_FINISH, do initSyncItemView");
                m21155E9(context);
                return;
            }
        }
        if ("com.huawei.hicloud.intent.action.SAFE_INFO_CONFIG_SUCCESS".equals(action)) {
            C11839m.m70688i("MainActivity", "receive SAFE_INFO_CONFIG_SUCCESS");
            m21197J8();
            return;
        }
        if ("checkFinish".equals(action)) {
            C11839m.m70688i("MainActivity", "receive CHECK_UPDATE_ACTION, is need to show: " + safeIntent.getBooleanExtra("visibility", false));
            return;
        }
        if ("com.huawei.android.hicloud.sendmessage".equals(action)) {
            FeedbackMailProcessor.getInstance().jumpToMailView(this, safeIntent.getStringExtra("accessoryName"), C10028c.m62182c0().m62237L());
        } else {
            if (!"com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW".equals(action)) {
                m21473s8(safeIntent);
                return;
            }
            if (safeIntent.getBooleanExtra("needUpdateStorage", false)) {
                m21357da();
            }
            SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
            if (spaceDisplayFragment != null) {
                spaceDisplayFragment.m24261N();
            }
            m21291V5();
        }
    }

    /* renamed from: r9 */
    public final void m21465r9() {
        if (this.f15389t5 == null) {
            C11839m.m70687e("MainActivity", "refreshExchangeMenu, params is null.");
            return;
        }
        Response response = this.f15394u5;
        if (response == null || response.getResultCode() != 0) {
            C11839m.m70687e("MainActivity", "refreshExchangeMenu, cardSupportResp is null or not success.");
            return;
        }
        if (TextUtils.isEmpty(this.f15389t5.getPromotionCardTitle())) {
            C11839m.m70687e("MainActivity", "refreshExchangeMenu, exchangeTitle is null or empty.");
            return;
        }
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            return;
        }
        RelativeLayout moreHotSpace = gradientActionBar.getMoreHotSpace();
        if (this.f15297Z1 != null && moreHotSpace != null) {
            Boolean boolM80803F0 = C13452e.m80781L().m80803F0();
            boolM80803F0.booleanValue();
            m21265Ra(boolM80803F0, moreHotSpace);
        }
        this.f15394u5 = null;
    }

    /* renamed from: ra */
    public final void m21466ra() {
        HandlerC3357g1 handlerC3357g1 = this.f15189D4;
        if (handlerC3357g1 == null) {
            C11839m.m70687e("MainActivity", "uiHandler null");
            return;
        }
        if (handlerC3357g1.hasMessages(103)) {
            this.f15189D4.removeMessages(103);
        }
        this.f15189D4.sendMessageDelayed(Message.obtain(this.f15189D4, 103), 200L);
    }

    /* renamed from: rb */
    public final void m21467rb() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if ("81".equals(this.f15234M4)) {
            m21503w4();
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f15414z, "create_shortcut_sp", 0);
        this.f15272U1 = sharedPreferencesM1382b.getBoolean("isCreatShortcut", true);
        boolean zIsAllModuleDisabledIncludePhonefinder = ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this);
        if (!this.f15272U1 || zIsAllModuleDisabledIncludePhonefinder || !C1443a.f6215c.booleanValue()) {
            moveTaskToBack(true);
            m21003Sb(this, 2);
            return;
        }
        AddToDesktopDialog addToDesktopDialog = new AddToDesktopDialog(this.f15414z);
        this.f15370q = addToDesktopDialog;
        addToDesktopDialog.show();
        sharedPreferencesM1382b.edit().putBoolean("isCreatShortcut", false).commit();
        C2783d.m16082F0("");
    }

    /* renamed from: rc */
    public final void m21468rc() {
        C11839m.m70686d("MainActivity", "taskCenterReport");
        if (this.f15339i4 || !C11842p.f.PERCENT_50.m70892b(this.f15381s0)) {
            return;
        }
        this.f15339i4 = true;
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R("task_center_show", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "task_center_show", linkedHashMapM79499C);
    }

    /* renamed from: s4 */
    public final void m21469s4() {
        this.f15229L4.m16461u(new IconManager.IconCallBack() { // from class: com.huawei.android.hicloud.ui.activity.x5
            @Override // com.huawei.android.hicloud.manager.IconManager.IconCallBack
            /* renamed from: a */
            public final void mo16467a(boolean z10) {
                this.f17802a.m21205K7(z10);
            }
        });
    }

    /* renamed from: s5 */
    public final void m21470s5(Message message) throws Resources.NotFoundException {
        FamilyDetailInfoRetBody retBody;
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = (FamilyShareInfoAndDetailResult) message.obj;
        if (familyShareInfoAndDetailResult == null) {
            C11839m.m70687e("MainActivity", "space share info and detail is null");
            return;
        }
        String gradeCode = familyShareInfoAndDetailResult.getGradeCode();
        if (TextUtils.isEmpty(gradeCode)) {
            gradeCode = C13452e.m80781L().m80790C();
        }
        if (TextUtils.equals(CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE, gradeCode)) {
            m21134C6();
            return;
        }
        if (this.f15407x3 == null || this.f15412y3 == null) {
            C11839m.m70687e("MainActivity", "dealGetShareInfoHandler, cloudSpaceShareContainer or cloudSpaceShareEnter is null.");
            return;
        }
        FamilyDetailInfoResult familyDetailInfoResult = familyShareInfoAndDetailResult.getFamilyDetailInfoResult();
        FamilyShareInfoResult familyShareInfoResult = familyShareInfoAndDetailResult.getFamilyShareInfoResult();
        this.f15219J4 = familyShareInfoResult;
        if (familyShareInfoResult == null) {
            C11839m.m70688i("MainActivity", "getshareinfo failed " + message.what);
            return;
        }
        if (familyShareInfoResult.getRetCode() != 0) {
            C11839m.m70688i("MainActivity", "getshareinfo failed " + this.f15219J4.getRetCode());
            return;
        }
        C11839m.m70688i("MainActivity", "getshareinfo success");
        FamilyShareInfoResult familyShareInfoResult2 = this.f15219J4;
        if (familyShareInfoResult2 != null) {
            this.f15214I4 = false;
            if (familyShareInfoResult2.getFamilyShareEnable() != 1) {
                if (familyShareInfoAndDetailResult.getTotalSpace() < RecommendCardConstants.Num.GB_200) {
                    this.f15407x3.setVisibility(8);
                    this.f15412y3.setVisibility(8);
                    return;
                }
                this.f15407x3.setVisibility(0);
                this.f15412y3.setVisibility(0);
                this.f15412y3.setTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_space_share_title"));
                this.f15412y3.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_space_share_content"));
                this.f15214I4 = true;
                this.f15412y3.setArrowText("");
                m21429n5();
                return;
            }
            this.f15407x3.setVisibility(0);
            this.f15412y3.setVisibility(0);
            int spaceShareEnable = this.f15219J4.getSpaceShareEnable();
            boolean z10 = this.f15219J4.getSpaceShareOwner() != -1;
            List<FamilyDetailInfo> usedSpaceInfoList = (familyDetailInfoResult == null || (retBody = familyDetailInfoResult.getRetBody()) == null) ? null : retBody.getUsedSpaceInfoList();
            if (spaceShareEnable == 0) {
                if (z10) {
                    this.f15412y3.hideLoading();
                    this.f15412y3.hideRedImg();
                    this.f15412y3.setArrowText(getString(R$string.not_join));
                    this.f15412y3.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
                } else {
                    this.f15412y3.hideLoading();
                    this.f15412y3.hideRedImg();
                    if (familyShareInfoAndDetailResult.getTotalSpace() == 53687091200L) {
                        try {
                            if (SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_share_content").contains("%d")) {
                                this.f15412y3.setSubTitleText(String.format(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_share_content"), 200));
                            } else {
                                this.f15412y3.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_share_content"));
                            }
                        } catch (Exception e10) {
                            C11839m.m70687e("MainActivity", "initBasicDataGuideView, basic_data_cloud_share_content use default, err：" + e10);
                            this.f15412y3.setSubTitleText(getString(R$string.basic_data_cloud_share_content, 200));
                        }
                    } else {
                        this.f15412y3.setArrowText(getString(R$string.settings_hicloud_disabled));
                        this.f15412y3.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
                    }
                }
                this.f15412y3.setTitleText(getString(R$string.cloud_space_share));
                this.f15412y3.setIconListFrame(false, false);
            } else {
                this.f15412y3.setTitleText(getString(R$string.cloud_space_share));
                m21474s9(usedSpaceInfoList);
                m21483t9();
            }
            m21429n5();
        }
    }

    /* renamed from: s6 */
    public final boolean m21471s6(Message message) {
        C11839m.m70686d("MainActivity", "handleClaimMsg message type is " + message.what);
        int i10 = message.what;
        if (i10 == 4) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                C11839m.m70688i("MainActivity", "final can show dialog = " + str);
                m21228N4(str);
            }
        } else if (i10 == 5) {
            C11839m.m70688i("MainActivity", "policy agree");
            this.f15292Y1.m65762i("POLICY_SERVICE");
            Object obj2 = message.obj;
            if (obj2 != null && (obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                m21171G7(JumpInactivePageStatus.PROTOCOL_CHECK_PASSED);
                this.f15292Y1.m65763j("PUSH_MARKETING_NOTICE");
                this.f15292Y1.m65763j("CLAM_POP");
                m21057i9();
                m21477sc();
                m21278T8();
            }
        } else {
            if (i10 != 2001) {
                return m21480t6(message);
            }
            Object obj3 = message.obj;
            if (obj3 != null && (obj3 instanceof UserPackage)) {
                UserPackage userPackage = (UserPackage) obj3;
                this.f15399v5 = userPackage;
                if (userPackage.getUserPayType() == 0) {
                    C11839m.m70686d("MainActivity", "usertype is free");
                    C9713b.m60566c().m60569d(this.f15304a5, NoticeWithActivityUtil.checkRecommendActivityType(), 1, true);
                } else {
                    m21147Da("CLAM_POP");
                }
            }
        }
        return true;
    }

    /* renamed from: s7 */
    public final void m21472s7() {
        SyncItemInfo syncItemInfoM21337b6 = m21337b6("wlan", this.f15215J);
        if (syncItemInfoM21337b6 == null) {
            SyncItemInfo syncItemInfo = new SyncItemInfo();
            this.f15215J = syncItemInfo;
            syncItemInfo.setShowSwitch(true);
            this.f15215J.setSubUserDisable(true);
            this.f15215J.setId("wlan");
        } else {
            this.f15215J = syncItemInfoM21337b6;
            syncItemInfoM21337b6.setShowSwitch(true);
            this.f15215J.setSubUserDisable(true);
        }
        Resources resources = getResources();
        if (resources != null) {
            this.f15215J.setImage(getDrawable(R$drawable.ic_wifi));
            if (C0209d.m1262h2()) {
                this.f15215J.setTitle(resources.getString(R$string.wlan_sync));
            } else {
                this.f15215J.setTitle(resources.getString(R$string.wifi_sync));
            }
        }
    }

    /* renamed from: s8 */
    public final void m21473s8(SafeIntent safeIntent) {
        String action = safeIntent.getAction();
        if ("com.huawei.hicloud.intent.action.ACTION_REFRESH_FIRST_PAGE".equals(action)) {
            m21269S5();
            return;
        }
        if ("com.huawei.hicloud.DELETE_STORAGE_FINISHED".equals(action)) {
            String stringExtra = safeIntent.getStringExtra("moduleName");
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (TextUtils.equals(stringExtra, NavigationUtils.SMS_SCHEMA_PREF)) {
                if (interfaceC9284c != null) {
                    interfaceC9284c.mo17095J();
                }
            } else if (TextUtils.equals(stringExtra, "calllog") && interfaceC9284c != null) {
                interfaceC9284c.mo17149s0();
            }
            m21269S5();
            return;
        }
        if ("com.huawei.android.intent.action.CLOUD_BACKUP_DELETE".equals(action)) {
            C11839m.m70686d("MainActivity", "delete backup record");
            m21357da();
            return;
        }
        if ("com.huawei.cg.action.SPACE_DELETED_CHANGED".equals(action)) {
            C11839m.m70688i("MainActivity", "main gallery change,updata size");
            C13368e.m80184F().m80253r0();
            C13368e.m80184F().m80250o0();
            return;
        }
        if (RecommendCardConstants.HOMEPAGE_RECOMMEND_REFRESH_FINISH_ACTION.equals(action)) {
            C11839m.m70688i("MainActivity", "receive refresh recommend card finish action");
            m21508w9();
            return;
        }
        if ("com.huawei.hicloud.intent.action.HICLOUD_SPACE_POSITION_MGR_REFRESH_FINISH_ACTION".equals(action)) {
            C11839m.m70688i("MainActivity", "receive: " + action);
            RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, false);
            return;
        }
        if ("com.huawei.hicloud.action.ACTION_MESSAGE_STATUS_CHANGED".equals(action) || "com.huawei.hicloud.action.ACTION_MESSAGE_NUM_CHANGED".equals(action)) {
            C11839m.m70688i("MainActivity", "receive ACTION_MESSAGE_STATUS_CHANGED action");
            Handler handler = this.f15324e5;
            if (handler != null) {
                handler.postDelayed(this.f15344j5, 200L);
                return;
            }
            return;
        }
        if ("com.huawei.hicloud.getCloudPhotoTotalSize".equals(action)) {
            if (!C10155f.m63299w()) {
                C11839m.m70686d("MainActivity", "receive ACTION_GET_CLOUD_PHOTO_TOTAL_SIZE action , not show cloud photo manager ");
                return;
            }
            String stringExtra2 = safeIntent.getStringExtra("param_pic_and_video_content");
            String stringExtra3 = safeIntent.getStringExtra("param_num_content");
            boolean booleanExtra = safeIntent.getBooleanExtra("is_num_append", false);
            C11839m.m70686d("MainActivity", "receive ACTION_GET_CLOUD_PHOTO_TOTAL_SIZE action, picAndViedoStr=" + stringExtra2 + ", content=" + stringExtra3 + ", isAppend=" + booleanExtra);
            if (booleanExtra) {
                this.f15334h1.m83859j(this, stringExtra2, stringExtra3);
            } else {
                this.f15334h1.m83857i(this, stringExtra2);
            }
            C0212e0.m1372v(this.f15414z, "sp_have_show_cloud_photo", "key_main_page_gallery_status", stringExtra3);
            C0212e0.m1372v(this.f15414z, "sp_have_show_cloud_photo", "key_main_page_gallery_count", stringExtra2);
            return;
        }
        if ("com.huawei.hicloud.more.setting.clear.cache".equals(action)) {
            boolean booleanExtra2 = safeIntent.getBooleanExtra("reportDeleteFile", false);
            boolean booleanExtra3 = safeIntent.getBooleanExtra("clearWebViewCache", false);
            C11839m.m70688i("MainActivity", "receive clear cache");
            if (booleanExtra3) {
                m21352d5();
            }
            C13950f c13950f = this.f15334h1;
            if (c13950f != null) {
                c13950f.m83866m0(booleanExtra2);
                return;
            }
            return;
        }
        if ("com.huawei.android.hicloud.intent.SWITCH_CHANGED".equals(action)) {
            String stringExtra4 = safeIntent.getStringExtra("syncType");
            boolean booleanExtra4 = safeIntent.getBooleanExtra("switchState", false);
            C11839m.m70688i("MainActivity", "BackupOn sync switch changed! syncType = " + stringExtra4 + ", switchState = " + booleanExtra4);
            m21232N8(booleanExtra4, stringExtra4, 5);
            return;
        }
        if ("newBusinessChangeSuccess".equals(action)) {
            C11839m.m70688i("MainActivity", "ACTION_NEW_BUSINESS_CHANGE_SUCCESS");
            SpaceDisplayFragment spaceDisplayFragment = this.f15186D0;
            if (spaceDisplayFragment != null) {
                spaceDisplayFragment.m24258K();
            }
            m21433n9();
            return;
        }
        if ("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_CHANGE".equals(action)) {
            C11839m.m70688i("MainActivity", "ACTION_GRADE_CODE_CHANGE");
            m21433n9();
            return;
        }
        if ("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_PUSH".equals(action)) {
            C11839m.m70688i("MainActivity", "ACTION_GRADE_CODE_PUSH");
            ExpirationReminderCardView expirationReminderCardView = this.f15175B;
            if (expirationReminderCardView != null) {
                expirationReminderCardView.m25762k();
            }
            if (!C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
                C11839m.m70688i("MainActivity", "MainActivity isForeground false");
                return;
            }
            C11060c c11060c = new C11060c();
            c11060c.m66664t("06008");
            c11060c.m66643I(C11058a.m66627b("06008"));
            C9158a.m57503F().m57515M(this.f15304a5, 3, c11060c, false, true, "ACTION_GRADE_CODE_PUSH");
            m21291V5();
            C13823d.m82903c();
            m21195J6();
            m21219M4();
        }
    }

    /* renamed from: s9 */
    public final void m21474s9(List<FamilyDetailInfo> list) throws Resources.NotFoundException {
        if (list == null) {
            m21200Jb(false);
            this.f15412y3.hideStorageManageCardSubTitle();
            this.f15412y3.hideSubDataListView();
            return;
        }
        int size = m21290V4(list).size();
        if (size <= 0) {
            m21200Jb(false);
            this.f15412y3.hideStorageManageCardSubTitle();
            this.f15412y3.hideSubDataListView();
        } else {
            m21200Jb(true);
            Resources resources = getResources();
            if (resources != null) {
                this.f15412y3.setStorageManageCardNumber(resources.getQuantityString(R$plurals.joined_member_desc, size, Integer.valueOf(size)), size);
            }
            this.f15412y3.hideStorageManageCardSubTitle();
        }
    }

    /* renamed from: sa */
    public final void m21475sa() {
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.m23953o();
        }
    }

    /* renamed from: sb */
    public final void m21476sb() {
        if (C10155f.m63300x() && this.f15368p4 != null) {
            C11839m.m70688i("MainActivity", "showAlbumShareProgressBar VISIBLE");
            this.f15368p4.setVisibility(0);
        }
    }

    /* renamed from: sc */
    public final void m21477sc() {
        boolean zIsShownAlready = SpaceNoticeCommonSpUtil.getInstance().isShownAlready();
        if (C2783d.m16111U(this)) {
            m21241O8();
            return;
        }
        if (zIsShownAlready) {
            m21147Da("CLAM_POP");
        } else if (SpaceNoticeCommonSpUtil.getInstance().isSupport()) {
            m21241O8();
        } else {
            m21147Da("CLAM_POP");
        }
    }

    /* renamed from: t4 */
    public final void m21478t4() {
        if (this.f15229L4.m16463w(getPackageName())) {
            m21147Da("ADD_ICON_DIALOG_ID");
        } else {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.u5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17760a.m21222M7();
                }
            });
        }
    }

    /* renamed from: t5 */
    public final void m21479t5(Bundle bundle) {
        String string = bundle.getString("photoUrl");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getApplicationContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        String string2 = sharedPreferencesM1382b.getString("AccountInfoaccountPhotoUrl", null);
        C11839m.m70686d("MainActivity", "userPicUrl = " + string + " preUserPhotoUrl = " + string2 + " mUserPhotoBitmap = " + this.f15401w0);
        if ((!TextUtils.isEmpty(string) && !string.equals(string2)) || this.f15401w0 == null) {
            C11839m.m70688i("MainActivity", "prepareShowAccountInfo prepare get new head photo.");
            sharedPreferencesM1382b.edit().putString("AccountInfoaccountPhotoUrl", string).commit();
            C12515a.m75110o().m75172d(new GetUserAvatarTask(this.f15304a5, string, true));
            return;
        }
        if (!TextUtils.isEmpty(string) || string2 == null) {
            C11839m.m70688i("MainActivity", "prepareShowAccountInfo do not set image");
            return;
        }
        C11839m.m70688i("MainActivity", "prepareShowAccountInfo use default photo.");
        sharedPreferencesM1382b.edit().putString("AccountInfoaccountPhotoUrl", string).commit();
        this.f15181C0.setImageDrawable(getDrawable(R$drawable.img_defaultavatar_list_gray));
        C10809w.m65797a();
    }

    /* renamed from: t6 */
    public final boolean m21480t6(Message message) {
        C11839m.m70686d("MainActivity", "handleClaimMsg2 message type is " + message.what);
        int i10 = message.what;
        if (i10 == 2131) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof UserPackage)) {
                UserPackage userPackage = (UserPackage) obj;
                this.f15399v5 = userPackage;
                if (userPackage.getUserPayType() == 0) {
                    C11839m.m70686d("MainActivity", "pushguide,usertype is free");
                    C9713b.m60566c().m60569d(this.f15304a5, NoticeWithActivityUtil.checkRecommendActivityTypeForPushGuide(), 1, true);
                } else {
                    C11839m.m70686d("MainActivity", "pushguide,usertype is not free");
                    m21216Lb(null);
                }
            }
        } else if (i10 == 7016) {
            Object obj2 = message.obj;
            if (obj2 != null && (obj2 instanceof GetRecommendActivityResp)) {
                m21501vb(((GetRecommendActivityResp) obj2).getPayActivityInfo());
            }
        } else {
            if (i10 != 7018) {
                return m21488u6(message);
            }
            Object obj3 = message.obj;
            if (obj3 != null && (obj3 instanceof GetRecommendActivityResp)) {
                PayActivityInfo payActivityInfo = ((GetRecommendActivityResp) obj3).getPayActivityInfo();
                C11839m.m70688i("MainActivity", "get recommend activity for push guide success");
                m21216Lb(payActivityInfo);
            }
        }
        return true;
    }

    /* renamed from: t7 */
    public final void m21481t7() {
        C11839m.m70688i("MainActivity", "initUrgencyReciver");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (this.f15221K0 == null) {
            this.f15221K0 = new UrgencyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("notify_urgency_top_banner");
            c13108aM78878b.m78880c(this.f15221K0, intentFilter);
        }
    }

    /* renamed from: t8 */
    public final void m21482t8(String str) {
        C9904a.m61488b().m61495h(this);
        C13227f.m79492i1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", "100");
        if ("browser".equals(this.f15390u)) {
            C11839m.m70686d("MainActivity", "jump by browser");
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f15395v));
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e10) {
                C11839m.m70687e("MainActivity", "browser ActivityNotFoundException : " + e10.toString());
                return;
            }
        }
        if (!"webview".equals(this.f15390u)) {
            C11839m.m70689w("MainActivity", "jump type is not webView or browser");
            return;
        }
        C11839m.m70686d("MainActivity", "jump by webView");
        try {
            Intent intent2 = new Intent();
            intent2.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
            C0209d.m1302r2(intent2, "com.huawei.hidisk");
            intent2.putExtra("srcChannel", "0");
            intent2.putExtra("salChannel", "0");
            intent2.putExtra("url", this.f15395v);
            intent2.putExtra("title", getString(com.huawei.hicloud.router.R$string.HiCloud_app_name));
            intent2.putExtra("isEnableJs", true);
            intent2.putExtra("launch_web_type", -1);
            intent2.putExtra("is_support_orientation", true);
            intent2.putExtra("is_support_dark_mode", true);
            startActivity(intent2);
        } catch (Exception e11) {
            C11839m.m70687e("MainActivity", "start safeLink Exception : " + e11.toString());
        }
    }

    /* renamed from: t9 */
    public final void m21483t9() {
        long jM80213E = C13368e.m80184F().m80213E();
        C11839m.m70686d("MainActivity", "familySize:" + jM80213E);
        if (jM80213E > 0) {
            StorageManagerCardLayout storageManagerCardLayout = this.f15412y3;
            if (storageManagerCardLayout != null) {
                storageManagerCardLayout.hideLoading();
                this.f15412y3.hideRedImg();
                this.f15412y3.setArrowText("");
                return;
            }
            return;
        }
        if (this.f15412y3 != null) {
            FamilyShareInfoResult familyShareInfoResult = this.f15219J4;
            if (familyShareInfoResult == null || familyShareInfoResult.getSpaceShareEnable() != 0) {
                this.f15412y3.hideLoading();
                this.f15412y3.hideRedImg();
                this.f15412y3.setArrowText("");
            } else {
                if (this.f15219J4.getSpaceShareOwner() != -1) {
                    this.f15412y3.hideLoading();
                    this.f15412y3.hideRedImg();
                    this.f15412y3.setArrowText(getString(R$string.not_join));
                    this.f15412y3.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
                    return;
                }
                this.f15412y3.hideLoading();
                this.f15412y3.hideRedImg();
                this.f15412y3.setArrowText(getString(R$string.settings_hicloud_disabled));
                this.f15412y3.setSubTitleText(getString(R$string.family_share_cloud_data_only_yourself));
            }
        }
    }

    /* renamed from: ta */
    public final void m21484ta(boolean z10, boolean z11) {
        m21440o8(this.f15333h0);
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar != null) {
            gradientActionBar.m23947i();
        }
        m21188I9(z10, z11);
    }

    /* renamed from: tb */
    public final void m21485tb() {
        if (this.f15334h1 == null || this.f15414z == null) {
            C11839m.m70687e("MainActivity", "showCacheGallerySyncInfo statusController or mContext is null");
            return;
        }
        if (C10155f.m63299w()) {
            String strM1363m = C0212e0.m1363m(this.f15414z, "sp_have_show_cloud_photo", "key_main_page_gallery_status", "");
            String strM1363m2 = C0212e0.m1363m(this.f15414z, "sp_have_show_cloud_photo", "key_main_page_gallery_count", "");
            C11839m.m70686d("MainActivity", "showCacheGallerySyncInfo statusContent " + strM1363m + " picAndViedoStr " + strM1363m2);
            if (TextUtils.isEmpty(strM1363m2)) {
                C11839m.m70687e("MainActivity", "showCacheGallerySyncInfo  picAndViedoStr is null");
                return;
            } else if (TextUtils.isEmpty(strM1363m)) {
                this.f15334h1.m83857i(this, strM1363m2);
            } else {
                this.f15334h1.m83859j(this, strM1363m2, strM1363m);
            }
        }
        m21137C9(this.f15220K);
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: u */
    public void mo7532u() {
        if (this.f15358n1 == null) {
            this.f15358n1 = new AlertDialogC11014a(this, this);
        }
        this.f15358n1.show();
    }

    /* renamed from: u4 */
    public final void m21486u4() {
        ArrayList<MainMenuItem> arrayListM824a = this.f15312c2.m824a();
        if (arrayListM824a == null || arrayListM824a.isEmpty() || arrayListM824a.get(0).getMenuType() == 13) {
            return;
        }
        m21215La(arrayListM824a);
        this.f15312c2.m828e(arrayListM824a);
        this.f15312c2.notifyDataSetChanged();
    }

    /* renamed from: u5 */
    public final void m21487u5() {
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            return;
        }
        RelativeLayout moreHotSpace = gradientActionBar.getMoreHotSpace();
        PopupWindow popupWindow = this.f15297Z1;
        if (popupWindow == null || !popupWindow.isShowing() || moreHotSpace == null) {
            return;
        }
        Boolean boolM80803F0 = C13452e.m80781L().m80803F0();
        boolM80803F0.booleanValue();
        m21265Ra(boolM80803F0, moreHotSpace);
    }

    /* renamed from: u6 */
    public boolean m21488u6(Message message) {
        int i10 = message.what;
        if (i10 == 108) {
            m21445p5(message.obj);
            return true;
        }
        if (i10 == 2024) {
            C11839m.m70688i("MainActivity", "get account userInfo failed");
            m21147Da("CLAM_POP");
            return true;
        }
        if (i10 == 2101) {
            C11839m.m70688i("MainActivity", "get userPackage failed");
            m21147Da("CLAM_POP");
            return true;
        }
        if (i10 == 7011) {
            m21090r5(message.obj);
            return true;
        }
        if (i10 == 7017) {
            C11839m.m70688i("MainActivity", "get recommendActivity failed");
            m21147Da("CLAM_POP");
            return true;
        }
        if (i10 == 7019) {
            C11839m.m70688i("MainActivity", "get userpackage push guide failed");
            m21147Da("PUSH_MARKETING_NOTICE");
            return true;
        }
        if (i10 == 7020) {
            C11839m.m70688i("MainActivity", "get recommend activity push guide failed");
            m21147Da("PUSH_MARKETING_NOTICE");
            return true;
        }
        if (i10 != 31003) {
            if (i10 != 31004) {
                return m21497v6(message);
            }
            C11839m.m70688i("MainActivity", "query push guide failed");
            m21147Da("PUSH_MARKETING_NOTICE");
            return true;
        }
        C11839m.m70688i("MainActivity", "query push guide success");
        Object obj = message.obj;
        if (obj == null || !(obj instanceof QueryPushGuideRsp)) {
            return true;
        }
        m21095tc((QueryPushGuideRsp) obj);
        return true;
    }

    /* renamed from: u7 */
    public final boolean m21489u7() {
        if (C13452e.m80781L().m80887a1()) {
            C11839m.m70689w("MainActivity", "isAddServiceUpdateMenuItem is newBmType.");
            return false;
        }
        if (!C9733f.m60705z().m60720O(m21378g6())) {
            C11839m.m70689w("MainActivity", "isAddServiceUpdateMenuItem switchStatus is not open.");
            return false;
        }
        BmServiceUpdateInfo bmServiceUpdateInfoM60706A = C9733f.m60705z().m60706A(m21378g6());
        if (bmServiceUpdateInfoM60706A != null && bmServiceUpdateInfoM60706A.getUrl() != null) {
            return true;
        }
        C11839m.m70689w("MainActivity", "isAddServiceUpdateMenuItem serviceUpdateInfo is null.");
        return false;
    }

    /* renamed from: u8 */
    public final void m21490u8(int i10) {
        Intent intent = getIntent();
        if (intent != null && new HiCloudSafeIntent(intent).getBooleanExtra("open_extend_function", false)) {
            C11839m.m70688i("MainActivity", "open extend function from setting-storage");
            C10028c.m62182c0().m62272S1(true);
            intent.removeExtra("open_extend_function");
            this.f15253Q3 = true;
        } else {
            this.f15253Q3 = C10028c.m62182c0().m62413x();
        }
        C11839m.m70686d("MainActivity", "onResume itemSwitch:" + this.f15253Q3);
        m21209Kb(this.f15253Q3, i10);
    }

    /* renamed from: u9 */
    public final void m21491u9(boolean z10) {
        if (z10 && C10155f.m63300x()) {
            C1006a.m5936k().m5968o(this.f15384s5);
        }
        boolean zM5975v = C1006a.m5936k().m5975v(this.f15414z);
        C11839m.m70686d("MainActivity", "isGallerySynOn " + zM5975v);
        if (C10155f.m63299w()) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9010;
            messageObtain.obj = Boolean.valueOf(zM5975v);
            this.f15309b5.sendMessage(messageObtain);
        }
    }

    /* renamed from: ua */
    public final void m21492ua() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            C11839m.m70687e("MainActivity", "setActionbarVipRightsInfo mGradientActionbar is null");
            return;
        }
        gradientActionBar.setActionBarTitle(C0209d.m1232a0(C13452e.m80781L().m80841P()));
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C11839m.m70686d("MainActivity", "show vip rights only china region ");
            return;
        }
        boolean zM62413x = C10028c.m62182c0().m62413x();
        this.f15253Q3 = zM62413x;
        if (!zM62413x) {
            C11839m.m70686d("MainActivity", "setActionbarVipRightsInfo extendFuncSwitch is closed");
            return;
        }
        int iM1357g = C0212e0.m1357g(this, "sp_vip_rights_info", "key_vip_expired_days", 0);
        int iM1357g2 = C0212e0.m1357g(this, "sp_vip_rights_info", "key_vip_rights_num", 0);
        String strM1363m = C0212e0.m1363m(this, "sp_vip_rights_info", "key_vip_grade_code", "");
        C11839m.m70686d("MainActivity", "setActionbarVipRightsInfo expiredDays " + iM1357g + " ,vipRightsNum " + iM1357g2 + " ,vipGradeCode " + strM1363m);
        if (TextUtils.isEmpty(strM1363m) || iM1357g2 == 0) {
            C11839m.m70686d("MainActivity", "no vip rights cache info");
        } else {
            this.f15335h4 = strM1363m;
            if (iM1357g != 0) {
                C11839m.m70686d("MainActivity", "expired vip user");
            } else {
                m21435nb();
                this.f15329g0.setVipIconLayoutShowStatus(0);
                this.f15329g0.m23958t(iM1357g2);
                this.f15329g0.m23956r(false, this.f15223K3);
            }
        }
        C11839m.m70686d("MainActivity", "setActionbarVipRightsInfo take times " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    /* renamed from: ub */
    public final void m21493ub() {
        CampaignEntryFloatView campaignEntryFloatView = this.f15184C4;
        if (campaignEntryFloatView == null || campaignEntryFloatView.getVisibility() == 0) {
            return;
        }
        this.f15184C4.m25679f();
        this.f15184C4.setVisibility(0);
        this.f15184C4.m25685l();
    }

    /* renamed from: uc */
    public final void m21494uc(String str) {
        AlertDialogC13154a alertDialogC13154a = (AlertDialogC13154a) this.f15292Y1.m65756c(str);
        this.f15291Y0 = alertDialogC13154a;
        if (alertDialogC13154a == null) {
            C11839m.m70688i("MainActivity", "backupOptionAlertDialog is null");
        } else {
            if (!C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
                C11839m.m70688i("MainActivity", "backupOptionAlertDialog activity is foreground");
                return;
            }
            C11839m.m70688i("MainActivity", "show backupOptionAlertDialog");
            this.f15291Y0.show();
            this.f15292Y1.m65762i(str);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("MainActivity", "KEYCODE_BACK click too fast");
            return true;
        }
        if (!this.f15203G3) {
            m21467rb();
            return true;
        }
        C11839m.m70689w("MainActivity", "onKeyBackPressed, jumpToCampaign");
        m21503w4();
        return true;
    }

    /* renamed from: v4 */
    public final void m21495v4(String str, UrgencyGoto urgencyGoto, String str2) {
        boolean z10 = false;
        for (UrgencyOnTopParams urgencyOnTopParams : this.f15277V1) {
            C11839m.m70687e("aaa", "page not show111");
            z10 = !str.equals(urgencyOnTopParams.getUrgencID());
        }
        if (z10) {
            UrgencyOnTopParams urgencyOnTopParams2 = new UrgencyOnTopParams();
            urgencyOnTopParams2.setUrgencID(str);
            m21439o7(urgencyOnTopParams2, urgencyGoto, str2);
            this.f15277V1.add(urgencyOnTopParams2);
            m21428mb();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0057  */
    /* renamed from: v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m21496v5() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "dealSyncRiskConfirmBack"
            java.lang.String r2 = "MainActivity"
            p514o9.C11839m.m70688i(r2, r1)
            android.content.Intent r1 = r6.getIntent()
            if (r1 != 0) goto L10
            return
        L10:
            r3 = 0
            java.lang.String r4 = "risk_jump_type_key"
            int r3 = r1.getIntExtra(r4, r3)     // Catch: java.lang.Exception -> L3a
            java.lang.String r4 = "risk_sync_type_key"
            java.lang.String r1 = r1.getStringExtra(r4)     // Catch: java.lang.Exception -> L3a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3b
            r4.<init>()     // Catch: java.lang.Exception -> L3b
            java.lang.String r5 = "SyncRisk jumpType:"
            r4.append(r5)     // Catch: java.lang.Exception -> L3b
            r4.append(r3)     // Catch: java.lang.Exception -> L3b
            java.lang.String r5 = ", syncType:"
            r4.append(r5)     // Catch: java.lang.Exception -> L3b
            r4.append(r1)     // Catch: java.lang.Exception -> L3b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L3b
            p514o9.C11839m.m70688i(r2, r4)     // Catch: java.lang.Exception -> L3b
            goto L40
        L3a:
            r1 = r0
        L3b:
            java.lang.String r4 = "getIntent error"
            p514o9.C11839m.m70687e(r2, r4)
        L40:
            r2 = 2
            r4 = 4
            if (r3 != r2) goto L57
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L4d
            r6.m21347c9(r1, r4)
        L4d:
            ap.c r1 = p020ap.C1008c.m6035v()
            android.app.Activity r6 = r6.f15414z
            r1.m6087m0(r6, r4, r0)
            goto L63
        L57:
            r1 = 1
            if (r3 != r1) goto L63
            ap.c r1 = p020ap.C1008c.m6035v()
            android.app.Activity r6 = r6.f15414z
            r1.m6087m0(r6, r4, r0)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.MainActivity.m21496v5():void");
    }

    /* renamed from: v6 */
    public final boolean m21497v6(Message message) {
        int i10 = message.what;
        if (i10 != 7038) {
            if (i10 != 7039) {
                return false;
            }
            C11839m.m70688i("MainActivity", "get user pkg grade fail");
            m21183Hb();
            return true;
        }
        C11839m.m70688i("MainActivity", "get user pkg grade success");
        m21210L4();
        m21214L9(message);
        m21204K6();
        m21427m9();
        m21152E6();
        this.f15186D0.m24260M();
        ExpirationReminderCardView expirationReminderCardView = this.f15175B;
        if (expirationReminderCardView == null) {
            return true;
        }
        expirationReminderCardView.m25762k();
        return true;
    }

    /* renamed from: v8 */
    public final void m21498v8() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 7);
        intent.putExtras(bundle);
        intent.setClass(this, CloudSpaceShareActivity.class);
        startActivityForResult(intent, 10029);
    }

    /* renamed from: v9 */
    public final void m21499v9() {
        C11839m.m70688i("MainActivity", "enter refreshIconItem");
        if (this.f15312c2 == null) {
            C11839m.m70688i("MainActivity", "mainMenuAdapter is null");
            return;
        }
        if (C0209d.m1269j1()) {
            this.f15229L4.m16461u(new IconManager.IconCallBack() { // from class: com.huawei.android.hicloud.ui.activity.o6
                @Override // com.huawei.android.hicloud.manager.IconManager.IconCallBack
                /* renamed from: a */
                public final void mo16467a(boolean z10) {
                    this.f17692a.m21325Z7(z10);
                }
            });
        } else if (this.f15229L4.m16463w(getPackageName())) {
            C11839m.m70688i("MainActivity", "app icon is exist");
        } else {
            m21486u4();
        }
    }

    /* renamed from: va */
    public final void m21500va(ArrayList<MainMenuItem> arrayList) {
        MainMenuItem mainMenuItem = new MainMenuItem(getString(R$string.add_to_desktop_title), 1);
        if (C1443a.f6215c.booleanValue()) {
            arrayList.add(mainMenuItem);
        }
    }

    /* renamed from: vb */
    public final void m21501vb(PayActivityInfo payActivityInfo) {
        if (payActivityInfo != null) {
            C11839m.m70688i("MainActivity", "ClaimSpacePopDialog is to be popuped");
            ClaimSpacePopDialog claimSpacePopDialog = new ClaimSpacePopDialog(this, payActivityInfo, this.f15292Y1);
            this.f15256R0 = claimSpacePopDialog;
            this.f15292Y1.m65765l("CLAM_POP", claimSpacePopDialog);
            this.f15292Y1.m65754a("CLAM_POP");
        } else {
            SpaceNoticeCommonSpUtil.getInstance().setSupport(false);
            if (!this.f15387t1) {
                m21147Da("CLAM_POP");
            }
        }
        this.f15387t1 = false;
    }

    /* renamed from: vc */
    public final void m21502vc(String str) {
        if (SpaceNoticeCommonSpUtil.getInstance().isShownAlready() || this.f15256R0 == null) {
            return;
        }
        if (C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
            C11839m.m70688i("MainActivity", "claimdialog,activity is foreground");
            this.f15256R0.show();
            this.f15256R0.dialogShowReport();
            this.f15292Y1.m65762i(str);
        } else {
            this.f15382s1 = true;
            this.f15292Y1.m65757d(str).m65769d(-1);
        }
        this.f15377r1 = false;
    }

    /* renamed from: w4 */
    public final void m21503w4() {
        String strM82922f = C13823d.m82904y().m82922f(this);
        Intent intent = new Intent(this, (Class<?>) CampaignActivity.class);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setFlags(67239936);
        intent.putExtra("channels", 9);
        intent.putExtra("taskActivityId", strM82922f);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("is_activity_need_back_to_main", true);
        intent.putExtra("entrance_from", 9);
        intent.putExtra("campaign_need_show_toast", true);
        AdParametersExt adParametersExtM63035a = C10121i.m63035a();
        if (adParametersExtM63035a != null) {
            intent.putExtra("agd_resource_enable", adParametersExtM63035a.getEnabled());
            intent.putExtra("agd_resource_slot_id", adParametersExtM63035a.getAgdAdid());
            intent.putExtra("pps_threshold", adParametersExtM63035a.getThreshold());
        }
        startActivity(intent);
    }

    /* renamed from: w5 */
    public final void m21504w5(GetUserRegisterResp getUserRegisterResp) {
        C11839m.m70688i("MainActivity", "dealUserStatus");
        m21195J6();
        if (getUserRegisterResp == null) {
            C11839m.m70687e("MainActivity", "dealUserStatus registerData is null!");
            return;
        }
        if (getUserRegisterResp.isActivated().booleanValue()) {
            C11839m.m70688i("MainActivity", "dealUserStatus isNotInActive");
            m21454q4();
            return;
        }
        final HashMap<String, String> mapM57566e = C9159b.m57566e(getUserRegisterResp);
        if (mapM57566e == null) {
            C11839m.m70689w("MainActivity", "inactiveData is null");
            return;
        }
        this.f15289X4 = mapM57566e;
        this.f15329g0.setInactiveTVVisible(true);
        this.f15329g0.setOnInActiveTVClick(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.c6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16493a.m21240O7(mapM57566e, view);
            }
        });
        m21171G7(JumpInactivePageStatus.DATA_READY);
    }

    /* renamed from: w6 */
    public final void m21505w6(Message message) {
        C11839m.m70686d("MainActivity", "notepad history message type is " + message.arg1);
        C10028c c10028cM62183d0 = C10028c.m62183d0(this.f15414z);
        this.f15240O.setHideLoading(true);
        int i10 = message.arg1;
        if (i10 == -10 || i10 == -5) {
            C11839m.m70688i("MainActivity", "notepad history no data or service unavaliable");
            boolean zM62388s = c10028cM62183d0.m62388s("notepad");
            c10028cM62183d0.m62336h2("notepad_has_history_data", false);
            this.f15362o1 = false;
            this.f15240O.setCheckedProgrammatically(zM62388s);
            this.f15240O.setShowSwitchLayout(true);
            this.f15240O.setOnClick(false);
        } else if (i10 == 0) {
            C11839m.m70688i("MainActivity", "notepad history query success");
            c10028cM62183d0.m62336h2("notepad_has_history_data", true);
            this.f15362o1 = true;
            this.f15240O.setShowStatusLayout(true);
            this.f15240O.setOnClick(true);
            if (c10028cM62183d0.m62388s("notepad")) {
                this.f15240O.setStatusText(getString(R$string.settings_hicloud_open));
            } else {
                this.f15240O.setStatusText(getString(R$string.sync_switch_button_close));
            }
        }
        m21137C9(this.f15240O);
    }

    /* renamed from: w7 */
    public final boolean m21506w7() {
        try {
            return new SafeIntent(getIntent()).getIntExtra(NotifyConstants.NOTIFY_ID_KEY, -1) == 278;
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "initNavSource error, e = " + e10.toString());
            return false;
        }
    }

    /* renamed from: w8 */
    public final void m21507w8() {
        try {
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            if (safeIntent.getBooleanExtra("is_specific_h5_pay_return", false)) {
                C11839m.m70687e("MainActivity", "start pay result success: ");
                intent.removeExtra("is_specific_h5_pay_return");
                SafeIntent safeIntent2 = new SafeIntent(new Intent(this, (Class<?>) GuideWebViewActivity.class));
                Uri.Builder builderBuildUpon = Uri.parse(safeIntent.getStringExtra("payResultUrl")).buildUpon();
                builderBuildUpon.appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1632j());
                String string = builderBuildUpon.toString();
                C11839m.m70686d("MainActivity", "parseIntentGiftPackage: " + string);
                safeIntent2.putExtra("url", string);
                safeIntent2.putExtra("srcChannel", safeIntent.getStringExtra("srcChannel"));
                safeIntent2.putExtra("salChannel", safeIntent.getStringExtra("salChannel"));
                safeIntent2.putExtra("activityCode", safeIntent.getStringExtra("activityCode"));
                safeIntent2.putExtra("isEnableJs", true);
                safeIntent2.putExtra("main_dialog_id", "GET_SPACE_H5_PAY_RESULT_DIALOG");
                startActivity(safeIntent2);
            }
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "parseIntentGiftPackage error: " + e10.getMessage());
        }
    }

    /* renamed from: w9 */
    public final void m21508w9() {
        if (this.f15405x0 == null || this.f15176B0 == null) {
            C11839m.m70687e("MainActivity", "recommend view is null");
        } else {
            this.f15210I = RecommendCardManager.getInstance().getRecommendCardsFromCache(RecommendCardConstants.Entrance.HOMEPAGE);
            m21334ab();
        }
    }

    /* renamed from: wa */
    public final void m21509wa() {
        this.f15225L.setCheckedProgrammatically(false);
        this.f15235N.setCheckedProgrammatically(false);
        this.f15230M.setCheckedProgrammatically(false);
        this.f15239N4.put(this.f15225L.getId(), this.f15225L);
        this.f15239N4.put(this.f15235N.getId(), this.f15235N);
        this.f15239N4.put(this.f15230M.getId(), this.f15230M);
        m21366eb();
    }

    /* renamed from: wb */
    public final boolean m21510wb() {
        if (C13452e.m80781L().m80791C0()) {
            return false;
        }
        boolean zM62413x = C10028c.m62182c0().m62413x();
        return C13452e.m80781L().m80858T0() ? zM62413x : ModuleConfigUtil.getInstance().isGeneralVersion() && C10155f.m63248A() && C0209d.m1190M0(this, C13843a.m83099u()) && zM62413x;
    }

    /* renamed from: wc */
    public final void m21511wc(String str) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            Uri.Builder builderBuildUpon = Uri.parse(this.f15224K4).buildUpon();
            builderBuildUpon.appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1632j());
            String string = builderBuildUpon.toString();
            C11839m.m70686d("MainActivity", "toShowGetSpaceOkH5Dialog: " + string);
            intent.putExtra("url", string);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("main_dialog_id", str);
            GuideWebViewActivity.m20586z2(this.f15292Y1);
            CloudSpaceUpgradeActivity.m23269K8(this.f15292Y1);
            startActivity(intent);
            C9437n.m59190e().m59201n(false);
            this.f15292Y1.m65762i(str);
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "toShowGetSpaceOkH5Dialog error: " + e10.getMessage());
        }
    }

    /* renamed from: x4 */
    public void m21512x4() {
        C11839m.m70688i("MainActivity", "backgroundTask start");
        m21154E8();
        C2783d.m16164n1(this.f15414z);
        HiCloudAllOMConfigManager.getInstance().queryConfigAsync("HiCloudFooterLink");
        HiCloudAllOMConfigManager.getInstance().queryConfigAsync("HiCloudOperPageHints");
        if (C0209d.m1333z1(this)) {
            C11839m.m70688i("MainActivity", "need update HiCloudNoticeConfigAllInOne");
            HiCloudAllOMConfigManager.getInstance().queryConfigAsync("HiCloudNoticeConfigAllInOne");
        } else {
            C11839m.m70688i("MainActivity", "netWorkConnected is false");
        }
        m21247P8(getIntent());
        if ((!C10028c.m62182c0().m62226I1() && !C10028c.m62182c0().m62320e1()) || C0209d.m1269j1()) {
            m21330a5();
        }
        C10718a c10718a = this.f15182C1;
        if (c10718a != null) {
            c10718a.m65429D(this.f15304a5);
            this.f15182C1.m65432m("main");
        }
        m21303W9();
        m21141D4();
        C11839m.m70688i("MainActivity", "backgroundTask end");
    }

    /* renamed from: x5 */
    public final void m21513x5(String str, String str2, int i10) {
        m21397ib(str, i10);
        str.hashCode();
        switch (str) {
            case "addressbook":
                C1008c.m6035v().m6095q0(this, str, 102, 2012, str2);
                break;
            case "calendar":
                C1008c.m6035v().m6093p0(this, str, 102, 2012, str2);
                break;
            case "wlan":
                C1008c.m6035v().m6104v0(this, str, 102, 2012, str2);
                break;
            case "browser":
                C1008c.m6035v().m6091o0(this, str, 102, 2012, str2);
                break;
            case "notepad":
                C1008c.m6035v().m6101t0(this, str, 102, 2012, str2);
                break;
        }
    }

    /* renamed from: x6 */
    public final void m21514x6(Message message) {
        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
        if (zBooleanValue != this.f15258R3) {
            this.f15258R3 = zBooleanValue;
            m21180H8();
        }
    }

    /* renamed from: x7 */
    public final boolean m21515x7() {
        try {
            if (new SafeIntent(getIntent()).getIntExtra(NotifyConstants.NOTIFY_ID_KEY, -1) != 777) {
                return false;
            }
            C10158i.m63321e("0");
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("MainActivity", "initNavSource error, e = " + e10.toString());
            return false;
        }
    }

    /* renamed from: x8 */
    public void m21516x8() {
        if ("1".equals(this.f16166i) || "4".equals(this.f16166i)) {
            this.f15404x = "1";
        }
        C11839m.m70688i("MainActivity", "parseManulScene: " + this.f15404x);
    }

    /* renamed from: x9 */
    public final void m21517x9(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A;
        linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        str.hashCode();
        switch (str) {
            case "cloud_disk_recording":
                List<String> listM69903b = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_recording"));
                if (listM69903b != null && listM69903b.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close CLOUD_DISK_RECORDING automatically");
                    m21377g5("autorecordingkey");
                }
                C2783d.m16090J0("main_permission_close_recording_upload", linkedHashMapM79497A);
                break;
            case "sync_ablum":
                List<String> listM69903b2 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_ablum"));
                if (listM69903b2 != null && listM69903b2.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close ablum automatically");
                    InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                    if (interfaceC9282a != null) {
                        interfaceC9282a.mo58407Z0(this, 12);
                    }
                    m21199Ja(this.f15220K, false);
                }
                C2783d.m16090J0("main_permission_close_gallery", linkedHashMapM79497A);
                break;
            case "backup":
                List<String> listM69903b3 = this.f22163b.m69903b(this, this.f22163b.m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP));
                if (listM69903b3 != null && listM69903b3.size() > 0) {
                    CloudBackupService.getInstance().cloudbackupOpr(false);
                }
                C2783d.m16090J0("main_permission_close_backup", linkedHashMapM79497A);
                break;
            case "cloud_disk_sms":
                List<String> listM69903b4 = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_sms"));
                if (listM69903b4 != null && listM69903b4.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close CLOUD_DISK_SMS automatically");
                    m21377g5("autosmslistkey");
                }
                C2783d.m16090J0("main_permission_close_sms_upload", linkedHashMapM79497A);
                break;
            case "sync_contact":
                List<String> listM69903b5 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_contact"));
                if (listM69903b5 != null && listM69903b5.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close contact automatically");
                    this.f15225L.setCheckedProgrammatically(false);
                    m21223M8(false, "addressbook", 2);
                }
                m21137C9(this.f15225L);
                C2783d.m16090J0("main_permission_close_contact", linkedHashMapM79497A);
                break;
            case "cloud_disk_calllog":
                List<String> listM69903b6 = this.f22163b.m69903b(this, this.f22163b.m69911k("cloud_disk_calllog"));
                if (listM69903b6 != null && listM69903b6.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close CLOUD_DISK_CALLLOG automatically");
                    m21377g5("autocallloglistkey");
                }
                C2783d.m16090J0("main_permission_close_calllog_upload", linkedHashMapM79497A);
                break;
            case "sync_calendar":
                List<String> listM69903b7 = this.f22163b.m69903b(this, this.f22163b.m69911k("sync_calendar"));
                SyncItemInfo syncItemInfoM21337b6 = m21337b6("calendar", this.f15235N);
                if (syncItemInfoM21337b6 == null) {
                    SyncItemInfo syncItemInfo = new SyncItemInfo(getString(R$string.calendar_sync_item));
                    this.f15235N = syncItemInfo;
                    syncItemInfo.setShowSwitch(true);
                    this.f15235N.setId("calendar");
                } else {
                    this.f15235N.setShowSwitch(true);
                    this.f15235N = syncItemInfoM21337b6;
                }
                if (listM69903b7 != null && listM69903b7.size() > 0) {
                    C11839m.m70688i("MainActivity", "no permission close calendar automatically");
                    this.f15235N.setCheckedProgrammatically(false);
                    m21223M8(false, "calendar", 2);
                }
                m21137C9(this.f15235N);
                C2783d.m16090J0("main_permission_close_calendar", linkedHashMapM79497A);
                break;
        }
    }

    /* renamed from: xa */
    public final void m21518xa() {
        BackupDeviceView backupDeviceView = this.f15170A;
        if (backupDeviceView != null) {
            backupDeviceView.setBackFromDeviceManager(true);
        }
        NewBmBackupItemView newBmBackupItemView = this.f15185D;
        if (newBmBackupItemView != null) {
            newBmBackupItemView.setBackFromDeviceManager(true);
        }
    }

    /* renamed from: xb */
    public final void m21519xb(boolean z10) {
        int[] iArrM16247b = Constant.C2794f.m16247b();
        HiCloudItemView hiCloudItemView = null;
        for (int i10 = 0; i10 < iArrM16247b.length; i10++) {
            HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76829b(this, iArrM16247b[i10]);
            if (i10 == iArrM16247b.length - 1) {
                if (hiCloudItemView2 != null && hiCloudItemView2.getVisibility() == 0) {
                    hiCloudItemView2.m23973d();
                }
            } else if (hiCloudItemView2 != null && hiCloudItemView2.getVisibility() == 0) {
                hiCloudItemView2.m23964D();
                hiCloudItemView = hiCloudItemView2;
            }
        }
        if (hiCloudItemView == null || z10) {
            return;
        }
        hiCloudItemView.m23973d();
    }

    /* renamed from: xc */
    public final void m21520xc(String str) {
        if (this.f15292Y1.m65758e()) {
            C11839m.m70688i("MainActivity", "h5 dialog is showing");
            return;
        }
        Dialog dialogM65756c = this.f15292Y1.m65756c(str);
        this.f15286X0 = dialogM65756c;
        if (dialogM65756c == null) {
            C11839m.m70688i("MainActivity", "guideBackupSwitchDialog is null");
            return;
        }
        if (!C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
            C11839m.m70688i("MainActivity", "guideBackupSwitchDialog activity is foreground");
            return;
        }
        C11839m.m70688i("MainActivity", "show guideBackupSwitchDialog");
        this.f15286X0.show();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0212e0.m1370t(this, "switch_suggest_dialog_sp", "guide_backup_switch_notify_time", jCurrentTimeMillis);
        C11839m.m70686d("MainActivity", "guideBackupSwitchDialog currentTimeMillis:" + jCurrentTimeMillis);
        this.f15292Y1.m65762i(str);
        C13148e.m79053b(this.f15414z);
    }

    /* renamed from: y5 */
    public final void m21521y5(String str) {
        this.f15296Z0.setMessage(getString(R$string.exit_account_removing));
        this.f15296Z0.setCancelable(false);
        this.f15296Z0.show();
        if (C13612b.m81829B().m81855T()) {
            return;
        }
        C1008c.m6035v().m6092p(this.f15414z, this.f15304a5, C9062b.m57146k().m57157j(), str);
        C13612b.m81829B().m81881q0(true);
        C11839m.m70688i("MainActivity", "processExit flag is: true");
    }

    /* renamed from: y6 */
    public final void m21522y6(Message message) {
        C11839m.m70688i("MainActivity", "Handle message, id = " + message.what + "mIsToolFinish =" + this.f15343j4);
        if (isFinishing() || isDestroyed()) {
            C11839m.m70688i("MainActivity", "MainActivity is destroyed, not handle message");
            return;
        }
        int i10 = message.what;
        if (i10 == 102) {
            if (this.f15343j4 || !C0209d.m1333z1(this)) {
                return;
            }
            this.f15347k4 = true;
            m21297Vb();
            return;
        }
        if (i10 == 100) {
            m21234Na(getString(R$string.getting_file));
            return;
        }
        if (i10 == 101) {
            if (this.f15343j4) {
                return;
            }
            m21234Na(getString(R$string.loading_tips_net_slow));
        } else if (i10 == 103) {
            m21404ja();
        }
    }

    /* renamed from: y7 */
    public final boolean m21523y7() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f15199F4 < 10000) {
            return true;
        }
        this.f15199F4 = jCurrentTimeMillis;
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0079 A[Catch: Exception -> 0x007c, TRY_LEAVE, TryCatch #0 {Exception -> 0x007c, blocks: (B:49:0x000a, B:51:0x0010, B:52:0x0018, B:59:0x0032, B:81:0x006c, B:82:0x0071, B:83:0x0076, B:84:0x0079, B:62:0x003a, B:65:0x0044, B:68:0x004c, B:71:0x0056), top: B:89:0x000a }] */
    /* renamed from: y8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m21524y8() {
        /*
            r10 = this;
            java.lang.String r0 = "channel_of_open_switch"
            android.content.Intent r1 = r10.getIntent()
            java.lang.String r2 = "MainActivity"
            if (r1 == 0) goto L81
            boolean r3 = r1.hasExtra(r0)     // Catch: java.lang.Exception -> L7c
            if (r3 == 0) goto L18
            java.lang.String r0 = r1.getStringExtra(r0)     // Catch: java.lang.Exception -> L7c
            r10.f15400w = r0     // Catch: java.lang.Exception -> L7c
            goto L81
        L18:
            java.lang.String r0 = r10.f16166i     // Catch: java.lang.Exception -> L7c
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L7c
            r3 = 49
            r4 = 4
            java.lang.String r5 = "3"
            r6 = 1
            r7 = 2
            java.lang.String r8 = "5"
            r9 = 3
            if (r1 == r3) goto L56
            r3 = 57
            if (r1 == r3) goto L4c
            switch(r1) {
                case 51: goto L44;
                case 52: goto L3a;
                case 53: goto L32;
                default: goto L31;
            }
        L31:
            goto L60
        L32:
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L60
            r0 = r7
            goto L61
        L3a:
            java.lang.String r1 = "4"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L60
            r0 = r6
            goto L61
        L44:
            boolean r0 = r0.equals(r5)     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L60
            r0 = r4
            goto L61
        L4c:
            java.lang.String r1 = "9"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L60
            r0 = r9
            goto L61
        L56:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L60
            r0 = 0
            goto L61
        L60:
            r0 = -1
        L61:
            if (r0 == 0) goto L79
            if (r0 == r6) goto L79
            if (r0 == r7) goto L76
            if (r0 == r9) goto L71
            if (r0 == r4) goto L6c
            goto L81
        L6c:
            java.lang.String r0 = "7"
            r10.f15400w = r0     // Catch: java.lang.Exception -> L7c
            goto L81
        L71:
            java.lang.String r0 = "11"
            r10.f15400w = r0     // Catch: java.lang.Exception -> L7c
            goto L81
        L76:
            r10.f15400w = r8     // Catch: java.lang.Exception -> L7c
            goto L81
        L79:
            r10.f15400w = r5     // Catch: java.lang.Exception -> L7c
            goto L81
        L7c:
            java.lang.String r0 = "parseOpenSwitchChannel get extra error"
            p514o9.C11839m.m70687e(r2, r0)
        L81:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "parseOpenSwitchChannel channel: "
            r0.append(r1)
            java.lang.String r10 = r10.f15400w
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            p514o9.C11839m.m70686d(r2, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.MainActivity.m21524y8():void");
    }

    /* renamed from: y9 */
    public final void m21525y9() {
        C11839m.m70686d("MainActivity", "refreshSpaceText");
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L != null) {
            m21318Y8(quotaSpaceInfoM80223L.getAvailable());
        } else {
            m21147Da("SPACE_FULL");
        }
    }

    /* renamed from: ya */
    public final void m21526ya(int i10) {
        C11839m.m70688i("MainActivity", "setBackupItemVisibility: " + i10 + " ,newBmType: " + C13452e.m80781L().m80887a1());
        BackupDeviceView backupDeviceView = this.f15170A;
        if (backupDeviceView != null) {
            backupDeviceView.setVisibility(8);
        }
        NewBmBackupItemView newBmBackupItemView = this.f15185D;
        if (newBmBackupItemView != null) {
            newBmBackupItemView.setVisibility(i10);
        }
        m21150E4();
    }

    /* renamed from: yb */
    public final void m21527yb() {
        GradientActionBar gradientActionBar = this.f15329g0;
        if (gradientActionBar == null) {
            C11839m.m70687e("MainActivity", "setMoreIconVisibility, mGradientActionbar is null");
            return;
        }
        gradientActionBar.setSnSInfoViewVisible(false);
        this.f15329g0.setMoreIconVisibility(false);
        this.f15329g0.m23957s();
        this.f15190E.setVisibility(8);
    }

    /* renamed from: yc */
    public final void m21528yc(String str) {
        boolean z10 = C2783d.m16159m() != 1;
        if (!C0209d.m1245d1(this.f15414z, MainActivity.class.getName()) || !z10) {
            MessageCenterReportUtil.reportH5WindowShowResult("not foreground");
            C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog, activity is not foreground");
            return;
        }
        C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog,activity is foreground");
        Object obj = this.f15319d5;
        if (obj == null || !(obj instanceof Bundle)) {
            C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog  !(object instanceof Bundle)");
            MessageCenterReportUtil.reportH5WindowShowResult("guideH5Object null");
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i10 = bundle.getInt("queryh5oknum");
        C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog  queryH5OkNum: " + i10);
        if (TextUtils.isEmpty(bundle.getString("h5Uri")) || i10 == -1) {
            C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog  h5Url == null:  true");
            MessageCenterReportUtil.reportH5WindowShowResult("h5Url null");
            return;
        }
        String string = bundle.getString(ContentRecord.UNIQUE_ID);
        String strIsH5AlreadyRead = MessageCenterManager.getInstance().isH5AlreadyRead(string);
        C11839m.m70688i("MainActivity", "QueryGuideH5Task uniqueId = " + string + ", alreadyRead = " + strIsH5AlreadyRead);
        if ("1".equals(strIsH5AlreadyRead)) {
            C11839m.m70689w("MainActivity", "QueryGuideH5Task h5 is Already read, SHOW_h5_FAIL");
            MessageCenterReportUtil.reportH5WindowShowResult("Already read");
            m21147Da("GUIDE_H5_WEBVIEW_DAILOG");
        } else {
            String string2 = bundle.getString("resourceInfo");
            MessageCenterManager.getInstance().setMsgAsRead(string);
            MessageCenterManager.getInstance().cancelMarketingMsgNotificationByAction(i10);
            MessageCenterReportUtil.reportH5WindowShow(string, string2, i10);
            C11839m.m70688i("MainActivity", "QueryGuideH5Task toShowGuideH5Dialog  frequencyChecker.checkGuiH5Dialog: true");
            m21217Lc(str, bundle);
        }
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: z */
    public void mo7533z() {
        if (this.f15354m1 == null) {
            this.f15354m1 = new AlertDialogC11015b(this, this);
        }
        C11839m.m70688i("MainActivity", "showDisagreeDialog");
        this.f15354m1.show();
    }

    /* renamed from: z6 */
    public final void m21529z6() {
        if (this.f15368p4 != null) {
            C11839m.m70688i("MainActivity", "showAlbumShareProgressBar GONE");
            this.f15368p4.setVisibility(8);
        }
    }

    /* renamed from: z7 */
    public final boolean m21530z7() {
        Dialog dialog;
        Dialog dialog2;
        AlertDialog alertDialog;
        ClaimSpacePopDialog claimSpacePopDialog = this.f15256R0;
        if ((claimSpacePopDialog == null || !claimSpacePopDialog.isShowing()) && (((dialog = this.f15281W0) == null || !dialog.isShowing()) && (((dialog2 = this.f15266T0) == null || !dialog2.isShowing()) && (((alertDialog = this.f15261S0) == null || !alertDialog.isShowing()) && !this.f15229L4.m16459s())))) {
            return false;
        }
        C11839m.m70688i("MainActivity", "has other dialog is showing");
        return true;
    }

    /* renamed from: z8 */
    public void m21531z8() {
        if ("9".equals(this.f16166i)) {
            this.f15409y = "4";
        } else {
            this.f15409y = "2";
        }
        C11839m.m70688i("MainActivity", "parseRestoreEntrance: " + this.f15409y);
    }

    /* renamed from: z9 */
    public final void m21532z9(boolean z10) {
        RelativeLayout relativeLayout;
        if (z10 || (relativeLayout = this.f15196F0) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    /* renamed from: za */
    public final void m21533za() throws Resources.NotFoundException {
        C11839m.m70688i("MainActivity", "setBottomBlank");
        if (this.f15173A3 == 1) {
            C11839m.m70688i("MainActivity", "tabSize == 1 no bottom margin");
            return;
        }
        Resources resources = getResources();
        if (resources != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.hwbottomnavigationview_item_land_minheight);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.hwbottomnavigationview_item_port_minheight);
            if (!this.f15417z3) {
                dimensionPixelSize = 0;
            } else if (!C11842p.m70753O0(this)) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (this.f15290Y == null || this.f15298Z3 == null) {
                C11839m.m70688i("MainActivity", "mainRegion or mMainView is null");
                return;
            }
            C11839m.m70688i("MainActivity", "bottomTabHeight =" + dimensionPixelSize);
            C11842p.m70724E1(this.f15290Y, dimensionPixelSize);
            C11842p.m70724E1(this.f15298Z3, dimensionPixelSize);
        }
    }

    /* renamed from: zc */
    public final void m21534zc(String str) {
        Dialog dialogM65756c = this.f15292Y1.m65756c(str);
        this.f15266T0 = dialogM65756c;
        if (dialogM65756c != null) {
            if (C0209d.m1245d1(this.f15414z, MainActivity.class.getName())) {
                C11839m.m70688i("MainActivity", "policy dialog,activity is foreground");
                this.f15266T0.show();
            } else {
                this.f15392u1 = true;
            }
            this.f15377r1 = false;
            this.f15382s1 = false;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        this.f15346k1 = true;
        m21304Wa(str, false);
        m21117A8(str, str2, i10);
        C2783d.m16114V0(str, "1", "1", i10);
        m21184Hc("");
    }
}
