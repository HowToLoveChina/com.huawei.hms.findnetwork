package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchListApp;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.SpaceSwitchSuggestAdapter;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.HomepageSwitchNoticeManager;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0212e0;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p490nb.C11661a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p848zl.C14333b;
import sk.AlertDialogC12804a;
import sk.C12809f;
import tl.C13026e;
import tl.C13037p;

/* loaded from: classes3.dex */
public class SpaceSwitchSuggestDialog extends AlertDialogC12804a implements View.OnClickListener {
    public static final String SCENE_ID_MAIN_ACTIVITY = "main_activity";
    public static final String SCENE_ID_NOTIFY = "notify";
    private static final String TAG = "SpaceSwitchSuggestDialog";
    private SpaceSwitchSuggestAdapter backupOptionAdapter;
    private AutoSizeButton cancelButton;
    private AutoSizeButton confirmButton;
    private final Context context;
    private boolean isShowClickText;
    private ListView listView;
    private DialogSaveSwitchCallback listener;
    private final C13026e optionItemOperator;
    private String sceneId;
    private SpanClickText spanClickText;
    private long startShowTime;
    private HwTextView title;

    public interface DialogSaveSwitchCallback {
        void onSaveFinish();

        void onSyncSwitchOpen(String str);
    }

    public SpaceSwitchSuggestDialog(Context context, boolean z10, DialogSaveSwitchCallback dialogSaveSwitchCallback, SpanClickText.ISpanClickListener iSpanClickListener) {
        super(context);
        this.sceneId = SCENE_ID_MAIN_ACTIVITY;
        this.context = context;
        this.isShowClickText = z10;
        this.listener = dialogSaveSwitchCallback;
        this.optionItemOperator = new C13026e();
        setView(initView());
        replaceSpanTextView(iSpanClickListener);
    }

    private String getAppName(C13037p c13037p) {
        String strM25632b = NewHiSyncUtil.m25632b(c13037p.m78575a());
        if (!TextUtils.isEmpty(strM25632b)) {
            c13037p.m78584j(strM25632b);
            this.optionItemOperator.m78374I(strM25632b, c13037p.m78575a());
            return strM25632b;
        }
        String strM78576b = c13037p.m78576b();
        if (TextUtils.isEmpty(strM78576b)) {
            strM78576b = c13037p.m78575a();
        }
        return strM78576b;
    }

