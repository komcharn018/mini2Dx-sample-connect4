/*
/*******************************************************************************
 * Copyright 2019 Viridian Software Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2dx.connect4;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.Texture;

public class TileColourSprites {        // constant field //

    private static final String EMPTY_TILE = "tileGrey_27.png";  // assign the variable to get the picture of the tile
    private static final String RED_TILE = "tileRed_27.png";
    private static final String BLUE_TILE = "tileBlue_27.png";
    private static final String BOX_TILE = "box101.png";
    private Sprite blueSprite, redSprite, emptySprite;
    private Sprite boxSprite;

     TileColourSprites()    // constructor //
     {
        redSprite = Mdx.graphics.newSprite(Mdx.graphics.newTexture(Mdx.files.internal(RED_TILE)));
        blueSprite = Mdx.graphics.newSprite(Mdx.graphics.newTexture(Mdx.files.internal(BLUE_TILE)));
        emptySprite = Mdx.graphics.newSprite(Mdx.graphics.newTexture(Mdx.files.internal(EMPTY_TILE)));
        boxSprite = Mdx.graphics.newSprite(Mdx.graphics.newTexture(Mdx.files.internal(BOX_TILE)));
    }

    Sprite getBlueSprite() {
        return blueSprite;
    }   // method

    Sprite getRedSprite() {
        return redSprite;
    }

    Sprite getEmptySprite() {
        return emptySprite;
    }

    Sprite getBoxSprite() { return boxSprite; }

}
