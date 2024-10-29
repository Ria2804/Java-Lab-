// Source code is decompiled from a .class file using FernFlower decompiler.
class ShareTrader {
    static int maxProfit;
 
    ShareTrader() {
    }
 
    public static int findMaxProfit(int[] var0) {
       int var1 = var0.length;
       if (var1 < 2) {
          return 0;
       } else {
          int[] var2 = new int[var1];
          int[] var3 = new int[var1];
          int var4 = var0[0];
 
          int var5;
          for(var5 = 1; var5 < var1; ++var5) {
             var4 = Math.min(var4, var0[var5]);
             var2[var5] = Math.max(var2[var5 - 1], var0[var5] - var4);
          }
 
          var5 = var0[var1 - 1];
 
          int var6;
          for(var6 = var1 - 2; var6 >= 0; --var6) {
             var5 = Math.max(var5, var0[var6]);
             var3[var6] = Math.max(var3[var6 + 1], var5 - var0[var6]);
          }
 
          maxProfit = 0;
 
          for(var6 = 0; var6 < var1; ++var6) {
             maxProfit = Math.max(maxProfit, var2[var6] + var3[var6]);
          }
 
          return maxProfit;
       }
    }
 
    public static void main(String[] var0) {
       int[] var1 = new int[]{10, 22, 5, 75, 65, 80};
       System.out.println("Maximum Profit: " + findMaxProfit(var1));
       int[] var2 = new int[]{2, 30, 15, 10, 8, 25, 80};
       System.out.println("Maximum Profit: " + findMaxProfit(var2));
    }
 }
