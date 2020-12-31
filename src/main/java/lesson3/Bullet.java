package lesson3;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 velocity;
    private int damage;
    private Sprite owner;

    public Bullet() {
        regions = new TextureRegion[1];
        velocity = new Vector2();
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(velocity, delta);
        if (isOutside(worldBounds)) destroy();
    }

    public void set(
            Sprite owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.velocity.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
