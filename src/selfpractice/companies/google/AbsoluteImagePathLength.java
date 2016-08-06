package selfpractice.companies.google;

import java.util.Stack;

/**
 http://qa.geeksforgeeks.org/6922/google-interview-question-question-google-interview-solution
 https://discuss.leetcode.com/topic/31565/the-longest-absolute-path-in-file-system/8

 Approach:
 1. Create a class to hold level where the directory is present and absolute length of that directory
 2. Split by \n and get all files and directories
 3. IMP: Maintain a stack (like DFS) to keep track of each level
 4. If Image File
    Check if current level same as stack top level, if yes then pop as file is not in that top dir,
          else
            calculate absolute length of file and add to maxLength
 5. If Dir
    Check if current level same as stack top level, if yes then pop till top level is less than current level ie reach parent dir
    Push the directory entry into stack
 6. Return maxLen;
 */

class Directory {
    String fileName;
    int level;
    int currLength;
}

public class AbsoluteImagePathLength {
    public static void main(String[] args) {
        AbsoluteImagePathLength obj = new AbsoluteImagePathLength();
        String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        int len = obj.getPathSum(S);
        System.out.println(len);
    }


    public int getPathSum(String s){
        String[] dirs = s.split("\n");
        Stack<Directory> stack = new Stack<>();              //Only push directories to stack

        int maxLen = 0;
        for(String dir : dirs) {

            int currLevel = 0;
            while (dir.charAt(currLevel) == ' ')            //calculate current level by counting spaces
                currLevel++;

            String name = dir.substring(currLevel);      //substring except space

            if (name.contains(".")) {      //File
                if (name.contains(".jpeg") || name.contains(".gif") || name.contains(".png")) {  //img file
                    if(stack.peek().level == currLevel){                        //checks if another dir found at same level, then remove previous dir
                        stack.pop();
                    }
                    int absLength = (stack.isEmpty() ? 1 : stack.peek().currLength + 1) + name.length();
                    maxLen += absLength;
                }
            } else {      //Dir
                while (!stack.isEmpty() && stack.peek().level >= currLevel) {   //checks if another dir found at same level, then remove previous dir
                    stack.pop();
                }

                Directory directory = new Directory();
                directory.fileName = name;
                directory.level = currLevel;
                directory.currLength = (currLevel == 0 ? 1 : stack.peek().currLength + 1) + name.length();

                stack.push(directory);
            }
        }
        return maxLen;
    }
}
