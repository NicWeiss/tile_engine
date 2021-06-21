package com.nicweiss.tileengine.Components.Ui;

import com.nicweiss.tileengine.Generic.BaseObject;
import com.nicweiss.tileengine.Generic.Store;

public class UiObject extends BaseObject {
    public String title;
    public static Store store;

    public interface Callback {
        void callingBack(String str);
    }

    public Callback callback;

    public void registerCallBack(Callback callback) {
        this.callback = callback;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
