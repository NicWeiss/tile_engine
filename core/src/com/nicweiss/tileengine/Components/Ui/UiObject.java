package com.nicweiss.tileengine.Components.Ui;

import com.nicweiss.tileengine.Generic.BaseObject;
import com.nicweiss.tileengine.Generic.Store;

public class UiObject extends BaseObject {
    public String title;
    public static Store store;

    public interface PressButtonCallback {
        void onPressButton(String str);
    }

    public PressButtonCallback pressButtonCallback;

    public void registerCallBack(PressButtonCallback pressButtonCallback) {
        this.pressButtonCallback = pressButtonCallback;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
