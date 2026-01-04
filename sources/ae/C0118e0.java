package ae;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupChangeRecordNumDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupUpGradeRecordDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p514o9.C11839m;
import p550pb.C12126b;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13467g;
import sk.C12809f;

/* renamed from: ae.e0 */
/* loaded from: classes3.dex */
public class C0118e0 extends BaseAdapter {

    /* renamed from: a */
    public Context f429a;

    /* renamed from: c */
    public LayoutInflater f431c;

    /* renamed from: d */
    public int f432d;

    /* renamed from: g */
    public int f435g;

    /* renamed from: b */
    public List<Integer> f430b = new ArrayList();

    /* renamed from: e */
    public BackupChangeRecordNumDialog f433e = null;

    /* renamed from: f */
    public BackupUpGradeRecordDialog f434f = null;

    /* renamed from: ae.e0$b */
    public static class b {

        /* renamed from: a */
        public TextView f436a;

        /* renamed from: b */
        public RadioButton f437b;

        /* renamed from: c */
        public LinearLayout f438c;

        public b() {
        }
    }

    public C0118e0(Context context, int i10) {
        this.f435g = -1;
        this.f429a = context;
        this.f431c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f435g = i10;
    }

    /* renamed from: d */
    public final boolean m771d(final int i10) {
        if (this.f432d > i10) {
            BackupChangeRecordNumDialog backupChangeRecordNumDialog = new BackupChangeRecordNumDialog(this.f429a, new DialogInterface.OnClickListener() { // from class: ae.c0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f363a.m773f(i10, dialogInterface, i11);
                }
            });
            this.f433e = backupChangeRecordNumDialog;
            backupChangeRecordNumDialog.show();
            m777j("backup_records_change_type");
            C11839m.m70686d("BackupRecordsSettingAdapter", "BackupChangeRecordNumDialog show");
            return true;
        }
        if (!C12590s0.m75850f2() || this.f432d >= i10) {
            return false;
        }
        BackupUpGradeRecordDialog backupUpGradeRecordDialog = new BackupUpGradeRecordDialog(this.f429a, new DialogInterface.OnClickListener() { // from class: ae.d0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f422a.m774g(dialogInterface, i11);
            }
        });
        this.f434f = backupUpGradeRecordDialog;
        backupUpGradeRecordDialog.show();
        m777j("backup_records_upgrade_type");
        C11839m.m70686d("BackupRecordsSettingAdapter", "BackupUpGradeRecordDialog show");
        return true;
    }

    /* renamed from: e */
    public int m772e() {
        return this.f435g;
    }

    /* renamed from: f */
    public final /* synthetic */ void m773f(int i10, DialogInterface dialogInterface, int i11) {
        if (-1 != i11) {
            m776i("backup_records_change_type", "param_cancel_click");
            dialogInterface.dismiss();
            return;
        }
        this.f432d = i10;
        this.f435g = this.f430b.get(i10).intValue();
        C13467g.m81086c().m81094i("user_number_of_backup_record", this.f435g);
        notifyDataSetChanged();
        m776i("backup_records_change_type", "param_confirm_click");
        dialogInterface.dismiss();
    }

    /* renamed from: g */
    public final /* synthetic */ void m774g(DialogInterface dialogInterface, int i10) {
        if (-1 != i10) {
            m776i("backup_records_upgrade_type", "param_cancel_click");
            dialogInterface.dismiss();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("nav_source", 16);
        C12126b.m72707c("2", bundle);
        m776i("backup_records_upgrade_type", "param_grade_click");
        dialogInterface.dismiss();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f430b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f430b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(final int i10, View view, ViewGroup viewGroup) {
        Integer num;
        View viewM76832e;
        b bVar;
        List<Integer> list = this.f430b;
        if (list == null || i10 >= list.size() || (num = this.f430b.get(i10)) == null) {
            return view;
        }
        int iIntValue = num.intValue();
        if (view == null) {
            bVar = new b();
            viewM76832e = C12809f.m76832e(this.f431c, R$layout.item_activity_backup_records);
            bVar.f436a = (TextView) C12809f.m76831d(viewM76832e, R$id.item_records_content);
            bVar.f437b = (RadioButton) C12809f.m76831d(viewM76832e, R$id.item_records_radio);
            bVar.f438c = (LinearLayout) C12809f.m76831d(viewM76832e, R$id.list_view_buttom_line);
            viewM76832e.setTag(bVar);
        } else {
            viewM76832e = view;
            bVar = (b) view.getTag();
        }
        if (this.f435g == iIntValue) {
            this.f432d = i10;
        }
        bVar.f436a.setText(this.f429a.getResources().getQuantityString(R$plurals.backup_record_page_value, iIntValue, num));
        Drawable drawable = this.f429a.getDrawable(R$drawable.backup_records_vip_icon);
        if (iIntValue > 1) {
            bVar.f436a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            bVar.f436a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (i10 == this.f430b.size() - 1) {
            bVar.f438c.setVisibility(8);
        } else {
            bVar.f438c.setVisibility(0);
        }
        viewM76832e.setOnClickListener(new View.OnClickListener() { // from class: ae.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f356a.m775h(i10, view2);
            }
        });
        bVar.f437b.setChecked(this.f435g == iIntValue);
        return viewM76832e;
    }

    /* renamed from: h */
    public final /* synthetic */ void m775h(int i10, View view) {
        if (this.f432d == i10 || m771d(i10)) {
            return;
        }
        this.f432d = i10;
        this.f435g = this.f430b.get(i10).intValue();
        C13467g.m81086c().m81094i("user_number_of_backup_record", this.f430b.get(i10).intValue());
        notifyDataSetChanged();
    }

    /* renamed from: i */
    public final void m776i(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("backup_records_type", str);
        linkedHashMapM79497A.put("backup_records_click_type", str2);
        C13225d.m79490f1().m79567R("action_code_backup_records_change_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_records_change_dialog", linkedHashMapM79497A);
    }

    /* renamed from: j */
    public final void m777j(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("backup_records_type", str);
        linkedHashMapM79497A.put("key_backup_records_dialog_show", String.valueOf(true));
        C13225d.m79490f1().m79567R("action_code_backup_records_change_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_records_change_dialog", linkedHashMapM79497A);
    }

    /* renamed from: k */
    public void m778k(List<Integer> list) {
        this.f430b.clear();
        if (list != null) {
            this.f430b.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* renamed from: l */
    public void m779l(int i10) {
        this.f435g = i10;
        notifyDataSetChanged();
    }
}
