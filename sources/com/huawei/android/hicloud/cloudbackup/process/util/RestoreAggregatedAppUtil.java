package com.huawei.android.hicloud.cloudbackup.process.util;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreAggregatedAppsAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.HashMap;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes2.dex */
public class RestoreAggregatedAppUtil {
    private static final HashMap<String, Integer> MODUlES_NAME = new HashMap<String, Integer>() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil.1
        public C26221() {
            int i10 = R$string.recorder_app_name;
            put("soundrecorder", Integer.valueOf(i10));
            put("com.huawei.hmos.soundrecorder", Integer.valueOf(i10));
            int i11 = R$string.recovering_call_recorder;
            put("callRecorder", Integer.valueOf(i11));
            put("com.huawei.hmos.callrecorder", Integer.valueOf(i11));
        }
    };
    private static final String TAG = "RestoreAggregatedAppUtil";

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil$1 */
    public class C26221 extends HashMap<String, Integer> {
        public C26221() {
            int i10 = R$string.recorder_app_name;
            put("soundrecorder", Integer.valueOf(i10));
            put("com.huawei.hmos.soundrecorder", Integer.valueOf(i10));
            int i11 = R$string.recovering_call_recorder;
            put("callRecorder", Integer.valueOf(i11));
            put("com.huawei.hmos.callrecorder", Integer.valueOf(i11));
        }
    }

    public static BottomSheetDialog buildAggregatedAppsDetailDialog(Context context, CloudRestoreItem cloudRestoreItem) throws IllegalAccessException, IllegalArgumentException {
        if (context == null) {
            return null;
        }
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_aggregated_apps_restore_detail, (ViewGroup) null);
        RestoreAggregatedAppsAdapter restoreAggregatedAppsAdapter = new RestoreAggregatedAppsAdapter(context);
        ((ListView) viewInflate.findViewById(R$id.childs_view)).setAdapter((ListAdapter) restoreAggregatedAppsAdapter);
        restoreAggregatedAppsAdapter.m25107b(cloudRestoreItem.m29202r());
        C12809f.m76831d(viewInflate, R$id.img_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        ((TextView) C12809f.m76831d(viewInflate, R$id.father_app_name)).setText(cloudRestoreItem.getAppName());
        bottomSheetDialog.setContentView(viewInflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.findViewById(R$id.design_bottom_sheet).setBackgroundResource(R.color.transparent);
            if (C0219i.m1463a() >= 17 && C11829c.m70563b0(context)) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                try {
                    attributes.getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).setInt(attributes, 1);
                } catch (Exception e10) {
                    C11839m.m70687e(TAG, "setCutoutMode exception:" + e10.toString());
                }
                window.setAttributes(attributes);
                if (C11842p.m70753O0(context)) {
                    window.addFlags(1024);
                } else {
                    window.clearFlags(1024);
                }
            }
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorM9904s = bottomSheetDialog.m9904s();
        if (C11842p.m70753O0(context)) {
            bottomSheetBehaviorM9904s.m9839C0(C11842p.m70752O(context));
        }
        return bottomSheetDialog;
    }

    public static void dismissAggregatedAppsDetailDialog(BottomSheetDialog bottomSheetDialog) {
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            return;
        }
        bottomSheetDialog.dismiss();
    }

    public static String getAppName(Context context, CloudRestoreItem cloudRestoreItem) {
        if (context == null || cloudRestoreItem == null || TextUtils.isEmpty(cloudRestoreItem.getAppId())) {
            return "";
        }
        HashMap<String, Integer> map = MODUlES_NAME;
        return map.get(cloudRestoreItem.getAppId()) != null ? context.getString(map.get(cloudRestoreItem.getAppId()).intValue()) : cloudRestoreItem.getAppName();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isShowAggregatedDialog(com.huawei.hicloud.cloudbackup.model.CloudRestoreItem r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            int r1 = r5.getStatus()
            java.lang.String r2 = r5.getAppId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "buildView appId "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " statue "
            r3.append(r2)
            int r2 = r5.getStatus()
            r3.append(r2)
            java.lang.String r2 = " type = "
            r3.append(r2)
            int r2 = r5.getType()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "RestoreAggregatedAppUtil"
            p514o9.C11839m.m70688i(r3, r2)
            r2 = 8
            r3 = 1
            if (r1 == r2) goto L43
            switch(r1) {
                case -8: goto L4a;
                case -7: goto L4a;
                case -6: goto L4a;
                case -5: goto L4a;
                case -4: goto L4a;
                case -3: goto L4a;
                case -2: goto L4a;
                case -1: goto L4a;
                case 0: goto L4a;
                case 1: goto L68;
                case 2: goto L4a;
                default: goto L42;
            }
        L42:
            goto L68
        L43:
            int r1 = r5.getType()
            if (r1 != r3) goto L4a
            goto L68
        L4a:
            java.util.List r1 = r5.m29202r()
            if (r1 == 0) goto L68
            java.util.List r5 = r5.m29202r()
            int r5 = r5.size()
            if (r5 <= r3) goto L68
            vj.e r5 = p709vj.C13452e.m80781L()
            int r5 = r5.m80916g0()
            if (r5 == 0) goto L68
            if (r5 != r3) goto L67
            goto L68
        L67:
            return r3
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil.isShowAggregatedDialog(com.huawei.hicloud.cloudbackup.model.CloudRestoreItem):boolean");
    }
}
