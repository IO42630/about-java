package examples;

import java.util.Random;
import java.nio.file.*;


public class Sudoku {

    int[][] numbers;
    boolean[][] presets;
    int[] order;

    public Sudoku() {
        numbers = new int[9][9];
        presets = new boolean[9][9];
        order = new int[81];
	for (int i=0; i<81; i++) {
	    order[i] = i;
        }
    }

    // Copy Constructor
    public Sudoku(Sudoku orig) {
	this();
	for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                this.order[r*9+c] = orig.order[r*9+c];
		this.numbers[r][c] = orig.numbers[r][c];
		this.presets[r][c] = orig.presets[r][c];
            }
        }
    }

    public Sudoku(String s) {
        this();
        if (s.length()!=81) {
            throw new IllegalArgumentException("String must be of length 81");
        }
        for (int i=0; i<81; i++) {
            char c = s.charAt(i);
            if (c>='1' && c<='9') {
                numbers[i/9][i%9] = c-'0';
                presets[i/9][i%9] = true;
            }  
        }
    }

    // Reshuffle the existing order Array
    public void shuffleOrder(Random rand) {
        // Swap every position with a random position from that position on
        for (int i=0; i<80; i++) {
            int j = rand.nextInt(81-i)+i;
            // swap i <-> j
            int h = order[i];
            order[i] = order[j];
            order[j] = h;
        }
    }


    public boolean isEmpty(int r, int c) {
        if (r<0 || r>8 || c<0 || c>8) {
            return false;
        }
        return (numbers[r][c]==0);
    }

    public boolean isGiven(int r, int c) {
        if (r<0 || r>8 || c<0 || c>8) {
            return true;
        }
        return presets[r][c];
    }

    public int getValue(int r, int c) {
        if (r<0 || r>8 || c<0 || c>8) {
            return 0;
        }
        return numbers[r][c];
    }

    public void setValue(int r, int c, int v) {
        if ((!isGiven(r,c)) && isEmpty(r,c) && v>=1 && v<=9) {
            numbers[r][c] = v;
        }
    }

    public void clearValue(int r, int c) {
        if (!isGiven(r,c)) {
            numbers[r][c] = 0;
        }
    }

    private boolean existsInRow(int r, int v) {
        if (v<1 || v>9 || r<0 || r>8) {
            return false;
        }
        for (int c=0; c<9; c++) {
            if (numbers[r][c]==v) {
                return true;
            }
        }
        return false;
    }

    private boolean existsInColumn(int c, int v) {
        if (v<1 || v>9 || c<0 || c>8) {
            return false;
        }
        for (int r=0; r<9; r++) {
            if (numbers[r][c]==v) {
                return true;
            }
        }
        return false;
    }

    private boolean existsInSquare(int r, int c, int v) {
        if (v<1 || v>9 || r<0 || c<0 || r>6 || c>6 || (r%3!=0) || (c%3!=0)) {
            return false;
        }
        for (int dr=0; dr<3; dr++) {
            for (int dc=0; dc<3; dc++) {
                if (numbers[r+dr][c+dc]==v) {
                    return true;
                }
            }
        }
        return false;
    }

    // Calculer le nombre de possibilites pour la case r,c
    private int getScore(int r, int c) {
        if (isGiven(r,c) || getValue(r,c)>0) {
            return 0;
        }
        int num = 0;
        // Compter les possibilites
	for (int v=1; v<=9; v++) {
            if (canSetValue(r,c,v)) {
                num++;
            }
        }
	return num;
    }

    private void computeOrder(int startPos) {
        int[] score = new int[81];
        for (int p=startPos; p<81; p++) {
            int r = order[p]/9;
	    int c = order[p]%9;
            score[p] = getScore(r,c);
        }
        // Tri
        for (int s=0; s<9; s++) {
            for (int p=startPos; p<81; p++) {
                if (score[p]==s) {
                   // echanger order[p] et order[startPos]
                   int h = order[p];
                   order[p] = order[startPos];
                   order[startPos] = h;
                   // echanger score
                   h = score[p];
                   score[p] = score[startPos];
		   score[startPos] = h;
                   startPos++;
                }
            }
        }


    }

    public boolean canSetValue(int r, int c, int v) {
        return (!isGiven(r,c)) && (!existsInRow(r,v)) && 
               (!existsInColumn(c,v)) && (!existsInSquare(r-r%3, c-c%3,v));
    }

    public Sudoku[] numSolve() {
	Sudoku sol1 = this.solve(0);
        if (sol1==null) {
           return new Sudoku[0];
        }
        Sudoku sol2 = sol1.solve(80);
        if (sol2 == null) {
           return new Sudoku[] {sol1};
        }
        return new Sudoku[] { sol1, sol2 };
    }
    
    public Sudoku solve(int startPos) {
	Sudoku copy = new Sudoku(this);
        int p = startPos;
        boolean forward = true;
        copy.computeOrder(p);
        while (p>=0 && p<=80) {
            //System.out.println(copy);
	    //System.out.flush();
            int r = copy.order[p]/9;
            int c = copy.order[p]%9;
            if (copy.isGiven(r,c)) {  // Etat 1
	        if (forward) {
		    p++;
		} else {
                    p--;
                }
            } else { // Etat 2
		int v = copy.getValue(r,c)+1;
		while (v<10 && !copy.canSetValue(r,c,v)) {
		    v++;
                }
                if (v<10) { // Nouveau nombre existe
		    copy.clearValue(r,c);
                    copy.setValue(r,c,v);
                    forward = true;
                    p++;
                    copy.computeOrder(p);
                } else {  // plus de nombre possible
                    copy.clearValue(r,c);
		    forward = false;
                    p--;
                }
            }
        }
	if (p<0) {
            return null;
        } else {
            return copy;
        }
    }


    public String toString() {
        String sep = separation('-');
        String sepbold = separation('=');
        String line = line();
        StringBuilder all = new StringBuilder(sep);
        for (int i=0; i<9; i++) {
            StringBuilder l = new StringBuilder(line);
            for (int j=0; j<9; j++) {
                if (numbers[i][j]>=1 && numbers[i][j]<=9) {
                    l.setCharAt(j*4+2,((char)(numbers[i][j]+'0')));
                    if (presets[i][j]) {
                        l.setCharAt(j*4+1,'<');
                        l.setCharAt(j*4+3,'>');
                    }
                }
            }
            all.append(l);
            if (i%3==2 && i<8) {
                all.append(sepbold);
            } else {
                all.append(sep);
            }
        }
        return all.toString();
    }

   	private static String separation(char kind) {
        StringBuilder sep = new StringBuilder("+");
        for (int i=0; i<9; i++) {
            sep.append(kind).append(kind).append(kind);
            if (i%3==2 && i<8) {
                if (kind=='-') {
                    sep.append("H");
                } else {
                    sep.append("#");
                }
            } else {
                sep.append("+");
            }
        }
        return sep.append("\n").toString();
    }

    private static String line() {
        StringBuilder line = new StringBuilder("|");
        for (int i=0; i<9; i++) {
            line.append("   ");
            if (i%3==2 && i<8) {
                line.append("H");
            } else {
                line.append("|");
            }
        }
        return line.append("\n").toString();
    }
 
    public void clearNonGiven() {
	for (int r=0; r<9; r++) {
	   for (int c=0; c<9; c++) {
              if (!presets[r][c]) {
                  numbers[r][c] = 0;
              }
           }
        }
    }

    public static Sudoku generate() {
        
        Random random = new Random();
        Sudoku s = new Sudoku();
        s.shuffleOrder(random);
        s = s.solve(0);
	for (int i=0; i<17; i++) {
	    int p = random.nextInt(81);
            s.presets[p/9][p%9] = true;
        }
        while (true) {
           s.clearNonGiven();
           Sudoku[] solutions = s.numSolve();
	   if (solutions.length==1) {
              return s;
           }
           // Abuser de order:
           s.shuffleOrder(random);
           for (int p=0;p<80; p++) {
               int r = s.order[p]/9;
               int c = s.order[p]%9;
               if (solutions[0].numbers[r][c] != solutions[1].numbers[r][c]) {
                   s.presets[r][c] = true;
                   s.numbers[r][c] = solutions[random.nextInt(2)].numbers[r][c];
                   break;
               }
           }
        }  
    }
    
 public void stringToHTML()	{
    StringBuilder sb = new StringBuilder(); 
	sb.append("<!DOCTYPE HTML><html><head><title>out</title><link rel=\"stylesheet\" href=\"out.css\"></head><body>");
	sb.append("<div class=\"page\">");
	sb.append("<table class=\"t\">");
	sb.append("<tbody>");
	for (int i=0;i<9;i++)	{
		sb.append("<tr>");
		for (int j=0;j<9;j++)	{
			if (isGiven(i,j)==false)	{
				sb.append("<td ><input class=\"n\"> </input></td>");
			}
			else	{
				sb.append("<td >");
				sb.append(numbers[i][j]);
				sb.append("</td>");
			}
			 		
		}
		
		sb.append("</tr>");
		sb.append("</br>");
	}
	sb.append("</tbody>");
	sb.append("</table>");
	sb.append("</div>");
	sb.append("</body></html>");
	String sbb = sb.toString();
    Path path = Paths.get("out.html");
    try {
        Files.write(path, sbb.getBytes(),  StandardOpenOption.CREATE);
    } catch (Exception e) {
        System.out.format("Sorry, something went wrong:%n%s",e);
    }
}
    
    public static void stringToFile(String in)	{
        Path path = Paths.get("out.txt");
        try {
            Files.write(path, in.getBytes(), StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.format("Sorry, something went wrong:%n%s",e);
        }
    }

    public static void main(String[] args) {
        Sudoku s = generate();
        System.out.println(s);
        stringToFile(s.toString());
        s.stringToHTML();
    }


}




 
class SudokuS {				

