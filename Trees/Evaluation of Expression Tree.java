
class Solution {
    public int evalTree(Node root) {
        if(root==null) return 0;
        if(isNumber(root.data)) 
          return Integer.parseInt(root.data);
          int leftValue=evalTree(root.left);
          int rightValue=evalTree(root.right);
          switch(root.data) {
              case "+":
                  return leftValue+rightValue;
              case "-":
                  return leftValue-rightValue;
              case "*":
                  return leftValue*rightValue;
              case "/":
                  return leftValue/rightValue;
              default:
                  throw new IllegalArgumentException("Invalid operator: "+root.data);
          }
    }
    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}