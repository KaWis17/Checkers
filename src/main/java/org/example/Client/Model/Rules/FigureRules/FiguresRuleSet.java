package org.example.Client.Model.Rules.FigureRules;

/**
 * interface for specific figure ruleset
 */
public interface FiguresRuleSet{
    /**
     * initiates pon1 rules
     * @return pon1 ruleset
     */
    Figure initPon1Rules();
    /**
     * initiates pon2 rules
     * @return pon2 ruleset
     */
    Figure initPon2Rules();
    /**
     * initiates queen rules
     * @return queen ruleset
     */
    Figure initQueenRules();
}
