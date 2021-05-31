package finalLeapP3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class RobotBoundedInCircle {

	public static void main(String[] args) {
		RobotBoundedInCircle s = new RobotBoundedInCircle();
		
		//System.out.println(s.isRobotBounded("GLGLGLGL"));
		System.out.println(s.solution());
	}

	
	public boolean isRobotBounded(String instructions) {
        int[] cur = new int[] {0, 0};
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dir = 0; // 0:north(up), 1: right, 2: down, 3: left
        
        for (char in : instructions.toCharArray()) {
            if (in == 'G') {
                cur[0] += dirs[dir][0];
                cur[1] += dirs[dir][1];
            } else if (in == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        if (cur[0] == 0 && cur[1] == 0) { // ended up at the same place
            return true;
        }
        if (dir == 0 && !(cur[0] == 0 && cur[1] == 0)) { // if the direction is north and location has changed
            return false;
        }
        return true; // it is always true
    }
	
	/**
	 * @return
	 */
	public boolean solution() {
		String instructions = "GLGLGLGLGL";
		
		int move = 2; //3 - j+1 | 1 - j-1 | 2 - i +1 | 0 - i-1
        int[] pos = new int[]{0,0}; 
        int i = 0;
        while(i<instructions.length()){
            char c = instructions.charAt(i);
            if(c=='G'){
                switch(move){
                    case 0:
                      pos[0]-=1; 
                    break;
                    case 1:
                      pos[1]-=1; 
                   break; 
                    case 2:
                      pos[0]+=1; 
                    break;
                    case 3:
                      pos[1]+=1; 
                    break;
                }
               
            }
            else if(c=='L'){
                move=move==3?0:move+1;
            }
             else if(c=='R'){
                move=move==0?3:move-1;
            }
            i++;
        }
         if(pos[0]==0 && pos[1] == 0 ) return true;
         else if(move==2 ) return false;
         else return true;
		
    }
	
}


/*
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

 * */
 