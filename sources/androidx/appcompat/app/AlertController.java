package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A */
    public NestedScrollView f1146A;

    /* renamed from: C */
    public Drawable f1148C;

    /* renamed from: D */
    public ImageView f1149D;

    /* renamed from: E */
    public TextView f1150E;

    /* renamed from: F */
    public TextView f1151F;

    /* renamed from: G */
    public View f1152G;

    /* renamed from: H */
    public ListAdapter f1153H;

    /* renamed from: J */
    public int f1155J;

    /* renamed from: K */
    public int f1156K;

    /* renamed from: L */
    public int f1157L;

    /* renamed from: M */
    public int f1158M;

    /* renamed from: N */
    public int f1159N;

    /* renamed from: O */
    public int f1160O;

    /* renamed from: P */
    public boolean f1161P;

    /* renamed from: R */
    public Handler f1163R;

    /* renamed from: a */
    public final Context f1165a;

    /* renamed from: b */
    public final AppCompatDialog f1166b;

    /* renamed from: c */
    public final Window f1167c;

    /* renamed from: d */
    public final int f1168d;

    /* renamed from: e */
    public CharSequence f1169e;

    /* renamed from: f */
    public CharSequence f1170f;

    /* renamed from: g */
    public ListView f1171g;

    /* renamed from: h */
    public View f1172h;

    /* renamed from: i */
    public int f1173i;

    /* renamed from: j */
    public int f1174j;

    /* renamed from: k */
    public int f1175k;

    /* renamed from: l */
    public int f1176l;

    /* renamed from: m */
    public int f1177m;

    /* renamed from: o */
    public Button f1179o;

    /* renamed from: p */
    public CharSequence f1180p;

    /* renamed from: q */
    public Message f1181q;

    /* renamed from: r */
    public Drawable f1182r;

    /* renamed from: s */
    public Button f1183s;

    /* renamed from: t */
    public CharSequence f1184t;

    /* renamed from: u */
    public Message f1185u;

    /* renamed from: v */
    public Drawable f1186v;

    /* renamed from: w */
    public Button f1187w;

    /* renamed from: x */
    public CharSequence f1188x;

    /* renamed from: y */
    public Message f1189y;

    /* renamed from: z */
    public Drawable f1190z;

    /* renamed from: n */
    public boolean f1178n = false;

    /* renamed from: B */
    public int f1147B = 0;

    /* renamed from: I */
    public int f1154I = -1;

    /* renamed from: Q */
    public int f1162Q = 0;

    /* renamed from: S */
    public final View.OnClickListener f1164S = new ViewOnClickListenerC0351a();

    public static class AlertParams {

        /* renamed from: A */
        public int f1191A;

        /* renamed from: B */
        public int f1192B;

        /* renamed from: C */
        public int f1193C;

        /* renamed from: D */
        public int f1194D;

        /* renamed from: F */
        public boolean[] f1196F;

        /* renamed from: G */
        public boolean f1197G;

        /* renamed from: H */
        public boolean f1198H;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f1200J;

        /* renamed from: K */
        public Cursor f1201K;

        /* renamed from: L */
        public String f1202L;

        /* renamed from: M */
        public String f1203M;

        /* renamed from: N */
        public AdapterView.OnItemSelectedListener f1204N;

        /* renamed from: a */
        public final Context f1206a;

        /* renamed from: b */
        public final LayoutInflater f1207b;

        /* renamed from: d */
        public Drawable f1209d;

        /* renamed from: f */
        public CharSequence f1211f;

        /* renamed from: g */
        public View f1212g;

        /* renamed from: h */
        public CharSequence f1213h;

        /* renamed from: i */
        public CharSequence f1214i;

        /* renamed from: j */
        public Drawable f1215j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f1216k;

        /* renamed from: l */
        public CharSequence f1217l;

        /* renamed from: m */
        public Drawable f1218m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f1219n;

        /* renamed from: o */
        public CharSequence f1220o;

        /* renamed from: p */
        public Drawable f1221p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f1222q;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f1224s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f1225t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f1226u;

        /* renamed from: v */
        public CharSequence[] f1227v;

        /* renamed from: w */
        public ListAdapter f1228w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f1229x;

        /* renamed from: y */
        public int f1230y;

        /* renamed from: z */
        public View f1231z;

        /* renamed from: c */
        public int f1208c = 0;

        /* renamed from: e */
        public int f1210e = 0;

        /* renamed from: E */
        public boolean f1195E = false;

        /* renamed from: I */
        public int f1199I = -1;

        /* renamed from: O */
        public boolean f1205O = true;

        /* renamed from: r */
        public boolean f1223r = true;

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$a */
        public class C0347a extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            public final /* synthetic */ RecycleListView f1232a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0347a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f1232a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = AlertParams.this.f1196F;
                if (zArr != null && zArr[i10]) {
                    this.f1232a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$b */
        public class C0348b extends CursorAdapter {

            /* renamed from: a */
            public final int f1234a;

            /* renamed from: b */
            public final int f1235b;

            /* renamed from: c */
            public final /* synthetic */ RecycleListView f1236c;

            /* renamed from: d */
            public final /* synthetic */ AlertController f1237d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0348b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f1236c = recycleListView;
                this.f1237d = alertController;
                Cursor cursor2 = getCursor();
                this.f1234a = cursor2.getColumnIndexOrThrow(AlertParams.this.f1202L);
                this.f1235b = cursor2.getColumnIndexOrThrow(AlertParams.this.f1203M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f1234a));
                this.f1236c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1235b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.f1207b.inflate(this.f1237d.f1158M, viewGroup, false);
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$c */
        public class C0349c implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ AlertController f1239a;

            public C0349c(AlertController alertController) {
                this.f1239a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AlertParams.this.f1229x.onClick(this.f1239a.f1166b, i10);
                if (AlertParams.this.f1198H) {
                    return;
                }
                this.f1239a.f1166b.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$d */
        public class C0350d implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ RecycleListView f1241a;

            /* renamed from: b */
            public final /* synthetic */ AlertController f1242b;

            public C0350d(RecycleListView recycleListView, AlertController alertController) {
                this.f1241a = recycleListView;
                this.f1242b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = AlertParams.this.f1196F;
                if (zArr != null) {
                    zArr[i10] = this.f1241a.isItemChecked(i10);
                }
                AlertParams.this.f1200J.onClick(this.f1242b.f1166b, i10, this.f1241a.isItemChecked(i10));
            }
        }

        public AlertParams(Context context) {
            this.f1206a = context;
            this.f1207b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void m2020a(AlertController alertController) {
            View view = this.f1212g;
            if (view != null) {
                alertController.m2006k(view);
            } else {
                CharSequence charSequence = this.f1211f;
                if (charSequence != null) {
                    alertController.m2011p(charSequence);
                }
                Drawable drawable = this.f1209d;
                if (drawable != null) {
                    alertController.m2008m(drawable);
                }
                int i10 = this.f1208c;
                if (i10 != 0) {
                    alertController.m2007l(i10);
                }
                int i11 = this.f1210e;
                if (i11 != 0) {
                    alertController.m2007l(alertController.m1998c(i11));
                }
            }
            CharSequence charSequence2 = this.f1213h;
            if (charSequence2 != null) {
                alertController.m2009n(charSequence2);
            }
            CharSequence charSequence3 = this.f1214i;
            if (charSequence3 != null || this.f1215j != null) {
                alertController.m2005j(-1, charSequence3, this.f1216k, null, this.f1215j);
            }
            CharSequence charSequence4 = this.f1217l;
            if (charSequence4 != null || this.f1218m != null) {
                alertController.m2005j(-2, charSequence4, this.f1219n, null, this.f1218m);
            }
            CharSequence charSequence5 = this.f1220o;
            if (charSequence5 != null || this.f1221p != null) {
                alertController.m2005j(-3, charSequence5, this.f1222q, null, this.f1221p);
            }
            if (this.f1227v != null || this.f1201K != null || this.f1228w != null) {
                m2021b(alertController);
            }
            View view2 = this.f1231z;
            if (view2 != null) {
                if (this.f1195E) {
                    alertController.m2014s(view2, this.f1191A, this.f1192B, this.f1193C, this.f1194D);
                    return;
                } else {
                    alertController.m2013r(view2);
                    return;
                }
            }
            int i12 = this.f1230y;
            if (i12 != 0) {
                alertController.m2012q(i12);
            }
        }

        /* renamed from: b */
        public final void m2021b(AlertController alertController) {
            ListAdapter c0353c;
            RecycleListView recycleListView = (RecycleListView) this.f1207b.inflate(alertController.f1157L, (ViewGroup) null);
            if (this.f1197G) {
                c0353c = this.f1201K == null ? new C0347a(this.f1206a, alertController.f1158M, R.id.text1, this.f1227v, recycleListView) : new C0348b(this.f1206a, this.f1201K, false, recycleListView, alertController);
            } else {
                int i10 = this.f1198H ? alertController.f1159N : alertController.f1160O;
                if (this.f1201K != null) {
                    c0353c = new SimpleCursorAdapter(this.f1206a, i10, this.f1201K, new String[]{this.f1202L}, new int[]{R.id.text1});
                } else {
                    c0353c = this.f1228w;
                    if (c0353c == null) {
                        c0353c = new C0353c(this.f1206a, i10, R.id.text1, this.f1227v);
                    }
                }
            }
            alertController.f1153H = c0353c;
            alertController.f1154I = this.f1199I;
            if (this.f1229x != null) {
                recycleListView.setOnItemClickListener(new C0349c(alertController));
            } else if (this.f1200J != null) {
                recycleListView.setOnItemClickListener(new C0350d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1204N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f1198H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f1197G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1171g = recycleListView;
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        public final int f1244a;

        /* renamed from: b */
        public final int f1245b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public void m2022a(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f1244a, getPaddingRight(), z11 ? getPaddingBottom() : this.f1245b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f1245b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1244a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    public class ViewOnClickListenerC0351a implements View.OnClickListener {
        public ViewOnClickListenerC0351a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f1179o || (message3 = alertController.f1181q) == null) ? (view != alertController.f1183s || (message2 = alertController.f1185u) == null) ? (view != alertController.f1187w || (message = alertController.f1189y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f1163R.obtainMessage(1, alertController2.f1166b).sendToTarget();
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    public static final class HandlerC0352b extends Handler {

        /* renamed from: a */
        public WeakReference<DialogInterface> f1247a;

        public HandlerC0352b(DialogInterface dialogInterface) {
            this.f1247a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f1247a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    public static class C0353c extends ArrayAdapter<CharSequence> {
        public C0353c(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f1165a = context;
        this.f1166b = appCompatDialog;
        this.f1167c = window;
        this.f1163R = new HandlerC0352b(appCompatDialog);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f1155J = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.f1156K = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f1157L = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.f1158M = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f1159N = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f1160O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.f1161P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f1168d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        appCompatDialog.m2191m(1);
    }

    /* renamed from: a */
    public static boolean m1995a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1995a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    public static boolean m1996y(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* renamed from: b */
    public final void m1997b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    public int m1998c(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f1165a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: d */
    public ListView m1999d() {
        return this.f1171g;
    }

    /* renamed from: e */
    public void m2000e() {
        this.f1166b.setContentView(m2004i());
        m2019x();
    }

    /* renamed from: f */
    public boolean m2001f(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f1146A;
        return nestedScrollView != null && nestedScrollView.m3987s(keyEvent);
    }

    /* renamed from: g */
    public boolean m2002g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f1146A;
        return nestedScrollView != null && nestedScrollView.m3987s(keyEvent);
    }

    /* renamed from: h */
    public final ViewGroup m2003h(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: i */
    public final int m2004i() {
        int i10 = this.f1156K;
        return (i10 != 0 && this.f1162Q == 1) ? i10 : this.f1155J;
    }

    /* renamed from: j */
    public void m2005j(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f1163R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f1188x = charSequence;
            this.f1189y = message;
            this.f1190z = drawable;
        } else if (i10 == -2) {
            this.f1184t = charSequence;
            this.f1185u = message;
            this.f1186v = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f1180p = charSequence;
            this.f1181q = message;
            this.f1182r = drawable;
        }
    }

    /* renamed from: k */
    public void m2006k(View view) {
        this.f1152G = view;
    }

    /* renamed from: l */
    public void m2007l(int i10) {
        this.f1148C = null;
        this.f1147B = i10;
        ImageView imageView = this.f1149D;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f1149D.setImageResource(this.f1147B);
            }
        }
    }

    /* renamed from: m */
    public void m2008m(Drawable drawable) {
        this.f1148C = drawable;
        this.f1147B = 0;
        ImageView imageView = this.f1149D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f1149D.setImageDrawable(drawable);
            }
        }
    }

    /* renamed from: n */
    public void m2009n(CharSequence charSequence) {
        this.f1170f = charSequence;
        TextView textView = this.f1151F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: o */
    public final void m2010o(ViewGroup viewGroup, View view, int i10, int i11) {
        View viewFindViewById = this.f1167c.findViewById(R$id.scrollIndicatorUp);
        View viewFindViewById2 = this.f1167c.findViewById(R$id.scrollIndicatorDown);
        C9603h0.m59843F0(view, i10, i11);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    /* renamed from: p */
    public void m2011p(CharSequence charSequence) {
        this.f1169e = charSequence;
        TextView textView = this.f1150E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: q */
    public void m2012q(int i10) {
        this.f1172h = null;
        this.f1173i = i10;
        this.f1178n = false;
    }

    /* renamed from: r */
    public void m2013r(View view) {
        this.f1172h = view;
        this.f1173i = 0;
        this.f1178n = false;
    }

    /* renamed from: s */
    public void m2014s(View view, int i10, int i11, int i12, int i13) {
        this.f1172h = view;
        this.f1173i = 0;
        this.f1178n = true;
        this.f1174j = i10;
        this.f1175k = i11;
        this.f1176l = i12;
        this.f1177m = i13;
    }

    /* renamed from: t */
    public final void m2015t(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f1179o = button;
        button.setOnClickListener(this.f1164S);
        if (TextUtils.isEmpty(this.f1180p) && this.f1182r == null) {
            this.f1179o.setVisibility(8);
            i10 = 0;
        } else {
            this.f1179o.setText(this.f1180p);
            Drawable drawable = this.f1182r;
            if (drawable != null) {
                int i11 = this.f1168d;
                drawable.setBounds(0, 0, i11, i11);
                this.f1179o.setCompoundDrawables(this.f1182r, null, null, null);
            }
            this.f1179o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f1183s = button2;
        button2.setOnClickListener(this.f1164S);
        if (TextUtils.isEmpty(this.f1184t) && this.f1186v == null) {
            this.f1183s.setVisibility(8);
        } else {
            this.f1183s.setText(this.f1184t);
            Drawable drawable2 = this.f1186v;
            if (drawable2 != null) {
                int i12 = this.f1168d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f1183s.setCompoundDrawables(this.f1186v, null, null, null);
            }
            this.f1183s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f1187w = button3;
        button3.setOnClickListener(this.f1164S);
        if (TextUtils.isEmpty(this.f1188x) && this.f1190z == null) {
            this.f1187w.setVisibility(8);
        } else {
            this.f1187w.setText(this.f1188x);
            Drawable drawable3 = this.f1190z;
            if (drawable3 != null) {
                int i13 = this.f1168d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f1187w.setCompoundDrawables(this.f1190z, null, null, null);
            }
            this.f1187w.setVisibility(0);
            i10 |= 4;
        }
        if (m1996y(this.f1165a)) {
            if (i10 == 1) {
                m1997b(this.f1179o);
            } else if (i10 == 2) {
                m1997b(this.f1183s);
            } else if (i10 == 4) {
                m1997b(this.f1187w);
            }
        }
        if (i10 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: u */
    public final void m2016u(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f1167c.findViewById(R$id.scrollView);
        this.f1146A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f1146A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f1151F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f1170f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f1146A.removeView(this.f1151F);
        if (this.f1171g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f1146A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f1146A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f1171g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: v */
    public final void m2017v(ViewGroup viewGroup) {
        View viewInflate = this.f1172h;
        if (viewInflate == null) {
            viewInflate = this.f1173i != 0 ? LayoutInflater.from(this.f1165a).inflate(this.f1173i, viewGroup, false) : null;
        }
        boolean z10 = viewInflate != null;
        if (!z10 || !m1995a(viewInflate)) {
            this.f1167c.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f1167c.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f1178n) {
            frameLayout.setPadding(this.f1174j, this.f1175k, this.f1176l, this.f1177m);
        }
        if (this.f1171g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    /* renamed from: w */
    public final void m2018w(ViewGroup viewGroup) {
        if (this.f1152G != null) {
            viewGroup.addView(this.f1152G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1167c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.f1149D = (ImageView) this.f1167c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f1169e)) || !this.f1161P) {
            this.f1167c.findViewById(R$id.title_template).setVisibility(8);
            this.f1149D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f1167c.findViewById(R$id.alertTitle);
        this.f1150E = textView;
        textView.setText(this.f1169e);
        int i10 = this.f1147B;
        if (i10 != 0) {
            this.f1149D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.f1148C;
        if (drawable != null) {
            this.f1149D.setImageDrawable(drawable);
        } else {
            this.f1150E.setPadding(this.f1149D.getPaddingLeft(), this.f1149D.getPaddingTop(), this.f1149D.getPaddingRight(), this.f1149D.getPaddingBottom());
            this.f1149D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: x */
    public final void m2019x() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f1167c.findViewById(R$id.parentPanel);
        int i10 = R$id.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i10);
        int i11 = R$id.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i11);
        int i12 = R$id.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R$id.customPanel);
        m2017v(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i10);
        View viewFindViewById8 = viewGroup.findViewById(i11);
        View viewFindViewById9 = viewGroup.findViewById(i12);
        ViewGroup viewGroupM2003h = m2003h(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM2003h2 = m2003h(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM2003h3 = m2003h(viewFindViewById9, viewFindViewById6);
        m2016u(viewGroupM2003h2);
        m2015t(viewGroupM2003h3);
        m2018w(viewGroupM2003h);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (viewGroupM2003h == null || viewGroupM2003h.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (viewGroupM2003h3 == null || viewGroupM2003h3.getVisibility() == 8) ? false : true;
        if (!z12 && viewGroupM2003h2 != null && (viewFindViewById2 = viewGroupM2003h2.findViewById(R$id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.f1146A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f1170f == null && this.f1171g == null) ? null : viewGroupM2003h.findViewById(R$id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM2003h2 != null && (viewFindViewById = viewGroupM2003h2.findViewById(R$id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f1171g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).m2022a(z11, z12);
        }
        if (!z10) {
            View view = this.f1171g;
            if (view == null) {
                view = this.f1146A;
            }
            if (view != null) {
                m2010o(viewGroupM2003h2, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f1171g;
        if (listView2 == null || (listAdapter = this.f1153H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i13 = this.f1154I;
        if (i13 > -1) {
            listView2.setItemChecked(i13, true);
            listView2.setSelection(i13);
        }
    }
}
