public class SearchResult {
    public boolean isGoalFound;
    public Node finalNode;
    public int updatedF; 

    public SearchResult(boolean isGoalFound, Node finalNode, int updatedF) {
        this.isGoalFound = isGoalFound;
        this.finalNode = finalNode;
        this.updatedF = updatedF;
    }
}