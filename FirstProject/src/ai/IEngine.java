package ai;

public interface IEngine {
	void solve(ProductionSystem.Rules rules, Jug.State initialState, Jug.State finalState);
}
