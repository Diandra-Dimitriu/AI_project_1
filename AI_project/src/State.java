public class State {
    private int C;
    private int M;
    private String boat;

    public State(int C, int M, String boat) {
        this.C = C;
        this.M = M;
        this.boat = boat;
    }

    public boolean goal_State()
    {
        if( C == 0 && M == 0 && boat.equals("R") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public int getC() {
        return C;
    }
    public int getM() {
        return M;
    }
    public String getBoat() {
        return boat;
    }


    public void move(int c, int m)
    {
        if ( c + m > 2 || c + m < 1 )
        {
            System.out.println("Invalid move");
            return;
        }

        if(boat.equals("L"))
        {
            C -= c;
            M -= m;
            boat = "R";
            //System.out.println("Move: " + c + " cannibals and " + m + " missionaries to the right bank.");
        }
        else
        {
            C += c;
            M += m;
            boat = "L";
           //System.out.println("Move: " + c + " cannibals and " + m + " missionaries to the left bank.");
        }
    }

public boolean isValid() {

    if (C < 0 || C > 3 || M < 0 || M > 3) {
        return false;
    }
    
    
    boolean leftSafe = (M == 0 || M >= C);
    
   
    int rightC = 3 - C;
    int rightM = 3 - M;
    boolean rightSafe = (rightM == 0 || rightM >= rightC);
    
    return leftSafe && rightSafe;
}

public String getRealTimeDisplay() {
        int rightC = 3 - C;
        int rightM = 3 - M;
        return "[Left: " + C + "C, " + M + "M | Boat: " + boat + " | Right: " + rightC + "C, " + rightM + "M]";
    }

    //to make sure progress is made
@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return C == state.C && M == state.M && boat.equals(state.boat);
    }

}
