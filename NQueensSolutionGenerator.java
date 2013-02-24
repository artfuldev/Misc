package com.nqueens.simulatedAnnealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class NQueensSolutionGenerator
{
	public static int noOfQueens=0;
	public static double initialTemperature=0;
	public static double finalTemperature=0;
	public static double alpha=0;
	public static int stepsPerChange=0;
	public static Random RNG=new Random();
	public static Scanner inputStream=new Scanner(System.in);
	public class Solution implements Cloneable
	{
		public ArrayList<Integer> solution;
		public double energy;
		public void tweak()
		{
			int x,y;
			x=RNG.nextInt(noOfQueens);
			do
			{
				y=RNG.nextInt(noOfQueens);
			}while(x==y);
			Collections.swap(solution,x,y);
		}
		public void initialize()
		{
			solution=new ArrayList<Integer>();
			for(int i=0;i<noOfQueens;i++)
				solution.add(i);
			for(int i=0;i<noOfQueens;i++)
				tweak();
		}
		public void calculateEnergy()
		{
			energy=0;
			for(int i=0;i<solution.size();i++)
				for(int j=0;j<solution.size();j++)
					if(i!=j)
						if((i-j)==(solution.get(i)-solution.get(j))||
							(i-j)==(solution.get(j)-solution.get(i)))
							energy++;
		}
		public Solution clone()
		{
			Solution returnSolution=new Solution();
			returnSolution.solution=new ArrayList<Integer>();
			for(int i=0;i<this.solution.size();i++)
				returnSolution.solution.add(this.solution.get(i));
			returnSolution.energy=this.energy;
			return returnSolution;
		}
		public void print()
		{
			for(int i=0;i<solution.size();i++)
			{
				for(int j=0;j<solution.size();j++)
					if(solution.get(i)==j)
						System.out.print("+ ");
					else
						System.out.print("- ");
				System.out.println();
			}
			System.out.println(solution);
			System.out.println("Energy: "+energy);
		}
	}
	public void calculateAll()
	{
		initialTemperature=noOfQueens*10;
		finalTemperature=0.5;
		alpha=1-(10/initialTemperature);
		stepsPerChange=(int)Math.pow(noOfQueens,2);
	}
	public void getSolution()
	{
		calculateAll();
		double startTime=System.nanoTime();
		double time;
		double temperature=initialTemperature;
		Solution currentSolution,workingSolution,bestSolution;
		boolean useNew=false,solutionFound=false;
		currentSolution=this.new Solution();
		currentSolution.initialize();
		currentSolution.calculateEnergy();
		bestSolution=this.new Solution();
		bestSolution.energy=stepsPerChange;
		workingSolution=currentSolution.clone();
		int accepted=0;
		while((temperature>finalTemperature)&&(bestSolution.energy!=0))
		{
			accepted=0;
			//Monte-Carlo
			for(int step=0;step<stepsPerChange;step++)
			{
				useNew=false;
				workingSolution.tweak();
				workingSolution.calculateEnergy();
				if(workingSolution.energy<=currentSolution.energy)
					useNew=true;
				else
				{
					double testValue=RNG.nextDouble();
					double deltaEnergy=workingSolution.energy-currentSolution.energy;
					double acceptanceProbability=Math.exp(-deltaEnergy/temperature);
					if(acceptanceProbability>testValue)
					{
						accepted++;
						useNew=true;
					}
				}
				if(useNew)
				{
					useNew=false;
					currentSolution=workingSolution.clone();
					if(currentSolution.energy<bestSolution.energy)
					{
						bestSolution=currentSolution.clone();
						solutionFound=true;
					}
				}
				else
					workingSolution=currentSolution.clone();
			}
			time=(System.nanoTime()-startTime)/1000000L;
			System.out.println("Time: "+time+" ms, Temperature: "+temperature
					+", Best Energy: "+bestSolution.energy+", Accepted: "+accepted);
			temperature*=alpha;
		}
		if(solutionFound)
			bestSolution.print();
	}
	public static void main(String[] args)
	{
		NQueensSolutionGenerator nQueens=new NQueensSolutionGenerator(); 
		System.out.println("Enter the n (max. 2147483647) in the n-Queens Problem to solve:");
		noOfQueens=inputStream.nextInt();
//		noOfQueens=8;
		nQueens.getSolution();
	}
}