package p802y8;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.huawei.android.p073ds.R$string;
import java.lang.ref.WeakReference;
import p514o9.C11841o;

/* renamed from: y8.e */
/* loaded from: classes2.dex */
public class C13921e implements TextWatcher {

    /* renamed from: a */
    public final WeakReference<Context> f62313a;

    /* renamed from: b */
    public final int f62314b;

    /* renamed from: c */
    public final TextView f62315c;

    public C13921e(Context context, int i10, TextView textView) {
        this.f62313a = new WeakReference<>(context);
        this.f62314b = i10;
        this.f62315c = textView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        Context context = this.f62313a.get();
        if (context == null) {
            return;
        }
        int length = charSequence != null ? charSequence.length() : 0;
        int i13 = this.f62314b;
        if (i13 == 1) {
            if (length > 30) {
                C11841o.m70708d(context, context.getString(R$string.wish_list_input_tips_max), 0);
            }
            C13918b.m83426D(context, this.f62315c, length, 30);
        } else if (i13 == 2) {
            if (length > 200) {
                C11841o.m70708d(context, context.getString(R$string.wish_list_input_tips_max), 0);
            }
            C13918b.m83426D(context, this.f62315c, length, 200);
        }
    }
}