    private void initNameAndIcon(C13037p c13037p) {
        c13037p.m78588n(true);
        if (c13037p.m78581g() == 0) {
            Map<String, Integer> map = C11661a.f54100b;
            if (map.containsKey(c13037p.m78575a())) {
                c13037p.m78584j(this.context.getString(map.get(c13037p.m78575a()).intValue()));
                c13037p.m78586l(this.context.getDrawable(C11661a.f54099a.get(c13037p.m78575a()).intValue()));
            } else {
                for (SyncConfigService syncConfigService : NotifyUtil.getShownSyncServiceItems(this.context)) {
                    if (syncConfigService.getId().equals(c13037p.m78575a())) {
                        c13037p.m78584j(syncConfigService.getTitleText());
                        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncConfigService.getId()) && C0209d.m1293p1()) {
                            c13037p.m78586l(this.context.getDrawable(R$drawable.hinote_sync_icon));
                        } else {
                            c13037p.m78585k(C11829c.m70501B(syncConfigService.getIconPath()));
                        }
                    }
                }
            }
        } else {
            String strM78575a = c13037p.m78575a();
            if (StringUtil.equals(c13037p.m78580f(), "virtualApp")) {
                c13037p.m78584j(CloudBackupLanguageUtil.getVirtualName(strM78575a));
                c13037p.m78586l(CloudBackup3rdIconUtil.getDrawable(strM78575a, null));
            } else if (C14333b.m85483r().containsKey(strM78575a)) {
                c13037p.m78584j(C2783d.m16079E(this.context, strM78575a));
                c13037p.m78586l(CloudBackup3rdIconUtil.getDrawable(strM78575a));
            } else {
                c13037p.m78584j(C14333b.f63653e.containsKey(strM78575a) ? C2783d.m16079E(this.context, strM78575a) : getAppName(c13037p));
                c13037p.m78586l(CloudBackup3rdIconUtil.get3rdDrawable(strM78575a));
            }
        }
        this.backupOptionAdapter.m25239h(c13037p);
    }

    private View initView() {
        View viewInflate = LayoutInflater.from(this.context).inflate(C0209d.m1195O(this.context) > 1.45f ? R$layout.dialog_space_switch_suggest_175 : R$layout.dialog_space_switch_suggest, (ViewGroup) null);
        this.listView = (ListView) C12809f.m76831d(viewInflate, R$id.lv_open_item);
        this.title = (HwTextView) C12809f.m76831d(viewInflate, R$id.recomend_span_title);
        this.spanClickText = (SpanClickText) C12809f.m76831d(viewInflate, R$id.recomend_span_text);
        this.cancelButton = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.cancel_btn);
        this.confirmButton = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.confirm_btn);
        this.cancelButton.setOnClickListener(this);
        this.confirmButton.setOnClickListener(this);
        SpaceSwitchSuggestAdapter spaceSwitchSuggestAdapter = new SpaceSwitchSuggestAdapter(this.context);
        this.backupOptionAdapter = spaceSwitchSuggestAdapter;
        spaceSwitchSuggestAdapter.m25254w(new SpaceSwitchSuggestAdapter.OnSwitchStatusChangeListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.y0
            @Override // com.huawei.android.hicloud.ui.uiadapter.SpaceSwitchSuggestAdapter.OnSwitchStatusChangeListener
            /* renamed from: a */
            public final void mo25258a() {
                this.f19260a.lambda$initView$0();
            }
        });
        this.listView.setAdapter((ListAdapter) this.backupOptionAdapter);
        this.listView.setCacheColorHint(0);
        return viewInflate;
    }

    private void openAlbumSyncSwitch() {
        C11839m.m70688i(TAG, "openAlbumSyncSwitch");
        ((InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class)).mo17155v0(this.context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", true);
        bundle.putBoolean("ShareAlbum", true);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        interfaceC9282a.mo58402X(true, this.context);
        interfaceC9282a.mo58396U(this.context, bundle, 17);
    }

    private void saveSwitchResult() {
        boolean z10 = false;
        for (C13037p c13037p : this.backupOptionAdapter.m25245n()) {
            if (c13037p.m78582h()) {
                if (c13037p.m78581g() == 0) {
                    if (StringUtil.equals(c13037p.m78575a(), HNConstants.DataType.MEDIA)) {
                        openAlbumSyncSwitch();
                    } else {
                        DialogSaveSwitchCallback dialogSaveSwitchCallback = this.listener;
                        if (dialogSaveSwitchCallback != null) {
                            dialogSaveSwitchCallback.onSyncSwitchOpen(c13037p.m78575a());
                        }
                    }
                    z10 = true;
                } else {
                    updateBackupOptionSwitch(c13037p);
                }
            }
            C13225d.m79490f1().m79568R0(c13037p.m78575a(), c13037p.m78582h());
        }
        if (z10) {
            C11841o.m70707c(this.context, R$string.space_switch_suggest_sync_open_tips, 0);
        }
        DialogSaveSwitchCallback dialogSaveSwitchCallback2 = this.listener;
        if (dialogSaveSwitchCallback2 != null) {
            dialogSaveSwitchCallback2.onSaveFinish();
        } else {
            C11839m.m70689w(TAG, "listener is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setButtonEnable, reason: merged with bridge method [inline-methods] */
    public void lambda$initView$0() {
        this.confirmButton.setEnabled(!this.backupOptionAdapter.m25249r());
    }

    private void updateBackupOptionSwitch(C13037p c13037p) {
        String strM78575a = c13037p.m78575a();
        if ("soundrecorder".equals(strM78575a)) {
            this.optionItemOperator.m78376K(true, "callRecorder");
        }
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(strM78575a)) {
            this.optionItemOperator.m78376K(true, "chatSms");
        }
        this.optionItemOperator.m78376K(true, c13037p.m78575a());
    }

    public String getDialogSceneId() {
        return this.sceneId;
    }

    public long getStartShowTime() {
        return this.startShowTime;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(TAG, "fast click button");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.cancel_btn) {
            C11839m.m70688i(TAG, "click negative button!");
            dismiss();
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("scene_id", this.sceneId);
            linkedHashMapM79499C.put("action_code_guide_dialog_time", Long.valueOf(System.currentTimeMillis() - this.startShowTime));
            C13225d.m79490f1().m79591l0("mecloud_main_switch_suggest_cancel", linkedHashMapM79499C);
            C13225d.m79490f1().m79573U("mecloud_main_switch_suggest_cancel", linkedHashMapM79499C);
            UBAAnalyze.m29958S("PVC", "mecloud_main_switch_suggest_cancel", "1", "cloud_space_home_page_dialog", linkedHashMapM79499C);
            return;
        }
        if (id2 == R$id.confirm_btn) {
            C11839m.m70688i(TAG, "click positive button!");
            saveSwitchResult();
            C0212e0.m1368r(this.context, "switch_suggest_dialog_sp", "dialog_switch_suggest_num_new", 0);
            dismiss();
            LinkedHashMap<String, String> linkedHashMapM79499C2 = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C2.put("scene_id", this.sceneId);
            linkedHashMapM79499C2.put("action_code_guide_dialog_time", Long.valueOf(System.currentTimeMillis() - this.startShowTime));
            C13225d.m79490f1().m79591l0("mecloud_main_switch_suggest_open", linkedHashMapM79499C2);
            C13225d.m79490f1().m79573U("mecloud_main_switch_suggest_open", linkedHashMapM79499C2);
            UBAAnalyze.m29958S("PVC", "mecloud_main_switch_suggest_open", "1", "cloud_space_home_page_dialog", linkedHashMapM79499C2);
        }
    }

    public void replaceSpanTextView(boolean z10, SpanClickText.ISpanClickListener iSpanClickListener) {
        this.isShowClickText = z10;
        replaceSpanTextView(iSpanClickListener);
    }

    public void setDialogSceneId(String str) {
        this.sceneId = str;
    }

    public void setSwitchData(List<AppBackupSwitchListApp> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w(TAG, "setSyncSwitchData itemList is null!");
            return;
        }
        C11839m.m70688i(TAG, "setSyncSwitchData");
        for (AppBackupSwitchListApp appBackupSwitchListApp : list) {
            C13037p c13037p = new C13037p();
            c13037p.m78583i(appBackupSwitchListApp.getPackageName());
            c13037p.m78590p(appBackupSwitchListApp.getType());
            c13037p.m78589o(appBackupSwitchListApp.getParent());
            initNameAndIcon(c13037p);
        }
        this.backupOptionAdapter.m25247p(!C13452e.m80781L().m80887a1());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        C11839m.m70688i(TAG, "dialog show!");
        int iM1357g = C0212e0.m1357g(this.context, "switch_suggest_dialog_sp", "dialog_switch_suggest_num_new", 0) + 1;
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("show_num", Integer.valueOf(iM1357g));
        linkedHashMapM79499C.put("scene_id", this.sceneId);
        C0212e0.m1368r(this.context, "switch_suggest_dialog_sp", "dialog_switch_suggest_num_new", iM1357g);
        C13225d.m79490f1().m79591l0("mecloud_main_switch_suggest_show", linkedHashMapM79499C);
        C13225d.m79490f1().m79573U("mecloud_main_switch_suggest_show", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_main_switch_suggest_show", "1", "cloud_space_home_page_dialog", linkedHashMapM79499C);
        this.startShowTime = System.currentTimeMillis();
    }

    private void replaceSpanTextView(SpanClickText.ISpanClickListener iSpanClickListener) {
        if (this.context == null || this.spanClickText == null) {
            return;
        }
        String extraNoticeTitleLanguage = HomepageSwitchNoticeManager.getInstance().getExtraNoticeTitleLanguage();
        HwTextView hwTextView = this.title;
        if (TextUtils.isEmpty(extraNoticeTitleLanguage)) {
            extraNoticeTitleLanguage = this.context.getString(R$string.usage_suggestion_dialog_title_new);
        }
        hwTextView.setText(extraNoticeTitleLanguage);
        String string = this.isShowClickText ? this.context.getString(R$string.hicloud_service_location_change_8) : "";
        String extraNoticeMainTextLanguage = HomepageSwitchNoticeManager.getInstance().getExtraNoticeMainTextLanguage();
        String string2 = TextUtils.isEmpty(extraNoticeMainTextLanguage) ? this.context.getString(R$string.space_switch_suggest_description, string) : extraNoticeMainTextLanguage.replace("%1$s", string);
        this.spanClickText.m15931c(string, iSpanClickListener);
        this.spanClickText.m15934g(string2, false);
    }
}
