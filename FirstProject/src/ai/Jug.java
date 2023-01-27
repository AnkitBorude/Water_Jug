package ai;

//djd
class Jug {
	static int Jug1MaxSize;
	static int Jug2MaxSize;

	Jug(int maxJ1, int maxj2) {
		Jug1MaxSize = maxJ1;
		Jug2MaxSize = maxj2;
	}

	public int getJug2MaxSize() {
		return Jug2MaxSize;
	}

	public void setJug2MaxSize(int jug2MaxSize) {
		Jug2MaxSize = jug2MaxSize;
	}

	public void setJug1MaxSize(int jug1MaxSize) {
		Jug1MaxSize = jug1MaxSize;
	}

	public int getJug1MaxSize() {
		return Jug1MaxSize;
	}

	static class State {
		private int currentJug1State = 0, currentJug2State = 0;
		private int depth = 0;

		State(int a, int b) {
			currentJug1State = a;
			currentJug2State = b;
		}

		State(int a, int b, int depth) {
			currentJug1State = a;
			currentJug2State = b;
			this.setDepth(depth);
		}

		public void viewState() {
			System.out.println("<" + this.currentJug1State + "," + this.currentJug2State + ">");
		}

		public int getSum() {
			return currentJug1State + currentJug2State;

		}

		public int getCurrentJug1State() {
			return currentJug1State;
		}

		public void setCurrentJug1State(int currentJug1State) {
			this.currentJug1State = currentJug1State;
		}

		public int getCurrentJug2State() {
			return currentJug2State;
		}

		public void setCurrentJug2State(int currentJug2State) {
			this.currentJug2State = currentJug2State;
		}

		public boolean isEqual(State state) {
			return (state.getCurrentJug1State() == this.currentJug1State
					&& state.getCurrentJug2State() == this.getCurrentJug2State());
		}

		public void getMax() {
			System.out.println(Jug.Jug1MaxSize);
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}
	}
}
