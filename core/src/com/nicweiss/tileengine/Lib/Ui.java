package com.nicweiss.tileengine.Lib;

import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Generic.Store;

import java.util.HashMap;

public class Ui {
    public static Store store;

    public Ui(Store store) {
        this.store = store;
    }

    public ButtonCommon[] createButtonList(HashMap<Integer, String[]> buttonsDescription) {
        ButtonCommon button;

        int buttonsCount = buttonsDescription.size();
        int paddingsCount = buttonsCount - 1;
        int padding = 80;
        float buttonHeight = 0;
        float buttonWidth = 0;

        ButtonCommon[] buttonList = new ButtonCommon[buttonsCount];

        for (int i = 0; i < buttonsCount; i++) {
            button = new ButtonCommon(this.store);
            button.setTitle(buttonsDescription.get(i)[0]);
            button.setObjectId(buttonsDescription.get(i)[1]);

            buttonHeight = button.getHeight();
            buttonWidth = button.getWidth();
            buttonList[buttonsCount - 1 - i] = button;
        }

        float finalButtonHeight = buttonHeight + padding;
        float buttonsListContainerHeight = (buttonsCount * buttonHeight) + (paddingsCount * padding);
        float buttonsListContainerTop = (store.display.get("height") / 2) - (buttonsListContainerHeight / 2);
        float buttonsListContainerLeft = (store.display.get("width") / 2) - (buttonWidth / 2);

        float buttonPositionTop = buttonsListContainerTop;
        for (ButtonCommon buttonOfList : buttonList) {
            buttonOfList.setY(buttonPositionTop);
            buttonOfList.setX(buttonsListContainerLeft);
            buttonPositionTop = buttonPositionTop + finalButtonHeight;
        }

        return buttonList;
    }
}
