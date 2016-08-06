package selfpractice.companies.google;

import java.util.Stack;

/**
 http://qa.geeksforgeeks.org/6922/google-interview-question-question-google-interview-solution
 https://discuss.leetcode.com/topic/31565/the-longest-absolute-path-in-file-system/8

 Approach:
 1.

 */

class DirEntry {
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
        Stack<DirEntry> stack = new Stack<>();

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

                DirEntry dirEntry = new DirEntry();
                dirEntry.fileName = name;
                dirEntry.level = currLevel;
                dirEntry.currLength = (currLevel == 0 ? 1 : stack.peek().currLength + 1) + name.length();

                stack.push(dirEntry);
            }
        }
        return maxLen;
    }
}
