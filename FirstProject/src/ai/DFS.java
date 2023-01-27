package ai;

import java.util.LinkedList;

import ai.Jug.State;
import ai.ProductionSystem.Rules;

public class DFS implements IEngine {
	LinkedList<State> stack = new LinkedList<>();
	private int maxdepth = 1;

	DFS(int maxdepth)// we need to pass maximum depth to which the DFS would go one side
	{
		this.maxdepth = maxdepth;
	}

	@Override
	public void solve(Rules rules, State initialState, State finalState) {
		State tempState;
		int counter = 0;
		stack.push(initialState);
		while (!stack.isEmpty()) {
			State cstate, costate = new State(10, 10);
			System.out.print("" + counter++);
			tempState = stack.pop();
			tempState.viewState();
			System.out.print("  At Depth " + tempState.getDepth());
			if (tempState.isEqual(finalState)) {
				System.out.println("Final State Found");
				return;
			}
			for (int i = 1; i < Rules.TOTAL_RULES; i++) {
				cstate = rules.checkRules(tempState, i);
				if (cstate == null || cstate.isEqual(initialState)) {
					continue;
				} else {
					if (!cstate.isEqual(costate)) {
						if (cstate.getDepth() <= maxdepth) {
							stack.push(cstate);
							costate = cstate;
						}
					}
				}
			}

		}
		System.out.println("Cannot Find Final State");
	}

}
