import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Beräkna simhoppspoäng
        //   - Ange antal domare (minst 3)
        //
        //   - Loop
        //     - Läs in svårighetsgrad
        //     - Läs in poäng från alla domare
        //     - Dra bort högsta och lägsta poängen
        //     - Räkna ut genomsnitt av kvarvarande (obs 2 färre domare)
        //     - Multiplicera med 3
        //     - Multiplicera med svårighetsgraden
        //
        // Fortsätt tills svårighetsgraden är negativ

        Scanner input = new Scanner(System.in);
        System.out.print("Ange antal domare: ");
        int ref = input.nextInt();

        if (ref < 3) {
            System.out.println("Felaktigt antal domare (minst 3)");
            System.exit(0);
        }

        while (true) {
            System.out.print("Ange svårighetsgrad: ");
            double level = input.nextDouble();
            if (level <= 0) {
                break;
            }

            double min = Double.MAX_VALUE;
            double max = 0;
            double sum = 0;
            for (int i=0; i < ref; i++) {
                System.out.print("Ange poäng för domare #" + i + ": ");
                double points = input.nextDouble();

                min = Math.min(points, min);
                max = Math.max(points, max);
                sum += points;
            }

            sum = sum - max - min;
            sum = sum / (ref-2);
            sum = sum * 3 * level;

            System.out.println("Poäng: " + sum);
        }
    }
}