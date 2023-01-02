package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.Rules.FigureRules.NormalFigureRuleSet;
import org.example.Client.Model.Rules.FigureRules.NotBackFigureRuleset;
import org.example.Client.Model.Rules.FigureRules.PlusFigureRuleset;
import org.example.Client.Model.SpecificModel;

public class OtherStart extends AbstractCommand{

    @Override
    public void execute(String line, Client client) {
        String arguments = line.replaceAll("(.*): /otherstart ","");
        initGame(arguments,client);
    }

    protected void initGame(String arguments, Client client){
        int numberOfRows = Integer.parseInt(arguments.substring(0,1));
        int figureRuleset = Integer.parseInt(arguments.substring(2,3));
        switch (figureRuleset){
            case 1 -> ((SpecificModel)client.model).getRules().initRules(new NotBackFigureRuleset());
            case 2 -> ((SpecificModel)client.model).getRules().initRules(new PlusFigureRuleset());
            default -> ((SpecificModel)client.model).getRules().initRules(new NormalFigureRuleSet());
        }
        ((SpecificModel)client.model).getBoard().setInit(numberOfRows);
    }
}
