package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import ae.C0151n1;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1006a;
import p020ap.C1008c;
import p422k9.C11019b;
import p494nk.C11718b;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class NewMergeAlertDialog extends AlertDialogC13154a implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "NewMergeAlertDialog";
    private List<String> baseList;
    private ImageView browserImg;
    private DisableSupportedRelativeLayout browserItem;
    private UnionSwitch browserSwitch;
    private AutoSizeButton btCancel;
    private AutoSizeButton btConfirm;
    private ImageView calendarImg;
    private DisableSupportedRelativeLayout calendarItem;
    private UnionSwitch calendarSwitch;
    private ArrayList<String> confirmedModules;
    private ImageView contactImg;
    private DisableSupportedRelativeLayout contactItem;
    private UnionSwitch contactSwitch;
    private final Handler databasesHandler;
    private DialogCallback dialogActivity;
    private ImageView galleryImg;
    private DisableSupportedRelativeLayout galleryItem;
    private UnionSwitch gallerySwitch;
    private int mClickOptType;
    private Activity mContext;
    private String mTraceId;
    private ArrayList<String> modules;
    private ImageView notepadImg;
    private DisableSupportedRelativeLayout notepadItem;
    private UnionSwitch notepadSwitch;
    private C0151n1 syncConfigAdapter;
    private ScrollDisabledListView syncConfigView;
    private TextView title;
    private String traceId;
    private ImageView wlanImg;
    private DisableSupportedRelativeLayout wlanItem;
    private UnionSwitch wlanSwitch;
    private TextView wlanText;

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        private DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (NewMergeAlertDialog.this.dialogActivity == null) {
                return;
            }
            C11839m.m70688i(NewMergeAlertDialog.TAG, "onCancel");
            NewMergeAlertDialog.this.dialogActivity.onCanceled("all_module", NewMergeAlertDialog.this.mClickOptType);
        }
    }

    public NewMergeAlertDialog(Activity activity, DialogCallback dialogCallback, int i10) {
        super(activity);
        this.confirmedModules = new ArrayList<>();
        this.baseList = new ArrayList();
        this.databasesHandler = new Handler() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.NewMergeAlertDialog.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 0) {
                    C11839m.m70688i(NewMergeAlertDialog.TAG, "query innerDataBases suc");
                } else if (i11 == 5) {
                    C11839m.m70688i(NewMergeAlertDialog.TAG, "query innerDataBases fail");
                }
                NewMergeAlertDialog.this.baseList = C1008c.m6035v().m6036A(NewMergeAlertDialog.this.mContext);
                NewMergeAlertDialog.this.showDialog();
            }
        };
        this.mContext = activity;
        this.dialogActivity = dialogCallback;
        this.mClickOptType = i10;
        initView();
        setOnCancelListener(new DialogOnCancelListener());
        setCanceledOnTouchOutside(false);
    }

    private void checkPermissionByService() {
        C11839m.m70688i(TAG, "enter checkPermissionByService");
        C11718b c11718b = new C11718b();
        if (c11718b.m69903b(this.mContext, c11718b.m69911k(HNConstants.DataType.MEDIA)).size() > 0) {
            this.galleryItem.setVisibility(8);
        }
        if (c11718b.m69903b(this.mContext, c11718b.m69911k("addressbook")).size() > 0) {
            this.contactItem.setVisibility(8);
        }
        if (c11718b.m69903b(this.mContext, c11718b.m69911k("browser")).size() > 0) {
            this.browserItem.setVisibility(8);
        }
        if (c11718b.m69903b(this.mContext, c11718b.m69911k("calendar")).size() > 0) {
            this.calendarItem.setVisibility(8);
        }
        if (c11718b.m69903b(this.mContext, c11718b.m69911k("notepad")).size() > 0) {
            this.notepadItem.setVisibility(8);
        }
        if (c11718b.m69903b(this.mContext, c11718b.m69911k("wlan")).size() > 0) {
            this.wlanItem.setVisibility(8);
        }
    }

    private void dealList(String str, boolean z10) {
        C11839m.m70688i(TAG, "onCheckedChanged, module: " + str + ", isChecked: " + z10);
        if (z10) {
            if (this.confirmedModules.contains(str)) {
                return;
            }
            this.confirmedModules.add(str);
        } else if (this.confirmedModules.contains(str)) {
            this.confirmedModules.remove(str);
        }
    }

    private void initSyncConfigView(View view) {
        this.syncConfigView = (ScrollDisabledListView) C12809f.m76831d(view, R$id.sync_config_item);
        C0151n1 c0151n1 = new C0151n1(this.mContext, this);
        this.syncConfigAdapter = c0151n1;
        this.syncConfigView.setAdapter((ListAdapter) c0151n1);
        this.syncConfigView.setFocusable(false);
        this.syncConfigView.setEnabled(false);
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.merge_alert_dialog, (ViewGroup) null);
        this.title = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.galleryItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_gallery);
        this.contactItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_contact);
        this.browserItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_browser);
        this.calendarItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_calendar);
        this.notepadItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_notepad);
        this.wlanItem = (DisableSupportedRelativeLayout) C12809f.m76831d(viewInflate, R$id.rl_wlan);
        this.galleryImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_gallery_img);
        this.contactImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_contact_img);
        this.browserImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_browser_img);
        this.calendarImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_calendar_img);
        this.notepadImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_notepad_img);
        this.wlanImg = (ImageView) C12809f.m76831d(viewInflate, R$id.rl_wlan_img);
        this.wlanText = (TextView) C12809f.m76831d(viewInflate, R$id.rl_wlan_title);
        this.gallerySwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_gallery_switch);
        this.contactSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_contact_switch);
        this.browserSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_browser_switch);
        this.calendarSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_calendar_switch);
        this.notepadSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_notepad_switch);
        this.wlanSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.rl_wlan_switch);
        this.btCancel = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.bt_cancel);
        this.btConfirm = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.bt_confirm);
        Resources resources = this.mContext.getResources();
        if (this.galleryImg == null || this.contactImg == null || this.browserImg == null || this.calendarImg == null || this.notepadImg == null || this.wlanImg == null || this.wlanText == null || this.gallerySwitch == null || this.contactSwitch == null || this.browserSwitch == null || this.calendarSwitch == null || this.notepadSwitch == null || this.wlanSwitch == null || this.btCancel == null || this.btConfirm == null || resources == null) {
            C11839m.m70687e(TAG, "initView error");
        } else {
            initViewSplit(viewInflate, resources);
        }
    }

    private void initViewSplit(View view, Resources resources) {
        if (C0209d.m1293p1()) {
            this.galleryImg.setBackground(this.mContext.getDrawable(R$drawable.ic_cloud_album_ink));
            this.browserImg.setBackground(this.mContext.getDrawable(R$drawable.ic_hicloud_browser_list_new_ink));
            this.calendarImg.setBackground(this.mContext.getDrawable(R$drawable.icon_calendar_ink));
            this.notepadImg.setBackground(this.mContext.getDrawable(R$drawable.ic_memorandum_ink));
            this.wlanImg.setBackground(this.mContext.getDrawable(R$drawable.ic_wifi_ink));
        } else if (C0209d.m1269j1()) {
            this.galleryImg.setBackground(this.mContext.getDrawable(R$drawable.ic_cloud_album_honor));
            this.contactImg.setBackground(this.mContext.getDrawable(R$drawable.ic_contacts_honor));
            this.browserImg.setBackground(this.mContext.getDrawable(R$drawable.ic_hicloud_browser_list_new_honor));
            this.calendarImg.setBackground(this.mContext.getDrawable(R$drawable.icon_calendar_honor));
            this.notepadImg.setBackground(this.mContext.getDrawable(R$drawable.ic_memorandum_honor));
            this.wlanImg.setBackground(this.mContext.getDrawable(R$drawable.ic_wifi));
        } else {
            this.galleryImg.setBackground(this.mContext.getDrawable(R$drawable.ic_cloud_album));
            this.contactImg.setBackground(this.mContext.getDrawable(R$drawable.ic_contacts));
            this.browserImg.setBackground(this.mContext.getDrawable(R$drawable.ic_hicloud_browser_list_new));
            this.calendarImg.setBackground(this.mContext.getDrawable(R$drawable.icon_calendar));
            this.notepadImg.setBackground(this.mContext.getDrawable(R$drawable.ic_memorandum));
            this.wlanImg.setBackground(this.mContext.getDrawable(R$drawable.ic_wifi));
        }
        String string = this.mContext.getString(R$string.wifi_sync);
        if (C0209d.m1262h2()) {
            string = this.mContext.getString(R$string.wlan_sync);
        }
        this.wlanText.setText(string);
        this.gallerySwitch.setOnCheckedChangeListener(this);
        this.contactSwitch.setOnCheckedChangeListener(this);
        this.browserSwitch.setOnCheckedChangeListener(this);
        this.calendarSwitch.setOnCheckedChangeListener(this);
        this.notepadSwitch.setOnCheckedChangeListener(this);
        this.wlanSwitch.setOnCheckedChangeListener(this);
        this.btCancel.setOnClickListener(this);
        this.btConfirm.setOnClickListener(this);
        setView(view);
        initSyncConfigView(view);
    }

    private boolean isAgreeToBasicUser() {
        return C13452e.m80781L().m80791C0();
    }

    private boolean isInCloudSyncBasicDataList(String str) {
        return C1008c.m6035v().m6045J(this.baseList, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.title.setText(this.mContext.getString(R$string.merge_alert_dialog_title, C13452e.m80781L().m80841P()));
        this.galleryItem.setVisibility(8);
        this.contactItem.setVisibility(8);
        this.browserItem.setVisibility(8);
        this.calendarItem.setVisibility(8);
        this.notepadItem.setVisibility(8);
        this.wlanItem.setVisibility(8);
        this.syncConfigView.setVisibility(8);
        this.syncConfigAdapter.m842b();
        this.confirmedModules.clear();
        showSplit(this.modules, this.traceId);
    }

    private void showSplit(ArrayList<String> arrayList, String str) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                this.confirmedModules.add(next);
                if (next.equals(HNConstants.DataType.MEDIA) && C0209d.m1166E1() && !isAgreeToBasicUser()) {
                    this.galleryItem.setVisibility(0);
                } else if (next.equals("addressbook") && isInCloudSyncBasicDataList("addressbook")) {
                    this.contactItem.setVisibility(0);
                } else if (next.equals("browser") && isInCloudSyncBasicDataList("browser")) {
                    this.browserItem.setVisibility(0);
                } else if (next.equals("calendar") && isInCloudSyncBasicDataList("calendar")) {
                    this.calendarItem.setVisibility(0);
                } else if (next.equals("notepad") && isInCloudSyncBasicDataList("notepad")) {
                    this.notepadItem.setVisibility(0);
                } else if (next.equals("wlan") && C0209d.m1166E1() && isInCloudSyncBasicDataList("wlan")) {
                    this.wlanItem.setVisibility(0);
                } else {
                    showSyncConfig(next);
                }
            }
        }
        if (C0209d.m1269j1()) {
            checkPermissionByService();
        }
        this.mTraceId = str;
        show();
    }

    private void showSyncConfig(String str) {
        ArrayList<SyncConfigService> arrayListM66456z = C11019b.m66371t().m66456z(this.mContext);
        if (arrayListM66456z == null || arrayListM66456z.size() <= 0) {
            return;
        }
        Iterator<SyncConfigService> it = arrayListM66456z.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            SyncConfigService next = it.next();
            if (next != null) {
                String id2 = next.getId();
                if (!TextUtils.isEmpty(id2) && str.equals(id2) && isInCloudSyncBasicDataList(next.getId())) {
                    this.syncConfigAdapter.m841a(next);
                    z10 = true;
                }
            }
        }
        if (z10) {
            this.syncConfigView.setVisibility(0);
            this.syncConfigAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton == null) {
            return;
        }
        int id2 = compoundButton.getId();
        if (id2 == R$id.rl_gallery_switch) {
            dealList(HNConstants.DataType.MEDIA, z10);
            return;
        }
        if (id2 == R$id.rl_contact_switch) {
            dealList("addressbook", z10);
            return;
        }
        if (id2 == R$id.rl_browser_switch) {
            dealList("browser", z10);
            return;
        }
        if (id2 == R$id.rl_calendar_switch) {
            dealList("calendar", z10);
            return;
        }
        if (id2 == R$id.rl_notepad_switch) {
            dealList("notepad", z10);
            return;
        }
        if (id2 == R$id.rl_wlan_switch) {
            dealList("wlan", z10);
            return;
        }
        Object tag = compoundButton.getTag();
        if (tag == null || !(tag instanceof String)) {
            return;
        }
        String str = (String) tag;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        dealList(str, z10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i(TAG, "fast click");
            return;
        }
        if (view == null) {
            C11839m.m70687e(TAG, "view is null");
            return;
        }
        if (this.dialogActivity == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.bt_cancel) {
            C11839m.m70688i(TAG, "click cancel");
            if (C13452e.m80781L().m80791C0()) {
                C1006a.m5936k().m5953Q(true, getContext());
            }
            this.dialogActivity.onCanceled("all_module", this.mClickOptType);
            return;
        }
        if (id2 == R$id.bt_confirm) {
            C11839m.m70688i(TAG, "click confirm");
            if (C13452e.m80781L().m80791C0()) {
                C1006a.m5936k().m5953Q(true, getContext());
            }
            this.dialogActivity.onConfirmed("all_module", this.mTraceId, this.confirmedModules, this.mClickOptType);
        }
    }

    public void show(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.size() == 0 || this.galleryItem == null || this.contactItem == null || this.browserItem == null || this.calendarItem == null || this.notepadItem == null || this.wlanItem == null || this.title == null || this.mContext == null || this.syncConfigView == null || this.syncConfigAdapter == null) {
            C11839m.m70687e(TAG, "show error");
            return;
        }
        this.modules = arrayList;
        this.traceId = str;
        C1008c.m6035v().m6051P(this.mContext, this.databasesHandler, false);
    }
}
