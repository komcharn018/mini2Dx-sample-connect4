package org.mini2dx.connect4;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.graphics.Sprite;

public class BoxColourSprites {

    private static final String BOX_TILE = "box101.png";
    private Sprite boxSprite;

    BoxColourSprites()
    {
        boxSprite = Mdx.graphics.newSprite(Mdx.graphics.newTexture(Mdx.files.internal(BOX_TILE)));
    }

    Sprite getBoxSprite()
    {
        return boxSprite;
    }

}