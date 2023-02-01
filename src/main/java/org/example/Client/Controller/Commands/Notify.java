package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Board.Tile;

public class Notify extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        String board = (((SpecificModel)client.model).getBoard().printBoard());
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Tile tile = ((Tile)client.view.download(1).download(2).download(i*8+j));
                int location = ((i * 8) + j) * 4 + i;
                char color = board.charAt(location +1);
                int state = Character.getNumericValue(board.charAt(location +2));
                boolean picked = board.charAt(location)=='{';
                boolean possible = board.charAt(location)=='<';
                tile.setColor(color);
                if(picked) tile.setColor('y');
                else if(possible) tile.setColor('g');
                tile.setState(state);
            }
        }
    }
}
