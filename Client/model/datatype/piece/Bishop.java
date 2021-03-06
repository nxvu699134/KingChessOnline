package model.datatype.piece;

import java.util.ArrayList;
import model.game.Cell;
import model.game.Coordinate;

public class Bishop extends Piece
{
    public Bishop(String name, String img, int color)
    {
        super(name, img, color);
    }
    
    @Override
    public ArrayList<Cell> suggestMove(Cell[][] board, Coordinate coord)
    {
        ArrayList<Cell> res = new ArrayList<>();
        
        int row = coord.row - 1;
        int col = coord.col - 1;
        while (0 <= row && 0 <= col)
        {
            if (Check(board, res, row, col))
                break;
            --row;
            --col;
        }
        
        row = coord.row + 1;
        col = coord.col + 1;
        while (8 > row && 8 > col)
        {
            if (Check(board, res, row, col))
                break;
            ++row;
            ++col;
        }
        
        row = coord.row - 1;
        col = coord.col + 1;
        while (0 <= row && 8 > col)
        {
            if (Check(board, res, row, col))
                break;
            --row;
            ++col;
        }
        
        row = coord.row + 1;
        col = coord.col - 1;
        while (8 > row && 0 <= col)
        {
            if (Check(board, res, row, col))
                break;
            ++row;
            --col;
        }
        
        return res;
    }
    
    private boolean Check(Cell[][] board, ArrayList<Cell> res, int row, int col)
    {
        boolean isBreak = false;
        if (null == board[row][col].getPiece()) //empty cell can move
        {
            res.add(board[row][col]);
        }
        else if (board[row][col].getPiece().getColor() == this.getColor()) // cell contain your piece 
        {
            // Nothing to do
            isBreak = true;
        }
        else // cell contain opponent's piece can move
        {
            res.add(board[row][col]);
            isBreak = true;
        }
        return isBreak;
    }
}
