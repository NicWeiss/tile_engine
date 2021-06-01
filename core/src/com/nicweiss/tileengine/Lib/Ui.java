package com.nicweiss.tileengine.Lib;

import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;

public class Ui {
    public ButtonCommon createButton(String title){
        ButtonCommon button = new ButtonCommon();
        button.init();
        return button;
    }
}
