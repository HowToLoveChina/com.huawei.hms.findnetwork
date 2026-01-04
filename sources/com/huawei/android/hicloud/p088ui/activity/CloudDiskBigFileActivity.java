package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.BigFileListViewAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import dj.C9159b;
import huawei.android.app.HwProgressDialog;
import huawei.android.widget.ListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0209d;
import p252e9.C9428e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p581qk.AbstractC12368e;
import p610rd.C12488a;
import p616rk.C12515a;
import pa.C12123a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudDiskBigFileActivity extends UIActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /* renamed from: A */
    public AlertDialog f14187A;

    /* renamed from: B */
    public HwProgressDialog f14188B;

    /* renamed from: C */
    public AlertDialog f14189C;

    /* renamed from: D */
    public C3208h f14190D;

    /* renamed from: E */
    public float f14191E;

    /* renamed from: F */
    public Handler f14192F = new HandlerC3201a();

    /* renamed from: G */
    public Handler f14193G;

    /* renamed from: H */
    public boolean f14194H;

    /* renamed from: I */
    public C3202b f14195I;

    /* renamed from: p */
    public View f14196p;

    /* renamed from: q */
    public View f14197q;

    /* renamed from: r */
    public View f14198r;

    /* renamed from: s */
    public View f14199s;

    /* renamed from: t */
    public AutoSizeButton f14200t;

    /* renamed from: u */
    public CheckBox f14201u;

    /* renamed from: v */
    public TextView f14202v;

    /* renamed from: w */
    public ListView f14203w;

    /* renamed from: x */
    public TextView f14204x;

    /* renamed from: y */
    public ProgressBar f14205y;

    /* renamed from: z */
    public BigFileListViewAdapter f14206z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$a */
    public class HandlerC3201a extends Handler {
        public HandlerC3201a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("CloudDiskBigFileActivity", "handleMessage " + message.what);
            int i10 = message.what;
            if (i10 == 0) {
                CloudDiskBigFileActivity.this.m19673m2();
                return;
            }
            if (i10 == 1) {
                removeMessages(0);
                CloudDiskBigFileActivity.this.m19667g2(message);
            } else {
                if (i10 != 2 || CloudDiskBigFileActivity.this.f14206z == null) {
                    return;
                }
                CloudDiskBigFileActivity.this.f14206z.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$b */
    public class C3202b implements CloudDiskFileDeleteTask.Callback {

        /* renamed from: a */
        public Handler f14208a;

        public C3202b(Handler handler) {
            this.f14208a = handler;
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask.Callback
        /* renamed from: a */
        public void mo15806a() {
            C11839m.m70688i("CloudDiskBigFileActivity", "BigFileDelete dealTaskStart");
            CloudDiskBigFileActivity.this.m19669i2(this.f14208a, 11, null, false);
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask.Callback
        /* renamed from: b */
        public void mo15807b(int i10) {
            C11839m.m70688i("CloudDiskBigFileActivity", "BigFileDelete dealTaskEnd");
            CloudDiskBigFileActivity.this.f14194H = true;
            CloudDiskBigFileActivity.this.m19669i2(this.f14208a, 12, Integer.valueOf(i10), false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$c */
    public class C3203c extends C12488a {

        /* renamed from: d */
        public WeakReference<Handler> f14210d;

        public C3203c(Handler handler, List<FileModel> list, int i10) {
            super(list, i10);
            this.f14210d = new WeakReference<>(handler);
        }

        @Override // p610rd.C12488a
        /* renamed from: c */
        public void mo19674c() {
            super.mo19674c();
            WeakReference<Handler> weakReference = this.f14210d;
            if (weakReference == null) {
                C11839m.m70688i("CloudDiskBigFileActivity", "queryAfterRefershUI handler is null");
            } else {
                CloudDiskBigFileActivity.this.m19669i2(weakReference.get(), 2, null, false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$d */
    public class C3204d implements BigFileListViewAdapter.CheckBoxCallback {
        public C3204d() {
        }

        @Override // com.huawei.android.hicloud.ui.uiadapter.BigFileListViewAdapter.CheckBoxCallback
        /* renamed from: a */
        public void mo19675a() {
            CloudDiskBigFileActivity.this.f14201u.setChecked(CloudDiskBigFileActivity.this.f14206z.m24848h());
            CloudDiskBigFileActivity.this.m19670j2();
        }

        public /* synthetic */ C3204d(CloudDiskBigFileActivity cloudDiskBigFileActivity, HandlerC3201a handlerC3201a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$e */
    public static class C3205e {

        /* renamed from: a */
        public long f14213a;

        /* renamed from: b */
        public CopyOnWriteArrayList<FileModel> f14214b;

        public C3205e(long j10, CopyOnWriteArrayList<FileModel> copyOnWriteArrayList) {
            this.f14213a = j10;
            this.f14214b = copyOnWriteArrayList;
        }

        /* renamed from: a */
        public CopyOnWriteArrayList<FileModel> m19676a() {
            return this.f14214b;
        }

        /* renamed from: b */
        public long m19677b() {
            return this.f14213a;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$f */
    public class DialogInterfaceOnClickListenerC3206f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public Context f14215a;

        /* renamed from: b */
        public List<FileModel> f14216b;

        /* renamed from: c */
        public CheckBox f14217c;

        public DialogInterfaceOnClickListenerC3206f(Context context, List<FileModel> list, CheckBox checkBox) {
            this.f14215a = context;
            this.f14216b = list;
            this.f14217c = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f14215a == null) {
                C11839m.m70688i("CloudDiskBigFileActivity", "deleteCloudFileListener context is null.");
            } else {
                CheckBox checkBox = this.f14217c;
                C9428e.m59118h().m59125f(this.f14216b, CloudDiskBigFileActivity.this.f14195I, checkBox != null ? checkBox.isChecked() : false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$g */
    public class HandlerC3207g extends Handler {

        /* renamed from: a */
        public Context f14219a;

        public HandlerC3207g(Context context) {
            this.f14219a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Integer num;
            int iIntValue;
            C11839m.m70688i("CloudDiskBigFileActivity", "handleMessage " + message.what);
            int i10 = message.what;
            if (i10 == 11) {
                CloudDiskBigFileActivity cloudDiskBigFileActivity = CloudDiskBigFileActivity.this;
                cloudDiskBigFileActivity.f14188B = cloudDiskBigFileActivity.m19662a2(this.f14219a);
                if (CloudDiskBigFileActivity.this.f14188B != null) {
                    CloudDiskBigFileActivity.this.f14188B.show();
                    return;
                }
                return;
            }
            if (i10 == 12) {
                removeMessages(0);
                if (CloudDiskBigFileActivity.this.f14188B != null) {
                    CloudDiskBigFileActivity.this.f14188B.dismiss();
                }
                Object obj = message.obj;
                if ((obj instanceof Integer) && (iIntValue = (num = (Integer) obj).intValue()) > 0) {
                    Context context = this.f14219a;
                    C11841o.m70708d(context, context.getResources().getQuantityString(R$plurals.file_delete_fail, iIntValue, num), 0);
                }
                CloudDiskBigFileActivity cloudDiskBigFileActivity2 = CloudDiskBigFileActivity.this;
                cloudDiskBigFileActivity2.f14190D = cloudDiskBigFileActivity2.new C3208h(cloudDiskBigFileActivity2.f14192F);
                C12515a.m75110o().m75172d(CloudDiskBigFileActivity.this.f14190D);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$h */
    public class C3208h extends AbstractC12368e {

        /* renamed from: a */
        public Handler f14221a;

        public C3208h(Handler handler) {
            this.f14221a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            C3205e c3205e = null;
            try {
                try {
                    C11839m.m70688i("CloudDiskBigFileActivity", "LoadBigFileDataTask start.");
                    CloudDiskBigFileActivity.this.m19669i2(this.f14221a, 0, null, true);
                    ArrayList<FileModel> arrayListM72692h = new C12123a().m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskBigFile order by CAST(fileSize AS LONG) desc,modifyTime desc", null);
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    ArrayList arrayList = new ArrayList();
                    Iterator<FileModel> it = arrayListM72692h.iterator();
                    long fileSize = 0;
                    while (it.hasNext()) {
                        FileModel next = it.next();
                        next.setFileSize(FileUtil.m16355e(next.getFileSize(), true));
                        fileSize += next.getFileSize();
                        if (TextUtils.isEmpty(next.getFileParentName())) {
                            arrayList.add(next);
                            next.setCloudPath(CloudDiskBigFileActivity.this.getResources().getString(R$string.hidisk_my_drive));
                        }
                        next.setCloudPath(C9428e.m59118h().m59127i(next.getFileParentName()));
                        copyOnWriteArrayList.add(next);
                    }
                    C11839m.m70688i("CloudDiskBigFileActivity", "LoadBigFileDataTask query result: ." + copyOnWriteArrayList.size());
                    C3205e c3205e2 = new C3205e(fileSize, copyOnWriteArrayList);
                    try {
                        if (!arrayList.isEmpty()) {
                            C12515a.m75110o().m75172d(CloudDiskBigFileActivity.this.new C3203c(this.f14221a, arrayList, 0));
                        }
                        C11839m.m70688i("CloudDiskBigFileActivity", "LoadBigFileDataTask end.");
                        CloudDiskBigFileActivity.this.m19669i2(this.f14221a, 1, c3205e2, false);
                    } catch (Exception e10) {
                        e = e10;
                        c3205e = c3205e2;
                        C11839m.m70687e("CloudDiskBigFileActivity", "LoadBigFileDataTask error: " + e.toString());
                        CloudDiskBigFileActivity.this.m19669i2(this.f14221a, 1, c3205e, false);
                    } catch (Throwable th2) {
                        th = th2;
                        c3205e = c3205e2;
                        CloudDiskBigFileActivity.this.m19669i2(this.f14221a, 1, c3205e, false);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$i */
    public class ViewOnClickListenerC3209i implements View.OnClickListener {

        /* renamed from: a */
        public Context f14223a;

        /* renamed from: b */
        public String f14224b;

        public ViewOnClickListenerC3209i(Context context, String str) {
            this.f14223a = context;
            this.f14224b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14223a == null) {
                C11839m.m70688i("CloudDiskBigFileActivity", "openCloudDirListener context is null.");
                return;
            }
            if (TextUtils.isEmpty(this.f14224b)) {
                C11839m.m70688i("CloudDiskBigFileActivity", "openCloudDirListener parentFileId is null.");
                return;
            }
            AlertDialog alertDialog = CloudDiskBigFileActivity.this.f14189C;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_COMPATIBLE_NEW");
            C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            C9159b.m57571j(intent);
            intent.putExtra("cloud_disk_file_id", this.f14224b);
            intent.putExtra("from_to", 6);
            intent.putExtra("not_exist_to_disk_root", true);
            try {
                this.f14223a.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("CloudDiskBigFileActivity", "openCloudDirListener error: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudDiskBigFileActivity$j */
    public class DialogInterfaceOnClickListenerC3210j implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public Context f14226a;

        /* renamed from: b */
        public String f14227b;

        public DialogInterfaceOnClickListenerC3210j(Context context, String str) {
            this.f14226a = context;
            this.f14227b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f14226a == null) {
                C11839m.m70688i("CloudDiskBigFileActivity", "viewCloudFileListener context is null.");
            } else if (TextUtils.isEmpty(this.f14227b)) {
                C11839m.m70688i("CloudDiskBigFileActivity", "viewCloudFileListener fileId is null.");
            } else {
                dialogInterface.dismiss();
                CloudDiskBigFileActivity.this.m19666e2(this.f14226a, this.f14227b);
            }
        }
    }

    public CloudDiskBigFileActivity() {
        HandlerC3207g handlerC3207g = new HandlerC3207g(this);
        this.f14193G = handlerC3207g;
        this.f14194H = false;
        this.f14195I = new C3202b(handlerC3207g);
    }

    /* renamed from: f2 */
    private void m19660f2() {
        this.f14196p = C12809f.m76829b(this, R$id.big_file_view);
        this.f14197q = C12809f.m76829b(this, R$id.big_file_main_view);
        this.f14198r = C12809f.m76829b(this, R$id.big_file_info_view_normal);
        this.f14199s = C12809f.m76829b(this, R$id.big_file_info_view_3_dot_2);
        if (this.f14191E >= 1.45f) {
            this.f14198r.setVisibility(8);
            this.f14199s.setVisibility(0);
            this.f14201u = (CheckBox) C12809f.m76829b(this, R$id.big_file_select_all_3_dot_2);
            this.f14202v = (TextView) C12809f.m76829b(this, R$id.big_file_size_3_dot_2);
        } else {
            this.f14198r.setVisibility(0);
            this.f14199s.setVisibility(8);
            this.f14201u = (CheckBox) C12809f.m76829b(this, R$id.big_file_select_all);
            this.f14202v = (TextView) C12809f.m76829b(this, R$id.big_file_size);
        }
        this.f14200t = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_big_file_button);
        this.f14203w = C12809f.m76829b(this, R$id.big_file_list);
        this.f14204x = (TextView) C12809f.m76829b(this, R$id.big_file_error);
        this.f14205y = (ProgressBar) C12809f.m76829b(this, R$id.big_file_loading);
        this.f14201u.setOnClickListener(this);
        BigFileListViewAdapter bigFileListViewAdapter = new BigFileListViewAdapter(this, new C3204d(this, null));
        this.f14206z = bigFileListViewAdapter;
        this.f14203w.setAdapter(bigFileListViewAdapter);
        this.f14203w.setOnItemClickListener(this);
        this.f14203w.setOnItemLongClickListener(this);
        this.f14200t.setOnClickListener(this);
        m19673m2();
    }

    /* renamed from: Z1 */
    public final AlertDialog m19661Z1(Context context, List<FileModel> list, int i10) {
        if (context == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "createDeleteDialog context is null.");
            return null;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "showDeleteDialog resource is null.");
            return null;
        }
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), R$layout.cloud_disk_file_delete_dialog);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.delete_file_tip);
        CheckBox checkBox = (CheckBox) C12809f.m76831d(viewM76832e, R$id.delete_choose);
        textView.setText(resources.getQuantityString(R$plurals.file_delete_tip, 30, 30));
        return new AlertDialog.Builder(context).setTitle(resources.getQuantityString(R$plurals.file_delete_title, i10, Integer.valueOf(i10))).setPositiveButton(R$string.delete, new DialogInterfaceOnClickListenerC3206f(context, list, checkBox)).setNegativeButton(R$string.cancel, (DialogInterface.OnClickListener) null).setView(viewM76832e).create();
    }

    /* renamed from: a2 */
    public final HwProgressDialog m19662a2(Context context) {
        if (context == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "createDeleteProgress context is null.");
            return null;
        }
        HwProgressDialog hwProgressDialog = new HwProgressDialog(context);
        hwProgressDialog.setMessage(context.getString(R$string.hicloud_notepad_deleting));
        hwProgressDialog.setCanceledOnTouchOutside(false);
        hwProgressDialog.setCancelable(true);
        return hwProgressDialog;
    }

    /* renamed from: b2 */
    public final AlertDialog m19663b2(Context context, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2, FileModel fileModel) {
        if (context == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "createDetailDialog context is null.");
            return null;
        }
        if (fileModel == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "createDetailDialog item is null.");
            return null;
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        View viewM76832e = this.f14191E >= 1.75f ? C12809f.m76832e(layoutInflater, R$layout.cloud_disk_file_detail_dialog_1dot75) : C12809f.m76832e(layoutInflater, R$layout.cloud_disk_file_detail_dialog);
        TextView textView = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_name);
        TextView textView2 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_size);
        TextView textView3 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_modify_time);
        TextView textView4 = (TextView) C12809f.m76831d(viewM76832e, R$id.detail_file_parent_path);
        textView.setText(fileModel.getFileName());
        textView4.setText(TextUtils.isEmpty(fileModel.getCloudPath()) ? context.getResources().getString(R$string.hidisk_my_drive) : fileModel.getCloudPath());
        textView3.setText(C11829c.m70535O(fileModel.getModifyTime()));
        textView2.setText(C11829c.m70551W(fileModel.getFileSize()));
        AlertDialog alertDialogCreate = UIActivity.m22363s1(context) ? new AlertDialog.Builder(context).setTitle(R$string.file_detail).setPositiveButton(R$string.lookat, onClickListener).setNegativeButton(R$string.cancel, (DialogInterface.OnClickListener) null).setView(viewM76832e).create() : new AlertDialog.Builder(context).setTitle(R$string.file_detail).setPositiveButton(R$string.phonefinder_dialog_know, (DialogInterface.OnClickListener) null).setView(viewM76832e).create();
        textView4.setOnClickListener(onClickListener2);
        return alertDialogCreate;
    }

    /* renamed from: c2 */
    public final void m19664c2() {
        if (C0209d.m1226Y0()) {
            C11839m.m70686d("CloudDiskBigFileActivity", "dealFileDeleteClick isFast");
            return;
        }
        if (!C0209d.m1208S0(this)) {
            C11839m.m70688i("CloudDiskBigFileActivity", "dealFileDeleteClick network not connected!");
            C11841o.m70708d(this, getString(R$string.gallery_no_network_tips), 0);
            return;
        }
        BigFileListViewAdapter bigFileListViewAdapter = this.f14206z;
        AlertDialog alertDialogM19661Z1 = m19661Z1(this, this.f14206z.m24846f(), bigFileListViewAdapter != null ? bigFileListViewAdapter.m24845e() : 0);
        this.f14187A = alertDialogM19661Z1;
        if (alertDialogM19661Z1 != null) {
            alertDialogM19661Z1.show();
            this.f14187A.getButton(-1).setTextColor(getColor(R$color.red));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14196p);
        arrayList.add(this.f14197q);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m19665d2(FileModel fileModel) {
        if (fileModel == null) {
            C11839m.m70686d("CloudDiskBigFileActivity", "dealFileDetailClick item is null");
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70686d("CloudDiskBigFileActivity", "dealFileDetailClick isFast");
            return;
        }
        AlertDialog alertDialogM19663b2 = m19663b2(this, new DialogInterfaceOnClickListenerC3210j(this, fileModel.getFileId()), new ViewOnClickListenerC3209i(this, fileModel.getFileParent()), fileModel);
        this.f14189C = alertDialogM19663b2;
        if (alertDialogM19663b2 != null) {
            alertDialogM19663b2.show();
            Button button = this.f14189C.getButton(-1);
            if (button != null) {
                button.setTextColor(getColor(R$color.file_detail_path_color));
            }
            Button button2 = this.f14189C.getButton(-2);
            if (button2 != null) {
                button2.setTextColor(getColor(R$color.file_detail_path_color));
            }
        }
    }

    /* renamed from: e2 */
    public void m19666e2(Context context, String str) {
        if (C4633d0.m28404a(str)) {
            C11839m.m70687e("CloudDiskBigFileActivity", "fileId =" + str);
        }
        if (!UIActivity.m22363s1(context)) {
            C11839m.m70687e("CloudDiskBigFileActivity", "is not Has FileViewer");
            m22375i1(this, 9);
            return;
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        intent.setAction("com.huawei.hidisk.action.EXTERNAL_FILE_VIEWER");
        intent.putExtra("fileId", str);
        intent.putExtra("from_to", 6);
        intent.putExtra("type", "key_file_view_from_space_clean");
        intent.putExtra("not_exist_to_disk_root", true);
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDiskBigFileActivity", "gotoFileViewer is failed =" + e10.getMessage());
            m22375i1(this, 9);
        }
    }

    /* renamed from: g2 */
    public final void m19667g2(Message message) {
        if (message == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "refreshQueryResult msg is null.");
            return;
        }
        Object obj = message.obj;
        if (!(obj instanceof C3205e)) {
            C11839m.m70688i("CloudDiskBigFileActivity", "refreshQueryResult result is null.");
            m19672l2(R$string.big_file_no_file, R$drawable.hidisk_no_file);
            return;
        }
        C3205e c3205e = (C3205e) obj;
        CopyOnWriteArrayList<FileModel> copyOnWriteArrayListM19676a = c3205e.m19676a();
        long jM19677b = c3205e.m19677b();
        C11839m.m70688i("CloudDiskBigFileActivity", "refreshQueryResult totalSize： " + jM19677b);
        if (copyOnWriteArrayListM19676a.size() == 0) {
            m19672l2(R$string.big_file_no_file, R$drawable.hidisk_no_file);
        } else {
            m19671k2(copyOnWriteArrayListM19676a, jM19677b);
        }
    }

    /* renamed from: h2 */
    public final void m19668h2() {
        BigFileListViewAdapter bigFileListViewAdapter = this.f14206z;
        if (bigFileListViewAdapter == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "selectAllClick adapter is null.");
        } else {
            bigFileListViewAdapter.m24856p(this.f14201u.isChecked());
            m19670j2();
        }
    }

    /* renamed from: i2 */
    public final void m19669i2(Handler handler, int i10, Object obj, boolean z10) {
        if (handler == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "sendMessage handler is null.");
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

    /* renamed from: j2 */
    public final void m19670j2() {
        if (this.f14200t == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "setDeletButton button is null.");
            return;
        }
        BigFileListViewAdapter bigFileListViewAdapter = this.f14206z;
        if (bigFileListViewAdapter == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "setDeletButton adapter is null.");
            return;
        }
        boolean zM24849i = bigFileListViewAdapter.m24849i();
        this.f14200t.setEnabled(zM24849i);
        this.f14200t.setText(getString(R$string.delete_has_choose_size, C11829c.m70551W(this.f14206z.m24847g())));
        if (zM24849i) {
            this.f14200t.setTextColor(getColor(R$color.delete_btn_color));
        } else {
            this.f14200t.setTextColor(getColor(R$color.delete_btn_disable_color));
        }
    }

    /* renamed from: k2 */
    public final void m19671k2(CopyOnWriteArrayList<FileModel> copyOnWriteArrayList, long j10) {
        View view = this.f14197q;
        if (view != null) {
            view.setVisibility(0);
        }
        AutoSizeButton autoSizeButton = this.f14200t;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(0);
        }
        TextView textView = this.f14204x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ProgressBar progressBar = this.f14205y;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        CheckBox checkBox = this.f14201u;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        this.f14206z.m24858r(copyOnWriteArrayList);
        this.f14202v.setText(C11829c.m70551W(j10));
        this.f14206z.m24859s(j10);
        this.f14206z.notifyDataSetChanged();
        m19670j2();
    }

    /* renamed from: l2 */
    public final void m19672l2(int i10, int i11) {
        View view = this.f14197q;
        if (view != null) {
            view.setVisibility(8);
        }
        AutoSizeButton autoSizeButton = this.f14200t;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        TextView textView = this.f14204x;
        if (textView != null) {
            textView.setVisibility(0);
            this.f14204x.setText(i10);
            this.f14204x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i11), (Drawable) null, (Drawable) null);
        }
        ProgressBar progressBar = this.f14205y;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* renamed from: m2 */
    public final void m19673m2() {
        View view = this.f14197q;
        if (view != null) {
            view.setVisibility(8);
        }
        AutoSizeButton autoSizeButton = this.f14200t;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        TextView textView = this.f14204x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ProgressBar progressBar = this.f14205y;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.big_file_actionbar));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.big_file_select_all || id2 == R$id.big_file_select_all_3_dot_2) {
            m19668h2();
        } else if (id2 == R$id.delete_big_file_button) {
            m19664c2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        mo13327n1();
        setContentView(R$layout.activity_cloud_disk_big_file);
        this.f14191E = C0209d.m1195O(this);
        m19660f2();
        mo19005p1();
        this.f14190D = new C3208h(this.f14192F);
        C12515a.m75110o().m75172d(this.f14190D);
        if (C9428e.m59118h().m59128j()) {
            m19669i2(this.f14193G, 11, null, false);
            C9428e.m59118h().m59133p(new C3202b(this.f14193G));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f14189C;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14189C = null;
        }
        HwProgressDialog hwProgressDialog = this.f14188B;
        if (hwProgressDialog != null) {
            hwProgressDialog.dismiss();
            this.f14188B = null;
        }
        AlertDialog alertDialog2 = this.f14187A;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f14187A = null;
        }
        C3208h c3208h = this.f14190D;
        if (c3208h != null) {
            c3208h.cancel();
        }
        if (this.f14194H) {
            C9428e.m59118h().m59129k(this);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        BigFileListViewAdapter bigFileListViewAdapter = this.f14206z;
        if (bigFileListViewAdapter == null) {
            C11839m.m70688i("CloudDiskBigFileActivity", "onItemClick adapter is null.");
        } else {
            m19665d2(bigFileListViewAdapter.getItem(i10));
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }
}
