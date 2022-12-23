package org.example.Client.Model.Rules;

import org.example.Client.Model.Tile;
import org.example.Vector2;

public interface Rules {

    void pick(Vector2 vector2, Board board);

    void put(Vector2 vector2, Board board);
}
