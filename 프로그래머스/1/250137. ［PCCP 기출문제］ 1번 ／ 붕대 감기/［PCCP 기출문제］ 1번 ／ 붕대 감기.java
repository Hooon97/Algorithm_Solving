class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int maxHealth = health;
        int healTime = bandage[0];
        int sequenceHealTime = 0;
        int heal = bandage[1];
        int bonusHeal = bandage[2];
        
        int attackIdx = 0;
        while(attackIdx < attacks.length){
            time++;
            if(attacks[attackIdx][0] == time){
                health -= attacks[attackIdx][1];
                sequenceHealTime = 0;
                attackIdx++;
                if(health <= 0) return -1;
                continue;
            }
            sequenceHealTime++;
            health += heal;
            if(healTime == sequenceHealTime){
                sequenceHealTime = 0;
                health += bonusHeal;
            }
            if(health > maxHealth) health = maxHealth;
        }

        return health;
    }
}