package org.example.Client.Controller.Bot;

import org.example.Client.Client;
import org.example.Client.Controller.Bot.BotMoves.BotMove;
import org.example.Client.Controller.Bot.BotMoves.BotPon;
import org.example.Client.Controller.Bot.BotMoves.BotPonSmart;
import org.example.Client.Controller.Bot.BotMoves.BotQueen;
import org.example.Client.Controller.SpecificController;
import org.example.Client.Model.SpecificModel;
import org.example.Vector2;

public class BotController extends SpecificController {
/**
 * Constructor
 *
 * @param client client
 */

    BotMove[] moves = {new BotPon(4), new BotQueen(false),new BotPonSmart(),new BotQueen(true),new BotPon(2)};

    public BotController(Client client) {
        super(client);
        BotThread botThread = new BotThread(this);
        botThread.start();
    }

    public Vector2 pickToCheckMove(Vector2 current){
        if(((SpecificModel)model).getBoard().isMine(new Vector2(current.getX(), current.getY()))
            && !((SpecificModel)model).getBoard().foundEmpty(new Vector2(current.getX(), current.getY()))) {
            client.send(": /pick " + current.getX() + " " + current.getY());
        }
        return new Vector2(current.getY()==0 ? (current.getX()+15)%8 : current.getX(),(current.getY()+15)%8);
    }

    public void put(Vector2 proposed){
        client.send(": /put " + proposed.getX() + " " + proposed.getY());
    }

    static class BotThread extends Thread{
        BotController botController;
        public BotThread(BotController botController) {
            this.botController=botController;
        }

        @Override
        public void run() {
            super.run();
            Vector2 current = new Vector2(0,0);
            int currentMove = 0;
            while (true){

                if(((SpecificModel)(botController.model)).initiated && ((SpecificModel)botController.model).isPlayerCurrent()){
                    current = botController.pickToCheckMove(current);
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if(((SpecificModel)(botController.model)).initiated && ((SpecificModel)botController.model).isPlayerCurrent()&&((SpecificModel)botController.model).getBoard().getPicked()!=null){
                    Vector2 proposed = botController.moves[currentMove].getWhereToPut(((SpecificModel) botController.model).getBoard());
                    if(proposed!=null){
                        botController.put(proposed);
                        currentMove = 0;
                        current = new Vector2(0,0);
                    } else if (current.getX()==7&&current.getY()==7)
                    {
                        currentMove=(currentMove+1)%(botController.moves.length);
                        current = new Vector2(0,0);
                        botController.put(((SpecificModel)(botController.client.model)).getBoard().getPickedPos());
                    }

                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

