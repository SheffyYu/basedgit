import java.awt.*;

import javax.swing.*;

import java.util.*;
import java.lang.Math;

class Game {

	private int GameMap[][]=new int [256][256];//��Ϸ��ͼ
	private int TempMap[][]=new int [256][256];//ˢ�º����Ϸ��ͼ	
	private int rows=4;//����
	private int cols=4;//����

	void InitGameMap(){
		/*
		//���ó�ʼ������������
		System.out.println("��������Ҫ��ʼ��������������");
		Scanner scan=new Scanner (System.in);
		rows=scan.nextInt();
		
		cols=rows;//�������ɵ���Ϸ��ͼ�̶�Ϊ50
		
		//��������״̬
		for(int i=0;i<=rows+1;i++)
		{
			GameMap[0][i]=0;
			GameMap[i][0]=0;
			GameMap[rows+1][i]=0;
			GameMap[i][rows+1]=0;
		}
	
		//���ô��״̬
		for(int i=1;i<=rows;i++)
		{
			for(int j=1;j<=cols;j++)
			{
				int rand= (int)( Math.random()+0.5);
				//int rand=(int)(1+Math.random()*(1-0+1));
				GameMap[i][j]=rand;
				if(rand==1)
					System.out.print("�� ");
					
				else
					System.out.print("�� ");
			}
			System.out.println();
		}
*/        //�̶�ֵ
	  	int nGameMap[][]={{0,0,0,0,0,0},
		         {0,0,0,0,0,0},
		         {0,0,1,1,1,0},
		         {0,0,1,1,0,0},
		         {0,0,0,0,0,0},
		         {0,0,0,0,0,0}};
	  	for(int i=0;i<6;i++)
	  		for(int j=0;j<6;j++)
	  			GameMap[i][j]=nGameMap[i][j];
	}
	int GetNeighborCount(int row, int col){

		int ret=0;
		for(int r=row-1;r<=row+1;r++)
			for(int c=col-1;c<=col+1;c++)
			{
				
				if(GameMap[r][c]==1)
					ret++;
			}	
		if(GameMap[row][col]==1)
			ret--;
		return ret;	
	}
	
	void InitNewMap(){

		for(int i=0;i<=rows+1;i++)
		{
			TempMap[0][i]=0;
			TempMap[i][0]=0;
			TempMap[rows+1][i]=0;
			TempMap[i][rows+1]=0;
		}
		
		for(int i=1;i<=rows;i++)
			for(int j=1;j<=cols;j++)
			{
				int LiveCnt=0;
				LiveCnt=GetNeighborCount(i,j);
				if(LiveCnt<2||LiveCnt>3)
					TempMap[i][j]=0;
				else if(LiveCnt==3)
					TempMap[i][j]=1;
				else
					TempMap[i][j]=GameMap[i][j];
			}
		//return TempMap;
	}
	
	
	
	void UpdateGameMap()
	{
		InitNewMap();
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=1;j<=cols;j++)
			{
		
				GameMap[i][j]=TempMap[i][j];
				if(GameMap[i][j]==1)
					System.out.print("�� ");
				else if(GameMap[i][j]==0)
					System.out.print("�� ");
			}
			System.out.println();
		}
		
		//InitNewMap();
		
	
	}
	}

public class GameOfLifeDemo 
{	
	public static void main(String args[]){
	Game start=new Game();
	start.InitGameMap();
	System.out.println();
	start.UpdateGameMap();
	System.out.println();
	start.UpdateGameMap();
	}
	
}
