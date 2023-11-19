package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Ui;
import com.nicweiss.tileengine.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainMenu extends View implements UiObject.PressButtonCallback {
    public Ui ui;
    ButtonCommon[] menuButtonList;

    public MainMenu() {
        ui = new Ui(store);

        List<String[]> buttonsDescription = new ArrayList<>();
        
        buttonsDescription.add(new String[]{"Continue", "menu#loadGame"});
        buttonsDescription.add(new String[]{"New game", "menu#newGame"});
//        buttonsDescription.add(new String[]{"Settings", "menu#settings"});
//        buttonsDescription.add(new String[]{"Exit", "menu#exit"});

        menuButtonList = ui.createButtonList(buttonsDescription);

        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.registerCallBack(this);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        for (ButtonCommon menuButton : menuButtonList) { menuButton.checkTouch(fingerX, fingerY); }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (ButtonCommon menuButton : menuButtonList) { menuButton.touchOut(); }

        return false;
    }

    public void render(SpriteBatch batch) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float) 0x00 / 0xff, (float) 0x00 / 0xff, (float) 0x00 / 0xff, 1);

        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.draw(batch);
        }
    }

    @Override
    public void onPressButton(String buttonId) {
        switch (buttonId) {
            case ("menu#newGame"):
                Main.changeView(new MapMenu());
                break;
            case ("menu#loadGame"):
//                Код2;
                break;
            case ("menu#settings"):
//                Код3;
                break;
            case ("menu#exit"):
                Main.exit();
                break;
        }
//        Gdx.app.log("Debug", str);
    }
}
