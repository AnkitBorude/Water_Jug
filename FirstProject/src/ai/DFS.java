package ai;

import java.util.LinkedList;

import ai.Jug.State;
import ai.ProductionSystem.Rules;

public class DFS implements IEngine{
	LinkedList<State> stack = new LinkedList<>();
	@Override
	public void solve(Rules rules, State initialState, State finalState) {
		State tempState;
		int depth=0;
		stack.push(initialState);
		while(!stack.isEmpty())
		{
			State cstate,costate=new State(10,10);
			tempState=stack.pop();
			depth++;
			tempState.viewState();
			if (tempState.isEqual(finalState)) {
				System.out.println("Final State Found");
				return;
			}
			for(int i=1;i<Rules.TOTAL_RULES;i++)
			{
				cstate=rules.checkRules(tempState, i);
				if (cstate == null || cstate.isEqual(initialState)) {
					continue;
				} else {
					if (!cstate.isEqual(costate) || depth<5) {//HANDLING REDUDNDANT CASE
						stack.push(cstate);
						costate = cstate;
					}
				}
			}
			
		}
		System.out.println("Cannot Find Final State");
	}

}
