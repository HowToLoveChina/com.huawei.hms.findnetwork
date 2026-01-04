package com.huawei.phoneservice.faq.base.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes4.dex */
public class SimpleBaseAdapter<T> extends BaseAdapter {
    protected List<T> arrayList = new ArrayList(0);
    protected View.OnClickListener listener;

    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(Landroid/view/View;I)TT; */
    public static View findViewById(View view, int i10) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(sparseArray);
        }
        View view2 = (View) sparseArray.get(i10);
        if (view2 != null) {
            return view2;
        }
        View viewFindViewById = view.findViewById(i10);
        sparseArray.put(i10, viewFindViewById);
        return viewFindViewById;
    }

    public void add(int i10, T t10) {
        if (t10 == null) {
            return;
        }
        this.arrayList.add(i10, t10);
    }

    public void appendToList(int i10, List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<T> listSubList = this.arrayList.subList(0, i10);
        this.arrayList = listSubList;
        listSubList.addAll(list);
    }

    public void cleanAll() {
        List<T> list = this.arrayList;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.arrayList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<T> list = this.arrayList;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.arrayList.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public View.OnClickListener getOnClickListener() {
        return this.listener;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    public void setResource(List<T> list) {
        List<T> list2;
        if (list == null || (list2 = this.arrayList) == null) {
            this.arrayList = new ArrayList();
        } else {
            list2.clear();
            this.arrayList.addAll(list);
        }
    }

    public void add(T t10) {
        add(this.arrayList.size(), t10);
    }

    public void appendToList(List<T> list) {
        appendToList(this.arrayList.size(), list);
    }
}
