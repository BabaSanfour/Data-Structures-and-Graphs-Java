import java.util.ArrayList;
import java.util.List;

public class Grid {
    public class Cell {
        public int value;
        public Cell left;
        public Cell top;
        public Cell right;
        public Cell bottom;
        
        public Cell(int value) {
            this.value = value;
            this.left = null;
            this.top = null;
            this.right = null;
            this.bottom = null;
        }
    }
    // A variable Grid: list of 12 cell
    public List<Cell> grid;
    public Grid() {
        grid = new ArrayList<Cell>();
        
        Cell cell1 = new Cell(25);
        grid.add(cell1);
        Cell cell2 = new Cell(10);
        grid.add(cell2);
        Cell cell3 = new Cell(1);
        grid.add(cell3);
        Cell cell4 = new Cell(10);
        grid.add(cell4);
        Cell cell5 = new Cell(1);
        grid.add(cell5);
        Cell cell6 = new Cell(5);
        grid.add(cell6);
        Cell cell7 = new Cell(5);
        grid.add(cell7);
        Cell cell8 = new Cell(10);
        grid.add(cell8);
        Cell cell9 = new Cell(1);
        grid.add(cell9);
        Cell cell10 = new Cell(10);
        grid.add(cell10);
        Cell cell11 = new Cell(1);
        grid.add(cell11);
        Cell cell12 = new Cell(-1);
        grid.add(cell12);

        // cell 1
        cell1.right = cell2;
        cell1.bottom = cell5;
        // cell 2
        cell2.left = cell1;
        cell2.right = cell3;
        cell2.bottom = cell6;
        // cell 3
        cell3.left = cell2;
        cell3.right = cell4;
        cell3.bottom = cell7;
        // cell 4
        cell4.left = cell3;
        cell4.bottom = cell8;
        // cell 5
        cell5.top = cell1;
        cell5.right = cell6;
        cell5.bottom = cell9;
        // cell 6
        cell6.left = cell5;
        cell6.top = cell2;
        cell6.right = cell7;
        cell6.bottom = cell10;
        // cell 7
        cell7.left = cell6;
        cell7.top = cell3;
        cell7.right = cell8;
        cell7.bottom = cell11;
        // cell 8
        cell8.left = cell7;
        cell8.top = cell4;
        cell8.bottom = cell12;
        // cell 9
        cell9.top = cell5;
        cell9.right = cell10;
        // cell 10
        cell10.left = cell9;
        cell10.top = cell6;
        cell10.right = cell11;
        // cell 11
        cell11.left = cell10;
        cell11.top = cell7;
        cell11.right = cell12;
        // cell 12
        cell12.left = cell11;
        cell12.top = cell8;

    }
    public boolean move(Cell box){
        if (box.left!= null)
        {
            if (box.left.value == -1) // move box to left
            {
                box.left.value = box.value;
                box.value = -1;
                return true;
            }
        }
        if (box.top!= null)
        {
            if (box.top.value == -1) // move box to top   
            {
                box.top.value = box.value;
                box.value = -1;
                return true;
            }
        }
        if  (box.right!= null)
        {
            if (box.right.value == -1) // move box to right   
            {
                box.right.value = box.value;
                box.value = -1;
                return true;
            }
        }
        if  (box.bottom!= null)
        {
            if (box.bottom.value == -1) // move box to bottom   
            {
                box.bottom.value = box.value;
                box.value = -1;
                return true;
            }
        }
        return false;
    }

    public boolean check_complete(){
        if ( // the bottom and top of cell 5,6,7,8 are the same then its solved
            grid.get(4).top.value == grid.get(4).bottom.value ||
            grid.get(5).top.value == grid.get(5).bottom.value ||
            grid.get(6).top.value == grid.get(6).bottom.value ||
            grid.get(7).top.value == grid.get(7).bottom.value
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void solve_game(){
        // move 10 in case 8 down
        move(grid.get(7));
        // move the 2 fives left
        move(grid.get(6));
        move(grid.get(5));
        // start rotating cell 5,6,7, 9,10,11
        move(grid.get(4));
        int iter = 4;
        while (iter!=0){
            move(grid.get(8));
            move(grid.get(9));
            move(grid.get(10));
            move(grid.get(6));
            move(grid.get(5));
            move(grid.get(4));
            iter--;
        }
        // left row done
        //  rotate cell 6,7,8, 4,3,2 
        move(grid.get(5));
        move(grid.get(6));
        move(grid.get(7));
        move(grid.get(3));
        move(grid.get(2));
        move(grid.get(1));
        //  move first cell 
        move(grid.get(0));
        //  move cell 5 and 6 
        move(grid.get(4));
        move(grid.get(5));
        iter = 1;
        while (iter!=0){
            move(grid.get(6));
            move(grid.get(7));
            move(grid.get(3));
            move(grid.get(2));
            move(grid.get(1));
            move(grid.get(5));
            iter--;
        }
        // move 5 to its place
        move(grid.get(4));
        move(grid.get(0));
        move(grid.get(1));
        // fix loop
        move(grid.get(6));
        iter = 1;
        while (iter!=0){
            move(grid.get(6));
            move(grid.get(7));
            move(grid.get(3));
            move(grid.get(2));
            move(grid.get(1));
            move(grid.get(5));
            iter--;
        }
        // move 5 to its place
        move(grid.get(6));
        move(grid.get(2));
        move(grid.get(1));
        // fix loop
        move(grid.get(5));
        iter = 1;
        while (iter!=0){
            move(grid.get(6));
            move(grid.get(7));
            move(grid.get(3));
            move(grid.get(2));
            move(grid.get(1));
            move(grid.get(5));
            iter--;
        }
        // move 10 to its place
        move(grid.get(6));
        move(grid.get(2));
        move(grid.get(1));
        // fix loop
        move(grid.get(5));

        // solved but nake it exactly as asked in devoir
        move(grid.get(6));

    
    }

        public static void main(String[] args) {
            Grid grid = new Grid();
            grid.solve_game();
            System.out.println(grid.check_complete());
        }
}