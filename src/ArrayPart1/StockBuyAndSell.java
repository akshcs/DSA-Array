package ArrayPart1;

public class StockBuyAndSell {

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.print("Max Profit : " + maxProfit(prices));
    }
    static int maxProfit(int[] prices) {
        int out = 0;
        if(prices.length==2){
            out = max(out, prices[1]-prices[0]);
        } else if(prices.length>2){
            int[] maximumPriceAfterDay = getMaximumPriceAfterDay(prices, prices.length);
            for(int i=0;i<maximumPriceAfterDay.length;i++){
                out = max(out, maximumPriceAfterDay[i]-prices[i]);
            }
        }
        return out;
    }

    static int[] getMaximumPriceAfterDay(int[] prices, int size){
        int[] maximumPriceAfterDay = new int[size-1];
        int index = size-2;
        maximumPriceAfterDay[index] = prices[index+1];
        int maxVal = prices[index+1];
        index--;
        while(index>=0){
            if(prices[index+1] > maxVal){
                maxVal = prices[index+1];
            }
            maximumPriceAfterDay[index--] = maxVal;
        }
        return maximumPriceAfterDay;
    }

    static int max(int a, int b){
        return Math.max(a, b);
    }
}
