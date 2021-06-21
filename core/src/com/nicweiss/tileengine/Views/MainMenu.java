package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Ui;
import com.nicweiss.tileengine.Main;

import java.util.HashMap;


public class MainMenu extends View implements UiObject.Callback {
    public Ui ui;
    ButtonCommon[] menuButtonList;

    public MainMenu() {
        ui = new Ui(store);

        HashMap<Integer, String[]> buttonsDescription = new HashMap();
        buttonsDescription.put(0, new String[]{"New game", "menu_newGame"});
        buttonsDescription.put(1, new String[]{"Load game", "menu_loadGame"});
        buttonsDescription.put(2, new String[]{"Settings", "menu_settings"});
        buttonsDescription.put(3, new String[]{"Exit", "menu_exit"});

        menuButtonList = ui.createButtonList(buttonsDescription);

        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.registerCallBack(this);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);

        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.checkTouch(fingerX, fingerY);
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.touchOut();
        }

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
    public void callingBack(String buttonId) {
        switch (buttonId) {
            case ("menu_newGame"):
                Main.changeView(new MapMenu());
                break;
            case ("menu_loadGame"):
//                Код2;
                break;
            case ("menu_settings"):
//                Код3;
                break;
            case ("menu_exit"):
                Main.exit();
                break;
        }
//        Gdx.app.log("Debug", str);
    }
}
