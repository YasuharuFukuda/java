package ex07_03;

public class Pascal {
	private int depth;
	private int[][] values;

	public Pascal(int depth) {
		this.depth = depth;
		values = new int[depth][];
		for(int i = 0,j = 0; i < values.length; i++){
			values[i] = new int[i+1];
			values[i][j] = 1;
			values[i][i] = 1;
		}
		createValues();
	}

	public int[][] createValues() {
		for(int i = 2;i < values.length; i++)
			for(int j = 1; j < values[i].length-1; j++)
				values[i][j] = values[i-1][j-1] + values[i-1][j];
		return values;
	}

	public void show() {
		for(int i = 0; i < depth; i++) {
			for(int j = 0; j < values[i].length; j++) {
				System.out.print(values[i][j] + ",");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Pascal p = new Pascal(12);
		p.show();
	}
}
