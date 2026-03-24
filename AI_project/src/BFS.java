import java.util.ArrayList;
import java.util.List;

public class BFS {
   

 public SearchResult search(Node currentNode, int fLimit) {
    // check if we got to the goal
    if (currentNode.getState().goal_State()) {
        return new SearchResult(true, currentNode, currentNode.getScore());
    }

    // children nodes
    currentNode.generateChildren();
    List<Node> childrenList = currentNode.getChildrenList();
    if (childrenList.isEmpty()) {
        return new SearchResult(false, null, Integer.MAX_VALUE);
    }

    // pack and sort children
    List<NodeWithValue> sortedChildren = new ArrayList<>();
    for (Node child : childrenList) {
        child.setScore(Math.max(child.getScore(), currentNode.getScore()));
        sortedChildren.add(new NodeWithValue(child, child.getScore()));
    }
    QuickSort sorter = new QuickSort();
    sorter.quickSort(sortedChildren, 0, sortedChildren.size() - 1);
    
    //pick best
    NodeWithValue bestChild = sortedChildren.get(0);
    System.out.println(">> CHOICE: Proceeding with -> " + bestChild.getNode().getState().getRealTimeDisplay() + " (Score: " + bestChild.getValue() + ")\n");

    //check budget
    if (bestChild.getValue() > fLimit) {
        return new SearchResult(false, null, bestChild.getValue());
    }

    return search(bestChild.getNode(),fLimit);
}
    

}

