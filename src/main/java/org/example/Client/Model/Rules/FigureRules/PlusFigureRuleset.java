package org.example.Client.Model.Rules.FigureRules;

import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens.LineMove;
import org.example.Vector2;

import java.util.ArrayList;
import java.util.List;

    /**
     * figure ruleset where queens move like towers from chess
     */
    public class PlusFigureRuleset extends NormalFigureRuleSet{
    /**
     * initiates queen rules
     * @return queen ruleset
     */
    @Override
    public Figure initQueenRules() {
        List<FigureMove> queenMoves = new ArrayList<>();
        queenMoves.add(new LineMove(Vector2.plusDirections));
        return new Figure(queenMoves);
    }
}
