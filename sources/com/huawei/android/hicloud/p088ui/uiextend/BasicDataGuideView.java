package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.NewBusinessModelConfigBean;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import hu.C10342a;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p292fn.C9733f;
import p371ik.C10527a;
import p514o9.C11839m;
import p550pb.C12126b;
import p618rm.C12590s0;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BasicDataGuideView extends FrameLayout implements View.OnClickListener {
    private static final int DEFAULT_UPGRADE_SWITCH = 0;
    private static final int SHARE_SPACE = 200;
    private static final String TAG = "BasicDataGuideView";
    private View basicDataRegion;
    private Context context;
    private View inflateView;
    private HiCloudItemView itemAlbumView;
    private HiCloudItemView itemCloudDiskView;
    private HiCloudItemView itemCloudShareView;
    private HiCloudItemView itemThirdAppBackupView;
    private View updateDataServerBtn;

    public BasicDataGuideView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private ViewStub findViewStubById(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    private void initBasicDataGuideView() {
        C11839m.m70688i(TAG, "initBasicDataGuideView");
        if (this.inflateView != null) {
            C11839m.m70689w(TAG, "initBasicDataGuideView, do not init!");
            return;
        }
        View viewInflate = View.inflate(this.context, R$layout.basic_data_guide_item_layout, this);
        this.inflateView = viewInflate;
        View viewInflate2 = findViewStubById(viewInflate, R$id.basic_data_guide_list_item_view).inflate();
        this.basicDataRegion = C12809f.m76831d(viewInflate2, R$id.basic_data_list_region);
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76831d(viewInflate2, R$id.album_item);
        this.itemAlbumView = hiCloudItemView;
        hiCloudItemView.setTitle(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_gallery_title"));
        this.itemAlbumView.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_gallery_content"));
        HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76831d(viewInflate2, R$id.third_backup_item);
        this.itemThirdAppBackupView = hiCloudItemView2;
        hiCloudItemView2.setTitle(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_other_backup_title"));
        this.itemThirdAppBackupView.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_other_backup_content"));
        HiCloudItemView hiCloudItemView3 = (HiCloudItemView) C12809f.m76831d(viewInflate2, R$id.cloud_disk_item);
        this.itemCloudDiskView = hiCloudItemView3;
        hiCloudItemView3.setTitle(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_disk_title"));
        this.itemCloudDiskView.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_cloud_disk_content"));
        HiCloudItemView hiCloudItemView4 = (HiCloudItemView) C12809f.m76831d(viewInflate2, R$id.cloud_share_item);
        this.itemCloudShareView = hiCloudItemView4;
        hiCloudItemView4.setTitle(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_space_share_title"));
        try {
            this.itemCloudShareView.setSubTitleText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_space_share_content"));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "initBasicDataGuideView, basic_data_cloud_share_content use default, err：" + e10);
            this.itemCloudShareView.setSubTitleText(this.context.getString(R$string.cloud_space_share_content_new));
        }
        this.itemAlbumView.m23989v();
        if (C0209d.m1269j1()) {
            this.itemAlbumView.setImage(this.context.getDrawable(R$drawable.ic_cloud_album_honor));
        } else {
            this.itemAlbumView.setImage(this.context.getDrawable(R$drawable.ic_cloud_album));
        }
        this.itemThirdAppBackupView.m23989v();
        this.itemCloudDiskView.m23989v();
        this.itemCloudShareView.m23989v();
        View view = this.inflateView;
        int i10 = R$id.update_server_data_btn;
        this.updateDataServerBtn = C12809f.m76831d(view, i10);
        this.basicDataRegion.setOnClickListener(this);
        this.updateDataServerBtn.setOnClickListener(this);
        ((TextView) this.inflateView.findViewById(R$id.task_center_title)).setText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_guide_title"));
        AutoSizeButton autoSizeButton = (AutoSizeButton) this.inflateView.findViewById(i10);
        autoSizeButton.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("basic_data_upgrade_btn"));
        autoSizeButton.setAllCaps(true);
    }

    private void initView() {
        if (!isShowGuideView()) {
            C11839m.m70689w(TAG, "initView, not init view!");
            setVisibility(8);
        } else {
            initBasicDataGuideView();
            setVisibility(0);
            reportBI("show_basic_data_guide_view");
        }
    }

    private boolean isShowGuideView() {
        if (C13452e.m80781L().m80791C0()) {
            return C9733f.m60705z().m60729X(0);
        }
        C11839m.m70688i(TAG, "isShowGuideView, not NN user");
        return false;
    }

    private void jumpCloudUpgradeH5Page(String str) {
        Intent intentM75832b0 = C12590s0.m75832b0(str, null, true);
        intentM75832b0.putExtra("srcChannel", "0");
        intentM75832b0.putExtra("salChannel", "0");
        C10342a.m63676b(this.context, intentM75832b0);
    }

    private void jumpCloudUpgradeNativePage() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "jumpCloudUpgradeNativePage");
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 7);
        if (!TextUtils.isEmpty("28")) {
            C13230i.m79522d1(bundle, "1", "28");
        }
        Context context = this.context;
        if (context instanceof MainActivity) {
            C12126b.m72707c(C13222a.m79465g((MainActivity) context), bundle);
            new HwAnimationReflection(this.context).m15927c(1);
        }
    }

    private void jumpToUpgradePackageCardLink() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HiCloudSysParamMap hiCloudSysParamMapM60758q;
        C11839m.m70686d(TAG, "jumpToUpgradePackageCardLink");
        String newBusinessModelConfig = HiCloudSysParamMapCache.getNewBusinessModelConfig();
        if (newBusinessModelConfig == null && (hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q()) != null) {
            newBusinessModelConfig = hiCloudSysParamMapM60758q.getNewBusinessModelConfig();
        }
        if (newBusinessModelConfig == null) {
            C11839m.m70689w(TAG, "jumpToUpgradePackageCardLink, sysParamMap is null!");
            jumpCloudUpgradeNativePage();
            return;
        }
        NewBusinessModelConfigBean newBusinessModelConfigBean = (NewBusinessModelConfigBean) C10527a.m64629g(newBusinessModelConfig, NewBusinessModelConfigBean.class);
        if (newBusinessModelConfigBean == null || TextUtils.isEmpty(newBusinessModelConfigBean.getUpgradePackageCardLink())) {
            C11839m.m70689w(TAG, "jumpToUpgradePackageCardLink, configBean or dataDownloadPage is null");
            jumpCloudUpgradeNativePage();
        } else if (!TextUtils.isEmpty(newBusinessModelConfigBean.getUpgradePackageCardLink())) {
            jumpCloudUpgradeH5Page(newBusinessModelConfigBean.getUpgradePackageCardLink());
        } else {
            C11839m.m70689w(TAG, "jumpToUpgradePackageCardLink, link is null");
            jumpCloudUpgradeNativePage();
        }
    }

    private void reportBI(String str) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R(str, linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", str, linkedHashMapM79499C);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.basic_data_list_region || view.getId() == R$id.update_server_data_btn) {
            jumpToUpgradePackageCardLink();
            reportBI("jump_cloud_upgrade_h5_page");
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        HiCloudItemView hiCloudItemView = this.itemAlbumView;
        if (hiCloudItemView == null || this.itemCloudDiskView == null || this.itemThirdAppBackupView == null || this.itemCloudShareView == null) {
            return;
        }
        hiCloudItemView.m23987t();
        this.itemCloudDiskView.m23987t();
        this.itemThirdAppBackupView.m23987t();
        this.itemCloudShareView.m23987t();
    }

    public void refreshView() {
        C11839m.m70686d(TAG, "refreshView");
        initView();
    }

    public BasicDataGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initView();
    }
}
