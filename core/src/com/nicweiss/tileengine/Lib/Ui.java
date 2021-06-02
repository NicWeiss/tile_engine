package com.nicweiss.tileengine.Lib;

import com.badlogic.gdx.Gdx;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Generic.Store;

public class Ui {
    public static Store store ;

    public void init(Store store){
        this.store = store;
    }
    public ButtonCommon createButton(String title){
        ButtonCommon button = new ButtonCommon();
        button.init();
        return button;
    }

    public ButtonCommon[] createButtonList(String[][] buttonsData){
        ButtonCommon button;
        
        int buttonsCount = buttonsData.length;
        int paddingsCount = buttonsCount -1;
        int padding = 80;
        float buttonHeight = 0;
        float buttonWidth = 0;
        
        ButtonCommon[] buttonList = new ButtonCommon[buttonsCount];

        for (int i = 0; i < buttonsCount ; i ++){
            button = new ButtonCommon();
            button.init();
            button.setTitle(buttonsData[i][0]);
            button.setObjectId(buttonsData[i][1]);
            
            buttonHeight = button.getHeight();
            buttonWidth = button.getWidth();
            buttonList[buttonsCount -1 - i] = button;
        }

        float finalButtonHeight = buttonHeight + padding;
        float buttonsListContainerHeight = (buttonsCount * buttonHeight) + (paddingsCount * padding);
        float buttonsListContainerTop = (store.display.get("height") / 2) - (buttonsListContainerHeight / 2);
        float buttonsListContainerLeft = (store.display.get("width") / 2) - (buttonWidth / 2);

        float buttonPositionTop = buttonsListContainerTop;
        for (ButtonCommon buttonOfList: buttonList) {
            buttonOfList.setY(buttonPositionTop);
            buttonOfList.setX(buttonsListContainerLeft);
            buttonPositionTop = buttonPositionTop + finalButtonHeight;
        }


        return buttonList;
    }
}
