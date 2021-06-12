package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Font;
import com.nicweiss.tileengine.Lib.Ui;

import java.util.ArrayList;
import java.util.HashMap;


public class MainMenu extends View implements UiObject.Callback {

    public Ui ui;

    ButtonCommon[] menuButtonList;
    private Font fontTitle;
    private String someText;

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

        fontTitle = new Font(14, Color.WHITE);
        fontTitle.setText("");
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

        someText = "";
        fontTitle.setText("");
        return false;
    }

    public void log(String message) {
    }

    public void render(SpriteBatch batch) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float) 0x00 / 0xff, (float) 0x00 / 0xff, (float) 0x00 / 0xff, 1);

        for (ButtonCommon menuButton : menuButtonList) {
            menuButton.draw(batch);
        }

        fontTitle.draw(batch, someText, 0, 100);
    }

    @Override
    public void callingBack(String str) {
        someText = str;
        fontTitle.setText(someText);
        Gdx.app.log("Debug", str);
    }
}
