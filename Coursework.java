import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Coursework
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("Realized tasks:\n1)Triangle with max perimeter\n2)max number\n3)sorting of diagonals in matrix\n4)piles of coins");
			System.out.println("5)balloons and arrows\n6)merge of intervals\n7)string competition\n8)palindrome substring\n9)concatination of substrings");
			System.out.print("Input number of task or 'end' to close prorgam: ");
			String task = input.nextLine();
			if(task.equals("1"))
			{
				try
				{
					System.out.print("Input array of positive integers using ' ' as separator: ");
					String array = input.nextLine();
					args = array.split(" ");
					int[] numbers = new int[args.length];
					for(int i = 0; i < args.length; i++)
					{
						numbers[i] = Integer.parseInt(args[i]);
					}
					int maxPerimeter = perimeter(numbers);
					System.out.println(maxPerimeter);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
			if(task.equals("2"))
			{
				try
				{
					System.out.print("Input array of positive integers using ' ' as separator: ");
					String array = input.nextLine();
					args = array.split(" ");
					int[] numbers = new int[args.length];
					boolean isCorrect = true;
					for(int i = 0; i < args.length; i++)
					{
						numbers[i] = Integer.parseInt(args[i]);
						if(numbers[i] < 0)
						{
							isCorrect = false;
							break;
						}
					}
					if(isCorrect)
					{
						String max = maxNumber(numbers);
						System.out.println(max);
					}
					else
					{
						System.out.println("Input array is incorrect: some numbers are negative");
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			if(task.equals("3"))
			{
				try
				{
					System.out.print("Input dimensions of your matrix (columns and lines) using ' ' as separator: ");
					String dimensions = input.nextLine();
					int columns = Integer.parseInt(dimensions.split(" ")[0]), lines = Integer.parseInt(dimensions.split(" ")[1]);
					int[][] matrix = new int[lines][columns];
					boolean isCorrect = true;
					for(int i = 0; i < lines; i++)
					{
						System.out.print("Input line of positive integers using ' ' as separator: ");
						String line = input.nextLine();
						args = line.split(" ");
						if(args.length != columns)
						{
							isCorrect = false;
							break;
						}
						for(int j = 0; j < columns; j++)
						{
							matrix[i][j] = Integer.parseInt(args[j]);
						}
					}
					if(isCorrect)
					{
						System.out.println(Arrays.deepToString(matrix));
						diagonal(matrix);
						System.out.println(Arrays.deepToString(matrix));
					}
					else
					{
						System.out.println("Input matrix is incorrect: wrong or different count of numbers in some lines");
					}
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
			if(task.equals("4"))
			{
				System.out.print("Input array of positive integers using ' ' as separator: ");
				args = input.nextLine().split(" ");
				if(args.length % 3 == 0)
				{
					try
					{
						int[] array = new int[args.length];
						boolean isCorrect = true;
						for(int i = 0; i < args.length; i++)
						{
							array[i] = Integer.parseInt(args[i]);
							if(array[i] <= 0)
							{
								isCorrect = false;
								break;
							}
						}
						if(isCorrect)
						{
							int max = piles(array);
							System.out.println(max);
						}
						else
						{
							System.out.println("Input array is incorrect: some numbers are negative or equals 0");
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				else
				{
					System.out.println("Input array is incorrect: count of elements is not divisible by 3");
				}
			}
			if(task.equals("5"))
			{
				System.out.print("Input couples of positive integers using ' ' as separator: ");
				args = input.nextLine().split(" ");
				if(args.length % 2 == 0)
				{
					try
					{
						int[][] array = new int[args.length/2][2];
						for(int i = 0; i < args.length; i++)
						{
							array[i/2][0] = Integer.parseInt(args[i]);
							i++;
							array[i/2][1] = Integer.parseInt(args[i]);
						}
						int minArrows = balloons(array);
						System.out.println(minArrows);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
					System.out.println("Input array is incorrect: count of elements is not divisible by 2");
				}
			}
			if(task.equals("6"))
			{
				System.out.print("Input couples of positive integers using ' ' as separator: ");
				args = input.nextLine().split(" ");
				if(args.length % 2 == 0)
				{
					try
					{
						int[][] array = new int[args.length/2][2];
						for(int i = 0; i < args.length; i++)
						{
							array[i/2][0] = Integer.parseInt(args[i]);
							i++;
							array[i/2][1] = Integer.parseInt(args[i]);
						}
						array = merge(array);
						System.out.println(Arrays.deepToString(array));
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
					System.out.println("Input array is incorrect: count of elements is not divisible by 2");
				}
			}
			if(task.equals("7"))
			{
				//canWin("xya","abc");
				System.out.print("Input two strings using ' ' as separator: ");
				args = input.nextLine().split(" ");
				if(args[0].length() == args[1].length())
				{
					boolean isCorrect = true;
					for(int i = 0; i < args[0].length(); i++)
					{
						if(!Character.isLetter(args[0].charAt(i)) || !Character.isLetter(args[1].charAt(i)))
						{
							isCorrect = false;
							break;
						}
					}
					if(isCorrect)
					{
						boolean canWin = canWin(args[0], args[1]);
						System.out.println(canWin);
					}
					else
					{
						System.out.println("Input strings are incorrect: one of strings contains something except letters");
					}
				}
				else
				{
					System.out.println("Input strings are incorrect: lengths of strings are different");
				}
			}
			if(task.equals("8"))
			{
				System.out.print("Input string: ");
				args = input.nextLine().split(" ");
				String maxPalindrome = maxPalindrome(args[0]);
				System.out.println(maxPalindrome);
			}
			if(task.equals("9"))
			{
				System.out.print("Input string: ");
				args = input.nextLine().split(" ");
				int count = concatinations(args[0]);
				System.out.println(count);
			}
			if(task.equals("end"))
			{
				break;
			}
			System.out.println();
		}
		
			
		input.close();
	}
	
	public static int perimeter(int[] args)
	{
		Arrays.sort(args);
		if(args.length < 3)
		{
			System.out.println("Array has less than 3 elements");
			return 0;
		}
		int max1 = args[args.length-1], max2 = args[args.length-2], perimeter = 0;
		if(max1 < 0 || max2 < 0)
		{
			System.out.println("One of max sides of triangle is negative");
			return 0;
		}
		for(int i = args.length-3; i >= 0; i--)
		{
			if(max1 < max2 + args[i])
			{
				perimeter = max1 + max2 + args[i];
				break;
			}
			else
			{
				max1 = max2;
				max2 = args[i];
			}
		}
		return perimeter;
	}
	
	public static String maxNumber(int[] array)
	{
		String[] args = new String[array.length];
		for(int i = 0; i < args.length; i++)
		{
			args[i] = Integer.toString(array[i]);
		}
		for(int i = 1; i < args.length; i++)
		{
			String changer = "";
			for(int j = 0; j < i; j++)
			{
				String num1 = args[i] + args[j];
				String num2 = args[j] + args[i];
				if(num2.compareTo(num1) < 0)
				{
					changer = args[i] + "";
					args[i] = args[j] + "";
					args[j] = changer + "";
				}
			}
		}
		String result = "";
		for(String s : args)
		{
			result += s;
		}
		return result;
	}
	
	public static int[][] diagonal(int[][] matrix)
	{
		
		for(int i = 0, j = matrix[0].length-2; i < matrix.length-1 || j > 0;)
		{
			for(int k = j, l = i; k < matrix[0].length && l < matrix.length;)
			{
				int min = matrix[l][k], indexJ = k, indexI = l, changer;
				for(int k1 = k, l1 = l; k1 < matrix[0].length && l1 < matrix.length;)
				{
					if(matrix[l1][k1] < min)
					{
						min = matrix[l1][k1];
						indexJ = k1;
						indexI = l1;
					}
					k1++;
					l1++;
				}
					
				changer = matrix[l][k];
				matrix[l][k] = min;
				matrix[indexI][indexJ] = changer;
					
				k++;
				l++;
			}
			if(j - 1 >= 0)
			{
				j--;
			}
			else
			{
				if(i + 1 <= matrix.length-1)
				{
					i++;
				}
			}
		}
		return matrix;	
	}
	
	public static int piles(int[] args)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < args.length; i++)
		{
			arr.add(args[i]);
		}
		Collections.sort(arr, Collections.reverseOrder());
		int max = 0;
		for(int i = arr.size(); i > 0; i = i - 3)
		{
			max += arr.get(1);
			arr.remove(1);
			arr.remove(0);
			arr.remove(arr.size()-1);
		}
		return max;
	}
	
	
	public static int balloons(int[][] points)
	{
		ArrayList<Integer[]> intersections = new ArrayList<>();
		int changer0 = 0, changer1 = 0;
		for(int i = 0; i < points.length; i++)
		{
			for(int j = i; j < points.length; j++)
			{
				if(points[j][0] < points[i][0])
				{
					changer0 = points[j][0];
					changer1 = points[j][1];
					points[j][0] = points[i][0];
					points[j][1] = points[i][1];
					points[i][0] = changer0;
					points[i][1] = changer1;
				}
			}
		}
		
		for(int i = 0; i < points.length; i++)
		{
			intersections.add(new Integer[]{points[i][0], points[i][1]});
		}
		while(true)
		{
			boolean isNotChanged = true;
			for(int i = 0; i < intersections.size()-1; i++)
			{
				if(intersections.get(i)[1] >= intersections.get(i+1)[0])
				{
					intersections.set(i, new Integer[]{intersections.get(i+1)[0], intersections.get(i)[1]});
					intersections.remove(i+1);
					isNotChanged = false;
					break;
				}
			}
			if(isNotChanged)
			{
				break;
			}
		}
		return intersections.size();
		
	}
	
	public static int[][] merge(int[][] intervals)
	{
		ArrayList<Integer[]> merges = new ArrayList<>();
		int changer0 = 0, changer1 = 0;
		for(int i = 0; i < intervals.length; i++)
		{
			for(int j = i; j < intervals.length; j++)
			{
				if(intervals[j][0] < intervals[i][0])
				{
					changer0 = intervals[j][0];
					changer1 = intervals[j][1];
					intervals[j][0] = intervals[i][0];
					intervals[j][1] = intervals[i][1];
					intervals[i][0] = changer0;
					intervals[i][1] = changer1;
				}
			}
		}
		
		for(int i = 0; i < intervals.length; i++)
		{
			merges.add(new Integer[]{intervals[i][0], intervals[i][1]});
		}
		while(true)
		{
			boolean isNotChanged = true;
			for(int i = 0; i < merges.size()-1; i++)
			{
				if(merges.get(i)[1] >= merges.get(i+1)[0])
				{
					merges.set(i, new Integer[]{merges.get(i)[0], merges.get(i+1)[1]});
					merges.remove(i+1);
					isNotChanged = false;
					break;
				}
			}
			if(isNotChanged)
			{
				break;
			}
		}
		intervals = new int[merges.size()][2];
		for(int i = 0; i < merges.size(); i++)
		{
			intervals[i][0] = merges.get(i)[0];
			intervals[i][1] = merges.get(i)[1];
		}
		return intervals;
	}
	
	public static boolean canWin(String s1, String s2)
	{
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char changer = ' ';
		for(int i = 0; i < s1.length(); i++)
		{
			for(int j = i; j < s1.length(); j++)
			{
				if(c1[i] > c1[j])
				{
					changer = c1[i];
					c1[i] = c1[j];
					c1[j] = changer;
				}
				if(c2[i] > c2[j])
				{
					changer = c2[i];
					c2[i] = c2[j];
					c2[j] = changer;
				}
			}
		}
		boolean canWin1 = true, canWin2 = true;
		for(int i = 0; i < c1.length; i++)
		{
			if(c1[i] < c2[i])
			{
				canWin1 = false;
			}
			if(c2[i] < c1[i])
			{
				canWin2 = false;
			}
		}
		//System.out.println(Arrays.toString(c1));
		if(canWin1 || canWin2)
		{
			return true;
		}
		return false;
	}
	
	public static String maxPalindrome(String s)
	{
		String palindrome = "";
		String substring = "";
		for(int i = 0; i < s.length(); i++)
		{
			substring = "";
			for(int j = i; j < s.length(); j++)
			{
				substring += s.charAt(j);
				if(isPalindrome(substring) && substring.length() > palindrome.length())
				{
					palindrome = substring;
				}
			}
		}
		return palindrome;
	}
	
	public static String reverseString(String s)
	{
		String newS = "";
		for(int i = s.length()-1; i >= 0; i--)
		{
			newS += s.charAt(i);
		}
		return newS;
	}
	
	public  static  boolean  isPalindrome(String  s)
	{
		String reverseS = reverseString(s);
		return s.equals(reverseS);
	}
	
	public static int concatinations(String s)
	{
		int count = 0;
		ArrayList<String> substrings = new ArrayList<>();
		String substring = "";
		for(int i = 0; i < s.length(); i++)
		{
			substring = "";
			for(int j = i; j < s.length(); j++)
			{
				substring += s.charAt(j);
				if(substring.length() % 2 == 0)
				{
					if(!substrings.contains(substring) && substring.equals(substring.substring(0, substring.length()/2) + substring.substring(0, substring.length()/2)))
					{
						substrings.add(substring);
						count++;
					}
				}
			}
			
		}
		return count;
	}
}