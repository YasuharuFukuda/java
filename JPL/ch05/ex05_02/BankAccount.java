package ex05_02;

public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History history = new History();

	public class Action {
		public String act;
		public long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
		public String toString() {
			return number + ": " + act + " " + amount;
		}
	}

	public class History {
		private Action[] acts = new Action[10];
		private int index = 0;

		public Action next() {
			Action act = null;
			if (index < 10)
				act = acts[index];
			index++;
			return act;
		}

		public void record(Action act) {
			for(int i = 9; i >= 1; i--){
				acts[i] = acts[i - 1];
			}
			acts[0] = act;
			index = 0;
		}
	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.record(lastAct);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdrow", amount);
		history.record(lastAct);
	}

	public History history() {
		return history;
	}

}
