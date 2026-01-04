package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.hwunifiedinteract.widget.HwCompoundEventDetector;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
class bqmxo {

    /* renamed from: q */
    private static final String f43942q = "HwMultipleChoiceModeHelper";

    /* renamed from: r */
    private static final int f43943r = -1;

    /* renamed from: s */
    private static final int f43944s = 3;

    /* renamed from: t */
    private static final int f43945t = 0;

    /* renamed from: u */
    private static final int f43946u = 20;

    /* renamed from: v */
    private static final int f43947v = -1;

    /* renamed from: w */
    private static final int f43948w = 2;

    /* renamed from: c */
    private ActionMode f43951c;

    /* renamed from: d */
    private boolean f43952d;

    /* renamed from: e */
    private boolean f43953e;

    /* renamed from: i */
    private HwRecyclerView f43957i;

    /* renamed from: j */
    private int f43958j;

    /* renamed from: k */
    private SparseBooleanArray f43959k;

    /* renamed from: l */
    private LongSparseArray<Integer> f43960l;

    /* renamed from: m */
    private aauaf f43961m;

    /* renamed from: n */
    private C14500bqmxo f43962n;

    /* renamed from: o */
    private HwRecyclerView.MultiChoiceModeListener f43963o;

    /* renamed from: p */
    private HwCompoundEventDetector.OnMultiSelectListener f43964p;

    /* renamed from: a */
    private boolean f43949a = true;

    /* renamed from: b */
    private boolean f43950b = true;

    /* renamed from: f */
    private int f43954f = -1;

    /* renamed from: g */
    private int f43955g = -1;

    /* renamed from: h */
    private int f43956h = 0;

