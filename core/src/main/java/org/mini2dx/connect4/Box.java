package org.mini2dx.connect4;
import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.graphics.Sprite;

public class Box {

    private int x, y; //co-oridinates of the tile.
    private BoxColour colour;
    private static BoxColourSprites sprites;
    private Sprite boxSprite;

    public enum BoxColour
    {
        BOX // 0
    }

    public Box(BoxColour colour)
    {
        sprites = new BoxColourSprites();
        this.setColour(colour);
    }

    public Box(int x, int y)
    {
        sprites = new BoxColourSprites();
        this.setColour(BoxColour.BOX);
        this.x = x;
        this.y = y;
    }

    public Box clone()
    {
        return new Box(this.colour);
    }

    public void render(Graphics g)
    {
        g.drawSprite(boxSprite);
    }

    public void initialise()
    {
        boxSprite.setPosition(getX(),getY());
    }

    public void update(float delta)
    {
        boxSprite.setPosition(getX(),getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BoxColour getColour()
    {
        return colour;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColour(BoxColour colour)
    {
        this.colour = colour;

        switch (colour)
        {
            case BOX:
                boxSprite = sprites.getBoxSprite();
                break;
        }
    }

}