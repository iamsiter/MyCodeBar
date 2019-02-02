package com.leetcode.linkedin;

import java.util.List;

public class DepthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList,1);
    }

    public int depthSum(List<NestedInteger> nestedList,int multiplier) {
        int result=0;
        for(NestedInteger i:nestedList){
            if(i.isInteger())
                result=result+i.getInteger()*multiplier;
            else{
                result=result+depthSum(i.getList(), multiplier+1);                         }
        }
        return result;
    }
}


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
