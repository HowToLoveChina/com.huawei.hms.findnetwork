package com.huawei.uikit.hwrecyclerview.widget;

import android.util.Log;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class HwAvlTree<T extends Comparable<T>> {

    /* renamed from: b */
    private static final String f43338b = "HwAvlTree";

    /* renamed from: c */
    private static final boolean f43339c = false;

    /* renamed from: a */
    private HwAvlTree<T>.HwAvlTreeNode<T> f43340a = null;

    public class HwAvlTreeNode<T extends Comparable<T>> {

        /* renamed from: a */
        private T f43341a;

        /* renamed from: b */
        private int f43342b = 0;

        /* renamed from: c */
        private HwAvlTree<T>.HwAvlTreeNode<T> f43343c;

        /* renamed from: d */
        private HwAvlTree<T>.HwAvlTreeNode<T> f43344d;

        public HwAvlTreeNode(T t10, HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode2) {
            this.f43341a = t10;
            this.f43343c = hwAvlTreeNode;
            this.f43344d = hwAvlTreeNode2;
        }
    }

    /* renamed from: a */
    private int m54852a(int i10, int i11) {
        return i10 >= i11 ? i10 : i11;
    }

    /* renamed from: b */
    private void m54859b(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        if (hwAvlTreeNode != null) {
            m54859b(((HwAvlTreeNode) hwAvlTreeNode).f43343c);
            m54859b(((HwAvlTreeNode) hwAvlTreeNode).f43344d);
        }
    }

    /* renamed from: c */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54861c(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, T t10) {
        if (hwAvlTreeNode == null) {
            return null;
        }
        int iCompareTo = t10.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43341a);
        return iCompareTo < 0 ? m54861c(((HwAvlTreeNode) hwAvlTreeNode).f43343c, t10) : iCompareTo > 0 ? m54861c(((HwAvlTreeNode) hwAvlTreeNode).f43344d, t10) : hwAvlTreeNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54862d(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        ((HwAvlTreeNode) hwAvlTreeNode).f43343c = m54867i(((HwAvlTreeNode) hwAvlTreeNode).f43343c);
        return m54860c(hwAvlTreeNode);
    }

    /* renamed from: e */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54863e(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        if (hwAvlTreeNode == null) {
            return null;
        }
        while (((HwAvlTreeNode) hwAvlTreeNode).f43344d != null) {
            hwAvlTreeNode = ((HwAvlTreeNode) hwAvlTreeNode).f43344d;
        }
        return hwAvlTreeNode;
    }

    /* renamed from: f */
    private void m54864f(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        if (hwAvlTreeNode != null) {
            m54864f(((HwAvlTreeNode) hwAvlTreeNode).f43343c);
            m54864f(((HwAvlTreeNode) hwAvlTreeNode).f43344d);
        }
    }

    /* renamed from: g */
    private void m54865g(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        if (hwAvlTreeNode != null) {
            m54865g(((HwAvlTreeNode) hwAvlTreeNode).f43343c);
            m54865g(((HwAvlTreeNode) hwAvlTreeNode).f43344d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54866h(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        ((HwAvlTreeNode) hwAvlTreeNode).f43344d = m54860c(((HwAvlTreeNode) hwAvlTreeNode).f43344d);
        return m54867i(hwAvlTreeNode);
    }

    /* renamed from: i */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54867i(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode2 = ((HwAvlTreeNode) hwAvlTreeNode).f43344d;
        ((HwAvlTreeNode) hwAvlTreeNode).f43344d = ((HwAvlTreeNode) hwAvlTreeNode2).f43343c;
        ((HwAvlTreeNode) hwAvlTreeNode2).f43343c = hwAvlTreeNode;
        ((HwAvlTreeNode) hwAvlTreeNode).f43342b = m54852a(m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c), m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d)) + 1;
        ((HwAvlTreeNode) hwAvlTreeNode2).f43342b = m54852a(m54853a(((HwAvlTreeNode) hwAvlTreeNode2).f43344d), ((HwAvlTreeNode) hwAvlTreeNode).f43342b) + 1;
        return hwAvlTreeNode2;
    }

    public int getHeight() {
        return m54853a(this.f43340a);
    }

    public List<T> getInOrderNodes() {
        ArrayList arrayList = new ArrayList();
        m54857a(this.f43340a, arrayList);
        return arrayList;
    }

    public void inOrder() {
    }

    public void insert(T t10) {
        this.f43340a = m54858b(this.f43340a, t10);
    }

    public boolean isEmpty() {
        return this.f43340a == null;
    }

    public void postOrder() {
    }

    public void preOrder() {
    }

    public void remove(T t10) {
        HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNodeM54861c = m54861c(this.f43340a, t10);
        if (hwAvlTreeNodeM54861c != null) {
            this.f43340a = m54854a(this.f43340a, hwAvlTreeNodeM54861c);
        }
    }

    public HwAvlTree<T>.HwAvlTreeNode<T> search(T t10) {
        return m54861c(this.f43340a, t10);
    }

    public List<T> searchAllMatchKey(T t10) {
        ArrayList arrayList = new ArrayList();
        m54856a(this.f43340a, t10, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private int m54853a(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        if (hwAvlTreeNode != null) {
            return ((HwAvlTreeNode) hwAvlTreeNode).f43342b;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m54857a(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, List<T> list) {
        if (hwAvlTreeNode == null) {
            return;
        }
        m54857a(((HwAvlTreeNode) hwAvlTreeNode).f43343c, list);
        list.add(((HwAvlTreeNode) hwAvlTreeNode).f43341a);
        m54857a(((HwAvlTreeNode) hwAvlTreeNode).f43344d, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54858b(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, T t10) {
        HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNodeM54855a;
        if (hwAvlTreeNode == 0) {
            hwAvlTreeNodeM54855a = new HwAvlTreeNode<>(t10, null, null);
        } else {
            int iCompareTo = t10.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43341a);
            if (iCompareTo < 0) {
                ((HwAvlTreeNode) hwAvlTreeNode).f43343c = m54858b(((HwAvlTreeNode) hwAvlTreeNode).f43343c, t10);
                hwAvlTreeNodeM54855a = m54855a((HwAvlTree<T>.HwAvlTreeNode<HwAvlTree<T>.HwAvlTreeNode<T>>) hwAvlTreeNode, (HwAvlTree<T>.HwAvlTreeNode<T>) t10);
            } else if (iCompareTo > 0) {
                ((HwAvlTreeNode) hwAvlTreeNode).f43344d = m54858b(((HwAvlTreeNode) hwAvlTreeNode).f43344d, t10);
                hwAvlTreeNodeM54855a = m54855a((HwAvlTree<T>.HwAvlTreeNode<HwAvlTree<T>.HwAvlTreeNode<T>>) hwAvlTreeNode, (HwAvlTree<T>.HwAvlTreeNode<T>) t10);
            } else {
                Log.e(f43338b, "insert failed, same node");
                hwAvlTreeNodeM54855a = hwAvlTreeNode;
            }
        }
        ((HwAvlTreeNode) hwAvlTreeNodeM54855a).f43342b = m54852a(m54853a(((HwAvlTreeNode) hwAvlTreeNodeM54855a).f43343c), m54853a(((HwAvlTreeNode) hwAvlTreeNodeM54855a).f43344d)) + 1;
        return hwAvlTreeNodeM54855a;
    }

    /* renamed from: c */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54860c(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode) {
        HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode2 = ((HwAvlTreeNode) hwAvlTreeNode).f43343c;
        ((HwAvlTreeNode) hwAvlTreeNode).f43343c = ((HwAvlTreeNode) hwAvlTreeNode2).f43344d;
        ((HwAvlTreeNode) hwAvlTreeNode2).f43344d = hwAvlTreeNode;
        ((HwAvlTreeNode) hwAvlTreeNode).f43342b = m54852a(m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c), m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d)) + 1;
        ((HwAvlTreeNode) hwAvlTreeNode2).f43342b = m54852a(m54853a(((HwAvlTreeNode) hwAvlTreeNode2).f43343c), ((HwAvlTreeNode) hwAvlTreeNode).f43342b) + 1;
        return hwAvlTreeNode2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m54856a(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, T t10, List<T> list) {
        if (hwAvlTreeNode == null) {
            return;
        }
        if (t10.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43341a) == 0) {
            list.add(((HwAvlTreeNode) hwAvlTreeNode).f43341a);
        }
        m54856a(((HwAvlTreeNode) hwAvlTreeNode).f43343c, t10, list);
        m54856a(((HwAvlTreeNode) hwAvlTreeNode).f43344d, t10, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54855a(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, T t10) {
        if (m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c) - m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d) > 1) {
            if (t10.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43343c.f43341a) < 0) {
                return m54860c(hwAvlTreeNode);
            }
            return m54862d(hwAvlTreeNode);
        }
        if (m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d) - m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c) <= 1) {
            return hwAvlTreeNode;
        }
        if (t10.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43344d.f43341a) > 0) {
            return m54867i(hwAvlTreeNode);
        }
        return m54866h(hwAvlTreeNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private HwAvlTree<T>.HwAvlTreeNode<T> m54854a(HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode, HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNode2) {
        if (hwAvlTreeNode == 0 || hwAvlTreeNode2 == 0) {
            return null;
        }
        int iCompareTo = ((HwAvlTreeNode) hwAvlTreeNode2).f43341a.compareTo(((HwAvlTreeNode) hwAvlTreeNode).f43341a);
        if (iCompareTo < 0) {
            ((HwAvlTreeNode) hwAvlTreeNode).f43343c = m54854a(((HwAvlTreeNode) hwAvlTreeNode).f43343c, (HwAvlTree<T>.HwAvlTreeNode<T>) hwAvlTreeNode2);
            if (m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d) - m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c) <= 1) {
                return hwAvlTreeNode;
            }
            HwAvlTreeNode hwAvlTreeNode3 = ((HwAvlTreeNode) hwAvlTreeNode).f43344d;
            if (m54853a(hwAvlTreeNode3.f43343c) > m54853a(hwAvlTreeNode3.f43344d)) {
                return m54866h(hwAvlTreeNode);
            }
            return m54867i(hwAvlTreeNode);
        }
        if (iCompareTo <= 0) {
            if (((HwAvlTreeNode) hwAvlTreeNode).f43343c == null || ((HwAvlTreeNode) hwAvlTreeNode).f43344d == null) {
                return ((HwAvlTreeNode) hwAvlTreeNode).f43343c != null ? ((HwAvlTreeNode) hwAvlTreeNode).f43343c : ((HwAvlTreeNode) hwAvlTreeNode).f43344d;
            }
            if (m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c) > m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d)) {
                HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNodeM54863e = m54863e(((HwAvlTreeNode) hwAvlTreeNode).f43343c);
                ((HwAvlTreeNode) hwAvlTreeNode).f43341a = ((HwAvlTreeNode) hwAvlTreeNodeM54863e).f43341a;
                ((HwAvlTreeNode) hwAvlTreeNode).f43343c = m54854a(((HwAvlTreeNode) hwAvlTreeNode).f43343c, hwAvlTreeNodeM54863e);
                return hwAvlTreeNode;
            }
            HwAvlTree<T>.HwAvlTreeNode<T> hwAvlTreeNodeM54863e2 = m54863e(((HwAvlTreeNode) hwAvlTreeNode).f43344d);
            ((HwAvlTreeNode) hwAvlTreeNode).f43341a = ((HwAvlTreeNode) hwAvlTreeNodeM54863e2).f43341a;
            ((HwAvlTreeNode) hwAvlTreeNode).f43344d = m54854a(((HwAvlTreeNode) hwAvlTreeNode).f43344d, hwAvlTreeNodeM54863e2);
            return hwAvlTreeNode;
        }
        ((HwAvlTreeNode) hwAvlTreeNode).f43344d = m54854a(((HwAvlTreeNode) hwAvlTreeNode).f43344d, (HwAvlTree<T>.HwAvlTreeNode<T>) hwAvlTreeNode2);
        if (m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43343c) - m54853a(((HwAvlTreeNode) hwAvlTreeNode).f43344d) <= 1) {
            return hwAvlTreeNode;
        }
        HwAvlTreeNode hwAvlTreeNode4 = ((HwAvlTreeNode) hwAvlTreeNode).f43343c;
        if (m54853a(hwAvlTreeNode4.f43344d) > m54853a(hwAvlTreeNode4.f43343c)) {
            return m54862d(hwAvlTreeNode);
        }
        return m54860c(hwAvlTreeNode);
    }
}
