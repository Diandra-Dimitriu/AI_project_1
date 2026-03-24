import java.util.ArrayList;
import java.util.List;

public class Node {
    private int layer;
    private Node parent;
    private State state;
    private int guess;
    private int score;
    private List<Node> children = new ArrayList<>();

    public Node(int layer, State state) {
        this.layer = layer;
        this.parent = null;
        this.state = state;

        int peopleOnLeft = this.state.getC() + this.state.getM();
        int boatModifier = this.state.getBoat().equals("R") ? 1 : 0;
        this.guess = (peopleOnLeft * 2) - boatModifier;
        this.score=this.guess+this.layer;
        System.out.println("Initial score: " + score);
        System.out.println("Initial guess: " + guess);
        System.out.println("Initial layer: " + layer);
    }

    public int getLayer() {
        return layer;
    }
    public int getGuess() {
        return guess;
    }
    public int getScore() {
        return score;
    }
    public Node getParent() {
        return parent;
    }
    public State getState() {
        return state;
    }
    public List<Node> getChildrenList() {
    return children;
}


    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setScore(int score) {
        this.score = score;
    }


    public void generateChildren() {
        int possibilityCount = 1; // start counter for display
        System.out.println("Evaluating moves from " + this.state.getRealTimeDisplay() + "...");

        for (int c = 0; c <= 2; c++) {
            for (int m = 0; m <= 2; m++) {
                if (c + m >= 1 && c + m <= 2) {
                    State newState = new State(state.getC(), state.getM(), state.getBoat());
                    newState.move(c, m);
                    
                    if (newState.isValid()) {
                        if (this.parent != null && newState.equals(this.parent.getState())) {
                            continue; // makes sure the move doesnt undo what parent did
                        }

                        //display
                        String direction = state.getBoat().equals("L") ? "Right" : "Left";
                        
                        System.out.println("  Possibility_" + possibilityCount + ": Move " + c + "C, " + m + "M to " + direction + " -> " + newState.getRealTimeDisplay());
                        possibilityCount++;
                        //--

                        Node childNode = new Node(layer + 1, newState);
                        childNode.setParent(this);
                        children.add(childNode); 
                    }
                }
            }
        }
    }


}
