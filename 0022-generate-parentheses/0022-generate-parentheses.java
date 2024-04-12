class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    dfs(n, n, new StringBuilder(), res);
    return res;
  }

  private void dfs(int openRemain, int closeRemain, StringBuilder sb, List<String> res) {
    if (openRemain == 0 && closeRemain == 0) {
      res.add(sb.toString());
      return;
    }
    if (openRemain > 0) {
      sb.append('(');
      dfs(openRemain-1, closeRemain, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (closeRemain > openRemain) {
      sb.append(')');
      dfs(openRemain, closeRemain - 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

}