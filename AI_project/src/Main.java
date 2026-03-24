import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    
        System.out.println("Starting Missionaries and Cannibals RBFS...");

        State initialState = new State(3, 3, "L");
        Node root = new Node(0, initialState);

        //f limit
       int startingLimit = 1000;

        BFS solver = new BFS();
        SearchResult result = solver.search(root, startingLimit);

        if (result.isGoalFound) {
            System.out.println("\n--- SUCCESS! ---");
            printPath(result.finalNode);
        } else {
            System.out.println("\n--- FAILED ---");
            System.out.println("No solution found, or budget exceeded.");
        }
    }

    private static void printPath(Node finalNode) {
        List<Node> path = new ArrayList<>();
        Node current = finalNode;

        while (current != null) {
            path.add(current);
            current = current.getParent();
        }

        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            State s = path.get(i).getState();
            System.out.println("Step " + i + ": Left Bank -> " + 
                               s.getC() + "C, " + s.getM() + "M | Boat: " + s.getBoat());
        }
    }
}