package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import ae.C0142k1;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p514o9.C11839m;
import p618rm.C12590s0;
import p676ud.AlertDialogC13154a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import sk.C12809f;

/* loaded from: classes3.dex */
public class AutoBackupFrequencyDialog extends AlertDialogC13154a {
    private static final String TAG = "AutoBackupFrequencyDialog";
    private Integer[] basicBusinessFrequency;
    private Map<String, String> basicGradeCodeName;
    private Context context;
    private C0142k1 frequencyListAdapter;
    private Map<String, String> gradeCodeName;
    private ListView listView;
    private View view;

    public class FrequencyDialogListener implements DialogInterface.OnClickListener {
        private static final String TAG = "FrequencyDialogListener";

        public FrequencyDialogListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 != i10) {
                if (-2 == i10) {
                    C13225d.m79490f1().m79585f0("mecloud_backup_frequency_cancel_click", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29954O("PVC", "mecloud_backup_frequency_cancel_click", "1", "44");
                    return;
                }
                return;
            }
            C13466f c13466fM81073d = C13466f.m81073d();
            int iM816d = AutoBackupFrequencyDialog.this.frequencyListAdapter.m816d();
            String strM75827a0 = "";
            String strM81079g = c13466fM81073d.m81079g("gradeCode", "");
            int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(strM81079g);
            C11839m.m70688i(TAG, "target frequency: " + iM816d + ", gradeCode: " + strM81079g);
            if (gradeMinFrequency > iM816d) {
                Iterator<Map.Entry<String, Integer>> it = CloudBackupUtil.getGradeAllFrequency().entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Integer> next = it.next();
                    if (AutoBackupFrequencyDialog.this.gradeCodeName.containsKey(next.getKey()) && iM816d == next.getValue().intValue()) {
                        strM75827a0 = next.getKey();
                        break;
                    }
                }
                if (TextUtils.isEmpty(strM75827a0)) {
                    strM75827a0 = C12590s0.m75827a0();
                }
                Message message = new Message();
                message.what = 33018;
                Bundle bundle = new Bundle();
                bundle.putString("targetGradeCode", strM75827a0);
                bundle.putInt("targetFrequency", iM816d);
                bundle.putString("targetGradeName", (String) AutoBackupFrequencyDialog.this.gradeCodeName.get(strM75827a0));
                message.obj = bundle;
                CBCallBack.getInstance().sendMessage(message);
            } else {
                C13467g.m81086c().m81098m(iM816d);
                Message message2 = new Message();
                message2.what = 33016;
                CBCallBack.getInstance().sendMessage(message2);
                LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("gradeCode", c13466fM81073d.m81079g("gradeCode", ""));
                linkedHashMapM79499C.put("backup_frequency", Integer.valueOf(iM816d));
                C13225d.m79490f1().m79567R("auto_backup_frequency_selected", linkedHashMapM79499C);
                UBAAnalyze.m29947H("CKC", "auto_backup_frequency_selected", linkedHashMapM79499C);
            }
            C13225d.m79490f1().m79585f0("mecloud_backup_frequency_confirm_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_backup_frequency_confirm_click", "1", "44");
        }
    }

    public AutoBackupFrequencyDialog(Context context, Map<String, String> map, Map<String, String> map2) {
        super(context);
        this.basicBusinessFrequency = new Integer[]{7, 5, 3, 1};
        this.context = context;
        this.gradeCodeName = map;
        this.basicGradeCodeName = map2;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.auto_backup_frequency_dialog, (ViewGroup) null);
        this.view = viewInflate;
        setView(viewInflate);
        initView();
    }

    private List<Integer> initAdapterList() {
        C11839m.m70688i(TAG, "init adapter list");
        int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(C13466f.m81073d().m81079g("gradeCode", ""));
        List<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : CloudBackupUtil.getGradeAllFrequency().entrySet()) {
            Integer value = entry.getValue();
            int iIntValue = value.intValue();
            if (!arrayList.contains(value)) {
                if (iIntValue >= gradeMinFrequency) {
                    arrayList.add(value);
                } else if (!TextUtils.isEmpty(this.gradeCodeName.get(entry.getKey()))) {
                    arrayList.add(value);
                }
            }
        }
        if (C13452e.m80781L().m80887a1()) {
            if (C13452e.m80781L().m80791C0()) {
                arrayList = Arrays.asList(this.basicBusinessFrequency);
            }
            Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.AutoBackupFrequencyDialog.1
                @Override // java.util.Comparator
                public int compare(Integer num, Integer num2) {
                    return num2.compareTo(num);
                }
            });
        } else {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private void initData() {
        C0142k1 c0142k1 = new C0142k1(this.context, initAdapterList());
        this.frequencyListAdapter = c0142k1;
        this.listView.setAdapter((ListAdapter) c0142k1);
        this.listView.setVisibility(0);
        this.frequencyListAdapter.m821j(C13467g.m81086c().m81091f());
        this.frequencyListAdapter.m820i(this.gradeCodeName);
        this.frequencyListAdapter.m819h(this.basicGradeCodeName);
    }

    private void initView() {
        this.listView = (ListView) C12809f.m76831d(this.view, R$id.frequency_list);
        FrequencyDialogListener frequencyDialogListener = new FrequencyDialogListener();
        setButton(-1, this.context.getString(R$string.cloudbackup_btn_ok), frequencyDialogListener);
        setButton(-2, this.context.getString(R$string.cloudbackup_Cancel), frequencyDialogListener);
    }

    private void setHeight() {
        Context context = this.context;
        if (context == null || context.getResources() == null) {
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        if (window == null || displayMetrics == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int height = window.getDecorView().getHeight();
        int i10 = displayMetrics.heightPixels;
        if (height >= ((int) (i10 * 0.7d))) {
            attributes.height = (int) (i10 * 0.7d);
        } else {
            attributes.height = -2;
        }
        window.setAttributes(attributes);
    }

    public void setBasicGradeCodeName(Map<String, String> map) {
        this.basicGradeCodeName = map;
    }

    public void setGradeCodeName(Map<String, String> map) {
        this.gradeCodeName = map;
    }

    @Override // android.app.Dialog
    public void show() {
        initData();
        setHeight();
        super.show();
    }
}
