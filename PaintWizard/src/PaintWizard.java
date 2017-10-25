import java.util.ArrayList;

public class PaintWizard {
    public static void main(String[] args)
    {
        PaintWizard pw = new PaintWizard();
        int coverageNeeded = 25;
        ArrayList<Paint> paintList = pw.getPaint();
        System.out.println("The cheapest paint for the job is: ");
        System.out.println(pw.whichPaint(coverageNeeded, paintList,"cost"));
        System.out.println("The paint with the least waste for the job is: ");
        System.out.println(pw.whichPaint(coverageNeeded, paintList,"waste"));

    }
    private Paint whichPaint(int coverageNeeded, ArrayList<Paint> paintList, String costOrWaste)
    {
        ArrayList<Integer> bucketsNeeded = new ArrayList<Integer>();
        ArrayList<Integer> waste = new ArrayList<Integer>();
        ArrayList<Double> cost = new ArrayList<Double>();

        for (int i = 0; i < paintList.size(); i++)
        {
            bucketsNeeded.add(paintList.get(i).bucketsNeeded(coverageNeeded));
            waste.add(paintList.get(i).waste(coverageNeeded));
            cost.add(paintList.get(i).cost(coverageNeeded));
        }

        int minwaste = waste.get(0);
        double mincost = cost.get(0);
        for (int i = 1; i < waste.size(); i++)
        {
            minwaste = (minwaste > waste.get(i)) ? waste.get(i) : minwaste;
            mincost = (mincost > cost.get(i)) ? cost.get(i) : mincost;
        }

        if (costOrWaste.equals("cost"))
            return paintList.get(cost.indexOf(mincost));
        else
            return paintList.get(waste.indexOf(minwaste));
    }

    private ArrayList<Paint> getPaint()
    {
        ArrayList<Paint> paintList = new ArrayList<Paint>();
        paintList.add(new Paint("CheapoMax", 19.99,10,20));
        paintList.add(new Paint("AverageJoes", 17.99,11, 15));
        paintList.add(new Paint("DuluxourousPaints", 25.00,20,10));
        return paintList;
    }
}
