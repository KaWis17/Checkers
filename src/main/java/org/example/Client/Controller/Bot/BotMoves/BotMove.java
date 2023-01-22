package org.example.Client.Controller.Bot.BotMoves;

import org.example.Client.Model.Board.Board;
import org.example.Vector2;

public abstract class BotMove {
    public abstract Vector2 getWhereToPut(Board board);
}