	private int[][] sudoku;
	private boolean[][] given;
	private int [] line;
	private Object[][] numbers;
	private Object[][] presets;
	private Object[] order;
	
	public SudokuS()	{
		sudoku = new int [9][9];
    	given = new boolean [9][9];
    	line = new int [81];	
	}
	public SudokuS(Sudoku orig) {
	this();
	for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                this.order[r*9+c] = orig.order[r*9+c];
		this.numbers[r][c] = orig.numbers[r][c];
		this.presets[r][c] = orig.presets[r][c];
            }
        }
    }
    public SudokuS(String in) {
    	this();
    	if (in.length()!=81) {
            throw new IllegalArgumentException("input with length 81 required");
        }
        for (int i=0; i<81; i++) {
            char a = in.charAt(i);
            if (a>='1' && a<='9') {
                sudoku[i/9][i%9] = a-'0';
                given[i/9][i%9] = true;
                line [i] = a-'0';
            }
        }
    }
    
    public void shuffleOrder(Random rand) {
        // Swap every position with a random position from that position on
        for (int i=0; i<80; i++) {
            int j = rand.nextInt(81-i)+i;
            // swap i <-> j
            int h = (int) order[i];
            order[i] = order[j];
            order[j] = h;
        }
    }
    
    private int[] toLine(int type, int n) {
        int[] out = new int[9];
        n = n*9;
        for (int i=n; i<n+9;i++)	{
        	if	(type==0)	{
        		out[i-n]= sudoku[i/9][i%9];
        	}
        	if	(type==1)	{
        		out[i-n]= sudoku[i%9][i/9];
        	}
        }
        return out;
    }//0=row, 1=column, n=# of r or c
    private int[][] toSquare(int r, int c) {
        int[][] out = new int [3][3];
        for (int i=0; i<3;i++)	{
        	for (int j=0; j<3;j++)	{
        		out[i][j]=sudoku[i+3*(r/3)][j+3*(c/3)];
        	}
        }
        return out;
    }//le square ou r et c est dedans
    
    public String toString(int[][] sudoku)	{
    	StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<81; i++) {
        		if (i%27==0)	{	
        			sb.append("\n");	
        		}
        		if (i%3==0 )	{	
        			sb.append("<br />");	
        		}
        		sb.append(sudoku[i/9][i%9] + " ");
        		if ((i+1)%9==0)	{	
        			sb.append("\n");	
        		}
        }
        sb.append("\n");
        return sb.toString();
    }
    
	public boolean isExist(int r, int c, int v)	{
		boolean out = true;
		if (r<0||8<r||c<0||8<c||v<1||9<v)	{
			out = false;
		}
		return out;
	}
    public boolean isEmpty(int r, int c)	{
    	return (sudoku[r][c]==0);
    }
    public boolean isGiven(int r, int c)	{
    	return given[r][c];
    }
    
    public int getValue(int r, int c)	{
    	if (isExist(r,c,sudoku[r][c]))	{
    		return sudoku[r][c];
    	}
    	else	{
    		return 0;
    	}
    }
    public void setValue(int r, int c, int v) 	{
    	if( isExist(r,c,v) && isEmpty(r,c))	{
    		sudoku[r][c]=v;
    	}
    }
    public void clearValue(int r, int c)	{
    	if(!isGiven(r,c))	{
    		sudoku[r][c]=0;
    	}
    }
    
    private boolean existsInLine(int type, int n, int v)	{
    	boolean e = false;
    	for (int i=0;i<9;i++)	{
    		if (toLine(type,n)[i]==v)	{
    			e=  true;
    		}
    	}
    	return e;
    }
    private boolean existsInSquare(int r, int c, int v)	{
    	boolean e = false;
    	for (int i=0;i<3;i++)	{
    		for (int j=0;j<3;j++)	{
    			if (toSquare(r,c)[i][j]==v)	{
    				e=  true;
    			}
    		}
    	}
    	return e;
    }
    
    public boolean canSetValue(int r, int c, int v)	{
    	boolean can = false;
    	if (		
    		isEmpty(r,c)== true 
    		&& 	
    		isGiven(r,c) == false 
    		&& 	
    		existsInLine(0,r,v) == false
    		&& 	
    		existsInLine(1,c,v) == false
    		&& 	
    		existsInSquare(r,c,v) == false
    		&&
    		isExist(r,c,v) == true	
    							)	{
    		can=true;
    	}
    	return can;
    }
    /*
    public static void main(String[] args) {	
    	Sudoku s = new Sudoku(args[0]);
    	for (int p=0; p<81 && -1<p ;p++)	{
    			for (int val=0; val<=9;val++)	{
    				if (s.canSetValue(p/9, p%9, val))	{
    					s.setValue(p/9, p%9, val);
    				}
    			}
    	}
		System.out.print(s.toString(s.sudoku));
    }*/
}