    public class aauaf extends RecyclerView.AbstractC0840j {
        private aauaf() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onChanged() {
            bqmxo.this.m55372o();
            super.onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeChanged(int i10, int i11) {
            bqmxo.this.m55372o();
            super.onItemRangeChanged(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeInserted(int i10, int i11) {
            bqmxo.this.m55372o();
            super.onItemRangeInserted(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeMoved(int i10, int i11, int i12) {
            bqmxo.this.m55372o();
            super.onItemRangeMoved(i10, i11, i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeRemoved(int i10, int i11) {
            bqmxo.this.m55372o();
            super.onItemRangeRemoved(i10, i11);
        }

        public /* synthetic */ aauaf(bqmxo bqmxoVar, bzrwd bzrwdVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0840j
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            bqmxo.this.m55372o();
            super.onItemRangeChanged(i10, i11, obj);
        }
    }

    public static class akxao extends View.BaseSavedState {
        public static final Parcelable.Creator<akxao> CREATOR = new bzrwd();

        /* renamed from: a */
        private boolean f43966a;

        /* renamed from: b */
        private int f43967b;

        /* renamed from: c */
        private SparseBooleanArray f43968c;

        /* renamed from: d */
        private LongSparseArray<Integer> f43969d;

        /* renamed from: e */
        private int f43970e;

        /* renamed from: f */
        private int f43971f;

        public class bzrwd implements Parcelable.Creator<akxao> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public akxao createFromParcel(Parcel parcel) {
                return new akxao(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public akxao[] newArray(int i10) {
                return new akxao[i10];
            }
        }

        public /* synthetic */ akxao(Parcel parcel, bzrwd bzrwdVar) {
            this(parcel);
        }

        public String toString() {
            return "HwRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " mCheckState=" + this.f43968c + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel == null) {
                return;
            }
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f43966a ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f43967b);
            parcel.writeSparseBooleanArray(this.f43968c);
            LongSparseArray<Integer> longSparseArray = this.f43969d;
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeLong(this.f43969d.keyAt(i11));
                parcel.writeInt(this.f43969d.valueAt(i11).intValue());
            }
            parcel.writeInt(this.f43970e);
            parcel.writeInt(this.f43971f);
        }

        public akxao(Parcelable parcelable) {
            super(parcelable);
        }

        private akxao(Parcel parcel) {
            super(parcel);
            this.f43966a = parcel.readByte() != 0;
            this.f43967b = parcel.readInt();
            this.f43968c = parcel.readSparseBooleanArray();
            int i10 = parcel.readInt();
            if (i10 > 0 && i10 <= parcel.dataAvail() + 4) {
                this.f43969d = new LongSparseArray<>();
                for (int i11 = 0; i11 < i10; i11++) {
                    this.f43969d.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
            this.f43970e = parcel.readInt();
            this.f43971f = parcel.readInt();
        }
    }

    /* renamed from: com.huawei.uikit.hwrecyclerview.widget.bqmxo$bqmxo, reason: collision with other inner class name */
    public class C14500bqmxo implements HwRecyclerView.MultiChoiceModeListener {

        /* renamed from: a */
        private HwRecyclerView.MultiChoiceModeListener f43972a;

        public C14500bqmxo() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener = this.f43972a;
            if (multiChoiceModeListener == null) {
                return false;
            }
            return multiChoiceModeListener.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener = this.f43972a;
            if (multiChoiceModeListener == null || !multiChoiceModeListener.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            bqmxo.this.f43957i.setDetectoredLongpressEnabled(false);
            RecyclerView.AbstractC0838h adapter = bqmxo.this.f43957i.getAdapter();
            if (adapter == null || !adapter.m5212i()) {
                return true;
            }
            bqmxo bqmxoVar = bqmxo.this;
            bqmxoVar.f43961m = new aauaf(bqmxoVar, null);
            adapter.m5204A(bqmxo.this.f43961m);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener = this.f43972a;
            if (multiChoiceModeListener != null) {
                multiChoiceModeListener.onDestroyActionMode(actionMode);
            }
            bqmxo.this.f43951c = null;
            bqmxo.this.f43957i.clearChoices();
            bqmxo.this.f43957i.requestLayout();
            RecyclerView.AbstractC0838h adapter = bqmxo.this.f43957i.getAdapter();
            if (adapter != null && bqmxo.this.f43961m != null) {
                adapter.m5206C(bqmxo.this.f43961m);
                bqmxo.this.f43961m = null;
            }
            bqmxo.this.f43957i.setDetectoredLongpressEnabled(true);
        }

        @Override // com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i10, long j10, boolean z10) {
            HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener = this.f43972a;
            if (multiChoiceModeListener == null || actionMode == null) {
                return;
            }
            multiChoiceModeListener.onItemCheckedStateChanged(actionMode, i10, j10, z10);
            if (bqmxo.this.m55392g() == 0) {
                actionMode.finish();
                bqmxo.this.m55367c();
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener = this.f43972a;
            if (multiChoiceModeListener == null) {
                return false;
            }
            return multiChoiceModeListener.onPrepareActionMode(actionMode, menu);
        }

        /* renamed from: a */
        public void m55416a(HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener) {
            this.f43972a = multiChoiceModeListener;
        }

        /* renamed from: a */
        public boolean m55417a() {
            return this.f43972a != null;
        }
    }

    public class bzrwd implements HwCompoundEventDetector.OnMultiSelectListener {
        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwCompoundEventDetector.OnMultiSelectListener
        public boolean onCancel(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwCompoundEventDetector.OnMultiSelectListener
        public boolean onSelectContinuous(boolean z10, MotionEvent motionEvent) {
            return bqmxo.this.m55360a(motionEvent);
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwCompoundEventDetector.OnMultiSelectListener
        public boolean onSelectDiscrete(MotionEvent motionEvent) {
            return bqmxo.this.m55364b(motionEvent);
        }
    }

    public bqmxo(HwRecyclerView hwRecyclerView) {
        this.f43957i = hwRecyclerView;
        m55357a(hwRecyclerView.getContext());
    }

    /* renamed from: k */
    private int[] m55371k() {
        int[] iArr = new int[2];
        int i10 = this.f43954f;
        int i11 = this.f43955g;
        if (i10 <= i11) {
            iArr[0] = i10;
            iArr[1] = i11;
        } else {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m55372o() {
        RecyclerView.AbstractC0838h adapter = this.f43957i.getAdapter();
        if (this.f43956h == 0 || adapter == null || !adapter.m5212i()) {
            return;
        }
        m55368d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r */
    private void m55373r() {
        RecyclerView.AbstractC0833c0 childViewHolder;
        int childCount = this.f43957i.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f43957i.getChildAt(i10);
            if (childAt != 0 && (childViewHolder = this.f43957i.getChildViewHolder(childAt)) != null) {
                int iM5164k = childViewHolder.m5164k();
                if (childAt instanceof Checkable) {
                    ((Checkable) childAt).setChecked(this.f43959k.get(iM5164k));
                } else {
                    childAt.setActivated(this.f43959k.get(iM5164k));
                }
            }
        }
    }

    /* renamed from: e */
    public HwCompoundEventDetector.OnMultiSelectListener m55390e() {
        return new bzrwd();
    }

    /* renamed from: f */
    public SparseBooleanArray m55391f() {
        return this.f43959k;
    }

    /* renamed from: g */
    public int m55392g() {
        return this.f43958j;
    }

    /* renamed from: h */
    public long[] m55393h() {
        LongSparseArray<Integer> longSparseArray;
        if (this.f43956h == 0 || (longSparseArray = this.f43960l) == null) {
            return new long[0];
        }
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = this.f43960l.keyAt(i10);
        }
        return jArr;
    }

    /* renamed from: i */
    public ActionMode m55394i() {
        return this.f43951c;
    }

    /* renamed from: j */
    public int m55395j() {
        return this.f43956h;
    }

    /* renamed from: l */
    public HwRecyclerView.MultiChoiceModeListener m55396l() {
        return this.f43963o;
    }

    /* renamed from: m */
    public HwCompoundEventDetector.OnMultiSelectListener m55397m() {
        if (this.f43964p == null) {
            this.f43964p = m55390e();
        }
        return this.f43964p;
    }

    /* renamed from: n */
    public SparseBooleanArray m55398n() {
        if (this.f43956h == 3) {
            return this.f43959k;
        }
        return null;
    }

    /* renamed from: p */
    public boolean m55399p() {
        if (!this.f43952d && !this.f43953e) {
            return false;
        }
        this.f43952d = false;
        this.f43953e = false;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: q */
    public boolean m55400q() {
        if (this.f43956h != 3 || this.f43959k == null) {
            return false;
        }
        int childCount = this.f43957i.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f43957i.getChildAt(i10);
            if (childAt != 0) {
                boolean z10 = this.f43959k.get(this.f43957i.getChildAdapterPosition(childAt));
                if (childAt instanceof Checkable) {
                    Checkable checkable = (Checkable) childAt;
                    if (checkable.isChecked() != z10) {
                        checkable.setChecked(z10);
                        childAt.jumpDrawablesToCurrentState();
                    }
                } else {
                    childAt.setActivated(z10);
                    childAt.jumpDrawablesToCurrentState();
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    private void m55368d() {
        ActionMode actionMode;
        this.f43959k.clear();
        RecyclerView.AbstractC0838h adapter = this.f43957i.getAdapter();
        if (adapter == null || this.f43960l == null) {
            return;
        }
        int i10 = 0;
        boolean z10 = false;
        while (i10 < this.f43960l.size()) {
            long jKeyAt = this.f43960l.keyAt(i10);
            int iIntValue = this.f43960l.valueAt(i10).intValue();
            if (jKeyAt != adapter.mo722f(iIntValue)) {
                int i11 = iIntValue - 20;
                int i12 = iIntValue + 20;
                int iMo721e = adapter.mo721e();
                if (!m55361a(adapter, i10, jKeyAt, i11 <= 0 ? 0 : i11, i12 <= iMo721e ? i12 : iMo721e)) {
                    this.f43960l.delete(jKeyAt);
                    i10--;
                    this.f43958j--;
                    m55356a(jKeyAt, iIntValue);
                    z10 = true;
                }
            } else {
                this.f43959k.put(iIntValue, true);
            }
            i10++;
        }
        if (!z10 || (actionMode = this.f43951c) == null) {
            return;
        }
        actionMode.invalidate();
    }

    /* renamed from: c */
    public boolean m55389c(MotionEvent motionEvent) {
        View viewFindChildViewUnder;
        if (this.f43956h != 3 || this.f43951c != null || (viewFindChildViewUnder = this.f43957i.findChildViewUnder(motionEvent.getX(), motionEvent.getY())) == null || !m55387b(this.f43957i.getChildAdapterPosition(viewFindChildViewUnder))) {
            return false;
        }
        this.f43957i.setPressed(false);
        viewFindChildViewUnder.setPressed(false);
        return true;
    }

    /* renamed from: b */
    public void m55385b() {
        SparseBooleanArray sparseBooleanArray = this.f43959k;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.f43960l;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.f43958j = 0;
    }

    /* renamed from: a */
    private void m55357a(Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            return;
        }
        HwRecyclerView hwRecyclerView = this.f43957i;
        Boolean bool = Boolean.TRUE;
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, hwRecyclerView, "consecutiveSelectEnabled", bool});
        if (objInvokeMethod instanceof Boolean) {
            m55380a(true, ((Boolean) objInvokeMethod).booleanValue());
        }
        Object objInvokeMethod2 = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this.f43957i, "quickSelectEnabled", bool});
        if (objInvokeMethod2 instanceof Boolean) {
            m55380a(false, ((Boolean) objInvokeMethod2).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m55367c() {
        this.f43954f = -1;
        this.f43955g = -1;
    }

    /* renamed from: b */
    public akxao m55384b(Parcelable parcelable) {
        akxao akxaoVar = new akxao(parcelable);
        akxaoVar.f43966a = this.f43956h == 3 && this.f43951c != null;
        SparseBooleanArray sparseBooleanArray = this.f43959k;
        if (sparseBooleanArray != null) {
            akxaoVar.f43968c = sparseBooleanArray.clone();
        }
        if (this.f43960l != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            int size = this.f43960l.size();
            for (int i10 = 0; i10 < size; i10++) {
                longSparseArray.put(this.f43960l.keyAt(i10), this.f43960l.valueAt(i10));
            }
            akxaoVar.f43969d = longSparseArray;
        }
        akxaoVar.f43967b = this.f43958j;
        akxaoVar.f43970e = this.f43954f;
        akxaoVar.f43971f = this.f43955g;
        return akxaoVar;
    }

    /* renamed from: c */
    public void m55388c(int i10) {
        this.f43956h = i10;
        ActionMode actionMode = this.f43951c;
        if (actionMode != null) {
            actionMode.finish();
            m55367c();
            this.f43951c = null;
        }
        if (this.f43956h == 3) {
            RecyclerView.AbstractC0838h adapter = this.f43957i.getAdapter();
            if (this.f43959k == null) {
                this.f43959k = new SparseBooleanArray();
            }
            if (this.f43960l == null && adapter != null && adapter.m5212i()) {
                this.f43960l = new LongSparseArray<>();
            }
            m55385b();
            this.f43957i.setDetectoredLongpressEnabled(true);
        }
    }

    /* renamed from: a */
    public boolean m55382a(int i10, long j10) {
        boolean z10;
        RecyclerView.AbstractC0838h adapter = this.f43957i.getAdapter();
        boolean z11 = false;
        if (adapter == null || this.f43956h != 3) {
            return false;
        }
        if (this.f43951c != null) {
            m55369d(i10);
            z10 = true;
            boolean z12 = !this.f43959k.get(i10, false);
            this.f43959k.put(i10, z12);
            m55359a(z12, adapter, i10);
            if (z12) {
                this.f43958j++;
            } else {
                this.f43958j--;
            }
            ActionMode actionMode = this.f43951c;
            if (actionMode != null) {
                this.f43962n.onItemCheckedStateChanged(actionMode, i10, j10, z12);
            }
            z11 = true;
        } else {
            z10 = false;
        }
        if (z11) {
            m55373r();
        }
        return z10;
    }

    /* renamed from: d */
    private void m55369d(int i10) {
        this.f43954f = i10;
        this.f43955g = -1;
    }

    /* renamed from: b */
    public void m55386b(boolean z10) {
        int[] iArrM55371k = m55371k();
        int i10 = this.f43954f;
        int i11 = this.f43955g;
        for (int i12 = iArrM55371k[0]; i12 <= iArrM55371k[1]; i12++) {
            if (i12 != this.f43954f || z10) {
                this.f43957i.setItemChecked(i12, z10);
            }
        }
        this.f43954f = i10;
        this.f43955g = i11;
    }

    /* renamed from: a */
    public void m55376a(int i10, boolean z10) {
        RecyclerView.AbstractC0838h adapter = this.f43957i.getAdapter();
        if (adapter == null || this.f43956h != 3) {
            return;
        }
        if (z10 && this.f43951c == null) {
            C14500bqmxo c14500bqmxo = this.f43962n;
            if (c14500bqmxo != null && c14500bqmxo.f43972a != null) {
                this.f43951c = this.f43957i.startActionMode(this.f43962n);
            } else {
                Log.e(f43942q, "The multi-select mode condition is not established");
                return;
            }
        }
        if (this.f43956h == 3) {
            m55369d(i10);
            boolean z11 = this.f43959k.get(i10);
            this.f43959k.put(i10, z10);
            m55359a(z10, adapter, i10);
            boolean z12 = z11 != z10;
            if (z12) {
                if (z10) {
                    this.f43958j++;
                } else {
                    this.f43958j--;
                }
            }
            if (this.f43951c != null) {
                this.f43962n.onItemCheckedStateChanged(this.f43951c, i10, adapter.mo722f(i10), z10);
            }
            if (z12) {
                this.f43957i.requestLayout();
            }
        }
    }

    /* renamed from: b */
    public boolean m55387b(int i10) {
        C14500bqmxo c14500bqmxo;
        if (this.f43956h != 3) {
            return false;
        }
        if (this.f43951c == null && (c14500bqmxo = this.f43962n) != null) {
            ActionMode actionModeStartActionMode = this.f43957i.startActionMode(c14500bqmxo);
            this.f43951c = actionModeStartActionMode;
            if (actionModeStartActionMode != null) {
                this.f43957i.setItemChecked(i10, true);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m55364b(MotionEvent motionEvent) {
        View viewFindChildViewUnder;
        if (!this.f43949a || (viewFindChildViewUnder = this.f43957i.findChildViewUnder(motionEvent.getX(), motionEvent.getY())) == null) {
            return false;
        }
        int childAdapterPosition = this.f43957i.getChildAdapterPosition(viewFindChildViewUnder);
        if (this.f43956h != 3 || this.f43951c != null || childAdapterPosition == -1) {
            return false;
        }
        this.f43957i.setItemChecked(childAdapterPosition, true);
        this.f43953e = true;
        return true;
    }

    /* renamed from: a */
    private void m55359a(boolean z10, RecyclerView.AbstractC0838h abstractC0838h, int i10) {
        if (this.f43960l == null || !abstractC0838h.m5212i()) {
            return;
        }
        if (z10) {
            this.f43960l.put(abstractC0838h.mo722f(i10), Integer.valueOf(i10));
        } else {
            this.f43960l.delete(abstractC0838h.mo722f(i10));
        }
    }

    /* renamed from: a */
    private boolean m55361a(RecyclerView.AbstractC0838h abstractC0838h, int i10, long j10, int i11, int i12) {
        while (i11 < i12) {
            if (j10 == abstractC0838h.mo722f(i11)) {
                this.f43959k.put(i11, true);
                this.f43960l.setValueAt(i10, Integer.valueOf(i11));
                return true;
            }
            i11++;
        }
        return false;
    }

    /* renamed from: a */
    private void m55356a(long j10, int i10) {
        C14500bqmxo c14500bqmxo;
        ActionMode actionMode = this.f43951c;
        if (actionMode == null || (c14500bqmxo = this.f43962n) == null) {
            return;
        }
        c14500bqmxo.onItemCheckedStateChanged(actionMode, i10, j10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m55377a(View view, int i10) {
        if (this.f43956h != 3 || this.f43951c == null) {
            return;
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f43959k.get(i10));
        } else {
            view.setActivated(this.f43959k.get(i10));
        }
    }

    /* renamed from: a */
    public void m55378a(RecyclerView.AbstractC0838h abstractC0838h) {
        if (abstractC0838h != null && this.f43956h != 0 && abstractC0838h.m5212i() && this.f43960l == null) {
            this.f43960l = new LongSparseArray<>();
        }
        m55385b();
        ActionMode actionMode = this.f43951c;
        if (actionMode != null) {
            actionMode.finish();
            this.f43951c = null;
        }
    }

    /* renamed from: a */
    public boolean m55381a(int i10) {
        SparseBooleanArray sparseBooleanArray;
        if (this.f43956h != 3 || (sparseBooleanArray = this.f43959k) == null) {
            return false;
        }
        return sparseBooleanArray.get(i10);
    }

    /* renamed from: a */
    public void m55380a(boolean z10, boolean z11) {
        if (z10) {
            this.f43950b = z11;
        } else {
            this.f43949a = z11;
        }
    }

    /* renamed from: a */
    public boolean m55383a(boolean z10) {
        return z10 ? this.f43950b : this.f43949a;
    }

    /* renamed from: a */
    public void m55379a(HwRecyclerView.MultiChoiceModeListener multiChoiceModeListener) {
        if (this.f43962n == null) {
            this.f43962n = new C14500bqmxo();
        }
        this.f43963o = multiChoiceModeListener;
        this.f43962n.m55416a(multiChoiceModeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m55360a(MotionEvent motionEvent) {
        boolean z10 = false;
        if (!this.f43950b) {
            return false;
        }
        View viewFindChildViewUnder = this.f43957i.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (viewFindChildViewUnder != null) {
            int childAdapterPosition = this.f43957i.getChildAdapterPosition(viewFindChildViewUnder);
            if (this.f43956h == 3 && this.f43951c != null && childAdapterPosition != -1) {
                int i10 = this.f43955g;
                if (i10 != -1 && i10 != childAdapterPosition) {
                    m55386b(false);
                }
                z10 = true;
                if (this.f43955g != childAdapterPosition) {
                    this.f43955g = childAdapterPosition;
                    m55386b(true);
                }
                this.f43952d = true;
            }
        }
        return z10;
    }

    /* renamed from: a */
    public Parcelable m55374a(Parcelable parcelable) {
        C14500bqmxo c14500bqmxo;
        if (!(parcelable instanceof akxao)) {
            return null;
        }
        akxao akxaoVar = (akxao) parcelable;
        if (akxaoVar.f43968c != null) {
            this.f43959k = akxaoVar.f43968c;
        }
        if (akxaoVar.f43969d != null) {
            this.f43960l = akxaoVar.f43969d;
        }
        this.f43958j = akxaoVar.f43967b;
        if (akxaoVar.f43966a && this.f43956h == 3 && (c14500bqmxo = this.f43962n) != null) {
            this.f43951c = this.f43957i.startActionMode(c14500bqmxo);
        }
        this.f43954f = akxaoVar.f43970e;
        this.f43955g = akxaoVar.f43971f;
        this.f43957i.requestLayout();
        return akxaoVar.getSuperState();
    }

    /* renamed from: a */
    public void m55375a() {
        SparseBooleanArray sparseBooleanArray = this.f43959k;
        if (sparseBooleanArray != null) {
            int size = sparseBooleanArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                m55376a(this.f43959k.keyAt(i10), false);
            }
        }
    }
}
