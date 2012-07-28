package ca;

import java.awt.Color;
import java.awt.Graphics;

public class CellularAutomaton {
	private int rule;
	private boolean cells[][];
	private int width;
	private int height;
	
	public CellularAutomaton(int rule, int width, int height, long seed) {
		this.rule = rule;
		this.width = width;
		this.height = height;
		cells = new boolean[width][height];
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height-1; j++) {
				cells[i][j] = false;
			}
		}
		
		if(seed == 0) {
			cells[0][0] = true;
		}
		else {
			for(int i=0; i<width; i++) {
				long n = (long)Math.pow(2, i);
				cells[i][0] = (seed&n)>0;
			}
		}
		
		for(int j=0; j<height-1; j++) {
			for(int i=0; i<width; i++) {
				int pattern = getPattern(i, j);
				int n = (int) Math.pow(2, pattern);
				cells[i][j+1] = (rule&n)>0;
			}
		}
	}
	
	public int getPattern(int x, int y) {
		int pattern = 0;
		if(y<height) {
			if((x-1)>=0 && (x-1)<width) {
				if(cells[x-1][y]==true) {
					pattern+=1;
				}
			}
			if(x>=0 && x<width) {
				if(cells[x][y]==true) {
					pattern+=2;
				}
			}
			if(x+1>=0 && x+1<width) {
				if(cells[x+1][y]==true) {
					pattern+=4;
				}
			}
		}
		return pattern;
	}
	
	public void clean() {
		for(int j=0; j<height-1; j++) {
			for(int i=0; i<width; i++) {
				int pattern = getPattern(i, j);
				if(pattern==7 || pattern==3 || pattern==6) {
					cells[i][j]=false;
				}
			}
		}
	}
	
	public void erase(int eraserPattern) {
		for(int j=0; j<height-1; j++) {
			for(int i=0; i<width; i++) {
				int pattern = getPattern(i, j);
				if(eraserPattern==pattern) {
					cells[i][j]=false;
				}
			}
		}
	}
	
	public boolean[] getRow(int index) {
		boolean row[] = new boolean[width];
		for(int x=0; x<width; x++) {
			if(index < height) {
				row[x] = cells[x][index];
			}
			else {
				row[x] = false;
			}
		}
		return row;
	}
	
	public void show(Graphics g, int x, int y, int zoom) {
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(cells[i][j]==true) {
					g.fillRect(x+i*zoom, y+j*zoom, zoom, zoom);
				}
			}
		}
	}
	
	public void showArea(Graphics g, int x, int y, int offset, int width, int zoom) {
		for(int i=offset; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(cells[i][j]==true) {
					g.fillRect(x+i*zoom, y+j*zoom, zoom, zoom);
				}
			}
		}
	}
}
