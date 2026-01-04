package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskBigFileActivity;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.hicloud.task.simple.AbstractC3015b1;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import me.C11444a;
import me.C11445b;
import p015ak.C0209d;
import p015ak.C0223k;
import p252e9.C9428e;
import p514o9.C11829c;
import p514o9.C11839m;
import p607ra.RunnableC12484f;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p771xd.HandlerC13773q;
import p783xp.C13843a;
import pa.C12123a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class LargeFileFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public View f18087a;

    /* renamed from: b */
    public TextView f18088b;

    /* renamed from: c */
    public TextView f18089c;

    /* renamed from: d */
    public TextView f18090d;

    /* renamed from: e */
    public TextView f18091e;

    /* renamed from: f */
    public ImageView f18092f;

    /* renamed from: g */
    public TextView f18093g;

    /* renamed from: h */
    public TextView f18094h;

    /* renamed from: i */
    public TextView f18095i;

    /* renamed from: j */
    public ImageView f18096j;

    /* renamed from: k */
    public HwButton f18097k;

    /* renamed from: l */
    public RelativeLayout f18098l;

    /* renamed from: m */
    public RelativeLayout f18099m;

    /* renamed from: n */
    public HwProgressBar f18100n;

    /* renamed from: p */
    public FileModel f18102p;

    /* renamed from: q */
    public FileModel f18103q;

    /* renamed from: r */
    public int f18104r;

    /* renamed from: s */
    public ImageView f18105s;

    /* renamed from: t */
    public ImageView f18106t;

    /* renamed from: u */
    public RelativeLayout f18107u;

    /* renamed from: v */
    public ImageView f18108v;

    /* renamed from: w */
    public RelativeLayout f18109w;

    /* renamed from: x */
    public C3960c f18110x;

    /* renamed from: o */
    public long f18101o = 0;

    /* renamed from: y */
    public Handler f18111y = new HandlerC3958a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.LargeFileFragment$a */
    public class HandlerC3958a extends Handler {
        public HandlerC3958a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (LargeFileFragment.this.getActivity() == null || LargeFileFragment.this.getActivity().isFinishing()) {
                C11839m.m70689w("LargeFileFragment", "isFinishing");
                return;
            }
            int i10 = message.what;
            if (1001 != i10) {
                if (1002 == i10) {
                    LargeFileFragment.this.m24150r();
                }
            } else {
                LargeFileFragment.this.m24157y();
                LargeFileFragment largeFileFragment = LargeFileFragment.this;
                largeFileFragment.m24152t(largeFileFragment.f18092f, LargeFileFragment.this.f18102p, true);
                LargeFileFragment largeFileFragment2 = LargeFileFragment.this;
                largeFileFragment2.m24152t(largeFileFragment2.f18096j, LargeFileFragment.this.f18103q, false);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.LargeFileFragment$b */
    public class C3959b extends AbstractC3015b1 {
        public C3959b() {
        }

        /* renamed from: c */
        public final void m24159c(int i10) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            LargeFileFragment.this.f18111y.sendMessage(messageObtain);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    ArrayList<FileModel> arrayListM72692h = new C12123a().m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskBigFile order by CAST(fileSize AS LONG) desc,modifyTime desc", null);
                    C11839m.m70688i("LargeFileFragment", "fileModelArrayList:" + arrayListM72692h.size());
                    LargeFileFragment.this.f18104r = arrayListM72692h.size();
                    if (arrayListM72692h.size() == 0) {
                        m24159c(1002);
                    } else {
                        LargeFileFragment.this.m24151s(arrayListM72692h);
                        m24159c(1001);
                    }
                } catch (Exception unused) {
                    m24159c(1002);
                    C11839m.m70687e("LargeFileFragment", "queryData error");
                }
                LargeFileFragment.this.m24155w();
            } catch (Throwable th2) {
                LargeFileFragment.this.m24155w();
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.LargeFileFragment$c */
    public class C3960c extends BroadcastReceiver {
        public C3960c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.huawei.hicloud.action.ACTION_SPACE_CLEAR_DATA_REFRESH".equals(new SafeIntent(intent).getAction())) {
                C11839m.m70688i("LargeFileFragment", "receive changed");
                if (LargeFileFragment.this.getActivity() == null) {
                    C11839m.m70689w("LargeFileFragment", "activity null");
                } else {
                    LargeFileFragment.this.m24153u();
                }
            }
        }

        public /* synthetic */ C3960c(LargeFileFragment largeFileFragment, HandlerC3958a handlerC3958a) {
            this();
        }
    }

    /* renamed from: m */
    public final boolean m24145m() {
        return isAdded() && getActivity() != null;
    }

    /* renamed from: n */
    public final void m24146n(boolean z10, int i10) {
        if (z10) {
            this.f18105s.setVisibility(i10);
        } else {
            this.f18106t.setVisibility(i10);
        }
    }

    /* renamed from: o */
    public final void m24147o() {
        C13225d.m79490f1().m79585f0("mecloud_clouddiskmaininterception_click_large_file_next_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmaininterception_click_large_file_next_delete", "1", "28");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("LargeFileFragment", "do not fast click");
            return;
        }
        if (view.getId() == R$id.clean_big_file_btn || view.getId() == R$id.big_file_real) {
            m24147o();
            this.f18102p = null;
            this.f18103q = null;
            getActivity().startActivity(new Intent(getActivity(), (Class<?>) CloudDiskBigFileActivity.class));
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        View view = this.f18087a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18087a);
        }
        if (C0209d.m1195O(getActivity()) >= 1.45f) {
            this.f18087a = layoutInflater.inflate(R$layout.large_file_fragment_layout_3dot2, viewGroup, false);
        } else {
            this.f18087a = layoutInflater.inflate(R$layout.large_file_fragment_layout, viewGroup, false);
        }
        m24149q();
        m24154v();
        return this.f18087a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        m24158z();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onInflate(AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(attributeSet, bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m24153u();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* renamed from: p */
    public final void m24148p() {
        this.f18108v.setVisibility(8);
        this.f18109w.setEnabled(false);
    }

    /* renamed from: q */
    public final void m24149q() {
        this.f18088b = (TextView) C12809f.m76831d(this.f18087a, R$id.large_file_total_size);
        this.f18089c = (TextView) C12809f.m76831d(this.f18087a, R$id.first_large_file_name);
        this.f18090d = (TextView) C12809f.m76831d(this.f18087a, R$id.first_large_file_path);
        this.f18091e = (TextView) C12809f.m76831d(this.f18087a, R$id.first_large_file_size);
        this.f18092f = (ImageView) C12809f.m76831d(this.f18087a, R$id.large_file_first_image);
        this.f18093g = (TextView) C12809f.m76831d(this.f18087a, R$id.second_large_file_name);
        this.f18094h = (TextView) C12809f.m76831d(this.f18087a, R$id.second_large_file_path);
        this.f18095i = (TextView) C12809f.m76831d(this.f18087a, R$id.second_large_file_size);
        this.f18096j = (ImageView) C12809f.m76831d(this.f18087a, R$id.large_file_second_image);
        HwButton hwButton = (HwButton) C12809f.m76831d(this.f18087a, R$id.clean_big_file_btn);
        this.f18097k = hwButton;
        hwButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18319a.onClick(view);
            }
        });
        this.f18098l = (RelativeLayout) C12809f.m76831d(this.f18087a, R$id.big_file_first);
        this.f18099m = (RelativeLayout) C12809f.m76831d(this.f18087a, R$id.big_file_second);
        this.f18100n = (HwProgressBar) C12809f.m76831d(this.f18087a, R$id.total_size_progressbar);
        this.f18105s = (ImageView) C12809f.m76831d(this.f18087a, R$id.large_file_first_video_image);
        this.f18106t = (ImageView) C12809f.m76831d(this.f18087a, R$id.large_file_second_video_image);
        this.f18107u = (RelativeLayout) C12809f.m76831d(this.f18087a, R$id.large_file_btn);
        this.f18108v = (ImageView) C12809f.m76831d(this.f18087a, R$id.hicloud_item_right_arrow);
        this.f18109w = (RelativeLayout) C12809f.m76831d(this.f18087a, R$id.big_file_real);
    }

    /* renamed from: r */
    public final void m24150r() {
        C11839m.m70688i("LargeFileFragment", "noDataShowView");
        this.f18107u.setVisibility(8);
        this.f18098l.setVisibility(8);
        this.f18099m.setVisibility(8);
        this.f18088b.setText(C0223k.m1524g(getActivity(), 0L));
        m24148p();
    }

    /* renamed from: s */
    public final void m24151s(ArrayList<FileModel> arrayList) {
        this.f18101o = 0L;
        this.f18102p = null;
        this.f18103q = null;
        Iterator<FileModel> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f18101o = it.next().getFileSize() + this.f18101o;
        }
        if (arrayList.size() <= 1) {
            this.f18102p = arrayList.get(0);
        } else {
            this.f18102p = arrayList.get(0);
            this.f18103q = arrayList.get(1);
        }
        if (this.f18102p != null && m24145m()) {
            this.f18102p.setCloudPath(C9428e.m59118h().m59127i(TextUtils.isEmpty(this.f18102p.getFileParentName()) ? getActivity().getResources().getString(R$string.hidisk_my_drive) : this.f18102p.getFileParentName()));
        }
        if (this.f18103q == null || !m24145m()) {
            return;
        }
        this.f18103q.setCloudPath(C9428e.m59118h().m59127i(TextUtils.isEmpty(this.f18103q.getFileParentName()) ? getActivity().getResources().getString(R$string.hidisk_my_drive) : this.f18103q.getFileParentName()));
    }

    /* renamed from: t */
    public final void m24152t(ImageView imageView, FileModel fileModel, boolean z10) {
        if (imageView == null || fileModel == null) {
            m24146n(z10, 8);
            C11839m.m70689w("LargeFileFragment", "item or imageview is null");
            return;
        }
        int fileCategory = fileModel.getFileCategory();
        imageView.setVisibility(0);
        if (fileCategory == 2) {
            m24146n(z10, 0);
        } else {
            m24146n(z10, 8);
        }
        if (!C11445b.m68564a(fileCategory)) {
            RoundRectImageView.setNoBorderScaleDefault(imageView, getActivity().getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
            return;
        }
        Bitmap bitmapM68559c = C11444a.m68559c(fileModel.getThumbnailPath());
        if (bitmapM68559c != null) {
            RoundRectImageView.setBorderImageViewByBitmap(imageView, bitmapM68559c);
            if (fileCategory == 2) {
                m24146n(z10, 0);
                return;
            }
            return;
        }
        m24146n(z10, 8);
        String fileName = fileModel.getFileName();
        imageView.setTag(fileModel.getFileId());
        RoundRectImageView.setNoBorderScaleDefault(imageView, getActivity().getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
        C11829c.m70601o(new RunnableC12484f(fileModel, new HandlerC13773q(imageView, fileModel.getFileId(), fileName, z10 ? this.f18105s : this.f18106t, fileCategory), 0));
    }

    /* renamed from: u */
    public final void m24153u() {
        C11839m.m70688i("LargeFileFragment", "queryData");
        C12515a.m75110o().m75172d(new C3959b());
    }

    /* renamed from: v */
    public final void m24154v() {
        Activity activity = getActivity();
        if (activity == null) {
            C11839m.m70689w("LargeFileFragment", "registerReceiver activity null");
        } else if (this.f18110x == null) {
            this.f18110x = new C3960c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.action.ACTION_SPACE_CLEAR_DATA_REFRESH");
            C13108a.m78878b(activity).m78880c(this.f18110x, intentFilter);
        }
    }

    /* renamed from: w */
    public final void m24155w() {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("cloudspace_large_file_num", Integer.valueOf(this.f18104r));
        linkedHashMapM79499C.put("cloudspace_large_file_size", Long.valueOf(this.f18101o));
        C13225d.m79490f1().m79567R("ENTER_LARGE_FILE", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "ENTER_LARGE_FILE", linkedHashMapM79499C);
    }

    /* renamed from: x */
    public final void m24156x() {
        this.f18108v.setVisibility(0);
        this.f18109w.setEnabled(true);
        this.f18109w.setOnClickListener(this);
    }

    /* renamed from: y */
    public final void m24157y() {
        C11839m.m70688i("LargeFileFragment", "showView");
        if (this.f18102p == null) {
            m24150r();
            return;
        }
        m24156x();
        this.f18107u.setVisibility(0);
        this.f18098l.setVisibility(0);
        if (m24145m()) {
            String strM83086h = C13843a.m83086h(getActivity(), this.f18101o);
            TextView textView = this.f18088b;
            Resources resources = getResources();
            int i10 = R$plurals.backup_backing_state;
            int i11 = this.f18104r;
            textView.setText(resources.getQuantityString(i10, i11, Integer.valueOf(i11), strM83086h));
        }
        this.f18089c.setText(this.f18102p.getFileName());
        this.f18090d.setText(this.f18102p.getCloudPath());
        if (TextUtils.isEmpty(this.f18102p.getCloudPath())) {
            this.f18090d.setVisibility(8);
        }
        if (m24145m()) {
            this.f18091e.setText(C13843a.m83086h(getActivity(), this.f18102p.getFileSize()));
        }
        if (this.f18103q == null) {
            this.f18099m.setVisibility(8);
            return;
        }
        this.f18099m.setVisibility(0);
        this.f18093g.setText(this.f18103q.getFileName());
        this.f18094h.setText(this.f18103q.getCloudPath());
        if (TextUtils.isEmpty(this.f18103q.getCloudPath())) {
            this.f18094h.setVisibility(8);
        }
        if (m24145m()) {
            this.f18095i.setText(C13843a.m83086h(getActivity(), this.f18103q.getFileSize()));
        }
    }

    /* renamed from: z */
    public final void m24158z() {
        Activity activity = getActivity();
        if (activity == null) {
            C11839m.m70689w("LargeFileFragment", "unregisterReceiver activity null");
        } else if (this.f18110x != null) {
            C13108a.m78878b(activity).m78883f(this.f18110x);
            this.f18110x = null;
        }
    }
}
