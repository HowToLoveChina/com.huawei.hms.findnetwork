package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import be.C1173i;
import ca.C1398a;
import ca.C1399b;
import com.google.gson.Gson;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.common.task.ClickExchangeTask;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.GradePackageCardView;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.ScrollUpUrgencyView;
import com.huawei.android.hicloud.p088ui.extend.TextBannerSwitcher;
import com.huawei.android.hicloud.p088ui.extend.UrgencyScrollUpView;
import com.huawei.android.hicloud.p088ui.fragment.BannerFragment;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.CurrentRightAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.PartMemRightShowAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.ConfirmBuyPackageDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.MemberQuitFamilyShareDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.HicloudPushGuideDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.UnspportPrivateSpaceDialog;
import com.huawei.android.hicloud.p088ui.uilistener.BannerShowRegionListener;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.p088ui.views.WrapContentHeightViewPager;
import com.huawei.android.hicloud.task.simple.C3010a0;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.hicloud.task.simple.C3032f2;
import com.huawei.android.hicloud.task.simple.GetUserAvatarTask;
import com.huawei.android.p073ds.R$anim;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$menu;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.AcceptSignGiftInfo;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CampaignInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetGradeRightDetailResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.GetRecommendActivityResp;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.cloud.pay.model.MemGradeRightDetail;
import com.huawei.cloud.pay.model.MemGradeRightDetails;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.PackageGrade;
import com.huawei.cloud.pay.model.PackageGradeRight;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PayActivityInfo;
import com.huawei.cloud.pay.model.PurchaseNeedData;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Response;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardBaseResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDiamondResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardGoldResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardSilverResourceBean;
import com.huawei.cloud.pay.p098ui.uiextend.HwAnimationReflection;
import com.huawei.cloud.pay.p098ui.uiextend.view.AutoRenewRuleDialog;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollView4List;
import com.huawei.hicloud.base.view.widget.TextOnClickTextView;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.NewBusinessModelConfigBean;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.HicloudPushGuideManager;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuidPopConfig;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.UrgencyGoto;
import com.huawei.hicloud.notification.p106db.bean.UrgencyOnTopParams;
import com.huawei.hicloud.notification.p106db.bean.UrgencyTop;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.ConsentRecord;
import com.huawei.hicloud.request.agreement.request.ConsentRecordWithStatus;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import dj.C9158a;
import dk.EnumC9164e;
import fj.C9713b;
import gp.C10028c;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import je.C10804r;
import je.C10809w;
import mc.C11436a;
import org.json.JSONException;
import org.json.JSONObject;
import p010a9.C0079a;
import p014aj.C0202a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0223k;
import p015ak.C0225l;
import p015ak.C0234s;
import p037bp.C1270a;
import p054cj.C1442a;
import p222da.C9060d;
import p232dp.InterfaceC9282a;
import p252e9.C9433j;
import p292fn.C9733f;
import p329h7.C10121i;
import p336he.C10155f;
import p341hj.C10221d1;
import p341hj.C10257p1;
import p364ib.C10465b;
import p371ik.C10527a;
import p387j7.C10718a;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11081g;
import p446l7.C11256d;
import p446l7.C11258f;
import p450le.C11273b;
import p454lj.C11282e;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p454lj.C11303z;
import p459lp.C11326d;
import p459lp.C11333k;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12318k0;
import p616rk.C12515a;
import p664u0.C13108a;
import p674ub.C13152i;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p706vd.C13407b;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p802y8.C13918b;
import sk.C12806c;
import sk.C12809f;
import tk.C13021b;

/* loaded from: classes3.dex */
public class CloudSpaceUpgradeActivity extends BuyPackageBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BannerShowRegionListener, GradePackageCardView.SendMessageCommunicator, PushGuideDialogCallback, PopupMenu.OnMenuItemClickListener, PartMemRightShowAdapter.PartMemRightShowCallBack {

    /* renamed from: S4 */
    public static C10804r f16872S4 = null;

    /* renamed from: T4 */
    public static String f16873T4 = "";

    /* renamed from: U4 */
    public static String f16874U4 = "";

    /* renamed from: V4 */
    public static String f16875V4 = "";

    /* renamed from: A1 */
    public ImageView f16876A1;

    /* renamed from: A3 */
    public Bitmap f16877A3;

    /* renamed from: A4 */
    public TextView f16878A4;

    /* renamed from: B1 */
    public ImageView f16879B1;

    /* renamed from: B3 */
    public View f16880B3;

    /* renamed from: B4 */
    public TextView f16881B4;

    /* renamed from: C1 */
    public RelativeLayout f16882C1;

    /* renamed from: C3 */
    public View f16883C3;

    /* renamed from: C4 */
    public TextView f16884C4;

    /* renamed from: D1 */
    public ListView f16885D1;

    /* renamed from: D3 */
    public BannerFragment f16886D3;

    /* renamed from: D4 */
    public SpanClickText f16887D4;

    /* renamed from: E1 */
    public View f16888E1;

    /* renamed from: E3 */
    public HiCloudExceptionView f16889E3;

    /* renamed from: E4 */
    public TextView f16890E4;

    /* renamed from: F1 */
    public View f16891F1;

    /* renamed from: F3 */
    public LinearLayout f16892F3;

    /* renamed from: F4 */
    public LinearLayout f16893F4;

    /* renamed from: G1 */
    public View f16894G1;

    /* renamed from: G3 */
    public LinearLayout f16895G3;

    /* renamed from: G4 */
    public LinearLayout f16896G4;

    /* renamed from: H1 */
    public boolean f16897H1;

    /* renamed from: H3 */
    public TextView f16898H3;

    /* renamed from: H4 */
    public ImageView f16899H4;

    /* renamed from: I1 */
    public View f16900I1;

    /* renamed from: I3 */
    public TextView f16901I3;

    /* renamed from: I4 */
    public RenewAgreementTextview f16902I4;

    /* renamed from: J1 */
    public RelativeLayout f16903J1;

    /* renamed from: J3 */
    public RelativeLayout f16904J3;

    /* renamed from: J4 */
    public boolean f16905J4;

    /* renamed from: K1 */
    public WrapContentHeightViewPager f16906K1;

    /* renamed from: K3 */
    public RelativeLayout f16907K3;

    /* renamed from: K4 */
    public TextView f16908K4;

    /* renamed from: L1 */
    public RelativeLayout f16909L1;

    /* renamed from: L3 */
    public RelativeLayout f16910L3;

    /* renamed from: L4 */
    public View.OnClickListener f16911L4;

    /* renamed from: M1 */
    public TextView f16912M1;

    /* renamed from: M3 */
    public TextView f16913M3;

    /* renamed from: M4 */
    public ImageView f16914M4;

    /* renamed from: N1 */
    public TextView f16915N1;

    /* renamed from: N3 */
    public C3628o f16916N3;

    /* renamed from: O1 */
    public ImageView f16918O1;

    /* renamed from: O4 */
    public TextView f16920O4;

    /* renamed from: P1 */
    public ImageView f16921P1;

    /* renamed from: P3 */
    public UrgencyScrollUpView f16922P3;

    /* renamed from: P4 */
    public boolean f16923P4;

    /* renamed from: Q3 */
    public String f16925Q3;

    /* renamed from: R3 */
    public String f16928R3;

    /* renamed from: S1 */
    public View f16930S1;

    /* renamed from: T1 */
    public View f16932T1;

    /* renamed from: T3 */
    public C3625l f16933T3;

    /* renamed from: U1 */
    public View f16934U1;

    /* renamed from: U3 */
    public LinearLayout f16935U3;

    /* renamed from: V1 */
    public View f16936V1;

    /* renamed from: V3 */
    public RecyclerView f16937V3;

    /* renamed from: W1 */
    public View f16938W1;

    /* renamed from: W3 */
    public TextView f16939W3;

    /* renamed from: X1 */
    public TextView f16940X1;

    /* renamed from: X3 */
    public TextView f16941X3;

    /* renamed from: Y1 */
    public PopupMenu f16942Y1;

    /* renamed from: Y3 */
    public AlertDialog f16943Y3;

    /* renamed from: Z1 */
    public MenuItem f16944Z1;

    /* renamed from: Z3 */
    public String f16945Z3;

    /* renamed from: a2 */
    public MenuItem f16946a2;

    /* renamed from: a4 */
    public GetAvailableGradePackagesResp f16947a4;

    /* renamed from: b2 */
    public String f16948b2;

    /* renamed from: b4 */
    public int f16949b4;

    /* renamed from: c2 */
    public String f16950c2;

    /* renamed from: c4 */
    public float f16951c4;

    /* renamed from: d2 */
    public AutoSizeButton f16952d2;

    /* renamed from: e2 */
    public AutoSizeButton f16954e2;

    /* renamed from: e4 */
    public Voucher f16955e4;

    /* renamed from: h1 */
    public ImageView f16958h1;

    /* renamed from: h4 */
    public PayActivityInfo f16959h4;

    /* renamed from: i1 */
    public HwProgressBar f16960i1;

    /* renamed from: j1 */
    public ImageView f16962j1;

    /* renamed from: j4 */
    public GetPackagesBySpaceRuleResp f16963j4;

    /* renamed from: k1 */
    public ImageView f16964k1;

    /* renamed from: l1 */
    public RelativeLayout f16966l1;

    /* renamed from: m1 */
    public RelativeLayout f16968m1;

    /* renamed from: m4 */
    public String f16969m4;

    /* renamed from: n1 */
    public TextView f16970n1;

    /* renamed from: o1 */
    public TextView f16972o1;

    /* renamed from: o4 */
    public boolean f16973o4;

    /* renamed from: p1 */
    public TextView f16974p1;

    /* renamed from: p4 */
    public DlAppCampInfo f16975p4;

    /* renamed from: q1 */
    public TextView f16976q1;

    /* renamed from: r1 */
    public TextBannerSwitcher f16978r1;

    /* renamed from: s1 */
    public View f16980s1;

    /* renamed from: t1 */
    public RelativeLayout f16982t1;

    /* renamed from: u1 */
    public ScrollView4List f16984u1;

    /* renamed from: v1 */
    public LinearLayout f16986v1;

    /* renamed from: v4 */
    public boolean f16987v4;

    /* renamed from: w1 */
    public View f16988w1;

    /* renamed from: w4 */
    public long f16989w4;

    /* renamed from: x1 */
    public String f16990x1;

    /* renamed from: y1 */
    public String f16993y1;

    /* renamed from: y3 */
    public UnspportPrivateSpaceDialog f16994y3;

    /* renamed from: y4 */
    public float f16995y4;

    /* renamed from: z1 */
    public RelativeLayout f16996z1;

    /* renamed from: z3 */
    public C10718a f16997z3;

    /* renamed from: z4 */
    public C1173i f16998z4;

    /* renamed from: Q1 */
    public List<GradePackageCardView> f16924Q1 = new ArrayList();

    /* renamed from: R1 */
    public List<GradePackageCardView> f16927R1 = new ArrayList();

    /* renamed from: x3 */
    public boolean f16991x3 = true;

    /* renamed from: O3 */
    public List<UrgencyOnTopParams> f16919O3 = new ArrayList();

    /* renamed from: S3 */
    public C11828b f16931S3 = C9433j.m59164c().m59165b();

    /* renamed from: d4 */
    public boolean f16953d4 = false;

    /* renamed from: f4 */
    public String f16956f4 = "";

    /* renamed from: g4 */
    public String f16957g4 = "";

    /* renamed from: i4 */
    public boolean f16961i4 = false;

    /* renamed from: k4 */
    public boolean f16965k4 = false;

    /* renamed from: l4 */
    public long f16967l4 = -1;

    /* renamed from: n4 */
    public int f16971n4 = 0;

    /* renamed from: q4 */
    public boolean f16977q4 = false;

    /* renamed from: r4 */
    public boolean f16979r4 = false;

    /* renamed from: s4 */
    public boolean f16981s4 = false;

    /* renamed from: t4 */
    public boolean f16983t4 = false;

    /* renamed from: u4 */
    public boolean f16985u4 = false;

    /* renamed from: x4 */
    public boolean f16992x4 = true;

    /* renamed from: N4 */
    public C3627n f16917N4 = new C3627n(this, null);

    /* renamed from: Q4 */
    public Handler f16926Q4 = new HandlerC3616c();

    /* renamed from: R4 */
    public boolean f16929R4 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$a */
    public class ViewOnClickListenerC3614a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f16999a;

        /* renamed from: b */
        public final /* synthetic */ boolean f17000b;

