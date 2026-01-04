package com.huawei.android.hicloud.p088ui.activity;

import ae.C0111c1;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCard;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCategory;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.uikit.phone.hwrecyclerview.widget.HwRecyclerView;
import dj.C9159b;
import fk.C9721b;
import huawei.android.app.HwProgressDialog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0209d;
import p015ak.C0213f;
import p252e9.C9428e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p581qk.AbstractC12368e;
import p610rd.C12488a;
import p616rk.C12515a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DuplicateFileActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public AlertDialog f14766A;

    /* renamed from: B */
    public HwProgressDialog f14767B;

    /* renamed from: C */
    public AlertDialog f14768C;

    /* renamed from: D */
    public final Handler f14769D;

    /* renamed from: E */
    public volatile Map<Integer, List<DuplicateFileCard>> f14770E;

    /* renamed from: F */
    public volatile Set<FileModel> f14771F;

    /* renamed from: G */
    public final C3278d f14772G;

    /* renamed from: H */
    public float f14773H;

    /* renamed from: I */
    public View.OnClickListener f14774I;

    /* renamed from: J */
    public boolean f14775J;

    /* renamed from: p */
    public Context f14776p;

    /* renamed from: q */
    public TextView f14777q;

    /* renamed from: r */
    public View f14778r;

    /* renamed from: s */
    public View f14779s;

    /* renamed from: t */
    public HwRecyclerView f14780t;

    /* renamed from: u */
    public View f14781u;

    /* renamed from: v */
    public TextView f14782v;

    /* renamed from: w */
    public C0111c1 f14783w;

    /* renamed from: x */
    public final Map<Integer, DuplicateFileCategory> f14784x = new HashMap();

    /* renamed from: y */
    public C3280f f14785y;

    /* renamed from: z */
    public AutoSizeButton f14786z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$b */
    public class DialogInterfaceOnClickListenerC3276b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final CheckBox f14787a;

        public DialogInterfaceOnClickListenerC3276b(CheckBox checkBox) {
            this.f14787a = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (DuplicateFileActivity.this.f14776p == null) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file deleteCloudFileListener context is null.");
            } else {
                CheckBox checkBox = this.f14787a;
                C9428e.m59118h().m59126g(new ArrayList(DuplicateFileActivity.this.f14771F), DuplicateFileActivity.this.f14772G, checkBox != null ? checkBox.isChecked() : false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$c */
    public class C3277c extends C12488a {

        /* renamed from: d */
        public WeakReference<Handler> f14789d;

        public C3277c(Handler handler, List<FileModel> list, int i10) {
            super(list, i10);
            this.f14789d = new WeakReference<>(handler);
        }

        @Override // p610rd.C12488a
        /* renamed from: c */
        public void mo19674c() {
            super.mo19674c();
            WeakReference<Handler> weakReference = this.f14789d;
            if (weakReference == null) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file queryAfterRefershUI refHandler is null");
                return;
            }
            Handler handler = weakReference.get();
            if (handler == null) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file queryAfterRefershUI handler is null");
            } else {
                handler.sendEmptyMessage(2);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$d */
    public class C3278d implements CloudDiskFileDeleteTask.Callback {

        /* renamed from: a */
        public final Handler f14791a;

        public C3278d(Handler handler) {
            this.f14791a = handler;
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask.Callback
        /* renamed from: a */
        public void mo15806a() {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealTaskStart");
            DuplicateFileActivity.this.m20429q2(this.f14791a, 11, null, false);
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask.Callback
        /* renamed from: b */
        public void mo15807b(int i10) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealTaskEnd");
            DuplicateFileActivity.this.f14775J = true;
            DuplicateFileActivity.this.m20429q2(this.f14791a, 12, Integer.valueOf(i10), false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$e */
    public class ViewOnClickListenerC3279e implements View.OnClickListener {
        public ViewOnClickListenerC3279e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DuplicateFileActivity.this.m20434h2(view);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$f */
    public class C3280f extends AbstractC12368e {

        /* renamed from: a */
        public final Handler f14794a;

        /* renamed from: b */
        public final boolean f14795b;

        public C3280f(Handler handler, boolean z10) {
            this.f14794a = handler;
            this.f14795b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                try {
                    C11839m.m70688i("DuplicateFileActivity", "duplicate file LoadFileDataTask start.");
                    if (this.f14795b) {
                        this.f14794a.sendEmptyMessage(0);
                    }
                    ArrayList arrayList = new ArrayList();
                    DuplicateFileActivity.this.f14770E = FileUtil.m16367q(DuplicateFileActivity.this.getResources().getString(R$string.hidisk_my_drive), arrayList);
                    if (!arrayList.isEmpty()) {
                        C12515a.m75110o().m75172d(DuplicateFileActivity.this.new C3277c(this.f14794a, arrayList, 1));
                    }
                    C11839m.m70688i("DuplicateFileActivity", "duplicate file LoadFileDataTask end.");
                } catch (Exception e10) {
                    C11839m.m70687e("DuplicateFileActivity", "duplicate file LoadFileDataTask error: " + e10.toString());
                }
                this.f14794a.sendEmptyMessage(1);
            } catch (Throwable th2) {
                this.f14794a.sendEmptyMessage(1);
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$g */
    public class ViewOnClickListenerC3281g implements View.OnClickListener {

        /* renamed from: a */
        public final Context f14797a;

        /* renamed from: b */
        public final String f14798b;

        public ViewOnClickListenerC3281g(Context context, String str) {
            this.f14797a = context;
            this.f14798b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14797a == null) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file openCloudDirListener context is null.");
                return;
            }
            if (TextUtils.isEmpty(this.f14798b)) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file openCloudDirListener parentFileId is null.");
                return;
            }
            AlertDialog alertDialog = DuplicateFileActivity.this.f14768C;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_COMPATIBLE_NEW");
            C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            intent.putExtra("cloud_disk_file_id", this.f14798b);
            C9159b.m57571j(intent);
            intent.putExtra("from_to", 6);
            intent.putExtra("not_exist_to_disk_root", true);
            try {
                this.f14797a.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("DuplicateFileActivity", "duplicate file openCloudDirListener error: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$h */
    public class HandlerC3282h extends Handler {
        public HandlerC3282h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Integer num;
            int iIntValue;
            super.handleMessage(message);
            int i10 = message.what;
            C11839m.m70688i("DuplicateFileActivity", "duplicate file handleMessage what: " + i10);
            if (i10 == 0) {
                DuplicateFileActivity.this.m20430u2();
                return;
            }
            if (i10 == 1) {
                removeMessages(0);
                DuplicateFileActivity.this.m20441p2();
                return;
            }
            if (i10 == 2) {
                if (DuplicateFileActivity.this.f14783w != null) {
                    DuplicateFileActivity.this.f14783w.m5213j();
                    return;
                }
                return;
            }
            if (i10 == 11) {
                DuplicateFileActivity duplicateFileActivity = DuplicateFileActivity.this;
                duplicateFileActivity.f14767B = duplicateFileActivity.m20425e2(duplicateFileActivity);
                if (DuplicateFileActivity.this.f14767B != null) {
                    DuplicateFileActivity.this.f14767B.show();
                    return;
                }
                return;
            }
            if (i10 != 12) {
                return;
            }
            removeMessages(0);
            if (DuplicateFileActivity.this.f14767B != null) {
                DuplicateFileActivity.this.f14767B.dismiss();
            }
            Object obj = message.obj;
            if ((obj instanceof Integer) && (iIntValue = (num = (Integer) obj).intValue()) > 0) {
                C11841o.m70708d(DuplicateFileActivity.this.f14776p, DuplicateFileActivity.this.f14776p.getResources().getQuantityString(R$plurals.file_delete_fail, iIntValue, num), 0);
            }
            if (DuplicateFileActivity.this.f14785y != null) {
                DuplicateFileActivity.this.f14785y.cancel();
            }
            DuplicateFileActivity.this.f14771F.clear();
            DuplicateFileActivity duplicateFileActivity2 = DuplicateFileActivity.this;
            duplicateFileActivity2.f14785y = duplicateFileActivity2.new C3280f(duplicateFileActivity2.f14769D, false);
            C12515a.m75110o().m75172d(DuplicateFileActivity.this.f14785y);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DuplicateFileActivity$i */
    public class DialogInterfaceOnClickListenerC3283i implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final Context f14801a;

        /* renamed from: b */
        public final String f14802b;

        public DialogInterfaceOnClickListenerC3283i(Context context, String str) {
            this.f14801a = context;
            this.f14802b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f14801a == null) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file viewCloudFileListener context is null.");
            } else if (TextUtils.isEmpty(this.f14802b)) {
                C11839m.m70688i("DuplicateFileActivity", "duplicate file viewCloudFileListener fileId is null.");
            } else {
                dialogInterface.dismiss();
                DuplicateFileActivity.this.m20437k2(this.f14801a, this.f14802b);
            }
        }
    }

    public DuplicateFileActivity() {
        HandlerC3282h handlerC3282h = new HandlerC3282h(Looper.getMainLooper());
        this.f14769D = handlerC3282h;
        this.f14771F = new HashSet();
        this.f14772G = new C3278d(handlerC3282h);
        this.f14775J = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public HwProgressDialog m20425e2(Context context) {
        if (context == null) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file createDeleteProgress context is null.");
            return null;
        }
        HwProgressDialog hwProgressDialog = new HwProgressDialog(context);
        hwProgressDialog.setMessage(context.getString(R$string.hicloud_notepad_deleting));
        hwProgressDialog.setCanceledOnTouchOutside(false);
        hwProgressDialog.setCancelable(true);
        return hwProgressDialog;
    }

    /* renamed from: f2 */
    private AlertDialog m20426f2(Context context, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2, FileModel fileModel) {
        if (context == null) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file createDetailDialog context is null.");
            return null;
        }
        if (fileModel == null) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file createDetailDialog item is null.");
            return null;
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        View viewM76832e = this.f14773H >= 1.75f ? C12809f.m76832e(layoutInflater, R$layout.cloud_disk_file_detail_dialog_1dot75) : C12809f.m76832e(layoutInflater, R$layout.cloud_disk_file_detail_dialog);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_name);
        TextView textView2 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_size);
        TextView textView3 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_modify_time);
        TextView textView4 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_parent_path);
        textView.setText(fileModel.getFileName());
        textView4.setText(fileModel.getCloudPath());
        textView3.setText(C11829c.m70535O(fileModel.getModifyTime()));
        textView2.setText(C11829c.m70551W(fileModel.getFileSize()));
        AlertDialog alertDialogCreate = UIActivity.m22363s1(context) ? new AlertDialog.Builder(context).setTitle(R$string.file_detail).setPositiveButton(R$string.lookat, onClickListener).setNegativeButton(R$string.cancel, (DialogInterface.OnClickListener) null).setView(viewM76832e).create() : new AlertDialog.Builder(context).setTitle(R$string.file_detail).setPositiveButton(R$string.phonefinder_dialog_know, (DialogInterface.OnClickListener) null).setView(viewM76832e).create();
        textView4.setOnClickListener(onClickListener2);
        return alertDialogCreate;
    }

    /* renamed from: g2 */
    private void m20427g2() {
        if (isFinishing()) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealFileDeleteClick isFinishing");
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealFileDeleteClick isFast click");
            return;
        }
        if (!C0209d.m1208S0(this)) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealFileDeleteClick network not connected!");
            C11841o.m70708d(this, getString(R$string.gallery_no_network_tips), 0);
            return;
        }
        AlertDialog alertDialogM20433d2 = m20433d2();
        this.f14766A = alertDialogM20433d2;
        if (alertDialogM20433d2 != null) {
            alertDialogM20433d2.show();
            this.f14766A.getButton(-1).setTextColor(getColor(R$color.red));
        }
    }

    /* renamed from: n2 */
    private void m20428n2() {
        this.f14777q = (TextView) C12809f.m76829b(this, R$id.duplicate_file_total_size);
        this.f14778r = C12809f.m76829b(this, R$id.duplicate_file_view);
        this.f14779s = C12809f.m76829b(this, R$id.duplicate_file_main_view);
        this.f14780t = (HwRecyclerView) C12809f.m76829b(this, R$id.duplicate_file_recyclerview);
        this.f14781u = C12809f.m76829b(this, R$id.duplicate_file_loading);
        this.f14782v = (TextView) C12809f.m76829b(this, R$id.no_file);
        this.f14786z = (AutoSizeButton) C12809f.m76829b(this, R$id.duplicate_file_delete_button);
        m20442r2();
        m20444t2(8, 8, 0, 8, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2 */
    public void m20429q2(Handler handler, int i10, Object obj, boolean z10) {
        if (handler == null) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file sendMessage handler is null.");
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        messageObtainMessage.obj = obj;
        if (z10) {
            handler.sendMessageDelayed(messageObtainMessage, 500L);
        } else {
            handler.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u2 */
    public void m20430u2() {
        View view = this.f14779s;
        if (view != null) {
            view.setVisibility(8);
        }
        AutoSizeButton autoSizeButton = this.f14786z;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        View view2 = this.f14781u;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* renamed from: b2 */
    public final void m20431b2(List<Object> list, int i10) {
        List<DuplicateFileCard> list2 = this.f14770E.get(Integer.valueOf(i10));
        if (list2 == null || list2.isEmpty()) {
            this.f14784x.remove(Integer.valueOf(i10));
            C11839m.m70688i("DuplicateFileActivity", "duplicate file fileCategory: " + i10 + " not exist files");
            return;
        }
        DuplicateFileCategory duplicateFileCategory = this.f14784x.get(Integer.valueOf(i10));
        if (duplicateFileCategory == null) {
            duplicateFileCategory = new DuplicateFileCategory(i10, false, list2);
            this.f14784x.put(Integer.valueOf(i10), duplicateFileCategory);
        } else {
            duplicateFileCategory.setCardList(list2);
        }
        duplicateFileCategory.setLastCategory(m20440o2(i10));
        if (duplicateFileCategory.isLastCategory()) {
            duplicateFileCategory.setExpand(true);
        }
        list.add(duplicateFileCategory);
        Collection<? extends Object> cardAndFileList = duplicateFileCategory.getCardAndFileList();
        if (cardAndFileList == null || !duplicateFileCategory.existFiles()) {
            return;
        }
        list.addAll(cardAndFileList);
    }

    /* renamed from: c2 */
    public final boolean m20432c2(int i10) {
        return this.f14770E.get(Integer.valueOf(i10)) == null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14778r);
        arrayList.add(this.f14779s);
        return arrayList;
    }

    /* renamed from: d2 */
    public final AlertDialog m20433d2() {
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file showDeleteDialog resource is null.");
            return null;
        }
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), R$layout.cloud_disk_file_delete_dialog);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.delete_file_tip);
        CheckBox checkBox = (CheckBox) C12809f.m76831d(viewM76832e, R$id.delete_choose);
        textView.setText(resources.getQuantityString(R$plurals.file_delete_tip, 30, 30));
        int size = this.f14771F.size();
        return new AlertDialog.Builder(this).setTitle(resources.getQuantityString(R$plurals.file_delete_title, size, Integer.valueOf(size))).setPositiveButton(R$string.delete, new DialogInterfaceOnClickListenerC3276b(checkBox)).setNegativeButton(R$string.cancel, (DialogInterface.OnClickListener) null).setView(viewM76832e).create();
    }

    /* renamed from: h2 */
    public final void m20434h2(View view) {
        if (view == null) {
            C11839m.m70686d("DuplicateFileActivity", "duplicate file dealFileDetailClick view is null.");
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file dealFileDetailClick isFastClick.");
            return;
        }
        if (!(view.getTag() instanceof FileModel)) {
            C11839m.m70686d("DuplicateFileActivity", "duplicate file dealFileDetailClick obj is null.");
            return;
        }
        FileModel fileModel = (FileModel) view.getTag();
        AlertDialog alertDialogM20426f2 = m20426f2(this, new DialogInterfaceOnClickListenerC3283i(this, fileModel.getFileId()), new ViewOnClickListenerC3281g(this, fileModel.getFileParent()), fileModel);
        this.f14768C = alertDialogM20426f2;
        if (alertDialogM20426f2 != null) {
            alertDialogM20426f2.show();
            Button button = this.f14768C.getButton(-1);
            if (button != null) {
                button.setTextColor(getColor(R$color.file_detail_path_color));
            }
            Button button2 = this.f14768C.getButton(-2);
            if (button2 != null) {
                button2.setTextColor(getColor(R$color.file_detail_path_color));
            }
        }
    }

    /* renamed from: i2 */
    public final long m20435i2() {
        Iterator<FileModel> it = this.f14771F.iterator();
        long fileSize = 0;
        while (it.hasNext()) {
            fileSize += it.next().getFileSize();
        }
        return fileSize;
    }

    /* renamed from: j2 */
    public final long m20436j2() {
        long size = 0;
        if (this.f14770E != null) {
            Iterator<Map.Entry<Integer, List<DuplicateFileCard>>> it = this.f14770E.entrySet().iterator();
            while (it.hasNext()) {
                for (DuplicateFileCard duplicateFileCard : it.next().getValue()) {
                    if (duplicateFileCard.getFileModelList() != null) {
                        size += duplicateFileCard.getSize() * r4.size();
                    }
                }
            }
        }
        return size;
    }

    /* renamed from: k2 */
    public void m20437k2(Context context, String str) {
        if (C4633d0.m28404a(str)) {
            C11839m.m70687e("DuplicateFileActivity", "duplicate file fileId =" + str);
        }
        if (!UIActivity.m22363s1(context)) {
            C11839m.m70687e("DuplicateFileActivity", "duplicate file is not Has FileViewer");
            m22375i1(this, 9);
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        intent.setAction("com.huawei.hidisk.action.EXTERNAL_FILE_VIEWER");
        intent.putExtra("fileId", str);
        intent.putExtra("from_to", 6);
        intent.putExtra("not_exist_to_disk_root", true);
        intent.putExtra("type", "key_file_view_from_space_clean");
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("DuplicateFileActivity", "duplicate file gotoFileViewer is failed =" + e10.getMessage());
            m22375i1(this, 9);
        }
    }

    /* renamed from: l2 */
    public final void m20438l2() {
        this.f14771F.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileModel());
        arrayList.add(new FileModel());
        m20431b2(arrayList, 0);
        m20431b2(arrayList, 2);
        m20431b2(arrayList, 3);
        m20431b2(arrayList, 1);
        m20431b2(arrayList, 4);
        m20431b2(arrayList, 6);
        if (arrayList.size() <= 2) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file initAdapter not exist files");
            m20444t2(8, 8, 8, 0, 8);
            return;
        }
        arrayList.add(new FileModel());
        C0111c1 c0111c1 = this.f14783w;
        if (c0111c1 == null) {
            C0111c1 c0111c12 = new C0111c1(this.f14776p, arrayList, this.f14771F);
            this.f14783w = c0111c12;
            c0111c12.m740R(this.f14786z);
            this.f14783w.m742T(this.f14773H);
            this.f14783w.m745W(m20436j2());
            this.f14783w.m741S(this.f14774I);
            this.f14780t.setLayoutManager(new LinearLayoutManager(this));
            this.f14780t.setAdapter(this.f14783w);
        } else {
            c0111c1.m739Q(arrayList);
            this.f14783w.m742T(this.f14773H);
            this.f14783w.m745W(m20436j2());
        }
        this.f14783w.m5213j();
    }

    /* renamed from: m2 */
    public final void m20439m2() {
        this.f14786z.setOnClickListener(this);
        this.f14774I = new ViewOnClickListenerC3279e();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.duplicate_file));
        }
    }

    /* renamed from: o2 */
    public final boolean m20440o2(int i10) {
        if (this.f14770E.size() == 1) {
            return true;
        }
        if (i10 == 0) {
            if (m20432c2(2) && m20432c2(3)) {
                return m20432c2(1) && m20432c2(4) && m20432c2(6);
            }
            return false;
        }
        if (i10 == 1) {
            return m20432c2(4) && m20432c2(6);
        }
        if (i10 != 2) {
            return i10 != 3 ? i10 != 4 ? i10 == 6 : m20432c2(6) : m20432c2(1) && m20432c2(4) && m20432c2(6);
        }
        if (m20432c2(3)) {
            return m20432c2(1) && m20432c2(4) && m20432c2(6);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.duplicate_file_delete_button) {
            m20427g2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f14773H = C0209d.m1195O(this);
        C11839m.m70688i("DuplicateFileActivity", "duplicate file onCreate mFontScale: " + this.f14773H);
        mo13327n1();
        setContentView(R$layout.duplicate_file_activity);
        this.f14776p = C0213f.m1377a();
        m20428n2();
        mo19005p1();
        m20439m2();
        this.f14785y = new C3280f(this.f14769D, true);
        C12515a.m75110o().m75172d(this.f14785y);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f14771F.clear();
        if (this.f14770E != null) {
            this.f14770E.clear();
        }
        AlertDialog alertDialog = this.f14768C;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14768C = null;
        }
        HwProgressDialog hwProgressDialog = this.f14767B;
        if (hwProgressDialog != null) {
            hwProgressDialog.dismiss();
            this.f14767B = null;
        }
        AlertDialog alertDialog2 = this.f14766A;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f14766A = null;
        }
        C3280f c3280f = this.f14785y;
        if (c3280f != null) {
            c3280f.cancel();
        }
        if (this.f14775J) {
            C9428e.m59118h().m59129k(this);
        }
    }

    /* renamed from: p2 */
    public final void m20441p2() {
        if (this.f14770E == null || this.f14770E.size() == 0) {
            C11839m.m70688i("DuplicateFileActivity", "duplicate file refreshPages not exist files");
            m20444t2(8, 8, 8, 0, 8);
        } else {
            m20444t2(0, 0, 8, 8, 0);
            m20442r2();
            m20438l2();
        }
    }

    /* renamed from: r2 */
    public final void m20442r2() {
        if (this.f14786z != null) {
            boolean z10 = this.f14771F.size() > 0;
            this.f14786z.setEnabled(z10);
            this.f14786z.setText(this.f14776p.getString(R$string.delete_has_choose_size, C11829c.m70551W(m20435i2())));
            if (z10) {
                this.f14786z.setTextColor(this.f14776p.getColor(R$color.delete_btn_color));
            } else {
                this.f14786z.setTextColor(this.f14776p.getColor(R$color.delete_btn_disable_color));
            }
        }
    }

    /* renamed from: s2 */
    public final void m20443s2(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    /* renamed from: t2 */
    public final void m20444t2(int i10, int i11, int i12, int i13, int i14) {
        m20443s2(this.f14777q, i10);
        m20443s2(this.f14779s, i11);
        m20443s2(this.f14781u, i12);
        m20443s2(this.f14782v, i13);
        m20443s2(this.f14786z, i14);
    }
}
