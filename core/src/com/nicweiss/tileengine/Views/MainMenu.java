package com.nicweiss.tileengine.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nicweiss.tileengine.Components.Ui.Buttons.ButtonCommon;
import com.nicweiss.tileengine.Components.Ui.UiObject;
import com.nicweiss.tileengine.Generic.View;
import com.nicweiss.tileengine.Lib.Ui;
import com.nicweiss.tileengine.Main;


public class MainMenu extends View implements UiObject.Callback {

    public Ui ui;

    ButtonCommon newGameButton;

    public void init(){
        ui = new Ui();
        newGameButton = ui.createButton("Button success");
        newGameButton.registerCallBack(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        newGameButton.checkTouch(fingerX, fingerY);

        return false;
    }

    public void log(String message){
    }

    public void render(SpriteBatch batch) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor((float) 0x00 / 0xff, (float) 0x00 / 0xff, (float) 0x00 / 0xff, 1);
        newGameButton.draw(batch);
    }

    @Override
    public void callingBack(String str) {
        Gdx.app.log("Debug",str);
    }
}
