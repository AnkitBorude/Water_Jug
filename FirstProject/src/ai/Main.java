package ai;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEngine engine = new DFS(15);
		Jug jugs = new Jug(4, 3);//size of each jug 
		Jug.State startingState = new Jug.State(0, 0);//start state
		Jug.State goalState = new Jug.State(0,2);//goal state
		ProductionSystem system = new ProductionSystem(jugs, startingState, goalState, engine);
	}

}
