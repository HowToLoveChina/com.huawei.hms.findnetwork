package p834z6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.hicloud.base.drive.user.model.RisksRecord;
import java.util.ArrayList;
import java.util.List;
import p336he.C10159j;
import sk.C12809f;

/* renamed from: z6.b */
/* loaded from: classes2.dex */
public class C14142b extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public Context f63230d;

    /* renamed from: e */
    public LayoutInflater f63231e;

    /* renamed from: f */
    public List<RisksRecord> f63232f = new ArrayList();

    /* renamed from: g */
    public b f63233g;

    /* renamed from: z6.b$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f63234a;

        public a(int i10) {
            this.f63234a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C14142b.this.f63233g.mo13390o0((RisksRecord) C14142b.this.f63232f.get(this.f63234a));
        }
    }

    /* renamed from: z6.b$b */
    public interface b {
        /* renamed from: o0 */
        void mo13390o0(RisksRecord risksRecord);
    }

    /* renamed from: z6.b$c */
    public static class c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63236u;

        /* renamed from: v */
        public TextView f63237v;

        /* renamed from: w */
        public TextView f63238w;

        /* renamed from: x */
        public LinearLayout f63239x;

        /* renamed from: y */
        public View f63240y;

        public c(View view) {
            super(view);
            this.f63239x = (LinearLayout) C12809f.m76831d(view, R$id.llay_item);
            this.f63236u = (TextView) C12809f.m76831d(view, R$id.tv_record_title);
            this.f63237v = (TextView) C12809f.m76831d(view, R$id.tv_record_time);
            this.f63238w = (TextView) C12809f.m76831d(view, R$id.tv_reply_desc);
            this.f63240y = C12809f.m76831d(view, R$id.record_underline);
        }
    }

    public C14142b(Context context, b bVar) {
        this.f63231e = LayoutInflater.from(context);
        this.f63230d = context;
        this.f63233g = bVar;
    }

    /* renamed from: F */
    public void m84909F(List<RisksRecord> list) {
        this.f63232f = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f63232f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        String string;
        c cVar = (c) abstractC0833c0;
        RisksRecord risksRecord = this.f63232f.get(i10);
        cVar.f63237v.setText(C10159j.m63336l(risksRecord.getCreatedTime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"));
        cVar.f63236u.setText(risksRecord.getReason());
        int state = risksRecord.getState();
        boolean zEquals = risksRecord.getType().equals(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE);
        if (state == 0) {
            string = this.f63230d.getString(R$string.appeal_not_reply);
        } else if (state == 1) {
            string = this.f63230d.getString(R$string.appeal_replyed, this.f63230d.getString(zEquals ? R$string.appeal_content_success : R$string.appeal_account_success));
        } else {
            string = state == 2 ? this.f63230d.getString(R$string.appeal_replyed, this.f63230d.getString(R$string.appeal_fail)) : "";
        }
        cVar.f63238w.setText(string);
        cVar.f63239x.setOnClickListener(new a(i10));
        cVar.f63240y.setVisibility(i10 == this.f63232f.size() - 1 ? 4 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new c(this.f63231e.inflate(R$layout.item_appeal_record, viewGroup, false));
    }
}
