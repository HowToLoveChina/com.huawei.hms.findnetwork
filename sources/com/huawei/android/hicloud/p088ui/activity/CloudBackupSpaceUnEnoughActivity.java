package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TipCommonView;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$menu;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.notification.manager.HiCloudSceneSpaceMgrManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipData;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gl.C9964e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p010a9.C0079a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0234s;
import p015ak.C0241z;
import p054cj.C1442a;
import p292fn.C9733f;
import p336he.C10152c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupSpaceUnEnoughActivity extends CloudBackupSpaceGuideActivitty {

    /* renamed from: A3 */
    public View f14071A3;

    /* renamed from: C3 */
    public List<BackupOptionItem> f14073C3;

    /* renamed from: D3 */
    public RelativeLayout f14074D3;

    /* renamed from: E1 */
    public TextView f14075E1;

    /* renamed from: E3 */
    public List<Voucher> f14076E3;

    /* renamed from: F1 */
    public TextView f14077F1;

    /* renamed from: F3 */
    public ImageView f14078F3;

    /* renamed from: G1 */
    public ViewPager f14079G1;

    /* renamed from: H1 */
    public ImageView f14081H1;

    /* renamed from: I1 */
    public ImageView f14083I1;

    /* renamed from: J1 */
    public ArrayList<Object> f14085J1;

    /* renamed from: K1 */
    public LinearLayout f14087K1;

    /* renamed from: L1 */
    public ImageView f14088L1;

    /* renamed from: M1 */
    public TextView f14089M1;

    /* renamed from: N1 */
    public TextView f14090N1;

    /* renamed from: O1 */
    public LinearLayout f14091O1;

    /* renamed from: P1 */
    public ImageView f14092P1;

    /* renamed from: Q1 */
    public TextView f14093Q1;

    /* renamed from: R1 */
    public TextView f14094R1;

    /* renamed from: S1 */
    public LinearLayout f14095S1;

    /* renamed from: T1 */
    public ImageView f14096T1;

    /* renamed from: U1 */
    public TextView f14097U1;

    /* renamed from: V1 */
    public TextView f14098V1;

    /* renamed from: W1 */
    public LinearLayout f14099W1;

    /* renamed from: X1 */
    public ImageView f14100X1;

    /* renamed from: Y1 */
    public TextView f14101Y1;

    /* renamed from: Z1 */
    public TextView f14102Z1;

    /* renamed from: a2 */
    public View f14103a2;

    /* renamed from: b2 */
    public View f14104b2;

    /* renamed from: c2 */
    public View f14105c2;

    /* renamed from: d2 */
    public PackageGrades f14106d2;

    /* renamed from: e2 */
    public CloudPackage f14107e2;

    /* renamed from: x3 */
    public List<CBSDevice> f14108x3;

    /* renamed from: y3 */
    public boolean f14109y3;

    /* renamed from: z3 */
    public TipCommonView f14110z3;

    /* renamed from: B3 */
    public C13149f f14072B3 = new C13149f();

    /* renamed from: G3 */
    public int f14080G3 = 3;

    /* renamed from: H3 */
    public PackageParamUtil.VouchersCallBack f14082H3 = new C3189a();

    /* renamed from: I3 */
    public boolean f14084I3 = false;

    /* renamed from: J3 */
    public ViewPager.InterfaceC0980i f14086J3 = new C3192d();

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$a */
    public class C3189a implements PackageParamUtil.VouchersCallBack {
        public C3189a() {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil.VouchersCallBack
        public void onVouchersCallBack(List<Voucher> list) {
            C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "onVouchersCallBack");
            CloudBackupSpaceUnEnoughActivity.this.f14076E3 = list;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$b */
    public class C3190b extends AbstractC12367d {

        /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$b$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ long f14113a;

            public a(long j10) {
                this.f14113a = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                RecommendNeedData recommendNeedData = CloudBackupSpaceUnEnoughActivity.this.f14059t1;
                if (recommendNeedData != null) {
                    C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "getWaitSize increase =" + this.f14113a + " backupNeedSpace =" + recommendNeedData.getBackupNeedSpace());
                    CloudBackupSpaceUnEnoughActivity.this.f14059t1.setBackupNeedSpace(this.f14113a);
                }
                CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity = CloudBackupSpaceUnEnoughActivity.this;
                cloudBackupSpaceUnEnoughActivity.m19467Y5(cloudBackupSpaceUnEnoughActivity.f14055p1);
            }
        }

        public C3190b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C0226l0.m1584d(new a(C12590s0.m75923y(true).m69963a()));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$c */
    public class ViewOnClickListenerC3191c implements View.OnClickListener {
        public ViewOnClickListenerC3191c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudBackupSpaceUnEnoughActivity.this.f14110z3 != null) {
                CloudBackupSpaceUnEnoughActivity.this.f14110z3.dismiss();
            }
            CloudBackupSpaceUnEnoughActivity.this.m22869r4("cloudbackup_space_unenough_detail2_click_help");
            CloudBackupSpaceUnEnoughActivity.this.f16501C0 = true;
            CloudBackupSpaceUnEnoughActivity.this.m19486F7();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$d */
    public class C3192d implements ViewPager.InterfaceC0980i {
        public C3192d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            CloudBackupSpaceUnEnoughActivity.this.m19558v7(i10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$e */
    public class C3193e extends AbstractC0984a implements RenewAgreementTextview.RenewAgreementTVCallback {

        /* renamed from: h */
        public ArrayList<Object> f14117h;

        /* renamed from: i */
        public Context f14118i;

        /* renamed from: j */
        public LinearLayout f14119j;

        /* renamed from: k */
        public ImageView f14120k;

        /* renamed from: l */
        public RenewAgreementTextview f14121l;

        /* renamed from: m */
        public boolean f14122m;

        /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$e$a */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C3193e.this.f14122m) {
                    C3193e.this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_off));
                    C3193e.this.f14122m = false;
                } else {
                    C3193e.this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_on));
                    C3193e.this.f14122m = true;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("renew_checkbox_status", String.valueOf(C3193e.this.f14122m));
                linkedHashMap.put("way_of_purchase", "recommend2_purchase");
                CloudBackupSpaceUnEnoughActivity.this.m22842j4("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMap);
            }
        }

        /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$e$b */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws JSONException {
                if (C0209d.m1226Y0()) {
                    C11839m.m70689w("CloudBackupSpaceUnEnoughActivity", "order_now_btn click too fast");
                } else {
                    CloudBackupSpaceUnEnoughActivity.this.m19539D7();
                    C3193e.this.m19567f();
                }
            }
        }

        /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$e$c */
        public class c implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
            public c() {
            }

            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
            public void refreshCheckboxStatus(boolean z10) {
                if (C3193e.this.f14120k == null) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "refreshCheckboxStatus, renewCheckboxView is null.");
                    return;
                }
                if (z10) {
                    C3193e.this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_on));
                } else {
                    C3193e.this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_off));
                }
                C3193e.this.f14122m = z10;
            }

            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
            public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
                linkedHashMap.put("way_of_purchase", "recommend2_purchase");
                CloudBackupSpaceUnEnoughActivity.this.m22842j4(str, linkedHashMap);
            }

            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
            public void startPaymentProcess(C0079a c0079a) throws JSONException {
                if (c0079a == null) {
                    C1442a.m8289e("CloudBackupSpaceUnEnoughActivity", "startPaymentProcess, agreementDialogNeedData is null.");
                } else {
                    C3193e.this.m19572k();
                }
            }
        }

        public C3193e(Context context, ArrayList<Object> arrayList) {
            this.f14117h = arrayList;
            this.f14118i = context;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            if (obj == null || !(obj instanceof View)) {
                return;
            }
            viewGroup.removeView((View) obj);
        }

        /* renamed from: f */
        public final void m19567f() throws JSONException {
            LinearLayout linearLayout = this.f14119j;
            if (linearLayout == null || linearLayout.getVisibility() != 0 || this.f14122m) {
                m19572k();
                return;
            }
            C0079a c0079a = new C0079a();
            c0079a.m652i(CloudBackupSpaceUnEnoughActivity.this.f16538V.getCheckDialogRenewAgreement());
            c0079a.m651h(new c());
            ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(CloudBackupSpaceUnEnoughActivity.this, c0079a);
            confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
            confirmRenewAgreementDialog.show();
        }

        /* renamed from: g */
        public final String m19568g() {
            return C13452e.m80781L().m80887a1() ? CloudBackupSpaceUnEnoughActivity.this.f21452m.getIsAutoPay() == 1 ? CloudBackupSpaceUnEnoughActivity.this.getString(R$string.change_plan) : CloudBackupSpaceUnEnoughActivity.this.getString(R$string.cloudpay_subscribe_now) : CloudBackupSpaceUnEnoughActivity.this.getString(R$string.upgrade_now);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            ArrayList<Object> arrayList = this.f14117h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        /* renamed from: h */
        public final View m19569h(Object obj) throws Resources.NotFoundException {
            View viewInflate = LayoutInflater.from(this.f14118i).inflate(R$layout.space_clear_content, (ViewGroup) null);
            TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.tv_recommend_clear);
            TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_time_unbackup);
            TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_wait_clear_size);
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.bt_clear_now);
            long j10 = 0;
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 0) {
                    long j11 = 0;
                    for (Object obj2 : list) {
                        if (obj2 == null) {
                            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "cbsDevice is null");
                        } else if (obj2 instanceof CBSDevice) {
                            long jM1688f = C0241z.m1688f(((CBSDevice) obj2).getDeviceSpace());
                            if (jM1688f != 0) {
                                j11 += jM1688f;
                            }
                        }
                    }
                    j10 = j11;
                }
            }
            boolean zM70765S0 = C11842p.m70765S0();
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "loadRecommendClearPageView rtl =" + zM70765S0);
            textView.setText(R$string.recomend_clear);
            textView.setBackgroundResource(zM70765S0 ? R$drawable.storage_manage_cardview_list_shape_blue_mirror : R$drawable.storage_manage_cardview_list_shape_blue);
            String quantityString = this.f14118i.getResources().getQuantityString(R$plurals.long_ago_cloudbackup, CloudBackupSpaceUnEnoughActivity.this.f14080G3, Integer.valueOf(CloudBackupSpaceUnEnoughActivity.this.f14080G3));
            int iM70840n = C11842p.m70840n(this.f14118i, 30);
            String strValueOf = String.valueOf(CloudBackupSpaceUnEnoughActivity.this.f14080G3);
            int iIndexOf = quantityString.indexOf(strValueOf);
            int length = strValueOf.length();
            SpannableStringBuilder spannableStringBuilderM19542e6 = CloudBackupSpaceUnEnoughActivity.this.m19542e6(quantityString, strValueOf, iM70840n);
            int i10 = length + iIndexOf;
            if (iIndexOf >= 0 && quantityString.length() > i10) {
                spannableStringBuilderM19542e6.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, i10, 33);
            }
            textView2.setText(spannableStringBuilderM19542e6);
            textView3.setText(C0223k.m1524g(this.f14118i, j10));
            C11842p.m70866t1(this.f14118i, autoSizeButton);
            autoSizeButton.setOnClickListener(CloudBackupSpaceUnEnoughActivity.this);
            autoSizeButton.setText(R$string.cleanup_now);
            return viewInflate;
        }

        /* renamed from: i */
        public final View m19570i(CloudPackage cloudPackage) {
            View viewInflate;
            SpannableStringBuilder spannableStringBuilderM19542e6;
            boolean z10 = cloudPackage.getProductType() == 12;
            float fM1195O = C0209d.m1195O(this.f14118i);
            boolean z11 = fM1195O >= 1.75f;
            if (z10) {
                viewInflate = LayoutInflater.from(this.f14118i).inflate(z11 ? R$layout.space_worry_free_recommend_content_scale : R$layout.space_worry_free_recommend_content, (ViewGroup) null);
            } else {
                viewInflate = LayoutInflater.from(this.f14118i).inflate(z11 ? R$layout.space_recommend_content_scale : R$layout.space_recommend_content, (ViewGroup) null);
            }
            View view = viewInflate;
            TextView textView = (TextView) C12809f.m76831d(view, R$id.tv_recommend_bg);
            LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(view, R$id.rl_package_detail);
            TextView textView2 = (TextView) C12809f.m76831d(view, R$id.tv_package_writer);
            TextView textView3 = (TextView) C12809f.m76831d(view, R$id.tv_package_price);
            TextView textView4 = (TextView) C12809f.m76831d(view, R$id.tv_continue_mode);
            TextView textView5 = (TextView) C12809f.m76831d(view, R$id.tv_package_desc);
            this.f14119j = (LinearLayout) C12809f.m76831d(view, R$id.recommend_second_renew_check_area);
            this.f14121l = (RenewAgreementTextview) C12809f.m76831d(view, R$id.recommend_second_renew_text);
            ImageView imageView = (ImageView) C12809f.m76831d(view, R$id.recommend_second_renew_check_view);
            this.f14120k = imageView;
            imageView.setOnClickListener(new a());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14120k.getLayoutParams();
            layoutParams.topMargin = fM1195O < 1.75f ? (C11842p.m70771U0() || C11842p.m70753O0(CloudBackupSpaceUnEnoughActivity.this)) ? C11842p.m70840n(CloudBackupSpaceUnEnoughActivity.this, 6) : 0 : C11842p.m70840n(CloudBackupSpaceUnEnoughActivity.this, 8);
            this.f14120k.setLayoutParams(layoutParams);
            m19571j(this);
            String memAD = cloudPackage.getMemAD();
            if (TextUtils.isEmpty(memAD)) {
                textView5.setVisibility(8);
            } else {
                textView5.setText(memAD);
            }
            String durationTag = cloudPackage.getDurationTag();
            if (TextUtils.isEmpty(durationTag)) {
                textView.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                int iM70840n = C11842p.m70840n(CloudBackupSpaceUnEnoughActivity.this, 18);
                layoutParams2.setMargins(iM70840n, C11842p.m70840n(CloudBackupSpaceUnEnoughActivity.this, 16), iM70840n, 0);
                linearLayout.setLayoutParams(layoutParams2);
            } else {
                textView.setVisibility(0);
                textView.setText(durationTag);
                boolean zM70765S0 = C11842p.m70765S0();
                C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "loadRecommendPakeageView rtl =" + zM70765S0);
                textView.setBackgroundResource(zM70765S0 ? R$drawable.storage_manage_cardview_list_shape_blue_mirror : R$drawable.storage_manage_cardview_list_shape_blue);
            }
            long capacity = cloudPackage.getCapacity();
            int iM70840n2 = C11842p.m70840n(this.f14118i, 20);
            if (z10) {
                String productName = cloudPackage.getProductName();
                String strProcWorryFreeDurationText = PackageParamUtil.procWorryFreeDurationText(this.f14118i, cloudPackage);
                textView.setVisibility(8);
                spannableStringBuilderM19542e6 = CloudBackupSpaceUnEnoughActivity.this.m19542e6(this.f14118i.getString(R$string.payment_renewal_package_size, productName, strProcWorryFreeDurationText), productName, iM70840n2);
                textView4.setText(cloudPackage.getRemark3());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f14119j.getLayoutParams();
                if (!C0234s.m1643u() || fM1195O > 1.0f) {
                    layoutParams3.bottomMargin = 0;
                } else {
                    layoutParams3.bottomMargin = C11842p.m70840n(this.f14118i, 42);
                }
                this.f14119j.setLayoutParams(layoutParams3);
            } else {
                String productName2 = PackageParamUtil.getProductName(cloudPackage, CloudBackupSpaceUnEnoughActivity.this.f16538V);
                String strReplace = C0223k.m1524g(this.f14118i, capacity).replace(" ", "");
                spannableStringBuilderM19542e6 = CloudBackupSpaceUnEnoughActivity.this.m19542e6(this.f14118i.getString(R$string.payment_renewal_package_size, strReplace, productName2), strReplace, iM70840n2);
                PackageParamUtil.showReMemark(textView4, cloudPackage, CloudBackupSpaceUnEnoughActivity.this.f16538V);
            }
            textView2.setText(spannableStringBuilderM19542e6);
            PackageParamUtil.showSelectVouchersPrice(CloudBackupSpaceUnEnoughActivity.this.f16535T0, textView3, cloudPackage, this.f14118i, CloudBackupSpaceUnEnoughActivity.this.f14082H3, CloudBackupSpaceUnEnoughActivity.this.f21452m.getDeductAmount());
            AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(view, R$id.bt_order_now);
            autoSizeButton.setText(m19568g());
            autoSizeButton.setOnClickListener(new b());
            return view;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "instantiateItem  position =" + i10);
            Object obj = this.f14117h.get(i10);
            View viewM19570i = obj instanceof CloudPackage ? m19570i((CloudPackage) obj) : m19569h(obj);
            viewGroup.addView(viewM19570i);
            return viewM19570i;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public boolean isViewFromObject(View view, Object obj) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isViewFromObject ");
            sb2.append(view == obj);
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", sb2.toString());
            return view == obj;
        }

        /* renamed from: j */
        public void m19571j(RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
            if (C13452e.m80781L().m80803F0().booleanValue()) {
                if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                    C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, switch is close.");
                    return;
                }
                if (CloudBackupSpaceUnEnoughActivity.this.f14107e2 == null) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, selectCloudPackage is null.");
                    return;
                }
                int productType = CloudBackupSpaceUnEnoughActivity.this.f14107e2.getProductType();
                if (productType != 6 && productType != 8 && productType != 12) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, invalid productType = " + productType);
                    return;
                }
                if (this.f14119j == null) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, renewCheckViewArea is null.");
                    return;
                }
                String packageCardAgreement = CloudBackupSpaceUnEnoughActivity.this.f16538V.getPackageCardAgreement();
                String checkDialogRenewAgreement = CloudBackupSpaceUnEnoughActivity.this.f16538V.getCheckDialogRenewAgreement();
                if (TextUtils.isEmpty(packageCardAgreement)) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, packageCardRenewAgreementText is null.");
                    return;
                }
                if (TextUtils.isEmpty(checkDialogRenewAgreement)) {
                    C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "showRenewAgreement, checkDialogRenewAgreementText is null.");
                    return;
                }
                this.f14119j.setVisibility(0);
                if (this.f14122m) {
                    this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_on));
                } else {
                    this.f14120k.setBackground(CloudBackupSpaceUnEnoughActivity.this.getDrawable(R$drawable.renew_check_icon_off));
                }
                String string = CloudBackupSpaceUnEnoughActivity.this.getString(R$string.cloudpay_monthly_renew_agreement);
                String string2 = CloudBackupSpaceUnEnoughActivity.this.getString(R$string.cloudpay_user_agreement);
                this.f14121l.m25806w(String.format(packageCardAgreement, string2, string), string2, string, CloudBackupSpaceUnEnoughActivity.this, renewAgreementTVCallback);
                this.f14121l.setTextColor(CloudBackupSpaceUnEnoughActivity.this.getResources().getColor(R$color.view_details_text_color));
            }
        }

        @Override // com.huawei.android.hicloud.ui.views.RenewAgreementTextview.RenewAgreementTVCallback
        /* renamed from: j0 */
        public void mo18858j0(boolean z10) {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("way_of_purchase", "recommend2_purchase");
            CloudBackupSpaceUnEnoughActivity.this.m22842j4(z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", linkedHashMapM79497A);
        }

        /* renamed from: k */
        public final void m19572k() throws JSONException {
            if (CloudBackupSpaceUnEnoughActivity.this.f14107e2 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (CloudBackupSpaceUnEnoughActivity.this.f14076E3 != null) {
                arrayList.addAll(CloudBackupSpaceUnEnoughActivity.this.f14076E3);
            }
            ReportVoucherInfo reportVoucherInfo = new ReportVoucherInfo();
            CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity = CloudBackupSpaceUnEnoughActivity.this;
            cloudBackupSpaceUnEnoughActivity.m22880u5(cloudBackupSpaceUnEnoughActivity.f14107e2, CloudBackupSpaceUnEnoughActivity.this.f14106d2, "recommend2_purchase", arrayList, CloudBackupSpaceUnEnoughActivity.this.m22882v2(), reportVoucherInfo, CloudBackupSpaceUnEnoughActivity.this.f21452m.getDeductAmount());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$f */
    public class C3194f extends AbstractC12367d {
        public C3194f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            GetOptionsInfoFromCloneTask.checkCacheInvalid();
            final List<BackupOptionItem> listQueryRecommendOptions = TransferedUtil.queryRecommendOptions();
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.w2
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f17785a.m19574d(listQueryRecommendOptions);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m19574d(List list) throws Resources.NotFoundException {
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "GetRecommendOptions showView");
            CloudBackupSpaceUnEnoughActivity.this.f14073C3 = list;
            CloudBackupSpaceUnEnoughActivity.this.mo19479s5();
            CloudBackupSpaceUnEnoughActivity.this.f14091O1.setVisibility(8);
            CloudBackupSpaceUnEnoughActivity.this.f14095S1.setVisibility(8);
            CloudBackupSpaceUnEnoughActivity.this.f14099W1.setVisibility(8);
            CloudBackupSpaceUnEnoughActivity.this.f14105c2.setVisibility(8);
            CloudBackupSpaceUnEnoughActivity.this.f14104b2.setVisibility(8);
            CloudBackupSpaceUnEnoughActivity.this.f14103a2.setVisibility(8);
            if (CloudBackupSpaceUnEnoughActivity.this.f14073C3.isEmpty()) {
                CloudBackupSpaceUnEnoughActivity.this.f14074D3.setVisibility(8);
                return;
            }
            CloudBackupSpaceUnEnoughActivity.this.f14074D3.setVisibility(0);
            for (int i10 = 0; i10 < CloudBackupSpaceUnEnoughActivity.this.f14073C3.size(); i10++) {
                BackupOptionItem backupOptionItem = (BackupOptionItem) CloudBackupSpaceUnEnoughActivity.this.f14073C3.get(i10);
                if (i10 == 0) {
                    CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity = CloudBackupSpaceUnEnoughActivity.this;
                    cloudBackupSpaceUnEnoughActivity.m19536A7(backupOptionItem, cloudBackupSpaceUnEnoughActivity.f14087K1, CloudBackupSpaceUnEnoughActivity.this.f14088L1, CloudBackupSpaceUnEnoughActivity.this.f14089M1, CloudBackupSpaceUnEnoughActivity.this.f14090N1);
                } else if (i10 == 1) {
                    CloudBackupSpaceUnEnoughActivity.this.f14105c2.setVisibility(0);
                    CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity2 = CloudBackupSpaceUnEnoughActivity.this;
                    cloudBackupSpaceUnEnoughActivity2.m19536A7(backupOptionItem, cloudBackupSpaceUnEnoughActivity2.f14091O1, CloudBackupSpaceUnEnoughActivity.this.f14092P1, CloudBackupSpaceUnEnoughActivity.this.f14093Q1, CloudBackupSpaceUnEnoughActivity.this.f14094R1);
                } else if (i10 == 2) {
                    CloudBackupSpaceUnEnoughActivity.this.f14104b2.setVisibility(0);
                    CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity3 = CloudBackupSpaceUnEnoughActivity.this;
                    cloudBackupSpaceUnEnoughActivity3.m19536A7(backupOptionItem, cloudBackupSpaceUnEnoughActivity3.f14095S1, CloudBackupSpaceUnEnoughActivity.this.f14096T1, CloudBackupSpaceUnEnoughActivity.this.f14097U1, CloudBackupSpaceUnEnoughActivity.this.f14098V1);
                } else if (i10 == 3) {
                    CloudBackupSpaceUnEnoughActivity.this.f14103a2.setVisibility(0);
                    CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity4 = CloudBackupSpaceUnEnoughActivity.this;
                    cloudBackupSpaceUnEnoughActivity4.m19536A7(backupOptionItem, cloudBackupSpaceUnEnoughActivity4.f14099W1, CloudBackupSpaceUnEnoughActivity.this.f14100X1, CloudBackupSpaceUnEnoughActivity.this.f14101Y1, CloudBackupSpaceUnEnoughActivity.this.f14102Z1);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$g */
    public class C3195g extends AbstractC12367d {

        /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceUnEnoughActivity$g$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ List f14129a;

            public a(List list) {
                this.f14129a = list;
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                CloudBackupSpaceUnEnoughActivity.this.m19537B7(this.f14129a);
            }
        }

        public C3195g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (CloudBackupSpaceUnEnoughActivity.this.f14080G3 > 0) {
                boolean z10 = false;
                List<CBSDevice> listM61826o = C9964e.m61814f().m61826o(false, CloudBackupSpaceUnEnoughActivity.this.f14080G3);
                CloudBackupSpaceUnEnoughActivity cloudBackupSpaceUnEnoughActivity = CloudBackupSpaceUnEnoughActivity.this;
                if (listM61826o != null && listM61826o.size() > 0) {
                    z10 = true;
                }
                cloudBackupSpaceUnEnoughActivity.m19555s7(z10);
                C0226l0.m1584d(new a(listM61826o));
            }
        }
    }

    /* renamed from: F7 */
    public void m19486F7() {
        RecommendTipData recommendTipData = this.f14061v1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "recommendTipData is null help not display");
            return;
        }
        if (TextUtils.isEmpty(recommendTipData.getHelpUrl())) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "help url is null");
            return;
        }
        Intent intent = new Intent(this, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("srcChannel", true);
        intent.putExtra("salChannel", true);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("url", this.f14061v1.getHelpUrl());
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 5);
        intent.putExtra("backUpTime", String.valueOf(C2783d.m16190y()));
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData != null) {
            long backupNeedSpace = recommendNeedData.getBackupNeedSpace();
            long notUsedSpace = this.f14059t1.getNotUsedSpace();
            if (notUsedSpace < 0) {
                notUsedSpace = 0;
            }
            String strM1524g = C0223k.m1524g(this, backupNeedSpace);
            String strM1524g2 = C0223k.m1524g(this, notUsedSpace);
            intent.putExtra("needSpace", strM1524g);
            intent.putExtra("nowSpace", strM1524g2);
        }
        intent.putExtra("drawCloudSpace", String.valueOf(this.f14064y1));
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "startActivity exception: " + e10.toString());
        }
    }

    /* renamed from: k7 */
    private LinkedHashMap m19517k7() {
        return new LinkedHashMap();
    }

    /* renamed from: p7 */
    private void m19523p7() {
        this.f14080G3 = HiCloudSceneSpaceMgrManager.getInstance().getOverMonths(C13466f.m81073d().m81075b("backup_key", false) ? 1 : 0);
    }

    /* renamed from: q7 */
    private void m19525q7(View view) throws Resources.NotFoundException {
        RecommendTipData recommendTipData = this.f14061v1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "initHelp recommendTipData is null help not display");
            return;
        }
        if (!TextUtils.isEmpty(recommendTipData.getDisplayHelp()) && C10152c.m63233q(this.f14061v1.getDisplayHelp()) && C10152c.m63232p(this.f14061v1.getDialogViewDetailsNum(), this.f14061v1.getDialogPopTimesThreshold())) {
            String strM63228l = C10152c.m63228l(this.f14061v1.getTipId(), this.f14061v1.getNotificationId());
            if (TextUtils.isEmpty(strM63228l)) {
                return;
            }
            this.f16501C0 = true;
            TipCommonView tipCommonView = new TipCommonView(this);
            this.f14110z3 = tipCommonView;
            tipCommonView.showLeftTip(view, strM63228l);
        }
    }

    /* renamed from: y7 */
    private void m19534y7() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "setActionbarTitle actionBar is null.");
            return;
        }
        actionBar.setHomeAsUpIndicator(R$drawable.cloud_space_guide_back_icon);
        actionBar.setTitle(C13452e.m80781L().m80887a1() ? R$string.full_data_service : R$string.cloudpay_cloud_backup_item_title);
        m19560x7(actionBar);
    }

    /* renamed from: A7 */
    public final void m19536A7(BackupOptionItem backupOptionItem, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        String appId = backupOptionItem.getAppId();
        if ("virtualApp".equals(backupOptionItem.getParent())) {
            textView.setText(CloudBackupLanguageUtil.getVirtualName(appId));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId, null));
        } else if (C14333b.m85483r().containsKey(appId)) {
            textView.setText(C2783d.m16079E(this, appId));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId));
        } else {
            textView.setText(C14333b.f63653e.containsKey(appId) ? C2783d.m16079E(this, appId) : m19549l7(backupOptionItem));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
        }
        textView2.setText(C0223k.m1524g(this, backupOptionItem.getTotalIncrease()));
        linearLayout.setVisibility(0);
    }

    /* renamed from: B7 */
    public final void m19537B7(List<CBSDevice> list) throws Resources.NotFoundException {
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "showLongRecords showView");
        if (this.f14085J1 == null) {
            this.f14085J1 = new ArrayList<>();
        }
        if (list == null || list.size() <= 0) {
            this.f14108x3 = new ArrayList();
        } else {
            this.f14108x3 = list;
        }
        mo19479s5();
    }

    /* renamed from: C7 */
    public final boolean m19538C7() {
        if (this.f14063x1) {
            if (this.f14073C3 != null) {
                return true;
            }
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "data no prepare ok");
            return false;
        }
        if (this.f16538V != null && this.f21452m != null && this.f16548a0 != null && this.f14073C3 != null) {
            return true;
        }
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "data no prepare ok");
        return false;
    }

    /* renamed from: D7 */
    public final void m19539D7() {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_upgrad", linkedHashMapM19517k7);
        UBAAnalyze.m29947H("CKC", "cloudbackup_space_unenough_upgrad", linkedHashMapM19517k7);
    }

    /* renamed from: E7 */
    public void m19540E7() {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_view_all", linkedHashMapM19517k7);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_unenough_view_all", "4", "16", linkedHashMapM19517k7);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo19460T3();
        m19534y7();
        m19559w7();
        m19554r7();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty
    /* renamed from: T5 */
    public void mo19461T5() throws Resources.NotFoundException {
        super.mo19461T5();
        m19543e7();
        m19544f7();
        ((TextView) C12809f.m76829b(this, R$id.tv_manager_space)).setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: d5 */
    public void mo19541d5() {
        if (!this.f14084I3) {
            C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "showGuidH5  isShowViewOk: false");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudBackupSpaceUnEnoughActivity_isShowViewOk_return");
            onBackPressed();
        } else if (!C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE, "").equals("recommend")) {
            C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "showGuidH5  !pageType.equals(QueryGuideH5Task.CAMPAIGNSOURCE_RECOMMEND)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudBackupSpaceUnEnoughActivity_pageType_return");
            onBackPressed();
        } else {
            if (C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE, "").equals("exit")) {
                super.mo19541d5();
                return;
            }
            C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "showGuidH5  !sceneType.equals(QueryGuideH5Task.OPER_EXIT)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudBackupSpaceUnEnoughActivity_sceneType_return");
            onBackPressed();
        }
    }

    /* renamed from: e6 */
    public final SpannableStringBuilder m19542e6(String str, String str2, int i10) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = str2.length();
        int iIndexOf = str.indexOf(str2);
        int i11 = length + iIndexOf;
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "content =" + str + " handleContent =" + str2);
        if (iIndexOf >= 0 && str.length() > i11) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i10, false), iIndexOf, i11, 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: e7 */
    public final void m19543e7() {
        View viewInflate = LayoutInflater.from(this).inflate(C0209d.m1195O(this) >= 1.75f ? R$layout.space_unenough_content_large : R$layout.space_unenough_content, this.f14057r1);
        if (viewInflate instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
            TextView textView = (TextView) C12809f.m76831d(relativeLayout, R$id.tv_start);
            TextView textView2 = (TextView) C12809f.m76831d(relativeLayout, R$id.tv_end);
            LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(relativeLayout, R$id.ll_more);
            textView.setText(R$string.backup_wait_size);
            textView2.setText(R$string.view_all);
            View viewInflate2 = LayoutInflater.from(this).inflate(R$layout.space_wait_backup_content, (RelativeLayout) C12809f.m76831d(relativeLayout, R$id.rl_part_content));
            if (viewInflate2 instanceof RelativeLayout) {
                RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate2;
                this.f14074D3 = relativeLayout2;
                this.f14087K1 = (LinearLayout) C12809f.m76831d(relativeLayout2, R$id.ll_first);
                this.f14088L1 = (ImageView) C12809f.m76831d(this.f14074D3, R$id.iv_first);
                this.f14089M1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_first);
                this.f14090N1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_first_szie);
                this.f14105c2 = C12809f.m76831d(this.f14074D3, R$id.view_sencond);
                this.f14091O1 = (LinearLayout) C12809f.m76831d(this.f14074D3, R$id.ll_sendcond);
                this.f14092P1 = (ImageView) C12809f.m76831d(this.f14074D3, R$id.iv_sencond);
                this.f14093Q1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_sencond);
                this.f14094R1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_sencond_size);
                this.f14104b2 = C12809f.m76831d(this.f14074D3, R$id.view_third);
                this.f14095S1 = (LinearLayout) C12809f.m76831d(this.f14074D3, R$id.ll_third);
                this.f14096T1 = (ImageView) C12809f.m76831d(this.f14074D3, R$id.iv_third);
                this.f14097U1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_third);
                this.f14098V1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_third_size);
                this.f14103a2 = C12809f.m76831d(this.f14074D3, R$id.view_fourth);
                this.f14099W1 = (LinearLayout) C12809f.m76831d(this.f14074D3, R$id.ll_fourth);
                this.f14100X1 = (ImageView) C12809f.m76831d(this.f14074D3, R$id.iv_fourth);
                this.f14101Y1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_fourth);
                this.f14102Z1 = (TextView) C12809f.m76831d(this.f14074D3, R$id.tv_fourth_size);
            }
            linearLayout.setOnClickListener(this);
            linearLayout.setTag(1);
        }
    }

    /* renamed from: f7 */
    public final void m19544f7() throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this).inflate(C0209d.m1195O(this) >= 1.75f ? R$layout.space_unenough_content_large : R$layout.space_unenough_content, this.f14058s1);
        this.f14075E1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_start);
        this.f14077F1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_end);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(viewInflate, R$id.ll_more);
        linearLayout.setOnClickListener(this);
        linearLayout.setTag(2);
        View viewInflate2 = LayoutInflater.from(this).inflate(R$layout.space_cloudbackup_viewpager, (RelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_part_content));
        if (viewInflate2 instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate2;
            this.f14079G1 = (ViewPager) C12809f.m76831d(relativeLayout, R$id.vpager_space_content);
            this.f14081H1 = (ImageView) C12809f.m76831d(relativeLayout, R$id.iv_start_arrow);
            this.f14083I1 = (ImageView) C12809f.m76831d(relativeLayout, R$id.iv_end_arrow);
        }
        this.f14079G1.setPageMargin(C11842p.m70840n(this, 12));
        this.f14079G1.setOffscreenPageLimit(3);
        this.f14079G1.addOnPageChangeListener(this.f14086J3);
        this.f14081H1.setOnClickListener(this);
        this.f14083I1.setOnClickListener(this);
    }

    /* renamed from: g7 */
    public final void m19545g7() throws Resources.NotFoundException {
        ViewPager viewPager = this.f14079G1;
        if (viewPager == null) {
            C11839m.m70689w("CloudBackupSpaceUnEnoughActivity", "changeViewPager null");
            return;
        }
        int currentItem = viewPager.getCurrentItem();
        int iM70840n = C11842p.m70840n(this, 12);
        this.f14079G1.setAdapter(new C3193e(this, this.f14085J1));
        this.f14079G1.setCurrentItem(currentItem);
        this.f14079G1.setPageMargin(iM70840n);
        m19558v7(currentItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        return super.mo19475h1();
    }

    /* renamed from: h7 */
    public final boolean m19546h7() {
        ArrayList<Object> arrayList = this.f14085J1;
        if (arrayList == null || arrayList.isEmpty()) {
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "checkPagerDatasEmpty finishactivity");
            startActivity(new Intent(this, (Class<?>) CloudSpaceUpgradeActivity.class));
            finish();
            return true;
        }
        if (this.f14085J1.size() == 1) {
            int iM70840n = C11842p.m70840n(this, 12);
            this.f14079G1.setPaddingRelative(iM70840n, 0, iM70840n, 0);
        }
        return false;
    }

    /* renamed from: i7 */
    public final void m19547i7() {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_clean_now", linkedHashMapM19517k7);
        UBAAnalyze.m29947H("CKC", "cloudbackup_space_unenough_clean_now", linkedHashMapM19517k7);
    }

    /* renamed from: j7 */
    public final void m19548j7() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_free_space", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_space_unenough_free_space", linkedHashMap);
    }

    /* renamed from: l7 */
    public final String m19549l7(BackupOptionItem backupOptionItem) {
        String strM25632b = NewHiSyncUtil.m25632b(backupOptionItem.getAppId());
        if (TextUtils.isEmpty(strM25632b)) {
            String appName = backupOptionItem.getAppName();
            return TextUtils.isEmpty(appName) ? backupOptionItem.getAppId() : appName;
        }
        backupOptionItem.setAppName(strM25632b);
        return strM25632b;
    }

    /* renamed from: m7 */
    public final void m19550m7() {
        C12515a.m75110o().m75172d(new C3190b());
    }

    /* renamed from: n7 */
    public void m19551n7(String str) {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        linkedHashMapM19517k7.put("go_detail_space_source", str);
        C13225d.m79490f1().m79591l0("cloudbackup_space_go_space_detail_act", linkedHashMapM19517k7);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_go_space_detail_act", "4", "16", linkedHashMapM19517k7);
    }

    /* renamed from: o7 */
    public final void m19552o7() {
        if (this.f14085J1 == null) {
            return;
        }
        Object obj = this.f14085J1.get(this.f14079G1.getCurrentItem());
        if (obj instanceof CloudPackage) {
            m19557u7();
            startActivity(new Intent(this, (Class<?>) CloudSpaceUpgradeActivity.class));
        } else if (obj instanceof List) {
            m19551n7("2");
            startActivity(new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        SafeIntent safeIntent = new SafeIntent(intent);
        if (i10 == 1) {
            m19554r7();
            m19550m7();
        } else {
            if (i10 != 2) {
                if (i10 != 10016) {
                    super.onActivityResult(i10, i11, intent);
                    return;
                } else {
                    C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "REQUESTCODE_RENEW_AGREEMENT_H5");
                    return;
                }
            }
            if (this.f14108x3.size() != safeIntent.getIntExtra("not_clear_size", 0)) {
                m19559w7();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id2 = view.getId();
        if (id2 == R$id.ll_more) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            if (iIntValue != 1) {
                if (iIntValue == 2) {
                    m19552o7();
                    return;
                }
                return;
            } else {
                Intent intent = new Intent(this, (Class<?>) BackupOptionsActivity.class);
                intent.putExtra("source", 1);
                startActivityForResult(intent, 1);
                m19540E7();
                return;
            }
        }
        if (id2 == R$id.iv_start_arrow) {
            m19561z7(this.f14079G1.getCurrentItem() - 1);
            return;
        }
        if (id2 == R$id.iv_end_arrow) {
            m19561z7(this.f14079G1.getCurrentItem() + 1);
            return;
        }
        if (id2 == R$id.bt_clear_now) {
            m19547i7();
            startActivityForResult(new Intent(this, (Class<?>) CloudBackupOldDevicesCleanActivity.class), 2);
            return;
        }
        if (id2 == R$id.set_no_net_btn) {
            mo19446D1();
            return;
        }
        if (id2 == R$id.tv_free_space) {
            m19548j7();
            m19454P5();
        } else if (id2 == R$id.tv_manager_space) {
            m19551n7("1");
            startActivity(new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class));
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "onConfigurationChanged");
        m19545g7();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f14072B3.m79065c(this, getIntent(), C13222a.m79465g(this));
        setContentView(R$layout.activity_cloud_backup_space_guide);
        mo19461T5();
        m28587n1();
        mo19460T3();
        C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudBackupSpaceUnEnoughActivity"), false);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        RecommendTipData recommendTipData = this.f14061v1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "onCreateOptionsMenu recommendTipData is null help not display");
        } else if (!TextUtils.isEmpty(recommendTipData.getDisplayHelp()) && C10152c.m63233q(this.f14061v1.getDisplayHelp())) {
            getMenuInflater().inflate(R$menu.tip_help, menu);
            MenuItem menuItemFindItem = menu.findItem(R$id.help);
            menuItemFindItem.setActionView(R$layout.action_item);
            ImageView imageView = (ImageView) C12809f.m76831d(menuItemFindItem.getActionView(), R$id.action_item_image);
            this.f14078F3 = imageView;
            imageView.setImageResource(R$drawable.hicloud_new_backup);
            View actionView = menuItemFindItem.getActionView();
            this.f14071A3 = actionView;
            actionView.setOnClickListener(new ViewOnClickListenerC3191c());
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16501C0 = true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudBackupSpaceUnEnoughActivity"), false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) throws Resources.NotFoundException {
        super.onWindowFocusChanged(z10);
        if (m22805V3()) {
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "isShowBubble is true");
            return;
        }
        ImageView imageView = this.f14078F3;
        if (imageView == null) {
            C11839m.m70687e("CloudBackupSpaceUnEnoughActivity", "commentImg is null");
        } else {
            m19525q7(imageView);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: r1 */
    public boolean mo19553r1(int i10, KeyEvent keyEvent) {
        C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "QueryGuideH5Task onKeyDown in ");
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudBackupSpaceUnEnoughActivity", "KEYCODE_BACK click too fast");
            return true;
        }
        mo19541d5();
        return true;
    }

    /* renamed from: r7 */
    public final void m19554r7() {
        C12515a.m75110o().m75172d(new C3194f());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() throws Resources.NotFoundException {
        if (m19556t7()) {
            C11839m.m70688i("CloudBackupSpaceUnEnoughActivity", "showView");
            if (this.f14085J1 == null) {
                this.f14085J1 = new ArrayList<>();
            }
            this.f14085J1.clear();
            ArrayList<FilterAvailabalGradePackage> arrayList = this.f16548a0;
            if (arrayList != null && !arrayList.isEmpty()) {
                C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "recommendPackagesList is not null");
                FilterAvailabalGradePackage filterAvailabalGradePackage = this.f16548a0.get(0);
                List<CloudPackage> monthlyPackageList = filterAvailabalGradePackage.getMonthlyPackageList();
                List<CloudPackage> basicPackageList = filterAvailabalGradePackage.getBasicPackageList();
                List<CloudPackage> incrementList = filterAvailabalGradePackage.getIncrementList();
                this.f14106d2 = filterAvailabalGradePackage.getPackageGrades();
                if (monthlyPackageList != null && monthlyPackageList.size() > 0) {
                    CloudPackage cloudPackage = monthlyPackageList.get(0);
                    this.f14107e2 = cloudPackage;
                    this.f14085J1.add(cloudPackage);
                } else if (basicPackageList != null && basicPackageList.size() > 0) {
                    CloudPackage cloudPackage2 = basicPackageList.get(0);
                    this.f14107e2 = cloudPackage2;
                    this.f14085J1.add(cloudPackage2);
                } else if (incrementList != null && incrementList.size() > 0) {
                    CloudPackage cloudPackage3 = incrementList.get(0);
                    this.f14107e2 = cloudPackage3;
                    this.f14085J1.add(cloudPackage3);
                }
            }
            List<CBSDevice> list = this.f14108x3;
            if (list != null && list.size() > 0) {
                this.f14085J1.add(0, this.f14108x3);
            }
            if (m19546h7()) {
                return;
            }
            this.f14079G1.setAdapter(new C3193e(this, this.f14085J1));
            this.f14079G1.setCurrentItem(0);
            m19558v7(0);
            mo19476h5();
            this.f14084I3 = true;
        }
    }

    /* renamed from: s7 */
    public final void m19555s7(boolean z10) {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        linkedHashMapM19517k7.put("isHasCleanCard", Boolean.valueOf(z10));
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_clean_card", linkedHashMapM19517k7);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_unenough_clean_card", "4", "16", linkedHashMapM19517k7);
    }

    /* renamed from: t7 */
    public final boolean m19556t7() {
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "isShowView isShowBackupCard" + this.f14109y3 + " isPackageEmpty" + this.f14063x1);
        if (!this.f14109y3) {
            return m19538C7();
        }
        if (this.f14063x1) {
            if (this.f14108x3 != null && this.f14073C3 != null) {
                return true;
            }
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "data no prepare ok");
            return false;
        }
        if (this.f16538V != null && this.f21452m != null && this.f16548a0 != null && this.f14108x3 != null && this.f14073C3 != null) {
            return true;
        }
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "data no prepare ok");
        return false;
    }

    /* renamed from: u7 */
    public void m19557u7() {
        LinkedHashMap linkedHashMapM19517k7 = m19517k7();
        C13225d.m79490f1().m79591l0("cloudbackup_space_more_package", linkedHashMapM19517k7);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_more_package", "4", "16", linkedHashMapM19517k7);
    }

    /* renamed from: v7 */
    public final void m19558v7(int i10) {
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "pagePosiChange " + i10);
        ArrayList<Object> arrayList = this.f14085J1;
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() > i10) {
            Object obj = this.f14085J1.get(i10);
            if (obj instanceof List) {
                this.f14075E1.setText(R$string.manage_space_title_new1);
                this.f14077F1.setText(R$string.go_clean_up);
            } else if (obj instanceof CloudPackage) {
                this.f14075E1.setText(R$string.recommend_upgrade_plan);
                this.f14077F1.setText(R$string.backup_detail_more);
            }
        }
        if (i10 == 0) {
            this.f14081H1.setVisibility(8);
            if (this.f14085J1.size() > 1) {
                this.f14083I1.setVisibility(0);
                this.f14079G1.setPadding(C11842p.m70840n(this, 12), 0, C11842p.m70840n(this, 24), 0);
                return;
            }
            return;
        }
        if (i10 == this.f14085J1.size() - 1) {
            this.f14083I1.setVisibility(8);
            this.f14081H1.setVisibility(0);
            this.f14079G1.setPadding(C11842p.m70840n(this, 24), 0, C11842p.m70840n(this, 12), 0);
        }
    }

    /* renamed from: w7 */
    public final void m19559w7() {
        RecommendTipData recommendTipData = this.f14061v1;
        if (recommendTipData == null) {
            C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "queryLongTimeRecord recommendTipData null");
            return;
        }
        String displayClearCard = recommendTipData.getDisplayClearCard();
        C11839m.m70686d("CloudBackupSpaceUnEnoughActivity", "queryLongTimeRecord displayClearCard " + displayClearCard);
        int iM1686d = C0241z.m1686d(displayClearCard, 1);
        m19523p7();
        if (iM1686d != 1 || this.f14080G3 <= 0) {
            this.f14109y3 = false;
        } else {
            this.f14109y3 = true;
            C12515a.m75110o().m75172d(new C3195g());
        }
    }

    /* renamed from: x7 */
    public final void m19560x7(ActionBar actionBar) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.pay_activity_harmony_bg);
            C0209d.m1306s2(actionBar, this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: z7 */
    public final void m19561z7(int i10) throws Resources.NotFoundException {
        AbstractC0984a adapter = this.f14079G1.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            if (i10 < 0 || count <= i10) {
                return;
            }
            this.f14079G1.setCurrentItem(i10);
            m19558v7(i10);
        }
    }
}
