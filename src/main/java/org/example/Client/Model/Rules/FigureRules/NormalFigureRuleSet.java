package org.example.Client.Model.Rules.FigureRules;

import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonAttack;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon.PonMove;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens.LineMove;
import org.example.Vector2;

import java.util.ArrayList;
import java.util.List;

    /**
     * normal figure ruleset
     */
    public class NormalFigureRuleSet implements FiguresRuleSet{

    /**
     * initiates pon1 rules
     * @return pon1 ruleset
     */
    @Override
    public Figure initPon1Rules() {
        List<FigureMove> pon1Moves = new ArrayList<>();
        pon1Moves.add(new PonAttack(new Vector2[]{new Vector2(2,2),new Vector2(2,-2),new Vector2(-2,-2),new Vector2(-2,2)}));
        pon1Moves.add(new PonMove(new Vector2[]{new Vector2(1,1),new Vector2(1,-1)}));
        return new Figure(pon1Moves);
    }

    /**
     * initiates pon2 rules
     * @return pon2 ruleset
     */
    @Override
    public Figure initPon2Rules() {
        List<FigureMove> pon2Moves = new ArrayList<>();
        pon2Moves.add(new PonAttack(new Vector2[]{new Vector2(2,2),new Vector2(2,-2),new Vector2(-2,-2),new Vector2(-2,2)}));
        pon2Moves.add(new PonMove(new Vector2[]{new Vector2(-1,-1),new Vector2(-1,1)}));
        return new Figure(pon2Moves);
    }

    /**
     * initiates queen rules
     * @return queen ruleset
     */
    @Override
    public Figure initQueenRules() {
        List<FigureMove> queenMoves = new ArrayList<>();
        queenMoves.add(new LineMove(Vector2.crossDirections));
        return new Figure(queenMoves);
    }
}
