package ai;

import java.util.LinkedList;

import ai.Jug.State;
import ai.ProductionSystem.Rules;

public class BFS implements IEngine {
	LinkedList<State> queue = new LinkedList<>();

	public void solve(Rules rules, State initialState, State finalState) {
		queue.offer(initialState);// add initial state at first
		State tstate;
		int counter = 0;
		while (!queue.isEmpty()) {
			State cstate, costate = new State(10, 10);
			System.out.print("" + counter++);
			tstate = queue.poll();
			tstate.viewState();
			if (tstate.isEqual(finalState)) {
				System.out.println("Final State Found");
				return;
			}
			for (int i = 1; i <= rules.TOTAL_RULES; i++) {
				cstate = rules.checkRules(tstate, i);

				if (cstate == null || cstate.isEqual(initialState)) {
					continue;
				} else {
					if (!cstate.isEqual(costate)) {
						queue.offer(cstate);
						costate = cstate;
					}
				}
			}
		}
		System.out.println("Cannot Match State");

	}

}