        public ViewOnClickListenerC3614a(String str, boolean z10) {
            this.f16999a = str;
            this.f17000b = z10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "refreshMemRightArea click too fast");
                return;
            }
            if (C13452e.m80781L().m80887a1()) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "new business mode user, turn to H5 page");
                CloudSpaceUpgradeActivity.this.m23352J7();
                return;
            }
            C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshMemRightArea click more.");
            Intent intent = new Intent(CloudSpaceUpgradeActivity.this, (Class<?>) MemberRightActivity.class);
            intent.putExtra("rightGradeCode", this.f16999a);
            intent.putExtra("rightRightCode", "more_rights");
            intent.putExtra("isavailable", this.f17000b);
            intent.putExtra("clickSourceType", "2");
            intent.putExtra("purchase_need_data", CloudSpaceUpgradeActivity.this.mo23429o());
            CloudSpaceUpgradeActivity.this.startActivity(intent);
            CloudSpaceUpgradeActivity.this.m22842j4("UNIFORM_CLOUDPAY_CLICK_MORE_RIGHT_INFO", new LinkedHashMap<>());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$b */
    public static /* synthetic */ class C3615b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f17002a;

        static {
            int[] iArr = new int[EnumC9164e.values().length];
            f17002a = iArr;
            try {
                iArr[EnumC9164e.LEVEL_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17002a[EnumC9164e.LEVEL_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17002a[EnumC9164e.LEVEL_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17002a[EnumC9164e.LEVEL_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$c */
    public class HandlerC3616c extends Handler {
        public HandlerC3616c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "msg is null");
                return;
            }
            Object obj = message.obj;
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            int i10 = message.arg1;
            int i11 = message.what;
            if (i11 == 7014) {
                CloudSpaceUpgradeActivity.this.m23325A9(iIntValue, i10);
            } else if (i11 != 7015) {
                CloudSpaceUpgradeActivity.this.m23401d8(i10);
            } else {
                CloudSpaceUpgradeActivity.this.m23404e8(i10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$d */
    public class ViewOnClickListenerC3617d implements View.OnClickListener {
        public ViewOnClickListenerC3617d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "refreshMemRightArea click too fast");
                return;
            }
            C1442a.m8290i("CloudSpaceUpgradeActivity", "new business mode diamond user jump to h5 power page");
            CloudSpaceUpgradeActivity.this.m23352J7();
            CloudSpaceUpgradeActivity.this.m22842j4("UNIFORM_CLOUDPAY_CLICK_MORE_RIGHT_INFO", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$e */
    public class C3618e extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final /* synthetic */ View f17005a;

        public C3618e(View view) {
            this.f17005a = view;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.removeChild(CloudSpaceUpgradeActivity.this.f16984u1);
            accessibilityNodeInfo.removeChild(this.f17005a);
            accessibilityNodeInfo.addChild(CloudSpaceUpgradeActivity.this.f16984u1);
            accessibilityNodeInfo.addChild(this.f17005a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$f */
    public class ViewTreeObserverOnPreDrawListenerC3619f implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC3619f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CloudSpaceUpgradeActivity.this.f16974p1.getViewTreeObserver().removeOnPreDrawListener(this);
            int width = CloudSpaceUpgradeActivity.this.f16960i1.getWidth();
            if (CloudSpaceUpgradeActivity.this.f16976q1.getLineCount() + CloudSpaceUpgradeActivity.this.f16974p1.getLineCount() <= 2) {
                return true;
            }
            CloudSpaceUpgradeActivity.this.f16974p1.setMaxWidth((int) ((width - CloudSpaceUpgradeActivity.this.getResources().getDimensionPixelOffset(R$dimen.cloud_space_16_dp)) * 0.4d));
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$g */
    public class DialogInterfaceOnClickListenerC3620g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3620g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity = CloudSpaceUpgradeActivity.this;
            if (cloudSpaceUpgradeActivity.f16983t4) {
                cloudSpaceUpgradeActivity.m22865q4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$h */
    public class RunnableC3621h implements Runnable {
        public RunnableC3621h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CloudSpaceUpgradeActivity.this.m23349I7()) {
                return;
            }
            CloudSpaceUpgradeActivity.this.f16943Y3.show();
            CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity = CloudSpaceUpgradeActivity.this;
            if (cloudSpaceUpgradeActivity.f16983t4) {
                cloudSpaceUpgradeActivity.m22888w4();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$i */
    public class RunnableC3622i implements Runnable {
        public RunnableC3622i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudSpaceUpgradeActivity.this.m23359M6();
            CloudSpaceUpgradeActivity.this.f16505E0.showStopFamilyShareDialog();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$j */
    public class C3623j implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
        public C3623j() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void refreshCheckboxStatus(boolean z10) {
            if (z10) {
                CloudSpaceUpgradeActivity.this.f16899H4.setBackground(CloudSpaceUpgradeActivity.this.getDrawable(R$drawable.renew_check_icon_on));
            } else {
                CloudSpaceUpgradeActivity.this.f16899H4.setBackground(CloudSpaceUpgradeActivity.this.getDrawable(R$drawable.renew_check_icon_off));
            }
            CloudSpaceUpgradeActivity.this.f16905J4 = z10;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
            CloudSpaceUpgradeActivity.this.mo23208t(str, linkedHashMap);
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void startPaymentProcess(C0079a c0079a) throws JSONException {
            if (c0079a == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startPaymentProcess, agreementDialogNeedData is null.");
            } else {
                CloudSpaceUpgradeActivity.this.m23465y9(c0079a.m650g(), c0079a.m649f(), c0079a.m646c());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$k */
    public class C3624k implements ScrollUpUrgencyView.OnItemClickListener {
        public C3624k() {
        }

        @Override // com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView.OnItemClickListener
        public void onItemClick(int i10) {
            if (C0209d.m1226Y0()) {
                C11839m.m70687e("CloudSpaceUpgradeActivity", "fast click urgencyScrollupView");
            } else {
                CloudSpaceUpgradeActivity.this.m23306j7(i10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$l */
    public static class C3625l extends AbstractC0984a {

        /* renamed from: h */
        public List<GradePackageCardView> f17013h;

        /* renamed from: i */
        public Context f17014i;

        public C3625l(Context context, List<GradePackageCardView> list) {
            this.f17014i = context;
            this.f17013h = list;
        }

        /* renamed from: a */
        public int m23468a() {
            for (int i10 = 0; i10 < getCount(); i10++) {
                GradePackageCardView gradePackageCardView = this.f17013h.get(i10);
                if (gradePackageCardView != null && gradePackageCardView.m23544E()) {
                    return i10;
                }
            }
            return -1;
        }

        /* renamed from: b */
        public int m23469b(String str) {
            for (int i10 = 0; i10 < getCount(); i10++) {
                GradePackageCardView gradePackageCardView = this.f17013h.get(i10);
                if (gradePackageCardView != null && gradePackageCardView.m23545F(str)) {
                    return i10;
                }
            }
            return -1;
        }

        /* renamed from: c */
        public int m23470c(String str, long j10) {
            for (int i10 = 0; i10 < getCount(); i10++) {
                GradePackageCardView gradePackageCardView = this.f17013h.get(i10);
                if (gradePackageCardView != null && gradePackageCardView.m23546G(str, j10)) {
                    return i10;
                }
            }
            return -1;
        }

        /* renamed from: d */
        public List<GradePackageCardView> m23471d() {
            return this.f17013h;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj == null || !(obj instanceof GradePackageCardView)) {
                return;
            }
            viewGroup.removeView((GradePackageCardView) obj);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            List<GradePackageCardView> list = this.f17013h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            List<GradePackageCardView> list = this.f17013h;
            if (list == null || list.isEmpty() || this.f17013h.size() <= i10) {
                return new GradePackageCardView(this.f17014i);
            }
            GradePackageCardView gradePackageCardView = this.f17013h.get(i10);
            viewGroup.addView(gradePackageCardView);
            return gradePackageCardView;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$m */
    public class C3626m implements ViewPager.InterfaceC0980i {

        /* renamed from: a */
        public WrapContentHeightViewPager f17015a;

        public C3626m(WrapContentHeightViewPager wrapContentHeightViewPager) {
            this.f17015a = wrapContentHeightViewPager;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 2) {
                CloudSpaceUpgradeActivity.this.m23416i8();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            List<GradePackageCardView> listM23471d;
            GradePackageCardView gradePackageCardView;
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f17015a;
            if (wrapContentHeightViewPager == null) {
                return;
            }
            AbstractC0984a adapter = wrapContentHeightViewPager.getAdapter();
            if (!(adapter instanceof C3625l) || (listM23471d = ((C3625l) adapter).m23471d()) == null || i10 >= listM23471d.size() || (gradePackageCardView = listM23471d.get(i10)) == null) {
                return;
            }
            String str = gradePackageCardView.getmGradeCode();
            if (!TextUtils.isEmpty(str)) {
                CloudSpaceUpgradeActivity.this.m23324A8(str);
            }
            CloudSpaceUpgradeActivity.this.m23323A6(i10, listM23471d.size());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$n */
    public class C3627n extends BroadcastReceiver {
        public C3627n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C11839m.m70688i("CloudSpaceUpgradeActivity", "onReceive: " + safeIntent.getAction());
            if ("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH".equals(safeIntent.getAction()) && CloudSpaceUpgradeActivity.this.f16979r4) {
                C11839m.m70688i("CloudSpaceUpgradeActivity", "open switch after upgrade");
                CloudSpaceUpgradeActivity.this.m23294Z7();
                CloudSpaceUpgradeActivity.this.f16979r4 = false;
            }
        }

        public /* synthetic */ C3627n(CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity, HandlerC3616c handlerC3616c) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity$o */
    public class C3628o extends BroadcastReceiver {
        public C3628o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if ("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW".equals(action)) {
                C1442a.m8288d("CloudSpaceUpgradeActivity", "config file changed, check campaign");
                CloudSpaceUpgradeActivity.this.m23375T6();
                return;
            }
            if ("notify_urgency_top_banner".equals(action)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("Receive urgency broadcast", String.valueOf("CloudSpaceUpgradeActivity:notify_urgency_top_banner,Time =" + System.currentTimeMillis()));
                C12318k0.m74089a("Receive urgency broadcast", linkedHashMap);
                CloudSpaceUpgradeActivity.this.m23314o9(safeIntent);
                return;
            }
            if (RecommendCardConstants.BUY_RECOMMEND_REFRESH_FINISH_ACTION.equals(action)) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "refresh card finish, refresh banner");
                if (CloudSpaceUpgradeActivity.this.f16886D3 != null) {
                    CloudSpaceUpgradeActivity.this.f16886D3.m24114m();
                    return;
                }
                return;
            }
            if (RecommendCardConstants.UPGRADE_BANNER_CONFIG_UPDATE.equals(action)) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "refresh recommend Cards");
                RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.BUY, false, false);
                return;
            }
            if ("com.huawei.hicloud.intent.action.ACTION_TASK_CENTER_ACCEPT_CLOUD_SPACE_SUCCESS".equals(action)) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "UpgradeBroadcastReceiver, taskCenter accpet cloud space success.");
                CloudSpaceUpgradeActivity.this.mo19460T3();
            } else if ("com.huawei.hicloud.intent.action.ACTION_AOP_PAY_SUCCESS".equals(action)) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "broadcast aop success.");
                CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity = CloudSpaceUpgradeActivity.this;
                if (cloudSpaceUpgradeActivity.f16521M0 || cloudSpaceUpgradeActivity.isFinishing()) {
                    return;
                }
                CloudSpaceUpgradeActivity.this.mo19460T3();
            }
        }

        public /* synthetic */ C3628o(CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity, HandlerC3616c handlerC3616c) {
            this();
        }
    }

    /* renamed from: A7 */
    private void m23262A7() {
        UrgencyScrollUpView urgencyScrollUpView = (UrgencyScrollUpView) C12809f.m76829b(this, R$id.cloud_urgency_scrollup_text);
        this.f16922P3 = urgencyScrollUpView;
        urgencyScrollUpView.setVisibility(8);
        this.f16922P3.setOnItemClickListener(new C3624k());
    }

    @SuppressLint({"ResourceAsColor"})
    /* renamed from: C7 */
    private void m23263C7() throws Resources.NotFoundException {
        m23430o7();
        m23376T8();
        new LinearLayoutManager(this).setOrientation(0);
        new LinearLayoutManager(this).setOrientation(0);
        this.f16932T1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f16934U1 = C12809f.m76829b(this, R$id.layout_nodata);
        this.f16940X1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f16936V1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f16938W1 = C12809f.m76829b(this, R$id.layout_nonet_icon);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f16952d2 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f16934U1.setOnClickListener(this);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f16954e2 = autoSizeButton2;
        C11842p.m70874v1(this, autoSizeButton2);
        this.f16954e2.setOnClickListener(this);
        this.f16988w1 = C12809f.m76829b(this, R$id.actionbar_layout_add_height);
        this.f16889E3 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        C10718a c10718a = new C10718a(this);
        this.f16997z3 = c10718a;
        c10718a.m65429D(this.f16524O);
        this.f16997z3.m65432m("cloudSpaceUpgrade");
        if (m23345H7()) {
            this.f16901I3.setText(R$string.cloudpay_card_exchange_title);
        }
        m23262A7();
        m23455w7();
        m23320u7();
        m23327B7();
        this.f16892F3 = (LinearLayout) C12809f.m76829b(this, R$id.default_packages_area);
        this.f16895G3 = (LinearLayout) C12809f.m76829b(this, R$id.service_diff_country_area);
        this.f16898H3 = (TextView) C12809f.m76829b(this, R$id.diff_current_register);
        this.f16913M3 = (TextView) C12809f.m76829b(this, R$id.diff_current_service);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.mem_right_show_area);
        this.f16935U3 = linearLayout;
        linearLayout.setVisibility(8);
        this.f16939W3 = (TextView) C12809f.m76829b(this, R$id.mem_right_title);
        this.f16941X3 = (TextView) C12809f.m76829b(this, R$id.mem_right_more);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.part_mem_right_area);
        this.f16937V3 = recyclerView;
        recyclerView.addItemDecoration(new C13407b(C11842p.m70840n(this, 4)));
        this.f16908K4 = (TextView) C12809f.m76829b(this, R$id.tv_more_right);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.worry_free_card_ll);
        this.f16893F4 = linearLayout2;
        linearLayout2.setVisibility(8);
        this.f16881B4 = (TextView) C12809f.m76829b(this, R$id.worry_free_card_title_tv);
        this.f16884C4 = (TextView) C12809f.m76829b(this, R$id.worry_free_card_title2_tv);
        int i10 = R$id.worry_free_card_desc;
        View viewM76829b2 = C12809f.m76829b(this, i10);
        int i11 = R$id.worry_free_card_desc2;
        View viewM76829b3 = C12809f.m76829b(this, i11);
        this.f16896G4 = (LinearLayout) C12809f.m76829b(this, R$id.worry_card_renew_check_area);
        this.f16899H4 = (ImageView) C12809f.m76829b(this, R$id.worry_card_renew_check_view);
        this.f16902I4 = (RenewAgreementTextview) C12809f.m76829b(this, R$id.worry_card_renew_text);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16896G4.getLayoutParams();
        if (this.f16995y4 >= 1.75f || !C13843a.m83067S()) {
            viewM76829b2.setVisibility(8);
            viewM76829b3.setVisibility(0);
            this.f16887D4 = (SpanClickText) C12809f.m76829b(this, R$id.worry_free_card_price_tv2);
            this.f16890E4 = (TextView) C12809f.m76829b(this, R$id.worry_free_card_price_remark2);
            layoutParams.f2994j = i11;
        } else {
            viewM76829b2.setVisibility(0);
            viewM76829b3.setVisibility(8);
            this.f16887D4 = (SpanClickText) C12809f.m76829b(this, R$id.worry_free_card_price_tv);
            this.f16890E4 = (TextView) C12809f.m76829b(this, R$id.worry_free_card_price_remark);
            layoutParams.f2994j = i10;
        }
        this.f16896G4.setLayoutParams(layoutParams);
        this.f16899H4.setOnClickListener(this);
        if (this.f16905J4) {
            this.f16899H4.setBackground(getDrawable(R$drawable.renew_check_icon_on));
        } else {
            this.f16899H4.setBackground(getDrawable(R$drawable.renew_check_icon_off));
        }
        TextView textView = (TextView) C12809f.m76829b(this, R$id.worry_free_card_buy_tv);
        this.f16878A4 = textView;
        textView.setOnClickListener(this);
    }

    /* renamed from: K8 */
    public static void m23269K8(C10804r c10804r) {
        f16872S4 = c10804r;
    }

    /* renamed from: O6 */
    private void m23274O6(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (i10 == 0) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e("CloudSpaceUpgradeActivity", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C1442a.m8289e("CloudSpaceUpgradeActivity", "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10002) {
                        c10028cM62183d0.m62377p3("hms_agr_force_query", false);
                    }
                }
            }
        } else {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "agreement update success");
            c10028cM62183d0.m62377p3("hms_agr_force_query", false);
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
    }

    /* renamed from: O7 */
    public static /* synthetic */ boolean m23275O7(MemGradeRight memGradeRight) {
        return TextUtils.equals(memGradeRight.getRightCode(), "FRW");
    }

    /* renamed from: R7 */
    public static /* synthetic */ boolean m23279R7(boolean z10, CloudSpace cloudSpace) {
        return !(z10 && cloudSpace.getScheme() == 2) && cloudSpace.getEndTime() > 0;
    }

    /* renamed from: R8 */
    private void m23280R8(View view) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "setMoreHotSpace");
        m23448u8();
        PopupMenu popupMenu = new PopupMenu(this, view, 8388613);
        this.f16942Y1 = popupMenu;
        popupMenu.getMenuInflater().inflate(R$menu.main_menu_upgrade, this.f16942Y1.getMenu());
        this.f16942Y1.setOnMenuItemClickListener(this);
        this.f16944Z1 = this.f16942Y1.getMenu().findItem(R$id.redemption_member_card);
        if (m23426n7()) {
            this.f16944Z1.setVisible(false);
        } else {
            this.f16944Z1.setTitle(this.f16948b2);
        }
        this.f16946a2 = this.f16942Y1.getMenu().findItem(R$id.purchase_member_card);
        if (m23424m7()) {
            this.f16946a2.setVisible(false);
        } else {
            this.f16946a2.setTitle(this.f16950c2);
        }
        this.f16942Y1.show();
    }

    /* renamed from: S8 */
    private void m23282S8() {
        int iM70731H = C11842p.m70731H(this, (int) C11842p.m70844o(this, 36));
        int iM70731H2 = C11842p.m70731H(this, (int) C11842p.m70844o(this, 60));
        C11842p.m70763R1(this, this.f16938W1, iM70731H2);
        C11842p.m70763R1(this, this.f16932T1, iM70731H);
        C11842p.m70763R1(this, C12809f.m76829b(this, R$id.layout_no_service_icon), iM70731H2);
    }

    /* renamed from: T7 */
    public static /* synthetic */ boolean m23284T7(SpannableString spannableString) {
        return !TextUtils.isEmpty(spannableString);
    }

    /* renamed from: W6 */
    public static C10804r m23288W6() {
        return f16872S4;
    }

    /* renamed from: X6 */
    private void m23290X6() {
        C12515a.m75110o().m75172d(new C3010a0(this.f16524O));
    }

    /* renamed from: X8 */
    private void m23291X8() {
        if (TextUtils.isEmpty(this.f16925Q3)) {
            this.f16922P3.setVisibility(8);
        } else {
            m23316p9();
        }
    }

    /* renamed from: Z7 */
    public void m23294Z7() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58414c(C0213f.m1377a(), 39);
        }
    }

    /* renamed from: i9 */
    private void m23304i9() throws Resources.NotFoundException {
        if (this.f16933T3 == null) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "mGradePackageAdapter is null");
            return;
        }
        m23341G6();
        C11842p.m70712A2(this.f16909L1, false);
        this.f16544Y = false;
        m23411g9();
        mo23347I(this.f16981s4);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("deviceId", C13452e.m80781L().m80950o());
        C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_MORE_PKG_CLICK", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_MORE_PKG_CLICK", "1", "84", linkedHashMapM79497A);
    }

    /* renamed from: j7 */
    public void m23306j7(int i10) {
        Intent intent;
        List<UrgencyOnTopParams> list = this.f16919O3;
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "Urgency failed, urgencyOnTopParams is null");
            return;
        }
        if (i10 > this.f16919O3.size()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "Urgency failed, position is illegal.");
            return;
        }
        UrgencyOnTopParams urgencyOnTopParams = this.f16919O3.get(i10);
        String urgencyGoto = urgencyOnTopParams.getUrgencyGoto();
        String detailString = urgencyOnTopParams.getDetailString();
        String urgencID = urgencyOnTopParams.getUrgencID();
        String url = urgencyOnTopParams.getUrl();
        if (TextUtils.isEmpty(urgencyGoto)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "gotoType is null.");
            return;
        }
        try {
            if (urgencyGoto.equals("detail")) {
                intent = new Intent();
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("com.huawei.android.hicloud.ui.activity.UrgencyDetailActivity");
                intent.putExtra("urgency_goto_detail", detailString);
                intent.putExtra("detail_urgency_ID", urgencID);
                m23331C8("CloudSpaceUpgradeActivity:detail-" + detailString + ",Time =" + System.currentTimeMillis());
            } else if (urgencyGoto.equals("web")) {
                Intent intentM79111y = C13152i.m79070o().m79111y(url);
                m23331C8("CloudSpaceUpgradeActivity:web-" + url + ",Time =" + System.currentTimeMillis());
                intent = intentM79111y;
            } else {
                intent = null;
            }
            if (intent != null) {
                startActivity(intent);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "startActivity exception:" + e10.toString());
        }
    }

    /* renamed from: j9 */
    private void m23307j9() {
        this.f16936V1.setVisibility(0);
        this.f16932T1.setVisibility(8);
        this.f16934U1.setVisibility(8);
        this.f16930S1.setVisibility(8);
    }

    /* renamed from: m8 */
    private void m23311m8(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshUserPhoto photo is wrong! bitmap is " + (bitmap == null ? "null" : "recycled"));
            return;
        }
        Bitmap bitmap2 = this.f16877A3;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.f16877A3 = bitmap;
        ImageView imageView = this.f16962j1;
        Resources resources = getResources();
        int i10 = R$drawable.avatar_bg_circle;
        imageView.setBackground(resources.getDrawable(i10));
        this.f16962j1.setImageBitmap(this.f16877A3);
        this.f16964k1.setBackground(getResources().getDrawable(i10));
        this.f16964k1.setImageBitmap(this.f16877A3);
    }

    /* renamed from: o9 */
    public void m23314o9(SafeIntent safeIntent) {
        UrgencyTop urgencyTop;
        String stringExtra = safeIntent.getStringExtra("detail_urgency_top_banner");
        String stringExtra2 = safeIntent.getStringExtra("detail_urgency_top_detail");
        String stringExtra3 = safeIntent.getStringExtra("detail_urgency_ID");
        if (stringExtra != null) {
            try {
                urgencyTop = (UrgencyTop) new Gson().fromJson(stringExtra, UrgencyTop.class);
            } catch (Exception e10) {
                C11839m.m70687e("CloudSpaceUpgradeActivity", "getUrencyTop exception:" + e10.toString());
                return;
            }
        } else {
            urgencyTop = null;
        }
        if (urgencyTop == null) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "get UrgencyTop is null");
            return;
        }
        if (!C13152i.m79070o().m79094d("upgrade_entrance", urgencyTop.getShowPages())) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "page not show");
            return;
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "get UrgencyID is null");
            return;
        }
        String content = urgencyTop.getContent();
        if (TextUtils.isEmpty(content)) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "get Urgency content is null");
            return;
        }
        String strM79071w = C13152i.m79071w(content);
        this.f16925Q3 = strM79071w;
        if (strM79071w == null) {
            return;
        }
        UrgencyGoto to2 = urgencyTop.getTo();
        List<UrgencyOnTopParams> list = this.f16919O3;
        if (list == null || list.size() != 0) {
            if (this.f16919O3 != null) {
                m23319s6(stringExtra3, to2, stringExtra2);
            }
        } else {
            UrgencyOnTopParams urgencyOnTopParams = new UrgencyOnTopParams();
            urgencyOnTopParams.setUrgencID(stringExtra3);
            m23321z7(urgencyOnTopParams, to2, stringExtra2);
            this.f16919O3.add(urgencyOnTopParams);
            m23291X8();
        }
    }

    /* renamed from: p9 */
    private void m23316p9() {
        if (this.f16919O3.size() <= 0 || this.f16922P3 == null) {
            return;
        }
        C11839m.m70686d("CloudSpaceUpgradeActivity", "showBannerView success , mBannerInfoList size = " + this.f16919O3.size());
        this.f16922P3.setData(this.f16919O3);
        this.f16922P3.setVisibility(0);
        if (this.f16919O3.size() > 1) {
            this.f16922P3.setTimer(5000L);
            this.f16922P3.m24011l();
            this.f16922P3.m24010k();
        }
    }

    /* renamed from: r7 */
    private void m23318r7() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "initBroadcastReceiver");
        if (this.f16916N3 == null) {
            this.f16916N3 = new C3628o(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW");
            intentFilter.addAction("notify_urgency_top_banner");
            intentFilter.addAction(RecommendCardConstants.UPGRADE_BANNER_CONFIG_UPDATE);
            intentFilter.addAction(RecommendCardConstants.BUY_RECOMMEND_REFRESH_FINISH_ACTION);
            if (!this.f16521M0) {
                intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_AOP_PAY_SUCCESS");
            }
            C13108a.m78878b(this).m78880c(this.f16916N3, intentFilter);
        }
    }

    /* renamed from: s6 */
    private void m23319s6(String str, UrgencyGoto urgencyGoto, String str2) {
        boolean z10 = false;
        for (UrgencyOnTopParams urgencyOnTopParams : this.f16919O3) {
            C11839m.m70687e("aaa", "page not show111");
            z10 = !str.equals(urgencyOnTopParams.getUrgencID());
        }
        if (z10) {
            UrgencyOnTopParams urgencyOnTopParams2 = new UrgencyOnTopParams();
            urgencyOnTopParams2.setUrgencID(str);
            m23321z7(urgencyOnTopParams2, urgencyGoto, str2);
            this.f16919O3.add(urgencyOnTopParams2);
            m23291X8();
        }
    }

    /* renamed from: u7 */
    private void m23320u7() {
        this.f16930S1 = C12809f.m76829b(this, R$id.layout_main);
        this.f16903J1 = (RelativeLayout) C12809f.m76829b(this, R$id.main_viewpage_layout);
        this.f16885D1 = (ListView) C12809f.m76829b(this, R$id.diamend_right_card);
        View viewM76829b = C12809f.m76829b(this, R$id.redemption_member_card);
        this.f16891F1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        View viewM76829b2 = C12809f.m76829b(this, R$id.purchase_member_card);
        this.f16894G1 = viewM76829b2;
        viewM76829b2.setOnClickListener(this);
        this.f16888E1 = C12809f.m76829b(this, R$id.entrance_card_layout);
        this.f16900I1 = C12809f.m76829b(this, R$id.bottom_mutable_layout);
    }

    /* renamed from: z7 */
    private void m23321z7(UrgencyOnTopParams urgencyOnTopParams, UrgencyGoto urgencyGoto, String str) {
        urgencyOnTopParams.setUrgencyContent(this.f16925Q3);
        if (urgencyGoto == null) {
            return;
        }
        urgencyOnTopParams.setDetailString(str);
        urgencyOnTopParams.setUrgencyGoto(urgencyGoto.getType());
        urgencyOnTopParams.setUrl(urgencyGoto.getUri());
    }

    /* renamed from: z8 */
    private void m23322z8() {
        RestoreUtil.reportSourceFromNotification(getIntent(), "78");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: A3 */
    public void mo22742A3(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        super.mo22742A3(getAvailableGradePackagesResp);
        View view = this.f16880B3;
        if (view != null && view.getVisibility() == 0 && this.f16544Y) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", "set bannerStubFrame gone");
            C11842p.m70712A2(this.f16880B3, false);
        }
    }

    /* renamed from: A6 */
    public final void m23323A6(int i10, int i11) {
        ImageView imageView = this.f16918O1;
        if (imageView == null || this.f16921P1 == null) {
            return;
        }
        this.f16971n4 = i10;
        if (i11 <= 1) {
            imageView.setVisibility(4);
            this.f16921P1.setVisibility(4);
        } else if (i10 == 0) {
            imageView.setVisibility(4);
            this.f16921P1.setVisibility(0);
        } else if (i10 == i11 - 1) {
            imageView.setVisibility(0);
            this.f16921P1.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            this.f16921P1.setVisibility(0);
        }
    }

    /* renamed from: A8 */
    public final void m23324A8(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("grade_code", str);
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_GRADE_CARD_CHANGE", linkedHashMap);
    }

    /* renamed from: A9 */
    public final void m23325A9(final int i10, final int i11) throws Resources.NotFoundException {
        AdParametersExt adParametersExt = this.f16575v0;
        if (adParametersExt == null || !adParametersExt.isRequestAgdResource(0, null)) {
            m23401d8(i11);
        } else {
            C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.t
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f17571a.m23385X7(i10, i11, (List) obj);
                }
            }, this.f16575v0.getAgdAdid()), false);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 16));
    }

    /* renamed from: B6 */
    public final void m23326B6() {
        if (C11293p.m67772p(this.f21452m)) {
            this.f16503D0 = 2;
        }
    }

    /* renamed from: B7 */
    public final void m23327B7() {
        this.f16958h1 = (ImageView) C12809f.m76829b(this, R$id.upgrade_user_head_background_rl);
        this.f16960i1 = (HwProgressBar) C12809f.m76829b(this, R$id.space_use_progress_bar);
        this.f16962j1 = (ImageView) C12809f.m76829b(this, R$id.upgrade_user_head_pic);
        this.f16964k1 = (ImageView) C12809f.m76829b(this, R$id.new_business_user_card_head_pic);
        this.f16966l1 = (RelativeLayout) C12809f.m76829b(this, R$id.member_card_layout);
        this.f16968m1 = (RelativeLayout) C12809f.m76829b(this, R$id.member_card_layout_nn);
        this.f16970n1 = (TextView) C12809f.m76829b(this, R$id.upgrade_user_nick_name);
        this.f16972o1 = (TextView) C12809f.m76829b(this, R$id.vip_card_grad_name);
        this.f16914M4 = (ImageView) C12809f.m76829b(this, R$id.icon_petalone);
        this.f16974p1 = (TextView) C12809f.m76829b(this, R$id.member_grade_right_tips);
        this.f16976q1 = (TextView) C12809f.m76829b(this, R$id.available_space_tip);
        this.f16980s1 = C12809f.m76829b(this, R$id.actionbar_layout);
        this.f16982t1 = (RelativeLayout) C12809f.m76829b(this, R$id.actionbar_bg);
        this.f16984u1 = (ScrollView4List) C12809f.m76829b(this, R$id.main_scroll);
        this.f16986v1 = (LinearLayout) C12809f.m76829b(this, R$id.main_view_container);
        this.f16978r1 = (TextBannerSwitcher) C12809f.m76829b(this, R$id.payment_manager_text_switcher);
        this.f16920O4 = (TextView) C12809f.m76829b(this, R$id.payment_manager_button);
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            m23337E8();
            this.f16982t1.setAlpha(0.0f);
            this.f16982t1.setBackground(getResources().getDrawable(R$color.hicloud_activity_bg));
        }
        this.f16984u1.setOnScrollChangedListener(new ScrollView4List.InterfaceC4859a() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.s
            @Override // com.huawei.hicloud.base.p103ui.uiextend.ScrollView4List.InterfaceC4859a
            /* renamed from: a */
            public final void mo23907a(ScrollView scrollView, int i10, int i11, int i12, int i13) {
                this.f17570a.m23363N7(scrollView, i10, i11, i12, i13);
            }
        });
        this.f16930S1.setAccessibilityDelegate(new C3618e(C12809f.m76829b(this, R$id.actionbar_upgrade)));
    }

    /* renamed from: B8 */
    public final void m23328B8(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m23443t6(linkedHashMapM79497A);
        m22842j4(str, linkedHashMapM79497A);
    }

    /* renamed from: B9 */
    public final void m23329B9() {
        if (this.f16995y4 >= 1.75f) {
            return;
        }
        this.f16974p1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC3619f());
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: C */
    public void mo23172C() {
        C1442a.m8289e("CloudSpaceUpgradeActivity", "--- onCountDownTimer");
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 16));
    }

    /* renamed from: C6 */
    public final boolean m23330C6(QueryPushGuideRsp queryPushGuideRsp) {
        ConsentRecordWithStatus consentRecordWithStatus;
        if (queryPushGuideRsp == null) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "rsp is null");
            return false;
        }
        List<ConsentRecordWithStatus> recordWithStatusArrayList = queryPushGuideRsp.getRecordWithStatusArrayList();
        if (recordWithStatusArrayList == null || (consentRecordWithStatus = recordWithStatusArrayList.get(0)) == null) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "consentrecordwithstatus rsp is null");
            return false;
        }
        ConsentRecord latestSignRecord = consentRecordWithStatus.getLatestSignRecord();
        if (latestSignRecord != null) {
            C10028c.m62182c0().m62296Y1(latestSignRecord.getSubConsent());
        }
        if (consentRecordWithStatus.isNeedSign()) {
            return true;
        }
        C11839m.m70688i("CloudSpaceUpgradeActivity", "no need sign");
        return false;
    }

    /* renamed from: C8 */
    public final void m23331C8(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("urgency goto", String.valueOf(str));
        C12318k0.m74089a("urgency notice event", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: D3 */
    public Map<String, String> mo22754D3() {
        Map<String, String> mapMo22754D3 = super.mo22754D3();
        if (mapMo22754D3 == null) {
            mapMo22754D3 = new HashMap<>();
        }
        if (!TextUtils.isEmpty(this.f16519L0)) {
            mapMo22754D3.put(Constants.CONTENT_SERVER_REALM, this.f16519L0);
        }
        if (!TextUtils.isEmpty(this.f16517K0)) {
            mapMo22754D3.put("activityId", this.f16517K0);
        }
        return mapMo22754D3;
    }

    /* renamed from: D6 */
    public final boolean m23332D6(List<Voucher> list, CloudPackage cloudPackage, PackageGrades packageGrades) {
        if (this.f16896G4.getVisibility() != 0 || this.f16905J4) {
            return false;
        }
        C0079a c0079a = new C0079a();
        c0079a.m656m(cloudPackage);
        c0079a.m653j(packageGrades);
        c0079a.m657n(list);
        c0079a.m652i(this.f16538V.getCheckDialogRenewAgreement());
        c0079a.m651h(new C3623j());
        ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(this, c0079a);
        confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
        confirmRenewAgreementDialog.show();
        return true;
    }

    /* renamed from: D7 */
    public final void m23333D7() {
        this.f16918O1 = (ImageView) C12809f.m76829b(this, R$id.main_viewpage_left_iv);
        this.f16921P1 = (ImageView) C12809f.m76829b(this, R$id.main_viewpage_right_iv);
        this.f16918O1.setOnClickListener(this);
        this.f16921P1.setOnClickListener(this);
    }

    /* renamed from: D8 */
    public final void m23334D8(ViewPager viewPager) throws Resources.NotFoundException {
        int iM23469b;
        GradePackageCardView gradePackageCardView;
        if (viewPager == null) {
            return;
        }
        AbstractC0984a adapter = viewPager.getAdapter();
        if (adapter instanceof C3625l) {
            C3625l c3625l = (C3625l) adapter;
            String str = this.f16560g0;
            if (!TextUtils.isEmpty(this.f16956f4)) {
                str = this.f16957g4;
            }
            this.f16955e4 = null;
            this.f16956f4 = null;
            this.f16957g4 = null;
            if (this.f16965k4) {
                iM23469b = c3625l.m23470c(this.f16560g0, this.f16967l4);
                this.f16965k4 = false;
            } else if (this.f16977q4) {
                iM23469b = c3625l.m23470c(this.f16560g0, this.f16967l4);
                this.f16977q4 = false;
            } else {
                iM23469b = !TextUtils.isEmpty(str) ? c3625l.m23469b(str) : -1;
            }
            if (iM23469b == -1) {
                iM23469b = c3625l.m23468a();
            }
            if (iM23469b == -1) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "no recommend grade");
                return;
            }
            viewPager.setCurrentItem(iM23469b);
            m23323A6(iM23469b, this.f16933T3.getCount());
            List<GradePackageCardView> listM23471d = c3625l.m23471d();
            if (listM23471d == null || listM23471d.isEmpty() || (gradePackageCardView = listM23471d.get(iM23469b)) == null) {
                return;
            }
            gradePackageCardView.m23580q();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 16));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: E5 */
    public void mo22760E5(QueryPushGuideRsp queryPushGuideRsp) {
        if (m23467z9(queryPushGuideRsp)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "no show");
            return;
        }
        HicloudPushGuidPopConfig popConfig = HicloudPushGuideManager.getInstance().getPopConfig();
        if (popConfig == null) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "hicloudpushguideconfig is null");
            return;
        }
        if (!HicloudPushGuideManager.getInstance().checkPopTimes()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "over poptimes");
            return;
        }
        String[] currentContentString = HicloudPushGuideManager.getInstance().getCurrentContentString();
        if (currentContentString.length == 0) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "dialog ContentString is null");
            return;
        }
        String str = currentContentString[0];
        String str2 = currentContentString[1];
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "dialog current string is null");
            return;
        }
        String giftPackageMode = popConfig.getGiftPackageMode();
        C11839m.m70686d("CloudSpaceUpgradeActivity", "pushguide giftPackageMode:" + giftPackageMode);
        if (!TextUtils.equals(giftPackageMode, "1")) {
            m23423l9(str, str2, "");
            return;
        }
        UserPackage userPackage = this.f21452m;
        if (userPackage == null || userPackage.getUserPayType() != 0) {
            C11839m.m70686d("CloudSpaceUpgradeActivity", "pushguide,usertype is not free");
            m23423l9(str, str2, "");
        } else {
            C11839m.m70686d("CloudSpaceUpgradeActivity", "pushguide,usertype is free");
            C9713b.m60566c().m60569d(this.f16524O, NoticeWithActivityUtil.checkRecommendActivityTypeForPushGuide(), 2, true);
        }
    }

    /* renamed from: E6 */
    public final boolean m23335E6() {
        MemGradeRights gradeRights;
        UserPackage userPackage = this.f21452m;
        if (userPackage == null || (gradeRights = userPackage.getGradeRights()) == null) {
            return false;
        }
        m23326B6();
        if (gradeRights.getGradeType() != 9 || !m28589p1()) {
            this.f16503D0 = 0;
            return false;
        }
        Filter filter = new Filter();
        filter.setShowPlace(2);
        C9158a.m57503F().m57558w(this.f16524O, filter, null, m22886w2(true), false, true);
        this.f16568o0 = null;
        return true;
    }

    /* renamed from: E7 */
    public final boolean m23336E7(FilterAvailabalGradePackage filterAvailabalGradePackage) {
        if (filterAvailabalGradePackage.getBasicPackageList() != null && !filterAvailabalGradePackage.getBasicPackageList().isEmpty()) {
            return true;
        }
        if (filterAvailabalGradePackage.getIncrementList() == null || filterAvailabalGradePackage.getIncrementList().isEmpty()) {
            return (filterAvailabalGradePackage.getMonthlyPackageList() == null || filterAvailabalGradePackage.getMonthlyPackageList().isEmpty()) ? false : true;
        }
        return true;
    }

    /* renamed from: E8 */
    public final void m23337E8() {
        RelativeLayout relativeLayout = this.f16982t1;
        if (relativeLayout == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "actionBarBackgrond is null");
            return;
        }
        if (this.f16988w1 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "actionbarAddHeight is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f16988w1.getLayoutParams();
        int iM70789a0 = ((!C11842p.m70753O0(this) || C11842p.m70771U0()) && C12806c.m76815f(this)) ? C11842p.m70789a0(this) + C11842p.m70852q(this) : C11842p.m70852q(this);
        layoutParams.height = iM70789a0;
        layoutParams2.height = iM70789a0;
        this.f16982t1.setLayoutParams(layoutParams);
        this.f16988w1.setLayoutParams(layoutParams2);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 16));
    }

    /* renamed from: F6 */
    public final void m23338F6() {
        this.f16973o4 = false;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        safeIntent.putExtra("enter", "");
        setIntent(safeIntent);
        m23340F8();
    }

    /* renamed from: F7 */
    public final boolean m23339F7() {
        if (this.f16538V == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , params is null.");
            return false;
        }
        if (this.f21452m == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , user is null.");
            return false;
        }
        if (this.f16540W == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , availablePackages is null.");
            return false;
        }
        if (this.f16530R == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , cardSupportResp is null.");
            return false;
        }
        if (this.f16546Z == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , register is null.");
            return false;
        }
        if (C11829c.m70626w0() && this.f16550b0 == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , mFamilyShareInfoResult is null.");
            return false;
        }
        if (this.f16567n0 == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , gradeRightDetailResp is null.");
            return false;
        }
        if (this.f16535T0 != null) {
            return true;
        }
        C1442a.m8289e("CloudSpaceUpgradeActivity", "data no prepare ok ,showView voucherList is null.");
        return false;
    }

    /* renamed from: F8 */
    public final void m23340F8() {
        if (this.f16901I3 == null) {
            this.f16901I3 = (TextView) C12809f.m76829b(this, R$id.title);
        }
        if (C13452e.m80781L().m80887a1()) {
            C12809f.m76840m(this.f16901I3, R$string.full_data_service);
        } else {
            C12809f.m76840m(this.f16901I3, R$string.cloudpay_upgrade_storage);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 16));
    }

    /* renamed from: G6 */
    public final void m23341G6() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "clearSpecPkgPushInfo");
        this.f16544Y = false;
        this.f21457r = null;
        ArrayList<FilterAvailabalGradePackage> arrayList = this.f16542X;
        if (arrayList != null) {
            arrayList.clear();
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        safeIntent.putExtra("specified_pkg_id_key", "");
        setIntent(safeIntent);
    }

    /* renamed from: G7 */
    public final boolean m23342G7() {
        if (!m23345H7()) {
            return false;
        }
        if (this.f16538V == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , params is null.");
            return false;
        }
        if (this.f21452m == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , user is null.");
            return false;
        }
        if (C11829c.m70626w0() && this.f16550b0 == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , mFamilyShareInfoResult is null.");
            return false;
        }
        Response response = this.f16530R;
        if (response == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , cardSupportResp is null.");
            return false;
        }
        if (response.getResultCode() == 0 && this.f16538V.getPromotionCardTitle() != null && !this.f16538V.getPromotionCardTitle().isEmpty()) {
            return true;
        }
        C1442a.m8288d("CloudSpaceUpgradeActivity", " card no support.");
        m23338F6();
        mo19460T3();
        return false;
    }

    /* renamed from: G8 */
    public final void m23343G8(int i10) {
        if (this.f16980s1 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "actionBarLayout is null");
            return;
        }
        if (getActionBar() == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getActionBar is null");
            return;
        }
        int iM70840n = C11842p.m70840n(this, 30);
        if (iM70840n == 0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "headerHeight is zero");
            return;
        }
        float fMin = Math.min(Math.max(i10, 0), iM70840n) / iM70840n;
        this.f16951c4 = fMin;
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            this.f16982t1.setAlpha(fMin);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f16986v1);
        C11842p.m70823i2(this.f16903J1, C11842p.m70840n(this, 0));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo");
        if (this.f16991x3) {
            this.f16991x3 = false;
        }
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.SPACE_UPDATE_GET_SPACE_INFO, "isFisrtProc= " + this.f16992x4);
        if (this.f16992x4) {
            this.f16992x4 = false;
            C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudSpaceUpgradeActivity"), false);
        }
        if (m23345H7()) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo isFromHuaWeiCard");
            C9158a.m57503F().m57518P(this.f16524O, this.f21448i);
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
            C9158a.m57503F().m57504A(this.f16524O, this.f21448i);
            C9158a.m57503F().m57517O(this.f16524O, this.f21448i, true, true, "CloudSpaceUpgradeActivity");
            if (C11829c.m70626w0()) {
                C9158a.m57503F().m57506C(this.f16524O, false);
                return;
            }
            return;
        }
        if (this.f16525O0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo isFromH5Pay");
            if (TextUtils.isEmpty(this.f16945Z3)) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "getSpaceInfo h5PackageId is empty.");
                m23408f9(19);
                return;
            }
            Filter filter = new Filter();
            filter.setPackageId(this.f16945Z3);
            C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudSpaceUpgradeActivity");
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
            C9158a.m57503F().m57557v(this.f16524O, filter, null, m22882v2(), false);
            if (C11829c.m70626w0()) {
                C9158a.m57503F().m57506C(this.f16524O, false);
                return;
            }
            return;
        }
        if (this.f16531R0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo isFromPushGuide");
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
            C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudSpaceUpgradeActivity");
            return;
        }
        if (this.f16527P0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo isBackupDialogPay");
            m23386Y6(bundle);
            return;
        }
        if (this.f16543X0) {
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
            C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudSpaceUpgradeActivity");
            C9158a.m57503F().m57531b(this.f16524O, this.f21448i, this.f16545Y0);
        } else if (this.f16521M0) {
            C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudSpaceUpgradeActivity");
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        } else {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getSpaceInfo normal");
            m23386Y6(bundle);
        }
    }

    /* renamed from: H6 */
    public final void m23344H6() {
        if (TextUtils.isEmpty(this.f16990x1)) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "taskCenterUrl null");
            return;
        }
        this.f16879B1.setVisibility(8);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("mecloud_click_task_center", linkedHashMap);
        try {
            C11839m.m70686d("CloudSpaceUpgradeActivity", "taskCenterUrl: " + this.f16990x1);
            Intent dlAppWebViewIntent = NotifyUtil.getDlAppWebViewIntent(this, this.f16990x1);
            dlAppWebViewIntent.setFlags(805306368);
            startActivity(dlAppWebViewIntent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "taskCenter click: " + e10.toString());
        }
    }

    /* renamed from: H7 */
    public final boolean m23345H7() {
        Bundle extras = new SafeIntent(getIntent()).getExtras();
        if (extras != null) {
            String string = extras.getString("enter");
            if (!TextUtils.isEmpty(string) && string.equals("HuaweiCard")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: H8 */
    public final void m23346H8(long j10, long j11) {
        this.f16976q1.setText(C0223k.m1529l(C11290m.m67752m(this, j10, j11)));
        m23382V8(j10, j11);
    }

    @Override // com.huawei.android.hicloud.p088ui.uilistener.BannerShowRegionListener
    /* renamed from: I */
    public void mo23347I(boolean z10) {
        this.f16981s4 = z10;
        if (m22813Y3()) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "show Banner region is can buy worry");
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showBannerRegion,isShowBanner:" + this.f16981s4 + ",isExistSpecifiedPkgPush:" + this.f16544Y);
        if (!z10 || this.f16544Y) {
            this.f16880B3.setVisibility(8);
        } else {
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("banner_ids", this.f16886D3.m24109h());
            linkedHashMapM79499C.put("banner_percentages", this.f16886D3.m24110i());
            C13227f.m79492i1().m79591l0("mecloud_main_show_banner", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "mecloud_main_show_banner", "1", "35", linkedHashMapM79499C);
            this.f16880B3.setVisibility(0);
        }
        m23413h8();
    }

    /* renamed from: I6 */
    public final void m23348I6() {
        try {
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
            if (wrapContentHeightViewPager == null || wrapContentHeightViewPager.getCurrentItem() <= 0) {
                return;
            }
            this.f16906K1.setCurrentItem(r0.getCurrentItem() - 1);
            m23416i8();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "clickViewPageLeftImageView out of count : " + e10.toString());
        }
    }

    /* renamed from: I7 */
    public final boolean m23349I7() {
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog = this.f16505E0;
        return memberQuitFamilyShareDialog != null && memberQuitFamilyShareDialog.isShowing();
    }

    /* renamed from: I8 */
    public void m23350I8(GradeCardBaseResourceBean gradeCardBaseResourceBean, boolean z10) {
        if (gradeCardBaseResourceBean == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "setCardResource failed resourceBean is null");
            return;
        }
        if (getResources() == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "setCardResource failed resource is null");
            return;
        }
        this.f16958h1.setImageDrawable(gradeCardBaseResourceBean.getVipCardBg());
        int boldTextColor = gradeCardBaseResourceBean.getBoldTextColor();
        this.f16972o1.setTextColor(boldTextColor);
        this.f16970n1.setTextColor(boldTextColor);
        this.f16976q1.setTextColor(gradeCardBaseResourceBean.getNormalTextColor());
        m23358L8(gradeCardBaseResourceBean, z10);
        int mediumTextColor = gradeCardBaseResourceBean.getMediumTextColor();
        this.f16974p1.setTextColor(mediumTextColor);
        C11842p.m70835l2(this, mediumTextColor, this.f16974p1);
        this.f16960i1.setProgressDrawable(gradeCardBaseResourceBean.getProcessBarDrawable());
        if (C13452e.m80781L().m80838O0()) {
            return;
        }
        this.f16914M4.setBackground(gradeCardBaseResourceBean.getDrawable(R$drawable.ic_petalone));
        this.f16914M4.setImageTintList(ColorStateList.valueOf(gradeCardBaseResourceBean.getPetalOneTextColor()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: J3 */
    public void mo22774J3() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "handleAdUpdate");
        BannerFragment bannerFragment = this.f16886D3;
        if (bannerFragment != null) {
            bannerFragment.m24114m();
        }
    }

    /* renamed from: J6 */
    public final void m23351J6() {
        try {
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
            if (wrapContentHeightViewPager == null || wrapContentHeightViewPager.getCurrentItem() >= this.f16933T3.getCount() - 1) {
                return;
            }
            WrapContentHeightViewPager wrapContentHeightViewPager2 = this.f16906K1;
            wrapContentHeightViewPager2.setCurrentItem(wrapContentHeightViewPager2.getCurrentItem() + 1);
            m23416i8();
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "clickViewPageRightImageView out of count : " + e10.toString());
        }
    }

    /* renamed from: J7 */
    public final void m23352J7() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C11839m.m70689w("CloudSpaceUpgradeActivity", "jumpToDownLoadPage, sysParamMap is null!");
            return;
        }
        NewBusinessModelConfigBean newBusinessModelConfigBean = (NewBusinessModelConfigBean) C10527a.m64629g(hiCloudSysParamMapM60758q.getNewBusinessModelConfig(), NewBusinessModelConfigBean.class);
        if (newBusinessModelConfigBean == null || TextUtils.isEmpty(newBusinessModelConfigBean.getUserBenefitsPage())) {
            C11839m.m70689w("CloudSpaceUpgradeActivity", "jumpToDownLoadPage configBean or dataDownloadPage is null");
        } else {
            C11273b.m67658m(this, newBusinessModelConfigBean.getUserBenefitsPage(), new SafeIntent(new Intent()), getPackageName());
        }
    }

    /* renamed from: J8 */
    public final void m23353J8(final GradeCardBaseResourceBean gradeCardBaseResourceBean, final boolean z10) {
        this.f16978r1.setCustomTextViewCallBack(new TextBannerSwitcher.CustomTextViewCallBack() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.p
            @Override // com.huawei.android.hicloud.ui.extend.TextBannerSwitcher.CustomTextViewCallBack
            /* renamed from: a */
            public final TextView mo23906a() {
                return this.f17563a.m23370Q7(z10, gradeCardBaseResourceBean);
            }
        });
    }

    /* renamed from: K6 */
    public final void m23354K6() {
        if (this.f16905J4) {
            this.f16899H4.setBackground(getDrawable(R$drawable.renew_check_icon_off));
            this.f16905J4 = false;
        } else {
            this.f16899H4.setBackground(getDrawable(R$drawable.renew_check_icon_on));
            this.f16905J4 = true;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("renew_checkbox_status", String.valueOf(this.f16905J4));
        linkedHashMap.put("way_of_purchase", "upgrade_purchase");
        m22842j4("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMap);
    }

    /* renamed from: K7 */
    public final /* synthetic */ boolean m23355K7(TextOnClickTextView textOnClickTextView, GradeCardBaseResourceBean gradeCardBaseResourceBean) {
        Layout layout = textOnClickTextView.getLayout();
        if (layout == null) {
            return true;
        }
        int lineCount = layout.getLineCount() - 1;
        int ellipsisCount = layout.getEllipsisCount(lineCount);
        int lineEnd = layout.getLineEnd(lineCount);
        if (ellipsisCount == 0) {
            return true;
        }
        String strTrim = textOnClickTextView.getText().toString().trim();
        int length = ((lineEnd - ellipsisCount) - getString(R$string.payment_manager_button).length()) - 3;
        if (length < 0) {
            return true;
        }
        textOnClickTextView.setText(m23454w6(gradeCardBaseResourceBean, strTrim.substring(0, length) + "...", true));
        return false;
    }

    /* renamed from: L6 */
    public final void m23356L6() throws JSONException {
        GetAvailableGradePackagesResp getAvailableGradePackagesResp = this.f16568o0;
        if (getAvailableGradePackagesResp == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "worryFreePackage is null");
            return;
        }
        List<PackageGrades> packageGrades = getAvailableGradePackagesResp.getPackageGrades();
        List<CloudPackage> spacePackages = this.f16568o0.getSpacePackages();
        if (spacePackages == null || spacePackages.size() < 1) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "available packages is null or empty");
            return;
        }
        if (packageGrades == null || packageGrades.size() < 1) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "available packages is null or empty");
            return;
        }
        CloudPackage cloudPackageM23403e7 = m23403e7(spacePackages);
        PackageGrades packageGrades2 = packageGrades.size() > 0 ? packageGrades.get(0) : null;
        if (cloudPackageM23403e7 == null || packageGrades2 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "packageGrade is null");
            return;
        }
        C13227f.m79492i1().m79585f0("action_code_click_worry_free_buy", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_upgrade_click_exchange", "1", "action_code_click_worry_free_buy");
        List<Voucher> voucherList = C11296s.m67839w(cloudPackageM23403e7, C11296s.m67837u(this.f16535T0, cloudPackageM23403e7, this.f21452m.getDeductAmount()), this.f21452m.getDeductAmount()).getVoucherList();
        if (m23332D6(voucherList, cloudPackageM23403e7, packageGrades2)) {
            return;
        }
        m23465y9(voucherList, cloudPackageM23403e7, packageGrades2);
    }

    /* renamed from: L7 */
    public final /* synthetic */ SpannableStringBuilder m23357L7(GradeCardBaseResourceBean gradeCardBaseResourceBean, CharSequence charSequence) {
        return m23454w6(gradeCardBaseResourceBean, charSequence, true);
    }

    /* renamed from: L8 */
    public final void m23358L8(GradeCardBaseResourceBean gradeCardBaseResourceBean, final boolean z10) {
        List<CharSequence> list = (List) this.f21452m.getEffectivePackages().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.y
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudSpaceUpgradeActivity.m23279R7(z10, (CloudSpace) obj);
            }
        }).map(new Function() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17580a.m23374S7((CloudSpace) obj);
            }
        }).filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.a0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudSpaceUpgradeActivity.m23284T7((SpannableString) obj);
            }
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            list.add(new SpannableString(getString(R$string.free_member_tip)));
        }
        this.f16978r1.m24031n(m23458x6(gradeCardBaseResourceBean, list));
    }

    /* renamed from: M6 */
    public final void m23359M6() {
        AlertDialog alertDialog = this.f16943Y3;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f16943Y3.dismiss();
    }

    /* renamed from: M7 */
    public final /* synthetic */ GradePackageCardView m23360M7(CloudSpace cloudSpace, FilterAvailabalGradePackage filterAvailabalGradePackage) {
        if (filterAvailabalGradePackage == null || !m23336E7(filterAvailabalGradePackage)) {
            return null;
        }
        GradePackageCardView gradePackageCardView = new GradePackageCardView(this);
        boolean z10 = !TextUtils.isEmpty(this.f16928R3) && this.f16928R3.equals(filterAvailabalGradePackage.getGradeCode());
        List<CloudPackage> incrementList = filterAvailabalGradePackage.getIncrementList();
        if (incrementList != null && incrementList.size() == 1 && cloudSpace != null && cloudSpace.getIsAutoPay() == 1 && cloudSpace.getDurationMonth() == 1 && incrementList.get(0).getDurationMonth() == 12) {
            CloudPackage cloudPackage = new CloudPackage();
            cloudPackage.setCapacity(cloudSpace.getCapacity());
            cloudPackage.setCurrency(cloudSpace.getCurrency());
            cloudPackage.setDurationMonth(cloudSpace.getDurationMonth());
            cloudPackage.setDurationUnit(cloudSpace.getDurationUnit());
            cloudPackage.setId(cloudSpace.getId());
            cloudPackage.setPackageTitle(cloudSpace.getPackageTitle());
            cloudPackage.setPrice(cloudSpace.getPrice());
            cloudPackage.setSpPrice(cloudSpace.getSpPrice());
            cloudPackage.setSymbol(cloudSpace.getSymbol());
            cloudPackage.setProductType(cloudSpace.getType());
            cloudPackage.setProductName(cloudSpace.getProductName());
            cloudPackage.setEffectEndTime(cloudSpace.getEndTime());
            cloudPackage.setRemark3(cloudSpace.getRemark());
            incrementList.add(0, cloudPackage);
            gradePackageCardView.setIsHasWorryFreeMonth(true);
        }
        gradePackageCardView.setUser(this.f21452m);
        if (!C11296s.m67787K() || !C11296s.m67789M(this)) {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f16538V, false, z10, this.f16535T0, null, null, true, this.f21452m.getDeductAmount(), this);
        } else if (this.f16955e4 != null && !TextUtils.isEmpty(this.f16956f4)) {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f16538V, false, z10, this.f16535T0, this.f16956f4, this.f16955e4.getVoucherCode(), true, this.f21452m.getDeductAmount(), this);
        } else if (this.f16965k4) {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f16538V, false, z10, this.f16535T0, this.f16969m4, null, true, this.f21452m.getDeductAmount(), this);
        } else {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f16538V, false, z10, this.f16535T0, null, null, true, this.f21452m.getDeductAmount(), this);
        }
        return gradePackageCardView;
    }

    /* renamed from: M8 */
    public final void m23361M8(List<MemGradeRight> list, final String str) {
        if (list.isEmpty()) {
            this.f16974p1.setVisibility(8);
            return;
        }
        int size = list.size();
        this.f16974p1.setText(getResources().getQuantityString(R$plurals.right_effect_number_tip, size, Integer.valueOf(size)));
        this.f16974p1.setVisibility(0);
        this.f16974p1.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17575a.m23378U7(str, view);
            }
        });
    }

    /* renamed from: N6 */
    public final PackageGrades m23362N6(AcceptSignGiftInfo acceptSignGiftInfo) {
        PackageGrades packageGrades = new PackageGrades();
        PackageGrade packageGrade = acceptSignGiftInfo.getPackageGrade();
        if (packageGrade == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "createPackageGrade packageGrade is null.");
            return packageGrades;
        }
        MemGradeRights gradeRights = acceptSignGiftInfo.getGradeRights();
        if (gradeRights == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "createPackageGrade memGradeRights is null.");
            return packageGrades;
        }
        packageGrades.setCapacity(gradeRights.getCapacity().longValue());
        packageGrades.setGradeCode(packageGrade.getGradeCode());
        packageGrades.setGradeName(packageGrade.getGradeName());
        packageGrades.setRecommended(0);
        return packageGrades;
    }

    /* renamed from: N7 */
    public final /* synthetic */ void m23363N7(ScrollView scrollView, int i10, int i11, int i12, int i13) {
        m23343G8(i11);
    }

    /* renamed from: N8 */
    public final void m23364N8(boolean z10, boolean z11) {
        if ((z10 && z11) || !C13843a.m83067S()) {
            this.f16914M4.setImageDrawable(null);
        } else if (z10 && !C13452e.m80781L().m80887a1()) {
            this.f16914M4.setImageResource(R$drawable.ic_petalone_text);
        }
        if (z10) {
            this.f16914M4.setRotationY(C11842p.m70765S0() ? 180.0f : 0.0f);
        } else {
            m23365O8(this.f16914M4);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O3 */
    public void mo19452O3(Message message) {
        if (message == null) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "handleH5ConfigUpdate msg null");
            return;
        }
        int i10 = message.arg1;
        C11839m.m70688i("CloudSpaceUpgradeActivity", "handleH5ConfigUpdate " + i10);
        if (i10 == 1006) {
            m23463y7(this.f16975p4);
        } else if (i10 == 1002) {
            m23459x7();
            m23444t7();
        }
    }

    /* renamed from: O8 */
    public final void m23365O8(ImageView imageView) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            imageView.setBackground(null);
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: P */
    public void mo23180P(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        this.f16557e1 = true;
        m22820a5(m22848m2(cloudPackage, packageGrades, list, reportVoucherInfo, agreementDlgCallback));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: P2 */
    public void mo22789P2(Object obj) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "dealGetAcountHeadPicSuccess");
        if (obj == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetAcountHeadPicSuccess object is null.");
        } else if (obj instanceof Bitmap) {
            m23311m8((Bitmap) obj);
        } else {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetAcountHeadPicSuccess object is not bitmap.");
        }
    }

    /* renamed from: P6 */
    public final void m23366P6(boolean z10) {
        if (z10) {
            this.f16918O1.setVisibility(8);
            this.f16921P1.setVisibility(8);
        }
    }

    /* renamed from: P7 */
    public final /* synthetic */ void m23367P7(View view) {
        m23412h7();
    }

    /* renamed from: P8 */
    public final void m23368P8(boolean z10) throws Resources.NotFoundException {
        C1442a.m8291w("CloudSpaceUpgradeActivity", "setMagrinMoreLayout" + z10);
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_48_dp);
        if (!z10) {
            m23384W8(this.f16910L3, 0);
        } else {
            if (m23397c7(this.f16910L3) > 0) {
                return;
            }
            C1442a.m8291w("CloudSpaceUpgradeActivity", "setMagrinMoreLayout");
            m23384W8(this.f16910L3, dimensionPixelSize);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q2 */
    public void mo19455Q2(int i10) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "dealGetAvailableGradePackagesFail Fail code = " + i10);
        if (this.f16553c1) {
            m22831e5();
            return;
        }
        if (i10 == 19) {
            m23408f9(19);
            return;
        }
        if (i10 == 21) {
            m23408f9(21);
            return;
        }
        if (i10 == 26) {
            m23408f9(26);
        } else if (i10 != 120) {
            mo19477k5();
        } else {
            m23408f9(120);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q3 */
    public void mo22792Q3(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "handleMouthAgreement host is null");
            return;
        }
        m23393a9(str + "/payagreement?lang=" + C0234s.m1627e());
        m23435q8(false);
    }

    /* renamed from: Q6 */
    public final boolean m23369Q6(MemGradeRights memGradeRights, CloudSpace cloudSpace) throws Resources.NotFoundException {
        String gradeCode = memGradeRights.getGradeCode();
        ArrayList<FilterAvailabalGradePackage> arrayList = this.f16540W;
        boolean z10 = arrayList != null && (arrayList.size() == 0 || this.f16540W.get(0).getIncrementList() == null || (this.f16540W.get(0).getIncrementList() != null && this.f16540W.get(0).getIncrementList().size() == 0));
        if (memGradeRights.getGradeType() == 9 && z10 && m28589p1()) {
            GetGradeRightDetailResp getGradeRightDetailResp = this.f16567n0;
            if (getGradeRightDetailResp == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "GetGradeRightDetailResp is null");
                m23399c9();
                return false;
            }
            MemGradeRightDetails gradeRights = getGradeRightDetailResp.getGradeRights();
            if (gradeRights == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "memGradeRightDetails is null");
                m23399c9();
                return false;
            }
            m23405e9(gradeRights, gradeRights.getGradeCode(), cloudSpace);
            m23366P6(true);
            this.f16935U3.setVisibility(8);
            this.f16953d4 = true;
            return false;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "current level is : " + gradeCode);
        m23366P6(false);
        this.f16893F4.setVisibility(8);
        ArrayList<FilterAvailabalGradePackage> arrayList2 = this.f16540W;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f16924Q1 = m23451v7(this.f16540W);
            this.f16927R1 = m23451v7(this.f16542X);
            if (this.f16933T3 != null) {
                m23323A6(this.f16971n4, m23380V6().size());
            }
            m23411g9();
        } else if (C11296s.m67795S()) {
            m23425m9();
        } else {
            m23399c9();
        }
        this.f16953d4 = false;
        return true;
    }

    /* renamed from: Q7 */
    public final /* synthetic */ TextView m23370Q7(boolean z10, GradeCardBaseResourceBean gradeCardBaseResourceBean) {
        TextOnClickTextView textOnClickTextView = new TextOnClickTextView(this);
        textOnClickTextView.setEllipsize(TextUtils.TruncateAt.END);
        textOnClickTextView.setBreakStrategy(0);
        textOnClickTextView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17566a.m23367P7(view);
            }
        });
        if (z10) {
            m23450v6(gradeCardBaseResourceBean, textOnClickTextView);
        }
        return textOnClickTextView;
    }

    /* renamed from: Q8 */
    public final void m23371Q8(boolean z10) throws Resources.NotFoundException {
        C1442a.m8291w("CloudSpaceUpgradeActivity", "setMagrinTaskCenterLayout " + z10);
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.cloud_space_48_dp);
        if (!z10) {
            m23384W8(this.f16907K3, 0);
        } else {
            if (m23397c7(this.f16907K3) > 0) {
                return;
            }
            m23384W8(this.f16907K3, dimensionPixelSize);
        }
    }

    /* renamed from: R6 */
    public final void m23372R6(MemGradeRightDetail memGradeRightDetail, CloudSpace cloudSpace) {
        String str;
        Map i18ResourceMap = memGradeRightDetail.getI18ResourceMap();
        if (i18ResourceMap == null || (str = (String) i18ResourceMap.get("diamondDesc2")) == null || !str.contains("%s") || cloudSpace == null) {
            return;
        }
        i18ResourceMap.put("diamondDesc2", cloudSpace.getIsAutoPay() == 0 ? (String) i18ResourceMap.get("diamondDesc") : str.replaceAll("%s", C11290m.m67743d(this, cloudSpace.getEndTime())));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        if (C11296s.m67786J(this)) {
            return false;
        }
        C11829c.m70612r1(this);
        return true;
    }

    /* renamed from: S6 */
    public final List<MemGradeRightDetail> m23373S6(List<MemGradeRightDetail> list, CloudSpace cloudSpace) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (MemGradeRightDetail memGradeRightDetail : list) {
                if (memGradeRightDetail.getStatus() == 1) {
                    arrayList.add(memGradeRightDetail);
                    if ("FRW".equals(memGradeRightDetail.getRightCode())) {
                        m23372R6(memGradeRightDetail, cloudSpace);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "initData");
        if (this.f16889E3.getVisibility() == 0) {
            this.f16889E3.m23914a();
        }
        if (!C11296s.m67786J(this)) {
            m23307j9();
            return;
        }
        this.f16540W = null;
        this.f16542X = null;
        this.f21452m = null;
        this.f16530R = null;
        this.f16538V = null;
        this.f16546Z = null;
        this.f16550b0 = null;
        this.f16567n0 = null;
        this.f16947a4 = null;
        this.f16535T0 = null;
        this.f16571r0 = null;
        this.f16570q0 = null;
        this.f16897H1 = false;
        this.f16929R4 = false;
        this.f16547Z0 = null;
        this.f16568o0 = null;
        this.f16503D0 = 0;
        mo19474g5();
        m28588o1("06008");
        m23290X6();
        C13612b.m81829B().m81848K(this.f16524O);
        C1398a.m8004D(false);
        RecommendCardManager.getInstance().clearAds(RecommendCardConstants.Entrance.BUY);
    }

    /* renamed from: T6 */
    public void m23375T6() {
        if (!this.f16985u4) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "not fromFrontAcceptNotify");
        } else if (C11829c.m70530L0()) {
            C9158a.m57503F().m57552q(this.f16524O, null, 2);
        } else {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "not support activity");
        }
    }

    /* renamed from: T8 */
    public final void m23376T8() {
        View viewM76829b = C12809f.m76829b(this, R.id.content);
        if (viewM76829b instanceof ViewGroup) {
            View childAt = ((ViewGroup) viewM76829b).getChildAt(0);
            if (childAt == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "root view is null");
                return;
            }
            childAt.setFocusable(true);
            childAt.setFocusableInTouchMode(true);
            childAt.requestFocus();
            childAt.requestFocusFromTouch();
            childAt.setDefaultFocusHighlightEnabled(false);
        }
    }

    /* renamed from: U6 */
    public int m23377U6() {
        float f10 = this.f16995y4;
        return (f10 < 1.75f || f10 >= 2.0f) ? (f10 < 2.0f || f10 >= 3.2f) ? f10 >= 3.2f ? R$layout.pay_upgrade_cloudspace_member_activity_3dot2 : R$layout.pay_upgrade_cloudspace_member_activity : R$layout.pay_upgrade_cloudspace_member_activity_2 : R$layout.pay_upgrade_cloudspace_member_activity_1dot75;
    }

    /* renamed from: U7 */
    public final /* synthetic */ void m23378U7(String str, View view) {
        m23415i7(str);
    }

    /* renamed from: U8 */
    public final boolean m23379U8() {
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog;
        if (C11829c.m70626w0()) {
            FamilyShareInfoResult familyShareInfoResult = this.f16550b0;
            if (familyShareInfoResult == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "setShowStopMFamilyShare mFamilyShareInfoResult is null.");
                mo19477k5();
                return false;
            }
            boolean zM64302l = C10465b.m64302l(familyShareInfoResult);
            C1442a.m8290i("CloudSpaceUpgradeActivity", "setShowStopMFamilyShare isMember = " + zM64302l);
            if (zM64302l) {
                if (!isFinishing() && (memberQuitFamilyShareDialog = this.f16505E0) != null && memberQuitFamilyShareDialog.isShowing()) {
                    this.f16505E0.dismiss();
                }
                this.f16505E0 = null;
                MemberQuitFamilyShareDialog memberQuitFamilyShareDialog2 = new MemberQuitFamilyShareDialog(this, this.f16521M0);
                this.f16505E0 = memberQuitFamilyShareDialog2;
                memberQuitFamilyShareDialog2.setCanceledOnTouchOutside(false);
                this.f16505E0.showStopFamilyShareDialog();
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: V2 */
    public void mo22804V2(Object obj) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (obj instanceof GetAvailableGradePackagesResp) {
            this.f16947a4 = (GetAvailableGradePackagesResp) obj;
            mo19479s5();
        }
    }

    /* renamed from: V6 */
    public final List<GradePackageCardView> m23380V6() {
        return this.f16544Y ? this.f16927R1 : this.f16924Q1;
    }

    /* renamed from: V7 */
    public final /* synthetic */ void m23381V7(View view) {
        m23412h7();
    }

    /* renamed from: V8 */
    public final void m23382V8(long j10, long j11) {
        this.f16960i1.setMax(100);
        if (j10 <= 0) {
            this.f16960i1.setProgress(0);
        } else if (C11333k.m68086b().m68090e(j11 - j10)) {
            this.f16960i1.setProgress(100);
        } else {
            this.f16960i1.setProgress(Integer.min(99, Integer.max((int) ((j10 / j11) * 100.0f), 1)));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: W2 */
    public void mo22807W2(Object obj) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "dealGetLocalHeadPicSuccess");
        if (obj == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetLocalHeadPicSuccess object is null.");
        } else if (obj instanceof Bitmap) {
            m23311m8((Bitmap) obj);
        } else {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetLocalHeadPicSuccess object is not bitmap.");
        }
    }

    /* renamed from: W7 */
    public final /* synthetic */ void m23383W7(View view) {
        m23412h7();
    }

    /* renamed from: W8 */
    public final void m23384W8(RelativeLayout relativeLayout, int i10) {
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(i10);
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: X7 */
    public final /* synthetic */ void m23385X7(int i10, int i11, List list) throws Throwable {
        if (this.f16573t0 + i10 + list.size() >= this.f16572s0) {
            m23404e8(i11);
        } else {
            m23401d8(i11);
        }
    }

    /* renamed from: Y6 */
    public final void m23386Y6(Bundle bundle) {
        if (bundle == null) {
            mo19477k5();
            C1442a.m8289e("CloudSpaceUpgradeActivity", "getSpaceInfo userInfo is null.");
            return;
        }
        C9158a.m57503F().m57518P(this.f16524O, this.f21448i);
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, true);
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, true, true, "CloudSpaceUpgradeActivity");
        C9158a.m57503F().m57504A(this.f16524O, this.f21448i);
        C9158a.m57503F().m57552q(this.f16524O, null, 414);
        Filter filter = new Filter();
        filter.setShowPlace(2);
        Voucher voucher = this.f16955e4;
        m23418k7(filter, voucher != null ? voucher.getProductId() : null, new SafeIntent(getIntent()).getLongExtra("need_extra_space", 0L));
        if (C11829c.m70626w0()) {
            C9158a.m57503F().m57506C(this.f16524O, true);
        }
        m23398c8(bundle);
        m23375T6();
        C12515a.m75110o().m75172d(new C3032f2());
    }

    /* renamed from: Y7 */
    public final void m23387Y7(int i10) throws IllegalAccessException, JSONException, IllegalArgumentException, InvocationTargetException {
        if (i10 == R$id.back) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CloudSpaceUpgradeActivity", "onOtherClick back click too fast");
                return;
            } else {
                mo19541d5();
                return;
            }
        }
        if (i10 == R$id.rl_task_center) {
            m23344H6();
            return;
        }
        if (i10 == R$id.main_viewpage_left_iv) {
            m23348I6();
            return;
        }
        if (i10 == R$id.main_viewpage_right_iv) {
            m23351J6();
            return;
        }
        if (i10 == R$id.worry_free_card_buy_tv) {
            m23356L6();
        } else if (i10 == R$id.worry_card_renew_check_view) {
            m23354K6();
        } else {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "no click");
        }
    }

    /* renamed from: Y8 */
    public final void m23388Y8() {
        if (this.f16995y4 < 1.75f) {
            int iMin = (int) Float.min(this.f16970n1.getPaint().measureText(this.f16970n1.getText().toString()), getResources().getDimensionPixelOffset(R$dimen.vip_card_normal_font_size_user_name_mini_width));
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f16970n1.getLayoutParams();
            layoutParams.f2967R = iMin;
            this.f16970n1.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: Z6 */
    public final Drawable m23389Z6(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        if (C11842p.m70771U0()) {
            drawable.setBounds(0, 0, 23, 25);
        } else {
            drawable.setBounds(0, 0, 40, 40);
        }
        return drawable;
    }

    /* renamed from: Z8 */
    public final void m23390Z8() {
        if (this.f16906K1 == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "setViewPagerMargin, viewPager is null.");
            return;
        }
        List<GradePackageCardView> list = this.f16924Q1;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "setViewPagerMargin, packageViewList is null.");
            return;
        }
        if (m23380V6().size() != 1) {
            C11842p.m70733H1(this.f16906K1, C11842p.m70840n(this, 32));
        } else if (C11842p.m70753O0(this) || C11842p.m70771U0() || C11842p.m70747M0(this)) {
            C11842p.m70733H1(this.f16906K1, C11842p.m70840n(this, 0));
        } else {
            C11842p.m70733H1(this.f16906K1, C11842p.m70840n(this, 16));
        }
    }

    /* renamed from: a7 */
    public final Drawable m23391a7(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        if (C11842p.m70771U0()) {
            drawable.setBounds(0, 0, 25, 25);
        } else {
            drawable.setBounds(0, 0, 40, 40);
        }
        return drawable;
    }

    /* renamed from: a8 */
    public final void m23392a8(Intent intent) {
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            this.f21455p = safeIntent.getIntExtra("nav_source", 0);
            this.f21459t = safeIntent.getStringExtra("appId");
            this.f21460u = safeIntent.getStringExtra("packageName");
            this.f21461v = safeIntent.getStringExtra("user_tags_key");
            this.f21462w = safeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f);
            this.f16955e4 = (Voucher) m22746B3(safeIntent.getStringExtra("iap_intent_voucher_info"), Voucher.class);
            this.f16562i0 = safeIntent.getIntExtra("chosen_backup_frequency", 0);
            this.f16560g0 = safeIntent.getStringExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY);
            this.f16965k4 = safeIntent.getBooleanExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, false);
            this.f16977q4 = safeIntent.getBooleanExtra(HNConstants.PayIntentKey.IS_FROM_COUPON_CENTER_WELFARE_CARD, false);
            this.f16967l4 = safeIntent.getLongExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, -1L);
            this.f16969m4 = safeIntent.getStringExtra(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY);
            this.f16549a1 = safeIntent.getStringExtra("payResultType");
            this.f16551b1 = safeIntent.getStringExtra("payResultUrl");
            this.f16517K0 = safeIntent.getStringExtra("activityId");
            this.f16519L0 = safeIntent.getStringExtra(Constants.CONTENT_SERVER_REALM);
            this.f16555d1 = safeIntent.getStringExtra("verifyIsAutoPay");
            this.f16923P4 = safeIntent.getBooleanExtra("more_pkg", false);
            f16873T4 = safeIntent.getStringExtra("user_operation_text");
            f16874U4 = safeIntent.getStringExtra("user_operation_type");
            f16875V4 = safeIntent.getStringExtra("forOtherPage");
            C1442a.m8290i("CloudSpaceUpgradeActivity", "forOtherPage:" + f16875V4);
            if ("1".equals(this.f16549a1)) {
                this.f16553c1 = true;
                C10804r c10804r = f16872S4;
                if (c10804r != null) {
                    c10804r.m65763j("GET_SPACE_OK_H5_DIALOG");
                }
            }
            m23395b8(safeIntent);
            m23322z8();
        }
    }

    /* renamed from: a9 */
    public final void m23393a9(String str) {
        if (str == null) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "showAgreement url is null.");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        PackageManager packageManager = getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return;
        }
        startActivity(intent);
    }

    /* renamed from: b7 */
    public final SpannableString m23374S7(CloudSpace cloudSpace) {
        String strM67742c = C0209d.m1278l2("et") ? C11290m.m67742c(this, cloudSpace.getEndTime(), "dd.MM.yyyy") : C0209d.m1278l2(Constants.URDU_LANG) ? C11290m.m67742c(this, cloudSpace.getEndTime(), "dd/MM/yyyy") : C11290m.m67743d(this, cloudSpace.getEndTime());
        String string = getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1529l(cloudSpace.getScheme() == 2 ? cloudSpace.getProductName() : C0223k.m1524g(getApplicationContext(), cloudSpace.getCapacity())), cloudSpace.getIsAutoPay() == 1 ? getString(R$string.auto_pay_member_tip, strM67742c) : getString(R$string.accept_success_dialog_end_time_text, strM67742c));
        if (cloudSpace.getScheme() == 1) {
            string = getString(R$string.cloudpay_package_pace_use_detail, C0223k.m1529l("Petal One"), string);
        }
        SpannableString spannableString = new SpannableString("  " + string);
        if (C13452e.m80781L().m80838O0()) {
            Drawable drawableM23391a7 = cloudSpace.getPetalOneMemberType() == 1 ? m23391a7(R$drawable.petalone_enjoy) : cloudSpace.getPetalOneMemberType() == 2 ? m23391a7(R$drawable.petalone_preferential) : cloudSpace.getPetalOneMemberType() == 3 ? m23391a7(R$drawable.petalone_exclusive) : cloudSpace.getScheme() == 2 ? m23391a7(R$drawable.ic_incremental_space_sec) : m23389Z6(R$drawable.full_data_vip_icon);
            if (drawableM23391a7 != null) {
                spannableString.setSpan(new ImageSpan(drawableM23391a7, 0), 0, 1, 33);
            }
        }
        return spannableString;
    }

    /* renamed from: b8 */
    public final void m23395b8(SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("specified_pkg_id_key");
        if (TextUtils.isEmpty(stringExtra)) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "specifiedPkgId is empty");
            return;
        }
        String[] strArrSplit = stringExtra.split("_");
        if (strArrSplit.length < 1) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "specifiedPkgId is empty");
        } else {
            this.f21457r = strArrSplit;
        }
    }

    /* renamed from: b9 */
    public void m23396b9() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m23342G7()) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "showView huawei card failed");
        } else if (m23379U8()) {
            m23409g7();
        }
    }

    /* renamed from: c7 */
    public final int m23397c7(RelativeLayout relativeLayout) {
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return ((RelativeLayout.LayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    /* renamed from: c8 */
    public final void m23398c8(Bundle bundle) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "prepareShowAccountInfo");
        String string = bundle.getString("account_nick_name", null);
        if (this.f16970n1 == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "prepareShowAccountInfo mAccountNickName is null.");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "prepareShowAccountInfo nickName is null.");
            return;
        }
        if (!C10155f.m63293q(500L) || C13452e.m80781L().m80791C0()) {
            this.f16970n1.setText(C0209d.m1232a0(string));
            this.f16970n1.setTextSize(1, 21.0f);
        } else {
            this.f16970n1.setText(R$string.basic_full_data_service);
            this.f16970n1.setTextSize(1, 18.0f);
        }
        m23388Y8();
        C13452e.m80781L().m80949n2(string);
        String string2 = bundle.getString("account_head_pic_url", null);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getApplicationContext(), NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        String string3 = sharedPreferencesM1382b.getString("AccountInfoaccountPhotoUrl", null);
        C1442a.m8288d("CloudSpaceUpgradeActivity", "userPhotoUrl = " + string2 + " preUserPhotoUrl = " + string3 + " mUserPhotoBitmap = " + this.f16877A3);
        if ((!TextUtils.isEmpty(string2) && !string2.equals(string3)) || this.f16877A3 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "prepareShowAccountInfo prepare get new head photo.");
            sharedPreferencesM1382b.edit().putString("AccountInfoaccountPhotoUrl", string2).commit();
            C12515a.m75110o().m75172d(new GetUserAvatarTask((Handler) this.f16524O, string2, true));
            return;
        }
        if (!TextUtils.isEmpty(string2) || string3 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "prepareShowAccountInfo do not set image");
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "prepareShowAccountInfo use default photo.");
        sharedPreferencesM1382b.edit().putString("AccountInfoaccountPhotoUrl", string2).commit();
        Drawable drawable = getDrawable(R$drawable.img_defaultavatar_list_gray);
        this.f16962j1.setImageDrawable(drawable);
        this.f16964k1.setImageDrawable(drawable);
        C10809w.m65797a();
    }

    /* renamed from: c9 */
    public final void m23399c9() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showDefaultPackagesArea");
        LinearLayout linearLayout = this.f16892F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ListView listView = this.f16885D1;
        if (listView != null) {
            listView.setVisibility(8);
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager != null) {
            wrapContentHeightViewPager.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f16895G3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        ImageView imageView = this.f16918O1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.f16921P1;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f16935U3;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: d5 */
    public void mo19541d5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.f16929R4) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  isShowViewOk: false");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_isShowViewOk_return");
            onBackPressed();
            return;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  child account!");
            onBackPressed();
            return;
        }
        if (!C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE, "").equals(RecommendCardConstants.Entrance.BUY)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  !pageType.equals(QueryGuideH5Task.CAMPAIGNSOURCE_BUY)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_pageType_return");
            onBackPressed();
            return;
        }
        if (!C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE, "").equals("exit")) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  !sceneType.equals(QueryGuideH5Task.OPER_EXIT)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_sceneType_return");
            onBackPressed();
            return;
        }
        if (FrequencyManager.checkInValidTime(this, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5 CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE checkInValidTime true");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_checkInValidTime_return");
            onBackPressed();
            return;
        }
        int iM1357g = C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM, -1);
        String strM1363m = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL, "");
        if (TextUtils.isEmpty(strM1363m) || iM1357g == -1) {
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_h5Url_return_queryh5oknum: " + iM1357g);
            onBackPressed();
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  h5Url == null:  true");
            return;
        }
        int iM1357g2 = C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY, 1);
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  frequency: " + iM1357g2);
        if (!frequencyManager.checkGuideH5DialogFrequency(this, iM1357g2, -1, iM1357g2 == 0 ? C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL, 0) : 0)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "showGuidH5  checkGuideH5DialogFrequency:  false");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceUpgradeActivity_checkGuideH5DialogFrequency_return");
            finish();
            return;
        }
        String strM1363m2 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_ACTIVEURL, "");
        String strM1363m3 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_PACKAGEID, "");
        String strM1363m4 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYTYPE, "");
        String strM1363m5 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYURL, "");
        String strM1363m6 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, "check_guid_h5_dialog_update_data_gradeCode", "");
        String strM1363m7 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, "check_guid_h5_dialog_update_data_expireTime", "");
        if (iM1357g == 0) {
            m22764F5(iM1357g, strM1363m, strM1363m3, "", "", "", "", "");
            return;
        }
        if (iM1357g == 1) {
            m22764F5(iM1357g, strM1363m, "", "", "", strM1363m2, "", "");
            return;
        }
        if (iM1357g == 2) {
            m22764F5(iM1357g, strM1363m, "", strM1363m4, strM1363m5, "", "", "");
            return;
        }
        if (iM1357g == 3 || iM1357g == 4) {
            m22764F5(iM1357g, strM1363m, strM1363m3, strM1363m4, strM1363m5, strM1363m2, strM1363m6, strM1363m7);
        } else {
            if (iM1357g != 5) {
                return;
            }
            m22764F5(iM1357g, strM1363m, "", "", "", "", "", "");
        }
    }

    /* renamed from: d7 */
    public GradeCardBaseResourceBean m23400d7(String str) {
        if (str == null) {
            return new GradeCardDefaultResourceBean();
        }
        if (C13452e.m80781L().m80887a1()) {
            return C13452e.m80781L().m80834N0(str) ? new GradeCardDefaultResourceBean() : new GradeCardDiamondResourceBean();
        }
        int i10 = C3615b.f17002a[C11326d.m68044f(str).ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new GradeCardDefaultResourceBean() : new GradeCardDiamondResourceBean() : new GradeCardGoldResourceBean() : new GradeCardSilverResourceBean() : new GradeCardDefaultResourceBean();
    }

    /* renamed from: d8 */
    public final void m23401d8(int i10) throws Resources.NotFoundException {
        if (i10 != 1006) {
            m23431o8();
            return;
        }
        if (!C13452e.m80781L().m80795D0()) {
            this.f16996z1.setVisibility(0);
        }
        this.f16879B1.setVisibility(8);
        m23328B8("mecloud_show_task_center_icon_only");
        m23371Q8(true);
    }

    /* renamed from: d9 */
    public final void m23402d9() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showDiamondListView");
        LinearLayout linearLayout = this.f16892F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (C13452e.m80781L().m80887a1()) {
            LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.diamond_text_layout);
            linearLayout2.setVisibility(0);
            linearLayout2.setOnClickListener(new ViewOnClickListenerC3617d());
            linearLayout2.setClickable(true);
        }
        ListView listView = this.f16885D1;
        if (listView != null) {
            listView.setVisibility(0);
            if (C13452e.m80781L().m80887a1()) {
                this.f16885D1.setSelector(R$color.transparent);
            }
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager != null) {
            wrapContentHeightViewPager.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f16895G3;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: e4 */
    public void mo19472e4(long j10) {
        if (HicloudH5ConfigManager.getInstance().getClientVersion() >= j10) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "preGetPpsAdsNum H5Config ClientVersion not updated ");
            m23459x7();
            m23444t7();
        } else {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "preGetPpsAdsNum H5Config ClientVersion updated " + j10);
            C12515a.m75110o().m75175e(new C10257p1(this.f16524O, j10, 1002), false);
        }
    }

    /* renamed from: e7 */
    public final CloudPackage m23403e7(List<CloudPackage> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            CloudPackage cloudPackage = list.get(i10);
            if (cloudPackage.getProductType() == 12) {
                return cloudPackage;
            }
        }
        return null;
    }

    /* renamed from: e8 */
    public final void m23404e8(int i10) throws Throwable {
        if (i10 == 1006) {
            m23407f8(this.f16993y1);
            return;
        }
        this.f16897H1 = true;
        if (this.f16929R4) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "load ads finish");
            m23421l7();
        }
        m23437r6();
    }

    /* renamed from: e9 */
    public final void m23405e9(MemGradeRightDetails memGradeRightDetails, String str, CloudSpace cloudSpace) {
        m23402d9();
        C1173i c1173i = new C1173i(m23373S6(memGradeRightDetails.getRights(), cloudSpace), getLayoutInflater(), this, this.f16931S3, str);
        this.f16998z4 = c1173i;
        this.f16885D1.setAdapter((ListAdapter) c1173i);
        this.f16885D1.setClickable(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f3 */
    public void mo19473f3(Object obj) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!(obj instanceof UserPackage)) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetUserPackageSuccess obj is not UserPackage.");
            mo19477k5();
            return;
        }
        UserPackage userPackage = (UserPackage) obj;
        this.f21452m = userPackage;
        MemGradeRights gradeRights = userPackage.getGradeRights();
        if (gradeRights == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "dealGetUserPackageSuccess gradeRights is null.");
            mo19477k5();
            return;
        }
        String gradeCode = gradeRights.getGradeCode();
        if (gradeRights.getGradeType() != 9 || !m28589p1()) {
            this.f16567n0 = new GetGradeRightDetailResp();
            mo19479s5();
            return;
        }
        if (this.f16955e4 != null) {
            m23406f7();
            this.f16955e4 = null;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "Highest level is : " + gradeCode);
        C9158a.m57503F().m57508E(this.f16524O, gradeCode);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f4 */
    public void mo22832f4(Message message) {
        super.mo22832f4(message);
        m23431o8();
    }

    /* renamed from: f7 */
    public final void m23406f7() {
        String json = new Gson().toJson(this.f16955e4);
        Intent intent = new Intent(this, (Class<?>) PurchaseCloudCardActivity.class);
        intent.putExtra("iap_intent_voucher_info", json);
        startActivity(intent);
    }

    /* renamed from: f8 */
    public final void m23407f8(String str) throws Throwable {
        C11839m.m70688i("CloudSpaceUpgradeActivity", "processTaskCenterIcon: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String taskCenterUrl = HicloudH5ConfigManager.getInstance().getTaskCenterUrl(str);
        if (TextUtils.isEmpty(taskCenterUrl)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "iconUrl null");
            if (!C13452e.m80781L().m80795D0()) {
                this.f16996z1.setVisibility(0);
            }
            m23371Q8(true);
            this.f16879B1.setVisibility(0);
            m23328B8("mecloud_show_task_center_dot");
            return;
        }
        C1399b.m8034o().m8048n(taskCenterUrl);
        String strM8048n = C1399b.m8034o().m8048n(taskCenterUrl);
        if (strM8048n != null && new File(strM8048n).exists()) {
            this.f16876A1.setImageDrawable(Drawable.createFromPath(strM8048n));
        }
        if (!C13452e.m80781L().m80795D0()) {
            this.f16996z1.setVisibility(0);
        }
        m23371Q8(true);
        this.f16879B1.setVisibility(0);
        m23328B8("mecloud_show_task_center_dot");
    }

    /* renamed from: f9 */
    public final void m23408f9(int i10) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        BuyPackageBaseActivity.HandlerC3583m handlerC3583m;
        m22859p2();
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog = this.f16505E0;
        if (memberQuitFamilyShareDialog == null || !memberQuitFamilyShareDialog.isShowing()) {
            mo19476h5();
            this.f16983t4 = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (i10 == 19) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "showInvaidH5PackageIdDialog PACKAGE_UNEXITS");
                builder.setMessage(R$string.cloudpay_h5_invalid_package_id);
            } else if (i10 == 21) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "showInvaidH5PackageIdDialog PROMOTE_NOTMATCH");
                this.f16983t4 = true;
                builder.setMessage(R$string.cloudpay_h5_invalid_package);
            } else if (i10 == 120) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "showInvaidH5PackageIdDialog NEW_DEVICE_PRIVILEDGE_ERROR");
                builder.setMessage(R$string.cloudpay_free_package_conflict);
            } else if (i10 == 26) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "showInvaidH5PackageIdDialog MARKET_PACKAGE_HAS_PURCHASE");
                builder.setMessage(R$string.cloudpay_h5_invalid_package);
            } else {
                builder.setMessage(R$string.cloudpay_h5_invalid_package_id);
            }
            builder.setNegativeButton(R$string.cloudpay_payment_result_dialog_agree, new DialogInterfaceOnClickListenerC3620g());
            AlertDialog alertDialog = this.f16943Y3;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f16943Y3 = null;
            }
            this.f16943Y3 = builder.create();
            if (isFinishing() || this.f16943Y3.isShowing() || (handlerC3583m = this.f16524O) == null) {
                return;
            }
            handlerC3583m.postDelayed(new RunnableC3621h(), 200L);
        }
    }

    @Override // android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m23457w9();
        super.finish();
        if (m23345H7()) {
            overridePendingTransition(R$anim.search_fade_in, R$anim.search_fade_out);
        } else {
            new HwAnimationReflection(this).m28598b(2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g3 */
    public void mo22834g3(int i10) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (m22802U3()) {
            this.f16503D0 = 0;
        }
        m23442s9(false);
        mo19479s5();
        this.f16569p0 = 0;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g4 */
    public boolean mo22835g4(Message message) {
        boolean zMo22835g4 = super.mo22835g4(message);
        C11839m.m70688i("CloudSpaceUpgradeActivity", "processGetActivityEntrySuccess isSuccess " + zMo22835g4);
        if (!zMo22835g4) {
            m23431o8();
        }
        return zMo22835g4;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f16932T1.setVisibility(0);
        this.f16934U1.setVisibility(8);
        this.f16930S1.setVisibility(8);
        this.f16936V1.setVisibility(8);
        this.f16940X1.setText(R$string.cloudpay_loading);
        this.f16958h1.setVisibility(8);
    }

    /* renamed from: g7 */
    public final void m23409g7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent(this, (Class<?>) CardNumConfirmActivity.class);
        intent.putExtra("enter_type", "huawei_card_enter");
        intent.putExtra("params", this.f16538V);
        intent.putExtra("user", this.f21452m);
        intent.putExtra("from_where", 3);
        m28580X0(intent);
        startActivity(intent);
        overridePendingTransition(R$anim.search_fade_in, R$anim.search_fade_out);
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showView huawei card");
        finish();
    }

    /* renamed from: g8 */
    public final void m23410g8() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "frompushguide,querySignStatus");
        m22796R4("0", "1", "4");
        this.f16576w0 = "push_guide_purchase";
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        PayActivityInfo payActivityInfo = this.f16959h4;
        if (payActivityInfo == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "activityinfo is null.");
            return;
        }
        cloudSpace.setId(payActivityInfo.getcId());
        this.f16520M.setProductName(this.f16959h4.getProductName());
        this.f16520M.setCapacity(this.f16959h4.getCapacity());
        this.f16520M.setBaseCapacity(this.f21452m.getBaseCapacity());
        if (!C11296s.m67798V()) {
            C9158a.m57503F().m57530a0(this.f16524O, this.f21448i, this.f16959h4.getcId(), 1, m22882v2(), mo22754D3(), BigDecimal.ZERO);
            return;
        }
        this.f16541W0 = null;
        mo19478l5();
        C9158a.m57503F().m57542g0(this.f16524O, this.f21448i, this.f16520M.getId(), m22882v2(), mo22754D3(), new ArrayList(), null, 1, BigDecimal.ZERO);
    }

    /* renamed from: g9 */
    public final void m23411g9() throws Resources.NotFoundException {
        if (this.f16906K1 == null) {
            m23455w7();
        }
        if (this.f16906K1 == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "showMemberCardViewPager viewPager is null.");
            m23399c9();
            return;
        }
        List<GradePackageCardView> list = this.f16924Q1;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "packageViewList is null.");
            m23399c9();
            return;
        }
        m23390Z8();
        C3625l c3625l = new C3625l(this, m23380V6());
        this.f16933T3 = c3625l;
        this.f16906K1.setAdapter(c3625l);
        if (this.f16544Y) {
            m23323A6(0, this.f16933T3.getCount());
        }
        m23420k9();
        m23334D8(this.f16906K1);
        m23416i8();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16930S1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h3 */
    public void mo22836h3(Object obj) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (obj instanceof GetAvailableGradePackagesResp) {
            GetAvailableGradePackagesResp getAvailableGradePackagesResp = (GetAvailableGradePackagesResp) obj;
            this.f16568o0 = getAvailableGradePackagesResp;
            getAvailableGradePackagesResp.getSpacePackages();
            if (C11303z.m67859c().m67860a(this.f16568o0)) {
                if (!m22798S3()) {
                    this.f16503D0 = 1;
                }
                if (m22876t5(C11296s.m67829n(this.f16568o0.getPackageGrades(), this.f16568o0.getSpacePackages()))) {
                    return;
                }
                this.f16569p0 = 0;
                return;
            }
            m23442s9(false);
            if (m22802U3()) {
                this.f16503D0 = 0;
            }
            mo19479s5();
            this.f16569p0 = 0;
            C1442a.m8290i("CloudSpaceUpgradeActivity", "worryFree packages is empty");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h4 */
    public void mo22837h4() {
        C11839m.m70686d("CloudSpaceUpgradeActivity", "queryPushGuideStatus");
        if (C13452e.m80781L().m80803F0().booleanValue() || !C0209d.m1166E1()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "chinaRegion no push guide");
        } else {
            C12515a.m75110o().m75172d(new C11256d(new WeakReference(this.f16524O)));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f16525O0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "isFromH5Pay is true,showMain");
            m22803U4();
            m22859p2();
            mo19460T3();
            return;
        }
        if (this.f16521M0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "isAOPSubscribePay is true,showMain");
            this.f16521M0 = false;
            mo19460T3();
            return;
        }
        if (this.f16527P0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "isBackupDialogPay is true,showMain");
            this.f16527P0 = false;
            mo19460T3();
            return;
        }
        if (!m23339F7()) {
            if (!this.f16543X0) {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "other cases,showMain");
                mo19460T3();
                return;
            } else {
                C1442a.m8290i("CloudSpaceUpgradeActivity", "isAcceptSignGiftProcess is false,showMain");
                this.f16543X0 = false;
                mo19460T3();
                return;
            }
        }
        if (!this.f16498A0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "mDataIsReady is false,showMain");
            mo19479s5();
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "mDataIsReady is true,showMain");
        this.f16930S1.setVisibility(0);
        this.f16932T1.setVisibility(8);
        this.f16934U1.setVisibility(8);
        this.f16936V1.setVisibility(8);
        this.f16958h1.setVisibility(0);
    }

    /* renamed from: h7 */
    public final void m23412h7() {
        GetClientUIConfigResp getClientUIConfigResp;
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "manage_monthly_payment click too fast");
            return;
        }
        Intent intent = new Intent(this, (Class<?>) PaymentManagerAndOrderActivity.class);
        if (this.f21452m != null && (getClientUIConfigResp = this.f16538V) != null) {
            intent.putExtra("params", getClientUIConfigResp);
            intent.putExtra("user", this.f21452m);
            intent.putExtra("chosen_backup_frequency", this.f16562i0);
        }
        m28580X0(intent);
        m23445t8();
        startActivityForResult(intent, NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE);
    }

    /* renamed from: h8 */
    public final void m23413h8() {
        View view;
        if (this.f16900I1 == null || (view = this.f16888E1) == null || this.f16880B3 == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "refreshBottomMutableLayout, view is null");
        } else if (view.getVisibility() == 8 && this.f16880B3.getVisibility() == 8) {
            this.f16900I1.setVisibility(8);
        } else {
            this.f16900I1.setVisibility(0);
        }
    }

    /* renamed from: h9 */
    public void m23414h9() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "show continuous monthly service agreement");
        C9158a.m57503F().m57527Y(this.f16524O);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: i0 */
    public void mo23196i0(boolean z10) {
        m23435q8(z10);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CloudSpaceUpgradeActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i4 */
    public void mo22839i4() {
        if (this.f16563j0.size() > 0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "refresh vouchers");
            mo19460T3();
        }
    }

    /* renamed from: i7 */
    public final void m23415i7(String str) {
        if (str == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "gradeCode is null ");
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "new business mode user, turn to H5 page");
            m23352J7();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) MemberRightActivity.class);
        intent.putExtra("rightGradeCode", str);
        intent.putExtra("isavailable", true);
        intent.putExtra("clickSourceType", "1");
        intent.putExtra("fromActivity", getClass().getSimpleName());
        m23460x8("", str, "1");
        startActivityForResult(intent, 10010);
    }

    /* renamed from: i8 */
    public final void m23416i8() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshMemRightArea()");
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshMemRightArea viewPager is null.");
            this.f16935U3.setVisibility(8);
            return;
        }
        int currentItem = wrapContentHeightViewPager.getCurrentItem();
        if (this.f16924Q1 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshMemRightArea packageViewList is null.");
            this.f16935U3.setVisibility(8);
            return;
        }
        int size = m23380V6().size();
        if (currentItem < size) {
            GradePackageCardView gradePackageCardView = m23380V6().get(currentItem);
            m23417j8(gradePackageCardView.getGradeRightList(), gradePackageCardView.m23543D(), gradePackageCardView.getmGradeCode(), gradePackageCardView.getmGradeName(), gradePackageCardView.getPurchaseNeedData());
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "refreshMemRightArea index >= packageViewListSize, index = " + currentItem + " , packageViewListSize = " + size);
        this.f16935U3.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: j5 */
    public void mo22843j5() throws Resources.NotFoundException {
        GetClientUIConfigResp getClientUIConfigResp = this.f16538V;
        if (getClientUIConfigResp == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "showMoreIcon params is null.");
            return;
        }
        this.f16948b2 = getClientUIConfigResp.getPromotionCardTitle();
        this.f16950c2 = this.f16538V.getBuyCardTitle();
        if (m23424m7() && m23426n7()) {
            this.f16882C1.setVisibility(8);
            m23368P8(false);
        } else {
            this.f16882C1.setVisibility(0);
            m23368P8(true);
        }
    }

    /* renamed from: j8 */
    public void m23417j8(List<PackageGradeRight> list, boolean z10, String str, String str2, PurchaseNeedData purchaseNeedData) {
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "refreshMemRightArea gradeRightList is null or empty.");
            this.f16935U3.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            PackageGradeRight packageGradeRight = list.get(i11);
            if (packageGradeRight.getStatus() == 1) {
                arrayList.add(packageGradeRight);
            } else {
                i10++;
            }
        }
        if (i10 == size) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "refreshMemRightArea all grade right is inactive.");
            this.f16935U3.setVisibility(8);
            return;
        }
        this.f16935U3.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.diamond_text_layout);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ViewOnClickListenerC3614a viewOnClickListenerC3614a = new ViewOnClickListenerC3614a(str, z10);
        this.f16911L4 = viewOnClickListenerC3614a;
        this.f16935U3.setOnClickListener(viewOnClickListenerC3614a);
        PartMemRightShowAdapter partMemRightShowAdapter = new PartMemRightShowAdapter(this, arrayList, str, z10, this);
        this.f16937V3.setAdapter(partMemRightShowAdapter);
        this.f16937V3.setLayoutManager(new GridLayoutManager((Context) this, 1, 0, false));
        if (C13452e.m80781L().m80887a1()) {
            this.f16939W3.setText(R$string.data_service_scope_rights);
            this.f16937V3.setVisibility(8);
        } else {
            this.f16939W3.setText(getResources().getQuantityString(R$plurals.cloudpay_mem_right_area_title, arrayList.size(), str2, Integer.valueOf(arrayList.size())));
            this.f16937V3.setVisibility(0);
        }
        partMemRightShowAdapter.m5213j();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f16934U1.setVisibility(0);
        this.f16932T1.setVisibility(8);
        this.f16930S1.setVisibility(8);
        this.f16936V1.setVisibility(8);
    }

    /* renamed from: k7 */
    public final void m23418k7(Filter filter, String str, long j10) {
        if (this.f16987v4) {
            C9158a.m57503F().m57559x(this.f16524O, filter, null, m22882v2(), true, true, this.f16989w4);
            return;
        }
        if (!C11296s.m67787K() || str == null || str.equals("0") || !C11296s.m67789M(this)) {
            C9158a.m57503F().m57560y(this.f16524O, filter, null, true, m22882v2(), true, j10);
        } else {
            C9158a.m57503F().m57560y(this.f16524O, filter, this.f16955e4.getVoucherCode(), true, m22882v2(), true, j10);
        }
    }

    /* renamed from: k8 */
    public final void m23419k8() {
        if (this.f16953d4) {
            m23366P6(true);
        } else {
            m23366P6(false);
        }
    }

    /* renamed from: k9 */
    public final void m23420k9() {
        LinearLayout linearLayout = this.f16892F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ListView listView = this.f16885D1;
        if (listView != null) {
            listView.setVisibility(8);
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager != null) {
            wrapContentHeightViewPager.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f16895G3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l4 */
    public void mo22847l4(Bundle bundle) {
        if (bundle == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "reportBannerClickEvent bundle is null.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("banner_name", bundle.getString("banner_name"));
            linkedHashMapM79497A.put("banner_goto_type", bundle.getString("banner_goto_type"));
            linkedHashMapM79497A.put("banner_goto_uri", bundle.getString("banner_goto_uri"));
            linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(bundle.getFloat(HNConstants.C4906BI.BI_PERCENTAGE)));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_BANNER_CLICK", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_BANNER_CLICK", "1", "35", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_BANNER_CLICK", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "reportBannerClickEvent error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f16932T1.setVisibility(0);
        this.f16934U1.setVisibility(8);
        if (this.f16557e1) {
            this.f16930S1.setVisibility(0);
        } else {
            this.f16930S1.setVisibility(8);
        }
        this.f16936V1.setVisibility(8);
        this.f16940X1.setText(R$string.cloudpay_loading);
    }

    /* renamed from: l7 */
    public final void m23421l7() {
        String str;
        C1442a.m8290i("CloudSpaceUpgradeActivity", "handleFrontAppJump");
        UserPackage userPackage = this.f21452m;
        if (userPackage == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "handleFrontAppJump user is null.");
            return;
        }
        if (!this.f16897H1) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "handleFrontAppJump no ads");
            return;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages == null || effectivePackages.size() <= 0) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "effectivePackages is null.");
            return;
        }
        CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 0);
        if (m28589p1() || cloudSpaceM16171q.getCapacity() == 0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "no need continue.");
            return;
        }
        String strM67741b = C11290m.m67741b(this, cloudSpaceM16171q.getEndTime());
        if (TextUtils.isEmpty(this.f16570q0) || TextUtils.isEmpty(this.f16571r0)) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "no ResourceId.");
            return;
        }
        H5Resource h5ResourceById = HicloudH5ConfigManager.getInstance().getH5ResourceById(this.f16570q0);
        if (h5ResourceById == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "no H5Resource.");
            return;
        }
        if (!TextUtils.equals(h5ResourceById.getEnablePopup(), "1")) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", " enablePopup not match");
            return;
        }
        NotifyTypeAndUriGoto gotoUrl = h5ResourceById.getGotoUrl();
        if (gotoUrl == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "go is null");
            return;
        }
        if (!TextUtils.equals(gotoUrl.getNotifyType(), "web")) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "getNotifyType unMatch");
            return;
        }
        String notifyUri = gotoUrl.getNotifyUri();
        if (notifyUri.contains(Constants.QUESTION_STR)) {
            str = notifyUri + "&expireTime=" + strM67741b;
        } else {
            str = notifyUri + "?expireTime=" + strM67741b;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "notifyUri: " + str);
        Intent intent = new Intent(this, (Class<?>) GuideWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("notifyAction", 1);
        intent.putExtra("activeUri", this.f16571r0);
        C1442a.m8290i("CloudSpaceUpgradeActivity", " go to new Activity");
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", " FrontAppJump Exception: " + e10.getMessage());
        }
    }

    /* renamed from: l8 */
    public final void m23422l8() {
        if (this.f16904J3 == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "refreshToolStatusBarHeight, mToolStatusBarLayout is null.");
            return;
        }
        if (C11842p.m70753O0(this) && !C11842p.m70771U0()) {
            C11842p.m70727F1(this.f16904J3, 0);
        } else if (C12806c.m76815f(this)) {
            C11842p.m70727F1(this.f16904J3, C11842p.m70789a0(this));
        } else {
            C11842p.m70727F1(this.f16904J3, 0);
        }
    }

    /* renamed from: l9 */
    public final void m23423l9(String str, String str2, String str3) {
        C11839m.m70686d("CloudSpaceUpgradeActivity", "showPushguideDialog");
        HicloudPushGuideDialog hicloudPushGuideDialog = new HicloudPushGuideDialog();
        this.f16578y0 = hicloudPushGuideDialog;
        Dialog dialogPrepareDialog = hicloudPushGuideDialog.prepareDialog(this, this, str, str2, str3);
        this.f16577x0 = dialogPrepareDialog;
        dialogPrepareDialog.show();
        this.f16533S0 = true;
        C10028c.m62182c0().m62427z3();
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("show_push_guide_dialog_scene", "upgrade_scene");
        linkedHashMapM79497A.put("pop_show_times", String.valueOf(C10028c.m62182c0().m62230J0()));
        C13227f.m79492i1().m79567R("07031", linkedHashMapM79497A);
    }

    /* renamed from: m7 */
    public final boolean m23424m7() {
        return TextUtils.isEmpty(this.f16950c2) || !C11296s.m67796T();
    }

    /* renamed from: m9 */
    public final void m23425m9() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showServiceDiffCountryArea");
        LinearLayout linearLayout = this.f16892F3;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ListView listView = this.f16885D1;
        if (listView != null) {
            listView.setVisibility(8);
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager != null) {
            wrapContentHeightViewPager.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f16895G3;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            m22775J4("upgrade_purchase");
        }
        boolean zM1224X1 = C0209d.m1224X1();
        if (this.f16898H3 != null) {
            String string = getString(R$string.cloudpay_current_register, C0209d.m1177I(C13452e.m80781L().m80942m()));
            TextView textView = this.f16898H3;
            if (zM1224X1) {
                string = getString(R$string.cloudpay_change_service_tw, string);
            }
            textView.setText(string);
        }
        TextView textView2 = this.f16913M3;
        if (textView2 != null) {
            if (zM1224X1) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(getString(R$string.cloudpay_current_service, C0209d.m1177I(C13452e.m80781L().m80921h0())));
            }
        }
        ImageView imageView = this.f16918O1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.f16921P1;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.f16935U3;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    /* renamed from: n7 */
    public final boolean m23426n7() {
        Response response;
        return TextUtils.isEmpty(this.f16948b2) || (response = this.f16530R) == null || response.getResultCode() != 0;
    }

    /* renamed from: n8 */
    public void m23427n8(String str, List<MemGradeRight> list) {
        m23350I8(m23400d7(str), this.f16885D1.getVisibility() == 0 && list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.w
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudSpaceUpgradeActivity.m23275O7((MemGradeRight) obj);
            }
        }).count() > 0);
    }

    /* renamed from: n9 */
    public final boolean m23428n9() {
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog;
        if (C11829c.m70626w0()) {
            FamilyShareInfoResult familyShareInfoResult = this.f16550b0;
            if (familyShareInfoResult == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "setShowStopMFamilyShare mFamilyShareInfoResult is null.");
                return false;
            }
            boolean zM64302l = C10465b.m64302l(familyShareInfoResult);
            C1442a.m8290i("CloudSpaceUpgradeActivity", "showStopMFamilyShare isMember = " + zM64302l);
            if (zM64302l) {
                this.f16992x4 = true;
                if (!isFinishing() && (memberQuitFamilyShareDialog = this.f16505E0) != null && memberQuitFamilyShareDialog.isShowing()) {
                    return true;
                }
                this.f16505E0 = null;
                MemberQuitFamilyShareDialog memberQuitFamilyShareDialog2 = new MemberQuitFamilyShareDialog(this, this.f16521M0);
                this.f16505E0 = memberQuitFamilyShareDialog2;
                memberQuitFamilyShareDialog2.setCanceledOnTouchOutside(false);
                BuyPackageBaseActivity.HandlerC3583m handlerC3583m = this.f16524O;
                if (handlerC3583m != null) {
                    handlerC3583m.postDelayed(new RunnableC3622i(), 200L);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.cloudpay.PartMemRightShowAdapter.PartMemRightShowCallBack
    /* renamed from: o */
    public PurchaseNeedData mo23429o() {
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        if (wrapContentHeightViewPager == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getPurchaseNeedata viewPager is null.");
            return new PurchaseNeedData();
        }
        int currentItem = wrapContentHeightViewPager.getCurrentItem();
        if (this.f16924Q1 == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "getPurchaseNeedata packageViewList is null.");
            return new PurchaseNeedData();
        }
        int size = m23380V6().size();
        if (currentItem < size) {
            return m23380V6().get(currentItem).getPurchaseNeedData();
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "getPurchaseNeedata index >= packageViewListSize, index = " + currentItem + " , packageViewListSize = " + size);
        return new PurchaseNeedData();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: o5 */
    public void mo22858o5(Object obj) {
        String[] currentContentString = HicloudPushGuideManager.getInstance().getCurrentContentString();
        if (currentContentString.length == 0) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "dialog ContentString is null");
            return;
        }
        String str = currentContentString[0];
        String str2 = currentContentString[1];
        String str3 = currentContentString[2];
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "string is null");
            return;
        }
        if (obj == null || !(obj instanceof GetRecommendActivityResp)) {
            this.f16961i4 = false;
            m23423l9(str, str2, "");
            return;
        }
        this.f16959h4 = ((GetRecommendActivityResp) obj).getPayActivityInfo();
        if (TextUtils.isEmpty(str3) || this.f16959h4 == null) {
            this.f16961i4 = false;
            C11839m.m70688i("CloudSpaceUpgradeActivity", "activityInfo is null");
            m23423l9(str, str2, "");
        } else {
            C11839m.m70686d("CloudSpaceUpgradeActivity", "pushGuideDialog is to be popuped");
            this.f16961i4 = true;
            m23423l9(str, str2, String.format(Locale.ENGLISH, str3, C0223k.m1524g(getApplicationContext(), this.f16959h4.getCapacity())));
        }
    }

    /* renamed from: o7 */
    public final void m23430o7() {
        try {
            View viewFindViewById = findViewById(R$id.vs_user_item);
            if (viewFindViewById instanceof ViewStub) {
                ((ViewStub) viewFindViewById).inflate();
            }
            View viewFindViewById2 = findViewById(R$id.new_business_upgradepage_usercard_viewstub);
            if (viewFindViewById2 instanceof ViewStub) {
                ((ViewStub) viewFindViewById2).inflate();
            }
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "adaptOldByFontScale --- " + e10.getMessage());
        }
    }

    /* renamed from: o8 */
    public final void m23431o8() {
        C11839m.m70688i("CloudSpaceUpgradeActivity", "remove ad loader banner, but no need");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0061  */
    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) throws org.json.JSONException, java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            com.huawei.hicloud.base.common.HiCloudSafeIntent r0 = new com.huawei.hicloud.base.common.HiCloudSafeIntent
            r0.<init>(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "onActivityResult requestCode = "
            r6.append(r1)
            r6.append(r4)
            java.lang.String r1 = ", resultCode = "
            r6.append(r1)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r1 = "CloudSpaceUpgradeActivity"
            p054cj.C1442a.m8290i(r1, r6)
            r6 = 8801(0x2261, float:1.2333E-41)
            if (r4 != r6) goto L2b
            super.onActivityResult(r4, r5, r0)
            return
        L2b:
            r6 = -1
            if (r5 == r6) goto L9e
            if (r5 == 0) goto L81
            r6 = 1
            if (r5 == r6) goto L81
            r6 = 201(0xc9, float:2.82E-43)
            if (r5 == r6) goto L61
            r6 = 802(0x322, float:1.124E-42)
            if (r5 == r6) goto L61
            r6 = 8903(0x22c7, float:1.2476E-41)
            if (r5 == r6) goto L4f
            r6 = 10028(0x272c, float:1.4052E-41)
            if (r5 == r6) goto L4b
            switch(r5) {
                case 7101: goto L61;
                case 7102: goto L47;
                case 7103: goto L61;
                default: goto L46;
            }
        L46:
            goto La1
        L47:
            r3.m23431o8()
            goto La1
        L4b:
            r3.m23274O6(r5, r0)
            goto La1
        L4f:
            j7.a r6 = r3.f16997z3
            if (r6 == 0) goto La1
            uj.l r6 = p681uj.C13195l.m79272J()
            j7.a r1 = r3.f16997z3
            j7.a$d r1 = r1.m65437v()
            r6.m79297M(r3, r1, r5, r0)
            goto La1
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "refresh data by requestCode:"
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = ", resultCode:"
            r6.append(r2)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            p054cj.C1442a.m8288d(r1, r6)
            r3.mo19460T3()
            goto La1
        L81:
            r3.m28583a1()
            com.huawei.cloud.pay.model.GetClientUIConfigResp r6 = r3.f16538V
            if (r6 == 0) goto L95
            com.huawei.cloud.pay.model.UserPackage r6 = r3.f21452m
            if (r6 == 0) goto L95
            java.util.ArrayList<com.huawei.cloud.pay.model.FilterAvailabalGradePackage> r6 = r3.f16540W
            if (r6 != 0) goto L91
            goto L95
        L91:
            r3.mo19476h5()
            goto La1
        L95:
            java.lang.String r4 = " data no prepare ok"
            p054cj.C1442a.m8288d(r1, r4)
            r3.mo19460T3()
            return
        L9e:
            r3.mo19453O4(r4, r0)
        La1:
            super.onActivityResult(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m23457w9();
        if (this.f16521M0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "onBackPressed aop");
            m22753D2();
        }
        super.onBackPressed();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "check status = " + z10);
        C11282e.m67709b(this).m67714f("key_checkbox_status", Boolean.valueOf(z10));
        if (this.f16991x3) {
            return;
        }
        C1442a.m8289e("CloudSpaceUpgradeActivity", "initView mPackageTimeAdapter is null.");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        int id2 = view.getId();
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
            return;
        }
        if (R$id.layout_nodata == id2) {
            mo19460T3();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            mo19446D1();
            return;
        }
        if (id2 == R$id.ic_more_hot_space) {
            m23280R8(view);
        } else if (id2 == R$id.recommend_more_tv) {
            m23304i9();
        } else {
            m23387Y7(id2);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        C11842p.m70822i1(this);
        C11842p.m70874v1(this, this.f16952d2);
        C11842p.m70874v1(this, this.f16954e2);
        m23282S8();
        if (C0209d.m1173G1(this)) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "not support PrivateSpace mode!");
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f16994y3;
            if (unspportPrivateSpaceDialog == null) {
                UnspportPrivateSpaceDialog unspportPrivateSpaceDialog2 = new UnspportPrivateSpaceDialog(this, this);
                this.f16994y3 = unspportPrivateSpaceDialog2;
                unspportPrivateSpaceDialog2.show();
            } else if (!unspportPrivateSpaceDialog.isShowing()) {
                this.f16994y3.show();
            }
        }
        BannerFragment bannerFragment = this.f16886D3;
        if (bannerFragment != null) {
            bannerFragment.m24115n();
        }
        if (m23380V6() != null) {
            Iterator<GradePackageCardView> it = m23380V6().iterator();
            while (it.hasNext()) {
                it.next().m23576n();
            }
        }
        m23466z6();
        m23390Z8();
        if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
            m23337E8();
        }
        m23419k8();
        m23413h8();
        mo23770l1();
        m23422l8();
        m23329B9();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onCreate");
        m23392a8(getIntent());
        m23464y8();
        this.f16979r4 = false;
        C13108a.m78878b(this).m78880c(this.f16917N4, new IntentFilter("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH"));
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("sceneId");
        if ("OPEN_CLOUD_PHOTO_IN_APP".equals(stringExtra) || "OPEN_CLOUD_PHOTO_FROM_OTHER".equals(stringExtra)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "guide the upgrade user,sceneId:" + stringExtra);
            this.f16979r4 = true;
        }
        if (C13452e.m80781L().m80912f1()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        }
        if (C0209d.m1173G1(this)) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "not support PrivateSpace mode!");
            UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = new UnspportPrivateSpaceDialog(this, this);
            this.f16994y3 = unspportPrivateSpaceDialog;
            unspportPrivateSpaceDialog.show();
        } else {
            if (C0219i.m1463a() < 14 || C0219i.m1463a() >= 17) {
                C11842p.m70889z0(this);
            }
            if (!C13843a.m83076a0(this)) {
                setRequestedOrientation(1);
            }
            this.f16995y4 = C0209d.m1195O(this);
            setContentView(m23377U6());
            m23432p7();
            m23318r7();
            m23263C7();
            m28587n1();
            m23440s7();
            m28592t1();
            mo23770l1();
            C0202a.m1119c().m1123e(1);
            m23434q7();
            RecommendCardManager.getInstance().getConfigFromOM(RecommendCardConstants.Entrance.BUY);
        }
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "CloudSpaceUpgradeActivity");
        m23282S8();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AutoRenewRuleDialog autoRenewRuleDialog;
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onDestroy");
        PopupMenu popupMenu = this.f16942Y1;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
        if (this.f16917N4 != null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "openAlbumSwitchAfterPaying unregisterReceiver");
            C13108a.m78878b(this).m78883f(this.f16917N4);
        }
        closeOptionsMenu();
        List<UrgencyOnTopParams> list = this.f16919O3;
        if (list != null) {
            list.clear();
            this.f16919O3 = null;
        }
        UrgencyScrollUpView urgencyScrollUpView = this.f16922P3;
        if (urgencyScrollUpView != null) {
            urgencyScrollUpView.m24011l();
            this.f16922P3 = null;
        }
        UnspportPrivateSpaceDialog unspportPrivateSpaceDialog = this.f16994y3;
        if (unspportPrivateSpaceDialog != null) {
            unspportPrivateSpaceDialog.dismiss();
            this.f16994y3 = null;
        }
        super.onDestroy();
        C10718a c10718a = this.f16997z3;
        if (c10718a != null) {
            c10718a.m65430k();
            this.f16997z3.m65438x();
        }
        if (this.f16916N3 != null) {
            C13108a.m78878b(this).m78883f(this.f16916N3);
            this.f16916N3 = null;
        }
        Bitmap bitmap = this.f16877A3;
        if (bitmap != null) {
            bitmap.recycle();
        }
        BannerFragment bannerFragment = this.f16886D3;
        if (bannerFragment != null) {
            bannerFragment.m24113l();
        }
        AlertDialog alertDialog = this.f16943Y3;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f16943Y3 = null;
        }
        HicloudPushGuideDialog hicloudPushGuideDialog = this.f16578y0;
        if (hicloudPushGuideDialog != null) {
            hicloudPushGuideDialog.dismissAndDestroy();
        }
        AlertDialog alertDialog2 = this.f16554d0;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        C11842p.m70836m(this);
        RenewAgreementTextview renewAgreementTextview = this.f16902I4;
        if (renewAgreementTextview == null || (autoRenewRuleDialog = renewAgreementTextview.f19532h) == null) {
            return;
        }
        autoRenewRuleDialog.dismiss();
        this.f16902I4.f19532h = null;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R$id.redemption_member_card) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "notch_fit_pay_card click too fast");
                return false;
            }
            String strM80971t0 = C13452e.m80781L().m80971t0();
            if (!TextUtils.isEmpty(strM80971t0)) {
                C13227f.m79492i1().m79585f0("mecloud_upgrade_click_exchange", strM80971t0);
                UBAAnalyze.m29954O("PVC", "mecloud_upgrade_click_exchange", "1", "36");
            }
            m23438r8();
            m23441s8();
            C12515a.m75110o().m75172d(new ClickExchangeTask(this, this.f16538V, this.f21452m, 1, this.f16562i0));
        } else if (itemId == R$id.purchase_member_card) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "purchase_member_card click too fast");
                return false;
            }
            m23452v8();
            m23456w8();
            Intent intent = new Intent();
            intent.setClass(this, PurchaseCloudCardActivity.class);
            intent.putExtra("params", this.f16538V);
            intent.putExtra("user", this.f21452m);
            intent.putExtra("chosen_backup_frequency", this.f16562i0);
            m28580X0(intent);
            startActivityForResult(intent, RequestManager.NOTIFY_CONNECT_FAILED);
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback
    public void onNegativeClick() {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws JSONException {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        m23392a8(intent);
        m23464y8();
        m23440s7();
        this.f16533S0 = false;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "onOptionsItemSelected item is null.");
            return false;
        }
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        } else {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "item is over.");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public void onPause() {
        UrgencyScrollUpView urgencyScrollUpView = this.f16922P3;
        if (urgencyScrollUpView != null && urgencyScrollUpView.getVisibility() == 0) {
            this.f16922P3.m24011l();
        }
        super.onPause();
        C1442a.m8288d("CloudSpaceUpgradeActivity", "onPause isFisrtProc: " + this.f16992x4);
        this.f16992x4 = true;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.PushGuideDialogCallback
    public void onPositiveClick(PayActivityInfo payActivityInfo) {
        C10028c.m62182c0().m62296Y1("1111222222222222");
        C12515a.m75110o().m75172d(new C11258f(true, "1111222222222222", "upgrade_scene"));
        if (this.f16961i4) {
            m23410g8();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onRestart");
        C10718a c10718a = this.f16997z3;
        if (c10718a != null) {
            c10718a.m65431l();
        }
        Dialog dialog = this.f16577x0;
        if (dialog != null && dialog.isShowing()) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "pushguide has show ,check status");
            this.f16577x0.cancel();
            this.f16533S0 = false;
            mo22837h4();
        }
        if (this.f16992x4) {
            this.f16992x4 = false;
            C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudSpaceUpgradeActivity"), false);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f16949b4 = bundle.getInt("scroll_value");
        float f10 = bundle.getFloat("ratio_value");
        this.f16951c4 = f10;
        RelativeLayout relativeLayout = this.f16982t1;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(f10);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        UrgencyScrollUpView urgencyScrollUpView;
        UrgencyScrollUpView urgencyScrollUpView2;
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onResume");
        UrgencyScrollUpView urgencyScrollUpView3 = this.f16922P3;
        if (urgencyScrollUpView3 != null && urgencyScrollUpView3.getVisibility() == 0) {
            this.f16922P3.m24011l();
            this.f16922P3.m24009j();
            this.f16922P3.m24010k();
        }
        super.onResume();
        if (C1398a.m8023p()) {
            this.f16985u4 = false;
            mo19460T3();
        }
        C11836j.m70658k().m70677t(this);
        if (this.f16889E3 != null) {
            if (C0209d.m1333z1(this)) {
                this.f16889E3.m23914a();
                if (!TextUtils.isEmpty(this.f16925Q3) && (urgencyScrollUpView2 = this.f16922P3) != null) {
                    urgencyScrollUpView2.setVisibility(0);
                }
            } else {
                this.f16889E3.m23919i();
                if (!TextUtils.isEmpty(this.f16925Q3) && (urgencyScrollUpView = this.f16922P3) != null) {
                    urgencyScrollUpView.setVisibility(8);
                }
            }
        }
        if (!TextUtils.isEmpty(f16873T4)) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "onResume userOperationText report");
            C12515a.m75110o().m75172d(new C11081g(f16873T4, f16874U4));
            f16873T4 = "";
            f16874U4 = "";
        }
        C11296s.m67824k0(true);
        RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.BUY, false, false);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        bundle.putInt("scroll_value", this.f16949b4);
        bundle.putFloat("ratio_value", this.f16951c4);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C1442a.m8288d("CloudSpaceUpgradeActivity", "onStop isFisrtProc: " + this.f16992x4);
        this.f16992x4 = true;
    }

    /* renamed from: p7 */
    public final void m23432p7() {
        this.f16904J3 = (RelativeLayout) C12809f.m76829b(this, R$id.tool_status_bar_region);
        m23340F8();
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.back);
        imageView.setOnClickListener(this);
        imageView.setContentDescription(getString(R$string.talkback_upward_navigation));
        this.f16907K3 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_magrin_task_center);
        this.f16910L3 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_magrin_more);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.rl_task_center);
        this.f16996z1 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f16876A1 = (ImageView) C12809f.m76829b(this, R$id.ic_task_center);
        this.f16879B1 = (ImageView) C12809f.m76829b(this, R$id.ic_task_dot);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.ic_more_hot_space);
        this.f16882C1 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        Window window = getWindow();
        if (window != null) {
            int color = getColor(R$color.hicloud_hmos_bg);
            window.setStatusBarColor(color);
            window.getDecorView().setBackgroundColor(color);
        }
        m23422l8();
    }

    /* renamed from: p8 */
    public final void m23433p8(SafeIntent safeIntent) throws JSONException {
        if (safeIntent == null) {
            return;
        }
        String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE);
        if (stringExtra == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "notifyType is null");
            return;
        }
        boolean booleanExtra = safeIntent.getBooleanExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, false);
        boolean booleanExtra2 = safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false);
        String stringExtra2 = safeIntent.getStringExtra("scene_id");
        if (booleanExtra && booleanExtra2) {
            JSONObject jSONObjectM79464f = C13222a.m79464f(this, "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
            String stringExtra3 = safeIntent.getStringExtra(HNConstants.C4906BI.DATA_TYPE_ID);
            try {
                jSONObjectM79464f.put("notify_type", "1");
                jSONObjectM79464f.put("notify_id", stringExtra3);
                jSONObjectM79464f.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, safeIntent.getIntExtra(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, 0));
                jSONObjectM79464f.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID, safeIntent.getStringExtra(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID));
                jSONObjectM79464f.put(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, safeIntent.getStringExtra(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE));
                jSONObjectM79464f.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(safeIntent.getFloatExtra(HNConstants.C4906BI.BI_PERCENTAGE, 0.0f)));
                jSONObjectM79464f.put("scene_id", stringExtra2);
            } catch (JSONException e10) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "ERROR OCCUR:" + e10.getMessage());
            }
            C13227f.m79492i1().m79602z(jSONObjectM79464f);
            if ("3".equals(stringExtra)) {
                UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "8", jSONObjectM79464f);
            } else if ("2".equals(stringExtra)) {
                UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "6", jSONObjectM79464f);
            }
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: q0 */
    public void mo23205q0(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo) throws JSONException {
        if (this.f16932T1.getVisibility() == 0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "sendSelectPackage , viewLoading is visible.");
            return;
        }
        this.f16557e1 = true;
        if (cloudPackage == null) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", " mSelectPackage is null.");
        } else {
            m22880u5(cloudPackage, packageGrades, "upgrade_purchase", list, m22882v2(), reportVoucherInfo, this.f21452m.getDeductAmount());
        }
    }

    /* renamed from: q7 */
    public final void m23434q7() {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "initBannerView");
        this.f16880B3 = C12809f.m76829b(this, R$id.upgrade_banner_stub_frame);
        C1442a.m8290i("CloudSpaceUpgradeActivity", "bannerStubFrame:" + this.f16880B3.getVisibility());
        try {
            if (this.f16883C3 == null) {
                View viewFindViewById = findViewById(R$id.upgrade_banner_stub);
                if (viewFindViewById instanceof ViewStub) {
                    this.f16883C3 = ((ViewStub) viewFindViewById).inflate();
                }
            }
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "view stub inflate exception:" + e10.toString());
        }
        BannerFragment bannerFragment = (BannerFragment) C12809f.m76828a(getFragmentManager(), R$id.banner_fragment);
        this.f16886D3 = bannerFragment;
        if (bannerFragment != null) {
            bannerFragment.m24119r(this);
            this.f16886D3.m24120s(this.f16524O);
            this.f16886D3.m24118q(this.f16562i0);
        }
    }

    /* renamed from: q8 */
    public final void m23435q8(boolean z10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("way_of_purchase", "upgrade_purchase");
        m22842j4(z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", linkedHashMap);
    }

    /* renamed from: q9 */
    public final void m23436q9() {
        m23340F8();
        if (!C13452e.m80781L().m80791C0()) {
            RelativeLayout relativeLayout = this.f16966l1;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RelativeLayout relativeLayout2 = this.f16968m1;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this.f16966l1;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.f16968m1;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(0);
            ((LinearLayout) C12809f.m76829b(this, R$id.new_business_upgradepage_usercard_upgrade_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f17574a.m23381V7(view);
                }
            });
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: r1 */
    public boolean mo19553r1(int i10, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudSpaceUpgradeActivity", "KEYCODE_BACK click too fast");
            return true;
        }
        mo19541d5();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: r2 */
    public void mo22867r2() {
        this.f16932T1.setVisibility(8);
        this.f16934U1.setVisibility(8);
        this.f16930S1.setVisibility(0);
        this.f16936V1.setVisibility(8);
    }

    /* renamed from: r6 */
    public final void m23437r6() {
        C11839m.m70688i("CloudSpaceUpgradeActivity", "add ad loader banner, but no need");
    }

    /* renamed from: r8 */
    public final void m23438r8() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_EXCHANGE_CARD", linkedHashMap);
    }

    /* renamed from: r9 */
    public final void m23439r9() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f16531R0) {
            m23410g8();
            this.f16531R0 = false;
            return;
        }
        if (this.f16525O0) {
            if (this.f21452m == null) {
                return;
            }
            if (!C13452e.m80781L().m80791C0()) {
                this.f16958h1.setVisibility(0);
            }
            m23461x9();
            return;
        }
        if (this.f16521M0) {
            if (this.f21452m == null) {
                C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , user is null.");
                return;
            } else if (this.f16538V == null) {
                C1442a.m8288d("CloudSpaceUpgradeActivity", " data no prepare ok , params is null.");
                return;
            } else {
                m23449u9();
                return;
            }
        }
        if (this.f16527P0) {
            m23453v9();
            return;
        }
        if (this.f16973o4) {
            m23396b9();
            return;
        }
        if (this.f16543X0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "showView start accept sign gift process.");
            m23446t9();
            return;
        }
        if (m23339F7()) {
            if (this.f16558f0) {
                this.f16576w0 = "backup_before_purchase";
            }
            this.f16498A0 = true;
            C1442a.m8290i("CloudSpaceUpgradeActivity", "begin showView");
            if (this.f16569p0 == 0) {
                if (m23335E6()) {
                    this.f16569p0 = 1;
                    return;
                }
                if (m22802U3()) {
                    this.f16503D0 = 0;
                }
                this.f16568o0 = null;
                m23442s9(false);
            }
            C11842p.m70712A2(this.f16909L1, this.f16544Y);
            m23439r9();
            List<CloudSpace> effectivePackages = this.f21452m.getEffectivePackages();
            CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
            MemGradeRights gradeRights = this.f21452m.getGradeRights();
            if (cloudSpaceM67757a == null) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "effective is null.");
                mo19477k5();
                return;
            }
            if (gradeRights == null) {
                C1442a.m8291w("CloudSpaceUpgradeActivity", "gradeRights is null.");
                mo19477k5();
                return;
            }
            this.f16928R3 = gradeRights.getGradeCode();
            CloudSpace cloudSpaceM16174r = C2783d.m16174r(effectivePackages, 12);
            CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 1);
            List<MemGradeRight> listM25370E = CurrentRightAdapter.m25370E(gradeRights.getRights());
            m23361M8(listM25370E, gradeRights.getGradeCode());
            m23329B9();
            m23369Q6(gradeRights, cloudSpaceM16174r);
            m23427n8(this.f16928R3, listM25370E);
            m23364N8(cloudSpaceM16171q != null, cloudSpaceM16174r != null);
            long jM67762f = C11293p.m67762f(this.f21452m);
            if (C13452e.m80781L().m80791C0()) {
                RelativeLayout relativeLayout = this.f16966l1;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                RelativeLayout relativeLayout2 = this.f16968m1;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                    ((LinearLayout) C12809f.m76829b(this, R$id.new_business_upgradepage_usercard_upgrade_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f17560a.m23383W7(view);
                        }
                    });
                }
            } else if (C10155f.m63293q(500L)) {
                this.f16972o1.setText(C11290m.m67746g(this, jM67762f, 1024, true, true));
            } else {
                this.f16972o1.setText(gradeRights.getGradeName());
            }
            m23346H8(this.f21452m.getUsed(), jM67762f);
            m23447u6();
            m23428n9();
            mo19476h5();
            mo22760E5(this.f16537U0);
            m22784M4("upgrade_purchase");
            this.f16929R4 = true;
            C1442a.m8290i("CloudSpaceUpgradeActivity", "showView finish");
            m23421l7();
            C13918b.m83437m().m83442k();
            m23436q9();
        }
    }

    /* renamed from: s7 */
    public final void m23440s7() throws JSONException {
        Serializable serializableExtra;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        int intExtra = safeIntent.getIntExtra("from_where", 0);
        try {
            serializableExtra = safeIntent.getSerializableExtra("activityInfo");
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "initDataForEnterActivity get payActivityInfo error " + e10.getMessage());
            serializableExtra = null;
        }
        if (serializableExtra != null && (serializableExtra instanceof PayActivityInfo)) {
            this.f16959h4 = (PayActivityInfo) serializableExtra;
        }
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra(Inviter.INVITE_CODE);
        String stringExtra5 = safeIntent.getStringExtra("tranUrlSuccess");
        String stringExtra6 = safeIntent.getStringExtra("tranUrlFail");
        this.f16504E = safeIntent.getIntExtra("aop_from_where", -1);
        C0216g0.m1402e(this).m1403A(stringExtra);
        this.f16985u4 = safeIntent.getBooleanExtra("is_from_front_app_notify", false);
        m22796R4(stringExtra, stringExtra2, stringExtra3);
        if (intExtra == 1) {
            this.f16525O0 = true;
            this.f16945Z3 = safeIntent.getStringExtra("package_id");
            m22814Y4(stringExtra4);
            m22800T4(stringExtra, stringExtra2, stringExtra3, stringExtra5, stringExtra6, stringExtra4);
            C1442a.m8288d("CloudSpaceUpgradeActivity", "h5Pakcageid = " + this.f16945Z3);
        } else if (intExtra == 2) {
            this.f16531R0 = true;
            this.f16533S0 = true;
        } else if (intExtra == 3) {
            try {
                this.f16963j4 = (GetPackagesBySpaceRuleResp) safeIntent.getSerializableExtra("backup_dialog_recommend_info");
            } catch (Exception e11) {
                C11839m.m70687e("CloudSpaceUpgradeActivity", "initDataForEnterActivity get recommendInfo error " + e11.getMessage());
            }
            this.f16527P0 = true;
        } else if (intExtra == 21) {
            try {
                this.f16963j4 = (GetPackagesBySpaceRuleResp) safeIntent.getSerializableExtra("backup_dialog_recommend_info");
            } catch (Exception e12) {
                C11839m.m70687e("CloudSpaceUpgradeActivity", "initDataForEnterActivity get recommendInfo error " + e12.getMessage());
            }
            this.f16527P0 = true;
            this.f16529Q0 = true;
        } else if (intExtra == 4) {
            this.f16543X0 = true;
            this.f16545Y0 = (CampaignInfo) safeIntent.getSerializableExtra("accept_sign_campaign_info");
        } else if (m23345H7()) {
            this.f16973o4 = true;
        } else if (intExtra == 5) {
            this.f16556e0 = true;
        } else if (intExtra == 6) {
            this.f16558f0 = true;
        } else if (intExtra == 22) {
            this.f16521M0 = true;
            this.f16523N0 = safeIntent.getStringExtra("aop_info");
        } else {
            this.f16525O0 = false;
        }
        this.f16987v4 = safeIntent.getBooleanExtra("is_total_space_scene", false);
        this.f16989w4 = safeIntent.getLongExtra("total_space_needed", 0L);
        C1442a.m8288d("initDataForEnterActivity srcChannel = " + stringExtra + ", salChannel = " + stringExtra2, ", activityCode = " + stringExtra3 + ", invite Code = " + stringExtra4);
        mo19460T3();
        m23433p8(safeIntent);
    }

    /* renamed from: s8 */
    public final void m23441s8() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("UNIFORM_CLOUDPAY_CLICK_EXCHANGE_MENU", linkedHashMap);
    }

    /* renamed from: s9 */
    public final void m23442s9(boolean z10) {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showWorryFreeCard:" + z10);
        if (z10) {
            this.f16893F4.setVisibility(8);
            this.f16908K4.setVisibility(8);
            this.f16880B3.setVisibility(8);
            C13227f.m79492i1().m79585f0("action_code_show_worry_free_card", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_upgrade_click_exchange", "1", "action_code_show_worry_free_card");
            return;
        }
        this.f16893F4.setVisibility(8);
        this.f16908K4.setVisibility(0);
        C1442a.m8290i("CloudSpaceUpgradeActivity", "showWorryFreeCard isShowBanner: " + this.f16981s4);
        mo23347I(this.f16981s4);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: t */
    public void mo23208t(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "reportClickEvent, eventObject is null.");
            return;
        }
        linkedHashMap.put("way_of_purchase", "upgrade_purchase");
        linkedHashMap.put("from_where", String.valueOf(new SafeIntent(getIntent()).getIntExtra("from_where", 0)));
        m22842j4(str, linkedHashMap);
    }

    /* renamed from: t6 */
    public final void m23443t6(LinkedHashMap<String, String> linkedHashMap) {
        CloudSpace cloudSpaceM67757a;
        UserPackage userPackage = this.f21452m;
        if (userPackage == null || (cloudSpaceM67757a = C11293p.m67757a(userPackage)) == null) {
            return;
        }
        linkedHashMap.put("package_id", cloudSpaceM67757a.getId());
        linkedHashMap.put("capacity", String.valueOf(cloudSpaceM67757a.getCapacity()));
        linkedHashMap.put("productType", String.valueOf(cloudSpaceM67757a.getType()));
        linkedHashMap.put("price", String.valueOf(cloudSpaceM67757a.getPrice()));
    }

    /* renamed from: t7 */
    public final void m23444t7() {
        C12515a.m75110o().m75175e(new C9060d(this.f16570q0, this.f16572s0, this.f16573t0, this.f16574u0, this.f16926Q4, 1002, false), false);
    }

    /* renamed from: t8 */
    public final void m23445t8() {
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_MANAGE_MONTHLY_PAYMENT", new LinkedHashMap<>());
    }

    /* renamed from: t9 */
    public final void m23446t9() throws JSONException {
        ConfirmBuyPackageDialog confirmBuyPackageDialog;
        if (this.f21452m == null) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess user is null.");
            return;
        }
        if (this.f16538V == null) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess params is null.");
            return;
        }
        if (this.f16547Z0 == null) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess mAcceptSignGiftResp is null.");
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess --->");
        AcceptSignGiftInfo gift = this.f16547Z0.getGift();
        if (gift == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess acceptSignGiftInfo is null.");
            mo19460T3();
            return;
        }
        this.f16539V0 = BigDecimal.ZERO;
        m22817Z4(new ArrayList());
        this.f16576w0 = "accept_sign_gift_purchase";
        m22778K4(gift.getId(), this.f16576w0);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("type", Integer.valueOf(gift.getDurationMonth()));
        C13227f.m79492i1().m79591l0("mecloud_upgrade_click_timelong", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "mecloud_upgrade_click_timelong", "1", "30", "type", String.valueOf(gift.getDurationMonth()));
        if (mo19458S4()) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess network is not connect.");
            m22751C4("failed_by_no_net");
            return;
        }
        int productType = gift.getProductType();
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        cloudSpace.setId(gift.getBaseId());
        this.f16520M.setProductType(productType);
        this.f16520M.setDurationMonth(gift.getDurationMonth());
        this.f16520M.setCapacity(gift.getCapacity());
        this.f16520M.setBaseCapacity(this.f21452m.getBaseCapacity());
        this.f16520M.setCurrency(gift.getCurrency());
        this.f16520M.setDurationUnit(gift.getDurationUnit());
        this.f16520M.setGrade(m23362N6(gift));
        this.f16520M.setPrice(gift.getAmount());
        ProgressDialog progressDialog = this.f21453n;
        if ((progressDialog != null && progressDialog.isShowing()) || ((confirmBuyPackageDialog = this.f16522N) != null && confirmBuyPackageDialog.isShowing())) {
            C1442a.m8288d("CloudSpaceUpgradeActivity", "startAcceptSignGiftProcess mWaittingDlg or dialog is showing");
            m22751C4("failed_by_dialog_waiting");
            return;
        }
        m22806V4(this.f16500C, this.f16502D, this.f16508G, this.f16506F);
        m22781L4(this.f16576w0, new ReportVoucherInfo());
        if (this.f16547Z0.getSignMode() == 1 && this.f16547Z0.getSignStatus() == 1) {
            this.f16536U.setRequestId(gift.getRequestId());
            this.f16536U.setId(gift.getBaseId());
            m22758E3();
        } else {
            m28588o1("06004");
            this.f16527P0 = false;
            this.f16532S = true;
            this.f16534T = true;
            m22794R1();
            m22803U4();
        }
    }

    /* renamed from: u6 */
    public final void m23447u6() {
        View view = this.f16891F1;
        if (view == null || this.f16894G1 == null || this.f16888E1 == null) {
            C1442a.m8291w("CloudSpaceUpgradeActivity", "adjustMargin error, layout is null");
            return;
        }
        if (view.getVisibility() == 8 && this.f16894G1.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f16894G1.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(0);
                this.f16894G1.setLayoutParams(layoutParams2);
            }
        }
        if (this.f16891F1.getVisibility() == 8 && this.f16894G1.getVisibility() == 8) {
            this.f16888E1.setVisibility(8);
        } else {
            this.f16888E1.setVisibility(0);
        }
        m23413h8();
    }

    /* renamed from: u8 */
    public final void m23448u8() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("UNIFORM_CLOUDPAY_CLICK_MORE_ICON", linkedHashMap);
    }

    /* renamed from: u9 */
    public final void m23449u9() {
        m22806V4(this.f16500C, this.f16502D, this.f16508G, this.f16506F);
        HashMap map = new HashMap();
        map.put("aopInfo", this.f16523N0);
        C9158a.m57503F().m57550o(this.f16524O, this.f21448i, true, map);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: v3 */
    public void mo22883v3() throws Resources.NotFoundException {
        C11839m.m70688i("CloudSpaceUpgradeActivity", "dealTaskCenterGetActivityEntryFail: ");
        m23328B8("mecloud_no_task_center_icon");
        this.f16996z1.setVisibility(8);
        m23371Q8(false);
    }

    /* renamed from: v6 */
    public final void m23450v6(final GradeCardBaseResourceBean gradeCardBaseResourceBean, final TextOnClickTextView textOnClickTextView) {
        textOnClickTextView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.r
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f17567a.m23355K7(textOnClickTextView, gradeCardBaseResourceBean);
            }
        });
    }

    /* renamed from: v7 */
    public List<GradePackageCardView> m23451v7(ArrayList<FilterAvailabalGradePackage> arrayList) {
        if (C0209d.m1205R0(arrayList)) {
            return new ArrayList();
        }
        final CloudSpace cloudSpaceM16174r = C2783d.m16174r(this.f21452m.getEffectivePackages(), 12);
        return C0225l.m1579c(arrayList, new Function() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17577a.m23360M7(cloudSpaceM16174r, (FilterAvailabalGradePackage) obj);
            }
        });
    }

    /* renamed from: v8 */
    public final void m23452v8() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_PURCHASE_CLOUD_CARD", linkedHashMap);
    }

    /* renamed from: v9 */
    public final void m23453v9() throws JSONException {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "startBackupDialogPay start");
        if (m23339F7()) {
            GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp = this.f16963j4;
            if (getPackagesBySpaceRuleResp == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startBackupDialogPay recommendInfo is null.");
                m22787N4();
                return;
            }
            List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
            if (spacePackages == null || spacePackages.isEmpty()) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startBackupDialogPay spacePackages is null.");
                m22787N4();
                return;
            }
            CloudPackage cloudPackage = spacePackages.get(0);
            if (cloudPackage == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startBackupDialogPay recommendPackage is null.");
                m22787N4();
                return;
            }
            List<PackageGrades> packageGrades = this.f16963j4.getPackageGrades();
            if (packageGrades == null || packageGrades.isEmpty()) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startBackupDialogPay packageGrades is null.");
                m22787N4();
                return;
            }
            PackageGrades packageGrades2 = packageGrades.get(0);
            if (packageGrades2 == null) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "startBackupDialogPay packageGrade is null.");
                m22787N4();
                return;
            }
            List<Voucher> voucherList = (C11296s.m67787K() && C11296s.m67789M(this)) ? C11296s.m67840x(this.f16963j4).getVoucherList() : null;
            String str = this.f16529Q0 ? "backup_dialog_purchase_v5" : "backup_dialog_purchase";
            if (voucherList == null || voucherList.isEmpty()) {
                m22885v5(cloudPackage, packageGrades2, str, new ArrayList(), m22882v2(), this.f21452m.getDeductAmount());
            } else {
                m22885v5(cloudPackage, packageGrades2, str, voucherList, m22882v2(), this.f21452m.getDeductAmount());
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: w3 */
    public void mo22887w3(Object obj) {
        if (obj instanceof GetActivityEntryResp) {
            GetActivityEntryResp getActivityEntryResp = (GetActivityEntryResp) obj;
            C11839m.m70688i("CloudSpaceUpgradeActivity", "GetActivityEntryResp: " + getActivityEntryResp.toString());
            ActivityEntry entry = getActivityEntryResp.getEntry();
            if (entry != null) {
                this.f16990x1 = entry.getUrl();
                this.f16993y1 = entry.getResource();
                DlAppCampInfo campaignInfo = entry.getCampaignInfo();
                if (campaignInfo == null) {
                    this.f16996z1.setVisibility(8);
                    m23328B8("mecloud_no_task_center_icon");
                    C11839m.m70687e("CloudSpaceUpgradeActivity", "get activity entry SUCCESS, but campaignInfo is null");
                    return;
                }
                this.f16975p4 = campaignInfo;
                AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
                this.f16575v0 = adParametersExt;
                if (adParametersExt == null) {
                    this.f16996z1.setVisibility(8);
                    m23328B8("mecloud_no_task_center_icon");
                    C11839m.m70687e("CloudSpaceUpgradeActivity", " but adParametersExt is null");
                    return;
                }
                this.f16572s0 = this.f16975p4.getMinLimit();
                this.f16573t0 = this.f16975p4.getLaunchNo();
                C10121i.m63036b(this.f16575v0);
                BannerFragment bannerFragment = this.f16886D3;
                if (bannerFragment != null) {
                    bannerFragment.m24117p(this.f16575v0);
                }
                if (TextUtils.isEmpty(this.f16575v0.getPpsAdid())) {
                    this.f16996z1.setVisibility(8);
                    m23328B8("mecloud_no_task_center_icon");
                    C11839m.m70687e("CloudSpaceUpgradeActivity", " PpsAdid is null");
                } else {
                    if (HicloudH5ConfigManager.getInstance().getClientVersion() >= getActivityEntryResp.getClientVersion()) {
                        C11839m.m70688i("CloudSpaceUpgradeActivity", "H5Config ClientVersion not updated ");
                        m23463y7(campaignInfo);
                        return;
                    }
                    C11839m.m70688i("CloudSpaceUpgradeActivity", "H5Config ClientVersion updated " + getActivityEntryResp.getClientVersion());
                    C12515a.m75110o().m75175e(new C10257p1(this.f16524O, getActivityEntryResp.getClientVersion(), 1006), false);
                }
            }
        }
    }

    /* renamed from: w6 */
    public final SpannableStringBuilder m23454w6(GradeCardBaseResourceBean gradeCardBaseResourceBean, CharSequence charSequence, boolean z10) {
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append(charSequence);
        spannableStringBuilderAppend.setSpan(new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(gradeCardBaseResourceBean.getNormalTextColor()), null), 0, charSequence.length(), 33);
        if (z10) {
            int length = charSequence.length();
            int i10 = R$string.payment_manager_button;
            int length2 = length + 1 + getString(i10).length();
            spannableStringBuilderAppend.append(' ').append((CharSequence) getString(i10));
            spannableStringBuilderAppend.setSpan(new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(gradeCardBaseResourceBean.getMediumTextColor()), null), length, length2, 33);
            m23462y6(gradeCardBaseResourceBean.getMediumTextColor(), spannableStringBuilderAppend);
        }
        return spannableStringBuilderAppend;
    }

    /* renamed from: w7 */
    public final void m23455w7() throws Resources.NotFoundException {
        C1442a.m8290i("CloudSpaceUpgradeActivity", "initPackagesViewPager");
        this.f16912M1 = (TextView) C12809f.m76829b(this, R$id.recommend_text_tv);
        this.f16915N1 = (TextView) C12809f.m76829b(this, R$id.recommend_more_tv);
        this.f16909L1 = (RelativeLayout) C12809f.m76829b(this, R$id.recommend_label_layout);
        this.f16915N1.setOnClickListener(this);
        this.f16906K1 = (WrapContentHeightViewPager) C12809f.m76829b(this, R$id.show_member_card);
        int iM70840n = C11842p.m70840n(this, 16);
        C3625l c3625l = new C3625l(this, m23380V6());
        this.f16933T3 = c3625l;
        this.f16906K1.setAdapter(c3625l);
        this.f16906K1.setCurrentItem(0);
        this.f16906K1.setPageMargin(iM70840n);
        this.f16906K1.setOffscreenPageLimit(3);
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f16906K1;
        wrapContentHeightViewPager.addOnPageChangeListener(new C3626m(wrapContentHeightViewPager));
        m23333D7();
        m23323A6(0, this.f16933T3.getCount());
    }

    /* renamed from: w8 */
    public final void m23456w8() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        m23443t6(linkedHashMap);
        m22842j4("UNIFORM_CLOUDPAY_CLICK_PURCHASE_MEMBER_CARD_MENU", linkedHashMap);
    }

    /* renamed from: w9 */
    public final void m23457w9() {
        if (this.f16923P4) {
            try {
                startActivity(new Intent(this, (Class<?>) CloudBackupSpaceInsufficientNewActivity.class));
            } catch (ActivityNotFoundException unused) {
                C1442a.m8289e("CloudSpaceUpgradeActivity", "morePkg not found");
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: x3 */
    public void mo22891x3(Object obj) {
        GetAvailableGradePackagesResp getAvailableGradePackagesResp;
        List<Voucher> availableVouchers;
        List<String> relatedPackages;
        if (!(obj instanceof GetAvailableGradePackagesResp) || (availableVouchers = (getAvailableGradePackagesResp = (GetAvailableGradePackagesResp) obj).getAvailableVouchers()) == null || availableVouchers.isEmpty() || (relatedPackages = availableVouchers.get(0).getRelatedPackages()) == null || relatedPackages.isEmpty()) {
            return;
        }
        this.f16956f4 = relatedPackages.get(0);
        for (CloudPackage cloudPackage : getAvailableGradePackagesResp.getSpacePackages()) {
            if (this.f16956f4.equals(cloudPackage.getId())) {
                this.f16957g4 = cloudPackage.getGradeCode();
            }
        }
    }

    /* renamed from: x6 */
    public final List<CharSequence> m23458x6(final GradeCardBaseResourceBean gradeCardBaseResourceBean, List<CharSequence> list) {
        m23353J8(gradeCardBaseResourceBean, true);
        return (List) list.stream().map(new Function() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17561a.m23357L7(gradeCardBaseResourceBean, (CharSequence) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: x7 */
    public final void m23459x7() {
        C11839m.m70688i("CloudSpaceUpgradeActivity", "init adloader, but no need.");
    }

    /* renamed from: x8 */
    public final void m23460x8(String str, String str2, String str3) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("right_code", str);
        linkedHashMap.put("grade_code", str2);
        linkedHashMap.put("clickSourceActivity", getClass().getSimpleName());
        linkedHashMap.put("click_source_type", str3);
        m22884v4(linkedHashMap);
    }

    /* renamed from: x9 */
    public final void m23461x9() throws JSONException {
        if (C11829c.m70626w0() && this.f16550b0 == null) {
            return;
        }
        if (m23428n9()) {
            m22803U4();
            m22859p2();
            mo19476h5();
            return;
        }
        if (this.f21452m == null || this.f16947a4 == null) {
            return;
        }
        C1442a.m8290i("CloudSpaceUpgradeActivity", "startH5Pay");
        List<CloudPackage> spacePackages = this.f16947a4.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "startH5Pay cloudPackageList is empty.");
            m23408f9(19);
            return;
        }
        List<PackageGrades> packageGrades = this.f16947a4.getPackageGrades();
        if (packageGrades == null || packageGrades.isEmpty()) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "startH5Pay packageGradesList is empty.");
            m23408f9(19);
            return;
        }
        CloudPackage cloudPackage = spacePackages.get(0);
        if (cloudPackage == null) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "startH5Pay cloudPackage is empty.");
            m23408f9(19);
            return;
        }
        PackageGrades packageGrades2 = packageGrades.get(0);
        if (packageGrades2 != null) {
            m22885v5(cloudPackage, packageGrades2, "h5_purchase", new ArrayList(), m22882v2(), this.f21452m.getDeductAmount());
        } else {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "startH5Pay packageGrades is empty.");
            m23408f9(19);
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: y */
    public void mo23213y(CloudPackage cloudPackage, PackageGrades packageGrades, int i10) {
        m22872s4(cloudPackage, packageGrades, "upgrade_purchase", i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: y3 */
    public void mo22895y3(Object obj) throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        m23442s9(false);
        mo19479s5();
        this.f16569p0 = 0;
    }

    /* renamed from: y6 */
    public final void m23462y6(int i10, SpannableStringBuilder spannableStringBuilder) {
        C13021b c13021b = new C13021b(C11842p.m70793b0(this, i10), getResources().getDimensionPixelOffset(R$dimen.vip_card_mini_text_arrow_padding), " ");
        spannableStringBuilder.append(" ").append(' ');
        spannableStringBuilder.setSpan(c13021b, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
    }

    /* renamed from: y7 */
    public final void m23463y7(DlAppCampInfo dlAppCampInfo) {
        if (dlAppCampInfo == null) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", "campInfo null");
            return;
        }
        int minLimit = dlAppCampInfo.getMinLimit();
        int launchNo = dlAppCampInfo.getLaunchNo();
        AdParametersExt adParametersExt = dlAppCampInfo.getAdParametersExt();
        if (adParametersExt == null) {
            C11839m.m70687e("CloudSpaceUpgradeActivity", " parametersExt is null");
        } else {
            C12515a.m75110o().m75175e(new C9060d(this.f16993y1, minLimit, launchNo, adParametersExt.getPpsAdid(), this.f16926Q4, 1006, false), false);
        }
    }

    /* renamed from: y8 */
    public final void m23464y8() {
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            String stringExtra = safeIntent.getStringExtra("srcChannel");
            String stringExtra2 = safeIntent.getStringExtra("salChannel");
            String stringExtra3 = safeIntent.getStringExtra("activityCode");
            String stringExtra4 = safeIntent.getStringExtra("pkg_name");
            String stringExtra5 = safeIntent.getStringExtra("sceneCode");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("sceneCode", stringExtra5);
            linkedHashMapM79497A.put("pay_sal_channel", stringExtra2);
            linkedHashMapM79497A.put("pay_src_channel", stringExtra);
            linkedHashMapM79497A.put("pay_activity_code", stringExtra3);
            linkedHashMapM79497A.put("pay_pkg_name", stringExtra4);
            linkedHashMapM79497A.put("forOtherPage", f16875V4);
            linkedHashMapM79497A.put("from_where", String.valueOf(safeIntent.getIntExtra("from_where", 0)));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_ENTER_UPGRADEACITIVY", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_ENTER_UPGRADEACITIVY", "1", "7", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_ENTER_UPGRADEACITIVY", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceUpgradeActivity", "reportEnterUpgradeActivity error occur:" + e10.getMessage());
        }
    }

    /* renamed from: y9 */
    public final void m23465y9(List<Voucher> list, CloudPackage cloudPackage, PackageGrades packageGrades) throws JSONException {
        if (this.f16932T1.getVisibility() == 0) {
            C1442a.m8290i("CloudSpaceUpgradeActivity", "startWorryPayProcess , viewLoading is visible.");
        } else if (list == null || list.size() < 1) {
            m22880u5(cloudPackage, packageGrades, "upgrade_purchase", null, m22886w2(true), null, this.f21452m.getDeductAmount());
        } else {
            m22880u5(cloudPackage, packageGrades, "upgrade_purchase", list, m22886w2(true), null, this.f21452m.getDeductAmount());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: z5 */
    public void mo22901z5() throws JSONException, IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        mo19476h5();
    }

    /* renamed from: z6 */
    public final void m23466z6() throws Resources.NotFoundException {
        if (this.f16906K1 == null) {
            this.f16906K1 = (WrapContentHeightViewPager) C12809f.m76829b(this, R$id.show_member_card);
        }
        int currentItem = this.f16906K1.getCurrentItem();
        int iM70840n = C11842p.m70840n(this, 16);
        C3625l c3625l = new C3625l(this, m23380V6());
        this.f16933T3 = c3625l;
        this.f16906K1.setAdapter(c3625l);
        this.f16906K1.setCurrentItem(currentItem);
        this.f16906K1.setPageMargin(iM70840n);
        m23323A6(currentItem, this.f16933T3.getCount());
    }

    /* renamed from: z9 */
    public final boolean m23467z9(QueryPushGuideRsp queryPushGuideRsp) {
        if (this.f16531R0 || this.f16533S0) {
            C11839m.m70688i("CloudSpaceUpgradeActivity", "from push guide,no show again");
            return true;
        }
        if (!m23330C6(queryPushGuideRsp)) {
            return true;
        }
        if (this.f16579z0 && this.f16498A0) {
            return false;
        }
        C11839m.m70688i("CloudSpaceUpgradeActivity", "data no ready");
        return true;
    }
}
