/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class Queen extends Bee{
    @Override
    void damage(int x) {
        if(isDead()){
            return;
        }else
        {
            setHealth(health-x);
            if(health <20){
                setDead(true);
            }
        }
    }

    @Override
    public void showStatus() {
        String dead = isDead()? "dead":"alive";       
        System.out.printf("%-10s %-10.2f %-10s\n","Queen",health,dead);
    }
    
}
