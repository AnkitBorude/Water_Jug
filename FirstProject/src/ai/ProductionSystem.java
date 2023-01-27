package ai;

class ProductionSystem {
	Jug jug;
	Jug.State initialState, finalState;
	Rules rules;

	public ProductionSystem(Jug jugs, Jug.State initialstate, Jug.State finalstate, IEngine solver) {
		this.jug = jugs;
		this.initialState = initialstate;
		this.finalState = finalstate;
		rules = new Rules();
		solver.solve(rules, initialState, finalState);
	}

	class Rules {
		static final int TOTAL_RULES = 8;

		public Jug.State checkRules(Jug.State state, int rule_no) {
			switch (rule_no) {
			case 1:
				if (state.getCurrentJug1State() < Jug.Jug1MaxSize) {
					return new Jug.State(Jug.Jug1MaxSize, state.getCurrentJug2State(),state.getDepth()+1);// fill the x
				} else {
					return null;
				}
			case 2:
				if (state.getCurrentJug2State() < Jug.Jug2MaxSize) {
					return new Jug.State(state.getCurrentJug1State(), Jug.Jug2MaxSize,state.getDepth()+1);// fill the y
				} else {
					return null;
				}
			case 3:
				if (state.getCurrentJug1State() > 0) {
					return new Jug.State(0, state.getCurrentJug2State(),state.getDepth()+1);// fill the x
				} else {
					return null;
				}
			case 4:
				if (state.getCurrentJug2State() > 0) {
					return new Jug.State(state.getCurrentJug1State(), 0,state.getDepth()+1);// fill the x
				} else {
					return null;
				}
			case 5:
				if (state.getCurrentJug2State() > 0 && (state.getSum() >= jug.getJug1MaxSize())) {
					return new Jug.State(jug.getJug1MaxSize(),
							state.getCurrentJug2State() - (jug.getJug1MaxSize() - state.getCurrentJug1State()),state.getDepth()+1);
				} else {
					return null;
				}
			case 6:
				if (state.getCurrentJug1State() > 0 && (state.getSum() >= jug.getJug2MaxSize())) {
					return new Jug.State(
							state.getCurrentJug1State() - (jug.getJug2MaxSize() - state.getCurrentJug2State()),
							jug.getJug2MaxSize(),state.getDepth()+1);
				} else {
					return null;
				}
			case 7:
				if (state.getCurrentJug2State() > 0 && (state.getSum() <= jug.getJug1MaxSize())) {
					return new Jug.State(state.getSum(), 0,state.getDepth()+1);
				} else {
					return null;
				}
			case 8:
				if (state.getCurrentJug1State() > 0 && (state.getSum() <= jug.getJug2MaxSize())) {
					return new Jug.State(0, state.getSum(),state.getDepth()+1);
				} else {
					return null;
				}
			default:
				return null;
			}
		}
	}
}
