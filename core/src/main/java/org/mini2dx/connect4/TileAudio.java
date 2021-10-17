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
import org.mini2Dx.core.audio.Sound;

import java.io.IOException;

public class TileAudio {

    Sound tile_fall, game_won;      // class field //

    enum SoundId {      // enum constant for Sound as SoundId
        TILE_FALL,      // 0
        GAME_WON        // 1
    }

    public TileAudio() {
        try {
            tile_fall = Mdx.audio.newSound(Mdx.files.internal("coin1.ogg"));
            game_won = Mdx.audio.newSound(Mdx.files.internal("jingles_SAX10.ogg"));
        } catch (IOException e) {               // note: IOE = Input Output Exceptions
            throw new RuntimeException(e);      // catch the error occur in the program in runtime
        }
    }

    public void play(SoundId sound) {       // play the sound effect
        switch (sound) {
            case TILE_FALL:                 // when tile fall
                tile_fall.play();
                break;
            case GAME_WON:                  // when game won
                game_won.play();
                break;
        }
    }

}
