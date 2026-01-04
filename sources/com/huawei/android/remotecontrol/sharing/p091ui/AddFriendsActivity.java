package com.huawei.android.remotecontrol.sharing.p091ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.p093ui.BaseActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.bean.Contact;
import com.huawei.android.remotecontrol.sharing.bean.FriendInfo;
import com.huawei.hms.p148ui.SafeIntent;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import ng.C11703j;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0226l0;
import p514o9.C11842p;
import p521og.C11881n;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p707vf.C13433a;
import p783xp.C13843a;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class AddFriendsActivity extends BaseActivity implements TextView.OnEditorActionListener {

    /* renamed from: r */
    public Dialog f20156r;

    /* renamed from: s */
    public HiCloudExceptionView f20157s;

    /* renamed from: t */
    public NotchTopFitRelativeLayout f20158t;

    /* renamed from: u */
    public NotchFitRelativeLayout f20159u;

    /* renamed from: v */
    public EditText f20160v;

    /* renamed from: w */
    public Contact f20161w;

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.AddFriendsActivity$a */
    public class C4402a extends AbstractC12367d {

        /* renamed from: a */
        public final Context f20162a;

        /* renamed from: b */
        public final Contact f20163b;

        public C4402a(Context context, Contact contact) {
            this.f20162a = context;
            this.f20163b = contact;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, C9721b {
            final int iM26191a;
            PhoneFinderServer phoneFinderServer = new PhoneFinderServer(this.f20162a);
            FriendInfo friendInfo = new FriendInfo();
            friendInfo.setRelationType(2);
            friendInfo.setFriendAccountName(this.f20163b.getNumber());
            friendInfo.setFriendAliasName(this.f20163b.getName());
            try {
                iM26191a = phoneFinderServer.m26191a(friendInfo);
            } catch (C9721b e10) {
                C13981a.m83988e("AddFriendsActivity", "AddFriendTask CExption:" + e10.getMessage());
                iM26191a = 1;
            }
            C13981a.m83989i("AddFriendsActivity", "AddFriendTask result code:" + iM26191a);
            if (iM26191a != 0 && iM26191a != 3022) {
                C0226l0.m1584d(new Runnable() { // from class: xf.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61967a.m26554d(iM26191a);
                    }
                });
            } else {
                AddFriendsActivity.this.setResult(-1);
                AddFriendsActivity.this.finish();
            }
        }

        /* renamed from: d */
        public final /* synthetic */ void m26554d(int i10) {
            AddFriendsActivity addFriendsActivity = AddFriendsActivity.this;
            addFriendsActivity.m26550c2(addFriendsActivity.m26545V1(i10));
        }
    }

    /* renamed from: W1 */
    private void m26542W1() {
        this.f20158t = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f20159u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_view);
        this.f20157s = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.account_editor);
        this.f20160v = editText;
        editText.setOnEditorActionListener(this);
        ((ImageButton) C12809f.m76829b(this, R$id.contact_icon)).setOnClickListener(new View.OnClickListener() { // from class: xf.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f61966a.m26543a2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2 */
    public /* synthetic */ void m26543a2(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        m26551d2();
    }

    /* renamed from: U1 */
    public final void m26544U1() {
        Contact contact;
        if (this.f20160v != null && m26546X1()) {
            String strReplace = this.f20160v.getText().toString().replace(" ", "");
            if (TextUtils.isEmpty(strReplace)) {
                C13981a.m83990w("AddFriendsActivity", "input account is empty");
                return;
            }
            if (!C11881n.m71376z(strReplace) && !m26547Y1(strReplace)) {
                m26550c2(m26545V1(3020));
                C13981a.m83990w("AddFriendsActivity", "input account format error");
                return;
            }
            Contact contact2 = this.f20161w;
            if (contact2 == null || !strReplace.equals(contact2.getNumber())) {
                Contact contact3 = new Contact();
                contact3.setNumber(strReplace);
                contact3.setName("");
                contact = contact3;
            } else {
                contact = this.f20161w;
            }
            C12515a.m75110o().m75172d(new C4402a(this, contact));
        }
    }

    /* renamed from: V1 */
    public final int m26545V1(int i10) {
        if (i10 == 3020) {
            return R$string.add_friend_account_not_exist;
        }
        if (i10 == 3031) {
            return R$string.add_friend_is_self;
        }
        if (i10 == 3032) {
            return R$string.query_fail_please_retry_later;
        }
        switch (i10) {
            case 3023:
                return R$string.add_friend_sender_limited;
            case 3024:
                return R$string.add_friend_receiver_limited;
            case 3025:
                return R$string.add_friend_country_not_support;
            case 3026:
                return R$string.add_friend_exist_in_family;
            default:
                return R$string.text_oobedisabledreason;
        }
    }

    /* renamed from: X1 */
    public final boolean m26546X1() {
        if (C0209d.m1333z1(this)) {
            this.f20157s.m23914a();
            return true;
        }
        this.f20157s.m23919i();
        return false;
    }

    /* renamed from: Y1 */
    public final boolean m26547Y1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{8,20}$");
    }

    /* renamed from: Z1 */
    public final /* synthetic */ void m26548Z1(View view) {
        if (view.getId() == R$id.ic_more_hot_space) {
            m26544U1();
        }
    }

    /* renamed from: b2 */
    public final /* synthetic */ void m26549b2(DialogInterface dialogInterface, int i10) {
        Dialog dialog;
        if (dialogInterface == null || (dialog = this.f20156r) == null) {
            return;
        }
        dialog.dismiss();
        this.f20156r = null;
    }

    /* renamed from: c2 */
    public final void m26550c2(int i10) {
        if (this.f20156r == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(i10);
            builder.setPositiveButton(R$string.cs_confirm, new DialogInterface.OnClickListener() { // from class: xf.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.f61964a.m26549b2(dialogInterface, i11);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f20156r = alertDialogCreate;
            C11842p.m70890z1(this, alertDialogCreate);
            this.f20156r.setCanceledOnTouchOutside(false);
            try {
                C13981a.m83989i("AddFriendsActivity", "showErrorDialog");
                this.f20156r.show();
            } catch (Exception unused) {
                C13981a.m83988e("AddFriendsActivity", "show CloseOfflineLocateDialog bad window");
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20158t);
        arrayList.add(this.f20157s);
        arrayList.add(this.f20159u);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m26551d2() {
        try {
            Intent intent = new Intent();
            if (C11703j.m69815k(this, "com.huawei.contacts")) {
                intent.setPackage("com.huawei.contacts");
            } else {
                intent.setPackage("com.android.contacts");
            }
            intent.setAction("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/phone_v2");
            intent.putExtra("com.huawei.community.action.ADD_EMAIL", true);
            intent.putExtra("com.huawei.community.action.MULTIPLE_PICK", false);
            intent.putExtra("com.huawei.community.action.EXPECT_INTEGER_LIST", true);
            intent.putExtra("com.huawei.community.action.MAX_SELECT_COUNT", 1);
            startActivityForResult(intent, 10);
        } catch (Exception e10) {
            C13981a.m83988e("AddFriendsActivity", "startFamilyShareActivity exception: " + e10.getMessage());
        }
    }

    /* renamed from: e2 */
    public final void m26552e2(List<Contact> list) {
        if (list.isEmpty()) {
            C13981a.m83990w("AddFriendsActivity", "contact list is empty");
            return;
        }
        Contact contact = list.get(0);
        if (contact == null) {
            C13981a.m83990w("AddFriendsActivity", "contact is empty");
            return;
        }
        String number = contact.getNumber();
        if (TextUtils.isEmpty(number)) {
            C13981a.m83990w("AddFriendsActivity", "contact account is empty");
            return;
        }
        this.f20161w = contact;
        this.f20160v.setText("");
        try {
            this.f20160v.setText(number);
            this.f20160v.setSelection(number.length());
        } catch (IndexOutOfBoundsException unused) {
            C13981a.m83990w("AddFriendsActivity", "setSelection exception");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.add_friend_action_bar_layout, (ViewGroup) null);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(viewInflate);
        int i10 = R$string.add_friends_title;
        actionBar.setTitle(i10);
        actionBar.setHomeAsUpIndicator(getDrawable(R$drawable.ic_cancel));
        ((AutoSizeButton) C12809f.m76831d(viewInflate, R$id.action_bar_title)).setText(i10);
        viewInflate.findViewById(R$id.ic_more_hot_space).setOnClickListener(new View.OnClickListener() { // from class: xf.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f61965a.m26548Z1(view);
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (10 == i10 && -1 == i11 && intent != null) {
            try {
                Uri data = new SafeIntent(intent).getData();
                if (data == null) {
                    C13981a.m83989i("AddFriendsActivity", "contact data is empty");
                    return;
                }
                List<Contact> listM80731a = C13433a.m80731a(this, new Parcelable[]{data});
                if (listM80731a == null || listM80731a.size() == 0) {
                    C13981a.m83989i("AddFriendsActivity", "contact uris is empty");
                } else {
                    m26552e2(listM80731a);
                }
            } catch (Exception unused) {
                C13981a.m83987d("AddFriendsActivity", "onActivityResult error");
            }
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("AddFriendsActivity", "onCreate");
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        mo13327n1();
        setContentView(R$layout.location_share_add_friend);
        m26542W1();
        mo19005p1();
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("AddFriendsActivity", "onDestroy");
        Dialog dialog = this.f20156r;
        if (dialog != null) {
            dialog.dismiss();
            this.f20156r = null;
        }
        super.onDestroy();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 5 && i10 != 6) {
            return true;
        }
        m26544U1();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m26546X1();
    }
}
