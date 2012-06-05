package ch06.ex06_03;

public interface Verbose {
	enum Degree { SILENT,TERSE, NORMAL, VERBORSE }

	void setVerbosity(Degree degree);
	int getVerbosity();
}
