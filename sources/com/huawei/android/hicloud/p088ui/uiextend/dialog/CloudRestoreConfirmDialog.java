package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.util.BasicDataRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p676ud.AlertDialogC13154a;
import p711vl.C13466f;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudRestoreConfirmDialog extends AlertDialogC13154a {
    public static final float DISABLE_ALPHA = 0.38f;
    private static final String MORE = "…";
    private static final int ONE_MODULE = 1;
    private static final String TAG = "CloudRestoreConfirmDialog";
    private static final int TWO_MODULE = 2;
    private Button buttonPositive;
    private LinearLayout checkBoxLayout;
    private Context context;
    private boolean isIncludeAppData;
    private boolean isIncludeBaseItem;
    private boolean isOOBE;
    private boolean isRefurbished;
    private ArrayList<BasicDataRestoreUtil.BasicItemInfo> mBasicAppsPriorityList;
    private CheckBox mCheckBox;
    private TextView tvAppDataRefuerbished;
    private TextView tvAppDataTips;
    private TextView tvBackupSize;

    public interface BackupRecoverOnClickListner extends DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        void onClick(DialogInterface dialogInterface, int i10);
    }

    public CloudRestoreConfirmDialog(Context context, BackupRecoverOnClickListner backupRecoverOnClickListner, boolean z10) {
        super(context);
        this.isOOBE = false;
        this.mBasicAppsPriorityList = new ArrayList<>();
        this.context = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        View viewM76832e = C0209d.m1195O(context) > 1.75f ? C12809f.m76832e(layoutInflaterFrom, R$layout.dialog_backup_recover_title_font_scale) : C12809f.m76832e(layoutInflaterFrom, R$layout.dialog_backup_recover_title);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_title);
        if (z10) {
            textView.setText(R$string.dialog_restore_confirm_title);
        } else {
            textView.setText(R$string.restore_replace_title);
        }
        setCustomTitle(viewM76832e);
        if (z10) {
            setButton(-1, context.getString(R$string.backup_record_recovery), backupRecoverOnClickListner);
            setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), backupRecoverOnClickListner);
        } else {
            setButton(-1, context.getString(R$string.dialog_restore_confirm_title), backupRecoverOnClickListner);
            setButton(-2, context.getString(R$string.restore_new_cancel), backupRecoverOnClickListner);
        }
        initView();
    }

    private void addThirdDataItemFromBaseData(CloudRestoreItem cloudRestoreItem, ArrayList<CloudRestoreItem> arrayList) {
        for (CloudRestoreItem cloudRestoreItem2 : cloudRestoreItem.m29202r()) {
            C11839m.m70686d(TAG, "addThirdDataItemFromBaseData appId = " + cloudRestoreItem2.getAppId() + " action = " + cloudRestoreItem2.getAction());
            if (cloudRestoreItem2.getAction() != 2 && cloudRestoreItem2.m29187M() && !cloudRestoreItem2.isHarmonyNext()) {
                this.isIncludeAppData = true;
                arrayList.add(cloudRestoreItem2);
            }
        }
    }

    private String getShowAppNames(List<Object> list, ArrayList<CloudRestoreItem> arrayList) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        if (arrayList.size() == 1) {
            String splitApkType = arrayList.get(0).getSplitApkType();
            string2 = SplitAppUtil.isTwinApp(splitApkType, arrayList.get(0).getOriBackupAppName()) ? this.context.getString(R$string.refurbish_twin_app, arrayList.get(0).getAppName().replace(splitApkType, "")) : arrayList.get(0).getAppName();
        } else {
            if (arrayList.size() < 2) {
                return "";
            }
            Iterator<Object> it = list.iterator();
            final CloudRestoreItem cloudRestoreItem = null;
            final CloudRestoreItem cloudRestoreItem2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next instanceof CloudRestoreItem) {
                    CloudRestoreItem cloudRestoreItem3 = (CloudRestoreItem) next;
                    if (cloudRestoreItem3.getAction() != 2 && ((cloudRestoreItem3.m29187M() && !cloudRestoreItem3.isHarmonyNext()) || C14333b.m85480o().contains(cloudRestoreItem3.getAppId()) || (!"sysdata".equals(cloudRestoreItem3.getAppId()) && cloudRestoreItem3.isHarmonyNext()))) {
                        if (cloudRestoreItem2 == null) {
                            cloudRestoreItem2 = cloudRestoreItem3;
                        } else if (!Objects.equals(cloudRestoreItem2.getOriBackupAppName(), cloudRestoreItem3.getOriBackupAppName())) {
                            cloudRestoreItem = cloudRestoreItem3;
                            break;
                        }
                    }
                }
            }
            if (cloudRestoreItem2 == null) {
                C11839m.m70686d(TAG, "firstCloudRestoreItem is null, no data");
                return "";
            }
            if (cloudRestoreItem == null) {
                Optional<CloudRestoreItem> optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.a0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreConfirmDialog.lambda$getShowAppNames$2((CloudRestoreItem) obj);
                    }
                }).findFirst();
                string2 = optionalFindFirst.isPresent() ? this.context.getString(R$string.dialog_has_split_add_name_new, optionalFindFirst.get().getAppName()) : this.context.getString(R$string.refurbish_twin_app, arrayList.get(0).getAppName().replace(arrayList.get(0).getSplitApkType(), ""));
            } else if (!SplitAppUtil.isTwinApp(cloudRestoreItem2.getSplitApkType(), cloudRestoreItem2.getOriBackupAppName())) {
                long jCount = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.b0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreConfirmDialog.lambda$getShowAppNames$3(cloudRestoreItem2, (CloudRestoreItem) obj);
                    }
                }).count();
                long jCount2 = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.c0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreConfirmDialog.lambda$getShowAppNames$4(cloudRestoreItem, (CloudRestoreItem) obj);
                    }
                }).count();
                if (jCount > 1) {
                    Context context = this.context;
                    int i10 = R$string.dialog_has_split_add_name;
                    String string6 = context.getString(i10, cloudRestoreItem2.getAppName());
                    if (jCount2 > 1) {
                        string5 = this.context.getString(i10, cloudRestoreItem.getAppName());
                    } else {
                        string5 = SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName()) ? this.context.getString(R$string.refurbish_twin_app, cloudRestoreItem.getAppName().replace(cloudRestoreItem.getSplitApkType(), "")) : cloudRestoreItem.getAppName();
                    }
                    string2 = this.context.getString(R$string.restore_apps, string6, string5);
                } else {
                    if (jCount2 > 1) {
                        string4 = this.context.getString(R$string.dialog_has_split_add_name, cloudRestoreItem.getAppName());
                    } else {
                        string4 = SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName()) ? this.context.getString(R$string.refurbish_twin_app, cloudRestoreItem.getAppName().replace(cloudRestoreItem.getSplitApkType(), "")) : cloudRestoreItem.getAppName();
                    }
                    string2 = this.context.getString(R$string.restore_apps, cloudRestoreItem2.getAppName(), string4);
                }
            } else {
                if (SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                    String strReplace = cloudRestoreItem2.getAppName().replace(cloudRestoreItem2.getSplitApkType(), "");
                    Context context2 = this.context;
                    int i11 = R$string.refurbish_twin_app;
                    return this.context.getString(R$string.restore_apps, context2.getString(i11, strReplace), this.context.getString(i11, cloudRestoreItem.getAppName().replace(cloudRestoreItem.getSplitApkType(), "")));
                }
                long jCount3 = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.d0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreConfirmDialog.lambda$getShowAppNames$5(cloudRestoreItem, (CloudRestoreItem) obj);
                    }
                }).count();
                long jCount4 = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.e0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudRestoreConfirmDialog.lambda$getShowAppNames$6(cloudRestoreItem2, (CloudRestoreItem) obj);
                    }
                }).count();
                if (jCount3 > 1) {
                    Context context3 = this.context;
                    int i12 = R$string.dialog_has_split_add_name;
                    String string7 = context3.getString(i12, cloudRestoreItem.getAppName());
                    if (jCount4 > 1) {
                        string3 = this.context.getString(i12, cloudRestoreItem2.getAppName());
                    } else {
                        string3 = SplitAppUtil.isTwinApp(cloudRestoreItem2.getSplitApkType(), cloudRestoreItem2.getOriBackupAppName()) ? this.context.getString(R$string.refurbish_twin_app, cloudRestoreItem2.getAppName().replace(cloudRestoreItem2.getSplitApkType(), "")) : cloudRestoreItem2.getAppName();
                    }
                    string2 = this.context.getString(R$string.restore_apps, string3, string7);
                } else {
                    if (jCount4 > 1) {
                        string = this.context.getString(R$string.dialog_has_split_add_name, cloudRestoreItem2.getAppName());
                    } else {
                        string = SplitAppUtil.isTwinApp(cloudRestoreItem2.getSplitApkType(), cloudRestoreItem2.getOriBackupAppName()) ? this.context.getString(R$string.refurbish_twin_app, cloudRestoreItem2.getAppName().replace(cloudRestoreItem2.getSplitApkType(), "")) : cloudRestoreItem2.getAppName();
                    }
                    string2 = this.context.getString(R$string.restore_apps, string, cloudRestoreItem.getAppName());
                }
            }
        }
        return string2;
    }

    private ArrayList<CloudRestoreItem> getThirdDataItems(List<CloudRestoreItem> list) {
        ArrayList<CloudRestoreItem> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (CloudRestoreItem cloudRestoreItem : list) {
                String appId = cloudRestoreItem.getAppId();
                C11839m.m70686d(TAG, "appId = " + appId + " action = " + cloudRestoreItem.getAction());
                if (cloudRestoreItem.m29189N()) {
                    if ("bmBaseData".equals(appId)) {
                        for (CloudRestoreItem cloudRestoreItem2 : cloudRestoreItem.m29202r()) {
                            if (C14333b.m85480o().contains(cloudRestoreItem2.getAppId()) && cloudRestoreItem2.getAction() != 2) {
                                this.isIncludeAppData = true;
                                arrayList.add(cloudRestoreItem2);
                            }
                        }
                    }
                    this.mBasicAppsPriorityList = BasicDataRestoreUtil.getBasicPriorityApps(cloudRestoreItem, true);
                    boolean z10 = cloudRestoreItem.getAction() != 2;
                    this.isIncludeBaseItem = z10;
                    if (!z10 && cloudRestoreItem.m29202r() != null) {
                        this.isIncludeBaseItem = cloudRestoreItem.m29202r().stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.z
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return CloudRestoreConfirmDialog.lambda$getThirdDataItems$7((CloudRestoreItem) obj);
                            }
                        });
                    }
                    addThirdDataItemFromBaseData(cloudRestoreItem, arrayList);
                } else if (cloudRestoreItem.getAction() != 2 && ((cloudRestoreItem.m29187M() && !cloudRestoreItem.isHarmonyNext()) || (!"sysdata".equals(cloudRestoreItem.getAppId()) && cloudRestoreItem.isHarmonyNext()))) {
                    this.isIncludeAppData = true;
                    arrayList.add(cloudRestoreItem);
                }
            }
        }
        return arrayList;
    }

    private void initView() {
        View viewM76832e = C12809f.m76832e(LayoutInflater.from(this.context), R$layout.dialog_backup_recover);
        setView(viewM76832e);
        this.tvBackupSize = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_backup_size);
        this.checkBoxLayout = (LinearLayout) C12809f.m76831d(viewM76832e, R$id.ll_app_info);
        this.tvAppDataTips = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_app_data_tips);
        this.tvAppDataRefuerbished = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_app_data_refurbish);
        this.mCheckBox = (CheckBox) C12809f.m76831d(viewM76832e, R$id.cb_app_data);
        this.checkBoxLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19215a.lambda$initView$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getShowAppNames$2(CloudRestoreItem cloudRestoreItem) {
        return !SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getShowAppNames$3(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return Objects.equals(cloudRestoreItem2.getOriBackupAppName(), cloudRestoreItem.getOriBackupAppName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getShowAppNames$4(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return Objects.equals(cloudRestoreItem2.getOriBackupAppName(), cloudRestoreItem.getOriBackupAppName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getShowAppNames$5(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return Objects.equals(cloudRestoreItem2.getOriBackupAppName(), cloudRestoreItem.getOriBackupAppName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getShowAppNames$6(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return Objects.equals(cloudRestoreItem2.getOriBackupAppName(), cloudRestoreItem.getOriBackupAppName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getThirdDataItems$7(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAction() != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        this.mCheckBox.setChecked(!r3.isChecked());
        if (this.buttonPositive == null) {
            return;
        }
        if (this.mCheckBox.isChecked()) {
            this.buttonPositive.setEnabled(true);
            this.buttonPositive.setAlpha(1.0f);
        } else {
            this.buttonPositive.setEnabled(false);
            this.buttonPositive.setAlpha(0.38f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$setSedRecoveryItem$1(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        return Long.compare(cloudRestoreItem2.getSize(), cloudRestoreItem.getSize());
    }

    private void setBasicAppsTips(String str) {
        String string;
        ArrayList<BasicDataRestoreUtil.BasicItemInfo> arrayList = this.mBasicAppsPriorityList;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        if (this.mBasicAppsPriorityList.size() == 1) {
            string = this.context.getString(R$string.backup_recover_basic_data_restore_few_items, this.mBasicAppsPriorityList.get(0).getAppName());
        } else if (this.mBasicAppsPriorityList.size() == 2) {
            string = this.context.getString(R$string.backup_recover_basic_data_restore_few_items, this.context.getString(R$string.service_names, this.mBasicAppsPriorityList.get(0).getAppName(), this.mBasicAppsPriorityList.get(1).getAppName()));
        } else if (this.mBasicAppsPriorityList.size() == 3) {
            string = this.context.getString(R$string.backup_recover_basic_data_restore_few_items, this.context.getString(R$string.backup_recover_base_data_triple_not_support, this.mBasicAppsPriorityList.get(0).getAppName(), this.mBasicAppsPriorityList.get(1).getAppName(), this.mBasicAppsPriorityList.get(2).getAppName()));
        } else if (this.mBasicAppsPriorityList.size() > 3) {
            string = this.context.getString(R$string.backup_recover_basic_data_restore_many_items, this.context.getString(R$string.backup_recover_base_data_triple_not_support, this.mBasicAppsPriorityList.get(0).getAppName(), this.mBasicAppsPriorityList.get(1).getAppName(), this.mBasicAppsPriorityList.get(2).getAppName()));
        } else {
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.tvAppDataTips.setText(this.context.getString(R$string.backup_recover_basic_data_restore_tip, string, str));
    }

    private List<Object> sortRestoreItems(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof CloudRestoreItem) {
                CloudRestoreItem cloudRestoreItem = (CloudRestoreItem) obj;
                CloudRestoreItem cloudRestoreItemClone = cloudRestoreItem.clone();
                if ("com.tencent.mm".equals(cloudRestoreItem.getOriBackupAppName())) {
                    if ("com.tencent.mm".equals(cloudRestoreItem.getAppId())) {
                        arrayList.add(cloudRestoreItemClone);
                    } else {
                        arrayList2.add(cloudRestoreItemClone);
                    }
                } else if ("com.tencent.mobileqq".equals(cloudRestoreItem.getAppId())) {
                    arrayList3.add(cloudRestoreItemClone);
                } else {
                    arrayList4.add(cloudRestoreItemClone);
                }
            }
        }
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList);
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        Iterator<BasicDataRestoreUtil.BasicItemInfo> it = this.mBasicAppsPriorityList.iterator();
        while (it.hasNext()) {
            BasicDataRestoreUtil.BasicItemInfo next = it.next();
            if (C14333b.m85480o().contains(next.getAppId())) {
                CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                cloudRestoreItem2.setAppId(next.getAppId());
                cloudRestoreItem2.setAppName(next.getAppName());
                arrayList5.add(cloudRestoreItem2);
            }
        }
        return arrayList5;
    }

    public int getSelectSize() {
        return getThirdDataItems(RestoreCache.getInstance().getItemList()).size();
    }

    public void setIsOOBE(boolean z10) {
        this.isOOBE = z10;
    }

    public void setRecoveryItem(long j10) {
        this.isIncludeAppData = false;
        this.tvAppDataTips.setText(this.context.getString(R$string.restore_confirm_size_tip, C0209d.m1232a0(C0223k.m1524g(this.context, j10))));
        if (j10 > 0) {
            this.tvAppDataTips.setVisibility(0);
        }
        C12809f.m76843p(this.tvAppDataTips, true);
        C12809f.m76843p(this.checkBoxLayout, false);
        if (!this.isRefurbished) {
            C12809f.m76843p(this.tvAppDataRefuerbished, false);
        } else {
            C12809f.m76843p(this.tvAppDataRefuerbished, true);
            C12809f.m76843p(this.checkBoxLayout, true);
        }
    }

    public void setRefurbished(boolean z10) {
        this.isRefurbished = z10;
    }

    public void setSedRecoveryItem(String str, List<Object> list, boolean z10) {
        this.isIncludeAppData = false;
        ArrayList<CloudRestoreItem> thirdDataItems = getThirdDataItems(RestoreCache.getInstance().getItemList());
        int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
        if (!this.isIncludeAppData || z10 || iM81077e == 1) {
            return;
        }
        if (thirdDataItems.size() > 1) {
            thirdDataItems.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.g0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CloudRestoreConfirmDialog.lambda$setSedRecoveryItem$1((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
                }
            });
        }
        String showAppNames = getShowAppNames(sortRestoreItems(list), thirdDataItems);
        String quantityString = this.context.getResources().getQuantityString(R$plurals.other_app_count, thirdDataItems.size(), Integer.valueOf(thirdDataItems.size()));
        if (thirdDataItems.size() == 1) {
            this.tvAppDataTips.setText(this.context.getString(R$string.restore_confirm_one, showAppNames, str));
        } else if (thirdDataItems.size() == 2) {
            this.tvAppDataTips.setText(this.context.getString(R$string.restore_confirm_two_new, showAppNames, quantityString, str));
        } else {
            this.tvAppDataTips.setText(this.context.getString(R$string.restore_confirm_more_new, showAppNames, quantityString, str));
        }
        C12809f.m76843p(this.tvAppDataTips, true);
        C12809f.m76843p(this.checkBoxLayout, true);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.isOOBE) {
            C11829c.m70585i1(getWindow());
            C11840n.m70694e(this);
        }
        super.show();
        Button button = getButton(-1);
        this.buttonPositive = button;
        if (button == null) {
            return;
        }
        if (!C12809f.m76836i(this.checkBoxLayout)) {
            this.buttonPositive.setEnabled(true);
            this.buttonPositive.setAlpha(1.0f);
        } else {
            this.mCheckBox.setChecked(false);
            this.buttonPositive.setEnabled(false);
            this.buttonPositive.setAlpha(0.38f);
        }
    }
}
