import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {290, 270, 250, 300, 500, 200, 150, 100};
    public static int[] heroesDamage = {20, 15, 10, 0, 3, 0, 0, 0};
    public static String[] heroesAttackType = {"Physical", "Magical", "Piercing", "Medic3","Golem","Lucky", "Witcher","Thor"};
    public static int roundNumber = 0;
    public static int healAmount = 100;


    public static void main(String[] args) {
        showStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        /*if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;*/
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefence = heroesAttackType[randomIndex];
    }
    public static void medic3HealthCare(){
        for(int i = 0; i < heroesHealth.length; i++ ){
            if(heroesAttackType[i]==" Medic3"){
            continue;}
            if(heroesHealth[3]>0 && heroesHealth[i]<100 && heroesHealth[i]>0){
                heroesHealth[i] = heroesHealth[i] + healAmount;
                break;
            }
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttacks();
        heroesAttack();
        showStatistics();
        medic3HealthCare();
        playerGolem();
    }

    public static void bossAttacks() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && heroesAttackType[5]=="lucky") {
                heroesHealth[i] = heroesHealth[i] - bossDamage;
                if (heroesHealth[i] < 0) {
                    heroesHealth[i] = 0;{

                        if(heroesAttackType[5]=="lucky" && bossHealth>0){
                            bossDamage=0;{
                                if(heroesAttackType[7]=="Thor" && bossHealth>0);
                                bossDamage=0;
                                boolean isPlayerThorStunned= true;

                            }
                        }
                        {


                        }
                    }
                }
            }
        }
    }
    public static void playerWitcher(){
        for (int i = 0; i < heroesHealth.length; i++)
        if(heroesHealth[i] <=0){
            heroesHealth[i] = heroesHealth[i]+ heroesHealth[6];
            heroesHealth[6]=0;

        }
    }
    public static boolean isPlayerThorStunned(){
        Random random = new Random();
        return random.nextBoolean();


    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i] == bossDefence) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    damage = heroesDamage[i] * coeff;
                    System.out.println("Critical damage: " + damage);
                }
                bossHealth = bossHealth - damage;
                if (bossHealth < 0) {
                    bossHealth = 0;{


                        }
                }
            }
        }
    }
    public static void playerGolem(){
        if(heroesHealth[4]> 0 && bossHealth>0){
            bossDamage = bossDamage-10;{
                if(bossDamage < 0){
                    bossDamage = 0;
                }
            }

        }



        }


    public static void showStatistics() {
        System.out.println("ROUND " + roundNumber + " -------------");
        /*String defence;
        if (bossDefence == null) {
            defence = "No defence";
        } else {
            defence = bossDefence;
        }*/
        System.out.println("Boss health: " + bossHealth + " damage: "
                + bossDamage + " defence: " + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + " damage: "
                    + heroesDamage[i]);
        }
    }
}