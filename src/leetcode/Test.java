package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {



    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> all=new ArrayList<>();
        List<Integer> cordin=new ArrayList<>(1);
        int kingX=king[0];
        int kingY=king[1];
        int t;
        int r;
        for (int i = 0; i < queens.length; i++) {
            t=queens[i][1];
            r=queens[i][0];

            int g=kingX-1;
            while (g>=0){
                if(g==r&&t==kingY){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
                g--;
            }
            g=kingX+1;
            while (g<9){
                if(g==r&&t==kingY){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
                g++;
            }
            g=kingY+1;
            while (g<9){
                if(g==t&&r==kingX){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
                g++;
            }
            g=kingY-1;
            while (g>=0){
                if(g==t&&r==kingX){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
                g--;
            }
            int y=kingX+1;
            int b=kingY+1;
            while (y<9&&b<9){
                if(y==r&&b==t){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
                y++;
                b++;
            }

            y=kingX+1;
            b=kingY-1;
            while (y<9&&b>=0){
                if(y++==r&&b--==t){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
            }

            y=kingX-1;
            b=kingY+1;
            while (y>=0&&b<9){
                if(y--==r&&b++==t){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
            }

            y=kingX-1;
            b=kingY-1;
            while (y>=0&&b>=0){
                if(y--==r&&b--==t){
                    cordin=new ArrayList<>();
                    cordin.add(r);
                    cordin.add(t);
                    all.add(cordin);
                    break;
                }
            }

        }
        return all;
    }

}
