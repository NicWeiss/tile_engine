package com.nicweiss.tileengine.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.nicweiss.tileengine.Generic.BaseObject;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {
    private BaseObject[] fontImages;
    float fontScale = (float) 0.14;
    private BitmapFont font;
    String text = "";
    GlyphLayout layout;

    public Font() {
        this(100, Color.BLACK);
    }

    public Font(int size, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/Roboto-Medium.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (size * 4.5);
        parameter.color = color;
        parameter.characters = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" +
                "!\"#$%&\\'()*+,-./:;<=>?@[\\\\]^_`{|}~абвгдеёжзийклмнопрстуфхчшщъьыэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЧШЩЪЬЫЭЮЯ";
        font = generator.generateFont(parameter);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void setText(String newText) {
        text = newText;
        layout = new GlyphLayout(font, text);
    }

    public float getWidth() {
        return layout.width;
    }

    public float getHeight() {
        return layout.height;
    }

    public void draw(Batch batch, String ttl, float x, float y) {
        float previousWidth = x;
        font.draw(batch, text, x, y);
    }
}
